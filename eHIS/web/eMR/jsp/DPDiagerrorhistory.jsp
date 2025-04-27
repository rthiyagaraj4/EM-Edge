<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%	
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String locale = (String)session.getAttribute("LOCALE"); 
	String recorded_date_time			= "";
	//String recorded_proc_date_time	= "";
	 String facilityID		= (String) session.getValue( "facility_id" ) ;
	String encounterID = checkForNull(request.getParameter("encounterID"));
	String view_from	 = checkForNull(request.getParameter("view_from"));
%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	</head>
	<body>
		<form>
			<%if(view_from.equals("MRK_ERR")){
						try{
							   eMR.DPRecodedHistory beanObj = new eMR.DPRecodedHistory();
							   beanObj.setSql("select  t.display_text, t.href, t.recode_desc, t.recorded_date_time, t.practitioner, t.code_desc,t.error_dtl  from table(MR_TERM_RECODE_HISTORY.GET_HISTORY(?, ?, ?)) t" );
							   beanObj.setParameters(
								new String[] { "MR_DIAGNOSIS_RECODING_DTL",
													 facilityID,
													encounterID
												   }
									  );						  %>
								<table align='center' width='100%' cellpadding='1' cellspacing='0'>
									<tr>
										<td colspan="6"  class='PANELTOOLBAR' align='left'>
											<fmt:message key="eMR.DiagnosisErrorHistory.label" bundle="${mr_labels}"/>
										</td>
									</tr>
									<tr></tr>
									<tr>
										<th style="width:19%" align='left'><fmt:message key="eMR.OriginalCode.label" bundle="${mr_labels}"/>&nbsp;/&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
										<th style="width:19%" align='left'><fmt:message key="eMR.ErrorCode.label" bundle="${mr_labels}"/>&nbsp;/&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
										<th style="width:19%" align='left' nowrap><fmt:message key="eMR.PreviousCode.label" bundle="${mr_labels}"/>&nbsp;/&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
										<th style="width:19%" align='left'><fmt:message key="eMR.NextCode.label" bundle="${mr_labels}"/>&nbsp;/&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
										<th style="width:15%" align='left'><fmt:message key="Common.Error.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.MarkedBy.label" bundle="${common_labels}"/></th>
										<th style="width:15%" align='left'><fmt:message key="Common.Error.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/></th>
									<% while(beanObj.next()) { 
										recorded_date_time=checkForNull(beanObj.getString("recorded_date_time"));
										recorded_date_time=DateUtils.convertDate(recorded_date_time,"DMYHM" ,"en",locale);
										String error_dtl = checkForNull(beanObj.getString("error_dtl"));
									%>
										<tr>
											<td class="gridData">
												<span ><%= checkForNull(beanObj.getString("display_text"))%>&nbsp;</span>
											</td>
											<td class="gridData"><%= checkForNull(beanObj.getString("href"))%>&nbsp;</td>
										<%if(!error_dtl.equals("N")){%>
												<td class="gridData"><%= checkForNull(beanObj.getString("recode_desc"))%>&nbsp;</td>
												<td class="gridData"><%= checkForNull(beanObj.getString("code_desc"))%>&nbsp;</td>
											<%}else{%>
												<td class="gridData">&nbsp;</td>
												<td class="gridData">&nbsp;</td>
											<%}%>
											<td class="gridData"><%= checkForNull(beanObj.getString("practitioner"))%>&nbsp;</td>
											<td class="gridData" nowrap><%=recorded_date_time%>&nbsp;</td>
									</tr>
							<% }%>
								</table>
							<%}catch(Exception ex){
								ex.printStackTrace();
							}
					}else if(view_from.equals("EX_CODES")){
						Connection con=null;
						PreparedStatement pstmt	= null;
						ResultSet rs						= null;
						try{
								con			 = ConnectionManager.getConnection(request);
								String term_code			= "";
								String term_code_desc	= "";
								String pract_name			= "";
								String recorded_dt_tim	= "";
								String remarks				= "";
								String EX_CODES_SQL ="SELECT A.TERM_CODE,CASE WHEN A.TERM_CODE='*OTH' THEN A.TERM_CODE_SHORT_DESC ELSE B.SHORT_DESC END SHORT_DESC,AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID, 'en', '1') PRACTITIONER_NAME,TO_CHAR(A.RECORDED_DATE_TIME,'DD/MM/YYYY HH24:MI') RECORDED_DATE_TIME,A.REMARKS FROM MR_DIAGNOSIS_RECODING_DTL A,MR_TERM_CODE B WHERE A.ERROR_DTL='X' AND A.FACILITY_ID='"+facilityID+"' AND A.ENCOUNTER_ID='"+encounterID+"' AND A.TERM_CODE=B.TERM_CODE AND A.TERM_SET_ID=B.TERM_SET_ID ";%>
								<table align='center' width='100%' cellpadding='1' cellspacing='0'>
									<tr>
										<td colspan="6"  class='PANELTOOLBAR' align='left'>
											<fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>
										</td>
									</tr>
									<tr></tr>
									<tr>
										<th style="width:19%" align='left'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
										<th style="width:19%" align='left'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
										<th style="width:19%" align='left'><fmt:message key="eMR.Excluded.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.by.label" bundle="${common_labels}"/></th>
										<th style="width:19%" align='left'><fmt:message key="eMR.Excluded.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/></th>
										<th style="width:15%" align='left'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
									<% 								
										pstmt	=	con.prepareStatement(EX_CODES_SQL);
										rs	=pstmt.executeQuery();
										while(rs.next()){
											term_code			=	checkForNull(rs.getString("TERM_CODE"));
											term_code_desc	=	checkForNull(rs.getString("SHORT_DESC"));
											pract_name			=	checkForNull(rs.getString("PRACTITIONER_NAME"));
											recorded_dt_tim	=	checkForNull(rs.getString("RECORDED_DATE_TIME"));
											recorded_dt_tim	=	DateUtils.convertDate(recorded_dt_tim,"DMYHM" ,"en",locale);
											remarks				=	checkForNull(rs.getString("REMARKS"));
										%>
										<tr>
											<td class="gridData"><%=term_code%>&nbsp;</td>
											<td class="gridData"><%=term_code_desc%>&nbsp;</td>
											<td class="gridData"><%=pract_name%>&nbsp;</td>
											<td class="gridData"><%=recorded_dt_tim%>&nbsp;</td>
											<td class="gridData"><%=remarks%>&nbsp;</td>
									</tr>
							<% }
										if(pstmt!=null)pstmt.close();
										if(rs!=null)rs.close();
								%>
								</table>
							<%}catch(Exception ex){
								ex.printStackTrace();
							}finally{
								if(con!=null){
									ConnectionManager.returnConnection(con,request);
								}
							}
					}else if(view_from.equals("ORIG_MRK_ERR")){
						Connection con=null;
						PreparedStatement pstmt	= null;
						ResultSet rs						= null;
						try{
								con			 = ConnectionManager.getConnection(request);
								String term_code			= "";
								String term_code_desc	= "";
								String pract_name			= "";
								String recorded_dt_tim	= "";
//								String remarks				= "";
								String ORIG_ERR__SQL ="SELECT TERM_CODE,TERM_CODE_SHORT_DESC,AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID, 'en', '1') PRACTITIONER_NAME,TO_CHAR(RECORDED_DATE_TIME,'DD/MM/YYYY HH24:MI') RECORDED_DATE_TIME,REMARKS FROM MR_DIAGNOSIS_RECODING_DTL WHERE ERROR_DTL='E' AND FACILITY_ID='"+facilityID+"' AND ENCOUNTER_ID='"+encounterID+"' ";%>
								<table align='center' width='100%' cellpadding='1' cellspacing='0'>
									<tr>
										<td colspan="6"  class='PANELTOOLBAR' align='left'>
											<fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>
										</td>
									</tr>
									<tr></tr>
									<tr>
										<th style="width:19%" align='left'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
										<th style="width:19%" align='left'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
										<th style="width:19%" align='left'><fmt:message key="Common.Error.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.MarkedBy.label" bundle="${common_labels}"/></th>
										<th style="width:19%" align='left'><fmt:message key="Common.Error.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/></th>
									<% 								
										pstmt	=	con.prepareStatement(ORIG_ERR__SQL);
										rs	=pstmt.executeQuery();
										while(rs.next()){
											term_code			=	checkForNull(rs.getString("TERM_CODE"));
											term_code_desc	=	checkForNull(rs.getString("TERM_CODE_SHORT_DESC"));
											pract_name			=	checkForNull(rs.getString("PRACTITIONER_NAME"));
											recorded_dt_tim	=	checkForNull(rs.getString("RECORDED_DATE_TIME"));
											recorded_dt_tim	=	DateUtils.convertDate(recorded_dt_tim,"DMYHM" ,"en",locale);
										%>
										<tr>
											<td class="gridData"><%=term_code%>&nbsp;</td>
											<td class="gridData"><%=term_code_desc%>&nbsp;</td>
											<td class="gridData"><%=pract_name%>&nbsp;</td>
											<td class="gridData"><%=recorded_dt_tim%>&nbsp;</td>
									</tr>
							<% }
										if(pstmt!=null)pstmt.close();
										if(rs!=null)rs.close();
								%>
								</table>
							<%}catch(Exception ex){
									ex.printStackTrace();
							}finally{
								if(con!=null){
									ConnectionManager.returnConnection(con,request);
								}
							}
					}
				%>
		</form>
	</body>
</html>
<%!
	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

