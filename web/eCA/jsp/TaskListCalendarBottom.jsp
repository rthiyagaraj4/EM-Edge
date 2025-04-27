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
<%@ page import="java.util.*,java.sql.*,eCA.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
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
<form name='TaskListCalendarForm' id='TaskListCalendarForm'>
<table width='168' height='166' cellspacing='0' align='center' cellpadding='5.6px' border="1"  bordercolor='#83A9B2'>
<%	
	PatTaskListRepository patTask = (PatTaskListRepository)getObjectFromBean("patTask","eCA.PatTaskListRepository",session);
	LinkedHashMap hash_values = new LinkedHashMap();
	hash_values=patTask.get_hash();

	Connection con = null;
	ResultSet rs= null;
	PreparedStatement pstmt = null;
	StringBuffer sql = new StringBuffer();
	StringTokenizer tokenPipe = null;	
	String day = "";

	String sysdate =  request.getParameter("currentDate")==null ? "" :  request.getParameter("currentDate");	
	String date =  hash_values.get("c_clickdate")=="" ? sysdate :  (String)hash_values.get("c_clickdate");	
	String l_locale = (String)session.getAttribute("LOCALE"); //SRR20056-SCF-9390-IN037479_RF [IN056958]
	int delim = date.indexOf("/");	
	if (delim == 1)
		day = date.substring(0,1);	
	else if (delim == 2)
		day = date.substring(0,2);

	if(day.length()==1)
		day = "0"+day;
		
	String prevDate = "";
	String date_vals="";
	String date_mon="";
	String classValue="QRYEVEN";
	String tempString="";		
	String tempString1="";		
	String dateset="";
	
	try
	{
		if(!l_locale.equals("en")) //SRR20056-SCF-9390-IN037479_RF [IN056958]
			sysdate = com.ehis.util.DateUtils.convertDate(sysdate,"DMY",l_locale,"en"); //SRR20056-SCF-9390-IN037479_RF [IN056958]
		
		con= ConnectionManager.getConnection(request);
		sql.append("select CA_Task_list_Cal(to_char(to_date(?,'dd/mm/yyyy'),'mm/yyyy')),to_char(to_date(?,'dd/mm/yyyy'),'mm/yyyy') month from dual");
		
		pstmt= con.prepareStatement(sql.toString());	
		pstmt.setString(1,sysdate);
		pstmt.setString(2,sysdate);
		
		rs= pstmt.executeQuery();
		prevDate =date;
		int count =1;
		while(rs.next())
		{
			date_vals=rs.getString(1);
			date_mon=rs.getString(2);
		}
		out.println("<tr nowrap height='22' VALIGN='bottom-center'>");		
		out.println("<td  nowrap>Su</td>");
		out.println("<td  nowrap>M</td>");
		out.println("<td  nowrap>Tu</td>");
		out.println("<td  nowrap>W</td>");
		out.println("<td  nowrap>Th</td>");
		out.println("<td  nowrap>F</td>");
		out.println("<td  nowrap>S</td>");
		
		out.println("</tr>");
		out.println("<tr>");
		
		tokenPipe = new StringTokenizer(date_vals,"|");
		while(tokenPipe.hasMoreTokens())
		{			
			tempString = tokenPipe.nextToken();			
			if(tempString.equals("0")) 
						tempString="";
			if(!tempString.equals("0")){
				if (tempString.length()==1)
						tempString1 = "0"+tempString;
				else 
						tempString1 = tempString;
					dateset=tempString+"/"+date_mon;
				
			}

			%>
			<td style='<%if(day.equals(tempString1)){%>fontWeight:BOLD;background:#9E9E9E;font-family: Verdana, Arial, Helvetica, sans-serif;font-size: 10pt;COLOR:#000000;<%}else{%>fontWeight:normal;cursor:pointer;font-family: Verdana, Arial, Helvetica, sans-serif;font-size: 8pt;COLOR:#000000;<%}%>' class="<%=classValue%>" id="d_<%=tempString%>" onclick='setDatecal("<%=tempString%>","<%=dateset%>")' nowrap><%=tempString.equals("")?"&nbsp;":tempString%></td>
			<%
			if(count==7)
					{
						out.println("</tr>");	
						out.println("<tr>");
						count=0;
					}
		count++;
		}
		if(rs !=null)  rs.close();
		if(pstmt != null)pstmt.close();	

}
catch(Exception ee)
{
	//out.println("Error fromTaskListCalendarBottom jsp :"+ee.toString());//COMMON-ICN-0181
	ee.printStackTrace();
}
finally
{
	if(con != null) ConnectionManager.returnConnection(con);
}
%>
</table>
<input type='hidden' name='clickdate' id='clickdate' value='<%=date%>'>
<input type='hidden' name='localeName' id='localeName' value='<%=localeName%>'>
</form>
<%if (hash_values.get("c_clickdate")==""){
	date = com.ehis.util.DateUtils.convertDate(date.trim(),"DMY",localeName,"en"); //SRR20056-SCF-9390-IN037479_RF [IN056958]
%> 
<script>		
	setDatecal1("<%=date.trim()%>");
</script>
<%}%>
</body>
</html>

<%putObjectInBean("patTask",patTask,session);%>

