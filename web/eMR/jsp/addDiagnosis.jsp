<!DOCTYPE html>
<!--
	Developed by 	:	Kumar
	Created on 	:	29/11/2001
	Module		:	mr
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "java.util.*,java.sql.*,java.text.*,webbeans.eCommon.*,java.sql.Statement,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eMR/js/CreatePatientFile.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	var scheme=""
	
	

function callDesc(obj){
       document.forms[0].diag_desc.value="";
		var pq = document.forms[0].diag_code_scheme.value;
		obj.value = obj.value.toUpperCase();		
		if (pq == 1 || pq == 2)
		{
			var p_diag_code = obj.value; 
			var indicator= "";
			if(document.forms[0].diag_code_scheme.value == '2') {
				indicator=document.forms[0].cause_indicator.value;
			    var p_scheme	= 2;
			}
			else
				 var p_scheme    = 1;

			var sensitive='N';
			if(document.forms[0].authorize!=null)
			{
			   if(document.forms[0].authorize.value=="Normal Mode")
					sensitive='Y';
			}
			htmlVal = "<html><body onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eMR/jsp/RetICDDescVal.jsp'><input type='hidden' name='p_diag_code' id='p_diag_code' value='"+p_diag_code+"'><input type='hidden' name='p_scheme' id='p_scheme' value='"+p_scheme+"'><input type='hidden' name='p_cause_indicator' id='p_cause_indicator' value='"+indicator+"'><input type='hidden' name='p_sensitive_yn' id='p_sensitive_yn' value='"+sensitive+"'></form></body></html>";
			parent.parent.frames[3].document.body.insertAdjacentHTML('afterbegin',htmlVal);
			parent.parent.frames[3].document.forms[0].submit();
		}
	}


	</script>

	</head>
	<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		Connection con=null;
		Statement stmt	= null;
