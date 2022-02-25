//package com.course.server.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * @author zzy
// * @date 2022/2/24
// */
//@Configuration
//public class CorsConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOriginPatterns("*")
//                .allowedHeaders(CorsConfiguration.ALL)
//                .allowedMethods(CorsConfiguration.ALL)
//                .allowCredentials(true) //允许带上凭证，比如cookie
//                .maxAge(3600);  //1小时内不需要再次质检（发OPTIONS请求）
//    }
//}
