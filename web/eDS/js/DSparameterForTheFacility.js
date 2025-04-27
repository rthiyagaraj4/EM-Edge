	/***********************************************************
	/*               DSparameterForTheFacility.JS
	/***********************************************************/
/*	function create(){
		content.location.href=contextPath+"/DSparameterForTheFacilityAction.do?method="+loadMethod+"&vo.functionId="+functionId
}*/

function apply() {
	var formObj = parent.content.f_query_add_mod.document.forms[0];
	
	formObj.querySelector("#kitchenCode").disabled=false;
	formObj.querySelector("#multiKitchenYn").disabled=false;
	
	//Commented by vikash against ICN
	/*formObj.querySelector("#gracePeriodApplicableYn").disabled=false;
	formObj.querySelector("#gracePeriod").disabled=false;*/
	 var error ="";
	//CRF-230 changes
	if(formObj.querySelector("#multiFacilityOPyn").checked)
		formObj.querySelector("#multiFacilityOPyn").value = "Y";
	else
		formObj.querySelector("#multiFacilityOPyn").value = "N";
	//CRF-78.1 starts
	//Commented for 409 CRF
	/*
	if(formObj.querySelector("#GenerateNilByMouth_YN").checked)
		formObj.querySelector("#GenerateNilByMouth_YN").value = "Y";
	else
		formObj.querySelector("#GenerateNilByMouth_YN").value = "N";
	*/
	//Commented for 409 CRF
	//CRF-78.1 ends		

	//MMS-KH-CRF-0029.1 Starts
	if(formObj.querySelector("#enableDrugFoodYN").checked)
		formObj.querySelector("#enableDrugFoodYN").value = "Y";
	else
		formObj.querySelector("#enableDrugFoodYN").value = "N";
	//MMS-KH-CRF-0029.1 Ends

	//RestrictMealServingStartTime
	//ML-MMOH-CRF-409 Starts	
	if(formObj.querySelector("#LATE_IRREGULAR_DIET_ORD_FOR_IP").checked){
		formObj.querySelector("#LATE_IRREGULAR_DIET_ORD_FOR_IP").value = "Y";
	}	else{
		formObj.querySelector("#LATE_IRREGULAR_DIET_ORD_FOR_IP").value = "N";	
	}
	//ML-MMOH-CRF-409 Ends
	//ML-MMOH-CRF-600 Starts
	//OP/EM
	if(formObj.querySelector("#allow_op_em_yn").checked)
	formObj.querySelector("#allow_op_em_yn").value="Y";
	else
	formObj.querySelector("#allow_op_em_yn").value="N";
	if(formObj.querySelector("#op_served_yn").checked){			
		formObj.querySelector("#op_served_yn").value = "Y";
	}else{		
		formObj.querySelector("#op_served_yn").value ="N";
	}
	if(formObj.querySelector("#op_accept_yn").checked){
		formObj.querySelector("#op_accept_yn").value = "Y";
	}else {
		formObj.querySelector("#op_accept_yn").value ="N";
	}
	//IP
	if(formObj.querySelector("#allow_ip_yn").checked)
	formObj.querySelector("#allow_ip_yn").value="Y";
	else
	formObj.querySelector("#allow_ip_yn").value="N";
	
   if(formObj.querySelector("#ip_MealPrepared_yn").checked){
		formObj.querySelector("#ip_MealPrepared_yn").value = "Y";
	}else {
		formObj.querySelector("#ip_MealPrepared_yn").value ="N";
	}
	if(formObj.querySelector("#ip_MealReceived_yn").checked){
		formObj.querySelector("#ip_MealReceived_yn").value = "Y";
	}else {
		formObj.querySelector("#ip_MealReceived_yn").value ="N";
	}
	if(formObj.querySelector("#ip_MealServed_yn").checked){
		formObj.querySelector("#ip_MealServed_yn").value = "Y";
	}else {
		formObj.querySelector("#ip_MealServed_yn").value ="N";
	}
	//ML-MMOH-CRF-600 Ends
	//ML-ML-MMOH-CRF-0412		
	if(formObj.querySelector("#attendantOrderApplicableYn").checked)
		formObj.querySelector("#attendantOrderApplicableYn").value = "Y";
	else
		formObj.querySelector("#attendantOrderApplicableYn").value = "N";
	//ML-ML-MMOH-CRF-0412	
	
	//ML-MMOH-CRF-0427 Starts		
	if (checkNull()) {
		formObj.querySelector("#gracePeriodApplicableYn").disabled=false;
		formObj.querySelector("#gracePeriod").disabled=false;
		//formObj.querySelector("#GenerateNilByMouth_YN").disabled=false;//MMS-CRF-78.1//Commented for 409 CRF
		//ML-MMOH-CRF-409 starts
		if(formObj.querySelector("#LATE_IRREGULAR_DIET_ORD_FOR_IP").value == "Y" &&formObj.querySelector("#GenerateNilByMouth_YN").value == "N"){
		formObj.querySelector("#GenerateNilByMouth_YN").value = "Y";
		}
		formObj.querySelector("#LATE_IRREGULAR_DIET_ORD_FOR_IP").disabled=false;			
		formObj.querySelector("#NotificationMessageforPlaceDietOrder").disabled=false;
		//ML-MMOH-CRF-409 ends
		formObj.querySelector("#attendantcount").disabled=false;//ML-ML-MMOH-CRF-0412
		formObj.method='post';
		formObj.action="../../servlet/eDS.DSparameterForTheFacilityServlet";
		formObj.submit();
		top.frames[1].location.href=top.frames[1].location.href;//ML-ML-MMOH-CRF-0406 FOR REFRESHING THE MENU FRAME			
	}
}

