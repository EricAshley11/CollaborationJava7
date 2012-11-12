//<editor-fold defaultstate="collapsed" desc=" Imports and package ">
package collaboration;

import collaborationjava7.common.*;
import java.awt.event.ItemEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

//google calendar API imports
//import com.google.gdata.client.*;
//import com.google.gdata.client.calendar.*;
//import com.google.gdata.data.*;
//import com.google.gdata.data.acl.*;
//import com.google.gdata.data.calendar.*;
//import com.google.gdata.data.extensions.*;
//import com.google.gdata.util.*;
//import java.net.URL;
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc=" Class declaration and constructor ">
public class mainView extends javax.swing.JFrame {

    mainEngine engine = new mainEngine();

    /**
     * Creates new form mainView
     */
    public mainView() {
        initComponents();
    }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc=" Custom methods ">

    private void updateLookAndFeel(String pLookAndFeel) {
        try {
            if (pLookAndFeel.startsWith("System")) {
                javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            } else if (pLookAndFeel.startsWith("Tattoo")) {
                javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
            } else if (pLookAndFeel.startsWith("Glass")) {
                javax.swing.UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
            } else {
                javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            }
            javax.swing.SwingUtilities.updateComponentTreeUI(this);
            javax.swing.SwingUtilities.updateComponentTreeUI(addMemberJFrame);
            javax.swing.SwingUtilities.updateComponentTreeUI(editMemberJFrame);
            javax.swing.SwingUtilities.updateComponentTreeUI(addTasksJFrame);
            javax.swing.SwingUtilities.updateComponentTreeUI(editTasksJFrame);
            javax.swing.SwingUtilities.updateComponentTreeUI(editProjectJFrame);
            javax.swing.SwingUtilities.updateComponentTreeUI(settingsJFrame);
            javax.swing.SwingUtilities.updateComponentTreeUI(loginJFrame);
        } catch (Exception e) {
            //System.out.println(e.toString());
        }
    }
//</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMemberJFrame = new javax.swing.JFrame();
        addMemberJPanel = new javax.swing.JPanel();
        addMemberDialogButton = new javax.swing.JButton();
        addMemberNameJLabel = new javax.swing.JLabel();
        addMemberNameTextField = new javax.swing.JTextField();
        editMemberJFrame = new javax.swing.JFrame();
        editMemberJPanel = new javax.swing.JPanel();
        saveEditMemberButton = new javax.swing.JButton();
        editMemberNameJLabel = new javax.swing.JLabel();
        editMemberPhoneJLabel = new javax.swing.JLabel();
        editMemberEmailJLabel = new javax.swing.JLabel();
        editNameTextField = new javax.swing.JTextField();
        editPhoneTextField = new javax.swing.JTextField();
        editEmailTextField = new javax.swing.JTextField();
        addTasksJFrame = new javax.swing.JFrame();
        addTasksJPanel = new javax.swing.JPanel();
        addTasksDialogButton = new javax.swing.JButton();
        addTasksLeadJLabel = new javax.swing.JLabel();
        addTasksUserStoryJLabel = new javax.swing.JLabel();
        addTasksTaskJLabel = new javax.swing.JLabel();
        addTasksStatusJLabel = new javax.swing.JLabel();
        addTasksEstimatedJLabel = new javax.swing.JLabel();
        addTasksActualJLabel = new javax.swing.JLabel();
        addTasksLeadTextField = new javax.swing.JTextField();
        addTasksUserStoryTextField = new javax.swing.JTextField();
        addTasksTaskTextField = new javax.swing.JTextField();
        addTasksStatusTextField = new javax.swing.JTextField();
        addTasksEstimatedTextField = new javax.swing.JTextField();
        addTasksActualTextField = new javax.swing.JTextField();
        editTasksJFrame = new javax.swing.JFrame();
        editTasksJPanel = new javax.swing.JPanel();
        editTasksDialogButton = new javax.swing.JButton();
        editTasksLeadJLabel = new javax.swing.JLabel();
        editTasksUserStoryJLabel = new javax.swing.JLabel();
        editTasksTaskJLabel = new javax.swing.JLabel();
        editTasksStatusJLabel = new javax.swing.JLabel();
        editTasksEstimatedJLabel = new javax.swing.JLabel();
        editTasksActualJLabel = new javax.swing.JLabel();
        editTasksLeadTextField = new javax.swing.JTextField();
        editTasksUserStoryTextField = new javax.swing.JTextField();
        editTasksTaskTextField = new javax.swing.JTextField();
        editTasksStatusTextField = new javax.swing.JTextField();
        editTasksEstimatedTextField = new javax.swing.JTextField();
        editTasksActualTextField = new javax.swing.JTextField();
        editProjectJFrame = new javax.swing.JFrame();
        editProjectJPanel = new javax.swing.JPanel();
        editProjectSaveButton = new javax.swing.JButton();
        editProjectTextField = new javax.swing.JTextField();
        editProjectDeleteJLabel = new javax.swing.JLabel();
        editProjectRenameJLabel = new javax.swing.JLabel();
        loginJFrame = new javax.swing.JFrame();
        loginJPanel = new javax.swing.JPanel();
        usernameJLabel = new javax.swing.JLabel();
        passwordJLabel = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        spaceJlabel = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JPasswordField();
        createUserButton = new javax.swing.JButton();
        settingsJFrame = new javax.swing.JFrame();
        loginJPanel1 = new javax.swing.JPanel();
        saveSettingsButton = new javax.swing.JButton();
        spaceJlabel1 = new javax.swing.JLabel();
        themeComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        createUserJFrame = new javax.swing.JFrame();
        createUserJPanel = new javax.swing.JPanel();
        createUserDialogButton = new javax.swing.JButton();
        createUserNameJLabel = new javax.swing.JLabel();
        createUserPhoneJLabel = new javax.swing.JLabel();
        createUserEmailJLabel = new javax.swing.JLabel();
        createUserNameTextField = new javax.swing.JTextField();
        createUserPhoneTextField = new javax.swing.JTextField();
        createUserEmailTextField = new javax.swing.JTextField();
        spaceJlabel2 = new javax.swing.JLabel();
        createUserUsernameTextField = new javax.swing.JTextField();
        createUserUsernameJLabel = new javax.swing.JLabel();
        createUserNameJLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        firstPasswordField = new javax.swing.JPasswordField();
        confirmPasswordField = new javax.swing.JPasswordField();
        filterTeamJFrame = new javax.swing.JFrame();
        filterTeamJPanel = new javax.swing.JPanel();
        filterTeamSaveButton = new javax.swing.JButton();
        filterTeamUsernameJCheckBox = new javax.swing.JCheckBox();
        filterTeamFullNameJCheckBox = new javax.swing.JCheckBox();
        filterTeamEmailJCheckBox = new javax.swing.JCheckBox();
        filterTeamPhoneJCheckBox = new javax.swing.JCheckBox();
        filterTasksJFrame = new javax.swing.JFrame();
        filterTasksJPanel = new javax.swing.JPanel();
        filterTasksSaveButton = new javax.swing.JButton();
        filterTasksLeadJCheckBox = new javax.swing.JCheckBox();
        filterTasksUserStoryJCheckBox = new javax.swing.JCheckBox();
        filterTasksStatusJCheckBox = new javax.swing.JCheckBox();
        filterTasksTaskJCheckBox = new javax.swing.JCheckBox();
        filterTasksEstCompletionJCheckBox = new javax.swing.JCheckBox();
        filterTasksActualCompletionJCheckBox = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        projectComboBox = new javax.swing.JComboBox();
        signOutButton = new javax.swing.JButton();
        newProjectButton = new javax.swing.JButton();
        editProjectButton = new javax.swing.JButton();
        settingsButton = new javax.swing.JButton();
        aboutButton = new javax.swing.JButton();
        tabbedPane = new javax.swing.JTabbedPane();
        teamPanel = new javax.swing.JPanel();
        addMemberButton = new javax.swing.JButton();
        removeMemberButton = new javax.swing.JButton();
        editMemberButton = new javax.swing.JButton();
        teamTableScrollPane = new javax.swing.JScrollPane();
        teamTable = new javax.swing.JTable();
        teamFilterTextField = new javax.swing.JTextField();
        filterTeamButton = new javax.swing.JButton();
        tasksPanel = new javax.swing.JPanel();
        addTasksButton = new javax.swing.JButton();
        removeTaskButton = new javax.swing.JButton();
        editTaskButton = new javax.swing.JButton();
        tasksFilterTextField = new javax.swing.JTextField();
        tasksTableScrollPane = new javax.swing.JScrollPane();
        tasksTable = new javax.swing.JTable();
        filterTasksButton = new javax.swing.JButton();
        schedulePanel = new javax.swing.JPanel();
        progressPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();

        addMemberJFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMemberJFrame.setTitle("Add Member - ProjectTracker");
        addMemberJFrame.setAlwaysOnTop(true);
        addMemberJFrame.setBounds(new java.awt.Rectangle(50, 50, 250, 250));
        addMemberJFrame.setIconImage(new ImageIcon(getClass().getResource("/resources/icons/binoculars.png")).getImage());
        addMemberJFrame.setMaximumSize(new java.awt.Dimension(400, 100));
        addMemberJFrame.setMinimumSize(new java.awt.Dimension(400, 100));
        addMemberJFrame.setName("Add Member"); // NOI18N
        addMemberJFrame.setPreferredSize(new java.awt.Dimension(400, 100));
        addMemberJFrame.setResizable(false);

        addMemberJPanel.setPreferredSize(null);

        addMemberDialogButton.setText("Add Member");
        addMemberDialogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMemberDialogButtonActionPerformed(evt);
            }
        });

        addMemberNameJLabel.setText("Username");

        javax.swing.GroupLayout addMemberJPanelLayout = new javax.swing.GroupLayout(addMemberJPanel);
        addMemberJPanel.setLayout(addMemberJPanelLayout);
        addMemberJPanelLayout.setHorizontalGroup(
            addMemberJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addMemberJPanelLayout.createSequentialGroup()
                .addGroup(addMemberJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addMemberJPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(addMemberNameJLabel)
                        .addGap(18, 18, 18)
                        .addComponent(addMemberNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addMemberJPanelLayout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(addMemberDialogButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        addMemberJPanelLayout.setVerticalGroup(
            addMemberJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addMemberJPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(addMemberJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addMemberNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addMemberNameJLabel))
                .addGap(18, 18, 18)
                .addComponent(addMemberDialogButton)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout addMemberJFrameLayout = new javax.swing.GroupLayout(addMemberJFrame.getContentPane());
        addMemberJFrame.getContentPane().setLayout(addMemberJFrameLayout);
        addMemberJFrameLayout.setHorizontalGroup(
            addMemberJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addMemberJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        addMemberJFrameLayout.setVerticalGroup(
            addMemberJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addMemberJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        editMemberJFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        editMemberJFrame.setTitle("Add Member - ProjectTracker");
        editMemberJFrame.setAlwaysOnTop(true);
        editMemberJFrame.setBounds(new java.awt.Rectangle(50, 50, 250, 250));
        editMemberJFrame.setIconImage(new ImageIcon(getClass().getResource("/resources/icons/binoculars.png")).getImage());
        editMemberJFrame.setMinimumSize(new java.awt.Dimension(400, 200));
        editMemberJFrame.setName("Add Member"); // NOI18N

        editMemberJPanel.setMaximumSize(new java.awt.Dimension(400, 200));
        editMemberJPanel.setMinimumSize(new java.awt.Dimension(400, 200));

        saveEditMemberButton.setText("Save");
        saveEditMemberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveEditMemberButtonActionPerformed(evt);
            }
        });

        editMemberNameJLabel.setText("Name");

        editMemberPhoneJLabel.setText("Phone");

        editMemberEmailJLabel.setText("Email");

        javax.swing.GroupLayout editMemberJPanelLayout = new javax.swing.GroupLayout(editMemberJPanel);
        editMemberJPanel.setLayout(editMemberJPanelLayout);
        editMemberJPanelLayout.setHorizontalGroup(
            editMemberJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editMemberJPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(editMemberJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editMemberJPanelLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(saveEditMemberButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editMemberJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editMemberJPanelLayout.createSequentialGroup()
                            .addComponent(editMemberNameJLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(editNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editMemberJPanelLayout.createSequentialGroup()
                            .addComponent(editMemberPhoneJLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(editPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editMemberJPanelLayout.createSequentialGroup()
                            .addComponent(editMemberEmailJLabel)
                            .addGap(32, 32, 32)
                            .addComponent(editEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 37, Short.MAX_VALUE))
        );
        editMemberJPanelLayout.setVerticalGroup(
            editMemberJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editMemberJPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(editMemberJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editMemberNameJLabel)
                    .addComponent(editNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editMemberJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editMemberPhoneJLabel)
                    .addComponent(editPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(editMemberJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editMemberEmailJLabel)
                    .addComponent(editEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(saveEditMemberButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout editMemberJFrameLayout = new javax.swing.GroupLayout(editMemberJFrame.getContentPane());
        editMemberJFrame.getContentPane().setLayout(editMemberJFrameLayout);
        editMemberJFrameLayout.setHorizontalGroup(
            editMemberJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editMemberJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        editMemberJFrameLayout.setVerticalGroup(
            editMemberJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editMemberJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 189, Short.MAX_VALUE)
        );

        addTasksJFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addTasksJFrame.setTitle("Add Tasks - ProjectTracker");
        addTasksJFrame.setAlwaysOnTop(true);
        addTasksJFrame.setBounds(new java.awt.Rectangle(50, 50, 250, 250));
        addTasksJFrame.setIconImage(new ImageIcon(getClass().getResource("/resources/icons/binoculars.png")).getImage());
        addTasksJFrame.setMinimumSize(new java.awt.Dimension(450, 400));
        addTasksJFrame.setName("Add Member"); // NOI18N

        addTasksJPanel.setPreferredSize(new java.awt.Dimension(400, 400));

        addTasksDialogButton.setText("Add Task");
        addTasksDialogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTasksDialogButtonActionPerformed(evt);
            }
        });

        addTasksLeadJLabel.setText("Lead");

        addTasksUserStoryJLabel.setText("User Story");

        addTasksTaskJLabel.setText("Task");

        addTasksStatusJLabel.setText("Estimated Comp.");

        addTasksEstimatedJLabel.setText("Actual Comp.");

        addTasksActualJLabel.setText("Status");

        javax.swing.GroupLayout addTasksJPanelLayout = new javax.swing.GroupLayout(addTasksJPanel);
        addTasksJPanel.setLayout(addTasksJPanelLayout);
        addTasksJPanelLayout.setHorizontalGroup(
            addTasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addTasksJPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(addTasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addTasksStatusJLabel)
                    .addComponent(addTasksEstimatedJLabel)
                    .addComponent(addTasksActualJLabel)
                    .addComponent(addTasksUserStoryJLabel)
                    .addComponent(addTasksTaskJLabel)
                    .addComponent(addTasksLeadJLabel))
                .addGap(18, 18, 18)
                .addGroup(addTasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addTasksDialogButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTasksLeadTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTasksEstimatedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTasksActualTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTasksStatusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTasksTaskTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTasksUserStoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        addTasksJPanelLayout.setVerticalGroup(
            addTasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addTasksJPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(addTasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTasksLeadJLabel)
                    .addComponent(addTasksLeadTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addTasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTasksUserStoryJLabel)
                    .addComponent(addTasksUserStoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(addTasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTasksTaskJLabel)
                    .addComponent(addTasksTaskTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addTasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTasksActualJLabel)
                    .addComponent(addTasksStatusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addTasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTasksStatusJLabel)
                    .addComponent(addTasksEstimatedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(addTasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTasksEstimatedJLabel)
                    .addComponent(addTasksActualTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addTasksDialogButton)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout addTasksJFrameLayout = new javax.swing.GroupLayout(addTasksJFrame.getContentPane());
        addTasksJFrame.getContentPane().setLayout(addTasksJFrameLayout);
        addTasksJFrameLayout.setHorizontalGroup(
            addTasksJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addTasksJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        addTasksJFrameLayout.setVerticalGroup(
            addTasksJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addTasksJFrameLayout.createSequentialGroup()
                .addComponent(addTasksJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        editTasksJFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        editTasksJFrame.setTitle("Edit Tasks - ProjectTracker");
        editTasksJFrame.setAlwaysOnTop(true);
        editTasksJFrame.setBounds(new java.awt.Rectangle(50, 50, 250, 250));
        editTasksJFrame.setIconImage(new ImageIcon(getClass().getResource("/resources/icons/binoculars.png")).getImage());
        editTasksJFrame.setMinimumSize(new java.awt.Dimension(450, 400));
        editTasksJFrame.setName("Add Member"); // NOI18N

        editTasksJPanel.setPreferredSize(new java.awt.Dimension(400, 400));

        editTasksDialogButton.setText("Save Task");
        editTasksDialogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTasksDialogButtonActionPerformed(evt);
            }
        });

        editTasksLeadJLabel.setText("Lead");

        editTasksUserStoryJLabel.setText("User Story");

        editTasksTaskJLabel.setText("Task");

        editTasksStatusJLabel.setText("Estimated Comp.");

        editTasksEstimatedJLabel.setText("Actual Comp.");

        editTasksActualJLabel.setText("Status");

        javax.swing.GroupLayout editTasksJPanelLayout = new javax.swing.GroupLayout(editTasksJPanel);
        editTasksJPanel.setLayout(editTasksJPanelLayout);
        editTasksJPanelLayout.setHorizontalGroup(
            editTasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editTasksJPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(editTasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editTasksStatusJLabel)
                    .addComponent(editTasksEstimatedJLabel)
                    .addComponent(editTasksActualJLabel)
                    .addComponent(editTasksUserStoryJLabel)
                    .addComponent(editTasksTaskJLabel)
                    .addComponent(editTasksLeadJLabel))
                .addGap(18, 18, 18)
                .addGroup(editTasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editTasksDialogButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editTasksLeadTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editTasksEstimatedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editTasksActualTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editTasksStatusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editTasksTaskTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editTasksUserStoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        editTasksJPanelLayout.setVerticalGroup(
            editTasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editTasksJPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(editTasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editTasksLeadJLabel)
                    .addComponent(editTasksLeadTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editTasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editTasksUserStoryJLabel)
                    .addComponent(editTasksUserStoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(editTasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editTasksTaskJLabel)
                    .addComponent(editTasksTaskTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editTasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editTasksActualJLabel)
                    .addComponent(editTasksStatusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editTasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editTasksStatusJLabel)
                    .addComponent(editTasksEstimatedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(editTasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editTasksEstimatedJLabel)
                    .addComponent(editTasksActualTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(editTasksDialogButton)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout editTasksJFrameLayout = new javax.swing.GroupLayout(editTasksJFrame.getContentPane());
        editTasksJFrame.getContentPane().setLayout(editTasksJFrameLayout);
        editTasksJFrameLayout.setHorizontalGroup(
            editTasksJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editTasksJFrameLayout.createSequentialGroup()
                .addComponent(editTasksJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        editTasksJFrameLayout.setVerticalGroup(
            editTasksJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editTasksJFrameLayout.createSequentialGroup()
                .addComponent(editTasksJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 44, Short.MAX_VALUE))
        );

        editProjectJFrame.setTitle("Edit Project - ProjectTracker");
        editProjectJFrame.setAlwaysOnTop(true);
        editProjectJFrame.setBounds(new java.awt.Rectangle(50, 50, 210, 150));
        editProjectJFrame.setIconImage(new ImageIcon(getClass().getResource("/resources/icons/binoculars.png")).getImage());
        editProjectJFrame.setMinimumSize(new java.awt.Dimension(285, 104));
        editProjectJFrame.setResizable(false);

        editProjectJPanel.setMinimumSize(new java.awt.Dimension(210, 104));

        editProjectSaveButton.setText("Save");
        editProjectSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProjectSaveButtonActionPerformed(evt);
            }
        });

        editProjectDeleteJLabel.setText("To delete this project type DELETE");

        editProjectRenameJLabel.setText("Rename Project:");

        javax.swing.GroupLayout editProjectJPanelLayout = new javax.swing.GroupLayout(editProjectJPanel);
        editProjectJPanel.setLayout(editProjectJPanelLayout);
        editProjectJPanelLayout.setHorizontalGroup(
            editProjectJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editProjectJPanelLayout.createSequentialGroup()
                .addGroup(editProjectJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editProjectJPanelLayout.createSequentialGroup()
                        .addGroup(editProjectJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(editProjectJPanelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(editProjectDeleteJLabel))
                            .addGroup(editProjectJPanelLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(editProjectRenameJLabel)))
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addGroup(editProjectJPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(editProjectTextField)))
                .addContainerGap())
            .addGroup(editProjectJPanelLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(editProjectSaveButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        editProjectJPanelLayout.setVerticalGroup(
            editProjectJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editProjectJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editProjectRenameJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editProjectTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editProjectDeleteJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(editProjectSaveButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout editProjectJFrameLayout = new javax.swing.GroupLayout(editProjectJFrame.getContentPane());
        editProjectJFrame.getContentPane().setLayout(editProjectJFrameLayout);
        editProjectJFrameLayout.setHorizontalGroup(
            editProjectJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(editProjectJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(editProjectJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        editProjectJFrameLayout.setVerticalGroup(
            editProjectJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 129, Short.MAX_VALUE)
            .addGroup(editProjectJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(editProjectJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        loginJFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        loginJFrame.setTitle("Login - ProjectTracker");
        loginJFrame.setBounds(new java.awt.Rectangle(50, 50, 400, 350));
        loginJFrame.setIconImage(new ImageIcon(getClass().getResource("/resources/icons/binoculars.png")).getImage());
        loginJFrame.setMinimumSize(new java.awt.Dimension(300, 340));
        loginJFrame.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                loginJFrameComponentShown(evt);
            }
        });

        loginJPanel.setMaximumSize(new java.awt.Dimension(300, 340));
        loginJPanel.setMinimumSize(new java.awt.Dimension(300, 340));
        loginJPanel.setPreferredSize(new java.awt.Dimension(300, 340));

        usernameJLabel.setText("Username:");

        passwordJLabel.setText("Password:");

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        spaceJlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/ProjectTracker.png"))); // NOI18N

        createUserButton.setText("Create User");
        createUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginJPanelLayout = new javax.swing.GroupLayout(loginJPanel);
        loginJPanel.setLayout(loginJPanelLayout);
        loginJPanelLayout.setHorizontalGroup(
            loginJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginJPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(loginJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spaceJlabel)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(loginJPanelLayout.createSequentialGroup()
                                .addComponent(passwordJLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(loginJPanelLayout.createSequentialGroup()
                                .addComponent(usernameJLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(loginJPanelLayout.createSequentialGroup()
                            .addComponent(createUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        loginJPanelLayout.setVerticalGroup(
            loginJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginJPanelLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(spaceJlabel)
                .addGap(18, 18, 18)
                .addGroup(loginJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameJLabel)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(loginJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordJLabel)
                    .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(loginJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createUserButton)
                    .addComponent(loginButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout loginJFrameLayout = new javax.swing.GroupLayout(loginJFrame.getContentPane());
        loginJFrame.getContentPane().setLayout(loginJFrameLayout);
        loginJFrameLayout.setHorizontalGroup(
            loginJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginJFrameLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(loginJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        loginJFrameLayout.setVerticalGroup(
            loginJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginJFrameLayout.createSequentialGroup()
                .addComponent(loginJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 42, Short.MAX_VALUE))
        );

        settingsJFrame.setTitle("Settings - ProjectTracker");
        settingsJFrame.setBounds(new java.awt.Rectangle(50, 50, 365, 345));
        settingsJFrame.setIconImage(new ImageIcon(getClass().getResource("/resources/icons/binoculars.png")).getImage());
        settingsJFrame.setMinimumSize(new java.awt.Dimension(365, 345));
        settingsJFrame.setResizable(false);

        saveSettingsButton.setText("Save Settings");
        saveSettingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveSettingsButtonActionPerformed(evt);
            }
        });

        spaceJlabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/ProjectTracker.png"))); // NOI18N

        themeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nimbus (Default)", "Glass (Light)", "Tattoo (Dark)", "System (Windows, Mac, etc)" }));

        jLabel1.setText("Theme:");

        javax.swing.GroupLayout loginJPanel1Layout = new javax.swing.GroupLayout(loginJPanel1);
        loginJPanel1.setLayout(loginJPanel1Layout);
        loginJPanel1Layout.setHorizontalGroup(
            loginJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginJPanel1Layout.createSequentialGroup()
                .addGroup(loginJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginJPanel1Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(saveSettingsButton))
                    .addGroup(loginJPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(loginJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(loginJPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(themeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(spaceJlabel1))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        loginJPanel1Layout.setVerticalGroup(
            loginJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginJPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(spaceJlabel1)
                .addGap(18, 18, 18)
                .addGroup(loginJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(themeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(saveSettingsButton)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout settingsJFrameLayout = new javax.swing.GroupLayout(settingsJFrame.getContentPane());
        settingsJFrame.getContentPane().setLayout(settingsJFrameLayout);
        settingsJFrameLayout.setHorizontalGroup(
            settingsJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginJPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        settingsJFrameLayout.setVerticalGroup(
            settingsJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginJPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        createUserJFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        createUserJFrame.setTitle("Add Member - ProjectTracker");
        createUserJFrame.setAlwaysOnTop(true);
        createUserJFrame.setBounds(new java.awt.Rectangle(50, 50, 250, 250));
        createUserJFrame.setIconImage(new ImageIcon(getClass().getResource("/resources/icons/binoculars.png")).getImage());
        createUserJFrame.setMinimumSize(new java.awt.Dimension(400, 450));
        createUserJFrame.setName("Add Member"); // NOI18N
        createUserJFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                createUserJFrameWindowClosed(evt);
            }
        });

        createUserJPanel.setMaximumSize(new java.awt.Dimension(400, 450));
        createUserJPanel.setMinimumSize(new java.awt.Dimension(400, 450));
        createUserJPanel.setPreferredSize(new java.awt.Dimension(400, 450));

        createUserDialogButton.setText("Create User");
        createUserDialogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserDialogButtonActionPerformed(evt);
            }
        });

        createUserNameJLabel.setText("Full Name");

        createUserPhoneJLabel.setText("Phone Number");

        createUserEmailJLabel.setText("Email Address");

        createUserNameTextField.setPreferredSize(new java.awt.Dimension(200, 25));

        createUserPhoneTextField.setPreferredSize(new java.awt.Dimension(200, 25));

        createUserEmailTextField.setPreferredSize(new java.awt.Dimension(200, 25));

        spaceJlabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/ProjectTracker.png"))); // NOI18N

        createUserUsernameTextField.setPreferredSize(new java.awt.Dimension(200, 25));

        createUserUsernameJLabel.setText("Username");

        createUserNameJLabel1.setText("Password");

        jLabel2.setText("Confirm Password");

        firstPasswordField.setPreferredSize(new java.awt.Dimension(200, 25));

        confirmPasswordField.setPreferredSize(new java.awt.Dimension(200, 25));

        javax.swing.GroupLayout createUserJPanelLayout = new javax.swing.GroupLayout(createUserJPanel);
        createUserJPanel.setLayout(createUserJPanelLayout);
        createUserJPanelLayout.setHorizontalGroup(
            createUserJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createUserJPanelLayout.createSequentialGroup()
                .addGroup(createUserJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(createUserJPanelLayout.createSequentialGroup()
                        .addGroup(createUserJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(createUserJPanelLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(createUserJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(createUserPhoneJLabel)
                                    .addComponent(createUserEmailJLabel)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createUserJPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(createUserJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(createUserNameJLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(createUserNameJLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(createUserUsernameJLabel, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(createUserJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(createUserDialogButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(createUserUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(firstPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(createUserPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(createUserEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(createUserNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(createUserJPanelLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(spaceJlabel2)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        createUserJPanelLayout.setVerticalGroup(
            createUserJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createUserJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spaceJlabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(createUserJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createUserUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createUserUsernameJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(createUserJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createUserNameJLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(createUserJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(createUserJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createUserNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createUserNameJLabel))
                .addGap(12, 12, 12)
                .addGroup(createUserJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createUserPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createUserPhoneJLabel))
                .addGap(18, 18, 18)
                .addGroup(createUserJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createUserEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createUserEmailJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(createUserDialogButton)
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout createUserJFrameLayout = new javax.swing.GroupLayout(createUserJFrame.getContentPane());
        createUserJFrame.getContentPane().setLayout(createUserJFrameLayout);
        createUserJFrameLayout.setHorizontalGroup(
            createUserJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(createUserJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        createUserJFrameLayout.setVerticalGroup(
            createUserJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(createUserJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        filterTeamJFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        filterTeamJFrame.setTitle("Filter Team On...");
        filterTeamJFrame.setAlwaysOnTop(true);
        filterTeamJFrame.setBounds(new java.awt.Rectangle(50, 50, 250, 250));
        filterTeamJFrame.setIconImage(new ImageIcon(getClass().getResource("/resources/icons/binoculars.png")).getImage());
        filterTeamJFrame.setMinimumSize(new java.awt.Dimension(189, 153));
        filterTeamJFrame.setName("Add Member"); // NOI18N

        filterTeamSaveButton.setText("Save");
        filterTeamSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterTeamSaveButtonActionPerformed(evt);
            }
        });

        filterTeamUsernameJCheckBox.setSelected(true);
        filterTeamUsernameJCheckBox.setText("Username");

        filterTeamFullNameJCheckBox.setSelected(true);
        filterTeamFullNameJCheckBox.setText("Full Name");

        filterTeamEmailJCheckBox.setSelected(true);
        filterTeamEmailJCheckBox.setText("Email");

        filterTeamPhoneJCheckBox.setSelected(true);
        filterTeamPhoneJCheckBox.setText("Phone");

        javax.swing.GroupLayout filterTeamJPanelLayout = new javax.swing.GroupLayout(filterTeamJPanel);
        filterTeamJPanel.setLayout(filterTeamJPanelLayout);
        filterTeamJPanelLayout.setHorizontalGroup(
            filterTeamJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filterTeamJPanelLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(filterTeamSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filterTeamJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(filterTeamJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filterTeamUsernameJCheckBox)
                    .addComponent(filterTeamFullNameJCheckBox)
                    .addComponent(filterTeamPhoneJCheckBox)
                    .addComponent(filterTeamEmailJCheckBox))
                .addGap(81, 81, 81))
        );
        filterTeamJPanelLayout.setVerticalGroup(
            filterTeamJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filterTeamJPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(filterTeamUsernameJCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filterTeamFullNameJCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filterTeamPhoneJCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filterTeamEmailJCheckBox)
                .addGap(18, 18, 18)
                .addComponent(filterTeamSaveButton)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout filterTeamJFrameLayout = new javax.swing.GroupLayout(filterTeamJFrame.getContentPane());
        filterTeamJFrame.getContentPane().setLayout(filterTeamJFrameLayout);
        filterTeamJFrameLayout.setHorizontalGroup(
            filterTeamJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(filterTeamJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        filterTeamJFrameLayout.setVerticalGroup(
            filterTeamJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(filterTeamJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        filterTasksJFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        filterTasksJFrame.setTitle("Filter Team On...");
        filterTasksJFrame.setAlwaysOnTop(true);
        filterTasksJFrame.setBounds(new java.awt.Rectangle(50, 50, 250, 250));
        filterTasksJFrame.setIconImage(new ImageIcon(getClass().getResource("/resources/icons/binoculars.png")).getImage());
        filterTasksJFrame.setMinimumSize(new java.awt.Dimension(189, 153));
        filterTasksJFrame.setName("Add Member"); // NOI18N

        filterTasksSaveButton.setText("Save");
        filterTasksSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterTasksSaveButtonActionPerformed(evt);
            }
        });

        filterTasksLeadJCheckBox.setSelected(true);
        filterTasksLeadJCheckBox.setText("Lead");

        filterTasksUserStoryJCheckBox.setSelected(true);
        filterTasksUserStoryJCheckBox.setText("User Story");

        filterTasksStatusJCheckBox.setSelected(true);
        filterTasksStatusJCheckBox.setText("Status");

        filterTasksTaskJCheckBox.setSelected(true);
        filterTasksTaskJCheckBox.setText("Task");

        filterTasksEstCompletionJCheckBox.setSelected(true);
        filterTasksEstCompletionJCheckBox.setText("Estimated Completion");

        filterTasksActualCompletionJCheckBox.setSelected(true);
        filterTasksActualCompletionJCheckBox.setText("Actual Completion");

        javax.swing.GroupLayout filterTasksJPanelLayout = new javax.swing.GroupLayout(filterTasksJPanel);
        filterTasksJPanel.setLayout(filterTasksJPanelLayout);
        filterTasksJPanelLayout.setHorizontalGroup(
            filterTasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filterTasksJPanelLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(filterTasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(filterTasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(filterTasksActualCompletionJCheckBox)
                        .addComponent(filterTasksEstCompletionJCheckBox)
                        .addComponent(filterTasksLeadJCheckBox)
                        .addComponent(filterTasksUserStoryJCheckBox)
                        .addComponent(filterTasksTaskJCheckBox)
                        .addComponent(filterTasksStatusJCheckBox))
                    .addGroup(filterTasksJPanelLayout.createSequentialGroup()
                        .addComponent(filterTasksSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGap(38, 38, 38))
        );
        filterTasksJPanelLayout.setVerticalGroup(
            filterTasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filterTasksJPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(filterTasksLeadJCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filterTasksUserStoryJCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filterTasksTaskJCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filterTasksStatusJCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterTasksEstCompletionJCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterTasksActualCompletionJCheckBox)
                .addGap(18, 18, 18)
                .addComponent(filterTasksSaveButton)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout filterTasksJFrameLayout = new javax.swing.GroupLayout(filterTasksJFrame.getContentPane());
        filterTasksJFrame.getContentPane().setLayout(filterTasksJFrameLayout);
        filterTasksJFrameLayout.setHorizontalGroup(
            filterTasksJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(filterTasksJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        filterTasksJFrameLayout.setVerticalGroup(
            filterTasksJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filterTasksJFrameLayout.createSequentialGroup()
                .addComponent(filterTasksJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ProjectTracker");
        setBounds(new java.awt.Rectangle(50, 50, 0, 0));
        setIconImage(new ImageIcon(getClass().getResource("/resources/icons/binoculars.png")).getImage());
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        projectComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                projectComboBoxItemStateChanged(evt);
            }
        });

        signOutButton.setText("Sign Out");
        signOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signOutButtonActionPerformed(evt);
            }
        });

        newProjectButton.setText("New Project");
        newProjectButton.setToolTipText("New Project");
        newProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProjectButtonActionPerformed(evt);
            }
        });

        editProjectButton.setText("Edit Project");
        editProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProjectButtonActionPerformed(evt);
            }
        });

        settingsButton.setText("Settings");
        settingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsButtonActionPerformed(evt);
            }
        });

        aboutButton.setText("About");
        aboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutButtonActionPerformed(evt);
            }
        });

        tabbedPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tabbedPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tabbedPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabbedPaneMouseClicked(evt);
            }
        });

        addMemberButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/add30.png"))); // NOI18N
        addMemberButton.setToolTipText("Add Member");
        addMemberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMemberButtonActionPerformed(evt);
            }
        });

        removeMemberButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/delete30.png"))); // NOI18N
        removeMemberButton.setToolTipText("Delete Member");
        removeMemberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeMemberButtonActionPerformed(evt);
            }
        });

        editMemberButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/edit30.png"))); // NOI18N
        editMemberButton.setToolTipText("Edit Member");
        editMemberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editMemberButtonActionPerformed(evt);
            }
        });

        teamTable.setAutoCreateRowSorter(true);
        teamTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Full Name", "Phone", "Email", "Tasks"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        teamTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teamTableMouseClicked(evt);
            }
        });
        teamTableScrollPane.setViewportView(teamTable);

        teamFilterTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                teamFilterTextFieldKeyReleased(evt);
            }
        });

        filterTeamButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/filter30.png"))); // NOI18N
        filterTeamButton.setToolTipText("Edit Member");
        filterTeamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterTeamButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout teamPanelLayout = new javax.swing.GroupLayout(teamPanel);
        teamPanel.setLayout(teamPanelLayout);
        teamPanelLayout.setHorizontalGroup(
            teamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, teamPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(teamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(teamTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 911, Short.MAX_VALUE)
                    .addGroup(teamPanelLayout.createSequentialGroup()
                        .addComponent(addMemberButton)
                        .addGap(18, 18, 18)
                        .addComponent(removeMemberButton)
                        .addGap(18, 18, 18)
                        .addComponent(editMemberButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filterTeamButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(teamFilterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        teamPanelLayout.setVerticalGroup(
            teamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(teamPanelLayout.createSequentialGroup()
                .addGroup(teamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addMemberButton)
                    .addComponent(removeMemberButton)
                    .addComponent(editMemberButton)
                    .addComponent(filterTeamButton)
                    .addGroup(teamPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(teamFilterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(teamTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPane.addTab("", new javax.swing.ImageIcon(getClass().getResource("/resources/icons/team75.png")), teamPanel, "Team"); // NOI18N

        addTasksButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/add30.png"))); // NOI18N
        addTasksButton.setToolTipText("Add Task");
        addTasksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTasksButtonActionPerformed(evt);
            }
        });

        removeTaskButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/delete30.png"))); // NOI18N
        removeTaskButton.setToolTipText("Remove Task");
        removeTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeTaskButtonActionPerformed(evt);
            }
        });

        editTaskButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/edit30.png"))); // NOI18N
        editTaskButton.setToolTipText("Edit Task");
        editTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTaskButtonActionPerformed(evt);
            }
        });

        tasksFilterTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tasksFilterTextFieldKeyReleased(evt);
            }
        });

        tasksTable.setAutoCreateRowSorter(true);
        tasksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lead", "User Story", "Task", "Status", "Estimated Completion", "Actual Completion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tasksTableScrollPane.setViewportView(tasksTable);

        filterTasksButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/filter30.png"))); // NOI18N
        filterTasksButton.setToolTipText("Edit Member");
        filterTasksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterTasksButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tasksPanelLayout = new javax.swing.GroupLayout(tasksPanel);
        tasksPanel.setLayout(tasksPanelLayout);
        tasksPanelLayout.setHorizontalGroup(
            tasksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tasksPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tasksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tasksPanelLayout.createSequentialGroup()
                        .addComponent(addTasksButton)
                        .addGap(18, 18, 18)
                        .addComponent(removeTaskButton)
                        .addGap(18, 18, 18)
                        .addComponent(editTaskButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filterTasksButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tasksFilterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tasksTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 911, Short.MAX_VALUE))
                .addContainerGap())
        );
        tasksPanelLayout.setVerticalGroup(
            tasksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tasksPanelLayout.createSequentialGroup()
                .addGroup(tasksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addTasksButton)
                    .addComponent(removeTaskButton)
                    .addComponent(editTaskButton)
                    .addComponent(filterTasksButton)
                    .addGroup(tasksPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tasksFilterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tasksTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPane.addTab("", new javax.swing.ImageIcon(getClass().getResource("/resources/icons/tasks75.png")), tasksPanel, "Tasks"); // NOI18N

        javax.swing.GroupLayout schedulePanelLayout = new javax.swing.GroupLayout(schedulePanel);
        schedulePanel.setLayout(schedulePanelLayout);
        schedulePanelLayout.setHorizontalGroup(
            schedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 931, Short.MAX_VALUE)
        );
        schedulePanelLayout.setVerticalGroup(
            schedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 461, Short.MAX_VALUE)
        );

        tabbedPane.addTab("", new javax.swing.ImageIcon(getClass().getResource("/resources/icons/cal75.png")), schedulePanel, "Schedule"); // NOI18N

        javax.swing.GroupLayout progressPanelLayout = new javax.swing.GroupLayout(progressPanel);
        progressPanel.setLayout(progressPanelLayout);
        progressPanelLayout.setHorizontalGroup(
            progressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 931, Short.MAX_VALUE)
        );
        progressPanelLayout.setVerticalGroup(
            progressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 461, Short.MAX_VALUE)
        );

        tabbedPane.addTab("", new javax.swing.ImageIcon(getClass().getResource("/resources/icons/graph75.png")), progressPanel, "Progress"); // NOI18N

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Project");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Team");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Eric Ashley");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Cam Warner");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Mike Vokes");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Eric Munson");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Zach Burnside");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Thomas Rankin");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Tasks");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("User Story 1");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("User Story 2");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("User Story 3");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("User Story 4");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(jTree1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 931, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
        );

        tabbedPane.addTab("", new javax.swing.ImageIcon(getClass().getResource("/resources/icons/overview75.png")), jPanel1, "Project Overview"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(projectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                        .addComponent(newProjectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editProjectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(settingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aboutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(signOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(projectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newProjectButton)
                    .addComponent(settingsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(aboutButton)
                    .addComponent(signOutButton)
                    .addComponent(editProjectButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedPane)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//<editor-fold defaultstate="collapsed" desc=" Actions ">
    private void signOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signOutButtonActionPerformed
        passwordTextField.setText("");
        loginJFrame.setVisible(true);
    }//GEN-LAST:event_signOutButtonActionPerformed

    private void addMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMemberButtonActionPerformed
        addMemberNameTextField.setText("");
//        addMemberPhoneTextField.setText("");
//        addMemberEmailTextField.setText("");
        addMemberJFrame.setVisible(true);
    }//GEN-LAST:event_addMemberButtonActionPerformed

    private void addTasksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTasksButtonActionPerformed
        addTasksLeadTextField.setText("");
        addTasksUserStoryTextField.setText("");
        addTasksTaskTextField.setText("");
        addTasksStatusTextField.setText("");
        addTasksEstimatedTextField.setText("");
        addTasksActualTextField.setText("");
        addTasksJFrame.setVisible(true);
    }//GEN-LAST:event_addTasksButtonActionPerformed

    private void removeTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeTaskButtonActionPerformed
        if (!engine.removeTask(tasksTable)) {
            JOptionPane.showMessageDialog(this,
                    "No Task Selected",
                    "No Task Selected", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_removeTaskButtonActionPerformed

    private void removeMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeMemberButtonActionPerformed
        if (!engine.removeMember(teamTable)) {
            JOptionPane.showMessageDialog(this,
                    "No Member Selected",
                    "No Member Selected", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_removeMemberButtonActionPerformed

    private void tabbedPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabbedPaneMouseClicked
        engine.updateChart(progressPanel);
    }//GEN-LAST:event_tabbedPaneMouseClicked

    private void addMemberDialogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMemberDialogButtonActionPerformed
        String userString = addMemberNameTextField.getText();
        if (engine.addMember(teamTable, userString)) {
            JOptionPane.showMessageDialog(this,
                    userString + "has been added as a member of this team",
                    "Success", JOptionPane.DEFAULT_OPTION);
        } else {
        }
        addMemberJFrame.setVisible(false);
    }//GEN-LAST:event_addMemberDialogButtonActionPerformed

    private void saveEditMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveEditMemberButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) teamTable.getModel();
        model.setValueAt(editNameTextField.getText(), teamTable.getSelectedRow(), 0);
        model.setValueAt(editPhoneTextField.getText(), teamTable.getSelectedRow(), 1);
        model.setValueAt(editEmailTextField.getText(), teamTable.getSelectedRow(), 2);
        editMemberJFrame.setVisible(false);
    }//GEN-LAST:event_saveEditMemberButtonActionPerformed

    private void editMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMemberButtonActionPerformed
        JTextField[] textFields = {editNameTextField, editPhoneTextField, editEmailTextField};
        if (engine.editUser(teamTable, textFields)) {
            editMemberJFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this,
                    "No Member Selected",
                    "No Member Selected", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_editMemberButtonActionPerformed

    private void editTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTaskButtonActionPerformed
        boolean isAnyRowSelected = false;
        for (int i = 0; i < tasksTable.getRowCount(); i++) {
            if (tasksTable.isRowSelected(i)) {
                isAnyRowSelected = true;
            }
        }
        if (isAnyRowSelected) {
            editTasksLeadTextField.setText(tasksTable.getValueAt(tasksTable.getSelectedRow(), 0).toString());
            editTasksUserStoryTextField.setText(tasksTable.getValueAt(tasksTable.getSelectedRow(), 1).toString());
            editTasksTaskTextField.setText(tasksTable.getValueAt(tasksTable.getSelectedRow(), 2).toString());
            editTasksStatusTextField.setText(tasksTable.getValueAt(tasksTable.getSelectedRow(), 3).toString());
            editTasksEstimatedTextField.setText(tasksTable.getValueAt(tasksTable.getSelectedRow(), 4).toString());
            editTasksActualTextField.setText(tasksTable.getValueAt(tasksTable.getSelectedRow(), 5).toString());
            editTasksJFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this,
                    "No Task Selected",
                    "No Task Selected", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_editTaskButtonActionPerformed

    private void addTasksDialogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTasksDialogButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) tasksTable.getModel();
        model.addRow(new Object[]{addTasksLeadTextField.getText(), addTasksUserStoryTextField.getText(), addTasksTaskTextField.getText(), addTasksStatusTextField.getText(), addTasksEstimatedTextField.getText(), addTasksActualTextField.getText()});
        addTasksJFrame.setVisible(false);
    }//GEN-LAST:event_addTasksDialogButtonActionPerformed

    private void editTasksDialogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTasksDialogButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) tasksTable.getModel();
        model.setValueAt(editTasksLeadTextField.getText(), tasksTable.getSelectedRow(), 0);
        model.setValueAt(editTasksUserStoryTextField.getText(), tasksTable.getSelectedRow(), 1);
        model.setValueAt(editTasksTaskTextField.getText(), tasksTable.getSelectedRow(), 2);
        model.setValueAt(editTasksStatusTextField.getText(), tasksTable.getSelectedRow(), 3);
        model.setValueAt(editTasksEstimatedTextField.getText(), tasksTable.getSelectedRow(), 4);
        model.setValueAt(editTasksActualTextField.getText(), tasksTable.getSelectedRow(), 5);
        editTasksJFrame.setVisible(false);
    }//GEN-LAST:event_editTasksDialogButtonActionPerformed

    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
        JOptionPane.showMessageDialog(this,
                "ProjectTracker is an open source project of six GVSU students for CIS 467\n"
                + "Please direct comments and suggestions to ProjectTrackerApp@gmail.com\n"
                + "Credits:\n"
                + "Eric Ashley - GUI and Graph integration\n"
                + "Eric Munson - Android GUI port\n"
                + "Cam Warner - Client backend and gCal, Toggl integration\n"
                + "Tommy Rankin - Testing and documentation\n"
                + "Mike Vokes - Client/Server Backend\n"
                + "Zach Burnside - Object Oriented Database/Server Back End",
                "About ProjectTracker", JOptionPane.DEFAULT_OPTION);
    }//GEN-LAST:event_aboutButtonActionPerformed

    private void newProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProjectButtonActionPerformed
        try {
            String projectTitle = JOptionPane.showInputDialog("Project Title");
            if (!projectTitle.isEmpty()) {
                projectComboBox.addItem(projectTitle);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Project title is required to create a new project",
                        "Title Required", JOptionPane.DEFAULT_OPTION);
            }
        } catch (Exception e) {//do nothing if canceled
        }
    }//GEN-LAST:event_newProjectButtonActionPerformed

    private void editProjectSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProjectSaveButtonActionPerformed
        String edittedProjectName = editProjectTextField.getText();
        if (edittedProjectName.equals("DELETE")) {
            projectComboBox.removeItemAt(projectComboBox.getSelectedIndex());
            projectComboBox.setSelectedItem(null);
        } else {
            projectComboBox.getModel().setSelectedItem(editProjectTextField.getText());
        }
        editProjectJFrame.setVisible(false);
    }//GEN-LAST:event_editProjectSaveButtonActionPerformed

    private void editProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProjectButtonActionPerformed
        editProjectJFrame.setVisible(true);
        Object selectedProject = projectComboBox.getSelectedItem();
        if (selectedProject != null) {
            editProjectTextField.setText(selectedProject.toString());
        }
    }//GEN-LAST:event_editProjectButtonActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        if (engine.validCredentials()) {
            loginJFrame.setVisible(false);
            this.engine.populateProjectComboBox(this.projectComboBox);
            //this.setExtendedState(6); //maximises the screen by default when loggin in.
            this.setVisible(true);
        } else {
            loginJFrame.setVisible(false);
            passwordTextField.setText("");
            JOptionPane.showMessageDialog(this,
                    "Invalid Credentials",
                    "Invalid Credentials", JOptionPane.DEFAULT_OPTION);
            loginJFrame.setVisible(true);
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void loginJFrameComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_loginJFrameComponentShown
        this.setVisible(false);
    }//GEN-LAST:event_loginJFrameComponentShown

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        engine.updateChart(progressPanel);
    }//GEN-LAST:event_formComponentResized

    private void settingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsButtonActionPerformed
        settingsJFrame.setVisible(true);
    }//GEN-LAST:event_settingsButtonActionPerformed

    private void saveSettingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveSettingsButtonActionPerformed
        updateLookAndFeel(themeComboBox.getSelectedItem().toString());
        settingsJFrame.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_saveSettingsButtonActionPerformed

    private void projectComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_projectComboBoxItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) { // this should fix the event happening multiple times
            engine.setCurrentProject((Project) this.projectComboBox.getSelectedItem());//TODO: Fix this
            engine.loadTeamTable(teamTable);
        }
    }//GEN-LAST:event_projectComboBoxItemStateChanged

    private void createUserDialogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserDialogButtonActionPerformed
        JTextField[] textFields = {createUserUsernameTextField,
            firstPasswordField,
            confirmPasswordField,
            createUserNameTextField,
            createUserPhoneTextField,
            createUserEmailTextField};
        engine.createUser(textFields);
        createUserJFrame.setVisible(false);
        loginJFrame.setVisible(true);
    }//GEN-LAST:event_createUserDialogButtonActionPerformed

    private void createUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserButtonActionPerformed
        loginJFrame.setVisible(false);
        createUserJFrame.setVisible(true);
    }//GEN-LAST:event_createUserButtonActionPerformed

    private void createUserJFrameWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_createUserJFrameWindowClosed
        loginJFrame.setVisible(true);
    }//GEN-LAST:event_createUserJFrameWindowClosed

    private void teamTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teamTableMouseClicked
        if (teamTable.getSelectedColumn() == 4) { //last column
            tabbedPane.setSelectedIndex(1); //tasks pane
            tasksFilterTextField.setText(teamTable.getValueAt(teamTable.getSelectedRow(), 0).toString());
            engine.filterTable(tasksTable, tasksFilterTextField.getText());
        }
    }//GEN-LAST:event_teamTableMouseClicked

    private void teamFilterTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_teamFilterTextFieldKeyReleased
        engine.filterTable(teamTable, teamFilterTextField.getText());
    }//GEN-LAST:event_teamFilterTextFieldKeyReleased

    private void tasksFilterTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tasksFilterTextFieldKeyReleased
        engine.filterTable(tasksTable, tasksFilterTextField.getText());
    }//GEN-LAST:event_tasksFilterTextFieldKeyReleased

    private void filterTeamButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterTeamButtonActionPerformed
        filterTeamJFrame.setVisible(true);
    }//GEN-LAST:event_filterTeamButtonActionPerformed

    private void filterTeamSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterTeamSaveButtonActionPerformed
        boolean[] checkedBoxes = {filterTeamUsernameJCheckBox.isSelected(),
            filterTeamFullNameJCheckBox.isSelected(),
            filterTeamPhoneJCheckBox.isSelected(),
            filterTeamEmailJCheckBox.isSelected()
        };
        engine.setFilterColumns(checkedBoxes);
        filterTeamJFrame.setVisible(false);
    }//GEN-LAST:event_filterTeamSaveButtonActionPerformed

    private void filterTasksSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterTasksSaveButtonActionPerformed
        boolean[] checkedBoxes = {filterTasksLeadJCheckBox.isSelected(),
            filterTasksUserStoryJCheckBox.isSelected(),
            filterTasksTaskJCheckBox.isSelected(),
            filterTasksStatusJCheckBox.isSelected(),
            filterTasksEstCompletionJCheckBox.isSelected(),
            filterTasksActualCompletionJCheckBox.isSelected()
        };
        engine.setFilterColumns(checkedBoxes);
        filterTasksJFrame.setVisible(false);
    }//GEN-LAST:event_filterTasksSaveButtonActionPerformed

    private void filterTasksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterTasksButtonActionPerformed
         filterTasksJFrame.setVisible(true);
    }//GEN-LAST:event_filterTasksButtonActionPerformed
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc=" public static void main(String args[]) ">

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            setDefaultLookAndFeelDecorated(true);
            javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }
        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new mainView().loginJFrame.setVisible(true);
            }
        });
    }
    //</editor-fold>
