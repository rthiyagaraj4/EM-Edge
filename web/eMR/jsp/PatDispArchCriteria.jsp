<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.* ,javax.servlet.*,javax.servlet.http.*,webbeans.eCommon.*,org.json.simple.parser.JSONParser,org.json.simple.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
		String locale           = (String) session.getAttribute("LOCALE");
%>
<html>
<head>
    <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/dchk.js' language='javascript'></script>

	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
	<script language='javascript' src='../js/PatDispArch.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="frmPatDispArchApprovalCriteria" id="frmPatDispArchApprovalCriteria" method="post" action="../../eMR/jsp/PatDispArchResults.jsp" target="resultsFrame">
<center>
<%
Statement stmt = null;
Connection con = null;
ResultSet  rs  = null;


try	{
	con = ConnectionManager.getConnection(request);
	JSONArray batchIdJsonArr	= new JSONArray();
	batchIdJsonArr  = eMR.MRPatDisposalArchivalBean.getBatchIds(con);
	



%>
	<table border="0" cellpadding="3" cellspacing="3" width="100%" align='center'>
		<tr>
			<td class="label" width="10%">&nbsp;</td>
			<td class="label" width="3%"><fmt:message key="Common.BatchNo.label" bundle="${common_labels}"/></td>
			<td width="15%" class="fields" >
				<select name="batchId" id="batchId" onchange="callSearch(this);">
					<option value="">--------------<fmt:message key="Common.Select.label" bundle="${common_labels}"/>--------------</option>
					<%for(int i = 0 ; i < batchIdJsonArr.size() ; i++) {
					JSONObject batchIdJson		= (JSONObject)batchIdJsonArr.get(i);
					String batchId		= (String) batchIdJson.get("batchId");
					%>
					<option value="<%=batchId%>"><%=batchId%></option>
					<% } %>
				</select>
				<img src='../../eCommon/images/mandatory.gif' align='center'></img>
			</td>
	   </tr>
		<tr>
			<td class="label" width="10%">&nbsp;</td>
			<td class="label" width="5%"><fmt:message key="eMR.ApprovalDisposalNo.label" bundle="${mr_labels}"/></td>
			<td width="15%" class="fields" >
				<input type=text name="approval_disp_no" id="approval_disp_no" size='40' maxlength="40"  />
			<img src='../../eCommon/images/mandatory.gif' align='center'></img>
			</td>
	   </tr>
		<tr>
			<td class="label" width="10%">&nbsp;</td>
			<td class="label" width="3%"><fmt:message key="eMR.ApprovalDate.label" bundle="${mr_labels}"/></td>
			<td width="15%" class="fields" >
				<input type="text" id='approval_date' name="approval_date" id="approval_date" maxlength=16 size=16 onblur="chkDateVal(this);" value =""><img src="../../eCommon/images/CommonCalendar.gif"  onClick="document.forms[0].approval_date.focus();return showCalendar('approval_date',null,'hh:mm');" ><img src='../../eCommon/images/mandatory.gif' align='center'></img>
			</td>
	   </tr>
	</table>
		
</form>
</center>
</body>
</html>

<%

	} catch(Exception e) {
		//out.println(e.getMessage());
		e.printStackTrace();
	} finally {
		ConnectionManager.returnConnection(con,request);
	}
%>

<%!	
	
	public static String checkForNull(String inputString, String defaultValue)	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

