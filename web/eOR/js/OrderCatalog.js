/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/* 
-----------------------------------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------------------------------
?             100         ?           created
04/07/2012	  IN032180    Nijitha S   PH Code Setup - PH Drug Setup - Drug->Click on Drug "Query" enter drug name and "Apply'
									  & 'Ok" , Order Catalog Web Page will open on click on ?Apply? button ?Operation Completed Successfully ?  message  is not retained in the message frame 
10/03/2014	  IN024984	  Chowminya		Duplicate order recording with reason - new mandatory option		
-------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------
02/04/2014	IN048083		Karthi L										Option need to be provided for Select All /  De-Select All 							  
12/07/2014	  IN048467		Karthi L										To have an indicator to skip the authorization process if the priority for that order is urgent.	
08/05/2017	IN063816		Vijayakumar K									GHL-CRF-0445.1 [IN:063816]	
15/12/2017	IN065942		Dinesh T			15/12/2017		Ramesh G		In Nuclear medicine  department we required the 																				barcode functionality at the time of 																						Registration of order,required patient 																						Id,patient name,age,sex,register date and name 																				of study.
01/08/2018	IN64543			Dinesh T		01/08/2018	Ramesh G		ML-MMOH-CRF-0776
07/08/2018	IN064543		Kamalakannan	07/08/2018		Ramesh G		ML-MMOH-CRF-0776
20/11/2018		ML-MMOH-SCF-1108		Kamalakannan 		Ramesh G			20/11/2018			ML-MMOH-SCF-1108
28/02/2019  IN068370    	Dinesh T      	28/02/2019    	Ramesh G    	PMG2018-GHL-CRF-0014
28/02/2019  IN068373    	Dinesh T      	28/02/2019    	Ramesh G    	PMG2018-GHL-CRF-0015
09/09/2019	IN071296		Ramesh G										PMG2019-COMN-CRF-0015
30/11/2020     TFSID-8081        Haribabu      18/11/2020       Ramesh G            GHL-SCF-1531
07/09/2020	7540			Nijitha S		07/12/2020		Nijitha S		PMG2019-MMS-CRF-0004.1
-------------------------------------------------------------------------------------------------------------------------------
*/
var function_id = "" ;
var mod_qry_str = "" ;//this suppose to have the Parameter Passed by the other modules
var resultGlobal = false;
var messageGlobal = "" ;
var invalidCode = "";
var flagGlobal = true;
var flagChk = false;
var qry_str = "";
var check="";
var currentTab ="";
var linkContent = "";



/*************Handle to the Frame's and the form Object ****************/
var headerDoc			=null;
var detailDoc			=null;
	var detailUpperDoc  =null;
	var detailLowerDoc  =null;
var tabDoc				=null;

var formObjHeader		=null;
var formObjDetail		=null;
	var detailUpperForm  =null;
	var detailLowerForm  =null;
