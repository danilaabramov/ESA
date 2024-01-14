package com.hospital.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.xslt.XsltView;
import org.springframework.web.servlet.view.xslt.XsltViewResolver;

public class WebConfig {
    @Bean
    public ViewResolver xsltViewResolver(){
        XsltViewResolver viewResolver = new XsltViewResolver();
        viewResolver.setOrder(1);
        viewResolver.setViewClass(XsltView.class);
        viewResolver.setViewNames("patientXSL", "roomXSL", "hospitalXSL");
        viewResolver.setPrefix("classpath:/xsl/");
        viewResolver.setSuffix(".xsl");
        return viewResolver;
    }
}

