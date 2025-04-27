/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
27/03/2017	  IN063686		Raja S			27/03/2017		Ramesh G		PMG2017-GHL-CRF-0001
03/08/2017	IN062992		Dinesh T		7/8/2017		Ramesh G		ML-MMOH-CRF-0345.1
04/09/2017	IN065144		Dinesh T		04/09/2017		Ramesh G		Script error displayed
04/09/2017	IN065021		Dinesh T		04/09/2017		Ramesh G		Unable to update comments
30/01/2018	IN065713		Dinesh T		30/01/2017		Ramesh G		System to allow to do multiple setup for same drug in the same Oncology Regimen.
16/01/2018	IN066717		Dinesh T		16/02/2018		Ramesh G		Order set Additional icon(+) is not showing in the next pages.
																			Order catalog is not searchable in the select tab with catalog (Dextrose)
																			Warning messages such Route code must be entered is coming in a single line along with age wise catalog messages.
28/02/2019  IN068370    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0014
28/02/2019  IN068373    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0015
08/01/2020	IN068314	Nijitha S     08/01/2020	Ramesh G	ML-MMOH-CRF-1229
07/06/2020	IN072524	Nijitha S     07/06/2020	Ramesh G	ML-MMOH-CRF-1229.2
------------------------------------------------------------------------------------------------------------------------------
*/
var function_id = "" ;
var mod_qry_str = "" ;//this suppose to have the Parameter Passed by the other modules
var resultGlobal = false;
var messageGlobal = "" ;
var flagGlobal = true;
var flagChk = false;
var qry_str = "";
var message = "" ;

var currentTab =""; //to know current tab selected ['S','Se','C' ,'']

/*For Component Tab*/
var detailPageMode		 = "N";	//Select,Associated,None{S,A,N}
var selFlag			     = false ;



/*************Handle to the Frame 's and the form Object ****************/
var headerDoc			=null;
var detailDoc			=null;
var detailUpperDoc		=null;
var detailLowerDoc		=null;
var tabDoc				=null;

var formObjHeader		=null;
var formObjDetail		=null;
var detailUpperForm		=null;
var detailLowerForm		=null;
var formObjTab			=null;

Array.prototype.contains = function(obj) {
    var i = this.length;
    while (i--)
    {        
    	if (this[i] == obj) 
        {
            return true;
        }
    }
    return false;
}

/*****************initailisation*************************************/
function intialisation(){
 currentTab				="";
 resultGlobal			= false;
 messageGlobal			= "" ;
 flagGlobal				= true;
 flagChk				= false;
 selFlag				= false ;
 detailPageMode         = "N";
}
/*******************************************************************/
function create() {
	intialisation();
	f_query_add_mod.location.href = "../../eOR/jsp/OrderSetAddModify.jsp?mode=1&function_id="+function_id+"&"+qry_str;
}
/******************************************************************************/
function query() {
		f_query_add_mod.location.href="../../eOR/jsp/OrderSetQueryCriteria.jsp?function_id="+function_id;
}
/*******************************************************************************/

function defaultLoadDetail(){
	//Called in when ever header page is loaded
	getHandleHeader();	
//only when called in modify mode or from other modules...........

//headerDoc	     =f_query_add_mod.header ;

//formObjHeader   =headerDoc.header ;

	if(headerDoc.mode.value == '2'  ){
			intialisation();
			display('S');
		}
	}

/***************function of header File(OrderCatalogAddModifyHeader.jsp) to deafult values of lower frame and called when OtherSetUpDetailForm page is loaded*******/
function defaultIntLowerFrame(){
getHandleHeader()
objVal = formObjHeader.short_desc.value ;

if(getHandleDetailUpper()){
	if(detailUpperForm.catalog_synonym_primary != undefined || detailUpperForm.catalog_synonym_primary != null)
		if(objVal != null ){
			detailUpperForm.catalog_synonym_primary .value= objVal ;
  		}
}
}
/******************************************************************************/
function apply() {
	if (! checkIsValidForProceed() ) {
		var message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
		return false ;
	}


	getHandleHeader();
	getHandleDetail();

	var chkMandatoryFlag = true ;


	var l_globalFacilityYn= formObjHeader.globalFacilityYn.value;//IN068370,IN068373
	var l_siteSpecGlobalFac= formObjHeader.siteSpecGlobalFac.value;//IN068370,IN068373
	
	var	fields = new Array (formObjHeader.order_set_code,
			formObjHeader.long_desc,
			formObjHeader.short_desc,
			formObjHeader.order_category,
			formObjHeader.order_type_code);
	var	names =	new	Array (getLabel("Common.code.label","COMMON"),getLabel("Common.longdescription.label","Common"),getLabel("Common.shortdescription.label","Common"),getLabel("Common.OrderCategory.label","Common"),getLabel("Common.OrderType.label","Common"));

	//IN068370,IN068373, starts
  if(l_globalFacilityYn=='Y' && l_siteSpecGlobalFac=='true')
	{
		fields.push(formObjHeader.applFacsMappedYn);
		names.push(getLabel("eOR.ApplicableFacilities.label","or"));
	}
  //IN068370,IN068373, ends
	
	if(!checkFields(fields,	names, messageFrame)){
		return ;
	}


	var flds=new Array(formObjHeader.order_set_code);
	var name=new Array("Code");

	if(!SpecialCharCheck(flds,name,messageFrame,"M","../../eCommon/jsp/error.jsp")){
			return false;
	}


	if(formObjHeader.indexed_yn.checked == true){
		formObjHeader.indexed_yn.value = "Y";
	}else{
		formObjHeader.indexed_yn.value = "N";
	}

	if(formObjHeader.discharge_indicator.checked == true){
		formObjHeader.discharge_indicator.value = "Y";
	}else{
		formObjHeader.discharge_indicator.value = "N";
	}


	if(f_query_add_mod.detail.location.href.indexOf(".jsp") == -1){
		
	}else{
	     if(currentTab !== ""){ //i:e Before Clicking tabs there is already tab seleted

			if(currentTab == "C"){
				if(getHandleDetailLower())
				formObjSyn = detailLowerForm ;
			}else{
				if(getHandleDetailUpper())
					 formObjSyn = detailUpperForm ;
				
				if(currentTab == "S"){
					if(getHandleDetailLower())
					formObjSyn = detailLowerForm ;
					if (formObjSyn.catalog_synonym_directCare) {
						if ((formObjSyn.catalog_synonym_directCare.value.length > 0 && formObjSyn.effective_status_directCare.checked == false)||(formObjSyn.catalog_synonym_ancillaryDept.value.length > 0 && formObjSyn.effective_status_ancillaryDept.checked == false)) {
							//var conf = confirm("Synonym for Direct Care/Ancillary Dept. is not Checked. Record will not be saved.Do u want to make Active?");
							var conf = confirm(getMessage("DIRECT_CARE_ANCILLARY_DEPT_ACTIVATE","OR"));
							if (conf == true) {
								if (formObjSyn.catalog_synonym_directCare.value.length > 0 && formObjSyn.effective_status_directCare.checked == false) {
									formObjSyn.effective_status_directCare.checked = true;
								}
								if (formObjSyn.catalog_synonym_ancillaryDept.value.length > 0 && formObjSyn.effective_status_ancillaryDept.checked == false) {
									formObjSyn.effective_status_ancillaryDept.checked = true;
								}
							} else {
								messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
								return false;
							}
						}
					}
				}

			}

			doSync(formObjSyn);

		}
	}//end of Sync
	

/*	if(formObjSyn.explanatory_text!=null){
		formObjHeader.explanatory_text.value=formObjSyn.explanatory_text.value;
	}	   */
	

	eval(formApply(formObjHeader,OR_CONTROLLER));
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ messageGlobal;
	if(resultGlobal){
	onSuccess();
	return true ;
	}else{
	return false;
	}


}
/******************************************************************************/
function onSuccess() 
{
	if(formObjHeader.module_id.value == "OH")
	{
		alert(messageGlobal);
		window.returnValue="Y";
		window.close();
	}
	getHandleHeader();

	if( headerDoc.mode.value == MODE_INSERT )
	create();

	else if( headerDoc.mode.value == MODE_MODIFY ) {
	f_query_add_mod.document.location.href="../../eOR/jsp/OrderSetAddModify.jsp?"+formObjHeader.qry_str.value ;
	}
}
/********************reset *************************************/
function reset() {
  if(f_query_add_mod.header != null){
  	 if( headerDoc.mode.value == MODE_MODIFY ){//modify mode
	  	 f_query_add_mod.document.location.href = "../../eOR/jsp/OrderSetAddModify.jsp?"+formObjHeader.qry_str.value;
	  }else{//insert mode
		getHandleHeader();
		
		if(headerDoc.module_id.value!="OH")
		 {
			removeOptions(headerDoc.order_type_td ,"OrderType");
		 }
		intialisation();
		formObjHeader.reset();
		clearOnReset(formObjHeader.bean_id.value, formObjHeader.bean_name.value);//IN068370,IN068373
		f_query_add_mod.detail.location.href = "../../eCommon/html/blank.html";
	  }
  }
  else if(f_query_add_mod.document.forms[0]!=null)	   
	f_query_add_mod.document.forms[0].reset(); //reset in query mode
else{
		frames[0].location.reload(); //reset in query mode
		return false;
	}

}
/******************************************************************************/
function assignResult(res,msg,mod){
	resultGlobal = res ;
	messageGlobal = msg ;
	flagGlobal = mod;



	
}
/**************For Text Area**************************************/
function checkMaxLimitLocal(obj,maxSize){

		if ( obj.value.length >= maxSize )
		{
			event.returnValue = false;
		}
}
/************For Text Area**************************************/
function chkLength(Obj,len){

	if(Obj.value.length > parseInt(len,10)){
		alert('The number of characters cannot exceed '+len);
		Obj.focus();
	}

}

/*******************TAB MANAGMENT**********************/
/***************Chage tab************************************/

function ChangeTabClass(objName){

	getHandleTab();

	var obj = null ;

	if(objName == "S")
		obj = tabDoc.getElementById("synonymsTab") 	;
	else if(objName == "C")
		obj = tabDoc.getElementById("componentTab") ;
	else if(objName == "E")
		obj = tabDoc.getElementById("explanatoryTab") ;
	else  if(objName == "Se")
		obj = tabDoc.getElementById("settingsTab") 	;

	if(tabDoc.synonymsTab  != undefined)
    tabDoc.synonymsTab.className			= "normal";

	if(tabDoc.componentTab  != undefined)
    tabDoc.componentTab.className			= "normal";

	if(tabDoc.explanatoryTab  != undefined)
    tabDoc.explanatoryTab.className			= "normal";

	if(tabDoc.settingsTab != undefined)
	tabDoc.settingsTab.className		 	= "normal";

	if(obj != null )
	obj.className = "clicked";

}
/********THIS IS USE TO SELECT JSP PAGES CALLED FROM ORDERCATALOG TAB PAGE*****/
function display(obj){

	//Obj is "" when it is called on change of order Category,so detail frame is blank
	if(!mandatoryChk() && obj!= "" ){
		if( headerDoc.mode.value != MODE_MODIFY ){//Because Order Type cannot be Changed and currebt Tab cannot be unselected I:e ""
			currentTab = ""; //here all current tab selection  is invalited and made to ""
			getHandleHeader();
			ChangeTabClass("");
			headerDoc.order_type_code.selectedIndex = 0;
			f_query_add_mod.detail.location.href = "../../eCommon/html/blank.html";
			return ;
		}
	}else{
			ChangeTabClass(obj);//Click Curr Set Tab
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}


	var formObjSyn = null ;

	if(currentTab == "C"){
		 if(getHandleDetailLower())		//false is cond when on select/ascc tab is clicked
			formObjSyn = detailLowerForm ;

		  detailPageMode = "N";

	}else{
		 if(getHandleDetailUpper())
			 formObjSyn = detailUpperForm ;
	}

	


	if(currentTab !== "" && formObjSyn != null){ //i:e Before Clicking tabs there is  already tab seleted
	   	eval(doSync(formObjSyn));
	}

	var tabFlag = obj ;

	getHandleTab();
	getHandleHeader();

	//var  urlParams = formObjHeader.qry_str.value +"&tabFlag="+tabFlag + "&order_category="+formObjHeader.order_category.value + "&order_type_code="+formObjHeader.order_type_code.value;//IN062992
	//var  urlParams = formObjHeader.qry_str.value +"&tabFlag="+tabFlag + "&order_category="+formObjHeader.order_category.value + "&order_type_code="+formObjHeader.order_type_code.value+"&p_applicable_to="+formObjHeader.iv_prep_yn.value;//IN062992
	//var  urlParams = formObjHeader.qry_str.value +"&tabFlag="+tabFlag + "&order_category="+formObjHeader.order_category.value + "&order_type_code="+formObjHeader.order_type_code.value+"&p_applicable_to="+formObjHeader.iv_prep_yn.value+"&bean_id="+formObjHeader.bean_id.value+"&bean_name="+formObjHeader.bean_name.value;//IN062992
	var  urlParams = formObjHeader.qry_str.value +"&tabFlag="+tabFlag + "&order_category="+formObjHeader.order_category.value + "&order_type_code="+formObjHeader.order_type_code.value+"&p_applicable_to="+f_query_add_mod.header.document.getElementById("iv_prep_yn").value+"&bean_id="+f_query_add_mod.header.document.getElementById("bean_id").value+"&bean_name="+f_query_add_mod.header.document.getElementById("bean_name").value;//IN062992/IN068314
	//IN068314 Starts
	if(formObjHeader.fpp_yn!=undefined)
	{
		urlParams=urlParams+"&fpp_yn="+formObjHeader.fpp_yn.value;
	}
  //IN068314 Ends
	//IN062992, starts
	if(f_query_add_mod.header.document.getElementById("iv_prep_yn").value != 'C')
	{
		clearAgeWiseDetails();
	}	

	//IN062992, ends


	if(getHandleDetail()){
		if(tabFlag != "")
			f_query_add_mod.detail.location.href = "../../eOR/jsp/OrderSetAddModifyDetail.jsp?"+ urlParams ;
		else
			f_query_add_mod.detail.location.href = "../../eCommon/html/blank.html";

		if(tabFlag != "" || tabFlag != null)
			currentTab =  tabFlag ;

	}else{
		alert("Wrong Acssess.....");
	}
}
/****doSync This function--Sync the current tab to bean before going to other tab********/
function doSync(frmObj){
 var xmlHttp = new XMLHttpRequest();
 var  xmlString = buildXml(frmObj);
 
 //parse the xml string into xml document
 var parser = new DOMParser();
 var xmlDoc = parser.parseFromString(xmlString, "text/xml");

 xmlHttp.open("POST","../../eOR/jsp/OrderSetSync.jsp",false);

 xmlHttp.send(xmlDoc);

 eval(xmlHttp.responseText ) ;
}
/***************************************************************************/
//function chkInclude(index){//IN062992
function chkInclude(index,calledFrom)//IN062992
{
	
	//IN062992, starts
	if(calledFrom == 'orderset_dosage_age_dtl_form')
	{
		//IN065713, starts
		/*var include				= eval("frames[0].document.getElementById("include")"+index);
		var	order_set_seq_num   = eval("frames[0].document.getElementById("order_set_seq_num")"+index);*/
		//IN68241, commented starts
    /*var include				= eval("orderset_dosage_age_dtl.document.getElementById("include")"+index);
		var	order_set_seq_num   = eval("orderset_dosage_age_dtl.document.getElementById("order_set_seq_num")"+index);*/
    //IN68241, ends
		//IN065713, ends
    
    //IN68241, starts
    var include				= eval(orderset_dosage_age_dtl_form.document.getElementById("include"+index));
	var	order_set_seq_num   = eval(orderset_dosage_age_dtl_form.document.getElementById("order_set_seq_num"+index));
    //IN68241, ends

		if(!include.checked)
		{
	
			//IN065713, starts
			/*eval("frames[0].document.getElementById("qty_unit")"+index).value = '';
			eval("frames[0].document.getElementById("freq_code")"+index).selectedIndex=0;
			eval("frames[0].document.getElementById("durn_value")"+index).value = '';
			eval("frames[0].document.getElementById("durn_type")"+index).value ='';
			eval("frames[0].document.getElementById("durn_type_desc")"+index).value ='';
			eval("frames[0].document.getElementById("rel_start_date_time")"+index).value = '';
			eval("frames[0].document.getElementById("route_desc")"+index).value = '';
			eval("frames[0].document.getElementById("route_code")"+index).value = '';
			eval("frames[0].document.getElementById("prompt_msg")"+index).value = '';*/
			eval(orderset_dosage_age_dtl_form.document.getElementById("qty_unit"+index)).value = '';
			eval(orderset_dosage_age_dtl_form.document.getElementById("freq_code"+index)).selectedIndex=0;
			eval(orderset_dosage_age_dtl_form.document.getElementById("durn_value"+index)).value = '';
			eval(orderset_dosage_age_dtl_form.document.getElementById("durn_type"+index)).value ='';
			eval(orderset_dosage_age_dtl_form.document.getElementById("durn_type_desc"+index)).value ='';
			eval(orderset_dosage_age_dtl_form.document.getElementById("rel_start_date_time"+index)).value = '';
			eval(orderset_dosage_age_dtl_form.document.getElementById("route_desc"+index)).value = '';
			eval(orderset_dosage_age_dtl_form.document.getElementById("route_code"+index)).value = '';
			eval(orderset_dosage_age_dtl_form.document.getElementById("prompt_msg"+index)).value = '';
			eval(orderset_dosage_age_dtl_form.document.getElementById("add_cata_age_grp"+index)).style.visibility='hidden';
			//IN065713, ends
		}
	}//IN062992, ends
	else if(calledFrom == 'orderset_by_dosage_type_dtl_form')//IN68241, starts
	{
	
		var include				= eval(document.getElementById("include")+index);
		var	order_set_seq_num   = eval(document.getElementById("order_set_seq_num"+index));
		
		if(!include.checked)
		{
			eval(document.getElementById("qty_unit"+index)).value = '';
			eval(document.getElementById("freq_code"+index)).selectedIndex=0;
			eval(document.getElementById("durn_value"+index)).value = '';
			eval(document.getElementById("durn_type"+index)).value ='';
			eval(document.getElementById("durn_type_desc"+index)).value ='';
			eval(document.getElementById("rel_start_date_time"+index)).value = '';
			eval(document.getElementById("route_desc"+index)).value = '';
			eval(document.getElementById("route_code"+index)).value = '';
			eval(document.getElementById("prompt_msg"+index)).value = '';
			eval(document.getElementById("add_cata_age_grp"+index)).style.visibility='hidden';
		}
	}//IN68241, ends
	else//IN062992
	{		
		getHandleDetailLower();
		var include				= eval("detailLowerDoc.include"+index);
		var	order_set_seq_num   = eval("detailLowerDoc.order_set_seq_num"+index);
	}//IN062992
}
/****************this methos is called by the Sync jsp in retrun text******/
function syncStatus(flag) {

	return flag ;
}
/***********************doSync****************************************/
function buildXml(frmObj){


    var arrObj = frmObj.elements;

    var frmObjs = new Array()
    if(frmObj.name == null)
        frmObjs = frmObj ;
    else frmObjs[0] = frmObj ;
    var xmlStr ="<root><SEARCH ";

	for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
	frmObj = frmObjs[frmCount]
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
			}
		}
	}

    xmlStr +=" /></root>";

	return xmlStr;

}
/********This is use to have Mandaotry chks before tab is clicked*****/
function mandatoryChk(){
	var	fields = new Array (formObjHeader.order_set_code,
							formObjHeader.long_desc,
							formObjHeader.short_desc,
							formObjHeader.order_category,
							formObjHeader.order_type_code);
	var	names =	new	Array (getLabel("Common.code.label","COMMON"),getLabel("Common.longdescription.label","Common"),getLabel("Common.shortdescription.label","Common"),getLabel("Common.OrderCategory.label","Common"),getLabel("Common.OrderType.label","Common"));

	if(!checkFields(fields,	names, messageFrame)){//
	return false;
	}

	return true;

}
/*************************************************************************/
function checkFieldsofMstLocal( fields) {
    var errors = true ;
    for( var i=0; i<fields.length; i++ ) {
        if(fields[i].value == null ||  fields[i].value == "" )
           errors = false ;
       }

	   return errors ;
}

