<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html><head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCA/js/ProblemList.js'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>

<%
	Connection			conlCon		=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rslRst		=	null;
	String diagid   = "";
	diagid       =  (request.getParameter("diag_code")==null)?"":request.getParameter("diag_code");
	
	String shortdesc ="";
	//String concat="";
	try	
		{
		conlCon				=	(Connection)	ConnectionManager.getConnection(request);

		//String sql="select short_desc from mr_icd_code where diag_code = ?";
		String sql="select short_desc from MR_TERM_CODE where TERM_CODE = ?";
		
		pstmt = conlCon.prepareStatement(sql);
		pstmt.setString(1,diagid);
        rslRst = pstmt.executeQuery();
        
		while(rslRst.next())
		{
			shortdesc	=	(rslRst.getString("short_desc")==null)?"":rslRst.getString("short_desc");
		}
	  
		if(!(shortdesc.equals("")))
		{
			out.println("<script language='javascript'>parent.RecClinicalNotesLinkDiagCriteriaFrame.document.ProblemListForm.code_desc.value='"+shortdesc+"';parent.messageFrameReference.location.href= '../../eCommon/jsp/MstCodeError.jsp';</script>");

		} 
		}		
	catch(Exception e){
		//out.println("Exception@1: "+e.toString());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}finally{
		if(rslRst!=null) rslRst.close();
		if(pstmt!=null) pstmt.close();
		if(conlCon!=null) ConnectionManager.returnConnection(conlCon,request);
	}

%>

