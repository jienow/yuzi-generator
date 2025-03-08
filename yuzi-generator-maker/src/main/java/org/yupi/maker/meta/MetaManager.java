package org.yupi.maker.meta;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

public class MetaManager {

    private static volatile Meta meta;

    private MetaManager() {}

    public static Meta getMeta() {
        if (meta == null) {
            synchronized (MetaManager.class) {
                if (meta == null) {
                    meta = initMeta();
                }
            }
        }
        return meta;
    }

    private static Meta initMeta() {
        String MetaJson = ResourceUtil.readUtf8Str("meta.json");
        Meta newMeta = JSONUtil.toBean(MetaJson, Meta.class);
        Meta.FileConfig fileConfig = newMeta.getFileConfig();
        //todo 校验和处理默认值
        return newMeta;
    }


    public static void main(String[] args) {
        String MetaJson = ResourceUtil.readUtf8Str("meta.json");
        Meta newMeta = JSONUtil.toBean(MetaJson, Meta.class);
        System.out.println(newMeta);
    }
}
