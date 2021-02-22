package com.mariciucioan.PALab2compulsory;

public class Destination {
    private String name;
    private int demand;
    static int totalDemands;

    public Destination(String names, int demand) {
        this.name = names;
        this.demand = demand;
        totalDemands+=demand;
    }

    public static int getTotalDemands() {
        return totalDemands;
    }

    public static void setTotalDemands(int totalDemands) {
        Destination.totalDemands = totalDemands;
    }

    public String getName() {
        return name;
    }

    public void setNames(String names) {
        this.name = names;
    }

    public int getDemand() {
        return demand;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Destination) {
            Destination dest = (Destination) obj;

            return this.getName().equals(dest.getName());
        }

        return false;
    }
}
