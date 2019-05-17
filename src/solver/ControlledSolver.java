package solver;

import consts.Configuration;
import grid.Grid;

public abstract class ControlledSolver extends Solver {

    private SpeedLocker speedLocker;
    private Timer timer;
    protected Grid grid;

    public ControlledSolver(Grid grid) {
        super(grid);
        this.grid = grid;
        this.speedLocker = new SpeedLocker();
        this.timer = new Timer(this.speedLocker);
    }

    public ControlledSolver(Grid grid, Configuration.SPEED speed) {
        this(grid);
        this.timer.setSpeed(speed);
    }

    public void next() {
        if (this.timer.getSpeed() != Configuration.SPEED.STEP_BY_STEP) {
            return;
        }
        this.speedLocker.signal();
    }

    protected void await() {
        this.speedLocker.await();
    }

    public void setSpeed(Configuration.SPEED speed) {
        this.timer.setSpeed(speed);
        System.out.println(speed);
    }

    @Override
    public synchronized void start() {
        super.start();
        this.timer.start();
    }

    @Override
    public void interrupt() {
        this.timer.interrupt();
        super.interrupt();
    }

    public Configuration.SPEED getSpeed() {
        return this.timer.getSpeed();
    }

}
