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
*	Created By		:	Anuradha.P
*	Created On		:	24 March 2005
--%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ page  contentType="text/html;charset=UTF-8"  language="java" import ="java.sql.*, webbeans.eCommon.*,eCommon.Common.*,java.util.HashMap ,java.net.*,java.util.*,eCommon.XSSRequestWrapper" %>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
//This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
    String classvalue = "";
/*----- Required while Selecting sql and Formatting display------*/
	//String enableGif ="<div align='center'><img align='center' src='../../eCommon/images/enabled.gif'></img></div>" ;
	//String disableGif ="<div align='center'><img src='../../eCommon/images/RRnwd.gif'></img></div>" ;

try{
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale			= (String)session.getAttribute("LOCALE");

	String frequency_code	= request.getParameter("frequency_code");
	String frequency_desc		= request.getParameter("frequency_desc");
	String intervention_code		= request.getParameter("intervention_code");
	String short_desc		= request.getParameter("short_desc");
	
	boolean searched		= request.getParameter( "searched" ) == null? false : true  ;	

	if(frequency_code == null ||frequency_code.equals("null")) frequency_code =" "; else frequency_code = frequency_code.trim();
	if(frequency_desc	 == null || frequency_desc.equals("null")) frequency_desc =" "; else frequency_desc = frequency_desc.trim();
	if(intervention_code == null || intervention_code.equals("null")) intervention_code=" "; else intervention_code = intervention_code.trim();
	if(short_desc == null || short_desc.equals("null")) short_desc =" "; else short_desc = short_desc.trim();
		

		HashMap sqlMap = new HashMap();
		
//		String sql_frequency ="select a.freq_code, b.freq_desc, a.intervention_code,c.short_desc from ca_intervention_freq a, am_frequency b, ca_intervention c where a.freq_code=b.freq_code and a.intervention_code=c.intervention_code and upper(a.freq_code) like upper(?) and  upper(b.freq_desc) like upper(?) and upper(a.intervention_code) like upper(?)  and upper(c.short_desc) like upper(?)";
		String sql_frequency ="SELECT a.freq_code, b.freq_desc, a.intervention_code,c.short_desc FROM ca_intervention_freq a, am_frequency_lang_vw b, ca_intervention_lang_vw c WHERE a.freq_code=b.freq_code AND a.intervention_code=c.intervention_code AND UPPER(a.freq_code) LIKE UPPER(?) AND  UPPER(b.freq_desc) LIKE UPPER(?) AND UPPER(a.intervention_code) LIKE UPPER(?)  AND UPPER(c.short_desc) LIKE UPPER(?) and b.language_id = ? and c.language_id = b.language_id";
		

    sqlMap.put( "sqlData",sql_frequency);
	
	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	
	displayFields.add("freq_code");
	displayFields.add("freq_desc");
	displayFields.add("intervention_code");
	displayFields.add("short_desc");

	//The fields are going to be in where condition * shld match with the qry//
	ArrayList chkFields = new ArrayList();

	chkFields.add(frequency_code+"%");
	chkFields.add(frequency_desc+"%");
	chkFields.add(intervention_code+"%");
	chkFields.add(short_desc+"%");
	chkFields.add(locale);
		
	// Adding function related array list into the HashMap//
	HashMap funcMap = new HashMap();
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );


	//Calling the Result from Common Adaptor as a arraylist.//
	ArrayList result=new ArrayList();
	result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);

  
	if((result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){

 %>
 <table cellpadding=0 cellspacing=0 width="100%" align="center">
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

<table cellpadding=0 cellspacing=0 border=1 width='100%'  align=center>
<tr>
	<th align='left'><fmt:message key="Common.FrequencyCode.label" bundle="${common_labels}"/></th>
	<th align='left'><fmt:message key="Common.FrequencyDescription.label" bundle="${common_labels}"/></th>
	<th  align='left'><fmt:message key="eCP.InterventionCode.label" bundle="${cp_labels}"/></th>
	<th align='left'><fmt:message key="eCP.InterventionDescription.label" bundle="${cp_labels}"/></th>
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
		String str=""; 
		for(int colCount=0; colCount<records.size(); colCount++){		
			str = (String)records.get(colCount)==null?"":(String)records.get(colCount);
			if(str.equals("")){%>
			<td class="<%=classvalue%>">&nbsp;</td>
 		<%} else {
		 %>
				<td class="<%=classvalue%>"><%=str%></td>
		  <%}}//end of for loop
		  %>
</tr>
<%}//Loop for all records%>
</table>
	<%
	//out.flush();
	}
	else
	{
	%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
	<%
		}
			out.println(CommonBean.setForm(request ,"../../eCP/jsp/FrequencyForInterventionQueryResult.jsp", searched));
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} 
	%>
</body>
</html>  
	

