package com.mariciucioan.PALab2compulsory;

public class Solution {
    private final Problem problem;

    public Solution(Problem problem) {
        this.problem = problem;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("O solutie ar putea fi:\n\n");

        while(Destination.getTotalDemands() != 0) {
            problem.getSources().forEach(e -> {
                if(e.getSupply() == 0)
                    return;

                int id = searchMinimumCostIndexInMatrix(e);
                int currentRow = problem.getSources().indexOf(e);

                while (problem.getDestinations().get(id).getDemand() == 0) {
                    problem.setCosts(currentRow, id, 1000);
                    id = searchMinimumCostIndexInMatrix(e);
                }

                result.append(e.toString()).append(" -> ")
                        .append(problem.getDestinations().get(id).toString()).append(":  ")
                        .append(problem.SourceToDestination(e, id)).append('\n');
            });
        }

        result.append('\n');
        result.append("Total cost: ").append(problem.getTotalCost());

        return result.toString();
    }

    private int searchMinimumCostIndexInMatrix(Source source) {
        int min = 0;
        for(int i=0; i<problem.getCosts().length; i++) {
            min = problem.getCosts()[problem.getSources().indexOf(source)][i]
                    < problem.getCosts()[problem.getSources().indexOf(source)][min] ? i : min;
        }

        return min;
    }
}
