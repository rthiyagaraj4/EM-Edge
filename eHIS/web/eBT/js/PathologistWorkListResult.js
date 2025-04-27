/*
Added By Niveditha for GHL-CRF-602.1
*/

function selectedRecord(obj){
	if(obj.checked){
		            obj.checked=true;
					obj.value="Y";
					}
			else{
					obj.checked=false;
					obj.value="N";
					document.getElementById("selectAll").checked=false;
					document.getElementById("selectAll").value="N";
					}
}

function getReportingFactility1(obj){
	if(obj.value!="")
		getReportingFactility();
	else{
		document.PathologistWorkListResultForm.reporting_facility_id_name.value ="";
		 document.PathologistWorkListResultForm.reporting_facility_id.value = "";	
	}
}
function getReportingFactility(){
	var reportingFacility = document.PathologistWorkListResultForm.reporting_facility_id_name.value;
	
	var retVal=  new String();
	var dialogTop	= "40";
	var dialogHeight= "10" ;
	var dialogWidth= "40" ;
	var features= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments	= "" ;
	var title= getLabel("Common.RepFacility.label","Common");
	var sql="select facility_id code,facility_name description from sm_facility_param where  status='E'  and upper(facility_id) like upper(?) and upper(facility_name) like upper(?)  ";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = reportingFacility; 
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	
	retArray = CommonLookup(title,argArray);
	if(retArray != null && retArray !=""){
		 document.PathologistWorkListResultForm.reporting_facility_id_name.value = retArray[1];
		 document.PathologistWorkListResultForm.reporting_facility_id.value = retArray[0];	
	}
}
			
function getAssignedPathologist1(obj){
	if(obj.value!="")
		getAssignedPathologist();
	else{
		document.PathologistWorkListResultForm.assign_desc.value = ""; 
		document.PathologistWorkListResultForm.assign_code.value = "";		
	}
}
			
			
function getAssignedPathologist()
{
		var target			= document.PathologistWorkListResultForm.assign_desc.value;
		var scode_userselect = document.PathologistWorkListResultForm.section_code.value;
		var rpf_userselect	= document.PathologistWorkListResultForm.reporting_facility_id.value;
		var locale			= document.PathologistWorkListResultForm.locale.value;

		var retVal			= new String();
		var dialogTop		= "40";
		var dialogHeight	= "10" ;
		var dialogWidth		= "40" ;
		var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		= "" ;
		var title			= getLabel("Common.Assigned.label","COMMON");
		var sql;

		if(rpf_userselect){
			sql= "select sm_appl_user.appl_user_id code, sm_appl_user.appl_user_name description from sm_appl_user, rl_user_dept where sm_appl_user.eff_status = 'E' and sm_appl_user.language_id='"+locale+"' and upper(sm_appl_user.appl_user_id) like upper(?) and upper(sm_appl_user.appl_user_name) like upper(?) and rl_user_dept.SECTION_CODE = '"+scode_userselect+"' and rl_user_dept.OPERATING_FACILITY_ID = '"+rpf_userselect+"' and sm_appl_user.appl_user_id=rl_user_dept.user_id order by 2"; 
		}else if(scode_userselect){
			sql= "select sm_appl_user.appl_user_id code, sm_appl_user.appl_user_name description from sm_appl_user, rl_user_dept where sm_appl_user.eff_status = 'E' and sm_appl_user.language_id='"+locale+"' and upper(sm_appl_user.appl_user_id) like upper(?) and upper(sm_appl_user.appl_user_name) like upper(?) and rl_user_dept.SECTION_CODE = '"+scode_userselect+"' and sm_appl_user.appl_user_id=rl_user_dept.user_id order by 2"; 
		}else{
			sql= "select sm_appl_user.appl_user_id code, sm_appl_user.appl_user_name description from sm_appl_user, rl_user_dept where sm_appl_user.eff_status = 'E' and sm_appl_user.language_id='"+locale+"' and upper(sm_appl_user.appl_user_id) like upper(?) and upper(sm_appl_user.appl_user_name) like upper(?) and sm_appl_user.appl_user_id=rl_user_dept.user_id order by 2"; 
		}

		var argArray		= new Array();
		var namesArray		= new Array();
		var valuesArray		= new Array();
		var datatypesArray	= new Array();
		
		argArray[0] = sql;
		
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		
		retArray = CommonLookup(title,argArray);
		if(retArray != null && retArray !=""){
			 document.PathologistWorkListResultForm.assign_desc.value = retArray[1];
			 document.PathologistWorkListResultForm.assign_code.value = retArray[0];	
		}				
}


function resetCriteria()
{
	parent.pathologistWorkListResultFrame.location.reload();
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
	

}


function insertRecords(){

	if(parent.pathologistWorkListResultFrame.document.PathologistWorkListResultForm !=undefined){
		
	var count=parent.pathologistWorkListResultFrame.document.PathologistWorkListResultForm.count.value;
	var frmobj=parent.pathologistWorkListResultFrame.document.PathologistWorkListResultForm;
	var frmobj1=document.PathologistWorkListResultForm;
	
	var checkedCount=0;
	for (var i=0;i<=count ;i++ ){
			if(eval("frmobj.select"+i).checked==true){
			checkedCount++;
		}
}
	if(checkedCount==0){
		alert(getMessage("NO_RECORDS_HAVE_BEEN_SELECTED","BT"));
		return;
	}
	if(frmobj1.reporting_facility_id.value == ""){
		alert(getMessage("REPORING_FACILITY_PATHOLOGIST_BLANK","BT"));
		return;
	}
	if(frmobj1.assign_code.value == ""){
		alert(getMessage("ASSIGN_PATHOLOGIST_BLANK","BT"));
		return;
	}
	else{
		frmobj1.Remarks.value=frmobj1.Remarks_assign.value;
		parent.pathologistWorkListResultFrame.document.PathologistWorkListResultForm.submit();
		}
	}
}


function selectCheckBoxes(obj){
		
		var count=document.PathologistWorkListResultForm.count.value;

		if(obj.checked){
			
			for(var i=0;i<=count;i++){
				if(document.getElementById("select"+i).disabled== false){
				document.getElementById("select"+i).checked=true;
				document.getElementById("select"+i).value="Y";
				}
			}
		}
		else{
			for(var i=0;i<=count;i++){
				document.getElementById("select"+i).checked=false;
				document.getElementById("select"+i).value="N";
			}
		}

}


function selectedRecord(obj){
	if(obj.checked){
		            obj.checked=true;
					obj.value="Y";
					}
			else{
					obj.checked=false;
					obj.value="N";
					document.getElementById("selectAll").checked=false;
					document.getElementById("selectAll").value="N";
					}
}


function errorCall(){
	alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
	return false;
}

function checkCharRange(obj,length) {    
	var str = document.getElementById("Remarks_assign").value;
	if(str.length>length){
		alert(" Remarks Should be 250 characters only");
		//var res = str.substring(0, 250);
		//document.getElementById("Remarks_assign").value = res;
		//document.PathologistWorkListResultForm.Remarks.value=res;
		obj.focus();
	} 
} 
function showToolTipsForChnFldRmks(obj,strCFldRmks){
	if(strCFldRmks != "" && strCFldRmks.length > 0 && strCFldRmks != null && strCFldRmks != "null")

		obj.title= decodeURIComponent((strCFldRmks + '').replace(/\+/g, '%20'));
}