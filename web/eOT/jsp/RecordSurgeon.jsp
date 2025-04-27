<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
 <%@ page contentType="text/html;charset=UTF-8"  import ="eCommon.Common.CommonBean,eOR.OrderEntryBillingQueryBean,java.sql.Connection,java.sql.PreparedStatement,eCommon.XSSRequestWrapper,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"  %>

<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<title><fmt:message key="eOT.RecordSurgeonNotes.Label" bundle="${ot_labels}"/></title>
<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String facility_id = (String) session.getAttribute("facility_id");
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eOT/js/RecordSurgeon.js"></script>
	<script language="javascript" src="../../eOT/js/Hashtable.js"></script>
	<script language="javascript" src="../../eOT/js/OTCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
</head>

<%
Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	String bill_interface_flag_yn="",bill_sub_services_yn="",params="",source="",rec_implants_in_nurs_notes_yn="",rec_implants_in_surg_notes_yn="",rec_equp_in_nurs_notes_yn="",rec_instr_in_nurs_notes_yn="",rec_packs_in_nurs_notes_yn="",finalize_implants_in="",finalize_equp_in="",finalize_instr_in="",finalize_packs_in="",oper_finalization_stage="",storeCode="",st_interface_flag="",operation_sub_services_yn="",surgeon_doc_comp_yn="",nursing_doc_comp_yn="",implant_entry_cmp_yn="",consumable_entry_cmp_yn="",equipment_entry_cmp_yn="",instrument_entry_cmp_yn="",proc_chrg_cmp_yn="",check_into_or_time="",oper_room_code="", encounter_id="",episode_type="",patient_class="",Link_Operation_And_Notes_in_Record_Surgeon_Notes="";//PMG MOD-0005
	String check_in_time = "";
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	 params = request.getQueryString();
	/*
	Commented by DhanasekarV against incident IN029391 billing subservices
		params=params+"&bill_interface_flag_yn="+bill_interface_flag_yn+"&bill_sub_services_yn="+bill_sub_services_yn;
	*/

	String tab_name = CommonBean.checkForNull(request.getParameter("tab_name"));//Added Against ML-MMOH-CRF-1939-US4
	String called_from = CommonBean.checkForNull(request.getParameter("called_from"));
	String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	String booking_num = CommonBean.checkForNull(request.getParameter("booking_num")); // 04000112
	String slate_user_id = CommonBean.checkForNull(request.getParameter("slate_user_id")); // logged in user from Slate
	if(called_from==null) called_from="OT_MENU";
	if(called_from!=null && called_from.equals("null")) called_from="OT_MENU";
	if(called_from!=null && called_from.equals("")) called_from="OT_MENU";
	String modified_date = "";

	try
	{
		con=ConnectionManager.getConnection(request);
		stmt=con.prepareStatement("SELECT BL_INTERFACE_FLAG,OPERATION_SUB_SERVICES_YN,DEF_ST_STORE,NVL(ST_INTERFACE_FLAG,'N') ST_INTERFACE_FLAG, NVL(REC_PACKS_IN_NURS_NOTES_YN, 'N') REC_PACKS_IN_NURS_NOTES_YN , nvl(OPERATION_SUB_SERVICES_YN,'N') OPERATION_SUB_SERVICES_YN,NVL(REC_IMPLANTS_IN_NURS_NOTES_YN,'N') REC_IMPLANTS_IN_NURS_NOTES_YN,NVL(REC_IMPLANTS_IN_SURG_NOTES_YN,'N') REC_IMPLANTS_IN_SURG_NOTES_YN, NVL(REC_EQUP_IN_NURS_NOTES_YN,'N') REC_EQUP_IN_NURS_NOTES_YN, NVL(REC_INSTR_IN_NURS_NOTES_YN,'N') REC_INSTR_IN_NURS_NOTES_YN,  NVL(FINALIZE_IMPLANTS_IN,'N') FINALIZE_IMPLANTS_IN,  NVL(FINALIZE_EQUP_IN,'N') FINALIZE_EQUP_IN,  NVL(FINALIZE_INSTR_IN,'N') FINALIZE_INSTR_IN,  NVL(FINALIZE_PACKS_IN,'N') FINALIZE_PACKS_IN, NVL(OPER_FINALIZATION_STAGE,'N') OPER_FINALIZATION_STAGE,LINK_OPER_RECORD_NOTES_YN  FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID=?");//PMG MOD-0005
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
			Link_Operation_And_Notes_in_Record_Surgeon_Notes=checkForNull(rs.getString("LINK_OPER_RECORD_NOTES_YN"));//PMG MOD-0005
		}
