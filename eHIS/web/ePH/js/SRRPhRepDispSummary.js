  //saved on 29.12.2009


function run() {
	var frmObj = searchFrame.document.formSRRPhRepDlyDispSumm;
	if(frmObj.p_fm_date1.value!='' || frmObj.p_to_date1.value!='')
	{
	
		frmObj.p_fm_date.value = convertDate(frmObj.p_fm_date1.value,'DMYHM',frmObj.p_language_id.value,"en");
		frmObj.p_to_date.value = convertDate(frmObj.p_to_date1.value,'DMYHM',frmObj.p_language_id.value,"en");
		if(validateDate())
		{
			frmObj.submit();
		}
		
	}
	else
	frmObj.submit();
}

function ValidateTime(obj){
	
	//p_fm_date = document.formPhRepDlyDispSumm.p_fm_date;
	if(obj.value!=""){
		
		if(!doDateTimeChk(obj)){
			alert(getMessage("INVALID_DATE_TIME","PH"));
			obj.focus;
			return false;
		}
	}

}

function reset(){
	searchFrame.location.reload();
	
}

function validateDate(){
	
	var formObj = searchFrame.document.formSRRPhRepDlyDispSumm;
	if (formObj.p_fm_date1.value!="" && formObj.p_to_date1.value!=""){
		
		if(!ValidateDateTime(formObj.p_fm_date1,formObj.p_to_date1)){
			
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("FM_DISP_NO_TO_DISP_NO","PH");
			formObj.p_to_date1.focus();
			return false;
		}else{
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
			return true;
		}
	}
}

function populateDispLocs(facility_id, language_id)
{
	var formObj =document.formSRRPhRepDlyDispSumm;
	var bean_id		= formObj.bean_id.value ;
	var bean_name	= formObj.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "SRRPhRepDlyDispSummValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode=populateDispLocs"+"&facility_id="+facility_id+"&locale="+language_id.value, false ) ;
	xmlHttp.send( xmlDoc ) ;
	//alert(xmlHttp.responseText);
	eval(xmlHttp.responseText);
}

function addOption(code,desc){

	var opt = document.createElement("OPTION") ;
	if(desc == "A")
		desc = "--"+getLabel("Common.all.label","Common")+"--";
	opt.text = desc ;
	opt.value = code ;
	document.formSRRPhRepDlyDispSumm.p_disp_locn.add(opt);

}

function clearList(){
	
	var disp_loc_len =document.formSRRPhRepDlyDispSumm.p_disp_locn.options.length;
	for(var i=0;i<disp_loc_len;i++) {
		formSRRPhRepDlyDispSumm.p_disp_locn.remove("p_disp_locn") ;
	}
}

