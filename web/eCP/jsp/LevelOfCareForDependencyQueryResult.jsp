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
*	Created By		:	Sreenivasulu.Y
*	Created On		:	30 Dec 2004

--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@ page import ="java.sql.*,webbeans.eCommon.*, eCP.*,com.ehis.eslp.* " %>

<HTML>
<head>
<%
//This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>	
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonResult.js"></Script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	 

</head>

<BODY class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String classvalue = "";
/*----- Required while Selecting sql and Formatting display------*/
//	String enableGif ="<div align='center'><img align='center' src='../../eCommon/images/enabled.gif'></img></div>" ;
//	String disableGif ="<div align='center'><img src='../../eCommon/images/RRnwd.gif'></img></div>" ;

try{
		
	String level_of_care_code = request.getParameter("level_of_care_code");
	String level_of_care_desc		= request.getParameter("level_of_care_desc");
	String dependency_code		= request.getParameter("dependency_code");
	String long_desc		= request.getParameter("long_desc");

	boolean searched		= request.getParameter( "searched" ) == null? false : true  ;	

	if(level_of_care_code == null || level_of_care_code.equals("null")) level_of_care_code =" "; else level_of_care_code = level_of_care_code.trim();
	if(level_of_care_desc == null || level_of_care_desc.equals("null")) level_of_care_desc =" "; else level_of_care_desc = level_of_care_desc.trim();
	if(dependency_code == null || dependency_code.equals("null")) dependency_code =" "; else dependency_code = dependency_code.trim();
	if(long_desc == null || long_desc.equals("null")) long_desc =" "; else long_desc = long_desc.trim();

	//Common parameters.
	HashMap sqlMap = new HashMap();
	String sql_dependency="select a.level_of_care_code, b.level_of_care_desc, a.dependency_code, c.long_desc  from cp_loc_for_dependency a, am_level_of_care b, cp_dependency c where a.level_of_care_code = b.level_of_care_code and a.dependency_code=c.dependency_code  and upper(a.level_of_care_code) like upper(?) and upper(b.level_of_care_desc) like upper(?) and upper(a.dependency_code) like upper(?) and upper(c.long_desc) like upper(?)";
			
	sqlMap.put( "sqlData",sql_dependency);
	ArrayList displayFields = new ArrayList();
	displayFields.add("level_of_care_code");
	displayFields.add("level_of_care_desc");
	displayFields.add("dependency_code");
	displayFields.add("long_desc");
	
	//The fields are going to be in where condition * shld match with the qry//
	ArrayList chkFields = new ArrayList();

	chkFields.add( level_of_care_code+"%");
	chkFields.add( level_of_care_desc+"%");
	chkFields.add( dependency_code+"%");
	chkFields.add( long_desc+"%");


	// Adding function related array list into the HashMap//
	HashMap funcMap = new HashMap();
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );
	
	//Calling the Result from Common Adaptor as a arraylist.//
	ArrayList result=new ArrayList();
	result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);
    
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

<table cellpadding=0 cellspacing=0 border=1 align=center width='98%'>
<tr>

	<th width="15%" align='center'>Level of Care Code</th>
	<th width="20%" align='center'>Level of Care Description</th>
	<th width="10%" align='center'>Dependency Code</th>
	<th width="20%" align='center'>Dependency Description</th>
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
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
	<%
		}
			out.println(CommonBean.setForm(request ,"../../eCP/jsp/LevelOfCareForDependencyQueryResult.jsp", searched));
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} %>
</body>
</html>  






