import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.net.*;

 class DatabaseConn
  {
		private transient Connection Oracle_Connection=null;
		private transient CallableStatement Oracle_CallableStatement=null;
		private transient ResultSet resultset=null;
		private transient PreparedStatement oracle_PrepareStatement;
		private transient Statement Oracle_Statement;


		public DatabaseConn()throws Exception 	{ }

	 public void db_openOracleConnection(String msg,String userName,String passWord)throws Exception
		{	
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Oracle_Connection=DriverManager.getConnection(msg,userName,passWord);
				Oracle_Connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
				Oracle_Statement=Oracle_Connection.createStatement();
		}

	 public void db_closeConnection()throws Exception
		{
				Oracle_Connection.close();			
		}

	public void db_oracleCommit()throws Exception
		{
				Oracle_Connection.commit();
		}

	public void db_oracleQueryExecute(String msg)throws Exception
		{		
				 Oracle_Statement.execute(msg);	
				 Oracle_Connection.commit(); 
		}				

	 public ResultSet db_OracleSelectQuery(String msg)throws Exception
		{ 	
				 resultset=Oracle_Statement.executeQuery(msg);	
				 return resultset;
		}	
}

class urlc implements Runnable
{

		Thread thr;
		String url ="";

public void run()
	{
		try
		{		  
			loadURL();		
		}
		catch(Exception ee)		{	}
	}

public void setURL(String arg)
	{
	url = arg;
	}

public void exploreURL()
	{
/*	if (thr == null)
	{
	thr=new Thread(this);
	thr.start();
	}
	*/
	thr=new Thread(this);
	thr.start();
	}


private void loadURL() throws Exception
	{
	
String result="";
URL reportUrl = new URL( url ) ;
URLConnection urlConnection = reportUrl.openConnection(); 
BufferedReader br = new BufferedReader(
					new InputStreamReader(
					urlConnection.getInputStream()
										) ) ;
						String line = "" ;
						String output = "" ;

						while( (line = br.readLine() ) != null ) {
							output = output + line ;
						}

						int start = output.indexOf( "<PRE>" ) ;
						int end   = output.lastIndexOf( "</PRE>" ) ;

						if ( start != -1 ) {
							String error = output.substring( start+5, end ) ;
							result += error ;
						}					

					br.close();	

urlConnection=null;
reportUrl=null;
//if(thr!=null)  thr=null;
		
	}
}

public class URLRepSubmit extends JFrame  implements Runnable ,ActionListener
 {
//JLabel jlab=new JLabel("Label Generation");
//JLabel jlab=new JLabel(" ");
JButton jbut=new JButton("Stop");
JLabel jdum=new JLabel("");
JLabel jlab1=new JLabel("Staus :  Idle");
JLabel jlab11=new JLabel("");

DatabaseConn  dbconn=null;
String connectString;
String username,password,result;
ResultSet rslt=null;
Thread t;
int count=0;
urlc urlObj;
int refcou,refcount;
String query;
String l_facility_id=null;
String wherecon= "'BDRLBPRN','BTRLBPRN'";

//String wherecon= "'BDRLBPRN1'";


public  URLRepSubmit(String usrn,String pasw,String facID,String connStr)
 {
try{

		//	username = usrn;
		//	password = pasw;
			username= "appluser";
			password ="appluser";
			l_facility_id = facID;
			connectString = connStr;

			getDatabaseConnection();	
			if (getAliveStatus()==0)
			{
				System.exit(0);
			}

			getContentPane().setLayout(new GridLayout(4,3));

			getContentPane().add(new JLabel(""));
//			getContentPane().add(jlab);
			getContentPane().add(new JLabel(""));
			getContentPane().add(new JLabel(""));

           getContentPane().add(new JLabel(""));
			getContentPane().add(jbut);
			getContentPane().add(new JLabel(""));

			getContentPane().add(new JLabel(""));
			getContentPane().add(jdum);
			getContentPane().add(new JLabel(""));

			getContentPane().add(new JLabel(""));
			getContentPane().add(jlab1);
			getContentPane().add(new JLabel(""));

			java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
  		    setBounds( (screenSize.width-400)/2, (screenSize.height-180)/2, 400, 180);

			urlObj=new urlc();

			t=new Thread(this);
			setTitle("                           Label Generation");

			//jbut.requestFocus();
			setSize(400,180);

	jbut.registerKeyboardAction(
                jbut.getActionForKeyStroke(
                        KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false)),
                        KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false),
                        JComponent.WHEN_FOCUSED);
		 jbut.registerKeyboardAction(
                jbut.getActionForKeyStroke(
                        KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true)),
                        KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true),
                        JComponent.WHEN_FOCUSED);

			jbut.addActionListener(this);
			jlab1.setText("Status :  Idle");
			getContentPane().setBackground(new Color(221,225,230));
		//	jlab1.setBackground(new Color(221,225,230));
			addWindowListener(new WindowAdapter()
				{
					public void windowClosing(WindowEvent ee) 
					{
					deleteAliveStatus();
					System.exit(0);		
					}						
				});

		 
}catch(Exception ee) 	{      }



setVisible(true);
//jbut.setFocus(true);
}




public void actionPerformed(ActionEvent e)
	 {
		deleteAliveStatus();
		System.exit(0);		
	  }

