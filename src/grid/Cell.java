package grid;

public class Cell {

    private int value;
    private int x;
    private int y;
    private boolean finalValue;

    public Cell(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
        this.finalValue = false;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setFinal() {
        this.finalValue = true;
    }

    public boolean isFinal() {
        return this.finalValue;
    }

}