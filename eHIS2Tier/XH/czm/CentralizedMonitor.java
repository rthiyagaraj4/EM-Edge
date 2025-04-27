
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.io.*;
import java.util.*;
import java.net.*;

//class CentralizedMonitor 

public class CentralizedMonitor extends JFrame implements ActionListener {
   
	JButton submitButton;
	JButton canelButton;

	JPanel connectionPanel;
	JFrame frame; // The query/results window.

	JLabel		userNameLabel;
	JTextField	userNameField;
	JLabel		passwordLabel;
	JPasswordField passwordField;

	JTextArea   queryTextArea;
	JComponent  queryAggregate;
	JLabel      serverLabel;
	JTextField  serverField;
	JLabel      driverLabel;
	JTextField  driverField;

	JLabel      applicationLabel;
	JTextField  applicationField;

	JLabel      facilityLabel;
	JTextField  facilityField;

	JLabel      commuLabel;
	JTextField  commuField;

	JLabel      ioLabel;
	JTextField  ioField;
	JPanel      displayPanel;   

	JPanel      mainPanel;

	JScrollPane tableAggregate;

    /**
     * Creates the connectionPanel, which will contain all the fields for
     * the connection information.
     */
    public void init() {
 	// Create the labels and text fields.
	userNameLabel = new JLabel("User name ", JLabel.CENTER);
 	userNameField = new JTextField(30);

	passwordLabel = new JLabel("Password ", JLabel.CENTER);
	passwordField = new JPasswordField(30);
	    
	driverLabel = new JLabel("Database  ", JLabel.CENTER);
	driverField = new JTextField(30);

  	submitButton=new JButton("SUBMIT");
	canelButton=new JButton("CANCEL");
	
	JPanel namePanel = new JPanel(false);
	namePanel.setLayout(new GridLayout(4,2));
	namePanel.add(userNameLabel);
	namePanel.add(userNameField);
	
	namePanel.add(passwordLabel);
	namePanel.add(passwordField);
	namePanel.add(driverLabel);
	namePanel.add(driverField);
 	
	displayPanel = new JPanel(false);
	displayPanel.setLayout(new FlowLayout());
	displayPanel.add(submitButton);
	displayPanel.add(canelButton);

	connectionPanel = new JPanel(false);
	connectionPanel.setLayout(new BorderLayout());
	connectionPanel.add(namePanel,BorderLayout.NORTH);
	connectionPanel.add(displayPanel,BorderLayout.SOUTH);
    
	}

    //constructor 	CentralizedMonitor
	public CentralizedMonitor() 
	{
        
		setSize(450,150);
		//setDefaultLookAndFeelDecorated(true);
		Dimension us = getSize(), them = Toolkit.getDefaultToolkit().getScreenSize();
		int newX = (them.width - us.width) / 2;
		int newY = (them.height - us.height) / 2;
		setLocation(newX, newY);
	   // Image image = Toolkit.getDefaultToolkit().createImage("./product_small.gif");
	//	setIconImage(Toolkit.getDefaultToolkit().getImage("product_small.gif"));
		setTitle("Centralized Interface Gateway Monitor Login");
		
		init();
		this.getContentPane().add(connectionPanel);
		submitButton.addActionListener(this);
		canelButton.addActionListener(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	
    }

	//connection information
	public void connect() {
		boolean dbInfoExists = true;
		String databaseurl = "";
		String database = driverField.getText().trim();
		String username = userNameField.getText().trim();
		String password = passwordField.getText().trim();

		databaseurl = getDataBaseUrl(database);

		if("FileNotFound".equals(databaseurl)) 
		{
			JOptionPane.showMessageDialog(this, "Configuration File Not found...", "Error", JOptionPane.ERROR_MESSAGE);	
			dbInfoExists = false;
		}
		else if("".equals(databaseurl))
		{
			JOptionPane.showMessageDialog(this, "Databaseurl is Not Found in Configuration Settings File...", "Error", JOptionPane.ERROR_MESSAGE);	
			dbInfoExists = false;
		}

		if(username.equalsIgnoreCase("")) 
		{
			JOptionPane.showMessageDialog(this, "Invalid User..", "Error", JOptionPane.ERROR_MESSAGE);	
			dbInfoExists = false;
		}

		if(password.equalsIgnoreCase("")) 
		{
			JOptionPane.showMessageDialog(this, "Invalid Password..", "Error", JOptionPane.ERROR_MESSAGE);	
			dbInfoExists = false;
		}

		if(dbInfoExists)
		{
			new CentralizedMonitorApplication(databaseurl, username, password);	
			setVisible(false);
		}
	}

	// method to verify the dabase connection url 
	public String getDataBaseUrl(String dbstrng) 
	{
		String propvalue = null;
		Properties properties = new Properties();
		try 
		{
			properties.load(new FileInputStream("c:/ehis/config/properties.ini"));			
		}
		catch(FileNotFoundException exp)
		{				
			System.out.println(exp);
			propvalue = "FileNotFound";
		}
		catch (IOException e) 
		{
			System.out.println("Exception : " + e.toString());
		}		

		if("FileNotFound".equals(propvalue))
		{
			propvalue = "";
			try
			{
				properties.load(new FileInputStream("c:/ehis/reports/properties.ini"));			
			}
			catch(FileNotFoundException fexp)
			{
				System.out.println(fexp.toString());
				propvalue = "FileNotFound";
			}
			catch(Exception GExp)
			{
			}
		}

		for (Enumeration props = properties.keys(); props.hasMoreElements();) 
		{
			String propkey;			
			propkey = (String) props.nextElement();
			propvalue = properties.getProperty(propkey);

			if (propkey.equalsIgnoreCase(dbstrng.trim())) 
			{
				propvalue = properties.getProperty(propkey);			
				break;
			} 
			else propvalue = "";
		}
		return propvalue;
	}

   // public actionPermormed method implemeted to add actions    
	public  void actionPerformed(ActionEvent actionevent)
	{
	     Object source = actionevent.getSource();
		
		 if(source == submitButton) {
			  connect();
		 }
		 else if(source == canelButton) {			
			 CentralizedWriteLog write = new CentralizedWriteLog();
			 write.fileOutput("CentMonitorLog.txt"," (CentralizedMonitorApplication:actionPerformed) Closing Centralized Interface Gateway Monitor \n");
			 System.exit(0);
		  }
	 }

    public static void main(String s[]) {
        new CentralizedMonitor();
    }
	
 }
