<!DOCTYPE html>
<%
/*
------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------
?             	100            		?           	?				?					created 
20/08/2015    	IN056958		 	Karthi L		      								Login Thai. After select order and record order already. In Task list function, system display error message.	
18/11/2015		IN071765			Nijitha S		18/11/2020      Ramesh G					Calendar (DateTime Picker) in task list shows incorrect year format with error.
------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>	
	<%
		request.setCharacterEncoding("UTF-8");
		String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eCA/js/TaskList.js"></script>
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
		String locale = (String)session.getAttribute("LOCALE"); //SRR20056-SCF-9390-IN037479_RF [IN056958]
		currDate = com.ehis.util.DateUtils.convertDate(currDate,"DMY",locale,"en");  //SRR20056-SCF-9390-IN037479_RF [IN056958]
		
		con= ConnectionManager.getConnection(request);
			String sql  = "";
		PreparedStatement pstmt =null;
		ResultSet rs= null;
		if(flagString.equals("PrevMonth"))//IN071765 Starts
		//sql = "select to_char(add_months(to_date(?,'dd/mm/yyyy'),-1),'Month YYYY'),to_char(add_months(to_date(?,'dd/mm/yyyy'),-1),'dd/mm/yyyy') from dual	";
		sql = "select sm_convert_date_anyformat(add_months(to_date(?,'dd/mm/yyyy'),-1),'Month YYYY',?),sm_convert_date_anyformat(add_months(to_date(?,'dd/mm/yyyy'),-1),'dd/mm/yyyy',?) from dual	";
		else
		//sql = "select to_char(add_months(to_date(?,'dd/mm/yyyy'),1),'Month YYYY'),to_char(add_months(to_date(?,'dd/mm/yyyy'),1),'dd/mm/yyyy') from dual ";
		sql = "select sm_convert_date_anyformat(add_months(to_date(?,'dd/mm/yyyy'),1),'Month yyyy',?) ,sm_convert_date_anyformat(add_months(to_date(?,'dd/mm/yyyy'),1),'dd/mm/yyyy',?) from dual ";
		//IN071765 Ends
		String currentDate = "";
		pstmt = con.prepareStatement(sql);
		//IN071765 Starts
		//pstmt.setString(1,currDate);
		//pstmt.setString(2,currDate);
		pstmt.setString(1,currDate);
		pstmt.setString(2,locale);
		pstmt.setString(3,currDate);	
		pstmt.setString(4,locale);
		//IN071765 Ends
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
parent.TaskListCalendarFrameTop.document.TaskListTopForm.currentDate.value='<%=currentDate%>';
parent.TaskListCalendarFrameTop.document.TaskListTopForm.currDate.value="<%=currDate%>";
parent.TaskListCalendarFrameTop.document.getElementById("systemDate").innerText="<%=currDate%>";//Added for IN071765
var queryString =parent.TaskListCalendarFrameTop.document.TaskListTopForm.queryString.value	
//parent.TaskListCalendarFrameBottom.location.href='../../eCA/jsp/TaskListCalendarBottom.jsp?'+queryString+'&currentDate='+'<%=com.ehis.util.DateUtils.convertDate(currDate,"DMY",localeName,"en")%>';//Commented for IN071765
parent.TaskListCalendarFrameBottom.location.href='../../eCA/jsp/TaskListCalendarBottom.jsp?'+queryString+'&currentDate='+'<%=currDate%>';//Added for IN071765
</script>
<%
}
catch(Exception ee)
{
	//out.println("Error from TaskListCalendarIntermediate jsp :"+ee.toString());//COMMON-ICN-0181
          ee.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(con != null) ConnectionManager.returnConnection(con);
}
%>
</body>
</html>

