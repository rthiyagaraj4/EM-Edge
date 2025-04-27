function apply(){
	var formObj=f_query_result_mod.document.Proccode_For_Pract_Result_Form;
	if(formObj){
		var final_linked_codes=formObj.final_linked_codes.value;
		var final_unlinked_codes=formObj.final_unlinked_codes.value;
		if(final_linked_codes=="" && final_unlinked_codes==""){
			alert(f_query_result_mod.getMessage("NO_CHANGE_TO_SAVE","Common"));		
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=&err_value=0";
		}else{
			formObj.submit();
		}
	}else{
		messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=&err_value=0";;
		return ;
	}
}
function reset(){
		var formObj =f_query_criteria_mod.document.Proccode_For_Pract_Criteria_Form;
		var formAll =f_query_criteria_mod.document;
		formObj.reset();
		formAll.change_lookup_to.innerHTML=getLabel("Common.ProcedureCode.label","Common");
		formAll.practitoner_block_id.style.display="none";
		formAll.proc_code_id.style.display="inline";
		formObj.proc_desc.value="";
		formObj.proc_code.value="";
		f_query_result_mod.location.href="../../eCommon/html/blank.html";;
}
function displayResults(){
		var formObj	=document.Proccode_For_Pract_Criteria_Form;
		var link_by		= formObj.link_by.value;
		var link_code	= "";
		var specialty		= formObj.specialty.value;
		var search_by	= formObj.search_by.value;
		var search_criteria	= formObj.search_criteria.value;
		var term_set_id	= formObj.term_set_id.value;
		if(term_set_id==""){
			var err_msg=getMessage('CAN_NOT_BE_BLANK','Comman');
			err_msg=err_msg.replace("$",getLabel("Common.TerminologySet.label",'COMMON'))
			alert(err_msg)
			formObj.term_set_id.focus();
			/*if(formObj.linking_desc.value!=""){
				formObj.linking_desc.value="";
			}*/			
			return;
		}else if(link_by=="PROC_CODE" && formObj.proc_code.value==""){
				var err_msg=getMessage('CAN_NOT_BE_BLANK','Comman');
				err_msg=err_msg.replace("$",getLabel("Common.ProcedureCode.label",'COMMON'))
				alert(err_msg)
				formObj.proc_code.focus();
				return;
		}else if(link_by=="PRACTITIONER" && formObj.pract_code.value==""){
				err_msg=err_msg.replace("$",getLabel("Common.practitioner.label",'COMMON'))
				alert(err_msg)
				formObj.pract_desc.focus();
				return;
		}else	if(search_by.length<3){
			alert("Please specify minimum 3 characters for search.");
			formObj.search_by.focus();
			return;
		}
		if(link_by=="PROC_CODE"){
			link_code=formObj.proc_code.value;
		}else{
			link_code=formObj.pract_code.value;
		}
		parent.f_query_result_mod.location.href="../../eOA/jsp/ProcCodeforPractitionerResult.jsp?link_by="+link_by+"&link_code="+link_code+"&specialty="+specialty+"&search_by="+search_by+"&search_criteria="+search_criteria+"&term_set_id="+term_set_id;


}
function clearAll(){
//	document.Proccode_For_Pract_Criteria_Form.reset();
	parent.f_query_result_mod.location.href="../../eCommon/html/blank.html";
	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
}
function changeLinkingproperties(obj){
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
	var formObj=document.Proccode_For_Pract_Criteria_Form;
	var formAll=document;
	formObj.term_set_id.options[0].selected=true;
	formObj.specialty.options[0].selected=true;
	formObj.search_by.value="";
	parent.f_query_result_mod.location.href="../../eCommon/html/blank.html";
	if(obj.value=="PRACTITIONER"){
			formAll.change_lookup_to.innerHTML=getLabel("Common.practitioner.label","Common");
//			formAll.splty_man_gif.style.visibility="hidden";
			document.getElementById('proc_code_id').style.display="none";
			document.getElementById('practitoner_block_id').style.display="inline";
			formObj.pract_desc.value="";
			formObj.pract_code.value="";
	}else{
//			formAll.splty_man_gif.style.visibility="visible";
			formAll.change_lookup_to.innerHTML=getLabel("Common.ProcedureCode.label","Common");
			document.getElementById('practitoner_block_id').style.display="none";
			document.getElementById('proc_code_id').style.display="inline";
			formObj.proc_desc.value="";
			formObj.proc_code.value="";
	}

}
function changeLinkinglookup(linking_desc,linking_code,onblur){
	var formObj=document.Proccode_For_Pract_Criteria_Form;
	linking_lookup=formObj.link_by.value;
	if(linking_lookup=="PRACTITIONER"){
			if(onblur=="Y"){
				if(linking_desc.value!=""){
					getPractitioner(linking_desc,linking_code);
				}
			}else{
				getPractitioner(linking_desc,linking_code);
			}
			
	}else{
		if(linking_lookup=="PROC_CODE"){
			if(onblur=="Y"){
				getProcdesc(linking_code,linking_desc);
			}else{
				linking_desc.value="";
				getProcedurecode(linking_desc,linking_code);
			}
		}
	}
}
function getProcdesc(proc_code,proc_desc){
		var term_set_id	= document.Proccode_For_Pract_Criteria_Form.term_set_id.value;
		if(term_set_id==""){
			var err_msg=getMessage('CAN_NOT_BE_BLANK','Comman');
			err_msg=err_msg.replace("$",getLabel("Common.TerminologySet.label",'COMMON'))
			alert(err_msg)
			document.Proccode_For_Pract_Criteria_Form.term_set_id.focus();
			document.Proccode_For_Pract_Criteria_Form.proc_code.value="";
			return;					
		}
		htmlval = "<html><body onKeyDown='lockKey()'><form name='MRvalidate' id='MRvalidate' method='post' action='../../eOA/jsp/ServerSideValidation.jsp'><input type='hidden' name='term_set_id' id='term_set_id' value='"+document.forms[0].term_set_id.value+"'><input type='hidden' name='proc_code' id='proc_code' value='"+proc_code.value+"'><input type='hidden' name='from' id='from' value='PROC_PRACT_LINK'></form></body></html>";
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',htmlval);
		parent.messageFrame.document.MRvalidate.submit();
}
/*********Building Procedure Code Lookup Starts***********/
async function getProcedurecode(linking_desc,linking_code){
		var formObj=document.Proccode_For_Pract_Criteria_Form;
		if(formObj.term_set_id.value==""){
			var err_msg=getMessage('CAN_NOT_BE_BLANK','Comman');
			err_msg=err_msg.replace("$",getLabel("Common.TerminologySet.label",'COMMON'))
			alert(err_msg)
			formObj.term_set_id.focus();
			if(formObj.proc_code.value!=""){
				formObj.proc_desc.value="";
				formObj.proc_code.value="";
			}			
			return;
		}
		var temp_term_code = "";
		var term_desc = "";
		var term_code_associated = "";
		var mode ="";
		var mulitple_yn = "";
		var term_set_id= formObj.term_set_id.value;
		var retVal = new String();
		var dialogHeight= "28" ;
		var dialogWidth = "45" ;
		var status = "no";
		var tit = getLabel("Common.ProcedureCode.label",'COMMON');
		var dialogUrl    = "../../eMR/jsp/TermCodeFrameSet.jsp?title="+encodeURIComponent(tit,"UTF-8")+"&term_set_id="+term_set_id+"&mulitple_yn="+mulitple_yn+"&temp_term_code="+temp_term_code+"&term_code_associated="+term_code_associated+"&term_desc="+term_desc;
		if(mode == '2'){
			dialogUrl+= "&Db_term_code="+term_code_associated;
		}
		var dialogArguments = term_set_id ;
		var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		var returnVal = await window.showModalDialog(dialogUrl, term_set_id, dialogFeatures);
		if( returnVal == null || returnVal == "" ){
			formObj.proc_desc.value="";
		}else{
			var retValCode = returnVal.split("||") ;
			var retVal		 = retValCode[0].split("\"") ;
			formObj.proc_code.value=retValCode[0];
			formObj.proc_desc.value=retValCode[1];
			}
		}
