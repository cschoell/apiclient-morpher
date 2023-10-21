package org.cschoell.apiclient.context;

import org.cschoell.apiclient.converter.api.ConverterModule;
import org.cschoell.apiclient.converter.api.ConverterRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import java.util.List;

@Configuration
@ComponentScan(basePackages = "org.cschoell", includeFilters = @ComponentScan.Filter(
        type = FilterType.ASSIGNABLE_TYPE, classes = ConverterModule.class
))
public class SpringContextConfiguration {
    private static ApplicationContext myInstance;

    public static ApplicationContext getInstance() {
        if (myInstance == null) {
            myInstance = new AnnotationConfigApplicationContext(SpringContextConfiguration.class);
        }
        return myInstance;
    }

    @Bean
    public ConverterRegistry converterRegistry(List<ConverterModule> modules) {
        final ConverterRegistry converterRegistry = new ConverterRegistry();
        modules.forEach(converterRegistry::registerModule);
        return converterRegistry;
    }
}
