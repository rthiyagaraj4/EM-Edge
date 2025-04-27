<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*, eBL.* ,eBL.Common.*,eCommon.Common.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<HTML>

<HEAD>
</HEAD>
<!--
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link>
-->
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>		
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eBL/js/BLMultiFactorDeductRule.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
			String function_id=request.getParameter("function_id");
			if(function_id==null || function_id.equals("")) function_id="";
			String url = "../../eCommon/jsp/MstCodeToolbar.jsp?home_required_yn=Y";
			String source = url + params ;
			Connection con = null;
			ResultSet rst = null;
			PreparedStatement pstmt = null;
			String MFDRMandYN = "N";
			String drugCatTab_YN = "N";
			String diagCatTab_YN = "N";
			String servicesAndItemsTab_YN = "N";
			String facility_id = (String)session.getAttribute("facility_id");
			
			try{
				
				con = ConnectionManager.getConnection(request);
				//V221017
				String qry_MFDRMandYN = "select NVL(MULTI_FACTOR_DED_RULE_APPL_YN,'N') MULTI_FACTOR_DED_RULE_APPL_YN, NVL(MFDR_DRUG_CAT_APPL_YN,'N') MFDR_DRUG_CAT_APPL_YN, NVL(MFDR_DIAG_CAT_APPL_YN,'N') MFDR_DIAG_CAT_APPL_YN, NVL(MFDR_SERV_ITEM_CAT_APPL_YN,'N') MFDR_SERV_ITEM_CAT_APPL_YN from bl_parameters where OPERATING_FACILITY_ID = '"+facility_id+"'";
			
				pstmt = con.prepareStatement(qry_MFDRMandYN);
				rst = pstmt.executeQuery();
						
				if(rst != null){
					while(rst.next()) {
						MFDRMandYN 	= rst.getString("MULTI_FACTOR_DED_RULE_APPL_YN");
						drugCatTab_YN = rst.getString("MFDR_DRUG_CAT_APPL_YN");
						diagCatTab_YN = rst.getString("MFDR_DIAG_CAT_APPL_YN");
						servicesAndItemsTab_YN = rst.getString("MFDR_SERV_ITEM_CAT_APPL_YN");
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
			
			if(MFDRMandYN.equals("Y") && (diagCatTab_YN.equals("Y") || drugCatTab_YN.equals("Y") || servicesAndItemsTab_YN.equals("Y"))){
%>
		<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>          
			<iframe name='MultiFactorDeductRuleMainFrame' id='MultiFactorDeductRuleMainFrame' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='' noresize style='height:83vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:9vh;width:100vw'></iframe>  
		
			<%}else{
				
			   out.println("<script>alert('Multi Factor Deductible Rule is not enabled, cannot use this function');document.location.href='../../eCommon/jsp/dmenu.jsp';</script>"); 
			}
			%>
	<script>   
	</script>
</HTML> 

