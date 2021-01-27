package com.gogonew.tes.state;

public class EndState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }
    public String toString(){
        return "end";
    }
}
