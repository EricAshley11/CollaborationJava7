//<editor-fold defaultstate="collapsed" desc=" Imports and package ">
package collaboration;

import collaborationjava7.common.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
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

    static void communicationError() {
        String text = JOptionPane.showInputDialog(null, "Error communicating with server, please enter in your server's address.\n"+
                "Address should not include http:// or the port number", "Server Communication Error",
                JOptionPane.ERROR_MESSAGE);
        if(!text.isEmpty())
            engine.saveServerAddr(text);
    }
    static void noAddressFound(){
        String text = JOptionPane.showInputDialog(null, "Please enter in your server's address.\n"+
                "Address should not include http:// or the port number", "Change Server Address",
                JOptionPane.INFORMATION_MESSAGE);
        if(!text.isEmpty())
            engine.saveServerAddr(text);
    }

    JTogglHelper togglHelper = null;
    static mainEngine engine = new mainEngine();
    Task editingTask = null;

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
            javax.swing.SwingUtilities.updateComponentTreeUI(settingsJFrame);
            javax.swing.SwingUtilities.updateComponentTreeUI(loginJFrame);
            javax.swing.SwingUtilities.updateComponentTreeUI(createUserJFrame);
            javax.swing.SwingUtilities.updateComponentTreeUI(filterTeamJFrame);
            javax.swing.SwingUtilities.updateComponentTreeUI(filterTasksJFrame);
            javax.swing.SwingUtilities.updateComponentTreeUI(gCalendarLoginJFrame);
            javax.swing.SwingUtilities.updateComponentTreeUI(gCalendarAddCalendarJFrame);
            javax.swing.SwingUtilities.updateComponentTreeUI(gCalendarAddEntryJFrame);
            javax.swing.SwingUtilities.updateComponentTreeUI(addUserStoryJFrame);
        } catch (Exception e) {
            //System.out.println(e.toString());
        }
    }

    public void clearAllFields() {
        addEntryEndTimeTextField.setText("");
        addEntryStartTimeTextField.setText("");
        addEntryTitleTextField.setText("");
        addMemberUsernameTextField.setText("");
        addTasksActualTextField.setText("");
        addTasksEstimatedTextField.setText("");
        addTasksTaskTextField.setText("");
        confirmPasswordField.setText("");
        createUserEmailTextField.setText("");
        createUserNameTextField.setText("");
        createUserPhoneTextField.setText("");
        createUserUsernameTextField.setText("");
        editEmailTextField.setText("");
        editNameTextField.setText("");
        editPhoneTextField.setText("");
        editTasksActualTextField.setText("");
        editTasksEstimatedTextField.setText("");
        editTasksTaskTextField.setText("");
        firstPasswordField.setText("");
        gCalCalendarTitleTextField.setText("");
        gCalLocationTextField.setText("");
        gCalPasswordField.setText("");
        gCalUserNameTextField.setText("");
        newTeamConfirmPasswordField.setText("");
        newTeamNameTextField.setText("");
        newTeamPasswordField.setText("");
        passwordTextField.setText("");
        tasksFilterTextField.setText("");
        teamFilterTextField.setText("");
        usernameTextField.setText("");
    }
    public void filterTasks(String tasks){
            tabbedPane.setSelectedComponent(this.tasksPanel); //tasks pane
            tasksFilterTextField.setText(tasks);
            engine.filterTable(tasksTable, tasksFilterTextField.getText());
    }
