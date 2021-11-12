package com.shf.reflect2;

import java.io.Serializable;

public class Creature<T> implements Serializable {
    private char gender;
    private double weight;

    private void breathbreak(){
        System.out.println("生物呼吸");
    }
    public void eat(){
        System.out.println("生物吃东西");
    }
}
