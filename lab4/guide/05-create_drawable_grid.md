[forrige](04-drawing.md) &bullet; [oversikt](../README.md) &bullet; [neste](06-bonus.md)

## Opprett rutenettet som skal tegnes

I `Main::main` skal vi nå opprette et rutenett, og gi det til `GridView`-konstruktøren som et argument ved opprettelse. Deretter skal vi endre GridView slik at den tegner dette rutenettet.

**TODO:**
* I `Main::main`, opprett et ColorGrid-objekt med 3 rader og 4 kolonner. Sett fargene i hjørnene til å være
  * Rød i hjørnet oppe til venstre (posisjon (0, 0))
  * Blå i hjørnet oppe til høyre (posisjon (0, 3))
  * Gul i hjørnet nede til venstre (posisjon (2, 0))
  * Grønn i hjørnet nede til høyre (posisjon (2, 3))
* I `GridView`, legg til en parameter av typen `IColorGrid` i konstruktøren, og legg også til en instansvariabel av samme type. Initialiser feltvariabelen med argumentet gitt til konstruktøren.

For å tegne rutenettet gjenstår det å endre på *paintComponent* -metoden. Vi skal benytte oss av tre hjelpemetoder for å tegne rutenettet. I *paintComponent* gjør vi et kall til

* `drawGrid`, som har som ansvar å tegne et fullstendig rutenett, inkludert alle rammer og ruter (alt innenfor det grå området i illustrasjonen). For å tegne selve rutene, kaller denne metoden på
* `drawCells`, som har som ansvar å tegne en samling av ruter. For hver rute regner denne metode ut hvor ruten skal være ved å kalle på hjelpemetoden
* `getBoundsForCell` som vet hvordan å regne ut posisjonen til én rute i rutenettet.

Det viser seg at det er den sistnevnte metoden som er mest komplisert. Vi kunne hatt `getBoundForCell` som en vanlig hjelpemetode, men siden dette er en relativt isolert operasjon som vi ønsker å kunne teste separat, oppretter vi en en klasse for denne hjelpemetoden: *CellPositionToPixelConverter*.

> Måten vi tenker på når vi skal utvikle et program er «top-down» -- man begynner med å dele opp oppgaven i store steg, og så drømmer vi opp hjelpemetoder vi trenger før disse hjelpemetodene faktisk eksisterer. Når vi faktisk koder, er det ofte lettest å gjøre det «bottom up», slik at vi kan teste hver enkelt byggeklosse/metode mens vi holder på. Dette for å si: hvilken rekkefølge du løser resten av oppgaven er opp til deg. Det kan være at det er lettere å hoppe litt frem og tilbake mellom de neste avsnittene.


## CellPositionToPixelConverter

Vi ønsker å opprette en hjelpemetode `getBoundsForCell` som oversetter koordinater i rutenettet til et rektangel med posisjon og størrelse beskrevet som piksler til bruk på et lerret. Det er naturlig at denne metoden
* har en parameter av typen `CellPosition` og 
* returnerer et `Rectangle2D` -objekt.

Men -- dette er ikke tilstrekkelig informasjon for å gjøre utregningen; vi trenger i tillegg å vite
* innefor hvilket område rutenettet befinner seg
* hvor mange rader og kolonner det er i rutenettet som helhet, og
* hvor stor avstanden mellom rutene skal være.

Disse siste delene med informasjon vil ikke endre seg særlig fra kall til kall, men er en del av *konteksten* metoden kjører i. Slik kontekst er best beskrevet som feltvariabler.

**TODO: I klassen `CellPositionToPixelConverter`:**

* Opprett instansvariabler:
  * En `Rectangle2D` -variabel `box` som beskriver innenfor hvilket område rutenettet skal tegnes
  * En `GridDimension` -variabel `gd` som beskriver størrelsen til rutenettet rutene vil være en del av
  * En `double` kalt `margin` som beskriver hvor stor avstanden skal være mellom rutene
* Opprett en konstruktør i klassen med tre parametre: en `Rectangle2D` -variabel, en `GridDimension` -variabel og en `double`. Initaliser feltvariablene med argumentene som mottas i konstruktøren.
* Opprett metoden `getBoundsForCell` med en parameter av typen `CellPosition` (i figur under navgitt `cp`) og returtype `Rectangle2D`.

Returverdien er et `Rectangle2D` -objekt. For å opprette dette objektet, må du regne ut fire verdier: x, y, bredde og høyde for den gitte ruten. Så kan du returnere et nytt `Rectangle2D.Double` -objekt med disse verdiene.

