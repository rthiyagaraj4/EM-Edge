/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var function_id = "" ;
var result = false;
var message = "" ;
var flag = "" ;  

	
function lockSpecialCharacters(obj)
		{
			var key = window.event.keyCode
				if(((key >=65)&&(key <=90)) || ((key >=97 )&&(key<=122))||((key >=48) &&(key <=57)))
			{

				return true 
			}
			else
			{

				return false
			}
		}
function populateOrderTypes(ord_cat){
	var n= document.frmPatientOrders.p_order_type_from.options.length;	
	var n1= document.frmPatientOrders.p_order_type_to.options.length;
	for(var i=0;i<n;i++){
		document.frmPatientOrders.p_order_type_from.remove("p_order_type_from");			
	}
	for(var i=0;i<n1;i++){
		document.frmPatientOrders.p_order_type_to.remove("p_order_type_to");			
	}
var str =ord_cat.value;

    if( ord_cat.value == "" ){
		clearList("document");
		clearList1("document");
	}
	var bean_id = document.frmPatientOrders.bean_id.value ;
	var queryString = "bean_id=\""+bean_id+"\" ord_cat=\""+str+"\"";
	var temp_jsp = "PatientOrdersReportValidate.jsp";
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	var str="<root><SEARCH " ;
	str+="tmp"+"=\""+ "tmp" +"\" "+queryString ;
	str+=" /></root>" ;
	xmlDoc.loadXML(str);
	
	xmlHttp.open("POST",temp_jsp,false);
	
	xmlHttp.send(xmlDoc);
	
	responseText=xmlHttp.responseText ;
	eval(responseText);
	
}
function clearList( docObj ) {
	/*var tp = "All" ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "*ALL" ;
	eval(docObj+".frmPatientOrders.p_order_type_from.add(opt)") ;*/
}
function clearList1( docObj ) {
/*	var tp = "All" ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "*ALL" ;
	eval(docObj+".frmPatientOrders.p_order_type_to.add(opt)") ;*/
}
function addLocationList(code,value) {
	var element = document.createElement('OPTION') ;
	//alert("code"+code)
	//alert("value"+value)
	element.value =  code ;
	element.text = value ;
	document.frmPatientOrders.p_order_type_from.add(element);
	
}

function addLocationList1(code,value) {
	var element1 = document.createElement('OPTION') ;
	//alert("code"+code)
	//alert("value"+value)
	element1.value =  code ;
	element1.text = value ;
	document.frmPatientOrders.p_order_type_to.add(element1);
}
function run()
{
	//alert("run clicked");
	
	if(searchResultFrame.document.frmPatientOrders.p_patient_id.value == '')
	{
		
		message = getMessage("SHD_NOT_BE_BLANK","OR");
		messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+message;
		return false
	}
	//alert(searchResultFrame.document.frmPatientOrders.p_order_type_from.value)
	//alert(searchResultFrame.document.frmPatientOrders.p_order_type_to.value)
	searchResultFrame.document.frmPatientOrders.submit()
				
	

}

function reset()
{
	//alert(parent.frames[1].name)
	parent.content.searchResultFrame.location.href="../../eOR/jsp/ORPatientOrders.jsp";
}

function callPatientSearch(){
	var pat_id =  PatientSearch();

	if(pat_id != null)
	document.frmPatientOrders.p_patient_id.value = pat_id;
}

function callEncounterSearch(target)
{

}

function datefun(obj)
{
		var t1 = ChkDate(obj);		
		if(!t1)
			{
			//obj.value=""; 
			var msg = getMessage("INVALID_DATE_FMT","OR");
			alert(msg);
			obj.focus();
			return;
			}
}

function Valid_DT(event)
	{
		var strCheck = '0123456789/';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  // Get key value from key code
		if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	} 


	
