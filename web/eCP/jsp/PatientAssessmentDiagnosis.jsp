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
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	</head>
	<body onmouseDown='CodeArrest();'>
		<script>
			document.body.style.scrollbarBaseColor='#E2E3F0';
			document.body.style.scrollbarArrowColor='#000080';
		</script>
		<form name='patAssessDiagnosisForm' id='patAssessDiagnosisForm' action=''>
		<%
			String mode = request.getParameter("mode") == null ? "" : request.getParameter("mode");
			String status_flag = request.getParameter("status_flag") == null ? "" : request.getParameter("status_flag");
			String accession_num = request.getParameter("accession_num") == null ? "" : request.getParameter("accession_num");
			String note_type = request.getParameter("note_type") == null ? "" : request.getParameter("note_type");
			String assess_ref_no = request.getParameter("assess_ref_no") == null ? "" : request.getParameter("assess_ref_no");
			String flag = request.getParameter("flag") == null ? "" : request.getParameter("flag");
			String ss_dep_desc = request.getParameter("ss_dep_desc") == null ? "" : request.getParameter("ss_dep_desc");
			String flag_int = request.getParameter("flag_int") == null ? "0" : request.getParameter("flag_int");
			String facility_id = (String) session.getAttribute("facility_id");

			String assess_catg_code = "";
			String current_mapTermSetDesc_disp = "";
			String abnormalCateg = "";
			String keys_disp = "";
			String mapTermSetId_disp = "";
			String mapTermCode_disp = "";
			//String flag_ss_ua_disp = "";
			String mapDesc_disp = "";
			String mapTermSetDesc_disp = "";
			String mapDiagDesc_disp = "";
			//String term_code_id = "";
			String term_set_desc = "";
			String term_code_desc = "";
			String cur_term_set_desc = "";
			String classValue = "";
			String mapValue = "";
			String current_term_code = "";  
			String keys = "";
			String mapTermSetDesc = "";
			String mapDiagDesc = "";
			String occur_srl_no = "";
			String innerTextColor = "";
			String mapDesc = "";
			String mapTermSetId = "";
			String mapTermCode = "";
			String flag_ss_ua = "";
			String current_mapTermSetDesc  = "";
			String sqlDiagnosis_ss  = "";
			String term_set_id_ss  = "";
			String term_set_desc_ss  = "";
			String term_code_ss  = "";
			String term_desc_ss  = "";
			String keys_ss  = "";
			String values_ss  = "";

			StringTokenizer abnCategToken = null;
			int count = 0;
			int i = 0;
			int k = 0;
			int i_ss = 0;
			int k_ss = 0;

			ArrayList list = new ArrayList();
			ArrayList list_ss = new ArrayList();

			StringTokenizer termCodeToken = null;
			StringTokenizer termCodeToken_disp = null;
			StringTokenizer diagToken = null;
			StringTokenizer diagToken_disp = null;

			Connection con = null;
			ResultSet resDesc = null;
			ResultSet resDesc_ss = null;
			ResultSet resDiagnosis1 = null;
			PreparedStatement psDesc = null;
			PreparedStatement pstDiagnosis_ss = null;
			PreparedStatement pstDiagnosis1 = null;
			CallableStatement cs = null;
	try{		
			try
			{
				con = ConnectionManager.getConnection(request);
				cs = con.prepareCall("{call CP_GET_ASSESS_OUTPUT(?,?,?,?,?)}" );
							
				cs.setString(1,accession_num);
				cs.setString(2,facility_id);
				cs.setString(3,note_type);
				cs.registerOutParameter(4,Types.VARCHAR);
				cs.registerOutParameter(5,Types.VARCHAR);
				cs.execute();				
				abnormalCateg = cs.getString(5) == null ? "" : cs.getString(5);			


				abnCategToken = new StringTokenizer(abnormalCateg,"~");
				while(abnCategToken.hasMoreTokens())
				{
					if(assess_catg_code.equals(""))
						assess_catg_code = assess_catg_code +("'" + assess_catg_code + abnCategToken.nextToken() + "'");
					else
						assess_catg_code = assess_catg_code +("'" + assess_catg_code + abnCategToken.nextToken() + "',");
				}
			}
			catch(Exception e)
			{
				System.err.println("@@@@@@@@@@Diag"+e.toString());
				e.printStackTrace(System.err);
			}

			if(mode.equals("modify") && !flag.equals("modAuth"))
			{
		%>		
			<table width='100%' align='center' border=1 cellpadding=1 cellspacing=1 id='selTable'>
				<tr id='trId'>
					<th colspan='2' align='left' style='BACKGROUND-COLOR:#ffc5b5;color:black'><a href='javascript:' onclick="showDesc('<%=assess_ref_no%>','SystemDefined','<%=ss_dep_desc%>')">Diagnosis</a></th>
				</tr>				
			<%
			try
			{
				//con = ConnectionManager.getConnection(request);
				String sql_diag_desc = "SELECT distinct a.term_set_id, b.TERM_SET_DESC , a.term_code, c.short_desc  diag_desc FROM mr_term_set b ,mr_term_code c,CP_PAT_ASSESS_UA_TERM_CODE  a WHERE b.term_set_id = a.term_set_id AND c.term_set_id =a.term_set_id AND c.term_code=a.term_code AND (c.term_set_id ,c.term_code) IN (SELECT term_set_id ,term_code FROM cp_pat_assess_ua_term_code WHERE assess_ref_no=?) order by b.TERM_SET_DESC";
				psDesc = con.prepareStatement(sql_diag_desc);
				psDesc.setString(1,assess_ref_no);

				
				resDesc = psDesc.executeQuery();
				while(resDesc.next())
				{
					//term_code_id = resDesc.getString(3);
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
					out.println(" "+term_code_desc+" ");
					out.println("</td>");
					out.println("</tr>");

					cur_term_set_desc = term_set_desc;
					count++;
				}

			}
			catch(Exception e)
			{
				System.out.println("Exception in try of PatientAssessmentShowDescMain.jsp"+e.toString());
			}
			finally
			{
				if(resDesc != null) resDesc = null;
				if(psDesc != null) psDesc = null;
//				if(con != null) ConnectionManager.returnConnection(con);
			}
			%>
				</table>
			<%
		}//end of if mode modify and Authorized
			PreparedStatement pstDiagnosis		 = null;
			ResultSet resDiagnosis				 = null;
		if(mode.equals("modify") && flag.equals("modAuth"))
		{
			
			String term_code = request.getParameter("term_code") == null ? "" : request.getParameter("term_code");
			String term_set_id = request.getParameter("term_set_id") == null ? "" : request.getParameter("term_set_id");

			pstDiagnosis = null;
			resDiagnosis = null;

			String current_term_set_desc = "";
			String mapKey = "";
			%>
			<table width='100%' align='center' border=1 cellpadding=1 cellspacing=1 id='selTable'>
				<tr id='trId'>
					<th colspan='2' align='left' style='BACKGROUND-COLOR:#ffc5b5;color:black'><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></th>
				</tr>
				<tr id='trId'>			
					<th><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
				</tr>
			<%

			try
			{			
				//con = ConnectionManager.getConnection(request);
				if(flag_int.equals("0"))
				{				
					try
					{	
						sqlDiagnosis_ss = "SELECT a.term_set_id, b.TERM_SET_DESC, a.term_code, c.short_desc  diag_desc FROM cp_trgd_term_code_at_assmt a ,mr_term_set b,mr_term_code c where ASSESS_CATG_CODE in ("+(assess_catg_code.equals("")?"''":assess_catg_code)+")  and b.term_set_id = a.term_set_id and c.term_set_id =a.term_set_id and c.term_code=a.term_code";
						pstDiagnosis_ss = con.prepareStatement(sqlDiagnosis_ss);
						resDesc_ss = pstDiagnosis_ss.executeQuery();
						
						while(resDesc_ss.next())
						{
							term_set_id_ss = resDesc_ss.getString(1);
							term_set_desc_ss = resDesc_ss.getString(2);
							term_code_ss = resDesc_ss.getString(3);
							term_desc_ss = resDesc_ss.getString("diag_desc");
							keys_ss = term_set_id_ss + "$" +  term_code_ss + "$" + "SS";
							values_ss = term_set_desc_ss + "~" +  term_desc_ss + "~" + term_set_id_ss;
							diagBean.addDiagnosis(keys_ss, values_ss);						
						}
						resDesc_ss.close();
						pstDiagnosis_ss.close();

						i_ss = diagBean.getSize();
						list_ss = diagBean.getKeySet();
						for(k_ss=0;k_ss<i_ss;k_ss++)
						{
							keys_disp = (String) list_ss.get(k_ss);
							termCodeToken_disp = new StringTokenizer(keys_disp,"$");
							mapTermSetId_disp = termCodeToken_disp.nextToken();
							mapTermCode_disp = termCodeToken_disp.nextToken();
							//flag_ss_ua_disp = termCodeToken_disp.nextToken();

							mapDesc_disp = diagBean.getDiagRecords(keys_disp);
							diagToken_disp = new StringTokenizer(mapDesc_disp,"~");

							mapTermSetDesc_disp = diagToken_disp.nextToken();
							mapDiagDesc_disp = diagToken_disp.nextToken();

							if(count%2 == 0)
								classValue = "QRYEVEN";
							else
								classValue = "QRYODD";

							innerTextColor = "marroon";

							if(!(mapTermSetDesc_disp.equals(current_mapTermSetDesc_disp)))
							{
								out.println("<tr>");
								out.println("<td colspan='3' class='CAGROUPHEADING'>");
								out.println(" "+mapTermSetDesc_disp+" ");
								out.println("</td>");						
								out.println("</tr>");
							}
							out.println("<tr>");
							out.println("<td class='"+classValue+"'><font color=\""+innerTextColor+"\"><a href='javascript:' onclick='callDiagnosisOnClickOfHyperLink(\""+mapTermSetId_disp+"\",\""+mapTermCode_disp+"\",\""+mapDiagDesc_disp+"\")'>");
							out.println(" "+mapDiagDesc_disp+" ");
							out.println("</a></font>");
							out.println("</td>");
							out.println("<td class='"+classValue+"'> ");
							out.println("<input type='checkbox' checked name='chk_yn"+count+"' id='chk_yn"+count+"'>");
							out.println("</td>");
							out.println("</tr>");
							count++;
							current_mapTermSetDesc_disp = mapTermSetDesc_disp;
						}
					}
					catch(Exception e)
					{
						System.out.println("Exception in try@@@@@4 of PatientAssessmentDiagnosis.jsp"+e.toString());
						e.printStackTrace(System.err);
					}
				}
				else if(flag_int.equals("1"))
				{
					try
					{
						String sqlDiagnosis = "SELECT b.term_set_id, b.TERM_SET_DESC, c.term_code, c.short_desc  diag_desc FROM mr_term_set b, mr_term_code c WHERE b.term_set_id  = ? AND term_code = ? AND b.term_set_id = c.term_set_id";
						pstDiagnosis = con.prepareStatement(sqlDiagnosis);
						pstDiagnosis.setString(1,term_set_id);
						pstDiagnosis.setString(2,term_code);
						mapKey = term_set_id + "$" + term_code + "$" + "UA";
						resDiagnosis = pstDiagnosis.executeQuery();
						//out.println("<script>");
						while(resDiagnosis.next())
						{
							current_term_set_desc = resDiagnosis.getString(2);
							term_code_desc = resDiagnosis.getString("diag_desc");
							mapValue = current_term_set_desc + "~" + term_code_desc + "~" + term_set_id;

							if((diagBean.checkForDups(mapValue)))
							{
								ArrayList list_temp = new ArrayList();
								list_temp = diagBean.getKeySet();
								int list_size = list_temp.size();
								int temp = 0;
								StringTokenizer tempToken = null;
								String tempKeys = "";
								String tempTermCode = "";

								for(temp=0; temp<list_size;temp++)
								{
									tempKeys = (String) list_temp.get(temp);
									tempToken = new StringTokenizer(tempKeys,"$");
									tempTermCode = tempToken.nextToken();
									
									if(term_code.equals(tempTermCode)) 
									{
										current_term_code = "true";
										break;
									}
								}
								if(!current_term_code.equals("true"))
								{
									diagBean.addDiagnosis(mapKey,mapValue);
								}									
							}
							else
							{									
								diagBean.addDiagnosis(mapKey, mapValue);									
							}
						}//end of while

						resDiagnosis.close();
						pstDiagnosis.close();

						i = diagBean.getSize();
						list = diagBean.getKeySet();
						for(k=0;k<i;k++)
						{
							keys = (String) list.get(k);
							termCodeToken = new StringTokenizer(keys,"$");
							mapTermSetId = termCodeToken.nextToken();
							mapTermCode = termCodeToken.nextToken();
							flag_ss_ua = termCodeToken.nextToken();
							
							if(flag_ss_ua.equals("SS"))
							{
								innerTextColor = "marroon";
							}
							else
							{
								innerTextColor = "";
							}
							
							mapDesc = diagBean.getDiagRecords(keys);
							diagToken = new StringTokenizer(mapDesc,"~");

							mapTermSetDesc = diagToken.nextToken();
							mapDiagDesc = diagToken.nextToken();
							
							if(count%2 == 0)
								classValue = "QRYEVEN";
							else
								classValue = "QRYODD";

							if(!(mapTermSetDesc.equals(current_mapTermSetDesc)))
							{
								out.println("<tr>");
								out.println("<td colspan='3' class='CAGROUPHEADING'>");
								out.println(" "+mapTermSetDesc+" ");
								out.println("</td>");						
								out.println("</tr>");
							}
							out.println("<tr>");
							out.println("<td class='"+classValue+"'><font color=\""+innerTextColor+"\"><a href='javascript:' onclick='callDiagnosisOnClickOfHyperLink(\""+mapTermSetId+"\",\""+mapTermCode+"\",\""+mapDiagDesc+"\")'>");
							out.println(" "+mapDiagDesc+" ");
							out.println("</a></font>");
							out.println("</td>");
							out.println("<td class='"+classValue+"'> ");
							out.println("<input type='checkbox' checked name='chk_yn"+count+"' id='chk_yn"+count+"'>");
							out.println("</td>");
							out.println("</tr>");
							count++;
							current_mapTermSetDesc = mapTermSetDesc;
						}//end of for
					}
					catch(Exception e)
					{
						System.out.println("Exception in try@@@@@6 of PatientAssessmentDiagnosis.jsp"+e.toString());
						e.printStackTrace(System.err);
					}
				}
			}//end of try
			catch(Exception e)
			{
				System.out.println("Exception in try-modify-flag-true of PatientAssessmentDiagnosis.jsp"+e.toString());
				e.printStackTrace(System.err);
			}
			%>
			</table>
		<%
		}//end of modify NOT Authorized	
		
		if(!mode.equals("modify") && status_flag.equals("4"))
		{
			String term_code = request.getParameter("term_code") == null ? "" : request.getParameter("term_code");
			String term_set_id = request.getParameter("term_set_id") == null ? "" : request.getParameter("term_set_id");

/*			PreparedStatement pstDiagnosis = null;
			ResultSet resDiagnosis = null;*/

			String current_term_set_desc = "";
			String mapKey = "";
			%>
			<table width='100%' align='center' border=1 cellpadding=1 cellspacing=1 id='selTable'>				
				<tr id='trId'>			
					<th><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
				</tr>
			<%

			try
			{
				//con = ConnectionManager.getConnection(request);
				if(flag_int.equals("0"))
				{					
					//out.println("here 2");
					try
					{
//						con = ConnectionManager.getConnection(request);

						sqlDiagnosis_ss = "SELECT a.term_set_id, b.TERM_SET_DESC, a.term_code, c.short_desc  diag_desc FROM cp_trgd_term_code_at_assmt a ,mr_term_set b,mr_term_code c where ASSESS_CATG_CODE in ("+(assess_catg_code.equals("")?"''":assess_catg_code)+")  and b.term_set_id = a.term_set_id and c.term_set_id =a.term_set_id and c.term_code=a.term_code";
						pstDiagnosis_ss = con.prepareStatement(sqlDiagnosis_ss);
						resDesc_ss = pstDiagnosis_ss.executeQuery();

						while(resDesc_ss.next())
						{
							term_set_id_ss = resDesc_ss.getString(1);
							term_set_desc_ss = resDesc_ss.getString(2);
							term_code_ss = resDesc_ss.getString(3);
							term_desc_ss = resDesc_ss.getString("diag_desc");
							keys_ss = term_set_id_ss + "$" +  term_code_ss + "$" +"SS";
							values_ss = term_set_desc_ss + "~" +  term_desc_ss + "~" + term_set_id_ss;
							diagBean.addDiagnosis(keys_ss, values_ss);
						}

						resDesc_ss.close();
						pstDiagnosis_ss.close();

						i_ss = diagBean.getSize();
						list_ss = diagBean.getKeySet();

						for(k_ss=0;k_ss<i_ss;k_ss++)
						{
							keys_disp = (String) list_ss.get(k_ss);
							termCodeToken_disp = new StringTokenizer(keys_disp,"$");
							mapTermSetId_disp = termCodeToken_disp.nextToken();
							mapTermCode_disp = termCodeToken_disp.nextToken();
							//flag_ss_ua_disp = termCodeToken_disp.nextToken();

							mapDesc_disp = diagBean.getDiagRecords(keys_disp);
							diagToken_disp = new StringTokenizer(mapDesc_disp,"~");

							mapTermSetDesc_disp = diagToken_disp.nextToken();
							mapDiagDesc_disp = diagToken_disp.nextToken();
							
							if(count%2 == 0)
								classValue = "QRYEVEN";
							else
								classValue = "QRYODD";

							innerTextColor = "marroon";

							if(!(mapTermSetDesc_disp.equals(current_mapTermSetDesc_disp)))
							{
								out.println("<tr>");
								out.println("<td colspan='3' class='CAGROUPHEADING'>");
								out.println(" "+mapTermSetDesc_disp+" ");
								out.println("</td>");						
								out.println("</tr>");
							}
							out.println("<tr>");
							out.println("<td class='"+classValue+"'><font color=\""+innerTextColor+"\"><a href='javascript:' onclick='callDiagnosisOnClickOfHyperLink(\""+mapTermSetId_disp+"\",\""+mapTermCode_disp+"\",\""+mapDiagDesc_disp+"\")'>");
							out.println(" "+mapDiagDesc_disp+" ");
							out.println("</a></font>");
							out.println("</td>");
							out.println("<td class='"+classValue+"'> ");
							out.println("<input type='checkbox' checked name='chk_yn"+count+"' id='chk_yn"+count+"'>");
							out.println("</td>");
							out.println("</tr>");
							count++;
							current_mapTermSetDesc_disp = mapTermSetDesc_disp;
						}
					}
					catch(Exception e)
					{
						System.out.println("Exception in try@@@@2 of PatientAssessmentDiagnosis.jsp"+e.toString());
						e.printStackTrace(System.err);
					}
				}
				else if(flag_int.equals("1"))
				{				
					try
					{
						//con = ConnectionManager.getConnection(request);
						String sqlDiagnosis = "SELECT b.term_set_id, b.TERM_SET_DESC, c.term_code, c.short_desc  diag_desc FROM mr_term_set b, mr_term_code c WHERE b.term_set_id  = ? AND term_code = ? AND b.term_set_id = c.term_set_id";

						pstDiagnosis = con.prepareStatement(sqlDiagnosis);
						pstDiagnosis.setString(1,term_set_id);
						pstDiagnosis.setString(2,term_code);
						mapKey = term_set_id + "$" + term_code + "$" + "UA";
						resDiagnosis = pstDiagnosis.executeQuery();

						//out.println("<script>");
						while(resDiagnosis.next())
						{
							current_term_set_desc = resDiagnosis.getString(2);
							term_code_desc = resDiagnosis.getString("diag_desc");
							mapValue = current_term_set_desc + "~" + term_code_desc + "~" + term_set_id;

							if((diagBean.checkForDups(mapValue)))
							{
								ArrayList list_temp = new ArrayList();
								list_temp = diagBean.getKeySet();
								int list_size = list_temp.size();
								int temp = 0;
								StringTokenizer tempToken = null;
								String tempKeys = "";
								String tempTermCode = "";

								for(temp=0; temp<list_size;temp++)
								{
									tempKeys = (String) list_temp.get(temp);
									tempToken = new StringTokenizer(tempKeys,"$");
									tempTermCode = tempToken.nextToken();
									
									if(term_code.equals(tempTermCode)) 
									{
										current_term_code = "true";
										break;
									}
								}
								if(!current_term_code.equals("true"))
								{
									diagBean.addDiagnosis(mapKey,mapValue);
								}									
							}
							else
							{									
								diagBean.addDiagnosis(mapKey, mapValue);									
							}
						}//end of while

						resDiagnosis.close();
						pstDiagnosis.close();

						i = diagBean.getSize();
						list = diagBean.getKeySet();
						for(k=0;k<i;k++)
						{
							keys = (String) list.get(k);
							termCodeToken = new StringTokenizer(keys,"$");
							mapTermSetId = termCodeToken.nextToken();
							mapTermCode = termCodeToken.nextToken();
							flag_ss_ua = termCodeToken.nextToken();

							if(flag_ss_ua.equals("SS"))
							{
								innerTextColor = "marroon";
							}
							else
							{
								innerTextColor = "";
							}
							
							mapDesc = diagBean.getDiagRecords(keys);
							diagToken = new StringTokenizer(mapDesc,"~");

							mapTermSetDesc = diagToken.nextToken();
							mapDiagDesc = diagToken.nextToken();
							
							if(count%2 == 0)
								classValue = "QRYEVEN";
							else
								classValue = "QRYODD";

							if(!(mapTermSetDesc.equals(current_mapTermSetDesc)))
							{
								out.println("<tr>");
								out.println("<td colspan='3' class='CAGROUPHEADING'>");
								out.println(" "+mapTermSetDesc+" ");
								out.println("</td>");						
								out.println("</tr>");
							}
							out.println("<tr>");
							out.println("<td class='"+classValue+"'><font color=\""+innerTextColor+"\"><a href='javascript:' onclick='callDiagnosisOnClickOfHyperLink(\""+mapTermSetId+"\",\""+mapTermCode+"\",\""+mapDiagDesc+"\")'>");
							out.println(" "+mapDiagDesc+" ");
							out.println("</a></font>");
							out.println("</td>");
							out.println("<td class='"+classValue+"'> ");
							out.println("<input type='checkbox' checked name='chk_yn"+count+"' id='chk_yn"+count+"'>");
							out.println("</td>");
							out.println("</tr>");
							count++;
							current_mapTermSetDesc = mapTermSetDesc;
						}//end of for
					}
					catch(Exception e)
					{						
						System.out.println("Exception in try@@@@@@@@3 of PatientAssessmentDiagnosis.jsp"+e.toString());
					}
				}
			}//end of try
			catch(Exception e)
			{
				out.println("Exception in try of PatientAssessmentDiagnosis.jsp"+e.toString());
				e.printStackTrace(System.err);
			}
		}
		%>
		</table>
		<input type='hidden' name='srl_no' id='srl_no' value='<%=occur_srl_no%>'>
		<input type='hidden' name='chk_cnt' id='chk_cnt' value='<%=count%>'>
		<input type='hidden' name='abnormal_categ' id='abnormal_categ' value='<%=count%>'>
	</form>
</body>
<%
	}
		catch(Exception ex)
		{
			out.println("Exception @ last try "+ex.toString());
		}
		finally
		{
			if(resDesc != null) resDesc.close();
			if(resDesc_ss != null) resDesc_ss.close();
			if(resDiagnosis1 != null) resDiagnosis1.close();
			if(psDesc != null) psDesc.close();
			if(pstDiagnosis_ss != null) pstDiagnosis_ss.close();
			if(pstDiagnosis1 != null) pstDiagnosis1.close();
			if(cs != null) cs.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
%>
</html>

