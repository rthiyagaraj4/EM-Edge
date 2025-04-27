<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,java.util.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="diagBean" class="eCP.PatientAssessmentDiag" scope="session"/>
<html>
	<head>
		<title><fmt:message key="eCP.PatientAssessmentDiagnosis.label" bundle="${cp_labels}"/></title>
		<script src='../../eCP/js/PatientAssessment.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	</head>
	<body onmouseDown='CodeArrest();'>
		<form name='patAssessDependencyForm' id='patAssessDependencyForm' action=''>
		<%
			String mode = request.getParameter("mode") == null ? "" : request.getParameter("mode");
			System.err.println("mode="+mode);
			String status = request.getParameter("status") == null ? "" : request.getParameter("status");
			String status_flag = request.getParameter("status_flag") == null ? "" : request.getParameter("status_flag");
			//out.println("status="+status);
			String accession_num = request.getParameter("accession_num") == null ? "" : request.getParameter("accession_num");
			String note_type = request.getParameter("note_type") == null ? "" : request.getParameter("note_type");
			String assess_ref_no = request.getParameter("assess_ref_no") == null ? "" : request.getParameter("assess_ref_no");
			String ua_dep_desc = request.getParameter("ua_dep_desc") == null ? "" : request.getParameter("ua_dep_desc");
			String ua_dep_code = request.getParameter("ua_dep_code") == null ? "" : request.getParameter("ua_dep_code");
			String flag = request.getParameter("flag") == null ? "" : request.getParameter("flag");
			//out.println("flag="+flag);
			String ss_dep_desc = request.getParameter("ss_dep_desc") == null ? "" : request.getParameter("ss_dep_desc");
			String facility_id = (String) session.getAttribute("facility_id");			

			//out.println("QueryString = " +request.getQueryString());

			String assess_catg_code = "";
			String abnormalCateg = "";
			String assessDependency = "";
			String sqlDependency = "";

			Connection con = null;
			ResultSet resDesc = null;
			PreparedStatement psDesc = null;
			CallableStatement cs = null;
			ResultSet resDepend = null;
			PreparedStatement pstDepend = null;

			String short_desc = "";
			String depend_code = "";
			String dep_selected = "";
			StringTokenizer abnCategToken = null;
			

			try
			{
				try
				{
					con = ConnectionManager.getConnection(request);
					cs = con.prepareCall("{call CP_GET_ASSESS_OUTPUT(?,?,?,?,?)}" );
					
								System.err.println("accession_num : " + accession_num + "facility_id : " + facility_id + "note_type:  " +note_type +"Types.VARCHAR: "+Types.VARCHAR);
					cs.setString(1,accession_num);
					cs.setString(2,facility_id);
					cs.setString(3,note_type);
					cs.registerOutParameter(4,Types.VARCHAR);
					cs.registerOutParameter(5,Types.VARCHAR);
					cs.execute();				
					assessDependency = cs.getString(4) == null ? "" : cs.getString(4);			
					System.err.println("assessDependency "+assessDependency);
					abnormalCateg = cs.getString(5) == null ? "" : cs.getString(5);			
					abnCategToken = new StringTokenizer(abnormalCateg,"~");
					while(abnCategToken.hasMoreTokens())
					{
						if(assess_catg_code.equals(""))
							assess_catg_code =assess_catg_code + ("'" + assess_catg_code + abnCategToken.nextToken() + "'");
						else
							assess_catg_code =assess_catg_code + ("'" + assess_catg_code + abnCategToken.nextToken() + "',");
					}

//					if(con!=null) ConnectionManager.returnConnection(con,request);
				}
				catch(Exception e)
				{
					//out.println(e.toString());//COMMON-ICN-0181
					e.printStackTrace();//COMMON-ICN-0181
					System.err.println("@@@@@@@@@@Diag"+e.toString());
				}

				if(!mode.equals("modify"))
				{
			%>			
				<table width='100%' align='right' border=0 cellpadding='5' cellspacing=0>
					<!-- <tr>
						<td colspan='4'>&nbsp;</td>
					</tr> -->
					<tr>
						<td class='Data' width='15%' align='left'> <fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></td>
						<td width='15%' align='left'> <input type='button' class='button' value='<fmt:message key="eCP.AddNew.label" bundle="${cp_labels}"/>' name='newDiag' onclick="callDiagnosisOnClickOfBtn('<%=status%>','<%=status_flag%>')"></td>
						<td class='label' width='53%' align='right'> <fmt:message key="Common.Dependency.label" bundle="${common_labels}"/>&nbsp;</td>
						<td width='55%' align='left'>
							<select name='assessDepandency' id='assessDepandency'>
								<option value=''>-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
								<%
									try
									{
//										con = ConnectionManager.getConnection(request);
										//sqlDependency = "Select short_desc,dependency_code from cp_dependency ";
										sqlDependency = "Select short_desc,dependency_code from cp_dependency_lang_vw WHERE language_id=?";
										pstDepend = con.prepareStatement(sqlDependency);
										pstDepend.setString(1,locale);
										resDepend = pstDepend.executeQuery();
										while(resDepend.next())
										{	
											short_desc = resDepend.getString(1);
											depend_code = resDepend.getString(2);
											System.err.println("1assessDependency,depend_code :"+assessDependency+"="+depend_code);
											if(assessDependency.equals(depend_code))
											{
												dep_selected = " selected ";
												System.err.println("1selected:"+dep_selected);
											}
											else
											{
												dep_selected = "";
											}
											out.println("<option "+dep_selected+" value="+depend_code+">"+short_desc+"</option>");
										}
										resDepend.close();
										pstDepend.close();
//										if(con!=null) ConnectionManager.returnConnection(con,request);

									}
									catch(Exception e)
									{
										System.out.println("Exception in try-Dep of PatientAssessmentDiagnosis.jsp"+e.toString());
									}
								%>
							</select><img src='../../eCommon/images/mandatory.gif'>
						</td>
					</tr>
					<!-- <tr>
						<td colspan='4'>&nbsp;</td>
					</tr> -->
			</table>	
			<%
				}
				if(mode.equals("modify"))
				{
					if(!flag.equals("modAuth"))
					{
						//out.println("assess_ref_no= "+assess_ref_no);
				%>
					<table width='100%' align='center' border=0 cellpadding='5' cellspacing=0>
						<!-- <tr>
							<td colspan='3'>&nbsp;</td>
						</tr> -->
						<tr>
							<td class='data' width='8%' align='left'><fmt:message key="Common.Dependency.label" bundle="${common_labels}"/>:&nbsp;</td>
							<td class='label' width='45%' align='left'><%=ua_dep_desc%></td>
							<!-- <td width='75%' align='right'><a href='javascript:' onclick="showDesc('<%=assess_ref_no%>','SystemDefined','<%=ss_dep_desc%>')"><U>System Suggested</U></a></td> -->
						</tr>
						<!-- <tr>
							<td colspan='3'>&nbsp;</td>
						</tr> -->
					</table>
				<%
					}
					if(flag.equals("modAuth"))
					{
				%>
					<table width='100%' align='right' border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td class='Data' width='15%' align='left'> <fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></td>
						<td width='15%' align='left'> <input type='button' class='button' value='<fmt:message key="eCP.AddNew.label" bundle="${cp_labels}"/>' name='newDiag' onclick='callDiagnosisOnClickOfBtn()'></td>
						<td class='label' width='55%' align='right'> <fmt:message key="Common.Dependency.label" bundle="${common_labels}"/>&nbsp;</td>
						<td width='55%' align='left'>
							<select name='assessDepandency' id='assessDepandency'>
								<option value=''>-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
								<%
									try
									{
//										con = ConnectionManager.getConnection(request);
										sqlDependency = "Select short_desc,dependency_code from cp_dependency ";
										pstDepend = con.prepareStatement(sqlDependency);
										resDepend = pstDepend.executeQuery();
										while(resDepend.next())
										{	
											short_desc = resDepend.getString(1);
											depend_code = resDepend.getString(2);
											System.err.println("2assessDependency,depend_code :"+assessDependency+"="+depend_code);
											if(assessDependency.equals(depend_code))
											{
												dep_selected = " selected ";
												System.err.println("2selected");
											}
											else
											{
												dep_selected = "";
											}
											out.println("<option "+dep_selected+" value="+depend_code+">"+short_desc+"</option>");
										}
										resDepend.close();
//										if(con!=null) ConnectionManager.returnConnection(con,request);

									}
									catch(Exception e)
									{
										System.out.println("Exception in try-Dep of PatientAssessmentDiagnosis.jsp"+e.toString());
									}
								%>
							</select><img src='../../eCommon/images/mandatory.gif'>
						</td>
					</tr>				
			</table>	
				<%		
					}				
				}
				%>
				<input type='hidden' name='ua_dep_code' id='ua_dep_code' value='<%=ua_dep_code%>'>
				<input type='hidden' name='ss_dep_code' id='ss_dep_code' value='<%=assessDependency%>'>
				<input type='hidden' name='abnormalCateg' id='abnormalCateg' value='<%=abnormalCateg%>'>
			</form>
		</body>
		<%
			}
			catch(Exception e)
			{
				System.out.println("Exception in try-main of PatientAssessmentDependency.jsp:"+e.toString());
			}
			finally
			{
				if(resDesc != null) resDesc.close();
				if(resDepend != null) resDepend.close();
				if(psDesc != null) psDesc.close();
				if(pstDepend != null) pstDepend.close();
				if(cs != null) cs.close();
				if(con!=null) ConnectionManager.returnConnection(con,request);
			}
		%>
</html>

