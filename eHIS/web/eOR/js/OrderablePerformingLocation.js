/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/**************Global Variable for all function ****************/
var function_id          = "" ;
var resultGlobal	     = false;
var messageGlobal	     = "" ;
var invalidCodeGlobal	 = "" ;
var flagGlobal		     = true;
var detailPageMode		 = "N";	//Select,Associated,None{s,A,N}
var selFlag			     = false ;
/***************************************************************/
var flagChk          = false; //Only to DiBug
/*************Handle to the Frame 's and the form Object ****************/
var headerDoc		= null	;
var detailDoc		= null ;
var formObjHeader	= null	;
var formObjDetail	= null ;
/********************Intialise function*************************************/
function initializeGlobal(){
	resultGlobal			= false;
	messageGlobal			= "" ;
    flagGlobal				= true;
	flagChk					= false;
	selFlag				    = false ;
}
/************************Set detial Page Mode***********************/
function setDetailPageMode(val){
detailPageMode = val;
}
/*********Click Function"s Start Here**********/

/********************Create function*************************************/
function create() {
	setDetailPageMode('N');
	initializeGlobal();
	f_query_add_mod.location.href="../../eOR/jsp/OrderablePerformingLocationMultiple.jsp?mode=1&function_id="+function_id
}
/********************Query function*************************************/
function query() {
	f_query_add_mod.location.href="../../eOR/jsp/OrderablePerformingLocationQueryCriteria.jsp?function_id="+function_id;
}
/******************Select function when section code Combo opt selected****/
function select(obj){

	getHandleDetail();
	getHandleHeader();
 	ShowHtml();
	setCombinationMode(true);

	if(obj.value != "")
	{
		changeCellStyle("show");
	}else{
		changeCellStyle("hide");
		detailDoc.location.href="../../eCommon/html/blank.html";
	}
}
/*******************Select TAB*****************************/
function selectInsert(){
	//chk  whether detail form is present
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	if(!chkDetail())
	return false;

	getHandleHeader();
//	initializeGlobal();
	getHandleDetailDoc();
	ShowHtml();

	headerDoc.SelectTab.className="clicked";
	headerDoc.AssociateTab.className="normal";
    //alert("detailPageMode=" + detailPageMode);
if(detailPageMode == 'N'){//Current Page Mode == No
//alert("in select")
	detailDoc.location.href="../../eOR/jsp/OrderablePerformingLocationDetail.jsp?&action=select" + "&location_type="+ formObjHeader.location_type.value + "&location_code="+ formObjHeader.location_code.value+"&order_type="+ formObjHeader.order_type.value+ "&nextPrevFlag=next"  + "&detailPageMode="+detailPageMode ;
}else{
	getHandleDetail();
	formObjDetail.action.value="select";
	eval(formObjDetail);
	formObjDetail.submit();
}
	detailPageMode = 'N' ;
	detailDocObj.location.href="../../eCommon/html/blank.html";
}
/*******************Associated TAB*****************************/
function associated(){

	//chk  whether detail form is present
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	if(!chkDetail())
	return false;

	selFlag			 = true ;

	getHandleHeader();
	getHandleDetail();
//	initializeGlobal();
	clearHtmlABC();

	headerDoc.SelectTab.className="normal";
	headerDoc.AssociateTab.className="clicked";
	 //alert("detailPageMode=" + detailPageMode);

	if(detailPageMode == 'N'){
		
		//Current Page Mode == No
	detailDoc.location.href="../../eOR/jsp/OrderablePerformingLocationDetail.jsp?&action=associated" + "&location_type="+ formObjHeader.location_type.value + "&location_code="+ formObjHeader.location_code.value +"&order_type="+ formObjHeader.order_type.value + "&nextPrevFlag=next"  + "&detailPageMode="+detailPageMode ;
	
	
	}else{
		getHandleDetail();
		if(formObjDetail)
		{
		formObjDetail.nextPrevFlag.value='next';
		formObjDetail.action.value="associated";
		}
		eval(formObjDetail);
		formObjDetail.submit();
	}
}
/********************apply function*************************************/
function apply(){
	if (! checkIsValidForProceed() ) {
		var message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	getHandleDetail();
	getHandleHeader();
	
	var fields = new Array ( formObjHeader.location_type,
							 formObjHeader.location_code,
							 formObjHeader.order_type);
	var names = new Array ( getLabel("Common.locationtype.label","Common") , getLabel("Common.locationcode.label","Common") , getLabel("Common.OrderType.label","Common"));
	if(!checkFieldsofMst( fields, names, messageFrame)) {
	  return false;
	}

	//chk  whether detail form is present
	if(!chkDetail()) {
		return false;
	}
	//alert("####selFlag="+selFlag);
	if(!selFlag)
	{
		var msg = getMessage("CLICK_ONE_ORDERABLE","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		return false;
	}


	/*if(f_query_add_mod.f_query_add_mod_detail.location.href.indexOf(".jsp") == -1){
	var tempHtml = "<input type='hidden' value='1' name='mode' id='mode'><input type='hidden' value='N' name='detailPageMode' id='detailPageMode'>"
	formObjHeader.insertAdjacentHTML("AfterEnd", tempHtml);
	eval(formApply(formObjHeader));
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+
	messageGlobal;
	return false;
	}*/
	//alert("##########f_query_add_mod.f_query_add_mod_detail.document.name="+f_query_add_mod.f_query_add_mod_detail.document.name);

	if(f_query_add_mod.f_query_add_mod_detail.location.href.indexOf(".jsp") == -1){

		//alert("@@@@@@@@@@@@@@@");
	eval(formApply(formObjHeader,OR_CONTROLLER));
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+
	messageGlobal;

	if(!resultGlobal){
		if(invalidCodeGlobal != "" && invalidCodeGlobal != "null"){
		var msg = messageGlobal + invalidCodeGlobal;
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
		}
		associated();
		return false;
	}

		return true;
	}
	

	if(!ValidateEntry()){
		return false;
	}
	//alert(formApply(formObjDetail,OR_CONTROLLER))

	//alert("$$$$");
	eval(formApply(formObjDetail,OR_CONTROLLER))
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
	if(resultGlobal){
	initializeGlobal();
	detailDoc.location.href="../../eCommon/html/blank.html" ;
	onSuccess();
	return true ;
	}else{

	if(invalidCodeGlobal != "" && invalidCodeGlobal != "null"){
	var msg = messageGlobal + invalidCodeGlobal;
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
		}
	}

}

/********************reset *************************************/
function reset() {
	if(f_query_add_mod.f_query_add_mod_header !=null){
	getHandleDetail();
	getHandleHeader();
	initializeGlobal();
	setCombinationMode(false);
	selFlag			 = false ;
	formObjHeader.location_type.selectedIndex = 0 ;
	detailPageMode			="N";
	removeOptions(headerDoc.order_type_option ,"orderTypeOption");
	removeOptions( headerDoc.location_code_option,"locationCodeOption");
	changeCellStyle("hide");
	detailDoc.location.href = "../../eCommon/html/blank.html";
	}else if( f_query_add_mod.document.forms[0])
    f_query_add_mod.document.forms[0].reset(); //reset in query mode
		else{
				frames[0].location.reload();
				return false;
			}
	
}
/**************function to fill combo Box Dynamically********************/
function fillComboOptions(obj) {

	getHandleDetail();
	getHandleHeader();

	var locationType = "";
	var locationCode = "";
	var  xmlAppend = "";


	//Clear detail Page and the All Anchor tags
	detailDoc.location.href="../../eCommon/html/blank.html";
	currentIndexSelected = "";

	var bean_id					= formObjHeader.bean_id ;
	var function_id				= formObjHeader.function_id;
	var location_code			= formObjHeader.location_code ;
	var order_type				= formObjHeader.order_type ;
	var location_code_option	= headerDoc.location_code_option ;
	var order_type_option		= headerDoc.order_type_option ;


/*	if(obj.name == "location_code" )
	{
		removeOptions(order_type_option ,"orderTypeOption");
		if(obj.value == "" )
		{
			removeOptions(location_code_option ,"locationCodeOption");
			changeCellStyle("hide");
			return ;
		}else{
		locationType = obj.value ;
		xmlAppend += "location_type"+"=\""+ formObjHeader.location_type.value+"\" " ;
		xmlAppend += "function_id"+"=\""+function_id+"\" ";
		xmlAppend += "type"+"=\"locationCode\"" ;
		}
	}
*/
	if(obj.name == "location_type" )
	{

		if(obj.value == "" )
		{
			removeOptions(order_type_option ,"orderTypeOption");
			changeCellStyle("hide");
			return ;
		}else{
			locationCode = obj.value ;
			//alert(function_id.value)
			//xmlAppend += "location_code"+"=\""+ formObjHeader.location_code.value+"\" " ;
			xmlAppend += "location_type"+"=\""+ formObjHeader.location_type.value+"\" " ;
			xmlAppend += "function_id"+"=\""+function_id.value+"\" ";
			xmlAppend += "type"+"=\"locationCode\"" ;
		}
	}


	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;



	xmlStr ="<root><SEARCH " ;
	xmlStr =xmlStr + xmlAppend ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderablePerformingLocationComboFill.jsp?bean_id="+bean_id.value+"&function_id="+function_id.value,false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;

	if(flagChk ==  true )
	{
		//alert(responseText);
		eval(responseText ) ;
	}

	if(flagChk ==  false )
	{
		flagChk = true ;
		//alert(responseText);
		eval( responseText ) ;
	}

}
/********************function called when index is clicked*********************/
function callOrderCatalog(obj){

	//alert("in callOrderCatalog")
	if(!chkDetail())
	return ;

	selFlag			 = true ;

	getHandleDetail();
	getHandleHeader();
	clearMessageFrame();

	//alert("detailPageMode="+detailPageMode);

	var location_type = formObjHeader.location_type.value ;
	var location_code  = formObjHeader.location_code.value ;
	var order_type   = formObjHeader.order_type.value ;

	if(detailPageMode == "N"){
	detailDoc.location.href="../../eOR/jsp/OrderablePerformingLocationDetail.jsp?OrderCatalogIndex="+obj + "&action=IndexSelect" + "&location_type="+location_type + "&location_code="+location_code +"&order_type="+order_type + "&nextPrevFlag=next"  + "&detailPageMode="+detailPageMode ;
	detailPageMode = "S" ;	//Detail page mode becomes selected
	}else{
	if(formObjDetail)
	{
	formObjDetail.nextPrevFlag.value='next';
	formObjDetail.OrderCatalogIndex.value=obj;
	formObjDetail.order_type.value=order_type;
	formObjDetail.location_type.value=location_type;
	formObjDetail.action.value="IndexSelect";
	}
	eval(formObjDetail);

	formObjDetail.submit();
	}


}
/********************NExt- Prevoius function******************************/
function getNext(flagSelect){

if(!chkDetail())
return ;

getHandleDetail();
getHandleHeader();
messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?";
formObjDetail.nextPrevFlag.value=flagSelect;//set the Flag to next or Prevoius
formObjDetail.action.value="nextPrev";
formObjDetail.submit();
}
/*******END OF CLICK FUNCTIONS***********/
/********************sucess********************************/
function onSuccess() {
	create();
}
/*****************assign result function*************************************/
function assignResult(res,msg,mod ,invcode){
	resultGlobal			=res ;
	messageGlobal			=msg ;
	flagGlobal				=mod;
	invalidCodeGlobal		=invcode ;
}

/********************Clear the Options-- function***********************/
function removeOptions(comboObject,optionName){
	var locationCodeOption = '<select name="location_code" id="location_code" <%=readOnly%> ><option>--------"'+getLabel("Common.defaultSelect.label","Common")+'"-----</option></select><img src="../../eCommon/images/mandatory.gif"></img>';  //onChange="fillComboOptions(this);"

	var orderTypeOption = '<select name="order_type" id="order_type" <%=readOnly%> onChange="parent.parent.select(this)"><option>-----------"'+getLabel("Common.defaultSelect.label","Common")+'"-----</option></select><img src="../../eCommon/images/mandatory.gif"></img>';


	if(optionName == "locationCodeOption")
	 comboObject.innerHTML = locationCodeOption;

	if(optionName == "orderTypeOption")
	 comboObject.innerHTML = orderTypeOption;
  }

/********************Dynamically add Option function************************/
function addComboObject(comboObjectString,Object){
		getHandleDetail();
		getHandleHeader();

		var location_code_option	= 	headerDoc.location_code_option ;
		var order_type_option    	= 	headerDoc.order_type_option ;
		comboObjectString = comboObjectString.replace('Select',getLabel("Common.defaultSelect.label","Common"));
        //alert("here:"+Object)
		if(Object == "location_type")
		location_code_option.innerHTML = comboObjectString ;

		if(Object == "location_code") {

			order_type_option.innerHTML = comboObjectString ;
		}

   }
/********************Show html function*************************************/
function ShowHtml(){

	getHandleDetail();
	getHandleHeader();

	detailDoc.location.href="../../eCommon/html/blank.html";

	if(headerDoc.mode.value == "1")	{
		changeCellStyle("show");
	}else{
	;
	}


}

/********************Clear A,B,C Alphabet function**************************/

function clearHtmlABC(){
	getHandleHeader();
	headerDoc.alphabet.style.display	 = "none" ;
}
/********************Chk whether detail form present or not******************************/
function chkDetail() {
	//alert("in chkDetail:" + parent.frames[1].name)
	//if(f_query_add_mod.f_query_add_mod_detail.location.href.indexOf(".jsp") == -1) {
	if(f_query_add_mod.location.href.indexOf(".jsp") != -1){
		//alert("in if")
		return true;
	}
}
/********************Check Duplicate function******************************/
function chkDulplicateSeqNo(){

	//Chk whether detail form present or not
//	if(parent.frames[1].location.href.indexOf(".jsp") != -1){
	if(f_query_add_mod.f_query_add_mod_detail.location.href.indexOf(".jsp") == -1){
	return true;
	}

	getHandleDetail();
	getHandleHeader();

	var SqnArrayLocal  = new Array()
	var arrLocalLen = 0;

	var form =parseInt(formObjDetail.previousRecord.value) ;
	var to   =parseInt(formObjDetail.nextRecord.value) ;


	 //Construct arrLocal array for the Page
	for(i=form-1;i<to;i++){

		var obj  = eval("formObjDetail.tick_sheet_seq_num" +i) ;

		if(obj.value != "" && obj.value != null )
			SqnArrayLocal[i] = obj.value ;
		else
			SqnArrayLocal[i] = "";
	}


	arrLocalLen = SqnArrayLocal.length ;

	//CODE FOR CHK DUPLICATES on Local Page
	var chkDuplicate = false ;

	for(k=0;k<(SqnArrayLocal.length-1);k++)
	{
		var chk = SqnArrayLocal[k] ;

		if(chk != "" && chk != null )
		{
				for(h=k+1;h<SqnArrayLocal.length;h++)
				{
					if(parseInt(chk) == parseInt(SqnArrayLocal[h]))
					chkDuplicate = true ;
				}
		}

	}

	if(chkDuplicate == true)
	{
//		var message  ="APP-OR0005 Duplicate values are passed";
		var message = getMessage("SEQ_ORDER_CAT_SECTION_CHK","OR") ;
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}


	return true;

}//End of Duplicate Function

/*****************Validate Method*************************************/
function ValidateEntry(){

	getHandleDetail();
	getHandleHeader();

	var mode = formObjHeader.mode.value ;

	var form =parseInt(formObjDetail.previousRecord.value) ;
	var to   =parseInt(formObjDetail.nextRecord.value) ;

	var flagValidateSeqNo  = true ;
	var flagValidateChkBox = true ;

	/*for(i=form-1;i<to;i++){

		var objChkBox  = eval("formObjDetail.include" +i) ;
		var objSeqNo   =  eval("formObjDetail.appt_reqd_yn" +i) ;

		if(objChkBox.checked == true){
			if(objSeqNo.value == "" || objSeqNo.value == null || objSeqNo.value == 0 )
			flagValidateSeqNo = false ;
		}


	if(objSeqNo.value != "" && objSeqNo.value != 0 ){
			if(objChkBox.checked == false)
			flagValidateChkBox = false ;
		}

	}

	if(flagValidateChkBox == false && mode == '1'){
	  var message  ="APP-OR0005 Sequence no's cannot be entered for the Check Box not checked.... " ;
	  messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	  return false ;
	 }

	 if(flagValidateSeqNo == false){
	  var message  ="APP-OR0005 Sequence no's for Check Box Checked should be filled.... " ;
	  messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	  return false ;
	 }*/

	return true ;
}
/*************************************************************/
 function setCombinationMode(flag)
 {
	 getHandleHeader();
	 formObjHeader.location_type.disabled = flag;
 	 formObjHeader.location_code.disabled = flag;
 	 formObjHeader.order_type.disabled = flag;
 }

/*********************Clear Message Frame*****************************/
function clearMessageFrame(){
	  	  messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?";
}
/*********************Header Handle*****************************/
function getHandleHeader(){
 headerDoc	     =f_query_add_mod.f_query_add_mod_header.document ;
 formObjHeader   =headerDoc.OrderablePerformingLocationHeader ;
}
/**********************Detail Handle**********************************/
function getHandleDetail(){
 detailDoc		 =f_query_add_mod.f_query_add_mod_detail.document ;
 formObjDetail	 =detailDoc.OrderablePerformingLocationDetail ;
}
/**************************************************************************/
function getHandleDetailDoc(){
 detailDocObj		 =f_query_add_mod.f_query_add_mod_detail.document ;
}
/****************************************************************************/
function changeCellStyle(pattern){
	getHandleHeader();
	if(pattern == "hide" ){
		headerDoc.alphabet.style.display	 = "none" ;
		headerDoc.innerCellTab.style.display	 = "none" ;
	}else if(pattern == "show" ){
		headerDoc.alphabet.style='display';
		headerDoc.alphabet.style.visibility	 = "visible" ;
		headerDoc.innerCellTab.style='display';
		headerDoc.alphabet.style.visibility	 = "visible" ;
	}

}
function deleteAll(obj) {
	if (obj.checked == false) {
		parent.f_query_add_mod_detail.document.OrderablePerformingLocationDetail.deleteall.value = '1';
	} else {
		parent.f_query_add_mod_detail.document.OrderablePerformingLocationDetail.deleteall.value = '0';
	}
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
/****doSync This function--Sync the current tab to bean before going to other tab********/
function doSync(frmObj){
 var xmlDoc="";
 var xmlHttp = new XMLHttpRequest();
 var  xmlString = buildXml(frmObj);
/* xmlDoc.loadXML(xmlString);*/
 xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
 
 //alert(xmlString);
 xmlHttp.open("POST","../../eOR/jsp/OrderablePerformingLocationSync.jsp",false);
 xmlHttp.send(xmlDoc);
 //alert(xmlHttp.responseText );
 return xmlHttp.responseText  ;
}
/***************************************************************************/
function buildXml(frmObj){

   if(frmObj)
    var arrObj = frmObj.elements;

    var frmObjs = new Array()
    if(frmObj.name == null)
        frmObjs = frmObj ;
    else frmObjs[0] = frmObj ;
    var xmlStr ="<root><SEARCH ";

	for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
	frmObj = frmObjs[frmCount]
	if(frmObj)
	var arrObj = frmObj.elements;

		for(var i=0;i<arrObj.length;i++) {
			var val = "" ;
			if(arrObj[i].type == "checkbox") {
				if(arrObj[i].checked)
					val = arrObj[i].value;
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
			}
			else if(arrObj[i].type == "radio") {
				if(arrObj[i].checked) {
					val = arrObj[i].value;
					if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
				}
			}
			else if(arrObj[i].type == "select-multiple" )
			{
				for(var j=0; j<arrObj[i].options.length; j++)
				{
					if(arrObj[i].options[j].selected)
						val+=arrObj[i].options[j].value +"~"
				}
				val= val.substring(0,val.lastIndexOf('~'))
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;

			}
			else {
				val = arrObj[i].value;
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
					//xmlStr+= arrObj[i].name+"=\""+ val + "\" ";
			}
		}
	}

    xmlStr +=" /></root>";

	//alert(xmlStr);
	return xmlStr;

}
/****************************************************************************/
function syncStatus(flag) {
//	alert(flag);
	return flag ;
}
/*****************************************************************************/
function chkdefault_yn(obj){
	if(obj.checked)
		obj.value='Y';
	else
		obj.value='N';
}

/**
Reference Pattern for Frame's and form Object For Catalog By section

Menu
	|
	OrderablePerformingLocation.jsp---->OrderablePerformingLocation.js
		|
		|------MstToolBar
		|
		|------OrderablePerformingLocationMultiple.jsp
		|		|
		|		|---OrderablePerformingLocationHeader.jsp
		|		|		Document ---headerDoc
		|		|		FormObect---formObjHeader
		|		|
		|		|---OrderablePerformingLocationDetail.jsp
		|		|		Document ---detailDoc
		|		|		FormObect---formObjDetail
		|
		|------MessageFrame
		|

**/

