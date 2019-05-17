package gui;

import java.awt.*;

class C {

    private static final int padding = 30;
    private static final int sudokuBorderExternal = 2;
    private static final int sudokuBorderInternal = 1;
    private static final int sudokuWidth = 410;
    private static final int sudokuHeight = 410;
    private static final Font sudokuFontFinal = new Font("Helvetica", Font.BOLD, 16);
    private static final Font sudokuFont = new Font("Helvetica", Font.PLAIN, 16);
    private static final int formHeight = 100;
    private static final int sliderHeight = 70;
    private static final int btnWidth = 40;
    private static final int btnHeight = 40;

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
        return sudokuWidth - 2 * padding - 2 * sudokuBorderExternal;
    }

    static int getSudokuInternalHeight() {
        return sudokuHeight - padding;
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

    public static int getSliderHeight() {
        return sliderHeight;
    }

    public static int getBtnWidth() {
        return btnWidth;
    }

    public static int getBtnHeight() {
        return btnHeight;
    }

}
