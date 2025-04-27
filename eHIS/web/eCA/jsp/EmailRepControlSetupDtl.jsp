<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             	100           		?           	created
17/12/2013		IN044085		Ramesh G		Bru-HIMS-CRF-024.2 
---------------------------------------------------------------------------------------------------------------
 */
%>
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.net.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
 <%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/EmailRepControlSetup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;

	String mode="insert";
	String sql_disclimer_code="";
	String sql_disclimer_desc="";
	String sql="";
	String subject_text="";
	String disclimer_id="";
	String email_to_pat_id_yn="N";
	String pat_body_text_ref="";
	String very_reqd_pat_yn="N";
	String email_to_regd_id_yn="N";
	String regd_id_body_text_ref="";
	String very_reqd_regd_id_yn="N";
	String email_to_any_id_yn="N";
	String any_id_body_text_ref="";
	String very_reqd_any_id_yn="N";
	String very_reqd_conf_result_yn="N";
	String dispEmailAppRule="";

	String sys_appl_to_pat_id_yn="N";
	String sys_appl_to_regd_id_yn="N";
	String sys_appl_to_any_id_yn="N";
	String sys_appl_to_url_yn="N"; //Bru-HIMS-CRF-024 [IN030465]
	
	String very_reqd_pat_yn_enabled = "disabled";
	String pat_body_text_ref_enabled = "disabled";
	String very_reqd_regd_id_yn_enabled = "disabled";
	String regd_id_body_text_ref_enabled = "disabled";
	String very_reqd_any_id_yn_enabled = "disabled";
	String any_id_body_text_ref_enabled = "disabled";
	String email_to_pat_id_checked = "";
	String email_to_regd_id_checked = "";
	String email_to_any_id_yn_checked = "";
	
	String module_id=request.getParameter("module_id")==null?"":((String)request.getParameter("module_id"));
	String report_id=request.getParameter("report_id")==null?"":((String)request.getParameter("report_id"));
	String bodyTextVals_pat_text="";
	String bodyTextVals_reqd_regd="";
	String bodyTextVals_any_id="";
	String recipients_id =""; //Bru-HIMS-CRF-024 [IN030465]
	String url_text="";//Bru-HIMS-CRF-024 [IN030465]
	if(!module_id.equals("") && !report_id.equals("")){
	try
	{
		
		con =	ConnectionManager.getConnection(request);
		
		//sql ="select subject_text,disclimer_id,email_to_pat_id_yn,pat_body_text_ref,very_reqd_pat_yn,email_to_regd_id_yn,regd_id_body_text_ref,very_reqd_regd_id_yn,email_to_any_id_yn,any_id_body_text_ref,very_reqd_any_id_yn,very_reqd_conf_result_yn,sys_appl_to_pat_id_yn,sys_appl_to_regd_id_yn,sys_appl_to_any_id_yn from SM_REPORT_MAIL_INFO where module_id=? and report_id=?"; //Bru-HIMS-CRF-024 [IN030465]
		sql ="select subject_text,disclimer_id,email_to_pat_id_yn,pat_body_text_ref,very_reqd_pat_yn,email_to_regd_id_yn,regd_id_body_text_ref,very_reqd_regd_id_yn,email_to_any_id_yn,any_id_body_text_ref,very_reqd_any_id_yn,very_reqd_conf_result_yn,sys_appl_to_pat_id_yn,sys_appl_to_regd_id_yn,sys_appl_to_any_id_yn,recipients_id,url_text from SM_REPORT_MAIL_INFO where module_id=? and report_id=?"; //Bru-HIMS-CRF-024 [IN030465]
		stmt=con.prepareStatement(sql);
		stmt.setString(1,module_id);
		stmt.setString(2,report_id);
		rs = stmt.executeQuery();			 
		if(rs.next()){
			mode="update";
			subject_text=rs.getString("subject_text")==null?"N":rs.getString("subject_text");
			disclimer_id=rs.getString("disclimer_id")==null?"N":rs.getString("disclimer_id");
			email_to_pat_id_yn=rs.getString("email_to_pat_id_yn")==null?"N":rs.getString("email_to_pat_id_yn");
			pat_body_text_ref=rs.getString("pat_body_text_ref")==null?"":rs.getString("pat_body_text_ref");
			very_reqd_pat_yn=rs.getString("very_reqd_pat_yn")==null?"N":rs.getString("very_reqd_pat_yn");
			email_to_regd_id_yn=rs.getString("email_to_regd_id_yn")==null?"N":rs.getString("email_to_regd_id_yn");
			regd_id_body_text_ref=rs.getString("regd_id_body_text_ref")==null?"":rs.getString("regd_id_body_text_ref");
			very_reqd_regd_id_yn=rs.getString("very_reqd_regd_id_yn")==null?"N":rs.getString("very_reqd_regd_id_yn");
			email_to_any_id_yn=rs.getString("email_to_any_id_yn")==null?"N":rs.getString("email_to_any_id_yn");
			any_id_body_text_ref=rs.getString("any_id_body_text_ref")==null?"":rs.getString("any_id_body_text_ref");
			very_reqd_any_id_yn=rs.getString("very_reqd_any_id_yn")==null?"N":rs.getString("very_reqd_any_id_yn");
			very_reqd_conf_result_yn=rs.getString("very_reqd_conf_result_yn")==null?"N":rs.getString("very_reqd_conf_result_yn");
			sys_appl_to_pat_id_yn=rs.getString("sys_appl_to_pat_id_yn")==null?"N":rs.getString("sys_appl_to_pat_id_yn");
			sys_appl_to_regd_id_yn=rs.getString("sys_appl_to_regd_id_yn")==null?"N":rs.getString("sys_appl_to_regd_id_yn");
			sys_appl_to_any_id_yn=rs.getString("sys_appl_to_any_id_yn")==null?"N":rs.getString("sys_appl_to_any_id_yn");
			recipients_id = rs.getString("recipients_id")==null?"":(String)rs.getString("recipients_id"); //Bru-HIMS-CRF-024 [IN030465]
			url_text  = rs.getString("url_text")==null?"":(String)rs.getString("url_text"); //Bru-HIMS-CRF-024 [IN030465]
			if(email_to_pat_id_yn.equals("Y"))
				{
				 email_to_pat_id_checked="checked";
				 very_reqd_pat_yn_enabled="";
				 pat_body_text_ref_enabled="";
				}
			else
				email_to_pat_id_checked="";
			    //pat_body_text_ref="";

			if(email_to_regd_id_yn.equals("Y"))
				{
				 email_to_regd_id_checked="checked";
				 very_reqd_regd_id_yn_enabled="";
				 regd_id_body_text_ref_enabled="";
				}
			else
				email_to_regd_id_checked="";
			    //regd_id_body_text_ref="";

			if(email_to_any_id_yn.equals("Y"))
				{
				 email_to_any_id_yn_checked="checked";
				 very_reqd_any_id_yn_enabled="";
				 any_id_body_text_ref_enabled="";
				}
			else
				email_to_any_id_yn_checked="";
			    //any_id_body_text_ref="";
		}else{
			mode="insert";
			if(email_to_pat_id_yn.equals("Y"))
				{
				 email_to_pat_id_checked="checked";
				 very_reqd_pat_yn_enabled="";
				 pat_body_text_ref_enabled="";
				}
			else
				email_to_pat_id_checked="";
			    //pat_body_text_ref="";

			if(email_to_regd_id_yn.equals("Y"))
				{
				 email_to_regd_id_checked="checked";
				 very_reqd_regd_id_yn_enabled="";
				 regd_id_body_text_ref_enabled="";
				}
			else
		    	email_to_regd_id_checked="";
			    //regd_id_body_text_ref="";

			if(email_to_any_id_yn.equals("Y"))
				{
				 email_to_any_id_yn_checked="checked";
				 very_reqd_any_id_yn_enabled="";
				 any_id_body_text_ref_enabled="";
				}
			else
				email_to_any_id_yn_checked="";
			   //any_id_body_text_ref="";
		}
		//Bru-HIMS-CRF-024 Start.[IN030465]
		//IN044085 Start.
		//if(module_id.equals("CA") && report_id.equals("CANFREP")){
		if(module_id.equals("CA") && !report_id.equals("AHCLINREP")){
		//IN044085 End.
			sys_appl_to_pat_id_yn="N";
			sys_appl_to_any_id_yn="N";
			sys_appl_to_url_yn ="Y";
		}
		//Bru-HIMS-CRF-024 End.[IN030465]
		if(rs!=null)  rs.close(); 
		if(stmt!=null)  stmt.close();	
		bodyTextVals_pat_text=populateBodyText(con,module_id,report_id,pat_body_text_ref);
		bodyTextVals_reqd_regd=populateBodyText(con,module_id,report_id,regd_id_body_text_ref);
		bodyTextVals_any_id=populateBodyText(con,module_id,report_id,any_id_body_text_ref);
		
	}catch(Exception e)
	{
	//out.println("Exception@1: "+e.toString());//COMMON-ICN-0181
	e.printStackTrace();
	}finally { 
	ConnectionManager.returnConnection(con,request);
	}

}
%>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement();' onKeyDown="lockKey()">
<form name="EmailRepControlSetupDtlForm" id="EmailRepControlSetupDtlForm" action="../../servlet/eCA.EmailRepControlSetupServlet" method="post" target="messageFrame">
<table border=0 cellspacing=0 cellpadding=3 width='95%' align='center'>
<tr><td colspan='4'>&nbsp;</td></tr>

