<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8");
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff"); %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
      <head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
      	
		<script language="javascript" src="../js/RhesusFactor.js"></script>


      </head>

      <body OnMouseDown='CodeArrest()' onload='FocusFirstElement()' onKeyDown = 'lockKey()'>


<%
   String RhesusFactor="";
   String longdesc="";
   String shortdesc="";
   String effstatus="";
   String codeTextAttribute="";
   String otherTextAttribute="";
   String checkBoxAttribute="";
   String eventFunctionForCase="";
   //String eventFunctionForDate="";
   boolean newRhesusFactor = false;
   String sql="";
   Connection conn=null;
%>
<%
try{
	conn=ConnectionManager.getConnection(request);
	RhesusFactor=request.getParameter("rhesus_factor_code");
	
	if(RhesusFactor==null){
		RhesusFactor="";
		longdesc="";
		shortdesc="";
		effstatus="E";
		codeTextAttribute="";
		otherTextAttribute="";
		checkBoxAttribute="CHECKED";
		newRhesusFactor=true;
		eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
	}else{
	       //Statement stmt=null;
		   PreparedStatement stmt = null;
	    	ResultSet rset=null;
     try{

		if(RhesusFactor.equals(""))
		RhesusFactor="+";

		//stmt = conn.createStatement();

		sql = "select rhesus_factor_code,long_desc,short_desc,eff_status from mr_rhesus_factor where rhesus_factor_code =?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1,RhesusFactor);
		rset = stmt.executeQuery();
		rset.next();
		RhesusFactor=rset.getString("rhesus_factor_code");
		longdesc=rset.getString("long_desc");
		shortdesc=rset.getString("short_desc");


		effstatus=rset.getString("eff_status");
		if(effstatus.equals("D")){
			otherTextAttribute="READONLY";
			checkBoxAttribute="";
		}else{

			otherTextAttribute="";
			checkBoxAttribute="CHECKED";
		}

	     }catch(Exception e){
			e.toString();
	     }
	     finally{
	     	if(stmt!=null)
	     	stmt.close();
	     	if(rset!=null)
	     	rset.close();
	     }
		codeTextAttribute="READONLY";
		newRhesusFactor=false;
		eventFunctionForCase="";
	}

%>

      	<form name='RhesusFactor_form' id='RhesusFactor_form' action='../../servlet/eMR.RhesusFactorServlet' method='post' target='messageFrame'>
      	<div align='left'>
		<BR><BR><BR><BR><BR><BR><BR><BR><BR>
      	<table border='0' cellpadding='5' cellspacing='0' width='auto' align='center'>
      	
      		<tr>
      		    <td width='50%' class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      		    <td width='50%' class='fields'>
      		    <input type='text' name='rhesus_factor_code' id='rhesus_factor_code' value="<%=RhesusFactor%>" onKeyPress="return CheckForSpecChars(event)"  size='4' maxlength='4' <%=codeTextAttribute%> <%=eventFunctionForCase%>>
      		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
      			
      		<tr>
      		    <td  class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      		    <td class='fields'>
      		    <input type='text' name='long_desc' id='long_desc' size='40' maxlength='40' value="<%=longdesc%>" <%=otherTextAttribute%>  onBlur="makeValidString(this);">
      		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
      			
      		<tr>
      		    <td  class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		    <td class='fields'>
		    <input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' value="<%=shortdesc%>" <%=otherTextAttribute%>  onBlur="makeValidString(this);">
		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
				
      		<tr>
      		     <td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
      		     <td class='fields'>
      		     <input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="change()"></td>
      		</tr>
			
      	</table>
      	</div>
    <%  if(newRhesusFactor){%>

      	<input type='hidden' name='function' id='function' value='insert'>
      	<input type='hidden' name='function_name' id='function_name' value='insert'>

      <%}else{%>

      	<input type='hidden' name='function' id='function' value='modify'>
      	<input type='hidden' name='function_name' id='function_name' value='modify'>
     <%}%>
      	</form>
      	</body>
      	</html>
<%
}catch(Exception e){/* out.println(e.toString()); */ e.printStackTrace(); }
finally
{
	ConnectionManager.returnConnection(conn,request);
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

