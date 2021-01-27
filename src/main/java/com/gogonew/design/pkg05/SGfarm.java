package com.gogonew.design.pkg05;

public class SGfarm implements Farm{
    @Override
    public Animal newAnimal() {
        return new Cattle();
    }

    @Override
    public Plant newPlant() {
        return new Fruitage();
    }
}
