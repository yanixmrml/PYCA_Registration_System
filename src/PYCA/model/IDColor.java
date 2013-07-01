/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PYCA.model;

/**
 *
 * @author YANIX-MRML
 */
public class IDColor {
    
    private int colorID;
    private String colorName;
    private Year year;
    
    public IDColor(){
        
    }

    public IDColor(int colorID, String colorName,Year year) {
        this.colorID = colorID;
        this.colorName = colorName;
        this.year = year;
    }

    public int getColorID() {
        return colorID;
    }

    public void setColorID(int colorID) {
        this.colorID = colorID;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    /**
     * @return the year
     */
    public Year getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(Year year) {
        this.year = year;
    }
    
    
    
}
