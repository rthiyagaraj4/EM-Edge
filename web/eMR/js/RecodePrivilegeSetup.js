
function create() {
	f_query_add_mod.location.href = "../../eMR/jsp/RecodePrivilegeSetupCreateFrames.jsp?flag=d" ;
	
}
//*******************************************************************************************************

function reset(){

	/*var masterframe = parent.content.f_query_add_mod.Criteria; 
	var formObj=masterframe.document.forms[0];	
	
	if(!(formObj._update_mode_yn.value=='update_db'))
		f_query_add_mod.location.reload();
		*/
		var url=f_query_add_mod.location.href;
		
		if((url.indexOf("RecodePrivilegeSetupCreateFrames.jsp")!=-1)||(url.indexOf("RecodePrivilegeSetupQueryCriteria.jsp")!=-1)){
			f_query_add_mod.document.location.reload();
		}
		else
			return false;


	
}
//******************************************************************************************************
function chkMandatory(){
	//var stageCode=getLabel("Common.StageCode.label","Common");
	var serialNo=getLabel("Common.Stage.label","Common")+getLabel("Common.no.label","Common");
	var stageDesc=getLabel("Common.Stage.label","Common")+" "+getLabel("Common.description.label","Common");
	var masterframe = parent.content.f_query_add_mod.MasterFrame; 
	var formObj=masterframe.document.forms[0];
	
	var fields = new Array ( formObj.srl_no,formObj.stage_description);
	var names = new Array (serialNo,stageDesc);
	var messageFrame =parent.content.messageFrame;
	if(masterframe.checkFieldsofMst( fields, names, messageFrame))
		return true;
}
//******************************************************************************************************
function chkSpecific_Indicator(){
	
	var p_string_val =parent.content.f_query_add_mod.DetailFrame.document.getElementById("p_string_val").value;
    var specific_indicator=parent.content.f_query_add_mod.MasterFrame.document.getElementById("specific_indicator").value
	var err_txt="";
	

	
	if(specific_indicator=="SPC"){		
	if(specific_indicator=="SPC" && p_string_val.length==0){
		err_txt=getMessage("APP-OT0099","OT");
		
        parent.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
		
		return false;
		

	}
	else {
		
	return true;
	}
	}
	else{
		
		return true;
	}

}
function checkIsValidForProceed()
{

	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}
