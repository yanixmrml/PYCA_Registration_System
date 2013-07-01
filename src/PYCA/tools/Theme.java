/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package PYCA.tools;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Theme{
    public static void setDefaultLookAndFeel(JComponent components){
        try {
            String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
            //        try {
            UIManager.setLookAndFeel(lookAndFeel);
            SwingUtilities.updateComponentTreeUI(components);
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void setDefaultLookAndFeel(){
        String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        try { 
            UIManager.setLookAndFeel(lookAndFeel);
        }
         catch (ClassNotFoundException ex) {
            Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void setMetalLookAndFeel()throws ExceptionHandler{
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        }
         catch (ClassNotFoundException ex) {
            Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void setWindowsLookAndFeel() throws ExceptionHandler{
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
         catch (ClassNotFoundException ex) {
            Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void setMotifLookAndFeel() throws ExceptionHandler{
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        }
         catch (ClassNotFoundException ex) {
            Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void setWindowsClassicLookAndFeel() throws ExceptionHandler{
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
        }
         catch (ClassNotFoundException ex) {
            Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
