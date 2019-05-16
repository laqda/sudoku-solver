package grid;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Cell> cells;
    private int index;

    public Line(int index) {
        this.cells = new ArrayList<>();
        this.index = index;
    }

    public void addCell(Cell cell) {
        this.cells.add(cell);
    }

    public Cell getCell(int index) {
        return this.cells.get(index);
    }

    public boolean contains(int value) {
        for (Cell cell : cells) {
            if (cell.getValue() == value) {
                return true;
            }
        }
        return false;
    }

}