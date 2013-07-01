/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PYCA.services.implementation;

import PYCA.DAO.implementation.YearDAOImpl;
import PYCA.DAO.interfaces.YearDAO;
import PYCA.model.Year;
import PYCA.services.interfaces.YearService;
import PYCA.tools.ExceptionHandler;
import java.util.List;

/**
 *
 * @author YANIX-MRML
 */
public class YearServiceImpl implements YearService{

    public YearDAO yearDAO;
    
    public YearServiceImpl(){
        yearDAO = new YearDAOImpl();
    }
    
    @Override
    public int addYear(Year year) throws ExceptionHandler {
        return yearDAO.addYear(year);
    }

    @Override
    public void editYear(Year year) throws ExceptionHandler {
        yearDAO.editYear(year);
    }

    @Override
    public void deleteYear(Year year) throws ExceptionHandler {
        yearDAO.deleteYear(year);
    }

    @Override
    public List<Year> getYears() throws ExceptionHandler {
        return yearDAO.getYears();
    }

    @Override
    public Year getCurrentYear() throws ExceptionHandler {
        return yearDAO.getCurrentYear();
    }
    
}
