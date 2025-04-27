
package eMR.smrp;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import java.text.*;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
  

public class GeneratePD207 extends HttpServlet 
{ 

	PrintWriter out;
	java.util.Properties p;

	/*This function will be invoked when Server Started- for this it has entry in web.xml*/
	/*public void init(ServletConfig config) throws ServletException	
	{

		super.init(config);
		//This gets called without user action. If this has to be called on specific intervals, the same has to be handled inside the main method.
		JobSchedulePD207 js =new JobSchedulePD207();
		// to call a sub routine which will call the main mathod based on preset intervals.
		js.main();

	}*/
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException 
	{
		try	
		{ 
			req.setCharacterEncoding("UTF-8");
		    res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			doPost(req,res);
			
		}
		catch(Exception e)	{
			System.err.println("Exception in doGet function:"+e.toString());
			  e.printStackTrace();

			}
	}
				

	/* called when the report is generatede form application*/
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException 
	{
		try	
		{
			

			String from_date 	  = req.getParameter("rep_date");
			String to_date   	  = req.getParameter("rep_date");
			String facility_id    = req.getParameter("hmis_hospital");
			String locale    = req.getParameter("locale");
			
			
			String dir  		  = System.getProperty("user.dir");	

			req.setCharacterEncoding("UTF-8");
		    res.setContentType("text/html;charset=UTF-8");
			
		/*This will make call to createPD207 function which will create the JSON file*/
			GeneratePD207 Gjson= new GeneratePD207();

			String PD207_fileCreated_flag =Gjson.createPD207(facility_id,from_date,to_date);

			String error="";
			if(PD207_fileCreated_flag.equals("1")){
				error= "SMRP_FILE_GENERATED";
			}else if (PD207_fileCreated_flag.equals("0")){
				error= "SMRP_FILE_NOT_GENERATED";
			}else if (PD207_fileCreated_flag.equals("2")){
				error= "SMRP_FILE_PATH_NO_SPECIFY";
			}
			Hashtable hashtable1 = MessageManager.getMessage(locale, error,"MR");
			error = (String)hashtable1.get("message");
			
			res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + PD207_fileCreated_flag );
			
		}
		catch(Exception e)	{
			 System.err.println("Exception in doPost function:"+e.toString());
			  e.printStackTrace();
			}
	}