/*******This is use to select View(Tab) CHARACTERSTICS tag************/
function displayForOthersSetUp(obj){
	getHandleDetailUpper();
	getHandleHeader();

	if(detailUpperForm.detail_page_loaded.value == "N"){ //i:e when the detail page is not loaded

		if(getHandleDetailLower())
		f_query_add_mod.detail.detailLower.location.href = "../../eOR/jsp/CareSetSynonymForm.jsp?tabFlag="+tabFlag+ "&order_category="+formObjHeader.order_category.value + "&order_type_code="+formObjHeader.order_type_code.value;
		else
		alert("Wrong Acssess");

		detailUpperForm.detail_page_loaded.value  = "y"
	}

	var tabFlag = obj ;


}
/*********************Header Handle*****************************/
function getHandleHeader(){

if(f_query_add_mod.header == null){

	 return false;
}
 headerDoc	     =f_query_add_mod.header.document ;
 formObjHeader   =headerDoc.header ;
 }
/*********************tab Handle*****************************/
function getHandleTab(){
if(f_query_add_mod.tab == null)
	 return false;
 tabDoc	        =f_query_add_mod.tab.document ;
 formObjTab		 =tabDoc.tab ;
 }
/*********************detail Handle*****************************/
function getHandleDetail(){
if(f_query_add_mod.detail == null)
	 return false;
else
	return true;
}
/*********************detail upper Handle*****************************/
function getHandleDetailUpper(){


if(!getHandleDetail())
 return false;


if(f_query_add_mod.detail.detailUpper == undefined)
	return false;


 detailUpperDoc			 =f_query_add_mod.detail.detailUpper.document ;

if(detailUpperDoc.forms[0] == null)
	return false;


if(detailUpperDoc.forms[0].name == "detailUpperForm"){
	 detailUpperDoc	     =f_query_add_mod.detail.detailUpper.document ;
	 detailUpperForm	 =detailUpperDoc.detailUpperForm ;
	 return true;
 }else{
	 return false;
 }
}
/*********************detail Lower Handle*****************************/
function getHandleDetailLower(){
if(!getHandleDetail()){
	 return false;
}


if(f_query_add_mod.detail.detailLower == undefined)
	return ;

 detailLowerDoc			 =f_query_add_mod.detail.detailLower.document ;

 if(detailLowerDoc.forms.length == 0)
 return false;


 if(detailLowerDoc.forms[0].name == "detailLowerForm"){
 detailLowerForm		= detailLowerDoc.detailLowerForm ;
 return true;
 }else{
 return false;
 }

}
/**************function to fill combo Box Dynamically********************/
function fillComboOptions(obj) {


	getHandleHeader();

	f_query_add_mod.detail.location.href = "../../eCommon/html/blank.html";
	currentTab = "";	//Always make current Tab empty when detail frame is made blank.....
	ChangeTabClass("");
	var  xmlAppend = "";

	var bean_id				= formObjHeader.bean_id ;
	var iv_prep_ynVal       = f_query_add_mod.header.document.getElementById("iv_prep_ynVal").value ;
	var localeName= formObjHeader.localeName.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var order_category="";
	
	if(obj.name == "order_category" ){    
	if(obj.value == "PH"){
		
		//headerDoc.iv_prep_yn_display.style.display = "inline";
		headerDoc.iv_prep_yn_display.style.display = "inline";
		headerDoc.iv_prep_yn_display.style.visibility = "visible";
		order_category = obj.value ;
			
		xmlAppend += "order_category"+"=\""+ order_category+"\" " ;
		xmlAppend += "iv_prep_ynVal"+"=\""+ iv_prep_ynVal+"\" " ;
		xmlAppend += "type"+"=\"iv_prep_yn\"" ;
		xmlStr ="<root><SEARCH " ;
		xmlStr =xmlStr + xmlAppend ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");		
		xmlHttp.open( "POST", "OrderSetComboFill.jsp?bean_id="+bean_id.value+"&localeName="+localeName,false ) ;
		xmlHttp.send( xmlDoc ) ;		
		responseText=xmlHttp.responseText ;
		eval(responseText ) ;
		xmlAppend="";

 	} else  {
		removeOptions(headerDoc.iv_prep_yn_td ,"iv_prep_yn");
		//headerDoc.iv_prep_yn_display.style.display = "none";
		headerDoc.iv_prep_yn_display.style.visibility = "hidden";
		headerDoc.iv_prep_yn.value="";
 	}

	if(obj.value == "" ) {
		removeOptions(headerDoc.order_type_td ,"OrderType");		
		return ;
	}else{
		order_category = obj.value ;
		xmlAppend += "order_category"+"=\""+ order_category+"\" " ;
		xmlAppend += "type"+"=\"OrderCategory\"" ;
		}
	}

	if(obj.name == "order_type_code" ){
	if(obj.value == "" ) {
		removeOptions(headerDoc.activity_type_td ,"ActivityType");
		return ;
	}else{
		var order_type_code = obj.value ;
		order_category = formObjHeader.order_category.value ;		
		xmlAppend += "order_category"+"=\""+ order_category+"\" " ;
		xmlAppend += "order_type_code"+"=\""+ order_type_code+"\" " ;
		xmlAppend += "type"+"=\"OrderType\"" ;
		}
	}

	xmlStr ="<root><SEARCH " ;
	xmlStr =xmlStr + xmlAppend ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
	xmlHttp.open( "POST", "OrderSetComboFill.jsp?bean_id="+bean_id.value+"&localeName="+localeName,false ) ;	
	xmlHttp.send( xmlDoc ) ;	
	responseText=xmlHttp.responseText ;
	eval(responseText ) ;
 	
 }
/********************Dynamically add Option function************************/
function addComboObject(comboObjectString,Object){

		getHandleHeader();
		if(Object == "order_category"){
		var order_type		= 	headerDoc.order_type_td ;	
		comboObjectString=comboObjectString.replace('Select',getLabel("Common.defaultSelect.label","Common"))
		order_type.innerHTML = comboObjectString ;
		}else if(Object == "order_type_code")
		{
		comboObjectString=comboObjectString.replace('Select',getLabel("Common.defaultSelect.label","Common"))
		activity_type		= 	headerDoc.activity_type_td;
		activity_type.innerHTML = comboObjectString ;
		}
		else if(Object == "iv_prep_yn") 
		{
		iv_prep_yn_td		= 	headerDoc.iv_prep_yn_td;
		var comboObjectString2="";
		if(comboObjectString == ""){
			//comboObjectString2 = "<select name='iv_prep_yn' id='iv_prep_yn'><option value=\"\">---"+getLabel('Common.defaultSelect.label','Common')+" ---</option></select><img src='../../eCommon/images/mandatory.gif'></img>";//IN062992
			comboObjectString2 = "<select name='iv_prep_yn' id='iv_prep_yn' onchange=\"parent.parent.clearAll();parent.parent.display('S')\"><option value=\"\" >---"+getLabel('Common.defaultSelect.label','Common')+" ---</option></select><img src='../../eCommon/images/mandatory.gif'></img>";//IN062992
	    
		}else{
			//comboObjectString2 = "<select name='iv_prep_yn' id='iv_prep_yn'>"+comboObjectString+"</select><img src='../../eCommon/images/mandatory.gif'></img>";//IN062992
			comboObjectString2 = "<select name='iv_prep_yn' id='iv_prep_yn' onchange=\"parent.parent.clearAll();parent.parent.display('S')\">"+comboObjectString+"</select><img src='../../eCommon/images/mandatory.gif'></img>";//IN062992
		}
		
	    iv_prep_yn_td.innerHTML = comboObjectString2 ;
	
	  	}
}
/********************Clear the Options-- function***********************/
function removeOptions(comboObject,optionName){		

	if(optionName == "OrderType"){
		var OrderType = '<select name="order_type_code" id="order_type_code" ><option value="">--- ' +getLabel("Common.defaultSelect.label","Common")+'---</option></select><img src="../../eCommon/images/mandatory.gif"></img>';	
		comboObject.innerHTML = OrderType;
	}else if(optionName == "ActivityType")
	{
		var ActivityType = '<select name="activity_type" id="activity_type" ><option value="">--- '+getLabel("Common.defaultSelect.label","Common")+' ---</option></select>';
		comboObject.innerHTML = ActivityType;
	}else if(optionName == "iv_prep_yn")
	{
		//var iv_prep_yn = '<select name="iv_prep_yn" id="iv_prep_yn" ><option value="">--- '+getLabel("Common.defaultSelect.label","Common")+' --- </option></select>';//IN062992
		var iv_prep_yn = "<select name='iv_prep_yn' id='iv_prep_yn' onchange=\"parent.parent.clearAll();parent.parent.display('S')\"><option value=''>--- "+getLabel("Common.defaultSelect.label","Common")+" --- </option></select>";//IN062992
		comboObject.innerHTML = iv_prep_yn;
	}
}
// Function for Component Tab starts here
/************************Set detail Page Mode***********************/

function setDetailPageMode(val){
detailPageMode = val;
}

/******************* When Select TAB is Clicked**********************/
function selectInsert(){

	getHandleHeader();
	getHandleDetailUpper();
	getHandleDetailLower();

	ShowHtml();

	detailUpperDoc.SelectTab.className    ="clicked";
	detailUpperDoc.AssociateTab.className ="normal";
	detailUpperDoc.forms[0].search_text.value = "";
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" ;
    if(detailPageMode != 'N'){

		if(detailLowerForm == null || detailLowerForm == undefined)
		  return ;

	 detailLowerForm.action.value="select";
	 eval(doSync(detailLowerForm)); //Syn the lower Frame

	}

	detailPageMode = 'N' ;	//Current Page mode after Blank page is loaded

}
/*******************Associated TAB*****************************/
function associated(){

	selFlag			 = true ;

	getHandleHeader();
	getHandleDetailUpper();
	getHandleDetailLower();

	changeCellStyle("hide");

	detailUpperDoc.SelectTab.className	  ="normal";
	detailUpperDoc.AssociateTab.className ="clicked";

	//IN068314 Starts
	var fpp_yn;
	if(formObjHeader.fpp_yn!=undefined)
	{
		fpp_yn = formObjHeader.fpp_yn.value;
	}
  //IN068314 Ends
	if(detailPageMode != 'N')
	{ 	//Current Page mode

		if(detailLowerForm == null || detailLowerForm == undefined)
		  return ;
		if(f_query_add_mod.detail.detailLower.document.getElementById("bean_id")!=undefined)
		{
			detailLowerForm.nextPrevFlag.value ='next';
			detailLowerForm.action.value	   ="associated";
			detailLowerForm.p_applicable_to.value =f_query_add_mod.header.document.getElementById("iv_prep_yn").value;
			eval(doSync(detailLowerForm)); //Syn the lower Frame
		}
		else
		{
			//detailLowerDoc.location.href="../../eOR/jsp/OrderSetComponentDetailForm.jsp?&action=associated" + "&order_category="+ formObjHeader.order_category.value +"&nextPrevFlag=next" + "&detailPageMode="+detailPageMode ;//IN062992
			//detailLowerDoc.location.href="../../eOR/jsp/OrderSetComponentDetailForm.jsp?&action=associated" + "&order_category="+ formObjHeader.order_category.value +"&nextPrevFlag=next" + "&detailPageMode="+detailPageMode +"&applicable_to="+formObjHeader.iv_prep_yn.value;//IN062992
			detailLowerDoc.location.href="../../eOR/jsp/OrderSetComponentDetailForm.jsp?&action=associated" + "&order_category="+ formObjHeader.order_category.value +"&nextPrevFlag=next" + "&detailPageMode="+detailPageMode +"&applicable_to="+f_query_add_mod.header.document.getElementById("iv_prep_yn").value+"&fpp_yn="+fpp_yn;//IN062992//IN068314
		}
	}
	//detailLowerDoc.location.href="../../eOR/jsp/OrderSetComponentDetailForm.jsp?&action=associated" + "&order_category="+ formObjHeader.order_category.value +"&nextPrevFlag=next" + "&detailPageMode="+detailPageMode ;//IN062992
	//detailLowerDoc.location.href="../../eOR/jsp/OrderSetComponentDetailForm.jsp?&action=associated" + "&order_category="+ formObjHeader.order_category.value +"&nextPrevFlag=next" + "&detailPageMode="+detailPageMode +"&applicable_to="+formObjHeader.iv_prep_yn.value;//IN062992
	detailLowerDoc.location.href="../../eOR/jsp/OrderSetComponentDetailForm.jsp?&action=associated" + "&order_category="+ formObjHeader.order_category.value +"&nextPrevFlag=next" + "&detailPageMode="+detailPageMode +"&applicable_to="+f_query_add_mod.header.document.getElementById("iv_prep_yn").value+"&fpp_yn="+fpp_yn;//IN068314

	detailPageMode = 'A' ;	 	//Current Page mode after upper page is loaded
}
/****** Shows alphabets and Clear the detailLower page with blank html**/
function ShowHtml(){

	getHandleDetailUpper();
	getHandleDetailLower();

	changeCellStyle("show");
	detailLowerDoc.location.href="../../eCommon/html/blank.html";
}
/*****Shows/Hide alphabets******************************/
function changeCellStyle(pattern){
getHandleDetailUpper();
if(pattern == "hide" ){
	detailUpperDoc.alphabet.style.display	 = "none" ;
	detailUpperDoc.searchTxt.style.display	 = "none" ;
}else if(pattern == "show" ){
	detailUpperDoc.alphabet.style.display	 = "inline" ;
	detailUpperDoc.alphabet.style.visibility = "visible" ;
}
}
/********************function called when index is clicked*********************/
function OderCatalogForSelIndx(indx){
	selFlag			 = true ;
	getHandleHeader();
	getHandleDetailUpper();
	getHandleDetailLower();

	var order_category = formObjHeader.order_category.value ;

	if(detailPageMode != "N"){

	if(detailLowerForm == null || detailLowerForm == undefined)
		  return ;
		if(f_query_add_mod.detail.detailLower.document.getElementById("bean_id")!=undefined)
		{
			detailLowerForm.nextPrevFlag.value			='next';
			detailLowerForm.OrderCatalogIndex.value		=indx;
			detailLowerForm.order_category.value		=order_category;
			detailLowerForm.action.value				="IndexSelect";
				eval(doSync(detailLowerForm)); //Syn the lower Frame
		//var flag = latestUpdate();
		}
		else
		{
			//detailLowerDoc.location.href="../../eOR/jsp/OrderSetComponentDetailForm.jsp?OrderCatalogIndex="+indx + "&action=IndexSelect" + "&order_category="+order_category + "&nextPrevFlag=next"  + "&detailPageMode="+detailPageMode ;//IN062992
			detailLowerDoc.location.href="../../eOR/jsp/OrderSetComponentDetailForm.jsp?OrderCatalogIndex="+indx + "&action=IndexSelect" + "&order_category="+order_category + "&nextPrevFlag=next"  + "&detailPageMode="+detailPageMode +"&applicable_to="+f_query_add_mod.header.document.getElementById("iv_prep_yn").value ;//IN062992
		}
	}

	//detailLowerDoc.location.href="../../eOR/jsp/OrderSetComponentDetailForm.jsp?OrderCatalogIndex="+indx + "&action=IndexSelect" + "&order_category="+order_category + "&nextPrevFlag=next"  + "&detailPageMode="+detailPageMode ;//IN062992
	detailLowerDoc.location.href="../../eOR/jsp/OrderSetComponentDetailForm.jsp?OrderCatalogIndex="+indx + "&action=IndexSelect" + "&order_category="+order_category + "&nextPrevFlag=next"  + "&detailPageMode="+detailPageMode +"&applicable_to="+f_query_add_mod.header.document.getElementById("iv_prep_yn").value ;//IN062992
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" ;

	detailPageMode = "S" ;	//Detail page mode becomes selected

}

