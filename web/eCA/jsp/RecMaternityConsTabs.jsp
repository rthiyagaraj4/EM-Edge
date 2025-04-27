<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@page import="org.w3c.dom.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
<html>

	<head>
		<%
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale = (String) p.getProperty("LOCALE");
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			String queryString = request.getQueryString() == null ? "" : request.getQueryString();
			String patientId = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
			String accessionNum = request.getParameter("accessionNum") == null ? "" : request.getParameter("accessionNum");
			String encounterId = request.getParameter("episode_id") == null ? "" : request.getParameter("episode_id");
			String sec_hdg_code = request.getParameter("sec_hdg_code") == null ? "" : request.getParameter("sec_hdg_code");
			String subSecHdgCode1 = request.getParameter("sub_sec_hdg_code") == null ? "" : request.getParameter("sub_sec_hdg_code");
			//String prevSecHdgCode = request.getParameter("prevSecHdgCode") == null ? "" : request.getParameter("prevSecHdgCode");
			String sectionType = request.getParameter("sectionType") == null ? "" : request.getParameter("sectionType");
			String modeValue = request.getParameter("modeValue") == null ? "" : request.getParameter("modeValue");
			String splty_event_code = request.getParameter("splty_event_code") == null ? "" : request.getParameter("splty_event_code");
			String OCmode = request.getParameter("OCmode") == null ? "" : request.getParameter("OCmode");
			String cycle_no = request.getParameter("cycle_no") == null ? "" : request.getParameter("cycle_no");
			String module_id = request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
			String splty_task_code = request.getParameter("splty_task_code") == null ? "" : request.getParameter("splty_task_code");
			String hrmode = request.getParameter("HRmode") == null ? "" : request.getParameter("HRmode");
			String dob=request.getParameter("Dob") == null ? "" : request.getParameter("Dob");
			String sex=request.getParameter("Sex") == null ? "" : request.getParameter("Sex");

			//String prevSubSecHdgCode = request.getParameter("prevSubSecHdgCode") == null ? "" : request.getParameter("prevSubSecHdgCode");
			String subSecHdgCode = "";
			String firstSubSecHdgCode = "";
