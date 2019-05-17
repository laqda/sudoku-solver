package gui;

import javax.swing.*;
import java.awt.*;

public class Main extends JPanel {

    public Main(State state) {
        this.setBackground(Color.WHITE);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(C.getAppWidth(), C.getAppHeight()));

        Sudoku sudoku = new Sudoku(state);
        this.add(sudoku);

        Form form = new Form(state);
        this.add(form);
    }

}
