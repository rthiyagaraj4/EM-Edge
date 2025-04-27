/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           created
23/08/2011  IN028370    Menaka      	Incident No: 028370 - <Wrong toot tip and image shown in Consent editor page.> 
06/04/2015	IN054751	Ramesh G		Alpha-OR-System does not reloads the patient name in Consent details window.
--------------------------------------------------------------------------------------------------------------------
*/
/*function listbox(){
	
	if(parent.consent_details.document.formConsentDetails.self1.value=='n') {
		var relation = parent.consent_details.document.formConsentDetails.relation.value;

	var formObj = parent.consent_details.document.formConsentDetails;
	
	var bean_id = formObj.bean_id.value ;
	var bean_name = formObj.bean_name.value ;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ConsentDetailsValidate.jsp?bean_id=" + bean_id +"&bean_name="+bean_name+"&default_val=''", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval(responseText);

	}
}
*/

function onLoadChk(){
	//	alert(document.formConsentDetails.flag.value);alert(document.formConsentDetails.self1.value);
//	if(document.formConsentDetails.flag.value=='yes'){
	if(document.formConsentDetails.self1.value=='' || document.formConsentDetails.self1.value=='y'){
			rel.style.visibility="hidden";
			document.formConsentDetails.elements[0].checked=true;
			//ListClear();
	}
	if(document.formConsentDetails.self1.value=='n'){
		document.formConsentDetails.patient_name.disabled=false;
	}else
		document.formConsentDetails.patient_name.disabled=true;
}

function disableText(){
	if(document.formConsentDetails)
	{
		//IN054751 Start.
		//var pat_name_def=document.formConsentDetails.patient_name.value;
		var pat_name_def=document.formConsentDetails.pat_name.value;
		//IN054751 End.
		document.formConsentDetails.patient_name.value=pat_name_def;
		document.formConsentDetails.patient_name.disabled=true;
		rel.style.visibility="hidden";
		rel1.style.visibility="hidden";
	}
	
}


function enableText(){
	var pat_name=document.formConsentDetails.pat_name.value;
	document.formConsentDetails.patient_name.value="";
	document.formConsentDetails.patient_name.disabled=false;
	rel.style.visibility="visible";
	rel1.style.visibility="visible";
	
	//ListClear();
	/*var formObj = document.formConsentDetails;
	var bean_id = formObj.bean_id.value ;
	var bean_name = formObj.bean_name.value ;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ConsentDetailsValidate.jsp?bean_id=" + bean_id +"&bean_name="+bean_name+"&default_val=''", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval(responseText);
	*/
}

function addRelationList(value,code) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	
	parent.consent_details.document.formConsentDetails.reln_box.add(element);
}

/*****************************************************************************/
function ListClear() {
	var len = eval("document.formConsentDetails.reln_box.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval("document.formConsentDetails.reln_box.remove(\"atc_class_l2_code\")") ;
	}
	var tp = "  ---"+getLabel("Common.defaultSelect.label","Common")+"---   " ;
	var opt  	= eval("document.createElement(\"OPTION\")") ;
	opt.text 	= tp ;
	eval("document.formConsentDetails.reln_box.add(opt)") ;
}
/****************************************************************************/




function clearList(relation,relation_text) {
	
	var len = eval("document.formConsentDetails.reln_box.options.length") ;
	for(var i=0;i<len;i++)
	{
		
		eval("document.formConsentDetails.reln_box.remove(relation)") ;
	}
	
/*	var tp			=document.formConsentDetails.reln_box.remove(relation)
	var tp 		= relation_text;
	var tp_val	= relation;
	var opt  	= eval("document.createElement(\"OPTION\")") ;
	opt.text 	= tp ;
	opt.value	= tp_val;
	//eval("document.formConsentDetails.reln_box.selected(opt)") ;*/
}


/********************************************************************************/
	//for common look up for referral practioner

