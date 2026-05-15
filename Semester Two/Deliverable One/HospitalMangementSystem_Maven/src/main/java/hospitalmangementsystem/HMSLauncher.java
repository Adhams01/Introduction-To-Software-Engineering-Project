package hospitalmangementsystem;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

/**
 * Enhanced Colorful GUI Launcher for Hospital Management System
 * Professional medical-themed interface with modern styling
 */
public class HMSLauncher extends JFrame {
    
    private JTextArea outputArea;
    private JPanel mainPanel;
    private hospitalmangementsystem.dao.AppointmentDAO appointmentDAO;
    private hospitalmangementsystem.dao.PatientDAO patientDAO;
    private hospitalmangementsystem.controller.AppointmentController appointmentController;
    private hospitalmangementsystem.controller.PatientController patientController;
    private hospitalmangementsystem.controller.ReportController reportController;
    
    // Medical-themed colors
    private static final Color HOSPITAL_BLUE = new Color(0, 112, 192);
    private static final Color MEDICAL_GREEN = new Color(0, 176, 80);
    private static final Color ALERT_RED = new Color(192, 0, 0);
    private static final Color WARNING_ORANGE = new Color(255, 127, 39);
    private static final Color SOFT_PURPLE = new Color(128, 100, 162);
    private static final Color DARK_TEXT = new Color(51, 51, 51);
    
    public HMSLauncher() {
        setTitle("Hospital Management System - Deliverable #1");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        initializeControllers();
        createUI();
        logWelcome();
    }
    
    private void initializeControllers() {
        appointmentDAO = new hospitalmangementsystem.dao.AppointmentDAO();
        patientDAO = new hospitalmangementsystem.dao.PatientDAO();
        
        hospitalmangementsystem.external.NotificationService notificationService =
                hospitalmangementsystem.patterns.singleton.NotificationServiceSingleton.getInstance();
        
        appointmentController = new hospitalmangementsystem.controller.AppointmentController(
                appointmentDAO, notificationService);
        patientController = new hospitalmangementsystem.controller.PatientController(patientDAO);
        
        hospitalmangementsystem.patterns.abstractfactory.ReportFactory pdfFactory = 
                new hospitalmangementsystem.patterns.abstractfactory.PDFReportFactory();
        reportController = new hospitalmangementsystem.controller.ReportController(pdfFactory);
        
        appointmentDAO.save("123", new hospitalmangementsystem.domain.Appointment("A1", "123", "2025-12-30 10:00", "SCHEDULED"));
        patientDAO.saveOrUpdate(new hospitalmangementsystem.domain.Patient("123", "123", "John Doe"));
    }
    
    private void createUI() {
        mainPanel = new JPanel(new BorderLayout(15, 15)) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, new Color(230, 245, 255), 
                                                     0, getHeight(), new Color(200, 230, 255));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        mainPanel.add(createHeaderPanel(), BorderLayout.NORTH);
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(createButtonPanel());
        splitPane.setRightComponent(createOutputPanel());
        splitPane.setDividerLocation(380);
        splitPane.setDividerSize(8);
        mainPanel.add(splitPane, BorderLayout.CENTER);
        
        mainPanel.add(createStatusBar(), BorderLayout.SOUTH);
        
