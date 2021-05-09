
package hr.algebra.View;

import hr.algebra.Dal.RepoFactory;
import hr.algebra.Dal.Repository;
import hr.algebra.Model.Movie;
import hr.algebra.Model.Person;
import hr.algebra.Model.Genre;
import hr.algebra.Model.MovieTableModel;
import hr.algebra.Model.PersonFunction;
import hr.algebra.Model.PersonTransferable;
import hr.algebra.Model.User;
import hr.algebra.utils.FileUtils;
import hr.algebra.utils.IconUtils;
import hr.algebra.utils.MessageUtils;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.TransferHandler;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Marta
 */
public class UserForm extends javax.swing.JFrame {

    private List<JTextComponent> validationFields;
    private List<JLabel> errorLabels;

    private static final Random RANDOM = new Random();
    private static final String DIR = "assets";

    private Repository repository;
    private MovieTableModel moviesTableModel;
    private Movie selectedMovie;
    private int selectedCbMovieId;
    private JPanel activePanel = new JPanel();
    private final DefaultComboBoxModel<Movie> movieModel = new DefaultComboBoxModel<>();
    private final DefaultListModel<Person> actorModel = new DefaultListModel<>();
    private final DefaultListModel<Person> actorMovieModel = new DefaultListModel<>();
    private final DefaultListModel<Person> directorMovieModel = new DefaultListModel<>();
    private final DefaultListModel<Person> directorModel = new DefaultListModel<>();
    private final DefaultListModel<Genre> genreMovieModel = new DefaultListModel<>();
    private final DefaultListModel<Genre> genreModel = new DefaultListModel<>();
    private List<Movie> movies = new ArrayList<>();
    private List<Person> allActors = new ArrayList<>();
    private List<Person> movieActors = new ArrayList<>();
    private List<Person> allDirectors = new ArrayList<>();
    private List<Person> movieDirectors = new ArrayList<>();
    private List<Genre> allGenres = new ArrayList<>();
    private List<Genre> movieGenres = new ArrayList<>();

    private Person personToTransfer;

    public UserForm(User user) {

        initComponents();
        hideComponents();
        try {
            initRepository();
            initMovies();
            initABG();
            initDragNDrop();

        } catch (Exception ex) {
            Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
            System.exit(1);
        }
        mMovie.setSelected(true);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpABG = new javax.swing.JTabbedPane();
        pnlViewEditADG = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        lbStartingDate3 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        cbMovies = new javax.swing.JComboBox<>();
        jScrollPane13 = new javax.swing.JScrollPane();
        lbMovieGenres = new javax.swing.JList<>();
        jScrollPane14 = new javax.swing.JScrollPane();
        lbAllDirectors = new javax.swing.JList<>();
        jScrollPane15 = new javax.swing.JScrollPane();
        lbAllActors = new javax.swing.JList<>();
        jScrollPane16 = new javax.swing.JScrollPane();
        lbAllGenres = new javax.swing.JList<>();
        jScrollPane17 = new javax.swing.JScrollPane();
        lbMovieActors = new javax.swing.JList<>();
        jScrollPane18 = new javax.swing.JScrollPane();
        lbMovieDirectors = new javax.swing.JList<>();
        btnRemoveDirector = new javax.swing.JButton();
        btnAddDirector = new javax.swing.JButton();
        btnRemoveGenre = new javax.swing.JButton();
        btnAddGenre = new javax.swing.JButton();
        btnAddActor = new javax.swing.JButton();
        btnRemoveActor = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        pnlAddADG = new javax.swing.JPanel();
        lbStartingDate6 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        btnAddAddDirector = new javax.swing.JButton();
        btnAddAddGenre = new javax.swing.JButton();
        btnAddAddActor = new javax.swing.JButton();
        tfActorSurname = new javax.swing.JTextField();
        tfActorName = new javax.swing.JTextField();
        tfDirectorSurname = new javax.swing.JTextField();
        tfGenreName = new javax.swing.JTextField();
        tfDirectorName = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lbGenreNameError = new javax.swing.JLabel();
        lbDirectorSurnameError = new javax.swing.JLabel();
        lbActorNameError = new javax.swing.JLabel();
        lbActorSurnameError = new javax.swing.JLabel();
        lbDirectorNameError = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        pnlDeleteADG = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jScrollPane27 = new javax.swing.JScrollPane();
        lbDeleteAllDirectors = new javax.swing.JList<>();
        jScrollPane28 = new javax.swing.JScrollPane();
        lbDeleteAllGenres = new javax.swing.JList<>();
        btnDeleteDirector = new javax.swing.JButton();
        btnDeleteGenre = new javax.swing.JButton();
        btnDeleteActor = new javax.swing.JButton();
        jScrollPane29 = new javax.swing.JScrollPane();
        lbDeleteAllActors = new javax.swing.JList<>();
        jLabel22 = new javax.swing.JLabel();
        tpMovies = new javax.swing.JTabbedPane();
        pnlViewMovie = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lbStartingDate = new javax.swing.JLabel();
        lbPicture = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbDuration = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMovies = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        taDescription = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        pnlEditMovie = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbStartingDate1 = new javax.swing.JLabel();
        lbEditPicture = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbDuration1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbEditMovies = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        taEditDescription = new javax.swing.JTextArea();
        tfEditDuration = new javax.swing.JTextField();
        tfEditStartingDate = new javax.swing.JTextField();
        tfEditPath = new javax.swing.JTextField();
        tfEditTitle = new javax.swing.JTextField();
        btnEditUpload = new javax.swing.JButton();
        btnSaveEdit = new javax.swing.JButton();
        lbEditDescriptionError = new javax.swing.JLabel();
        lbEditDurationError = new javax.swing.JLabel();
        lbEditStartingDateError = new javax.swing.JLabel();
        lbEditPictureError = new javax.swing.JLabel();
        lbEditTitleError = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        pnlAddMovie = new javax.swing.JPanel();
        btnAddMovie = new javax.swing.JButton();
        btnAddUpload = new javax.swing.JButton();
        tfAddTitle = new javax.swing.JTextField();
        tfAddPath = new javax.swing.JTextField();
        tfAddStartingDate = new javax.swing.JTextField();
        tfAddDuration = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbAddPicture = new javax.swing.JLabel();
        lbStartingDate2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        taAddDescription = new javax.swing.JTextArea();
        lbAddTitleError = new javax.swing.JLabel();
        lbAddDurationError = new javax.swing.JLabel();
        lbAddStartingDateError = new javax.swing.JLabel();
        lbAddPictureError = new javax.swing.JLabel();
        lbAddDescriptionError = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        pnlDelete = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbDeleteMovies = new javax.swing.JTable();
        btnDeleteMovie = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mMovie = new javax.swing.JMenu();
        mADG = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(688, 850));
        setSize(new java.awt.Dimension(688, 850));
        getContentPane().setLayout(null);

