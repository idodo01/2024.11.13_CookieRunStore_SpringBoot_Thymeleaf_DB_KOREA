package com.koreait.store.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.koreait.store.aspect")
@EnableAspectJAutoProxy
public class MainConfiguration {
}