Illustrasjonen under visualiserer parameterne og resultatvariablene. Variabler i svart tekst er gitt som input eller er tilgjengelig som feltvariabler, mens variablene i rød kursiv tekst er de du skal regne ut og returnere.

![Illustrasjon av variabler som opptrer i getBoundsForCell](../img/getBoundsForCell.png)

**Hint:**
* Benytt `double` hvis du gjør regnestykker som involverer divisjon, da unngår du avrundingsfeil.
* Ikke bland horisontale og vertikale verdier. Horsiontale begreper: x, bredde, kolonne. Vertikale begreper: y, høyde, rad.
* Begynn med å regne ut *cellWidth* og *cellHeight*, og bruk verdiene du finner der for videre kalkulasjoner.

> Eksempel: anta at du får følgende parametre (som i illustrasjonen):
>  * `box.getX()` er 30 og `box.getY()` er 30
>  * `box.getWidth()` er 340 og `box.getHeight()` er 240
>  * `cp.col()` er 2 og `cp.row()` er 1
>  * `gd.cols()` er 4 og `gd.rows()` er 3
>  * `margin` er 30
>
> Vi begynner med å regne ut `cellWidth`. Siden vi har 4 kolonner totalt, vil det gå med 5*30=150 piksler til marginer, og vi får da 190 piksler igjen å fordele på de fire kolonnene. Vi får da at cellen skal ha bredde 47.5.
>
> For å finne verdien til `cellX` begynner vi på posisjonen `box.getX()` og går derfra videre mot høyre ved å plusse på margin + rutebredde + margin + rutebredde + margin. Verdien blir da 30+30+47.5+30+47.5+30 = 215.
>
> Tilsvarende finner vi at `cellHeight` blir 40 og `cellY` blir 130.


✅ Du er klar til å gå videre når testene i `TestCellPositionToPixelConverter` passerer.

## drawGrid

Denne metoden i `GridView` skal ha et `Graphics2D` -objekt som parameter, og ikke ha noen returverdi. Planen er å først tegne en stor grå firkant, og så tegne selve rutene «oppå».

**TODO:**
- Opprett et Rectangle2D -objekt med en fast 30 pikslers avstand til kanten på vinduet (se avsnitt om fast avstand til kantene på lerretet i kursnotater om [grafikk](https://inf101v23.stromme.me/notat/grafikk/#fast-avstand-til-kantene-p%C3%A5-lerretet))
  *  Det kan være lurt å lagre tallet som en konstant med et beskrivende navn (altså opprett en static final feltvariabel `private static final double OUTERMARGIN = 30;` og så bruke `OUTERMARGIN` i stedet for 30 når du kommer tilbake her)
- Fyll rektangelet med gråfarge på lerretet.
  * Det kan være lurt å lagre fargen som en konstant med et beskrivende navn (altså opprett en static final feltvariabel `private static final Color MARGINCOLOR = Color.LIGHT_GRAY;` og så bruke `MARGINCOLOR` i stedet for Color.LIGHT_GRAY når du kommer tilbake her)
- Opprett et `CellPositionToPixelConverter` -objekt.
  * Hvilket objekt med typen GridDimension skal du bruke som argument ved opprettelsen? Har du et slik objekt liggende et sted allerede?
  * Marginen skal være et fast tall; i eksempelillustrasjonen er tallet 30 blitt brukt. Det kan være lurt å lagre tallet som en konstant med et beskrivende navn.
- Gjør et kall til en hjelpemetoden `drawCells` beskrevet under

PS: Siden metoden benytter instansmetoder kan metoden *ikke* være static. Siden metoden ikke skal benyttes av noen utenfor `GridView` -klassen, bør metoden være *private*.

## drawCells

Denne metoden i `GridView` er uten returverdi, men skal ha tre parametre:
* et `Graphics2D` -objekt, lerretet rutene skal tegnes på
* et `CellColorCollection` -objekt, rutene som skal tegnes
* et `CellPositionToPixelConverter` -objekt som kan regne ut rutene sin posisjon

La metoden iterere gjennom rutene i CellColorCollection -objektet, og tegne hver av dem på lerretet. Dersom fargen er null, bruk `Color.DARK_GRAY` i stedet.

PS: siden drawCells ikke er avhengig av instansvariabler, bør metoden være *static*. Siden den ikke benyttes utenfor `GridCell` -klassen bør metoden være *private*.

✅ Du er ferdig med lab'en når testene i `TestGridView` passerer, og du kan kjøre Main-metoden og ser samme bilde som vist i illustrasjonen nå programmet kjører. Det skal fungere å endre størrelse på vinduet, og rutenettet skal strekke seg for å fylle hele lerretet med en fast avstand til kanten.

