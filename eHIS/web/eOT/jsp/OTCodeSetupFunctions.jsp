<!DOCTYPE html>
<%@ page import= "java.text.*,java.sql.Types,java.sql.Statement,java.sql.CallableStatement,java.sql.Connection,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");	%>

<html>
<head>

<% String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language=JavaScript src="../../eCommon/js/menu.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<style>
		A:active{ 
			COLOR: white; 
		}
	</style>
	<script>
		var temparr = new Array();
		var count = 0;
		var prev=0;
		var prevcol='ECMENUHIGHERLEVELCOLOR';
		var sec_hdg_cd=new Array();
		var logic_seq_no=new Array();

		function goHomePage(){
				parent.location.href='../../eCommon/jsp/dmenu.jsp';
		}
		
		function chcol(ro)
		{
				document.getElementById("t").rows(prev).cells(0).className=prevcol
			    prevcol=ro.cells(0).className
				ro.cells(0).className="MENUSELECTEDCOLOR"
				prev=ro.rowIndex;
		}

		function callJSPs(val,count_record_role,count_record_admin)
		{
			var specialities_function_name = encodeURIComponent(getLabel("eFM.Specialitys.label","FM"));
			var ordertypeforsepcialities_function_name = encodeURIComponent(getLabel("eOT.OrderTypeForSepcialities.Label","OT"));
			var notetypesforsepcialities_function_name = encodeURIComponent(getLabel("eOT.NoteTypesForSpecialities.Label","OT"));
			var operationcategory_function_name = encodeURIComponent(getLabel("eOT.OperationCategory.Label","OT"));
			var operationsubcategory_function_name = encodeURIComponent(getLabel("eOT.OperationSubCategory.Label","OT"));
			var operationtype_function_name = encodeURIComponent(getLabel("eOT.OperationType.Label","OT"));
			var surgerytype_function_name = encodeURIComponent(getLabel("Common.SurgeryType.label","Common"));
			var operationsprocedures_function_name = encodeURIComponent(getLabel("eOT.OperationsProcedures.Label","OT"));
			var equipments_function_name = encodeURIComponent(getLabel("eOT.Equipments.Label","OT"));
			var instrumentscssdpacks_function_name = encodeURIComponent(getLabel("eOT.InstrumentsCSSDPacks.Label","OT"));
			var setcomponents_function_name = encodeURIComponent(getLabel("eOT.SetComponents.Label","OT"));
			var component_function_name = encodeURIComponent(getLabel("Common.Component.label","common"));
			var consumablepacks_function_name = encodeURIComponent(getLabel("eOT.ConsumablePacks.Label","OT"));
			var surgicalaccessories_function_name = encodeURIComponent(getLabel("eOT.SurgicalAccessories.Label","OT"));
			var surgeonpreferences_function_name = encodeURIComponent(getLabel("eOT.SurgeonPreferences.Label","OT"));
			var prosthesisimplantstypes_function_name = encodeURIComponent(getLabel("eOT.ProsthesisImplantsTypes.Label","OT"));
			var prosthesisimplantscategories_function_name = encodeURIComponent(getLabel("eOT.ProsthesisImplantsCategories.Label","OT"));
			var prosthesisimplants_function_name = encodeURIComponent(getLabel("eOT.ProsthesisImplants.Label","OT"));
			var checklist_function_name = encodeURIComponent(getLabel("eOT.Checklist.Label","OT"));
			var checklistitem_function_name = encodeURIComponent(getLabel("eOT.ChecklistItem.Label","OT"));
			var listitem_function_name = encodeURIComponent(getLabel("Common.ListItem.label","common"));
			var swabandinstrumentcount_function_name = encodeURIComponent(getLabel("eOT.SwabCountTemplate.Label","OT"));
			var templateitems_function_name = encodeURIComponent(getLabel("eOT.TemplateItems.Label","OT"));
			var patientposition_function_name = encodeURIComponent(getLabel("Common.PatientPosition.label","Common"));
			var woundtype_function_name = encodeURIComponent(getLabel("eOT.WoundType.Label","OT"));
			var unusualoccurrence_function_name = encodeURIComponent(getLabel("eOT.UnusualOccurrence.Label","OT"));
			var organdisposal_function_name = encodeURIComponent(getLabel("eOT.OrganDisposal.Label","OT"));
			var blockslotsbyspeciality_function_name = encodeURIComponent(getLabel("eOT.BlockSlotsBySpeciality.Label","OT"));
			var blockslotsbyagegroup_function_name = encodeURIComponent(getLabel("eOT.BlockSlotsByAgeGroup.Label","OT"));
			var diaryscheduleforsurgeon_function_name = encodeURIComponent(getLabel("eOT.DiaryScheduleforSurgeon.Label","OT"));
			var diaryschedulefortheatre_function_name = encodeURIComponent(getLabel("eOT.DiaryScheduleforTheatre.Label","OT")); // newly added by rajesh.
			var premorbidstatus_function_name = encodeURIComponent(getLabel("eOT.PreMorbidStatus.Label","OT"));
			var reasons_function_name = encodeURIComponent(getLabel("eAE.Reasons.label","AE"));
			var actiontypesforeason_function_name = encodeURIComponent(getLabel("eOT.ActionTypesForReason.Label","OT"));
			var preoperativeindicator_function_name = encodeURIComponent(getLabel("eOT.PreOperativeIndicator.Label","OT"));
			/*var discretemeasure_function_name = encodeURIComponent(getLabel("Common.DiscreteMeasure.label","common"));*/
			var drugsfornotification_function_name = encodeURIComponent(getLabel("eOT.DrugsForNotification.Label","OT"));

			var formObj = document.forms[0];
			var ca_module_yn = formObj.ca_module_yn.value;			
			/*
					Access is in the order - Common.operation.label
					insertaccess,updateaccess,queryaccess,deleteaccess,printaccess
			*/
	
			  if(val == 'Specialities'){
				parent.frames[1].location.href = '../../eOT/jsp/SpecialitiesFrame.jsp?module_id=OT&function_id=Specialities&function_name='+specialities_function_name+'&function_type=F&access=YYYNN';
			}
			
			if(val == 'OrderTypesForSpeciality'){
				if(ca_module_yn=="N"){
					alert(getMessage("CA_NOT_INSTALLED","Common"));
				}else{
					parent.frames[1].location.href = '../../eOT/jsp/OrderTypesForSpeciality.jsp?module_id=OT&function_id=OrderTypesForSpeciality&function_name='+ordertypeforsepcialities_function_name+'&function_type=F&access=YYYNN';
				}
			}
			
			if(val == 'NoteTypesforSepcialities'){
				if(ca_module_yn=="N"){
					alert(getMessage("CA_NOT_INSTALLED","Common"));
				}else{
					parent.frames[1].location.href = '../../eOT/jsp/NoteTypeForSpecialities.jsp?module_id=OT&function_id=NoteTypesforSepcialities&function_name='+notetypesforsepcialities_function_name+  '&function_type=F&access=YYYNN';
				}
			}
			
			if(val == 'OperationCategories'){
				parent.frames[1].location.href = '../../eOT/jsp/OperationCategories.jsp?module_id=OT&function_id=OperationCategories&function_name='+operationcategory_function_name+'&function_type=F&access=YYYNN';
			}
			if(val == 'OperationSubCategories'){
				parent.frames[1].location.href = '../../eOT/jsp/OperationSubCategories.jsp?module_id=OT&function_id=OperationSubCategories&function_name='+operationsubcategory_function_name+'&function_type=F&access=YYYNN';
			}
			if(val == 'OperationTypes'){
				parent.frames[1].location.href = '../../eOT/jsp/OperationTypes.jsp?module_id=OT&function_id=OperationTypes&function_name='+operationtype_function_name+'&function_type=F&access=YYYNN';
			}
			if(val == 'SurgeryTypes'){
				parent.frames[1].location.href = '../../eOT/jsp/SurgeryTypes.jsp?module_id=OT&function_id=SurgeryTypes&function_name='+surgerytype_function_name+'&function_type=F&access=YYYNN';
			}
			if(val == 'OperationsProcedures'){
				parent.frames[1].location.href = '../../eOT/jsp/OperationsProcedures.jsp?module_id=OT&function_id=OperationsProcedures&function_name='+operationsprocedures_function_name+'&function_type=F&access=YYYNN';
			}
			if(val == 'Equipments'){
				parent.frames[1].location.href = '../../eOT/jsp/Equipments.jsp?module_id=OT&function_id=Equipments&function_name='+equipments_function_name+'&function_type=F&access=YYYNN';
			}
			if(val == 'InstrumentsCSSDPacks'){
				if(ca_module_yn=="N"){
					alert(getMessage("CA_NOT_INSTALLED","Common"));
				}else{
					parent.frames[1].location.href = '../../eOT/jsp/Instruments.jsp?module_id=OT&function_id=InstrumentsCSSDPacks&function_name='+instrumentscssdpacks_function_name+'&function_type=F&access=YYYNN';
				}
			}
			if(val == 'SetComponents'){
				if(ca_module_yn=="N"){
					alert(getMessage("CA_NOT_INSTALLED","Common"));
				}else{
					parent.frames[1].location.href = '../../eOT/jsp/SetComponentsFrame.jsp?module_id=OT&function_id=SetComponents&function_name='+setcomponents_function_name+'&function_type=F&access=YYYNN';
				}
			}
			
			if(val == 'Components'){
				parent.frames[1].location.href = '../../eOT/jsp/Components.jsp?module_id=OT&function_id=Components&function_name='+component_function_name+'&function_type=F&access=YYYNN';
			}
			if(val == 'SurgicalAccessories'){
				parent.frames[1].location.href = '../../eOT/jsp/SurgicalAccessoriesFrame.jsp?module_id=OT&function_id=SurgicalAccessories&function_name='+surgicalaccessories_function_name+'&function_type=F&access=YYYNN';
			}
			/*
			if(val == 'SurgeonPreferences'){
				parent.frames[1].location.href = '../../eOT/jsp/SurgeonPreferencesFrame.jsp?module_id=OT&function_id=SurgeonPreferences&function_name='+surgeonpreferences_function_name+'&function_type=F&access=YYYNN';
			}	
			*/
			if(val == 'ProsthesisType'){
				parent.frames[1].location.href = '../../eOT/jsp/ProsthesisType.jsp?module_id=OT&function_id=ProsthesisType&function_name='+prosthesisimplantstypes_function_name+'&function_type=F&access=YYYNN';
			}
			if(val == 'ProsthesisCategory'){
				parent.frames[1].location.href = '../../eOT/jsp/ProsthesisCategory.jsp?module_id=OT&function_id=ProsthesisCategory&function_name='+prosthesisimplantscategories_function_name+'&function_type=F&access=YYYNN';
			}
			
			if(val == 'ProsthesisImplants'){
				parent.frames[1].location.href = '../../eOT/jsp/Implants.jsp?module_id=OT&function_id=ProsthesisImplants&function_name='+prosthesisimplants_function_name+'&function_type=F&access=YYYNN';
			}
			if(val == 'ConsumablePacks'){
				if(ca_module_yn=="N"){
					alert(getMessage("CA_NOT_INSTALLED","Common"));
				}else{
					parent.frames[1].location.href = '../../eOT/jsp/ConsumablePackFrame.jsp?module_id=OT&function_id=ConsumablePacks&function_name='+consumablepacks_function_name+'&function_type=F&access=YYYNN';
				}
			}

			if(val == 'Checklists'){
				parent.frames[1].location.href = '../../eOT/jsp/ChecklistsFrame.jsp?module_id=OT&function_id=Checklists&function_name='+checklist_function_name+'&function_type=F&access=YYYNN';
			}
			if(val == 'ChecklistItems'){
				parent.frames[1].location.href = '../../eOT/jsp/ChecklistItems.jsp?module_id=OT&function_id=ChecklistItems&function_name='+checklistitem_function_name+'&function_type=F&access=YYYNN';
			}
			if(val == 'ListItems'){
				parent.frames[1].location.href = '../../eOT/jsp/ListItemsFrame.jsp?module_id=OT&function_id=ListItems&function_name='+listitem_function_name+'&function_type=F&access=YYYNN';
			}
			if(val == 'SwabandInstrumentsTemplate'){
				parent.frames[1].location.href = '../../eOT/jsp/SwabAndInstrumentsTemplateFrame.jsp?module_id=OT&function_id=SwabandInstrumentsTemplate&function_name='+swabandinstrumentcount_function_name+'&function_type=F&access=YYYNN';
			}

			if(val == 'TemplateItems'){
				parent.frames[1].location.href = '../../eOT/jsp/TemplateItems.jsp?module_id=OT&function_id=TemplateItems&function_name='+templateitems_function_name+'&function_type=F&access=YYYNN';
			}
			
			if(val == 'SurgeonPreferences'){
				parent.frames[1].location.href = '../../eOT/jsp/SurgeonPrefFrame.jsp?module_id=OT&function_id=SurgeonPreferences&function_name='+surgeonpreferences_function_name+'&function_type=F&access=YYYNN';
			}
			

			if(val == 'PatientPositions'){
				parent.frames[1].location.href = '../../eOT/jsp/PatientPositions.jsp?module_id=OT&function_id=PatientPositions&function_name='+patientposition_function_name+'&function_type=F&access=YYYNN';
			}
			if(val == 'WoundTypes'){
				parent.frames[1].location.href = '../../eOT/jsp/WoundTypes.jsp?module_id=OT&function_id=WoundTypes&function_name='+woundtype_function_name+'&function_type=F&access=YYYNN';
			}
			if(val == 'UnusualOccurences'){
				parent.frames[1].location.href = '../../eOT/jsp/UnusualOccurences.jsp?module_id=OT&function_id=UnusualOccurences&function_name='+unusualoccurrence_function_name+'&function_type=F&access=YYYNN';
			}
			if(val == 'OrganDisposal'){
				parent.frames[1].location.href = '../../eOT/jsp/OrganDisposal.jsp?module_id=OT&function_id=OrganDisposal&function_name='+organdisposal_function_name+'&function_type=F&access=YYYNN';
			}

			if(val == 'BlockSlotsbySpeciality'){
				parent.frames[1].location.href = '../../eOT/jsp/BlockSlotsBySpecialityFrame.jsp?module_id=OT&function_id=BlockSlotsbySpeciality&function_name='+blockslotsbyspeciality_function_name+'&function_type=F&access=YYYNN';
			}
			/* Commented by bshankar. This shall be taken care alongwith the corresponding transactions.
			if(val == 'BlockSlotsbyAgeGroup'){
				parent.frames[1].location.href = '../../eOT/jsp/BlockSlotsByAgeGroupFrame.jsp?module_id=OT&function_id=BlockSlotsbyAgeGroup&function_name='+blockslotsbyagegroup_function_name+'&function_type=F&access=YYYNN';
			}
			*/
			if(val == 'DiaryScheduleforSurgeon'){
				//parent.frames[1].location.href = '../../eOT/jsp/DiaryScheduleForSurgeon.jsp?module_id=OT&function_id=DiaryScheduleforSurgeon&function_name=Diary Schedule for Surgeon&function_type=F&access=YYYNN';
				
				parent.frames[1].location.href = '../../eOT/jsp/DiaryScheduleForSurgeon.jsp?module_id=OT&function_id=DiaryScheduleforSurgeon&function_name='+diaryscheduleforsurgeon_function_name+'&function_type=F&access=YYYNN';
			}

		// Newly Added by rajesh on 19/10
			if(val == 'DiaryScheduleforTheatre'){
				//parent.frames[1].location.href = '../../eOT/jsp/DiaryScheduleForSurgeon.jsp?module_id=OT&function_id=DiaryScheduleforSurgeon&function_name=Diary Schedule for Surgeon&function_type=F&access=YYYNN';
				
				parent.frames[1].location.href = '../../eOT/jsp/DiaryScheduleForSurgeon.jsp?module_id=OT&function_id=DiaryScheduleforSurgeon&function_name='+diaryschedulefortheatre_function_name+'&function_type=F&access=YYYNN';
			}

			if(val == 'PreMorbidStatus'){
				parent.frames[1].location.href = '../../eOT/jsp/PreMorbidStatus.jsp?module_id=OT&function_id=PreMorbidStatus&function_name='+premorbidstatus_function_name+'&function_type=F&access=YYYNN';
			}
			if(val == 'Reasons'){
				parent.frames[1].location.href = '../../eOT/jsp/Reasons.jsp?module_id=OT&function_id=Reasons&function_name='+reasons_function_name+'&function_type=F&access=YYYNN';
			}
			if(val == 'ActionTypesForReason'){
				parent.frames[1].location.href = '../../eOT/jsp/ActionTypesForReason.jsp?module_id=OT&function_id=ActionTypesForReason&function_name='+actiontypesforeason_function_name+'&function_type=F&access=YYYNN';
			}

			/*if(val == 'DiscreteMeasure'){
				parent.frames[1].location.href = '../../eOT/jsp/PreOpIndicator.jsp?module_id=OT&function_id=DiscreteMeasure&function_name='+preoperativeindicator_function_name+'&function_type=F&access=YYYNN';
			}*/
			if(val == 'PreOpIndicator'){
				parent.frames[1].location.href = '../../eOT/jsp/PreOpIndicator.jsp?module_id=OT&function_id=PreOpIndicator&function_name='+preoperativeindicator_function_name+'&function_type=F&access=YYYNN';
			}
		
			if(val == 'DrugsforNotification'){
				if(ca_module_yn=="N"){
					alert(getMessage("CA_NOT_INSTALLED","Common"));
				}else{
					parent.frames[1].location.href = '../../eOT/jsp/DrugNotification.jsp?module_id=OT&function_id=DrugsforNotification&function_name='+drugsfornotification_function_name+'&function_type=F&access=YYYNN';
				}
			}		
		
			
	}
	
	async function showFunctionality(){
		var retVal = new Array(); 

		var features	= 'dialogHeight:33; dialogWidth:15;dialogLeft:2;dialogTop:60;status=no;scroll=no;title=no;fullscreen=1';  
		var arguments	= '' ;  
		
		var vals = parent.parent.header.document.header_form.menu_values.value;
		MPMasterMenu_form.menu_values.value = vals;
 		
		arguments = vals

		//retVal = window.showModalDialog('change_functionality.jsp',arguments,features);
		
		retVal	= await window.showModalDialog('change_functionality.jsp',arguments,features);


		if(retVal != null)
		{
			//alert(retVal)
			retVal = retVal.replace("location","parent.parent.frames[1].location")
			eval(retVal)
		}
	}
	function refreshPage()
		{
			parent.frames[0].location.href='../../eOT/jsp/OTCodeSetupFunctions.jsp?expand='+expand
		}
	function chkRow( ro,val,exp )
		{
			var O =expand.charAt(0)
			var P =expand.charAt(1)
			var C =expand.charAt(2)			
			var S =expand.charAt(3)			
			var OR =expand.charAt(4)
			var B =expand.charAt(5)			
			var A =expand.charAt(6)
			var OT =expand.charAt(7)
			if( val == "O" )
			{
				if( exp =="E")
					O = "C";
				else
					O = "E";
			}
			
			if( val == "P"  )
			{
				 if( exp =="E" )
					P= "C"
				else
					P = "E";
			}
			if( val == "C" )
			{
				if(exp =="E" )
					C="C";
				else
					C ="E"
			}
			if( val == "S" )
			{
				if(exp =="E" )
					S="C";
				else
					S ="E"
			}
			if( val == "OR")
			{
				if(exp =="E" )
					OR ="C"
				else
					OR ="E"
			}
			if( val == "B")
			{
				if(exp =="E" )
					B ="C"
				else
					B ="E"
			}
			if( val == "A")
			{
				if(exp =="E" )
					A ="C"
				else
					A ="E"
			}
			if( val == "OT" )
			{
				if( exp =="E")
					OT = "C";
				else
					OT = "E";
			}
		
			expand = O+ P + C + S + OR + B + A + OT;
			parent.frames[1].location.href = '../../eCommon/html/blank.html'
		}

	</script>

	</head>
