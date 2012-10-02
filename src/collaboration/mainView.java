//<editor-fold defaultstate="collapsed" desc=" Imports and package ">
package collaboration;

import com.alee.laf.WebLookAndFeel;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Window;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultRowSorter;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.jfree.chart.ChartPanel;

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

    private void addTitleBar(JFrame frame) {
        frame.setShape(null);
        frame.dispose();
        frame.setUndecorated(false);
        frame.pack();
    }

    private void removeTitleBar(JFrame frame) {
        frame.dispose();
        frame.setUndecorated(true);
        frame.pack();
    }

    private void updateLookAndFeel(String pLookAndFeel) {
        try {
            if (pLookAndFeel.equals("System")) {
                addTitleBar(this);
                addTitleBar(addMemberJFrame);
                addTitleBar(editMemberJFrame);
                addTitleBar(addTasksJFrame);
                addTitleBar(editTasksJFrame);
                addTitleBar(settingsJFrame);
                addTitleBar(loginJFrame);
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } else if (pLookAndFeel.equals("Dark")) {
                removeTitleBar(this);
                removeTitleBar(addMemberJFrame);
                removeTitleBar(editMemberJFrame);
                removeTitleBar(addTasksJFrame);
                removeTitleBar(editTasksJFrame);
                removeTitleBar(settingsJFrame);
                removeTitleBar(loginJFrame);
                setDefaultLookAndFeelDecorated(true);
                UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
//            } else if (pLookAndFeel.equals("Light")) {
//                addTitleBar(this);
//                addTitleBar(addMemberJFrame);
//                addTitleBar(editMemberJFrame);
//                addTitleBar(addTasksJFrame);
//                addTitleBar(editTasksJFrame);
//                addTitleBar(settingsJFrame);
//                addTitleBar(loginJFrame);
//                WebLookAndFeel.install();
            } else {
                removeTitleBar(this);
                removeTitleBar(addMemberJFrame);
                removeTitleBar(editMemberJFrame);
                removeTitleBar(addTasksJFrame);
                removeTitleBar(editTasksJFrame);
                removeTitleBar(settingsJFrame);
                removeTitleBar(loginJFrame);
                UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
            }
            SwingUtilities.updateComponentTreeUI(this);
            SwingUtilities.updateComponentTreeUI(addMemberJFrame);
            SwingUtilities.updateComponentTreeUI(editMemberJFrame);
            SwingUtilities.updateComponentTreeUI(addTasksJFrame);
            SwingUtilities.updateComponentTreeUI(editTasksJFrame);
            SwingUtilities.updateComponentTreeUI(editProjectJFrame);
            SwingUtilities.updateComponentTreeUI(settingsJFrame);
            SwingUtilities.updateComponentTreeUI(loginJFrame);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
//</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMemberJFrame = new javax.swing.JFrame();
        addMemberJPanel = new javax.swing.JPanel();
        addMemberDialogButton = new javax.swing.JButton();
        addMemberNameJLabel = new javax.swing.JLabel();
        addMemberPhoneJLabel = new javax.swing.JLabel();
        addMemberEmailJLabel = new javax.swing.JLabel();
        addMemberNameTextField = new javax.swing.JTextField();
        addMemberPhoneTextField = new javax.swing.JTextField();
        addMemberEmailTextField = new javax.swing.JTextField();
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
        settingsJFrame = new javax.swing.JFrame();
        loginJPanel1 = new javax.swing.JPanel();
        saveSettingsButton = new javax.swing.JButton();
        spaceJlabel1 = new javax.swing.JLabel();
        themeComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
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
        teamFilterButton = new javax.swing.JButton();
        teamFilterTextField = new javax.swing.JTextField();
        tasksPanel = new javax.swing.JPanel();
        addTasksButton = new javax.swing.JButton();
        removeTaskButton = new javax.swing.JButton();
        editTaskButton = new javax.swing.JButton();
        tasksFilterTextField = new javax.swing.JTextField();
        tasksFilterButton = new javax.swing.JButton();
        tasksTableScrollPane = new javax.swing.JScrollPane();
        tasksTable = new javax.swing.JTable();
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
        addMemberJFrame.setMinimumSize(new java.awt.Dimension(400, 200));
        addMemberJFrame.setName("Add Member"); // NOI18N

        addMemberJPanel.setMaximumSize(new java.awt.Dimension(400, 200));
        addMemberJPanel.setMinimumSize(new java.awt.Dimension(400, 200));
        addMemberJPanel.setPreferredSize(new java.awt.Dimension(400, 200));

        addMemberDialogButton.setText("Add Member");
        addMemberDialogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMemberDialogButtonActionPerformed(evt);
            }
        });

        addMemberNameJLabel.setText("Name");

        addMemberPhoneJLabel.setText("Phone");

        addMemberEmailJLabel.setText("Email");

        javax.swing.GroupLayout addMemberJPanelLayout = new javax.swing.GroupLayout(addMemberJPanel);
        addMemberJPanel.setLayout(addMemberJPanelLayout);
        addMemberJPanelLayout.setHorizontalGroup(
            addMemberJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addMemberJPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(addMemberJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addMemberJPanelLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(addMemberDialogButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addMemberJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addMemberJPanelLayout.createSequentialGroup()
                            .addComponent(addMemberNameJLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addMemberNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addMemberJPanelLayout.createSequentialGroup()
                            .addComponent(addMemberPhoneJLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addMemberPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addMemberJPanelLayout.createSequentialGroup()
                            .addComponent(addMemberEmailJLabel)
                            .addGap(32, 32, 32)
                            .addComponent(addMemberEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 37, Short.MAX_VALUE))
        );
        addMemberJPanelLayout.setVerticalGroup(
            addMemberJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addMemberJPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(addMemberJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addMemberNameJLabel)
                    .addComponent(addMemberNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addMemberJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addMemberPhoneJLabel)
                    .addComponent(addMemberPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(addMemberJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addMemberEmailJLabel)
                    .addComponent(addMemberEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addMemberDialogButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout addMemberJFrameLayout = new javax.swing.GroupLayout(addMemberJFrame.getContentPane());
        addMemberJFrame.getContentPane().setLayout(addMemberJFrameLayout);
        addMemberJFrameLayout.setHorizontalGroup(
            addMemberJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addMemberJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        addMemberJFrameLayout.setVerticalGroup(
            addMemberJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addMemberJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 189, Short.MAX_VALUE)
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
        editProjectJFrame.setMinimumSize(new java.awt.Dimension(230, 104));
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
        loginJFrame.setMinimumSize(new java.awt.Dimension(400, 300));
        loginJFrame.setResizable(false);
        loginJFrame.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                loginJFrameComponentShown(evt);
            }
        });

        usernameJLabel.setText("Username:");

        passwordJLabel.setText("Password:");

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        spaceJlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/ProjectTracker.png"))); // NOI18N

        javax.swing.GroupLayout loginJPanelLayout = new javax.swing.GroupLayout(loginJPanel);
        loginJPanel.setLayout(loginJPanelLayout);
        loginJPanelLayout.setHorizontalGroup(
            loginJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginJPanelLayout.createSequentialGroup()
                .addGroup(loginJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginJPanelLayout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(loginButton))
                    .addGroup(loginJPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(loginJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(loginJPanelLayout.createSequentialGroup()
                                .addComponent(passwordJLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(loginJPanelLayout.createSequentialGroup()
                                .addComponent(usernameJLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginJPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(spaceJlabel)
                .addGap(52, 52, 52))
        );
        loginJPanelLayout.setVerticalGroup(
            loginJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginJPanelLayout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(spaceJlabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(loginJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameJLabel)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(loginJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordJLabel)
                    .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(loginButton)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout loginJFrameLayout = new javax.swing.GroupLayout(loginJFrame.getContentPane());
        loginJFrame.getContentPane().setLayout(loginJFrameLayout);
        loginJFrameLayout.setHorizontalGroup(
            loginJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginJFrameLayout.createSequentialGroup()
                .addComponent(loginJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        loginJFrameLayout.setVerticalGroup(
            loginJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        themeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Glass", "Light", "Dark", "System" }));

        jLabel1.setText("Theme:");

        javax.swing.GroupLayout loginJPanel1Layout = new javax.swing.GroupLayout(loginJPanel1);
        loginJPanel1.setLayout(loginJPanel1Layout);
        loginJPanel1Layout.setHorizontalGroup(
            loginJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginJPanel1Layout.createSequentialGroup()
                .addGroup(loginJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginJPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(spaceJlabel1))
                    .addGroup(loginJPanel1Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(saveSettingsButton))
                    .addGroup(loginJPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(themeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ProjectTracker");
        setBounds(new java.awt.Rectangle(50, 50, 0, 0));
        setIconImage(new ImageIcon(getClass().getResource("/resources/icons/binoculars.png")).getImage());
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
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

        addMemberButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/add50.png"))); // NOI18N
        addMemberButton.setToolTipText("Add Member");
        addMemberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMemberButtonActionPerformed(evt);
            }
        });

        removeMemberButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/delete50.png"))); // NOI18N
        removeMemberButton.setToolTipText("Delete Member");
        removeMemberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeMemberButtonActionPerformed(evt);
            }
        });

        editMemberButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/edit50.png"))); // NOI18N
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
                "Name", "Phone", "Email", "Tasks"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
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
        teamTableScrollPane.setViewportView(teamTable);

        teamFilterButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/filter50.png"))); // NOI18N
        teamFilterButton.setToolTipText("Filter");
        teamFilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teamFilterButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout teamPanelLayout = new javax.swing.GroupLayout(teamPanel);
        teamPanel.setLayout(teamPanelLayout);
        teamPanelLayout.setHorizontalGroup(
            teamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, teamPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(teamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(teamTableScrollPane)
                    .addGroup(teamPanelLayout.createSequentialGroup()
                        .addComponent(addMemberButton)
                        .addGap(18, 18, 18)
                        .addComponent(removeMemberButton)
                        .addGap(18, 18, 18)
                        .addComponent(editMemberButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                        .addComponent(teamFilterButton)
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
                    .addComponent(teamFilterButton)
                    .addGroup(teamPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(teamFilterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(teamTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPane.addTab("", new javax.swing.ImageIcon(getClass().getResource("/resources/icons/team75.png")), teamPanel, "Team"); // NOI18N

        addTasksButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/add50.png"))); // NOI18N
        addTasksButton.setToolTipText("Add Task");
        addTasksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTasksButtonActionPerformed(evt);
            }
        });

        removeTaskButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/delete50.png"))); // NOI18N
        removeTaskButton.setToolTipText("Remove Task");
        removeTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeTaskButtonActionPerformed(evt);
            }
        });

        editTaskButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/edit50.png"))); // NOI18N
        editTaskButton.setToolTipText("Edit Task");
        editTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTaskButtonActionPerformed(evt);
            }
        });

        tasksFilterButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/filter50.png"))); // NOI18N
        tasksFilterButton.setToolTipText("Filter");
        tasksFilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tasksFilterButtonActionPerformed(evt);
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                        .addComponent(tasksFilterButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tasksFilterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tasksTableScrollPane))
                .addContainerGap())
        );
        tasksPanelLayout.setVerticalGroup(
            tasksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tasksPanelLayout.createSequentialGroup()
                .addGroup(tasksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addTasksButton)
                    .addComponent(removeTaskButton)
                    .addComponent(editTaskButton)
                    .addComponent(tasksFilterButton)
                    .addGroup(tasksPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(tasksFilterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tasksTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPane.addTab("", new javax.swing.ImageIcon(getClass().getResource("/resources/icons/tasks75.png")), tasksPanel, "Tasks"); // NOI18N

        javax.swing.GroupLayout schedulePanelLayout = new javax.swing.GroupLayout(schedulePanel);
        schedulePanel.setLayout(schedulePanelLayout);
        schedulePanelLayout.setHorizontalGroup(
            schedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 833, Short.MAX_VALUE)
        );
        schedulePanelLayout.setVerticalGroup(
            schedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 325, Short.MAX_VALUE)
        );

        tabbedPane.addTab("", new javax.swing.ImageIcon(getClass().getResource("/resources/icons/cal75.png")), schedulePanel, "Schedule"); // NOI18N

        javax.swing.GroupLayout progressPanelLayout = new javax.swing.GroupLayout(progressPanel);
        progressPanel.setLayout(progressPanelLayout);
        progressPanelLayout.setHorizontalGroup(
            progressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 833, Short.MAX_VALUE)
        );
        progressPanelLayout.setVerticalGroup(
            progressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 325, Short.MAX_VALUE)
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
        );

        tabbedPane.addTab("", new javax.swing.ImageIcon(getClass().getResource("/resources/icons/overview75.png")), jPanel1, "Project Overview"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 933, Short.MAX_VALUE)
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
        addMemberPhoneTextField.setText("");
        addMemberEmailTextField.setText("");
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
        boolean isAnyRowSelected = false;
        for (int i = 0; i < tasksTable.getRowCount(); i++) {
            if (tasksTable.isRowSelected(i)) {
                isAnyRowSelected = true;
            }
        }
        if (isAnyRowSelected) {
            DefaultTableModel model = (DefaultTableModel) tasksTable.getModel();
            model.removeRow(tasksTable.getSelectedRow());
        } else {
            JOptionPane.showMessageDialog(this,
                    "No Member Selected",
                    "No Member Selected", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_removeTaskButtonActionPerformed

    private void removeMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeMemberButtonActionPerformed
        boolean isAnyRowSelected = false;
        for (int i = 0; i < teamTable.getRowCount(); i++) {
            if (teamTable.isRowSelected(i)) {
                isAnyRowSelected = true;
            }
        }
        if (isAnyRowSelected) {
            DefaultTableModel model = (DefaultTableModel) teamTable.getModel();
            model.removeRow(teamTable.getSelectedRow());
        } else {
            JOptionPane.showMessageDialog(this,
                    "No Member Selected",
                    "No Member Selected", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_removeMemberButtonActionPerformed

    private void tabbedPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabbedPaneMouseClicked
        engine.updateChart(progressPanel);
    }//GEN-LAST:event_tabbedPaneMouseClicked

    private void addMemberDialogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMemberDialogButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) teamTable.getModel();
        model.addRow(new Object[]{addMemberNameTextField.getText(), addMemberPhoneTextField.getText(), addMemberEmailTextField.getText()});
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
        boolean isAnyRowSelected = false;
        for (int i = 0; i < teamTable.getRowCount(); i++) {
            if (teamTable.isRowSelected(i)) {
                isAnyRowSelected = true;
            }
        }
        if (isAnyRowSelected) {
            editNameTextField.setText(teamTable.getValueAt(teamTable.getSelectedRow(), 0).toString());
            editPhoneTextField.setText(teamTable.getValueAt(teamTable.getSelectedRow(), 1).toString());
            editEmailTextField.setText(teamTable.getValueAt(teamTable.getSelectedRow(), 2).toString());
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
                    "No Member Selected",
                    "No Member Selected", JOptionPane.DEFAULT_OPTION);
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
        boolean validCredentials = false;
        //code to set validCredentials to true given valid credentials are entered will need to be added here
        //for testing sake validCredentials will be set to true until implemented
        validCredentials = true;
        if (validCredentials) {
            loginJFrame.setVisible(false);
            this.setExtendedState(6); //maximises the screen by default when loggin in.
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

    private void teamFilterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teamFilterButtonActionPerformed
        engine.filterTable(teamTable, teamFilterTextField.getText());
    }//GEN-LAST:event_teamFilterButtonActionPerformed

    private void tasksFilterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tasksFilterButtonActionPerformed
        engine.filterTable(tasksTable, tasksFilterTextField.getText());
    }//GEN-LAST:event_tasksFilterButtonActionPerformed

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
        updateLookAndFeel("System");
        updateLookAndFeel(themeComboBox.getSelectedItem().toString());
        settingsJFrame.setVisible(false);
        this.setVisible(true);
        //full screen bug when swithing themes was fixed when going non full to fullscreen
        this.setExtendedState(0); //not fullscreen
        this.setExtendedState(6); //fullscreen
    }//GEN-LAST:event_saveSettingsButtonActionPerformed
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc=" public static void main(String args[]) ">

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        //WebLookAndFeel.install();
        try {
            setDefaultLookAndFeelDecorated(true);
            javax.swing.UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
        } catch (Exception e) {
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainView().loginJFrame.setVisible(true);
            }
        });
    }
//    public void saveChart(JFreeChart chart)
//    {
//        String fileName="C:/Users/Eric/Desktop/myCategoryChart.jpg";
//        try {
//            /**
//             * This utility saves the JFreeChart as a JPEG
//             * First Parameter: FileName
//             * Second Parameter: Chart To Save
//             * Third Parameter: Height Of <span id="IL_AD10" class="IL_AD">Picture</span>
//             * Fourth Parameter: Width Of Picture
//             */
//        ChartUtilities.saveChartAsJPEG(new File(fileName), chart, 800, 600);
//    } catch (IOException e) {
//        e.printStackTrace();
//        System.err.println("Problem occurred creating chart.");
//    }
//    }
    //</editor-fold>
//<editor-fold defaultstate="collapsed" desc=" Variable declarations ">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aboutButton;
    private javax.swing.JButton addMemberButton;
    private javax.swing.JButton addMemberDialogButton;
    private javax.swing.JLabel addMemberEmailJLabel;
    private javax.swing.JTextField addMemberEmailTextField;
    private javax.swing.JFrame addMemberJFrame;
    private javax.swing.JPanel addMemberJPanel;
    private javax.swing.JLabel addMemberNameJLabel;
    private javax.swing.JTextField addMemberNameTextField;
    private javax.swing.JLabel addMemberPhoneJLabel;
    private javax.swing.JTextField addMemberPhoneTextField;
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
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
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JButton tasksFilterButton;
    private javax.swing.JTextField tasksFilterTextField;
    private javax.swing.JPanel tasksPanel;
    private javax.swing.JTable tasksTable;
    private javax.swing.JScrollPane tasksTableScrollPane;
    private javax.swing.JButton teamFilterButton;
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