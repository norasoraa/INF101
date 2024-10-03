[forrige](./06-view.md) &bullet; [oversikt](../README.md#steg-for-steg) &bullet; neste

## Oppgave 7: Rydd i filer og kjør programmet

Vi har nå gjort alt som er nødvendig i strukturene våre for at programmet skal avhenge kun av det generiske gridet og ikke de enkelte ``ColorGrid`` og ``TextGrid`` klassene. Dermed kan du endelig slette de overflødige filene som tilhører ``TextGrid``! For å få programmet til å kjøre igjen må du også endre noe smått i ``Main.java``.

**TODO:**
* Gjør slik at variablene `colorGrid` og `textGrid` bruker generics.
* Slett ``CellText``, ``CellTextCollection``, ``ITextGrid`` og ``TextGrid``. 
* Fjern importen til ``TextGrid``


✅ Denne oppgaven er fullført når du kan kjøre main og (hver for seg) vise både et grid av farger og et grid med tekst.
## ✅ Denne laben er fullført når du får vise begge gridene med generics i main, og de innlimte testene i `GridCellTest.java` og `GridTest.java` passerer.