<!DOCTYPE html>
<!--Created by Ashwini on 27-Oct-2017 for ML-MMOH-CRF-0790-->
<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.ConnectionManager,java.sql.Connection,java.sql.ResultSet,java.sql.Statement,java.sql.PreparedStatement,org.json.simple.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	Connection con = null;
	Statement stmt = null;
	ResultSet rs   = null;
	String p_report_id	= "MOMOMWS";
	String facilityId 	= (String) session.getValue("facility_id");
	String p_user_name	= (String) session.getValue("login_user");
	String locale		= (String) session.getAttribute("LOCALE");
	//String function_id	= request.getParameter("function_id");
	String p_module_id	= "MO";
	String CurrentYear	= "";
	String CurrentDate	= "";
	
	try
	{
		con		=	ConnectionManager.getConnection(request);
		stmt	=	con.createStatement();

		JSONObject CurrentDateJsonObj = new JSONObject();
		CurrentDateJsonObj  = eMO.MOCommonBean.getCurrentDate(con);

		CurrentYear  = (String) CurrentDateJsonObj.get("CurrentYear");
		CurrentDate  = (String) CurrentDateJsonObj.get("CurrentDate");
		CurrentDate  = DateUtils.convertDate(CurrentDate,"DMY","en",locale);
		CurrentYear  = DateUtils.convertDate(CurrentYear,"YY","en",locale);
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
<html>
<head>
<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
	<Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>	
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
	<script language="javascript" src="../../eCommon/js/common.js" ></script>
	<script language="javascript" src="../js/MonthMortuaryWrkldStat.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>

<body  OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<form name="monthMortuaryWrkldStatForm" id="monthMortuaryWrkldStatForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame"  >
<BR>
<table border="0" cellpadding="0" cellspacing="0" width="60%" align='left'>

<tr>
	<td width="20%"  class="label"></td>

	<td width="15%"  class="label"><fmt:message key="Common.month.label" bundle="${common_labels}"/>/<fmt:message key="Common.year.label" bundle="${common_labels}"/></td>
	
	<td  class="fields" width="30%" ><input type=text  name='frm_date' id='frm_date' size="7" maxlength="7" align="center"  onblur='validDateObj(this,"MY",localeName);validate_date_mon_year(this);'><input align="top" type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('frm_date','mm/y',null)"><img  src='../../eCommon/images/mandatory.gif'></img></td>
</tr>

</table>

<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facilityId%>">
<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%=p_module_id%>">
<input type="hidden" name="p_report_id" id="p_report_id" 	value="<%=p_report_id%>">
<input type="hidden" name="p_user_name" id="p_user_name" 	value="<%=p_user_name%>">
<input type="hidden" name="CurrentYear" id="CurrentYear"		value="<%=CurrentYear%>">
<input type="hidden" name="CurrentDate" id="CurrentDate"		value="<%=CurrentDate%>">
<input type="hidden" name="from_date" id="from_date" 		value="">

</form>
</body>
</html>