//******************************************************************************************************
function setValue(obj){
	if (obj.checked){
		obj.value="Y";
	}
}
function apply(){

	if (! (checkIsValidForProceed()) )
    {
		message  = getMessage("APPLY_NOT_VALID",'MR');
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
    } 
    

	var list_auth_users=parent.content.f_query_add_mod.DetailFrame.document.forms[0].p_string_val.value;
	
   var masterframe = parent.content.f_query_add_mod.Criteria; 
	var formObj=masterframe.document.forms[0];	
	 var masterframe = parent.content.f_query_add_mod.MasterFrame; 
	  var formObj_f=masterframe.document.forms[0];
	  var specific_indicator=formObj_f.specific_indicator.value;
	if(chkMandatory()){
		 if(chkSpecific_Indicator()){
			  //var stage_code=formObj_f.stage_code.value;
			  var stage_description=formObj_f.stage_description.value;
			  var srl_no=formObj_f.srl_no.value;
			  var color_ind=formObj_f.color_ind.value;
			  var text_color=formObj_f.text_color.value;
			  var cutoff_period=formObj_f.cutoff_period.value;
			  var days_fromVisit=formObj_f.days_fromVisit.value;
			  if(formObj_f.allow_auth.checked)
			     formObj_f.allow_auth.value="Y";
		     else
			      formObj_f.allow_auth.value="N";

			  var action_ifnot_done=formObj_f.action_ifnot_done.value;
			/*if(formObj.term_set_1.checked)
				parent.content.f_query_add_mod.Criteria.document.getElementById("term_set").value="Y";
			else
				parent.content.f_query_add_mod.Criteria.document.getElementById("term_set").value="N";

			if(formObj.term_code_1.checked)
				parent.content.f_query_add_mod.Criteria.document.getElementById("term_code").value="Y";
			else
				parent.content.f_query_add_mod.Criteria.document.getElementById("term_code").value="N";

			if(formObj.term_desc_1.checked)
				 parent.content.f_query_add_mod.Criteria.document.getElementById("term_desc").value="Y";
			else
				 parent.content.f_query_add_mod.Criteria.document.getElementById("term_desc").value="N";
*/
			/*if(formObj.diagnosis_clasifi_1.checked)
				parent.content.f_query_add_mod.Criteria.document.getElementById("diagnosis_clasifi").value="Y";
			else
				parent.content.f_query_add_mod.Criteria.document.getElementById("diagnosis_clasifi").value="N";

			if(formObj.accuracy_1.checked)
				parent.content.f_query_add_mod.Criteria.document.getElementById("accuracy").value="Y";
			else
				parent.content.f_query_add_mod.Criteria.document.getElementById("accuracy").value="N";

			if(formObj.severity_1.checked)
				parent.content.f_query_add_mod.Criteria.document.getElementById("severity").value="Y";
			else
				parent.content.f_query_add_mod.Criteria.document.getElementById("severity").value="N";

			if(formObj.priority_1.checked)
				parent.content.f_query_add_mod.Criteria.document.getElementById("priority").value="Y";
			else
				parent.content.f_query_add_mod.Criteria.document.getElementById("priority").value="N";

			if(formObj.onset_type_1.checked)
				parent.content.f_query_add_mod.Criteria.document.getElementById("onset_type").value="Y";
			else
				parent.content.f_query_add_mod.Criteria.document.getElementById("onset_type").value="N";

			if(formObj.onset_date_1.checked)
				parent.content.f_query_add_mod.Criteria.document.getElementById("onset_date").value="Y";
			else
				parent.content.f_query_add_mod.Criteria.document.getElementById("onset_date").value="N";

			if(formObj.applicable_side_1.checked)
				parent.content.f_query_add_mod.Criteria.document.getElementById("applicable_side").value="Y";
			else
				parent.content.f_query_add_mod.Criteria.document.getElementById("applicable_side").value="N";

			if(formObj.status_1.checked)
				parent.content.f_query_add_mod.Criteria.document.getElementById("status").value="Y";
			else
				parent.content.f_query_add_mod.Criteria.document.getElementById("status").value="N";

			if(formObj.asOn_Date_1.checked)
				parent.content.f_query_add_mod.Criteria.document.getElementById("asOn_Date").value="Y";
			else
				parent.content.f_query_add_mod.Criteria.document.getElementById("asOn_Date").value="N";

			if(formObj.remarks_1.checked)
				parent.content.f_query_add_mod.Criteria.document.getElementById("remarks").value="Y";
			else
				parent.content.f_query_add_mod.Criteria.document.getElementById("remarks").value="N";*/

                 
			// parent.content.f_query_add_mod.Criteria.document.getElementById("stage_code").value=stage_code;
				parent.content.f_query_add_mod.Criteria.document.getElementById("stage_description").value=stage_description;
				parent.content.f_query_add_mod.Criteria.document.getElementById("srl_no").value=srl_no;
				parent.content.f_query_add_mod.Criteria.document.getElementById("color_ind").value=color_ind;
				parent.content.f_query_add_mod.Criteria.document.getElementById("text_color").value=text_color;
				parent.content.f_query_add_mod.Criteria.document.getElementById("specific_indicator").value=specific_indicator;
				parent.content.f_query_add_mod.Criteria.document.getElementById("cutoff_period").value=cutoff_period;
				parent.content.f_query_add_mod.Criteria.document.getElementById("days_fromVisit").value=days_fromVisit;
				parent.content.f_query_add_mod.Criteria.document.getElementById("isConfirmApplicable").value=formObj_f.isConfirmApplicable.value; // added by mujafar for ML-MMOH-CRF-0878 START
				if(parent.content.f_query_add_mod.Criteria.document.getElementById("isConfirmApplicable").value == "true")
				parent.content.f_query_add_mod.Criteria.document.getElementById("confirm_not_appl").value=formObj_f.confirm_not_appl.value; // END
				parent.content.f_query_add_mod.Criteria.document.getElementById("allow_auth").value=formObj_f.allow_auth.value;
				parent.content.f_query_add_mod.Criteria.document.getElementById("action_ifnot_done").value=action_ifnot_done;		 
				parent.content.f_query_add_mod.Criteria.document.getElementById("list_auth_users").value=list_auth_users;
				parent.content.f_query_add_mod.Criteria.document.getElementById("diagnosis_clasifi").disabled=false;
				parent.content.f_query_add_mod.Criteria.document.getElementById("status").disabled=false;
				parent.content.f_query_add_mod.Criteria.document.getElementById("proc_status_yn").disabled=false;
				parent.content.f_query_add_mod.Criteria.document.forms[0].submit();
			  }
		 }
	}
	


