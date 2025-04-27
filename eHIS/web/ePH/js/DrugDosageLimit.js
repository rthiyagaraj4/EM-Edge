/*
---------------------------------------------------------------------------------------------------------------
Date       	  Edit History          Name        		Rev.Date		Rev.Name 		Description
---------------------------------------------------------------------------------------------------------------
26/06/2019     IN:070451            Haribabu            26/06/2019                      ML-MMOH-CRF-1408
---------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

var function_id = "PH_DOSAGE_LIMIT" ;
var result = false ;
var message = "" ;
var flag = "" ;

var globalGender= new Array();
var globalMinAge= new Array();
var globalMaxAge= new Array();
var globalAgeUnit=new Array();

var globalDrugRelated= new Array();

var index=0;

function create() {
    f_query_add_mod.location.href="../../ePH/jsp/DrugDosageLimitAddModify.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
}
function query(){
	f_query_add_mod.location.href="../../ePH/jsp/DrugDosageLimitQueryCriteria.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
}
function deleterecord(){
	
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();

	if ( (url.indexOf("drugdosagelimitaddmodify")==-1) ) { 
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		return false;
	}
	else {
		if (f_query_add_mod.document.formDrugDosageLimit.mode.value == MODE_MODIFY) {
			f_query_add_mod.document.formDrugDosageLimit.mode.value = MODE_DELETE;
			if (confirm(f_query_add_mod.getMessage("DELETE_RECORD","Common")))
				apply();
			else {
				f_query_add_mod.document.formDrugDosageLimit.mode.value = MODE_MODIFY;
				messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
			}
		}
		else {
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
			return false;
		}
	}
}

function apply() {

	
	if(!checkIsValidForProceed()){
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";	
		return false;
	}
	var formObj = f_query_add_mod.document.formDrugDosageLimit ;
	var mode	= formObj.mode.value;
	//Modified for IN:070451 START
	var unit		=	formObj.calc_dosage_by.value;
	var mand_check = false;
	if( mode == MODE_INSERT ) {
		if(unit=="A"){
		var fields = new Array ( formObj.drug_desc ,formObj.age_group_code,formObj.low_of_unit_dosage,formObj.high_of_unit_dosage,formObj.std_unit_dosage,formObj.low_of_daily_dosage,formObj.high_of_daily_dosage);
		var names = new Array ( getLabel("Common.DrugName.label","Common"),getLabel("Common.agegroup.label","Common"),getLabel("ePH.MinimumUnitDose.label","PH"),getLabel("ePH.MaximumUnitDose.label","PH"),getLabel("ePH.StandardUnitDose.label","PH"),getLabel("ePH.MinimumDailyDose.label","PH"),getLabel("ePH.MaximumDailyDose.label","PH"));
		 mand_check = f_query_add_mod.checkFields( fields, names, messageFrame);
		}
		else{
			mand_check=true;
		}
		if(mand_check) {
			if (validateDosage(unit)){//Modified for IN:070451 end
				eval(formApply( formObj,PH_CONTROLLER ));
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;	
				if( result ) {
					onSuccess();		
				}
			}
		}
	}
	if (mode==MODE_DELETE){
		eval( formApply( formObj, PH_CONTROLLER ) ) ;
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
		if( result ) {
			onSuccess();	
		}
	}	
	if( mode == MODE_MODIFY ) {
	//Modified for IN:070451 START
		if(unit=="A"){
		var fields = new Array ( formObj.low_of_unit_dosage,formObj.high_of_unit_dosage,formObj.low_of_daily_dosage,formObj.high_of_daily_dosage,formObj.std_unit_dosage);
		var names = new Array (getLabel("ePH.MinimumUnitDose.label","PH"),getLabel("ePH.MaximumUnitDose.label","PH"),getLabel("ePH.MinimumDailyDose.label","PH"),getLabel("ePH.MaximumDailyDose.label","PH"),getLabel("ePH.StandardUnitDose.label","PH"));
		mand_check = f_query_add_mod.checkFields( fields, names, messageFrame);
		}
		else{
			mand_check=true;
		}
		if(mand_check) {
			if (validateDosage(unit)){//Modified for IN:070451 end
				eval(formApply( formObj,PH_CONTROLLER ));
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;	
				if( result ) {
					onSuccess();		
				}
			}
		}
	}
}

function beforePost(xmlStr){
			//alert("In :"+xmlStr)
}
function onSuccess() {
	var mode = f_query_add_mod.document.formDrugDosageLimit.mode.value;

	if (mode==MODE_INSERT ){
		create();
	}
	else if (mode==MODE_DELETE){
		f_query_add_mod.location.href="../../eCommon/html/blank.html";
	}
}
function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

function defaultUnit() {
	//alert("inside default unnit");
	var unit		=	document.formDrugDosageLimit.calc_dosage_by.value;
	cellingDoseVissable(unit);//Added for IN:070451
	var mode		= document.formDrugDosageLimit.mode.value;
	//alert("unit====||"+unit+ "|========mode======|" +mode);
	var unit_val	=	"";
	if(unit=="B") {
		unit_val	=	getLabel("ePH.Mtsq.label","PH");
		document.getElementById("dose_unit_1").innerText=""+globalDrugRelated[9]+"/"+unit_val;
		document.getElementById("dose_unit_2").innerText=""+globalDrugRelated[9]+"/"+unit_val;
		document.getElementById("dose_unit_3").innerText=""+globalDrugRelated[9]+"/"+unit_val;
		document.getElementById("dose_unit_4").innerText=""+globalDrugRelated[9]+"/"+unit_val;
		document.getElementById("dose_unit_5").innerText=""+globalDrugRelated[9]+"/"+unit_val;
		//Added for IN:070451 start
		document.getElementById("dose_unit_20").innerText=""+globalDrugRelated[9];
		document.getElementById("dose_unit_21").innerText=""+globalDrugRelated[9];
		document.getElementById("dose_unit_23").innerText=""+globalDrugRelated[9];
		document.getElementById("dose_unit_24").innerText=""+globalDrugRelated[9];
		//Added for IN:070451 end

		if (mode!="2"){
			document.formDrugDosageLimit.limit_ind[0].checked = true;
			document.formDrugDosageLimit.limit_ind[1].checked = false;
		}
		document.formDrugDosageLimit.limit_ind[0].disabled = true;
		document.formDrugDosageLimit.limit_ind[1].disabled = true;
	}
	else if(unit=="W") {
		unit_val	=	getLabel("Common.kg.label","Common");
		document.getElementById("dose_unit_1").innerText=""+globalDrugRelated[9]+"/"+unit_val;
		document.getElementById("dose_unit_2").innerText=""+globalDrugRelated[9]+"/"+unit_val;
		document.getElementById("dose_unit_3").innerText=""+globalDrugRelated[9]+"/"+unit_val;
		document.getElementById("dose_unit_4").innerText=""+globalDrugRelated[9]+"/"+unit_val;
		document.getElementById("dose_unit_5").innerText=""+globalDrugRelated[9]+"/"+unit_val;
		//Added for IN:070451 start
		document.getElementById("dose_unit_20").innerText=""+globalDrugRelated[9];
		document.getElementById("dose_unit_21").innerText=""+globalDrugRelated[9];
		document.getElementById("dose_unit_23").innerText=""+globalDrugRelated[9];
		document.getElementById("dose_unit_24").innerText=""+globalDrugRelated[9];
		//Added for IN:070451 end

		if (mode!="2"){
			document.formDrugDosageLimit.limit_ind[0].checked = true;
			document.formDrugDosageLimit.limit_ind[1].checked = false;
		}
		document.formDrugDosageLimit.limit_ind[0].disabled = true;
		document.formDrugDosageLimit.limit_ind[1].disabled = true;
	}
	else if(unit=="A") {
		//alert("if unit==A===>" +unit);
		
		unit_val	=	getLabel("ePH.Gram.label","PH");
		if (globalDrugRelated[9]!='null' && globalDrugRelated[9]!=undefined)
			unit_val	=globalDrugRelated[9];	
		//alert("unit_val===154===>" +unit_val);
		if(document.formDrugDosageLimit.limit_ind[1].checked)
			unit_val	=globalDrugRelated[8];	
		if (unit_val=='null' || unit_val==undefined)
			unit_val="";

		//if(unit_val!="" && mode!="1") {
		if(unit_val!="") {
			document.getElementById("dose_unit_1").innerText=""+unit_val;
			document.getElementById("dose_unit_2").innerText=""+unit_val;
			document.getElementById("dose_unit_3").innerText=""+unit_val;
			document.getElementById("dose_unit_4").innerText=""+unit_val;
			document.getElementById("dose_unit_5").innerText=""+unit_val;
			//Added for IN:070451 start
			document.getElementById("dose_unit_20").innerText="";
			document.getElementById("dose_unit_21").innerText="";
			document.getElementById("dose_unit_23").innerText="";
			document.getElementById("dose_unit_24").innerText="";
			//Added for IN:070451 end
			
		}

		if (mode!="2"){
			document.formDrugDosageLimit.limit_ind[0].checked = true;
			document.formDrugDosageLimit.limit_ind[1].checked = false;
		}
		document.formDrugDosageLimit.limit_ind[0].disabled = false;
		document.formDrugDosageLimit.limit_ind[1].disabled = false;
	}

	if(unit=="A") {
		document.formDrugDosageLimit.std_unit.value	= globalDrugRelated[7];
	} 
	else {
		document.formDrugDosageLimit.std_unit.value	= globalDrugRelated[9];
	}
	if(document.formDrugDosageLimit.strength_value.value!="" && mode!="2")
		document.formDrugDosageLimit.calc_dosage_by.disabled=false;
}

function validateDosage(unit){//Added for IN:070451
	
	var formObj = f_query_add_mod.document.formDrugDosageLimit ;
	if(unit=="A"){//Added for IN:070451
		if (parseFloat(formObj.low_of_unit_dosage.value) > parseFloat(formObj.high_of_unit_dosage.value)){
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("PH_MIN_UNIT_DOSE_LESS_MAX","PH");	
			formObj.high_of_unit_dosage.select();
			return false;
		}
		else if (parseFloat(formObj.low_of_unit_dosage.value) > parseFloat(formObj.std_unit_dosage.value)){
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("PH_MIN_UNIT_DOSE_LESS_STD","PH");	
			formObj.high_of_unit_dosage.select();
			return false;
		}
		else if (parseFloat(formObj.high_of_unit_dosage.value) < parseFloat(formObj.std_unit_dosage.value)){
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("PH_MAX_UNIT_DOSE_LESS_STD","PH");	
			formObj.high_of_unit_dosage.select();
			return false;
		}
		else if (parseFloat(formObj.low_of_daily_dosage.value) > parseFloat(formObj.high_of_daily_dosage.value)){
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("PH_MIN_DAILY_DOSE_LESS_MAX","PH");	
			formObj.high_of_daily_dosage.select();
			return false;
		}
		else if (parseFloat(formObj.low_of_unit_dosage.value) > parseFloat(formObj.low_of_daily_dosage.value)){
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("UNIT_DOSE_LESS_THAN_DAILY_DOSE","PH");	
			return false;
		}
		else if (parseFloat(formObj.high_of_unit_dosage.value) > parseFloat(formObj.high_of_daily_dosage.value)){
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("UNIT_DOSE_GREATER_THAN_DAILY_DOSE","PH");	
			return false;
		}
		//Added for IN:070451 START
		return true;	
	}
	else
	{
		if ((formObj.drug_desc.value)=="" ){
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("DRUG_CANT_BE_BLANK","PH");
			formObj.drug_desc.select();
			return false;
		}
		else if ((formObj.age_group_code.value)==""){
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("AGE_GROUP_CANT_BE_BLANK","PH");

			return false;
		}
		else if (((formObj.low_of_unit_dosage.value)=="" && (formObj.low_celling_of_unit_dosage.value)=="")){
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("MIN_UNIT_DOSE_OR_CELLING_DOSE_CANNOT_BLANK","PH");
			formObj.low_of_unit_dosage.select();
			return false;
		}
		else if (((formObj.high_of_unit_dosage.value)=="" && (formObj.high_celling_of_unit_dosage.value)=="")){
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("MAX_UNIT_DOSE_OR_CELLING_DOSE_CANNOT_BLANK","PH");	
			formObj.high_of_unit_dosage.select();
			return false;
		}
		else if (((formObj.low_of_daily_dosage.value)=="" && (formObj.low_celling_of_daily_dosage.value)=="")){
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("MIN_DAILY_DOSE_OR_CELLING_DOSE_CANNOT_BLANK","PH");	
			formObj.low_of_daily_dosage.select();
			return false;
		}
		else if (((formObj.high_of_daily_dosage.value)=="" && (formObj.high_celling_of_daily_dosage.value)=="")){
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("MAX_DAILY_DOSE_OR_CELLING_DOSE_CANNOT_BLANK","PH");	
			formObj.high_of_daily_dosage.select();
			return false;
		}
		else if (((formObj.std_unit_dosage.value)=="" )){
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("STD_UNIT_DOSE_CANT_BE_BLANK","PH");	
			formObj.std_unit_dosage.select();
			return false;
		}
		else if ((parseFloat(formObj.low_of_unit_dosage.value) > parseFloat(formObj.high_of_unit_dosage.value)) && (!((formObj.low_of_unit_dosage.value)=="" || (formObj.high_of_unit_dosage.value)==""))){
		    messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("PH_MIN_UNIT_DOSE_LESS_MAX","PH");	
			formObj.low_of_unit_dosage.select();
			return false;
		}
		else if ((parseFloat(formObj.low_of_unit_dosage.value) > parseFloat(formObj.std_unit_dosage.value)) && (!((formObj.low_of_unit_dosage.value)=="" || (formObj.std_unit_dosage.value)==""))){
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("PH_MIN_UNIT_DOSE_LESS_STD","PH");	
			formObj.low_of_unit_dosage.select();
			return false;
		}
		else if ((parseFloat(formObj.high_of_unit_dosage.value) < parseFloat(formObj.std_unit_dosage.value)) && (!((formObj.high_of_unit_dosage.value)=="" || (formObj.std_unit_dosage.value)==""))){
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("PH_MAX_UNIT_DOSE_LESS_STD","PH");	
			formObj.high_of_unit_dosage.select();
			return false;
		}
		else if ((parseFloat(formObj.low_of_daily_dosage.value) > parseFloat(formObj.high_of_daily_dosage.value)) && (!((formObj.low_of_daily_dosage.value)=="" || (formObj.high_of_daily_dosage.value)==""))){
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("PH_MIN_DAILY_DOSE_LESS_MAX","PH");	
			formObj.low_of_daily_dosage.select();
			return false;
		}
		else if ((parseFloat(formObj.low_of_unit_dosage.value) > parseFloat(formObj.low_of_daily_dosage.value)) && (!((formObj.low_of_unit_dosage.value)=="" || (formObj.low_of_daily_dosage.value)==""))){
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("UNIT_DOSE_LESS_THAN_DAILY_DOSE","PH");
			formObj.low_of_unit_dosage.select();
			return false;
		}
		else if ((parseFloat(formObj.high_of_unit_dosage.value) > parseFloat(formObj.high_of_daily_dosage.value)) && (!((formObj.high_of_unit_dosage.value)=="" || (formObj.high_of_daily_dosage.value)==""))){
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("UNIT_DOSE_GREATER_THAN_DAILY_DOSE","PH");
			formObj.high_of_unit_dosage.select();
			return false;
		}
		else if ((parseFloat(formObj.low_of_unit_dosage.value) > parseFloat(formObj.low_celling_of_unit_dosage.value)) && (!((formObj.low_of_unit_dosage.value)=="" || (formObj.low_celling_of_unit_dosage.value)==""))){
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("MIN_UNIT_DOSE_LESS_THAN_MIN_UNIT_CELLING_DOSE","PH");	
				return false;
		}
		else if ((parseFloat(formObj.low_celling_of_unit_dosage.value) > parseFloat(formObj.high_celling_of_unit_dosage.value)) && (!((formObj.low_celling_of_unit_dosage.value)=="" || (formObj.high_celling_of_unit_dosage.value)==""))){
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("MIN_UNIT_CELLING_DOSE_LESS_THAN_MAX_UNIT_CELLING_DOSE","PH");	
				return false;
		}
		else if ((parseFloat(formObj.high_of_unit_dosage.value) > parseFloat(formObj.high_celling_of_unit_dosage.value)) && (!((formObj.high_of_unit_dosage.value)=="" || (formObj.high_celling_of_unit_dosage.value)==""))){
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("MAX_UNIT_DOSE_LESS_THAN_MAX_UNIT_CELLING_DOSE","PH");	
				return false;
		}
		
		else if ((parseFloat(formObj.low_of_daily_dosage.value) > parseFloat(formObj.low_celling_of_daily_dosage.value)) && (!((formObj.low_of_daily_dosage.value)=="" || (formObj.low_celling_of_daily_dosage.value)==""))){
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("MIN_DAILY_DOSE_LESS_THAN_MIN_DAILY_CELLING_DOSE","PH");	
				return false;
		}
		else if ((parseFloat(formObj.low_celling_of_daily_dosage.value) > parseFloat(formObj.high_celling_of_daily_dosage.value))&& (!((formObj.low_celling_of_daily_dosage.value)=="" || (formObj.high_celling_of_daily_dosage.value)==""))){
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("MIN_DAILY_CELLING_DOSE_LESS_THAN_MAX_DAILY_CELLING_DOSE","PH");	
				return false;
		}
		else if ((parseFloat(formObj.high_of_daily_dosage.value) > parseFloat(formObj.high_celling_of_daily_dosage.value)) && (!((formObj.high_of_daily_dosage.value)=="" || (formObj.high_celling_of_daily_dosage.value)==""))){
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("MAX_DAILY_DOSE_LESS_THAN_MAX_DAILY_CELLING_DOSE","PH");	
				return false;
		}
		
		else if ((parseFloat(formObj.low_celling_of_unit_dosage.value) > parseFloat(formObj.low_celling_of_daily_dosage.value)) && (!((formObj.low_celling_of_unit_dosage.value)=="" || (formObj.low_celling_of_daily_dosage.value)==""))){
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("MIN_UNIT_CELLING_DOSE_LESS_THAN_MIN_DAILY_CELLING_DOSE","PH");	
				return false;
		}
		else if ((parseFloat(formObj.high_celling_of_unit_dosage.value) > parseFloat(formObj.high_celling_of_daily_dosage.value)) && (!((formObj.high_celling_of_unit_dosage.value)=="" || (formObj.high_celling_of_daily_dosage.value)==""))){
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("MAX_UNIT_CELLING_DOSE_LESS_THAN_MAX_DAILY_CELLING_DOSE","PH");	
				return false;
		}
	return true;
	}
	//Added for IN:070451 END
}
function checkIsValidForProceed() {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();

	if ( (url.indexOf("blank.html")==-1) && (url.indexOf("drugdosagelimitquery")==-1) )
		return true;
	else
		return false;
}

function reset(){
	
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	
	if ( (url.indexOf("drugdosagelimitquerycriteria")!=-1) ) {
		f_query_add_mod.document.query_form.reset();
	}
	else if ( (url.indexOf("drugdosagelimitaddmodify")!=-1) ) {	
		var mode=f_query_add_mod.document.formDrugDosageLimit.mode.value;	
		
		if(f_query_add_mod.document.formDrugDosageLimit.drug_desc.disabled==false){
			
			f_query_add_mod.document.formDrugDosageLimit.drug_desc.readOnly=false;
		}
		
		//f_query_add_mod.document.formDrugDosageLimit.reset();
		f_query_add_mod.location.reload();
	
		/*var radval1=f_query_add_mod.document.formDrugDosageLimit.limit_ind[0].value;
		var radval2=f_query_add_mod.document.formDrugDosageLimit.limit_ind[1].value;
		alert("==============" +radval2+ "==============" +radval1);
		if(radval1=="S")
		{		alert("++++++++++");
				f_query_add_mod.document.formDrugDosageLimit.limit_ind[0].checked		= true;
		}
		else if(radval2=="B")
		{
			alert("============================");
			f_query_add_mod.document.formDrugDosageLimit.limit_ind[1].checked		= true;
		}*/
	
		if(mode!=undefined && mode=="1")
		{	
			f_query_add_mod.document.getElementById("dose_unit_1").innerText="";
			f_query_add_mod.document.getElementById("dose_unit_2").innerText="";
			f_query_add_mod.document.getElementById("dose_unit_3").innerText=""; 
			f_query_add_mod.document.getElementById("dose_unit_4").innerText="";
			f_query_add_mod.document.getElementById("dose_unit_5").innerText=""; 
		}

	}
}

