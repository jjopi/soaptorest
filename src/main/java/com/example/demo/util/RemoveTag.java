package com.example.demo.util;

public class RemoveTag {
    public static String remove(String s){
        StringBuilder builder=new StringBuilder();
        int tag=0;
        for(int i=0;i<s.length();i++){
            if(tag==0){
                if(s.charAt(i)=='<'){
                    tag=1;
                }else {
                    builder.append(s.charAt(i));
                }

            }else {
                if(s.charAt(i)=='>'){
                    tag=0;
                    builder.append(" ");
                }
            }
        }
        return builder.toString();
    }
}
