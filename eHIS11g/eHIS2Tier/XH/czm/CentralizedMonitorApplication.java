import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.Border;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

import java.util.*;
import java.net.*;
import java.text.SimpleDateFormat;

import java.io.*;

// class  CentralizedMonitorApplication
public class CentralizedMonitorApplication extends JFrame implements ActionListener {
	// JButton
//	JButton fetchButton;
	JButton refreshButton;
	JButton exitButton;
	JButton startButton;
	JButton stopButton;

	// JLabel
	JLabel applicationLabel;
	JLabel facilityLabel;
	JLabel commuLabel;
	JLabel ioLabel;

	// JLabel installLabel;
	// JComboBox
	JComboBox applicationField;
	JComboBox facilityField;
	JComboBox commuField;
	JComboBox ioField;
	JComboBox installField;

	// JPanel
	JPanel labelPanel;
	JPanel buttonPanel;
	JPanel mainPanel;
	JPanel topPanel = null;
	JPanel centrePanel = null;
	JPanel bottomPanel = null;
	JPanel barPanel = new JPanel(new GridLayout(1, 12, 1, 1));

	// JSplitPane
	JSplitPane mainPane;
	JSplitPane subPane;
	JSplitPane bottomPane;

	// JTable
	JTable intable;
	JTable outtable;

	// JScrollPane
	JScrollPane inscrollpane = null;
	JScrollPane outscrollpane = null;

	// JProgressBar
	JProgressBar progressbar;
	JMenuItem menuItem;
	PopupListener popupListener;

	// sql stmt variables
	String insql = null;
	String outsql = null;

	String clientArray[][] = null;
	String commtypeArray[] = { "Outbound", "Inbound" };
	String installArray[] = { "Without Service", "With Service" };
	String applnArray[][] = null;
	String facilityArray[][] = null;
	String all[] = { "All" };

	String clientidArray[] = null;
	String clientdescArray[] = null;
	String applnidArray[] = null;
	String applndescArray[] = null;
	String facilityidArray[] = null;
	String facilitydescArray[] = null;

	String dburl = null;
	String usrname = null;
	String password = null;

	String strLogInformation = "\t     iSOFT CENTRALIZED INTERFACE GATEWAY MONITOR LOG  \n";
	String line = "-------------------------------------------------------------------------------------------------------------";

	String filename = null;
	String modeofinstall = null;

	int initStart = 0;
	int lastFileGenTime = 0;
	long lastFileGenTimeInMillis;
	int rowSel;

	TableModel inboundmodel = null;
	TableModel outboundmodel = null;

	JTable inboundtable = null;
	JTable outboundtable = null;

	PrintStream out;

	HashMap sqlhashMap = null;

	CentralizedWriteLog write = null;
	CentralizedDataBaseAdapter dataadapter = null;
	CentralizedRemote remoteObject = null;
	CustomTableCellRenderer customTableCellRenderer = null;

	// constructor CentralizedMonitorApplication
	CentralizedMonitorApplication(String dburl, String usrname, String password) {
		super("Centralized Interface Gateway Monitor");
		System.out.println("------- CentralizedMonitor ----");
		try 
		{
			this.dburl = dburl;
			this.usrname = usrname;
			this.password = password;

			write = new CentralizedWriteLog();
			filename = write.filename;
			write.fileOutput(filename, "\n".getBytes(), "\n".getBytes().length);
			write.fileOutput(filename, line.getBytes(), line.getBytes().length);
			write.fileOutput(filename, "\n".getBytes(), "\n".getBytes().length);
			write.fileOutput(filename, "\n".getBytes(), "\n".getBytes().length);
			write.fileOutput(filename, strLogInformation.getBytes(), strLogInformation.getBytes().length);
			write.fileOutput(filename, "\n".getBytes(), "\n".getBytes().length);
			write.fileOutput(filename, line.getBytes(), line.getBytes().length);
			write.fileOutput(filename, "\n".getBytes(), "\n".getBytes().length);
			write.fileOutput(filename,
							" (CentralizedMonitorApplication:constructor) Login to Communication Administrator Application\n");
			dataadapter = new CentralizedDataBaseAdapter(dburl, usrname, password, write);
			if (dataadapter.connectionflag) {
				write.fileOutput(filename,
								" (CentralizedMonitorApplication:constructor) Database Connection Successful: "
										+ dburl + ":" + usrname +  "\n");
				init();
				setup();
				createPopupMenu();
				fetch();
				displayRecords("R");				
			} else {
				JOptionPane.showMessageDialog(this,
						CentralizedDataBaseAdapter.dbConnectionExcetion,
						"Error", JOptionPane.ERROR_MESSAGE);
				write.fileOutput(filename,
								" (CentralizedMonitorApplication:constructor) Database Connection Failed :"
										+ dburl + ":" + usrname + "\n");
				System.exit(0);
			}
			out = new PrintStream(new FileOutputStream(filename, true));

		} catch (Exception exception) {
			write.fileOutput(filename,
					" (CentralizedMonitorApplication:constructor) Exception :"
							+ exception.toString() + "\n");
		}

	}// end of Constructor

	// /method setup
	public void setup() {
		try {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			getContentPane().add(mainPane, BorderLayout.CENTER);
			// Image image =
			// Toolkit.getDefaultToolkit().createImage("/product_small.gif");
			// setIconImage(image);
			setSize(1024, 740);
			setVisible(true);
		} catch (Exception exception) {
			write.fileOutput(filename,
					" (CentralizedMonitorApplication:setup()) Exception :"
							+ exception.toString() + "\n");
		}

	}// end of setup

