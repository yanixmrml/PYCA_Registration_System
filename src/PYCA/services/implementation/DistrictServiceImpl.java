/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PYCA.services.implementation;

import PYCA.DAO.implementation.DistrictDAOImpl;
import PYCA.DAO.interfaces.DistrictDAO;
import PYCA.model.District;
import PYCA.services.interfaces.DistrictService;
import PYCA.tools.ExceptionHandler;
import java.util.List;

/**
 *
 * @author YANIX-MRML
 */
public class DistrictServiceImpl implements DistrictService{

    public DistrictDAO districtDAO;
    
    public DistrictServiceImpl(){
        districtDAO = new DistrictDAOImpl();
    }
    
    @Override
    public int addDistrict(District district) throws ExceptionHandler {
        return districtDAO.addDistrict(district);
    }

    @Override
    public void editDistrict(District district) throws ExceptionHandler {
        districtDAO.editDistrict(district);
    }

    @Override
    public void deleteDistrict(District district) throws ExceptionHandler {
        districtDAO.deleteDistrict(district);
    }

    @Override
    public List<District> getDistricts() throws ExceptionHandler {
        return districtDAO.getDistricts();
    }
    
}
