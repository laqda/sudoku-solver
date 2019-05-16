package solver;

import consts.Consts;
import grid.Grid;

public class BacktrackingSolver extends Solver {

    public BacktrackingSolver(Grid grid) {
        super(grid);
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
                            this.grid.setValue(i, j, k);
                            if (this.solveR()) {
                                return true;
                            }
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