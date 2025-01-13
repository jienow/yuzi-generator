package org.yupi;

import org.yupi.cli.CommandExecutor;

public class MainStart {
    public static void main(String[] args) {
//        args = new String[]{"generate", "-l", "-a", "-o"};
//        args = new String[]{"--help"};
//        args = new String[]{"config"};
        args = new String[]{"list"};
        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.doExecute(args);
    }
}
