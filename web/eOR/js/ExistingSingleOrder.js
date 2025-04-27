/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
24/11/2011    IN029659       Chowminya G    Incident No: IN029659 - <System allows to place the new orders using Copy Previous Order function- CRF Linked Issue> 
19/10/2012    IN033061      Chowminya G  System doesnt display menu cancel/discontinue if the orders are IV Fluid ,IV Fluid+Drug, IV Fluid+Drug(Frequency). 
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Review Date   Review By          Description
--------------------------------------------------------------------------------------------------------------
14/10/2019  IN071315	     Nijitha S    14/10/2019     Ramesh G      		GHL-CRF-0607
14/10/2020		IN073985		SIVABAGYAM M	14/10/2020	RAMESH G	ML-MMOH-SCF-1607
28/02/2022      IN27707         Suji Keerthi.G      28/02/2022      Ramesh G        SKR-CRF-0052  
---------------------------------------------------------------------------------------------------------------
*/
var function_id 	= "" ;
var result 			= false; 
var message 		= "" ;
var flag 			= "" ;
var qry_string 		= "";
var totCountGlobal 	= "";
var errorMessage	= "";

async function callMultipleConsent(order_type_code,catalog_code,catalog_desc,order_id,order_line_num,order_category,index){

	var dialogHeight		= '37.5vh';
	var dialogWidth			= '50vw';
	var dialogTop			= '150';
	var dialogLeft			= '100' ;
	var title				= ''
	var	arguments			= "";	
	var	features			= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + ';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var bean_id				=  "";
	var bean_name			=  "";
	bean_id		= document.existing_order_dtl.bean_id.value;
	bean_name	= document.existing_order_dtl.bean_name.value;
	var retVals				=  await window.showModalDialog("../../eOR/jsp/ExistingOrderMultipleConsentFrameSet.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&index="+index+"&consent_form_id="+"&order_catalog_code="+catalog_code+"&order_catalog_desc="+catalog_desc+"&order_id="+order_id+"&order_line_num="+order_line_num+"&order_category="+order_category+"&order_type_code="+order_type_code+"&viewBy=line",arguments,features);
}
async function callMultipleConsentHdr(order_type_code,order_id,order_category,index){
	var dialogHeight		= '37.5vh';
	var dialogWidth			= '50vw';
	var dialogTop			= '150';
	var dialogLeft			= '100' ;
	var title				= ''
	var	arguments			= "";	
	var	features			= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + ';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var bean_id				=  "";
	var bean_name			=  "";
	bean_id		= document.existing_order_dtl.bean_id.value;
	bean_name	= document.existing_order_dtl.bean_name.value;
	var retVals				=  await window.showModalDialog("../../eOR/jsp/ExistingOrderMultipleConsentFrameSet.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&index="+index+"&order_id="+order_id+"&order_category="+order_category+"&order_type_code="+order_type_code+"&viewBy=header",arguments,features);
}


/*function populateOrderTyoes(ord_cat){

	if( ord_cat.value == "" ) {
		clearList("document")
	}
	var bean_id = document.existing_order_search.bean_id.value ;
	var localeName		= document.existing_order_search.localeName.value ;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr += ord_cat.name+"=\""+ ord_cat.value +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ExistingOrderValidate1.jsp?bean_id=" + bean_id + "&validate=ord_cat&localeName="+localeName, false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText ) ;
}*/

/*function populateActivity(){

	var bean_id			= document.existing_order_search.bean_id.value ;
	var order_category	= document.existing_order_search.order_category.value ;
	var order_type		= document.existing_order_search.order_type.value ;
	var localeName		= document.existing_order_search.localeName.value ;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr += "order_category=\""+ order_category +"\" " ;
	xmlStr += "order_type=\""+ order_type +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ExistingOrderValidate1.jsp?bean_id=" + bean_id + "&validate=order_type&localeName="+localeName, false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	
	eval(responseText ) ;
}*/



/*function addOrderTypeList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.existing_order_search.order_type.add(element);
}*/

/*function clearList( docObj ) {
	var len = eval(docObj+".existing_order_search.order_type.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".existing_order_search.order_type.remove(\"atc_class_l2_code\")") ;
	}
	var tp = "     --- "+getLabel("Common.defaultSelect.label","Common")+" ---     " ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".existing_order_search.order_type.add(opt)") ;


	
}*/


/*function addActivityTypeList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.existing_order_search.activity_type.add(element);
}*/

/*function clearActivityList( docObj ) {
	var len = eval(docObj+".existing_order_search.activity_type.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".existing_order_search.activity_type.remove(\"activity_type\")") ;
	}
	var tp = "     --- "+getLabel("Common.defaultSelect.label","Common")+" ---     " ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".existing_order_search.activity_type.add(opt)") ;


	 
}*/

//this fucntion is used to clear the entries of search criteria
function resetValues()
{
}


//this is used for patient ID search
async function callPatientSearch()
{
	var pat_id = await PatientSearch();

	if(pat_id != null)
	document.getElementById("patientId").value = pat_id;
}

//called on click of search //Modified for IN27707
function populateValues(val)
{
	var from_date = document.existing_order_search.date_from ;
	var to_date  = document.existing_order_search.date_to ;
	var localeName = document.existing_order_search.localeName.value;
	//var order_category = document.existing_order_search.order_category.value;
	//if(doDateCheckOR(from_date,to_date) == 1) { // this function is available in eOR/js/orCommonFunctions.js		
	if(!isAfter(to_date.value,from_date.value,"DMY",localeName))
	{//this is added in place of doDateCheckOR		
		alert(getMessage("TO_DT_GR_EQ_FM_DT","SM")); // this message available in messages.js of ecommon/js
		return false
	}
	elapsed_orders = "";
	if(document.existing_order_search.elapsed_orders)
	{
		elapsed_orders = document.existing_order_search.elapsed_orders.value;
	}
	sys_cancelled_orders = "";
	if(document.existing_order_search.sys_cancelled_orders)
	{
		sys_cancelled_orders = document.existing_order_search.sys_cancelled_orders.value;
	}
	catalog = document.existing_order_search.catalog.value;

	 //qry_string = "patientId="+document.existing_order_search.patientId.value+"&encntr_id="+document.existing_order_search.encntr_id.value+"&ord_status="+document.existing_order_search.ord_status.value+"&order_by="+document.existing_order_search.order_by.value+"&catalog="+encodeURIComponent(catalog)+"&view="+document.existing_order_search.view.value+"&priority="+document.existing_order_search.priority.value+"&date_from="+document.existing_order_search.date_from.value+"&date_to="+document.existing_order_search.date_to.value+"&order_category="+document.existing_order_search.order_category.value+"&order_type="+document.existing_order_search.order_type.value+"&view_by="+document.existing_order_search.view_by.value+"&search_criteria="+document.existing_order_search.search_criteria.value+"&cosign="+document.existing_order_search.cosign.value+"&activity_type="+document.existing_order_search.activity_type.value+"&elapsed_orders="+elapsed_orders+"&sys_cancelled_orders="+sys_cancelled_orders;//Menaka
	 //qry_string = "patientId="+document.existing_order_search.patientId.value+"&encntr_id="+document.existing_order_search.encntr_id.value+"&ord_status="+document.existing_order_search.ord_status.value+"&order_by="+document.existing_order_search.order_by.value+"&catalog="+encodeURIComponent(catalog)+"&view="+document.existing_order_search.view.value+"&priority="+document.existing_order_search.priority.value+"&date_from="+document.existing_order_search.date_from.value+"&date_to="+document.existing_order_search.date_to.value+"&order_category="+document.existing_order_search.order_category.value+"&order_type="+document.existing_order_search.order_type.value+"&view_by="+document.existing_order_search.view_by.value+"&search_criteria="+document.existing_order_search.search_criteria.value+"&cosign="+document.existing_order_search.cosign.value+"&activity_type="+document.existing_order_search.activity_type.value+"&elapsed_orders="+elapsed_orders+"&sys_cancelled_orders="+sys_cancelled_orders+"&group_by="+document.existing_order_search.group_by.value+"&order_frequency="+document.existing_order_search.order_frequency.value;//Menaka
	 qry_string = "patientId="+document.existing_order_search.patientId.value+"&encntr_id="+document.existing_order_search.encntr_id.value+"&ord_status="+document.existing_order_search.ord_status.value+"&order_by="+document.existing_order_search.order_by.value+"&catalog="+encodeURIComponent(catalog)+"&view="+document.existing_order_search.view.value+"&priority="+document.existing_order_search.priority.value+"&date_from="+document.existing_order_search.date_from.value+"&date_to="+document.existing_order_search.date_to.value+"&order_type="+document.existing_order_search.order_type.value+"&view_by="+document.existing_order_search.view_by.value+"&search_criteria="+document.existing_order_search.search_criteria.value+"&cosign="+document.existing_order_search.cosign.value+"&activity_type="+document.existing_order_search.activity_type.value+"&elapsed_orders="+elapsed_orders+"&sys_cancelled_orders="+sys_cancelled_orders+"&group_by="+document.existing_order_search.group_by.value+"&order_frequency="+document.existing_order_search.order_frequency.value+"&call_from="+val;//Menaka//IN27707
	  
	var qry_string_fr_ammend = "&pract_reln_id="+document.existing_order_search.pract_reln_id.value+"&location_type="+document.existing_order_search.location_type.value+"&location_code="+document.existing_order_search.location_code.value+"&patient_class="+document.existing_order_search.patient_class.value+"&p_called_from_ca="+document.existing_order_search.p_called_from_ca.value+"&sex="+document.existing_order_search.sex.value+"&age="+document.existing_order_search.age.value+"&dob="+document.existing_order_search.dob.value+"&visit_adm_date="+document.existing_order_search.visit_adm_date.value+"&function_from="+document.existing_order_search.function_from.value
	document.existing_order_search.search.disabled = true;
	
	//parent.ExistingOrderHeader.location.href = "../jsp/ExistingOrderHeader.jsp?"+qry_string+qry_string_fr_ammend
	parent.ExistingOrderResult.location.href = "../jsp/ExistingSingleOrderResultsFrameset.jsp?"+qry_string+qry_string_fr_ammend
}

//called on click of clear button in search criteria
function clearValues(){
	document.existing_order_search.search.disabled = false;
	document.existing_order_search.reset();
	displayElapsedFields(document.existing_order_search.ord_status);
	//clearList( "document" )
	//clearActivityList( "document" )
	//parent.ExistingOrderHeader.location.href = "../../eCommon/html/blank.html"
	parent.ExistingOrderResult.location.href = "../../eCommon/html/blank.html"
}

function clearCopySearchValues(){
	//document.copy_orders_search.reset();
	finalstring=document.copy_orders_search.querystring.value;
	finalstring=finalstring+"&clear=clear"
	parent.CopyOrdersSearch.location.href="../../eOR/jsp/CopyOrdersSearch.jsp?"+finalstring;
	parent.CopyOrdersHdr.location.href = "../../eCommon/html/blank.html"
	parent.CopyOrdersResults.location.href = "../../eCommon/html/blank.html"
	parent.CopyOrdersResultsBottom.location.href = "../../eCommon/html/blank.html"
	parent.CopyOrdersBtn.location.href = "../../eCommon/html/blank.html"
}


