/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PYCA.DAO.interfaces;

import PYCA.model.Year;
import PYCA.tools.ExceptionHandler;
import java.util.List;

/**
 *
 * @author YANIX-MRML
 */
public interface YearDAO {
    
    int addYear(Year year) throws ExceptionHandler;
    void editYear(Year year) throws ExceptionHandler;
    void deleteYear(Year year) throws ExceptionHandler;
    List<Year> getYears()throws ExceptionHandler;
    Year getCurrentYear() throws ExceptionHandler;
    
}