<tr>
<td class='label' ><fmt:message key="eCA.Subject.label" bundle="${ca_labels}"/></td><td class="fields" colspan='3'><input type="text" name="subject_text" id="subject_text" value="<%=subject_text%>" size=100 maxlength=100  onBlur="return makeValidString(this)"></td>
</tr>

<tr><td colspan='4'>&nbsp;</td></tr>

<tr>
<td class='label' ><fmt:message key="eCA.Disclaimer.label" bundle="${ca_labels}"/></td><td class="fields" >
<select name='disclimer_id' id='disclimer_id' onchange="document.getElementById("discView").style.display='inline'"><option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
<%
try {
								
	con = ConnectionManager.getConnection(request);
	sql="select distinct disclimer_code,disclimer_desc from  ca_disclimer_text  where eff_status='E' and applicable_to_rep_yn ='Y' order by disclimer_desc";
	stmt = con.prepareStatement(sql);
	rs = stmt.executeQuery();
	while( rs != null &&  rs.next())
	{
		sql_disclimer_code = rs.getString( "disclimer_code" ) ;
		sql_disclimer_desc = rs.getString( "disclimer_desc" ) ;
		if(disclimer_id.equals(sql_disclimer_code)){
			out.println("<option selected value='"+sql_disclimer_code+"'>"+sql_disclimer_desc+"</option>");
		}else{
			out.println("<option value='"+sql_disclimer_code+"'>"+sql_disclimer_desc+"</option>");
		}
		
	}
	if( rs != null )  rs.close();
	if( stmt != null )  stmt.close();
								
} catch(Exception e) {
	
	e.printStackTrace();
}finally { 
	ConnectionManager.returnConnection(con,request);
}
%></select>&nbsp;
	<a href='javascript:disclaimerText()' ID='discView' style='display' class="gridLink"><fmt:message key="Common.view.label" bundle="${common_labels}"/></a>
