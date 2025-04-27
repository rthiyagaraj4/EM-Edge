/* 
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           	?				?				created
01/10/2014    IN051373		Chowminya      									Patient List By PPR Relationship Issue 	
---------------------------------------------------------------------------------------------------------------
*/
function checkOnBlurClinicianType(clinician_type)
{
	resetRelationshipDetails();
	var action_url = getRelativeURL("/eCA/jsp/AssignRelationshipGetClnName.jsp");
	var f = top.content.messageFrame;

	if(document.AssignRelationshipForm.modal_yn.value == "Y")
		f = parent.messageFrame;

	/*var optlength = parent.AssignRelationshipFrame.document.AssignRelationshipForm.clinician_id.options.length;
	for (var i=0; i<optlength; i++)
	{
		parent.AssignRelationshipFrame.document.AssignRelationshipForm.clinician_id.options.remove("clinician_id");
	}*/

	parent.AssignRelationshipFrame.document.AssignRelationshipForm.clinician_name.value='';

	if( clinician_type.value!='')
	{
		var optlength1 = parent.AssignRelationshipFrame.document.AssignRelationshipForm.relationship.options.length;
		for (var i=0; i<optlength1; i++)
		{
			parent.AssignRelationshipFrame.document.AssignRelationshipForm.relationship.options.remove("relationship");
		}
		var opt=parent.AssignRelationshipFrame.document.createElement('OPTION'); 
		opt.text	=	"-----"+getLabel("Common.defaultSelect.label",'COMMON')+"----";
		opt.value	=	'';
		parent.AssignRelationshipFrame.document.forms[0].relationship.add(opt); 
		var limitPractList = "";
		if(parent.AssignRelationshipFrame.document.AssignRelationshipForm.chkLimitPractList.checked){
			limitPractList="Y";
		}else{
			limitPractList="N";		
		}

		var temp_episode_type = "";
		var temp_location_code ="";
		
		temp_episode_type = parent.AssignRelationshipFrame.document.AssignRelationshipForm.episode_type.value;
		temp_location_code = parent.AssignRelationshipFrame.document.AssignRelationshipForm.location_code.value;
		
		patient_id = parent.AssignRelationshipFrame.document.AssignRelationshipForm.patient_id.value;
		episode_id = parent.AssignRelationshipFrame.document.AssignRelationshipForm.episode_id.value;

		//dha

		var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='AssignRelationshipGetClnNameForm' id='AssignRelationshipGetClnNameForm' method='get' action='"+action_url+"'>"+
		"<input type='hidden' name='clinician_type' id='clinician_type' value='"+clinician_type.value+"'>"+
		"<input type='hidden' name='modal_yn' id='modal_yn' value='"+document.AssignRelationshipForm.modal_yn.value+"'>"+
		"<input type='hidden' name='limitPractList' id='limitPractList' value='"+limitPractList+"'>"+
		"<input type='hidden' name='episode_type' id='episode_type' value='"+temp_episode_type+"'>"+
		"<input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'>"+
		"<input type='hidden' name='episode_id' id='episode_id' value='"+episode_id+"'>"+
		"<input type='hidden' name='location_code' id='location_code' value='"+temp_location_code+"'>"+
		"</form></body></html>";
		f.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
		f.document.AssignRelationshipGetClnNameForm.submit();
	
	}
	else
	{
		/*var opt=parent.AssignRelationshipFrame.document.createElement('OPTION'); 
		opt.text	=	"-----"+getLabel("Common.defaultSelect.label",'COMMON')+"----";

		opt.value	=	'';
		parent.AssignRelationshipFrame.document.forms[0].clinician_id.add(opt); */

		parent.AssignRelationshipFrame.document.forms[0].clinician_name.value='';
		
		var opt=parent.AssignRelationshipFrame.document.createElement('OPTION'); 
		opt.text	="------"+	getLabel("Common.defaultSelect.label",'COMMON');+"-----";
		opt.value	=	'';
		parent.AssignRelationshipFrame.document.forms[0].relationship.add(opt); 
	}
}