        tpABG.setBackground(new java.awt.Color(255, 255, 255));
        tpABG.setName("Int"); // NOI18N
        tpABG.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tpABGStateChanged(evt);
            }
        });

        pnlViewEditADG.setBackground(new java.awt.Color(0, 0, 0));
        pnlViewEditADG.setLayout(null);

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("All Directors:");
        pnlViewEditADG.add(jLabel15);
        jLabel15.setBounds(370, 70, 80, 30);

        lbStartingDate3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbStartingDate3.setForeground(new java.awt.Color(255, 255, 255));
        lbStartingDate3.setText("Genres:");
        pnlViewEditADG.add(lbStartingDate3);
        lbStartingDate3.setBounds(30, 410, 70, 30);

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Movie:");
        pnlViewEditADG.add(jLabel16);
        jLabel16.setBounds(30, 30, 50, 20);

        jLabel17.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("All genres:");
        pnlViewEditADG.add(jLabel17);
        jLabel17.setBounds(370, 410, 70, 30);

        jLabel27.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Directors:");
        pnlViewEditADG.add(jLabel27);
        jLabel27.setBounds(30, 70, 80, 30);

        jLabel28.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Actors:");
        pnlViewEditADG.add(jLabel28);
        jLabel28.setBounds(30, 240, 70, 30);

        jLabel29.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("All actors:");
        pnlViewEditADG.add(jLabel29);
        jLabel29.setBounds(370, 240, 70, 30);

        cbMovies.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMoviesItemStateChanged(evt);
            }
        });
        pnlViewEditADG.add(cbMovies);
        cbMovies.setBounds(80, 30, 270, 20);

        jScrollPane13.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane13.setForeground(new java.awt.Color(255, 255, 255));

        lbMovieGenres.setBackground(new java.awt.Color(0, 0, 0));
        lbMovieGenres.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane13.setViewportView(lbMovieGenres);

        pnlViewEditADG.add(jScrollPane13);
        jScrollPane13.setBounds(30, 440, 260, 100);

        jScrollPane14.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane14.setForeground(new java.awt.Color(255, 255, 255));

        lbAllDirectors.setBackground(new java.awt.Color(0, 0, 0));
        lbAllDirectors.setForeground(new java.awt.Color(255, 255, 255));
        lbAllDirectors.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lbAllDirectorsValueChanged(evt);
            }
        });
        jScrollPane14.setViewportView(lbAllDirectors);

        pnlViewEditADG.add(jScrollPane14);
        jScrollPane14.setBounds(370, 100, 260, 100);

        jScrollPane15.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane15.setForeground(new java.awt.Color(255, 255, 255));

        lbAllActors.setBackground(new java.awt.Color(0, 0, 0));
        lbAllActors.setForeground(new java.awt.Color(255, 255, 255));
        lbAllActors.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lbAllActorsValueChanged(evt);
            }
        });
        jScrollPane15.setViewportView(lbAllActors);

        pnlViewEditADG.add(jScrollPane15);
        jScrollPane15.setBounds(370, 270, 260, 100);

        jScrollPane16.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane16.setForeground(new java.awt.Color(255, 255, 255));

        lbAllGenres.setBackground(new java.awt.Color(0, 0, 0));
        lbAllGenres.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane16.setViewportView(lbAllGenres);

        pnlViewEditADG.add(jScrollPane16);
        jScrollPane16.setBounds(370, 440, 260, 100);

        jScrollPane17.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane17.setForeground(new java.awt.Color(255, 255, 255));

        lbMovieActors.setBackground(new java.awt.Color(0, 0, 0));
        lbMovieActors.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane17.setViewportView(lbMovieActors);

        pnlViewEditADG.add(jScrollPane17);
        jScrollPane17.setBounds(30, 270, 260, 100);

        jScrollPane18.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane18.setForeground(new java.awt.Color(255, 255, 255));

        lbMovieDirectors.setBackground(new java.awt.Color(0, 0, 0));
        lbMovieDirectors.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane18.setViewportView(lbMovieDirectors);

        pnlViewEditADG.add(jScrollPane18);
        jScrollPane18.setBounds(30, 100, 260, 100);

        btnRemoveDirector.setText("Remove director");
        btnRemoveDirector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveDirectorActionPerformed(evt);
            }
        });
        pnlViewEditADG.add(btnRemoveDirector);
        btnRemoveDirector.setBounds(30, 210, 160, 23);

        btnAddDirector.setText("Add director");
        btnAddDirector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDirectorActionPerformed(evt);
            }
        });
        pnlViewEditADG.add(btnAddDirector);
        btnAddDirector.setBounds(370, 210, 150, 23);

        btnRemoveGenre.setText("Remove genre");
        btnRemoveGenre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveGenreActionPerformed(evt);
            }
        });
        pnlViewEditADG.add(btnRemoveGenre);
        btnRemoveGenre.setBounds(30, 550, 160, 23);

        btnAddGenre.setText("Add genre");
        btnAddGenre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddGenreActionPerformed(evt);
            }
        });
        pnlViewEditADG.add(btnAddGenre);
        btnAddGenre.setBounds(370, 550, 150, 23);

        btnAddActor.setText("Add actor");
        btnAddActor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActorActionPerformed(evt);
            }
        });
        pnlViewEditADG.add(btnAddActor);
        btnAddActor.setBounds(370, 380, 150, 23);

        btnRemoveActor.setText("Remove actor");
        btnRemoveActor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActorActionPerformed(evt);
            }
        });
        pnlViewEditADG.add(btnRemoveActor);
        btnRemoveActor.setBounds(30, 380, 160, 23);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hr/algebra/Resources/StarsBackground.png"))); // NOI18N
        pnlViewEditADG.add(jLabel18);
        jLabel18.setBounds(-10, 0, 695, 590);

        tpABG.addTab("View & Edit", pnlViewEditADG);

        pnlAddADG.setBackground(new java.awt.Color(0, 0, 0));
        pnlAddADG.setLayout(null);

        lbStartingDate6.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        lbStartingDate6.setForeground(new java.awt.Color(255, 255, 255));
        lbStartingDate6.setText("Genre:");
        pnlAddADG.add(lbStartingDate6);
        lbStartingDate6.setBounds(60, 410, 70, 30);

        jLabel33.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Director:");
        pnlAddADG.add(jLabel33);
        jLabel33.setBounds(60, 50, 80, 30);

        jLabel35.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Actor:");
        pnlAddADG.add(jLabel35);
        jLabel35.setBounds(370, 250, 70, 30);

        btnAddAddDirector.setText("Add director");
        btnAddAddDirector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAddDirectorActionPerformed(evt);
            }
        });
        pnlAddADG.add(btnAddAddDirector);
        btnAddAddDirector.setBounds(60, 190, 160, 23);

        btnAddAddGenre.setText("Add genre");
        btnAddAddGenre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAddGenreActionPerformed(evt);
            }
        });
        pnlAddADG.add(btnAddAddGenre);
        btnAddAddGenre.setBounds(60, 510, 160, 23);

        btnAddAddActor.setText("Add actor");
        btnAddAddActor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAddActorActionPerformed(evt);
            }
        });
        pnlAddADG.add(btnAddAddActor);
        btnAddAddActor.setBounds(370, 390, 150, 23);

        tfActorSurname.setBackground(new java.awt.Color(0, 0, 0));
        tfActorSurname.setForeground(new java.awt.Color(255, 255, 255));
        pnlAddADG.add(tfActorSurname);
        tfActorSurname.setBounds(430, 340, 190, 30);

        tfActorName.setBackground(new java.awt.Color(0, 0, 0));
        tfActorName.setForeground(new java.awt.Color(255, 255, 255));
        pnlAddADG.add(tfActorName);
        tfActorName.setBounds(430, 290, 190, 30);

        tfDirectorSurname.setBackground(new java.awt.Color(0, 0, 0));
        tfDirectorSurname.setForeground(new java.awt.Color(255, 255, 255));
        pnlAddADG.add(tfDirectorSurname);
        tfDirectorSurname.setBounds(120, 140, 190, 30);

        tfGenreName.setBackground(new java.awt.Color(0, 0, 0));
        tfGenreName.setForeground(new java.awt.Color(255, 255, 255));
        pnlAddADG.add(tfGenreName);
        tfGenreName.setBounds(110, 450, 200, 30);

        tfDirectorName.setBackground(new java.awt.Color(0, 0, 0));
        tfDirectorName.setForeground(new java.awt.Color(255, 255, 255));
        pnlAddADG.add(tfDirectorName);
        tfDirectorName.setBounds(120, 90, 190, 30);

        jLabel23.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Surname:");
        pnlAddADG.add(jLabel23);
        jLabel23.setBounds(370, 340, 60, 30);

        jLabel24.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Name:");
        pnlAddADG.add(jLabel24);
        jLabel24.setBounds(370, 290, 40, 30);

        jLabel25.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Name:");
        pnlAddADG.add(jLabel25);
        jLabel25.setBounds(60, 450, 37, 30);

        jLabel26.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Name:");
        pnlAddADG.add(jLabel26);
        jLabel26.setBounds(60, 90, 37, 30);

        jLabel30.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Surname:");
        pnlAddADG.add(jLabel30);
        jLabel30.setBounds(60, 140, 60, 30);

        lbGenreNameError.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbGenreNameError.setForeground(new java.awt.Color(0, 153, 255));
        pnlAddADG.add(lbGenreNameError);
        lbGenreNameError.setBounds(320, 460, 20, 20);

        lbDirectorSurnameError.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbDirectorSurnameError.setForeground(new java.awt.Color(0, 153, 255));
        pnlAddADG.add(lbDirectorSurnameError);
        lbDirectorSurnameError.setBounds(320, 140, 20, 20);

        lbActorNameError.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbActorNameError.setForeground(new java.awt.Color(0, 153, 255));
        pnlAddADG.add(lbActorNameError);
        lbActorNameError.setBounds(630, 300, 20, 20);

        lbActorSurnameError.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbActorSurnameError.setForeground(new java.awt.Color(0, 153, 255));
        pnlAddADG.add(lbActorSurnameError);
        lbActorSurnameError.setBounds(630, 340, 20, 20);

        lbDirectorNameError.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbDirectorNameError.setForeground(new java.awt.Color(0, 153, 255));
        pnlAddADG.add(lbDirectorNameError);
        lbDirectorNameError.setBounds(320, 100, 20, 20);

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hr/algebra/Resources/StarsBackground.png"))); // NOI18N
        pnlAddADG.add(jLabel36);
        jLabel36.setBounds(-10, 0, 695, 590);

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hr/algebra/Resources/StarsBackground.png"))); // NOI18N
        pnlAddADG.add(jLabel37);
        jLabel37.setBounds(0, 60, 695, 550);

        tpABG.addTab("Add", pnlAddADG);

        pnlDeleteADG.setBackground(new java.awt.Color(0, 0, 0));
        pnlDeleteADG.setLayout(null);

        jLabel19.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("All Directors:");
        pnlDeleteADG.add(jLabel19);
        jLabel19.setBounds(50, 50, 80, 30);

        jLabel21.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("All genres:");
        pnlDeleteADG.add(jLabel21);
        jLabel21.setBounds(30, 400, 70, 30);

        jLabel39.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("All actors:");
        pnlDeleteADG.add(jLabel39);
        jLabel39.setBounds(360, 230, 70, 30);

        jScrollPane27.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane27.setForeground(new java.awt.Color(255, 255, 255));

        lbDeleteAllDirectors.setBackground(new java.awt.Color(0, 0, 0));
        lbDeleteAllDirectors.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane27.setViewportView(lbDeleteAllDirectors);

        pnlDeleteADG.add(jScrollPane27);
        jScrollPane27.setBounds(50, 80, 260, 100);

        jScrollPane28.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane28.setForeground(new java.awt.Color(255, 255, 255));

        lbDeleteAllGenres.setBackground(new java.awt.Color(0, 0, 0));
        lbDeleteAllGenres.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane28.setViewportView(lbDeleteAllGenres);

        pnlDeleteADG.add(jScrollPane28);
        jScrollPane28.setBounds(30, 430, 260, 100);

        btnDeleteDirector.setText("Delete director");
        btnDeleteDirector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDirectorActionPerformed(evt);
            }
        });
        pnlDeleteADG.add(btnDeleteDirector);
        btnDeleteDirector.setBounds(50, 200, 160, 23);

        btnDeleteGenre.setText("Delete genre");
        btnDeleteGenre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteGenreActionPerformed(evt);
            }
        });
        pnlDeleteADG.add(btnDeleteGenre);
        btnDeleteGenre.setBounds(30, 540, 160, 23);

        btnDeleteActor.setText("Delete actor");
        btnDeleteActor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActorActionPerformed(evt);
            }
        });
        pnlDeleteADG.add(btnDeleteActor);
        btnDeleteActor.setBounds(360, 370, 160, 23);

        jScrollPane29.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane29.setForeground(new java.awt.Color(255, 255, 255));

        lbDeleteAllActors.setBackground(new java.awt.Color(0, 0, 0));
        lbDeleteAllActors.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane29.setViewportView(lbDeleteAllActors);

        pnlDeleteADG.add(jScrollPane29);
        jScrollPane29.setBounds(360, 260, 260, 100);

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hr/algebra/Resources/StarsBackground.png"))); // NOI18N
        pnlDeleteADG.add(jLabel22);
        jLabel22.setBounds(-10, 0, 695, 590);

        tpABG.addTab("Delete", pnlDeleteADG);

        getContentPane().add(tpABG);
        tpABG.setBounds(0, 180, 690, 640);

        tpMovies.setBackground(new java.awt.Color(255, 255, 255));
        tpMovies.setName("Int"); // NOI18N
        tpMovies.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tpMoviesStateChanged(evt);
            }
        });

        pnlViewMovie.setBackground(new java.awt.Color(0, 0, 0));
        pnlViewMovie.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Why you have to watch this movie?");
        pnlViewMovie.add(jLabel3);
        jLabel3.setBounds(10, 70, 270, 20);

        lblTitle.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        pnlViewMovie.add(lblTitle);
        lblTitle.setBounds(50, 20, 290, 20);

        lbStartingDate.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbStartingDate.setForeground(new java.awt.Color(255, 255, 255));
        lbStartingDate.setText("Watch it in cinema from:");
        pnlViewMovie.add(lbStartingDate);
        lbStartingDate.setBounds(340, 380, 340, 20);

        lbPicture.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        lbPicture.setForeground(new java.awt.Color(255, 255, 255));
        pnlViewMovie.add(lbPicture);
        lbPicture.setBounds(350, 10, 320, 360);

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Title:");
        pnlViewMovie.add(jLabel6);
        jLabel6.setBounds(10, 20, 50, 20);

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Duration:");
        pnlViewMovie.add(jLabel7);
        jLabel7.setBounds(10, 380, 70, 20);

        lbDuration.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lbDuration.setForeground(new java.awt.Color(255, 255, 255));
        pnlViewMovie.add(lbDuration);
        lbDuration.setBounds(80, 380, 80, 20);

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 0));

        tbMovies.setBackground(new java.awt.Color(0, 0, 0));
        tbMovies.setForeground(new java.awt.Color(255, 255, 255));
        tbMovies.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbMovies.setSelectionBackground(new java.awt.Color(0, 0, 0));
        tbMovies.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMoviesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbMovies);

        pnlViewMovie.add(jScrollPane1);
        jScrollPane1.setBounds(0, 430, 660, 180);

        taDescription.setEditable(false);
        taDescription.setBackground(new java.awt.Color(0, 0, 0));
        taDescription.setColumns(20);
        taDescription.setForeground(new java.awt.Color(255, 255, 255));
        taDescription.setLineWrap(true);
        taDescription.setRows(5);
        jScrollPane2.setViewportView(taDescription);

        pnlViewMovie.add(jScrollPane2);
        jScrollPane2.setBounds(10, 100, 310, 270);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hr/algebra/Resources/StarsBackground.png"))); // NOI18N
        pnlViewMovie.add(jLabel2);
        jLabel2.setBounds(-10, 0, 695, 590);

        tpMovies.addTab("View", pnlViewMovie);

        pnlEditMovie.setBackground(new java.awt.Color(0, 0, 0));
        pnlEditMovie.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Description:");
        pnlEditMovie.add(jLabel4);
        jLabel4.setBounds(10, 50, 270, 20);

        lbStartingDate1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbStartingDate1.setForeground(new java.awt.Color(255, 255, 255));
        lbStartingDate1.setText("Starting date:");
        pnlEditMovie.add(lbStartingDate1);
        lbStartingDate1.setBounds(20, 380, 90, 30);
        lbStartingDate1.getAccessibleContext().setAccessibleName("");

        lbEditPicture.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        lbEditPicture.setForeground(new java.awt.Color(255, 255, 255));
        lbEditPicture.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlEditMovie.add(lbEditPicture);
        lbEditPicture.setBounds(350, 20, 260, 300);

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Title:");
        pnlEditMovie.add(jLabel8);
        jLabel8.setBounds(10, 10, 50, 30);

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Duration:");
        pnlEditMovie.add(jLabel9);
        jLabel9.setBounds(20, 330, 70, 30);

        lbDuration1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lbDuration1.setForeground(new java.awt.Color(255, 255, 255));
        pnlEditMovie.add(lbDuration1);
        lbDuration1.setBounds(80, 380, 80, 20);

        jScrollPane3.setBackground(new java.awt.Color(0, 0, 0));

        tbEditMovies.setBackground(new java.awt.Color(0, 0, 0));
        tbEditMovies.setForeground(new java.awt.Color(255, 255, 255));
        tbEditMovies.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbEditMovies.setSelectionBackground(new java.awt.Color(0, 0, 0));
        tbEditMovies.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMoviesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbEditMovies);

        pnlEditMovie.add(jScrollPane3);
        jScrollPane3.setBounds(0, 430, 660, 180);

        taEditDescription.setBackground(new java.awt.Color(0, 0, 0));
        taEditDescription.setColumns(20);
        taEditDescription.setForeground(new java.awt.Color(255, 255, 255));
        taEditDescription.setLineWrap(true);
        taEditDescription.setRows(5);
        jScrollPane4.setViewportView(taEditDescription);

        pnlEditMovie.add(jScrollPane4);
        jScrollPane4.setBounds(10, 80, 270, 230);

        tfEditDuration.setBackground(new java.awt.Color(0, 0, 0));
        tfEditDuration.setForeground(new java.awt.Color(255, 255, 255));
        tfEditDuration.setName("Int"); // NOI18N
        pnlEditMovie.add(tfEditDuration);
        tfEditDuration.setBounds(80, 330, 50, 30);

        tfEditStartingDate.setBackground(new java.awt.Color(0, 0, 0));
        tfEditStartingDate.setForeground(new java.awt.Color(255, 255, 255));
        tfEditStartingDate.setName("Date"); // NOI18N
        pnlEditMovie.add(tfEditStartingDate);
        tfEditStartingDate.setBounds(110, 380, 160, 30);

        tfEditPath.setBackground(new java.awt.Color(0, 0, 0));
        tfEditPath.setForeground(new java.awt.Color(255, 255, 255));
        pnlEditMovie.add(tfEditPath);
        tfEditPath.setBounds(350, 340, 200, 30);

        tfEditTitle.setBackground(new java.awt.Color(0, 0, 0));
        tfEditTitle.setForeground(new java.awt.Color(255, 255, 255));
        pnlEditMovie.add(tfEditTitle);
        tfEditTitle.setBounds(50, 10, 230, 30);

        btnEditUpload.setText("Upload");
        btnEditUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditUploadActionPerformed(evt);
            }
        });
        pnlEditMovie.add(btnEditUpload);
        btnEditUpload.setBounds(560, 340, 80, 30);

        btnSaveEdit.setText("Save changes");
        btnSaveEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveEditActionPerformed(evt);
            }
        });
        pnlEditMovie.add(btnSaveEdit);
        btnSaveEdit.setBounds(350, 390, 290, 30);

        lbEditDescriptionError.setBackground(new java.awt.Color(0, 0, 0));
        lbEditDescriptionError.setForeground(new java.awt.Color(0, 153, 255));
        pnlEditMovie.add(lbEditDescriptionError);
        lbEditDescriptionError.setBounds(290, 270, 30, 40);

        lbEditDurationError.setBackground(new java.awt.Color(0, 0, 0));
        lbEditDurationError.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbEditDurationError.setForeground(new java.awt.Color(0, 153, 255));
        pnlEditMovie.add(lbEditDurationError);
        lbEditDurationError.setBounds(140, 330, 30, 30);

        lbEditStartingDateError.setBackground(new java.awt.Color(0, 0, 0));
        lbEditStartingDateError.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbEditStartingDateError.setForeground(new java.awt.Color(0, 153, 255));
        pnlEditMovie.add(lbEditStartingDateError);
        lbEditStartingDateError.setBounds(280, 380, 30, 30);

        lbEditPictureError.setBackground(new java.awt.Color(0, 0, 0));
        lbEditPictureError.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbEditPictureError.setForeground(new java.awt.Color(0, 153, 255));
        pnlEditMovie.add(lbEditPictureError);
        lbEditPictureError.setBounds(620, 280, 40, 40);

        lbEditTitleError.setBackground(new java.awt.Color(0, 0, 0));
        lbEditTitleError.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbEditTitleError.setForeground(new java.awt.Color(0, 153, 255));
        pnlEditMovie.add(lbEditTitleError);
        lbEditTitleError.setBounds(290, 10, 30, 30);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hr/algebra/Resources/StarsBackground.png"))); // NOI18N
        pnlEditMovie.add(jLabel10);
        jLabel10.setBounds(-10, 0, 695, 610);

        tpMovies.addTab("Edit", pnlEditMovie);

        pnlAddMovie.setBackground(new java.awt.Color(0, 0, 0));
        pnlAddMovie.setLayout(null);

        btnAddMovie.setText("Add movie");
        btnAddMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMovieActionPerformed(evt);
            }
        });
        pnlAddMovie.add(btnAddMovie);
        btnAddMovie.setBounds(190, 510, 310, 30);

        btnAddUpload.setText("Upload");
        btnAddUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUploadActionPerformed(evt);
            }
        });
        pnlAddMovie.add(btnAddUpload);
        btnAddUpload.setBounds(590, 460, 65, 30);

        tfAddTitle.setBackground(new java.awt.Color(0, 0, 0));
        tfAddTitle.setForeground(new java.awt.Color(255, 255, 255));
        pnlAddMovie.add(tfAddTitle);
        tfAddTitle.setBounds(50, 40, 240, 30);

        tfAddPath.setBackground(new java.awt.Color(0, 0, 0));
        tfAddPath.setForeground(new java.awt.Color(255, 255, 255));
        pnlAddMovie.add(tfAddPath);
        tfAddPath.setBounds(400, 460, 170, 30);

        tfAddStartingDate.setBackground(new java.awt.Color(0, 0, 0));
        tfAddStartingDate.setForeground(new java.awt.Color(255, 255, 255));
        tfAddStartingDate.setName("Date"); // NOI18N
        pnlAddMovie.add(tfAddStartingDate);
        tfAddStartingDate.setBounds(120, 460, 160, 30);
        tfAddStartingDate.getAccessibleContext().setAccessibleName("");

        tfAddDuration.setBackground(new java.awt.Color(0, 0, 0));
        tfAddDuration.setForeground(new java.awt.Color(255, 255, 255));
        tfAddDuration.setName("Int"); // NOI18N
        pnlAddMovie.add(tfAddDuration);
        tfAddDuration.setBounds(90, 400, 50, 30);

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Duration:");
        pnlAddMovie.add(jLabel11);
        jLabel11.setBounds(20, 400, 70, 30);

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Title:");
        pnlAddMovie.add(jLabel12);
        jLabel12.setBounds(10, 40, 50, 30);

        lbAddPicture.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        lbAddPicture.setForeground(new java.awt.Color(255, 255, 255));
        lbAddPicture.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlAddMovie.add(lbAddPicture);
        lbAddPicture.setBounds(390, 20, 240, 400);

        lbStartingDate2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbStartingDate2.setForeground(new java.awt.Color(255, 255, 255));
        lbStartingDate2.setText("Starting date:");
        pnlAddMovie.add(lbStartingDate2);
        lbStartingDate2.setBounds(20, 460, 110, 30);

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Description:");
        pnlAddMovie.add(jLabel13);
        jLabel13.setBounds(10, 100, 270, 20);

        taAddDescription.setBackground(new java.awt.Color(0, 0, 0));
        taAddDescription.setColumns(20);
        taAddDescription.setForeground(new java.awt.Color(255, 255, 255));
        taAddDescription.setLineWrap(true);
        taAddDescription.setRows(5);
        jScrollPane5.setViewportView(taAddDescription);

        pnlAddMovie.add(jScrollPane5);
        jScrollPane5.setBounds(10, 140, 290, 230);

        lbAddTitleError.setBackground(new java.awt.Color(0, 0, 0));
        lbAddTitleError.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbAddTitleError.setForeground(new java.awt.Color(0, 153, 255));
        pnlAddMovie.add(lbAddTitleError);
        lbAddTitleError.setBounds(310, 40, 30, 30);

        lbAddDurationError.setBackground(new java.awt.Color(0, 0, 0));
        lbAddDurationError.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbAddDurationError.setForeground(new java.awt.Color(0, 153, 255));
        pnlAddMovie.add(lbAddDurationError);
        lbAddDurationError.setBounds(170, 400, 30, 30);

        lbAddStartingDateError.setBackground(new java.awt.Color(0, 0, 0));
        lbAddStartingDateError.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbAddStartingDateError.setForeground(new java.awt.Color(0, 153, 255));
        pnlAddMovie.add(lbAddStartingDateError);
        lbAddStartingDateError.setBounds(310, 470, 30, 30);

        lbAddPictureError.setBackground(new java.awt.Color(0, 0, 0));
        lbAddPictureError.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbAddPictureError.setForeground(new java.awt.Color(0, 153, 255));
        pnlAddMovie.add(lbAddPictureError);
        lbAddPictureError.setBounds(640, 390, 30, 30);

        lbAddDescriptionError.setBackground(new java.awt.Color(0, 0, 0));
        lbAddDescriptionError.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbAddDescriptionError.setForeground(new java.awt.Color(0, 153, 255));
        pnlAddMovie.add(lbAddDescriptionError);
        lbAddDescriptionError.setBounds(310, 340, 30, 30);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hr/algebra/Resources/StarsBackground.png"))); // NOI18N
        pnlAddMovie.add(jLabel14);
        jLabel14.setBounds(-10, 0, 695, 610);

        tpMovies.addTab("Add", pnlAddMovie);

        pnlDelete.setBackground(new java.awt.Color(0, 0, 0));
        pnlDelete.setLayout(null);

        jScrollPane6.setBackground(new java.awt.Color(0, 0, 0));

        tbDeleteMovies.setBackground(new java.awt.Color(0, 0, 0));
        tbDeleteMovies.setForeground(new java.awt.Color(255, 255, 255));
        tbDeleteMovies.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbDeleteMovies.setSelectionBackground(new java.awt.Color(0, 0, 0));
        tbDeleteMovies.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMoviesMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbDeleteMovies);

        pnlDelete.add(jScrollPane6);
        jScrollPane6.setBounds(0, 140, 660, 470);

        btnDeleteMovie.setText("Delete movie");
        btnDeleteMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteMovieActionPerformed(evt);
            }
        });
        pnlDelete.add(btnDeleteMovie);
        btnDeleteMovie.setBounds(240, 60, 180, 23);

        tpMovies.addTab("Delete", pnlDelete);

        getContentPane().add(tpMovies);
        tpMovies.setBounds(0, 180, 690, 640);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hr/algebra/Resources/CinestarAppImg.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -10, 690, 580);

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hr/algebra/Resources/StarsBackground.png"))); // NOI18N
        getContentPane().add(jLabel20);
        jLabel20.setBounds(0, 300, 690, 580);

        mMovie.setText("Movie");
        mMovie.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                mMovieMenuSelected(evt);
            }
        });
        jMenuBar1.add(mMovie);

        mADG.setText("Actor & Director & Genre");
        mADG.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                mADGMenuSelected(evt);
            }
        });
        jMenuBar1.add(mADG);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mMovieMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_mMovieMenuSelected
        tpABG.setVisible(false);
        tpMovies.setVisible(true);
    }//GEN-LAST:event_mMovieMenuSelected

    private void tbMoviesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMoviesMouseClicked
        ShowMovieData();
        clearForm();
    }//GEN-LAST:event_tbMoviesMouseClicked

    private void btnEditUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditUploadActionPerformed
        Optional<File> optFile = FileUtils.uploadFile("Images", "jpg", "jpeg", "png");
        if (optFile.isPresent()) {
            File file = optFile.get();
            tfEditPath.setText(file.getAbsolutePath());
            setIcon(lbEditPicture, file);
        }
    }//GEN-LAST:event_btnEditUploadActionPerformed

    private void btnSaveEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveEditActionPerformed
        initValidation();
        if (formIsValid()) {
            try {
                if (selectedMovie.getPicturePath() == null
                        || !tfEditPath.getText().trim().equals(selectedMovie.getPicturePath())) {
                    Files.deleteIfExists(Paths.get(selectedMovie.getPicturePath()));
                    String localPicturePath = uploadPicture();
                    selectedMovie.setPicturePath(localPicturePath);
                }

                selectedMovie.setTitle(tfEditTitle.getText().trim());
                selectedMovie.setDuration(Integer.parseInt(tfEditDuration.getText().trim()));
                selectedMovie.setDescription(taEditDescription.getText().trim());
                selectedMovie.setStartingDate(LocalDate.parse(tfEditStartingDate.getText().trim(), Movie.DATE_FORMATTER));

                repository.updateMovie(selectedMovie.getId(), selectedMovie);
                initMovies();
                MessageUtils.showInformationMessage("Data progress", "You successfully updated movie!");
            } catch (Exception e) {
                Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, e);
                MessageUtils.showErrorMessage("Error", "Unable to update movie!");
            }

        }


    }//GEN-LAST:event_btnSaveEditActionPerformed

    private void btnAddUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUploadActionPerformed
        Optional<File> optFile = FileUtils.uploadFile("Images", "jpg", "jpeg", "png");
        if (optFile.isPresent()) {
            File file = optFile.get();
            tfAddPath.setText(file.getAbsolutePath());
            setIcon(lbAddPicture, file);
        }

    }//GEN-LAST:event_btnAddUploadActionPerformed


    private void btnAddMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMovieActionPerformed
        initValidation();
        if (formIsValid()) {
            try {
                String localPicturePath = uploadPicture();
                Movie movie = new Movie(
                        tfAddTitle.getText().trim(),
                        taAddDescription.getText().trim(),
                        Integer.parseInt(tfAddDuration.getText().trim()),
                        LocalDate.parse(tfAddStartingDate.getText().trim(), Movie.DATE_FORMATTER),
                        selectedMovie.getLink(),
                        localPicturePath);
                repository.createMovie(movie);
                initMovies();
                MessageUtils.showInformationMessage("Data progress", "You successfully inserted movie!");
                clearForm();
            } catch (Exception ex) {
                Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to create movie!");
            }
        }


    }//GEN-LAST:event_btnAddMovieActionPerformed

    private void btnDeleteMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteMovieActionPerformed
        if (MessageUtils.showConfirmDialog(
                "Delete movie",
                "Do you really want to delete " + selectedMovie.getTitle() + " ?") == JOptionPane.YES_OPTION) {
            try {
                Files.deleteIfExists(Paths.get(selectedMovie.getPicturePath()));
                repository.deleteMovie(selectedMovie.getId());
                initMovies();
                MessageUtils.showInformationMessage("Data progress", "You successfully deleted movie!");
                clearForm();
            } catch (Exception ex) {
                Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to delete movie!");
            }
        }


    }//GEN-LAST:event_btnDeleteMovieActionPerformed

    private void tpMoviesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tpMoviesStateChanged
        activePanel = (JPanel) tpMovies.getSelectedComponent();
        if (validationFields != null) {
            clearForm();
        }
    }//GEN-LAST:event_tpMoviesStateChanged

    private void tpABGStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tpABGStateChanged
        activePanel = (JPanel) tpABG.getSelectedComponent();
        clearAddForm();
    }//GEN-LAST:event_tpABGStateChanged

    private void mADGMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_mADGMenuSelected
        tpMovies.setVisible(false);
        tpABG.setVisible(true);

    }//GEN-LAST:event_mADGMenuSelected

    private void cbMoviesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMoviesItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            try {
                Movie movie = (Movie) cbMovies.getSelectedItem();
                selectedCbMovieId = movie.getId();
                loadModelDependingOnMovie();
            } catch (Exception ex) {
                Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to load movie data!");
            }
        }
    }//GEN-LAST:event_cbMoviesItemStateChanged

    private void btnRemoveDirectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveDirectorActionPerformed
        if (MessageUtils.showConfirmDialog(
                "Remove director from movie",
                "Do you really want to remove director?") == JOptionPane.YES_OPTION) {
            try {
                Person director = lbMovieDirectors.getSelectedValue();
                int directorId = director.getId();
                repository.deleteMoviePerson(selectedCbMovieId, directorId);
                loadModelDependingOnMovie();
            } catch (Exception ex) {
                Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to remove director!");
            }
        }
    }//GEN-LAST:event_btnRemoveDirectorActionPerformed

    private void btnAddDirectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDirectorActionPerformed
        if (MessageUtils.showConfirmDialog(
                "Add director on a movie",
                "Do you really want to add director?") == JOptionPane.YES_OPTION) {
            try {
                Person director = lbAllDirectors.getSelectedValue();
                int directorId = director.getId();
                repository.createMoviePerson(directorId, selectedCbMovieId);
                loadModelDependingOnMovie();
            } catch (Exception ex) {
                Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to add director!");
            }
        }
    }//GEN-LAST:event_btnAddDirectorActionPerformed

    private void btnRemoveActorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActorActionPerformed
        if (MessageUtils.showConfirmDialog(
                "Remove actor from movie",
                "Do you really want to remove actor?") == JOptionPane.YES_OPTION) {
            try {
                Person actor = lbMovieActors.getSelectedValue();
                int actorId = actor.getId();
                repository.deleteMoviePerson(selectedCbMovieId, actorId);
                loadModelDependingOnMovie();
            } catch (Exception ex) {
                Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to remove actor!");
            }
        }
    }//GEN-LAST:event_btnRemoveActorActionPerformed

    private void btnAddActorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActorActionPerformed
        if (MessageUtils.showConfirmDialog(
                "Add actor on a movie",
                "Do you really want to add actor?") == JOptionPane.YES_OPTION) {
            try {
                Person actor = lbAllActors.getSelectedValue();
                int actorId = actor.getId();
                repository.createMoviePerson(actorId, selectedCbMovieId);
                loadModelDependingOnMovie();
            } catch (Exception ex) {
                Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to add actor!");
            }
        }
    }//GEN-LAST:event_btnAddActorActionPerformed

    private void btnRemoveGenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveGenreActionPerformed
        if (MessageUtils.showConfirmDialog(
                "Remove genre from movie",
                "Do you really want to remove genre?") == JOptionPane.YES_OPTION) {
            try {
                Genre genre = lbMovieGenres.getSelectedValue();
                int genreId = genre.getId();
                repository.deleteMovieGenre(selectedCbMovieId, genreId);
                loadModelDependingOnMovie();
            } catch (Exception ex) {
                Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to remove director!");
            }
        }
    }//GEN-LAST:event_btnRemoveGenreActionPerformed

    private void btnAddGenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddGenreActionPerformed
        if (MessageUtils.showConfirmDialog(
                "Add movie genre",
                "Do you really want to add genre?") == JOptionPane.YES_OPTION) {
            try {
                Genre genre = lbAllGenres.getSelectedValue();
                int genreId = genre.getId();
                repository.createMovieGenre(genreId, selectedCbMovieId);
                loadModelDependingOnMovie();
            } catch (Exception ex) {
                Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to add genre!");
            }
        }
    }//GEN-LAST:event_btnAddGenreActionPerformed

    private void btnAddAddDirectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAddDirectorActionPerformed
        initAddDirectorValidation();
        if (formIsValid()) {
            Person person = new Person(tfDirectorName.getText(), tfDirectorSurname.getText(), PersonFunction.DIRECTOR);
            try {
                repository.createPerson(person);
                initLists();
                loadModelDependingOnMovie();
                clearAddForm();
                MessageUtils.showInformationMessage("Data progress", "You successfully inserted director!");
            } catch (Exception ex) {
                Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to add director!");
            }
        }
    }//GEN-LAST:event_btnAddAddDirectorActionPerformed

    private void btnAddAddActorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAddActorActionPerformed
        initAddActorValidation();
        if (formIsValid()) {
            Person person = new Person(tfActorName.getText(), tfActorSurname.getText(), PersonFunction.ACTOR);
            try {
                repository.createPerson(person);
                initLists();
                loadModelDependingOnMovie();
                clearAddForm();
                MessageUtils.showInformationMessage("Data progress", "You successfully inserted actor!");
            } catch (Exception ex) {
                Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to add director!");
            }
        }
    }//GEN-LAST:event_btnAddAddActorActionPerformed

    private void btnAddAddGenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAddGenreActionPerformed
        initAddGenreValidation();
        if (formIsValid()) {
            Genre genre = new Genre(tfGenreName.getText());
            try {
                repository.createGenre(genre);
                initLists();
                loadModelDependingOnMovie();
                clearAddForm();
                MessageUtils.showInformationMessage("Data progress", "You successfully inserted genre!");
            } catch (Exception ex) {
                Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to add director!");
            }
        }
    }//GEN-LAST:event_btnAddAddGenreActionPerformed

    private void btnDeleteDirectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDirectorActionPerformed
        if (MessageUtils.showConfirmDialog(
                "Delete director",
                "Do you really want to delete director?") == JOptionPane.YES_OPTION) {
            try {
                Person director = lbDeleteAllDirectors.getSelectedValue();
                int directorId = director.getId();
                repository.deletePerson(directorId);
                initLists();
                loadModelDependingOnMovie();
            } catch (Exception ex) {
                Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to delete director!");
            }
        }
    }//GEN-LAST:event_btnDeleteDirectorActionPerformed

    private void btnDeleteActorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActorActionPerformed
        if (MessageUtils.showConfirmDialog(
                "Delete actor",
                "Do you really want to delete director?") == JOptionPane.YES_OPTION) {
            try {
                Person actor = lbDeleteAllActors.getSelectedValue();
                int actorId = actor.getId();
                repository.deletePerson(actorId);
                initLists();
                loadModelDependingOnMovie();
            } catch (Exception ex) {
                Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to delete actor!");
            }
        }
    }//GEN-LAST:event_btnDeleteActorActionPerformed

    private void btnDeleteGenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteGenreActionPerformed
        if (MessageUtils.showConfirmDialog(
                "Delete director",
                "Do you really want to delete director?") == JOptionPane.YES_OPTION) {
            try {
                Genre genre = lbDeleteAllGenres.getSelectedValue();
                int genreId = genre.getId();
                repository.deleteGenre(genreId);
                initLists();
                loadModelDependingOnMovie();
            } catch (Exception ex) {
                Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to delete genre!");
            }
        }
    }//GEN-LAST:event_btnDeleteGenreActionPerformed

    private void lbAllDirectorsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lbAllDirectorsValueChanged
        personToTransfer = lbAllDirectors.getSelectedValue();
    }//GEN-LAST:event_lbAllDirectorsValueChanged

    private void lbAllActorsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lbAllActorsValueChanged
        personToTransfer = lbAllActors.getSelectedValue();
    }//GEN-LAST:event_lbAllActorsValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddActor;
    private javax.swing.JButton btnAddAddActor;
    private javax.swing.JButton btnAddAddDirector;
    private javax.swing.JButton btnAddAddGenre;
    private javax.swing.JButton btnAddDirector;
    private javax.swing.JButton btnAddGenre;
    private javax.swing.JButton btnAddMovie;
    private javax.swing.JButton btnAddUpload;
    private javax.swing.JButton btnDeleteActor;
    private javax.swing.JButton btnDeleteDirector;
    private javax.swing.JButton btnDeleteGenre;
    private javax.swing.JButton btnDeleteMovie;
    private javax.swing.JButton btnEditUpload;
    private javax.swing.JButton btnRemoveActor;
    private javax.swing.JButton btnRemoveDirector;
    private javax.swing.JButton btnRemoveGenre;
    private javax.swing.JButton btnSaveEdit;
    private javax.swing.JComboBox<Movie> cbMovies;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lbActorNameError;
    private javax.swing.JLabel lbActorSurnameError;
    private javax.swing.JLabel lbAddDescriptionError;
    private javax.swing.JLabel lbAddDurationError;
    private javax.swing.JLabel lbAddPicture;
    private javax.swing.JLabel lbAddPictureError;
    private javax.swing.JLabel lbAddStartingDateError;
    private javax.swing.JLabel lbAddTitleError;
    private javax.swing.JList<Person> lbAllActors;
    private javax.swing.JList<Person> lbAllDirectors;
    private javax.swing.JList<Genre> lbAllGenres;
    private javax.swing.JList<Person> lbDeleteAllActors;
    private javax.swing.JList<Person> lbDeleteAllDirectors;
    private javax.swing.JList<Genre> lbDeleteAllGenres;
    private javax.swing.JLabel lbDirectorNameError;
    private javax.swing.JLabel lbDirectorSurnameError;
    private javax.swing.JLabel lbDuration;
    private javax.swing.JLabel lbDuration1;
    private javax.swing.JLabel lbEditDescriptionError;
    private javax.swing.JLabel lbEditDurationError;
    private javax.swing.JLabel lbEditPicture;
    private javax.swing.JLabel lbEditPictureError;
    private javax.swing.JLabel lbEditStartingDateError;
    private javax.swing.JLabel lbEditTitleError;
    private javax.swing.JLabel lbGenreNameError;
    private javax.swing.JList<Person> lbMovieActors;
    private javax.swing.JList<Person> lbMovieDirectors;
    private javax.swing.JList<Genre> lbMovieGenres;
    private javax.swing.JLabel lbPicture;
    private javax.swing.JLabel lbStartingDate;
    private javax.swing.JLabel lbStartingDate1;
    private javax.swing.JLabel lbStartingDate2;
    private javax.swing.JLabel lbStartingDate3;
    private javax.swing.JLabel lbStartingDate6;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JMenu mADG;
    private javax.swing.JMenu mMovie;
    private javax.swing.JPanel pnlAddADG;
    private javax.swing.JPanel pnlAddMovie;
    private javax.swing.JPanel pnlDelete;
    private javax.swing.JPanel pnlDeleteADG;
    private javax.swing.JPanel pnlEditMovie;
    private javax.swing.JPanel pnlViewEditADG;
    private javax.swing.JPanel pnlViewMovie;
    private javax.swing.JTextArea taAddDescription;
    private javax.swing.JTextArea taDescription;
    private javax.swing.JTextArea taEditDescription;
    private javax.swing.JTable tbDeleteMovies;
    private javax.swing.JTable tbEditMovies;
    private javax.swing.JTable tbMovies;
    private javax.swing.JTextField tfActorName;
    private javax.swing.JTextField tfActorSurname;
    private javax.swing.JTextField tfAddDuration;
    private javax.swing.JTextField tfAddPath;
    private javax.swing.JTextField tfAddStartingDate;
    private javax.swing.JTextField tfAddTitle;
    private javax.swing.JTextField tfDirectorName;
    private javax.swing.JTextField tfDirectorSurname;
    private javax.swing.JTextField tfEditDuration;
    private javax.swing.JTextField tfEditPath;
    private javax.swing.JTextField tfEditStartingDate;
    private javax.swing.JTextField tfEditTitle;
    private javax.swing.JTextField tfGenreName;
    private javax.swing.JTabbedPane tpABG;
    private javax.swing.JTabbedPane tpMovies;
    // End of variables declaration//GEN-END:variables

    private void initRepository() throws Exception {
        repository = RepoFactory.getRepository();
    }

    private void hideComponents() {
        tpABG.setVisible(false);

    }

    private void ShowMovieData() {

        int selectedRow = tbMovies.getSelectedRow();
        int rowIndex = tbMovies.convertRowIndexToModel(selectedRow);
        int selectedMovieId = (int) moviesTableModel.getValueAt(rowIndex, 0);

        int selectedRowEdit = tbEditMovies.getSelectedRow();
        int rowIndexEdit = tbEditMovies.convertRowIndexToModel(selectedRowEdit);
        int selectedEditMovieId = (int) moviesTableModel.getValueAt(rowIndexEdit, 0);

        int selectedRowDelete = tbDeleteMovies.getSelectedRow();
        int rowIndexDelete = tbDeleteMovies.convertRowIndexToModel(selectedRowDelete);
        int selectedDeleteMovieId = (int) moviesTableModel.getValueAt(rowIndexDelete, 0);
        if (pnlEditMovie == activePanel) {
            try {
                Optional<Movie> optMovie = repository.getMovie(selectedEditMovieId);
                if (optMovie.isPresent()) {
                    selectedMovie = optMovie.get();
                    fillForm(selectedMovie);
                }
            } catch (Exception ex) {
                MessageUtils.showErrorMessage("Error", "Unable to show movie!");
            }
        } else if (pnlDelete == activePanel) {
            try {
                Optional<Movie> optMovie = repository.getMovie(selectedDeleteMovieId);
                if (optMovie.isPresent()) {
                    selectedMovie = optMovie.get();
                    fillForm(selectedMovie);
                }
            } catch (Exception ex) {
                MessageUtils.showErrorMessage("Error", "Unable to show movie!");
            }
        } else {
            try {
                Optional<Movie> optMovie = repository.getMovie(selectedMovieId);
                if (optMovie.isPresent()) {
                    selectedMovie = optMovie.get();
                    fillForm(selectedMovie);
                }
            } catch (Exception ex) {
                MessageUtils.showErrorMessage("Error", "Unable to show movie!");
            }
        }

    }

    private void initTables() throws Exception {
        tbMovies.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbMovies.setAutoCreateRowSorter(true);
        tbMovies.setRowHeight(25);
        moviesTableModel = new MovieTableModel(repository.getMovies());
        tbMovies.setModel(moviesTableModel);

        tbDeleteMovies.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbDeleteMovies.setAutoCreateRowSorter(true);
        tbDeleteMovies.setRowHeight(25);
        tbDeleteMovies.setModel(moviesTableModel);

        tbEditMovies.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbEditMovies.setAutoCreateRowSorter(true);
        tbEditMovies.setRowHeight(25);
        tbEditMovies.setModel(moviesTableModel);

    }

    private void clearForm() {
        lbAddPicture.setIcon(null);
        tfAddDuration.setText("");
        tfAddPath.setText("");
        tfAddStartingDate.setText("");
        tfAddTitle.setText("");
        taAddDescription.setText("");

        lbEditDurationError.setText("");
        lbEditTitleError.setText("");
        lbEditDescriptionError.setText("");
        lbEditPictureError.setText("");
        lbEditStartingDateError.setText("");

        lbAddDescriptionError.setText("");
        lbAddStartingDateError.setText("");
        lbAddDurationError.setText("");
        lbAddPictureError.setText("");
        lbAddTitleError.setText("");
    }

    private void fillForm(Movie movie) {
        if (movie.getPicturePath() != null && Files.exists(Paths.get(movie.getPicturePath()))) {
            setIcon(lbPicture, new File(movie.getPicturePath()));
            tfEditPath.setText(movie.getPicturePath());
            setIcon(lbEditPicture, new File(movie.getPicturePath()));
        }
        lblTitle.setText(movie.getTitle());
        lbDuration.setText(String.valueOf(movie.getDuration()));
        taDescription.setText(movie.getDescription());
        lbStartingDate.setText("You can watch it in cinema from " + movie.getStartingDate().format(movie.DATE_FORMATTER) + " !");

        tfEditTitle.setText(movie.getTitle());
        tfEditDuration.setText(String.valueOf(movie.getDuration()));
        taEditDescription.setText(movie.getDescription());
        tfEditStartingDate.setText(movie.getStartingDate().format(movie.DATE_FORMATTER));
    }

    private void setIcon(JLabel lbPicture, File file) {

        try {
            lbPicture.setIcon(IconUtils.createIcon(file.getAbsolutePath(), lbPicture.getWidth(), lbPicture.getHeight()));
        } catch (IOException ex) {
            Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to set picture!");
        }
    }

    private void initMovies() throws Exception {
        initTables();
        tbMovies.changeSelection(0, 0, false, false);
        tbEditMovies.changeSelection(0, 0, false, false);
        tbDeleteMovies.changeSelection(0, 0, false, false);
        ShowMovieData();
    }

    private void initValidation() {
        if (activePanel == pnlEditMovie) {
            validationFields = Arrays.asList(tfEditTitle, tfEditPath, taEditDescription, tfEditDuration, tfEditStartingDate);
            errorLabels = Arrays.asList(lbEditTitleError, lbEditPictureError, lbEditDescriptionError, lbEditDurationError, lbEditStartingDateError);
        } else {
            validationFields = Arrays.asList(tfAddTitle, tfAddPath, taAddDescription, tfAddDuration, tfAddStartingDate);
            errorLabels = Arrays.asList(lbAddTitleError, lbAddPictureError, lbAddDescriptionError, lbAddDurationError, lbAddStartingDateError);

        }

    }

    private void initAddDirectorValidation() {
        validationFields = Arrays.asList(tfDirectorName, tfDirectorSurname);
        errorLabels = Arrays.asList(lbDirectorNameError, lbDirectorSurnameError);
    }

    private void initAddActorValidation() {
        validationFields = Arrays.asList(tfActorName, tfActorSurname);
        errorLabels = Arrays.asList(lbActorNameError, lbActorSurnameError);
    }

    private void initAddGenreValidation() {
        validationFields = Arrays.asList(tfGenreName);
        errorLabels = Arrays.asList(lbGenreNameError);
    }

    private boolean formIsValid() {
        boolean ok = true;

        for (int i = 0; i < validationFields.size(); i++) {
            ok &= !validationFields.get(i).getText().trim().isEmpty();
            errorLabels.get(i).setText(validationFields.get(i).getText().trim().isEmpty() ? "X" : "");
            if ("Int".equals(validationFields.get(i).getName())) {
                try {
                    Integer.valueOf(validationFields.get(i).getText().trim());
                    errorLabels.get(i).setText("");
                } catch (NumberFormatException e) {
                    errorLabels.get(i).setText("X");
                    ok = false;
                }
            }
            if ("Date".equals(validationFields.get(i).getName())) {
                try {
                    LocalDate.parse(validationFields.get(i).getText().trim(), Movie.DATE_FORMATTER);
                    errorLabels.get(i).setText("");
                } catch (Exception e) {
                    ok = false;
                    errorLabels.get(i).setText("X");
                }
            }
        }
        return ok;
    }

    private String uploadPicture() throws IOException {
        String picturePath;
        if (activePanel == pnlEditMovie) {
            picturePath = tfEditPath.getText().trim();
        } else {
            picturePath = tfAddPath.getText().trim();
        }

        String ext = picturePath.substring(picturePath.lastIndexOf("."));
        String pictureName = Math.abs(RANDOM.nextInt()) + ext;
        String localPicturePath = DIR + File.separator + pictureName;
        FileUtils.copy(picturePath, localPicturePath);
        return localPicturePath;
    }

    private void initABG() throws Exception {

        initLists();
        loadModel();
        cbMovies.setSelectedIndex(0);
        ShowMovieData();
    }

    private void initLists() throws Exception {
        movies = repository.getMovies();
        allActors = repository.getActors();
        allDirectors = repository.getDirectors();
        allGenres = repository.getGenres();
        Collections.sort(movies);
        Collections.sort(allActors);
        Collections.sort(allDirectors);
        Collections.sort(allGenres);

    }

    private void loadModel() throws Exception {

        movieModel.removeAllElements();
        movies.forEach(movie -> movieModel.addElement(movie));
        cbMovies.setModel(movieModel);
        cbMovies.setSelectedIndex(0);

        loadModelDependingOnMovie();

    }

    private void loadModelNotDependingOnMovie() {
        actorModel.clear();
        allActors.forEach(actor -> actorModel.addElement(actor));
        lbAllActors.setModel(actorModel);
        lbDeleteAllActors.setModel(actorModel);

        directorModel.clear();
        allDirectors.forEach(director -> directorModel.addElement(director));
        lbAllDirectors.setModel(directorModel);
        lbDeleteAllDirectors.setModel(directorModel);

        genreModel.clear();
        allGenres.forEach(genre -> genreModel.addElement(genre));
        lbAllGenres.setModel(genreModel);
        lbDeleteAllGenres.setModel(genreModel);
    }

    private void loadModelDependingOnMovie() throws Exception {

        Movie movie = (Movie) cbMovies.getSelectedItem();
        selectedCbMovieId = movie.getId();

        movieActors = repository.getMovieActors(selectedCbMovieId);
        movieDirectors = repository.getMovieDirectors(selectedCbMovieId);
        movieGenres = repository.getMovieGenres(selectedCbMovieId);

        removeDuplicates();
        loadModelNotDependingOnMovie();

        Collections.sort(movieActors);
        Collections.sort(movieDirectors);
        Collections.sort(movieGenres);

        actorMovieModel.clear();
        movieActors.forEach(actor -> actorMovieModel.addElement(actor));
        lbMovieActors.setModel(actorMovieModel);

        directorMovieModel.clear();
        movieDirectors.forEach(director -> directorMovieModel.addElement(director));
        lbMovieDirectors.setModel(directorMovieModel);

        genreMovieModel.clear();
        movieGenres.forEach(genre -> genreMovieModel.addElement(genre));
        lbMovieGenres.setModel(genreMovieModel);
    }

    private void clearAddForm() {

        tfDirectorName.setText("");
        tfActorName.setText("");
        tfDirectorSurname.setText("");
        tfActorSurname.setText("");
        tfGenreName.setText("");

        lbDirectorNameError.setText("");
        lbActorNameError.setText("");
        lbGenreNameError.setText("");
        lbDirectorSurnameError.setText("");
        lbActorSurnameError.setText("");
    }

    private void initDragNDrop() {
        lbAllDirectors.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lbAllDirectors.setDragEnabled(true);
        lbAllDirectors.setTransferHandler(new ExportTransferHandler());

        lbAllActors.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lbAllActors.setDragEnabled(true);
        lbAllActors.setTransferHandler(new ExportTransferHandler());

        lbMovieDirectors.setDropMode(DropMode.ON);
        lbMovieDirectors.setTransferHandler(new ImportTransferHandler());
    }

    private void removeDuplicates() throws Exception {

        allActors.removeAll(movieActors);
        allActors.removeAll(movieDirectors);
        allDirectors.removeAll(movieDirectors);
        allGenres.removeAll(movieGenres);

    }

    private class ExportTransferHandler extends TransferHandler {

        @Override
        protected Transferable createTransferable(JComponent c) {
            return new PersonTransferable(personToTransfer);
        }

        @Override
        public int getSourceActions(JComponent c) {
            return COPY;
        }

    }

    private class ImportTransferHandler extends TransferHandler {

        @Override
        public boolean importData(TransferSupport support) {
            Transferable transferable = support.getTransferable();
            try {
                Person add = (Person) transferable.getTransferData(PersonTransferable.PERSON_FLAVOR);
                if (movieDirectors.add(add)) {
                    repository.createMoviePersonSetPF(add.getId(), selectedCbMovieId, 1);
                    loadModelDependingOnMovie();
                    initLists();
                    return true;
                }
            } catch (UnsupportedFlavorException | IOException ex) {
                Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }

        @Override
        public boolean canImport(TransferSupport support) {
            return support.isDataFlavorSupported(PersonTransferable.PERSON_FLAVOR);
        }

    }

}
