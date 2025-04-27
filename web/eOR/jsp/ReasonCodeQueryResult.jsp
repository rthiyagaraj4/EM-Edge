<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
	<head>
	<title></title>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>

	<script language="Javascript" src="../../eOR/js/OrCommon.js"></script>
	<script language="Javascript" src="../../eOR/js/ReasonCode.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function Modify(obj){
	var action_type			= obj.cells[0].innerText;
	var action_reason_code	= obj.cells[1].innerText;
	var action_reason_desc	= obj.cells[2].innerText;
	var action_description	= obj.cells[3].innerText;
	var eff_status          = obj.cells[4].children[0].value;

		document.location.href="../../eOR/jsp/ReasonCodeAddModify.jsp?mode=2&action_type="+action_type+"&action_reason_code="+action_reason_code+"&action_reason_desc="+encodeURIComponent(action_reason_desc)+"&eff_status="+eff_status+"&function_id"+parent.function_id;
}
	</script>
</head>
 
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()"  >
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

	//String function_id = request.getParameter("function_id");
    String action_type  = request.getParameter("reason_type");
    String action_reason_code  = request.getParameter("reason_code");
	String action_reason_desc  = request.getParameter("reason_desc");
	String action_description  = request.getParameter("reason_short_desc");
	String eff_status   = request.getParameter("eff_status");

	if(action_type != null){action_type = action_type.trim();}
	if(action_type == null){action_type = "";}else{action_type = action_type.toUpperCase().trim();}
	if(action_reason_code == null){action_reason_code = "";}else{action_reason_code = action_reason_code.toUpperCase();}
	if(action_reason_desc == null){action_reason_desc = "";}else{action_reason_desc = action_reason_desc.toUpperCase().trim();}
	if(action_description == null){action_description = "";}else{action_description = action_description.toUpperCase().trim();}
	if(eff_status == null || eff_status.equals("B"))eff_status="";

	boolean searched = request.getParameter( "searched" ) == null ? false : true  ;

	try{
	String classvalue			= "";

	HashMap sqlMap = new HashMap();
	sqlMap.put( "sqlData", OrRepository.getOrKeyValue("SQL_OR_REASON_CODE_QUERY_RESULT"));

	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	displayFields.add( "action_type" );
	displayFields.add( "action_reason_code" );
	displayFields.add( "action_description" );
	displayFields.add( "action_reason_desc" );
	displayFields.add( "eff_status" );
	//displayFields.add( "action_type" );

	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();
	chkFields.add( action_type + "%");
	chkFields.add( action_reason_code + "%");
	chkFields.add( action_description + "%");
	chkFields.add( action_reason_desc + "%");
	chkFields.add( eff_status + "%");

	//Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.(sqlMap, funcMap, request,false)
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);

	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<table cellpadding=3 cellspacing=0 width="100%" align="center">
		<tr>
		<td class=label></td>
		<td class=label>
	<%
		//For display the previous/next link
	     out.println(result.get(1));
	%>
		</td></tr>
		</table>

		<table class='grid' width="100%">
		<th class='columnheader' style="text-align:left;"><fmt:message key="eOR.ReasonType.label" bundle="${or_labels}"/></th>
		<th class='columnheader' style="text-align:left;"><fmt:message key="Common.ReasonCode.label" bundle="${common_labels}"/></th>
		<th class='columnheader' style="text-align:left;"><fmt:message key="Common.reason.label" bundle="${common_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
		<th class='columnheader' style="text-align:left;"><fmt:message key="eOR.ReasonText.label" bundle="${or_labels}"/></th>
		<th class='columnheader' style="text-align:left;"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
		<%
		//Retriving the records from result arraylist

		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "gridData" ;
			else
				classvalue = "gridData" ;
		%>
			<tr onClick="Modify(this);" >
		<%
		String link_columns = "2", disp ="";
		records=(ArrayList) result.get( recCount );

		for(int colCount=0; colCount<records.size(); colCount++){
			if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){%>
			<td class="<%=classvalue%>" onmouseover="changeCursor(this);"><a class='gridLink' href='#'><%=(String)records.get(colCount)%> </a></td>
			<%}else{
				if(colCount != 4){
					%>
					<td class="<%=classvalue%>"  onclick="disableClick(event);" style="word-break: break-all; max-width: 200px; overflow-wrap: break-word;"><%
					out.println((String)records.get(colCount)==null ? "&nbsp;" :(String)records.get(colCount));
				%></td>
				<%
				}else{
					disp = (String)records.get(colCount);
					%>
					<td class="<%=classvalue%>" onclick="disableClick(event);"><input type='hidden' value=<%=disp%>></img><%
					if(disp.equals("E")){%><img src="../../eCommon/images/enabled.gif"></img><%}else if(disp.equals("D")){%><img src="../../eCommon/images/disabled.gif"></img> <%}%></td>

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
			<%}out.println(CommonBean.setForm(request ,"../../eOR/jsp/ReasonCodeQueryResult.jsp", searched));
	}
	catch(Exception e) {
	System.out.print("Exception @ Result JSP :"+e.toString());
	}
	%>
	</body>
	</html>

