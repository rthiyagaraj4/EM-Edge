<!DOCTYPE html>
<%@page import="eOT.SetUpParamForFacilityBean"%>
<%@ page import ="java.util.HashMap" contentType="text/html;charset=UTF-8" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	//String bean_id = "SetUpParamForFacilityBean";
	//String bean_name = "eOT.SetUpParamForFacilityBean";
	//SetUpParamForFacilityBean bean = (SetUpParamForFacilityBean) mh.getBeanObject( bean_id, request, bean_name );
	
	String locale = (String) session.getAttribute("LOCALE");
	String facility_id = (String) session.getAttribute("facility_id");
	java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
	String login_user = prop.getProperty( "login_user" ) ;
	request.setCharacterEncoding("UTF-8");
	String	tab_id="AdditionalDetails";
	Connection con = null;
	ResultSet rst = null;
	PreparedStatement pstmt = null;
	ResultSet rst1 = null;
	PreparedStatement pstmt1 = null;
	String over_booking_window_user = "";
	Boolean isTimeDtlsSurNurAppl = false;
	HashMap map = new HashMap();
	//map=(session.getAttribute(tab_id)!=null)?(HashMap)session.getAttribute(tab_id):bean.getQueryDtls(tab_id,facility_id);
//	map=(session.getAttribute(tab_id)!=null)?bean.getQueryDtls(tab_id,facility_id):bean.getQueryDtls(tab_id,facility_id);
	//String session_facility_id=(String) map.get("facility_id");
	
	//if(!facility_id.equals(session_facility_id)){
	//	map=bean.getQueryDtls(tab_id,facility_id);
	//}
	
	String sqlAddDet=	"SELECT CSSD_INTERFACE_YN,(select short_desc from sy_doc_type_master where doc_type_code = OTP.CSSD_DOC_TYPE_REQ) req_doc,"+						
						"(select short_desc from sy_doc_type_master where doc_type_code = OTP.CSSD_DOC_TYPE_RET) ret_doc, "+
						"(select short_desc from mm_store where store_code = OTP.CSSD_STORE_REQ) req_store, "+
						"(select short_desc from mm_store where store_code = OTP.CSSD_STORE_RET) issue_store, "+
						"TAT_RQ_YN ,TAT_FROM_STATUS,TAT_TO_STATUS,CSSD_DOC_TYPE_REQ,CSSD_DOC_TYPE_RET,CSSD_STORE_REQ,CSSD_STORE_RET,ANES_PROC_START_END_TIME_YN,ANES_START_END_TIME_YN,SURGERY_START_END_TIME_YN,PREPARATION_START_END_TIME_YN,RECORD_SURGEON_NOTES_YN,RECORD_NURSING_NOTES_YN FROM OT_PARAM_FOR_FACILITY OTP WHERE OPERATING_FACILITY_ID=?";
	String sqlOverBooking = "select NVL(over_booking_window_user, 'N') from OT_PARAM_FOR_FACILITY where OPERATING_FACILITY_ID = ?";
	try{
		con = ConnectionManager.getConnection(request);
		
		isTimeDtlsSurNurAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OT", "TIMEDTLS_NUR_SUR_NOTE_MAND");

     	pstmt = con.prepareStatement(sqlAddDet);
	 	pstmt.setString(1,facility_id);
		int record =0;
	 	rst = pstmt.executeQuery();
	 	while(rst.next()){
        	++record;
        	map.put("cssd_interface_yn",checkForNull(rst.getString("CSSD_INTERFACE_YN")));
        	map.put("cssd_doc_type_req",checkForNull(rst.getString("req_doc")));
        	map.put("cssd_doc_type_ret",checkForNull(rst.getString("ret_doc")));
        	map.put("cssd_store_req",checkForNull(rst.getString("req_store")));
        	map.put("cssd_store_ret",checkForNull(rst.getString("issue_store")));
        	map.put("tat_rq_yn",checkForNull(rst.getString("TAT_RQ_YN")));
        	map.put("tat_from_status",checkForNull(rst.getString("TAT_FROM_STATUS")));
        	map.put("tat_to_status",checkForNull(rst.getString("TAT_TO_STATUS")));
        	map.put("req_doc",checkForNull(rst.getString("cssd_doc_type_req")));
        	map.put("ret_doc",checkForNull(rst.getString("cssd_doc_type_ret")));
        	map.put("req_store",checkForNull(rst.getString("cssd_store_req")));
        	map.put("issue_store",checkForNull(rst.getString("cssd_store_ret")));		
        	map.put("AnesProcedureStartEndTimeYN",checkForNull(rst.getString("ANES_PROC_START_END_TIME_YN")));		
        	map.put("AnesStartEndTimeYN",checkForNull(rst.getString("ANES_START_END_TIME_YN")));		
        	map.put("SurgeryStartEndTimeYN",checkForNull(rst.getString("SURGERY_START_END_TIME_YN")));		
        	map.put("PreparationStartEndTimeYN",checkForNull(rst.getString("PREPARATION_START_END_TIME_YN")));		
        	map.put("RecordSurgeonNotesYN",checkForNull(rst.getString("RECORD_SURGEON_NOTES_YN")));		
        	map.put("RecordNursingNotesYN",checkForNull(rst.getString("RECORD_NURSING_NOTES_YN")));		
		}
		if(record==0){
			map.put("cssd_interface_yn","");
			map.put("cssd_doc_type_req","");
			map.put("cssd_doc_type_ret","");
			map.put("cssd_store_req","");
			map.put("cssd_store_ret","");
			map.put("tat_rq_yn","");
			map.put("tat_from_status","");
			map.put("tat_to_status","");
			map.put("req_doc","");
        	map.put("ret_doc","");
        	map.put("req_store","");
        	map.put("issue_store","");		
        	map.put("AnesProcedureStartEndTimeYN","");		
        	map.put("AnesStartEndTimeYN","");		
        	map.put("SurgeryStartEndTimeYN","");		
        	map.put("PreparationStartEndTimeYN","");		
        	map.put("RecordSurgeonNotesYN","");		
        	map.put("RecordNursingNotesYN","");		
		}
		pstmt1 = con.prepareStatement(sqlOverBooking);
	 	pstmt1.setString(1,facility_id);		
	 	rst1 = pstmt1.executeQuery();
	 	while(rst1.next()){
			over_booking_window_user = checkForNull(rst1.getString(1));
		}

 	}catch(Exception e){
	 	System.err.println("Exception in Setup Parameter Add Det->"+e);
 	}
 	finally {
	 	try{
	 		rst.close();
	 		pstmt.close();
			rst1.close();
	 		pstmt1.close();
	 		con.close();
	 	}
	 	catch(Exception e){
	 		System.err.println("Exception in Setup Parameter Add Det->"+e);
	 	}
 	}
 
	String cssdInterfaceYn = checkForNull((String) map.get("cssd_interface_yn"),"");
	String reqDoc = checkForNull((String) map.get("cssd_doc_type_req"),"");
	String retDoc = checkForNull((String) map.get("cssd_doc_type_ret"),"");
	String reqStore = checkForNull((String) map.get("cssd_store_req"),"");
	String retStore = checkForNull((String) map.get("cssd_store_ret"),"");
	String tat = checkForNull((String) map.get("tat_rq_yn"),"");
	String fromStatus = checkForNull((String) map.get("tat_from_status"),"");
	String toStatus = checkForNull((String) map.get("tat_to_status"),"");
	String reqDocHdn = checkForNull((String) map.get("req_doc"),"");
	String retDocHdn = checkForNull((String) map.get("ret_doc"),"");
	String reqStoreHdn = checkForNull((String) map.get("req_store"),"");
	String retStoreHdn = checkForNull((String) map.get("issue_store"),"");	
	String anesProcStartEndTimeYN = checkForNull((String) map.get("AnesProcedureStartEndTimeYN"),"");	
	String anessStartEndTimeYN = checkForNull((String) map.get("AnesStartEndTimeYN"),"");	
	String surgStartEndTimeYN = checkForNull((String) map.get("SurgeryStartEndTimeYN"),"");	
	String prepStartEndTimeYN = checkForNull((String) map.get("PreparationStartEndTimeYN"),"");	
	String recSurgeonNotesYN = checkForNull((String) map.get("RecordSurgeonNotesYN"),"");	
	String recNursingNotesYN = checkForNull((String) map.get("RecordNursingNotesYN"),"");	
	
