/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package PYCA.tools;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author YANIX_MRML
 */
public class ExceptionHandler extends Exception{

    public ExceptionHandler(ExceptionHandler e){
        JOptionPane.showMessageDialog(null,e.getMessage(),"DBException", JOptionPane.WARNING_MESSAGE);
    }
    public ExceptionHandler(SQLException e){
         if(e.getErrorCode() == 1451){
            JOptionPane.showMessageDialog(null,"Delete subject : Failed","Error",0);
            return;
         }else{
            JOptionPane.showMessageDialog(null,e.getMessage(),"SQLException", JOptionPane.WARNING_MESSAGE);
         }
    }
    public ExceptionHandler(Exception e){
        JOptionPane.showMessageDialog(null,e.getMessage(),"Exception", JOptionPane.WARNING_MESSAGE);
    }
    public ExceptionHandler(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"ClassNotFoundException",JOptionPane.WARNING_MESSAGE);
    }

}