/*This function will Create the Json based on the Parameters*/
	public String createPD207(String facility_id,String start_date,String end_date)					
	{ 
		
		Connection con = null;
		ResultSet rset = null;
		Statement stmt =  null;

		String fileCreated = "0";
		
		int Count  				= 0;
		String filename="";
		LogSMRP smrpLogger=new LogSMRP();
		int file_count=0;
		String fl_name="";
		try {			
		
			Date currentdate = new Date();
			SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
			int def_duration=0;
			
			//String dir="\\\\cscappche608\\eHIS\\WCHSMRP"; //This has to be read from the db.
			String dir=""; //This has to be read from the db.

			con =   ConnectionManager.getConnection();
			stmt =  con.createStatement();
			
			//System.out.println("");
			rset =  stmt.executeQuery("select VALUE_1 file_path, nvl(VALUE_2,0) def_duration  from SM_FUNCTION_CONTROL where module_id='MR' and functionality_id='SMRP' and SITE_ID=(select customer_id from sm_site_param)");
			if(rset!= null && rset.next()){
				dir=rset.getString("file_path");
				def_duration=rset.getInt("def_duration");
			}

			rset.close();
			stmt.close();

			if(dir.equals("") && def_duration==0) {
				fileCreated="2";
   			    System.out.println(" No dir path --> "+dir +"or no def_duration "+def_duration+" -->"+filename);
			}else{
			
				GregorianCalendar cal = new GregorianCalendar();
				cal.setTime(currentdate);
				cal.add(Calendar.DATE, - 1);
				currentdate=cal.getTime();
				cal.setTime(currentdate);
				cal.add(Calendar.DATE, - def_duration);
				Date pastdate = cal.getTime();


				/*when Date is not passed from Front end, it will consider Current Date and Current Date - 7*/
				String from_date 	  = start_date.equals("") ? ft.format(pastdate):start_date; 
				//String to_date   	   = end_date.equals("") ? ft.format(currentdate):end_date;
				String to_date   	   = end_date.equals("") ? ft.format(pastdate):end_date;

				start_date=from_date;
				end_date=to_date;

				
				/*The View which is created for this PD207Json purpose*/

				String mapped_fac_id=facility_id;

				stmt =  con.createStatement();
				rset =  stmt.executeQuery("SELECT ext_pk_id  FROM xh_oth_appl_data_skey WHERE table_id = 'SM_FACILITY_PARAM' AND pk_value ='"+facility_id+"' AND application_id = 'SMRP'");
				
				if(rset!=null && rset.next()){
					mapped_fac_id=rset.getString("EXT_PK_ID");
				}
				rset.close();
				stmt.close();

				filename       = mapped_fac_id+"_"+from_date.replaceAll("/","")+"_"+to_date.replaceAll("/",""); 	

				String[]  arr_from_dt = from_date.split("/");
				String[]  arr_to_dt = to_date.split("/");

				
				
				System.out.println("179 filename-->"+filename);

				String from_date_mon="";
				String to_date_mon="";

				from_date=arr_from_dt[2]+"-"+arr_from_dt[1]+"-"+arr_from_dt[0];
				to_date=arr_to_dt[2]+"-"+arr_to_dt[1]+"-"+arr_to_dt[0];

				if (arr_from_dt[1].equals ("01") || arr_from_dt[1].equals ("03") || arr_from_dt[1].equals ("05") || arr_from_dt[1].equals ("07") || arr_from_dt[1].equals ("08") || arr_from_dt[1].equals ("10") || arr_from_dt[1].equals ("12") ) {
					from_date_mon=arr_from_dt[2]+"-"+arr_from_dt[1]+"-01";
					to_date_mon=arr_to_dt[2]+"-"+arr_to_dt[1]+"-31";
				}

				if (arr_from_dt[1].equals ("04") || arr_from_dt[1].equals ("06") || arr_from_dt[1].equals ("09") || arr_from_dt[1].equals ("11")  ) {
					from_date_mon=arr_from_dt[2]+"-"+arr_from_dt[1]+"-01";
					to_date_mon=arr_to_dt[2]+"-"+arr_to_dt[1]+"-30";
				}

				if (arr_from_dt[1].equals ("02") ) {
					from_date_mon=arr_from_dt[2]+"-"+arr_from_dt[1]+"-01";

					if(arr_from_dt[2].equals("2000") || arr_from_dt[2].equals("2004") || arr_from_dt[2].equals("2008") || arr_from_dt[2].equals("2012") || arr_from_dt[2].equals("2016") ||		arr_from_dt[2].equals("2020") || arr_from_dt[2].equals("2024") || arr_from_dt[2].equals("2028")|| arr_from_dt[2].equals("2032") || arr_from_dt[2].equals("2036") || arr_from_dt[2].equals("2040")) {
						to_date_mon=arr_to_dt[2]+"-"+arr_to_dt[1]+"-29";
					}else{
						to_date_mon=arr_to_dt[2]+"-"+arr_to_dt[1]+"-28";
					}
				}

				String refServiceTypeCode="01";
				fl_name="";
			
				//String[] ServiceType_arr={"IP","PD","OP","PL","DC","RH"};
				String cen_mon=arr_from_dt[1]+"/"+arr_from_dt[2];
				//String pat_class="";
				
				//for (int kk=0;kk<ServiceType_arr.length;kk++){  -- commented as single PD207 for all patient class
					//pat_class=ServiceType_arr[kk];
					//System.out.println("pat_class-->"+pat_class);
					//System.out.println(ServiceType_arr[kk+1]);
					//fl_name=filename+ServiceType_arr[kk+1]+"_PD207";  commented as single PD 207 to genarte irrespective of patient class.
					fl_name=filename+"_PD207";
					System.out.println("fl_name"+fl_name);

					/*This query will return the service code for which JSON file need to be generated*/
					
					/*stmt =  con.createStatement();  // block commented to hard code refServiceTypeCode as 01 as per mail from Sri Thu 8/30/2018 1:12 PM
					rset =  stmt.executeQuery("select EXT_PK_ID from  XH_OTH_APPL_DATA_SKEY WHERE table_id='AM_PATIENT_CLASS' and APPLICATION_ID='SMRP' and PK_VALUE='"+pat_class+"'");
					
					

				
					if(rset!=null && rset.next()){
						refServiceTypeCode=rset.getString("EXT_PK_ID");
					}
					rset.close();
					stmt.close();*/

									
					StringBuffer str_head=new StringBuffer("");
					str_head.append("{\"filename\": \""+fl_name+"\",\"refServiceTypeCode\": \""+refServiceTypeCode+"\",\"formType\": \"207\",\"facilityCode\": \""+mapped_fac_id+"\",");
					str_head.append("\"censusDateFrom\": \""+from_date_mon+"\",\"censusDateTo\": \""+to_date_mon+"\",\"monthlySurgicalCensus\": [");


					//kk=kk+1;
					//String sqlQuery		  = "select count(*) TOT_AL,SERVICE_CODE_MAP,SURGICAL_TYPE_CODE from MR_PD207_VW  WHERE to_char(REPORTING_DATE,'mm/yyyy')='"+cen_mon+"'  and PAT_CLASS='"+pat_class+"' and facility_id='"+facility_id+"' group by SERVICE_CODE_MAP,SURGICAL_TYPE_CODE order by SERVICE_CODE_MAP";

					// query changed as single file ot be generated for al lpatinet class.

					String sqlQuery		  = "select count(*) TOT_AL,SERVICE_CODE_MAP,SURGICAL_TYPE_CODE from MR_PD207_VW  WHERE to_char(REPORTING_DATE,'mm/yyyy')='"+cen_mon+"'  and facility_id='"+facility_id+"' group by SERVICE_CODE_MAP,SURGICAL_TYPE_CODE order by SERVICE_CODE_MAP";

					//String sqlQuery		  = "select count(*) TOT_AL,SERVICE_CODE_MAP,SURGICAL_TYPE_CODE from MR_PD207_VW  WHERE to_char(REPORTING_DATE,'dd/mm/yyyy')='05/03/2018'  and PAT_CLASS='"+pat_class+"' and facility_id='"+facility_id+"' group by SERVICE_CODE_MAP,SURGICAL_TYPE_CODE order by SERVICE_CODE_MAP";

					System.out.println("67");
					stmt =  con.createStatement();
					rset = stmt.executeQuery(sqlQuery);
					System.out.println(sqlQuery);
				

					StringBuffer str_foot=new StringBuffer("");

					StringBuffer service_head= new StringBuffer("");
					StringBuffer details_head= new StringBuffer("");

					int i=0;
					
					String Service_code="";
					String SurgicalTypeCode="";
					String refSurgicalClassCode="00";
					String old_ser_cd="";
					String ot_cd="00";
					 while(rset!=null && rset.next()) 	{  	 // looping
							
								file_count=file_count+1;
								
								SurgicalTypeCode=rset.getString("SURGICAL_TYPE_CODE");
								if (!Service_code.equals(rset.getString("SERVICE_CODE_MAP"))){
								
									if(!Service_code.equals("")){
										details_head.append("]");
										service_head.append(details_head.toString());
										service_head.append("} ,");
										str_head.append(service_head.toString());
										
										service_head=new StringBuffer("");
										details_head=new StringBuffer("");
									}

									Service_code=checkForNull(rset.getString("SERVICE_CODE_MAP"));
									
									service_head.append("{");
									service_head.append("\"year\": \""+arr_from_dt[2]+"\",");
									service_head.append("\"month\": \""+arr_from_dt[1]+"\",");
									service_head.append("\"refDisciplineCode\": \""+Service_code+"\",");
									
									
									
									service_head.append("\"details\": [");

									details_head.append("{ \"refSurgicalTypeCode\": \""+SurgicalTypeCode+"\",");
									details_head.append("\"refSurgicalClassCode\": \""+ot_cd+"\",");
									details_head.append("\"total\": \""+checkForNull(rset.getString("TOT_AL"))+"\" } ");
									
								}else{
									
									details_head.append(",{ \"refSurgicalTypeCode\": \""+SurgicalTypeCode+"\",");
									details_head.append("\"refSurgicalClassCode\": \""+ot_cd+"\",");
									details_head.append("\"total\": \""+checkForNull(rset.getString("TOT_AL"))+"\" } ");
									
									
									/*service_head.append(details_head.toString());
									service_head.append("} ,");
									str_head.append(service_head.toString());
									
									service_head=new StringBuffer("");
									details_head=new StringBuffer("");*/
								
								}
									
						
						i++;
					 }// while loop for  

					service_head.append(details_head.toString());
					service_head.append(" ] }");
					str_head.append(service_head.toString());
				 

					str_foot.append(" 	 ]	}");

					str_head.append(str_foot.toString());

					fl_name=fl_name+".json";

					if(i>0){
					
						try{
							
							System.out.println("dir-->"+dir);
							//FileWriter file = new FileWriter(dir+"\\"+filename+"_PD207.json");/*File is Created with Json object as data in specific folder*/
							
							System.out.println("309 fl_name-->"+fl_name);
							dir=dir+fl_name;
							System.out.println("dir-->"+dir);
							File PD207json = new File (dir);
							FileWriter file = new FileWriter(PD207json);/*File is Created with Json object as data in specific folder*/
							System.out.println("PD207json.getPath()-->"+PD207json.getPath());
							System.out.println("PD207json.getAbsolutePath()-->"+PD207json.getAbsolutePath());
							System.out.println("PD207json.getName()-->"+PD207json.getName());

							
							//str_head.append(str_foot.toString());
							file.write(str_head.toString());
							fileCreated="1";
							System.out.println("fileCreated@746-->"+fileCreated);
							smrpLogger.logSMRPStatus(con,fileCreated,fl_name,start_date,"PD207",PD207json.getAbsolutePath());
							file.flush();
							file.close();

							if(dir.equals("")){
								fileCreated="2";
								 System.out.println("Error while file obj  PD207 generation. No dir path-->"+fl_name);
								 smrpLogger.logSMRPStatus(con,fileCreated,fl_name,start_date,"PD207","File creation path is not defined");
							}

						} catch (IOException e) {
							fileCreated="2";
							System.err.println("Exception in createPD207 function Inside try:"+e.toString());
							System.out.println("Error while file obj  PD207 generation-->"+fl_name+"-->"+e.toString());
							smrpLogger.logSMRPStatus(con,fileCreated,fl_name,start_date,"PD207","IO Error. Unable to create File for PD207 generation");
							e.printStackTrace();
						}
					}else{ // no data for file generation
						System.out.println("No data for PD207 generation-->"+fl_name);
						fileCreated="0";
						smrpLogger.logSMRPStatus(con,fileCreated,fl_name,start_date,"PD207","No data for PD207 generation");
					}
				//}// for loop for IP,OP,DC  commented as single PD207 for all pat class
					
			}	 //check in function control				
		
		}catch (Exception e) {
			  System.err.println("Exception in createPD207 function outside try:"+e.toString());
			  smrpLogger.logSMRPStatus(con,fileCreated,fl_name,start_date,"PD207",e.toString());
			  fileCreated="0";
			  e.printStackTrace();
		}finally{
			try{
				rset.close();
				stmt.close();
				ConnectionManager.returnConnection(con);
			}catch(Exception ex){
			}
		}
		if(file_count>0){
			fileCreated="1";
		}
		return fileCreated;
	}

	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}
	


