function reset(){
	FutOrdInsApprTrackMainFrame.location.reload();
}

function reloadPage(){
	parent.FutOrdInsApprTrackMainFrame.location.reload();
	parent.FutOrdInsApprTrackResultFrame.location.href="../../eCommon/html/blank.html";
	parent.FutOrdInsApprTrackBtnFrame.location.href="../../eCommon/html/blank.html";
}


function primaryPatValidation(obj)
{
	var patient_id=obj.value;	
	if(patient_id!=""){
		var function_id = "PAT_CHK";
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "patient_id=\"" + patient_id + "\" " ;					
		xmlStr +=" /></root>";
		var temp_jsp="PkgSubscriptionValidation.jsp?func_mode=CHK_PAT_ID&function_id="+function_id;					
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml"); 
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		var responseText=trimString(xmlHttp.responseText);		
		if(responseText=="N")
		{
			alert(getMessage("INVALID_PATIENT","MP"));
			obj.select();
		}else if(responseText=="Y"){
			LoadPatientName(patient_id);
		}
	}
}


function clearCode(obj){
	obj.value='';
}


function checkAlpha(event) {
    var strCheck = '1234567890';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);
    if (strCheck.indexOf(key) == -1)
        return false;
    return true;
}

function checkForNumber(obj) {
    if (trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
		if(obj.value == 0){
			alert(getMessage("CANNOT_BE_ZERO", "common"));
			obj.value = "";
			obj.focus();
			return false;
		}
        return true;
    } else {
        if (obj.value.length > 0) {
            alert(getMessage("NUM_ALLOWED", "SM"));
            obj.value = '';
            return false;
        }
    }
}


async function callDemographic(eve)
{
		//alert("In patient ID "+eve.parentElement.children[1].value);
        var patient_id         =    trimString(eve.parentElement.children[1].value) ;
        var retVal             =     new String();
        var dialogHeight     = "92vh" ;
        var dialogWidth      = "93vw" ;
        var dialogTop        = "0px";
        var status             = "no";
        var features        = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
        retVal = await top.window.showModalDialog("../../eCA/jsp/DemographicsView.jsp?patient_id="+patient_id,arguments,features);

}

async function placeFutureOrder(eve)
{
        //alert("In encounter ID "+eve.parentNode.parentNode.children[2].children[0].innerHTML);
	var patient_id         =    trimString(eve.parentNode.parentNode.children[1].children[1].value) ;
	var patientClass    =          trimString(eve.parentNode.parentNode.children[3].children[0].innerHTML);
	var facilityId             =             trimString(eve.parentNode.parentNode.children[0].children[0].innerHTML);
	var encounterId            =       trimString(eve.parentNode.parentNode.children[2].children[0].innerHTML);
	var retVal             =     new String();
	var dialogHeight     = "92vh" ;
	var dialogWidth      = "93vw" ;
	var dialogTop        = "100";
	var status             = "no";
	var features        = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
	retVal = await top.window.showModalDialog("../../eOR/jsp/OpenFunctionWrapper.jsp?patient_class="+patientClass+"&FacilityId="+facilityId+"&patient_id="+patient_id+"&encounter_id="+encounterId+"&invoke_function_id=ORDER_ENTRY&cnsnt_with_order_yn=Y",arguments,features);
	parent.FutOrdInsApprTrackQryCriteriaFrame.document.get
	parent.frames[0].document.getElementById('search_btn').click();
}

function saveUserData(ev){
    parent.FutOrdInsApprTrackResultFrame.document.getElementById('p_action_id').value = ev;
	if (parent.FutOrdInsApprTrackResultFrame != undefined) {
         var mode = "insert";
         if(mode == "insert" || mode == "modify"){                                                                                     
               var frmObj = parent.FutOrdInsApprTrackResultFrame.document.forms[0];             
               var index = frmObj.rowCount.value;
               var parentDoc = frmObj.document;
               xmlString = formXMLStringMain(frmObj);
			   
               updation = formValidation(xmlString);

               if(updation == true)
               {
                 //  var mode = frmObj.mode.value;  //yet to fix
				   frmObj.target = 'messageFrame';
                   frmObj.method = "post";
                   frmObj.action = "../../servlet/eBL.BLFutOrdInsApprTrackServlet?mode=" + mode;
                   frmObj.submit();  
               }                                                                                                           
         }
	}
}