function printValues(){
	var no_of_checked = 0;
	var formObj = "";
	//var localeName=parent.ExistingOrderResult.ExistingOrderResult.document.existing_order_dtl.localeName.value;
	if(parent.ExistingOrderResult.ExistingOrderResult && parent.ExistingOrderResult.ExistingOrderResult.document.existing_order_dtl)
		formObj = parent.ExistingOrderResult.ExistingOrderResult.document.existing_order_dtl;

	if(formObj){
		for(cnt=0; cnt<formObj.total_recs.value; cnt++){
			val = eval("parent.ExistingOrderResult.ExistingOrderResult.document.existing_order_dtl.chk"+cnt);
		
			if(val.checked == true){
				val.value = "Y";
				no_of_checked++;
			}
		}
	}
	if(parseInt(no_of_checked) == 0){
		alert(getMessage('CLICK_ANY_ONE','OR'))
		return false
	}
	var bean_id = formObj.bean_id.value ;
		
	//alert(formApply( parent.ExistingOrderResult.ExistingOrderResult.document.existing_order_dtl,OR_CONTROLLER)) ;

	
	eval(formApply( parent.ExistingOrderResult.ExistingOrderResult.document.existing_order_dtl,"../../eOR/jsp/ExistingOrderPrintValidate.jsp")) ;
	//if( result ) {
		onSuccess();
	//}
}

function assignResult(_result, _message, _flag){
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

function onSuccess() {
	//alert(message)
	//alert("APP-OR0148 Report has been Submitted to the Printer");
	alert(getMessage("RPT_SUBMIT_TO_PRINTER","OR"));
//	parent.ExistingOrderResult.location.href = "../../eCommon/html/blank.html"
}


// this function is called on clicking of the checkbox to select all the checkboxes
// in the page where all the records getiing displayed
function clickAll(){
   var existingorder;
   var clicked_from="";
   if(document.existing_order_hdg)
	{
		clicked_from=document.existing_order_hdg;
	}
	else
	{
		clicked_from=document.all;
	}
	if(clicked_from.select_all.checked == true){

		
		if(parent.ExistingOrderResult.ExistingOrderResult)
			existingorder=parent.ExistingOrderResult.ExistingOrderResult;
		else
			existingorder=parent.ExistingOrderResult;

		for(cnt=0; cnt<existingorder.document.existing_order_dtl.total_recs.value; cnt++){
			  val = eval("existingorder.document.existing_order_dtl.chk"+cnt);
			  val.checked = true;
		}
	}else{

		if(parent.ExistingOrderResult.ExistingOrderResult)
			existingorder=parent.ExistingOrderResult.ExistingOrderResult;
		else
			existingorder=parent.ExistingOrderResult;

		for(cnt=0; cnt<existingorder.document.existing_order_dtl.total_recs.value; cnt++){
			val = eval("existingorder.document.existing_order_dtl.chk"+cnt);
			val.checked = false;
		}
	}
}

function clearChecked(){
	parent.RegisterOrderHeader.document.register_order_hdg.reset()
	parent.RegisterOrderResult.document.register_order_dtl.reset()
}



function checkDateRange(obj,from){

	var fromDate = eval("document."+from+".date_from")
	var toDate = eval("document."+from+".date_to")
    var localeName = eval("document."+from+".localeName")

	if(validDateObj(obj,"DMY",localeName.value))
	{

		if(!isAfter(toDate.value,fromDate.value,"DMY",localeName.value)){
			
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM")); // this message available in messages.js of ecommon/js
			obj.focus()
			return false
		}
	
	}
	else
	{
		//this code is added for thai date conversions
		var temp;
	if(parent.ExistingOrderSearch)
		temp=parent.ExistingOrderSearch.document.existing_order_search;
	else
		temp=document.copy_orders_search;
	   temp.date_to.value= temp.temp_curr_sys_date.value;//end 
//parent.ExistingOrderSearch.document.existing_order_search.date_to.value= parent.ExistingOrderSearch.document.existing_order_search.temp_curr_sys_date.value;
	}
}

async function callMenuFunctions(colval1,patient_id,ord_cat,colval,orderId,cont_order_ind,order_status,sex,ord_typ_code,catalog_code,encounter_id,pat_class,location_code,location_type,episode_id,episode_visit_num){

	if(ord_typ_code==null)
		ord_typ_code="";

		colval=unescape(colval)
		if(colval1=="Hold")
		{
			var dialogHeight ='17vh' ;
			var dialogWidth = '25vw' ;
			var dialogTop	= '189';
			var dialogLeft = '167' ;
		}else if(colval1=="Resume")
		{
			var dialogHeight ='10vh' ;
			var dialogWidth = '40vw' ;
			var dialogTop	= '189';
			var dialogLeft = '167' ;
		}
		else if(colval1 == "Discontinue"||colval1=="Cancel") 
		{		
			var dialogHeight ='22vh' ;
			var dialogWidth = '25vw' ;
			var dialogTop	= '189';
			var dialogLeft = '167' ;
		}
		else if(colval1=="LinkToCurrentEncounter")
		{
			var dialogHeight ='100vh' ;
			var dialogWidth = '100vw' ;
			var dialogTop	= '100';
			var dialogLeft = '30' ;
		}
		else
		{
			/*var dialogHeight ='35' ;
			var dialogWidth = '60' ;
			var dialogTop	= '129';
			var dialogLeft = '11' ;*/
			var dialogHeight ='37.5vh' ;
			var dialogWidth = '50vw' ;
			var dialogTop	= '100';
			var dialogLeft = '100' ;
		}

		var title = 'rewe'
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';

		var arguments = "";
		if((colval1=="ViewReplacedOrder")||(colval1=="ViewOriginalOrder"))
		{
			//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
			var xmlHttp = new XMLHttpRequest() ;
			var bean_id				=  "";
			var bean_name			=  "";
			bean_id		  = document.existing_order_dtl.bean_id.value;
			bean_name	  = document.existing_order_dtl.bean_name.value;
			var func_mode = colval1;
			xmlStr ="<root><SEARCH " ;
			xmlStr += " orderId=\""+ orderId +"\" " ;
			xmlStr +=" /></root>" ;
			var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "ExistingOrderValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate="+func_mode,false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText = xmlHttp.responseText ;
			if((responseText!=null)||(responseText!=undefined))
				orderId = responseText;
		}
		

		var finalString	= "from=header&colval1="+colval1+"&colval="+encodeURIComponent(colval)+"&orderId="+orderId+"&val1="+ord_cat+"&patient_id="+patient_id+"&cont_order_ind="+cont_order_ind+"&order_status="+order_status+"&sex="+sex+"&ord_cat="+colval+"&ord_typ_code="+ord_typ_code+"&catalog_code="+catalog_code+"&ord_cat_id="+ord_cat+"&encounter_id="+encounter_id+"&patient_class="+pat_class;
	
		if(colval1 == "LinkToCurrentEncounter")
		{
			var futureOrderString	= "called_from=ExistingOrder&colval1="+colval+ "&colval=" +colval+"&orderId="+ orderId+"&ord_cat="+ ord_cat+"&ord_typ_code="+ ord_typ_code+"&catalog_code="+ catalog_code+"&p_patient_id="+ patient_id+"&cont_order_ind="+ cont_order_ind+"&order_status="+ order_status+"&sex="+ sex+ colval+"&p_encounter_id="+encounter_id+"&p_patient_class="+pat_class+"&can_reason="+colval+"&p_source_code="+location_code+"&p_source_type="+location_type+"&p_episode_id="+episode_id+"&p_episode_visit_num="+episode_visit_num;
			 var retVals = await window.showModalDialog("../../eOR/jsp/FutureOrderDtl.jsp?"+futureOrderString,arguments,features);
		}
		else
		{
			var retVals = await window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);
		}
	
 		if(colval1 != "View" && colval1!="ViewReplacedOrder" && colval1!="ViewOriginalOrder")
			reloadValues();
}

async function callRenewFunctions(orderId,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,sex,age,dob,visit_adm_date,iv_prep_yn,colval1,queryString){
		//unescape(colval)

			var dialogHeight ='15vh' ;
			var dialogWidth = '50vw' ;
			var dialogTop	= '105';
			var dialogLeft = '167' ;

		var title = 'rewe'
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

		var arguments = "";
		var amend_called_from = "existing_order";

		var finalString = queryString + "&order_id="+orderId+"&order_line_num=";



		var retVals = await window.showModalDialog("../../eOR/jsp/ExistingOrderRenewFrameset.jsp?"+finalString,arguments,features);

			reloadValues();

}

async function callRenewFunctions1(colval1,val1,ord_cat,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn,queryString) {


	var dialogHeight ='15vh' ;
	var dialogWidth = '50vw' ;
	var dialogTop	= '105';
	var dialogLeft = '167' ;

	var title = 'rewe';
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

	var arguments = "";
	amend_called_from = "existing_order";

	var finalString = queryString + "&order_id="+orderId+"&order_line_num="+order_line_num;



	var retVals = await window.showModalDialog("../../eOR/jsp/ExistingOrderRenewFrameset.jsp?"+finalString,arguments,features);



		reloadValues();

}

async function callAmmendFunctions(orderId,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,sex,age,dob,visit_adm_date,iv_prep_yn,colval1){
		//unescape(colval)
		//var dialogHeight ='32' ;
			//var dialogWidth = '60' ;
			//var dialogTop	= '105';
			//var dialogLeft = '147' ;

	if(location_type==null||location_type==undefined)
	{
		location_type="R";
	}
	if(location_code==null||location_code==undefined)
	{
		location_code="";
	}
			/*var dialogHeight ='38' ;
			var dialogWidth = '64' ;
			var dialogTop	= '105';
			var dialogLeft = '167' ;*/
			var dialogHeight ='45vh' ;
			var dialogWidth = '100vw' ;
			var dialogTop	= '100';
			var dialogLeft = '100' ;

		var title = 'rewe'
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

		var arguments = "";
		var amend_called_from = "existing_order";

		var finalString = "ammend_called_from="+amend_called_from+"&order_id="+orderId+"&patient_id="+patient_id+"&episode_id="+encntr_id+"&pract_reln_id="+pract_reln_id+"&location_type="+location_type+"&location_code="+location_code+"&patient_class="+patient_class+"&p_called_from_ca="+p_called_from_ca+"&Sex="+sex+"&Age="+age+"&Dob="+dob+"&visit_adm_date="+visit_adm_date+"&iv_prep_yn="+iv_prep_yn;

		if (colval1 == "Renew") {
			finalString += "&function_from=RENEW_ORDER";
		} else if (colval1 == "Ammend") {
			finalString += "&function_from=AMEND_ORDER";
		}
  		

		var retVals = await window.showModalDialog("../../eOR/jsp/EnterOrder.jsp?"+finalString,arguments,features);

		if(p_called_from_ca!="PH")
			reloadValues(); 

}

async function callAmmendFunctions1(colval1,val1,ord_cat,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn) {


	/*var dialogHeight ='32' ;
	var dialogWidth = '60' ;
	*/
	if(location_type==null||location_type==undefined)
	{
		location_type="R";
	}
	if(location_code==null||location_code==undefined)
	{
		location_code="";
	}
	
	var dialogHeight ='99vh' ;
	var dialogWidth = '99vw' ;
	var dialogTop	= '2';
	var dialogLeft = '9' ;
	var title = 'rewe';
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

	var arguments = "";
	amend_called_from = "existing_order";

	var finalString = "ammend_called_from="+amend_called_from+"&order_id="+orderId+"&patient_id="+patient_id+"&episode_id="+encntr_id+"&pract_reln_id="+pract_reln_id+"&location_type="+location_type+"&location_code="+location_code+"&patient_class="+patient_class+"&p_called_from_ca="+p_called_from_ca+"&Sex="+sex+"&Age="+age+"&Dob="+dob+"&visit_adm_date="+visit_adm_date+"&iv_prep_yn="+iv_prep_yn+"&order_line_num="+order_line_num+"&catalog_code="+catalog_code;


    if (colval1 == "Renew") {
		finalString += "&function_from=RENEW_ORDER";
	} else if (colval1 == "Amend") {
		finalString += "&function_from=AMEND_ORDER";
	}


	var retVals = await top.window.showModalDialog("../../eOR/jsp/EnterOrder.jsp?"+finalString,arguments,features);

	if(p_called_from_ca!="PH")
		reloadValues();
}

