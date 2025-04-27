package ePH;
 
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import webbeans.eCommon.*;
import java.text.*;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
  

public class MIMSScheduler extends HttpServlet 
{ 
	PrintWriter out;
	java.util.Properties p;

	// Initial invoked at server started time from web.xml 
	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	    System.err.println("Init Method - MIMSScheduler");
		JobMIMSSchedulerConnnection jmsc =new JobMIMSSchedulerConnnection();
			// to call internaly on specific intervals. 
			jmsc.main();

	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException 
	{
		try	
		{ 
			req.setCharacterEncoding("UTF-8");
		    res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			
			System.err.println("---doGet - MIMSScheduler");

			doPost(req,res);
		}
		catch(Exception e)	{
			System.err.println("Exception in doGET - MIMSScheduler:"+e.toString());
			  e.printStackTrace();
			}
	} // End of doGet

	/* called when the report is generatede form application*/
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException 
	{
		try	
		{
			req.setCharacterEncoding("UTF-8");
		    res.setContentType("text/html;charset=UTF-8");
			System.err.println("---doPost - MIMSScheduler");
			//Automatically to reschedule on specific intervals.
			
			//JobMIMSSchedulerConnnection jmsc =new JobMIMSSchedulerConnnection();
			// to call internaly on specific intervals. 
			//jmsc.main();
			
			System.err.println("---doPost - After calling - MIMSScheduler");
		}
		catch(Exception e)	{
			 System.err.println("Exception in doGET - MIMSScheduler:"+e.toString());
			  e.printStackTrace();
			}
	} // End of doPost
	
	public static class JobMIMSSchedulerConnnection extends TimerTask {
		/*The main method will be invoked when Server gets Started initially*/
		public  void main (String... arguments ) {
			//Call CIMS
			CIMSExternalDataBaseBean CIMSBean = new CIMSExternalDataBaseBean();
			CIMSBean.releaseMIMSConnection();
			 
			//SchedulerBean CIMSBean = new SchedulerBean(); // Testing Purpose Bean is used, remove it later
			
			//CIMSBean.releaseMIMSConnection();  // Testing Purpose Bean is used, remove it later
			//CIMSBean.getMIMSInstance(); //Create Instance - Not required as per first request it will create MIMS instance and MIMS Connection

			TimerTask JobMIMSScheduler = new JobMIMSSchedulerConnnection(); // Scheduler
			Timer timer = new Timer();		
			// check for timer, when run method to be executed next time 
			timer.scheduleAtFixedRate(JobMIMSScheduler, schedulerTime(), PER_DAY_LONG_PERIOD);
		} //End of main 

		@Override public void run(){
    		try
			{
				System.err.println("RUN method......in Scheduler"+System.currentTimeMillis());
				JobMIMSSchedulerConnnection jmsc  =new JobMIMSSchedulerConnnection();  // JobScheduleCSSP executed 
				jmsc.main();
				System.err.println("RUN Method.. execution after - in Scheduler"+System.currentTimeMillis());
			}
			catch (Exception e)	
			{
				  System.err.println("Exception - run method - "+e.toString());
				  e.printStackTrace();
			} 
		} //End of run()
  
		private final static long PER_DAY_LONG_PERIOD = 1000*60*60*24;    //long period = 1000L * 60L * 60L * 24L;
   		// Schedule time to execute 11:30 Pm daily
		private Date schedulerTime(){
			//Calendar calendarNextDay = Calendar.getInstance();  //GregorianCalendar
			Calendar calendarNextDay = new GregorianCalendar();
		
			System.err.println("Get Time"+calendarNextDay+"calendarNextDay.Date"+calendarNextDay.DATE+"calendarNextDay.HOUR_OF_DAY"+calendarNextDay.HOUR_OF_DAY+"calendarNextDay.MINUTE"+calendarNextDay.MINUTE);
			calendarNextDay.add(Calendar.DATE, 1);
			//calendarNextDay.add(Calendar.MINUTE, 1);  // testing purpose remove after that
			//calendarNextDay.add(Calendar.SECOND, 55);  // testing purpose remove after that
			calendarNextDay.set(Calendar.HOUR_OF_DAY, 23);
			calendarNextDay.set(Calendar.MINUTE, 59);
			//calendarNextDay.set(Calendar.SECOND, 59);
	
			System.err.println("Get Time"+calendarNextDay);
			System.err.println("DAY_OF_MONTH"+calendarNextDay.DAY_OF_MONTH+"calendarNextDay.HOUR_OF_DAY"+calendarNextDay.HOUR_OF_DAY+"calendarNextDay.MINUTE"+calendarNextDay.MINUTE);
			System.err.println("calendarNextDay.getTime()"+calendarNextDay.getTime());
		return calendarNextDay.getTime();
	  } //End of schedulerTime
	} //End of JobMIMSSchedulerConnnection 
}// End of main MIMSScheduler