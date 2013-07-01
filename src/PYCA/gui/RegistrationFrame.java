/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RegistrationFrame.java
 *
 * Created on May 5, 2011, 11:08:35 AM
 */
package PYCA.gui;

import PYCA.model.District;
import PYCA.model.Participant;
import PYCA.model.Team;
import PYCA.model.Type;
import PYCA.model.Year;
import PYCA.services.implementation.DistrictServiceImpl;
import PYCA.services.implementation.ParticipantServiceImpl;
import PYCA.services.implementation.TeamServiceImpl;
import PYCA.services.implementation.TypeServiceImpl;
import PYCA.services.implementation.YearServiceImpl;
import PYCA.services.interfaces.DistrictService;
import PYCA.services.interfaces.ParticipantService;
import PYCA.services.interfaces.TeamService;
import PYCA.services.interfaces.TypeService;
import PYCA.services.interfaces.YearService;
import PYCA.tools.ComponentFormatter;
import PYCA.tools.ExceptionHandler;
import PYCA.tools.Theme;
import PYCA.tools.TimeRunnableObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author YANIX-MRML
 */
public class RegistrationFrame extends javax.swing.JFrame {

    private ParticipantService participantService;
    private TeamService teamService;
    private DistrictService districtService;
    private ArrayList<Participant> participantList;
    private ArrayList<Team> teamList;
    private ArrayList<District> districtList;
    private YearService yearService;
    private TypeService typeService;
    private ArrayList<Type> typeList;
    private ArrayList<Year> yearList;
    private Year currentYear;
    private DefaultTableModel participantTableModel;
    private Lock lockObject = new ReentrantLock( true );
    private ExecutorService runner;
    private TimeRunnableObject timeObject;
    private Year yearSelected;
    private Type typeSelected;
    private District districtSelected;
    private Team teamSelected;
    
    /** Creates new form RegistrationFrame */
    public RegistrationFrame() {
        Theme.setDefaultLookAndFeel();
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        participantService = new ParticipantServiceImpl();
        teamService = new TeamServiceImpl();
        districtService = new DistrictServiceImpl();
        yearService = new YearServiceImpl();
        currentYear = null;
        typeService = new TypeServiceImpl();        
        participantList = new ArrayList<Participant>();
        teamList = new ArrayList<Team>();
        districtList = new ArrayList<District>();
        participantTableModel = (DefaultTableModel) participantTable.getModel();
        setCurrentYear();
        setItemComboBox();
        setComboBox();
        ComponentFormatter.stripTable(participantTable);
        runner = Executors.newFixedThreadPool( 1 );
        timeObject = new TimeRunnableObject(lockObject,timeLabel,Calendar.getInstance());
        runner.execute(timeObject);
        runner.shutdown();
    }
    
