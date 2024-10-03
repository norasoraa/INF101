[forrige](04-SimpleShell.md) &bullet; [oversikt](../README.md) &bullet; [neste](06-install_commands_SimpleShell.md)

## Et grensesnitt for kommandoer

**TODO: Les over kildekoden for metoden `executeCommand` i `SimpleShell`.** Det er i denne metoden at vi bestemmer at ulike ting skal skje basert på hvilken kommando som blir gitt (se sekvensen med if og else if).

Vi ønsker å endre executeCommand slik at vi ikke bruker en lang sekvens med if og else if, men i stedet slår opp på `commandName` i et oppslagsverk og finner hvilken kommando som skal utføres der. Vi ønsker altså at koden skal se omtrent slik ut i stedet:

```java
Command command = this.allCommands.get(commandName);
if (command != null) {
  String result = command.run(args);
  return result;
} else {
  return "Command not found: \"" + commandName + "\"";
}
```
Som pseudokode kan koden over tolkes slik:
* Basert på verdien av `commandName`, finn ut hvilken kommando som skal utføres
* Dersom vi fant en gyldig kommando, utfør den og returner resultatet.

Du trenger ikke å ender denne koden helt enda, men dette illustrer hvor vi er på vei. For å komme oss hit, mangler vi en del ting. For eksempel finnes det ikke en type som heter `Command`. La oss definere den nå:

### Opprette grensesnittet `Command`

**TODO: Opprett et nytt grensesnitt som heter `Command` i pakken *no.uib.inf101.terminal*.**
  * VS Code: høyreklikk på «terminal» der det står no/uib/inf101/terminal i filutforskeren. ![klikk her i VSCode](../img/vscode-terminalfolder.png) Velg så *new file* og skriv *Command.java*. I den nye filen kan du opprette grensesnittet, og skrive inn koden som vises under.
  * Eclipse: høyreklikk «no.uib.inf101.terminal» i prosjekt-navigatoren, og velg *new -> Interface*. I boksen som kommer opp, skriv *Command*. Koden som vises under skal nå ha blitt generert automatisk for deg.
  * Intellij: høyreklikk «no.uib.inf101.terminal» i prosjekt-navigatoren, og velg *new -> Java class*. I boksen som kommer opp, skriv *Command* og velg *Interface* i menyen under. Koden som vises under skal nå ha blitt generert automatisk for deg.

Filen skal se nå se slik ut:

```java
package no.uib.inf101.terminal;

public interface Command {
  
}
```

### Definere metoder i `Command`

Planen er at vi skal kunne kalle på  `run` på *Command* -objekter. Nærmere bestemt ønsker vi at følgende skal være mulig hvis *command* er en variabel som har typen *Command*:
```java
String[] args = new String[] { "foo", "bar" };
String result = command.run(args);
```
For at dette skal være lov, må grensesnittet *Command* definere en metodesignatur `String run(String[])`. La oss gjøre det nå. 

**TODO: Legg til følgende metodesignatur i `Command`:**

```java
String run(String[] args);
```

I tillegg trenger vi å vite hva navnet til kommandoen er.

**TODO: Legg til følgende metodesignatur i `Command`:**

```java
String getName();
```

### Vår første kommando: echo

Echo er en enkel kommando. Hvis man skriver kommandoen `echo foo bar`, så blir resultatet `foo bar `. Denne kommandoen vil du også finne i bash og lignende shell, og det eneste den gjør er å spytte tilbake argumentene den fikk som input.

**TODO:**
* Opprett en klasse `CmdEcho` i pakken *no.uib.inf101.terminal*
* La `CmdEcho` implementere grensesnittet `Command`
* La `CmdEcho` implementere metodene som er definert i *Command* -gresesnittet. Husk å annotere hver av dem med `@Override`.
* La `getName()` alltid returnere `"echo"`.
* La `run(String[])` returnere en streng hvor hvert av argumentene i String[] -arrayen er limt sammen med mellomrom. Gå gjennom args med en foreach-løkke, og legg til et mellomrom etter hver av strengene. For eksempel, hvis input er `new String[] {"foo", "bar"}`, skal returverdien være `"foo bar "` (legg merke til ekstra mellomrom etter *bar*).
* I filen `TestCmdEcho` ([link](../src/test/java/no/uib/inf101/terminal/TestCmdEcho.java)), fjern kommentarene slik at testene blir aktivert.

✅ Du kan gå videre når testene i `TestCmdEcho` er aktivert og passerer.