async function practitioner_display(target){

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	locale = formConsentDetails.locale.value;
	
//	argumentArray[0]   = formConsentDetails.practitioner_code_sql.value;
	argumentArray[0]   = "SELECT PRACTITIONER_ID code,PRACTITIONER_NAME description FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND EFF_STATUS = 'E' AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) AND UPPER(PRACTITIONER_NAME) LIKE UPPER(?)";
	/*Commented and updated by Dinesh T on 11/19/2010 for incident no 25051*/
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;
		
	retVal = await CommonLookup( getLabel("Common.practitioner.label","Common"),argumentArray );

	if(retVal != null && retVal != ""){
		var ret1=unescape(retVal);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		document.formConsentDetails.practitionerId.value=arr[0];
		target.value = arr[1];

		document.formConsentDetails.dat_time.focus();
	}else{
				//target.value="";
				document.formConsentDetails.Practioner_name.focus();
			}
	}
/**************************************************************/
async function onblur_pract_disp(target)
{
	if(target.value != '')
	{
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;

		locale = formConsentDetails.locale.value;
		argumentArray[0]   = formConsentDetails.practitioner_code_sql.value;
		argumentArray[0]   = "SELECT PRACTITIONER_ID code,PRACTITIONER_NAME description FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND EFF_STATUS = 'E' AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) AND UPPER(PRACTITIONER_NAME) LIKE UPPER(?)";
		/*Commented and updated by Dinesh T on 11/19/2010 for incident no 25051*/

		argumentArray[1]   = dataNameArray ;
		argumentArray[2]   = dataValueArray ;
		argumentArray[3]   = dataTypeArray ;
		argumentArray[4]   = "1,2";
		argumentArray[5]   = target.value ;
		argumentArray[6]   = CODE_LINK ;
		argumentArray[7]   = CODE_DESC ;
		
		retVal = await CommonLookup( getLabel("Common.practitioner.label","Common"), argumentArray );

		if(retVal != null && retVal != "")
		{
			var ret1=unescape(retVal);
			var arr=ret1.split(",");
			if(arr[1]==undefined) { 
			arr[1]="";
			arr[0]="";
			}
			document.formConsentDetails.practitionerId.value=arr[0];
			target.value = arr[1];

			document.formConsentDetails.dat_time.focus();
		}
		else
		{
			target.value="";
			document.formConsentDetails.Practioner_name.focus();
		}
	}
}


/************************************************************/
	//to check for date validation

/*function chkdate(target){
	
	if(target.value=="" || target.value==null){
		//do nothing
	}else{
		
		doDateTimeChk(target);
	}
}*/

function CheckSpecCharsCols(event){
    var strCheck = '0123456789/\: ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return true ;
}



/*************************************************************/


function onClose(){
		var cnt = parent.consent_orderable.document.formConsentOrderable.cat_cnt.value;
		var ord_ctg_cd="";var flag=false;
		for(var i=0;i<cnt;i++){
			if(eval("parent.consent_orderable.document.formConsentOrderable.chk"+i).checked == true){
				ord_ctg_cd += eval("parent.consent_orderable.document.formConsentOrderable.catalog_cd"+i).value+"||";
				flag=true;
			}
		}
		parent.consent_orderable.document.formConsentOrderable.orderable_chk.value = ord_ctg_cd;

		var obj =new Array();

		obj[0] = document.formConsentDetails.patient_name.value;
		obj[1] = document.formConsentDetails.Practioner_name.value;
		obj[2] = document.formConsentDetails.dat_time.value;
		obj[3] = document.formConsentDetails.remarks.value;
		obj[4] = document.formConsentDetails.ord_pract.value;
		obj[5] =eval("document.formConsentDetails.Consent_detail.value");
		
		if(document.formConsentDetails.self[0].checked){
			obj[6] = "y";
			obj[8]="";
			obj[9]="";
		}else if(document.formConsentDetails.self[1].checked){
			obj[6] = "n";			
		obj[8]=document.formConsentDetails.reln_box[document.formConsentDetails.reln_box
		.selectedIndex].value;
		obj[9]=document.formConsentDetails.reln_box[document.formConsentDetails.reln_box
		.selectedIndex].text;
		}
	
		if(document.formConsentDetails.practitionerId.value==""){
			obj[7] = document.formConsentDetails.pract_id.value;
		}else{
			obj[7] =  document.formConsentDetails.practitionerId.value;
		}
		
		obj[10] = parent.consent_orderable.document.formConsentOrderable.orderable_chk.value;

		if(obj[0]==""){
			alert(getMessage("NAME_BLANK","OR"));//me cannot be blank...");
			return false
		}else if(obj[1]==""){
			alert(getMessage("PRACT_NOT_BLANK","OR"));
		return false
		}else
			{
				if(obj[2] != "" && obj[2] != null && obj[2] != " ")
				{
					var date = new Array();
					var indx = obj[2].lastIndexOf(" ");
								
					date[0] = obj[2].substring(0,indx);
					date[1] = obj[2].substring(indx+1);
					if((checkDt(date[0])) && (chkTime(date[1])))
					{	
						window.returnValue = obj;
						window.close();
					}
					else
					{
						alert(getMessage("INVALID_DATE_TIME","common"));
					}
				}
				else
				{
					window.returnValue = obj;
					window.close();
				}
			}
		}


