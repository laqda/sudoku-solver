package gui;

import consts.Configuration;
import generator.Generator;
import grid.DefaultGrid;
import grid.Grid;
import solver.BacktrackingControlledSolver;
import solver.ControlledSolver;

public class State {

    Grid grid;
    private ControlledSolver solver;
    private Generator generator;
    private Configuration.SPEED runningSpeed = Configuration.SPEED.SLOW;
    private boolean shouldInitSolver;

    public State() {
        this.grid = new DefaultGrid(9);
    }

    public void run() {
        this.solver.start();
    }

    private void setSpeed(Configuration.SPEED speed) {
        if (this.solver != null) {
            this.solver.setSpeed(speed);
        }
    }

    public void handleChangeSpeed(Configuration.SPEED speed) {
        if (this.solver.getSpeed().running()) {
            this.setSpeed(speed);
        }
        this.runningSpeed = speed;
    }

    public void play() {
        if (shouldInitSolver) {
            this.solver = new BacktrackingControlledSolver(this.grid);
            this.pause();
            this.run();
            this.shouldInitSolver = false;
        }
        this.setSpeed(this.runningSpeed);
    }

    public void pause() {
        this.setSpeed(Configuration.SPEED.STEP_BY_STEP);
    }

    public void next() {
        this.pause();
        if (this.solver != null) {
            this.solver.next();
        }
    }

    public void complete() {
        this.play();
        this.setSpeed(Configuration.SPEED.NO_LIMIT);
    }

    public int getSpeed() {
        return this.runningSpeed.getSpeed();
    }

    private int randomInt(int min, int max) {
        return min + (int) (Math.random() * (max - min) + 1);
    }

    public void generateGrid(int attemps) {
        if (this.solver != null) {
            this.solver.interrupt();
            try {
                this.solver.join();
            } catch (InterruptedException ignored) {
            }
        }
        this.grid.empty();
        this.generator = new Generator(this.grid);
        generator.generate(attemps);
        this.grid.setFinal();
        this.shouldInitSolver = true;
    }

}
