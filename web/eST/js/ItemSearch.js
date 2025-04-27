/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
24/05/2017		IN063603		Badmavathi B							GHL-CRF-0456
24/12/2021		TFS:26172		Shazana											KDAH-SCF-0741
---------------------------------------------------------------------------------------------------------
*/
var ordercolmns = "1";
var count = 1;
var radioval = "IC";
var prevObj = null;
var prevColor = null;

function CloseWindow() {
	parent.window.close();
}
function callMoreOptions() {
	parent.qryResult.document.location.href = "../../eST/jsp/ItemSearchQueryCriteriaMore.jsp";
}
function callLessOptions() {
	parent.qryResult.document.location.href = "../../eCommon/html/blank.html";
}
function searchVals() {
	var formObj = parent.qryCriteria.document.ItemSearchCriteria_Form;
	if (formObj.search_string.value != "") {
		objform = parent.qryCriteria.ItemSearchCriteria_Form;
		search_string = objform.search_string.value;

    //if(document.forms[0] != null {
		if (document.forms[0].searchby[0].checked) {
			radioval = "IC";
		}
		if (document.forms[0].searchby[1].checked) {
			radioval = "IN";
		}
		if (document.forms[0].searchby[2].checked) {
			radioval = "MC";
		}
		if (document.forms[0].searchby[3].checked) {
			radioval = "PN";
		}
		if (document.forms[0].searchby[4].checked) {
			radioval = "TI";
		}
		if (document.forms[0].searchby[5].checked) {
			radioval = "TN";
		}
		if (document.forms[0].searchby[6].checked) {
			radioval = "AC";
		}
		

	//}
		var item_code = "";
		var short_desc = "";
		var alpha_code = "";
		var machine_code = "";
		var spare_part_id = "";
		var trade_name = "";
		var trade_id = "";
		var medical_item_yn = "";
		var re = /%/g;
		search_string = search_string.replace(re, " ");
		if (search_string != "" && search_string != null) {
			if (objform.search_criteria.value == "S") {
				search_string = search_string + "%";
			} else {
				if (objform.search_criteria.value == "C") {
					search_string = "%" + search_string + "%";
				} else {
					search_string = "%" + search_string;
				}
			}
			//Below code is comented and following code is added by Archana Dhal on 11/26/2010 related to incident no IN025029
			//search_string = escape(search_string);
			search_string = encodeURIComponent(search_string,"UTF-8");
			if (radioval == "IC") {
				item_code = search_string;
			} else {
				if (radioval == "IN") {
					short_desc = search_string;
				} else {
					if (radioval == "AC") {
						alpha_code = search_string;
					} else {
						if (radioval == "MC") {
							machine_code = search_string;
						} else {
							if (radioval == "PN") {
								spare_part_id = search_string;
							} else {
								if (radioval == "TI") {
									trade_id = search_string;
								} else {
									if (radioval == "TN") {
										trade_name = search_string;
									}
								}
							}
						}
					}
				}
			}
		} else {
			item_code = "";
			short_desc = "";
			alpha_code = "";
			machine_code = "";
			spare_part_id = "";
			trade_id = "";
			trade_name = "";
				//return;
		}
		mfg_item = objform.mfg_item.value;
		expiry = objform.expiry.value;
		item_class = objform.item_class_code.value;
		item_analysis_1 = objform.item_analysis_1.value;
		item_analysis_2 = objform.item_analysis_2.value;
		item_analysis_3 = objform.item_analysis_3.value;
		if (objform.kit_template_yn.checked) {
			var kit_code = search_string;
			var temp_jsp = "../../eST/jsp/ItemSearchValidate.jsp?function_type=5&kit_code=" + kit_code;
			var xmlStr = "<root><SEARCH /></root>";
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST", temp_jsp, false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
		//return;
			parent.qryResult.document.location.href = "../../eST/jsp/KitItemSearchQueryResult.jsp?";//radioval="+radioval;
		} else {
			if (objform.chkitemstorecmb.checked) {
				chk_itemstorecmb = "Y";
			} else {
				chk_itemstorecmb = "N";
			}
			/*Added By Mahesh on 03/12/2009 to Set Store_code to empty when store value is deleted from the text box*/
			if(objform.store.value==""){
				objform.store_code.value = "";
			}
			/*Coded added on 03/12/2009 ends*/
			var temp_jsp = "../../eST/jsp/ItemSearchValidate.jsp?function_type=1&item_code=" + item_code + "&short_desc=" + short_desc + "&alpha_code=" + alpha_code + "&machine_code=" + machine_code + "&spare_part_id=" + spare_part_id + "&category=" + objform.category.value + "&ps_item=" + objform.ps_item.value + "&sole_source=" + objform.sole_source.value + "&manufacturer=" + objform.manufacturer.value + "&abc_analysis=" + objform.abc_analysis.value + "&mfg_item=" + mfg_item + "&expiry=" + expiry + "&item_class=" + item_class + "&item_analysis_1=" + item_analysis_1 + "&item_analysis_2=" + item_analysis_2 + "&item_analysis_3=" + item_analysis_3 + "&ordercolmns=" + ordercolmns + "&trade_id=" + trade_id + "&trade_name=" + trade_name + "&consignment=" + objform.consignment.value + "&store_code=" + objform.store_code.value + "&store_desc=" + objform.store_desc.value + "&chk_itemstorecmb=" + chk_itemstorecmb + "&trn_type=" + objform.trn_type.value + "&radioval=" + radioval;//Added trn_type against GHL-CRF-0456
			var xmlStr = "<root><SEARCH /></root>";
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest(); 
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST", temp_jsp, false);
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			//parent.qryResult.document.location.href = "../../eST/jsp/ItemSearchQueryResult.jsp?radioval=" + radioval;
			//Modified by Sakti against AMS-CRF-0011 trn_type passing
			//Modified by suresh.r on 17-06-2014 against ML-BRU-SCF-1375 search_no passing 
			parent.qryResult.document.location.href = "../../eST/jsp/ItemSearchQueryResult.jsp?radioval="+ radioval+"&trn_type="+objform.trn_type.value+"&search_no="+objform.search_no.value;
		}
	} else {
		alert(getMessage("SEARCH_STRING_CANNOT_BE_BLANK", "ST"));
	}
}
function searchVals1() {
	objform = parent.qryCriteria.ItemSearchCriteria_Form;
	search_string = objform.search_string.value;
	if (search_string != "") {
    
    //if(document.forms[0] != null {
		
	//}
		var item_code = "";
		var short_desc = "";
		var alpha_code = "";
		var machine_code = "";
		var spare_part_id = "";
		var trade_name = "";
		var trade_id = "";
		var medical_item_yn = "";
		var re = /%/g;
		search_string = search_string.replace(re, " ");
		if (search_string != "" && search_string != null) {
			if (objform.search_criteria.value == "S") {
				search_string = search_string + "%";
			} else {
				if (objform.search_criteria.value == "C") {
					search_string = "%" + search_string + "%";
				} else {
					search_string = "%" + search_string;
				}
			}
			//search_string = escape(search_string);
			search_string = encodeURIComponent(search_string,"UTF-8");
			if (radioval == "IC") {
				item_code = search_string;
			} else {
				if (radioval == "IN") {
					short_desc = search_string;
				} else {
					if (radioval == "AC") {
						alpha_code = search_string;
					} else {
						if (radioval == "MC") {
							machine_code = search_string;
						} else {
							if (radioval == "PN") {
								spare_part_id = search_string;
							} else {
								if (radioval == "TI") {
									trade_id = search_string;
								} else {
									if (radioval == "TN") {
										trade_name = search_string;
									}
								}
							}
						}
					}
				}
			}
		} else {
			item_code = "";
			short_desc = "";
			alpha_code = "";
			machine_code = "";
			spare_part_id = "";
			trade_id = "";
			trade_name = "";
				//return;
		}
		mfg_item = objform.mfg_item.value;
		expiry = objform.expiry.value;
		item_class = objform.item_class_code.value;
		item_analysis_1 = objform.item_analysis_1.value;
		item_analysis_2 = objform.item_analysis_2.value;
		item_analysis_3 = objform.item_analysis_3.value;
		if (objform.chkitemstorecmb.checked) {
			chk_itemstorecmb = "Y";
		} else {
			chk_itemstorecmb = "N";
		}
		var temp_jsp = "../../eST/jsp/ItemSearchValidate.jsp?function_type=1&item_code=" + item_code + "&short_desc=" + short_desc + "&alpha_code=" + alpha_code + "&machine_code=" + machine_code + "&spare_part_id=" + spare_part_id + "&category=" + objform.category.value + "&ps_item=" + objform.ps_item.value + "&sole_source=" + objform.sole_source.value + "&manufacturer=" + objform.manufacturer.value + "&abc_analysis=" + objform.abc_analysis.value + "&mfg_item=" + mfg_item + "&expiry=" + expiry + "&item_class=" + item_class + "&item_analysis_1=" + item_analysis_1 + "&item_analysis_2=" + item_analysis_2 + "&item_analysis_3=" + item_analysis_3 + "&ordercolmns=" + ordercolmns + "&trade_id=" + trade_id + "&trade_name=" + trade_name + "&consignment=" + objform.consignment.value + "&store_code=" + objform.store_code.value + "&store_desc=" + objform.store_desc.value + "&chk_itemstorecmb=" + chk_itemstorecmb + "&trn_type=" + objform.trn_type.value + "&radioval=" + radioval;//Added trn_type against GHL-CRF-0456
		var xmlStr = "<root><SEARCH /></root>";
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", temp_jsp, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		//parent.qryResult.document.location.href = "../../eST/jsp/ItemSearchQueryResult.jsp?radioval=" + radioval;
		//Modified by Sakti against AMS-CRF-0011 trn_type passing
		//Modified by suresh.r on 17-06-2014 against ML-BRU-SCF-1375 search_no passing
		parent.qryResult.document.location.href = "../../eST/jsp/ItemSearchQueryResult.jsp?radioval=" + radioval+"&trn_type=" + objform.trn_type.value+"&search_no="+objform.search_no.value;
	} else {
		alert(getMessage("SEARCH_STRING_CANNOT_BE_BLANK", "ST"));
	}
}
function storeVal(currad) {
	radioval = currad;
}
function returnVals(mfg_base_qty, machine_code, min_stk_qty, max_stk_qty, long_desc, ps_item_yn, sole_source_yn, manufacturer_id, gen_uom_code, unit_cost, manufacture_desc, trade_id_applicable_yn, batch_id_applicable_yn, expiry_yn, item_code, item_name, item_class, alpha_code, uom_desc, consignment, store_code, store_desc, curr_supp_code, preparation_type, preparation_mode, gen_uom_desc, req_uom_code,allow_decimals_yn,no_of_decimals) {

	var returnvals = item_code + "!~" + decodeURIComponent(item_name,"UTF-8")  + "!~" + expiry_yn + "!~" + decodeURIComponent(item_class,"UTF-8") + "!~" + alpha_code + "!~" + mfg_base_qty + "!~" + machine_code + "!~" + min_stk_qty + "!~" + max_stk_qty + "!~" + decodeURIComponent(long_desc,"UTF-8")  + "!~" + ps_item_yn + "!~" + sole_source_yn + "!~" + manufacturer_id + "!~" + gen_uom_code + "!~" + unit_cost + "!~" + decodeURIComponent(uom_desc,"UTF-8") + "!~" + decodeURIComponent(manufacture_desc,"UTF-8") + "!~" + trade_id_applicable_yn + "!~" + batch_id_applicable_yn + "!~" + consignment + "!~" + store_code + "!~" + store_desc + "!~" + curr_supp_code + "!~" + preparation_type + "!~" + preparation_mode + "!~" + decodeURIComponent(gen_uom_desc,"UTF-8") + "!~" + req_uom_code+ "!~" + allow_decimals_yn+ "!~" + no_of_decimals;
	
	window.parent.parent.returnValue = returnvals.split("!~");
	/*let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = returnvals.split("!~");*/
    
    //To Clear the ItemSearchBean after selecting value
	var temp_jsp = "../../eST/jsp/ItemSearchValidate.jsp?function_type=4";
	var xmlStr = "<root><SEARCH /></root>";
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	//toCloseTopShowModal(returnvals.split("!~"));
	parent.window.close();
   /* const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();*/
}
function kitReturnVals(kit, kit_template_code) {
	var kitreturnvals = kit + "#" + kit_template_code;
	window.parent.parent.returnValue = kitreturnvals.split("#");
	/*let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = kitreturnvals.split("#");
*/
	//To Clear the ItemSearchBean after selecting value
	var temp_jsp = "../../eST/jsp/ItemSearchValidate.jsp?function_type=4";
	var xmlStr = "<root><SEARCH /></root>";
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	parent.window.close();
	/*const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();*/
}
function activeLink() {
	formObjCriteria = parent.qryCriteria.ItemSearchCriteria_Form;
	formObjResult = parent.qryResult.ItemsearchForm;
	if (formObjResult.start.value != 0) {
		parent.qryCriteria.ItemSearchCriteria_Form.previous.disabled = false;
	} else {
		parent.qryCriteria.ItemSearchCriteria_Form.previous.disabled = true;
	}
	if (!((parseInt(formObjResult.start.value) + parseInt(formObjResult.displaySize.value)) >= formObjResult.totalRecords.value)) {
		parent.qryCriteria.ItemSearchCriteria_Form.next.disabled = false;
	} else {
		parent.qryCriteria.ItemSearchCriteria_Form.next.disabled = true;
	}
}
function goNext() {
	formObj = parent.qryResult.ItemsearchForm;
	start = parseInt(formObj.start.value) + parseInt(formObj.displaySize.value);
	end = parseInt(formObj.end.value) + parseInt(formObj.displaySize.value);
	//parent.qryResult.location.href = "../../eST/jsp/ItemSearchQueryResult.jsp?from=" + start + "&to=" + end;
	//Modified by Sakti against AMS-CRF-0011 trn_type passing
	//Modified by suresh.r on 17-06-2014 against ML-BRU-SCF-1375 search_no passing
	parent.qryResult.location.href = "../../eST/jsp/ItemSearchQueryResult.jsp?from=" + start + "&to=" + end+"&trn_type="+parent.qryCriteria.ItemSearchCriteria_Form.trn_type.value+"&search_no="+parent.qryCriteria.ItemSearchCriteria_Form.search_no.value;
}
function goPrev() {
	formObj = parent.qryResult.ItemsearchForm;
	start = parseInt(formObj.start.value) - parseInt(formObj.displaySize.value);
	end = parseInt(formObj.end.value) - parseInt(formObj.displaySize.value);
	//parent.qryResult.location.href = "../../eST/jsp/ItemSearchQueryResult.jsp?from=" + start + "&to=" + end;
	//Modified by Sakti against AMS-CRF-0011 trn_type passing
	//Modified by suresh.r on 17-06-2014 against ML-BRU-SCF-1375 search_no passing
	parent.qryResult.location.href = "../../eST/jsp/ItemSearchQueryResult.jsp?from=" + start + "&to=" + end+"&trn_type="+parent.qryCriteria.ItemSearchCriteria_Form.trn_type.value+"&search_no="+parent.qryCriteria.ItemSearchCriteria_Form.search_no.value;
}
function ordercols(obj) {
	ordercolmns = obj;
	formObj = parent.qryResult.ItemsearchForm;
	start = formObj.start.value;
	end = formObj.end.value;
	var maxrec = "";
	totalRecords = formObj.totalRecords.value;
	
	//if (parseInt(end)>totalRecords)
	//{
	maxrec = totalRecords;
	
		
	//}
	//else
		//maxrec=end;
	var temp_jsp;
	var xmlStr = "<root><SEARCH /></root>";
	temp_jsp = "../../eST/jsp/ItemSearchValidate.jsp?function_type=2&from=" + start + "&to=" + parseInt(maxrec) + "&ordercolmns=" + ordercolmns;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	//parent.qryResult.location.href = "../../eST/jsp/ItemSearchQueryResult.jsp?from=" + start + "&to=" + end;
	//Modified by Sakti against AMS-CRF-0011 trn_type passing
	//Modified by suresh.r on 17-06-2014 against ML-BRU-SCF-1375 search_no passing
	parent.qryResult.location.href = "../../eST/jsp/ItemSearchQueryResult.jsp?from=" + start + "&to=" + end+"&trn_type="+parent.qryCriteria.ItemSearchCriteria_Form.trn_type.value+"&search_no="+parent.qryCriteria.ItemSearchCriteria_Form.search_no.value;
}
function onMMove(obj, e, machine_code, ps_item_yn, sole_source_yn, unit_cost, spare_part_id, mfg_item_yn, medical_item_yn, abc_class_code, consignment,item_name) {
	
	if (machine_code == null || machine_code == "") {
		machine_code = "&nbsp;";
	}
	if (spare_part_id == null || spare_part_id == "") {
		spare_part_id = "&nbsp;";
	}
	if (ps_item_yn == "Y") {
		ps_item_yn = "<img align='center' src='../../eCommon/images/enabled.gif'>";
	} else {
		ps_item_yn = "<img align='center' src='../../eCommon/images/disabled.gif'>";
	}
	if (sole_source_yn == "Y") {
		sole_source_yn = "<img align='center' src='../../eCommon/images/enabled.gif'>";
	} else {
		sole_source_yn = "<img align='center' src='../../eCommon/images/disabled.gif'>";
	}
	if (mfg_item_yn == "Y") {
		mfg_item_yn = "<img align='center' src='../../eCommon/images/enabled.gif'>";
	} else {
		mfg_item_yn = "<img align='center' src='../../eCommon/images/disabled.gif'>";
	}
	if (medical_item_yn == "Y") {
		medical_item_yn = "<img align='center' src='../../eCommon/images/enabled.gif'>";
	} else {
		medical_item_yn = "<img align='center' src='../../eCommon/images/disabled.gif'>";
	}
	if (consignment == "Y") {
		consignment = "<img align='center' src='../../eCommon/images/enabled.gif'>";
	} else {
		consignment = "<img align='center' src='../../eCommon/images/disabled.gif'>";
	}
	obj.style.left = e.x + 30;
	obj.style.top = e.y;
	obj.style.borderColor = "";
	obj.style.borderWidth = "thin";
	obj.style.borderStyle = "groove";
	obj.style.width = 700;
	/*	var PSItem_Legend=getLabel("eMM.PharmacyStockItem.label","MM");
			var SoleSource_Legend=getLabel("Common.SoleSource.label","Common");
			var MfgItem_Legend=getLabel("eST.MFGItem.label","ST");
			var MedicalItem_Legend=getLabel("Common.MedicalItem.label","Common");
			var ABCAnalysis_Legend=getLabel("eST.ABCAnalysis.label","ST");
			var MachineCode_Legend=getLabel("eST.MachineCode.label","ST");
			var PartNumber_Legend=getLabel("eST.PartNumber.label","ST");
			var Consignment_Legend=getLabel("Common.Consignment.label","Common");*/

	//commented by Rabbani #Inc no:35672 on 19/10/12	
	//obj.innerHTML = "<table cellspacing='0' cellpadding='0' border='1' height=100% width='100%'><tr><th>" + getLabel("eMM.PharmacyStockItem.label", "MM") + "</th><th>" + getLabel("Common.SoleSource.label", "Common") + "</th><th>" + getLabel("eST.MFGItem.label", "ST") + "</th><th>" + getLabel("Common.MedicalItem.label", "Common") + "</th><th>" + getLabel("eST.Consignment.label", "ST") + "</th><th>" + getLabel("eST.ABCAnalysis.label", "ST") + "</th><th>" + getLabel("eST.MachineCode.label", "ST") + "</th><th>" + getLabel("eST.PartNumber.label", "ST") + "</th><th width=520>" + getLabel("Common.item.label", "Common") + "</th></tr><tr><td  align='center' nowrap>" + ps_item_yn + "</td><td align='center' nowrap>" + sole_source_yn + "</td><td  align='center'>" + mfg_item_yn + "</td><td align='center' >" + medical_item_yn + "</td><td align='center' >" + consignment + "</td><td  >" + abc_class_code + "</td><td  >" + machine_code + "</td><td  >" + spare_part_id + "</td><td wrap>" + item_name + "</td></tr></table>";
	
	//Added by Rabbani #Inc no:35672 on 19/10/12
	obj.innerHTML = "<table cellspacing='0' cellpadding='0' border='1' height=100% width='100%'><tr><th>" + getLabel("eMM.PharmacyStockItem.label", "MM") + "</th><th>" + getLabel("Common.SoleSource.label", "Common") + "</th><th>" + getLabel("eST.MFGItem.label", "ST") + "</th><th>" + getLabel("Common.MedicalItem.label", "Common") + "</th><th>" + getLabel("eST.Consignment.label", "ST") + "</th><th>" + getLabel("eST.ABCAnalysis.label", "ST") + "</th><th>" + getLabel("eST.MachineCode.label", "ST") + "</th><th>" + getLabel("eST.PartNumber.label", "ST") + "</th><th width=520>" + getLabel("Common.item.label", "Common") + "</th></tr><tr><td  align='center' nowrap>" + ps_item_yn + "</td><td align='center' nowrap>" + sole_source_yn + "</td><td  align='center'>" + mfg_item_yn + "</td><td align='center' >" + medical_item_yn + "</td><td align='center' >" + consignment + "</td><td  >" + abc_class_code + "</td><td  >" + machine_code + "</td><td  >" + spare_part_id + "</td><td wrap>"  +decodeURIComponent(item_name,"UTF-8") + "</td></tr></table>";
	}
