package com.mrymw.application;

import javax.swing.text.PlainDocument;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NineSquare extends JPanel {
    JTextField[] fields = new JTextField[9]; // 9 fields for the 3x3 square
    private static final int BORDER_WIDTH = 5;

    public NineSquare(Color bgColor) {
        setLayout(new GridLayout(3, 3));
        initGui();
        setBackground(bgColor);
    }

    private void initGui() {
        for (int i = 0; i < fields.length; i++) {
            fields[i] = new JTextField(1);
            fields[i].setDocument(new NumericalDocument());
            add(fields[i]);
        }
        setBorder(BorderFactory.createMatteBorder(BORDER_WIDTH, BORDER_WIDTH, BORDER_WIDTH, BORDER_WIDTH, Color.BLACK));
    }

    public List<Integer> getValues() {
        List<Integer> values = new ArrayList<>();
        for (JTextField field : fields) {
            String text = field.getText();
            values.add(text.isEmpty() ? 0 : Integer.parseInt(text)); // 0 for empty cells
        }
        return values;
    }
    public void setValues(List<String> values) {
        for (int i = 0; i < values.size(); i++) {
            fields[i].setText(values.get(i));
        }
    }
}