//******************************************************************************************************
function onSuccess(){
	
	f_query_add_mod.location.reload();
}
//******************************************************************************************************
function query()
{
	
	f_query_add_mod.location.href='../../eMR/jsp/RecodePrivilegeSetupQueryCriteria.jsp';
}
//*******************************************************************************************************
function refresh(){
	
	var _spec_user_id=document.getElementById("_spec_user_id").value;
	var _update_mode_yn=document.getElementById("_update_mode_yn").value;
	var _specific_ind=document.getElementById("_specific_ind").value;
	
	
	if(_update_mode_yn=="update_db"){ window.parent.parent.frames[1].DetailFrame.location.href="../../eMR/jsp/RecordPriviegeStageDetailForm.jsp?_update_mode_yn="+_update_mode_yn+"&all_user="+encodeURIComponent(_spec_user_id)+"&_specific_ind="+_specific_ind+"";    
	//+params;;             
	}
	else{
 window.parent.parent.frames[1].DetailFrame.location.href='../../eMR/jsp/RecordPriviegeStageDetailForm.jsp?';              //+params;;  
	}
}
function setConfirmValue(){  // added by mujafar for ML-MMOH-CRF-0878
	if(document.getElementById("confirm_not_appl").checked==true)
		document.getElementById("confirm_not_appl").value="Y";
	else
		document.getElementById("confirm_not_appl").value="N";
}

//*******************************************************************************************************
async function callUsercode(obj,target){
	var locale = document.getElementById("locale").value;
	var facility_id=document.getElementById("facility_id").value;
	
	var masterframe=window.parent.frames[0];
	
	var obj =      document.forms[0].user_id;
	var target = document.forms[0].user_name;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var title=getLabel("Common.userid.label","common");

//var sql="SELECT  A.APPL_USER_ID CODE, B.APPL_USER_NAME DESCRIPTION FROM SM_FACILITY_FOR_USER A, SM_APPL_USER B WHERE A.APPL_USER_ID = B.APPL_USER_ID AND NVL (B.EFF_STATUS, 'E') = 'E' AND A.FACILITY_ID = '"+facility_id+"' AND UPPER (B.APPL_USER_NAME) LIKE UPPER (?) AND UPPER (A.APPL_USER_ID) LIKE UPPER (?) AND FUNC_ROLE_ID IN (SELECT PRACTITIONER_ID FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+locale+"') AND A.APPL_USER_ID NOT IN ( SELECT APPL_USER_ID FROM MR_RECODE_PRIVI_SETUP_DTL C WHERE C.FACILITY_ID='"+facility_id+"') ORDER BY 2";

var sql="SELECT A.APPL_USER_ID CODE, B.APPL_USER_NAME DESCRIPTION FROM SM_FACILITY_FOR_USER A,SM_APPL_USER B,AM_USER_FOR_OPER_STN C,AM_OPER_STN D WHERE A.APPL_USER_ID = B.APPL_USER_ID AND NVL (B.EFF_STATUS, 'E') = 'E' AND A.FACILITY_ID = '"+facility_id+"' AND A.appl_user_id=C.appl_user_id and A.facility_id=C.facility_id  and C.OPER_STN_ID=D.OPER_STN_ID AND  D.FACILITY_ID=C.FACILITY_ID AND (D.DIAG_PROC_RECODE_FOR_IP_YN ='Y' OR D.DIAG_PROC_RECODE_FOR_OP_YN='Y') AND UPPER (B.APPL_USER_NAME) LIKE UPPER (?) AND UPPER (A.APPL_USER_ID) LIKE UPPER (?)  AND FUNC_ROLE_ID IN (SELECT PRACTITIONER_ID FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+locale+"')  AND A.APPL_USER_ID NOT IN (SELECT APPL_USER_ID FROM MR_RECODE_PRIVI_SETUP_DTL C WHERE C.FACILITY_ID='"+facility_id+"') ORDER BY 2";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";

	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	retVal = await CommonLookup( title, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		obj.value = arr[0];
		target.value=arr[1];
	}else{
		target.value="";
		obj.value="";
	}

}
function disable_field(){
	document.getElementById("authorise").disabled=true;
	if(parent.frames[1].document.getElementById("allow_auth").checked)
		document.getElementById("authorise").disabled=false;
}
// function setCheckValue(){}
function setCheckValue(){
	if(document.getElementById("allow_auth").checked==true){
		document.getElementById("allow_auth").value="Y";
		eval("parent.frames[3].document.getElementById('authorise')").disabled = false;
//		eval("parent.frames[3].document.getElementById("authorise")").disabled=false;
	}
	else{
		document.getElementById("allow_auth").value="N";
		parent.frames[3].document.getElementById("authorise").checked=false;
		eval("parent.frames[3].document.getElementById('authorise')").disabled = true;
//		eval("parent.frames[3].document.getElementById("authorise")").disabled = true;
	}

}
function setAllusers(){
	if(document.getElementById("specific_indicator").value=="*ALL"){
		parent.frames[3].document.getElementById("authorise").checked=false;
		parent.frames[3].document.getElementById("authorise").value="N";
		parent.frames[3].document.getElementById("authorise").disabled=true;
	}
}
/*function auth_disable(){
	if(parent.frames[0].document.getElementById("allow_auth").value=="on")
		parent.frames[0].document.getElementById("allow_auth").value="N";
	else
		parent.frames[0].document.getElementById("allow_auth").value="Y"

	if(parent.frames[0].document.getElementById("allow_auth").value=="N"){
			document.getElementById("authorise").disabled=true;
	}
	else
		document.getElementById("authorise").disabled=false;

	}
*/
function alreadyExist(){
	var formObj = document.RecodePrivilegeSetupUserDetail;
	var codeDtl =document.getElementById("p_string_val").value; //detail frame
	var codeRecord=document.getElementById("user_id").value;

	
	if(codeDtl.indexOf(codeRecord)>=0)  {

		document.forms[0].user_id.value="";
	document.forms[0].user_name.value="";
	if(parent.frames[0].document.getElementById("allow_auth").checked){
		document.forms[0].authorise.checked=false;


	}
	else
		{
		document.forms[0].authorise.value="";
		document.forms[0].authorise.disabled=true;
		}
	parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+getMessage('RECORD_ALREADY_EXISTS','Common');
	return ;
    }else       
	  return true;
	}

