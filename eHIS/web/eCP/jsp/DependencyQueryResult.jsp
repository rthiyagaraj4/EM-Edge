<!DOCTYPE html>
<!--Created by P.Anuradha on Dec-27-2004-->
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page import="eCP.* " %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
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
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/CommonResult.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<script>
	function Modify(obj){
		var dependency_code	= obj.cells[0].innerText;
		
document.location.href="../../eCP/jsp/DependencyAddModify.jsp?mode=2&dependency_code="+dependency_code;
}
</script>

<BODY class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
String classvalue = "";
	/*----- Required while Selecting sql and Formatting display------*/
	String enableGif ="<div align='center'><img align='center' src='../../eCommon/images/enabled.gif'></img></div>" ;
	String disableGif ="<div align='center'><img src='../../eCommon/images/RRnwd.gif'></img></div>" ;

	try{

		boolean searched	= request.getParameter( "searched" ) == null? false : true  ;

		String dependency_code = request.getParameter("Dependency_code").equals("") ? "":request.getParameter("Dependency_code");
		String long_desc = request.getParameter("Dependency_Longdesc").equals("") ? "":request.getParameter("Dependency_Longdesc");
		String dependency_level = request.getParameter("Dependency_Level").equals("") ? "":request.getParameter("Dependency_Level");
     	String eff_status = request.getParameter("eff_status_yn").equals("") ? "D":request.getParameter("eff_status_yn");
		//String short_desc="";
		//String reassessment_interval="";
		//String durn_desc="";

		HashMap sqlMap = new HashMap();

//		sqlMap.put("sqlData","select dependency_code,long_desc,short_desc,dependency_level,reassessment_interval,durn_desc,eff_status from cp_dependency a,am_duration_type b where a.reassessment_interval_unit = b.durn_type and upper(dependency_code) like upper(?)  and upper(long_desc) like upper(?) and upper(dependency_level) like upper(?) and upper(eff_status) like upper(?)");
		sqlMap.put("sqlData","SELECT dependency_code,long_desc,short_desc,dependency_level,reassessment_interval,durn_desc,eff_status FROM cp_dependency_lang_vw a,am_duration_type_lang_vw b WHERE a.reassessment_interval_unit = b.durn_type AND UPPER(dependency_code) LIKE UPPER(?)  AND UPPER(long_desc) LIKE UPPER(?) AND UPPER(dependency_level) LIKE UPPER(?) AND UPPER(eff_status) LIKE UPPER(?) AND A.LANGUAGE_ID = ? AND B.LANGUAGE_ID = A.LANGUAGE_ID");

		ArrayList displayFields = new ArrayList();

		displayFields.add("dependency_code" );
		displayFields.add("long_desc");
		displayFields.add("short_desc");
		displayFields.add("dependency_level");
		displayFields.add("reassessment_interval");
		displayFields.add("durn_desc");
		displayFields.add("eff_status");

		//The fields are going to be in where condition * shld match with the qry//
		ArrayList chkFields = new ArrayList();
		chkFields.add( dependency_code+"%" );
		chkFields.add( long_desc+"%" );
		chkFields.add( dependency_level);
		chkFields.add( eff_status+"%" );
		chkFields.add( locale);

		// Adding function related array list into the HashMap//
		HashMap funcMap = new HashMap();
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );

		//Calling the Result from Common Adaptor as a arraylist.//
		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);
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
		</td></tr>
</table>

	<table cellpadding=0 cellspacing=0 border=1 width='98%' align="center">
<tr>
		<th rowspan="2"><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th rowspan="2"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
		<th rowspan="2"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
		<th rowspan="2"><fmt:message key="Common.Level.label" bundle="${common_labels}"/></th>
		<th rowspan="2"><fmt:message key="eCP.ReassessmentInterval.label" bundle="${cp_labels}"/></th>
		<th rowspan="2"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
</tr><tr></tr>

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
		 long_desc=(String)records.get(1);
		// short_desc=(String)records.get(2);
		 dependency_level=(String)records.get(3);
		 //reassessment_interval=(String)records.get(4);
		//durn_desc=(String)records.get(5);
		 eff_status=(String)records.get(6);
		 
	%>
<tr onClick="Modify(this);" >
		<%
			String str="";
			for(int colCount=0; colCount<records.size(); colCount++){
				if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
		%>
		<td class="<%=classvalue%>" onmouseover="changeCursor(this);"> 	<font class='HYPERLINK'><%=(String)records.get(colCount)%></font></td>
		<%}else{
			if(colCount == 4){
				str = (String)records.get(colCount)==null?"":(String)records.get(colCount)+" ";
				continue;
			}
			if(colCount == 5)
				str=str+(String)records.get(colCount)==null?"":(String)records.get(colCount);
			else
				str=(String)records.get(colCount)==null?"":(String)records.get(colCount);

			if(colCount == 6 )
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
		out.println(CommonBean.setForm(request ,"../../eCP/jsp/DependencyQueryResult.jsp", searched));
		}catch(Exception e ){
			//out.println("here in catch"+e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
	%>

</body>
</html>

