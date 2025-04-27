<!DOCTYPE html>
 <%@ page import="java.sql.*,webbeans.eCommon.*,java.io.*" contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<title><fmt:message key="Common.details.label" bundle="${common_labels}"/></title>
<%
	
	java.sql.Connection		con = null;
	java.sql.PreparedStatement pstmt = null;
	java.sql.ResultSet		rs = null;
	
	

	String	patient_id			=	(request.getParameter("patient_id")==null?"":request.getParameter("patient_id"));
	String	facility_id			=	(request.getParameter("facility_id")==null?"":request.getParameter("facility_id"));
	String	resePatcategory		=	(request.getParameter("resePatcategory")==null?"":request.getParameter("resePatcategory"));
	String	reseCategoryFact	=	(request.getParameter("reseCategoryFact")==null?"":request.getParameter("reseCategoryFact"));
	String	addedDate	=	(request.getParameter("addedDate")==null?"":request.getParameter("addedDate"));
	
	String			outPutDetails	=	"";
	StringBuffer qry =new StringBuffer(" SELECT REMARKS FROM CA_RESEARCH_PATIENT_DETAIL WHERE RESEARCH_CATEG_ID=? AND RESEARCH_CATEG_FACT_ID=? AND PATIENT_ID=? AND ADDED_FACILITY_ID=? AND added_date = TO_date(?, 'dd/mm/yyyy hh24:mi:ss')");
	try{
		con	= ConnectionManager.getConnection(request);
		pstmt	= con.prepareStatement(qry.toString());
		pstmt.setString(1, resePatcategory);
		pstmt.setString(2, reseCategoryFact);
		pstmt.setString(3, patient_id);
		pstmt.setString(4, facility_id);
		pstmt.setString(5, addedDate);
		rs = pstmt.executeQuery();

		if(rs.next()){
			  outPutDetails = rs.getString("REMARKS");
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		
	}catch(Exception e){
			e.printStackTrace();
			//out.println("Exception from ClinicalStudiesPatientListHistDetails.jsp " + e.toString());//COMMON-ICN-0181
	}finally{
			if(con != null) ConnectionManager.returnConnection(con, request);
	}	
	out.println(outPutDetails);
%>

