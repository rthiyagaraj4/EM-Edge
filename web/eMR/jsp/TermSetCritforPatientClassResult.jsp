<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eMR
*	Purpose 		:	
*	Created By		:	Janet George
*	Created On		:	6 Jan 2005

--%>


<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%@ page contentType="text/html;charset=UTF-8" import ="java.util.*, java.sql.*,webbeans.eCommon.*, eMR.*,com.ehis.eslp.* ,eCommon.XSSRequestWrapper" %><!--oracle.jdbc.driver.*,-->
<% request.setCharacterEncoding("UTF-8");
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff"); %>
<HTML>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonResult.js"></Script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrMessages.js"></script>
	<script src="../js/TermSetCritforPatientClass.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<BODY class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
String classvalue = "";
/*----- Required while Selecting sql and Formatting display------*/
//	String enableGif ="<div align='center'><img align='center' src='../../eCommon/images/enabled.gif'></img></div>" ;
//	String disableGif ="<div align='center'><img src='../../eCommon/images/RRnwd.gif'></img></div>" ;

try{
		
	String criteria= request.getParameter("criteria");
	String List_value	= request.getParameter("List_value");
	String patient_class		= request.getParameter("patient_class");
	String patient_class_desc		= request.getParameter("patient_class_desc");
	
	boolean searched		= request.getParameter( "searched" ) == null? false : true  ;	


	if(criteria == null || criteria.equals("null")) criteria =" "; else criteria =criteria.trim();
	if(List_value == null ||List_value.equals("null")) List_value =" "; else List_value = List_value.trim();
	if(patient_class	 == null || patient_class	.equals("null")) patient_class	 =" "; else patient_class	 = patient_class	.trim();
	if(patient_class_desc == null || patient_class_desc.equals("null")) patient_class_desc=" "; else patient_class_desc = patient_class_desc.trim();
	
	HashMap sqlMap = new HashMap();
	//String sql_accuracy="select a.accuracy_code, b.long_desc, a.patient_class, c.long_desc patient_class_desc from mr_accuracy_for_pat_class a, mr_accuracy b,am_patient_class c where a.accuracy_code = b.accuracy_code and a.patient_class=c.patient_class and upper(a.accuracy_code) like upper(?) and upper( b.long_desc) like upper(?) and upper(a.patient_class) like upper(?) and upper(c.long_desc) like upper (?)";

	String sql_accuracy="select a.CRITERIA,a.LIST_VALUE,  a.patient_class, c.long_desc patient_class_desc from MR_TERM_SET_CRIT_FOR_PC a, am_patient_class c where  a.patient_class=c.patient_class AND  upper(a.CRITERIA) like upper(?) AND upper(a.LIST_VALUE) like upper(?) AND upper(a.patient_class) like upper(?) AND upper(c.long_desc) like upper(?)";

	
	//out.println(sql_terminology);

	sqlMap.put( "sqlData",sql_accuracy);
	
	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	
	displayFields.add("criteria");
	displayFields.add("List_value");
	displayFields.add("patient_class");
	displayFields.add("patient_class_desc");
	
	//The fields are going to be in where condition * shld match with the qry//
	ArrayList chkFields = new ArrayList();

	chkFields.add(criteria+"%");
	chkFields.add( List_value+"%");
	chkFields.add( patient_class+"%");
	chkFields.add(patient_class_desc+"%");
	


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

	<th width="15%" align='left'><fmt:message key="Common.criteria.label" bundle="${common_labels}"/></th>
	<th width="50%" align='left'><fmt:message key="eMR.ListValue.label" bundle="${mr_labels}"/></th>
	<th width="10%" align='left'><fmt:message key="Common.PatientClassCode.label" bundle="${common_labels}"/></th>
	<th width="25%" align='left'><fmt:message key="Common.PatientClassDescription.label" bundle="${common_labels}"/></th>
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
<%}//Loop for all records%>
</table>
	<%
	out.flush();
	}
	else
		{%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA",'Common'));history.go(-1);</script>
	<%
		}
			out.println(CommonBean.setForm(request ,"../../eMR/jsp/TermSetCritforPatientClassResult.jsp", searched));
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

