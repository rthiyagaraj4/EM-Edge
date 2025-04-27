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
<title>Active Diagnosis</title>
<%
	
	java.sql.Connection		con = null;
	java.sql.PreparedStatement pstmt = null;
	java.sql.ResultSet		rs = null;
	
	

	String	patient_id		=	(request.getParameter("patient_id")==null?"":request.getParameter("patient_id"));
	String	facility_id		=	(request.getParameter("facility_id")==null?"":request.getParameter("facility_id"));
	String	local			=	(request.getParameter("local")==null?"":request.getParameter("local"));
	String	term_set_id		=	(request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id"));
	String	diagnew1		=	(request.getParameter("diagnew1")==null?"":request.getParameter("diagnew1"));
	String	diagnew2		=	(request.getParameter("diagnew2")==null?"":request.getParameter("diagnew2"));
	String	diagnew3		=	(request.getParameter("diagnew3")==null?"":request.getParameter("diagnew3"));
	
	StringBuffer	outPutDetails	=	new StringBuffer();
	StringBuffer sql =new StringBuffer("SELECT DISTINCT   MTC.SHORT_DESC from MR_TERM_CODE_LANG_VW MTC,PR_DIAGNOSIS PD where MTC.TERM_CODE=PD.TERM_CODE and PD.PATIENT_ID= ? AND PD.ADDED_FACILITY_ID=? AND MTC.LANGUAGE_ID=?");
	/*if(!term_set_id.equals("")){			
		sql.append(" AND PD.TERM_SET_ID='"+term_set_id+"'");
	}
	if(!diagnew1.equals("") || !diagnew2.equals("") || !diagnew3.equals("")){
				
				sql.append(" AND PD.TERM_CODE IN(");
				
				int i=0;
				if (!diagnew1.equals("")){
					sql.append("'"+diagnew1+"'");
					i++;
				}  
				if (!diagnew2.equals("")){
					if(i>0)
						sql.append(",");
					sql.append("'"+diagnew2+"'");
					i++;
				}
				if (!diagnew3.equals("")){
				 if(i>0)
						sql.append(",");
					sql.append("'"+diagnew3+"'");
					i++;
				}		
				sql.append(")");	
	}*/
	try{
		con	= ConnectionManager.getConnection(request);
		pstmt	= con.prepareStatement(sql.toString());
		pstmt.setString(1, patient_id);
		pstmt.setString(2, facility_id);
		pstmt.setString(3, local);

		rs = pstmt.executeQuery();		
		while(rs.next()){
			  outPutDetails.append(rs.getString("SHORT_DESC")+"<br>");
		}
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		
	}catch(Exception e){
			e.printStackTrace();
			//out.println("Exception from ClinicalStudiesPatientListHistDetails.jsp " + e.toString());//COMMON-ICN-0181
	}finally{
			if(con != null) ConnectionManager.returnConnection(con, request);
	}	
	out.println(outPutDetails.toString());
%>

