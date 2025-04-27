<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
-----------------------------------------------------------------------
Date       	  Edit History  Name        Description
-----------------------------------------------------------------------
?             100         	?            created	
05/07/2012    IN029935      Chowminya G	 Add NPB Request Form in query 	
09/11/2012	  IN030473		Ramesh G	 Bru-HIMS-CRF-032 								 
-----------------------------------------------------------------------
-->
<!-- ConsentFormatResult.jsp -->  
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper " %> 
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

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
	<title></title>
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<!--<script language='javascript' src='../../eCommon/js/messages.js'></script>--> <!-- changed effected-->
	<script language="Javascript" src="../../eOR/js/OrCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eOR/js/ReasonCode.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function Modify(obj){
		var consent_form_id = obj.cells[0].innerText;

		document.location.href="ConsentFormatAddModify.jsp?mode=2&consent_form_id="+consent_form_id+"&function_id="+parent.function_id;
	}
	</script>
	<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()"  >
 <%
	
    String consent_form_id		= request.getParameter("id");
    String eff_status			= request.getParameter("eff_status").trim();
	String consent_type			= request.getParameter("consent_type").trim();
	String Consent_form_label		= request.getParameter("Consent_form_label");
	ArrayList records=null;

	if(consent_form_id == null){consent_form_id = "";}else{consent_form_id = consent_form_id.toUpperCase();}
	if(consent_type == null){consent_type = "";}else{consent_type = consent_type.toUpperCase();}
	if(Consent_form_label == null){Consent_form_label = "";}else{Consent_form_label = Consent_form_label.toUpperCase();}
	if(eff_status==null || eff_status.equals("B")) eff_status="";

	boolean searched = request.getParameter( "searched" ) == null ? false : true  ;


	try{
	String classvalue			= "";

	HashMap sqlMap = new HashMap();
	//sqlMap.put( "sqlData", OrRepository.getOrKeyValue("SQL_OR_CONSENT_NOTE_TEXT_QUERY_RESULT"));
	//sqlMap.put( "sqlData", "SELECT consent_form_id, consent_type,decode(consent_type,'C','Consent Form','R','Refusal Form','Z','Referral Form','N','NPB Request Form') consent_type_desc ,eff_status,consent_form_label FROM  or_consent_form WHERE upper(consent_form_id) LIKE upper(?) AND upper(consent_type) like upper(?) AND upper(consent_form_label) like upper(?) AND upper(eff_status) LIKE upper(?)"); //IN029935  //IN030473
	sqlMap.put( "sqlData", "SELECT consent_form_id, consent_type,decode(consent_type,'C','Consent Form','I','Patient Instructions for Interventions','R','Refusal Form','Z','Referral Form','N','NPB Request Form') consent_type_desc ,eff_status,consent_form_label FROM  or_consent_form WHERE upper(consent_form_id) LIKE upper(?) AND upper(consent_type) like upper(?) AND upper(consent_form_label) like upper(?) AND upper(eff_status) LIKE upper(?)"); //IN030473
	

	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	displayFields.add( "consent_form_id" );
	//displayFields.add( "consent_form_content_bref" );
	displayFields.add( "consent_type_desc");
	displayFields.add( "Consent_form_label" );
	displayFields.add( "eff_status" );


	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();
	chkFields.add( consent_form_id + "%");
	chkFields.add( consent_type + "%");
	chkFields.add( Consent_form_label + "%");
	
	chkFields.add( eff_status + "%");

	//Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );
	displayFields=null;
	chkFields=null;

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
//out.println("<script>alert('result="+result+"');</script>");

	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<table cellpadding=3 cellspacing=0 width="100%" border=0 align="center"> 
		<tr>
		
		<td class='label' nowrap></td>
		<td class='label' nowrap>
	<%
		//For display the previous/next link
	     out.println(result.get(1));
	%>
		</td></tr>
		</table>

		<table class='grid' width="100%">
		<th class='columnheader'><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
		<th class='columnheader'><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
		<th class='columnheader'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		<th class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td> 
		<%
		//Retriving the records from result arraylist
		records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "gridData" ;
			else
				classvalue = "gridData" ;
		%>
			<tr onClick="Modify(this);" >
		<%
		String link_columns = "1", disp ="";
		String str = "";
		records=(ArrayList) result.get( recCount );
		for(int colCount=0; colCount<records.size(); colCount++){
			if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){%>
			<td class="<%=classvalue%>" onmouseover="changeCursor(this);"><a class='gridLink' href='#'><%=(String)records.get(colCount)%> </a></td>
			<%}else{
				if(colCount == 1 || colCount == 2)
				{
					str= (String) records.get(colCount);
					if(str==null) str="";
					%>
					<td class="<%=classvalue%>" onclick="disableClick(event);"> 
						 <%= str %>
					</td>
					<%	
				}
				else
				{
					disp = (String)records.get(colCount);
					%>
					<td class="<%=classvalue%>" onclick="disableClick(event);"><%
					if(disp.equals("E")){%><img src="../../eCommon/images/enabled.gif" align=center></img><%}else if(disp.equals("D")){%><img src="../../eCommon/images/disabled.gif" align=center></img> <%}%></td>

					<%
				}	
				}
		}
		%>
		</tr>
		<%}%>
		</table>
		<%out.flush();}else{%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script>
			<%}out.println(CommonBean.setForm(request ,"ConsentFormatQueryResult.jsp", searched));
	result=null;
	}
	catch(Exception e) {
	//out.print("Exception @ Result JSP :"+e.toString());//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
	}
	%>
	</body>
	</html>

