/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PYCA.services.implementation;

import PYCA.DAO.implementation.ParticipantDAOImpl;
import PYCA.DAO.interfaces.ParticipantDAO;
import PYCA.model.District;
import PYCA.model.Participant;
import PYCA.model.Team;
import PYCA.model.Type;
import PYCA.model.Year;
import PYCA.services.interfaces.ParticipantService;
import PYCA.tools.ExceptionHandler;
import java.util.List;

/**
 *
 * @author YANIX-MRML
 */
public class ParticipantServiceImpl implements ParticipantService{

    public ParticipantDAO participantDAO;
    
    public ParticipantServiceImpl(){
        participantDAO = new ParticipantDAOImpl();
    }
    
    @Override
    public Participant addParticipant(Participant participant) throws ExceptionHandler {
        return participantDAO.addParticipant(participant);
    }

    @Override
    public void editParticipant(Participant participant) throws ExceptionHandler {
       participantDAO.editParticipant(participant);
    }

    @Override
    public void deleteParticipant(Participant participant) throws ExceptionHandler {
        participantDAO.deleteParticipant(participant);
    }

    @Override
    public List<Participant> getParticipantByTeam(Team team, Year year, Type type) throws ExceptionHandler {
        return participantDAO.getParticipantByTeam(team, year, type);
    }

    @Override
    public List<Participant> getParticipantByDistrict(District district, Year year, Type type) throws ExceptionHandler {
        return participantDAO.getParticipantByDistrict(district, year, type);
    }

    @Override
    public List<Participant> getAllParticipants(Year year) throws ExceptionHandler {
        return participantDAO.getAllParticipants(year);
    }

    @Override
    public List<Participant> getAllParticipantsByName(String name, Year year) throws ExceptionHandler {
        return participantDAO.getAllParticipantsByName(name, year);
    }
    
}