	// init method
	public void init() {
		try {
			clientArray = dataadapter.getClientRecords();

			if ((clientArray != null) && (clientArray.length != 0)) {
				clientidArray = new String[clientArray.length];
				clientdescArray = new String[clientArray.length];
				for (int i = 0; i < clientArray.length; i++) {
					clientidArray[i] = clientArray[i][0];
					clientdescArray[i] = clientArray[i][1];
				}
			}
			commuLabel = new JLabel(" Gateway Server  ", JLabel.RIGHT);
			commuField = new JComboBox(clientdescArray);
			commuField.setForeground(Color.black);
			commuField.setBackground(Color.white);

			ioLabel = new JLabel(" Communication Mode  ", JLabel.RIGHT);
			ioField = new JComboBox(commtypeArray);
			ioField.setForeground(Color.black);
			ioField.setBackground(Color.white);

			applnArray = dataadapter.getApplicationRecords();
			if ((applnArray != null) && (applnArray.length != 0)) {
				applnidArray = new String[applnArray.length];
				applndescArray = new String[applnArray.length];

				for (int i = 0; i < applnArray.length; i++) {
					applnidArray[i] = applnArray[i][0];
					applndescArray[i] = applnArray[i][1];
				}
			}
			applicationLabel = new JLabel(" Application  ", JLabel.RIGHT);
			applicationField = new JComboBox(applndescArray);
			applicationField.setForeground(Color.black);
			applicationField.setBackground(Color.white);

			facilityArray = dataadapter.getFacilityRecords();
			if ((facilityArray != null) && (facilityArray.length != 0)) {
				facilityidArray = new String[facilityArray.length];
				facilitydescArray = new String[facilityArray.length];

				for (int i = 0; i < facilityArray.length; i++) {
					facilityidArray[i] = facilityArray[i][0];
					facilitydescArray[i] = facilityArray[i][1];
				}
			}

			facilityLabel = new JLabel(" Facility    ", JLabel.RIGHT);
			facilityField = new JComboBox(facilitydescArray);
			facilityField.setForeground(Color.black);
			facilityField.setBackground(Color.white);

			// installLabel = new JLabel(" Install Type ",JLabel.RIGHT);
			// installField = new JComboBox(installArray);
			// installField.setForeground(Color.black);
			// installField.setBackground(Color.white);

			labelPanel = new JPanel(new GridLayout(3, 2, 0, 0));

			labelPanel.add(commuLabel);
			labelPanel.add(commuField);
			labelPanel.add(ioLabel);
			labelPanel.add(ioField);
			labelPanel.add(applicationLabel);
			labelPanel.add(applicationField);
			// labelPanel.add(facilityLabel);
			// labelPanel.add(facilityField);
			// labelPanel.add(installLabel);
			// labelPanel.add(installField);

			Color buttonColor = new Color(220, 100, 100);
			buttonPanel = new JPanel(new GridLayout(1, 5, 2, 2));
		//	fetchButton = new JButton("Query");
		//	fetchButton.setBackground(buttonColor);
		//	buttonPanel.add(fetchButton);

			refreshButton = new JButton("Refresh");
			refreshButton.setBackground(buttonColor);
			buttonPanel.add(refreshButton);

			startButton = new JButton("Start");
			startButton.setBackground(buttonColor);
			buttonPanel.add(startButton);

			stopButton = new JButton("Stop");
			stopButton.setBackground(buttonColor);
			buttonPanel.add(stopButton);

			exitButton = new JButton("Exit");
			exitButton.setBackground(buttonColor);
			buttonPanel.add(exitButton);

			Border border = BorderFactory.createLineBorder(Color.BLACK);

			JLabel label1 = new JLabel("New Gateway", JLabel.CENTER);
		// Button1.setOpaque(true);
			JLabel label12 = new JLabel("", JLabel.CENTER);
			label12.setBackground(Color.PINK);
			label12.setOpaque(true);

		//	label12.setBorder(border);
			JLabel label2 = new JLabel("Active", JLabel.CENTER);
			JLabel label22 = new JLabel("", JLabel.CENTER);
			label22.setBackground(Color.green);
			label22.setSize(500, 500);
			label22.setOpaque(true);
		//	label2.setBorder(border);

			JLabel label3 = new JLabel(" Warming Up ", JLabel.CENTER);
			JLabel label32 = new JLabel("", JLabel.CENTER);
			label32.setBackground(Color.yellow);
			label32.setOpaque(true);
		//	label3.setBorder(border);

			JLabel label4 = new JLabel("Stopped", JLabel.CENTER);
			JLabel label42 = new JLabel("", JLabel.CENTER);
			label42.setBackground(Color.red);
			label42.setOpaque(true);
		//	label4.setBorder(border);

			JLabel label5 = new JLabel(" About To Stop ", JLabel.CENTER);
			JLabel label52 = new JLabel("", JLabel.CENTER);
			label52.setMinimumSize(new Dimension(2, 2));
			label52.setPreferredSize(new Dimension(5, 5));
			label52.setBackground(Color.blue);
			label52.setOpaque(true);
		//	label5.setBorder(border);

			JLabel label6 = new JLabel("Unknown", JLabel.CENTER);
			JLabel label62 = new JLabel("", JLabel.CENTER);
			label62.setSize(2, 2);
		//	label62.setForeground(Color.white);
			label62.setBackground(Color.black);
			label62.setOpaque(true);
		//	label6.setBorder(border);

			barPanel.add(label1);
			barPanel.add(label12);
			barPanel.add(label2);
			barPanel.add(label22);
			barPanel.add(label3);
			barPanel.add(label32);
			barPanel.add(label4);
			barPanel.add(label42);
			barPanel.add(label5);
			barPanel.add(label52);
			barPanel.add(label6);
			barPanel.add(label62);

			topPanel = new JPanel(new BorderLayout());
			topPanel.add(labelPanel, BorderLayout.NORTH);
			topPanel.add(buttonPanel, BorderLayout.SOUTH);

		//	fetchButton.addActionListener(this);
			startButton.addActionListener(this);
			refreshButton.addActionListener(this);
			stopButton.addActionListener(this);
			exitButton.addActionListener(this);

			mainPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
			mainPane.setDividerSize(3);
			mainPane.setDividerLocation(100);
			mainPane.setTopComponent(topPanel);

			subPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
			mainPane.setBottomComponent(subPane);

		} catch (Exception exception) {
			write.fileOutput(filename,
					" (CentralizedMonitorApplication:init()) Exception :"
							+ exception.toString() + "\n");
			exception.printStackTrace(out);
		}

	} // end of init

	// method fetch
	public void fetch() {
		try {
			String applicationid = null;
			String facilityid = null;
			String commclient = null;
			String commtype = "";

			int applnindex = applicationField.getSelectedIndex();
			int facindex = facilityField.getSelectedIndex();
			int commindex = commuField.getSelectedIndex();
			commtype = (String) ioField.getSelectedItem();

			// modeofinstall = (String)installField.getSelectedItem();

			modeofinstall = getPropertyVal("C:/eHIS/config/properties.ini", "windowsservice");

			if (modeofinstall == null || "N".equalsIgnoreCase(modeofinstall))
				modeofinstall = "Without Service";
			else
				modeofinstall = "With Service";

			if ((applnindex > 0) && (applnidArray != null)) applicationid = applnidArray[applnindex];
			else applicationid = "";

			if ((facindex > 0) && (facilityidArray != null)) facilityid = facilityidArray[facindex];
			else facilityid = "";

			if ((commindex > 0) && (clientidArray != null)) commclient = clientidArray[commindex];
			else commclient = "";

			if (commtype.equalsIgnoreCase("All")) commtype = "";
			if (commtype.equalsIgnoreCase("Inbound")) commtype = "I";
			if (commtype.equalsIgnoreCase("Outbound")) commtype = "O";

			write.fileOutput(filename,
					" (CentralizedMonitorApplication:fetch) ApplicationId :" + applicationid + "\n");
			write.fileOutput(filename,
					" (CentralizedMonitorApplication:fetch) FacilityId :" + facilityid + "\n");
			write.fileOutput(filename,
					" (CentralizedMonitorApplication:fetch) Communication ClientId :" + commclient + "\n");
			write.fileOutput(filename,
					" (CentralizedMonitorApplication:fetch) Ccommunication Type :" + commtype + "\n");

			sqlhashMap = constructSql(applicationid, facilityid, commclient, commtype);
			outsql = (String) sqlhashMap.get("outsql");
			insql = (String) sqlhashMap.get("insql");

			write.fileOutput(filename,
					" (CentralizedMonitorApplication:fetch) Outbound sql Query :" + outsql + "\n");
			write.fileOutput(filename,
					" (CentralizedMonitorApplication:fetch) Inbound sql Query :" + insql + "\n");

		} catch (Exception exception) {
			write.fileOutput(filename,
					" (CentralizedMonitorApplication:fetch()) Exception :" + exception.toString() + "\n");
			exception.printStackTrace(out);
		}
	} // end of method fetch

