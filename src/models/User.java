/*
 *user.class is a class that create a template for the UserApi.java and 
 UserApi_user.java classes
 */
package models;

import database.ConnectDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author philip
 *
 */
public class User {

    private int userID;
    private String idcardno;
    private String surname;
    private String firstname;
    private String middlename;
    private String gender;
    private String address;
    private String department;
    private String phoneno;
    private String userCategory;
    private String dateRegistered;

    private PreparedStatement create;
    private PreparedStatement search;
    private static Connection con;
    private Statement stmt;
    private ResultSet rs;
    private Statement st;

    public User() {

        try {
            con = ConnectDb.connect();// connect to database

            search = con.prepareStatement("SELECT * FROM users WHERE userId =?");
            //create = con.prepareStatement("INSERT INTO users(surname, firstname, middlename, gender, address, "
            //+ "department, phoneno, usercategory,dateregistered)" + "VALUES (?,?,?,?,?,?,?,?,?)");

        } catch (SQLException e) {

            e.printStackTrace();
            System.exit(1);

        }

    }

    public User(int userID, String surname, String firstname, String middlename, String gender, String address,
            String department, String phoneno, String userCategory, String dateRegistered) {
        super();
        this.userID = userID;
        this.surname = surname;
        this.firstname = firstname;
        this.middlename = middlename;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.phoneno = phoneno;
        this.userCategory = userCategory;
        this.dateRegistered = dateRegistered;
    } // end of constructor

    public User(int userID, String surname, String firstname, String department, String phoneno, String dateRegistered) {
        setUserID(userID);
        setSurname(surname);
        setFirstname(firstname);
        setDepartment(department);
        setPhoneno(phoneno);
        setDateRegistered(dateRegistered);

    }//end of constructor

    public User(int userID, String idcardno, String surname, String firstname, String department, String phoneno, String dateRegistered) {
        setUserID(userID);
        setIdcardno(idcardno);
        setSurname(surname);
        setFirstname(firstname);
        setDepartment(department);
        setPhoneno(phoneno);
        setDateRegistered(dateRegistered);

    }//end of constructor

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getIdcardno() {
        return idcardno;
    }

    public void setIdcardno(String idcardno) {
        this.idcardno = idcardno;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surName) {
        this.surname = surName;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middleName) {
        this.middlename = middleName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(String userCategory) {
        this.userCategory = userCategory;
    }

    public String getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(String dateRegistered) {
        this.dateRegistered = dateRegistered;
    }
    /*
    this  method creates a new user (member) in the Library
    */
    public int createNewUser(User user) {
        int result = 0;

        try {
            con = ConnectDb.connect();
            create = con.prepareStatement("INSERT INTO users(surname, useridcardno, firstname, middlename, gender, address, "
                    + "department, phoneno, usercategory,dateregistered)" + "VALUES (?,?,?,?,?,?,?,?,?,?)");
            create.setString(1, user.getSurname());
            create.setString(2, user.getIdcardno());
            create.setString(3, user.getFirstname());
            create.setString(4, user.getMiddlename());
            create.setString(5, user.getGender());
            create.setString(6, user.getAddress());
            create.setString(7, user.getDepartment());
            create.setString(8, user.getPhoneno());
            create.setString(9, user.getUserCategory());
            create.setString(10, user.getDateRegistered());

            result = create.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();

            try {

                con.close();
            } catch (SQLException e1) {

                e1.printStackTrace();
            }
        }

        return result;

    }
    /*
    updates a user in the library
    */
    public void UpdateUser(User user) {
        try {
            con = ConnectDb.connect();
            stmt = con.createStatement();

            String sql = "UPDATE users SET surname= \'" + user.getSurname() + "\', useridcardno =\'" + user.getIdcardno() + "\', firstname= \'" + user.getFirstname() + "\', middlename = \'" + user.getMiddlename() + "\', "
                    + "gender = \'" + user.getGender() + "\', address =\'" + user.getAddress() + "\', department=\'" + user.getDepartment() + "\' , phoneno = \'" + user.getPhoneno() + "\' , "
                    + "usercategory=\'" + user.getUserCategory() + "\',dateregistered=\'" + user.getDateRegistered() + "\' WHERE userID=\'" + user.getUserID() + "\';";

            stmt.executeUpdate(sql);

        } catch (Exception e) {

            e.printStackTrace();

            try {
                con.close();
            } catch (SQLException e1) {

                e1.printStackTrace();
            }
        }

    }

    /*
		 * This method handles deletion of data from the table
		 * you only will supply the query string and the message delete
     */
    public void deleteUser(String query, String message) {
        con = ConnectDb.connect();

        try {
            stmt = con.createStatement();
            if ((stmt.executeUpdate(query)) == 1) {

                JOptionPane.showMessageDialog(null, "Data " + message + " Succefully");
            } else {
                JOptionPane.showMessageDialog(null, "Data Not " + message);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void loadValuesFromTable(String sql, JComboBox<String> cbo) {
        //this method links the database and loads the values from department table
        //into the combobox
        try {
            // connect to Database
            con = ConnectDb.connect();

            st = con.createStatement();
            //String sql = "select * from bookcategory";
            rs = st.executeQuery(sql);

            cbo.removeAllItems();
            cbo.addItem("--Select Department--");
            while (rs.next()) {

                cbo.addItem(rs.getString(2));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error retrieving data");
            e.printStackTrace();
        } finally {
            try {
                st.close();
                rs.close();
                con.close();
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Error ....");
            }
        }

    }

}
