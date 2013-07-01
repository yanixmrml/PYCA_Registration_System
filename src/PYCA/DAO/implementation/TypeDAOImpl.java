/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PYCA.DAO.implementation;

import PYCA.DAO.interfaces.DBManager;
import PYCA.DAO.interfaces.TypeDAO;
import PYCA.tools.ExceptionHandler;
import PYCA.model.Type;
import PYCA.tools.DataSQLHandler;
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
public class TypeDAOImpl implements TypeDAO{

    private DBManager connectionDB;
    private Connection connection;
    private PreparedStatement pStatement;
    private Statement statement;
    private ResultSet resultSet;
    private String sql;
    
    public TypeDAOImpl(){
        
    }
    
    @Override
    public int addType(Type type) throws ExceptionHandler {
        try {
            sql = "CALL addType(?);";
            connectionDB = DBManagerImpl.getInstance();
            connection = (Connection) connectionDB.getConnection();
            pStatement = (PreparedStatement) connection.prepareStatement(sql);
            pStatement.setString(1,type.getTypeName());
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
    public void editType(Type type) throws ExceptionHandler {
        try {
            sql = "UPDATE type SET typeName = ? WHERE typeID = " + type.getTypeName();
            connectionDB = DBManagerImpl.getInstance();
            connection = (Connection) connectionDB.getConnection();
            pStatement = (PreparedStatement) connection.prepareStatement(sql);
            pStatement.setString(1, type.getTypeName());
            pStatement.execute();
        } catch (SQLException ex) {
            throw new ExceptionHandler(ex);
        }finally {
            DataSQLHandler.close(pStatement, connection);
	}
    }

    @Override
    public void deleteType(Type type) throws ExceptionHandler {
        try {
            sql = "DELETE FROM type WHERE typeID = ?";
            connectionDB = DBManagerImpl.getInstance();
            connection = (Connection) connectionDB.getConnection();
            pStatement = (PreparedStatement) connection.prepareStatement(sql);
            pStatement.setInt(1, type.getTypeID());
            pStatement.execute();
        } catch (SQLException ex) {
            throw new ExceptionHandler(ex);
        }finally {
            DataSQLHandler.close(pStatement, connection);
	}
    }

    @Override
    public List<Type> getTypes() throws ExceptionHandler {
        ArrayList<Type> typeList = new ArrayList<Type>();
        try {
            sql = "SELECT * FROM type ORDER BY typeName";
            connectionDB = DBManagerImpl.getInstance();
            connection = (Connection) connectionDB.getConnection();
            statement = connection.createStatement();
            statement.executeQuery(sql);
            resultSet = statement.getResultSet();
            while(resultSet.next()){
                Type type = new Type();
                type.setTypeID(resultSet.getInt("typeID"));
                type.setTypeName(resultSet.getString("typeName"));
                typeList.add(type);
            }
        } catch (SQLException ex) {
            throw new ExceptionHandler(ex);
        }finally {
            DataSQLHandler.close(pStatement, connection);
	}
        return typeList;
    }
    
}
