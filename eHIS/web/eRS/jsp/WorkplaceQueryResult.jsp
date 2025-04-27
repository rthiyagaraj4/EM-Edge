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
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<!-- <script language='javascript' src='../../eCommon/js/messages.js'></script> -->
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonResult.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- <script language="javascript" src="../js/RSMessages.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<script>
	function Modify(obj){
		var workplace_code						= obj.cells[0].innerText;
document.location.href="../../eRS/jsp/WorkplaceAddModify.jsp?mode=2&workplace_code="+workplace_code;
}
</script>
<BODY class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String classvalue = "";
	/*----- Required while Selecting sql and Formatting display------*/
	String enableGif ="<div align='center'><img align='center' src='../../eCommon/images/enabled.gif'></img></div>" ;
	String disableGif ="<div align='center'><img src='../../eCommon/images/RRnwd.gif'></img></div>" ;
	try{
    	String facilityId = (String) session.getValue( "facility_id" );

		String workplace_code = request.getParameter("workplace_code");		
		String workplace_desc = request.getParameter("workplace_desc");
		String locn_type = request.getParameter("locn_type");
		String eff_status	 =	 request.getParameter("eff_status");

boolean searched			= request.getParameter( "searched" ) == null? false : true  ;
	
		if(workplace_code==null )
			workplace_code ="";
		else 
			workplace_code = workplace_code.trim(); 
		if(workplace_desc==null )
			workplace_desc="";
		else
			workplace_desc = workplace_desc.trim();
		if(locn_type==null )
			locn_type="";
		else
			locn_type = locn_type.trim();
		if(eff_status==null )
			eff_status="";
		else
			eff_status = eff_status.trim();

		//Common parameters.
		HashMap sqlMap = new HashMap();
		//include all the common parameters.
		//String SelectSql="select a.workplace_code,a.workplace_desc,b.short_desc,a.staff_util_review_opt,a.eff_status from rs_workplace a , am_care_locn_type b where a.locn_type = b.locn_type(+) and a.facility_id  = ? and upper(a.workplace_code) like  upper(?) and upper(a.workplace_desc) like  upper(?) and upper(nvl(a.locn_type,'%')) like  upper(?) and upper(a.eff_status) like  upper(?)";
		String SelectSql="SELECT a.workplace_code,a.workplace_desc,b.short_desc,a.staff_util_review_opt,a.eff_status FROM rs_workplace_lang_vw a , am_care_locn_type_lang_vw b WHERE a.locn_type = b.locn_type(+) AND a.facility_id  = ? AND UPPER(a.workplace_code) LIKE  UPPER(?) AND UPPER(a.workplace_desc) LIKE  UPPER(?) AND UPPER(NVL(a.locn_type,'%')) LIKE  UPPER(?) AND UPPER(a.eff_status) LIKE  UPPER(?) and a.language_id = ? and b.language_id = a.language_id";

		sqlMap.put( "sqlData",SelectSql);

		//The fields are going to be display.
		ArrayList displayFields = new ArrayList();
		displayFields.add("WORKPLACE_CODE" );
		displayFields.add("WORKPLACE_DESC");
		displayFields.add("SHORT_DESC");
		displayFields.add("STAFF_UTIL_REVIEW_OPT");
		displayFields.add("EFF_STATUS");

		//The fields are going to be in where condition * shld match with the qry//
		ArrayList chkFields = new ArrayList();
		chkFields.add(facilityId);
		chkFields.add(workplace_code+"%" );
		chkFields.add(workplace_desc+"%" );
		chkFields.add(locn_type+"%" );
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
<th><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></th>
<th><fmt:message key="eRS.StaffReviewOption.label" bundle="${rs_labels}"/></th>
<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
</tr>
	<%
	//------------Retriving the records from result arraylist------------------//
	ArrayList records=new ArrayList();
	for(int recCount=2; recCount<result.size(); recCount++) {
		if ( recCount % 2 == 0 )
			classvalue = "QRYEVEN" ;
		else
			classvalue = "QRYODD" ;
		String link_columns = "1";
		String align="";
		 records=(ArrayList) result.get( recCount );
	%>
	<tr onClick="Modify(this);" >
		<%
			for(int colCount=0; colCount<5; colCount++){
				if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
		%>
		<td class="<%=classvalue%>" onmouseover="changeCursor(this);"> 	<font class='HYPERLINK'><%=(String)records.get(colCount)%></font></td>
		<%}else{
			String str = (String)records.get(colCount)==null?"&nbsp;":(String)records.get(colCount);			
			if(colCount == 4 )
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
		out.println(CommonBean.setForm(request ,"../../eRS/jsp/WorkplaceQueryResult.jsp", searched));
		}catch(Exception e ){
			out.println("here in catch"+e);
		}
	%>
</body>
</html>

