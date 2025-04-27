var qryString_skill="";

function reset(){
	//parent.frames[1].frames[1].frameStaffProfileCriteria.document.formStaffProfCriteria.reset(); --changed on 19/11/08
	parent.frames[2].frames[1].frameStaffProfileCriteria.document.formStaffProfCriteria.reset();
	//parent.frames[1].messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+""; --commented on 19/11/08
	parent.frames[2].messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+"";
}

/**************** Used to call Staff Common look @ shld pass mode as 'call'***********/
function showStaff(target){
	var frmObj=document.formStaffProfCriteria;
	var role_type	= frmObj.role_type.value;
//	var staff_type	= frmObj.staff_type.value;
		var mode		= "call";
		var url = "../../eRS/jsp/SearchStaff.jsp?p_role_type="+role_type+"&mode="+mode;

		var dialogHeight =window.screen.height ;
		var dialogWidth = window.screen.width ;
		var dialogTop	= 0;
		var dialogLeft = 0 ;

	    var arguments   = "" ;
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:"+dialogTop+";dialogLeft:"+dialogLeft+"; scroll=no; status=no;";
	    var retVal   = window.showModalDialog( url, arguments, features ) ;
		if(retVal != null )  {
		if(role_type != retVal[2]){
			var index;
			var len=frmObj.role_type.length;
			for(i=0;i<len;i++){
				if(frmObj.role_type.options[i].value==retVal[2]){
					frmObj.role_type.selectedIndex=i;
					break;
				}
			}
		}
		target.value=retVal[1];
		frmObj.staff_id.value=retVal[0];
		frmObj.staff_type.value=retVal[3];
	}
}
/****************************Calls From StaffProfileSetupCriteria.jsp*******************/
function skillDetails(){
	var frmObj=document.formStaffProfCriteria;
	var fields=new Array(frmObj.staff_text);
	var names = new Array(getLabel("eRS.Staff.label","RS"));
	if(parent.parent.f_query_add_mod.checkFieldsofMst( fields, names, parent.parent.messageFrame)){
		var dialogHeight ='30' ;
		var dialogWidth = '50' ;
		var dialogTop	= '230';
		var dialogLeft = '200' ;
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
		var arguments = "";
		var role_type	= document.formStaffProfCriteria.role_type.value;
		var staff_type	= document.formStaffProfCriteria.staff_type.value;
		var staff_id	= document.formStaffProfCriteria.staff_id.value;
		var db_action	= "I";
		var funcValue	="Skill";
		var retVal = window.showModalDialog("../../eRS/jsp/StaffProfileSetupSkills.jsp?role_type="+role_type+"&staff_id="+staff_id+"&staff_type="+staff_type+"&db_action="+db_action+"&funcValue="+funcValue,arguments,features);
	}
}
/*******************************************************************/
function experienceDetails(){
	var frmObj=document.formStaffProfCriteria;
	var fields=new Array(frmObj.staff_text);
	var names = new Array(getLabel("eRS.Staff.label","RS"));
	if(parent.parent.f_query_add_mod.checkFieldsofMst( fields, names, parent.parent.messageFrame)){
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+"";
		var dialogHeight ='30' ;
		var dialogWidth = '50' ;
		var dialogTop	= '230';
		var dialogLeft = '200' ;
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
		var arguments = "";
		var role_type	= frmObj.role_type.value;
		var staff_type	=frmObj.staff_type.value;
		var staff_id	= frmObj.staff_id.value;
		var db_action	= "I";
		var funcValue	="expr";		
		var retVal = window.showModalDialog("../../eRS/jsp/StaffProfileSetupExpr.jsp?role_type="+role_type+"&staff_id="+staff_id+"&staff_type="+staff_type+"&db_action="+db_action+"&funcValue="+funcValue,arguments,features);
	}
}
/******************************************************************/
function trainingDetails(){
	var frmObj=document.formStaffProfCriteria;
	var fields=new Array(frmObj.staff_text);
	var names = new Array(getLabel("eRS.Staff.label","RS"));
	if(parent.parent.f_query_add_mod.checkFieldsofMst( fields, names, parent.parent.messageFrame)){
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+"";
		var dialogHeight ='30' ;
		var dialogWidth = '50' ;
		var dialogTop	= '230';
		var dialogLeft = '200' ;
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
		var arguments = "";
		var role_type	= document.formStaffProfCriteria.role_type.value;
		var staff_type	= document.formStaffProfCriteria.staff_type.value;
		var staff_id	= document.formStaffProfCriteria.staff_id.value;
		var db_action	= "I";
		var funcValue	="training";		
		qryString_trng = "role_type="+role_type+"&staff_id="+staff_id+"&db_action="+db_action+"&funcValue="+funcValue;
		
		var retVal = window.showModalDialog("../../eRS/jsp/StaffProfileSetupTraining.jsp?role_type="+role_type+"&staff_id="+staff_id+"&staff_type="+staff_type+"&db_action="+db_action+"&funcValue="+funcValue,arguments,features);
	}
}
/***********************************************************************/
function licenseDetails(){
	var frmObj=document.formStaffProfCriteria;
	var fields=new Array(frmObj.staff_text);
	var names = new Array(getLabel("eRS.Staff.label","RS"));
	if(parent.parent.f_query_add_mod.checkFieldsofMst( fields, names, parent.parent.messageFrame)){
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+"";
		var dialogHeight ='30' ;
		var dialogWidth = '50' ;
		var dialogTop	= '230';
		var dialogLeft = '200' ;
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
		var arguments = "";
		var role_type	= document.formStaffProfCriteria.role_type.value;
		var staff_type	= document.formStaffProfCriteria.staff_type.value;
		var staff_id	= document.formStaffProfCriteria.staff_id.value;
		var db_action	= "I";
		var funcValue	="license";		
		//qryString_lic	= "role_type="+role_type+"&staff_id="+staff_id+"&db_action="+db_action+"&funcValue="+funcValue;
		var retVal = window.showModalDialog("../../eRS/jsp/StaffProfileSetupLicensure.jsp?role_type="+role_type+"&staff_id="+staff_id+"&staff_type="+staff_type+"&db_action="+db_action+"&funcValue="+funcValue,arguments,features);
	}
}
/********************* Date Validations Starts*********************************/
function showCal(obj, obj_id){
	showCalendar(obj_id);
	obj.focus();
}
/*************************************************************************/
function AllowDateFormat(){
   var key = window.event.keyCode;
   if( ! ( (( key>=48 ) && ( key<58 ) ) || (key == 47)) ) {
       return false;
   }
}
/***********************************************************************/
function checkDateRange(obj,from){

	var fromDate=from;
	var toDate=obj;
		if(doDateCheckAlert(fromDate,toDate) == false) { 
			alert(getMessage("TO_DATE_GR_FR_DATE","RS")); 
			obj.focus()
			obj.value='';
			return false
	}
}
/**********************************************************************/
function checkDateRangeLicense(obj,from){

	var fromDate=from;
	var toDate=obj;
		if(doDateCheckAlert(fromDate,toDate) == false) { 
			alert(getMessage("TO_DATE_LESSER_FROM_DATE","RS")); 
			obj.focus()
			obj.value='';
			return false
	}
}
/*********************************************************************/
function checkToDate(from,today){

	var fromdate = from.value;
	var todaydate = today.value;
	var fromarray;
	var toarray;
	if(fromdate.length > 0 && todaydate.length > 0){
		fromarray = fromdate.split("/");
		toarray = todaydate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(todt) < Date.parse(fromdt)){
			var invaldt =parent.frames[2].getMessage("TO_DATE_LESS_SYSDATE","RS") ; 
			alert(invaldt);
			from.value='';
			from.focus();
		}
	}
}
/*********************************************************************/
function checkFromDate(from,today,to_date){
	var fromdate = from.value;
	var todaydate = today.value;
	var fromarray;
	var toarray;
	if(fromdate.length > 0 && todaydate.length > 0){
		fromarray = fromdate.split("/");
		toarray = todaydate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(todt) < Date.parse(fromdt)){
			var invaldt =parent.frames[2].getMessage("FROM_DATE_LESS_SYSDATE","RS") ; 
			alert(invaldt);
			from.value='';
			from.focus();
		}
	}
	if(to_date.value != ''){
		if(doDateCheckAlert(from,to_date) == false) { 
			alert(getMessage("TO_DATE_LESSER_FROM_DATE","RS")); 
			to_date.value='';
			to_date.focus();
			return false
		}
	}
}

