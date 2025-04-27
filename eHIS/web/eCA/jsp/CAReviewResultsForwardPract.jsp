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
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      	Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
22/04/2016	IN059255			Karthi L							 			ML-MMOH-CRF-0329.1
------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script src="../../eCA/js/CAChartSummaryLabNotify.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body   onMouseDown="CodeArrest()" onKeyDown="lockKey()" onscroll='moveFrame()'>     <%--onload='FocusFirstElement()' --%>
<%
	
	/* Mandatory checks start */
	String mode	   = "1";//request.getParameter( "mode" ) ;

	String bean_id = "Or_ReviewResults" ;
	String bean_name = "eOR.ReviewResults";

	String ca_practitioner_id = (String)session.getValue("ca_practitioner_id");
	String resp_id = (String)session.getValue("responsibility_id");
    String user_id = (String)session.getValue("login_user");
	String search_by =(request.getParameter("search_by")==null)?"":request.getParameter("search_by");
	String search_criteria =(request.getParameter("search_criteria")==null)?"":request.getParameter("search_criteria");

	String[] searchArray = new String[2];
	searchArray[0] = search_by;
	searchArray[1] = search_criteria;

	if(resp_id== null)resp_id = "";
	if (user_id == null) user_id = "";

	



	String practitioner_name    = CommonBean.checkForNull(request.getParameter("practitioner_name"));

	ArrayList allValues = new ArrayList();
	/* Mandatory checks end */

	/* Initialize Function specific start */
	ReviewResults bean = (ReviewResults)getBeanObject( bean_id,bean_name , request) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	
	bean.setMode( mode ) ;

	allValues		= bean.getAllPractitionerDetails(practitioner_name,ca_practitioner_id,searchArray);

	
/* Initialize Function specific end */
	if(allValues.size() == 0){
%>
		<script>
			alert('APP-002415 Query caused No records to be retrieved...');
			searchbutton();
			parent.ReviewResultsForwardPractHeader.location.href = "../../eCommon/html/blank.html"
			parent.ReviewResultsForwardPract.location.href = "../../eCommon/html/blank.html"
			parent.ReviewResultsForwardPractBtn.location.href = "../../eCommon/html/blank.html" 
		</script>

<%	}%>

<form name="review_results_forward_pract_dtl" id="review_results_forward_pract_dtl" target="messageFrame">
<table cellpadding=3 cellspacing=0 border=1 width="100%" id='detailTab' class="grid">
<%

	//String disp_value      = "";
	String slClassValue    = "";
	String pract_id        = "";
	String pract_name      = "";

	for(int i=0; i<allValues.size(); i++){
        String[] record  = (String[])allValues.get(i);

		pract_id				=CommonBean.checkForNull(record[0]);
		pract_name				=CommonBean.checkForNull(record[1]);

		/*if(i % 2 == 0){
			slClassValue = "QRYEVEN";
		}else{
			slClassValue = "QRYODD";
		}*/
		slClassValue="gridData";
	    //disp_value = "&nbsp;";

%>
        <TR>
			<td width='5%' class='<%=slClassValue%>'><input type=checkbox name='chk<%=i%>' id='chk<%=i%>' value='Y' onclick="chk(this);"></td>
            <td width='30%' class='<%=slClassValue%>'><font size=1><%=pract_id%></font><Input name='pract_id<%=i%>' id='pract_id<%=i%>' type='hidden' value='<%=pract_id%>'></td>
			<td width='65%' class='<%=slClassValue%>'><font size=1><%=pract_name%></font><Input name='pract_name<%=i%>' id='pract_name<%=i%>' type='hidden' value='<%=pract_name%>'></td>
		</TR>
		<script>
parent.ReviewResultsForwardPractHeader.location.href = "../../eCA/jsp/CAReviewResultsForwardPractHeader.jsp"			
parent.ReviewResultsForwardPractBtn.location.href = "../../eCA/jsp/CAReviewResultsForwardPractBtn.jsp" 
	</script>
<%  }%>
<tr style='visibility:hidden'>
<Td class=columnheader><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></Td>
<Td class=columnheader><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></Td>
<Td class=columnheader><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></Td></tr>
</table>

<input type=hidden name='total_recs' id='total_recs' value='<%=allValues.size()%>'>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="function_id" id="function_id" value="<%//=bean.getFunctionId()%>">
<input type=hidden name='practitioner_id' id='practitioner_id' value='<%=ca_practitioner_id%>'>
<input type="hidden" name="called_from" id="called_from" value="INSERT_FORWARD_PRACT">
<script>
if(parent.ReviewResultsForwardPractHeader.document.getElementById("detailHeader")==null)
{
	setTimeout("alignHeading();",300);
}
else 
	alignHeading();
</script>
</form>
</body>
</html>
<%
if(allValues.size() != 0){
%>
<script>searchbutton();</script>
	<%}%>
<%
putObjectInBean(bean_id,bean,request);
%>

