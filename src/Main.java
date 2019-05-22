import consts.Configuration;
import generator.Generator;
import grid.Grid;
import gui.App;
import solver.BacktrackingControlledSolver;
import solver.ControlledSolver;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        App app = new App();
        app.setVisible(true);
//        Generator generator = new Generator(16);
//        Grid grid = generator.generate();
//        ControlledSolver solver = new BacktrackingControlledSolver(grid, Configuration.SPEED.NO_LIMIT);
//        solver.start();
//        try {
//            TimeUnit.MILLISECONDS.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        grid.display();
    }

}
