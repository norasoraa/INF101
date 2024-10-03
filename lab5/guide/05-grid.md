[forrige](./04-igrid.md) &bullet; [oversikt](../README.md#steg-for-steg) &bullet; [neste](./06-view.md)

## Oppgave 5: Gjør ColorGrid generisk

Vi er endelig kommet fram til å gjøre `ColorGrid` generisk. Denne nye, generiske klassen `Grid` kommer til å være nyttig videre i INF101.

**TODO:**
* Endre navn på ``ColorGrid`` til ``Grid``.

* Gjør klassen generisk ved å sette en `<T>` bak klassenavnet ``Grid`` og grensesnittet klassen implementerer, ``IGrid``.

* Gå gjennom klassen og bytt alle referanser til ``Color`` og `CellColor` med generiske alternativer. Hva tenker du skal stå i stedet for disse?
(Hint finner du i testene)


## Test

Lim innholdet fra [denne filen](./test-05.md) inn i `GridTest.java` for å teste den nye ``Grid`` klassen. Pass på at hvis de ikke passerer kan det skyldes feil fra oppgave 3 eller 4 også, siden vi tester ``GridCellCollection``, ``IGrid`` og ``Grid`` samtidig.

✅ Denne oppgaven er ferdig når du har gjort ColorGrid om til den generiske ``Grid`` klassen, og de innlimte testene kjører og passerer. 