//</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMemberJFrame = new javax.swing.JFrame();
        addMemberJPanel = new javax.swing.JPanel();
        addMemberDialogButton = new javax.swing.JButton();
        addMemberNameJLabel = new javax.swing.JLabel();
        addMemberUsernameTextField = new javax.swing.JTextField();
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
        addTasksLeadJLabel = new javax.swing.JLabel();
        newUserStoryButton = new javax.swing.JButton();
        addTasksDialogButton = new javax.swing.JButton();
        newTaskUserStoryComboBox = new javax.swing.JComboBox();
        addTasksTaskJLabel = new javax.swing.JLabel();
        leadComboBox = new javax.swing.JComboBox();
        addTasksUserStoryJLabel = new javax.swing.JLabel();
        addTasksStatusJLabel = new javax.swing.JLabel();
        addTasksEstimatedJLabel = new javax.swing.JLabel();
        addTasksTaskTextField = new javax.swing.JTextField();
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
        editTasksTaskTextField = new javax.swing.JTextField();
        editTasksEstimatedTextField = new javax.swing.JTextField();
        editTasksActualTextField = new javax.swing.JTextField();
        editTaskLeadComboBox = new javax.swing.JComboBox();
        editTaskStatusComboBox = new javax.swing.JComboBox();
        editTaskUserStoryComboBox = new javax.swing.JComboBox();
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
        editServerAddrButton = new javax.swing.JButton();
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
        gCalendarLoginJFrame = new javax.swing.JFrame();
        gCalendarLoginPanel = new javax.swing.JPanel();
        gCalUserNameTextField = new javax.swing.JTextField();
        gCalUserNameLabel = new javax.swing.JLabel();
        gCalPasswordLabel = new javax.swing.JLabel();
        gCalLoginScreenButton = new javax.swing.JButton();
        gCalLoginScreenCancelButton = new javax.swing.JButton();
        gCalLoginCommandLabel = new javax.swing.JLabel();
        gCalPasswordField = new javax.swing.JPasswordField();
        gCalendarAddCalendarJFrame = new javax.swing.JFrame();
        gCalendarAddCalendarPanel = new javax.swing.JPanel();
        gCalAddCalendarTitleLabel = new javax.swing.JLabel();
        gCalCalendarTitleLabel = new javax.swing.JLabel();
        gCalCalendarTitleTextField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        gCalCalendarDescriptionTextArea = new javax.swing.JTextArea();
        gCalCalendarDescriptionLabel = new javax.swing.JLabel();
        gCalCalendarLocationLabel = new javax.swing.JLabel();
        gCalLocationTextField = new javax.swing.JTextField();
        gCalAddCalendarCancelButton = new javax.swing.JButton();
        gCalAddCalendarDoneButton = new javax.swing.JButton();
        noTeamJFrame = new javax.swing.JFrame();
        noTeamCreateNewTeamJButton = new javax.swing.JButton();
        noTeamJoinExistingTeamJButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        createNewTeamJFrame = new javax.swing.JFrame();
        createNewTeamButton = new javax.swing.JButton();
        newTeamNameTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        newTeamPasswordField = new javax.swing.JPasswordField();
        newTeamConfirmPasswordField = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        joinExistingTeamJFrame = new javax.swing.JFrame();
        joinExistingTeamJoinJButton = new javax.swing.JButton();
        joinExistingComboBox = new javax.swing.JComboBox();
        joinTeamPasswordField = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        gCalendarAddEntryJFrame = new javax.swing.JFrame();
        addEntryTitleLabel = new javax.swing.JLabel();
        addEntryTitleTextField = new javax.swing.JTextField();
        addEntryNameLabel = new javax.swing.JLabel();
        addEntryDescriptionLabel = new javax.swing.JLabel();
        addEntryStartTimeTextField = new javax.swing.JTextField();
        addEntryStartTimeLabel = new javax.swing.JLabel();
        addEntryEndTimeTextField = new javax.swing.JTextField();
        addEntryEndTimeLabel = new javax.swing.JLabel();
        startTimeComboBox = new javax.swing.JComboBox();
        endTimeComboBox = new javax.swing.JComboBox();
        addEntryDescriptionScrollPane = new javax.swing.JScrollPane();
        addEntryDescriptionTextArea = new javax.swing.JTextArea();
        addEntryCancelButton = new javax.swing.JButton();
        addEntryAddButton = new javax.swing.JButton();
        startDateLabel = new javax.swing.JLabel();
        endDateLabel = new javax.swing.JLabel();
        startDateTextField = new javax.swing.JTextField();
        endDateTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        addUserStoryJFrame = new javax.swing.JFrame();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        addUserStoryButton = new javax.swing.JButton();
        userStoryMilestoneComboBox = new javax.swing.JComboBox();
        addMilestoneButton = new javax.swing.JButton();
        userStoryNameTextField = new javax.swing.JTextField();
        togglFrame = new javax.swing.JFrame();
        jTogglPanel = new javax.swing.JPanel();
        togglPasswordField = new javax.swing.JPasswordField();
        togglUserField = new javax.swing.JTextField();
        togglLoginButton = new javax.swing.JButton();
        togglLoginLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
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
        jTogglTaskButton = new javax.swing.JButton();
        togglTaskTextField = new javax.swing.JTextField();
        togglButton = new javax.swing.JToggleButton();
        togglStatusTextBox = new javax.swing.JLabel();
        togglLabel = new javax.swing.JLabel();
        schedulePanel = new javax.swing.JPanel();
        calendarPanel = new javax.swing.JPanel();
        gCalLoginButton = new javax.swing.JButton();
        calendarScrollPane = new javax.swing.JScrollPane();
        calendarTextArea = new javax.swing.JTextArea();
        gCalLogoutButton = new javax.swing.JButton();
        calTableScrollPane = new javax.swing.JScrollPane();
        calTable = new javax.swing.JTable();
        calendarTableLabel = new javax.swing.JLabel();
        entryTableLabel = new javax.swing.JLabel();
        entryTableScrollPane = new javax.swing.JScrollPane();
        entryTable = new javax.swing.JTable();
        feedLabel = new javax.swing.JLabel();
        createCalendarButton = new javax.swing.JButton();
        removeCalendarButton = new javax.swing.JButton();
        createEventButton = new javax.swing.JButton();
        deleteEventButton = new javax.swing.JButton();
        progressPanel = new javax.swing.JPanel();
        gitHubPanel1 = new collaboration.GitHubPanel();
        userStoryPanel1 = new collaboration.UserStoryPanel(this);

        addMemberJFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMemberJFrame.setTitle("Add Member - ProjectTracker");
        addMemberJFrame.setAlwaysOnTop(true);
        addMemberJFrame.setBounds(new java.awt.Rectangle(50, 50, 250, 250));
        addMemberJFrame.setIconImage(new ImageIcon(getClass().getResource("/resources/icons/binoculars.png")).getImage());
        addMemberJFrame.setMinimumSize(new java.awt.Dimension(400, 100));
        addMemberJFrame.setName("Add Member"); // NOI18N
        addMemberJFrame.setResizable(false);

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
                        .addComponent(addMemberUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(addMemberUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        editMemberJFrame.setTitle("Edit Member - ProjectTracker");
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
                .addContainerGap(21, Short.MAX_VALUE))
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
        addTasksJFrame.setBounds(new java.awt.Rectangle(50, 50, 450, 350));
        addTasksJFrame.setIconImage(new ImageIcon(getClass().getResource("/resources/icons/binoculars.png")).getImage());
        addTasksJFrame.setMinimumSize(new java.awt.Dimension(450, 350));
        addTasksJFrame.setName("Add Member"); // NOI18N

        addTasksLeadJLabel.setText("Lead");

        newUserStoryButton.setText("+");
        newUserStoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newUserStoryButtonActionPerformed(evt);
            }
        });

        addTasksDialogButton.setText("Add Task");
        addTasksDialogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTasksDialogButtonActionPerformed(evt);
            }
        });

        newTaskUserStoryComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        newTaskUserStoryComboBox.setRenderer(new ListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = new JLabel();
                label.setOpaque(true);
                if (isSelected) {
                    label.setBackground(list.getSelectionBackground());
                    label.setForeground(list.getSelectionForeground());
                }
                else {
                    label.setBackground(list.getBackground());
                    label.setForeground(list.getForeground());
                }
                label.setText(((UserStory)value).getName());
                Border border = null;
                if (cellHasFocus) {
                    if (isSelected) {
                        border = UIManager.getBorder("List.focusSelectedCellHighlightBorder");
                    }
                    if (border == null) {
                        border = UIManager.getBorder("List.focusCellHighlightBorder");
                    }
                } else {
                    border = new EmptyBorder(1, 1, 1, 1);
                }
                label.setBorder(border);
                return label;
            }
        });

        addTasksTaskJLabel.setText("Task");

        leadComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        leadComboBox.setRenderer(new ListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = new JLabel();
                label.setOpaque(true);
                if (isSelected) {
                    label.setBackground(list.getSelectionBackground());
                    label.setForeground(list.getSelectionForeground());
                }
                else {
                    label.setBackground(list.getBackground());
                    label.setForeground(list.getForeground());
                }

                label.setText(((User)value).getName());
                Border border = null;
                if (cellHasFocus) {
                    if (isSelected) {
                        border = UIManager.getBorder("List.focusSelectedCellHighlightBorder");
                    }
                    if (border == null) {
                        border = UIManager.getBorder("List.focusCellHighlightBorder");
                    }
                } else {
                    border = new EmptyBorder(1, 1, 1, 1);
                }
                label.setBorder(border);
                return label;
            }
        });

        addTasksUserStoryJLabel.setText("User Story");

        addTasksStatusJLabel.setText("Estimated Comp.");

        addTasksEstimatedJLabel.setText("Actual Comp.");

        javax.swing.GroupLayout addTasksJFrameLayout = new javax.swing.GroupLayout(addTasksJFrame.getContentPane());
        addTasksJFrame.getContentPane().setLayout(addTasksJFrameLayout);
        addTasksJFrameLayout.setHorizontalGroup(
            addTasksJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addTasksJFrameLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(addTasksJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addTasksStatusJLabel)
                    .addComponent(addTasksEstimatedJLabel)
                    .addComponent(addTasksTaskJLabel)
                    .addComponent(addTasksUserStoryJLabel)
                    .addComponent(addTasksLeadJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(addTasksJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addTasksJFrameLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(addTasksDialogButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addTasksJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(addTasksEstimatedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addTasksTaskTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addTasksActualTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(addTasksJFrameLayout.createSequentialGroup()
                            .addGroup(addTasksJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(leadComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(newTaskUserStoryComboBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(newUserStoryButton))))
                .addGap(34, 34, 34))
        );
        addTasksJFrameLayout.setVerticalGroup(
            addTasksJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addTasksJFrameLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(addTasksJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(leadComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTasksLeadJLabel))
                .addGap(18, 18, 18)
                .addGroup(addTasksJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newTaskUserStoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newUserStoryButton)
                    .addComponent(addTasksUserStoryJLabel))
                .addGap(18, 18, 18)
                .addGroup(addTasksJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTasksTaskTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTasksTaskJLabel))
                .addGap(18, 18, 18)
                .addGroup(addTasksJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTasksEstimatedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTasksStatusJLabel))
                .addGap(23, 23, 23)
                .addGroup(addTasksJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTasksActualTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTasksEstimatedJLabel))
                .addGap(18, 18, 18)
                .addComponent(addTasksDialogButton)
                .addContainerGap(31, Short.MAX_VALUE))
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

        editTaskLeadComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        editTaskStatusComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        editTaskUserStoryComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                .addGroup(editTasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(editTaskUserStoryComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editTaskStatusComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editTasksDialogButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editTasksEstimatedTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addComponent(editTasksActualTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addComponent(editTasksTaskTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addComponent(editTaskLeadComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        editTasksJPanelLayout.setVerticalGroup(
            editTasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editTasksJPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(editTasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editTasksLeadJLabel)
                    .addComponent(editTaskLeadComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editTasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editTasksUserStoryJLabel)
                    .addComponent(editTaskUserStoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(editTasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editTasksTaskJLabel)
                    .addComponent(editTasksTaskTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editTasksJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editTasksActualJLabel)
                    .addComponent(editTaskStatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        passwordTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordTextFieldKeyPressed(evt);
            }
        });

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
                .addContainerGap(45, Short.MAX_VALUE))
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

        saveSettingsButton.setText("Save Theme");
        saveSettingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveSettingsButtonActionPerformed(evt);
            }
        });

        spaceJlabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/ProjectTracker.png"))); // NOI18N

        themeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nimbus (Default)", "Glass (Light)", "Tattoo (Dark)", "System (Windows, Mac, etc)" }));

        jLabel1.setText("Theme:");

        editServerAddrButton.setText("Edit Server Address");
        editServerAddrButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editServerAddrButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginJPanel1Layout = new javax.swing.GroupLayout(loginJPanel1);
        loginJPanel1.setLayout(loginJPanel1Layout);
        loginJPanel1Layout.setHorizontalGroup(
            loginJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginJPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(loginJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(loginJPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(themeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(spaceJlabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginJPanel1Layout.createSequentialGroup()
                .addContainerGap(146, Short.MAX_VALUE)
                .addComponent(saveSettingsButton)
                .addGap(92, 92, 92))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginJPanel1Layout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addComponent(editServerAddrButton)
                .addGap(75, 75, 75))
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
                .addGap(18, 18, 18)
                .addComponent(saveSettingsButton)
                .addGap(18, 18, 18)
                .addComponent(editServerAddrButton)
                .addContainerGap(70, Short.MAX_VALUE))
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
        createUserJFrame.setTitle("Create User - ProjectTracker");
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
                .addContainerGap(85, Short.MAX_VALUE)
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
        filterTasksJFrame.setMinimumSize(new java.awt.Dimension(0, 300));
        filterTasksJFrame.setName("Add Member"); // NOI18N

        filterTasksJPanel.setMinimumSize(new java.awt.Dimension(0, 240));

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
                .addContainerGap(35, Short.MAX_VALUE))
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

        gCalendarLoginJFrame.setTitle("Google Calendar Login");
        gCalendarLoginJFrame.setBounds(new java.awt.Rectangle(400, 250, 0, 0));
        gCalendarLoginJFrame.setMaximizedBounds(new java.awt.Rectangle(350, 225, 0, 0));
        gCalendarLoginJFrame.setMinimumSize(new java.awt.Dimension(350, 225));

        gCalendarLoginPanel.setMinimumSize(new java.awt.Dimension(300, 300));

        gCalUserNameLabel.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        gCalUserNameLabel.setText("Username:");

        gCalPasswordLabel.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        gCalPasswordLabel.setText("Password:");

        gCalLoginScreenButton.setText("Login");
        gCalLoginScreenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gCalLoginScreenButtonActionPerformed(evt);
            }
        });

        gCalLoginScreenCancelButton.setText("Cancel");
        gCalLoginScreenCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gCalLoginScreenCancelButtonActionPerformed(evt);
            }
        });

        gCalLoginCommandLabel.setText("Please login to your Google Account:");

        gCalPasswordField.setText("jPasswordField1");

        javax.swing.GroupLayout gCalendarLoginPanelLayout = new javax.swing.GroupLayout(gCalendarLoginPanel);
        gCalendarLoginPanel.setLayout(gCalendarLoginPanelLayout);
        gCalendarLoginPanelLayout.setHorizontalGroup(
            gCalendarLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gCalendarLoginPanelLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(gCalendarLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gCalendarLoginPanelLayout.createSequentialGroup()
                        .addGroup(gCalendarLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gCalPasswordLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(gCalUserNameLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(gCalendarLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(gCalendarLoginPanelLayout.createSequentialGroup()
                                .addComponent(gCalLoginScreenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(gCalLoginScreenCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(gCalPasswordField)
                            .addComponent(gCalUserNameTextField))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gCalendarLoginPanelLayout.createSequentialGroup()
                        .addComponent(gCalLoginCommandLabel)
                        .addGap(48, 48, 48))))
        );
        gCalendarLoginPanelLayout.setVerticalGroup(
            gCalendarLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gCalendarLoginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gCalLoginCommandLabel)
                .addGap(19, 19, 19)
                .addGroup(gCalendarLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gCalUserNameLabel)
                    .addComponent(gCalUserNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gCalendarLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gCalPasswordLabel)
                    .addComponent(gCalPasswordField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gCalendarLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gCalLoginScreenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gCalLoginScreenCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout gCalendarLoginJFrameLayout = new javax.swing.GroupLayout(gCalendarLoginJFrame.getContentPane());
        gCalendarLoginJFrame.getContentPane().setLayout(gCalendarLoginJFrameLayout);
        gCalendarLoginJFrameLayout.setHorizontalGroup(
            gCalendarLoginJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gCalendarLoginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        gCalendarLoginJFrameLayout.setVerticalGroup(
            gCalendarLoginJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gCalendarLoginJFrameLayout.createSequentialGroup()
                .addComponent(gCalendarLoginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        gCalendarAddCalendarJFrame.setBounds(new java.awt.Rectangle(400, 250, 451, 385));

        gCalendarAddCalendarPanel.setMinimumSize(new java.awt.Dimension(400, 370));

        gCalAddCalendarTitleLabel.setFont(new java.awt.Font("DejaVu Sans", 1, 18));
        gCalAddCalendarTitleLabel.setText(" Enter Calendar Information");
        gCalAddCalendarTitleLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        gCalCalendarTitleLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
        gCalCalendarTitleLabel.setText("Calendar Title:");

        gCalCalendarDescriptionTextArea.setColumns(20);
        gCalCalendarDescriptionTextArea.setRows(5);
        jScrollPane3.setViewportView(gCalCalendarDescriptionTextArea);

        gCalCalendarDescriptionLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
        gCalCalendarDescriptionLabel.setText("Calendar Description:");

        gCalCalendarLocationLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
        gCalCalendarLocationLabel.setText("Location:");

        gCalAddCalendarCancelButton.setText("Cancel");
        gCalAddCalendarCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gCalAddCalendarCancelButtonActionPerformed(evt);
            }
        });

        gCalAddCalendarDoneButton.setText("Done");
        gCalAddCalendarDoneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gCalAddCalendarDoneButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gCalendarAddCalendarPanelLayout = new javax.swing.GroupLayout(gCalendarAddCalendarPanel);
        gCalendarAddCalendarPanel.setLayout(gCalendarAddCalendarPanelLayout);
        gCalendarAddCalendarPanelLayout.setHorizontalGroup(
            gCalendarAddCalendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gCalendarAddCalendarPanelLayout.createSequentialGroup()
                .addGroup(gCalendarAddCalendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gCalendarAddCalendarPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(gCalendarAddCalendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(gCalendarAddCalendarPanelLayout.createSequentialGroup()
                                .addComponent(gCalAddCalendarCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(gCalAddCalendarDoneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(gCalendarAddCalendarPanelLayout.createSequentialGroup()
                                .addGroup(gCalendarAddCalendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(gCalCalendarDescriptionLabel)
                                    .addComponent(gCalCalendarTitleLabel)
                                    .addComponent(gCalCalendarLocationLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gCalendarAddCalendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                                    .addComponent(gCalCalendarTitleTextField)
                                    .addComponent(gCalLocationTextField)))))
                    .addGroup(gCalendarAddCalendarPanelLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(gCalAddCalendarTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gCalendarAddCalendarPanelLayout.setVerticalGroup(
            gCalendarAddCalendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gCalendarAddCalendarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gCalAddCalendarTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(gCalendarAddCalendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gCalCalendarTitleLabel)
                    .addComponent(gCalCalendarTitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(gCalendarAddCalendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gCalCalendarDescriptionLabel)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(gCalendarAddCalendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gCalCalendarLocationLabel)
                    .addComponent(gCalLocationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(gCalendarAddCalendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gCalAddCalendarDoneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gCalAddCalendarCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout gCalendarAddCalendarJFrameLayout = new javax.swing.GroupLayout(gCalendarAddCalendarJFrame.getContentPane());
        gCalendarAddCalendarJFrame.getContentPane().setLayout(gCalendarAddCalendarJFrameLayout);
        gCalendarAddCalendarJFrameLayout.setHorizontalGroup(
            gCalendarAddCalendarJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gCalendarAddCalendarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        gCalendarAddCalendarJFrameLayout.setVerticalGroup(
            gCalendarAddCalendarJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gCalendarAddCalendarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        noTeamJFrame.setTitle("Join or Create Team");
        noTeamJFrame.setBounds(new java.awt.Rectangle(55, 55, 369, 150));
        noTeamJFrame.setMinimumSize(new java.awt.Dimension(369, 170));

        noTeamCreateNewTeamJButton.setText("Create New Team");
        noTeamCreateNewTeamJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noTeamCreateNewTeamJButtonActionPerformed(evt);
            }
        });

        noTeamJoinExistingTeamJButton.setText("Join Existing Team");
        noTeamJoinExistingTeamJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noTeamJoinExistingTeamJButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("You are not currently a member of a team");

        javax.swing.GroupLayout noTeamJFrameLayout = new javax.swing.GroupLayout(noTeamJFrame.getContentPane());
        noTeamJFrame.getContentPane().setLayout(noTeamJFrameLayout);
        noTeamJFrameLayout.setHorizontalGroup(
            noTeamJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noTeamJFrameLayout.createSequentialGroup()
                .addGroup(noTeamJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(noTeamJFrameLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel4))
                    .addGroup(noTeamJFrameLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(noTeamJoinExistingTeamJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(noTeamCreateNewTeamJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        noTeamJFrameLayout.setVerticalGroup(
            noTeamJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, noTeamJFrameLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(noTeamJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noTeamJoinExistingTeamJButton)
                    .addComponent(noTeamCreateNewTeamJButton))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        createNewTeamJFrame.setTitle("Create Team");
        createNewTeamJFrame.setBounds(new java.awt.Rectangle(55, 55, 377, 158));
        createNewTeamJFrame.setMinimumSize(new java.awt.Dimension(377, 158));

        createNewTeamButton.setText("Create Team");
        createNewTeamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNewTeamButtonActionPerformed(evt);
            }
        });

        newTeamNameTextField.setName(""); // NOI18N

        jLabel9.setText("Team Name:");

        jLabel10.setText("Team Password:");

        jLabel11.setText("Confirm Password:");

        javax.swing.GroupLayout createNewTeamJFrameLayout = new javax.swing.GroupLayout(createNewTeamJFrame.getContentPane());
        createNewTeamJFrame.getContentPane().setLayout(createNewTeamJFrameLayout);
        createNewTeamJFrameLayout.setHorizontalGroup(
            createNewTeamJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createNewTeamJFrameLayout.createSequentialGroup()
                .addGroup(createNewTeamJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(createNewTeamButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, createNewTeamJFrameLayout.createSequentialGroup()
                        .addGroup(createNewTeamJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(createNewTeamJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newTeamNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(createNewTeamJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(newTeamPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                .addComponent(newTeamConfirmPasswordField)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        createNewTeamJFrameLayout.setVerticalGroup(
            createNewTeamJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createNewTeamJFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(createNewTeamJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newTeamNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(11, 11, 11)
                .addGroup(createNewTeamJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(newTeamPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(createNewTeamJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(newTeamConfirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(createNewTeamButton)
                .addContainerGap())
        );

        joinExistingTeamJFrame.setTitle("Join or Create Team");
        joinExistingTeamJFrame.setBounds(new java.awt.Rectangle(55, 55, 369, 150));
        joinExistingTeamJFrame.setMinimumSize(new java.awt.Dimension(369, 150));

        joinExistingTeamJoinJButton.setText("Join");
        joinExistingTeamJoinJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinExistingTeamJoinJButtonActionPerformed(evt);
            }
        });

        joinExistingComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Team1" }));

        jLabel12.setText("Team:");

        jLabel13.setText("Password:");

        javax.swing.GroupLayout joinExistingTeamJFrameLayout = new javax.swing.GroupLayout(joinExistingTeamJFrame.getContentPane());
        joinExistingTeamJFrame.getContentPane().setLayout(joinExistingTeamJFrameLayout);
        joinExistingTeamJFrameLayout.setHorizontalGroup(
            joinExistingTeamJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(joinExistingTeamJFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(joinExistingTeamJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(joinExistingTeamJFrameLayout.createSequentialGroup()
                        .addGroup(joinExistingTeamJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                        .addGap(25, 25, 25)
                        .addGroup(joinExistingTeamJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(joinTeamPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                            .addComponent(joinExistingComboBox, 0, 253, Short.MAX_VALUE)))
                    .addComponent(joinExistingTeamJoinJButton, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE))
                .addContainerGap())
        );
        joinExistingTeamJFrameLayout.setVerticalGroup(
            joinExistingTeamJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(joinExistingTeamJFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(joinExistingTeamJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(joinExistingComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(joinExistingTeamJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(joinTeamPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(joinExistingTeamJoinJButton)
                .addContainerGap())
        );

        gCalendarAddEntryJFrame.setTitle("Add Entry");
        gCalendarAddEntryJFrame.setBounds(new java.awt.Rectangle(300, 400, 470, 450));

        addEntryTitleLabel.setFont(new java.awt.Font("DejaVu Sans", 1, 18));
        addEntryTitleLabel.setText("Add Calendar Entry");

        addEntryNameLabel.setText("Entry Title:");

        addEntryDescriptionLabel.setText("Entry Description:");

        addEntryStartTimeTextField.setText("12:00");

        addEntryStartTimeLabel.setText("Start Time:");

        addEntryEndTimeTextField.setText("1:00");
		addEntryEndTimeTextField.setMinimumSize(new java.awt.Dimension(28, 20));

        addEntryEndTimeLabel.setText("End Time:");

        startTimeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AM", "PM" }));

        endTimeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AM", "PM" }));

        addEntryDescriptionTextArea.setColumns(20);
        addEntryDescriptionTextArea.setRows(5);
        addEntryDescriptionScrollPane.setViewportView(addEntryDescriptionTextArea);

        addEntryCancelButton.setText("Cancel");
        addEntryCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEntryCancelButtonActionPerformed(evt);
            }
        });

        addEntryAddButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/add30.png"))); // NOI18N
        addEntryAddButton.setText("Add");
        addEntryAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEntryAddButtonActionPerformed(evt);
            }
        });

        startDateLabel.setText("Start Date:");

        endDateLabel.setText("End Date:");

        jLabel6.setText("(MM/DD/YYYY)");

        jLabel14.setText("(MM/DD/YYYY)");
        javax.swing.GroupLayout gCalendarAddEntryJFrameLayout = new javax.swing.GroupLayout(gCalendarAddEntryJFrame.getContentPane());
        gCalendarAddEntryJFrame.getContentPane().setLayout(gCalendarAddEntryJFrameLayout);
        gCalendarAddEntryJFrameLayout.setHorizontalGroup(
            gCalendarAddEntryJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gCalendarAddEntryJFrameLayout.createSequentialGroup()
                .addGroup(gCalendarAddEntryJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gCalendarAddEntryJFrameLayout.createSequentialGroup()
						.addGap(35, 35, 35)
                        .addGroup(gCalendarAddEntryJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(gCalendarAddEntryJFrameLayout.createSequentialGroup()
                                .addComponent(addEntryStartTimeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addEntryStartTimeTextField))
                            .addGroup(gCalendarAddEntryJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(addEntryNameLabel)
                                .addComponent(addEntryDescriptionLabel))
                            .addGroup(gCalendarAddEntryJFrameLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(addEntryEndTimeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addEntryEndTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16)
                        .addGroup(gCalendarAddEntryJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(gCalendarAddEntryJFrameLayout.createSequentialGroup()
                               .addGap(18, 18, 18)
                                .addGroup(gCalendarAddEntryJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addEntryDescriptionScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                    .addComponent(addEntryTitleTextField)))
                            .addGroup(gCalendarAddEntryJFrameLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gCalendarAddEntryJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(gCalendarAddEntryJFrameLayout.createSequentialGroup()
                                        .addComponent(endTimeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(endDateLabel))
                                    .addGroup(gCalendarAddEntryJFrameLayout.createSequentialGroup()
                                        .addComponent(startTimeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(startDateLabel)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gCalendarAddEntryJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(startDateTextField)
                                    .addComponent(endDateTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gCalendarAddEntryJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(0, 29, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gCalendarAddEntryJFrameLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(gCalendarAddEntryJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(gCalendarAddEntryJFrameLayout.createSequentialGroup()
                                .addComponent(addEntryAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(addEntryCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(gCalendarAddEntryJFrameLayout.createSequentialGroup()
                                .addComponent(addEntryTitleLabel)
                                .addGap(96, 96, 96)))))
                .addContainerGap())
        );
        gCalendarAddEntryJFrameLayout.setVerticalGroup(
            gCalendarAddEntryJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gCalendarAddEntryJFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addEntryTitleLabel)
                .addGap(34, 34, 34)
                .addGroup(gCalendarAddEntryJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addEntryTitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addEntryNameLabel))
                .addGap(18, 18, 18)
                .addGroup(gCalendarAddEntryJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addEntryDescriptionLabel)
                    .addComponent(addEntryDescriptionScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(gCalendarAddEntryJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addEntryStartTimeLabel)
					.addComponent(startTimeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startDateLabel)
                    .addComponent(startDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(addEntryStartTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(gCalendarAddEntryJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(endTimeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addEntryEndTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addEntryEndTimeLabel)
                    .addComponent(endDateLabel)
                    .addComponent(endDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(34, 34, 34)
                .addGroup(gCalendarAddEntryJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addEntryCancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addEntryAddButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        addUserStoryJFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addUserStoryJFrame.setTitle("Add User Story - ProjectTracker");
        addUserStoryJFrame.setAlwaysOnTop(true);
        addUserStoryJFrame.setBounds(new java.awt.Rectangle(50, 50, 350, 200));
        addUserStoryJFrame.setIconImage(new ImageIcon(getClass().getResource("/resources/icons/binoculars.png")).getImage());
        addUserStoryJFrame.setMinimumSize(new java.awt.Dimension(350, 200));
        addUserStoryJFrame.setName("Add Member"); // NOI18N

        jLabel7.setText("User Story Name:");

        jLabel8.setText("Milestone:");

        addUserStoryButton.setText("Add User Story");
        addUserStoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserStoryButtonActionPerformed(evt);
            }
        });

        userStoryMilestoneComboBox.setRenderer(new ListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = new JLabel();
                label.setOpaque(true);
                if (isSelected) {
                    label.setBackground(list.getSelectionBackground());
                    label.setForeground(list.getSelectionForeground());
                }
                else {
                    label.setBackground(list.getBackground());
                    label.setForeground(list.getForeground());
                }
                label.setText(((Milestone)value).getName());
                Border border = null;
                if (cellHasFocus) {
                    if (isSelected) {
                        border = UIManager.getBorder("List.focusSelectedCellHighlightBorder");
                    }
                    if (border == null) {
                        border = UIManager.getBorder("List.focusCellHighlightBorder");
                    }
                } else {
                    border = new EmptyBorder(1, 1, 1, 1);
                }
                label.setBorder(border);
                return label;
            }
        });
        userStoryMilestoneComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        addMilestoneButton.setText("+");
        addMilestoneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMilestoneButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addUserStoryJFrameLayout = new javax.swing.GroupLayout(addUserStoryJFrame.getContentPane());
        addUserStoryJFrame.getContentPane().setLayout(addUserStoryJFrameLayout);
        addUserStoryJFrameLayout.setHorizontalGroup(
            addUserStoryJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addUserStoryJFrameLayout.createSequentialGroup()
                .addGroup(addUserStoryJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addUserStoryJFrameLayout.createSequentialGroup()
                        .addGroup(addUserStoryJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addUserStoryJFrameLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7))
                            .addGroup(addUserStoryJFrameLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel8)))
                        .addGap(0, 244, Short.MAX_VALUE))
                    .addGroup(addUserStoryJFrameLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(addUserStoryJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addUserStoryJFrameLayout.createSequentialGroup()
                                .addComponent(userStoryMilestoneComboBox, 0, 282, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addMilestoneButton))
                            .addComponent(userStoryNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(addUserStoryJFrameLayout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(addUserStoryButton)
                .addContainerGap(131, Short.MAX_VALUE))
        );
        addUserStoryJFrameLayout.setVerticalGroup(
            addUserStoryJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addUserStoryJFrameLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userStoryNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addUserStoryJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userStoryMilestoneComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addMilestoneButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addUserStoryButton)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        togglFrame.setTitle("Toggl Login");
        togglFrame.setAlwaysOnTop(true);
        togglFrame.setMinimumSize(new java.awt.Dimension(473, 186));
        togglFrame.setResizable(false);

        togglLoginButton.setText("Login");
        togglLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                togglLoginButtonActionPerformed(evt);
            }
        });

        togglLoginLabel.setText("Login with your Toggl Email and Password");

        jLabel3.setText("Email");

        jLabel5.setText("Password");

        javax.swing.GroupLayout jTogglPanelLayout = new javax.swing.GroupLayout(jTogglPanel);
        jTogglPanel.setLayout(jTogglPanelLayout);
        jTogglPanelLayout.setHorizontalGroup(
            jTogglPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jTogglPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jTogglPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jTogglPanelLayout.createSequentialGroup()
                        .addGroup(jTogglPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(togglUserField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jTogglPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(togglPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jTogglPanelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(togglLoginLabel))
                    .addGroup(jTogglPanelLayout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(togglLoginButton)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jTogglPanelLayout.setVerticalGroup(
            jTogglPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jTogglPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(togglLoginLabel)
                .addGap(18, 18, 18)
                .addGroup(jTogglPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(6, 6, 6)
                .addGroup(jTogglPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(togglUserField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(togglPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(togglLoginButton)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout togglFrameLayout = new javax.swing.GroupLayout(togglFrame.getContentPane());
        togglFrame.getContentPane().setLayout(togglFrameLayout);
        togglFrameLayout.setHorizontalGroup(
            togglFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 473, Short.MAX_VALUE)
            .addGroup(togglFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(togglFrameLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTogglPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        togglFrameLayout.setVerticalGroup(
            togglFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 186, Short.MAX_VALUE)
            .addGroup(togglFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(togglFrameLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTogglPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

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
                "Username", "Phone", "Email", "Tasks"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
                    .addComponent(teamTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
                    .addGroup(teamPanelLayout.createSequentialGroup()
                        .addComponent(addMemberButton)
                        .addGap(18, 18, 18)
                        .addComponent(removeMemberButton)
                        .addGap(18, 18, 18)
                        .addComponent(editMemberButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 318, Short.MAX_VALUE)
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
                .addGap(17, 17, 17)
                .addComponent(teamTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE))
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
                "Lead", "User Story", "Task", "Status", "Estimated Duration", "Actual Duration"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tasksTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tasksTableMouseClicked(evt);
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

        jTogglTaskButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/toggl30.png"))); // NOI18N
        jTogglTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTogglTaskButtonActionPerformed(evt);
            }
        });

        togglTaskTextField.setEnabled(false);
        togglTaskTextField.setVisible(false);

        togglButton.setBackground(java.awt.Color.green);
        togglButton.setText("Start");
        togglButton.setEnabled(false);
        togglButton.setVisible(false);
        togglButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                togglButtonActionPerformed(evt);
            }
        });

        togglStatusTextBox.setText("Waiting...");
        togglStatusTextBox.setEnabled(false);
        togglStatusTextBox.setFocusable(false);
        togglStatusTextBox.setVisible(false);

        togglLabel.setText("Toggl Task:");
        togglLabel.setVisible(false);

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
                        .addGap(18, 18, 18)
                        .addComponent(jTogglTaskButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                        .addComponent(filterTasksButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tasksFilterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tasksTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
                    .addGroup(tasksPanelLayout.createSequentialGroup()
                        .addComponent(togglLabel)
                        .addGap(26, 26, 26)
                        .addComponent(togglTaskTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(togglButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(togglStatusTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        tasksPanelLayout.setVerticalGroup(
            tasksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tasksPanelLayout.createSequentialGroup()
                .addGroup(tasksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTogglTaskButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addTasksButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(removeTaskButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editTaskButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(filterTasksButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(tasksPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tasksFilterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tasksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(togglTaskTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(togglLabel)
                    .addComponent(togglButton)
                    .addComponent(togglStatusTextBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addComponent(tasksTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPane.addTab("", new javax.swing.ImageIcon(getClass().getResource("/resources/icons/tasks75.png")), tasksPanel, "Tasks"); // NOI18N

        gCalLoginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/cal75.png"))); // NOI18N
        gCalLoginButton.setText("Login ");
        gCalLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gCalLoginButtonActionPerformed(evt);
            }
        });

        calendarTextArea.setEditable(false);
        calendarTextArea.setColumns(20);
        calendarTextArea.setRows(5);
        calendarScrollPane.setViewportView(calendarTextArea);

        gCalLogoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/cal75.png"))); // NOI18N
        gCalLogoutButton.setText("Logout ");
        gCalLogoutButton.setEnabled(false);
        gCalLogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gCalLogoutButtonActionPerformed(evt);
            }
        });

        calTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        calTable.setEnabled(false);
        calTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calTableMouseClicked(evt);
            }
        });
        calTableScrollPane.setViewportView(calTable);

        calendarTableLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        calendarTableLabel.setText("Your Calendars");

        entryTableLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        entryTableLabel.setText("Upcoming Events");

        entryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        entryTable.setEnabled(false);
        entryTableScrollPane.setViewportView(entryTable);

        feedLabel.setFont(new java.awt.Font("DejaVu Sans", 1, 13));
        feedLabel.setText("Feed");

        createCalendarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/add30.png"))); // NOI18N
        createCalendarButton.setText("Create Calendar");
        createCalendarButton.setEnabled(false);
        createCalendarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createCalendarButtonActionPerformed(evt);
            }
        });

        removeCalendarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/delete30.png"))); // NOI18N
        removeCalendarButton.setText("Remove Calendar");
        removeCalendarButton.setEnabled(false);
        removeCalendarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCalendarButtonActionPerformed(evt);
            }
        });

        createEventButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/add30.png"))); // NOI18N
        createEventButton.setText("Create Event");
        createEventButton.setEnabled(false);
        createEventButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createEventButtonActionPerformed(evt);
            }
        });

        deleteEventButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/delete30.png"))); // NOI18N
        deleteEventButton.setText("Delete Event");
        deleteEventButton.setEnabled(false);
        deleteEventButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEventButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout calendarPanelLayout = new javax.swing.GroupLayout(calendarPanel);
        calendarPanel.setLayout(calendarPanelLayout);
        calendarPanelLayout.setHorizontalGroup(
            calendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calendarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(calendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(gCalLoginButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(calTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                    .addComponent(calendarTableLabel)
                    .addComponent(removeCalendarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(createCalendarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(calendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(gCalLogoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                    .addComponent(entryTableLabel)
                    .addComponent(entryTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                    .addComponent(createEventButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteEventButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addGroup(calendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(feedLabel)
                    .addComponent(calendarScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );
        calendarPanelLayout.setVerticalGroup(
            calendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calendarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(calendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gCalLoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gCalLogoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(calendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(createCalendarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(createEventButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addGroup(calendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteEventButton)
                    .addComponent(removeCalendarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(calendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(calendarTableLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(entryTableLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(feedLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(calendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(calendarScrollPane)
                    .addComponent(calTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(entryTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout schedulePanelLayout = new javax.swing.GroupLayout(schedulePanel);
        schedulePanel.setLayout(schedulePanelLayout);
        schedulePanelLayout.setHorizontalGroup(
            schedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(calendarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        schedulePanelLayout.setVerticalGroup(
            schedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(calendarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabbedPane.addTab("", new javax.swing.ImageIcon(getClass().getResource("/resources/icons/cal75.png")), schedulePanel, "Schedule"); // NOI18N

        javax.swing.GroupLayout progressPanelLayout = new javax.swing.GroupLayout(progressPanel);
        progressPanel.setLayout(progressPanelLayout);
        progressPanelLayout.setHorizontalGroup(
            progressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 805, Short.MAX_VALUE)
        );
        progressPanelLayout.setVerticalGroup(
            progressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        tabbedPane.addTab("", new javax.swing.ImageIcon(getClass().getResource("/resources/icons/graph75.png")), progressPanel, "Progress"); // NOI18N
        tabbedPane.addTab("", new javax.swing.ImageIcon(getClass().getResource("/resources/icons/giticon.png")), gitHubPanel1); // NOI18N
        tabbedPane.addTab("tab7", userStoryPanel1);

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//<editor-fold defaultstate="collapsed" desc=" Actions ">
    private void signOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signOutButtonActionPerformed
        clearAllFields();
        tabbedPane.setSelectedIndex(0);
        loginJFrame.setVisible(true);
    }//GEN-LAST:event_signOutButtonActionPerformed

    private void addMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMemberButtonActionPerformed
        addMemberUsernameTextField.setText("");
        try {
            String userString = JOptionPane.showInputDialog("Username of team member to add: ");
            if (!userString.isEmpty()) {
                if (engine.addMember(teamTable, userString)) {
                    JOptionPane.showMessageDialog(this,
                            userString + " has been added as a member of this team.",
                            "Success", JOptionPane.DEFAULT_OPTION);
                }
            } else {
                JOptionPane.showMessageDialog(this,
                        "Milestone name is required to create a new user story",
                        "Milestone Name Required", JOptionPane.DEFAULT_OPTION);
            }
        } catch (Exception e) {//do nothing if canceled
        }
        //addMemberJFrame.setVisible(true);
    }//GEN-LAST:event_addMemberButtonActionPerformed

    private void addTasksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTasksButtonActionPerformed
        engine.createProjectUsersComboBox(leadComboBox);
        engine.createProjectUserStoriesComboBox(newTaskUserStoryComboBox);
        addTasksTaskTextField.setText("");
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
        engine.updateChart(progressPanel, tasksTable);
        if (this.tabbedPane.getSelectedComponent().equals(userStoryPanel1)) {
            this.userStoryPanel1.updateComponents(false);
        }
    }//GEN-LAST:event_tabbedPaneMouseClicked

    private void addMemberDialogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMemberDialogButtonActionPerformed
        String userString = addMemberUsernameTextField.getText();
        if (engine.addMember(teamTable, userString)) {
            JOptionPane.showMessageDialog(this,
                    userString + " has been added as a member of this team.",
                    "Success", JOptionPane.DEFAULT_OPTION);
        } else {
        }
        addMemberJFrame.setVisible(false);
    }//GEN-LAST:event_addMemberDialogButtonActionPerformed

    private void saveEditMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveEditMemberButtonActionPerformed
//        DefaultTableModel model = (DefaultTableModel) teamTable.getModel();
//        model.setValueAt(editNameTextField.getText(), teamTable.getSelectedRow(), 0);
//        model.setValueAt(editPhoneTextField.getText(), teamTable.getSelectedRow(), 1);
//        model.setValueAt(editEmailTextField.getText(), teamTable.getSelectedRow(), 2);
        String name = editNameTextField.getText();
        String phone = editPhoneTextField.getText();
        String email = editEmailTextField.getText();
        engine.editUser(name, phone, email);
        engine.loadTeamTable(teamTable);
        editMemberJFrame.setVisible(false);
    }//GEN-LAST:event_saveEditMemberButtonActionPerformed

    private void editMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMemberButtonActionPerformed
        JTextField[] textFields = {editNameTextField, editPhoneTextField, editEmailTextField};
        if (engine.populateEditUserFields(teamTable, textFields)) {
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
            editingTask = engine.getTask(tasksTable.getValueAt(tasksTable.getSelectedRow(), 2).toString());
            engine.createProjectUsersComboBox(this.editTaskLeadComboBox, editingTask);
            engine.createProjectUserStoriesComboBox(editTaskUserStoryComboBox, editingTask);
            editTasksTaskTextField.setText(editingTask.getName());
            engine.populateStatusComboBox(this.editTaskStatusComboBox, editingTask);
            editTasksEstimatedTextField.setText(Double.toString(editingTask.getTimeEstimate()));
            editTasksActualTextField.setText(Double.toString(editingTask.getTimeActual()));
            editTasksJFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this,
                    "No Task Selected",
                    "No Task Selected", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_editTaskButtonActionPerformed

    private void addTasksDialogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTasksDialogButtonActionPerformed
        try {
            DefaultTableModel model = (DefaultTableModel) tasksTable.getModel();
            model.addRow(engine.getNewTaskRow(((User) leadComboBox.getSelectedItem()), (UserStory) newTaskUserStoryComboBox.getSelectedItem(), addTasksTaskTextField.getText(), addTasksEstimatedTextField.getText(), addTasksActualTextField.getText()));//new Object[]{addTasksLeadTextField.getText(), });
            addTasksJFrame.setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "One or more fields have an invalid entry",
                    "Invalid Entry", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_addTasksDialogButtonActionPerformed

    private void editTasksDialogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTasksDialogButtonActionPerformed
        try {
            DefaultTableModel model = (DefaultTableModel) tasksTable.getModel();
            User u = (User) this.editTaskLeadComboBox.getSelectedItem();
            UserStory us = (UserStory) this.editTaskUserStoryComboBox.getSelectedItem();
            String name = this.editTasksTaskTextField.getText();
            Status.States state = (Status.States) this.editTaskStatusComboBox.getSelectedItem();
            double est = Double.parseDouble(this.editTasksEstimatedTextField.getText());
            double actual = Double.parseDouble(this.editTasksActualTextField.getText());
            engine.editTask(editingTask, name, u, us, state, est, actual);
            engine.loadTasksTable(tasksTable);
            editTasksJFrame.setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "One or more fields have an invalid entry",
                    "Invalid Entry", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_editTasksDialogButtonActionPerformed

    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
        JOptionPane.showMessageDialog(this,
                "ProjectTracker is an open source project of six GVSU students for CIS 467\n"
                + "Please direct comments and suggestions to ProjectTrackerApp@gmail.com\n"
                + "Credits:\n"
                + "Eric Ashley - Graphical User Interface and Graph integration\n"
                + "Cam Warner - Client/Server backend and Toggl integration\n"
                + "Thomas Rankin - Testing and documentation\n"
                + "Mike Vokes - Google Calendar integration\n"
                + "Zach Burnside - Object Oriented Database and GitHub Integration\n"
                + "Eric Munson - Android GUI port",
                "About ProjectTracker", JOptionPane.DEFAULT_OPTION);
    }//GEN-LAST:event_aboutButtonActionPerformed

    private void newProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProjectButtonActionPerformed
        try {
            String projectTitle = JOptionPane.showInputDialog("Project Title");
            if (!projectTitle.isEmpty()) {
                Project newProj = engine.createProject(projectTitle);
                projectComboBox.addItem(newProj);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Project title is required to create a new project",
                        "Title Required", JOptionPane.DEFAULT_OPTION);
                newProjectButtonActionPerformed(evt);
            }
        } catch (Exception e) {//do nothing if canceled
        }
    }//GEN-LAST:event_newProjectButtonActionPerformed

    private void editProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProjectButtonActionPerformed
         try {
            String editedProjectName = JOptionPane.showInputDialog("Project Title");
            if (!editedProjectName.isEmpty()) {
                engine.processProjectNameChanged(projectComboBox, editedProjectName);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Project title is required",
                        "Title Required", JOptionPane.DEFAULT_OPTION);
                editProjectButtonActionPerformed(evt);
            }
        } catch (Exception e) {//do nothing if canceled
        }
    }//GEN-LAST:event_editProjectButtonActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        if (!this.usernameTextField.getText().isEmpty()
                && engine.validCredentials(this.usernameTextField.getText(), String.copyValueOf(this.passwordTextField.getPassword()))) {
            if (engine.userHasTeam()) {
                loginJFrame.setVisible(false);
                this.engine.populateProjectComboBox(this.projectComboBox);
                //this.setExtendedState(6); //maximises the screen by default when loggin in.
                this.setVisible(true);
            } else {
                noTeamJFrame.setVisible(true);
            }
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
        engine.updateChart(progressPanel, tasksTable);
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
            engine.setSeletedProj((Project) this.projectComboBox.getSelectedItem());
            engine.loadTeamTable(teamTable);
            engine.loadTasksTable(tasksTable);
            this.userStoryPanel1.updateComponents(true);

        }
    }//GEN-LAST:event_projectComboBoxItemStateChanged

    private void createUserDialogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserDialogButtonActionPerformed
        JTextField[] textFields = {createUserUsernameTextField,
            firstPasswordField,
            confirmPasswordField,
            createUserNameTextField,
            createUserPhoneTextField,
            createUserEmailTextField};
        if (engine.createUser(textFields)) {
            JOptionPane.showMessageDialog(this,
                    "User \"" + createUserUsernameTextField.getText() + "\" has been created",
                    "User Created", JOptionPane.DEFAULT_OPTION);
        } else {
            JOptionPane.showMessageDialog(this,
                    "User \"" + createUserUsernameTextField.getText() + "\" is invalid or already taken",
                    "User Creation Failure", JOptionPane.DEFAULT_OPTION);
        }
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
        if (teamTable.getSelectedColumn() == 3) { //last column
            this.filterTasks(teamTable.getValueAt(teamTable.getSelectedRow(), 0).toString());
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

    private void gCalLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gCalLoginButtonActionPerformed
        gCalendarLoginJFrame.setVisible(true);
        gCalUserNameTextField.setText("");
        gCalPasswordField.setText("");
    }//GEN-LAST:event_gCalLoginButtonActionPerformed

    private void gCalLoginScreenCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gCalLoginScreenCancelButtonActionPerformed
        gCalendarLoginJFrame.setVisible(false);
        gCalUserNameTextField.setText("");
        gCalPasswordField.setText("");
    }//GEN-LAST:event_gCalLoginScreenCancelButtonActionPerformed

    private void gCalLoginScreenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gCalLoginScreenButtonActionPerformed
        if (engine.calendarLogin(gCalUserNameTextField.getText(), new String(gCalPasswordField.getPassword()))) {
            calendarTextArea.setText("Login Successful...\n");
            createCalendarButton.setEnabled(true);
            removeCalendarButton.setEnabled(true);
            createEventButton.setEnabled(true);
            deleteEventButton.setEnabled(true);
            gCalLogoutButton.setEnabled(true);
            calTable.setEnabled(true);
            engine.loadCalendarTable(calTable);
            calTable.getTableHeader().setReorderingAllowed(false);
            entryTable.setEnabled(true);
            entryTable.getTableHeader().setReorderingAllowed(false);
        } else {
            calendarTextArea.setText("Login Failed... Try Again\n");
        }

        gCalendarLoginJFrame.setVisible(false);
        gCalUserNameTextField.setText("");
        gCalPasswordField.setText("");
    }//GEN-LAST:event_gCalLoginScreenButtonActionPerformed

    private void gCalLogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gCalLogoutButtonActionPerformed
        createCalendarButton.setEnabled(false);
        removeCalendarButton.setEnabled(false);
        createEventButton.setEnabled(false);
        deleteEventButton.setEnabled(false);
        gCalLogoutButton.setEnabled(false);
        calTable.setEnabled(false);
        entryTable.setEnabled(false);
        calendarTextArea.setText("");
    }//GEN-LAST:event_gCalLogoutButtonActionPerformed

    private void gCalAddCalendarCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gCalAddCalendarCancelButtonActionPerformed
        gCalendarAddCalendarJFrame.setVisible(false);
        gCalCalendarTitleTextField.setText("");
        gCalCalendarDescriptionTextArea.setText("");
        gCalLocationTextField.setText("");
    }//GEN-LAST:event_gCalAddCalendarCancelButtonActionPerformed

    private void gCalAddCalendarDoneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gCalAddCalendarDoneButtonActionPerformed
        if (gCalCalendarTitleTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter a title.");
        } else if (gCalCalendarDescriptionTextArea.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter a description.");
        } else if (gCalLocationTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter a location.");
        } else {
            if (engine.createNewCalendar(gCalCalendarTitleTextField.getText(),
                    gCalCalendarDescriptionTextArea.getText(),
                    gCalLocationTextField.getText())) {
                calendarTextArea.setText("Calendar "
                        + gCalCalendarTitleTextField.getText() + " created...\n\n");
                gCalendarAddCalendarJFrame.setVisible(false);
                gCalCalendarTitleTextField.setText("");
                gCalCalendarDescriptionTextArea.setText("");
                gCalLocationTextField.setText("");
                engine.loadCalendarTable(calTable);
            } else {
                calendarTextArea.setText("Failed to create a new calendar...\n\n");
                gCalendarAddCalendarJFrame.setVisible(false);
                gCalCalendarTitleTextField.setText("");
                gCalCalendarDescriptionTextArea.setText("");
                gCalLocationTextField.setText("");
            }
        }
    }//GEN-LAST:event_gCalAddCalendarDoneButtonActionPerformed

    private void calTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calTableMouseClicked
        String name = calTable.getModel().getValueAt(calTable.getSelectedRow(), 0).toString();
        engine.loadCalendarEntryTable(entryTable, name);
    }//GEN-LAST:event_calTableMouseClicked

    private void createCalendarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createCalendarButtonActionPerformed
        gCalendarAddCalendarJFrame.setVisible(true);
        gCalCalendarTitleTextField.setText("");
        gCalCalendarDescriptionTextArea.setText("");
        gCalLocationTextField.setText("");
    }//GEN-LAST:event_createCalendarButtonActionPerformed

    private void removeCalendarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCalendarButtonActionPerformed

        if (calTable.isColumnSelected(0)) {
            String name = calTable.getModel().getValueAt(calTable.getSelectedRow(), 0).toString();
            if (engine.deleteCalendar(name)) {
                engine.loadCalendarTable(calTable);
                calendarTextArea.setText("Calendar " + name + " was Deleted...\n\n");
            } else {
                calendarTextArea.setText("Unable to delete...\n\n");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No Calendar Selected.");
        }
    }//GEN-LAST:event_removeCalendarButtonActionPerformed

    private void noTeamCreateNewTeamJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noTeamCreateNewTeamJButtonActionPerformed
        newTeamNameTextField.setText("");
        newTeamPasswordField.setText("");
        newTeamConfirmPasswordField.setText("");
        createNewTeamJFrame.setVisible(true);
    }//GEN-LAST:event_noTeamCreateNewTeamJButtonActionPerformed

    private void noTeamJoinExistingTeamJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noTeamJoinExistingTeamJButtonActionPerformed
        engine.createTeamComboBox(joinExistingComboBox);//.setModel(new javax.swing.DefaultComboBoxModel(engine.createTeamComboBox()));
        //joinExistingComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Team1" }));
        joinExistingTeamJFrame.setVisible(true);
    }//GEN-LAST:event_noTeamJoinExistingTeamJButtonActionPerformed

    private void joinExistingTeamJoinJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinExistingTeamJoinJButtonActionPerformed
        Team team = (Team) joinExistingComboBox.getSelectedItem();
        if (team.validatePassword(String.copyValueOf(this.joinTeamPasswordField.getPassword()))) {
            engine.addUserToTeam(team);
            noTeamJFrame.setVisible(false);
            joinExistingTeamJFrame.setVisible(false);
            loginButtonActionPerformed(evt);
        } else {
            joinExistingTeamJFrame.setVisible(false);
            JOptionPane.showMessageDialog(this,
                    "Invalid password, please try again.",
                    "Invalid Password", JOptionPane.DEFAULT_OPTION);
            joinExistingTeamJFrame.setVisible(true);
        }
    }//GEN-LAST:event_joinExistingTeamJoinJButtonActionPerformed

    private void createNewTeamButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNewTeamButtonActionPerformed
        String teamName = newTeamNameTextField.getText();
        String password = String.copyValueOf(newTeamPasswordField.getPassword());
        String confirmPass = String.copyValueOf(newTeamConfirmPasswordField.getPassword());
        if (password.equals(confirmPass)) {
            Team newTeam = engine.createTeam(teamName, password);
            engine.addUserToTeam(newTeam);
            createNewTeamJFrame.setVisible(false);
            this.noTeamJFrame.setVisible(false);
            loginButtonActionPerformed(evt);
        }
    }//GEN-LAST:event_createNewTeamButtonActionPerformed

    private void addEntryCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEntryCancelButtonActionPerformed
        gCalendarAddEntryJFrame.setVisible(false);
        addEntryTitleTextField.setText("");
        addEntryDescriptionTextArea.setText("");
        addEntryStartTimeTextField.setText("12:00");
        addEntryEndTimeTextField.setText("1:00");
    }//GEN-LAST:event_addEntryCancelButtonActionPerformed

    private void addEntryAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEntryAddButtonActionPerformed
        if (addEntryTitleTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter a title.");
        } else if (addEntryDescriptionTextArea.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter a description.");
        } else if (addEntryStartTimeTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter a starting time.");
        } else if (addEntryEndTimeTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter a ending time.");
        } else {
            String name = calTable.getModel().getValueAt(calTable.getSelectedRow(), 0).toString();
            if (engine.addNewEntry(name, addEntryTitleTextField.getText(), addEntryDescriptionTextArea.getText(),
                    startDateTextField.getText(), endDateTextField.getText(),
                    addEntryStartTimeTextField.getText() + " " + startTimeComboBox.getSelectedItem(), 
                    addEntryEndTimeTextField.getText() + " " + endTimeComboBox.getSelectedItem())) {
                calendarTextArea.setText("Entry: "
                        + addEntryTitleTextField.getText() + " was created\nin calendar: "
                        + name + "\n\n");
                gCalendarAddEntryJFrame.setVisible(false);
                addEntryTitleTextField.setText("");
                addEntryDescriptionTextArea.setText("");
                addEntryStartTimeTextField.setText("12:00");
                addEntryEndTimeTextField.setText("1:00");
                engine.loadCalendarEntryTable(entryTable, name);
            } else {
                calendarTextArea.setText("Failed to create entry...\n\n");
                gCalendarAddEntryJFrame.setVisible(false);
                addEntryTitleTextField.setText("");
                addEntryDescriptionTextArea.setText("");
                addEntryStartTimeTextField.setText("");
                addEntryEndTimeTextField.setText("");
            }
        }
    }//GEN-LAST:event_addEntryAddButtonActionPerformed

    private void togglButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_togglButtonActionPerformed
        String command = evt.getActionCommand();
        JToggleButton button = (JToggleButton) evt.getSource();
        if (command.equals("Start")) {
            this.togglHelper.startNewTimeEntry(this.togglTaskTextField.getText());
            button.setText("Stop");
            button.setBackground(Color.red);
        } else if (command.equals("Stop")) {
            button.setText("Start");
            String response = this.togglHelper.endNewTimeEntry();
            togglStatusTextBox.setText(response);
            button.setBackground(Color.green);
        }
    }//GEN-LAST:event_togglButtonActionPerformed

    private void togglLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_togglLoginButtonActionPerformed
        try {
            togglHelper = new JTogglHelper(this.togglUserField.getText(), String.copyValueOf(this.togglPasswordField.getPassword()));

            this.togglButton.setEnabled(true);
            this.togglStatusTextBox.setEnabled(true);
            this.togglTaskTextField.setEnabled(true);
            this.togglLabel.setEnabled(true);
            this.togglButton.setVisible(true);
            this.togglStatusTextBox.setVisible(true);
            this.togglTaskTextField.setVisible(true);
            this.togglLabel.setVisible(true);
            JOptionPane.showMessageDialog(this,
                    "Successfully logged in as " + this.togglHelper.getFullName(),
                    "Success!", JOptionPane.DEFAULT_OPTION);
            this.togglFrame.setVisible(false);
        } catch (Exception e) {
            this.togglFrame.setVisible(false);
            JOptionPane.showMessageDialog(this,
                    "Please check your username and password",
                    "Unable to login to Toggl", JOptionPane.DEFAULT_OPTION);
            this.togglFrame.setVisible(true);
        }
    }//GEN-LAST:event_togglLoginButtonActionPerformed

    private void newUserStoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newUserStoryButtonActionPerformed
        userStoryNameTextField.setText("");
        engine.populateMilestoneComboBox(this.userStoryMilestoneComboBox);
        addUserStoryJFrame.setVisible(true);
//        try {
//            String userStoryName = JOptionPane.showInputDialog("New User Story Name: ");
//            if (!userStoryName.isEmpty()) {
//                UserStory userStory = engine.createNewUserStory(userStoryName);
//                newTaskUserStoryComboBox.addItem(userStory);
//            } else {
//                JOptionPane.showMessageDialog(this,
//                        "User story name is required to create a new user story",
//                        "User Story Name Required", JOptionPane.DEFAULT_OPTION);
//            }
//        } catch (Exception e) {//do nothing if canceled
//        }
    }//GEN-LAST:event_newUserStoryButtonActionPerformed

    private void createEventButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createEventButtonActionPerformed
        if (calTable.isColumnSelected(0)) {
			gCalendarAddEntryJFrame.setVisible(true);
			addEntryTitleTextField.setText("");
			addEntryDescriptionTextArea.setText("");
			addEntryStartTimeTextField.setText("");
			addEntryEndTimeTextField.setText("");
		}
    }//GEN-LAST:event_createEventButtonActionPerformed

    private void deleteEventButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEventButtonActionPerformed
        if (entryTable.isColumnSelected(0) && calTable.isColumnSelected(0)) {
            String entryName = entryTable.getModel().getValueAt(entryTable.getSelectedRow(), 0).toString();
            String calName = calTable.getModel().getValueAt(calTable.getSelectedRow(), 0).toString();
            if (engine.deleteEntry(calName, entryName)) {
                engine.loadCalendarEntryTable(entryTable, calName);
                calendarTextArea.setText("Entry " + entryName + " was Deleted...\n\n");
            } else {
                calendarTextArea.setText("Unable to delete...\n\n");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nothing Selected.");
        }
    }//GEN-LAST:event_deleteEventButtonActionPerformed

    private void addUserStoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserStoryButtonActionPerformed
        String userStoryName = userStoryNameTextField.getText();
        Milestone milestone = (Milestone) userStoryMilestoneComboBox.getSelectedItem();
        UserStory us = engine.createNewUserStory(userStoryName, milestone);
        if (us != null) {
            engine.createProjectUserStoriesComboBox(this.newTaskUserStoryComboBox);
        } else {
            JOptionPane.showMessageDialog(this,
                    "User story name is invalid or already taken",
                    "Input Error", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_addUserStoryButtonActionPerformed

    private void addMilestoneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMilestoneButtonActionPerformed
        try {
            String milestoneString = JOptionPane.showInputDialog("Name of new milestone: ");
            if (!milestoneString.isEmpty()) {
                Milestone ms = engine.createMilestone(milestoneString);
                if (ms != null) {
                    engine.populateMilestoneComboBox(userStoryMilestoneComboBox);
                    JOptionPane.showMessageDialog(this,
                            milestoneString + " has been added to the project",
                            "Success", JOptionPane.DEFAULT_OPTION);
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Milestone name is already taken or is invalid",
                            "Milestone Name Taken or Invalid", JOptionPane.DEFAULT_OPTION);
                }
            } else {
                JOptionPane.showMessageDialog(this,
                        "Milestone name is required",
                        "Milestone Name Required", JOptionPane.DEFAULT_OPTION);
            }
        } catch (Exception e) {//do nothing if canceled
        }
    }//GEN-LAST:event_addMilestoneButtonActionPerformed

    private void tasksTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tasksTableMouseClicked
        if (evt.getClickCount() == 2) {//populates a task in toggl if it is double clicked
            jTogglTaskButtonActionPerformed(null);
        }
    }//GEN-LAST:event_tasksTableMouseClicked

    private void jTogglTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTogglTaskButtonActionPerformed
        int index = tasksTable.getSelectedRow();
        if (this.togglHelper == null || !this.togglHelper.isLoggedIn()) {
            this.togglFrame.setVisible(true);
            this.togglFrame.setAlwaysOnTop(true);
        }
        if (index != -1) {
            Task task = engine.getTask(tasksTable.getValueAt(index, 2).toString());
            this.togglTaskTextField.setText(task.getName());
        } else {
            //TODO: maybe throw error box
        }
    }//GEN-LAST:event_jTogglTaskButtonActionPerformed

    private void passwordTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordTextFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            loginButton.doClick();
        }
    }//GEN-LAST:event_passwordTextFieldKeyPressed

    private void editServerAddrButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editServerAddrButtonActionPerformed
        mainView.noAddressFound();
    }//GEN-LAST:event_editServerAddrButtonActionPerformed
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
        
            Thread.setDefaultUncaughtExceptionHandler(new CollabExceptionHandler());
            System.setProperty( "sun.awt.exception.handler",CollabExceptionHandler.class.getName());
            java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                if(!mainEngine.loadServerAddr()){
                    mainView.noAddressFound();
                };
                new mainView().loginJFrame.setVisible(true);
            }
        });
    }
    //</editor-fold>
//<editor-fold defaultstate="collapsed" desc=" Variable declarations ">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aboutButton;
    private javax.swing.JButton addEntryAddButton;
    private javax.swing.JButton addEntryCancelButton;
    private javax.swing.JLabel addEntryDescriptionLabel;
    private javax.swing.JScrollPane addEntryDescriptionScrollPane;
    private javax.swing.JTextArea addEntryDescriptionTextArea;
    private javax.swing.JLabel addEntryEndTimeLabel;
    private javax.swing.JTextField addEntryEndTimeTextField;
    private javax.swing.JLabel addEntryNameLabel;
    private javax.swing.JLabel addEntryStartTimeLabel;
    private javax.swing.JTextField addEntryStartTimeTextField;
    private javax.swing.JLabel addEntryTitleLabel;
    private javax.swing.JTextField addEntryTitleTextField;
    private javax.swing.JButton addMemberButton;
    private javax.swing.JButton addMemberDialogButton;
    private javax.swing.JFrame addMemberJFrame;
    private javax.swing.JPanel addMemberJPanel;
    private javax.swing.JLabel addMemberNameJLabel;
    private javax.swing.JTextField addMemberUsernameTextField;
    private javax.swing.JButton addMilestoneButton;
    private javax.swing.JTextField addTasksActualTextField;
    private javax.swing.JButton addTasksButton;
    private javax.swing.JButton addTasksDialogButton;
    private javax.swing.JLabel addTasksEstimatedJLabel;
    private javax.swing.JTextField addTasksEstimatedTextField;
    private javax.swing.JFrame addTasksJFrame;
    private javax.swing.JLabel addTasksLeadJLabel;
    private javax.swing.JLabel addTasksStatusJLabel;
    private javax.swing.JLabel addTasksTaskJLabel;
    private javax.swing.JTextField addTasksTaskTextField;
    private javax.swing.JLabel addTasksUserStoryJLabel;
    private javax.swing.JButton addUserStoryButton;
    private javax.swing.JFrame addUserStoryJFrame;
    private javax.swing.JTable calTable;
    private javax.swing.JScrollPane calTableScrollPane;
    private javax.swing.JPanel calendarPanel;
    private javax.swing.JScrollPane calendarScrollPane;
    private javax.swing.JLabel calendarTableLabel;
    private javax.swing.JTextArea calendarTextArea;
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JButton createCalendarButton;
    private javax.swing.JButton createEventButton;
    private javax.swing.JButton createNewTeamButton;
    private javax.swing.JFrame createNewTeamJFrame;
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
    private javax.swing.JButton deleteEventButton;
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
    private javax.swing.JButton editServerAddrButton;
    private javax.swing.JButton editTaskButton;
    private javax.swing.JComboBox editTaskLeadComboBox;
    private javax.swing.JComboBox editTaskStatusComboBox;
    private javax.swing.JComboBox editTaskUserStoryComboBox;
    private javax.swing.JLabel editTasksActualJLabel;
    private javax.swing.JTextField editTasksActualTextField;
    private javax.swing.JButton editTasksDialogButton;
    private javax.swing.JLabel editTasksEstimatedJLabel;
    private javax.swing.JTextField editTasksEstimatedTextField;
    private javax.swing.JFrame editTasksJFrame;
    private javax.swing.JPanel editTasksJPanel;
    private javax.swing.JLabel editTasksLeadJLabel;
    private javax.swing.JLabel editTasksStatusJLabel;
    private javax.swing.JLabel editTasksTaskJLabel;
    private javax.swing.JTextField editTasksTaskTextField;
    private javax.swing.JLabel editTasksUserStoryJLabel;
    private javax.swing.JLabel endDateLabel;
    private javax.swing.JTextField endDateTextField;
    private javax.swing.JComboBox endTimeComboBox;
    private javax.swing.JTable entryTable;
    private javax.swing.JLabel entryTableLabel;
    private javax.swing.JScrollPane entryTableScrollPane;
    private javax.swing.JLabel feedLabel;
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
    private javax.swing.JButton gCalAddCalendarCancelButton;
    private javax.swing.JButton gCalAddCalendarDoneButton;
    private javax.swing.JLabel gCalAddCalendarTitleLabel;
    private javax.swing.JLabel gCalCalendarDescriptionLabel;
    private javax.swing.JTextArea gCalCalendarDescriptionTextArea;
    private javax.swing.JLabel gCalCalendarLocationLabel;
    private javax.swing.JLabel gCalCalendarTitleLabel;
    private javax.swing.JTextField gCalCalendarTitleTextField;
    private javax.swing.JTextField gCalLocationTextField;
    private javax.swing.JButton gCalLoginButton;
    private javax.swing.JLabel gCalLoginCommandLabel;
    private javax.swing.JButton gCalLoginScreenButton;
    private javax.swing.JButton gCalLoginScreenCancelButton;
    private javax.swing.JButton gCalLogoutButton;
    private javax.swing.JPasswordField gCalPasswordField;
    private javax.swing.JLabel gCalPasswordLabel;
    private javax.swing.JLabel gCalUserNameLabel;
    private javax.swing.JTextField gCalUserNameTextField;
    private javax.swing.JFrame gCalendarAddCalendarJFrame;
    private javax.swing.JPanel gCalendarAddCalendarPanel;
    private javax.swing.JFrame gCalendarAddEntryJFrame;
    private javax.swing.JFrame gCalendarLoginJFrame;
    private javax.swing.JPanel gCalendarLoginPanel;
    private collaboration.GitHubPanel gitHubPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel jTogglPanel;
    private javax.swing.JButton jTogglTaskButton;
    private javax.swing.JComboBox joinExistingComboBox;
    private javax.swing.JFrame joinExistingTeamJFrame;
    private javax.swing.JButton joinExistingTeamJoinJButton;
    private javax.swing.JPasswordField joinTeamPasswordField;
    private javax.swing.JComboBox leadComboBox;
    private javax.swing.JButton loginButton;
    private javax.swing.JFrame loginJFrame;
    private javax.swing.JPanel loginJPanel;
    private javax.swing.JPanel loginJPanel1;
    private javax.swing.JButton newProjectButton;
    private javax.swing.JComboBox newTaskUserStoryComboBox;
    private javax.swing.JPasswordField newTeamConfirmPasswordField;
    private javax.swing.JTextField newTeamNameTextField;
    private javax.swing.JPasswordField newTeamPasswordField;
    private javax.swing.JButton newUserStoryButton;
    private javax.swing.JButton noTeamCreateNewTeamJButton;
    private javax.swing.JFrame noTeamJFrame;
    private javax.swing.JButton noTeamJoinExistingTeamJButton;
    private javax.swing.JLabel passwordJLabel;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JPanel progressPanel;
    private javax.swing.JComboBox projectComboBox;
    private javax.swing.JButton removeCalendarButton;
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
    private javax.swing.JLabel startDateLabel;
    private javax.swing.JTextField startDateTextField;
    private javax.swing.JComboBox startTimeComboBox;
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
    private javax.swing.JToggleButton togglButton;
    private javax.swing.JFrame togglFrame;
    private javax.swing.JLabel togglLabel;
    private javax.swing.JButton togglLoginButton;
    private javax.swing.JLabel togglLoginLabel;
    private javax.swing.JPasswordField togglPasswordField;
    private javax.swing.JLabel togglStatusTextBox;
    private javax.swing.JTextField togglTaskTextField;
    private javax.swing.JTextField togglUserField;
    private javax.swing.JComboBox userStoryMilestoneComboBox;
    private javax.swing.JTextField userStoryNameTextField;
    private collaboration.UserStoryPanel userStoryPanel1;
    private javax.swing.JLabel usernameJLabel;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
//</editor-fold>