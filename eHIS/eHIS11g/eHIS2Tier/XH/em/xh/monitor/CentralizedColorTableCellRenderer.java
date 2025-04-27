package em.xh.monitor;

import java.awt.*;
import java.awt.event.*;
import java.util.EventObject;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.util.HashMap;
import java.io.*;

//class  CentralizedColorTableCellRenderer
public class CentralizedColorTableCellRenderer implements TableCellRenderer
{
    private JPanel panel = new JPanel();

	public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) 
	{		
	  panel.setBackground((Color) value);
	  return panel;
    }
   	
	public boolean isCellEditable(EventObject anEvent) 
	{
       return true;
    }
}

 //	class CentralizedColorTableCellEditor
 class CentralizedColorTableCellEditor extends CentralizedColorTableCellRenderer implements TableCellEditor 
 {
     private JColorChooser colorChooser;
     private EventListenerList listenerList = new EventListenerList();
	 
	 String applicationid = null;
     String facilityid = null;
     String commclient = null;
     String commtypeid = null;
     String applicationname = null;
     String facilityname = null;
     String commclientname = null;
     String commtypename = null;
     String facility = null;
	 String mode = null;
	 String protocolLinkID = null;

	 PrintStream out;
	 	 
	 private ChangeEvent event = new ChangeEvent(this);

     CentralizedCommunicationProcessApplication commapplication=null;
	 CentralizedDataBaseAdapter dataadapter=null;
	 CentralizedWriteLog write=null;
	 CentralizedSingleRecordDispalyInNewWindow newreference=null;

     HashMap hashmap=null;
	 String servicemode="";

	public CentralizedColorTableCellEditor(String mode)
	{	  
		this.mode = mode;	   
	}

	// Method getTableCellEditorComponent
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
	{ 				
		dataadapter = CentralizedMainTableModel.dataadapter;
		write = CentralizedMainTableModel.write;
		servicemode = CentralizedMainTableModel.servicemode;
		try
		{
			out = new PrintStream(new FileOutputStream(write.filename,true));
		}
		catch(Exception e)
		{
			write.fileOutput(write.filename," (CentralizedColorTableCellEditor) \n");
		}	      	   
		try
		{
			commtypeid = CentralizedDataBaseAdapter.communicationType;
			if(mode.equalsIgnoreCase("P"))
			{
				facilityid=(String)table.getValueAt(row,4);
				facility=facilityid.trim();

				String outbound[][]=(String[][])CentralizedDataBaseAdapter.outboundArray;
				String inbound[][]=(String[][])CentralizedDataBaseAdapter.inboundArray;

			//	write.fileOutput(write.filename," (CentralizedColorTableCellEditor:getTableCellEditorComponent()) mode :"+mode+"\n");				

				if(commtypeid.equalsIgnoreCase("O"))
				{
					applicationid = (String)outbound[row][1];
					commclient = (String)outbound[row][0];
					facilityid = (String)outbound[row][2];
					applicationname = (String)table.getValueAt(row,4);
					facilityname = facility;
					commclientname = (String)table.getValueAt(row,3);
					commtypename = "Outbound";
					protocolLinkID = (String)outbound[row][4];					
				}
				else
				{
					commtypeid = (String)inbound[row][3];
					applicationid = (String)inbound[row][1];
					commclient = (String)inbound[row][0];
					facilityid = (String)inbound[row][2];
					applicationname = (String)table.getValueAt(row,4);
					facilityname = facility;
					commclientname = (String)table.getValueAt(row,2);
					commtypename = "Inbound";
					protocolLinkID = (String)inbound[row][4];
				}
				
				write.fileOutput(write.filename," (CentralizedColorTableCellEditor:getTableCellEditorComponent()) applicationid :"+applicationid+"  \n");
				write.fileOutput(write.filename," (CentralizedColorTableCellEditor:getTableCellEditorComponent()) facilityid :"+facilityid+"  \n");
				write.fileOutput(write.filename," (CentralizedColorTableCellEditor:getTableCellEditorComponent()) commclient :"+commclient+"  \n");
				write.fileOutput(write.filename," (CentralizedColorTableCellEditor:getTableCellEditorComponent()) commtypeid :"+commtypeid+"  \n");
				write.fileOutput(write.filename," (CentralizedColorTableCellEditor:getTableCellEditorComponent()) applicationname :"+applicationname+"  \n");
			//	write.fileOutput(write.filename," (CentralizedColorTableCellEditor:getTableCellEditorComponent()) facilityname :"+facilityname+"  \n");
			//	write.fileOutput(write.filename," (CentralizedColorTableCellEditor:getTableCellEditorComponent()) commclientname :"+commclientname+"  \n");
				write.fileOutput(write.filename," (CentralizedColorTableCellEditor:getTableCellEditorComponent()) commtypename :"+commtypename+"  \n");
				write.fileOutput(write.filename," (CentralizedColorTableCellEditor:getTableCellEditorComponent()) protocolLinkID :"+protocolLinkID+"  \n");

				commapplication = new CentralizedCommunicationProcessApplication(dataadapter,write,applicationid,
												facilityid,commclient,commtypeid,applicationname,facilityname,
												commclientname,commtypename,servicemode,protocolLinkID);

			}
			
			if(mode.equalsIgnoreCase("D"))
			{
			/*	write.fileOutput(write.filename," (CentralizedColorTableCellEditor:getTableCellEditorComponent()) mode :"+mode+"\n");

				hashmap=new HashMap();
				if(commtypeid.equalsIgnoreCase("O"))
				{
					hashmap.put("process_status",(String)table.getValueAt(row,1));
					hashmap.put("process_id",(String)table.getValueAt(row,2));
					hashmap.put("process_type",(String)table.getValueAt(row,3));
					hashmap.put("application_id",(String)table.getValueAt(row,4));
					hashmap.put("facility_id",(String)table.getValueAt(row,5));
					hashmap.put("comm_client",(String)table.getValueAt(row,6));
					hashmap.put("start_date_time",(String)table.getValueAt(row,7));
					hashmap.put("last_outbound-reties",(String)table.getValueAt(row,8));
					hashmap.put("last_comm_date_time",(String)table.getValueAt(row,9));
					hashmap.put("last_message_id",(String)table.getValueAt(row,10));
					hashmap.put("last_message_id1",(String)table.getValueAt(row,11));
					hashmap.put("total_messages",(String)table.getValueAt(row,12));
					hashmap.put("total_queries",(String)table.getValueAt(row,13));
					hashmap.put("started_by",(String)table.getValueAt(row,14));
					hashmap.put("stopped_by",(String)table.getValueAt(row,15));
					hashmap.put("added_workstation",(String)table.getValueAt(row,16));
					hashmap.put("modified_workstation",(String)table.getValueAt(row,17));
					hashmap.put("added_facility",(String)table.getValueAt(row,18));
					hashmap.put("modified_facility",(String)table.getValueAt(row,19));
				}
				else
				{
					hashmap.put("process_status",(String)table.getValueAt(row,1));
					hashmap.put("process_id",(String)table.getValueAt(row,2));
					hashmap.put("process_type",(String)table.getValueAt(row,3));
					hashmap.put("application_id",(String)table.getValueAt(row,4));
					hashmap.put("facility_id",(String)table.getValueAt(row,5));
					hashmap.put("comm_client",(String)table.getValueAt(row,6));
					hashmap.put("start_date_time",(String)table.getValueAt(row,7));					
					hashmap.put("last_comm_date_time",(String)table.getValueAt(row,8));
					hashmap.put("last_message_id",(String)table.getValueAt(row,9));
					hashmap.put("last_message_id1",(String)table.getValueAt(row,10));
					hashmap.put("total_messages",(String)table.getValueAt(row,11));
					hashmap.put("total_queries",(String)table.getValueAt(row,12));
					hashmap.put("started_by",(String)table.getValueAt(row,13));
					hashmap.put("stopped_by",(String)table.getValueAt(row,14));
					hashmap.put("added_workstation",(String)table.getValueAt(row,15));
					hashmap.put("modified_workstation",(String)table.getValueAt(row,16));
					hashmap.put("added_facility",(String)table.getValueAt(row,17));
					hashmap.put("modified_facility",(String)table.getValueAt(row,18));
				}
				write.fileOutput(write.filename," (CentralizedColorTableCellEditor:getTableCellEditorComponent()) hashmap :"+hashmap+"\n");
				write.fileOutput(write.filename," (CentralizedColorTableCellEditor:getTableCellEditorComponent()) Before opening CentralizedSingleRecordDispalyInNewWindow \n");
				newreference=new CentralizedSingleRecordDispalyInNewWindow(hashmap,write);
				write.fileOutput(write.filename," (CentralizedColorTableCellEditor:getTableCellEditorComponent()) After opening CentralizedSingleRecordDispalyInNewWindow  \n");
			*/
			}
		}
		catch(Exception exception)
		{
			write.fileOutput(write.filename," (CentralizedColorTableCellEditor:getTableCellEditorComponent()) Exception :"+exception.toString()+"\n");
			exception.printStackTrace(out);
		}

		return getTableCellRendererComponent(table, value, isSelected, true, row, column);
	}	//end of getTableCellEditorComponent

  // method shouldSelectCell
  public boolean shouldSelectCell(EventObject anEvent)
  { 	   
    // colorDialog.setVisible(true);
	 return true;
  }	// end of shouldSelectCell

  //Method cancelCellEditing
  public void cancelCellEditing() 
  { 	 
   // colorDialog.setVisible(false);
  }//end of cancelCellEditing

  //Method stopCellEditing
  public boolean stopCellEditing() 
  { 	
    //colorDialog.setVisible(false);
    return true;
  }//end of stopCellEditing

  //Method 	getCellEditorValue
  public Object getCellEditorValue() 
  {		
    return colorChooser.getColor();
  }//end of getCellEditorValue

  // Method  addCellEditorListener
  public void addCellEditorListener(CellEditorListener l) 
  {	   
    listenerList.add(CellEditorListener.class, l);
  }	//end of addCellEditorListener

  // Method  removeCellEditorListener
  public void removeCellEditorListener(CellEditorListener l) 
  {		 
    listenerList.remove(CellEditorListener.class, l);
  }// end of removeCellEditorListener

  // Method  fireEditingStopped
  protected void fireEditingStopped() 
  {	  
	  Object[] listeners = listenerList.getListenerList();
    for (int i = listeners.length - 2; i >= 0; i -= 2)
      ((CellEditorListener) listeners[i + 1]).editingStopped(event);
  }//end of fireEditingStopped

  // Method  fireEditingCanceled
  protected void fireEditingCanceled() {	 
    Object[] listeners = listenerList.getListenerList();
    for (int i = listeners.length - 2; i >= 0; i -= 2)
      ((CellEditorListener) listeners[i + 1]).editingCanceled(event);
  }//end of fireEditingCanceled
}//end of CentralizedColorTableCellEditor