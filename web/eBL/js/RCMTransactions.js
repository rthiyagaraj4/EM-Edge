function loadPolicyDetails(tr1,rowNo)
{
	var frm = parent.frames[1].document;
	var prevClicked = document.forms[0].prevClicked.value;
	var rowClicked = document.forms[0].rowClicked.value;
	
	var facility_id = frm.getElementById("facility_id").value;
	var appr_doc_ref_num = frm.getElementById("apprDocRefNum_"+rowNo).value;
	
	var billDocTypeCode	= frm.getElementById("billDocTypeCode_"+rowNo).value;
	var billNum	= frm.getElementById("billNum_"+rowNo).value;
	var claimId	= frm.getElementById("claimID_"+rowNo).value;
	var insuranceStatus = frm.getElementById("claimStatus_"+rowNo).value;
	var claims_services_level = frm.getElementById("claimsServicesLevel_"+rowNo).value;
	
	if(prevClicked == 'Y'){
		if(rowClicked != rowNo){				
				document.forms[0].rowClicked.value = rowNo;

				for(var i=1;i<15;i++){
					document.getElementById('td_'+rowClicked+'_'+i).className =  "fields";
				}
	
				for(var i=1;i<15;i++){
					document.getElementById('td_'+rowNo+'_'+i).className =  "YELLOW";
					//document.getElementById('td_'+rowNo+'_'+i).style.background =  "YELLOW";
					//document.getElementById('td_'+rowNo+'_'+i).style.color =  "BLACK";
				}				
				document.forms[0].prevClicked.value = 'Y';
				parent.BLRCMTransGenerateServiceResult.document.location.href = "../../eBL/jsp/BLRCMTransGenerateServiceResult.jsp?facility_id="+facility_id+"&appr_doc_ref_num="+appr_doc_ref_num+"&billDocTypeCode="+billDocTypeCode+"&billNum="+billNum+"&claimId="+claimId+"&insuranceStatus="+insuranceStatus+"&claims_services_level="+claims_services_level;
					
		}
		
	}
	else if(prevClicked == 'N'){
			document.forms[0].prevClicked.value = 'Y';
			document.forms[0].rowClicked.value = rowNo;

			for(var i=1;i<15;i++){
					document.getElementById('td_'+rowNo+'_'+i).className =  "YELLOW";
					//document.getElementById('td_'+rowNo+'_'+i).style.background =  "YELLOW";
					//document.getElementById('td_'+rowNo+'_'+i).style.color =  "BLACK";	
				}
			parent.BLRCMTransGenerateServiceResult.document.location.href = "../../eBL/jsp/BLRCMTransGenerateServiceResult.jsp?facility_id="+facility_id+"&appr_doc_ref_num="+appr_doc_ref_num+"&billDocTypeCode="+billDocTypeCode+"&billNum="+billNum+"&claimId="+claimId+"&insuranceStatus="+insuranceStatus;
				
	}
	
		document.forms[0].rowClicked.value = rowNo;
}

function payerCheck(obj){
	
	var ele=document.getElementById("appr_tot_rec").value;  
	var flag = 0;

	if(obj.checked){
		for(var i=1;i<=ele;i++){
			if(!document.getElementById("check_payer"+i).disabled)
				document.getElementById("check_payer"+i).checked = true;
		}	
	}else{
		for(var i=1;i<=ele;i++){
			if(!document.getElementById("check_payer"+i).disabled)
				document.getElementById("check_payer"+i).checked = false;
		}
	}
}

function checkBoxEnableDisable(obj){
	var ele=document.getElementById("appr_tot_rec").value; 
	var bill_cnt = document.getElementById("bill_tot_rec").value; 
	var appr_Num;
	var apprDocRefNum;
	var claim_status;
	var flag;
	for(var i=1;i<=ele;i++)
	{
		flag = 1;
		appr_Num = document.getElementById("appr_Num_"+i).value;
		for(var j=0;j<bill_cnt;j++){
			apprDocRefNum = document.getElementById("apprDocRefNum_"+j).value;
			if(appr_Num == apprDocRefNum){
				claim_status = document.getElementById("claimStatus_"+j).value;
				if(claim_status=='P' || claim_status=='C')
					flag=0;
			}
			
		}
		if(flag==1)
			document.getElementById("check_payer"+i).disabled = true;
		
	}
		
}

function check_payer(ind){
	
	var flag = 0;
	
	var ele=document.getElementById("appr_tot_rec").value; 
	for(var i=1;i<=ele;i++)
	{
		if(!document.getElementById("check_payer"+i).checked && !document.getElementById("check_payer"+i).disabled){
			flag = 1;
		}
	}
	
	if(flag==0)
		document.getElementById("checkheader").checked = true;
	else
		document.getElementById("checkheader").checked = false;
	
}