/*****validates to n frm dt for to_dt shld b greater than n should not b equal to frm_dt*******/
function doDateCheck(from,to) {
    var fromarray; var toarray;
    var fromdate = from.value ;
    var todate   = to.value ;
    if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
            var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
            if(Date.parse(todt) < Date.parse(fromdt))
               return 1 ;
            else if(Date.parse(todt) > Date.parse(fromdt))
			  return  -1 ;
			else if(Date.parse(todt) == Date.parse(fromdt))
			 return  1 ;
   }
} //End of function

/*************************SKILL FUNCTIONS****************************/
/************* called frm StaffProfileSetupSkillRecord.jsp **********************/
function onLoadValidate(){
var formObj= parent.frameSkillsRecord.document.form_profileSetupRecord;
var db_action = formObj.db_action.value;
if(db_action=='U'){
		var level = formObj.level.value;
		formObj.prof_level.options.value=level;
		formObj.prof_level.options.text=level;
		formObj.prof_level.options.selected;
		formObj.delete_btn.style.visibility="visible";
		formObj.skill_lookup_button.disabled=true;
	}
}
/********************************************************************/
function skillLookup(call_mode, target){
	
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var formObj= parent.frameSkillsRecord.document.form_profileSetupRecord;
	var role_type = formObj.role_type.value;
	var staff_id = formObj.staff_id.value;
	var locale=formObj.locale.value
	var skill_id=formObj.skillID.value;
	var skill_txt=formObj.skill_text.value;
	if((call_mode == 'T')&&(skill_txt =='')){
		formObj.skillID.value='';
		return false;
	}
	if(skill_id !=''){
		formObj.skillID.value='';
		target.value='';
	}
	//argumentArray[0] = "SELECT skill_code code, skill_desc description FROM rs_skill WHERE skill_code NOT IN (SELECT skill_code FROM rs_staff_skillset WHERE role_type = '"+role_type+"' AND staff_id = '"+staff_id+"')AND eff_Status = 'E' AND UPPER(skill_code) LIKE UPPER(?) AND UPPER(skill_desc) LIKE UPPER(?) ORDER BY skill_desc";
	argumentArray[0] = "SELECT skill_code code, skill_desc description FROM rs_skill_lang_vw WHERE skill_code NOT IN (SELECT skill_code FROM rs_staff_skillset WHERE role_type = '"+role_type+"' AND staff_id = '"+staff_id+"')AND eff_Status = 'E' AND UPPER(skill_code) LIKE UPPER(?) AND UPPER(skill_desc) LIKE UPPER(?) and language_id = '"+locale+"' ORDER BY skill_desc";
	
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2"; 
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC
	retVal = CommonLookup(getLabel("eRS.Skill.label","RS"), argumentArray );
		if(retVal != null && retVal != "") {
			target.value = retVal[1] ;
			formObj.skillID.value = retVal[0];
		}else
			target.value ="";
}
/***********************************************************************/
function clearSkill(){
	var frmObj=document.forms[0];
	frmObj.db_action.value='I';
	frmObj.skill_text.value='';
	frmObj.skillID.value='';
	frmObj.prof_level.selectedIndex=0;
	frmObj.delete_btn.style.visibility='hidden';
	frmObj.level.value='';
	frmObj.skill_text.readOnly=false;
	frmObj.skill_lookup_button.disabled=false;
}
/***********************************************************************/
function recordSkill(){
	var formObj= parent.frameSkillsRecord.document.form_profileSetupRecord;
	var skill_text = formObj.skill_text.value;
	var prof_level = formObj.prof_level.value;
	
	var fields=new Array(skill_text,prof_level);
	var names = new Array(getLabel("eRS.Skill.label","RS"),getLabel("eRS.ProficiencyLevel.label","RS"));
	
	if(mandatorySkill( fields, names)){
		var task="rec";
		formObj.task.value=task;
		formObj.submit();
	}	
}
/**********************checks mandotary fields *****************************/
function mandatorySkill( fields, names) 	{
	var errors = "" ;
    for( var i=0; i<fields.length; i++ ) {
		if (fields[i]==" "||fields[i]==null||fields[i]==""){
			errors = errors + "APP-000001 " + names[i] + " cannot be blank... ";
		}
	}
    if ( errors.length != 0 ) {
		alert(errors);
        return false ;
    }
    return true ;
}
/***********************************************************************/
function deleteSkill(){
	var formObj= parent.frameSkillsRecord.document.form_profileSetupRecord;
		var task="del";
		formObj.task.value=task;
		formObj.submit();
}
/********* This fucn is used to open the explnatory text modal window *****************/
function Expl_txt(index,skillCode){
	var dialogHeight ='12' ;
	var dialogWidth = '22' ;
	var dialogTop	= '200';
	var dialogLeft = '150' ;
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
	var arguments = "";
	var index=index;
	var skillCode=skillCode;
	var retVals = window.showModalDialog("../../eRS/jsp/StaffProfileSetupShowExplText.jsp?index="+index+"&skillCode="+skillCode,arguments,features);
} 