function Modify(obj){
	var drug_code=obj.cells[0].innerText;
	var age_group_code=obj.cells[5].innerText;
	var calc_by_ind=obj.cells[4].innerText;
	calc_by_ind=calc_by_ind.substring(0,1);	document.location.href="../../ePH/jsp/DrugDosageLimitAddModify.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&drug_code="+drug_code+"&age_group_code="+age_group_code+"&calc_by_ind="+calc_by_ind;
}

function changeCursor(obj) {
	obj.style.cursor = "hand" ;
}
function getRelatedValuesForAgeGroup(obj){
	var formObj=document.formDrugDosageLimit;

	if (obj.value !=""){
	
		if (globalGender[obj.selectedIndex-1] != "null" && globalGender[obj.selectedIndex-1]!=undefined)
			formObj.gender.value=globalGender[obj.selectedIndex-1];		
		else
			formObj.gender.value="";

		if (globalMinAge[obj.selectedIndex-1] != "null" && globalMinAge[obj.selectedIndex-1]!=undefined)
			formObj.min_age.value=globalMinAge[obj.selectedIndex-1];		
		else
			formObj.min_age.value="";
		
		if (globalMaxAge[obj.selectedIndex-1] != "null" && globalMaxAge[obj.selectedIndex-1]!=undefined)
			formObj.max_age.value=globalMaxAge[obj.selectedIndex-1];		
		else
			formObj.max_age.value="";

		if (globalAgeUnit[obj.selectedIndex-1]=="D"){
			formObj.lbl_age_unit.value = getLabel("Common.days.label","Common");
			formObj.age_unit.value ="Days";
		}
		else if (globalAgeUnit[obj.selectedIndex-1]=="W"){
			formObj.lbl_age_unit.value = getLabel("Common.weeks.label","Common")
			formObj.age_unit.value ="Weeks";
		}
		else if (globalAgeUnit[obj.selectedIndex-1]=="M"){
			formObj.lbl_age_unit.value = getLabel("Common.months.label","Common");
			formObj.age_unit.value ="Months";
		}
		else if (globalAgeUnit[obj.selectedIndex-1]=="Y"){
			formObj.lbl_age_unit.value = getLabel("Common.Years.label","Common");
			formObj.age_unit.value ="Years";
		}else if (globalAgeUnit[obj.selectedIndex-1]=="H"){//Added for ML-MMOH-SCF-1974
			formObj.lbl_age_unit.value = getLabel("Common.hours.label","Common");
			formObj.age_unit.value ="Hours";
		}
		else if (globalAgeUnit[obj.selectedIndex-1]=="N"){
			formObj.lbl_age_unit.value = getLabel("Common.Minutes.label","Common");
			formObj.age_unit.value ="Minutes";
		}//Adding end for ML-MMOH-SCF-1974
		else{
			formObj.lbl_age_unit.value = ""
			formObj.age_unit.value ="";
		}
	}
	else{
		formObj.gender.value="";
		formObj.min_age.value="";
		formObj.max_age.value="";
		formObj.age_unit.value ="";
		formObj.lbl_age_unit.value = ""
	}
}
function validNumber(obj) {
	if ( CheckNum(obj) ) {
		putDecimal(obj, 12, 3);
		if (obj.value != ""){
			if (obj.value.indexOf(".") == -1 || obj.value.indexOf(".") > 9) {
				alert(getMessage("INVALID_NUMBER_FORMAT","Common"));
				obj.value="";
				obj.focus();
				return false;
			}
		}
	}
	if(parseFloat(obj.value) == 0){
		alert(getMessage("VALUE_SHOULD_BE_GR_ZERO","Common"));
		obj.value="";
		obj.focus();
	}
}
async function searchCode( target ) {

	if(!document.formDrugDosageLimit.drug_desc.readOnly){
		var retVal = await DrugSearch(target);
	}
	else{
		var retVal="";
	}
}

