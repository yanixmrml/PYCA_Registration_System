/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package PYCA.DAO.implementation;

import PYCA.DAO.interfaces.DBManager;
import PYCA.tools.ExceptionHandler;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;


public class DBManagerImpl implements DBManager{

    private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    //private String DATABASE_URL = "jdbc:mysql://localhost:3307/pyca";
    private String DATABASE_URL = "jdbc:mysql://YANIX-MRML-PC:3307/pyca";
    private String username = "root";
    private String password = "root";
    private boolean connectedToDatabase = false;
    private volatile static DBManager INSTANCE = null;

    public DBManagerImpl() throws ExceptionHandler{
        try {
            Class.forName(JDBC_DRIVER);
	} catch (ClassNotFoundException Exception) {
            throw new ExceptionHandler(Exception);
        }
    }


    public static DBManager getInstance() throws ExceptionHandler{
        if(INSTANCE==null){
            synchronized(DBManager.class){
		if(INSTANCE==null){
                    INSTANCE= new DBManagerImpl();
		}
            }
        }
        return INSTANCE;
    }

    public Connection getConnection() throws ExceptionHandler{
        Connection connection=null;
        try{
            connection= DriverManager.getConnection( DATABASE_URL, username, password );
            connectedToDatabase = true;
        }
        catch(SQLException Exception){
            throw new ExceptionHandler(Exception);
        }
        return connection;
    }

    public boolean isConnectedToDatabase(){
        return connectedToDatabase;
    }
}
