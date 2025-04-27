<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
      <head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
		
		<script language="javascript" src="../js/HighRisk.js"></script>


      </head>

      <body OnMouseDown='CodeArrest()' onload='FocusFirstElement()' onKeyDown = 'lockKey()'>


<%
   request.setCharacterEncoding("UTF-8");
   String High_Risk="";
   String longdesc="";
   String shortdesc="";
   String effstatus="";
   String codeTextAttribute="";
   String otherTextAttribute="";
   String checkBoxAttribute="";
   String eventFunctionForCase="";
   //String eventFunctionForDate="";
   boolean newHighRisk = false;
   String sql="";
   Connection conn=null;
%>
<%
try
{
	conn=ConnectionManager.getConnection(request);
	High_Risk=request.getParameter("high_risk_code");
	if(High_Risk==null){
		High_Risk="";
		longdesc="";
		shortdesc="";
		effstatus="E";
		codeTextAttribute="";
		otherTextAttribute="";
		checkBoxAttribute="CHECKED";
		newHighRisk=true;
		//eventFunctionForDate="OnBlur='CheckDate(this)'";
		eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
	}else{
	//	   Connection conn = (Connection) session.getValue( "connection" );
	       Statement stmt=null;
	    	ResultSet rset=null;
     try{

		stmt = conn.createStatement();

		sql = "select high_risk_code,long_desc,short_desc,eff_status from mr_high_risk where high_risk_code='"+High_Risk+"'";
		rset = stmt.executeQuery(sql);
		rset.next();
		High_Risk=rset.getString("high_risk_code");
		longdesc=rset.getString("long_desc");
		shortdesc=rset.getString("short_desc");
		//eventFunctionForDate="OnBlur='CheckDate(this)'";


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
			 try
			 {
	     	if(stmt!=null)
	     	stmt.close();
	     	if(rset!=null)
	     	rset.close();
			 }
			 catch(Exception e){
	     }

	     }
		codeTextAttribute="READONLY";
		newHighRisk=false;
		eventFunctionForCase="";
	}

%>

      	<form name='HighRisk_form' id='HighRisk_form' action='../../servlet/eMR.HighRiskServlet' method='post' target='messageFrame'>
      	<div align='left'><BR><BR><BR><BR><BR>
      	<BR><BR><BR>
      	<table border='0' cellpadding='5' cellspacing='0' width='auto' align='center'>
      	
      		<tr>
      		    <td width='50%' class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      		    <td width='50%' class='fields'>
      		    <input type='text' name='high_risk_code' id='high_risk_code' value="<%=High_Risk%>" size='7' maxlength='6' onKeyPress="return CheckForSpecChars(event)"  <%=codeTextAttribute%> <%=eventFunctionForCase%>>
      		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
      		
      		<tr>
      		    <td  class=label><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      		    <td class='fields'>
      		    <input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' value="<%=longdesc%>" <%=otherTextAttribute%>  onBlur="makeValidString(this);">
      		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
      		
      		<tr>
     		    <td  class=label><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		    <td class='fields'>
		    <input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' value="<%=shortdesc%>" <%=otherTextAttribute%>  onBlur="makeValidString(this);">
		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
			
      		<tr>
      		     <td  class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
      		     <td class='fields'>
      		     <input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="change()"></td>
      		</tr>
			
      	</table>
      	</div>
    <%  if(newHighRisk){%>

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
}catch(Exception e){}
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

