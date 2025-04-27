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
-------------------------------------------------------------------------------------------------------
Date			Edit History		Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------
12/02/2018		IN066055		Raja S			12/02/2018		Ramesh 			ML-MMOH-CRF-0891.2
25/05/2022		31686			Pranay			25/05/2022		Ramesh			NMC-JD-SCF-0287
-------------------------------------------------------------------------------------------------------
*/

%>
 <!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,org.apache.commons.codec.binary.Base64,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
 
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/><!--IN066055-->
<html>                                
	<head>                                
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		////IN066055 starts
		beanQueryObj.setSiteSpecific("EXTERNAL_PH");//IN066055
		boolean isExternalPHEnabled = beanQueryObj.isSiteSpecific("EXTERNAL_PH");
		//IN066055 ends
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<!--<script language="javascript" src="../js/PhCommon.js"></script>-->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
		String called_frm = request.getParameter("called_frm");
		String mode = request.getParameter("mode");
		if(!called_frm.equals("")) {
%>
			<title><fmt:message key="ePH.PatientDrugProfile.label" bundle="${ph_labels}"/></title>
<%
		}else{
			%>
			<title><fmt:message key="ePH.DrugProfile.label" bundle="${ph_labels}"/></title>
			<% 
		}
%>
	</head>                               
<%
		String patient_id = request.getParameter("patient_id");
		String disp_locn_code = request.getParameter("disp_locn_code");
		String pat_class		= request.getParameter("pat_class");
		String user_id = (String)session.getValue("login_user");//IN066055
		String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id"); // encounter_id added for AAKH-CRF-0088.2
		String enc_id1 = request.getParameter("enc_id1")==null?"":request.getParameter("enc_id1");//Added for MMS-DM-CRF-115.4
		String ReqDb	    =	request.getParameter("RepDb")==null?"":request.getParameter("RepDb");//Added for MMS-DM-CRF-115.4
		String called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");//Added for MMS-DM-CRF-115.4
		//31686  Start
		String compressed = request.getParameter("compressed")==null?"N":(String)request.getParameter("compressed");
		if("Y".equals(compressed)){
			patient_id = new String(Base64.decodeBase64(((String)request.getParameter("patient_id")).getBytes()));
			encounter_id = new String(Base64.decodeBase64(((String)request.getParameter("encounter_id")).getBytes()));
		}
		//31686 End.
		//isExternalPHEnabled = false;REMOVED FOR ML-MMOH-SCF-1313
		//IN066055 starts
		if(isExternalPHEnabled)
		{
			mode="GenerateExtURL";
			called_frm="PHIS_CLINICAL_SUMMARY";
			String source =  "../../eOR/jsp/PlaceOrderIntermediate.jsp?user_id="+user_id+"&patient_id="+patient_id+"&extph_function_id="+called_frm+"&Mode="+mode+"&encounter_id="+encounter_id; 
			%>
				<iframe name="f_query_criteria" id="f_query_criteria" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:17vh;width:100vw"></iframe>
			</html>
			
			<%
		}
		else
		{
		//IN066055 ends
		String source =  "../../ePH/jsp/QueryPatientDrugProfileCriteria.jsp?patient_id="+patient_id+"&called_frm="+called_frm+"&disp_locn_code="+disp_locn_code +"&pat_class="+pat_class+"&mode="+mode+"&encounter_id="+encounter_id+"&enc_id1="+enc_id1+"&ReqDb="+ReqDb+"&called_from="+called_from; // encounter_id added for AAKH-CRF-0088.2//Added called_from,enc_id1,ReqDb for MMS-DM-CRF-115.4
%>
	<iframe name="f_query_criteria" id="f_query_criteria" frameborder="0" scrolling="yes" noresize src="<%= source %>" style="height:20vh;width:100vw"></iframe>
	<iframe name="f_query_result" id="f_query_result" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:68vh;width:100vw"></iframe>
	<iframe name="f_query_status" id="f_query_status" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:10vh;width:100vw"></iframe>
</html>
		<%}%>

