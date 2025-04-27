<!DOCTYPE html>
<%@page  import ="java.util.HashMap,eOT.SetUpParamForFacilityBean" contentType="text/html;charset=UTF-8" %>
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,eOT.OTBillingBean,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean,eOT.*"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale = (String) session.getAttribute("LOCALE");
request.setCharacterEncoding("UTF-8");
%>

<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
	<script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<script language='javascript' src='../../eOT/js/SetUpParameterForFacility.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%!
public String checkForNull(String str){
    return (  str!=null && str.intern()!="null" )?str.trim():"";
}
%>

<% 

	String facility_id = (String) session.getAttribute("facility_id");
	String bean_id = "SetUpParamForFacilityBean";
	String bean_name = "eOT.SetUpParamForFacilityBean";
	SetUpParamForFacilityBean bean = (SetUpParamForFacilityBean) mh.getBeanObject( bean_id, request, bean_name );
	String empty = "".intern();
	String billing_sub_services = "";
	String admin_func_charging_un= empty;
	String holding_area_bill_yn= empty;
	String operating_room_bill_yn= empty;
	String recovery_room_bill_yn= empty;
	String holding_area= empty;
	String operating_room= empty;
	String recovry_room= empty;
	String oper_proc_fin_stg= empty;
	String pros_srgn_notes_yn= empty;
	String pros_nursing_notes_yn= empty;
	String pros_admin_yn= empty;
	String pros_imp_val= empty;
	String equip_nursing_notes_yn= empty;
	String equip_admin_yn= empty;
	String equip_val= empty;
	String cssd_nursing_notes_yn= empty;
	String cssd_admin_yn= empty;
	String instr_cssd_val= empty;
	String cons_nursing_notes_yn= empty;
	String cons_admin_yn = empty;
	String consumable_pack_val = empty; 
	String charges_appl_checkin_yn = empty; //047105
	String Include_fpp = empty;//Added against ML-MMOH-CRF-1939-US1
	String	tab_id="BillingSetup";
	String  mode=bean.getMode();
	String chargesApplCheckInDateTimeChked = "";
	HashMap map=new HashMap();
	map=(session.getAttribute(tab_id)!=null)?(HashMap)session.getAttribute(tab_id):bean.getQueryDtls(tab_id,facility_id);
