
<%@page import="java.sql.*,java.util.*, eCA.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	
	StringTokenizer rowTok = null;
	StringTokenizer colTok = null;
	String arrVal ="";
	request.setCharacterEncoding("UTF-8");
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	String operation_mode = request.getParameter("operation_mode")==null?"":request.getParameter("operation_mode");
	String bean_key = request.getParameter("bean_key")==null?"":request.getParameter("bean_key");

	if(operation_mode.equals("addAllToBean"))
	{

		eCA.PatientBannerGroupLine multiTransBean = null;
		java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p1.getProperty("LOCALE");
		String facility_id		=	(String) session.getValue("facility_id");
		String resp_id = (String)session.getValue("responsibility_id");
		
		Connection con = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;

		StringBuffer transReqQry = new StringBuffer();
		String patientId ="";
		String practitionerId ="";
		String speciality_code ="";
		String location_code ="";
		String service_code ="";
		String CurrentDate ="";
		String CurrentTime = "";
		String transcriber = "";
		String notes = "";
		String hash_key = "";
		String hash_value = "";
		String patient_id ="";
		String encounter_id ="";
		String pline ="";
		String rsAdmission_date_time ="";
		String attend_practitioner_id ="";
		String locn_type_crit		 =	"";

		patientId			=	(request.getParameter("patientId")==null)	?	""	:	request.getParameter("patientId");
		practitionerId			=	(request.getParameter("practitionerId")==null)	?	""	:	request.getParameter("practitionerId");
		speciality_code			=	(request.getParameter("speciality_code")==null)	?	""	:	request.getParameter("speciality_code");
		location_code			=	(request.getParameter("location_code")==null)	?	""	:	request.getParameter("location_code");
		service_code			=	(request.getParameter("service_code")==null)	?	""	:	request.getParameter("service_code");
		CurrentDate			=	(request.getParameter("CurrentDate")==null)	?	""	:	request.getParameter("CurrentDate");
		CurrentTime			=	(request.getParameter("CurrentTime")==null)	?	""	:	request.getParameter("CurrentTime");
		locn_type_crit			=	(request.getParameter("locn_type")==null)	?	""	:	request.getParameter("locn_type");

		bean_key = practitionerId+CurrentDate+CurrentTime;

		multiTransBean = (eCA.PatientBannerGroupLine)getObjectFromBean("multiTransBean"+bean_key,"eCA.PatientBannerGroupLine",session);

		transReqQry.append("select b.PATIENT_ID,b.ENCOUNTER_ID,get_patient.get_line_detail(b.PATIENT_ID,?) Pline, to_char(b.ADMISSION_DATE_TIME,'DD/MM/YYYY HH24:MI') ADMISSION_DATE_TIME ,nvl(b.ATTEND_PRACTITIONER_ID,b.ADMIT_PRACTITIONER_ID) ATTEND_PRACTITIONER_ID,CA_GET_DEFAULT_TRANSCRIBER(?,b.SPECIALTY_CODE,b.PATIENT_CLASS) DEFAULT_TRANSCRIBER,CA_GET_DEFAULT_NOTES(?,?,b.SPECIALTY_CODE) DEFAULT_NOTE,PAT_CURR_LOCN_CODE LOCN_CODE from IP_OPEN_ENCOUNTER b where b.facility_id= ? and b.ATTEND_PRACTITIONER_ID= ? ");

	if(!speciality_code.equals(""))
		transReqQry.append("and b.SPECIALTY_CODE=? ");
	if(!patientId.equals(""))
		transReqQry.append("and b.PATIENT_ID =? ");
	
	if(!locn_type_crit.equals(""))
		transReqQry.append("and PAT_CURR_LOCN_TYPE = ? ");

	if(!location_code.equals(""))
		transReqQry.append("and b.NURSING_UNIT_CODE =? ");
	if(!service_code.equals(""))
		transReqQry.append("and b.SERVICE_CODE=? "); //

	   transReqQry.append(" UNION ALL SELECT a.PATIENT_ID,a.ENCOUNTER_ID,get_patient.get_line_detail(a.PATIENT_ID,?) Pline,to_char(a.ARRIVE_DATE_TIME,'DD/MM/YYYY HH24:MI') ADMISSION_DATE_TIME,PRACTITIONER_ID ATTEND_PRACTITIONER_ID,CA_GET_DEFAULT_TRANSCRIBER(?,a.SPECIALITY_CODE,a.PATIENT_CLASS) DEFAULT_TRANSCRIBER,CA_GET_DEFAULT_NOTES(?,?,a.SPECIALITY_CODE) DEFAULT_NOTE,PAT_CURR_LOCN_CODE LOCN_CODE from op_patient_queue a where a.FACILITY_ID=? and a.PRACTITIONER_ID=? ");

	if(!speciality_code.equals(""))
		transReqQry.append("and a.SPECIALITY_CODE=? ");
	if(!patientId.equals(""))
		transReqQry.append("and a.PATIENT_ID =? ");
	if(!locn_type_crit.equals(""))
		transReqQry.append("and PAT_CURR_LOCN_TYPE = ? ");
	
	if(!location_code.equals(""))
		transReqQry.append("and a.PAT_CURR_LOCN_CODE =? ");
	if(!service_code.equals(""))
		transReqQry.append("and a.SERVICE_CODE=? ");

		transReqQry.append(" Order By LOCN_CODE ");

		try
		{

			con =  ConnectionManager.getConnection(request);
			stmt = con.prepareStatement(transReqQry.toString());
			int count1=0;
			
			stmt.setString(++count1,locale);
			stmt.setString(++count1,practitionerId);
			stmt.setString(++count1,practitionerId);
			stmt.setString(++count1,resp_id);
			stmt.setString(++count1,facility_id);
			stmt.setString(++count1,practitionerId);
			
			if(!speciality_code.equals(""))
				stmt.setString(++count1,speciality_code);
			if(!patientId.equals(""))
				stmt.setString(++count1,patientId);
			if(!locn_type_crit.equals(""))
				stmt.setString(++count1,locn_type_crit);
			if(!location_code.equals(""))
				stmt.setString(++count1,location_code);
			if(!service_code.equals(""))
				stmt.setString(++count1,service_code);

			stmt.setString(++count1,locale);
			stmt.setString(++count1,practitionerId);
			stmt.setString(++count1,practitionerId);
			stmt.setString(++count1,resp_id);
			stmt.setString(++count1,facility_id);
			stmt.setString(++count1,practitionerId);

			if(!speciality_code.equals(""))
				stmt.setString(++count1,speciality_code);
			if(!patientId.equals(""))
				stmt.setString(++count1,patientId);
			if(!locn_type_crit.equals(""))
				stmt.setString(++count1,locn_type_crit);
			if(!location_code.equals(""))
				stmt.setString(++count1,location_code);
			if(!service_code.equals(""))
				stmt.setString(++count1,service_code);
			
			rs = stmt.executeQuery();

			while(rs.next())
			{

				patient_id = rs.getString("PATIENT_ID")==null?"":rs.getString("PATIENT_ID");
				encounter_id = rs.getString("ENCOUNTER_ID")==null?"":rs.getString("ENCOUNTER_ID");
				pline = rs.getString("Pline")==null?"":rs.getString("Pline");
				pline =pline.replaceAll("\\|",",");
				rsAdmission_date_time = rs.getString("ADMISSION_DATE_TIME")==null?"":rs.getString("ADMISSION_DATE_TIME");
				attend_practitioner_id = rs.getString("ATTEND_PRACTITIONER_ID")==null?"":rs.getString("ATTEND_PRACTITIONER_ID");
				transcriber = rs.getString("DEFAULT_TRANSCRIBER")==null?"":rs.getString("DEFAULT_TRANSCRIBER");
				notes = rs.getString("DEFAULT_NOTE")==null?"":rs.getString("DEFAULT_NOTE");

				hash_key = patient_id+"~"+encounter_id;
				hash_value = patient_id+"~"+encounter_id+"~"+transcriber+"~"+notes;

				if(!multiTransBean.ContainsKey(hash_key))
				{
					multiTransBean.addToHashMap(hash_key,hash_value);
				}
			
			}

			if(rs!=null) rs.close();
			if(stmt!=null)stmt.close();



			putObjectInBean("multiTransBean"+bean_key,multiTransBean,session);

		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		finally 
		{
			ConnectionManager.returnConnection(con,request);
		}
	}
	else if(operation_mode.equals("addToBean"))
	{
		
		eCA.PatientBannerGroupLine multiTransBean = null;

		String hashKey ="";
		String hashValue ="";
		
		multiTransBean = (eCA.PatientBannerGroupLine)getObjectFromBean("multiTransBean"+bean_key,"eCA.PatientBannerGroupLine",session);

		String final_string = request.getParameter("final_string")==null?"":request.getParameter("final_string");

		try{
		rowTok = new StringTokenizer(final_string,"`");

		while(rowTok.hasMoreTokens())
		{
			
			arrVal = (String) rowTok.nextToken();
			colTok = new StringTokenizer(arrVal,"~");

			while(colTok.hasMoreTokens())
			{

				hashKey =(String)colTok.nextToken()+"~"+(String)colTok.nextToken();
				
				colTok.nextToken();
				colTok.nextToken();
				hashValue = arrVal;

				if(!multiTransBean.ContainsKey(hashKey))
				{
					multiTransBean.addToHashMap(hashKey,hashValue);
				}

			}
	
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}


		putObjectInBean("multiTransBean"+bean_key,multiTransBean,session);


	}
	else if(operation_mode.equals("remove"))
	{
		
		String patient_id ="";
		String encounter_id ="";
		String mode ="";
		
		eCA.PatientBannerGroupLine multiTransBean = null;
		
		bean_key = request.getParameter("bean_key")==null?"":request.getParameter("bean_key");
		patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		mode = request.getParameter("mode")==null?"":request.getParameter("mode");
				
		arrVal = patient_id+"~"+encounter_id;

		multiTransBean = (eCA.PatientBannerGroupLine)getObjectFromBean("multiTransBean"+bean_key,"eCA.PatientBannerGroupLine",session);

		if(mode.equals("Add"))
		{
			
			if(!(multiTransBean.returnList1().contains(arrVal)))
			{
				multiTransBean.addRecordstoLine1(arrVal);
			}
		}
		else if (mode.equals("Rem"))
		{
			if((multiTransBean.returnList1().contains(arrVal)))
			{
				multiTransBean.remRecordsFromLine1(arrVal);
			}

		}


		putObjectInBean("multiTransBean"+bean_key,multiTransBean,session);	

	}
	else if(operation_mode.equals("addNoteToBean"))
	{
		eCA.PatientBannerGroupLine multiTransBean = null;
		
		String patient_id ="";
		String encounter_id ="";
		String transcriber ="";
		String note_type ="";
		//String mode ="";

		String hash_key ="";
		String hash_value ="";
		
		
		bean_key = request.getParameter("bean_key")==null?"":request.getParameter("bean_key");
		patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		transcriber = request.getParameter("transcriber")==null?"":request.getParameter("transcriber");
		note_type = request.getParameter("note_type")==null?"":request.getParameter("note_type");

		multiTransBean = (eCA.PatientBannerGroupLine)getObjectFromBean("multiTransBean"+bean_key,"eCA.PatientBannerGroupLine",session);
		
		hash_key = patient_id+"~"+encounter_id;
		hash_value = patient_id+"~"+encounter_id+"~"+transcriber+"~"+note_type;
		


		if(!multiTransBean.ContainsKey(hash_key))
		{
			multiTransBean.addToHashMap(hash_key,hash_value);
		}
		
		
		putObjectInBean("multiTransBean"+bean_key,multiTransBean,session);
	}
	else if(operation_mode.equals("getSpecialty"))
	{

		Connection con = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;

		java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p1.getProperty("LOCALE");
		
		String practitionerId ="";
		String speciality_code ="";
		String primary_speciality ="";

		practitionerId			=	(request.getParameter("practitionerId")==null)	?	""	:	request.getParameter("practitionerId");

		String speciality_qry= "select PRIMARY_SPECIALITY_CODE, am_get_desc.AM_SPECIALITY(PRIMARY_SPECIALITY_CODE,?,1 ) PRIMARY_SPECIALITY from am_practitioner where PRACTITIONER_ID= ? ";

		try
		{
			con =  ConnectionManager.getConnection(request);
			stmt = con.prepareStatement(speciality_qry);
			stmt.setString(1,locale);
			stmt.setString(2,practitionerId);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
							
				speciality_code = rs.getString("PRIMARY_SPECIALITY_CODE")==null?"":rs.getString("PRIMARY_SPECIALITY_CODE");
				primary_speciality = rs.getString("PRIMARY_SPECIALITY")==null?"":rs.getString("PRIMARY_SPECIALITY");
			}

				if(rs!=null) rs.close();
				if(stmt!=null)stmt.close();

				out.println("parent.MultiTransRequestCriteriFrame.MultiTransRequestCriteriaForm.speciality.value='"+primary_speciality+"'");
				out.println("parent.MultiTransRequestCriteriFrame.MultiTransRequestCriteriaForm.speciality_code.value='"+speciality_code+"'");
				


		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		finally 
		{
			ConnectionManager.returnConnection(con,request);
		}

	}
	else if(operation_mode.equals("selCount"))
	{
		
	
		eCA.PatientBannerGroupLine multiTransBean = null;
		bean_key = request.getParameter("bean_key")==null?"":request.getParameter("bean_key");
		
		multiTransBean = (eCA.PatientBannerGroupLine)getObjectFromBean("multiTransBean"+bean_key,"eCA.PatientBannerGroupLine",session);
		
		if(multiTransBean.returnHashMap().isEmpty())
		{
			
			out.println("callfunction('false');");
		}
		else
		{
			out.println("callfunction('true');");
			
		}

	}

%>
