package grid;

import consts.Consts;

import java.util.List;

public abstract class Grid {

    public abstract void display();
    public abstract Square getSquare(int x, int y);
    public abstract List<Line> getRows();
    public abstract List<Line> getColumns();
    public abstract List<Square> getSquares();
    public abstract int getSize();
    protected abstract Cell getCell(int x, int y);

    public Line getRow(int y) {
        return this.getRows().get(y);
    }

    public Line getColumn(int x) {
        return this.getColumns().get(x);
    }

    public int getValue(int x, int y) {
        return this.getCell(x, y).getValue();
    }

    public void setValue(int x, int y, int value) {
        this.getCell(x, y).setValue(value);
    }

    public boolean isAllowed(int x, int y, int value) {
        if (value == Consts.UNASSIGNED) {
            return true;
        }
        return !this.getRow(y).contains(value) &&
               !this.getColumn(x).contains(value) &&
               !this.getSquare(x, y).contains(value);
    }

}
