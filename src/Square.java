import java.util.ArrayList;
import java.util.List;

public class Square {

    private List<Cell> cells;
    private int index;

    public Square(int index) {
        this.cells = new ArrayList<>();
        this.index = index;
    }

    public void addCell(Cell cell) {
        this.cells.add(cell);
    }
}