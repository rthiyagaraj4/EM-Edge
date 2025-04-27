<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String locale = (String)session.getAttribute("LOCALE"); 
 String facility_id = (String)session.getValue( "facility_id" ) ;
 request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%
	Connection con=null;
	PreparedStatement pstmt=null;						    
	ResultSet rs=null;

	String sql = "";
	String from = checkForNull(request.getParameter( "from" )) ;
	String to =   checkForNull(request.getParameter( "to" ) ) ;
	String trmt_cat_type=checkForNull(request.getParameter( "trmt_cat_type" ));
	String patient_id=checkForNull(request.getParameter("patient_id"));
	String totalSelected=checkForNull(request.getParameter("totalSelected"));

	String chart_num=checkForNull(request.getParameter("chart_num"));
	String chart_line_num=checkForNull(request.getParameter("chart_line_num"));
	String trmt_code=checkForNull(request.getParameter("trmt_code"));
    String tooth_range_count_for_order=checkForNull(request.getParameter("tooth_range_count_for_order"));
	String composition_class_desc="";
	String composition_desc=checkForNull(request.getParameter("composition_desc"));
	String display_tooth_no=checkForNull(request.getParameter("display_tooth_no"));
	String task_code = checkForNull(request.getParameter("task_code_req"));
	String ind_chart_line_num = checkForNull(request.getParameter("ind_chart_line_num"));
	String seq_no	= checkForNull(request.getParameter( "seq_no" )) ;//Added by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
	String baseline_chart_yn = checkForNull(request.getParameter("baseline_chart_yn"));//Added by Sridevi Johi on 5/27/2010 for IN021653
	String date_diff_flag = checkForNull(request.getParameter("date_diff_flag"));//Added by Sridevi Johi on 5/27/2010 for IN021668
	String disable_flag ="";
	String trmt_dtls_entry_cmpl_yn ="";
	int maxRecord = 0;
	int total = 0; 
	
	String task_desc = checkForNull(request.getParameter("task_desc"));
	String status_disabled =  checkForNull(request.getParameter("status_disabled"));
	String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
	String other_chart_facility_id  = checkForNull(request.getParameter( "other_chart_facility_id" )) ;			
	if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
		other_chart_facility_id=facility_id;
	}

	if(!other_chart_facility_id.equals(facility_id)){
		status_disabled = "disabled";
	}

%>
<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eOH/js/TrmtMatDetails.js" language="javascript"></script>
		<script language="javascript" src="../../eOH/js/Hashtable.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	try{
		con=ConnectionManager.getConnection(request);
		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();
		
		pstmt=con.prepareStatement("SELECT TRMT_DTLS_ENTRY_CMPL_YN TRMT_DTLS_ENTRY_CMPL_YN1 FROM OH_RESTORATIVE_CHART_TASKS where PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE= ?  AND TASK_CODE=? AND TASK_SEQ = ?");
		pstmt.setString(1,patient_id); 
		pstmt.setString(2,chart_num); 
		pstmt.setString(3,chart_line_num); 
		pstmt.setString(4,trmt_code); 
		pstmt.setString(5,task_code); 
		pstmt.setString(6,seq_no); 
		rs = pstmt.executeQuery();
		while(rs.next()){
			trmt_dtls_entry_cmpl_yn = rs.getString("TRMT_DTLS_ENTRY_CMPL_YN1");
		}

		//By Sridevi Joshi for CRF-709(IN012626) : This is to disable the fields if dataentry is already completed and we are loading this page without closing the window.
		if(trmt_dtls_entry_cmpl_yn.equals("Y") || baseline_chart_yn.equals("Y") || date_diff_flag.equals("disable")){//Condition for baseline_chart_yn is added by Sridevi Joshi on 5/27/2010 for IN021653
			disable_flag= "disabled";
		}
		else{
			disable_flag= "";
		}
		
		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();
