/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.motemediacenter.core;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
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

    public Mote getMote () { return this.mote; }

    public void disconnect () {
        // desconecta o wii mote
        try {
            if (mote != null) {
                //mote.setReportMode(ReportModeRequest.DATA_REPORT_0x30);
                //mote.disableIrCamera();
                mote.disconnect();
            }
            mote = null;
        } catch (Exception e) { System.err.println(e.getMessage()); }
    }

   public void connect() {
        SimpleMoteFinder simpleMoteFinder = new SimpleMoteFinder();
        
        // 
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_CONTROL);

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
                                    // FIXME pegar o tamanho da tela
                                    int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
                                    int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
                                    int x = (int) (width * (1 - ((1023 - evt.getIrPoint(0).getX()) / 1023)));
                                    int y = (int) (height * (1 - ((768 - evt.getIrPoint(0).getY()) / 768)));

                                    // o eixo X eh invertido
                                    robot.mouseMove(width - x, y);
                                    //System.out.println(evt.getIrPoint(0).toString() + " -> (" + x + ", " + y + ")");
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
                            // botao A
                            //boolean flagA = false;
                            if (evt.isButtonAPressed()) {
                                //flagA = true;
                                robot.mousePress(InputEvent.BUTTON1_MASK);
                            } else {
                                //if (flagA) {
                                //    flagA = false;
                                    robot.mouseRelease(InputEvent.BUTTON1_MASK);
                                //}
                            }
                            
                            // botao B
                            if (evt.isButtonBPressed()) {
                                robot.mousePress(InputEvent.BUTTON3_MASK);
                            } else {
                                robot.mouseRelease(InputEvent.BUTTON3_MASK);
                            }

                            // seta para cima
                            if (evt.isDPadUpPressed()) {
                                robot.keyPress(KeyEvent.VK_UP);
                            } else {
                                robot.keyRelease(KeyEvent.VK_UP);
                            }

                            // seta para baixo
                            if (evt.isDPadDownPressed()) {
                                robot.keyPress(KeyEvent.VK_DOWN);
                            } else {
                                robot.keyRelease(KeyEvent.VK_DOWN);
                            }

                            // seta para esquerda
                            if (evt.isDPadLeftPressed()) {
                                robot.keyPress(KeyEvent.VK_LEFT);
                            } else {
                                robot.keyRelease(KeyEvent.VK_LEFT);
                            }

                            // seta para direita
                            if (evt.isDPadRightPressed()) {
                                robot.keyPress(KeyEvent.VK_RIGHT);
                            } else {
                                robot.keyRelease(KeyEvent.VK_RIGHT);
                            }

                            // menos
                            if (evt.isButtonMinusPressed()) {
                                robot.keyPress(KeyEvent.VK_SLASH);
                            } else {
                                robot.keyRelease(KeyEvent.VK_SLASH);
                            }

                            // mais
                            if (evt.isButtonPlusPressed()) {
                                robot.keyPress(KeyEvent.VK_SHIFT);
                                robot.keyPress(KeyEvent.VK_ASTERISK);
                           } else {
                                robot.keyRelease(KeyEvent.VK_ASTERISK);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
                            }

                            // home
                            if (evt.isButtonHomePressed()) {
                                robot.keyPress(KeyEvent.VK_ALT);
                                robot.keyPress(KeyEvent.VK_CONTROL);
                            }

                            // 1
                            if (evt.isButtonOnePressed()) {
                                robot.keyPress(KeyEvent.VK_ALT);
                                robot.keyPress(KeyEvent.VK_CONTROL);
                                robot.keyPress(KeyEvent.VK_SHIFT);
                                robot.keyPress(KeyEvent.VK_K);
                                
                                robot.keyRelease(KeyEvent.VK_ALT);
                                robot.keyRelease(KeyEvent.VK_CONTROL);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
                                robot.keyRelease(KeyEvent.VK_K);
                            } else {
                                
                            }

                            // 2
                            if (evt.isButtonTwoPressed()) {
                                //robot.keyPress(KeyEvent.VK_ALT);
                                //robot.keyPress(KeyEvent.VK_WINDOWS);
                                //robot.mousePress(InputEvent.BUTTON1_MASK);
                            } else {
                                //robot.keyRelease(KeyEvent.VK_ALT);
                                //robot.keyRelease(KeyEvent.VK_WINDOWS);
                                //robot.mouseRelease(InputEvent.BUTTON1_MASK);
                            }
                        }
                    });
                }
            });
        }
    }
}