/********* called frm StaffProfileSetupSkillsResult.jsp (hyperlink) *******************/
function skill_edit(index,role_type,staff_id,funcValue,code,desc,level){
	var index		=index;
	var code		=code;
	var desc		=desc;
	var level		=level;
	var db_action	= "U";
	var role_type	= role_type;
	var staff_id	= staff_id;
	var funcValue	= funcValue;
	parent.frameSkillsRecord.location.href="../../eRS/jsp/StaffProfileSetupSkillsRecord.jsp?index="+index+"&code="+code+"&desc="+desc+"&level="+level+"&db_action="+db_action+"&role_type="+role_type+"&staff_id="+staff_id+"&funcValue="+funcValue;
}

/*************** SKILL FUNCTIONS END --- TRAINING FUNCTION STARTS**************/
/****************** Calls from StaffProfileSetupTrainingCriteria.jsp*******************/
function  onLoadChk(){
	document.form_profileSetupRecord.org_type.disabled=true;
	document.form_profileSetupRecord.org_txt.disabled=true;
	if(document.form_profileSetupRecord.db_action.value=="U"){
		document.form_profileSetupRecord.delete_btn.style.visibility="visible";
	}
}
/***********************************************************************/
function callTraininglkup(call_mode, target){

	//var formObj=document.forms[0];
	var formObj= parent.frameTrainingRecord.document.form_profileSetupRecord;
	//alert(formObj.name);
	var role_type = formObj.role_type.value;
	var staff_id = formObj.staff_id.value;
	//alert("role_type----->"+role_type);
	//alert("staff_id----->"+staff_id);
	
	var locale=formObj.locale.value
	//alert("locale---->"+locale);
	var training_text = formObj.training_text.value;
	if((call_mode =='T')&&(training_text =='')){
		formObj.training_id.value = '';
		return false;
	}

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var training_code=document.form_profileSetupRecord.training_id.value;
	if(training_code !=''){
		formObj.training_id.value = '';
		target.value='';
	}

	//argumentArray[0] = "select training_code code,training_desc description from rs_training where training_code NOT IN(SELECT training_code FROM rs_staff_training  WHERE role_type ='"+role_type+"' AND staff_id ='"+staff_id+"' ) and  eff_status='E'  AND UPPER(training_code) LIKE UPPER(?) AND UPPER(training_desc) LIKE UPPER(?) ORDER BY training_desc";
	argumentArray[0] = "select training_code code,training_desc description from rs_training_lang_vw where training_code NOT IN(SELECT training_code FROM rs_staff_training  WHERE role_type ='"+role_type+"' AND staff_id ='"+staff_id+"' ) and  eff_status='E'  AND UPPER(training_code) LIKE UPPER(?) AND UPPER(training_desc) LIKE UPPER(?) and language_id = '"+locale+"' ORDER BY training_desc";
	
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2"; 
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC
	retVal = CommonLookup(getLabel("eRS.Training.label","RS"), argumentArray );
		if(retVal != null && retVal != "") {
			target.value = retVal[1] ;
			formObj.training_id.value = retVal[0];
		}else{
			target.value ="";
			formObj.training_id.value ='';
		}
}
/**********************************************************************/
function chkOrgType(){
	document.form_profileSetupRecord.org_type.value="";
	document.form_profileSetupRecord.org_txt.value="";
	var training_type=document.form_profileSetupRecord.training_type.value
		if (training_type=='I'){
			document.form_profileSetupRecord.org_type.disabled=false;
			document.form_profileSetupRecord.org_txt.disabled=true;
		}else if (training_type=='L' || training_type=='O'){
			document.form_profileSetupRecord.org_txt.disabled=false;
			document.form_profileSetupRecord.org_type.disabled=true;
		}else if (training_type==""){
			document.form_profileSetupRecord.org_type.disabled=true;
			document.form_profileSetupRecord.org_txt.disabled=true;
		}
}
/*********************************************************************/
function getFacilityType(){
	var frmObj	=	document.forms[0];
	frmObj.org_txt1.value=frmObj.org_type[frmObj.org_type.selectedIndex].text;
}
/*********************************************************************/
function checkVal(target){
	if(target.checked == true){
		target.value='Y';
		target.checked= true;
	}
	else{
		target.value='N';
		target.checked=false;
	}
}		
/*******************************************************************/
function clearTraining(){
	var frmObj=document.forms[0];
	/*frmObj.db_action.value='I';
	frmObj.frm_dt.value='';
	frmObj.to_dt.value='';
	frmObj.org_txt.value='';
	frmObj.training_text.value='';
	frmObj.training_type.disabled=false;
	frmObj.org_type.disabled=false;
	frmObj.frm_dt.readOnly=false;
	frmObj.to_dt.readOnly=false;
//alert(frmObj.frm_dt_lookup_id.disabled);
	//frmObj.frm_dt_lookup.disabled=false;
	//frmObj.to_dt_lookup.disabled=false;
	frmObj.training_type.selectedIndex=0;
	frmObj.org_type.selectedIndex=0;
	frmObj.delete_btn.style.visibility='hidden';
	frmObj.chk.value='';
	frmObj.chk.checked=false;
	frmObj.remarks.value='';
	frmObj.training_lookup.disabled=false;*/
	var role_type= frmObj.role_type.value;
	var staff_type=frmObj.staff_type.value;
	var staff_id = frmObj.staff_id.value;
	var db_action='I';
	var funcValue = frmObj.funcVal.value;
	parent.frames[2].location.href="../../eRS/jsp/StaffProfileSetupTrainingCriteria.jsp?role_type="+role_type+"&staff_id="+staff_id+"&funcValue="+funcValue+"&db_action=I";

}
/******************************************************************/
function recordTraining(){
	var frmObj= document.form_profileSetupRecord;
	var frm_dt =frmObj.frm_dt.value;
	var to_dt =frmObj.to_dt.value;
	var trg_text = frmObj.training_text.value;
	var training_type=frmObj.training_type.value;
	var org	= "";
	if (training_type=='I'){
		org = frmObj.org_type.value;
	}else if(training_type=='L' || training_type=='O'){
		org = frmObj.org_txt.value;
	}else if(training_type==""){
		org="";
	}
	var fields=new Array(frm_dt,to_dt,trg_text,org);
	var names = new Array (getLabel("eRS.FromDate.label","RS"),getLabel("eRS.To-Date.label","RS"),getLabel("eRS.TrainingProgram.label","RS"),getLabel("eRS.Organisation.label","RS"));
	if(mandatory( fields, names)){
		var task='rec';
		if(frmObj.chk.checked==true){
			frmObj.chk.value='Y';
		}else
			frmObj.chk.value='N';
			frmObj.task.value=task;
			frmObj.submit();			
	}//end of mandatory if condtn.
}
	
