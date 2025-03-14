package org.yupi.model;

import lombok.Data;

@Data
public class MainTemplateConfig {
    /**
     * 是否产生循环
     */
    private boolean loop;
    /**
     * 作者注释
     */
    private String author = "yupi";
    /**
     * 输出信息
     */
    private String outputText = "sum = ";
}
