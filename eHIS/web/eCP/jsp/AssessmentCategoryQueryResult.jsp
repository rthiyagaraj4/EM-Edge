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
*	Created On		:	24 Dec 2004

--%>
<%-- JSP Page specific attributes start --%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*, eCP.*,eCommon.Common.*,com.ehis.eslp.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
	 //This file is saved on 18/10/2005.
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/CommonResult.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<script>
	function Modify(obj,long_desc,short_desc,enable_temp){
		var assess_catg_code	= obj.cells[0].innerText;
		var long_desc	 			=long_desc;
		var short_desc			= short_desc;
		var eff_status				= enable_temp;
document.location.href="../../eCP/jsp/AssessmentCategoryAddModify.jsp?mode=2&assess_catg_code="+assess_catg_code+"&long_desc="+escape(long_desc)+"&short_desc="+ escape(short_desc)+"&eff_status="+eff_status;
}
</script>

<BODY class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
	String classvalue = "";
/*----- Required while Selecting sql and Formatting display------*/
	String enableGif ="<div align='center'><img align='center' src='../../eCommon/images/enabled.gif'></img></div>" ;
	String disableGif ="<div align='center'><img src='../../eCommon/images/RRnwd.gif'></img></div>" ;
try{
		
			String assess_catg_code = request.getParameter("assess_catg_code")== null ? "":request.getParameter("assess_catg_code");
			String short_desc = request.getParameter("short_desc")== null ? "":request.getParameter("short_desc");
			String Enabled = request.getParameter("eff_status")== null ? "":request.getParameter("eff_status");

	boolean searched		= request.getParameter( "searched" ) == null? false : true  ;	
	String enable_temp="";
			
	HashMap sqlMap = new HashMap();

	sqlMap.put("sqlData","select assess_catg_code,long_desc,short_desc,eff_status from cp_assess_catg_lang_vw where upper(assess_catg_code) like upper(?)  and upper(short_desc) like upper(?) and  upper(eff_status) like upper(?) and language_id like ?");

			

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	
	displayFields.add("assess_catg_code");
	displayFields.add("long_desc");
	displayFields.add("short_desc");
	displayFields.add("eff_status");
	
	//The fields are going to be in where condition * shld match with the qry//
	ArrayList chkFields = new ArrayList();

	chkFields.add(assess_catg_code+"%");
	chkFields.add(short_desc+"%");
	chkFields.add(Enabled+"%");
	chkFields.add(locale+"%");
		

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

		<th rowspan="2"><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th rowspan="2"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
		<th rowspan="2"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
		<th rowspan="2"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
</tr><tr>
</tr>
			<%
	//------------Retriving the records from result arraylist------------------//
	ArrayList records=new ArrayList();
	for(int recCount=2; recCount<result.size(); recCount++) {
		if ( recCount % 2 == 0 )
			classvalue = "QRYEVEN" ;
		else
			classvalue = "QRYODD" ;
		String link_columns = "1";
		records=(ArrayList) result.get( recCount );
		 String long_desc=(String)records.get(1);
		 short_desc=(String)records.get(2);
		 enable_temp=(String)records.get(3);
	%>
	<tr onClick='Modify(this,"<%=long_desc%>","<%=short_desc%>","<%=enable_temp%>");' >
		<%
			for(int colCount=0; colCount<records.size(); colCount++){
				if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
		%>
		<td class="<%=classvalue%>" onmouseover="changeCursor(this);"><font class='HYPERLINK'><%=(String)records.get(colCount)%></font></td>
		<%}else{
			String str = (String)records.get(colCount)== null? "":(String)records.get(colCount);	

			if(colCount == 3 )
				str=str.equals("E")?enableGif:disableGif;
			if(str.equals("")){
		%>
			<td class="<%=classvalue%>" onclick="disableClick(event);">&nbsp;</td>
		<%}else{%>
			<td class="<%=classvalue%>" onclick="disableClick(event);"><%=str%></td>
		  <%}}//with out hyper link
		}//loop for all tds
		%>
	</tr>
	<%}//L00p for all records%>
	</table>

	<%
		out.flush();
		} else{
	%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);
	</script>
	<%
		}
		out.println(CommonBean.setForm(request ,"../../eCP/jsp/AssessmentCategoryQueryResult.jsp", searched));
		}catch(Exception e ){
			out.println("here in catch"+e);
		}
	%>

</body>
</html>