/*********************************************************************/	
function mandatory( fields, names) 	{
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if (fields[i]==""||fields[i]==null || fields[i]==" " ){
			errors = errors + "APP-000001 " + names[i] + " cannot be blank... ";
		}
	}
	if ( errors.length != 0 ) {
		alert(errors);
		return false ;
	}
    return true ;
}
/********************************************************************/
function deleteTraining(){
	var task='del';
	document.form_profileSetupRecord.task.value=task;
	document.form_profileSetupRecord.submit();
}
/***************Function calling from StaffProfileSetupTrainingResult.jsp***************/
function trng_edit(role_type,staff_id,funcValue,frm_dt,to_dt,trng_desc,trng_code,trng_type,fac_id,orgn,cert){
	var db_action	= "U";
	parent.frameTrainingRecord.location.href="../../eRS/jsp/StaffProfileSetupTrainingCriteria.jsp?frm_dt="+frm_dt+"&to_dt="+to_dt+"&trng_desc="+trng_desc+"&trng_code="+trng_code+"&db_action="+db_action+"&role_type="+role_type+"&staff_id="+staff_id+"&funcValue="+funcValue+"&trng_type="+trng_type+"&fac_id="+fac_id+"&orgn="+escape(orgn)+"&cert="+cert;
}

/**********************************************************************/
function remarks(role_type,staff_id,trng_code){
	var dialogHeight ='12' ;
	var dialogWidth = '22' ;
	var dialogTop	= '200';
	var dialogLeft = '150' ;
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
	var arguments = "";
	var retVals = window.showModalDialog("../../eRS/jsp/StaffProfileSetupRemarks.jsp?role_type="+role_type+"&staff_id="+staff_id+"&trng_code="+trng_code,arguments,features);
} 

