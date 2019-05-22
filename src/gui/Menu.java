package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Menu extends JMenuBar {

    public Menu(State state) {
        JMenu menu = new JMenu("Sudoku generator");

        Map<String, Integer> difficulties = new HashMap<>();
        difficulties.put("Easy", 1);
        difficulties.put("Medium", 3);
        difficulties.put("Difficult", 20);

        difficulties.forEach((text, difficulty) -> {
            JMenuItem item = new JMenuItem(text);
            item.addActionListener(e -> state.generateGrid(difficulty));
            menu.add(item);
        });

        this.add(menu);
    }
}