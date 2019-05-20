package generator;

import consts.Consts;
import grid.DefaultGrid;
import grid.Grid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Generator {

    protected Grid grid;
    private boolean isAlreadySolved;

    public Generator(int size) {
        this.grid = new DefaultGrid(size);
        this.isAlreadySolved = false;
    }

    public Grid generate() {
        fillGrid();
        cleanGrid();
        return this.grid;
    }

    private boolean fillGrid() {
        for (int j = 0; j < this.grid.getSize(); j++) {
            for (int i = 0; i < this.grid.getSize(); i++) {
                if (this.grid.getValue(i, j) == Consts.UNASSIGNED) {
                    List<Integer> numberList = randomNumberList(this.grid.getSize());
                    for (int k = 0; k < this.grid.getSize(); k++) {
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

    private List<Integer> randomNumberList(int size) {
        List<Integer> numberList = new ArrayList<>();
        for (int k = 1; k <= size; k++) {
            numberList.add(k);
        }
        Collections.shuffle(numberList);
        return numberList;
    }

    private void cleanGrid() {
        int attemps = 10;
        while (attemps > 1) {
            int x = randomInt(0, 8);
            int y = randomInt(0, 8);
            while (this.grid.getValue(x, y) == Consts.UNASSIGNED) {
                x = randomInt(0, 8);
                y = randomInt(0, 8);
            }
            int value = this.grid.getValue(x, y);
            this.grid.setValue(x, y, Consts.UNASSIGNED);
            Grid copyGrid = copyGrid(this.grid);
            this.isAlreadySolved = false;
            if (gotMultipleSolution(copyGrid)) {
                this.grid.setValue(x, y, value);
                attemps -= 1;
            }
        }
    }

    private int randomInt(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }

    private Grid copyGrid(Grid grid) {
        Grid copyGrid = new DefaultGrid(grid.getSize());
        for (int j = 0; j < grid.getSize(); j++) {
            for (int i = 0; i < grid.getSize(); i++) {
                copyGrid.setValue(i, j, grid.getValue(i, j));
            }
        }
        return copyGrid;
    }

    private boolean gotMultipleSolution(Grid grid) {
        for (int j = 0; j < grid.getSize(); j++) {
            for (int i = 0; i < grid.getSize(); i++) {
                if (grid.getValue(i, j) == Consts.UNASSIGNED) {
                    for (int k = 1; k <= grid.getSize(); k++) {
                        if (grid.isAllowed(i, j, k)) {
                            grid.setValue(i, j, k);
                            if (gotMultipleSolution(grid)) {
                                if (!this.isAlreadySolved) {
                                    this.isAlreadySolved = true;
                                    return false;
                                }
                                return true;
                            }
                            grid.setValue(i, j, Consts.UNASSIGNED);
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

}