/********************function called when index of orderset function is clicked*********************/

function OderCatalogForSelectedIndex(alphalink,search){
	
	var indx;
	if(search==null||search==""||search=="null")
		indx=alphalink;
	else
		indx=search;
	selFlag			 = true ;
	getHandleHeader();
	getHandleDetailUpper();
	getHandleDetailLower();

	var order_category = formObjHeader.order_category.value ;
	//IN068314 Starts
	var fpp_yn;
	if(formObjHeader.fpp_yn!=undefined)
	{
		fpp_yn = formObjHeader.fpp_yn.value;
	}
  //IN068314 Ends
	if(detailPageMode != "N"){

	//if(detailLowerForm == null || detailLowerForm == undefined)
		 // return ;
		if(detailLowerForm)
		{
			if(f_query_add_mod.detail.detailLower.document.getElementById("bean_id")!=undefined)
			{
				detailLowerForm.nextPrevFlag.value			='next';
				detailLowerForm.OrderCatalogIndex.value		=indx;
				detailLowerForm.order_category.value		=order_category;
				detailLowerForm.action.value				="IndexSelect";
				eval(doSync(detailLowerForm)); //Syn the lower Frame
			/*Added by Uma on 10/13/2009 for 15081 SRR20056-SCF-3641*/
			//var flag = latestUpdate(alphalink,search);
			}
			else
			{
				//detailLowerDoc.location.href="../../eOR/jsp/OrderSetComponentDetailForm.jsp?OrderCatalogIndex="+indx + "&action=IndexSelect" + "&order_category="+order_category + "&nextPrevFlag=next"  + "&detailPageMode="+detailPageMode ;//IN062992
				detailLowerDoc.location.href="../../eOR/jsp/OrderSetComponentDetailForm.jsp?OrderCatalogIndex="+indx + "&action=IndexSelect" + "&order_category="+order_category + "&nextPrevFlag=next"  + "&detailPageMode="+detailPageMode +"&applicable_to="+f_query_add_mod.header.document.getElementById("iv_prep_yn").value ;//IN062992
			}
		}
	}

	//detailLowerDoc.location.href="../../eOR/jsp/OrderSetComponentDetailForm.jsp?OrderCatalogIndex="+indx + "&action=IndexSelect" + "&order_category="+order_category + "&nextPrevFlag=next"  + "&detailPageMode="+detailPageMode ;//IN062992
	//detailLowerDoc.location.href="../../eOR/jsp/OrderSetComponentDetailForm.jsp?OrderCatalogIndex="+indx + "&action=IndexSelect" + "&order_category="+order_category + "&nextPrevFlag=next"  + "&detailPageMode="+detailPageMode +"&applicable_to="+formObjHeader.iv_prep_yn.value ;//IN062992
	f_query_add_mod.detail.document.querySelector("#detailUpper").style.height="33vh";
	f_query_add_mod.detail.document.querySelector("#detailLower").style.height="67vh";
	detailLowerDoc.location.href="../../eOR/jsp/OrderSetComponentDetailForm.jsp?OrderCatalogIndex="+indx + "&action=IndexSelect" + "&order_category="+order_category + "&nextPrevFlag=next"  + "&detailPageMode="+detailPageMode +"&applicable_to="+f_query_add_mod.header.document.getElementById("iv_prep_yn").value+"&fpp_yn="+fpp_yn;//IN062992//IN068314
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" ;

	detailPageMode = "S" ;	//Detail page mode becomes selected

}
/********************NExt- Prevoius function******************************/
function getNext(flagSelect)
{

	getHandleHeader();
	getHandleDetailUpper();
	getHandleDetailLower();

	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?";
	if(f_query_add_mod.detail.detailLower.document.getElementById("bean_id")!=undefined)
	{
		detailLowerForm.nextPrevFlag.value=flagSelect;//set the Flag to next or Prevoius
		detailLowerForm.action.value="nextPrevFlag";
		doSync(detailLowerForm); //Syn the lower Frame
		
		
		var nexprev=detailLowerForm.nextPrevFlag.value;
		var prev=detailLowerForm.previousRecord.value;
		var nex=detailLowerForm.nextRecord.value;
		var actionVal=detailLowerForm.action.value;
		var ordercateg=detailLowerForm.order_category.value;
		var mode=detailLowerForm.detailPageMode.value;		
		//detailLowerForm.submit();//for orderset

		//detailLowerDoc.location.href="../../eOR/jsp/OrderSetComponentDetailForm.jsp?nextPrevFlag="+nexprev + "&action="+actionVal + "&order_category="+ordercateg  + "&previousRecord="+prev + "&nextRecord="+nex+ "&detailPageMode="+mode;//IN062992
		detailLowerDoc.location.href="../../eOR/jsp/OrderSetComponentDetailForm.jsp?nextPrevFlag="+nexprev + "&action="+actionVal + "&order_category="+ordercateg  + "&previousRecord="+prev + "&nextRecord="+nex+ "&detailPageMode="+mode+"&applicable_to="+f_query_add_mod.header.document.getElementById("iv_prep_yn").value ;//IN062992
		


		
	}
}
/*******END OF CLICK FUNCTIONS***********/
/******************************************************************/
//function getDurnType(obj,index){//IN062992
function getDurnType(obj,index,calledForm)//IN062992
{
	//if(calledForm != 'orderset_dosage_age_dtl_form')//IN062992//IN065713
	//if(calledForm != 'orderset_dosage_age_dtl_form' && calledForm != 'ORD_SET_AGE_GRP' && calledForm!='additionalDetailForm')//IN062992//IN065713//IN68241
	if(calledForm != 'orderset_dosage_age_dtl_form' && calledForm != 'ORD_SET_AGE_GRP' && calledForm!='additionalDetailForm' && calledForm != 'orderset_by_dosage_type_dtl_form' && calledForm !='DOSAGE_TYPE_DEFN_ADDITIONAL')//IN062992//IN065713//IN68241
	{
		getHandleDetailUpper();
		getHandleDetailLower();
		getHandleHeader();
	}
	
	var freq_code = "";
	var xmlAppend = "";


	//IN062992, starts
	if(calledForm == 'orderset_dosage_age_dtl_form')
	{
		//IN065713, starts
		/*
		var durn_value    = eval("parent.frames[0].document.getElementById("durn_value")"+index);
		var durn_type     = eval("parent.frames[0].document.getElementById("durn_type")"+index);
		var durn_type_desc= eval("parent.frames[0].document.getElementById("durn_type_desc")"+index);

		var bean_id = parent.frames[0].document.getElementById("bean_id").value ;
		var localeName = parent.frames[0].document.getElementById("localeName").value;
		*/
		var durn_value    = eval(parent.orderset_dosage_type_dtl.document.getElementById("durn_value"+index));
		var durn_type     = eval(parent.orderset_dosage_type_dtl.document.getElementById("durn_type"+index));
		//alert(durn_type);
		var durn_type_desc= eval(parent.orderset_dosage_type_dtl.document.getElementById("durn_type_desc"+index));
	
		var bean_id = parent.orderset_dosage_type_dtl.document.getElementById("bean_id").value ;
		var localeName = parent.orderset_dosage_type_dtl.document.getElementById("localeName").value;
		//IN065713, ends
	}//IN062992, ends
	else if(calledForm == 'orderset_by_dosage_type_dtl_form')//IN68241, starts
	{	
		var durn_value    = eval(parent.orderset_dosage_type_dtl.document.getElementById("durn_value"+index));
		var durn_type     = eval(parent.orderset_dosage_type_dtl.document.getElementById("durn_type"+index));
		var durn_type_desc= eval(parent.orderset_dosage_type_dtl.document.getElementById("durn_type_desc"+index));	
		var bean_id = parent.orderset_dosage_type_dtl.document.getElementById("bean_id").value ;
		var localeName = parent.orderset_dosage_type_dtl.document.getElementById("localeName").value;		
	}//IN68241, ends
	else if(calledForm == 'ORD_SET_AGE_GRP')//IN065713, starts
	{
		var durn_value    = eval(document.getElementById("durn_value"+index));
		var durn_type     = eval(document.getElementById("durn_type"+index));
		var durn_type_desc= eval(document.getElementById("durn_type_desc"+index));
	
		var bean_id = document.getElementById("bean_id").value ;
		var localeName = document.getElementById("localeName").value;
	}
	else if(calledForm == 'additionalDetailForm')
	{
		var durn_value    = eval(document.getElementById("durn_value"+index));
		var durn_type     = eval(document.getElementById("durn_type"+index));
		var durn_type_desc= eval(document.getElementById("durn_type_desc"+index));
	
		var bean_id = document.getElementById("bean_id").value ;
		var localeName = document.getElementById("localeName").value;
	}//IN065713, ends
	else if(calledForm == 'DOSAGE_TYPE_DEFN_ADDITIONAL')
	{
		var durn_value    = eval(parent.orderset_dosage_type_dtl.document.getElementById("durn_value"+index));
		var durn_type     = eval(parent.orderset_dosage_type_dtl.document.getElementById("durn_type"+index));
		var durn_type_desc= eval(parent.orderset_dosage_type_dtl.document.getElementById("durn_type_desc"+index));	
		var bean_id = parent.orderset_dosage_type_dtl.document.getElementById("bean_id").value ;
		var localeName = parent.orderset_dosage_type_dtl.document.getElementById("localeName").value;	
	}
	else//IN062992
	{
		var durn_value    = eval("detailLowerDoc.durn_value"+index);
		var durn_type     = eval("detailLowerDoc.durn_type"+index);
		var durn_type_desc= eval("detailLowerDoc.durn_type_desc"+index);
	
		var bean_id = formObjHeader.bean_id ;
		var localeName = formObjHeader.localeName.value;
	}//IN062992

	durn_value.value		= "";  //reset on change of the freq
	durn_type.value			=""; //reset on change of the freq

	if(obj.value == "" )
	{
	   durn_value.disabled			=  true; //when freq is selected in null disabled the feild
	   durn_value.value				=   "";
	   durn_type.value				=	"";
	   durn_type_desc.value			=	"";
	   return ;
	}
	else
	{
		freq_code = obj.value ;
		xmlAppend += "freq_code"+"=\""+ freq_code+"\" " ;
		xmlAppend += "index"+"=\""+ index+"\" " ;
		xmlAppend += "type"+"=\"freq_code\" " ;
		xmlAppend += "calledForm"+"=\""+ calledForm+"\" " ;//IN062992
		durn_value.disabled	     	=  false; //when freq is selected in not null Enable the feild
   }

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr =xmlStr + xmlAppend ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderSetComboFill.jsp?bean_id="+bean_id.value+"&localeName="+localeName,false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;	
	eval(responseText ) ;

}
/*********TO DEFAULT DURATION TYPE AND VALUE*************************/
//function addDurnObject(durn_type,durn_value,durn_desc,index)//IN062992
function addDurnObject(durn_type,durn_value,durn_desc,index, calledForm)//IN062992
{
	//IN062992, starts
	//getHandleDetailLower();

	//alert("1109,calledForm=>"+calledForm);
	if(calledForm == 'orderset_dosage_age_dtl_form')
	{
		//ageWiseDet = parent.frames[0].document;//IN065713
		ageWiseDet = parent.orderset_dosage_type_dtl.document;//IN065713

		var durn_type_Obj        = eval("ageWiseDet.durn_type"+index);
		var durn_type_desc_Obj   = eval("ageWiseDet.durn_type_desc"+index);
		durn_type_Obj.value	= durn_type ;
		//IN065713, starts
		/*if(durn_type == "H") durn_type = "Hour(s)";
		if(durn_type == "D") durn_type = "Day(s)";
		if(durn_type == "W") durn_type = "Week(s)";
		if(durn_type == "L") durn_type = "Month(s)";
		if(durn_type == "M") durn_type = "Minute(s)";
		durn_type_desc_Obj.value	= durn_type ;*/
		//IN065713, ends
		
	}
	else if(calledForm == 'orderset_by_dosage_type_dtl_form' || calledForm == 'DOSAGE_TYPE_DEFN_ADDITIONAL')//IN68241, starts
	{
		var durn_type_Obj        = eval(parent.orderset_dosage_type_dtl.document.getElementById("durn_type"+index));
		var durn_type_desc_Obj   = eval(parent.orderset_dosage_type_dtl.document.getElementById("durn_type_desc"+index));
		durn_type_Obj.value	= durn_type ;		
	}//IN68241, ends
	else if(calledForm == 'ORD_SET_AGE_GRP')
	{
		var durn_type_Obj        = eval(document.getElementById("durn_type"+index));
		var durn_type_desc_Obj   = eval(document.getElementById("durn_type_desc"+index));
		durn_type_Obj.value	= durn_type ;		
	}
	else if(calledForm == 'additionalDetailForm')
	{
		var durn_type_Obj        = eval(document.getElementById("durn_type"+index));
		var durn_type_desc_Obj   = eval(document.getElementById("durn_type_desc"+index));
		durn_type_Obj.value	= durn_type ;	
	}	
	else
	{
		getHandleDetailLower();
		var durn_type_Obj        = eval("detailLowerDoc.durn_type"+index);
		var durn_type_desc_Obj   = eval("detailLowerDoc.durn_type_desc"+index);
		durn_type_Obj.value	= durn_type ;
		//IN065713, starts
		/*if(durn_type == "H") durn_type = "Hour(s)";
		if(durn_type == "D") durn_type = "Day(s)";
		if(durn_type == "W") durn_type = "Week(s)";
		if(durn_type == "L") durn_type = "Month(s)";
		if(durn_type == "M") durn_type = "Minute(s)";
		durn_type_desc_Obj.value	= durn_type ;*/
		//IN065713, ends
	}
	
	durn_type_desc_Obj.value = decodeDesc(durn_type);//IN065713
	//IN062992, ends	
}
/******************Check Valid time*************************************/
function timeChk(time1)
{
var time = time1.value;
var	retFlag = true ;

if(time == "" || time ==null) return ;

getHandleDetailUpper();

if(!(f_query_add_mod.detail.detailUpper.chkTime(time)))
retFlag = false;


if(!retFlag)
{
	time1.value="";
	time1.focus();
}

var message  = getMessage("INVALID_TIME_FMT");

if(!retFlag)	
{
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
	return false ;
}
else
{
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
}

}


//this function will give the final xml string on click of apply
function beforePost(str) {
}

//Function for Component tab ends here

/*****************************show dialog box on click of comnts link***************/
//function showDialog(index) //IN062992
async function showDialog(index,calledFrom)//IN062992
{
		var dialogHeight ='30vh' ;
		var dialogWidth = '45vw' ;
		var dialogTop	= '291';
		var dialogLeft = '157' ;

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

		var arguments = "";		

		//IN062992, starts
		if(calledFrom == "orderset_dosage_age_dtl_form")
		{
			//var currCmntsTxtObj=eval('frames[0].document.getElementById("prompt_msg")'+index);//IN065713
			var currCmntsTxtObj=eval('orderset_dosage_type_dtl.document.getElementById("prompt_msg")'+index);//IN065713
			var currCmntsTxt		  =	currCmntsTxtObj.value;
			//var detailPageMode		  =	frames[0].document.getElementById("detailPageMode").value;//IN065713
			var detailPageMode		  =	orderset_dosage_type_dtl.document.getElementById("detailPageMode").value;//IN065713
			//var eff_status			  = frames[0].document.getElementById("eff_status").value;
			var eff_status = "";
			var l_valid =  orderset_dosage_type_dtl.document.getElementById("valid").value;
		}//IN062992, ends
		else if(calledFrom == "orderset_by_dosage_type_dtl_form")//IN68241, starts
		{
			var currCmntsTxtObj=eval(document.getElementById("prompt_msg"+index));
			var currCmntsTxt		  =	currCmntsTxtObj.value;
			var detailPageMode		  =	document.getElementById("detailPageMode").value;
			var l_valid =  document.getElementById("valid").value;
			var eff_status = "";
		}//IN68241, ends
		else//IN062992
		{//IN062992
			getHandleDetailLower();
			var currCmntsTxtObj=eval('detailLowerForm.prompt_msg'+index);

			var currCmntsTxt		  =	currCmntsTxtObj.value;
			var detailPageMode		  =	detailLowerForm.detailPageMode.value;
			var eff_status			  = detailLowerForm.eff_status.value;	
			var l_dis_comments = eval("detailLowerForm.dis_comments"+index).value;//IN065021
		}//IN062992


		if(currCmntsTxt != ""){
			currCmntsTxt = trimString(currCmntsTxt);
		}

		//var retVals = window.showModalDialog("../../eOR/jsp/OrderSetModal.jsp?currCmntsTxt="+escape(currCmntsTxt)+"&detailPageMode="+detailPageMode+"&eff_status="+eff_status+"&"+qry_str,arguments,features);//IN065021
		//var retVals = window.showModalDialog("../../eOR/jsp/OrderSetModal.jsp?currCmntsTxt="+escape(currCmntsTxt)+"&detailPageMode="+detailPageMode+"&eff_status="+eff_status+"&"+"dis_comments="+l_dis_comments+"&"+qry_str,arguments,features);//IN065021
		//var retVals = window.showModalDialog("../../eOR/jsp/OrderSetModal.jsp?currCmntsTxt="+escape(currCmntsTxt)+"&detailPageMode="+detailPageMode+"&eff_status="+eff_status+"&"+"dis_comments="+l_dis_comments+"&"+qry_str+"&p_called_from="+calledFrom,arguments,features);//IN065021
		var retVals =await window.showModalDialog("../../eOR/jsp/OrderSetModal.jsp?currCmntsTxt="+escape(currCmntsTxt)+"&detailPageMode="+detailPageMode+"&eff_status="+eff_status+"&"+"dis_comments="+l_dis_comments+"&"+qry_str+"&p_called_from="+calledFrom+"&valid="+l_valid,arguments,features);//IN065021

		if(retVals != ""){
		 	currCmntsTxtObj.value	 =  trimString(retVals);
		}
}