/*******************************************************************/

function consentNotes(consent_form_id){
 		
		//alert(" in consentNotes"+consent_form_id);
		/*if(parent.consent_orderable.document.formConsentOrderable.orderable_chk.value !='' && parent.consent_orderable.document.formConsentOrderable.orderable_chk.value !='undefined'){
			var cnt = parent.consent_orderable.document.formConsentOrderable.cat_cnt.value;
			 var ord_ctg_cd="";var flag=false;
			 for(var i=0;i<cnt;i++){
				if(eval("parent.consent_orderable.document.formConsentOrderable.chk"+i).checked == true){
					ord_ctg_cd += eval("parent.consent_orderable.document.formConsentOrderable.catalog_cd"+i).value+"||";
					flag=true;
				}
			}
			if(!flag){
				alert(getOrMessage("CLICK_ONE_ORDERABLE"));	
				return false;
			}
			 
		}
			//alert(ord_ctg_cd);
			parent.consent_orderable.document.formConsentOrderable.orderable_chk.value = ord_ctg_cd;
			document.formConsentDetails.order_catalog_code.value = ord_ctg_cd;

			var dialogHeight ='20' ;
			var dialogWidth = '38' ;
			var dialogTop	= '120';
			var dialogLeft = '10' ;

			var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
			var arguments = "";
			
			//var Consent_detail=	document.formConsentDetails.Consent_detail.value
			var index=document.formConsentDetails.index.value;
			var bean_id=document.formConsentDetails.bean_id.value;
			var bean_name=document.formConsentDetails.bean_name.value;
			var order_catalog_code = document.formConsentDetails.order_catalog_code.value;
			var order_catalog_desc = document.formConsentDetails.order_catalog_desc.value;

			

			var retVals = window.showModalDialog("../../eOR/jsp/ConsentNotesFrameSet.jsp?order_id="+order_id+"&index="+index+"&bean_name="+bean_name+"&bean_id="+bean_id+"&order_catalog_code="+order_catalog_code+"&order_catalog_desc="+order_catalog_desc,arguments,features);
			
			if(retVals!= null){
						
				document.formConsentDetails.Consent_detail.value=retVals;
			}
		*/
		if(parent.editor && parent.editor_button && parent.editor.RTEditor0 && parent.consent_details){   //it is already there, then put the editor value into  the bean
			// Set it in the bean (old one)
 			var bean_id				= parent.editor_button.document.editorButtonForm.bean_id.value;
 			var bean_name			= parent.editor_button.document.editorButtonForm.bean_name.value;
			var old_consent_form_id	= parent.editor_button.document.editorButtonForm.consent_form_id.value;
 			var index				= parent.editor_button.document.editorButtonForm.index.value;
  			var count				= "1";  

			var patient_name		= parent.consent_details.document.formConsentDetails.patient_name.value
			var Practioner_name		= parent.consent_details.document.formConsentDetails.Practioner_name.value
			var reln_box			= parent.consent_details.document.formConsentDetails.reln_box.value
			var dat_time			= parent.consent_details.document.formConsentDetails.dat_time.value
			var remarks				= parent.consent_details.document.formConsentDetails.remarks.value
			var practitioner_id		= parent.consent_details.document.formConsentDetails.practitionerId.value

			var self				= "";
			if(parent.consent_details.document.formConsentDetails.self[0].checked)
				self				= "y";
			else 
				self				= "n";
   			//var xmlDoc 				= new ActiveXObject( "Microsoft.XMLDom" ) ;
			//var xmlHttp 			= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
			var xmlHttp = new XMLHttpRequest();
			xmlStr					= "<root><SEARCH " ;
			xmlStr					+= "bean_id=\"" +bean_id +"\" ";
			xmlStr					+= "bean_name=\"" +bean_name +"\" ";
			xmlStr					+= "index=\"" +index +"\" ";
			xmlStr					+= "consent_form_id0=\"" +old_consent_form_id +"\" ";
			xmlStr					+= "consent_form_text0=\""+checkSpl(parent.editor.RTEditor0.document.body.innerHTML) +"\" ";
			xmlStr					+= "patient_name=\""+checkSpl(patient_name) +"\" "; 
			xmlStr					+= "practitioner_name=\""+checkSpl(Practioner_name) +"\" "; 
			xmlStr					+= "practitioner_id=\""+checkSpl(practitioner_id) +"\" "; 
			xmlStr					+= "reln_box=\""+checkSpl(reln_box) +"\" "; 
			xmlStr					+= "dat_time=\""+checkSpl(dat_time) +"\" "; 
			xmlStr					+= "remarks=\""+checkSpl(remarks) +"\" "; 
			xmlStr					+= "self=\""+checkSpl(self) +"\" "; 
		 	xmlStr					+= "count=\"" +count +"\" ";
	 		xmlStr 					+=" /></root>" ;
 
			var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "ConsentNotesValidate.jsp", false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			eval( responseText ) ;
		}
	
		var query_string = parent.consent_orderable.document.formConsentOrderable.query_string.value;
		query_string	 += "&consent_form_id="+consent_form_id
		var query_String_ ="bean_id="+parent.consent_orderable.document.formConsentOrderable.bean_id.value+"&bean_name="+parent.consent_orderable.document.formConsentOrderable.bean_name.value+"&index="+parent.consent_orderable.document.formConsentOrderable.index.value+"&task_categ="+parent.consent_orderable.document.formConsentOrderable.task_categ.value+"&consent_form_id="+consent_form_id;
		parent.editor_template.location.href = "../../eOR/jsp/EditorTemplate.jsp?"+query_string;
		parent.editor.location.href = "../../eCommon/jsp/RTEditor.jsp";
		parent.editor_button.location.href = "../../eOR/jsp/ConsentEditorButton.jsp?"+query_String_;
}
/***********************************************************************************/
function chkValidate(index){
	var cnt = document.formConsentOrderable.cat_cnt.value;
	var flag=false;
	if(eval("document.formConsentOrderable.chk"+index).checked == true){
		for(var i=0;i<cnt;i++){
			if(eval("document.formConsentOrderable.chk"+i).checked == false){
				flag=false;
				break;
			}else
				flag=true;
		}
	}else
		flag = false;
	if(!flag)
		document.formConsentOrderable.cat_chk.checked = false;
	else
		document.formConsentOrderable.cat_chk.checked = true ;
}
/***********************************************************************************/
function selectAll(obj){
	//alert(obj);
	var cnt = document.formConsentOrderable.cat_cnt.value;
	if(obj == ""){
		if(document.formConsentOrderable.cat_chk.checked == true){
			for(var i=0;i<cnt;i++){
				eval("document.formConsentOrderable.chk"+i).checked = true;
			}
		}else{
			for(var i=0;i<cnt;i++){
				eval("document.formConsentOrderable.chk"+i).checked = false;
			}
		}
	}else{
		if(document.formConsentOrderable.orderable_chk.value != ""){
		if(document.formConsentOrderable.orderable_chk.value == ""){
			document.formConsentOrderable.cat_chk.checked = true;
			for(var i=0;i<cnt;i++){
				eval("document.formConsentOrderable.chk"+i).checked = true;
			}
		}else{
			var orderable_val=document.formConsentOrderable.orderable_chk.value;
			var orderable_arr=orderable_val.split("||");
			for(var i=0;i<cnt;i++){
				var catalog_cd =eval("document.formConsentOrderable.catalog_cd"+i).value;
				for(var j=0;j<orderable_arr.length;j++){
					if(catalog_cd == orderable_arr[j]){
						eval("document.formConsentOrderable.chk"+i).checked = true;
						chkValidate(i);
					}
				}
			}
		}
		}
	}
}

