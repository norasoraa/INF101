[forrige](./05-grid.md) &bullet; [oversikt](../README.md#steg-for-steg) &bullet; [neste](./07-main.md)

## Oppgave 6: Fiks ColorGridView og TextGridView

Siden vi har endret så mye på ColorGrid funker ikke den i ``ColorGridView`` slik som før. Men det skal ikke mye til for å få vise rutene av farger igjen! I tillegg til å gjøre dette skal vi også gjøre slik at ``TextGridView`` bruker det generiske gridet.

Vi skulle gjerne ha gjort hele viewet generisk også, slik at vi ikke måtte ha 2 forskjellige view klasser. Det eneste problemet er ``drawCells()`` metoden, hvor ruten skal tegnes forskjellig avhengig av innholdet. Det fins strukturelle endringer som kan forbedre dette, men vi går ikke over de her.

<br>

### Del A: ``ColorGridView``:
**TODO:** 

* Bytt ut typen til feltvariabelen `grid` og parameteret til konstruktøren slik at de bruker den generiske typen. Men i stedet for nå å skrive `T` i krokodilletegnene, setter vi inn den typen vi ønsker at gridet skal holde. I dette viewet er det `Color`. Som eksempel skal feltvariabelen grid nå se slik ut:

```Java
private IGrid<Color> grid;
```

* I `drawCells()`: Bytt ut CellColor og CellColorCollection med tilsvarende generiske typer som vi har laget. Endre metoden som brukes på ``cell`` objektet slik at det henter ut fargen fra objektet.

<br>

### Del B: ``TextGridView``
**TODO:**

* Gjør samme endringene som du gjorde i ``ColorGridView``, men for ``TextGridView``.

<br>

✅ Denne oppgaven er fullført når både ColorGridView og TextGridView bruker generiske grids og du ikke har kompileringsfeil noen andre plasser en ``Main.java``.