
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


function checkSequence(obj){
	var pdoc=parent.PayerSpecDocsFrame.document.forms[0];
	var tbl = pdoc.parentNode.document.getElementById('tblDocDetails');
	var index = tbl.rows.length-1;
	
	if(obj.value==0 && obj.value!=""){
		alert("Sequence can't less than 1" );
		obj.value='';
		obj.select();
	}
	for(var i=0;i<index;i++){
		
		if(pdoc.document.getElementById("reportSeq_"+i)!==null && pdoc.document.getElementById("reportSeq_"+i).value!="" && pdoc.document.getElementById("reportSeq_"+i )!=obj){
			
			
			if(obj.value==pdoc.document.getElementById("reportSeq_"+i).value){
					alert("Sequence can't be duplicated");
					obj.value='';
					obj.select();
					
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
		"<p  name='reportName_"+index+"' id='reportName_"+index+"'>"+d+"</p> <input type='hidden' name='reportId_"+index+"' id=reportId_'"+index+"' value='"+dId+"'> </td>"
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
	var mainfrmObj = "";
	mainfrmObj = BLInsRCMPayerSpecSupDocConfigMain.PayerSpecInfoFrame.document.forms[0];
	var mode = mainfrmObj.mode.value;
	
	
	var frm=BLInsRCMPayerSpecSupDocConfigMain.PayerSpecAddDocFrame.document.forms[0];
	var Docsfrm=BLInsRCMPayerSpecSupDocConfigMain.PayerSpecDocsFrame.document.forms[0];
	var doc = frm.parentNode.document.getElementById('docName');
	var docRowCount = Docsfrm.docRowCount.value;
		
	var fieldsTop = new Array(mainfrmObj.payerCode2,mainfrmObj.payerCode);
	
	var payerLbl = getLabel("eBL.PAYER.label", "bl");
    var payerGrpLbl = getLabel("eBL.PAYER_GROUP.label", "bl");
	
	var namesTop = new Array(payerGrpLbl,payerLbl);
	
	var msgFrame=messageFrame;
	
	var proceed=true;
	
	
	if(checkFieldsofMst(fieldsTop,namesTop,msgFrame)){
		
		
		
		if(docRowCount<1){
		alert("APP-000005 Documents Cannot be Blank");
		commontoolbarFrame.location.reload();
		
		return false;
	}
		
		if(mainfrmObj.policyTypeCode.value==""){
			mainfrmObj.policyTypeCode.value="**"
			if(validateCombination(mainfrmObj.payerCode2,mainfrmObj.payerCode,mainfrmObj.policyTypeCode,mainfrmObj)){
					
				commontoolbarFrame.location.reload();
				return false;
					
			}		
		}
		
		var indx=0;
		
		for(var i=0;i<docRowCount;i++){
			while(Docsfrm.document.getElementById('reportSeq_'+indx)==null){
					indx++;
			}
			
			if(Docsfrm.document.getElementById('reportSeq_'+indx).value=="" || Docsfrm.document.getElementById('reportSeq_'+indx).value==null){
				alert("Documents Sequence Cannot be Null");
				commontoolbarFrame.location.reload();
				return false;
			} 
			indx++;
			
		}
		
		indx=0;
		for(var i=0;i<docRowCount;i++){
			while(Docsfrm.document.getElementById('appl_ip_'+indx)==null){
					indx++;
			}
			
			if(Docsfrm.document.getElementById('appl_ip_'+indx).value=="N" && Docsfrm.document.getElementById('appl_dc_'+indx).value=="N" && Docsfrm.document.getElementById('appl_em_'+indx).value=="N" && Docsfrm.document.getElementById('appl_op_'+indx).value=="N"){
				alert("At least one Episode/Encounter Type should be selected");
				commontoolbarFrame.location.reload();
				return false;
			} 
			indx++;
			
		}
		
		
		
		
		var xmlString = formXMLStringMain(mainfrmObj);
        var updation = formValidation(xmlString, "infoFrame");
		
		var frmObj = "";
		frmObj = BLInsRCMPayerSpecSupDocConfigMain.PayerSpecDocsFrame.document.forms[0];
		var mode = mainfrmObj.mode.value;
		var pageInfo = frmObj.pageInfo.value;
		xmlString = formXMLStringMain(frmObj);
        updation = formValidation(xmlString, pageInfo);
		
		mainfrmObj.target = 'messageFrame';
        mainfrmObj.method = "post";
        mainfrmObj.action = "../../servlet/eBL.BLInsRCMPayerSpecSupDocConfigServlet?mode=" + mode;
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