%>
<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
	<script language='javascript' src='../../eOT/js/SetUpParameterForFacility.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onload= 'enDisRecSurYN()'>
<form name="SetUpParameterForFacilityAdditionalDetailsForm" id="SetUpParameterForFacilityAdditionalDetailsForm"  action="../../servlet/eOT.SetupParameterFacilityAddDetailServlet" method='post' onload='FocusFirstElement();'  target="messageFrame"> 
<table border=0 cellspacing=0 cellpadding=3  width='100%'  align=center id='t' >
	<tr>
			 <td class='COLUMNHEADERCENTER' width='100%'>
				<fmt:message key="eOT.InterfacetoCSSD.Label" bundle="${ot_labels}"/>
			</td>
			</tr>
</table>
<table border='0' cellpadding=3  cellspacing='0' width='100%' align='center'>
<tr>
			<td class=label width='25%'>
				<fmt:message key="eOT.CSSDInterface.Label" bundle="${ot_labels}"/>
			</td>
			<td class=label width='25%'>
			<%if("Y".equals(cssdInterfaceYn)){ %>
			<input type="checkbox" name="cssdInterface" id="cssdInterface" onclick="fieldEnableDisable('cssdInterface');" checked disabled>
			<%}
			else{%>
			<input type="checkbox" name="cssdInterface" id="cssdInterface" onclick="fieldEnableDisable('cssdInterface');">
			<%} %>
			</td>
			<td width="25%">
			</td>
			<td width="25%">
			</td>
			
