package com.mariciucioan.PALab2compulsory;

public class Factory extends Source {
    static final String TYPE="Factory";

    public Factory(String name, int supply) {
        super(name, supply);
    }

    public String getType() {
        return TYPE;
    }
}