//function callMenuFunctions1(colval1,colval,orderId){
//Passing iv_prep_yn --[IN033061]
//function callMenuFunctions1(colval,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,cont_order_ind,order_status,sex,ord_typ_code,encntr_id,pat_class,location_code,location_type,episode_id,episode_visit_num,iv_prep_yn){//IN64543
//function callMenuFunctions1(colval,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,cont_order_ind,order_status,sex,ord_typ_code,encntr_id,pat_class,location_code,location_type,episode_id,episode_visit_num,iv_prep_yn,line){//IN64543
async function callMenuFunctions1(colval,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,cont_order_ind,order_status,sex,ord_typ_code,encntr_id,pat_class,location_code,location_type,episode_id,episode_visit_num,iv_prep_yn,line,p_called_from_ca){//IN64543//Added for IN071315
	unescape(colval)
	
	var instrn_type = eval("document.existing_order_dtl.instrn_type"+line+".value");//IN64543
	//unescape(item_narration)
  	//for(var i=0;i<=item_narration;i++)
		item_narration =eval('document.existing_order_dtl.item_narration'+item_narration).value;
		

		if(item_narration==null)	item_narration="";
		if(colval == "Instructions")
		{
      //IN64543, start
			//var dialogHeight ='10.5' ;	
			//var dialogWidth = '36' ;
			var dialogHeight ='33vh' ;
			var dialogWidth = '40vw' ;
      //IN64543, ends
			var dialogTop	= '189';
			var dialogLeft = '167' ;
			//IN64543, start
			if("E" == instrn_type)
			{
				dialogHeight ='40vh' ;
				dialogWidth = '40vw' ;
			}
			//IN64543, ends
		} //Modified by Uma on 2/11/2010 for package billing
		else if ((colval == "View") || (colval=="ViewReplacedOrder") || (colval=="ViewOriginalOrder") || (colval=="Replace")) 
		{
				var dialogHeight ='50vh' ;
				var dialogWidth = '50vw' ;
				var dialogTop	= '100';
				var dialogLeft = '30' ;
		} 
		else if(colval=="Cancel"||colval=="Discontinue"||colval=="Hold")
		{
			if((iv_prep_yn == "1" || iv_prep_yn == "2" || iv_prep_yn == "3" || iv_prep_yn == "4" || iv_prep_yn == "5") && colval=="Cancel")// --[IN033061]
			{
				var dialogHeight ='37.5vh' ;
				var dialogWidth = '50vw' ;
				var dialogTop	= '100';
				var dialogLeft = '30' ;
			}
			else
			{
			var dialogHeight ='37vh' ;
			var dialogWidth = '25vw' ;
			var dialogTop	= '189';
			var dialogLeft = '167' ;
			}
		}
		else if(colval=="Preps"||colval=="Comments")
		{
			//IN64543, starts
      //var dialogHeight ='12' ;
			//var dialogWidth = '30' ;
			var dialogHeight ='30vh' ;
			var dialogWidth = '30vw' ;
      //IN64543, ends
			var dialogTop	= '189';
			var dialogLeft = '167' ;
			
			//IN64543, start
			if("E" == instrn_type)
			{
				dialogHeight ='40vh' ;
				dialogWidth = '40vw' ;
			}
			//IN64543, ends
		}
		else if(colval=="LinkToCurrentEncounter")
		{
			var dialogHeight ='42vh' ;
			var dialogWidth = '100vw' ;
			var dialogTop	= '100';
			var dialogLeft = '30' ;
		}
		else
		{
			var dialogHeight ='11vh' ;
			var dialogWidth = '40vw' ;
			var dialogTop	= '189';
			var dialogLeft = '167' ;
		}
		if((colval=="ViewReplacedOrder")||(colval=="ViewOriginalOrder"))
		{
			
			//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
			//var xmlDoc = ""; 
			var xmlHttp = new XMLHttpRequest() ;
			var bean_id				=  "";
			var bean_name			=  "";
			bean_id		  = document.existing_order_dtl.bean_id.value;
			bean_name	  = document.existing_order_dtl.bean_name.value;
			var func_mode = colval;
			xmlStr ="<root><SEARCH " ;
			xmlStr += " orderId=\""+ orderId +"\" " ;
			xmlStr +=" /></root>" ;
			var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "ExistingOrderValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate="+func_mode,false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText = xmlHttp.responseText ;
			if((responseText!=null)||(responseText!=undefined))
				orderId = responseText;
		}
 		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';

		var arguments = "";
		//if(order_line_num != "")		 
		//var finalString	= "from=line&colval1="+colval+ "&colval=" +colval+"&orderId="+ orderId+"&ord_cat="+ ord_cat+"&ord_typ_code="+ ord_typ_code+"&val1="+ val1+"&cancel_type="+ cancel_type+"&order_line_num="+ order_line_num+"&catalog_code="+ catalog_code+"&patient_id="+ patient_id+"&cont_order_ind="+ cont_order_ind+"&order_status="+ order_status+"&sex="+ sex+ colval+"&ord_cat_id="+val1+"&encounter_id="+encntr_id+"&patient_class="+pat_class+"&can_reason="+colval+"&iv_prep_yn="+iv_prep_yn; // --[IN033061]//Commented for IN071315
		//else
    //var finalString	= "from=header&colval1="+colval+ "&colval=" +colval+"&orderId="+ orderId+"&ord_cat="+ ord_cat+"&ord_typ_code="+ ord_typ_code+"&val1="+ val1+"&cancel_type="+ cancel_type+"&order_line_num="+ order_line_num+"&catalog_code="+ catalog_code+"&patient_id="+ patient_id+"&cont_order_ind="+ cont_order_ind+"&order_status="+ order_status+"&sex="+ sex+ colval+"&ord_cat_id="+val1+"&encounter_id="+encntr_id+"&patient_class="+pat_class+"&can_reason="+colval;	
    var finalString	= "from=line&colval1="+colval+ "&colval=" +colval+"&orderId="+ orderId+"&ord_cat="+ ord_cat+"&ord_typ_code="+ ord_typ_code+"&val1="+ val1+"&cancel_type="+ cancel_type+"&order_line_num="+ order_line_num+"&catalog_code="+ catalog_code+"&patient_id="+ patient_id+"&cont_order_ind="+ cont_order_ind+"&order_status="+ order_status+"&sex="+ sex+ colval+"&ord_cat_id="+val1+"&encounter_id="+encntr_id+"&patient_class="+pat_class+"&can_reason="+colval+"&iv_prep_yn="+iv_prep_yn+"&p_called_from_ca="+p_called_from_ca;//Added for IN071315
		//IN64543, starts
    if(colval=="Preps" ||colval=="Comments" || colval == "Instructions")
			finalString	= finalString +"&instrn_type="+instrn_type;
    //IN64543, ends
    
    if(colval == "LinkToCurrentEncounter")
		{
			var futureOrderString	= "called_from=ExistingOrder&colval1="+colval+ "&colval=" +colval+"&orderId="+ orderId+"&ord_cat="+ ord_cat+"&ord_typ_code="+ ord_typ_code+"&val1="+ val1+"&cancel_type="+ cancel_type+"&order_line_num="+ order_line_num+"&catalog_code="+ catalog_code+"&p_patient_id="+ patient_id+"&cont_order_ind="+ cont_order_ind+"&order_status="+ order_status+"&sex="+ sex+ colval+"&ord_cat_id="+val1+"&p_encounter_id="+encntr_id+"&p_patient_class="+pat_class+"&can_reason="+colval+"&p_source_code="+location_code+"&p_source_type="+location_type+"&p_episode_id="+episode_id+"&p_episode_visit_num="+episode_visit_num;
			var retVals = await top.window.showModalDialog("../../eOR/jsp/FutureOrderDtl.jsp?"+futureOrderString,arguments,features);
		}
		else
		{
			var retVals = await top.window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);
		}

		if(colval == "Cancel" || colval == "Discontinue"  || colval == "Hold"  || colval == "Resume" || colval == "LinkToCurrentEncounter")
		{
			reloadValues();		
		}
}

function clickLine(chk) {
	if (chk.checked == true) {
		chk.value = 'Y';
	} else {
		chk.value = 'N';
	}
}

async function show_practitioner_window(target){

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;



	argumentArray[0]   = document.copy_orders_search.prac_sql.value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	//argumentArray[5]   = target.value ;
	argumentArray[5]   = "" ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;


	retVal = await CommonLookup( getLabel("Common.practitioner.label","Common"),argumentArray );

	if(retVal != null && retVal != ""){
		target.value = retVal[1];
		target.focus();
		document.copy_orders_search.practitioner.value=retVal[0];
	}

}

//this is used for patient ID search
async function callPatientSearch(){
	var pat_id = await PatientSearch();

	if(pat_id != null) {
		document.copy_orders_search.patientId.value = pat_id;

	}
}

function displayLegendForButton(Obj) {

	if(parent.ExistingOrderSearch.document.existing_order_search.copyorders)
	{	
		parent.ExistingOrderSearch.document.existing_order_search.copyorders.value=getLabel("eOR.CopyPreviousOrders.label","OR");
		parent.ExistingOrderSearch.document.existing_order_search.copyorders_btn_type.value = 'C';
			
	}
	displayElapsedFields(Obj);
}

//callFutureOrders()
function callFutureOrders() {


	var count 		= 0;
	var flag		= true;
	//var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
	//var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
    var xmlHttp = new XMLHttpRequest();
	xmlStr 			= "<root><SEARCH " ;

	var no_of_checked = 0;
	//var formObj = parent.ExistingOrderResult.document.existing_order_dtl



	if(parent.ExistingOrderResult.location.href.indexOf(".jsp") != -1){
		var formObj = parent.ExistingOrderResult.ExistingOrderResult.document.existing_order_dtl
		bean_id = parent.ExistingOrderSearch.document.existing_order_search.bean_id.value

		for(cnt=0; cnt<formObj.total_recs.value; cnt++){
			val = eval("formObj.chk"+cnt);
			status = eval("formObj.ord_status"+cnt).value;
			if(val.checked == true){

				//if (status == 'IR' || status == 'CD' || status == 'DC' || status == 'CN')
				{
					//if (view_by == 'L')
					{
						xmlStr += "order_id"+ no_of_checked +"=\""+ eval("formObj.ord_id"+cnt).value +"\" " ;
						if (eval("formObj.line_num"+cnt)) {
							xmlStr += "order_line_num"+ no_of_checked +"=\""+ eval("formObj.line_num"+cnt).value +"\" " ;
							xmlStr += "catalog_code"+ no_of_checked +"=\""+ eval("formObj.catalog_code"+cnt).value +"\" " ;
						} else {
							xmlStr += "order_line_num"+ no_of_checked +"=\""+ "" +"\" " ;
							xmlStr += "catalog_code"+ no_of_checked +"=\""+ "" +"\" " ;
						}
						xmlStr += "order_category"+ no_of_checked +"=\""+ eval("formObj.order_category"+cnt).value +"\" " ;
						xmlStr += "order_type_code"+ no_of_checked +"=\""+ eval("formObj.ord_typ_code"+cnt).value +"\" " ;
						no_of_checked++;
					}
				}
			}
		}
		if (no_of_checked > 0) {
			flag = confirm(getMessage("FUTURE_ORDER_ACTIVATED_LINKED","OR"));

			if (flag) {


				count = no_of_checked;
				xmlStr += "encounter_id=\""+ parent.ExistingOrderSearch.document.existing_order_search.encounter_id.value +"\" " ;
				xmlStr += "count=\""+ no_of_checked +"\" " ;
				xmlStr +=" /></root>" ;

				var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				var validate = "ACTIVATE_ORDER";

				xmlHttp.open( "POST", "ExistingOrderValidate.jsp?bean_id=" + bean_id + "&validate="+validate, false ) ;

				xmlHttp.send( xmlDoc ) ;
				responseText=xmlHttp.responseText ;

				eval(responseText ) ;
				//parent.ExistingOrderResult.ExistingOrderResult.reset();
				formObj.reset();
			}
		} else {
			alert(getMessage('CLICK_ANY_ONE','OR'))
			return false
		}
	}
}
//END OF callFutureOrders()

