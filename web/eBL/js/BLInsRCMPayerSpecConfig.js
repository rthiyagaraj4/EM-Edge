


function create() {
	
    BLInsRCMPayerSpecSupDocConfigMain.location.href = "../../eBL/jsp/BLInsRCMPayerSpecSupDocConfigMainFrame.jsp?mode=insert";

}

function reset() {
   
    BLInsRCMPayerSpecSupDocConfigMain.location.reload();	
}

function query() {
    commontoolbarFrame.document.forms[0].apply.disabled = true;
    BLInsRCMPayerSpecSupDocConfigMain.location.href = "../../eBL/jsp/BLInsRCMPayerSpecSupDocConfigQueryCriteria.jsp";
}

function onSuccess() {
    BLInsRCMPayerSpecSupDocConfigMain.location.href = "../../eBL/jsp/BLInsRCMPayerSpecSupDocConfigMainFrame.jsp?mode=insert";
}



function DeleteRow(button) {
	var parts= button.name.split("_");
	var index =parts[1];
	
	var pdoc=parent.PayerSpecDocsFrame.document.forms[0];
	var mode=pdoc.parentNode.document.getElementById('mode').value;
	var payerGroup=pdoc.parentNode.document.getElementById('payerGroup').value;
	var payer=pdoc.parentNode.document.getElementById('payer').value;
	var policy=pdoc.parentNode.document.getElementById('policy').value;
	
	
    var row = button.parentNode.parentNode; // Get the parent row
	
	if(mode=="modify"){
			
			var xmlStr = "<root><SEARCH ";
            xmlStr += " /></root>";
            var temp_jsp = "../../eBL/jsp/BLInsRCMPayerSpecSupDocConfigPersistence.jsp?func_mode=deleteRow&reportId="+document.getElementById("reportId_"+index).value+"&payerGroup="+payerGroup+"&payer="+payer+"&policy="+policy;
			  
            var xmlDoc="";
            var xmlHttp = new XMLHttpRequest();
			
			
            xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
            xmlHttp.open("POST", temp_jsp, false);
			
            xmlHttp.send(xmlDoc);
			
            var responseText = trimString(xmlHttp.responseText);
						
    
	}
	row.parentNode.removeChild(row); // Remove the row
	var l=Number(pdoc.parentNode.document.getElementById('docRowCount').value);
	l--;
	pdoc.parentNode.document.getElementById('docRowCount').value=l;
}


function checkSequence(obj) {
    var pdoc = parent.PayerSpecDocsFrame.document.forms[0];
    var tbl = pdoc.parentNode.document.getElementById('docTableFrm');
    var inputs = tbl.getElementsByTagName('input');
    var objValue = obj.value;

    // Check if the sequence is less than 1
    if (objValue == 0 && objValue != "") {
        alert("Sequence can't be less than 1");
        obj.value = '';
        obj.select();
        return;
    }

    // Loop through all input elements and check for duplicate sequences
    for (var i = 0; i < inputs.length; i++) {
        var input = inputs[i];

        // Check if it's a sequence input and not the current input
        if (input.type === 'text' && input !== obj && input.value !== '') {
            if (input.value === objValue) {
                alert("Sequence can't be duplicated");
                obj.value = '';
                obj.select();
                return;
            }
        }
    }
}


function clearField(obj){
	obj.value = '';
}

