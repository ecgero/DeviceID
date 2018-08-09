package com.emailxl.deviceid.utils;

public class Output {
    private String name;
    private String value;

    public Output(String name, String value) {
        this.name = name;
        this.value = value;
    }

    // name functions
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // value functions
    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[" +
                "name=" + name + ", " +
                "value=" + value + ", " + "]";
    }
}
