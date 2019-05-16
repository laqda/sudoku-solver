package gui;

import grid.DefaultGrid;
import grid.Grid;
import solver.BacktrackingTimedSolver;
import solver.TimedSolver;

import java.util.concurrent.TimeUnit;

public class State {

    Grid grid;

    public State() {
        this.grid = new DefaultGrid(9);
    }

    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(1200);
            // Init
            this.grid.setValue(0, 0, 2);

            // Solve
            TimedSolver solver = new BacktrackingTimedSolver(grid);
            solver.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
