/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var function_id = "" ;
var result 		= false;
var message		= "" ;
var flag 		= "" ;
var qry_string = "";

function populateLocationOnChange(location_type){

	var formObj = document.PatOrderByLocnSearch;
	var bean_id = document.PatOrderByLocnSearch.bean_id.value ;
	var bean_name = document.PatOrderByLocnSearch.bean_name.value ;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr += location_type.name+"=\""+ location_type.value +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "PatOrderByLocnValidate.jsp?bean_id=" + bean_id +"&bean_name="+bean_name+"&func_mode=locn", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText )	;
}

function addLocationList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.PatOrderByLocnSearch.locn.add(element);
}

function clearList( docObj ) {
var len = eval(docObj+".forms[0].locn.options.length") ;
for(var i=0;i<len;i++){
		eval(docObj+".PatOrderByLocnSearch.locn.remove(\"locn\")") ;
}
var tp = "     ---"+getLabel("Common.all.label","Common")+"---     " ;
var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
eval(docObj+".PatOrderByLocnSearch.locn.add(opt)") ;
}
/////////////////

//this fucntion is used to clear the entries of search criteria
//this is used for patient ID search

function callPatientSearch(){
	var pat_id =  PatientSearch();

	if(pat_id != null)
	document.getElementById("patientId").value = pat_id;
}

//called on click of search
function populateValues(){		//alert("function get called");


	group_by	 		= document.PatOrderByLocnSearch.group_by;
	if(group_by[0].checked==true)
		group_by		= "ORC";
	else if(group_by[1].checked==true)
		group_by		= "ORT";
	else if(group_by[2].checked==true)
		group_by		= "CAT";
	else if(group_by[3].checked==true)
		group_by		= "LOC";
	qry_string ="bean_id="+document.PatOrderByLocnSearch.bean_id.value+"&bean_name="+document.PatOrderByLocnSearch.bean_name.value+"&period_from="+document.PatOrderByLocnSearch.period_from.value+"&period_to="+document.PatOrderByLocnSearch.period_to.value+"&status="+document.PatOrderByLocnSearch.status.value+"&order_category="+document.PatOrderByLocnSearch.order_category.value+"&order_type="+document.PatOrderByLocnSearch.order_type.value+"&ordering_pract="+document.PatOrderByLocnSearch.ordering_pract.value+"&location_type="+document.PatOrderByLocnSearch.location_type.value+"&locn="+document.PatOrderByLocnSearch.locn.value+"&locn1="+document.PatOrderByLocnSearch.locn1.value+"&patient_id="+document.PatOrderByLocnSearch.patient_id.value+"&encounter_id="+document.PatOrderByLocnSearch.encounter_id.value+"&order_id="+document.PatOrderByLocnSearch.order_id.value+"&order_catalog="+document.PatOrderByLocnSearch.order_catalog.value+"&search_crt="+document.PatOrderByLocnSearch.search_crt.value+"&group_by="+group_by
	//parent.PatOrderByPRHeader.location.href = "../jsp/PatOrderByPrivRelnHeader.jsp";
	parent.PatOrderByLocnResult.location.href = "../jsp/PatOrderByLocnResultFrameSet.jsp?"+qry_string;

}

//called on click of clear button in search criteria
function clearValues(){
	document.PatOrderByLocnSearch.reset();
	parent.PatOrderByLocnResult.location.href = "../../eCommon/html/blank.html"
}

function checkDate(obj){
	if(!(trimCheck(obj.value)))
	{
		obj.value = "";
		return false;
	}
	if(!(checkDt(obj.value))){
		alert(getMessage("INVALID_DATE_FMT","OR"));
		obj.select();
		obj.focus();
		return false;
	}
}

function checkDate1(obj){
	var dt = new Date()
	var fromDate = document.PatOrderByLocnSearch.date_from
	var toDate = document.PatOrderByLocnSearch.date_to
	if(!(trimCheck(obj.value)))
	{
		obj.value = "";
		return false;
	}

	if(!(checkDt(obj.value))){

		obj.select();
		obj.focus();
		return false;
	}

	if(!(doDateCheck(fromDate,toDate,parent.parent.messageFrame)))
		return false
}

