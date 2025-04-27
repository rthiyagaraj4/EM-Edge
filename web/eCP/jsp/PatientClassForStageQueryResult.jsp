<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ page import ="java.sql.*,webbeans.eCommon.*, eCP.*,com.ehis.eslp.* " %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<%-- Mandatory declarations end --%>



<HTML>
<head>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>	<script language="javascript" src="../../eCommon/js/messages.js"></script>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonResult.js"></Script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
String classvalue = "";
String stage_code= "";
String long_desc	= "";
String patient_class		= "";
String patient_class_desc		= "";
boolean searched		=false;

String sql_stage="";
String str = "";
HashMap sqlMap =null;
ArrayList displayFields =null;
ArrayList chkFields =null;
HashMap funcMap = null;
ArrayList result=null;
ArrayList records=null;
/*----- Required while Selecting sql and Formatting display------*/
//	String enableGif ="<div align='center'><img align='center' src='../../eCommon/images/enabled.gif'></img></div>" ;
//	String disableGif ="<div align='center'><img src='../../eCommon/images/RRnwd.gif'></img></div>" ;

try{
		
	 stage_code= request.getParameter("stage_code");
	 long_desc	= request.getParameter("long_desc");
	 patient_class		= request.getParameter("patient_class");
	 patient_class_desc		= request.getParameter("patient_class_desc");
	
	 searched		= request.getParameter( "searched" ) == null? false : true  ;	


	if(stage_code == null || stage_code.equals("null")) stage_code =" "; else stage_code =stage_code.trim();
	if(long_desc == null ||long_desc.equals("null")) long_desc =" "; else long_desc = long_desc.trim();
	if(patient_class	 == null || patient_class	.equals("null")) patient_class	 =" "; else patient_class	 = patient_class	.trim();
	if(patient_class_desc == null || patient_class_desc.equals("null")) patient_class_desc=" "; else patient_class_desc = patient_class_desc.trim();
	
	 sqlMap = new HashMap();
	 //sql_stage="select a.stage_code, b.long_desc, a.patient_class, c.long_desc patient_class_desc from cp_pat_class_for_stage a, cp_stage b,am_patient_class c where a.stage_code = b.stage_code and a.patient_class=c.patient_class and upper(a.stage_code) like upper(?) and upper( b.long_desc) like upper(?) and upper(a.patient_class) like upper(?) and upper(c.long_desc) like upper (?)";
	 sql_stage="SELECT a.stage_code, b.long_desc, a.patient_class, c.long_desc patient_class_desc FROM cp_pat_class_for_stage a, cp_stage_lang_vw b,am_patient_class_lang_vw c WHERE a.stage_code = b.stage_code AND a.patient_class=c.patient_class AND b.language_id = ? AND c.language_id = ? AND UPPER(a.stage_code) LIKE UPPER(?) AND UPPER( b.long_desc) LIKE UPPER(?) AND UPPER(a.patient_class) LIKE UPPER(?) AND UPPER(c.long_desc) LIKE UPPER (?)";


	sqlMap.put( "sqlData",sql_stage);
	
	//The fields are going to be display
	 displayFields = new ArrayList();
	
	displayFields.add("stage_code");
	displayFields.add("long_desc");
	displayFields.add("patient_class");
	displayFields.add("patient_class_desc");
	
	//The fields are going to be in where condition * shld match with the qry//
	 chkFields = new ArrayList();
	chkFields.add(locale);
	chkFields.add(locale);
	chkFields.add(stage_code+"%");
	chkFields.add( long_desc+"%");
	chkFields.add( patient_class+"%");
	chkFields.add(patient_class_desc+"%");
	


	// Adding function related array list into the HashMap//
	funcMap = new HashMap();
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );
	//out.println("=====chkFields==="+chkFields);
	//Calling the Result from Common Adaptor as a arraylist.//
	 result=new ArrayList();
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

	<th width="15%" align='left'><fmt:message key="Common.StageCode.label" bundle="${common_labels}"/></th>
	<th width="50%" align='left'><fmt:message key="eCP.StageDescription.label" bundle="${cp_labels}"/></th>
	<th width="10%" align='left'><fmt:message key="Common.PatientClassCode.label" bundle="${common_labels}"/></th>
	<th width="25%" align='left'><fmt:message key="Common.PatientClassDescription.label" bundle="${common_labels}"/></th>
</tr>
	<%
		//Retriving the records from result arraylist
		 records=new ArrayList();
		
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
	out.flush();
	}
	else
		{%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
	<%
		}
			out.println(CommonBean.setForm(request ,"../../eCP/jsp/PatientClassForStageQueryResult.jsp", searched));
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} %>
</body>
</html>  