%>
		<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
			<form name="TrmtMatDetailsForm" id="TrmtMatDetailsForm" method="post" action='../../servlet/eOH.TrmtMatDetailsServlet'> 
				<table width="100%"  cellpadding =10 cellspacing=0  align="center">
					<tr>
						<td class='CAGROUPHEADING' align="left" ><fmt:message key="eOH.CompositionDetailsEntry.Label" bundle="${oh_labels}"/>&nbsp;<%=task_desc%></td>
					</tr>
					<tr>
						<td>
							<table cellpadding =4 align="center" border=0>
								<tr>
									<td class=label width="25%" nowrap><fmt:message key="eOH.CompositionClass.Label" bundle="${oh_labels}"/></td>
									<td class="fields" width="25%"  align="left">
										<select name='composition_class' id='composition_class' onChange='populateComposition(this);' <%=status_disabled%> <%=disable_flag%>> 
											<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
											<%          
												if(rs != null) rs.close();
												if(pstmt != null) pstmt.close();
												sql="SELECT A.COMPOSITION_CLASS_CODE, A.COMPOSITION_CLASS_DESC FROM OH_COMPOSITION_CLASS_LANG_VW A, OH_COMPOSN_CLASS_TRMT_CAT_TYPE B WHERE  A.COMPOSITION_CLASS_CODE = B.COMPOSITION_CLASS_CODE AND B.TRMT_CATEGORY_TYPE = ? AND A.LANGUAGE_ID = ? AND NVL(EFF_STATUS,'E')='E'";
												pstmt=con.prepareStatement(sql);
												pstmt.setString(1,trmt_cat_type);
												pstmt.setString(2,locale);
												rs=pstmt.executeQuery();
												while(rs.next()){
													composition_class_desc=rs.getString("COMPOSITION_CLASS_DESC");
											%>
						
													<option value='<%=rs.getString("COMPOSITION_CLASS_CODE")%>'><%=rs.getString("COMPOSITION_CLASS_DESC")%></option>
											<%	} %>
										</select>
									</td>
								</tr>
								<tr>
									<td class=label width="25%" nowrap><fmt:message key="Common.Composition.label" bundle="${common_labels}"/></td>
									<td class="fields" width="25%"  align="left" id="comp_code_id">
										<select name='composition_code' id='composition_code' <%=status_disabled%> <%=disable_flag%>> 
											<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
										</select>
									</td>
								</tr>
								<tr>
									<td width="25%" colspan="4" class="button" >
										<input type="button" class="button" name="record" id="record" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onclick ="recordComposition();" <%=status_disabled%> <%=disable_flag%>>&nbsp;
										<input type="button" class="button" name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onclick="clearvalues();" <%=status_disabled%> <%=disable_flag%>>&nbsp;
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<%     
					if(pstmt != null) pstmt.close();
					if(rs != null) rs.close();
					//Added SEQ_NO by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
					pstmt=con.prepareStatement("SELECT A.TASK_CODE, B.TASK_DESC, NVL(A.TRMT_DTLS_ENTRY_CMPL_YN,'N') TRMT_DTLS_ENTRY_CMPL_YN FROM OH_RESTORATIVE_CHART_TASKS A, OH_TASKS_LANG B WHERE A.PATIENT_ID=? AND   A.CHART_NUM=? AND A.CHART_LINE_NUM=? AND A.TRMT_CODE=? AND A.TASK_CODE = B.TASK_CODE AND B.LANGUAGE_ID = ? AND A.SEQ_NO=? ORDER BY A.SEQ_NO");
					pstmt.setString(1,patient_id); 
					pstmt.setString(2,chart_num); 
					pstmt.setString(3,chart_line_num); 
					pstmt.setString(4,trmt_code); 
					pstmt.setString(5,locale); 
					pstmt.setString(6,seq_no); 
					rs = pstmt.executeQuery();
					while(rs.next()){
						total++;
					}

					maxRecord = total;
		
					if(pstmt != null) pstmt.close();
					if(rs != null) rs.close();
					//Added SEQ_NO by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480)
					pstmt=con.prepareStatement("SELECT A.TASK_CODE, B.TASK_DESC, NVL(A.TRMT_DTLS_ENTRY_CMPL_YN,'N') TRMT_DTLS_ENTRY_CMPL_YN FROM OH_RESTORATIVE_CHART_TASKS A, OH_TASKS_LANG B WHERE A.PATIENT_ID=? AND   A.CHART_NUM=? AND A.CHART_LINE_NUM=? AND A.TRMT_CODE=? AND A.TASK_CODE = B.TASK_CODE AND B.LANGUAGE_ID = ? AND A.SEQ_NO=? ");
					pstmt.setString(1,patient_id); 
					pstmt.setString(2,chart_num); 
					pstmt.setString(3,chart_line_num); 
					pstmt.setString(4,trmt_code); 
					pstmt.setString(5,locale); 
					pstmt.setString(6,seq_no); 
					rs = pstmt.executeQuery();
						
				%>
				<input type = "hidden" name= "params" value = "<%=request.getQueryString()%>">
				<input type = "hidden" name= "trmt_cat_type" value = "<%=trmt_cat_type%>">
				<input type = "hidden" name="tooth_range_count_for_order" id="tooth_range_count_for_order" value="<%=tooth_range_count_for_order%>" >
				<input type = "hidden" name= "patient_id" value = "<%=patient_id%>">
				<input type = "hidden" name= "chart_num" value = "<%=chart_num%>">
				<input type = "hidden" name= "chart_line_num" value = "<%=chart_line_num%>">
				<input type = "hidden" name= "trmt_code" value = "<%=trmt_code%>">
				<input type = "hidden" name= "task_code" value = "<%=task_code%>">
				<input type = "hidden" name= "composition_class_desc" value = "<%=composition_class_desc%>">
				<input type = "hidden" name= "composition_desc" value = "<%=composition_desc%>">

				<!--Added by Sharon Crasta on 11/13/2008 for SCR #6492-->
				<input type = "hidden" name= "task_desc" value = "<%=task_desc%>">
				<!--End-->

				<input type = "hidden" name= "oh_chart_level" value = "<%=oh_chart_level%>">
				<input type = "hidden" name= "other_chart_facility_id" value = "<%=other_chart_facility_id%>">
				<!--Added by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480) -->
				<input type = "hidden" name= "seq_no" value = "<%=seq_no%>">

				<input type = "hidden" name= "from" value = "<%=from%>">
				<input type = "hidden" name= "to" value = "<%=to%>">
				<input type = "hidden" name= "display_tooth_no" value = "<%=display_tooth_no%>">
				<input type = "hidden" name= "totalSelected" value = "<%=totalSelected%>">
				<input type = "hidden" name= "ind_chart_line_num" value = "<%=ind_chart_line_num%>">
				<input type = "hidden" name= "status_disabled" value = "<%=status_disabled%>">
				<input type = "hidden" name= "maxRecord" value = "<%=maxRecord%>">
			</form>
		</body>
	</html>
	<%
	}catch ( Exception e ) {
		e.printStackTrace() ;
	}finally {
		try{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) 
				ConnectionManager.returnConnection(con,request);
		}catch(Exception es){es.printStackTrace();}
	}
%>