function chkEmpty(){
	 var userid=getLabel("Common.userid.label",'Common');
	var formObj = document.RecodePrivilegeSetupUserDetail;
	var fields = new Array(formObj.user_id);
	var names = new Array(userid);
	var messageFrame = window.parent.parent.messageFrame;
	if(checkFieldsofMst( fields, names, messageFrame))
		return true;
}
function alreadyExist_Modify(){
	var formObj = document.RecodePrivilegeSetupUserDetail;
	var codeDtl =window.parent.parent.frames[1].DetailFrame.document.forms[0].p_string_val.value; //detail frame
	var codeRecord=document.getElementById("user_id").value;
	
	if(codeDtl.indexOf(codeRecord)>=0)  {
	parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+getMessage('RECORD_ALREADY_EXISTS','Common');
	return ;
    }else       
	  return true;

}
function addRow_Select(){

	if(document.getElementById("modify").value=='modify'){
		
		var p_string_val ="";
		var user_id = document.getElementById("user_id").value;
		var user_name = document.getElementById("user_name").value;
		if(chkEmpty()){
			 parent.parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp';
			
		var authorise=""
			 if(document.getElementById("authorise").checked)
				 authorise="Y";
			 else
				 authorise="N";
			
		var p_string_newVal="";
		p_string_val=window.parent.parent.frames[1].DetailFrame.document.forms[0].p_string_val.value;
		var update_modify_string=window.parent.parent.frames[1].RecordFrame.document.forms[0].update_modify_string.value;
		
		
		if(p_string_val.indexOf(user_id)>=0){
			p_string_val =update_modify_string+ user_id +'`'+ user_name + '`' + authorise + '~';
		}
			else 
			  p_string_val =p_string_val+ user_id +'`'+ user_name + '`' + authorise + '~'  ;


			/*Thursday, March 26, 2009 
			*/

			var unChkAllAuth="";
						if(parent.frames[0].document.getElementById("allow_auth").checked){
							
							unChkAllAuth="";
						 }
						 else{
							
							unChkAllAuth="unChk";
						 }
			
			 window.parent.parent.frames[1].DetailFrame.location.href="../../eMR/jsp/RecordPriviegeStageDetailForm.jsp?unChkAllAuth="+unChkAllAuth+"&p_string_val="+encodeURIComponent(p_string_val)+"";

			document.forms[0].user_id.value="";
			document.forms[0].user_name.value="";
			document.forms[0].authorise.checked=false;
		
		}	
		 
	}
	else{
		
		var p_string_val ="";
		 var user_id = document.getElementById("user_id").value;
		 var user_name = document.getElementById("user_name").value;
		 
		 if(chkEmpty()&&alreadyExist()&&alreadyExist_Modify()){
			 parent.parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp';

					 var authorise=""
					 if(document.getElementById("authorise").checked)
						 authorise="Y";
					 else
						 authorise="N";
					p_string_val = window.parent.parent.frames[1].DetailFrame.document.forms[0].p_string_val.value;
					//p_string_val = document.forms[0].p_string_val.value ;

					if (p_string_val==null||p_string_val=='null')
							{
						
								p_string_val = '';
							}
					 p_string_val =p_string_val+ user_id +'`'+ user_name + '`' + authorise + '~'  ;



					 document.forms[0].p_string_val.value=p_string_val;

					 /*
					 Thursday, March 26, 2009 code added for the uncheck all aithrise
					*/
					
						var unChkAllAuth="";
						if(parent.frames[0].document.getElementById("allow_auth").checked){
							
							unChkAllAuth="";
						 }
						 else{
							
							unChkAllAuth="unChk";
						 }

					/*
						end here Thursday, March 26, 2009 code added for the uncheck all aithrise
					 */

					window.parent.parent.frames[1].DetailFrame.location.href="../../eMR/jsp/RecordPriviegeStageDetailForm.jsp?unChkAllAuth="+unChkAllAuth+"&p_string_val="+encodeURIComponent(p_string_val)+"";

					document.forms[0].user_id.value="";
					document.forms[0].user_name.value="";
					document.forms[0].authorise.checked=false;

				}
	}

}
function cancelDetails(){
	
	var user_id=document.forms[0].user_id.value
	var user_name=document.forms[0].user_name.value
		var authorise=""
		if(document.forms[0].authorise.value.checked)
	 authorise="Y";
	else
		authorise="N";
	var p_string_val = window.parent.parent.frames[1].DetailFrame.document.forms[0].p_string_val.value; ;
	var p_string_newval =user_id;


	var flag="";
	
	 if(parent.frames[0].document.getElementById("allow_auth").checked){
		 
		 flag=" ";
	 }
	 else
	{
		 flag="d";
		 
	}

		document.location.href="../../eMR/jsp/RecodePrivilegeSetupUserDetail.jsp?flag="+flag+"&p_mode=mod&p_string_newval="+encodeURIComponent(p_string_newval)+"";
		var remove_column="remove_column";
		window.parent.parent.frames[1].DetailFrame.location.href ="../../eMR/jsp/RecordPriviegeStageDetailForm.jsp?&p_string_newval="+p_string_newval+"&p_string_val="+encodeURIComponent(p_string_val)+"&remove_column="+remove_column+""

			

}
function viewUserDetails(user_id,user_name,auth_user,p_string_val){
	var flag="";
	
	 if(parent.frames[0].document.getElementById("allow_auth").checked){
		 
		 flag=" ";
	 }
	 else
	{
		 flag="d";
		 
	}
//if(parent.parent.frames[1].DetailFrame.document.getElementById("unChkAllAuth").value);
//p_string_val=parent.parent.frames[1].DetailFrame.document.getElementById("unChk_String_Val").value;
		 
	
	
	window.parent.parent.frames[1].RecordFrame.location.href =	"../../eMR/jsp/RecodePrivilegeSetupUserDetail.jsp?&flag="+flag+"&p_string_user_id="+user_id+"&p_string_val="+p_string_val+"&user_id="+user_id+"&user_name="+user_name+"&p_mode=mod"+"&auth_user="+auth_user+"&modify=modify";

	parent.parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp';
}

