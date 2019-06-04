package graph;

import generator.Generator;
import grid.DefaultGrid;
import grid.Grid;
import graph.Node;

import java.util.*;

public class GraphGenerator {

    public static Node generateReducedUniverse(Grid rootGrid, boolean display) {
        Node<Grid> visitedNode;
        Grid visitedGrid;
        Grid nextGrid;
        int[] target = new int[]{0, 0};
        Node<Grid> rootNode = new Node<>(rootGrid);
        Queue<Node<Grid>> q = new LinkedList<>();
        q.add(rootNode);
        while (!q.isEmpty()) {
            visitedNode = q.poll();
            visitedGrid = visitedNode.getData();
            if (!visitedGrid.isFilled()) {
                target = visitedGrid.nextUnassignedValue(target[0], target[1]);
                for (int cellFill = 1; cellFill <= 9; cellFill++) {
                    nextGrid = Generator.copyGrid(visitedGrid);
                    nextGrid.setValue(target[0], target[1], cellFill);
                    if (display) {
                        nextGrid.display();
                    }
                    visitedNode.addChild(nextGrid);
                    Node<Grid> child = new Node<>(nextGrid);
                    q.add(child);
                }
                target = visitedGrid.nextUnassignedValue(target[0] + 1, target[1]);
            }

        }

        return rootNode;
    }

    public static Node generateReducedUniverseWithConstraintVerification(Grid rootGrid, boolean display) {
        Node<Grid> visitedNode;
        Grid visitedGrid;
        Grid nextGrid;
        int[] target = new int[]{0, 0};
        Node<Grid> rootNode = new Node<>(rootGrid);
        Queue<Node<Grid>> q = new LinkedList<>();
        q.add(rootNode);
        while (!q.isEmpty()) {
            visitedNode = q.poll();
            visitedGrid = visitedNode.getData();
            if (!visitedGrid.isFilled()) {
                target = visitedGrid.nextUnassignedValue(target[0], target[1]);
                for (int cellFill = 1; cellFill <= 9; cellFill++) {
                    nextGrid = Generator.copyGrid(visitedGrid);
                    if (nextGrid.isAllowed(target[0], target[1], cellFill)) {
                        nextGrid.setValue(target[0], target[1], cellFill);
                        if (display) {
                            nextGrid.display();
                        }
                        visitedNode.addChild(nextGrid);
                        Node<Grid> child = new Node<>(nextGrid);
                        q.add(child);
                    }
                }
                target = visitedGrid.nextUnassignedValue(target[0] + 1, target[1]);
            }

        }

        return rootNode;
    }

    public static Node generateFullUniverse(Grid rootGrid, boolean display) {
        Node<Grid> visitedNode;
        Grid visitedGrid;
        Grid nextGrid;
        int[] target = new int[]{0, 0};
        Node<Grid> rootNode = new Node<>(rootGrid);
        Queue<Node<Grid>> q = new LinkedList<>();
        q.add(rootNode);
        while (!q.isEmpty()) {
            visitedNode = q.poll();
            visitedGrid = visitedNode.getData();
            for (int i = 0; i < visitedGrid.emptyCellsRemaining(); i++) {
                target = visitedGrid.nextUnassignedValue(target[0], target[1]);
                for (int cellFill = 1; cellFill <= 9; cellFill++) {
                    nextGrid = Generator.copyGrid(visitedGrid);
                    nextGrid.setValue(target[0], target[1], cellFill);
                    if (display) {
                        nextGrid.display();
                    }
                    visitedNode.addChild(nextGrid);
                    Node<Grid> child = new Node<>(nextGrid);
                    q.add(child);
                }
                target = visitedGrid.nextUnassignedValue(target[0] + 1, target[1]);
            }
        }

        return rootNode;
    }

