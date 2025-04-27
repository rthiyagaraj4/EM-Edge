function run(){
	var formObj = searchResultFrame.document.forms[0];
	if(formObj) {
		formObj.submit();
		window.returnValue=true;
		window.close();
	}
}

function reset(){
	if(searchResultFrame.document.forms[0]){
		searchResultFrame.document.forms[0].reset();
		messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
	}
 }

function loadPage(objVal) {
	if(objVal=="") {
		parent.searchResultFrame.location.href="../../eCommon/html/blank.html";
	}
	if(objVal=="OH_NUMBERING_SYSTEM") {
		parent.searchResultFrame.location.href="../../eOH/jsp/MRepNumberingSystem.jsp";
	}
	if(objVal=="OH_ARCH") {
		parent.searchResultFrame.location.href="../../eOH/jsp/MRepArch.jsp";
	}
	if(objVal=="OH_QUADRANT") {
		parent.searchResultFrame.location.href="../../eOH/jsp/MRepQuadrant.jsp";
	}
	if(objVal=="OH_SITE_TYPE") {
		parent.searchResultFrame.location.href="../../eOH/jsp/MRepSiteType.jsp";
	}
	if(objVal=="OH_CUSP_TIP") {
		parent.searchResultFrame.location.href="../../eOH/jsp/MRepCuspTip.jsp";
	}
	if(objVal=="OH_SURFACE") {
		parent.searchResultFrame.location.href="../../eOH/jsp/MRepSurface.jsp";
	}
	if(objVal=="OH_TOOTH") {
		parent.searchResultFrame.location.href="../../eOH/jsp/MRepTooth.jsp";
	}
	if(objVal=="OH_TREATMENT_CATEGORY_TYPE") {
		parent.searchResultFrame.location.href="../../eOH/jsp/MRepTreatmentCategoryType.jsp";
	}
	if(objVal=="OH_TREATMENT_CATEGORY") {
		parent.searchResultFrame.location.href="../../eOH/jsp/MRepTreatmentCategory.jsp";
	}
	if(objVal=="OH_TREATMENT") {
		parent.searchResultFrame.location.href="../../eOH/jsp/MRepTreatments.jsp ";
	}
	if(objVal=="OH_CONDITION_TYPE") {
		parent.searchResultFrame.location.href="../../eOH/jsp/MRepConditionType.jsp";
	}
	if(objVal=="OH_CONDITION") {
		parent.searchResultFrame.location.href="../../eOH/jsp/MRepConditions.jsp";
	}
	if(objVal=="OH_PERIODONTAL_CHART_COMP") {
		parent.searchResultFrame.location.href="../../eOH/jsp/MRepPeriodontalChartComp.jsp";
	}
	if(objVal=="OH_PERIODONTAL_CHART_HDR") {
		parent.searchResultFrame.location.href="../../eOH/jsp/MRepPeriodontalChartHdr.jsp";
	}
	if(objVal=="OH_GINGIVAL_STATUS") {
		parent.searchResultFrame.location.href="../../eOH/jsp/MRepGingivalStatus.jsp";
	}
	if(objVal=="OH_CLINICAL_GROUP") {
		parent.searchResultFrame.location.href="../../eOH/jsp/MRepClinicalGroup.jsp";
	}
	if(objVal=="OH_COMPLICATION") {
		parent.searchResultFrame.location.href="../../eOH/jsp/MRepComplications.jsp";
	}
	if(objVal=="OH_COMPOSITION_CLASS") {
		parent.searchResultFrame.location.href="../../eOH/jsp/MRepCompositionClass.jsp";
	}
	if(objVal=="OH_COMPOSITION") {
		parent.searchResultFrame.location.href="../../eOH/jsp/MRepComposition.jsp";
	}
	//newly created by rajesh on 21/02/08
	if(objVal=="OH_TREATMENT_CATEGORY_TYPE") {
		parent.searchResultFrame.location.href="../../eOH/jsp/MRepTrmtCatType.jsp";
	}
	if(objVal=="OH_TREATMENT_CATEGORY") {
		parent.searchResultFrame.location.href="../../eOH/jsp/MRepTrmtCategory.jsp";
	}
	if(objVal=="OH_TREATMENT") {
		parent.searchResultFrame.location.href="../../eOH/jsp/MRepTreatment.jsp";
	}
	if(objVal=="OH_TASKS") {
		parent.searchResultFrame.location.href="../../eOH/jsp/MRepTasks.jsp";
	}
	if(objVal=="OH_TREATMENT_TASKS") {
		parent.searchResultFrame.location.href="../../eOH/jsp/MRepTasksForTrmt.jsp";
	}
	if(objVal=="OH_PERIODONTAL_CHART_COMP") {
		parent.searchResultFrame.location.href="../../eOH/jsp/MRepPerioChartComp.jsp";
	}
	if(objVal=="OH_PERIODONTAL_CHART_DEF_HDR") {
		parent.searchResultFrame.location.href="../../eOH/jsp/MRepPerioChartDef.jsp";
	}
	if(objVal=="OH_PERIODONTAL_CHART_DEF_DTL2") {
		parent.searchResultFrame.location.href="../../eOH/jsp/MRepPerioChartToothAppl.jsp";
	}

	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";

}

function callCommonMasterLookup(obj){
	var formObj = document.forms[0];
	var tit = obj.title;
	var key = obj.key;
	var param1 = obj.param1;
	var param2 = obj.param2;
	var target = eval("formObj."+param1);
	var totarget = eval("formObj."+param2);
	var returnedValues =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0] = getSqlString(key);
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
//	argumentArray[4] = "1,2"; Modified By Rajesh for LOokup Issue
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE ;
	
	returnedValues = CommonLookup( tit, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		target.value=returnedValues[0];
		obj.value=returnedValues[1];
		totarget.value=returnedValues[0];
		
	}else{
		target.value='';
		obj.value='';
		totarget.value='';
	}
	
}

