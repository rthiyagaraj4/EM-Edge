<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 			:
*	Created By		:	Janet George
*	Created On		:	15 January 2005
-->
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*,eRS.* " %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*, eRS.*,com.ehis.eslp.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<!-- <script language='javascript' src='../../eCommon/js/messages.js'></script> -->
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonResult.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- <script language="javascript" src="../js/RSMessages.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<script>
function Modify(obj)
{
var license_code	= obj.cells[0].innerText;
document.location.href="../../eRS/jsp/LicensureAddModify.jsp?mode=2&license_code="+license_code;
}
</script>
<BODY class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String classvalue = "";
	/*----- Required while Selecting sql and Formatting display------*/
	String enableGif ="<div align='center'><img align='center' src='../../eCommon/images/enabled.gif'></img></div>" ;
	String disableGif ="<div align='center'><img src='../../eCommon/images/RRnwd.gif'></img></div>" ;
	try
	{
		String license_code = request.getParameter("license_code");
		String license_desc = request.getParameter("license_desc");
		String eff_status = request.getParameter("eff_status");

	boolean searched = request.getParameter( "searched" ) == null? false : true  ;
		
		if(license_code==null )
			license_code ="";
		else 
			license_code = license_code.trim(); 

		if(license_desc==null )
			license_desc="";
		else
			license_desc = license_desc.trim();

		if(eff_status==null )
			eff_status="";
		else
			eff_status = eff_status.trim();


		//Common parameters.
		HashMap sqlMap = new HashMap();

		//include all the common parameters.
		//String SelectSql="select license_code,license_desc,eff_status from rs_licensure where upper(license_code) like upper(?) and upper(license_desc) like upper(?) and  upper(eff_status) like upper(?)";
		String SelectSql="select license_code,license_desc,eff_status from rs_licensure_lang_vw where upper(license_code) like upper(?) and upper(license_desc) like upper(?) and  upper(eff_status) like upper(?) and language_id like ? ";

		sqlMap.put( "sqlData",SelectSql);
		//The fields are going to be display.
		ArrayList displayFields = new ArrayList();
		displayFields.add("LICENSE_CODE" );
		displayFields.add("LICENSE_DESC");
		displayFields.add("EFF_STATUS");

		//The fields are going to be in where condition * shld match with the qry//
		ArrayList chkFields = new ArrayList();
		chkFields.add(license_code+"%" );
		chkFields.add(license_desc+"%" );
		chkFields.add(eff_status);
		chkFields.add(locale);

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
	<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
</tr>
	<%
	//------------Retriving the records from result arraylist------------------//
	ArrayList records=new ArrayList();
	String link_columns = "1";
	String align="";
	for(int recCount=2; recCount<result.size(); recCount++){
		if ( recCount % 2 == 0 )
			classvalue = "QRYEVEN" ;
		else
			classvalue = "QRYODD" ;
		
		 records=(ArrayList) result.get( recCount );


	%>
	<tr onClick="Modify(this);" >
		<%
			for(int colCount=0; colCount<3; colCount++){
				if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
		%>
		<td class="<%=classvalue%>" onmouseover="changeCursor(this);"> 	<font class='HYPERLINK'><%=(String)records.get(colCount)%></font></td>
		<%}else{
			String str = (String)records.get(colCount);			
			if(colCount == 2 )
				str=str.equals("E")?enableGif:disableGif;		
		%>
			<td class="<%=classvalue%>" align='<%=align%>'onclick="disableClick(event);"><%=str%></td>
		  <%}//with out hyper link
		}//loop for all tds
		%>
	</tr>
	<%}//Loop for all records%>
	</table>
	<%
		out.flush();
		} else{
	%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);
	</script>
	<%
		}
		out.println(CommonBean.setForm(request ,"../../eRS/jsp/LicensureQueryResult.jsp", searched));
		}
		catch(Exception e )
		{
			out.println("here in catch"+e);
		}
	%>
</body>
</html>

