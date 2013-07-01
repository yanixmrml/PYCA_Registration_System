/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PYCA.model;

/**
 *
 * @author YANIX-MRML
 */
public class Team {
    
    private int teamID;
    private String teamName;
    private Year year;

    public Team() {
    }

    public Team(int teamID, String teamName, Year year) {
        this.teamID = teamID;
        this.teamName = teamName;
        this.year = year;
    }
    
    /**
     * @return the teamID
     */
    public int getTeamID() {
        return teamID;
    }

    /**
     * @param teamID the teamID to set
     */
    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    /**
     * @return the teamName
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * @param teamName the teamName to set
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
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
