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
//**var chk_Valflag = false;

function apply(){
	if (! checkIsValidForProceed() ) {
		var message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}

	//var result=true;
	var formObj = f_query_add_mod.headerFrame.document.formMultiFacilityProcessingHdr;
	var	fields = new Array ( formObj.ordering_facility_id,formObj.source_type_code
						,formObj.source_location_code,formObj.order_category
						,formObj.order_type_code,formObj.performing_facility_id);

	var	names =	new	Array (getLabel("Common.OrderingFacility.label","COMMON"),getLabel("Common.SourceType.label","COMMON"),getLabel("eOR.SourceLocation.label","OR")
				,getLabel("Common.OrderCategory.label","Common"),getLabel("Common.OrderType.label","Common"),getLabel("Common.PerformingFacility.label","COMMON"));
				
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)){
		var flag = true;
		//alert(formObj.order_type_code.value);
		if (formObj.order_type_code.value == "ALL" && formObj.ordering_facility_id.value == formObj.performing_facility_id.value) {
			fields 	= new Array(formObj.performing_facility_lo);
			names	= new Array (getLabel("Common.PerformingLocation.label","COMMON"));
			
			if(!f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)){
				flag = false;
			}
		}
		//alert("###flag="+flag);
		if (flag)
			flag = onApplyUpdate();
		//**if(flag && chk_Valflag){
		if(flag){
			//alert( formApply(f_query_add_mod.headerFrame.document.formMultiFacilityProcessingHdr));
			//alert('$$$$$$$$here');
			//alert("11111111");
   	   			eval( formApply(f_query_add_mod.headerFrame.document.formMultiFacilityProcessingHdr, OR_CONTROLLER) ) ;
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+messageGlobal;
				
			if(resultGlobal){
				onSuccess();
			}
		}/*else{
			var msg = getMessage('CLICK_ONE_ORDERABLE',"OR");
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
			return false;
		}*/
	}
}

function create(){
	f_query_add_mod.location.href='../../eOR/jsp/MultiFacilityProcessingMain.jsp?mode='+MODE_INSERT+"&function_id="+function_id;
}

function query(){
	f_query_add_mod.location.href='../../eOR/jsp/MultiFacilityProcessingQueryCriteria.jsp?function_id='+function_id;
}

function onSuccess(){
	f_query_add_mod.frames[0].location.href="../../eOR/jsp/MultiFacilityProcessingHdr.jsp?mode="+MODE_INSERT;
	f_query_add_mod.frames[1].location.href="../../eCommon/html/blank.html";
}

function reset(){
	//create();
	if (f_query_add_mod.headerFrame != null || f_query_add_mod.detailFrame != null) {
		if (f_query_add_mod.headerFrame) {
			//alert('here');
			f_query_add_mod.frames[0].location.href="../../eOR/jsp/MultiFacilityProcessingHdr.jsp?mode="+MODE_INSERT;
		}
		if (f_query_add_mod.detailFrame) {
			f_query_add_mod.frames[1].location.href="../../eCommon/html/blank.html";
		}
	} else if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.forms[0].reset(); //reset in query mode
	else{
			frames[0].location.reload();
			return false;
	}
}

function assignResult(res,msg,mod){
	
	resultGlobal = res ;
	messageGlobal = msg ;
	flagGlobal = mod;

	if(messageGlobal=="CLICK_ONE_ORDERABLE" && resultGlobal==false){
		//alert("11111111");
		messageGlobal=getMessage('CLICK_ONE_ORDERABLE','OR');
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
		return false;
	}


}
function callOnAlphaLink(obj, obj2){
	changeAlphaColor(obj2);
	var checkManFlag = checkMandatory();
	if(checkManFlag){
		if(parent.frames[1].location.href.indexOf(".jsp") != -1){
			var flag = latestUpdate();
	//		alert("@@@flag: "+flag);
		}
		var formObj				   	= document.forms[0];
		var ordering_facility_id   	= formObj.ordering_facility_id;
		var order_category		   	= formObj.order_category;
		var	order_type_code		   	= formObj.order_type_code;
		var	performing_facility_id 	= formObj.performing_facility_id;
		var source_type_code		= formObj.source_type_code;
		var source_location_code	= formObj.source_location_code;

		var queryString ="index="+obj+"&tabVal=S&ordering_facility_id="+ordering_facility_id.value+"&order_category="+order_category.value+"&order_type_code="+order_type_code.value+"&performing_facility_id="+performing_facility_id.value;
		queryString += "&source_type="+source_type_code.value+"&source_location="+source_location_code.value;
		parent.detailFrame.location.href="../../eOR/jsp/MultiFacilityProcessingDtl.jsp?"+queryString;
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";

		ordering_facility_id.disabled=true;
		order_category.disabled=true;
		order_type_code.disabled=true;
		performing_facility_id.disabled=true;
		source_type_code.disabled=true;
		source_location_code.disabled=true;
	}
	else{
		/*
		parent.detailFrame.location.href="../../eCommon/html/blank.html";
		var msg = "APP-000001 Service cannot be blank...";
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		*/

	}
}


