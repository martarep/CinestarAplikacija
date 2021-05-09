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
public class SignUpForm extends javax.swing.JFrame {

    private List<JTextComponent> validationFields;
    private List<JLabel> errorLabels;
    private Repository repository;
    private User registerUser;
    private boolean userExists = false;

    public SignUpForm() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pfPassword = new javax.swing.JPasswordField();
        btnSignUp = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tfUsername = new javax.swing.JTextField();
        lblUserExistsError = new javax.swing.JLabel();
        lblNameError = new javax.swing.JLabel();
        lbPasswordError = new javax.swing.JLabel();
        lbUsernameError = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(695, 588));
        setResizable(false);
        setSize(new java.awt.Dimension(695, 88));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sign Up");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(290, 170, 120, 30);

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Name");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(210, 230, 100, 30);

        tfName.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfName.setToolTipText("");
        getContentPane().add(tfName);
        tfName.setBounds(210, 270, 260, 30);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(210, 390, 100, 16);

        pfPassword.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        getContentPane().add(pfPassword);
        pfPassword.setBounds(210, 420, 260, 30);

        btnSignUp.setBackground(new java.awt.Color(255, 255, 255));
        btnSignUp.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSignUp.setText("Sign up");
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });
        getContentPane().add(btnSignUp);
        btnSignUp.setBounds(290, 480, 100, 27);

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Username");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(210, 310, 100, 24);

        tfUsername.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfUsername.setToolTipText("");
        getContentPane().add(tfUsername);
        tfUsername.setBounds(210, 340, 260, 30);

        lblUserExistsError.setForeground(new java.awt.Color(51, 153, 255));
        lblUserExistsError.setText("* User already exists");
        lblUserExistsError.setToolTipText("");
        getContentPane().add(lblUserExistsError);
        lblUserExistsError.setBounds(210, 450, 260, 14);

        lblNameError.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblNameError.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(lblNameError);
        lblNameError.setBounds(480, 270, 40, 30);

        lbPasswordError.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lbPasswordError.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(lbPasswordError);
        lbPasswordError.setBounds(480, 420, 40, 30);

        lbUsernameError.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lbUsernameError.setForeground(new java.awt.Color(0, 153, 255));
        getContentPane().add(lbUsernameError);
        lbUsernameError.setBounds(480, 340, 40, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hr/algebra/Resources/CinestarAppImg.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 690, 560);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed

        if (formValid()) {

            String password = new String(pfPassword.getPassword());
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            registerUser = new User(
                    tfName.getText(),
                    tfUsername.getText(),
                    hashedPassword,
                    UserRole.USER);

            try {

                List<User> users = repository.getUsers();
                users.forEach(user -> checkIfUserExists(user));

                if (userExists) {
                    clearForm();
                    lblUserExistsError.setVisible(true);
                } else {
                    repository.createUser(registerUser);
                    openUserForm();
                }
            } catch (Exception ex) {
                Logger.getLogger(SignUpForm.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btnSignUpActionPerformed
    }
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSignUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lbPasswordError;
    private javax.swing.JLabel lbUsernameError;
    private javax.swing.JLabel lblNameError;
    private javax.swing.JLabel lblUserExistsError;
    private javax.swing.JPasswordField pfPassword;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables

    private void init() {
        try {
            lblUserExistsError.setVisible(false);
            initValidation();
            initRepository();
        } catch (Exception ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
            System.exit(1);
        }
    }

    private void initValidation() {
        validationFields = Arrays.asList(tfName, tfUsername, pfPassword);
        errorLabels = Arrays.asList(lblNameError, lbPasswordError, lbUsernameError);
    }

    private void initRepository() throws Exception {
        repository = RepoFactory.getRepository();
    }

    private void clearForm() {
        validationFields.forEach(e -> e.setText(""));
        errorLabels.forEach(e -> e.setText(""));
        lblUserExistsError.setVisible(false);
    }

    private boolean formValid() {
        boolean ok = true;

        for (int i = 0; i < validationFields.size(); i++) {
            ok &= !validationFields.get(i).getText().trim().isEmpty();
            errorLabels.get(i).setText(validationFields.get(i).getText().trim().isEmpty() ? "X" : "");
        }

        return ok;
    }

    private void openUserForm() {
        EventQueue.invokeLater(() -> {
            UserForm userForm;
            try {
                userForm = new UserForm(registerUser);
                userForm.setVisible(true);
            } catch (Exception ex) {
                MessageUtils.showErrorMessage("Unrecoverable error", "Cannot open user form");
            }
            dispose();
        });
    }

    private void checkIfUserExists(User user) {
        String password = new String(pfPassword.getPassword());
        if (user.getUsername() == null ? tfUsername.getText() == null : user.getUsername().equals(tfUsername.getText())) {
            if (BCrypt.checkpw(password, user.getPassword())) {
                userExists = true;
            }
        }
    }
}
