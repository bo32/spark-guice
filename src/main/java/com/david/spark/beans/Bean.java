package com.david.spark.beans;

public class Bean {
    private String key, chain;
    private int value;

    public Bean(String key, String chain, int value) {
        this.key = key;
        this.chain = chain;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getChain() {
        return chain;
    }

    public int getValue() {
        return value;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setChain(String chain) {
        this.chain = chain;
    }

    public void setValue(int value) {
        this.value = value;
    }

}