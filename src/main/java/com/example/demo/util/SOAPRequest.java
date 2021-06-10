package com.example.demo.util;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.webservice.SoapClient;

import java.util.Map;

public class SOAPRequest {
    public static String request(String url,String methodName,String namespaceURI){
        SoapClient client = SoapClient.create(url)
                .setMethod(methodName, namespaceURI)
                .setCharset(CharsetUtil.CHARSET_GBK)
                ;
        client.setConnectionTimeout(3000);
        client.setReadTimeout(3000);
        String response = client.send(true);
        return response;
    }
    public static String post(String url, String methodName,
                              String namespaceURI, Map<String,Object> map){
        SoapClient client = SoapClient.create(url)
                .setMethod(methodName, namespaceURI)
                .setCharset(CharsetUtil.CHARSET_GBK)
                ;
        for (String s : map.keySet()) {
            client.setParam("web:"+s,map.get(s));
        }
        String result = client.send(true);
        return result;
    }
}
