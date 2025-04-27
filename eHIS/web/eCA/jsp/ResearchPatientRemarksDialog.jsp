<!DOCTYPE html>
<%@ page language="java" import ="java.sql.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCA.ResearchRemarks.label" bundle="${ca_labels}"/></title>

		<%
			request.setCharacterEncoding("UTF-8");	
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE1")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	  <script language='javascript' src='../../eCommon/js/common.js'></script>
      <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		String patient_id = "";
		String research_categ_id = "";
		String start_date = "";
		String remarks = "";
		String research_categ_fact_id = ""; // added for CRF-025
		patient_id = request.getParameter("patient_id") == null?"":request.getParameter("patient_id");
		String research_sql = "";
		research_categ_id = (request.getParameter("research_categ_id")==null)?"":request.getParameter("research_categ_id");
		research_categ_fact_id = (request.getParameter("research_categ_fact_id")==null)?"":request.getParameter("research_categ_fact_id"); // added for CRF-025

		start_date = (request.getParameter("start_date")==null)?"":request.getParameter("start_date");
		try
		{
			con	= ConnectionManager.getConnection();
			if(research_categ_fact_id != "" && research_categ_fact_id != null)
			{
				research_sql = "select remarks from ca_research_patient_detail where research_categ_id = ? and patient_id = ? and start_date = TO_DATE(?,'DD/MM/YYYY') and research_categ_fact_id = ?"; // modified for CRF-025
			}
			else
			{	
				research_sql = "select remarks from ca_research_patient_detail where research_categ_id = ? and patient_id = ? and start_date = TO_DATE(?,'DD/MM/YYYY')"; 
			
			}
			stmt = con.prepareStatement(research_sql);
			stmt.setString(1,research_categ_id);
			stmt.setString(2,patient_id);
			stmt.setString(3,start_date);
			if(research_categ_fact_id != "" && research_categ_fact_id != null)
			{
				stmt.setString(4,research_categ_fact_id); // added for CRF-025
			}	
			rs=stmt.executeQuery();
			while(rs.next())
			{
				remarks= rs.getString("remarks");
			}
		%>
			</head>
			<BODY  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
				<form>
					<br>
					<table border=0 cellpadding=3 cellspacing=0 align=center>
						<tr>
							<td><textarea name='remarks' value="" rows=5 cols=90 value=''  readonly ><%=remarks%></textarea></td>
						</tr>
					</table>
		<%	
		
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}
		catch(Exception e)
		{
		//	out.println("Exception in try of ResearchPatientRemarksDialog.jsp:"+e);//COMMON-ICN-0181
	         	e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			if(con!=null)ConnectionManager.returnConnection(con,request);
		}	
			%>
			</form>
		</body>
</html>