function getRelativeURL(targetURL)
{

	var url='';
	if(document.AssignRelationshipForm.modal_yn.value == "N"){
		url= top.content.messageFrame.location.href;
	}else{
		
		dialogFrame = top.document.getElementById("dialog-body")?top.document.getElementById("dialog-body").contentWindow:"";
		
		if(dialogFrame)
		url= dialogFrame.messageFrame.location.href;
		else
		url=top.content.messageFrame.location.href;
	}
	
	var action_url =targetURL;
	if(url.indexOf("/servlet")!=-1)
	{
		action_url = ".."+targetURL;
	}
	else
	{
		action_url = "../.."+targetURL;
	}
	return action_url;
}

function checkOnBlurClinicianName(clinician_name)
{
	resetRelationshipDetails();
	var action_url = getRelativeURL("/eCA/jsp/AssignRelationshipGetReln.jsp");

	var f = top.content.messageFrame;

	if(document.AssignRelationshipForm.modal_yn.value == "Y")
		f = parent.messageFrame;

	var optlength = parent.AssignRelationshipFrame.document.AssignRelationshipForm.relationship.options.length;
	for (var i=0; i<optlength; i++)
	{
		parent.AssignRelationshipFrame.document.AssignRelationshipForm.relationship.options.remove("relationship");
	}
	
	var whereClause		=	document.forms[0].whereClause;
	var boundCount		=	document.forms[0].boundCount;
	var patient_id		=	document.forms[0].patient_id;
	var episode_type	=	document.forms[0].episode_type;
	var episode_id		=	document.forms[0].episode_id;
	var visit_id		=	document.forms[0].visit_id;
	var phys_prov_id	=	document.forms[0].phys_prov_id;

	//alert(whereClause.value);
	var clinician_type = parent.AssignRelationshipFrame.document.AssignRelationshipForm.clinician_type;
	
	var clinician_id = parent.AssignRelationshipFrame.document.AssignRelationshipForm.clinician_id;
	//alert(clinician_type.value);
	var optlength = parent.AssignRelationshipFrame.document.AssignRelationshipForm.relationship.options.length;
	for (var i=0; i<optlength; i++)
	{
		parent.AssignRelationshipFrame.document.AssignRelationshipForm.relationship.options.remove("relationship");
	}
	
	if( clinician_name.value!='')
	{
		var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='AssignRelationshipGetRelnForm' id='AssignRelationshipGetRelnForm' method='get' action='"+action_url+"'>"+
		"<input type='hidden' name='clinician_id' id='clinician_id' value='"+clinician_id.value+"'>"+
		"<input type='hidden' name='clinician_type' id='clinician_type' value='"+clinician_type.value+"'>"+
		"<input type='hidden' name='whereClause' id='whereClause' value=\""+whereClause.value+"\">"+
		"<input type='hidden' name='boundCount' id='boundCount' value=\""+boundCount.value+"\">"+
		"<input type='hidden' name='patient_id' id='patient_id' value=\""+patient_id.value+"\">"+
		"<input type='hidden' name='episode_type' id='episode_type' value=\""+episode_type.value+"\">"+
		"<input type='hidden' name='episode_id' id='episode_id' value=\""+episode_id.value+"\">"+
		"<input type='hidden' name='visit_id' id='visit_id' value=\""+visit_id.value+"\">"+
		"<input type='hidden' name='phys_prov_id' id='phys_prov_id' value=\""+phys_prov_id.value+"\">"+
		"<input type='hidden' name='modal_yn' id='modal_yn' value='"+document.AssignRelationshipForm.modal_yn.value+"'>"+
		"</form></body></html>";
		f.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
		f.document.AssignRelationshipGetRelnForm.submit();
	}
	else
	{
		var opt = parent.AssignRelationshipFrame.document.createElement('OPTION'); 
		opt.text	=	"-----"+getLabel("Common.defaultSelect.label",'COMMON')+"----";
		opt.value	=	'';
		parent.AssignRelationshipFrame.document.forms[0].relationship.add(opt); 
	}
}

