<!DOCTYPE html>
<!--Created by Thamizh selvi on 10th July 2017 against ML-MMOH-CRF-719-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*,org.json.simple.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% request.setCharacterEncoding("UTF-8"); %>
<%
    Connection con			= null;
	String cutOffDate		= "";
	Integer incompReqCount	= 0;
	String facilityId		= (String)session.getValue("facility_id");
	String locale			= (String)session.getValue("LOCALE");
	String loginUser		= (String) session.getValue("login_user");
	
try 
{
	con	= ConnectionManager.getConnection(request);
	JSONObject incompReqJsonObj	= new JSONObject();
	incompReqJsonObj  = eMR.MRCommonBean.getCutOffDateIncompReqCount(con,facilityId);

	cutOffDate			= checkForNull((String) incompReqJsonObj.get("cutOffDate"),"");
	incompReqCount		= (Integer) incompReqJsonObj.get("count");
%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
		<script src='../../eMR/js/MRBatchProcess.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src="../../eCommon/js/common.js" language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onload='FocusFirstElement();disableButtons()'>
	<form name="MRBatchProcessForm" id="MRBatchProcessForm" action="" method="" target="messageFrame">
	<br><br>
	<table border="0" width='80%' cellpadding="0" cellspacing="0"  align='center'>
		<tr>
			<td width="100%" class="Border" align='center'>
			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >
				<tr>
					<td align='right' width='40%' class="label"><fmt:message key="Common.Process.label" bundle="${common_labels}"/>&nbsp;</td>
					<td width='50%' class="fields"  >
						 <SELECT name="process_type" id="process_type" disabled>
							 <option value="1" selected><fmt:message key="eMR.AutoCancelIncompReq.label" bundle="${mr_labels}"/></option>
						 </SELECT>
					</td>
					<td colspan ='2'>
				</tr>
				<tr>
					<td align='right' width='40%' class="label">  &nbsp;</td>
					<td width='50%'  >
						
					</td>
					<td colspan ='2'>
				</tr>
				<tr>
					<td align='right' width='40%' class="label"><fmt:message key="eOP.CutoffDate.label" bundle="${op_labels}"/></td>
					<td align='left' width='50%' class="fields"><%=cutOffDate%></td>
					<td colspan ='2'>
				</tr>
				<tr>
					<td align='right' width='40%' class="label">  &nbsp;</td>
					<td width='50%'>
					</td>
					<td colspan ='2'>
				</tr>
				<tr>
					<td align='right' width='40%' class="label"><fmt:message key="eMR.TotalIncompReqForAutoCancel.label" bundle="${mr_labels}"/></td>
					<td align='left' width='50%' class="fields"><%=incompReqCount%></td>
					<td colspan ='2'>
				</tr>
				<tr>
					<td align='right' width='40%' class="label">  &nbsp;</td>
					<td width='50%'  >
					</td>
					<td colspan ='2'>	
				</tr>
				<tr>
					<td align='right' width='40%' class="label">  &nbsp;</td>
					<td width='50%'  >
					</td>
					<td colspan ='2'>	
				</tr>
				<tr>
					<td align='right' width='40%' class="label">  &nbsp;</td>
					<td class='fields' width ='50%'><input type='button' class='button' name='GenerateReport' id='GenerateReport' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Generate.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.report.label","common_labels")%>' onclick='generateReport()'>

					<input type='button' class='button' name='DispIncompReq' id='DispIncompReq' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.incomplete.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Request.label","common_labels")+"s"%>' onclick='getResult()'>
				</tr>
				<tr>
					<td align='right' width='30%' class="label">  &nbsp;</td>
					<td width='50%'  >
					</td>
					<td colspan ='2'>	
				</tr>
			</table>
			</td>
		</tr>
	</table>
	<input type='hidden' name='p_report_id' id='p_report_id' value="MRINCREQ">
	<input type='hidden' name='p_module_id' id='p_module_id' value="MR">
	<input type='hidden' name='call_function' id='call_function' value="AUTO_CANCEL_BATCH_PROCESS">
	<input type='hidden' name='p_language_id' id='p_language_id' value="<%=locale%>">
	<input type='hidden' name='p_cut_of_date' id='p_cut_of_date' value="<%=cutOffDate%>">
	<input type='hidden' name='incompReqCount' id='incompReqCount' value="<%=incompReqCount%>">
	<input type='hidden' name='p_user_name' id='p_user_name' value="<%=loginUser%>">
	<input type='hidden' name='p_facility_id' id='p_facility_id' value="<%=facilityId%>"> 
</form>
</body>
</html>
<%
} catch(Exception e) {  
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>
<%!
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

