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
-----------------------------------------------------------------------
Date			Edit History	Name        Description
-----------------------------------------------------------------------
?				100         	?     		created	 
09/11/2012		IN030473		Ramesh G	Bru-HIMS-CRF-032 								 
16/12/2013		IN036697				Ramesh G	Special Characters Issue							 
-----------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*" %> 
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
	<head>
	<%
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	String patientId=(String)request.getParameter("patient_id")==null?"":(String)request.getParameter("patient_id");
	String encounterId=(String)request.getParameter("encounter_id")==null?"":(String)request.getParameter("encounter_id");
	String facilityId=(String)request.getParameter("facility_id")==null?"":(String)request.getParameter("facility_id");
	String interventionId=(String)request.getParameter("intervention_id")==null?"":(String)request.getParameter("intervention_id");
	String consentformId=(String)request.getParameter("consentform_id")==null?"":(String)request.getParameter("consentform_id");
	
	String bean_id = "Or_InterventionOrdersBean" ;
	String bean_name = "eOR.InterventionOrdersBean";
	InterventionOrdersBean bean = (InterventionOrdersBean)getBeanObject( bean_id,  bean_name ,request ) ;
	bean.setLanguageId(localeName);  //[IN036697]
	String displayContent="";
	displayContent = bean.getInterventionFormContent(patientId,encounterId,facilityId,interventionId,consentformId);
	
	%>	
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	</head>
	<body>
		<form name="PatientInterventionsDetailsForm" id="PatientInterventionsDetailsForm">
			<table  border='2' align="center" width='100%' height="100%" cellpadding='0' cellspacing='0'>
				<tr>
					<td width="100%" valign="top">
						<%=displayContent%>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