function checkOnBlurRelationship(phys_prov_reln_id)
{
	//IN051373 - Start
	var rule = "";
	var pat_discharge_yn="N";

	if(phys_prov_reln_id.value!='') 
	{	
		
		var val = phys_prov_reln_id.value.split("~");
		phys_prov_reln_id = val[0];
		rule = val[1];
		pat_discharge_yn = document.forms[0].pat_discharged_yn.value;
		var patient_class = document.forms[0].patient_class.value;

		if(pat_discharge_yn == "Y" && (rule == "DAD" || rule == "DAT" || rule == "HAD" || rule == "HAT"))
		{	
			if(patient_class == "OP" || patient_class == "EM" )
			{	
				alert(getMessage("PAT_CHKD_OUT","CA"));
			}	
			else if(patient_class == "IP" || patient_class == "DC")
			{	
				alert(getMessage("PAT_DISCHARGED","CA"));
			}
			
			document.forms[0].relationship.value = "";	
		}
		else
			pat_discharge_yn = "N";
	}
	//IN051373 - End
	//Added if condition - IN051373
	if(pat_discharge_yn != "Y")
	{	
		//if(phys_prov_reln_id.value=="")  // IN051373
		if(phys_prov_reln_id=="") 
		{
			document.forms[0].expiry_based_yn.checked=false;
			document.forms[0].expiry_rule.value = "";
			document.forms[0].start_date.value = "";
			document.forms[0].end_date.value = "";
		}
		var f = "";
		//var f = top.content.messageframe;
		
		hyperLinkStartDate = parent.AssignRelationshipFrame.document.getElementById("hyperLinkStartDate").value;
		hyperLinkEndDate = parent.AssignRelationshipFrame.document.getElementById("hyperLinkEndDate").value; 
	
		if(document.AssignRelationshipForm.modal_yn.value == "Y"){
			f = parent.messageFrame;
		}else{
			f = top.content.messageFrame;
		}
	
		var action_url = getRelativeURL("/eCA/jsp/AssignRelationshipGetRelnDtls.jsp");
		//var action_url = "../../eCA/jsp/AssignRelationshipGetRelnDtls.jsp";
		//if( phys_prov_reln_id.value!='')  //IN051373
		if( phys_prov_reln_id!='')
		{
			
			var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><body onKeyDown='lockKey()'><form name='AssignRelationshipGetRelnDtlsForm' id='AssignRelationshipGetRelnDtlsForm' method='get' action='"+action_url+"'>"+
			"<input type='hidden' name='phys_prov_reln_id' id='phys_prov_reln_id' value='"+phys_prov_reln_id+"'>"+
			"<input type='hidden' name='hyperLinkStartDate' id='hyperLinkStartDate' value='"+hyperLinkStartDate+"'>"+
			"<input type='hidden' name='hyperLinkEndDate' id='hyperLinkEndDate' value='"+hyperLinkEndDate+"'>"+
			"<input type='hidden' name='modal_yn' id='modal_yn' value='"+document.AssignRelationshipForm.modal_yn.value+"'>"+
			"</form></body></html>";
			f.document.write(HTMLVal);
			 f.document.AssignRelationshipGetRelnDtlsForm.submit();
	
			//f.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
			//f.document.AssignRelationshipGetRelnDtlsForm.submit();
		}
	}
}


