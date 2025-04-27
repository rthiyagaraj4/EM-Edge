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
Date       		Edit History      Name        	Rev.Date	Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
?             	100            		?           created
24/11/2011    	IN029659       	Chowminya G    	Incident No: IN029659 - <System allows to place the new orders using Copy Previous Order function- CRF Linked Issue> 
25/09/2012		IN030279		Ramesh G		Bru-HIMS-CRF-160
19/10/2012    	IN033061      	Chowminya G  	System doesnt display menu cancel/discontinue if the orders are IV Fluid ,IV Fluid+Drug, IV Fluid+Drug(Frequency).
17/12/2012		IN036674		Ramesh G		When we Cancel or Discontinue we get a message as ?Queries caused no records?.
11/01/2012		IN037290		Chowminya G		 Place Order Set->Existing Orders-Header level-> Amend > system is displaying Script Error.
13/08/2013	    IN042045		Chowminya G	    System should not allow to copy for the drugs for which Verbal Order Applicable is not selected
14/03/2014	  	IN047658		Vijayakumar K	17/03/2014	Chowminya G		Clinician Access ? Webpage dialog Some webpage 
21/04/2014	  IN047658		Vijayakumar K		14/03/2014		Chowminya G		Reopen - Result Reporting > Result Entry ?Comments-webpage
-------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        		Rev.Date		Rev.Name 		Description
-------------------------------------------------------------------------------------------------------------------------------
11/08/2014		IN049419		Ramesh/Karthi L										An Audit Trail for Additional Information Amendment of Order
19/03/2015  	IN052649		Ramesh G											Previous orders - Default filter to be filtered by All or by specialty
21/10/2015		IN057196		Ramesh G											Recording Of Consent Form
29/04/2016	    IN060148   		Raja S												MMS-MD-SCF-0009 (Order entry scrren,EXPLANATORY_TEXT
																					is not showing while the mouse moveover(IE11))
13/04/2017		IN064010		Raja S												AAKH-SCF-0322
09/06/2017	    IN063816		Krishna Gowtham J	09/06/2017		Ramesh G		GHL-CRF-0445.1	
27/06/2017  	IN064614		Vijayakumar K		27/06/2017		Ramesh G		CRF-OR-GHL-CRF-0445.1/03 - Unable to place order if report server is down / having issue. [IN:064614]
28/08/2017		IN065091		Krishna Gowtham J 	29/08/2017		Ramesh G		GHL-CRF-0440.1
15/12/2017		IN065942		Dinesh T			15/12/2017		Ramesh G			In Nuclear medicine  department we required the barcode functionality at the time
																					of Registration of order,required patient Id,patient name,age,sex,register date and name of study.
23/07/2018		IN64543			Dinesh T			23/07/2018		Ramesh G		ML-MMOH-CRF-0776
19/04/2018	    IN067327		Prakash C			19/04/2018		Ramesh G		ML-MMOH-CRF-1025	
18/07/2018      IN061961		sivabagyam M       	18/07/2018		Ramesh G		GHL-CRF-0433
16/10/2018	    IN066709		Prakash C	   		16/10/2018		Ramesh G 		ML-MMOH-CRF-1101
17/10/2018		IN067817		sivabagyam	 		17/10/2018	    Ramesh G       	ML-MMOH-CRF-1198	
27/05/2019		IN069027		Ramesh G											MMS-DM-CRF-0150
13/06/2019     IN070698              sivabagyam	          13/06/2019          Ramesh G		SKR-SCF-1227
14/10/2019  	IN071315	    Nijitha S   		14/10/2019  	Ramesh G		GHL-CRF-0607
04/08/2020		IN073562		Nijitha S	04/08/2020	Remesh G	MMS-KH-CRF-0029.4/01
24/09/2020		IN074110		Nijitha S	24/09/2020	Remesh G	MMS-KH-CRF-0029.4/05
14/10/2020		IN073985		SIVABAGYAM M	14/10/2020	RAMESH G	ML-MMOH-SCF-1607
31/05/2023		44884		Krishna		31/05/2023		Ramesh G 	MO-CRF-20183
07/09/2023	  31792	   Ranjith P R		08/09/2023		RAMESH G		ML-MMOH-CRF-1913
-------------------------------------------------------------------------------------------------------------------------------
*/
var function_id 	= "" ;
var result 			= false; 
var message 		= "" ;
var flag 			= "" ;
var qry_string 		= "";
var totCountGlobal 	= "";
var errorMessage	= "";

async function callMultipleConsent(order_type_code,catalog_code,catalog_desc,order_id,order_line_num,order_category,index){

	var dialogHeight		= '90vh';
	var dialogWidth			= '80vw';
	var dialogTop			= '150';
	var dialogLeft			= '100' ;
	var title				= ''
	var	arguments			= "";	
	var	features			= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + ';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var bean_id				=  "";
	var bean_name			=  "";
	bean_id		= document.existing_order_dtl.bean_id.value;
	bean_name	= document.existing_order_dtl.bean_name.value;
	var retVals				=  await top.window.showModalDialog("../../eOR/jsp/ExistingOrderMultipleConsentFrameSet.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&index="+index+"&consent_form_id="+"&order_catalog_code="+catalog_code+"&order_catalog_desc="+catalog_desc+"&order_id="+order_id+"&order_line_num="+order_line_num+"&order_category="+order_category+"&order_type_code="+order_type_code+"&viewBy=line",arguments,features);
}
async function callMultipleConsentHdr(order_type_code,order_id,order_category,index){
	var dialogHeight		= '37.5';
	var dialogWidth			= '50';
	var dialogTop			= '150';
	var dialogLeft			= '100' ;
	var title				= ''
	var	arguments			= "";	
	var	features			= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + ';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var bean_id				=  "";
	var bean_name			=  "";
	bean_id		= document.existing_order_dtl.bean_id.value;
	bean_name	= document.existing_order_dtl.bean_name.value;
	var retVals				= await  window.showModalDialog("../../eOR/jsp/ExistingOrderMultipleConsentFrameSet.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&index="+index+"&order_id="+order_id+"&order_category="+order_category+"&order_type_code="+order_type_code+"&viewBy=header",arguments,features);
}
//IN057196 Start.
//IN066709 Start
//function callConsentRec(patient_id,order_id){ 
async function callConsentRec(patient_id,order_id,date){	
//IN066709 Ends
	var dialogHeight		= '90vh';
	var dialogWidth			= '80vw';
	var dialogTop			= '150';
	var dialogLeft			= '100' ;
	var title				= ''
	var	arguments			= "";	
	var	features			= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + ';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var bean_id				=  "";
	var bean_name			=  "";
	bean_id		= document.existing_order_dtl.bean_id.value;
	bean_name	= document.existing_order_dtl.bean_name.value;
	//var retVals				=  window.showModalDialog("../../eOR/jsp/ConsentOrders.jsp?patient_id="+patient_id+"&order_id="+order_id+"&fromDate="+document.existing_order_dtl.date_from.value+"&toDate="+document.existing_order_dtl.date_to.value+"&calledFrom=RECORD_CONSENT_WITH_ORDER",arguments,features);commented for IN066709	
	var retVals				=  await top.window.showModalDialog("../../eOR/jsp/ConsentOrders.jsp?patient_id="+patient_id+"&order_id="+order_id+"&fromDate="+document.existing_order_dtl.date_from.value+"&toDate="+document.existing_order_dtl.date_to.value+"&calledFrom=RECORD_CONSENT_WITH_ORDER"+"&date="+date,arguments,features);//IN066709 added "date" parameter
	if(retVals==undefined){
		//IN067327 starts		
			document.location.href=document.location.href;//IN067327
		//IN067327 ends
		document.location.reload();
	}
}
//IN057196 End.
//IN067817 starts
async function callNotifyDetailsHdr(order_id,facility_id){
	var dialogHeight		= '35';
	var dialogWidth			= '64.9';
	var dialogTop			= '150';
	var dialogLeft			= '100' ;
	var title				= ''
	var	arguments			= "";	
	var	features			= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + ';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var retVals				=  await window.showModalDialog("../../eOR/jsp/NotifyDetails.jsp?&order_id="+order_id+"&facility_id="+facility_id,arguments,features);
}
//IN067817 ends
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

