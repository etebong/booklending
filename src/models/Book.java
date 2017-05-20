/*
 The Book.java class creates all the methods required by the BookApi.java classes.
 */
package models;

import database.ConnectDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author philip
 */
public class Book {
    
    private int accno;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private int year;
    private String edition;
    private String category;
    private String status;


    private static Connection con;
    private PreparedStatement create;
    private Statement st;
    private ResultSet rs;
    private Book book;





     public Book (){

            try {
                con = ConnectDb.connect();

                
                create = con.prepareStatement("INSERT INTO books " +
                            "(isbn, title, author, publisher, year, edition,category)" 
                            + "VALUES (?,?, ?, ?, ?, ?, ?)");


            } catch (SQLException e) {

                    e.printStackTrace();
                    System.exit(1);

            }
		
	}

    public Book(int accno, String isbn, String title, String author, String publisher, int year, String edition, String category, String status) {
        this.accno = accno;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.edition = edition;
        this.category = category;
        this.status = status;
    }
	
	
		
	public Book(int accno, String title, String author, String publisher, String status) {
            super();
            this.accno = accno;
            this.title = title;
            this.author = author;
            this.publisher = publisher;
            this.status = status;
	}

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String authur) {
		this.author = authur;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public int creatNewBook(Book book){//This method create new Book in The Library
		int result = 0;
		
		try {
			

                    create.setString(1, book.getIsbn());
                    create.setString(2, book.getTitle());
                    create.setString(3, book.getAuthor());
                    create.setString(4, book.getPublisher());
                    create.setInt(5, book.getYear());
                    create.setString(6, book.getEdition());
                    create.setString(7, book.getCategory());
                    //create.setString(8, book.getStatus());
			
			
						
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
		
	}//end of createNewUser method
	
	public void updateBook(Book book){//Update book table
		try {
                    con = ConnectDb.connect();
                    st = con.createStatement();

                    String sql = "UPDATE books SET isbn= \'" + book.getIsbn()+ "\', title = \'" + book.getTitle() + "\',"
                                    + " author = \'"+ book.getAuthor()+"\', publisher = \'" + book.getPublisher() + "\',year = \'" + book.getYear() + "\',"
                                                    + "edition = \'" + book.getEdition() + "\',category = \'" + book.getCategory() + "\' WHERE accno=\'" + book.getAccno()+ "\';";

			
			
                    st.executeUpdate(sql);
		
		
		} catch (Exception e) {
		
                    e.printStackTrace();

                    try {
                            con.close();
                    } catch (SQLException e1) {

                            e1.printStackTrace();
                    }
		}
	
	
	}//end of updateBook status	
	
	public ArrayList<Book> getBookList()//creates an arraylist to load data from the books table 
	   {
	       ArrayList<Book> bookList = new ArrayList<Book>();
	        con = ConnectDb.connect();
	       
	       String query = "SELECT accno, title, author,publisher,status FROM  books ";
	       	       
	       try {
	           st = con.createStatement();
	           rs = st.executeQuery(query);

	        
	           while(rs.next())
	           {
	        	   book = new Book(Integer.parseInt(rs.getString("accno")),rs.getString("title"),rs.getString("author"),rs.getString("publisher"),
	        			   rs.getString("status"));
	               bookList.add(book);
	           }

	       } 
	      catch (Exception e) {
	           e.printStackTrace();
	       }
	       return bookList;
	   }//end of getUserList
        
        public ArrayList<Book> getNewBookList()//creates an arraylist to load data from the books table 
	   {
	       ArrayList<Book> bookList = new ArrayList<Book>();
	        con = ConnectDb.connect();
	       
	       String query = "SELECT * FROM  books ";
	       	       
	       try {
	           st = con.createStatement();
	           rs = st.executeQuery(query);

	        
	           while(rs.next())
	           {
                       
	        	   book = new Book(Integer.parseInt(rs.getString("accno")),rs.getString("isbn"), rs.getString("title"),rs.getString("author"),rs.getString("publisher"),  
                                   Integer.parseInt(rs.getString("year")), rs.getString("edition"), rs.getString("category"), rs.getString("status"));
	               bookList.add(book);
	           }

	       } 
	      catch (Exception e) {
	           e.printStackTrace();
	       }
	       return bookList;
	   }//end of getUserList
	
	public void loadValuesFromTable(String sql, JComboBox<String> cbo) {
            try {
                    // connect to Database
                    con = ConnectDb.connect();

                    st = con.createStatement();
                    //String sql = "select * from bookcategory";
                    rs = st.executeQuery(sql);
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
	
	public void deleteBook(String query, String message)
	   {
	       con = ConnectDb.connect();
	       
	       try{
	           st = con.createStatement();
	           if((st.executeUpdate(query)) == 1)
	           {
	                                            
	               JOptionPane.showMessageDialog(null, "Data "+message+" Succefully");
	           }else{
	               JOptionPane.showMessageDialog(null, "Data Not "+message);
	           }
	       }catch(Exception ex){
	           ex.printStackTrace();
	       }
	   }
	
    
}