function checkOnSubAssignRelationship()
{
	//var f = top.content.messageframe;
	var f ="";
	
	if(document.AssignRelationshipForm.modal_yn.value == "Y"){
		f = parent.messageFrame;
	}else{
		f = top.content.messageFrame;
	}

	var clinician_type = document.forms[0].clinician_type;
	var clinician_name = document.forms[0].clinician_name;
	var clinician_id = document.forms[0].clinician_id;
	var relationship = document.forms[0].relationship;
	var reason= document.forms[0].reason;//0605.5
	

	var tempTerminate = "";
	var temp = parent.AssignRelationshipFrame.document.getElementById("tdTerminate").style.display;
	//if(temp == 'inline'){
	if(temp == ''){
		if(document.forms[0].chkTerminate.checked){
			tempTerminate = "Y";
		}else{
			tempTerminate = "N";
		}
	}else{
		tempTerminate = "N";	
	}
	var msg = "";
	var fields="";
	var name="";

	if(document.forms[0].remarks_relationships_yn.value=="Y" && document.forms[0].episode_id.value==""){
		fields	=	new Array ( clinician_type, clinician_name, relationship,reason );
		names	=	new Array ( getLabel("Common.practitionertype.label",'COMMON'), getLabel("Common.practitionername.label",'COMMON'), getLabel("Common.relationship.label",'COMMON'),getLabel("eCA.Reason.label",'CA_LABEL'));
	
	}else{
		fields	=	new Array ( clinician_type, clinician_name, relationship );
		names	=	new Array ( getLabel("Common.practitionertype.label",'COMMON'), getLabel("Common.practitionername.label",'COMMON'), getLabel("Common.relationship.label",'COMMON') );
	}

	/*Here Additional checking for modal window starts*/
	if(document.AssignRelationshipForm.modal_yn.value == "Y"){
		if((checkFieldsofMst(fields,names,f))){
			document.forms[0].act_clinician_type.value = clinician_type.value;
			document.forms[0].act_clinician_id.value = clinician_id.value;
			document.forms[0].target = f.name;
			parent.AssignRelationshipFrame.AssignRelationshipForm.terminate.value = tempTerminate;
			var html = "<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='dummyFormSubmit' id='dummyFormSubmit'  action='../../servlet/eCA.AssignRelationshipServlet' method='post'>";
			for(var i=0;i<document.AssignRelationshipForm.elements.length;i++){
				var n = parent.AssignRelationshipFrame.AssignRelationshipForm.elements[i].name;
				var v = parent.AssignRelationshipFrame.AssignRelationshipForm.elements[i].value;
				html += "<input type=hidden name='"+n+"' id='"+n+"' value='"+v+"'>";
			}
			html+="</form></body></html>";
			parent.messageFrame.document.body.insertAdjacentHTML("afterbegin",html);
			parent.messageFrame.dummyFormSubmit.submit();	
		}
	}else{
		if((checkFields(fields,names,f))){
			parent.AssignRelationshipFrame.document.getElementById("clinician_type").disabled = false;
			parent.AssignRelationshipFrame.document.getElementById("clinician_id").disabled = false;
			parent.AssignRelationshipFrame.document.getElementById("relationship").disabled = false;
			parent.AssignRelationshipFrame.document.getElementById("terminate").value = tempTerminate;


			//dha document.forms[0].target=parent.parent.parent.frames[5].name;
			document.forms[0].target=f.name;
			document.forms[0].submit();

			var temp = parent.AssignRelationshipFrame.document.getElementById("tdTerminate").style.display;
			if(temp == 'inline'){
				parent.AssignRelationshipFrame.document.getElementById("clinician_type").disabled = true;
				parent.AssignRelationshipFrame.document.getElementById("clinician_id").disabled = true;
				parent.AssignRelationshipFrame.document.getElementById("relationship").disabled = true;
			}
		}
	}
	/*Here Additional checking for modal window ends*/
}

function checkIsNull(obj)
{
	if(trimCheck(obj.value)=="")
		return true;
	else
		return false;
}

function callAssignRelationship()
{
	//resetRelationshipDetails();
	var action_url = getRelativeURL("../../eCA/jsp/AssignRelationship.jsp");

	var query_string = document.forms[0].query_string.value;
	parent.AssignRelationshipFrame.location.href = action_url+'?'+query_string;
}

function resetRelationshipDetails()
{
	var expiry_based_yn = document.forms[0].expiry_based_yn;
	var expiry_rule = document.forms[0].expiry_rule;
	var start_date = document.forms[0].start_date;
	var end_date = document.forms[0].end_date;

	var optlength = parent.AssignRelationshipFrame.document.AssignRelationshipForm.relationship.options.length;
	for (var i=0; i<optlength; i++)
	{
		parent.AssignRelationshipFrame.document.AssignRelationshipForm.relationship.options.remove("relationship");
	}
	//document.AssignRelationshipForm.relationship.selectedIndex=0;
	expiry_based_yn.checked =	false;
	expiry_rule.value		=	"";
	start_date.value		=	"";
	end_date.value			=	"";
}

function callOnCancel()
{
	if(document.AssignRelationshipForm.modal_yn.value == "Y")
	{
		
		//parent.window.close();
		parent.parent.document.getElementById('dialog_tag').close();
	}
	else
	{
		top.content.workAreaFrame.location.href = '../../eCommon/html/blank.html';
		top.content.messageFrame.location.href = '../../eCommon/jsp/error.jsp';
		//var query_string = top.secondframe.thirdframe.AssignRelationshipViewFrame.document.AssignRelationshipForm.query_string.value;
		//var action_url = getRelativeURL('/eCA/jsp/AssignRelationshipMain.jsp')
		//document.location.href = action_url+'?'+query_string;
	}
}

