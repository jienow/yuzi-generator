package org.yupi.generator;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.yupi.model.MainTemplateConfig;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DynamicGenerator {
    public static void main(String[] args) throws IOException, TemplateException {
        /**
         * 加载模板
         */
        // configuration是Freemarker的类
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
        // 指定路径
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");
        // 创建模板对象，加载指定模板
        Template template = configuration.getTemplate("MainTemplate.java.ftl");

        /**
         * 创建数据模型
         */
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setAuthor("yupi");
        mainTemplateConfig.setOutputText("求和结果");

        /**
         * 生成
         */
        FileWriter fileWriter = new FileWriter("MainTemplate.java");
        template.process(mainTemplateConfig, fileWriter);

        fileWriter.close();

    }

    /**
     *
     */
    public static void doGenerate(String inputPath, String outputPath,Object model) throws IOException, TemplateException {
        // configuration是Freemarker的类
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        // 指定路径
        configuration.setDirectoryForTemplateLoading(
                new File(inputPath).getParentFile());

        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");
        // 创建模板对象，加载指定模板

        Template templateName = configuration.getTemplate(
                new File(inputPath).getName());

        // 加载数据模型，直接使用outputPath
        FileWriter fileWriter = new FileWriter(outputPath);
        templateName.process(model, fileWriter);
        fileWriter.close();

    }
}
