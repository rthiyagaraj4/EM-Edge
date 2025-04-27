<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<jsp:useBean id="bean" scope="page" class="eOR.OrderEntryQueryBean"/>
<%-- Mandatory declarations end --%>
<%
	/*
	 *  Common to make the Button enable or disable
	 */
	 			bean.setLanguageId(localeName);

	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	 Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
	String patient_id				= request.getParameter("patient_id");
	String encounter_id				= request.getParameter("episode_id");
	String bean_id 					= "@accessrightbean"+patient_id+encounter_id;
	String bean_name 				= "eOR.Common.AccessRightBean";
	/* Mandatory checks end */
	/* Initialize Function specific start */
		//AccessRightBean bean 		= (AccessRightBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	//	AccessRightBean bean		= (AccessRightBean)getBeanObject( bean_id, bean_name, request ) ;
	//	bean.clear();
	/* Initialize Function specific end */
 
	String responsibility_id		= (String) session.getValue("responsibility_id");
	String relationship_id			= bean.checkForNull(request.getParameter("relationship_id"),"");
	String p_called_from_ca			= bean.checkForNull(request.getParameter("p_called_from_ca "),"");
	String allergy_display_yn 		= "";
	String active_display_yn 		= "";
	String demography_display_yn 	= "";
%>
<html>
	<head>
		<title></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>

		<script language="JavaScript" src="../../ePH/js/PrescriptionTest.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!-- Used for Prescription -->

	</head>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="OrCommonForm" id="OrCommonForm">
<%
		// To check whether the user has access to view or not , other wise button gets disabled
		if(p_called_from_ca.equals("Y"))
		{
			allergy_display_yn 		= bean.getMenu("ALLERGY_LST",responsibility_id,relationship_id, properties);
			active_display_yn 		= bean.getMenu("PROBLEM_LST",responsibility_id,relationship_id, properties);
			demography_display_yn 	= bean.getMenu("DEMOGRAPY_VIEW",responsibility_id,relationship_id, properties);
		}
%>
		<table border="0" cellpadding="3" cellspacing="0" width="100%">
		<tr>
			 <td class="label" width="100%" ><input type="button" name="allergies" id="allergies" class="BUTTON" value ="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Allergies.label","common_labels")%>" onClick='callAllergies("<%=patient_id%>")' <%if(allergy_display_yn.equals("X")) out.println("DISABLED");%>  ><input type='button' name='active' id='active' class='BUTTON' value ='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ActiveProblems.label","common_labels")%>' onClick='callActive("<%=patient_id%>","<%=encounter_id%>")' <%if(active_display_yn.equals("X")) out.println("DISABLED");%>><input type='button' name='demographic' id='demographic' class='BUTTON' value ='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Demographics.label","common_labels")%>' onClick='callDemographic("<%=patient_id%>")' <%if(demography_display_yn.equals("X")) out.println("DISABLED");%>></td>
	       </tr>
		</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="module_id" id="module_id" value=""><!-- Used to identify from which tab(Lab,Radiology,Treatment) it is currently used,  -->
			<input type="hidden" name="ph_load_yn" id="ph_load_yn" value=""><!-- Used by Pharmacy Module(To identify if it is coming inside the Pharmacy Orders,first time) -->
			<input type="hidden" name="ph_priority" id="ph_priority" value=""><!-- Used by Pharmacy Module(To identify if it is coming inside the Pharmacy Orders,first time) -->
			<input type="hidden" name="ph_order_date_time" id="ph_order_date_time" value=""><!-- Used by Pharmacy Module(To identify if it is coming inside the Pharmacy Orders,first time) -->
	</form>
</body>
</html>
<%
	// set it back persistence (NO set methods)
	//putObjectInBean(bean_id,bean,request);

%>