function saveUserData(){
    var frm =  parent.frames[1].document.forms[0];  
	var frmObj = parent.frames[1].document;
	var bill_total_cnt = frm.bill_tot_rec.value; 
	var appr_total_cnt = frm.appr_tot_rec.value;
	var called_from_dashboard_YN = frmObj.getElementById("called_from_dashboard_YN").value;
	var params = frmObj.getElementById("qry_search_params").value;
	var filePath = frmObj.getElementById("filePath").value;
	document.getElementById('send_to_insurance').disabled=true; 
	var claimStatus = "";
	var checkStatus = "";
	var appr_no = "", appr_ref_no = "";
	
	for(var i = 1; i <= appr_total_cnt; i++ ){
		if(frmObj.getElementById("check_payer"+i).checked){
			
			checkStatus = "Y";
			
			appr_no = frmObj.getElementById("appr_Num_"+i).value;
			for(var j = 0; j < bill_total_cnt; j++ ){
				appr_ref_no = frmObj.getElementById("apprDocRefNum_"+j).value;
				if(appr_no == appr_ref_no){
					frmObj.getElementById("checkedStatus_"+j).value = "Y";
				}
			}
		}
	}
	
	if(checkStatus != "Y"){
		alert(getMessage("ATLEAST_ONE_SELECTED","common"));
		document.getElementById('send_to_insurance').disabled=false; 
		return;
	}		
			
	xmlString = formXMLStringMain(frm);
	updation = formValidation(xmlString);
	if(updation == true)
	{
		frm.target = 'messageFrame';
		frm.method = "post";
		frm.action = "../../servlet/eBL.BLRCMTransactionsServlet?called_from_dashboard_YN=" + called_from_dashboard_YN+"&filePath="+filePath+"&"+params;
		frm.submit();                                                                                                         
	}
}

function generateExcel(ev){
	/*var totalRecords = parent.frames[2].document.getElementById('rowCount').value;
	if(totalRecords == 0){
		alert("No records to Export");
		return false;
	}*/
	var frm =  parent.frames[3].document.forms[0]; 

	frm.p_action_id.value = ev;
	frm.target = 'messageFrame';
	frm.method = 'post';
	frm.action = "../../servlet/eBL.BLRCMTransactionsServlet";
	frm.submit();
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
	
	var temp_jsp = "../../eBL/jsp/RCMTransactionsPersistance.jsp";
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


function callRemarkPopup(bill_doc_type_code, bill_doc_num, appr_doc_ref_num, called_from,blng_serv_code){
	var retVal = new String();
	var dialogHeight= "25" ;
	var dialogWidth	= "60" ;
	var dialogTop = "150" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop :" + dialogTop +"; status=no";
	var arguments			= "" ;
	var message				= "" ;

	//var title = getLabel("eBL.Remarks.label","BL"); 
	var title = "Expanded Remarks";
	var param = "title="+title+"&bill_doc_type_code="+bill_doc_type_code+"&bill_doc_num="+bill_doc_num+"&appr_doc_ref_num="+appr_doc_ref_num+"&called_from="+called_from+"&blng_serv_code="+blng_serv_code;
	
	var retVal=window.showModalDialog("../../eBL/jsp/BLRCMTransRemarksPage.jsp?"+param,arguments,features); 
}


//
function getFileType(ind){
	 //var myFSO = new ActiveXObject("Scripting.FileSystemObject");
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
    	 alert("Only pdf/jpeg files are allowed!");
		//alert(getMessage("BL0991", 'BLEXT'));
    	 return false;
     }
}

function getSize(ind){
	//alert("inside getsize ")
	 //var myFSO = new ActiveXObject("Scripting.FileSystemObject");
	 var myFSO = '';
     var file = document.getElementById("patFile_"+ind).value;
    var filename;
	       //TO DO
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
	var apprDocRefNum = "",billDocTypeCode = "",billNum = "";
	
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
			document.getElementById("DocUplYN"+ind).value="Y";
			apprDocRefNum = document.getElementById("apprDocRefNum_"+ind).value;
			apprDocRefNum=apprDocRefNum.replace("/", "_");
			billDocTypeCode = document.getElementById("billDocTypeCode_"+ind).value;
			billNum = document.getElementById("billNum_"+ind).value;
			
			document.getElementById("fileName_"+ind).value=apprDocRefNum+"_"+billDocTypeCode+"_"+billNum+"."+uploadFileType;;
		//	alert("filename is: "+document.getElementById("fileName_"+ind).value);	
		//	document.getElementById('docCnt').value="1";
			return true;
		}
		else
		{
			document.getElementById("DocUplYN"+ind).value="N";
			document.getElementById("fileName_"+ind).value = "";
			alert("Please upload PDF/JPEG Files Only");
			//alert(getMessage("BL0991", 'BLEXT'));
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

function reset(){
	frames[0].location.reload();
	frames[1].location.reload();
	frames[2].location.href = "../../eCommon/jsp/error.jsp";
}
