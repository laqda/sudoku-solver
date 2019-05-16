package grid;

import consts.Consts;

import java.util.List;
import java.util.Observable;

public abstract class Grid extends Observable {

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
        this.setChanged();
        this.notifyObservers();
    }

    public boolean isAllowed(int x, int y, int value) {
        if (value == Consts.UNASSIGNED) {
            return true;
        }
        return !this.getRow(y).contains(value) &&
               !this.getColumn(x).contains(value) &&
               !this.getSquare(x, y).contains(value);
    }

    public void setFinal() {
        for (int i = 0; i < this.getSize(); i++) {
            for (int j = 0; j < this.getSize(); j++) {
                if (this.getValue(i, j) != Consts.UNASSIGNED) {
                    this.getCell(i, j).setFinal();
                }
            }
        }
    }

    public boolean isFinal(int x, int y) {
        return this.getCell(x, y).isFinal();
    }

}
