import java.util.ArrayList;
import java.util.List;

public class Square {

    private List<Cell> cells;
    private int index;
    private int length;

    public Square(int length, int index) {
        this.cells = new ArrayList<>(length * length);
        this.index = index;
        this.length = length;
    }

    public void setCell(int i, int j, Cell cell) {
        int x = i % this.length;
        int y = j % this.length;
        this.cells.set(y * this.length + x, cell);
    }

}