/*********Building Procedure Code Lookup Ends***********/
/********Building Practitioner Lookup Starts******************/
function getPractitioner(linking_desc,linking_code){
	var formObj=document.Proccode_For_Pract_Criteria_Form;
	var firstSql					= "";
	var secondSql				 = "";
	var practitionerName     = "";
	var practitionerValue	 = "";
	var specialityCriteria		= "";
	var locale						= document.Proccode_For_Pract_Criteria_Form.locale.value;
	var speciality_code		= document.Proccode_For_Pract_Criteria_Form.specialty.value;
	if(speciality_code!=null){
		specialityCriteria="AND PRIMARY_SPECIALITY_CODE=''"+speciality_code+"";
	}
	linking_desc.value = trimString(linking_desc.value);	
	practitionerName = linking_desc.name;
	practitionerValue = linking_desc.value;

	firstSql="SELECT DISTINCT b.PRACTITIONER_ID,b.PRACTITIONER_NAME,a.PRIMARY_SPECIALITY_DESC primary_specialty,a.PRACT_TYPE_DESC  practitioner_type,b.gender FROM AM_PRACTITIONER_LANG_VW a, AM_PRACTITIONER b  WHERE b.EFF_STATUS='E' AND a.LANGUAGE_ID='"+locale+"' AND b.PRACT_TYPE LIKE (?) AND b.PRIMARY_SPECIALITY_CODE LIKE UPPER(?)AND (UPPER(b.PRACTITIONER_ID) LIKE UPPER(NVL(?,b.PRACTITIONER_ID)) AND UPPER(b.PRACTITIONER_NAME) LIKE UPPER(NVL(?,b.PRACTITIONER_NAME))) AND  b.gender LIKE (?) AND  upper(nvl(b.POSITION_CODE,'123')) like upper(nvl(?,nvl(b.POSITION_CODE,'123'))) and a.PRACTITIONER_ID=b.PRACTITIONER_ID ";

	secondSql="SELECT DISTINCT b.PRACTITIONER_ID,b.PRACTITIONER_NAME,a.PRIMARY_SPECIALITY_DESC primary_specialty,a.PRACT_TYPE_DESC  practitioner_type,b.gender FROM AM_PRACTITIONER_LANG_VW a, AM_PRACTITIONER b  WHERE b.EFF_STATUS='E' AND a.LANGUAGE_ID='"+locale+"' AND b.PRACT_TYPE LIKE (?) AND b.PRIMARY_SPECIALITY_CODE LIKE UPPER(?)AND (UPPER(b.PRACTITIONER_ID) LIKE UPPER(NVL(?,b.PRACTITIONER_ID)) AND UPPER(b.PRACTITIONER_NAME) LIKE UPPER(NVL(?,b.PRACTITIONER_NAME))) AND  b.gender LIKE (?) AND  upper(nvl(b.POSITION_CODE,'123')) like upper(nvl(?,nvl(b.POSITION_CODE,'123'))) and a.PRACTITIONER_ID=b.PRACTITIONER_ID";

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" + encodeURIComponent(practitionerName) + "\"";
	xmlStr += " practName_FValue=\"" + encodeURIComponent(practitionerValue) + "\"";
	xmlStr += " practId_FName=\"" + practitionerName + "\"";
	xmlStr += " sql=\"" +escape(firstSql)+"\"";
	xmlStr += " sqlSec=\"" +escape(secondSql)+"\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" +speciality_code+ "\"";
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	//eval(responseText);	
	//return;
	eval(practSearch(encodeURIComponent(practitionerName),encodeURIComponent(practitionerValue),speciality_code,responseText));

}
async function practSearch(practName_FName,practName_FValue,speciality_code,responseText) {
	var retVal = 	new String();
	var dialogTop = "10px" ;
	var dialogHeight= "450px" ;
	var dialogWidth	= "700px" ;
		
	if(responseText =="true") {        	
	    dialogWidth="70.5";
	}
	
	var status = "no";
	var arguments	= "" ;
	var tit="Pract Search";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	var sqlArray= new Array();
	//var objName="<%=practName_FName%>";
	var objName=practName_FName;
    arguments='';
	
	//retVal = window.showModalDialog("<%=request.getContextPath()%>/eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+"<%=practName_FValue%>"+"&practitioner_type="+"<%=practitioner_type%>"+"&primary_specialty="+"<%=specialty_code%>"+"&job_title="+"<%=job_title%>"+"&gender="+"<%=gender%>",arguments,features);
	
	retVal = await window.showModalDialog("../../eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+practName_FValue+"&practitioner_type="+"\""+"&primary_specialty="+speciality_code+"&job_title="+"\""+"&gender="+"\"",arguments,features);
	PractLookupRetVal(retVal,objName);
}