function FillOrderType(OrderCatObj){
	var formObj = document.PatOrderByLocnSearch;
	var bean_id = document.PatOrderByLocnSearch.bean_id.value ;
	var bean_name = document.PatOrderByLocnSearch.bean_name.value ;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
 	xmlStr ="<root><SEARCH " ;
	xmlStr += OrderCatObj.name+"=\""+ OrderCatObj.value +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "PatOrderByLocnValidate.jsp?bean_id=" + bean_id + "&func_mode=order_type", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
//	alert(responseText);
	eval(responseText )
}
function addLocationList1(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.PatOrderByLocnSearch.order_type.add(element);
}
function clearList1( docObj ) {
var len = eval(docObj+".forms[0].order_type.options.length") ;
//	alert(len);
for(var i=0;i<len;i++){
		eval(docObj+".PatOrderByLocnSearch.order_type.remove(\"locn\")") ;
}
var tp = getLabel("Common.all.label","Common") ;
var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
eval(docObj+".PatOrderByLocnSearch.order_type.add(opt)") ;
}


function changeState(row, total_rows)
{
 	obj 				= eval("document.PatOrderByLocnSearchResult.outerlayernursing_"+row);
	exp_obj			 	= eval("document.PatOrderByLocnSearchResult.expandnursing_"+row);
	if(obj.style.position=="absolute")
	{
		exp_obj.innerHTML		= "<a href='javascript:changeState(\""+row+"\",\""+total_rows+"\")'>-</a>&nbsp;<b>'"+getLabel('Common.nursingUnit.label','Common')+"'</b></font>";
		obj.style.position 		= "relative";
		window.setTimeout("toMakeVisible()",1);
	}
	else
	{
		document.location.reload();
	/*	exp_obj.innerHTML		= "<a href=\"javascript:changeState('"+row+"','"+total_rows+"')\">+</a>&nbsp;<b>Nursing Unit</b></font>";
		obj.style.position 			= "absolute";
		obj.style.visibility 		= "hidden";
		for(i=0;i<total_rows;i++)
  		{
			innerobj		 	= eval("document.PatOrderByLocnSearchResult.innerlayernursing_"+i);
			if(innerobj)
			{
				innerobj.style.position 	= "absolute";
				innerobj.style.visibility 	= "hidden";
			}
		}*/
	}
}

function toMakeVisible()
{
	obj.style.visibility 				= "visible";
}

function expandPatient(rows,code, nursing_details)
{
	nursing_details = unescape(nursing_details);

	var nursing_details_display = nursing_details
	nursing_details_display 	= changeSpecialCharacter(nursing_details_display,'ö',' ')
	nursing_details_display 	= changeSpecialCharacter(nursing_details_display,'ø','>')
	nursing_details_display 	= changeSpecialCharacter(nursing_details_display,'ù','\'')
	obj 						= eval("document.PatOrderByLocnSearchResult.innerlayernursing_"+rows);

	paint_obj					= eval("document.PatOrderByLocnSearchResult.changerownursing_"+rows);
	paint_obj.innerHTML		= "<a href=javascript:expandPatient(\""+rows+"\",\""+code+"\",escape(\""+nursing_details+"\"))>-&nbsp;"+nursing_details_display+"</a></font>";


	if(obj.style.position=="absolute")
	{

		var formObj 	= document.PatOrderByLocnSearchResult;
		var bean_id 	= formObj.bean_id.value ;
		var bean_name 	= formObj.bean_name.value ;
		//var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
		//var xmlHttp	    = new ActiveXObject( "Microsoft.XMLHTTP" ) ;
		var xmlHttp = new XMLHttpRequest();
		xmlStr 			="<root><SEARCH /></root>" ;
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "PatOrderByLocnValidate.jsp?bean_id=" + bean_id +"&bean_name="+bean_name+"&code="+code+"&rows="+rows+"&func_mode=populate_patients", false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText )	;

		var retVal 			= new String();
		var dialogHeight 	= "29" ;
		var dialogWidth  	= "52" ;
		var dialogTop   	= "100";
		var dialogLeft   	= "280";

    	var status 			= "no";
		var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth 	+" ; dialogTop:"+dialogTop+";dialogLeft: "+dialogLeft+"; scroll=auto; status:no";
		retVal 				= 	window.showModalDialog("../../eOR/jsp/PatOrderByLocnViewFrameSet.jsp?code="+code,arguments,features);
	}else {

			obj.style.position 		= "absolute";
			obj.style.visibility 	= "hidden";
			paint_obj.innerHTML		= "<a href=javascript:expandPatient(\""+rows+"\",\""+code+"\",escape(\""+nursing_details+"\"))>+&nbsp;"+nursing_details_display+"</a>&nbsp;</font>";
	}
}


