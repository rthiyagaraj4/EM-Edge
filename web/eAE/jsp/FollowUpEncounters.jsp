<!DOCTYPE html>
<!--Created by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657-->
<%@ page import="java.sql.*,java.text.*, java.util.*,java.io.*, webbeans.eCommon.*,org.json.simple.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String pat_id		= request.getParameter("pat_id");
	String facilityId	= (String)session.getAttribute("facility_id");
	Connection con	= null;
%>

<script>
function closeRemarks()
{
	window.returnValue = "";
	window.close();
}

function getEncounterId(enc_id)
{
	window.returnValue = enc_id;
	window.close();
}
</script>

<title><fmt:message key="Common.followup.label" bundle="${common_labels}"/> <fmt:message key="Common.encounter.label" bundle="${common_labels}"/>s</title>

<style>
	
.inner_table_site 
{ 
	width:100%; 
	height: 210px;
	overflow-y: auto;
}

</style>

</head>
<%	try
	{
		con	= ConnectionManager.getConnection(request);
%>

<body>
<div class="inner_table_site">
<table  border="1" width="100%" cellspacing='0' cellpadding='0'>
	<tr>
		<th style="width:30%" class="columnheader"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
		<th style="width:35%" class="columnheader"><fmt:message key="Common.encounterdatetime.label" bundle="${common_labels}"/></th>
		<th style="width:35%" class="columnheader"><fmt:message key="Common.followup.label" bundle="${common_labels}"/> <fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/></th>
	</tr>
	<tr></tr>	
		<%
		JSONArray FollowUpJsonArr	= new JSONArray();
		FollowUpJsonArr  = eAE.AECommonBean.getFollowUpDetails(con,pat_id,facilityId);

		for(int i = 0 ; i < FollowUpJsonArr.size() ; i++) 
		{
		JSONObject json			= (JSONObject)FollowUpJsonArr.get(i);
		String encounter_id		= (String) json.get("encounter_id");
		String enc_date_time	= (String) json.get("enc_date_time");
		String recall_date		= (String) json.get("recall_date");
		%>
		<tr>
			<td nowrap style="width:30%" height='20' class='field' align='center'><a href = "javascript:getEncounterId('<%=encounter_id%>')"><%=encounter_id%>&nbsp;</td>
			<td nowrap style="width:35%" height='20' class='field' align='center'><%=enc_date_time%>&nbsp;</td>
			<td nowrap style="width:35%" height='20' class='field' align='center'><%=recall_date%>&nbsp;</td>
		</tr>	
		<%}%>
</table>
</div>
<br>
<center><input type='Button' class='Button' name='Close' id='Close' value='  Close  ' onclick='closeRemarks()'></center>
<%}catch(Exception e) 
	{ 
		e.printStackTrace();
	}
	finally
	{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
	%>
</body>
</html>

