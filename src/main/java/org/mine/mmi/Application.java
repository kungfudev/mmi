package org.mine.mmi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Application  {

    private static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args){
        log.debug("Start Converter Service");
        SpringApplication.run(Application.class, args);
    }

    @Bean
    WebMvcConfigurer configurer () {
        return new WebMvcConfigurer() {

            @Override
            public void addResourceHandlers (ResourceHandlerRegistry registry) {
                registry
                        .addResourceHandler("/static/**")
                        .addResourceLocations("classpath:/pages/");
            }

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addRedirectViewController("/index", "/static/index.html");
            }
        };
    }
}


