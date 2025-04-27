async function searchCode(obj){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	globalDrugRelated  = new Array() ;
	var formObj		   = document.Dispensestaticcriteriaform;
	dataNameArray[0]   = "FACILITY_ID" ;
	dataValueArray[0]  = formObj.p_facility_id.value;
	dataTypeArray[0]   = STRING ;
	argumentArray[0]   = formObj.SQL_PH_DISP_STAT_AGE_GROUP_SELECT1.value+"'"+formObj.p_language_id.value+"' ORDER BY 2";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,3";
	argumentArray[5]   = formObj.disp_loc_desc.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	var retVal = await CommonLookup( getLabel("ePH.DispenseLocation.label","PH"), argumentArray );
	var ret1=unescape(retVal);
 	arr=ret1.split(",");
	//var retVal = CommonLookup("Dispense Location Lookup", argumentArray );
	if(retVal != null && retVal != "" ){
		formObj.disp_loc_desc.value = arr[1];
		formObj.p_disp_locn_code.value = arr[0];
	}
}

async function Summarize(obj){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var formObj		   = document.Dispensestaticcriteriaform;
	argumentArray[0]   = formObj.SQL_PH_DISP_STAT_AGE_GROUP_SELECT2.value+"'"+formObj.p_language_id.value+"' ORDER BY 2";		
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = formObj.p_summ_age_group_desc.value ;//summ_age_group_desc to p_summ_age_group_desc for MMS-QH-CRF-0109[Inc:39377]
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	var retVal = await CommonLookup( getLabel("Common.AgeRange.label","Common"), argumentArray );//ePH.summarizeby.label changed to getLabel("Common.AgeRange.label","Common")
	var ret1=unescape(retVal);
 	arr=ret1.split(",");
	if(retVal != null && retVal != "" ){
		formObj.p_summ_age_group_desc.value = arr[1];//summ_age_group_desc to p_summ_age_group_desc for MMS-QH-CRF-0109[Inc:39377]
		formObj.p_summ_range_id.value = arr[0];
	}
}

async function Nationality(obj){ 
   if(obj.value!= ""){
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var formObj		   = document.Dispensestaticcriteriaform;
		argumentArray[0]   = formObj.SQL_PH_DISP_STAT_AGE_GROUP_SELECT3.value; 
		argumentArray[1]   = dataNameArray ;
		argumentArray[2]   = dataValueArray ;
		argumentArray[3]   = dataTypeArray ;
		argumentArray[4]   = "1,2";
		argumentArray[5]   = formObj.nationality_group_desc.value ;
		argumentArray[6]   = DESC_LINK ;
		argumentArray[7]   = CODE_DESC ;
		var retVal = await CommonLookup( getLabel("Common.nationality.label","Common"), argumentArray );
		var ret1=unescape(retVal);
	 	arr=ret1.split(",");
		if(retVal != null && retVal != "" ){
			formObj.nationality_group_desc.value = arr[1];
			formObj.p_stat_grp_id.value = arr[0];
		}
	}
	else
		document.Dispensestaticcriteriaform.p_stat_grp_id.value = "";
}