function changeAll(obj){
	
	
	var parts= obj.name.split("_");
	var index =parts[1];
	if(obj.value=="N" || obj.value=="" || obj.value==null){
		document.getElementById('all_'+index).value='Y';
		document.getElementById('all_'+index).checked=true;
		document.getElementById('appl_ip_'+index).value='Y';
		document.getElementById('appl_ip_'+index).checked=true;

		document.getElementById('appl_op_'+index).value='Y';
		document.getElementById('appl_op_'+index).checked=true;
		
		document.getElementById('appl_dc_'+index).value='Y';
		document.getElementById('appl_dc_'+index).checked=true;
		
		document.getElementById('appl_em_'+index).value='Y';
		document.getElementById('appl_em_'+index).checked=true;
	}else{
		document.getElementById('all_'+index).value='N';
		document.getElementById('all_'+index).checked=false;
		document.getElementById('appl_ip_'+index).value='N';
		document.getElementById('appl_ip_'+index).checked=false;

		document.getElementById('appl_op_'+index).value='N';
		document.getElementById('appl_op_'+index).checked=false;
		
		document.getElementById('appl_dc_'+index).value='N';
		document.getElementById('appl_dc_'+index).checked=false;
		
		document.getElementById('appl_em_'+index).value='N';
		document.getElementById('appl_em_'+index).checked=false;
	}
	
	
}
function AddRow(){
	var pdoc=parent.PayerSpecDocsFrame.document.forms[0];

	var tbl = pdoc.parentNode.document.getElementById('tblDocDetails');
	
	var d=frmAddBtn.parentNode.document.getElementById('docName').value;
	var dId=frmAddBtn.parentNode.document.getElementById('docID').value;
	
	
	var index = tbl.rows.length-1;
	var prevIndex = index - 1;
	
	if(d.length<1){
		alert(getMessage("BL00727", "BL"));
		return false;
	}
	
	
	for(var i=0;i<index;i++){
		if(pdoc.document.getElementById("reportId_"+i)!==null){

			
			if(dId===pdoc.document.getElementById("reportId_"+i).value){
				
					alert(getMessage("BL00726", "BL"));
					frmAddBtn.parentNode.document.getElementById('docName').value='';
					return false;
			}
		}
		
		
	}
	row="reportId_"+index;
	if(pdoc.document.getElementById(row)!==null){
		index=0;
		while(pdoc.document.getElementById(row)!==null){
			index++;
			row="reportId_"+index;
		}
				
	}
	
	

	var allLabel=getLabel('Common.all.label','common');
	var ipLabel=getLabel('Common.IP.label','common');
	var dcLabel=getLabel('Common.DC.label','common'); 
	var opLabel=getLabel('Common.OP.label','common');
	var emLabel=getLabel('Common.EM.label','common');
	
	
	
	if(dId!=""){
	
		var newRow = tbl.insertRow();
		var newCell = newRow.insertCell(0);	
		newCell.innerHTML = "<td class='fields'>"+
		"<p  name='reportDesc_"+index+"' id='reportDesc_"+index+"'>"+d+"</p> " +
		"<input type='hidden' name='reportId_"+index+"' id='reportId_"+index+"' value='"+dId+"'>" +
		"<input type ='hidden' name='reportName_"+index+"' id='reportName_"+index+"' value='"+d+"'>" 
		+" </td>"
		newCell.className =  'fields';
		
		
		newCell = newRow.insertCell(1);	
		newCell.innerHTML = "<td class='fields'>"+
		"<input type='input' name='reportSeq_"+index+"' maxlength='3' id='reportSeq_"+index+"' onKeyPress='return CheckForNumbers(event)' onblur='checkSequence(this);checkNumberonBlur(this);' />"
		
		"</td> ";
		newCell.className =  'fields';
		
		newCell = newRow.insertCell(2);	
		newCell.innerHTML = "<td class='fields'>"+
		"<img src='../../eCommon/images/MarkError.gif' name='deleteBtn_"+index+"' onClick='DeleteRow(this)' id='deleteBtn_"+index+"'  />"+

		
		"</td> ";
		newCell.className =  'fields';
		newCell.style.textAlign='center';
		
		newCell = newRow.insertCell(3);	
		newCell.innerHTML = "<td class='fields'>"+
		allLabel+"  <input type='checkbox' name='all_"+index+"' id='all_"+index+"' value='N' onClick='changeAll(this);'>  &nbsp; "+
		ipLabel+"  <input type='checkbox' name='appl_ip_"+index+"' id='appl_ip_"+index+"' value='N' onClick='check(this);'>  &nbsp; "+
		dcLabel+"  <input type='checkbox' name='appl_dc_"+index+"' id='appl_dc_"+index+"' value='N' onClick='check(this);'>  &nbsp; "+
		opLabel+"  <input type='checkbox' name='appl_op_"+index+"' id='appl_op_"+index+"' value='N' onClick='check(this);'>  &nbsp; "+
		emLabel+"  <input type='checkbox' name='appl_em_"+index+"' id='appl_em_"+index+"' value='N' onClick='check(this);'>  &nbsp; "+
		"</td> ";
		newCell.className ='fields';
		newCell.style.textAlign='center';
		
		var l=Number(pdoc.parentNode.document.getElementById('docRowCount').value);
		l++;
		pdoc.parentNode.document.getElementById('docRowCount').value=l;
		
		frmAddBtn.parentNode.document.getElementById('docName').value='';
	}

	
	
	
}


function check(obj){
	
	var parts= obj.name.split("_");
	var index =parts[2];
	
	if(obj.value==='N'){obj.value='Y'}
	else{obj.value='N'}
	
	if(document.getElementById("appl_ip_"+index).value=='N' || document.getElementById("appl_em_"+index).value=='N' || document.getElementById("appl_dc_"+index).value=='N' || document.getElementById("appl_op_"+index).value=='N'){
		document.getElementById('all_'+index).value='N';
		document.getElementById('all_'+index).checked=false;
	}
	
	if(document.getElementById("appl_ip_"+index).value=='Y' && document.getElementById("appl_em_"+index).value=='Y' && document.getElementById("appl_dc_"+index).value=='Y' && document.getElementById("appl_op_"+index).value=='Y'){
		document.getElementById('all_'+index).value='Y';
		document.getElementById('all_'+index).checked=true;
	}
}


function checkNumberonBlur(obj){
	
              if(isNaN(obj.value)){
                             alert(getMessage('BL8532','BL'));
							 obj.value='';
                             obj.select();
              }
}


