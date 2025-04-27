/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      	Name        	Description
--------------------------------------------------------------------------------------------------------------
?             100            	?           	created
13/12/2012	IN026966			Vijayakumark	Procedure recording screen accepts procedure code in lower case when typed. 
												Then while querying the function, the description is not shown. 
												The hyperlink to mark it as error or view details of audit trail are then disabled.
20/01/2012	CHL-CRF [IN035950]	Ramesh G		CHL-CRF [IN035950]	
15/03/2022    36285          Hariharan k       	              MMs-DM-CRF-0221.v1.0(003)
---------------------------------------------------------------------------------------------------------------
*/

package eCA ;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import eCA.Procedures.*;
import eCommon.XSSRequestWrapper;
public class ProceduresServlet extends javax.servlet.http.HttpServlet
{		
	//final java.util.HashMap results=new HashMap();
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.
	ServletException,IOException
	{
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
req= new XSSRequestWrapper(req); //MOHE-SCF-0153
res.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
res.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		PrintWriter out = res.getWriter();
		HttpSession session;
		
		try
		{		
			session = req.getSession(false);
		
			out = res.getWriter();
			insertProcedures(req, res,session,out);
		}
		catch(Exception e)
		{
			//out.print(e);//common-icn-0181
			e.printStackTrace();
		}
		
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = res.getWriter();
		try
		{
			doPost(req,res);		
		}
		catch(Exception e)	
		{	
			out.println("Exception in invoking doPost Method");
			e.printStackTrace();
		}
	}

