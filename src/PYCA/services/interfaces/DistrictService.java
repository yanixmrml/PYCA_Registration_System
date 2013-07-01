/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PYCA.services.interfaces;

import PYCA.model.District;
import PYCA.tools.ExceptionHandler;
import java.util.List;

/**
 *
 * @author YANIX-MRML
 */
public interface DistrictService {
    
    int addDistrict(District district) throws ExceptionHandler;
    void editDistrict(District district) throws ExceptionHandler;
    void deleteDistrict(District district) throws ExceptionHandler;
    List<District> getDistricts()throws ExceptionHandler;
    
}
