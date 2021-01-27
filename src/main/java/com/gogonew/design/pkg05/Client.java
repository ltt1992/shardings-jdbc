package com.gogonew.design.pkg05;

public class Client {
    public static void main(String[] args) {
        Farm farm =  new SGfarm();
        farm.newAnimal().show();
        farm.newPlant().show();

        Farm farm1 = new SRfarm();
        farm1.newAnimal().show();
        farm1.newPlant().show();
    }
}