function dispLink(obj){
	//alert("in dispLink,obj.value="+obj.value);
	var checkManFlag = checkMandatory();
	if(checkManFlag){

		var buttonVal			   	= obj;
		var formObj				   	= document.forms[0];

		var ordering_facility_id   	= formObj.ordering_facility_ids;
		var order_category		   	= formObj.order_categorys;
		var	order_type_code		   	= formObj.order_type_codes;
		var	performing_facility_id 	= formObj.performing_facility_ids;
		var source_type_code		= formObj.source_type_code;
		var source_location_code	= formObj.source_location_code;

		if(buttonVal == "S"){
			document.getElementById('SelectTab').className="clicked";
			document.getElementById('AssociateTab').className="normal";
		}else if(buttonVal == "A"){
			document.getElementById('SelectTab').className="normal";
			document.getElementById('AssociateTab').className="clicked";
		}
		document.getElementById('tabVal').value = buttonVal;
		if(parent.frames[1].location.href.indexOf(".jsp") != -1){
			//alert("before latestUpdate()");
		var flag = latestUpdate();
		}

		if(linkContent=="")
			linkContent	=	document.getElementById("linkId").innerHTML;

//		alert("jsTabValue :"+buttonVal);

		var queryString ="tabVal="+buttonVal+"&ordering_facility_id="+ordering_facility_id.value+"&order_category="+order_category.value+"&order_type_code="+order_type_code.value+"&performing_facility_id="+performing_facility_id.value;
		queryString += "&source_type="+source_type_code.value+"&source_location="+source_location_code.value;

		if(buttonVal=="A"){
		document.getElementById('linkId').className ="";
		document.getElementById('linkId').innerHTML = "";
		parent.frames[1].location.href="../../eOR/jsp/MultiFacilityProcessingDtl.jsp?"+queryString;

		ordering_facility_id.disabled=true;
		order_category.disabled=true;
		order_type_code.disabled=true;
		performing_facility_id.disabled=true;
		source_type_code.disabled=true;
		source_location_code.disabled=true;

		}else{
			parent.frames[1].location.href="../../eCommon/html/blank.html";
			document.getElementById('linkId').innerHTML = linkContent;
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
	}
}

function latestUpdate(){

	var bean_id		= parent.detailFrame.document.formMultiFacilityProcessingDtl.bean_id.value;
	var bean_name	= parent.detailFrame.document.formMultiFacilityProcessingDtl.bean_name.value;
	var fm_disp		= parent.detailFrame.document.formMultiFacilityProcessingDtl.fm_disp.value;
	var to_disp		= parent.detailFrame.document.formMultiFacilityProcessingDtl.to_disp.value;
	var tabVal		= parent.detailFrame.document.formMultiFacilityProcessingDtl.tabVal.value;
//	alert("inslatupdatetbval :"+tabVal);
	var value_str	= "";
	var performing_locn_str = "";

	fm_disp = parseInt(fm_disp);
	to_disp = parseInt(to_disp);

//	alert("fm_disp:"+fm_disp);
//	alert("to_disp:"+to_disp);

	for(i=fm_disp; i<=to_disp; i++){
			var value = eval('parent.detailFrame.document.formMultiFacilityProcessingDtl.select_yn'+i);

			if(!value.disabled){
				if(value.checked)
					val = "Y";
				else
					val = "N";
				}
				else
					val ="N";

				//alert("@@@select_yn:"+val);

				value_str += val+"~";

		 	//	alert("i :"+i);
				var performing_locn = eval('parent.detailFrame.document.formMultiFacilityProcessingDtl.performing_facility_lo'+i).value

			
				performing_locn_str += performing_locn+"~";

				//alert("@@@select_yn"+value_str);
		}
		var xmlStr ="<root><SEARCH ";
		xmlStr += " INDEX_VALUES=\""+ value_str + "\" ";
		xmlStr += " LOCN_VALUES=\""+ performing_locn_str + "\" ";
		xmlStr += " FROM_VALUE=\""+ fm_disp + "\" ";
		xmlStr += " TO_VALUE=\""+ to_disp + "\" ";
		xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
		xmlStr += " TAB_VALUE=\""+ tabVal + "\" ";
		xmlStr += " CLASS_NAME=\"MultiFacilityProcessingBean\"";
		xmlStr +=" /></root>";
		//alert(xmlStr);
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","MultiFacilityProcessingValidate.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		
		//alert( responseText ) ;
		return true;

	}

function onApplyUpdate(){
	var refForm = f_query_add_mod.frames[1].document.forms[0];
	//alert("in onApplyUpdate");
	//alert("refForm="+refForm.name);
	if(f_query_add_mod.frames[1].location.href.indexOf(".jsp") != -1){

		var bean_id		= refForm.bean_id.value;
		var bean_name	= refForm.bean_name.value;
		var fm_disp		= refForm.fm_disp.value;
		var to_disp		= refForm.to_disp.value;
		var tabVal		= refForm.tabVal.value;
		var value_str	= "";
		var performing_locn_str = "";

		fm_disp = parseInt(fm_disp);
		to_disp = parseInt(to_disp);

		for(i=fm_disp; i<=to_disp; i++){
			var value = eval('f_query_add_mod.frames[1].document.forms[0].select_yn'+i);
			//alert("value.disabled="+value.disabled);
			//alert("value.checked="+value.checked);
			if(!value.disabled){
				if(value.checked){
					val = "Y";
				//***	chk_Valflag = true;
				}else
					val = "N";
				}
				else
					val ="N";

			value_str += val+"~";
			var performing_locn = eval('f_query_add_mod.frames[1].document.forms[0].performing_facility_lo'+i).value;
			//alert("performing_locn :"+performing_locn);
			performing_locn_str += performing_locn+"~";
		}
//alert(value_str)
		var xmlStr ="<root><SEARCH ";
		xmlStr += " INDEX_VALUES=\""+ value_str + "\" ";
		xmlStr += " LOCN_VALUES=\""+ performing_locn_str + "\" ";
		xmlStr += " FROM_VALUE=\""+ fm_disp + "\" ";
		xmlStr += " TO_VALUE=\""+ to_disp + "\" ";
		xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
		xmlStr += " TAB_VALUE=\""+ tabVal + "\" ";
		xmlStr += " CLASS_NAME=\"MultiFacilityProcessingBean\"";
		xmlStr +=" /></root>";
		//alert(xmlStr);
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","MultiFacilityProcessingValidate.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		//alert( responseText ) ;
		return true;
	}
	else
	{
		return true;
	}

}

function getOrderType(obj){

	//if(obj.value =="") return
	if(obj.value!=''){
		// remove the existing ones
		var	bean_id		= document.multi_facility_processing_form.bean_id.value ;

		var	xmlDoc = new ActiveXObject(	"Microsoft.XMLDom" ) ;
		var	xmlHttp	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
		xmlStr ="<root><SEARCH " ;
		xmlStr += obj.name+"=\""+ obj.value	+"\" " ;
		xmlStr +=" /></root>" ;

		xmlDoc.loadXML(	xmlStr ) ;
		xmlHttp.open( "POST", "MultiFacilityProcessingFetchOrderType.jsp?bean_id=" + bean_id+"&object_id=ORDER_TYPE", false	) ;

		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval( responseText ) ;
	}
	else{
		 clearList('document','order_type_code');
	}
}

/********/
function fillComboOptions(obj,defaultval) {
	
	var formObjectHeader    = document.forms[0];
	var objName = obj.name;
	if(obj.value != ""){
		var  xmlAppend				= "";
		var  bean_id				= formObjectHeader.bean_id ;
		var  order_type_code		= formObjectHeader.order_type_code;
		var  performing_facility_id = formObjectHeader.performing_facility_id;

		if(obj.name == "order_category" ){
	//		alert("order_category:"+obj.value);
			if(obj.value == "" ){
				removeOptions(order_type_code ,"OrderType");
				return ;
			}else{
			OrderCategory = obj.value ;
			xmlAppend += "order_category"+"=\""+OrderCategory+"\" " ;
			xmlAppend += "type"+"=\"OrderCategory\"" ;
			}
		}else if(obj.name == "ordering_facility_id" ){

		//	alert("ordering_facility_id"+obj.value);

			if(obj.value == "" ){
				removeOptions(performing_facility_id ,"OperatingFacId");
				return ;
			}else{
			OrderingFacID = obj.value ;
			xmlAppend += "ordering_facility_id"+"=\""+OrderingFacID+"\" " ;
			xmlAppend += "type"+"=\"OrderingFacID\"" ;
			}
		}/* else if (obj.name == "performing_facility_id") {
			var ordering_facility_id = document.formMultiFacilityProcessingHdr.all.ordering_facility_id.value;
		 	var performing_facility_id = obj.value;
		 	if (ordering_facility_id == performing_facility_id) {
		 		document.getElementById("performing_facility_lo_lo").innerHTML = "&nbsp;<select name='performing_facility_lo' id='performing_facility_lo'><option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ---Select--- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option></select>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>";
		 	} else {
		 		document.getElementById("performing_facility_lo_lo").innerHTML = "&nbsp;<select name='performing_facility_lo' id='performing_facility_lo'><option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ---Select--- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option></select>";
		 	}
		 	PerformFacID = obj.value;
		 	xmlAppend += "performing_facility_id"+"=\""+PerformFacID+"\" ";
		 	xmlAppend += "type"+"=\"PerformFacID\"" ;
		}*/

		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;
		xmlStr =xmlStr + xmlAppend ;
		xmlStr +=" /></root>" ;
		//alert(xmlStr);
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "MultiFacilityProcessingFetchValues.jsp?bean_id="+bean_id.value+"&default_val="+defaultval,false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		//alert(responseText);
		eval(responseText ) ;

	}else{
		//alert(objName);
		if(objName == "order_category")
			removeOptions(document,document.forms[0].order_type_code ,"OrderType");
		else if(objName == "ordering_facility_id")
			removeOptions(document,document.forms[0].performing_facility_id ,"OperatingFacId");
		//else if(objName == "performing_facility_id")
		//	removeOptions(document,document.forms[0].performing_facility_lo ,"PerformFacID");
	}

}
/********/
function removeOptions(formObject,comboObject,optionName) {
	var len = comboObject.length;
	for(var i=0;i<len;i++){
		if(optionName == "OrderType")
			formObject.forms[0].order_type_code.remove("order_type_code");
		else if(optionName == "OperatingFacId")
			formObject.forms[0].performing_facility_id.remove("performing_facility_id");
		//else if (optionName == "PerformFacID")
		//	formObject.forms[0].performing_facility_lo.remove("performing_facility_lo");

	}
	var tp = "------- "+getLabel("Common.defaultSelect.label","Common")+" -------" ;
	var opt = formObject.createElement("OPTION");
	opt.text = tp ;
	opt.value = "" ;

	if(optionName == "OrderType")
		formObject.forms[0].order_type_code.add(opt);
	else if(optionName == "OperatingFacId")
		formObject.forms[0].performing_facility_id.add(opt);
	//else if (optionName == "PerformFacID")
	//	formObject.forms[0].performing_facility_lo.add(opt);

}
/********/
function addComboObject(comboObjectString,Object){
//alert(comboObjectString);
comboObjectString = comboObjectString.replace('Select',getLabel("Common.defaultSelect.label","Common"));
comboObjectString = comboObjectString.replace('AALL',getLabel("Common.all.label","Common"));

//alert(Object);
	var order_type_code				= 	document.getElementById('order_type_id');
	var performing_facility_id		= 	document.getElementById('performing_facility_id_id');
	//var performing_facility_lo		=	document.forms[0].all.performing_facility_lo_lo;

	if(Object == "order_category")
		order_type_code.innerHTML = comboObjectString ;
	if(Object == "performing_facility_id")
		performing_facility_id.innerHTML = comboObjectString ;
	//if (Object == "performing_facility_lo")
	//	performing_facility_lo.innerHTML = comboObjectString ;
}
/********/

function getPerformingFacility(obj){
	//if(obj.value =="") return
	if(obj.value!=''){
		// remove the existing ones
		var	bean_id	= document.multi_facility_processing_form.bean_id.value ;

		var	xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();

		xmlStr ="<root><SEARCH " ;
		xmlStr += obj.name+"=\""+ obj.value	+"\" " ;
		xmlStr +=" /></root>" ;

		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "MultiFacilityProcessingFetchOrderType.jsp?bean_id=" + bean_id+"&object_id=ORDERING_FACILITY", false	) ;

		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval( responseText ) ;
	}
	else{
		clearList('document','performing_facility');
	}

}

