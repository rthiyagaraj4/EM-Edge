<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCA.ResearchInfo.label" bundle="${ca_labels}"/></title>
		<%
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		

		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCA/js/ResearchPatient.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	</head>
	<body class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	<form name='ResearchPatientQueryResultform' id='ResearchPatientQueryResultform'>
	<%
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
			
		String patient_id = "";
		String research_categ_id = "",research_categ_desc="", research_categ_fact_id="";
		String remarks = "";
		String start_date = "";
		String close_date = "";
		try
		{
			con	= ConnectionManager.getConnection();
			patient_id = (request.getParameter("patient_id")==null)?"":request.getParameter("patient_id");


			//String research_patient_sql = "select a.patient_id as patient_id ,a.research_categ_id as research_categ_id,a.remarks as remarks,TO_CHAR(A.START_DATE,'DD/MM/YYYY') start_date ,TO_CHAR(A.CLOSE_DATE,'DD/MM/YYYY') close_date,(select initcap(research_categ_desc) from ca_research_category where research_categ_id = a.research_categ_id) as RESEARCH_DESC from ca_research_patient_detail a where patient_id = ? ";

			String research_patient_sql = "select a.patient_id as patient_id ,a.research_categ_id as research_categ_id,a.remarks as remarks,TO_CHAR(A.START_DATE,'DD/MM/YYYY') start_date ,TO_CHAR(A.CLOSE_DATE,'DD/MM/YYYY') close_date,CA_GET_DESC.CA_RESEARCH_CATEGORY(A.RESEARCH_CATEG_ID,?,'1') RESEARCH_DESC,a.RESEARCH_CATEG_FACT_ID from ca_research_patient_detail a where patient_id = ?";  

			stmt = con.prepareStatement(research_patient_sql);
			stmt.setString(1,locale);
			stmt.setString(2,patient_id);
			rs = stmt.executeQuery();
	%>
		<table class='grid' width='100%' align="center">
			<tr>
				<td class='COLUMNHEADERCENTER' ><fmt:message key="eCA.ResearchCategory.label" bundle="${ca_labels}"/></td>
				<td class='COLUMNHEADERCENTER' ><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADERCENTER' ><fmt:message key="eCA.CloseDate.label" bundle="${ca_labels}"/></td>
				<td class='COLUMNHEADERCENTER' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			</tr>
		<%
			int count = 0;
			String ClassValue ="";
			while(rs.next())
			{
				research_categ_id = (rs.getString("research_categ_id")==null)?"":rs.getString("research_categ_id");	
				research_categ_desc=(rs.getString("RESEARCH_DESC")==null)?"":rs.getString("RESEARCH_DESC");
				remarks=(rs.getString("remarks")==null)?"":rs.getString("remarks");
				start_date=(rs.getString("start_date")==null)?"&nbsp;":rs.getString("start_date");
				close_date=(rs.getString("close_date")==null)?"":rs.getString("close_date");
				research_categ_fact_id = (rs.getString("RESEARCH_CATEG_FACT_ID")==null)?"":(String)rs.getString("RESEARCH_CATEG_FACT_ID");
				if(close_date.equals("") || close_date==null)
					close_date="&nbsp";
				/*if(count % 2 == 0)
					ClassValue = "QRYEVEN";
				else
					ClassValue = "QRYODD";*/

				ClassValue="gridData";

				out.println("<tr><td class='" + ClassValue + "' >");
				out.println(research_categ_desc+"</td>");
				out.println("<td class='" + ClassValue + "' >"+start_date+"</td>");
				out.println("<td class='" + ClassValue + "' >"+close_date+"</td>");
				int len=remarks.length();
				if(len > 30)
				{
					String printString=remarks.substring(0,30);
					out.println("<td class='" + ClassValue +"' ><a href='#' onClick=\"return showRemarksResearchPatient('"+patient_id+"','"+research_categ_id+"','"+research_categ_fact_id+"','"+start_date+"')\"  style='cursor:pointer; color: blue'>"+printString+"...</a></td></tr>");
				}
				else
				{			
					out.println("<td class='" + ClassValue + "'>"+remarks+"</td></tr>");
				}	
				count++; 
			}	
		%>
		</table>
		<%
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
	}
	catch(Exception e)
	{
		//out.println("Exception in try1 of ResearchPatient.jsp : "+e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally 
	{
		
		if (con != null) ConnectionManager.returnConnection(con,request);
	}
	%>
	</form>
	</body>
</html>

