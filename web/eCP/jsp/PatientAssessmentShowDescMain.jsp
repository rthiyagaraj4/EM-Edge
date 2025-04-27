<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,java.util.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%
//This file is saved on 18/10/2005.
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String flag_ss_ua = request.getParameter("arg2") == null? "" :request.getParameter("arg2");
	String ss_dep_desc = request.getParameter("ss_dep_desc") == null? "" :request.getParameter("ss_dep_desc");
%>
	<head>
		<%
			if(flag_ss_ua.equals("SystemDefined"))
			{
		%>
			<title><fmt:message key="eCP.SystemSuggested.label" bundle="${cp_labels}"/></title>
		<%
			}
			else
			{
		%>
			<title><fmt:message key="eCP.UserDefinedDiagnoses.label" bundle="${cp_labels}"/></title>
		<%
			}
		%>
<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<Script language ="JavaScript" src ='../../eCP/js/PatientAssessment.js'></Script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body  onmousedown = 'CodeArrest()' onscroll='fixedHeading()'>
		<form>
			<table width='100%' align='center' border=1 cellpadding='0' cellspacing=0>
				<tr id='trSt'>
					<th align='left' colspan='2' style='BACKGROUND-COLOR:#ffc5b5;color:black'><fmt:message key="Common.Dependency.label" bundle="${common_labels}"/>: <%=ss_dep_desc%>
				</tr>
				<tr id='trSt'>
					<th align='left' colspan='2'><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></th>
					</th>
				</tr>
				<tr id='trSt'>
					<th><fmt:message key="Common.TermCode.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
				</tr>
			<%				
				String term_set_desc = "";
				String term_code_desc = "";
				String cur_term_set_desc = "";
				String classValue = "";
				String term_code_id = "";
				String assess_ref_no = request.getParameter("arg1") == null ? "" :request.getParameter("arg1");

				int count = 0;
				Connection con = null;
				ResultSet resDesc = null;
				PreparedStatement psDesc = null;
				try
				{
					con = ConnectionManager.getConnection(request);

				if(flag_ss_ua.equals("SystemDefined"))
				{
					try
					{

						String sql_diag_desc = "SELECT distinct a.term_set_id, b.TERM_SET_DESC , a.term_code, c.short_desc  diag_desc FROM mr_term_set b ,mr_term_code c,CP_PAT_ASSESS_SS_TERM_CODE  a WHERE b.term_set_id = a.term_set_id AND c.term_set_id =a.term_set_id AND c.term_code=a.term_code AND (c.term_set_id ,c.term_code) IN (SELECT term_set_id ,term_code FROM cp_pat_assess_ss_term_code WHERE assess_ref_no=?) order by b.TERM_SET_DESC";
						psDesc = con.prepareStatement(sql_diag_desc);
						psDesc.setString(1,assess_ref_no);
						//out.println("CP_PAT_ASSESS_SS_TERM_CODE = "+sql_diag_desc);
						//psDesc.setString(2,encounter_id);
												
						resDesc = psDesc.executeQuery();
						while(resDesc.next())
						{
							term_code_id = resDesc.getString(3);
							term_set_desc = resDesc.getString(2);
							term_code_desc = resDesc.getString("diag_desc");
							
							if(count%2 == 0)
								classValue = "QRYEVEN";
							else
								classValue = "QRYODD";
							
				
							if(!(term_set_desc.equals(cur_term_set_desc)))
							{
								out.println("<tr>");
								out.println("<td class='CAGROUPHEADING' colspan='2'>");
								out.println(" "+term_set_desc+" ");
								out.println("</td>");
								out.println("</tr>");
							}
							out.println("<tr>");
							out.println("<td class="+classValue+" >");
							out.println(" "+term_code_id+" ");
							out.println("</td>");
							out.println("<td class="+classValue+" >");
							out.println(" "+term_code_desc+" ");
							out.println("</td>");
							out.println("</tr>");

							cur_term_set_desc = term_set_desc;
							count++;
						}
						resDesc.close();
						psDesc.close();
					}//end of try
					catch(Exception e)
					{
						System.out.println("Exception in PatientAssessmentShowDescMain.jsp"+e.toString());
					}
				}
				else
				{
					try
					{
//						con = ConnectionManager.getConnection(request);
						String sql_diag_desc = "SELECT distinct a.term_set_id, b.TERM_SET_DESC , a.term_code, c.short_desc  diag_desc FROM mr_term_set b ,mr_term_code c,CP_PAT_ASSESS_UA_TERM_CODE  a WHERE b.term_set_id = a.term_set_id AND c.term_set_id =a.term_set_id AND c.term_code=a.term_code AND (c.term_set_id ,c.term_code) IN (SELECT term_set_id ,term_code FROM cp_pat_assess_ua_term_code WHERE assess_ref_no=?) order by b.TERM_SET_DESC";
						psDesc = con.prepareStatement(sql_diag_desc);
						psDesc.setString(1,assess_ref_no);
						
						
						resDesc = psDesc.executeQuery();
						while(resDesc.next())
						{
							term_code_id = resDesc.getString(3);
							term_set_desc = resDesc.getString(2);
							term_code_desc = resDesc.getString("diag_desc");
							
							if(count%2 == 0)
								classValue = "QRYEVEN";
							else
								classValue = "QRYODD";

							if(!(term_set_desc.equals(cur_term_set_desc)))
							{
								out.println("<tr>");
								out.println("<td class='CAGROUPHEADING' colspan='2'>");
								out.println(" "+term_set_desc+" ");
								out.println("</td>");
								out.println("</tr>");
							}
							out.println("<tr>");
							out.println("<td class="+classValue+" >");
							out.println(" "+term_code_id+" ");
							out.println("</td>");
							out.println("<td class="+classValue+" >");
							out.println(" "+term_code_desc+" ");
							out.println("</td>");
							out.println("</tr>");

							cur_term_set_desc = term_set_desc;
							count++;
						}
						 resDesc.close();
						 psDesc.close();
					}
					catch(Exception e)
					{
						System.out.println("Exception in try of PatientAssessmentShowDescMain.jsp"+e.toString());
					}
				}				
			%>
			</table>
			<table align='right' >
				<tr>
					<td><input type='button' class='button' value = '<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick='closeDescWindow()' align='right'></td>
				</tr>
			</table>			
		</form>
	</body>
<%
}
catch(Exception e)
{
	out.println(e.toString());
}
finally
{
	if(resDesc != null) resDesc = null;
	if(psDesc != null) psDesc = null;
	if(con != null) ConnectionManager.returnConnection(con);
}
%>
</html>

