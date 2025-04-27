<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" import ="java.sql.*, webbeans.eCommon.*, com.ehis.eslp.* ,java.net.*,eCommon.XSSRequestWrapper"%>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); %>
<!-- jsp:useBean id="mh" scope="session" class="CommonMultipleHandler" 
To call the Common MultipleHandler where the id will be as mh -->
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
  <head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language=JavaScript src="../../eCommon/js/common.js"></script>	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/Accuracy.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	
  </head> 
<%
Connection conn=null;
PreparedStatement accuracy_stmt=null;
ResultSet accuracy_rset=null;

conn = ConnectionManager.getConnection(request);

String mode			= request.getParameter( "mode" ) ;
String function_id	= request.getParameter("function_id" ) ;
try
{
%>
<body onMouseDown="CodeArrest()"  onload='FocusFirstElement()' onKeyDown="lockKey()" >
<form name="AccuracyAddModify_Form" id="AccuracyAddModify_Form" method="post" action='../../servlet/eMR.AccuracyServlet' target="messageFrame">
<BR><BR><BR><BR><BR>
      	<BR><BR><BR>
<%if(mode.equals("1")){%>
<table cellpadding='5' cellspacing=0 width="auto" align="center">

<tr>

<td class="label" width='50%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
<td class='fields' width='50%'>
<input type="text" name="Accuracy_code" id="Accuracy_code" value="" size="10" maxlength="10" onBlur="ChangeUpperCase( this );" onKeyPress="return CheckForSpecChars(event);" >
<img src="../../eCommon/images/mandatory.gif"></img>
</td>

</tr>

<tr>

<td class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
<td class='fields' >
<input type="text" name="Accuracy_Longdesc" id="Accuracy_Longdesc" value=""  size="30" maxLength="30" onBlur="makeValidString( this );">
<img src="../../eCommon/images/mandatory.gif"></img>
</td>
</tr>

<tr>

<td class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
<td class='fields'>
<input type="text" name="Accuracy_Shortdesc" id="Accuracy_Shortdesc" value=""  size="15" maxLength="15" onBlur="makeValidString( this );">
<img src="../../eCommon/images/mandatory.gif"></img>
</td>
</tr>
<tr>
<td class="label" ><fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></td>
<td class='fields'><input type=radio name="Indicator" id="Indicator" value="C">Certain<input type=radio name="Indicator" id="Indicator" value="U" checked>Uncertain</td>
</tr>
<tr>
<td class="label"  ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
<td class='fields'><input type='checkbox' name='eff_status_yn' id='eff_status_yn' checked>
</td>
</tr>
</table>
<%
}
else if(mode.equals("2"))
{
	String accuracy_code="";
	String short_desc  = "";
	String long_desc = "";
	String indicator="";
	String eff_status = "";

 accuracy_code=request.getParameter("accuracy_code")==null ? "":request.getParameter("accuracy_code");

	String accuracy_sql="select * from mr_accuracy where accuracy_code=?";
    accuracy_stmt=conn.prepareStatement(accuracy_sql);
	accuracy_stmt.setString(1,accuracy_code);

	accuracy_rset=accuracy_stmt.executeQuery();

	if(accuracy_rset!=null)
	{
		while(accuracy_rset.next())
		{
			short_desc  = accuracy_rset.getString("short_desc")==null ? "":accuracy_rset.getString("short_desc");
	        long_desc = accuracy_rset.getString("long_desc")==null ? "":accuracy_rset.getString("long_desc");
	        indicator = accuracy_rset.getString("accuracy_indicator")==null ? "":accuracy_rset.getString("accuracy_indicator");
         	eff_status = accuracy_rset.getString("eff_status")==null ? "D":accuracy_rset.getString("eff_status");
		}
	}

     String status_c="";
	 String status_u="";
	if(indicator.equals("C"))
	{
		 status_c="checked";
	}
	else if(indicator.equals("U"))
	{
		status_u="checked";
	}

	String status="";
	if(eff_status.equals("E"))
	{
		status="checked";
	}
	else 
	{
		status="";
	}

     String enable_status="";
	 String indicator_status="";
	 if(eff_status.equals("E"))
	{
		 enable_status="";
	}
	else
	{
		 enable_status="readonly";
		 indicator_status="disabled";
	}
%>
<table cellpadding='5' cellspacing=0 width="auto" align="center">

<tr>
<td class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
<td class='fields' >
<input type="text" name="Accuracy_code" id="Accuracy_code" value="<%=accuracy_code%>" size="10" maxlength="10" onBlur="ChangeUpperCase( this );" onKeyPress="return CheckForSpecChars(event);" readonly>
<img src="../../eCommon/images/mandatory.gif"></img>
</td>
</tr>
<tr>
<td class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
<td class='fields' >
<input type="text" name="Accuracy_Longdesc" id="Accuracy_Longdesc" value="<%=long_desc%>"  size="30" maxLength="30" onBlur="makeValidString( this );" <%=enable_status%>>
<img src="../../eCommon/images/mandatory.gif"></img>
</td>
</tr>
<tr>
<td class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
<td class='fields'>
<input type="text" name="Accuracy_Shortdesc" id="Accuracy_Shortdesc" value="<%=short_desc%>"  size="15" maxLength="15" onBlur="makeValidString( this );" <%=enable_status%>>
<img src="../../eCommon/images/mandatory.gif"></img>
</td>
</tr>
<tr>
<td class="label" ><fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></td>
<td class="fields"><input type=radio name="Indicator" id="Indicator" 
value="C" <%=status_c%> <%=indicator_status%> onClick="indicatorcheck(this);"><fmt:message key="Common.Certain.label" bundle="${common_labels}"/><input type=radio name="Indicator" id="Indicator" value="U" <%=status_u%> <%=indicator_status%> onClick="indicatorcheck(this);"><fmt:message key="Common.Uncertain.label" bundle="${common_labels}"/></td>
</tr>
<tr>
<td class="label"  ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
<td class='fields'><input type='checkbox' name='eff_status_yn' id='eff_status_yn' value="<%=eff_status%>" <%=status%>>
</td>
</tr>
</table>
<input type="hidden" name="Indicator1" id="Indicator1" value="<%=indicator%>">
<%
}%>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="function_id" id="function_id" value="<%=function_id%>">
</form>
</body>
<%
}
catch(Exception exp)
{
	//out.println(exp.getMessage());
	exp.printStackTrace();
}
finally {
	 try
	 {
	  if (accuracy_rset != null)   accuracy_rset.close();
	  if (accuracy_stmt != null) accuracy_stmt.close();
	  ConnectionManager.returnConnection(conn,request);
	 }
	 catch(Exception exp)
	 {
		 exp.toString();
	 }
	}
%>
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