function ChkApplcationposition(obj){
	var _spec_user_id=document.getElementById("_spec_user_id").value;
	var _update_mode_yn=document.getElementById("_update_mode_yn").value;
	if(obj.value=='*ALL'){
		parent.parent.frames[1].RecordFrame.document.getElementById("user_id_img").style.visibility='hidden';
		window.parent.parent.frames[1].RecordFrame.location.href =	"../../eMR/jsp/RecodePrivilegeSetupUserDetail.jsp?&all_user="+obj.value+"";
                
	}
		else if(obj.value=='SPC'){
			//window.parent.parent.frames[1].RecordFrame.location.href =	"../../eMR/jsp/RecodePrivilegeSetupUserDetail.jsp?&all_user="+obj.value+"";
			var flag="";
			if(document.forms[0].allow_auth.checked==true)
				flag="";
			else
				flag="d";

			window.parent.parent.frames[1].RecordFrame.location.href =	"../../eMR/jsp/RecodePrivilegeSetupUserDetail.jsp?flag="+flag+"&_update_mode_yn="+_update_mode_yn+"&_spec_user_id="+encodeURIComponent(_spec_user_id)+"";

	}
}
function _chkSerialNo(){

	
		
}

function _ChkNumberInput(fld, e, deci)
{

if (parseInt(deci)>0)
   var strCheck = '123';
else
   var strCheck = '123';
	
var whichCode = (window.Event) ? e.which : e.keyCode;
if (whichCode == 13) return true;  // Enter

key = String.fromCharCode(whichCode);  // Get key value from key code

if (strCheck.indexOf(key) == -1) {
	alert("Enter serial number range of 1 2 3");
	parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?';
	
	return false;
}  // Not a valid key

if(key == "." && fld.value.indexOf(key) != -1) return false; // Not more than one '.' char

}
function _chkNumberDB(obj){
	

	var HTMLVal = new String();		
		HTMLVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><BODY class='message' onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMR/jsp/getSerialNoValidation.jsp'><input type='hidden' name='srl_no_valid' id='srl_no_valid' value='"+obj.value+"'></form></BODY></HTML>";
		parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.parent.messageFrame.document.form1.submit();
		
	

}

