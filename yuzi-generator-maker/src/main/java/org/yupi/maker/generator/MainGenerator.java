package org.yupi.maker.generator;

import org.yupi.maker.meta.Meta;
import org.yupi.maker.meta.MetaManager;

public class MainGenerator {
    public static void main(String[] args) {
        Meta meta = MetaManager.getMeta();
        System.out.println(meta);
    }
}
