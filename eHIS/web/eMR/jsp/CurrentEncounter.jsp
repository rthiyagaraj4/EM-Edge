<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<!--<link rel='stylesheet' type='text/css' href='../html/text.css'></link>-->
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		
	</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String patientId=request.getParameter("patientId");
//String Patient_Class=request.getParameter("Patient_Class");

String facility_Id = (String)session.getValue("facility_id");
String locale      = (String)session.getAttribute("LOCALE"); 

String encounterId = request.getParameter("encounterId") == null ?"" : request.getParameter("encounterId");
if(patientId == null) patientId="";
StringBuffer StrBuff=new StringBuffer();
  /*StrBuff.append(" Select facility_id , encounter_id,");
	StrBuff.append("to_char(admission_date_time,'dd/mm/yyyy hh24:mi') admission_date_time, ");
	StrBuff.append("practitioner_name , specialty_short_desc , admission_short_desc , ");
	StrBuff.append(" patient_type_short_desc ,patient_type_short_desc,");
	StrBuff.append(" TRUNC(SYSDATE-admission_date_time+1) no_of_days  ");
	StrBuff.append("from ip_open_encounter_vw where encounter_id = '"+encounterId+"' and "); 
	StrBuff.append("facility_id='"+facility_Id+"' ");*/


	/*StrBuff.append(" Select facility_id , encounter_id,");
	StrBuff.append("to_char(admission_date_time,'dd/mm/yyyy hh24:mi') admission_date_time, ");
	StrBuff.append("am_get_desc.AM_PRACTITIONER(admit_practitioner_id,'"+locale+"','1') practitioner_name , AM_GET_DESC.AM_SPECIALITY(specialty_code,'"+locale+"','2') specialty_short_desc , ip_get_desc.IP_ADMISSION_TYPE(admission_type,'"+locale+"','2') admission_short_desc , ");
	StrBuff.append("null patient_type_short_desc,");
	StrBuff.append(" TRUNC(SYSDATE-admission_date_time+1) no_of_days  ");
	StrBuff.append("from ip_open_encounter_vw where encounter_id = '"+encounterId+"' and "); 
	StrBuff.append("facility_id='"+facility_Id+"' ");*/


	StrBuff.append(" Select facility_id , encounter_id,");
	StrBuff.append("to_char(admission_date_time,'dd/mm/yyyy hh24:mi') admission_date_time, ");
	StrBuff.append("am_get_desc.AM_PRACTITIONER(admit_practitioner_id,'"+locale+"','1') practitioner_name , AM_GET_DESC.AM_SPECIALITY(specialty_code,'"+locale+"','2') specialty_short_desc , ip_get_desc.IP_ADMISSION_TYPE(admission_type,'"+locale+"','2') admission_short_desc , ");
	StrBuff.append("null patient_type_short_desc,");
	StrBuff.append(" TRUNC(SYSDATE-admission_date_time+1) no_of_days  ");
	StrBuff.append("from IP_OPEN_ENCOUNTER where encounter_id = '"+encounterId+"' and "); 
	StrBuff.append("facility_id='"+facility_Id+"' ");


