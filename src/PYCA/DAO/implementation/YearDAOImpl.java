/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PYCA.DAO.implementation;

import PYCA.DAO.interfaces.DBManager;
import PYCA.DAO.interfaces.YearDAO;
import PYCA.model.Year;
import PYCA.tools.DataSQLHandler;
import PYCA.tools.ExceptionHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YANIX-MRML
 */
public class YearDAOImpl implements YearDAO{
    
    private DBManager connectionDB;
    private Connection connection;
    private PreparedStatement pStatement;
    private Statement statement;
    private ResultSet resultSet;
    private String sql;
    
    public YearDAOImpl(){
        
    }
    
    @Override
    public int addYear(Year year) throws ExceptionHandler {
        try {
            sql = "CALL addYear(?,?,?,?);";
            connectionDB = DBManagerImpl.getInstance();
            connection = (Connection) connectionDB.getConnection();
            pStatement = (PreparedStatement) connection.prepareStatement(sql);
            pStatement.setInt(1,year.getYear());
            pStatement.setInt(2,year.getStatus());
            pStatement.setDate(3,(java.sql.Date) year.getDateFrom());
            pStatement.setDate(4, (java.sql.Date) year.getDateTo());
            pStatement.execute();
            resultSet = pStatement.getResultSet();
            if(resultSet.next()){
               return resultSet.getInt(1); 
            }
        } catch (SQLException ex) {
            throw new ExceptionHandler(ex);
        }finally {
            DataSQLHandler.close(pStatement, connection);
	}
        return 0;
    }

    @Override
    public void editYear(Year year) throws ExceptionHandler {
        try {
            sql = "UPDATE type SET year = ?, status = ?, dateFrom = ?, dateTo = ?"
                    + "  WHERE yearID = " + year.getYearID();
            connectionDB = DBManagerImpl.getInstance();
            connection = (Connection) connectionDB.getConnection();
            pStatement = (PreparedStatement) connection.prepareStatement(sql);
            pStatement.setInt(1,year.getYear());
            pStatement.setInt(2,year.getStatus());
            pStatement.setDate(3,(java.sql.Date) year.getDateFrom());
            pStatement.setDate(4, (java.sql.Date) year.getDateTo());
            pStatement.execute();
        } catch (SQLException ex) {
            throw new ExceptionHandler(ex);
        }finally {
            DataSQLHandler.close(pStatement, connection);
	}
    }

    @Override
    public void deleteYear(Year year) throws ExceptionHandler {
        try {
            sql = "DELETE FROM year WHERE yearID = ?";
            connectionDB = DBManagerImpl.getInstance();
            connection = (Connection) connectionDB.getConnection();
            pStatement = (PreparedStatement) connection.prepareStatement(sql);
            pStatement.setInt(1, year.getYearID());
            pStatement.execute();
        } catch (SQLException ex) {
            throw new ExceptionHandler(ex);
        }finally {
            DataSQLHandler.close(pStatement, connection);
	}
    }

    @Override
    public List<Year> getYears() throws ExceptionHandler {
        ArrayList<Year> yearList = new ArrayList<Year>();
        try {
            sql = "SELECT * FROM year ORDER BY year";
            connectionDB = DBManagerImpl.getInstance();
            connection = (Connection) connectionDB.getConnection();
            statement = connection.createStatement();
            statement.executeQuery(sql);
            resultSet = statement.getResultSet();
            while(resultSet.next()){
                Year year = new Year();
                year.setYearID(resultSet.getInt("yearID"));
                year.setYear(resultSet.getInt("year"));
                year.setStatus(resultSet.getInt("status"));
                year.setDateFrom(resultSet.getDate("dateFrom"));
                year.setDateTo(resultSet.getDate("dateTo"));
                yearList.add(year);
            }
        } catch (SQLException ex) {
            throw new ExceptionHandler(ex);
        }finally {
            DataSQLHandler.close(pStatement, connection);
	}
        return yearList;
    }
    
    @Override
    public Year getCurrentYear() throws ExceptionHandler{
        Year year = null;
        try {
            sql = "SELECT * FROM year WHERE status = " + Year.OPEN;
            connectionDB = DBManagerImpl.getInstance();
            connection = (Connection) connectionDB.getConnection();
            statement = connection.createStatement();
            statement.executeQuery(sql);
            resultSet = statement.getResultSet();
            while(resultSet.next()){
                year = new Year();
                year.setYearID(resultSet.getInt("yearID"));
                year.setYear(resultSet.getInt("year"));
                year.setStatus(resultSet.getInt("status"));
                year.setDateFrom(resultSet.getDate("dateFrom"));
                year.setDateTo(resultSet.getDate("dateTo"));
            }
        } catch (SQLException ex) {
            throw new ExceptionHandler(ex);
        }finally {
            DataSQLHandler.close(pStatement, connection);
	}
        return year;
    }
    
}