private void insertTraceMessage(String type,String msg)
  	 {
	try
		 {
		msg=msg.substring(1,70);
		query="INSERT INTO SY_PROG_MSG(operating_Facility_id,PGM_ID,MSG_TYPE,MSG_NUM,MSG_DESC,MSG_DATE_TIME,SESSION_ID,PGM_DATE) VALUES  ('"+l_facility_id+"''BDASRVPR','"+type+"',NULL, '"+msg+"',SYSDATE,USERENV('sessionid'),TO_CHAR(SYSDATE,'DD/MM/YYYY'))";
		dbconn.db_oracleQueryExecute(query);
		 }
		 catch(Exception ee) 
		 {

		 }
	  }

private void getDatabaseConnection()
	 {
	try
		 {
			dbconn=new DatabaseConn();			
			dbconn.db_openOracleConnection(connectString,username,password);
		 }catch(Exception ee)
		 {
			 JOptionPane.showMessageDialog(this,"Database Connection"+ee);
			 System.exit(0);
		 }
	 }

private int getAliveStatus()
	{
    query = " select count(1) from SY_BG_PROCESS_CONTROL WHERE operating_facility_id IN ('"+l_facility_id+"','*A') and  pgm_id = 'BDASRVPR' AND started_date IS NOT NULL";
    int coun=0;

   try	{
   rslt =dbconn.db_OracleSelectQuery(query);

		while(rslt.next())
		{
		 coun=Integer.parseInt(rslt.getString(1));
		}
		rslt.close();
		}catch(Exception ee)		
			{
              insertTraceMessage("AS",ee.toString());
		    }
//System.out.println("Data count "+coun);
		return coun;
	}

private void deleteAliveStatus()
	 {

	try
		 {
	 query= "DELETE FROM SY_BG_PROCESS_CONTROL WHERE operating_facility_id IN ('"+l_facility_id+"','*A') and pgm_id = 'BDASRVPR' AND started_date IS NOT NULL";

	dbconn.db_oracleQueryExecute(query);

//	System.out.println("deleted successfully");
	     }
		 catch(Exception ee)
		 {
			 insertTraceMessage("DS",ee.toString());
		 }

	 }


private int getConnectionCount()
	{
   query = " select count(1) from SY_REPORT_GENERATE_REQUEST a WHERE  pgm_id IN ("+wherecon+") AND (a.pgm_id, a.operating_facility_id) IN (SELECT report_id, decode(operating_facility_id,'*A',a.operating_Facility_id,operating_facility_id)  FROM BD_REPORTS  WHERE  report_id IN ("+wherecon+")   AND report_exec_ind = 'RS')";
      int coun=0;

   try	{
   rslt =dbconn.db_OracleSelectQuery(query);

		while(rslt.next())
		{
		 coun=Integer.parseInt(rslt.getString(1));
		}
		rslt.close();
		}catch(Exception ee)		
			{
			insertTraceMessage("CC",ee.toString());
			}
//System.out.println("Data count "+coun);
		return coun;
	}
private void deleteRow(String msg)
	 {

	try
		 {
	query= "delete from SY_REPORT_GENERATE_REQUEST  where ROWID ='"+msg+"'";

	dbconn.db_oracleQueryExecute(query);

//	System.out.println("deleted successfully");
	     }
		 catch(Exception ee)
		 {
			 insertTraceMessage("DR",ee.toString());
		 }

	 }

private void getURLDetails()
	 {

	query = "SELECT cmd_line_arg,rowid FROM SY_REPORT_GENERATE_REQUEST a WHERE  pgm_id IN ("+wherecon+") AND (a.pgm_id, a.operating_facility_id) IN (SELECT report_id, decode(operating_facility_id,'*A',a.operating_Facility_id,operating_facility_id)  FROM BD_REPORTS  WHERE  report_id IN ("+wherecon+")   AND report_exec_ind = 'RS')";

// query = " select CMD_LINE_ARG,ROWID from SY_REPORT_GENERATE_REQUEST  where operating_facility_id='"+l_facility_id+"' and PGM_ID IN("+wherecon+")";

 String url=null;
 String rowid=null;
   jlab1.setText("Status :Processing");
   try
		{
	   rslt =dbconn.db_OracleSelectQuery(query);
	while(rslt.next())
		{
//		System.out.println("found the query");
		url=rslt.getString(1);
		rowid=rslt.getString(2);
//		System.out.println("before explore");
		urlObj.setURL(url);
		urlObj.exploreURL();
//		exploreURL(url);
//		System.out.println("before delete");
	    deleteRow(rowid);

		}

		rslt.close();
		}catch(Exception ee)		
			{		
			insertTraceMessage("GU",ee.toString());
		   }

	 }


public void run()
{
	try
	{
		while(true)
		{				 
			count=getConnectionCount();
			if(count > 0)       getURLDetails();
			t.sleep(1000);
			jlab1.setText("Status :  Idle");
			refcount++;
			if(refcount > 5)  
			{
			  refcou=getAliveStatus();
			  refcount =0;
			  if(refcou ==0)   System.exit(0);
			}
		}
	}catch(Exception ee){
					}
}


public static void main(String arg[])
  {
try{
//System.out.println("args"+ arg[0]+" and "+arg[1]+"  and"+arg[2]);

URLRepSubmit frn=new URLRepSubmit(arg[0],arg[1],arg[2],arg[3]);
frn.t.start();
	}catch(Exception ee)
  {
	System.exit(0);			
  }
}
}  