/*************TRAINING FUNCTION END --- LICENSURE FUNCTIONS STARTS************/
function  onLoadChk_license(){
	document.form_licenseRecord.org_type.disabled=true;
	document.form_licenseRecord.org_txt.disabled=true;
	if(document.form_licenseRecord.db_action.value=="U"){
		document.form_licenseRecord.delete_btn.style.visibility="visible";
	}
}
/***********************************************************************/
function callLicenselkup(call_mode, target){

	var formObj=document.forms[0];
	//alert(formObj.name);
	var role_type = formObj.role_type.value;
	var staff_id = formObj.staff_id.value;
	var locale=formObj.locale.value

	var title_txt = formObj.title_txt.value;
	if((call_mode =='T')&&(title_txt =='')){
		formObj.license_id.value = '';
		return false;
	}

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var license_code=			document.form_licenseRecord.license_id.value;
	if(license_code != ''){
		formObj.license_id.value = '';
		target.value='';
	}

	//argumentArray[0] = "SELECT license_code code,license_desc description FROM rs_licensure WHERE license_code NOT IN( SELECT license_code FROM rs_staff_licensure WHERE role_type = '"+role_type+"' AND staff_id = '"+staff_id+"')and eff_status='E' AND UPPER(license_code) LIKE UPPER(?) AND UPPER(license_desc) LIKE UPPER(?) ORDER BY license_desc";
	argumentArray[0] = "SELECT license_code code,license_desc description FROM rs_licensure_lang_vw WHERE license_code NOT IN( SELECT license_code FROM rs_staff_licensure WHERE role_type = '"+role_type+"' AND staff_id = '"+staff_id+"')and eff_status='E' AND UPPER(license_code) LIKE UPPER(?) AND UPPER(license_desc) LIKE UPPER(?) and language_id = '"+locale+"' ORDER BY license_desc";
	
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2"; 
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC
	retVal = CommonLookup(getLabel("eRS.License.label","RS"),argumentArray);
		if(retVal != null && retVal != "") {
			target.value = retVal[1] ;
			formObj.license_id.value = retVal[0];
		}else{
			target.value ="";
			formObj.license_id.value = '';
		}
}
/*************************************************************************/
function chkOrgType_license(){
	document.form_licenseRecord.org_type.value="";
	document.form_licenseRecord.org_txt.value="";
	var license_type=document.form_licenseRecord.license_type.value
		if (license_type=='I'){
			document.form_licenseRecord.org_type.disabled=false;
			document.form_licenseRecord.org_txt.disabled=true;
		}else if (license_type=='L' || license_type=='O'){
			document.form_licenseRecord.org_txt.disabled=false;
			document.form_licenseRecord.org_type.disabled=true;
		}else if (license_type==""){
			document.form_licenseRecord.org_type.disabled=true;
			document.form_licenseRecord.org_txt.disabled=true;
		}
}

/*************************************************************************/
function clearLicensure(){

	var frmObj=document.forms[0];
	var role_type= frmObj.role_type.value;
	var staff_id = frmObj.staff_id.value;
	var staff_type = frmObj.staff_type.value;
	var db_action='I';
	var funcValue = frmObj.funcVal.value;
	parent.frames[2].location.href="../../eRS/jsp/StaffProfileSetupLicensureRecord.jsp?role_type="+role_type+"&staff_type="+staff_type+"&staff_id="+staff_id+"&funcValue="+funcValue+"&db_action=I";

}
/***********************************************************************/
function recordLicense(){

	var formObj=document.form_licenseRecord;
	var facility_id = formObj.org_type[formObj.org_type.selectedIndex].value;
	var facility_name = formObj.org_type[formObj.org_type.selectedIndex].text;
	var orgn="";
	if(facility_id!=""){
		orgn=facility_name;
	}else if(facility_id==""){
		orgn=formObj.org_txt.value;
	}
	formObj.orng_name.value=orgn;
	formObj.facility_id.value=facility_id;
	
	var title		=formObj.title_txt.value;
	var id_txt		=formObj.id_txt.value;
	var orng_name	=formObj.orng_name.value;
	var issue_dt	=formObj.issue_dt.value;
	var valid_dt	=formObj.valid_dt.value;

	var fields=new Array(title,id_txt,orng_name,issue_dt);
	var names = new Array(getLabel("Common.TITLE.label","Common"),getLabel("Common.identification.label","Common"),getLabel("eRS.Organisation.label","RS"),getLabel("eRS.IssueDate.label","RS"));
	if(mandatoryLicense( fields, names)){
		var task='rec';
		formObj.task.value=task;
		formObj.submit();
	}
}
/**************************************************************************/
function mandatoryLicense( fields, names) 	{

		var errors = "" ;
			for( var i=0; i<fields.length; i++ ) {
				if (fields[i]==""||fields[i]==null || fields[i]==" " ){
					errors = errors + "APP-000001 " + names[i] + " cannot be blank...                                                                      ";
				}
			}
			if ( errors.length != 0 ) {
				alert(errors);
				return false ;
			}
    return true ;
}
/***********************************************************************/
function deleteLicense(){
	var task='del';
	document.form_licenseRecord.task.value=task;
	document.form_licenseRecord.submit();
}
/*************FUNCTIONS CALLING FROM StaffProfileSetupLicenseresult.jsp*************/

