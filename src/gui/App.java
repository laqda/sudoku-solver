package gui;

import javax.swing.*;

public class App extends JFrame {

    public App() {
        State state = new State();
        Main main = new Main(state);
        this.setContentPane(main);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        state.run();
    }

}
