package gui;

import java.awt.*;

class C {

    private static final int sudokuBorderExternal = 2;
    private static final int sudokuBorderInternal = 1;
    private static final int sudokuPadding = 10;
    private static final int sudokuWidth = 320;
    private static final int sudokuHeight = 320;

    static BasicStroke getSudokuBorderExternal() {
        return new BasicStroke(sudokuBorderExternal);
    }

    static BasicStroke getSudokuBorderInternal() {
        return new BasicStroke(sudokuBorderInternal);
    }

    static int getSudokuPadding() {
        return sudokuPadding;
    }

    static int getSudokuWidth() {
        return sudokuWidth;
    }

    static int getSudokuHeight() {
        return sudokuHeight;
    }

    static int getSudokuInternalWidth() {
        return sudokuWidth - 2 * sudokuPadding;
    }

    static int getSudokuInternalHeight() {
        return sudokuHeight - 2 * sudokuPadding;
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
}
