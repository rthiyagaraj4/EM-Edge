<!DOCTYPE html>
<%
/*
------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------
?             	100            		?           	?				?					created 
20/08/2015    	IN056958		 	Karthi L		      								Login Thai. After select order and record order already. In Task list function, system display error message.	
------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.util.*,java.sql.*,eCA.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCA/js/TaskList.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	PatTaskListRepository patTask = (PatTaskListRepository)getObjectFromBean("patTask","eCA.PatTaskListRepository",session);
	LinkedHashMap hash_values = new LinkedHashMap();
	hash_values=patTask.get_hash();
	Connection con = null;
	String currentDate = "";
	String currDate= "";

	String sysdate = "";	
	//SRR20056-SCF-9390-IN037479_RF [IN056958] - Start
	//sysdate = patTask.getSysdateTime();  	
	//sysdate = com.ehis.util.DateUtils.convertDate(sysdate,"DMYHM","en",localeName);
	if(!localeName.equals("en")) // SRR20056-SCF-9390-IN037479_RF [IN056958] - End
		sysdate = com.ehis.util.DateUtils.convertDate(sysdate,"DMYHM",localeName,"en");

try
{			
		con= ConnectionManager.getConnection(request);
		PreparedStatement pstmt =null;
	
		ResultSet rs= null;
		//String sql = "select to_char(to_date(?,'dd/mm/yyyy hh24:mi'),'Month yyyy'),to_char(to_date(?,'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy') from dual "; //  SRR20056-SCF-9390-IN037479_RF [IN056958]
		String sql = "SELECT sm_convert_date_anyformat (SYSDATE,'Month yyyy', ?),sm_convert_date_anyformat(SYSDATE,'dd/mm/yyyy', ?)FROM DUAL"; // SRR20056-SCF-9390-IN037479_RF [IN056958]
		pstmt = con.prepareStatement(sql);
		// SRR20056-SCF-9390-IN037479_RF [IN056958] - Start
		//pstmt.setString(1,sysdate);
		//pstmt.setString(2,sysdate);
		pstmt.setString(1,localeName);
		pstmt.setString(2,localeName);
		// SRR20056-SCF-9390-IN037479_RF [IN056958] - End
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			currentDate = rs.getString(1)==null ? "" :  rs.getString(1);
			currDate = rs.getString(2)==null ? "" :  rs.getString(2);
		}
		if(rs !=null)  rs.close();
		if(pstmt != null)pstmt.close();
%>
<form name ="TaskListTopForm">
<table border="0" cellpadding="3" cellspacing="0" id='tableId' width="250" height="16" bgcolor="#D4E2E5" align="Center" >
<tr>
<td class="label">		
	<label id="systemDate"><%=hash_values.get("c_clickdate")=="" ? currDate :  (String)hash_values.get("c_clickdate")%></label>
</td>
</tr>
<tr>
<td bgcolor="#D4E2E5">	
	<IMG src="../../eCommon/images/previousMonth.jpg" name='buttonPrevDate' OnClick='getDate(this,"<%=localeName%>")'>&nbsp;&nbsp;&nbsp;
	<INPUT TYPE="text" name="currentDate" id="currentDate" style="background: #D4E2E5;border:0px;font-family: Verdana, Arial, Helvetica, sans-serif;font-size: 8pt;font-weight:bold; " value='<%=currentDate%>' size='15' ReadOnly>&nbsp;&nbsp;&nbsp;	
	<IMG src="../../eCommon/images/nextMonth.jpg" name='buttonNextDate' OnClick='getDate(this,"<%=localeName%>")'>&nbsp;
	<INPUT TYPE="hidden"  value='<%=currDate%>' name='currDate'>
</td>
</tr>

</table>
<INPUT TYPE="hidden"  value='<%=request.getQueryString()%>' name='queryString'>
</form>

<%
	/*
		Added by Kishore kumar N, on 13/05/2010 for Incident 21239
	*/
	//currDate = com.ehis.util.DateUtils.convertDate(currDate,"DMY",localeName,"en"); // SRR20056-SCF-9390-IN037479_RF [IN056958]
	/*
		ends here.
	*/
}
catch(Exception ee)
{
	//out.println("Error from TaskListCalenderTop jsp :"+ee.toString()); // SRR20056-SCF-9390-IN037479_RF [IN056958]
	ee.printStackTrace(); // SRR20056-SCF-9390-IN037479_RF [IN056958]
}
finally
{
	if(con != null) ConnectionManager.returnConnection(con);
}
%>
</body>
<script>
var toDate = "<%=sysdate%>";
parent.TaskListCalendarFrameBottom.location.href="../../eCA/jsp/TaskListCalendarBottom.jsp?"+"<%=request.getQueryString()%>"+"&currentDate="+"<%=currDate%>";
</script>
</html>

<%putObjectInBean("patTask",patTask,session);%>

