//This file is saved on 25/10/2005.
var function_id	= "PH_DRUG_INFO_ENQ" ;
var result		= false ;
var message		= "" ;
var flag		= "" ;
var maxRec = 0  ;
var displaySize = 0 ;
var currClass="";
var error_str="";// Added to avoid script error on QueryMode Apply event

function create() {
	f_query_add_mod.location.href="../../ePH/jsp/PhDrugInfoFrames.jsp?function_id="+function_id+"&mode=MODE_INSERT";
}

function query() {
	f_query_add_mod.location.href="../../ePH/jsp/PhDrugInfoFrames.jsp?function_id="+function_id+"&mode=MODE_MODIFY";
}

function reset() {
	if(f_query_add_mod.f_query_criteria1!=null){
		f_query_add_mod.location.href="../../ePH/jsp/PhDrugInfoFrames.jsp?function_id="+function_id+"&mode=MODE_MODIFY";
	}
	else if(f_query_add_mod.f_query_criteria!=null){
		if(f_query_add_mod.f_enquiry.document.forms[0].Enquiry_Num.value!=""){
			f_query_add_mod.f_enquiry.document.forms[0].reset();
			f_query_add_mod.f_request.f_request1.document.forms[0].reset();
			f_query_add_mod.f_request.f_request2.document.forms[0].reset();
			f_query_add_mod.f_patient.document.forms[0].reset();
			f_query_add_mod.f_response.f_response1.document.forms[0].reset();
			f_query_add_mod.f_response.f_response2.document.forms[0].reset();
			f_query_add_mod.f_response.f_response3.document.forms[0].reset();
			f_query_add_mod.f_response.f_response3.document.getElementById("resp_tt").innerText='';
			if(f_query_add_mod.f_enquiry.document.forms[0].Logged_in_fc.value==f_query_add_mod.f_enquiry.document.forms[0].src.value){
				f_query_add_mod.f_enquiry.document.forms[0].Source.selectedIndex=0
				f_query_add_mod.f_enquiry.document.getElementById("id5").style.display='none';
				f_query_add_mod.f_enquiry.document.forms[0].other_pract.value='';
			}
			else if(f_query_add_mod.f_enquiry.document.forms[0].src.value=='*P'){
				f_query_add_mod.f_enquiry.document.forms[0].Source.selectedIndex=3
				if(f_query_add_mod.f_enquiry.document.forms[0].request_mode.value!='S') //if condition  Added for HSA-CRF-0158 [IN:048491] -start
					f_query_add_mod.f_enquiry.document.forms[0].Pract_name.value='';
				f_query_add_mod.f_enquiry.document.getElementById("pn").style.display='inline';
				f_query_add_mod.f_enquiry.document.getElementById("id5").style.display='inline';
				f_query_add_mod.f_enquiry.document.getElementById("fc").style.display='none';
				f_query_add_mod.f_enquiry.document.getElementById("id4").style.display='none';
				f_query_add_mod.f_enquiry.document.getElementById("ff").style.display='none';
				f_query_add_mod.f_enquiry.document.getElementById("id1").style.display='none';
				f_query_add_mod.f_enquiry.document.forms[0].Pract_name_btn.disabled=true;
				f_query_add_mod.f_enquiry.document.forms[0].Designation.disabled=false;
			}
			else if(f_query_add_mod.f_enquiry.document.forms[0].src.value=='*F'){
				f_query_add_mod.f_enquiry.document.forms[0].Source.selectedIndex=1; //changed from 2 - 1
				if(f_query_add_mod.f_enquiry.document.forms[0].request_mode.value!='S') //if condition  Added for HSA-CRF-0158 [IN:048491] -start
					f_query_add_mod.f_enquiry.document.forms[0].Pract_name.value='';
				f_query_add_mod.f_enquiry.document.getElementById("id5").style.display='inline';
				f_query_add_mod.f_enquiry.document.getElementById("id1").style.display='none';
				f_query_add_mod.f_enquiry.document.getElementById("facility_name").disabled=false;
				f_query_add_mod.f_enquiry.document.getElementById("facility_name").disabled=false;
				f_query_add_mod.f_enquiry.document.forms[0].Pract_name_btn.disabled=true;
				f_query_add_mod.f_enquiry.document.forms[0].Designation.disabled=false;
				f_query_add_mod.f_enquiry.document.getElementById("fc").style.display='none';
				f_query_add_mod.f_enquiry.document.getElementById("id4").style.display='inline';
			}
			else{
				f_query_add_mod.f_enquiry.document.forms[0].Source.selectedIndex=2; //changed from 2 - 1
				f_query_add_mod.f_enquiry.document.forms[0].other_source.value=f_query_add_mod.f_enquiry.document.forms[0].src.value; //changed from 2 - 1
				f_query_add_mod.f_enquiry.document.getElementById("id4").style.display='none';
				f_query_add_mod.f_enquiry.document.getElementById("id5").style.display='none';
				f_query_add_mod.f_enquiry.document.getElementById("fc").style.display='inline';
			}
			if(f_query_add_mod.f_enquiry.document.forms[0].request_mode.value=='S'){ //if condition  block Added for HSA-CRF-0158 [IN:048491] -start
				f_query_add_mod.f_enquiry.document.getElementById("pn").style.display='none';
				f_query_add_mod.f_enquiry.document.getElementById("id3").style.display='none';
				f_query_add_mod.f_enquiry.document.getElementById("id5").style.display='none';
				f_query_add_mod.f_enquiry.document.getElementById("id7").style.display='none';
			}
		}
		else{
			f_query_add_mod.location.href="../../ePH/jsp/PhDrugInfoFrames.jsp?function_id="+function_id+"&mode=MODE_INSERT";
		}
	}
	f_drug_quick_info.PhDrugQuickInfoForm.quick_links.selectedIndex=0;//Added for  Bru-HIMS-CRF-078 [IN:029944] 
}

