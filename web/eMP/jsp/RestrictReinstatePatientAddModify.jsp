<!DOCTYPE html>
<!-- 
CRF Reference No: MMS-DM-CRF-0210.1
Detected Release: Dec23
File Prepared by: Ajay Hatwate
File Prepared on: 04/10/2023
-->
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.ConnectionManager" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<% 

	String locale = (String)session.getValue("LOCALE");
	locale = (locale == null || locale.equals(""))?"en":locale;
	java.util.Locale loc = new java.util.Locale(locale);
	java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);

	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
    Connection con = null;
    request.setCharacterEncoding("UTF-8");
    try
    {
		con = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ResultSet rs1=null;
		String patient_id = request.getParameter("Patient_ID");
		String restricted_yn =""; 
		String remarks="";
		String reason="";
		String isRestrictedBefore = "";
		StringBuffer sbQuery = new StringBuffer("Select RESTRICT_REINSTATE_YN, RESTRICT_REINSTATE_REMARKS,RESTRICT_REINSTATE_REASON_CODE from Mp_Patient where Patient_Id=?");
		pstmt = con.prepareStatement(sbQuery.toString());
		pstmt.setString(1,patient_id);
	
		rs = pstmt.executeQuery();
		if(rs != null) 
		{
			if(rs.next()) 
			{
				restricted_yn = rs.getString("RESTRICT_REINSTATE_YN")==null ? "Y" : rs.getString("RESTRICT_REINSTATE_YN");
				remarks = rs.getString("RESTRICT_REINSTATE_REMARKS")==null ? "" : rs.getString("RESTRICT_REINSTATE_REMARKS");
				reason = rs.getString("RESTRICT_REINSTATE_REASON_CODE")==null ? "" : rs.getString("RESTRICT_REINSTATE_REASON_CODE");
			}
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		
		pstmt = con.prepareStatement("Select count(patient_id) from mp_pat_restrict_audit where patient_id=?");
		pstmt.setString(1,patient_id);
	
		rs = pstmt.executeQuery();
		if(rs != null) 
		{
			if(rs.next()) 
			{
				if(rs.getInt(1)==0){
					isRestrictedBefore="N";
				}else{
					isRestrictedBefore="Y";
				}
			}
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		
%>
<html>
<head>
	<link rel="stylesheet" type="text/css" href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script> 
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src="../../eMP/js/RestrictReinstatePatient.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<style>
textarea {
  resize: none;
}
</style>
<body  OnMouseDown="CodeArrest()" onLoad='startBlink();' onKeyDown='lockKey();'>
<form name="restrict_reinstate_patient_form" id="restrict_reinstate_patient_form" action="../../servlet/eMP.RestrictReinstatePatientServlet?Patient_Id=<%=patient_id%>" method="post" target="messageFrame">
<center>
<br> 
 <table border="0" cellpadding="3" cellspacing="0" width="97%">
  <tr>
		<td width='100% 'class="BORDER">
		<table border="0" cellpadding="3" cellspacing="0" width="100%">
		<tr>
				<td class='label' width='20%'>&nbsp;</td>
				<td class='label' width='20%'>&nbsp;</td>
				<td class='label' width='60%'>&nbsp;</td>
		</tr>
        <tr>
				<td class='label'>&nbsp;</td>
			   <td class="label"><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
			   <td >
				<% if(restricted_yn.equals("N"))
				   { 
						out.println("<input type='text'   value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Reinstate.label","mp_labels")+"' name='Action_1' id='Action_1' size ='15' readonly> 			 <input type='hidden' value='Active' name='status' id='status'>");
					}
					else 
					{
						out.println("<input type='text'   value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Restricted.label","mp_labels")+"'   name='Action_1' id='Action_1' size ='15'  readonly> 			 <input type='hidden' value='Restricted'   name='status' id='status' >");
					}
				%>  
				<%if(isRestrictedBefore.equals("Y")){ %>				&nbsp;
				<input type='button' value="<%=common_labels.getString("Common.AuditTrail.label")%>" onclick="callAuditTrailScreen()" class='BUTTON'></input>
				<%} %>
				</td>
				</tr>
				
				<tr>
				<td class='label'>&nbsp;</td>
			   <td class="label"><fmt:message key="Common.action.label" bundle="${common_labels}"/></td>
			   <td >
				<% if(restricted_yn.equals("Y"))
				   { 
						out.println("<input type='text'   value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Reinstate.label","mp_labels")+"' name='Action_1' id='Action_1' size ='15' disabled> 			 <input type='hidden' value='Reinstate' name='action' id='action'>");
					}
					else 
					{
						out.println("<input type='text'   value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Restrict.label","mp_labels")+"'   name='Action_1' id='Action_1' size ='15'  disabled> 			 <input type='hidden' value='Restrict'   name='action' id='action' >");
					}
				%>  
				</td></tr>
				
				
				
				
				
				<% if(restricted_yn.equals("N")) 
				{
				%>  
				<tr>
				<td class='label'>&nbsp;</td>
				<td  class="label"><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
			   <td ><Select name="reason" id="reason" >
				<Option value="">---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</OPTION>
<%
		pstmt = con.prepareStatement("Select Reason_Code,long_desc from MP_PAT_RESTRICTION_REASON where eff_status = 'E' order by short_desc");
		rs1 = pstmt.executeQuery();
            if(rs1 !=null)
			{
                while(rs1.next()) out.println("<Option value='"+ rs1.getString("Reason_Code") + "'>" +rs1.getString("long_desc")+"</OPTION>" );
             }	
    } else out.println("<input type='hidden' name='reason' id='reason' value='"+reason+"'>");                      
		%>
		   </Select><%if (restricted_yn.equals("N")){%><img src='../images/mandatory.gif'></img>
		<% } %>
                   </td>
        </tr>
