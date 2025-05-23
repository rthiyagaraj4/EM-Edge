<!DOCTYPE html>
<%--
*	Copyright � MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eMR
*	Purpose 		:	
*	Created By		:	Sreelatha
*	Created On		:	7 January 2005

--%>

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*, eMR.*,eCommon.Common.*,com.ehis.eslp.*,eCommon.XSSRequestWrapper "   contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<HTML>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonResult.js"></Script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>

<BODY class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String classvalue = "";
/*----- Required while Selecting sql and Formatting display------*/
	//String enableGif ="<div align='center'><img align='center' src='../../eCommon/images/enabled.gif'></img></div>" ;
	//String disableGif ="<div align='center'><img src='../../eCommon/images/RRnwd.gif'></img></div>" ;

try{
		
	String term_set_id= request.getParameter("term_set_id");
	String term_set_desc	= request.getParameter("term_set_desc");
	String specialty_code		= request.getParameter("specialty_code");
	String specialty_desc		= request.getParameter("specialty_desc");
	
	boolean searched		= request.getParameter( "searched" ) == null? false : true  ;	


	if(term_set_id == null || term_set_id.equals("null")) term_set_id =" "; else term_set_id =term_set_id.trim();
	if(term_set_desc == null ||term_set_desc.equals("null")) term_set_desc =" "; else term_set_desc = term_set_desc.trim();
	if(specialty_code	 == null || specialty_code	.equals("null")) specialty_code	 =" "; else specialty_code	 = specialty_code	.trim();
	if(specialty_desc == null || specialty_desc.equals("null")) specialty_desc=" "; else specialty_desc = specialty_desc.trim();
	
	HashMap sqlMap = new HashMap();

	
	
	String sql_terminology="select a.term_set_id, b.term_set_desc, a.specialty_code, c.long_desc specialty_desc  from mr_term_set_for_specialty a, mr_term_set b,am_speciality c where a.term_set_id = b.term_set_id and a.specialty_code=c.speciality_code    and upper(a.term_set_id) like upper(?) and upper( b.term_set_desc) like upper(?) and upper(a.specialty_code) like upper(?) and upper(c.long_desc) like upper(?)";
		

		
	sqlMap.put( "sqlData",sql_terminology);
	
	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	
	displayFields.add("term_set_id");
	displayFields.add("term_set_desc");
	displayFields.add("specialty_code");
	displayFields.add("specialty_desc");

	
	
	//The fields are going to be in where condition * shld match with the qry//
	ArrayList chkFields = new ArrayList();

	chkFields.add(term_set_id+"%");
	chkFields.add( term_set_desc+"%");
	chkFields.add( specialty_code+"%");
	chkFields.add(specialty_desc+"%");
	


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

	<th width="20%" ><fmt:message key="eMR.TerminologySetId.label" bundle="${mr_labels}"/></th>
	<th width="40%"><fmt:message key="eMR.TerminologySetDescription.label" bundle="${mr_labels}"/></th>
	<th width="15%" ><fmt:message key="Common.SpecialityCode.label" bundle="${common_labels}"/></th>
	<th width="25%"><fmt:message key="eMP.SpecialityDesc.label" bundle="${mp_labels}"/></th>
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
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA",'Common'));history.go(-1);</script>
	<%
		}
			out.println(CommonBean.setForm(request ,"../../eMR/jsp/TerminologySetForSpecialtyQueryResult.jsp", searched));
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} %>

</body>
</html>  
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

