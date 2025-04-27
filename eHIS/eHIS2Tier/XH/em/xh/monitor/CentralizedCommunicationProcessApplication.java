package em.xh.monitor;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.net.*;

class CentralizedCommunicationProcessApplication extends JFrame implements ActionListener
{
	JLabel     applicationLabel;
    JTextField applicationField;
	JTextField applicationField1;

    JLabel     facilityLabel;
    JTextField facilityField;
	JTextField facilityField1;

    JLabel     commuLabel;
    JTextField commuField;
	JTextField commuField1;

    JLabel     ioLabel;
    JTextField ioField;
    JTextField ioField1;
    
	JPanel labelPanel;   
	JPanel buttonPanel;
    JPanel mainPanel;
	JPanel resultPanel=null;
	JScrollPane scrollpane;
    
	String sql = null;
	JTable table = null;
    TableModel model = null;
 
	JButton refreshButton;
    JButton resetButton;
	JButton closeButton;

	String appln = null;
	String facility = null;
	String comm_client = null;
	String comm_type = null;

	String appln_des = null;
    String facility_des = null;
    String comm_client_des = null;
    String comm_type_des = null;
	String protocolLinkID = null;

	CentralizedDataBaseAdapter dataadapter = null;
    CentralizedWriteLog write = null;
    String filename = "";	 
	String servicemode = "";	

	//Method init()
	public void init ()
	{
		try
		{
			applicationLabel = new JLabel("Application  ", JLabel.RIGHT);
			applicationField = new JTextField(8);
			applicationField1 = new JTextField(8);

			facilityLabel = new JLabel("Gateway  ", JLabel.RIGHT);
			facilityField = new JTextField(8);
			facilityField1 = new JTextField(8);

			commuLabel = new JLabel("Communication Client  ", JLabel.RIGHT);
			commuField = new JTextField(8);
			commuField1 = new JTextField(8);

			ioLabel = new JLabel("communication Type  ", JLabel.RIGHT);
			ioField = new JTextField(8);
			ioField1 = new JTextField(8);

			applicationField.setText(appln_des);
			facilityField.setText(facility_des);
			commuField.setText(comm_client_des);
			ioField.setText(comm_type_des);

			applicationField1.setText(appln);
		//	facilityField1.setText(facility);
			commuField1.setText(comm_client);
			ioField1.setText(comm_type);

			labelPanel = new JPanel(new GridLayout(3,2,2,2));
			labelPanel.add(applicationLabel);
			labelPanel.add(applicationField);
		//	labelPanel.add(facilityLabel);
			labelPanel.add(facilityField);
			labelPanel.add(commuLabel);
			labelPanel.add(commuField);
			labelPanel.add(ioLabel);	
			labelPanel.add(ioField);

			buttonPanel= new JPanel();
			refreshButton = new JButton("Refresh");
		//	buttonPanel.add(refreshButton);

			resetButton = new JButton("Reset");
		//	buttonPanel.add(resetButton);

			closeButton=new JButton("Close");
			closeButton.setSize(20,10);
			buttonPanel.add(closeButton);
		//	buttonPanel.setBounds(1000,100,10,20);

			mainPanel=new JPanel(new BorderLayout());
		//	mainPanel.add(labelPanel,BorderLayout.NORTH);
			mainPanel.add(buttonPanel,BorderLayout.EAST);

		//	refreshButton.addActionListener(this);
		//	resetButton.addActionListener(this);
			closeButton.addActionListener(this); 
		}
		catch(Exception ex)
		{
			write.fileOutput(filename," (CentralizedCommunicationProcessApplication:init()) Exception :"+ex.toString()+"\n");
		}

	}
	//End of Method init()

	//************************************************************************************//
	// constructor
	//*************************************************************************************
	CentralizedCommunicationProcessApplication(CentralizedDataBaseAdapter dataadapter,CentralizedWriteLog write,String appln,String facility,String comm_client,String comm_type,String appln_des,String facility_des,String comm_client_des,String comm_type_des,String servicemode,String protocolLinkID)
	{
		try
		{
			this.dataadapter = dataadapter;
			this.write = write;
			this.filename = write.filename;
			this.appln = appln;
			this.facility = facility;
			this.comm_client = comm_client;
			this.comm_type = comm_type;
			this.appln_des = appln_des;
			this.facility_des = facility_des;
			this.comm_client_des = comm_client_des;
			this.comm_type_des = comm_type_des;
			this.servicemode = servicemode;
			this.protocolLinkID = protocolLinkID;

			init();
			setup();
			fetch();
		//	setVisible(true);
			displayGUI();			 
		}
		catch(Exception ex)
		{
			write.fileOutput(filename," (CentralizedCommunicationProcessApplication:constructor()) Exception :"+ex.toString()+"\n");
		}
	}

