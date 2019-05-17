package gui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class Main extends JPanel {

    public Main(State state) {
        this.setBackground(new Color(255, 255, 255));
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        Sudoku sudoku = new Sudoku(state);
        this.add(sudoku);

        Form form = new Form(state);
        this.add(form);
    }

}
