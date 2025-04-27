<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%
/*
--------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
	?			?				?			?				?					?
21/02/2014    IN058341     Ramesh G      Akbar			05/11/2015			Alpha - CIS - OR - Record Refusal - System displays "null" in Source Type & Source field.
-------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>
 
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>

<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%> 

<html>
<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/RefusalOrders.js"></script> 
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
	<!--<script language="JavaScript" src="../js/OrMessages.js"></script>
	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
 <script>
  </script>

	
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<table >
			<%
					request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
					String patientId=request.getParameter("patientid");
		
								boolean searched = request.getParameter( "searched" ) == null ? false : true  ;

								String classvalue			= "";

	HashMap sqlMap = new HashMap();
	sqlMap.put( "sqlData", OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER_VISIT_TIME"));

	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	displayFields.add("encounter_id");
	displayFields.add("facility_name" );
	displayFields.add("assign_care_locn_type" );
	displayFields.add("assign_care_locn_code" );
	displayFields.add("visit_adm_date_time" );
	ArrayList chkFields = new ArrayList();
	
	chkFields.add(localeName);
	chkFields.add(localeName);
	chkFields.add(localeName);
	chkFields.add(localeName); //IN058341
	chkFields.add(patientId);
	
	//Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );
	//Calling the Result from Common Adaptor as a arraylist.(sqlMap, funcMap, request,false)
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);

if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<table cellpadding=0 cellspacing=0 width="100%" align="center">
		<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;
	<%
		//For display the previous/next link
	     out.println(result.get(1));
	%>
		</td></tr>
		</table>

		<table border="" cellpadding="0" cellspacing="0" width="100%" align="center" class="grid">
		<tr>
		<td class='COLUMNHEADER' width="20%"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width="20%"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width="20%"><fmt:message key="Common.SourceType.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width="20%"><fmt:message key="Common.source.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width="20%"><fmt:message key="eOR.VisitAdmTime.label" bundle="${or_labels}"/></td>
		</tr>
	<%
			

        for(int recCount=2; recCount<result.size(); recCount++) {
          /*  if ( recCount % 2 == 0 )
                classvalue = "QRYODD" ;
            else
                classvalue = "QRYEVEN" ;*/
				classvalue="gridData";
    %>
            <tr >
		
		<%
		//Retriving the records from result arraylist

		ArrayList records=new ArrayList();
		 //  String link_columns = "1";

            records=(ArrayList) result.get( recCount );
          //System.err.println("in the records"+records);

			for(int colCount=0; colCount<records.size(); colCount+=5){
    %>

            <td class="<%=classvalue%>" onclick="disableClick(event);"><a class='gridLink' href='#'   onClick="displayEncounterDetails('<%=(String)records.get( colCount )%>','<%=(String)records.get( colCount+4 )%>');"><%=(String)records.get( colCount )%></a></td>
		<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><%=(String)records.get( colCount+1 )%></td>
		<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><%=(String)records.get( colCount+2)%></td>
		<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><%=(String)records.get( colCount+3)%></td>
		<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><%=com.ehis.util.DateUtils.convertDate((String)records.get( colCount+4 ),"DMYHM","en",localeName)%></td>

<%
		}
		}
%>
</table>
<%
	 }
else
{
	%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));</script>
	<script>parent.parent.document.getElementById("dialog_tag").close()</script>
		
<%
}
 %>
</form>
<%
out.println(CommonBean.setForm ( request ,"../../eOR/jsp/RefusalOrderEncounterResult.jsp", searched) );
%>
</body>
</html>
	

