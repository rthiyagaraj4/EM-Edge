/*
	Developed by  : Balachander R.R.
	Created on    : 26/03/2003
	Modified on	  : 05/12/2009 - Added new connection checkbox feature
*/
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.InetAddress;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import HL7Engine.Common.InterfaceUtil;
import HL7Simulator.Common.Common;
import HL7Simulator.QuerySimulator.ClientApplication;

public class QuerySimulator  extends JFrame implements ActionListener {

	Common common = new Common() ;

	FlowLayout flowLayout1 = new FlowLayout(FlowLayout.LEFT);
	JScrollPane jScrollPane1 = new JScrollPane();
	JTextArea txtaQryOutput = new JTextArea("");
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JCheckBox chkBox = new JCheckBox("NewConn.", true);

	JTextField txtIPAddr = new JTextField("", 10);
	JTextField txtPortNo = new JTextField("",5);
	JPanel jPanel1 = new JPanel();
	JTextField txtQueryFile = new JTextField("c:/eHIS/interface/query/Qry1.txt",30);
	JPanel jPanel2 = new JPanel();
	JLabel jLabel4 = new JLabel();
	JTextField txtRespFile = new JTextField("c:/eHIS/interface/response/Qry1Response.txt",30);
	JScrollPane jScrollPane2 = new JScrollPane();
	JTextArea txtaRespOutput = new JTextArea("");
	JPanel jPanel3 = new JPanel();
	JButton btnSendQuery = new JButton();
	JButton btnExit = new JButton();
	JLabel jLabel5 = new JLabel();

	ClientApplication application = null;

	public QuerySimulator (String msg) {
		super(msg);
		try  
		{
			jbInit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		try
		{
			String emSetupDir = InterfaceUtil.getIntSetupDir();
	    	String qryReqFile = emSetupDir + "/query/Qry1.txt";
	    	String qryResFile = emSetupDir + "/Response/Qry1Response.txt";
	    	txtQueryFile.setText(qryReqFile);
	    	txtRespFile.setText(qryResFile);
			InetAddress inetaddr = InetAddress.getLocalHost() ;
			txtIPAddr.setText( inetaddr.getHostAddress() );
		} 
		catch (Exception e) 
		{
			System.out.println("Exception while getting Inet Address :"+e) ;
			System.exit(0) ;
		}
		jLabel1.setText("Port No");
		jLabel2.setText("Query File");
		jLabel3.setText("IP Address");
		jLabel4.setText("Response File");
		jScrollPane2.setPreferredSize(new Dimension(790, 250));
		btnSendQuery.setText("Send Query");
		btnExit.setText("     Exit      ");
		jLabel5.setText("                                                                 " +
		"                          ");
		jLabel5.setForeground(SystemColor.scrollbar);
		this.setTitle("Query Simulator");
		this.getContentPane().setLayout(flowLayout1);
		this.setSize(new Dimension(767, 458));
		flowLayout1.setVgap(2);
		flowLayout1.setHgap(2);
		jScrollPane1.setPreferredSize(new Dimension(790, 150));
		this.getContentPane().add(jPanel1, null);
		jPanel1.add(jLabel3, null);
		jPanel1.add(txtIPAddr, null);
		jPanel1.add(jLabel1, null);
		jPanel1.add(txtPortNo, null);
		jPanel1.add(jLabel2, null);
		jPanel1.add(txtQueryFile, null);
		jPanel1.add(chkBox);
		this.getContentPane().add(jScrollPane1, null);
		txtaQryOutput.setLineWrap( true );
		txtaQryOutput.setWrapStyleWord( false );
		txtaQryOutput.setEditable( false );
		jScrollPane1.getViewport().add(txtaQryOutput, null);
		this.getContentPane().add(jPanel2, null);
		jPanel2.add(jLabel4, null);
		jPanel2.add(txtRespFile, null);    
		this.getContentPane().add(jScrollPane2, null);
		txtaRespOutput.setLineWrap( true );
		txtaRespOutput.setWrapStyleWord( false );
		txtaRespOutput.setEditable( false );
		jScrollPane2.getViewport().add(txtaRespOutput, null);
		this.getContentPane().add(jPanel3, null);
		jPanel3.add(jLabel5, null);
		jPanel3.add(btnSendQuery, null);
		jPanel3.add(btnExit, null);
		jScrollPane1.getViewport();

		btnSendQuery.addActionListener(this);
		btnExit.addActionListener(this);

		setSize(800,550);
		setResizable(false);
	//	setLocation(7,7);
		show();
	}

	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();
		if(source == btnSendQuery) {
			String txtipaddr = txtIPAddr.getText().trim();
			String portno = txtPortNo.getText().trim();
			String qryfile = txtQueryFile.getText().trim();
			String respfile = txtRespFile.getText().trim();
			boolean newConn = chkBox.isSelected();
			System.out.println("New Connection "+newConn);

			if( !proceed( txtipaddr, portno, qryfile, respfile ) ) return;

			File file = new File(qryfile);
			if(file.exists()) {
				GregorianCalendar gregorianCal = new GregorianCalendar();
				String strDateTime = gregorianCal.get(Calendar.DAY_OF_MONTH)+"/"+(gregorianCal.get(Calendar.MONTH)+1)+"/"+
				gregorianCal.get(Calendar.YEAR)+" "+
				gregorianCal.get(Calendar.HOUR_OF_DAY)+":"+
				gregorianCal.get(Calendar.MINUTE)+":"+
				gregorianCal.get(Calendar.SECOND);

				common.addServerOutput( txtaQryOutput, "Query process started on : "+strDateTime+"\n" );

				try {
					if(!newConn && (application != null))
					{
						try
						{
							System.out.println("Application");
							application.sendMessage(qryfile);
						}
						catch(Exception exp)
						{
							exp.printStackTrace();
						}
					}
					else
					{
						application = new ClientApplication(txtipaddr, Integer.parseInt(portno), qryfile, respfile, txtaQryOutput, txtaRespOutput );
					}
				} catch(Exception exception) {
					System.out.println(" General Exception in Simulator Server :"+exception);
				}
			} else {
				common.addServerOutput( txtaQryOutput, "Query file does not exists\n" );
			}
		}
		else if(source==btnExit) {
			System.out.println(" Quiting query processing. ") ;
			System.exit(0);
		}
	}

