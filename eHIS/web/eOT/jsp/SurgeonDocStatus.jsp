<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.Common.*,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,eCommon.XSSRequestWrapper,java.sql.Statement,java.sql.*,webbeans.eCommon.*,java.sql.Types,java.sql.CallableStatement,eCommon.Common.*,eOT.*,eCommon.Common.CommonBean,java.sql.ResultSetMetaData,webbeans.eCommon.ConnectionManager,java.util.StringTokenizer" %>
<%@include file="../../eCommon/jsp/Common.jsp"  %>
<%@ page contentType=" text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
   
   // Added Against PMG2023-MMS-CRF-0002
	
	String ot_bean_id = "OTCommonBean";
	String ot_bean_name = "eOT.OTCommonBean";
	OTCommonBean bean = (OTCommonBean)mh.getBeanObject( ot_bean_id, request, ot_bean_name );
	
	// Added Against PMG2023-MMS-CRF-0002
%>

<%! 
	String encode(String data){	  
	  byte byteData[] = data.getBytes();
		String outDat = "";
	  for (int i=0; i<byteData.length; i++)
	  {
		outDat = outDat +"%"+Integer.toHexString((int)byteData[i]);
	  }
		return(outDat);
	}
%>
<html>
<script>
function callrestorativechart()
{
	var patient_class=parent.frames[2].document.forms[0].patient_class.value;
	var patient_id=parent.frames[2].document.forms[0].patient_id.value;
	var episode_id=parent.frames[2].document.forms[0].episode_id.value;
	var encounter_id=parent.frames[2].document.forms[0].encounter_id.value;
	var episode_type=parent.frames[2].document.forms[0].episode_type.value;
	var facility_id=parent.frames[2].document.forms[0].facility_id.value;
	var locale = parent.frames[2].document.forms[0].locale.value;
	var function_id="OTH_LINK";
	var oh_chart_num="";
	var chart_flag="";
	var speciality_code=parent.frames[2].document.forms[0].speciality_code.value;
	var location_code=parent.frames[2].document.forms[0].source_code.value;
	var location_type=parent.frames[2].document.forms[0].source_type.value;
	var title = getLabel("eOH.RestorativeChart.Label","OH");
	var accession_num = facility_id+"||"+encounter_id;
	var chart_flag="R";
	var url = "../../eOH/jsp/OH.jsp?modal_yn=Y&accession_num="+accession_num+"&patient_id="+patient_id+"&episode_id="+episode_id+"&patient_class="+patient_class+"&oh_chart_num="+oh_chart_num+"&chart_flag="+chart_flag+"&speciality_code="+speciality_code+"&location_code="+location_code+"&location_type="+location_type+"&episode_type="+episode_type+"&locale="+locale+"&encounter_id="+encounter_id+"&function_id="+function_id+"&called_from=OT"+"&title="+title;
	var features			= "channelmode=yes";
	window.open(url,"CAWindow",features);
}
</script>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String tab = checkForNull(request.getParameter("tab")); 
    String facility_id = (String) session.getAttribute("facility_id");
	String contr_mod_accession_num = "";
	String oper_speciality_code= "";
	String oper_num =  checkForNull(request.getParameter("oper_num"));
	String rec_implants_in_nurs_notes_yn =  checkForNull(request.getParameter("rec_implants_in_nurs_notes_yn"));
	String rec_implants_in_surg_notes_yn =  checkForNull(request.getParameter("rec_implants_in_surg_notes_yn"));
	String rec_equp_in_nurs_notes_yn =  checkForNull(request.getParameter("rec_equp_in_nurs_notes_yn"));
	String rec_instr_in_nurs_notes_yn =  checkForNull(request.getParameter("rec_instr_in_nurs_notes_yn"));
	String rec_packs_in_nurs_notes_yn =  checkForNull(request.getParameter("rec_packs_in_nurs_notes_yn"));
	String st_interface_flag =  checkForNull(request.getParameter("st_interface_flag"));
	String finalize_implants_in =  checkForNull(request.getParameter("finalize_implants_in"));
	String finalize_equp_in =  checkForNull(request.getParameter("finalize_equp_in"));
	String finalize_instr_in =  checkForNull(request.getParameter("finalize_instr_in"));
	String finalize_packs_in =  checkForNull(request.getParameter("finalize_packs_in"));
	String oper_finalization_stage =  checkForNull(request.getParameter("oper_finalization_stage"));
	String proc_chrg_cmp_yn =  checkForNull(request.getParameter("proc_chrg_cmp_yn"));
	String surgeon_doc_comp_yn = checkForNull(request.getParameter("surgeon_doc_comp_yn"));
	String nursing_doc_comp_yn = checkForNull(request.getParameter("nursing_doc_comp_yn"));
	String implant_entry_cmp_yn = checkForNull(request.getParameter("implant_entry_cmp_yn"));
	String consumable_entry_cmp_yn =checkForNull(request.getParameter("consumable_entry_cmp_yn"));
	String equipment_entry_cmp_yn =checkForNull( request.getParameter("equipment_entry_cmp_yn"));
	String instrument_entry_cmp_yn = checkForNull(request.getParameter("instrument_entry_cmp_yn"));
	String bill_flag = checkForNull(request.getParameter("bill_flag"));
	String update_notes_checkbox = "N";
	contr_mod_accession_num=facility_id+oper_num+oper_speciality_code+"30";	 

	Connection con = null;
	Statement stmt=null;
	Statement stmt1=null;//ML-BRU-SCF-1550
	ResultSet rset_cat1=null;
	ResultSet rset_cat2=null;
	ResultSet rset_cat3=null;//ML-BRU-SCF-1550
	ResultSet rs=null;//PMG2023-MMS-CRF-0002
	String SURGEON_UPDATE_NOTES_YN = "";//PMG2023-MMS-CRF-0002
	String checked="",disabled="",checked1="",disabled1="",checked2="",disabled2="",checked3="",disabled3="",checked4="",disabled4="",checked5="",disabled5="",checked6="",disabled6="",oper_code_val="",modified_Surgeon_Note_Date="";//ML-BRU-SCF-1550 and PMG2023-MMS-CRF-0002
	int cnt_val=0;

	Boolean isTimeDtlsSurNurAppl = false;//Added against ML-MMOH-CRF-1936
	
	try{
			con = ConnectionManager.getConnection();

			update_notes_checkbox = checkForNull(bean.getUpdateNoteCheckboxValue(facility_id));
			isTimeDtlsSurNurAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OT", "TIMEDTLS_NUR_SUR_NOTE_MAND");//Added against ML-MMOH-CRF-1936
			System.err.println("isTimeDtlsSurNurAppl---107------------"+isTimeDtlsSurNurAppl);

if(tab.equals("record_surgeon"))
		{
		
			stmt=con.createStatement();
			
			//Added Against PMG2023-MMS-CRF-0002
			String sql="Select SURGEON_UPDATE_NOTES_YN from OT_POST_OPER_HDR where oper_num='"+oper_num+"' and OPERATING_FACILITY_ID='"+facility_id+"'";
			rs=stmt.executeQuery(sql);
			if(rs !=null && rs.next())
			{
				SURGEON_UPDATE_NOTES_YN=rs.getString("SURGEON_UPDATE_NOTES_YN");
				if(SURGEON_UPDATE_NOTES_YN == null) SURGEON_UPDATE_NOTES_YN="";

				if(SURGEON_UPDATE_NOTES_YN.equals("Y") && surgeon_doc_comp_yn.equals("Y")){
					checked6 = "checked";
					disabled6 = "disabled";
				}else if((SURGEON_UPDATE_NOTES_YN.equals("Y") || SURGEON_UPDATE_NOTES_YN.equals("N")) && surgeon_doc_comp_yn.equals("N")){
					checked6 = "checked";
					disabled6 = "disabled";
				}else if((SURGEON_UPDATE_NOTES_YN.equals("") || SURGEON_UPDATE_NOTES_YN.equals(null))) {
					update_notes_checkbox = "N";
				}else{ 
					checked6 = "";
					disabled6 = "";
				}
			}
			
			//Added Against PMG2023-MMS-CRF-0002
			
			String sql_cat1="Select oper_code from OT_POST_OPER_DTLS where oper_num='"+oper_num+"' and OPERATING_FACILITY_ID='"+facility_id+"'";
			rset_cat1=stmt.executeQuery(sql_cat1);
			if(rset_cat1 !=null && rset_cat1.next())
			{
			oper_code_val=rset_cat1.getString("oper_code");
			if(oper_code_val ==null) oper_code_val="";
			}

			if(oper_code_val !="")
			{
			String sql_cat2="select count(*)  from ot_param_for_facility where  OH_TASK_CATALOG in ( Select ORDER_CATALOG_CODE from OT_OPER_MAST where oper_code='"+oper_code_val+"' )";
			rset_cat2=stmt.executeQuery(sql_cat2);
			if(rset_cat2.next())
			{
			cnt_val=rset_cat2.getInt(1);
			}
			}
			//ML-BRU-SCF-1550 start
			if(surgeon_doc_comp_yn.equals("Y"))
			{
			stmt1=con.createStatement();
			String modified_Surgeon_Note_Date_Query="select CONTR_MOD_ACCESSION_NUM, LAST_AMENDED_DATE_TIME from  CA_ENCNTR_NOTE where CONTR_MOD_ACCESSION_NUM like '"+facility_id+"' || '"+oper_num+"' || '%'";			
			rset_cat3=stmt1.executeQuery(modified_Surgeon_Note_Date_Query);
			while(rset_cat3 !=null && rset_cat3.next()){
			modified_Surgeon_Note_Date=modified_Surgeon_Note_Date.concat(rset_cat3.getString("LAST_AMENDED_DATE_TIME")).concat("~");
			}
			}
			//ML-BRU-SCF-1550 End
		}

	if(nursing_doc_comp_yn.equals("Y"))
	{
		checked="checked";
		disabled="disabled";
	}else
	{
		checked="";
		disabled="";
	}
	if(implant_entry_cmp_yn.equals("Y"))
	{
		checked1="checked";
		disabled1="disabled";
	}else
	{
		checked1="";
		disabled1="";
	}
		if(consumable_entry_cmp_yn.equals("Y"))
	{
		checked2="checked";
		disabled2="disabled";
	}else
	{
		checked2="";
		disabled2="";
	}

		if(equipment_entry_cmp_yn.equals("Y"))
	{
		checked3="checked";
		disabled3="disabled";
	}else
	{
		checked3="";
		disabled3="";
	}
		if(instrument_entry_cmp_yn.equals("Y"))
	{
		checked4="checked";
		disabled4="disabled";
	}else
	{
		checked4="";
		disabled4="";
	}
		if(proc_chrg_cmp_yn.equals("Y"))
	{
		checked5="checked";
		disabled5="disabled";
	}else
	{
		checked5="";
		disabled5="";
	}
 
		}catch(Exception e){
		e.printStackTrace();
		System.err.println("Err Msg from RecordSurgeonTab.jsp "+e);
	}finally{
if(rset_cat1!=null) rset_cat1.close();
if(rset_cat2!=null) rset_cat2.close();
if(rset_cat3!=null) rset_cat3.close();//ML-BRU-SCF-1550
if(stmt!=null) stmt.close();
if(stmt1!=null) stmt1.close();//ML-BRU-SCF-1550
if(con!=null) ConnectionManager.returnConnection(con,request);

	}

	