function license_details(role_type,staff_id,funcValue,lic_code,lic_desc,lic_id,issue_dt,valid_dt,fac_type,fac_id,orng){ 
	var db_action	= "U";
	parent.framelicenseRecord.location.href="../../eRS/jsp/StaffProfileSetupLicensureRecord.jsp?lic_code="+lic_code+"&lic_desc="+lic_desc+"&lic_id="+lic_id+"&issue_dt="+issue_dt+"&db_action="+db_action+"&role_type="+role_type+"&staff_id="+staff_id+"&funcValue="+funcValue+"&valid_dt="+valid_dt+"&fac_type="+fac_type+"&orng="+escape(orng)+"&fac_id="+fac_id;
}
/***********************************************************************/
function remarks_license(role_type,staff_id,lic_code){
	
	var dialogHeight ='12' ;
	var dialogWidth = '22' ;
	var dialogTop	= '200';
	var dialogLeft = '150' ;
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
	var arguments = "";
	var retVals = window.showModalDialog("../../eRS/jsp/StaffProfileSetupRemarks.jsp?role_type="+role_type+"&staff_id="+staff_id+"&lic_code="+lic_code,arguments,features);
} 

/************LICENSURE FUNCTIONS END --- EXPERIANCE FRUNTIONS STARTS************/
function  onLoadChk_Expr(){
	document.form_ExprRecord.facility_id.disabled=true;
	document.form_ExprRecord.org_txt.disabled=true;
	document.form_ExprRecord.wrkPlace_type.disabled=true;
	document.form_ExprRecord.wrkPlace_txt.disabled=true;
	if(document.form_ExprRecord.db_action.value =='U')
		document.form_ExprRecord.del.style.visibility="visible";
}	
/************************************************************************/
function positionLkup(call_mode, target){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var frmObj=document.form_ExprRecord;
	//alert(frmObj.name);
	var position_txt=frmObj.position_txt.value;
	var position_code=frmObj.position_id.value
	var locale=frmObj.locale.value
	if((call_mode == 'T')&&(position_txt =='')){
		frmObj.position_id.value='';
		return false;
	}
	if(position_code !=''){
		frmObj.position_id.value='';
		target.value='';
	}

	var role_type= frmObj.role_type.value;
	var staff_id= frmObj.staff_id.value;
//position_code not in(select position_code  FROM rs_staff_profile WHERE role_type = '"+role_type+"' AND staff_id = '"+staff_id+"')  and
	//argumentArray[0] = "SELECT position_code code,position_desc description FROM am_position WHERE role_type='"+role_type+"' AND eff_status='E'  AND UPPER(position_code) LIKE UPPER(?) AND UPPER(position_desc) LIKE UPPER(?) ORDER BY position_desc";
	argumentArray[0] = "SELECT position_code code,position_desc description FROM am_position_lang_vw WHERE role_type='"+role_type+"' AND eff_status='E'  AND UPPER(position_code) LIKE UPPER(?) AND UPPER(position_desc) LIKE UPPER(?) and language_id = '"+locale+"' ORDER BY position_desc";
	
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2"; 
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC
	retVal = CommonLookup(getLabel("eRS.Experience.label","RS"),argumentArray);
		if(retVal != null && retVal != "") {
			target.value = retVal[1] ;
			frmObj.position_id.value = retVal[0];
		}else
			target.value ="";
	
}
/*************************************************************************/
function chkForFac(){
	document.form_ExprRecord.org_type.value="";
	document.form_ExprRecord.org_txt.value="";
	document.form_ExprRecord.wrkPlace_type.value="";
	document.form_ExprRecord.wrkPlace_txt.value="";
	var formObj = document.form_ExprRecord;
	var facility_type = formObj.fac_type[formObj.fac_type.selectedIndex].value;
	
		if(facility_type=="E"){
			formObj.org_type.disabled=false;
			formObj.org_txt.disabled=true;
			formObj.wrkPlace_type.disabled=false;
			formObj.wrkPlace_txt.disabled=true;
		}else if(facility_type=="X"){
			formObj.org_type.disabled=true;
			formObj.org_txt.disabled=false;
			formObj.wrkPlace_type.disabled=true;
			formObj.wrkPlace_txt.disabled=false;
		}else if(facility_type==""){
			formObj.org_type.disabled=true;
			formObj.org_txt.disabled=true;
			formObj.wrkPlace_type.disabled=true;
			formObj.wrkPlace_txt.disabled=true;
		}

}
/*************************************************************************/
function loadWrkPlace(){
	clearWrkPlaceList();
	var formObj = document.form_ExprRecord;
	var facility_type = formObj.fac_type[formObj.fac_type.selectedIndex].value;
	var facility_id	 = formObj.org_type[formObj.org_type.selectedIndex].value;
	var locn_id		= formObj.locn_type[formObj.locn_type.selectedIndex].value;
	if(facility_type == "E" && facility_id!="" && locn_id!=""){
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;

		xmlStr ="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "../../eRS/jsp/StaffProfileSetupValidate.jsp?locn_id="+locn_id+"&facility_id="+facility_id, false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText); 
	}
}
/************************************************************************/
function gradeLkup(call_mode, target){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var frmObj=document.form_ExprRecord;
	var grade_txt = frmObj.Grade_txt.value;
	var grade_id = frmObj.grade_id.value;
	var locale=frmObj.locale.value
	if((call_mode =='T')&&(grade_txt =='')){
		frmObj.grade_id.value = retVal[0];
		return false;
	}
	
	if(grade_id !=""){
		frmObj.Grade_txt.value='';
		frmObj.grade_id.value='';
	}
	//argumentArray[0] = "SELECT grade_code code,grade_desc description FROM rs_grade WHERE eff_status='E' AND UPPER(grade_code) LIKE UPPER(?) AND UPPER(grade_desc) LIKE UPPER(?) ORDER BY grade_desc";
	argumentArray[0] = "SELECT grade_code code,grade_desc description FROM rs_grade_lang_vw WHERE eff_status='E' AND UPPER(grade_code) LIKE UPPER(?) AND UPPER(grade_desc) LIKE UPPER(?) and language_id = '"+locale+"' ORDER BY grade_desc";
	
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2"; 
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC
	retVal = CommonLookup(getLabel("eRS.Grade.label","RS"),argumentArray);
		if(retVal != null && retVal != "") {
			target.value = retVal[1] ;
			frmObj.grade_id.value = retVal[0];
		}else
			target.value ="";
	
}