function callClear()
{
	if(parent.AssignRelationshipFrame.document.getElementById("record").disabled==true)
	parent.AssignRelationshipFrame.document.getElementById("record").disabled=false;

	parent.AssignRelationshipFrame.document.getElementById("clinician_type").disabled = false;
	parent.AssignRelationshipFrame.document.getElementById("clinician_name").disabled = false;
	parent.AssignRelationshipFrame.document.getElementById("relationship").disabled = false;
	var temp = parent.AssignRelationshipFrame.document.getElementById("tdTerminate").style.display;
	//if(temp == 'inline'){
	if(temp == ''){
		parent.AssignRelationshipFrame.document.getElementById("tdTerminate").style.display = 'none'
		parent.AssignRelationshipFrame.document.getElementById("tempRelation").style.display = 'inline';	
		parent.AssignRelationshipFrame.document.getElementById("tempCheckList").style.display = '';	
	}
	/*var check1 = parent.AssignRelationshipFrame.document.getElementById("clinician_id").length;
	for(var i=0;i<check1;i++){
		parent.AssignRelationshipFrame.document.AssignRelationshipForm.clinician_id.options.remove("clinician_id");
	}
	var opt=parent.AssignRelationshipFrame.document.createElement('OPTION'); 
	opt.text	=	"-----"+getLabel("Common.defaultSelect.label",'COMMON')+"----";
	opt.value	=	'';
	parent.AssignRelationshipFrame.document.forms[0].clinician_id.add(opt); */

	parent.AssignRelationshipFrame.document.AssignRelationshipForm.clinician_name.value = '';
	parent.AssignRelationshipFrame.document.AssignRelationshipForm.clinician_name_button.disabled = false;

	var check2 = parent.AssignRelationshipFrame.document.getElementById("relationship").length;
	for(var i=0;i<check2;i++){
		parent.AssignRelationshipFrame.document.AssignRelationshipForm.relationship.options.remove("relationship");
	}

	var opt=parent.AssignRelationshipFrame.document.createElement('OPTION'); 
	opt.text	=	"-----"+getLabel("Common.defaultSelect.label",'COMMON')+"----";
	opt.value	=	'';
	parent.AssignRelationshipFrame.document.forms[0].relationship.add(opt); 
	top.content.messageFrame.location.href = '../../eCommon/jsp/error.jsp';
}


