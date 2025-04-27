<!DOCTYPE html>
	<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.sql.*,java.text.*,java.net.*,eCommon.XSSRequestWrapper" %>
	<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

	<html>
		<head>
			<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
			<script language='javascript' src='../../eCommon/js/common.js' ></script>		
			<script src='../js/MedRecRequest.js' language='javascript'>
			</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</head>
		<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String url="../../eCommon/jsp/commonToolbar.jsp?";
		String params = request.getQueryString() ;
		String source = url + params ;
		String call_function=request.getParameter("function_id")==null?"":request.getParameter("function_id");
		String fac_id					= (String) session.getValue( "facility_id" );
		String userid					= (String) session.getValue("login_user");
		String stage_no				= "";
		Connection con	= null;
		Statement stmt	= null;
		PreparedStatement pstmt	= null;
		Statement stmt1	= null;
		ResultSet rs	= null;
		ResultSet rs1	= null;
		String ca_install_yn = "N";
		String oper_stn_id = "";
		String oper_stn_id1 = "";
		try{
			if(call_function.equals("DIAG_RECODE")){	
					try{
						con		= ConnectionManager.getConnection(request);
						stmt		= con.createStatement();
						stmt1	= con.createStatement();
						rs			= stmt.executeQuery("SELECT install_yn FROM SM_MODULE WHERE module_id = 'CA'");	
						if ((rs != null) && (rs.next())){
							ca_install_yn = checkForNull(rs.getString("install_yn"),"N");
						}
						if(rs	 != null)   rs.close();
						if(stmt !=null) stmt.close();
					}catch(Exception exp){
						//out.println("Exception in CA Install.jsp : "+exp.toString());
						exp.printStackTrace();
					}
					stmt	= con.createStatement();
					rs = stmt.executeQuery("Select AM_OPER_STN_ACCESS_CHECK('"+fac_id+"','"+userid+"','C','','DIAG_PROC_RECODE_FOR_IP_YN') FROM dual") ;
					if(rs !=null && rs.next()){
						oper_stn_id=rs.getString(1);
						//out.println("<script>alert(\""+oper_stn_id+"\");</script>");

					}
					if(rs	 != null)   rs.close();
					if(stmt !=null) stmt.close();


					rs1 = stmt1.executeQuery("Select AM_OPER_STN_ACCESS_CHECK('"+fac_id+"','"+userid+"','C','','DIAG_PROC_RECODE_FOR_OP_YN') FROM dual") ;

					if(rs1 !=null && rs1.next()){
						oper_stn_id1=rs1.getString(1);
						//out.println("<script>alert(\""+oper_stn_id1+"\");</script>");
					}
					if(rs1	 != null)   rs1.close();
					if(stmt1 !=null) stmt1.close();
					if(oper_stn_id.equals("1") && oper_stn_id1.equals("1")){%>
						<script>
							alert(getMessage('NO_OPER_STN_FOR_USER','Common'));
							//location.href='../../eCommon/jsp/home.jsp';
							document.location.href='../../eCommon/jsp/dmenu.jsp';
						</script>
					<%}else if(oper_stn_id.equals("2") && oper_stn_id1.equals("2")){
							out.print(" <script>alert(getMessage('NO_CLINICS_FOR_USER','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");			
					}else if(oper_stn_id.equals("3") && oper_stn_id1.equals("3")){
							out.print(" <script>alert(getMessage('OPER_STN_RESTRN','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");		
					}else  if(oper_stn_id.equals("4") && oper_stn_id1.equals("4")){
							out.print(" <script>alert(getMessage('NOT_VALID','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}else  if(oper_stn_id.equals("5") && oper_stn_id1.equals("5")){
							out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}else	if(!oper_stn_id.equals("") && !oper_stn_id1.equals("")){
							if(ca_install_yn.equals("Y")){		
										String allow_diag="";
										String allow_proc="";
										stmt1	= con.createStatement();
										rs1 = stmt1.executeQuery("SELECT ALLOW_RECODE_DIAG_YN,ALLOW_RECODE_PROC_YN FROM mr_parameter") ;
										if(rs1 !=null && rs1.next()){
											allow_diag = rs1.getString("ALLOW_RECODE_DIAG_YN");
											allow_proc = rs1.getString("ALLOW_RECODE_PROC_YN");
										}
										if(allow_diag.equals("Y") || allow_proc.equals("Y")){
												String tmp_stg_no="";
												String sql20="SELECT STAGE_NO FROM MR_RECODE_PRIVI_SETUP_DTL WHERE APPL_USER_ID='"+userid+"' AND FACILITY_ID='"+fac_id+"'";
												pstmt = con.prepareStatement(sql20);
												rs = pstmt.executeQuery();	
												while(rs.next()){
													tmp_stg_no = checkForNull(rs.getString("STAGE_NO"));
												}
												if(pstmt != null) pstmt.close();
												if(rs != null) rs.close();
												if(tmp_stg_no.equals("")){
													String sql_st="SELECT STAGE_NO FROM MR_RECODE_PRIVI_SETUP WHERE SPECIFIC_IND='*ALL' ORDER BY  STAGE_NO DESC";
													pstmt = con.prepareStatement(sql_st);
													rs		  = pstmt.executeQuery();	
													while(rs.next()){
														stage_no =checkForNull(rs.getString("STAGE_NO"));
													}
													if(pstmt != null) pstmt.close();
													if(rs != null) rs.close();
												}else{
													stage_no=tmp_stg_no;
												}
												if(!stage_no.equals("")){
													/*String locn_codes="";
													String LOCN_CODE_SQL="SELECT  LOCN_CODE FROM AM_OS_USER_LOCN_ACCESS_VW WHERE FACILITY_ID = '"+fac_id+"'AND OPER_STN_ID =(SELECT OPER_STN_ID FROM AM_USER_FOR_OPER_STN WHERE APPL_USER_ID = 'SUPERUSER'AND FACILITY_ID = '"+fac_id+"' AND FACILITY_ID = '"+fac_id+"' AND TRUNC (SYSDATE) BETWEEN TRUNC(NVL (EFF_DATE_FROM,SYSDATE ) )AND TRUNC (NVL (EFF_DATE_TO,SYSDATE)))AND APPL_USER_ID = '"+userid+"' AND DIAG_PROC_RECODE_FOR_IP_YN = 'Y'";
													pstmt = con.prepareStatement(LOCN_CODE_SQL);
													rs = pstmt.executeQuery();	
													while(rs.next()){
														locn_codes = locn_codes+"'"+checkForNull(rs.getString("LOCN_CODE"))+"'"+",";
													}
														request.setAttribute("locn_codes",locn_codes)
													if(pstmt != null) pstmt.close();
													if(rs != null) rs.close();*/
													%>
														<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
															<iframe scrolling="no" name='f_query_add_mod' id='f_query_add_mod' src='../../eMR/jsp/DiagProcedureRecodingCriteria.jsp?jsp_name=PaintDischargePatient.jsp&win_height=33.4&win_width=49.6&call_function=<%=call_function%>&oper_stn_id=<%=oper_stn_id%>&oper_stn_id1=<%=oper_stn_id1%>&function_id=<%=call_function%>&increment_rec_count=Y' noresize frameborder=0 style='height:35vh;width:100vw'></iframe><iframe scrolling="auto" name='content' id='content' src='../../eCommon/html/blank.html'  noresize frameborder=0 style='height:50vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:8vh;width:100vw'></iframe>
										<%}else{%>
												<script>
														var err_msg=getMessage("RECODE_PRIVILEGE_NOT_DEFINED","MR");
														alert(err_msg);
														document.location.href='../../eCommon/jsp/dmenu.jsp';
												</script>
											<%}
											}else{
												out.println("<script>alert(getMessage('DIAG_PROC_REC_NO','MR'));</script>");
												out.println("<script>document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
											}
							}else{
									out.println("<script>alert(getMessage('CA_NOT_INSTALLED','Common'));</script>");
									out.println("<script>document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
							}
					}	
			}else{%>
					<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder='0' scrolling='no' noresize style='height:40%;width:100vw'></iframe>
						<iframe scrolling="no" name='f_query_add_mod' id='f_query_add_mod' src='../../eMR/jsp/MedRecRequestCriteria.jsp?jsp_name=PaintDischargePatient.jsp&win_height=33.4&win_width=49.6&call_function=<%=call_function%>&function_id=<%=call_function%>' noresize frameborder=0 style='height:175%;width:100vw'></iframe>
						<iframe scrolling="auto" name='content' id='content' src='../../eCommon/html/blank.html'  noresize frameborder=0 style='height:100vh;width:100vw'></iframe>
						<iframe scrolling="no" name='f_select' id='f_select' src='../../eMR/jsp/MedRecRequestButton.jsp'  noresize frameborder=0 style='height:20%;width:100vw'></iframe>
						<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:50%;width:100vw'></iframe>
						<iframe name='errFrame' id='errFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:0%;width:100vw'></iframe>
			<%}	
		}catch(Exception exp){
			//out.println("Exception : "+exp.toString());
			exp.printStackTrace();
		}
		finally{
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}%>
	</html>
<%!
	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