function getDrugRelatedInfo( obj ) {
	index	=	0;
	var mode = document.formDrugDosageLimit.mode.value;
	if(obj.value != "" ) {
		var bean_id = document.formDrugDosageLimit.bean_id.value ;
		var bean_name = document.formDrugDosageLimit.bean_name.value ;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;

		xmlStr ="<root><SEARCH " ;
		xmlStr += "drug_code=\""+ checkSpl(obj.value) +"\" " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "DrugDosageLimitGetDrugInfo.jsp?function_id="+function_id+"&bean_id=" + bean_id + "&bean_name=" + bean_name + "&drug_code="+obj.value, false ) ;
		xmlHttp.send( xmlDoc ) ;
	//	alert("xmlHttp.responseText = "+xmlHttp.responseText);
		eval(xmlHttp.responseText) ;

	//	Assigning the values starts from here...
		var formObjForDosage = document.formDrugDosageLimit;
		if (globalDrugRelated[3]!='null' && globalDrugRelated[3]!=undefined)
			formObjForDosage.generic_name.value=globalDrugRelated[3];
		else
			formObjForDosage.generic_name.value="";
		if (globalDrugRelated[6]!='null' && globalDrugRelated[6]!=undefined && globalDrugRelated[6] !="0")
			formObjForDosage.strength_value.value=globalDrugRelated[6];
		else
			formObjForDosage.strength_value.value="";
		if (globalDrugRelated[5]!='null' && globalDrugRelated[5]!=undefined)
			formObjForDosage.form_desc.value=globalDrugRelated[5];
		else
			formObjForDosage.form_desc.value="";
		if (globalDrugRelated[8]!='null' && globalDrugRelated[8]!=undefined)
			formObjForDosage.pres_base_uom.value=globalDrugRelated[8];	
		else
			formObjForDosage.pres_base_uom.value="";

		if (globalDrugRelated[9]!='null' && globalDrugRelated[9]!=undefined) {
			formObjForDosage.strength_value.value+=" "+globalDrugRelated[9];
			defaultUnit();
		}
		else
			formObjForDosage.strength_value.value+="";

		if (formObjForDosage.strength_value.value==""){
			formObjForDosage.limit_ind[0].disabled = true;
			formObjForDosage.limit_ind[1].disabled = true;
			setUOM('B')
		}
		else{
			formObjForDosage.limit_ind[0].disabled = false;
			formObjForDosage.limit_ind[1].disabled = false;
		}
		
		if (formObjForDosage.strength_value.value==0){

			if (!(mode=="2")){			
				formObjForDosage.limit_ind[1].checked		= true;
			}
			formObjForDosage.limit_ind[0].disabled		= true;
			formObjForDosage.limit_ind[1].disabled		= true;
			formObjForDosage.calc_dosage_by.disabled	=	true;
		}
		else{
			if (!(mode=="2")){				
				formObjForDosage.limit_ind[0].checked		= true;
				formObjForDosage.calc_dosage_by.disabled	= false;
			}
			formObjForDosage.limit_ind[0].disabled		= false;
			formObjForDosage.limit_ind[1].disabled		= false;
			
		}
	}
}

