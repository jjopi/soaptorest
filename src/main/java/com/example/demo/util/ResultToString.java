package com.example.demo.util;

import java.util.ArrayList;
import java.util.List;

public class ResultToString {
    public static List<String> getResult(String s) {
        List<String> list=new ArrayList<>();
        StringBuilder builder=new StringBuilder();
        String res=null;
        int index=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='>'){
                index=1;
            }else if(s.charAt(i)=='<'){
                index=0;
                res = builder.toString();
                if(res.length()==0){
                    builder=new StringBuilder();
                    continue;
                }
                list.add(res);
                builder=new StringBuilder();
            }else {
                if(index==1){
                    if(s.charAt(i)!='\n'&&s.charAt(i)!='\t'&&s.charAt(i)!=' '&&s.charAt(i)!='\r'){
                        builder.append(s.charAt(i));
                    }
                }
            }
        }
        return list;
    }
}
