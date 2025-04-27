<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*, eCP.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>

<html>
<head>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<script>
function Modify(obj)
{
var intervention_type	= obj.cells[0].innerText;
document.location.href="../../eCP/jsp/InterventionTypeAddModify.jsp?mode=2&intervention_type="+intervention_type;
}
</script>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
String classvalue = "";
/*----- Required while Selecting sql and Formatting display------*/
String enableGif ="<div align='center'><img align='center' src='../../eCommon/images/enabled.gif'></img></div>" ;
String disableGif ="<div align='center'><img src='../../eCommon/images/RRnwd.gif'></img></div>" ;

try{
	String intervention_type	= request.getParameter("intervention_type");
	String long_desc			= request.getParameter("long_desc");
	String system_defined_yn	= request.getParameter("system_defined_yn")==null? "N":request.getParameter("system_defined_yn");
	String enabled				= request.getParameter("eff_status");	
	boolean searched			= request.getParameter( "searched" ) == null? false : true  ;	

	if(intervention_type == null || intervention_type.equals("null")) intervention_type=" "; else intervention_type = intervention_type.trim();
	if(long_desc == null || long_desc.equals("null")) long_desc =" "; else long_desc = long_desc.trim();
	if(enabled == null || enabled.equals("null")) enabled =" "; else enabled = enabled.trim();
		
	HashMap sqlMap = new HashMap();
		
	//String sql_interventiontype="select intervention_type,long_desc,short_desc,eff_status from ca_intervention_type where upper(intervention_type) like upper(?)  and upper(long_desc) like upper(?) and  upper(eff_status) like upper(?)";
	String sql_interventiontype="SELECT intervention_type,long_desc,short_desc,eff_status FROM ca_intervention_type_lang_vw WHERE UPPER(intervention_type) LIKE UPPER(?)  AND UPPER(long_desc) LIKE UPPER(?) AND  UPPER(system_defined_yn) LIKE UPPER(?) AND  UPPER(eff_status) LIKE UPPER(?) AND language_id = ?";
		
    sqlMap.put( "sqlData",sql_interventiontype);
	
	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	
	displayFields.add("intervention_type");
	displayFields.add("long_desc");
	displayFields.add("short_desc");
	displayFields.add("eff_status");
	
	//The fields are going to be in where condition * shld match with the qry//
	ArrayList chkFields = new ArrayList();

	chkFields.add(intervention_type+"%");
	chkFields.add(long_desc+"%");
	chkFields.add(system_defined_yn+"%");
	chkFields.add(enabled+"%");
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
<th align='left'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th align='left'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th  align='left'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<th  align='left'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
</tr>
	<%
	//Retriving the records from result arraylist

		String link_columns = "1";
		ArrayList records=new ArrayList();
		
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
			records=(ArrayList) result.get( recCount );
		%>				
		<tr onClick="Modify(this);">   
		<%
			String str="";
		for(int colCount=0; colCount<4; colCount++){
			if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
		%>
		<td class="<%=classvalue%>" onmouseover="changeCursor(this);"> 	<font class='HYPERLINK'><%=(String)records.get(colCount)%></font></td>
 		<%} else {
			if(colCount == 2)
				str=(String)records.get(colCount)==null?"":(String)records.get(colCount);
			else
				str=(String)records.get(colCount)==null?"":(String)records.get(colCount);

			if(colCount == 3 )
				str=str.equals("E")?enableGif:disableGif;
			if(str.equals("")){
		 %>
		 <td class="<%=classvalue%>" onclick="disableClick(event);">&nbsp;</td>
		<%}else{%>
			<td class="<%=classvalue%>" onclick="disableClick(event);"><%=str%></td>
		  <%}}//end of for loop
		}
		  %>
</tr>
<%}//Loop for all records%>
</table>
	<%
	out.flush();
	}else{%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
	<%
		}
			out.println(CommonBean.setForm(request ,"../../eCP/jsp/InterventionTypeQueryResult.jsp", searched));
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} %>
</body>
</html>  
	

