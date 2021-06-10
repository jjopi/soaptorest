package com.example.demo.controller;

import com.example.demo.entity.WebApiToSql;
import com.example.demo.util.ResultToString;
import com.example.demo.util.SOAPRequest;
import com.example.demo.util.WSDLTOREST;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class RequestController {
    @GetMapping("/api/{web}/{method}")
    @ResponseBody
    public List<String> hello(@PathVariable("web") String web,
                              @PathVariable("method") String method){

        System.out.println(method);
        List<String> list=new ArrayList<>();
        if(!WSDLTOREST.apiMap.containsKey(web)){
            list.add("没有" + web + "项目");
            return list;
        }
        WebApiToSql webApiToSql = WSDLTOREST.apiMap.get(web);
        String result = SOAPRequest.request(webApiToSql.getUrl(), method,
                webApiToSql.getWebApi().getNamespaceURI());
        return ResultToString.getResult(result);
    }

    @PostMapping("/api/{web}/{method}")
    @ResponseBody
    public List<String> my_post(@PathVariable("web") String web,
                        @PathVariable("method") String method,@RequestBody Map<String,Object> params){
        System.out.println(method);
        List<String> list=new ArrayList<>();
        if(!WSDLTOREST.apiMap.containsKey(web)){
            list.add("没有" + web + "项目");
            return list;
        }

        System.out.println(params);
        WebApiToSql webApiToSql = WSDLTOREST.apiMap.get(web);
        String result = SOAPRequest.post(webApiToSql.getUrl(), method,
                webApiToSql.getWebApi().getNamespaceURI(),params);
        return ResultToString.getResult(result);
    }
}