function checkDateWithSysDate(entered_date,sys_date){
	//alert("inside 261");
	var enteredDateArray; 
	var sysDateArray;
	var enteredDate = entered_date.value ;
	var sysDate = sys_date.value;

	if(enteredDate.length > 0 && sysDate.length > 0 ){
		enteredDateArray = enteredDate.split("/");
		sysDateArray = sysDate.split("/");
		var enteredDateObject = new Date(enteredDateArray[2],(enteredDateArray[1]-1),enteredDateArray[0]);
		var sysDateObject = new Date(sysDateArray[2],(sysDateArray[1]-1),sysDateArray[0]);	
		if(Date.parse(sysDateObject) < Date.parse(enteredDateObject)){
			/*  * If the sys_date is less than the entered_date date,
			  * i.e., The Entered date is greater than the Current System Date
			  * Then return false to indicate it is wrong..*/
			return false;
		}
		else if(Date.parse(sysDateObject) >= Date.parse(enteredDateObject)) return true;
	}	
	return true;
}
// the below method is used for leap year calculation
function CheckDateT(obj){
	var locale=document.Dispensestaticcriteriaform.p_language_id.value;
	if(obj.value!=""){
		if(!validDate(obj.value, 'DMY',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			obj.select();
			obj.focus();
			return false;
		}
		ValidateFromDt();//Added for INC : 48027
	}
}
/*function validate_date(Obj,ref) {
	if (CheckDate(Obj))	{
	 if(ref == "TO_DT_GR_EQ_FM_DT"){
	  from = document.forms[0].p_disp_date_to;
	  to = document.forms[0].p_disp_date_from;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','PH');
	}
		else if(ref == "TO_DT_GR_EQ_FM_DT1"){
	  from = document.forms[0].p_disp_date_from;
	  to = document.forms[0].p_disp_date_to;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','PH');
	}
	else if(ref == "TO_DATE_LESS_FROM"){
	  from = document.forms[0].p_disp_date_to;
	  to = document.forms[0].p_disp_date_from;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','PH');
	}
	var fromarray;
	var toarray;
	var fromdate = eval(from).value ;
	var todate = eval(to).value ;
	if(fromdate.length > 0 && todate.length > 0 ) {
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(todt) > Date.parse(fromdt)) {		   
			alert(error_id);
 		    from.focus();
		}
		else if(Date.parse(todt) <= Date.parse(fromdt))
		     {
	       //parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num= ";
		       return true;
		      } 
	}
	return true;
}
}*/

function run() {
	var formObj		   = searchFrame.document.Dispensestaticcriteriaform;
	//validateAgeGroup(formObj);//Added for MMS-QH-CRF-0109[Inc: 39377]
	if(searchFrame.document.Dispensestaticcriteriaform) {
		//var fields= new Array (formObj.disp_loc_desc,formObj.p_disp_date_from, formObj.p_disp_date_to,formObj.summ_age_group_desc,formObj.nationality_group_desc);Commented for MMS-QH-CRF-0109[Inc: 39377]
		var fields;//Added for MMS-QH-CRF-0109[Inc: 39377]-Start
		var names;
		 if(formObj.p_age_by.options[formObj.p_age_by.selectedIndex].value=="A"){
			 fields= new Array (formObj.disp_loc_desc,formObj.disp_date_from, formObj.disp_date_to,formObj.p_summ_age_group_desc);//,formObj.nationality_group_desc,summ_age_group_desc to p_summ_age_group_desc for MMS-QH-CRF-0109[Inc:39377] && p_disp_date_from to disp_date_from && p_disp_date_to to disp_date_to for Inc : 48027
			 names= new Array (getLabel("ePH.DispenseLocation.label","PH"),getLabel("ePH.DispenseDateFrom.label","PH"),getLabel("Common.todate.label","Common"),getLabel("Common.AgeRange.label","Common"));//,getLabel("Common.nationality.label","Common"),ePH.summarizeby.label commented and add Common.AgeRange.label for Linked Inc : 48027
		  }
		  else{
			  fields= new Array (formObj.disp_loc_desc,formObj.disp_date_from, formObj.disp_date_to,formObj.p_durn_frm,formObj.p_durn_to);//commented nationality_group_desc and added from and to for MMS-QH-CRF-0109[Inc: 39377] && p_disp_date_from to disp_date_from && p_disp_date_to to disp_date_to for Inc : 48027 
			  names= new Array (getLabel("ePH.DispenseLocation.label","PH"),getLabel("ePH.DispenseDateFrom.label","PH"),getLabel("Common.todate.label","Common"),(getLabel("Common.AgeRange.label","Common")+"&nbsp;"+getLabel("Common.from.label","Common")),(getLabel("Common.AgeRange.label","Common")+"&nbsp;"+getLabel("Common.to.label","Common")));//commented getLabel("Common.nationality.label","Common") and added from and to label for MMS-QH-CRF-0109[Inc: 39377] AND  AgeRange Label Added for INC : 48027 
		   }//Added for MMS-QH-CRF-0109[Inc: 39377]-End
		//var names= new Array (getLabel("ePH.DispenseLocation.label","PH"),getLabel("ePH.DispenseDateFrom.label","PH"),getLabel("Common.todate.label","Common"),getLabel("ePH.summarizeby.label","PH"),getLabel("Common.nationality.label","Common"));Commented for MMS-QH-CRF-0109[Inc: 39377]
		if(checkFields(fields,names,messageFrame)) {
			formObj.p_disp_date_from.value = convertDate(formObj.disp_date_from.value,'DMY',formObj.p_language_id.value,'en');//p_disp_date_from to disp_date_from && p_disp_date_to to disp_date_to for Inc : 48027
			formObj.p_disp_date_to.value = convertDate(formObj.disp_date_to.value,'DMY',formObj.p_language_id.value,'en');//p_disp_date_from to disp_date_from && p_disp_date_to to disp_date_to for Inc : 48027
			if(formObj.p_report_by.value == 'S')
				formObj.p_report_id.value='PHBDSTAG';
			else
				formObj.p_report_id.value='PHBDSTAGDTL';
					
			searchFrame.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
			searchFrame.document.forms[0].target="messageFrame";
			searchFrame.Dispensestaticcriteriaform.submit();
		}
	}
}

function reset() {
	searchFrame.Dispensestaticcriteriaform.reset();
	if(searchFrame.Dispensestaticcriteriaform.p_age_by.options[searchFrame.Dispensestaticcriteriaform.p_age_by.selectedIndex].value=="A"){ //Added if block for MMS-QH-CRF-0109[Inc:39377]-Start
		searchFrame.Dispensestaticcriteriaform.lblGender.style.display='none';
		searchFrame.Dispensestaticcriteriaform.fldGender.style.display='none';
		searchFrame.Dispensestaticcriteriaform.ageRangeFrom.style.display='none';
		searchFrame.Dispensestaticcriteriaform.ageRangeTo.style.display='none';
		searchFrame.Dispensestaticcriteriaform.lblAgreGroup.style.display='inline';
		searchFrame.Dispensestaticcriteriaform.fldAgreGroup.style='display';
	 }
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}
function validateDate(){
	var formObj = document.frames.Dispensestaticcriteriaform;
	if (formObj.disp_date_from.value!="" && formObj.disp_date_to.value!=""){//p_disp_date_from to disp_date_from && p_disp_date_to to disp_date_to for Inc : 48027
		if(!doDateCheck(formObj.dt_from_disp,formObj.disp_date_to,parent.messageFrame)){
			formObj.disp_date_to.select();
		}
		else{
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
		}
	}
}

function displayfields(){//Added below function for MMS-QH-CRF-0109[Inc: 39377]-Start
	var formObj=document.Dispensestaticcriteriaform;
	if(formObj.p_age_by.options[formObj.p_age_by.selectedIndex].value=="U"){
		document.getElementById("lblGender").style='display';
		document.getElementById("fldGender").style='display';
		document.getElementById("ageRangeFrom").style='display';
		document.getElementById("ageRangeTo").style='display';
		document.getElementById("lblAgreGroup").style.display='none';
		document.getElementById("fldAgreGroup").style.display='none';
	//	formObj.p_gender_by.value='';Commented for MMS-QH-CRF-0109[Inc:39377]
		formObj.p_durn_frm.value='';//durn_fr to p_durn_frm for MMS-QH-CRF-0109[Inc:39377]
		//formObj.p_durn_type_fr.value='';
		 formObj.p_durn_to.value='';//durn_to to p_durn_to for MMS-QH-CRF-0109[Inc:39377]
		//formObj.p_durn_type_to.value='';
		formObj.p_summ_range_id.value='';
		formObj.p_summ_age_group_desc.value='';//summ_age_group_desc to p_summ_age_group_desc for MMS-QH-CRF-0109[Inc:39377]
	}
	else{
		document.getElementById("lblGender").style.display='none';
		document.getElementById("fldGender").style.display='none';
		document.getElementById("ageRangeFrom").style.display='none';
		document.getElementById("ageRangeTo").style.display='none';
		document.getElementById("lblAgreGroup").style='display';
		document.getElementById("fldAgreGroup").style='display';
		formObj.p_gender_by.value='';
		formObj.p_durn_frm.value='';//durn_fr to p_durn_frm for MMS-QH-CRF-0109[Inc:39377]
		//formObj.p_durn_type_fr.value='';
		formObj.p_summ_range_id.value='';
		formObj.p_summ_age_group_desc.value='';
		Summarize();//Code added for MMS-QH-CRF-0109[IN039377]		
	}
}

function assignAgeRangeDurnType(obj,curr_value){
  var formObj=document.Dispensestaticcriteriaform;
  if(curr_value == '2')
	  formObj.p_durn_type_to.value =  obj.value;
  else if(curr_value == '1')
	  formObj.p_durn_type_fr.value =  obj.value;
}	

function ValidateFromDt(){
	formObj = document.Dispensestaticcriteriaform;
	var from_date=formObj.disp_date_from.value;//p_disp_date_from to disp_date_from && p_disp_date_to to disp_date_to for Inc : 48027 
	var to_date=formObj.disp_date_to.value;
	var locale=formObj.p_language_id.value;
	if(to_date!='' && to_date !='' ){
		if(!isBefore(from_date,to_date, "DMY",locale)){
			alert(getMessage("FROM_DATE_LESS_EQ_TO_DT", "PH"));
			formObj.disp_date_to.value='';
			formObj.disp_date_to.focus();
		}
	}
}

async function CustomerGroupSearch(target,validate){ 
	if(target.value != ""  || validate == '2'){	//Code added for MMS-QH-CRF-0109[IN039377]
		var frmObject = document.Dispensestaticcriteriaform; 
		var argumentArray	= new Array() ;
		var dataNameArray	= new Array() ;
		var dataValueArray	= new Array() ;
		var dataTypeArray	= new Array() ;
		var lan_id=frmObject.p_language_id.value;
		argumentArray[0] = frmObject.SQL_PH_CUSTOMER_GROUP_SELECT.value+"'"+lan_id+"' ORDER BY 2";
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] =target.value;
		argumentArray[6] = DESC_LINK ;
		argumentArray[7] = DESC_CODE ;
		retVal = await CommonLookup( getLabel("ePH.CustomerGroup.label","PH"), argumentArray );
		var ret1=unescape(retVal);
	 	arr=ret1.split(",");
		if(retVal != null && retVal != "") {
			frmObject.p_customer_group.value = arr[1];
			frmObject.P_CUST_GROUP_CODE.value = arr[0];
		}
	}	//Code added for MMS-QH-CRF-0109[IN039377] --start
	else
		document.Dispensestaticcriteriaform.P_CUST_GROUP_CODE.value = "";//Code added for MMS-QH-CRF-0109[IN039377] --End
}