function checkIsValidForProceed()
{
		 var url = f_query_add_mod.location.href;
		 var canApply = "N";//IN068370,IN068373
		 
			//IN068370, starts
      if(f_query_add_mod.isCatalogApplyAppl!=null) 
				canApply =  f_query_add_mod.isCatalogApplyAppl.value;
      //IN068370,, ends
		url = url.toLowerCase();

		 //IN068370,IN068373, starts
     if (canApply == 'N')
				return false;
      //if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		 else if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )//IN068370,IN068373, ends
				return true;
		else
				return false;
}

function checkValid(obj,event,val1,val2) 
{
	if (event.keyCode == 13) 
	{
 		event.keyCode = "";
 		return;
 	}
	else 
	{
 		return allowValidNumber(obj,event,val1,val2);
 	}
} 


/************************************************************************************/


function show_qty_uom_window(target,code,i){

		getHandleDetailLower();
		if(detailLowerForm!=null)
		{

//			show_qty_uom_Lookupwindow(target,code,i,defaultUOM);
			if(target.value != "")
			{
				show_qty_uom_Lookupwindow(target,code,i);
			}
		}
}

// function show_qty_uom_Lookupwindow(target,qty_uom,i,defaultUOM){

async function show_qty_uom_Lookupwindow(target,qty_uom,i)
{
	await getHandleDetailLower();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;	
	
	var sql="select uom_code code,short_Desc description from AM_UOM where eff_Status = 'E' and upper(uom_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
	argumentArray[0]	=  sql;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = f_query_add_mod.detail.detailLower.CODE_LINK ;
	argumentArray[7]   = f_query_add_mod.detail.detailLower.CODE_DESC ;
	retVal = await f_query_add_mod.detail.detailLower.uomLookup( getLabel("Common.uom.label","Common"), argumentArray );
	var ret1=unescape(retVal);
	 var arr=ret1.split(",");
		if(arr[1]==undefined) 
		{
			arr[0]="";	
			arr[1]="";	
		}
 	if(retVal != null && retVal != ""){
   		target.value = arr[1];
 		qty_uom.value =arr[0] ;	


 	}else{
   		target.value = "";
   		qty_uom.value = "" ;
 	}
}
async function uomLookup(title, pArgumentArray) {
	var retVal = new String();
	    /*
	    var dialogHeight= "30" ; 
	    var dialogWidth = "50" ;
	    */
	    
	    var dialogTop   = "10px";
	    var dialogHeight= "85vh" ;
	    var dialogWidth = "85vw" ;
	    
	    var status = "no";
		//var fin_Val=pArgumentArray.split(",");
	    var xmlDoc = "" ;
	    var xmlHttp = new XMLHttpRequest() ;

		firstCodeVal = "" ;
		firstDescVal = "" ;

	    xmlStr ="<root><SEARCH " ;
	    xmlStr +=" /></root>" ;
	    
	    // added for PE on 26th April 2010
	    
	    if (pArgumentArray[5] != "")
	    {
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "GET", "../../eCommon/jsp/CommonLookupResult.jsp?callFrom=0&" + formQueryString(pArgumentArray,0) , false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			responseText = trimString(responseText);
			eval(responseText) ;
		}
	    if(firstCodeVal == "")
	    {

			var dialogUrl       = "../../eCommon/jsp/CommonLookup.jsp?title="+title;
			
			pArgumentArray[9] = title;

			var dialogArguments = pArgumentArray ;
	        var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	        
	        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	        
			//var returnVal = window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);	
	        
	        var returnVal = "";  
	        
	        returnVal =   await top.window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);	
	        
	        if( returnVal == null || returnVal == "" )
	            return "";
	        else
	            return returnVal.split("\"") ;
			
	     }
		 
	     else
	     {
	         if(pArgumentArray[7] == CODE_DESC )
	         {
	            var temp = firstCodeVal
	            firstCodeVal = firstDescVal
	            firstDescVal = temp
	         }
			 
	          returnVal = firstCodeVal + "\"" + firstDescVal

	         return returnVal.split("\"") ;
	     }
	}
function show_qty_uom_Lookup(target,qty_uom,i)
{
	if(target.value!="")
	{
		show_qty_uom_Look(target,qty_uom,i);
	}
}
async function show_qty_uom_Look(target,qty_uom,i)
{
		
 	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;	
	
	
	argumentArray[0]	=  "select uom_code code,short_Desc description from AM_UOM where eff_Status = 'E' and upper(uom_code) like upper(?) and upper(short_desc) like upper(?) order by 2" ;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value ;
	argumentArray[6]   =CODE_LINK ;
	argumentArray[7]   =CODE_DESC ;
	retVal = await CommonLookup( getLabel("Common.uom.label","Common"), argumentArray );
 	if(retVal != null && retVal != "")
	{
   		target.value = retVal[1];
 		qty_uom.value =retVal[0] ;	
 	}
	else
	{
   		target.value = "";
   		qty_uom.value = "" ;
 	}
 }
function callAdditionalRows(index)
{	
	var oCell;
    var oRow;
    var rowId;
	var queryString ="";
	var trText = eval(document.getElementById("row"+index));
	var eff_status=document.getElementById("eff_status").value;
	var order_category=document.getElementById("order_category").value;
	var seq_num = eval(document.getElementById("order_set_seq_num"+index)).value;
	var l_invoke_func = eval(document.getElementById("p_invoke_func")).value;
	var l_appl_to = document.getElementById("p_appl_to").value;// eval("parent.parent.header.document.getElementById("iv_prep_yn")").value;	
	
	if(seq_num == "")
	{
		alert(getMessage('SEQ_NO_NOT_BLANK','OR'));
		return;
	}
	else
	{
		//queryString = queryString + "&order_category_desc="+trText.cells[2].innerText//IN065144, existing bug found
		if("DOSAGE_TYPE_DEFN" == l_invoke_func)
		{
			queryString = queryString + "&order_category_desc="+encodeURIComponent(document.getElementById("p_order_catalog_desc").value,'UTF-8');
			queryString +="&order_category_code="+document.getElementById("p_order_catalog_code").value;
			queryString +="&order_type="+document.getElementById("p_order_type_code").value;
			queryString += "&p_fetch_dosage_type="+eval(document.getElementById("p_fetch_dosage_type"+index)).value;
		}
		else
		{
			queryString = queryString + "&order_category_desc="+encodeURIComponent(trText.cells[2].innerText,'UTF-8');//IN065144, existing bug found
			queryString +="&order_category_code="+trText.cells[1].innerText;
			queryString +="&order_type="+trText.cells[4].innerText;
		}	
		
		queryString +="&order_set_seq_num="+eval(document.getElementById("order_set_seq_num"+index)).value;
		queryString +="&qty_value="+eval(document.getElementById("qty_unit"+index)).value;
		queryString +="&qty_uom_desc="+encodeURIComponent(eval(document.getElementById("qty_uom_desc"+index)).value);
		queryString +="&freq_code="+eval(document.getElementById("freq_code"+index)).value ;
		queryString +="&durn_value="+eval(document.getElementById("durn_value"+index)).value	;
		queryString +="&durn_type_desc="+eval(document.getElementById("durn_type_desc"+index)).value;
		queryString +="&rel_start_date_time="+eval(document.getElementById("rel_start_date_time"+index)).value;
		queryString +="&reqd_or_opt_ind="+eval(document.getElementById("reqd_or_opt_ind"+index)).value;
		queryString +="&durn_type="+eval(document.getElementById("durn_type"+index)).value;
		queryString +="&qty_uom="+eval(document.getElementById("qty_uom"+index)).value;
		queryString +="&route_code="+eval(document.getElementById("route_code"+index)).value;
		//queryString +="&prompt_msg="+eval("document.getElementById("prompt_msg")"+index).value;//IN065144
		queryString +="&prompt_msg="+encodeURIComponent(eval(document.getElementById("prompt_msg"+index)).value,'UTF-8');//IN065144
		//queryString +="&occ_no="+eval("document.getElementById("occ_no")"+index).value;
		queryString +="&eff_status="+eff_status;
		queryString +="&order_category="+order_category;
		if(l_invoke_func == 'DOSAGE_TYPE_DEFN')
			queryString +="&p_invoke_func=DOSAGE_TYPE_DEFN";//IN065713
		else
		queryString +="&p_invoke_func=additionalDetailForm";//IN065713
		queryString +="&p_appl_to="+l_appl_to;//IN065713

		var retVal = 	new String();
		var dialogHeight= "50" ;
		var dialogWidth	= "100" ;
		var status = "no";
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no;  status:" + status;
		queryString+="&modal_yn=Y";
		
		if("DOSAGE_TYPE_DEFN" == l_invoke_func)
		{
			retVal=window.showModalDialog("../jsp/OrdersetComponentDetailAddedFrame.jsp?"+queryString,arguments,features);
		}
		else
		{
			retVal=window.showModalDialog("../../eOR/jsp/OrdersetComponentDetailAddedFrame.jsp?"+queryString,arguments,features);
		}
	}	
}

function checkDecimal1(obj)
{ //Don't remove this

  if(!OrCheckPositiveNumber1(obj))
  {
	  return ;
  }
  else
 {
  	    var objVal  = obj.value ;
		if(objVal.indexOf(".") != -1) 
		{
		  	alert(getMessage('DECIMAL_NOT_ALLOWED','OR'));
			obj.focus();
			obj.value = "";
		}
  }
}
function checkDecimal2(obj)
{ 

   if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0 ) {	 
	   if(obj.value.indexOf(".") != -1) 
		{
		  	alert(getMessage('DECIMAL_NOT_ALLOWED','OR'));
			obj.select();
            obj.focus();
		}
		if ( obj.value=="-0" ) {
            alert(getMessage("ONLY_POSITIVE_NUM", "SM"));
            obj.select();
            obj.focus();
        }
		}
    else {
        if ( obj.value.length > 0 ) {
            alert(getMessage("ONLY_POSITIVE_NUM", "SM"));
            obj.select();
            obj.focus();
        }		
    }
}
async function showDia(index) 
{

		var dialogHeight ='11' ;
		var dialogWidth = '30' ;
		var dialogTop	= '291';
		var dialogLeft = '157' ;

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

		var arguments = "";
		//IN065713, starts
		/*var formObj = parent.orderset_order_dtl.additionalDetailForm;
		var currCmntsTxtObj = eval('formObj.document.getElementById("prompt_msg")'+index);*/		

		var currCmntsTxtObj = eval(document.getElementById("prompt_msg"+index));

		//IN065713, ends
		var currCmntsTxt		  =	currCmntsTxtObj.value;
		var detailPageMode		  =	"A";
		var eff_status			  = "";

		if(currCmntsTxt != "")
		{
			currCmntsTxt = trimString(currCmntsTxt);
		}

		var retVals = await window.showModalDialog("../../eOR/jsp/OrderSetModal.jsp?currCmntsTxt="+escape(currCmntsTxt)+"&detailPageMode="+detailPageMode+"&eff_status="+eff_status+"&"+qry_str,arguments,features);


		if(retVals != "")
		{
		 	currCmntsTxtObj.value	 =  trimString(retVals);
		}

}
function getDrnType(obj,index)
{

var freq_code = "";
var  xmlAppend = "";


var durn_value    = eval("detailLowerDoc1.durn_value"+index);
var durn_type     = eval("detailLowerDoc1.durn_type"+index);
var durn_type_desc= eval("detailLowerDoc1.durn_type_desc"+index);

var bean_id				= detailLowerDoc1.bean_id.value ;

var localeName      =detailLowerDoc1.localeName.value;

durn_value.value		= "";  //reset on change of the freq
durn_type.value			=""; //reset on change of the freq

	if(obj.value == "" )
		{
		   durn_value.disabled			=  true; //when freq is selected in null disabled the feild
		   durn_value.value				=   "";
   		   durn_type.value				=	"";
		   durn_type_desc.value			=	"";
		   return ;
		}else{
		freq_code = obj.value ;
		xmlAppend += "freq_code"+"=\""+ freq_code+"\" " ;
		xmlAppend += "index"+"=\""+ index+"\" " ;
		xmlAppend += "type"+"=\"freq_code\"" ;
		 durn_value.disabled	     	=  false; //when freq is selected in not null Enable the feild
	   }

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr =xmlStr + xmlAppend ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderSetComboFill.jsp?bean_id="+bean_id.value+"&localeName="+localeName,false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;

	eval(responseText ) ;

}

//function clearChecked()//IN065713
function clearChecked(invoked_from_page)//IN065713
{
	//window.close();//IN065713
	//IN065713, starts
	var l_invoke_func = document.getElementById("p_invoke_func").value;
	//var l_appl_to = parent.frames[0].document.getElementById("iv_prep_yn").value;

	if(invoked_from_page == 'ADDITIONAL_CANCEL_BUTTON' && l_invoke_func=='ORD_SET_AGE_GRP')
	{
		var l_query_string = document.getElementById("p_query_string").value;
		
		//parent.orderset_dosage_type_hdr.document.getElementById('age_grp_add_cata_tab').className = 'normal';
		//parent.orderset_dosage_type_hdr.document.getElementById('age_grp_tab').className = 'clicked';		
		parent.orderset_dosage_type_dtl.document.location.href='../jsp/OrderSetDosageTypeAgeWiseDetails.jsp?'+l_query_string;
		parent.orderset_dosage_type_btn.document.location.href='../jsp/OrderSetDosageTypeAgeWiseButtons.jsp?'+l_query_string;			
	}
	else if(l_invoke_func=='DOSAGE_TYPE_DEFN' && invoked_from_page=='ADDITIONAL_CANCEL_BUTTON')
	{
		var l_query_string = document.getElementById("p_query_string").value;
		
		//l_query_string = l_query_string+"&p_appl_to="+l_appl_to;		
		//parent.orderset_dosage_age_hdr.document.getElemenById('age_grp_add_cata_tab').className = 'normal';
		//parent.orderset_dosage_age_hdr.document.getElementById('age_grp_tab').className = 'clicked';
		parent.orderset_dosage_type_dtl.document.location.href='../jsp/OrderSetDosageByTypeDefinition.jsp?'+l_query_string;
		parent.orderset_dosage_type_btn.document.location.href='../jsp/OrderSetDosageByTypeDefinitionButtons.jsp?'+l_query_string;			
	}
	else if(l_invoke_func=='DOSAGE_TYPE_DEFN_ADDITIONAL' && invoked_from_page=='ADDITIONAL_CANCEL_BUTTON')
	{
		var l_query_string = document.getElementById("p_query_string").value;
		
		//parent.orderset_dosage_age_hdr.document.getElementById('age_grp_add_cata_tab').className = 'normal';
		//parent.orderset_dosage_age_hdr.document.getElementById('age_grp_tab').className = 'clicked';		
		
		parent.orderset_dosage_type_dtl.document.location.href='../jsp/OrderSetDosageByTypeDefinition.jsp?'+l_query_string;
		parent.orderset_dosage_type_btn.document.location.href='../jsp/OrderSetDosageByTypeDefinitionButtons.jsp?'+l_query_string;			
	}
	else if(invoked_from_page=='AGE_WISE_CANCEL_BUTTON')
	{
		var l_query_string = document.getElementById("p_query_string").value;		
		//parent.orderset_dosage_age_hdr.document.getElementById('age_grp_add_cata_tab').className = 'normal';
		//parent.orderset_dosage_age_hdr.document.getElementById('age_grp_tab').className = 'clicked';		
		parent.orderset_dosage_type_dtl.document.location.href='../jsp/OrderSetDosageByTypeDefinition.jsp?'+l_query_string;
		parent.orderset_dosage_type_btn.document.location.href='../jsp/OrderSetDosageByTypeDefinitionButtons.jsp?'+l_query_string;			
	}
	else
	{//IN065713, ends
		window.close();		
	}//IN065713
}

function ordersetadded()
{
	var no_of_checked = 0;
	var formObj = parent.orderset_order_dtl.detailForm;
	var arguments = "";
	flag = false
	for(cnt=0; cnt<9; cnt++){
		
		val = eval("parent.orderset_order_dtl.detailForm.include"+cnt);
		
		
if(eval("parent.orderset_order_dtl.detailForm.include"+cnt))
		{
		if(val.checked == true){
			no_of_checked++;
		}
	}
	}

	if(parseInt(no_of_checked,10) == 0){
		alert(getMessage('CLICK_ANY_ONE','OR'));
		return false
	}
	
if(parseInt(no_of_checked,10) > 0){
			
    		eval(formApply( parent.orderset_order_dtl.detailForm,OR_CONTROLLER)) ;
			var msg_array=new Array();
			var multi_message="";
			if(messageGlobal=="RECORD_MODIFIED")
			{
				alert("Operation Completed Successfully");
				window.close();
			}
			else
			{
					if(messageGlobal.indexOf("<br>")!=-1)
					{
						msg_array=messageGlobal.split("<br>");
						for(m=0;m<msg_array.length;m++)
						{
								multi_message=multi_message+msg_array[m]+"\n";
						}
						alert(multi_message);
					}
					else
					{
						alert(messageGlobal);
					}

			}
			// messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ messageGlobal;
			
}
}