/************************************************************************/
function addWrkPlace(code,desc){
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = desc ;
	document.form_ExprRecord.wrkPlace_type.add(element);
}
/*************************************************************************/
function clearWrkPlaceList() {
	var len = eval("document.form_ExprRecord.wrkPlace_type.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval("document.form_ExprRecord.wrkPlace_type.remove(\"atc_class_l2_code\")") ;
	}
	var tp 		= "  ---Select---  " ;
	var opt  	= eval("document.createElement(\"OPTION\")") ;
	opt.text 	= tp ;
	opt.value 	= "" ;
	eval("document.form_ExprRecord.wrkPlace_type.add(opt)") ;
}

/*********************************************************************/
function clearExpr(){
	var frmObj=document.forms[0];
	var role_type= frmObj.role_type.value;
	var staff_id = frmObj.staff_id.value;
	var staff_type = frmObj.staff_type.value;
	var funcValue = frmObj.funcVal.value;
	parent.frames[2].location.href="../../eRS/jsp/StaffProfileSetupExprRecord.jsp?role_type="+role_type+"&staff_type="+staff_type+"&staff_id="+staff_id+"&funcValue="+funcValue+"&db_action=I";

}

/************************************************************************/
function recordExpr(){
	var formObj=document.form_ExprRecord;
	var position= formObj.position_txt.value;
	var fac_type =  formObj.fac_type[formObj.fac_type.selectedIndex].value;
	var facility = "";
	var wrkPlace = "";	
	if (fac_type=='E'){
		facility = formObj.org_type.value;
		wrkPlace=formObj.wrkPlace_type.value;
	}else{
		facility = formObj.org_txt.value;
		wrkPlace=formObj.wrkPlace_txt.value;
		
	}

	var frm_dt = formObj.frm_dt.value;
	var to_dt = formObj.to_dt.value;
	var grade = formObj.Grade_txt.value;
	var fte = formObj.fte.value; 
	var fields=new Array(position,facility,frm_dt,wrkPlace,grade,fte);
	var names = new Array (getLabel("Common.Position.label","Common"),getLabel("Common.facility.label","Common"),getLabel("eRS.FromDate.label","RS"),getLabel("eRS.WorkPlace.label","RS"),getLabel("eRS.Grade.label","RS"),getLabel("eRS.FTE.label","RS"));
	if(fte <0||fte > 0.9){
	
		alert(getMessage("FTE_RANGE","RS")); 
	}

	if(mandatoryExpr( fields, names)){
	var facility_id = formObj.org_type[formObj.org_type.selectedIndex].value;
	var facility_name = formObj.org_type[formObj.org_type.selectedIndex].text;
	var wrkPlace_id=formObj.wrkPlace_type[formObj.wrkPlace_type.selectedIndex].value;
	var wrkPlace_txt=formObj.wrkPlace_type[formObj.wrkPlace_type.selectedIndex].text;
	var task='rec';
	var orgn="";
	if(facility_id!=""){
		orgn=facility_name;
	}else if(facility_id==""){
		orgn=formObj.org_txt.value;
	}
	
	var wrkPlace="";
	if(wrkPlace_id!=""){
		wrkPlace=wrkPlace_txt;
	}else if(wrkPlace_id==""){
		wrkPlace=formObj.wrkPlace_txt.value;
	}
	
	formObj.facility.value=orgn;
	formObj.facility_id.value=facility_id;
	formObj.wrkplace.value=wrkPlace;
	formObj.wrkplace_id.value=wrkPlace_id;
	formObj.task.value=task;
	formObj.submit();
	}	
}
/*********************************************************************/
function mandatoryExpr( fields, names) 	{
		var errors = "" ;
			for( var i=0; i<fields.length; i++ ) {
				if (fields[i]==""||fields[i]==null || fields[i]==" " ){
					errors = errors + "APP-000001 " + names[i] + " cannot be blank...";
					
				}
			}
			if ( errors.length != 0 ) {
				alert(errors);
				return false ;
			}
    return true ;
}
/**********************************************************************/
function deleteExpr(){
	var task='del';
	document.form_ExprRecord.task.value=task;
	document.form_ExprRecord.submit();
}
/*****************FUNCTIONS CALL FROM StaffProfileSetupExprResult.jsp************/
function remarks_Expr(role_type,staff_id,serial_no){
	var dialogHeight ='12' ;
	var dialogWidth = '22' ;
	var dialogTop	= '200';
	var dialogLeft = '150' ;
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
	var arguments = "";
	var retVals = window.showModalDialog("../../eRS/jsp/StaffProfileSetupRemarks.jsp?role_type="+role_type+"&staff_id="+staff_id+"&serial_no="+serial_no,arguments,features);
} 
/**********************************************************************/
function expr_edit(role_type,staff_id,funcValue,position_code,position_desc,facility_type,type_desc,facility_id,facility_name,workplace_type,workplace_code,workplace_name,grade_code,grade_desc,fte,frm_dt,to_dt,locn_type,serial_no){
	var db_action	= "U";
	parent.frameExprRecord.location.href="../../eRS/jsp/StaffProfileSetupExprRecord.jsp?position_code="+position_code+"&position_desc="+position_desc+"&facility_type="+facility_type+"&type_desc="+type_desc+"&db_action="+db_action+"&role_type="+role_type+"&staff_id="+staff_id+"&funcValue="+funcValue+"&facility_id="+facility_id+"&facility_name="+escape(facility_name)+"&workplace_type="+workplace_type+"&workplace_code="+workplace_code+"&workplace_name="+escape(workplace_name)+"&grade_code="+grade_code+"&grade_desc="+grade_desc+"&fte="+fte+"&frm_dt="+frm_dt+"&to_dt="+to_dt+"&locn_type="+locn_type+"&serial_no="+serial_no;
}

