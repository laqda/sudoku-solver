package graph;

import grid.Grid;

import static graph.GraphGenerator.*;

public class GraphComparator {

    public static void main(String[] args) {
        long diff;
        //Grid rootGrid = new DefaultGrid(9);
        Grid rootGrid = easyTestGrid();

        //Generator generator = new Generator(rootGrid);
        //generator.generate(1);
        rootGrid.display();

        long startRC = System.currentTimeMillis();
        System.out.println("Generating reduced universe w. constraint graph");
        Node ndRC = generateReducedUniverseWithConstraintVerification(rootGrid, false);
        long endRC = System.currentTimeMillis();
        diff = endRC - startRC;
        System.out.println("Finished in : " + diff + "ms");

        long startFC = System.currentTimeMillis();
        System.out.println("Generating full universe w. constraint graph");
        Node ndFC = generateFullUniverseWithConstraintVerification(rootGrid, false);
        long endFC = System.currentTimeMillis();
        diff = endFC - startFC;
        System.out.println("Finished in : " + diff + "ms");

        long startR = System.currentTimeMillis();
        System.out.println("Generating reduced universe graph");
        Node ndR = generateReducedUniverse(rootGrid, false);
        long endR = System.currentTimeMillis();
        diff = endR - startR;
        System.out.println("Finished in : " + diff + "ms");

        long startF = System.currentTimeMillis();
        System.out.println("Generating full universe graph");
        Node ndF = generateFullUniverse(rootGrid, false);
        long endF = System.currentTimeMillis();
        diff = endF - startF;
        System.out.println("Finished in : " + diff + "ms");
    }

}