/***********************************************************************************/

function onCloseNotes(){

	var vals= "";
	var count= document.formConsentNotes.count.value;
	var order_catalog_code=document.formConsentNotes.order_catalog_code.value;

		if(count==0){
			vals = document.formConsentNotes.consent_form_text.value;
			if(vals==""){
				//alert("APP-000001 Consent Notes cannot be blank...");
				alert(getMessage("CONSENT_NOTE_CANT_BLANK","OR"));
				return false;
			}	
		} else {
 			for(i=0;i<count;i++){
				var vals=eval("document.formConsentNotes.consent_form_text"+i+".value");
				if(vals==""){
					//alert("APP-000001 Consent Notes cannot be blank...");
					alert(getMessage("CONSENT_NOTE_CANT_BLANK","OR"));
				return false;
	 		} 
		 }
		}	
	var formObj = document.formConsentNotes;
	eval(formApply(formObj,"../../eOR/jsp/ConsentNotesValidate.jsp"))
	window.returnValue = vals ;
	window.close();

	
}

function datetimecheck(target)
{
 	if(target.value != "" && target.value != null)
	{
		if(doDateTimeChk(target)==false){
			alert(getMessage("INVALID_DATE_TIME","SM"));
			target.value = document.formConsentDetails.curr_sys_date.value; 
		}
	}
}

