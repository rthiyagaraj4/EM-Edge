<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,eBL.* " %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>

<%
String params = request.getQueryString();
System.err.println("Params in rule frame:"+params);
String from	= request.getParameter("from")== null ? "DiagnosisCategoryDetails" : request.getParameter("from"); 
String rowS = "90%, 10%";

	String drugCatTabYN = "N";
	String diagCatTabYN = "N";
	String disabled = "";

	
	Connection con = null;
	ResultSet rst = null;
	PreparedStatement pstmt = null;
	String facility_id = (String)session.getAttribute("facility_id");
			
	try{
			
		con = ConnectionManager.getConnection(request);
		
		String qry_MFDRMandYN = "select NVL(MFDR_DRUG_CAT_APPL_YN,'N') MFDR_DRUG_CAT_APPL_YN, NVL(MFDR_DIAG_CAT_APPL_YN,'N') MFDR_DIAG_CAT_APPL_YN from bl_parameters where OPERATING_FACILITY_ID = '"+facility_id+"'";
	
		pstmt = con.prepareStatement(qry_MFDRMandYN);
		rst = pstmt.executeQuery();
					
		if(rst != null){
			while(rst.next()) {
				drugCatTabYN = rst.getString("MFDR_DRUG_CAT_APPL_YN");
				diagCatTabYN = rst.getString("MFDR_DIAG_CAT_APPL_YN");
				}
			}
	
		//V221017
		}catch(Exception e){
			System.err.println("Exception is: "+e);
		}finally{
			if(rst !=null) rst.close();
			if(pstmt !=null) pstmt.close();
			if(con!=null) ConnectionManager.returnConnection(con);
		}


%>

<HTML>
<HEAD>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src='../../eBL/js/BLMultiFactorDeductRule.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

			<iframe name='CategoryDtls' id='CategoryDtls'	src='../../eCommon/html/blank.html' frameborder=0 noresize  noresize style='height:90vh;width:100vw'></iframe>
			<iframe name='CategoryBtn' id='CategoryBtn'	src='../../eCommon/html/blank.html' frameborder=0 noresize  noresize style='height:10vh;width:100vw'></iframe> 

<!--		<% if(from.equals("DiagnosisCategoryDetails") && diagCatTabYN.equals("Y")){%>
			<iframe name='DiagnosisCategoryDetailsPage' id='DiagnosisCategoryDetailsPage'	src='BLMulFactDedRuleDiagCatDtls.jsp?<%=params%>' frameborder=0 noresize  noresize></iframe>
			<iframe name='DrugCategoryDetailsBtn' id='DrugCategoryDetailsBtn'	src='BLMultiFactorDeductRuleDrugCategoryDetailsAdd.jsp?<%=params%>' frameborder=0 noresize  noresize></iframe>
		
		<% }else if(from.equals("DrugCategoryDetails") ){%>
			<iframe name='DrugCategoryDtlsPage' id='DrugCategoryDtlsPage'	src='BLMultiFactorDeductRuleDrugCategoryDetails.jsp?<%=params%>' frameborder=0 noresize  noresize></iframe>
			<iframe name='DrugCategoryDetailsBtn' id='DrugCategoryDetailsBtn'	src='BLMultiFactorDeductRuleDrugCategoryDetailsAdd.jsp?<%=params%>' frameborder=0 noresize  noresize></iframe>
			
		  <%}%> -->
		  


</HTML>