//called on click of search
function populateValues()
{
	var from_date = document.existing_order_search.date_from ;
	var to_date  = document.existing_order_search.date_to ;
	var localeName = document.existing_order_search.localeName.value;
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

	 qry_string = "patientId="+document.existing_order_search.patientId.value+"&encntr_id="+document.existing_order_search.encntr_id.value+"&ord_status="+document.existing_order_search.ord_status.value+"&order_by="+document.existing_order_search.order_by.value+"&catalog="+encodeURIComponent(catalog)+"&view="+document.existing_order_search.view.value+"&priority="+document.existing_order_search.priority.value+"&date_from="+document.existing_order_search.date_from.value+"&date_to="+document.existing_order_search.date_to.value+"&order_category="+document.existing_order_search.order_category.value+"&order_type="+document.existing_order_search.order_type.value+"&view_by="+document.existing_order_search.view_by.value+"&search_criteria="+document.existing_order_search.search_criteria.value+"&cosign="+document.existing_order_search.cosign.value+"&activity_type="+document.existing_order_search.activity_type.value+"&elapsed_orders="+elapsed_orders+"&sys_cancelled_orders="+sys_cancelled_orders;

	 qry_string = qry_string+"&recordConsentWithOrder="+document.existing_order_search.recordConsentWithOrder.value; //IN057196
	 qry_string = qry_string+"&cnsnt_with_order_yn="+document.existing_order_search.cnsnt_with_order_yn.value; //IN057196
	 qry_string = qry_string+"&BTColorYN="+document.existing_order_search.BTColorYN.value;//IN065091
	 qry_string = qry_string+"&existing_order_called_from_new="+document.existing_order_search.existing_order_called_from_new.value;//IN074110
	    
	var qry_string_fr_ammend = "&pract_reln_id="+document.existing_order_search.pract_reln_id.value+"&location_type="+document.existing_order_search.location_type.value+"&location_code="+document.existing_order_search.location_code.value+"&patient_class="+document.existing_order_search.patient_class.value+"&p_called_from_ca="+document.existing_order_search.p_called_from_ca.value+"&sex="+document.existing_order_search.sex.value+"&age="+document.existing_order_search.age.value+"&dob="+document.existing_order_search.dob.value+"&visit_adm_date="+document.existing_order_search.visit_adm_date.value+"&function_from="+document.existing_order_search.function_from.value
	
	document.existing_order_search.search.disabled = true;
	//parent.ExistingOrderHeader.location.href = "../jsp/ExistingOrderHeader.jsp?"+qry_string+qry_string_fr_ammend
	parent.ExistingOrderResult.location.href = "../jsp/ExistingOrderResultsFrameset.jsp?"+qry_string+qry_string_fr_ammend
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

	//IN063816 start
	if(formObj.call_from_barcode_btn != null)
	{
		formObj.call_from_barcode_btn.value = "N";//IN063816
	}
	//IN063816 ends
	if(formObj){
		for(cnt=0; cnt<formObj.total_recs.value; cnt++){
			val = eval("parent.ExistingOrderResult.ExistingOrderResult.document.existing_order_dtl.chk"+cnt);
		
			if(val.checked == true){
				val.value = "Y";
				no_of_checked++;
			}
		}
	}

	var prn_lab_no_of_chked = prnRegLabelChk();//IN065942

	//if(parseInt(no_of_checked) == 0){//IN065942
	if(parseInt(no_of_checked) == 0 && prn_lab_no_of_chked == 0){//IN065942
		alert(getMessage('CLICK_ANY_ONE','OR'))
		return false
	}
	var bean_id = formObj.bean_id.value ;
	//alert(formApply( parent.ExistingOrderResult.ExistingOrderResult.document.existing_order_dtl,OR_CONTROLLER)) ;

	
	eval(formApply( parent.ExistingOrderResult.ExistingOrderResult.document.existing_order_dtl,"../../eOR/jsp/ExistingOrderPrintValidate.jsp")) ;

	prnRegLabel();

	//if( result ) {
		//onSuccess();//IN065942
		callOnSuccess(no_of_checked,prn_lab_no_of_chked);//IN065942
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

	//if(chckDate2(obj)){ //  this method is from ValidateControl.js

		//if(doDateCheckOR(fromDate,toDate) == 1) { // this function is available in eOR/js/orCommonFunctions.js
	//if(CheckDate(obj)){	//this method is commented for thai date conversion	
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

//function callMenuFunctions(colval1,patient_id,ord_cat,colval,orderId,cont_order_ind,order_status,sex,ord_typ_code,catalog_code,encounter_id,pat_class,location_code,location_type,episode_id,episode_visit_num){//IN074110
async function callMenuFunctions(colval1,patient_id,ord_cat,colval,orderId,cont_order_ind,order_status,sex,ord_typ_code,catalog_code,encounter_id,pat_class,location_code,location_type,episode_id,episode_visit_num,existing_order_called_from_new){//IN074110
	var p_called_from_ca = document.existing_order_dtl.p_called_from_ca.value;//IN071315
	if(ord_typ_code==null)
		ord_typ_code="";

		colval=unescape(colval)
		if(colval1=="Hold")
		{
			var dialogHeight ='17' ;
			var dialogWidth = '25' ;
			var dialogTop	= '189';
			var dialogLeft = '167' ;
		}else if(colval1=="Resume")
		{
			var dialogHeight ='10' ;
			var dialogWidth = '40' ;
			var dialogTop	= '189';
			var dialogLeft = '167' ;
		}
		else if(colval1 == "Discontinue"||colval1=="Cancel") 
		{		
			var dialogHeight ='22' ;
			var dialogWidth = '25' ;
			var dialogTop	= '189';
			var dialogLeft = '167' ;
		}
		else if(colval1=="LinkToCurrentEncounter")
		{
			var dialogHeight ='100' ;
			var dialogWidth = '100' ;
			var dialogTop	= '100';
			var dialogLeft = '30' ;
		}
		else
		{
			/*var dialogHeight ='35' ;
			var dialogWidth = '60' ;
			var dialogTop	= '129';
			var dialogLeft = '11' ;*/
			var dialogHeight ='90vh' ;
			var dialogWidth = '95vw' ;
			var dialogTop	= '10';
			var dialogLeft = '10' ;
		}

		var title = 'rewe'
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';

		var arguments = "";
		if((colval1=="ViewReplacedOrder")||(colval1=="ViewOriginalOrder"))
		{
			var xmlDoc = ""; 
			var xmlHttp = new XMLHttpRequest();
			var bean_id				=  "";
			var bean_name			=  "";
			bean_id		  = document.existing_order_dtl.bean_id.value;
			bean_name	  = document.existing_order_dtl.bean_name.value;
			var func_mode = colval1;
			xmlStr ="<root><SEARCH " ;
			xmlStr += " orderId=\""+ orderId +"\" " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "ExistingOrderValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate="+func_mode,false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText = xmlHttp.responseText ;
			if((responseText!=null)||(responseText!=undefined))
				orderId = responseText;
		}
		
		//var finalString	= "from=header&colval1="+colval1+"&colval="+encodeURIComponent(colval)+"&orderId="+orderId+"&val1="+ord_cat+"&patient_id="+patient_id+"&cont_order_ind="+cont_order_ind+"&order_status="+order_status+"&sex="+sex+"&ord_cat="+colval+"&ord_typ_code="+ord_typ_code+"&catalog_code="+catalog_code+"&ord_cat_id="+ord_cat+"&encounter_id="+encounter_id+"&patient_class="+pat_class;//Commented for IN071315

		//var finalString	= "from=header&colval1="+colval1+"&colval="+encodeURIComponent(colval)+"&orderId="+orderId+"&val1="+ord_cat+"&patient_id="+patient_id+"&cont_order_ind="+cont_order_ind+"&order_status="+order_status+"&sex="+sex+"&ord_cat="+colval+"&ord_typ_code="+ord_typ_code+"&catalog_code="+catalog_code+"&ord_cat_id="+ord_cat+"&encounter_id="+encounter_id+"&patient_class="+pat_class+"&p_called_from_ca="+p_called_from_ca;//Added for IN071315
		var finalString	= "from=header&colval1="+colval1+"&colval="+encodeURIComponent(colval)+"&orderId="+orderId+"&val1="+ord_cat+"&patient_id="+patient_id+"&cont_order_ind="+cont_order_ind+"&order_status="+order_status+"&sex="+sex+"&ord_cat="+colval+"&ord_typ_code="+ord_typ_code+"&catalog_code="+catalog_code+"&ord_cat_id="+ord_cat+"&encounter_id="+encounter_id+"&patient_class="+pat_class+"&p_called_from_ca="+p_called_from_ca+"&existing_order_called_from_new="+existing_order_called_from_new;//Added for IN071315//IN074110
	
		if(colval1 == "LinkToCurrentEncounter")
		{
			//Added for IN064010 Starts
			var ord_class=orderId.substring(0,2);
			if("PH"==ord_class && "DC"==pat_class)
				pat_class="IP";
			//Added for IN064010 Ends
			var futureOrderString	= "called_from=ExistingOrder&colval1="+colval+ "&colval=" +colval+"&orderId="+ orderId+"&ord_cat="+ ord_cat+"&ord_typ_code="+ ord_typ_code+"&catalog_code="+ catalog_code+"&p_patient_id="+ patient_id+"&cont_order_ind="+ cont_order_ind+"&order_status="+ order_status+"&sex="+ sex+ colval+"&p_encounter_id="+encounter_id+"&p_patient_class="+pat_class+"&can_reason="+colval+"&p_source_code="+location_code+"&p_source_type="+location_type+"&p_episode_id="+episode_id+"&p_episode_visit_num="+episode_visit_num;
			 var retVals = await top.window.showModalDialog("../../eOR/jsp/FutureOrderDtl.jsp?"+futureOrderString,arguments,features);
		}
		else
		{
			var retVals = await top.window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);
		}
	
 		if(colval1 != "View" && colval1!="ViewReplacedOrder" && colval1!="ViewOriginalOrder")
			reloadValues();
}

