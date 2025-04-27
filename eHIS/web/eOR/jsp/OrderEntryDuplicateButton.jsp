<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id 						= request.getParameter("bean_id");
	String bean_name 					= request.getParameter("bean_name");
	String dupl_message				= "";  // For Lab is installed and panel dupl check
	String susp_message				= "";  // For Lab is installed and catalog is suspended
	String rd_appt						= "";
	String called_from_multi					= "";
	String dupMessage				= "";

	/* Initialize Function specific start */
		OrderEntryBean bean		= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(localeName);
	/* Initialize Function specific end */
	HashMap hashValues				= bean.getAllValues();
	
//	String ord_dupl_message			= "";

	int dupl_count_alert			= 0,dupl_count_error=0,conflict_exam_count_records = 0, conflict_records = 0,total_records=0;
	if(hashValues!=null)
	{
		dupl_message		 		= bean.checkForNull((String)hashValues.get("dupl_message"),"");
		susp_message		 		= bean.checkForNull((String)hashValues.get("susp_message"),"");
		rd_appt						= bean.checkForNull((String)hashValues.get("rd_appt"),""); // For Radialogy Appointment
		dupl_count_alert 			= Integer.parseInt(bean.checkForNull((String)hashValues.get("dupl_count_alert"),"0"));
		dupl_count_error 			= Integer.parseInt(bean.checkForNull((String)hashValues.get("dupl_count_error"),"0"));
		conflict_exam_count_records = Integer.parseInt(bean.checkForNull((String)hashValues.get("conflict_exam_count_records"),"0"));
		conflict_records = Integer.parseInt(bean.checkForNull((String)hashValues.get("conflict_records"),"0"));
		total_records = Integer.parseInt(bean.checkForNull((String)hashValues.get("total_count"),"0"));
		called_from_multi = bean.checkForNull((String)hashValues.get("called_from_multi"),"");
		dupMessage = (String)bean.getMessage(localeName,"DUPLICATE_RECORDS_FOUND","OR");
	}
%> 
<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
	<form name ="duplicateFormButton">	
	<%
	if(called_from_multi.equalsIgnoreCase("MULTI_PATIENT_ORDERS"))
	{
	%>
		<table cellpadding=3 cellspacing=0 border='0' align='right' width="100%" id="DuplicateButton" height="100%">
		<tr>
			<td>
				<%=dupMessage%>
			</td>
		</tr>
		<tr>
				<td class="button"  width="100%" style='border-width:0'>
	<%
	}
	else
	{
		if((!susp_message.equals(""))||((conflict_exam_count_records > 0))||((rd_appt.equals("X")))) 
		{ 
		%>
			<table cellpadding=3 cellspacing=0 border='0' align='center' width="100%" id="DuplicateButton">
			<tr>
				<td class="white"  width="100%" style='border-width:0'>
		
		<%
		}  
		else 
		{ 
		%>
			
		<table cellpadding=3 cellspacing=0 border='0' align='center' width="100%" id="DuplicateButton">
		<tr>
			<td>
				<%=dupMessage%>
			</td>
		</tr>
			<tr>
				<td class="white"  width="100%" style='border-width:0'>
	<%
		}
	}
				
	if((dupl_count_error > 0) || (dupl_count_alert > 0)) 
	{ // display the View, cancel buttons
		
		if(called_from_multi.equalsIgnoreCase("MULTI_PATIENT_ORDERS"))
		{
		%>
			<input type="button" name="continue" id="continue" class="BUTTON" value ="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" onClick="insertRecord()">
			<input type="button" name="cancel" id="cancel" class="BUTTON" id="CloseDuplicate" value ="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick="closeDuplicateRecord()">
		<%	
		}
		else
		{
		%>
			<br><input type="button" name="continue" id="continue" class="BUTTON" value ="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Continue.label","common_labels")%>" onClick="proceedInsertions()">
			<input type="button" name="cancel" id="cancel" class="BUTTON" id="CancelDuplicate" value ="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onClick="cancelDuplicateRecord()">
		 <%
		}
	}
	else if(conflict_records >0 || rd_appt.equals("X")) 
	{ 
	%>
		<input type="button" name="continue" id="continue" class="BUTTON" value ="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" onClick="proceedInsertion()">
		<input type="button" name="view" id="view" class="BUTTON" value ="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")%>" onClick="viewDuplicateRecords('')">
		<input type="button" name="cancel" id="cancel" class="BUTTON" id="CancelDuplicate" value ="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onClick="cancelDuplicateRecords()">
	<%
	}  
	%>			
	</td>
	</tr>
	</table>
	
	<%
	if(called_from_multi.equalsIgnoreCase("MULTI_PATIENT_ORDERS"))
	{
	%>
	<table cellpadding=3 cellspacing=0 border='0' align='right' width="100%">
		<tr>
			<td  class='QRY7' width='1%'></td><td  nowrap class='DATA'><font size="1"><fmt:message key="eOR.RejectOrders.label" bundle="${or_labels}"/></font></td>
			<td  class='DISCHARGED' width='2%' ></td><td  nowrap class='DATA'><font size="1"><fmt:message key="eOR.WarningOrders.label" bundle="${or_labels}"/></font></td>
		</tr>
	</table>
	<%
	}
	%>
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
  </form>
</body>
	<script>
		if((<%=total_records%>==<%=dupl_count_error%>) && (<%=dupl_count_error%>==1))
		{
			if(parent.OrderEntryDuplicateButton)
			{
				if(parent.OrderEntryDuplicateButton.duplicateFormButton.CancelDuplicate)
				{
					parent.OrderEntryDuplicateButton.duplicateFormButton.CancelDuplicate.disabled=true;
				}
			}			
		}
	</script>
</html>

