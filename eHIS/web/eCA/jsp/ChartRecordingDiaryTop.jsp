<!DOCTYPE html>
<%@ page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css">
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link> -->

	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eCA/js/ChartRecording.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='ChartRecordingDiaryTopForm' id='ChartRecordingDiaryTopForm'>
<%
Connection con = null;
String currentDate = "";
String currDate= "";
String toDate=request.getParameter("toDate")==null ? "" :  request.getParameter("toDate");
String detailDate=request.getParameter("detailDate")==null ? "" :  request.getParameter("detailDate");
try
{
		 con= ConnectionManager.getConnection(request);
		PreparedStatement pstmt =null;
	
		ResultSet rs= null;
		//String sql = "select to_char(to_date('"+detailDate+"','dd/mm/yyyy'),'Month yyyy'),to_char(to_date('"+detailDate+"','dd/mm/yyyy'),'dd/mm/yyyy') from dual ";//common-icn-0180
		String sql = "select to_char(to_date(?,'dd/mm/yyyy'),'Month yyyy'),to_char(to_date(?,'dd/mm/yyyy'),'dd/mm/yyyy') from dual ";//common-icn-0180
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, detailDate);//common-icn-0180
		pstmt.setString(2, detailDate);//common-icn-0180
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			currentDate = rs.getString(1)==null ? "" :  rs.getString(1);
			currDate = rs.getString(2)==null ? "" :  rs.getString(2);
		}
		if(rs !=null)  rs.close();
		if(pstmt != null)pstmt.close();

%>
<form name ="ChartRecordingDairyTopForm">
<table border="0" cellpadding="3" cellspacing="0" id='tableId' width="100%" valign='bottom'>
<tr>
<td align='center'>
	<!-- <INPUT TYPE="button" class='button' value='<--' name='buttonPrevDate' id='buttonPrevDate' OnClick='getDate(this)'> --><img name ='buttonPrevDate' src='../../eCommon/images/goback.gif' OnClick='getDate(this)'>&nbsp;
	 <INPUT TYPE="text" name="currentDate" id="currentDate" value='<%=currentDate%>' ReadOnly size='13' >&nbsp;
	<!-- <INPUT TYPE="button" class='button' value='->' name='buttonNextDate' OnClick='getDate(this)'> --><img name = 'buttonNextDate' src='../../eCommon/images/tri.gif' OnClick='getDate(this)'>
	
	<INPUT TYPE="hidden"  value='<%=currDate%>' name='currDate'>
</td>
</tr>
<tr>
<td align='center'>
	&nbsp;
</td>
</tr>
</table>
<INPUT TYPE="hidden"  value='<%=request.getQueryString()%>' name='queryString'>
</form>

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
<script>
var toDate = "<%=toDate%>"

if(toDate == "")
{
	document.ChartRecordingDiaryTopForm.buttonNextDate.disabled=true
}
else
{
	var dateArray = "<%=toDate%>".split(" ");
	var currDay = "<%=currDate%>".split("/");
	var toDateArray = dateArray[0].split("/");
	if(toDateArray[2] == currDay[2])
	{
		if(toDateArray[1] == currDay[1])
		{
				document.ChartRecordingDiaryTopForm.buttonNextDate.disabled=true			
		}
	}
}
parent.ChartRecordingDiaryCalendarFrameBottom.location.href="../../eCA/jsp/ChartRecordingDiaryCalendar.jsp?"+"<%=request.getQueryString()%>"+"&currentDate="+"<%=currDate%>";
</script>
</html>

