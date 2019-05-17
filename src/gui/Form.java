package gui;

import consts.Configuration;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class Form extends JPanel {

    State state;

    public Form(State state) {
        this.state = state;
        this.setPreferredSize(new Dimension(C.getFormWidth(), C.getFormHeight()));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(createBtns());
        this.add(createSilder());
    }

    private int adjustSpeedToValue(int speed) {
        return (int) Math.log10(speed);
    }

    private int adjustValueToSpeed(int value) {
        return (int) Math.pow(10, value);
    }

    private JPanel createSilder() {
        JSlider slider = new JSlider(
                JSlider.HORIZONTAL,
                adjustSpeedToValue(Configuration.SPEED.FAST.getSpeed()),
                adjustSpeedToValue(Configuration.SPEED.SLOW.getSpeed()),
                adjustSpeedToValue(this.state.getSpeed())
        );
        slider.setPaintTicks(true);
        slider.setBackground(Color.WHITE);
        slider.setPreferredSize(new Dimension(C.getFormWidth(), C.getSliderHeight()));

        Hashtable<Integer, JLabel> labels = new Hashtable<>();
        labels.put(adjustSpeedToValue(Configuration.SPEED.SLOW.getSpeed()), new JLabel("SLOW"));
        labels.put(adjustSpeedToValue(Configuration.SPEED.MEDIUM.getSpeed()), new JLabel("MEDIUM"));
        labels.put(adjustSpeedToValue(Configuration.SPEED.FAST.getSpeed()), new JLabel("FAST"));
        slider.setLabelTable(labels);

        slider.setPaintLabels(true);

        slider.addChangeListener(changeEvent -> {
            Object source = changeEvent.getSource();
            if (source instanceof JSlider) {
                JSlider sliderSource = (JSlider) source;
                if (!sliderSource.getValueIsAdjusting()) {
                    this.state.handleChangeSpeed(Configuration.SPEED.getSpeed(adjustValueToSpeed(sliderSource.getValue())));
                }
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        panel.add(slider, c);
        panel.setMaximumSize(new Dimension(C.getAppWidth(), C.getSliderHeight()));
        panel.setBackground(Color.WHITE);
        return panel;
    }

    private JPanel createBtns() {
        JPanel btns = new JPanel();
        btns.setLayout(new FlowLayout(FlowLayout.CENTER));
        btns.setPreferredSize(new Dimension(C.getFormWidth(), C.getFormHeight() - C.getSliderHeight()));
        btns.setBackground(Color.WHITE);

        JPanel end = new JPanel();
        end.setLayout(new FlowLayout(FlowLayout.LEFT));
        end.setBackground(Color.WHITE);

        JPanel start = new JPanel();
        start.setLayout(new FlowLayout(FlowLayout.RIGHT));
        start.setBackground(Color.WHITE);

        JButton play = createBtn("play.png");
        play.addActionListener(actionEvent -> this.state.play());
        end.add(play);

        JButton pause = createBtn("pause.png");
        pause.addActionListener(actionEvent -> this.state.pause());
        end.add(pause);

        JButton next = createBtn("next.png");
        next.addActionListener(actionEvent -> this.state.next());
        start.add(next);

        JButton complete = createBtn("complete.png");
        complete.addActionListener(actionEvent -> this.state.complete());
        start.add(complete);

        btns.add(start);
        btns.add(end);

        return btns;
    }

    private JButton createBtn(String filename) {
        JButton btn = null;
        try {
            btn = new JButton(new ImageIcon(ImageIO.read(new File("src/re/" + filename))));
            btn.setPreferredSize(new Dimension(C.getBtnWidth(), C.getBtnHeight()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return btn;
    }

}