function _validateSerialNoEqual(){
	
	
	parent.frames[1].frames[0].document.getElementById("allow_auth").checked=true;
	parent.frames[1].frames[0].document.getElementById("allow_auth").disabled=true;
		
}
function _validateSerialNoLess(){
	
	parent.frames[1].frames[0].document.getElementById("allow_auth").checked=false;
	parent.frames[1].frames[0].document.getElementById("allow_auth").disabled=true;
	
}

function _validateSerialNoGrettet(){
	
	parent.frames[1].frames[0].document.getElementById("allow_auth").checked=false;
	parent.frames[1].frames[0].document.getElementById("allow_auth").disabled=false;
	
}
function _validateAuth(){
	parent.frames[1].frames[0].document.getElementById("allow_auth").disabled=false;

}
function _chkValue(){
	if(parent.frames[0].document.getElementById("allow_auth").checked==true){
		
		
		
		document.getElementById("authorise").disabled=false;
	}
	else{
		parent.frames[0].document.getElementById("allow_auth").value="N";
		
		//parent.frames[3].document.getElementById("authorise").checked=false;
		//parent.frames[3].document.getElementById("authorise").value="N";
		
		document.getElementById("authorise").disabled=true;
		
	}

}


function stageAuth(obj,obj2){
if(obj2==0||obj2==null){
	obj2=1;
}
	var stageNo		= obj.value;
	var paramVal	= obj2;
	if(paramVal==stageNo){
		document.forms[0].allow_auth.disabled=false;
//		document.forms[0].allow_auth.checked=false;
//		eval("parent.frames[3].document.getElementById("authorise")").disabled=true;
	}else if(stageNo>paramVal){
		document.forms[0].allow_auth.disabled=false;
//		document.forms[0].allow_auth.checked=true;
//		eval("parent.frames[3].document.getElementById("authorise")").disabled=false;
	}else{
		document.forms[0].allow_auth.disabled=true;
//		document.forms[0].allow_auth.checked=false;
//		eval("parent.frames[3].document.getElementById("authorise")").disabled=true;
	}
	document.forms[0].allow_auth.value="N";

	/*if(finalValue>dbValue)
		document.forms[0].allow_auth.disabled=true;	
	if(finalValue<dbValue)
		document.forms[0].allow_auth.disabled=false;	*/
//	document.forms[0].allow_auth.checked=false;
//	document.getElementById("chkAuth").value="N";
//	parent.frames[3].document.getElementById("authorise").checked=false;
//	parent.frames[3].document.getElementById("authorise").disabled=true;


}



