package PYCA.tools;

import com.mysql.jdbc.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;


public class DataSQLHandler {
    public static void close(ResultSet resultSet, Statement statement, Connection conn) throws ExceptionHandler{
        if(resultSet != null){
            try {  resultSet.close();   }
            catch (SQLException exception) {  throw new ExceptionHandler(exception); }
        }
        if(statement != null){
            try {  statement.close(); }
            catch (SQLException exception) {  throw new ExceptionHandler(exception); }
        }
        if(conn != null){
            try {  conn.close();   }
            catch (SQLException exception) {   throw new ExceptionHandler(exception); }
        }
    }

    public static void close(ResultSet resultSet, PreparedStatement pStatement, Connection conn) throws ExceptionHandler{
        if( resultSet != null){
            try {  resultSet.close();  }
            catch (SQLException exception) {  throw new ExceptionHandler(exception); }
        }
        if (pStatement != null){
            try { pStatement.close();  }
            catch (SQLException exception) { throw new ExceptionHandler(exception);   }
        }
        if (conn != null){
            try { conn.close();  }
            catch (SQLException exception) {  throw new ExceptionHandler(exception);   }
        }
    }

    public static void close(Statement statement, Connection conn) throws ExceptionHandler{
        if(statement != null){
            try {  statement.close(); }
            catch (SQLException exception) {  throw new ExceptionHandler(exception); }
        }

        if(conn != null){
            try {  conn.close();   }
            catch (SQLException exception) {   throw new ExceptionHandler(exception); }
        }
    }

    public static void close(PreparedStatement pStatement, Connection conn)throws ExceptionHandler{
        if (pStatement != null){
            try { pStatement.close();  }
            catch (SQLException exception) { throw new ExceptionHandler(exception);   }
        }
        if (conn != null){
            try { conn.close();  }
            catch (SQLException exception) {  throw new ExceptionHandler(exception);   }
        }
    }

    public static void close(ResultSet resultSet, CallableStatement cStatement, Connection conn) throws ExceptionHandler{
        if( resultSet != null){
            try {
                resultSet.close();
             } catch (SQLException exception) {
                throw new ExceptionHandler(exception);
            }
        }
        if (cStatement != null){
            try {
                cStatement.close();
            } catch (SQLException exception) {
                throw new ExceptionHandler(exception);
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException exception) {
                throw new ExceptionHandler(exception);
            }

        }
    }
}
