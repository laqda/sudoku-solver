package gui;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Sudoku extends JPanel implements Observer {

    private State state;

    public Sudoku(State state) {
        setPreferredSize(new Dimension(C.getSudokuWidth(), C.getSudokuHeight()));
        state.grid.addObserver(this);
        this.state = state;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;

        // external border
        g2D.setStroke(C.getSudokuBorderExternal());
        g2D.drawRect(C.getSudokuPadding(),
                     C.getSudokuPadding(),
                     C.getSudokuInternalWidth(),
                     C.getSudokuInternalHeight()
        );

        // squares
        g2D.setStroke(C.getSudokuBorderExternal());
        g2D.drawRect(C.getSudokuPadding() + C.getSudokuSquareWidth(),
                     C.getSudokuPadding(),
                     C.getSudokuSquareWidth(),
                     C.getSudokuInternalHeight()
        );
        g2D.drawRect(C.getSudokuPadding(),
                     C.getSudokuPadding() + C.getSudokuSquareHeight(),
                     C.getSudokuInternalWidth(),
                     C.getSudokuSquareHeight()
        );

        // cells
        g2D.setStroke(C.getSudokuBorderInternal());
        g2D.drawRect(C.getSudokuPadding() + C.getSudokuCellWidth(),
                     C.getSudokuPadding(),
                     C.getSudokuCellWidth(),
                     C.getSudokuInternalHeight()
        );
        g2D.drawRect(C.getSudokuPadding() + C.getSudokuSquareWidth() + C.getSudokuCellWidth(),
                     C.getSudokuPadding(),
                     C.getSudokuCellWidth(),
                     C.getSudokuInternalHeight()
        );
        g2D.drawRect(C.getSudokuPadding() + 2 * C.getSudokuSquareWidth() + C.getSudokuCellWidth(),
                     C.getSudokuPadding(),
                     C.getSudokuCellWidth(),
                     C.getSudokuInternalHeight()
        );
        g2D.drawRect(C.getSudokuPadding(),
                     C.getSudokuPadding() + C.getSudokuCellHeight(),
                     C.getSudokuInternalWidth(),
                     C.getSudokuCellHeight()
        );
        g2D.drawRect(C.getSudokuPadding(),
                     C.getSudokuPadding() + C.getSudokuSquareHeight() + C.getSudokuCellHeight(),
                     C.getSudokuInternalWidth(),
                     C.getSudokuCellHeight()
        );
        g2D.drawRect(C.getSudokuPadding(),
                     C.getSudokuPadding() + 2 * C.getSudokuSquareHeight() + C.getSudokuCellHeight(),
                     C.getSudokuInternalWidth(),
                     C.getSudokuCellHeight()
        );

        // cells value
        for (int i = 0; i < this.state.grid.getSize(); i++) {
            for (int j = 0; j < this.state.grid.getSize(); j++) {
                drawCellValue(g2D, i, j);
            }
        }
    }

    private void drawCellValue(Graphics2D g2D, int x, int y) {
        int value = this.state.grid.getValue(x, y);
        if (this.state.grid.isFinal(x, y)) {
            g2D.setFont(C.getSudokuFontFinal());
        } else {
            g2D.setFont(C.getSudokuFont());
        }
        g2D.drawString(value == 0 ? " " : String.valueOf(value),
                       C.getSudokuPadding() + C.getSudokuCellWidth() / 2 - 5 + x * C.getSudokuCellWidth(),
                       C.getSudokuPadding() + C.getSudokuCellHeight() / 2 + 5 + y * C.getSudokuCellHeight()
        );
    }

    @Override
    public void update(Observable observable, Object o) {
        this.repaint();
    }

}
