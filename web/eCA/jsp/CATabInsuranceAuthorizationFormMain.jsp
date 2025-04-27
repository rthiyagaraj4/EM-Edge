<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      		Name        		Rev.Date				Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
25/01/2019		IN057997			Kamalakannan G	  		25/01/2019				Ramesh G.		AAKH-CRF-0079
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>

<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eCA.*, eCA.Common.*, eCommon.Common.*,java.text.DecimalFormat,java.sql.*,webbeans.eCommon.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title><fmt:message key="eCA.InsuranceAuthorizationForm.label" bundle="${ca_labels}"/></title>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
			<iframe name="f_query_criteria" id="f_query_criteria" frameborder="0" scrolling="no" noresize src="../../eCA/jsp/CATAbInsuranceAuthorizationFormCriteria.jsp" style="height:10%;width:100vw"></iframe><iframe name="f_query_result" id="f_query_result" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:*%;width:100vw"></iframe><iframe name="f_query_print" id="f_query_print" SCROLLING="NO" FRAMEBORDER="0" NORESIZE SRC="../../eCA/jsp/CAInsuranceAuthorizationFormPrint.jsp" style="height:10%;width:100vw"></iframe>		
</html>