<% if(restricted_yn.equals("N")) { %>
		<tr>
		    <td class='label'>&nbsp;</td>
		   <td  class="label" valign="center"><fmt:message key="eMP.RestrictionRemark.label" bundle="${mp_labels}"/></td>
		   <td ><TextArea name="restriction_remark" size=500 onKeyPress="checkMaxLimit(this, 500)" onpaste="maxLengthPaste(this, '500')" maxlength=500 rows="5" cols="45"></TextArea> </td>
		</tr>
		  <tr><td class='label' colspan='3'>&nbsp;</td></tr>
<%}else{ %>

		<tr>
		    <td class='label'>&nbsp;</td>
		   <td  class="label" valign="center"><fmt:message key="eMP.RestrictionRemark.label" bundle="${mp_labels}"/></td>
		   <td ><TextArea name="restriction_remark" onKeyPress="checkMaxLimit(this, 500)" onpaste="maxLengthPaste(this, '500')" size=500 maxlength=500 rows="5" cols="45" disabled><%=remarks %></TextArea> </td>
		</tr>


		<tr>
		   <td class='label'>&nbsp;</td>
		   <td  class="label" valign="center"><fmt:message key="eMP.ReinstatementRemark.label" bundle="${mp_labels}"/></td>
		   <td ><TextArea name="reinastatement_remark" onKeyPress="checkMaxLimit(this, 500)" onpaste="maxLengthPaste(this, '500')" size=500 maxlength=500 rows="5" cols="45"></TextArea></td>
		</tr>
<% }%>
		<tr><td class='label' colspan='3'></td></tr>
	</table>
   </td>
   </tr>
  </table>
</center>
<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
<%if(restricted_yn.equals("N")){ %>
<input type='hidden' name='operation' id='operation' value='restrict'>
<%}else{ %>
<input type='hidden' name='operation' id='operation' value='reinstate'>
<%} %>
</form>
</body>

<%
    if(rs != null) rs.close();
    if(rs1 != null) rs1.close();
	if(pstmt != null) pstmt.close();
}
catch(Exception e){out.println(e);}
finally{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

