<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*,java.util.StringTokenizer,java.util.TreeMap" %>
<jsp:useBean id="MedicalReportReq" class="webbeans.eCommon.RecordSet" scope="session"/> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<HTML>
<head>
	<title><fmt:message key="eMR.ViewEncounterDetails.label" bundle="${mr_labels}"/></title>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<body OnMouseDown='CodeArrest();' onKeyDown='lockKey()'>
<form name='enc_detail' id='enc_detail' >
<%

request.setCharacterEncoding("UTF-8");
String classValue		= "";
String FacilityId		= (String) session.getValue( "facility_id" ) ;	
String locale			= (String)session.getAttribute("LOCALE");
String call_function	= checkForNull(request.getParameter("call_function"));
String PatientId		= checkForNull(request.getParameter("PatientId"));
String request_id		= checkForNull(request.getParameter("request_id"));

if(call_function.equals("MEDICAL_REPORT_STATUS") || call_function.equals("FORWARD_MEDICAL_REPORT") || call_function.equals("PREPARE_MEDICAL_REPORT") || call_function.equals("RECEIVE_MEDICAL_REPORT") || call_function.equals("DELIVER_MEDICAL_REPORT") || call_function.equals("REVISE_MEDICAL_REPORT") || call_function.equals("MEDICAL_REPORT_COMPLETED") || call_function.equals("MEDICAL_REPORT_CANCELLED") )
{	
	%>
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<tr>
			<th align='center' nowrap><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></th> 
			<th align='center' nowrap><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/></th> 
			<th align='center' nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
			<th align='center' nowrap><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></th>
			<th align='center' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
			<th align='center' nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
			<th align='center' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>
			<th align='center' nowrap><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/></th>
		</tr>
<%
	Statement stmt	= null;
	Statement stmt1	= null; // added by N Munisekhar on 21-AUG-2013 against RUT-SCF-0282 [IN:042499]
	ResultSet rset	= null;
	ResultSet rset_hdr	= null;
	Connection con	= null;
	try
	{
		con = ConnectionManager.getConnection(request);	
		String sql = " select ENCOUNTER_ID from MR_REPORT_REQUEST_DTL where facility_id= '"+FacilityId+"' and patient_id = '"+PatientId+"' and request_id='"+request_id+"' ";

		if(stmt!=null) stmt.close();
		stmt	= con.createStatement();
		rset	= stmt.executeQuery(sql);

		if (rset != null)
		{
			int classColor = 1;
			while(rset.next())
			{
			
				String Enc_ID=rset.getString("ENCOUNTER_ID");		

				if ( classColor % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;

				//String hdr_sql = " SELECT  (CASE WHEN a.specialty_code IS NOT NULL THEN (SELECT short_desc FROM am_speciality WHERE speciality_code = a.specialty_code) END ) speciality_desc, (CASE WHEN a.assign_care_locn_type = 'C' THEN (SELECT short_desc FROM op_clinic WHERE facility_id = a.facility_id AND clinic_code = a.assign_care_locn_code) WHEN a.assign_care_locn_type = 'N' THEN (SELECT short_desc FROM ip_nursing_unit WHERE facility_id = a.facility_id AND nursing_unit_code = a.assign_care_locn_code) END ) locn_desc, (CASE WHEN a.attend_practitioner_id IS NOT NULL THEN ( SELECT practitioner_name FROM am_practitioner WHERE practitioner_id = a.attend_practitioner_id) END ) practitioner_name, DECODE (a.assign_care_locn_type,'C', 'Clinic','N', 'Nursing Unit') locn_type, TO_CHAR (a.discharge_date_time,'dd/mm/yy hh24:mi') discharge_date_time , (CASE WHEN a.patient_class IS NOT NULL THEN (SELECT short_desc FROM am_patient_class WHERE patient_class = a.patient_class) END) patient_class, TO_CHAR (a.visit_adm_date_time,'dd/mm/yy hh24:mi') visit_adm_date_time FROM PR_ENCOUNTER a, MP_PATIENT b WHERE a.patient_id = b.patient_id AND b.patient_id = '"+PatientId+"' and ENCOUNTER_ID = '"+Enc_ID+"' AND a.facility_id = '"+FacilityId+"' ";

                // modified by N Munisekhar on 21-AUG-2013 against RUT-SCF-0282 [IN:042499]
				String hdr_sql = " SELECT (CASE WHEN a.specialty_code IS NOT NULL THEN (SELECT short_desc FROM AM_SPECIALITY_LANG_VW WHERE speciality_code = a.specialty_code and language_id='"+locale+"') END ) speciality_desc, (CASE WHEN a.assign_care_locn_type = 'C' THEN (SELECT short_desc FROM OP_CLINIC_LANG_VW WHERE facility_id = a.facility_id and language_id='"+locale+"' AND clinic_code = a.assign_care_locn_code) WHEN a.assign_care_locn_type = 'N' THEN (SELECT short_desc FROM IP_NURSING_UNIT_LANG_VW WHERE facility_id = a.facility_id AND nursing_unit_code = a.assign_care_locn_code and language_id='"+locale+"') END ) locn_desc, (CASE WHEN a.attend_practitioner_id IS NOT NULL THEN ( SELECT practitioner_name FROM AM_PRACTITIONER_LANG_VW WHERE practitioner_id = a.attend_practitioner_id and language_id='"+locale+"') END ) practitioner_name, a.assign_care_locn_type locn_type, TO_CHAR (a.discharge_date_time,'dd/mm/yyyy hh24:mi') discharge_date_time , (CASE WHEN a.patient_class IS NOT NULL THEN (SELECT short_desc FROM AM_PATIENT_CLASS_LANG_VW WHERE patient_class = a.patient_class and language_id='"+locale+"') END) patient_class, TO_CHAR (a.visit_adm_date_time,'dd/mm/yyyy hh24:mi') visit_adm_date_time FROM PR_ENCOUNTER a, MP_PATIENT b WHERE a.patient_id = b.patient_id AND b.patient_id = '"+PatientId+"' and ENCOUNTER_ID = '"+Enc_ID+"' AND a.facility_id = '"+FacilityId+"' ";

				stmt1	= con.createStatement();
				rset_hdr= stmt1.executeQuery(hdr_sql);
				if (rset_hdr != null && rset_hdr.next())
				{
					String visit_adm_date_time		= checkForNull(rset_hdr.getString("visit_adm_date_time"),"&nbsp;");
					if(!(visit_adm_date_time==null || visit_adm_date_time.equals("&nbsp;")))
					visit_adm_date_time	= DateUtils.convertDate(visit_adm_date_time,"DMYHM","en",locale);


					String enc_type		= checkForNull(rset_hdr.getString("patient_class"),"&nbsp;");
					String locn_type	= checkForNull(rset_hdr.getString("locn_type"),"&nbsp;");
					if(locn_type.equals("C"))
						locn_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
					else if(locn_type.equals("N"))
						locn_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
					String location		= checkForNull(rset_hdr.getString("locn_desc"),"&nbsp;");
					String practitioner= checkForNull(rset_hdr.getString("practitioner_name"),"&nbsp;");
					String speciality = checkForNull(rset_hdr.getString("speciality_desc"),"&nbsp;");

					String dis_date	= checkForNull(rset_hdr.getString("discharge_date_time"),"&nbsp;");

					if(!(dis_date==null || dis_date.equals("&nbsp;")))
					dis_date	= DateUtils.convertDate(dis_date,"DMYHM","en",locale);


					out.println("<tr>");				
					out.println("<td nowrap class='"+classValue+"'>" +enc_type+"</td>");
					out.println("<td nowrap class='"+classValue+"'>" +visit_adm_date_time+"</td>");
					out.println("<td nowrap class='"+classValue+"'>" +Enc_ID+"</td>");
					out.println("<td nowrap class='"+classValue+"'>" +locn_type+"</td>");
					out.println("<td nowrap class='"+classValue+"'>" +location+"</td>");
					out.println("<td nowrap class='"+classValue+"'>" +practitioner+"</td>");
					out.println("<td nowrap class='"+classValue+"'>" +speciality+"</td>");
					out.println("<td nowrap class='"+classValue+"'>" +dis_date+"</td>");
					out.println("</tr>");
				}
				if ( rset_hdr != null ) rset_hdr.close() ;
				if ( stmt1 != null ) stmt1.close() ;
			}
		if ( rset != null ) rset.close() ;
		if ( stmt != null ) stmt.close() ;	
		}
	}catch ( Exception e )
	{   e.printStackTrace();
		//out.println("Expection in vwMedRecEncounterDetails.jsp  : "+e);
	}
	finally
	{
		if ( rset != null ) rset.close() ;
		if(rset_hdr !=  null) rset_hdr.close();
		if ( stmt != null ) stmt.close() ;
		ConnectionManager.returnConnection(con,request);
	}
%>
		</form>
	</body>
</html>
<%
}
else
{
	
	StringBuffer sqlbuff = new StringBuffer();
	String finalSelect	= checkForNull(request.getParameter("finalSelect"));
	String  req_start   =   "", req_end     =   "";
    String  checkedOnes         =   "";

    req_start       =   request.getParameter("from");
    req_end         =   request.getParameter("to");

	if(req_start.equals("") || req_start == null)
	req_start = "0";

	if(req_end.equals("") || req_end == null)
	req_end = "0";

	String from = checkForNull(request.getParameter( "from" )) ;
	String to = checkForNull(request.getParameter( "to" )) ;

    int i=1;
	PreparedStatement pstmt	= null;
	ResultSet rs			= null;
	Connection conn			= null;
try
{
	conn = ConnectionManager.getConnection(request);	
	if(from != null && to != null)
	{
		 int j=0;
		 for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
		 {
			 if(request.getParameter("chk"+(i)) != null)
			 {
				 checkedOnes = request.getParameter("chk"+(i));
				 if(!(MedicalReportReq.containsObject(checkedOnes)))
				 {
					 MedicalReportReq.putObject(checkedOnes);
				 }
				 j++;
			 }
		 }	
		 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
		 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
	}
			i = 1 ;
			if(sqlbuff.length() > 0) sqlbuff.delete(0,sqlbuff.length());	
			//sqlbuff.append("select to_char(a.visit_adm_date_time,'dd/mm/yyyy hh24:mi') encounter_date, a.encounter_id, (CASE WHEN a.specialty_code IS NOT NULL THEN (SELECT short_desc FROM am_speciality WHERE speciality_code = a.specialty_code)END) speciality_desc, (CASE WHEN a.assign_care_locn_type = 'C' THEN (SELECT short_desc FROM op_clinic WHERE facility_id = a.facility_id AND clinic_code = a.assign_care_locn_code) WHEN assign_care_locn_type = 'N' THEN (SELECT short_desc FROM ip_nursing_unit WHERE facility_id = a.facility_id AND nursing_unit_code = a.assign_care_locn_code) END ) locn_desc, (CASE WHEN a.attend_practitioner_id IS NOT NULL THEN (SELECT practitioner_name FROM am_practitioner  WHERE practitioner_id = a.attend_practitioner_id) END) practitioner_name, DECODE (a.assign_care_locn_type,'C', 'Clinic','N', 'Nursing Unit') locn_type, (CASE WHEN a.patient_class IS NOT NULL THEN (SELECT short_desc FROM am_patient_class WHERE patient_class = a.patient_class) END ) patient_class, TO_CHAR (a.discharge_date_time,'dd/mm/yy hh24:mi') discharge_date_time FROM PR_ENCOUNTER a, MP_PATIENT b WHERE a.patient_id = b.patient_id and b.patient_id like '"+PatientId+"' and a.facility_id='"+FacilityId+"' ");
			sqlbuff.append(" select to_char(a.visit_adm_date_time,'dd/mm/yyyy hh24:mi') encounter_date, a.encounter_id, (CASE WHEN a.specialty_code IS NOT NULL THEN (SELECT short_desc FROM am_speciality_lang_vw WHERE speciality_code = a.specialty_code and language_id='"+locale+"')END) speciality_desc, (CASE WHEN a.assign_care_locn_type = 'C' THEN (SELECT short_desc FROM op_clinic_lang_vw WHERE facility_id = a.facility_id AND clinic_code = a.assign_care_locn_code and language_id='"+locale+"') WHEN assign_care_locn_type = 'N' THEN (SELECT short_desc FROM ip_nursing_unit_lang_vw WHERE facility_id = a.facility_id AND nursing_unit_code = a.assign_care_locn_code and language_id='"+locale+"') END ) locn_desc, (CASE WHEN a.attend_practitioner_id IS NOT NULL THEN (SELECT practitioner_name FROM am_practitioner_lang_vw WHERE practitioner_id = a.attend_practitioner_id and language_id='"+locale+"') END) practitioner_name, a.assign_care_locn_type locn_type, (CASE WHEN a.patient_class IS NOT NULL THEN (SELECT short_desc FROM am_patient_class_lang_vw WHERE patient_class = a.patient_class AND language_id='"+locale+"') END ) patient_class, TO_CHAR (a.discharge_date_time,'dd/mm/yyyy hh24:mi') discharge_date_time FROM PR_ENCOUNTER a, MP_PATIENT b WHERE a.patient_id = b.patient_id and b.patient_id like '"+PatientId+"' and a.facility_id='"+FacilityId+"' ");

			if(rs != null)rs.close();
			if(pstmt  != null)pstmt.close();
			pstmt = conn.prepareStatement(sqlbuff.toString());
			rs = pstmt.executeQuery();
	%>
		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
			<TR>
				<th align='center' nowrap><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></th> 
				<th align='center' nowrap><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/></th> 
				<th align='center' nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
				<th align='center' nowrap><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></th>
				<th align='center' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
				<th align='center' nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
				<th align='center' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>
				<th align='center' nowrap><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/></th>
			</TR>
			<%
		if(!finalSelect.equals("")&&!finalSelect.equals("SELECTALL"))
		{  //Above condtion added for this SCF ML-MMOH-SCF-0437
			TreeMap ssm=new TreeMap();
			String selitem="";
			selitem=(request.getParameter("selitem")==null) ? "" : request.getParameter("selitem"); 
			
			//Below if condtion added for this SCF ML-MMOH-SCF- 0437
			if(!selitem.equals("")){
			selitem=selitem.substring(1);
			selitem=selitem.substring(0,selitem.length()-1);
			}
			
			StringTokenizer st=new StringTokenizer(finalSelect,"~");

			int temp=st.countTokens();
			String practId="";
			String enable_dis="";

			for(int u2=0;u2<temp;u2++)
			{
				String st2=st.nextToken();
				StringTokenizer st1=new StringTokenizer(st2,"$");
				practId=st1.nextToken(); 
				st1.nextToken();
				enable_dis=st1.nextToken();
				if(enable_dis.equals("E"))
				ssm.put(practId,practId);
				else
				{
					if(ssm.containsKey(practId))
					ssm.remove(practId);
				}
			}

			if (rs != null)
			{  
				int clsCnt=1;
				while(rs.next())
				{
				   		
						


					if(ssm.containsKey(new String(i+"")))
					{
						if ( clsCnt % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;

						String Patient_Class	= checkForNull(rs.getString("patient_class"),"&nbsp;");	

						String Encounter_Date	= checkForNull(rs.getString("encounter_date"),"&nbsp;");
						if(!(Encounter_Date==null || Encounter_Date.equals("&nbsp;")))
							Encounter_Date	= DateUtils.convertDate(Encounter_Date,"DMYHM","en",locale);


						String Encounter_ID		= checkForNull(rs.getString("encounter_id"),"&nbsp;");
						String con_Speciality	= checkForNull(rs.getString("speciality_desc"),"&nbsp;");
						String con_Location		= checkForNull(rs.getString("locn_desc"),"&nbsp;");		
						String con_Practitioner	= checkForNull(rs.getString("practitioner_name"),"&nbsp;");

						String Dis_dateTime		= checkForNull(rs.getString("discharge_date_time"),"&nbsp;");

						if(!(Dis_dateTime==null || Dis_dateTime.equals("&nbsp;")))
							Dis_dateTime	= DateUtils.convertDate(Dis_dateTime,"DMYHM","en",locale);


						String locn_type		= checkForNull(rs.getString("locn_type"),"&nbsp;");	
						
						
						if(locn_type.equals("C"))
							locn_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
						else if(locn_type.equals("N"))
							locn_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");



						out.println("<tr>");				
						out.println("<td nowrap class='"+classValue+"'>" +Patient_Class+"</td>");
						out.println("<td nowrap class='"+classValue+"'>" +Encounter_Date+"</td>");
						out.println("<td nowrap class='"+classValue+"'>" +Encounter_ID+"</td>");
						out.println("<td nowrap class='"+classValue+"'>" +locn_type+"</td>");
						out.println("<td nowrap class='"+classValue+"'>" +con_Location+"</td>");
						out.println("<td nowrap class='"+classValue+"'>" +con_Practitioner+"</td>");
						out.println("<td nowrap class='"+classValue+"'>" +con_Speciality+"</td>");
						out.println("<td nowrap class='"+classValue+"'>" +Dis_dateTime+"</td>");
						out.println("</tr>");
						clsCnt++;
					}
					i++;
				}
			}
		}
		else if(finalSelect.equals("") || finalSelect.equals("SELECTALL"))
		{  //Above condtion added for this SCF ML-MMOH-SCF-0437
		   
			if (rs != null)
			{   
				int clsCnt=1;
				while(rs.next())
				{
					if ( clsCnt % 2 == 0 )
						classValue = "QRYEVEN" ;
					else
						classValue = "QRYODD" ;


					String Patient_Class	= checkForNull(rs.getString("patient_class"),"&nbsp;");	

					String Encounter_Date	= checkForNull(rs.getString("encounter_date"),"&nbsp;");
					if(!(Encounter_Date==null || Encounter_Date.equals("&nbsp;")))
							Encounter_Date	= DateUtils.convertDate(Encounter_Date,"DMYHM","en",locale);


					String Encounter_ID		= checkForNull(rs.getString("encounter_id"),"&nbsp;");
					String con_Speciality	= checkForNull(rs.getString("speciality_desc"),"&nbsp;");
					String con_Location		= checkForNull(rs.getString("locn_desc"),"&nbsp;");		
					String con_Practitioner	= checkForNull(rs.getString("practitioner_name"),"&nbsp;");

					String Dis_dateTime		= checkForNull(rs.getString("discharge_date_time"),"&nbsp;");


					if(!(Dis_dateTime==null || Dis_dateTime.equals("&nbsp;")))
							Dis_dateTime	= DateUtils.convertDate(Dis_dateTime,"DMYHM","en",locale);

					String locn_type		= checkForNull(rs.getString("locn_type"),"&nbsp;");	
						
						if(locn_type.equals("C"))
							locn_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
						else if(locn_type.equals("N"))
							locn_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");

					out.println("<tr>");				
					out.println("<td nowrap class='"+classValue+"'>" +Patient_Class+"</td>");
					out.println("<td nowrap class='"+classValue+"'>" +Encounter_Date+"</td>");
					out.println("<td nowrap class='"+classValue+"'>" +Encounter_ID+"</td>");
					out.println("<td nowrap class='"+classValue+"'>" +locn_type+"</td>");
					out.println("<td nowrap class='"+classValue+"'>" +con_Location+"</td>");
					out.println("<td nowrap class='"+classValue+"'>" +con_Practitioner+"</td>");
					out.println("<td nowrap class='"+classValue+"'>" +con_Speciality+"</td>");
					out.println("<td nowrap class='"+classValue+"'>" +Dis_dateTime+"</td>");
					out.println("</tr>");

					clsCnt++;
					i++;
				}
			}
			if(pstmt  != null)pstmt.close();
		}
		if(rs != null)rs.close();// E.O SelectAll
		%></TABLE>
		<br><center>

	<%
}catch ( Exception e )
{   e.printStackTrace();
	//out.println("Expection in vwMedRecEncounterDetails.jsp :: : "+e);
}
finally
{
	if ( rs != null ) rs.close() ;
	if ( pstmt != null ) pstmt.close() ;
	ConnectionManager.returnConnection(conn,request);
}

}
%>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
</center>
</form>
</body>
</html>

