<!DOCTYPE html>
<%@page  import ="eCommon.Common.CommonBean,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager,java.util.HashMap,eOR.OrderEntryBillingQueryBean,eOT.OTBillingBean,java.util.ArrayList" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eOT/jsp/StringUtil.jsp"%>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<html>
<title> <fmt:message key="eOT.RecordNursingNotes.Label" bundle="${ot_labels}"/> </title>
<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eOT/js/RecordNursing.js"></script>
	<script language="javascript" src="../../eOT/js/OTCommon.js"></script>
	</head>

<%
	String facility_id  = (String) session.getValue("facility_id");
	String params = request.getQueryString();
	String called_from = CommonBean.checkForNull(request.getParameter("called_from"));
		String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	String booking_num = CommonBean.checkForNull(request.getParameter("booking_num")); // 04000112
	String slate_user_id = CommonBean.checkForNull(request.getParameter("slate_user_id")); // logged in user from Slate
	if(called_from==null) called_from="OT_MENU";
	if(called_from!=null && called_from.equals("null")) called_from="OT_MENU";
	if(called_from!=null && called_from.equals("")) called_from="OT_MENU";
	String or_bean_id 				= "Or_billingQueryBean";
	String or_bean_name 			= "eOR.OrderEntryBillingQueryBean";
	OrderEntryBillingQueryBean or_bean			= (OrderEntryBillingQueryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
	or_bean.clearBean();

		String bill_interface_flag_yn="",bill_sub_services_yn="",rec_implants_in_nurs_notes_yn="",rec_implants_in_surg_notes_yn="",rec_equp_in_nurs_notes_yn="",rec_instr_in_nurs_notes_yn="",rec_packs_in_nurs_notes_yn="",finalize_implants_in="",finalize_equp_in="",finalize_instr_in="",finalize_packs_in="",oper_finalization_stage="",storeCode="",st_interface_flag="",operation_sub_services_yn="",surgeon_doc_comp_yn="",nursing_doc_comp_yn="",implant_entry_cmp_yn="",consumable_entry_cmp_yn="",equipment_entry_cmp_yn="",instrument_entry_cmp_yn="",proc_chrg_cmp_yn="",check_into_or_time="",oper_room_code="", encounter_id="",episode_type="",patient_class="";
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;

		try
	{
		con=ConnectionManager.getConnection(request);
		stmt=con.prepareStatement("SELECT BL_INTERFACE_FLAG,OPERATION_SUB_SERVICES_YN,DEF_ST_STORE,NVL(ST_INTERFACE_FLAG,'N') ST_INTERFACE_FLAG, NVL(REC_PACKS_IN_NURS_NOTES_YN, 'N') REC_PACKS_IN_NURS_NOTES_YN , nvl(OPERATION_SUB_SERVICES_YN,'N') OPERATION_SUB_SERVICES_YN,NVL(REC_IMPLANTS_IN_NURS_NOTES_YN,'N') REC_IMPLANTS_IN_NURS_NOTES_YN,NVL(REC_IMPLANTS_IN_SURG_NOTES_YN,'N') REC_IMPLANTS_IN_SURG_NOTES_YN, NVL(REC_EQUP_IN_NURS_NOTES_YN,'N') REC_EQUP_IN_NURS_NOTES_YN, NVL(REC_INSTR_IN_NURS_NOTES_YN,'N') REC_INSTR_IN_NURS_NOTES_YN,  NVL(FINALIZE_IMPLANTS_IN,'N') FINALIZE_IMPLANTS_IN,  NVL(FINALIZE_EQUP_IN,'N') FINALIZE_EQUP_IN,  NVL(FINALIZE_INSTR_IN,'N') FINALIZE_INSTR_IN,  NVL(FINALIZE_PACKS_IN,'N') FINALIZE_PACKS_IN, NVL(OPER_FINALIZATION_STAGE,'N') OPER_FINALIZATION_STAGE  FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID=?");
		stmt.setString(1,facility_id);
		rs=stmt.executeQuery();
		if(rs !=null && rs.next()){
			bill_interface_flag_yn=checkForNull(rs.getString(1),"N");
			bill_sub_services_yn=checkForNull(rs.getString(2),"N");
			storeCode=(rs.getString("DEF_ST_STORE"));
			st_interface_flag=(rs.getString("ST_INTERFACE_FLAG"));
			rec_packs_in_nurs_notes_yn=(rs.getString("REC_PACKS_IN_NURS_NOTES_YN"));
			operation_sub_services_yn=(rs.getString("OPERATION_SUB_SERVICES_YN"));
			rec_implants_in_nurs_notes_yn=rs.getString("REC_IMPLANTS_IN_NURS_NOTES_YN");
			rec_implants_in_surg_notes_yn=checkForNull(rs.getString("REC_IMPLANTS_IN_SURG_NOTES_YN"));
			rec_equp_in_nurs_notes_yn=checkForNull(rs.getString("REC_EQUP_IN_NURS_NOTES_YN"));
			rec_instr_in_nurs_notes_yn=checkForNull(rs.getString("REC_INSTR_IN_NURS_NOTES_YN"));
			finalize_implants_in=checkForNull(rs.getString("FINALIZE_IMPLANTS_IN"));
			finalize_equp_in=checkForNull(rs.getString("FINALIZE_EQUP_IN"));
			finalize_instr_in=checkForNull(rs.getString("FINALIZE_INSTR_IN"));
			finalize_packs_in=checkForNull(rs.getString("FINALIZE_PACKS_IN"));
			oper_finalization_stage=checkForNull(rs.getString("OPER_FINALIZATION_STAGE"));
		}

		stmt=con.prepareStatement("SELECT  OPER_ROOM_CODE, ENCOUNTER_ID,NVL(NURSING_DOC_COMP_YN, 'N') NURSING_DOC_COMP_YN,NVL(SURGEON_DOC_COMP_YN, 'N') SURGEON_DOC_COMP_YN,NVL(IMPLANT_ENTRY_CMP_YN,'N')IMPLANT_ENTRY_CMP_YN,nvl(CONSUMABLE_ENTRY_CMP_YN,'N') CONSUMABLE_ENTRY_CMP_YN,nvl(EQUIPMENT_ENTRY_CMP_YN,'N')EQUIPMENT_ENTRY_CMP_YN,nvl(INSTRUMENT_ENTRY_CMP_YN,'N') INSTRUMENT_ENTRY_CMP_YN,nvl(PROC_CHRG_CMP_YN,'N')PROC_CHRG_CMP_YN,TO_CHAR(CHECK_INTO_OR_TIME,'DD/MM/YYYY HH24:MI') CHECK_INTO_OR_TIME,EPISODE_TYPE,PATIENT_CLASS FROM OT_POST_OPER_HDR WHERE OPER_NUM='"+oper_num+"' AND OPERATING_FACILITY_ID=?");

		stmt.setString(1,facility_id);
		rs=stmt.executeQuery();

		if(rs !=null && rs.next())
		{
			 surgeon_doc_comp_yn = checkForNull(rs.getString("SURGEON_DOC_COMP_YN"));
			 if(surgeon_doc_comp_yn =="") surgeon_doc_comp_yn="N";
			 nursing_doc_comp_yn = checkForNull(rs.getString("NURSING_DOC_COMP_YN"));
			  if(nursing_doc_comp_yn =="") nursing_doc_comp_yn="N";
			 implant_entry_cmp_yn = checkForNull(rs.getString("IMPLANT_ENTRY_CMP_YN"));
			  if(implant_entry_cmp_yn =="") implant_entry_cmp_yn="N";
			 consumable_entry_cmp_yn = checkForNull(rs.getString("CONSUMABLE_ENTRY_CMP_YN"));
			  if(consumable_entry_cmp_yn =="") consumable_entry_cmp_yn="N";
			 equipment_entry_cmp_yn = checkForNull(rs.getString("EQUIPMENT_ENTRY_CMP_YN"));
			  if(equipment_entry_cmp_yn =="") equipment_entry_cmp_yn="N";
			 instrument_entry_cmp_yn = checkForNull(rs.getString("INSTRUMENT_ENTRY_CMP_YN"));
			  if(instrument_entry_cmp_yn =="") instrument_entry_cmp_yn="N";
			   proc_chrg_cmp_yn = checkForNull(rs.getString("PROC_CHRG_CMP_YN"));
			  if(proc_chrg_cmp_yn =="") proc_chrg_cmp_yn="N";
			  check_into_or_time= checkForNull(rs.getString("CHECK_INTO_OR_TIME"));
			  oper_room_code= checkForNull(rs.getString("OPER_ROOM_CODE"));
			  encounter_id= checkForNull(rs.getString("ENCOUNTER_ID"));
  			  episode_type = checkForNull(rs.getString("EPISODE_TYPE"));
			  if(episode_type =="") episode_type="";
			  patient_class = checkForNull(rs.getString("PATIENT_CLASS"));
			  if(patient_class =="") patient_class="";
			
		}


	/*if(called_from.equals("OT_MENU"))*/
		params = params+"&function_name=Record Nursing Notes&called_from="+called_from+"&booking_num="+booking_num+"&slate_user_id="+slate_user_id+"&facility_id="+facility_id+"&storeCode="+storeCode+"&st_interface_flag="+st_interface_flag+"&rec_packs_in_nurs_notes_yn="+rec_packs_in_nurs_notes_yn+"&operation_sub_services_yn="+operation_sub_services_yn+"&rec_implants_in_nurs_notes_yn="+rec_implants_in_nurs_notes_yn+"&rec_implants_in_surg_notes_yn="+rec_implants_in_surg_notes_yn+"&rec_equp_in_nurs_notes_yn="+rec_equp_in_nurs_notes_yn+"&rec_instr_in_nurs_notes_yn="+rec_instr_in_nurs_notes_yn+"&finalize_implants_in="+finalize_implants_in+"&finalize_equp_in="+finalize_equp_in+"&finalize_instr_in="+finalize_instr_in+"&finalize_packs_in="+finalize_packs_in+"&oper_finalization_stage="+oper_finalization_stage+"&surgeon_doc_comp_yn="+surgeon_doc_comp_yn+"&nursing_doc_comp_yn="+nursing_doc_comp_yn+"&implant_entry_cmp_yn="+implant_entry_cmp_yn+"&consumable_entry_cmp_yn="+consumable_entry_cmp_yn+"&equipment_entry_cmp_yn="+equipment_entry_cmp_yn+"&instrument_entry_cmp_yn="+instrument_entry_cmp_yn+"&proc_chrg_cmp_yn="+proc_chrg_cmp_yn+"&check_into_or_time="+check_into_or_time+"&encounter_id="+encounter_id+"&oper_room_code="+oper_room_code+"&episode_type="+episode_type+"&patient_class="+patient_class+"&document_level_yn=Y"+"&tab=record_nursing";

%>

<FRAMESET rows="10%,12%,4%,*,45,10%,0" border='0'>

	<frame name='OtPatientLineFrame' src="../../eOT/jsp/OTPatLineFrame.jsp?<%=params%>" frameborder=0  scrolling="no" noresize>
	<frame name='common_patient_hdr_frame' SRC='../../eOT/jsp/CommonOperDtlsHdr.jsp?<%=params%>'  scrolling='no' noresize></frame>
	<FRAMESET rows='0,*' border='0'>
		<FRAME NAME='ObjectCollect' SRC='../../eOT/jsp/NursingObjectCollect.jsp?<%=params%>'  scrolling='no' noresize='no'>
	    <FRAME name="tab_frame" frameborder="0" scrolling="no" noresize src="../../eOT/jsp/RecordNursingTab.jsp?<%=params%>">    	    
	</FRAMESET>
	<FRAME NAME='RecordFrame' SRC='../../eOT/jsp/ProcedureFrames.jsp?<%=params%>'  scrolling='no' noresize='no'></FRAME>
	<frame name='doc_status_frame' src="../../eOT/jsp/SurgeonDocStatus.jsp?<%=params%>" frameborder="0" nowrap noresize scrolling='yes' ><!-- newly added by Sathish.K for Amazon Changes -->
    <frame name="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto"></frame>
    <frame name="apply_time_dummy_load_frame" src="../../eCommon/html/blank.html" frameborder="0" noresize scrolling="no"></frame>
</FRAMESET>
<body  onKeyDown = 'lockKey();'>
<form name="RecordNursingForm" >
	<input type='hidden' name='params' value='<%=params%>' >
</form>
</body>
</html>
<%}catch(Exception e){
	System.err.println("Exception in RecordnURSINGn.jsp : "+e);
	}finally{
		try{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}%>
