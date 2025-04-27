package em.xh.monitor;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import java.util.EventObject;
import java.util.ArrayList;

public class CentralizedMainTableModel extends AbstractTableModel 
{
  private String[] columnNames = {"", "Status", "Comm Status", "Process", "Gateway Server", "Application","Gateway","Retries","Last Comm Time","Last Msg ID","Total Messages","Communication Type","Start Date Time","Started By","End Date Time"};

  public static final int SELECT = 0;
  public static final int STATUS_COLUMN = 1;
  public static final int PROCESS_ID_COLUMN = 5;
  public static final int CLIENT_ID_COLUMN = 2;
  public static final int APPLICATION_ID_COLUMN = 3;
  public static final int FACILITY_ID_COLUMN = 4;  
  public static final int START_DATE_TIME_COLUMN = 6;
  public static final int STARTED_BY_ID_COLUMN = 7;
  public static final int STOP_DATE_TIME_COLUMN = 8;
  public static final int LAST_OUTBOUND_RETRIES_COLUMN = 9;
  public int cellLength = 0;
  Object[][] cells = null;

  static CentralizedDataBaseAdapter dataadapter = null;
  static CentralizedWriteLog write = null;

  static String servicemode = "";
  String filename = "";
  
	CentralizedMainTableModel(String sqlquery,String querymode,String commtype,CentralizedDataBaseAdapter dataadapter,CentralizedWriteLog write,String servicemode)
	{
		this.dataadapter = dataadapter;
		this.write = write;
		this.filename = write.filename;
		this.servicemode = servicemode;
		try
		{
			if((querymode.equalsIgnoreCase("F")) && (sqlquery != null))
			{  		 
				cells = dataadapter.executeQuery(sqlquery,commtype);
			}
			if((querymode.equalsIgnoreCase("R")) && (sqlquery != null))
			{  				
				cells = dataadapter.executeQueryWithRemoteStatus(sqlquery,commtype,servicemode);
			}
			if(cells != null) 
			{
				cellLength = cells.length;		
			}
		}
		catch(Exception exception)
		{
			write.fileOutput(filename," (CentralizedMainTableModel:constructor) Exception :"+exception.toString()+"n");
		}
	}

	public String getColumnName(int c) 
	{	  	  
		if(c == 0) return String.valueOf(new Boolean(false));
		return columnNames[c];	  
	}

	public Class getColumnClass(int c)
	{				
		return cells[0][c].getClass();
	}

	public int getColumnCount() 
	{
		if((cells != null) && (cells.length != 0)) return cells[0].length;
		else return 0;
	}

	public int getRowCount() 
	{
		if((cells != null) && (cells.length != 0)) return cells.length;
		else return 0;
	}

	public Object getValueAt(int r, int c) 
	{		
		if(c == 6) // Getting protocol link name to display instead of ID 
		{
			return dataadapter.getProtocolName(cells[r][c]);
		}
		else
		{
			return cells[r][c];
		}
	}

	public void setValueAt(Object obj, int r, int c) 
	{
		cells[r][c] = obj;
	}

	public boolean isCellEditable(int r, int c) 
	{	
		String protocolType = (String)cells[r][11];

		if(c == SELECT && protocolType.equalsIgnoreCase("ORACLE_TABLE"))
		{
			return false;
		} 
		return  c == STATUS_COLUMN || c == SELECT;
	} 
}