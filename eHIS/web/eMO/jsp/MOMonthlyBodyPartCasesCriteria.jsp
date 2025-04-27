<!DOCTYPE html>
<!--Created by Ashwini on 04-Jan-2019 for ML-MMOH-CRF-1094-->
<%@ page import ="java.sql.*,webbeans.eCommon.*,org.json.simple.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	Connection con	= null;
	Statement stmt	= null;
	ResultSet rs	= null ;
	
	String facilityId	= (String) session.getValue("facility_id");
	String p_user_name	= (String) session.getValue("login_user");
	String locale		= (String)session.getAttribute("LOCALE");

	String p_module_id	= "MO";
	String p_report_id	= "MOMBOPAC";
	String CurrentYear	= "";
	
	try
	{
		con	= ConnectionManager.getConnection(request);
		stmt = con.createStatement();

		JSONObject CurrentDateJsonObj = new JSONObject();
		CurrentDateJsonObj  = eMO.MOCommonBean.getCurrentDate(con);

		CurrentYear  = (String) CurrentDateJsonObj.get("CurrentYear");
		CurrentYear  = DateUtils.convertDate(CurrentYear,"YY","en",locale);

%>

<html>

<head>

<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'> </script>
<Script language='JavaScript' src='../../eCommon/js/CommonCalendar.js'></Script>	
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../js/MOMonthlyBodyPartCases.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<body  OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">

<form name="monthlyBodyPartCasesForm" id="monthlyBodyPartCasesForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">

	<table border="0" cellpadding="0" cellspacing="0" width="60%" align='left'>
	
	<br>
	
	<tr>

		<td width="20%"  class="label"></td>
	
		<td width="15%"  class="label"><fmt:message key="Common.year.label" bundle="${common_labels}"/></td>
		
		<td  class="fields" width="30%" ><input type=text  name='from_date' id='from_date' size="4" maxlength="4" align="center"  onblur='validDateObj(this,"YY",localeName);validate_date(this);'><img type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('from_date','y',null)"></img>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
		</td>
	
    </tr>
	
	</table>

    <input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facilityId%>">
	<input type="hidden" name="p_module_id" id="p_module_id"		value="<%=p_module_id%>">
	<input type="hidden" name="p_report_id" id="p_report_id" 	value="<%=p_report_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name" 	value="<%=p_user_name%>">
	<input type='hidden' name='p_language_id' id='p_language_id'	value='<%=locale%>'>
	<input type="hidden" name="CurrentYear" id="CurrentYear"		value="<%=CurrentYear%>">
	<input type="hidden" name="p_from_date" id="p_from_date" 	value="">

</form>

</body>

	<%
	}
	catch(Exception e)
	{
		out.println(e);
	}
	finally 
	{ 
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		ConnectionManager.returnConnection(con,request);
	}
	%>

</html>

