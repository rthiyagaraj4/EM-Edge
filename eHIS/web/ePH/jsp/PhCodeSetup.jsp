<!DOCTYPE html>
 
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8"  import="ePH.*, ePH.Common.* ,java.util.*, eCommon.Common.*" %>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<%
		//String licenceRights	= PhLicenceRights.getKey();
		request.setCharacterEncoding("UTF-8");
        String locale			= (String)session.getAttribute("LOCALE");
		//
		String db_interface_yn	=	"N";
		String bean_id       = "Phparameter" ;
		String bean_name     = "ePH.ParameterBean";
	
		ParameterBean bean	 = (ParameterBean)getBeanObject( bean_id, bean_name,request) ;
		bean.setLanguageId(locale);
		HashMap existrec     = (HashMap)bean.loadExistData();
		if(existrec!=null){
			if(existrec.containsKey("drug_db_interface_yn")){
				db_interface_yn = ((String)existrec.get("drug_db_interface_yn"));
			}
		}
		String version_no	=	"";
		version_no	= (String) PhVersionNo.getVersion();

%>
	<html>
	<head>
<!-- 	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->

	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
   <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<script>
		var temparr = new Array();
		var count = 0;
		var prev=0;
		var prevcol='MENUSUBLEVELCOLOR';
		var sec_hdg_cd=new Array();
		var logic_seq_no=new Array();

		function goHomePage(){
				parent.location.href="../../eCommon/jsp/CommonClearObjects.jsp";
		}

		async function showFunctionality(){
		var retVal = new Array();

		var features	= 'dialogHeight:40vh;dialogWidth:50vw;dialogLeft:2;dialogTop:60;status=no;scroll=no;title=no;fullscreen=1';
		var arguments	= '' ;

		var vals = parent.parent.header.document.header_form.menu_values.value;
		PHMasterMenu_form.menu_values.value = vals;

		arguments = vals

		retVal	= await window.showModalDialog('change_functionality.jsp',arguments,features);


		if(retVal != null)
		{
			retVal = retVal.replace("location","parent.parent.frames[1].location")
			eval(retVal)
		}
	}

		function chcol(ro)
		{
				document.getElementById("t").rows(prev).cells(0).className=prevcol
				prevcol=ro.cells(0).className
				ro.cells(0).className="MENUSELECTEDCOLOR"
				prev=ro.rowIndex;
		}

		function callJSPs(val)
		{
			
			if(val == 'RouteCode')
				parent.frames[1].location.href = '../../ePH/jsp/RouteCode.jsp?module_id=ePH&function_id=PH_ROUTE&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("ePH.AdminRoute.label","PH"));

			if(val == 'DrugCategory')
				parent.frames[1].location.href = '../../ePH/jsp/DrugCategory.jsp?module_id=ePH&function_id=PH_DRUG_CATG&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("ePH.DrugCategory.label","PH"));

			if(val == 'ATCLevel')
				parent.frames[1].location.href = '../../ePH/jsp/ATCClassification.jsp?module_id=ePH&function_id=PH_ATC_CLASS_LEVEL&function_type=F&access=YYYNN&called_from=ATC&function_name='+encodeURIComponent(getLabel("Common.ATCClassification.label","Common"));

			if(val == 'AssociateRuleForDrugCatg')
				parent.frames[1].location.href = '../../ePH/jsp/DrugCategoryRuleByPatcl.jsp?module_id=ePH&function_id=PH_DRUG_CATG_RULE_BY_PATCL&function_type=F&access=YYYYN&function_name='+encodeURIComponent(getLabel("ePH.AssociatedRulesforDrugCategory.label","PH"));

			if(val == 'DrugSchedule')
				parent.frames[1].location.href = '../../ePH/jsp/DrugSchedule.jsp?module_id=ePH&function_id=PH_DRUG_SCHEDULE&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("ePH.DrugSchedule.label","PH"));

			if(val == 'DrugClassForOrderType')
				parent.frames[1].location.href = '../../ePH/jsp/DrugClassForOrderType.jsp?module_id=ePH&function_id=PH_DRUG_CLASS_ORDER_TYPE&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("ePH.DrugClassforOrderType.label","PH"));

			if(val == 'FormOfDrug')
				parent.frames[1].location.href = '../../ePH/jsp/FormOfDrug.jsp?module_id=ePH&function_id=PH_FORM_OF_DRUG &function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("ePH.FormofDrug.label","PH"));

			if(val == 'DrugType')
				parent.frames[1].location.href = '../../ePH/jsp/DrugType.jsp?module_id=ePH&function_id=PH_DRUG_TYPE&function_type=F&access=NYYNN&function_name='+encodeURIComponent(getLabel("ePH.DrugType.label","PH"));

			if(val == 'DrugDrugType')
				parent.frames[1].location.href = '../../ePH/jsp/DrugDrugType.jsp?module_id=ePH&function_id=PH_DRUG_TYPE &function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("ePH.DrugsByDrugType.label","PH"));

			if(val == 'TermCodeForDrug')
				parent.frames[1].location.href = '../../ePH/jsp/TermCodeForDrug.jsp?module_id=ePH&function_id=PH_TERM_COEE_FOR_DRUG &function_type=F&access=YYNNN&function_name='+encodeURIComponent(getLabel("Common.TermCodeforDrug.label","Common"));

			if(val == 'LabelText')
				parent.frames[1].location.href = '../../ePH/jsp/LabelText.jsp?module_id=ePH&function_id=PH_LABEL_TEXT &function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("Common.labelText.label","Common"));
			if(val == 'ProblemStage')
				parent.frames[1].location.href = '../../ePH/jsp/ProblemStage.jsp?module_id=ePH&function_id=PH_PROBLEM_STAGE &function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("ePH.ProblemStage.label","PH"));
			if(val == 'OrderIntention')
				parent.frames[1].location.href = '../../ePH/jsp/OrderIntention.jsp?module_id=ePH&function_id=PH_ORDER_INTENTION&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("ePH.OrderIntention.label","PH"));
			if(val == 'RegimenService')
				parent.frames[1].location.href = '../../ePH/jsp/RegimenService.jsp?module_id=ePH&function_id=PH_REGIMEN_SERVICEE&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("ePH.RegimenService.label","PH"));

			if(val == 'TPNStockItem')
				parent.frames[1].location.href = '../../ePH/jsp/TPNStockItem.jsp?module_id=ePH&function_id=PH_TPN_STOCK_ITEM&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("ePH.TPNStockItemNSR.label","PH"));

			if(val == 'TPNConsGroup')
				parent.frames[1].location.href = '../../ePH/jsp/PHTPNConsGroup.jsp?module_id=ePH&function_id=PH_TPN_CONST_GRP&function_type=F&access=NYYNN&function_name='+encodeURIComponent(getLabel("ePH.TPNConstituentsGroup.label","PH"));

			if(val == 'TPNConsGeneric')
				parent.frames[1].location.href = '../../ePH/jsp/PHTPNConsGeneric.jsp?module_id=ePH&function_id=PH_TPN_CONST_GEN&function_type=F&access=NYYNN&function_name='+encodeURIComponent(getLabel("ePH.TPNConstituentGeneric.label","PH"));

			if(val == 'TPNConsEnergy')
				parent.frames[1].location.href = '../../ePH/jsp/PHTPNConsEnergy.jsp?module_id=ePH&function_id=PH_TPN_ENERGY_CALC&function_type=F&access=NYYNN&function_name='+encodeURIComponent(getLabel("ePH.TPNEnergyforConstituent.label","PH"));

			if(val == 'UOMForTPNConstituents')
				parent.frames[1].location.href = '../../ePH/jsp/TpnUomConst.jsp?module_id=ePH&function_id=PH_TPN_CONST_UOM&function_type=F&access=YNNNN&function_name='+encodeURIComponent(getLabel("ePH.UOMForTPNConstituents.label","PH"));

			if(val == 'TPNConsLimits')
				parent.frames[1].location.href = '../../ePH/jsp/PHTPNConsLimits.jsp?module_id=ePH&function_id=PH_TPN_CONST_LIMIT&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("ePH.TPNConstituentsLimit.label","PH"));

			if(val == 'StressFactor')
				parent.frames[1].location.href = '../../ePH/jsp/StressFactor.jsp?module_id=ePH&function_id=PH_STRESS_FACTOR&function_type=F&access=YYYYN&function_name='+encodeURIComponent(getLabel("ePH.StressFactor.label","PH"));

			if(val == 'TPNRegimen')
				parent.frames[1].location.href = '../../ePH/jsp/TPNRegimenMast.jsp?module_id=ePH&function_id=PH_TPN_REGIMEN_MAST&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("ePH.TPNRegimen.label","PH"));

			if(val == 'TPNConsNsRegimen')
				parent.frames[1].location.href = '../../ePH/jsp/TpnConsNsRegimen.jsp?module_id=ePH&function_id=PH_TPN_CONST_NS_REGIM&function_type=F&access=YYYNY&function_name='+encodeURIComponent(getLabel("ePH.TPNConstituentNSR.label","PH"));

			if(val == 'UnitsForFormOfDrug')
				parent.frames[1].location.href = '../../ePH/jsp/UomForForm.jsp?module_id=ePH&function_id=PH_UOM_FOR_FORM&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("ePH.UnitsforFormofDrug.label","PH"));

			if(val == 'RouteForForm')
				parent.frames[1].location.href = '../../ePH/jsp/RouteForForm.jsp?module_id=ePH&function_id=PH_ROUTE_FOR_FORM&function_type=F&access=YYYYN&function_name='+encodeURIComponent(getLabel("ePH.RouteForForm.label","PH"));

			if(val == 'GenericNameByATCClass')
				parent.frames[1].location.href = '../../ePH/jsp/GenericNameByATC.jsp?module_id=ePH&function_id=PH_GENERIC_NAME_BY_ATC_CLASS&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("Common.GenericName.label","Common"));

			if(val == 'GenericNameForService')
				parent.frames[1].location.href = '../../ePH/jsp/GenericNameForService.jsp?module_id=ePH&function_id=PH_GENERIC_NAME_FOR_SERVICE&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("ePH.GenericNameForService.label","PH"));

			if(val == 'PresRemarks')
				parent.frames[1].location.href = '../../ePH/jsp/PresRemark.jsp?module_id=ePH&function_id=PH_PRES_REMARK&function_type=F&access=YYYYN&function_name='+encodeURIComponent(getLabel("ePH.PrescriptionRemarks.label","PH"));

			if(val == 'PresRemarksForDrug')
				parent.frames[1].location.href = '../../ePH/jsp/PresRemarkForDrug.jsp?module_id=ePH&function_id=PH_PRES_REMARK_FOR_DRUG&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("ePH.PrescriptionRemarksForDrug.label","PH"));

			if(val == 'ATCL3')
				parent.frames[1].location.href = '../../ePH/jsp/ATCL3.jsp?module_id=ePH&function_id=ATCL3&function_type=F&access=YYYYN&function_name='+encodeURIComponent(getLabel("ePH.DispenseLocation.label","PH"));

			if(val == 'ReasonCodes')
				parent.frames[1].location.href = '../../ePH/jsp/ReasonCodes.jsp?module_id=ePH&function_id=PH_REASON_CODES&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("ePH.ReasonCodes.label","PH"));

			if(val == 'TDMAttributes')
				parent.frames[1].location.href = '../../ePH/jsp/TDMAttributes.jsp?module_id=ePH&function_id=PH_TDM_ATTRIBUTES&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("ePH.TDMAttributes.label","PH"));
		
			if(val == 'ADRType')
				parent.frames[1].location.href = '../../ePH/jsp/ADRType.jsp?module_id=ePH&function_id=PH_ADR_TYPE&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("ePH.AdrType.label","PH"));

			if(val == 'ADRQuestion')
				parent.frames[1].location.href = '../../ePH/jsp/ADRQuestion.jsp?module_id=ePH&function_id=PH_ADR_QUESTION&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("ePH.ADRQuestion.label","PH"));

			if(val == 'ADRCertainity')
				parent.frames[1].location.href = '../../ePH/jsp/ADRCertainity.jsp?module_id=ePH&function_id=PH_ADR_CERTAINITY&function_type=F&access=NYYNN&function_name='+encodeURIComponent(getLabel("ePH.ADRCertainity.label","PH"));

			if(val == 'MedicalItem')
				parent.frames[1].location.href = '../../ePH/jsp/MedicalItem.jsp?module_id=ePH&function_id=PH_MEDICAL_ITEM&function_type=F&access=YYYNN&function_name='+encodeURIComponent(getLabel("Common.MedicalItem.label","Common"));

			if(val == 'VaccineFamily')
				parent.frames[1].location.href = '../../ePH/jsp/VaccineFamily.jsp?module_id=ePH&function_id=PH_VACCINE_FAMILY&function_name=Vaccine Family &function_type=F&access=YYYNN';

			if(val == 'VaccineSchedule')
				parent.frames[1].location.href = '../../ePH/jsp/VaccineSchedule.jsp?module_id=ePH&function_id=PH_VACCINE_SCHEDULE&function_name=Vaccine Schedule &function_type=F&access=YYYNN';

			if(val == 'VaccineDrug')
				parent.frames[1].location.href = '../../ePH/jsp/VaccineDrug.jsp?module_id=ePH&function_id=PH_VACCINE_DRUG&function_name=Vaccine Drug &function_type=F&access=YYYNN';

			if(val == 'eRx')
				parent.frames[1].location.href = '../../ePH/eRx/jsp/eRx.html?module_id=ePH&function_id=ERX&function_name=eRx&function_type=F&access=YYYNN';
		}
	</script>
	</head>

	<!-- <body style="background-color:dimgray;" > -->
	<body style="background-color:dimgray;" onMouseDown="" onKeyDown="lockKey()">
	<form name="PHMasterMenu_form" id="PHMasterMenu_form">
	<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('eRx')" >eRx</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ATCLevel')" ><fmt:message key="Common.ATCClassification.label" bundle="${common_labels}"/></td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('GenericNameByATCClass')" ><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('GenericNameForService')" ><fmt:message key="ePH.GenericNameForService.label" bundle="${ph_labels}"/></td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('FormOfDrug')" ><fmt:message key="ePH.FormofDrug.label" bundle="${ph_labels}"/></td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('UnitsForFormOfDrug')" ><fmt:message key="ePH.UnitsforFormofDrug.label" bundle="${ph_labels}"/></td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('DrugType')" ><fmt:message key="ePH.DrugType.label" bundle="${ph_labels}"/></td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('DrugDrugType')" ><fmt:message key="ePH.DrugsByDrugType.label" bundle="${ph_labels}"/></td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('TermCodeForDrug')" ><fmt:message key="Common.TermCodeforDrug.label" bundle="${common_labels}"/></td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('RouteCode')" ><fmt:message key="ePH.AdminRoute.label" bundle="${ph_labels}"/></td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('RouteForForm')" ><fmt:message key="ePH.RouteForForm.label" bundle="${ph_labels}"/></td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('DrugCategory')" ><fmt:message key="ePH.DrugCategory.label" bundle="${ph_labels}"/></td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('AssociateRuleForDrugCatg')" ><fmt:message key="ePH.AssociatedRulesforDrugCategory.label" bundle="${ph_labels}"/></td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('DrugSchedule')" ><fmt:message key="ePH.DrugSchedule.label" bundle="${ph_labels}"/></td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('DrugClassForOrderType')" ><fmt:message key="ePH.DrugClassforOrderType.label" bundle="${ph_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PresRemarks')" ><fmt:message key="ePH.PrescriptionRemarks.label" bundle="${ph_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PresRemarksForDrug')" ><fmt:message key="ePH.PrescriptionRemarksForDrug.label" bundle="${ph_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('LabelText')" ><fmt:message key="Common.labelText.label" bundle="${common_labels}"/></td>
		</tr>
		<% if(db_interface_yn.equals("Y")) { %>
		<%	}	%>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ReasonCodes')" ><fmt:message key="ePH.ReasonCodes.label" bundle="${ph_labels}"/></td>
		</tr>
		<% if(version_no.equals("3")){%>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ProblemStage')" ><fmt:message key="ePH.ProblemStage.label" bundle="${ph_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('OrderIntention')" ><fmt:message key="ePH.OrderIntention.label" bundle="${ph_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('RegimenService')" ><fmt:message key="ePH.RegimenService.label" bundle="${ph_labels}"/></td>
		</tr>
		<%}%>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('TDMAttributes')" ><fmt:message key="ePH.TDMAttributes.label" bundle="${ph_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ADRType')" ><fmt:message key="ePH.AdrType.label" bundle="${ph_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ADRQuestion')" ><fmt:message key="ePH.ADRQuestion.label" bundle="${ph_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ADRCertainity')" ><fmt:message key="ePH.ADRCertainity.label" bundle="${ph_labels}"/></td>
		</tr>
        <!-- <tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('VaccineFamily')" >Vaccine Family</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('VaccineSchedule')" >Vaccine Schedule</td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('VaccineDrug')" >Vaccine Drug</td>
		</tr> -->

		<% if(version_no.equals("3")){%>
		<tr>
			<td class='MENUHIGHERLEVELCOLOR'><label style='color:white;'><b><fmt:message key="ePH.TPNSetup.label" bundle="${ph_labels}"/></b></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('TPNStockItem')" ><fmt:message key="ePH.TPNStockItemNSR.label" bundle="${ph_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('TPNConsGroup')" ><fmt:message key="ePH.TPNConstituentsGroup.label" bundle="${ph_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('TPNConsGeneric')" ><fmt:message key="ePH.TPNConstituentGeneric.label" bundle="${ph_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('TPNConsEnergy')" ><fmt:message key="ePH.TPNEnergyforConstituent.label" bundle="${ph_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('UOMForTPNConstituents')" ><fmt:message key="ePH.UOMForTPNConstituents.label" bundle="${ph_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('TPNConsLimits')" ><fmt:message key="ePH.TPNConstituentsLimit.label" bundle="${ph_labels}"/></td>
		</tr>

		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('TPNRegimen')" ><fmt:message key="ePH.TPNRegimen.label" bundle="${ph_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('StressFactor')" ><fmt:message key="ePH.StressFactor.label" bundle="${ph_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('TPNConsNsRegimen')" ><fmt:message key="ePH.TPNConstituentNSR.label" bundle="${ph_labels}"/></td>
		</tr>
 	 	<!-- <tr>
			<td class='MENUHIGHERLEVELCOLOR'><label style='color:white;'><b><fmt:message key="ePH.MedicalItemSetup.label" bundle="${ph_labels}"/></b></td>
		</tr> -->
 		<!-- <tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('MedicalItem')" ><fmt:message key="ePH.MedicalItem.label" bundle="${ph_labels}"/></td>
		</tr> -->
		<% }if(db_interface_yn.equals("Y")) { %>
		<%	}	%>
		<tr >
			<td class='MENUHIGHERLEVELCOLOR'><a href="javascript:goHomePage()" style='color:white;'><b><fmt:message key="Common.menu.label" bundle="${common_labels}"/></b></a></td>
		</tr>

		<input type=hidden name='menu_values' id='menu_values'>
	</table>
	</body>
	<% putObjectInBean(bean_id,bean,request); %>
	</form>
</html> 

