<!DOCTYPE html>
<%/*
Sr No        Version           Incident        SCF/CRF                     		Developer Name
-----------------------------------------------------------------------------------------------
 1			V230210								MMS-DM-CRF-0209.5			Namrata Charate
*/ %>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>	
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String mul_fact_ded_rule_YN = request.getParameter("mul_fact_ded_rule_YN");
	if(mul_fact_ded_rule_YN==null || mul_fact_ded_rule_YN.equals("")) mul_fact_ded_rule_YN="N";
	System.err.println("params in BLParametersInsMain.jsp:"+mul_fact_ded_rule_YN);

	String drug_cat_YN = request.getParameter("drug_cat_YN");
	if(drug_cat_YN == null) drug_cat_YN = "N";
	String diag_cat_YN = request.getParameter("diag_cat_YN");
	if(diag_cat_YN == null) diag_cat_YN = "N";
	String service_items_YN = request.getParameter("service_items_YN");  //V230210
	if(service_items_YN == null) service_items_YN = "N";  //V230210
	
	String queryString = "../../eBL/jsp/BLParametersInsTabs.jsp?mul_fact_ded_rule_YN="+mul_fact_ded_rule_YN+"&drug_cat_YN="+drug_cat_YN+"&diag_cat_YN="+diag_cat_YN+"&service_items_YN="+service_items_YN; //V230210
%>
<iframe name='InsTabsFrame' id='InsTabsFrame' src="<%=queryString%>" frameborder=0 scrolling='no' style='height:12vh;width:100vw'></iframe>
<iframe name='InsTabsDataFrame' id='InsTabsDataFrame' src='../../eCommon/html/blank.html' frameborder=0 style='height:78vh;width:100vw'></iframe>
</html>

