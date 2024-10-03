[forrige](./01-textgrid_vs_colorgrid.md) &bullet; [oversikt](../README.md#steg-for-steg) &bullet; [neste](./03-gridcellcollection.md)

## Oppgave 2: Gjør CellColor generisk

For å gjøre ``ColorGrid`` generisk begynner vi med å endre på byggeklossene til ``ColorGrid``. Dette gjelder ``CellColor``, ``CellColorCollection`` og ``IColorGrid``. Vi starter med ``CellColor``, som vi endrer til: ``GridCell``.

**TODO:**
* Endre navn på ``CellColor`` til ``GridCell`` . Dette må gjøres inni filen og på filnavnet. Det er mest praktisk å bruke refaktureringen som din IDE sannsynligvis kan gjøre for deg. (I VSCode kan du gjøre dette ved å høyreklikke på filnavnet og trykke "rename").

* Gjør GridCell generisk ved å legge inn ``<T>`` etter `GridCell` i record-deklarasjonen og bytt ut typen til den andre parameteren i konstruktøren med `T`. Se under for hvordan den bør se ut.

>:question: **Deklarasjon**. Med dette mener vi den delen av en struktur i Java (en metode, klasse, grensenitt, record osv.) som inneholder nøkkelord som public/private, returtype (for metoder), implementerte eller utvidede grensesnitt (for klasser og grensesnitt) og annet.

* Gi argumentet med den generiske typen `T` det mer passende navnet "elem" (kort for "element"). Oppdater dokumentasjonen slik at den passer.

>:question: **T**. Her bruker vi bokstaven T som et alias for en vilkårlig type. Du kan bruke andre bokstaver i stedet for T, men det er vanlig å bruke T for en generisk type som dette.

Recorden `GridCell` burde nå se slik ut (hvor vi har valgt "elem" som navn på det generiske argumentet):
```Java
public record GridCell<T>(CellPosition pos, T elem) {}
```


## Test
* Sett inn denne testen i den tomme testklassen `GridCellTest.java` som ligger i testmappen under pakken `no.uib.inf101.datastructure`. Hvis alt er gjort riktig skal testen passere og heller ikke gi røde streker eller kompilasjonsfeil:

```Java
@Test
public void sanityTest() {
    GridCell<Integer> integerCell = new GridCell<Integer>(new CellPosition(5, 2), 40);
    assertEquals(40, integerCell.elem(), "element is null or not equal");
    CellPosition expectedPosition = new CellPosition(5, 2);
    assertEquals(expectedPosition, integerCell.pos(), "position is null or not equal");
}
```

✅ Denne oppgaven er ferdig når GridCell er generisk og den innlimte testen `GridCellTest::sanityTest()` passerer.