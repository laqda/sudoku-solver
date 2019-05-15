import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Cell> cells;
    private int index;

    public Line(int size, int index) {
        this.cells = new ArrayList<>(size);
        this.index = index;
    }

    public void setCell(int index, Cell cell) {
        this.cells.set(index, cell);
    }
}