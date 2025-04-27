 /***************************************************************************************************************
 * Author   :   Srinivasa.N
 * Desc     :	Class to handle jtable dispaly of records  
 ***************************************************************************************************************/
import java.awt.*;
import java.awt.event.*;
import java.util.EventObject;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
/**
  * class PlanetTableModel
  **/
  public class CentralizedCommunicationPlanetTableModel extends AbstractTableModel 
  {

     public static final int STATUS_COLUMN = 0;
     public static final int PROCESS_STATUS_COLUMN = 1;
     public static final int PROCESS_ID_COLUMN = 2;
     public static final int PROCESS_TYPE_COLUMN = 3;
     public static final int APPLICATION_ID_COLUMN = 4;
     public static final int FACILITY_ID_COLUMN = 5;
     public static final int CLIENT_ID_COLUMN = 6;
     public static final int START_DATE_TIME_COLUMN = 7;
     public static final int LAST_OUTBOUND_RETRIES_COLUMN = 8;
     public static final int LAST_COMM_DATE_TIME_COLUMN = 9;
     public static final int LAST_MESSAGE_ID_COLUMN = 10;
     public static final int LAST_MESSAGE_ID1_COLUMN = 11;
     public static final int TOTAL_MESSAGES_COLUMN = 12;
     public static final int TOTAL_QUERIES_COLUMN = 13;
     public static final int STARTED_BY_ID_COLUMN = 14;
     public static final int STOPPED_BY_ID_COLUMN = 15;
     public static final int ADDED_AT_WS_NO_COLUMN = 16;
     public static final int MODIFIED_AT_WS_NO_COLUMN = 17;
     public static final int ADDED_FACILITY_ID_COLUMN = 18;
     public static final int MODIFIED_FACILITY_ID_COLUMN = 19;

     public static  int cellLength =0;
  	 Object[][] cells=null;
	 CentralizedDataBaseAdapter dataadapter=null;
     CentralizedWriteLog write=null;
     String filename=""; 

	 CentralizedCommunicationPlanetTableModel(String sql,CentralizedDataBaseAdapter dataadapter,CentralizedWriteLog write)
	 {
     	  try{
		  this.dataadapter=dataadapter;
		  this.write=write;
		  cells=dataadapter.executeQueryForProcess(sql);
	      if(cells!=null) {
			    cellLength=cells.length;
			
		         }
		  }catch(Exception exception)
		   {
		 	  write.fileOutput(filename," (CentralizedCommunicationPlanetTableModel:constructor()) Exception :"+exception.toString()+"\n");
		   }
		 
	 }

     public String getColumnName(int c) {
      return columnNames[c];
     }

     public Class getColumnClass(int c) {
       return cells[0][c].getClass();
	 }

    public int getColumnCount() {
      return cells[0].length;
     }

    public int getRowCount() {
      return cells.length;
    }

    public Object getValueAt(int r, int c) {
      return cells[r][c];
    }
  
	public void setValueAt(Object obj, int r, int c) {
     cells[r][c] = obj;
    }

    public boolean isCellEditable(int r, int c) {
      return c == STATUS_COLUMN ;
    }

    private String[] columnNames = {"Status","Process Status", "Process", "Process Type", "Application","Gateway",
      "Communication Client","Start DateTime","End DateTime","Last Outbound Retries","Last Communication Date Time",
	  "Last Message","Total messages","Total Queries","Started By","Stopped By",
	  "Added WorkStation","Modified WorkStation","Added Facility","Modified facility"};
  
}//end of class PlanetTableModel 