   ///method setup
  public void setup()
  {
	 try{
	      
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setTitle("Communication Process Details List");
		  setSize(1020,750);
	     // Image image = Toolkit.getDefaultToolkit().createImage("/product_small.gif");
		 // setIconImage(image);
         /* if(comm_type.equalsIgnoreCase("I"))
		  {
			 setLocation(0,0);
		  }
		  else setLocation(0,300);
		  */
	     // setBackground(Color.blue);
		  this.getContentPane().add(mainPanel,BorderLayout.PAGE_START);
	 }catch(Exception exception)
	  {
  		write.fileOutput(filename," (CentralizedCommunicationProcessApplication:setup()) Exception :"+exception.toString()+"\n");		
	  }

  }//end of setup

	// Method returnJTable
	public JTable returnJTable(TableModel model)
	{		
		JTable tmptable = null;
		try
		{
			tmptable = new JTable(model);			
			TableColumn column = null;
						
			for (int i = 0; i < tmptable.getColumnCount(); i++) 
			{				
				column = tmptable.getColumnModel().getColumn(i);
				if (i==0)  column.setPreferredWidth(80);
				else column.setPreferredWidth(120);

				if(comm_type != null && comm_type.equalsIgnoreCase("I") && i == 9)
				{
					tmptable.removeColumn(column);
				}
			}

			tmptable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
			tmptable.setPreferredScrollableViewportSize(new Dimension(1024,350));
			tmptable.setDefaultRenderer(Color.class, new CentralizedColorTableCellRenderer());
			tmptable.setDefaultEditor(Color.class, new CentralizedColorTableCellEditor("D"));
		} 
		catch(Exception exception)
		{
			write.fileOutput(filename," (CentralizedCommunicationProcessApplication:returnJTable()) Exception :"+exception.toString()+"\n");			
		}
		return tmptable	;

	}//end of returnJTable

