package com.gogonew.design.pkg06;

import lombok.Setter;

/**
 * 产品角色：包含多个组成部件的复杂对象
 */
@Setter
public class Product {

    private String partA;
    private String partB;
    private String partC;

    public void show(){
        System.out.println("显示产品特性。。。"+partA+partB+partC);
    }
}