/*public static class JobSchedulePD207 extends TimerTask {

 //The main method will be invoked when Server is Started
  public  void main (String... arguments ) {
    TimerTask JobSchedulePD207 = new JobSchedulePD207();
   
    Timer timer = new Timer();
    //After main mehtod is invoked, it will check for the time at which the run method has to be invoked 
    timer.scheduleAtFixedRate(JobSchedulePD207, getTomorrowMorning12am(), fONCE_PER_DAY);
  }
  
  @Override public void run(){
    	
try
		{
    	Connection con = null;
		ResultSet rset = null;
		Statement stmt =  null;
		
    GeneratePD207 Gjson= new GeneratePD207();
    con =   ConnectionManager.getConnection();
		
		stmt =  con.createStatement();
		//for all the facility the job will run, if the facility has data it will create the Json file for that else it will not create file
		rset =  stmt.executeQuery("select facility_id from sm_facility_param  where facility_id!='DF' and STATUS='E'	");
 while(rset!=null && rset.next())
		{  	
	
    Gjson.createPD207(rset.getString("facility_id"),"","");
    
}
		rset.close();
		stmt.close();
		ConnectionManager.returnConnection(con);
}
		catch (Exception e)	
		{
			  System.err.println("Exception in run method of JobSchedulePD207 Class:::"+e.toString());
			  e.printStackTrace();
		}
  }
  

	  private final static long fONCE_PER_DAY = 1000*60*60*24;

	  private final static int fONE_DAY = 1;
	  private final static int fZEROHOUR = 00;
	  private final static int fZERO_MINUTES = 20; 

	//The function will retutn the time at which the process has to be run
	  private  Date getTomorrowMorning12am(){
		Calendar tomorrow = new GregorianCalendar();
		tomorrow.add(Calendar.DATE, fONE_DAY);
		Calendar result = new GregorianCalendar(
		  tomorrow.get(Calendar.YEAR),
		  tomorrow.get(Calendar.MONTH),
		  tomorrow.get(Calendar.DATE),
		  fZEROHOUR,
		  fZERO_MINUTES
		);
		return result.getTime();
	  }
}
*/

	
	
	
}
