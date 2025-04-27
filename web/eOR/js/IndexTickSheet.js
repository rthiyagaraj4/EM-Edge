/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------
?           100            	?           	?				?					created
09/10/2014	IN050655		VijayakumarK	09/10/2014							iASSIST ID : 807002 Index Tick sheet by practitioner is a 
																				good functionality to provide personalised tick sheets to practitioners.
------------------------------------------------------------------------------------------------------------------------------------------
*/
var function_id = "" ;
var resultGlobal = false;
var messageGlobal = "" ;
var flagGlobal = true;
var linkContent = "";
var chk_Valflag = false;
var rdSearch = 'D';  //IN050655

function create() {
	f_query_add_mod.location.href="../../eOR/jsp/IndexTickSheetMain.jsp?mode="+MODE_INSERT+"&function_id="+function_id;
}

function query() {
	f_query_add_mod.location.href="../../eOR/jsp/IndexTickSheetQueryCriteria.jsp?function_id="+function_id;
}


async function apply(){
	if (! checkIsValidForProceed() ) {
		var message  = getMessage("NOT_VALID",'OR');
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	var result=true;
	//All the Frame Ref has to be replaced with Frame name.
	//alert(parent.frames[1].frames[1].frames[0].document.forms[0].name);//addMod Frame.
	//alert(parent.frames[1].frames[1].frames[1].frames[0].document.forms[0].name);//Details Frame;
	//alert(parent.frames[1].frames[1].frames[1].frames[1].document.forms[0].name);//Result Frame

	var formObj = f_query_add_mod.headerFrame.document.formIndexTickShAddMod ;
	var fields = new Array ( formObj.order_category
							,formObj.tick_sheet_id
							,formObj.index_type
							);
	var names = new Array ( getLabel("Common.OrderCategory.label","Common")
							,getLabel("eOR.TickSheet.label","OR")
							,getLabel("eOR.IndexType.label","OR")
							);

  if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
   {
	  var source_type = f_query_add_mod.frames[1].frames[0].document.forms[0].source_type.value;
	  var facility_id = f_query_add_mod.frames[1].frames[0].document.forms[0].facility_id.value;
	  f_query_add_mod.frames[0].document.forms[0].source_type.value = source_type;
	  f_query_add_mod.frames[0].document.forms[0].facility_id.value = facility_id;

	  /****	ADDED BY PRASHANT -TO Check  faclity and Source Type Madatory when   Index Type is Selected as Source*************/
	  if(formObj.index_type.value == "F"){
	     var fields = new Array ( formObj.facility_id,formObj.source_type);
		 var names = new Array ( getLabel("Common.facility.label","Common"),getLabel("Common.SourceType.label","COMMON"));
	     if(!f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)){
			 return ;
		 }
	  }
	 /***/
		var flag = false;
		if(source_type!="A"){
			flag  = onApplyUpdate();
			
		}else{
			flag  = true;
			chk_Valflag  = true;
		}
			
		if(flag && chk_Valflag){
			//alert( formApply(f_query_add_mod.headerFrame.document.formIndexTickShAddMod));
			eval( formApply(f_query_add_mod.headerFrame.document.formIndexTickShAddMod,OR_CONTROLLER) ) ;
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
			if(result){
				onSuccess();
			}
		}else{
			
			var indexType = formObj.index_type.value;
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

function assignResult(res,msg,mod){
	resultGlobal = res ;
	messageGlobal = msg ;
	flagGlobal = mod;
	//alert(flagGlobal);
}

function onSuccess()
{
	//parent.frames[1].frames[1].frames[0].document.forms[0].reset();//addMod Frame.
	f_query_add_mod.frames[0].location.href="../../eOR/jsp/IndexTickSheetAddModify.jsp?mode="+MODE_INSERT;
	f_query_add_mod.frames[1].frames[0].location.href="../../eCommon/html/blank.html";
	f_query_add_mod.frames[1].frames[1].location.href="../../eCommon/html/blank.html";
}

function loadDtlFrame(obj, obj1, obj2){
	
	if((obj.value!="") && (obj1.value!="") && (obj2.value!="")){
		parent.detailFrame.location.href="../../eOR/jsp/IndexTickSheetDetailMain.jsp?index_type="+obj.value+"&order_category="+obj1.value+"&tick_sheet_id="+obj2.value;
	}
	else{
		var msgFrame = parent.parent.frames[2];
		var formObj = parent.frames[0].document.forms[0];
		var fields = new Array ( formObj.order_category
						,formObj.tick_sheet_id
						,formObj.index_type
						);
		var names = new Array ( getLabel("Common.OrderCategory.label","Common")
				,getLabel("eOR.TickSheet.label","OR")
				,getLabel("eOR.IndexType.label","OR")
				);
		if(checkFieldsofMst( fields, names, msgFrame)) {
			msgFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
		}

		parent.detailFrame.location.href="../../eCommon/html/blank.html";
	}
}

async function dispLink(obj){
	var order_category	= document.forms[0].order_category.value;
	var tick_sheet_id	= document.forms[0].tick_sheet_id.value;
	var index_type		= document.forms[0].index_type.value;
	//IN050655 starts
	var source_type 	= "";
	source_type 	= await document.formIndexTickShDetail.source_type.value;
	//IN050655 ends
	var facility_id ="";
	var buttonVal = obj;
	if(buttonVal == "S"){
		document.getElementById('SelectTab').className="clicked";
		document.getElementById('AssociateTab').className="normal";
	}else if(buttonVal == "A"){
		//document.forms[0].SelectTab.className='normal';
		document.getElementById('SelectTab').className='normal';
		//document.forms[0].SelectTab.className="normal";
		document.getElementById('SelectTab').className="normal";
		document.getElementById('AssociateTab').className="clicked";
	}
	var formObjAddMod = parent.parent.frames[0].document.forms[0];
	formObjAddMod.order_category.disabled=true;
	formObjAddMod.tick_sheet_id.disabled=true;
	formObjAddMod.index_type.disabled=true;

	if(parent.frames[0].location.href.indexOf("index_type=F") != -1){
		var formObjDtl = parent.frames[0].document.forms[0];
		facility_id = parent.frames[0].document.forms[0].facility_id.value;
		formObjDtl.facility_id.disabled=true;
		formObjDtl.source_type.disabled=true;
	}
	document.forms[0].tabVal.value = buttonVal;

	if(parent.frames[1].location.href.indexOf(".jsp") != -1){
		var flag = latestUpdate();
	}
	if(linkContent=="")
			linkContent	=	document.getElementById("linkId").innerHTML;

	if(buttonVal=="A"){
	document.getElementById('linkId').className ="";
	document.getElementById('linkId').innerHTML = "&nbsp;";
	document.getElementById('tbsrch_row').style.display = "none";//IN050655
	
	//IN050655 starts
	if(index_type == "F")
		parent.document.getElementsByTagName('frameset').rows = "15%,65%";
	else
		parent.document.getElementsByTagName('frameset').rows = "6%,79%";
	//IN050655 ends
	
	//parent.frames[1].location.href="../../eOR/jsp/IndexTickSheetDetailResult.jsp?tabVal="+buttonVal+"&order_category="+order_category+"&tick_sheet_id="+tick_sheet_id+"&index_type="+index_type+"&fac_id="+facility_id;
	parent.frames[1].location.href="../../eOR/jsp/IndexTickSheetDetailResult.jsp?tabVal="+buttonVal+"&order_category="+order_category+"&tick_sheet_id="+tick_sheet_id+"&index_type="+index_type+"&fac_id="+facility_id+"&source_type="+source_type;
	
	}else{
	parent.frames[1].location.href="../../eCommon/html/blank.html";
	document.getElementById('linkId').innerHTML = linkContent;
	//IN050655 starts
	if(index_type == "F")
		parent.document.getElementsByTagName("frameset")[0].rows = "*,65%";
	else
		//parent.document.getElementsByTagName("frameset")[0].rows = "*,79%";
	document.getElementById('tbsrch_row').style.display = "";
	//IN050655 ends
	parent.parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
}

function callOnAlphaLink(obj, obj1){
	changeAlphaColor(obj1);
	var formObjAddMod = parent.parent.frames[0].document.forms[0];
	var formObjDtl = parent.frames[0].document.forms[0];
	//alert(formObjAddMod.name);
	//alert(formObjDtl.name);
	var obj2 = document.forms[0].index_type;
	var obj3 = document.forms[0].tabVal;
	var obj4 = document.forms[0].order_category;
	var obj5 = document.forms[0].tick_sheet_id;
	var source_type =""; //IN050655
	if(parent.frames[1].location.href.indexOf(".jsp") != -1){
		var flag = latestUpdate();
	}
	if(obj!=""){
		var fac_id="";
		//if((obj2.value=="C")||(obj2.value=="N")){ //IN050655
		if((obj2.value=="F")){ //IN050655
//		source_type = document.formIndexTickShDetail.all.source_type.value; //IN050655
			source_type = document.formIndexTickShDetail.source_type.value;
			fac_id = document.formIndexTickShDetail.facility_id.value;
			if(fac_id != ""){
				//parent.detailResultFrame.location.href="../../eOR/jsp/IndexTickSheetDetailResult.jsp?pract_index="+obj+"&index_type="+obj2.value+"&fac_id="+fac_id+"&tabVal=S&order_category="+obj4.value+"&tick_sheet_id="+obj5.value;//IN050655
				parent.detailResultFrame.location.href="../../eOR/jsp/IndexTickSheetDetailResult.jsp?pract_index="+obj+"&index_type="+obj2.value+"&fac_id="+fac_id+"&tabVal=S&order_category="+obj4.value+"&tick_sheet_id="+obj5.value+"&source_type="+source_type;//IN050655
				formObjAddMod.order_category.disabled=true;
				formObjAddMod.tick_sheet_id.disabled=true;
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
			parent.detailResultFrame.location.href="../../eOR/jsp/IndexTickSheetDetailResult.jsp?pract_index="+obj+"&index_type="+obj2.value+"&tabVal=S&order_category="+obj4.value+"&tick_sheet_id="+obj5.value;
			formObjAddMod.order_category.disabled=true;
			formObjAddMod.tick_sheet_id.disabled=true;
			formObjAddMod.index_type.disabled=true;
			parent.parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
	}
	else
		parent.detailResultFrame.location.href="../../eCommon/html/blank.html";
		//parent.parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
}

function callSourceDtl(obj){
	
	var hdrAddModForm = parent.parent.frames[0].document.forms[0];
	var order_cat		= hdrAddModForm.order_category.value;
	var tick_sheet_id	= hdrAddModForm.tick_sheet_id.value;
	var index_type		= hdrAddModForm.index_type.value;

	var facility_id		= document.getElementById('facility_id').value;
	var source_type		= document.getElementById('source_type').value;

	var msgFrame = parent.parent.parent.frames[2];
	var fields = new Array ( hdrAddModForm.order_category
						,hdrAddModForm.tick_sheet_id
						,hdrAddModForm.index_type
						,document.formIndexTickShDetail.facility_id
						,document.formIndexTickShDetail.source_type
						);
	var names = new Array (getLabel("Common.OrderCategory.label","Common")
						,getLabel("eOR.TickSheet.label","OR")
						,getLabel("eOR.IndexType.label","OR")
						,getLabel("Common.facility.label","Common")
						,getLabel("Common.SourceType.label","COMMON")
						);
	if(checkFieldsofMst( fields, names, msgFrame)) {
		msgFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
		//document.formIndexTickShDetail.all.index_type.value=obj.value;//IN050655 commented
		var rowSelAssTab = document.getElementById('rowSelAssTab');
		var rowLinkTab = document.getElementById('rowLinkTab');
		var tbsrch_row =  document.getElementById('tbsrch_row');//IN050655
		if(obj.value == "N" || obj.value=="C"){
			rowSelAssTab.style.visibility='visible';
			rowLinkTab.style.visibility='visible';
			tbsrch_row.style.visibility='visible';//IN050655
		}else if(obj.value == "A"){
			rowSelAssTab.style.visibility='hidden';
			rowLinkTab.style.visibility='hidden';
			tbsrch_row.style.visibility='hidden';//IN050655
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

function fillComboOptions(obj) {
	var formObjectHeader    = document.forms[0];
	if(obj.value != ""){
		var  xmlAppend = "";
		var bean_id			= formObjectHeader.bean_id ;
		var tick_sheet_opt	= formObjectHeader.tick_sheet_opt;
		if(obj.name == "order_category" ){
			if(obj.value == "" ){
				removeOptions(tick_sheet_opt ,"tickSheetOption");
				return ;
			}else{
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
		xmlHttp.open( "POST", "IndexTickSheetComboFill.jsp?bean_id="+bean_id.value,false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		//alert(responseText);
		eval(responseText ) ;
	}else{
			removeOptions(document,document.forms[0].tick_sheet_id ,"tickSheetID");
	}

}


function removeOptions(formObject,comboObject,optionName) {
	var len = comboObject.length;
	for(var i=0;i<len;i++){
		formObject.forms[0].tick_sheet_id.remove("tick_sheet_id");
	}
	var tp = "           --- "+getLabel("Common.defaultSelect.label","Common")+" ---            " ;
	var opt = formObject.createElement("OPTION");
	opt.text = tp ;
	opt.value = "" ;
	formObject.forms[0].tick_sheet_id.add(opt);
}


function addComboObject(comboObjectString,Object){
	var tick_sheet_opt		= 	document.getElementById('tick_sheet_opt');
	comboObjectString = comboObjectString.replace('Select',getLabel("Common.defaultSelect.label","Common"));
	if(Object == "order_category")
		tick_sheet_opt.innerHTML = comboObjectString ;
}


function latestUpdate(){
	var bean_id		= parent.detailResultFrame.document.formIndexTickShDetailResult.bean_id.value;
	var bean_name	= parent.detailResultFrame.document.formIndexTickShDetailResult.bean_name.value;
	var fm_disp		= parent.detailResultFrame.document.formIndexTickShDetailResult.fm_disp.value;
	var to_disp		= parent.detailResultFrame.document.formIndexTickShDetailResult.to_disp.value;
	var tabVal		= parent.detailResultFrame.document.formIndexTickShDetailResult.tabVal.value;
	var source_type		= parent.detailResultFrame.document.formIndexTickShDetailResult.source_type.value;//IN050655
	var value_str	= "";

	fm_disp = parseInt(fm_disp);
	to_disp = parseInt(to_disp);
	
	for(i=fm_disp; i<=to_disp; i++){
		var value = eval('parent.detailResultFrame.document.formIndexTickShDetailResult.select_yn'+i);
			if(!value.disabled){
				if(value.checked){
					val = "Y";
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
		xmlStr += " SOURCE_TYPE=\""+ source_type + "\" ";//IN050655
		xmlStr +=" /></root>";
		//alert(xmlStr);
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","IndexTickSheetValidate.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		eval( responseText ) ;
		return true;
	
	}


function onApplyUpdate(){
	
	var refForm = f_query_add_mod.frames[1].frames[1].document.forms[0];
	var formObj = f_query_add_mod.headerFrame.document.formIndexTickShAddMod ;
	var formDetail = f_query_add_mod.frames[1].detailsHeaderFrame.document.formIndexTickShDetail ;
	
	var order_category		= formObj.order_category.value;
	var tick_sheet_id		= formObj.tick_sheet_id.value;
	var index_type		= formObj.index_type.value;
	var source_type		= formObj.source_type.value;//IN050655
	
	var facility_id		= "";
	if(formDetail.facility_id !=null ){
		facility_id = formDetail.facility_id.value;
		//IN050655 starts
		/*if(formDetail.source_type.value !="")
			index_type = formDetail.source_type.value;*/
		//IN050655 ends
	}
	//alert("===="+order_category+"="+tick_sheet_id+"=Ind=111="+index_type+"====="+facility_id);
	//alert(refForm.name);
	if(f_query_add_mod.frames[1].frames[1].location.href.indexOf(".jsp") != -1){

		var bean_id		= refForm.bean_id.value;
		var bean_name	= refForm.bean_name.value;
		var fm_disp		= refForm.fm_disp.value;
		var to_disp		= refForm.to_disp.value;
		var tabVal		= refForm.tabVal.value;
		var value_str	= "";

		fm_disp = parseInt(fm_disp);
		to_disp = parseInt(to_disp);
		
		for(i=fm_disp; i<=to_disp; i++){
			var value = eval('f_query_add_mod.frames[1].frames[1].document.forms[0].select_yn'+i);
			if(!value.disabled){
				if(value.checked){
					val = "Y";
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
		//alert(xmlStr);
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","IndexTickSheetValidate.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		eval( responseText ) ;
		return true;
	}
	else
	{
		var xmlStr ="<root><SEARCH ";
		var tmp_bean_id = "indexticksheet";
		var tmp_bean  = "eOR.IndexTickSheet";
		xmlStr += " ORDER_CATEGORY=\""+ order_category + "\" ";
		xmlStr += " TICK_SHEET_ID=\""+ tick_sheet_id + "\" ";
		xmlStr += " INDEX_TYPE=\""+ index_type + "\" ";
		xmlStr += " FACILITY_ID=\""+ facility_id + "\" ";
		xmlStr += " BEAN_ID=\""+ tmp_bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ tmp_bean + "\" ";
		xmlStr += " SOURCE_TYPE=\""+ source_type + "\" ";//IN050655
		xmlStr +=" /></root>";
		//alert(xmlStr);
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","IndexTickSheetValidate.jsp?chkflag=CHECK_RECORDS",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		eval( responseText ) ;
		return true;
	}
}

function setRecordsFlag(){
	chk_Valflag = true;
}
function setFlag(){
	chk_Valflag= false;count=0;
}
function reset()
{
	if (f_query_add_mod.document.forms[0]!=null)
	{
		f_query_add_mod.document.forms[0].reset();
	}

	// if(parent.frames[1].frames[1].frames[0]!=null)
	if (f_query_add_mod.location.href.indexOf("IndexTickSheetMain.jsp") !=-1)
		 {
		var addModifyDoc = f_query_add_mod.frames[0].document.forms[0];
//	alert(addModifyDoc.name);
		addModifyDoc.reset();
		addModifyDoc.order_category.disabled = false;
		addModifyDoc.tick_sheet_id.disabled = false;
		addModifyDoc.index_type.disabled = false;
		f_query_add_mod.frames[1].location.href = '../../eCommon/html/blank.html';
	}
	else
	{
		commontoolbarFrame.location.reload();
		return false;
	}

/*	parent.frames[1].frames[1].frames[0].location.href="../../eOR/jsp/IndexTickSheetAddModify.jsp?mode="+MODE_INSERT;
	if(parent.frames[1].frames[1].frames[1].frames[0].location.href.indexOf(".jsp") != -1)
		parent.frames[1].frames[1].frames[1].frames[0].location.href="../../eCommon/html/blank.html";
	if(parent.frames[1].frames[1].frames[1].frames[1].location.href.indexOf(".jsp") != -1)
		parent.frames[1].frames[1].frames[1].frames[1].location.href="../../eCommon/html/blank.html";
*/
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
//IN050655 starts
function searchByRd(cur_rd) {
    rdSearch=cur_rd.value
}

function searchText(obj){
	
	var formObjAddMod = parent.parent.frames[0].document.forms[0];
	var search_code = "";
	var search_desc	= "";
	var title			= "";
	var sql = "";
	var obj2 = document.forms[0].index_type;
	var obj3 = document.forms[0].tabVal;
	var obj4 = document.forms[0].order_category;
	var obj5 = document.forms[0].tick_sheet_id;
	var source_type = "";
	
	var l_search_by 	= document.formIndexTickShDetail.search_criteria.value;
	var l_search_txt 	= encodeURIComponent(document.formIndexTickShDetail.search_text.value);
	var fac_id="";
	if(parent.frames[1].location.href.indexOf(".jsp") != -1){
		var flag = latestUpdate();
	}
		if(obj2.value=="F"){
			fac_id = document.formIndexTickShDetail.facility_id.value;
			source_type = document.formIndexTickShDetail.source_type;

			if(fac_id != "" || fac_id != null){
				parent.detailResultFrame.location.href="../../eOR/jsp/IndexTickSheetDetailResult.jsp?pract_index="+obj+"&index_type="+obj2.value+"&source_type="+source_type.value+"&tabVal=S&order_category="+obj4.value+"&tick_sheet_id="+obj5.value+'&p_search_by='+l_search_by+'&p_search_txt='+l_search_txt+'&p_filter_opt=S&p_radioval='+rdSearch+'&fac_id='+fac_id;
				parent.parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
			}
			else
			{
				var msg =getMessage("FACILITY_BLANK","OR");
				alert(msg);
				parent.parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
			}
		}else{
				parent.detailResultFrame.location.href="../../eOR/jsp/IndexTickSheetDetailResult.jsp?pract_index="+obj+"&index_type="+obj2.value+"&tabVal=S&order_category="+obj4.value+"&tick_sheet_id="+obj5.value+'&p_search_by='+l_search_by+'&p_search_txt='+l_search_txt+'&p_filter_opt=S&p_radioval='+rdSearch+'&fac_id=';
				parent.parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
		
}
function resetQueryForm(){
	document.getElementById('rdCode').checked = false;
	document.getElementById('rdDesc').checked = true;
	
	document.formIndexTickShDetail.search_criteria.selectedIndex=0;
	document.formIndexTickShDetail.search_text.value = '';
	parent.detailResultFrame.location.href = '../../eCommon/html/blank.html';
	parent.parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
}
//IN050655 ends