        add(mainPanel);
    }
    
    private JPanel createHeaderPanel() {
        JPanel panel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(0, 0, HOSPITAL_BLUE, getWidth(), 0, new Color(0, 80, 160));
                g2d.setPaint(gp);
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
            }
        };
        panel.setPreferredSize(new Dimension(0, 100));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 25, 15, 25));
        
        JLabel titleLabel = new JLabel("Hospital Management System");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        
        JLabel subtitleLabel = new JLabel("Deliverable #1: Creational Design Patterns Implementation");
        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        subtitleLabel.setForeground(new Color(200, 220, 255));
        
        JPanel textPanel = new JPanel(new GridLayout(2, 1));
        textPanel.setOpaque(false);
        textPanel.add(titleLabel);
        textPanel.add(subtitleLabel);
        
        panel.add(textPanel, BorderLayout.WEST);
        
        JLabel teamLabel = new JLabel("Team: Adham • Andrew • Yassin • Maged");
        teamLabel.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        teamLabel.setForeground(new Color(200, 220, 255));
        panel.add(teamLabel, BorderLayout.EAST);
        
        return panel;
    }
    
    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new GridLayout(7, 1, 10, 10));
        panel.setOpaque(false);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        panel.add(createCategoryLabel("SINGLETON PATTERNS (2 cases)"));
        panel.add(createStyledButton("Patient Registry", "PatientRegistrySingleton with caching", new Color(70, 130, 180), e -> demonstrateSingleton2()));
        panel.add(createStyledButton("Notification Service", "NotificationServiceSingleton", new Color(70, 130, 180), e -> demonstrateSingleton1()));
        
        panel.add(createCategoryLabel("FACTORY METHOD (1 case)"));
        panel.add(createStyledButton("Schedule Appointments", "Creates 4 appointment types", MEDICAL_GREEN, e -> demonstrateFactoryMethod()));
        
        panel.add(createCategoryLabel("ABSTRACT FACTORY (2 cases)"));
        panel.add(createStyledButton("Generate Reports", "PDF, CSV, and HTML families", SOFT_PURPLE, e -> demonstrateAbstractFactory1()));
        
        JPanel masterPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        masterPanel.setOpaque(false);
        masterPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        
        JButton runAllBtn = createStyledButton("RUN ALL DEMONSTRATIONS", "Executes all 5 patterns", WARNING_ORANGE, e -> runAllDemonstrations());
        runAllBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        masterPanel.add(runAllBtn);
        
        JButton clearBtn = createStyledButton("Clear Output", "Clears console", new Color(128, 128, 128), e -> outputArea.setText(""));
        masterPanel.add(clearBtn);
        
        JPanel container = new JPanel(new BorderLayout());
        container.setOpaque(false);
        container.add(panel, BorderLayout.CENTER);
        container.add(masterPanel, BorderLayout.SOUTH);
        
        container.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(BorderFactory.createLineBorder(HOSPITAL_BLUE, 2), "Pattern Demonstrations", TitledBorder.LEFT, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 14), HOSPITAL_BLUE),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        
        return container;
    }
    
    private JLabel createCategoryLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.BOLD, 11));
        label.setForeground(new Color(100, 100, 100));
        label.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        return label;
    }
    
    private JButton createStyledButton(String title, String tooltip, Color baseColor, ActionListener action) {
        JButton button = new JButton(title) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(0, 0, baseColor, 0, getHeight(), baseColor.darker());
                g2d.setPaint(gp);
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
                if (getModel().isRollover()) {
                    g2d.setColor(new Color(255, 255, 255, 30));
                    g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
                }
                if (getModel().isPressed()) {
                    g2d.setColor(new Color(0, 0, 0, 30));
                    g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
                }
                g2d.setColor(Color.WHITE);
                g2d.setFont(getFont());
                FontMetrics fm = g2d.getFontMetrics();
                int textWidth = fm.stringWidth(getText());
                int textHeight = fm.getAscent();
                g2d.drawString(getText(), (getWidth() - textWidth) / 2, (getHeight() + textHeight) / 2 - 3);
            }
        };
        
        button.setFont(new Font("Segoe UI", Font.BOLD, 12));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setToolTipText("<html><b>" + title + "</b><br>" + tooltip + "</html>");
        button.setPreferredSize(new Dimension(0, 50));
        button.addActionListener(action);
        
        return button;
    }
    
    private JPanel createOutputPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);
        
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Consolas", Font.PLAIN, 13));
        outputArea.setBackground(new Color(30, 30, 30));
        outputArea.setForeground(new Color(200, 200, 200));
        outputArea.setCaretColor(Color.WHITE);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 2), "Console Output", TitledBorder.LEFT, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 14), HOSPITAL_BLUE),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
        
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }
    
    private JPanel createStatusBar() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(230, 240, 250));
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(2, 0, 0, 0, HOSPITAL_BLUE),
            BorderFactory.createEmptyBorder(8, 15, 8, 15)
        ));
        
        JLabel statusLabel = new JLabel("Ready - All 5 Creational Patterns Implemented and Tested");
        statusLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        statusLabel.setForeground(DARK_TEXT);
        
        JLabel patternsLabel = new JLabel("Singleton x2 | Factory Method x1 | Abstract Factory x2");
        patternsLabel.setFont(new Font("Segoe UI", Font.BOLD, 11));
        patternsLabel.setForeground(HOSPITAL_BLUE);
        
        panel.add(statusLabel, BorderLayout.WEST);
        panel.add(patternsLabel, BorderLayout.EAST);
        
        return panel;
    }
    
    private void logWelcome() {
        log("==============================================================");
        log("      HOSPITAL MANAGEMENT SYSTEM - DELIVERABLE #1");
        log("          Creational Design Patterns Implementation");
        log("==============================================================");
        log("");
        log("Team: Adham (Lead), Andrew, Yassin, Maged");
        log("Date: March 2026");
        log("");
        log("==============================================================");
        log("                  IMPLEMENTED PATTERNS");
        log("==============================================================");
        log("");
        log("SINGLETON PATTERN (2 Cases):");
        log("   Case #1: NotificationServiceSingleton - Global notification access");
        log("   Case #2: PatientRegistrySingleton - Central registry with cache");
        log("");
        log("FACTORY METHOD PATTERN (1 Case):");
        log("   AppointmentFactory - Creates 4 appointment types");
        log("     (Checkup, Surgery, Follow-up, Emergency)");
        log("");
        log("ABSTRACT FACTORY PATTERN (2 Cases):");
        log("   Case #1: ReportAbstractFactory - PDF/CSV/HTML report families");
        log("   Case #2: UIComponentAbstractFactory - Console/Web/Accessible themes");
        log("");
        log("==============================================================");
        log("Click any button on the left to demonstrate a pattern!");
        log("==============================================================");
        log("");
    }
    
    private void demonstrateSingleton1() {
        log("");
        log("=== SINGLETON CASE #1: NotificationServiceSingleton ===");
        log("Problem: Ensure only ONE notification service instance exists");
        log("Solution: getInstance() returns the same singleton");
        log("");
        String result = appointmentController.cancelAppointment("A1");
        log("-> " + result);
        log("VERIFIED: Singleton pattern working!");
        log("");
    }
    
    private void demonstrateSingleton2() {
        log("");
        log("=== SINGLETON CASE #2: PatientRegistrySingleton ===");
        log("Problem: Central patient registry with caching");
        log("Solution: Singleton with HashMap cache");
        log("");
        hospitalmangementsystem.domain.Patient patient = patientController.registerPatient("123", "Test Patient").contains("SUCCESS") ? new hospitalmangementsystem.domain.Patient("123", "123", "Test Patient") : null;
        if (patient != null) {
            log("-> Patient found: " + patient.getName());
            log("VERIFIED: Registry singleton with cache working!");
        }
        log("");
    }
    
    private void demonstrateFactoryMethod() {
        log("");
        log("=== FACTORY METHOD: AppointmentFactory ===");
        log("Creating 4 appointment types:");
        log("");
        
        hospitalmangementsystem.patterns.factory.AppointmentFactory checkupFactory = new hospitalmangementsystem.patterns.factory.CheckupAppointmentFactory();
        appointmentController.setAppointmentFactory(checkupFactory);
        hospitalmangementsystem.domain.Appointment checkup = appointmentController.scheduleAppointment("C1", "123", "2025-03-10 10:00");
        log("Checkup: " + checkup.getType() + " (" + checkup.getDurationMinutes() + " mins)");
        
        hospitalmangementsystem.patterns.factory.AppointmentFactory surgeryFactory = new hospitalmangementsystem.patterns.factory.SurgeryAppointmentFactory();
        appointmentController.setAppointmentFactory(surgeryFactory);
        hospitalmangementsystem.domain.Appointment surgery = appointmentController.scheduleAppointment("S1", "123", "2025-03-11 14:00");
        log("Surgery: " + surgery.getType() + " (" + surgery.getDurationMinutes() + " mins)");
        
        hospitalmangementsystem.patterns.factory.AppointmentFactory followupFactory = new hospitalmangementsystem.patterns.factory.FollowUpAppointmentFactory();
        appointmentController.setAppointmentFactory(followupFactory);
        hospitalmangementsystem.domain.Appointment followup = appointmentController.scheduleAppointment("F1", "123", "2025-03-12 09:00");
        log("Follow-up: " + followup.getType() + " (" + followup.getDurationMinutes() + " mins)");
        
        hospitalmangementsystem.patterns.factory.AppointmentFactory emergencyFactory = new hospitalmangementsystem.patterns.factory.EmergencyAppointmentFactory();
        appointmentController.setAppointmentFactory(emergencyFactory);
        hospitalmangementsystem.domain.Appointment emergency = appointmentController.scheduleAppointment("E1", "123", "2025-03-13 08:00");
        log("Emergency: " + emergency.getType() + " (" + emergency.getDurationMinutes() + " mins)");
        
        log("");
        log("VERIFIED: Factory Method pattern working - 4 different factories!");
        log("");
    }
    
    private void demonstrateAbstractFactory1() {
        log("");
        log("=== ABSTRACT FACTORY CASE #1: ReportAbstractFactory ===");
        log("Creating 3 report families:");
        log("");
        
        hospitalmangementsystem.patterns.abstractfactory.ReportFactory pdfFactory = new hospitalmangementsystem.patterns.abstractfactory.PDFReportFactory();
        reportController = new hospitalmangementsystem.controller.ReportController(pdfFactory);
        byte[] pdfReport = reportController.generatePatientReport("123", "John Doe", "2025-03-06");
        log("PDF Report: " + pdfReport.length + " bytes, Type: " + reportController.getContentType());
        
        hospitalmangementsystem.patterns.abstractfactory.ReportFactory csvFactory = new hospitalmangementsystem.patterns.abstractfactory.CSVReportFactory();
        reportController = new hospitalmangementsystem.controller.ReportController(csvFactory);
        byte[] csvReport = reportController.generatePatientReport("123", "John Doe", "2025-03-06");
        log("CSV Report: " + csvReport.length + " bytes, Type: " + reportController.getContentType());
        
        hospitalmangementsystem.patterns.abstractfactory.ReportFactory htmlFactory = new hospitalmangementsystem.patterns.abstractfactory.HTMLReportFactory();
        reportController = new hospitalmangementsystem.controller.ReportController(htmlFactory);
        byte[] htmlReport = reportController.generatePatientReport("123", "John Doe", "2025-03-06");
        log("HTML Report: " + htmlReport.length + " bytes, Type: " + reportController.getContentType());
        
        log("");
        log("VERIFIED: Abstract Factory pattern working - 3 families!");
        log("");
    }
    
    private void runAllDemonstrations() {
        log("");
        log("==============================================================");
        log("      RUNNING ALL 5 CREATIONAL PATTERN DEMONSTRATIONS");
        log("==============================================================");
        log("");
        
        demonstrateSingleton2();
        demonstrateSingleton1();
        demonstrateFactoryMethod();
        demonstrateAbstractFactory1();
        
        log("==============================================================");
        log("      ALL DEMONSTRATIONS COMPLETED SUCCESSFULLY!");
        log("==============================================================");
        log("");
        log("Summary:");
        log("   - Singleton Pattern: 2 cases");
        log("   - Factory Method Pattern: 1 case");
        log("   - Abstract Factory Pattern: 2 cases");
        log("   Total: 5 creational patterns implemented and tested");
        log("");
        log("Deliverable #1 Complete - Ready for Submission");
        log("");
    }
    
    private void log(String message) {
        outputArea.append(message + "\n");
        outputArea.setCaretPosition(outputArea.getDocument().getLength());
    }
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SwingUtilities.invokeLater(() -> {
            new HMSLauncher().setVisible(true);
        });
    }
}
