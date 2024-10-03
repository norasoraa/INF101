[forrige](06-install_commands_SimpleShell.md) &bullet; [oversikt](../README.md) &bullet; [neste](08-voluntary_improvements.md)

## Anbefalte forbedringer

Forbedringene i dette avsnittet er frivillige med tanke på å bestå laben, men er sterkt anbefalt å prøve seg på.

### `exit`: en annen enkel kommando

**TODO:**
- Opprett en ny klasse `CmdExit` etter samme mønster som `CmdEcho`, som også implementerer *Command* -grensesnittet.
- I run-metoden, gjør et kall til `System.exit(0);`. Denne metoden kan returnere for eksempel null.
- Installer kommandoen i `Main::main` på samme måte som tidligere. 
- Sjekk at det fungerer å lukke programmet ved å gi kommandoen `exit`.

### `pwd`, `cd`, og `ls`: kommandoer som trenger kontekst

Vi skal opprette egne klasser for hver av kommandoene `pwd`, `cd` og `ls`. Dette er SimpleShell sine tre kjerne-kommandoer som alltid må være tilgengelig, og som allerede var implementert; men vi ønsker å benytte oss av samme struktur som de andre kommandoene (jo færre ting som håndteres på en spesiell måte, jo bedre).

Det som skiller disse kommandoene fra echo og exit, er at de har behov for å vite *konteksten* shellet kjører i. Vi løser dette ved at SimpleShell skal gi kommandoene som ønsker det tilgang til Context-objektet når de blir installert.

**TODO: I `Command`, legg til en metode-signatur for å sette kontekst:**
```java
default void setContext(Context context) { /* do nothing */ };
```
Denne linjen oppretter en metode i grensesnittet med en *standard* (default) implementasjon (som altså her er å ikke gjøre noen ting som helst dersom metoden blir kalt). Dette innebærer imidlertid at vi nå kan kalle på `setContext` dersom vi har å gjøre med et `Command`-objekt.

**TODO: I `SimpleShell::installCommand`, gjør et kall til *setContext*:**

```java
command.setContext(this.context);
```

Vi er nå klare til å opprette klassene `CmdLs`, `CmdPwd` og `CmdCd` som alle implementerer *Command* -grensesnittet.
**TODO:**
- La disse klassene ha en instansvariabel for kontekst, og la dem overskrive `setContext` -metoden slik at denne instansvariabelen bli initiert med en verdi når metoden kalles.
- Kopier funksjonaliteten fra de tilsvarende metodene i SimpleShell inn i run-metodene i de nye klassene.
- Fjern metodene fra SimpleShell (inkludert sekvensen med else-if i executeCommand), og installer i stedet kommandoene i *konstruktøren til SimpleShell*. Dette gjøres på samme måte som vi gjorde for echo -kommandoen i Main, men objektet vi kaller installCommand på heter *this* i stedet for *shell*: for eksempel `this.installCommand(new CmdLs())`.
- Sjekk at testene fremdeles passerer og at de fremdeles virker i terminal-gui'en


### `man`: kommando for å lese manualen

* `man command` gir oss manualen til kommandoen `command`.

**TODO:**
- La `Command` -grensesnittet ha en metode `String getManual()` som returnerer instruksjoner for hvordan kommandoen brukes. Du må nå oppdatere alle klassene som implementerer Command slik at de implementerer metoden og returnerer en hensiktsmessig hjelpetekst.
- La `Command` -grensesnittet ha en default-metode `default void setCommandContext(Map<String, Command>)` med en standard-implementasjon som ikke gjør noen ting.
- I `SimpleShell::installCommand`, gjør et kall til setCommandContext med this.allCommands som argument.
- I `CmdMan`, la det være en instansvariabel av typen `Map<String, Command>`, og initer denne i `setCommandContext`.
- I `run` -metoden til `CmdMan`, hent ut riktig Command-objekt fra nevnte instansvariabel og returner resultatet av getManual() kalt på dette objektet.

