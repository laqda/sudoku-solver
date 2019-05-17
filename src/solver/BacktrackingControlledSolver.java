package solver;

import consts.Configuration;
import consts.Consts;
import grid.Grid;

public class BacktrackingControlledSolver extends ControlledSolver {

    public BacktrackingControlledSolver(Grid grid) {
        super(grid);
    }

    public BacktrackingControlledSolver(Grid grid, Configuration.SPEED speed) {
        super(grid, speed);
    }

    @Override
    protected void solve() {
        solveR();
    }

    private boolean solveR() {
        for (int j = 0; j < this.grid.getSize(); j++) { // y
            for (int i = 0; i < this.grid.getSize(); i++) { // x
                if (this.grid.getValue(i, j) == Consts.UNASSIGNED) {
                    for (int k = 1; k <= this.grid.getSize(); k++) { // test values between 1 and 9
                        if (this.grid.isAllowed(i, j, k)) {
                            this.await();
                            this.grid.setValue(i, j, k);
                            if (this.solveR()) {
                                return true;
                            }
                            this.await();
                            this.grid.setValue(i, j, Consts.UNASSIGNED);
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

}