function addToGlobalDrugRelated(str){
	globalDrugRelated[index]=str;
	index++;
}

function callCheckMaxLen(obj,noOfChars,Legend){
	makeValidString(obj);
	if(trimCheck(obj.value)==""){
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";		
		return false;
	}
	if(CheckMaxLen(Legend,obj,noOfChars,parent.messageFrame)==false){
		obj.focus();
		return false;
	}
	else{		
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
		return true;
	}
}

function clearDrugRelatedFields(obj){

	var formObj=document.formDrugDosageLimit;

	if (obj=="onBlur"){
		if (formObj.drug_desc.value==""){
			formObj.drug_code.value="";
			formObj.generic_name.value="";
			formObj.strength_value.value="";
			formObj.form_desc.value="";
			formObj.pres_base_uom.value="";
		}
	}
	else if (obj=="keyDown"){
		formObj.drug_code.value="";
		formObj.generic_name.value="";
		formObj.strength_value.value="";
		formObj.form_desc.value="";
		formObj.pres_base_uom.value="";
	}
}

async function DrugSearchForDosageLimit(obj){
	var formObj=document.formDrugDosageLimit;
	var arrDrug = await DrugSearch("D",obj);	
//	alert("arrDrug >> "+arrDrug);
	if (arrDrug != ""){
		formObj.drug_code.value = arrDrug[0];
		formObj.drug_desc.value = arrDrug[1];
		formObj.drug_desc.readOnly=true;
		getDrugRelatedInfo(formObj.drug_code);
	}
}