/* This apply function is called from the top frame button */
function apply() {	
	var flag='true';
	var flag1='true';
	var no_of_record=0;
	flag=chkMandatary('Enc_dtl','apply');
	var chk_flag='false';
	var i=0;
	if(flag=='true'){
		var Verified_by=f_query_add_mod.f_enquiry.document.PhDrugInfoEnqForm.Verified_by.value;
		if(Verified_by==''){ 
			flag='true';
		}
		else{
			flag='false';
		}

		if(flag=='true'){
			no_of_record=f_query_add_mod.f_request.f_request2.document.PhDrugInfoReqCatgDtlsForm.no_of_records.value;
			if(no_of_record!=0){
				for(i=1;i<=no_of_record;i++){
					if(eval("f_query_add_mod.f_request.f_request2.document.PhDrugInfoReqCatgDtlsForm.chk"+i).checked){
						chk_flag='true';
						break;
					}
				}
				frames[3].location.href="../../eCommon/jsp/error.jsp";//Changed frames 2 to 3 for Bru-HIMS-CRF-078 [IN:029944]
			}
			 
			if(chk_flag=='false'){
				frames[3].location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("ATLEAST_ONE_REQ_CATEGORY","PH");//Changed frames 2 to 3 for Bru-HIMS-CRF-078 [IN:029944]
				return;
			}
			else{
				var chk=ChkMaxLen('Request Detail',f_query_add_mod.f_request.f_request1.document.PhDrugInfoReqForm.Request_dtl,1000,'mode');
			
				if(chk){
					chk=ChkMaxLen('Food Detail',f_query_add_mod.f_patient.document.PhDrugInfoPatForm.food,1000,'mode');
				}
				if(chk){
					chk=ChkMaxLen('Drug Detail',f_query_add_mod.f_patient.document.PhDrugInfoPatForm.Drug,1000,'mode');
				}
				if(chk){
					chk=ChkMaxLen('Other Allergy Detail',f_query_add_mod.f_patient.document.PhDrugInfoPatForm.other_desc,1000,'mode');
				}
				if(chk){
					chk=ChkMaxLen('Response Detail',f_query_add_mod.f_response.f_response1.document.PhDrugInfoResForm.Response_dtl,1000,'mode');
				}
				if(chk){
					chk=ChkMaxLen('Response Remarks',f_query_add_mod.f_response.f_response3.document.PhDrugInfoResInfoDtls1Form.remark,1000,'mode');
				}
		
				if(chk){
					var enq_dtl_form	= f_query_add_mod.f_enquiry.document.PhDrugInfoEnqForm;
					var req_dtl_form1	= f_query_add_mod.f_request.f_request1.document.PhDrugInfoReqForm;
					var req_dtl_form2	= f_query_add_mod.f_request.f_request2.document.PhDrugInfoReqCatgDtlsForm;
					var pat_dtl_form	= f_query_add_mod.f_patient.document.PhDrugInfoPatForm;
					var res_dtl_form1= f_query_add_mod.f_response.f_response1.document.PhDrugInfoResForm;
					var res_dtl_form2= f_query_add_mod.f_response.f_response2.document.PhDrugInfoResInfoDtlsForm;
					var res_dtl_form3= f_query_add_mod.f_response.f_response3.document.PhDrugInfoResInfoDtls1Form
					var xmlStr ="<root><SEARCH ";	 
					var xmlStr_1 = buildXMLString(enq_dtl_form); //Enquiry Form 

					var xmlStr_2 = buildXMLString(req_dtl_form1); //Request Form1
					var xmlStr_3 = buildXMLString(req_dtl_form2); //Request Form2 
					var xmlStr_4 = buildXMLString(pat_dtl_form); //Patient Form
					var xmlStr_5 = buildXMLString(res_dtl_form1); //Response Form1 
					var xmlStr_6 = buildXMLString(res_dtl_form2); //Response Form2 
					var xmlStr_7 = buildXMLString(res_dtl_form3); //Response Form3 
					xmlStr		+=	xmlStr_1+xmlStr_2+xmlStr_3+xmlStr_4+xmlStr_5+xmlStr_6+xmlStr_7;	 
					xmlStr +=" /></root>";
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest() ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","PhDrugInfoValidation.jsp?func_mode=InsertMode",false);
					xmlHttp.send(xmlDoc);
					responseText=xmlHttp.responseText ;
					eval(responseText);
					var homePage = f_drug_quick_info.PhDrugQuickInfoForm.homepage.value; //added for  Bru-HIMS-CRF-073.1 [IN:047222]
					if(homePage=='Y'){  //added for  Bru-HIMS-CRF-073.1 [IN:047222]
						parent.menuFrame.document.location.reload();
					}

				}
				else{
					var err1='';
					messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+err1;
				}
			}//chk_flag is true
		}//flag is true
		else{
			errors='';
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+errors;
		}
	}
	else{
		messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+error_str;// Added to avoid script error on QueryMode Apply event
		error_str="";// Added to avoid script error on QueryMode Apply event
	}
}

function chk(){
	var formobj=parent.parent.f_query_add_mod.f_enquiry.document.PhDrugInfoEnqForm
	if(eval('formobj.confidential_yn').checked==true)
		   formobj.Confidential_YN.value="Y";
	else 
	formobj.Confidential_YN.value="N";
}

function buildXMLString(frmObj) {
	var xmlStr = "";
	var arrObj = frmObj.elements;
	var frmObjs = new Array()
	if(frmObj.name == null)
		frmObjs = frmObj;
	else frmObjs[0] = frmObj;

	for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
		frmObj = frmObjs[frmCount]
		var arrObj = frmObj.elements;

		for(var i=0;i<arrObj.length;i++) {
			var val = "";
			if(arrObj[i].type == "checkbox") {
				if(arrObj[i].checked) {
					val = arrObj[i].value;
					//val ='' ;
					
				}
				else {
					val ="";
				}
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" ";
			}
			else if(arrObj[i].type == "radio") {
				if(arrObj[i].checked) {
					val = arrObj[i].value;
					if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" ";
				}
			}
			else if(arrObj[i].type == "select-multiple") {
				for(var j=0; j<arrObj[i].options.length; j++) {
					if(arrObj[i].options[j].selected)
						val+=arrObj[i].options[j].value +"~"
				}
				val= val.substringing(0,val.lastIndexOf('~'))
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" ";
			}
			else {
				val = arrObj[i].value;
				
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" ";
				if(val =="WithinF"){					
					var facility_desc = frmObj.other_source.options[frmObj.other_source.selectedIndex].text;
					xmlStr += " facility_desc=\""+ facility_desc + "\" ";
				}
			}
		}
	}
	return xmlStr;
}

function onSuccess(msgid){
	messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msgid
	f_query_add_mod.location.href="../../ePH/jsp/PhDrugInfoFrames.jsp?mode=MODE_INSERT&function_id="+function_id;
}
function changeButtonColor1(obj,from_name){
	cellref = parent.window[2].window[1].document.getElementById('tab').rows[0].cells;
	for(i=0; i<cellref.length; i++){
		if(cellref[i].id!="dummy")
			cellref[i].className = 'CAFIRSTSELECTHORZ'
	}
	obj.className = "CASECONDSELECTHORZ"
	currClass ="CASECONDSELECTHORZ";
}
function changeButtonColorDrugInfo(obj,from_name){
	cellref =parent.window[0].document.getElementById('tab').rows[0].cells;
	for(i=0; i<cellref.length; i++){
		if(cellref[i].id!="dummy")
			cellref[i].className = 'CAFIRSTSELECTHORZ'
	}
	obj.className = "CASECONDSELECTHORZ";
	currClass ="CASECONDSELECTHORZ";
}
function changeButtonColor(obj,from_name){

	cellref =parent.document.getElementById('tab').rows[0].cells;
	for(i=0; i<cellref.length; i++){
		if(cellref[i].id!="dummy")
			cellref[i].className = 'CAFIRSTSELECTHORZ'
	}
	obj.className = "CASECONDSELECTHORZ";
	currClass ="CASECONDSELECTHORZ";
}

function callOnMouseOver(obj){
	currClass = obj.className ;
	obj.className = 'CASECONDSELECTHORZ';
}

function callOnMouseOut(obj){
	obj.className = currClass;
}

/*function change_tab_buttons(Obj,str){
	var flag='true';
	if(str=="Enc_dtl"){	
		if(parent.f_detail.rows=="0%,0%,100%,0%")
			flag=chkMandatary('Pat_dtl','');
		if(parent.f_detail.rows=="0%,0%,0%,100%")
			flag=chkMandatary('Res_dtl','');
		if(parent.f_detail.rows=="0%,100%,0%,0%")
			flag=chkMandatary('Req_dtl','');
		if(flag=='true'){
			parent.f_detail.rows="100%,0%,0%,0%";
			parent.frames[1].document.forms[0].display1.value="Y";
			parent.frames[2].frames[0].document.forms[0].display2.value="N";
			parent.frames[3].document.forms[0].display3.value="N";
			parent.frames[4].frames[0].document.forms[0].display4.value="N";
			changeButtonColor(Obj,'PH_BUTTONS');
			parent.parent.frames[3].location.href="../../eCommon/jsp/error.jsp";//Changed frames 2 to 3 for Bru-HIMS-CRF-078 [IN:029944]
			//parent.f_enquiry.location.href="../../ePH/jsp/PhDrugInfoEnqDtls.jsp?mode='MODE_INSERT'";
		}
		else{
			//parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=Madantary Fields cannot be Blank"; 
		}
	}
	else if(str=="Req_dtl"){	
		if(parent.f_detail.rows=="100%,0%,0%,0%")
			flag=chkMandatary("Enc_dtl",'');
		if(parent.f_detail.rows=="0%,0%,100%,0%")
			flag=chkMandatary('Pat_dtl','');
		if(parent.f_detail.rows=="0%,0%,0%,100%")
			flag=chkMandatary('Res_dtl','');
		if(flag=='true'){
			parent.f_detail.rows="0%,100%,0%,0%";
			changeButtonColor(Obj,'PH_BUTTONS');
			parent.frames[1].document.forms[0].display1.value="N";
			parent.frames[2].frames[0].document.forms[0].display2.value="Y";
			parent.frames[3].document.forms[0].display3.value="N";
			parent.frames[4].frames[0].document.forms[0].display4.value="N";
			parent.parent.frames[3].location.href="../../eCommon/jsp/error.jsp";//Changed frames 2 to 3 for Bru-HIMS-CRF-078 [IN:029944]
		}
	}
	else if(str=="Pat_dtl" ){
		flag=chkMandatary("Enc_dtl",'');
		if(parent.f_detail.rows=="0%,100%,0%,0%")
			flag=chkMandatary('Req_dtl','');
		if(parent.f_detail.rows=="0%,0%,0%,100%")
			flag=chkMandatary('Res_dtl','');
		if(flag=='true'){
			parent.f_detail.rows="0%,0%,100%,0%";
			changeButtonColor(Obj,'PH_BUTTONS');
			parent.frames[1].document.forms[0].display1.value="N";
			parent.frames[2].frames[0].document.forms[0].display2.value="N";
			parent.frames[3].document.forms[0].display3.value="Y";
			parent.frames[4].frames[0].document.forms[0].display4.value="N";
			parent.parent.frames[3].location.href="../../eCommon/jsp/error.jsp";//Changed frames 2 to 3 for Bru-HIMS-CRF-078 [IN:029944]
		}
	}
	else if(str=="Res_dtl"){
		flag=chkMandatary("Enc_dtl",'');
		if(parent.f_detail.rows=="0%,100%,0%,0%")
			flag=chkMandatary('Req_dtl','');
		if(parent.f_detail.rows=="0%,0%,100%,0%")
			flag=chkMandatary('Pat_dtl','');
		if(flag=='true'){
			parent.f_detail.rows="0%,0%,0%,100%";
			changeButtonColor(Obj,'PH_BUTTONS');
			parent.frames[1].document.forms[0].display1.value="N";
			parent.frames[2].frames[0].document.forms[0].display2.value="N";
			parent.frames[3].document.forms[0].display3.value="N";
			parent.frames[4].frames[0].document.forms[0].display4.value="Y";
			parent.parent.frames[3].location.href="../../eCommon/jsp/error.jsp";//Changed frames 2 to 3 for Bru-HIMS-CRF-078 [IN:029944]
		}
	}
}*/

