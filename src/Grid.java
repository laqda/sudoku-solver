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
                Cell cell = new Cell(i, j, 0);
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
        return value != 0 ? Integer.toHexString(value).toUpperCase() : " ";
    }

    public void display() throws Exception {
        String format;
        switch (this.size) {
            case 9:
                format = GRID_9;
                break;
            case 16:
                format = GRID_16;
                break;
            default:
                throw new Exception("Grid display not supported for size " + this.size);
        }
        List<String> tmp = new ArrayList<>();
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                tmp.add(this.getCellValue(j, i));
            }
        }
        System.out.println(String.format(format, tmp.toArray()));
    }

    private static final String GRID_9 = "╔═══╤═══╤═══╦═══╤═══╤═══╦═══╤═══╤═══╗\n" +
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
                                         "╚═══╧═══╧═══╩═══╧═══╧═══╩═══╧═══╧═══╝";
    private static final String GRID_16 = "╔═══╤═══╤═══╤═══╦═══╤═══╤═══╤═══╦═══╤═══╤═══╤═══╦═══╤═══╤═══╤═══╗\n" +
                                          "║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║\n" +
                                          "╟───┼───┼───┼───╫───┼───┼───┼───╫───┼───┼───┼───╢───┼───┼───┼───╢\n" +
                                          "║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║\n" +
                                          "╟───┼───┼───┼───╫───┼───┼───┼───╫───┼───┼───┼───╢───┼───┼───┼───╢\n" +
                                          "║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║\n" +
                                          "╟───┼───┼───┼───╫───┼───┼───┼───╫───┼───┼───┼───╢───┼───┼───┼───╢\n" +
                                          "║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║\n" +
                                          "╠═══╪═══╪═══╪═══╬═══╪═══╪═══╪═══╬═══╪═══╪═══╪═══╣═══╪═══╪═══╪═══╣\n" +
                                          "║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║\n" +
                                          "╟───┼───┼───┼───╫───┼───┼───┼───╫───┼───┼───┼───╢───┼───┼───┼───╢\n" +
                                          "║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║\n" +
                                          "╟───┼───┼───┼───╫───┼───┼───┼───╫───┼───┼───┼───╢───┼───┼───┼───╢\n" +
                                          "║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║\n" +
                                          "╟───┼───┼───┼───╫───┼───┼───┼───╫───┼───┼───┼───╢───┼───┼───┼───╢\n" +
                                          "║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║\n" +
                                          "╠═══╪═══╪═══╪═══╬═══╪═══╪═══╪═══╬═══╪═══╪═══╪═══╣═══╪═══╪═══╪═══╣\n" +
                                          "║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║\n" +
                                          "╟───┼───┼───┼───╫───┼───┼───┼───╫───┼───┼───┼───╢───┼───┼───┼───╢\n" +
                                          "║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║\n" +
                                          "╟───┼───┼───┼───╫───┼───┼───┼───╫───┼───┼───┼───╢───┼───┼───┼───╢\n" +
                                          "║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║\n" +
                                          "╟───┼───┼───┼───╫───┼───┼───┼───╫───┼───┼───┼───╢───┼───┼───┼───╢\n" +
                                          "║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║\n" +
                                          "╠═══╪═══╪═══╪═══╬═══╪═══╪═══╪═══╬═══╪═══╪═══╪═══╣═══╪═══╪═══╪═══╣\n" +
                                          "║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║\n" +
                                          "╟───┼───┼───┼───╫───┼───┼───┼───╫───┼───┼───┼───╢───┼───┼───┼───╢\n" +
                                          "║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║\n" +
                                          "╟───┼───┼───┼───╫───┼───┼───┼───╫───┼───┼───┼───╢───┼───┼───┼───╢\n" +
                                          "║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║\n" +
                                          "╟───┼───┼───┼───╫───┼───┼───┼───╫───┼───┼───┼───╢───┼───┼───┼───╢\n" +
                                          "║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║ %s │ %s │ %s │ %s ║\n" +
                                          "╚═══╧═══╧═══╧═══╩═══╧═══╧═══╧═══╩═══╧═══╧═══╧═══╩═══╧═══╧═══╧═══╝";

}