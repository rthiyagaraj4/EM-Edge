<!DOCTYPE html>
<!--Created by Ashwini on 01-Jul-2021 for AAKH-CRF-0125.1-->
<%@ page import="java.sql.*,java.text.*, java.util.*,java.io.*, webbeans.eCommon.*,webbeans.op.CurrencyFormat,blopin.*,org.json.simple.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<title><fmt:message key="eOP.VisitsNotAutoClosed.label" bundle="${op_labels}"/></title>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	<script>
	function closeListWindow()
	{	
		window.close();	
	}
	</script>

	<style>
	.container {
		width:100%;
	}

	.inner_table_site { 
		width:100%; 
		height: 400px;
		overflow-y: scroll;
	}
	</style>
</head>

<body>
<%
Connection con = null;
String facility_id = "";
String locale = "";
String bl_install_yn = ""; 
String bl_interfaced_yn = "";
String encounter_id = "";
String visit_adm_date_time = "";
String patient_details = "";
String national_id_no = "";
String mr_mds_remarks = "";

try
{
	con = ConnectionManager.getConnection(request);
	facility_id = (String)session.getValue("facility_id");
	locale = (String)session.getAttribute("LOCALE");
	bl_install_yn = checkForNull(request.getParameter("bl_install_yn"));
	bl_interfaced_yn = checkForNull(request.getParameter("bl_interfaced_yn"));
%>

<div class="container">
	<table  border="1" width="100%" cellpadding='0' style='border-spacing:0px;'>
		<tr>
			<th class='columnheader' width="12%" nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>

			<th class='columnheader' width="12%" nowrap><fmt:message key="Common.Visit.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/></th>

			<th class='columnheader' width="30%" nowrap><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></th>

			<th class='columnheader' width="15%" nowrap><fmt:message key="Common.National.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.identification.label" bundle="${common_labels}"/></th>

			<th class='columnheader'width="35%" nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
		</tr>
	</table>
<div class="inner_table_site">
	<table  border="1" width="100%" cellpadding='0' style='border-spacing:0px;'>
		<%

		JSONArray VstLstJsonArr = new JSONArray();
		VstLstJsonArr  = eOP.OPCommonBean.getListVisitsNotAutoClosed(con,bl_install_yn,bl_interfaced_yn,facility_id,locale);

		for(int i = 0 ; i < VstLstJsonArr.size() ; i++) 
		{
			JSONObject json	= (JSONObject)VstLstJsonArr.get(i);
			encounter_id = (String) json.get("encounter_id");
			visit_adm_date_time = (String) json.get("visit_adm_date_time");
			visit_adm_date_time = DateUtils.convertDate(visit_adm_date_time,"DMYHM","en",locale);
			patient_details = (String) json.get("patient_details");
			national_id_no = (String) json.get("national_id_no");
			mr_mds_remarks = (String) json.get("mr_mds_remarks");

			if(!mr_mds_remarks.equals("Y"))
			{
		%>
			<tr>
			<td class='fields' width="12%" nowrap><%=encounter_id%>&nbsp;</td>
			<td class='fields' width="12%" nowrap><%=visit_adm_date_time%>&nbsp;</td>
			<td class='fields' width="30%" style='word-wrap:break-word;width:320px;'><%=patient_details%>&nbsp;</td>
			<td class='fields' width="15%" nowrap><%=national_id_no%>&nbsp;</td>
			<td class='fields' width="30%">
			<font color='RED'><b><fmt:message key="eMR.MDS.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.CriteriaNotMet.label" bundle="${common_labels}"/></b></font>
				<jsp:include page="../../eOP/jsp/ListVisitsMDSCompliance.jsp" ><jsp:param name="flush" value="true" />
				<jsp:param name="mr_mds_recorded" value="<%=mr_mds_remarks%>"/>
				</jsp:include>
			</td>
			</tr>
		<%
			}
		}
		%>
	</table>
</div>
</div>
<br>
	<center><input type=button value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' class='button' onclick='closeListWindow()'></center>

</form>
</body>
</html>

<%
}catch(Exception e){
	e.printStackTrace();
}finally{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

<%!
	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

