<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
22/09/2023	  28906	   Ranjith P R		25/07/2023		RAMESH G		ML-MMOH-CRF-1846.1
---------------------------------------------------------------------------------------------------------------
*/
%> 
<!--28906 starts -->
<%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCA.*,eCA.Common.*" %>
<html>
<head>
	 <%
	  request.setCharacterEncoding("UTF-8");
	  String sStyle =

		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
    
    <script language='javascript' src='../../eCommon/js/common.js'></script>
	<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script src="../../eCA/js/ResearchPatient.js" language="javascript"></script>
	<script src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title> <fmt:message key="Common.PhenotypeDetails.label" bundle="${common_labels}"/> </title>

</head>
<body  class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown="lockKey()" >
<%
	Properties p;
	session 		= request.getSession(false);
	p 				= (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale 	= (String) p.getProperty("LOCALE");
	String classValue="gridData";
	String patient_id	=request.getParameter("patient_id");
	String bean_id = "PhenotypeDetailsBean";
	String bean_name = "eCA.PhenotypeDetailsBean";
	PhenotypeDetailsBean bean = (PhenotypeDetailsBean)getBeanObject(bean_id,bean_name,request) ; 
	ArrayList searchData = new ArrayList();		
	searchData = bean.getPhenotypeDetails(p,locale,patient_id);

%>

		<!-- <div id='divDataTitle' style='postion:relative'> -->
		<table width='100%' id='dataTitleTable' class='grid' align='center' >
			<TR>
				<td class='COLUMNHEADERCENTER' width='20%'><fmt:message key="Common.Type.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADERCENTER' width='20%'><fmt:message key="Common.PhenotypeCode.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADERCENTER' width='20%'><fmt:message key="Common.PhenotypeDescription.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADERCENTER' width='20%'><fmt:message key="Common.ResultDateandTime.label" bundle="${common_labels}"/></td>
			</TR>
	
		<%
		for(int i=0;i<searchData.size();i++){
			HashMap<String,String>  resultMap= new HashMap<String,String>();
			resultMap = (HashMap<String,String>)searchData.get(i);
			
%>
<tr>
			<td style="text-align: left" class='<%=classValue %>'><%=(String)resultMap.get("TYPE")%></td>
			<td style="text-align: left" class='<%=classValue %>'><%=(String)resultMap.get("PHENOTYPE_CODE")%></td>
			<td style="text-align: left" class='<%=classValue %>'><%=(String)resultMap.get("PHENOTYPE_DESCRIPTION")%></td>
			<td style="text-align: left" class='<%=classValue %>'><%=(String)resultMap.get("RESULT_DATE")%></td>
			</tr>
	<% 	

	} 
	
%>

</td></tr>
</table>
</body>
</html>
<!--28906 ends  -->

