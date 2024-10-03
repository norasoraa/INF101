[forrige](03-source_code.md) &bullet; [oversikt](../README.md) &bullet; [neste](05-interface_for_commands.md)

## Kjøre SimpleShell

I resten av oppgaven skal vi modifisere klassen [SimpleShell](../src/main/java/no/uib/inf101/terminal/SimpleShell.java) og senere opprette noen andre klasser og grensesnitt som vi skal bruke for å forbedre SimpleShell.

**TODO: Kjør testene i `TestSimpleShellStarter` ([link](../src/test/java/no/uib/inf101/terminal/TestSimpleShellStarter.java)) og se at de allerede passerer.**

> **Målet med laben.** Før vi gjør noen endringer i det hele tatt, støtter SimpleShell tre kommandoer: pwd, ls og cd. I løpet av laben skal vi oppdatere SimpleShell slik at
> * det virker sammen med GUI'en vår «Terminal», og
> * shellet virker med ubegrenset mange kommandoer.
> 
> Når laben er gjennomført skal vi kunne installere så mange kommandoer vi vil i SimpleShell uten at vi trenger å endre ytterligere på kildekoden i SimpleShell-klassen utover det vi gjorde i løpet av denne lab'en.

### Vis SimpleShell gjennom GUI
Vi ønsker at det grafiske brukergrensesnittet vårt [Terminal](../src/main/java/no/uib/inf101/terminal/Terminal.java) skal virke sammen med SimpleShell. Konsturktøren til Terminal-klassen aksepterer alle shell og objekter som implementerer *CommandLineInterface*.

**TODO:**
- La `SimpleShell` implementere grensesnittet `CommandLineInterface`.
- Opprett de metodene som må implementeres for å oppfylle kontrakten *CommandLineInterface* beskriver. Du kan enten
  - gi nytt navn til metodene *aKeyIsPressed* og *whatTheScreenLooksLike* slik at de stemmer overens med metodenavnene som er angitt i CommandLineInterface. Når du endrer navnet, bruk din IDE sin «refactor» -funksjonalitet: høyreklikk på metodenavnet og velg *rename symbol* (VS Code) eller *refactor -> rename* (Eclipse/Intellij) eller tilsvarende. Hvis du glemmer dette, må du endre navnet manuelt i alle testene i TestSimpleShellStarter som bruker disse metodenavnene. Alternativt kan du:
  - opprette metodene som kreves av CommandLineInterface og la dem enkelt og greit kalle på *aKeyIsPressed* og *whatTheScreenLooksLike*.
- Husk i *SimpleShell* å bruke `@Override` foran de metodene som opprinnelig er definert i et grensesnitt.
- I `Main::main`-metoden: Bytt ut *EchoShell/DummyShell* med *SimpleShell*. Kjør programmet og se at kommandoene `pwd`, `cd` og `ls` virker. Prøv også noe helt annet og se at det kommer en feilmelding uten at java-programmet krasjer.

> Våre kommandoer er forenklede versjoner av de samme kommandoene i bash.
>  * `pwd` (print working directory) skriver ut hvilken mappe i filsystemet som er **cwd** (current working directory), altså den mappen man «er» i.
>  * `ls` skriver ut alle filene og mappene som befinner seg i cwd.
>  * `cd foo` endrer cwd til å bli mappen «foo». Mappen «foo» må ligge i cwd.
>  * `cd ..` endrer cwd til å bli mappen over seg i mappehierarkiet.
>  * `cd` endrer cwd til å bli «home» -mappen. Det er ikke så viktig hvilken mappe dette er, men det er den samme hver gang (hvis man ikke manipulerer hvilken mappe dette er (slik vi må gjøre i testene), vil dette være cwd for programmet som startet java-prosessen).

✅ Du er klar til å gå videre når testene i `TestSimpleShell` ([link](../src/test/java/no/uib/inf101/terminal/TestSimpleShell.java)) passerer.