function apply() {

	
	messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp";
	var mainfrmObj                  = "";
	mainfrmObj                      = BLInsRCMPayerSpecSupDocConfigMain.PayerSpecInfoFrame.document.forms[0];  // contain LOV 
	var mode                        = mainfrmObj.mode.value;
	var loginUser                   = mainfrmObj.login_user.value;
	var ws_no                       = mainfrmObj.ws_no.value;
		
	var fieldsTop   = new Array(mainfrmObj.payerCode2,mainfrmObj.payerCode);
	var payerLbl    = getLabel("eBL.PAYER.label", "bl");
    var payerGrpLbl = getLabel("eBL.PAYER_GROUP.label", "bl");
    
    var proceed = false ;
	
	var namesTop    = new Array(payerGrpLbl,payerLbl);
	
	var msgFrame    = messageFrame;



    if (!(checkFieldsofMst(fieldsTop, namesTop, msgFrame))) {
        return false; 
    } else {
        if (mainfrmObj.policyTypeCode.value === "") {
            mainfrmObj.policyTypeCode.value = "**";
            if (validateCombination(mainfrmObj.payerCode2, mainfrmObj.payerCode, mainfrmObj.policyTypeCode, mainfrmObj)) {            
                commontoolbarFrame.location.reload();
                return false;                    
            }        
        }
    } 
  
    var framTab  = BLInsRCMPayerSpecSupDocConfigMain.viewOfTabFrame;

	var from_tab = framTab.document.getElementById('from_tab').value;
	if(from_tab =='general'){
		 var newBornLimit      = framTab.document.forms[0].new_born_limit.value;
		 if(newBornLimit == "" || newBornLimit == null){
			 alert("New Porn Limit can not be Empty !");
			 commontoolbarFrame.location.reload();
	         return false;
		 }
		
		 var msgFrame              = framTab.document.forms[0];
		 var xmlString             = formXMLStringMain(msgFrame);
	     var updation              = formValidation(xmlString, "generalFrame");		
	     proceed = true ; 
	}	
	if(from_tab =='supporting'){
		var obj = BLInsRCMPayerSpecSupDocConfigMain.viewOfTabFrame;
	     if(validationForDocAddingFrame(obj)){
	  
	    	 var msgFrame          = BLInsRCMPayerSpecSupDocConfigMain.viewOfTabFrame.PayerSpecConfiguration.document.forms[0];
			 var xmlString         = formXMLStringMain(msgFrame);
		     var updation          = formValidation(xmlString, "supportDocConfigVar");
		     
		     var msgFrame          = BLInsRCMPayerSpecSupDocConfigMain.viewOfTabFrame.PayerSpecDocsFrame.document.forms[0];
			 var xmlString         = formXMLStringMain(msgFrame);
		     var updation          = formValidation(xmlString, "docsInfo");
		     proceed = true ; 
	        }else{
                commontoolbarFrame.location.reload();
	        	return false;
	        }
	     
	}
	if(from_tab == 'validations'){
	 	var validationFrame = BLInsRCMPayerSpecSupDocConfigMain.viewOfTabFrame.PayerSpecValidationParam.document.forms[0];  
		var xmlString       = formXMLStringMain(validationFrame);
		var updation        = formValidation(xmlString, 'validationsParam');
		
		var validationFrame = BLInsRCMPayerSpecSupDocConfigMain.viewOfTabFrame.PayerSpecValidation.document.forms[0];  
		var xmlString       = formXMLStringMain(validationFrame);
		var updation        = formValidation(xmlString, 'validationsRow');

	     proceed = true ; 

	}
	
	if(from_tab == 'claimSplitting'){
		var mainfrmObj = "";
		var infofrmObj="";
		mainfrmObj = BLInsRCMPayerSpecSupDocConfigMain.viewOfTabFrame.PayerSpecClaimSplittingClaimsFrame.document.forms[0];
		infofrmObj=  BLInsRCMPayerSpecSupDocConfigMain.viewOfTabFrame.PayerSpecClaimSplittingInfoFrame.document.forms[0];
		var tbl = mainfrmObj.parentNode.document.getElementById('tblType');
		var index= (tbl.rows.length)-1;
		
		var msg_frame=messageFrame;
		if(index==0){
			messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+"APP-00001 At least one claim type should be configured";
			return;
		}else{
			var obj = BLInsRCMPayerSpecSupDocConfigMain.viewOfTabFrame;
			if(validateBeforeApply(msg_frame,"apply",obj)){
				
				var mode = mainfrmObj.mode.value;
				
				var clickedRow=mainfrmObj.parentNode.document.getElementById('rowClicked').value;
				var xmlString= formXMLStringMain(infofrmObj);
				var updation =formValidation_splitting(xmlString,"InfoFrame");
				
				xmlString = formXMLStringMain(mainfrmObj);

				updation =formValidation_splitting(xmlString,"addClaimTypes");
				
				var frmObj = "";
				frmObj = BLInsRCMPayerSpecSupDocConfigMain.viewOfTabFrame.PayerSpecClaimSplittingClassFrame.document.forms[0];
				if(clickedRow!="" && frmObj!=null){
						var claimType=mainfrmObj.parentNode.document.getElementById('claimTypeCode_'+clickedRow).value;
						var appl_all=mainfrmObj.parentNode.document.getElementById('all_'+clickedRow).value;
						var appl_ip=mainfrmObj.parentNode.document.getElementById('appl_ip_'+clickedRow).value;
						var appl_op=mainfrmObj.parentNode.document.getElementById('appl_op_'+clickedRow).value;
						var appl_dc=mainfrmObj.parentNode.document.getElementById('appl_dc_'+clickedRow).value;
						var appl_em=mainfrmObj.parentNode.document.getElementById('appl_em_'+clickedRow).value;
					
						xmlString = formXMLStringMain(frmObj);

						updation = serviceFormValidation(xmlString,"validateAndUpdateService",claimType,appl_all,appl_ip,appl_op,appl_dc,appl_em);
						
				}
				
				proceed=true;
				
			
		}
		
	}

		
}
	if(proceed){
		
	
       var	mainfrmObj    = BLInsRCMPayerSpecSupDocConfigMain.PayerSpecInfoFrame.document.forms[0];  // contain LOV 
       var xmlString      = formXMLStringMain(mainfrmObj);
       var updation       = formValidation(xmlString, "infoFrame");

	   mainfrmObj.target = 'messageFrame';
       mainfrmObj.method = "post";
       mainfrmObj.action = "../../servlet/eBL.BLInsRCMPayerSpecSupDocConfigServlet?mode=" + mode+"&loginUser="+loginUser+"&wsNo="+ws_no;
       mainfrmObj.submit();
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

function formValidation(xmlStr, last_link, event) {
    var temp_jsp = "BLInsRCMPayerSpecSupDocConfigPersistence.jsp?func_mode=" + last_link;
    var xmlDoc="";

    var xmlHttp = new XMLHttpRequest();
	
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
    xmlHttp.open("POST", temp_jsp, false);
    xmlHttp.send(xmlDoc);
	
    var responseText = xmlHttp.responseText;

    eval(responseText);
	
	
    return true;
}




function validateCombination(payerCode, payer, policy,frmObj) {
		var pg = payerCode.value;
		var p = payer.value;
		var pt =policy.value;
		
    if (pg.length > 0 && p.length > 0 &&
        pt.length > 0) {
        
       
            var xmlStr = "<root><SEARCH ";
            xmlStr += " /></root>";
            var temp_jsp = "../../eBL/jsp/BLInsRCMPayerSpecSupDocConfigPersistence.jsp?func_mode=validateCombination&payerGroup=" +
                pg +
                "&payer=" +
                p +
                "&policy=" +
                pt;
            var xmlDoc="";
            var xmlHttp = new XMLHttpRequest();
			
			
            xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
            
            xmlHttp.open("POST", temp_jsp, false);
			
            xmlHttp.send(xmlDoc);
			
            var responseText = trimString(xmlHttp.responseText);
			
            if (responseText == 'N') {
                alert("Record already exists for the selected combination");
				payerCode.value = '';
				payer.value = '';
				policy.value = '';
				
				
				if(frmObj){var frm=frmObj;}
				else{var frm = document.forms[0];}
				
				frm.payerGroup2.value = '';
				frm.payerGroup1.value = '';
				frm.policyType.value = '';
				return true;
        }
    }
}


function callCommonValidationQryCriteria(sqlSelect, obj, code) {
    var locale = document.forms[0].locale.value;
    var facility_id = document.forms[0].facility_id.value;
    var argumentArray = new Array();
    var dataNameArray = new Array();
    var dataValueArray = new Array();
    var dataTypeArray = new Array();
    var sql = '';
    var title = '';
    // alert(sqlSelect);
    switch (sqlSelect) {
        case 1:
            {
                var cust_code = document.forms[0].payerCode2.value;
                sql = "Select description,code from (Select long_name description,cust_code code from ar_customer_lang_vw " +
                "Where acc_entity_code  In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '" +
                facility_id +
                "') " +
                "and nvl(patient_flag,'N')  ='Y' " +
                "and nvl(pat_com_flag,'N')='N' " +
                "And Nvl(Insurance_Yn, 'N') = 'Y' And Status Is Null " +
                "and upper(language_id) = upper('" +
                locale +
                "') union  Select 'All Payer','**' From Dual) where upper(description) like upper(?) and upper(code) like upper(?) ";

                title = 'Payer';
                break;
            }
		case 2:
		{
			sql ="select description,code from(select long_desc description,policy_type_code code from bl_ins_policy_types_lang_vw where nvl(status,'A') !='S' and operating_facility_id = '" +
						facility_id +
						"' and upper(language_id) = upper('" +
						locale +
						"') union  Select 'All Policy','**' From Dual) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Policy';
                break;
		}

    }


    
    argumentArray[0] = sql;
    argumentArray[1] = dataNameArray;
    argumentArray[2] = dataValueArray;
    argumentArray[3] = dataTypeArray;
    argumentArray[4] = "2,1";
    argumentArray[5] = obj.value;
    argumentArray[6] = DESC_LINK;
    argumentArray[7] = DESC_CODE;

    returnedValues = CommonLookup(title, argumentArray);
    if ((returnedValues != null) && (returnedValues != "")) {
        obj.value = returnedValues[1];
        code.value = returnedValues[0];
    } else {
        obj.value = '';
        code.value = '';
     
    }
}

function callCommonValidation(sqlSelect, obj, code) {
    
	var locale = document.forms[0].locale.value;
    var facility_id = document.forms[0].facility_id.value;
	
	
	
    var argumentArray = new Array();
    var dataNameArray = new Array();
    var dataValueArray = new Array();
    var dataTypeArray = new Array();
    var sql = '';
    var title = '';

    switch (sqlSelect) {
        case 1:
            {
                sql = "select description, code  from (select short_desc description, speciality_code code from am_speciality_lang_vw where language_id = '" +
                locale +
                "' Union Select 'All Specialities','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?)  order by 2";
                title = 'Speciality';
                break;
            }
        case 2:
            {
        		var cust_code = document.forms[0].payerCode2.value;
                sql = "Select description,code from (Select long_name description,cust_code code from ar_customer_lang_vw " +
                "Where Cust_Code In ( SELECT cust_code " +
                "FROM bl_cust_by_cust_group " +
                "WHERE cust_group_code = " +
                "DECODE ('" +
                cust_code +
                "', " +
                "'**', cust_group_code, '" +
                cust_code +
                "')) " +
                "and acc_entity_code  In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '" +
                facility_id +
                "') " +
                "and nvl(patient_flag,'N')  ='Y' " +
                "and nvl(pat_com_flag,'N')='N' " +
                "And Nvl(Insurance_Yn, 'N') = 'Y' And Status Is Null " +
                "and upper(language_id) = upper('" +
                locale +
                "') union  Select 'All Payer','**' From Dual) where upper(description) like upper(?) and upper(code) like upper(?) ";

                title = 'Payer';
                break;
            }
        case 3:
            {
				
               
                sql = "select description,code from (select long_desc description, cust_group_code code from ar_cust_group_lang_vw where status is null and " +
                "cust_group_code in (Select Distinct Cust_Group_Code From Bl_Cust_By_Cust_Group Where Cust_Code In (Select Cust_Code From Ar_Customer_Lang_Vw " +
                "where acc_entity_code  in (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '" +
                facility_id +
                "') and upper(language_id) = upper('" +
                locale +
                "') " +
                "and nvl(patient_flag,'N')  ='Y' And Nvl(Insurance_Yn, 'N') = 'Y' )) " +
                "And Acc_Entity_Code In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '" +
                facility_id +
                "') and upper(language_id) = upper('" +
                locale +
                "') union Select 'All Payer Group','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) " +
                " order by 2";

                title = 'Payer Group';
                break;
            }
        case 4:
            {	
					sql ="select description,code from(select long_desc description,policy_type_code code from bl_ins_policy_types_lang_vw where nvl(status,'E') !='D' and operating_facility_id = '"+ 
					facility_id+"' and upper(language_id) = upper('"+
					locale+"') union Select 'All Policy','**' From Dual) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";//Modified against nmc-jd-crf-0059/V201027
					title = 'Policy';
                break;
            }
        case 5:
            {
                sql = "Select Description,Code from (Select Long_Desc Description, Age_Group_Code Code  From Bl_Ins_Age_Group where nvl(Status,'E') != 'D' Union Select 'All Age groups','**' From Dual) where  upper(Description) like upper(?) and upper(Code) like upper(?) ";
                title = 'Age Group';
                break;
            }
		case 6: 
			{

				sql="select Description,Code from (Select REPORT_NAME Description,REPORT_ID Code from BL_SUPPORT_DOCUMENT_LIST ) where upper(Description) like upper(?) and upper(Code) like upper(?) ";
				title = "Document";
				
				break;
				
				
				
			}

    }

    
    argumentArray[0] = sql;
    argumentArray[1] = dataNameArray;
    argumentArray[2] = dataValueArray;
    argumentArray[3] = dataTypeArray;
    argumentArray[4] = "2,1";
    argumentArray[5] = obj.value;
    argumentArray[6] = DESC_LINK;
    argumentArray[7] = DESC_CODE;

    returnedValues = CommonLookup(title, argumentArray);
    if ((returnedValues != null) && (returnedValues != "")) {
        obj.value = returnedValues[1];
        code.value = returnedValues[0];
 
    } else {
        obj.value = '';
        code.value = '';
    }

}

function callDocValidation( obj, code) {
    
	
    var facility_id = parent.parent.PayerSpecInfoFrame.document.forms[0].facility_id.value;
	
	
	if(obj.value==""){
		code.value="";
		
	}
	
    var argumentArray = new Array();
    var dataNameArray = new Array();
    var dataValueArray = new Array();
    var dataTypeArray = new Array();
    var sql = '';
    var title = '';
    sql="select Description,Code from (Select REPORT_NAME Description,REPORT_ID Code from BL_SUPPORT_DOCUMENT_LIST ) where upper(Description) like upper(?) and upper(Code) like upper(?) ";
	title = "Document";

    argumentArray[0] = sql;
    argumentArray[1] = dataNameArray;
    argumentArray[2] = dataValueArray;
    argumentArray[3] = dataTypeArray;
    argumentArray[4] = "2,1";
    argumentArray[5] = obj.value;
    argumentArray[6] = DESC_LINK;
    argumentArray[7] = DESC_CODE;

    returnedValues = CommonLookup(title, argumentArray);
    if ((returnedValues != null) && (returnedValues != "")) {
        obj.value = returnedValues[1];
        code.value = returnedValues[0];
    } else {
        obj.value = '';
        code.value = '';
       
    }

}




function checkPayerGroup(){
	
	if(frmInfo.payerGroup2.value==""){
		alert("You must select payer group first");
		frmInfo.payerGroup1.value='';
		document.getElementById('payerGroup2').focus();
		return true;
	}
	
}


function showMainTabDetails(fromTab,params){
	var from_tab = document.getElementById('from_tab').value;
	
	if(from_tab == 'general'){

		 var newBornLimit      = parent.viewOfTabFrame.document.forms[0].new_born_limit.value
		 if(newBornLimit == "" || newBornLimit == null){
			 alert("New Porn Limit can not be Empty !");
			 commontoolbarFrame.location.reload();
	         return false;
		 }
         var generalFrame      = parent.viewOfTabFrame.document.forms[0];  
		 var xmlString         = formXMLStringMain(generalFrame);
         var updation          = formValidation(xmlString, "generalFrame");
	}
	if(from_tab == 'supporting'){
		var obj = parent.viewOfTabFrame ;
        if(validationForDocAddingFrame(obj)){

			var configurationFrame = parent.viewOfTabFrame.PayerSpecConfiguration.document.forms[0];  
			var xmlString          = formXMLStringMain(configurationFrame);
	        var updation           = formValidation(xmlString, "supportDocConfigVar");
	        
	        
	        var PayerSpecDocsFrame = parent.viewOfTabFrame.PayerSpecDocsFrame.document.forms[0];  
			var xmlString          = formXMLStringMain(PayerSpecDocsFrame);
	        var updation           = formValidation(xmlString, "docsInfo");
        }
   		
	}
	
	if(from_tab == 'validations'){
		
		var validationFrame = parent.viewOfTabFrame.PayerSpecValidationParam.document.forms[0];  
		var xmlString       = formXMLStringMain(validationFrame);
		var updation        = formValidation(xmlString, 'validationsParam');
		
		var validationFrame = parent.viewOfTabFrame.PayerSpecValidation.document.forms[0];  
		var xmlString       = formXMLStringMain(validationFrame);
		var updation        = formValidation(xmlString, 'validationsRow');

	}
	if(from_tab =='claimSplitting'){
		//var validationFrame = parent.viewOfTabFrame.PayerSpecClaimSplittingInfoFrame.document.forms[0];  
		//var xmlString       = formXMLStringMain(validationFrame);
	//	var updation        = formValidation_splitting(xmlString, 'InfoFrame');
		
	//	var validationFrame = parent.viewOfTabFrame.PayerSpecClaimSplittingClaimsFrame.document.forms[0];  
	//	var xmlString       = formXMLStringMain(validationFrame);
	//	var updation        = formValidation_splitting(xmlString, 'addClaimTypes');
		
		
	//	var validationFrame = parent.viewOfTabFrame.PayerSpecClaimSplittingClassFrame.document.forms[0];  
		//var xmlString       = formXMLStringMain(validationFrame);
	//	var updation        = formValidation_splitting(xmlString, 'addClaimTypes');
		var msg_frame    ="";
		var obj = parent.viewOfTabFrame;
		if(validateBeforeApply(msg_frame,"tabs",obj)){
			var validationFrame = parent.viewOfTabFrame.PayerSpecClaimSplittingInfoFrame.document.forms[0];  
			var mode = validationFrame.mode.value;
			
			var xmlString= formXMLStringMain(validationFrame);
			var updation =formValidation_splitting(xmlString,"InfoFrame");
			
			validationFrame = parent.viewOfTabFrame.PayerSpecClaimSplittingClaimsFrame.document.forms[0];  
			var clickedRow=validationFrame.parentNode.document.getElementById('rowClicked').value;

			xmlString = formXMLStringMain(validationFrame);

			updation =formValidation_splitting(xmlString,"addClaimTypes");
			
			var frmObj = "";
			frmObj = parent.viewOfTabFrame.PayerSpecClaimSplittingClassFrame.document.forms[0];
			var mainfrmObj = parent.viewOfTabFrame.PayerSpecClaimSplittingClaimsFrame.document.forms[0];
			if(clickedRow!="" && frmObj!=null){
					var claimType=mainfrmObj.parentNode.document.getElementById('claimTypeCode_'+clickedRow).value;
					var appl_all=mainfrmObj.parentNode.document.getElementById('all_'+clickedRow).value;
					var appl_ip=mainfrmObj.parentNode.document.getElementById('appl_ip_'+clickedRow).value;
					var appl_op=mainfrmObj.parentNode.document.getElementById('appl_op_'+clickedRow).value;
					var appl_dc=mainfrmObj.parentNode.document.getElementById('appl_dc_'+clickedRow).value;
					var appl_em=mainfrmObj.parentNode.document.getElementById('appl_em_'+clickedRow).value;
				
					xmlString = formXMLStringMain(frmObj);
					updation = serviceFormValidation(xmlString,"validateAndUpdateService",claimType,appl_all,appl_ip,appl_op,appl_dc,appl_em);
					
			}
			
		
	}
		
	}
	
	if(fromTab=="general_tab"){ 
		
		document.getElementById('from_tab').value = 'general';
		
		
		document.getElementById('supportDoc_tab').className = "tabA";
		document.getElementById('supportDoc_tab_span').className = "tabAspan";
		
		
		
		
		document.getElementById('validation_tab').className = "tabA";
		document.getElementById('validation_tab_span').className = "tabAspan";
		

		document.getElementById('claimSplit_tab').className = "tabA";
		document.getElementById('claimSplit_tab_span').className = "tabAspan";

		
		
		document.getElementById('general_tab').className = "tabClicked";
		document.getElementById('general_tab_span').className = "tabSpanclicked";
		


		parent.viewOfTabFrame.document.location.href = '../../eBL/jsp/BLInsRCMPayerSpecConfigGeneral.jsp?'+params;
		
		
        
	}
	if(fromTab=="supportDoc_tab"){
		
		document.getElementById('from_tab').value = "supporting";
		
		document.getElementById('general_tab').className = "tabA";
		document.getElementById('general_tab_span').className = "tabAspan";
		

		document.getElementById('validation_tab').className = "tabA";
		document.getElementById('validation_tab_span').className = "tabAspan";
		

		document.getElementById('claimSplit_tab').className = "tabA";
		document.getElementById('claimSplit_tab_span').className = "tabAspan";
		

		
		document.getElementById('supportDoc_tab').className = "tabClicked";
		document.getElementById('supportDoc_tab_span').className = "tabSpanclicked";

		parent.viewOfTabFrame.document.location.href = '../../eBL/jsp/BLInsRCMPayerSpecConfigDocsFrame.jsp?'+params;
		
	}
	
	if(fromTab=="validation_tab"){
		
		document.getElementById('from_tab').value = "validations";

		document.getElementById('general_tab').className = "tabA";
		document.getElementById('general_tab_span').className = "tabAspan";
		
		document.getElementById('supportDoc_tab').className = "tabA";
		document.getElementById('supportDoc_tab_span').className = "tabAspan";
		
		document.getElementById('claimSplit_tab').className = "tabA";
		document.getElementById('claimSplit_tab_span').className = "tabAspan";
		
		
		
		document.getElementById('validation_tab').className = "tabClicked";
		document.getElementById('validation_tab_span').className = "tabSpanclicked";
		parent.viewOfTabFrame.document.location.href = '../../eBL/jsp/BLInsRCMPayerSpecValidationFrame.jsp?'+params;

		
	}
	
	if(fromTab=="claimSplit_tab"){
		
		document.getElementById('from_tab').value = "claimSplitting";

		document.getElementById('general_tab').className = "tabA";
		document.getElementById('general_tab_span').className = "tabAspan";
		
		document.getElementById('validation_tab').className = "tabA";
		document.getElementById('validation_tab_span').className = "tabAspan";
		
		document.getElementById('supportDoc_tab').className = "tabA";
		document.getElementById('supportDoc_tab_span').className = "tabAspan";
		
		
		
		document.getElementById('claimSplit_tab').className = "tabClicked";
		document.getElementById('claimSplit_tab_span').className = "tabSpanclicked";
		
		
		parent.viewOfTabFrame.document.location.href = '../../eBL/jsp/BLInsRCMPayerSpecClaimSplittingMainFrame.jsp?'+params;
		
	}
	
}

function validationForDocAddingFrame(obj) {
	var checkDone1 = checkTheSequnceInputIsEmpty(obj);
	var checkDone2  = validateCheckboxes_encounter(obj);
	if(checkDone1 && checkDone2){
		return true ;
	}
	
	return false ;
}

function checkTheSequnceInputIsEmpty(obj){
	var configurationFrame = obj.PayerSpecDocsFrame.document.forms[0];
	var inputs = configurationFrame.getElementsByTagName("input");
	var textInputs = [];
	
	for (var i = 0; i < inputs.length; i++) {
	    if (inputs[i].type === "text") {
	        textInputs.push(inputs[i]);
	    }
	}

	for (var j = 0; j < textInputs.length; j++) {
	    if(textInputs[j].value == ''){
	    	 alert("Documents Sequence Cannot be Null");
	         commontoolbarFrame.location.reload();
	         return false;
	    }
	}
	return true;
}


function validateCheckboxes_encounter(obj) {
    var form =obj.PayerSpecDocsFrame.document;
    var table = form.getElementById("tblDocDetails");
    var rows = table.getElementsByTagName("tr");

    for (var i = 1; i < rows.length; i++) { // Skip the header row
        var row = rows[i];
        var checkboxes = row.getElementsByTagName("input");
        var isChecked = false;

        for (var j = 0; j < checkboxes.length; j++) {
            if (checkboxes[j].type === "checkbox" && checkboxes[j].checked) {
                isChecked = true;
                break; 
            }
        }

        if (!isChecked) {
            alert("Please Ensure That At Least One Episode/Encounter Type Is Checked In Row " + i);
             commontoolbarFrame.location.reload();
	         return false;
        }
    }

    return true;
} 




// claim splitting functions 

function validateBeforeApply(messageFrame,calledFrom,obj) {
	
	var flag1=true;
	var flag2=true;
	var claimTypeFrm= obj.PayerSpecClaimSplittingClaimsFrame.document.forms[0];

	
	var tbl = claimTypeFrm.parentNode.document.getElementById('tblType');

	var index = tbl.rows.length-1;
	var episodeTypeFlag=false;
	var idx=1;
	var jdx=1;
	
	
	if(index!='0'){
	
		outerLoop:
		for(var i=1;i<tbl.rows.length;i++){
			
			while(claimTypeFrm.parentNode.document.getElementById("claimTypeCode_"+idx)==null){
				idx++;
			}
			
			episodeTypeFlag=false;
			if(claimTypeFrm.parentNode.document.getElementById("claimTypeCode_"+idx).value==""){
					alert("Claim Type Code Cannot be Blank");
					flag1=false;
					break;
					
			}else{
				for(var j=1;j<tbl.rows.length;j++){
					jdx=1;
					while(claimTypeFrm.parentNode.document.getElementById("claimTypeCode_"+jdx)==null){
							jdx++
					}
					
					if(jdx!=idx){		
						if(claimTypeFrm.parentNode.document.getElementById('claimTypeCode_'+idx).value==claimTypeFrm.parentNode.document.getElementById('claimTypeCode_'+jdx).value){
							var f=false;
							
							if(claimTypeFrm.parentNode.document.getElementById('appl_ip_'+idx).value=='Y'&&claimTypeFrm.parentNode.document.getElementById('appl_ip_'+jdx).value=='Y') f=true;
							if(claimTypeFrm.parentNode.document.getElementById('appl_op_'+idx).value=='Y'&&claimTypeFrm.parentNode.document.getElementById('appl_op_'+jdx).value=='Y') f=true;
							if(claimTypeFrm.parentNode.document.getElementById('appl_dc_'+idx).value=='Y'&&claimTypeFrm.parentNode.document.getElementById('appl_dc_'+jdx).value=='Y') f=true;
							if(claimTypeFrm.parentNode.document.getElementById('appl_em_'+idx).value=='Y'&&claimTypeFrm.parentNode.document.getElementById('appl_em_'+jdx).value=='Y') f=true;
							if(f){
								alert("Claim Type Configuration Cannot be Duplicated for the same Episode Type");
								flag1=false;
								break outerLoop;

							}
						}
					}
					jdx++;
				}
			}
			
	
			if(claimTypeFrm.parentNode.document.getElementById('all_'+idx).value=='Y') episodeTypeFlag=true;
			if(claimTypeFrm.parentNode.document.getElementById('appl_ip_'+idx).value=='Y') episodeTypeFlag=true;
			if(claimTypeFrm.parentNode.document.getElementById('appl_op_'+idx).value=='Y') episodeTypeFlag=true;
			if(claimTypeFrm.parentNode.document.getElementById('appl_dc_'+idx).value=='Y') episodeTypeFlag=true;
			if(claimTypeFrm.parentNode.document.getElementById('appl_em_'+idx).value=='Y') episodeTypeFlag=true;
			
			if(!episodeTypeFlag){
				flag1=false;
				alert("At least one Episode/Encounter Type should be selected");
			}
		
			idx++;
		}
	}
	
	
	if(flag1){
		var classTypeFrm= obj.PayerSpecClaimSplittingClassFrame.document.forms[0];
	
		if(classTypeFrm!=null){
			
			tbl = classTypeFrm.parentNode.document.getElementById('tblService');
			
			index = tbl.rows.length-1;
			idx=1;
			if(index!='0'){
				for(var i=1;i<tbl.rows.length;i++){
					while(tbl.document.getElementById('bg_code_'+idx)==null){
						idx++;
					}
					if(tbl.document.getElementById("bg_code_"+idx).value==""){
							alert("Billing Services/Items Cannot be Blank");
							flag2= false;
							break;
							
					}
					idx++;
				}
				
			}
		}
	}
	
	
	
	if(flag1&&flag2){	
			return true;
	}else{
		if(calledFrom="apply"){
			messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+"APP-00001 Mandatory flelds Cannot be blank";
		}else{
			alert("APP-00001 Mandatory flelds Cannot be blank");
		}
        commontoolbarFrame.location.reload();

		return false ;

	}
    

}
function formValidation_splitting(xmlStr, last_link, event) {
    var temp_jsp = "BLInsRCMPayerSpecClaimSplittingPersistence.jsp?func_mode=" + last_link;

    var xmlDoc="";

    var xmlHttp = new XMLHttpRequest();
	
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
    xmlHttp.open("POST", temp_jsp, false);
    xmlHttp.send(xmlDoc);
	
    var responseText = xmlHttp.responseText;

    eval(responseText);
	
	
    return true;
}
function serviceFormValidation(xmlStr, last_link, claimType,appl_all,appl_ip,appl_op,appl_dc,appl_em) {
    var temp_jsp = "BLInsRCMPayerSpecClaimSplittingPersistence.jsp?func_mode=" + last_link+ "&claimType="+claimType+"&all="+appl_all+"&appl_ip="+appl_ip+"&appl_op="+appl_op+"&appl_dc="+appl_dc+"&appl_em="+appl_em;

    var xmlDoc="";

    var xmlHttp = new XMLHttpRequest();
	
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
    xmlHttp.open("POST", temp_jsp, false);
    xmlHttp.send(xmlDoc);
	
    var responseText = xmlHttp.responseText;

    eval(responseText);
	
	
    return true;
}

