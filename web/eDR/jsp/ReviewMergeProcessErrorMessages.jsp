<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eDR.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>

<title><fmt:message key="Common.Error.label" bundle="${common_labels}"/>&nbsp<fmt:message key="Common.details.label" bundle="${common_labels}"/></title>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eDR/js/MergeDuplicates.js'></script>
	<Script language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function  callclose()
	{
		window.close();
	}
	</script>
	
	</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form>
<table border='1' width='100%' cellspacing='0' cellpadding='0'>
<tr>
	<th align=left width='35%'><fmt:message key="Common.MessageDate/Time.label" bundle="${common_labels}"/></th>
	<th align=left width='65%'><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></th>
</tr>
<tr>
	<th colspan=4 align=left><fmt:message key="Common.ErrorMessage.label" bundle="${common_labels}"/></th>
</tr>
<%
	String locale = (String)session.getAttribute("LOCALE");

	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;
	String patient_id=request.getParameter("patient_id");
	String app_msg="";
	String err_msg="";
	String app_key="";
	String facility_name="";
	String msg_time="";
	try
	 {
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		if(patient_id == null) patient_id = ""; 

		String str  = "select sm_get_desc.SM_FACILITY_PARAM(OPERATING_FACILITY_ID,'"+locale+"',1 )FACILITY_NAME,to_char(msg_date_time,'dd/mm/yyyy hh24:mi:ss') msg_date,APP_MSG,ERR_MSG,APP_KEY from sm_proc_msg where proc_id='DRBMERGE' AND APP_KEY LIKE '%"+patient_id+"%' order by MSG_DATE_TIME desc ";
		
		rs	= stmt.executeQuery(str);
		if(rs.next())
		{
          app_msg=checkForNull(rs.getString("APP_MSG"));
          err_msg=checkForNull(rs.getString("ERR_MSG"));
          app_key=checkForNull(rs.getString("APP_KEY"));
          facility_name=checkForNull(rs.getString("FACILITY_NAME"));
          msg_time=checkForNull(rs.getString("msg_date"));
		}
		%>
     <tr>
		<td align=left><%=msg_time%></td>
		<td align=left><%=facility_name%></td>
	</tr>
	<tr>
	   <td colspan=2><%=app_key%><br><%if(err_msg.equals("")){%><%=app_msg%><br><%}%><%=err_msg%><br><br></td>
	</tr>
	</table>
	<table border='0' width='100%' cellspacing='0' cellpadding='0'>
			<tr>
	   <td colspan=2>&nbsp; </td></tr>
      <tr>
	   <td colspan=2 align=center><input type='button' class="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick="callclose()"></td>
    </table>
	</form>
	<%
	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception e :"+ e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</body>
</html>
<%!
public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
}
%>

