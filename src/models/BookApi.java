/*
BookApi.java is a class that manipulate everything about the creation of new book
update of old book. This class has full functionality meant for the Aministrator of the system 
deletion of old books in the library(only for the admin)
You can also search books  
*/
package models;

import database.ConnectDb;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;


public class BookApi extends javax.swing.JInternalFrame {

    private Book book = new Book();
    private final String sql;
    private GregorianCalendar gcal;
    private DefaultTableModel model;
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    
    public BookApi() {
        BasicInternalFrameUI frame =(BasicInternalFrameUI) this.getUI();
        frame.setNorthPane(null);
        initComponents();
        getContentPane().setBackground(Color.white);
        sql = "SELECT * FROM bookcategory";//query to read from book category table
	book.loadValuesFromTable(sql, cboCategory);// read values into coboBox
        yearBookWasPublished(cboYear);
        Show_Books_In_Table();//displays book's information from book's table
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cboYear = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnAddNewRecord = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        cboCategory = new javax.swing.JComboBox<>();
        txtISBN = new javax.swing.JTextField();
        txtPublisher = new javax.swing.JTextField();
        txtTitle = new javax.swing.JTextField();
        txtEdition = new javax.swing.JTextField();
        txtArthor = new javax.swing.JTextField();
        search_panel = new javax.swing.JPanel();
        panel_1 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtSearchYear = new javax.swing.JTextField();
        txtSearchTitle = new javax.swing.JTextField();
        txtSearchAuthor = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        txtSearchStatus = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtSearchPublisher = new javax.swing.JTextField();
        txtSearchBookEdition = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtSearchISBN = new javax.swing.JTextField();
        txtSearchCategory = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 16, -1, -1));

        jLabel14.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Book's Title:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        cboYear.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        cboYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Select Year--" }));
        jPanel2.add(cboYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 240, 40));

        jLabel15.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Year published:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, -1));

        jLabel16.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 214, -1, -1));

        jLabel17.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Name of Author:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        jLabel18.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Book's Category:");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        jLabel19.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Name of Publisher:");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        jLabel20.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Book's Edition:");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        btnAddNewRecord.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnAddNewRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save-icon.png"))); // NOI18N
        btnAddNewRecord.setText("Save");
        btnAddNewRecord.setBorderPainted(false);
        btnAddNewRecord.setContentAreaFilled(false);
        btnAddNewRecord.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddNewRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewRecordActionPerformed(evt);
            }
        });
        jPanel2.add(btnAddNewRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 480, -1, -1));

        btnClear.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear.png"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.setBorderPainted(false);
        btnClear.setContentAreaFilled(false);
        btnClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel2.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 480, -1, -1));

        jLabel30.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("ISBN:");
        jPanel2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, -1, -1));

        cboCategory.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        cboCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Select Gategory---" }));
        jPanel2.add(cboCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 240, 43));
        jPanel2.add(txtISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 250, 40));
        jPanel2.add(txtPublisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 380, 40));
        jPanel2.add(txtTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 380, 40));
        jPanel2.add(txtEdition, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 250, 40));
        jPanel2.add(txtArthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 380, 40));

        search_panel.setBackground(new java.awt.Color(255, 255, 255));
        search_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        search_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_1.setBackground(new java.awt.Color(249, 255, 255));
        panel_1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        panel_1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Book's Title:");
        panel_1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        txtSearchYear.setBackground(new java.awt.Color(220, 220, 220));
        txtSearchYear.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtSearchYear.setForeground(new java.awt.Color(0, 51, 51));
        txtSearchYear.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panel_1.add(txtSearchYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 80, -1));

        txtSearchTitle.setBackground(new java.awt.Color(220, 220, 220));
        txtSearchTitle.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtSearchTitle.setForeground(new java.awt.Color(0, 51, 51));
        txtSearchTitle.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panel_1.add(txtSearchTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 340, -1));

        txtSearchAuthor.setBackground(new java.awt.Color(220, 220, 220));
        txtSearchAuthor.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        panel_1.add(txtSearchAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 340, -1));

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update1.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setBorderPainted(false);
        btnUpdate.setContentAreaFilled(false);
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        panel_1.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, 100, -1));

        jLabel23.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("ISBN:");
        panel_1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, -1, 20));

        jLabel25.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Book's Status:");
        panel_1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, -1, -1));

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setBorderPainted(false);
        btnDelete.setContentAreaFilled(false);
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        panel_1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, -1, -1));

        txtSearchStatus.setBackground(new java.awt.Color(220, 220, 220));
        txtSearchStatus.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtSearchStatus.setForeground(new java.awt.Color(0, 51, 51));
        txtSearchStatus.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panel_1.add(txtSearchStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 176, 140, -1));

        jLabel26.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("Book's Edition:");
        panel_1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        jLabel27.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Book's Category:");
        panel_1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, -1));

        jLabel28.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Author' Name:");
        panel_1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        txtSearchPublisher.setBackground(new java.awt.Color(220, 220, 220));
        txtSearchPublisher.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtSearchPublisher.setForeground(new java.awt.Color(0, 51, 51));
        txtSearchPublisher.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panel_1.add(txtSearchPublisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 340, -1));

        txtSearchBookEdition.setBackground(new java.awt.Color(220, 220, 220));
        txtSearchBookEdition.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtSearchBookEdition.setForeground(new java.awt.Color(0, 51, 51));
        txtSearchBookEdition.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panel_1.add(txtSearchBookEdition, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 70, -1));

        jLabel29.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("Publisher's Name:");
        panel_1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel31.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel31.setText("Year Published:");
        panel_1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, 20));

        txtSearchISBN.setBackground(new java.awt.Color(220, 220, 220));
        txtSearchISBN.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        panel_1.add(txtSearchISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 130, -1));

        txtSearchCategory.setBackground(new java.awt.Color(220, 220, 220));
        txtSearchCategory.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        panel_1.add(txtSearchCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 138, 140, 30));

        search_panel.add(panel_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 530, 260));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        btnSearch.setToolTipText("Click to seach");
        btnSearch.setBorderPainted(false);
        btnSearch.setContentAreaFilled(false);
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 0, 204));
        jLabel11.setText("Please Enter Book Accession Number: ");

        txtSearch.setBackground(new java.awt.Color(255, 204, 204));
        txtSearch.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
            }
        });
        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchMouseClicked(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        search_panel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true));

        table.setBackground(new java.awt.Color(173, 216, 230));
        table.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        table.setForeground(new java.awt.Color(0, 0, 204));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Accession Number", "Book's Title", "Author's Name", "Publisher's Name", "Book's Status"
            }
        ));
        table.setFillsViewportHeight(true);
        table.setName("table"); // NOI18N
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        scrollPane.setViewportView(table);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(search_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(search_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddNewRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewRecordActionPerformed
        //This ensures that no entry required is left blank
       // addNewDataToTable();
       if (txtISBN.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "ISBN not Provided.");
			txtISBN.requestFocus();
		} else if (txtTitle.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Book Title not Provided.");
			txtTitle.requestFocus();
		} else if (txtEdition.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Edition number not Provided.");
			txtEdition.requestFocus();
		} else if (txtPublisher.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Name of Pubnlisher not Provided.");
			txtPublisher.requestFocus();
		} else if (cboYear.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Year of publication required.");

		} else if (cboCategory.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Book's Category is required.");

		} else if (txtArthor.getText().equals(null)) {
			JOptionPane.showMessageDialog(null, "Authur's name is required.");
			txtArthor.requestFocus();
		} else {
                try {
                        book = getDetailData();
                        try {
                                int result = book.creatNewBook(book);

                                if (result == 1) {
                                    JOptionPane.showMessageDialog(null, "Successfully created a new User....");
                                    clearFields();
                                    model.setRowCount(0);// reset book's table on the form
                                    Show_Books_In_Table();// append the newly created to the table
                                                                                    

                                } else {
                                    JOptionPane.showMessageDialog(null, "Problemm creating a user......");
                                }
                        } catch (Exception e1) {
                                e1.printStackTrace();

                        }
                } catch (Exception e2) {

                }
		}

    }//GEN-LAST:event_btnAddNewRecordActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        //clearFields();//clears the entry of the fields
        clearFields();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if(!txtSearchISBN.getText().equals("")){
        try {
            book = getData();
            int reply = JOptionPane.showConfirmDialog(null,
                            "Do you really want to Update the record with ACCNO " + txtSearch.getText() + "?",
                            "Confirm Record Update", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (reply == JOptionPane.OK_OPTION) {
                book.updateBook(book); // update selected fields
                JOptionPane.showMessageDialog(null, "Successfully Updated..........");
                txtSearch.setText("");
                clearFieldsData();
                model.setRowCount(0);// reset user's table on the form
                Show_Books_In_Table();// append the newly created to the

            }

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Not successful......");// TODO:
																		// handle
																		// exception
		}
        }else{
            JOptionPane.showMessageDialog(null, "Please search for book to proceed");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        //deletes data from the database
        
        if(!txtSearchISBN.getText().equals("")){
        try {

                int reply = JOptionPane.showConfirmDialog(null,
                                "Do you really want to Delete the record with Accession Number " + txtSearch.getText() + "?",
                                "Confirm Record Deletion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (reply == JOptionPane.YES_OPTION) {
                    String query = "DELETE FROM books WHERE accno = " + txtSearch.getText();
                    book.deleteBook(query, "Deleted");
                    txtSearch.setText("");
                    model.setRowCount(0);// reset book's table on the form
                    Show_Books_In_Table();// append the newly created to the
                    clearFields();
                }

        } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Not successful......");
        }
        }else{
            JOptionPane.showMessageDialog(null, "Search for book to proceed");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
            
        if (txtSearch.getText().equals("")) {
        	} else
		do_search_table();

    }//GEN-LAST:event_txtSearchFocusLost

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
        txtSearch.setText("");//clears the search box
        clearFieldsData();//resets the fields to null

    }//GEN-LAST:event_txtSearchMouseClicked

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        //ensures entry for search operation is digit
        char c = evt.getKeyChar();
        if (!((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE))) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtSearchKeyTyped

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (!txtSearch.getText().equals("")) {
            do_search_table();
	} else{
            JOptionPane.showMessageDialog(null, "Empty search string, please supply book's ID");
        }
            
    }//GEN-LAST:event_btnSearchActionPerformed

    private void yearBookWasPublished(JComboBox cbo) {
        //method to to initialize year book was published
        gcal = new GregorianCalendar();
        int initYear;
        for (initYear = gcal.get(Calendar.YEAR); initYear > 1980; initYear--) {
                cbo.addItem(initYear);
        }

	}

    private Book getDetailData() {
        book.setIsbn(txtISBN.getText());
        book.setTitle(txtTitle.getText());
        book.setEdition(txtEdition.getText());
        book.setAuthor(txtArthor.getText());
        book.setPublisher(txtPublisher.getText());
        book.setCategory(cboCategory.getSelectedItem().toString());
        book.setYear(Integer.parseInt(cboYear.getSelectedItem().toString()));
        return book;
    }

    private void clearFields() {
        txtISBN.setText(null);
        txtPublisher.setText(null);
        txtArthor.setText(null);
        txtEdition.setText(null);
        txtTitle.setText(null);
        cboCategory.setSelectedIndex(0);
        cboYear.setSelectedIndex(0);
    }

    private void Show_Books_In_Table() {
        ArrayList<Book> list = book.getBookList();// call the method in book
        model = (DefaultTableModel) (table).getModel();
        Object[] row = new Object[5];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getAccno();
            row[1] = list.get(i).getTitle();
            row[2] = list.get(i).getAuthor();
            row[3] = list.get(i).getPublisher();
            row[4] = list.get(i).getStatus();

                model.addRow(row);
        }
    }

    private void do_search_table() {
        int id = Integer.parseInt(txtSearch.getText());
            int bookNo;
            boolean found = false;

            try {
                    con = ConnectDb.connect();
                    st = con.createStatement();

                    String sql = "SELECT * FROM books WHERE accno = " + id + "";

                    rs = st.executeQuery(sql);

                    rs.next();
                    bookNo = rs.getInt("accno");

                    if (bookNo == id) {
                        panel_1.setVisible(true);
                        found = true;
                        txtSearchISBN.setText("" + rs.getString("isbn"));
                        txtSearchYear.setText("" + rs.getString("year"));
                        txtSearchTitle.setText("" + rs.getString("title"));
                        txtSearchAuthor.setText("" + rs.getString("author"));
                        txtSearchPublisher.setText("" + rs.getString("publisher"));
                        txtSearchBookEdition.setText("" + rs.getString("edition"));
                        txtSearchCategory.setText("" + rs.getString("category"));
                        txtSearchStatus.setText("" + rs.getString("status"));

                    } else {
                            found = false;
                    }
            } catch (SQLException sqlex) {
                    if (found == false) {
                            // display warning message
                            JOptionPane.showMessageDialog(this, "Record not Found.");
                            txtSearch.setText("");
                            txtSearch.requestFocus();
                    }

            }
    }

    private Book getData() {
        book = new Book();
        book.setAccno(Integer.parseInt(txtSearch.getText()));
        book.setIsbn(txtSearchISBN.getText());
        book.setTitle(txtSearchTitle.getText());
        book.setAuthor(txtSearchAuthor.getText());
        book.setPublisher(txtSearchPublisher.getText());
        book.setYear(Integer.parseInt(txtSearchYear.getText()));
        book.setEdition(txtSearchBookEdition.getText());
        book.setCategory(txtSearchCategory.getText());
        

        
        return book;
    }

    private void clearFieldsData() {
        txtSearchISBN.setText("");
        txtSearchYear.setText("");
        txtSearchTitle.setText("");
        txtSearchAuthor.setText("");
        txtSearchPublisher.setText("");
        txtSearchBookEdition.setText("");
        txtSearchCategory.setText("");
        txtSearchStatus.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNewRecord;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboCategory;
    private javax.swing.JComboBox<String> cboYear;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel panel_1;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JPanel search_panel;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtArthor;
    private javax.swing.JTextField txtEdition;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtPublisher;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSearchAuthor;
    private javax.swing.JTextField txtSearchBookEdition;
    private javax.swing.JTextField txtSearchCategory;
    private javax.swing.JTextField txtSearchISBN;
    private javax.swing.JTextField txtSearchPublisher;
    private javax.swing.JTextField txtSearchStatus;
    private javax.swing.JTextField txtSearchTitle;
    private javax.swing.JTextField txtSearchYear;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
    
    
}
