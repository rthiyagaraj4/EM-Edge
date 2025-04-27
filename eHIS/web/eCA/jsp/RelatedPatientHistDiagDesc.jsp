<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html><head>
<%

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<script language='javascript' src='../../eCA/js/RelatedPatientHist.js'></script> 
<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>


<%
	Connection			conlCon		=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rslRst		=	null;

	String fieldname    =  (request.getParameter("mode")==null)?"":request.getParameter("mode");
    String diagid       =  (request.getParameter(fieldname)==null)?"":request.getParameter(fieldname);
    String term_set_id       =  (request.getParameter("term_set_id")==null)?"":request.getParameter("term_set_id");
	String shortdesc ="";
	String concat="";
	
	try{

		conlCon				=	(Connection)	ConnectionManager.getConnection(request);

		//String sql="select short_desc from mr_icd_code where diag_code = ?";
		String sql="select short_desc from mr_term_code	where TERM_SET_ID=? and TERM_CODE= ?";
		
		pstmt = conlCon.prepareStatement(sql);
		pstmt.setString(1,term_set_id);
		pstmt.setString(2,diagid);
        

		rslRst = pstmt.executeQuery();
        
		while(rslRst.next()) {
					shortdesc	=	(rslRst.getString("short_desc")==null)?"":rslRst.getString("short_desc");
					
		}
	  
				if(!(shortdesc.equals("")))
		{
					concat = diagid + "-"+shortdesc;
					%>
       
        <script language='javascript'>setValue("<%=concat%>","<%=fieldname%>");</script>

		<%
			}
           else
		{
			   out.println("<script>alert(getMessage('NO_SHORT_DESC','CA'));</script>");
			   //out.println("<script>alert('CA00043-There is no ShortDescription');</script>");
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

