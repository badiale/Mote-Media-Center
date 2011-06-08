/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.motemediacenter.layout;

import javax.swing.JLabel;

/**
 *
 * @author badiale
 */
class LabelAnimator extends Thread {
    private JLabel label;
    private String text;
    private boolean continues;
    private ListaArquivos parent;
    private static final Object monitor = new Object();

    public LabelAnimator(ListaArquivos parent, JLabel label) {
        this.label = label;
        this.continues = true;
        this.parent = parent;
    }

    @Override
    public void run () {
        text = label.getText();
        boolean continua = true;
        continues = true;
        while (continua) {
            try {
                Thread.sleep(175);
            } catch (Exception e) { System.err.println(e.getMessage()); }

            synchronized (monitor) {
                continua = continues;
            }

            parent.setVisible(false);

            if (label.getText().isEmpty()) label.setText(text);
            else label.setText(label.getText().substring(1));

            parent.setVisible(true);
        }
        parent.setVisible(false);
        label.setText(text);
        parent.setVisible(true);
    }

    public void para () {
        synchronized (monitor) {
            continues = false;
        }
    }
}