function callCopyPreviousOrders() {

	if (document.existing_order_search.copyorders_btn_type.value == 'A') {
		callFutureOrders(this);
	} else {
		
		var view_by = document.existing_order_search.view_by.value;

		qry_string = document.existing_order_search.qry_string.value;
		qry_string += "&bean_id="+document.existing_order_search.bean_id.value;
		qry_string += "&bean_name="+document.existing_order_search.bean_name.value;
		qry_string += "&date_from="+document.existing_order_search.date_from.value;
		qry_string += "&date_to="+document.existing_order_search.date_to.value;
		qry_string += "&order_category="+document.existing_order_search.order_category.value;
		qry_string += "&order_type="+document.existing_order_search.order_type.value;
		qry_string += "&order_type_desc="+document.existing_order_search.order_type_desc.value;
		qry_string += "&catalog="+document.existing_order_search.catalog.value;
		qry_string += "&view_by="+view_by;
		qry_string += "&encounter_id="+document.existing_order_search.encounter_id.value;//--[IN029659]
		//Start - [IN029659]
		var patientId = document.existing_order_search.patientId.value;
		var encounterId = document.existing_order_search.encntr_id.value;
		var patientClass = document.existing_order_search.patient_class.value;
		//End - [IN029659]
		var retString 	= "";
		var count 		= 0;
		var flag		= true;
		var xmlInputStr = "<root><SEARCH " ;
		//var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
		//var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
        var xmlHttp = new XMLHttpRequest();
		xmlStr 			= "<root><SEARCH " ;
		xmlStr1 		= "<root><SEARCH " ; //--[IN029659]
		var no_of_checked = 0;

		var formObj0 = parent.ExistingOrderSearch.document.existing_order_search

		if (parent.ExistingOrderResult.ExistingOrderResult != null) {

			var formObj = parent.ExistingOrderResult.ExistingOrderResult.document.existing_order_dtl

			if(formObj){
			
				for(cnt=0; cnt<formObj.total_recs.value; cnt++)
				{
					val = eval("formObj.chk"+cnt);
					status = eval("formObj.ord_status"+cnt).value;
					copy_yn = eval("formObj.copy_yn"+cnt).value;
					if(val.checked == true&&!((eval("formObj.order_category"+cnt).value=="PH")&&((eval("formObj.ord_typ_code"+cnt).value=="TDM")||(eval("formObj.ord_typ_code"+cnt).value=="PDC"))))
					{
						
						//if (status == 'IR' || status == 'CD' || status == 'DC' || status == 'CN') {
						if (copy_yn == 'Y') 
						{
							if (view_by == 'L') 
							{
								//Changed xmlStr to xmlStr1 - [IN029659]
								xmlStr1 += "order_id"+ no_of_checked +"=\""+ eval("formObj.ord_id"+cnt).value +"\" " ;
								//retString += "&order_id"+i+"="+eval("formObj.ord_id"+cnt).value;
								if (eval("formObj.line_num"+cnt)) 
								{
									xmlStr1 += "order_line_num"+ no_of_checked +"=\""+ eval("formObj.line_num"+cnt).value +"\" " ;
									if (retString.indexOf("~"+eval("formObj.catalog_code"+cnt).value+"~") != -1) 
									{
										alert(getMessage("DUPLICATE_ORDERABLES","OR"));
										return false;
									}
									retString += "~"+ eval("formObj.catalog_code"+cnt).value + "~";//--[IN029659]
									xmlStr1 += "catalog_code"+ no_of_checked +"=\""+ eval("formObj.catalog_code"+cnt).value +"\" " ;
								} 
								else
								{
									xmlStr1 += "order_line_num"+ no_of_checked +"=\""+ "" +"\" " ;
									retString += "&order_line_num"+i+"=";
									xmlStr1 += "catalog_code"+ no_of_checked +"=\""+ "" +"\" " ;
									retString += "&catalog_code"+i+"=";
								}
								xmlStr1 += "order_category"+ no_of_checked +"=\""+ eval("formObj.order_category"+cnt).value +"\" " ;
								retString += "&order_category"+i+"="+eval("formObj.order_category"+cnt).value;
								xmlStr1 += "order_type_code"+ no_of_checked +"=\""+ eval("formObj.ord_typ_code"+cnt).value +"\" " ;
								retString += "&order_type_code"+i+"="+eval("formObj.ord_typ_code"+cnt).value;
								no_of_checked++;
							} 
								
							else if (view_by == 'H') {
						
								xmlInputStr += "order_id"+ no_of_checked +"=\""+ eval("formObj.ord_id"+cnt).value +"\" " ;
								xmlInputStr += "order_category"+ no_of_checked +"=\""+ eval("formObj.order_category"+cnt).value +"\" " ;
								xmlInputStr += "order_type_code"+ no_of_checked +"=\""+ eval("formObj.ord_typ_code"+cnt).value +"\" " ;
								no_of_checked++;
							}
						} else {
							flag = confirm(getMessage("CONFIRM_COPY","OR"));
							if (!flag) return false;
						}
					}
				}
				if (view_by == 'H') 
				{
					if(no_of_checked > 0)
					{
					xmlStr += catalogCodeForOrderId(formObj.bean_id.value,xmlInputStr,no_of_checked,patientId,encounterId,patientClass,view_by);
					no_of_checked = totCountGlobal;
						if (errorMessage != null && errorMessage != "") 
						{
						//alert(getMessage(errorMessage,"OR"));
						//return false; //--[IN029659] -Start
							if(errorMessage == "DUPLICATE_ORDERABLES")
							{
								alert(getMessage("DUPLICATE_ORDERABLES","OR"));
								return false;
							}
							else
							{
								flag = confirm(getMessage(errorMessage,"OR"));
								if (!flag)return false;
							} //--[IN029659] -End
						}
					}

				}else if(view_by == 'L')//--[IN029659] - Start
				{
					if(no_of_checked > 0)
					{
						xmlStr += catalogCodeForOrderId(formObj.bean_id.value,xmlStr1,no_of_checked,patientId,encounterId,patientClass,view_by);		
						no_of_checked = totCountGlobal;
						if (errorMessage != null && errorMessage != "") 
						{
							flag = confirm(getMessage(errorMessage,"OR"));
							if (!flag)return false;
						}
					}
				}//--[IN029659] - End
			}
		}

			/*	if (no_of_checked > 0) {
			count = no_of_checked;
		} COMMETED FOR IN073985*/ 
    if (flag == true) {
			
			var dialogHeight ='41.5' ;
			var dialogWidth = '100' ;
			var dialogTop	= '100';
			var dialogLeft = '30' ;
			var title = getLabel("eOR.CopyOrders.label","OR");
			var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

			var arguments = "";
			var retVals = window.showModalDialog("../../eOR/jsp/CopyOrdersFrameset.jsp?"+qry_string,arguments,features);
			
			if (retVals != null) {
				xmlStr	= retVals[0];
				count	= retVals[1]; 
			}
		}

		if (count > 0) {
			var qryStringArray = new Array();
			qryStringArray = parent.location.href.split("?");
 			xmlStr += "rowCount=\""+ count +"\" " ;
			xmlStr +=" /></root>" ;
			var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "CopyOrdersSetBeanVals.jsp?"+qryStringArray[1]+"&bean_id="+document.existing_order_search.bean_id.value+"&bean_name="+document.existing_order_search.bean_name.value+"localeName="+document.existing_order_search.localeName.value, false ) ;

			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			eval(responseText ) ;
			var queryString = "";//"../../eOR/jsp/EnterOrder.jsp?";
			queryString += "&ammend_called_from=COPY_ORDER&function_from=COPY_ORDER&";
			queryString += qryStringArray[1];
			/*Added by Uma on 2/24/2010 for IN019470*/
			queryString += "&existing_order_called_from="+document.existing_order_search.existing_order_called_from.value;
			queryString += "&multi_called_from="+document.existing_order_search.multi_called_from.value;
			/*Ends Here Uma for IN019470*/
			//queryString += "&bean_id="+document.existing_order_search.bean_id.value;
			//queryString += "&bean_name="+document.existing_order_search.bean_name.value;
			queryString += "&count="+count;
			//parent.parent.location.href = queryString;

			/*Added by Ambiga on 3/12/2010 for IN019984*/
			if(top.content!=null)
			{
				parent.parent.location.href = "../../eOR/jsp/EnterOrder.jsp?"+queryString;
			}
			else
			{
				
				if(parent.parent.orderMainTab)
				{
					parent.parent.orderMainTab.OrCommonForm.params.value=queryString;
					if(parent.parent.orderMainTab.OrCommonForm.all.newOrders)
						parent.parent.orderMainTab.OrCommonForm.all.newOrders.className		= "CASECONDSELECTHORZ";		
					if(parent.parent.orderMainTab.OrCommonForm.all.existingOrders)
						parent.parent.orderMainTab.OrCommonForm.all.existingOrders.className  = "CAFIRSTSELECTHORZ";
					parent.parent.orderDetailFrame.location.href = "../../eOR/jsp/OrderEntryByPractitioner.jsp?"+queryString;					
				}
			}
			/*Ends Here for IN019984*/
		}
	}
}

function catalogCodeForOrderId(bean_id,xmlInputStr,count,patientId,encounterId,patientClass,view) {
	var xmlStr = "";
	var validate = "";
	var localeName='en';
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr = xmlInputStr;
	xmlStr += "count=\""+ count +"\" " ;
	xmlStr += "patientId=\""+ patientId +"\" " ;
	xmlStr += "encounterId=\""+ encounterId +"\" " ;
	xmlStr += "patientClass=\""+ patientClass +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	if(view == 'H') //--[IN029659]
	validate = "order_line_num";
	else //--[IN029659]
	validate = "order_line";	//--[IN029659]

	xmlHttp.open( "POST", "CopyOrdersValidate.jsp?bean_id=" + bean_id + "&validate="+validate+"&localeName="+localeName, false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText ) ;
	return xmlStr;
}