function PractLookupRetVal(retVal,objName){
var arr;

if (retVal != null){
			arr=retVal.split("~");
			document.forms[0].pract_code.value=arr[0];
			document.forms[0].pract_desc.value=arr[1];
		}else{
			document.forms[0].pract_code.value="";
			document.forms[0].pract_desc.value="";

		}
}

/****************************Practitioner Lookup Ends***************************************************/

function setValue(obj,i){
	var formObj=document.Proccode_For_Pract_Result_Form;
	var final_linked_codes		=formObj.final_linked_codes;
	var final_unlinked_codes	=formObj.final_unlinked_codes;
	var db_linked_codes		=formObj.db_linked_codes;
	var tracking_codes			=formObj.tracking_codes;
	var tot = formObj.final_unlinked_codes.value;
		var arr = tot.split("$");
		var temp_arr ="";
		for(var i=0;i< arr.length;i++){
			var fval=arr[i];
			if(fval!=obj.value){
				temp_arr=temp_arr+arr[i]+"$";
			}
		}
		temp_arr=temp_arr.substring(0,temp_arr.length-1)
		final_unlinked_codes.value=temp_arr;
	if(obj.checked==true){
		var db_tot	=db_linked_codes.value;
		var linked_tot	=final_linked_codes.value;
		var arr = db_tot.split("$");
		var link_arr = linked_tot.split("$");
		var code_exits =false;
		for(var i=0;i<arr.length;i++){
			var fval=link_arr[i];
			var fval1=arr[i];
			if(fval1 == obj.value){
				code_exits=true;
				break;
			}
		}
		if(!code_exits){
			if(final_linked_codes.value==""){
				final_linked_codes.value=obj.value;
			}else{
				final_linked_codes.value=final_linked_codes.value+"$"+obj.value;
			}
		}
	}else{
		var tot = formObj.final_linked_codes.value;
		var arr = tot.split("$");
		var temp_arr ="";
		for(var i=0;i< arr.length;i++){
			var fval=arr[i];
			if(fval!=obj.value){
				temp_arr=temp_arr+arr[i]+"$";
			}
		}
		temp_arr=temp_arr.substring(0,temp_arr.length-1)
		final_linked_codes.value=temp_arr;
		if(final_unlinked_codes.value==""){
			final_unlinked_codes.value=obj.value;
		}else{
			final_unlinked_codes.value=final_unlinked_codes.value+"$"+obj.value;
		}
	}
}
function selectAll(obj){
	var formObj=document.Proccode_For_Pract_Result_Form;
	var tot_num=formObj.total_num.value;
	if(obj.checked==true){
	formObj.final_linked_codes.value="";
	for(var i=0;i<tot_num;i++){
		eval("document.Proccode_For_Pract_Result_Form.linking_box_"+i).checked=true;
		if(formObj.final_linked_codes.value==""){
			formObj.final_linked_codes.value=eval("document.Proccode_For_Pract_Result_Form.linking_box_"+i).value;
		}else{
			formObj.final_linked_codes.value=formObj.final_linked_codes.value+"$"+eval("document.Proccode_For_Pract_Result_Form.linking_box_"+i).value;
		}
	}
	}else{
		for(var i=0;i<tot_num;i++){
			eval("document.Proccode_For_Pract_Result_Form.linking_box_"+i).checked=false;
			formObj.final_linked_codes.value="";
			if(formObj.final_unlinked_codes.value==""){
				formObj.final_unlinked_codes.value=eval("document.Proccode_For_Pract_Result_Form.linking_box_"+i).value;
			}else{
			formObj.final_unlinked_codes.value=formObj.final_unlinked_codes.value+"$"+eval("document.Proccode_For_Pract_Result_Form.linking_box_"+i).value;
			}

		}
	}
}
function onSuccess(){
	f_query_result_mod.location.reload();
}
function buildDBValues(){
	var formObj=document.Proccode_For_Pract_Result_Form;
	var tot_num=formObj.total_num.value;
	var link_box_check="";
	for(var i=0;i<tot_num;i++){
		link_box_check=eval("document.Proccode_For_Pract_Result_Form.linking_box_"+i);
		if(link_box_check.checked==true){
			if(formObj.db_linked_codes.value==""){
				formObj.db_linked_codes.value=eval("document.Proccode_For_Pract_Result_Form.linking_box_"+i).value;
			}else{
			formObj.db_linked_codes.value=formObj.db_linked_codes.value+"$"+eval("document.Proccode_For_Pract_Result_Form.linking_box_"+i).value;
			}
		}
	}
}
function paintDesc(){
	var formObj=parent.f_query_criteria_mod.document.Proccode_For_Pract_Criteria_Form;
	var link_by=formObj.link_by.value
	if(link_by=="PROC_CODE"){
		document.getElementById('paint_desc').innerHTML=getLabel("Common.ProcedureCode.label",'COMMON')+":"+formObj.proc_desc.value;
	}else{
		document.getElementById('paint_desc').innerHTML=getLabel("Common.practitioner.label",'COMMON')+":"+formObj.pract_desc.value;
	}
}	

function openWindw(){
		var dialogHeight= "28" ;
		var dialogWidth = "45" ;
		var status = "no";
		var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		var tit = getLabel("Common.ProcedureCode.label",'COMMON');
		var dialogUrl    = "../../eOA/jsp/Scheduletracking_frames.jsp";
		var returnVal = window.open(dialogUrl,'', dialogFeatures);

}

