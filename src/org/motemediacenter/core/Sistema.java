/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.motemediacenter.core;

import org.motemediacenter.layout.Principal;

/**
 *
 * @author badiale
 */
public class Sistema {
    public Sistema () {
    }

    public static void main (String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
}