function onSetCount(val) {

}
function showAllDiagnosisWindow(scheme,scheme_code) {
	var retVal 		= new String();
	var dialogHeight 	= "29" ;
	var dialogWidth  	= "40" ;
	var dialogTop    	= "100";
	var status 		= "no";
	var arguments		= "" ;
	var features 		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll:no; status:" + status;
	retVal = window.showModalDialog("../../eCA/jsp/PaintConsultationFrame.jsp?title=Diagnosis&p_diag_code="+scheme+"&p_diag_scheme_desc="+scheme_code+"&p_auth_yn=Y&cause_indicator=",arguments,features);
    if (!(retVal == null))
	{
		//val=retVal.split("/");
		document.getElementById("diag_code").value	 = retVal;//unescape(val[0]);
		//document.careSetSearchForm.orderable_text.value 	 = retVal;//unescape(val[0]);
		var bean_id 			= document.copy_orders_search.bean_id.value ;
		var bean_name 			= document.copy_orders_search.bean_name.value ;
		var localeName          = document.copy_orders_search.localeName.value;
		//var xmlDoc 				= new ActiveXObject( "Microsoft.XMLDom" ) ;
		//var xmlHttp 			= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
        var xmlHttp = new XMLHttpRequest();
		xmlStr					= "<root><SEARCH " ;
		xmlStr 					+= obj.name+"=\""+ obj.value +"\" " ;
		xmlStr 					+=" /></root>" ;
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "CopyOrdersValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name +"&validate=diag_desc"+"&diag_code="+retVal+"&localeName="+localeName, false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval( responseText ) ;
	}
}

function addCareSetDiagnosisDesc(form_name,diag_desc)
{
	eval(form_name+".diag_desc.value=diag_desc");
}
/*function clearActivityTypeList( docObj ) {
	var len = eval(docObj+".copy_orders_search.activity_type.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".copy_orders_search.activity_type.remove(\"atc_class_l2_code\")") ;
	}
	var tp = "     --- "+getLabel("Common.defaultSelect.label","Common")+" ---     " ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".copy_orders_search.activity_type.add(opt)") ;
}

function addActivityList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.copy_orders_search.activity_type.add(element);
}*/

function populateCopyOrdersSearchValues(obj){

	formObj = document.copy_orders_search;

	if (obj == null || obj == "") {
		return false;
	}

	var bean_id = formObj.bean_id.value ;
	var localeName = formObj.localeName.value;


	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	//if (obj == "ord_cat")
		xmlStr += formObj.order_category.name+"=\""+ formObj.order_category.value +"\" " ;
	if (obj == "order_type"){
	  //	xmlStr += formObj.order_category.name+"=\""+ formObj.order_category.value +"\" " ;
		xmlStr += formObj.order_type.name+"=\""+ formObj.order_type.value +"\" " ;
	}
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var validate = obj;

	xmlHttp.open( "POST", "CopyOrdersValidate.jsp?bean_id=" + bean_id + "&validate="+validate+"&localeName="+localeName, false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;

	eval(responseText ) ;
}

function addPatientClassList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.copy_orders_search.patient_class.add(element);
}

function clearPatientClassList( docObj ) {
	var len = eval(docObj+".copy_orders_search.patient_class.options.length") ;
	for(var i=0;i<len;i++) {
		eval(docObj+".copy_orders_search.patient_class.remove(\"atc_class_l2_code\")") ;
	}
	var tp = "     --- "+getLabel("Common.defaultSelect.label","Common")+" ---     " ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".copy_orders_search.patient_class.add(opt)") ;
}

function populateCopyValues(clearcopy) {

if(clearcopy!="clear")
	{
		formObj = document.copy_orders_search;
		var from_date = document.copy_orders_search.date_from ;
		var to_date  = document.copy_orders_search.date_to ;
		var localeName = document.copy_orders_search.localeName.value;
	//if(doDateCheckOR(from_date,to_date) == 1) { // this function is available in eOR/js/orCommonFunctions.js
	
	
		if(!isAfter(to_date.value,from_date.value,"DMY",localeName)){//this is added in place of doDateCheckOR
		
		
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM")); // this message available in messages.js of ecommon/js
			return false
		}

		var qry_string = "";
		var flag		= true;

	//flag = checkField(formObj.date_from,"Period From");
	//if (!flag) 
		//return false;
		if(!trimCheck(from_date.value)){
			alert(getMessage("FROM_DATE_CANNOT_BE_BLANK","SM"));
			parent.CopyOrdersResultsBottom.location.href = "../../eCommon/html/blank.html"
			return false
		}

	//flag = checkField(formObj.date_to,"Period To");
	//if (!flag) return false;

	
		if(!trimCheck(to_date.value)){
			alert(getMessage("TO_DT_NOT_BLANK","SM"));
			parent.CopyOrdersResultsBottom.location.href = "../../eCommon/html/blank.html"
			return false
		}

		if (formObj.diag_chk) {
			 if (formObj.diag_chk.checked == true) {
    			if (formObj.diag_type.value = 'P') {
    				flag = checkFieldLocal(formObj.patientId,"Patient ID");
    				if (!flag) return false;

    		}

    		if (formObj.diag_code.value == "") {
    			//alert("APP-000001 Diagnosis cannot be blank...");
    			alert(getMessage("DIAGNOSIS_EVENT_BLANK","OR"));
    			flag = false;
    		}

    		if (!flag) return false;

    		flag = checkFieldLocal(formObj.occurrance,"Occurance");
    		if (!flag) return false;
    	}
    }
	//if (document.copy_orders_search.patientId.value != "")
    qry_string = "patientId="+escape(document.copy_orders_search.patientId.value);
    qry_string += "&patient_class="+escape(document.copy_orders_search.patient_class.value);
    //else
    //	qry_string = "patientId="+document.copy_orders_search.pat_id.value;

	qry_string +="&encntr_id="+escape(document.copy_orders_search.encounter_id.value)+"&catalog="+escape(document.copy_orders_search.catalog.value)+"&date_from="+escape(document.copy_orders_search.date_from.value)+"&date_to="+escape(document.copy_orders_search.date_to.value)+"&order_category="+escape(document.copy_orders_search.order_category.value)+"&order_type="+escape(document.copy_orders_search.order_type.value)
	qry_string += "&ord_pract_id="+escape(document.copy_orders_search.practitioner.value);
	qry_string += "&bean_id="+escape(document.copy_orders_search.bean_id.value);
	qry_string += "&bean_name="+escape(document.copy_orders_search.bean_name.value);
	qry_string += "&view_by="+escape(document.copy_orders_search.view_by.value);
	qry_string += "&search_criteria="+escape(document.copy_orders_search.search_criteria.value);
	qry_string += "&activity_type="+escape(document.copy_orders_search.activity_type.value);
	qry_string += "&location_type="+escape(document.copy_orders_search.location_type.value);
	qry_string += "&locn="+escape(document.copy_orders_search.locn.value);
	qry_string += "&cur_encounter_id="+escape(document.copy_orders_search.cur_encounter_id.value); //--[IN029659]
	qry_string += "&cur_patient_class="+escape(document.copy_orders_search.cur_patient_class.value);//--[IN029659]

	parent.CopyOrdersHdr.location.href = "../jsp/CopyOrdersHdr.jsp";
	parent.CopyOrdersResults.location.href = "../jsp/CopyOrdersResults.jsp?"+qry_string;
	parent.CopyOrdersResultsBottom.location.href = "../jsp/CopyOrdersResultsBottom.jsp?finalString=&bean_id="+escape(document.copy_orders_search.bean_id.value)+"&bean_name="+escape(document.copy_orders_search.bean_name.value)+"&view_by="+escape(document.copy_orders_search.view_by.value)+"&localeName="+localeName;
	parent.CopyOrdersBtn.location.href = "../jsp/CopyOrdersBtn.jsp";
	}
}
function checkFieldLocal( field, name ) {
    var errors = '' ;
    if( trimCheck(field.value) )
    {
        field.value = trimString(field.value);
        return true;
    }
    else
    {
		errors = errors + getMessage("CAN_NOT_BE_BLANK","Common");
		errors = errors.replace('$',name);
        alert(errors) ;
        field.focus();
        return false ;
    }
}

function populateCopyLocation(location_type)
{
	var formobj=document.copy_orders_search;
	
	if((location_type.value != "") && (location_type.value != undefined)) 
	{
		formobj.location_lookup.disabled=false;
		formobj.locn_code.disabled=false;
		formobj.locn_code.value="";
		formobj.locn.value="";
	}
	else
	{
		formobj.location_lookup.disabled=true;
		formobj.locn_code.disabled=true;
		formobj.locn_code.value="";
		formobj.locn.value="";
	}

}

function fillDefaultVals(order_category,order_type,order_type_desc) 
{
	document.getElementById("order_category").value = order_category;
	document.getElementById("order_type").value = order_type;
	document.getElementById("order_type_desc").value = order_type_desc;
}

function clickSelect1() {
	var count 	= 0;
	var finalString = document.copy_orders_results.finalString.value;

	if (finalString == "")
		finalString = "~";

	for(i=0;i<document.copy_orders_results.allValues.value;i++) {
		if (eval("document.copy_orders_results.chk"+i)) {
			if (eval("document.copy_orders_results.chk"+i).checked == true) {
				if (finalString.split("~").length <= 11) {
					finalString += i + "~";
					count++;
				} else {

					alert(getMessage("MAX_ORDERABLES","OR"));
					eval("document.copy_orders_results.chk"+i).checked = false;
					return false;
				}
			}
		}
	}

	//if (count <= 0)
	//	return false;
	var bean_id = escape(document.copy_orders_results.bean_id.value);
	var bean_name = escape(document.copy_orders_results.bean_name.value);
	var localeName = document.copy_orders_results.localeName.value;

	parent.CopyOrdersResultsBottom.location.href = "../jsp/CopyOrdersResultsBottom.jsp?finalString="+finalString+"&bean_id="+bean_id+"&bean_name="+bean_name+"&view_by="+parent.CopyOrdersSearch.copy_orders_search.view_by.value+"&localeName="+localeName;
}
function clickUnSelect() {
	var count = 0;
	var finalString = "~";
	for(i = 0;i < document.copy_orders_results_bottom.allValues.value;i++) {
		if (eval("document.copy_orders_results_bottom.chk"+i)) {
			if (eval("document.copy_orders_results_bottom.chk"+i).checked == true) {
				finalString += i + "~";
				count++;
			} else {
				eval("parent.CopyOrdersResults.copy_orders_results.chk"+i).checked = false;
			}
		}
	}
	var bean_id = escape(document.copy_orders_results_bottom.bean_id.value);
	var bean_name = escape(document.copy_orders_results_bottom.bean_name.value);
	//var localeName = document.copy_orders_results_bottom.localeName.value;

	parent.CopyOrdersResultsBottom.location.href = "../jsp/CopyOrdersResultsBottom.jsp?finalString="+finalString+"&bean_id="+bean_id+"&bean_name="+bean_name+"&view_by="+parent.CopyOrdersSearch.copy_orders_search.view_by.value;
}

