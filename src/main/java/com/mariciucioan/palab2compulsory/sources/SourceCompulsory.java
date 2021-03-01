package com.mariciucioan.palab2compulsory.sources;

/**
 * Author: Mariciuc Ioan
 */
public class SourceCompulsory {
    private String name;
    private int supply;
    public enum SourceType {
        WAREHOUSE,
        FACTORY;
    }

    SourceType type;


    public SourceCompulsory(String name, int supply) {
        this.name = name;
        this.supply = supply;
    }

    public SourceType getType() {
        return this.type;
    }

    public void setType(SourceType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSupply() {
        return supply;
    }

    public void setSupply(int supply) {
        this.supply = supply;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Source) {
            Source source = (Source) obj;

            return this.getName().equals(source.getName());
        }

        return false;
    }
}