<% 
	String expand=request.getParameter("expand");
	if( expand == null) 
		expand="CCCCCCCC";
	
	String facility_id  = (String) session.getValue("facility_id");
	String responsibility_id= (String) session.getValue("responsibility_id");
	String Log_user= (String)session.getValue("login_user");
	Connection con=null;
	ResultSet rs=null;
	Statement stmt=null;
	CallableStatement cstmt = null;
	String modules_list = "";
	String ca_module_yn="";
	String menu_change_flag="";

	int count_record_role=0;
	int count_record_admin=0;
	try{
		con = ConnectionManager.getConnection(request);
		stmt=con.createStatement();
		String sqlRole ="select count(1) from sm_resp  where ora_role_id='MEDADMIN' and resp_id='"+responsibility_id+"' ";
		rs=stmt.executeQuery(sqlRole);
		if (rs !=null){
			while (rs.next()){
				count_record_role=rs.getInt(1);					
			}
		}	
		String sql_admin="select count(1) from sm_menu_admin where menu_admin_id='"+Log_user+"' and to_char(sysdate,'dd/mm/yyyy')>= nvl(to_char(eff_date_from,'dd/mm/yyyy'),sysdate-1) and to_char(sysdate,'dd/mm/yyyy')<=nvl(to_char(eff_date_to,'dd/mm/yyyy'),sysdate+1) ";	
		rs=stmt.executeQuery(sql_admin);
		if (rs !=null){
			while (rs.next()){
				count_record_admin=rs.getInt(1);	
			}
		}
	// Code Included by rajesh for Changing the menu name  on 19/10 from DairyScvForSurgeon to DairyScheduleForTheatre.,
	String surgeon_yn="select DIARY_SCHED_FOR_SURG_REQD_YN from ot_param_for_facility where OPERATING_FACILITY_ID='"+facility_id+"'";

	rs=stmt.executeQuery(surgeon_yn);
	if (rs !=null){
		while (rs.next()){
			menu_change_flag=rs.getString(1);	
		}
	}
	
	// Check for CA Module Existence
		cstmt=con.prepareCall("{call GET_OPERATIONAL_MODULES(?,?)}");
		cstmt.setString(1,facility_id);
		cstmt.registerOutParameter(2,Types.VARCHAR);
		cstmt.execute();
		modules_list=cstmt.getString(2);
		if(modules_list.indexOf("OR|")>=0)
			ca_module_yn="Y";	// When CA is  Operational
		else
			ca_module_yn="N";	// When CA is not Operational
	}catch(Exception e){
		e.printStackTrace();
		//out.println(e);
	}finally { 
		if(cstmt !=null) cstmt.close();
		if(stmt !=null) stmt.close();
		if(rs !=null) rs.close();
		ConnectionManager.returnConnection(con,request);
	}

