For å fullføre laben, ber vi deg om å svare på følgende spørsmål. Svar på spørsmålene ved å fylle ut denne filen.

## Hva har du lært om Java og objekt-orientert programmering under arbeidet med denne oppgaven? Beskriv hvilke deloppgave(r) du jobbet med i læringsøyeblikket.

Jeg har lært mye om hvordan arv fungerer under arbeidet med denne oppgaven. I steget hvor vi skulle tegne brettet så hadde vi to metoder i TetrisModel, getDimension() og getTilesOnBoard(). I begge disse metodene kunne vi returnere board som er av typen TetrisBoard, selv om typene som skulle returneres var GridDimension og Iterable<GridCell<Character>>. Dette er fordi TetrisBoard utvider Grid<Character>, Grid<E> implementerer IGrid<E>, og tilslutt utvider IGrid<E> både GridDimension og Iterable<GridCell<Character>>. Dette gjør at brettet av typen TetrisBoard også er av typen GridDimension og Iterable<GridCell<Character>>.

Jeg har også lært mye om å bruke strengeste tilgangsmodifikatoren til variabler og metoder. Og forskjellen på å bruke public metoder, private metoder, static metoder eller pakke-privat klassemetoder. I Tetromino lagde vi en metode newTetromino som er en pakke-privat klassemetode, mens de andre metodene i klassen er public metoder som vi bruker i modellen for å endre på utseende av tetromino brikken.

Jeg har også lært mye om tester. Både hvordan man skriver tester og hvilke deler av koden som er viktig å teste.

## Hva er det neste du ønsker å lære om Java og programmering?

Jeg ønsker å lære mer om Eventbuss og Observer, og hvordan man bruker disse i programmer. 

## Hvilke grep gjør vi for å øke modulariteten i koden? Gi noen eksempeler.

Modulær kode handler om å dele opp koden i byggeklosser. Å bruke model-view-controller prinsippet for å dele opp programmet er en måte som hjelper for å oppnå modulær kode. Hver av de tre komponentene har ulike egenskaper og ansvar. Modellen har ansvaret for å representere spillet og logikken som ligger i det. Visningen har ansvaret for å tegne modellen. Kontrolleren har ansvaret for å endre modellen basert på blant annet input fra brukeren. Å dele det opp slik gjør det mulig å endre og legge til kode i hver komponent uavhengig av hverandre.

Andre grep vi gjør er å dele koden opp i klasser som hver har en bestemt oppgave. Vi har for eksempel en klasse Tetromino som er ansvarlig for å representere en brikke, en klasse CellPositionToPixelConverter som har bare en oppgave med å convertere posisjoner i rutenettet med rad og kolonne nummer til piksler, og en klasse DefaultColorTheme som representerer fargetemaet som blir brukt. I tillegg til klassen DefaultColorTheme har vi også et grensesnitt ColorTheme som gjør det enklere å bytte ut fargetemaet. Vi har en enum GameState som inneholder de ulile tilstandene spillet har. Det gjør det enkelt for oss å kunne legge til flere tilstander senere uten å endre noen andre deler av koden.

I hver klasse lager vi ulike metoder med bestemt funksjonalitet og hjelpemetoder der det er nødvendig. Vi har delt opp koden slik at hver metode bare har en oppgave. Dette gjør det enklere å debugge og teste koden del for del for å se at en metode eller klasse har den funksjonen den skal ha.

Bruken av grensesnitt hjelper også på å oppnå modularitet i koden. Slik som ViewableTetrisModel og ControllableTetrisModel. Bruken av slike interface gjør at de ulike delene av programmet kan samhandle med hverandre uten at det skal påvirke deler av koden hvis det ikke er meningen. For eksempel skal ikke visningen kunne uforvarende endre på modellen, og dette forhindrer vi ved å bruke ViewableTetrisModel til å representere modellen i TetrisView.

Grepene vi gjør for å øke modulariteten med å dele opp koden i byggeklosser, hjelper oss med å enklere kunne debugge og teste koden, det gjør det lettere å fokusere på små deler av koden om gangen og den er lettere å lese, og det vil være lettere å endre eller legge til ny funksjonlitet senere uten å endre andre deler av koden. I tillegg hjelper det oss å begrense avhengighetene mellom de ulike klassene så mye som mulig.