function clickAmend() {

	var count 		= 0;
	var returnValue = "";
	var catalogStr	= "~";
	var xmlStr 		="<root><SEARCH " ; //catalogCodeForOrderId(bean_id,xmlInputStr,count)
	var formObj = parent.CopyOrdersResultsBottom.document.copy_orders_results_bottom;
	//var localeName=parent.CopyOrdersResultsBottom.document.localeName.value;
	
	for(i = 0;i < parent.CopyOrdersResultsBottom.document.copy_orders_results_bottom.allValues.value;i++) {
		if (eval("parent.CopyOrdersResultsBottom.document.copy_orders_results_bottom.chk"+i)) {
			if (eval("parent.CopyOrdersResultsBottom.document.copy_orders_results_bottom.chk"+i).checked == true) {
				xmlStr += "order_id"+ count +"=\""+ eval("parent.CopyOrdersResultsBottom.document.copy_orders_results_bottom.order_id"+i).value +"\" " ;
				xmlStr += "order_category"+ count +"=\""+ eval("parent.CopyOrdersResultsBottom.document.copy_orders_results_bottom.order_category"+i).value +"\" " ;
				xmlStr += "order_type_code"+ count +"=\""+ eval("parent.CopyOrdersResultsBottom.document.copy_orders_results_bottom.order_type_code"+i).value +"\" " ;
				patientId = eval("parent.CopyOrdersResultsBottom.document.copy_orders_results_bottom.patient_id"+i).value;
				encounterId = eval("parent.CopyOrdersResultsBottom.document.copy_orders_results_bottom.encounter_id"+i).value;
				if (eval("parent.CopyOrdersResultsBottom.document.copy_orders_results_bottom.view_by").value == 'L') {
									
					if(catalogStr.indexOf("~"+eval("parent.CopyOrdersResultsBottom.document.copy_orders_results_bottom.catalog_code"+i).value+"~") != -1) {
						
						alert(getMessage("DUPLICATE_ORDERABLES","OR"));
						return false;
					}
					
					xmlStr += "order_line_num"+ count +"=\""+ eval("parent.CopyOrdersResultsBottom.document.copy_orders_results_bottom.order_line_num"+i).value +"\" " ;
					xmlStr += "catalog_code"+ count +"=\""+ eval("parent.CopyOrdersResultsBottom.document.copy_orders_results_bottom.catalog_code"+i).value +"\" " ;
					catalogStr += eval("parent.CopyOrdersResultsBottom.document.copy_orders_results_bottom.catalog_code"+i).value + "~";
				}
				count++;
			}
		}
	}
	if (count <= 0) {
		alert(getMessage("CLICK_ANY_ONE","OR"));
		return false;
	}
	if (eval("parent.CopyOrdersResultsBottom.document.copy_orders_results_bottom.view_by").value == 'H' && count > 0) {
		
		xmlStr = "<root><SEARCH " + catalogCodeForOrderId(parent.CopyOrdersResultsBottom.document.copy_orders_results_bottom.bean_id.value,xmlStr,count,patientId,encounterId,parent.frames[0].document.copy_orders_search.cur_patient_class.value,eval("parent.CopyOrdersResultsBottom.document.copy_orders_results_bottom.view_by").value);
		
		if (errorMessage != null && errorMessage != "") {
			alert(getMessage(errorMessage,"OR"));
			return false;
		}
		count = totCountGlobal;
	}
	var retVal	= new Array();
	retVal[0]	= xmlStr;
	retVal[1]	= count;


	window.returnValue	= retVal;
	window.close();
}

function callCopyMenuFunctions1(colval,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,cont_order_ind,order_status,sex){

		unescape(colval)
		//unescape(item_narration)
		//item_narration = eval("document.existing_order_dtl.item_narration"+item_narration+".value")
		if(colval == "Instructions"){
			var dialogHeight ='12' ;
			var dialogWidth = '35' ;
			var dialogTop	= '189';
			var dialogLeft = '167' ;
		} else if (colval == "View") {
				var dialogHeight ='37.5' ;
				var dialogWidth = '50' ;
				var dialogTop	= '100';
				var dialogLeft = '30' ;
		} else{
			var dialogHeight ='12' ;
			var dialogWidth = '30' ;
			var dialogTop	= '189';
			var dialogLeft = '167' ;
		}
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';

		var arguments = "";
		var finalString	= "from=line&colval1="+colval+ "&colval=" +colval+"&orderId="+ orderId+"&ord_cat="+ ord_cat+"&val1="+ val1+"&cancel_type="+ cancel_type+"&order_line_num="+ order_line_num+"&catalog_code="+ catalog_code+"&line_narration="+ escape(item_narration)+"&patient_id="+ patient_id+"&cont_order_ind="+ cont_order_ind+"&order_status="+ order_status+"&sex="+ sex+"&ord_cat_id="+val1+"&can_reason="+colval;


		var retVals = window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);

		if(colval == "Cancel" || colval == "Discontinue"  || colval == "Hold"  || colval == "Resume")
			reloadValues();
			//document.location.reload();
}

function chkDiagnosys(obj) {
	if (obj.checked == true) {
		document.getElementById("diag_td").innerHTML = "<input type='checkbox' value='Y' onClick='chkDiagnosys(this)'  name='diag_chk' id='diag_chk' checked>&nbsp;<select name='diag_type' id='diag_type' onChange='diagTypeSelect(this)'><option value='A'>All</option><option value='P'>Patient Specific</option></select>&nbsp;<input type=\"text\" name=\"diag_desc\" id=\"diag_desc\" value = \"\" size=\"20\" maxlength=\"20\" readonly><input type=\"hidden\" name=\"diag_code\" id=\"diag_code\" value = \"\">&nbsp;<Input type=\"button\" class=\"button\" Name=\"all_diagnosis\" id=\"all_diagnosis\" onClick=\"showAllDiagnosisWindow(this,'<%=diag_code[0]%>','<%=diag_code[1]%>')\" value='?'>&nbsp;<img src=\"../../eCommon/images/mandatory.gif\"></img>";
		document.getElementById("occurance_td").innerHTML += "&nbsp;<img src=\"../../eCommon/images/mandatory.gif\"></img>";
		//document.getElementById("diag_button_td").innerHTML = "";
	} else {
		document.getElementById("diag_td").innerHTML = "<input type='checkbox' value='N' onClick='chkDiagnosys(this)'   name='diag_chk' id='diag_chk'>&nbsp;";
		document.getElementById("patient_id_td").innerHTML = document.getElementById("patient_id_td").innerHTML.split("&nbsp;<IMG")[0];
		document.getElementById("occurance_td").innerHTML = document.getElementById("occurance_td").innerHTML.split("&nbsp;<IMG")[0];
		//document.getElementById("diag_button_td").innerHTML = "&nbsp;";
	}
}

function diagTypeSelect(obj) {
	if (obj.value == 'A') {
		document.getElementById("diag_td").innerHTML = "<input type='checkbox' value='Y' onClick='chkDiagnosys(this)'  name='diag_chk' id='diag_chk' checked>&nbsp;<select name='diag_type' id='diag_type' onChange='diagTypeSelect(this)'><option value='A'>All</option><option value='P'>Patient Specific</option></select>&nbsp;<input type=\"text\" name=\"diag_desc\" id=\"diag_desc\" value = \"\" size=\"20\" maxlength=\"20\" readonly><input type=\"hidden\" name=\"diag_code\" id=\"diag_code\" value = \"\">&nbsp;<Input type=\"button\" class=\"button\" Name=\"all_diagnosis\" id=\"all_diagnosis\" onClick=\"showAllDiagnosisWindow(this,'<%=diag_code[0]%>','<%=diag_code[1]%>')\" value='?'>&nbsp;<img src=\"../../eCommon/images/mandatory.gif\"></img>";
		document.getElementById("patient_id_td").innerHTML = document.getElementById("patient_id_td").innerHTML.split("&nbsp;<IMG")[0];
	} else if (obj.value == 'P') {
		document.getElementById("diag_td").innerHTML = "<input type='checkbox' value='Y' onClick='chkDiagnosys(this)'  name='diag_chk' id='diag_chk' checked>&nbsp;<select name='diag_type' id='diag_type' onChange='diagTypeSelect(this)'><option value='A'>All</option><option value='P' selected>Patient Specific</option></select>&nbsp;<Select name='diag_code' id='diag_code' noresize><Option>&nbsp;&nbsp;&nbsp;--- Select ---&nbsp;&nbsp;&nbsp;</Option></Select>&nbsp;<img src=\"../../eCommon/images/mandatory.gif\"></img>";
		document.getElementById("patient_id_td").innerHTML += "&nbsp;<img src=\"../../eCommon/images/mandatory.gif\"></img>";
		fillDiagList();
	}

}

function fillDiagList() {
	patient_id = document.getElementById("patientId");
	if (patient_id == null || patient_id.value == "") {

		alert(getMessage("SHD_NOT_BE_BLANK","OR"));
		return false;
	}
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	var xmlStr 		="<root><SEARCH " ;

	bean_id	= document.getElementById("bean_id").value;
    var localeName = document.getElementById("localeName").value;

	xmlStr += patient_id.name+"=\""+ patient_id.value +"\" " ;

	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open( "POST", "CopyOrdersValidate.jsp?bean_id=" + bean_id + "&validate=diag&localeName="+localeName, false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;

	eval(responseText )

} 

function addDiagList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.getElementById("diag_code").add(element);
}

function clearDiagList( docObj ) {
	var len = eval(docObj+".all.diag_code.options.length") ;
	for(var i=0;i<len;i++) {
		eval(docObj+".all.diag_code.remove(\"atc_class_l2_code\")") ;
	}
	var tp = "     --- "+getLabel("Common.defaultSelect.label","Common")+" ---     " ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".all.diag_code.add(opt)") ;
}

function showSecondayOrders(i,order_id)
{
	var called_from="existing_order";
    var start_date_time         = "";
    var priority                = "";
    var pri_order_catalog_code  = "";
	var	bean_id					= ""; var bean_name = "";
	patient_class				= eval("parent.ExistingOrderResult.document.existing_order_dtl.patient_class"+i+".value");
    start_date_time				= eval("parent.ExistingOrderResult.document.existing_order_dtl.start_date_time"+i+".value");
    priority					= eval("parent.ExistingOrderResult.document.existing_order_dtl.priority"+i+".value");
    pri_order_catalog_code		= eval("parent.ExistingOrderResult.document.existing_order_dtl.catalog_code"+i+".value");
	sec_order_catalog_type		= "I" ;  // Because it is only interventions
    var retVal;
 	var dialogTop   = "260";
 	var dialogHeight= "24" ;
 	var dialogWidth = "35" ;
 	var features	= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop +'; scroll=no; status=no';
 	var arguments	= "";

 	var qryString = "";
 	qryString += "bean_id="+bean_id+"&bean_name="+bean_name+"&start_date_time="+start_date_time;
 	qryString += "&pri_order_catalog_code="+pri_order_catalog_code+"&priority="+priority+"&patient_class="+patient_class+"&sec_order_catalog_type="+sec_order_catalog_type+"&called_from="+called_from+"&order_id="+order_id;
 	retVal 			= window.showModalDialog("../../eOR/jsp/OrderEntrySecondaryOrdersFrameset.jsp?"+qryString,arguments,features);
 } // End of viewSecondaryOrders