function reset(){
	var formObj = parent.content.f_query_add_mod.DSparameterForTheFacilityForm;
	var mode=formObj.mode.value;		  
	var generateDefaultDiet=formObj.reset_generateDefaultDiet.value;
	var labelMessage=formObj.reset_labelMessage.value;
	var multiKitchen=formObj.reset_multiKitchen.value;
	var maxMealPlanCreatDays=formObj.reset_maxMealPlanCreatDays.value;
	var mealPlanNextSeq=formObj.reset_mealPlanNextSeq.value;
	var acceptDietForMeal=formObj.reset_acceptDietForMeal.value;
	var blInterface=formObj.reset_blInterface.value;
	var attendantOrderApplicable=formObj.reset_attendantOrderApplicable.value;
	var cutOffTimeForLiquidFood=formObj.reset_cutOffTimeForLiquidFood.value;
	var gracePeriodApplicable=formObj.reset_gracePeriodApplicable.value;
	var gracePeriod=formObj.reset_gracePeriod.value;
	var multiFacility=formObj.reset_multiFacility.value; //CRF-230

	var RestrictDateRangeforInpatients=formObj.reset_RestrictDateRangeforInpatients.value;//ML-MMOH-CRF-0427
	var MaximumDaysAllowed_Value=formObj.reset_MaximumDaysAllowed_Value.value;//ML-MMOH-CRF-0427
	var GenerateNilByMouth=formObj.reset_GenerateNilByMouth.value;//MMS-CRF-78.1

	var enableDrugFoodYN=formObj.reset_enableDrugFoodYN.value;//MMS-KH-CRF-0029.1

	//ML-MMOH-CRF-409 Starts
	var LATE_IRREGULAR_DIET_ORD_FOR_IP=formObj.reset_LATE_IRREGULAR_DIET_ORD_FOR_IP.value;
	var NotificationMessageforPlaceDietOrder=formObj.reset_NotificationMessageforPlaceDietOrder.value;
	//ML-MMOH-CRF-409 Ends
	var Attendent_Label_Name=formObj.reset_Attendent_Label_Name.value;//ML-MMOH-CRF-0406
	var No_Of_Attendant=formObj.reset_No_Of_Attendant.value;//ML-MMOH-CRF-0412

	//ML-MMOH-CRF-0600
	var OPEMServed=formObj.reset_op_em_served.value;
	var OPEMAccept=formObj.reset_op_em_accept.value;
	var OPEMAllow =formObj.reset_op_em_allow.value;
	var IPMealPrepared=formObj.reset_ip_MealPrepared.value;
	var IPMealReceived=formObj.reset_ip_MealReceived.value;
	var IPMealServed=formObj.reset_ip_MealServed.value;
	var IPAllow=formObj.reset_ip_allow.value;
	//ML-MMOH-CRF-0600
	//Added Against ML-MMOH-CRF-1061 US2 Starts Here
	var OP_served = formObj.reset_OPstatus_Ser.value;
	var OP_accepted = formObj.reset_OPstatus_Acc.value;//67113
	var MealPrepared = formObj.reset_IPstatus_Pre.value;
	var MealReceived = formObj.reset_IPstatus_Rec.value;
	var MealServed = formObj.reset_IPstatus_Ser.value;//67113
	//Added Against ML-MMOH-CRF-1061 US2 Ends Here
	//Added Against ML-MMOH-CRF-0825 Starts Here
	var LATE_IRREGULAR_DIET_ORD_FOR_OP=formObj.reset_LATE_IRREGULAR_DIET_ORD_FOR_OP.value;
	var LATE_IRREGULAR_DIET_ORD_FOR_EM=formObj.reset_LATE_IRREGULAR_DIET_ORD_FOR_EM.value;
	var LATE_IRREGULAR_DIET_ORD_FOR_ST=formObj.reset_LATE_IRREGULAR_DIET_ORD_FOR_ST.value;
	var LATE_IRREGULAR_DIET_ORD_FOR_SP=formObj.reset_LATE_IRREGULAR_DIET_ORD_FOR_SP.value;
	//Added Against ML-MMOH-CRF-0825 Ends Here
	//Added by santhosh
	var InstructionInLabelFormula = formObj.reset_InstructionInLabelFormula.value;
	formObj.reset();

	formObj.mode.value=mode;
	formObj.labelMessage.value=labelMessage;
	formObj.maxMealPlanCreatDays.value=maxMealPlanCreatDays;
	formObj.mealPlanNextSeq.value=mealPlanNextSeq;
	formObj.cutoffTimeforFreqBased.value=cutOffTimeForLiquidFood;
	formObj.gracePeriod.value=gracePeriod;
	formObj.multiFacilityOPyn.value=multiFacility;
	//formObj.GenerateNilByMouth_YN.value=GenerateNilByMouth;//MMS-CRF-78.1//Commented for 409 CRF
	formObj.RestrictDateRangeforInpatientsYN.value=RestrictDateRangeforInpatients;//ML-MMOH-CRF-0427
	formObj.MaximumDaysAllowed.value=MaximumDaysAllowed_Value;//ML-MMOH-CRF-0427
  
	formObj.enableDrugFoodYN.value=enableDrugFoodYN;//MMS-KH-CRF-0029.1
	//ML-MMOH-CRF-409 Starts
	formObj.LATE_IRREGULAR_DIET_ORD_FOR_IP.value=LATE_IRREGULAR_DIET_ORD_FOR_IP;	
	formObj.NotificationMessageforPlaceDietOrder.value=NotificationMessageforPlaceDietOrder;
	//ML-MMOH-CRF-409 Ends

	//ML-MMOH-CRF-0825 Starts
	formObj.LATE_IRREGULAR_DIET_ORD_FOR_OP.value=LATE_IRREGULAR_DIET_ORD_FOR_OP;
	formObj.LATE_IRREGULAR_DIET_ORD_FOR_EM.value=LATE_IRREGULAR_DIET_ORD_FOR_EM;
	formObj.LATE_IRREGULAR_DIET_ORD_FOR_ST.value=LATE_IRREGULAR_DIET_ORD_FOR_ST;
	formObj.LATE_IRREGULAR_DIET_ORD_FOR_SP.value=LATE_IRREGULAR_DIET_ORD_FOR_SP;
	//ML-MMOH-CRF-0825 Ends
	formObj.Attendent_Label_Name.value=Attendent_Label_Name;//ML-ML-MMOH-CRF-0406
	formObj.attendantcount.value=No_Of_Attendant;//ML-ML-MMOH-CRF-0412
	//Added by santhosh
	formObj.InstructionInLabelFormula.value=InstructionInLabelFormula;

	if(generateDefaultDiet=='Y') {
	  formObj.generateDefaultDietYn.checked=true;
	  }
	//CRF-600 Starts		  
	if(OPEMAllow=='Y'){
		  formObj.allow_op_em_yn.checked=true; 
		//Commented Against ML-MMOH-CRF-1061/US004/01 [IN:067113]
		/*if(OPEMServed=='Y'){
		  formObj.op_served_yn.checked=true;				  
		}
		if(OPEMAccept=='Y'){
		formObj.op_accept_yn.checked=true;				  
		} 
		formObj.op_served_yn.disabled=false;	
		formObj.op_accept_yn.disabled=false; */	
	//Added Against ML-MMOH-CRF-1061 US2 & 67113 Starts Here
	if(OP_served=="Y"){
		if(OPEMServed=='Y'){
		formObj.op_served_yn.disabled=false;
		formObj.op_served_yn.checked=true;
		}
		else{
		formObj.op_served_yn.disabled=false;
		formObj.op_served_yn.checked=false;	
		}
	}else{
		formObj.op_served_yn.disabled=true;
		formObj.op_served_yn.checked=false;
	} 
	if(OP_accepted=="Y"){
		if(OPEMAccept=='Y'){
		formObj.op_accept_yn.disabled=false;
		formObj.op_accept_yn.checked=true;
		}
		else{
		formObj.op_accept_yn.disabled=false;
		formObj.op_accept_yn.checked=false;		
		}
	}else{
		formObj.op_accept_yn.disabled=true;
		formObj.op_accept_yn.checked=false;
	}

	//Added Against ML-MMOH-CRF-1061 US2 & 67113 Ends Here				
	}
	else
	{
	   formObj.allow_op_em_yn.checked=false;
	   //Added Against ML-MMOH-CRF-1061 US2 & 67113 Starts Here
		if(OP_served=="Y"){
			formObj.op_served_yn.checked=true;
			formObj.op_served_yn.disabled=true;
		}else{
			formObj.op_served_yn.checked=false;
			formObj.op_served_yn.disabled=true;
		}
		if(OP_accepted=="Y"){
			formObj.op_accept_yn.checked=true;
			formObj.op_accept_yn.disabled=true;
		}else{
			formObj.op_accept_yn.checked=false;
			formObj.op_accept_yn.disabled=true;
		}		
	}
	if(IPAllow=='Y'){
		formObj.allow_ip_yn.checked=true;	
	//67113
		if(MealPrepared=="Y"){
			if(IPMealPrepared=='Y'){
				formObj.ip_MealPrepared_yn.disabled=false;
				formObj.ip_MealPrepared_yn.checked=true;
			}
			else{
				formObj.ip_MealPrepared_yn.disabled=false;
				formObj.ip_MealPrepared_yn.checked=false;	
			}
		}else{
			formObj.ip_MealPrepared_yn.disabled=true;
			formObj.ip_MealPrepared_yn.checked=false;
		}
		if(MealReceived=="Y"){
			if(IPMealReceived=='Y'){
				formObj.ip_MealReceived_yn.disabled=false;
				formObj.ip_MealReceived_yn.checked=true;
			}
			else{
				formObj.ip_MealReceived_yn.disabled=false;
				formObj.ip_MealReceived_yn.checked=false;
			}
		}else{
			formObj.ip_MealReceived_yn.disabled=true;
			formObj.ip_MealReceived_yn.checked=false;
		}
		if(MealServed=="Y"){
			if(IPMealServed=='Y') {
				formObj.ip_MealServed_yn.disabled=false;
				formObj.ip_MealServed_yn.checked=true;
			}
			else{
				formObj.ip_MealServed_yn.disabled=false;
				formObj.ip_MealServed_yn.checked=false;
			}
		}else{
			formObj.ip_MealServed_yn.disabled=true;
			formObj.ip_MealServed_yn.checked=false;
		}
	}
	else
	{
		if(MealPrepared=="Y"){
			formObj.ip_MealPrepared_yn.checked=true;
			formObj.ip_MealPrepared_yn.disabled=true;
		}else{
			formObj.ip_MealPrepared_yn.checked=false;
			formObj.ip_MealPrepared_yn.disabled=true;
		}
		if(MealReceived=="Y"){
			formObj.ip_MealReceived_yn.checked=true;
			formObj.ip_MealReceived_yn.disabled=true;
		}else{
			formObj.ip_MealReceived_yn.checked=false;
			formObj.ip_MealReceived_yn.disabled=true;
		}
		if(MealServed=="Y"){
			formObj.ip_MealServed_yn.checked=true;
			formObj.ip_MealServed_yn.disabled=true;
		}else{
			formObj.ip_MealServed_yn.checked=false;
			formObj.ip_MealServed_yn.disabled=true;
		}
		//67113
	}
	
	if(multiKitchen=='Y') {
		formObj.multiKitchenYn.checked=true;
		formObj.kitchenCode.disabled = false;
	}
	if(acceptDietForMeal=='Y') {formObj.acceptDietForIndMealYn.checked=true;}
	if(blInterface=='Y') {formObj.blInterfaceYn.checked=true;}
	if(attendantOrderApplicable=='Y') {
	formObj.attendantOrderApplicableYn.checked=true;
	formObj.attendantcount.disabled=false;//ML-ML-MMOH-CRF-0412
	formObj.attendant_count_check.style.visibility="visible";//ML-ML-MMOH-CRF-0412
	}else{
	formObj.attendantcount.disabled=true;//ML-ML-MMOH-CRF-0412
	formObj.attendant_count_check.style.visibility="hidden";//ML-ML-MMOH-CRF-0412
	//formObj.attendantcount.value="";//ML-ML-MMOH-CRF-0412
	}
	if(gracePeriodApplicable=='Y') {
	  formObj.gracePeriodApplicableYn.checked=true;
	  formObj.gracePeriodApplicableYn.disabled=true;
	  formObj.gracePeriod.disabled = true;
	  formObj.grace_image.style.visibility = "visible";
	}else{
	  formObj.gracePeriod.disabled = true;
	  formObj.grace_image.style.visibility = "hidden";
	}
	//CRF-230 changes
	if(multiFacility == 'Y'){
	formObj.multiFacilityOPyn.checked=true;
	}else{
	formObj.multiFacilityOPyn.checked=false;
	}
	//ML-MMOH-CRF-0427 starts
	if(RestrictDateRangeforInpatients=="Y"){
	formObj.RestrictDateRangeforInpatientsYN.checked=true;
	formObj.count_check.style.visibility="visible";
	formObj.MaximumDaysAllowed.disabled=false;

	}else{
	formObj.count_check.style.visibility="hidden";
	formObj.MaximumDaysAllowed.disabled=true;
	}
	//ML-MMOH-CRF-0427 ends

	//MMS-KH-CRF-0029.1 Starts
	if(enableDrugFoodYN == 'Y'){
	formObj.enableDrugFoodYN.checked=true;
	}else{
	formObj.enableDrugFoodYN.checked=false;
	}
	//MMS-KH-CRF-0029.1 Ends
  
	//ML-MMOH-CRF-409 Starts
	if(acceptDietForMeal=="Y"){
		formObj.LATE_IRREGULAR_DIET_ORD_FOR_IP.disabled=false;
	}else{
		formObj.LATE_IRREGULAR_DIET_ORD_FOR_IP.disabled=true;
	}
	if(LATE_IRREGULAR_DIET_ORD_FOR_IP=="Y"){
		formObj.LATE_IRREGULAR_DIET_ORD_FOR_IP.checked=true;
	if(acceptDietForMeal=="Y"){		
		formObj.NotificationMessageforPlaceDietOrder.disabled=false;
	}			
	}else{
		formObj.LATE_IRREGULAR_DIET_ORD_FOR_IP.checked=false;		
		formObj.NotificationMessageforPlaceDietOrder.disabled=true;
	}  
	//ML-MMOH-CRF-409 Ends
	//ML-MMOH-CRF-0825 Starts
	if(LATE_IRREGULAR_DIET_ORD_FOR_OP=="Y"){
		formObj.LATE_IRREGULAR_DIET_ORD_FOR_OP.checked=true;				
	}else{
		formObj.LATE_IRREGULAR_DIET_ORD_FOR_OP.checked=false;		
	}
	if(LATE_IRREGULAR_DIET_ORD_FOR_EM=="Y"){
		formObj.LATE_IRREGULAR_DIET_ORD_FOR_EM.checked=true;				
	}else{
		formObj.LATE_IRREGULAR_DIET_ORD_FOR_EM.checked=false;		
	}
	if(LATE_IRREGULAR_DIET_ORD_FOR_ST=="Y"){
		formObj.LATE_IRREGULAR_DIET_ORD_FOR_ST.checked=true;				
	}else{
		formObj.LATE_IRREGULAR_DIET_ORD_FOR_ST.checked=false;		
	}
	if(LATE_IRREGULAR_DIET_ORD_FOR_SP=="Y"){
		formObj.LATE_IRREGULAR_DIET_ORD_FOR_SP.checked=true;				
	}else{
		formObj.LATE_IRREGULAR_DIET_ORD_FOR_SP.checked=false;		
	}
	//ML-MMOH-CRF-0825 Ends
}

