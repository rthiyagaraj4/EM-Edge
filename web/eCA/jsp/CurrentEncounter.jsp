<!DOCTYPE html>
<!------------------------------------------------------------------------------------------------------------
Date			Edit History		Name        Description
--------------------------------------------------------------------------------------------------------------
12/09/2012		IN034999			vijayakumark	-Encounter details and Confirm hyperlink not displayed for Enterprise Referral Type
-------------------------------------------------------------------------------------------------------------->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,com.ehis.util.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
	<title><fmt:message key="Common.encounterdetails.label" bundle="${common_labels}"/></title>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    
	<script>
	
	var facility_name;
	var admission_date_time;
	var practitioner_name; 
	var specialty_short_desc;
	var encounter_id;
	var admission_type_short_desc; 
	var patient_type_short_desc;
	
	function displayCurEncDetail(admission_date_time,practitioner_name,specialty_short_desc,encounter_id,admission_type_short_desc,patient_type_short_desc,patientId)
	{
		var temp="admission_date_time="+admission_date_time+"&practitioner_name="+practitioner_name+"&specialty_short_desc="+specialty_short_desc+"&encounter_id="+encounter_id+"&admission_type_short_desc="+admission_type_short_desc+"&patient_type_short_desc="+patient_type_short_desc;
		parent.frames[2].location.href="../jsp/LastAdmissionResult.jsp?encounter_id='"+encounter_id+"'&patientId='"+patientId+"'";
	
	}
	
	
	</script>
	
	</head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	 
	/*IN034999 starts*/
	//String facility_Id		= (String)session.getValue("facility_id");
	String facility_Id		= checkForNull(request.getParameter("facilityid"));
	/*IN034999 ends*/
	String encounterId		= checkForNull(request.getParameter("encounterId"));
	StringBuffer sqlQuery	= new StringBuffer();

	String referral_id		="";
	String referral_details	="";
	
	// Changed By Vinod 6/19/2006 4:53 PM
	/*sqlQuery.append("SELECT" );
	sqlQuery.append("  facility_id " );
	sqlQuery.append("  , encounter_id" );
	sqlQuery.append("  , TO_CHAR(admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time" );
	sqlQuery.append("  , AM_GET_DESC.AM_PRACTITIONER(ATTEND_PRACTITIONER_ID,'"+locale+"','1') practitioner_name " );
	sqlQuery.append("  ,AM_GET_DESC.AM_SPECIALITY(specialty_code,'"+locale+"','2') specialty_short_desc " );
	sqlQuery.append("  ,IP_GET_DESC.IP_ADMISSION_TYPE(ADMISSION_TYPE,'"+locale+"','2') admission_short_desc " );
	sqlQuery.append("  , TRUNC(SYSDATE-admission_date_time+1) no_of_days " );
	sqlQuery.append("FROM" );
	sqlQuery.append("  IP_OPEN_ENCOUNTER " );
	sqlQuery.append("WHERE encounter_id = '"+encounterId+"' " );
	sqlQuery.append("  AND facility_id='"+facility_Id+"' " );*/


	sqlQuery.append("SELECT" );
	sqlQuery.append("  facility_id " );
	sqlQuery.append("  , encounter_id" );
	//sqlQuery.append("  , sm_get_desc.sm_facility_param(facility_id,'"+locale+"','1') facility_name " );//common-icn-0180
	sqlQuery.append("  , sm_get_desc.sm_facility_param(facility_id,?,'1') facility_name " );//common-icn-0180
	
	sqlQuery.append("  , TO_CHAR(VISIT_ADM_DATE_TIME,'dd/mm/rrrr hh24:mi') admission_date_time" );
	sqlQuery.append("  , TO_CHAR(DISCHARGE_DATE_TIME,'dd/mm/rrrr hh24:mi') discharge_date_time" );
	//sqlQuery.append("  , (CASE WHEN ATTEND_PRACTITIONER_ID IS NULL THEN   (AM_GET_DESC.AM_PRACTITIONER(ADMIT_PRACTITIONER_ID,'"+locale+"','1')) ELSE (AM_GET_DESC.AM_PRACTITIONER(ATTEND_PRACTITIONER_ID,'"+locale+"','1')) END) practitioner_name " );//common-icn-0180
	sqlQuery.append("  , (CASE WHEN ATTEND_PRACTITIONER_ID IS NULL THEN   (AM_GET_DESC.AM_PRACTITIONER(ADMIT_PRACTITIONER_ID,?,'1')) ELSE (AM_GET_DESC.AM_PRACTITIONER(ATTEND_PRACTITIONER_ID,?,'1')) END) practitioner_name " );//common-icn-0180
	
	//sqlQuery.append("  ,AM_GET_DESC.AM_SPECIALITY(specialty_code,'"+locale+"','2') specialty_short_desc " );//common-icn-0180
	sqlQuery.append("  ,AM_GET_DESC.AM_SPECIALITY(specialty_code,?,'2') specialty_short_desc " );//common-icn-0180
	
	//sqlQuery.append("  ,IP_GET_DESC.IP_ADMISSION_TYPE(VISIT_ADM_TYPE,'"+locale+"','2') admission_short_desc " );//common-icn-0180
	sqlQuery.append("  ,IP_GET_DESC.IP_ADMISSION_TYPE(VISIT_ADM_TYPE,?,'2') admission_short_desc " );//common-icn-0180
	
	sqlQuery.append("  , (CASE WHEN DISCHARGE_DATE_TIME IS NULL THEN (TRUNC(SYSDATE-VISIT_ADM_DATE_TIME+1)) END) no_of_days " );
	sqlQuery.append("  ,referral_id " );
	sqlQuery.append("FROM" );
	sqlQuery.append("  PR_ENCOUNTER " );
	//sqlQuery.append("WHERE encounter_id = '"+encounterId+"' " );//common-icn-0180
	sqlQuery.append("WHERE encounter_id = ? " );//common-icn-0180
	
	//sqlQuery.append("  AND facility_id='"+facility_Id+"' " );//common-icn-0180
	sqlQuery.append("  AND facility_id=? " );//common-icn-0180
	//sqlQuery.append("  AND patient_class in ('IP', 'DC') " );


 	Connection con	= null;
 	Statement stmt	= null;
 	ResultSet rset	=null; 	
 	PreparedStatement pstmt = null;//common-icn-0180
	Statement  stmt1= null;
	ResultSet  rset1= null;

	try{
		con		= ConnectionManager.getConnection(request);
		//stmt	= con.createStatement();//common-icn-0180
		pstmt = con.prepareStatement(sqlQuery.toString());//common-icn-0180
		//common-icn-0180 starts
		pstmt.setString(1, locale);
		pstmt.setString(2, locale);
		pstmt.setString(3, locale);
		pstmt.setString(4, locale);
		pstmt.setString(5, locale);
		pstmt.setString(6, encounterId);
		pstmt.setString(7, facility_Id);
		//common-icn-0180 ends
	 	//rset	= stmt.executeQuery(sqlQuery.toString());//common-icn-0180	
	 	rset	= pstmt.executeQuery();//common-icn-0180
 
		while(rset.next())
 		{
			String admission_date_time_converted = "";
 			String admission_date_time		= checkForNull(rset.getString("admission_date_time"),"&nbsp;");
			if(!(admission_date_time.equals("") || admission_date_time.equals("&nbsp;") || admission_date_time == null))
					admission_date_time_converted = DateUtils.convertDate(admission_date_time,"DMYHM","en",locale); 
	
			String no_of_days				= checkForNull(rset.getString("no_of_days"),"&nbsp;");
			String encounter_id				= checkForNull(rset.getString("encounter_id"));
			String admission_type_short_desc= checkForNull(rset.getString("admission_short_desc"));
			String specialty_short_desc		= checkForNull(rset.getString("specialty_short_desc"),"&nbsp;");
			String practitioner_name		= checkForNull(rset.getString("practitioner_name"),"&nbsp;");


			String discharge_date_time_converted = "";
			String facility_name		= checkForNull(rset.getString("facility_name"),"&nbsp;");
			String discharge_date_time	= checkForNull(rset.getString("discharge_date_time"),"&nbsp;");
			referral_id					= checkForNull(rset.getString("referral_id"));

			if(!(discharge_date_time.equals("") || discharge_date_time.equals("&nbsp;") || discharge_date_time == null))
					discharge_date_time_converted = DateUtils.convertDate(discharge_date_time,"DMYHM","en",locale); 

		
	 %>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<FORM NAME = "currentencounter_form">
<table border='0' cellpadding='3' cellspacing='0' width='100%' >
	<tr><td class='COLUMNHEADER' colspan='4' ><fmt:message key="Common.encounterdetails.label" bundle="${common_labels}"/></td></tr>
	<tr>
		<!--<td  class='label' width='25%'><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td>-->
		<td class='label'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
		<td  class='QUERYDATA'  width='25%'><%=facility_name%></td> 
		<td  class='label' width='25%' ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td  class='QUERYDATA'  width='25%'><%=encounter_id%></td> 
	</tr>
	<tr>
		<td  class='label' width='25%'><fmt:message key="Common.AdmissionDateTime.label" bundle="${common_labels}"/></td>
		<td  class='QUERYDATA'  width='25%'><%=admission_date_time_converted%></td> 
		<td class='label'><fmt:message key="Common.dischargedatetime.label" bundle="${common_labels}"/></td>
		<td  class='QUERYDATA'  width='25%'><%=discharge_date_time_converted%></td> 
	</tr>
	<tr>
		<td  class='label' width='10%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
		<td  class='QUERYDATA'  ><%=specialty_short_desc%></td> 
		<td  class='label' width='10%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
		<td  class='QUERYDATA'  ><%=practitioner_name%></td> 	
	</tr>
 	<tr>
		<td  class='label' width='10%'><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/></td>
		<td  class='QUERYDATA'  ><%=admission_type_short_desc%></td> 	
		<td  class='label'  width='10%'><fmt:message key="Common.noofdays.label" bundle="${common_labels}"/></td>
		<td  class='QUERYDATA'  ><%=no_of_days%></td>
	</tr>

	<% if (!referral_id.equals("")) 
			{
				stmt1		= con.createStatement();
				String sql	= "select get_referral_detail_line('"+referral_id+"','FROM','"+locale+"')ref_detail from dual";
				rset1		= stmt1.executeQuery(sql);	
				if (rset1.next())
				{
					referral_details = checkForNull(rset1.getString("ref_detail"));
								
				}
			if(rset1!=null)	rset1.close();
			if(stmt1!=null)	stmt1.close();
		%>
		<tr>
			<td  colspan='4' class='CAGROUPHEADING'><fmt:message key="Common.referraldetails.label" bundle="${common_labels}"/></td>
		</tr>
		<tr>
			<td class='label' colspan='4'><%=referral_details%></td>
		 </tr>
		<%}%>
</table> 
<%
  if(sqlQuery.length() > 0) sqlQuery.delete(0,sqlQuery.length());
  }
	}catch(Exception e) {
	//out.println(e.toString());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		try
		{
			if (rset != null) rset.close();
			if (stmt != null) stmt.close();
			if (pstmt != null) pstmt.close();//common-icn-0180
			if(rset1!=null)	rset1.close();
			if(stmt1!=null) stmt1.close();
			ConnectionManager.returnConnection(con,request);
		}catch(Exception ee) {
			//out.println("Error while closing the connections :"+ee.toString());//COMMON-ICN-0181
			ee.printStackTrace();//COMMON-ICN-0181
		}
	}

%>  
	</table>
</FORM>
</body>
</html>
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

