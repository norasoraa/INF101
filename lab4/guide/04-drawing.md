[forrige](03-create_color_grid.md) &bullet; [oversikt](../README.md) &bullet; [neste](05-create_drawable_grid.md)

## Tegning

Ha kursnotatene om [grafikk](https://inf101v23.stromme.me/notat/grafikk/) i bakhodet når du gjør denne oppgaven.

**TODO: I `GridView`:**
* La klassen utvide `JPanel`
* La konstruktøren til `GridView` sette standard størrelse på lerretet til 400x300 piksler
* Overskriv metoden `public void paintComponent(Graphics g)`. Begynn med å kalle på super-metoden og opprett en Graphics2D -variabel fra g, slik som vist i kursnotatene om grafikk.
* Velg din favoritt-figur fra kursnotatene og tegn den i paintComponent (midlertidig, fjern den igjen når vi senere skal tegne rutenettet )

**TODO: I `Main`:**
* Opprett et `GridView` -objekt
* Opprett et `JFrame` -objekt
* Kall `setContentPane` -metoden på JFrame-objektet med GridView-objektet som argument
* Kall `setTitle`, `setDefaultCloseOperation`, `pack` og `setVisible` på JFrame-objektet etter mønster fra kursnotatene om grafikk.

✅ Du er klar til å gå videre hvis du ser tegningen din i et vindu når du kjører `Main`.
