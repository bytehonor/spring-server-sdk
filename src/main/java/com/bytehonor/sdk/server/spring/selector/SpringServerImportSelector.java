package com.bytehonor.sdk.server.spring.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import com.bytehonor.sdk.server.spring.config.SpringBootStandardConfiguration;

/**
 * @author lijianqiang
 *
 */
public class SpringServerImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] { SpringBootStandardConfiguration.class.getName() };
    }
}