	public boolean proceed( String txtipaddr, String portno, String qryfile, String respfile ) 
	{
		if( txtipaddr == null || txtipaddr.equals("") ) {
			JOptionPane.showMessageDialog(this, "IP Address cannot be blank..", "Error", JOptionPane.ERROR_MESSAGE);	
			return false ;
		}

		if( portno == null || portno.equals("") ) {
			JOptionPane.showMessageDialog(this, "Port No. cannot be blank..", "Error", JOptionPane.ERROR_MESSAGE);	
			return false ;
		}

		try	{
		//	int num = Integer.parseInt(portno) ;
		} catch (NumberFormatException nfe)	{
			JOptionPane.showMessageDialog(this, "Not a valid Port No..", "Error", JOptionPane.ERROR_MESSAGE);	
			return false ;
		}

		if( qryfile == null || qryfile.equals("") ) {
			JOptionPane.showMessageDialog(this, "Query File cannot be blank..", "Error", JOptionPane.ERROR_MESSAGE);	
			return false ;
		}

		File file1 = new File( qryfile );
		if( !file1.exists() ) {
			JOptionPane.showMessageDialog(this, "Not a valid Query File..", "Error", JOptionPane.ERROR_MESSAGE);	
			return false;
		}

		if( respfile == null || respfile.equals("") ) {
			JOptionPane.showMessageDialog(this, "Response File cannot be blank..", "Error", JOptionPane.ERROR_MESSAGE);	
			return false ;
		}

		return true ;
	}

	public static void main(String[] args)
	{
		new QuerySimulator ("Query Simulator").addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		}
		);
	}
}