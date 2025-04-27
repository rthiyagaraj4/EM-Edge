<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>     
<html>
	<head>
	  <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
      	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
      	
      	
      	<script src='../../eIP/js/LodgerstayReason.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


     <script>
   	
  	</script>
</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad='FocusFirstElement()'>
<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String reasonforstaycode	="";
	String longdesc				="";
	String shortdesc			="";
	String effstatus			="";
	String codeTextAttribute	="";
	String otherTextAttribute	="";
	String checkBoxAttribute	="";
	String eventFunctionForCase	="";
	String facilityID			="";
	StringBuffer sql = new StringBuffer();
	boolean newLodger			=false;

	reasonforstaycode=request.getParameter("reason_for_stay_code");
        
    if(reasonforstaycode==null)
    {
	  reasonforstaycode	= "";
	  longdesc			= "";
	  shortdesc			= "";
	  effstatus			= "E";
	  codeTextAttribute	= "";
	  otherTextAttribute= "";
	  checkBoxAttribute	= "CHECKED";
	  newLodger			= true;
	  eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
    }
    else
    {
		Connection conn = null;
		Statement stmt	= null;
		ResultSet rset	= null;
		facilityID=(String)session.getValue("facility_id");

	try{  
    	conn = ConnectionManager.getConnection(request);
     	stmt = conn.createStatement();
		sql.append("select reason_for_stay_code,long_desc,short_desc,eff_status from ip_reason_for_lodger_stay where reason_for_stay_code='"+reasonforstaycode+"'");
		rset = stmt.executeQuery(sql.toString());
		rset.next();
		longdesc	= rset.getString("long_desc");
		shortdesc	= rset.getString("short_desc");		
		effstatus	= rset.getString("eff_status");

		if(effstatus.equals("D"))
		 {
		    otherTextAttribute	="READONLY";
		    checkBoxAttribute	="";
		 }
		else
		 {  otherTextAttribute	="";
		    checkBoxAttribute	="CHECKED";
		 }

		if(rset!=null) 	    rset.close();
		if(stmt!=null)	    stmt.close();

     }catch(Exception e){
		 //out.println(e.toString());
		 e.printStackTrace();
		 }
     finally
     {
		ConnectionManager.returnConnection(conn,request);
     }
		codeTextAttribute	="READONLY";
		newLodger			=false;
		eventFunctionForCase="";
	}
%>

<form name='lodgerstay_form' id='lodgerstay_form' action='../../servlet/eIP.LodgerStayReasonServlet' method='post' target='messageFrame'>
   	<div>
      	<br><br><br><br><br><br><br>
<table border='0' cellpadding='0' cellspacing='0' width='auto' align='center'>
   	<tr>
   		<td class='label' width='10%'>&nbsp;</td>
		<td class='label'>&nbsp;</td>
		<td class='label'>&nbsp;</td>
		<td class='label' width='10%'>&nbsp;</td>
	</tr>
      		<tr>
      		    <td class='label'>&nbsp;</td>
      		    <td  class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      		    <td class='fields'><input type='text' name='reason_for_stay_code' id='reason_for_stay_code' value="<%=reasonforstaycode%>" size='2' maxlength='2' <%=codeTextAttribute%> <%=eventFunctionForCase%> onKeyPress="return CheckForSpecChars(event)"><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
      		    <td class='label'>&nbsp;</td>
      		</tr>
      		<tr>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
		</tr>
      		<tr>
      		    <td class='label'>&nbsp;</td>
      		    <td    class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;</td>
      		    <td class='fields'><input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' value="<%=longdesc%>" <%=otherTextAttribute%> onBlur="makeValidString(this)"><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
      		    <td class='label'>&nbsp;</td>
      		</tr>
      		<tr>
      		<td class='label'>&nbsp;</td>
      		<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
		</tr>
      		<tr>
      		    <td class='label'>&nbsp;</td>
      		    <td  class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;</td>
		    <td class='fields'><input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' value="<%=shortdesc%>" <%=otherTextAttribute%> onBlur="makeValidString(this)"><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
		    <td class='label'>&nbsp;</td>
      		</tr>
      		<tr>
      			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
		</tr>
      		<tr>
      		     <td class='label'>&nbsp;</td>
      		     <td  class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
      		     <td align='left' class='fields'><input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="change()"></td>
      		     <td class='label'>&nbsp;</td>
      		</tr>
      		<tr>
      		<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
		</tr>

      	</table>
      	</div>
    <%  if(newLodger){%>

      	<input type='hidden' name='function' id='function' value='insert'>
      	<input type='hidden' name='function_name' id='function_name' value='insert'>

      <%}else{%>

      	<input type='hidden' name='function' id='function' value='modify'>
      	<input type='hidden' name='function_name' id='function_name' value='modify'>
      	<input type='hidden' name='facility_id' id='facility_id' value="<%=facilityID%>" >
     <%}%>

      	</form>
   	</body>
</html>
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

