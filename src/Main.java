import consts.Configuration;
import grid.DefaultGrid;
import grid.Grid;
import gui.App;
import solver.BacktrackingSolver;
import solver.BacktrackingControlledSolver;
import solver.Solver;
import solver.ControlledSolver;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
//        testSolversInTerminal();
        testGUI();
    }

    private static Grid generateGrid() {
        Grid grid = new DefaultGrid(9);
        grid.setValue(0, 0, 2);
        return grid;
    }

    private static void testGUI() {
        App app = new App();
        app.setVisible(true);
    }

    private static void testSolversInTerminal() {
        try {
            testBacktrakingSolver();
            testBacktrakingTimedSolver();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void testBacktrakingSolver() throws InterruptedException {
        // Init
        Grid grid = generateGrid();

        // Solve
        Solver solver = new BacktrackingSolver(grid);
        solver.start();

        // Display
        while (solver.isAlive()) {
            TimeUnit.MILLISECONDS.sleep(Configuration.TIMER_WAIT);
            grid.display();
        }
    }

    private static void testBacktrakingTimedSolver() throws InterruptedException {
        // Init
        Grid grid = generateGrid();

        // Solve
        ControlledSolver solver = new BacktrackingControlledSolver(grid);
        solver.setSpeed(Configuration.SPEED.FAST);
        solver.start();

        // Display
        while (solver.isAlive()) {
            TimeUnit.MILLISECONDS.sleep(Configuration.TIMER_WAIT);
            grid.display();
        }
    }

}