//	map=(session.getAttribute(tab_id)!=null)?bean.getQueryDtls(tab_id):bean.getQueryDtls(tab_id);
	String session_facility_id=(String) map.get("facility_id");
	
	//Added Against ML-MMOH-CRF-1939-US1...starts
	String bean_id1 = "OTCommonBean";
	String bean_name1 = "eOT.OTCommonBean";
	OTCommonBean bean1 = (OTCommonBean)mh.getBeanObject( bean_id1, request, bean_name1 );
	boolean isIncludeFpp = false;
	Connection conn = null;
	String sql="";
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	Integer count = 0; 
	try{
	    conn = ConnectionManager.getConnection(request);
	    isIncludeFpp = CommonBean.isSiteSpecific(conn,"OT","OT_FPP");
	    System.err.println("isIncludeFpp --->"+isIncludeFpp);
	   
		
		count = bean1.getFppIcon();
		
	   }catch(Exception e){
			System.err.println(e);		
		}finally{		
			ConnectionManager.returnConnection(conn);
		}	  
			
		//Added Against ML-MMOH-CRF-1939-US1...ends 
	   
	if(!facility_id.equals(session_facility_id)){
		map=bean.getQueryDtls(tab_id,facility_id);
	}
	
	if( ("UPDATE".equals(mode) || "INSERT".equals(mode)) )
	{
		// map=bean.getQueryDtls(tab_id);
		 billing_sub_services = (String) map.get("billing_sub_services");
		 admin_func_charging_un= (String) map.get("admin_func_charging_un");
		 holding_area_bill_yn= (String) map.get("holding_area_bill_yn");
		 operating_room_bill_yn= (String) map.get("operating_room_bill_yn");
		 recovery_room_bill_yn= (String) map.get("recovery_room_bill_yn");
		 holding_area= (String) map.get("holding_area");
		 operating_room= (String) map.get("operating_room");
		 recovry_room= (String) map.get("recovry_room");
		 oper_proc_fin_stg= (String) map.get("oper_proc_fin_stg");
		 pros_srgn_notes_yn= (String) map.get("pros_srgn_notes_yn");
		 pros_nursing_notes_yn= (String) map.get("pros_nursing_notes_yn");
		 pros_admin_yn= (String) map.get("pros_admin_yn");
		 pros_imp_val= (String) map.get("pros_imp_val");
		 equip_nursing_notes_yn= (String) map.get("equip_nursing_notes_yn");
		 //if(ot_slate_no_of_days.equals("")){ot_slate_no_of_days="0";}
		 equip_admin_yn= (String) map.get("equip_admin_yn");
		 equip_val= (String) map.get("equip_val");
		 cssd_nursing_notes_yn= (String) map.get("cssd_nursing_notes_yn");
		 cssd_admin_yn= (String) map.get("cssd_admin_yn");
		 instr_cssd_val= (String) map.get("instr_cssd_val");
		 cons_nursing_notes_yn= (String) map.get("cons_nursing_notes_yn"); 
		 cons_admin_yn= (String) map.get("cons_admin_yn");
		 consumable_pack_val= (String) map.get("consumable_pack_val");
		 charges_appl_checkin_yn = (String) map.get("charges_appl_checkin_yn"); //047105
		 Include_fpp= checkForNull((String) map.get("Include_fpp"));//Added against ML-MMOH-CRF-1939-US1
		 System.err.println("charges_appl_checkin_yn-----s-----"+charges_appl_checkin_yn);
	}
	if(charges_appl_checkin_yn != null && charges_appl_checkin_yn.equalsIgnoreCase("Y"))
		chargesApplCheckInDateTimeChked = "checked";
	String chk_flags = billing_sub_services+"::"+admin_func_charging_un+"::"+holding_area_bill_yn+"::"+operating_room_bill_yn+"::"+recovery_room_bill_yn+"::"+pros_srgn_notes_yn+"::"+pros_nursing_notes_yn+"::"+pros_admin_yn+"::"+equip_nursing_notes_yn+"::"+equip_admin_yn+"::"+cssd_nursing_notes_yn+"::"+cssd_admin_yn+"::"+cons_nursing_notes_yn+"::"+cons_admin_yn+"::"+charges_appl_checkin_yn+"::"+Include_fpp; //047105 Added against ML-MMOH-CRF-1939-US1
	
	String lst_val = holding_area+"@@"+operating_room+"@@"+recovry_room+"@@"+pros_imp_val+"@@"+equip_val+"@@"+instr_cssd_val+"@@"+consumable_pack_val+"@@"+oper_proc_fin_stg;
	
	//String disable_flag = ("Y".equals(ss_module_YN))?"":"disabled";
	//String disable_flag1 = ("Y".equals(st_interface_flag))?"":"disabled";
	 
%>

 <body onLoad = " setBillChkBoxValues('<%=chk_flags%>');setBillingListBoxValues('<%=lst_val%>');removeHoldingArea();removeRecoveryRoom(); assignChkValues();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'> 
<!-- Page formated By yadav -->
<form name="SetUpParameterForFacilityForm" id="SetUpParameterForFacilityForm"  onload='FocusFirstElement();'  target="messageFrame"> 
<table border='0' cellpadding=3  cellspacing='0' width='100%' align='center'>
    <tr>
    <td class="BORDER">
<!-- Border test end -->
	<table border='0' cellpadding=3 cellspacing='0' width='100%' align='center'>
        <tr>
            <td class="COLUMNHEADERCENTER">
                <b><fmt:message key="eOT.OperationServices.Label" bundle="${ot_labels}"/></b>
            </td>
        </tr>

        <tr><td colspan='2'></td></tr>
 
        <tr>
            <td width="100%" class="BORDERX">
                <table border='0' cellpadding=3  cellspacing='0' width='100%'>
                    <tr>
            <td class="label" width='20%'>
                            <fmt:message key="eOT.BillingSubServices.Label" bundle="${ot_labels}"/>
						</td>
						<td>
						    <input type='checkbox' name='billing_sub_services' id='billing_sub_services' value='<%=billing_sub_services%>' onClick="setChkBoxValue(this); checkPanelService();">
                        </td>
						<!--Added against ML-MMOH-CRF-1939-US1...starts-->
						<%
						if(isIncludeFpp ){
							  if(count ==1){
						%>
						<td class="label" width='20%'>
                            <fmt:message key="eOT.IncludeFpp.Label" bundle="${ot_labels}"/>
						</td>
						<td>
						    <input type='checkbox' name='Include_fpp' id='Include_fpp' value='<%=Include_fpp%>' onClick="setChkBoxValue(this);"><!--Added By Gaurav Against ML-MMOH-SCF-2511-->
                        </td>
						<%
						}else{
						%>
						<td class="label" width='20%'>
                            <fmt:message key="eOT.IncludeFpp.Label" bundle="${ot_labels}"/>
						</td>
						<td>
						    <input type='checkbox' name='Include_fpp' id='Include_fpp' value='' onClick="setChkBoxValue(this);" disabled ><!--Added By Gaurav Against ML-MMOH-SCF-2511-->
                        </td>
						<%
						    }
						}
						%>
						<!--Added against ML-MMOH-CRF-1939-US1...ends-->
						<td class="label" width='30%'>
                            <fmt:message key="eOT.AdminFunctionforCharging.Label" bundle="${ot_labels}"/>
						</td>
						<td>
						    <input type='checkbox' name='admin_func_charging_un' id='admin_func_charging_un' value='<%=admin_func_charging_un%>' onclick="removeHoldingArea(); removeOperRoom(); removeRecoveryRoom(); removeProsImpAdminFunction(); removeEquipAdminFunction(); removeInstrCssdAdminFunction(); removeConsPackAdminFunction();setChkBoxValue(this); assignChkValues();" >
                        </td>
					</tr>
        </tr>