function clearList( docObj,obj_name ) {
	var len = eval(docObj+".multi_facility_processing_form."+obj_name+".options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".multi_facility_processing_form."+obj_name+".remove(\"obj_name\")") ;
	}
	var tp = " ";
	if(obj_name=="order_type_code")
		tp = "-------------- "+getLabel("Common.all.label","Common")+" ------------------" ;
	else
  	    tp = "-------------- "+getLabel("Common.defaultSelect.label","Common")+" ------------------" ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".multi_facility_processing_form."+obj_name+".add(opt)") ;
}

function addList(obj_name,code,value) {
	var element		= document.createElement('OPTION') ;
	element.value	=  code ;
	element.text	= value ;
	eval("document.multi_facility_processing_form."+obj_name+".add(element);");
}


function checkMandatory(){
	var	formObj	= parent.headerFrame.document.formMultiFacilityProcessingHdr ;
	var	fields = new Array ( formObj.ordering_facility_id
						,formObj.source_type_code
						,formObj.source_location_code
						,formObj.order_category
						,formObj.order_type_code
						,formObj.performing_facility_id
						);

	var	names =	new	Array (getLabel("Common.OrderingFacility.label","COMMON"),getLabel("Common.SourceType.label","COMMON"),getLabel("eOR.SourceLocation.label","OR"),getLabel("Common.OrderCategory.label","Common"),getLabel("Common.OrderType.label","Common"),getLabel("Common.PerformingFacility.label","COMMON"));

	var msgFrame = parent.parent.messageFrame;
	
	if(parent.headerFrame.checkFieldsofMst(	fields,	names, msgFrame)) {
	   return true;
	}
	else
	  return false;
}

