package gui;

import consts.Configuration;
import grid.DefaultGrid;
import grid.Grid;
import solver.BacktrackingTimedSolver;
import solver.TimedSolver;

public class State {

    Grid grid;

    public State() {
        this.grid = new DefaultGrid(9);
    }

    public void run() {
        // Init
        this.grid.setValue(0, 0, 5);
        this.grid.setValue(1, 0, 3);
        this.grid.setValue(4, 0, 7);
        this.grid.setValue(0, 1, 6);
        this.grid.setValue(3, 1, 1);
        this.grid.setValue(4, 1, 9);
        this.grid.setValue(5, 1, 5);
        this.grid.setValue(1, 2, 9);
        this.grid.setValue(2, 2, 8);
        this.grid.setValue(7, 2, 6);
        this.grid.setValue(0, 3, 8);
        this.grid.setValue(4, 3, 6);
        this.grid.setValue(8, 3, 3);
        this.grid.setValue(0, 4, 4);
        this.grid.setValue(3, 4, 8);
        this.grid.setValue(5, 4, 3);
        this.grid.setValue(8, 4, 1);
        this.grid.setValue(0, 5, 7);
        this.grid.setValue(4, 5, 2);
        this.grid.setValue(8, 5, 6);
        this.grid.setValue(1, 6, 6);
        this.grid.setValue(6, 6, 2);
        this.grid.setValue(7, 6, 8);
        this.grid.setValue(3, 7, 4);
        this.grid.setValue(4, 7, 1);
        this.grid.setValue(5, 7, 9);
        this.grid.setValue(8, 7, 5);
        this.grid.setValue(4, 8, 8);
        this.grid.setValue(7, 8, 7);
        this.grid.setValue(8, 8, 9);

        this.grid.setFinal();

        // Solve
        TimedSolver solver = new BacktrackingTimedSolver(grid);
        solver.setTimerWait(Configuration.TIMER_WAIT);
        solver.start();
    }

}