    public static Node generateFullUniverseWithConstraintVerification(Grid rootGrid, boolean display) {
        Node<Grid> visitedNode;
        Grid visitedGrid;
        Grid nextGrid;
        int[] target = new int[]{0, 0};
        Node<Grid> rootNode = new Node<>(rootGrid);
        Queue<Node<Grid>> q = new LinkedList<>();
        q.add(rootNode);
        while (!q.isEmpty()) {
            visitedNode = q.poll();
            visitedGrid = visitedNode.getData();
            for (int i = 0; i < visitedGrid.emptyCellsRemaining(); i++) {
                target = visitedGrid.nextUnassignedValue(target[0], target[1]);
                for (int cellFill = 1; cellFill <= 9; cellFill++) {
                    nextGrid = Generator.copyGrid(visitedGrid);
                    if (nextGrid.isAllowed(target[0], target[1], cellFill)) {
                        nextGrid.setValue(target[0], target[1], cellFill);
                        if (display) {
                            nextGrid.display();
                        }
                        visitedNode.addChild(nextGrid);
                        Node<Grid> child = new Node<>(nextGrid);
                        q.add(child);

                    }
                }
                target = visitedGrid.nextUnassignedValue(target[0] + 1, target[1]);
            }
        }

        return rootNode;
    }

    public static Grid easyTestGrid() {

        Grid grid = new DefaultGrid(9);
        grid.setValue(0, 0, 2);
        grid.setValue(1, 0, 8);
        grid.setValue(2, 0, 3);
        grid.setValue(3, 0, 5);
        grid.setValue(4, 0, 1);
        grid.setValue(5, 0, 9);
        grid.setValue(6, 0, 7);
        grid.setValue(7, 0, 4);
        grid.setValue(8, 0, 6);

        grid.setValue(0, 1, 9);
        grid.setValue(1, 1, 6);
        grid.setValue(2, 1, 4);
        grid.setValue(3, 1, 8);
        grid.setValue(4, 1, 7);
        grid.setValue(5, 1, 3);
        grid.setValue(6, 1, 5);
        grid.setValue(7, 1, 2);
        grid.setValue(8, 1, 1);

        grid.setValue(0, 2, 5);
        grid.setValue(1, 2, 1);
        grid.setValue(2, 2, 7);
        grid.setValue(3, 2, 6);
        grid.setValue(4, 2, 2);
        grid.setValue(5, 2, 4);
        grid.setValue(6, 2, 9);
        grid.setValue(7, 2, 3);
        grid.setValue(8, 2, 8);

        grid.setValue(0, 3, 1);
        grid.setValue(1, 3, 5);
        grid.setValue(2, 3, 6);
        grid.setValue(3, 3, 7);
        grid.setValue(4, 3, 4);
        grid.setValue(5, 3, 2);
        grid.setValue(6, 3, 3);
        grid.setValue(7, 3, 8);
        grid.setValue(8, 3, 9);

        grid.setValue(0, 4, 4);
        grid.setValue(1, 4, 2);
        grid.setValue(2, 4, 9);
        grid.setValue(3, 4, 3);
        grid.setValue(4, 4, 8);
        grid.setValue(5, 4, 6);
        grid.setValue(6, 4, 1);
        grid.setValue(7, 4, 7);
        grid.setValue(8, 4, 5);

        grid.setValue(0, 5, 3);
        grid.setValue(1, 5, 7);
        grid.setValue(2, 5, 8);
        grid.setValue(3, 5, 1);
        grid.setValue(4, 5, 9);
        grid.setValue(5, 5, 5);
        grid.setValue(6, 5, 2);
        grid.setValue(7, 5, 6);
        grid.setValue(8, 5, 4);

        grid.setValue(0, 6, 8);
        grid.setValue(1, 6, 9);
        grid.setValue(2, 6, 5);
        grid.setValue(3, 6, 4);
        grid.setValue(4, 6, 3);
        grid.setValue(5, 6, 7);
        grid.setValue(6, 6, 6);
        grid.setValue(7, 6, 1);
        grid.setValue(8, 6, 2);

        grid.setValue(0, 7, 7);
        grid.setValue(1, 7, 4);
        grid.setValue(2, 7, 2);
        grid.setValue(3, 7, 9);
        grid.setValue(4, 7, 6);
        //grid.setValue(5, 7, 1);
        grid.setValue(6, 7, 8);
        grid.setValue(7, 7, 5);
        grid.setValue(8, 7, 3);

        grid.setValue(0, 8, 6);
        //grid.setValue(1, 8, 3);
        grid.setValue(2, 8, 1);
        grid.setValue(3, 8, 2);
        grid.setValue(4, 8, 5);
        grid.setValue(5, 8, 8);
        grid.setValue(6, 8, 4);


        grid.setFinal();

        return grid;
    }
}
