package em.xh.monitor;

 /***************************************************************************************************************
 * Author   :   Srinivasa.N
 * Desc     :	Class  ShowNewWindow
 ***************************************************************************************************************/
import java.awt.*;
import java.net.*;
import java.awt.event.*;
import java.util.EventObject;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.util.HashMap;
/***
 * class  ShowNewWindow
 **/
class  CentralizedSingleRecordDispalyInNewWindow extends JFrame implements ActionListener
{
	
    JLabel  process_Status_Label ;
 	JTextField process_Status_Field ;

	JLabel process_id_Label ;
	JTextField process_id_Field ;

    JLabel process_type_Label ;
	JTextField process_type_Field ;

	JLabel application_Label ;
	JTextField application_Field ;
    
	JLabel facility_Label ;
	JTextField facility_Field;

	JLabel comm_Label ;
	JTextField comm_Field;

	JLabel Start_date_time_Label ;
	JTextField Start_date_time_Field ;

	JLabel last_outbound_retries_Label;
	JTextField last_outbound_retries_Field ;

	JLabel last_comm_date_time_Label ;
	JTextField last_comm_date_time_Field;

	JLabel last_message_Label ;
	JTextField last_message_Field ;

	JLabel last_message1_Label ;
	JTextField last_message1_Field  ;

	JLabel total_messages_Label ;
	JTextField total_messages_Field ;

	JLabel total_queries_Label ;
	JTextField total_queries_Field ;

	JLabel started_by_Label ;
	JTextField started_by_Field ;

	JLabel stopped_by_Label ;
	JTextField stopped_by_Field ;
	
	JLabel added_workstation_Label ;
	JTextField added_workstation_Field ;
    
	JLabel modified_workstation_Label;
	JTextField modified_workstation_Field ;

    JLabel added_facility_Label ;
	JTextField added_facility_Field ;
    
	JLabel modified_facility_Label;
	JTextField modified_facility_Field;
	CentralizedWriteLog write=null;

    
	JPanel      labelPanel;   
	JPanel      buttonPanel;
    JPanel      mainPanel;

	JButton     refreshButton;
    JButton     resetButton;
	JButton     exitButton;