function change_tab_buttons(Obj, str) {
    var flag = 'true';
    
    // Get references to the iframes
    var fDetail = parent.document.getElementById('f_detail');
    var fEnquiry = parent.document.getElementById('f_enquiry');
    var fRequest = parent.document.getElementById('f_request');
    var fPatient = parent.document.getElementById('f_patient');
    var fResponse = parent.document.getElementById('f_response');

    // Check visibility based on height values
    
    var isEnquiryVisible = fEnquiry.style.height === "84vh";
    var isRequestVisible = fRequest.style.height === "0vh";
    var isPatientVisible = fPatient.style.height === "0vh";
    var isResponseVisible = fResponse.style.height === "0vh";

    if (str === "Enc_dtl") {
        if (isPatientVisible && !isRequestVisible && !isResponseVisible && isEnquiryVisible) {
            flag = chkMandatary('Pat_dtl', '');
        }
        if (!isPatientVisible && !isRequestVisible && isResponseVisible && !isEnquiryVisible) {
            flag = chkMandatary('Res_dtl', '');
        }
        if (isPatientVisible && !isRequestVisible && !isResponseVisible && !isEnquiryVisible) {
            flag = chkMandatary('Req_dtl', '');
        }
        if (flag === 'true') {
            fEnquiry.style.height = "100vh";
            fRequest.style.height = "0vh";
            fPatient.style.height = "0vh";
            fResponse.style.height = "0vh";
            fEnquiry.contentWindow.document.forms[0].display1.value = "Y";
            fRequest.contentWindow.f_request1.document.forms[0].display2.value = "N";
            fPatient.contentWindow.document.forms[0].display3.value = "N";
            fResponse.contentWindow.f_response1.document.forms[0].display4.value = "N";
            changeButtonColorDrugInfo(Obj, 'PH_BUTTONS');
            parent.parent.frames[3].location.href = "../../eCommon/jsp/error.jsp"; // Redirect to error page
        } else {
            // Handle mandatory fields error
            // window.location.href = "../../eCommon/jsp/error.jsp?err_num=Mandatory Fields cannot be Blank"; 
        }
    } else if (str === "Req_dtl") {
        if (fEnquiry.style.height === "100vh") {
            flag = chkMandatary("Enc_dtl", '');
        }
        if (fPatient.style.height === "100vh") {
            flag = chkMandatary('Pat_dtl', '');
        }
        if (fResponse.style.height === "100vh") {
            flag = chkMandatary('Res_dtl', '');
        }
        if (flag === 'true') {
            fEnquiry.style.height = "0vh";
            fRequest.style.height = "100vh";
            fPatient.style.height = "0vh";
            fResponse.style.height = "0vh";
            changeButtonColorDrugInfo(Obj, 'PH_BUTTONS');
            fEnquiry.contentWindow.document.forms[0].display1.value = "N";
            fRequest.contentWindow.f_request1.document.forms[0].display2.value = "Y";
            fPatient.contentWindow.document.forms[0].display3.value = "N";
            fResponse.contentWindow.f_response1.document.forms[0].display4.value = "N";
            parent.parent.frames[3].location.href = "../../eCommon/jsp/error.jsp"; // Redirect to error page
        }
    } else if (str === "Pat_dtl") {
        flag = chkMandatary("Enc_dtl", '');
        if (fRequest.style.height === "100vh") {
            flag = chkMandatary('Req_dtl', '');
        }
        if (fResponse.style.height === "100vh") {
            flag = chkMandatary('Res_dtl', '');
        }
        if (flag === 'true') {
            fEnquiry.style.height = "0vh";
            fRequest.style.height = "0vh";
            fPatient.style.height = "100vh";
            fResponse.style.height = "0vh";
            changeButtonColorDrugInfo(Obj, 'PH_BUTTONS');
            fEnquiry.contentWindow.document.forms[0].display1.value = "N";
            fRequest.contentWindow.f_request1.document.forms[0].display2.value = "N";
            fPatient.contentWindow.document.forms[0].display3.value = "Y";
            fResponse.contentWindow.f_response1.document.forms[0].display4.value = "N";
            parent.parent.frames[3].location.href = "../../eCommon/jsp/error.jsp"; // Redirect to error page
        }
    } else if (str === "Res_dtl") {
        flag = chkMandatary("Enc_dtl", '');
        if (fRequest.style.height === "100vh") {
            flag = chkMandatary('Req_dtl', '');
        }
        if (fPatient.style.height === "100vh") {
            flag = chkMandatary('Pat_dtl', '');
        }
        if (flag === 'true') {
            fEnquiry.style.height = "0vh";
            fRequest.style.height = "0vh";
            fPatient.style.height = "0vh";
            fResponse.style.height = "100vh";
            changeButtonColorDrugInfo(Obj, 'PH_BUTTONS');
            fEnquiry.contentWindow.document.forms[0].display1.value = "N";
            fRequest.contentWindow.f_request1.document.forms[0].display2.value = "N";
            fPatient.contentWindow.document.forms[0].display3.value = "N";
            fResponse.contentWindow.f_response1.document.forms[0].display4.value = "Y";
            parent.parent.frames[3].location.href = "../../eCommon/jsp/error.jsp"; // Redirect to error page
        }
    }
}



async function searchPractitionerName() {
	parent.f_enquiry.document.PhDrugInfoEnqForm.Pract_name.value="";
	parent.f_enquiry.document.PhDrugInfoEnqForm.Designation.value="";
	parent.f_enquiry.document.PhDrugInfoEnqForm.pract_type.value="";
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	dataNameArray[0]	= "FACILITY_ID" ;
	dataValueArray[0]	= parent.f_enquiry.PhDrugInfoEnqForm.Logged_in_fc.value;
	dataTypeArray[0]	= STRING ;
	argumentArray[0]    = parent.f_enquiry.document.PhDrugInfoEnqForm.sql1.value;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,3";
	argumentArray[5] = parent.f_enquiry.document.PhDrugInfoEnqForm.Pract_name.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;
	retArray =await CommonLookup( getLabel("ePH.PractitionerSearch.label","PH"), argumentArray );
	var str =unescape(retArray);
	var arr = str.split(",");
	if(retArray != null && retArray != "") {
		parent.f_enquiry.PhDrugInfoEnqForm.Pract_name.value = arr[1];
		parent.f_enquiry.PhDrugInfoEnqForm.Pract_id.value = arr[0];
		getPracType(arr[0])
	}
}