//	}

 	Connection con	= null;
 	Statement stmt	= null;
 	ResultSet rset	=null; 	
	try{
		con = ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

	 	rset = stmt.executeQuery(StrBuff.toString());	
 
		while(rset.next())
 		{
 	
		String admission_date_time=rset.getString("admission_date_time");
		if(admission_date_time == null || admission_date_time.equals("null")) admission_date_time="&nbsp;"; 	
		String no_of_days = "";
	
		no_of_days=rset.getString("no_of_days");
		if(no_of_days == null || no_of_days.equals("null")) no_of_days="&nbsp;"; 	
		//if(no_of_days == 1) days="&nbsp;"; 	
	
		
		String encounter_id= rset.getString("encounter_id");
		if( encounter_id == null) encounter_id="";
	 
		String admission_type_short_desc=rset.getString("admission_short_desc");
		if( admission_type_short_desc == null) admission_type_short_desc=""; 	
		
		String facility_id=rset.getString("facility_id");
		if( facility_id == null || facility_id.equals("null")) facility_id="&nbsp;"; 	
		
		String specialty_short_desc=rset.getString("specialty_short_desc");
		if( specialty_short_desc == null || specialty_short_desc.equals("null")) specialty_short_desc="&nbsp;"; 	
		
		String practitioner_name=rset.getString("practitioner_name");
		if( practitioner_name == null || practitioner_name.equals("null")) practitioner_name="&nbsp;"; 	
		
		String patient_type_short_desc= rset.getString("patient_type_short_desc");
		if( patient_type_short_desc == null) patient_type_short_desc="";  
		
	//	String ref_source_type_desc=rset.getString("ref_source_type_desc");
	//	if( ref_source_type_desc == null) ref_source_type_desc="";
		
	//	String ref_source_desc=rset.getString("ref_source_desc");
	//	if( ref_source_desc == null) ref_source_desc="";
		
	//	String ref_practitioner_name=rset.getString("ref_practitioner_name");
	//	if( ref_practitioner_name == null) ref_practitioner_name="";
		
		
	 %>
 <BODY onKeyDown='lockKey()'>
 <FORM NAME = "currentencounter_form">
 <table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
  
  <tr> 	  <th colspan='7' align='left'><fmt:message key="Common.encounterdetails.label" bundle="${common_labels}"/></th> </tr>
  <tr>
   	  <td width='1%'>&nbsp;</td>
 	  <td align=right class='label' width='10%'><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td>
 	  <td align ='left' class='QUERYDATA' nowrap align='center'>&nbsp;<%=admission_date_time%> 	  	
 	  </td> 
 	  
 	  <td align=right class='label' width='10%' nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
 	  <td align ='left' class='QUERYDATA' nowrap align='center'>&nbsp;<%=encounter_id%> 	  
 	  </td> 
 	  
 	  <td align=right class='label' width='10%'><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/></td>
 	  <td align ='left' class='QUERYDATA' nowrap align='center'>&nbsp;<%=admission_type_short_desc%> 	  	
 	  </td> 	
  </tr>
  <tr>
   	  <td width='1%'>&nbsp;</td>
 	  <td align=right class='label' width='10%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
 	  <td align ='left' class='QUERYDATA' nowrap align='center'>&nbsp;<%=specialty_short_desc%> 	  	
 	  </td> 
 	  <td align=right class='label' width='10%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
 	  <td align ='left' class='QUERYDATA' nowrap align='center'>&nbsp;<%=practitioner_name%></td> 	
 	  
 	  <td align=right class='label' width='10%'><fmt:message key="Common.patienttype.label" bundle="${common_labels}"/></td>
 	  <td align ='left' class='QUERYDATA' nowrap align='center'>&nbsp;<%=patient_type_short_desc%></td> 	
  </tr>	 
	  <tr>
	  <td width='1%'>&nbsp;</td>	
   	  <td align=right class='label' width='10%' nowrap><fmt:message key="Common.noofdays.label" bundle="${common_labels}"/></td>
 	  <td align ='left' class='QUERYDATA' nowrap align='center'>&nbsp;<%=no_of_days%> days</td> 	
	  <td colspan=4></td>
	  </tr>	  
   </table> 
  	<script>
 		//displayCurEncDetail('<%=admission_date_time%>','<%=practitioner_name%>','<%=specialty_short_desc%>','<%=encounter_id%>','<%=admission_type_short_desc%>','<%=patient_type_short_desc%>','<%=patientId%>');
 	</script>
<%
  }
	}catch(Exception e) {
		//out.println("Exception @ try "+e.toString());
		e.printStackTrace();
		}
	finally
	{
		try
		{
		if (rset != null) rset.close();
		if (stmt != null) stmt.close();
		}
		catch(Exception e)
		{
			//out.println("Exception at CurrentEncounter.jsp "+e.toString());
			e.printStackTrace();
		}
		ConnectionManager.returnConnection(con,request);
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

