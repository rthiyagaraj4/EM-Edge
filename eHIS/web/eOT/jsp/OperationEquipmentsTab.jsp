<!DOCTYPE html>
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8"  %>
<%@page  contentType=" text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
<head>
<%
//Added Against MMS Vulnerability Issue - Starts
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
//Added Against MMS Vulnerability Issue - Ends

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String bill_flag =checkForNull(request.getParameter("bill_flag"));
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/Tabs.css"></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script language="javascript">
function changeTab(objStr)
{
	selectTab(objStr);
	var frmObj=document.forms[0];
	var oper_code_new=document.forms[0].oper_code_new.value;
	var param=frmObj.param.value+"&tab_id="+objStr+"&oper_code_new="+oper_code_new;
	if(parent.ChildBaseFrame!=null)
	{
		if(frmObj.tab.value !="record_surgeon")
		{

			if(objStr=="OperationsTab")
		{
		setTimeout(function(){parent.ChildBaseFrame.location.href='../../eOT/jsp/NursingOperDtlsChildFrames.jsp?'+param,3000});	 //Added setTimeOut against SKR-SCF-1596
		parent.ResultsFrame.location.href='../../eCommon/html/blank.html';
		}else if(objStr=="SurgaccessTab")
		{
			//Commented on 11/24/2010 by Anitha for scf=5515
		//parent.ChildBaseFrame.location.href='../../eOT/jsp/ProsthesisImplants.jsp?'+param
		parent.ChildBaseFrame.location.href='../../eOT/jsp/ProsthesisImplants.jsp?'+param
		parent.ResultsFrame.location.href='../../eOT/jsp/SurgicalAccessoriesResult.jsp?'+param
		}
		}else
		{
			if(objStr=="OperationsTab")
		{
			
		setTimeout(function(){parent.ChildBaseFrame.location.href='../../eOT/jsp/SurgeonOperationRecord.jsp?'+param,3000});	 //Added setTimeOut against SKR-SCF-1596
		parent.ResultsFrame.location.href='../../eCommon/html/blank.html';
		}else if(objStr=="SurgaccessTab")
		{
		parent.ChildBaseFrame.location.href='../../eOT/jsp/ProsthesisImplants.jsp?'+param
		parent.ResultsFrame.location.href='../../eOT/jsp/SurgicalAccessoriesResult.jsp?'+param
		}
		}
	}
	if(parent.parent.messageFrame!=null)
		parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
}
function callForDefaultBLLoading()
{   
	var frmObj=document.forms[0];
	var param=frmObj.param.value;
	if(parent.parent.apply_time_dummy_load_frame!=null){
	}
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
request.setCharacterEncoding("UTF-8");

	HashMap NursingDtls = new HashMap();

	String tab = checkForNull(request.getParameter("tab"));
	String val = checkForNull(request.getParameter("rec_implants_in_surg_notes_yn"));
	String rec_implants_in_nurs_notes_yn = checkForNull(request.getParameter("rec_implants_in_nurs_notes_yn"));
	String rec_equp_in_nurs_notes_yn = checkForNull(request.getParameter("rec_equp_in_nurs_notes_yn"));
	String rec_instr_in_nurs_notes_yn = checkForNull(request.getParameter("rec_instr_in_nurs_notes_yn"));
	String rec_packs_in_nurs_notes_yn = checkForNull(request.getParameter("rec_packs_in_nurs_notes_yn"));

	//Added on 11/24/2010 by AnithaJ for scf-5515
	String oper_num = checkForNull(request.getParameter("oper_num"));
	String facility_id = checkForNull(request.getParameter("facility_id"));
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String booking_num = checkForNull(request.getParameter("booking_num"));
	String surgeon_code = checkForNull(request.getParameter("surgeon_code"));
	String oper_room_code = checkForNull(request.getParameter("oper_room_code"));
	String encounter_id = checkForNull(request.getParameter("encounter_id"));

	String rec_implants_in_surg_notes_yn = checkForNull(request.getParameter("rec_implants_in_surg_notes_yn"));
	String st_interface_flag = checkForNull(request.getParameter("st_interface_flag"));
	String episode_type = checkForNull(request.getParameter("episode_type"));
	String patient_class = checkForNull(request.getParameter("patient_class"));
	String surgeon_doc_comp_yn = checkForNull(request.getParameter("surgeon_doc_comp_yn"));
	String nursing_doc_comp_yn = checkForNull(request.getParameter("nursing_doc_comp_yn"));
	String implant_entry_cmp_yn = checkForNull(request.getParameter("implant_entry_cmp_yn"));
	String consumable_entry_cmp_yn = checkForNull(request.getParameter("consumable_entry_cmp_yn"));
	String equipment_entry_cmp_yn = checkForNull(request.getParameter("equipment_entry_cmp_yn"));
	String instrument_entry_cmp_yn = checkForNull(request.getParameter("instrument_entry_cmp_yn"));

	NursingDtls.put("tab",tab);
	NursingDtls.put("oper_num",oper_num);
	NursingDtls.put("facility_id",facility_id);
	NursingDtls.put("patient_id",patient_id);
	NursingDtls.put("booking_num",booking_num);
	NursingDtls.put("surgeon_code",surgeon_code);
	NursingDtls.put("bill_flag",bill_flag);
	NursingDtls.put("oper_room_code",oper_room_code);
	NursingDtls.put("surgeon_code",surgeon_code);
	NursingDtls.put("encounter_id",encounter_id );
	NursingDtls.put("rec_implants_in_surg_notes_yn",rec_implants_in_surg_notes_yn);
	NursingDtls.put("rec_implants_in_nurs_notes_yn",rec_implants_in_nurs_notes_yn);
	NursingDtls.put("rec_equp_in_nurs_notes_yn",rec_equp_in_nurs_notes_yn);
	NursingDtls.put("rec_instr_in_nurs_notes_yn",rec_instr_in_nurs_notes_yn);
	NursingDtls.put("rec_packs_in_nurs_notes_yn",rec_packs_in_nurs_notes_yn);
	NursingDtls.put("st_interface_flag",st_interface_flag);
	NursingDtls.put("episode_type",episode_type);
	NursingDtls.put("patient_class",patient_class);
	NursingDtls.put("surgeon_doc_comp_yn",surgeon_doc_comp_yn);
	NursingDtls.put("nursing_doc_comp_yn",nursing_doc_comp_yn);
	NursingDtls.put("rec_implants_in_nurs_notes_yn",rec_implants_in_nurs_notes_yn);
	NursingDtls.put("nursing_doc_comp_yn",nursing_doc_comp_yn);
	NursingDtls.put("implant_entry_cmp_yn",implant_entry_cmp_yn);
	NursingDtls.put("nursing_doc_comp_yn",nursing_doc_comp_yn);
	NursingDtls.put("consumable_entry_cmp_yn",consumable_entry_cmp_yn);
	NursingDtls.put("equipment_entry_cmp_yn",equipment_entry_cmp_yn);
	NursingDtls.put("instrument_entry_cmp_yn",instrument_entry_cmp_yn);

	session.setAttribute("NursingDetails",NursingDtls);

%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="OperationEquipmentsTabForm" id="OperationEquipmentsTabForm">
	<table id="tab" cellspacing=0 cellpadding=3  border="0" width='100%' align='3'>
<tr>
	<td width="100%" class="white">
		<ul id='tablist' class='tablist'>
			<li class='tablistitem' title='<fmt:message key="eOT.OperationsProcedures.Label" bundle="${ot_labels}"/>'>
				<a onclick="changeTab('OperationsTab')" class="tabclicked" id="OperationsTab">
					<span class="tabSpanclicked" id="OperationsTabspan">
						<fmt:message key="eOT.OperationsProcedures.Label" bundle="${ot_labels}"/></span></a>
			</li>
<%if(tab.equals("record_surgeon") && val.equals("Y")) {%>
			<li class="tablistitem" title='<fmt:message key="eOT.SurgicalAccessories.Label" bundle="${ot_labels}"/>' >
				<a onclick="changeTab('SurgaccessTab')" class="tabA" id="SurgaccessTab">
					<span class="tabAspan" id="SurgaccessTabspan">
						<fmt:message key="eOT.SurgicalAccessories.Label" bundle="${ot_labels}"/>
						</span>
				</a>
			</li>
			<%}else if(tab.equals("record_nursing")) {
				if(rec_implants_in_nurs_notes_yn.equals("N") && rec_equp_in_nurs_notes_yn.equals("N") && rec_instr_in_nurs_notes_yn.equals("N") && rec_packs_in_nurs_notes_yn.equals("N") )
				{
				%>
				<%}else{%>
			<li class="tablistitem" title='<fmt:message key="eOT.SurgicalAccessories.Label" bundle="${ot_labels}"/>' >
				<a onclick="changeTab('SurgaccessTab')" class="tabA" id="SurgaccessTab">
					<span class="tabAspan" id="SurgaccessTabspan">
						<fmt:message key="eOT.SurgicalAccessories.Label" bundle="${ot_labels}"/>
						</span>
				</a>
			</li>
			  <%}
}%>
		</ul>
	</td>
</tr>
</table>
<input type='hidden' name='param' id='param' value='<%=request.getQueryString()%>'>
<input type='hidden' name='tab' id='tab' value='<%=tab%>'>
<input type='hidden' name='oper_code_new' id='oper_code_new' value=''>
<input type='hidden' name='oper_desc_val' id='oper_desc_val' value=''>
<input type='hidden' name='oper_code_all' id='oper_code_all' value=''>
<input type='hidden' name='status_value' id='status_value' value=''>
<input type='hidden' name='row_length' id='row_length' value=''>
<input type='hidden' name='chk_val' id='chk_val' value=''>

<%if(("true").equals(bill_flag)){%>
<script>callForDefaultBLLoading()</script> 
<%}%>
<script>prevTabObj='OperationsTab'</script>
<script>changeTab('OperationsTab')</script>

</form>
</body >
</html>

