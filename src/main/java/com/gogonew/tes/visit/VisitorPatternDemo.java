package com.gogonew.tes.visit;

public class VisitorPatternDemo {

    public static void main(String[] args) {
        ComputerPart computerPart = new Computer();
        computerPart.accept(new ComputerPartDisplayVisitor());
    }
}
