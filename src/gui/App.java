package gui;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {

    public App() {
        State state = new State();
        Main main = new Main(state);
        this.setContentPane(main);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        this.setPreferredSize(new Dimension(C.getAppWidth(), C.getAppHeight()));
        this.setResizable(false);
        state.run();
    }

}
