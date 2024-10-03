[forrige](02-dictionary.md) &bullet; [oversikt](../README.md) &bullet; [neste](04-SimpleShell.md)

## Bli kjent med eksisterende kildekode

**TODO:**
- Kjør *main*-metoden i `Main` ([link](../src/main/java/no/uib/inf101/terminal/Main.java)) og se at du får opp et vindu du kan skrive i. Sjekk at det virker å skrive, og at du får en ny linje når du trykker enter.
- I *main*-metoden, bytt ut *DummyShell* med *EchoShell*. Sjekk at når du nå kjører programmet, vil du få et ekko av hver linje du skriver.

Dette du nå har bevitnet kalles *polymorfisme*, og innebærer at to objekter med forskjellig *klasse* begge har samme *type*, og at det finnes kode som fungerer bra med objekter fra begge klassene selv om metodene deres er implementert ulikt. Dette gir oss en høy grad av *modularitet*, siden vi enkelt kan bytte ut objekter i én klasse med objekter i en annen klasse med en litt annen oppførsel.

**TODO:**
- Besvar spørsmålene i `TextAnswers` ([link](../src/main/java/no/uib/inf101/terminal/TextAnswers.java)).


✅ Du er klar til å gå videre når testene i `TestTextAnswers` ([link](../src/test/java/no/uib/inf101/terminal/TestTextAnswers.java)) passerer
