package com.mariciucioan.palab2compulsory.problem;

import com.mariciucioan.palab2compulsory.destinations.Destination;
import com.mariciucioan.palab2compulsory.sources.Source;

import java.util.ArrayList;

/**
 * Author: Mariciuc Ioan
 */
public class Problem {
    private final int[][] costs;
    private ArrayList<Source> sources;
    private ArrayList<Destination> destinations;
    private int totalCost;

    public Problem(int[][] costs, ArrayList<Source> sources, ArrayList<Destination> destinations) {
        this.costs = costs;
        this.sources = sources;
        this.destinations = destinations;
        totalCost = 0;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public int[][] getCosts() {
        return costs;
    }

    public void setCosts(int i, int j, int value) {
        this.costs[i][j] = value;
    }

    public ArrayList<Source> getSources() {
        return sources;
    }

    public void setSources(ArrayList<Source> sources) {
        this.sources = sources;
    }

    public ArrayList<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(ArrayList<Destination> destinations) {
        this.destinations = destinations;
    }


    /**
     * Handle the operations between source and destination
     * @param source the row in the costs matrix
     * @param id the column id
     * @return StringBuilder
     */
    public StringBuilder sourceToDestination(Source source, int id) {
        StringBuilder sb = new StringBuilder();
        Destination destination = destinations.get(id);

        int storage = source.getSupply();
        int needs = destination.getDemand();
        int cost = costs[sources.indexOf(source)][id];
        int result;

        if(storage < needs) {
            result = storage * cost;
            sb.append(storage).append(" units * cost ").append(cost)
                    .append(" = ").append(result);

            destination.setDemand(needs-storage);
            Destination.setTotalDemands(Destination.getTotalDemands() - storage);
            source.setSupply(0);
        } else {
            result = needs * cost;
            sb.append(needs).append(" units * cost ").append(cost)
                    .append(" = ").append(result);

            source.setSupply(storage-needs);

            Destination.setTotalDemands(Destination.getTotalDemands() - needs);
            destination.setDemand(0);
        }

        setTotalCost(getTotalCost() + result);
        return sb;
    }

    /**
     *
     * @return String of the problem's details
     */
    @Override
    public String toString() {
        StringBuilder result= new StringBuilder();

        result.append("Matricea de costuri a problemei:\n");

        for(int i=0; i<costs.length; i++) {
            for(int j=0; j<costs.length; j++)
                result.append(costs[i][i]).append(" ");

            result.append('\n');
        }

        result.append("\nAvem urmatoarele surse cu supply-urile respective:\n");

        for (Source source : sources) {
            result.append(source.getName()).append(" (type: ")
                    .append(source.getName()).append("): ").
                    append(source.getSupply()).append('\n');
        }

        result.append("\nAvem urmatoarele destinatii cu demandurile-urile respective:\n");

        for (Destination e : destinations) {
            result.append(e.getName()).append(": ").append(e.getDemand()).append('\n');
        }

        return result.toString();
    }
}
