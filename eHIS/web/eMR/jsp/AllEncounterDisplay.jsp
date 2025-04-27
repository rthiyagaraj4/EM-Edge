<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import="java.sql.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
 
<%
	Connection con = null;
	Statement stmt=null;
	ResultSet rs =null;
	String locale = (String)session.getAttribute("LOCALE");
	try
	{

	con  =  ConnectionManager.getConnection(request);
	stmt=con.createStatement();
	String patient_id = request.getParameter("patient_id");
	String sql = "SELECT encounter_id, TO_CHAR (visit_adm_date_time, 'dd/mm/rrrr hh24:mi')encounter_date,a.PATIENT_CLASS, b.short_desc, practitioner_name FROM pr_encounter a, ip_nursing_unit b, am_practitioner c WHERE c.practitioner_id = a.admit_practitioner_id   AND a.assign_care_locn_code = b.nursing_unit_code  AND a.facility_id = b.facility_id   AND patient_id = '"+patient_id+"'  AND PATIENT_CLASS IN('IP','DC')  union SELECT encounter_id, TO_CHAR (visit_adm_date_time, 'dd/mm/rrrr hh24:mi')encounter_date,a.PATIENT_CLASS,   d.short_desc,nvl(AM_GET_DESC.AM_PRACTITIONER(a.ATTEND_PRACTITIONER_ID,'"+locale+"','1'),'') PRACTITIONER_NAME   FROM pr_encounter a ,op_clinic d WHERE  a.assign_care_locn_code = d.clinic_code  AND a.facility_id = d.facility_id  AND patient_id = '"+patient_id+"'  AND PATIENT_CLASS IN('OP','EM')  order by encounter_date desc "; 
	rs=stmt.executeQuery(sql);
%>

<html>	
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
request.setCharacterEncoding("UTF-8"); %>
<HEAD>
<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	function sendtomain(encid){
		//alert("encid------------>"+encid);
			//parent.window.returnValue=encid;
			//parent.window.close();   
		let dialogBody = parent.parent.document.getElementById('dialog-body');
	    dialogBody.contentWindow.returnValue = encid;
	    
	    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
	    dialogTag.close();   
			}
</script>
</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<br>
<br>
<form name="RepMovementHistForm" id="RepMovementHistForm" >
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<tr>
<th width = '15%'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
<th width = '28%'><fmt:message key="Common.Visit.label" bundle="${common_labels}"/>/<fmt:message key="Common.AdmissionDateTime.label" bundle="${common_labels}"/></th>
<th ><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.Location.label" bundle="${common_labels}"/>/<fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th> 
</tr>
<%	int i = 0;
    String classValue="";
	if (rs!=null){
		String practname=""; 
		while(rs.next())
		{
		 i = i +1;
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;	
			practname=rs.getString(5)==null?"&nbsp;":rs.getString(5); // added by mujafar for ML-MMOH-CRF-0615	
	      out.println("<tr><td width = '15%' class='"+classValue+"'><a href=\"javascript:sendtomain('"+rs.getString(1)+"')\">"+rs.getString(1)+"</a></td>");
		out.println("<td width = '23%' class='" + classValue + "'>"+DateUtils.convertDate(rs.getString(2),"DMYHM","en",locale)+"</td>");
		out.println("<td class='" + classValue + "'>"+rs.getString(3)+"</td>"); 
		out.println("<td class='" + classValue + "'>"+rs.getString(4)+"</td>");
		out.println("<td class='" + classValue + "'>"+practname+"</td></tr>"); 
}
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
}
if(stmt!=null) stmt.close();
	if(rs!=null) rs.close();
}catch (Exception e){ /* out.println ("Exception :"+e);e.printStackTrace(); */ e.printStackTrace(); }
finally 
{
	ConnectionManager.returnConnection(con,request);
}	
%>
</table>
</form>
</BODY>
</HTML>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

