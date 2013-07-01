/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PYCA.services.interfaces;

import PYCA.model.Team;
import PYCA.model.Year;
import PYCA.tools.ExceptionHandler;
import java.util.List;

/**
 *
 * @author YANIX-MRML
 */
public interface TeamService {
    
    int addTeam(Team team) throws ExceptionHandler;
    void editTeam(Team team) throws ExceptionHandler;
    void deleteTeam(Team team) throws ExceptionHandler;
    List<Team> getTeams(Year currentYear) throws ExceptionHandler;
    
}
