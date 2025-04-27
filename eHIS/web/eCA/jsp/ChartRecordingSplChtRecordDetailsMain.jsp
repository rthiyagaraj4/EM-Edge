<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String splChartType = request.getParameter("splChartType") == null ? "" : request.getParameter("splChartType");
	String splGrpAppl = "";
	String fileName = "";
	String toolBarFileName = "";
	String rows = "4%,*,5.5%,0%";
	String sql = "select spl_chart_Type_grp_appl_yn from CA_SPL_CHART_TYPE where spl_chart_type = ?";

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet res = null;
	
	//java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	//String locale = (String) p.getProperty("LOCALE");

	try
	{
		con = ConnectionManager.getConnection(request);
		ps = con.prepareStatement(sql);
		ps.setString(1,splChartType);
		res = ps.executeQuery();

		while(res.next())
		{
			splGrpAppl = res.getString("spl_chart_Type_grp_appl_yn") == null ? "N" : res.getString("spl_chart_Type_grp_appl_yn");
		}

		if(res != null) res.close();
		if(ps != null) ps.close();
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

	if(splGrpAppl.equals("N"))
	{
		rows = "0%,*,7%,0%";
		fileName = "../../eCA/jsp/ChartRecordingSplChtDtlEntry.jsp?splChtGrpId='*A'";
		toolBarFileName = "ChartRecordingSplChtDtlBtn.jsp";
	}
	else
	{
		rows = "4%,*,5.5%,0%";
		fileName = "../../eCA/jsp/blank.jsp";
		toolBarFileName = "../../eCA/jsp/blank.jsp";
	}
%>

<%

	String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<html>
	<head>
			<title><fmt:message key="eCA.PastRecords.label" bundle="${ca_labels}"/></title>
			<script language="javascript" src="../../eCA/js/ChartRecording.js"></script>
			<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	</head>
	<frameset rows='<%=rows%>'>
		<frame name='chartRecordingSplGrpFrame' id='chartRecordingSplGrpFrame' src='../../eCA/jsp/ChartRecordingSplChtSplGrp.jsp?<%=request.getQueryString()%>' scrolling='no' noresize frameborder="0"></frame>
		<frame name="chartRecordingEntryFrame" id="chartRecordingEntryFrame" frameborder="0" scrolling="auto" noresize src="<%=fileName%>"></frame>
		<frame name="chartRecordingSplChtBtnFrame" id="chartRecordingSplChtBtnFrame" frameborder="0" scrolling="no" noresize src="<%=toolBarFileName%>"></frame>
		<frame name="blankRecFrame" id="blankRecFrame" frameborder="0" scrolling="no" noresize src="../../eCA/jsp/blank.jsp"></frame>
	</frameset>
</html>

