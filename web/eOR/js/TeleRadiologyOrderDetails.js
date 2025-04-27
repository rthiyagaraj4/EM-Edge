
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History     Name      			Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
	
06/02/2018		IN065642		Prathyusha P				 		Ramesh G       GHL-CRF-0487 [IN:065642]
14/02/2018      IN066695        Prathyusha p     14/02/2018        Ramesh G        GHL-CRF-0487_US001 [IN:065642]

---------------------------------------------------------------------------------------------------------------------------------------------------------
*/
function getTelRadiologyReporteingFacility1(obj){
		if(obj.value!="")
			getTelRadiologyReporteingFacility();
			
			else{
	        document.TeleRadiologyOrdersResultForm.reporting_facility_id_name.value = ""; 
			document.TeleRadiologyOrdersResultForm.reporting_facility_id.value = "";
	}
			
}
function getTelRadiologyReporteingFacility()
{	
            document.TeleRadiologyOrdersResultForm.assigned_pract_desc.value = ""; 
			document.TeleRadiologyOrdersResultForm.assigned_pract_code.value = "";
	var target			= document.TeleRadiologyOrdersResultForm.reporting_facility_id_name;
	var retArray			= new String();
	var dialogTop	= "40";
	var dialogHeight= "10" ;
	var dialogWidth= "40" ;
	var features= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments	= "" ;
	var search_desc		= "";
	var title= getLabel("Common.RepFacility.label","Common");
	var sql="select facility_id code,facility_name description from sm_facility_param where  status='E' and upper(facility_id) like upper(?)  and upper(facility_name) like upper(?)  ";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value; 
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	
	retArray = CommonLookup( title , argArray )
	
	if(retArray != null && retArray !=""){
		
		document.TeleRadiologyOrdersResultForm.reporting_facility_id_name.value = retArray[1];
		document.TeleRadiologyOrdersResultForm.reporting_facility_id.value = retArray[0];
		//obj.value=retArray[1];
	}
	else{
		
	        document.TeleRadiologyOrdersResultForm.reporting_facility_id_name.value = ""; 
			document.TeleRadiologyOrdersResultForm.reporting_facility_id.value = "";
	}
}
function getAssignPractitioner1(obj){
	if(obj.value!="")
		getAssignPractitioner();
		else
		{
			document.TeleRadiologyOrdersResultForm.assigned_pract_desc.value = ""; 
			document.TeleRadiologyOrdersResultForm.assigned_pract_code.value = "";
			
		} 
}
function getAssignPractitioner()
{
		var target			= document.TeleRadiologyOrdersResultForm.assigned_pract_desc;
		var locale			= document.TeleRadiologyOrdersResultForm.locale.value;
		var spec_code		= document.TeleRadiologyOrdersResultForm.reporting_facility_id.value;
		var retVal			= new String();
		var dialogTop		= "40";
		var dialogHeight	= "10" ;
		var dialogWidth		= "40" ;
		var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		= "" ;
		var search_desc		= "";
		var title			= getLabel("eOR.assigndiag.label","EOR")+" "+getLabel("eOR.radiologist.label","EOR");
		var sql="SELECT   a.practitioner_id code, a.short_name description FROM am_practitioner_lang_vw a, am_pract_for_facility b, RD_RAD_AVAILABILITY_HDR c WHERE a.eff_status = 'E' AND language_id = '"+locale+"' AND UPPER (a.practitioner_id) LIKE UPPER (?) AND UPPER (a.short_name) LIKE UPPER (?) AND a.practitioner_id = b.practitioner_id AND UPPER (b.facility_id)  LIKE UPPER ('"+spec_code+"') AND a.pract_type = 'RD' AND b.facility_id = c.OPERATING_FACILITY_ID AND b.practitioner_id = c.RADIOLOGIST_ID AND c.AVAILABILITY_START_TIME IS NOT NULL AND c.AVAILABILITY_END_TIME IS NULL  and b.eff_status= 'E' ORDER BY 2 ";
		var argArray		= new Array();
		var namesArray		= new Array();
		var valuesArray		= new Array();
		var datatypesArray	= new Array();
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		
		retVal = await CommonLookup( title, argArray )

		if (retVal != null && retVal != '' && retVal != "null")
		{
		   	document.TeleRadiologyOrdersResultForm.assigned_pract_desc.value = retVal[1];
		   	document.TeleRadiologyOrdersResultForm.assigned_pract_code.value = retVal[0];
			
		}
		else
		{
			document.TeleRadiologyOrdersResultForm.assigned_pract_desc.value = ""; 
			document.TeleRadiologyOrdersResultForm.assigned_pract_code.value = "";
			
		} 
				
}
function resetCriteria()
{
	parent.teleRadiologyOrdersResultFrame.location.reload();
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
	

}
function insertRecords(){
	if(parent.teleRadiologyOrdersResultFrame.document.TeleRadiologyOrdersResultForm !=undefined){
	var count=parent.teleRadiologyOrdersResultFrame.document.TeleRadiologyOrdersResultForm.count.value;
	var frmobj=parent.teleRadiologyOrdersResultFrame.document.TeleRadiologyOrdersResultForm;
	var frmobj1=document.TeleRadiologyOrdersResultForm;
	var checkedCount=0;
	for (var i=0;i<=count ;i++ ){
		if(eval("frmobj.select"+i).checked==true){
			checkedCount++;
		}
}
	if(checkedCount==0){
		alert(getMessage("NO_RECORDS_HAVE_BEEN_SELECTED","OR"));
		   return;
	}
	if(frmobj1.reporting_facility_id.value == ""){
		alert(getMessage("REPORINGFACILITYBLANK","OR"));
		   return;
	}
	if(frmobj1.assigned_pract_code.value == ""){
		alert(getMessage("ASSIGNEDPRACTATIONERBLANK","OR"));
		return;
	}
	else{
		frmobj1.Remarks.value=frmobj1.Remarks_assign.value;
		parent.teleRadiologyOrdersResultFrame.document.TeleRadiologyOrdersResultForm.submit();
		}
	}

}
	function selectCheckBoxes(obj){
		
		var count=document.TeleRadiologyOrdersResultForm.count.value;

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

async function callAuditTrail(i){
	
	
	var dialogHeight	= "30" ;
	var dialogWidth		= "70";
	var dialogTop		= "300" ;
	var dialogLeft		= "350" ;
	var center			= "1" ;
	var status			="no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	
	var order_id=document.getElementById("order_id"+i).value;
	var catalog_desc=document.getElementById("catalog_desc"+i).value;
	var ordering_facility_id=document.getElementById("operating_facility_desc"+i).value;
	var ordered_by=document.getElementById("ordered"+i).value;
	var operating_facility_id=document.getElementById("operating_facility"+i).value;
	var performed_by=document.getElementById("performed"+i).value;
	var exam_status=document.getElementById("exam_status"+i).value;
	var request_num=document.getElementById("request_num"+i).value;
	var request_line_num=document.getElementById("request_line_num"+i).value;
	retVal = await window.showModalDialog("../../eOR/jsp/TeleRadiologyOrdersDetail.jsp?order_id="+order_id+"&catalog_desc="+catalog_desc+"&ordering_facility_id="+ordering_facility_id+"&ordered_by="+ordered_by+"&operating_facility_id="+operating_facility_id+"&performed_by="+performed_by+"&exam_status="+exam_status+"&request_num="+request_num+"&request_line_num="+request_line_num,arguments,features);
	
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
		//document.TeleRadiologyOrdersResultForm.Remarks.value=res;
		obj.focus();
	} 
} 
function showToolTipsForChnFldRmks(obj,strCFldRmks){
	
	if(strCFldRmks != "" && strCFldRmks.length > 0 && strCFldRmks != null && strCFldRmks != "null")

		obj.title= decodeURIComponent((strCFldRmks + '').replace(/\+/g, '%20'));
}