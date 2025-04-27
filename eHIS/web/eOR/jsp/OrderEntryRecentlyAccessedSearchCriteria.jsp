<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>
<%-- Mandatory declarations end --%>
<%
	//String patient_id				= request.getParameter("patient_id");
	//String encounter_id			= request.getParameter("encounter_id");
	//out.println("==patient_id+"+patient_id+"==encounter_id+"+encounter_id);

		 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

	String bean_id 					= request.getParameter("bean_id");
	String bean_name 				= request.getParameter("bean_name");
	//String disableOrderCategory	= "";
	//String disableOrderType		= "";
	/* Mandatory checks end */
	/* Initialize Function specific start */
		//OrderEntryBean bean 		= (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
		beanQueryObj.setLanguageId(localeName);
		 OrderEntryBean bean		= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
		 bean.setLanguageId(localeName);

	/* Initialize Function specific end */
	String ammend_called_from		= bean.checkForNull(request.getParameter("ammend_called_from"),"");
 	String function_from			= bean.checkForNull(request.getParameter("function_from"),"");
	String search_by				= bean.checkForNull(request.getParameter("search_by"),"");
	// By Default 10 Occurances
	String no_of_occurances			= bean.checkForNull(request.getParameter("no_of_occurances"),"10");
  	//String practitioner_name		= (String) session.getValue("practitioner_name");
   	String patient_name				= "";
	ArrayList Nationality			= bean.getNationality(bean.getPatientId());// Get the patient_name

   	if(Nationality!=null && Nationality.size() > 0)
   	{
   	    patient_name				= (String)Nationality.get(1); // Get the patient_name
   	}
	Nationality						 = null;				// Nullifying the objects
 %>
<html>
<head><title><fmt:message key="eOR.OrderEntryCriteriaHeader.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
 	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>	<!-- for Preview Button -->
 	<script language="JavaScript" src="../js/OrderEntryRapidPreview.js"></script>
 	<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="recentlyAccessedCriteriaForm" id="recentlyAccessedCriteriaForm" title="Additional Search" onKeyPress="lockEnterKey()">
		<table class="BOX"   class="cellpadding="3" cellspacing="0" border="0" width="100%" align="center" >
		<tr>
		 	<th colspan="5" ><%
		if(search_by.equals("practitioner")) { 
%>
			<fmt:message key="eOR.FrequentOrdersPlacedby.label" bundle="${or_labels}"/>:  <%=bean.getPractitionerName()%>
<%		}  else { %> <!-- For Patients -->
			<fmt:message key="eOR.FrequentOrdersPlacedfor.label" bundle="${or_labels}"/> : <%=patient_name%>
<%		} %>
			</th>
		</tr>
		<tr>
<%	if(!(search_by.equals("patient")))  { %>
		 	<td class="label" ><fmt:message key="eOR.Occurance.label" bundle="${or_labels}"/></td>
			<td class="label">
				<input type="text" name="no_of_occurances" id="no_of_occurances" value = "<%=no_of_occurances%>" size="3" maxlength="3" onKeyPress="ChkNumberInput(this,event,'0');">
 			</td>
<%	} %>
			<td class="label"   colspan="4">
<%	if(!(search_by.equals("practitioner")))  { %>
 				<input type="button" class="BUTTON" name="Search" id="Search" value = "Search" onClick="getRecentResult()" TITLE="Frequent Orders"> 
<%	} %>
<%	if (!function_from.equals("AMEND_ORDER") && !function_from.equals("MULTI_PATIENT_ORDERS") && !(search_by.equals("practitioner")) ) { %>
				<input type="button" class="button" name="preview" id="preview" value=" Preview " onClick="rapidPreview()" TITLE="Preview">
<%		} %>
			</td>

		 
		</tr>
		</table>

		 
 		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
		<input type="hidden" name="ammend_called_from" id="ammend_called_from" value="<%=ammend_called_from%>">
		<input type="hidden" name="function_from" id="function_from" value="<%=function_from%>">
		<input type="hidden" name="query_string" id="query_string" value="<%=request.getQueryString()%>">
		<input type="hidden" name="search_by" id="search_by" value="<%=search_by%>">
	</form>
</body>
</html>


<%
	// no need to  set it back persistence
	//putObjectInBean(bean_id,bean,request);	
%>

