package no.uib.inf101.terminal;

import java.util.Map;

public interface Command {
  String run(String[] args);
  String getName();
  String getManual();
  default void setCommandContext(Map<String, Command> map) { /* do nothing */};
  default void setContext(Context context) { /* do nothing */ };
}