    private void setComboBox(){
        try {
            typeList = (ArrayList<Type>) typeService.getTypes();
            for(Type type: typeList){
                typeCombo.addItem(type.getTypeName());
            }
            yearList = (ArrayList<Year>) yearService.getYears();
            for(Year year : yearList){
                yearCombo.addItem(year.getYear());
            }
            yearCombo.setSelectedItem(currentYear.getYear());
        } catch (ExceptionHandler ex) {
            Logger.getLogger(RegistrationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setItemComboBox(){
        itemCombo.removeAllItems();
        itemCombo.setEditable(false);
        if(choiceCombo.getSelectedItem().toString().equalsIgnoreCase("DISTRICT")){
            try {
                districtList = (ArrayList<District>) districtService.getDistricts();
                for(District district : districtList){
                    itemCombo.addItem(district.getDistrictName());
                }
            } catch (ExceptionHandler ex) {
                Logger.getLogger(RegistrationFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(choiceCombo.getSelectedItem().toString().equalsIgnoreCase("TEAM")){
            try {
                teamList = (ArrayList<Team>) teamService.getTeams(currentYear);
                for(Team team : teamList){
                    itemCombo.addItem(team.getTeamName());
                }
            } catch (ExceptionHandler ex) {
                Logger.getLogger(RegistrationFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            itemCombo.removeAllItems();
            itemCombo.setEditable(true);
        }
        
    }
    
    private void setCurrentYear(){
        try {
            currentYear = yearService.getCurrentYear();
        } catch (ExceptionHandler ex) {
            Logger.getLogger(RegistrationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        participantTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        yearCombo = new javax.swing.JComboBox();
        jToolBar2 = new javax.swing.JToolBar();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        items = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        viewButton = new javax.swing.JButton();
        itemCombo = new javax.swing.JComboBox();
        choiceCombo = new javax.swing.JComboBox();
        typeCombo = new javax.swing.JComboBox();
        jToolBar1 = new javax.swing.JToolBar();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Registration Frame");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 3));

        participantTable.setAutoCreateRowSorter(true);
        participantTable.setFont(new java.awt.Font("Tahoma", 1, 12));
        participantTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NO", "NAME", "NICKNAME", "AGE", "GKK", "PC", "RC", "ROLE", "DISTRICT", "TEAM", "ID COLOR", "YEAR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        participantTable.getTableHeader().setFont(new java.awt.Font("Calibri",java.awt.Font.PLAIN,14));
        participantTable.setRowHeight(28);
        participantTable.setShowHorizontalLines(false);
        participantTable.setShowVerticalLines(false);
        jScrollPane1.setViewportView(participantTable);
        participantTable.getColumnModel().getColumn(0).setMinWidth(35);
        participantTable.getColumnModel().getColumn(0).setPreferredWidth(35);
        participantTable.getColumnModel().getColumn(0).setMaxWidth(35);
        participantTable.getColumnModel().getColumn(2).setMinWidth(120);
        participantTable.getColumnModel().getColumn(2).setPreferredWidth(120);
        participantTable.getColumnModel().getColumn(2).setMaxWidth(120);
        participantTable.getColumnModel().getColumn(3).setMinWidth(35);
        participantTable.getColumnModel().getColumn(3).setPreferredWidth(35);
        participantTable.getColumnModel().getColumn(3).setMaxWidth(35);
        participantTable.getColumnModel().getColumn(5).setMinWidth(30);
        participantTable.getColumnModel().getColumn(5).setPreferredWidth(30);
        participantTable.getColumnModel().getColumn(5).setMaxWidth(30);
        participantTable.getColumnModel().getColumn(6).setMinWidth(30);
        participantTable.getColumnModel().getColumn(6).setPreferredWidth(30);
        participantTable.getColumnModel().getColumn(6).setMaxWidth(30);
        participantTable.getColumnModel().getColumn(11).setMinWidth(60);
        participantTable.getColumnModel().getColumn(11).setPreferredWidth(60);
        participantTable.getColumnModel().getColumn(11).setMaxWidth(60);

        jButton1.setFont(new java.awt.Font("Calibri", 1, 14));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PYCA/resources/83.png"))); // NOI18N
        jButton1.setText("Add Participant");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Calibri", 1, 14));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PYCA/resources/edit.png"))); // NOI18N
        jButton2.setText("Edit Participant");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Calibri", 1, 14));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PYCA/resources/50.png"))); // NOI18N
        jButton3.setText("Delete Participant");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PARISH YOUTH COORDINATING APOSTOLATE - STO. NINO PARISH");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("_______________________________________________________________________");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 510, -1));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 12));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("www.pyca.weebly.com");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 12));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Poblacion Kaputian, Dist III, Island Garden City of Samal");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        yearCombo.setFont(new java.awt.Font("Calibri", 1, 14));
        yearCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Choose Year>" }));
        jPanel1.add(yearCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);
        jToolBar2.setOpaque(false);

        jButton8.setFont(new java.awt.Font("Calibri", 1, 14));
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PYCA/resources/load.png"))); // NOI18N
        jButton8.setText("Categorized Again");
        jButton8.setOpaque(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton8);

        jButton9.setFont(new java.awt.Font("Calibri", 1, 14));
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PYCA/resources/print.png"))); // NOI18N
        jButton9.setText("Print List");
        jButton9.setFocusable(false);
        jButton9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton9.setOpaque(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton9);

        jPanel1.add(jToolBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 240, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PYCA/resources/1banner-customer.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jPanel3.setBackground(new java.awt.Color(0, 0, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PYCA/resources/footer.jpg"))); // NOI18N

        timeLabel.setFont(new java.awt.Font("Calibri", 1, 14));
        timeLabel.setForeground(new java.awt.Color(255, 255, 255));
        timeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PYCA/resources/calendar25.png"))); // NOI18N
        timeLabel.setText("TODAY is");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(timeLabel)))
                .addContainerGap())
        );

        items.setFont(new java.awt.Font("Calibri", 1, 14));
        items.setText("There are 0 total items in the list.");

        jPanel4.setBackground(new java.awt.Color(0, 204, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        viewButton.setFont(new java.awt.Font("Calibri", 1, 14));
        viewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PYCA/resources/eye.png"))); // NOI18N
        viewButton.setText("View");
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });

        itemCombo.setFont(new java.awt.Font("Tahoma", 1, 12));

        choiceCombo.setFont(new java.awt.Font("Tahoma", 1, 12));
        choiceCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DISTRICT", "TEAM", "FIRSTNAME" }));
        choiceCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceComboItemStateChanged(evt);
            }
        });

