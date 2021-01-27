package com.gogonew.design.pkg05;

public class SRfarm implements Farm{
    @Override
    public Animal newAnimal() {
        return new Horse();
    }

    @Override
    public Plant newPlant() {
        return new Vegetables();
    }
}
