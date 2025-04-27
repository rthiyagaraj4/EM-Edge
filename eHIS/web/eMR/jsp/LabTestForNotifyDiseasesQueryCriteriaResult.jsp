<!DOCTYPE html>


<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*, eMR.*,eCommon.Common.*,com.ehis.eslp.*,eCommon.XSSRequestWrapper"   contentType="text/html;charset=UTF-8" %>
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
		
	String term_set_id= request.getParameter("NOTIFY_DISEASE_CODE");
	String term_set_desc	= request.getParameter("LONG_DESC");
	String specialty_code		= request.getParameter("TEST_CODE");
	String specialty_desc		= request.getParameter("TEST_CODE_DES");

	
	 boolean searched		= request.getParameter( "searched" ) == null? false : true  ;	


	if(term_set_id == null || term_set_id.equals("null")) term_set_id =" "; else term_set_id =term_set_id.trim();
	if(term_set_desc == null ||term_set_desc.equals("null")) term_set_desc =" "; else term_set_desc = term_set_desc.trim();
	if(specialty_code	 == null || specialty_code	.equals("null")) specialty_code	 =" "; else specialty_code	 = specialty_code	.trim();
	if(specialty_desc == null || specialty_desc.equals("null")) specialty_desc=" "; else specialty_desc = specialty_desc.trim();
	
	HashMap sqlMap = new HashMap();

	
	
	String sql_terminology=" SELECT a.notify_disease_code, b.long_desc, a.test_code, c.long_desc test_code_des FROM mr_labtest_for_notify_dis a, mr_notifiable_disease b, rl_test_code c WHERE a.notify_disease_code = b.notify_disease_code AND a.test_code = c.test_code AND UPPER (a.notify_disease_code) LIKE UPPER (?) AND UPPER (b.long_desc) LIKE UPPER (?) AND UPPER (a.test_code) LIKE UPPER (?) AND UPPER (c.long_desc) LIKE UPPER (?)";
		

		
	sqlMap.put( "sqlData",sql_terminology);
	
	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	
	displayFields.add("notify_disease_code");
	displayFields.add("LONG_DESC");
	displayFields.add("test_code");
	 displayFields.add("test_code_des");

	
	
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
    <th width="20%" ><fmt:message key="eMR.NotifyDiseasesCode.label" bundle="${mr_labels}"/></th>
	<th width="40%"><fmt:message key="eMR.NotifyDiseasesDesc.label" bundle="${mr_labels}"/></th>
	<th width="15%" ><fmt:message key="eMR.TEST_CODE.label" bundle="${mr_labels}"/></th>
	<th width="25%"><fmt:message key="eMR.TEST_DES.label" bundle="${mr_labels}"/></th>
	
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
			out.println(CommonBean.setForm(request ,"../../eMR/jsp/LabTestForNotifyDiseasesQueryCriteriaResult.jsp", searched));
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

