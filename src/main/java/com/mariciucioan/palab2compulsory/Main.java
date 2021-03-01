package com.mariciucioan.palab2compulsory;

import com.mariciucioan.palab2compulsory.destinations.Destination;
import com.mariciucioan.palab2compulsory.problem.Problem;
import com.mariciucioan.palab2compulsory.problem.Solution;
import com.mariciucioan.palab2compulsory.sources.Factory;
import com.mariciucioan.palab2compulsory.sources.Source;
import com.mariciucioan.palab2compulsory.sources.Warehouse;

import java.util.ArrayList;

/**
 * Author: Mariciuc Ioan
 */
public class Main {

    public static void main(String[] args) {
        int[][] costs = new int[][] {
                {2, 3, 1},
                {5, 4, 8},
                {5, 6, 8}
        };
        Factory s1 = new Factory("S1", 10);
        Warehouse s2 = new Warehouse("S2", 35);
        Warehouse s3 = new Warehouse("S3", 25);

        ArrayList<Source> sources = new ArrayList<>();
        sources.add(s1);
        sources.add(s2);
        sources.add(s3);

        Destination d1 = new Destination("D1", 20);
        Destination d2 = new Destination("D2", 25);
        Destination d3 = new Destination("D3", 25);

        ArrayList<Destination> destinations = new ArrayList<>();
        destinations.add(d1);
        destinations.add(d2);
        destinations.add(d3);

        Problem problem = new Problem(costs, sources, destinations);
        System.out.println(problem.toString());

        Solution solution = new Solution(problem);
        System.out.println(solution.toString());
    }
}