</table>
   <tr>
    <td class="BORDER">
<!-- Border test end -->
	<table border='0' cellpadding=3 cellspacing='0' width='100%' align='center'>
        <tr>
            <td class="COLUMNHEADERCENTER">
                <b><fmt:message key="eOT.RoomServiceUsage.Label" bundle="${ot_labels}"/></b>
            </td>
        </tr>

        <tr><td colspan='2'></td></tr>
 
        <tr>
            <td width="100%" class="BORDERX">
                <table border='0' cellpadding=3  cellspacing='0' width='100%'>
                    <tr>
					<td class="label" width='20%'>
                            <fmt:message key="eOT.BillHoldingAreaUsage?.Label" bundle="${ot_labels}"/>
						</td>
						<td>
						    <input type='checkbox' name='holding_area_bill_yn' id='holding_area_bill_yn' value='<%=holding_area_bill_yn%>' onclick="checkEnaDisHoldingArea();">
                        </td>
					
						<td class="label" width='20%'>
                            <fmt:message key="eOT.BillOperatingRoomUsage?.Label" bundle="${ot_labels}"/>
						</td>
						<td>
						    <input type='checkbox' name='operating_room_bill_yn' id='operating_room_bill_yn' value='<%=operating_room_bill_yn%>' onclick="checkEnaOperRoom();">
                        </td>
					</tr>
					<tr>
						<td class="label" width='20%'><fmt:message key="eOT.BillRecoveryRoomUsage?.Label" bundle="${ot_labels}"/></td>
						<td>
							<input type='checkbox' name='recovery_room_bill_yn' id='recovery_room_bill_yn' value='<%=recovery_room_bill_yn%>' onclick="checkEnaRecoveryRoom();">
						</td>
						<!-- 047105 start -->
						<td class="label" width='20%'><fmt:message key="eOT.ChargesApplCheckinDateTime.label" bundle="${ot_labels}"/></td>
						<td>
							<input type='checkbox' name='charges_appl_checkin_yn' id='charges_appl_checkin_yn' <%=chargesApplCheckInDateTimeChked%> value='<%=charges_appl_checkin_yn%>' onClick="setChkBoxValue(this);">
                        </td>
						<!-- 047105 end -->
					</tr>
	</table>
     </tr>
   <tr>
    <td class="BORDER">
