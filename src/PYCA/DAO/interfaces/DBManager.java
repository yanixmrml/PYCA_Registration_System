/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package PYCA.DAO.interfaces;

import PYCA.tools.ExceptionHandler;
import java.sql.Connection;


public interface DBManager {

    public Connection getConnection() throws ExceptionHandler;
    public boolean isConnectedToDatabase() throws ExceptionHandler;

}
