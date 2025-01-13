package org.yupi.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

public class Login implements Callable<Integer> {
    @Option(names = {"-u", "--user"}, description = "User name")
    String user;

    @Option(names = {"-p", "--password"}, description = "Passphrase",
            interactive = true, prompt = "请输入密码：",arity = "0..1")
    String password;

    @Option(names = {"-cp", "--check password"}, description = "Check Passphrase",
            interactive = true, prompt = "请重复输入密码：", arity = "0..1")
    String checkPassword;

    public Integer call() throws Exception {
        System.out.println("password = " + password);
        System.out.println("checkPassword = " + checkPassword);
        return 0;
    }

    public static void main(String[] args) {
        new CommandLine(new Login()).execute("-u", "user123", "-p", "123","-cp");
    }
}