var formObjTab			=null;
/*****************initailisation*************************************/
function intialisation(){
 currentTab ="";
 resultGlobal = false;
 messageGlobal = "" ;
 invalideCode = "";
 flagGlobal = true;
 flagChk = false;
}
/*******************************************************************/
function create() {
  	intialisation();
	f_query_add_mod.location.href = "../../eOR/jsp/OrderCatalogAddModify.jsp?mode=1&function_id="+function_id+"&"+qry_str;
}
/******************************************************************************/
function query() {
	
	f_query_add_mod.location.href="../../eOR/jsp/OrderCatalogQueryCriteria.jsp?function_id="+function_id +"&"+qry_str;
}
/****************************************************************************/
function dummmy(){
}
/*******************************************************************************/
function defaultLoadDetail(){//Called in when ever header page is loaded
	getHandleHeader();

	setTimeout('dummmy();',1000);

	//only when called in modify mode or from other modules...........

if(f_query_add_mod.header.document.header!=null)
	{
	 
	if( f_query_add_mod.header.document.getElementById('mode').value == MODE_MODIFY  ){
		intialisation();
		defaultTabChar();//to select the tab(Characteristics)
		if(f_query_add_mod.header.document.header.order_category.value=="PH")
			display('Timing');		
		else		
			display('C');		
	}

	if( f_query_add_mod.header.document.getElementById('module_id').value != "OR" && f_query_add_mod.header.document.getElementById('mode').value != MODE_MODIFY){//whenever called from other module in insert mode
		//defaultTabChar();//to select the tab(Characterstics)
		//display('C');
	}
	}
}
/******************************************************************************/
function apply() {
	var formObjSyn = null;
	if (! checkIsValidForProceed() ) {
		var message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
		return false ;
	}
	

	getHandleHeader();
	getHandleDetail();

	var chkMandatoryFlag = true ;
	/*NEED TO BE REVERTED AFTER FINDING SOLUTION. 
	if( formObjHeader.order_category.value == "PH" && formObjHeader.module_id.value == "OR")
	{
		var message="jdfjkld"+getMessage("PH_NOT_ALLOWED","OR");
		//alert("Pharmacy cannot be updated from here....");
		alert(message);
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		return false;
	}*/
	var l_globalFacilityYn = formObjHeader.globalFacilityYn.value;//IN068370,IN068373
	var l_siteSpecGlobalFac = formObjHeader.siteSpecGlobalFac.value;//IN068370,IN068373
	var	fields = new Array (formObjHeader.order_catalog_code,
							formObjHeader.long_desc,
							formObjHeader.short_desc,
							formObjHeader.order_category,
							formObjHeader.order_type_code
							
		);
	var	names =	new	Array (getLabel("Common.code.label","Common"),getLabel("Common.longdescription.label","Common"),getLabel("Common.shortdescription.label","Common"),getLabel("Common.OrderCategory.label","Common"),getLabel("Common.OrderType.label","Common"));

	//IN068370,IN068373, starts
	if (l_globalFacilityYn == 'Y' && l_siteSpecGlobalFac == 'true') {
		fields.push(formObjHeader.applFacsMappedYn);
		names.push(getLabel("eOR.ApplicableFacilities.label", "or"))
	}
	//IN068370,IN068373, ends
	if(!checkFields(fields,names, messageFrame)){
			//	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";

		return ;
	}

	var flds=new Array(formObjHeader.order_catalog_code);
	var name=new Array("Code");
	
	if(!SpecialCharCheckPH(flds,name,messageFrame,"M","../../eCommon/jsp/error.jsp")){// called to allow special chars like (.) ,(-)
	//if(!SpecialCharCheck(flds,name,messageFrame,"M","../../eCommon/jsp/error.jsp")){// this allows standard spl charas
				return false;
	}
	if(f_query_add_mod.detail.location.href.indexOf(".jsp") == -1){
		alert(getMessage("CANNOT_SYNC","OR"));
	}else{
	     if(currentTab !== ""){ //i:e Before Clicking tabs there is already tab seleted
			if(currentTab == "C" || currentTab == "O" || currentTab == "Timing" ){
				if(getHandleDetailLower()) {
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
					if (formObjSyn.qty_uom_desc) {
						if (formObjSyn.qty_uom_desc.value != "" && formObjSyn.qty_uom.value == "") {
							formObjSyn.qty_uom.value = formObjSyn.qty_uom_desc.value;
						}
					}

					///////////////////////////////-- For consent changes
					var multiple_consent_yn = formObjSyn.multiple_consent_yn.checked;
					var consent_req_bo = formObjSyn.num_of_consent_req_bo.value;
					var consent_req_br = formObjSyn.num_of_consent_req_br.value;
					var count = parseInt(consent_req_bo) + parseInt(consent_req_br);
					if(multiple_consent_yn==true)
					{
						if(count<=1)
						{
							//var msg = getOrMessage("OR_ORDER_CATALOG_CONSENT_REQUIRED");
							var msg = getMessage("OR_ORDER_CATALOG_CONSENT_REQUIRED","OR");
							messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;
								return false;
						}
					}
					//////////////////////////////
				}
			}else{
				if (currentTab == "P") {
				    if (getHandleDetailUpperPrep()) {
						formObjSyn = detailUpperForm ;
				    }
							
					if (getHandleDetailLowerPrep()) {
						latestUpdateUpper();
						
					}
				} else if (currentTab == "T") {
					
				    if(getHandleDetailUpper()) {
    				    formObjSyn = detailUpperForm ;
						
                        if (formObjSyn && formObjSyn.stat_turn_around_time.value != "" && formObjSyn.stat_turn_around_type.value == "") {
						   	alert(getMessage("STAT_DURATION_TYPE_BLANK","OR"));
							messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
                            return false;
    				    }
    				    if (formObjSyn &&  formObjSyn.urgent_turn_around_time.value != "" && formObjSyn.urgent_turn_around_type.value == "") {							
                            alert(getMessage("URGENT_DURATION_TYPE_BLANK","OR"));
							messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
                            return false;
    				    }
    				    if (formObjSyn && formObjSyn.routine_turn_around_time.value != "" && formObjSyn.routine_turn_around_type.value == "") {							
                            alert(getMessage("ROUTINE_DURATION_TYPE_BLANK","OR"));
							messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
                            return false;
    				    }

    				    if (formObjSyn &&  formObjSyn.stat_turn_around_time.value == "" && formObjSyn.stat_turn_around_type.value != "") {
                            alert(getMessage("STAT_DURATION_BLANK","OR"));
							messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
                            return false;
    				    }
    				    if (formObjSyn &&  formObjSyn.urgent_turn_around_time.value == "" && formObjSyn.urgent_turn_around_type.value != "") {
                            alert(getMessage("URGENT_DURATION_BLANK","OR"));
							messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
                            return false;
    				    }
    				    if (formObjSyn.routine_turn_around_time.value == "" && formObjSyn.routine_turn_around_type.value != "") {
                            alert(getMessage("ROUTINE_DURATION_BLANK","OR"));
							messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
                            return false;
    				    }
    				}
                } else {
                    if(getHandleDetailUpper())
    				 formObjSyn = detailUpperForm ;
				}
			}
			doSync(formObjSyn);

		}
	}//end of Sync
  var resultFunction = formApply(formObjHeader,OR_CONTROLLER);
  resultFunction = resultFunction.trim();
  resultFunction = resultFunction.replace(/"/g,'\"').replace(/'/g,"\'");
	eval(resultFunction);
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ messageGlobal;
	if(resultGlobal){
		onSuccess();	
	return true ;
	}else{
	return false;
	}
}
/******************************************************************************/
function onSuccess() {

	if(formObjHeader.ot_module.value == "OT")
	{
		alert(messageGlobal);

		window.close();
	}
	if(formObjHeader.oh_module.value == "OH")
	{
		alert(messageGlobal);
		window.returnValue="Y";
		window.close();
	}
	getHandleHeader();
	if( f_query_add_mod.header.document.getElementById('mode').value == MODE_INSERT )
	create();
	else if( f_query_add_mod.header.document.getElementById('mode').value == MODE_MODIFY ) {
	f_query_add_mod.document.location.href="../../eOR/jsp/OrderCatalogAddModify.jsp?"+formObjHeader.qry_str.value ;
	}
}
/********************reset *************************************/
function reset() {
//if(headerDoc.ot_module.value != 'OT')
//	{
  if(f_query_add_mod.header != null){
  	 if( f_query_add_mod.header.mode.value == MODE_MODIFY ){//modify mode
	  	 f_query_add_mod.document.location.href = "../../eOR/jsp/OrderCatalogAddModify.jsp?"+formObjHeader.qry_str.value;
	  }else{//insert mode

		if(f_query_add_mod.header.module_id.value == "PH" || f_query_add_mod.header.ot_module.value == "OT"){
			f_query_add_mod.document.location.href = "../../eOR/jsp/OrderCatalogAddModify.jsp?"+formObjHeader.qry_str.value
			intialisation();
			return ;
		}
		getHandleHeader();
		if(f_query_add_mod.header.oh_module.value != "OH")
		{
			removeOptions(f_query_add_mod.header.document.getElementById("order_type_td") ,"OrderType");
		}
		intialisation();
		formObjHeader.reset();
		clearOnReset(formObjHeader.bean_id.value, formObjHeader.bean_name.value);//IN068370,IN068373
		f_query_add_mod.detail.location.href = "../../eCommon/html/blank.html";
	  }
  }
  else if(f_query_add_mod.document.forms[0]!=null)
    f_query_add_mod.document.forms[0].reset(); //reset in query mode
  else
	  {
		  frames[0].location.reload();
		  return false;
	  } 
//	}
}
/******************************************************************************/
function changeType(obj,noOfRecords){
	parent.parent.parent.frames[2].frames[0].frames[0].document.forms[0].pri_sec_tasks_type.value=obj.value;
	for (i=0;i<noOfRecords ; i++)
	{
		var objCheck= eval('parent.parent.parent.frames[2].frames[0].frames[0].document.forms[0].patient_class_chk'+i);
		objCheck.value='N'
		objCheck.checked=false;		
	}
	parent.parent.parent.frames[2].frames[0].frames[1].document.location.href= "../../eCommon/html/blank.html";
	
	var bean_id=parent.parent.parent.frames[2].frames[0].frames[0].document.forms[0].bean_id.value;
	var bean_name=parent.parent.parent.frames[2].frames[0].frames[0].document.forms[0].bean_name.value;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
	xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
	xmlStr += " clearFlag=\"true\"";
	xmlStr +=" /></root>";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OrderCatalogAddModifyPrepDetailValidate.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;

	return true;
		
	

}
/*******************************************************************************/

function assignResult(res,msg,mod,code){
	resultGlobal = res ;
	messageGlobal = msg ;
	flagGlobal = mod;
  invalidCode = code;
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

	if(Obj.value.length > parseInt(len)){
		alert(getMessage("NO_OF_CHARACTERS","OR")+len);
		Obj.focus();
	}

}
/*****************************************************************************/
function defaultTabChar(){
	getHandleTab();
	if(f_query_add_mod.header.document.header.order_category.value=="PH"){
	setTimeout('dummmy();',1000);	
	
	if(document.getElementById("setupTab")  != undefined){		
    f_query_add_mod.tab.document.getElementById('setupTab').className			= "normal";
	}

	if(document.getElementById("timingTab")!= undefined)
	f_query_add_mod.tab.document.getElementById('timingTab').className			= "clicked" ;
	}else{
	setTimeout('dummmy();',1000);	
		
	if(document.getElementById('setupTab')  != undefined){		
    f_query_add_mod.tab.document.getElementById('setupTab').className			= "clicked";
	}

	if(document.getElementById('timingTab') != undefined)
	f_query_add_mod.tab.document.getElementById('timingTab').className			= "normal" ;	
	}
	setTimeout('dummmy();',1000);	
	if(document.getElementById("reviewsTab") != undefined)
	f_query_add_mod.tab.document.getElementById('reviewsTab').className			= "normal" ;


	if(document.getElementById("instructionsTab") != undefined)
	f_query_add_mod.tab.document.getElementById('instructionsTab').className	= "normal" ;


	if(document.getElementById("settingsTab") != undefined)
	f_query_add_mod.tab.document.getElementById('settingsTab').className		= "normal" ;
}
/***********************************************************************/
function  resetDefaultTabChar() {
	defaultLoadDetail()
   getHandleTab();

	if(tabDoc.setupTab  != undefined || tabDoc.setupTab != null){
	tabDoc.setupTab.className			= "normal";
	}

	if(tabDoc.frequencyTab != undefined)
	tabDoc.frequencyTab.className			= "normal" ;

	if(tabDoc.reviewsTab != undefined)
	tabDoc.reviewsTab.className			= "normal" ;


	if(tabDoc.instructionsTab != undefined)
	tabDoc.instructionsTab.className	= "normal" ;


	if(tabDoc.settingsTab != undefined)
	tabDoc.settingsTab.className		= "normal" ;

}
/********THIS IS USE TO SELECT JSP PAGES CALLED FROM ORDERCATALOG TAB PAGE*****/
function display(obj){
if(f_query_add_mod.header.document.getElementById('mode').value == MODE_INSERT )
{
	defaultLoadDetail();
}
//	if(!flagTabPageLoaded)
//		return false ;

	//Obj is "" when it is called on change of order type,so detail frame is blank



	if(!mandatoryChk() && obj!= "" ){
		if( header.mode.value != MODE_MODIFY ){//Because Order Type cannot be Changed and currebt Tab cannot be ""
			currentTab = ""; //here all current tab selection  is invalited and made to ""
			getHandleHeader();
			resetDefaultTabChar();
			header.order_type_code.selectedIndex = 0;
			f_query_add_mod.detail.location.href = "../../eCommon/html/blank.html";
			return ;
		}
	}else{
			//messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";//IN033181
	}


	var formObjSyn = null ;
	if(currentTab == "C" || currentTab=="Timing" || currentTab=="O" ){
		defaultTabChar();
		 if(getHandleDetailLower()) {
			formObjSyn = detailLowerForm ;
			if (formObjSyn.catalog_synonym_directCare) {
				//if (formObjSyn.catalog_synonym_directCare) {
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
				//}
			}
			if (formObjSyn.qty_uom_desc) {
				if (formObjSyn.qty_uom_desc.value != "" && formObjSyn.qty_uom.value == "") {
					formObjSyn.qty_uom.value = formObjSyn.qty_uom_desc.value;
				}
			}
		}
	}else{
         if (currentTab == "P") {
		    if (getHandleDetailUpperPrep()) {
		        formObjSyn = detailUpperForm ;
		    }
			if (getHandleDetailLowerPrep()) {
				latestUpdateUpper();
			}
		 }else if (currentTab == "T") {
    	    if(getHandleDetailUpper()) {
    		    formObjSyn = detailUpperForm ;

                if (formObjSyn.stat_turn_around_time.value != "" && formObjSyn.stat_turn_around_type.value == "") {
                    alert(getMessage("STAT_DURATION_TYPE_BLANK","OR"));
                    return false;
			    }
			    if (formObjSyn.urgent_turn_around_time.value != "" && formObjSyn.urgent_turn_around_type.value == "") {
                    alert(getMessage("URGENT_DURATION_TYPE_BLANK","OR"));
                    return false;
			    }
			    if (formObjSyn.routine_turn_around_time.value != "" && formObjSyn.routine_turn_around_type.value == "") {
                    alert(getMessage("ROUTINE_DURATION_TYPE_BLANK","OR"));
                    return false;
			    }

			    if (formObjSyn.stat_turn_around_time.value == "" && formObjSyn.stat_turn_around_type.value != "") {
                    alert(getMessage("STAT_DURATION_BLANK","OR"));
                    return false;
			    }
			    if (formObjSyn.urgent_turn_around_time.value == "" && formObjSyn.urgent_turn_around_type.value != "") {
                    alert(getMessage("URGENT_DURATION_BLANK","OR"));
                    return false;
			    }
			    if (formObjSyn.routine_turn_around_time.value == "" && formObjSyn.routine_turn_around_type.value != "") {
                    alert(getMessage("ROUTINE_DURATION_BLANK","OR"));
                    return false;
			    }
    		}
        } else {
             if(getHandleDetailUpper())
    			 formObjSyn = detailUpperForm ;
		 }
	}



	if(currentTab !== "" && currentTab !== "B"){ //i:e Before Clicking tabs there is already tab seleted
		setTimeout('dummmy();',1000);
	   	eval(doSync(formObjSyn));
	}

	setTimeout('dummmy();',1000);

	var tabFlag = obj ;
	getHandleTab();
	getHandleHeader();
     
	var  urlParams = f_query_add_mod.header.document.getElementById('qry_str').value +"&tabFlag="+tabFlag +"&order_category="+formObjHeader.order_category.value + "&order_type_code="+formObjHeader.order_type_code.value+"&order_catalog_code="+formObjHeader.order_catalog_code.value;

	if(getHandleDetail()){

//		flagTabPageLoaded = false ; //indicating we are loading the tab page but it is not loaded yet process is going on..........
		if(tabFlag != "")
			f_query_add_mod.detail.location.href = "../../eOR/jsp/OrderCatalogAddModifyDetail.jsp?"+ urlParams ;
		else
			f_query_add_mod.detail.location.href = "../../eCommon/html/blank.html";

		if(tabFlag != "" || tabFlag != null)
			currentTab =  tabFlag ;

	}else{
//		alert("Wrong Acssess.....");
	}
}
/****doSync This function--Sync the current tab to bean before going to other tab********/
function doSync(frmObj){

if(frmObj == null)
		return ;

 var xmlHttp = new XMLHttpRequest();
 var xmlDoc = new DOMParser().parseFromString( buildXml(frmObj), "text/xml");
 //xmlDoc.loadXML(xmlString);
 xmlHttp.open("POST","../../eOR/jsp/OrderCatalogSync.jsp",false);
 xmlHttp.send(xmlDoc);
 return xmlHttp.responseText  ;
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
			else if(arrObj[i].type == "textarea" )//IN64543, starts
			{				
				//val = arrObj[i].innerText;
				val = arrObj[i].value;

				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;	
			}//IN64543, ends
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
	getHandleHeader();
	/*var	fields = new Array (formObjHeader.order_catalog_code,
							formObjHeader.long_desc,
							formObjHeader.short_desc,
							formObjHeader.order_category,
							formObjHeader.order_type_code);
	//var	names =	new	Array ("Code","Long Description","Short Description","Order Type");

	if(!checkFieldsofMstLocal(fields))
		return false ;
	else
		return true ;

  */

	var	fields = new Array (formObjHeader.order_catalog_code,
							formObjHeader.long_desc,
							formObjHeader.short_desc,
							formObjHeader.order_category,
							formObjHeader.order_type_code);
	var	names =	new	Array (getLabel("Common.code.label","Common"),getLabel("Common.longdescription.label","Common"),getLabel("Common.shortdescription.label","Common"),getLabel("Common.OrderCategory.label","Common"),getLabel("Common.OrderType.label","Common"));

	if(!checkFields(fields,	names, messageFrame)){
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
/******************************************************************/
/*******This is use to select View(Tab) CHARACTERSTICS tag************/
function displayForOthersSetUp(obj){
	getHandleDetailUpper();
	getHandleHeader();

	if(detailUpperForm.detail_page_loaded.value == "N"){ //i:e when the detail page is not loaded

		if(getHandleDetailLower())
		f_query_add_mod.detail.detailLower.location.href = "../../eOR/jsp/OtherSetUpDetailForm.jsp?tabFlag="+tabFlag+ "&order_category="+formObjHeader.order_category.value + "&order_type_code="+formObjHeader.order_type_code.value;
		else{
		}

		detailUpperForm.detail_page_loaded.value  = "y"
	}

	var tabFlag = obj ;
	
	

	if(getHandleDetailLower()){
		if(tabFlag == "S"){
			detailLowerDoc.getElementById("synonyms").style="display";
			detailLowerDoc.getElementById("synonyms").style.visibility="visible";
			detailLowerDoc.getElementById("timing").style.display="none";
			detailLowerDoc.getElementById("duplicate").style.display="none";
			detailLowerDoc.getElementById("consent_refusal").style.display="none";
			detailLowerDoc.getElementById("explanatoryText").style.display="none";
			detailLowerDoc.getElementById("others").style.display="none";
		}/*else if(tabFlag == 'Timing'){
			detailLowerDoc.getElementById("timing").style="display";
			detailLowerDoc.getElementById("timing").style.visibility="visible"
			detailLowerDoc.getElementById("synonyms").style.display="none";
			detailLowerDoc.getElementById("duplicate").style.display="none";
			detailLowerDoc.getElementById("explanatoryText").style.display="none";
			detailLowerDoc.getElementById("others").style.display="none";
		}else if(tabFlag == 'O'){
			detailLowerDoc.getElementById("others").style="display";
			detailLowerDoc.getElementById("others").style.visibility="visible"
			detailLowerDoc.getElementById("timing").style.display="none";
			detailLowerDoc.getElementById("duplicate").style.display="none";
			detailLowerDoc.getElementById("explanatoryText").style.display="none";
			detailLowerDoc.getElementById("synonyms").style.display="none";
		}*/
		else if(tabFlag == "D"){
			//detailLowerDoc.getElementById("duplicate").style.width="100%";
			detailLowerDoc.getElementById("duplicate").style="display";
			detailLowerDoc.getElementById("duplicate").style.visibility="visible";
			detailLowerDoc.getElementById("consent_refusal").style.display="none";
			detailLowerDoc.getElementById("timing").style.display="none";
			detailLowerDoc.getElementById("others").style.display="none";
			detailLowerDoc.getElementById("explanatoryText").style.display="none";
			detailLowerDoc.getElementById("synonyms").style.display="none";
	   }else if(tabFlag == "ConsentRefusal"){
			detailLowerDoc.getElementById("consent_refusal").style="display";
			detailLowerDoc.getElementById("consent_refusal").style.visibility="visible";
			detailLowerDoc.getElementById("timing").style.display="none";
			detailLowerDoc.getElementById("others").style.display="none";
			detailLowerDoc.getElementById("explanatoryText").style.display="none";
			detailLowerDoc.getElementById("synonyms").style.display="none";
			detailLowerDoc.getElementById("duplicate").style.display="none";
	   }else if(tabFlag == "E"){
		   detailLowerDoc.getElementById("explanatoryText").style="display";
		   detailLowerDoc.getElementById("explanatoryText").style.visibility="visible";
		   detailLowerDoc.getElementById("timing").style.display="none";
		   detailLowerDoc.getElementById("others").style.display="none";
		   detailLowerDoc.getElementById("synonyms").style.display="none";
		   detailLowerDoc.getElementById("duplicate").style.display="none";
		   detailLowerDoc.getElementById("consent_refusal").style.display="none";
	   }

	}else{
	//	alert("Wrong Acssess to detial Lower in java script");
	}
}
/*********************Header Handle*****************************/
function getHandleHeader(){
if(f_query_add_mod.header == null)
	 return false;
 headerDoc	     =f_query_add_mod.header.document ;
 formObjHeader   =headerDoc.header ;
}
/*********************tab Handle*****************************/
function getHandleTab(){
if(f_query_add_mod.tab == null)
	 return false;
if(f_query_add_mod.tab.document.tab==null)
	return false;
else{
 tabDoc	        =f_query_add_mod.tab.document ;
 formObjTab		 =tabDoc.tab ;
}
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
	return ;


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
//	display("");//to make detail frame blank
	if(obj.value == "PH"){
	//	alert("Pharmacy cannot be selected from here....");
		alert(getMessage("PH_SELECT_NOT","OR"));
		formObjHeader.order_category.selectedIndex = "0";
		return ;
	}

	f_query_add_mod.detail.location.href = "../../eCommon/html/blank.html";
	currentTab = "";	//Always make current Tab empty when detail frame is made blank.....

	resetDefaultTabChar()

	//var OrderCategory = "";
	//var order_type_code=""
	var  xmlAppend = "";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;


	var bean_id				= formObjHeader.bean_id ;
	var localeName				= f_query_add_mod.header.document.header.localeName.value ;


	if(obj.name == "order_category" ){
	if(obj.value == "" ) {
		removeOptions(f_query_add_mod.header.document.getElementById("order_type_td") ,"OrderType");
		removeOptions(f_query_add_mod.header.document.getElementById("order_type_td") ,"HotSpot");
		formObjHeader.image_link_lbl.style.visibility = "visible";
		formObjHeader.image_link_td.style.visibility = "visible";
		formObjHeader.image_link_id.value = '';
		formObjHeader.image_link_id.disabled = true;
		return ;
	}else{
		var order_category = obj.value ;
		if(order_category =="RX" || order_category =="RD" || order_category =="TR" )
		{
			//formObjHeader.image_link_lbl.style.visibility = "visible";
			f_query_add_mod.header.document.getElementById("image_link_lbl").style.visibility = "visible";
			//formObjHeader.image_link_td.style.visibility = "visible";
			f_query_add_mod.header.document.getElementById("image_link_td").visibility = "visible";
			formObjHeader.image_link_id.disabled=false;
			xmlAppend += "order_category"+"=\""+ order_category+"\" " ;
			xmlAppend += "type"+"=\"HotSpot\"" ;
			xmlStr ="<root><SEARCH " ;
			xmlStr =xmlStr + xmlAppend ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "OrderCatalogComboFill.jsp?bean_id="+bean_id.value+"&localeName="+localeName,false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			eval(responseText ) ;
			xmlAppend="";
		}else if(order_category=="PH")
		{
			formObjHeader.image_link_id.value = '';
			formObjHeader.image_link_lbl.style.visibility = "hidden";
			formObjHeader.image_link_td.style.visibility = "hidden";
			formObjHeader.image_link_lbl.innerHTML = "&nbsp";
			formObjHeader.image_link_td.style.visibility = "&nbsp";
		}
		else {
			removeOptions(f_query_add_mod.header.document.getElementById("image_link_td") ,"HotSpot");
			//formObjHeader.image_link_lbl.style.visibility = "visible";
			f_query_add_mod.header.document.getElementById("image_link_lbl").style.visibility = "visible";
			//formObjHeader.image_link_td.style.visibility = "visible";
			//formObjHeader.image_link_id.value='';
			f_query_add_mod.header.document.getElementById("image_link_lbl").value='';
			//formObjHeader.image_link_id.disabled=true;
			f_query_add_mod.header.document.getElementById("image_link_lbl").disabled=true;
		}
		xmlAppend += "order_category"+"=\""+ order_category+"\" " ;
		xmlAppend += "type"+"=\"OrderCategory\"" ;
		}
	}

	if(obj.name == "order_type_code" ){
	if(obj.value == "" ) {
		removeOptions(headerDoc.header.activity_type_td ,"ActivityType");
		return ;
	}else{
	
		var order_type_code = obj.value ;
		var order_category = formObjHeader.order_category.value ;
		xmlAppend += "order_category"+"=\""+ order_category+"\" " ;
		xmlAppend += "order_type_code"+"=\""+ order_type_code+"\" " ;
		xmlAppend += "type"+"=\"OrderType\"" ;
		}
	}
	xmlStr ="<root><SEARCH " ;
	xmlStr =xmlStr + xmlAppend ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderCatalogComboFill.jsp?bean_id="+bean_id.value+"&localeName="+localeName,false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;

	eval(responseText ) ;


}
/********************Dynamically add Option function************************/
function addComboObject(comboObjectString,Object){
    comboObjectString = comboObjectString.replace('-------------Select----------', '---Select---');
		getHandleHeader();		

		if(Object == "order_category")
	{
		var order_type		= 	f_query_add_mod.header.document.getElementById("order_type_td");
		
		comboObjectString=comboObjectString.replace('Select',getLabel("Common.defaultSelect.label","Common"))
		order_type.innerHTML = comboObjectString ;
	}if(Object == "HotSpot")
	{
		var image_link_td		= 	f_query_add_mod.header.document.getElementById("image_link_td");
		comboObjectString=comboObjectString.replace('Select',getLabel("Common.defaultSelect.label","Common"))
		image_link_td.innerHTML = comboObjectString ;
	}
	else if(Object == "order_type_code")
	{
		activity_type		= 	f_query_add_mod.header.document.getElementById("activity_type_td");
        comboObjectString=comboObjectString.replace('Select',getLabel("Common.defaultSelect.label","Common"))
		activity_type.innerHTML = comboObjectString ;
	}
}
/********************Clear the Options-- function***********************/
function removeOptions(comboObject,optionName){
	getHandleHeader();

	if(headerDoc.header.module_id.value == "PH"){
		return ;
	}	
	if(optionName == "OrderType")
	{
		var OrderType ='<select name="order_type_code" id="order_type_code" ><option value="">---'+getLabel("Common.defaultSelect.label","Common")+' ---</option></select><img src="../../eCommon/images/mandatory.gif" align=center></img>';
		comboObject.innerHTML = OrderType;
	}
	else if(optionName == "ActivityType")
	{
		var ActivityType ='<select name="activity_type" id="activity_type" ><option value="">---'+getLabel("Common.defaultSelect.label","Common")+' ---</option></select>';
		comboObject.innerHTML = ActivityType;
	}else if(optionName == "HotSpot")
	{
		var HotSpot = '<select name="image_link_id" id="image_link_id" ><option value="">--- '+getLabel("Common.defaultSelect.label","Common")+'  ---</option></select>';
		comboObject.innerHTML = HotSpot;
	}

}
/***************function of header File(OrderCatalogAddModifyHeader.jsp) to deafult values of lower frame and called when OtherSetUpDetailForm page is loaded*******/
function defaultIntLowerFrame(){
getHandleHeader();
objVal = formObjHeader.short_desc.value ;
var module_id =  formObjHeader.module_id.value ;

if(getHandleDetailLower()){
	if(detailLowerForm.catalog_synonym_primary != undefined || detailLowerForm.catalog_synonym_primary != null){
		if(objVal != null ){
			detailLowerForm.catalog_synonym_primary .value= objVal ;
			if(module_id == "PH") {
				if(detailLowerForm.contr_msr_panel_desc !=null && detailLowerForm.contr_msr_panel_id !=null){
			detailLowerForm.contr_msr_panel_desc.value    = formObjHeader.order_catalog_code.value ;
			detailLowerForm.contr_msr_panel_id.value       = formObjHeader.order_catalog_code.value ;
				}
			}
			if(objVal != "")
			detailLowerForm.effective_status_primary.checked = true ;
			else
			detailLowerForm.effective_status_primary.checked = false ;
		}
}
}
}
/*******function of detail Frame Lower -Validation for =>OtherSetUpDetailForm Page ****STARTS*******/
function chkFreq(Obj){
 getHandleDetailLower();

	if(Obj.checked == true){
	 if(detailLowerForm.update_soft_stop_yn_db.value == "Y" ||
			detailLowerForm.update_soft_stop_yn_db.value == "y" ){
 	    detailLowerForm.soft_stop_yn.disabled = false ;}

    if(detailLowerForm.update_cont_order_yn_db.value == "Y" ||
			detailLowerForm.update_cont_order_yn_db.value == "y" ){
 	     detailLowerForm.cont_order_yn.disabled = false ;}

	 detailLowerForm.contineous_freq_order.disabled	  		 =false ;
	}else{
	//	 detailLowerDoc.soft_stop_yn.disabled  				 = true  ;
	//	 detailLowerDoc.cont_order_yn.disabled				 = true  ;
	//	 detailLowerDoc.soft_stop_yn.checked				 = false ;
 	//	 detailLowerDoc.cont_order_yn.checked				 = false ;
		 detailLowerForm.contineous_freq_order.selectedIndex	 =	0;
 		 detailLowerForm.contineous_freq_order.disabled	  	 =true ;
	}

}

/*************when contineous_freq_order is chk/un chk Timing Tab****/
function chkCont_order_yn(obj){
 getHandleDetailLower();

 if(obj.checked == true){
	 detailLowerDoc.getElementById("contineous_freq_order_td").innerHTML = "<SELECT name='contineous_freq_order' id='contineous_freq_order'><option value=''>--- "+getLabel('Common.defaultSelect.label','Common')+"  ---</option><option value='D'>"+getLabel('eOR.explodebyday.label','OR')+"</option>";
 }else{
	 detailLowerDoc.getElementById("contineous_freq_order_td").innerHTML = "<SELECT name='contineous_freq_order' id='contineous_freq_order'><option value=''>"+getLabel('Common.notapplicable.label','Common')+"</option>";
 }

}

function showUOM(obj,order_category,module_id,mode) {
	 if(getHandleDetailLower())
	if (obj.checked == true || order_category == 'PH' || module_id == 'PH') {
		
		detailLowerDoc.getElementById("uom_lbl_td").innerHTML 	= "&nbsp;UOM";

		if (module_id != 'PH' || order_category != 'PH') {
			
			/*if (mode == MODE_MODIFY) {
				detailLowerDoc.uom_td.innerHTML		= "&nbsp;<INPUT TYPE=\"text\" NAME=\"qty_uom_desc\" size='10' maxlength='4' value='"+detailLowerDoc.qty_uom_desc.value+"' disabled><INPUT TYPE='hidden' name='qty_uom' id='qty_uom' value='"+detailLowerDoc.qty_uom.value+"'>";
			} else {*/
			detailLowerDoc.getElementById("uom_td").innerHTML		= "<INPUT TYPE='hidden' name='qty_uom' id='qty_uom' value=''><INPUT TYPE=\"text\" NAME=\"qty_uom_desc\" id=\"qty_uom_desc\" size='10' maxlength='4' value='' onBlur=\"parent.parent.parent.before_show_qty_uom_window(this,qty_uom);\"><INPUT type=\"hidden\" name=\"qty_uom_desc_temp\" id=\"qty_uom_desc_temp\" value=\"\"><INPUT  TYPE=\"button\" name=\"qty_uom_button\" id=\"qty_uom_button\" class=\"button\" value=\"?\" onClick=\"parent.parent.parent.show_qty_uom_window(qty_uom_desc,qty_uom);\"> ";
			//}
		}// else {
		//	detailLowerDoc.uom_td.innerHTML		= "&nbsp;<INPUT TYPE=\"text\" NAME=\"qty_uom_desc\" size='10' disabled value=''><INPUT TYPE='hidden' name='qty_uom' id='qty_uom' value=''>";
		//}
	} else {
		if (module_id != 'PH' || order_category != 'PH') {
			/*if (mode == MODE_MODIFY) {
				detailLowerDoc.uom_lbl_td.innerHTML = "&nbsp;";
				detailLowerDoc.uom_td.innerHTML		= "&nbsp;<input type='hidden' name='qty_uom_desc' id='qty_uom_desc' value='"+detailLowerDoc.qty_uom_desc.value+"'><INPUT TYPE='hidden' name='qty_uom' id='qty_uom' value='"+detailLowerDoc.qty_uom.value+"'>";
			} else {*/
				detailLowerForm.qty_uom_desc.value 		= "";
				detailLowerForm.qty_uom.value			= "";
				detailLowerDoc.getElementById("uom_lbl_td").innerHTML = "&nbsp;";
				//detailLowerDoc.uom_td.innerHTML		= "&nbsp;<input type='hidden' name='qty_uom_desc' id='qty_uom_desc' value=''><INPUT TYPE='hidden' name='qty_uom' id='qty_uom' value=''>  <input type='hidden' name='qty_uom_button' id='qty_uom_button' class='button' value='?' onClick=parent.parent.parent.show_qty_uom_window(qty_uom_desc,qty_uom);'> ";

				detailLowerDoc.getElementById("uom_td").innerHTML		= "<INPUT TYPE='hidden' name='qty_uom' id='qty_uom' value=''><input type=\"hidden\" name=\"qty_uom_desc\" id=\"qty_uom_desc\" value='' onBlur=\"parent.parent.parent.before_show_qty_uom_window(this,qty_uom);\"><INPUT TYPE=\"hidden\" name=\"qty_uom_desc_temp\" id=\"qty_uom_desc_temp\" value=''>  <input  type=\"hidden\" name=\"qty_uom_button\" id=\"qty_uom_button\" class=\"button\" value=\"?\" onClick=\"parent.parent.parent.show_qty_uom_window(qty_uom_desc,qty_uom);\"> ";
			//}
		}
	}
}
/*********************************show_qty_uom_window*************************/

function before_show_qty_uom_window(target,code)
{
	getHandleDetailLower();
	if(detailLowerForm!=null){
		//if(detailLowerForm.qty_uom_desc_temp.value != detailLowerForm.qty_uom_desc.value)
		if(parent.f_query_add_mod.detail.detailLower.document.getElementById("qty_uom_desc_temp").value != detailLowerForm.qty_uom_desc.value)
		{
			if(detailLowerForm.qty_uom_desc.value != "")
			 show_qty_uom_Lookupwindow(target,code);
		}
	}
}

function show_qty_uom_window(target,code){
		getHandleDetailLower();
		if(detailLowerForm!=null){
			//if(detailLowerForm.qty_uom_desc.value == ""){
				if(f_query_add_mod.detail.detailLower.document.getElementById("qty_uom_desc").value == ""){
			show_qty_uom_Lookupwindow(target,code);
			}
		}
}
async function show_qty_uom_Lookupwindow(target,qty_uom){

	getHandleDetailLower();

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	//dataNameArray[0]   = "facility_id" ;
	//dataValueArray[0]  = ""
	//dataTypeArray[0]   = STRING ;

	//var order_catalog_nature = detailLowerDoc.order_catalog_nature.value ;


	//if(order_catalog_nature == "A")
		//argumentArray[0]		 =  detailLowerDoc.sql_or_catalog_culture_test_atomic.value;

	//if(order_catalog_nature == "P")
		
		
	//argumentArray[0]	=  detailLowerForm.qty_uom_sql.value;
	argumentArray[0]   = f_query_add_mod.detail.detailLower.document.getElementById("qty_uom_sql").value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = f_query_add_mod.detail.detailLower.CODE_LINK ;
	argumentArray[7]   = f_query_add_mod.detail.detailLower.CODE_DESC ;
	retVal = await f_query_add_mod.detail.detailLower.CommonLookup( "UOM", argumentArray );
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
		//detailLowerForm.qty_uom_desc_temp.value= retVal[1];
 		f_query_add_mod.detail.detailLower.document.getElementById("qty_uom_desc_temp").value= arr[1];
 	}else{
   		target.value = "";
   		qty_uom.value = "" ;
		//detailLowerForm.qty_uom_desc_temp.value="";
   		f_query_add_mod.detail.detailLower.document.getElementById("qty_uom_desc_temp").value="";

 	}


}
/**********************in Duplicate Req tab***************************/
function chkDuplicateReq(obj){
 getHandleDetailLower();
 getHandleHeader()	  ;
 var eff_status = formObjHeader.eff_status_mod.value;
 
 if(obj.checked == true){
	 detailLowerForm.routine_chk_for_dupl_yn.disabled	= false;	
	 detailLowerForm.routine_chk_for_dupl_yn.checked	    = true;

	detailLowerForm.urgent_chk_for_dupl_yn.disabled		    = false;
	detailLowerForm.urgent_chk_for_dupl_yn.checked	    = true;

	detailLowerForm.stat_chk_for_dupl_yn.disabled		    = false;
	detailLowerForm.stat_chk_for_dupl_yn.checked	    = true;

	detailLowerForm.chk_for_dupl_status.disabled		    = false;
	if(detailLowerForm.chk_for_dupl_status.value == "")
		detailLowerForm.chk_for_dupl_status.value	    = 'A';
	detailLowerForm.check_for_dupl_level.disabled	    = false;
	//detailLowerForm.activity_type.disabled	            = false;
	if(detailLowerForm.check_for_dupl_level.value == "")
		detailLowerForm.check_for_dupl_level.value       = 'O';
	detailLowerForm.chk_for_dupl_behind_action.disabled	= false;
	detailLowerForm.chk_for_dupl_behind_period.disabled	= false;
	detailLowerForm.chk_for_dupl_behind_unit.disabled    = false;
	detailLowerForm.chk_for_dupl_ahead_action.disabled	= false;
	detailLowerForm.chk_for_dupl_ahead_period.disabled	= false;
	detailLowerForm.chk_for_dupl_ahead_unit.disabled     = false;
 }else{
	 
	detailLowerForm.routine_chk_for_dupl_yn.checked	     = false;
	detailLowerForm.urgent_chk_for_dupl_yn.checked	     = false;
	detailLowerForm.stat_chk_for_dupl_yn.checked			 = false;
	detailLowerForm.routine_chk_for_dupl_yn.disabled		 = true;
	detailLowerForm.urgent_chk_for_dupl_yn.disabled		 = true;
	detailLowerForm.stat_chk_for_dupl_yn.disabled		 = true;

    detailLowerForm.chk_for_dupl_status.selectedIndex         = 0;
    detailLowerForm.check_for_dupl_level.selectedIndex    = 0;
   // detailLowerDoc.activity_type.value	         = "";
    //chkActionType(detailLowerForm.activity_type);
	detailLowerForm.chk_for_dupl_behind_action.selectedIndex	 = 0;
	detailLowerForm.chk_for_dupl_behind_period.value	     = "";
	detailLowerForm.chk_for_dupl_behind_unit.selectedIndex    = 0;
	detailLowerForm.chk_for_dupl_ahead_action.selectedIndex	 = 0
	detailLowerForm.chk_for_dupl_ahead_period.value	     = "";
	detailLowerForm.chk_for_dupl_ahead_unit.selectedIndex     = 0;

	detailLowerForm.chk_for_dupl_status.disabled		    = true;
	detailLowerForm.check_for_dupl_level.disabled		= true;
	//detailLowerForm.activity_type.disabled				= true;
	detailLowerForm.chk_for_dupl_behind_action.disabled	= true;
	detailLowerForm.chk_for_dupl_behind_period.disabled	= true;
	detailLowerForm.chk_for_dupl_behind_unit.disabled    = true;
	detailLowerForm.chk_for_dupl_ahead_action.disabled	= true;
	detailLowerForm.chk_for_dupl_ahead_period.disabled	= true;
	detailLowerForm.chk_for_dupl_ahead_unit.disabled     = true;
	detailLowerForm.dup_reason_chk.style.display ='none';//IN024984
	detailLowerForm.dup_reason_reqd_yn.value		="";	//IN024984

 }

   if(detailLowerForm.mode.value = "2"){//if mode modify and eff sttaus is disabled
 	    if(eff_status == "D"){

			detailLowerForm.routine_chk_for_dupl_yn.disabled		 = true;
			detailLowerForm.urgent_chk_for_dupl_yn.disabled		 = true;
			detailLowerForm.stat_chk_for_dupl_yn.disabled		 = true;
			detailLowerForm.chk_for_dupl_status.disabled		    = true;
			detailLowerForm.check_for_dupl_level.disabled	= true;
			//detailLowerForm.activity_type.disabled	= true;
			detailLowerForm.chk_for_dupl_behind_action.disabled	= true;
			detailLowerForm.chk_for_dupl_behind_period.disabled	= true;
			detailLowerForm.chk_for_dupl_behind_unit.disabled    = true;
			detailLowerForm.chk_for_dupl_ahead_action.disabled	= true;
			detailLowerForm.chk_for_dupl_ahead_period.disabled	= true;
			detailLowerForm.chk_for_dupl_ahead_unit.disabled     = true;
			detailLowerForm.dup_reason_reqd_yn.disabled          = true;//IN024984
   		}
   }

}

		
/*function chkActionType(obj) {
    if (obj.value == 'A') {
        //detailLowerDoc.chk_for_dupl_activity_type_lbl_td.innerHTML = "&nbsp;Activity Type";
        //detailLowerDoc.chk_for_dupl_activity_type_td.innerHTML = "&nbsp;<input type='text' size='20' maxlength='20' onkeypress='return CheckForSpecChars(event)'  onBlur='ChangeUpperCase(this);' name='activity_type' id='activity_type' value=''>&nbsp;";
    } else //if (obj.value == 'O')
    {
        //detailLowerDoc.chk_for_dupl_activity_type_lbl_td.innerHTML = "&nbsp;";
        //detailLowerDoc.chk_for_dupl_activity_type_td.innerHTML = "&nbsp;<input type='hidden' size='20' maxlength='20' name='activity_type' id='activity_type' value=''>";
    }
}*/
/********************************************************/
function showChargeTypeApplicable(obj)
{
if (obj.checked == true) {
		detailLowerForm.bill_yn.value="Y"
		detailLowerDoc.getElementById("ChargeTypeApplicable_lbl_td").innerHTML 	= getLabel("eOR.chargetypeapplicable.label","OR");

		detailLowerDoc.getElementById("ChargeTypeApplicable_td").innerHTML		= "<select name=\"charge_type_applicable\" id=\"charge_type_applicable\"><option  value=\"S\" selected>"+getLabel('Common.single.label','Common')+"</option><option  value=\"M\">"+getLabel('eOR.Multi.label','OR')+"</option></select>";
		
	} else {
		detailLowerForm.bill_yn.value="N"		
		detailLowerForm.charge_type_applicable.value 		= "";
		detailLowerDoc.getElementById("ChargeTypeApplicable_lbl_td").innerHTML = "&nbsp;";
		detailLowerDoc.getElementById("ChargeTypeApplicable_td").innerHTML		= "&nbsp;";	
	}
}


/**********************in Others tab***************************/
function chkCompleteOnOrder(obj){
 getHandleDetailLower();
 getHandleHeader();
var order_category  = formObjHeader.order_category.value ;
 if(obj.checked == true){
	 if(order_category=="RD" ||order_category=="RX" ||order_category=="PC" ||order_category=="DS"){
		detailLowerForm.result_applicable_yn.checked		    = false;
		detailLowerForm.result_applicable_yn.value		    = "N";
		detailLowerForm.result_applicable_yn.disabled		= false;	 
		detailLowerForm.auto_report_yn_lbl.style.visibility	= "visible";	 
		detailLowerForm.auto_report_yn_id.style.visibility	= "visible";	 
	 }else{
		detailLowerForm.result_applicable_yn.checked		    = false;
		detailLowerForm.result_applicable_yn.value		    = "N";
		detailLowerForm.result_applicable_yn.disabled		= true;
		detailLowerForm.auto_report_yn_lbl.style.visibility	= "hidden";	
		detailLowerForm.auto_report_yn_id.style.visibility	= "hidden";	
	 }
		chkChart(detailLowerForm.result_applicable_yn)
 }else{
	if(detailLowerForm.result_applicable_yn_db.value == "Y")
	detailLowerForm.result_applicable_yn.disabled		= false;
	detailLowerForm.order_catalog_nature.selectedIndex		=0;
	detailLowerForm.proc_link_applicable.selectedIndex		=0;
	 if(order_category=="RD" ||order_category=="RX" ||order_category=="PC" ||order_category=="DS"){
		detailLowerForm.auto_report_yn_lbl.style.visibility	= "visible";	
		detailLowerForm.auto_report_yn_id.style.visibility	= "visible";
	 }else{
		detailLowerForm.auto_report_yn_lbl.style.visibility	= "hidden";	
		detailLowerForm.auto_report_yn_id.style.visibility	= "hidden";	 
	 }
	 
	 chkChart(detailLowerForm.result_applicable_yn);
	//detailLowerForm.ChartProceApplicable.value		= 'X';
	//detailLowerForm.proc_link_applicable.disabled		= false;

 }

}

/*******************When Chart is Chekced   Other Tab**********************/
function chkChart(Obj){
	
getHandleDetailLower();
getHandleHeader();

var order_category  = formObjHeader.order_category.value ;
	if(Obj.checked == true){
		detailLowerForm.result_applicable_yn.value="Y";
	if(detailLowerForm.complete_on_order_yn.checked==true){
		detailLowerForm.auto_report_yn_lbl.style.visibility	= "hidden";
		detailLowerForm.auto_report_yn_id.style.visibility	= "hidden";
		detailLowerForm.auto_report_yn.value				= "Y";
		detailLowerDoc.getElementById("order_catalog_nature_id").innerHTML = "<SELECT name='order_catalog_nature' id='order_catalog_nature' onChange='parent.parent.parent.chkNature(this)'> <option value='A'>"+getLabel('Common.Individual.label','COMMON')+"</option></select>";
	}
	else{
		if(order_category=="RD" ||order_category=="RX" ||order_category=="PC" ||order_category=="DS"){  
			detailLowerForm.auto_report_yn_lbl.style.visibility		= "visible";
			detailLowerForm.auto_report_yn_id.style.visibility		= "visible";
			detailLowerForm.auto_report_yn.disabled					= false;
			detailLowerForm.auto_report_yn.checked					= false;
			detailLowerForm.auto_report_yn.value						= "N";
			detailLowerDoc.getElementById("order_catalog_nature_id").innerHTML = "<SELECT name='order_catalog_nature' id='order_catalog_nature' onChange='parent.parent.parent.chkNature(this)'><option value='A'>"+getLabel('Common.Individual.label','COMMON')+"</option><option value='P'>"+getLabel('Common.Panel.label','COMMON')+"</option></select>";
		}else{
			//detailLowerForm.auto_report_yn.disabled					= false;
			detailLowerForm.auto_report_yn.checked					= false;
			detailLowerForm.auto_report_yn.value						= "N";
			
			(f_query_add_mod.detail.detailLower.document.getElementById("order_catalog_nature_id")).innerHTML = "<SELECT name='order_catalog_nature' id='order_catalog_nature' onChange='parent.parent.parent.chkNature(this)'><option value='A'>"+getLabel('Common.Individual.label','COMMON')+"</option><option value='P'>"+getLabel('Common.Panel.label','COMMON')+"</option></select>";
			//alert(f_query_add_mod.detailLowerForm.document.getElementById("auto_report_yn_lbl"));
			//detailLowerForm.auto_report_yn_lbl.style.visibility		= "hidden";
			//detailLowerForm.auto_report_yn_id.style.visibility		= "hidden";
		}
	}
	detailLowerForm.confidential_yn.disabled		            = false;    
	detailLowerForm.chart_result_type.disabled			    = false;
	(f_query_add_mod.detail.detailLower.document.getElementById("proc_coding_scheme_td")).style.display ="none";
	(f_query_add_mod.detail.detailLower.document.getElementById("discr_msr_panel_id_lbl")).style.posWidth	=208;
	detailLowerForm.discr_msr_panel_id.disabled		        = false;
	detailLowerForm.appl_button.disabled				        = false;
	detailLowerForm.result_auth_reqd_yn.disabled		        = false;
	detailLowerForm.chart_result_type.selectedIndex			=	0;
   (f_query_add_mod.detail.detailLower.document.getElementById("chrtMandatory2")).style.posWidth = 346;
    detailLowerForm.proc_link_applicable.value				='X';
    detailLowerForm.proc_link_applicable.disabled				=false;	
    

	if(order_category=="RD" ||order_category=="RX" ||order_category=="PC" ||order_category=="DS"){  if(detailLowerForm.complete_on_order_yn.checked == true){
			detailLowerForm.auto_report_yn.value				="Y";
			f_query_add_mod.detail.detailLower.document.getElementById("order_catalog_nature_id").innerHTML = "<SELECT name='order_catalog_nature' id='order_catalog_nature' onChange='parent.parent.parent.chkNature(this)'><option value='A'>"+getLabel('Common.Individual.label','COMMON')+"</option></select>";
			detailLowerDoc.getElementById("chart_result_type_td").innerHTML = "<SELECT name='chart_result_type' id='chart_result_type' onChange='parent.parent.parent.chkResultType(this);'><option value='D'>"+getLabel('Common.DiscreteMeasure.label','Common')+"</option></select>";
			detailLowerDoc.getElementById("discr_msr_panel_id_lbl").innerHTML = getLabel("Common.DiscreteMeasure.label","Common");
			detailLowerDoc.getElementById("discr_msr_panel_id_td").innerHTML = "<INPUT type='text' onfocus=javascript:blur() maxLength=30 size=23 name=discr_msr_panel_id_desc id=discr_msr_panel_id_desc><INPUT type=hidden name=discr_msr_panel_id id=discr_msr_panel_id><INPUT class=button onclick=parent.parent.parent.showApplUserWindow() type=button value=? name=appl_button>";
			detailLowerDoc.getElementById("proc_link_applicable_td").innerHTML="<SELECT name='proc_link_applicable' id='proc_link_applicable' onChange='parent.parent.parent.showProc_link_resulting_option(this)'><option value='X' >"+getLabel('Common.notapplicable.label','Common')+"</option><option value='P'>"+getLabel('eOR.AutoLink.label','OR')+"</option></SELECT>"	
		}else
			{
				//detailLowerForm.auto_report_yn.value				="N";
				if(order_category=="PC"){
						//detailLowerForm.chart_result_type_td.innerHTML = "<SELECT name='chart_result_type' id='chart_result_type' onChange='parent.parent.parent.chkResultType(this);'><option value=''>--- "+getLabel('Common.defaultSelect.label','Common')+" ---</option><option value='D'>"+getLabel('Common.DiscreteMeasure.label','Common')+"</option><option value='M'>"+getLabel('eOR.resultmatrix.label','OR')+"</option><option value='N'>"+getLabel('Common.NoteType.label','COMMON')+"</option><option value='C'>"+getLabel('eOR.Charting.label','OR')+"</option><option value='P'>"+getLabel('Common.Procedure.label','COMMON')+"</option></select></select>";
					detailLowerDoc.getElementById("chart_result_type_td").innerHTML = "<SELECT name='chart_result_type' id='chart_result_type' onChange='parent.parent.parent.chkResultType(this);'><option value=''>--- "+getLabel('Common.defaultSelect.label','Common')+" ---</option><option value='D'>"+getLabel('Common.DiscreteMeasure.label','Common')+"</option><option value='M'>"+getLabel('eOR.resultmatrix.label','OR')+"</option><option value='N'>"+getLabel('Common.NoteType.label','COMMON')+"</option><option value='C'>"+getLabel('eOR.Charting.label','OR')+"</option></select>";
				}else{
					detailLowerDoc.getElementById("chart_result_type_td").innerHTML = "<SELECT name='chart_result_type' id='chart_result_type' onChange='parent.parent.parent.chkResultType(this);'><option value=''>--- "+getLabel('Common.defaultSelect.label','Common')+" ---</option><option value='D'>"+getLabel('Common.DiscreteMeasure.label','Common')+"</option><option value='M'>"+getLabel('eOR.resultmatrix.label','OR')+"</option><option value='N'>"+getLabel('Common.NoteType.label','COMMON')+"</option><option value='C'>"+getLabel('eOR.Charting.label','OR')+"</option></select>";
				
				}
				detailLowerDoc.getElementById("discr_msr_panel_id_lbl").innerHTML = getLabel("Common.DiscreteMeasure.label","Common");
				detailLowerDoc.getElementById("discr_msr_panel_id_td").innerHTML = "<INPUT type='text' onfocus=javascript:blur() maxLength=30 size=23 name=discr_msr_panel_id_desc id=discr_msr_panel_id_desc><INPUT type=hidden name=discr_msr_panel_id id=discr_msr_panel_id><INPUT class=button onclick=parent.parent.parent.showApplUserWindow() type=button value=? name=appl_button>";
				detailLowerDoc.getElementById("proc_link_applicable_td").innerHTML="<SELECT name='proc_link_applicable' id='proc_link_applicable' onChange='parent.parent.parent.showProc_link_resulting_option(this)' ><option value='X' >"+getLabel('Common.notapplicable.label','Common')+"</option><option value='P'>"+getLabel('eOR.AutoLink.label','OR')+"</option><option value='R'>"+getLabel('eOR.manuallink.label','OR')+"</option></SELECT>"
			}
	}
			showProc_link_resulting_option(detailLowerForm.proc_link_applicable);
	//Discrete Measurte && Chart Result Type is Not Mandatory in the case of LB.RD,RX
			
	
		if((order_category != "LB" && order_category != "RD" && order_category != "RX") ||  (detailLowerForm.auto_report_yn.checked==true) || (detailLowerForm.complete_on_order_yn.checked==true) ){
			
			detailLowerDoc.getElementById("chrtMandatory2").innerHTML					="<img src='../../eCommon/images/mandatory.gif' align='center'></img>";
			detailLowerDoc.getElementById("chrtMandatory1").innerHTML					="<img src='../../eCommon/images/mandatory.gif' align='center'></img>";
		  }else{
			  detailLowerDoc.getElementById("chrtMandatory1").innerHTML					="";
			  detailLowerDoc.getElementById("chrtMandatory2").style.posWidth				=346;
			  detailLowerDoc.getElementById("chrtMandatory2").innerHTML					="";
		  
				}
		detailLowerForm.order_catalog_nature.disabled		    = false;
	}else{
		detailLowerForm.result_applicable_yn.value="N";
		if(order_category=="RD" ||order_category=="RX" ||order_category=="PC" ||order_category=="DS"){ 	
		detailLowerForm.auto_report_yn_lbl.style.visibility		= "visible";
		detailLowerForm.auto_report_yn_id.style.visibility		= "visible";
		detailLowerForm.auto_report_yn.checked					= false;
		detailLowerForm.auto_report_yn.disabled					= true;
		detailLowerForm.auto_report_yn.value						= "N";
		f_query_add_mod.detail.detailLower.document.getElementById("order_catalog_nature_id").innerHTML = "<SELECT name='order_catalog_nature' id='order_catalog_nature' onChange='parent.parent.parent.chkNature(this)'><option value='A'>"+getLabel('Common.Individual.label','COMMON')+"</option><option value='P'>"+getLabel('Common.Panel.label','COMMON')+"</option></select>";
		}else{

		detailLowerForm.auto_report_yn.checked					= false;
		//detailLowerForm.auto_report_yn.disabled					= true;
		detailLowerForm.auto_report_yn.value						= "N";
		f_query_add_mod.detail.detailLower.document.getElementById("order_catalog_nature_id").innerHTML = "<SELECT name='order_catalog_nature' id='order_catalog_nature' onChange='parent.parent.parent.chkNature(this)'><option value='A'>"+getLabel('Common.Individual.label','COMMON')+"</option><option value='P'>"+getLabel('Common.Panel.label','COMMON')+"</option></select>";
		//detailLowerForm.auto_report_yn_lbl.style.visibility		= "hidden";
		//detailLowerForm.auto_report_yn_id.style.visibility		= "hidden";
		
		detailLowerDoc.getElementById("auto_report_yn_lbl").style.visibility	= "hidden";
		detailLowerDoc.getElementById("auto_report_yn_id").style.visibility		= "hidden";
		

		}
	detailLowerForm.confidential_yn.disabled		            = true;
	detailLowerForm.confidential_yn.checked		            = false;
	if(order_category=="RD" ||order_category=="RX" ||order_category=="PC" ||order_category=="DS"){
		if(order_category=="PC"){
			
				//detailLowerForm.chart_result_type_td.innerHTML = "<SELECT name='chart_result_type' id='chart_result_type' onChange='parent.parent.parent.chkResultType(this);'><option value=''>--- "+getLabel('Common.defaultSelect.label','Common')+" ---</option><option value='D'>"+getLabel('Common.DiscreteMeasure.label','Common')+"</option><option value='M'>"+getLabel('eOR.resultmatrix.label','OR')+"</option><option value='N'>"+getLabel('Common.NoteType.label','COMMON')+"</option><option value='C'>"+getLabel('eOR.Charting.label','OR')+"</option><option value='P'>"+getLabel('Common.Procedure.label','COMMON')+"</option></select></select>";
			detailLowerDoc.getElementById("chart_result_type_td").innerHTML = "<SELECT name='chart_result_type' id='chart_result_type' onChange='parent.parent.parent.chkResultType(this);'><option value=''>--- "+getLabel('Common.defaultSelect.label','Common')+" ---</option><option value='D'>"+getLabel('Common.DiscreteMeasure.label','Common')+"</option><option value='M'>"+getLabel('eOR.resultmatrix.label','OR')+"</option><option value='N'>"+getLabel('Common.NoteType.label','COMMON')+"</option><option value='C'>"+getLabel('eOR.Charting.label','OR')+"</option></select>";
				
				}else{
					
					detailLowerDoc.getElementById("chart_result_type_td").innerHTML = "<SELECT name='chart_result_type' id='chart_result_type' onChange='parent.parent.parent.chkResultType(this);'><option value=''>--- "+getLabel('Common.defaultSelect.label','Common')+" ---</option><option value='D'>"+getLabel('Common.DiscreteMeasure.label','Common')+"</option><option value='M'>"+getLabel('eOR.resultmatrix.label','OR')+"</option><option value='N'>"+getLabel('Common.NoteType.label','COMMON')+"</option><option value='C'>"+getLabel('eOR.Charting.label','OR')+"</option></select>";
				}
	}
    detailLowerForm.order_catalog_nature.selectedIndex		=	0;
	detailLowerForm.order_catalog_nature.disabled		    = true;
	detailLowerForm.chart_result_type.selectedIndex		    =	0;
	detailLowerForm.chart_result_type.disabled		        = true;
	//detailLowerForm.proc_coding_scheme_td.style.display		="none";
	//detailLowerForm.discr_msr_panel_id_lbl.style.posWidth	=150;
	detailLowerDoc.getElementById("proc_coding_scheme_td").style.display = "none";
	detailLowerDoc.getElementById("discr_msr_panel_id_lbl").style.posWidth	= 150;		
	detailLowerDoc.getElementById("discr_msr_panel_id_lbl").innerHTML = getLabel("Common.DiscreteMeasure.label","Common");
	detailLowerDoc.getElementById("discr_msr_panel_id_td").innerHTML = "<INPUT type='text' onfocus=javascript:blur() maxLength=30 size=23 name=discr_msr_panel_id_desc id=discr_msr_panel_id_desc><INPUT type=hidden name=discr_msr_panel_id id=discr_msr_panel_id><INPUT class=button onclick=parent.parent.parent.showApplUserWindow() type=button value=? name=appl_button>";
	detailLowerForm.discr_msr_panel_id.value					= "" ;
	detailLowerForm.discr_msr_panel_id_desc.value			= "" ;
	detailLowerForm.discr_msr_panel_id.disabled	 			= true;
	detailLowerForm.appl_button.disabled		                = true;
	detailLowerForm.result_auth_reqd_yn.checked				= false;
	detailLowerForm.result_auth_reqd_yn.disabled             = true;
	detailLowerDoc.getElementById("chrtMandatory1").innerHTML					="&nbsp;";
	detailLowerDoc.getElementById("chrtMandatory2").style.posWidth			=346;
	detailLowerDoc.getElementById("chrtMandatory2").innerHTML					="&nbsp;";
	detailLowerDoc.getElementById("proc_link_applicable_td").innerHTML="<SELECT name='proc_link_applicable' id='proc_link_applicable' onChange='parent.parent.parent.showProc_link_resulting_option(this)' disabled><option value='X' >"+getLabel('Common.notapplicable.label','Common')+"</option><option value='P'>"+getLabel('eOR.AutoLink.label','OR')+"</option><option value='R'>"+getLabel('eOR.manuallink.label','OR')+"</option></SELECT>"
	//detailLowerForm.proc_link_applicable.selectedIndex		=0;		
	//detailLowerForm.proc_link_applicable.disabled			=true;		
	showProc_link_resulting_option(detailLowerForm.proc_link_applicable);
	}
}
/*********************when Nature combo is Changed ******Other Tab***********/
function chkAutoReport(obj){
	getHandleDetailLower();
	getHandleHeader();
	var order_category  = formObjHeader.order_category.value ;
	
	
	if(obj.checked == true && (detailLowerForm.complete_on_order_yn.checked==false) &&(detailLowerForm.result_applicable_yn.checked==true)){
		
			detailLowerForm.auto_report_yn.value				="Y";
			detailLowerForm.innerHTML = "<SELECT name='order_catalog_nature' id='order_catalog_nature' onChange='parent.parent.parent.chkNature(this)'> <option value='A'>"+getLabel('Common.Individual.label','COMMON')+"</option></select>";
			detailLowerDoc.getElementById("chart_result_type_td").innerHTML = "<SELECT name='chart_result_type' id='chart_result_type' onChange='parent.parent.parent.chkResultType(this);'><option value='D'>"+getLabel('Common.DiscreteMeasure.label','Common')+"</option></select>";
			detailLowerForm.proc_coding_scheme_td.style.display  ="none";
			detailLowerForm.discr_msr_panel_id_lbl.style.posWidth  =150;
			detailLowerDoc.getElementById("chrtMandatory2").innerHTML					="<img src='../../eCommon/images/mandatory.gif' align='center'></img>";
			detailLowerDoc.getElementById("chrtMandatory1").innerHTML					="<img src='../../eCommon/images/mandatory.gif' align='center'></img>";	
			detailLowerDoc.getElementById("discr_msr_panel_id_lbl").innerHTML = getLabel("Common.DiscreteMeasure.label","Common");
			detailLowerDoc.getElementById("discr_msr_panel_id_td").innerHTML = "<INPUT type='text' onfocus=javascript:blur() maxLength=30 size=23 name=discr_msr_panel_id_desc id=discr_msr_panel_id_desc><INPUT type=hidden name=discr_msr_panel_id id=discr_msr_panel_id><INPUT class=button onclick=parent.parent.parent.showApplUserWindow() type=button value=? name=appl_button>";
			detailLowerForm.chrtMandatory2.style.posWidth  =346;
			detailLowerDoc.getElementById("proc_link_applicable_td").innerHTML="<SELECT name='proc_link_applicable' id='proc_link_applicable' onChange='parent.parent.parent.showProc_link_resulting_option(this)'><option value='X' >"+getLabel('Common.notapplicable.label','Common')+"</option><option value='P'>"+getLabel('eOR.AutoLink.label','OR')+"</option></SELECT>"			
	
		
	}else{
	if (detailLowerForm.auto_report_yn.checked==true){
		detailLowerForm.auto_report_yn.value						="Y";
	}else{
		detailLowerForm.auto_report_yn.value						="N";
		/*
		if(detailLowerForm.result_applicable_yn.checked==true)
		{
			detailLowerForm.innerHTML = "<SELECT name='order_catalog_nature' id='order_catalog_nature' onChange='parent.parent.parent.chkNature(this)'><option value='A'>"+getLabel('Common.Individual.label','COMMON')+"</option><option value='P'>"+getLabel('Common.Panel.label','COMMON')+"</option></select>";
		}
		*/
	}
	if(((order_category != "LB" && order_category != "RD" && order_category != "RX") &&(detailLowerForm.result_applicable_yn?.checked==true)) || ((detailLowerForm.result_applicable_yn?.checked==true) && (detailLowerForm.auto_report_yn.value=="Y")) )
	{
		detailLowerDoc.getElementById("chrtMandatory2").innerHTML	 ="<img src='../../eCommon/images/mandatory.gif' align='center'></img>";
		detailLowerDoc.getElementById("chrtMandatory1").innerHTML	 ="<img src='../../eCommon/images/mandatory.gif' align='center'></img>";
	}else{
		detailLowerDoc.getElementById("chrtMandatory1").innerHTML	="";		
		detailLowerDoc.getElementById("chrtMandatory2").style.posWidth			=346;
		detailLowerDoc.getElementById("chrtMandatory2").innerHTML					="";
	}

	chkNature(detailLowerForm.order_catalog_nature);
	}
	showProc_link_resulting_option(detailLowerForm.proc_link_applicable);


}
/*********************when Nature combo is Changed ******Other Tab***********/
function chkNature(obj){
getHandleDetailLower();	

detailLowerForm.discr_msr_panel_id.value = "" ;
var order_category=detailLowerForm.order_category.value;	
	if(obj.value == "P") {
		detailLowerForm.discr_msr_panel_id.disabled		    = false;
			
		if (order_category== 'LB') {
			var disableFlag	= "";
				if (detailLowerForm.chart_result_type.disabled == true) {
				disableFlag = "disabled";
			}	
		}
			if(((order_category=="RD" ||order_category=="RX" ||order_category=="PC" ||order_category=="DS")&&(detailLowerForm.complete_on_order_yn.checked == true)) || (detailLowerForm.result_applicable_yn.checked == true && detailLowerForm.auto_report_yn.checked==true)){
				detailLowerForm.auto_report_yn.value				="Y";
				
				detailLowerDoc.getElementById("chart_result_type_td").innerHTML = "<SELECT name='chart_result_type' id='chart_result_type' onChange='parent.parent.parent.chkResultType(this);' "+disableFlag+"><option value='D'>"+getLabel('Common.DiscreteMeasure.label','Common')+"</option></select>";
			}else{
				
				detailLowerDoc.getElementById("chart_result_type_td").innerHTML = "<SELECT name='chart_result_type' id='chart_result_type' onChange='parent.parent.parent.chkResultType(this);' "+disableFlag+"><option value=''>--- "+getLabel('Common.defaultSelect.label','Common')+" ---</option><option value='D'>"+getLabel('Common.DiscreteMeasure.label','Common')+"</option></select>";
			}
			
			chkResultType(detailLowerForm.chart_result_type);			
			
		/* // check this if funtionality problem
		if (detailLowerForm.chart_result_type.value == 'P') {

			//detailLowerForm.chart_result_type.value = "";
			detailLowerForm.discr_msr_panel_id_lbl.innerHTML = "&nbsp;Discrete Measure";
			detailLowerForm.discr_msr_panel_id_td.innerHTML = "&nbsp;&nbsp;<INPUT type='text' onfocus=javascript:blur() maxLength=10 size=10 name=discr_msr_panel_id_desc>&nbsp;<INPUT type=hidden name=discr_msr_panel_id><INPUT class=button onclick=parent.parent.parent.showApplUserWindow() type=button value=? name=appl_button>";
		}*/

			detailLowerDoc.getElementById("proc_link_applicable_td").innerHTML="<SELECT name='proc_link_applicable' id='proc_link_applicable'><option value='X'>"+getLabel('Common.notapplicable.label','Common')+"</option></SELECT>"
		showProc_link_resulting_option(detailLowerForm.proc_link_applicable);
}else {
		
		detailLowerForm.discr_msr_panel_id.disabled		    = true;
		if (order_category == 'LB') {
	
			var disableFlag	= "";
			
			if (detailLowerForm.chart_result_type.disabled == true) {
				
				disableFlag = "disabled";
			}
		}
		
		 if(((order_category=="RD" ||order_category=="RX" ||order_category=="PC" ||order_category=="DS")&&(detailLowerForm.complete_on_order_yn.checked == true)) ||  (detailLowerForm.result_applicable_yn.checked == true && detailLowerForm.auto_report_yn.checked==true))
		{
				detailLowerForm.auto_report_yn.value				="Y";
				detailLowerDoc.getElementById("chart_result_type_td").innerHTML = "<SELECT name='chart_result_type' id='chart_result_type' onChange='parent.parent.parent.chkResultType(this);' "+disableFlag+"><option value='D'>"+getLabel('Common.DiscreteMeasure.label','Common')+"</option></select>";
		}else if (order_category == 'TR' || order_category == 'PC' ||order_category == 'OT') 
		{	
			var result_applicable_yn_checked=detailLowerForm.result_applicable_yn.checked;
			if (result_applicable_yn_checked == false) 
			{
				disableFlag = "disabled";
			}
			else
			{
				disableFlag = "";
			}

			//detailLowerForm.chart_result_type_td.innerHTML = "<SELECT name='chart_result_type' id='chart_result_type' onChange='parent.parent.parent.chkResultType(this);' "+disableFlag+"><option value=''>--- "+getLabel('Common.defaultSelect.label','Common')+" ---</option><option value='D'>"+getLabel('Common.DiscreteMeasure.label','Common')+"</option><option value='M'>"+getLabel('eOR.resultmatrix.label','OR')+"</option><option value='N'>"+getLabel('Common.note.label','Common')+"</option><option value='C'>"+getLabel('eOR.Charting.label','OR')+"</option><option value='P'>"+getLabel('Common.Procedure.label','COMMON')+"</option></select>";
			if(order_category == 'PC')
			{
				detailLowerDoc.getElementById("chart_result_type_td").innerHTML = "<SELECT name='chart_result_type' id='chart_result_type' onChange='parent.parent.parent.chkResultType(this);' "+disableFlag+"><option value=''>--- "+getLabel('Common.defaultSelect.label','Common')+" ---</option><option value='D'>"+getLabel('Common.DiscreteMeasure.label','Common')+"</option><option value='M'>"+getLabel('eOR.resultmatrix.label','OR')+"</option><option value='N'>"+getLabel('Common.note.label','Common')+"</option><option value='C'>"+getLabel('eOR.Charting.label','OR')+"</option></select>";
			}
			else
			{
				detailLowerDoc.getElementById("chart_result_type_td").innerHTML = "<SELECT name='chart_result_type' id='chart_result_type' onChange='parent.parent.parent.chkResultType(this);' "+disableFlag+"><option value=''>--- "+getLabel('Common.defaultSelect.label','Common')+" ---</option><option value='D'>"+getLabel('Common.DiscreteMeasure.label','Common')+"</option><option value='M'>"+getLabel('eOR.resultmatrix.label','OR')+"</option><option value='N'>"+getLabel('Common.note.label','Common')+"</option><option value='C'>"+getLabel('eOR.Charting.label','OR')+"</option><option value='P'>"+getLabel('Common.Procedure.label','COMMON')+"</option></select>";
			}
		}else{
			detailLowerDoc.getElementById("chart_result_type_td").innerHTML = "<SELECT name='chart_result_type' id='chart_result_type' onChange='parent.parent.parent.chkResultType(this);' "+disableFlag+"><option value=''>--- "+getLabel('Common.defaultSelect.label','Common')+" ---</option><option value='D'>"+getLabel('Common.DiscreteMeasure.label','Common')+"</option><option value='M'>"+getLabel('eOR.resultmatrix.label','OR')+"</option><option value='N'>"+getLabel('Common.note.label','Common')+"</option><option value='C'>"+getLabel('eOR.Charting.label','OR')+"</option></select>";
			chkResultType(detailLowerForm.chart_result_type);
		}
			if(((order_category=="RD" ||order_category=="RX" ||order_category=="PC" ||order_category=="DS")&&(detailLowerForm.complete_on_order_yn.checked == true)) || (detailLowerForm.result_applicable_yn.checked == true && detailLowerForm.auto_report_yn.checked==true)){
				detailLowerDoc.getElementById("proc_link_applicable_td").innerHTML="<SELECT name='proc_link_applicable' id='proc_link_applicable' onChange='parent.parent.parent.showProc_link_resulting_option(this)'  "+disableFlag+"><option value='X' >"+getLabel('Common.notapplicable.label','Common')+"</option><option value='P'>"+getLabel('eOR.AutoLink.label','OR')+"</option></SELECT>"
			}else {
				detailLowerDoc.getElementById("proc_link_applicable_td").innerHTML="<SELECT name='proc_link_applicable' id='proc_link_applicable' onChange='parent.parent.parent.showProc_link_resulting_option(this);'  "+disableFlag+"><option value='X'>"+getLabel('Common.notapplicable.label','Common')+"</option><option value='P'>"+getLabel('eOR.AutoLink.label','OR')+"</option><option value='R'>"+getLabel('eOR.manuallink.label','OR')+"</option></SELECT>"
			}
			showProc_link_resulting_option(detailLowerForm.proc_link_applicable);
	
	}
}
/*********************Discrete Measurte Look Up*******Other Tab**************/
//function showApplUserWindow(target,discr_msr_panel_id){
async function showApplUserWindow(){

getHandleDetailLower();
	getHandleHeader();

var argumentArray  = new Array() ;
var dataNameArray  = new Array() ;
var dataValueArray = new Array() ;
var dataTypeArray  = new Array() ;

//dataNameArray[0]   = "facility_id" ;
//dataValueArray[0]  = ""
//dataTypeArray[0]   = STRING ;

var order_catalog_nature = detailLowerForm.order_catalog_nature.value ;
var order_category  = formObjHeader.order_category.value ;

if((order_category=="RD" ||order_category=="RX" ||order_category=="PC" ||order_category=="DS") && (detailLowerForm.complete_on_order_yn.checked == true) && (detailLowerForm.result_applicable_yn.checked == true)){
	
	argumentArray[0]		 =  detailLowerForm.sql_or_catalog_discrete_auto_report_yn.value;
}else{

if(order_catalog_nature == "A")
argumentArray[0]		 =  detailLowerForm.sql_or_catalog_discrete_atomic.value;

if(order_catalog_nature == "P")
argumentArray[0]		 =  detailLowerForm.sql_or_catalog_discrete_profile.value;


}

argumentArray[1]   = dataNameArray ;
argumentArray[2]   = dataValueArray ;
argumentArray[3]   = dataTypeArray ;
argumentArray[4]   = "1,2";
//argumentArray[5]   = target.value ;
argumentArray[5]   = "" ;
argumentArray[6]   = f_query_add_mod.detail.detailLower.CODE_LINK ;
argumentArray[7]   = f_query_add_mod.detail.detailLower.CODE_DESC ;


//retVal = f_query_add_mod.detail.detailLower.CommonLookup( "Discrete Measure", argumentArray );

retVal = await CommonLookup(getLabel("Common.DiscreteMeasure.label","Common"),argumentArray );
var ret1=unescape(retVal);
var arr=ret1.split(",");
		if(arr[1]==undefined) 
		{
			arr[0]="";	
			arr[1]="";	
		}


 if(retVal != null && retVal != ""){
   //target.value = retVal[1];
   //discr_msr_panel_id.value =retVal[0] ;
       //detailLowerForm.discr_msr_panel_id.value=retVal[0];
	  detailLowerForm['discr_msr_panel_id'].value=arr[0];
	   //detailLowerForm.discr_msr_panel_id_desc.value=retVal[1];
	  detailLowerForm['discr_msr_panel_id_desc'].value=arr[1];

 }/*else{
   target.value = "";
   discr_msr_panel_id.value = "" ;
 }*/


}

/*********************Culture Test Look Up*******Other Tab**************/
async function showCultureTestWindow(target,discr_msr_panel_id){
	getHandleDetailLower()

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	//dataNameArray[0]   = "facility_id" ;
	//dataValueArray[0]  = ""
	//dataTypeArray[0]   = STRING ;

	var order_catalog_nature = detailLowerForm.order_catalog_nature.value ;


	if(order_catalog_nature == "A")
		argumentArray[0]		 =  detailLowerForm.sql_or_catalog_culture_test_atomic.value;

	if(order_catalog_nature == "P")
		argumentArray[0]		 =  detailLowerForm.sql_or_catalog_discrete_profile.value;


	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = f_query_add_mod.detail.detailLower.CODE_LINK ;
	argumentArray[7]   = f_query_add_mod.detail.detailLower.CODE_DESC ;

	retVal =await f_query_add_mod.detail.detailLower.CommonLookup( getLabel("Common.DiscreteMeasure.label","Common"), argumentArray );
	var ret1=unescape(retVal);
	 var arr=ret1.split(",");
		if(arr[1]==undefined) 
		{
			arr[0]="";	
			arr[1]="";	
		}
   if(retVal != null && retVal != ""){
   		target.value = arr[1];
 		discr_msr_panel_id.value =arr[0] ;
 	}else{
   		target.value = "";
   		discr_msr_panel_id.value = "" ;
 	}
}

/***Function of detailFrameLower(OtherSetUpDetailForm Page)  ENDS *******/

/*******FUNCTION of detail UPPER -Validation for =>OrderCatalogAddModifyReviewsDetial STARTS*******/


/*****************************REVIEW TAGS***********************************/

function chkApplicability(obj,index){


getHandleDetailUpper();
var obj_ord_auth_reqd_yn     = eval("detailUpperForm.ord_auth_reqd_yn"+index);
var obj_ord_cosign_reqd_yn	 = eval("detailUpperForm.ord_cosign_reqd_yn"+index);
var ord_spl_appr_reqd_yn	 = eval("detailUpperForm.ord_spl_appr_reqd_yn"+index);
	var obj_ord_skip_auth		 = eval("detailUpperForm.skip_auth"+index); //IN048467


 if(obj.value == "A"){
		obj_ord_auth_reqd_yn.disabled	    = false;

	if(obj_ord_cosign_reqd_yn != undefined)
		obj_ord_cosign_reqd_yn.disabled	= false;

	 if(ord_spl_appr_reqd_yn != undefined)
		ord_spl_appr_reqd_yn.disabled	= false;

 }else{
		obj_ord_auth_reqd_yn.checked		= false;
		obj_ord_auth_reqd_yn.disabled	    = true;
			obj_ord_skip_auth.disabled 			= true; //IN048467
			obj_ord_skip_auth.selectedIndex		= 0; //IN048467
		if(obj_ord_cosign_reqd_yn != undefined){
			obj_ord_cosign_reqd_yn.checked		= false;
			obj_ord_cosign_reqd_yn.disabled		= true;
		}


		if(ord_spl_appr_reqd_yn != undefined){
			ord_spl_appr_reqd_yn.checked		= false;
			ord_spl_appr_reqd_yn.disabled		= true;
		}
 }

}

/********************SETTING TABS****************************/
function chkApplSetting(obj,index,order_category){

getHandleDetailUpper();
var qty_value					  = eval("detailUpperForm.qty_value"+index);
var qty_uom						  = eval("detailUpperForm.qty_uom"+index);
var age_group_code				  = eval("detailUpperForm.age_group_code"+index);
var freq_code					  = eval("detailUpperForm.freq_code"+index);
//var durn_type_td				  = eval("detailUpperForm.durn_type_td"+index);
var durn_type					  = eval("detailUpperForm.durn_type"+index);
//var durn_type_td				  = eval("detailUpperDoc.durn_type_td"+index);
var durn_value					  = eval("detailUpperForm.durn_value"+index);
var durn_desc					  = eval("detailUpperForm.durn_desc"+index);
var max_durn_type				  = eval("detailUpperForm.max_durn_type"+index);
var max_durn_value				  = eval("detailUpperForm.max_durn_value"+index);
var chk_for_max_durn_action       = eval("detailUpperForm.chk_for_max_durn_action"+index);
var prompt_msg					  = eval("detailUpperForm.prompt_msg"+index);
var ord_auth_level				  = eval("detailUpperForm.ord_auth_level"+index);

var soft_stop_yn				  = detailUpperForm.soft_stop_yn.value ;
var qty_reqd_yn					  = detailUpperForm.qty_reqd_yn.value ;
var freq_applicable_yn			  = detailUpperForm.freq_applicable_yn.value ;
var module_id					  = detailUpperForm.module_id.value ;

 if(obj.value == "A"){
		if(qty_reqd_yn == "Y"){
		   qty_value.disabled				= false;
		   if (module_id == 'PH' || order_category == 'PH') {
		   	qty_uom.disabled					= false;
		   } else {
		   	qty_uom.disabled					= true;
		   }
		}
         age_group_code.disabled            = false;
		 freq_code.disabled					= false;


	/*	if(freq_applicable_yn == "Y"){ //Commend as per change
		   freq_code.disabled				= false;
	//	   max_durn_type.disabled			= false;
	//	   max_durn_value.disabled			= false;
		   chk_for_max_durn_action.disabled	= false;
		}
  */

 //    max_durn_type.disabled					= false;
//	   max_durn_value.disabled				= false;

 }else{
		   qty_value.disabled						= true;
		   qty_uom.disabled						    = true;

		   //if(module_id != "PH")
		   qty_uom.value							= "";

		   age_group_code.disabled				    = true;
		   age_group_code.selectedIndex				= 0;

           freq_code.disabled					    = true;
		   freq_code.selectedIndex					= 0;

		   max_durn_value.disabled				    = true;
		   max_durn_value.value						= "";

		   max_durn_type.disabled					= true;
		   max_durn_type.selectedIndex				= 0;

		   chk_for_max_durn_action.disabled			= true;
		   chk_for_max_durn_action.selectedIndex	= 0;

		   ord_auth_level.disabled					= true;
		   ord_auth_level.value						= "";

		   durn_value.value							= "";
		   durn_value.disabled					    = true;

		   durn_desc.value							= "";
		   durn_type.value							= "";

		   prompt_msg.value							= "";


 }

}
/*********************************************************************/
async function showMsgDialog(index) {

	var dialogHeight ='20vh' ;
	var dialogWidth = '35vw' ;
	var dialogTop	= '0vh';
	var dialogLeft = '0vw' ;

	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

	var arguments = "";

	getHandleDetailUpper();
	var currMsgTxtObj     = eval("detailUpperForm.prompt_msg"+index);
	var currMaxValObj     = eval("detailUpperForm.max_durn_value"+index);
	var msg_val = currMsgTxtObj.value;
	while((msg_val).indexOf("\r\n") != -1){
		msg_val = msg_val.replace("\r\n", " ");
	}	
	
	var currMsgTxt		  =	(currMsgTxtObj.value);

	/*IF Max is entered than only msg is allowed **********/
	if(currMaxValObj.value == ""){  //new req march 28/03/2003
		return ;
	}

	var retVals = await window.showModalDialog("../../eOR/jsp/OrderCatlogSettingsModal.jsp?currMsgTxt="+encodeURIComponent(msg_val)+"&"+qry_str,arguments,features);

	if(retVals != ""){
	 	currMsgTxtObj.value	 =  trimString(retVals);
		//currMsgTxtObj.value = makeValidString(retVals);
	}
}

/**********************chkAction***********************************/
function chkAction(obj,index){
	getHandleDetailUpper();
	var obj_ord_auth_level     = eval("detailUpperForm.ord_auth_level"+index);
	var prompt_msg			   = eval("detailUpperForm.prompt_msg"+index);
	var msg_td				   = eval(detailUpperDoc.getElementById("msg_td"+index));
	prompt_msg.value = "";
	
	if(obj.value==""){
		msg_td.innerHTML="&nbsp";	
	}else{
		msg_td.innerHTML="&nbsp;&nbsp;<A name='msg"+index+"' HREF='javascript:parent.parent.parent.showMsgDialog(\""+index+"\")'>"+getLabel('eOR.Msg.label','OR')+"</A>";	
	}	
	
	if(obj.value == "A"){
		obj_ord_auth_level.disabled			= false;	
	 }else{
		obj_ord_auth_level.disabled			= true;
		obj_ord_auth_level.value			= "";
	 }

}
/*************SET MAX DURN TYPE on entry of max value****************/
function chkEnteredMaxVal(obj,index){
getHandleDetailUpper();

var max_durn_type					 = eval("detailUpperForm.max_durn_type"+index);
var durn_type						 = eval("detailUpperForm.durn_type"+index);
var chk_for_max_durn_action		     = eval("detailUpperForm.chk_for_max_durn_action"+index);
var prompt_msg						 = eval("detailUpperForm.prompt_msg"+index);

max_durn_type.disabled = true;

if(obj.value == ""  ){
	 max_durn_type.selectedIndex = 0 ;
	 chk_for_max_durn_action.selectedIndex = 0 ;
	 chk_for_max_durn_action.disabled		 = true;
	 prompt_msg.value = "";
	 return ;
}

chk_for_max_durn_action.disabled			=  false;
max_durn_type.value	=	durn_type.value;
/* Commented by Uma on 6/12/2009 for IN011397
if(durn_type.value == 'W'){
	max_durn_type.selectedIndex	=	4;
}

if(durn_type.value == 'H'){
	max_durn_type.selectedIndex	=	2 ;
}


if(durn_type.value == 'D'){
	max_durn_type.selectedIndex	=	3
}

if(durn_type.value == 'M'){
	max_durn_type.selectedIndex =	1;
}


if(durn_type.value == 'L'){
	max_durn_type.selectedIndex	=	5;
}
*/
chkMaxDurn(index,obj)	; //Chk Max durn versus durn entered


}
/************************Chk Athu Level***********************/
function chkSecurityLevel(obj){
getHandleDetailUpper();
getHandleHeader();
var security_level  =  formObjHeader.security_level.value ;

if(obj.value == "" )
	return ;

if(security_level == "" || security_level ==null)
	return ;

 if(parseFloat(security_level) > parseFloat(obj.value)){
	 alert(getMessage("CATALOG_AUTH_CHECK","OR"));
	 obj.focus();
 }

}
/******************************************************************/
function getDurnType(obj,index){
getHandleDetailUpper();
getHandleHeader();

var freq_code = "";
var  xmlAppend = "";

//var durn_type_td				  = eval("detailUpperDoc.durn_type_td"+index);
var durn_type					  = eval("detailUpperForm.durn_type"+index);
var durn_value					  = eval("detailUpperForm.durn_value"+index);
var durn_desc					  = eval("detailUpperForm.durn_desc"+index);
var max_durn_type				  = eval("detailUpperForm.max_durn_type"+index);
var max_durn_value				  = eval("detailUpperForm.max_durn_value"+index);
var chk_for_max_durn_action       = eval("detailUpperForm.chk_for_max_durn_action"+index);


var bean_id			= formObjHeader.bean_id ;
var localeName		= f_query_add_mod.header.document.header.localeName.value ;
var module_id		= detailUpperForm.module_id.value ;

if(	module_id != "PH"){//Not Applicable for Pharamacy
	max_durn_type.selectedIndex		= 0;  //reset on change of the freq
	max_durn_value.value			=""; //reset on change of the freq
}

	if(obj.value == "" )
		{
//		   durn_type_td.innerHTML = "&nbsp;";
		   durn_type.value					= "" ;
   		   durn_value.value					= "" ;
   		   durn_desc.value					= "" ;
		   durn_value.disabled				=  true;
		   max_durn_type.disabled			=  true; //when freq is selected in null disabled the feild
		   max_durn_type.selectedIndex      =   0;
		   max_durn_value.disabled			=  true; //when freq is selected in null disabled the feild
   		   max_durn_value.value				=	"";
   		   chk_for_max_durn_action.selectedIndex	= 0;
		   chk_for_max_durn_action.disabled	=  true; //when freq is selected in null disabled the feild
		   return ;
		}else{
		freq_code = obj.value ;
		xmlAppend += "freq_code"+"=\""+ freq_code+"\" " ;
		xmlAppend += "index"+"=\""+ index+"\" " ;
		xmlAppend += "type"+"=\"freq_code\"" ;

		if(	module_id != "PH"){//Not Applicable for Pharamacy
	        max_durn_value.disabled		     	=  false; //when freq is selected in not null Enable the feild
		}

		if(module_id == "PH"){
				 if(max_durn_value.value == "") //i:e no value passed from  ph module
					     max_durn_value.disabled		     	=  false;
		}


		durn_value.disabled				 	=  false;
  }





	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;



	xmlStr ="<root><SEARCH " ;
	xmlStr =xmlStr + xmlAppend ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderCatalogComboFill.jsp?bean_id="+bean_id.value+"&localeName="+localeName,false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;

	eval(responseText ) ;

}
/***********************************************************************************/
function addDurnObject(durn_type,durn_value,durn_desc,index){
	getHandleDetailUpper();
	//var durn_type_td			       = eval("detailUpperDoc.durn_type_td"+index); //changed as on 24/March
	var durn_type_Obj				   = eval("detailUpperForm.durn_type"+index);
	var durn_value_Obj				   = eval("detailUpperForm.durn_value"+index);
	var durn_desc_Obj				   = eval("detailUpperForm.durn_desc"+index);
	var max_durn_value_Obj			   = eval("detailUpperForm.max_durn_value"+index);
	
	//durn_type_td.innerHTML = "<b>" + durn_value + "/" + durn_desc ; //changed as on 24/March
	durn_type_Obj.value	= durn_type ;
	durn_desc_Obj.value	= durn_desc
	if(durn_type==""){
		durn_value_Obj.disabled= true ;
		max_durn_value_Obj.disabled= true ;
	}
}
/*****************MAX AND Durn Value check *****************/
function chkMaxDurn(index,obj){
	getHandleDetailUpper();
	var max_durn_value_Obj = eval("detailUpperForm.max_durn_value"+index);
	var durn_value_Obj = eval("detailUpperForm.durn_value"+index)	 ;
	
	
	if(max_durn_value_Obj.value == "" || durn_value_Obj.value == "" )
		return ;
	else{
		if(parseFloat(max_durn_value_Obj.value) < parseFloat(durn_value_Obj.value)){
				alert(getMessage("MAX_DURN_MAND_CHK","OR"));
				obj.value = "";
				obj.focus();
				obj.select();
		}
	}
}


/*********************INSTRUCTION TABS**************************************/
function chkPrompt(obj){
	getHandleDetailUpper();

	if(obj.checked == true){
		detailUpperDoc.detailUpperForm.prompt_alert_msg.disabled = false;
	}else{
		detailUpperDoc.detailUpperForm.prompt_alert_msg.value = "";
		detailUpperDoc.detailUpperForm.prompt_alert_msg.disabled	= true;
	}
}
/*function chktmp()
{
	getHandleDetailUpper();
	var tmp;
	tmp=detailUpperDoc.check.value;
	alert(tmp);
}*/
/**************************************************************************/
function chkApptReq(obj){
	getHandleDetailUpper();

	if(obj.checked == true){
		detailUpperDoc.detailUpperForm.appt_time.disabled = false;
	}else{
	   //detailUpperDoc.appt_time.value		        = "";
	   detailUpperDoc.detailUpperForm.appt_time.disabled = true;
	}
}

/**************************************************************************/
function chkConsentReq(obj){
getHandleDetailLower();

if(obj.checked == true){
	detailLowerForm.consent_form_id.disabled			    = false;
	detailLowerForm.consent_stage.disabled			    = false;
	detailLowerForm.consent_form_list.disabled		    = false;
	detailLowerForm.multiple_consent_yn.disabled		    = false;
	detailLowerForm.num_of_consent_req_bo.value			= "1";
	detailLowerForm.num_of_consent_req_bo.disabled		= true;
	detailLowerForm.num_of_consent_req_br.value			= "0";
	detailLowerForm.num_of_consent_req_br.disabled		= true;
 }else{
   detailLowerForm.consent_form_id.selectedIndex			= 0;
   detailLowerForm.consent_form_id.disabled		        = true;
   detailLowerForm.consent_stage.selectedIndex			= 0;
   detailLowerForm.consent_stage.disabled		        = true;
   detailLowerForm.consent_form_list.selectedIndex		= 0;
	detailLowerForm.consent_form_list.disabled		    = true;
	detailLowerForm.multiple_consent_yn.checked			= false;
	detailLowerForm.multiple_consent_yn.disabled		    = true;
	detailLowerForm.num_of_consent_req_bo.value			= "0";
	detailLowerForm.num_of_consent_req_bo.disabled		= true;
	detailLowerForm.num_of_consent_req_br.value			= "0";
	detailLowerForm.num_of_consent_req_br.disabled		= true;
 }

}

function enableMultiConsent(obj){
	getHandleDetailLower();
	
	if(obj.checked == true){
		detailLowerForm.consent_stage.selectedIndex		= 0;
		detailLowerForm.consent_stage.disabled		    = true;
		detailLowerForm.consent_form_id.selectedIndex	= 0;
		detailLowerForm.consent_form_id.disabled			= true;
		detailLowerForm.num_of_consent_req_bo.disabled	= false;
	    detailLowerForm.num_of_consent_req_br.disabled	= false;
		detailLowerForm.num_of_consent_req_bo.value		= "1";
		detailLowerForm.num_of_consent_req_br.value		= "0";
		
	 }else{
		detailLowerForm.consent_stage.selectedIndex		= 0;
		detailLowerForm.consent_form_id.selectedIndex	= 0;
		detailLowerForm.num_of_consent_req_bo.value		= "1";
		detailLowerForm.num_of_consent_req_bo.disabled	= true;
		detailLowerForm.num_of_consent_req_br.value		= "0";
		detailLowerForm.num_of_consent_req_br.disabled	= true;
		detailLowerForm.consent_stage.disabled			= false;
		if(detailLowerForm.consent_form_list.value=="V")
		{
			detailLowerForm.consent_form_id.selectedIndex	= 0;
			detailLowerForm.consent_form_id.disabled			= true;
		}
		else
		{
			detailLowerForm.consent_form_id.disabled		    = false;
		}
	 }

}
/**************************************************************************/
async function showDialogInstruction(obj) {
	
	var dialogHeight ="31vh" ;
	var dialogWidth = '35vw' ;
	var dialogTop	= '0vh'; 
	var dialogLeft = '0vw' ;

	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

	var arguments = "";

	getHandleDetailUpper();

	var currMsgTxtObj     = "";
	var currMsgTxt		  =	"";
	var retVals			  = "";
	
	if(detailUpperDoc.detailUpperForm.pat_preps_or_instrns_id[0].checked == true){
		await window.showModalDialog("../../eOR/jsp/OrderCatlogInstructionsModalStandard.jsp?mode=1&currMsgTxt="+currMsgTxt,arguments,features);
	}
	if(detailUpperDoc.detailUpperForm.pat_preps_or_instrns_id[1].checked == true){
		dialogHeight ='58vh' ;
		dialogWidth = '50vw' ;
		dialogTop	= '0vh' ;
		dialogLeft = '0vw' ;
		features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';
		await window.showModalDialog("../../eOR/jsp/OrderCatlogInstructionsModalByAgeSex.jsp?mode=1&currMsgTxt="+currMsgTxt,arguments,features);
	}
}


/******************Check Valid time*************************************/
function timeChk(time1){

var time = time1.value;
var	retFlag = true ;

if(time == "" || time ==null) return ;

getHandleDetailUpper();

if(!(f_query_add_mod.detail.detailUpper.chkTime(time)))
retFlag = false;


if(!retFlag){
	time1.value="";
	time1.focus();
}

var message  = getMessage("INVALID_TIME_FMT","OR");

if(!retFlag)	{
messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
return false ;
}else{
messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
}


}

function quantityCheck(obj) {
	if (!OrIsValidDecimal(obj)) {
		if (obj.value == 0) {
			obj.focus();
			alert(getMessage('QTY_CANNOT_BE_BLANK','OR'));
			return false;
		}
	}
}

function checkValid(obj,event,val1,val2) {
	if (event.keyCode == 13) {
 		event.keyCode = "";
 		return;
 	} else {
 		return allowValidNumber(obj,event,val1,val2);
 	}
} 

function chkResultType(obj) {

	if(getHandleDetailLower()) {
		
		if (obj.value == '' || obj.value == 'D') {
			//if (detailLowerForm.order_catalog_nature.value == 'A'){
			if (f_query_add_mod.detail.detailLower.document.getElementById("order_catalog_nature_id").value == 'A'){
				//detailLowerForm.discr_msr_panel_id_lbl.innerHTML = getLabel("Common.DiscreteMeasure.label","Common");
			f_query_add_mod.detail.detailLower.document.getElementById("discr_msr_panel_id_lbl").innerHTML = getLabel("Common.DiscreteMeasure.label","Common");
			//detailLowerForm.proc_coding_scheme_td.style.display  ="none";
			f_query_add_mod.detail.detailLower.document.getElementById("proc_coding_scheme_td").style.display  ="none";
			//detailLowerForm.discr_msr_panel_id_lbl.style.posWidth  =150;
			f_query_add_mod.detail.detailLower.document.getElementById("discr_msr_panel_id_lbl").style.posWidth  =150;
			//detailLowerForm.discr_msr_panel_id_td.innerHTML = "<INPUT type='text' onfocus=javascript:blur() maxLength=30 size=23 name=discr_msr_panel_id_desc><INPUT type=hidden name=discr_msr_panel_id><INPUT class=button onclick=parent.parent.parent.showApplUserWindow() type=button value=? name=appl_button>";
			f_query_add_mod.detail.detailLower.document.getElementById("discr_msr_panel_id_td").innerHTML = "<INPUT type='text' onfocus=javascript:blur() maxLength=30 size=23 name=discr_msr_panel_id_desc id=discr_msr_panel_id_desc><INPUT type=hidden name=discr_msr_panel_id id=discr_msr_panel_id><INPUT class=button onclick=parent.parent.parent.showApplUserWindow() type=button value=? name=appl_button>";
			//detailLowerForm.chrtMandatory2.style.posWidth  =346;
			f_query_add_mod.detail.detailLower.document.getElementById("chrtMandatory2").style.posWidth  =346;
			//if(((detailLowerForm.order_category.value=="RD" ||detailLowerForm.order_category.value=="RX" ||detailLowerForm.order_category.value=="PC" ||detailLowerForm.order_category.value=="DS")&&(detailLowerForm.complete_on_order_yn.checked == true)) || (detailLowerForm.result_applicable_yn.checked == true && detailLowerForm.auto_report_yn.checked==true)){
		 if(((f_query_add_mod.header.document.getElementById("order_category").value=="RD" ||f_query_add_mod.header.document.getElementById("order_category").value=="RX" ||f_query_add_mod.header.document.getElementById("order_category").value=="PC" ||f_query_add_mod.header.document.getElementById("order_category").value=="DS")&&(f_query_add_mod.detail.detailLower.document.getElementById("complete_on_order_yn").checked == true)) || (f_query_add_mod.detail.detailLower.document.getElementById("result_applicable_yn").checked == true && f_query_add_mod.detail.detailLower.document.getElementById("auto_report_yn").checked==true)){
				//detailLowerForm.proc_link_applicable_td.innerHTML="<SELECT name='proc_link_applicable' id='proc_link_applicable' onChange='parent.parent.parent.showProc_link_resulting_option(this)'><option value='X' >"+getLabel('Common.notapplicable.label','Common')+"</option><option value='P'>"+getLabel('eOR.AutoLink.label','OR')+"</option></SELECT>"
			 f_query_add_mod.detail.detailLower.document.getElementById("proc_link_applicable_td").innerHTML="<SELECT name='proc_link_applicable' id='proc_link_applicable' onChange='parent.parent.parent.showProc_link_resulting_option(this)'><option value='X' >"+getLabel('Common.notapplicable.label','Common')+"</option><option value='P'>"+getLabel('eOR.AutoLink.label','OR')+"</option></SELECT>"
			}else{
			//detailLowerForm.proc_link_applicable_td.innerHTML="<SELECT name='proc_link_applicable' id='proc_link_applicable' onChange='parent.parent.parent.showProc_link_resulting_option(this);' ><option value='X'>"+getLabel('Common.notapplicable.label','Common')+"</option><option value='P'>"+getLabel('eOR.AutoLink.label','OR')+"</option><option value='R'>"+getLabel('eOR.manuallink.label','OR')+"</option></SELECT>"
			f_query_add_mod.detail.detailLower.document.getElementById("proc_link_applicable_td").innerHTML="<SELECT name='proc_link_applicable' id='proc_link_applicable' onChange='parent.parent.parent.showProc_link_resulting_option(this);' ><option value='X'>"+getLabel('Common.notapplicable.label','Common')+"</option><option value='P'>"+getLabel('eOR.AutoLink.label','OR')+"</option><option value='R'>"+getLabel('eOR.manuallink.label','OR')+"</option></SELECT>"
				}
			//showProc_link_resulting_option(detailLowerForm.proc_link_applicable);
		 showProc_link_resulting_option(f_query_add_mod.detail.detailLower.document.getElementById("proc_link_applicable"));
		}else{
			//detailLowerForm.discr_msr_panel_id_lbl.innerHTML = getLabel("Common.DiscreteMeasure.label","Common");
			f_query_add_mod.detail.detailLower.document.getElementById("discr_msr_panel_id_lbl").innerHTML = getLabel("Common.DiscreteMeasure.label","Common");
			//detailLowerForm.proc_coding_scheme_td.style.display  ="none";
			f_query_add_mod.detail.detailLower.document.getElementById("proc_coding_scheme_td").style.display  ="none";
			//detailLowerForm.discr_msr_panel_id_lbl.style.posWidth  =150	;
			f_query_add_mod.detail.detailLower.document.getElementById("discr_msr_panel_id_lbl").style.posWidth  =150	;
			//detailLowerForm.discr_msr_panel_id_td.innerHTML = "<INPUT type='text' onfocus=javascript:blur() maxLength=30 size=23 name=discr_msr_panel_id_desc><INPUT type=hidden name=discr_msr_panel_id><INPUT class=button onclick=parent.parent.parent.showApplUserWindow() type=button value=? name=appl_button>";
			f_query_add_mod.detail.detailLower.document.getElementById("discr_msr_panel_id_td").innerHTML = "<INPUT type='text' onfocus=javascript:blur() maxLength=30 size=23 name=discr_msr_panel_id_desc id=discr_msr_panel_id_desc><INPUT type=hidden name=discr_msr_panel_id id=discr_msr_panel_id><INPUT class=button onclick=parent.parent.parent.showApplUserWindow() type=button value=? name=appl_button>";
			//detailLowerForm.chrtMandatory2.style.posWidth  =346;
			f_query_add_mod.detail.detailLower.document.getElementById("chrtMandatory2").style.posWidth  =346;
			//detailLowerForm.proc_link_applicable_td.innerHTML="<SELECT name='proc_link_applicable' id='proc_link_applicable' ><option value='X'>"+getLabel('Common.notapplicable.label','Common')+"</option></SELECT>"
			f_query_add_mod.detail.detailLower.document.getElementById("proc_link_applicable_td").innerHTML="<SELECT name='proc_link_applicable' id='proc_link_applicable' ><option value='X'>"+getLabel('Common.notapplicable.label','Common')+"</option></SELECT>"
			//showProc_link_resulting_option(detailLowerForm.proc_link_applicable);
			showProc_link_resulting_option(f_query_add_mod.detail.detailLower.document.getElementById("proc_link_applicable"));
			}
		} else if (obj.value == 'P'){

				//detailLowerForm.discr_msr_panel_id_lbl.innerHTML =getLabel("Common.Procedure.label","COMMON");
			f_query_add_mod.detail.detailLower.document.getElementById("discr_msr_panel_id_lbl").innerHTML =getLabel("Common.Procedure.label","COMMON");
				//detailLowerForm.discr_msr_panel_id_lbl.style.posWidth  =80;
			f_query_add_mod.detail.detailLower.document.getElementById("discr_msr_panel_id_lbl").style.posWidth  =80;
				//detailLowerForm.proc_coding_scheme_td.style.display  ="inline";
			f_query_add_mod.detail.detailLower.document.getElementById("proc_coding_scheme_td").style.display  ="inline";
				//detailLowerForm.proc_coding_scheme_td.style.visibility="visible";	
			f_query_add_mod.detail.detailLower.document.getElementById("proc_coding_scheme_td").style.visibility="visible";
				//detailLowerForm.proc_coding_scheme_td.innerHTML = "<select name='proc_coding_scheme' id='proc_coding_scheme' onChange='parent.parent.parent.onChangeProcCodingScheme();'><option value=''>--- "+getLabel('Common.defaultSelect.label','Common')+" ---</option></select>";
			f_query_add_mod.detail.detailLower.document.getElementById("proc_coding_scheme_td").innerHTML = "<select name='proc_coding_scheme' id='proc_coding_scheme' onChange='parent.parent.parent.onChangeProcCodingScheme();'><option value=''>--- "+getLabel('Common.defaultSelect.label','Common')+" ---</option></select>";	
			//var bean_id =f_query_add_mod.bean_id.value ;
			var bean_id =f_query_add_mod.header.document.getElementById("bean_id").value ; ;
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;

				xmlStr ="<root><SEARCH " ;
				xmlStr +=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","OrderCatalogFillTermSetId.jsp?bean_id=Or_OrderCatalog&fill=proc_coding_scheme",false ) ;
				xmlHttp.send( xmlDoc ) ;
				responseText=xmlHttp.responseText ;
				eval( responseText ) ;
				//detailLowerForm.discr_msr_panel_id_td.innerHTML = "<INPUT type='text' onfocus=javascript:blur() maxLength=30 size=23 name=discr_msr_panel_id_desc><INPUT type=hidden name=discr_msr_panel_id><INPUT class=button onclick='parent.parent.parent.show_window(proc_coding_scheme)' type=button value=? name=appl_button>";
				f_query_add_mod.detail.detailLower.document.getElementById("discr_msr_panel_id_td").innerHTML = "<INPUT type='text' onfocus=javascript:blur() maxLength=30 size=23 name=discr_msr_panel_id_desc><INPUT type=hidden name=discr_msr_panel_id id=discr_msr_panel_id><INPUT class=button onclick='parent.parent.parent.show_window(proc_coding_scheme)' type=button value=? name=appl_button>";
				//name=appl_button>&nbsp;"+detailLowerForm.scheme_desc.value;
				//detailLowerForm.proc_link_applicable_td.innerHTML="<SELECT name='proc_link_applicable' id='proc_link_applicable' disabled><option value='P'>"+getLabel('eOR.AutoLink.label','OR')+"</option></SELECT>"
				f_query_add_mod.detail.detailLower.document.getElementById("proc_link_applicable_td").innerHTML="<SELECT name='proc_link_applicable' id='proc_link_applicable' disabled><option value='P'>"+getLabel('eOR.AutoLink.label','OR')+"</option></SELECT>"
				//showProc_link_resulting_option(detailLowerForm.proc_link_applicable);
				showProc_link_resulting_option(f_query_add_mod.detail.detailLower.document.getElementById("proc_link_applicable"));
		}else if (obj.value == 'M'){
			detailLowerDoc.getElementById("discr_msr_panel_id_lbl").innerHTML = getLabel("eOR.resultmatrix.label","OR");
				detailLowerForm.proc_coding_scheme_td.style.display  ="none";
				detailLowerForm.discr_msr_panel_id_lbl.style.posWidth  =208;
				detailLowerDoc.getElementById("discr_msr_panel_id_td").innerHTML = "<INPUT onfocus=javascript:blur() maxLength=30 size=23 name=discr_msr_panel_id_desc id=discr_msr_panel_id_desc><INPUT type=hidden name=discr_msr_panel_id id=discr_msr_panel_id><INPUT class=button onclick='parent.parent.parent.show_ResultMatrix_window()' type=button value=? name=appl_button>";
				detailLowerForm.chrtMandatory2.style.posWidth  =346;
				detailLowerDoc.getElementById("proc_link_applicable_td").innerHTML="<SELECT name='proc_link_applicable' id='proc_link_applicable' onChange='parent.parent.parent.showProc_link_resulting_option(this);' ><option value='X'>"+getLabel('Common.notapplicable.label','Common')+"</option><option value='P'>"+getLabel('eOR.AutoLink.label','OR')+"</option><option value='R'>"+getLabel('eOR.manuallink.label','OR')+"</option></SELECT>"
				showProc_link_resulting_option(detailLowerForm.proc_link_applicable);
				
		} else if (obj.value == 'N'){
				

			if (detailLowerForm.order_catalog_nature.value == 'A') {
				detailLowerDoc.getElementById("discr_msr_panel_id_lbl").innerHTML = getLabel("Common.note.label","COMMON");
				detailLowerForm.proc_coding_scheme_td.style.display  ="none";
				detailLowerForm.discr_msr_panel_id_lbl.style.posWidth  =209;
				detailLowerDoc.getElementById("discr_msr_panel_id_td").innerHTML = "<INPUT onfocus=javascript:blur() maxLength=30 size=23 name=discr_msr_panel_id_desc id=discr_msr_panel_id_desc><INPUT type=hidden name=discr_msr_panel_id id=discr_msr_panel_id><INPUT class=button onclick='parent.parent.parent.show_notes_window()' type=button value=? name=appl_button>";
				detailLowerForm.chrtMandatory2.style.posWidth  =346;
				detailLowerDoc.getElementById("proc_link_applicable_td").innerHTML="<SELECT name='proc_link_applicable' id='proc_link_applicable' onChange='parent.parent.parent.showProc_link_resulting_option(this);' ><option value='X'>"+getLabel('Common.notapplicable.label','Common')+"</option><option value='P'>"+getLabel('eOR.AutoLink.label','OR')+"</option><option value='R'>"+getLabel('eOR.manuallink.label','OR')+"</option></SELECT>"
				showProc_link_resulting_option(detailLowerForm.proc_link_applicable);
			} else {
				obj.value = "";
				detailLowerDoc.getElementById("discr_msr_panel_id_lbl").innerHTML = getLabel("Common.DiscreteMeasure.label","Common");
				detailLowerForm.proc_coding_scheme_td.style.display  ="none";
				detailLowerForm.discr_msr_panel_id_lbl.style.posWidth  =150;
				detailLowerDoc.getElementById("discr_msr_panel_id_td").innerHTML = "<INPUT onfocus=javascript:blur() maxLength=30 size=23 name=discr_msr_panel_id_desc id=discr_msr_panel_id_desc><INPUT type=hidden name=discr_msr_panel_id id=discr_msr_panel_id><INPUT class=button onclick=parent.parent.parent.showApplUserWindow() type=button value=? name=appl_button>";
				detailLowerForm.chrtMandatory2.style.posWidth  =346;
				detailLowerDoc.getElementById("proc_link_applicable_td").innerHTML="<SELECT name='proc_link_applicable' id='proc_link_applicable'><option value='X'>"+getLabel('Common.notapplicable.label','Common')+"</option></SELECT>"
				showProc_link_resulting_option(detailLowerForm.proc_link_applicable);
			}	 
		} else if (obj.value == 'C'){
			detailLowerDoc.getElementById("discr_msr_panel_id_lbl").innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+getLabel("eOR.Charting.label","OR");
				detailLowerForm.proc_coding_scheme_td.style.display  ="none";
				detailLowerForm.discr_msr_panel_id_lbl.style.posWidth  =208;
				detailLowerDoc.getElementById("discr_msr_panel_id_td").innerHTML = "<INPUT onfocus=javascript:blur() maxLength=30 size=23 name=discr_msr_panel_id_desc id=discr_msr_panel_id_desc><INPUT type=hidden name=discr_msr_panel_id id=discr_msr_panel_id><INPUT class=button onclick='parent.parent.parent.show_charting_window()' type=button value=? name=appl_button>";
				detailLowerForm.chrtMandatory2.style.posWidth  =346;
				detailLowerDoc.getElementById("proc_link_applicable_td").innerHTML="<SELECT name='proc_link_applicable' id='proc_link_applicable' onChange='parent.parent.parent.showProc_link_resulting_option(this);' ><option value='X'>"+getLabel('Common.notapplicable.label','Common')+"</option><option value='P'>"+getLabel('eOR.AutoLink.label','OR')+"</option><option value='R'>"+getLabel('eOR.manuallink.label','OR')+"</option></SELECT>"
				showProc_link_resulting_option(detailLowerForm.proc_link_applicable);
		}
		
		
		
		/*else if (obj.value == 'C'){
			if (detailLowerForm.order_catalog_nature.value == 'A') {
				detailLowerForm.discr_msr_panel_id_lbl.innerHTML = "&nbsp;Charting";
				detailLowerForm.discr_msr_panel_id_td.innerHTML = "&nbsp;<INPUT onfocus=javascript:blur() maxLength=10 size=10 name=discr_msr_panel_id_desc>&nbsp;<INPUT type=hidden name=discr_msr_panel_id><INPUT class=button onclick='parent.parent.parent.show_chart_window()' type=button value=? name=appl_button>&nbsp;";
			} else {
				obj.value = "";
				detailLowerForm.discr_msr_panel_id_lbl.innerHTML = "&nbsp;Discrete Measure";
				detailLowerForm.discr_msr_panel_id_td.innerHTML = "&nbsp;<INPUT onfocus=javascript:blur() maxLength=10 size=10 name=discr_msr_panel_id_desc>&nbsp;<INPUT type=hidden name=discr_msr_panel_id><INPUT class=button onclick=parent.parent.parent.showApplUserWindow(discr_msr_panel_id_desc,discr_msr_panel_id) type=button value=? name=appl_button>";
			}
		} else if (obj.value == 'I'){
			if (detailLowerForm.order_catalog_nature.value == 'A') {
				detailLowerForm.discr_msr_panel_id_lbl.innerHTML = "&nbsp;Intravenous";
				detailLowerForm.discr_msr_panel_id_td.innerHTML = "&nbsp;<INPUT onfocus=javascript:blur() maxLength=10 size=10 name=discr_msr_panel_id_desc>&nbsp;<INPUT type=hidden name=discr_msr_panel_id><INPUT type='hidden' value='' name=appl_button>&nbsp;";
			} else {
				obj.value = "";
				detailLowerForm.discr_msr_panel_id_lbl.innerHTML = "&nbsp;Discrete Measure";
				detailLowerForm.discr_msr_panel_id_td.innerHTML = "&nbsp;<INPUT onfocus=javascript:blur() maxLength=10 size=10 name=discr_msr_panel_id_desc>&nbsp;<INPUT type=hidden name=discr_msr_panel_id><INPUT class=button onclick=parent.parent.parent.showApplUserWindow(discr_msr_panel_id_desc,discr_msr_panel_id) type=button value=? name=appl_button>";
			}
		}*/ else  {  //if (obj.value == 'T')
			//if (detailLowerForm.order_catalog_nature.value == 'A')
			//{
			detailLowerDoc.getElementById("discr_msr_panel_id_lbl").innerHTML = getLabel("Common.DiscreteMeasure.label","Common");
				detailLowerForm.proc_coding_scheme_td.style.display  ="none";
				detailLowerForm.discr_msr_panel_id_lbl.style.posWidth  =150;
				detailLowerDoc.getElementById("discr_msr_panel_id_td").innerHTML = "<INPUT type='text' onfocus=javascript:blur() maxLength=30 size=23 name=discr_msr_panel_id_desc id=discr_msr_panel_id_desc><INPUT type=hidden name=discr_msr_panel_id id=discr_msr_panel_id><INPUT class=button onclick=parent.parent.parent.showCultureTestWindow(discr_msr_panel_id_desc,discr_msr_panel_id) type=button value=? name=appl_button>";
				detailLowerForm.chrtMandatory2.style.posWidth  =346;
				detailLowerDoc.getElementById("proc_link_applicable_td").innerHTML="<SELECT name='proc_link_applicable' id='proc_link_applicable' onChange='parent.parent.parent.showProc_link_resulting_option(this);' ><option value='X'>"+getLabel('Common.notapplicable.label','Common')+"</option><option value='P'>"+getLabel('eOR.AutoLink.label','OR')+"</option><option value='R'>"+getLabel('eOR.manuallink.label','OR')+"</option></SELECT>"
				showProc_link_resulting_option(detailLowerForm.proc_link_applicable);
			/*} else {
				//obj.value = "";
				detailLowerForm.discr_msr_panel_id_lbl.innerHTML = "&nbsp;Discrete Measure";
				detailLowerForm.discr_msr_panel_id_td.innerHTML = "&nbsp;<INPUT onfocus=javascript:blur() maxLength=10 size=10 name=discr_msr_panel_id_desc>&nbsp;<INPUT type=hidden name=discr_msr_panel_id><INPUT class=button onclick=parent.parent.parent.showApplUserWindow(discr_msr_panel_id_desc,discr_msr_panel_id) type=button value=? name=appl_button>";
			}*/
		}
	}
}
/***********show_window for Procedure*************/
/*function before_show_term_code_window(target,code)
{
  if(getHandleDetailLower()) {
		if(detailLowerForm.temp_term_desc.value != detailLowerForm.term_desc.value)
		{
			if(detailLowerForm.term_desc.value != "")
			 term_code_lookup(target,code);
		}
	}
}

function show_term_code_window(target,code){
  if(getHandleDetailLower()) {

			if(detailLowerForm.term_desc.value == "")
			term_code_lookup(target,code);
		}
}
function term_code_lookup(target,code) {
  	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	dataNameArray[0] 	= "term_set_id" ;		 
 	dataValueArray[0] 	= detailLowerForm.term_set_id.value;	 
 	dataTypeArray[0] 	= STRING ;

 	argumentArray[0]   = detailLowerForm.term_code_sql.value;
	argumentArray[1]   = dataNameArray ;
 	argumentArray[2]   = dataValueArray ;
 	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,3";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;
  	retVal =CommonLookup( "Term Set", argumentArray );

	if(retVal != null && retVal != "")
	{
	  code.value=retVal[0];
	  target.value=retVal[1];
	 detailLowerForm.temp_term_desc.value=retVal[1];
    }
}*/
function before_show_term_code_window(obj)
{
  if(getHandleDetailLower()) {
		if(detailLowerForm.temp_term_desc.value != detailLowerForm.term_desc.value)
		{
			if(detailLowerForm.term_desc.value != "")
			 show_window(obj);
		}
	}
}

function show_term_code_window(obj){
  if(getHandleDetailLower()) {
			if(detailLowerForm.term_desc.value == "")
			show_window(obj);
		}
}
async function show_window(obj) {

	/*var s_scheme= "";
	var s_scheme_desc = "";
	if (getHandleDetailLower()) {
    	s_scheme=detailLowerForm.scheme.value;
    	s_scheme_desc =detailLowerForm.scheme_desc.value;
    }*/
    //var retVal =    new String();
	 if(getHandleDetailLower()) {
	/****if(obj==detailLowerForm.proc_coding_scheme || obj==detailLowerForm.discr_msr_panel_id ){	
 	
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	getHandleDetail();
	
	dataNameArray[0] 	= "term_set_id" ;		 
 	dataValueArray[0] 	= eval("formObjDetail.term_set")+i.value;
 	//**dataValueArray[0] 	= "ICD10";
 	dataTypeArray[0] 	= STRING ;

 	argumentArray[0]   = "select TERM_CODE code,SHORT_DESC description from mr_term_Code where term_set_id like ? and PROCEDURE_YN = 'Y' and SELECT_YN = 'Y' and eff_Status = 'E' and upper(TERM_CODE) LIKE  UPPER(?) AND UPPER(SHORT_dESC) LIKE UPPER(?)  order by 2";
	argumentArray[1]   = dataNameArray ;
 	argumentArray[2]   = dataValueArray ;
 	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,3";
	argumentArray[5]   ="" ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;
  	
	retVal = await CommonLookup( "Procedure", argumentArray );

	if(retVal != null && retVal != ""){
		if (obj !=detailLowerForm.term_set_id)
		{		
		   detailLowerForm.discr_msr_panel_id.value=retVal[0];
		   detailLowerForm.discr_msr_panel_id_desc.value=retVal[1];
		}
		detailLowerForm.term_code.value					= retVal[0];
		detailLowerForm.term_desc.value					= retVal[1];
    }
	
	}else if(obj==detailLowerForm.term_set_id){***/

	 var returnVal =    new String();
    var dialogHeight= "33" ;
    var dialogWidth = "44" ;
    var status = "no";
   var arguments   = "" ;
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
   // retVal =
   
   if(obj==detailLowerForm.proc_coding_scheme){
		
		  returnVal=await window.showModalDialog("../../eMR/jsp/TermCodeFrameSet.jsp?title="+encodeURIComponent(obj.options[obj.selectedIndex].text)+"&term_set_id="+obj.value+"&mulitple_yn=N",arguments,features);
   }else if(obj==detailLowerForm.term_set_id){
	   returnVal= await window.showModalDialog("../../eMR/jsp/TermCodeFrameSet.jsp?title="+encodeURIComponent(obj.options[obj.selectedIndex].text)+"&term_set_id="+obj.value+"&term_desc="+encodeURIComponent(detailLowerForm.term_desc.value)+"&mulitple_yn=N",arguments,features);
 }
    /**
        added by parimala
        retVal = window.showModalDialog("/eCIS/ca/jsp/ModalTest/SearchProc.jsp?s_scheme="+s_scheme,arguments,features);
    **/
  //  if (!(retVal == null))

 if (returnVal != null)
    {
       /* var vals=retVal.split("/")  ;
        if(getHandleDetailLower()) {
        	detailLowerForm.discr_msr_panel_id.value=vals[0];
        	detailLowerForm.discr_msr_panel_id_desc.value=vals[1];
        }*/
		var retValCode		= returnVal.split("~") ;
		var retVal		= retValCode[0].split("||") ;

		if(obj==detailLowerForm.proc_coding_scheme){
		detailLowerForm.discr_msr_panel_id.value		= trimString(retVal[0]);
		
		detailLowerForm.discr_msr_panel_id_desc.value	= retVal[1];
		detailLowerForm.term_code.value					= trimString(retVal[0]);
		detailLowerForm.term_desc.value					= retVal[1];
		
		}else if(obj==detailLowerForm.term_set_id)
		{
			detailLowerForm.term_code.value		= trimString(retVal[0]);
			detailLowerForm.term_desc.value		= retVal[1];

		}
		//level_desc		= retVal[2];
		//level			= retVal[3];
    }
	
    //document.OPProc_form.code.focus();
	// }
}
}


async function show_ResultMatrix_window(){
    if(getHandleDetailLower()) {
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	argumentArray[0]   = detailLowerForm.ResultMatrix_sql.value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	//argumentArray[5]   = target.value ;
	argumentArray[5]   = "" ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;
	retVal = await CommonLookup( getLabel("eOR.resultmatrix.label","OR"),argumentArray );
	var ret1=unescape(retVal);
	var arr=ret1.split(",");
		if(arr[1]==undefined) 
		{
			arr[0]="";	
			arr[1]="";	
		}
	if(retVal != null && retVal != ""){
       detailLowerForm.discr_msr_panel_id.value=arr[0];
	   detailLowerForm.discr_msr_panel_id_desc.value=arr[1];
    }
   }
}
async function show_notes_window(){

    if(getHandleDetailLower()) {
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	argumentArray[0]   = detailLowerForm.notes_sql.value;
  
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	//argumentArray[5]   = target.value ;
	argumentArray[5]   = "" ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;

	retVal = await CommonLookup(getLabel("Common.note.label","Common"), argumentArray );
	var ret1=unescape(retVal);
	var arr=ret1.split(",");
		if(arr[1]==undefined) 
		{
			arr[0]="";	
			arr[1]="";	
		}
	if(retVal != null && retVal != ""){
       detailLowerForm.discr_msr_panel_id.value=arr[0];
	   detailLowerForm.discr_msr_panel_id_desc.value=arr[1];
    }
   }
}

async function show_charting_window(){

    if(getHandleDetailLower()) {
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var localeName			   = f_query_add_mod.header.document.header.localeName.value ;
	var sql=detailLowerForm.chart_sql.value;
	
	//sql=sql.replace('?',"'"+localeName+"'");
	
	argumentArray[0]   = sql;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = "" ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;


	retVal = await CommonLookup(getLabel("eOR.Charting.label","eOR"), argumentArray );
	var ret1=unescape(retVal);
	var arr=ret1.split(",");
		if(arr[1]==undefined) 
		{
			arr[0]="";	
			arr[1]="";	
		}
	if(retVal != null && retVal != ""){
       detailLowerForm.discr_msr_panel_id.value=arr[0];
	   detailLowerForm.discr_msr_panel_id_desc.value=arr[1];
    }
   }
}
function showProc_link_resulting_option(obj){

	f_query_add_mod.detail.detailLower.document.getElementById("proc_link_applicable").value=obj.value;

		if(f_query_add_mod.detail.detailLower.document.getElementById("proc_link_applicable").value=='R' )
		{
			//detailLowerDoc.proc_link_resulting_option.value="M";	
			//detailLowerForm.proc_link_resulting_option_lbl.style.visibility="visible";
			//detailLowerForm.proc_link_resulting_option.style.visibility="visible";
			//detailLowerForm.term_set_id_lbl.style.visibility="hidden";
			//detailLowerForm.term_set_id_td.style.visibility="hidden";			
			detailLowerForm.term_set_id.value="";
			//detailLowerForm.term_code_lbl.style.visibility="hidden";
			//detailLowerForm.term_code_td.style.visibility="hidden";
			detailLowerForm.term_code.value="";
			detailLowerForm.term_desc.value="";
			detailLowerForm.temp_term_desc.value="";

		}else if (f_query_add_mod.detail.detailLower.document.getElementById("proc_link_applicable").value=='P' || f_query_add_mod.detail.detailLower.document.getElementById("proc_link_applicable").value=='C')
		{
			detailLowerForm.proc_link_resulting_option.selectedIndex=0;	
			//detailLowerForm.proc_link_resulting_option_lbl.style.visibility="hidden";
			detailLowerForm.proc_link_resulting_option.style.visibility="hidden";
			//detailLowerForm.term_set_id_lbl.style.visibility="visible";
			//detailLowerForm.term_set_id_td.style.visibility="visible";
			//detailLowerForm.term_set_id_td.style.visibility="visible";
			//detailLowerForm.term_code_lbl.style.visibility="visible";
			//detailLowerForm.term_code_td.style.visibility="visible";
			detailLowerForm.term_code.value="";

		}
		else
		{
			detailLowerForm.proc_link_resulting_option.selectedIndex=0;			
			//detailLowerForm.proc_link_resulting_option_lbl.style.visibility="hidden";
			detailLowerForm.proc_link_resulting_option.style.visibility="hidden";
			//detailLowerForm.term_set_id_lbl.style.visibility="hidden";
			//detailLowerForm.term_set_id_td.style.visibility="hidden";			
			detailLowerForm.term_set_id.value="";
			//detailLowerForm.term_code_lbl.style.visibility="hidden";
			//detailLowerForm.term_code_td.style.visibility="hidden";
			detailLowerForm.term_code.value="";
			detailLowerForm.term_desc.value="";
			detailLowerForm.temp_term_desc.value="";
		}
}
/****************onChange of proc_coding_scheme***********************/
function onChangeProcCodingScheme(){
	if(getHandleDetailLower()) {
		
	   detailLowerForm.discr_msr_panel_id.value="";
	   detailLowerForm.discr_msr_panel_id_desc.value="";
	   detailLowerForm.term_set_id.value=detailLowerForm.proc_coding_scheme.value;
	   detailLowerForm.term_code.value="";
	   detailLowerForm.term_desc.value="";
	   
	}
}
/****************onChange of term_set_id***********************/
function onChangeTermSetID(){
			detailLowerForm.term_code.value="";
			detailLowerForm.term_desc.value="";
			detailLowerForm.temp_term_desc.value="";


}
/***************************************************/
function checkVal(obj){
	f_query_add_mod.detail.detailUpper.detailUpperForm.dispMode.value = obj;
    doSync(f_query_add_mod.detail.detailUpper.detailUpperForm);

	f_query_add_mod.detail.detailUpper.detailUpperForm.submit();
}

function checkPrepVal(obj){
	f_query_add_mod = top.content.f_query_add_mod;
	document.detailLowerForm.dispMode.value = obj;
	//doSync(parent.OrderCatalogAddModifyPrepDetailHdr.document.detailUpperForm);
    latestUpdateUpper();
	document.getElementById("detailLowerForm").submit();
}

function dispLink(obj){
	var checkManFlag = true;//checkMandatory()
	//getHandleDetailUpper();
	if (getHandleDetailUpperPrep()) {
		formObjSyn = detailUpperForm ;
    }
	
	if(checkManFlag){

		var buttonVal			   	= obj;
		var formObj				   	= f_query_add_mod.detail.detailUpper.OrderCatalogAddModifyPrepDetailHdr.document.detailUpperForm;
		var formDoc				   	= f_query_add_mod.detail.detailUpper.OrderCatalogAddModifyPrepDetailHdr.document;
		
		if(buttonVal == "S"){
			formDoc.getElementById("SelectTab").className="clicked";
			formDoc.getElementById("AssociateTab").className="normal";
		}else if(buttonVal == "A"){
			formDoc.getElementById("SelectTab").className="normal";
			formDoc.getElementById("AssociateTab").className="clicked";
		}
		formObj.tabVal.value = buttonVal;
		
		if(f_query_add_mod.detail.detailUpper.document.OrderCatalogAddModifyPrepDetailDtl.location.href.indexOf(".jsp") != -1){
			  var flag = latestUpdateUpper();
		}

		if(linkContent=="")
			linkContent	=	f_query_add_mod.detail.detailUpper.OrderCatalogAddModifyPrepDetailHdr.document.getElementById("linkId").innerHTML;

        var queryString ="tabVal="+buttonVal;
        queryString += "&"+formObj.qry_string.value;
        for (i=0;i<formObj.tot_recs.value;i++) {
            queryString += "&patient_class"+i+"="+eval("formObj.patient_class"+i).value
        }

        var pri_sec_tasks_type=f_query_add_mod.detail.detailUpper.OrderCatalogAddModifyPrepDetailHdr.document.forms[0].pri_sec_tasks_type.value;
		if(buttonVal=="A"){
			/*f_query_add_mod.detail.detailUpper.OrderCatalogAddModifyPrepDetailHdr.document.forms[0].linkId.className ="";
			f_query_add_mod.detail.detailUpper.OrderCatalogAddModifyPrepDetailHdr.document.forms[0].linkId.innerHTML = "&nbsp;";
			f_query_add_mod.detail.detailUpper.document.frames[1].location.href="../../eOR/jsp/OrderCatalogAddModifyPrepDetailDtl.jsp?"+queryString+"&pri_sec_tasks_type="+pri_sec_tasks_type;*/
			
			formDoc.getElementById("linkId").className ="";
			formDoc.getElementById("linkId").innerHTML = "&nbsp;";
			f_query_add_mod.detail.detailUpper.document.OrderCatalogAddModifyPrepDetailDtl.location.href="../../eOR/jsp/OrderCatalogAddModifyPrepDetailDtl.jsp?"+queryString+"&pri_sec_tasks_type="+pri_sec_tasks_type;

		}else{
			//f_query_add_mod.detail.detailUpper.document.frames[1].location.href="../../eCommon/html/blank.html";
			f_query_add_mod.detail.detailUpper.document.OrderCatalogAddModifyPrepDetailDtl.location.href="../../eCommon/html/blank.html";
			//f_query_add_mod.detail.detailUpper.OrderCatalogAddModifyPrepDetailHdr.document.forms[0].linkId.innerHTML = linkContent;
			formDoc.getElementById("linkId").innerHTML = linkContent;
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
		}
	}
}

function callOnAlphaLink(obj, obj2){
	changeAlphaColor(obj2);
	var checkManFlag = true;//checkMandatory();
	if(checkManFlag){
		if(parent.frames[1].location.href.indexOf(".jsp") != -1){
			var flag = latestUpdate();
		}
		var formObj				   	= document.forms[0];

		var qry_string    = formObj.qry_string.value;


		var queryString ="index="+obj+"&tabVal=S&"+qry_string;

        for (i=0;i<formObj.tot_recs.value;i++) {
            queryString += "&patient_class"+i+"="+eval("formObj.patient_class"+i).value
        }
var pri_sec_tasks_type = parent.parent.parent.frames[2].frames[0].frames[0].document.forms[0].pri_sec_tasks_type.value;
parent.frames[1].location.href="../../eOR/jsp/OrderCatalogAddModifyPrepDetailDtl.jsp?"+queryString+"&pri_sec_tasks_type="+pri_sec_tasks_type;
parent.parent.parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";

	}
	else{
		/*
		parent.detailFrame.location.href="../../eCommon/html/blank.html";
		var msg = "APP-000001 Service cannot be blank...";
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		*/

	}
}

function latestUpdate(){
	
	var bean_id		= parent.frames[1].document.detailLowerForm.bean_id.value;
	var bean_name	= parent.frames[1].document.detailLowerForm.bean_name.value;
	var fm_disp		= parent.frames[1].document.detailLowerForm.fm_disp.value;
	var to_disp		= parent.frames[1].document.detailLowerForm.to_disp.value;
	var tabVal		= parent.frames[1].document.detailLowerForm.tabVal.value;
	
	var pri_sec_tasks_type	=parent.parent.parent.frames[2].frames[0].frames[1].document.forms[0].pri_sec_tasks_type.value;
	var value_str	= "";


    var sec_order_stage_stat_str = "";
    var sec_order_stat_durn_str = "";
    var sec_order_stat_durn_type_str = "";

    var sec_order_stage_urg_str = "";
    var sec_order_urg_durn_str = "";
    var sec_order_urg_durn_type_str = "";

    var sec_order_stage_rtn_str = "";
    var sec_order_rtn_durn_str = "";
    var sec_order_rtn_durn_type_str = "";
	var pri_sec_tasks_type_str="";

	fm_disp = parseInt(fm_disp);
	to_disp = parseInt(to_disp);

	for(i=fm_disp; i<=to_disp; i++){
		var value = eval('parent.frames[1].document.detailLowerForm.select_yn'+i);
			if(!value.disabled){
				if(value.checked)
					val = "Y";
				else
					val = "N";
				}
				else
					val ="N";

			value_str += val+"~";

        var sec_order_stage_stat = eval('parent.frames[1].document.detailLowerForm.sec_order_stage_stat'+i).value
		sec_order_stage_stat_str += sec_order_stage_stat+"~";
		var sec_order_stat_durn = eval('parent.frames[1].document.detailLowerForm.sec_order_stat_durn'+i).value
		if (sec_order_stat_durn == '') sec_order_stat_durn = ' ';
		sec_order_stat_durn_str += sec_order_stat_durn+"~";
		var sec_order_stat_durn_type = eval('parent.frames[1].document.detailLowerForm.sec_order_stat_durn_type'+i).value
		sec_order_stat_durn_type_str += sec_order_stat_durn_type+"~";

		var sec_order_stage_urg = eval('parent.frames[1].document.detailLowerForm.sec_order_stage_urg'+i).value
		sec_order_stage_urg_str += sec_order_stage_urg+"~";
		var sec_order_urg_durn = eval('parent.frames[1].document.detailLowerForm.sec_order_urg_durn'+i).value
		if (sec_order_urg_durn == '') sec_order_urg_durn = ' ';
		sec_order_urg_durn_str += sec_order_urg_durn+"~";
		var sec_order_urg_durn_type = eval('parent.frames[1].document.detailLowerForm.sec_order_urg_durn_type'+i).value
		sec_order_urg_durn_type_str += sec_order_urg_durn_type+"~";

		var sec_order_stage_rtn = eval('parent.frames[1].document.detailLowerForm.sec_order_stage_rtn'+i).value
		sec_order_stage_rtn_str += sec_order_stage_rtn+"~";
		var sec_order_rtn_durn = eval('parent.frames[1].document.detailLowerForm.sec_order_rtn_durn'+i).value
		if (sec_order_rtn_durn == '') sec_order_rtn_durn = ' ';
		sec_order_rtn_durn_str += sec_order_rtn_durn+"~";
		var sec_order_rtn_durn_type = eval('parent.frames[1].document.detailLowerForm.sec_order_rtn_durn_type'+i).value
		sec_order_rtn_durn_type_str += sec_order_rtn_durn_type+"~";
		var pri_sec_tasks_type = pri_sec_tasks_type
		pri_sec_tasks_type_str += pri_sec_tasks_type+"~";

        }
		var xmlStr ="<root><SEARCH ";
		xmlStr += " INDEX_VALUES=\""+ value_str + "\" ";

        xmlStr += " SEC_ORDER_STAGE_STAT_VALUES=\""+ sec_order_stage_stat_str + "\" ";
        xmlStr += " SEC_ORDER_STAT_DURN_VALUES=\""+ sec_order_stat_durn_str + "\" ";
        xmlStr += " SEC_ORDER_STAT_DURN_TYPE_VALUES=\""+ sec_order_stat_durn_type_str + "\" ";

        xmlStr += " SEC_ORDER_STAGE_URG_VALUES=\""+ sec_order_stage_urg_str + "\" ";
        xmlStr += " SEC_ORDER_URG_DURN_VALUES=\""+ sec_order_urg_durn_str + "\" ";
        xmlStr += " SEC_ORDER_URG_DURN_TYPE_VALUES=\""+ sec_order_urg_durn_type_str + "\" ";

        xmlStr += " SEC_ORDER_STAGE_RTN_VALUES=\""+ sec_order_stage_rtn_str + "\" ";
        xmlStr += " SEC_ORDER_RTN_DURN_VALUES=\""+ sec_order_rtn_durn_str + "\" ";
        xmlStr += " SEC_ORDER_RTN_DURN_TYPE_VALUES=\""+ sec_order_rtn_durn_type_str + "\" ";
		xmlStr += " PRI_SEC_TASKS_TYPE_STR_VALUES=\""+ pri_sec_tasks_type_str + "\" ";

		xmlStr += " FROM_VALUE=\""+ fm_disp + "\" ";
		xmlStr += " TO_VALUE=\""+ to_disp + "\" ";
		xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
		xmlStr += " TAB_VALUE=\""+ tabVal + "\" ";
		xmlStr += " CLASS_NAME=\"OrderCatalogBean\"";
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","OrderCatalogAddModifyPrepDetailValidate.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		return true;

	}

	function latestUpdateUpper(){
	
	var bean_id		= f_query_add_mod.detail.detailUpper.document.OrderCatalogAddModifyPrepDetailDtl.document.detailLowerForm.bean_id.value;
	var bean_name	= f_query_add_mod.detail.detailUpper.document.OrderCatalogAddModifyPrepDetailDtl.document.detailLowerForm.bean_name.value;
	var fm_disp		= f_query_add_mod.detail.detailUpper.document.OrderCatalogAddModifyPrepDetailDtl.document.detailLowerForm.fm_disp.value;
	var to_disp		= f_query_add_mod.detail.detailUpper.document.OrderCatalogAddModifyPrepDetailDtl.document.detailLowerForm.to_disp.value;
	var tabVal		= f_query_add_mod.detail.detailUpper.document.OrderCatalogAddModifyPrepDetailDtl.document.detailLowerForm.tabVal.value;
	var pri_sec_tasks_type	= f_query_add_mod.detail.detailUpper.document.OrderCatalogAddModifyPrepDetailDtl.document.detailLowerForm.pri_sec_tasks_type.value;

	var value_str	= "";

    var sec_order_stage_stat_str = "";
    var sec_order_stat_durn_str = "";
    var sec_order_stat_durn_type_str = "";

    var sec_order_stage_urg_str = "";
    var sec_order_urg_durn_str = "";
    var sec_order_urg_durn_type_str = "";

    var sec_order_stage_rtn_str = "";
    var sec_order_rtn_durn_str = "";
    var sec_order_rtn_durn_type_str = "";
	var pri_sec_tasks_type_str="";

	fm_disp = parseInt(fm_disp);
	to_disp = parseInt(to_disp);

	for(i=fm_disp; i<=to_disp; i++){
		var value = eval('f_query_add_mod.detail.detailUpper.document.OrderCatalogAddModifyPrepDetailDtl.document.detailLowerForm.select_yn'+i);
			if(value){ //!value.disabled
				if(value.checked)
					val = "Y";
				else
					val = "N";
				}
				else
					val ="N";

			value_str += val+"~";

        if(value){
			var sec_order_stage_stat = eval('f_query_add_mod.detail.detailUpper.document.OrderCatalogAddModifyPrepDetailDtl.document.detailLowerForm.sec_order_stage_stat'+i).value
			sec_order_stage_stat_str += sec_order_stage_stat+"~";
			var sec_order_stat_durn = eval('f_query_add_mod.detail.detailUpper.document.OrderCatalogAddModifyPrepDetailDtl.document.detailLowerForm.sec_order_stat_durn'+i).value
			if (sec_order_stat_durn == '') sec_order_stat_durn = ' ';
			sec_order_stat_durn_str += sec_order_stat_durn+"~";
			var sec_order_stat_durn_type = eval('f_query_add_mod.detail.detailUpper.document.OrderCatalogAddModifyPrepDetailDtl.document.detailLowerForm.sec_order_stat_durn_type'+i).value
			sec_order_stat_durn_type_str += sec_order_stat_durn_type+"~";

			var sec_order_stage_urg = eval('f_query_add_mod.detail.detailUpper.document.OrderCatalogAddModifyPrepDetailDtl.document.detailLowerForm.sec_order_stage_urg'+i).value
			sec_order_stage_urg_str += sec_order_stage_urg+"~";
			var sec_order_urg_durn = eval('f_query_add_mod.detail.detailUpper.document.OrderCatalogAddModifyPrepDetailDtl.document.detailLowerForm.sec_order_urg_durn'+i).value
			if (sec_order_urg_durn == '') sec_order_urg_durn = ' ';
			sec_order_urg_durn_str += sec_order_urg_durn+"~";
			var sec_order_urg_durn_type = eval('f_query_add_mod.detail.detailUpper.document.OrderCatalogAddModifyPrepDetailDtl.document.detailLowerForm.sec_order_urg_durn_type'+i).value
			sec_order_urg_durn_type_str += sec_order_urg_durn_type+"~";

			var sec_order_stage_rtn = eval('f_query_add_mod.detail.detailUpper.document.OrderCatalogAddModifyPrepDetailDtl.document.detailLowerForm.sec_order_stage_rtn'+i).value
			sec_order_stage_rtn_str += sec_order_stage_rtn+"~";
			var sec_order_rtn_durn = eval('f_query_add_mod.detail.detailUpper.document.OrderCatalogAddModifyPrepDetailDtl.document.detailLowerForm.sec_order_rtn_durn'+i).value
			if (sec_order_rtn_durn == '') sec_order_rtn_durn = ' ';
			sec_order_rtn_durn_str += sec_order_rtn_durn+"~";
			var sec_order_rtn_durn_type = eval('f_query_add_mod.detail.detailUpper.document.OrderCatalogAddModifyPrepDetailDtl.document.detailLowerForm.sec_order_rtn_durn_type'+i).value
			sec_order_rtn_durn_type_str += sec_order_rtn_durn_type+"~";
			var pri_sec_tasks_type = pri_sec_tasks_type
			pri_sec_tasks_type_str += pri_sec_tasks_type+"~";
			
		} else {
			sec_order_stage_stat_str += " ~";
			sec_order_stat_durn_str += " ~";
			sec_order_stat_durn_type_str += " ~";
			sec_order_stage_urg_str += " ~";
			sec_order_urg_durn_str += " ~";
			sec_order_urg_durn_type_str += " ~";
			sec_order_stage_rtn_str += " ~";
			sec_order_rtn_durn_str += " ~";
			sec_order_rtn_durn_type_str += " ~";
			pri_sec_tasks_type_str += " ~";
			
		}

       }
		var xmlStr ="<root><SEARCH ";
		xmlStr += " INDEX_VALUES=\""+ value_str + "\" ";

        xmlStr += " SEC_ORDER_STAGE_STAT_VALUES=\""+ sec_order_stage_stat_str + "\" ";
        xmlStr += " SEC_ORDER_STAT_DURN_VALUES=\""+ sec_order_stat_durn_str + "\" ";
        xmlStr += " SEC_ORDER_STAT_DURN_TYPE_VALUES=\""+ sec_order_stat_durn_type_str + "\" ";

        xmlStr += " SEC_ORDER_STAGE_URG_VALUES=\""+ sec_order_stage_urg_str + "\" ";
        xmlStr += " SEC_ORDER_URG_DURN_VALUES=\""+ sec_order_urg_durn_str + "\" ";
        xmlStr += " SEC_ORDER_URG_DURN_TYPE_VALUES=\""+ sec_order_urg_durn_type_str + "\" ";

        xmlStr += " SEC_ORDER_STAGE_RTN_VALUES=\""+ sec_order_stage_rtn_str + "\" ";
        xmlStr += " SEC_ORDER_RTN_DURN_VALUES=\""+ sec_order_rtn_durn_str + "\" ";
        xmlStr += " SEC_ORDER_RTN_DURN_TYPE_VALUES=\""+ sec_order_rtn_durn_type_str + "\" ";
		xmlStr += " PRI_SEC_TASKS_TYPE_STR_VALUES=\""+ pri_sec_tasks_type_str + "\" ";

		xmlStr += " FROM_VALUE=\""+ fm_disp + "\" ";
		xmlStr += " TO_VALUE=\""+ to_disp + "\" ";
		xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
		xmlStr += " TAB_VALUE=\""+ tabVal + "\" ";
		xmlStr += " CLASS_NAME=\"OrderCatalogBean\"";
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","OrderCatalogAddModifyPrepDetailValidate.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		return true;

	}

	/*********************detail upper Handle (for Secondary Orders) *****************************/
function getHandleDetailUpperPrep(){

if(!getHandleDetail())
 return false;
if(f_query_add_mod.detail.detailUpper == undefined)
	return ;

 detailUpperDoc			 =f_query_add_mod.detail.detailUpper.document ;

//if(detailUpperDoc.frames[0].document.forms[0] == null)
 if(f_query_add_mod.detail.detailUpper.document == null)
	return false;

if(detailUpperDoc.getElementsByTagName('iframe')[0].contentWindow.document.forms[0].name == "detailUpperForm"){
	 detailUpperDoc	     =f_query_add_mod.detail.detailUpper.document ;
	 detailUpperForm	 =detailUpperDoc.getElementsByTagName('iframe')[0].contentWindow.document.detailUpperForm;
	 return true;
 }else{
	 return false;
 }
}

function getHandleDetailLowerPrep(){

if(!getHandleDetail())
	 return false;

	if(f_query_add_mod.detail.detailUpper == undefined)
		return ;
	 detailUpperDoc			 =f_query_add_mod.detail.detailUpper.document ;
	 
	if(detailUpperDoc.OrderCatalogAddModifyPrepDetailHdr.document.forms[0] == null)
		return false;
	
	if(detailUpperDoc.OrderCatalogAddModifyPrepDetailHdr.document.forms[0].name == "detailLowerForm"){
		 detailUpperDoc	     =f_query_add_mod.detail.detailUpper.document ;
		 detailLowerForm	 =detailUpperDoc.OrderCatalogAddModifyPrepDetailHdr.document.detailLowerForm ;
		 return true;
	 }else{
		 return false;
	 }
}

function checkValue(obj) {
    if (obj.checked == true) {
        obj.value = 'Y';
    } else {
        obj.value = 'N';
    }
 
}

function chkTaperRadio(obj) {
    getHandleDetailLower();

		
    if (obj.name == 'taper_up') {
		
		detailLowerForm.taper_up.checked = true;
        detailLowerForm.taper_up.value = "Y";
		detailLowerForm.taper_dose_yn.checked = false;
        detailLowerForm.taper_dose_yn.value = "N";
        detailLowerForm.none_yn.checked = false;
        detailLowerForm.none_yn.value = "N";

        
    } else if (obj.name == 'taper_dose_yn') {

		detailLowerForm.taper_dose_yn.checked = true;
        detailLowerForm.taper_dose_yn.value = "Y";
        detailLowerForm.taper_up.checked = false;
        detailLowerForm.taper_up.value = "N";
		detailLowerForm.none_yn.checked = false;
        detailLowerForm.none_yn.value = "N";
        
    }
     else if(obj.name == 'none_yn') {
        detailLowerForm.taper_up.checked = false;
        detailLowerForm.taper_up.value = "N";
	    detailLowerForm.taper_dose_yn.checked = false;
        detailLowerForm.taper_dose_yn.value = "N";
		detailLowerForm.none_yn.checked = true;
        detailLowerForm.none_yn.value = "Y";  
    }
	 
	

}


function checkIsValidForProceed()
{
		 var url = f_query_add_mod.location.href;
		 var canApply = "N";//IN068370,IN068373
		 
			//IN068370,IN068373, starts
      if(f_query_add_mod.isCatalogApplyAppl!=null) 
				canApply =  f_query_add_mod.isCatalogApplyAppl.value;
      //IN068370,IN068373, ends
		url = url.toLowerCase();
		
		 //IN068370,IN068373, starts
     if (canApply == 'N')
				return false;
		 //if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
     else if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1) )//IN068370,IN068373, ends,Modified for TFSID-8081
				return true;
		else
				return false;
}