	// method constructSql
	public HashMap constructSql(String applicationid, String facilityid,
			String commclient, String commtype) {
		HashMap hashmap = null;
		try {

			String outboundsql = "SELECT DISTINCT A.CLIENT_ID ,B.CLIENT_NAME,A.APPLICATION_ID ,D.APPLICATION_NAME,A.PROCESS_ID,A.PROCESS_STATUS,TO_CHAR(A.START_DATE_TIME,'DD/MM/YYYY HH24:MI:SS') "
					+ " START_DATE_TIME,A.STARTED_BY_ID,TO_CHAR(A.STOP_DATE_TIME,'DD/MM/YYYY HH24:MI:SS')STOP_DATE_TIME, "
					+ " A.LAST_OUTBOUND_RETRIES,C.PROTOCOL_LINK,P.PROTOCOL_TYPE,TO_CHAR(A.LAST_COMM_DATE_TIME,'DD/MM/YYYY HH24:MI:SS')LAST_COMM_DATE_TIME,A.LAST_MESSAGE_ID,A.TOTAL_MESSAGES,A.COMM_STATUS"
					+ " FROM XH_COMM_PROCESS A,XH_COMM_CLIENT B,XH_COMM_CLIENT_APPLICATION C ,XH_APPLICATION D,XH_PROTOCOL P,XH_PROTOCOL_LINK PL"
					+ " WHERE A.CLIENT_ID=NVL('"
					+ commclient
					+ "',A.CLIENT_ID) AND A.PROCESS_TYPE='O' "
					+ " AND A.APPLICATION_ID=NVL('"
					+ applicationid
					+ "',A.APPLICATION_ID)"
					+ " AND A.CLIENT_ID=B.CLIENT_ID AND A.CLIENT_ID=C.CLIENT_ID "
					+ " AND b.OUTBOUND_YN = 'Y' AND c.IN_USE_YN = 'Y' AND b.IN_USE_YN = 'Y' "
					+ " AND A.APPLICATION_ID=D.APPLICATION_ID"
					+ " AND A.APPLICATION_ID = C.APPLICATION_ID AND A.PROTOCOL_LINK=C.PROTOCOL_LINK"
					+ " AND C.PROTOCOL_LINK=PL.PROTOCOL_LINK_ID AND PL.PROTOCOL_ID=P.PROTOCOL_ID"
					+ " AND (A.APPLICATION_ID,A.START_DATE_TIME)  IN (SELECT APPLICATION_ID , MAX(START_DATE_TIME) FROM XH_COMM_PROCESS "
					+ " WHERE CLIENT_ID=NVL('"
					+ commclient
					+ "',CLIENT_ID) AND PROTOCOL_LINK=A.PROTOCOL_LINK AND PROCESS_TYPE ='O' GROUP BY  APPLICATION_ID,CLIENT_ID)"
					+ " UNION "
					+ " SELECT DISTINCT X.CLIENT_ID CLIENT_ID,Y.CLIENT_NAME CLIENT_NAME,X.APPLICATION_ID APPLICATION_ID,D.APPLICATION_NAME,NULL PROCESS_ID,NULL PROCESS_STATUS,TO_CHAR(NULL) START_DATE_TIME,"
					+ " X.MODIFIED_BY_ID MODIFIED_BY_ID,TO_CHAR(NULL)STOP_DATE_TIME,NULL LAST_OUTBOUND_RETRIES,X.PROTOCOL_LINK,NULL,NULL,NULL,NULL,'N' COMM_STATUS"
					+ " FROM XH_COMM_CLIENT_APPLICATION X,XH_COMM_CLIENT Y ,XH_APPLICATION D,SM_FACILITY_PARAM S"
					+ " WHERE X.IN_USE_YN='Y'AND Y.OUTBOUND_YN='Y' AND X.CLIENT_ID  = Y.CLIENT_ID AND X.CLIENT_ID=NVL('"
					+ commclient
					+ "',X.CLIENT_ID) "
					+ " AND Y.IN_USE_YN='Y' AND X.COMM_TYPE='O' AND X.APPLICATION_ID=NVL('"
					+ applicationid
					+ "',X.APPLICATION_ID)  "
					+ " AND X.APPLICATION_ID=D.APPLICATION_ID AND (X.APPLICATION_ID, NVL('"
					+ commclient
					+ "',X.CLIENT_ID),NVL(X.PROTOCOL_LINK,'~')) NOT IN (SELECT APPLICATION_ID, CLIENT_ID,NVL(PROTOCOL_LINK,'~') FROM XH_COMM_PROCESS WHERE PROCESS_TYPE='O')";

			String inboundsql = "SELECT DISTINCT A.CLIENT_ID ,B.CLIENT_NAME,A.APPLICATION_ID ,D.APPLICATION_NAME,"
					+ " A.PROCESS_ID,A.PROCESS_STATUS,TO_CHAR(A.START_DATE_TIME,'DD/MM/YYYY HH24:MI:SS') "
					+ " START_DATE_TIME,A.STARTED_BY_ID,TO_CHAR(A.STOP_DATE_TIME,'DD/MM/YYYY HH24:MI:SS')STOP_DATE_TIME,"
					+ " A.LAST_OUTBOUND_RETRIES,C.PROTOCOL_LINK,P.PROTOCOL_TYPE,TO_CHAR(A.LAST_COMM_DATE_TIME,'DD/MM/YYYY HH24:MI:SS')LAST_COMM_DATE_TIME,A.LAST_MESSAGE_ID,A.TOTAL_MESSAGES,A.COMM_STATUS"
					+ " FROM XH_COMM_PROCESS A,XH_COMM_CLIENT B,XH_COMM_CLIENT_APPLICATION C ,XH_APPLICATION D,XH_PROTOCOL P,XH_PROTOCOL_LINK PL"
					+ " WHERE A.CLIENT_ID=NVL('"
					+ commclient
					+ "',A.CLIENT_ID) AND A.PROCESS_TYPE='I' "
					+ " AND A.APPLICATION_ID=NVL('"
					+ applicationid
					+ "',A.APPLICATION_ID)"
					+ " AND A.CLIENT_ID=B.CLIENT_ID AND A.CLIENT_ID=C.CLIENT_ID "
					+ " AND b.INBOUND_YN = 'Y' AND c.IN_USE_YN = 'Y' AND b.IN_USE_YN = 'Y' "
					+ " AND A.APPLICATION_ID=D.APPLICATION_ID "
					+ " AND A.APPLICATION_ID = C.APPLICATION_ID AND A.PROTOCOL_LINK=C.PROTOCOL_LINK"
					+ " AND C.PROTOCOL_LINK = PL.PROTOCOL_LINK_ID AND PL.PROTOCOL_ID = P.PROTOCOL_ID"
					+ " AND (A.APPLICATION_ID, A.START_DATE_TIME)  IN (SELECT APPLICATION_ID , MAX(START_DATE_TIME) FROM XH_COMM_PROCESS "
					+ " WHERE CLIENT_ID=NVL('"
					+ commclient
					+ "',CLIENT_ID) AND PROTOCOL_LINK=A.PROTOCOL_LINK AND PROCESS_TYPE ='I' GROUP BY  APPLICATION_ID,CLIENT_ID) "
					+ " UNION "
					+ " SELECT DISTINCT X.CLIENT_ID CLIENT_ID,Y.CLIENT_NAME CLIENT_NAME,X.APPLICATION_ID APPLICATION_ID,D.APPLICATION_NAME,NULL PROCESS_ID,NULL PROCESS_STATUS,TO_CHAR(NULL) START_DATE_TIME,"
					+ " X.MODIFIED_BY_ID MODIFIED_BY_ID,TO_CHAR(NULL)STOP_DATE_TIME,NULL LAST_OUTBOUND_RETRIES,X.PROTOCOL_LINK,NULL,NULL,NULL,NULL,'N' COMM_STATUS"
					+ " FROM XH_COMM_CLIENT_APPLICATION X,XH_COMM_CLIENT Y ,XH_APPLICATION D"
					+ " WHERE X.IN_USE_YN='Y'AND Y.INBOUND_YN='Y' AND X.CLIENT_ID  = Y.CLIENT_ID AND X.CLIENT_ID=NVL('"
					+ commclient
					+ "',X.CLIENT_ID) "
					+ " AND Y.IN_USE_YN='Y' AND X.COMM_TYPE='I' AND X.APPLICATION_ID=NVL('"
					+ applicationid
					+ "',X.APPLICATION_ID) "
					+ " AND X.APPLICATION_ID=D.APPLICATION_ID AND (X.APPLICATION_ID,NVL('"
					+ commclient
					+ "',X.CLIENT_ID),NVL(X.PROTOCOL_LINK,'~')) NOT IN (SELECT APPLICATION_ID,CLIENT_ID,NVL(PROTOCOL_LINK,'~') FROM XH_COMM_PROCESS WHERE PROCESS_TYPE='I')";

			hashmap = new HashMap();

			if (commtype.equals("")) {
				hashmap.put("outsql", outboundsql);
				hashmap.put("insql", inboundsql);
			}

			if (commtype.equals("O")) {
				hashmap.put("outsql", outboundsql);
				hashmap.put("insql", null);
			}

			if (commtype.equals("I")) {
				hashmap.put("outsql", null);
				hashmap.put("insql", inboundsql);
			}
		} catch (Exception exception) {
			write.fileOutput(filename,
					" (CentralizedMonitorApplication:constructSql()) Exception :"
							+ exception.toString() + "\n");
		}

		return hashmap;

	} // end of method constructSql

