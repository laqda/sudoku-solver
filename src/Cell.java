public class Cell {

    private Integer value;
    private int x;
    private int y;

    public Cell(int x, int y, Integer value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}