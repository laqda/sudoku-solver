package grid;

public interface Grid {

    public void display();
    public Square getSquare(int x, int y);
    public Line getRow(int y);
    public Line getColumn(int x);
    public int getSize();
    public int getValue(int x, int y);
    public void setValue(int x, int y, int value);

}
