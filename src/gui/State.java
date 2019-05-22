package gui;

import consts.Configuration;
import generator.Generator;
import grid.DefaultGrid;
import grid.Grid;
import solver.BacktrackingControlledSolver;
import solver.BacktrackingSolver;
import solver.ControlledSolver;
import solver.Solver;

import java.util.concurrent.TimeUnit;

public class State {

    Grid grid;
    private ControlledSolver solver;
    private Generator generator;
    private Configuration.SPEED runningSpeed = Configuration.SPEED.SLOW;

    public State() {
        this.grid = new DefaultGrid(9);
    }

    public void run() {
        this.solver.start();
    }

    private void setSpeed(Configuration.SPEED speed) {
        this.solver.setSpeed(speed);
    }

    public void handleChangeSpeed(Configuration.SPEED speed) {
        if (this.solver.getSpeed().running()) {
            this.setSpeed(speed);
        }
        this.runningSpeed = speed;
    }

    public void play() {
        this.setSpeed(this.runningSpeed);
    }

    public void pause() {
        this.setSpeed(Configuration.SPEED.STEP_BY_STEP);
    }

    public void next() {
        this.solver.next();
    }

    public void complete() {
        this.setSpeed(Configuration.SPEED.NO_LIMIT);
    }

    public int getSpeed() {
        return this.runningSpeed.getSpeed();
    }

    private int randomInt(int min, int max) {
        return min + (int) (Math.random() * (max - min) + 1);
    }

    public void generateGrid(int attemps) {
        this.generator = new Generator(this.grid);
        generator.generate(attemps);
        this.grid.setFinal();
        // Solve
        this.solver = new BacktrackingControlledSolver(this.grid);
        this.pause();
        this.run();
    }

}