function setForAll(obj){
	var value = obj.value;
	if(value=="ALL"){
		document.getElementById('SelectTab').style.visibility='hidden';
		document.getElementById('AssociateTab').style.visibility='hidden';
		document.getElementById('rowTab').style.visibility='hidden';
		document.getElementById('linkId').style.display='none';
		document.getElementById('perf_locn').style.display='inline';
		//document.formMultiFacilityProcessingHdr.all.perf_locn_lbl.style.visibility='visible';
		//document.formMultiFacilityProcessingHdr.all.performing_facility_lo_lo.style.visibility='visible';
	}else{
		document.getElementById('SelectTab').style.visibility='visible';
		document.getElementById('AssociateTab').style.visibility='visible';
		document.getElementById('rowTab').style.visibility='visible';
		document.getElementById('linkId').style.display="";
		document.getElementById('perf_locn').style.display='none';
		//document.formMultiFacilityProcessingHdr.all.perf_locn_lbl.style.visibility='hidden';
		//document.formMultiFacilityProcessingHdr.all.performing_facility_lo_lo.style.visibility='hidden';
	}
}

function visibility() {
	//alert("578");
	document.getElementById('perf_locn').style.display='none';
	//document.formMultiFacilityProcessingHdr.all.perf_locn_lbl.style.visibility='hidden';
	//document.formMultiFacilityProcessingHdr.all.performing_facility_lo_lo.style.visibility='hidden';
}