function setUOM(obj){		
	var unit_val="";
	cellingDoseVissable(obj); //Added for IN:070451
	if (obj=='S'){	
		if (globalDrugRelated[9]!='null' && globalDrugRelated[9]!=undefined)
		unit_val	=globalDrugRelated[9];	

		if(unit_val!="") {
			document.getElementById("dose_unit_1").innerText=""+unit_val;
			document.getElementById("dose_unit_2").innerText=""+unit_val;
			document.getElementById("dose_unit_3").innerText=""+unit_val;
			document.getElementById("dose_unit_4").innerText=""+unit_val;
			document.getElementById("dose_unit_5").innerText=""+unit_val;
		}
	}
	else if (obj=='B')	{
		
		if (globalDrugRelated[8]!='null' && globalDrugRelated[8]!=undefined)
		unit_val	=globalDrugRelated[8];	
		if(unit_val!="") {
			document.getElementById("dose_unit_1").innerText=""+unit_val;
			document.getElementById("dose_unit_2").innerText=""+unit_val;
			document.getElementById("dose_unit_3").innerText=""+unit_val;
			document.getElementById("dose_unit_4").innerText=""+unit_val;
			document.getElementById("dose_unit_5").innerText=""+unit_val;
		}
		unit_val	=globalDrugRelated[7];
	}
	
	if(obj=="B") {
		document.formDrugDosageLimit.std_unit.value	= globalDrugRelated[7];
	} 
	else {
		document.formDrugDosageLimit.std_unit.value	= globalDrugRelated[9];
	}
}

