function reset(){	
	frames[0].location.reload();
	frames[1].location.reload();
	frames[2].location.href = "../../eCommon/jsp/error.jsp";
}

function patientIdLookup()
{	
	var pat_id=PatientSearch();		
	if( pat_id != null )						
	document.getElementById('patient_id').value = pat_id ;
	if(pat_id!=undefined && pat_id!='')
	{
		LoadPatientName(pat_id);
		ChangeUpperCase(document.getElementById('patient_name'));
	}
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

function LoadPatientName(pat_id)
{
	var out;
	var response;
	var xmlhttp;    
	if (window.XMLHttpRequest) 
	{// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	}
	else
	{// code for IE6, IE5
		//xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
			xmlHttp = new XMLHttpRequest();
	}
		xmlhttp.onreadystatechange=function()
	{
	if (xmlhttp.readyState==4 && xmlhttp.status==200)
	{
		out = xmlhttp.responseText;
		var showdata = out.substring(out.indexOf("!")+1,out.length);
		response=showdata.split(":");
		var actual;
		//alert(response);
	for(var i=0;i<response.length;i++)
	{
		document.getElementById("patient_name").value = response[i];
	}
		ChangeUpperCase(document.getElementById('patient_name'));
	}
	}
		xmlhttp.open("POST","../../eBL/jsp/BillingRecordApprovalGetPatienName.jsp?patientId="+pat_id,true);
		xmlhttp.send(null);
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

function compareDates(startDate, endDate) {
    var starr = startDate.value.split("/");
    var enarr = endDate.value.split("/");
	
	var startdt = new Date();
    var enddt = new Date();
	startdt.setFullYear(starr[2], starr[1] - 1, starr[0]);
    enddt.setFullYear(enarr[2], enarr[1] - 1, enarr[0]);
	
	if(startDate.value == ""){
		alert(getMessage('BL8504', 'BL'));
        endDate.value = '';
		return false;
	}
	
	if (startDate.value.length > 0 && endDate.value.length > 0) {
        if(startdt > enddt) {
            alert(getMessage('BL4115', 'BL'));
            endDate.value = '';
			return false;
        }
    }
	return true;
}

function compareCurrent_endDates(endDate){
	var starr = endDate.value.split("/");
	var currdt = new Date();
    var startdt = new Date();
	startdt.setFullYear(starr[2], starr[1] - 1, starr[0]);
	if(currdt < startdt){
		alert(getMessage('BL0966', 'BLEXT')); 
		endDate.value = '';
		return false;
	}
}

function encFromDateValidation(obj, startDt, endDt){
	var locale = document.forms[0].locale.value; 
	if(obj.value != "") {
		var valid_status = validDateObj(obj,"DMY",locale);
		
		if(!isBeforeNow(obj.value,'DMY',locale)){
			alert(getMessage("FROM_DT_NGE_CURR_DATE","SM"));
			obj.value='';
			valid_status =  false;
		}else{
			valid_status = true;
		}
		
		if(valid_status == true || valid_status == "true"){
			valid_status = compareDates(startDt, endDt);
		}
	}
}

function encToDateValidation(obj, startDt, endDt ){
	var locale = document.forms[0].locale.value;
	if(obj.value != "") {	
		var valid_status = validDateObj(obj,"DMY",locale);
		if(valid_status == true){
			valid_status = compareDates(startDt, endDt)
		}	
		
		if(valid_status == true || valid_status == "true"){
			var dateDif = dateDiff(startDt.value, endDt.value);
			//alert(dateDif);
			var actualDays = 30;
			if(dateDif > actualDays){
				alert(getMessage("BL0939",'BLEXT'));
				endDt.value = '';
				return false;
			}
		}
	}
}

function showCalendarLocal(fromTo, obj) {
    if (fromTo == 1) {
        return showCalendar('effFrom_' + obj)
    } else if (fromTo == 2) {
        return showCalendar('effTo_' + obj)
    }
}
function dateDiff(fromDate, toDate){
	var starr = fromDate.split("/");
	var enarr = toDate.split("/");
	var startdt = new Date();
	var enddt = new Date();
	startdt.setFullYear(starr[2], starr[1]-1, starr[0]);
	enddt.setFullYear(enarr[2], enarr[1]-1, enarr[0]);
	var timeDiff;
	var daysDiff;

	timeDiff = enddt.getTime() - startdt.getTime();
	daysDiff =  Math.floor(timeDiff / (1000 * 60 * 60 * 24));
			
	return daysDiff;
}
function mandateNonMandatePolledDate(Obj){

	var patient_id = parent.frames[0].document.getElementById("patient_id").value;
	var nationalId = parent.frames[0].document.getElementById("nationalId").value;	
	var iqamaId = parent.frames[0].document.getElementById("iqamaId").value;
	var todaysDate = parent.frames[0].document.getElementById("todaysDate").value;		
	var todaysDate30 = parent.frames[0].document.getElementById("todaysDate30").value;		
	var polled_from_date = parent.frames[0].document.getElementById("polled_from_date").value;		
	var polled_to_date = parent.frames[0].document.getElementById("polled_to_date").value;	
	if(patient_id == "" && nationalId == "" && iqamaId == ""){
		polled_from_date.value = todaysDate30;
		polled_to_date.value = todaysDate;
		$('.mandHide').show();  		
	}else{
		polled_from_date.value = todaysDate30;
		polled_to_date.value = todaysDate;
		$('.mandHide').hide();
	}
	
}
function callResultFrame(){	

	parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	parent.frames[1].location.href='../../eCommon/html/blank.html';
	parent.frames[2].location.href='../../eCommon/html/blank.html';
	
	//alert("In callResultFrame ----------");
	var patient_id = parent.frames[0].document.getElementById("patient_id").value;
	var nationalId = parent.frames[0].document.getElementById("nationalId").value;			
	var polled_from_date = parent.frames[0].document.getElementById("polled_from_date").value		
	var polled_to_date = parent.frames[0].document.getElementById("polled_to_date").value	
	var polled_from_date1 = convertDate(polled_from_date,"DMY",locale,"en");	
	var polled_to_date1 = convertDate(polled_to_date,"DMY",locale,"en");
	var iqamaId = parent.frames[0].document.getElementById("iqamaId").value;	
	var locale = parent.frames[0].document.getElementById("locale").value;		
	var facility_id = parent.frames[0].document.getElementById("facility_id").value;	
	
	if(patient_id == "" && nationalId == "" && iqamaId == "") {
		if(polled_from_date1 == ''){
			alert(getMessage("BL00949","BL"));
			return false;
		}
		if(polled_to_date1 == ''){
			alert(getMessage("BL00950","BL"));
			return false;	
		}
	}
	
	//alert("Query parameters : facility_id="+facility_id+"&locale="+locale+"&patientId="+patient_id+"&polled_from_date="+polled_from_date1+"&polled_to_date="+polled_to_date1+"&nationalId="+nationalId+"&iqamaId="+iqamaId);

	parent.frames[1].location.href = "../../eBL/jsp/BLAdvancedPriorAuthPatientDetails.jsp?facility_id="+facility_id+"&locale="+locale+"&patientId="+patient_id+"&polled_from_date="+polled_from_date1+"&polled_to_date="+polled_to_date1+"&nationalId="+nationalId+"&iqamaId="+iqamaId;
	
}
function getPatientServiceDetails(obj){

	parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	parent.frames[2].location.href ='../../eCommon/html/blank.html';

	var prevClicked = parent.frames[1].document.getElementById('prevClicked').value;
	if(prevClicked>0){	
		document.getElementById('row_'+prevClicked).className = "";
	}
	document.getElementById('row_'+obj).className = "YELLOW";
	parent.frames[1].document.getElementById('prevClicked').value = obj;
	var locale = parent.frames[1].document.getElementById("locale").value;	
	var facility_id = parent.frames[1].document.getElementById("facility_id").value;
	var patient_id = parent.frames[1].document.getElementById("patient_id_"+obj).innerText;
	var nationalId = parent.frames[1].document.getElementById("national_Id_"+obj).innerText;	
	nationalId=nationalId.replace(/^\s+|\s+$/g,"");
	var iqamaId = parent.frames[1].document.getElementById("iqama_Id_"+obj).innerText	
	iqamaId = iqamaId.replace(/^\s+|\s+$/g,"");
	var polled_from_date = parent.frames[0].document.getElementById("polled_from_date").value;
	var polled_to_date = parent.frames[0].document.getElementById("polled_to_date").value;	
	var polled_from_date1 = convertDate(polled_from_date,"DMY",locale,"en");	
	var polled_to_date1 = convertDate(polled_to_date,"DMY",locale,"en");	
	var called_from_dashboard_YN = parent.frames[1].document.getElementById("called_from_dashboard_YN").value;
	
	//alert("calling Service details facility_id="+facility_id+"&locale="+locale+"&patientId="+patient_id+"&nationalId="+nationalId+"&iqamaId="+iqamaId);
	parent.frames[2].location.href = "../../eBL/jsp/BLAdvancedPriorAuthPatientServiceDetails.jsp?facility_id="+facility_id+"&locale="+locale+"&patientId="+patient_id+"&nationalId="+nationalId+"&iqamaId="+iqamaId+"&called_from_dashboard_YN="+called_from_dashboard_YN+"&polled_from_date="+polled_from_date1+"&polled_to_date="+polled_to_date1;
}

function callRemarkPopup(request_id,seq_no){
	var retVal = new String();
	var dialogHeight= "25" ;
	var dialogWidth	= "60" ;
	var dialogTop = "150" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop :" + dialogTop +"; status=no";
	var arguments			= "" ;
	var message				= "" ;

	//var title = getLabel("eBL.Remarks.label","BL"); 
	var title = "Expanded Remarks";
	var param = "title="+title+"&request_id="+request_id+"&seq_no="+seq_no;
	var retVal=window.showModalDialog("../../eBL/jsp/BLAdvancedPriorAuthRemarksMain.jsp?"+param,arguments,features); 
}
function getFileType(ind){
	// var myFSO = new ActiveXObject("Scripting.FileSystemObject");
	var myFSO = "";
    var filepath = document.getElementById("patFile_"+ind).value;
    var filename;
	 //alert("filepath "+filepath)
	  idxDot = filepath.lastIndexOf(".") + 1,
	  extFile = filepath.substr(idxDot, filepath.length).toLowerCase();
    if (extFile=="pdf" || extFile=="jpeg"){
	   	 if(getSize(ind)){
	   		 uploadfile(ind)
	   	 }else{
	   		 return false;
	   	 }
   	// return true;
    }else{
   	 	//alert("Only pdf/jpeg files are allowed!");
		alert(getMessage("BL0917", 'BLEXT'))
   	 	return false;
    }
}

function getSize(ind){
	//alert("inside getsize ")
	 var myFSO = new ActiveXObject("Scripting.FileSystemObject");
	 var myFSO = "";
     var file = document.getElementById("patFile_"+ind).value;
     var filename;
     var thefile = myFSO.getFile(file);
     var size = thefile.size;
     var sizeInMB = (size / (1024*1024)).toFixed(2);
     //alert(sizeInMB)
     if(sizeInMB>=2){	
		//alert("Uploading File size must be less than 2MB");
		alert(getMessage("BL0990", 'BLEXT'));
		return false;
     }else{
		document.getElementById("patFile_"+ind).value=file;
		return true;
	}
}

function uploadfile(ind){
	var filePath = document.forms[0].filePath.value;
	var pathExist = document.forms[0].pathExist.value;
	var writeAccess = document.forms[0].writeAccess.value;
	//var applServerURL = document.forms[0].applServerURL.value;
	var uploadFile = document.getElementById("patFile_"+ind).value;
	var uploadFileType = uploadFile.substr(uploadFile.lastIndexOf(".")+1, uploadFile.length);
	var blng_serv_code = "",nationalId = "",iqamaId = "",request_id = "" ,seq_no = "" ;
	var sysDateTime = parent.BLAdvancedPriorAuthSearchFrame.document.getElementById("sysdate").value;
	//alert(sysDateTime);
	if(filePath==""){
		alert("Configured file path is empty");
		document.getElementById("DocUplYN"+ind).value="N";
		return false;
	}
	else if(pathExist=="false"){
		alert("Configured file path - '"+filePath+"' does not exist");
		document.getElementById("DocUplYN"+ind).value="N";
		return false;
	}
	else if(writeAccess=="false"){
		alert("Configured file path - '"+filePath+"' does not have write access");
		document.getElementById("DocUplYN"+ind).value="N";
		return false;
	}
	else{
		if(uploadFile != '' )
		{
			if(uploadFileType.toUpperCase() == 'PDF' || uploadFileType.toUpperCase() == 'JPEG' )
			{	
				blng_serv_code = document.getElementById("blng_serv_code_"+ind).value;
				request_id = document.getElementById("request_id_"+ind).value;
				seq_no = document.getElementById("seq_no_"+ind).value;
				nationalId = document.getElementById("nationalId").value;
				iqamaId = document.getElementById("iqamaId").value;
				if(nationalId != null && nationalId != ""){
					document.getElementById("fileName_"+ind).value = "APA_"+nationalId+"_"+blng_serv_code+"_"+request_id+"_"+seq_no+"."+uploadFileType;
				}else if(iqamaId != null && iqamaId != ""){
					document.getElementById("fileName_"+ind).value = "APA_"+iqamaId+"_"+blng_serv_code+"_"+request_id+"_"+seq_no+"."+uploadFileType;
				}
				document.getElementById("DocUplYN"+ind).value="Y";
				return true;
			}
			else
			{
				document.getElementById("DocUplYN"+ind).value="N";
				document.getElementById("fileName_"+ind).value = "";
				//alert("Please upload PDF/JPEG Files Only");
				alert(getMessage("BL0917", 'BLEXT'));
				return false;
			}
		}
	else
		{
			//alert(getCAMessage("FILE_TYPE_NOT_ALLOWED"))//Sanjay
			document.getElementById("DocUplYN"+ind).value="N";
			document.getElementById("fileName_"+ind).value = "";
			alert("Uploaded file path cannot be empty");
			return false;
		}
	}
}

function apply(){
	var err_mess="";
	var msgFrame = parent.frames[2].messageFrame; 
	if(frames[1].frames[2].BLAdvancedPriorAuthPatientServiceDetailForm != undefined){
		var frm =  frames[1].frames[2].BLAdvancedPriorAuthPatientServiceDetailForm;
		var frmObj = frames[1].frames[2].BLAdvancedPriorAuthPatientServiceDetailForm.document;
		var called_from_dashboard_YN = frmObj.getElementById("called_from_dashboard_YN").value;
		var nationalId = frmObj.getElementById("nationalId").value;
		var iqamaId = frmObj.getElementById("iqamaId").value;
		var patientId = frmObj.getElementById("patient_id").value;
		var params = "";
		var filePath = frmObj.getElementById("filePath").value;
		var claimStatus = "";
		var checkStatus = "";
		var selectedRecCount = 0, clarificationRecCount = 0;
		var appr_no = "", appr_ref_no = "";
		var totalServices = frmObj.getElementById("totalServices").value;
		
		for(var i = 1; i <= totalServices; i++ ){
			var claimStatus = frmObj.getElementById("pre_app_status_"+i).value;
			
			if(claimStatus == "C"){
				clarificationRecCount = clarificationRecCount + 1;
				if(frmObj.getElementById("check_service_"+i).checked){
					selectedRecCount = selectedRecCount + 1;
					frmObj.getElementById("check_service_"+i).value = "Y";
				} else {
					frmObj.getElementById("check_service_"+i).value = "N";
				}
			}
		}

		if(clarificationRecCount > 0 && selectedRecCount == 0){
			err_mess = getMessage("ATLEAST_ONE_SELECTED","common");
			msgFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+ err_mess;
			return false;
		}
		
		for(var i = 1; i <= totalServices; i++ ){
			if(!(frmObj.getElementById("check_service_"+i).disabled) && frmObj.getElementById("check_service_"+i).checked && frmObj.getElementById("fileName_"+i).value == ""){
				err_mess = getMessage("BL0992", "BLEXT");
				msgFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+ err_mess;
				frmObj.getElementById("patFile_"+i).focus();
				return false;
			}
		}		
				
		xmlString = formXMLStringMain(frm);
		updation = formValidation(xmlString);
		if(updation == true)
		{
			var params="patientId="+patientId+"&nationalId="+nationalId+"&iqamaId="+iqamaId;
			frm.target = 'messageFrame';
			frm.method = "post";
			frm.action = "../../servlet/eBL.BLAdvancedPriorAuthServlet?called_from_dashboard_YN=" + called_from_dashboard_YN+"&filePath="+filePath+"&"+params;
			frm.submit();                                                                                                         
		}
	}else{
		msgFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+ err_mess;
		return false;
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
			}else if(arrObj[i].type == "label"){
				val = arrObj[i].innerText;
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
	
	var temp_jsp = "../../eBL/jsp/BLAdvancedPriorAuthPersistance.jsp";
    if (event != null && event == "delete")
        temp_jsp = "../../eBL/jsp/RCMTransactionsPersistance.jsp?event=" + event;

    var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
   
    xmlHttp.open("POST", temp_jsp, false);
    xmlHttp.send(xmlDoc);
    
    var responseText = xmlHttp.responseText;
	eval(responseText);
    return true;
}

function checkAllService(obj){
	var rowCount = document.getElementById("totalServices").value;  
	if(obj.checked){
		for(var i=1;i<=rowCount;i++){
			if(!document.getElementById("check_service_"+i).disabled)
				document.getElementById("check_service_"+i).checked = true;
		}	
	}else{
		for(var i=1;i<=rowCount;i++){
			if(!document.getElementById("check_service_"+i).disabled)
				document.getElementById("check_service_"+i).checked = false;
		}
	}
}


