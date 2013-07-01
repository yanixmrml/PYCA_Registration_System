/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PYCA.DAO.implementation;

import PYCA.DAO.interfaces.DBManager;
import PYCA.DAO.interfaces.DistrictDAO;
import PYCA.model.District;
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
public class DistrictDAOImpl implements DistrictDAO{

    private DBManager connectionDB;
    private Connection connection;
    private PreparedStatement pStatement;
    private Statement statement;
    private ResultSet resultSet;
    private String sql;
    
    public DistrictDAOImpl(){
        
    }
    
    @Override
    public int addDistrict(District district) throws ExceptionHandler {
        try {
            sql = "CALL addDistrict(?);";
            connectionDB = DBManagerImpl.getInstance();
            connection = (Connection) connectionDB.getConnection();
            pStatement = (PreparedStatement) connection.prepareStatement(sql);
            pStatement.setString(1,district.getDistrictName());
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
    public void editDistrict(District district) throws ExceptionHandler {
        try {
            sql = "UPDATE district SET districtName = ? WHERE districtID = " + district.getDistrictID();
            connectionDB = DBManagerImpl.getInstance();
            connection = (Connection) connectionDB.getConnection();
            pStatement = (PreparedStatement) connection.prepareStatement(sql);
            pStatement.setString(1, district.getDistrictName());
            pStatement.execute();
        } catch (SQLException ex) {
            throw new ExceptionHandler(ex);
        }finally {
            DataSQLHandler.close(pStatement, connection);
	}
    }

    @Override
    public void deleteDistrict(District district) throws ExceptionHandler {
        try {
            sql = "DELETE FROM district WHERE districtID = ?";
            connectionDB = DBManagerImpl.getInstance();
            connection = (Connection) connectionDB.getConnection();
            pStatement = (PreparedStatement) connection.prepareStatement(sql);
            pStatement.setInt(1,district.getDistrictID());
            pStatement.execute();
        } catch (SQLException ex) {
            throw new ExceptionHandler(ex);
        }finally {
            DataSQLHandler.close(pStatement, connection);
	}
    }

    @Override
    public List<District> getDistricts() throws ExceptionHandler {
        ArrayList<District> districtList = new ArrayList<District>();
        try {
            sql = "SELECT * FROM district ORDER BY districtName";
            connectionDB = DBManagerImpl.getInstance();
            connection = (Connection) connectionDB.getConnection();
            statement = connection.createStatement();
            statement.executeQuery(sql);
            resultSet = statement.getResultSet();
            while(resultSet.next()){
                District district = new District();
                district.setDistrictID(resultSet.getInt("districtID"));
                district.setDistrictName(resultSet.getString("districtName"));
                districtList.add(district);
            }
        } catch (SQLException ex) {
            throw new ExceptionHandler(ex);
        }finally {
            DataSQLHandler.close(pStatement, connection);
	}
        return districtList;
    }
   
    
    
}