function checkVal(obj){
	document.forms[0].dispMode.value = obj;
	document.forms[0].submit();
}

function fillLocation(itemObj,defaultval){
	
	//checkFields
	var	fields = new Array ( document.getElementById("ordering_facility_id"));
	var	names =	new	Array (getLabel("Common.OrderingFacility.label","COMMON"));
	
	if(parent.checkFieldsofMst( fields, names, parent.parent.messageFrame)){
		if (document.getElementById("source_type_code").value == '') {
			document.getElementById("source_location").innerHTML="<select name='source_location_code' id='source_location_code'> <option value=''>---"+getLabel("Common.defaultSelect.label","Common")+"---</option> </select><img src='../../eCommon/images/mandatory.gif' align=center></img>";
		}
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;
		xmlStr += itemObj.name+"=\""+ itemObj.value +"\" " ;
		xmlStr += document.getElementById("ordering_facility_id").name+"=\"" + document.getElementById("ordering_facility_id").value+"\" ";
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		//alert('itemObj='+itemObj.name);
		xmlHttp.open( "POST", "MultiFacilityProcessingFillLocation.jsp?bean_id="+document.formMultiFacilityProcessingHdr.bean_id.value+"&itemName="+itemObj.name+"&locType="+itemObj.value+"&facility_id="+document.getElementById("ordering_facility_id").value+"&default_val="+defaultval,false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		//alert(responseText);
		eval( responseText ) ;
	}
}

function clearLocationList( docObj,selected ) {
	var len = eval(docObj+".formMultiFacilityProcessingHdr.source_location_code.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".formMultiFacilityProcessingHdr.source_location_code.remove(\"atc_class_l2_code\")") ;
	}
	var tp = getLabel("Common.all.label","Common") ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "*ALL" ;
	eval(docObj+".formMultiFacilityProcessingHdr.source_location_code.add(opt)") ;
}
function addLocation2List(code,value,selected) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	if(selected=="true")
	{
		element.selected = true;
	}
	else
	{
		element.selected = false;
	}
	document.formMultiFacilityProcessingHdr.source_location_code.add(element);
}

