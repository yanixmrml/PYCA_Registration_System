/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PYCA.model;

/**
 *
 * @author YANIX-MRML
 */
public class Type {
    
    private int typeID;
    private String typeName;

    public Type() {
    }

    public Type(int typeID, String typeName) {
        this.typeID = typeID;
        this.typeName = typeName;
    }
    
    /**
     * @return the typeID
     */
    public int getTypeID() {
        return typeID;
    }

    /**
     * @param typeID the typeID to set
     */
    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    /**
     * @return the typeName
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * @param typeName the typeName to set
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    
    
}