function ChkMaxLen(lab,obj,max,mode) {
	if(obj.value.length >= max) {
		alert("APP-SM0045 - " + lab +getLabel("ePH.Cannotexceed.label","PH") + max  + " characters" );
	//	obj.select();
		return false;
	}
	else return true;
}

//Patient Search from common.js
async function callPatientSearch(){
	var formObj = parent.f_patient.PhDrugInfoPatForm;
	var formObj1 = parent.f_enquiry.PhDrugInfoEnqForm;
	var patient_id =await PatientSearch();

	if(patient_id != null && patient_id != "" )  {
		formObj.patient_id.value = patient_id;
		formObj.patient_id.disabled = true;
		//formObj.patient_search.disabled = true;
	
		var bean_id="PhDrugInfoEnqBean" ; 
		var bean_name="ePH.PhDrugInfoEnqBean";
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "patient_id =\"" + patient_id + "\" " ;
		xmlStr+= "bean_id =\"" +formObj1.bean_id.value+ "\" " ;
		xmlStr+= "bean_name =\"" + formObj1.bean_id.value + "\" " ;
		xmlStr +=" /></root>";
		var temp_jsp="PhDrugInfoValidation.jsp?func_mode=getPatientDtl";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;		
		eval(responseText);
	}
}

function showFacility(Obj){
	var frmObj	= parent.f_enquiry.PhDrugInfoEnqForm;
	frmObj.Designation.value="";
	frmObj.pract_type.value="";
	frmObj.Pract_name.value="";
	frmObj.request_mode.value='';
	parent.f_enquiry.PhDrugInfoEnqForm.other_mode.disabled=false;
	parent.f_enquiry.document.PhDrugInfoEnqForm.other_mode.value="";
	parent.f_enquiry.document.getElementById("main_mode").style.display="none";
	parent.f_enquiry.document.getElementById("oth_mode").style.display="inline";
	parent.f_enquiry.document.getElementById("id3").style.display="inline";
	parent.f_enquiry.document.getElementById("id7").style.display="inline";
	if(Obj.name=="Source"){
		var Source	= parent.f_enquiry.PhDrugInfoEnqForm.Source.value;
		if(Obj.value=="WithinF"){
			parent.f_enquiry.document.getElementById("fc").style.display="inline";
			frmObj.Pract_name_btn.disabled=false;
			parent.f_enquiry.document.getElementById("pn").style.display="none";
			parent.f_enquiry.document.getElementById("id5").style.display="none";
			//document.getElementById("ff").style.display="none";
			parent.f_enquiry.document.getElementById("mand").style.display="inline";
			parent.f_enquiry.document.getElementById("id1").style.display="inline";
			parent.f_enquiry.document.getElementById("id4").style.display="none";
			parent.f_enquiry.document.getElementById("mando").style.display="none";
		}
		if(Obj.value=="Public"){
			parent.f_enquiry.document.getElementById("pn").style.display="inline";
			parent.f_enquiry.document.getElementById("id5").style.display="inline";
			parent.f_enquiry.document.getElementById("fc").style.display="none";
			parent.f_enquiry.document.getElementById("ff").style.display="none";
			parent.f_enquiry.document.getElementById("mand").style.display="none";
			frmObj.Pract_name_btn.disabled=true;
			parent.f_enquiry.document.getElementById("id1").style.display="none";
			parent.f_enquiry.document.getElementById("id4").style.display="none";
			parent.f_enquiry.document.getElementById("mando").style.display="none";
		}
		if(Obj.value=="LoggedF"){
			parent.f_enquiry.document.forms[0].Pract_id.value='';
			parent.f_enquiry.document.getElementById("ff").style.display="inline";
			parent.f_enquiry.document.getElementById("pn").style.display="none";
			parent.f_enquiry.document.getElementById("id5").style.display="none";
			parent.f_enquiry.document.forms[0].other_pract.value="";
			//	frmObj.facility_name.disabled=false;
			parent.f_enquiry.document.getElementById("fc").style.display="none";
			frmObj.Pract_name_btn.disabled=false;
			frmObj.facility_name.disabled=true;
			frmObj.facility_name.value=frmObj.LoggedF.value;
			parent.f_enquiry.document.getElementById("id1").style.display="inline";
			parent.f_enquiry.document.getElementById("id4").style.display="inline";
			parent.f_enquiry.document.getElementById("mando").style.display="none";
		}
		if(Obj.value=="OtherF"){
			parent.f_enquiry.document.getElementById("ff").style.display="inline";
			frmObj.Pract_name_btn.disabled=true;
			frmObj.facility_name.disabled=false;
			frmObj.facility_name.value="";
			parent.f_enquiry.document.getElementById("pn").style.display="inline";
			parent.f_enquiry.document.getElementById("mando").style.display="inline";
			parent.f_enquiry.document.getElementById("id5").style.display="inline";
			parent.f_enquiry.document.forms[0].other_pract.value="";
			parent.f_enquiry.document.getElementById("fc").style.display="none";
			parent.f_enquiry.document.getElementById("mand").style.display="inline";
			parent.f_enquiry.document.getElementById("id1").style.display="none";
			parent.f_enquiry.document.getElementById("id4").style.display="inline";
		}
	}
}

function getPracType(Obj){	
	var frmObj=parent.f_enquiry.document.PhDrugInfoEnqForm;
	var pract_id=Obj;
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "pract_id =\"" + pract_id + "\" " ;
	xmlStr+= "bean_id =\"" + frmObj.bean_id.value+ "\" " ;
	xmlStr+= "bean_name =\"" + frmObj.bean_name.value + "\" " ;
	xmlStr +=" /></root>";
	var temp_jsp="PhDrugInfoValidation.jsp?func_mode=getPractType";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	//alert(xmlStr);
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;		
	eval(responseText);
}

function assignPractType(pract_type, pract_desc){
	parent.f_enquiry.document.PhDrugInfoEnqForm.Designation.value=pract_desc;
	parent.f_enquiry.document.PhDrugInfoEnqForm.pract_type.value=pract_type;
}

function chkDate(dt_from,dt_to){ 
	/*if(doDateCheckAlert(dt_from,dt_to)){
		//parent.frames[2].location.href='../../eCommon/jsp/error.jsp'; 
	}
	else{
	}*/
}

function callFirst(){

	var frmObj=parent.parent.f_enquiry.PhDrugInfoEnqForm;
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "bean_id =\"" + frmObj.bean_id.value+ "\" " ;
	xmlStr+= "bean_name =\"" + frmObj.bean_name.value + "\" " ;
	xmlStr +=" /></root>";
	
	//var temp_jsp="PhDrugInfoValidation.jsp?func_mode=setDate1";
	var temp_jsp="PhDrugInfoValidation.jsp?func_mode=getSysdate";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	//alert(xmlStr);
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;	
	eval(responseText)
}

function setDate1(date){
	parent.f_response3.PhDrugInfoResInfoDtls1Form.sysdate1.value=date;
	var today=parent.f_response3.PhDrugInfoResInfoDtls1Form.sysdate1;
	var obj=parent.f_response3.PhDrugInfoResInfoDtls1Form.response_dt;
	validateEnquiryDate1(obj,today,'');
}
/*function test(obj,today){
	var formobj=parent.parent.f_query_add_mod.f_enquiry.document.PhDrugInfoEnqForm;
	var locale = formobj.locale.value;
	var obj=convertDate(obj.value,"DMYHM",locale,"en");
	validateEnquiryDate(obj,today);
}*/
function validateEnquiryDate(obj,today){
	var formobj=parent.parent.f_query_add_mod.f_enquiry.document.PhDrugInfoEnqForm;
	var locale = formobj.locale.value;
	var actualobj = obj;
	var obj=convertDate(obj.value,"DMYHM",locale,"en");
	
	var res_dt=parent.f_response.frames[2].PhDrugInfoResInfoDtls1Form.response_dt;
	//var res_dt = convertDate(parent.f_response.frames[2].PhDrugInfoResInfoDtls1Form.response_dt.value,"DMYHM",locale,"en");
	if(obj.value != "") {
		if(!doDateTimeChk(obj) ){
			alert(getMessage("INVALID_DATE_TIME","PH"))
			actualobj.value = "";
		}
    }
	if(obj.name=="enc_dt"){
		if(obj.value != "" && today.value != "" && obj.value!=today.value){
			if(ValidateDateTime(today,obj)){
				//alert("Enquiry Date/Time should not be greater than Sysdate");
				alert(getMessage("PH_DRUG_INFO_TRN1","PH"));
				obj.select();
				obj.value="";
			}
		}
		var err='';
		if(res_dt.value !="" && obj.value != "" ){
			if(ValidateDateTime(res_dt,obj)){
				err=getMessage("PH_DRUG_INFO_TRN3","PH")+getMessage("RESPONSE_TIME","PH")+res_dt.value;
				alert(err);
				obj.focus();
				obj.value="";
				return true;
			}
			getRespondTime1();
		}
	}
}

