[forrige](./03-gridcellcollection.md) &bullet; [oversikt](../README.md#steg-for-steg) &bullet; [neste](./05-grid.md)

## Oppgave 4: Gjør IColorGrid generisk

Her skal vi, som i oppgave 3, ta et grensesnitt og gjøre det generisk.

**TODO:**
* Endre navn på ``IColorGrid`` til ``IGrid``

* Gjør grensesnittet generisk ved å sette `<T>` etter `IGrid` i deklarasjonen til grensesnittet

* Sett samme `<T>` etter `GridCellCollection` for å vise at Grid'et skal inneholde samme type ``T`` som vi snakker om i GridCellCollection.

* Gjør slik at metodedeklarasjonene er generiske i stedet for å referere til ``Color``. Oppdater dokumentasjonen.

✅ Denne oppgaven er ferdig når du har gjort om ``IColorGrid`` til det generiske grensesnittet ``IGrid``. Testing gjøres i [neste oppgave](./05-grid.md).