/*function fillPerformingLocation(obj) {
 	var ordering_facility_id = document.formMultiFacilityProcessingHdr.all.ordering_facility_id.value;
 	var performing_facility_id = obj.value;
 	if (ordering_facility_id == performing_facility_id) {
 		document.formMultiFacilityProcessingHdr.all.performing_facility_lo_lo.innerHTML = "&nbsp;<select name='performing_facility_lo' id='performing_facility_lo'><option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ---Select--- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option></select>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>";
 	} else {
 		document.formMultiFacilityProcessingHdr.all.performing_facility_lo_lo.innerHTML = "&nbsp;<select name='performing_facility_lo' id='performing_facility_lo'><option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ---Select--- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option></select>";
 	}
}*/

function fillPerformingLocation(itemObj){
	
	//checkFields
	var	fields = new Array ( document.getElementById("ordering_facility_id"),document.getElementById("order_category"));
	var	names =	new	Array (getLabel("Common.OrderingFacility.label","COMMON"),getLabel("Common.OrderCategory.label","Common"));
	
	if(parent.checkFieldsofMst( fields, names, parent.parent.messageFrame)){
		var ordering_facility_id = document.getElementById('ordering_facility_id').value;
        var order_t_c = document.getElementById('order_type_codes').value;
	//	alert("@@@order_type_code: "+order_t_c);

	 	var performing_facility_id = itemObj.value;
//		alert("@@performing_facility_id:"+performing_facility_id);
	 	if (ordering_facility_id == performing_facility_id) {
	 		document.getElementById('performing_facility_lo_lo').innerHTML = "<select name='performing_facility_lo' id='performing_facility_lo'><option value=''>---"+getLabel("Common.defaultSelect.label","Common")+"---</option></select><img src='../../eCommon/images/mandatory.gif' align=center></img>";
	 	} else {
	 		document.getElementById('performing_facility_lo_lo').innerHTML = "<select name='performing_facility_lo' id='performing_facility_lo'><option value=''>---"+getLabel("Common.defaultSelect.label","Common")+"---</option></select>";
	 	}
		/*if (document.getElementById("performing_facility_id").value == '') {
			document.getElementById("performing_facility_lo").innerHTML="&nbsp;<select name='performing_facility_lo' id='performing_facility_lo'> <option value=''>&nbsp;&nbsp;&nbsp;---Select---&nbsp;&nbsp;&nbsp;</option> </select><img src='../../eCommon/images/mandatory.gif'></img>";
		}*/
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;
		xmlStr += itemObj.name+"=\""+ itemObj.value +"\" " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "MultiFacilityProcessingFillLocation.jsp?bean_id="+document.getElementById('bean_id').value+"&itemName="+itemObj.name+"&locType="+document.getElementById("order_category").value+"&facility_id="+document.getElementById("performing_facility_ids").value+"&order_type_code="+document.getElementById("order_type_codes").value,false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		//alert(responseText);
		eval( responseText ) ;
	}
}

