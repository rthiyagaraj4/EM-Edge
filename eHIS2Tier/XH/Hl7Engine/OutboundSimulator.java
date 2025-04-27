/*
	Developed by  : Balachander R.R.
	Created on    : 26/03/2003
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

public class OutboundSimulator extends JFrame implements ActionListener {

  Common common = new Common() ;
  HL7Simulator.OutboundSimulator.Listener listener = new HL7Simulator.OutboundSimulator.Listener() ;

  boolean started = false ;
  FlowLayout flowLayout1 = new FlowLayout(FlowLayout.LEFT);
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea txtaSvrOutput = new JTextArea("");
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();

  JTextField txtIPAddr = new JTextField("", 10);
  JTextField txtPortNo = new JTextField("",5);
  JPanel jPanel1 = new JPanel();
  JTextField txtRecvFldr = new JTextField("",30);
  JCheckBox ackChkBox = new JCheckBox("Ack", true);
  JPanel jPanel2 = new JPanel();
  JLabel jLabel4 = new JLabel();
  JTextField txtAckFldr = new JTextField("",30);
  JScrollPane jScrollPane2 = new JScrollPane();
  JTextArea txtaAckOutput = new JTextArea("");
  JPanel jPanel3 = new JPanel();
  JButton btnStartServer = new JButton();
  JButton btnStopServer = new JButton();
  JButton btnExit = new JButton();
  JLabel jLabel5 = new JLabel();

  public OutboundSimulator(String msg) {
	super(msg);
    try  {
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
    	String receiveDir = emSetupDir + "/Receive";
    	String defAckFile = emSetupDir + "/ACK/ListenerAck.txt";
    	txtAckFldr.setText(defAckFile);
    	txtRecvFldr.setText(receiveDir);
		InetAddress inetaddr = InetAddress.getLocalHost() ;
		txtIPAddr.setText(inetaddr.getHostAddress());
		txtIPAddr.setEnabled(false);
	} 
    catch (Exception e) 
    {
		System.out.println("Exception while getting Inet Address :"+e) ;
		System.exit(0) ;
	}
    jLabel1.setText("Port no");
    jLabel2.setText("Receive Folder");
    jLabel3.setText("IP Address");
    jLabel4.setText("Acknowledge File");
    jScrollPane2.setPreferredSize(new Dimension(790, 100));
    btnStartServer.setText("Start Server");
    btnStopServer.setText("Stop Server");
    btnExit.setText("     Exit      ");
    jLabel5.setText("                                                                 " +
    "                                   ");
    jLabel5.setForeground(SystemColor.scrollbar);
    this.setTitle("Outbound Simulator");
    this.getContentPane().setLayout(flowLayout1);
    this.setSize(new Dimension(767, 458));
    flowLayout1.setVgap(2);
    flowLayout1.setHgap(2);
    jScrollPane1.setPreferredSize(new Dimension(790, 300));
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(jLabel3, null);
    jPanel1.add(txtIPAddr, null);
    jPanel1.add(jLabel1, null);
    jPanel1.add(txtPortNo, null);
    jPanel1.add(jLabel2, null);
    jPanel1.add(txtRecvFldr, null);
    jPanel1.add(ackChkBox);
    this.getContentPane().add(jScrollPane1, null);
	txtaSvrOutput.setLineWrap( true );
	txtaSvrOutput.setWrapStyleWord( false );
	txtaSvrOutput.setEditable( false );
    jScrollPane1.getViewport().add(txtaSvrOutput, null);
    this.getContentPane().add(jPanel2, null);
    jPanel2.add(jLabel4, null);
    jPanel2.add(txtAckFldr, null);
    this.getContentPane().add(jScrollPane2, null);
	txtaAckOutput.setLineWrap( true );
	txtaAckOutput.setWrapStyleWord( false );
	txtaAckOutput.setEditable( false );
    jScrollPane2.getViewport().add(txtaAckOutput, null);
    this.getContentPane().add(jPanel3, null);
    jPanel3.add(jLabel5, null);
    jPanel3.add(btnStartServer, null);
//    jPanel3.add(btnStopServer, null);
    jPanel3.add(btnExit, null);
    jScrollPane1.getViewport();

	btnStartServer.addActionListener(this);
	btnStopServer.addActionListener(this);
	btnExit.addActionListener(this);

	setSize(800,550);
	setResizable(false);
//	setLocation(7,7); 
	show();
  }

	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();
		if(source==btnStopServer) {
			System.out.println(" Normal Shutdown. ") ;
			common.addServerOutput( txtaSvrOutput, " Normal Shutdown..\n" );
			listener.deactivate( );
			started = false ;
		}
		else if(source==btnStartServer){	
			if(!started) {
				String portno = txtPortNo.getText().trim();
				String recvfldr = txtRecvFldr.getText().trim();
				String ackfldr = txtAckFldr.getText().trim();
				boolean isAckReq = ackChkBox.isSelected();
				
				if( !proceed( portno, recvfldr, ackfldr ) ) {
					return ;
				}

				started = true;
				txtPortNo.setEnabled( false ) ;
				txtRecvFldr.setEnabled( false ) ;
				txtAckFldr.setEnabled( false ) ;

				System.out.println(" Starting services..");

				common.addServerOutput( txtaSvrOutput, " Starting services..\n" );

				try {
					listener.activate( Integer.parseInt(portno), recvfldr, ackfldr, txtaSvrOutput, txtaAckOutput, isAckReq) ;
				} catch(Exception exception) {
					System.out.println(" General Exception in Simulator Server :"+exception);	
				}
			} else {
				common.addServerOutput( txtaSvrOutput, " Services running already...\n" );
			}
		}
		else if(source==btnExit) {
			System.out.println(" Shutting down and quiting. ") ;
			System.exit(0); 
		}
	}

	public boolean proceed( String portno, String recvfldr, String ackfile ) 
	{
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

		if( recvfldr == null || recvfldr.equals("") ) {
			JOptionPane.showMessageDialog(this, "Receive Folder cannot be blank..", "Error", JOptionPane.ERROR_MESSAGE);	
			return false ;
		}

		File fldr = new File( recvfldr );
		if( !fldr.isDirectory() ) {
			JOptionPane.showMessageDialog(this, "Not a valid Receive Folder..", "Error", JOptionPane.ERROR_MESSAGE);	
			return false ;
		}

		if( ackfile != null && !ackfile.equals("") ) {
			File file = new File( ackfile );
			if( !file.exists() ) {
				JOptionPane.showMessageDialog(this, "Not a valid Acknowledge File..", "Error", JOptionPane.ERROR_MESSAGE);	
				return false;
			}
		}

		return true ;
	}

	public static void main(String[] args) 
	{
		new OutboundSimulator("Outbound Simulator").addWindowListener(new WindowAdapter(){
												public void windowClosing(WindowEvent e){
													System.exit(0);
												}
											}
										);
	}
}


