package com.pruebasjpa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ContextUtil {

    public static ApplicationContext getContext() {
        return new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring/root-context.xml");
    }
}