	//Method displayGUI()
	public void displayGUI()
	{
		try
		{
			model = new CentralizedCommunicationPlanetTableModel(sql,dataadapter,write);		 
			if(model.getRowCount() > 0)
			{
				table = returnJTable(model);		
				validateGUI(table);
				this.validate();
				this.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Query Caused No Records To be Retrived.!!!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} 
		catch(Exception exception)
		{
			write.fileOutput(filename," (CentralizedCommunicationProcessApplication:displayRecords()) Exception :"+exception.toString()+"\n");			
			exception.printStackTrace();			
		}
	}
	//End of displayGUI

	// Method  validateGUI
	public void validateGUI(JTable table)
	{
		try
		{
			int row = 0;
			row = table.getRowCount();
			write.fileOutput(filename," (CentralizedCommunicationProcessApplication:fetch) Communication records :"+row+"\n");

			if(row<1)
			{
				JOptionPane.showMessageDialog(this, "Query Caused No Records To be Retrived.!!!", "Error", JOptionPane.ERROR_MESSAGE);	
			}
			else
			{
				scrollpane=null;
				scrollpane = new JScrollPane(table);
				resultPanel=null;
				resultPanel=new JPanel();
				resultPanel.add(scrollpane);
				this.getContentPane().add(resultPanel);
				setVisible(true);
			}
		} 
		catch(Exception exception)
		{
			write.fileOutput(filename," (CentralizedCommunicationProcessApplication:validateGUI()) Exception :"+exception.toString()+"\n");			
			exception.printStackTrace();
		}

	}//end of validateGUI

	//**********************************************************************************************************
	// fetch the values 
	//**********************************************************************************************************
	public void fetch() 
	{
		try
		{
			appln = applicationField1.getText().trim();
			facility = facilityField1.getText().trim();
			comm_client = commuField1.getText().trim();
			comm_type = ioField1.getText().trim();

			if(comm_type.equals("O"))
			{  
				sql = "SELECT DECODE (A.PROCESS_STATUS ,'A','Active','W','Warming Up','S','Stopped','C','About To Stop'),"+
				" A.PROCESS_ID,'Outbound',A.APPLICATION_ID,C.APPLICATION_NAME,NULL,NUll,A.CLIENT_ID,B.CLIENT_NAME,A.START_DATE_TIME,A.STOP_DATE_TIME,"+
				" A.LAST_OUTBOUND_RETRIES,A.LAST_COMM_DATE_TIME,A.LAST_MESSAGE_ID,"+
				" A.TOTAL_MESSAGES,A.TOTAL_QUERIES,A.STARTED_BY_ID,A.STOPPED_BY_ID,A.ADDED_AT_WS_NO,A.MODIFIED_AT_WS_NO,"+
				" A.ADDED_FACILITY_ID,A.MODIFIED_FACILITY_ID,A.PROTOCOL_LINK,D.PROTOCOL_LINK_NAME "+
				" FROM XH_COMM_PROCESS A, XH_COMM_CLIENT B,XH_APPLICATION C,XH_PROTOCOL_LINK D  "+
				" WHERE A.APPLICATION_ID=NVL('"+appln+"',A.APPLICATION_ID) AND A.APPLICATION_ID=C.APPLICATION_ID "+
				//	" AND  A.FACILITY_ID=NVL('"+facility+"',A.FACILITY_ID) AND  A.FACILITY_ID=D.FACILITY_ID "+
				" AND A.PROTOCOL_LINK=NVL('"+protocolLinkID+"',A.CLIENT_ID) AND A.PROTOCOL_LINK=D.PROTOCOL_LINK_ID"+
				" AND A.CLIENT_ID=NVL('"+comm_client+"',A.CLIENT_ID) AND A.CLIENT_ID=B.CLIENT_ID "+
				" AND A.PROCESS_TYPE=NVL('"+comm_type+"',A.PROCESS_TYPE) "+
				" ORDER BY A.START_DATE_TIME DESC ";
			}
			if(comm_type.equals("I"))
			{
				sql = "SELECT DECODE (A.PROCESS_STATUS ,'A','Active','W','Warming Up','S','Stopped','C','About To Stop'),"+
				" A.PROCESS_ID,'Inbound',A.APPLICATION_ID,C.APPLICATION_NAME,NULL,NULL,A.CLIENT_ID,B.CLIENT_NAME,A.START_DATE_TIME,A.STOP_DATE_TIME,"+
				" A.LAST_OUTBOUND_RETRIES,A.LAST_COMM_DATE_TIME,A.LAST_MESSAGE_ID,"+
				" A.TOTAL_MESSAGES,A.TOTAL_QUERIES,A.STARTED_BY_ID,A.STOPPED_BY_ID,A.ADDED_AT_WS_NO,A.MODIFIED_AT_WS_NO,"+
				" A.ADDED_FACILITY_ID,A.MODIFIED_FACILITY_ID,A.PROTOCOL_LINK,D.PROTOCOL_LINK_NAME "+
				" FROM XH_COMM_PROCESS A, XH_COMM_CLIENT B,XH_APPLICATION C,XH_PROTOCOL_LINK D "+
				" WHERE A.APPLICATION_ID=NVL('"+appln+"',A.APPLICATION_ID) AND A.APPLICATION_ID=C.APPLICATION_ID "+
				//	" AND  A.FACILITY_ID=NVL('"+facility+"',A.FACILITY_ID)  "+
				" AND A.PROTOCOL_LINK=NVL('"+protocolLinkID+"',A.CLIENT_ID) AND A.PROTOCOL_LINK=D.PROTOCOL_LINK_ID"+
				" AND A.CLIENT_ID=NVL('"+comm_client+"',A.CLIENT_ID) AND A.CLIENT_ID=B.CLIENT_ID "+
				" AND A.PROCESS_TYPE=NVL('"+comm_type+"',A.PROCESS_TYPE) "+
				" ORDER BY A.START_DATE_TIME DESC ";
			}
			
			write.fileOutput(filename," (CentralizedCommunicationProcessApplication:fetch()) sql : "+sql+"\n");

		}
		catch(Exception exception)
		{
			write.fileOutput(filename," (CentralizedCommunicationProcessApplication:fetch()) Exception :"+exception.toString()+"\n");	  		
		}
	} 

//************************************************************************************//
 // actionperformed method
//*************************************************************************************
	
	public void actionPerformed(ActionEvent event) 
    {
  	   Object source = event.getSource();
	  
	   try{
	   if(source==refreshButton)
	   {  
		     fetch();
			 displayGUI();

       }
	   if(source == resetButton)
	   {  
            boolean reflag=false;
			String serviceName = "";
		//	reflag=dataadapter.reSetProcess(appln,comm_client,facility,comm_type,servicemode);
			reflag=dataadapter.reSetProcess(appln,comm_client,facility,comm_type,servicemode, serviceName);
			if(reflag)
		   {
		   	JOptionPane.showMessageDialog(this, "Reset  process Sucessfully Done", "INFO", JOptionPane.INFORMATION_MESSAGE);	
			fetch();
			displayGUI();
		   }
		   else{
		   	JOptionPane.showMessageDialog(this, "Reset process failed !!!", "Error", JOptionPane.ERROR_MESSAGE);	
		      }
			        			
       }
	   if(source==closeButton)
	   {  
           this.dispose();		
       }

	   }catch(Exception exception)
		{

  		write.fileOutput(filename," (CentralizedCommunicationProcessApplication:actionPerformed()) Exception :"+exception.toString()+"\n");		
		}

	   
      
    }
 } //end of class openDialog