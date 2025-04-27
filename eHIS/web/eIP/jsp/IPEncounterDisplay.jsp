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
	String sql = "select encounter_id,to_char(visit_adm_date_time,'dd/mm/rrrr hh24:mi'),b.short_Desc,practitioner_name from pr_encounter a,ip_nursing_unit b,am_practitioner c where c.practitioner_id = a.admit_practitioner_id  and a.assign_care_locn_code = b.nursing_unit_code and a.facility_id = b.facility_id and a.patient_class not in ('OP','EM') and patient_id = '"+patient_id+"'";
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
			window.returnValue=encid;
			window.close();       
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
<th width = '23%'><fmt:message key="Common.AdmissionDateTime.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
</tr>
<%	
	int i = 0;
    String classValue="";
	if (rs!=null){
		while(rs.next())
		{
		 i = i +1;
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;		 
	      out.println("<tr><td width = '15%' class='"+classValue+"'><a href=\"javascript:sendtomain('"+rs.getString(1)+"')\">"+rs.getString(1)+"</a></td>");
		out.println("<td width = '23%' class='" + classValue + "'>"+DateUtils.convertDate(rs.getString(2),"DMYHM","en",locale)+"</td>");
		out.println("<td class='" + classValue + "'>"+rs.getString(3)+"</td>");
		out.println("<td class='" + classValue + "'>"+rs.getString(4)+"</td></tr>");
}
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
}
if(stmt!=null) stmt.close();
	if(rs!=null) rs.close();
}catch (Exception e){ out.println ("Exception :"+e);e.printStackTrace(); }
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