%>

	<body style="background-color:dimgray;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	<form name="OTCodeMasterMenu_form" id="OTCodeMasterMenu_form">
	<input type="hidden" name='menu_values' id='menu_values'>
	<input type="hidden" name='ca_module_yn' id='ca_module_yn' value="<%=ca_module_yn%>">
	
	<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>
        <tr onclick = "chkRow(this,'O','<%=expand.charAt(0) %>')">
			<% if(expand.charAt(0) == 'E') {%>
			<td  class='ECMENUHIGHERLEVELCOLOR'><a  href=javascript:refreshPage() style='color:white;' >
				-<fmt:message key="Common.operation.label" bundle="${common_labels}"/>
			</td>
			<% } else { %>
			<td  class='ECMENUHIGHERLEVELCOLOR'><a  href=javascript:refreshPage() style='color:white;'  >
				+<fmt:message key="Common.operation.label" bundle="${common_labels}"/> 
			</td>
			<% } %>
		</tr>
		<% if(expand.charAt(0) == 'E') {%>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Specialities')">
				<fmt:message key="eFM.Specialitys.label" bundle="${fm_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('OrderTypesForSpeciality')"><fmt:message key="eOT.OrderTypeForSepcialities.Label" bundle="${ot_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('NoteTypesforSepcialities')">
				<fmt:message key="eOT.NoteTypesForSpecialities.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('OperationCategories')">
				<fmt:message key="eOT.OperationCategory.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('OperationSubCategories')">
				<fmt:message key="eOT.OperationSubCategory.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('OperationTypes')">
				<fmt:message key="eOT.OperationType.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SurgeryTypes')">
				<fmt:message key="Common.SurgeryType.label" bundle="${common_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('OperationsProcedures')">
				<fmt:message key="eOT.OperationsProcedures.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Equipments')">
				<fmt:message key="eOT.Equipments.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('InstrumentsCSSDPacks')">
				<fmt:message key="eOT.InstrumentsCSSDPacks.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SetComponents')">
				<fmt:message key="eOT.SetComponents.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Components')">
				<fmt:message key="Common.Component.label" bundle="${common_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ConsumablePacks',<%=count_record_role%>,<%=count_record_admin%>)">
				<fmt:message key="eOT.ConsumablePacks.Label" bundle="${ot_labels}"/>
			</td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SurgicalAccessories')">
				<fmt:message key="eOT.SurgicalAccessories.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SurgeonPreferences')">
				<fmt:message key="eOT.SurgeonPreferences.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		
		<%}%>
		<tr onclick = "chkRow(this,'P','<%=expand.charAt(1) %>')">
			<% if(expand.charAt(1) == 'E') {%>
			<td  class='ECMENUHIGHERLEVELCOLOR'><a  href=javascript:refreshPage() style='color:white;' >
				-<fmt:message key="eOT.ProsthesisImplants.Label" bundle="${ot_labels}"/>
			</td>
			<% } else { %>
			<td  class='ECMENUHIGHERLEVELCOLOR'><a  href=javascript:refreshPage() style='color:white;'  >
				+<fmt:message key="eOT.ProsthesisImplants.Label" bundle="${ot_labels}"/>
			</td>
			<% } %>
		</tr>
		<% if(expand.charAt(1) == 'E') {%>
        <tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ProsthesisType')">
				<fmt:message key="eOT.ProsthesisImplantsTypes.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ProsthesisCategory')">
				<fmt:message key="eOT.ProsthesisImplantsCategories.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ProsthesisImplants')">
				<fmt:message key="eOT.ProsthesisImplants.Label" bundle="${ot_labels}"/>
			</td>
		</tr>

		<%}%>
		<tr onClick= "chkRow(this,'C','<%=expand.charAt(2) %>')">
			<% if(expand.charAt(2) == 'E') {%>
			<td  class='ECMENUHIGHERLEVELCOLOR'><a  href=javascript:refreshPage() style='color:white;' >
				-<fmt:message key="eOT.Checklists.Label" bundle="${ot_labels}"/>
			</td>
			<% } else { %>
			<td  class='ECMENUHIGHERLEVELCOLOR'><a  href=javascript:refreshPage() style='color:white;'  >
				+<fmt:message key="eOT.Checklists.Label" bundle="${ot_labels}"/>
			</td>
			<% } %>
        </tr>
		<% if(expand.charAt(2) == 'E') {%>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Checklists')">
				<fmt:message key="eOT.Checklist.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ChecklistItems')">
				<fmt:message key="eOT.ChecklistItem.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ListItems')"><fmt:message key="Common.ListItem.label" bundle="${common_labels}"/></td>
		</tr>
		<%}%>
		<tr onClick= "chkRow(this,'S','<%=expand.charAt(3) %>')">
			<% if(expand.charAt(3) == 'E') {%>
			<td  class='ECMENUHIGHERLEVELCOLOR'><a  href=javascript:refreshPage() style='color:white;' >
				-<fmt:message key="eOT.SwabCount.Label" bundle="${ot_labels}"/>
			</td>
			<% } else { %>
			<td  class='ECMENUHIGHERLEVELCOLOR'><a  href=javascript:refreshPage() style='color:white;'  >
				+<fmt:message key="eOT.SwabCount.Label" bundle="${ot_labels}"/>
			</td>
			<% } %>
		</tr>
		<% if(expand.charAt(3) == 'E') {%>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SwabandInstrumentsTemplate')">
				<fmt:message key="eOT.SwabCountTemplate.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('TemplateItems')">
				<fmt:message key="eOT.TemplateItems.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<!--
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SurgeonPreferences')"><fmt:message key="eOT.SurgeonPreferences.Label" bundle="${ot_labels}"/></td>
		</tr> -->
		<%}%>
		<tr onClick= "chkRow(this,'OR','<%=expand.charAt(4) %>')">
			<% if(expand.charAt(4) == 'E') {%>
			<td  class='ECMENUHIGHERLEVELCOLOR'><a  href=javascript:refreshPage() style='color:white;' >
				-<fmt:message key="eOT.OperativeRecords.Label" bundle="${ot_labels}"/>
			</td>
			<% } else { %>
			<td  class='ECMENUHIGHERLEVELCOLOR'><a  href=javascript:refreshPage() style='color:white;' >
				+<fmt:message key="eOT.OperativeRecords.Label" bundle="${ot_labels}"/>
			</td>
			<% } %>
		</tr>
		<% if(expand.charAt(4) == 'E') {%>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PatientPositions')">
				<fmt:message key="Common.PatientPosition.label" bundle="${common_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('WoundTypes')">
				<fmt:message key="eOT.WoundType.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('UnusualOccurences')">
				<fmt:message key="eOT.UnusualOccurrence.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('OrganDisposal')">
				<fmt:message key="eOT.OrganDisposal.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<%}%>
		<tr onClick= "chkRow(this,'B','<%=expand.charAt(5) %>')">
			<% if(expand.charAt(5) == 'E') {%>
			<td  class='ECMENUHIGHERLEVELCOLOR'><a  href=javascript:refreshPage() style='color:white;' >
				-<fmt:message key="eIP.Bookings.label" bundle="${ip_labels}"/>
			</td>
			<% } else { %>
			<td  class='ECMENUHIGHERLEVELCOLOR'><a  href=javascript:refreshPage() style='color:white;'>
				+<fmt:message key="eIP.Bookings.label" bundle="${ip_labels}"/>
			</td>
			<% } %>
		</tr>
		<% if(expand.charAt(5) == 'E') {%>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('BlockSlotsbySpeciality')">
				<fmt:message key="eOT.BlockSlotsBySpeciality.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<!-- Commented by bshankar. This shall be taken care alongwith the corresponding transactions.

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('BlockSlotsbyAgeGroup')">
				<fmt:message key="eOT.BlockSlotsByAgeGroup.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		-->
		<!-- Code added by rajesh for change the menu accorfding to the Dairy Schedule foe surgeon Reqd..., on 19/10  -->
		<%
		if(menu_change_flag.equals("Y")){
		%>
			<tr onclick='chcol(this)'>
				<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('DiaryScheduleforSurgeon')">
					<fmt:message key="eOT.DiaryScheduleforSurgeon.Label" bundle="${ot_labels}"/>
				</td>
			</tr>
		<%}else{%>
			<tr onclick='chcol(this)'>
				<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('DiaryScheduleforTheatre')">
					<fmt:message key="eOT.DiaryScheduleforTheatre.Label" bundle="${ot_labels}"/>
				</td>
			</tr>
		<%}%>
		<%}%>		
		<tr onclick="chkRow(this,'A','<%=expand.charAt(6)%>')">
			<% if(expand.charAt(6) == 'E') {%>
            <td class='ECMENUHIGHERLEVELCOLOR' ><a href=javascript:refreshPage() style='color:white;'>
				-<fmt:message key="Common.Anaesthesia.label" bundle="${common_labels}"/>
			</td>
			<% } else {%>
			<td class='ECMENUHIGHERLEVELCOLOR' ><a href=javascript:refreshPage() style='color:white;'>
				+<fmt:message key="Common.Anaesthesia.label" bundle="${common_labels}"/>
			</td>
			<%}%>
        </tr>
		<% if(expand.charAt(6) == 'E') {%>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PreMorbidStatus')">
				<fmt:message key="eOT.PreMorbidStatus.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<%}%>
		
		<tr onclick="chkRow(this,'OT','<%=expand.charAt(7)%>')">
		   <% if(expand.charAt(7) == 'E') {%>
            <td class='ECMENUHIGHERLEVELCOLOR' ><a href=javascript:refreshPage() style='color:white;'>
				-<fmt:message key="Common.others.label" bundle="${common_labels}"/>
			</td>
			<%} else {%>
            <td class='ECMENUHIGHERLEVELCOLOR' ><a href=javascript:refreshPage() style='color:white;'>
				+<fmt:message key="Common.others.label" bundle="${common_labels}"/>
			</td>

			<%}%>
        </tr>
	    <% if(expand.charAt(7) == 'E') {%>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Reasons')">
				<fmt:message key="eAE.Reasons.label" bundle="${ae_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ActionTypesForReason',<%=count_record_role%>,<%=count_record_admin%>)">
				<fmt:message key="eOT.ActionTypesForReason.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<!--<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('DiscreteMeasure',<%=count_record_role%>,<%=count_record_admin%>)">
				<fmt:message key="Common.DiscreteMeasure.label" bundle="${common_labels}"/>
			</td>
		</tr>-->
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PreOpIndicator')">
					<fmt:message key="eOT.PreOperativeIndicator.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('DrugsforNotification',<%=count_record_role%>,<%=count_record_admin%>)">
				<fmt:message key="eOT.DrugsForNotification.Label" bundle="${ot_labels}"/>
			</td>
		</tr>
		<%}
		
			out.println( "<script>expand='"+ expand +"'</script>" );
		%>
		
		<tr>
			<td class='ECMENUHIGHERLEVELCOLOR' ><a href=javascript:goHomePage() style='color:white;'><b>
				<fmt:message key="Common.menu.label" bundle="${common_labels}"/></b></a>
			</td>
		</tr>
	
	</table>

	</body>
	</form>
</html>

