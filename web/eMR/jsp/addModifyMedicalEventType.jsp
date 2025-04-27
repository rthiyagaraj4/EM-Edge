<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
      <head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
      	
<script language="javascript" src="../js/MedicalEventType.js"></script>


      </head>

      <body OnMouseDown='CodeArrest()' onload='FocusFirstElement()' onKeyDown = 'lockKey()'>


<%
   request.setCharacterEncoding("UTF-8"); 
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   String MedicalEventType="";
   String longdesc="";
   String shortdesc="";
   String effstatus="";
   String codeTextAttribute="";
   String otherTextAttribute="";
   String checkBoxAttribute="";
   String eventFunctionForCase="";
   //String eventFunctionForDate="";
   boolean NewMedicalEventType = false;
   String sql="";
   Connection conn=null;
   try{
	   conn=ConnectionManager.getConnection(request);
%>
<%
	MedicalEventType=request.getParameter("event_type");
	if(MedicalEventType==null){
		MedicalEventType="";
		longdesc="";
		shortdesc="";
		effstatus="E";
		codeTextAttribute="";
		otherTextAttribute="";
		checkBoxAttribute="CHECKED";
		NewMedicalEventType=true;
		eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
	}else{
	       //Statement stmt=null;
		   PreparedStatement stmt = null;
	    	ResultSet rset=null;
     try{

		//stmt = conn.createStatement();

		sql = "select MED_EVENT_TYPE_CODE,long_desc,short_desc,eff_status from mr_med_event_type where MED_EVENT_TYPE_CODE =?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1,MedicalEventType);
		rset = stmt.executeQuery();
		rset.next();
		MedicalEventType=rset.getString("MED_EVENT_TYPE_CODE");
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
		NewMedicalEventType=false;
		eventFunctionForCase="";
	}

%>

      	<form name='MedicalEventType_form' id='MedicalEventType_form' action='../../servlet/eMR.MedicalEventTypeServlet' method='post' target='messageFrame'>
      	<div align='left'><BR><BR><BR><BR><BR>
      	<BR><BR><BR>
      	<table border='0' cellpadding='5' cellspacing='0' align='center' width='auto'>
      
      		<tr>
      		    <td width='50%' class='label'><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></td>
      		    <td width='50%' class='fields'>
      		    <input type='text' name='event_type' id='event_type' value="<%=MedicalEventType%>" size='2' maxlength='2' onKeyPress="return CheckForSpecChars(event)"  <%=codeTextAttribute%> <%=eventFunctionForCase%>>
      		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
      
      		<tr>
      		    <td  class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      		    <td class='fields'>
      		    <input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' value="<%=longdesc%>" <%=otherTextAttribute%>  onBlur="makeValidString(this);">
      		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
      		
      		<tr>
      		    <td  class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		    <td class='fields'>
		    <input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' value="<%=shortdesc%>" <%=otherTextAttribute%> onBlur="makeValidString(this);" >
		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
      	
      		<tr>
      		     <td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
      		     <td class='fields'>
      		     <input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="change()"></td>
      		</tr>
      	
      	</table>
      	</div>
    <%  if(NewMedicalEventType){%>

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
finally{
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

