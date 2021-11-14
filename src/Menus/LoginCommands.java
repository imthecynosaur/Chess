package Menus;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum LoginCommands {
    REGISTER("(?i)register"),
    LOGIN("(?i)login"),
    REMOVE("(?i)remove"),
    LIST_USERS("(?i)list\\s+users"),
    HELP("(?i)help"),
    EXIT("(?i)exit");

    private final Pattern commandPattern;

    LoginCommands(String commandPatternString) {
        this.commandPattern = Pattern.compile(commandPatternString);
    }

    public Matcher getStringMatcher(String input){
        return this.commandPattern.matcher(input);
    }
}