async function CustomerSearch(target,validate){
	if(target.value != "" || validate == '2'){ //Code added for MMS-QH-CRF-0109[IN039377] 
		var frm_obj = document.Dispensestaticcriteriaform;		
		var argumentArray	= new Array() ;
		var dataNameArray	= new Array() ;
		var dataValueArray	= new Array() ;
		var dataTypeArray	= new Array() ;
		var lan_id=frm_obj.p_language_id.value;
		argumentArray[0] = frm_obj.SQL_PH_CUSTOMER_SELECT.value+"'"+lan_id+"' ORDER BY 2";
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = DESC_LINK ;
		argumentArray[7] = DESC_CODE ;
		retVal = await CommonLookup( getLabel("Common.Customer.label","PH"), argumentArray );
		var ret1=unescape(retVal);
	 	arr=ret1.split(",");
		if(retVal != null && retVal != "") {
			frm_obj.p_customer.value = arr[1];
			frm_obj.P_CUST_CODE.value = arr[0];
		}
	}	//Code added for MMS-QH-CRF-0109[IN039377] --Start
	else
		document.Dispensestaticcriteriaform.P_CUST_CODE.value = ""; //Code added for MMS-QH-CRF-0109[IN039377] --End 
	
} //Code added for MMS-QH-CRF-0109[IN039377] --End