function displayDetails(practitioner_type,practitioner_id,relationship_id,begin_date,end_date,added_date,phy_prov_name,relationship_name,expiry_based,expiry_rule,terminateRelnCheck,reason_type){
	
	if(terminateRelnCheck=='Y')
	
	{
		//alert('terminateRelnCheck'+terminateRelnCheck);
		parent.AssignRelationshipFrame.document.getElementById("chkTerminate").disabled=false;
		parent.AssignRelationshipFrame.document.getElementById("record").disabled=true;//0605.6

		
	}
	else
		
	{
		parent.AssignRelationshipFrame.document.getElementById("chkTerminate").checked = false;
		parent.AssignRelationshipFrame.document.getElementById("chkTerminate").disabled=true;
		parent.AssignRelationshipFrame.document.getElementById("record").disabled=true;//0605.6
	}

	
	parent.AssignRelationshipFrame.document.getElementById("tdTerminate").style.display = '';
	parent.AssignRelationshipFrame.document.getElementById("tempRelation").style.display = 'none';
	parent.AssignRelationshipFrame.document.getElementById("tempCheckList").style.display = 'none';	
	parent.AssignRelationshipFrame.document.getElementById("hyperLinkStartDate").value = begin_date;
	parent.AssignRelationshipFrame.document.getElementById("hyperLinkEndDate").value = end_date;

	parent.AssignRelationshipFrame.document.getElementById("start_date").value = begin_date;
	parent.AssignRelationshipFrame.document.getElementById("end_date").value = end_date;

	parent.AssignRelationshipFrame.document.getElementById("added_date").value = added_date;

	var check = parent.AssignRelationshipFrame.document.getElementById("clinician_type").length;
	//var check1 = parent.AssignRelationshipFrame.document.getElementById("clinician_id").length;
	var check2 = parent.AssignRelationshipFrame.document.getElementById("relationship").length;
	//start-0605.6
	var check3 = parent.AssignRelationshipFrame.document.getElementById("reason").length;

	var tempVal= "";
	var resVal="";
	
	for(var i=0;i<check3;i++)
	{
		resVal = parent.AssignRelationshipFrame.document.getElementById("reason").options[i].value;
		if(reason_type == resVal)
		{
			parent.AssignRelationshipFrame.document.getElementById("reason").value = reason_type;
			parent.AssignRelationshipFrame.document.getElementById("reason").disabled = true;
			parent.AssignRelationshipFrame.document.getElementById("reasonText").value = reason_type;
			break;
		}
	}
	//End-0605.6

	for(var i=0;i<check;i++)
	{
		tempVal = parent.AssignRelationshipFrame.document.getElementById("clinician_type").options[i].value;
		if(practitioner_type == tempVal)
		{
			parent.AssignRelationshipFrame.document.getElementById("clinician_type").value = practitioner_type;
			parent.AssignRelationshipFrame.document.getElementById("clinician_type").disabled = true;			
			break;
		}
	}
	
/*	for(var i=0;i<check1;i++){
		parent.AssignRelationshipFrame.document.AssignRelationshipForm.clinician_id.options.remove("clinician_id");
	}
	
	var opt=parent.AssignRelationshipFrame.document.createElement('OPTION'); 
	opt.text	=	phy_prov_name;
	opt.value	=	practitioner_id;
	parent.AssignRelationshipFrame.document.forms[0].clinician_id.add(opt); */
	parent.AssignRelationshipFrame.document.forms[0].clinician_name.value = phy_prov_name;
	
	parent.AssignRelationshipFrame.document.forms[0].phys_prov_id.value = practitioner_id;
	parent.AssignRelationshipFrame.document.forms[0].phys_prov_reln_id.value = relationship_id
	parent.AssignRelationshipFrame.document.getElementById("clinician_name").disabled = true; 
	parent.AssignRelationshipFrame.document.getElementById("clinician_name_button").disabled = true;
	parent.AssignRelationshipFrame.document.getElementById("chkTerminate").checked = false;

	for(var i=0;i<check2;i++){
		parent.AssignRelationshipFrame.document.AssignRelationshipForm.relationship.options.remove("relationship");
	}
	var opt1=parent.AssignRelationshipFrame.document.createElement('OPTION'); 
	
	opt1.text	=	relationship_name;
	opt1.value	=	escape(relationship_id);
	parent.AssignRelationshipFrame.document.forms[0].relationship.add(opt1); 
	parent.AssignRelationshipFrame.document.getElementById("relationship").disabled = true;
	if(expiry_based == "Y"){
		parent.AssignRelationshipFrame.document.getElementById("expiry_based_yn").checked = true;
	}
	parent.AssignRelationshipFrame.document.getElementById("expiry_rule").value = expiry_rule;
//	parent.AssignRelationshipFrame.location.href="../../eCA/jsp/AssignRelationshipMain?added_id="+added_id;
}


function makeInvisible(){
	document.getElementById("tdTerminate").style.display = 'none';
	document.getElementById("tempRelation").style='display';
	//document.getElementById("tempCheckList").style.display = 'inline';	
	if(document.AssignRelationshipForm.modal_yn.value == "Y"){
		document.getElementById("tempCheckList").style.display = 'none';	
	}else{
		document.getElementById("tempCheckList").style='display';	
	}
}

function funTerminateReln(){
	if(parent.AssignRelationshipFrame.document.getElementById("chkTerminate").checked == true){
		parent.AssignRelationshipFrame.document.getElementById("tempEndDate").value = parent.AssignRelationshipFrame.document.getElementById("end_date").value;
		parent.AssignRelationshipFrame.document.getElementById("end_date").value = parent.AssignRelationshipViewFrame.document.getElementById("currentDateTime").value;
		parent.AssignRelationshipFrame.document.getElementById("record").disabled=false;
	}else{
		parent.AssignRelationshipFrame.document.getElementById("end_date").value = parent.AssignRelationshipFrame.document.getElementById("tempEndDate").value;
		parent.AssignRelationshipFrame.document.getElementById("tempEndDate").value = '';
		parent.AssignRelationshipFrame.document.getElementById("record").disabled=true;
	}
	return true;
}

function funLimitPractList(){
	checkOnBlurClinicianType(parent.AssignRelationshipFrame.document.getElementById("clinician_type"));
}