//function Includes(index,order_category)//IN062992
//function Includes(index,order_category,appl_to)//IN062992
function Includes(index,order_category,appl_to,fetch_dosage_type)//IN062992
{
	//if(order_category=="PH")//IN062992
	//if(order_category=="PH" && appl_to != 'C')//IN062992//IN065713
	if(order_category=="PH")//IN065713
	{		

	if((eval(document.getElementById("include"+index)).checked)== true)
	{
		if(fetch_dosage_type=='A'){
			var hyper_link_val="<a href=\"javascript:showDosageAgeWiseDetails('"+index+"')\"><img src='..//images//Age.gif\'></a>";	
			eval(document.getElementById("Includes"+index)).innerHTML=hyper_link_val;
			eval(document.getElementById("Includes"+index)).style.visibility='visible';
		}
		else{
		var hyper_link_val="<a href=\"javascript:callAdditionalRows('"+index+"')\">+</a>";//IN68241	
		eval(document.getElementById("Includes"+index)).innerHTML=hyper_link_val;
		eval(document.getElementById("Includes"+index)).style.visibility='visible';//IN68241
		}
	}
	else
	{
		eval(document.getElementById("Includes"+index)).innerHTML="";
	}
	}
}

//function showIncluded(order_category)//IN062992
function showIncluded(order_category,appl_to)//IN062992
{
	var startIndex = document.getElementById("previousRecord").value;//IN066717
	var endIndex = document.getElementById("nextRecord").value;//IN066717
	//if(order_category=="PH")//IN062992
	//if(order_category=="PH" && appl_to != 'C')//IN062992//IN065713
	if(order_category=="PH")//IN062992//IN065713
	{
		//for(i=0;i<7;i++)//IN066717
		for(var i=parseInt(startIndex)-1;i<parseInt(endIndex);i++)//IN066717
		{
			var l_dosage_type = eval(document.getElementById("dosage_type"+i));//IN065713
			
			if(eval(document.getElementById("include"+i)))
			{				
				//IN065713, starts
				if(l_dosage_type != undefined)
				{
					if(eval(document.getElementById("include"+i)).checked == true && l_dosage_type.value != 'A')
					{
						var hyper_link_val="<a href=\"javascript:callAdditionalRows('"+i+"')\">+</a></font>";	
						eval(document.getElementById("Includes"+i)).innerHTML=hyper_link_val;					
					}
					else
					{
						eval(document.getElementById("Includes"+i)).innerHTML="";
					}
				}
				else
				{//IN065713, ends
					if((eval(document.getElementById("include"+i)).checked)== true)
					{
						var hyper_link_val="<a href=\"javascript:callAdditionalRows('"+i+"')\">+</a></font>";	
						eval(document.getElementById("Includes"+i)).innerHTML=hyper_link_val;
					}
					else
					{
						eval(document.getElementById("Includes"+i)).innerHTML="";
					}
				}//IN065713
			}

		}
	}
}

function show_route_window(target,code,i,from)
{
	if(from=='detailLowerForm')
	{
			getHandleDetailLower();
			if(detailLowerForm!=null)
			{
				if(target.value != "")
					show_route_Lookupwindow(target,code,i,from);
				else//IN062992
					code.value  = "";//IN062992
			}
	}
	else
	{
			if(target.value != "")
				show_route_Lookupwindow(target,code,i,from);
			else//IN062992
				code.value  = "";//IN062992
	}
}

async function show_route_Lookupwindow(target,route,i,from){	
 // if(target.value == "")
  //{
	if(from=='detailLowerForm')
	{
		await getHandleDetailLower();
	}

	var sql="select a.ROUTE_CODE code, a.ROUTE_DESC  description from PH_ROUTE a, PH_ROUTE_FOR_FORM b,ph_drug c where c.Drug_code=? and b.form_code=c.form_code and a.route_code=b.route_code and upper(a.route_code) like upper(?) and upper(a.route_desc) like upper(?) order by 2";
	
	if(from=='detailLowerForm')
	{
		//var cat_code = trimString(eval(detailLowerForm.getElementById("order_catalog_code"+i).innerText));
		var cat_code = trimString(detailLowerForm.querySelector("#order_catalog_code" + i).innerText);
		sql=sql.replace('?',"'"+cat_code+"'");
	}
	else if(from=='orderset_dosage_age_dtl_form')//IN062992, starts
	{
		//var cat_code = trimString(eval("frames[0].document.getElementById("order_catalog_code")").value);//IN065713
		//var cat_code = trimString(eval("orderset_dosage_age_dtl.document.getElementById("order_catalog_code")").value);//IN065713
		var cat_code = trimString(eval(orderset_dosage_type_dtl.document.getElementById("order_catalog_code")).value);//IN065713
		sql=sql.replace('?',"'"+cat_code+"'");
	}//IN062992, ends
	else if(from=='orderset_by_dosage_type_dtl_form')
	{	
		var cat_code = trimString(parent.orderset_dosage_type_dtl.document.getElementById("p_order_catalog_code").value);
		sql=sql.replace('?',"'"+cat_code+"'");
	}
	else
	{		
		sql=sql.replace('?',"'"+eval(document.getElementById("order_catalog_code"+i)).value+"'");
	}
	
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;	

	argumentArray[0]	=  sql;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value ;
	if(from=='detailLowerForm')
	{
		argumentArray[6]   = f_query_add_mod.detail.detailLower.CODE_LINK ;
		argumentArray[7]   = f_query_add_mod.detail.detailLower.CODE_DESC ;
		retVal = f_query_add_mod.detail.detailLower.uomLookup( getLabel("Common.Route.label","Common"), argumentArray );
	}
	else
	{
		argumentArray[6]   = CODE_LINK ;
		argumentArray[7]   = CODE_DESC ;
		retVal = await CommonLookup( getLabel("Common.Route.label","Common"), argumentArray );
		var ret1=unescape(retVal);
		 var arr=ret1.split(",");
			if(arr[1]==undefined) 
			{
				arr[0]="";	
				arr[1]="";	
			}
 	if(retVal != null && retVal != ""){
   		target.value = arr[1];
 		route.value =arr[0] ;	
 	}else{
   		target.value = "";
   		route.value = "" ;
 	}
  //}
}
}

function showChargeTypeApplicable(obj)
{
	if (obj.value == 'S') 
	{
		//f_query_add_mod.detail.detailUpper.detailUpperForm.bill_yn.value="Y"
		f_query_add_mod.detail.detailUpper.document.getElementById("bill_yn").value="Y"
		//f_query_add_mod.detail.detailUpper.detailUpperForm.ChargeTypeApplicable_lbl_td.innerHTML 	= getLabel("eOR.chargetypeapplicable.label","OR");
		f_query_add_mod.detail.detailUpper.document.getElementById("ChargeTypeApplicable_lbl_td").innerHTML = getLabel("eOR.chargetypeapplicable.label","OR");
		//f_query_add_mod.detail.detailUpper.detailUpperForm.ChargeTypeApplicable_td.innerHTML		= "<select name=\"charge_type_applicable\" id=\"charge_type_applicable\"><option  value=\"S\" selected>"+getLabel('Common.single.label','Common')+"</option><option  value=\"M\">"+getLabel('eOR.Multi.label','OR')+"</option></select>";
		f_query_add_mod.detail.detailUpper.document.getElementById("ChargeTypeApplicable_td").innerHTML	= "<select name=\"charge_type_applicable\" id=\"charge_type_applicable\"><option  value=\"S\" selected>"+getLabel('Common.single.label','Common')+"</option><option  value=\"M\">"+getLabel('eOR.Multi.label','OR')+"</option></select>";
		//IN072524 Starts
		if(null!=formObjHeader.document.getElementById("fpp_yn") && undefined!=formObjHeader.document.getElementById("fpp_yn") && 'Y'==formObjHeader.document.getElementById("fpp_yn").value)
		{
		f_query_add_mod.detail.detailUpper.detailUpperForm.fppCategoryApplicable_lbl_td.style.visibility ='visible';
		f_query_add_mod.detail.detailUpper.detailUpperForm.fppCategoryApplicable_td.style.visibility ='visible';
		f_query_add_mod.detail.detailUpper.detailUpperForm.fppCategoryApplicable_lbl_td.innerHTML 	= getLabel("eOR.FPPCATEGORYS.label","OR");
		f_query_add_mod.detail.detailUpper.detailUpperForm.fppCategoryApplicable_td.innerHTML 	= "<select name=\"fpp_category\" id=\"fpp_category\"><option  value=\"S\" selected>"+getLabel('eOR.Simple.label','Common')+"</option><option  value=\"M\">"+getLabel('eOR.Medium.label','OR')+"</option><option  value=\"C\">"+getLabel('eOR.Complex.label','OR')+"</option></select>";
		}
		//IN072524 ends
	} 
	else 
	{
		//console.log(parent.window[2].window[1].window[0].document.getElementById("fpp_yn"));
		if(null!=parent.window[2].window[1].window[0].document.getElementById("fpp_yn") && undefined!=parent.window[2].window[1].window[0].document.getElementById("fpp_yn") && 'Y'==parent.window[2].window[1].window[0].document.getElementById("fpp_yn").value)//IN072524
		{
		f_query_add_mod.detail.detailUpper.detailUpperForm.fppCategoryApplicable_lbl_td.style.visibility ='hidden';//IN072524
		f_query_add_mod.detail.detailUpper.detailUpperForm.fppCategoryApplicable_td.style.visibility ='hidden';//IN072524
		}//IN072524
		//console.log(f_query_add_mod.detail.detailUpper.document.getElementById("bill_yn"))
		//f_query_add_mod.detail.detailUpper.detailUpperForm.bill_yn.value="N";
		f_query_add_mod.detail.detailUpper.document.getElementById("bill_yn").value="N";
		//f_query_add_mod.detail.detailUpper.detailUpperForm.charge_type_applicable.value 		= "";
		f_query_add_mod.detail.detailUpper.document.getElementById("charge_type_applicable").value 		= "";
		//f_query_add_mod.detail.detailUpper.detailUpperForm.ChargeTypeApplicable_lbl_td.innerHTML = "&nbsp;";
		f_query_add_mod.detail.detailUpper.document.getElementById("ChargeTypeApplicable_lbl_td").innerHTML = "&nbsp;";
		//f_query_add_mod.detail.detailUpper.detailUpperForm.all.ChargeTypeApplicable_td.innerHTML		= "&nbsp;";
		f_query_add_mod.detail.detailUpper.document.getElementById("ChargeTypeApplicable_td").innerHTML		= "&nbsp;";
	}
}

function chargableYN(obj)
{
	if (obj.checked) 
	{
		//f_query_add_mod.detail.detailUpper.detailUpperForm.all.ord_set_charge_pat_yn.value="Y";	
		f_query_add_mod.detail.detailUpper.document.getElementById("ord_set_charge_pat_yn").value="Y";
	} 
	else 
	{
		//f_query_add_mod.detail.detailUpper.detailUpperForm.all.ord_set_charge_pat_yn.value="N";
		f_query_add_mod.detail.detailUpper.document.getElementById("ord_set_charge_pat_yn").value="N";
	}
}

