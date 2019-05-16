import grid.DefaultGrid;
import grid.Grid;
import solver.BacktrackingTimedSolver;
import solver.TimedSolver;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        try {
            test();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void test() throws InterruptedException {
        // Init
        Grid grid = new DefaultGrid(9);
        grid.setValue(0, 0, 2);

        // Solve
        TimedSolver solver = new BacktrackingTimedSolver(grid);
        solver.setTimerWait(Configuration.TIMER_WAIT);
        solver.start();

        // Display
        while (solver.isAlive()) {
            TimeUnit.MILLISECONDS.sleep(Configuration.TIMER_WAIT_RENDER);
            grid.display();
        }
    }

}
