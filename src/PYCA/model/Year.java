/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PYCA.model;

import java.util.Date;

/**
 *
 * @author YANIX-MRML
 */
public class Year {
    
    private int yearID;
    private int year;
    private int status;
    private Date dateFrom;
    private Date dateTo;

    public static int OPEN = 1;
    public static int CLOSE = 0;
    
    public Year() {
    }

    public Year(int yearID, int year,int status, Date dateFrom, Date dateTo) {
        this.yearID = yearID;
        this.year = year;
        this.status = status;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }
    
    /**
     * @return the yearID
     */
    public int getYearID() {
        return yearID;
    }

    /**
     * @param yearID the yearID to set
     */
    public void setYearID(int yearID) {
        this.yearID = yearID;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the dateFrom
     */
    public Date getDateFrom() {
        return dateFrom;
    }

    /**
     * @param dateFrom the dateFrom to set
     */
    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    /**
     * @return the dateTo
     */
    public Date getDateTo() {
        return dateTo;
    }

    /**
     * @param dateTo the dateTo to set
     */
    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }
    
    
    
    
}
