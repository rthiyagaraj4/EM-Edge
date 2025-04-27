<!DOCTYPE html>
<%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
06/12/2012   	IN030466    	 Karthi L		CRF-025 Based on the access rights, practitioner can Record, View and update the Clinical Studies content in CA Patient Chart Menu	
---------------------------------------------------------------------------------------------------------------
*/ %>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCA.ResearchPatient.label" bundle="${ca_labels}"/></title>

		<%
     		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<!-- Added by Archana Kumari Dhal @15/12/2008-->
		
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCA/js/ResearchPatient.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	</head>
	<body class='CONTENT' onKeyDown="lockKey()" OnMouseDown='CodeArrest()' onScroll='scrollTitle()' class='content'>
		<form name='ResearchPatientQueryResultform' id='ResearchPatientQueryResultform'>
	<%
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		String patient_id = "";
		String research_categ_id = "",research_categ_desc="";
		String remarks = "";
		String start_date = "";
		String close_date = "";
		String start_pdate = "";
		String close_pdate = "";
		String research_categ_fact_id = ""; // added for CRF025
		String research_categ_fact_desc = ""; // added for CRF025
		
		String mode = "modify";
		String close_date1 = "";
		int hyperlink_flag = 0;
		patient_id = request.getParameter("patient_id") == null?"":request.getParameter("patient_id");
		try
		{
			con	= ConnectionManager.getConnection();
		
			//String research_patient_sql = "SELECT A.RESEARCH_CATEG_ID,A.REMARKS,TO_CHAR(A.START_DATE,'DD/MM/YYYY') start_date ,TO_CHAR(A.CLOSE_DATE,'DD/MM/YYYY') close_date,(SELECT initcap(RESEARCH_CATEG_DESC) FROM CA_RESEARCH_CATEGORY WHERE RESEARCH_CATEG_ID = A.RESEARCH_CATEG_ID) RESEARCH_DESC,NVL((SELECT 1 FROM DUAL WHERE trunc(sysdate) between a.start_date and nvl(a.close_date,trunc(sysdate))),0) HYPERLINK_FLAG FROM ca_research_patient_detail A WHERE A.PATIENT_ID=? ";
			
			// commented below query for CRF-025
			//String research_patient_sql = "SELECT A.RESEARCH_CATEG_ID,A.REMARKS,TO_CHAR(A.START_DATE,'dd/mm/yyyy') start_date ,TO_CHAR(A.CLOSE_DATE,'dd/mm/yyyy') close_date,initcap(CA_GET_DESC.CA_RESEARCH_CATEGORY(A.RESEARCH_CATEG_ID,?,'1')) RESEARCH_DESC,NVL((SELECT 1 FROM DUAL WHERE trunc(sysdate) between a.start_date and nvl(a.close_date,trunc(sysdate))),0) HYPERLINK_FLAG FROM ca_research_patient_detail A WHERE A.PATIENT_ID=?"; 
			// added for CRF-025
			String research_patient_sql = "SELECT A.RESEARCH_CATEG_ID,A.REMARKS,A.RESEARCH_CATEG_FACT_ID, (Select RESEARCH_CATEG_FACT_DESC from ca_research_category_fact b where b.RESEARCH_CATEG_FACT_ID = A.RESEARCH_CATEG_FACT_ID) RESEARCH_CATEG_FACT_DESC, TO_CHAR(A.START_DATE,'dd/mm/yyyy') start_date ,TO_CHAR(A.CLOSE_DATE,'dd/mm/yyyy') close_date,initcap(CA_GET_DESC.CA_RESEARCH_CATEGORY(A.RESEARCH_CATEG_ID,?,'1')) RESEARCH_DESC,NVL((SELECT 1 FROM DUAL WHERE trunc(sysdate) between a.start_date and nvl(a.close_date,trunc(sysdate))),0) HYPERLINK_FLAG FROM ca_research_patient_detail A WHERE A.PATIENT_ID=?"; 
			
			stmt = con.prepareStatement(research_patient_sql);
			stmt.setString(1,locale);
			stmt.setString(2,patient_id);
			rs = stmt.executeQuery();
	%>
			<div id='divDataTitle' style='postion:relative'>
				<table border='1' width='100%' id='dataTitleTable' cellpadding='3' cellspacing='0' align='center' >
					<tr>
						<td class='COLUMNHEADERCENTER'  width='20%' ><fmt:message key="eCA.ResearchCategory.label" bundle="${ca_labels}"/></td>
						<td class='COLUMNHEADERCENTER'  width='20%' ><fmt:message key="eCA.ResearchCategoryFactor.label" bundle="${ca_labels}"/></td> <!-- IN030466 -->
						<td class='COLUMNHEADERCENTER'  width='15%'><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
						<td class='COLUMNHEADERCENTER'  width='15%'><fmt:message key="eCA.CloseDate.label" bundle="${ca_labels}"/></td>
						<td class='COLUMNHEADERCENTER'  width='30%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					</tr>
				</table>
			</div>
			<table id='dataTable' width='100%' align="center" class='grid'>
			<%
			int count = 0;
			String ClassValue ="";
			while(rs.next())
			{
				hyperlink_flag = 0;	
				research_categ_id = (rs.getString("research_categ_id")==null)?"":rs.getString("research_categ_id");	
				research_categ_desc=(rs.getString("RESEARCH_DESC")==null)?"":rs.getString("RESEARCH_DESC");
				remarks=(rs.getString("remarks")==null)?"":rs.getString("remarks");
				start_date=(rs.getString("start_date")==null)?"&nbsp;":rs.getString("start_date");
				close_date=(rs.getString("close_date")==null)?"":rs.getString("close_date");
				research_categ_fact_id = (rs.getString("RESEARCH_CATEG_FACT_ID")==null)?"":rs.getString("RESEARCH_CATEG_FACT_ID"); // added for CRF-025
				research_categ_fact_desc = (rs.getString("RESEARCH_CATEG_FACT_DESC")==null)?"":rs.getString("RESEARCH_CATEG_FACT_DESC"); // added for CRF-025
				if(close_date.equals("")){
					close_date1 = "N";
					close_date = "&nbsp;";
				}
				else{
					close_date1 = close_date;
				}

				if(!start_date.equals("&nbsp;") )
					start_pdate = com.ehis.util.DateUtils.convertDate(start_date,"DMY","en",locale);

				if(!close_date.equals("&nbsp;") )
					close_pdate = com.ehis.util.DateUtils.convertDate(close_date,"DMY","en",locale);
				
				hyperlink_flag = rs.getInt("HYPERLINK_FLAG");
				/*if(count % 2 == 0)
					ClassValue = "QRYEVEN";
				else
					ClassValue = "QRYODD";*/

					ClassValue = "gridData";					

				out.println("<tr><td  width='30%' class='" + ClassValue + "' >");				
				if(hyperlink_flag == 1){
					//commented below for CRF-025
					//out.println("<a class='gridLink' href='../../eCA/jsp/ResearchPatientRecord.jsp?mode="+mode+"&patient_id="+patient_id+"&research_categ_id="+research_categ_id+"&start_date="+start_date+"&close_date="+close_date1+"' target='ResearchPatientRecordframe' >"); 
					out.println("<a class='gridLink' href='../../eCA/jsp/ResearchPatientRecord.jsp?mode="+mode+"&patient_id="+patient_id+"&research_categ_id="+research_categ_id+"&research_categ_fact_id="+research_categ_fact_id+"&research_categ_fact_desc="+research_categ_fact_desc+"&start_date="+start_date+"&close_date="+close_date1+"' target='ResearchPatientRecordframe' >"); 
					
					out.println(research_categ_desc+"</a></td>");
				}else{
					out.println(research_categ_desc+"</td>");
				}
				if(close_date1.equals("N")){
					close_pdate="";
				}
				out.println("<td  width='20%' class='" + ClassValue + "' >"+research_categ_fact_desc+"</td>");
				out.println("<td  width='20%' class='" + ClassValue + "' >"+start_pdate+"</td>");
				out.println("<td  width='20%' class='" + ClassValue + "' >"+close_pdate+"</td>");
				
				int len=remarks.length();
				if(len > 30)
				{
					String printString=remarks.substring(0,30);
					//out.println("<td  width='30%' class='" + ClassValue +"' ><a class='gridLink' href=\"javascript:showRemarks('"+patient_id+"','"+research_categ_id+"','"+start_date+"')\"  style='cursor:pointer; color: blue'>"+printString+"...</a></td></tr>"); commented for CRF-025
					out.println("<td  width='30%' class='" + ClassValue +"' ><a class='gridLink' href=\"javascript:showRemarksResearchPatient('"+patient_id+"','"+research_categ_id+"','"+research_categ_fact_id+"','"+start_date+"')\"  style='cursor:pointer; color: blue'>"+printString+"...</a></td></tr>");
					// modified above line for CRF-025
				}
				else
				{			
					out.println("<td  width='30%' class='" + ClassValue + "' >"+remarks+"</td></tr>");
				}
				count++; 
			}	
			session.setAttribute("patient_id",patient_id);
			%>
			<tr style='visibility:hidden'>
				<td class='COLUMNHEADERCENTER' width='20%'><fmt:message key="eCA.ResearchCategory.label" bundle="${ca_labels}"/></td>
				<td class='COLUMNHEADERCENTER'  width='20%' ><fmt:message key="eCA.ResearchCategoryFactor.label" bundle="${ca_labels}"/></td> <!-- IN030466 -->
				<td class='COLUMNHEADERCENTER'  width='15%'><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADERCENTER'  width='15%'><fmt:message key="eCA.CloseDate.label" bundle="${ca_labels}"/></td>
				<td class='COLUMNHEADERCENTER'  width='30%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			</tr>
			</table>
		<%
		
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
			}catch(Exception e){
			//out.println("Exception in try of ResearchPatientQueryResult.jsp : "+e);//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
		}
		finally {
				
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
		%>
		</form>
	<script>alignWidth();</script>
	</body>
</html>





