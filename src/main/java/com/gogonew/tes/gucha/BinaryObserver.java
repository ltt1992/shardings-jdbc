package com.gogonew.tes.gucha;

public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    void update() {
        System.out.println("BinaryString:"+Integer.toBinaryString(this.subject.getState()));
    }
}
