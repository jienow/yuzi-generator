package org.yupi.maker.generator;

import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {

    public static void doGenerate(Object model) throws TemplateException, IOException {
        /**
         * 静态代码生成
         */
        // 获取整个项目的根路径
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();
        // 输入路径：ACM 示例代码模板目录
        String inputPath = new File(parentFile, "yuzi-generator-demo-project/acm-template").getAbsolutePath();
        // 输出路径：直接输出到项目的根目录
        String outputPath = projectPath;
        StaticGenerator.copyFilesByHutool(inputPath, outputPath);

        /**
         * 动态代码生成
         */
        String DynamicProjectPath = System.getProperty("user.dir");
        String DynamicInputPath = DynamicProjectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String DynamicOutputPath = DynamicProjectPath + File.separator+ "acm-template" + File.separator + "src/com/yupi/acm/MainTemplate.java";


        DynamicGenerator.doGenerate(DynamicInputPath,DynamicOutputPath,model);

    }

    /**
     * 程序入口方法，负责根据元数据生成Java代码文件。
     *
     * @param args 命令行参数（未使用）
     * @throws TemplateException 模plates处理异常
     * @throws IOException       输入输出异常
     */


}

