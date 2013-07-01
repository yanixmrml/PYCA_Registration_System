/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PYCA.model;

/**
 *
 * @author YANIX-MRML
 */
public class Participant {
    
    private int participantID;
    private String firstName;
    private String middleName;
    private String lastName;
    private String nickName;
    private int age;
    private Type type;
    private Team team;
    private District district;
    private Year year;
    private IDColor color;
    private String gkk;
    private boolean registrationFee;
    private boolean parentalConsent;
    
    public Participant() {
    }

    public Participant(int participantID, String firstName, String middleName, String lastName, String nickName, int age, Type type, Team team, District district, Year year, IDColor color,
            String gkk, boolean registrationFee, boolean parentalConsent) {
        this.participantID = participantID;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.age = age;
        this.type = type;
        this.team = team;
        this.district = district;
        this.year = year;
        this.color = color;
        this.gkk = gkk;
        this.registrationFee = registrationFee;
        this.parentalConsent = parentalConsent;
    }

    /**
     * @return the participantID
     */
    public int getParticipantID() {
        return participantID;
    }

    /**
     * @param participantID the participantID to set
     */
    public void setParticipantID(int participantID) {
        this.participantID = participantID;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @param middleName the middleName to set
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the nickName
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName the nickName to set
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * @return the team
     */
    public Team getTeam() {
        return team;
    }

    /**
     * @param team the team to set
     */
    public void setTeam(Team team) {
        this.team = team;
    }

    /**
     * @return the district
     */
    public District getDistrict() {
        return district;
    }

    /**
     * @param district the district to set
     */
    public void setDistrict(District district) {
        this.district = district;
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
     
    @Override
    public String toString(){
        return lastName + ", " + firstName + " " + middleName.charAt(0) + ".";
    }

    /**
     * @return the color
     */
    public IDColor getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(IDColor color) {
        this.color = color;
    }

    /**
     * @return the gkk
     */
    public String getGkk() {
        return gkk;
    }

    /**
     * @param gkk the gkk to set
     */
    public void setGkk(String gkk) {
        this.gkk = gkk;
    }

    /**
     * @return the registrationFee
     */
    public boolean isRegistrationFee() {
        return registrationFee;
    }

    /**
     * @param registrationFee the registrationFee to set
     */
    public void setRegistrationFee(boolean registrationFee) {
        this.registrationFee = registrationFee;
    }

    /**
     * @return the parentalConsent
     */
    public boolean isParentalConsent() {
        return parentalConsent;
    }

    /**
     * @param parentalConsent the parentalConsent to set
     */
    public void setParentalConsent(boolean parentalConsent) {
        this.parentalConsent = parentalConsent;
    }
    
}