function showCareSetResults(orderId)
{
	 var   allvalues= "patientId="+document.existing_order_dtl.patientId.value+"&encntr_id="+document.existing_order_dtl.encntr_id.value+"&ord_status="+document.existing_order_dtl.ord_status.value+"&order_by="+document.existing_order_dtl.order_by.value+"&catalog="+document.existing_order_dtl.catalog.value+"&view="+document.existing_order_dtl.view.value+"&priority="+document.existing_order_dtl.priority.value+"&date_from="+document.existing_order_dtl.date_from.value+"&date_to="+document.existing_order_dtl.date_to.value+"&order_category="+document.existing_order_dtl.order_category.value+"&order_type="+document.existing_order_dtl.order_type.value+"&view_by=H&search_criteria="+document.existing_order_dtl.search_criteria.value+"&cosign="+document.existing_order_dtl.cosign.value+"&activity_type="+document.existing_order_dtl.activity_type.value+"&pract_reln_id="+document.existing_order_dtl.pract_reln_id.value+"&location_type="+document.existing_order_dtl.location_type.value+"&location_code="+document.existing_order_dtl.location_code.value+"&patient_class="+document.existing_order_dtl.patient_class.value+"&p_called_from_ca="+document.existing_order_dtl.p_called_from_ca.value+"&sex="+document.existing_order_dtl.sex.value+"&age="+document.existing_order_dtl.age.value+"&dob="+document.existing_order_dtl.dob.value+"&visit_adm_date="+document.existing_order_dtl.visit_adm_date.value+"&function_from="+document.existing_order_dtl.function_from.value;
	 	
	//var  formObj=	document.existing_order_dtl;
	var finalString = allvalues+"&orderId="+orderId+"&order_by="+document.existing_order_dtl.order_by.value+"&view_by=H"//+document.existing_order_dtl.view_by.value
	
		 //	qry_string = "patientId="+formObj.patientId.value+"&encntr_id="+formObj.encntr_id.value+"&ord_status="+formObj.ord_status.value+"&order_by="+formObj.order_by.value+"&catalog="+escape(formObj.catalog.value)+"&view="+formObj.view.value+"&priority="+formObj.priority.value+"&date_from="+formObj.date_from.value+"&date_to="+formObj.date_to.value+"&order_category="+formObj.order_category.value+"&order_type="+formObj.order_type.value+"&view_by="+formObj.view_by.value+"&search_criteria="+formObj.search_criteria.value+"&cosign="+formObj.cosign.value+"&activity_type="+formObj.activity_type.value
	//var qrystring = parent.ExistingOrderResult.document.existing_order_dtl.queryString.value;
	var dialogHeight ='36' ;
	var dialogWidth = '48' ;
	var dialogTop	= '129';
	var dialogLeft = '30' ;
	var title = ''
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';

	var arguments = "";
		
	var retVals = window.showModalDialog("../../eOR/jsp/OrderSetResults.jsp?"+finalString,arguments,features);
	reloadValues();
	//document.location.reload();	
}

function showCareSetViewResults(orderId, order_line_num, cont_order_ind, patient_id, catalog_desc){

   	var finalString = document.existing_order_dtl.queryString.value+"&orderId="+orderId+"&order_line_num="+order_line_num+"&catalog_desc="+escape(catalog_desc)+"&cont_order_ind="+cont_order_ind+"&patient_id="+patient_id;
	var dialogHeight ='27' ;
	var dialogWidth = '48' ; 
	var dialogTop	= '129';
	var dialogLeft = '30' ;
	var title = ''
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

	var arguments = "";
	var retVals = window.showModalDialog("../../eOR/jsp/OrderSetResultsViewFrameset.jsp?"+finalString,arguments,features);
	//document.location.reload();
	reloadValues();
}  

//populate only on enter key
function callSearch()
{
   	if(window.event.keyCode==13)
	{
 		populateValues();
	}
}

function reloadValues() 
{
	var obj		  = parent.parent.ExistingOrderSearch
		
 	if(obj && parent.parent.ExistingOrderSearch.document.existing_order_search) 
	{
		var formObj	  = parent.parent.ExistingOrderSearch.document.existing_order_search
	  	var from_date = formObj.date_from ;
		var to_date   = formObj.date_to ;
		/*Added by Uma on 11/25/2010 for IN025214*/
		elapsed_orders = "";
		if(formObj.elapsed_orders)
		{
			elapsed_orders = formObj.elapsed_orders.value;
		}
		sys_cancelled_orders = "";
		if(formObj.sys_cancelled_orders)
		{
			sys_cancelled_orders = formObj.sys_cancelled_orders.value;
		}
		/*Ends here by Uma on 11/25/2010 for IN025214 & modified*/
	 	qry_string = "patientId="+formObj.patientId.value+"&encntr_id="+formObj.encntr_id.value+"&ord_status="+formObj.ord_status.value+"&order_by="+formObj.order_by.value+"&catalog="+encodeURIComponent(formObj.catalog.value)+"&view="+formObj.view.value+"&priority="+formObj.priority.value+"&date_from="+formObj.date_from.value+"&date_to="+formObj.date_to.value+"&order_category="+formObj.order_category.value+"&order_type="+formObj.order_type.value+"&view_by="+formObj.view_by.value+"&search_criteria="+formObj.search_criteria.value+"&cosign="+formObj.cosign.value+"&activity_type="+formObj.activity_type.value+"&elaspsed_orders="+elapsed_orders+"&sys_cancelled_orders="+sys_cancelled_orders;

		var qry_string_fr_ammend = "&pract_reln_id="+formObj.pract_reln_id.value+"&location_type="+formObj.location_type.value+"&location_code="+formObj.location_code.value+"&patient_class="+formObj.patient_class.value+"&p_called_from_ca="+formObj.p_called_from_ca.value+"&sex="+formObj.sex.value+"&age="+formObj.age.value+"&dob="+formObj.dob.value+"&visit_adm_date="+formObj.visit_adm_date.value
	 	formObj.search.disabled = true;
		
 		parent.parent.ExistingOrderResult.location.href = "../jsp/ExistingSingleOrderResultsFrameset.jsp?"+qry_string+qry_string_fr_ammend
		formObj.search.disabled = false;
	}
	else
	{
		
		if(parent.ExistingOrderResult && !parent.ExistingOrderSearch)
		{
			var qrystring = parent.ExistingOrderResult.document.existing_order_dtl.queryString.value;
			parent.ExistingOrderResult.location.href ="../jsp/OrderSetExistingOrderResults.jsp?"+qrystring;	
		
		}
		else if(parent.ExistingOrderSearch)
		{
			
			var qrystring = parent.ExistingOrderResult.document.existing_order_dtl.queryString.value;
			parent.ExistingOrderResult.location.href ="../jsp/ExistingSingleOrderResults.jsp?"+qrystring;	
			
		}
	}
}

// Calling the Notes View
function showNotes(accession_num) 
{
 	var dialogHeight ='27' ;
	var dialogWidth = '48' ;
	var dialogTop	= '129';
	var dialogLeft	= '30' ;
	var title = ''
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
 	var arguments = "";
	var retVals = window.showModalDialog("../../eCA/jsp/PhysicianNotesDetailsFrame.jsp?accession_num="+escape(accession_num),arguments,features);
}


//this function will give the final xml string on click of apply
/*function beforePost(str) {

}*/

//To disable Activity Type on selection of the Header Level.
function disableActivity()
{
	if(document.existing_order_search.view_by.value=='H')
	{
		document.existing_order_search.activity_type.value		= "" ;
		document.existing_order_search.activity_type.disabled	= true ;
	}
	else
	{
		document.existing_order_search.activity_type.disabled	= false ;
	}
}

function chckDate(Object2,focusflag)
{
	var localeName;
	if(parent.ExistingOrderSearch)
     localeName=parent.ExistingOrderSearch.document.existing_order_search.localeName.value;
	else
	localeName=document.copy_orders_search.localeName.value;
//if(CheckDate(Object2,focusflag)==false)//this method is commented for thai dates
		
	if(validDateObj(Object2,"DMY",localeName)==false){

	var temp;
	if(parent.ExistingOrderSearch)
		temp=parent.ExistingOrderSearch.document.existing_order_search;
	else
		temp=document.copy_orders_search;
	   temp.date_from.value= temp.temp_last_month_date.value;
	
	
	}
}

//the below fun is commented for thai date changes
/*
function chckDate2(Object2)
{
if(CheckDate(Object2)==false)
	{
	parent.ExistingOrderSearch.document.existing_order_search.date_to.value= parent.ExistingOrderSearch.document.existing_order_search.temp_curr_sys_date.value;
	}
}*/

function populateordertypeSearch(target,code,called_from)
{

	if(called_from=='ExistingOrder')
		var formobj=document.existing_order_search;
	else if(called_from=='CopyOrders')
		var formobj=document.copy_orders_search;

	if(trimString(target.value).length>0)
	{
		callordertypeSearch(target,code,called_from);
	}
	else
	{
		if(target.value=="")
		{
			code.value="";
			formobj.activity_type.value="";
			formobj.activity_type_desc.value="";
		}
		
	}
}

function callordertypeSearch(target,code,called_from)
{
	
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();
	if(called_from=='ExistingOrder')
		var formobj=document.existing_order_search;
	else if(called_from=='CopyOrders')
		var formobj=document.copy_orders_search;
	
	dataNameArray[0] 	= "order_category" ;	
	dataValueArray[0] 	= formobj.order_category.value;
 	dataTypeArray[0] 	= STRING ;
	
	var localeName= formobj.localeName.value;
	var sql=formobj.order_type_sql.value;
	
	
	sql=sql.replace('?',"'"+localeName+"'");
	
	argumentArray[0]=sql;
	argumentArray[1]=dataNameArray;
	argumentArray[2]=dataValueArray;
	argumentArray[3]=dataTypeArray;
	argumentArray[4]="2,3";
	argumentArray[5]=target.value;
	argumentArray[6]= CODE_LINK;
	argumentArray[7]= CODE_DESC;

	retval=CommonLookup(getLabel("Common.OrderType.label","Common"),argumentArray);

	if(retval !=null && retval != "")
	{
		code.value=retval[0];
		target.value=retval[1];
	}else{
   		target.value = "";
   		code.value = "" ;
	 }
		formobj.activity_type.value="";
		formobj.activity_type_desc.value="";
}

function populateActivitySearch(target,code,called_from)
{
	if(trimString(target.value).length>0)
	{
		callActivitySearch(target,code,called_from);
	}
	if(target.value=="")
	{
		code.value="";
	}
}

function callActivitySearch(target,code,called_from)
{
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();
	if(called_from=='ExistingOrder')
		var formobj=document.existing_order_search;
	else if(called_from=='CopyOrders')
		var formobj=document.copy_orders_search;
	localeName=formobj.localeName.value;
	dataNameArray[0] 	= "order_category" ;		 
  	dataValueArray[0] 	= formobj.order_category.value;
 	dataTypeArray[0] 	= STRING ;
	dataNameArray[1] 	= "order_type_code" ;		 
  	dataValueArray[1] 	= formobj.order_type.value;
 	dataTypeArray[1] 	= STRING ;
	
	var sql=formobj.activity_sql.value;
	sql=sql.replace('?',"'"+localeName+"'");
	
	argumentArray[0]=sql;
	argumentArray[1]=dataNameArray;
	argumentArray[2]=dataValueArray;
	argumentArray[3]=dataTypeArray;
	argumentArray[4]="3,4";
	argumentArray[5]=target.value;
	argumentArray[6]= CODE_LINK;
	argumentArray[7]= CODE_DESC;

	retval=CommonLookup(getLabel("eOR.ActivityType.label","OR"),argumentArray);

	if(retval !=null && retval != "")
	{
		code.value=retval[0];
		target.value=retval[1];
		
	}else
	{
   		target.value = "";
   		code.value = "" ;
	 }
}

function clearFields(called_from)
{
	if (called_from=='ExistingOrder')
		var formobj=document.existing_order_search;
	else if(called_from=='CopyOrders')
		var formobj=document.copy_orders_search;
	formobj.order_type.value="";
	formobj.order_type_desc.value="";
	formobj.activity_type.value="";
	formobj.activity_type_desc.value="";
	if (called_from=='ExistingOrder')
		displayElapsedFields(formobj.ord_status);
}

function populateMvLoaction(target,code)
{
	if(trimString(target.value).length>0)
	{
			populateMoveLoaction(target,code);
	}
	if(target.value=="")
		code.value="";
}