//<editor-fold defaultstate="collapsed" desc=" Variable declarations ">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aboutButton;
    private javax.swing.JButton addMemberButton;
    private javax.swing.JButton addMemberDialogButton;
    private javax.swing.JFrame addMemberJFrame;
    private javax.swing.JPanel addMemberJPanel;
    private javax.swing.JLabel addMemberNameJLabel;
    private javax.swing.JTextField addMemberNameTextField;
    private javax.swing.JLabel addTasksActualJLabel;
    private javax.swing.JTextField addTasksActualTextField;
    private javax.swing.JButton addTasksButton;
    private javax.swing.JButton addTasksDialogButton;
    private javax.swing.JLabel addTasksEstimatedJLabel;
    private javax.swing.JTextField addTasksEstimatedTextField;
    private javax.swing.JFrame addTasksJFrame;
    private javax.swing.JPanel addTasksJPanel;
    private javax.swing.JLabel addTasksLeadJLabel;
    private javax.swing.JTextField addTasksLeadTextField;
    private javax.swing.JLabel addTasksStatusJLabel;
    private javax.swing.JTextField addTasksStatusTextField;
    private javax.swing.JLabel addTasksTaskJLabel;
    private javax.swing.JTextField addTasksTaskTextField;
    private javax.swing.JLabel addTasksUserStoryJLabel;
    private javax.swing.JTextField addTasksUserStoryTextField;
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JButton createUserButton;
    private javax.swing.JButton createUserDialogButton;
    private javax.swing.JLabel createUserEmailJLabel;
    private javax.swing.JTextField createUserEmailTextField;
    private javax.swing.JFrame createUserJFrame;
    private javax.swing.JPanel createUserJPanel;
    private javax.swing.JLabel createUserNameJLabel;
    private javax.swing.JLabel createUserNameJLabel1;
    private javax.swing.JTextField createUserNameTextField;
    private javax.swing.JLabel createUserPhoneJLabel;
    private javax.swing.JTextField createUserPhoneTextField;
    private javax.swing.JLabel createUserUsernameJLabel;
    private javax.swing.JTextField createUserUsernameTextField;
    private javax.swing.JTextField editEmailTextField;
    private javax.swing.JButton editMemberButton;
    private javax.swing.JLabel editMemberEmailJLabel;
    private javax.swing.JFrame editMemberJFrame;
    private javax.swing.JPanel editMemberJPanel;
    private javax.swing.JLabel editMemberNameJLabel;
    private javax.swing.JLabel editMemberPhoneJLabel;
    private javax.swing.JTextField editNameTextField;
    private javax.swing.JTextField editPhoneTextField;
    private javax.swing.JButton editProjectButton;
    private javax.swing.JLabel editProjectDeleteJLabel;
    private javax.swing.JFrame editProjectJFrame;
    private javax.swing.JPanel editProjectJPanel;
    private javax.swing.JLabel editProjectRenameJLabel;
    private javax.swing.JButton editProjectSaveButton;
    private javax.swing.JTextField editProjectTextField;
    private javax.swing.JButton editTaskButton;
    private javax.swing.JLabel editTasksActualJLabel;
    private javax.swing.JTextField editTasksActualTextField;
    private javax.swing.JButton editTasksDialogButton;
    private javax.swing.JLabel editTasksEstimatedJLabel;
    private javax.swing.JTextField editTasksEstimatedTextField;
    private javax.swing.JFrame editTasksJFrame;
    private javax.swing.JPanel editTasksJPanel;
    private javax.swing.JLabel editTasksLeadJLabel;
    private javax.swing.JTextField editTasksLeadTextField;
    private javax.swing.JLabel editTasksStatusJLabel;
    private javax.swing.JTextField editTasksStatusTextField;
    private javax.swing.JLabel editTasksTaskJLabel;
    private javax.swing.JTextField editTasksTaskTextField;
    private javax.swing.JLabel editTasksUserStoryJLabel;
    private javax.swing.JTextField editTasksUserStoryTextField;
    private javax.swing.JCheckBox filterTasksActualCompletionJCheckBox;
    private javax.swing.JButton filterTasksButton;
    private javax.swing.JCheckBox filterTasksEstCompletionJCheckBox;
    private javax.swing.JFrame filterTasksJFrame;
    private javax.swing.JPanel filterTasksJPanel;
    private javax.swing.JCheckBox filterTasksLeadJCheckBox;
    private javax.swing.JButton filterTasksSaveButton;
    private javax.swing.JCheckBox filterTasksStatusJCheckBox;
    private javax.swing.JCheckBox filterTasksTaskJCheckBox;
    private javax.swing.JCheckBox filterTasksUserStoryJCheckBox;
    private javax.swing.JButton filterTeamButton;
    private javax.swing.JCheckBox filterTeamEmailJCheckBox;
    private javax.swing.JCheckBox filterTeamFullNameJCheckBox;
    private javax.swing.JFrame filterTeamJFrame;
    private javax.swing.JPanel filterTeamJPanel;
    private javax.swing.JCheckBox filterTeamPhoneJCheckBox;
    private javax.swing.JButton filterTeamSaveButton;
    private javax.swing.JCheckBox filterTeamUsernameJCheckBox;
    private javax.swing.JPasswordField firstPasswordField;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree1;
    private javax.swing.JButton loginButton;
    private javax.swing.JFrame loginJFrame;
    private javax.swing.JPanel loginJPanel;
    private javax.swing.JPanel loginJPanel1;
    private javax.swing.JButton newProjectButton;
    private javax.swing.JLabel passwordJLabel;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JPanel progressPanel;
    private javax.swing.JComboBox projectComboBox;
    private javax.swing.JButton removeMemberButton;
    private javax.swing.JButton removeTaskButton;
    private javax.swing.JButton saveEditMemberButton;
    private javax.swing.JButton saveSettingsButton;
    private javax.swing.JPanel schedulePanel;
    private javax.swing.JButton settingsButton;
    private javax.swing.JFrame settingsJFrame;
    private javax.swing.JButton signOutButton;
    private javax.swing.JLabel spaceJlabel;
    private javax.swing.JLabel spaceJlabel1;
    private javax.swing.JLabel spaceJlabel2;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTextField tasksFilterTextField;
    private javax.swing.JPanel tasksPanel;
    private javax.swing.JTable tasksTable;
    private javax.swing.JScrollPane tasksTableScrollPane;
    private javax.swing.JTextField teamFilterTextField;
    private javax.swing.JPanel teamPanel;
    private javax.swing.JTable teamTable;
    private javax.swing.JScrollPane teamTableScrollPane;
    private javax.swing.JComboBox themeComboBox;
    private javax.swing.JLabel usernameJLabel;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
//</editor-fold>
