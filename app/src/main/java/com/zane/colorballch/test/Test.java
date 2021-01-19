package com.zane.colorballch.test;

import android.util.ArrayMap;

public class Test {
    public static void main(String[] args) {
//        String str = "通过报备完成{n}运输交易奖励";
//        String res = str.replaceAll("\\{n\\}", "\\\n");
//        System.out.println("\\n");
//        System.out.println(res);


        ArrayMap<String, String> mMap = new ArrayMap<>();
        mMap.put("xx", "111");
        mMap.put("xx", "333");
        System.out.println(mMap.size());
    }
}
