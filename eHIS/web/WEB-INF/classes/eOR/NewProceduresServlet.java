/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eOR ;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
//import eOR.NewProcedures.*;


public class NewProceduresServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	//String mysql;
	java.util.Properties p;
	//String facility;
	String facility_id ;

	long encounter_id=0;
	String temp_encounter_id=encounter_id+"";
	//String srl_no;
	String practitioner;
	String practitioner_id;
	//String practitioner_name;
	String patient_id;
	String proc_code;
	String proc_date;
	String record_type;
	String cause_indicator;
	String proc_code_scheme;
	String proc_narration;
	String hpi;
	String proc_summary;
	String findings;
	String impression;
	String disposition;
	//String locn_code;
	//String locn_type;
	//String proc_date1 ;
	String client_ip_address ;
	String patient_class ;
	String encounterid="";
	String addedById = "";
	//String serviceURL;
//	String objectName;
	HttpSession session;
	//java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
	StringBuffer sb = new StringBuffer();
	String enddate="";
	String	practitioner1="";
	String anaesthetists1="";
	String anaesthetists2="";
	String anaesthetists3="";
	String scrubnurse="";
	String anaesthesia="";
	String anesthesia_det="";
	String indication="";
	String monitor="";
	String events="";
	String postProcedure="";
	String specimen="";
	//final java.util.HashMap results=new HashMap();
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.
	ServletException,IOException
	{
		
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		this.facility_id = (String) session.getAttribute( "facility_id" ) ;

		client_ip_address = this.p.getProperty("client_ip_address");
		addedById  = this.p.getProperty( "login_user" ) ;
		
		res.setContentType("text/html");
		this.out = res.getWriter();
		insertProcedures(req, res);
	}

