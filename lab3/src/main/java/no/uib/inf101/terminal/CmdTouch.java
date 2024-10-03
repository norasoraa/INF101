package no.uib.inf101.terminal;

import java.io.File;
import java.io.IOException;

public class CmdTouch implements Command {

    @Override
    public String run(String[] args) {
        if (args.length == 0) {
            return "Please provide a file name";
        }
        String filename = args[0];
        File file = new File(filename);
        file.getParentFile().mkdirs();
        try {
            if (!file.createNewFile()) {
                return "touch: the file already exists: " + filename;
            }
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public String getName() {
        return "touch";
    }

    @Override
    public String getManual() {
        return "'touch filename' oppretter en ny tom fil med det gitte navnet (hvis den ikke finnes fra før)";
    }
    
}