//Added modified_date by Anitha on modified_date
		stmt=con.prepareStatement("SELECT  TO_CHAR (check_in_time, 'DD/MM/YYYY HH24:MI') check_in_time, OPER_ROOM_CODE, ENCOUNTER_ID,NVL(NURSING_DOC_COMP_YN, 'N') NURSING_DOC_COMP_YN,NVL(SURGEON_DOC_COMP_YN, 'N') SURGEON_DOC_COMP_YN,NVL(IMPLANT_ENTRY_CMP_YN,'N')IMPLANT_ENTRY_CMP_YN,nvl(CONSUMABLE_ENTRY_CMP_YN,'N') CONSUMABLE_ENTRY_CMP_YN,nvl(EQUIPMENT_ENTRY_CMP_YN,'N')EQUIPMENT_ENTRY_CMP_YN,nvl(INSTRUMENT_ENTRY_CMP_YN,'N') INSTRUMENT_ENTRY_CMP_YN,nvl(PROC_CHRG_CMP_YN,'N')PROC_CHRG_CMP_YN,TO_CHAR(CHECK_INTO_OR_TIME,'DD/MM/YYYY HH24:MI') CHECK_INTO_OR_TIME,EPISODE_TYPE,PATIENT_CLASS,to_char(MODIFIED_DATE,'DD/MM/YYYY HH24:MI:SS') MODIFIED_DATE FROM OT_POST_OPER_HDR WHERE OPER_NUM='"+oper_num+"' AND OPERATING_FACILITY_ID=?");
		stmt.setString(1,facility_id);
		rs=stmt.executeQuery();

		if(rs !=null && rs.next())
		{
			 surgeon_doc_comp_yn = checkForNull(rs.getString("SURGEON_DOC_COMP_YN"));
			 if(surgeon_doc_comp_yn =="")
			 	surgeon_doc_comp_yn="N";
			 nursing_doc_comp_yn = checkForNull(rs.getString("NURSING_DOC_COMP_YN"));
			 if(nursing_doc_comp_yn =="")
			 	nursing_doc_comp_yn="N";
			 implant_entry_cmp_yn = checkForNull(rs.getString("IMPLANT_ENTRY_CMP_YN"));
			 if(implant_entry_cmp_yn =="")
			 implant_entry_cmp_yn="N";
			 consumable_entry_cmp_yn = checkForNull(rs.getString("CONSUMABLE_ENTRY_CMP_YN"));
			 if(consumable_entry_cmp_yn =="")
			 consumable_entry_cmp_yn="N";
			 equipment_entry_cmp_yn = checkForNull(rs.getString("EQUIPMENT_ENTRY_CMP_YN"));
			 if(equipment_entry_cmp_yn =="")
			 	equipment_entry_cmp_yn="N";
			 instrument_entry_cmp_yn = checkForNull(rs.getString("INSTRUMENT_ENTRY_CMP_YN"));
			 if(instrument_entry_cmp_yn =="")
			 	instrument_entry_cmp_yn="N";
			   proc_chrg_cmp_yn = checkForNull(rs.getString("PROC_CHRG_CMP_YN"));
			 if(proc_chrg_cmp_yn =="")
			 	proc_chrg_cmp_yn="N";
			  check_into_or_time= checkForNull(rs.getString("CHECK_INTO_OR_TIME"));
			  oper_room_code= checkForNull(rs.getString("OPER_ROOM_CODE"));
			  encounter_id= checkForNull(rs.getString("ENCOUNTER_ID"));
			  episode_type = checkForNull(rs.getString("EPISODE_TYPE"));
			 if(episode_type =="")
			 	episode_type="";
			  patient_class = checkForNull(rs.getString("PATIENT_CLASS"));
			 if(patient_class =="")
			 	patient_class=""; 
			  modified_date = checkForNull(rs.getString("MODIFIED_DATE"));
			 if(modified_date =="")
			 	modified_date="";
			 check_in_time = checkForNull(rs.getString("check_in_time"));
			 if(check_in_time == null || check_in_time.trim().length() == 0)
			 	check_in_time = "";
		}		
	String recordSurgeonNotes_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.RecordSurgeonNotes.Label","ot_labels");

	