### Trykk backspace for å fjerne bakerste bokstav i kommandoen

Undersøk metoden `SimpleShell::keyPressed` og se hvordan ulike taster håndteres. Legg til funskjonalitet slik at når backspace trykkes fjernes bakerste bokstav i kommandoen.

> Hint: sjekk hvilken verdi som kommer når du trykker på backspace ved å legge til
`System.out.println("Keycode pressed: '" + ((int) key) + "'");` i begynnelsen av keyPressed-metoden. Start programmet, trykk backspace og se hva som skrives ut. Dette vil være et tall, siden vi *castet* key-variabelen til en `int`.
>
> Når du senere ønsker å legge til en betingelse i programflyten, kan du også sammenligne castet verdi, slik: `((int) key) == /* tallet her */`

### Starte java-programmer fra SimpleShell

Det neste steget for å få et fullt funksjonelt shell er muligheten til å starte og avslutte andre programmer, kontrollere hva disse programmene får som input, og la dem gi oss output i sanntid. Hva som skal til for å klare alle disse oppgavene går utenfor pensum i INF101, og er ikke støttet av Terminal-klassen vår.

Likevel kan vi gi en liten smakebit, nemlig hvordan vi kan kjøre andre *java* -programmer med den begrensning at de ikke er basert på interaktiv input i konsollen.

#### Hello World

**TODO: Opprett en klasse `HelloWorld` som skriver ut `"Hello World!"` til skjermen**. Denne skal du kjenne igjen fra tidligere:

```java
package no.uib.inf101.terminal;

public class HelloWorld {
  public static void main(String[] args) {
    System.out.println("Hello World!");
  }
}
```

**TODO: Opprett en klasse `CmdJavaProgram` og kopier inn koden under** (avhengig av hvor mange metoder du har i `Command` -grensesnittet kan det være du må legge til en metode). Du trenger ikke å forstå alt koden gjør.

```java
package no.uib.inf101.terminal;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

public class CmdJavaProgram implements Command {

  private final Class<?> mainClass;
  private final String commandName;

  /**
   * Create a command from a Java program. Programs that read from
   * standard input are not supported, but printing to standard
   * output (i.e. using System.out to print) is ok.
   *
   * @param commandName  The name of the command
   * @param mainClass  The class containing a main(String[]) method
   */
  public CmdJavaProgram(String commandName, Class<?> mainClass) {
    this.mainClass = mainClass;
    this.commandName = commandName;
  }
  
  @Override
  public String getName() {
    return this.commandName;
  }

  @Override
  public String run(String[] args) {
    // Remember original System.out and System.err
    final PrintStream orgOut = System.out;
    final PrintStream orgErr = System.err;

    try {
      // Prepare for capturing the output of the program
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      PrintStream newOut = new PrintStream(out, true, StandardCharsets.UTF_8);
      System.setOut(newOut);
      System.setErr(newOut);

      // Invoke  main method of the class for which this command was created
      Method main = this.mainClass.getMethod("main", String[].class);
      main.invoke(null, new Object[] {args});

      // Convert the captured output to a string and return it
      return out.toString(StandardCharsets.UTF_8);
    } catch (NoSuchMethodException e) {
      return "No main method found in class " + this.mainClass.getName();
    } catch (Exception e) {
      return e.toString();
    } finally {
      // Restore the original System.out and System.err
      System.setOut(orgOut);
      System.setErr(orgErr);
    }
  }
}
```

Så gjenstår det å installere HelloWorld som en kommando `"hello"`.

**TODO: I `Main::main`, installer HelloWorld som en kommando:**

```java
shell.installCommand(new CmdJavaProgram("hello", HelloWorld.class));
```

✅ Sjekk at du kan kjøre programmet, og at kommandoen `"hello"` skriver ut `Hello World!` i GUI'en.

PS: Prøv også:

```java
shell.installCommand(new CmdJavaProgram("new", Main.class));
```

Hva er det som skjer?