/*******************************************************************************/
/***************************************/

function addProcTermSetIdList(code,desc)
	{		
			var element = document.createElement('OPTION') ;
			element.value = code ;
			element.text  = desc ;
			//var docObj=parent.f_query_add_mod_detail.document.ActivityTypeDetail;
			detailLowerForm.proc_coding_scheme.add(element) ;
	
	}
/***************************************/
function clearProcTermSetIdList( docObj ) {
if(getHandleDetailLower()) {	
		var len = detailLowerForm.proc_coding_scheme.options.length ;
		for(var i=0;i<len;i++)
		{
			detailLowerForm.proc_coding_scheme.remove("proc_coding_scheme") ;
		}
		
		var opt = document.createElement("OPTION") ;
		opt.text ="     --- "+getLabel("Common.defaultSelect.label","Common")+" ---     " ;
		opt.value = "" ;
		detailLowerForm.proc_coding_scheme.add(opt);
		detailLowerForm.proc_coding_scheme.value="";
	
}
}
function SpecialCharCheckPH( fields, names, messageFrame,disp_type,error_jsp) {
        var errors = "" ;
        for( var i=0; i<fields.length; i++ ) {
            if(CheckCharsPH(fields[i])) {
            }
            else{
                if (disp_type=="A"){//errors +=  "APP-000001 " + names[i] + " cannot have special characters..." + "\n" ;
				errors += getMessage("CANNOT_BE_SPECIAL_CHAR","Common",new Array(encodeURIComponent(names[i])))+"<br>";
				}
                else if(disp_type=="M"){//errors +=  "APP-000001 " + names[i] + " cannot have special characters..." + "<br>" ;
				errors += getMessage("CANNOT_BE_SPECIAL_CHAR","Common",new Array(encodeURIComponent(names[i])))+"<br>";}
            }
        }
        if ( errors.length != 0 ) {
            var loc_route = error_jsp+"?err_num="+errors;
            if (disp_type=="M")messageFrame.document.location.href=loc_route;
            else if (disp_type=="A")alert(errors);
            return false ;
        }
        return true ;
    }

	function CheckCharsPH(Obj){
        var str = Obj.value;
        var specCharsExist = true;
        for (u=0;u<str.length;u++){
            if (((str.charCodeAt(u)>=48) && (str.charCodeAt(u)<=57))||((str.charCodeAt(u)>=65) && (str.charCodeAt(u)<=90))||((str.charCodeAt(u)>=97) && (str.charCodeAt(u)<=122))||(str.charCodeAt(u)==95)||(str.charCodeAt(u)==42)||(str.charCodeAt(u)==45)||(str.charCodeAt(u)==46));
            else{
			    specCharsExist = false;
                break;
            }
        }
        return specCharsExist;
    }
