<!DOCTYPE html>
<%@ page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"> -->

	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link> -->
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eCA/js/ChartRecording.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	Connection con = null;
	try
	{
		String flagString = request.getParameter("flag")==null ? "" : request.getParameter("flag");
		String currDate =  request.getParameter("currdateValue")==null ? "" : request.getParameter("currdateValue");

		con= ConnectionManager.getConnection(request);
			String sql  = "";
		PreparedStatement pstmt =null;
		ResultSet rs= null;
		if(flagString.equals("PrevMonth"))
		sql = "select to_char(add_months(to_date(?,'dd/mm/yyyy'),-1),'Month YYYY'),to_char(add_months(to_date(?,'dd/mm/yyyy'),-1),'dd/mm/yyyy') from dual	";
		else
		sql = "select to_char(add_months(to_date(?,'dd/mm/yyyy'),1),'Month YYYY'),to_char(add_months(to_date(?,'dd/mm/yyyy'),1),'dd/mm/yyyy') from dual ";
		String currentDate = "";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,currDate);
		pstmt.setString(2,currDate);	 
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			currentDate= rs.getString(1)==null ? "" :  rs.getString(1);
			currDate = rs.getString(2)==null ? "" :  rs.getString(2);

		}

		if(rs !=null)  rs.close();
		if(pstmt != null)pstmt.close();
%>
<script>
parent.ChartRecordingDiaryCalendarFrameTop.document.ChartRecordingDiaryTopForm.currentDate.value="<%=currentDate%>";
parent.ChartRecordingDiaryCalendarFrameTop.document.ChartRecordingDiaryTopForm.currDate.value="<%=currDate%>";
var queryString =parent.ChartRecordingDiaryCalendarFrameTop.document.ChartRecordingDiaryTopForm.queryString.value
parent.ChartRecordingDiaryCalendarFrameBottom.location.href="../../eCA/jsp/ChartRecordingDiaryCalendar.jsp?"+queryString+"&currentDate="+"<%=currDate%>";

</script>
<%
}
catch(Exception ee)
{
	//out.println("Error fromChartRecordingDiaryTop jsp :"+ee.toString());//COMMON-ICN-0181
	ee.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(con != null) ConnectionManager.returnConnection(con);
}
%>
</body>
</html>

