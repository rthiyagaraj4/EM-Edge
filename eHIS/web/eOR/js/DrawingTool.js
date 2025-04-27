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

/*function showImage(){
	var bean_id		=  document.addlSearchCriteriaForm.bean_id.value;
	var bean_name	=  document.addlSearchCriteriaForm.bean_name.value;
	var bean_name	=  document.addlSearchCriteriaForm.bean_name.value;
	parent.parent.parent.parent.location.href="../../eOR/jsp/Image.jsp?bean_id="+escape(bean_id)+"&bean_name="+escape(bean_name)+"&sec_hdg_code=AS&image_view_counter="
	//parent.parent.parent.parent.location.href="../../eCA/jsp/MedPntredit.jsp?sec_hdg_code=AS&image_view_counter="
 	//parent.parent.parent.parent.orderMainTab.location.href="../../eCA/jsp/MedPntredit.jsp?sec_hdg_code=AS&image_view_counter="
} // End of showImage
*/
// Populate the order catalogs inthe Drawing tool, on change of the image ref or on load of the form
function populateCatalogs(obj){
 		query_string	= document.drawingToolCriteria.query_string.value;
 		parent.criteriaMainFrame.location.href = "../../eOR/jsp/DrawingToolResults.jsp?"+query_string+"&image_id="+obj.value;
}

function populateDrawingTools(catalog_code){
	// This method is called to put the order_catalog_code it into the bean, when the user wants to use the place order, he can use it.
	parent.storeCheckedValues("drawingToolResults","YES");
 	query_string = document.drawingToolResults.query_string.value;

	// Load the Painter and Button Frame
 	parent.criteriaPainterFrame.location.href = "../../eOR/jsp/MedPntredit.jsp?"+query_string+"&catalog_code="+catalog_code;
 	parent.criteriaButtonFrame.location.href = "../../eOR/jsp/DrawingToolButton.jsp?"+query_string+"&catalog_code="+catalog_code;
}

function Clear(){
		parent.criteriaSearchFrame.document.location.reload();
		parent.criteriaMainFrame.location.href="../../eCommon/html/blank.html";
		parent.criteriaPainterFrame.location.href="../../eCommon/html/blank.html";
		parent.criteriaButtonFrame.location.href="../../eCommon/html/blank.html";
}

function loadDrawingTool() {
 	var load_values = document.editor.load_values.value;
  	if(load_values!="")
		document.applets["drawing"].SetImage(load_values);
 		//parent.parent.criteriaPainterFrame.document.applets["drawing"].SetImage(load_values);
}
 
// this function is used from the Order Entry to Insert the record
function apply(){

 	// No need to check whether it has been edited or not
	//var image_edited_yn =  parent.RecClinicalNotesMediPainterFrame.document.applets["drawing"].IsChanged() ;
	//parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesMediPainterFrame.document.applets["drawing"].IsChanged();
	
	// Store it in a hidden value
	var image_content		=	(parent.criteriaPainterFrame.document.applets["drawing"].GetImage("JPEG"));

	// set it in the hidden field
	//document.buttonForm.image_content.value  =  image_content;

	document.buttonForm.image_content.value  =  "";


	var bean_id			=  document.buttonForm.bean_id.value;
	var bean_name		=  document.buttonForm.bean_name.value;
	var patient_id		=  document.buttonForm.patient_id.value;
	var encounter_id		=  document.buttonForm.encounter_id.value;
	//var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
	//var	xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	var xmlHttp = new XMLHttpRequest();
		xmlStr		= "<root><SEARCH " ;
		xmlStr		+= "image_content=\"" + image_content +"\" "
		xmlStr		+=" /></root>"
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "DrawingToolValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name+"&encounter_id="+encounter_id+"&patient_id="+patient_id, false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText	= xmlHttp.responseText ;
		eval( responseText ) ;
} // End of apply


function callBeforeApply(){
 	eval(formApply(document.buttonForm,OR_CONTROLLER));
	if(top.content)
	 	top.content.messageFrame.location.href = "../../eCA/jsp/error1.jsp?err_num="+message;
	else 
		window.close();
 	if(result) {  // Call the onSuccess Method, to refresh the screen
		onSuccess(); // For New Orders Only  
 	} // End of if result
}

// this function is used from the Result Entry to update the record
function resultApply() {
 	// Store it in a hidden value
	var image_content		=	(parent.criteriaPainterFrame.document.applets["drawing"].GetImage("JPEG"));

  	var bean_id			=  document.buttonForm.bean_id.value;
	var bean_name		=  document.buttonForm.bean_name.value;
	var patient_id		=  document.buttonForm.patient_id.value;
	var encounter_id		=  document.buttonForm.encounter_id.value;
	//var xmlDoc 		= new ActiveXObject( "Microsoft.XMLDom" ) ;
	//var	xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	var xmlHttp = new XMLHttpRequest();
		xmlStr		= "<root><SEARCH " ;
		xmlStr		+= "image_content=\"" + image_content +"\" "
		xmlStr		+=" /></root>"
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "DrawingToolValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name+"&encounter_id="+encounter_id+"&patient_id="+patient_id, false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText	= xmlHttp.responseText ;
		eval( responseText ) ;
}// resultApply



function assignResult(_result, _message, _flag){
	//alert(_result +"  -  "+_message+"  -  "+_flag)
	result	= _result ;
	message = _message ;
	flag	= _flag ;
}


// For Order Entry on successful completion of the order entry
function onSuccess(){
	if(parent.criteriaSearchFrame)
		parent.criteriaSearchFrame.location.href			= "../../eCommon/html/blank.html";
	if(parent.criteriaMainFrame) 
		parent.criteriaMainFrame.location.href		= "../../eCommon/html/blank.html";  // For the Place Order
	if(parent.criteriaPainterFrame)
		parent.criteriaPainterFrame.location.href		= "../../eCommon/html/blank.html";
	if(parent.criteriaButtonFrame)
		parent.criteriaButtonFrame.location.href		= "../../eCommon/html/blank.html";
  
	if(parent.parent.parent.parent.orderMainTab)
		parent.parent.parent.parent.orderMainTab.location.reload();
		//parent.parent.parent.parent.frames[0].location.reload()

	if(parent.parent.criteriaCategoryButtonFrame)
		parent.parent.criteriaCategoryButtonFrame.location.reload();
}

// to Zoom the window
function zoomWindow(){
	var zoom_yn		= document.editor.zoom_yn.value;
	var called_from = document.editor.called_from.value;
 	var rows		= "";
	var cols		= "";
   	if(called_from=="RESULT")
		cols		= parent.drawingtools.cols
    else 
		rows		= parent.drawingtools.rows
 	if(zoom_yn=="Y") {
		if(rows!="")
			rows		= "0%,0%,*,5%";
		if(cols!="")	 
			cols		= "0%,*";
		// Set the hidden field as "N", so that can zoom out
		document.editor.zoom_yn.value = "N";
	} else {  //to the old position
		if(rows!="")
			rows		= "8%,20%,*,5%";
 		if(cols!="")	 
			cols		= "40%,*";
		// Set the hidden field as "Y", so that can zoom in
		document.editor.zoom_yn.value = "Y";
	}
	if(rows!="") {
	  	parent.drawingtools.removeAttribute(rows);
		parent.drawingtools.rows = rows;
	}
	if(cols!="") {
	 	parent.drawingtools.removeAttribute(cols);
		parent.drawingtools.cols = cols;
	}

}