	// Method displayRecords
	public void displayRecords(String modetype) {
		try 
		{
			subPane.setDividerSize(8);
			subPane.setDividerLocation(300);

			outboundmodel = new CentralizedMainTableModel(outsql, modetype, "O", dataadapter, write, modeofinstall);
			inboundmodel = new CentralizedMainTableModel(insql, modetype, "I", dataadapter, write, modeofinstall);

			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
				//	fetchButton.setEnabled(true);
					startButton.setEnabled(true);
					refreshButton.setEnabled(true);
					stopButton.setEnabled(true);
					exitButton.setEnabled(true);
				}
			});

			outboundtable = returnJTable(outboundmodel);
			inboundtable = returnJTable(inboundmodel);

			outboundtable.addMouseListener(popupListener);
			inboundtable.addMouseListener(popupListener);			

			validateGUI(outboundtable, inboundtable);
			this.validate();
			this.setExtendedState(JFrame.MAXIMIZED_BOTH);
			this.setVisible(true);
		} 
		catch (Exception exception) 
		{
			write.fileOutput(filename,
					" (CentralizedMonitorApplication:displayRecords()) Exception: " + exception.toString() + "\n");
		}

	} // end of displayRecords

	// Method validateGUI
	public void validateGUI(JTable outboundtable, JTable inboundtable) {
		try {
			int outrow = 0;
			int inrow = 0;

			outrow = outboundtable.getRowCount();
			inrow = inboundtable.getRowCount();

			write.fileOutput(filename,
					" (CentralizedMonitorApplication:fetch) Outbound records :" + outrow + "\n");
			write.fileOutput(filename,
					" (CentralizedMonitorApplication:fetch) Inbound records :" + inrow + "\n");

			if ((outrow < 1) && (inrow < 1)) 
			{
				subPane.setDividerLocation(700);
				centrePanel = new JPanel();
				bottomPanel = new JPanel();

				centrePanel.setBackground(Color.LIGHT_GRAY);
				subPane.setTopComponent(centrePanel);
				subPane.setBottomComponent(bottomPanel);

				// mainPane.setBottomComponent(subPane);
				JOptionPane.showMessageDialog(this,
						"Query Caused No Records To Be Retrived..", "Info", JOptionPane.INFORMATION_MESSAGE);
			} 
			else if (inrow < 1) 
			{
				subPane.setDividerLocation(580);
				outscrollpane = new JScrollPane(outboundtable);
				centrePanel = new CentralizedOutBoundPanel(outscrollpane);
				bottomPanel = new JPanel();

				centrePanel.setBackground(Color.LIGHT_GRAY);
				// bottomPanel.setBackground(new Color(230,230,255));
				bottomPanel.setBackground(Color.LIGHT_GRAY);
				bottomPanel.add(barPanel, BorderLayout.NORTH);

				subPane.setTopComponent(centrePanel);
				subPane.setBottomComponent(bottomPanel);
				// mainPane.setBottomComponent(subPane);
			} 
			else if (outrow < 1) 
			{
				subPane.setDividerLocation(580);
				outscrollpane = new JScrollPane(outboundtable);
				inscrollpane = new JScrollPane(inboundtable);
				centrePanel = new CentralizedInBoundPanel(inscrollpane);
				centrePanel.setBackground(Color.LIGHT_GRAY);
				bottomPanel = new JPanel();

				centrePanel.setBackground(Color.LIGHT_GRAY);
				bottomPanel.setBackground(Color.LIGHT_GRAY);
				bottomPanel.add(barPanel, BorderLayout.NORTH);

				subPane.setTopComponent(centrePanel);
				subPane.setBottomComponent(bottomPanel);
				// mainPane.setBottomComponent(subPane);
			}
			/*
			 * else if((outrow > 1) && (inrow > 1)) {
			 * subPane.setDividerLocation(500); inscrollpane = new
			 * JScrollPane(inboundtable); centrePanel = new
			 * CentralizedInOutPanel(inscrollpane,outscrollpane);
			 * centrePanel.setBackground(Color.LIGHT_GRAY); bottomPanel = new
			 * JPanel();
			 * 
			 * centrePanel.setBackground(Color.LIGHT_GRAY);
			 * bottomPanel.setBackground(Color.LIGHT_GRAY);
			 * bottomPanel.add(barPanel,BorderLayout.NORTH);
			 * 
			 * subPane.setTopComponent(centrePanel);
			 * subPane.setBottomComponent(bottomPanel); }
			 */

		} catch (Exception exception) {
			write.fileOutput(filename,
					" (CentralizedMonitorApplication:validateGUI()) Exception :"
							+ exception.toString() + "\n");
			exception.printStackTrace(out);
		}

	}// end of validateGUI

	// Method returnJTable
	public JTable returnJTable(TableModel model) {
		JTable tmptable = null;
		try {
			String commtype = (String) ioField.getSelectedItem();

			tmptable = new JTable(model);
			TableColumn column = null;
			if (tmptable.getColumnCount() != 0) {
				for (int i = 0; i < tmptable.getColumnCount(); i++) {
					column = tmptable.getColumnModel().getColumn(i);
					
					if ((i == 0) || (i == 1) || (i == 2))
						column.setPreferredWidth(30);
					else if(i == 3 || i == 9 || i == 10 || i == 11) column.setPreferredWidth(60);
					else if((i == 4) || (i == 5) || (i == 6) || (i == 8) || (i == 12) || (i == 14)) 
						column.setPreferredWidth(110);					
					else if ((i == 7))
						column.setPreferredWidth(40);
					else if (i == 12 || i == 13)
						column.setPreferredWidth(100);
					else
						column.setPreferredWidth(140);

					// Removing retries column from inbound display records
					if (i == 7 && (commtype != null && commtype.equalsIgnoreCase("Inbound"))) {
						tmptable.removeColumn(column);
					}
				}
			}
			tmptable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tmptable.setPreferredScrollableViewportSize(new Dimension(1024, 350));
			tmptable.setDefaultRenderer(Color.class, new CentralizedColorTableCellRenderer());
			tmptable.setDefaultEditor(Color.class, new CentralizedColorTableCellEditor("P"));
			tmptable.getColumnModel().setColumnSelectionAllowed(false);
		} 
		catch (Exception exception) 
		{
			exception.printStackTrace();
			write.fileOutput(filename,
					" (CentralizedMonitorApplication:returnJTable()) Exception :" + exception.toString() + "\n");
		}
		return tmptable;

	}// end of returnJTable

	// method controlGateways
	public void controlGateways(String mode) {
		try {
			int outrow = 0;
			int inrow = 0;

			outrow = outboundtable.getRowCount();
			inrow = inboundtable.getRowCount();

			if ((outrow > 0) && (!mode.equalsIgnoreCase(""))) {
				if (mode.equalsIgnoreCase("S")) startOutboundGateways();
				else if (mode.equalsIgnoreCase("X")) stopOutboundGateways();
			}

			if ((inrow > 0) && (!mode.equalsIgnoreCase(""))) {
				if (mode.equalsIgnoreCase("S")) startInboundGateways();
				else if (mode.equalsIgnoreCase("X")) stopInboundGateways();
			}
		} catch (Exception exception) {
			write.fileOutput(filename,
					" (CentralizedMonitorApplication:controlGateways()) Exception :"
							+ exception.toString() + "\n");
		}
	}

	// End of controlGateways()

	// method startOutboundGateways
	public void startOutboundGateways() {
		try 
		{
			if (enabledForSelectedOperation(outboundtable)) 
			{
				String outbound[][] = (String[][]) dataadapter.outboundArray;
			//	String servicemode = (String)installField.getSelectedItem();
				String servicemode = getPropertyVal("C:/eHIS/config/properties.ini", "windowsservice");

				if (servicemode == null || "N".equalsIgnoreCase(servicemode))
					servicemode = "Without Service";
				else
					servicemode = "With Service";

				write.fileOutput(filename,
								" (CentralizedMonitorApplication:startOutboundGateways()) servicemode selected :"
										+ servicemode + "\n");

				CentralizedRemoteOBjectClass object = new CentralizedRemoteOBjectClass();

				HashMap hashmap = null;
				for (int i = 0; i < outboundtable.getRowCount(); i++) {
					Object obj = outboundtable.getValueAt(i, 0);

					if (obj.toString().equals("true")) {
						String clientid = (String) outbound[i][0];
						String applnid = (String) outbound[i][1];
						String facilityid = (String) outbound[i][2];
						String protocolLinkID = (String) outbound[i][4];
						String protcolLinkName = (String) outboundtable.getValueAt(i, 6);
						String clientName = (String) outboundtable.getValueAt(i, 4);

						String hl7userid = (this.usrname).toUpperCase();
					//	String hl7password = dataadapter.getPassword(hl7userid);
						String hl7password = password;

						write.fileOutput(filename,
									" (CentralizedMonitorApplication:startOutboundGateways()) hl7userid  :"
											+ hl7userid + "\n");
						write.fileOutput(filename,
									" (CentralizedMonitorApplication:startOutboundGateways()) hl7password  :"
											+ hl7password + "\n");

						String dbstring = dataadapter.getDbString();
						
						boolean isGatewayStarted = 
							dataadapter.checkGatewayStatus((String)outboundtable.getValueAt(i, 3));
						if (isGatewayStarted)
							write.fileOutput(filename,
											" (CentralizedMonitorApplication:startInboundGateways()) Gateway already running for "
													+ protcolLinkName
													+ " at "
													+ clientName + "\n");
						boolean dbConnExists = true;

						/*
						 * if(!isGatewayStarted) { dbConnExists =
						 * dataadapter.checkGatewayDBConnection(dbstring,hl7userid,hl7password); }
						 */
						dbConnExists = dataadapter.checkGatewayDBConnection(
								dbstring, hl7userid, hl7password);
						if (dbConnExists && !isGatewayStarted) {
							// String hl7userid =
							// (String)outboundtable.getValueAt(i,6);
							// String logoutdir =
							// dataadapter.getOutputDirectory(hl7userid,clientid);

							String ipaddress = dataadapter.getIpAddress(
									applnid, clientid, "O");
							String logoutdir = dataadapter.getOutputDirectory(
									clientid, applnid, facilityid,
									protocolLinkID);

							if (logoutdir == null || logoutdir.equals("")) {
								logoutdir = "C:/eHIS/reports/";
							}
							int procId = dataadapter.getProcessId();
							String flag = dataadapter.insertValues(procId,
									facilityid, clientid, applnid, "O",
									protocolLinkID);

							write.fileOutput(filename,
											" (CentralizedMonitorApplication:startOutboundGateways()) ------OUTBOUND GATEWAYS SELECTED---- \n");
							write.fileOutput(filename,
									" (CentralizedMonitorApplication:startOutboundGateways()) clientid  :"
											+ clientid + "\n");
							write.fileOutput(filename,
									" (CentralizedMonitorApplication:startOutboundGateways()) applnid  :"
											+ applnid + "\n");
							write.fileOutput(filename,
									" (CentralizedMonitorApplication:startOutboundGateways()) facilityid  :"
											+ facilityid + "\n");
							write.fileOutput(filename,
									" (CentralizedMonitorApplication:startOutboundGateways()) ipaddress  :"
											+ ipaddress + "\n");
							write.fileOutput(filename,
									" (CentralizedMonitorApplication:startOutboundGateways()) hl7userid  :"
											+ hl7userid + "\n");
							write.fileOutput(filename,
									" (CentralizedMonitorApplication:startOutboundGateways()) hl7password  :"
											+ hl7password + "\n");
							write.fileOutput(filename,
									" (CentralizedMonitorApplication:startOutboundGateways()) logoutdir  :"
											+ logoutdir + "\n");
							write.fileOutput(filename,
									" (CentralizedMonitorApplication:startOutboundGateways()) procId  :"
											+ procId + "\n");
							write.fileOutput(filename,
									" (CentralizedMonitorApplication:startOutboundGateways()) dbstring  :"
											+ dbstring + "\n");
							write.fileOutput(filename,
									" (CentralizedMonitorApplication:startOutboundGateways()) Protocol LinkID  :"
											+ protocolLinkID + "\n");
							write.fileOutput(filename,
											" (CentralizedMonitorApplication:startOutboundGateways()) xh_coMM_process insertion flaG  :"
													+ flag + "\n");

							hashmap = new HashMap();
							hashmap.put("applnId", applnid);
							hashmap.put("facilityId", facilityid);
							hashmap.put("client_id", clientid);
							hashmap.put("commtype", "O");
							hashmap.put("out_dir", logoutdir);
							hashmap.put("procId", new Integer(procId));
							hashmap.put("db_string", dbstring);
							hashmap.put("user_id", hl7userid);
							hashmap.put("pass_word", hl7password);
							hashmap.put("retryinterval", "9999");
							hashmap.put("servicemode", servicemode);
							hashmap.put("protocolLinkID", protocolLinkID); // Modified
																			// 11/23/2007

							write.fileOutput(filename,
									" (CentralizedMonitorApplication:startOutboundGateways()) hashmap: "
											+ hashmap + "\n");
							remoteObject = (CentralizedRemote) object.remoteObject(ipaddress.trim());
							// remoteObject=(CentralizedRemote)object.remoteObject(clientid);
							write.fileOutput(filename,
									" (CentralizedMonitorApplication:startOutboundGateways()) remoteObject: "
											+ remoteObject + "\n");

							if (remoteObject != null) {
								String status = remoteObject.startHl7Gateway(hashmap);
								write.fileOutput(filename,
										" (CentralizedMonitorApplication:startOutboundGateways()) status  :"
												+ status + "\n");
								JOptionPane.showMessageDialog(this, "" + status + "", "",
										JOptionPane.INFORMATION_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(
												this,
												"HL7Gateway not Started... Unable to find Remote Service !!",
												"Info",
												JOptionPane.INFORMATION_MESSAGE);
							}
						} else if (!dbConnExists) {
							JOptionPane.showMessageDialog(
											this,
											"Gateway Database connection does not exist",
											"Info",
											JOptionPane.INFORMATION_MESSAGE);
						} else if (isGatewayStarted) {
							JOptionPane.showMessageDialog(this, protcolLinkName
									+ " gateway already running at "
									+ clientName, "Info",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			} else {
				write.fileOutput(
								filename,
								" (CentralizedMonitorApplication:startOutboundGateways()) No Gateways Are selected To Start..!!! \n");
				JOptionPane.showMessageDialog(this,
						"No Gateways Are selected To Start..!!!", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		} catch (Exception ex) {
			write.fileOutput(filename,
					" (CentralizedMonitorApplication:startOutboundGateways()) Exception :"
							+ ex.toString() + "\n");
			ex.printStackTrace(out);
		}
	}

	// End of startOutboundGateways()

	// method startOutboundGateways
	public void startInboundGateways() {
		try {			
			if (enabledForSelectedOperation(inboundtable)) {
				String inbound[][] = (String[][]) dataadapter.inboundArray;			
				// String servicemode = (String)installField.getSelectedItem();
				String servicemode = getPropertyVal(
						"C:/eHIS/config/properties.ini", "windowsservice");

				if (servicemode == null || "N".equalsIgnoreCase(servicemode))
					servicemode = "Without Service";
				else
					servicemode = "With Service";

				write.fileOutput(filename,
								" (CentralizedMonitorApplication:startInboundGateways()) servicemode selected :"
										+ servicemode + "\n");

				CentralizedRemoteOBjectClass object = new CentralizedRemoteOBjectClass();
				CentralizedRemote remoteObject = null;
				HashMap hashmap = null;
				for (int i = 0; i < inboundtable.getRowCount(); i++) {
					Object obj = inboundtable.getValueAt(i, 0);

					if (obj.toString().equals("true")) {
						
						// String
						// logoutdir=dataadapter.getOutputDirectory(hl7userid,clientid);
						// String
						// hl7userid=(String)inboundtable.getValueAt(i,6);

						String clientid = (String) inbound[i][0];
						String applnid = (String) inbound[i][1];
						String facilityid = (String) inbound[i][2];
						String protocolLinkID = (String) inbound[i][4]; // Modified 30/05/2009
						String protcolLinkName = (String) inboundtable.getValueAt(i, 6);
						String clientName = (String) inboundtable.getValueAt(i, 4);

						String hl7userid = (this.usrname).toUpperCase();
					//	String hl7password = dataadapter.getPassword(hl7userid);
						String hl7password = password;
						String dbstring = dataadapter.getDbString();

						// boolean isGatewayStarted =
						// dataadapter.checkGatewayStatus(clientid,"I",protocolLinkID);
						boolean isGatewayStarted = 
							dataadapter.checkGatewayStatus((String)inboundtable.getValueAt(i, 3));
						if (isGatewayStarted)
							write.fileOutput(filename,
											" (CentralizedMonitorApplication:startInboundGateways()) Gateway already running for "
													+ protcolLinkName + " at " + clientName + "\n");
						boolean dbConnExists = true;

						/*
						 * if(!isGatewayStarted) { dbConnExists =
						 * dataadapter.checkGatewayDBConnection(dbstring,hl7userid,hl7password); }
						 */
						dbConnExists = dataadapter.checkGatewayDBConnection(dbstring, hl7userid, hl7password);

						if (dbConnExists && !isGatewayStarted) {
							String ipaddress = dataadapter.getIpAddress(
									applnid, clientid, "I");
							String logoutdir = dataadapter.getOutputDirectory(
									clientid, applnid, facilityid,
									protocolLinkID);

							if (logoutdir == null || logoutdir.equals("")) {
								logoutdir = "C:/eHIS/reports/";
							}
							int procId = dataadapter.getProcessId();
							String flag = dataadapter.insertValues(procId,
									facilityid, clientid, applnid, "I",
									protocolLinkID);

							write.fileOutput(filename,
											" (CentralizedMonitorApplication:startInboundGateways()) ------INBOUND GATEWAYS SELECTED---- \n");
							write.fileOutput(filename,
									" (CentralizedMonitorApplication:startInboundGateways()) clientid  :"
											+ clientid + "\n");
							write.fileOutput(filename,
									" (CentralizedMonitorApplication:startInboundGateways()) applnid  :"
											+ applnid + "\n");
							write.fileOutput(filename,
									" (CentralizedMonitorApplication:startInboundGateways()) facilityid  :"
											+ facilityid + "\n");
							write.fileOutput(filename,
									" (CentralizedMonitorApplication:startInboundGateways()) ipaddress  :"
											+ ipaddress + "\n");
							write.fileOutput(filename,
									" (CentralizedMonitorApplication:startInboundGateways()) hl7userid  :"
											+ hl7userid + "\n");
							write.fileOutput(filename,
									" (CentralizedMonitorApplication:startInboundGateways()) hl7password  :"
											+ hl7password + "\n");
							write.fileOutput(filename,
									" (CentralizedMonitorApplication:startInboundGateways()) logoutdir  :"
											+ logoutdir + "\n");
							write.fileOutput(filename,
									" (CentralizedMonitorApplication:startInboundGateways()) procId  :"
											+ procId + "\n");
							write.fileOutput(filename,
									" (CentralizedMonitorApplication:startInboundGateways()) dbstring  :"
											+ dbstring + "\n");
							write.fileOutput(filename,
									" (CentralizedMonitorApplication:startInboundGateways()) Protocol LinkID  :"
											+ protocolLinkID + "\n");
							write
									.fileOutput(
											filename,
											" (CentralizedMonitorApplication:startInboundGateways()) xh_coMM_process insertion flaG  :"
													+ flag + "\n");

							hashmap = new HashMap();
							hashmap.put("applnId", applnid);
							hashmap.put("facilityId", facilityid);
							hashmap.put("client_id", clientid);
							hashmap.put("commtype", "I");
							hashmap.put("out_dir", logoutdir);
							hashmap.put("procId", new Integer(procId));
							hashmap.put("db_string", dbstring);
							hashmap.put("user_id", hl7userid);
							hashmap.put("pass_word", hl7password);
							hashmap.put("retryinterval", "9999");
							hashmap.put("servicemode", servicemode);
							hashmap.put("protocolLinkID", protocolLinkID); // Modified
																			// 11/24/2007
							write.fileOutput(filename,
									" (CentralizedMonitorApplication:startInboundGateways()) hashmap  :"
											+ hashmap + "\n");
							remoteObject = (CentralizedRemote) object
									.remoteObject(clientid);
							write.fileOutput(filename,
									" (CentralizedMonitorApplication:startInboundGateways()) remoteObject  :"
											+ remoteObject + "\n");

							if (remoteObject != null) {
								String status = remoteObject
										.startHl7Gateway(hashmap);
								write.fileOutput(filename,
										" (CentralizedMonitorApplication:startInboundGateways()) status  :"
												+ status + "\n");
								JOptionPane.showMessageDialog(this, "" + status
										+ "", "INFO",
										JOptionPane.INFORMATION_MESSAGE);
							} else {
								JOptionPane
										.showMessageDialog(
												this,
												"HL7Gateway not Started... Unable to find Remote Service !!",
												"",
												JOptionPane.INFORMATION_MESSAGE);
							}
						} else if (!dbConnExists) {
							JOptionPane
									.showMessageDialog(
											this,
											"Gateway Database connection does not exist",
											"Info",
											JOptionPane.INFORMATION_MESSAGE);
						} else if (isGatewayStarted) {
							JOptionPane.showMessageDialog(this, protcolLinkName
									+ " gateway already running at "
									+ clientName, "Info",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			} else {
				write
						.fileOutput(
								filename,
								" (CentralizedMonitorApplication:startInboundGateways()) No Inbound Gateways Are selected To Start..!!! n");
				JOptionPane.showMessageDialog(this,
						"No Inbound Gateways Are selected To Start..!!!",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception ex) {
			write.fileOutput(filename,
					" (CentralizedMonitorApplication:startInboundGateways()) Exception :"
							+ ex.toString() + "\n");
			ex.printStackTrace(out);
		}

	}

	// End of startInboundGateways()

	// method stopOutboundGateways
	public void stopOutboundGateways() {
		try {
			if (enabledForSelectedOperation(outboundtable)) {
				String outbound[][] = (String[][]) dataadapter.outboundArray;
				// String servicemode = (String)installField.getSelectedItem();
				String servicemode = getPropertyVal(
						"C:/eHIS/config/properties.ini", "windowsservice");

				if (servicemode == null || "N".equalsIgnoreCase(servicemode))
					servicemode = "Without Service";
				else
					servicemode = "With Service";

				write.fileOutput(filename,
								" (CentralizedMonitorApplication:stopOutboundGateways()) \n");

				for (int i = 0; i < outboundtable.getRowCount(); i++) {
					Object obj = outboundtable.getValueAt(i, 0);
					if (obj.toString().equals("true")) {
						boolean stopstatus = false;
						String processid = (String) outboundtable.getValueAt(i, 3);
						String applnid = (String) outbound[i][1];
						String facilityid = (String) outbound[i][2];

						write.fileOutput(filename,
								" (CentralizedMonitorApplication:stopOutboundGateways()) processid :"
										+ processid + "\n");
						write.fileOutput(filename,
								" (CentralizedMonitorApplication:stopOutboundGateways()) applnid :"
										+ applnid + "\n");
						write.fileOutput(filename,
								" (CentralizedMonitorApplication:stopOutboundGateways()) facilityid :"
										+ facilityid + "\n");
						write.fileOutput(filename,
								" (CentralizedMonitorApplication:stopOutboundGateways()) servicemode :"
										+ servicemode + "\n");
						write.fileOutput(filename,
										" (CentralizedMonitorApplication:stopOutboundGateways()) Before calling dataadapter.setStopProcess\n");

						stopstatus = dataadapter.setStopProcess(applnid,
								facilityid, processid, "O", servicemode);

						write.fileOutput(filename,
										" (CentralizedMonitorApplication:stopOutboundGateways()) After calling dataadapter.setStopProcess\n");

						if (stopstatus) {
							JOptionPane.showMessageDialog(this,
									"HL7Gateway Stopped Sucessfully", "INFO",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(this,
									"Stopping HL7Gateway is Failed....! ",
									"ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			} else {
				write.fileOutput(filename,
								" (CentralizedMonitorApplication:stopOutboundGateways()) No Inbound Gateways Are selected To Stop..!!! \n");
				JOptionPane.showMessageDialog(this,
						"No Outbound Gateways Are selected To Stop..!!!",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception ex) {
			write.fileOutput(filename,
					" (CentralizedMonitorApplication:stopOutboundGateways()) Exception :"
							+ ex.toString() + "\n");
			ex.printStackTrace(out);
		}
	}

	// End of stopOutboundGateways()

	// method stopInboundGateways
	public void stopInboundGateways() {
		try {
			write.fileOutput(filename,
							" (CentralizedMonitorApplication:stopInboundGateways()) inside stopInboundGateways\n");

			if (enabledForSelectedOperation(inboundtable)) {
				String inbound[][] = (String[][]) dataadapter.inboundArray;
				// String servicemode=(String)installField.getSelectedItem();

				String servicemode = getPropertyVal(
						"C:/eHIS/config/properties.ini", "windowsservice");

				if (servicemode == null || "N".equalsIgnoreCase(servicemode))
					servicemode = "Without Service";
				else
					servicemode = "With Service";

				for (int i = 0; i < inboundtable.getRowCount(); i++) {
					Object obj = inboundtable.getValueAt(i, 0);
					if (obj.toString().equals("true")) {
						boolean stopstatus = false;
						String processid = (String) inboundtable.getValueAt(i, 3);
						String applnid = (String) inbound[i][1];
						String facilityid = (String) inbound[i][2];
						write.fileOutput(filename,
								" (CentralizedMonitorApplication:stopInboundGateways()) processid :"
										+ processid + "\n");
						write.fileOutput(filename,
								" (CentralizedMonitorApplication:stopInboundGateways()) applnid :"
										+ applnid + "\n");
						write.fileOutput(filename,
								" (CentralizedMonitorApplication:stopInboundGateways()) facilityid :"
										+ facilityid + "\n");
						write.fileOutput(filename,
								" (CentralizedMonitorApplication:stopInboundGateways()) servicemode :"
										+ servicemode + "\n");
						write.fileOutput(filename,
										" (CentralizedMonitorApplication:stopInboundGateways()) Before calling dataadapter.setStopProcess\n");
						stopstatus = dataadapter.setStopProcess(applnid,
								facilityid, processid, "I", servicemode);
						write.fileOutput(filename,
										" (CentralizedMonitorApplication:stopInboundGateways()) After calling dataadapter.setStopProcess\n");
						if (stopstatus) {
							JOptionPane.showMessageDialog(this,
									"HL7Gateway Stopped Sucessfully", "INFO",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(this,
									"Stopping HL7Gateway is Failed....! ",
									"ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
				}

			} else {
				write.fileOutput(filename,
								" (CentralizedMonitorApplication:stopInboundGateways()) No Inbound Gateways Are selected To Stop..!!!\n");
				JOptionPane.showMessageDialog(this,
						"No Inbound Gateways Are selected To Stop..!!!",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception ex) {
			write.fileOutput(filename,
					" (CentralizedMonitorApplication:stopInboundGateways()) Exception :"
							+ ex.toString() + "\n");
			ex.printStackTrace(out);
		}
	}

	// End of stopInboundGateways()

	// Method checks whether the current record's check box is selected or not
	public boolean enabledForSelectedOperation(JTable table) {
		boolean isEnabled = false;
		try {
			for (int i = 0; i < table.getRowCount(); i++) {
				Object obj = table.getValueAt(i, 0);
				if (obj.toString().equals("true")) {
					isEnabled = true;
					break;
				}
			}
		} catch (Exception exception) {
			write.fileOutput(filename,
					" (CentralizedMonitorApplication:enabledForSelectedOperation()) Exception :"
							+ exception.toString() + "\n");
		}
		return isEnabled;
	}

	// End of enabledForSelectedOperation()

	// method actionPerformed
	public void actionPerformed(ActionEvent actionevent) {
		Object source = actionevent.getSource();
		try {

			if (initStart == 0) 
			{
				initStart = 1;
				GregorianCalendar today = new GregorianCalendar();
				int temp = today.get(Calendar.HOUR_OF_DAY);
				lastFileGenTime = temp;
				lastFileGenTimeInMillis = System.currentTimeMillis();
			} 
			else 
			{
				getLogFilename();
			}			

			/** 
			 * Checking for DB Connection for every action from the user.
			 * If the connection does not exist, alert will be shown to the user.
			 */ 
			boolean isDBConnExists = dataadapter.checkDBConnection();

			if (isDBConnExists) 
			{
				// To disable all the buttons until the page has been loaded with the appropriate action is done.

				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
					//	fetchButton.setEnabled(false);
						startButton.setEnabled(false);
						refreshButton.setEnabled(false);
						stopButton.setEnabled(false);
						exitButton.setEnabled(false);
					}
				});

				// query button logic
			/*	if (source == fetchButton) {
					fetch();
					displayRecords("F");
				}
			*/													
				if (source == refreshButton) 
				{
					fetch();
					displayRecords("R");
				}
				else if (source == startButton) 
				{
					controlGateways("S");
					displayRecords("R");
				}
				else if (source == stopButton) 
				{
					controlGateways("X");
					displayRecords("R");
				}
				else if (source == exitButton) 
				{
					write.fileOutput(filename,
									" (CentralizedMonitorApplication:actionPerformed) Closing Centralized Interface Gateway Monitor \n");
					write.fileOutput(filename, line.getBytes(), line.getBytes().length);
					this.dispose();
					System.exit(0);
				}
			} 
			else 
			{
				JOptionPane.showMessageDialog(this,
						" Database Connection Failed !!", "Error", JOptionPane.ERROR_MESSAGE);
				write.fileOutput(filename,
								" (CentralizedMonitorApplication:constructor) Database Connection Failed :"
										+ dburl + ":" + usrname + "\n");
				//	System.exit(0);
			}

			if (source == menuItem) 
			{	
				String commtype = (String) ioField.getSelectedItem();
				String dataArray[][];
				String processID;
				TableColumn column;				

				if("Outbound".equals(commtype))
				{
					rowSel = outboundtable.rowAtPoint(popupListener.pointer);
					dataArray = (String[][]) dataadapter.outboundArray;	
					processID = (String) outboundtable.getValueAt(rowSel, 3);
					column = outboundtable.getColumnModel().getColumn(3);
				}
				else
				{
					rowSel = inboundtable.rowAtPoint(popupListener.pointer);
					dataArray = (String[][]) dataadapter.inboundArray;
					processID = (String) inboundtable.getValueAt(rowSel, 3);
					column = inboundtable.getColumnModel().getColumn(3);
				}

				String clientID = (String) dataArray[rowSel][0];
				String applicationID = (String) dataArray[rowSel][1];
				String facilityID = (String) dataArray[rowSel][2];
				String protocolLinkID = (String) dataArray[rowSel][4];

				Color bgColor = Color.white;
				Color foreGrndColor = Color.black;
				
				HashMap map = checkServiceStatus(clientID, applicationID, facilityID, processID);

				if(map != null)
				{
					boolean install = ((Boolean)map.get("install")).booleanValue();
					boolean start = ((Boolean)map.get("start")).booleanValue();
					boolean stop = ((Boolean)map.get("stop")).booleanValue();								

					if(stop) 
					{
						bgColor = Color.red;
						foreGrndColor = Color.black;
					}
					else if(start)
					{
						bgColor = Color.green;
						foreGrndColor = Color.black;
					}
					else if(install)
					{
						bgColor = Color.black;
						foreGrndColor = Color.white;
					}					 					
				}
				else
				{
					bgColor = Color.black;
					foreGrndColor = Color.white;
				}
				
				column.setCellRenderer(new CustomTableCellRenderer(rowSel, bgColor, foreGrndColor));
				if("Outbound".equals(commtype)) outboundtable.repaint();
				else inboundtable.repaint();

				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
					//	fetchButton.setEnabled(true);
						startButton.setEnabled(true);
						refreshButton.setEnabled(true);
						stopButton.setEnabled(true);
						exitButton.setEnabled(true);
					}
				});
			}
		} 
		catch (Exception exception) 
		{
			write.fileOutput(filename,
					" (CentralizedMonitorApplication:actionPerformed()) Exception :" + exception.toString() + "\n");
		}
	} //end of method actionperformed

	void getLogFilename() {
		try {
			GregorianCalendar today = new GregorianCalendar();
			int temp = today.get(Calendar.HOUR_OF_DAY);
			if (temp < lastFileGenTime
					|| (System.currentTimeMillis() - lastFileGenTimeInMillis) >= 86400000) {
				File curFileName = new File(filename);
				String strRenameFile = "c:/ehis/reports/CentralizedMonitor_" + getFormattedStringDate("ddMMyyyy", new Date()) + ".log";
				File renameFileTo = new File(strRenameFile);
				boolean purge = curFileName.renameTo(renameFileTo);
				if (purge) {
					write.fileOutput(filename,
							" (CentralizedMonitorApplication:getLogFilename) Log file purged to :"
									+ strRenameFile + "\n");
				} else {
					write.fileOutput(filename,
									" (CentralizedMonitorApplication:getLogFilename) Unable to purge log file \n");
				}
				lastFileGenTime = temp;
				lastFileGenTimeInMillis = System.currentTimeMillis();
			}
		} catch (Exception exp) {
			exp.printStackTrace(out);
		}
	}

	/**
	 * Method returns java.util.Date in the specified string format
	 */
	public String getFormattedStringDate(String format, java.util.Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		String dateFormatted = dateFormat.format(date);
		return dateFormatted;
	}

	/**
	 * Method retreives the specified property value from the specified property file.
	 */
	private String getPropertyVal(String fileName, String property) {
		Properties configProperties = new Properties();
		String propVal = null;

		try 
		{
			try 
			{
				configProperties.load(new FileInputStream(fileName));
			} 
			catch (FileNotFoundException exp) 
			{
				System.out.println(exp);
				write.fileOutput(filename,
						" (CentralizedMonitorApplication:getPropertyVal) Exception: " + exp + "\n");
				configProperties.load(new FileInputStream("c:/ehis/reports/properties.ini"));
			}

			propVal = configProperties.getProperty(property);
		} catch (Exception exp) {
			System.out.println(exp);
			write.fileOutput(filename,
					" (CentralizedMonitorApplication:getPropertyVal) Exception: " + exp + "\n");
		}
		return propVal;
	}

	/**
	 * Method checks the current status of the selected gateway.
	 * Checks whether the service is installed or not at the clientID and its current status.
	 */
	public HashMap checkServiceStatus(String clientID, String applicationID, String facilityID, String processID)
	{
		CentralizedRemote remoteObject = null;
		CentralizedRemoteOBjectClass remote = new CentralizedRemoteOBjectClass();
		HashMap map = null;

		try
		{
			remoteObject = (CentralizedRemote)remote.remoteObject(clientID);
			if(remoteObject != null) map = remoteObject.chkServiceStatus(applicationID, facilityID, processID);
		}
		catch(Exception exp)
		{
			write.fileOutput(filename,
					" (CentralizedMonitorApplication:checkServiceStatus) Exception: " + exp + "\n");
		}
		return map;
	}

	/**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("PopupMenuDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create/set menu bar and content pane.
       // PopupMenuDemo demo = new PopupMenuDemo();
       // frame.setJMenuBar(demo.createMenuBar());
       // frame.setContentPane(demo.createContentPane());

        //Create and set up the popup menu.
        this.createPopupMenu();

        //Display the window.
        frame.setSize(450, 260);
        frame.setVisible(true);
    }

	public void createPopupMenu() {        
        JPopupMenu popup = new JPopupMenu();
        menuItem = new JMenuItem("Check Service Status");
        menuItem.addActionListener(this);
        popup.add(menuItem);        
        popupListener = new PopupListener(popup);
    }

}// end of class

class PopupListener extends MouseAdapter {
        JPopupMenu popup;
		Point pointer;

        PopupListener(JPopupMenu popupMenu) {
            popup = popupMenu;
        }

        public void mousePressed(MouseEvent e) {
            maybeShowPopup(e);
        }

        public void mouseReleased(MouseEvent e) {
            maybeShowPopup(e);
        }

        private void maybeShowPopup(MouseEvent e) {			
            if (e.isPopupTrigger()) {
				pointer = e.getPoint();
                popup.show(e.getComponent(),
                           e.getX(), e.getY());
            }
        }
    }

class CustomTableCellRenderer extends DefaultTableCellRenderer 
{
	int rowSel;
	Color bgColor;
	Color foreGrndColor;

	public CustomTableCellRenderer(int rowSel, Color color, Color foreGrndColor)
	{
		this.rowSel = rowSel;
		this.bgColor = color;
		this.foreGrndColor = foreGrndColor;
	}

    public Component getTableCellRendererComponent
       (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
    {			
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
		if(row == rowSel)
		{			
			cell.setBackground(bgColor);
			cell.setForeground(foreGrndColor);
		//	rowSel = -1;
		}
		else
		{			
			cell.setBackground(Color.white);
			cell.setForeground(Color.black);
		}

        return cell;
    }
}