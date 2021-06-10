package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

import static com.example.demo.util.WSDLTOREST.apiMap;

@Controller
public class GetController {
    @GetMapping("/getprojects")
    @ResponseBody
    public Set<String> get(){
        Set<String> set = apiMap.keySet();
        return set;
    }
}