function validateEnquiryDate1(obj,today,mode){
	var enq_date=parent.parent.f_enquiry.PhDrugInfoEnqForm.enc_dt;
	if(obj.value != ""){
		if(!doDateTimeChk(obj) ){
			alert(getMessage("INVALID_DATE_TIME","PH"))
			obj.value="";
		}
    }
	if(obj.name=="response_dt"){
		if(obj.value != "" && today.value != ""){
			if(ValidateDateTime(today,obj)){
			//alert("Respond Date/Time should not be greater than Sysdate");
			alert(getMessage("PH_DRUG_INFO_TRN2","PH"));
			//obj.focus();
			Obj.value='';
			return true;
		}
		if(ValidateDateTime(obj,enq_date)){
			//alert("Respond Date/Time should be greater than Enquiry Date/Time");
			alert(getMessage("PH_DRUG_INFO_TRN3","PH"));
			obj.focus();
			obj.value="";
			return true;
			}
			getRespondTime();
		}
		else{
			parent.frames[2].document.getElementById("resp_tt").innerText='';
			parent.frames[2].document.forms[0].verify.checked='';
			parent.frames[2].document.forms[0].verify.disabled=true;
		}
	}
}

function callPriority(Obj){
	if(Obj.value !=""){
		parent.f_enquiry.document.getElementById("main_prio").style.display="inline";
		parent.f_enquiry.document.getElementById("id2").style.display="none";
		parent.f_enquiry.document.getElementById("id6").style.display="none";
		parent.f_enquiry.document.forms[0].other_priority.value='';
	}
	else{
		parent.f_enquiry.PhDrugInfoEnqForm.other_priority.disabled=false;
		parent.f_enquiry.document.PhDrugInfoEnqForm.other_priority.value="";
		parent.f_enquiry.document.getElementById("main_prio").style.display="none";
		parent.f_enquiry.document.getElementById("oth_prio").style.display="inline";
		parent.f_enquiry.document.getElementById("id2").style.display="inline";
		parent.f_enquiry.document.getElementById("id6").style.display="inline";
		parent.f_enquiry.document.forms[0].other_priority.value='';
	}
}

function callMode(Obj){
	if(Obj.value !=""){
		parent.f_enquiry.document.getElementById("main_mode").style.display="inline";
		parent.f_enquiry.document.getElementById("id3").style.display="none";
		parent.f_enquiry.document.getElementById("id7").style.display="none";
		parent.f_enquiry.document.forms[0].other_mode.value='';
	}
	else{
		parent.f_enquiry.PhDrugInfoEnqForm.other_mode.disabled=false;
		parent.f_enquiry.document.PhDrugInfoEnqForm.other_mode.value="";
		parent.f_enquiry.document.getElementById("main_mode").style.display="none";
		parent.f_enquiry.document.getElementById("oth_mode").style.display="inline";
		parent.f_enquiry.document.getElementById("id3").style.display="inline";
		parent.f_enquiry.document.getElementById("id7").style.display="inline";
	}
	if(Obj.value == 'S'){ //Added for HSA-CRF-0158 [IN:048491] -start
		if(document.PhDrugInfoEnqForm.login_pract_id.value==''){//if condition added for IN:049077
			alert(getMessage("PH_LOGIN_USER_NOT_PRACT","PH"));
			return false;
		}
		parent.f_enquiry.document.getElementById("pn").style.display="none";
		parent.f_enquiry.document.getElementById("id5").style.display="none";
		parent.f_enquiry.document.forms[0].other_pract.value='';
		//parent.f_enquiry.document.PhDrugInfoEnqForm.Pract_name.value = document.PhDrugInfoEnqForm.appl_user_name.value;//commented for IN:049077
		//parent.f_enquiry.document.PhDrugInfoEnqForm.Pract_id.value = document.PhDrugInfoEnqForm.login_user.value;//commented for IN:049077
		parent.f_enquiry.document.PhDrugInfoEnqForm.Pract_name.value = document.PhDrugInfoEnqForm.login_pract_name.value;//code added for IN:049077
		parent.f_enquiry.document.PhDrugInfoEnqForm.Pract_id.value = document.PhDrugInfoEnqForm.login_pract_id.value;//code added for IN:049077
		getPracType( document.PhDrugInfoEnqForm.Pract_id.value);
	}
	else{
		parent.f_enquiry.document.getElementById("pn").style.display="inline";
		parent.f_enquiry.document.getElementById("id5").style.display="inline";
		parent.f_enquiry.document.forms[0].other_pract.value='';
		parent.f_enquiry.document.PhDrugInfoEnqForm.Pract_name.value = "";
		parent.f_enquiry.document.PhDrugInfoEnqForm.Pract_id.value = "";
		parent.f_enquiry.document.PhDrugInfoEnqForm.Designation.value="";
		parent.f_enquiry.document.PhDrugInfoEnqForm.pract_type.value="";
	}//Added for HSA-CRF-0158 [IN:048491] -end
}

function assignPatientDtl(patient_name,patient_age,sex,ethnic_grp){
	var len1="";
	var check="F";
	var len=0;
	var ss="";
	var unit="";
	var unit_value="";
	if(patient_age.indexOf("Y")!=-1){
		len=patient_age.indexOf("Y");	
		ss=patient_age.substring(0,len);
		check="T";
		unit="Year(s)";
		unit_value="Y";
		parent.f_patient.document.PhDrugInfoPatForm.age_unit.selectedIndex=2;
		}
	if(check=="F"){
		if(patient_age.indexOf("M")!=-1){
			len=patient_age.indexOf("M");	
			ss=patient_age.substring(0,len);
			check="T";
			unit="Month(s)";
			unit_value="M";
			parent.f_patient.document.PhDrugInfoPatForm.age_unit.selectedIndex=1;
		}
	}
	if(check=="F"){
		if(patient_age.indexOf("D")!=-1){
			len=patient_age.indexOf("D");	
			ss=patient_age.substring(0,len);
			check="T";
			unit="Day(s)";
			unit_value="D";
			parent.f_patient.document.PhDrugInfoPatForm.age_unit.selectedIndex=0;
		}
	}
	parent.f_patient.document.PhDrugInfoPatForm.age_unit.disabled=true;
	parent.f_patient.document.PhDrugInfoPatForm.age.value=ss;
	parent.f_patient.document.PhDrugInfoPatForm.age.disabled=true;
	
	if(sex=="M") 
		parent.f_patient.document.getElementById("gender").selectedIndex=0;
	else if(sex=="F")
		parent.f_patient.document.getElementById("gender").selectedIndex=1;
	else 
		parent.f_patient.document.getElementById("gender").selectedIndex=2;
	parent.f_patient.document.getElementById("gender").disabled=true;
		
	var ee =parent.f_patient.document.PhDrugInfoPatForm.ethnic_grp.options.length;
	var tt=parent.f_patient.document.PhDrugInfoPatForm.ethnic_grp;
	for(var i=0;i<ee;i++){
		if(tt.options[i].value==ethnic_grp){
			parent.f_patient.document.PhDrugInfoPatForm.ethnic_grp.selectedIndex=i;
		}
	}

	if(parent.f_patient.document.PhDrugInfoPatForm.ethnic_grp.value!="")
		parent.f_patient.document.PhDrugInfoPatForm.ethnic_grp.disabled=true;
	else{
		parent.f_patient.document.PhDrugInfoPatForm.ethnic_grp.disabled=false;
	}
	parent.f_patient.document.PhDrugInfoPatForm.patient_name.value=patient_name;
	parent.f_patient.document.PhDrugInfoPatForm.patient_name.disabled=true;
	parent.f_patient.document.getElementById("clinical_cond").style="display";
	parent.f_patient.document.getElementById("diagnosis").style="display";
	parent.f_patient.document.getElementById("last_row").style.display='none';
}