</tr>	
<tr>
			<td class=label width='25%'>
			<fmt:message key="eOT.ReqDocType.Label" bundle="${ot_labels}"/>
			</td>
			<td width='25%'>
			<input type='text' name='request_doc' id='request_doc' size='15'  maxlength='15' value="<%=reqDoc %>"  onBlur="if(this.value!='')getLookup(request_doc,'request_doc');else request_doc.value='' " disabled>
			<input type='hidden' name='request_doc_hdn' id='request_doc_hdn'  value="<%=reqDocHdn%>"><input type='button' class='button' value='?' name='btn_request_doc' id='btn_request_doc' onClick="getLookup(request_doc,'request_doc');" disabled>
			</td>
			<td class=label width="25%">
			<fmt:message key="eOT.RetDocType.Label" bundle="${ot_labels}"/>
			</td>
			<td width='25%'>
			<input type='text' name='return_doc' id='return_doc' size='15'  maxlength='15' value="<%=retDoc %>"  onBlur="if(this.value!='')getLookup(return_doc,'return_doc');else return_doc.value='' " disabled>
			<input type='hidden' name='return_doc_hdn' id='return_doc_hdn'  value="<%=retDocHdn%>"><input type='button' class='button' value='?' name='btn_return_doc' id='btn_return_doc' onClick="getLookup(return_doc,'return_doc');" disabled>
			</td>
			
</tr>		
<tr>
			<td class=label width='25%'>
			<fmt:message key="eOT.ReqStore.Label" bundle="${ot_labels}"/>
			</td>
			<td width='25%'>
			<input type='text' name='request_store' id='request_store' size='15'  maxlength='15' value="<%=reqStore %>"  onBlur="if(this.value!='')getLookup(request_store,'request_store');else request_store.value='' " disabled>
			<input type='hidden' name='request_store_hdn' id='request_store_hdn'  value="<%=reqStoreHdn%>"><input type='button' class='button' value='?' name='btn_req_str' id='btn_req_str' onClick="getLookup(request_store,'request_store');" disabled>			
			</td>
			<td class=label width="25%">
			<fmt:message key="eOT.IssueStore.Label" bundle="${ot_labels}"/>
			</td>
			<td width='25%'>
			<input type='text' name='issue_store' id='issue_store' size='15'  maxlength='15' value="<%=retStore %>"  onBlur="if(this.value!='')getLookup(issue_store,'issue_store');else issue_store.value='' " disabled>
			<input type='hidden' name='issue_store_hdn' id='issue_store_hdn'  value="<%=retStoreHdn%>"><input type='button' class='button' value='?' name='btn_issue_store' id='btn_issue_store' onClick="getLookup(issue_store,'issue_store');" disabled>			
			</td>
			
</tr>		
</table>	
<br/>
<table border=0 cellspacing=0 cellpadding=3  width='100%'  align=center id='t' >
	<tr>
			 <td class='COLUMNHEADERCENTER' width='100%'>
				<fmt:message key="eOT.TurnAroundTime.Label" bundle="${ot_labels}"/>
			</td>
	</tr>
</table>
<table border='0' cellpadding=3  cellspacing='0' width='100%' align='center'>
<tr>
			<td class=label width='25%'>
				<fmt:message key="eOT.TurnAroundTime.Label" bundle="${ot_labels}"/>
			</td>
			<td class=label width='25%'>
			<%if("Y".equals(tat)){ %>
			<input type="checkbox" name="turnAround" id="turnAround" onclick="fieldEnableDisable('turnAround');" checked disabled>
			<%}
			else{%>
			<input type="checkbox" name="turnAround" id="turnAround" onclick="fieldEnableDisable('turnAround');">
			<%} %>
			</td>
			<td width="25%">
			</td>
			<td width="25%">
			</td>
			
