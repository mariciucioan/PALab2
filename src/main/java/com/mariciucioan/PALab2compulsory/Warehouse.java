package com.mariciucioan.PALab2compulsory;

/**
 * Author: Mariciuc Ioan
 */
public class Warehouse extends Source {
    static final String TYPE="Warehouse";

    public Warehouse(String name, int supply) {
        super(name, supply);
    }

    public String getType() {
        return TYPE;
    }
}
