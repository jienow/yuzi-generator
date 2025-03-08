package ${basePackage}.model;

import lombok.Data;

/**
 * 数据模型
 */
@Data
public class DataModel {
<#list modelConfig.models as modelInfo>

    <#if modelInfo.description>
    /**
     * 是否产生循环
     */
    </#if>

    private boolean loop;
</#list>
}
