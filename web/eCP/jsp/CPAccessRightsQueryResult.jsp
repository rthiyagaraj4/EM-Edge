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
*	Created By		:	Hema Malini B
*	Created On		:	24 Jan 2005

--%>
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
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language='javascript' src='../../eCommon/js/messages.js'></script>
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
try
	{
	String classvalue = "";
	/*----- Required while Selecting sql and Formatting display------*/
	String enableGif ="<div align='center'><img align='center' src='../../eCommon/images/enabled.gif'></img></div>" ;
	String disableGif ="<div align='center'><img src='../../eCommon/images/RRnwd.gif'></img></div>" ;

	String practitioner_type = request.getParameter("pract_type") == null ?"":request.getParameter("pract_type");
	String practitioner_id =  			request.getParameter("practitioner_id") == null ?"":request.getParameter("practitioner_id");
	String practitioner_name = request.getParameter("practitioner_name")== null ?"":request.getParameter("practitioner_name");

	boolean searched		= request.getParameter( "searched" ) == null? false : true  ;
	
	HashMap sqlMap = new HashMap();

	String sql_access="select b.practitioner_name practitioner_name,c.DESC_USERDEF pract_type,a.practitioner_id practitioner_id,assess_yn,generate_cp_yn,finalize_cp_yn,revise_cp_yn,evaluate_cp_yn from cp_access_rights a,am_practitioner b ,am_pract_type c where upper(c.pract_type) like upper(?) and upper(a.practitioner_id) like upper(?) and upper(practitioner_name) like upper(?) and a.practitioner_id=b.practitioner_id and b.pract_type=c.pract_type";


	sqlMap.put( "sqlData",sql_access);
	
	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	
	displayFields.add("pract_type");
	displayFields.add("practitioner_id");
	displayFields.add("practitioner_name");
	displayFields.add("assess_yn");
	displayFields.add("generate_cp_yn");
	displayFields.add("finalize_cp_yn");
	displayFields.add("revise_cp_yn");
	displayFields.add("evaluate_cp_yn");
	
	//The fields are going to be in where condition * shld match with the qry//
	ArrayList chkFields = new ArrayList();

	chkFields.add(practitioner_type+"%");
	chkFields.add(practitioner_id+"%");
	chkFields.add(practitioner_name+"%");
	
	
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

<table cellpadding=0 cellspacing=0 border=1 width='97%'  align=center>
<tr>

	<th rowspan='2' width="20%"><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></th>
	<th rowspan='2' width="10%"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></th>
	<th rowspan='2'width="20%"><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></th>
	<th rowspan='2'width="10%">Assess</th>
	<th rowspan='2'width="10%">Generate</th>
	<th rowspan='2'width="10%">Finalize</th>
	<th rowspan='2'width="10%"><fmt:message key="Common.revise.label" bundle="${common_labels}"/></th>
	<th rowspan='2'width="10%">Evaluate</th>
</tr><tr></tr>
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
			
			if(colCount == 3)
			str=str.equals("Y")?enableGif:disableGif;
			if(colCount == 4)
			str=str.equals("Y")?enableGif:disableGif;
			if(colCount == 5)
			str=str.equals("Y")?enableGif:disableGif;
			if(colCount == 6)
			str=str.equals("Y")?enableGif:disableGif;
			if(colCount == 7)
			str=str.equals("Y")?enableGif:disableGif;
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
			out.println(CommonBean.setForm(request ,"../../eCP/jsp/CPAccessRightsQueryResult.jsp", searched));
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} %>

</body>
</html> 	   