function clearPerformLocn( docObj ) {
	var len = eval(docObj+".formMultiFacilityProcessingHdr.performing_facility_lo.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".formMultiFacilityProcessingHdr.performing_facility_lo.remove(\"atc_class_l2_code\")") ;
	}
	var tp = "------- "+getLabel("Common.defaultSelect.label","Common")+" -------" ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".formMultiFacilityProcessingHdr.performing_facility_lo.add(opt)") ;
}
function addPerformLocn2List(code,value,selected,defaultval) {

	//alert("code: "+code);
	//alert("value: "+value);
	//alert("selected: "+selected);
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	if(selected=="true")
	{
		element.selected = true;
	}
	else
	{
		element.selected = false;
	}
	
	document.formMultiFacilityProcessingHdr.performing_facility_lo.add(element);
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

function deleterecord()
{
	if (! checkIsValidForProceed() ) 
	{
		message  = getMessage("NOT_VALID_DELETE","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}

	var formObj =f_query_add_mod.headerFrame.document.formMultiFacilityProcessingHdr ;
	var mode = formObj.mode.value ;
	if(mode == '1')
	{//no action
		var message  = getMessage("NOT_VALID_DELETE","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	var	fields = new Array ( formObj.ordering_facility_id,formObj.source_type_code
						,formObj.source_location_code,formObj.order_category
						,formObj.order_type_code,formObj.performing_facility_id);

	var	names =	new	Array (getLabel("Common.OrderingFacility.label","COMMON"),getLabel("Common.SourceType.label","COMMON"),getLabel("eOR.SourceLocation.label","OR")
				,getLabel("Common.OrderCategory.label","Common"),getLabel("Common.OrderType.label","Common"),getLabel("Common.PerformingFacility.label","COMMON"));
			
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{
	formObj.mode.value =0;
		var confirm_val= window.confirm(getMessage("DELETE_CONFIRM","OR"));
		if(confirm_val)
		{
			
			eval(formApply(f_query_add_mod.headerFrame.document.formMultiFacilityProcessingHdr,OR_CONTROLLER) );
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
			if( resultGlobal ) 
			{
				onSuccess();
			}
		}else
		{
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
		}
	}
}

function Modify(obj,rowIndex,chking) 
{
	var	ordering_facility_id							=     trimString(obj.cells[0].innerText);;
	var order_category                       =     trimString(obj.cells[2].innerText);
	var order_type_code  =     trimString(obj.cells[3].innerText);
	var performing_facility_id                                  =     trimString(obj.cells[5].innerText);
	var source_type                                  =     trimString(obj.cells[9].innerText);
	var source_location                                 =     trimString(obj.cells[10].innerText);

	parent.frames[1].location.href="../../eOR/jsp/MultiFacilityProcessingMain.jsp?order_category="+order_category+"&ordering_facility_id="+ordering_facility_id+"&order_type_code="+order_type_code+"&performing_facility_id="+performing_facility_id+"&source_type="+source_type+"&source_location="+source_location+"&mode="+MODE_MODIFY;

}

function multimodify()
{
	if(document.getElementById("ordering_facility_id")!=null)
	{
		fillComboOptions(document.getElementById("ordering_facility_id"),document.getElementById("performing_facility_ids").value)
	}
	if(document.getElementById("source_type_code")!=null)
	{
		fillLocation(document.getElementById("source_type_code"),document.getElementById("source_locations").value)
	}
	if(document.getElementById("order_category")!=null)
	{
		fillComboOptions(document.getElementById("order_category"),document.getElementById("order_type_codes").value)
		document.getElementById('order_type_codes').value=document.getElementById('order_type_codes').value;
	}
	if(document.getElementById("order_type_code")!=null)
	{
		setForAll(document.getElementById("order_type_code"));
	}
	if(document.getElementById("performing_facility_id")!=null && document.getElementById("perform_location")!=null)
	{
		
		fillPerformingLocation(document.getElementById("performing_facility_id"));
		
		if(document.getElementById("order_type_code").value=="ALL")
		{
			if(document.getElementById("perform_location").value!="null")
			{
				document.getElementById("performing_facility_lo").value=document.getElementById("perform_location").value;
			}
			
		}
	}
	
}