function disableDesignation(Obj){
	if(Obj.value !="")
		parent.f_enquiry.PhDrugInfoEnqForm.Designation.disabled=false;
	if(Obj.value =="")
		parent.f_enquiry.PhDrugInfoEnqForm.Designation.disabled=true;
}

function doSwap(){
	parent.f_enquiry.PhDrugInfoEnqForm.rep_line1.value=parent.f_enquiry.PhDrugInfoEnqForm.line1.value;
	parent.f_enquiry.PhDrugInfoEnqForm.rep_line2.value=parent.f_enquiry.PhDrugInfoEnqForm.line2.value;
	parent.f_enquiry.PhDrugInfoEnqForm.rep_line3.value=parent.f_enquiry.PhDrugInfoEnqForm.line3.value;
	parent.f_enquiry.PhDrugInfoEnqForm.rep_line4.value=parent.f_enquiry.PhDrugInfoEnqForm.line4.value;
	parent.f_enquiry.PhDrugInfoEnqForm.rep_email.value=parent.f_enquiry.PhDrugInfoEnqForm.email.value;
	parent.f_enquiry.PhDrugInfoEnqForm.rep_fac_num.value=parent.f_enquiry.PhDrugInfoEnqForm.fac_num.value;
	parent.f_enquiry.PhDrugInfoEnqForm.rep_tel_num.value=parent.f_enquiry.PhDrugInfoEnqForm.tel_num.value;

}

function showResDtl(Obj){
	if(Obj.value==getLabel("ePH.Respond.label","PH")){ 
		parent.frames[2].document.getElementById("respond_dt").style.display='inline';
		parent.frames[2].document.getElementById("respond_txt").style.display='inline';
		parent.frames[2].document.getElementById("replied_by").style.display='inline';
		parent.frames[2].document.getElementById("res_tt").style.display='inline';
		Obj.value=getLabel("ePH.DontRespond.label","PH");
	}
	else{
		Obj.value=getLabel("ePH.Respond.label","PH")
		parent.frames[2].document.getElementById("respond_dt").style.display='none';
		parent.frames[2].document.getElementById("respond_txt").style.display='none';
		parent.frames[2].document.getElementById("replied_by").style.display='none';
		parent.frames[2].document.getElementById("res_tt").style.display='none';

		parent.frames[2].document.getElementById("response_dt").value='';
		parent.frames[2].document.getElementById("verify").value='N';
		parent.frames[2].document.getElementById("resp_tt").innerText='';
		parent.frames[2].document.getElementById("resp_tt").value='';
		//parent.frames[2].document.getElementById("replied_by").style.display='none';
		//parent.frames[2].document.getElementById("res_tt").style.display='none';
		parent.frames[2].document.forms[0].verify.checked='';
	}
}

function chkMandatary(str,str1){
	var flag			   = 'true';
	var errors				="";
	var messageFrame	=	"";
	var fields = new Array ();
	var names = new Array ();
	var i=0;
	var formObj			=	"";// Added to avoid script error on QueryMode Apply event
	var formObj1		=	"";// Added to avoid script error on QueryMode Apply event
	if(str=="Enc_dtl"){
		if(str1=='apply'){
			messageFrame=frames[3];// //Changed frames 2 to 3 for  Bru-HIMS-CRF-078 [IN:029944]
			//var formObj		   = parent.frames[1].frames[1].frames[1].document.forms[0];
			if(f_query_add_mod.f_query_criteria1 == undefined){// Added to avoid script error on QueryMode Apply event
				if(f_query_add_mod.f_enquiry!=undefined || parent.f_request !=undefined || parent.f_patient !=undefined || parent.f_response !=undefined ){// Added to avoid script error on QueryMode Apply event
					formObj		   = f_query_add_mod.f_enquiry.document.forms[0];
					formObj1	   = f_query_add_mod.f_request.f_request1.document.forms[0];
				}
			}
		}
		else{
			messageFrame=parent.parent.messageFrame;
			var formObj		   = parent.f_enquiry.PhDrugInfoEnqForm;
		}
		if(parent.f_enquiry !=undefined ||  (parent.f_enquiry !=undefined  && f_query_add_mod.f_query_criteria1 == undefined) || (f_query_add_mod.f_enquiry!=undefined && f_query_add_mod.f_query_criteria1 == undefined)){// Added to avoid script error on QueryMode Apply event
			if(formObj.Source.value=="WithinF" ){
				if(formObj.other_source.value==''){
					fields[i]=formObj.other_source;
					names[i]=getLabel("Common.FacilityName.label","Common");
					flag='false'
					i++;
				}
			}
			if(formObj.Source.value=="OtherF" ){
				if(formObj.facility_name.value==''){
					fields[i]=formObj.facility_name;
					names[i]=getLabel("Common.FacilityName.label","Common");
					flag='false'
					i++;
				}
			}
			if(formObj.Source.value=="Public" || formObj.Source.value=="OtherF"){
				if((formObj.other_pract.value=="" && formObj.request_mode.value!='S')|| (formObj.Pract_name.value=="" && formObj.request_mode.value=='S')){
					fields[i]=formObj.other_pract;
					names[i]=getLabel("Common.practitionername.label","Common");
					flag='false'
					i++;
				}
			}
			if(formObj.Source.value=="LoggedF" || formObj.Source.value=="WithinF"){
				if(formObj.Pract_name.value==""){
					fields[i]=formObj.Pract_name;
					names[i]=getLabel("Common.practitionername.label","Common");
					flag='false'
					i++;
				}
			}
			if(formObj.priority.value=="" && formObj.other_priority.value=="") {
				fields[i]=formObj.priority;
				names[i]=getLabel("Common.priority.label","Common");
				flag='false';
				i++;
			}
			if(formObj.enc_dt.value==""){
				fields[i]=formObj.enc_dt;
				names[i]=getLabel("ePH.EnquiryDate.label","PH");
				i++;
				flag='false';
			}
			if(formObj.request_mode.value=="" && formObj.other_priority=="" ){
				fields[i]=formObj.other_priority;
				names[i]=getLabel("Common.RequestMode.label","Common");
				flag='false';
				i++;
			}
			if(str1=='apply'){
				if(formObj1.Request_dtl.value==''){
					fields[i]=formObj1.Request_dtl;
					names[i]=getLabel("ePH.Request/QueryDtl.label","PH");
					flag='false';
					i++;
				}
			}
		}
		else{// Added to avoid script error on QueryMode Apply event
			flag='false';
			return flag;
		}
	}
	else if(str=="Req_dtl" ){
		i=0;	
		var formObj	   = parent.f_request.f_request1.PhDrugInfoReqForm;
		messageFrame=parent.parent.messageFrame;
		if(formObj.Request_dtl.value==""){
			fields[i]=formObj.Request_dtl;
			names[i]=getLabel("ePH.Request/QueryDtl.label","PH");
			flag='false';
			i++;
			flag='false'
		}
		//return flag;
	}
	if(fields.length==0){
		flag='true';
		return flag;
	}
	else{
		flag='false'
		for( var i=0; i<fields.length; i++ ) {
			errors = errors + "APP-PH0045 " +names[i]+" "+getLabel("Common.Cannotbeblank.label","Common") + "<br>" ;
		}
		messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+errors;
		error_str=errors;// Added to avoid script error on QueryMode Apply event
		return flag;
	}
}//Karabi

