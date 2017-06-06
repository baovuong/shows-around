package com.vuongideas.showsaround.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    
    @RequestMapping("/")
    public String index() {
        return "SHOWS AROUND";
    }
    
    @RequestMapping("/wow")
    public Map<String, String> wow() {
        Map<String, String> test = new HashMap<String, String>();
        test.put("test", "one two");
        return test;
    }
}
