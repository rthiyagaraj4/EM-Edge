function setSelectedRenewOrder(obj, index){
	var formObj = document.ChartSummaryCurrentMedicationsForm;
	var selected_yn= '';
	if(obj.checked)
		selected_yn = "Y";
	else
		selected_yn = "N";
	var orderIdDtl = eval("formObj.OrderId_LineNum"+index).value;
	var drug_code = eval("formObj.drug_code"+index).value;
	var patient_id		= formObj.patient_id.value ;
	var encounter_id	= formObj.encounter_id.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " patient_id=\"" + patient_id + "\"";
	xmlStr += " encounter_id=\"" + encounter_id + "\"";
	xmlStr += " selected_yn=\"" + selected_yn + "\"";
	xmlStr += " orderIdDtl=\"" + orderIdDtl + "\"";
	xmlStr += " drug_code=\"" + drug_code + "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ChartSummaryCurrentMedicationsValidation.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&identity=setSelectedRenewOrder", false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);		
}

function checkDuplicate (obj, index, count){
	var formObj = document.ChartSummaryCurrentMedicationsForm;
	var drug_code = eval("formObj.drug_code"+index).value;
	var tmp_drug_code, IV_Prep_yn;
	for (i=1; i<parseInt(count) ;i++ ){
		tmp_drug_code = eval("formObj.drug_code"+i).value;
		IV_Prep_yn = eval("formObj.IV_Prep_yn"+i).value;
		if(drug_code == tmp_drug_code && IV_Prep_yn=="" && i!= index){
			if(obj.checked)
				eval("formObj.renewYN"+i).disabled = true;
			else
				eval("formObj.renewYN"+i).disabled = false;
		}
	}
}

function disableDuplicate (){
	var formObj = document.ChartSummaryCurrentMedicationsForm;
	var count = formObj.count.value;
	var tmp_drug_code, tmp_IV_Prep_yn, drug_code, IV_Prep_yn;
	for (index=1; index<parseInt(count) ;index++ ){
		drug_code = eval("formObj.drug_code"+index).value;
		IV_Prep_yn = eval("formObj.IV_Prep_yn"+index).value;
		renewYN = eval("formObj.renewYN"+index);
		if(IV_Prep_yn==''){
			for(i=1; i<parseInt(count) ;i++ ){
				tmp_drug_code = eval("formObj.drug_code"+i).value;
				tmp_IV_Prep_yn = eval("formObj.IV_Prep_yn"+i).value;
				if(drug_code == tmp_drug_code && IV_Prep_yn=="" && i!= index && renewYN.checked){
					eval("formObj.renewYN"+i).disabled = false;
				}
			}
		}
	}
}