try{
		con=ConnectionManager.getConnection(request);
		
		ResultSet rset		= null;
		String facilityId		= (String)session.getValue("facility_id");		

		String f_authorize_yn ="";
		String record_type = "";
		String cause_indicator ="";
		String diag_scheme = "";
		String diag_code_scheme = "";

		Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String userid = p.getProperty( "login_user" ) ;
		String practitioner_id= request.getParameter("practitioner_id");
		f_authorize_yn= request.getParameter("f_authorize_yn");
		if (f_authorize_yn==null) f_authorize_yn="N";
		stmt = con.createStatement();
		rset = stmt.executeQuery("select diag_code_scheme, decode(diag_code_scheme,1,'ICD10',2,'ICD9-CM') from mr_parameter");
		if(rset != null)
		{
			rset.next();
			diag_code_scheme = rset.getString(1);
			diag_scheme = rset.getString(2);	
		}	
		if (diag_code_scheme == "2") 
			record_type = "D";
		else
			record_type = "";

		if(rset!=null) 	rset.close();
		if(stmt!=null) 	stmt.close();
%>

<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<center>
<form name='DiagAddDtl_form' id='DiagAddDtl_form'  method="post" target="Dummy_frame">
	<table border='0' cellpadding='0' cellspacing='0' width="100%">
		<tr><td class="COLUMNHEADER" colspan=4><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></td></tr>
		<tr>
			<td width="25%" class=label ><fmt:message key="Common.DiagnosisType.label" bundle="${common_labels}"/></td>
			<td width="25%" class="fields"><select name="diag_type" id="diag_type">
					<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---
					<option value='P' ><fmt:message key="Common.Provisional.label" bundle="${common_labels}"/>
					<option value='D' ><fmt:message key="Common.Differential.label" bundle="${common_labels}"/>
					<option value='F' ><fmt:message key="Common.final.label" bundle="${common_labels}"/>
				</select>		
			</td>
			<td width="25%" class=label >&nbsp;</td>
			<td width="25%" class=label >&nbsp;</td>
		</tr>
		<tr>
			<td class=label ><fmt:message key="Common.code.label" bundle="${common_labels}"/></td><td class="fields"><input type="text" maxlength="5" name="diag_code" id="diag_code" size=5 onblur="callDesc(this)" tabindex=1 onKeyPress="return valid_ch(event)" ><input type="button" class='Button' name="search_button" id="search_button" value="?" onClick=show_window('1')><img src='../../eCommon/images/mandatory.gif'>
			<font size=1><%=diag_scheme%></font></td>
	
			<%
				if(diag_code_scheme.equals("2"))
				{
					String sel="";
					%>
						<tr>
						<td class='label'  nowrap><fmt:message key="Common.CauseIndicator.label" bundle="${mr_labels}"/></td>
						<td class="fields">
								<select name='cause_indicator' id='cause_indicator' onchange="callDesc(diag_code)"  tabindex=2>
										<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
											<%
												if(cause_indicator.equals("E"))
													sel="selected";
											%>
										<option value='E' <%=sel%>><fmt:message key="Common.external.label" bundle="${common_labels}"/></option>
								</select>
						</td>
						</tr>
					<%
				}				
				else {
				%>
					<input type='hidden'  name='cause_indicator' id='cause_indicator' value=''>
				<% }
			%>
			<td class=label ><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<td class="fields"><textarea rows=1 cols=30 name="diag_desc" style='resize: none;'  onkeyPress='checkMaxLimit(this,70)'   onBlur="return makeValidString(this);" readonly></textarea></td>
		</tr>

		<tr>
			<td class=label ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			<td class="fields" colspan='3'><textarea rows=2 cols=30 name="pr_remarks" style='resize: none;'  size=2000 tabindex=3 onkeyPress='checkMaxLimit(this,2000)' onBlur="return makeValidString(this);"></textarea></td>
		</tr>
		<tr>			
			<td colspan='2' class='fields' >&nbsp;</td>
			<%
				stmt = con.createStatement();
				rset = stmt.executeQuery("select 'x' from MR_USER_ACCESS_RIGHTS_VW where  FACILITY_ID = '"+facilityId+"' and APPL_USER_ID='"+userid+"' and ACCESS_TYPE ='E' and PATIENT_TYPE='O' and ACCESS_SCOPE='SD'");
				if(rset!=null)
				{
					if(rset.next())
					{
						String authorize_normal_mode_value;
						if (f_authorize_yn.equals("N"))
						{	
							authorize_normal_mode_value= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorize.label","common_labels")+' '+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mode.label","common_labels");
							%>
							<td class='button' colspan='2' ><input type='button' name='authorize' id='authorize' value='<%=authorize_normal_mode_value%>' class='button' id='Authorize_Mode' onclick='chkAuthorize(this)'>
					<%	}else{	
								authorize_normal_mode_value= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels")+' '+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mode.label","common_labels");
	
								%>
							<td class='button' colspan='2'><input type='button' name='authorize' id='authorize' value='<%=authorize_normal_mode_value%>' class='button' id='Normal_Mode' onclick='chkAuthorize(this)'>	
					<%	}
					}
					else
					{	%>
						<td class='button' colspan='2'>
				<%	}
				}
				if(rset!=null) 	rset.close();
				if(stmt!=null) 	stmt.close();
			%>	<input type='button' name='Add' id='Add' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")%>' class='button'  tabindex=4 onclick='return submitPage1()'><input type='button' name='Cancel' id='Cancel' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' tabindex=5 class='button' onclick='cancelPage1()'></td>
		</tr>
		<tr><td class=label colspan=4>&nbsp;</td></tr>
		<tr><td class=label colspan=4>&nbsp;</td></tr>
		</table>
		<INPUT TYPE="hidden" name=diag_code_scheme value="<%=diag_code_scheme%>">
		<INPUT TYPE="hidden" name=diag_scheme value="<%=diag_scheme%>">
		<input type="hidden"  name="record_type" id="record_type" value="<%=record_type%>">		
		<input type="hidden"  name="cause_ind" id="cause_ind" value="">
		<input type="hidden"  name="sensitive_yn" id="sensitive_yn" value="">
		<input type="hidden"  name="mode" id="mode" value='Add'>
		<input type="hidden"  name="row_id" id="row_id" value=''>
		<input type="hidden"  name="p_authorize" id="p_authorize" value = "<%=f_authorize_yn%>">
		<input type="hidden"  name="practitioner_id" id="practitioner_id" value = "<%=practitioner_id%>">
		</form>
		</center>
	</body>
<%
}catch(Exception e)	{/* out.println(e.toString()); */e.printStackTrace();}
finally
{
	try
	{
	if(stmt != null)stmt.close();
	}
	catch(Exception e)
	{
	}
	if(con!=null) ConnectionManager.returnConnection(con,request);
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

