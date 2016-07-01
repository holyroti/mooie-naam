package View;

import java.awt.*;

import javax.swing.*;
import javax.swing.text.Document;

@SuppressWarnings("serial")
public class JTextFieldPlaceholder extends JTextField {

    private String placeholder;

    public JTextFieldPlaceholder() {
    }

    public JTextFieldPlaceholder(
        final Document pDoc,
        final String pText,
        final int pColumns)
    {
        super(pDoc, pText, pColumns);
    }

    public JTextFieldPlaceholder(final int pColumns) {
        super(pColumns);
    }

    public JTextFieldPlaceholder(final String pText) {
        super(pText);
    }

    public JTextFieldPlaceholder(final String pText, final int pColumns) {
        super(pText, pColumns);
    }

    public String getPlaceholder() {
        return placeholder;
    }

    @Override
    protected void paintComponent(final Graphics pG) {
        super.paintComponent(pG);

        if (placeholder.length() == 0 || getText().length() > 0) {
            return;
        }

        final Graphics2D g = (Graphics2D) pG;
        g.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(getDisabledTextColor());
        g.drawString(placeholder, getInsets().left, pG.getFontMetrics()
            .getMaxAscent() / 2 + getHeight() / 2);
    }

    public void setPlaceholder(final String s) {
        placeholder = s;
    }

}