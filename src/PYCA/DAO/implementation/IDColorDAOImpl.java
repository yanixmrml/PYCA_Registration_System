/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PYCA.DAO.implementation;

import PYCA.DAO.interfaces.DBManager;
import PYCA.DAO.interfaces.IDColorDAO;
import PYCA.model.IDColor;
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
public class IDColorDAOImpl implements IDColorDAO{
    
    private DBManager connectionDB;
    private Connection connection;
    private PreparedStatement pStatement;
    private Statement statement;
    private ResultSet resultSet;
    private String sql;
    
    public IDColorDAOImpl(){
        
    }

    @Override
    public int addIDColor(IDColor color) throws ExceptionHandler {
        try {
            sql = "CALL addIDColor(?,?);";
            connectionDB = DBManagerImpl.getInstance();
            connection = (Connection) connectionDB.getConnection();
            pStatement = (PreparedStatement) connection.prepareStatement(sql);
            pStatement.setString(1,color.getColorName());
            pStatement.setInt(2, color.getYear().getYearID());
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
    public void editIDColor(IDColor color) throws ExceptionHandler {
        try {
            sql = "UPDATE IDColor SET colorName = ?, yearID = ? WHERE colorID = " + color.getColorID();
            connectionDB = DBManagerImpl.getInstance();
            connection = (Connection) connectionDB.getConnection();
            pStatement = (PreparedStatement) connection.prepareStatement(sql);
            pStatement.setString(1, color.getColorName());
            pStatement.setInt(2, color.getYear().getYearID());
            pStatement.execute();
        } catch (SQLException ex) {
            throw new ExceptionHandler(ex);
        }finally {
            DataSQLHandler.close(pStatement, connection);
	}
    }

    @Override
    public void deleteIDColor(IDColor color) throws ExceptionHandler {
        try {
            sql = "DELETE FROM IDColor WHERE colorID = ?";
            connectionDB = DBManagerImpl.getInstance();
            connection = (Connection) connectionDB.getConnection();
            pStatement = (PreparedStatement) connection.prepareStatement(sql);
            pStatement.setInt(1, color.getColorID());
            pStatement.execute();
        } catch (SQLException ex) {
            throw new ExceptionHandler(ex);
        }finally {
            DataSQLHandler.close(pStatement, connection);
	}
    }

    @Override
    public List<IDColor> getIDColors(Year currentYear) throws ExceptionHandler {
        ArrayList<IDColor> colorList = new ArrayList<IDColor>();
        try {
            sql = "SELECT * FROM IDColor INNER JOIN year ON IDColor.yearID = year.yearID "
                    + " AND  IDColor.yearID = " + currentYear.getYearID() + " ORDER BY colorName";
            connectionDB = DBManagerImpl.getInstance();
            connection = (Connection) connectionDB.getConnection();
            statement = connection.createStatement();
            statement.executeQuery(sql);
            resultSet = statement.getResultSet();
            while(resultSet.next()){
                IDColor color = new IDColor();
                color.setColorID(resultSet.getInt("colorID"));
                color.setColorName(resultSet.getString("colorName"));
                color.setYear(new Year(resultSet.getInt("yearID"),resultSet.getInt("year"),resultSet.getInt("status"),
                        resultSet.getDate("dateFrom"),resultSet.getDate("dateTo")));
                colorList.add(color);
            }
        } catch (SQLException ex) {
            throw new ExceptionHandler(ex);
        }finally {
            DataSQLHandler.close(pStatement, connection);
	}
        return colorList;
    }
    
    
}
