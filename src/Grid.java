import java.util.ArrayList;
import java.util.List;

public class Grid {

    private int size;
    private List<Line> rows;
    private List<Line> columns;
    private List<Square> squares;

    public Grid(int size) throws Exception {
        if (size > 16) {
            throw new Exception("Not supported");
        }
        this.size = size;
        this.rows = initLines();
        this.columns = initLines();
        this.squares = initSquares();
        initCells();
    }

    private List<Line> initLines() {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < this.size; i++) {
            Line line = new Line(i);
            lines.add(line);
        }
        return lines;
    }

    private List<Square> initSquares() {
        List<Square> squares = new ArrayList<>();
        for (int i = 0; i < this.size; i++) {
            Square square = new Square(i);
            squares.add(square);
        }
        return squares;
    }

    private void initCells() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                Cell cell = new Cell(i, j, null);
                this.rows.get(j).addCell(cell);
                this.columns.get(i).addCell(cell);
                this.getSquare(i, j).addCell(cell);
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

    public void setCellValue(int x, int y, Integer value) {
        this.rows.get(y).getCell(x).setValue(value);
    }

    private String getCellValue(int x, int y) {
        int value = this.rows.get(y).getCell(x).getValue();
        return value != 0 ? Integer.toHexString(value) : " ";
    }

    public void display() {
        List<String> tmp = new ArrayList<>();
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                tmp.add(this.getCellValue(j, i));
            }
        }
        System.out.println(String.format("╔═══╤═══╤═══╦═══╤═══╤═══╦═══╤═══╤═══╗\n" +
                                         "║ %s │ %s │ %s ║ %s │ %s │ %s ║ %s │ %s │ %s ║\n" +
                                         "╟───┼───┼───╫───┼───┼───╫───┼───┼───╢\n" +
                                         "║ %s │ %s │ %s ║ %s │ %s │ %s ║ %s │ %s │ %s ║\n" +
                                         "╟───┼───┼───╫───┼───┼───╫───┼───┼───╢\n" +
                                         "║ %s │ %s │ %s ║ %s │ %s │ %s ║ %s │ %s │ %s ║\n" +
                                         "╠═══╪═══╪═══╬═══╪═══╪═══╬═══╪═══╪═══╣\n" +
                                         "║ %s │ %s │ %s ║ %s │ %s │ %s ║ %s │ %s │ %s ║\n" +
                                         "╟───┼───┼───╫───┼───┼───╫───┼───┼───╢\n" +
                                         "║ %s │ %s │ %s ║ %s │ %s │ %s ║ %s │ %s │ %s ║\n" +
                                         "╟───┼───┼───╫───┼───┼───╫───┼───┼───╢\n" +
                                         "║ %s │ %s │ %s ║ %s │ %s │ %s ║ %s │ %s │ %s ║\n" +
                                         "╠═══╪═══╪═══╬═══╪═══╪═══╬═══╪═══╪═══╣\n" +
                                         "║ %s │ %s │ %s ║ %s │ %s │ %s ║ %s │ %s │ %s ║\n" +
                                         "╟───┼───┼───╫───┼───┼───╫───┼───┼───╢\n" +
                                         "║ %s │ %s │ %s ║ %s │ %s │ %s ║ %s │ %s │ %s ║\n" +
                                         "╟───┼───┼───╫───┼───┼───╫───┼───┼───╢\n" +
                                         "║ %s │ %s │ %s ║ %s │ %s │ %s ║ %s │ %s │ %s ║\n" +
                                         "╚═══╧═══╧═══╩═══╧═══╧═══╩═══╧═══╧═══╝", tmp.toArray()));
    }
}