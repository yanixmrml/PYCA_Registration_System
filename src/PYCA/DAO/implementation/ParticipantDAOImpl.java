/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PYCA.DAO.implementation;

import PYCA.DAO.interfaces.DBManager;
import PYCA.DAO.interfaces.ParticipantDAO;
import PYCA.model.District;
import PYCA.model.IDColor;
import PYCA.model.Participant;
import PYCA.model.Team;
import PYCA.model.Type;
import PYCA.model.Year;
import PYCA.tools.DataSQLHandler;
import PYCA.tools.ExceptionHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YANIX-MRML
 */
public class ParticipantDAOImpl implements ParticipantDAO{

    private DBManager connectionDB;
    private Connection connection;
    private PreparedStatement pStatement;
    private Statement statement;
    private ResultSet resultSet;
    private String sql;
    
    public ParticipantDAOImpl(){
    }
    
    @Override
    public Participant addParticipant(Participant participant) throws ExceptionHandler {
        try {
            sql = "CALL addParticipant(?,?,?,?,?,?,?,?,?,?,?);";
            connectionDB = DBManagerImpl.getInstance();
            connection = (Connection) connectionDB.getConnection();
            pStatement = (PreparedStatement) connection.prepareStatement(sql);
            pStatement.setString(1, participant.getFirstName());
            pStatement.setString(2, participant.getMiddleName());
            pStatement.setString(3, participant.getLastName());
            pStatement.setString(4, participant.getNickName());
            pStatement.setInt(5, participant.getAge());
            pStatement.setInt(6, participant.getType().getTypeID());
            pStatement.setInt(7, participant.getDistrict().getDistrictID());
            pStatement.setInt(8, participant.getYear().getYearID());
            if(participant.getGkk()!=null){
                pStatement.setString(9, participant.getGkk());
            }else{
                pStatement.setNull(9,Types.VARCHAR);
            }
            pStatement.setBoolean(10, participant.isParentalConsent()); 
            pStatement.setBoolean(11, participant.isRegistrationFee());            
            pStatement.execute();
            resultSet = pStatement.getResultSet();
            if(resultSet.next()){
               int id = resultSet.getInt("participantID");
               Team team = null;
               IDColor color = null;
               if(resultSet.getString("team_name")!=null){
                   team = new Team(resultSet.getInt("next_team_id"),resultSet.getString("team_name"),participant.getYear());
               }
               if(resultSet.getString("color_name")!=null){
                   color = new IDColor(resultSet.getInt("next_color_id"),resultSet.getString("color_name"),participant.getYear());
               }
               participant.setParticipantID(id);
               participant.setTeam(team);
               participant.setColor(color);
               return participant;
            }
        } catch (SQLException ex) {
            throw new ExceptionHandler(ex);
        }finally {
            DataSQLHandler.close(pStatement, connection);
	}
        return null;
    }

    @Override
    public void editParticipant(Participant participant) throws ExceptionHandler {
        try {
            sql = "UPDATE participant SET firstName = ?, middleName = ?, lastName = ?,"
                    + " nickName = ?, age = ?, typeID = ?, districtID = ?, teamID = ?, colorID = ?,"
                    + " gkk = ?, parentalConsent = ?, registrationFee = ? WHERE participantID = " + participant.getParticipantID();
            connectionDB = DBManagerImpl.getInstance();
            connection = (Connection) connectionDB.getConnection();
            pStatement = (PreparedStatement) connection.prepareStatement(sql);
            pStatement.setString(1, participant.getFirstName());
            pStatement.setString(2, participant.getMiddleName());
            pStatement.setString(3, participant.getLastName());
            pStatement.setString(4, participant.getNickName());
            pStatement.setInt(5, participant.getAge());
            pStatement.setInt(6, participant.getType().getTypeID());
            pStatement.setInt(7, participant.getDistrict().getDistrictID());
            if(participant.getTeam()!=null && participant.getTeam().getTeamName()!= null){
                pStatement.setInt(8, participant.getTeam().getTeamID());
            }else{
                pStatement.setNull(8, java.sql.Types.INTEGER);
            }
            if(participant.getTeam()!=null && participant.getTeam().getTeamName()!= null){
                pStatement.setInt(9, participant.getColor().getColorID());
            }else{
                pStatement.setNull(9, java.sql.Types.INTEGER);
            }
            if(participant.getGkk()!=null){
                pStatement.setString(10, participant.getGkk());
            }else{
                pStatement.setNull(10,Types.VARCHAR);
            }
            pStatement.setBoolean(11, participant.isParentalConsent()); 
            pStatement.setBoolean(12, participant.isRegistrationFee());
            pStatement.execute();
        } catch (SQLException ex) {
            throw new ExceptionHandler(ex);
        }finally {
            DataSQLHandler.close(pStatement, connection);
	}
    }

