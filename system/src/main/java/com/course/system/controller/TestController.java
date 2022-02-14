package com.course.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzy
 * @date 2022/2/14
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "system";
    }
}
