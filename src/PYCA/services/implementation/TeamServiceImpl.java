/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PYCA.services.implementation;

import PYCA.DAO.implementation.TeamDAOImpl;
import PYCA.DAO.interfaces.TeamDAO;
import PYCA.model.Team;
import PYCA.model.Year;
import PYCA.services.interfaces.TeamService;
import PYCA.tools.ExceptionHandler;
import java.util.List;

/**
 *
 * @author YANIX-MRML
 */
public class TeamServiceImpl implements TeamService{

    public TeamDAO teamDAO;
    
    public TeamServiceImpl(){
        teamDAO = new TeamDAOImpl();
    }
    
    @Override
    public int addTeam(Team team) throws ExceptionHandler {
        return teamDAO.addTeam(team);
    }

    @Override
    public void editTeam(Team team) throws ExceptionHandler {
        teamDAO.editTeam(team);
    }

    @Override
    public void deleteTeam(Team team) throws ExceptionHandler {
        teamDAO.deleteTeam(team);
    }

    @Override
    public List<Team> getTeams(Year currentYear) throws ExceptionHandler {
        return teamDAO.getTeams(currentYear);
    }
    
}
