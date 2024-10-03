[forrige](07-improvements.md) &bullet; [oversikt](../README.md) &bullet; neste

## Flere frivillige forbedringer

Forbedringene under krever at du setter deg inn i `File` -klassen fra Java sitt standardbibliotek, og bruker `Context` -klassen som følger med dette prosjektet aktivt. Du kan lese litt om `File` i [kursnotatene](https://inf101v23.stromme.me/notat/inputoutput/#filer) eller slå opp i den [offisielle dokumentasjonen](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/File.html).

### Forbedret `ls`: `ls -l`, `ls -a`, `ls path/to/folder`

I bash har kommandoen `ls` flere muligheter enn det vi så langt har laget. For eksempel:
* elementene vises i sortert rekkefølge
* `ls -l` vil vise elementene med linjeskift `'\n'` mellom seg i stedet for mellomrom `' '`
* `ls -a` vil vise skjulte filer, mens vanlig `ls` kun viser filer som ikke er skjulte.
* `ls -la` er en kombinasjon av de to over
* `ls path/to/folder` vil vise filene i mappen `cwd/path/to/folder`.

Det kan være en fin øvelse å gjenskape dette for vår `ls` -kommando.

### Flere kommandoer som trenger kontekst: touch, mkdir, cat, rm, mv, cp

* `touch filename` oppretter en ny tom fil med det gitte navnet (hvis den ikke finnes fra før)
* `mkdir dirname` oppretter en ny mappe med det gitte navnet (hvis den ikke finnes fra før)
* `cat filename` returnerer tekst-innholdet i den gitte filen som en streng
* `rm filname` sletter en fil eller en tom mappe (forsiktig når du tester med denne!)
* `rm -r foldername` sletter en mappe og alt innholdet i den (veldig forsiktig når du tester med denne!)
* `mv source target` endrer navn på filen eller mappen *source* til filnavnet/mappenavnet *target*. Dette kan innebære flytting hvis target er en sti til en annen mappe. Dersom *target* er en mappe som finnes fra før, flyttes *source* -filen/mappen til *target* -mappen og beholder sitt opprinnelige navn.
* `cp source target` det samme som mv, men lager en kopi i stedet for å flytte.

### `fgrep`: søking i filer

*Grep* og lillebroren *fgrep* er på mange måter *cat* med et søkefilter inkludert. Den skriver kun ut de linjene som har innhold som matcher søkeordet. Standard bruk:

`fgrep searchword filename`

Vi anbefaler alle å bli kjent med hvordan grep/fgrep virker i bash. De ambisiøse kan også implementere det de klarer av fgrep til bruk i vårt eget SimpleShell:

* `fgrep searchword filename -n` viser linjenummer
* `fgrep searchword filename -i` ignorerer case, dvs søkeordet `abc` vil få treff på `aBC`
* `fgrep searchword filename -v` skriver ut alle linjene som *ikke* matcher søkeordet
* `fgrep searchword filename -c` skriver ut hvor mange linjer som matchet søkeordet
* `fgrep searchword *` kjører grep på alle filer i current working directory. Hvis kombinert med `-n` viser utskriften navnet på filen ut først, og så linjenummer i den filen.
* `fgrep searchword * -l` skriver kun ut navnet på filene med innhold som matcher, uten å skrive ut selve treffene
* `fgrep searchword * -L` skriver kun ut navnet på filene *uten* innhold som matcher
* `fgrep searchword foldername -r` kjører grep på alle filer i mappen *og* på alle filer i alle undermapper i uendelig dypde.

Flagg (delen av kommandoene som begynner med `-`) kan ofte kombineres, for eksempel vil `-ni` både vise linjenummer og ignorere case. Du trenger ikke håndtere søkeord som inneholder mellomrom i første omgang, det blir eventuelt en superbonusoppgave.

Prøv deg frem og sammenlign med hva som skjer i bash. Les mer om grep i introduksjonen til [ryanstutorials](https://ryanstutorials.net/linuxtutorial/grep.php), [opensourceforu](https://www.opensourceforu.com/2012/06/beginners-guide-gnu-grep-basics/) eller [danielmiessler](https://danielmiessler.com/study/grep/).