//Function to disable all special characters in master codes.
function CheckForSpecChars(event){
    //var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_.-'; //IN071296
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_-'; //IN071296
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

async function show_primary_speciality()
{
	
    if(getHandleDetailUpper()) {
		
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var localeName			   = f_query_add_mod.header.document.header.localeName.value ;
	
	argumentArray[0]   = detailUpperForm.pri_splty_sql.value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = detailUpperForm.primary_speciality_desc.value;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;


	retVal = await CommonLookup(getLabel("Common.primaryspeciality.label","Common"), argumentArray );
	var ret1=unescape(retVal);
	var arr=ret1.split(",");
		if(arr[1]==undefined) 
		{
			arr[0]="";	
			arr[1]="";	
		}
	if(retVal != null && retVal != ""){
       detailUpperForm.pri_splty_code.value=arr[0];
	   detailUpperForm.primary_speciality_desc.value=arr[1];
    }
   }
}

function chkSplty(obj)
{
	getHandleDetailUpper();

	if(obj.checked == true){
		detailUpperDoc.detailUpperForm.primary_speciality_desc.disabled	= false;
		detailUpperDoc.detailUpperForm.appl_button.disabled	= false;
	}else{
	   detailUpperDoc.detailUpperForm.primary_speciality_desc.value	= "";
	   detailUpperDoc.detailUpperForm.pri_splty_code.value = "";
	   detailUpperDoc.detailUpperForm.appl_button.disabled	= true;
	   detailUpperDoc.detailUpperForm.primary_speciality_desc.disabled=true;
	}
}
function linkedConsent(obj,mode,consent_form_list)
{
	if(mode=="2" && consent_form_list.value=="F")
	{
		getHandleHeader();
		var  xmlAppend = "";
		var bean_id			   = formObjHeader.bean_id ;
		var order_catalog_code=formObjHeader.order_catalog_code.value;
		var localeName			   = formObjHeader.localeName.value ;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlAppend += "order_catalog_code"+"=\""+ order_catalog_code+"\" " ;
		xmlAppend += "obj_name"+"=\""+ obj.name+"\" " ;
		xmlAppend += "obj_value"+"=\""+ obj.value+"\" " ;
		xmlAppend += "type"+"=\"consent_count\"" ;
		xmlStr ="<root><SEARCH " ;
		xmlStr =xmlStr + xmlAppend ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "OrderCatalogComboFill.jsp?bean_id="+bean_id.value+"&localeName="+localeName,false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText ) ;
	}
}
function ConsentNum(no_consent,obj_name)
{
	var msg="";
	if(obj_name=="num_of_consent_req_bo")
	{
		msg=getMessage("BEFORE_ORDER_RELEASE_CONSENT_LINKED","OR");
		msg=msg.replace('{1}',no_consent);
		alert(msg);
	}
	else if(obj_name=="num_of_consent_req_br")
	{
		msg=getMessage("BEFORE_ORDER_REGISTRATION_CONSENT_LINKED","OR");
		msg=msg.replace('{1}',no_consent);
		alert(msg)
	}
}