async function callRenewFunctions(orderId,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,sex,age,dob,visit_adm_date,iv_prep_yn,colval1,queryString){
		//unescape(colval)

			var dialogHeight ='15' ;
			var dialogWidth = '50' ;
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


	var dialogHeight ='15' ;
	var dialogWidth = '50' ;
	var dialogTop	= '105';
	var dialogLeft = '167' ;

	var title = 'rewe';
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

	var arguments = "";
	amend_called_from = "existing_order";

	var finalString = queryString + "&order_id="+orderId+"&order_line_num="+order_line_num;



	var retVals =await  window.showModalDialog("../../eOR/jsp/ExistingOrderRenewFrameset.jsp?"+finalString,arguments,features);



		reloadValues();

}
//IN049419 Start.
//function callAmmendFunctions(orderId,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,sex,age,dob,visit_adm_date,iv_prep_yn,colval1){
async function callAmmendFunctions(orderId,patient_id,ord_cat,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,sex,age,dob,visit_adm_date,iv_prep_yn,colval1){
//IN049419 End.
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
			var dialogHeight ='100vh' ;
			var dialogWidth = '100vw' ;
			var dialogTop	= '100';
			var dialogLeft = '100' ;

		var title = 'rewe'
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

		var arguments = "";
		var amend_called_from = "existing_order";

		var finalString = "ammend_called_from="+amend_called_from+"&order_id="+orderId+"&patient_id="+patient_id+"&episode_id="+encntr_id+"&pract_reln_id="+pract_reln_id+"&location_type="+location_type+"&location_code="+location_code+"&patient_class="+patient_class+"&p_called_from_ca="+p_called_from_ca+"&Sex="+sex+"&Age="+age+"&Dob="+dob+"&visit_adm_date="+visit_adm_date+"&iv_prep_yn="+iv_prep_yn;
		var retvalue =""; //IN049419 
		if (colval1 == "Renew") {
			finalString += "&function_from=RENEW_ORDER";
		} else if (colval1 == "Ammend") {
			finalString += "&function_from=AMEND_ORDER";
			//IN049419 Start.			
			var xmlDoc = ""; 
			var xmlHttp = new XMLHttpRequest() ;
			var bean_id	 		= "@existingorderbean"+patient_id+encntr_id;
			var bean_name = "eOR.ExistingOrder";
			
			var validate = "AMMEND";
			xmlStr ="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "ExistingOrderValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate="+validate,false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText = (xmlHttp.responseText).replace(/^\s+|\s+$/gm,'') ;
			var auditTrailDtls = responseText.split("|");
			if("Y"==auditTrailDtls[0] && "Y"==auditTrailDtls[1]){
				var dialogHeight1 ='100vh' ;
				var dialogWidth1 = '90vw' ;
				var dialogTop1	= '100';
				var dialogLeft1 = '200' ;

				var title1 = 'rewe'
				var features1 = 'dialogHeight:' + dialogHeight1 + '; dialogWidth:' + dialogWidth1 +';dialogTop:'+dialogTop1+';dialogLeft:'+dialogLeft1+';dialogTitle:'+title+'; scroll=yes; status=no';
				var finalString1 ="ord_cat="+ord_cat+"&amendReasonMandYN="+auditTrailDtls[2]+"&bean_id="+bean_id+"&bean_name="+bean_name;
				
				retvalue=await top.window.showModalDialog("../../eOR/jsp/OrderAmendReason.jsp?"+finalString1,arguments,features1);				
				//window.open("../../eOR/jsp/OrderAmendReason.jsp?"+finalString1,"",arguments,features1);
				finalString +="&amendDesc="+retvalue;				
			}
			
		}
  		
		if(retvalue!="WindowClose" && retvalue!=undefined)
			await top.window.showModalDialog("../../eOR/jsp/EnterOrder.jsp?"+finalString,arguments,features);
		//var retVals = window.showModalDialog("../../eOR/jsp/EnterOrder.jsp?"+finalString,arguments,features);
		//IN049419 En
		
		if(p_called_from_ca!="PH")
			reloadValues(); 

}
//INo57196 Start.
//function callAmmendFunctions1(colval1,val1,ord_cat,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn) {
async function callAmmendFunctions1(colval1,val1,ord_cat,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn,cnsnt_with_order_yn) {
//INo57196 End.
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
	
	var dialogHeight ='90vh' ;
	var dialogWidth = '80vw' ;
	var dialogTop	= '107';
	var dialogLeft = '169' ;
	var title = 'rewe';
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

	var arguments = "";
	amend_called_from = "existing_order";

	var finalString = "ammend_called_from="+amend_called_from+"&order_id="+orderId+"&patient_id="+patient_id+"&episode_id="+encntr_id+"&pract_reln_id="+pract_reln_id+"&location_type="+location_type+"&location_code="+location_code+"&patient_class="+patient_class+"&p_called_from_ca="+p_called_from_ca+"&Sex="+sex+"&Age="+age+"&Dob="+dob+"&visit_adm_date="+visit_adm_date+"&iv_prep_yn="+iv_prep_yn+"&order_line_num="+order_line_num+"&catalog_code="+catalog_code;

	var retvalue =""; //IN049419 
    if (colval1 == "Renew") {
		finalString += "&function_from=RENEW_ORDER";
	} else if (colval1 == "Amend") {
		finalString += "&function_from=AMEND_ORDER";
		//IN049419 Start.			
		var xmlDoc = ""; 
		var xmlHttp = new XMLHttpRequest() ;
		var bean_id	 		= "@existingorderbean"+patient_id+encntr_id;
		var bean_name = "eOR.ExistingOrder";
		
		var validate = "AMMEND";
		xmlStr ="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "ExistingOrderValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate="+validate,false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText = (xmlHttp.responseText).replace(/^\s+|\s+$/gm,'') ;
		var auditTrailDtls = responseText.split("|");
		if("Y"==auditTrailDtls[0] && "Y"==auditTrailDtls[1]){
			var dialogHeight1 ='90vh' ;
			var dialogWidth1 = '80vw' ;
			var dialogTop1	= '100';
			var dialogLeft1 = '200' ;

			var title1 = 'rewe'
			var features1 = 'dialogHeight:' + dialogHeight1 + '; dialogWidth:' + dialogWidth1 +';dialogTop:'+dialogTop1+';dialogLeft:'+dialogLeft1+';dialogTitle:'+title+'; scroll=yes; status=no';
			var finalString1 ="ord_cat="+ord_cat+"&amendReasonMandYN="+auditTrailDtls[2]+"&bean_id="+bean_id+"&bean_name="+bean_name;
			
			retvalue=await top.window.showModalDialog("../../eOR/jsp/OrderAmendReason.jsp?"+finalString1,arguments,features1);				
			//window.open("../../eOR/jsp/OrderAmendReason.jsp?"+finalString1,"",arguments,features1);
			finalString +="&amendDesc="+retvalue;
			finalString +="&cnsnt_with_order_yn="+cnsnt_with_order_yn;  //INo57196
		}	
		
	}	
		
	if(retvalue!="WindowClose" && retvalue!=undefined)
		await top.window.showModalDialog("../../eOR/jsp/EnterOrder.jsp?"+finalString,arguments,features);
	//var retVals = window.showModalDialog("../../eOR/jsp/EnterOrder.jsp?"+finalString,arguments,features);
	//IN049419 En
	
	if(p_called_from_ca!="PH")
		reloadValues();
}

