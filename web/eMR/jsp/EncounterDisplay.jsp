<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.ConnectionManager" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %> 
<%
	Connection con = null;
	PreparedStatement stmt=null;
	ResultSet rs =null;
	try
	{
	con  =  ConnectionManager.getConnection(request);

	String patient_id = request.getParameter("patient_id");
	String locale       =(String) session.getAttribute("LOCALE");
	String enc_type = request.getParameter("enc_type");
	if(enc_type==null)enc_type="";
	String sql="";
	String visit_adm="";
	if (enc_type.equals("I")){
			sql = "select encounter_id,to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi'),b.short_Desc,practitioner_name from pr_encounter a,ip_nursing_unit b,am_practitioner c where c.practitioner_id = a.admit_practitioner_id  and a.assign_care_locn_code = b.nursing_unit_code and a.facility_id = b.facility_id and a.patient_class not in ('OP','EM') and patient_id = ?";
			visit_adm= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AdmissionDateTime.label","common_labels");
	}
   else{
   			sql = "select encounter_id,to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi'),b.short_Desc,practitioner_name from pr_encounter a,op_clinic b,am_practitioner c where c.practitioner_id(+) = a.ATTEND_PRACTITIONER_ID  and a.assign_care_locn_code = b.clinic_code and a.facility_id = b.facility_id and a.patient_class  in ('OP','EM') and patient_id = ? ";
	     	visit_adm= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Visit.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.datetime.label","common_labels");
   }

	stmt=con.prepareStatement(sql);
	stmt.setString(1,patient_id);
	rs=stmt.executeQuery();

%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>	
<HEAD>
<TITLE></TITLE>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eMR/js/MedRecRequest.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>

<BODY onMouseDown="CodeArrest();" onKeyDown='lockKey()'>
<br>
<br>
<form name="RepMovementHistForm" id="RepMovementHistForm" >
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<tr>
<th width = '15%'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
<th width = '23%'><%=visit_adm%></th>
<th><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
</tr>
<%	int i = 0;
    String classValue="";

	if (rs!=null)
	{
		while(rs.next())
		{
			i = i +1;
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;		 
			String pract = rs.getString(4);
			String visit_dat_tim_display = rs.getString(2);
			visit_dat_tim_display  = DateUtils.convertDate(visit_dat_tim_display,"DMYHM","en",locale);
			if (pract==null) pract="&nbsp;";
			out.println("<tr><td width = '15%' class='"+classValue+"'><a href=\"javascript:sendtomain('"+rs.getString(1)+"')\">"+rs.getString(1)+"</a></td>");
			out.println("<td width = '23%' class='" + classValue + "'>"+visit_dat_tim_display+"</td>");
			out.println("<td class='" + classValue + "'>"+rs.getString(3)+"</td>");
			out.println("<td class='" + classValue + "'>"+pract+"</td></tr>");
		}
	}%>
</table>
</form>
</BODY>
</HTML>
		<%
	}
	catch(Exception e)
	{
		//out.println("Exception @ try "+e.toString());
		e.printStackTrace();
	}
	finally
	{
		try
		{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}
		catch(Exception e)
		{
			//out.println("Exception @ try "+e.toString());
			e.printStackTrace();
		}
		ConnectionManager.returnConnection(con,request);
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

