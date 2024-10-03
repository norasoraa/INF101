package no.uib.inf101.terminal;

public class CmdEcho implements Command {

    @Override
    public String run(String[] args) {
        String result = "";
        for (String arg : args) {
            result += arg + " ";
        }
        return result;
    }

    @Override
    public String getName() {
        return "echo";
    }

    @Override
    public String getManual() {
        return "Gir du kommandoen echo, vil den gi tilbake de argumentene den fikk som input.";
    }

}