async function callActive(patient_id){
	var function_id		= "";
	var no_of_items		= "";
	var option_type		= "";
	var module_id		= "PH";
	if(module_id=="PH"){   //Used only For Pharmacy Orders
		 function_id	= "PH";
		 no_of_items 	= "3";
		 option_type	= "ACTIVE";
	}
	var query_string	= "patient_id="+patient_id+"&P_function_id="+function_id+"&P_no_of_items="+no_of_items+"&P_option_type="+option_type
	var retVal 			= new String();
	var dialogHeight 	= "87vh" ;//code  '29' replaced by 45 for IN:048274
	var dialogWidth  	= "90vw" ;
	var dialogTop    	= "20";
    var status 			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
	retVal =await top.window.showModalDialog("../../eCA/jsp/PatProblemList.jsp?modal_yn=Y&"+query_string,arguments,features);
}

// Called on click of the Allergies button
async function callAllergies(patient_id){
	var retVal 			= 	new String();
	var dialogHeight 	= "800px" ;
	var dialogWidth  	= "1000px" ;
	var dialogTop    	= "100";
    var status 			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
	retVal =await window.showModalDialog("../../eCA/jsp/AllergyList.jsp?called_from_ip=Y&patient_id="+patient_id,arguments,features);
}

function getRespondTime(){
	var frmObj=parent.parent.f_enquiry.document.PhDrugInfoEnqForm;
	var frmObj1=parent.frames[2].document.PhDrugInfoResInfoDtls1Form;
	var enq_date=frmObj.enc_dt.value;
	var resp_dt=frmObj1.response_dt.value;
	if(enq_date!="" && resp_dt!=""){
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "enq_date =\"" + enq_date + "\" " ;
		xmlStr+= "resp_dt =\"" + resp_dt + "\" " ;
		xmlStr+= "bean_id =\"" + frmObj.bean_id.value+ "\" " ;
		xmlStr+= "bean_name =\"" + frmObj.bean_name.value + "\" " ;
		xmlStr +=" /></root>";
		
		var temp_jsp="PhDrugInfoValidation.jsp?func_mode=getRespondTime";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		//alert(xmlStr);
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;		
		//alert(responseText);
		eval(responseText);
	}
}

function getRespondTime1(){
	var frmObj=parent.f_enquiry.document.PhDrugInfoEnqForm;
	var frmObj1=parent.f_response.frames[2].document.PhDrugInfoResInfoDtls1Form;
	var enq_date=frmObj.enc_dt.value;
	var resp_dt=frmObj1.response_dt.value;
	if(enq_date!="" && resp_dt!=""){
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "enq_date =\"" + enq_date + "\" " ;
		xmlStr+= "resp_dt =\"" + resp_dt + "\" " ;
		xmlStr+= "bean_id =\"" + frmObj.bean_id.value+ "\" " ;
		xmlStr+= "bean_name =\"" + frmObj.bean_name.value + "\" " ;
		xmlStr +=" /></root>";
		var temp_jsp="PhDrugInfoValidation.jsp?func_mode=getRespondTime1";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		//alert(xmlStr);
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;		
		//alert(responseText);
		eval(responseText);
	}
}

function assignRespondTime1(RespondTime){
	parent.f_response.frames[2].document.getElementById("resp_tt").innerText='';
	parent.f_response.frames[2].document.getElementById("resp_tt").innerText=RespondTime;
}

function assignRespondTime(RespondTime){
	parent.f_response3.document.getElementById("resp_tt").innerText='';
	parent.f_response3.document.getElementById("resp_tt").innerText=RespondTime;
	parent.f_response3.document.forms[0].verify.checked='';
	parent.f_response3.document.forms[0].verify.disabled=false;
}

function checkFlds( fields, names) {
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}
		else	errors = errors + "APP-000001 " + names[i] +getLabel("Common.Cannotbeblank.label","Common")+ "\n" ;
	}
	if ( errors.length != 0 ) {
		alert(errors) ;
		return false ;
	}
	return true ;
}

async function showDrugProfile(patient_id,disp_locn_code,pat_class){
	 
	var dialogHeight	= "85vh";//"34" ;
	var dialogWidth		= "90vw" ;
	var dialogTop		= "25" ;
	var center			= "1" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; scroll : auto; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	retVal				=await top.window.showModalDialog( "../../ePH/jsp/QueryPatientDrugProfileFrames.jsp?patient_id="+escape(patient_id)+"&called_frm=Prescription&disp_locn_code="+disp_locn_code+"&pat_class="+pat_class, arguments, features );
}

async function callVerify(Obj){
	if(Obj.checked){
		parent.f_response3.document.forms[0].verify.value='Y';
		/*if(confirm(getMessage("PH_ADR_VERIFY"))){
			var dialogTop   = "125";
			var dialogHeight    = "10" ;
			var dialogWidth = "20" ;*/
			var dialogTop   = "225";
			var dialogHeight    = "800px" ;
			var dialogWidth = "1000px" ;
			var DialogLeft="15" 
			var arguments   = "" ;
			var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no;scrolling: no" ;
			var retval =await window.showModalDialog("PhDrugInfoSignDetail.jsp?",arguments,features);
	
		//}
		if(retval !='OK'){
			parent.f_response3.document.forms[0].verify.value='N';
			parent.f_response3.document.forms[0].verify.checked='';
		}
			
	}
	else{
		parent.f_response3.document.forms[0].verify.value='N';
		parent.f_response3.document.forms[0].verify.checked='';
	}
}

async function searchUserNames1( target ) {
	var frmObj = document.DrugInfoSignedBy;
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

	argumentArray[0] = document.getElementById("SQL_PH_DISP_RIGHTS_SELECT1").value;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;
	argumentArray[7] = CODE_DESC ;
	retArray =await CommonLookup( getLabel("Common.SearchUser.label","Common"), argumentArray );
	var str =unescape(retArray);
	var arr = str.split(",");
	if(retArray != null && retArray != "" ) {
		frmObj.SignedBy.value = arr[1];
       	frmObj.user_search.disabled=true;
	}
	else{
		target.value = "";
		target.focus();
	}
}

function checkUser1(objVal){
	if (objVal == "") {
		document.DrugInfoSignedBy.SignedBy.disabled=false;
	}
	else {
		searchUserNames1(document.DrugInfoSignedBy.SignedBy);
	}
}


function setSignedBy(Signed_By,Date_Time,verify_remarks,bean_id,bean_name){

	var SignedBy = Signed_By.value;
	var DateTime = Date_Time.value;
	var verify_remarks=verify_remarks.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH " ;
	xmlStr+= "bean_id =\"" + bean_id+ "\" " ;
	xmlStr+= "bean_name =\"" + bean_name + "\" " ;
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "PhDrugInfoValidation.jsp?&func_mode=SETSIGNEDBYVALUES&SignedBy="+SignedBy+"&DateTime="+DateTime+"&verify_remarks="+verify_remarks, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
}

function callVerification(){
}

function callResponse(){
}

function validate_date(Obj,ref) {
	var formObj				=	 parent.f_query_criteria1.document.formDrugInfoQueryCriteria;                
	var locale = formObj.language_id.value; 
	if (CheckDate(Obj)){
		if(ref == "FROM_DATE_LESS_SYSDATE" ){
			// from = parent.frames[1].document.forms[0].b_from_date;
			// to = parent.frames[1].document.forms[0].sys_date;
			error_id = getMessage("FROM_DATE_LESS_SYSDATE","PH");
		}
		else if(ref == "TO_DT_GR_EQ_FM_DT"){
			from = document.forms[0].enq_date_to;
			//from = convertDate(formObj.enq_date_to.value,"DMY",locale,"en");

			to = document.forms[0].enq_date_from;
			//to = convertDate(formObj.enq_date_from.value,"DMY",locale,"en");
			error_id = getMessage("TO_DT_GR_EQ_FM_DT","PH");
		}
		else if(ref == "TO_DT_GR_EQ_FM_DT1"){
			from = document.forms[0].respond_date_to;
			//from = convertDate(formObj.respond_date_to,"DMY",locale,"en");
			to = document.forms[0].respond_date_from;
			//to = convertDate(formObj.respond_date_from,"DMY",locale,"en");
			error_id = getMessage("TO_DT_GR_EQ_FM_DT","PH");
		}
		else if(ref == "TO_DATE_LESS_FROM"){
			from = document.forms[0].enq_date_to;
			//from = convertDate(formObj.enq_date_to,"DMY",locale,"en");
			to = document.forms[0].enq_date_from;
			//to = convertDate(formObj.enq_date_from,"DMY",locale,"en");
			error_id = getMessage("TO_DT_GR_EQ_FM_DT","PH");
		}
		else if(ref == "TO_DATE_LESS_FROM1"){
			from = document.forms[0].respond_date_to;
			//from = convertDate(formObj.respond_date_to,"DMY",locale,"en");
			to = document.forms[0].respond_date_from;
			//to = convertDate(formObj.respond_date_from,"DMY",locale,"en");
			error_id = getMessage("TO_DT_GR_EQ_FM_DT","PH");
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
				from.value="";
 				from.focus();
			}
			else if(Date.parse(todt) <= Date.parse(fromdt)){
		       //parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num= ";
		       return true;
			} 
		}
		return true;
	}
}


