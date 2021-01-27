package com.gogonew.tes.c003;

public class TesFloat {
    public static void main(String[] args) {
        Double a = 19.013675664650987623456;
        String b = Double.toString(a);
        System.out.println(b);
        System.out.println(b.indexOf(".")+1);
        System.out.println(b.substring(b.indexOf(".")+1).length());
    }
}
