/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PYCA.services.interfaces;

import PYCA.model.District;
import PYCA.model.Participant;
import PYCA.model.Team;
import PYCA.model.Type;
import PYCA.model.Year;
import PYCA.tools.ExceptionHandler;
import java.util.List;

/**
 *
 * @author YANIX-MRML
 */
public interface ParticipantService {

    Participant addParticipant(Participant participant) throws ExceptionHandler;
    void editParticipant(Participant participant) throws ExceptionHandler;
    void deleteParticipant(Participant participant) throws ExceptionHandler;
    List<Participant> getParticipantByTeam(Team team, Year year, Type type) throws ExceptionHandler;
    List<Participant> getParticipantByDistrict(District district, Year year, Type type) throws ExceptionHandler;
    List<Participant> getAllParticipants(Year year) throws ExceptionHandler;
    List<Participant> getAllParticipantsByName(String name,Year year) throws ExceptionHandler;
    
}