/*Added by Uma on 5/27/2010*/
function addedorderset()
{
	//var indx;//IN065713
	selFlag			 = true ;
	
	var l_invoke_func = document.getElementById("p_invoke_func").value;//IN065713
	var l_query_string = document.getElementById("p_query_string").value;//IN065713
	var l_appl_to = parent.frames[0].document.getElementById("applicable_to").value;
	var l_site_specific_dosage_type = parent.frames[0].document.getElementById("p_site_specific_dosage_type").value;
	//var formObj = parent.orderset_order_dtl.additionalDetailForm;//IN065713
	var formObj = "";//IN065713
	//IN065713, starts
	if(l_invoke_func =='ORD_SET_AGE_GRP')
	{
		//formObj = parent.orderset_dosage_age_dtl;
		formObj = parent.orderset_dosage_type_dtl.additionalDetailForm;		
	}
	else if(l_invoke_func =='DOSAGE_TYPE_DEFN')
	{
		formObj = parent.orderset_dosage_type_dtl;
	}
	else if(l_invoke_func =='DOSAGE_TYPE_DEFN_ADDITIONAL')
	{
		formObj = parent.orderset_dosage_type_dtl.additionalDetailForm;		
	}
	else
	{
		formObj = parent.orderset_order_dtl.additionalDetailForm;		
	}
	
	if(l_site_specific_dosage_type == "true" && l_appl_to == 'C')
	{
		if(l_invoke_func =='ORD_SET_AGE_GRP' || l_invoke_func =='DOSAGE_TYPE_DEFN_ADDITIONAL'|| l_invoke_func =='additionalDetailForm')
		{
			arrValues = new Array();		
			
			for(var i = 1;i<10;i++)
			{				
				var include = eval(formObj.document.getElementById("include"+i));			
	
				if (include && include.checked)
				{
					if(!arrValues.contains(eval("formObj.occ_no"+i).value))
					{
						if(eval("formObj.occ_no"+i).value!='')
							arrValues.push(eval("formObj.occ_no"+i).value);
					}
					else
					{
						//alert("APP-OR0472 Contains duplicate Occurrance No");
						alert(getMessage("DUPLICATE_OCC_NO","OR"));
						return;			
					}
				}
			}
		}
	}
	//IN065713, ends
	
	if(formObj.document.getElementById("bean_id")!=undefined)
	{
		var bean_id		= formObj.document.getElementById("bean_id").value;
		var bean_name	= formObj.document.getElementById("bean_name").value;
		
		//var l_invoke_func = formObj.document.getElementById("p_invoke_func").value;//IN065713
		var age_grp_code = formObj.document.getElementById("p_age_grp_code").value;//IN065713
		var l_site_specific_dosage_type = formObj.document.getElementById("p_site_specific_dosage_type").value;
		var l_dosage_type = formObj.document.getElementById("p_dosage_type").value;
		
		var value_str	= "";
		var pmpt_msg	= "";
		var reqd_or_opt_inds	= "";
		var route_codes	= "";
		var rel_start_date_times	= "";
		var durn_values	= "";
		var durn_types	= "";
		var freq_codes	= "";
		var qty_uoms	= "";
		var qty_values	= "";
		var order_type_codes	= "";
		var order_set_seq_nums	= "";
		var catalog_str	= "";
		var dosage_types = "";
		var occ_nos = "";
		var index_values	= "";
		var count	= 0;
		var qty_units = "";
		var route_descs ="";

		fm_disp = 1;
		to_disp = 9;

		//for(i=(fm_disp); i<=to_disp; i++)//IN065713
		for(var i=(fm_disp); i<=to_disp; i++)//IN065713
		{			
			var prompt_msg = eval(formObj.document.getElementById("prompt_msg"+i)).value;
			var include = eval(ormObj.document.getElementById("include"+i));
			var reqd_or_opt_ind = eval(formObj.document.getElementById("reqd_or_opt_ind"+i)).value;
			var route_code = eval(formObj.document.getElementById("route_code"+i)).value;
			var route_desc = eval(formObj.document.getElementById("route_desc"+i)).value
			var rel_start_date_time = eval(formObj.document.getElementById("rel_start_date_time"+i)).value;
			var durn_value = eval(formObj.document.getElementById("durn_value"+i)).value;
			var durn_type = eval(formObj.document.getElementById("durn_type"+i)).value;
			var freq_code = eval(formObj.document.getElementById("freq_code"+i)).value;
			var qty_uom = eval(formObj.document.getElementById("qty_uom"+i)).value;
			var qty_value = eval(formObj.document.getElementById("qty_value"+i)).value;
			var qty_unit = eval(formObj.document.getElementById("qty_value"+i)).value;
			var order_type_code = eval(formObj.document.getElementById("order_type_code"+i)).value;
			var order_set_seq_num = eval(formObj.document.getElementById("order_set_seq_num"+i)).value;
			var order_catalog_code = eval(formObj.document.getElementById("order_catalog_code"+i)).value;
			var dosage_type =  eval(formObj.document.getElementById("p_fetch_dosage_type"+i)).value;
			if(l_site_specific_dosage_type == 'true' && l_appl_to == 'C')
			{
				var occ_no =  eval('formObj.document.getElementById("occ_no")'+i).value;
			}

			if (include && include.checked)
			{
				val = !include.disabled?(include.checked?"Y":"N"):"N";						
				
				value_str += val+"~";
				
				prompt_msg = prompt_msg==""?"@#":prompt_msg;
				pmpt_msg += prompt_msg+"~";

				reqd_or_opt_ind = reqd_or_opt_ind==""?"@#":reqd_or_opt_ind;
				reqd_or_opt_inds += reqd_or_opt_ind+"~";

				route_code = route_code==""?"@#":route_code;
				route_codes += route_code+"~";
				
				route_desc = route_desc==""?"@#":route_desc;
				route_descs += route_descs+"~";

				rel_start_date_time = rel_start_date_time==""?"@#":rel_start_date_time;
				rel_start_date_times += rel_start_date_time+"~";

				durn_value = durn_value==""?"@#":durn_value;
				durn_values += durn_value+"~";

				durn_type = durn_type==""?"@#":durn_type;
				durn_types += durn_type+"~";

				freq_code = freq_code==""?"@#":freq_code;
				freq_codes += freq_code+"~";

				qty_uom = qty_uom==""?"@#":qty_uom;
				qty_uoms += qty_uom+"~";

				qty_value = qty_value==""?"@#":qty_value;
				qty_values += qty_value+"~";				
				
				qty_unit = qty_unit == ""?"@#":qty_unit;
				qty_units += qty_unit+"~";

				order_type_code = order_type_code==""?"@#":order_type_code;
				order_type_codes += order_type_code+"~";

				order_set_seq_num = order_set_seq_num==""?"@#":order_set_seq_num
				order_set_seq_nums += order_set_seq_num+"~";
				
				dosage_type = dosage_type==""?"@#":dosage_type
				dosage_types += dosage_type+"~";
				

				if(l_site_specific_dosage_type == 'true' && l_appl_to == 'C')
				{	
					if(occ_no == '')
					{
						//alert("APP-OR0472 Occurance no cannot be blank");
						alert(getMessage("OCC_NO_CANNOT_BLANK","OR"));
						return false;
					}
				
					occ_no = occ_no==""?"@#":occ_no
						occ_nos += occ_no+"~";
				}
				
				index_values += (i+1)+"~";
				count++;			   
			}
		}			   
		
		var xmlStr ="<root><SEARCH ";
		xmlStr += " INDEX_VALUES=\""+ index_values + "\" ";
		xmlStr += " VALUE_STR=\""+ value_str + "\" ";
		//xmlStr += " PROMPT_MSG=\""+ pmpt_msg + "\" ";//IN065144
		xmlStr += " PROMPT_MSG=\""+ encodeURIComponent(pmpt_msg,'UTF-8') + "\" ";//IN065144
		xmlStr += " CATALOG_CODE=\""+ order_catalog_code + "\" ";
		xmlStr += " ORDER_SET_SEQ_NUM=\""+ order_set_seq_nums + "\" ";
		xmlStr += " ORDER_TYPE_CODE=\""+ order_type_codes + "\" ";
		xmlStr += " DURN_TYPE=\""+ durn_types + "\" ";
		xmlStr += " QTY_UNIT_STR=\""+ qty_values + "\" ";
		xmlStr += " QTY_VALUE=\""+ qty_values + "\" ";
		//xmlStr += " QTY_UOM_STR=\""+ qty_uoms + "\" ";		
		xmlStr += " QTY_UOM=\""+ qty_uoms + "\" ";
		xmlStr += " DURN_VALUE=\""+ durn_values + "\" ";
		xmlStr += " REL_START_DATE_TIME=\""+ rel_start_date_times + "\" ";
		xmlStr += " REQD_OR_OPT_IND=\""+ reqd_or_opt_inds + "\" ";
		xmlStr += " ROUTE_CODE=\""+ route_codes + "\" ";
		xmlStr += " ROUTE_DESC=\""+ route_descs + "\" ";
		xmlStr += " FREQ_CODE=\""+ freq_codes + "\" ";
		xmlStr += " FROM_VALUE=\""+ fm_disp + "\" ";
		xmlStr += " TO_VALUE=\""+ to_disp + "\" ";
		xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
		xmlStr += " COUNT=\""+ count + "\" ";
		//xmlStr += " TAB_VALUE=\""+ tabVal + "\" ";
		//IN065713, starts
		//xmlStr += " CLASS_NAME=\"AdditionalOrderSet\"";
		if(l_invoke_func == 'ORD_SET_AGE_GRP')
			xmlStr += " CLASS_NAME=\"ORD_SET_AGE_GRP\"";
		else if(l_invoke_func == 'DOSAGE_TYPE_DEFN')
			xmlStr += " CLASS_NAME=\"DOSAGE_TYPE_DEFN\"";
		else if(l_invoke_func == 'DOSAGE_TYPE_DEFN_ADDITIONAL')
			xmlStr += " CLASS_NAME=\"DOSAGE_TYPE_DEFN_ADDITIONAL\"";
		else
			xmlStr += " CLASS_NAME=\"AdditionalOrderSet\"";
		xmlStr += " AGE_GRP_CODE=\""+ age_grp_code + "\" ";
		xmlStr += " DOSAGE_TYPE=\""+ dosage_types + "\" ";		
		xmlStr += " OCC_NO=\""+ occ_nos + "\" ";		
		xmlStr += " P_DOSAGE_TYPE=\""+l_dosage_type+"\" ";
		//IN065713, ends
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
		xmlHttp.open("POST","OrderSetValidate.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;	
		//return true;//IN065713
   }
	//IN065713, starts
	//window.close();
	
	if(l_invoke_func == 'ORD_SET_AGE_GRP')
	{
		//parent.orderset_dosage_type_hdr.document.getElementById('age_grp_add_cata_tab').className = 'normal';
		//parent.orderset_dosage_type_hdr.document.getElementById('age_grp_tab').className = 'clicked';
		parent.orderset_dosage_type_dtl.document.location.href='../jsp/OrderSetDosageTypeAgeWiseDetails.jsp?'+l_query_string;
		parent.parent.orderset_dosage_type_btn.document.location.href='../jsp/OrderSetDosageTypeAgeWiseButtons.jsp?'+l_query_string;	
	}
	else if(l_invoke_func == 'DOSAGE_TYPE_DEFN')
	{		
		l_query_string = l_query_string+"&p_appl_to="+l_appl_to;
		parent.orderset_dosage_type_dtl.document.location.href='../jsp/OrderSetDosageByTypeDefinition.jsp?'+l_query_string;
		parent.parent.orderset_dosage_type_btn.document.location.href='../jsp/OrderSetDosageByTypeDefinitionButtons.jsp?'+l_query_string;		
	}
	else if(l_invoke_func == 'DOSAGE_TYPE_DEFN_ADDITIONAL')
	{		
		l_query_string = l_query_string+"&p_appl_to="+l_appl_to;
		parent.orderset_dosage_type_dtl.document.location.href='../jsp/OrderSetDosageByTypeDefinition.jsp?'+l_query_string;
		parent.parent.orderset_dosage_type_btn.document.location.href='../jsp/OrderSetDosageByTypeDefinitionButtons.jsp?'+l_query_string;		
	}
	else
	{
		window.close();
	}
	//IN065713, ends
}
//IN063686 changes ends

function chkApplSetting(obj,index){
var age_group_code	= eval(document.getElementById("age_group_code"+index));

 if(obj.value == "A"){
         age_group_code.disabled            = false;
		 age_group_code.value="";
 }else{
	       age_group_code.disabled            = true;
	     // parent.document.getElementById("age_group_code").disabled = true;
  		  age_group_code.value="";
	      //parent.document.getElementById("age_group_code").value="";
 }

}
//IN063686 changes ends
/*Ends Here*/

//IN062992, starts
function showDosageTypeAgeDetails(index)
{
	var dosageTypeObj = eval(document.getElementById("dosage_type"+index));
	var bean_id		= document.getElementById("bean_id").value;
	var bean_name	= document.getElementById("bean_name").value;
	var l_order_catalog_code = eval(document.getElementById("catalog_code"+index)).value;
	var l_order_set_seq_num = eval(document.getElementById("order_set_seq_num"+index)).value;

	if(dosageTypeObj.value == 'A')
	{
		eval(document.getElementById("qty_unit"+index)).disabled = true;
		//eval("document.getElementById("qty_unit")"+index).value = '';
		eval(document.getElementById("dosage_type_age"+index)).style.display = "inline";
		eval(document.getElementById("freq_code"+index)).disabled = true;
		eval(document.getElementById("freq_code"+index)).selectedIndex=0;
		eval(document.getElementById("durn_value"+index)).disabled = true;
		eval(document.getElementById("durn_value"+index)).value = '';
		eval(document.getElementById("durn_type"+index)).disabled = true;
		eval(document.getElementById("durn_type"+index)).value ='';
		eval(document.getElementById("durn_type_desc"+index)).value ='';
		eval(document.getElementById("rel_start_date_time"+index)).disabled = true;
		eval(document.getElementById("rel_start_date_time"+index)).value = '';
		eval(document.getElementById("route_desc"+index)).disabled = true;
		eval(document.getElementById("route_desc"+index)).value = '';
		eval(document.getElementById("route_code"+index)).value = '';
		eval(document.getElementById("route_button"+index)).disabled = true;
		eval(document.getElementById("Cmts"+index)).disabled = true;		
		eval(document.getElementById("Cmts"+index)).className = '';
		eval(document.getElementById("Cmts"+index)).style.cursor = 'none';
		eval(document.getElementById("Cmts"+index)).href = "#";
		eval(document.getElementById("prompt_msg"+index)).value = "";
		eval(document.getElementById("Includes"+index)).style.display = "none";//IN065713
	}
	else
	{
		if(eval(document.getElementById("qty_reqd_yn"+index)).value == 'Y')
			eval(document.getElementById("qty_unit"+index)).disabled = false;
		else
			eval(document.getElementById("qty_unit"+index)).disabled = true;

		eval(document.getElementById("dosage_type_age"+index)).style.display = "none";
		eval(document.getElementById("freq_code"+index)).disabled = false;

		if(eval(document.getElementById("freq_code"+index)).selectedIndex == 0)
		{
			eval(document.getElementById("durn_value"+index)).disabled = true;			
		}
		else
		{
			eval(document.getElementById("durn_value"+index)).disabled = false;
		}

		eval(document.getElementById("durn_type"+index)).disabled = false;
		eval(document.getElementById("rel_start_date_time"+index)).disabled = false;
		eval(document.getElementById("rel_start_date_time"+index)).value = '0';
		eval(document.getElementById("route_desc"+index)).disabled = false;
		eval(document.getElementById("route_button"+index)).disabled = false;
		eval(document.getElementById("Cmts"+index)).disabled = false;
		eval(document.getElementById("Cmts"+index)).className = "gridLink";
		eval(document.getElementById("Cmts"+index)).style.cursor = 'hand';
		eval(document.getElementById("Cmts"+index)).href = "javascript:parent.parent.parent.showDialog("+index+")";
		eval(document.getElementById("prompt_msg"+index)).value = "";		
		
		eval(document.getElementById("Includes"+index)).innerHTML = "<a href=\"javascript:callAdditionalRows('"+index+"')\">+</a></font>";//IN065713
		
		eval(document.getElementById("Includes"+index)).style.display = "inline";//IN065713

		//on changing the dosage type to M2 or Kg, clear the agewise values

		var xmlStr ="<root><SEARCH ";		
		xmlStr += " CATALOG_CODE=\""+ l_order_catalog_code + "\" ";	
		xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
		xmlStr += " CLASS_NAME=\"CLEAR_AGE_WISE_CATALOG_DETAILS\"";
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","OrderSetValidate.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
	}
}



function show_ph_qty_uom_lookup(target,qty_uom,i)
{
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;	
	
	var sql="select uom_code code,short_desc description from AM_UOM where eff_Status = 'E' and upper(uom_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
	argumentArray[0]	=  sql;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;
	retVal = orderset_dosage_age_dtl.CommonLookup( getLabel("Common.uom.label","Common"), argumentArray );

 	if(retVal != null && retVal != "")
	{
   		target.value = retVal[1];
 		qty_uom.value =retVal[0] ;
 	}
	else
	{
   		target.value = "";
   		qty_uom.value = "" ;
 	}
}

function show_ph_qty_uom_window(target,code,i)
{
	if(orderset_dosage_age_dtl!=null)
	{

		if(target.value != "")
		{
			show_ph_qty_uom_lookup(target,code,i);
		}
	}
}

function clearAgeWiseDetails()
{
	var bean_id		= f_query_add_mod.header.document.getElementById("bean_id").value;
	var bean_name	= f_query_add_mod.header.document.getElementById("bean_name").value;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
	xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
	xmlStr += " CLASS_NAME=\"CLEAR_AGE_WISE_ALL_DETAILS\"";
	xmlStr +=" /></root>";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OrderSetValidate.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;	
}

function clearAll()
{
	var bean_id		= formObjHeader.document.getElementById("bean_id").value;
	var bean_name	= f_query_add_mod.header.document.getElementById("bean_name").value;
	var iv_prep_yn = formObjHeader.document.getElementById("iv_prep_yn").value;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
	xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
	xmlStr += " IV_PREP_YN=\""+ iv_prep_yn + "\" ";
	xmlStr += " CLASS_NAME=\"CLEAR_ALL\"";
	xmlStr +=" /></root>";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open("POST","OrderSetValidate.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;	
}
//IN062992, ends

//IN065713, starts
function decodeDesc(code)
{
	var decodeDesc = "";
	if(code == "H") decodeDesc = "Hour(s)";
	if(code == "D") decodeDesc = "Day(s)";
	if(code == "W") decodeDesc = "Week(s)";
	if(code == "L") decodeDesc = "Month(s)";
	if(code == "M") decodeDesc = "Minute(s)";
	return decodeDesc;
}

//function loadAdditionalCatalogsAgeWise(order_catalog_code,qty_uom_code,qty_uom_desc,order_catalog_desc,order_set_seq_num,qty_unit,qty_reqd_yn,order_type_desc,age_group_code,qry_string,freq_code,durn_value, durn_type,time_frame,route_code,age_grp_desc)
//function loadAdditionalCatalogsAgeWise(order_catalog_code,qty_uom_code,qty_uom_desc,order_catalog_desc,order_set_seq_num,qty_unit,qty_reqd_yn,order_type_desc,age_group_code,qry_string,freq_code,durn_value, durn_type_desc,time_frame,route_code,age_grp_desc,durn_type,prompt_msg)
function loadAdditionalCatalogsAgeWise(order_catalog_code,qty_uom_code,qty_uom_desc,order_catalog_desc,order_set_seq_num,qty_unit,qty_reqd_yn,order_type_desc,age_group_code,qry_string,freq_code,durn_value, durn_type_desc,time_frame,route_code,age_grp_desc,durn_type,prompt_msg,occ_no)
{
	//var param = "order_category_code="+order_catalog_code+"&order_set_seq_num="+order_set_seq_num+"&order_category=PH&p_age_grp_code="+age_group_code+"&p_invoke_func=ORD_SET_AGE_GRP&order_type="+order_type_desc+"&qty_uom_desc="+uom_desc+"&qty_value="+qty_value+"&p_age_grp_desc="+age_grp_desc+"&"+qry_string;
	var param = "order_category_code="+order_catalog_code+"&order_set_seq_num="+order_set_seq_num+"&order_type="+order_type_desc+"&qty_value="+qty_unit+"&qty_uom_desc="+qty_uom_desc+"&qty_uom="+qty_uom_code+"&prompt_msg="+encodeURIComponent(prompt_msg,'UTF-8')+"&p_age_grp_code="+age_group_code+"&order_category=PH"+"&freq_code="+freq_code+"&durn_value="+durn_value+"&durn_type_desc="+durn_type_desc+"&rel_start_date_time="+time_frame+"&route_code="+route_code+"&p_age_grp_desc="+age_grp_desc+"&durn_type="+durn_type+"&p_invoke_func=ORD_SET_AGE_GRP"+"&occ_no="+occ_no;
	//parent.orderset_dosage_type_hdr.document.getElementById("age_grp_tab").className = "normal";
	//parent.orderset_dosage_type_hdr.document.getElementById("age_grp_add_cata_tab").className = "clicked";
	parent.orderset_dosage_type_dtl.document.location.href = "../jsp/OrdersetComponentDetailAdded.jsp?"+param;
	parent.orderset_dosage_type_btn.document.location.href = "../jsp/OrdersetComponentDetailAddedButton.jsp?"+qry_string+"&p_invoke_func=ORD_SET_AGE_GRP";	
}

function includeAdditionalDosageTypeAgeWise()
{
	selFlag			 = true ;
	var formObj = parent.orderset_dosage_type_dtl.orderset_dosage_age_dtl_form;
	var order_catalog_code = parent.orderset_dosage_type_dtl.orderset_dosage_age_dtl_form.order_catalog_code.value;
	var order_set_seq_num = parent.orderset_dosage_type_dtl.orderset_dosage_age_dtl_form.order_set_seq_num.value;

	if(formObj.document.getElementById("bean_id")!=undefined)
	{
		var bean_id		= formObj.document.getElementById("bean_id").value;
		var bean_name	= formObj.document.getElementById("bean_name").value;
		var value_str	= "";
		var pmpt_msg	= "";
		var route_codes	= "";
		var route_descs	= "";
		var rel_start_date_times	= "";
		var durn_values	= "";
		var durn_types	= "";
		var freq_codes	= "";
		var index_values	= "";
		var age_group_codes	= "";
		var qty_units = "";
		var qty_uoms = "";
		var occ_nos = "";
		var count	= 0;

		fm_disp = 0;
		to_disp = formObj.document.getElementById("age_group_size").value;

		for(var i=fm_disp; i<=to_disp; i++)
		{
			var include = eval('formObj.document.getElementById("include")'+i);
			var age_group_code = eval('formObj.document.getElementById("age_group_code")'+i).value;
			var qty_unit = eval('formObj.document.getElementById("qty_unit")'+i).value;
			var qty_uom = eval('formObj.document.getElementById("qty_uom")'+i).value;
			var freq_code = eval('formObj.document.getElementById("freq_code")'+i).value;	
			var durn_value = eval('formObj.document.getElementById("durn_value")'+i).value;
			var durn_type = eval('formObj.document.getElementById("durn_type")'+i).value;
			var rel_start_date_time = eval('formObj.document.getElementById("rel_start_date_time")'+i).value;					
			var route_code = eval('formObj.document.getElementById("route_code")'+i).value;
			var route_desc = eval('formObj.document.getElementById("route_desc")'+i).value;
			var prompt_msg = eval('formObj.document.getElementById("prompt_msg")'+i).value;
			var qty_reqd_yn = eval('formObj.document.getElementById("qty_reqd_yn")'+i).value;
			var occ_no = eval('formObj.document.getElementById("occ_no")'+i).value;
			
			if (include && include.checked)
			{
				val = !include.disabled?(include.checked?"Y":"N"):"N";				

				value_str += val+"~";
				
				age_group_code=age_group_code==""?"@#":age_group_code;
				age_group_codes += age_group_code+"~";				

				qty_unit=qty_unit == ""?"@#":qty_unit;
				qty_units += qty_unit+"~";

				qty_uom = qty_uom==""?"@#":qty_uom;
				qty_uoms += qty_uom+"~";

				freq_code = freq_code==""?"@#":freq_code;
				freq_codes += freq_code+"~";

				durn_value=durn_value==""?"@#":durn_value;
				durn_values += durn_value+"~";

				durn_type = durn_type==""?"@#":durn_type;
				durn_types += durn_type+"~";					

				rel_start_date_time = rel_start_date_time==""?"@#":rel_start_date_time;
				rel_start_date_times += rel_start_date_time+"~";					

				route_code = route_code==""?"@#":route_code;
				route_codes += route_code+"~";

				route_desc=route_desc==""?"@#":route_desc;
				route_descs += route_desc+"~";

				prompt_msg = prompt_msg==""?"@#":prompt_msg;
				pmpt_msg += prompt_msg+"~";
				
				occ_no = occ_no==""?"@#":occ_no;
				occ_nos += occ_no+"~";

				index_values += (i+1)+"~";
				count++;
			}
		}	

		if (count > 0)
		{
			var xmlStr ="<root><SEARCH ";
			xmlStr += " INDEX_VALUES=\""+ index_values + "\" ";
			xmlStr += " VALUE_STR=\""+ value_str + "\" ";
			//xmlStr += " PROMPT_MSG=\""+ pmpt_msg + "\" ";//IN065144
			xmlStr += " PROMPT_MSG=\""+ encodeURIComponent(pmpt_msg,'UTF-8') + "\" ";//IN065144
			xmlStr += " CATALOG_CODE=\""+ order_catalog_code + "\" ";
			xmlStr += " ORDER_SET_SEQ_NUM=\""+ order_set_seq_num+ "\" ";			
			xmlStr += " DURN_TYPE=\""+ durn_types + "\" ";
			xmlStr += " DURN_VALUE=\""+ durn_values + "\" ";
			xmlStr += " REL_START_DATE_TIME=\""+ rel_start_date_times + "\" ";
			xmlStr += " ROUTE_CODE=\""+ route_codes + "\" ";
			xmlStr += " ROUTE_DESC=\""+ route_descs + "\" ";
			xmlStr += " FREQ_CODE=\""+ freq_codes + "\" ";
			xmlStr += " FROM_VALUE=\""+ fm_disp + "\" ";
			xmlStr += " TO_VALUE=\""+ to_disp + "\" ";
			xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
			xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
			xmlStr += " COUNT=\""+ count + "\" ";
			xmlStr += " AGE_GROUP_STR=\""+ age_group_codes + "\" ";
			xmlStr += " QTY_UNIT_STR=\""+ qty_units + "\" ";
			xmlStr += " QTY_UOM=\""+ qty_uoms + "\" ";
			xmlStr += " OCC_NO=\""+ occ_nos + "\" ";
			
			xmlStr += " CLASS_NAME=\"DOSAGE_TYPE_AGE_GROUP\"";
			xmlStr +=" /></root>";
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","OrderSetValidate.jsp",false);
			xmlHttp.send(xmlDoc);
			return true;
		}
   }
}
//IN065713, ends

//IN68241, starts
function showDosageAgeWiseDetails(index)
{
	var seq_num = eval(document.getElementById("p_order_set_seq_num")).value;
	
  	if(seq_num=="")
	{
		alert(getMessage('SEQ_NO_NOT_BLANK','OR'));
		return;
	}
	else
	{		
		var l_order_catalog_code = eval(document.getElementById("p_order_catalog_code")).value;
		var l_qty_uom = eval(document.getElementById("qty_uom"+index)).value;
		var l_qty_uom_desc = eval(document.getElementById("qty_uom_desc")).value;
		var l_order_set_seq_num = eval(document.getElementById("p_order_set_seq_num")).value;	
		var l_order_catalog_desc = eval(document.getElementById("p_order_catalog_desc")).value;
		var l_qty_unit = eval(document.getElementById("qty_unit"+index)).value;
		var l_qty_reqd_yn = eval(document.getElementById("qty_reqd_yn"+index)).value;
		var l_freq_code = eval(document.getElementById("freq_code"+index)).value;
		var l_durn_code = eval(document.getElementById("durn_value"+index)).value;
		var l_durn_desc = eval(document.getElementById("durn_type"+index)).value;
		var l_route_desc = eval('document.getElementById("route_desc")'+index).value;
		var l_route_code = eval('document.getElementById("route_code")'+index).value;
		var l_order_type_desc= eval(document.getElementById("order_type")).value;
		var l_prompt_msg = eval(document.getElementById("prompt_msg"+index)).value;
		var l_valid = document.getElementById("valid").value;
		//var queryString = "modal_yn=Y"+"&p_order_catalog_code="+l_order_catalog_code+"&p_qty_uom_code="+l_qty_uom+"&qty_uom_desc="+encodeURIComponent(l_qty_uom_desc,'UTF-8')+"&p_order_catalog_desc="+encodeURIComponent(l_order_catalog_desc,'UTF-8')+"&p_order_set_seq_num="+l_order_set_seq_num+"&p_qty_unit="+l_qty_unit+"&p_qty_reqd_yn="+l_qty_reqd_yn+"&p_freq_code="+l_freq_code+"&p_durn_code="+l_durn_code+"&p_durn_type="+encodeURIComponent(l_durn_desc,'UTF-8')+"&p_order_type_desc="+encodeURIComponent(l_order_type_desc,'UTF-8')+"&p_route_desc="+l_route_desc+"&p_route_code="+l_route_code+"&prompt_msg="+encodeURIComponent(l_prompt_msg,'UTF-8');
		var queryString = "modal_yn=Y"+"&p_order_catalog_code="+l_order_catalog_code+"&p_qty_uom_code="+l_qty_uom+"&qty_uom_desc="+encodeURIComponent(l_qty_uom_desc,'UTF-8')+"&p_order_catalog_desc="+encodeURIComponent(l_order_catalog_desc,'UTF-8')+"&p_order_set_seq_num="+l_order_set_seq_num+"&p_qty_unit="+l_qty_unit+"&p_qty_reqd_yn="+l_qty_reqd_yn+"&p_freq_code="+l_freq_code+"&p_durn_code="+l_durn_code+"&p_durn_type="+encodeURIComponent(l_durn_desc,'UTF-8')+"&order_type="+encodeURIComponent(l_order_type_desc,'UTF-8')+"&p_route_desc="+l_route_desc+"&p_route_code="+l_route_code+"&prompt_msg="+encodeURIComponent(l_prompt_msg,'UTF-8')+"&order_type="+encodeURIComponent(l_order_type_desc,'UTF-8')+"&valid="+l_valid;
		parent.orderset_dosage_type_dtl.document.location.href='../jsp/OrderSetDosageTypeAgeWiseDetails.jsp?'+queryString;
		parent.orderset_dosage_type_btn.document.location.href='../jsp/OrderSetDosageTypeAgeWiseButtons.jsp?'+queryString;
	}
}

function includeDosageTypeAgeWise()
{
	selFlag			 = true ;

	var formObj = parent.orderset_dosage_type_dtl.orderset_dosage_age_dtl_form;
	var order_catalog_code = parent.orderset_dosage_type_dtl.orderset_dosage_age_dtl_form.order_catalog_code.value;
	var order_set_seq_num = parent.orderset_dosage_type_dtl.orderset_dosage_age_dtl_form.order_set_seq_num.value;
	var l_appl_to = parent.orderset_dosage_type_dtl.orderset_dosage_age_dtl_form.iv_prep_yn.value;

	if(formObj.document.getElementById("bean_id")!=undefined)
	{
		var bean_id		= formObj.document.getElementById("bean_id").value;
		var bean_name	= formObj.document.getElementById("bean_name").value;
		var value_str	= "";
		var pmpt_msg	= "";
		var route_codes	= "";
		var route_descs	= "";
		var rel_start_date_times	= "";
		var durn_values	= "";
		var durn_types	= "";
		var freq_codes	= "";
		var index_values	= "";
		var age_group_codes	= "";
		var qty_units = "";
		var qty_uoms = "";
		var occ_nos = "";
		var count	= 0;

		fm_disp = 0;
		to_disp = formObj.document.getElementById("age_group_size").value;

		for(var i=fm_disp; i<=to_disp; i++)
		{
			var include = eval('formObj.document.getElementById("include")'+i);
			var age_group_code = eval('formObj.document.getElementById("age_group_code")'+i).value;
			var qty_unit = eval('formObj.document.getElementById("qty_unit")'+i).value;
			var qty_uom = eval('formObj.document.getElementById("qty_uom")'+i).value;
			var freq_code = eval('formObj.document.getElementById("freq_code")'+i).value;	
			var durn_value = eval('formObj.document.getElementById("durn_value")'+i).value;
			var durn_type = eval('formObj.document.getElementById("durn_type")'+i).value;
			var rel_start_date_time = eval('formObj.document.getElementById("rel_start_date_time")'+i).value;					
			var route_code = eval('formObj.document.getElementById("route_code")'+i).value;
			var route_desc = eval('formObj.document.getElementById("route_desc")'+i).value;
			var prompt_msg = eval('formObj.document.getElementById("prompt_msg")'+i).value;
			var qty_reqd_yn = eval('formObj.document.getElementById("qty_reqd_yn")'+i).value;
			var occ_no = eval('formObj.document.getElementById("occ_no")'+i).value;
			
			if (include && include.checked)
			{
				val = !include.disabled?(include.checked?"Y":"N"):"N";
					
				value_str += val+"~";

				age_group_code = age_group_code==""?"@#":age_group_code;
				age_group_codes += age_group_code+"~";
				
				if(qty_reqd_yn == 'Y' && qty_unit == '')
				{
					alert("APP-OR0030 Qty. cannot be blank");
					return false;
				}

				qty_unit = qty_unit == ""?"@#":qty_unit;
				qty_units += qty_unit+"~";

				qty_uom = qty_uom==""?"@#":qty_uom;
				qty_uoms += qty_uom+"~";

				freq_code = freq_code==""?"@#":freq_code;
				freq_codes += freq_code+"~";

				if(durn_type != '' && durn_value == '')
				{
					alert("APP-OR0028 Durn is mandatory for all selected Freq. Codes");
					return false;
				}

				durn_value = durn_value==""?"@#":durn_value;
				durn_values += durn_value+"~";

				durn_type = durn_type==""?"@#":durn_type;
				durn_types += durn_type+"~";

				if(rel_start_date_time == '')
				{
					alert("APP-OR0027 Time is Mandatory");
					return false;
				}

				rel_start_date_time = rel_start_date_time==""?"@#":rel_start_date_time;
				rel_start_date_times += rel_start_date_time+"~";					
				
				if(route_code == '')
				{
					alert(getMessage("ORDER_SET_ADMIN_ROUTE","OR"));
					return false;
				}
				
				route_code = route_code==""?"@#":route_code;
				route_codes += route_code+"~";
				
				route_desc = route_desc==""?"@#":route_desc;
				route_descs += route_desc+"~";

				prompt_msg = prompt_msg==""?"@#":prompt_msg;
				pmpt_msg += prompt_msg+"~";
				
				occ_no = occ_no?"@#":occ_no;
				occ_nos += occ_no+"~";

				index_values += (i+1)+"~";
				count++;
			}				
		}

		if (count > 0)
		{
			var xmlStr ="<root><SEARCH ";
			xmlStr += " INDEX_VALUES=\""+ index_values + "\" ";
			xmlStr += " VALUE_STR=\""+ value_str + "\" ";
			xmlStr += " PROMPT_MSG=\""+ encodeURIComponent(pmpt_msg,'UTF-8') + "\" ";
			xmlStr += " CATALOG_CODE=\""+ order_catalog_code + "\" ";
			xmlStr += " ORDER_SET_SEQ_NUM=\""+ order_set_seq_num+ "\" ";
			xmlStr += " DURN_TYPE=\""+ durn_types + "\" ";
			xmlStr += " DURN_VALUE=\""+ durn_values + "\" ";
			xmlStr += " REL_START_DATE_TIME=\""+ rel_start_date_times + "\" ";
			xmlStr += " ROUTE_CODE=\""+ route_codes + "\" ";
			xmlStr += " ROUTE_DESC=\""+ route_descs + "\" ";
			xmlStr += " FREQ_CODE=\""+ freq_codes + "\" ";
			xmlStr += " FROM_VALUE=\""+ fm_disp + "\" ";
			xmlStr += " TO_VALUE=\""+ to_disp + "\" ";
			xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
			xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
			xmlStr += " COUNT=\""+ count + "\" ";
			xmlStr += " AGE_GROUP_STR=\""+ age_group_codes + "\" ";
			xmlStr += " QTY_UNIT_STR=\""+ qty_units + "\" ";
			xmlStr += " QTY_UOM=\""+ qty_uoms + "\" ";
			xmlStr += " OCC_NO=\""+ occ_nos + "\" ";
			xmlStr += " CLASS_NAME=\"DOSAGE_TYPE_AGE_GROUP\"";
			xmlStr +=" /></root>";
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","OrderSetValidate.jsp",false);
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText ;	
		}
		else
		{
			alert(getMessage("AGE_WISE_DATA_REQUIRED","OR"));
			return false;
		}
   }

	qry_string = parent.orderset_dosage_type_dtl.document.getElementById("p_query_string").value;
	parent.orderset_dosage_type_dtl.document.location.href = "../jsp/OrderSetDosageByTypeDefinition.jsp?"+qry_string;
	parent.orderset_dosage_type_btn.document.location.href = "../jsp/OrderSetDosageByTypeDefinitionButtons.jsp?"+qry_string+"&p_invoke_func=DOSAGE_TYPE_DEFN&p_appl_to="+l_appl_to;
}

function showDosageTypeDefWindow(index)
{
	var seq_num = eval(document.getElementById("order_set_seq_num"+index)).value;
	
	if(seq_num == "")
	{
		alert(getMessage('SEQ_NO_NOT_BLANK','OR'));
		return;
	}
	else
	{
		var dialogHeight= "50" ;
		var dialogWidth	= "100" ;
		var status = "no";
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no;  status:" + status;
		var l_order_set_code = parent.parent.header.document.getElementById("order_set_code").value;		
		var l_order_catalog_code = eval(document.getElementById("catalog_code"+index)).value;
		var l_qty_uom = eval(document.getElementById("qty_uom"+index)).value;
		var l_qty_uom_desc = eval(document.getElementById("qty_uom_desc"+index)).value;
		var l_order_set_seq_num = eval(document.getElementById("order_set_seq_num"+index)).value;	
		var l_order_catalog_desc = eval(document.getElementById("order_catalog_desc"+index)).value;
		var l_qty_unit = eval(document.getElementById("qty_unit"+index)).value;		
		var l_qty_reqd_yn = eval('document.getElementById("qty_reqd_yn")'+index).value;
		var l_freq_code = eval('document.getElementById("freq_code")'+index).value;
		var l_durn_code = eval('document.getElementById("durn_value")'+index).value;
		var l_durn_desc = eval('document.getElementById("durn_type")'+index).value;
		var l_order_type_desc= eval(document.getElementById("order_type_code"+index)).innerText;
		var l_rel_start_date_time = eval('document.getElementById("rel_start_date_time")'+index).value;
		var l_route_code = eval('document.getElementById("route_code")'+index).value;
		var l_route_desc = eval('document.getElementById("route_desc")'+index).value;
		var l_order_type_code = eval('document.getElementById("order_type_code")'+index).value;
		var l_reqd_or_opt_ind = eval('document.getElementById("reqd_or_opt_ind")'+index).value;
		var l_applicable_to = parent.parent.header.document.getElementById("iv_prep_yn").value;
		var l_prompt_msg = eval('document.getElementById("prompt_msg")'+index).value;
		var l_valid = eval('document.getElementById("valid")'+index).value;		
		var queryString = "modal_yn=Y"+"&p_order_catalog_code="+l_order_catalog_code+"&p_qty_uom_code="+l_qty_uom+"&qty_uom_desc="+encodeURIComponent(l_qty_uom_desc,'UTF-8')+"&p_order_catalog_desc="+encodeURIComponent(l_order_catalog_desc,'UTF-8')+"&p_order_set_seq_num="+l_order_set_seq_num+"&p_qty_unit="+l_qty_unit+"&p_qty_reqd_yn="+l_qty_reqd_yn+"&p_freq_code="+l_freq_code+"&p_durn_code="+l_durn_code+"&p_durn_type="+encodeURIComponent(l_durn_desc,'UTF-8')+"&order_type="+encodeURIComponent(l_order_type_desc,'UTF-8')+"&p_order_set_code="+l_order_set_code+"&p_rel_start_date_time="+l_rel_start_date_time+"&p_route_code="+l_route_code+"&p_route_desc="+l_route_desc+"&p_order_type_code="+l_order_type_code+"&p_reqd_or_opt_ind="+l_reqd_or_opt_ind+"&selectedCatIndex="+index+"&p_prompt_msg="+encodeURIComponent(l_prompt_msg,'UTF-8')+"&valid="+l_valid;
		retVal=window.showModalDialog("../../eOR/jsp/OrderSetDosageByTypeDefinitionFrameSet.jsp?"+queryString,arguments,features);
	}
}

function validateDuplicateDosageTypeSeqNo(index, start, limit)
{
	var l_selected_dosage_type_seq_no = eval(document.getElementById("dosage_type_seq_no"+index));
	var l_selected_include = eval(document.getElementById("include"+index));
	
	for(var i=parseInt(start);i<parseInt(limit);i++)
	{
		var l_dosage_type_seq_no = eval(document.getElementById("dosage_type_seq_no"+i)).value;
		var l_curr_include = eval(document.getElementById("include"+i));
		
		if(l_selected_include.checked && l_curr_include.checked && index!=i && l_selected_dosage_type_seq_no.value!='' && l_dosage_type_seq_no==l_selected_dosage_type_seq_no.value)
		{
			//alert('APP-OR0471 Duplicate Occurrance No cannot be selected');
			alert(getMessage("DUPLICATE_OCC_NO_SHLD_NOT_SELECT","OR"));
			l_selected_dosage_type_seq_no.selectedIndex = 0;
			break;
		}
	}
}

function validateDuplicateOccuranceNo(index, start, limit)
{

	var l_selected_occ_no = eval(document.getElementById("occ_no"+index));
	var l_selected_include = eval(document.getElementById("include"+index));
	
	for(var i=parseInt(start);i<parseInt(limit);i++)
	{
		var l_occ_no = eval(document.getElementById("occ_no"+i)).value;
		var l_curr_include = eval(document.getElementById("include"+i));

		if(l_selected_include.checked && l_curr_include.checked && index!=i && l_selected_occ_no.value!='' && l_occ_no==l_selected_occ_no.value)
		{
			//alert('APP-OR0471 Duplicate Occurrance No cannot be selected');
			alert(getMessage("DUPLICATE_OCC_NO_SHLD_NOT_SELECT","OR"));
			l_selected_occ_no.selectedIndex = 0;
			break;
		}	
	}	
}

function callDosageTypeAdditionalRows(index)
{	
	var oCell;
    var oRow;
    var rowId;
	var queryString ="";
	var trText = eval(document.getElementById("row"+index));
	var eff_status=document.getElementById("eff_status").value;
	var order_category=document.getElementById("order_category").value;
	var seq_num = eval(document.getElementById("order_set_seq_num"+index)).value;
	var l_invoke_func = eval(document.getElementById("p_invoke_func")).value;
	var l_appl_to = document.getElementById("p_appl_to").value;

	if(seq_num == "")
	{
		alert(getMessage('SEQ_NO_NOT_BLANK','OR'));
		return;
	}
	else
	{
		queryString = queryString + "&order_category_desc="+encodeURIComponent(document.getElementById("p_order_catalog_desc").value,'UTF-8');
		queryString +="&order_category_code="+document.getElementById("p_order_catalog_code").value;
		queryString +="&order_type="+document.getElementById("order_type").value;
		queryString +="&p_fetch_dosage_type="+eval(document.getElementById("p_fetch_dosage_type"+index)).value;		
		queryString +="&order_set_seq_num="+eval(document.getElementById("order_set_seq_num"+index)).value;
		queryString +="&qty_value="+eval(document.getElementById("qty_unit"+index)).value;
		queryString +="&qty_uom_desc="+encodeURIComponent(eval(document.getElementById("qty_uom_desc"+index)).value);
		queryString +="&freq_code="+eval(document.getElementById("freq_code"+index)).value ;
		queryString +="&durn_value="+eval(document.getElementById("durn_value"+index)).value	;
		queryString +="&durn_type_desc="+eval(document.getElementById("durn_type_desc"+index)).value;
		queryString +="&rel_start_date_time="+eval(document.getElementById("rel_start_date_time"+index)).value;
		queryString +="&reqd_or_opt_ind="+eval(document.getElementById("reqd_or_opt_ind"+index)).value;
		queryString +="&durn_type="+eval(document.getElementById("durn_type"+index)).value;
		queryString +="&qty_uom="+eval(document.getElementById("qty_uom"+index)).value;
		queryString +="&route_code="+eval(document.getElementById("route_code"+index)).value;
		queryString +="&prompt_msg="+encodeURIComponent(eval(document.getElementById("prompt_msg"+index)).value,'UTF-8');//IN065144
		queryString +="&eff_status="+eff_status;
		queryString +="&order_category="+order_category;
		queryString +="&p_invoke_func=DOSAGE_TYPE_DEFN_ADDITIONAL";//IN065713
		queryString +="&modal_yn=Y";
		queryString +="&order_set_seq_num="+seq_num;
		queryString +="&valid="+document.getElementById("valid").value;
		parent.orderset_dosage_type_dtl.document.location.href = "../jsp/OrdersetComponentDetailAdded.jsp?"+queryString;
		parent.orderset_dosage_type_btn.document.location.href = "../jsp/OrdersetComponentDetailAddedButton.jsp?"+queryString+"&p_invoke_func=ORD_SET_AGE_GRP";
	}	
}

function IncludesByDosageType(index,order_category,appl_to,fetch_dosage_type,catalog_code)
{

	var bean_id		= document.getElementById("bean_id").value;
	var bean_name	= document.getElementById("bean_name").value;
	if(order_category=="PH"){
		if((eval(document.getElementById("include"+index)).checked)== true){
			/*if(fetch_dosage_type=='A'){
				var hyper_link_val="<a href=\"javascript:showDosageAgeWiseDetails('"+index+"')\"><img src='..//images//Age.gif\'></a>";	
				eval("document.getElementById("Includes")"+index).innerHTML=hyper_link_val;
				eval("document.getElementById("Includes")"+index).style.visibility='visible';
			}
			else{
				var hyper_link_val="<a href=\"javascript:callDosageTypeAdditionalRows('"+index+"')\">+</a>";//IN68241	
				eval("document.getElementById("Includes")"+index).innerHTML=hyper_link_val;
				eval("document.getElementById("Includes")"+index).style.visibility='visible';//IN68241
			}*/
		}else{
			eval(document.getElementById("Includes"+index)).innerHTML="";

		}
		
	if((eval(document.getElementById("include"+index)).checked)== false)
		clearDosageTypeWise(fetch_dosage_type,bean_id,bean_name,catalog_code);
	}
}

function clearDosageTypeWise(fetch_dosage_type,bean_id,bean_name,catalog_code,age_grp_code)
{	

	var xmlStr ="<root><SEARCH ";	
	xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
	xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
	xmlStr += " P_DOSAGE_TYPE=\""+ fetch_dosage_type + "\" ";
	xmlStr += " CATALOG_CODE=\""+ catalog_code + "\" ";
	xmlStr += " P_AGE_GRP_CODE=\""+ age_grp_code + "\" ";
	xmlStr += " CLASS_NAME=\"DOSAGE_TYPE_DEFN_CLEAR\"";
	xmlStr +=" /></root>";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open("POST","OrderSetValidate.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
}

function includeDosageType()
{
	selFlag			 = true ;
	var formObj = parent.orderset_dosage_type_dtl.orderset_by_dosage_type_dtl_form;
	var order_catalog_code = parent.orderset_dosage_type_dtl.orderset_by_dosage_type_dtl_form.p_order_catalog_code.value;
	var order_set_seq_num = parent.orderset_dosage_type_dtl.orderset_by_dosage_type_dtl_form.p_order_set_seq_num.value;
	var l_selectedCatIndex = parent.orderset_dosage_type_dtl.orderset_by_dosage_type_dtl_form.p_selectedCatIndex.value;	

	var l_invoke_func = document.getElementById("p_invoke_func").value;
	var l_selected_occ_no = "";
	
	arrValues = new Array();
	
	for(var i = 0;i<3;i++)
	{	
		var include = eval('formObj.document.getElementById("include")'+i);
		
		if (include && include.checked)		
		{
			if(!arrValues.contains(eval("formObj.dosage_type_seq_no"+i).value))
			{
				if(eval("formObj.dosage_type_seq_no"+i).value!='')
					arrValues.push(eval("formObj.dosage_type_seq_no"+i).value);
			}
			else
			{
				//alert("APP-OR0472 Contains duplicate Occurrance No");
				alert(getMessage("DUPLICATE_OCC_NO","OR"));
				return;			
			}
		}
	}	
	
	if(formObj.document.getElementById("bean_id")!=undefined)
	{
		var bean_id		= document.getElementById("bean_id").value;
		var bean_name	= document.getElementById("bean_name").value;
		var value_str	= "";
		var pmpt_msg	= "";
		var route_codes	= "";
		var route_descs	= "";
		var rel_start_date_times	= "";
		var durn_values	= "";
		var durn_types	= "";
		var freq_codes	= "";
		var index_values	= "";
		var qty_units = "";
		var qty_uoms = "";
		var dosage_types = "";
		var order_set_seq_nums = "";
		var dosage_type_seq_nos = "";
		var count	= 0;

		fm_disp = 0;
		to_disp = 3;
		chkCnt = 0;
		
		for(var i=fm_disp; i<to_disp; i++)
		{
			var include = eval('formObj.document.getElementById("include")'+i);			
			var qty_unit = eval('formObj.document.getElementById("qty_unit")'+i).value;
			var qty_uom = eval('formObj.document.getElementById("qty_uom")'+i).value;
			var freq_code = eval('formObj.document.getElementById("freq_code")'+i).value;	
			var durn_value = eval('formObj.document.getElementById("durn_value")'+i).value;
			var durn_type = eval('formObj.document.getElementById("durn_type")'+i).value;
			var order_set_seq_num = eval('formObj.document.getElementById("order_set_seq_num")'+i).value;
			var rel_start_date_time = eval('formObj.document.getElementById("rel_start_date_time")'+i).value;					
			var route_code = eval('formObj.document.getElementById("route_code")'+i).value;
			var route_desc = eval('formObj.document.getElementById("route_desc")'+i).value;
			var prompt_msg = eval('formObj.document.getElementById("prompt_msg")'+i).value;
			var qty_reqd_yn = eval('formObj.document.getElementById("qty_reqd_yn")'+i).value;
			var dosage_type = eval('formObj.document.getElementById("p_fetch_dosage_type")'+i).value;
			var dosage_type_seq_no = eval('formObj.document.getElementById("dosage_type_seq_no")'+i).value;			
			
			if (include && include.checked)
			{
				chkCnt++;
				val = !include.disabled?(include.checked?"Y":"N"):"N";
					
				value_str += val+"~";			
				
				if(qty_reqd_yn == 'Y' && qty_unit == '')
				{
					alert("APP-OR0030 Qty. cannot be blank");
					return false;
				}

				qty_unit = qty_unit == ""?"@#":qty_unit;
				qty_units += qty_unit+"~";

				qty_uom = qty_uom==""?"@#":qty_uom;
				qty_uoms += qty_uom+"~";

				freq_code = freq_code==""?"@#":freq_code;
				freq_codes += freq_code+"~";
				
				order_set_seq_num = order_set_seq_num==""?"@#":order_set_seq_num;
				order_set_seq_nums += order_set_seq_num+"~";

				if(durn_type != '' && durn_value == '')
				{
					alert("APP-OR0028 Durn is mandatory for all selected Freq. Codes");
					return false;
				}

				durn_value = durn_value==""?"@#":durn_value;
				durn_values += durn_value+"~";

				durn_type = durn_type==""?"@#":durn_type;
				durn_types += durn_type+"~";

				if(rel_start_date_time == '')
				{
					alert("APP-OR0027 Time is Mandatory");
					return false;
				}

				rel_start_date_time = rel_start_date_time==""?"@#":rel_start_date_time;
				rel_start_date_times += rel_start_date_time+"~";					
				
				if(route_code == '')
				{
					alert(getMessage("ORDER_SET_ADMIN_ROUTE","OR"));
					return false;
				}
				
				route_code = route_code==""?"@#":route_code;
				route_codes += route_code+"~";
				
				route_desc = route_desc==""?"@#":route_desc;
				route_descs += route_desc+"~";

				prompt_msg = prompt_msg==""?"@#":prompt_msg;
				pmpt_msg += prompt_msg+"~";
				
				dosage_type = dosage_type==""?"@#":dosage_type;
				dosage_types += dosage_type+"~";				
				
				if(dosage_type_seq_no == '')
				{
					//alert("APP-OR0472 Occurance no cannot be blank");
					alert(getMessage("OCC_NO_CANNOT_BLANK","OR"));					
					return false;
				}
				
				dosage_type_seq_no = dosage_type_seq_no==""?"@#":dosage_type_seq_no;
				dosage_type_seq_nos += dosage_type_seq_no+"~";				
				
						

				index_values += (i+1)+"~";
				count++;
			}			
		}	

		var xmlStr ="<root><SEARCH ";
		xmlStr += " INDEX_VALUES=\""+ index_values + "\" ";
		xmlStr += " VALUE_STR=\""+ value_str + "\" ";
		xmlStr += " PROMPT_MSG=\""+ encodeURIComponent(pmpt_msg,'UTF-8') + "\" ";//IN065144
		xmlStr += " CATALOG_CODE=\""+ order_catalog_code + "\" ";		
		xmlStr += " ORDER_SET_SEQ_NUM=\""+ order_set_seq_nums+ "\" ";
		xmlStr += " DURN_TYPE=\""+ durn_types + "\" ";
		xmlStr += " DURN_VALUE=\""+ durn_values + "\" ";
		xmlStr += " REL_START_DATE_TIME=\""+ rel_start_date_times + "\" ";
		xmlStr += " ROUTE_CODE=\""+ route_codes + "\" ";
		xmlStr += " ROUTE_DESC=\""+ route_descs + "\" ";
		xmlStr += " FREQ_CODE=\""+ freq_codes + "\" ";
		xmlStr += " FROM_VALUE=\""+ fm_disp + "\" ";
		xmlStr += " TO_VALUE=\""+ to_disp + "\" ";
		xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
		xmlStr += " COUNT=\""+ count + "\" ";
		xmlStr += " QTY_UNIT_STR=\""+ qty_units + "\" ";
		xmlStr += " QTY_UOM=\""+ qty_uoms + "\" ";
		xmlStr += " DOSAGE_TYPE=\""+ dosage_types + "\" ";
		xmlStr += " DOSAGE_TYPE_SEQ_NO=\""+ dosage_type_seq_nos + "\" ";
		xmlStr += " CLASS_NAME=\"DOSAGE_TYPE_DEFN\"";
		xmlStr +=" /></root>";

		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","OrderSetValidate.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		
   }

   window.close();
   
   clearAdditionalForBasicDosageType(bean_id,bean_name,order_catalog_code,l_selectedCatIndex);
   
}

function cancelDosageTypeAgeWise()
{		
	var l_query_string = document.getElementById("p_query_string").value;
	parent.orderset_dosage_type_dtl.document.location.href='../jsp/OrderSetDosageByTypeDefinition.jsp?'+l_query_string;
	parent.orderset_dosage_type_btn.document.location.href='../jsp/OrderSetDosageByTypeDefinitionButtons.jsp?'+l_query_string;
}

function cancelDosageType()
{	
	window.close();
}

function clearAdditionalForBasicDosageType(bean_id,bean_name,catalog_code,index)
{
	var xmlStr ="<root><SEARCH ";	
	xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
	xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
	//xmlStr += " P_DOSAGE_TYPE=\""+ fetch_dosage_type + "\" ";
	xmlStr += " CATALOG_CODE=\""+ catalog_code + "\" ";
	xmlStr += " INDEX=\""+ index + "\" ";
	xmlStr += " CLASS_NAME=\"CLEAR_ADDITIONAL_FOR_BASIC_DOSAGE_TYPE\"";
	xmlStr +=" /></root>";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OrderSetValidate.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;	
	eval(responseText);
}
//IN68241, ends

function clearOnReset(bean_id,bean_name)//IN068370,IN068373, starts
{
	var xmlStr ="<root><SEARCH ";
	xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
	xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
	xmlStr += " CLASS_NAME=\"CLEAR_MAPPED_FACS\"";
	xmlStr +=" /></root>";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OrderSetValidate.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
}//IN068370,IN068373, ends
//IN068314 Starts
function validatefppcatalog(obj){
	
	var bean_id		= document.getElementById("bean_id").value;
	var bean_name	= document.getElementById("bean_name").value;
		
	if(obj.checked)
	{
		document.getElementById('fpp_yn').value = 'Y';
	}
	else{
		document.getElementById('fpp_yn').value = 'N';
	}
	
	
	var xmlStr ="<root><SEARCH ";
	xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
	xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
	xmlStr += " CLASS_NAME=\"VALIDATE_FPP_CATALOGS\"";
	xmlStr +=" /></root>";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OrderSetValidate.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	parent.parent.display('S');//IN072524
	//parent.frames[2].location.reload();//IN072524
}
//IN068314 Ends
/*******************************************************************************/
/**Reference Pattern for Frame's and form Object For Catalog By section

Menu
	|
	CareSet.jsp---->CareSet.js
		|
		|------CommonToolBar.jsp--------------------------------------------------------------------------------------------------->commontoolbarFrame[Frame]
		|
		|------OrderSetAddModify.jsp/OrderSetQueryCriteria.jsp/OrderSetQueryResult.jsp-------------------------->f_query_add_mod{FrameSet}
		|		|
		|		|---OrderSetAddModifyHeader.jsp----->header[Frame]
		|		|		Document ---headerDoc
		|		|		FormObect---formObjHeader		 header[form]
		|		|		Reference from  this JSP will  be as parent.parent.XXX()
		|		|
		|		|---OrderSetTab.jsp	---------------->tab[Frame]
		|		|		Document ---tabDoc
		|		|		FormObect---formObjTab			 tab[form]
		|		|		Reference from  this JSP will  be as parent.parent.XXX()
		|		|
		|		|---OrderSetAddModifyDetail.jsp----->detail{frameset}
		|		|		|
		|		|		|
		|		|		|
		|		|		|
		|		|		|------------OrderSetComponentDetailTab.jsp/OrderSetSettingDetailForm.jsp/OrderSetSynonymForm.jsp-------detailUpper-[Frame]
		|		|		|Document ---detailUpperDoc
		|		|		|FormObect---detailUpperForm	  [form]  (Form name=detailUpperForm)
		|		|		|Reference from  this JSP will  be as parent.parent.parent.XXX()
		|		|		|
		|		|		|
		|		|		|
		|		|		|
		|		|		|------------OrderSetComponentDetailForm.jsp/Blank.html/Blank.html------------------------detailLower--[Frame]
		|		|		|
		|		|		|Document ---detailLowerDoc
		|		|		|FormObect---detailLowerForm		[form] (Form name=detailLowerForm)
		|		|		|Reference from  this JSP will  be as parent.parent.parent.XXX()
		|		|		|
		|
		|------error.jsp------------------------------------------------------------------------------------------------->messageFrame---------[Frame]
		|
**/