/*******************************************************************************/

/**Reference Pattern for Frame's and form Object For Catalog By section

Menu
	|
	OROrderCatalog.jsp---->orderCatalog.js
		|
		|------MstToolBar--------------------------------------------------------------------------------------------------->commontoolbarFrame[Frame]
		|
		|------OrderCatalogAddModify.jsp/OrderCatalogQueryCriteria.jsp/OrderCatalogQueryResult.jsp-------------------------->f_query_add_mod{FrameSet}
		|		|
		|		|---OrderCatalogAddModifyHeader.jsp----->header[Frame]
		|		|		Document ---headerDoc
		|		|		FormObect---formObjHeader		 header[form]
		|		|		Reference from  this JSP will  be as parent.parent.XXX()
		|		|
		|		|---OrderCatalogTab.jsp	---------------->tab[Frame]
		|		|		Document ---tabDoc
		|		|		FormObect---formObjTab			 tab[form]
		|		|		Reference from  this JSP will  be as parent.parent.XXX()
		|		|
		|		|---OrderCatalogAddModifyDetail.jsp----->detail{frameset}
		|		|		|
		|		|		|
		|		|		|
		|		|		|
		|		|		|------------OtherSetUpDetailTab.jsp/reviewsDetail.jsp/settingDetail.jsp/instructionsDetail.jsp/billingDetail.jsp -------detailUpper-[Frame]
		|		|		|Document ---detailUpperDoc
		|		|		|FormObect---detailUpperForm	  [form]  (Form name=detailUpperForm)
		|		|		|Reference from  this JSP will  be as parent.parent.parent.XXX()
		|		|		|
		|		|		|
		|		|		|
		|		|		|
		|		|		|------------OtherSetUpDetailForm.jsp/Blank.html/Blank.html/Blank.html/Blank.html---------------------------------------detailLower--[Frame]
		|		|		|			(only in case of OtherSetUp)
		|		|		|Document ---detailLowerDoc
		|		|		|FormObect---detailLowerForm		[form] (Form name=detailLowerForm)
		|		|		|Reference from  this JSP will  be as parent.parent.parent.XXX()
		|		|		|
		|
		|------MessageFrame------------------------------------------------------------------------------------------------->messageFrame---------[Frame]
		|
**/
/* Added by Kishore Kumar N on Sept 07 for CRF 0691 */
function showVaccineSearchBYText(obj)
{
	if(obj.value != '')
	{
		showVaccineSearch(obj.value);
	}
	else if(obj.value == '')
	{
		  document.getElementById('hidLinkedVaccineId').value = '';
	}
}

