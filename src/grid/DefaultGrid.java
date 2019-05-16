package grid;

import java.util.ArrayList;
import java.util.List;

public class DefaultGrid implements Grid {

    private int size;
    private List<Line> rows;
    private List<Line> columns;
    private List<Square> squares;

    public DefaultGrid(int size) {
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

    @Override
    public Square getSquare(int x, int y) {
        int xSquare = x / this.squareLength();
        int ySquare = y / this.squareLength();
        return this.squares.get(ySquare * this.squareLength() + xSquare);
    }

    @Override
    public Line getRow(int y) {
        return this.rows.get(y);
    }

    @Override
    public Line getColumn(int x) {
        return this.columns.get(x);
    }

    @Override
    public int getSize() {
        return size;
    }

    private int squareLength() {
        return (int) Math.sqrt(this.size);
    }

    private Cell getCell(int x, int y) {
        return this.rows.get(y).getCell(x);
    }

    @Override
    public int getValue(int x, int y) {
        return this.getCell(x, y).getValue();
    }

    @Override
    public void setValue(int x, int y, int value) {
        this.getCell(x, y).setValue(value);
    }

    private String getValueFormated(int x, int y) {
        int value = this.getValue(x, y);
        return value != 0 ? Integer.toHexString(value).toUpperCase() : " ";
    }

    @Override
    public void display() {
        try {
            String format;
            switch (this.size) {
                case 9:
                    format = Consts.GRID_9;
                    break;
                case 16:
                    format = Consts.GRID_16;
                    break;
                default:
                    throw new Exception("grid.DefaultGrid display not supported for size " + this.size);
            }
            List<String> tmp = new ArrayList<>();
            for (int i = 0; i < this.size; i++) {
                for (int j = 0; j < this.size; j++) {
                    tmp.add(this.getValueFormated(j, i));
                }
            }
            System.out.println(String.format(format, tmp.toArray()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}