function Close()
{
	var obj =new Array();
	obj=null;
	window.returnValue =obj ;
	window.close();

}

function setZoomEditorTemplate()
{
 	// Setting the value to the editor.	
 	var RTEText = parent.editor_button.document.editorButtonForm.RTEText.value;

	parent.editor.RTEditor0.document.designMode = "On";
	parent.editor.RTEditor0.document.body.focus();
	parent.editor.RTEditor0.document.body.innerHTML = "";
	parent.editor.RTEditor0.document.execCommand("formatBlock","", "Address");

   	if(RTEText!="")
	{
		var conf_editor = confirm(getMessage("CONFIRM_ZOOM","OR"));
		if(conf_editor)
		{
			//parent.consentdetails.rows="0%,0%,16%,*,7%"
			parent.document.getElementById('editor').contentWindow.document.getElementById('RTEditor0').style.height='68vh';
			parent.document.getElementById('editor').contentWindow.document.getElementById('RTEditor0').style.width='92vw';
			parent.document.getElementById("consent_details").style.height="33vh";
			parent.document.getElementById("consent_orderable").style.height="8vh";
			parent.document.getElementById("editor_template").style.height="16vh";
			parent.document.getElementById("editor").style.height="48vh";
			parent.document.getElementById("editor_button").style.height="9vh";

			//Menaka Modification starts for IN:028370 
			document.editorButtonForm.zoom.title="ZoomOut"
 			document.editorButtonForm.zoom.src = "../../eOR/images/Minimize.gif";//Menaka Modification End For IN:028370 
		}
		else
		{
			//parent.consentdetails.rows="28%,16%,10%,*,7%";
			parent.document.getElementById('editor').contentWindow.document.getElementById('RTEditor0').style.height='55vh';
			parent.document.getElementById('editor').contentWindow.document.getElementById('RTEditor0').style.width='90vw';
			parent.document.getElementById("consent_details").style.height="28vh";
			parent.document.getElementById("consent_orderable").style.height="8vh";
			parent.document.getElementById("editor_template").style.height="10vh";
			parent.document.getElementById("editor").style.height="48vh";
			parent.document.getElementById("editor_button").style.height="9vh";

			document.editorButtonForm.zoom.title="ZoomIn"//Menaka for IN:028370 
			document.editorButtonForm.zoom.src = "../../eOR/images/Maximize.gif";
		}
		parent.editor.RTEditor0.document.body.insertAdjacentHTML("BeforeEnd",RTEText);
	}	
}


