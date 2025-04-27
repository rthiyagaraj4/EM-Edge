/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var function_id = "" ;
var resultGlobal = false;
var messageGlobal = "" ;
var flagGlobal = true;
var linkContent = "";
var late_flag = false;

function create()
{
	f_query_add_mod.location.href="../../eOR/jsp/IndexOrderCareSetMain.jsp?mode=1&function_id="+function_id;
}

function query()
{
	f_query_add_mod.location.href="../../eOR/jsp/IndexOrderCareSetQueryCriteria.jsp?function_id="+function_id;
}

function apply()
{
	
	if (! checkIsValidForProceed() ) {
		var message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	var result=true;
	var formObj = f_query_add_mod.headerFrame.document.index_order_care_set_add_modify ;
	var indexType = formObj.index_type.value;
	var fields = null;
	var names = null;
	if(indexType=='F')
	{
		var formDetail = f_query_add_mod.frames[1].detailsHeaderFrame.document.form_index_care_set_detail ;
		fields = new Array (formObj.care_set_id
								,formObj.index_type
								,formDetail.facility_id
								,formDetail.source_type
								);
		names = new Array ( getLabel("eOR.OrderSet.label","OR")
								,getLabel("Common.IndexType.label","COMMON")
								,getLabel("Common.facility.label","Common")
								,getLabel("Common.SourceType.label","COMMON")
								);
	}
	else if(indexType=='D')
	{
		var formDetail = f_query_add_mod.frames[1].detailsHeaderFrame.document.form_index_care_set_detail ;
		fields = new Array (formObj.care_set_id
								,formObj.index_type
								,formDetail.diagnosis_code
								);
		names = new Array ( getLabel("eOR.OrderSet.label","OR")
								,getLabel("Common.IndexType.label","COMMON")
								,getLabel("Common.DiagnosisCode.label","Common")
								);
	}
	else
	{
		fields = new Array (formObj.care_set_id
								,formObj.index_type
								);
		names = new Array ( getLabel("eOR.OrderSet.label","OR")
								,getLabel("Common.IndexType.label","COMMON")
								);
	}
	var checked = f_query_add_mod.checkFieldsofMst( fields, names, messageFrame);
	
	if(checked)
	{
		if(indexType == "D")
			late_flag = true;
		
		var source_type = "";
		if(f_query_add_mod.frames[1].detailsHeaderFrame.document.getElementById('source_type'))
			source_type =f_query_add_mod.frames[1].detailsHeaderFrame.document.getElementById('source_type').value;
		else source_type = "";

		var facility_id = "";
		if(f_query_add_mod.frames[1].detailsHeaderFrame.document.getElementById('facility_id'))
			facility_id = f_query_add_mod.frames[1].detailsHeaderFrame.document.getElementById('facility_id').value;
		else facility_id = "";

		var diagnosis_code = "";
		if(f_query_add_mod.frames[1].detailsHeaderFrame.document.getElementById('diagnosis_code'))
			diagnosis_code = f_query_add_mod.frames[1].detailsHeaderFrame.document.getElementById('diagnosis_code').value;
		else diagnosis_code = "";

		var diag_code_scheme = "";
		if(f_query_add_mod.frames[1].detailsHeaderFrame.document.getElementById('diag_code_scheme'))
			diag_code_scheme = f_query_add_mod.frames[1].detailsHeaderFrame.document.getElementById('diag_code_scheme').value;
		else diag_code_scheme = "";

		f_query_add_mod.headerFrame.document.getElementById('source_type').value = source_type;
		f_query_add_mod.headerFrame.document.getElementById('facility_id').value = facility_id;
		f_query_add_mod.headerFrame.document.getElementById('diagnosis_code').value = diagnosis_code;
		f_query_add_mod.headerFrame.document.getElementById('diag_code_scheme').value = diag_code_scheme;

		var flag = false;
		if(source_type!="A"){
			flag  = onApplyUpdate();
			
		}else{
			flag  = true;
			late_flag= true;
		}
		
		if(flag && late_flag)
		{
			var formresult = formApply(f_query_add_mod.headerFrame.document.index_order_care_set_add_modify, OR_CONTROLLER) ;
			eval(formresult.replace("\n","")) ;
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
			if(result)
			{
				onSuccess();
			}
		}else{
			if(source_type == 'C'){
				var msg = getMessage('ATLEAST_ONE_CLINIC','OR');
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
				return false;
			}else if(source_type == 'N'){
				var msg = getMessage('ATLEAST_ONE_NUR_UNIT','OR');
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
				return false;
			}else if(source_type == 'A'){			
				var msg = getMessage('CLICK_ONE_ORDERABLE','OR');
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
				return false;
			}
			if(indexType == 'S'){			
				var msg = getMessage('ATLEAST_ONE_SERVICE','OR');
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
				return false;
			}else if(indexType == 'P'){			
				var msg = getMessage('ATLEAST_ONE_PRACTITIONER','OR');
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
				return false;
			}
		}
	}
}

function reset()
{
	
	if (f_query_add_mod.document.forms[0])
	{
		f_query_add_mod.document.forms[0].reset();
		
	}
	else
	{
		f_query_add_mod.location.href="../../eOR/jsp/IndexOrderCareSetMain.jsp?mode=1&function_id="+function_id;
	/*	var addModifyDoc = parent.frames[1].frames[1].frames[0].document.index_order_care_set_add_modify;
		addModifyDoc.reset();
		//addModifyDoc.care_set_id.disabled = false;
		//addModifyDoc.index_type.disabled = false;
		parent.frames[1].frames[1].frames[1].location.href = '../../eCommon/html/blank.html';*/
	}
}

function fillComboOptions(obj)
{
	var formObjectHeader = document.forms[0];
	var careSetSelectObject	= formObjectHeader.care_set_id;

	if(obj.value != "")
	{
		var  xmlAppend = "";
		var bean_id	= formObjectHeader.bean_id ;
		var care_set_td	= formObjectHeader.care_set_td;
		if(obj.name == "order_category" )
		{
			if(obj.value == "" )
			{
				removeOptions(formObjectHeader, careSetSelectObject);
				return ;
			}else
			{
				OrderCategory = obj.value ;
				xmlAppend += "order_category"+"=\""+OrderCategory+"\" " ;
				xmlAppend += "type"+"=\"OrderCategory\"" ;
			}
		}
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;
		xmlStr =xmlStr + xmlAppend ;
		xmlStr +=" /></root>" ;
		//alert(xmlStr);
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "IndexOrderCareSetComboFill.jsp?bean_id="+bean_id.value,false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		//alert(responseText);
		eval(responseText ) ;
	}else
	{
		removeOptions(formObjectHeader, careSetSelectObject);
	}

}

function removeOptions(formObject,comboObject)
{
	var len = comboObject.options.length;
	for(var i=0;i<len;i++)
	{
		comboObject.remove("any text");
	}
	var tp = "             --- "+getLabel("Common.defaultSelect.label","Common")+" ---             " ;
	var opt = document.createElement("OPTION");
	opt.text = tp ;
	opt.value = "" ;
	formObject.care_set_id.add(opt);
}

function addComboObject(comboObjectString,Object)
{
	var care_set_td = document.forms[0].care_set_td;
	if(Object == "order_category")
		care_set_td.innerHTML = "&nbsp;"+comboObjectString ;
}

function loadDtlFrame(obj, obj1, obj2)
{
	
	//alert(obj.value+obj1.value+obj2.value);
	if((obj.value!="") && (obj1.value!="") && (obj2.value!=""))
	{
		parent.detailFrame.location.href="../../eOR/jsp/IndexOrderCareSetDetailMain.jsp?index_type="+obj.value+"&order_category="+obj1.value+"&care_set_id="+obj2.value;
		parent.parent.frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
	else
	{	
		if(parent.frames[0].document.forms[0].index_type.value=="")
			return false;
		
		var msgFrame = parent.parent.frames[2];
		var formObj = parent.frames[0].document.forms[0];
		var fields = new Array ( formObj.order_category, formObj.care_set_id, formObj.index_type );
		var names = new Array ( getLabel("Common.OrderCategory.label","Common"), getLabel("eOR.OrderSet.label","OR"), getLabel("Common.IndexType.label","COMMON") );
		if(checkFieldsofMst( fields, names, msgFrame ))
		{
			msgFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
		}

		parent.detailFrame.location.href="../../eCommon/html/blank.html";
	}
}

function dispLink(obj)
{

	var order_category	= document.forms[0].order_category.value;
	

	var care_set_id	= document.forms[0].care_set_id.value;

	var index_type		= document.forms[0].index_type.value;

	var facility_id ="";
	var buttonVal = obj;
	if(buttonVal == "S")
	{
		document.getElementById("SelectTab").className="clicked";
		document.getElementById("AssociateTab").className="normal";
	}else if(buttonVal == "A")
	{
		document.getElementById("SelectTab").className="normal";
		document.getElementById("AssociateTab").className="clicked";
	}
	var formObjAddMod = parent.parent.frames[0].document.forms[0];

	formObjAddMod.care_set_id.disabled=true;
	formObjAddMod.index_type.disabled=true;

	if(parent.frames[0].location.href.indexOf("index_type=F") != -1)
	{
		var formObjDtl = parent.frames[0].document.forms[0];
		facility_id = parent.frames[0].document.forms[0].facility_id.value;
		formObjDtl.facility_id.disabled=true;
		formObjDtl.source_type.disabled=true;
	}
	document.forms[0].tabVal.value = buttonVal;

	if(parent.frames[1].location.href.indexOf(".jsp") != -1)
		var flag = latestUpdate();

	if(linkContent=="")
			linkContent	=	document.getElementById("linkId").innerHTML;

	if(buttonVal=="A")
	{
		
		document.getElementById("linkId").className ="";
		document.getElementById("linkId").innerHTML = "&nbsp;";
		parent.frames[1].location.href="../../eOR/jsp/IndexOrderCareSetDetailResult.jsp?tabVal="+buttonVal+"&order_category="+order_category+"&care_set_id="+care_set_id+"&index_type="+index_type+"&fac_id="+facility_id;
	}
	else
	{
		parent.frames[1].location.href="../../eCommon/html/blank.html";
		document.getElementById("linkId").innerHTML = linkContent;
		parent.parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
}

function onDiagCodeLoad()
{
	var formObjAddMod = parent.parent.frames[0].document.forms[0];
	formObjAddMod.order_category.disabled=true;
	formObjAddMod.care_set_id.disabled=true;
	formObjAddMod.index_type.disabled=true;
}

function callOnAlphaLink(obj, obj1)
{
	changeAlphaColor(obj1);
	var formObjAddMod = parent.parent.frames[0].document.forms[0];
	var formObjDtl = parent.frames[0].document.forms[0];
	var obj2 = document.forms[0].index_type;
	var obj3 = document.forms[0].tabVal;
	var obj4 = document.forms[0].order_category;
	var obj5 = document.forms[0].care_set_id;
	if(parent.frames[1].location.href.indexOf(".jsp") != -1)
	{
		var flag = latestUpdate();
	}
	if(obj!="")
	{
		var fac_id="";
		if((obj2.value=="C")||(obj2.value=="N"))
		{
			//alert(document.getElementById("facility_id"));
			fac_id = document.getElementById("facility_id").value;
			if(fac_id != ""){
				parent.detailResultFrame.location.href="../../eOR/jsp/IndexOrderCareSetDetailResult.jsp?pract_index="+obj+"&index_type="+obj2.value+"&fac_id="+fac_id+"&tabVal=S&order_category="+obj4.value+"&care_set_id="+obj5.value;
				formObjAddMod.order_category.disabled=true;
				formObjAddMod.care_set_id.disabled=true;
				formObjAddMod.index_type.disabled=true;
				formObjDtl.facility_id.disabled=true;
				formObjDtl.source_type.disabled=true;
				parent.parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
			}
			else{
				var msg =getMessage("FACILITY_BLANK","OR");
				alert(msg);
				parent.parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
			}
		}
		else if((obj2.value=="P")||(obj2.value=="S")){
			parent.detailResultFrame.location.href="../../eOR/jsp/IndexOrderCareSetDetailResult.jsp?pract_index="+obj+"&index_type="+obj2.value+"&tabVal=S&order_category="+obj4.value+"&care_set_id="+obj5.value;
			formObjAddMod.order_category.disabled=true;
			formObjAddMod.care_set_id.disabled=true;
			formObjAddMod.index_type.disabled=true;
			parent.parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
	}
	else
		parent.detailResultFrame.location.href="../../eCommon/html/blank.html";
		//parent.parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
}

function latestUpdate()
{
	var bean_id	= parent.detailResultFrame.document.form_index_care_set_detail_result.bean_id.value;
	var bean_name = parent.detailResultFrame.document.form_index_care_set_detail_result.bean_name.value;
	var fm_disp	= parent.detailResultFrame.document.form_index_care_set_detail_result.fm_disp.value;
	var to_disp	= parent.detailResultFrame.document.form_index_care_set_detail_result.to_disp.value;
	var tabVal = parent.detailResultFrame.document.form_index_care_set_detail_result.tabVal.value;
	var value_str = "";

	fm_disp = parseInt(fm_disp);
	to_disp = parseInt(to_disp);

	for(i=fm_disp; i<=to_disp; i++)
	{
		var value = eval('parent.detailResultFrame.document.form_index_care_set_detail_result.select_yn' + i);
			if(!value.disabled)
			{
				if(value.checked){
					val = "Y";
					//late_flag=true;
				}else
					val = "N";
			}
			else
				val ="N";

			value_str += val+"~";
	}
	var xmlStr ="<root><SEARCH ";
	xmlStr += " INDEX_VALUES=\""+ value_str + "\" ";
	xmlStr += " FROM_VALUE=\""+ fm_disp + "\" ";
	xmlStr += " TO_VALUE=\""+ to_disp + "\" ";
	xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
	xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
	xmlStr += " TAB_VALUE=\""+ tabVal + "\" ";
	xmlStr +=" /></root>";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","IndexOrderCareSetValidate.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
	return true;
}

function callSourceDtl(obj)
{

	var hdrAddModForm	= parent.parent.frames[0].document.forms[0];
	var order_cat		= hdrAddModForm.order_category.value;
	var care_set_id		= hdrAddModForm.care_set_id.value;
	var index_type		= hdrAddModForm.index_type.value;
	var detailForm		= document.form_index_care_set_detail;
	var facility_id		= document.getElementById("facility_id").value;
	var source_type		= document.getElementById("source_type").value;
	var msgFrame = parent.parent.parent.frames[2];
	var fields = new Array ( hdrAddModForm.order_category
							,hdrAddModForm.care_set_id
							,hdrAddModForm.index_type
							,detailForm.facility_id
							,detailForm.source_type
							);
	var names = new Array ( getLabel("Common.OrderCategory.label","Common")
							,getLabel("eOR.CareSet.label","OR")
							,getLabel("Common.IndexType.label","COMMON")
							,getLabel("Common.facility.label","Common")
							,getLabel("Common.SourceType.label","COMMON")
							);
	if(checkFieldsofMst( fields, names, msgFrame))
	{
		msgFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
		document.getElementById("index_type").value=obj.value;
		var rowSelAssTab = document.getElementById("rowSelAssTab");
		var rowLinkTab = document.getElementById("rowLinkTab");

		if(obj.value == "N" || obj.value=="C")
		{
			rowSelAssTab.style.visibility='visible';
			rowLinkTab.style.visibility='visible';
		}else if(obj.value == "A"){
			rowSelAssTab.style.visibility='hidden';
			rowLinkTab.style.visibility='hidden';
		}

		if(parent.frames[1].location.href.indexOf(".jsp") != -1){
			parent.frames[1].location.href="../../eCommon/html/blank.html";
		}
	}
}

function checkVal(obj){
	document.forms[0].dispMode.value = obj;
	document.forms[0].submit();
}

function onApplyUpdate(){
	
	var refForm = f_query_add_mod.detailFrame.detailResultFrame.document.forms[0];
	
	
	//alert("refForm="+refForm.name);
	var formObj = f_query_add_mod.headerFrame.document.index_order_care_set_add_modify ;
	var formDetail = f_query_add_mod.frames[1].detailsHeaderFrame.document.form_index_care_set_detail ;
	
	var care_set_id		= formObj.care_set_id.value;
	var index_type		= formObj.index_type.value;
	var facility_id		= "";
	if(formDetail.facility_id !=null){
		facility_id = f_query_add_mod.frames[1].detailsHeaderFrame.document.getElementById("facility_id").value;
		index_type = f_query_add_mod.frames[1].detailsHeaderFrame.document.getElementById("source_type").value;
	}
	
	if(f_query_add_mod.detailFrame.detailResultFrame.location.href.indexOf(".jsp") != -1){

		var bean_id		= refForm.bean_id.value;
		var bean_name	= refForm.bean_name.value;
		var fm_disp		= refForm.fm_disp.value;
		var to_disp		= refForm.to_disp.value;
		var tabVal		= refForm.tabVal.value;
		var value_str	= "";

		fm_disp = parseInt(fm_disp);
		to_disp = parseInt(to_disp);

		for(i=fm_disp; i<=to_disp; i++){
			var value = eval('f_query_add_mod.detailFrame.detailResultFrame.select_yn'+i);
			if(!value.disabled){
				if(value.checked){
					val = "Y";
					//late_flag = true;
				}else
					val = "N";
				}
				else
					val ="N";

			value_str += val+"~";
		}
		//alert("value_str="+value_str);
		var xmlStr ="<root><SEARCH ";
		xmlStr += " INDEX_VALUES=\""+ value_str + "\" ";
		xmlStr += " FROM_VALUE=\""+ fm_disp + "\" ";
		xmlStr += " TO_VALUE=\""+ to_disp + "\" ";
		xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
		xmlStr += " TAB_VALUE=\""+ tabVal + "\" ";
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","IndexOrderCareSetValidate.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		eval( responseText ) ;
		return true;
	}
	else
	{	
		var xmlStr ="<root><SEARCH ";
		var tmp_bean_id = "indexordercareset";
		var tmp_bean  = "eOR.IndexOrderCareSetBean";
		xmlStr += " CARE_SET_ID=\""+ care_set_id + "\" ";
		xmlStr += " INDEX_TYPE=\""+ index_type + "\" ";
		xmlStr += " FACILITY_ID=\""+ facility_id + "\" ";
		xmlStr += " BEAN_ID=\""+ tmp_bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ tmp_bean + "\" ";
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","IndexOrderCareSetValidate.jsp?chkflag=CHECK_RECORDS",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		return true;
	}
}
function setRecordsFlag(){
	
	late_flag= true;
}
function setFlag(){

	late_flag= false;
}
function onSuccess()
{

	f_query_add_mod.headerFrame.location.href="../../eOR/jsp/IndexOrderCareSetAddModify.jsp?mode="+MODE_INSERT;
	f_query_add_mod.detailFrame.detailsHeaderFrame.location.href="../../eCommon/html/blank.html";
	f_query_add_mod.detailFrame.detailResultFrame.location.href="../../eCommon/html/blank.html";
	

}

async function show_diagnosis_window(scheme, scheme_code)
{
	var retVal = ""; //new String();
	var dialogHeight= "28" ;
	var dialogWidth	= "43" ;
	var status = "no";
	var arguments	= "" ;
	var search_code="";
	var search_desc="";
	var tit="Diagnosis";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll:no; status:" + status;
	retVal = await window.showModalDialog("../../eCA/jsp/PaintConsultationFrame.jsp?p_diag_code="+scheme+"&p_diag_scheme_desc="+scheme_code+"&p_auth_yn=Y&title=Diagnosis&cause_indicator=",arguments,features);
	if (!(retVal == null))
	{
		var vals=retVal.split("/")	;
		parent.detailsHeaderFrame.document.form_index_care_set_detail.diagnosis_code.value=unescape(vals[0]);
	}
	onDiagCodeLoad();
}

async function show_pat_diagnosis_window(){
    var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;



	argumentArray[0]   = parent.detailsHeaderFrame.document.form_index_care_set_detail.pat_diagnosis_sql.value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	//argumentArray[5]   = target.value ;
	argumentArray[5]   = "" ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;


	retVal = await CommonLookup( getLabel("eOR.PatientDiagnosis.label","OR"),argumentArray );

	if(retVal != null && retVal != ""){
       parent.detailsHeaderFrame.document.form_index_care_set_detail.diagnosis_code.value=retVal[0];
	   //detailLowerForm.all.discr_msr_panel_id_desc.value=retVal[1];
    }
    onDiagCodeLoad();
}

function assignResult(res,msg,mod, dummy){
	resultGlobal = res ;
	messageGlobal = msg ;
	flagGlobal = mod;
}

function checkIsValidForProceed()
{
		 var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;
}
async function show_window()
{
	var scheme="";
	var scheme_desc = document.forms[0].diag_code_scheme.value;
	
	if(scheme_desc=="ICD10")
	{
		scheme=1;
	}
	else
	{
		scheme=2;
	}
	var Encounter_Id= "";
	var p_auth_yn="N";

	if (scheme == 5)
	{
		var retVal = "test Value";
		var dialogHeight= "400px" ;
		var dialogWidth = "700px" ;
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
		var arguments   = "" ;
		retVal = await window.showModalDialog("../../eCA/html/eCISLUE.html",arguments,features);

		var arr = new Array();
		arr = retVal.split("|");
		var stra = arr[0];
		var strc = arr[1];
		var strb = arr[2];

		
	}

	if (scheme == 1 || scheme == 2)
	{
		var retVal =    new String();
		var dialogHeight= "400px" ;
		var dialogWidth = "700px" ;
		var status = "no";

		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	
		//var cause_ind='';
		//if(scheme=="2")
			//cause_ind=document.forms[0].cause_ind.value
		function_id="ca_diagnosis";
		retVal = await  window.showModalDialog("../../eMR/jsp/PaintConsultationFrame.jsp?title="+scheme_desc+"&CodeList&p_diag_code="+scheme+"&term_set_id="+scheme_desc+"&function_id="+function_id+"&p_diag_scheme_desc="+scheme_desc+"&Encounter_Id="+Encounter_Id+"&p_auth_yn="+p_auth_yn+"&cause_indicator=",arguments,features);
		var ret1=unescape(retVal);
		if (!(retVal == null))
		{
			var retdata;
			if(scheme=="2")
			{
				retdata	= ret1.split["/"] ;
				retVal	= retdata[0];
			}

			document.forms[0].diagnosis_code.value=retVal;
			var bean_id	= document.forms[0].bean_id.value ;
			
			var  xmlAppend = "";
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlStr ="<root><SEARCH " ;
			xmlStr =xmlStr + xmlAppend ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "IndexOrderCareSetComboFill.jsp?bean_id="+bean_id+"&term_code="+retVal+"&validate=TERMDESC",false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			eval(responseText ) ;

		}
		//eval("document.forms[0].recodedCode"+j).focus();
	}
}
function termdesc(desc)
{
		document.forms[0].diagnosis_code_desc.value=desc;
}
