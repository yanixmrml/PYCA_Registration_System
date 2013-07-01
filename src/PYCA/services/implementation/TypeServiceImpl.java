/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PYCA.services.implementation;

import PYCA.DAO.implementation.TypeDAOImpl;
import PYCA.DAO.interfaces.TypeDAO;
import PYCA.model.Type;
import PYCA.services.interfaces.TypeService;
import PYCA.tools.ExceptionHandler;
import java.util.List;

/**
 *
 * @author YANIX-MRML
 */
public class TypeServiceImpl implements TypeService{

    public TypeDAO typeDAO;
    
    public TypeServiceImpl(){
        typeDAO = new TypeDAOImpl();
    }
    
    @Override
    public int addType(Type type) throws ExceptionHandler {
        return typeDAO.addType(type);
    }

    @Override
    public void editType(Type type) throws ExceptionHandler {
        typeDAO.editType(type);
    }

    @Override
    public void deleteType(Type type) throws ExceptionHandler {
        typeDAO.deleteType(type);
    }

    @Override
    public List<Type> getTypes() throws ExceptionHandler {
        return typeDAO.getTypes();
    }
    
}
