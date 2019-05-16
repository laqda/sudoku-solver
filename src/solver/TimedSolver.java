package solver;

import grid.Grid;

public abstract class TimedSolver extends Solver {

    protected TimeLocker locker;
    private Timer timer;

    public TimedSolver(Grid grid) {
        super(grid);
        this.locker = new TimeLocker();
        this.timer = new Timer(this.locker);
        this.timer.start();
    }

    protected void await() {
        this.locker.lock();
        try {
            this.locker.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        this.locker.unlock();
    }

    @Override
    public void interrupt() {
        this.timer.interrupt();
        super.interrupt();
    }

    public void setTimerWait(int timerWait) {
        this.timer.setWait(timerWait);
    }

}