/*function checkFieldsLocalModal( fields, names, messageFrame) {
    var errors = "" ;
    for( var i=0; i<fields.length; i++ ) {
        if(trimCheck(fields[i].value)) {
            fields[i].value = trimString(fields[i].value);
        }
        else    errors = errors + names[i] + getMessage("CAN_NOT_BE_BLANK","common") + "<br>" ;
    }
    if ( errors.length != 0 ) {
        parent.messageFrame.location.href="../../eCA/jsp/CAError.jsp?err_num="+errors+"&error_value=0" ;
        return false ;
    }
    return true ;
}*/
//0605.5--Start

function setReasonText(reason_Desc){ 
	document.forms[0].reasonText.value=reason_Desc.value
	document.forms[0].reason_text.value=reason_Desc.value
}

//0605.5--End

//Functions for the file name AssignRelationshipView.jsp-start

function scrollTitle(){
  var y = parent.AssignRelationshipViewFrame.document.body.scrollTop;

  if(y == 0){
	parent.AssignRelationshipViewFrame.document.getElementById("divDataTitle").style.position = 'static';
	parent.AssignRelationshipViewFrame.document.getElementById("divDataTitle").style.posTop  = 0;
  }else{
	parent.AssignRelationshipViewFrame.document.getElementById("divDataTitle").style.position = 'relative';
	parent.AssignRelationshipViewFrame.document.getElementById("divDataTitle").style.posTop  = y-2;
  }

}
function alignWidth(){
	var totalRows =  parent.AssignRelationshipViewFrame.document.getElementById("dataTable").rows.length;
	var counter = totalRows-1;
	var temp = parent.AssignRelationshipViewFrame.document.getElementById("dataTitleTable").rows[0].cells.length;
	for(var i=0;i<temp;i++) {
		parent.AssignRelationshipViewFrame.document.getElementById("dataTitleTable").rows[0].cells[i].width=parent.AssignRelationshipViewFrame.document.getElementById("dataTable").rows[counter].cells[i].offsetWidth;
		
	}
}

//Functions for the file name AssignRelationshipView.jsp-end

function makeenable()
{
if(parent.AssignRelationshipFrame.document.getElementById("chkTerminate").disabled==false)
	{
//		alert('in if');
	}
//parent.AssignRelationshipFrame.document.getElementById("record").disabled==true
}
async function get_name(Object)
{
	if(Object.name=='clinician_name')
		{
			var target  = document.forms[0].clinician_name;
		
			if((target.value) == "null" || (target.value ==""))
			{
				return false;			
			}
			else
			{
				await get_clinician_name();
			}
		}
		else if(Object.name=='clinician_name_button')
		{		
			await get_clinician_name();
		}
		
}

