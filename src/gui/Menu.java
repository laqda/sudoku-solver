package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JMenuBar {

    public Menu(State state) {
        JMenu menu = new JMenu("Sudoku generator");

        JMenuItem menuItem1 = new JMenuItem("Easy");
        menuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.generateGrid(1);
            }
        });
        menu.add(menuItem1);

        JMenuItem menuItem2 = new JMenuItem("Medium");
        menuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.generateGrid(5);
            }
        });
        menu.add(menuItem2);

        JMenuItem menuItem3 = new JMenuItem("Difficult");
        menuItem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.generateGrid(10);
            }
        });
        menu.add(menuItem3);

        this.add(menu);
    }




}