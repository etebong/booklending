/*
 * this class keeps track of all daily transactions
 *in the library

 */
package models;

import database.ConnectDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author philip
 */
public class Transaction {

    private String transactionid;
    private String userid;
    private String username;
    private String bookTitle;
    private String author;
    private String dateborrowed;
    private String datedue;
    private String fine;
    private String returneddate;
    private String remarks;
    private String accno;
   

    private PreparedStatement saveIssuedBook, save;
    private Statement st;

    private Connection con;
    private ResultSet rs;
    private Transaction transaction;
    
    

    public  Transaction(String transactionid, String userid, String username,String accno, String bookTitle, String author, String dateborrowed, String datedue) {
        this.transactionid = transactionid;
        this.userid = userid;
        this.username = username;
        this.accno = accno;
        this.bookTitle = bookTitle;
        this.author = author;
        this.dateborrowed = dateborrowed;
        this.datedue = datedue;
        
    }
    
    
    public Transaction() {
        try {
            con = ConnectDb.connect();

            saveIssuedBook = con.prepareStatement("INSERT INTO transaction"
                    + "(userid, name,accno, booktitle, author, dateborrowed, datedue)" + "VALUES(?,?,?,?,?,?,?)");
            save = con.prepareStatement("INSERT INTO transactionlog "
                    + "(transactionid, userid, username, accno, bookTitle, author, dateborrowed, datedue, fine, returneddate, remarks)" + "VALUES (?,?,?,?,?,?,?,?,?,?,?)");

        } catch (SQLException e) {

            e.printStackTrace();
            System.exit(1);

        }

    }

    public int saveToLogFile(int transactionid, int userid, String username, int accno, String booktitle, String author,
            String dateborrowed, String datedue, double fine, String returneddate, String remarks) {
        int result = 0;
        try {
            save.setInt(1, transactionid);
            save.setInt(2, userid);
            save.setString(3, username);
            save.setInt(4, accno);
            save.setString(5, booktitle);
            save.setString(6, author);
            save.setString(7, dateborrowed);
            save.setString(8, datedue);
            save.setDouble(9, fine);
            save.setString(10, returneddate);
            save.setString(11, remarks);

            result = save.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error during operation");
            try {
                con.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    public int saveTransaction(String id, String name, int accNo, String booktitle, String author, String d, String dd) {
        int result = 0;
        /*
	 * id is transaction identity, name is name of the user involved in the transaction, 
	 * accno is the unique identity of books, d is the date which the transaction take place,
	 * dd is the date due for the return of the borrowed books
         */
        try {
            saveIssuedBook.setString(1, id);
            saveIssuedBook.setString(2, name);
            saveIssuedBook.setInt(3, accNo);
            saveIssuedBook.setString(4, booktitle);
            saveIssuedBook.setString(5, author);
            saveIssuedBook.setString(6, d);
            saveIssuedBook.setString(7, dd);

            result = saveIssuedBook.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            try {

                con.close();
            } catch (SQLException e1) {

                e1.printStackTrace();
            }
        }
        return result;
    }
    //method to handle create, update, read and deleting of records in a table

    public void executeSQlQuery(String query) {
        con = ConnectDb.connect();

        try {
            st = con.createStatement();
            if ((st.executeUpdate(query)) == 1) {

                //JOptionPane.showMessageDialog(null, "Data Succefully manipulated");
            } else {
                //JOptionPane.showMessageDialog(null, "Data Not ok ");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDateborrowed() {
        return dateborrowed;
    }

    public void setDateborrowed(String dateborrowed) {
        this.dateborrowed = dateborrowed;
    }

    public String getDatedue() {
        return datedue;
    }

    public void setDatedue(String datedue) {
        this.datedue = datedue;
    }

    public String getReturneddate() {
        return returneddate;
    }

    public void setReturneddate(String returneddate) {
        this.returneddate = returneddate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getAccno() {
        return accno;
    }

    public void setAccno(String accno) {
        this.accno = accno;
    }
    
    public ArrayList<Transaction> getTransactionList()//creates an arraylist to load data from the books table 
	   {
	       ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
	        con = ConnectDb.connect();
	       
	       String query = "SELECT transactionid, userid, name, accno, booktitle, author, dateborrowed, datedue FROM transaction WHERE remark = \"Not Returned\"; ";
	       	       
	       try {
	           st = con.createStatement();
	           rs = st.executeQuery(query);
	        
	           while(rs.next())
	           {
	        	   transaction = new Transaction((rs.getString("transactionid")),rs.getString("userid"),
                                   rs.getString("name"),rs.getString("accno"), rs.getString("booktitle"), rs.getString("author"),
	        			   rs.getString("dateborrowed"), rs.getString("datedue"));
	               transactionList.add(transaction);
	           }

	       } 
	      catch (Exception e) {
	           e.printStackTrace();
	       }
	       return transactionList;
	   }//end of getUserList

}