</td>

<td class='label' ><fmt:message key="eCA.VerificationRequiredForConfidentialResult.label" bundle="${ca_labels}"/></td>
<td class='fields' >&nbsp;<input type="checkbox" name="very_reqd_conf_result_yn" id="very_reqd_conf_result_yn" <%if(very_reqd_conf_result_yn.equals("Y")){%> checked <%}%>  value="<%=very_reqd_conf_result_yn%>" onchange="chkObj(this)"></td>

</tr>
<%
if(sys_appl_to_url_yn.equals("Y")){%>
<tr><td colspan='4'>&nbsp;</td></tr>
<tr>
<td class='label' >URL</td><td class="fields" colspan='3'><input type="text" name="url_text" id="url_text" value="<%=url_text%>" size=100 maxlength=100 onKeyPress='return CheckForSpeChar(event);'>&nbsp;<!-- <input type="button" value="?">&nbsp; --><img src='../../eCommon/images/mandatory.gif' ></img></td>
</tr>
<%}%>
</table>
<%
if(sys_appl_to_pat_id_yn.equals("N") && sys_appl_to_regd_id_yn.equals("N") && sys_appl_to_any_id_yn.equals("N")){
dispEmailAppRule="style='display:none;'";
}
%>
<table border=0 cellspacing=0 cellpadding=3 width='95%' align='center' <%=dispEmailAppRule%>>
<tr><td colspan='5'>&nbsp;</td></tr>

