/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PYCA.services.interfaces;

import PYCA.tools.ExceptionHandler;
import PYCA.model.Type;
import java.util.List;

/**
 *
 * @author YANIX-MRML
 */
public interface TypeService{
    
    int addType(Type type) throws ExceptionHandler;
    void editType(Type type) throws ExceptionHandler;
    void deleteType(Type type) throws ExceptionHandler;
    List<Type> getTypes()throws ExceptionHandler;
    
}