function formXMLStringMain(frmObj) {
    if (frmObj != null && frmObj != "undefined" && frmObj.length > 0) {
        var xmlStr = "<root><SEARCH ";
	if (true) {
		var arrObj = frmObj.elements;
		for (var i = 0; i < arrObj.length; i++) {
			var val = "";
			if (arrObj[i].type == "checkbox") {
				if (arrObj[i].checked) {
					val = arrObj[i].value;
					if (arrObj[i].name != null && arrObj[i].name != "")
						xmlStr += arrObj[i].name + "=\"Y" + "\" ";
				} else {
					if (arrObj[i].name != null && arrObj[i].name != "")
						xmlStr += arrObj[i].name + "=\"" + "N" + "\" ";
				}
			} else if (arrObj[i].type == "radio") {
				if (arrObj[i].checked) {
					val = arrObj[i].value;
					if (arrObj[i].name != null && arrObj[i].name != "")
						xmlStr += arrObj[i].name + "=\"" + checkSpl(val) +
						"\" ";
				}
			} else if (arrObj[i].type == "select-multiple") {
				for (var j = 0; j < arrObj[i].options.length; j++) {
					if (arrObj[i].options[j].selected)
						val += arrObj[i].options[j].value + "~"
				}
				val = val.substring(0, val.lastIndexOf('~'))
				if (arrObj[i].name != null && arrObj[i].name != "")
					xmlStr += arrObj[i].name + "=\"" + checkSpl(val) +
					"\" ";
			} else {
				val = arrObj[i].value;
				if (arrObj[i].name != null && arrObj[i].name != "")
					xmlStr += arrObj[i].name + "=\"" + checkSpl(val) +
					"\" ";
			}
		}
        }
        xmlStr += " /></root>";
    }
	
	return xmlStr;
}





function formValidation(xmlStr, event) {
	var temp_jsp = "../../eBL/jsp/BLFutOrdInsApprTrackPersistence.jsp?called_frm=onApply";

    if (event != null && event == "delete")
        temp_jsp = "../../eBL/jsp/BLFutOrdInsApprTrackPersistence.jsp?event=" + event;

    var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

    xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send(xmlDoc);
    var responseText = xmlHttp.responseText;

  	eval(responseText); 
    return true;   
}

function prevActionCall(ev){
	//var prevActionID = document.forms[0].prevActionID.value;
	var prevActionID = ev;
	if(prevActionID == "B") {
		prevActionID = "E";
		generateExcel(prevActionID);
	}
}

function displayServiceData(eve)
{
	parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	parent.frames[2].location.href='../../eCommon/html/blank.html';

	
	var patient_id         =       trimString(eve.parentNode.parentNode.children[1].children[1].value) ;
	var encounter_id       =       trimString(eve.parentNode.parentNode.children[2].children[0].innerHTML);
	var episode_type       =       trimString(eve.parentNode.parentNode.children[3].children[1].value);
	var payer_code         =       trimString(eve.parentNode.parentNode.children[4].children[1].value);
	var payer_grp_code     =       trimString(eve.parentNode.parentNode.children[4].children[2].value);
	var billingGrpCode	   =	   trimString(eve.parentNode.parentNode.children[4].children[3].value);
	var policy_no  		   =       trimString(eve.parentNode.parentNode.children[5].children[0].innerHTML);
	var policy_type_code  			=       trimString(eve.parentNode.parentNode.children[5].children[1].value);
	var spec_nursing_unit_code            =       trimString(eve.parentNode.parentNode.children[8].children[1].value);
	var frmObj = parent.FutOrdInsApprTrackEncounterFrame.document.forms[0];  
	var encounter_from = frmObj.p_enc_frm_date.value;	
	var encounter_to = frmObj.p_enc_to_date.value;	
	var insurance_Status = frmObj.p_ins_status.value;	
	var order_status = frmObj.p_order_line_status.value;	
	var serviceGroupCode = frmObj.p_serv_grp_code.value;	
	var serviceClassificationCode = frmObj.p_serv_class_code.value;	
	var coding_status = frmObj.p_coding_status.value;	
	var locale = frmObj.locale.value;		
	var facility_id = frmObj.facility_id.value;	
	var prevActionID = frmObj.prevActionID.value;
	if(prevActionID == "B") frmObj.prevActionID.value = "";
	//alert("Calling Result Service frame ------------");
	
	parent.frames[2].location.href="../../eBL/jsp/BLFutOrdInsApprTrackResultFrame.jsp?patient_id="+patient_id+"&episode_type="+episode_type+"&encounter_id="+encounter_id+"&enc_frm_date="+encounter_from+"&enc_to_date="+encounter_to+"&spec_nursing_unit_code="+spec_nursing_unit_code+"&insurance_Status="+insurance_Status+"&payer_grp_code="+payer_grp_code+"&payer_code="+payer_code+"&policy_type_code="+policy_type_code+"&order_status="+order_status+"&serviceGroupCode="+serviceGroupCode+"&serviceClassificationCode="+serviceClassificationCode+"&coding_status="+coding_status+"&billingGrpCode="+billingGrpCode+"&locale="+locale+"&facility_id="+facility_id+"&prevActionID="+prevActionID+"&policy_no="+policy_no;
}