</tr>	
<%
try{
	String sqlFrom = "select status_code code,status_desc description from ot_status where status_code not in ('10','25','99') order by status_code";
	con = ConnectionManager.getConnection(request);
	pstmt = con.prepareStatement(sqlFrom);
	rst = pstmt.executeQuery();

%>
<tr>
			<td class=label width='25%'>
			<fmt:message key="eOT.FromStatus.Label" bundle="${ot_labels}"/>
			</td>
			<td width='25%'>
				<select name="fromStatus" id="fromStatus"  onchange="checkVal();" disabled>
					<%while(rst.next()) {
						if(rst.getString("code").equals(fromStatus)){%>
						<option value="<%=rst.getString("code")%>" selected>
						<%}
						else{%>
						<option value="<%=rst.getString("code")%>">
						<%} %>
						<%=rst.getString("description") %>
						</option>
					<%}
					pstmt = null;
					rst = null;%>
				</select>
				<img src='../../eCommon/images/mandatory.gif' />
			</td>
			<td class=label width="25%">
			<fmt:message key="eOT.ToStatus.Label" bundle="${ot_labels}"/>
			</td>
			<td width="25%">
				<select name="toStatus" id="toStatus"  onchange="checkVal();" disabled>
				<%
				pstmt = con.prepareStatement(sqlFrom);
				rst = pstmt.executeQuery();
					while(rst.next()){
						if(rst.getString("code").equals(toStatus)){%>
						<option value="<%=rst.getString("code")%>" selected>
						<%}
						else{%>
						<option value="<%=rst.getString("code")%>">
						<%} %>
						<%=rst.getString("description") %>
						</option>
				<%} %>
				</select>
				<img src='../../eCommon/images/mandatory.gif' />
				<%if(!(toStatus.length()>0)){
				out.println("<script>document.forms[0].toStatus.selectedIndex = document.forms[0].toStatus.options.length-1;</script>");
				}
				%>
			</td>
			
</tr>
</table>
<br/>
<table border=0 cellspacing=0 cellpadding=3  width='100%'  align=center id='t' >
	<tr>
			 <td class='COLUMNHEADERCENTER' width='100%'>
				<fmt:message key="eOT.OverBookingWindowRestriction.Label" bundle="${ot_labels}"/>
			</td>
	</tr>
</table>
<table border='0' cellpadding=3  cellspacing='0' width='100%' align='center'>
<tr>
<td class=label width='25%'>
	
	<fmt:message key="eOT.OverBookingWindowRestriction.Label" bundle="${ot_labels}"/>
	
</td>
<td class=label width='25%'>
			<%if("Y".equals(over_booking_window_user)){ %>
			<input type="checkbox" name="overBookingRestriction" id="overBookingRestriction" checked disabled>
			<%}
			else{%>
			<input type="checkbox" name="overBookingRestriction" id="overBookingRestriction">
			<%} %>
</td>
<td width="25%">
</td>
<td width="25%">
</td>
</tr>
<% //out.println("over_booking_window_user:" + over_booking_window_user);
			}
				
	catch(Exception e){
		System.err.println("Exception in SetupParameterForFacilityAdditionalDetails.jsp:"+e);
	}
				
	finally{
		try{
			if(pstmt!=null) pstmt.close();
			if(rst!=null) rst.close();
			ConnectionManager.returnConnection(con);
		}
		catch(Exception e){
			System.err.println("Exception in SetupParameterForFacilityAdditionalDetails.jsp:"+e);
		}
}
%>
</table>
<!-- Added by Arthi for ML-MMOH-CRF-1936 on 20-Dec-2022 -->
<%if(isTimeDtlsSurNurAppl){%>
<br/>
<table border=0 cellspacing=0 cellpadding=3  width='100%'  align=center id='t' >
	<tr>
			 <td class='COLUMNHEADERCENTER' width='100%'>
				<fmt:message key="eOT.TimeandDetails.Label" bundle="${ot_labels}"/>
			</td>
	</tr>
</table>
<table border='0' cellpadding=3  cellspacing='0' width='100%' align='center'>
	<tr>
		<td class=label width='25%' nowrap>
				<fmt:message key="eOT.MandatoryField.Label" bundle="${ot_labels}"/>
		</td>
		<td class=label width='25%' nowrap><fmt:message key="eOT.AnaesthesiaProcedure.Label" bundle="${ot_labels}"/>&nbsp;<fmt:message key="eOT.StartandEndTime.Label" bundle="${ot_labels}"/>
		<%if("Y".equals(anesProcStartEndTimeYN)){ %>
		<input type="checkbox" id="AnesProcedureStartEndTimeYN" name="AnesProcedureStartEndTimeYN" id="AnesProcedureStartEndTimeYN" onclick="RecSurNurEnDisYN();" checked >
		<%}else{%>
		<input type="checkbox" id="AnesProcedureStartEndTimeYN" name="AnesProcedureStartEndTimeYN" id="AnesProcedureStartEndTimeYN" onclick="RecSurNurEnDisYN()" /></td>
		<%}%>

		<td class=label width='25%' nowrap><fmt:message key="Common.Anaesthesia.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.StartandEndTime.Label" bundle="${ot_labels}"/>
		<%if("Y".equals(anessStartEndTimeYN)){ %>
		<input type="checkbox" id="AnesStartEndTimeYN" name="AnesStartEndTimeYN" id="AnesStartEndTimeYN" onclick="RecSurNurEnDisYN();" checked >
		<%}else{%>
		<input type="checkbox" id="AnesStartEndTimeYN" name="AnesStartEndTimeYN" id="AnesStartEndTimeYN" onclick="RecSurNurEnDisYN()" /></td>
		<%}%>

		<td class=label width='25%' nowrap><fmt:message key="Common.Surgery.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.StartandEndTime.Label" bundle="${ot_labels}"/>
		<%if("Y".equals(surgStartEndTimeYN)){ %>
		<input type="checkbox" id="SurgeryStartEndTimeYN" name="SurgeryStartEndTimeYN" id="SurgeryStartEndTimeYN" onclick="RecSurNurEnDisYN();" checked >
		<%}else{%>
		<input type="checkbox" id="SurgeryStartEndTimeYN" name="SurgeryStartEndTimeYN" id="SurgeryStartEndTimeYN" onclick="RecSurNurEnDisYN()" /></td>
		<%}%>

		<td class=label width='25%' nowrap><fmt:message key="eOT.Preparation.Label" bundle="${ot_labels}"/>&nbsp;<fmt:message key="eOT.StartandEndTime.Label" bundle="${ot_labels}"/>
		<%if("Y".equals(prepStartEndTimeYN)){ %>
		<input type="checkbox" id="PreparationStartEndTimeYN" name="PreparationStartEndTimeYN" id="PreparationStartEndTimeYN" onclick="RecSurNurEnDisYN();" checked >
		<%}else{%>
		<input type="checkbox" id="PreparationStartEndTimeYN" name="PreparationStartEndTimeYN" id="PreparationStartEndTimeYN" onclick="RecSurNurEnDisYN()" /></td>
		<%}%>
	</tr>
	<tr>
		<td class=label width='25%' nowrap>
				<fmt:message key="Common.Function.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Level.label" bundle="${common_labels}"/>
		</td>
		<td class=label width='25%' nowrap><fmt:message key="eOT.RecordSurgeonNotes.Label" bundle="${ot_labels}"/>
		<%if("Y".equals(recSurgeonNotesYN)){ %>
		<input type="checkbox" id="RecordSurgeonNotesYN" name="RecordSurgeonNotesYN" id="RecordSurgeonNotesYN" onclick="RecSurNurEnDisYN();" checked >
		<%}else{%>
		<input type="checkbox" id="RecordSurgeonNotesYN" name="RecordSurgeonNotesYN" id="RecordSurgeonNotesYN"/></td>
		<%}%>

		<td class=label width='25%' nowrap><fmt:message key="eOT.RecordNursingNotes.Label" bundle="${common_labels}"/>
		<%if("Y".equals(recNursingNotesYN)){ %>
		<input type="checkbox" id="RecordNursingNotesYN" name="RecordNursingNotesYN" id="RecordNursingNotesYN" onclick="RecSurNurEnDisYN();" checked >
		<%}else{%>
		<input type="checkbox" id="RecordNursingNotesYN" name="RecordNursingNotesYN" id="RecordNursingNotesYN"/></td>
		<%}%>
	</tr>
</table>
<%}%>
<!-- End ML-MMOH-CRF-1936 -->


	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>">
	<input type='hidden' name='user_id' id='user_id' value="<%=login_user%>">
	<input type="hidden" name="tab_id" id="tab_id" value="<%=tab_id%>">
	<input type='hidden' name='isTimeDtlsSurNurAppl' id='isTimeDtlsSurNurAppl' value="<%=isTimeDtlsSurNurAppl%>"> <!-- Added by Arthi for ML-MMOH-CRF-1936 -->
</form>
</body>
</html>


