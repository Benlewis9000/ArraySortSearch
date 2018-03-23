package com.company;

public class Pair {

    private int index;
    private int value;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Pair (int index, int value){
        this.setIndex(index);
        this.setValue(value);
    }

}
