
package hr.algebra.View;

import hr.algebra.Dal.RepoFactory;
import hr.algebra.Dal.Repository;
import hr.algebra.Model.Movie;
import hr.algebra.Model.MovieAllData;
import hr.algebra.Model.MovieArchive;
import hr.algebra.Model.User;
import hr.algebra.parsers.Rss.CinestarParser;
import hr.algebra.utils.JAXBUtils;
import hr.algebra.utils.MessageUtils;
import java.awt.EventQueue;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Marta
 */
public class AdminForm extends javax.swing.JFrame {
    

      private List <MovieAllData> moviesData;
    private Repository repository;
     private static final String FILENAME = "moviearchive.xml";
 
    public AdminForm( User admin) {
        initComponents();
             lblHello.setText("Hello " + admin.getName() + "!");
         init();
    
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        lblHello = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnUpload = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnXML = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(695, 584));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("XML Download");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(280, 350, 160, 30);

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete);
        btnDelete.setBounds(300, 280, 120, 40);

        lblHello.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        lblHello.setForeground(new java.awt.Color(255, 255, 255));
        lblHello.setText("Hello!");
        getContentPane().add(lblHello);
        lblHello.setBounds(30, 20, 310, 30);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Upload new data to database");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(210, 90, 310, 30);

        btnUpload.setBackground(new java.awt.Color(255, 255, 255));
        btnUpload.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnUpload.setText("Upload");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpload);
        btnUpload.setBounds(300, 140, 120, 40);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Delete all data from database");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(210, 230, 310, 30);

        btnXML.setBackground(new java.awt.Color(255, 255, 255));
        btnXML.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnXML.setText("Download");
        btnXML.setEnabled(false);
        btnXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXMLActionPerformed(evt);
            }
        });
        getContentPane().add(btnXML);
        btnXML.setBounds(300, 410, 120, 40);

        btnLogOut.setBackground(new java.awt.Color(0, 0, 0));
        btnLogOut.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnLogOut.setForeground(new java.awt.Color(255, 255, 255));
        btnLogOut.setText("Log out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogOut);
        btnLogOut.setBounds(550, 10, 130, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hr/algebra/Resources/StarsBackground.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 695, 564);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
           try {
            List<MovieAllData> movies = CinestarParser.parse();
            repository.createMovies(movies);
              loadMovies();
            btnDelete.setEnabled(true);
            btnUpload.setEnabled(false);
             btnXML.setEnabled(true);
            MessageUtils.showInformationMessage("Data progress", "You successfully uploaded data!");
        } catch (Exception ex) {
            MessageUtils.showErrorMessage("Unrecoverable error", "Unable to upload movies");
            System.exit(1);
        }
    }//GEN-LAST:event_btnUploadActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
         try {
              File assets = new File("assets");
        if (assets.exists() && assets.isDirectory()) {
            File[] pictures = assets.listFiles();
            if (pictures != null) {
                for (File file : pictures) {
                    file.delete();
                }
            }
            btnDelete.setEnabled(false);
            btnUpload.setEnabled(true);
            btnXML.setEnabled(false);
        }
             repository.deleteAllMoviesData();
               MessageUtils.showInformationMessage("Data progress", "You successfully deleted data!");
         } catch (Exception ex) {
              MessageUtils.showErrorMessage("Unrecoverable error", "Unable to delete movies data");
            System.exit(1);
         }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXMLActionPerformed

          try {
              JAXBUtils.save(new MovieArchive(moviesData), FILENAME);
                  MessageUtils.showInformationMessage("Info", "Movies saved");
          } catch (JAXBException ex) {
                 MessageUtils.showErrorMessage("Error", "Unable to save movies");
              Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
          }
        
    
    }//GEN-LAST:event_btnXMLActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
 EventQueue.invokeLater(() -> {
            LoginForm logInForm;
            try {
                logInForm = new LoginForm();
                logInForm.setVisible(true);
            } catch (Exception ex) {
                   MessageUtils.showErrorMessage("Unrecoverable error", "Cannot open Log in form");
            }
            dispose();
       });
    }//GEN-LAST:event_btnLogOutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnUpload;
    private javax.swing.JButton btnXML;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblHello;
    // End of variables declaration//GEN-END:variables

    private void init() {

         try {
             repository = RepoFactory.getRepository();
         } catch (Exception ex) {
             Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
         }

    }

    private void loadMovies() throws Exception {
       moviesData = new ArrayList<MovieAllData> ();
        List<Movie> movies = repository.getMovies();
        for (Movie m : movies) {
           MovieAllData movieData = new MovieAllData();
           movieData.setMovie(m);
           movieData.setActors(repository.getMovieActors(m.getId()));
           movieData.setDirectors(repository.getMovieDirectors(m.getId()));
           movieData.setGenres(repository.getMovieGenres(m.getId()));
           
           moviesData.add(movieData);
        }
 
    }

    
}