    @Override
    public void deleteParticipant(Participant participant) throws ExceptionHandler {
        try {
            sql = "DELETE FROM participant WHERE participantID = ?";
            connectionDB = DBManagerImpl.getInstance();
            connection = (Connection) connectionDB.getConnection();
            pStatement = (PreparedStatement) connection.prepareStatement(sql);
            pStatement.setInt(1, participant.getParticipantID());
            pStatement.execute();
        } catch (SQLException ex) {
            throw new ExceptionHandler(ex);
        }finally {
            DataSQLHandler.close(pStatement, connection);
	}
    }

    @Override
    public List<Participant> getParticipantByTeam(Team team, Year year, Type type) throws ExceptionHandler {
        ArrayList<Participant> participantList = new ArrayList<Participant>();
        try {
            sql = "SELECT * FROM participant p INNER JOIN type t ON p.typeID = t.typeID "
                    + " LEFT JOIN team te ON p.teamID = te.teamID INNER JOIN district d ON p.districtID = d.districtID "
                    + " INNER JOIN year y ON p.yearID = y.yearID LEFT JOIN IDColor c ON p.colorID = c.colorID WHERE p.teamID = " + team.getTeamID() + " AND p.yearID = " + year.getYearID() 
                    + " AND p.typeID = " + type.getTypeID() + " ORDER BY lastName, firstName, middleName";
            connectionDB = DBManagerImpl.getInstance();
            connection = (Connection) connectionDB.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Participant participant = new Participant();
                participant.setParticipantID(resultSet.getInt("participantID"));
                participant.setFirstName(resultSet.getString("firstName"));
                participant.setMiddleName(resultSet.getString("middleName"));
                participant.setLastName(resultSet.getString("lastName"));
                participant.setAge(resultSet.getInt("age"));
                participant.setNickName(resultSet.getString("nickName"));
                participant.setType(new Type(resultSet.getInt("typeID"),resultSet.getString("typeName")));
                participant.setGkk(resultSet.getString("gkk"));
                participant.setRegistrationFee(resultSet.getBoolean("registrationFee"));
                participant.setParentalConsent(resultSet.getBoolean("parentalConsent"));
                
                participant.setDistrict(new District(resultSet.getInt("districtID"),resultSet.getString("districtName")));
                participant.setYear(new Year(resultSet.getInt("yearID"),resultSet.getInt("year"),
                        resultSet.getInt("status"),resultSet.getDate("dateFrom"),resultSet.getDate("dateTo")));
                if(resultSet.getString("teamName")!=null){
                    participant.setTeam(new Team(resultSet.getInt("teamID"),resultSet.getString("teamName"),participant.getYear()));
                }else{
                    participant.setTeam(null);
                }
                
                if(resultSet.getString("colorName")!=null){
                    participant.setColor(new IDColor(resultSet.getInt("colorID"),resultSet.getString("colorName"),participant.getYear()));
                }else{
                    participant.setColor(null);
                }
                
                participantList.add(participant);
            }
        } catch (SQLException ex) {
            throw new ExceptionHandler(ex);
        }finally {
            DataSQLHandler.close(pStatement, connection);
	}
        return participantList;
    }

    @Override
    public List<Participant> getParticipantByDistrict(District district, Year year, Type type) throws ExceptionHandler {
        ArrayList<Participant> participantList = new ArrayList<Participant>();
        try {
            sql = "SELECT * FROM participant p INNER JOIN type t ON p.typeID = t.typeID "
                    + " LEFT JOIN team te ON p.teamID = te.teamID INNER JOIN district d ON  p.districtID = d.districtID "
                    + " INNER JOIN year y ON p.yearID = y.yearID LEFT JOIN IDColor c ON p.colorID = c.colorID  WHERE p.districtID = " + district.getDistrictID() + " AND p.yearID = " + year.getYearID() +
                      " AND p.typeID = " + type.getTypeID() + " ORDER BY lastName, firstName, middleName";
            connectionDB = DBManagerImpl.getInstance();
            connection = (Connection) connectionDB.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Participant participant = new Participant();
                participant.setParticipantID(resultSet.getInt("participantID"));
                participant.setFirstName(resultSet.getString("firstName"));
                participant.setMiddleName(resultSet.getString("middleName"));
                participant.setLastName(resultSet.getString("lastName"));
                participant.setAge(resultSet.getInt("age"));
                participant.setNickName(resultSet.getString("nickName"));
                participant.setType(new Type(resultSet.getInt("typeID"),resultSet.getString("typeName")));
                participant.setGkk(resultSet.getString("gkk"));
                participant.setRegistrationFee(resultSet.getBoolean("registrationFee"));
                participant.setParentalConsent(resultSet.getBoolean("parentalConsent"));
                
                participant.setDistrict(new District(resultSet.getInt("districtID"),resultSet.getString("districtName")));
                participant.setYear(new Year(resultSet.getInt("yearID"),resultSet.getInt("year"),
                        resultSet.getInt("status"),resultSet.getDate("dateFrom"),resultSet.getDate("dateTo")));
                if(resultSet.getString("teamName")!=null){
                    participant.setTeam(new Team(resultSet.getInt("teamID"),resultSet.getString("teamName"),participant.getYear()));
                }else{
                    participant.setTeam(null);
                }
                
                if(resultSet.getString("colorName")!=null){
                    participant.setColor(new IDColor(resultSet.getInt("colorID"),resultSet.getString("colorName"),participant.getYear()));
                }else{
                    participant.setColor(null);
                }
                participantList.add(participant);
            }
        } catch (SQLException ex) {
            throw new ExceptionHandler(ex);
        }finally {
            DataSQLHandler.close(pStatement, connection);
	}
        return participantList;
    }

    @Override
    public List<Participant> getAllParticipants(Year year) throws ExceptionHandler {
        ArrayList<Participant> participantList = new ArrayList<Participant>();
        try {
            sql = "SELECT * FROM participant p INNER JOIN type t ON p.typeID = t.typeID "
                    + " LEFT JOIN team te ON p.teamID = te.teamID INNER JOIN district d ON  p.districtID = d.districtID "
                    + " INNER JOIN year y ON p.yearID = y.yearID LEFT JOIN IDColor c ON p.colorID = c.colorID  WHERE p.yearID = " +  year.getYearID()
                    + " ORDER BY lastName, firstName, middleName";
            connectionDB = DBManagerImpl.getInstance();
            connection = (Connection) connectionDB.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Participant participant = new Participant();
                participant.setParticipantID(resultSet.getInt("participantID"));
                participant.setFirstName(resultSet.getString("firstName"));
                participant.setMiddleName(resultSet.getString("middleName"));
                participant.setLastName(resultSet.getString("lastName"));
                participant.setAge(resultSet.getInt("age"));
                participant.setNickName(resultSet.getString("nickName"));
                participant.setType(new Type(resultSet.getInt("typeID"),resultSet.getString("typeName")));
                participant.setGkk(resultSet.getString("gkk"));
                participant.setRegistrationFee(resultSet.getBoolean("registrationFee"));
                participant.setParentalConsent(resultSet.getBoolean("parentalConsent"));
                
                participant.setDistrict(new District(resultSet.getInt("districtID"),resultSet.getString("districtName")));
                participant.setYear(new Year(resultSet.getInt("yearID"),resultSet.getInt("year"),
                        resultSet.getInt("status"),resultSet.getDate("dateFrom"),resultSet.getDate("dateTo")));
                if(resultSet.getString("teamName")!=null){
                    participant.setTeam(new Team(resultSet.getInt("teamID"),resultSet.getString("teamName"),participant.getYear()));
                }else{
                    participant.setTeam(null);
                }
                
                if(resultSet.getString("colorName")!=null){
                    participant.setColor(new IDColor(resultSet.getInt("colorID"),resultSet.getString("colorName"),participant.getYear()));
                }else{
                    participant.setColor(null);
                }
                participantList.add(participant);
            }
        } catch (SQLException ex) {
            throw new ExceptionHandler(ex);
        }finally {
            DataSQLHandler.close(pStatement, connection);
	}
        return participantList;
    }
    
    @Override
    public List<Participant> getAllParticipantsByName(String name,Year year) throws ExceptionHandler {
        ArrayList<Participant> participantList = new ArrayList<Participant>();
        try {
            sql = "SELECT * FROM participant p INNER JOIN type t ON p.typeID = t.typeID "
                    + " LEFT JOIN team te ON p.teamID = te.teamID INNER JOIN district d ON  p.districtID = d.districtID "
                    + " INNER JOIN year y ON p.yearID = y.yearID LEFT JOIN IDColor c ON p.colorID = c.colorID  WHERE p.yearID = " +  year.getYearID()
                    + " AND firstName LIKE '" + name + "%' ORDER BY lastName, firstName, middleName";
            connectionDB = DBManagerImpl.getInstance();
            connection = (Connection) connectionDB.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Participant participant = new Participant();
                participant.setParticipantID(resultSet.getInt("participantID"));
                participant.setFirstName(resultSet.getString("firstName"));
                participant.setMiddleName(resultSet.getString("middleName"));
                participant.setLastName(resultSet.getString("lastName"));
                participant.setAge(resultSet.getInt("age"));
                participant.setNickName(resultSet.getString("nickName"));
                participant.setType(new Type(resultSet.getInt("typeID"),resultSet.getString("typeName")));
                participant.setGkk(resultSet.getString("gkk"));
                participant.setRegistrationFee(resultSet.getBoolean("registrationFee"));
                participant.setParentalConsent(resultSet.getBoolean("parentalConsent"));
                
                participant.setDistrict(new District(resultSet.getInt("districtID"),resultSet.getString("districtName")));
                participant.setYear(new Year(resultSet.getInt("yearID"),resultSet.getInt("year"),
                        resultSet.getInt("status"),resultSet.getDate("dateFrom"),resultSet.getDate("dateTo")));
                if(resultSet.getString("teamName")!=null){
                    participant.setTeam(new Team(resultSet.getInt("teamID"),resultSet.getString("teamName"),participant.getYear()));
                }else{
                    participant.setTeam(null);
                }
                
                if(resultSet.getString("colorName")!=null){
                    participant.setColor(new IDColor(resultSet.getInt("colorID"),resultSet.getString("colorName"),participant.getYear()));
                }else{
                    participant.setColor(null);
                }
                participantList.add(participant);
            }
        } catch (SQLException ex) {
            throw new ExceptionHandler(ex);
        }finally {
            DataSQLHandler.close(pStatement, connection);
	}
        return participantList;
    }
    
    
    
}
