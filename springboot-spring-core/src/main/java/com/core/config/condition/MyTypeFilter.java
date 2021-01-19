package com.core.config.condition;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * 自定义包扫描过滤过滤规则
 * @ComponentScan注解中使用
 *
 * @author lovely
 * @version 1.0
 * on 2021/1/19
 */
public class MyTypeFilter implements TypeFilter {
    /**
     * @param metadataReader        读取当前正在扫描的类的信息
     * @param metadataReaderFactory 可以获取到其他任何类的信息
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        // 获取当前类注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        // 获取当前正在扫描的类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        System.out.println("-------->" + classMetadata.getClassName());

        // 获取当前类资源（类路径）
        Resource resource = metadataReader.getResource();
        return true;
    }
}