public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			doPost(req,res);		
		}
		catch(Exception e)	
		{	
			System.err.println("Exception in invoking doPost Method");
		}
	}

	private void insertProcedures(HttpServletRequest req, HttpServletResponse res)
	{
		Connection conn = null;
		PreparedStatement pstmt_srlno =null,pstmt= null;
		
		try
		{
			encounterid= req.getParameter("Encounter_Id") == null ? "" : req.getParameter("Encounter_Id");
			if(!encounterid.equals("")){
				encounter_id=(Long.valueOf(encounterid.trim())).longValue();
				temp_encounter_id=encounter_id+"";
			}

		//	practitioner		= req.getParameter("Practitioner_Id")== null ? "" : req.getParameter("Practitioner_Id");
			practitioner_id		= req.getParameter("Practitioner_Id")== null ? "" : req.getParameter("Practitioner_Id");

			patient_id			= req.getParameter("Patient_Id")== null ? "" : req.getParameter("Patient_Id");
			proc_code			= req.getParameter("code")== null ? "A02.0" : req.getParameter("code");
			proc_date			= req.getParameter("currentdate")== null ? "" : req.getParameter("currentdate");
		//	enddate				= req.getParameter("enddate")== null ? "" : req.getParameter("enddate");
		//	practitioner1		= req.getParameter("practitioner1")== null ? "" : req.getParameter("practitioner1");
		//	anaesthetists1		= req.getParameter("anaesthetists1")== null ? "" : req.getParameter("anaesthetists1");
		//	anaesthetists2		= req.getParameter("anaesthetists2")== null ? "" : req.getParameter("anaesthetists2");
		//	anaesthetists3		= req.getParameter("anaesthetists3")== null ? "" : req.getParameter("anaesthetists3");
		//	scrubnurse			= req.getParameter("scrubnurse")== null ? "" : req.getParameter("scrubnurse");
			anaesthesia			= req.getParameter("anesthesia")== null ? "" : req.getParameter("anesthesia");
			anesthesia_det		= req.getParameter("anesthesia_det")== null ? "" :req.getParameter("anesthesia_det");
			indication			= req.getParameter("indication")== null ? "" : req.getParameter("indication");
		//	monitor				= req.getParameter("monitor")== null ? "" : req.getParameter("monitor");
		//	events				= req.getParameter("events")== null ? "" : req.getParameter("events");
		//	postProcedure		= req.getParameter("postProcedure")== null ? "" : req.getParameter("postProcedure");
		//	specimen			= req.getParameter("specimen")== null ? "" : req.getParameter("specimen");
			record_type			= req.getParameter("record_type")== null ? "" : req.getParameter("record_type");
		//	cause_indicator		= req.getParameter("cause_indicator")== null ? "" : req.getParameter("cause_indicator");
			proc_code_scheme	= req.getParameter("proc_set")== null ? "ICD10" : req.getParameter("proc_set");
			proc_narration		= req.getParameter("description1")== null ? "Salmonella enteritis. Salmonellosis " : req.getParameter("description1");
		//	hpi					= req.getParameter("hpi")== null ? "" : req.getParameter("hpi");
		//	proc_summary		= req.getParameter("proceduresummary")== null ? "" : req.getParameter("proceduresummary");
		//	findings			= req.getParameter("findings")== null ? "" : req.getParameter("findings");
		//	impression			= req.getParameter("impression")== null ? "" : req.getParameter("impression");
		//	disposition			= req.getParameter("disposition")== null ? "" : req.getParameter("disposition");
			patient_class		= (req.getParameter("patient_class")==null)?"":req.getParameter("patient_class");

			//String order_id			= req.getParameter("order_id") == null ? "" : req.getParameter("order_id");
			//String order_line_num	= req.getParameter("order_line_num") == null ? "" : req.getParameter("order_line_num");
			//String mode				= req.getParameter("mode") == null ? "" : req.getParameter("mode");
			//String upd_pat_id		= req.getParameter("upd_pat_id")==null?"":req.getParameter("upd_pat_id");
			//String upd_srl_no		= req.getParameter("upd_srl_no")==null?"":req.getParameter("upd_srl_no");
			//String upd_encounter_id	= req.getParameter("upd_encounter_id")==null?"":req.getParameter("upd_encounter_id");
			//String modal_yn			= req.getParameter("modal_yn")==null?"N":req.getParameter("modal_yn");
			//String errorRemarks		= "";
			//errorRemarks		= req.getParameter("errorRemarks");

			
			//String priority=req.getParameter("priority")==null?"":req.getParameter("priority");
			//String nature=req.getParameter("nature")==null?"":req.getParameter("nature");
			//String multi_session=req.getParameter("multi_session")==null?"":req.getParameter("multi_session");
			//String consent=req.getParameter("consent")==null?"":req.getParameter("consent");
			String start_dt=req.getParameter("start_dt")==null?"":req.getParameter("start_dt");
			String end_dt=req.getParameter("end_dt")==null?"":req.getParameter("end_dt");
			
			//String multi_proc_records=req.getParameter("multi_proc_records")==null?"":req.getParameter("multi_proc_records");

			//String remarks=req.getParameter("remarks")==null?"":req.getParameter("remarks");
			//String reason=req.getParameter("reason")==null?"":req.getParameter("reason");
			//String outcome=req.getParameter("outcome")==null?"":req.getParameter("outcome");
			//String status=req.getParameter("status")==null?"":req.getParameter("status");

			//String med_team=req.getParameter("med_team")==null?"":req.getParameter("med_team");
			//String role=req.getParameter("role0")==null?"":req.getParameter("role0");
			//String pract_code=req.getParameter("pract_code0")==null?"":req.getParameter("pract_code0");
			//String pract_type_code=req.getParameter("pract_type_code0")==null?"":req.getParameter("pract_type_code0");
			//String postn_code=req.getParameter("postn_code0")==null?"":req.getParameter("postn_code0");


			/*StringTokenizer st = new StringTokenizer(practitioner,"|");
			while(st.hasMoreTokens())
			{
				practitioner_id = st.nextToken();
					st.nextToken();
				//practitioner_name  = st.nextToken();
			}
		
		 if(cause_indicator.equals("null"))
			cause_indicator="";
		 */
		
		 
		conn = ConnectionManager.getConnection(req);
			
		pstmt_srlno = conn.prepareStatement("select NVL(max(srl_no),0)+1  from pr_encounter_procedure where facility_id=? and encounter_id=?");
		pstmt = conn.prepareStatement("insert into   pr_encounter_procedure(facility_id,encounter_id,srl_no, practitioner_id,patient_id, proc_code,proc_date, record_type,cause_indicator,proc_code_scheme, proc_narration,hpi, proc_summary,findings, impression,disposition,added_by_id,added_date, added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,patient_class,order_id,order_line_num, start_datetime,end_datetime ,  ass_practitioner1,  ass_practitioner2, anaesthetist1, anaesthetist2,  anaesthetist3, anaesthesia_code, anaesthesia_detail, indication, monitoring, events,post_proc_std_orders, specimen_sent, scrub_nurse) values (?, ?, ?, ?, ?, ?, TO_DATE(?,'DD/MM/YYYY hh24:mi'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?,?,TO_DATE(?,'DD/MM/YYYY hh24:mi'),TO_DATE(?,'DD/MM/YYYY hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?)");	
        
		
		int srl_no=0;
		boolean result = false;
		java.util.HashMap results=new HashMap();
		StringBuffer sb = new StringBuffer( "" ) ;
		ResultSet no_gen = null;
		/*code that generates srl_no starts here*/
		
		pstmt_srlno.setString(1,facility_id);
		pstmt_srlno.setLong (2,encounter_id);
		no_gen=pstmt_srlno.executeQuery();
		if(no_gen !=null && no_gen.next())
			srl_no=no_gen.getInt(1);
			
		try
            {
   
				/*code that inserts record/s starts here*/
                
                pstmt.setString ( 1, facility_id ) ;
                pstmt.setLong   ( 2, encounter_id ) ;
                pstmt.setInt    ( 3, srl_no  ) ;
                pstmt.setString ( 4, practitioner_id ) ;
                pstmt.setString ( 5, patient_id ) ;
                pstmt.setString ( 6, proc_code ) ;
                pstmt.setString ( 7, proc_date ) ;
                pstmt.setString ( 8, record_type ) ;
                pstmt.setString ( 9, "" ) ;//cause_indicator
                pstmt.setString ( 10, proc_code_scheme ) ;
                pstmt.setString ( 11, proc_narration ) ;//proc_narration
                pstmt.setString ( 12, "" ) ;//hpi
                pstmt.setString ( 13, "" ) ;//proc_summary
                pstmt.setString ( 14, "" ) ;//findings
                pstmt.setString ( 15, "" ) ;//impression
                pstmt.setString ( 16, "" ) ;//disposition
                pstmt.setString ( 17, addedById ) ;
                pstmt.setTimestamp( 18,new java.sql.Timestamp(System.currentTimeMillis())) ;
                pstmt.setString ( 19, client_ip_address ) ;
                pstmt.setString ( 20, facility_id ) ;
                pstmt.setString ( 21, addedById ) ;
                pstmt.setTimestamp( 22,new java.sql.Timestamp(System.currentTimeMillis())) ;
                pstmt.setString ( 23, client_ip_address ) ;
                pstmt.setString ( 24, facility_id ) ;
                pstmt.setString ( 25, patient_class) ;
                pstmt.setString ( 26, "" ) ;//order_id
                pstmt.setString ( 27, "") ;//order_line_num
                pstmt.setString ( 28, start_dt ) ;//start_datetime
                pstmt.setString ( 29, end_dt ) ;//enddate
                pstmt.setString ( 30, practitioner_id) ;
                pstmt.setString ( 31, "" ) ;//practitioner1
                pstmt.setString ( 32, "") ;//anaesthetists1
                pstmt.setString ( 33, "" ) ;//anaesthetists2
                pstmt.setString ( 34, "" ) ;//anaesthetists3
                pstmt.setString ( 35, anaesthesia) ;
                pstmt.setString ( 36, anesthesia_det ) ;//anaesthesDet
                pstmt.setString ( 37, indication) ;
                pstmt.setString ( 38, "" ) ;//monitor
                pstmt.setString ( 39, "" ) ;//events
                pstmt.setString ( 40, "") ;//postProcedure
                pstmt.setString ( 41, "" ) ;//specimen
                pstmt.setString ( 42, "") ;//scrubnurse
             
				int rows_inserted =0;
				try{
                rows_inserted = pstmt.executeUpdate() ;
				}catch(Exception e){

					e.printStackTrace();
				}

                if ( rows_inserted != 0 )
                {
                    result = true ;
                    conn.commit() ;
                    sb.append( "APP-SM0001 Operation Completed Successfully" ) ;
                }
                else{
                    sb.append("Insertion failed ===") ;
					conn.rollback();
				}
            }
            catch ( Exception e ) {
                    conn.rollback();
            }

			finally{
				if(no_gen!=null) no_gen.close();
				if(pstmt_srlno!=null) pstmt_srlno.close();
				if(pstmt!=null) pstmt.close();
				
			}

			
			
		results.put( "status", new Boolean(result) ) ;
        results.put( "error", sb.toString() ) ;

			
			
			
			/*InitialContext context = new InitialContext();
			Object homeObject = context.lookup("java:comp/env/Procedures");
			final ProceduresManagerHome ProceduresManagerHome = (ProceduresManagerHome ) PortableRemoteObject.narrow(homeObject,ProceduresManagerHome.class);
			final ProceduresManagerRemote ProceduresManagerRemote = ProceduresManagerHome.create();*/
/*
		if(mode.equals("OR")){
			
			order_line_num = "1";

		boolean local_ejbs = false;
	
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/Procedures",ProceduresManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);		
				
		Object argArray[] = new Object[33];
		argArray[0] = p;
		argArray[1] = temp_encounter_id;
		argArray[2] = practitioner_id;
		argArray[3] = patient_id;
		argArray[4] = proc_code;
		argArray[5] = proc_date;
		argArray[6] = record_type;
		argArray[7] = cause_indicator;
		argArray[8] = proc_code_scheme;
		argArray[9] = proc_narration;
		argArray[10] = hpi;
		argArray[11] = proc_summary;
		argArray[12] = findings;
		argArray[13] = impression;
		argArray[14] = disposition;
		argArray[15] = client_ip_address;
		argArray[16] = facility_id;
		argArray[17] = patient_class;
		argArray[18] = order_id;
		argArray[19] = order_line_num;
		argArray[20] = enddate;
		argArray[21] = practitioner1;
		argArray[22] = anaesthetists1;
		argArray[23] = anaesthetists2;
		argArray[24] = anaesthetists3;
		argArray[25] = scrubnurse;
		argArray[26] = anaesthesia;
		argArray[27] = anaesthesDet;
		argArray[28] = indication;
		argArray[29] = monitor;
		argArray[30] = events;
		argArray[31] = postProcedure;
		argArray[32] = specimen;
		
				
		Class [] paramArray = new Class[33];
		
		paramArray[0] = p.getClass();
		paramArray[1] = temp_encounter_id.getClass();
		paramArray[2] = practitioner_id.getClass();
		paramArray[3] = patient_id.getClass();
		paramArray[4] = proc_code.getClass();
		paramArray[5] = proc_date.getClass();
		paramArray[6] = record_type.getClass();
		paramArray[7] = cause_indicator.getClass();
		paramArray[8] = proc_code_scheme.getClass();
		paramArray[9] = proc_narration.getClass();
		paramArray[10] = hpi.getClass();
		paramArray[11] = proc_summary.getClass();
		paramArray[12] = findings.getClass();
		paramArray[13] = impression.getClass();
		paramArray[14] = disposition.getClass();
		paramArray[15] = client_ip_address.getClass();
		paramArray[16] = facility_id.getClass();
		paramArray[17] = patient_class.getClass();
		paramArray[18] = order_id.getClass();
		paramArray[19] = order_line_num.getClass();
		paramArray[20] = enddate.getClass();
		paramArray[21] = practitioner1.getClass();
		paramArray[22] = anaesthetists1.getClass();
		paramArray[23] = anaesthetists2.getClass();
		paramArray[24] = anaesthetists3.getClass();
		paramArray[25] = scrubnurse.getClass();
		paramArray[26] = anaesthesia.getClass();
		paramArray[27] = anaesthesDet.getClass();
		paramArray[28] = indication.getClass();
		paramArray[29] = monitor.getClass();
		paramArray[30] = events.getClass();
		paramArray[31] = postProcedure.getClass();
		paramArray[32] = specimen.getClass();
		
				
 results = (java.util.HashMap)(busObj.getClass().getMethod("insertProcedure",paramArray)).invoke(busObj,argArray);
		
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			
			tempInserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			if(tempInserted){
				callOrBuildCprProcedures(req,order_id,addedById,client_ip_address,facility_id);
			}

		}else{

		boolean local_ejbs = false;
	
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/Procedures",ProceduresManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		

					
		Object argArray[] = new Object[33];
		argArray[0] = p;
		argArray[1] = temp_encounter_id;
		argArray[2] = practitioner_id;
		argArray[3] = patient_id;
		argArray[4] = proc_code;
		argArray[5] = proc_date;
		argArray[6] = record_type;
		argArray[7] = cause_indicator;
		argArray[8] = proc_code_scheme;
		argArray[9] = proc_narration;
		argArray[10] = hpi;
		argArray[11] = proc_summary;
		argArray[12] = findings;
		argArray[13] = impression;
		argArray[14] = disposition;
		argArray[15] = client_ip_address;
		argArray[16] = facility_id;
		argArray[17] = patient_class;
		argArray[18] = order_id;
		argArray[19] = order_line_num;
		argArray[20] = enddate;
		argArray[21] = practitioner1;
		argArray[22] = anaesthetists1;
		argArray[23] = anaesthetists2;
		argArray[24] = anaesthetists3;
		argArray[25] = scrubnurse;
		argArray[26] = anaesthesia;
		argArray[27] = anaesthesDet;
		argArray[28] = indication;
		argArray[29] = monitor;
		argArray[30] = events;
		argArray[31] = postProcedure;
		argArray[32] = specimen;
		
				
		Class [] paramArray = new Class[33];
		
		paramArray[0] = p.getClass();
		paramArray[1] = temp_encounter_id.getClass();
		paramArray[2] = practitioner_id.getClass();
		paramArray[3] = patient_id.getClass();
		paramArray[4] = proc_code.getClass();
		paramArray[5] = proc_date.getClass();
		paramArray[6] = record_type.getClass();
		paramArray[7] = cause_indicator.getClass();
		paramArray[8] = proc_code_scheme.getClass();
		paramArray[9] = proc_narration.getClass();
		paramArray[10] = hpi.getClass();
		paramArray[11] = proc_summary.getClass();
		paramArray[12] = findings.getClass();
		paramArray[13] = impression.getClass();
		paramArray[14] = disposition.getClass();
		paramArray[15] = client_ip_address.getClass();
		paramArray[16] = facility_id.getClass();
		paramArray[17] = patient_class.getClass();
		paramArray[18] = order_id.getClass();
		paramArray[19] = order_line_num.getClass();
		paramArray[20] = enddate.getClass();
		paramArray[21] = practitioner1.getClass();
		paramArray[22] = anaesthetists1.getClass();
		paramArray[23] = anaesthetists2.getClass();
		paramArray[24] = anaesthetists3.getClass();
		paramArray[25] = scrubnurse.getClass();
		paramArray[26] = anaesthesia.getClass();
		paramArray[27] = anaesthesDet.getClass();
		paramArray[28] = indication.getClass();
		paramArray[29] = monitor.getClass();
		paramArray[30] = events.getClass();
		paramArray[31] = postProcedure.getClass();
		paramArray[32] = specimen.getClass();

		results = (java.util.HashMap)(busObj.getClass().getMethod("insertProcedure",paramArray)).invoke(busObj,argArray);
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
							
						
		}//end of else
*/
		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		String error = (String) results.get("error") ;
				String error_value = "0" ;
				String modal_yn = "N",errorRemarks="" ;

									
				if ( inserted )
				{
					 error_value = "1" ;

					 res.sendRedirect("../eOR/jsp/NewProcedureMessage.jsp?err_num=" +( error ) + "&err_value=" +error_value+"&modal_yn="+modal_yn+"&errorRemarks="+errorRemarks);
				}
				else
				{
					  res.sendRedirect("../eOR/jsp/NewProcedureMessage.jsp?err_num=" +( error ) + "&err_value=" +error_value+"&modal_yn="+modal_yn);
				}

			
			}
			catch ( Exception e )
			{
				e.printStackTrace();
				//out.println( facility_id+ " "+temp_encounter_id+ " "+ practitioner_id+" "+patient_id+" "+proc_code+ " " +record_type+ " " +cause_indicator+ " " +proc_code_scheme+ " " +proc_narration+ " " +hpi+ " " +proc_summary+ " " +findings+ " " +impression+ " "+disposition);
				//out.println(sb.toString());
		}
		finally
		{
		  if(conn != null) ConnectionManager.returnConnection(conn,req);
		}
	}

	//public boolean callOrBuildCprProcedures(HttpServletRequest req,String order_id,String order_line_num,String addedById,String client_ip_address,String facility_id){
	public boolean callOrBuildCprProcedures(HttpServletRequest req,String order_id,String addedById,String client_ip_address,String facility_id){
		Connection con = null;
		CallableStatement cstmt = null;
		boolean returnValue = false;
		try{
			con = ConnectionManager.getConnection(req);
			cstmt = con.prepareCall("{ call OR_BUILD_CPT_PROCEDURES(?,?,?,?,?,?) }");

			cstmt.setString(1,order_id);
			cstmt.setInt(2,1);
			cstmt.setString(3,addedById);
			cstmt.setString(4,client_ip_address);
			cstmt.setString(5,facility_id);
			cstmt.registerOutParameter(6,Types.VARCHAR);
			cstmt.execute();
			String temp = cstmt.getString(6);
			
			
			if(temp == null)
				returnValue = true;
			else
				returnValue = false;

		}catch(Exception e){
			returnValue = false;
			System.err.println("OR_BUILD_CPT_PROCEDURES="+e);
		}finally{
			try{
				if(cstmt != null) cstmt.close();
				if(con != null) ConnectionManager.returnConnection(con,req);
			}catch(Exception e){}
		}
		return returnValue;
	}
}
