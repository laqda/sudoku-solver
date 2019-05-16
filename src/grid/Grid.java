package grid;

public abstract class Grid {

    public abstract void display();
    public abstract Square getSquare(int x, int y);
    public abstract Line getRow(int y);
    public abstract Line getColumn(int x);
    public abstract int getSize();
    public abstract int getValue(int x, int y);
    public abstract void setValue(int x, int y, int value);

    public boolean isAllowed(int x, int y, int value) {
        if (value == Consts.UNASSIGNED) {
            return true;
        }
        return !this.getRow(y).contains(value) &&
               !this.getColumn(x).contains(value) &&
               !this.getSquare(x, y).contains(value);
    }
}