async function get_clinician_name()
{
	var retVal = 	""; 
	var dialogHeight= "28" ;
	var dialogWidth	= "43" ;
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll:no; status:" + status;
	var tit = getLabel("Common.PractitionerDetails.label","COMMON");

	var target = document.forms[0].clinician_name;
	var tempValue=target.value;
	var locale = document.AssignRelationshipForm.locale.value;
	var facility_id = document.AssignRelationshipForm.facility_id.value;
	var clinician_type = document.AssignRelationshipForm.clinician_type.value;
	var clinician_id = document.AssignRelationshipForm.clinician_id.value;
	var patient_id = document.AssignRelationshipForm.patient_id.value;
	var episode_id = document.AssignRelationshipForm.episode_id.value;
	var episode_type = document.AssignRelationshipForm.episode_type.value;
	var location_code =	document.AssignRelationshipForm.location_code.value;
	
	var sql = "";
	resetRelationshipDetails();
	parent.AssignRelationshipFrame.document.AssignRelationshipForm.clinician_name.value='';

	if(clinician_type!='')
	{

		var optlength1 = parent.AssignRelationshipFrame.document.AssignRelationshipForm.relationship.options.length;

		for (var i=0; i<optlength1; i++)
		{
			parent.AssignRelationshipFrame.document.AssignRelationshipForm.relationship.options.remove("relationship");
		}

		var opt=parent.AssignRelationshipFrame.document.createElement('OPTION'); 
		opt.text	=	"-----"+getLabel("Common.defaultSelect.label",'COMMON')+"----";
		opt.value	=	'';
		parent.AssignRelationshipFrame.document.forms[0].relationship.add(opt); 

		var limitPractList = "";

		if(parent.AssignRelationshipFrame.document.AssignRelationshipForm.chkLimitPractList.checked)
			limitPractList="Y";
		else
			limitPractList="N";		

		if(limitPractList == "Y")
		{
			sql="select G.practitioner_id code,replace(b.practitioner_name,'''','') description from am_pract_for_facility G, AM_PRACTITIONER_LANG_VW B  where G.FACILITY_ID   = '" +facility_id+ "' and b.pract_type = '" +clinician_type+ "' and G.practitioner_id != '"+clinician_id +"' and G.PRACTITIONER_ID=b.PRACTITIONER_ID  and b.language_id =  '" +locale+ "' and G.PRACTITIONER_ID not in ( select PRACTITIONER_ID from  ca_encntr_pract_reln where PATIENT_ID ='" +patient_id+ "' and   sysdate between begin_date_time and nvl(end_date_time,sysdate)  and ENCOUNTER_ID = '" +episode_id+ "' and facility_id='" +facility_id+ "' ) ";

			sql	=	sql	+ " AND EXISTS(SELECT 1 FROM CA_PRACT_BY_LOCN A WHERE A.PRACTITIONER_ID=G.practitioner_id AND A.FACILITY_ID=FACILITY_ID ";

			if(episode_type == "O")
			{
				sql	=	sql+ " AND (   (A.LOCN_TYPE='C' AND A.LOCN_CODE='"+location_code+"') OR 	(A.LOCN_TYPE='X') OR (A.LOCN_TYPE='Z') OR (A.LOCN_TYPE='P' AND EXISTS (SELECT 1 FROM op_pract_for_clinic I WHERE I.FACILITY_ID=A.FACILITY_ID AND 					I.PRACTITIONER_ID=A.PRACTITIONER_ID AND I.CLINIC_CODE='"+location_code+"' ))) ";		
			}
			else if(episode_type == "I")
			{
				sql	=	sql+ " AND (  (A.LOCN_TYPE='W' AND A.LOCN_CODE='"+location_code+"') OR (A.LOCN_TYPE='Y') OR (A.LOCN_TYPE='Z') OR (A.LOCN_TYPE='P' AND EXISTS (SELECT 1 FROM IP_NURSING_UNIT_FOR_PRACT  I WHERE I.FACILITY_ID=A.FACILITY_ID AND I.PRACTITIONER_ID=A.PRACTITIONER_ID AND I.NURSING_UNIT_CODE='"+location_code+"'))) ";
			}

			sql	=	sql + ") and B.PRACTITIONER_ID like upper(?) and upper(B.PRACTITIONER_NAME) like upper(?) ORDER BY B.PRACTITIONER_NAME";
		}
		else
		{
			sql = " Select a.practitioner_id code,B.PRACTITIONER_NAME description from  am_pract_for_facility a,AM_PRACTITIONER_LANG_VW B where a.FACILITY_ID   = '" +facility_id+ "'  and B.pract_type = '" +clinician_type+ "' AND A.PRACTITIONER_ID = B.PRACTITIONER_ID AND B.LANGUAGE_ID = '" +locale+ "' and a.EFF_STATUS='E'  and A.PRACTITIONER_ID not in ( select PRACTITIONER_ID from  ca_encntr_pract_reln where PATIENT_ID = '" +patient_id+ "' and   sysdate between begin_date_time and nvl(end_date_time,sysdate)  and ENCOUNTER_ID = '" +episode_id+ "' and facility_id= '" +facility_id+ "' ) and B.PRACTITIONER_ID like upper(?) and upper(B.PRACTITIONER_NAME) like upper(?) order by B.PRACTITIONER_NAME";
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
		argArray[5] = tempValue;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retVal = await CommonLookup( tit, argArray );
		
		var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		var arr=new Array();
		
		if (retVal != null && retVal != "")
		{
			var retVal=unescape(retVal);
			arr=retVal.split(",");

			document.forms[0].clinician_id.value = arr[0];
			document.forms[0].clinician_name.value = arr[1];
			checkOnBlurClinicianName(document.forms[0].clinician_name);
		}
		else
		{
			document.forms[0].clinician_id.value = '';
			document.forms[0].clinician_name.value ='';

		}
	}
}

