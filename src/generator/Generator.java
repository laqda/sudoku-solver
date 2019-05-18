package generator;

import consts.Consts;
import grid.DefaultGrid;
import grid.Grid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Generator {

    protected Grid grid;
    private int counter;

    public Generator(int size) {
        this.grid = new DefaultGrid(size);
    }

    public Grid generate() {
        fillGrid();
        cleanGrid();
        return this.grid;
    }

    private boolean fillGrid() {
        for (int j = 0; j < this.grid.getSize(); j++) { // y
            for (int i = 0; i < this.grid.getSize(); i++) { // x
                if (this.grid.getValue(i, j) == Consts.UNASSIGNED) {
                    List<Integer> numberList = new ArrayList<>();
                    for (int k = 1; k <= this.grid.getSize(); k++) {
                        numberList.add(k);
                    }
                    Collections.shuffle(numberList);
                    for (int k = 0; k < this.grid.getSize(); k++) { // test values between 1 and 9
                        if (this.grid.isAllowed(i, j, numberList.get(k))) {
                            this.grid.setValue(i, j, numberList.get(k));
                            if (this.fillGrid()) {
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

    private void cleanGrid() {
        int attemps = 10;
        while (attemps > 0) {
            int x = randomInt(0, 8);
            int y = randomInt(0, 8);
            while (this.grid.getValue(x, y) == Consts.UNASSIGNED) {
                x = randomInt(0, 8);
                y = randomInt(0, 8);
            }
            int value = this.grid.getValue(x, y);
            this.grid.setValue(x, y, Consts.UNASSIGNED);
            Grid copyGrid = copyGrid();
            this.counter = 0;
            solveGrid(copyGrid);
            if (this.counter != 1) {
                this.grid.setValue(x, y, value);
                attemps -= 1;
            }
        }
    }

    private int randomInt(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }

    private Grid copyGrid() {
        Grid copyGrid = new DefaultGrid(this.grid.getSize());
        for (int j = 0; j < this.grid.getSize(); j++) { // y
            for (int i = 0; i < this.grid.getSize(); i++) {
                copyGrid.setValue(i, j, this.grid.getValue(i, j));
            }
        }
        return copyGrid;
    }

    private boolean solveGrid(Grid grid) {
        for (int j = 0; j < grid.getSize(); j++) { // y
            for (int i = 0; i < grid.getSize(); i++) { // x
                if (grid.getValue(i, j) == Consts.UNASSIGNED) {
                    for (int k = 1; k <= grid.getSize(); k++) {
                        if (grid.isAllowed(i, j, k)) {
                            grid.setValue(i, j, k);
                            if (checkGrid(grid)) {
                                this.counter += 1;
                                break;
                            }
                            else {
                                if (solveGrid(grid)) {
                                    return true;
                                }
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkGrid(Grid grid) {
        for (int j = 0; j < grid.getSize(); j++) { // y
            for (int i = 0; i < grid.getSize(); i++) { // x
                if (grid.getValue(i, j) == Consts.UNASSIGNED) {
                    return false;
                }
            }
        }
        return true;
    }

}
