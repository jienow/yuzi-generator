package org.yupi.cli.command;

import cn.hutool.core.bean.BeanUtil;
import freemarker.template.TemplateException;
import lombok.Data;
import org.yupi.generator.MainGenerator;
import org.yupi.model.MainTemplateConfig;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.io.IOException;

@Command(
        name = "generate",
        mixinStandardHelpOptions = true
)
@Data
public class GenerateCommand implements Runnable {

    @CommandLine.Option(names = {"-l", "--loop"}, arity = "0..1", description = "是否循环：", interactive = true, echo = true)
    private boolean loop;
    @CommandLine.Option(names = {"-a", "--author"}, arity = "0..1", description = "作者是谁：", interactive = true, echo = true)
    private String author;
    @CommandLine.Option(names = {"-o", "--output"}, arity = "0..1", description = "输出文本是什么：", interactive = true, echo = true)
    private String outputText;

    @Override
    public void run() {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        BeanUtil.copyProperties(this, mainTemplateConfig);
        System.out.println("配置信息：" + mainTemplateConfig);
        try {
            MainGenerator.doGenerator(mainTemplateConfig);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