function checkforvalid(obj){
	var drug_code=document.formDrugDosageLimit.drug_code.value;
	var calc_by_ind=document.formDrugDosageLimit.calc_dosage_by.value;
	if(drug_code != "" && calc_by_ind != "" && obj.value != ""){
		var bean_id = document.formDrugDosageLimit.bean_id.value ;
		var bean_name = document.formDrugDosageLimit.bean_name.value ;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;

		xmlStr ="<root><SEARCH " ;
		xmlStr += "drug_code=\""+ checkSpl(drug_code) +"\" " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "DrugDosageLimitGetDrugInfo.jsp?function_id="+function_id+"&bean_id=" + bean_id + "&bean_name=" + bean_name + "&drug_code="+drug_code+"&validate=checkforvalid"+"&age_group_code="+obj.value+"&calc_by_ind="+calc_by_ind, false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText) ;
	}
}

function addtocheckforvalid(flag){
	if(flag>0)	{
		alert(getMessage("AGE_RANGE_ALREADY_DEFINED_FOR_THIS_DRUG","PH"));
		document.frames.formDrugDosageLimit.age_group_code.selectedIndex=0;
		document.frames.formDrugDosageLimit.gender.value="";
		document.frames.formDrugDosageLimit.age_unit.value="";
		document.frames.formDrugDosageLimit.min_age.value="";
		document.frames.formDrugDosageLimit.max_age.value="";
		document.frames.formDrugDosageLimit.lbl_age_unit.value = "";
	}
}
//Added for IN:070451
function cellingDoseVissable(unit){
	if(unit=="A"){
		document.formDrugDosageLimit.low_celling_of_unit_dosage.style.visibility = "hidden";
		document.formDrugDosageLimit.high_celling_of_unit_dosage.style.visibility = "hidden";
		document.formDrugDosageLimit.low_celling_of_daily_dosage.style.visibility = "hidden";
		document.formDrugDosageLimit.high_celling_of_daily_dosage.style.visibility = "hidden";
		document.getElementById("CellingDose").style.visibility = "hidden";
		document.getElementById("CellingDose1").style.visibility = "hidden";
	}
	else{
		document.formDrugDosageLimit.low_celling_of_unit_dosage.style.visibility = "visible";
		document.formDrugDosageLimit.high_celling_of_unit_dosage.style.visibility = "visible";
		document.formDrugDosageLimit.low_celling_of_daily_dosage.style.visibility = "visible";
		document.formDrugDosageLimit.high_celling_of_daily_dosage.style.visibility = "visible";
		document.getElementById("CellingDose").style.visibility = "visible";
		document.getElementById("CellingDose1").style.visibility = "visible";
	}
}
//Added for IN:070451
