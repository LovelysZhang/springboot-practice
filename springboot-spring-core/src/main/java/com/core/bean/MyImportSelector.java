package com.core.bean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义需要导入的组件
 * @author hello.z
 * on 2021/1/19
 */
public class MyImportSelector implements ImportSelector {
    /**
     *
     * @param annotationMetadata 当前标注@Import注解的类的所有注解信息
     * @return 将要导入到容器中的组件全类名
     */
    @Override
    public String[] selectImports(final AnnotationMetadata annotationMetadata) {
        return new String[]{"com.core.bean.Yellow","com.core.bean.Blue"};
    }
}
