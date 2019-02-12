package com.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {
    private static final String PARAM1 = "[a-zA-Z][a-zA-Z0-9_-]*";
    private static final String PARAM2 = "[a-zA-Z]+";
    private static final String PARAM3 = "[a-]+";
    private static final Pattern p1 = Pattern.compile(PARAM1);
    private static final Pattern p2 = Pattern.compile("\\{(" + PARAM2 + ")\\}");
    private static final Pattern p3 = Pattern.compile(PARAM3);

    public static void main(String[] args) {
        String s = "我的手机号是18837112195，曾经用过18888888888，还用过18812345678";
        String regex = "1[35789]\\d{9}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        while (m.find()) { //一定需要先查找再调用group获取电话号码
            System.out.println(m.group());
        }
    }
}