function displayQeuryButtons(){
    var frmObj = parent.FutOrdInsApprTrackResultFrame.document.forms[0];   
	var patient_id         =    frmObj.p_patient_id.value;	
	var encounter_id       =       frmObj.p_encounter_id.value;	
	var episode_type       =       frmObj.p_episode_type.value;	
	var payer_code         =       frmObj.p_payer_code.value;	
	var payer_grp_code     =       frmObj.p_payer_grp_code.value;	
	var billingGrpCode	   =  	frmObj.p_blng_grp_id.value;	
	var policy_type_code   =       frmObj.p_policy_type_code.value;	
	var spec_nursing_unit_code            =      frmObj.p_speciality_code.value;	
	var encounter_from = frmObj.p_enc_frm_date.value;	
	var encounter_to = frmObj.p_enc_to_date.value;	
	var insurance_Status = frmObj.p_ins_status.value;	
	var order_status = frmObj.p_order_line_status.value;	
	var serviceGroupCode = frmObj.p_serv_grp_code.value;	
	var serviceClassificationCode = frmObj.p_serv_class_code.value;	
	var coding_status = frmObj.p_coding_status.value;	
	var locale = frmObj.locale.value;		
	var facility_id = frmObj.facility_id.value;	
	var prevActionID = frmObj.prevActionID.value;
	//if(prevActionID == "B") frmObj.prevActionID.value = "";
	parent.frames[3].location.href = "../../eBL/jsp/BLFutOrdInsApprTrackResultQueryBtn.jsp?patient_id="+patient_id+"&episode_type="+episode_type+"&encounter_id="+encounter_id+"&enc_frm_date="+encounter_from+"&enc_to_date="+encounter_to+"&spec_nursing_unit_code="+spec_nursing_unit_code+"&insurance_Status="+insurance_Status+"&payer_grp_code="+payer_grp_code+"&payer_code="+payer_code+"&policy_type_code="+policy_type_code+"&order_status="+order_status+"&serviceGroupCode="+serviceGroupCode+"&serviceClassificationCode="+serviceClassificationCode+"&coding_status="+coding_status+"&billingGrpCode="+billingGrpCode+"&locale="+locale+"&facility_id="+facility_id;

}

function changeFieldColor(obj){
	var prevClicked = document.forms[0].prevClicked.value;
	if(prevClicked>0){
		var rowbgColorYN = trimString(document.getElementById('rowbgColorYN_'+prevClicked).value);		
		if (rowbgColorYN=='Y') {
			document.getElementById('srl_no_'+prevClicked).parentNode.className =  "field";
			document.getElementById('patient_name_'+prevClicked).parentNode.className =  "field";
			document.getElementById('encounter_id_'+prevClicked).parentNode.className =  "field";
			document.getElementById('patient_class_'+prevClicked).parentNode.className =  "field";
			document.getElementById('payer_'+prevClicked).parentNode.className =  "field";
			document.getElementById('policy_'+prevClicked).parentNode.className =  "field";
			document.getElementById('visit_adm_date_'+prevClicked).parentNode.className =  "field";
			document.getElementById('physician_name_'+prevClicked).parentNode.className =  "field";
			document.getElementById('speciality_'+prevClicked).parentNode.className =  "field";
			document.getElementById('rowbgColorYN_'+prevClicked).value = '';
			
		}
	}
	document.getElementById('srl_no_'+obj).parentNode.className =  "YELLOW";
	document.getElementById('patient_name_'+obj).parentNode.className =  "YELLOW";
	document.getElementById('encounter_id_'+obj).parentNode.className =  "YELLOW";
	document.getElementById('patient_class_'+obj).parentNode.className =  "YELLOW";
	document.getElementById('payer_'+obj).parentNode.className =  "YELLOW";
	document.getElementById('policy_'+obj).parentNode.className =  "YELLOW";
	document.getElementById('visit_adm_date_'+obj).parentNode.className =  "YELLOW";
	document.getElementById('physician_name_'+obj).parentNode.className =  "YELLOW";
	document.getElementById('speciality_'+obj).parentNode.className =  "YELLOW";
	document.getElementById('rowbgColorYN_'+obj).value = 'Y';
	document.forms[0].prevClicked.value = obj;
}
function reloadResultFrame(encounterId){
	
	//var table = parent.frames[1].BLFutOrdInsApprTrackEncTable;
	var table = document.getElementById('BLFutOrdInsApprTrackEncTable');
	for (var i = 0, row; row = table.rows[i]; i++) {		//iterate through rows
		var encId = row.cells[2].children[0].innerHTML;
		if(encId == encounterId){
			row.cells[2].focus();
			row.cells[2].children[1].click();
		}
	}
	
}
