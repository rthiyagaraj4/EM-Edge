<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
06/09/2011    IN31901        NijithaS    Incident No: IN31901 - Bru-HIMS-CRF-263		 
-------------------------------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.Common.*,java.util.*, eOR.*,eCommon.XSSRequestWrapper " contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
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
	<!--<script language="Javascript" src="../../eCommon/js/messages.js"></script>-->
	<script language="Javascript" src="../../eOR/js/OrCommon.js"></script>
	<script language="Javascript" src="../../eOR/js/PerformingLocation.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function Modify(obj){
		var locn_type = "";
		var strDisplay = new Array();
		strDisplay[0] = "Departmental Diagnostics";			strDisplay[1] = "Laboratory Site";
		strDisplay[2] = "Radiology Wing";			strDisplay[3] = "Treatment Location";
		strDisplay[4] = "Miscellaneous Service"; 	strDisplay[5] = "Patient Care";
		strDisplay[6] = "Non OT Rooms";//IN31901
		var strLocnType = new Array();
		strLocnType[0]	= 'I';	strLocnType[1]	= 'L';
		strLocnType[2]	= 'R';	strLocnType[3]	= 'T';
		strLocnType[4]	= 'M';	strLocnType[5]	= 'P';
		strLocnType[6]  = 'O';//IN31901
		for (var i=0;i < strDisplay.length;i++)
			if (obj.cells[0].innerText == strDisplay[i]) locn_type = strLocnType[i];

		var code				= obj.cells[1].innerText;
		document.location.href="PerformingLocationAddModify.jsp?mode=2&locn_type="+locn_type+"&code="+code+"&function_id"+parent.function_id;
	}
	</script>
</head>
	
 
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()"  >
<%
	//String function_id = request.getParameter("function_id");
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
    String locn_type  = CommonBean.checkForNull(request.getParameter("locn_type"));
	
    String code  = CommonBean.checkForNull(request.getParameter("code"));
	String long_desc  = CommonBean.checkForNull(request.getParameter("long_desc"));
	String eff_status   = CommonBean.checkForNull(request.getParameter("eff_status"));
	//out.println("####before,eff_status="+eff_status);

	String facility_id = (String)session.getValue("facility_id");

	if(locn_type == null){locn_type = "";}
	if(code == null){code = "";}//else{code = code.toUpperCase().trim();}
	if(long_desc == null){long_desc = "";}//else{long_desc = long_desc.toUpperCase().trim();}
	if(eff_status == null || eff_status.equals("B"))eff_status="";

	boolean searched = request.getParameter( "searched" ) == null ? false : true  ;

	try{
	String classvalue			= "";

	HashMap sqlMap = new HashMap();
	sqlMap.put( "sqlData", OrRepository.getOrKeyValue("SQL_OR_PERFORM_LOCN_SELECT"));

	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	displayFields.add( "performing_deptloc_type" );
	displayFields.add( "performing_deptloc_code" );
	displayFields.add( "performing_deptloc_long_desc" );
	displayFields.add( "performing_deptloc_short_desc" );
	displayFields.add( "eff_status" );
	//displayFields.add( "action_type" );

	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();
	/*out.println("####locn_type="+locn_type+"######");
	out.println("####code="+code+"######");
	out.println("####long_desc="+long_desc+"######");
	out.println("####eff_status="+eff_status+"######");*/
	chkFields.add( locn_type.trim() + "%");
	chkFields.add( code.trim() + "%");
	chkFields.add( long_desc.trim() + "%");
	chkFields.add( facility_id.trim() + "%");
	chkFields.add( eff_status.trim() + "%");
	
	//out.println("####chkFields="+chkFields);

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

		<table class='grid' width="100%" style="text-align:left;">
		<th class='CLOUMNHEADER'><fmt:message key="eOR.PerformingDepartmentLocationType.label" bundle="${or_labels}"/></th> 
		<th class='CLOUMNHEADER'><fmt:message key="eOR.PerformingDepartmentLocationCode.label" bundle="${or_labels}"/></th> 
		<th class='CLOUMNHEADER'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
		<th class='CLOUMNHEADER'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
		<th class='CLOUMNHEADER'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
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
     String strDisplay = "";
					if (records.get(colCount) == null) strDisplay = "&nbsp;";
					else if (colCount == 0) {
						if (((String)records.get(colCount)).equalsIgnoreCase("I")) strDisplay		 = "Departmental Diagnostics";
						else if (((String)records.get(colCount)).equalsIgnoreCase("L")) strDisplay = "Laboratory Site";
						else if (((String)records.get(colCount)).equalsIgnoreCase("R")) strDisplay = "Radiology Wing";
						else if (((String)records.get(colCount)).equalsIgnoreCase("T")) strDisplay = "Treatment Location";
						else if (((String)records.get(colCount)).equals("M")) strDisplay = "Miscellaneous Service";
						else if (((String)records.get(colCount)).equals("P")) strDisplay = "Patient Care";
						else if (((String)records.get(colCount)).equals("O")) strDisplay = "Non OT Rooms";//IN31901
					} else strDisplay = (String)records.get(colCount);
					%>
					<td class="<%=classvalue%>"  onclick="disableClick(event);"><%=strDisplay%></td>
				<%
				}else{
					disp = (String)records.get(colCount);
					%>
					<td class="<%=classvalue%>" align="center"><input type='hidden' value=<%=disp%>></img><%
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
			<%}out.println(CommonBean.setForm(request ,"PerformingLocationQueryResults.jsp", searched));
	}
	catch(Exception e) {
	System.out.print("Exception @ Result JSP :"+e.toString());
	}
	%>
	</body>
	</html>

