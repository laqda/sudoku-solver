package gui;

import consts.Configuration;

import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class Form extends JPanel {

    State state;

    public Form(State state) {
        this.state = state;
        this.setPreferredSize(new Dimension(C.getAppWidth(), C.getFormHeight()));
        this.add(createSilder(), BorderLayout.CENTER);
    }

    private int adjustSpeedToValue(int speed) {
        return (int) Math.log10(speed);
    }
    private int adjustValueToSpeed(int value) {
        return (int) Math.pow(10, value);
    }

    private JSlider createSilder() {
        JSlider slider = new JSlider(
                JSlider.HORIZONTAL,
                0,
                adjustSpeedToValue(Configuration.SPEED.SLOW.getSpeed()),
                adjustSpeedToValue(this.state.getSpeed())
        );
        slider.setPaintTicks(true);
        slider.setPreferredSize(new Dimension(C.getAppWidth(), C.getFormHeight()));

        Hashtable<Integer, JLabel> labels = new Hashtable<>();
        labels.put(0, new JLabel("STEP BY STEP"));
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
                    this.state.setSpeed(Configuration.SPEED.getSpeed(adjustValueToSpeed(sliderSource.getValue())));
                }
            }
        });

        return slider;
    }

}
