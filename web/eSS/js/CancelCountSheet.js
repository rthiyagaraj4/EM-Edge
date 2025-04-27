/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var function_id = "";
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;

function query(){
	f_query_add_mod.location.href="../../eSS/jsp/CancelCountSheetQueryFrame.jsp?function_id="+function_id+"&mode="+MODE_MODIFY;
}

function reset() { 
	f_query_add_mod.location.href="../../eSS/jsp/CancelCountSheetQueryFrame.jsp?function_id="+function_id+"&mode="+MODE_MODIFY;
}

function checkAll() {
	var maxvalue= document.formQueryResultHeader.max_rows.value;
	var chkstatus = document.formQueryResultHeader.check_all.checked;
	for (i=0;i<maxvalue;i++ ) {
		eval("document.forms[0].count_"+i+".checked = chkstatus");
	}
}

function checkMandatory() {
	var fields = new Array(document.formCancelCountSheetHeader.phy_inv_id);
	var fieldNames = new Array(getLabel("eSS.PhysicalInvId.label","SS"));
	obj = getBlankField(fields, fieldNames, parent.parent.messageFrame) 
	if(obj != null){
		obj.focus();
		return;
	}
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
	document.formCancelCountSheetHeader.submit();
}

function onSuccess(){
	f_query_add_mod.frameCancelCountSheetQueryResult.document.location.reload();
	return;
}

function apply(){
	var headerForm = f_query_add_mod.frameCancelCountSheetQueryResult.document.formQueryResultHeader;
	var fields = new Array(f_query_add_mod.frameCancelCountSheetQueryCriteria.document.formCancelCountSheetHeader.phy_inv_id);
	var fieldNames = new Array(getLabel("eSS.PhysicalInvId.label","SS"));
	var obj = getBlankField(fields, fieldNames, messageFrame) 
	if(obj != null){
		obj.focus();
		return;
	}
	if (headerForm == null) {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ getMessage('MIN_ONE_DETAIL_REQUIRED',"SS");
		return;
	}
	var chkd_index = 0;
	var unchkd_index = 0;
	var selectedIndices = "";
	var xmlString = "";
	var max_rows = headerForm.max_rows.value;
	if (parseFloat(max_rows)<=0) {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ getMessage('MIN_ONE_DETAIL_REQUIRED',"SS");
		return;
	}
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=";
	for (count = 0;count<parseFloat(max_rows);count++) {
			checkedValue = eval("f_query_add_mod.frameCancelCountSheetQueryResult.document.formQueryResultHeader.count_"+count+".value");
			if(eval("f_query_add_mod.frameCancelCountSheetQueryResult.document.formQueryResultHeader.count_"+count+".checked")) {
				
				var arrayObject = new Array();
				xmlString += " checked_tray_"+ chkd_index +"=\""+checkedValue+"\" ";
				chkd_index+=1;
				selectedIndices += (count+",");
				xmlString += eval ("headerForm.group_code_"+count+".name");
				xmlString += "=\"";
				xmlString += eval ("headerForm.group_code_"+count+".value") + "\" ";
				xmlString += eval ("headerForm.current_store_code_"+count+".name");
				xmlString += "=\"";
				xmlString += eval ("headerForm.current_store_code_"+count+".value")+ "\" ";
				xmlString += eval ("headerForm.owner_store_code_"+count+".name");
				xmlString += "=\"";
				xmlString += eval ("headerForm.owner_store_code_"+count+".value")+ "\" ";
			}
			else {
				xmlString += " unchecked_tray_"+ unchkd_index +"=\""+checkedValue+"\"";
				unchkd_index+=1;
			}
	}
	xmlString += " checked_values=\""+chkd_index+"\"";
	xmlString += " unchecked_values=\""+unchkd_index+"\"";
	xmlString += " selectedIndices=\""+selectedIndices+"\"";
	xmlString += " phy_inv_id=\""+headerForm.phy_inv_id.value+"\"";
	xmlString ="<root><SEARCH "+xmlString+"/></root>";
	if ((chkd_index == 0) && (headerForm.hasNext.value=="0")) {
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ getMessage('MIN_ONE_DETAIL_REQUIRED',"SS");
		return;
	}
	assignBean(headerForm);	
	xmlDom.loadXML(xmlString);
	xmlHttp.open("POST", "../../eSS/jsp/CancelCountSheetValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&function_type=1", false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
	eval(formApply(f_query_add_mod.frameCancelCountSheetQueryResult.document.formQueryResultHeader,SS_CONTROLLER));
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+ message;	 
	onSuccess();
	return;
}

function assignBean(formObject) {
	bean_id = formObject.bean_id.value;
	bean_name = formObject.bean_name.value;
	xmlDom = new ActiveXObject( "Microsoft.XMLDom" );
	xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" );
}