function populateMoveLoaction(target,code)
{
	var formobj=document.copy_orders_search;
	location_type=formobj.location_type.value;
	if(location_type!='')
	{
		localeName=formobj.localeName.value;
		var sql="";

		if(location_type=="C")
		{
			var sql=formobj.clinic_sql.value;
		}else if(location_type=="N")
		{
			var sql=formobj.nursing_sql.value;
		}else if(location_type=="R")
		{
			var sql=formobj.referral_sql.value;
		}
		sql=sql.replace('?',"'"+localeName+"'");
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
	
		argumentArray[0]   =sql;
	
		argumentArray[1]   = dataNameArray ;
		argumentArray[2]   = dataValueArray ;
		argumentArray[3]   = dataTypeArray ;
		argumentArray[4]   = "1,2";
		argumentArray[5]   = target.value;
		argumentArray[6]   = CODE_LINK ;
		argumentArray[7]   = CODE_DESC ;

		retVal = CommonLookup(getLabel("Common.Location.label","Common") , argumentArray );

		if(retVal !=null && retVal != "")
		{
			code.value=retVal[0];
			target.value=retVal[1];
		}
		else
		{
   			target.value = "";
   			code.value = "" ;
 		}
	}
}

// In Order Entry Module all the places, this method is called to hide the tool tip
function hideToolTip()	{
  document.getElementById("tooltiplayer").style.visibility = 'hidden'
}

// In Order Entry Module all the places, this method is called to display the tool tip
function showToolTip(catalog_code, form_name) {

 	// All the places except Amend Order
	/*
	if(eval("document."+form_name+".explanatory_text"+catalog_code))
	 	explanatory_text	= eval("document."+form_name+".explanatory_text"+catalog_code+".value");
	else   // For Amend Orders
		explanatory_text	= eval("document."+form_name+".amend_explanatory_text"+catalog_code+".value");
	*/
	var form = document.getElementById(form_name);

	if(form["explanatory_text"+catalog_code])
	 	explanatory_text	= form["explanatory_text"+catalog_code].value;
	else   // For Amend Orders
		explanatory_text	= form["amend_explanatory_text"+catalog_code].value;

	if(explanatory_text!=null && explanatory_text!="")
    {
		buildToolTable(explanatory_text);
 		resizeWindow1();
	}
}
 
function buildToolTable(val) {

	var tab_dat		= "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center'>"
		tab_dat     += "<tr>"
		tab_dat     += "<td class = 'contextMenuItem'>"+val+" </td>"
 		tab_dat     += "</tr> "
 		tab_dat     += "</table> "
	document.getElementById("t").innerHTML = tab_dat;
		
}

function resizeWindow(){

		 bodwidth	= document.body.offsetWidth
		 bodheight	= document.body.offsetHeight
   		 var x		= event.x
		 var y		= event.y;

			x		= x + (document.getElementById("tooltiplayer").offsetWidth)
			y		= y + (document.getElementById("tooltiplayer").offsetHeight)

		 if(x<bodwidth)
			x		= event.x
		 else
			x		= x - (document.getElementById("tooltiplayer").offsetWidth*2)

		 if(y<bodheight)
		 {
			 y		= event.y
		 }
		 else {
			y		= y - (document.getElementById("tooltiplayer").offsetHeight*2)
		 }

		y	+=document.body.scrollTop
		x	+=document.body.scrollLeft

		document.getElementById("tooltiplayer").style.posLeft= x
		document.getElementById("tooltiplayer").style.posTop = y
		//document.getElementById("tooltiplayer").style.posLeft =160 ;//(8,147)in order to fix the tooltip table exactly to the orderable desc.
		document.getElementById("tooltiplayer").style.visibility='visible'
	}

function alignHeading(order_set_bill_yn)
{
	var row=1;
	if(parent.parent.ExistingOrderHeader.document.getElementById("tableheader")!=null)
	{
		parent.parent.ExistingOrderHeader.document.getElementById("tableheader").width =	eval(document.getElementById("tableresult").offsetWidth);
				
		if(order_set_bill_yn=="Y")
		{
			row=2;
		}
		else
		{
			row=1;
		}
		if(document.getElementById("tableresult")!=null&&document.getElementById("tableresult").rows(row)!=null)
		{
			for (j=0; j < document.getElementById("tableresult").rows(row).cells.length; j++) 
			{
				var wid=eval(document.getElementById("tableresult").rows(row).cells(j).offsetWidth);
				
				if(parent.parent.ExistingOrderHeader.document.getElementById("tableheader").rows(0).cells(j) != null)
				{
					parent.parent.ExistingOrderHeader.document.getElementById("tableheader").rows(0).cells(j).width=wid;
				}
			}
		}
	}
}


function moveFrame()
{
	var temp=document.body.scrollLeft;
	scrollValue=temp;

	if(parent.parent.ExistingOrderHeader.location.href.indexOf(".jsp") != -1)
	{
		parent.parent.ExistingOrderHeader.document.body.scrollLeft=temp;
	}
}

function callMouseOverOnTD_oth(obj){
	
	 if (prevObjID != null)
	 {			 
		 eval("document.all."+prevObjID).className = 'gridDataBlue';
		 eval("document.all."+prevImgObj).src = "../../eCommon/images/inactiveArrow.gif";			 
	 }		 		
}

function resizeWindow1(){

	            bodwidth = parent.frames[0].document.body.offsetWidth;
	            bodheight = parent.frames[0].document.body.offsetHeight;
				//bodwidth = parent.frames[2].document.body.offsetWidth
				//bodheight = parent.frames[2].document.body.offsetHeight

				var x =event.x;
				var y =event.y;

				x = x + (document.getElementById("tooltiplayer").offsetWidth);
				y = y + (document.getElementById("tooltiplayer").offsetHeight);
				
				if(x<bodwidth){					
					x =event.x;
				}else
					x = x - (document.getElementById("tooltiplayer").offsetWidth*2)

				if(y<bodheight)
				{
					 y =event.y;
				}
				else {
					y = y - (document.getElementById("tooltiplayer").offsetHeight*2);
				}

					y+=document.body.scrollTop;
					x+=document.body.scrollLeft;

					document.getElementById("tooltiplayer").style.posLeft= x;
					document.getElementById("tooltiplayer").style.posTop = y;
					document.getElementById("tooltiplayer").style.visibility='visible';
	}

	function displayElapsedFields(Obj)
	{
		var order_category="";
		if(Obj.value=="A")
		{
			order_category=parent.ExistingOrderSearch.document.existing_order_search.order_category.value;
			if(order_category!=""&&((order_category=="RX")||(order_category=="MI")||(order_category=="OT")||(order_category=="OH")))
			{
				parent.ExistingOrderSearch.document.existing_order_search.all.innerHTML=getLabel("eOR.ElapsedOrders.label","OR")+"<input type='checkbox' name='elapsed_orders' id='elapsed_orders' value='N' onclick='ChkElapseOrders()'>";
				if(parent.ExistingOrderSearch.document.existing_order_search.all.displayOrders)
					parent.ExistingOrderSearch.document.existing_order_search.all.displayOrders.style.visibility="visible";
				if(parent.ExistingOrderSearch.document.existing_order_search.all.elapsed_orders)
				{
					parent.ExistingOrderSearch.document.existing_order_search.all.elapsed_orders.checked=false;
					parent.ExistingOrderSearch.document.existing_order_search.all.elapsed_orders.disabled=true;
					parent.ExistingOrderSearch.document.existing_order_search.all.elapsed_orders.value="N";
				}
			}
			else
			{
				parent.ExistingOrderSearch.document.existing_order_search.all.displayOrders.innerHTML=getLabel("eOR.ElapsedOrders.label","OR")+"<input type='checkbox' name='elapsed_orders' id='elapsed_orders' value='N' onclick='ChkElapseOrders()'>";
				if(parent.ExistingOrderSearch.document.existing_order_search.all.displayOrders)
				parent.ExistingOrderSearch.document.existing_order_search.all.displayOrders.style.visibility = "visible";
				if(parent.ExistingOrderSearch.document.existing_order_search.all.elapsed_orders)
				{
					parent.ExistingOrderSearch.document.existing_order_search.all.elapsed_orders.checked=false;
					parent.ExistingOrderSearch.document.existing_order_search.all.elapsed_orders.disabled=false;
					parent.ExistingOrderSearch.document.existing_order_search.all.elapsed_orders.value="N";
				}
			}
		}
		else
		{
			if((Obj.value=="Z")||(Obj.value=="D"))
			{
				parent.ExistingOrderSearch.document.existing_order_search.all.displayOrders.innerHTML=getLabel("eOR.IncludeSystemCancelledOrders.label","OR")+"<input type='checkbox' name='sys_cancelled_orders' id='sys_cancelled_orders' value='' onclick='ChkSysCancelledOrders()'>";
				if(parent.ExistingOrderSearch.document.existing_order_search.all.displayOrders)
					parent.ExistingOrderSearch.document.existing_order_search.all.displayOrders.style.visibility="visible";
			}
			else
			{
				if(parent.ExistingOrderSearch.document.existing_order_search.all.displayOrders)
					parent.ExistingOrderSearch.document.existing_order_search.all.displayOrders.style.visibility="hidden";
			}
			//parent.ExistingOrderSearch.document.existing_order_search.all.ElapsedOrders.style.visibility="hidden";
		}
	}

	function ChkElapseOrders()
	{
		if(parent.ExistingOrderSearch.document.existing_order_search.all.elapsed_orders)
		{
			if(parent.ExistingOrderSearch.document.existing_order_search.all.elapsed_orders.checked==true)
			{
				parent.ExistingOrderSearch.document.existing_order_search.all.elapsed_orders.value="Y";
			}
			else
			{
				parent.ExistingOrderSearch.document.existing_order_search.all.elapsed_orders.value="N";
			}
		}
	}

	function callMultiPatientOrders()
	{
		var query_string = "";
		if(document.getElementById("qry_string")!=null)
		{
			query_string = document.getElementById("qry_string").value;
		}		
		top.content.workAreaFrame.location.href="../../eOR/jsp/MultiPatientOrders.jsp?"+query_string;
	}

	/*Added by Arvind on 3/3/2010 for IN012637 to open medadminchart*/
	function viewMedication(patient_id,nursing_unit,admin_date,patient_class) 
	{
		var dialogHeight	= "35";
		var dialogWidth		= "60";
		var dialogTop		= "100";
		var dialogLeft		= "50";
		var center			= "0";
		var status			= "no";
		var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments		= "";
		retVal 				= window.showModalDialog("../../ePH/jsp/QueryMednAdminChart.jsp?patient_id="+patient_id+"&nursing_unit="+nursing_unit+"&admin_date="+admin_date+"&patient_class="+patient_class+"&called_from=OR",arguments,features);
	}
	/*Ends Here IN012637*/
	function ChkSysCancelledOrders()
	{
		if(parent.ExistingOrderSearch.document.existing_order_search.all.sys_cancelled_orders)
		{
			if(parent.ExistingOrderSearch.document.existing_order_search.all.sys_cancelled_orders.checked==true)
			{
				parent.ExistingOrderSearch.document.existing_order_search.all.sys_cancelled_orders.value="Y";
			}
			else
			{
				parent.ExistingOrderSearch.document.existing_order_search.all.sys_cancelled_orders.value="N";
			}
		}
	}
//Menaka Starts
/*
function compressHeaderFrames()
{
	parent.ExistingOrderSearch.document.getElementById("detailTable").style.display="none";
	parent.ExistingOrderSearch.document.getElementById("headerLineTable").style.display="inline";
	parent.ExistingOrderResult.document.existing_order_dtl.tableresult.style.display="inline";
}
function expandHeaderFrames()
{
	parent.ExistingOrderSearch.scrolling="auto";
	parent.ExistingOrderSearch.document.getElementById("detailTable").style.display="inline";
	parent.ExistingOrderSearch.document.getElementById("headerLineTable").style.display="none";
}*/
//Menaka Ends