function addPatientDetails(rows,patient_details) {
	obj 				= eval("document.PatOrderByLocnSearchResult.innerlayernursing_"+rows);
	exp_obj 			= eval("document.PatOrderByLocnSearchResult.innerrownursing_"+rows);
	if(obj.style.position=="absolute")
	{
		exp_obj.innerHTML	= patient_details;
		obj.style.position 	= "relative";
		obj.style.visibility= "visible";
	}
}

function addCategoryDetails(old_val,cat_details) {
	obj 			= eval("document.PatOrderByLocnSearchResult.thirdinnerlayernursing_"+old_val);
	exp_obj 		= eval("document.PatOrderByLocnSearchResult.thirdlevelinner_"+old_val);
	if(obj.style.position=="absolute" && exp_obj)
	{

		exp_obj.innerHTML		= cat_details;
		obj.style.position 		= "relative";
		obj.style.visibility	= "visible";
	}
}


function expandCategory(old_val, curr_val, patient_id, patient_details){
	patient_details = unescape(patient_details);

	var patient_details_display = patient_details;

	patient_details_display = changeSpecialCharacter(patient_details_display,'ö',' ')
	patient_details_display = changeSpecialCharacter(patient_details_display,'ø','>')
	patient_details_display = changeSpecialCharacter(patient_details_display,'ù','\'')


	obj 		= eval("document.PatOrderByLocnSearchResult.all.thirdinnerlayernursing_"+old_val+curr_val);

	paint_obj	= eval("document.PatOrderByLocnSearchResult.all.patdtl_"+old_val+curr_val);
	inner_obj	= eval("document.PatOrderByLocnSearchResult.all.thirdlevelinner_"+old_val+curr_val);
	if(paint_obj)
		paint_obj.innerHTML	= "<a href=javascript:expandCategory(\""+old_val+"\",\""+curr_val+"\",\""+patient_id+"\",escape(\""+patient_details+"\"))>-&nbsp;"+patient_details_display+"</a></font>";

	if(obj.style.position=="absolute" && inner_obj)
	{
		var formObj 	= document.PatOrderByLocnSearchResult;
		var bean_id 	= formObj.bean_id.value ;
		var bean_name 	= formObj.bean_name.value ;
		//var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
		//var xmlHttp	    = new ActiveXObject( "Microsoft.XMLHTTP" ) ;
		var xmlHttp = new XMLHttpRequest();
		xmlStr 			="<root><SEARCH /></root>" ;
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "PatOrderByLocnValidate.jsp?bean_id=" + bean_id +"&bean_name="+bean_name+"&patient_id="+patient_id+"&old_val="+old_val+"&curr_val="+curr_val+"&func_mode=populate_categories", false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText )	;

	}else {
			obj.style.position 		= "absolute";
			obj.style.visibility 	= "hidden";
			if(paint_obj)
				paint_obj.innerHTML	= "<a href=javascript:expandCategory(\""+old_val+"\",\""+curr_val+"\",\""+patient_id+"\",escape(\""+patient_details+"\"))>+&nbsp;"+patient_details_display+"</a></font>";
	}
}

