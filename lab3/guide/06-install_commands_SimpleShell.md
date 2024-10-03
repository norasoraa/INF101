[forrige](05-interface_for_commands.md) &bullet; [oversikt](../README.md) &bullet; [neste](07-improvements.md)

## Installere kommandoer i SimpleShell

Vi skal nå installere kommandoer i SimpleShell. Til dette trenger vi å lagre forskjellige Command-objekter. Dette gjør vi i et oppslagsverk

**TODO: Opprett en instansvariabel `allCommands` i SimpleShell:**

```java
private final HashMap<String, Command> allCommands = new HashMap<>();
```
Koden over oppretter en variabel som
* heter `allCommands`, og
* har typen `HashMap<String, Command>`. Det betyr at typen er et oppslagsverk hvor nøklene er av typen `String`, og verdiene er av typen `Command`.

I tillegg opprettes det et nytt objekt i klassen `HashMap` som ved opprettelse er et tomt oppslagsverk uten noen nøkler eller verdier enda. Det neste vi skal gjøre er å gjøre det mulig å legge til kommandoer i oppslagsverket.

**TODO: Opprett en metode i SimpleShell med signatur `public void installCommand(Command command)`**. La metoden hente ut navnet fra Command -objektet og opprett et nytt nøkkel-verdi -par i *allCommands* med navnet som nøkkel og Command-objektet som verdi. For eksempel:

```java
this.allCommands.put(command.getName(), command);
```

**TODO: I `Main::main` -metoden, kall `installCommand` på SimpleShell -objektet med et nytt `CmdEcho` -objekt som argument**. Merk at du må endre typen til shell-variabelen slik at den har typen SimpleShell, ellers vil du ikke ha tilgang til installCommand -metoden.

```java
SimpleShell shell = new SimpleShell();
shell.installCommand(new CmdEcho());

Terminal gui = new Terminal(shell);
gui.run();
```


Vi har nå installert kommandoen *echo* i shellet vi bruker i Main-metoden. Det eneste som gjenstår før vi kan bruke echo-kommandoen er at `executeCommand` faktisk slår opp i oppslagsverket og kjører kommandoen.

**TODO: Modifiser `executeCommand` slik at den slår opp på kommandoen og kaller run dersom den fant en kommando med det gitte kommandonavnet**. Siden vi ikke har laget og installert kommandoer for pwd, cd og ls enda lar vi den gamle implementasjonen stå for disse kommandoene.
```java
Command command = this.allCommands.get(commandName);
if (command != null) {
  return command.run(args);
} else if (/* ... */) {
  // ...
} else {
  return "Command not found: \"" + commandName + "\"";
}
```

**TODO:**
- Kjør `Main` og sjekk at echo-kommandoen virker i praksis.
- Fjern kommenteringen fra `TestSimpleShellEcho` ([link](../src/test/java/no/uib/inf101/terminal/TestSimpleShellEcho.java)) slik at testen blir aktiv.



✅ Du er ferdig med den obligatoriske delen av laben når testen i `TestSimpleShellEcho` er aktivert og passerer (i tillegg til at testene i `TestCmdEcho`, `TestSimpleShell` og `TestTextAnswers` fremdeles passerer).