	private void insertProcedures(HttpServletRequest req, HttpServletResponse res, HttpSession session, PrintWriter out)
	{
		java.util.Properties p = null;
		String facility_id = "";
		long encounter_id = 0;
		String temp_encounter_id=encounter_id+"";
		String practitioner = "";
		String practitioner_id = "";
		String patient_id = "";
		String proc_code = "";
		String proc_date = "";
		String record_type = "";
		String cause_indicator = "";
		String proc_code_scheme = "";
		String proc_narration = "";
		String hpi = "";
		String proc_summary = "";
		String findings = "";
		String impression = "";
		String disposition = "";
		String client_ip_address = "";
		String patient_class = "";
		String encounterid = "";
		String addedById = "";
		String enddate = "";
		String practitioner1 = "";
		String anaesthetists1 = "";
		String anaesthetists2 = "";
		String anaesthetists3 = "";
		String scrubnurse = "";
		String anaesthesia = "";
		String anaesthesDet = "";
		String indication = "";
		String monitor = "";
		String events = "";
		String postProcedure = "";
		String specimen = "";
		String locale ="";
		String laterality = "";
		String location = "";
		String practitioner2 = "";
		String accession_number			= "";
		String p_called_from_widget = "";  //CHL-CRF [IN035950]
		String classifition_type = "";//  36285
		

		try
		{
			p = (java.util.Properties) session.getValue( "jdbc" ) ;
			locale = p.getProperty("LOCALE");
			
			facility_id = (String) session.getValue( "facility_id" ) ;
			client_ip_address = p.getProperty("client_ip_address");
			addedById  = p.getProperty( "login_user" ) ;
			encounterid= req.getParameter("encounterid") == null ? "" : req.getParameter("encounterid");
			if(!encounterid.equals("")){
				encounter_id=(Long.valueOf(encounterid.trim())).longValue();
				temp_encounter_id=encounter_id+"";
			}

			practitioner		= req.getParameter("practitioner")== null ? "" : req.getParameter("practitioner");

			patient_id			= req.getParameter("patientid")== null ? "" : req.getParameter("patientid");
			proc_code			= req.getParameter("code")== null ? "" : req.getParameter("code");
			proc_code           =  proc_code.toUpperCase();//IN026966 
			proc_date			= req.getParameter("date")== null ? "" : req.getParameter("date");
			enddate				= req.getParameter("enddate")== null ? "" : req.getParameter("enddate");
			practitioner1		= req.getParameter("practitioner1")== null ? "" : req.getParameter("practitioner1");
			anaesthetists1		= req.getParameter("anaesthetists1")== null ? "" : req.getParameter("anaesthetists1");
			anaesthetists2		= req.getParameter("anaesthetists2")== null ? "" : req.getParameter("anaesthetists2");
			anaesthetists3		= req.getParameter("anaesthetists3")== null ? "" : req.getParameter("anaesthetists3");
			scrubnurse			= req.getParameter("scrubnurse")== null ? "" : req.getParameter("scrubnurse");
			anaesthesia			= req.getParameter("anaesthesia")== null ? "" : req.getParameter("anaesthesia");
			anaesthesDet		= req.getParameter("anaesthesDet")== null ? "" : req.getParameter("anaesthesDet");
			indication			= req.getParameter("indication")== null ? "" : req.getParameter("indication");
			monitor				= req.getParameter("monitor")== null ? "" : req.getParameter("monitor");
			events				= req.getParameter("events")== null ? "" : req.getParameter("events");
			postProcedure		= req.getParameter("postProcedure")== null ? "" : req.getParameter("postProcedure");
			specimen			= req.getParameter("specimen")== null ? "" : req.getParameter("specimen");
			//proc_date1 = req.getParameter("date")== null ? "" : req.getParameter("date");
			record_type			= req.getParameter("record_type")== null ? "" : req.getParameter("record_type");
			cause_indicator		= req.getParameter("cause_indicator")== null ? "" : req.getParameter("cause_indicator");
			//proc_code_scheme = req.getParameter("s_scheme")== null ? "" : req.getParameter("s_scheme");
			proc_code_scheme	= req.getParameter("proc_set")== null ? "" : req.getParameter("proc_set");
			proc_narration		= req.getParameter("description1")== null ? "" : req.getParameter("description1");
			hpi					= req.getParameter("hpi")== null ? "" : req.getParameter("hpi");
			proc_summary		= req.getParameter("proceduresummary")== null ? "" : req.getParameter("proceduresummary");
			findings			= req.getParameter("findings")== null ? "" : req.getParameter("findings");
			impression			= req.getParameter("impression")== null ? "" : req.getParameter("impression");
			disposition			= req.getParameter("disposition")== null ? "" : req.getParameter("disposition");
			patient_class		= (req.getParameter("patient_class")==null)?"":req.getParameter("patient_class");
			laterality			= (req.getParameter("laterality")==null)?"":req.getParameter("laterality");
			location			= (req.getParameter("Location")==null)?"":req.getParameter("Location");
			practitioner2		= (req.getParameter("practitioner2")==null)?"":req.getParameter("practitioner2");

			proc_date			= com.ehis.util.DateUtils.convertDate(proc_date,"DMYHM",locale,"en");
			enddate				= com.ehis.util.DateUtils.convertDate(enddate,"DMYHM",locale,"en");

			String order_id			= req.getParameter("order_id") == null ? "" : req.getParameter("order_id");
			String order_line_num	= req.getParameter("order_line_num") == null ? "" : req.getParameter("order_line_num");
			String mode				= req.getParameter("mode") == null ? "" : req.getParameter("mode");
			String upd_pat_id		= req.getParameter("upd_pat_id")==null?"":req.getParameter("upd_pat_id");
			String upd_srl_no		= req.getParameter("upd_srl_no")==null?"":req.getParameter("upd_srl_no");
			String upd_encounter_id	= req.getParameter("upd_encounter_id")==null?"":req.getParameter("upd_encounter_id");
			String modal_yn			= req.getParameter("modal_yn")==null?"N":req.getParameter("modal_yn");
			accession_number			= req.getParameter("accession_number")==null?"":req.getParameter("accession_number");
			String errorRemarks		= "";
			errorRemarks		= req.getParameter("errorRemarks");	
			p_called_from_widget	= req.getParameter("p_called_from_widget")==null?"":req.getParameter("p_called_from_widget"); //CHL-CRF[IN035950]
			practitioner_id = practitioner;
		    classifition_type = req.getParameter("p_classifition_type")==null?"":req.getParameter("p_classifition_type");// 36285
//			StringTokenizer st = new StringTokenizer(practitioner,"|");

//			while(st.hasMoreTokens())
//			{
//				practitioner_id = st.nextToken();
//					st.nextToken();
				//practitioner_name  = st.nextToken();
//			}

		boolean tempInserted = false;
		 if(cause_indicator.equals("null"))
			
		 	cause_indicator="";
		 java.util.HashMap results=new HashMap();
			
         	/*InitialContext context = new InitialContext();
			Object homeObject = context.lookup("java:comp/env/Procedures");
			final ProceduresManagerHome ProceduresManagerHome = (ProceduresManagerHome ) PortableRemoteObject.narrow(homeObject,ProceduresManagerHome.class);
			final ProceduresManagerRemote ProceduresManagerRemote = ProceduresManagerHome.create();*/
		if(mode.equals("update")){
       
			/*results = ProceduresManagerRemote.updateProcedure(p,
																	upd_encounter_id,
																	practitioner_id,
																	upd_pat_id,
																	proc_code,
																	proc_date,
																	proc_narration,
																	hpi,
																	proc_summary,
																	findings,
																	impression,
																	disposition,
																	client_ip_address,
																	facility_id,
																	addedById,
																	upd_srl_no,
																			enddate,																			
																			practitioner1,			
																			anaesthetists1,		
																			anaesthetists2,		
																			anaesthetists3,		
																			scrubnurse,			
																			anaesthesia,								
																			anaesthesDet,		
																			indication,				
																			monitor,					
																			events	,					
																			postProcedure,		
																			specimen,
																			errorRemarks
																	);*/
			boolean local_ejbs = false;
	
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/Procedures",ProceduresManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		
		Object argArray[] = new Object[36];// 36285
		argArray[0] = p;
		argArray[1] = upd_encounter_id;
		argArray[2] = practitioner_id;
		argArray[3] = upd_pat_id;
		argArray[4] = proc_code;
		argArray[5] = proc_date;
		argArray[6] = proc_narration;
		argArray[7] = hpi;
		argArray[8] = proc_summary;
		argArray[9] = findings;
		argArray[10] = impression;
		argArray[11] = disposition;
		argArray[12] = client_ip_address;
		argArray[13] = facility_id;
		argArray[14] = addedById;
		argArray[15] = upd_srl_no;
		argArray[16] = enddate;
		argArray[17] = practitioner1;
		argArray[18] = anaesthetists1;
		argArray[19] = anaesthetists2;
		argArray[20] = anaesthetists3;
		argArray[21] = scrubnurse;
		argArray[22] = anaesthesia;
		argArray[23] = anaesthesDet;
		argArray[24] = indication;
		argArray[25] = monitor;
		argArray[26] = events;
		argArray[27] = postProcedure;
		argArray[28] = specimen;
		argArray[29] = errorRemarks;
		argArray[30] = locale;
		argArray[31] = laterality;
		argArray[32] = location;
		argArray[33] = practitioner2;
		argArray[34] = accession_number;
		argArray[35] =classifition_type;// 36285
		

		Class [] paramArray = new Class[36];// 36285
		
		paramArray[0] = p.getClass();
		paramArray[1] = upd_encounter_id.getClass();
		paramArray[2] = practitioner_id.getClass();
		paramArray[3] = upd_pat_id.getClass();
		paramArray[4] = proc_code.getClass();
		paramArray[5] = proc_date.getClass();
		paramArray[6] = proc_narration.getClass();
		paramArray[7] =  hpi.getClass();
		paramArray[8] = proc_summary.getClass();
		paramArray[9] = findings.getClass();
		paramArray[10] = impression.getClass();
		paramArray[11] = disposition.getClass();
		paramArray[12] = client_ip_address.getClass();
		paramArray[13] = facility_id.getClass();
		paramArray[14] = addedById.getClass();
		paramArray[15] = upd_srl_no.getClass();
		paramArray[16] = enddate.getClass();
		paramArray[17] = practitioner1.getClass();
		paramArray[18] = anaesthetists1.getClass();
		paramArray[19] = anaesthetists2.getClass();
		paramArray[20] = anaesthetists3.getClass();
		paramArray[21] = scrubnurse.getClass();
		paramArray[22] = anaesthesia.getClass();
		paramArray[23] = anaesthesDet.getClass();
		paramArray[24] = indication.getClass();
		paramArray[25] = monitor.getClass();
		paramArray[26] = events.getClass();
		paramArray[27] = postProcedure.getClass();
		paramArray[28] = specimen.getClass();
		paramArray[29] = errorRemarks.getClass();
		paramArray[30] = locale.getClass();
		paramArray[31] = laterality.getClass();
		paramArray[32] = location.getClass();
		paramArray[33] = practitioner2.getClass();
		paramArray[34] = accession_number.getClass();
		paramArray[35] = classifition_type.getClass();// 36285
		
		results = (java.util.HashMap)(busObj.getClass().getMethod("updateProcedure",paramArray)).invoke(busObj,argArray);
		
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			tempInserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			if(tempInserted && order_id != null && !order_id.equals("") ){
				order_line_num	="1";
				//callOrBuildCprProcedures(req,order_id,order_line_num,addedById,client_ip_address,facility_id);
				callOrBuildCprProcedures(req,order_id,addedById,client_ip_address,facility_id,out);
			}

			

		}else if(mode.equals("OR")){
			
			order_line_num = "1";
			/*results = ProceduresManagerRemote.insertProcedure(p,
																	encounter_id,														  				
																	practitioner_id,														  				
																	patient_id,																  				
																	proc_code,															  				
																	proc_date,																  				
																	record_type,															  				
																	cause_indicator,													  				
																	proc_code_scheme,											  				
																	proc_narration,														  				
																	hpi,																			  				
																	proc_summary,													  				
																	findings,																	  				
																	impression,															  				
																	disposition,															  				
																	client_ip_address,												  				
																	facility_id,																  				
																	practitioner_name,												  				
																	locn_code,															  				
																	locn_type,																  				
																	proc_date1,															  				
																	patient_class,
																	order_id,
																	order_line_num,
																							enddate,						
																							practitioner1,			
																							anaesthetists1,		
																							anaesthetists2,		
																							anaesthetists3,		
																							scrubnurse,			
																							anaesthesia,			
																							anaesthesDet,		
																							indication,				
																							monitor,					
																							events,						
																							postProcedure,		
																							specimen				
																	);*/
		boolean local_ejbs = false;
	
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/Procedures",ProceduresManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);		
				
		Object argArray[] = new Object[39];// 36285
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
		//argArray[17] = practitioner_name;
		//argArray[18] = locn_code;
		//argArray[19] = locn_type;
		//argArray[20] = proc_date1;
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
		argArray[33] = locale;
		argArray[34] = laterality;
		argArray[35] = location;
		argArray[36] = practitioner2;
		argArray[37] = accession_number;
		argArray[38] = classifition_type;// 36285
		
				
		Class [] paramArray = new Class[39];// 36285
		
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
		//paramArray[17] = practitioner_name.getClass();
		//paramArray[18] = locn_code.getClass();
		//paramArray[19] = locn_type.getClass();
		//paramArray[20] = proc_date1.getClass();
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
		paramArray[33] = locale.getClass();
		paramArray[34] = laterality.getClass();
		paramArray[35] = location.getClass();
		paramArray[36] = practitioner2.getClass();
		paramArray[37] = accession_number.getClass();
		paramArray[38] = classifition_type.getClass();// 36285
		
				
 results = (java.util.HashMap)(busObj.getClass().getMethod("insertProcedure",paramArray)).invoke(busObj,argArray);
		
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			
			tempInserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			//results.clear();

			if(tempInserted){
				//callOrBuildCprProcedures(req,order_id,order_line_num,addedById,client_ip_address,facility_id);
				callOrBuildCprProcedures(req,order_id,addedById,client_ip_address,facility_id,out);
			}


		}else{
    
		boolean local_ejbs = false;
	
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/Procedures",ProceduresManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		

			/*results = ProceduresManagerRemote.insertProcedure(p,
																	encounter_id,
																	practitioner_id,
																	patient_id,
																	proc_code,
																	proc_date,
																	record_type,
																	cause_indicator,
																	proc_code_scheme,
																	proc_narration,
																	hpi,
																	proc_summary,
																	findings,
																	impression,
																	disposition,
																	client_ip_address,
																	facility_id,
																	practitioner_name,
																	locn_code,
																	locn_type,
																	proc_date1,
																	patient_class,
																	order_id,
																	order_line_num,
																	enddate,						
																	practitioner1,			
																	anaesthetists1,		
																	anaesthetists2,		
																	anaesthetists3,		
																	scrubnurse,			
																	anaesthesia,			
																	anaesthesDet,		
																	indication,				
																	monitor,					
																	events	,					
																	postProcedure,		
																	specimen
											);*/

		

			
		
		Object argArray[] = new Object[39];// 36285
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
		//argArray[17] = practitioner_name;
		//argArray[18] = locn_code;
		//argArray[19] = locn_type;
		//argArray[20] = proc_date1;
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
		argArray[33] = locale;
		argArray[34] = laterality;
		argArray[35] = location;
		argArray[36] = practitioner2;
		argArray[37] = accession_number;
		argArray[38] = classifition_type;// 36285
		
				
		Class [] paramArray = new Class[39];// 36285
		
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
		//paramArray[17] = practitioner_name.getClass();
		//paramArray[18] = locn_code.getClass();
		//paramArray[19] = locn_type.getClass();
		//paramArray[20] = proc_date1.getClass();
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
		paramArray[33] = locale.getClass();
		paramArray[34] = laterality.getClass();
		paramArray[35] = location.getClass();
		paramArray[36] = practitioner2.getClass();
		paramArray[37] = accession_number.getClass();
		paramArray[38] = classifition_type.getClass();// 36285
		results = (java.util.HashMap)(busObj.getClass().getMethod("insertProcedure",paramArray)).invoke(busObj,argArray);
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
						
						}//end of else

						boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
						String error = (String) results.get("error") ;
						results.clear();
						String error_value = "0" ;
											
						if(inserted)
						{
	                  		if(mode.equals("OR") && modal_yn.equals("Y"))//Added by Jyothi to fix IN026248 on 03/02/2010
							{
								out.println("<script>alert('"+error+"');</script>");
								out.println("<script>parent.window.close();</script>");
							}
							else
							{
								error_value = "1" ;
								//CHL-CRF End.[IN035950]
									//res.sendRedirect("../eCA/jsp/ProcedureError.jsp?err_num=" +java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value=" +error_value+"&modal_yn="+modal_yn+"&errorRemarks="+errorRemarks);
									res.sendRedirect("../eCA/jsp/ProcedureError.jsp?err_num=" +java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value=" +error_value+"&modal_yn="+modal_yn+"&errorRemarks="+errorRemarks+"&p_called_from_widget="+p_called_from_widget);
								//CHL-CRF End.[IN035950]
							}
						}
						else
						{
							//CHL-CRF End.[IN035950]
								//res.sendRedirect("../eCA/jsp/ProcedureError.jsp?err_num=" +java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value=" +error_value+"&modal_yn="+modal_yn);
								res.sendRedirect("../eCA/jsp/ProcedureError.jsp?err_num=" +java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value=" +error_value+"&modal_yn="+modal_yn+"&p_called_from_widget="+p_called_from_widget);
							//CHL-CRF End.[IN035950]
						}

					
					}
					catch ( Exception e )
					{
						//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
						e.printStackTrace();
						//out.println( "Values sent are : <br>" ) ;//common-icn-0181
						out.println( facility_id+ " "+temp_encounter_id+ " "+ practitioner_id+" "+patient_id+" "+proc_code+ " " +record_type+ " " +cause_indicator+ " " +proc_code_scheme+ " " +proc_narration+ " " +hpi+ " " +proc_summary+ " " +findings+ " " +impression+ " "+disposition);
				}
	}

	public boolean callOrBuildCprProcedures(HttpServletRequest req,String order_id,String addedById,String client_ip_address,String facility_id, PrintWriter out){
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

			con.commit();

			String temp = cstmt.getString(6);
			if(temp == null)
				returnValue = true;
			else
				returnValue = false;

		}catch(Exception e){
			returnValue = false;
			//out.println("OR_BUILD_CPT_PROCEDURES="+e);//common-icn-0181
			e.printStackTrace();
			
		}finally{
			try{
				if(cstmt != null) cstmt.close();
				if(con != null) ConnectionManager.returnConnection(con,req);
			}catch(Exception e){}
		}
		return returnValue;
	}
}