<th colspan=2> &nbsp;</th>
<th align='left' nowrap><fmt:message key="eCA.EmailIdControl.label" bundle="${ca_labels}"/></th>
<th align='left' nowrap><fmt:message key="eCA.BodyText.label" bundle="${ca_labels}"/></th>
<th align='left' nowrap><fmt:message key="eCA.VerificationRequired.label" bundle="${ca_labels}"/></th>	
<%if(sys_appl_to_pat_id_yn.equals("Y")){%>
<tr><td colspan='5'>&nbsp;</td></tr>

<tr>
<td class='label' colspan='2' width='35%' nowrap ><fmt:message key="eCA.ApplicabletoPatient.label" bundle="${ca_labels}"/></td>
<td class='fields' width='16%' nowrap><input type="checkbox" name="email_to_pat_id_yn" id="email_to_pat_id_yn" id='AP'
value="<%=email_to_pat_id_yn%>" onchange="chkObj(this)" onClick='checkdefault(this)' <%=email_to_pat_id_checked%>></td>
<td class='fields' nowrap><select name='pat_body_text_ref' id='pat_body_text_ref' id='APD1' <%=pat_body_text_ref_enabled%> onchange='' onClick='Assigndefault(this)'><option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option><%=bodyTextVals_pat_text%></select></td>
<td class='fields'  nowrap><input type="checkbox" name="very_reqd_pat_yn" id="very_reqd_pat_yn" id='APD' <%if(very_reqd_pat_yn.equals("Y")){%> checked <%}%> value="<%=very_reqd_pat_yn%>" <%=very_reqd_pat_yn_enabled%> onchange="chkObj(this)" onClick='Assigndefault(this)'></td>
</tr>
<%}else {%>
<input type='hidden' name='email_to_pat_id_yn' id='email_to_pat_id_yn' value="<%=email_to_pat_id_yn%>">
<%
}
if(sys_appl_to_regd_id_yn.equals("Y")){%>

	<tr><td colspan='5'>&nbsp;</td></tr>

	<tr>
	<td class='label' colspan='2' width='35%' nowrap><fmt:message key="eCA.ApplicableToRegisteredUsers.label" bundle="${ca_labels}"/></td>
	<!-- Bru-HIMS-CRF-024 Start.[IN030465] -->
	<!-- <td class='fields' width='16%' style="valign:middle;" nowrap><input type="checkbox" name="email_to_regd_id_yn" id="email_to_regd_id_yn" id='AR' value="<%=email_to_regd_id_yn%>" onchange="chkObj(this)" onClick='checkdefault(this)' <%=email_to_regd_id_checked%>></td> -->
	<td class='fields' width='16%' style="valign:middle;" nowrap><input type="checkbox" name="email_to_regd_id_yn" id="email_to_regd_id_yn" id='AR' value="<%=email_to_regd_id_yn%>" onchange="chkObj(this)" onClick='checkdefault(this)' <%=email_to_regd_id_checked%>>&nbsp;&nbsp;
	<%
	//IN044085 Start
	//if(module_id.equals("CA") && report_id.equals("CANFREP")){
	if(module_id.equals("CA") && !report_id.equals("AHCLINREP")){
	//IN044085 End.
	%>
	<A id="ATRNF" href="javascript:getRecipientsId();" style="mouseover:hand;" <%if(email_to_regd_id_checked.equals("")){%> style="display:none;" <%}%>><U>Email Recipients</U></A>&nbsp;<img id="ATRNF1"  src='../../eCommon/images/mandatory.gif' <%if(email_to_regd_id_checked.equals("")){%> style="display:none;" <%}%> /> <%}%></td>
	<!-- Bru-HIMS-CRF-024 End.[IN030465] -->
	<td class='fields' nowrap><select name='regd_id_body_text_ref' id='regd_id_body_text_ref' id='ARD1' <%=regd_id_body_text_ref_enabled%> onchange=''><option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option><%=bodyTextVals_reqd_regd%></select></td>
	<td class='fields' nowrap><input type="checkbox" name="very_reqd_regd_id_yn" id="very_reqd_regd_id_yn" id='ARD' <%if(very_reqd_regd_id_yn.equals("Y")){%> checked <%}%>  value="<%=very_reqd_regd_id_yn%>" <%=very_reqd_regd_id_yn_enabled%> onchange="chkObj(this)" onClick='Assigndefault(this)'></td>
	</tr>
	
<%}else{ %>
	<input type='hidden' name='email_to_regd_id_yn' id='email_to_regd_id_yn' value="<%=email_to_regd_id_yn%>">
<%
}
if(sys_appl_to_any_id_yn.equals("Y")){%>

<tr><td colspan='5'>&nbsp;</td></tr>

<tr>
<td class='label' colspan='2' width='35%' nowrap><fmt:message key="eCA.ApplicableToAdhocEmailID.label" bundle="${ca_labels}"/></td>
<td class='fields' width='16%' nowrap><input type="checkbox" name="email_to_any_id_yn" id="email_to_any_id_yn" id='AE' <%if(email_to_any_id_yn.equals("Y")){%> checked <%}%>  value="<%=email_to_any_id_yn%>" onchange="chkObj(this)" onClick='checkdefault(this)' <%=email_to_any_id_yn_checked%>></td>
<td class='fields' nowrap><select name='any_id_body_text_ref' id='any_id_body_text_ref' id='AED1' <%=any_id_body_text_ref_enabled%> onchange=''><option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option><%=bodyTextVals_any_id%></select></td>
<td class='fields' nowrap><input type="checkbox" name="very_reqd_any_id_yn" id="very_reqd_any_id_yn" id='AED' <%if(very_reqd_any_id_yn.equals("Y")){%> checked <%}%>  value="<%=very_reqd_any_id_yn%>" <%=very_reqd_any_id_yn_enabled%> onchange="chkObj(this)" onClick='Assigndefault(this)'></td>
</tr>
<%}else{ %>
<input type='hidden' name='email_to_any_id_yn' id='email_to_any_id_yn' value="<%=email_to_any_id_yn%>">
<%}%>
</table>
<table border=0 cellspacing=0 cellpadding=3 width='95%' align='center'>
<tr><td colspan='5'>&nbsp;</td></tr>

