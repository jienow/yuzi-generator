package org.yupi.maker.cli;

import org.yupi.maker.cli.command.ConfigCommand;
import org.yupi.maker.cli.command.GenerateCommand;
import org.yupi.maker.cli.command.ListCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(
        name = "yuzi",
        mixinStandardHelpOptions = true
)
public class CommandExecutor implements Runnable {

    public final CommandLine commandLine;

    {
        commandLine = new CommandLine(this)
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ListCommand())
                .addSubcommand(new ConfigCommand());

    }

    @Override
    public void run() {
        System.out.println("请输入具体命令，或者输入 --help 查看命令提示");
    }

    public Integer doExecute(String[] args) {
        return commandLine.execute(args);
    }
}
