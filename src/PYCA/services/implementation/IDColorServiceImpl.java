/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PYCA.services.implementation;

import PYCA.DAO.implementation.IDColorDAOImpl;
import PYCA.DAO.interfaces.IDColorDAO;
import PYCA.model.IDColor;
import PYCA.model.Year;
import PYCA.services.interfaces.IDColorService;
import PYCA.tools.ExceptionHandler;
import java.util.List;

/**
 *
 * @author YANIX-MRML
 */
public class IDColorServiceImpl implements IDColorService{

    private IDColorDAO colorDAO;
    
    public IDColorServiceImpl(){
        colorDAO = new IDColorDAOImpl();
    }
    
    @Override
    public int addIDColor(IDColor color) throws ExceptionHandler {
        return colorDAO.addIDColor(color);
    }

    @Override
    public void editIDColor(IDColor color) throws ExceptionHandler {
        colorDAO.editIDColor(color);
    }

    @Override
    public void deleteIDColor(IDColor color) throws ExceptionHandler {
        colorDAO.deleteIDColor(color);
    }

    @Override
    public List<IDColor> getIDColors(Year currentYear) throws ExceptionHandler {
        return colorDAO.getIDColors(currentYear);
    }
    
}