        typeCombo.setFont(new java.awt.Font("Calibri", 1, 14));
        typeCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Choose Type>" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(choiceCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(itemCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(typeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(choiceCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewButton))
                .addContainerGap())
        );

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setOpaque(false);

        jButton5.setFont(new java.awt.Font("Calibri", 1, 14));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PYCA/resources/load.png"))); // NOI18N
        jButton5.setText("Manage Districts");
        jButton5.setFocusable(false);
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton5.setOpaque(false);
        jToolBar1.add(jButton5);

        jButton6.setFont(new java.awt.Font("Calibri", 1, 14));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PYCA/resources/departments.png"))); // NOI18N
        jButton6.setText("Manage Teams");
        jButton6.setFocusable(false);
        jButton6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton6.setOpaque(false);
        jToolBar1.add(jButton6);

        jButton4.setFont(new java.awt.Font("Calibri", 1, 14));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PYCA/resources/date25.png"))); // NOI18N
        jButton4.setText("Manage Schedule");
        jButton4.setFocusable(false);
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton4.setOpaque(false);
        jToolBar1.add(jButton4);

        jButton7.setFont(new java.awt.Font("Calibri", 1, 14));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PYCA/resources/scholars.png"))); // NOI18N
        jButton7.setText("Manage ID Colors");
        jButton7.setFocusable(false);
        jButton7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton7.setOpaque(false);
        jToolBar1.add(jButton7);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1308, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1288, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 588, Short.MAX_VALUE)
                        .addComponent(items, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(items)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenu1.setText("Action");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ParticipantDialog addParticipant = new ParticipantDialog(this,true,null,currentYear);
        addParticipant.setVisible(true);
        Participant participant = addParticipant.getParticipant();
        if(participant!=null){
            participantList.add(participant);
            if(participant.getType().getTypeName().equalsIgnoreCase("Participant")){
                participantTableModel.addRow(new Object[]{participant.getParticipantID(),participant.toString(), participant.getNickName(),
                participant.getAge(),participant.getGkk(), participant.isParentalConsent(), participant.isRegistrationFee(),
                participant.getType().getTypeName(),participant.getDistrict().getDistrictName(),
                participant.getTeam().getTeamName(),participant.getColor().getColorName(),participant.getYear().getYear()});
            }else{
                participantTableModel.addRow(new Object[]{participant.getParticipantID(),participant.toString(), participant.getNickName(),
                participant.getAge(),participant.getGkk(), participant.isParentalConsent(), participant.isRegistrationFee(),participant.getType().getTypeName(),participant.getDistrict().getDistrictName(),
                "","",participant.getYear().getYear()});
            }
        }
        items.setText("There are " + participantList.size() + " total items in the list.");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
        // TODO add your handling code here:
        if(yearCombo.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this, "No Selected Year","Year",JOptionPane.WARNING_MESSAGE);
            return;
        }else if(typeCombo.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this, "No Selected Type","Type",JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        yearSelected = yearList.get(yearCombo.getSelectedIndex()-1);
        typeSelected = typeList.get(typeCombo.getSelectedIndex()-1);
        
        if(choiceCombo.getSelectedItem().toString().equalsIgnoreCase("DISTRICT")){
            if(!districtList.isEmpty()){
                try {
                    districtSelected = districtList.get(itemCombo.getSelectedIndex());
                    teamSelected = null;
                    participantList = (ArrayList<Participant>) participantService.getParticipantByDistrict(districtSelected, yearSelected, typeSelected);
                } catch (ExceptionHandler ex) {
                    Logger.getLogger(RegistrationFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(this, "Empty District List","District",JOptionPane.WARNING_MESSAGE);
            }
        }else if(choiceCombo.getSelectedItem().toString().equalsIgnoreCase("TEAM")){
            if(!teamList.isEmpty()){
                try {
                    teamSelected = teamList.get(itemCombo.getSelectedIndex());
                    districtSelected = null;
                    participantList = (ArrayList<Participant>) participantService.getParticipantByTeam(teamSelected, yearSelected, typeSelected);
                } catch (ExceptionHandler ex) {
                    Logger.getLogger(RegistrationFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(this, "Empty Team List","Team",JOptionPane.WARNING_MESSAGE);
            }
        }else{
            String name = itemCombo.getSelectedItem().toString();
            if(!name.isEmpty()){
                try {
                    participantList = (ArrayList<Participant>) participantService.getAllParticipantsByName(name, yearSelected);
                } catch (ExceptionHandler ex) {
                    Logger.getLogger(RegistrationFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        displayParticipantList();
    }//GEN-LAST:event_viewButtonActionPerformed

    private void displayParticipantList(){
        ComponentFormatter.clearTable(participantTableModel);
        for(Participant participant : participantList){
            if(participant.getType().getTypeName().equalsIgnoreCase("Participant")){
                participantTableModel.addRow(new Object[]{participant.getParticipantID(),participant.toString(), participant.getNickName(),
                participant.getAge(),participant.getGkk(), participant.isParentalConsent(), participant.isRegistrationFee(),
                participant.getType().getTypeName(),participant.getDistrict().getDistrictName(),
                participant.getTeam().getTeamName(),participant.getColor().getColorName(),participant.getYear().getYear()});
            }else{
                participantTableModel.addRow(new Object[]{participant.getParticipantID(),participant.toString(), participant.getNickName(),
                participant.getAge(),participant.getGkk(), participant.isParentalConsent(), participant.isRegistrationFee(),participant.getType().getTypeName(),participant.getDistrict().getDistrictName(),
                "","",participant.getYear().getYear()});
            } 
        }
        if(participantList.isEmpty()){
            JOptionPane.showMessageDialog(this, "Empty Participant List","Participant",JOptionPane.INFORMATION_MESSAGE);
        }
        items.setText("There are " + participantList.size() + " total items in the list.");
    }
    
    private void choiceComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choiceComboItemStateChanged
        // TODO add your handling code here:
        itemCombo.removeAllItems();
        itemCombo.setEditable(false);
        if(choiceCombo.getSelectedItem().toString().equalsIgnoreCase("DISTRICT")){
            try {
                districtList = (ArrayList<District>) districtService.getDistricts();
                for(District district : districtList){
                    itemCombo.addItem(district.getDistrictName());
                }
            } catch (ExceptionHandler ex) {
                Logger.getLogger(RegistrationFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(choiceCombo.getSelectedItem().toString().equalsIgnoreCase("TEAM")){
            try {
                teamList = (ArrayList<Team>) teamService.getTeams(currentYear);
                for(Team team : teamList){
                    itemCombo.addItem(team.getTeamName());
                }
            } catch (ExceptionHandler ex) {
                Logger.getLogger(RegistrationFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            itemCombo.removeAllItems();
            itemCombo.setEditable(true);
        }
    }//GEN-LAST:event_choiceComboItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int index = participantTable.getSelectedRow();
        if(index>=0){
            int viewIndex = participantTable.convertRowIndexToModel(index);
            Participant participant = participantList.get(viewIndex);
            int option = JOptionPane.showConfirmDialog(this, "Do you want to delete " + participant.toString() + " ?", "Delete", JOptionPane.YES_NO_OPTION);
            if(option==JOptionPane.YES_OPTION){
                try {
                    participantService.deleteParticipant(participant);
                    participantList.remove(viewIndex);
                    participantTableModel.removeRow(viewIndex);
                    JOptionPane.showMessageDialog(this, "You have successfully deleted " + participant.toString(), "Delete", JOptionPane.INFORMATION_MESSAGE);
                } catch (ExceptionHandler ex) {
                    Logger.getLogger(RegistrationFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }    
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int index = participantTable.getSelectedRow();
        if(index>=0){
            int viewIndex = participantTable.convertRowIndexToModel(index);
            Participant participant = participantList.get(viewIndex);
            ParticipantDialog editParticipant = new ParticipantDialog(this,true,participant,currentYear);
            editParticipant.setVisible(true);
            if(editParticipant.getParticipant()!=null){
                participant = editParticipant.getParticipant();
                participantList.set(viewIndex, participant);
                participantTableModel.setValueAt(participant.getParticipantID(), viewIndex, 0);
                participantTableModel.setValueAt(participant.toString(), viewIndex, 1);
                participantTableModel.setValueAt(participant.getNickName(), viewIndex, 2);
                participantTableModel.setValueAt(participant.getAge(), viewIndex, 3);
                participantTableModel.setValueAt(participant.getGkk(), viewIndex, 4);
                participantTableModel.setValueAt(participant.isParentalConsent(), viewIndex, 5);
                participantTableModel.setValueAt(participant.isRegistrationFee(), viewIndex, 6);
                participantTableModel.setValueAt(participant.getType().getTypeName(), viewIndex, 7);
                participantTableModel.setValueAt(participant.getDistrict().getDistrictName(), viewIndex, 8);
                if(participant.getTeam()!=null){
                    participantTableModel.setValueAt(participant.getTeam().getTeamName(), viewIndex, 9);
                }
                if(participant.getColor()!=null){
                    participantTableModel.setValueAt(participant.getColor().getColorName(), viewIndex, 10);
                }
                participantTableModel.setValueAt(participant.getYear().getYear(), viewIndex, 11);                
            }
        }    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(this,"Do you wan to close this window?", "Exit Window", JOptionPane.YES_NO_OPTION);
        if(option == JOptionPane.YES_NO_OPTION){
            System.exit(1);
        }
    }//GEN-LAST:event_formWindowClosing

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        if(participantTable.getRowCount()>0){
            if(teamSelected==null && districtSelected!=null){
                PrintPreviewReports previewDialog = new PrintPreviewReports(this,true,"LIST OF PARTICIPANTS","\tYear : " + yearSelected.getYear() + "\t\t\t" + "District : " + districtSelected.getDistrictName()
                        + "\nType : " + typeSelected.getTypeName() + "\t\t\tNo of Participants : " + participantTable.getRowCount(),participantTable);
                previewDialog.setVisible(true);
            }else if(districtSelected==null && teamSelected!=null){
                PrintPreviewReports previewDialog = new PrintPreviewReports(this,true,"LIST OF PARTICIPANTS","\tYear : " + yearSelected.getYear() + "\t\t\t" + "Team : " + teamSelected.getTeamName()
                        + "\nType : " + typeSelected.getTypeName() + "\t\t\tNo of Participants : " + participantTable.getRowCount(),participantTable);
                previewDialog.setVisible(true);
            }else{
                PrintPreviewReports previewDialog = new PrintPreviewReports(this,true,"LIST OF PARTICIPANTS","\tYear : " 
                        + yearSelected.getYear() + "\t\t\tType : " + typeSelected.getTypeName() + "\nNo of Participants : " + participantTable.getRowCount(),participantTable);
                previewDialog.setVisible(true);
            }    
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new RegistrationFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox choiceCombo;
    private javax.swing.JComboBox itemCombo;
    private javax.swing.JLabel items;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JTable participantTable;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JComboBox typeCombo;
    private javax.swing.JButton viewButton;
    private javax.swing.JComboBox yearCombo;
    // End of variables declaration//GEN-END:variables
}