%>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script> 
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='JavaScript' src='../../eOT/js/CommonOperDtlsHdr.js'></script>
	<script language="JavaScript" src="../../eOT/js/RecordNursing.js"></script>

</head>


<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="SurgeonDocStatusForm" id="SurgeonDocStatusForm" >
<table cellspacing="0" width="100%" border="1">
<tr>

<td  align="left" class="columnHeader" width="100%">
<fmt:message key="Common.status.label" bundle="${common_labels}"/>  
</td>
</tr>
<tr>
<%  
	if(tab.equals("record_surgeon") || tab.equals("record_nursing")){	
	 if( tab.equals("record_surgeon")){ 
	if(rec_implants_in_surg_notes_yn.equals("Y"))	//sanjay change to N for testing Incident No IN:027927
		 {
		 if(surgeon_doc_comp_yn.equals("Y") && implant_entry_cmp_yn.equals("N"))
		 {

%>
    
	<td align="left" class="label" width='15%'>
	        <input type='checkbox' name='doc_complete' id='doc_complete'  checked disabled>
			<fmt:message key="eOT.DocumentationCompleted.Label" bundle="${ot_labels}"/> 
	&nbsp;&nbsp;
	<%if(!oper_finalization_stage.equals("S")) {%>
	     <input type='checkbox' name='oper_proc' id='oper_proc'   <%=checked5%> disabled>
			<fmt:message key="eOT.OperationsProcedures.Label" bundle="${ot_labels}"/>
<%}else {%>
	        <input type='checkbox' name='oper_proc' id='oper_proc'  <%=checked5%> <%=disabled5%>>
			<fmt:message key="eOT.OperationsProcedures.Label" bundle="${ot_labels}"/> 
			<%}%>
	&nbsp;&nbsp;
<%if(!finalize_implants_in.equals("RS")) {%>
	<input type='checkbox' name='pros_implants_comp' id='pros_implants_comp' disabled onClick="validatesurgeonchkbox(this,'<%=tab%>','<%=st_interface_flag%>');">
		<fmt:message key="eOT.ProsthesisImplantscompleted.Label" bundle="${ot_labels}"/>
<%}else {%>
			<input type='checkbox' name='pros_implants_comp' id='pros_implants_comp' <%=checked1%> <%=disabled1%> onClick="validatesurgeonchkbox(this,'<%=tab%>','<%=st_interface_flag%>');">
		<fmt:message key="eOT.ProsthesisImplantscompleted.Label" bundle="${ot_labels}"/>
		<%}%>
		
<%if(update_notes_checkbox.equals("Y")){%>		
	<!--Added Against PMG2023-MMS-CRF-0002-->
	<input type='checkbox' id = 'update_notes' name='update_notes' id='update_notes' Onclick = "updatingNotes();" <%=checked6%> <%=disabled6%> >
		<fmt:message key="eOT.UpdateNotes.Label" bundle="${ot_labels}"/>
	<!--Added Against PMG2023-MMS-CRF-0002-->	
<%}%>	

	</td>
<%}else if (surgeon_doc_comp_yn.equals("N") && implant_entry_cmp_yn.equals("Y")){%>
				
		<td align="left" class="label" width='15%'>
	        <input type='checkbox' name='doc_complete' id='doc_complete'   onClick="return allow_surg_acc('<%=tab%>','<%=finalize_implants_in%>','<%=oper_finalization_stage%>');" >
			<fmt:message key="eOT.DocumentationCompleted.Label" bundle="${ot_labels}"/>
			
	&nbsp;&nbsp;
	
	<%if(!oper_finalization_stage.equals("S")) {%>
	     <input type='checkbox' name='oper_proc' id='oper_proc'   <%=checked5%> disabled>
			<fmt:message key="eOT.OperationsProcedures.Label" bundle="${ot_labels}"/>
<%}else {%>
	        <input type='checkbox' name='oper_proc' id='oper_proc'  <%=checked5%> <%=disabled5%>>
			<fmt:message key="eOT.OperationsProcedures.Label" bundle="${ot_labels}"/> 
			<%}%> 
	&nbsp;&nbsp;
<%if(!finalize_implants_in.equals("RS")) {%>
<input type='checkbox' name='pros_implants_comp' id='pros_implants_comp'  disabled checked
			onClick="validatesurgeonchkbox(this,'<%=tab%>','<%=st_interface_flag%>');">
		<fmt:message key="eOT.ProsthesisImplantscompleted.Label" bundle="${ot_labels}"/>
<%}else {%>
			<input type='checkbox' name='pros_implants_comp' id='pros_implants_comp' checked disabled
			onClick="validatesurgeonchkbox(this,'<%=tab%>','<%=st_interface_flag%>');">
		<fmt:message key="eOT.ProsthesisImplantscompleted.Label" bundle="${ot_labels}"/>
				<%}%>
				<%
if(cnt_val >0) {%>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:callrestorativechart()"><fmt:message key="eOT.InvokeRestorativeChart.Label" bundle="${ot_labels}"/></a>
<%}%>

	<!--Added Against PMG2023-MMS-CRF-0002-->
	<%if(update_notes_checkbox.equals("Y")){%>		
	<input type='checkbox' id = 'update_notes' name='update_notes' id='update_notes' <%=checked6%> <%=disabled6%> >
		<fmt:message key="eOT.UpdateNotes.Label" bundle="${ot_labels}"/>
	<%}%>
	<!--Added Against PMG2023-MMS-CRF-0002-->
	
	</td>			
				
				
				
<%}else if (surgeon_doc_comp_yn.equals("Y") && implant_entry_cmp_yn.equals("Y")) {%>
	<td align="left" class="label" width='15%'>
	        <input type='checkbox' name='doc_complete' id='doc_complete'  checked disabled  onClick=" return allow_surg_acc('<%=tab%>','<%=finalize_implants_in%>','<%=oper_finalization_stage%>');" >
			<fmt:message key="eOT.DocumentationCompleted.Label" bundle="${ot_labels}"/>
			
	&nbsp;&nbsp;
		
	<%if(!oper_finalization_stage.equals("S")) {%>
	     <input type='checkbox' name='oper_proc' id='oper_proc'   <%=checked5%> disabled>
			<fmt:message key="eOT.OperationsProcedures.Label" bundle="${ot_labels}"/>
<%}else {%>
	        <input type='checkbox' name='oper_proc' id='oper_proc'  <%=checked5%> <%=disabled5%>>
			<fmt:message key="eOT.OperationsProcedures.Label" bundle="${ot_labels}"/> 
			<%}%>
	&nbsp;&nbsp;
<%if(!finalize_implants_in.equals("RS")) {%>
<input type='checkbox' name='pros_implants_comp' id='pros_implants_comp' checked disabled 
			onClick="validatesurgeonchkbox(this,'<%=tab%>','<%=st_interface_flag%>');">
		<fmt:message key="eOT.ProsthesisImplantscompleted.Label" bundle="${ot_labels}"/>
<%}else {%>
			<input type='checkbox' checked disabled name='pros_implants_comp' id='pros_implants_comp' <%=checked1%> <%=disabled1%> onClick="validatesurgeonchkbox(this,'<%=tab%>','<%=st_interface_flag%>');">
		<fmt:message key="eOT.ProsthesisImplantscompleted.Label" bundle="${ot_labels}"/>
		<%}%>
<%if(update_notes_checkbox.equals("Y")){%>		
	<!--Added Against PMG2023-MMS-CRF-0002-->
	<input type='checkbox' id = 'update_notes' name='update_notes' id='update_notes' Onclick = "updatingNotes();" <%=checked6%> <%=disabled6%> >
		<fmt:message key="eOT.UpdateNotes.Label" bundle="${ot_labels}"/>
	<!--Added Against PMG2023-MMS-CRF-0002-->	
<%}%>
	</td>


<%}else if (surgeon_doc_comp_yn.equals("N") && implant_entry_cmp_yn.equals("N")) {%>

<td align="left" class="label" width='15%'>
	        <input type='checkbox' name='doc_complete' id='doc_complete'   onClick="return allow_surg_acc('<%=tab%>','<%=finalize_implants_in%>','<%=oper_finalization_stage%>');" >
			<fmt:message key="eOT.DocumentationCompleted.Label" bundle="${ot_labels}"/>
			
	&nbsp;&nbsp;
	
	<%if(!oper_finalization_stage.equals("S")) {%>
	        <input type='checkbox' name='oper_proc' id='oper_proc'   <%=checked5%> disabled>
			<fmt:message key="eOT.OperationsProcedures.Label" bundle="${ot_labels}"/>
<%}else {%>
	        <input type='checkbox' name='oper_proc' id='oper_proc'  <%=checked5%> <%=disabled5%>>
			<fmt:message key="eOT.OperationsProcedures.Label" bundle="${ot_labels}"/> 
			<%}%>
	&nbsp;&nbsp;
<%if(!finalize_implants_in.equals("RS")) {%>
<input type='checkbox' name='pros_implants_comp' id='pros_implants_comp'  disabled
			onClick="validatesurgeonchkbox(this,'<%=tab%>','<%=st_interface_flag%>');">
		<fmt:message key="eOT.ProsthesisImplantscompleted.Label" bundle="${ot_labels}"/>
<%}else {%>
			<input type='checkbox' name='pros_implants_comp' id='pros_implants_comp'  onClick="validatesurgeonchkbox(this,'<%=tab%>','<%=st_interface_flag%>');">
		<fmt:message key="eOT.ProsthesisImplantscompleted.Label" bundle="${ot_labels}"/>
		<%}%>


<%
 if(cnt_val >0) {%>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:callrestorativechart()"><fmt:message key="eOT.InvokeRestorativeChart.Label" bundle="${ot_labels}"/></a>
<%}%>

	<!--Added Against PMG2023-MMS-CRF-0002--> 
	<%if(update_notes_checkbox.equals("Y")){	
	%>		
	<input type='checkbox' id = 'update_notes' name='update_notes' id='update_notes' <%=checked6%> <%=disabled6%> >
		<fmt:message key="eOT.UpdateNotes.Label" bundle="${ot_labels}"/>
	<%}%>
	<!--Added Against PMG2023-MMS-CRF-0002-->
	
	</td>


<%}
   }else {
	    if(surgeon_doc_comp_yn.equals("Y"))
		 {
			//PMG2014-KDAH-CRF-0001-03 [IN:047731] 
			if(oper_finalization_stage.equals("S") && !finalize_implants_in.equals("RS")){
%>
		<td align="left" class="label" width='15%'>
	        <input type='checkbox' name='doc_complete' id='doc_complete'  checked disabled>
			<fmt:message key="eOT.DocumentationCompleted.Label" bundle="${ot_labels}"/>
		
			  <input type='checkbox' name='oper_proc' id='oper_proc'   <%=checked5%> <%=disabled5%>>
			  <fmt:message key="eOT.OperationsProcedures.Label" bundle="${ot_labels}"/>
			  
			<%if(update_notes_checkbox.equals("Y")){%>		
				<!--Added Against PMG2023-MMS-CRF-0002-->
				<input type='checkbox' id = 'update_notes' name='update_notes' id='update_notes' Onclick = "updatingNotes();" <%=checked6%> <%=disabled6%> >
				<fmt:message key="eOT.UpdateNotes.Label" bundle="${ot_labels}"/>
				<!--Added Against PMG2023-MMS-CRF-0002-->	
			<%}%>  
			</td>
 <% }else {%>
		<td align="left" class="label" width='15%'>
	        <input type='checkbox' name='doc_complete' id='doc_complete'  checked disabled>
			<fmt:message key="eOT.DocumentationCompleted.Label" bundle="${ot_labels}"/>
			
		<%if(update_notes_checkbox.equals("Y")){%>		
				<!--Added Against PMG2023-MMS-CRF-0002-->
				<input type='checkbox' id = 'update_notes' name='update_notes' id='update_notes' Onclick = "updatingNotes();" <%=checked6%> <%=disabled6%> >
				<fmt:message key="eOT.UpdateNotes.Label" bundle="${ot_labels}"/>
				<!--Added Against PMG2023-MMS-CRF-0002-->	
		<%}%> 	
		</td>
 <%}%>
  <% }else {
           //PMG2014-KDAH-CRF-0001-03 [IN:047731] 
			if(oper_finalization_stage.equals("S") && !finalize_implants_in.equals("RS")){%>
			<td align="left" class="label" width='15%'>
	        <input type='checkbox' name='doc_complete' id='doc_complete'  onClick=" return allow_surg_acc('<%=tab%>','<%=finalize_implants_in%>','');" >
			<fmt:message key="eOT.DocumentationCompleted.Label" bundle="${ot_labels}"/>
			<input type='checkbox' name='oper_proc' id='oper_proc'   <%=checked5%> <%=disabled5%>>
			<fmt:message key="eOT.OperationsProcedures.Label" bundle="${ot_labels}"/>
			<%if(update_notes_checkbox.equals("Y")){%>		
				<!--Added Against PMG2023-MMS-CRF-0002-->
				<input type='checkbox' id = 'update_notes' name='update_notes' id='update_notes' Onclick = "updatingNotes();" <%=checked6%> <%=disabled6%> >
				<fmt:message key="eOT.UpdateNotes.Label" bundle="${ot_labels}"/>
				<!--Added Against PMG2023-MMS-CRF-0002-->	
			<%}%> 
			</td>
			<%}else{%>
			<td align="left" class="label" width='15%'>
	        <input type='checkbox' name='doc_complete' id='doc_complete'  onClick=" return allow_surg_acc('<%=tab%>','<%=finalize_implants_in%>','');" >
			<fmt:message key="eOT.DocumentationCompleted.Label" bundle="${ot_labels}"/>
		    &nbsp;
			<!-- below lines added by Sanjay for IN:027927 on 27-Jun-2011 -->
			
			<input type='hidden' name='oper_proc' id='oper_proc' value='N' >
			<input type='hidden' name='pros_implants_comp' id='pros_implants_comp' value='N' > 
		<%}%>	<!--PMG2014-KDAH-CRF-0001-03 [IN:047731] -->
			
			<!-- Changes ends for IN:027927 -->
			<%if(cnt_val >0) {%>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:callrestorativechart()"><fmt:message key="eOT.InvokeRestorativeChart.Label" bundle="${ot_labels}"/></a>
<%}%>

<%if(update_notes_checkbox.equals("Y")){%>		
	<!--Added Against PMG2023-MMS-CRF-0002-->
	<input type='checkbox' id = 'update_notes' name='update_notes' id='update_notes' Onclick = "updatingNotes();" <%=checked6%> <%=disabled6%> >
		<fmt:message key="eOT.UpdateNotes.Label" bundle="${ot_labels}"/>
	<!--Added Against PMG2023-MMS-CRF-0002-->	
<%}%>

</td>
	
<%}}%>
 <%}else if(tab.equals("record_nursing")) {%>


<%if(nursing_doc_comp_yn.equals("Y"))
		 {
%>
    
	<td align="left" class="label" width='15%'>
	        <input type='checkbox' name='doc_complete' id='doc_complete'  checked disabled>
			<fmt:message key="eOT.DocumentationCompleted.Label" bundle="${ot_labels}"/> &nbsp;&nbsp;
 <% }else {%>
	<td align="left" class="label" width='15%'>
	        <input type='checkbox' name='doc_complete' id='doc_complete'  onClick=" return allow_surg_acc_nursing('<%=tab%>','<%=finalize_implants_in%>','<%=finalize_packs_in%>','<%=finalize_equp_in%>','<%=finalize_instr_in%>');" >
			<fmt:message key="eOT.DocumentationCompleted.Label" bundle="${ot_labels}"/> &nbsp;&nbsp;
	
<%}%>


<%if(!finalize_implants_in.equals("RN")) {%>
	<input type='checkbox' name='pros_implants_comp' id='pros_implants_comp' disabled <%=checked1%> onClick="validatesurgeonchkbox(this,'<%=tab%>','<%=st_interface_flag%>');">
		<fmt:message key="eOT.ProsthesisImplantscompleted.Label" bundle="${ot_labels}"/>&nbsp;&nbsp;
		<%}else if(rec_implants_in_nurs_notes_yn.equals("Y")) {%>

	<input type='checkbox' name='pros_implants_comp' id='pros_implants_comp' <%=checked1%> <%=disabled1%> onClick="validatesurgeonchkbox(this,'<%=tab%>','<%=st_interface_flag%>');">
		<fmt:message key="eOT.ProsthesisImplantscompleted.Label" bundle="${ot_labels}"/> 	&nbsp;&nbsp;
<%}%>

<%if(!finalize_packs_in.equals("RN")) {%>

<input type='checkbox' name='cons_packs_comp' id='cons_packs_comp' disabled <%=checked2%>  onClick="validatesurgeonchkbox(this,'<%=tab%>','<%=st_interface_flag%>');">
		<fmt:message key="eOT.ConsumablesCompleted.Label" bundle="${ot_labels}"/> 	&nbsp;&nbsp;

<% }else if(rec_packs_in_nurs_notes_yn.equals("Y")) {%>

<input type='checkbox' name='cons_packs_comp' id='cons_packs_comp' <%=checked2%> <%=disabled2%> onClick="validatesurgeonchkbox(this,'<%=tab%>','<%=st_interface_flag%>');">
		<fmt:message key="eOT.ConsumablesCompleted.Label" bundle="${ot_labels}"/> 	&nbsp;&nbsp;

<%}%>

<%if(!finalize_equp_in.equals("RN")) {%>
<input type='checkbox' name='equip_comp' id='equip_comp' disabled <%=checked3%> onClick="validatesurgeonchkbox(this,'<%=tab%>','<%=st_interface_flag%>');">
		<fmt:message key="eOT.EquipmentsCompleted.Label" bundle="${ot_labels}"/> 	&nbsp;&nbsp;

<%}else if(rec_equp_in_nurs_notes_yn.equals("Y")) {%>
	<input type='checkbox' name='equip_comp' id='equip_comp' <%=checked3%> <%=disabled3%> onClick="validatesurgeonchkbox(this,'<%=tab%>','<%=st_interface_flag%>');">
		<fmt:message key="eOT.EquipmentsCompleted.Label" bundle="${ot_labels}"/> 	&nbsp;&nbsp;
<%}%>

<%if(!finalize_instr_in.equals("RN")) {%>
	<input type='checkbox' name='instr_css_comp' id='instr_css_comp' disabled <%=checked4%> onClick="validatesurgeonchkbox(this,'<%=tab%>','<%=st_interface_flag%>');">
		<fmt:message key="eOT.InstrumentsCSSDPacksCompleted.Label" bundle="${ot_labels}"/> &nbsp;&nbsp;
<%}else if(rec_instr_in_nurs_notes_yn.equals("Y")) {%>
	<input type='checkbox' name='instr_css_comp' id='instr_css_comp' <%=checked4%> <%=disabled4%> onClick="validatesurgeonchkbox(this,'<%=tab%>','<%=st_interface_flag%>');">
		<fmt:message key="eOT.InstrumentsCSSDPacksCompleted.Label" bundle="${ot_labels}"/> &nbsp;&nbsp;
<%}%>

	<input type="button" class="button" name="record" id="record"  align='right' value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onclick="recordCharges();">
	</td>
	 <%}
  }
