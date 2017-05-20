/*
 This class creates the method use by Administrator to create new user (Librarian)
to the system. It has the Setters and Geeters required for the Librarian creation.
This class is used/called by the MainApi.java class
 */
package models;

import database.ConnectDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author philip
 */
public class Admin {

    private int adminID;
    private String surname;
    private String firstname;
    private String middlename;
    private String gender;
    private String phoneno;
    private String address;
    private String username;
    private String password;
    

    private Connection con;
    private PreparedStatement insertRec;
    private PreparedStatement updateRec;

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender(){
        return gender;
    }
    
    public void setGender(String gender){
        this.gender = gender;
    }

    public Admin() {
        try {
            con = ConnectDb.connect();

            insertRec = con.prepareStatement("INSERT INTO admin "
                    + "(surname, firstname, middlename, gender, phoneno,address,"
                    + "username,password) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            updateRec = con.prepareStatement("UPDATE admin SET surname=?, firstname =?, middlename=?,"
                    + "phoneno=?, address =?, username=?, password=?, WHERE adminID='" + adminID + "' ");
        } catch (SQLException e) {

            e.printStackTrace();
            System.exit(1);

        }
    }//end of constructor
    
    
    /*
    The method below creates new Librarian for the system
    */

    public int createNewRecord(Admin admin) {

        int result = 0;
 
        try {

            insertRec.setString(1, admin.getSurname());
            insertRec.setString(2, admin.getFirstname());
            insertRec.setString(3, admin.getMiddlename());
            insertRec.setString(4, admin.getGender());
            insertRec.setString(5, admin.getPhoneno());
            insertRec.setString(6, admin.getAddress());
            insertRec.setString(7, admin.getUsername());
            insertRec.setString(8, admin.getPassword());
            

            result = insertRec.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

            try {
                con.close();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }

        return result;
    }//end of method

}
