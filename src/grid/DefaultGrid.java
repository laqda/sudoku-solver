package grid;

import consts.Consts;

import java.util.ArrayList;
import java.util.List;

public class DefaultGrid extends Grid {

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
                Cell cell = new Cell(i, j, Consts.UNASSIGNED);
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
    public List<Line> getRows() {
        return rows;
    }

    @Override
    public List<Line> getColumns() {
        return columns;
    }

    @Override
    public List<Square> getSquares() {
        return squares;
    }

    @Override
    public int getSize() {
        return size;
    }

    private int squareLength() {
        return (int) Math.sqrt(this.size);
    }

    @Override
    protected Cell getCell(int x, int y) {
        return this.rows.get(y).getCell(x);
    }

    private String getValueFormated(int x, int y) {
        int value = this.getValue(x, y);
        if (this.size == 16) {
            value--;
            return value != Consts.UNASSIGNED - 1 ? Integer.toHexString(value).toUpperCase() : " ";
        }
        return value != Consts.UNASSIGNED ? Integer.toHexString(value).toUpperCase() : " ";
    }

    @Override
    public void display() {
        try {
            String format;
            switch (this.size) {
                case 4:
                    format = Consts.GRID_4;
                    break;
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