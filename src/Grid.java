import java.util.ArrayList;
import java.util.List;

public class Grid {

    private int size;
    private List<Line> rows;
    private List<Line> columns;
    private List<Square> squares;

    public Grid(int size) {
        this.size = size;
        this.rows = initLines();
        this.columns = initLines();
        this.squares = initSquares();
        initCells();
    }

    private List<Line> initLines() {
        List<Line> lines = new ArrayList<>(this.size);
        for (int i = 0; i < this.size; i++) {
            Line line = new Line(this.size, i);
            lines.add(line);
        }
        return lines;
    }

    private List<Square> initSquares() {
        List<Square> squares = new ArrayList<>(this.squareLength());
        for (int i = 0; i < this.size; i++) {
            Square square = new Square(this.size, i);
            squares.add(square);
        }
        return squares;
    }

    private void initCells() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                Cell cell = new Cell(i, j, null);
                this.rows.get(j).setCell(i, cell);
                this.columns.get(i).setCell(j, cell);
                this.getSquare(i, j).setCell(i, j, cell);
            }
        }
    }

    private Square getSquare(int x, int y) {
        int xSquare = x / this.squareLength();
        int ySquare = y / this.squareLength();
        return this.squares.get(ySquare * this.squareLength() + xSquare);
    }

    private int squareLength() {
        return (int) Math.sqrt(this.size);
    }
}