function expandOrderType(old_val, curr_val, patient_id,order_category, cat_details){

	cat_details = unescape(cat_details);

	var cat_details_display = cat_details;

	cat_details_display = changeSpecialCharacter(cat_details_display,'ö',' ')
	cat_details_display = changeSpecialCharacter(cat_details_display,'ø','>')
	cat_details_display = changeSpecialCharacter(cat_details_display,'ù','\'')
	obj 		= eval("document.PatOrderByLocnSearchResult.all.fourthinnerlayernursing_"+old_val+curr_val);
	paint_obj	= eval("document.PatOrderByLocnSearchResult.all.catdtl_"+old_val+curr_val);
	inner_obj	= eval("document.PatOrderByLocnSearchResult.all.fourthlevelinner_"+old_val+curr_val);
	if(paint_obj)
		paint_obj.innerHTML	= "<a href=javascript:expandOrderType(\""+old_val+"\",\""+curr_val+"\",\""+patient_id+"\",\""+order_category+"\",escape(\""+cat_details_display+"\"))>-&nbsp;"+cat_details+"</a></font>";
	if(obj.style.position=="absolute" && inner_obj)
	{
		var formObj 	= document.PatOrderByLocnSearchResult;
		var bean_id 	= formObj.bean_id.value ;
		var bean_name 	= formObj.bean_name.value ;
		//var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
		//var xmlHttp	    = new ActiveXObject( "Microsoft.XMLHTTP" ) ;
		var xmlHttp = new XMLHttpRequest();
		xmlStr 			="<root><SEARCH /></root>" ;
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "PatOrderByLocnValidate.jsp?bean_id=" + bean_id +"&bean_name="+bean_name+"&patient_id="+patient_id+"&old_val="+old_val+"&curr_val="+curr_val+"&order_category="+order_category+"&func_mode=populate_order_type", false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText )	;
	}else {
			obj.style.position 		= "absolute";
			obj.style.visibility 	= "hidden";
			if(paint_obj)
				paint_obj.innerHTML	= "<a href=javascript:expandOrderType(\""+old_val+"\",\""+curr_val+"\",\""+patient_id+"\",\""+order_category+"\",escape(\""+cat_details_display+"\"))>+&nbsp;"+cat_details+"</a></font>";
	}
}
function addOrderTypeDetails(old_val,cat_details) {
	obj 			= eval("document.PatOrderByLocnSearchResult.all.fourthinnerlayernursing_"+old_val);
	exp_obj 		= eval("document.PatOrderByLocnSearchResult.all.fourthlevelinner_"+old_val);
	if(obj.style.position=="absolute" && exp_obj)
	{

		exp_obj.innerHTML		= cat_details;
		obj.style.position 		= "relative";
		obj.style.visibility	= "visible";
	}
}

function expandOrders(old_val,curr_val, patient_id,order_category,order_type_code,order_type_desc){

	order_type_desc 			= unescape(order_type_desc)
	var order_type_desc_display = order_type_desc;

	order_type_desc_display = changeSpecialCharacter(order_type_desc_display,'ö',' ')
	order_type_desc_display = changeSpecialCharacter(order_type_desc_display,'ø','>')
	order_type_desc_display = changeSpecialCharacter(order_type_desc_display,'ù','\'')

	obj 			= eval("document.PatOrderByLocnSearchResult.all.fifthinnerlayernursing_"+old_val+curr_val);
	paint_obj		= eval("document.PatOrderByLocnSearchResult.all.orderdtl_"+old_val+curr_val);
	inner_obj		= eval("document.PatOrderByLocnSearchResult.all.fifthlevelinner_"+old_val+curr_val);
	if(paint_obj)
		paint_obj.innerHTML	= "<a href=javascript:expandOrders(\""+old_val+"\",\""+curr_val+"\",\""+patient_id+"\",\""+order_category+"\",\""+order_type_code+"\",escape(\""+order_type_desc+"\"))>-&nbsp;"+order_type_desc_display+"</a></font>";
	if(obj.style.position=="absolute" && inner_obj)
	{
		var formObj 	= document.PatOrderByLocnSearchResult;
		var bean_id 	= formObj.bean_id.value ;
		var bean_name 	= formObj.bean_name.value ;
		//var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
		//var xmlHttp	    = new ActiveXObject( "Microsoft.XMLHTTP" ) ;
		var xmlHttp = new XMLHttpRequest();
		xmlStr 			="<root><SEARCH /></root>" ;
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "PatOrderByLocnValidate.jsp?bean_id=" + bean_id +"&bean_name="+bean_name+"&patient_id="+patient_id+"&old_val="+old_val+"&curr_val="+curr_val+"&order_category="+order_category+"&order_type_code="+order_type_code+"&func_mode=populate_orders", false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText )	;
	}else {
			obj.style.position 		= "absolute";
			obj.style.visibility 	= "hidden";
			if(paint_obj)
				paint_obj.innerHTML	= "<a href=javascript:expandOrders(\""+old_val+"\",\""+curr_val+"\",\""+patient_id+"\",\""+order_category+"\",\""+order_type_code+"\",escape(\""+order_type_desc+"\"))>+&nbsp;"+order_type_desc_display+"</a></font>";
	}
}
function addDetails(old_val,cat_details) {
	obj 			= eval("document.PatOrderByLocnSearchResult.all.fifthinnerlayernursing_"+old_val);
	exp_obj 		= eval("document.PatOrderByLocnSearchResult.all.fifthlevelinner_"+old_val);
	if(obj.style.position=="absolute" && exp_obj)
	{

		exp_obj.innerHTML		= cat_details;
		obj.style.position 		= "relative";
		obj.style.visibility	= "visible";
	}
}

