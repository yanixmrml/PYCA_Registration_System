/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PYCA.model;

/**
 *
 * @author YANIX-MRML
 */
public class District {
    
    private int districtID;
    private String districtName;

    public District() {
    }

    public District(int districtID, String districtName) {
        this.districtID = districtID;
        this.districtName = districtName;
    }

    /**
     * @return the districtID
     */
    public int getDistrictID() {
        return districtID;
    }

    /**
     * @param districtID the districtID to set
     */
    public void setDistrictID(int districtID) {
        this.districtID = districtID;
    }

    /**
     * @return the districtName
     */
    public String getDistrictName() {
        return districtName;
    }

    /**
     * @param districtName the districtName to set
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
    
    
}