function checkNumber(){
	obj =  String.fromCharCode(window.event.keyCode);
	var alphaFilter =/^[0-9]+$/;
	if (!(alphaFilter.test(obj))) {
		alert(getMessage("INVALID_POSITIVE_NUMBER","common"));
		window.event.keyCode = 27;
	}
}
//ML-MMOH-CRF-0427 starts
function checkDigit(){
	obj =  String.fromCharCode(window.event.keyCode);
	var alphaFilter =/^[0-9]+$/;
	if (!(alphaFilter.test(obj))) {
		//alert(getMessage("INVALID_POSITIVE_NUMBER","common"));
		window.event.keyCode = 27;
	}
}
//ML-MMOH-CRF-0427

function gracePeriodCheck(){
	  obj =  String.fromCharCode(window.event.keyCode);
	var alphaFilter =/^[0-9]+$/;
	if (!(alphaFilter.test(obj))) {
		alert("Grace Period Must be in Hours");
		window.event.keyCode = 27;
	}
}

function checkNull(){
	var formObj = parent.content.f_query_add_mod.document.forms[0];
	var mealPlanNextSeq=formObj.querySelector("#mealPlanNextSeq").value;
	var gracePeriod = formObj.querySelector("#gracePeriod").value;
	var chkGrace = formObj.querySelector("#gracePeriodApplicableYn").checked;
	var RestrictDateRangeforInpatientsYN=formObj.querySelector("#RestrictDateRangeforInpatientsYN").checked;//ML-MMOH-CRF-0427
	var MaximumDaysAllowed=formObj.querySelector("#MaximumDaysAllowed").value;//ML-MMOH-CRF-0427
	var ATTENDENT_LABEL_NAME=formObj.querySelector("#Attendent_Label_Name").value//ML-MMOH-CRF-0406
	var attendantOrderApplicableYn=formObj.querySelector("#attendantOrderApplicableYn").checked;//ML-ML-MMOH-CRF-0412
	var attendantcount=formObj.querySelector("#attendantcount").value;//ML-ML-MMOH-CRF-0412
	var Attendent_Name=formObj.querySelector("#Attendent_Name").value;//ML-ML-MMOH-CRF-0406
	if(mealPlanNextSeq=="") {
		var error="Next Meal Plan No. cannot be blanks";
		parent.content.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
	}else if(chkGrace == true && gracePeriod == ""){
		var error = "Grace Period cannot be blank";
		parent.content.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
	}else if(gracePeriod > 24){
			var error = "Grace Period should not be greater than 24Hrs"
			parent.content.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
	}
	//ML-MMOH-CRF-0427 Starts
	else if(RestrictDateRangeforInpatientsYN== true && (MaximumDaysAllowed<=0 || MaximumDaysAllowed=='')){
			var error = "Maximum Days Allowed (Including Current Day) should be minimum 1 and maximum 999 days"
			parent.content.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
	}		
	//ML-MMOH-CRF-0427 ends
	
	//ML-MMOH-CRF-0406 STARTS
	else if(ATTENDENT_LABEL_NAME==""){
		var error="Patient Care Taker (PCT) Label Cannot be blank";
		parent.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
	}
	//ML-MMOH-CRF-0406 ENDS
	
	//ML-MMOH-CRF-0412 Starts
	else if(attendantOrderApplicableYn==true &&  (attendantcount<=0 || attendantcount=='' || attendantcount>9)){
		var error="Maximum "+Attendent_Name+" Orders Allowed (For Each Day) should be minimum 1 and maximum 9";
		parent.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
	}		
	//ML-MMOH-CRF-0412 ENDS
	//ML-MMOH-CRF-0600 Start
	//For OP/EM
	
	
	else if(formObj.querySelector("#allow_op_em_yn").checked == true && formObj.querySelector("#op_served_yn").value == "N" && formObj.querySelector("#op_accept_yn").value =="N"){
	 var error = getMessage("DS_STATUS_IP_OP_EM","DS");
	 parent.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
	 return false;
	}
 
	
	//For IP
	
	
	else if(formObj.querySelector("#allow_ip_yn").checked == true && formObj.querySelector("#ip_MealPrepared_yn").value == "N" && formObj.querySelector("#ip_MealServed_yn").value =="N" && formObj.querySelector("#ip_MealReceived_yn").value =="N"){
 
	var error = getMessage("DS_STATUS_IP_OP_EM","DS");
	 parent.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
	return false;
 
 }

	else return true;
}

