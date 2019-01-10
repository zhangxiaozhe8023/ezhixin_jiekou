package com.interfaceTest.Data;

public class DataClass {
    private String count;
    private String key;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "DataClass{" +
                "count=" + count +
                ", key='" + key + '\'' +
                '}';
    }
}