//			String SubSecHdgCode = "";
			String subSecHdgDesc= "";
			
			int cnt = 0;		
			
			String outcomeval		= "";
			String outcomecode		= "";
			String outcome_desc		= "";
			String action_type		= "";
			String action_code		= "";
			String close_episode_yn = "";
			String outcome_event_code = "";
			Connection con = null;
			PreparedStatement pstmt = null;
			PreparedStatement pstmt1 = null;
			ResultSet res = null;
			ResultSet res1 = null;
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script src='../../eCA/js/RecMaternityCons.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<form name='matConsTabsForm' id='matConsTabsForm'>
		<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'> <!-- onLoad ="dfltTab()" -->
		<%if(!sectionType.equals("OC")) {%>	
		<center>
			<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
				<tr>
					<td width= "100%" class="white">
				<%	/* if(sectionType.equals("TG")&&modeValue.equals("V"))
					{  }
					else {%> 
						<!-- <ul id="tablist" class="tablist" >
						<li class="tablistitem" title=''> -->
					<%//} */
						try
						{
							con = ConnectionManager.getConnection(request);
							if ( sectionType.equals("TM") )
							{
									pstmt = con.prepareStatement("select SEC_HDG_DESC short_desc from CA_SECTION_HDG where SEC_HDG_CODE = ? ");
									pstmt.setString(1,sec_hdg_code);
									res = pstmt.executeQuery();
									if ((res!=null) && res.next())
									{

										subSecHdgDesc = res.getString("short_desc") == null ? "" : res.getString("short_desc");
										
										/*if(!splty_task_code.equals("MCT002"))
										{
											out.println("<a  onclick=\"loadMatDetailPage('"+sec_hdg_code+"','"+sec_hdg_code+"')\" class=\"tabClicked\"><span class='tabSpanclicked'>	<b>"+subSecHdgDesc+"</b></span></a> </li>");
										}*/
										if(splty_task_code.equals("MCT002"))
										{
											out.println("<a  onclick=\"loadMatDetailPage3('"+sec_hdg_code+"','"+sec_hdg_code+"','record_tab','"+splty_event_code+"')\" class=\"tabClicked\" id=\"record_tab\"><span class='tabSpanclicked' id='record_tabspan'>	<b>Record</b></span></a> </li>");

											out.println("<a  onclick=\"loadMatViewPage('"+sec_hdg_code+"','"+sec_hdg_code+"','view_tab')\" class=\"tabClicked\" id=\"view_tab\"><span class='tabSpanclicked' id='view_tabspan'>	<b>View</b></span></a> </li>");
										}
										if(!splty_task_code.equals("MCT002")&& !(modeValue.equals("V"))  )
										{
										
											out.println("<span class='tabSpanclicked'>	"+subSecHdgDesc+"</span></li>");
										}
										firstSubSecHdgCode=sec_hdg_code;
									}
									
								if(modeValue.equals("V"))
								{
									%>
											<script>
											//alert('queryString...'+'<%=queryString%>');
											parent.recMatConsDetailsFrame.location.href='../../eCA/jsp/RecMaternityConsView.jsp?<%=queryString%>';
											
											top.content.messageFrame.location.href="../../eCommon/jsp/error.jsp";
											</script>
									<%

								
								}



							}
							else if (sectionType.equals("TG"))
							{
								/* pstmt = con.prepareStatement("select count(*) from CA_SUBSECTION_LINK_VW where HEADER_SEC_HDG_CODE = ? ");
								pstmt.setString(1,sec_hdg_code);
								res = pstmt.executeQuery();
								while(res.next())
								{
									cnt = res.getInt(1);
								}

								if(pstmt != null) pstmt.close();
								if(res != null) res.close();*/

								  //here
								if(modeValue.equals("V"))
								{
									%>
											<script>
											//alert('queryString...'+'<%=queryString%>');
											parent.recMatConsDetailsFrame.location.href='../../eCA/jsp/RecMaternityConsView.jsp?<%=queryString%>';
											top.content.messageFrame.location.href="../../eCommon/jsp/error.jsp";
											</script>
									<%

								
								}


								
								  if(!hrmode.equals("H"))
									  {

										pstmt = con.prepareStatement("select CHILD_SEC_HDG_CODE,CHILD_SEC_HDG_DESC from CA_SUBSECTION_LINK_VW where HEADER_SEC_HDG_CODE = ? and CHILD_SEC_HDG_CODE = ? ");
									  }
									  else
									  {
										  pstmt = con.prepareStatement("select CHILD_SEC_HDG_CODE,CHILD_SEC_HDG_DESC from CA_SUBSECTION_LINK_VW where HEADER_SEC_HDG_CODE = ? AND  CHILD_SEC_HDG_CODE ='MC03' ");
										
									  }
									pstmt.setString(1,sec_hdg_code);
									if(!hrmode.equals("H"))
									{
									pstmt.setString(2,subSecHdgCode1);
									}
									res = pstmt.executeQuery();
									while(res.next())
									{
										
										if(modeValue.equals("V"))
										{
										
											subSecHdgCode = res.getString("CHILD_SEC_HDG_CODE") == null ? "" : res.getString("CHILD_SEC_HDG_CODE");
											subSecHdgDesc = res.getString("CHILD_SEC_HDG_DESC") == null ? "" : res.getString("CHILD_SEC_HDG_DESC");
											
											//htmContent.append("<a href=\"#Mothercare Template 3\">Mothercare Template 3</a>");
											
											//out.println("<a href=\"../../eCA/jsp/RecMaternityConsView.jsp?"+queryString+"#"+subSecHdgDesc+"\" target=\"recMatConsDetailsFrame\"               >["+subSecHdgDesc+"]</a>"); // </li>
											
											//out.println("<a href=\"../../eCA/jsp/RecMaternityConsView.jsp#"+subSecHdgDesc+"\" target=\"recMatConsDetailsFrame\"  onclick=\"loadMatDetailPage2('"+sec_hdg_code+"','"+subSecHdgCode+"','"+cnt+"')\"             class=\"tabClicked\" id=\"sh_tab"+cnt+"\" ><span class='tabSpanclicked' id='sh_tabspan"+cnt+"'>	"+subSecHdgDesc+"</span></a></li>");


											//out.println("<a onclick=\"loadMatDetailPage1('"+sec_hdg_code+"','"+subSecHdgCode+"','"+cnt+"')\" class=\"tabClicked\" id=\"sh_tab"+cnt+"\" ><span class='tabSpanclicked' id='sh_tabspan"+cnt+"'>	"+subSecHdgDesc+"</span></a></li>");
											//out.println("<a href='javascript:' onclick=\"loadMatDetailPage('"+sec_hdg_code+"','"+subSecHdgCode+"')\" ><span class='tabSpanclicked'>	"+subSecHdgDesc+"</span></a></li>");
											cnt++;
											//if (cnt==1) firstSubSecHdgCode=sec_hdg_code ;
											if (cnt==1) firstSubSecHdgCode=subSecHdgCode ;

										}
										else 
										{
											
											subSecHdgCode = res.getString("CHILD_SEC_HDG_CODE") == null ? "" : res.getString("CHILD_SEC_HDG_CODE");
											subSecHdgDesc = res.getString("CHILD_SEC_HDG_DESC") == null ? "" : res.getString("CHILD_SEC_HDG_DESC");

											out.println("<a  class=\"tabClicked\" id=\"sh_tab"+cnt+"\" ><span class='tabSpanclicked' id='sh_tabspan"+cnt+"'>	"+subSecHdgDesc+"</span></a></li>");
											//out.println("<a href='javascript:' onclick=\"loadMatDetailPage('"+sec_hdg_code+"','"+subSecHdgCode+"')\" ><span class='tabSpanclicked'>	"+subSecHdgDesc+"</span></a></li>");
											cnt++;
											//if (cnt==1) firstSubSecHdgCode=sec_hdg_code ;
											if (cnt==1) firstSubSecHdgCode=subSecHdgCode ;
											
									    }
									}
								if(res!=null) res.close();
								if(pstmt!=null) pstmt.close();
								//if(con!=null) con.close();
								//if(con!=null) ConnectionManager.returnConnection(con,request);
								

							}
						}
		    
						catch(Exception e)
						{							
							e.printStackTrace();
						}finally{
							if(con!=null) ConnectionManager.returnConnection(con,request);
						}
													
					

				}//end if(sectionType.equals("OC") loadTemplate()
			else
			{ %>
			  <table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
					<tr>
					<td class='label' width='25%'><fmt:message key="Common.outcome.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%'>
					<select name='OutCome' id='OutCome'onChange="chk_event_status()">
					<option value="">&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- &nbsp;&nbsp;&nbsp;&nbsp;</option>
					<%
					try{
						if(OCmode.equals("V")){

						String QueryOutcome1 ="SELECT ACTION_CODE,CA_GET_DESC.CA_SPLTY_OUTCOME(OUTCOME_CODE ,?,'1') outcome_desc FROM CA_SPLTY_EVENT_OUTCOME WHERE SPLTY_EVENT_CODE=? AND  ACTION_CODE =( select DISTINCT b.hdr_code from CA_PAT_SPLTY_EPISODE_TASK a, CA_PAT_SPLTY_TASK_DTL b  where a.patient_id = ? and a.module_id =?  and a.cycle_no = ? and a.ACCESSION_NUM = b.ACCESSION_NUM and a.SPLTY_EVENT_CODE = ? and b.XML_CONTENT is not null )";

						if(con==null)
						con = ConnectionManager.getConnection(request);
						
						pstmt1 = con.prepareStatement(QueryOutcome1);
						
						pstmt1.setString(1,locale);
						pstmt1.setString(2,splty_event_code);
						pstmt1.setString(3,patientId);
						pstmt1.setString(4,module_id);
						pstmt1.setString(5,cycle_no);
						pstmt1.setString(6,splty_event_code);
						res1 = pstmt1.executeQuery();
						while(res1.next())
							{
							action_code = res1.getString("ACTION_CODE") == null ? "" : res1.getString("ACTION_CODE");
							outcome_desc = res1.getString("outcome_desc") == null ? "" : res1.getString("outcome_desc");
							}
							%>
								
							<option value='<%=action_code%>' selected disabled ><%=outcome_desc%> </option>
						<%
						if(res1!=null) res1.close();
						if(pstmt1!=null) pstmt1.close();
						}
						else
						{
						String QueryOutcome="select A.OUTCOME_CODE, CA_GET_DESC.CA_SPLTY_OUTCOME(A.OUTCOME_CODE ,?,'1') outcome_desc, A.ACTION_TYPE,A.ACTION_CODE ,A.CLOSE_EPISODE_YN,A.OUTCOME_EVENT_CODE from CA_SPLTY_EVENT_OUTCOME A,CA_SPLTY_OUTCOME B where A.OUTCOME_CODE=B.OUTCOME_CODE AND A.SPLTY_EVENT_CODE=? and not exists (select 1 from CA_PAT_SPLTY_EPISODE_EVENT where patient_id=? and MODULE_ID=? and CYCLE_NO =? and SPLTY_EVENT_CODE = nvl(A.OUTCOME_EVENT_CODE,'***') ) and (B.AGE_GROUP is null or EXISTS ( SELECT 1 FROM AM_AGE_GROUP IA  WHERE IA.AGE_GROUP_CODE=B.AGE_GROUP AND   TRUNC(SYSDATE)-to_date(?,'dd/mm/yyyy') BETWEEN         DECODE(IA.AGE_UNIT,'D',IA.MIN_AGE,'M',30*IA.MIN_AGE,'Y',365*IA.MIN_AGE)  AND  DECODE(IA.AGE_UNIT,'D',IA.MAX_AGE,'M',30*IA.MAX_AGE,'Y',365*IA.MAX_AGE)     AND  NVL(IA.GENDER,?)=? )) ORDER BY 2  ";
						if(con==null)
						con = ConnectionManager.getConnection(request);
						
								pstmt1 = con.prepareStatement(QueryOutcome);
								
						pstmt1.setString(1,locale);
						pstmt1.setString(2,splty_event_code);
						pstmt1.setString(3,patientId);
						pstmt1.setString(4,module_id);
						pstmt1.setString(5,cycle_no);
						pstmt1.setString(6,dob);
						pstmt1.setString(7,sex);
						pstmt1.setString(8,sex);
						res1 = pstmt1.executeQuery();
						
							while(res1.next())
							{
								
								outcomecode = res1.getString("OUTCOME_CODE") == null ? "" : res1.getString("OUTCOME_CODE");
								outcome_desc = res1.getString("outcome_desc") == null ? "" : res1.getString("outcome_desc");
								action_type = res1.getString("ACTION_TYPE") == null ? "" : res1.getString("ACTION_TYPE");
								action_code = res1.getString("ACTION_CODE") == null ? "" : res1.getString("ACTION_CODE");
								close_episode_yn = res1.getString("CLOSE_EPISODE_YN") == null ? "" : res1.getString("CLOSE_EPISODE_YN");
								outcome_event_code = res1.getString("OUTCOME_EVENT_CODE") == null ? "" : res1.getString("OUTCOME_EVENT_CODE");
								
								outcomeval= outcomecode+"~"+action_type+"~"+action_code+"~"+close_episode_yn+"~"+outcome_event_code;
								if(!splty_event_code.equals("MCE005") && !splty_event_code.equals("MCE006"))
								{
									
								%>
								
								<option value='<%=outcomeval%>'><%=outcome_desc%></option>
								<%
								}
								else if((splty_event_code.equals("MCE005") || splty_event_code.equals("MCE006")) && outcome_event_code.equals(""))
								{									
									
								%>
									<option value='MCO001~~~H~'><%=outcome_desc%></option>
								<%
								}																				
							}
						
						if(res1!=null) res1.close();
						if(pstmt1!=null) pstmt1.close();
						}
						}
						catch(Exception e)
						{							
							e.printStackTrace();
						}
						finally
						{
							if(con != null) ConnectionManager.returnConnection(con,request);
						}		

					%>
					</select></td><td width='25%'> </td> <td width='25%'> </td>
										
					</tr>
				  </table>
			<%}		



					if(sectionType.equals("TG")&&modeValue.equals("V")){}
				else {%> 
					</ul> <%}%>
					</td>
				</tr>
			</table>
		</body>
		<input type='hidden' name='queryString' id='queryString' value='<%=queryString%>'>
		<input type='hidden' name='prevSecHdgCode' id='prevSecHdgCode' value='	'>
		<input type='hidden' name='prevSubSecHdgCode' id='prevSubSecHdgCode' value=''>
		<input type='hidden' name='sec_hdg_code' id='sec_hdg_code' value=''>
		<input type='hidden' name='sub_sec_hdg_code' id='sub_sec_hdg_code' value=''>
		<input type='hidden' name='accessionNum' id='accessionNum' value='<%=accessionNum%>'>
		<input type="hidden" name="no_of_rows" id="no_of_rows" value="">
		<input type="hidden" name="count" id="count" value='<%=cnt%>'>
		<input type="hidden" name="modeValue" id="modeValue" value='<%=modeValue%>'>
		<input type="hidden" name="sectionType" id="sectionType" value='<%=sectionType%>'>
		<input type="hidden" name="close_episode_yn" id="close_episode_yn" value=''>
		<input type="hidden" name="outcome_event_code" id="outcome_event_code" value=''>
		<input type="hidden" name="splty_task_code" id="splty_task_code" value='<%=splty_task_code%>'>
		<input type="hidden" name="outcome_code" id="outcome_code" value=''>
		<input type="hidden" name="patient_id" id="patient_id" value='<%=patientId%>'>
		<input type="hidden" name="splty_event_code" id="splty_event_code" value='<%=splty_event_code%>'>
		<input type="hidden" name="cycle_no" id="cycle_no" value='<%=cycle_no%>'>
		<input type="hidden" name="module_id" id="module_id" value='<%=module_id%>'>

	</form>
</html>
<%
	
	webbeans.eCA.RecClinicalNotesSectionBean matBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("matBean","webbeans.eCA.RecClinicalNotesSectionBean",session);
	String strKey	=	"";
	strKey = patientId + "~"+ encounterId;
	strKey = strKey.trim();
	matBean.getPatientSection(strKey);
	if (!subSecHdgCode1.equals("")&&!sectionType.equals("OC"))
	{
		out.println("<script>loadMatDetailPage('"+sec_hdg_code+"','"+subSecHdgCode1+"');</script>");
		out.println("<script>top.content.messageFrame.location.href='../../eCommon/jsp/error.jsp';</script>");
	}
	if(sectionType.equals("OC")&&OCmode.equals("V")){
		out.println("<script>document.matConsTabsForm.OutCome.disabled=true;</script>");
		out.println("<script>parent.recMatConsDetailsFrame.location.href = '../../eCA/jsp/RecMaternityConsView.jsp?"+request.getQueryString()+"&sec_hdg_code="+action_code+"&accessionNum="+accessionNum+"';</script>");
		out.println("<script>top.content.messageFrame.location.href='../../eCommon/jsp/error.jsp';</script>");
	}
	
%>

