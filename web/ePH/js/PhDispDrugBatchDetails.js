  var bean_id = "";
var bean_name = "";
var formObj="";

async function searchDrugCode(obj){
	//alert("the drug code"+obj);
	var formObj=parent.document.f_query_add_mod.PhDispDrugBatchDetails;
	var arrDrug = await DrugSearch("D",obj);	
	if (arrDrug != ""){
		formObj.p_drug_code.value = arrDrug[0];
		formObj.drug_desc.value = arrDrug[1];
		formObj.drug_desc.readOnly=true;
		populateTradeName(formObj.p_drug_code.value);

		replaceSpecialChar(formObj.drug_desc.value);
	}
}

function run() {
	var frmObject = f_query_add_mod.document.PhDispDrugBatchDetails;
	var locale=frmObject.p_language_id.value;
	
	if(f_query_add_mod.document.PhDispDrugBatchDetails){
		var fields= new Array (frmObject.p_drug_code,frmObject.p_f_date,frmObject.p_t_date);
		var names= new Array (getLabel("ePH.DispensedDrugName.label","PH"),getLabel("ePH.DispensedDateFrom.label","PH"),getLabel("ePH.DispensedDateTo.label","PH"));
		var ref=parent.parent.frames[2];
		var msgFrame= frames[2];
		
		if(checkFields(fields,names,msgFrame) ){   
		
			frmObject.p_fm_date.value=convertDate(frmObject.p_f_date.value,'DMY',locale,'en');//added for SKR-SCF-1009[IN048688] start
			frmObject.p_to_date.value=convertDate(frmObject.p_t_date.value,'DMY',locale,'en');//added for SKR-SCF-1009[IN048688] end
			if(parent.doDateCheck(frmObject.p_f_date,frmObject.p_t_date,msgFrame)){
				frmObject.action="../../eCommon/jsp/report_options.jsp";
				frmObject.target="messageFrame";
				frmObject.submit();
			}
			else{
				
				f_query_add_mod.document.PhDispDrugBatchDetails.p_fm_date.select;
			}
		}
	}
}

// the below method is used for leap year calculation
function CheckDateT(obj){
	var locale=document.PhDispDrugBatchDetails.p_language_id.value;
	if(obj.value!=""){
		if(!validDate(obj.value, 'DMY',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			obj.select();
			obj.focus();
			return false;
		}
	}
	else{
		obj.value=convertDate(obj,'DMY',locale,'en');
	}
}

function reset() {
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
	f_query_add_mod.PhDispDrugBatchDetails.reset();
	f_query_add_mod.PhDispDrugBatchDetails.drug_desc.readOnly=false;
	f_query_add_mod.PhDispDrugBatchDetails.drug_desc.focus();
}

function clearList()	{
	var len	= document.PhDispDrugBatchDetails.p_trade_id.options.length;
	for(var i=0;i<len;i++) {
		document.PhDispDrugBatchDetails.p_trade_id.remove(0) ;
	}
	var tp = "---"+getLabel("Common.defaultSelect.label","Common")+"---" ;
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	document.PhDispDrugBatchDetails.p_trade_id.add(opt);
	return;
}

function populateTradeName(drug_code){
	bean_id		=	document.PhDispDrugBatchDetails.bean_id.value;
	bean_name	=	document.PhDispDrugBatchDetails.bean_name.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr += " drug_code=\""+drug_code+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PhDispDrugBatchDetailsValidate.jsp",false);
	xmlHttp.send(xmlDoc);

	eval(xmlHttp.responseText);
	return;
}

function addList(code,desc)	{
	var element = document.createElement('OPTION') ;
	element.value		=  code ;
	element.text		= desc ;
	document.PhDispDrugBatchDetails.p_trade_id.add(element);
}

function replaceSpecialChar(values) {
//	alert("values"+values);
	var formObj=parent.document.f_query_add_mod.PhDispDrugBatchDetails;
	var strCheck = new Array("@", "!", "~" ,"#" ,"$" ,"%" ,"^" ,"*" ,"(" ,")" ,"_" ,"-" ,"+" ,"=" ,"`" ,"?" ,";" ,":" ,"'","<" ,">","/","\\","|","{","]","[","}" ,".");
	var lenValue  = strCheck.length;
	for(var i=0;i<lenValue;i++){
		while(values.indexOf(strCheck[i]) != -1 ){
			while(values.indexOf(strCheck[i]) != -1){
			values = values.replace(strCheck[i],"");
			formObj.drug_desc.value=values;
			}
			i++;
		}
	}
	return values;
}