<tr><td colspan='5'>&nbsp;</td></tr>
</table>

<input type='hidden' name='module_id' id='module_id' value="<%=module_id%>">
<input type='hidden' name='report_id' id='report_id' value="<%=report_id%>">
<input type='hidden' name='mode' id='mode' value="<%=mode%>">
<input type='hidden' name='email_to_pat_id_yn1' id='email_to_pat_id_yn1' value='<%=email_to_pat_id_yn%>'>
<input type='hidden' name='email_to_regd_id_yn1' id='email_to_regd_id_yn1' value='<%=email_to_regd_id_yn%>'>
<input type='hidden' name='email_to_any_id_yn1' id='email_to_any_id_yn1' value='<%=email_to_any_id_yn%>'>
<input type='hidden' name='recipients_id' id='recipients_id' value='<%=recipients_id%>'> <!-- Bru-HIMS-CRF-024 [IN030465] -->
</form>
</body>
</html>
<%! 
public String populateBodyText(Connection con,String module_id,String report_id,String default_populate) throws Exception{
	
	PreparedStatement stmt=null;
	ResultSet rs=null;
	StringBuffer list=new StringBuffer();
	String body_text_ref="";
	String body_text_desc="";
	try {									
		stmt = con.prepareStatement("select distinct body_text_ref,body_text_desc body_text_desc from  SM_REPORT_MAIL_body  where module_id=? and report_id=? order by body_text_desc");
		stmt.setString(1,module_id);
		stmt.setString(2,report_id);
		rs = stmt.executeQuery();
		while( rs != null &&  rs.next())
		{
		   body_text_ref = rs.getString( "body_text_ref" ) ;
		   body_text_desc = rs.getString( "body_text_desc" ) ;
		   if(default_populate.equalsIgnoreCase(body_text_ref))
			{
				list.append("<option value='"+body_text_ref+"' selected>"+body_text_desc+"</option>");	
			}
			else
			{
				list.append("<option value='"+body_text_ref+"'>"+body_text_desc+"</option>");
			}
		}
		if( rs != null )  rs.close();
		if( stmt != null )  stmt.close();
									
	} catch(Exception e) {
		
		e.printStackTrace();
	}
	return list.toString();

}%>

