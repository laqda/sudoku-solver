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
        this.grid.setValue(0, 0, 2);

        // Solve
        TimedSolver solver = new BacktrackingTimedSolver(grid);
        solver.setTimerWait(Configuration.TIMER_WAIT);
        solver.start();
    }

}
