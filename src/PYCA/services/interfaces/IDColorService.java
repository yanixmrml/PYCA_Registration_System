/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PYCA.services.interfaces;

import PYCA.model.IDColor;
import PYCA.model.Year;
import PYCA.tools.ExceptionHandler;
import java.util.List;

/**
 *
 * @author YANIX-MRML
 */
public interface IDColorService {
    
    int addIDColor(IDColor color) throws ExceptionHandler;
    void editIDColor(IDColor color) throws ExceptionHandler;
    void deleteIDColor(IDColor color) throws ExceptionHandler;
    List<IDColor> getIDColors(Year currentYear)throws ExceptionHandler;
    
    
}
