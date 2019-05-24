package solver;

import generator.Generator;
import grid.DefaultGrid;
import grid.Grid;
import tree.Node;

import java.util.*;


public class GraphGenerator {

    public static void main(String[] args) {


        Node<Grid> visitedNode;
        Grid rootGrid = new DefaultGrid(9);
        Grid visitedGrid;
        Grid nextGrid;

        Generator generator = new Generator(rootGrid);
        generator.generate(1);

        rootGrid.display();

        int[] target = new int[]{0, 0};


//        rootGrid.setValue(0, 0, 2);
//        rootGrid.setValue(1, 0, 8);
//        rootGrid.setValue(2, 0, 3);
//        rootGrid.setValue(3, 0, 5);
//        rootGrid.setValue(4, 0, 1);
//        rootGrid.setValue(5, 0, 9);
//        rootGrid.setValue(6, 0, 7);
//        rootGrid.setValue(7, 0, 4);
//        rootGrid.setValue(8, 0, 6);
//
//        rootGrid.setValue(0, 1, 9);
//        rootGrid.setValue(1, 1, 6);
//        rootGrid.setValue(2, 1, 4);
//        rootGrid.setValue(3, 1, 8);
//        rootGrid.setValue(4, 1, 7);
//        rootGrid.setValue(5, 1, 3);
//        rootGrid.setValue(6, 1, 5);
//        rootGrid.setValue(7, 1, 2);
//        rootGrid.setValue(8, 1, 1);
//
//        rootGrid.setValue(0, 2, 5);
//        rootGrid.setValue(1, 2, 1);
//        rootGrid.setValue(2, 2, 7);
//        rootGrid.setValue(3, 2, 6);
//        rootGrid.setValue(4, 2, 2);
//        rootGrid.setValue(5, 2, 4);
//        rootGrid.setValue(6, 2, 9);
//        rootGrid.setValue(7, 2, 3);
//        rootGrid.setValue(8, 2, 8);
//
//        rootGrid.setValue(0, 3, 1);
//        rootGrid.setValue(1, 3, 5);
//        rootGrid.setValue(2, 3, 6);
//        rootGrid.setValue(3, 3, 7);
//        rootGrid.setValue(4, 3, 4);
//        rootGrid.setValue(5, 3, 2);
//        rootGrid.setValue(6, 3, 3);
//        rootGrid.setValue(7, 3, 8);
//        rootGrid.setValue(8, 3, 9);
//
//        rootGrid.setValue(0, 4, 4);
//        rootGrid.setValue(1, 4, 2);
//        rootGrid.setValue(2, 4, 9);
//        rootGrid.setValue(3, 4, 3);
//        rootGrid.setValue(4, 4, 8);
//        rootGrid.setValue(5, 4, 6);
//        rootGrid.setValue(6, 4, 1);
//        rootGrid.setValue(7, 4, 7);
//        rootGrid.setValue(8, 4, 5);
//
//        rootGrid.setValue(0, 5, 3);
//        rootGrid.setValue(1, 5, 7);
//        rootGrid.setValue(2, 5, 8);
//        rootGrid.setValue(3, 5, 1);
//        rootGrid.setValue(4, 5, 9);
//        rootGrid.setValue(5, 5, 5);
//        rootGrid.setValue(6, 5, 2);
//        rootGrid.setValue(7, 5, 6);
//        rootGrid.setValue(8, 5, 4);
//
//        rootGrid.setValue(0, 6, 8);
//        rootGrid.setValue(1, 6, 9);
//        rootGrid.setValue(2, 6, 5);
//        rootGrid.setValue(3, 6, 4);
//        rootGrid.setValue(4, 6, 3);
//        rootGrid.setValue(5, 6, 7);
//        rootGrid.setValue(6, 6, 6);
//        rootGrid.setValue(7, 6, 1);
//        rootGrid.setValue(8, 6, 2);
//
//        rootGrid.setValue(0, 7, 7);
//        rootGrid.setValue(1, 7, 4);
//        rootGrid.setValue(2, 7, 2);
//        rootGrid.setValue(3, 7, 9);
//        rootGrid.setValue(4, 7, 6);
//        rootGrid.setValue(5, 7, 1);
//        rootGrid.setValue(6, 7, 8);
//        rootGrid.setValue(7, 7, 5);
//        rootGrid.setValue(8, 7, 3);
//
//        rootGrid.setValue(0, 8, 6);
//        rootGrid.setValue(1, 8, 3);
//        rootGrid.setValue(2, 8, 1);
//        rootGrid.setValue(3, 8, 2);
//        rootGrid.setValue(4, 8, 5);
//        rootGrid.setValue(5, 8, 8);
//        rootGrid.setValue(6, 8, 4);
//
//
//        rootGrid.setFinal();
//
//        rootGrid.display();

        //Generator generator = new Generator(rootGrid);
        //generator.generate(1);

        //rootGrid.display();

        Node<Grid> rootNode = new Node<>(rootGrid);
        Queue<Node<Grid>> q = new LinkedList<>();
        q.add(rootNode);


        while (!q.isEmpty()) {
            visitedNode = q.poll();
            visitedGrid = visitedNode.getData();
            //visitedGrid.display();
            if (!visitedGrid.isFilled()){
                target = visitedGrid.nextUnassignedValue(target[0], target[1]);
                for (int cellFill = 1; cellFill <= 9; cellFill++) {
                    //System.out.println("cell fill :" + cellFill);

                    nextGrid = Generator.copyGrid(visitedGrid);
                    nextGrid.setValue(target[0], target[1], cellFill);
                    //nextGrid.display();
                    visitedNode.addChild(nextGrid);
                    Node<Grid> child = new Node<>(nextGrid);
                    //System.out.println("Added new grid with " + cellFill + " in position : " + target[0] +", "+target[1]);
                    q.add(child);

                }
                target = visitedGrid.nextUnassignedValue(target[0]+1, target[1]);
            }

        }

        //List<Node<Grid>> rn = rootNode.getChildren();


//        while (!q.isEmpty()) {
//                    visitedNode = q.poll();
//                    visitedGrid = visitedNode.getData();
//                    //visitedGrid.display();
//
//
//
//                    for (int i = 0; i < visitedGrid.emptyCellsRemaining(); i++) {
//                        target = visitedGrid.nextUnassignedValue(target[0], target[1]);
//                        //System.out.println(1+"FOR LOOP");
//                        for (int cellFill = 1; cellFill <= 9; cellFill++) {
//                            //System.out.println("cell fill :" + cellFill);
//                            nextGrid = Generator.copyGrid(visitedGrid);
//                            nextGrid.setValue(target[0], target[1], cellFill);
//                            //nextGrid.display();
//                            visitedNode.addChild(nextGrid);
//                            Node<Grid> child = new Node<>(nextGrid);
//                            //System.out.println("Added new grid with " + cellFill + " in position : " + target[0] +", "+target[1]);
//                            q.add(child);
//                        }
//                        target = visitedGrid.nextUnassignedValue(target[0]+1, target[1]);
//                    }
//                }



}
}
