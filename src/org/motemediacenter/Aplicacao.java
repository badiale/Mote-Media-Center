/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.motemediacenter;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;
import org.motemediacenter.layout.Principal;

/**
 *
 * @author badiale
 */
public class Aplicacao extends SingleFrameApplication {
    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        show(new Principal(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of TestesApp
     */
    public static Aplicacao getApplication() {
        return Application.getInstance(Aplicacao.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(Aplicacao.class, args);
    }
}
