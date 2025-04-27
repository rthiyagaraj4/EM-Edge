<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- Modified 9/16/2005 -->
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%-- Mandatory declarations end --%>
<%@page   import="java.sql.*, java.io.*,java.util.*,java.text.*, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"%>

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
    <link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css">
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>

	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>

	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>

	<script language="JavaScript" src="../js/NewProcedure.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onload='' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
		
	String mode	   = request.getParameter( "mode" ) ;
	//String proc_code = request.getParameter("note_type")==null?"":request.getParameter("note_type") ;
	String term_set = request.getParameter("term_set")==null?"":request.getParameter("term_set") ;
	String term_code_associated = request.getParameter("term_code_associated")==null?"":request.getParameter("term_code_associated") ;
	String termdetails = request.getParameter("termdetails")==null?"":request.getParameter("termdetails") ;
	//String level1 = request.getParameter("level")==null?"":request.getParameter("level") ;

	String index = request.getParameter("index")==null?"":request.getParameter("index") ;

//out.println("=termdetails=="+termdetails+"====index=="+index+"=====");		
	//String classvalue="";String checked = "";int db_count=0;
	String temp_term_code="";
	//String tag = "",tag1="";
	//out.println("=request.getQueryString()=="+request.getQueryString()+"=====");	
	//String temp_db_chk = "";
	SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy H:mm" ) ;
	String	currentdate			= dateFormat.format(new java.util.Date()) ;
	String	onset_date			= currentdate;
	//System.out.println("=term_code_associated============"+term_code_associated+"====");
	
	StringTokenizer stoken=new StringTokenizer(termdetails,"~");
	String hrs = "",mins="",end_date="";
	int cnt=stoken.countTokens();
	//out.println("=cnt=="+cnt+"=======");		

	if(stoken.hasMoreTokens()){
	onset_date = stoken.nextToken();
	hrs = stoken.nextToken();
	mins = stoken.nextToken();
	end_date = stoken.nextToken();
	}
	
	if(onset_date.equals(" "))
		onset_date = "";
	if(end_date.equals(" "))
		end_date = "";

	int i=0;

	//StringBuffer sql1= new StringBuffer();
	Connection con      = null;
	//PreparedStatement pstmt	= null;
	//ResultSet rset		= null;
try
{
	con = ConnectionManager.getConnection(request);

%>

<form name='multi_procedure' id='multi_procedure' method='post' target='messageFrame' action=''>
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center id='term_associated'>

<tr>
	<td class='label' align='right' width=''>Start Date</td>
	<td class='label' align='' width=''>
<input type='text' name='onset_date<%=i%>' id='onset_date<%=i%>' value='<%=onset_date.trim()%>' size="14" maxlength="16" onBlur="checkValidDateTime(this);calEndDate('<%=i%>')" onKeyPress='return AllowDateFormat()'><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('onset_date<%=i%>',null,'hh:mm');" onblur='onset_date<%=i%>.focus()' style='cursor:pointer'></td>
</tr>	
<tr>
	<td class='label' align='right' width='' >Duration</td>
	<td class='label' align='' width=''><input type="text" name="hrs<%=i%>" id="hrs<%=i%>"  maxlength="2" size="2" value='<%=hrs.trim()%>' onBlur="calEndDate('<%=i%>')" onKeyPress='return OrAllowPositiveNumber()' ><font size="1">Hrs.</font><input type="text" name="mins<%=i%>" id="mins<%=i%>"  maxlength="2" value='<%=mins.trim()%>' size="2" onKeyPress='return OrAllowPositiveNumber()'  onBlur="calEndDate('<%=i%>')"   tabIndex='5' ><font size="1">Mins.</font></td>
</tr>	
<tr>
	<td class='label' align='right' width=''>End Date</td>
	<td class='label' align='' width='70%'><input type='text' name='end_date<%=i%>' id='end_date<%=i%>' value='<%=end_date.trim()%>' size="14" maxlength="16" onBlur="checkValidDateTime(this);CalculateDuration('<%=i%>')" onKeyPress='return AllowDateFormat()'><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('end_date<%=i%>',null,'hh:mm');" onblur='end_date<%=i%>.focus()' style='cursor:pointer'>
	</td>
</tr>	

		<input type="hidden" name="term_code<%=i%>" id="term_code<%=i%>" value="">
		<input type="hidden" name="code_level<%=i%>" id="code_level<%=i%>" value="">
		
			<!--<script>alert(document.forms[0].all.term_codeS<%=i%>.value)</script> -->

	</table>

<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="totalRecords" id="totalRecords" value="<%=cnt%>">
<input type="hidden" name="term_set_id" id="term_set_id" value="<%=term_set%>">
<input type="hidden" name="temp_term_code" id="temp_term_code" value="<%=temp_term_code%>">
<input type="hidden" name="term_code_associated" id="term_code_associated" value="<%=term_code_associated%>">
<input type="hidden" name = "currentdate" value ="<%=currentdate%>">
<input type="hidden" name = "index" value ="<%=index%>">

<%

} 
catch(Exception sqle)
{
	//out.println(sqle.getMessage());//COMMON-ICN-0181
	sqle.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}

%>

</form>

</body>
</html>

