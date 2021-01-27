package com.gogonew.tes.gucha;

public class HexaObserver extends Observer{

    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    void update() {
        System.out.println("Hex String:"+Integer.toHexString(this.subject.getState()));
    }
}
