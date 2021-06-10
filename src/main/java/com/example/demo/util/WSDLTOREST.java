package com.example.demo.util;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.example.demo.entity.*;
import org.dom4j.*;
import org.junit.Test;

import java.util.*;

public class WSDLTOREST {
    public static Map<String, WebApiToSql> apiMap = new HashMap<>();

    public static WebApi toRest(String url, String web_name,String text) throws Exception {
        String targetNameSpace = getTargetNamespace(url);
        /**
         * 解析url，得到所有的服务，不用生成类
         * 将服务变成rest风格
         * 前端访问的 到后端进行代理，用hutool访问源的东西
         */
        List<Node> elements = getElement(url);

        String my_url=getUrl(url);
        //获取所有的方法和参数  没有描述
        Map<String,List<String>> methods = getMethods(elements);

        //方法名称和参数以及结果的描述 没有具体参数
        Map<String,String> dis_map=getMethodParamsDescription(url);

        WebApi webApi;
        MyGetJSONObject getServices;
        MyPostJSONObject postServices;

        //getJsonObject中的services
        Map<String,String> get_services=new HashMap<>();
        List<PostService> post_services=new ArrayList<>();
        //没有getservice类
        PostService postService;

        //所有的方法名
        Set<String> keys = dis_map.keySet();
        for (String key : keys) {
            //整个描述
            String dis = dis_map.get(key);
            //在所有方法中获取该方法的参数
            List<String> params = methods.get(key);

            Map<String,String> json_params=new HashMap<>();
            if(params.size()==0){
                //放入get中
                //改过method
                get_services.put(key,dis);
            }else{
                //放入post中
                int i=params.size();
                for (int j = 0; j < i; j++) {
                    String param = params.get(j);
                    String[] split = param.split(":");
                    String type=split[2];

                    json_params.put(split[0],type);
                }
                postService=new PostService(key,dis,json_params);
                post_services.add(postService);
            }
        }

        getServices=new MyGetJSONObject(get_services);
        postServices=new MyPostJSONObject(post_services);

        webApi=new WebApi(text,"/api/"+web_name+"/",targetNameSpace,
                getServices,postServices);

        WebApiToSql webApiToSql=new WebApiToSql(my_url,webApi);
        apiMap.put(web_name,webApiToSql);
        return webApi;
    }
    public static String getUrl(String url) throws Exception{
        Document document = getDocument(url);
        List<Node> nodes  = document.selectNodes("//wsdl:service//wsdl:port");
        Node node = nodes.get(0).selectSingleNode("./soap:address");
        String s = node.valueOf("@location");
        return s;
    }

    public static Map<String,String> getMethodParamsDescription(String url) throws Exception{
        Map<String,String> map=new HashMap<>();

        String methodName;
        String params_descrip;

        Document document = getDocument(url);
        List<Node> list = document.selectNodes("//wsdl:portType");
        List<Node> descriptions = list.get(0).selectNodes("./wsdl:operation");
        for (Node node : descriptions) {
            methodName=node.valueOf("@name");
            params_descrip= node.selectSingleNode("./wsdl:documentation").getText();
            map.put(methodName,RemoveTag.remove(params_descrip));
        }
        return map;
    }

    //获取所有的方法和参数
    public static Map<String,List<String>> getMethods(List<Node> list) throws Exception {
        Map<String,List<String>> map=new HashMap<>();

        String name;
        //方法参数
        List<String> params;

        String param;
        String param_type;

        Iterator<Node> iterator = list.iterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            //方法名name
            name= node.valueOf("@name");
            params=new ArrayList<>();
            //获取参数
            List<Node> list_params = node.selectNodes(".//s:element");
            if(list_params.size()!=0){
                for (Node list_param : list_params) {
                    param= list_param.valueOf("@name");
                    param_type=list_param.valueOf("@type");
                    params.add(param+":"+param_type);
                }
            }
            map.put(name,params);
        }
        return map;
    }

    public static List<Node> getElement(String url) throws Exception{
        Document document = getDocument(url);
        List<Node> list = document.selectNodes("//wsdl:types/s:schema/s:element");
        return list;
    }

    public static String getTargetNamespace(String url) throws Exception{
        Document document = getDocument(url);
        Element rootElement = document.getRootElement();
        Node node = rootElement.selectSingleNode("//wsdl:definitions");
        String stringValue = node.valueOf("@targetNamespace");
        return stringValue;
    }
    public static Document getDocument(String url) throws Exception{
        HttpRequest request = HttpUtil.createGet(url);
        HttpResponse response = request.execute();
        String body = response.body();//待解析的满足xml规范的字符串
        Document document = DocumentHelper.parseText(body);
        return document;
    }

    @Test
    public void test() throws Exception{
        Document document = getDocument("http://www.webxml.com.cn/WebServices/WeatherWS.asmx?wsdl");
        List<Node> nodes  = document.selectNodes("//wsdl:service//wsdl:port");
        Node node = nodes.get(0).selectSingleNode("./soap:address");
        String s = node.valueOf("@location");
        System.out.println(s);
    }
}
