/*
 * This is the main class to start the Application
 * It load the splashscreen which later loads the login screen for the program
 * the password for the admin is admin
 * other users will choose username and password ro login to the system   
 */
package booklendingsystemlaunch;

import javax.swing.JOptionPane;
import security.Login;

public class BookLendingSystem {

    private static Splash splash;
    private static Login login;

    public static void main(String[] args) {
        //set nimbus look and feel for the screen
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        login = new Login();
        splash = new Splash();
        splash.setVisible(true);
        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(20);
                splash.loadingValue.setText(Integer.toString(i) + "%");
                splash.loadingBar.setValue(i);
                if (i == 100) {
                    splash.dispose();//close the screen
                    login.setVisible(true);//loads the login screen
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problem Loading Application");
        }//end of loading fomalities
    }

}
