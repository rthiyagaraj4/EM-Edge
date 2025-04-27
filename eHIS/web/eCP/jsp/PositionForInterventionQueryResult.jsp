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

<%-- Mandatory declarations end --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import ="java.sql.*,java.util.*,webbeans.eCommon.*, eCP.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
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
try{
	String role_type= request.getParameter("role_type");
	String position_code	= request.getParameter("position_code");
	String position_desc		= request.getParameter("position_desc");
	String intervention_code		= request.getParameter("intervention_code");
	String short_desc		= request.getParameter("short_desc");
	
	boolean searched		= request.getParameter( "searched" ) == null? false : true  ;	

	if(role_type == null || role_type.equals("null")) role_type =" "; else role_type =role_type.trim();
	if(position_code == null ||position_code.equals("null")) position_code =" "; else position_code = position_code.trim();
	if(position_desc	 == null || position_desc.equals("null")) position_desc =" "; else position_desc = position_desc.trim();
	if(intervention_code == null || intervention_code.equals("null")) intervention_code=" "; else intervention_code = intervention_code.trim();
	if(short_desc == null || short_desc.equals("null")) short_desc =" "; else short_desc = short_desc.trim();
		
	HashMap sqlMap = new HashMap();
		
	//String sql_position ="select a.position_code, b.position_desc pdesc, a.role_type, a.intervention_code, c.short_desc des from ca_intervention_for_posn a, am_position b, ca_intervention c where a.position_code=b.position_code and a.intervention_code=c.intervention_code and a.role_type = b.role_type and upper(a.position_code) like upper(?) and  upper(b.position_desc) like upper(?) and upper(a.role_type) like upper(?)  and upper(a.intervention_code) like upper(?)  and upper(c.short_desc) like upper(?)";
	String sql_position ="SELECT a.position_code, b.position_desc pdesc, a.role_type, a.intervention_code, c.short_desc des FROM ca_intervention_for_posn a, am_position_lang_vw b, ca_intervention_lang_vw c WHERE a.position_code=b.position_code AND a.intervention_code=c.intervention_code AND a.role_type = b.role_type AND UPPER(a.position_code) LIKE UPPER(?) AND  UPPER(b.position_desc) LIKE UPPER(?) AND UPPER(a.role_type) LIKE UPPER(?)  AND UPPER(a.intervention_code) LIKE UPPER(?)  AND UPPER(c.short_desc) LIKE UPPER(?) AND b.language_id = ? AND c.language_id = b.language_id";
		

    sqlMap.put( "sqlData",sql_position);
	
	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	
	displayFields.add("position_code");
	displayFields.add("pdesc");
	displayFields.add("role_type");
	displayFields.add("intervention_code");
	displayFields.add("des");
	
	//The fields are going to be in where condition * shld match with the qry//
	ArrayList chkFields = new ArrayList();

	chkFields.add(position_code+"%");
	chkFields.add( position_desc+"%");
	chkFields.add(role_type+"%");
	chkFields.add(intervention_code+"%");
	chkFields.add( short_desc+"%");
	chkFields.add( locale);

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
<th align='left'><fmt:message key="Common.PositionCode.label" bundle="${common_labels}"/></th>
<th align='left'><fmt:message key="Common.PositionDescription.label" bundle="${common_labels}"/></th>
<th  align='left'><fmt:message key="Common.RoleType.label" bundle="${common_labels}"/></th>
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
	}else{%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
	<%
		}
			out.println(CommonBean.setForm(request ,"../../eCP/jsp/PositionForInterventionQueryResult.jsp", searched));
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} %>
</body>
</html>  
	