//function callMenuFunctions1(colval1,colval,orderId){
//Passing iv_prep_yn --[IN033061]
//function callMenuFunctions1(colval,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,cont_order_ind,order_status,sex,ord_typ_code,encntr_id,pat_class,location_code,location_type,episode_id,episode_visit_num,iv_prep_yn){//IN64543
//function callMenuFunctions1(colval,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,cont_order_ind,order_status,sex,ord_typ_code,encntr_id,pat_class,location_code,location_type,episode_id,episode_visit_num,iv_prep_yn,instrn_type){//IN64543
//function callMenuFunctions1(colval,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,cont_order_ind,order_status,sex,ord_typ_code,encntr_id,pat_class,location_code,location_type,episode_id,episode_visit_num,iv_prep_yn,instrn_type,view_by){//IN061961//Commented for IN071315
async function callMenuFunctions1(colval,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,cont_order_ind,order_status,sex,ord_typ_code,encntr_id,pat_class,location_code,location_type,episode_id,episode_visit_num,iv_prep_yn,instrn_type,view_by,p_called_from_ca,existing_order_called_from_new){//IN061961//Added for IN071315//Added existing_order_called_from_new for IN074110
	unescape(colval)
		//unescape(item_narration)
  
	//for(var i=0;i<=item_narration;i++)
		item_narration =eval('document.existing_order_dtl.item_narration'+item_narration).value;		

		if(item_narration==null)	item_narration="";
		if(colval == "Instructions")
		{
			//var dialogHeight ='10.5' ; // commented IN049419
			var dialogHeight ='42vh' ; // modified IN049419
			//IN047658 starts
			//var dialogWidth = '36' ;
			//IN047658 - reopen starts
			//var dialogWidth = '40' ;
			//IN047658 ends
			var dialogWidth = '45vw';
			//IN047658 - reopen ends
			var dialogTop	= '189';
			var dialogLeft = '167' ;
			//IN64543, starts
			if("E"==instrn_type)
			{				
				var dialogHeight ='40' ;
				var dialogWidth = '40';								
			}
			//IN64543, ends
			
		} //Modified by Uma on 2/11/2010 for package billing
		else if ((colval == "View") || (colval=="ViewReplacedOrder") || (colval=="ViewOriginalOrder") || (colval=="Replace")) 
		{
				var dialogHeight ='91vh' ;
				var dialogWidth = '70vw' ;
				var dialogTop	= '100';
				var dialogLeft = '30' ;
		} 
		else if(colval=="Cancel"||colval=="Discontinue"||colval=="Hold")
		{
			if((iv_prep_yn == "1" || iv_prep_yn == "2" || iv_prep_yn == "3" || iv_prep_yn == "4" || iv_prep_yn == "5") && colval=="Cancel")//--[IN033061]
			{
      //IN070698 STARTS
				var dialogHeight ='37.5' ;
				var dialogWidth = '53' ;//changed from 50-53
				var dialogTop	= '100';
				var dialogLeft = '30' ;
        //IN070698 ENDS
			}
			else
			{
      //IN070698 STARTS
			var dialogHeight ='41vh' ;//changed from 22-23
			//IN047658 starts
			//var dialogWidth = '25' ;
			//IN047658 -reopen starts
			//var dialogWidth = '30' ;
			//IN047658 ends
			var dialogWidth = '40vw';//changed from 35-38
			//IN047658 -reopen ends
			var dialogTop	= '189';
			var dialogLeft = '167' ;
         //IN070698 ENDS
			}
		}
		else if(colval=="Preps"||colval=="Comments")
		{
			//var dialogHeight ='12' ; // IN049419
			var dialogHeight ='38vh' ; // IN049419
			//IN047658 starts
			//var dialogWidth = '30' ;
			//IN047658 -reopen starts
			//var dialogWidth = '35';
			//IN047658 ends
			var dialogWidth = '34vw';
			//IN047658 -reopen ends
			var dialogTop	= '189';
			var dialogLeft = '167' ;
			
			//IN64543, starts
			if("E"==instrn_type)
			{
				var dialogHeight ='40' ;				
				var dialogWidth = '40';			
			}
			//IN64543, ends
		}
		else if(colval=="LinkToCurrentEncounter")
		{
			var dialogHeight ='42' ;
			var dialogWidth = '100' ;
			var dialogTop	= '100';
			var dialogLeft = '30' ;
		}
		else if(colval=="InteractionDtls")//IN072654 Starts
		{
			var dialogHeight   = "80vh" ;
			var dialogWidth    = "65vw" ;
			var dialogTop      = "100";
			var dialogLeft     = "100";
		}//IN072654 Ends
		else
		{
			var dialogHeight ='11' ;
			var dialogWidth = '40' ;
			var dialogTop	= '189';
			var dialogLeft = '167' ;
		}
		//if((colval=="ViewReplacedOrder")||(colval=="ViewOriginalOrder"))//IN072654
		if((colval=="ViewReplacedOrder")||(colval=="ViewOriginalOrder")||(colval=="InteractionDtls"))//IN072654
		{
			var xmlDoc = ""; 
			var xmlHttp = new XMLHttpRequest() ;
			var bean_id				=  "";
			var bean_name			=  "";
			bean_id		  = document.existing_order_dtl.bean_id.value;
			bean_name	  = document.existing_order_dtl.bean_name.value;
			var func_mode = colval;
			xmlStr ="<root><SEARCH " ;
			xmlStr += " orderId=\""+ orderId +"\" " ;
			xmlStr += " catalog_code=\""+ catalog_code +"\" " ;//IN072654
			xmlStr += " order_line_num=\""+ order_line_num +"\" " ;//IN072654
			xmlStr += " patient_id=\""+ patient_id +"\" " ;//IN073562
			xmlStr += " encounter_id=\""+ encntr_id +"\" " ;//IN073562
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
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
		//var finalString	= "from=line&colval1="+colval+ "&colval=" +colval+"&orderId="+ orderId+"&ord_cat="+ ord_cat+"&ord_typ_code="+ ord_typ_code+"&val1="+ val1+"&cancel_type="+ cancel_type+"&order_line_num="+ order_line_num+"&catalog_code="+ catalog_code+"&patient_id="+ patient_id+"&cont_order_ind="+ cont_order_ind+"&order_status="+ order_status+"&sex="+ sex+ colval+"&ord_cat_id="+val1+"&encounter_id="+encntr_id+"&patient_class="+pat_class+"&can_reason="+colval+"&iv_prep_yn="+iv_prep_yn;//--[IN033061] added iv_prep_yn//IN64543
		var finalString	= "from=line&colval1="+colval+ "&colval=" +colval+"&orderId="+ orderId+"&ord_cat="+ ord_cat+"&ord_typ_code="+ ord_typ_code+"&val1="+ val1+"&cancel_type="+ cancel_type+"&order_line_num="+ order_line_num+"&catalog_code="+ catalog_code+"&patient_id="+ patient_id+"&cont_order_ind="+ cont_order_ind+"&order_status="+ order_status+"&sex="+ sex+ colval+"&ord_cat_id="+val1+"&encounter_id="+encntr_id+"&patient_class="+pat_class+"&can_reason="+colval+"&iv_prep_yn="+iv_prep_yn+"&instrn_type="+instrn_type;//IN64543
		var finalString	= "from=line&colval1="+colval+ "&colval=" +colval+"&orderId="+ orderId+"&ord_cat="+ ord_cat+"&ord_typ_code="+ ord_typ_code+"&val1="+ val1+"&cancel_type="+ cancel_type+"&order_line_num="+ order_line_num+"&catalog_code="+ catalog_code+"&patient_id="+ patient_id+"&cont_order_ind="+ cont_order_ind+"&order_status="+ order_status+"&sex="+ sex+ colval+"&ord_cat_id="+val1+"&encounter_id="+encntr_id+"&patient_class="+pat_class+"&can_reason="+colval+"&iv_prep_yn="+iv_prep_yn+"&instrn_type="+instrn_type+"&view_by="+view_by+"&p_called_from_ca="+p_called_from_ca+"&existing_order_called_from_new="+existing_order_called_from_new;//IN061961;//Added for IN071315//IN074110
		//else
		//var finalString	= "from=header&colval1="+colval+ "&colval=" +colval+"&orderId="+ orderId+"&ord_cat="+ ord_cat+"&ord_typ_code="+ ord_typ_code+"&val1="+ val1+"&cancel_type="+ cancel_type+"&order_line_num="+ order_line_num+"&catalog_code="+ catalog_code+"&patient_id="+ patient_id+"&cont_order_ind="+ cont_order_ind+"&order_status="+ order_status+"&sex="+ sex+ colval+"&ord_cat_id="+val1+"&encounter_id="+encntr_id+"&patient_class="+pat_class+"&can_reason="+colval;	

		if(colval == "LinkToCurrentEncounter")
		{
			var futureOrderString	= "called_from=ExistingOrder&colval1="+colval+ "&colval=" +colval+"&orderId="+ orderId+"&ord_cat="+ ord_cat+"&ord_typ_code="+ ord_typ_code+"&val1="+ val1+"&cancel_type="+ cancel_type+"&order_line_num="+ order_line_num+"&catalog_code="+ catalog_code+"&p_patient_id="+ patient_id+"&cont_order_ind="+ cont_order_ind+"&order_status="+ order_status+"&sex="+ sex+ colval+"&ord_cat_id="+val1+"&p_encounter_id="+encntr_id+"&p_patient_class="+pat_class+"&can_reason="+colval+"&p_source_code="+location_code+"&p_source_type="+location_type+"&p_episode_id="+episode_id+"&p_episode_visit_num="+episode_visit_num;
			var retVals =await  top.window.showModalDialog("../../eOR/jsp/FutureOrderDtl.jsp?"+futureOrderString,arguments,features);
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
	var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal != null && retVal != ""){
		target.value = arr[1];
		target.focus();
		document.copy_orders_search.practitioner.value=arr[0];
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
	if(parent.ExistingOrderSearch.document.existing_order_search.copyorders){	
		/*if(Obj.value == 'F') {Commented by Uma on 8/20/2010 for IN023355
			parent.ExistingOrderSearch.document.existing_order_search.copyorders.value=getLabel("eOR.ActivateOrders.label","OR");
			parent.ExistingOrderSearch.document.existing_order_search.copyorders_btn_type.value = 'A';
			//alrt(obj.value);
			parent.ExistingOrderSearch.document.existing_order_search.copyorders.click = 'callFutureOrders()';
		} else {*/
			parent.ExistingOrderSearch.document.existing_order_search.copyorders.value=getLabel("eOR.CopyPreviousOrders.label","OR");
			parent.ExistingOrderSearch.document.existing_order_search.copyorders_btn_type.value = 'C';
			//parent.ExistingOrderSearch.document.existing_order_search.copyorders.click = 'callCopyPreviousOrders()';
		//}
	}
	displayElapsedFields(Obj);
}

//callFutureOrders()
function callFutureOrders() {
	var count 		= 0;
	var flag		= true;
	//var xmlDoc 		= "";
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

async function callCopyPreviousOrders() {
	if("Y"==(parent.parent.orderMainTab.document.OrCommonForm.dxChkBfrPlaceOrderSpec.value)){  //IN069027
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
			qry_string += "&practitioner_type="+document.existing_order_search.practitioner_type.value;//IN042045
			//Start - [IN029659]
			var patientId = document.existing_order_search.patientId.value;
			var encounterId = document.existing_order_search.encntr_id.value;
			var patientClass = document.existing_order_search.patient_class.value;
			//End - [IN029659]
			var retString 	= "";
			var count 		= 0;
			var flag		= true;
			var xmlInputStr = "<root><SEARCH " ;
			//var xmlDoc 		= "";
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
			/*if (no_of_checked > 0) {
				count = no_of_checked;
			} COMMENTED FOR IN073985*/
       if (flag == true) {
				
				var dialogHeight ='100vh' ;
				var dialogWidth = '100vw' ;
				var dialogTop	= '100';
				var dialogLeft = '30' ;
				var title = getLabel("eOR.CopyOrders.label","OR");
				var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

				var arguments = "";
				var retVals = await top.window.showModalDialog("../../eOR/jsp/CopyOrdersFrameset.jsp?"+qry_string,arguments,features);
				
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
				if(top.content!=null && !top.window.document.getElementById('dialog-body'))
				{
					parent.parent.location.href = "../../eOR/jsp/EnterOrder.jsp?"+queryString;
				}
				else
				{
					
					if(parent.parent.orderMainTab)
					{
						parent.parent.orderMainTab.OrCommonForm.params.value=queryString;
						if(parent.parent.orderMainTab.newOrders)
							parent.parent.orderMainTab.newOrders.className		= "CASECONDSELECTHORZ";		
						if(parent.parent.orderMainTab.existingOrders)
							parent.parent.orderMainTab.existingOrders.className  = "CAFIRSTSELECTHORZ";
						parent.parent.orderDetailFrame.location.href = "../../eOR/jsp/OrderEntryByPractitioner.jsp?"+queryString;					
					}
				}
				/*Ends Here for IN019984*/
			}
		}
	//IN069027 Start.
	}else{
		alert(getMessage("DIAG_NOT_RECORDED","OR"));
		//alert('Patient Diagnosis not recorded, please complete to proceed further.');
	}
	//IN069027 End.
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
async function showAllDiagnosisWindow(scheme,scheme_code) {
	var retVal 		= new String();
	var dialogHeight 	= "29" ;
	var dialogWidth  	= "40" ;
	var dialogTop    	= "100";
	var status 		= "no";
	var arguments		= "" ;
	var features 		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll:no; status:" + status;
	retVal = await window.showModalDialog("../../eCA/jsp/PaintConsultationFrame.jsp?title=Diagnosis&p_diag_code="+scheme+"&p_diag_scheme_desc="+scheme_code+"&p_auth_yn=Y&cause_indicator=",arguments,features);
    if (!(retVal == null))
	{
		//val=retVal.split("/");
		document.getElementById("diag_code").value	 = retVal;//unescape(val[0]);
		//document.careSetSearchForm.orderable_text.value 	 = retVal;//unescape(val[0]);
		var bean_id 			= document.copy_orders_search.bean_id.value ;
		var bean_name 			= document.copy_orders_search.bean_name.value ;
		var localeName          = document.copy_orders_search.localeName.value;
	var xmlDoc = ""; 
	var xmlHttp = new XMLHttpRequest();

		xmlStr					= "<root><SEARCH " ;
		xmlStr 					+= obj.name+"=\""+ obj.value +"\" " ;
		xmlStr 					+=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
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
		if(document.copy_orders_search.dxChkBfrPlaceOrderSpec.value=="Y"){ //26826
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
				qry_string += "&speciality_code="+escape(document.copy_orders_search.speciality_code.value);//--[IN052649]
				qry_string += "&OrderingSpecialityCopyPreviousOrder="+escape(document.copy_orders_search.OrderingSpecialityCopyPreviousOrder.value);//--[IN052649]
				qry_string += "&practitioner_type="+escape(document.copy_orders_search.practitioner_type.value);//IN042045
				
				parent.CopyOrdersHdr.location.href = "../jsp/CopyOrdersHdr.jsp";
				parent.CopyOrdersResults.location.href = "../jsp/CopyOrdersResults.jsp?"+qry_string;
				parent.CopyOrdersResultsBottom.location.href = "../jsp/CopyOrdersResultsBottom.jsp?finalString=&bean_id="+escape(document.copy_orders_search.bean_id.value)+"&bean_name="+escape(document.copy_orders_search.bean_name.value)+"&view_by="+escape(document.copy_orders_search.view_by.value)+"&localeName="+localeName;
				parent.CopyOrdersBtn.location.href = "../jsp/CopyOrdersBtn.jsp";
	//26826 Start.
		}else{ 
			alert(getMessage("DIAG_NOT_RECORDED","OR"));
		}
	//26826 End.
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
				
				var ordCatagory=eval("document.copy_orders_results.order_category"+i+".value");	//26826	

				//44884 Starts.
				var practitionerRel="N";
				var restOrdersSelf="N";
				var restOrdersFamily="N";
				
				practitionerRel = parent.CopyOrdersSearch.copy_orders_search.practitionerRel.value;
				restOrdersSelf=eval("parent.CopyOrdersSearch.copy_orders_search.restBfrPlaceOrderS"+ordCatagory).value;
				restOrdersFamily=eval("parent.CopyOrdersSearch.copy_orders_search.restBfrPlaceOrderF"+ordCatagory).value;
				if("N"!=practitionerRel){
					if("S"==practitionerRel && "Y"==restOrdersSelf ){
						if("PH"==ordCatagory)
							alert(getMessage("RESTRICTED_PHORDER_SELF_FAMILY","OR"));
						else
							alert(getMessage("RESTRICTED_ORDER_SELF_FAMILY","OR"));
						eval("document.copy_orders_results.chk"+i).checked = false;
						return false;
					}
					if("F"==practitionerRel && "Y"==restOrdersFamily ){
						if("PH"==ordCatagory)
							alert(getMessage("RESTRICTED_PHORDER_SELF_FAMILY","OR"));
						else
							alert(getMessage("RESTRICTED_ORDER_SELF_FAMILY","OR"));
						eval("document.copy_orders_results.chk"+i).checked = false;
						return false;
					}
				}
				//44884 Ends.
				var dxChkBfrPlaceOrderYN = eval("parent.CopyOrdersSearch.copy_orders_search.dxChkBfrPlaceOrder"+ordCatagory+".value");//26826
				if("Y"==dxChkBfrPlaceOrderYN){ //26826
					if (finalString.split("~").length <= 11) {
						finalString += i + "~";
						count++;
					} else {

						alert(getMessage("MAX_ORDERABLES","OR"));
						eval("document.copy_orders_results.chk"+i).checked = false;
						return false;
					}
				}else{ //26826
					alert(getMessage("DIAG_NOT_RECORDED","OR"));  //26826
					eval("document.copy_orders_results.chk"+i).checked = false;  //26826
					return false;  //26826
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
		if (parent.CopyOrdersResultsBottom.document.getElementById('chk'+i)) {
			if (parent.CopyOrdersResultsBottom.document.getElementById('chk'+i).checked == true) {
				xmlStr += "order_id"+ count +"=\""+ parent.CopyOrdersResultsBottom.document.getElementById('order_id'+i).value +"\" " ;
				xmlStr += "order_category"+ count +"=\""+ parent.CopyOrdersResultsBottom.document.getElementById('order_category'+i).value +"\" " ;
				xmlStr += "order_type_code"+ count +"=\""+ parent.CopyOrdersResultsBottom.document.getElementById('order_type_code'+i).value +"\" " ;
				patientId = parent.CopyOrdersResultsBottom.document.getElementById('patient_id'+i).value;
				encounterId = parent.CopyOrdersResultsBottom.document.getElementById('encounter_id'+i).value;
				if (parent.CopyOrdersResultsBottom.document.getElementById('view_by').value == 'L') {
									
					if(catalogStr.indexOf("~"+parent.CopyOrdersResultsBottom.document.getElementById('catalog_code'+i).value+"~") != -1) {
						
						alert(getMessage("DUPLICATE_ORDERABLES","OR"));
						return false;
					}
					
					xmlStr += "order_line_num"+ count +"=\""+ parent.CopyOrdersResultsBottom.document.getElementById('order_line_num'+i).value +"\" " ;
					xmlStr += "catalog_code"+ count +"=\""+ parent.CopyOrdersResultsBottom.document.getElementById('catalog_code'+i).value +"\" " ;
					catalogStr += parent.CopyOrdersResultsBottom.document.getElementById('catalog_code'+i).value + "~";
				}
				count++;
			}
		}
	}
	if (count <= 0) {
		alert(getMessage("CLICK_ANY_ONE","OR"));
		return false;
	}
	if (parent.CopyOrdersResultsBottom.document.getElementById('view_by').value == 'H' && count > 0) {
		
		xmlStr = "<root><SEARCH " + catalogCodeForOrderId(parent.CopyOrdersResultsBottom.document.copy_orders_results_bottom.bean_id.value,xmlStr,count,patientId,encounterId,parent.frames[0].document.copy_orders_search.cur_patient_class.value,parent.CopyOrdersResultsBottom.document.getElementById('view_by').value);
		
		if (errorMessage != null && errorMessage != "") {
			alert(getMessage(errorMessage,"OR"));
			return false;
		}
		count = totCountGlobal;
	}
	var retVal	= new Array();
	retVal[0]	= xmlStr;
	retVal[1]	= count;


	//window.returnValue	= retVal;
	//window.close();
	
	parent.parent.document.querySelectorAll("#dialog-body")[parent.parent.document.querySelectorAll("#dialog-body").length -1 ].contentWindow.returnValue = retVal;
	parent.parent.document.querySelectorAll("#dialog_tag")[parent.parent.document.querySelectorAll("#dialog_tag").length -1].close();

}


async function callCopyMenuFunctions1(colval,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,cont_order_ind,order_status,sex){

		unescape(colval)
		//unescape(item_narration)
		//item_narration = eval("document.existing_order_dtl.item_narration"+item_narration+".value")
		if(colval == "Instructions"){
			var dialogHeight ='12' ;
			var dialogWidth = '35' ;
			var dialogTop	= '189';
			var dialogLeft = '167' ;
		} else if (colval == "View") {
				var dialogHeight ='90vh' ;
				var dialogWidth = '80vw' ;
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


		var retVals = await top.window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);

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

async function showSecondayOrders(i,order_id)
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
 	retVal 			=await  window.showModalDialog("../../eOR/jsp/OrderEntrySecondaryOrdersFrameset.jsp?"+qryString,arguments,features);
 } // End of viewSecondaryOrders


async function showCareSetResults(orderId)
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
		
	var retVals =await  window.showModalDialog("../../eOR/jsp/OrderSetResults.jsp?"+finalString,arguments,features);
	reloadValues();
	//document.location.reload();	
}

async function showCareSetViewResults(orderId, order_line_num, cont_order_ind, patient_id, catalog_desc){

   	var finalString = document.existing_order_dtl.queryString.value+"&orderId="+orderId+"&order_line_num="+order_line_num+"&catalog_desc="+escape(catalog_desc)+"&cont_order_ind="+cont_order_ind+"&patient_id="+patient_id;
	var dialogHeight ='27' ;
	var dialogWidth = '48' ; 
	var dialogTop	= '129';
	var dialogLeft = '30' ;
	var title = ''
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

	var arguments = "";
	var retVals = await window.showModalDialog("../../eOR/jsp/OrderSetResultsViewFrameset.jsp?"+finalString,arguments,features);
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
		qry_string_fr_ammend+="&recordConsentWithOrder="+formObj.recordConsentWithOrder.value+"&cnsnt_with_order_yn="+formObj.cnsnt_with_order_yn.value; //INo57196
		formObj.search.disabled = true;
		
 		parent.parent.ExistingOrderResult.location.href = "../../eOR/jsp/ExistingOrderResultsFrameset.jsp?"+qry_string+qry_string_fr_ammend
		formObj.search.disabled = false;
	}
	else
	{
		
		if(parent.ExistingOrderResult && !parent.ExistingOrderSearch)
		{
			var qrystring = parent.ExistingOrderResult.document.existing_order_dtl.queryString.value;
			// IN036674 Start.
			//parent.ExistingOrderResult.location.href ="../jsp/OrderSetExistingOrderResults.jsp?"+qrystring;
			if(document.forms[0].function_from)//IN037290 -Start
			{
				var functionFrom = document.forms[0].function_from.value;
				if(functionFrom == "MO" && functionFrom != null)
				{
					parent.ExistingOrderResult.location.href ="../../eOR/jsp/ExistingOrderResults.jsp?"+qrystring;
				}else
				{
					parent.ExistingOrderResult.location.href ="../../eOR/jsp/OrderSetExistingOrderResults.jsp?"+qrystring;	
				}
				
			}else
			{
				parent.ExistingOrderResult.location.href ="../../eOR/jsp/OrderSetExistingOrderResults.jsp?"+qrystring;	
			} //IN037290 -End
			//Commented IN037290
			/*if(functionFrom == "MO"){
				parent.ExistingOrderResult.location.href ="../jsp/ExistingOrderResults.jsp?"+qrystring;
			}else{
				parent.ExistingOrderResult.location.href ="../jsp/OrderSetExistingOrderResults.jsp?"+qrystring;	
			}*/
			// IN036674 End.
		}
		else if(parent.ExistingOrderSearch)
		{
			
			var qrystring = parent.ExistingOrderResult.document.existing_order_dtl.queryString.value;
			parent.ExistingOrderResult.location.href ="../../eOR/jsp/ExistingOrderResults.jsp?"+qrystring;	
			
		}
	}
}

// Calling the Notes View
async function showNotes(accession_num) 
{
 	var dialogHeight ='27' ;
	var dialogWidth = '48' ;
	var dialogTop	= '129';
	var dialogLeft	= '30' ;
	var title = ''
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
 	var arguments = "";
	var retVals = await window.showModalDialog("../../eCA/jsp/PhysicianNotesDetailsFrame.jsp?accession_num="+escape(accession_num),arguments,features);
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
		//IN063816 start
		if(document.existing_order_search.barcodeSiteSpecificYN.value == 'Y')
		{
			document.existing_order_search.barcode_print.style.display	= "none" ; 
		}
		//IN063816 end
	}
	else
	{
		document.existing_order_search.activity_type.disabled	= false ;
		//IN063816 start
		if(document.existing_order_search.barcodeSiteSpecificYN.value == 'Y')
		{
			document.existing_order_search.barcode_print.style.display	= "inline" ; 
		}
		//IN063816 end
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

async function callordertypeSearch(target,code,called_from)
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

	retval=await CommonLookup(getLabel("Common.OrderType.label","Common"),argumentArray);
var ret1=unescape(retval);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retval !=null && retval != "")
	{
		code.value=arr[0];
		target.value=arr[1];
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

async function callActivitySearch(target,code,called_from)
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

	retval=await CommonLookup(getLabel("eOR.ActivityType.label","OR"),argumentArray);
var ret1=unescape(retval);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retval !=null && retval != "")
	{
		code.value=arr[0];
		target.value=arr[1];
		
	}else
	{
   		target.value = "";
   		code.value = "" ;
	 }
}

function clearFields(called_from)
{
	//44884 Starts.
	var practitionerRel="N";
	var restOrdersSelf="N";
	var restOrdersFamily="N";
	
	practitionerRel = document.formTab.practitionerRel.value;
	var orderCategory=document.copy_orders_search.order_category.value;
	restOrdersSelf=eval("document.copy_orders_search.restBfrPlaceOrderS"+orderCategory).value;
	restOrdersFamily=eval("document.copy_orders_search.restBfrPlaceOrderF"+orderCategory).value;
	if("N"!=practitionerRel){
		if("S"==practitionerRel && "Y"==restOrdersSelf ){
			if("PH"==orderCategory)
				alert(getMessage("RESTRICTED_PHORDER_SELF_FAMILY","OR"));
			else
				alert(getMessage("RESTRICTED_ORDER_SELF_FAMILY","OR"));
			document.copy_orders_search.order_category.value="";
		return false;
		}
		if("F"==practitionerRel && "Y"==restOrdersFamily ){
			if("PH"==orderCategory)
				alert(getMessage("RESTRICTED_PHORDER_SELF_FAMILY","OR"));
			else
				alert(getMessage("RESTRICTED_ORDER_SELF_FAMILY","OR"));
			document.copy_orders_search.order_category.value="";
			return false;
		}
	}
	//44884 Ends.

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

async function populateMoveLoaction(target,code)
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

		retVal = await CommonLookup(getLabel("Common.Location.label","Common") , argumentArray );
		var ret1=unescape(retVal);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) 
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		}
		if(retVal !=null && retVal != "")
		{
			code.value=arr[0];
			target.value=arr[1];
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
	var explanatory_text;
	
	if(form["explanatory_text"+catalog_code])
	 	explanatory_text	= form["explanatory_text"+catalog_code].value;
	else   // For Amend Orders
		explanatory_text	= form["amend_explanatory_text"+catalog_code].value;

	if(explanatory_text!=null && explanatory_text!="")
    {
		buildToolTable(explanatory_text);
 		resizeWindow1(event);
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

		document.getElementById("tooltiplayer").style.left= x+"px";
		document.getElementById("tooltiplayer").style.top = y+"px";
		document.getElementById("tooltiplayer").style.background='grey';
		//document.getElementById("tooltiplayer").style.posLeft =160 ;//(8,147)in order to fix the tooltip table exactly to the orderable desc.
		document.getElementById("tooltiplayer").style.visibility='visible';
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

/*function resizeWindow1(){

	            bodwidth = parent.frames[0].document.body.offsetWidth;
	            bodheight = parent.frames[0].document.body.offsetHeight;
				//bodwidth = parent.frames[2].document.body.offsetWidth
				//bodheight = parent.frames[2].document.body.offsetHeight

			// var x=event.x   //commented for IN060148
			// var y=event.y;	//commented for IN060148
		   	   var x=event.clientX;  //IN060148
		 	   var y=event.clientY;   //IN060148

				x = x + (document.getElementById("tooltiplayer").offsetWidth);
				y = y + (document.getElementById("tooltiplayer").offsetHeight);
				
			 if(x<bodwidth)
			 {
			 	//x	=event.x;   //commented for IN060148
				  x	=event.clientX;   //IE11 compactability issue for tool tip
			 }
			 else
	 		 {
				x		= x - (document.getElementById("tooltiplayer").offsetWidth*2)
			 }
			 if(y<bodheight) 
			 {
  				// y=event.y;  //commented for IN060148
				   y=event.clientY;   //IE11 compactability issue for tool tip
			 }
			else {
					y = y - (document.getElementById("tooltiplayer").offsetHeight*2);
				}

					y+=document.body.scrollTop;
					x+=document.body.scrollLeft;

		document.getElementById("tooltiplayer").style.posLeft= x;
		document.getElementById("tooltiplayer").style.posTop = y;
		document.getElementById("tooltiplayer").style.visibility='visible';
}*/

function resizeWindow1(event) {
    // Get the dimensions of the body of the parent frame
    var bodwidth = parent.frames[0].document.body.offsetWidth;
    var bodheight = parent.frames[0].document.body.offsetHeight;

    // Get the cursor position
    var x = event.clientX;
    var y = event.clientY;

    // Get the tooltip element
    var tooltip = document.getElementById("tooltiplayer");
    var tooltipWidth = tooltip.offsetWidth;
    var tooltipHeight = tooltip.offsetHeight;

    // Position the tooltip directly under the cursor
    y = y + tooltipHeight;  // Place the tooltip below the cursor

    // Prevent the tooltip from going off the right side of the screen
    if (x + tooltipWidth > bodwidth) {
        x = bodwidth - tooltipWidth;  // Move it left if it exceeds the screen width
    }

    // Prevent the tooltip from going off the bottom side of the screen
    if (y + tooltipHeight > bodheight) {
        y = bodheight - tooltipHeight;  // Move it up if it exceeds the screen height
    }

    // Adjust for the page's scroll position
    y += document.body.scrollTop;
    x += document.body.scrollLeft;

    // Set the position of the tooltip
    tooltip.style.left = x + "px";
    tooltip.style.top = y + "px";
    tooltip.style.visibility = 'visible';  // Make the tooltip visible
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
				parent.ExistingOrderSearch.document.getElementById('displayOrders').innerHTML=getLabel("eOR.ElapsedOrders.label","OR")+"<input type='checkbox' name='elapsed_orders' id='elapsed_orders' value='N' onclick='ChkElapseOrders()'>";
				if(parent.ExistingOrderSearch.document.getElementById('displayOrders'))
				parent.ExistingOrderSearch.document.getElementById('displayOrders').style.visibility = "visible";
				if(parent.ExistingOrderSearch.document.getElementById('elapsed_orders'))
				{
					parent.ExistingOrderSearch.document.getElementById('elapsed_orders').checked=false;
					parent.ExistingOrderSearch.document.getElementById('elapsed_orders').disabled=false;
					parent.ExistingOrderSearch.document.getElementById('elapsed_orders').value="N";
				}
			}
		}
		else
		{
			if((Obj.value=="Z")||(Obj.value=="D"))
			{
				parent.ExistingOrderSearch.document.getElementById('displayOrders').innerHTML=getLabel("eOR.IncludeSystemCancelledOrders.label","OR")+"<input type='checkbox' name='sys_cancelled_orders' id='sys_cancelled_orders' value='' onclick='ChkSysCancelledOrders()'>";
				if(parent.ExistingOrderSearch.document.getElementById('displayOrders'))
					parent.ExistingOrderSearch.document.getElementById('displayOrders').style.visibility="visible";
			}
			else
			{
				if(parent.ExistingOrderSearch.document.getElementById('displayOrders'))
					parent.ExistingOrderSearch.document.getElementById('displayOrders').style.visibility="hidden";
			}
			//parent.ExistingOrderSearch.document.existing_order_search.all.ElapsedOrders.style.visibility="hidden";
		}
	}

	function ChkElapseOrders()
	{
		if(parent.ExistingOrderSearch.document.existing_order_search.elapsed_orders)
		{
			if(parent.ExistingOrderSearch.document.existing_order_search.elapsed_orders.checked==true)
			{
				parent.ExistingOrderSearch.document.existing_order_search.elapsed_orders.value="Y";
			}
			else
			{
				parent.ExistingOrderSearch.document.existing_order_search.elapsed_orders.value="N";
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
	async function viewMedication(patient_id,nursing_unit,admin_date,patient_class) 
	{
		var dialogHeight	= "95vh";
		var dialogWidth		= "95vw";
		var dialogTop		= "100";
		var dialogLeft		= "50";
		var center			= "0";
		var status			= "no";
		var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments		= "";
		retVal 				= await top.window.showModalDialog("../../ePH/jsp/QueryMednAdminChart.jsp?patient_id="+patient_id+"&nursing_unit="+nursing_unit+"&admin_date="+admin_date+"&patient_class="+patient_class+"&called_from=OR",arguments,features);
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
//IN030279 Start
async function placeOrderMO(){

	var patient_id = parent.ExistingOrderResult.document.existing_order_dtl.patient_id.value;
	var patient_class = parent.ExistingOrderResult.document.existing_order_dtl.patient_class.value;
	var facility_id = parent.ExistingOrderResult.document.existing_order_dtl.facility_id.value;
	var encounter_id = parent.ExistingOrderResult.document.existing_order_dtl.encntr_id.value;	
	var deceased_yn = parent.ExistingOrderResult.document.existing_order_dtl.deceased_yn.value;
	var medico_legal_yn = parent.ExistingOrderResult.document.existing_order_dtl.medico_legal_yn.value;
	var postmortem_status = parent.ExistingOrderResult.document.existing_order_dtl.postmortem_status.value;
	var body_part_yn = parent.ExistingOrderResult.document.existing_order_dtl.body_part_yn.value;
	var registration_no = parent.ExistingOrderResult.document.existing_order_dtl.registration_no.value;
	var queryString = parent.ExistingOrderResult.document.existing_order_dtl.queryString.value
	
	var area_code = "";
	var retVal = "";
	var dialogHeight= "40" ;
	var dialogWidth	= "70" ;
	var dialogTop ="60";
	var status = "no";
	var arguments	= " ";	 
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;
	
	var retval=await window.showModalDialog("../../eOR/jsp/EnterOrder.jsp?patient_id="+patient_id+"&function_from=MO&patient_class="+patient_class+"&facility_id="+facility_id+"&encounter_id="+encounter_id+"&episode_id="+encounter_id+"&requestedModule=MO&callingFrom=Q&deceased_yn="+deceased_yn+"&medico_legal_yn="+medico_legal_yn+"&postmortem_status="+postmortem_status+"&body_part_yn="+body_part_yn+"&registration_no="+registration_no,arguments,features);	
	parent.ExistingOrderResult.location.href="../../eOR/jsp/ExistingOrderResults.jsp?"+queryString;
	
}
async function viewAllOrderMO(){

	var patient_id = parent.ExistingOrderResult.document.existing_order_dtl.patient_id.value;
	var patient_class = parent.ExistingOrderResult.document.existing_order_dtl.patient_class.value;
	var facility_id = parent.ExistingOrderResult.document.existing_order_dtl.facility_id.value;
	var encounter_id = parent.ExistingOrderResult.document.existing_order_dtl.encntr_id.value;
	var deceased_yn = parent.ExistingOrderResult.document.existing_order_dtl.deceased_yn.value;
	var medico_legal_yn = parent.ExistingOrderResult.document.existing_order_dtl.medico_legal_yn.value;
	var postmortem_status = parent.ExistingOrderResult.document.existing_order_dtl.postmortem_status.value;
	var body_part_yn = parent.ExistingOrderResult.document.existing_order_dtl.body_part_yn.value;
	var registration_no = parent.ExistingOrderResult.document.existing_order_dtl.registration_no.value;
	
	var area_code = "";
	var retVal = "";
	var dialogHeight= "40" ;
	var dialogWidth	= "70" ;
	var dialogTop ="60";
	var status = "no";
	var arguments	= " ";	 
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;
	
	await window.showModalDialog("../../eOR/jsp/PatOrderByPrivReln.jsp?patient_id="+patient_id+"&function_from=MO",arguments,features);
	
}
//IN030279 End.
function specialityOnChange(){
	var orderSpeciality = document.copy_orders_search.OrderingSpecialityCopyPreviousOrder.value;
	if(orderSpeciality=="A"){
		document.copy_orders_search.speciality_code.value = "";
		document.copy_orders_search.speciality_desc.value = "";
	}else if(orderSpeciality=="P"){
		document.copy_orders_search.speciality_code.value = document.copy_orders_search.primarySpecialityCode.value;
		document.copy_orders_search.speciality_desc.value = document.copy_orders_search.PrimarySpecialityDesc.value;
	}else if(orderSpeciality=="E"){
		document.copy_orders_search.speciality_code.value = document.copy_orders_search.currentEncSpecialityCode.value;
		document.copy_orders_search.speciality_desc.value = document.copy_orders_search.currentEncSpecialityDesc.value;
	}
}
function populateSpecialityOnBlur(code,target){
	if(trimString(target.value).length>0)
	{
		populateSpeciality(code,target);
	}
	if(target.value=="")
		code.value="";
}
async function populateSpeciality(code,target)
{
	var formobj=document.copy_orders_search;	
		localeName=formobj.localeName.value;	
		var sql=formobj.speciality_sql.value;
		
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

		retVal = await CommonLookup(getLabel("Common.speciality.label","Common") , argumentArray );
		var ret1=unescape(retVal);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) 
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		}
		if(retVal !=null && retVal != "")
		{
			code.value=arr[0];
			target.value=arr[1];
		}
		else
		{
   			target.value = "";
   			code.value = "" ;
 		}	
	
}
//IN063816 start
function clickLine_barcode(chk_barcode)
{
	if (chk_barcode.checked == true) {
		chk_barcode.value = 'Y';
	} else {
		chk_barcode.value = 'N';
	}
}
function printBarcodeValues()
{
	var no_of_checked = 0;
	var frmObj = "";
	
	if(parent.ExistingOrderResult.ExistingOrderResult && parent.ExistingOrderResult.ExistingOrderResult.document.existing_order_dtl)
		 frmObj= parent.ExistingOrderResult.ExistingOrderResult.document.existing_order_dtl;
	
	//IN064614
		
	var frmObj= parent.ExistingOrderResult.ExistingOrderResult.document.existing_order_dtl;
	
	
	if(frmObj.call_from_barcode_btn != null)
	{
		frmObj.call_from_barcode_btn.value = "Y";
	}
	
	
	if(frmObj){

		for(cnt=0; cnt<frmObj.total_recs_barcode.value; cnt++){
			
			val = eval("parent.ExistingOrderResult.ExistingOrderResult.document.existing_order_dtl.chk_barcode"+cnt);
			
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
	
	
	
	var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();
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
            else if(arrObj[i].type == "select-multiple" ) {
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
			
                if(arrObj[i].name != null && arrObj[i].name != ""){
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
				}
            }
        }
    }

    xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST", "../../eOR/jsp/ExistingOrderPrintValidate.jsp", true);
    xmlHttp.send(xmlDoc);
	//IN064614
	onSuccessBarcode();

}

function onSuccessBarcode() {
	alert(getMessage("BARCODE_RPT_SUBMIT_TO_PRINTER","OR"));
}
//IN063816 end

//IN065942, starts
function chkPrnRegLabel(prnRegLabel)
{
	if (prnRegLabel.checked) 
		prnRegLabel.value = 'Y';
	else 
		prnRegLabel.value = 'N';
}

function prnRegLabelChk()
{
	var no_of_checked = 0;
	var formObj = "";

	if(parent.ExistingOrderResult.ExistingOrderResult && parent.ExistingOrderResult.ExistingOrderResult.document.existing_order_dtl)
		formObj = parent.ExistingOrderResult.ExistingOrderResult.document.existing_order_dtl;

	if(formObj)
	{
		for(cnt=0; cnt<formObj.total_recs.value; cnt++)
		{
			val = eval("formObj.chk_prn_reg_label"+cnt);

			if(val != undefined && val.checked)
			{
				no_of_checked++;
			}
		}
	}

	return no_of_checked;
}

function prnRegLabel()
{
	var no_of_checked = 0;
	var formObj = "";

	if(parent.ExistingOrderResult.ExistingOrderResult && parent.ExistingOrderResult.ExistingOrderResult.document.existing_order_dtl)
		formObj = parent.ExistingOrderResult.ExistingOrderResult.document.existing_order_dtl;

	var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();
	
    var xmlStr ="<root><SEARCH ";

	if(formObj)
	{
		for(cnt=0; cnt<formObj.total_recs.value; cnt++)
		{
			val = eval("formObj.chk_prn_reg_label"+cnt);

			if(val != undefined && val.checked)
			{
				xmlStr+= "p_order_id"+no_of_checked+"=\""+ eval("formObj.ord_id"+cnt).value +"\" " ;
				xmlStr+= "p_order_line_no"+no_of_checked+"=\""+ eval("formObj.line_num"+cnt).value +"\" " ;					
				no_of_checked++;
			}
		}
	}

	xmlStr+= "p_pract_type=\""+ formObj.pract_type.value +"\" " ;
	xmlStr+= "p_facility_id=\""+ formObj.facility_id.value +"\" " ;
	xmlStr+= "p_no_of_rec=\""+ no_of_checked +"\" " ;
	xmlStr+= "FUNC_TASK='PRINT_REG_ORDER_LABEL' " ;
	xmlStr +=" /></root>";

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
    xmlHttp.open("POST", "../../eOR/jsp/ExistingOrderPrintValidate.jsp", true);
    xmlHttp.send(xmlDoc);
}

function callOnSuccess(ord_sheet_cnt, label_prn_cnt) 
{
	if(ord_sheet_cnt > 0 && label_prn_cnt == 0)
		alert(getMessage("RPT_SUBMIT_TO_PRINTER","OR"));
	else if(label_prn_cnt > 0 && ord_sheet_cnt == 0)
		alert(getMessage("SUBMIT_TO_PRINTER","OR").replace("#","Label"));
	else
		alert(getMessage("SUBMIT_TO_PRINTER","OR").replace("#","Report, Label"));
}
//IN065942, ends
//31792 starts
async function NeonatalMotherSpecimenDetails1(order_id,order_line_num,order_category,performing_facility_id,specimen_num,accession_num,history_type)
{
	
	var dialogHeight ='10' ;
	var dialogWidth = '38' ;
	var dialogTop	= '129';
	var dialogLeft = '30' ;
	var title = ''
	var patient_id=document.forms[0].patient_id.value;	
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';

	var arguments = "";
		
	var retVals = await window.showModalDialog("../../eOR/jsp/NeoNatalMotherSpecimenDetails.jsp?p_order_id="+order_id+"&p_order_line_num="+order_line_num+"&order_category="+order_category+"&p_performing_facility_id="+performing_facility_id+"&accession_num="+specimen_num+"&history_type=null&patient_id="+patient_id+"&specimen_num="+specimen_num,arguments,features);
	
}

async function MotherAntibodiesDetails(patient_id,language_id,order_id)
{   
	
	var dialogHeight ='20' ;
	var dialogWidth = '38' ;
	var dialogTop	= '129';
	var dialogLeft = '30' ;
	var title = ''
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';

	var arguments = "";
		
	var retVals = await window.showModalDialog("../../eOR/jsp/MotherAntibodiesDetails.jsp?patient_id="+patient_id+"&language_id="+language_id+"&order_id="+order_id,arguments,features);
	
}//31792 ends