	String appln=null;
	String facility=null;
	String comm_type=null;
	String filename=null;

/***
 * init () method 
 **/
   public void init (HashMap hashmap )
    {
    
    try{	
    process_Status_Label = new JLabel("Process Status ", JLabel.LEFT);
 	process_Status_Field = new JTextField(8);

	process_id_Label = new JLabel("Process Id  ", JLabel.LEFT);
	process_id_Field = new JTextField(8);

    process_type_Label = new JLabel("Process Type   ", JLabel.LEFT);
	process_type_Field = new JTextField(8);

	application_Label = new JLabel("Application ", JLabel.LEFT);
	application_Field = new JTextField(8);
    
	facility_Label = new JLabel("Facility ", JLabel.LEFT);
	facility_Field = new JTextField(8); 

	comm_Label = new JLabel("Commununication Client ", JLabel.LEFT);
	comm_Field = new JTextField(8); 

	Start_date_time_Label = new JLabel("Start Date Time ", JLabel.LEFT);
	Start_date_time_Field = new JTextField(8); 

	last_outbound_retries_Label = new JLabel("Last Outbound Retries ", JLabel.LEFT);
	last_outbound_retries_Field = new JTextField(8); 

	last_comm_date_time_Label = new JLabel("Last Communication Date Time ", JLabel.LEFT);
	last_comm_date_time_Field = new JTextField(8); 

	last_message_Label = new JLabel("Last Message ", JLabel.LEFT);
	last_message_Field = new JTextField(8); 

	last_message1_Label = new JLabel("Last Message1 ", JLabel.LEFT);
	last_message1_Field = new JTextField(8); 

	total_messages_Label = new JLabel("Total Messages ", JLabel.LEFT);
	total_messages_Field = new JTextField(8); 

	total_queries_Label = new JLabel("Total Queries ", JLabel.LEFT);
	total_queries_Field = new JTextField(8); 

	started_by_Label = new JLabel("Started By ", JLabel.LEFT);
	started_by_Field = new JTextField(8); 

	stopped_by_Label = new JLabel("Stopped By ", JLabel.LEFT);
	stopped_by_Field = new JTextField(8); 
	
	added_workstation_Label = new JLabel("Added Workstation ", JLabel.LEFT);
	added_workstation_Field = new JTextField(8); 
    
	modified_workstation_Label = new JLabel("Modified Workstation ", JLabel.LEFT);
	modified_workstation_Field = new JTextField(8); 

    added_facility_Label = new JLabel("Added Facility ", JLabel.LEFT);
	added_facility_Field = new JTextField(8); 
    
	modified_facility_Label = new JLabel("Modified Facility ", JLabel.LEFT);
	modified_facility_Field = new JTextField(8); 

	labelPanel = new JPanel(new GridLayout(19,2,2,2));

	labelPanel.add(process_Status_Label);
	labelPanel.add(process_Status_Field);

	labelPanel.add(process_id_Label);
    labelPanel.add(process_id_Field);

	labelPanel.add(process_type_Label);
    labelPanel.add(process_type_Field);

	labelPanel.add(application_Label);	
    labelPanel.add(application_Field);

	labelPanel.add(facility_Label);
	labelPanel.add(facility_Field);

	labelPanel.add(comm_Label);
	labelPanel.add(comm_Field);

	labelPanel.add(Start_date_time_Label);
    labelPanel.add(Start_date_time_Field);

	labelPanel.add(last_outbound_retries_Label);
    labelPanel.add(last_outbound_retries_Field);

	labelPanel.add(last_comm_date_time_Label);	
    labelPanel.add(last_comm_date_time_Field);

	
	labelPanel.add(last_message_Label);
    labelPanel.add(last_message_Field);

	labelPanel.add(last_message1_Label);	
    labelPanel.add(last_message1_Field);

	labelPanel.add(total_messages_Label);
	labelPanel.add(total_messages_Field);

	labelPanel.add(total_queries_Label);
    labelPanel.add(total_queries_Field);

	labelPanel.add(started_by_Label);
    labelPanel.add(started_by_Field);

	labelPanel.add(stopped_by_Label);	
    labelPanel.add(stopped_by_Field);

	labelPanel.add(added_workstation_Label);
    labelPanel.add(added_workstation_Field);

	labelPanel.add(modified_workstation_Label);
    labelPanel.add(modified_workstation_Field);

	labelPanel.add(added_facility_Label);	
    labelPanel.add(added_facility_Field);
    
	labelPanel.add(modified_facility_Label);	
    labelPanel.add(modified_facility_Field);
   
   String process_status =(String)hashmap.get("process_status");
   process_Status_Field.setText(process_status);
   String process_id =(String)hashmap.get("process_id");
   process_id_Field.setText(process_id);
   String process_type =(String)hashmap.get("process_type");
   process_type_Field.setText(process_type);
   String application_id =(String)hashmap.get("application_id");
   application_Field.setText(application_id);
   String facility_id =(String)hashmap.get("facility_id");
   facility_Field.setText(facility_id);
   String comm_client =(String)hashmap.get("comm_client");
   comm_Field.setText(comm_client);
   String start_date_time =(String)hashmap.get("start_date_time");
   Start_date_time_Field.setText(start_date_time);
   String last_outbound_reties =(String)hashmap.get("last_outbound_reties");
   last_outbound_retries_Field.setText(last_outbound_reties);
   String last_comm_date_time =(String)hashmap.get("last_comm_date_time");
   last_comm_date_time_Field.setText(last_comm_date_time);
   String last_message =(String)hashmap.get("last_message_id");
    last_message_Field.setText(last_message);
   String last_message_id1 =(String)hashmap.get("last_message_id1");
	last_message1_Field.setText(last_message_id1);
   String total_messages =(String)hashmap.get("total_messages");
	total_messages_Field.setText(total_messages);
   String total_queries =(String)hashmap.get("total_queries");
	total_queries_Field.setText(total_queries);
   String started_by =(String)hashmap.get("started_by");
	started_by_Field.setText(started_by);
   String stopped_by =(String)hashmap.get("stopped_by");
	stopped_by_Field.setText(stopped_by);
   String added_workstation =(String)hashmap.get("added_workstation");
	added_workstation_Field.setText(added_workstation);
   String modified_workstation =(String)hashmap.get("modified_workstation");
	modified_workstation_Field.setText(modified_workstation);
   String added_facility =(String)hashmap.get("added_facility");
	added_facility_Field.setText(added_facility);
   String modified_facility =(String)hashmap.get("modified_facility");
   modified_facility_Field.setText(modified_facility);
    
    	
	buttonPanel= new JPanel(new GridLayout(1,1,2,2));
	refreshButton = new JButton("Close");
	buttonPanel.add(refreshButton);
    
	mainPanel=new JPanel(new BorderLayout());
	mainPanel.add(labelPanel,BorderLayout.NORTH);
	mainPanel.add(buttonPanel,BorderLayout.SOUTH);
  
    refreshButton.addActionListener(this);
	} catch(Exception exception)
		{
		  write.fileOutput(filename," (CentralizedSingleRecordDispalyInNewWindow:init()) Exception :"+exception.toString()+"\n");
	
		}
   }

/***
  * constructor CentralizedSingleRecordDispalyInNewWindow
  ***/
	CentralizedSingleRecordDispalyInNewWindow(HashMap hashmap,CentralizedWriteLog write)
    {
	       try{    
			 this.write=write;
			 this.filename=write.filename;
			 setTitle("Communication Process Details");
			 setSize(500,500);
            // Image image = Toolkit.getDefaultToolkit().createImage("/product_small.gif");
			// setIconImage(image);
             init(hashmap);
			 this.getContentPane().add(mainPanel,BorderLayout.PAGE_START);
			 setVisible(true);
		   }
		   catch(Exception exception)
		{
		  write.fileOutput(filename," (CentralizedSingleRecordDispalyInNewWindow:constructor()) Exception :"+exception.toString()+"\n");
	
		}


	}

/***
  * actionperformed method
  ***/

	public void actionPerformed(ActionEvent event) 
    {
  	    Object source = event.getSource();
	   try{
	   if(source==refreshButton)
	   {  
         this.dispose();
	   }
	   }catch(Exception exception)
		{
	  write.fileOutput(filename," (CentralizedSingleRecordDispalyInNewWindow:actionPerformed()) Exception :"+exception.toString()+"\n");
	}
    }

}//end of class	 ShowNewWindow