<!-- Border test end -->
	<table border='0' cellpadding=3 cellspacing='0' width='100%' align='center'>
        <tr >
            <td class="COLUMNHEADERCENTER">
                <fmt:message key="eOT.BillFinalizationStages.Label" bundle="${ot_labels}"/>
            </td>
        </tr>

        <tr><td colspan='2'></td></tr>
 
        <tr>
            <td width="100%" class="BORDERX">
                <table border='0' cellpadding=3  cellspacing='0' width='100%'>
                    <tr>
					<td class="label" width='20%'>
                            <fmt:message key="eOT.HoldingArea.Label" bundle="${ot_labels}"/>
						</td>
						<td>
	                  	 <select name='holding_area' id='holding_area' >
						<option value='H' selected>
						<fmt:message key="eOT.DuringChecking-OutIndividualRooms.Label" bundle="${ot_labels}"/>
						</option>
						<option value='A'>
							<fmt:message key="eOT.BeforeCheck-out/DocumentationCompletition.Label" bundle="${ot_labels}"/>
						</option>
					</select>
                        </td>
					
						<td class="label" width='20%'>
                            <fmt:message key="Common.OperatingRoom.label" bundle="${common_labels}"/>
						</td>
						<td>
						<select name='operating_room' id='operating_room' >
						<option value='O' selected>
							<fmt:message key="eOT.DuringChecking-OutIndividualRooms.Label" bundle="${ot_labels}"/>
						</option>
						<option value='A'>
							<fmt:message key="eOT.BeforeCheck-out/DocumentationCompletition.Label" bundle="${ot_labels}"/></option>
					</select>
                        </td>
					</tr>

					<tr>
					<td class="label" width='20%'>
                            <fmt:message key="eOT.RecoveryRoom.Label" bundle="${ot_labels}"/>
						</td>
						<td>
						    <select name='recovry_room' id='recovry_room' >
						<option value='R' selected>
							<fmt:message key="eOT.DuringChecking-OutIndividualRooms.Label" bundle="${ot_labels}"/>
						</option>
						<option value='A'>
							<fmt:message key="eOT.BeforeCheck-out/DocumentationCompletition.Label" bundle="${ot_labels}"/></option>
					</select>
                        </td>
					
						<td class="label" width='20%'>
                            <fmt:message key="eOT.OperationsProcedures.Label" bundle="${ot_labels}"/>
						</td>
						<td>
						    <select name='oper_proc_fin_stg' id='oper_proc_fin_stg' >
						<option value='S' selected>
							<fmt:message key="eOT.RecordSurgeonNotes.Label" bundle="${ot_labels}"/>
						</option>
						<option value='A'>
							<fmt:message key="eOT.AdminFunction.Label" bundle="${ot_labels}"/></option>
					</select>
                        </td>
					</tr>
	</table>
     </tr>

   <tr>
    <td class="BORDER">