function enableKitchen(){

	if(document.getElementById("multiKitchenYn").checked==true){
	   document.getElementById("kitchenCode").disabled=false;
	  }else{
		  document.getElementById("kitchenCode").value="";
		document.getElementById("kitchenCode").disabled=true;
	}
}

function query(){}
//ML-MMOH-CRF-0427 Starts
function chkBoxValue(obj){
var formObj = document.forms[0];
//Added Against ML-MMOH-CRF-1061 US2 Starts Here
var OP_served = formObj.querySelector("#OPstatus_Ser_YN").value;
var MealPrepared = formObj.querySelector("#IPstatus_Pre_YN").value;
var MealReceived = formObj.querySelector("#IPstatus_Rec_YN").value;
//Added Against ML-MMOH-CRF-1061 US2 Ends Here
if(obj.checked)
	obj.value="Y";
else
	obj.value="N";

if(obj.name == "RestrictDateRangeforInpatientsYN"){	
	if(obj.checked==false){
		formObj.MaximumDaysAllowed.disabled=true;
		//formObj.MaximumDaysAllowed.value="";
		document.getElementById('count_check').style.visibility='hidden';
	}else{
		formObj.MaximumDaysAllowed.disabled=false;
		formObj.RestrictDateRangeforInpatientsYN.value="Y";
		document.getElementById('count_check').style.visibility='visible';
	}
}

//ML-MMOH-CRF-409 starts
if(obj.name == "acceptDietForIndMealYn"){	
	if(obj.checked==false){
			formObj.LATE_IRREGULAR_DIET_ORD_FOR_IP.disabled=true;
			formObj.LATE_IRREGULAR_DIET_ORD_FOR_IP.checked=false;//409
			formObj.NotificationMessageforPlaceDietOrder.disabled=true;
			//formObj.MaximumDaysAllowed.value="";
			//document.getElementById('count_check').style.visibility='hidden'
	}else{
		formObj.LATE_IRREGULAR_DIET_ORD_FOR_IP.disabled=false;
		if(formObj.LATE_IRREGULAR_DIET_ORD_FOR_IP.checked==true){
			
			formObj.NotificationMessageforPlaceDietOrder.disabled=false;
		}
			//formObj.RestrictDateRangeforInpatientsYN.value="Y";
			//document.getElementById('count_check').style.visibility='visible'
	}
}
//CRF-600 & Modified Against ML-MMOH-CRF-1061 US2 Starts Here
if(obj.name == "allow_op_em_yn"){	
	if(obj.checked==false){
			formObj.op_served_yn.disabled=true;
			formObj.op_accept_yn.disabled=true;
			formObj.op_served_yn.checked=false;
			formObj.op_accept_yn.checked=false;
			
	}else{
		if(OP_served=="Y"){
			formObj.op_served_yn.disabled=false;
		}else{
			formObj.op_served_yn.disabled=true;
		} 
		formObj.op_accept_yn.disabled=false;
		
	}
}

if(obj.name == "allow_ip_yn"){	

	if(obj.checked==false){
			formObj.ip_MealPrepared_yn.disabled=true;
			formObj.ip_MealReceived_yn.disabled=true;
			formObj.ip_MealServed_yn.disabled=true;
			formObj.ip_MealPrepared_yn.checked=false;
			formObj.ip_MealReceived_yn.checked=false;
			formObj.ip_MealServed_yn.checked=false;
			
	}else{
		if(MealPrepared=="Y"){
			formObj.ip_MealPrepared_yn.disabled=false;
		}else{
			formObj.ip_MealPrepared_yn.disabled=true;
		}
		if(MealReceived=="Y"){
			formObj.ip_MealReceived_yn.disabled=false;
		}else{
			formObj.ip_MealReceived_yn.disabled=true;
		}
		formObj.ip_MealServed_yn.disabled=false;
	}
}
//CRF-600 & Modified Against ML-MMOH-CRF-1061 US2 Ends Here
if(obj.name=="LATE_IRREGULAR_DIET_ORD_FOR_IP")
{
	if(obj.checked==true){
		formObj.NotificationMessageforPlaceDietOrder.disabled=false;
		
	}else{
		
		formObj.NotificationMessageforPlaceDietOrder.disabled=true;
	
	}
}	
//ML-MMOH-CRF-409 ends

//ML-MMOH-CRF-0412 Starts
if(obj.name=="attendantOrderApplicableYn"){
	if(obj.checked==true){
		formObj.attendantcount.disabled=false;
		formObj.attendant_count_check.style.visibility="visible";
	}else{
		formObj.attendantcount.disabled=true;
		formObj.attendant_count_check.style.visibility="hidden";
	}
}
//ML-MMOH-CRF-0412 ENDS

return true;
}
//ML-MMOH-CRF-0427 Ends
//CRF-600 Starts & Modified Against ML-MMOH-CRF-1061 US2 Starts Here
function CheckAllow(){
var formObj = document.forms[0];
var OP_served = formObj.querySelector("#OPstatus_Ser_YN").value;
var OP_accepted = formObj.querySelector("#OPstatus_Acc_YN").value;//67113
var MealPrepared = formObj.querySelector("#IPstatus_Pre_YN").value;
var MealReceived = formObj.querySelector("#IPstatus_Rec_YN").value;
var MealServed = formObj.querySelector("#IPstatus_Ser_YN").value;//67113
if(formObj.querySelector("#allow_op_em_yn").checked == false){
	if(OP_served=="Y"){
		formObj.op_served_yn.disabled=true;
		formObj.op_served_yn.checked=true;
	}else{
		formObj.op_served_yn.disabled=true;
	}
	if(OP_accepted=="Y"){
		formObj.op_accept_yn.disabled=true;
		formObj.op_accept_yn.checked=true;
	}
	else{
		formObj.op_accept_yn.disabled=true;
	}
}else{
	if(OP_served=="Y"){
		formObj.op_served_yn.disabled=false;
	}else{
		formObj.op_served_yn.disabled=true;
		formObj.op_served_yn.checked=false;
	}
	formObj.op_accept_yn.disabled=false;
}	
if(formObj.querySelector("#allow_ip_yn").checked == false){
	if(MealPrepared=="Y"){
		formObj.ip_MealPrepared_yn.disabled=true;
		formObj.ip_MealPrepared_yn.checked=true;
	}
	else{
		formObj.ip_MealPrepared_yn.disabled=true;
	}
	if(MealReceived=="Y"){
		formObj.ip_MealReceived_yn.disabled=true;
		formObj.ip_MealReceived_yn.checked=true;
	}
	else{
		formObj.ip_MealReceived_yn.disabled=true;
	}
	if(MealServed=="Y"){
		formObj.ip_MealServed_yn.disabled=true;
		formObj.ip_MealServed_yn.checked=true;
	}
	else{
		formObj.ip_MealServed_yn.disabled=true;
	}
}else{
		if(MealPrepared=="Y"){
			formObj.ip_MealPrepared_yn.disabled=false;
		}			
		else{
			formObj.ip_MealPrepared_yn.disabled=true;
			formObj.ip_MealPrepared_yn.checked=false;
		}
		if(MealReceived=="Y"){
			formObj.ip_MealReceived_yn.disabled=false;
		}			
		else{
			formObj.ip_MealReceived_yn.disabled=true;
			formObj.ip_MealReceived_yn.checked=false;
		}
		formObj.ip_MealServed_yn.disabled=false;
	}
}
//CRF-600 Starts & Modified Against ML-MMOH-CRF-1061 US2 Ends Here
