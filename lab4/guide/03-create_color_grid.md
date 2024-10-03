[forrige](02-familiarize_with_code.md) &bullet; [oversikt](../README.md) &bullet; [neste](04-drawing.md)

## Opprett rutenett av farger

I denne oppgaven skal du lage klassen `ColorGrid` ([link](../src/main/java/no/uib/inf101/colorgrid/ColorGrid.java)). Den er nå helt tom.

<h2>I de følgende oppgavene vil du måtte tenke ut løsninger selv. Ikke alt vil stå 100% forklart.</h2>

**TODO:**
* La klassen implementere grensesnittet `IColorGrid`
* La klassen ha en konstruktør med to parametre: en int som beskriver antall rader, og en int som beskriver antall kolonner. Standard-verdien til en posisjon i rutenettet (før `set`-metoden har blitt kalt på gitt posisjon) skal være `null`.
* Fyll ut metodene du trenger i overenstemmelse med javadoc-kommentarene til `IColorGrid`.

Du kan leke deg litt i `Main::main` for å sjekke for deg selv at klassen fungerer som du forventer. For eksempel:

```java
// Opprett et rutenett med 3 rader og 4 kolonner
IColorGrid grid = new ColorGrid(3, 4);
System.out.println(grid.rows()); // forventer 3
System.out.println(grid.cols()); // forventer 4

// Sjekk at standard-verdien er null      
System.out.println(grid.get(new CellPosition(1, 2))); // forventer null

// Sjekk at vi kan endre verdien på en gitt posisjon        
grid.set(new CellPosition(1, 2), Color.RED);
System.out.println(grid.get(new CellPosition(1, 2))); // forventer rød
System.out.println(grid.get(new CellPosition(2, 1))); // forventer null
```
Husk å rydde opp etter deg i `Main::main` når du er ferdig!

✅ Du er klar til gå videre når alle testene i `TestColorGrid` ([link](../src/test/java/no/uib/inf101/colorgrid/TestColorGrid.java)) passerer.