async function showVaccineSearch(val)
{
	var locale = document.getElementById('locale').value;
	var sql = "Select VACCINE_ID code,ca_get_desc.CA_IM_VACCINE(VACCINE_ID,'"+locale+"','2') description from CA_IM_VACCINE where eff_status='E' and upper(VACCINE_ID) like upper(?) and  upper(SHORT_DESC) like upper(?) order by 2";
	
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	argumentArray[0]	=  sql;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = ((val == undefined)|| (val == ''))?'':val;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;
	retVal = await CommonLookup( "Vaccine Name", argumentArray );
	var ret1=unescape(retVal);
	var arr=ret1.split(",");
		if(arr[1]==undefined) 
		{
			arr[0]="";	
			arr[1]="";	
		}
	var lnkVaccineId = document.getElementById('txtLinkedVaccineId');
	var hidVaccineId = document.getElementById('hidLinkedVaccineId');
	if (retVal != null && retVal != undefined && retVal != '')
	{
		lnkVaccineId.value = arr[1];
		hidVaccineId.value = arr[0];
	}
	else
	{
		lnkVaccineId.value = '';
		hidVaccineId.value = '';
	}
}

function displayLnkVaccine(obj)
{

	if (obj.value != 'MS' && obj.value !='')
	{
		document.getElementById('tblLinkedVanccineId').style.display='inline';
	}
	else
	{
		document.getElementById('tblLinkedVanccineId').style.display='none';
	}

}
//method added for disabling the settings-rows only for PH(15829)
function ptClsSettingDisableInPH()
{
	var frmObj=document.detailUpperForm;
	noOfRecords=frmObj.noOfRecords.value;
	module_id=frmObj.module_id.value;
	if(frmObj.defVal1)
		defaultPh=frmObj.defVal1.value;
	
	if(module_id=="PH" && defaultPh>0)
	{		
		for(i=0;i<=noOfRecords;i++)
		{
			eval('frmObj.setting_applicability'+i).disabled=true;
			eval('frmObj.age_group_code'+i).disabled=true;
			eval('frmObj.qty_value'+i).disabled=true;
			eval('frmObj.qty_uom'+i).disabled=true;
			eval('frmObj.freq_code'+i).disabled=true;			
			eval('frmObj.durn_value'+i).disabled=true;
			eval('frmObj.durn_desc'+i).disabled=true;
			eval('frmObj.max_durn_value'+i).disabled=true;
			eval('frmObj.max_durn_type'+i).disabled=true;
			eval('frmObj.chk_for_max_durn_action'+i).disabled=true;			
			//eval('frmObj.ord_auth_level'+i).disabled=false;			
		}
	}
}
/*ends here.*/
// ML-BRU-SCF-1288 - IN048083 Start
function clickAll(){
	var from = f_query_add_mod.detail.detailUpper.detailUpperForm.fm_disp.value;
	var to = f_query_add_mod.detail.detailUpper.detailUpperForm.to_disp.value;
	to = parseInt(to)+1;
	if(f_query_add_mod.detail.detailUpper.detailUpperForm.check_checked == true){
		for(from=from;from<to; from++){
			val = eval("f_query_add_mod.detail.detailUpper.detailUpperForm.applicable_yn"+from);
			val.checked = true;
		}
	}else{
		for(from=from;from<to; from++){
			val = eval("f_query_add_mod.detail.detailUpper.detailUpperForm.applicable_yn"+from);
			val.checked = false;
		} 
	}
}
function unCheckAll(obj) {
	
	if(eval("f_query_add_mod.detail.detailUpper.detailUpperForm.applicable_yn"+obj).checked == false) {
		f_query_add_mod.detail.detailUpper.detailUpperForm.check_checked = false;
	}
}
// ML-BRU-SCF-1288 - IN048083 End
//IN048467 - Start
function enableSkipAuth(index) {
	if(eval("f_query_add_mod.detail.detailUpper.detailUpperForm.ord_auth_reqd_yn"+index).checked == true){
		eval("f_query_add_mod.detail.detailUpper.detailUpperForm.skip_auth"+index).disabled = false;
	}
	else {
		eval("f_query_add_mod.detail.detailUpper.detailUpperForm.skip_auth"+index).selectedIndex = 0;
		eval("f_query_add_mod.detail.detailUpper.detailUpperForm.skip_auth"+index).disabled = true;
	}
}
//IN048467 - End
//IN063816 starts
function chkBarcode(obj)
{
		if(obj.checked == true)
		{
			detailLowerForm.barcode_reqd_yn.value="Y";
		}
		else
		{
			detailLowerForm.barcode_reqd_yn.value="N";
		}
		
}
//IN063816 ends