//*******************************************************************************************************
function chkAllZeros(obj){
	
	
	if(obj.value=="000" ||obj.value=="00"||obj.value=="0"){
		alert(getMessage("CUT_OFF_PERIOD_FOR_RECODING",'MR'));
		  obj.focus();
		  obj.select();
		return false;
	}
	else
		return true;

	
}
//******************************************************************************************************************
function validateAuth(obj){

	if(obj.checked){
		

	}
		
	else{
		var user_id=parent.parent.frames[1].RecordFrame.document.getElementById("user_id").value;
	var user_name=parent.parent.frames[1].RecordFrame.document.getElementById("user_name").value;
		
		var authorise=""
		if(parent.parent.frames[1].RecordFrame.document.getElementById("authorise").value.checked)
	 authorise="Y";
	else
		authorise="N";
	var p_string_val = window.parent.parent.frames[1].DetailFrame.document.forms[0].p_string_val.value; ;
	//var p_string_newval =user_id;
	
		
	
		window.parent.parent.frames[1].DetailFrame.location.href ="../../eMR/jsp/RecordPriviegeStageDetailForm.jsp?unChkAllAuth=unChk&p_string_val="+encodeURIComponent(p_string_val)+"";
	}
}
function EnableAlowAuth(){
	var authStage	=	document.forms[0].authStage.value;
	var srl_no			=	document.forms[0].srl_no.value;
	var allow_auth =	document.forms[0].allow_auth;
	var update_mode_yn =	document.forms[0]._update_mode_yn.value;
	var allow_authorization_yn =document.forms[0]._allow_authorization_yn.value;
//	alert(authStage)
//	alert(srl_no)
//	alert("==>"+allow_authorization_yn+"<===")
//		allow_auth.checked=false;
//		eval("parent.frames[3].document.getElementById("authorise")").disabled=true;


if(authStage==0||authStage==null){	//When the Parameter Satge Setup is Zero or Empty;
	authStage=1;	 //Stage Setup is set to 1;
}
if(update_mode_yn==""){//Create Mode
	 if(authStage==srl_no){
		allow_auth.disabled=false;
	 }else{
		allow_auth.disabled=true;	 
	 }
	}else{//Query Mode
		 if(authStage==srl_no){ //Same Level
				allow_auth.disabled=false;
				if(allow_authorization_yn=="Y"){
					allow_auth.checked=true;
					parent.frames[3].document.getElementById('authorise').disabled = false;
//					eval("parent.frames[3].document.getElementById("authorise")").disabled=false;
				}else{
					allow_auth.checked=false;	
					parent.frames[3].document.getElementById('authorise').disabled = true;
//					eval("parent.frames[3].document.getElementById("authorise")").disabled=true;
				}
		}else if(srl_no>authStage){//Higher Level
				allow_auth.disabled=false;
				if(allow_authorization_yn=="Y"){
					allow_auth.checked=true;
					parent.frames[3].document.getElementById('authorise').disabled = false;
//					eval("parent.frames[3].document.getElementById("authorise")").disabled=false;
				}else{
					allow_auth.checked=false;	
					parent.frames[3].document.getElementById('authorise').disabled = true;
//					eval("parent.frames[3].document.getElementById("authorise")").disabled=true;
				}
		}else{
					allow_auth.disabled=true;	 
		}
	}//Query Mode Ends
}

//Added by Kamatchi S for ML-MMOH-CRF-1581
function ecounterStage(obj)
	{		
		var formObj=document.PrivilegeCriteriaForm;
		if(obj.checked)
		{
		   document.getElementById('ipchk').style.display = "inline";
document.getElementById('dchk').style.display = "inline";
document.getElementById('iplbl').style.display = "inline";
document.getElementById('dclbl').style.display = "inline";
document.getElementById('ipchk').checked = true;
document.getElementById('dchk').checked = true;
			obj.value="Y";
		}
		else
		{
			document.getElementById('ipchk').style.display = "none";
document.getElementById('dchk').style.display = "none";
document.getElementById('iplbl').style.display = "none";
document.getElementById('dclbl').style.display = "none";
document.getElementById('ipchk').checked = false;
document.getElementById('dchk').checked = false;


obj.value = "N";

// Setting values for other elements
document.getElementById('inpatient_appl').value = "N";
document.getElementById('daycare_appl').value = "N";

		}
	}

