<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<HTML>
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8"); 
String resultMessage = XHDBAdapter.checkNull(request.getParameter("statusMsg"));
%>

<HEAD>
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale = ((String)session.getAttribute("LOCALE"));
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<style>
	body {
	margin:100px 0px; padding:0px;
	text-align:center;
	}
</style>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language='javascript' src='../../eXB/js/BillingParam.js'></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<BODY leftmargin=0 topmargin=0 class="boby" onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onLoad="initFunc();">
<%
Connection dbConn = null;
Statement stmt = null;
ResultSet rs = null;

String sql = "SELECT def_ss_blng_grp_id, def_ss_cust_group_code, def_ss_cust_code, def_ss_policy_type_code, def_ss_policy_num_ind, def_ss_policy_number, to_char(last_process_date,'dd/mm/yyyy HH24:MI:SS') last_process_date, to_char(last_process_confirm_date,'dd/mm/yyyy HH24:MI:SS') last_process_confirm_date, def_ss_ref_source_code_sub, no_ex_priv_extended, no_ex_priv_removed, no_privilege_added, to_char(last_data_uploaded_date,'dd/mm/yyyy HH24:MI:SS') last_data_uploaded_date, auth_process_user_id FROM xf_ss_priv_default_values";
String blngGrpID = "";
String custGrpCode = "";
String custCode = "";
String polTypeCode = "";
String polNoInd = "";
String policyNo = "";
String refSourceCodeSub = "";
String userID = "";

try
{
	dbConn = ConnectionManager.getConnection();	
	stmt = dbConn.createStatement();
	rs = stmt.executeQuery(sql);

	if(rs.next())
	{
		blngGrpID = XHDBAdapter.checkNull(rs.getString("def_ss_blng_grp_id"));
		custGrpCode = XHDBAdapter.checkNull(rs.getString("def_ss_cust_group_code"));
		custCode = XHDBAdapter.checkNull(rs.getString("def_ss_cust_code"));
		polTypeCode = XHDBAdapter.checkNull(rs.getString("def_ss_policy_type_code"));
		polNoInd = XHDBAdapter.checkNull(rs.getString("def_ss_policy_num_ind"));
		policyNo = XHDBAdapter.checkNull(rs.getString("def_ss_policy_number"));
		refSourceCodeSub = XHDBAdapter.checkNull(rs.getString("def_ss_ref_source_code_sub"));
		userID = XHDBAdapter.checkNull(rs.getString("auth_process_user_id"));
	}	

}
catch(Exception e)
{
	out.println("BillingParamSetupAdmin:General)Exception: "+e.toString());
	e.printStackTrace(System.err);
}
finally
{
	try
	{
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();		
		if(dbConn != null) ConnectionManager.returnConnection(dbConn);
	}
	catch(Exception e)
	{
		out.println("InterfaceParamSetupAdmin:Gfinally)Exception: "+e.toString());
	}
}
%>

<form name="BillingParamForm" id="BillingParamForm" method='post' action='../../servlet/eXB.BillingParamSetupServlet'>

<table width='50%' align='center' valign='center'>
<tr align="center">
	<td align='center' valign="center" class="label"><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/> </td>
	<td align='left'>		
		<input type="text" id="blngGrpID" name='blngGrpID' id='blngGrpID' size=4 maxlength="4" value='<%= blngGrpID %>'> <img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
<tr align="center">
	<td align='center' valign="center" class="label"><fmt:message key="eXH.PAYER_GROUP.Label" bundle="${xh_labels}"/> </td>
	<td align='left'>		
		<input type="text" id="custGrpCode" name='custGrpCode' id='custGrpCode' size=2 maxlength="2" value='<%= custGrpCode %>'> <img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
<tr align="center">
	<td align='center' valign="center" class="label"><fmt:message key="Common.Payer.label" bundle="${common_labels}"/> </td>
	<td align='left'>		
		<input type="text" id="custCode" name='custCode' id='custCode' size=8 maxlength="8" value='<%= custCode %>'> <img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
<tr align="center">
	<td align='center' valign="center" class="label"><fmt:message key="eXH.PolicyTypeCode.Label" bundle="${xh_labels}"/> </td>
	<td align='left'>		
		<input type="text" id="polTypeCode" name='polTypeCode' id='polTypeCode' size=20 maxlength="20" value='<%= polTypeCode %>'> <img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
<tr align="center">
	<td align='center' valign="center" class="label"><fmt:message key="eXH.POL_NUM_IND.Label" bundle="${xh_labels}"/> </td>
	<td align='left'>
		<SELECT name="polNoInd" id="polNoInd" ID="polNoInd" onChange="processPolInd()">
			<OPTION VALUE="" SELECTED><fmt:message key="Common.Select.label" bundle="${common_labels}"/></OPTION>
			<OPTION VALUE="N" <%= "N".equals(polNoInd)?"SELECTED":"" %>><fmt:message key="eXH.SMAS_NAT_ID_NO.Label" bundle="${xh_labels}"/></OPTION>
			<OPTION VALUE="P" <%= "P".equals(polNoInd)?"SELECTED":"" %>><fmt:message key="eXH.SMAS_PAT_ID.Label" bundle="${xh_labels}"/></OPTION>
			<OPTION VALUE="D" <%= "D".equals(polNoInd)?"SELECTED":"" %>><fmt:message key="eXH.FIX_STR.Label" bundle="${xh_labels}"/></OPTION>
		</SELECT>
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
<tr align="center">
	<td align='center' valign="center" class="label"><fmt:message key="eXH.PolicyNo.Label" bundle="${xh_labels}"/> </td>
	<td align='left'>		
		<input type="text" id="dPolicyNo" name='dPolicyNo' id='dPolicyNo' size=6 maxlength="6" value='<%= policyNo %>' <%= "F".equals(polNoInd)?"":"DISABLED" %>>
		<input type="hidden" name="policyNo" id="policyNo" id="policyNo" value="<%= policyNo %>">
	</td>
</tr>
<tr align="center">
	<td align='center' valign="center" class="label"><fmt:message key="eXH.REF_SUB_HOSP.Label" bundle="${xh_labels}"/> </td>
	<td align='left'>		
		<input type="text" id="refSourceCodeSub" name='refSourceCodeSub' id='refSourceCodeSub' size=6 maxlength="6" value='<%= refSourceCodeSub %>'>
	</td>
</tr>
<tr align="center">
	<td align='center' valign="center" class="label"><fmt:message key="eXH.AUTH_USER_ID.Label" bundle="${xh_labels}"/> </td>
	<td align='left'>		
		<input type="text" id="userID" name='userID' id='userID' size=30 maxlength="30" value='<%= userID %>'> <img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
</table>

<input type="hidden" name="resultMessage" id="resultMessage" id="resultMessage" value="<%= resultMessage %>">
</form>
</body>
</html>

