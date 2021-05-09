
package hr.algebra.View;

import hr.algebra.Dal.RepoFactory;
import hr.algebra.Dal.Repository;
import hr.algebra.Model.User;
import hr.algebra.Model.UserRole;
import hr.algebra.utils.MessageUtils;
import java.awt.EventQueue;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.text.JTextComponent;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Marta
 */
public class LoginForm extends javax.swing.JFrame {

    private List<JTextComponent> validationFields;
    private List<JLabel> errorLabels;
    private Repository repository;
    private User loginUser;

    public LoginForm() {
        initComponents();
        init();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfUsername = new javax.swing.JTextField();
        pfPassword = new javax.swing.JPasswordField();
        btnLogIn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnSignUp = new javax.swing.JButton();
        lbPasswordError = new javax.swing.JLabel();
        lbUsernameError = new javax.swing.JLabel();
        lblMatchError = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(695, 588));
        setResizable(false);
        setSize(new java.awt.Dimension(695, 588));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Log In");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(300, 230, 90, 30);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(210, 390, 100, 16);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("New here?");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(470, 510, 100, 24);
        jLabel4.getAccessibleContext().setAccessibleName("");

        tfUsername.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfUsername.setToolTipText("");
        getContentPane().add(tfUsername);
        tfUsername.setBounds(210, 340, 260, 30);

        pfPassword.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        getContentPane().add(pfPassword);
        pfPassword.setBounds(210, 420, 260, 30);

        btnLogIn.setBackground(new java.awt.Color(255, 255, 255));
        btnLogIn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnLogIn.setText("Log in");
        btnLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogInActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogIn);
        btnLogIn.setBounds(300, 480, 75, 27);

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Username");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(210, 310, 100, 24);

        btnSignUp.setBackground(new java.awt.Color(255, 255, 255));
        btnSignUp.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSignUp.setText("Sign up");
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });
        getContentPane().add(btnSignUp);
        btnSignUp.setBounds(580, 510, 90, 27);

        lbPasswordError.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lbPasswordError.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(lbPasswordError);
        lbPasswordError.setBounds(480, 420, 40, 30);

        lbUsernameError.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lbUsernameError.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(lbUsernameError);
        lbUsernameError.setBounds(480, 340, 40, 30);

        lblMatchError.setForeground(new java.awt.Color(51, 153, 255));
        lblMatchError.setText("* Username and Password don't match");
        lblMatchError.setToolTipText("");
        getContentPane().add(lblMatchError);
        lblMatchError.setBounds(210, 450, 260, 14);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hr/algebra/Resources/CinestarAppImg.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 690, 560);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogInActionPerformed

        if (formValid()) {

            try {
                List<User> users = repository.getUsers();
                users.forEach(user -> checkIfLogInUser(user));

            } catch (Exception ex) {
                MessageUtils.showErrorMessage("Unrecoverable error", "Unable to get users data");
                System.exit(1);
            }
            if (loginUser == null) {
                clearForm();
                lblMatchError.setVisible(true);
            } else if (loginUser.getUserRole() == UserRole.ADMIN) {
                openAdminForm();
            } else {
                openUserForm();
            }
        }
    }//GEN-LAST:event_btnLogInActionPerformed
    private void checkIfLogInUser(User user) {
        String password = new String(pfPassword.getPassword());
        if (user.getUsername() == null ? tfUsername.getText() == null : user.getUsername().equals(tfUsername.getText())) {
            if (BCrypt.checkpw(password, user.getPassword())) {
                loginUser = user;
            }
        }

    }
    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        EventQueue.invokeLater(() -> {
            SignUpForm signUpForm;
            try {
                signUpForm = new SignUpForm();
                signUpForm.setVisible(true);
            } catch (Exception ex) {
                MessageUtils.showErrorMessage("Unrecoverable error", "Cannot open SignUp form");
            }
            dispose();
        });
    }//GEN-LAST:event_btnSignUpActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogIn;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbPasswordError;
    private javax.swing.JLabel lbUsernameError;
    private javax.swing.JLabel lblMatchError;
    private javax.swing.JPasswordField pfPassword;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables

    private void init() {
        try {
            lblMatchError.setVisible(false);
            initValidation();
            initRepository();
        } catch (Exception ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
            System.exit(1);
        }
    }

    private void initValidation() {
        validationFields = Arrays.asList(tfUsername, pfPassword);
        errorLabels = Arrays.asList(lbPasswordError, lbUsernameError);
    }

    private void initRepository() throws Exception {
        repository = RepoFactory.getRepository();
    }

    private void clearForm() {
        validationFields.forEach(e -> e.setText(""));
        errorLabels.forEach(e -> e.setText(""));
        lblMatchError.setVisible(false);
    }

    private boolean formValid() {
        boolean ok = true;

        for (int i = 0; i < validationFields.size(); i++) {
            ok &= !validationFields.get(i).getText().trim().isEmpty();
            errorLabels.get(i).setText(validationFields.get(i).getText().trim().isEmpty() ? "X" : "");
        }

        return ok;
    }

    private void openAdminForm() {
        EventQueue.invokeLater(() -> {
            AdminForm adminForm;
            try {
                adminForm = new AdminForm(loginUser);
                adminForm.setVisible(true);
            } catch (Exception ex) {
                MessageUtils.showErrorMessage("Unrecoverable error", "Cannot open admin form");
            }
            dispose();
        });
    }

    private void openUserForm() {
        EventQueue.invokeLater(() -> {
            UserForm userForm;
            try {
                userForm = new UserForm(loginUser);
                userForm.setVisible(true);
            } catch (Exception ex) {
                MessageUtils.showErrorMessage("Unrecoverable error", "Cannot open user form");
            }
            dispose();
        });
    }

}
