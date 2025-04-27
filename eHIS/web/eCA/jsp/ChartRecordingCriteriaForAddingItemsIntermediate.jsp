<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
			
		<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->

<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script language='javascript' src='../js/ChartRecording.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<form name='chartRecordingCriteriaIntermediateForm' id='chartRecordingCriteriaIntermediateForm'>
<%
	PreparedStatement psSql = null;
	ResultSet rsSql = null;
	Connection con = null;
	try
	{
	con = ConnectionManager.getConnection(request);
	int count=0;
	String facilityId =session.getValue("facility_id")==null ? "" :(String)	session.getValue("facility_id") ;
	String chartId = request.getParameter("chartId")==null ? "" :request.getParameter("chartId") ;
	String encounterId = request.getParameter("encounterId")==null ? "" :request.getParameter("encounterId");
	String sqlCheck = "select count(*) from CA_ENCNTR_CHART_DRAFT where ENCOUNTER_ID=? and CHART_ID= ? and facility_id = ? ";
	psSql = con.prepareStatement(sqlCheck);
	psSql.setString(1,encounterId);
	psSql.setString(2,chartId);
	psSql.setString(3,facilityId);
	rsSql = psSql.executeQuery();
	rsSql.next();	
	count = rsSql.getInt(1);
	
	if(count==0)
	{
		
	%>
<script>
	parent.chartRecordingTopFrame.document.chartRecordingCriteriaForm.target='blankFrame'
parent.chartRecordingTopFrame.document.chartRecordingCriteriaForm.action='../../servlet/eCA.ChartRecordingCriteriaServlet'
parent.chartRecordingTopFrame.document.chartRecordingCriteriaForm.method='post'
parent.chartRecordingTopFrame.document.chartRecordingCriteriaForm.flagMsg.value='msg'
parent.chartRecordingBottomFrame.apply();
</script>
	<%
	}
else
{
	out.println("<script>window.close()</script>");
}
%>

</form>
</body>
<%
	}
catch(Exception ee)
{
	//out.println("Exception from ChartRecordingCriteriaForAddingItemsIntermediate.jsp : "+ee.toString());//common-icn-0181
       ee.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(rsSql != null)rsSql.close();
	if(psSql != null)psSql.close();
	if(con != null) ConnectionManager.returnConnection(con);
}
%>
</html>