function DateCheck(from,to) {
    var fromarray;
    var toarray;
	var formObj				=	 parent.f_query_criteria1.document.formDrugInfoQueryCriteria;
	var locale				=	 formObj.language_id.value;
	var fromdate = from.value ; 
    var todate = convertDate(to.value,"DMY",locale);
    if(fromdate.length > 0 && todate.length > 0 ) {
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(todt) > Date.parse(fromdt)) {
			var invaldt = getMessage("START_DATE_GREATER_SYSDATE","Common");
			alert(invaldt);
			to.value="";
			to.select();
			to.focus();
		}
		else if(Date.parse(todt) <= Date.parse(fromdt))
			return true;
    }
    return true;
}


function showResult(){
	
	var formObj				=	 parent.f_query_criteria1.document.formDrugInfoQueryCriteria;
	var locale				=	 formObj.language_id.value;
//	var enq_date_from		=	 formObj.enq_date_from.value;
	var enq_date_from		=	 convertDate(formObj.enq_date_from.value,"DMY",locale,"en");
//	var enq_date_to			=	 formObj.enq_date_to.value;
	var enq_date_to			=	 convertDate(formObj.enq_date_to.value,"DMY",locale,"en");

//	var respond_date_from	=	 formObj.respond_date_from.value;
	var respond_date_from	=	 convertDate(formObj.respond_date_from.value,"DMY",locale,"en");
//	var respond_date_to		=	 formObj.respond_date_to.value;
	var respond_date_to		=	 convertDate(formObj.respond_date_to.value,"DMY",locale,"en");
	var source				=	 formObj.source.value;
	var designation			=	 formObj.designation.value;
	var priority			=	 formObj.priority.value;
	var request_mode		=	 formObj.request_mode.value;
	var response			=	 formObj.response.value;
	var verify				=	 formObj.verify.value;
	var Enq_num				=	 formObj.Enq_num.value;
	var req_catg			=	 formObj.req_catg.value;

	var fields = new Array (formObj.enq_date_from,formObj.enq_date_to);
	var names = new Array (getLabel("ePH.EnquiryDateFrom.label","PH"),getLabel("ePH.EnquiryDateTo.label","PH"));
	
	if(checkFields(fields,names,parent.parent.messageFrame)){
		parent.frames[1].location.href="../../ePH/jsp/PhDrugInfoQueryResult.jsp?enq_date_from="+enq_date_from+"&enq_date_to="+enq_date_to+"&respond_date_from="+respond_date_from+"&respond_date_to="+respond_date_to+"&source="+source+"&designation="+designation+"&priority="+priority+"&request_mode="+request_mode+"&response="+response+"&verify_yn="+verify+"&Enq_num="+Enq_num+"&req_catg="+req_catg;
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	}
}

function activeLink() {
    if( start != 0 ){
        parent.frames[1].document.getElementById("prev").style.visibility='visible';
    }
    else{
		parent.frames[1].document.getElementById("prev").style.display='none';
    }
    if( end >= maxRec )
        parent.frames[1].document.getElementById("next").style.display='none';
    else
        parent.frames[1].document.getElementById("next").style.visibility='visible';
}


function showEnqDtl(enq_num){
	if(enq_num != ""){
		var bean_id="PhDrugInfoEnqBean" ;
		var bean_name="ePH.PhDrugInfoEnqBean";
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "enq_num =\"" + enq_num + "\" " ;
		xmlStr+= "bean_id =\"" +bean_id+ "\" " ;
		xmlStr+= "bean_name =\"" +bean_id + "\" " ;
		xmlStr +=" /></root>";
		
		var temp_jsp="PhDrugInfoValidation.jsp?func_mode=setEnquirerDtls";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;		
		//eval(responseText);
		//alert(parent.parent.frames[1].name)
		parent.parent.frames[2].location.href="../../ePH/jsp/PhDrugInfoFrames.jsp?function_id="+function_id+"&Enq_num="+enq_num+"&mode=MODE_INSERT";//Changed frames 1 to 2 for Bru-HIMS-CRF-078 [IN:045032] 
	}
}

function callNext(from,to,enq_date_from,enq_date_to,respond_date_from,respond_date_to,source,designation,priority,request_mode,response,verify,Enq_num,req_catg){
	parent.f_detail.location.href="../../ePH/jsp/PhDrugInfoQueryResult.jsp?enq_date_from="+enq_date_from+"&enq_date_to="+enq_date_to+"&respond_date_from="+respond_date_from+"&respond_date_to="+respond_date_to+"&source="+source+"&designation="+designation+"&priority="+priority+"&request_mode="+request_mode+"&response="+response+"&verify_yn="+verify+"&Enq_num="+Enq_num+"&req_catg="+req_catg+"&from="+from+"&to="+to;
}

function CheckZero(Obj){
	var a=0;
	var b=00;
	var c=000;
	if(Obj.value!=''){
		if(Obj.value==a || Obj.value==b || Obj.value==c){
			alert(getMessage("PH_DRUG_INFO_TRN4","PH"));
			Obj.value='';
			Obj.focus();
			return true;
		}
		}
}

function validmaxlength(obj){	
		field_label = getLabel("verify_remarks","PH");
	if(!CheckMaxLen(field_label,obj,1000, parent.messageFrame)){
		obj.select();
		obj.focus();
	}
}
	
function openQuickLinkWindow(obj){ //Added New Method for  Bru-HIMS-CRF-078 [IN:029944] - Start
	var link_val=obj.value;
	var arr_param = new Array();
	if (link_val != undefined) {
		if (link_val.indexOf("http://") != -1) {
			link_val = link_val.replace(link_val.substring(0,
			link_val.indexOf("http://")), "");
		}
		/*if (link_val.indexOf(".com") != -1) {//commented for ml-mmoh-scf-2236  
			link_val = link_val.replace(link_val.substring(
			link_val.indexOf(".com"), link_val.length), "");
			link_val = link_val + ".com/";
		} 
		else {
			link_val = link_val + ".com/";
		}*/
		if (link_val.indexOf("http://") == -1) {
			link_val = "http://" + link_val;
		}
		if (link_val.indexOf("https://") != -1) {
			link_val = link_val.replace(link_val.substring(0,
			link_val.indexOf("https://")), "");
			link_val = link_val.replace("https://", "");
			link_val = "https://" + link_val;
		}
		var pattern = new RegExp("^(http|https|ftp)\://([a-zA-Z0-9\.\-]+(\:[a-zA-Z0-9\.&amp;%\$\-]+)*@)*((25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])|([a-zA-Z0-9\-]+\.)*[a-zA-Z0-9\-]+\.(com|edu|gov|int|mil|net|org|biz|arpa|info|name|pro|aero|coop|museum|[a-zA-Z]{2}))(\:[0-9]+)*(/($|[a-zA-Z0-9\.\,\?\'\\\+&amp;%\$#\=~_\-]+))*$");
		if (pattern.test(link_val)) {
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";//Added for [IN:045586]-Error message not cleared.
			window.open(link_val,null,"height=570,width=1020,top=0,left=0,resizable=yes,status=yes,toolbar=yes,menubar=yes,location=yes,scrollbars=yes");
		}
		else{ 
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("PH_NOT_VALID_URL","PH");
		}
	}
} //Added New Method for  Bru-HIMS-CRF-078 [IN:029944] - End
