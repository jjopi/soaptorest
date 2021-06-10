package com.example.demo.controller;

import com.example.demo.entity.WebApi;
import com.example.demo.util.WSDLTOREST;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;

@Controller
public class AddController {
    @PostMapping("/addwsdlurl")
    @ResponseBody
    public WebApi add(@RequestParam("url") String url,
                      @RequestParam("web_name") String web_name,
                      @RequestParam("text") String text) throws Exception {

        System.out.println(url);
        System.out.println(web_name);
        System.out.println(text);

        String url_n = URLDecoder.decode(url, "UTF-8");

        WebApi webApi = WSDLTOREST.toRest(url_n, web_name,text);
        return webApi;
    }
}