function onMOut(obj) {
	obj.innerHTML = "";
	obj.style.width = 0;
	obj.style.borderColor = "";
	obj.style.borderWidth = "";
	obj.style.borderStyle = "";
}
function changeRadVal() {
	if (radioval == "IC") {
		radioval = "IN";
		/* A new searchVals1() is called duw to problem in the document.forms[0].searchby(0).checked ..... */
		searchVals1();
	} else {
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA", "Common"));
		document.location.href = "../../eCommon/html/blank.html";
	}
}
async function searchCode(objCode, objDesc) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var sql = "SELECT  STORE_CODE code, SHORT_DESC  description FROM  MM_STORE_LANG_VW   WHERE   STORE_CODE  LIKE  UPPER(?)  AND  UPPER(SHORT_DESC)  LIKE UPPER(?)  AND  EFF_STATUS='E' AND  LANGUAGE_ID ='"+parent.qryCriteria.ItemSearchCriteria_Form.language_id.value+"'";//KDAH-SCF-0741
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	var ret1=unescape(returnedValues);
	var arr=ret1.split(",");
	if(arr[1]==undefined) 
	{
		arr[0]="";	
		arr[1]="";	
	}
	if ((returnedValues != null) && (returnedValues != "")) {
		objCode.value = arr[0];
		objDesc.value = arr[1];
		document.forms[0].store_desc.value = arr[1];
		document.forms[0].store.value = arr[0];
			//objDesc.disabled=true;
	}
}
function setItemClassDesc(obj) {
	var item_class_desc = obj[obj.selectedIndex].text;
	var item_class_code = obj.value;
	document.ItemSearchCriteria_Form.item_class_code.value = item_class_code;
}
//Mahesh
function formdisable(obj) {
	if (obj.checked) {
		for (var i = 0; i < 7; i++) {
			document.ItemSearchCriteria_Form.searchby(i).disabled = true;
		}
		document.ItemSearchCriteria_Form.category.disabled = true;
		document.ItemSearchCriteria_Form.mfg_item.disabled = true;
		document.ItemSearchCriteria_Form.sole_source.disabled = true;
		document.ItemSearchCriteria_Form.expiry.disabled = true;
		document.ItemSearchCriteria_Form.ps_item.disabled = true;
		document.ItemSearchCriteria_Form.item_class.disabled = true;
		document.ItemSearchCriteria_Form.abc_analysis.disabled = true;
		document.ItemSearchCriteria_Form.item_analysis_1.disabled = true;
		document.ItemSearchCriteria_Form.chkitemstorecmb.disabled = true;
		document.ItemSearchCriteria_Form.manufacturer.disabled = true;
		document.ItemSearchCriteria_Form.item_analysis_2.disabled = true;
		document.ItemSearchCriteria_Form.store.disabled = true;
		document.ItemSearchCriteria_Form.search_store.disabled = true;
		document.ItemSearchCriteria_Form.consignment.disabled = true;
		document.ItemSearchCriteria_Form.item_analysis_3.disabled = true;
		parent.qryResult.document.location.href = "../../eCommon/html/blank.html";
	} else {
		//parent.qryCriteria.location.reload();
		//document.ItemSearchCriteria_Form.reset();
		for (var i = 0; i < 7; i++) {
			document.ItemSearchCriteria_Form.searchby(i).disabled = false;
		}
		document.ItemSearchCriteria_Form.category.disabled = false;
		document.ItemSearchCriteria_Form.mfg_item.disabled = false;
		document.ItemSearchCriteria_Form.sole_source.disabled = false;
		document.ItemSearchCriteria_Form.expiry.disabled = false;
		document.ItemSearchCriteria_Form.ps_item.disabled = false;
		if (document.ItemSearchCriteria_Form.item_class_code.value == "") {
			document.ItemSearchCriteria_Form.item_class.disabled = false;
		}
		document.ItemSearchCriteria_Form.abc_analysis.disabled = false;
		document.ItemSearchCriteria_Form.item_analysis_1.disabled = false;
		document.ItemSearchCriteria_Form.chkitemstorecmb.disabled = false;
		document.ItemSearchCriteria_Form.manufacturer.disabled = false;
		document.ItemSearchCriteria_Form.item_analysis_2.disabled = false;
		document.ItemSearchCriteria_Form.store.disabled = false;
		document.ItemSearchCriteria_Form.search_store.disabled = false;
		document.ItemSearchCriteria_Form.consignment.disabled = false;
		document.ItemSearchCriteria_Form.item_analysis_3.disabled = false;
		parent.qryResult.document.location.href = "../../eCommon/html/blank.html";
	}
}

