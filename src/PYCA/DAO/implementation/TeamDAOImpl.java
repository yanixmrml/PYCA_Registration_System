/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PYCA.DAO.implementation;

import PYCA.DAO.interfaces.DBManager;
import PYCA.DAO.interfaces.TeamDAO;
import PYCA.model.Team;
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
public class TeamDAOImpl implements TeamDAO{

    private DBManager connectionDB;
    private Connection connection;
    private PreparedStatement pStatement;
    private Statement statement;
    private ResultSet resultSet;
    private String sql;
    
    public TeamDAOImpl(){
        
    }
    
    @Override
    public int addTeam(Team team) throws ExceptionHandler {
        try {
            sql = "CALL addTeam(?,?);";
            connectionDB = DBManagerImpl.getInstance();
            connection = (Connection) connectionDB.getConnection();
            pStatement = (PreparedStatement) connection.prepareStatement(sql);
            pStatement.setString(1,team.getTeamName());
            pStatement.setInt(2, team.getYear().getYearID());
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
    public void editTeam(Team team) throws ExceptionHandler {
        try {
            sql = "UPDATE team SET teamName = ?, yearID = ? WHERE teamID = " + team.getTeamID();
            connectionDB = DBManagerImpl.getInstance();
            connection = (Connection) connectionDB.getConnection();
            pStatement = (PreparedStatement) connection.prepareStatement(sql);
            pStatement.setString(1, team.getTeamName());
            pStatement.setInt(2, team.getYear().getYearID());
            pStatement.execute();
        } catch (SQLException ex) {
            throw new ExceptionHandler(ex);
        }finally {
            DataSQLHandler.close(pStatement, connection);
	}
    }

    @Override
    public void deleteTeam(Team team) throws ExceptionHandler {
        try {
            sql = "DELETE FROM team WHERE teamID = " + team.getTeamID();
            connectionDB = DBManagerImpl.getInstance();
            connection = (Connection) connectionDB.getConnection();
            pStatement = (PreparedStatement) connection.prepareStatement(sql);
            pStatement.setInt(1, team.getTeamID());
            pStatement.execute();
        } catch (SQLException ex) {
            throw new ExceptionHandler(ex);
        }finally {
            DataSQLHandler.close(pStatement, connection);
	}
    }

    @Override
    public List<Team> getTeams(Year currentYear) throws ExceptionHandler {
        ArrayList<Team> teamList = new ArrayList<Team>();
        try {
            sql = "SELECT * FROM team INNER JOIN year ON team.yearID = year.yearID "
                    + " WHERE team.yearID = " + currentYear.getYearID() + " ORDER BY teamName";
            connectionDB = DBManagerImpl.getInstance();
            connection = (Connection) connectionDB.getConnection();
            statement = connection.createStatement();
            statement.executeQuery(sql);
            resultSet = statement.getResultSet();
            while(resultSet.next()){
                Team team = new Team();
                team.setTeamID(resultSet.getInt("teamID"));
                team.setTeamName(resultSet.getString("teamName"));
                team.setYear(new Year(resultSet.getInt("yearID"),resultSet.getInt("year"),resultSet.getInt("status"),
                        resultSet.getDate("dateFrom"),resultSet.getDate("dateTo")));
                teamList.add(team);
            }
        } catch (SQLException ex) {
            throw new ExceptionHandler(ex);
        }finally {
            DataSQLHandler.close(pStatement, connection);
	}
        return teamList;
    }
    
}
