package solver;

import grid.Grid;

public class BacktrackingTimedSolver extends TimedSolver {

    public BacktrackingTimedSolver(Grid grid) {
        super(grid);
    }

    @Override
    protected void solve() {
        this.await();
        this.grid.setValue(0, 0, 4);
        this.await();
        this.grid.setValue(0, 1, 5);
    }

}