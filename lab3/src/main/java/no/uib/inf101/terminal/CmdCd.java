package no.uib.inf101.terminal;

public class CmdCd implements Command {

    Context context;

    @Override
    public String run(String[] args) {
        if (args.length == 0) {
            this.context.goToHome();
            return "";
        } else if (args.length > 1) {
            return "cd: too many arguments";
        }
        String path = args[0];
        if (this.context.goToPath(path)) {
            return "";
        } else {
            return "cd: no such file or directory: " + path;
        }
    }

    @Override
    public String getName() {
        return "cd";
    }

    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public String getManual() {
        return "Gir du kommandoen cd foo, endrer cwd til å bli mappen «foo».\n"+
        "Mappen «foo» må ligge i cwd. Gir du kommandoen cd .. , endrer cwd til å bli mappen over seg i mappehierarkiet.\n"+
        "Gir du kommandoen cd, endrer cwd til å bli «home» -mappen. Det er ikke så viktig hvilken mappe dette er,\n"+
        "men det er den samme hver gang (hvis man ikke manipulerer hvilken mappe dette er (slik vi må gjøre i testene),\n"+
        "vil dette være cwd for programmet som startet java-prosessen).";
    }
}