%>
</tr>
<input type='hidden' name='contr_mod_accession_num' id='contr_mod_accession_num' value='<%=contr_mod_accession_num%>'>
<input type='hidden' name='oper_num' id='oper_num' value='<%=oper_num%>'>
<input type='hidden' name='surgeon_doc_comp_yn' id='surgeon_doc_comp_yn' value='<%=surgeon_doc_comp_yn%>' >
<input type='hidden' name='nursing_doc_comp_yn' id='nursing_doc_comp_yn' value='<%=nursing_doc_comp_yn%>' >
<input type='hidden' name='implant_entry_cmp_yn' id='implant_entry_cmp_yn' value='<%=implant_entry_cmp_yn%>' >
<input type='hidden' name='consumable_entry_cmp_yn' id='consumable_entry_cmp_yn' value='<%=consumable_entry_cmp_yn%>' >
<input type='hidden' name='equipment_entry_cmp_yn' id='equipment_entry_cmp_yn' value='<%=equipment_entry_cmp_yn%>' >
<input type='hidden' name='instrument_entry_cmp_yn' id='instrument_entry_cmp_yn' value='<%=instrument_entry_cmp_yn%>' >
<input type='hidden' name='finalize_implants_in' id='finalize_implants_in' value='<%=finalize_implants_in%>' >
<input type='hidden' name='bill_flag' id='bill_flag' value='<%=bill_flag%>' >
<input type='hidden' name='modified_Surgeon_Note_Date' id='modified_Surgeon_Note_Date' value='<%=modified_Surgeon_Note_Date%>' ><!--ML-BRU-SCF-1550-->
<input type='hidden' name='isTimeDtlsSurNurAppl' id='isTimeDtlsSurNurAppl' value="<%=isTimeDtlsSurNurAppl%>"><!-- Added Against ML-MMOH-CRF-1936 -->
<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>"><!-- Added Against ML-MMOH-CRF-1936 -->
<input type='hidden' name='update_notes2' id='update_notes2' ><!-- Added Against PMG2023-MMS-CRF-0002 -->
<input type='hidden' name='surgeon_update_notes_yn' id='surgeon_update_notes_yn' value="<%=SURGEON_UPDATE_NOTES_YN%>" ><!-- Added Against PMG2023-MMS-CRF-0002 -->
</form>
</body>

