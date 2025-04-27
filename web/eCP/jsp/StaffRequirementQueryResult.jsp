<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Sreelatha
*	Created On		:	7 January 2005

--%>
<%-- JSP Page specific attributes start --%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<%@ page import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,webbeans.eCommon.*, eCP.*,eCommon.Common.*,com.ehis.eslp.*,eCommon.XSSRequestWrapper" %>

<HTML>
<head>
<%
//This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>	<script language='javascript' src='../../eCommon/js/messages.js'></script>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonResult.js"></Script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../js/CpMessages.js">
alert("entered");
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  
</head>

<BODY class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String classvalue = "";
/*----- Required while Selecting sql and Formatting display------*/
	//String enableGif ="<div align='center'><img align='center' src='../../eCommon/images/enabled.gif'></img></div>" ;
	//String disableGif ="<div align='center'><img src='../../eCommon/images/RRnwd.gif'></img></div>" ;

try{
		
	String dependency_code= request.getParameter("dependency_code");
	String workplace_code	= request.getParameter("workplace_code");
	String workplace_desc		= request.getParameter("workplace_desc");
	String shift_code		= request.getParameter("shift_code");
	String position_code		= request.getParameter("position_code");
	String position_desc		= request.getParameter("position_desc");
	
	
	
	boolean searched		= request.getParameter( "searched" ) == null? false : true  ;	


	if(dependency_code == null || dependency_code.equals("null")) dependency_code =" "; else dependency_code =dependency_code.trim();
	if(workplace_code == null ||workplace_code.equals("null")) workplace_code =" "; else workplace_code = workplace_code.trim();
	if(workplace_desc	 == null || workplace_desc	.equals("null")) workplace_desc	 =" "; else workplace_desc	 = workplace_desc	.trim();
	if(shift_code == null || shift_code.equals("null")) shift_code=" "; else shift_code = shift_code.trim();
	if(position_code	 == null || position_code	.equals("null")) position_code	 =" "; else position_code	 = position_code	.trim();
	if(position_desc	 == null || position_desc	.equals("null")) position_desc	 =" "; else position_desc	 = position_desc	.trim();
	
	HashMap sqlMap = new HashMap();

	
	/*String sql_terminology="select  a.dependency_code,b.long_desc,a.workplace_code,c.workplace_desc,a.shift_code,d.long_desc  long_desc1  from cp_staff_requirement a,cp_dependency b,rs_workplace c,am_shift d  where a.dependency_code=b.dependency_code and a.workplace_code=c.workplace_code and a.shift_code=d.shift_code and upper(a.dependency_code) like upper(?) and upper(b.long_desc) like upper(?) and upper(a.workplace_code) like upper(?)  and upper(c.workplace_desc) like upper(?)  and upper(a.shift_code) like upper(?)  and upper(d.long_desc) like upper(?)";*/
String sql_terminology="select a.dependency_code,b.long_desc,a.workplace_code,c.workplace_desc, a.shift_code,d.long_desc long_desc1, e.position_desc,e.position_code ,a.wday_hours,a.nwday_hours,a.hday_hours  from cp_staff_requirement a,cp_dependency b,rs_workplace c,am_shift d, am_position e  where a.dependency_code=b.dependency_code  and a.workplace_code=c.workplace_code  and a.shift_code=d.shift_code  and upper(a.dependency_code) like upper(?) and upper(a.workplace_code) like upper(?)  and upper(c.workplace_desc) like upper(?)  and upper(a.shift_code) like upper(?)  and upper(e.position_code) like upper(?)  and upper(e.position_desc) like upper(?) and e.position_code = a.position_code ";

	sqlMap.put( "sqlData",sql_terminology);

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	
	displayFields.add("dependency_code");
	displayFields.add("long_desc");
	displayFields.add("workplace_code");
	displayFields.add("workplace_desc");
	displayFields.add("shift_code");
	displayFields.add("long_desc1");
	displayFields.add("position_code");
	displayFields.add("position_desc");
	displayFields.add("wday_hours");
	displayFields.add("nwday_hours");
	displayFields.add("hday_hours");
	

	
	
	//The fields are going to be in where condition * shld match with the qry//
	ArrayList chkFields = new ArrayList();

	chkFields.add(dependency_code+"%");
		chkFields.add( workplace_code+"%");
	chkFields.add( workplace_desc+"%");
	chkFields.add(shift_code+"%");
		chkFields.add( position_code+"%");
		chkFields.add(position_desc+"%");
	
	
	


	// Adding function related array list into the HashMap//
	HashMap funcMap = new HashMap();
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );
	
	//Calling the Result from Common Adaptor as a arraylist.//
	ArrayList result=new ArrayList();
	result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);
    //int rowCount = 1;
	if((result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){

 %>
 <table cellpadding=0 cellspacing=0 width="98%" align="center">
<tr>
	<td width="80%" class="white">&nbsp;</td>
	<td width="20%" class="white">&nbsp;
<%
	// For display the previous/next link
     out.println(result.get(1));
%>
	</td>
</tr>
</table>

<table cellpadding=0 cellspacing=0 border=1 width='97%'  align=center>
<tr>

	<th  align='left'>Dependency Code</th>
	<th align='left'>Dependency Description</th>
	<th align='left'>Workplace Code</th>
	<th  align='left'>Workplace Description</th>
	<th align='left'>Shift Code</th>
	<th  align='left'>Shift Description</th>
		<th  align='left'>Position Code</th>
		<th  align='left'>Position Description</th>
			<th  align='left'>WDay</th>
		<th  align='left'>NWDay</th>
		<th  align='left'>HDay</th>
</tr>
	<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;

			
			records=(ArrayList) result.get( recCount );
		%>				
		<tr>   
		<%
		for(int colCount=0; colCount<records.size(); colCount++){		
			String str = (String)records.get(colCount)==null?"":(String)records.get(colCount);
			if(str.equals("")){%>
			<td class="<%=classvalue%>">&nbsp;</td>
 		<%} else {
		 %>
				<td class="<%=classvalue%>"><%=str%></td>
		  <%}}//end of for loop
		  %>
</tr>
<%}//L00p for all records%>
</table>
	<%
	out.flush();
	}else{%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA"));history.go(-1);</script>
	<%
		}
			out.println(CommonBean.setForm(request ,"../../eCP/jsp/StaffRequirementQueryResult.jsp", searched));
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} %>

</body>
</html>  