<!-- Border test end -->
	<table border='0' cellpadding=3 cellspacing='0' width='100%' align='center'>
        <tr>
            <td class="COLUMNHEADERCENTER">
                <b><fmt:message key="eOT.SurgicalAccessories.Label" bundle="${ot_labels}"/></b>
            </td>
        </tr>

        <tr><td colspan='2'></td></tr>
 
        <tr>
            <td width="100%" class="BORDERX">
                <table border='1' cellpadding=3  cellspacing='0' width='80%'>
                    <tr>
					<td class="label" width='20%'>
                            <b><fmt:message key="eOT.AccessoryType.Label" bundle="${ot_labels}"/></b>
						</td>
						<td class="label" width='20%'>
                            <b><fmt:message key="eOT.SurgeonNotes.Label" bundle="${ot_labels}"/></b>
						</td>
					
						<td class="label" width='20%'>
                            <b><fmt:message key="eOT.NursingNotes.Label" bundle="${ot_labels}"/></b>
						</td>
					<td class="label" width='20%'>
                            <b><fmt:message key="eOT.Admin.Label" bundle="${ot_labels}"/></b>
						</td>
						<td class="label" width='20%'>
                            <b><fmt:message key="eOT.FinalizationStages.Label" bundle="${ot_labels}"/></b>
						</td>
					</tr>

					<tr>
					<td class="label" width='20%'>
                            <fmt:message key="eOT.ProsthesisImplants.Label" bundle="${ot_labels}"/>
						</td>
					<td class="label" width='20%' align='center'>
                            <input type='checkbox' name='pros_srgn_notes_yn' id='pros_srgn_notes_yn' value='<%=pros_srgn_notes_yn%>' onClick="setChkBoxValue(this);checkProsSurgeonFinStage()">
						</td>
						<td class="label" width='20%' align='center'>
                            <input type='checkbox' name='pros_nursing_notes_yn' id='pros_nursing_notes_yn' value='<%=pros_nursing_notes_yn%>' onClick="setChkBoxValue(this);checkProsNursingFinStage();">
						</td>
					
						<td class="label" width='20%' align='center'>
                            <input type='checkbox' name='pros_admin_yn' id='pros_admin_yn' value='<%=pros_admin_yn%>' onClick="setChkBoxValue(this);checkProsAdminFinStage();">
						</td>
						<td class="label" width='20%'>
                               <select name='pros_imp_val' id='pros_imp_val' onchange="checkProsImpChkBox()">
					   <option value=''>
							<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
						</option>
						<option value='RS'>
							<fmt:message key="eOT.RecordSurgeonNotes.Label" bundle="${ot_labels}"/>
						</option>
						<option value='RN'>
							<fmt:message key="eOT.RecordNursingNotes.Label" bundle="${ot_labels}"/></option>
						 <option value='AF'>
							<fmt:message key="eOT.AdminFunction.Label" bundle="${ot_labels}"/></option> 
					</select>
						</td>
					</tr>
					<tr>
					<td class="label" width='20%'>
                            <fmt:message key="eOT.Equipments.Label" bundle="${ot_labels}"/>
						</td>
					<td class="label" width='20%' align='center'>
                            <input type='checkbox' name='equip_srgn_notes_yn' id='equip_srgn_notes_yn' value='' onClick="setChkBoxValue(this);" disabled> 
						</td>
						<td class="label" width='20%' align='center'>
                            <input type='checkbox' name='equip_nursing_notes_yn' id='equip_nursing_notes_yn' value='<%=equip_nursing_notes_yn%>' onClick="setChkBoxValue(this);checkEquipNursingFinStage();">
						</td>
					
						<td class="label" width='20%' align='center'>
                            <input type='checkbox' name='equip_admin_yn' id='equip_admin_yn' value='<%=equip_admin_yn%>' onClick="setChkBoxValue(this);checkEquipAdminFinStage();">
						</td>
						<td class="label" width='20%'>
                               <select name='equip_val' id='equip_val' onchange="checkEquipChkBox()" >
						<option value=''>
							<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
						</option>
						<option value='RN'>
							<fmt:message key="eOT.RecordNursingNotes.Label" bundle="${ot_labels}"/></option>
						 <option value='AF'>
							<fmt:message key="eOT.AdminFunction.Label" bundle="${ot_labels}"/></option>
					</select>
						</td>
					</tr>
					<tr>
					<td class="label" width='20%'>
                            <fmt:message key="eOT.InstrumentsCSSDPacks.Label" bundle="${ot_labels}"/>
						</td>
					<td class="label" width='20%' align='center'>
                            <input type='checkbox' name='cssd_srgn_notes_yn' id='cssd_srgn_notes_yn' value='' onClick="setChkBoxValue(this);" disabled> 
						</td>
						<td class="label" width='20%' align='center'>
                            <input type='checkbox' name='cssd_nursing_notes_yn' id='cssd_nursing_notes_yn' value='<%=cssd_nursing_notes_yn%>' onClick="setChkBoxValue(this);checkInstrNursingFinStage();">
						</td>
					
						<td class="label" width='20%' align='center'>
                            <input type='checkbox' name='cssd_admin_yn' id='cssd_admin_yn' value='<%=cssd_admin_yn%>' onClick="setChkBoxValue(this);checkInstrAdminFinStage();">
						</td>
						<td class="label" width='20%'>
                               <select name='instr_cssd_val' id='instr_cssd_val' onchange="checkInstrChkBox();">
					   <option value=''>
							<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
						</option>
						<option value='RN'>
							<fmt:message key="eOT.RecordNursingNotes.Label" bundle="${ot_labels}"/></option>
						 <option value='AF'>
							<fmt:message key="eOT.AdminFunction.Label" bundle="${ot_labels}"/></option> 
					</select>
						</td>
					</tr>
					<tr>
					<td class="label" width='20%'>
                            <fmt:message key="eOT.Consumables.Label" bundle="${ot_labels}"/>
						</td>
					<td class="label" width='20%' align='center'>
                            <input type='checkbox' name='cons_srgn_notes_yn' id='cons_srgn_notes_yn' value='' onClick="setChkBoxValue(this);" disabled> 
						</td>
						<td class="label" width='20%' align='center'>
                            <input type='checkbox' name='cons_nursing_notes_yn' id='cons_nursing_notes_yn' value='<%=cons_nursing_notes_yn%>' onClick="setChkBoxValue(this);checkConsNursingFinStage();">
						</td>
					
						<td class="label" width='20%' align='center'>
                            <input type='checkbox' name='cons_admin_yn' id='cons_admin_yn' value='<%=cons_admin_yn%>' onClick="setChkBoxValue(this);checkConsAdminFinStage();">
						</td>
						<td class="label" width='20%'>
                               <select name='consumable_pack_val' id='consumable_pack_val' onchange="checkConsChkBox();">
					   <option value=''>
							<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
						</option>
						<option value='RN' >
							<fmt:message key="eOT.RecordNursingNotes.Label" bundle="${ot_labels}"/></option>
						 <option value='AF'>
							<fmt:message key="eOT.AdminFunction.Label" bundle="${ot_labels}"/></option> 
					</select>
						</td>
					</tr>
	</table>
     </tr>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="tab_id" id="tab_id" value="<%=tab_id%>">
<input type='hidden' name='bean_id' id='bean_id' value='<%=bean_id%>' >
<input type='hidden' name='bean_name' id='bean_name' value='<%=bean_name%>' >
<input type='hidden' name='locale' id='locale' value="<%=locale%>">				
<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>">				
<input type='hidden' name='isIncludeFpp' id='isIncludeFpp' value="<%=isIncludeFpp%>"><!--Added By Gaurav Agaisnt MMS Issue-->			
 </form>
 </head>
</html>