/*********************************************************************/
function onSuccess(){
	var frmObj = parent.frames[2].document.forms[0];
	var funcValue = frmObj.funcVal.value;
	var db_action = frmObj.db_action.value;
	var task			= frmObj.task.value;
	var roletype = frmObj.role_type.value;
	var staff_id =  frmObj.staff_id.value;

	if((db_action =='U') && (task == 'rec'))
		frmObj.db_action.value='U';
	else
		frmObj.db_action.value='I';
	
		if(funcValue=='Skill'){
			parent.frames[1].location.href="../../eRS/jsp/StaffProfileSetupSkillsResult.jsp?role_type="+roletype+"&staff_id="+staff_id+"&funcValue="+funcValue+"&db_action="+db_action;
			if(db_action == 'I')
				parent.frames[2].location.href="../../eRS/jsp/StaffProfileSetupSkillsRecord.jsp?role_type="+roletype+"&staff_id="+staff_id+"&funcValue="+funcValue+"&db_action=I";

		}else if(funcValue=='expr'){
			parent.frames[1].location.href="../../eRS/jsp/StaffProfileSetupExprResult.jsp?role_type="+roletype+"&staff_id="+staff_id+"&funcValue="+funcValue+"&db_action="+db_action;
			if(db_action == 'I')
				parent.frames[2].location.href="../../eRS/jsp/StaffProfileSetupExprRecord.jsp?role_type="+roletype+"&staff_id="+staff_id+"&funcValue="+funcValue+"&db_action=I";
			else 
				if((db_action == 'U')&& (task == 'del')){
					frmObj.position_btn.disabled=false;
					frmObj.fac_type.disabled=false;
					frmObj.org_type.disabled=false;
					frmObj.locn_type.disabled=false;
					frmObj.wrkPlace_type.disabled=false;
					frmObj.frm_dt_lookup.disabled=false;
					frmObj.to_dt_lookup.disabled=false;

					frmObj.position_txt.readOnly=false;
					frmObj.org_txt1.readOnly=false;
					frmObj.wrkPlace_txt.readOnly=false;
					frmObj.frm_dt.readOnly=false;
					frmObj.to_dt.readOnly=false;
					frmObj.Grade_txt.readOnly=false;
					frmObj.fte.readOnly=false;
			}

		}else if(funcValue=='training'){
			parent.frames[1].location.href="../../eRS/jsp/StaffProfileSetupTrainingResult.jsp?role_type="+roletype+"&staff_id="+staff_id+"&funcValue="+funcValue+"&db_action="+db_action;
			if(db_action == 'I')
				parent.frames[2].location.href="../../eRS/jsp/StaffProfileSetupTrainingCriteria.jsp?role_type="+roletype+"&staff_id="+staff_id+"&funcValue="+funcValue+"&db_action=I";
			else 
				if((db_action == 'U')&& (task == 'del')){
					frmObj.training_type.disabled=false;
					frmObj.org_type.disabled=false;
					frmObj.frm_dt.readOnly=false;
					frmObj.to_dt.readOnly=false;
					frmObj.training_lookup.disabled=false;
					frmObj.frm_dt_lookup.disabled=false;
					frmObj.to_dt_lookup.disabled=false;
			}

		}else if(funcValue=='license'){
			parent.frames[1].location.href="../../eRS/jsp/StaffProfileSetupLicensureResult.jsp?role_type="+roletype+"&staff_id="+staff_id+"&funcValue="+funcValue+"&db_action="+db_action;
			if(db_action == 'I')
				parent.frames[2].location.href="../../eRS/jsp/StaffProfileSetupLicensureRecord.jsp?role_type="+roletype+"&staff_id="+staff_id+"&funcValue="+funcValue+"&db_action=I";
			else 
				if((db_action == 'U')&& (task == 'del')){
					frmObj.id_txt.readOnly=false;
					frmObj.issue_dt.readOnly=false;
					frmObj.valid_dt.readOnly=false;
					frmObj.license_type.disabled=false;
					frmObj.org_type.disabled=false;
					frmObj.license_lookup.disabled=false;
					frmObj.issue_dt_lookup.disabled=false;
					frmObj.valid_dt_lookup.disabled=false;
			}
		}
}
/***********************************************************************/