//Added bill_interface_flag_yn by DhanasekarV against incident IN029391 billing subservices
params=params+"&bill_interface_flag_yn="+bill_interface_flag_yn+"&bill_sub_services_yn="+bill_sub_services_yn;
//Added modified_date in params by Anitha on 2/3/2011
	params = params+"&function_name="+recordSurgeonNotes_title+""+"&called_from="+called_from+"&check_in_time="+check_in_time+"&booking_num="+booking_num+"&slate_user_id="+slate_user_id+"&facility_id="+facility_id+"&storeCode="+storeCode+"&st_interface_flag="+st_interface_flag+"&rec_packs_in_nurs_notes_yn="+rec_packs_in_nurs_notes_yn+"&operation_sub_services_yn="+operation_sub_services_yn+"&rec_implants_in_nurs_notes_yn="+rec_implants_in_nurs_notes_yn+"&rec_implants_in_surg_notes_yn="+rec_implants_in_surg_notes_yn+"&rec_equp_in_nurs_notes_yn="+rec_equp_in_nurs_notes_yn+"&rec_instr_in_nurs_notes_yn="+rec_instr_in_nurs_notes_yn+"&finalize_implants_in="+finalize_implants_in+"&finalize_equp_in="+finalize_equp_in+"&finalize_instr_in="+finalize_instr_in+"&finalize_packs_in="+finalize_packs_in+"&oper_finalization_stage="+oper_finalization_stage+"&surgeon_doc_comp_yn="+surgeon_doc_comp_yn+"&nursing_doc_comp_yn="+nursing_doc_comp_yn+"&implant_entry_cmp_yn="+implant_entry_cmp_yn+"&consumable_entry_cmp_yn="+consumable_entry_cmp_yn+"&equipment_entry_cmp_yn="+equipment_entry_cmp_yn+"&instrument_entry_cmp_yn="+instrument_entry_cmp_yn+"&proc_chrg_cmp_yn="+proc_chrg_cmp_yn+"&check_into_or_time="+check_into_or_time+"&encounter_id="+encounter_id+"&oper_room_code="+oper_room_code+"&episode_type="+episode_type+"&patient_class="+patient_class+"&modified_date="+modified_date+"&document_level_yn=Y&tab=record_surgeon&Link_Operation_And_Notes_in_Record_Surgeon_Notes="+Link_Operation_And_Notes_in_Record_Surgeon_Notes+"&tab_name="+tab_name;//PMG MOD-0005 Modified Against ML-MMOH-CRF-1939-US4
	 source = url + params ;
	String bean_id 						= "OrderEntryBillingQueryBean";
	String bean_name 					= "eOR.OrderEntryBillingQueryBean";
	OrderEntryBillingQueryBean or_bean		= (OrderEntryBillingQueryBean)getBeanObject( bean_id, bean_name, request ) ;
	or_bean.clearBean();
	cleanAll(session);
	}catch(Exception e){
	System.err.println("Exception in RecordSurgeon.jsp : "+e);
	e.printStackTrace();
	}finally{
		try{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){
		e.printStackTrace();
		}
	}
%>

<FRAMESET rows="42,12%,11%,8%,*,8%,10%,0%" border='0'>
    <frame name="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%=source%>">
	<frame name='OtPatientLineFrame' SRC='../../eOT/jsp/OTPatLineFrame.jsp?<%=params%>'  scrolling='yes' noresize>
	<frame name='common_patient_hdr_frame' SRC='../../eOT/jsp/CommonOperDtlsHdr.jsp?<%=params%>'  scrolling='yes' noresize></frame>
	<FRAMESET rows='0,*' border='0'>
	<FRAME NAME='ObjectCollect'scrolling='no' noresize='no' SRC='../../eOT/jsp/OperCollectObject.jsp?<%=params%>'  ></FRAME>
	 <frame name="tab_frame" frameborder="0" scrolling="no" noresize src="../../eOT/jsp/RecordSurgeonTab.jsp?<%=params%>"></frame>    	    
	</FRAMESET>
	<frame name="RecordFrame" src="../../eCommon/html/blank.html" frameborder="0" noresize scrolling="auto"></frame>
	<frame name='doc_status_frame' SRC="../../eCommon/html/blank.html" frameborder="0" noresize scrolling="auto"></frame>
	<frame name="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto"></frame>
	<frame name="content" frameborder="0" scrolling="no" src="../../eOT/jsp/ContentMessageFrame.jsp" noresize>
<!--Chaitanya
	<FRAME NAME='RecordFrame' SRC='../../eOT/jsp/ProcedureFrames.jsp?<%=params%>'  scrolling='no' noresize='no'></FRAME> 
	<frame name='doc_status_frame' src="../../eOT/jsp/SurgeonDocStatus.jsp?<%=params%>" frameborder="0" nowrap noresize scrolling='yes' >
	<frame name="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto"></frame>
	<frame name="content" frameborder="0" scrolling="no" src="../../eOT/jsp/ContentMessageFrame.jsp" noresize>
-->
</FRAMESET>
<body  onKeyDown = 'lockKey();'>
<form name="OTCheckinForm" >
	<input type='hidden' name='params' value='<%=params%>' >
	<input type='hidden' name='check_in_time' value='<%=check_in_time%>' >
	<input type="hidden" name="Link_Operation_And_Notes_in_Record_Surgeon_Notes" id="Link_Operation_And_Notes_in_Record_Surgeon_Notes" value='<%=Link_Operation_And_Notes_in_Record_Surgeon_Notes%>'>
</form>
</body>
</html>
