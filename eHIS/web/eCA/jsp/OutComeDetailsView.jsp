<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"SpecialityStyle.css";
	//java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	//String locale = (String) p.getProperty("LOCALE");
%>

<html>
<title><fmt:message key="eCA.RecMaternityconsView.label" bundle="${ca_labels}"/></title>
<head> 
	<link rel='StyleSheet' href='../../eCA/html/SpecialityStyle.css' type='text/css'></link> 
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>

<body class='MCCONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()"> 

<form name = "OutcomeDetailViewForm" >
<%

	java.sql.Connection			con		=	null;
	java.sql.PreparedStatement	pstmt	=	null;
	java.sql.ResultSet			rs		=	null;
	String query_details		=	"";
	
	StringBuffer htmContent = new StringBuffer();
	String accession_num					="";
	accession_num	=	request.getParameter("accessionNum")==null?"":request.getParameter("accessionNum");
	String outcomedesc	=	request.getParameter("outcomedesc")==null?"":request.getParameter("outcomedesc");
	String patient_id	=	request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	con = ConnectionManager.getConnection(request);

	try
	{
			query_details="select  HTM_CONTENT from CA_PAT_SPLTY_TASK_DTL where ACCESSION_NUM=?";
			pstmt		=	con.prepareStatement(query_details);
			pstmt.setString(1,accession_num);
			rs			=	pstmt.executeQuery();
			while(rs.next())
			{
				Clob HTM_CONTENT = (Clob) rs.getClob("HTM_CONTENT");
				if(HTM_CONTENT !=null)
				{
					java.io.BufferedReader r = new java.io.BufferedReader(HTM_CONTENT.getCharacterStream());
					String line = null;

					while((line=r.readLine()) != null) 
					{
						htmContent.append(line);
					}
				}
				
			 }	
		
	}
	catch(Exception e)
	{
		//out.println("Exception @ RecMaternityConsView.jsp"+e.toString());//COMMON-ICN-0181
		 e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{

		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null)	ConnectionManager.returnConnection(con,request);
	}
%>

<%=htmContent.toString()%>
  <input type="hidden" name="accession_num" id="accession_num" value="<%=accession_num%>">
  <input type="hidden" name="outcomedesc" id="outcomedesc" value="<%=outcomedesc%>">
  <input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
</form>
</body>
</html>

