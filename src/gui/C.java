package gui;

import java.awt.*;

class C {

    private static final int padding = 10;
    private static final int sudokuBorderExternal = 2;
    private static final int sudokuBorderInternal = 1;
    private static final int sudokuWidth = 320;
    private static final int sudokuHeight = 320;
    private static final Font sudokuFontFinal = new Font("Helvetica", Font.BOLD, 16);
    private static final Font sudokuFont = new Font("Helvetica", Font.PLAIN, 16);
    private static final int formHeight = 50;

    static BasicStroke getSudokuBorderExternal() {
        return new BasicStroke(sudokuBorderExternal);
    }

    static BasicStroke getSudokuBorderInternal() {
        return new BasicStroke(sudokuBorderInternal);
    }

    static int getPadding() {
        return padding;
    }

    static int getSudokuWidth() {
        return sudokuWidth;
    }

    static int getSudokuHeight() {
        return sudokuHeight;
    }

    static int getSudokuInternalWidth() {
        return sudokuWidth - 2 * padding;
    }

    static int getSudokuInternalHeight() {
        return sudokuHeight - 2 * padding;
    }

    static int getSudokuSquareWidth() {
        return getSudokuInternalWidth() / 3;
    }

    static int getSudokuSquareHeight() {
        return getSudokuInternalHeight() / 3;
    }

    static int getSudokuCellWidth() {
        return getSudokuInternalWidth() / 9;
    }

    static int getSudokuCellHeight() {
        return getSudokuInternalHeight() / 9;
    }

    public static Font getSudokuFontFinal() {
        return sudokuFontFinal;
    }

    public static Font getSudokuFont() {
        return sudokuFont;
    }

    public static int getAppWidth() {
        return sudokuWidth;
    }

    public static int getAppHeight() {
        return formHeight + sudokuHeight + 2 * padding;
    }

    public static int getFormWidth() {
        return getAppWidth() - 2 * padding;
    }

    public static int getFormHeight() {
        return formHeight;
    }

}
