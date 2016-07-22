package com.subrat.spring.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan (basePackages="com.subrat.spring")
@Import ({MessagingConfiguration.class})
public class AppConfig {

}