//IN065942, starts
function chkPrnRegStatus(obj)
{
	if(obj.checked)
	{
		detailLowerForm.prn_regd_ord.value = "Y";
	}
	else
	{
		detailLowerForm.prn_regd_ord.value = "N";
	}
}
//IN065942, ends

//IN64543, starts
function loadEditorContent(obj,currTabObj1,readOnly)
{	
	if(currTabObj1==undefined)
		currTabObj1 = "commentsInstrnTab";
	else	
		document.getElementById("currSelectedTab").value = currTabObj1.name;
		
	var currTab = document.getElementById("currSelectedTab").value;
	
	if("commentsInstrnTab" ==currTab)
	{
		currTabObj = "CMTS";
		currTabName = "Comments";
	}
	else if("prepInstrnTab" ==currTab)
	{
		currTabObj =  "PREPS";
		currTabName = "Preps";
	}
	else if("deptInstrnTab" ==currTab)
	{
		currTabObj =  "DEPT";
		currTabName = "Department Instruction";
	}
	else if("patInstrnTab" ==currTab)
	{
		currTabObj =  "PATIENT";
		currTabName = "Patient Instruction";
	}
	highlightTabs(currTabObj1);	
	document.getElementById('saveMsg').innerHTML="Click "+"<img src='../../eOR/images/Save.png'></img>"+" in Editor to Save "+ currTabName;//IN64543
	
	if("patInstrnTab" !=currTab)
		callInstantiateEditor(obj,null,readOnly);
	else
		loadMultValues(readOnly);
}

function saveCurrentContent()
{
	var currTabObj;
	var currTab = document.getElementById("currSelectedTab").value;

	if("prepInstrnTab"==currTab){
		currTabObj = "pat_preps_or_instrns_free_fmt_pr";
		document.getElementById(currTabObj).innerText = EditorGetHTML();
		//ML-MMOH-SCF-1108 start
		var HTMLVal = " <html><body><form name='dynamic_frame' id='dynamic_frame' method='post'  action='../../eOR/jsp/TempIntermediate.jsp' ><input type='hidden' name ='instrnContentSync' id ='instrnContentSync' value='"+currTabObj+"'/><textarea id='pat_preps_or_instrns_free_fmt_pr' name='pat_preps_or_instrns_free_fmt_pr' style='display:none'>"+document.getElementById(currTabObj).innerText+"</textarea></form></body></html>";
		top.frames[2].frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);		
		top.frames[2].frames[2].document.dynamic_frame.submit();
		//ML-MMOH-SCF-1108 end
	}
	else if("deptInstrnTab"==currTab){
		currTabObj = "pat_preps_or_instrns_free_fmt_dr";
		document.getElementById(currTabObj).innerText = EditorGetHTML();
		//ML-MMOH-SCF-1108 start
		var HTMLVal = " <html><body><form name='dynamic_frame' id='dynamic_frame' method='post'  action='../../eOR/jsp/TempIntermediate.jsp' ><input type='hidden' name ='instrnContentSync' id ='instrnContentSync' value='"+currTabObj+"'/><textarea id='pat_preps_or_instrns_free_fmt_dr' name='pat_preps_or_instrns_free_fmt_dr' style='display:none'>"+document.getElementById(currTabObj).innerText+"</textarea></form></body></html>";
		top.frames[2].frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);		
		top.frames[2].frames[2].document.dynamic_frame.submit();
		//ML-MMOH-SCF-1108 end
		
	}
	else if("patInstrnTab"==currTab){
  //ML-MMOH-SCF-1108 start
  //sendISToBean();
		var idInstrn 	 = EditorGetHTML();
		var instrnTypeObj = document.detailUpperForm.pat_instrns_free_fmt_id;
		var instrn_content_type = document.getElementById("instrn_content_type");
		var index		 = document.detailUpperForm.temp_index_holder.value;
		instrn_content_type[1]
		if(instrn_content_type[1].checked){
			instrn_content_type = "E";
		}
		if(instrnTypeObj[1].checked){
			instrnTypeObj="IM";
		}
		else {
			instrnTypeObj="IS";
		}
			if("IS"==instrnTypeObj){
			currTabObj = "pat_preps_or_instrns_free_fmt_is";
			var HTMLVal = " <html><body><form name='dynamic_frame' id='dynamic_frame' method='post'  action='../../eOR/jsp/TempIntermediate.jsp' ><input type='hidden' name ='instrnContentSync' id ='instrnContentSync' value='"+currTabObj+"'/><textarea id='pat_preps_or_instrns_free_fmt_is' name='pat_preps_or_instrns_free_fmt_is' style='display:none'>"+idInstrn+"</textarea></form></body></html>";
			top.frames[2].frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);		
			top.frames[2].frames[2].document.dynamic_frame.submit();
		}else if("IM"==instrnTypeObj){
			if(!finalChkLineLvl())
				return ;
			var sex	   = document.detailUpperForm.sex_spec_ind.value;
			var minAgeInYrs  = document.detailUpperForm.min_age_in_yrs.value;
			var minAgeInMths = document.detailUpperForm.min_age_in_mths.value;
			var minAgeInDays = document.detailUpperForm.min_age_in_days.value;
			var maxAgeInYrs  = document.detailUpperForm.max_age_in_yrs.value;
			var maxAgeInMths = document.detailUpperForm.max_age_in_mths.value;
			var maxAgeInDays = document.detailUpperForm.max_age_in_days.value;
			var index		 = document.detailUpperForm.temp_index_holder.value;
			var idInstrn 	 = EditorGetHTML();
			currTabObj = "pat_preps_or_instrns_free_fmt_im";
			var HTMLVal = " <html>" +
							"<body><form name='dynamic_frame' id='dynamic_frame' method='post'  action='../../eOR/jsp/TempIntermediate.jsp' >" +
							"<input type='hidden' name ='instrnContentSync' id ='instrnContentSync' value='"+currTabObj+"'/>" +
							"<textarea id='pat_preps_or_instrns_free_fmt_im' name='pat_preps_or_instrns_free_fmt_im' style='display:none'>"+idInstrn+"</textarea>" +
							"<input type='hidden' name ='sex' id ='sex' value='"+sex+"'/>"+
							"<input type='hidden' name ='minAgeInYrs' id ='minAgeInYrs' value='"+minAgeInYrs+"'/>"+
							"<input type='hidden' name ='minAgeInMths' id ='minAgeInMths' value='"+minAgeInMths+"'/>"+
							"<input type='hidden' name ='minAgeInDays' id ='minAgeInDays' value='"+minAgeInDays+"'/>"+
							"<input type='hidden' name ='maxAgeInYrs' id ='maxAgeInYrs' value='"+maxAgeInYrs+"'/>"+
							"<input type='hidden' name ='maxAgeInMths' id ='maxAgeInMths' value='"+maxAgeInMths+"'/>"+
							"<input type='hidden' name ='maxAgeInDays' id ='maxAgeInDays' value='"+maxAgeInDays+"'/>"+
							"<input type='hidden' name ='action' id ='action' value='IMDetails'/>"+
							"<input type='hidden' name ='index' id ='index' value='"+index+"'/>"+
							"</form></body></html>";
			top.frames[2].frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);		
			top.frames[2].frames[2].document.dynamic_frame.submit();
		}
		//ML-MMOH-SCF-1108 end
		
		
		
	}
}

