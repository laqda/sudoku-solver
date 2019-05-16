package solver;

import grid.Grid;

public class BacktrackingSolver extends Solver {

    public BacktrackingSolver(Grid grid) {
        super(grid);
    }

    @Override
    protected void solve() {
        this.grid.setValue(0, 0, 4);
        this.grid.setValue(0, 1, 5);
    }

}