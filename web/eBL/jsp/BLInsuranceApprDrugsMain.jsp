<!DOCTYPE html>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
	<head>
 	<script language='javascript' src='../../eBL/js/BLInsuranceApprDrugs.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 	</head>
	<%
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?home_required_yn=Y" ;
		String params = request.getQueryString() ;
		String source = url + params ;
		
		Connection con = null;
		ResultSet rst = null;
		PreparedStatement pstmt = null;
		String MFDRMandYN = "N", MFDRDrugEnabledYN = "N";
		String facility_id = (String)session.getAttribute("facility_id");
		
		try{
			
			con = ConnectionManager.getConnection(request);
			//V221017
			String qry_MFDRMandYN = "select NVL(MULTI_FACTOR_DED_RULE_APPL_YN,'N') MULTI_FACTOR_DED_RULE_APPL_YN, NVL(MFDR_DRUG_CAT_APPL_YN,'N') MFDR_DRUG_CAT_APPL_YN from bl_parameters where OPERATING_FACILITY_ID = '"+facility_id+"'";
		
			pstmt = con.prepareStatement(qry_MFDRMandYN);
			rst = pstmt.executeQuery();
					
			if(rst != null){
				while(rst.next()) {
					MFDRMandYN 	= rst.getString("MULTI_FACTOR_DED_RULE_APPL_YN");
					MFDRDrugEnabledYN = rst.getString("MFDR_DRUG_CAT_APPL_YN");
				}
			}
			System.err.println("Value of MFDR is: "+MFDRMandYN);
			//V221017
		}catch(Exception e){
			System.err.println("Exception is: "+e);
		}finally{
			if(rst !=null) rst.close();
			if(pstmt !=null) pstmt.close();
			if(con!=null) ConnectionManager.returnConnection(con);
		}
			
			if("Y".equals(MFDRMandYN) && "Y".equals(MFDRDrugEnabledYN)){		
	%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='ApprovedDrugsCriteriaFrame' id='ApprovedDrugsCriteriaFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no'  style='height:37vh;width:100vw'></iframe>
		<iframe name='ApprovedDrugsFrame' id='ApprovedDrugsFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no'  style='height:47vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
	<%}else{
				
			   out.println("<script>alert('Multi Factor Deductible Rule is not enabled, cannot use this function');document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}
	%>	
</html>