function getDefaultItmSearch()
{
	var formObj=document.ItemSearchCriteria_Form;
	//alert(formObj.dflt_search_item.value);
	formObj.searchby.value=formObj.dflt_search_item.value;

		
}

function getDefaultItmSearch1()
{
	var formObj=document.ItemSearchCriteria_Form;
	//alert(formObj.dflt_search_item1.value);
	formObj.searchby.value=formObj.dflt_search_item1.value;

}
async function callimageframe(image_filename,item_code){
	var bean_id = document.ItemsearchForm.bean_id.value;
	var bean_name = document.ItemsearchForm.bean_name.value;
	var img_path = document.ItemsearchForm.img_path.value;
	
	var imageURL= document.ItemsearchForm.img_path.value+image_filename;
		
	var dialogHeight= "30vh" ;
	var dialogWidth	= "50vw" ;
	var dialogTop = "111" ;
	var center = "1" ;
	var status="no";
	var scroll="auto";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal =await  window.showModalDialog("../../eST/jsp/ItemImageCataloguePreviewFrame.jsp?imageURL="+imageURL+"&bean_id="+bean_id+"&bean_name="+bean_name+"&item_code="+item_code+"&img_path="+img_path,arguments,features);
}
function callimagepreview(image_filename,index){		
	changeColumnColor(index);
	var imageURL= document.ViewImage.img_path.value+image_filename;
	var item_code = document.ViewImage.item_code.value;
	var bean_id = document.ViewImage.bean_id.value;
	var bean_name = document.ViewImage.bean_name.value;
	var img_path = document.ViewImage.img_path.value;
	
	parent.qryResult.location.href = "../../eST/jsp/ItemImageCataloguePreview.jsp?imageURL=" + imageURL+"&item_code="+item_code+"&bean_id="+bean_id+"&bean_name="+bean_name+"&img_path="+img_path;
}
function changeColumnColor(index) {
	//var var1="td_" + index
	var obj = eval(document.getElementById('td'));
	if (prevObj != null) {
			prevObj.className = prevColor;
	}
	prevObj = obj;	
	prevColor = obj.className;
	obj.className = "FOREDITOR";
}
