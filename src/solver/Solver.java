package solver;

import grid.Grid;

public abstract class Solver extends Thread {

    protected Grid grid;

    protected abstract void solve();

    public Solver(Grid grid) {
        this.grid = grid;
    }

    @Override
    public void run() {
        this.solve();
        Thread.currentThread().interrupt();
    }

}