function populateFrame(old_val, curr_val , patient_id , order_category ,order_type_code) {
	alert(order_category)
}

function changeSpecialCharacter( str , char_to_be_replaced, replace_char) {
	while(str.indexOf(char_to_be_replaced)!=-1)
	{
	 	str 	= str.replace(char_to_be_replaced,replace_char);
    }
	return str;
}

function hideToolTip()	{
	  parent.patientOrdersView.document.getElementById("tooltiplayer").style.visibility = "hidden"
}

function showToolTip(val){
	var val 	= unescape(val);
	buildTable (val);

	bodheight 	= parent.patientOrdersView.document.body.offsetHeight
	bodwidth  	= parent.patientOrdersView.document.body.offsetWidth
	var x 	  	= parent.patientOrdersView.event.x;
	var y 		= parent.patientOrdersView.event.y;
	x 			= x + (parent.patientOrdersView.document.getElementById("tooltiplayer").offsetWidth)
	y 			= y + (parent.patientOrdersView.document.getElementById("tooltiplayer").offsetHeight)
	if(x<bodwidth)   		x =parent.patientOrdersView.event.x
	else  		x = x - (parent.patientOrdersView.document.getElementById("tooltiplayer").offsetWidth*2)
	if(y<bodheight) 		y =parent.patientOrdersView.event.y
	else   		y = y - (parent.patientOrdersView.document.getElementById("tooltiplayer").offsetHeight*2)
	y+=parent.patientOrdersView.document.body.scrollTop
	x+=parent.patientOrdersView.document.body.scrollLeft
	parent.patientOrdersView.document.getElementById("tooltiplayer").style.posLeft= x
	parent.patientOrdersView.document.getElementById("tooltiplayer").style.posTop = y
   	parent.patientOrdersView.document.getElementById("tooltiplayer").style.visibility="visible"
}

function buildTable(val){
	var tab_dat  = "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>"
		tab_dat += "<tr>"
		tab_dat += "<td class='YELLOW' nowrap>"+val+"</td>"
		tab_dat += "</tr> "
		tab_dat += "</table> "
	parent.patientOrdersView.document.getElementById("td_id").innerHTML = tab_dat;
}

async function viewClobData(accession_num){
		var dialogHeight ='30' ;
		var dialogWidth = '38' ;
		var dialogTop	= '189';
		var dialogLeft = '107' ;
		var title = ''
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
		var arguments = "";
		var finalString	= "accession_num="+ escape(accession_num);
		var retVals = await window.showModalDialog("../../eOR/jsp/ReviewResultClobData.jsp?"+finalString,arguments,features);

}

async function viewComments(i){
	var result = eval("document.PatOrderView.result_str_"+i+".value");
	var retVal;
	var dialogHeight	= '9' ;
	var dialogWidth 	= '30' ;
	var features		= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
	var arguments		= result ;
	hdg_name			= "";
	retVal 				= await window.showModalDialog("../../eOR/jsp/OrderEntryComments.jsp?hdg_name="+hdg_name,arguments,features);
}

