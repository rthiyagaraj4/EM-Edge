<!DOCTYPE html>
<!--Maheshwaran K created this page for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013-->
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
      	<script language="javascript" src="../js/NotifiableSetup.js"></script>
		</head>
      <body OnMouseDown='CodeArrest()' onload='FocusFirstElement()' onKeyDown = 'lockKey()'>
	  <%
	  	String longdesc="";
        String shortdesc="";
        String effstatus="";
		String default_note_type="";
		String email_applicable="N";
		String notify_code="";
        Connection conn=null;
		Statement stmt=null;
		PreparedStatement stmt1 = null;
	    ResultSet rset=null;
		notify_code=checkForNull(request.getParameter("notify_code"));
		String eventFunctionForCase="";
		String codeTextAttribute="";
		String otherTextAttribute="";
		String otherSelectAttribute="";
		String checkBoxAttribute="";
		String emailcheckBoxAttribute="";
		String locale			= (String)session.getAttribute("LOCALE");
		%>
		<% 
		try{ 
		conn=ConnectionManager.getConnection(request);	
		//stmt = conn.createStatement();
		if(notify_code!="")
			{
			String sql="SELECT LONG_DESC,SHORT_DESC,DEFAULT_NOTE_TYPE,EMAIL_APPLICABLE,EFF_STATUS FROM  MR_NOTIFICATION_SETUP  WHERE NOTIFICATION_CODE=?";
			 stmt1 = conn.prepareStatement(sql);
			 stmt1.setString(1,notify_code);
			rset=stmt1.executeQuery();
			if(rset.next())
				{
				longdesc=rset.getString("LONG_DESC");
				shortdesc=rset.getString("SHORT_DESC");
				default_note_type=rset.getString("DEFAULT_NOTE_TYPE");
				email_applicable=rset.getString("EMAIL_APPLICABLE");
				effstatus=rset.getString("EFF_STATUS");
				}
				
			if(rset!=null)	 rset.close();
			if(stmt1!=null)	 stmt1.close();
			if(effstatus.equals("D"))
				{
				otherTextAttribute="READONLY";
				checkBoxAttribute="";
				otherSelectAttribute="DISABLED";
				}
			else{
				otherTextAttribute="";
				checkBoxAttribute="CHECKED";
				otherSelectAttribute="";
				}
			if(email_applicable.equals("Y"))
			emailcheckBoxAttribute="CHECKED";
			else emailcheckBoxAttribute="";
			codeTextAttribute="readonly";
			}
		else 
			{
				eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
			}
		%>
	   	<form name='Notification_Setup_form' id='Notification_Setup_form' action='../../servlet/eMR.NotifiableSetupServlet' method='post' target='messageFrame'>
      	<div align='left'>
		<BR><BR><BR><BR><BR><BR><BR><BR><BR>
      	<table border='0' cellpadding='5' cellspacing='0' width='auto' align='center'>
		<tr>
      		    <td width='50%' class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      		    <td width='50%' class='fields'>
      		    <input type='text' name='notify_code' id='notify_code' value="<%=notify_code%>" onKeyPress="return CheckForSpecChars(event)"  size='4' maxlength='4' <%=codeTextAttribute%> <%=eventFunctionForCase%>>
      		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
			<tr>
      		     <td  class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      		    <td class='fields'>
      		    <input type='text' name='long_desc' id='long_desc' size='40' maxlength='40' value="<%=longdesc%>" <%=otherTextAttribute%>   onBlur="makeValidString(this);">
      		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
			<tr>
      		    <td  class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		    <td class='fields'>
		    <input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' value="<%=shortdesc%>" <%=otherTextAttribute%>   onBlur="makeValidString(this);">
		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
			<tr>
      		    <td  class='label'><fmt:message key="Common.Default.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></td>
		    <td class='fields'>
			<select name='default_note_type_sel' id='default_note_type_sel' <%=otherSelectAttribute%> onchange="document.forms[0].default_note_type.value=this.value"><option value=''>Select</option>
			<%try
				{
				
				String notify_sql = "SELECT NOTE_TYPE, NOTE_TYPE_DESC FROM CA_NOTE_TYPE_LANG_VW  WHERE LANGUAGE_ID = '"+locale+"' AND NOTE_GROUP_ID = '*NOTIFORM' AND EFF_STATUS = 'E' ORDER BY 2";
				stmt = conn.createStatement();
				rset = stmt.executeQuery(notify_sql);
				while(rset.next())
					{
					
					String note_type=rset.getString("NOTE_TYPE");
					String note_type_desc=rset.getString("NOTE_TYPE_DESC");
					if(note_type.equals(default_note_type)){
					out.println("<option value='"+note_type+"' selected>"+note_type_desc+"</option>");
					}
					else	{
					out.println("<option value='"+note_type+"'>"+note_type_desc+"</option>");
					}
					}
				if(rset!=null)	 rset.close();
				if(stmt!=null)	 stmt.close();
				}
			catch(Exception e)	
				{
				e.printStackTrace();
				}
			
			%>
			</select><img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
			<tr>
      		    <td  class='label'><fmt:message key="Common.email.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Applicable.label" bundle="${common_labels}"/> </td>
		    <td class='fields'>
		    <input type='checkbox' name='email_applicable_chk' id='email_applicable_chk'  <%=emailcheckBoxAttribute%> <%=otherSelectAttribute%> onClick="emailchange()"></img></td>
      		</tr>
			<tr>
      		     <td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
      		     <td class='fields'>
      		     <input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%>  onClick="change()"></td>
      		</tr>
			</table>
			</div>
			 <%  if(notify_code==""){%>
     	<input type='hidden' name='function' id='function' value='insert'>
      	<input type='hidden' name='function_name' id='function_name' value='insert'>

      <%}else{%>

      	<input type='hidden' name='function' id='function' value='modify'>
      	<input type='hidden' name='function_name' id='function_name' value='modify'>
		
		
     <%}%>
			<input type='hidden' name='default_note_type' id='default_note_type' value='<%=default_note_type%>'>
			<input type='hidden' name='email_applicable' id='email_applicable' value='<%=email_applicable%>'>
			</form>
      	</body>
      	</html>
		<%}catch(Exception e){/* out.println(e.toString()); */e.printStackTrace();}
		finally{
	ConnectionManager.returnConnection(conn,request);}%>
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

