package no.uib.inf101.terminal;

import java.util.Map;

public class CmdMan implements Command {

    Map<String, Command> commandManuals;

    @Override
    public String run(String[] args) {
        if (args.length == 0) {
            return "Write a command to see the manual.";
        }
        String commandName = args[0];
        Command command = commandManuals.get(commandName);
        if (command == null) {
            return "Command not found: " + commandName;
        } 
        return command.getManual();
    }

    @Override
    public String getName() {
        return "man";
    }

    @Override
    public String getManual() {
        return "Skriver du man og gir deretter en komando, feks. man echo, vil den gi manualen til kommandoen du skrev inn.";
    }

    @Override
    public void setCommandContext(Map<String, Command> map) {
        this.commandManuals = map;
    }

    
}
