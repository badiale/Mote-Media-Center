/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.motemediacenter.core;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import javax.swing.SwingUtilities;
import motej.Mote;
import motej.demos.common.SimpleMoteFinder;
import motej.event.CoreButtonEvent;
import motej.event.CoreButtonListener;
import motej.event.IrCameraEvent;
import motej.event.IrCameraListener;
import motej.event.MoteDisconnectedEvent;
import motej.event.MoteDisconnectedListener;
import motej.request.ReportModeRequest;

/**
 *
 * @author badiale
 */
public class MoteSearch {
    private Mote mote;
    private Robot robot;

    public MoteSearch() {
        mote = null;
        try {
            robot = new Robot();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void disconnect () {
        // desconecta o wii mote
        try {
            //mote.setReportMode(ReportModeRequest.DATA_REPORT_0x30);
            //mote.disableIrCamera();
            mote.disconnect();
            mote = null;
        } catch (Exception e) { e.printStackTrace(); }
    }

   public void connect() {
        SimpleMoteFinder simpleMoteFinder = new SimpleMoteFinder();

        // procura por um wii mote
        mote = simpleMoteFinder.findMote();

        if (mote != null) {
            // habilita a camera infrared
            mote.enableIrCamera();
            mote.setReportMode(ReportModeRequest.DATA_REPORT_0x36);

            // desliga os leds, soh deixa o primeiro ligado
            mote.setPlayerLeds(new boolean[] {true, false, false, false});

            // coloca um listener para a camera infra red
            mote.addIrCameraListener(new IrCameraListener() {
                    public void irImageChanged(IrCameraEvent evt) {
                            try {
                                if (evt.getIrPoint(0).getX() < 1023 || evt.getIrPoint(0).getY() < 1023) {
                                    // o eixo X eh invertido
                                    int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
                                    int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
                                    int x = (int) (width * (1 - ((1023 - evt.getIrPoint(0).getX()) / 1023)));
                                    int y = (int) (height * (1 - ((768 - evt.getIrPoint(0).getY()) / 768)));
                                    robot.mouseMove(width - x, y);
                                    System.out.println(evt.getIrPoint(0).toString() + " -> (" + x + ", " + y + ")");
                                }
                            } catch (Exception e) { e.printStackTrace(); }
                    }
            });

            // caso o wii mote desconecte, desconecta corretamente
            mote.addMoteDisconnectedListener(new MoteDisconnectedListener() {

                public void moteDisconnected(MoteDisconnectedEvent evt) {
                    disconnect();
                }

            });

            // trata quando botoes são pressionados
            mote.addCoreButtonListener(new CoreButtonListener() {
                public void buttonPressed(final CoreButtonEvent evt) {
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            if (evt.isButtonAPressed()) {
                                robot.mousePress(InputEvent.BUTTON1_MASK);
                            } else {
                                robot.mouseRelease(InputEvent.BUTTON1_MASK);
                            }
                        }
                    });
                }
            });
        }
    }
}