function focusPreviewFrameset(){
	parent.preview.focus();
	//document.editor_preview.focus();
}

function zoomWindow(){
		if(parent.document.getElementById('consent_details').style.height!='0vh') {
			//parent.consentdetails.rows="0%,0%,15%,*,7%"	;	
			parent.document.getElementById('editor').contentWindow.document.getElementById('RTEditor0').style.height='68vh';
			parent.document.getElementById('editor').contentWindow.document.getElementById('RTEditor0').style.width='92vw';
			parent.document.getElementById('consent_details').style.height='0vh';
			parent.document.getElementById('consent_orderable').style.height='0vh';
			parent.document.getElementById('editor_template').style.height='16vh';
			parent.document.getElementById('editor').style.height='60vh';
			parent.document.getElementById('editor_button').style.height='10vh';
			//document.editorButtonForm.zoomIn.value="ZoomOut"
			document.editorButtonForm.zoom.title="ZoomOut"//Menaka for IN:028370
 			document.editorButtonForm.zoom.src = "../../eOR/images/Minimize.gif";
		} else  {
		 	//parent.consentdetails.rows="28%,16%,10%,*,7%";
			parent.document.getElementById('editor').contentWindow.document.getElementById('RTEditor0').style.height='55vh';
			parent.document.getElementById('editor').contentWindow.document.getElementById('RTEditor0').style.width='90vw';
			parent.document.getElementById('consent_details').style.height='20vh';
			parent.document.getElementById('consent_orderable').style.height='10vh';
			parent.document.getElementById('editor_template').style.height='10vh';
			parent.document.getElementById('editor').style.height='45vh';
			parent.document.getElementById('editor_button').style.height='5vh';
			//document.editorButtonForm.zoomIn.value="ZoomIn"
			document.editorButtonForm.zoom.title="ZoomIn"//Menaka for IN:028370
			document.editorButtonForm.zoom.src = "../../eOR/images/Maximize.gif";
		}
  
}

function copyDetails(obj){

   if(obj=="self") { // then it is for the radio button
	if(document.formConsentDetails.self[0].checked)
		val = getLabel("Common.self.label","Common");
	else if(document.formConsentDetails.self[1].checked)
		val = getLabel("Common.others.label","Common");
 }
 else if(obj=="relation"){
		val =  document.formConsentDetails.reln_box[document.formConsentDetails.reln_box.selectedIndex].text

 }
 else  {
	  val = obj.value
 }

 if(val!="" && parent.editor && parent.editor.RTEditor0) {
		/*parent.editor.RTEditor0.focus();
		parent.editor.RTEditor0.document.clear();
		parent.editor.RTEditor0.document.execCommand("paste","",val);
		*/
		var editor = parent.editor.RTEditor0.document;
        var editorBody = editor.body;
        editorBody.focus();
        editorBody.innerHTML =val+editorBody.innerHTML;
	}
}


 function reprintNotes(cons_form_id){
 	 	var bean_id					= parent.preview.document.editor_preview.bean_id.value;
		var bean_name				= parent.preview.document.editor_preview.bean_name.value;
		var index					= parent.preview.document.editor_preview.index.value;

		var new_consent_format_id	=  parent.preview.document.editor_preview.new_consent_format_id.value;
		var new_consent_format_label=  parent.preview.document.editor_preview.new_consent_format_label.value;
 		
		var query_string			= "bean_id="+bean_id+"&bean_name="+bean_name+"&index="+index+"&consent_form_id="+escape(cons_form_id)+"&new_consent_format_id="+escape(new_consent_format_id)+"&new_consent_format_label="+escape(new_consent_format_label)
 		parent.preview.location.href = "../../eOR/jsp/ConsentPreview.jsp?"+query_string;
		parent.preview_button.location.href = "../../eOR/jsp/ConsentPreviewButton.jsp?"+query_string;;

 }
 
