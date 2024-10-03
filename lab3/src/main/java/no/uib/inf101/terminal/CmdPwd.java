package no.uib.inf101.terminal;

public class CmdPwd implements Command {

    Context context;

    @Override
    public String run(String[] args) {
        return this.context.getCwd().getAbsolutePath();
    }

    @Override
    public String getName() {
        return "pwd";
    }

    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public String getManual() {
        return ("Gir du kommandoen pwd, (print working directory) skriver den ut hvilken mappe i\n"+
            "filsystemet som er cwd (current working directory), altså den mappen man «er» i.");
    };
    
}