function instrnRadioButton()
{		
	currObj = document.getElementById("instrn_content_type");

	if(currObj[0].checked == true)
	{
		document.getElementById('prep_instrn_td').style.display = 'inline';
		document.getElementById('dept_instrn_td').style.display = 'inline';
		document.getElementById('pat_instrn_td').style.display = 'inline';			
		document.getElementById('instrnEditorTabs').style.display = 'none';
		document.getElementById('contentEditor').style.display = 'none';
		document.getElementById('pat_instrn_details_table').style.display = 'none';
		document.getElementById('pat_preps_or_instrns_free_fmt_pr').value = "";	
		document.getElementById('pat_preps_or_instrns_free_fmt_dr').value = "";
		document.getElementById('pat_preps_or_instrns_free_fmt_is').value = "";
		clearPatInstrn();
		//clearBeforeInsertion();//IN64543
		//ageSexClearAllValues();//IN64543
		clearAllEditorValues();
		document.getElementById("pat_instrns_free_fmt_id")[0].checked=true;//IN64543
		document.getElementById("pat_preps_or_instrns_id")[0].checked=true;//IN64543
		EditorOnClear(document.getElementById("RTEditor0"));
		//document.getElementById("pat_preps_or_instrns_txt_pr").value = "";			
	}
	else if(currObj[1].checked == true)
	{
		//document.getElementById('pat_preps_or_instrns_free_fmt_pr').innerText = "";
		//document.getElementById('pat_preps_or_instrns_free_fmt_dr').innerText = "";
		document.getElementById('prep_instrn_td').style.display = 'none';
		document.getElementById('dept_instrn_td').style.display = 'none';
		document.getElementById('pat_instrn_td').style.display = 'none';
		document.getElementById('instrnEditorTabs').style.display = 'inline';		
		document.getElementById('contentEditor').style.display = 'inline';		
		document.getElementById("pat_preps_or_instrns_txt_pr").value = "";
		document.getElementById("pat_preps_or_instrns_txt_dr").value = "";
		//loadEditorContent(document.getElementById("pat_preps_or_instrns_free_fmt_pr"));		
		document.getElementById('prepInstrnTab').click();
	}		
}

/*function instrnRadioButtonOnLoad()
{		
	currObj = document.getElementById("instrn_content_type");
	
	if(currObj[0].checked == true)
	{
		document.getElementById('prep_instrn_td').style.display = 'inline';
		document.getElementById('dept_instrn_td').style.display = 'inline';
		document.getElementById('pat_instrn_td').style.display = 'inline';	
		document.getElementById('instrnEditorTabs').style.display = 'none';
		document.getElementById('contentEditor').style.display = 'none';
	}
	else if(currObj[1].checked == true)
	{
		document.getElementById('prep_instrn_td').style.display = 'none';
		document.getElementById('dept_instrn_td').style.display = 'none';
		document.getElementById('pat_instrn_td').style.display = 'none';
		document.getElementById('instrnEditorTabs').style.display = 'inline';
		document.getElementById('contentEditor').style.display = 'inline';			
	}		
}*/

function waitForCompleteLoad()
{	
	readOnly = document.getElementById("instrn_content_type_editor_updatable").value;
	if(document.getElementById("instrn_content_type").checked==true)
	{
		loadEditorContent(document.getElementById("pat_preps_or_instrns_free_fmt_pr"),null,readOnly);
	}
}

function clearPatInstrn()
{    	
	var bean_id=document.forms[0].bean_id.value;
	var bean_name=document.forms[0].bean_name.value;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " p_bean_id=\""+ bean_id + "\" ";
	xmlStr += " p_bean_name=\""+ bean_name + "\" ";
	xmlStr += " p_action=\"CLEAR_PAT_INSTRN\"";
	xmlStr +=" /></root>";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OrderCatalogIntermediate.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	return true;
}

function highlightTabs(obj)
{
	if(obj.name=='prepInstrnTab')
	{
		changeTabCSSClassName('prepInstrnTab','clicked');
		changeTabCSSClassName('deptInstrnTab','normal');
		changeTabCSSClassName('patInstrnTab','normal');
	}
	else if(obj.name=='deptInstrnTab')
	{
		changeTabCSSClassName('prepInstrnTab','normal');
		changeTabCSSClassName('deptInstrnTab','clicked');
		changeTabCSSClassName('patInstrnTab','normal');
	}
	else if(obj.name=='patInstrnTab')
	{
		changeTabCSSClassName('prepInstrnTab','normal');
		changeTabCSSClassName('deptInstrnTab','normal');
		changeTabCSSClassName('patInstrnTab','clicked');
	}
}

function changeTabCSSClassName(tabId,cssClassName)
{
	document.getElementById(tabId).className = cssClassName;
}
//IN64543, ends

//IN064543 starts
//function stdOrMult(){
function stdOrMult(readOnly){
	currObj = document.getElementById("pat_instrns_free_fmt_id");
	if(currObj[0].checked == true){
		document.getElementById('input_instrn').style.display = 'none';
		document.getElementById('input_instrn_btn').style.display = 'none';
		document.getElementById('result_instrn').style.display = 'none';
		clearBeforeInsertion();//IN64543
		ageSexClearAllValues(readOnly);//IN64543
		openEditorBoard();
	}
	else if(currObj[1].checked == true){
		document.getElementById('input_instrn').style.display = 'inline';
		document.getElementById('input_instrn_btn').style.display = 'inline';
		document.getElementById('result_instrn').style.display = 'inline';
		stdInstrnClearAllValues(readOnly);//ML-MMOH-SCF-1108
		closeEditorBoard(readOnly);
	}
}
function chkMonths(obj){

	if(obj.value == null || obj.value== "")
		return;

	if(!(parseFloat(obj.value) >= 0  && parseFloat(obj.value) <= 11)){
		obj.value ="";
		alert(getMessage("ENTER_MONTH_CHK","OR"));
		obj.focus();
	}
}
function chkDaysVal(obj){

	if(obj.value == null || obj.value== "")
		return;

	if(!(parseFloat(obj.value) >= 1  && parseFloat(obj.value) <= 30)){
		obj.value ="";
		alert(getMessage("ENTER_DAY_CHK","OR"));
		obj.focus();
	}
}
function finalChk(){
		if(document.getElementById("sex_spec_ind").value==""){
			checkField( document.getElementById("sex_spec_ind"), "Sex Field" );
			return false;
		}


		if(document.getElementById("min_age_in_yrs").value=="" && 	
				document.getElementById("min_age_in_days").value=="" &&
					 document.getElementById("min_age_in_mths").value==""  )   {
			alert(getMessage("ONE_ENTRY_MIN_AGE","OR"));
			return false;
		}	


		if(document.getElementById("min_age_in_yrs").value=="0" && 	
				document.getElementById("min_age_in_days").value=="0" &&
					 document.getElementById("min_age_in_mths").value=="0"  )   {
			alert(getMessage("ONE_ENTRY_MIN_AGE","OR"));
			return false;
		}	
		 

		 if(document.getElementById("max_age_in_yrs").value=="" && 	
				document.getElementById("max_age_in_days").value=="" &&
					 document.getElementById("max_age_in_mths").value==""  )   {
			alert(getMessage("ONE_ENTRY_MAX_AGE","OR"));
			return false;
		}	

		  
		if(!chkAgeEntries())
			return false;

		var idInstrn 	 = checkSpl(EditorGetHTML());
		if(idInstrn == ""){
			alert(getMessage("INSTRN_BLANK_CHK","OR"));
			return false;
		}
			
		return true;

	}

function finalChkLineLvl(){
	if(document.getElementById("sex_spec_ind").value==""){
		//checkField( document.getElementById("sex_spec_ind"), "Sex Field" );
		return false;
	}


	if(document.getElementById("min_age_in_yrs").value=="" && 	
			document.getElementById("min_age_in_days").value=="" &&
				 document.getElementById("min_age_in_mths").value==""  )   {
		return false;
	}	


	if(document.getElementById("min_age_in_yrs").value=="0" && 	
			document.getElementById("min_age_in_days").value=="0" &&
				 document.getElementById("min_age_in_mths").value=="0"  )   {
		return false;
	}	
	 

	 if(document.getElementById("max_age_in_yrs").value=="" && 	
			document.getElementById("max_age_in_days").value=="" &&
				 document.getElementById("max_age_in_mths").value==""  )   {
		return false;
	}	

	  
	if(!chkAgeEntriesLineLvl())
		return false;

	var idInstrn 	 = checkSpl(EditorGetHTML());
	if(idInstrn == ""){
		return false;
	}
		
	return true;

}
function chkAgeEntriesLineLvl(){

	if(parseFloat(chkYrs()) == -1 ){
		return false;
	}else if(parseFloat(chkYrs()) == 0 ){
		if(parseFloat(chkMnths()) == -1 ){
			return false;
		 }else if(parseFloat(chkMnths()) == 0 )
			 if(parseFloat(chkDays()) == -1 || parseFloat(chkDays()) == 0){
				return false;
		 }

   }
   return true;
}
function selectValues(){
	if(!finalChk())
		return ;
		getUserInputs();
}
function chkAgeEntries(){

	if(parseFloat(chkYrs()) == -1 ){
		alert(getMessage("MIN_MAX_AGE_CHECK","OR"));
		return false;
	}else if(parseFloat(chkYrs()) == 0 ){
		if(parseFloat(chkMnths()) == -1 ){
			alert(getMessage("MIN_MAX_AGE_CHECK","OR"));
			return false;
		 }else if(parseFloat(chkMnths()) == 0 )
			 if(parseFloat(chkDays()) == -1 || parseFloat(chkDays()) == 0){
				alert(getMessage("MIN_MAX_AGE_CHECK","OR"));
				return false;
		 }

   }
   return true;
}
function chkYrs(){
	return chkUtility(document.getElementById("min_age_in_yrs").value  ,document.getElementById("max_age_in_yrs").value  );
}

function chkMnths(){
	return chkUtility(document.getElementById("min_age_in_mths").value  ,document.getElementById("max_age_in_mths").value  );
}

function chkDays(){
	return chkUtility(document.getElementById("min_age_in_days").value  ,document.getElementById("max_age_in_days").value  );
}
function chkUtility(objMin,objMax){ //-1,0,1

	if(objMin == "")
	   objMin = 0;

	
	if(objMax == "")
	   objMax = 0;
	
	if(parseFloat(objMin)>parseFloat(objMax))
		return -1 ;
	if(parseFloat(objMin)==parseFloat(objMax))
		return 0 ;
	else
		return 1

}
function chkDaysVal(obj){

	if(obj.value == null || obj.value== "")
		return;

	if(!(parseFloat(obj.value) >= 1  && parseFloat(obj.value) <= 30)){
		obj.value ="";
		alert(getMessage("ENTER_DAY_CHK","OR"));
		obj.focus();
	}
}
function chkMonths(obj){

	if(obj.value == null || obj.value== "")
		return;

	if(!(parseFloat(obj.value) >= 0  && parseFloat(obj.value) <= 11)){
		obj.value ="";
		alert(getMessage("ENTER_MONTH_CHK","OR"));
		obj.focus();
	}
	}
function getUserInputs(){
	var index = document.detailUpperForm.temp_index_holder.value;
	var instrnTypeObj = document.detailUpperForm.pat_instrns_free_fmt_id;
	
	var actionCommand = "";
	if(index == ""){
		 actionCommand = "INSERTINPUTS";
	}else{
		 actionCommand = "MODIFYINPUTS";
	}
	if(instrnTypeObj[1].checked){
		instrnTypeObj="IM";
	}
	else {
		instrnTypeObj="IS";
	}
	
	
  //IN64543, starts
  var instrnType = document.getElementById("instrn_content_type");
	
	if(instrnType[1].checked){
		instrnType="E";
	}
	else {
		instrnType="T";
	}
  //IN64543, ends	

	var sex	   = document.detailUpperForm.sex_spec_ind.value;
	var minAgeInYrs = document.detailUpperForm.min_age_in_yrs.value;
	var minAgeInMths = document.detailUpperForm.min_age_in_mths.value;
	var minAgeInDays = document.detailUpperForm.min_age_in_days.value;
	var maxAgeInYrs = document.detailUpperForm.max_age_in_yrs.value;
	var maxAgeInMths = document.detailUpperForm.max_age_in_mths.value;
	var maxAgeInDays = document.detailUpperForm.max_age_in_days.value;
	var idInstrn 	 = checkSpl(EditorGetHTML());

	clearValuesInAllEditors();
	//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr += " action=\""+ actionCommand +"\" " ;
	if(index == ""){
		
	}else{
		xmlStr += " index=\""+ index +"\" " ;
	}
	
	xmlStr += " instructionType=\""+ instrnTypeObj +"\" " ;
	xmlStr += " instrn_content_type=\""+ instrnType +"\" " ;//IN64543
	xmlStr += " sex_spec_ind=\""+ sex +"\" " ;
	xmlStr += " min_age_in_yrs=\""+ minAgeInYrs + "\" ";
	xmlStr += " min_age_in_mths=\""+ minAgeInMths + "\" ";
	xmlStr += " min_age_in_days=\""+ minAgeInDays + "\" ";
	xmlStr += " max_age_in_yrs=\""+ maxAgeInYrs + "\" ";
	xmlStr += " max_age_in_mths=\""+ maxAgeInMths + "\" ";
	xmlStr += " max_age_in_days=\""+ maxAgeInDays + "\" ";
	xmlStr += " pat_preps_or_instrns_free_fmt_im=\""+ idInstrn + "\" ";
	xmlStr +=" /></root>" ;
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOR/jsp/OrderCatalogInstructionSync.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
}

function insertContentToRow(index,sexVal,minYearsVal,minMonthsVal,minDaysVal,maxYearsVal,maxMonthsVal,maxDaysVal){
	var readOnly = document.detailUpperForm.instrn_content_type_editor_updatable.value;
	var r=document.getElementById("inn_table").insertRow();
    r.setAttribute("id",index);
    var sex =r.insertCell();
    var anchorSex=document.createElement('a');
    anchorSex.setAttribute("href", "javascript:moveValuesToEditor('"+index+"')");
    if(sexVal=="M"){
    	sexVal="Male";
    }else if(sexVal=="F"){
    	sexVal="Female";
    }else if(sexVal=="N"){
    	sexVal="Both";
    }
    anchorSex.innerText=sexVal;
    sex.appendChild(anchorSex);
    var minYears =r.insertCell();
    minYears.innerText=minYearsVal;
    var minMonths =r.insertCell();
    minMonths.innerText=minMonthsVal;
    var minDays =r.insertCell();
    minDays.innerText=minDaysVal;
    var maxYears =r.insertCell();
    maxYears.innerText=maxYearsVal;
    var maxmonths =r.insertCell();
    maxmonths.innerText=maxMonthsVal;
    var maxDays =r.insertCell();
    maxDays.innerText=maxDaysVal;
    maxDays.innerText=maxDaysVal;
    var instrn =r.insertCell();
    instrn.innerText="Instrn";
    sex.height = "25px";
    minYears.height = "25px";
    minYears.height = "25px";
    minYears.height = "25px";
    minYears.height = "25px";
    minYears.height = "25px";
    minYears.height = "25px";
    clearValuesInAllEditors();
    //closeEditorBoard();
  	closeEditorBoard(readOnly);
}

function moveValuesToEditor(index){
	document.detailUpperForm.temp_index_holder.value = index;
	var readOnly = document.detailUpperForm.instrn_content_type_editor_updatable.value;
	//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr += " action=\"GETROWVALUES\" " ;
	xmlStr += " index=\""+ index +"\" " ;
	xmlStr += " readOnly=\""+ readOnly +"\" " ;
	xmlStr +=" /></root>" ;
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOR/jsp/OrderCatalogInstructionSync.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
}
function getSelectedCommentsToEditor(){
	var index = document.detailUpperForm.temp_index_holder.value;
	var readOnly = document.detailUpperForm.instrn_content_type_editor_updatable.value;
	//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr += " action=\"GETCOMMENTS\" " ;
	xmlStr += " index=\""+ index +"\" " ;
	xmlStr +=" /></root>" ;
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOR/jsp/OrderCatalogInstructionSync.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	//eval(responseText);//IN64543
	//loadContentInEditor(responseText);//IN64543
	loadContentInEditor(responseText,readOnly);//IN64543
	
}
function loadContentInRow(sex_spec_ind,min_age_in_yrs,min_age_in_mths,min_age_in_days,max_age_in_yrs,max_age_in_mths,max_age_in_days){
	document.detailUpperForm.sex_spec_ind.value	   = sex_spec_ind;
	document.detailUpperForm.min_age_in_yrs.value = min_age_in_yrs;
	document.detailUpperForm.min_age_in_mths.value = min_age_in_mths;
	document.detailUpperForm.min_age_in_days.value = min_age_in_days;
	document.detailUpperForm.max_age_in_yrs.value = max_age_in_yrs;
	document.detailUpperForm.max_age_in_mths.value = max_age_in_mths;
	document.detailUpperForm.max_age_in_days.value = max_age_in_days;
}
function loadContentInEditor(pat_preps_or_instrns_free_fmt_im,readOnly)
{
	openEditorBoard();
	instantiateEditor(null,readOnly);
	//EditorSetHTML(pat_preps_or_instrns_free_fmt_im);//IN64543
	setTimeout(function(){EditorSetHTML(pat_preps_or_instrns_free_fmt_im)},100);//IN64543
}
function clearValues(){
	var index=document.detailUpperForm.temp_index_holder.value;
	if(index==""){
		clearValuesInAllEditors();
	}else{
		document.detailUpperForm.temp_index_holder.value = index;
		//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;
		xmlStr += " action=\"CLEARVALUES\" " ;
		xmlStr += " index=\""+ index +"\" " ;
		xmlStr +=" /></root>" ;
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eOR/jsp/OrderCatalogInstructionSync.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		eval(responseText);
		document.detailUpperForm.temp_index_holder.value = "";
	}	
}

function clearContentInRow(index){
	var readOnly = document.detailUpperForm.instrn_content_type_editor_updatable.value;
	deleteRow(index);
	clearValuesInAllEditors();
	//closeEditorBoard();
	closeEditorBoard(readOnly);
}
function deleteRow(index)  
{   
    var row = document.getElementById(index);
    var table = row.parentNode;
    while ( table && table.tagName != 'TABLE' )
        table = table.parentNode;
    if ( !table )
        return;
    table.deleteRow(row.rowIndex);
}
function clearBeforeInsertion(){
	var size = document.getElementById("inn_table").rows.length;
	for(var i=size-1; i>=2; i--){
		document.getElementById("inn_table").deleteRow(i);
	}
}
function openEditorBoard(){
	var editorBoard = document.getElementById("contentEditor");
	editorBoard.style.display = "inline";
	//clearEditorContent();//IN64543
	//instantiateEditor();//IN64543
	editorBoard.scrollIntoView(true);
}
//function closeEditorBoard(){
function closeEditorBoard(readOnly){
	var editorBoard = document.getElementById("contentEditor");
	editorBoard.style.display = "none";
	//clearEditorContent();
	clearEditorContent(null,readOnly);
	instantiateEditor(null,readOnly);
}
function clearValuesInAllEditors(){
	document.detailUpperForm.sex_spec_ind.value	   = "";
	document.detailUpperForm.min_age_in_yrs.value = "";
	document.detailUpperForm.min_age_in_mths.value ="";
	document.detailUpperForm.min_age_in_days.value ="";
	document.detailUpperForm.max_age_in_yrs.value = "";
	document.detailUpperForm.max_age_in_mths.value = "";
	document.detailUpperForm.max_age_in_days.value = "";
	document.detailUpperForm.temp_index_holder.value = "";
	//clearEditorContent();
	clearEditorContent(null,readOnly);
}	
//function hideEditorOnLoad(instrnType){
function hideEditorOnLoad(readOnly){
	var instrn_content_type = document.getElementById("instrn_content_type");
	if(instrn_content_type[1].checked){
		instrn_content_type = 'E';
	}
	if(instrn_content_type=="E"){
		var editorBoard = document.getElementById("contentEditor");
		editorBoard.style.display = "none";
	}	
		var stdOrAge = document.detailUpperForm.pat_instrns_free_fmt_id;
		//stdOrMult();
		stdOrMult(readOnly);
		if(stdOrAge[0].checked){
			openEditorBoard();
		}
}
function openEditorOnLoad(){
	var instrn_content_type = document.getElementById("instrn_content_type");
	if(instrn_content_type[1].checked){
		instrn_content_type = 'E';
	}
	if(instrn_content_type=="E"){
		document.getElementById("pat_instrn_details_table").style.display='none';	//kamal
		var editorBoard = document.getElementById("contentEditor");
		editorBoard.style.display = "inline";
	}	
}
function loadMultValues(readOnly){
	document.getElementById("pat_instrn_details_table").style.display='inline';
	var instrnTypeObj = document.detailUpperForm.pat_instrns_free_fmt_id;

	if(instrnTypeObj[1].checked){
		instrnTypeObj="IM";
	}
	else {
		instrnTypeObj="IS";
	}

	//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr += " action=\"ONLOADCONTENTS\" " ;
	xmlStr += " instructionType=\""+ instrnTypeObj +"\" " ;
	xmlStr += " readOnly=\""+ readOnly +"\" " ;
	xmlStr +=" /></root>" ;
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOR/jsp/OrderCatalogInstructionSync.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	//eval(responseText);//IN64543
	if(instrnTypeObj=='IS')
		loadContentInEditor(responseText,readOnly);//IN64543
	else if(instrnTypeObj=='IM')
		eval(responseText);
}

function sendISToBean(){

	var idInstrn 	 = checkSpl(EditorGetHTML());
	var instrnTypeObj = document.detailUpperForm.pat_instrns_free_fmt_id;
	var instrn_content_type = document.getElementById("instrn_content_type");

	instrn_content_type[1]
	if(instrn_content_type[1].checked){
		instrn_content_type = "E";
	}
	if(instrnTypeObj[1].checked){
		instrnTypeObj="IM";
	}
	else {
		instrnTypeObj="IS";
	}
	//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr += " action=\"STDINSTRN\" " ;
	xmlStr += " instructionType=\""+ instrnTypeObj +"\" " ;
	xmlStr += " instrn_content_type=\""+ instrn_content_type +"\" " ;
	xmlStr += " pat_preps_or_instrns_free_fmt_is=\""+ idInstrn + "\" ";
	xmlStr +=" /></root>" ;
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOR/jsp/OrderCatalogInstructionSync.jsp",false);
	xmlHttp.send(xmlDoc);
	//responseText=xmlHttp.responseText ;	
	//eval(responseText);
}
function cancelValues(){
	clearValuesInAllEditors();
	document.detailUpperForm.temp_index_holder.value = "";
}

//IN64543, starts
//function ageSexClearAllValues()
function ageSexClearAllValues(readOnly)
{		
	//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr += " action=\"AGE_SEX_CLEAR_ALL_VALUES\" " ;
	xmlStr += " readOnly=\""+ readOnly +"\" " ;
	xmlStr +=" /></root>" ;
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOR/jsp/OrderCatalogInstructionSync.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
}
////ML-MMOH-SCF-1108 start
function stdInstrnClearAllValues(){
	//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr += " action=\"STD_INSTRN_CLEAR_ALL_VALUES\" " ;
	xmlStr += " readOnly=\""+ readOnly +"\" " ;
	xmlStr +=" /></root>" ;
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOR/jsp/OrderCatalogInstructionSync.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
}

function clearAllEditorValues(){
	//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr += " action=\"CLEAR_ALL_EDITOR_VALUES\" " ;
	xmlStr += " readOnly=\""+ readOnly +"\" " ;
	xmlStr +=" /></root>" ;
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOR/jsp/OrderCatalogInstructionSync.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
}
//ML-MMOH-SCF-1108 end
function textAgeSexClearAllValues()
{		
	/*var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr += " action=\"TEXT_AGE_SEX_CLEAR_ALL_VALUES\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOR/jsp/OrderCatalogInstructionSync.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);*/
	
	var xmlStr ="<root><SEARCH " ;
		xmlStr += " action=\"TEXT_AGE_SEX_CLEAR_ALL_VALUES\" ";
		xmlStr +=" /></root>" ;
    // Parse the XML string
    var parser = new DOMParser();
    var xmlDoc = parser.parseFromString(xmlStr, "text/xml");
    // Create an XMLHttpRequest object
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("POST", "../../eOR/jsp/OrderCatalogInstructionSync.jsp", false);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    // Send the XML
    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));
    // Handle the response
    var responseText = xmlHttp.responseText;
    responseText = trimString(responseText); 
	
}	
//IN64543, ends
function clearOnReset(bean_id,bean_name)//IN068370,IN068373, starts
{
	var xmlStr ="<root><SEARCH ";
	xmlStr += " p_bean_id=\""+ bean_id + "\" ";
	xmlStr += " p_bean_name=\""+ bean_name + "\" ";
	xmlStr += " p_action=\"CLEAR_MAPPED_FACS\"";
	xmlStr +=" /></root>";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OrderCatalogIntermediate.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
}//IN068370,IN068373, ends
//7540 Starts
function chkFreqSplitIndivialOrd(Obj){
	getHandleDetailLower();
	if(Obj.checked == true){
		detailLowerForm.freq_order_split_indvi_yn.value="Y";
	}
	else{
		detailLowerForm.freq_order_split_indvi_yn.value="N";
	}
	//7540 Ends
}

