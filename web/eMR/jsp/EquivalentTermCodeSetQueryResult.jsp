<!DOCTYPE html>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,eCommon.XSSRequestWrapper" %><!--,oracle.jdbc.driver.*-->
<%-- JSP Page specific attributes end --%>
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


try{
		
	String term_set_id					= request.getParameter("term_set_id");
	String term_code					= request.getParameter("term_code");  
	String short_desc					= request.getParameter("short_desc");
	String equivalent_term_set_id		= request.getParameter("equivalent_term_set_id");
	String equivalent_term_code			= request.getParameter("equivalent_term_code");
	String short_desc1					= request.getParameter("short_desc1");
	
	boolean searched					= request.getParameter( "searched" ) == null? false : true  ;	


	if(term_set_id == null || term_set_id.equals("null")) term_set_id =" "; else term_set_id =term_set_id.trim();
	if(term_code == null ||term_code.equals("null")) term_code =" "; else term_code = term_code.trim();
	if(equivalent_term_set_id	 == null || equivalent_term_set_id	.equals("null")) equivalent_term_set_id	 =" "; else equivalent_term_set_id	 = equivalent_term_set_id.trim();
	if(equivalent_term_code == null || equivalent_term_code.equals("null")) equivalent_term_code=" "; else equivalent_term_code = equivalent_term_code.trim();
	if(short_desc == null || short_desc.equals("null")) short_desc =" "; else short_desc =short_desc.trim();
	if(short_desc1 == null || short_desc1.equals("null")) short_desc1 =" "; else short_desc1 =short_desc1.trim();
	

	
	HashMap sqlMap = new HashMap();
	
	String sql_terminology="select a.TERM_SET_ID,a.TERM_CODE,a.short_desc,b.EQUIVALENT_TERM_SET_ID ,b.EQUIVALENT_TERM_CODE,c.short_desc short_desc1 from mr_term_code a,MR_EQUIVALENT_TERM_CODE b,mr_term_code c where a.TERM_SET_ID=b.TERM_SET_ID and a.TERM_CODE=b.TERM_CODE AND c.TERM_CODE=b.EQUIVALENT_TERM_CODE and c.TERM_SET_ID=b.EQUIVALENT_TERM_SET_ID AND  upper(a.TERM_SET_ID) like upper(?) AND upper(a.TERM_CODE) like upper(?) AND upper(a.short_desc) like upper(?) AND upper(b.EQUIVALENT_TERM_SET_ID) like upper(?) AND upper(b.EQUIVALENT_TERM_CODE) like upper(?) AND upper(c.short_desc) like upper(?)";

    sqlMap.put( "sqlData",sql_terminology);
	
	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	
	
	displayFields.add("term_set_id");
	displayFields.add("term_code");
	displayFields.add("short_desc");
    displayFields.add("equivalent_term_set_id");
	displayFields.add("equivalent_term_code");
	displayFields.add("short_desc1");

//The fields are going to be in where condition * shld match with the qry//
    ArrayList chkFields = new ArrayList();
	
	chkFields.add(term_set_id+"%");
	chkFields.add(term_code+"%");
	chkFields.add(short_desc+"%");
    chkFields.add(equivalent_term_set_id+"%");
	chkFields.add(equivalent_term_code+"%");
	chkFields.add(short_desc1+"%");
	
// Adding function related array list into the HashMap//
	HashMap funcMap = new HashMap();
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

//Calling the Result from Common Adaptor as a arraylist.//
	ArrayList result=new ArrayList();
	//result=(ArrayList)CommonBean.getQueryResultPage(sqlMap, funcMap, request,false);

	result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);

    //int rowCount = 1;
	if((result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){

 %>
 <table cellpadding=1 cellspacing=0 width="100%" align="center">
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

<table border="2" cellpadding=0 cellspacing=0 width="100%"  align='center'>
<tr>
	<th width="10%" ><fmt:message key="Common.TerminologySet.label"  bundle="${common_labels}"/></th>
	<th width="10%" ><fmt:message key="Common.TerminologySet.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
	<th width="30%" ><fmt:message key="eMR.TerminologySetDescription.label" bundle="${mr_labels}"/></th>

	<th width="10%" ><fmt:message key="eMR.EquivalentTermSet.label" bundle="${mr_labels}"/></th>
	<th width="10%" ><fmt:message key="eMR.EquivalentTermSetCode.label" bundle="${mr_labels}"/></th>
	<th width="30%" ><fmt:message key="eMR.EquivalentTermSetDesc.label" bundle="${mr_labels}"/></th>
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
			out.println(CommonBean.setForm(request ,"../../eMR/jsp/EquivalentTermCodeSetQueryResult.jsp", searched));

			funcMap.clear();
			sqlMap.clear();
			displayFields.clear();
			chkFields.clear();
			result.clear();
			

	} catch ( Exception e )	{
		//out.print("Exception @ Result JSP :"+e.toString());
		e.printStackTrace();
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

