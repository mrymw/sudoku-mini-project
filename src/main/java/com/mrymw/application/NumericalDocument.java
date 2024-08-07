package com.mrymw.application;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;

public class NumericalDocument extends PlainDocument {
    String numbers = "0123456789";

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (str != null && str.length() == 1 && numbers.contains(str)) {
            super.insertString(offs, str, a);
        } else {
            Toolkit.getDefaultToolkit().beep(); // Beep on invalid input
        }
    }
}

