<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
      <head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
	    
		<script language="javascript" src="../js/DiagGroup.js"></script>

      </head>
<body OnMouseDown='CodeArrest()' onload='FocusFirstElement()' onKeyDown = 'lockKey()'>
<%
	 request.setCharacterEncoding("UTF-8");
	 request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
     Connection conn=null; 

try{
	//Statement stmt=null;
	PreparedStatement stmt=null;
   	 ResultSet rset=null;
   
   String diag_code_scheme="";String sel1="";String sel2 = "";
   String sel11="";String sel12="";
   String tab_list_type="";
   String diag_code_range="";
   String DiagGroup="";
   String longdesc="";
   String shortdesc="";
   String effstatus="";
   String codeTextAttribute="";
   String otherTextAttribute="";
   String checkBoxAttribute="";
   String eventFunctionForCase="";
   String diag_code_scheme_desc="";
   String tablist="";
   boolean newDiagGroup = false;
   String sql="";

  	conn = ConnectionManager.getConnection(request);
	DiagGroup=request.getParameter("tab_list_no");

	if(DiagGroup==null){
		DiagGroup="";
		longdesc="";
		shortdesc="";
		effstatus="E";
		codeTextAttribute="";
		otherTextAttribute="";
		diag_code_scheme="";
		checkBoxAttribute="CHECKED";
		newDiagGroup=true;
		eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
	}else
	{
	       
     try
	{

		//stmt = conn.createStatement();

		sql = "select tab_list_no,long_desc,short_desc,eff_status,diag_code_scheme ,decode(diag_code_scheme ,'1','ICD10','2','ICD9-CM','3','CPT4','4','ICD9-CM') diag_code_scheme_desc,tab_list_type,diag_code_range  from mr_tab_list where tab_list_no=?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1,DiagGroup);
		rset = stmt.executeQuery();
		rset.next();
		DiagGroup=rset.getString("tab_list_no");
		longdesc=rset.getString("long_desc");
		shortdesc=rset.getString("short_desc");
		diag_code_scheme =rset.getString("diag_code_scheme");
		diag_code_range =rset.getString("diag_code_range");
		tab_list_type =rset.getString("tab_list_type");
		if(tab_list_type.equals("D"))
		tablist="Disease";
		else if(tab_list_type.equals("P"))
		tablist="Procedure";
		if(diag_code_scheme == null)  diag_code_scheme="";
		if(diag_code_range == null)  diag_code_range="";
		if (diag_code_scheme.equals("1"))sel1="selected";
		else if (diag_code_scheme.equals("2"))sel2="selected";
		diag_code_scheme_desc = rset.getString("diag_code_scheme_desc");
		if(diag_code_scheme_desc == null) diag_code_scheme_desc="";
		effstatus=rset.getString("eff_status");
		if(effstatus.equals("D"))
		{
			otherTextAttribute="READONLY";
			checkBoxAttribute="";
		}else
		{
			otherTextAttribute="";
			checkBoxAttribute="CHECKED";
		}
	}
	catch(Exception e)
	{
		e.toString();
	}
	finally
	{
		try
		{
		if(stmt!=null)
		stmt.close();
		if(rset!=null)
		rset.close();
		}
		catch(Exception e)
	{
		
	}
	}
	codeTextAttribute="READONLY";
	newDiagGroup=false;
	eventFunctionForCase="";
	}
%>
      	<form name='DiagGroup_form' id='DiagGroup_form' action='../../servlet/eMR.DiagGroupServlet' method='post' target='messageFrame'>
<div align='left'>
      	<BR><BR><BR><BR><BR>
      	<BR><BR><BR>
      	<table border='0' cellpadding='5' cellspacing='0' width='auto' align='center'>
      	
      		<tr>
      		    <td width='50%' class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      		    <td width='50%' class='fields'>
      		    <input type='text' name='tab_list_no' id='tab_list_no' value="<%=DiagGroup%>" size='4' maxlength='4' onKeyPress="return CheckForSpecChars(event)"  <%=codeTextAttribute%> <%=eventFunctionForCase%>>
      		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
      		
      		<tr>
      		    <td class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      		    <td class='fields'>
				<TEXTAREA style="resize:none" NAME="long_desc" <%=otherTextAttribute%> COLS="40" onkeyPress='checkMaxLimit(this,199)' onblur="checkNoOfCharacter(this,200)"><%=longdesc%></TEXTAREA>
      		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
      		
      		<tr>
      		    <td  class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		    <td class='fields'>
		    <input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' value="<%=shortdesc%>" <%=otherTextAttribute%> onBlur="makeValidString(this);" >
		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
			
      		<tr>
			<td  class='label'><fmt:message key="eMR.DiagnosisCodeRange.label" bundle="${mr_labels}"/></td>
		    <td class='fields'>
			<TEXTAREA style="resize:none" NAME="diag_code_range" <%=otherTextAttribute%> COLS="40" onkeyPress='checkMaxLimit(this,199)'  onblur="checkNoOfCharacter(this,200)" ><%=diag_code_range%></TEXTAREA>
		    </td>
      		</tr>
      		
      		<!-- <tr>
      		     <td class='label'><fmt:message key="Common.DiagnosisCodingScheme.label" bundle="${common_labels}"/></td>
      		     <td class='fields'>
      		     <% if(effstatus.equals("E")){ %>
      		     <select name='diag_code_scheme' id='diag_code_scheme'><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----<option value='1' <%=sel1%>><fmt:message key="eMR.ICD10.label" bundle="${mr_labels}"/><option value='2' <%=sel2%>><fmt:message key="Common.ICD9CM.label" bundle="${common_labels}"/>
      		     </select>
      		     <% } else { %>
      		     	<input type='text' name='diag_code_scheme_desc' id='diag_code_scheme_desc' readOnly value="<%=diag_code_scheme_desc%>" size='7'><input type='hidden' name='diag_code_scheme' id='diag_code_scheme' readOnly value="<%=diag_code_scheme%>" size='5'>
      		     <% } %>
      		     <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr> -->
      		
			
			<tr>
				<td class='label' > <fmt:message key="eMR.TabulationListType.label" bundle="${mr_labels}"/></td>
				<td class='fields'><% if(effstatus.equals("E")){ %><select name='tab_list_type' id='tab_list_type'>
				<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----</option>
				<!-- <option value='D' <%=sel11%>><fmt:message key="eMR.Disease.label" bundle="${mr_labels}"/></option> -->
				<option value='D' <%=sel11%>>Diagnosis</option>
				<option value='P' <%=sel12%>><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></option>
				</select>
				  <% } else { %>
				<input type='text' name='tab_list_type_desc' id='tab_list_type_desc' readOnly value="<%=tablist%>" size='7'><input type='hidden' name='tab_list_type' id='tab_list_type' readOnly value="<%=tab_list_type%>" size='5'>
				<% } %>

				<img src='../../eCommon/images/mandatory.gif'></img></td>
			</tr>
			
			
			<tr>
		     <td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		     <td class='fields'>
		     <input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="change()"></td>
		</tr>
			

     	</table>
    <%  if(newDiagGroup){%>

      	<input type='hidden' name='function' id='function' value='insert'>
      	<input type='hidden' name='function_name' id='function_name' value='insert'>

      <%}else{%>

      	<input type='hidden' name='function' id='function' value='modify'>
      	<input type='hidden' name='function_name' id='function_name' value='modify'>
     <%}%>

<!-- <script>document.forms[0].diag_code_scheme.value="<%=diag_code_scheme%>" </script> -->
 <script>document.forms[0].tab_list_type.value="<%=tab_list_type%>" </script> 
      	</form>
      	</body>
      	</html>
<%
}catch(Exception e)			{/* out.println(e.toString()); */e.printStackTrace();	}
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

