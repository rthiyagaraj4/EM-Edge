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
Date       		Edit History    Name        	Description
--------------------------------------------------------------------------------------------------------------
?             	100            	?           	created						
05/07/2012    	IN029935      	Chowminya G	 	Add NPB Request Form in query 
09/011/2012		IN030473		Ramesh G		Bru-HIMS-CRF-032 
14/03/2018		IN066781		Vijayakumar K	ARYU-SCF-0063 [IN:066781]
---------------------------------------------------------------------------------------------------------------
*/

var function_id = "" ;
var result = false;
var message = "" ;
var flag = "" ;
var qry_string = "";

function create() {
	f_query_add_mod.location.href = "../../eOR/jsp/ConsentFormatAddModify.jsp?mode=1&function_id="+function_id ;
}

function query() {
	f_query_add_mod.location.href='../../eOR/jsp/ConsentFormatQueryCriteria.jsp?function_id='+function_id ;
}

function apply() {
	if (! checkIsValidForProceed() ) {
		message  = getMessage("NOT_VALID",'OR'); 
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	var formObj = f_query_add_mod.document.consent_format ;
	var fields = new Array ( 
							formObj.consent_form_id
							,formObj.Consent_form_label
							//,formObj.consent_form_text
						);

	var names = new Array ( getLabel("Common.identification.label","Common")
							,getLabel("Common.description.label","COMMON")
							//,"Text"
				);

	if(formObj.effective_status.checked == true){
		formObj.effective_status.value = "E";
	}else{
		formObj.effective_status.value = "D";
	}


	if(f_query_add_mod.checkFieldsSpecific( fields, names, messageFrame)) {

		var flds=new Array(formObj.consent_form_id);
		var name=new Array(getLabel("Common.identification.label","Common"));
		if(SpecialCharCheck(flds,name,messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){

			qry_string =  "mode=2&consent_form_id="+formObj.consent_form_id.value+"&eff_status="+formObj.effective_status.value+"&consent_format="+formObj.consent_format.value+"&indexed="+formObj.indexed.value
				//alert("here"+f_query_add_mod.document.consent_format.all.value);
   			eval(formApply( f_query_add_mod.document.consent_format,OR_CONTROLLER)) ;

			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			if( result ) {
				onSuccess();
			}
		}

	}
}

function reset(){
	if(f_query_add_mod.document.forms[0] != null){

		if(f_query_add_mod.document.forms[0].name == "consent_format"){
			f_query_add_mod.document.consent_format.reset();
		}else{
			f_query_add_mod.document.forms[0].reset();
		}
	}

}


function onSuccess() {
	var mode = f_query_add_mod.document.consent_format.mode.value;
	if( mode == "1" ) {
		formReset();
		f_query_add_mod.location.href = "../../eOR/jsp/ConsentFormatAddModify.jsp?mode=1"
	}
	if(mode == "2"){
		f_query_add_mod.location.href="../../eOR/jsp/ConsentFormatAddModify.jsp?"+qry_string;
	}
}


function formReset () {
	var formObj = f_query_add_mod.document.consent_format;
	formObj.consent_form_id.value = "";
	formObj.consent_form_text.value = "";
	formObj.Consent_form_label.value = "";

}

function assignResult(_result, _message, _flag , _dummy){
	result = _result ;
	message  = _message ;
	flag = _flag ;

}

function CheckMaxLength(obj,max) {
	if(obj.value.length >= max) {
		//alert("Max limit is 2000 Characters");
		alert(getMessage("MAX_LIMIT","OR"));
		return false;
	} else return true;
}

function checkFieldsSpecific( fields, names, messageFrame) {
    var errors = "" ;
    for( var i=0; i<fields.length; i++ ) {
        if(trimCheck(fields[i].value)) {
        	if (i == 0) //ID
            	fields[i].value = trimString(fields[i].value);
        }
        else {   //errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
		errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"<br>";}
    }
    if ( errors.length != 0 ) {
        messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
        return false ;
    }
    return true ;
}

function checkIsValidForProceed()
{
		 var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
 		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")) && (url.indexOf("consentformateditorframeset"))==-1 )
				return true;
		else
				return false;
}


// to open the editor
function openConsentEditor(obj){

		if(obj.value!="" && obj.value=="E") {
			var   bean_id			  =	document.consent_format.bean_id.value;
			var   bean_name			  =	document.consent_format.bean_name.value;
  			var   consent_type		  = document.consent_format.consent_type.value;
 			var   consent_form_id	  = document.consent_format.consent_form_id.value;
			var   consent_form_label  = document.consent_format.Consent_form_label.value;
			var   consent_format	  = document.consent_format.consent_format.value;
			var   indexed			  = document.consent_format.indexed.value;

			//var   referralrow	  = document.getElementById("referralrow").style.display;
			//var   notreferral	  = document.getElementById("notreferral").style.display;
 			if(document.consent_format.effective_status.checked == true){
				document.consent_format.effective_status.value = "E";
			}else{
				document.consent_format.effective_status.value = "D";
			}
			// then change the text area value to null, because will be using the editor.
			document.consent_format.consent_form_text.value	= "";
 			var   effective_status	  = document.consent_format.effective_status.value;
			var	  mode				  = document.consent_format.mode.value;
    		var htmlText = "<html><body><form action='../../eOR/jsp/ConsentFormatEditorFrameSet.jsp' method='post' name='editor_form' id='editor_form'>";
  		 	htmlText +="<input type='hidden' name='consent_type' id='consent_type' value=\""+consent_type+"\">";
			htmlText +="<input type='hidden' name='consent_form_id' id='consent_form_id' value=\""+consent_form_id+"\">";
			htmlText +="<input type='hidden' name='consent_form_label' id='consent_form_label' value=\""+encodeURIComponent(consent_form_label)+"\">";
			htmlText +="<input type='hidden' name='consent_format' id='consent_format' value=\""+consent_format+"\">";
			htmlText +="<input type='hidden' name='effective_status' id='effective_status' value=\""+effective_status+"\">";
			htmlText +="<input type='hidden' name='mode' id='mode' value=\""+mode+"\">";
			htmlText +="<input type='hidden' name='bean_id' id='bean_id' value=\""+bean_id+"\">";
			htmlText +="<input type='hidden' name='bean_name' id='bean_name' value=\""+bean_name+"\">";
			htmlText +="<input type='hidden' name='function_id' id='function_id' value=\""+function_id+"\">";
			htmlText +="<input type='hidden' name='indexed' id='indexed' value=\""+indexed+"\">";
			htmlText +="</form></body></html>";
 			parent.f_query_add_mod.document.body.insertAdjacentHTML('afterbegin',htmlText);
			parent.f_query_add_mod.document.editor_form.submit();
	 	} 
 }
 function storeEditor(){
 	   var formObj			= parent.editor_button.document.editorButtonForm;
	   var localeName=formObj.localeName.value;
  	   var bean_id			= formObj.bean_id.value;
	   var bean_name		= formObj.bean_name.value;

		//var xmlDoc 			= new ActiveXObject( "Microsoft.XMLDom" ) ;
		//var xmlHttp 		= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	   //var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		//IN066781 starts
		if(parent.editor.RTEditor0.document.body != null)
		{
			if(parent.editor.RTEditor0.document.body.firstChild.nodeName == 'ADDRESS')
			{
				while(parent.editor.RTEditor0.document.body.firstChild.innerHTML == '')
				{
					parent.editor.RTEditor0.document.body.removeChild(parent.editor.RTEditor0.document.body.firstChild);
				}
			}
		}
		//IN066781 ends
		xmlStr				= "<root><SEARCH " ;
		xmlStr				+= "html_format=\"" +checkSpl(parent.editor.RTEditor0.document.body.innerHTML)  +"\" ";
		xmlStr 				+=" /></root>" ;
		//alert(xmlStr)
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "ConsentFormatEditorValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&localeName="+localeName, false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval( responseText ) ;

		// Submitting to the consent form
		var htmlText		= "<html><body><form action='../../eOR/jsp/ConsentFormatAddModify.jsp' method='post' name='editor_form' id='editor_form'>";
		htmlText +="<input type='hidden' name='mode' id='mode' value=\""+formObj.mode.value+"\">";
		// editor text no need already set
		htmlText +="<input type='hidden' name='function_id' id='function_id' value=\""+formObj.function_id.value+"\">";
		htmlText +="<input type='hidden' name='consent_type' id='consent_type' value=\""+formObj.consent_type.value+"\">";
		htmlText +="<input type='hidden' name='consent_form_id' id='consent_form_id' value=\""+formObj.consent_form_id.value+"\">";
		htmlText +="<input type='hidden' name='consent_form_label' id='consent_form_label' value=\""+formObj.consent_form_label.value+"\">";
		htmlText +="<input type='hidden' name='consent_format' id='consent_format' value=\""+formObj.consent_format.value+"\">";
		htmlText +="<input type='hidden' name='effective_status' id='effective_status' value=\""+formObj.effective_status.value+"\">";
		htmlText +="<input type='hidden' name='indexed' id='indexed' value=\""+formObj.indexed.value+"\">";
		htmlText +="<input type='hidden' name='test_status' id='test_status' value='test_status'>";
		htmlText +="</form></body></html>";
   		parent.parent.parent.f_query_add_mod.document.body.insertAdjacentHTML('afterbegin',htmlText);
		parent.parent.parent.f_query_add_mod.document.editor_form.submit();
}

async function previewEditor(){

		var bean_id				= parent.editor_button.document.editorButtonForm.bean_id.value;
		var bean_name			= parent.editor_button.document.editorButtonForm.bean_name.value;
		if(parent.editor.RTEditor0.document.body != null)//IN066781
			modifyEmptyTD(parent.editor.RTEditor0.document.body);//IN066781
		
		RTEText					= parent.editor.RTEditor0.document.body.innerHTML;
		//var xmlDoc 				= new ActiveXObject( "Microsoft.XMLDom" ) ;
		//var xmlHttp 			= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
		//var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		xmlStr					= "<root><SEARCH " ;
		xmlStr					+= "html_format=\"" +checkSpl(RTEText)+"\" ";
		xmlStr 			+=" /></root>" ;
	    var	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "ConsentFormatEditorValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name, false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval( responseText ) ;
		if(RTEText!="") {
			var dialogHeight	= '55vh' ;
			var dialogWidth		= '55vw' ;
			var dialogTop		= '10';
			var dialogLeft		= '10' ;
			var title			= '';
			var features		= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';
			var retVals			= await window.showModalDialog("../../eOR/jsp/EditorPreviewFrameSet.jsp?bean_id="+escape(bean_id)+"&bean_name="+escape(bean_name)+"&called_from=CONSENT_FORMAT",arguments,features);
		}
 	}		

function showVarianceLookUp(obj){
  	 showLookUp(obj); //Present in OrCommonFunction.js	
}
function selectformat()
{
    var formobj=document.consent_format
	//alert(formobj.consent_type.value);

	if(formobj.consent_type.value=="C")
	{
		document.getElementById("indexrow").style.display	= 'inline';
	}
	//else if(formobj.consent_type.value=="R" || formobj.consent_type.value=="Z" || formobj.consent_type.value=="N") //IN029935  //IN030473
	else if(formobj.consent_type.value=="R" || formobj.consent_type.value=="Z" || formobj.consent_type.value=="N" || formobj.consent_type.value=="I") //IN030473
	{
		document.getElementById("indexrow").style.display	= 'none';
	}
	
	if(formobj.consent_type.value=="Z")
	{
		//alert("======="+document.getElementById("referralrow").style.display);
		//alert("23232..."+formobj.consent_format.value);
		formobj.consent_format.value="P";
//		if(document.getElementById("referralrow"))
			document.getElementById("referralrow").style.display	= 'inline';
		//document.getElementById("notreferral").style.display='none';
		document.getElementById("indexrow").style.display='none';
		formobj.consent_format.value="P";
			
	}
	//else if (formobj.consent_type.value=="C" || formobj.consent_type.value=="R" || formobj.consent_type.value=="N") //IN029935 //IN030473
	else if (formobj.consent_type.value=="C" || formobj.consent_type.value=="R" || formobj.consent_type.value=="N" || formobj.consent_type.value=="I") //IN030473
	{
		formobj.consent_format.value="E";
		if(document.getElementById("referralrow"))
			document.getElementById("referralrow").style.display	= 'none';
		//document.getElementById("notreferral").style.display='inline';
		//document.getElementById("indexrow").style.display='inline';
	}
}
function selecteditor()
{
	var formobj=document.consent_format
		//alert("in editor...."+formobj.consent_format.value);
		//alert("in editor  consent_type...."+formobj.consent_type.value);
		if ( formobj.consent_type.value=="C" || formobj.consent_type.value=="R" || formobj.consent_type.value=="N") //IN029935
		{	
			formobj.consent_format.value="E";
			if(document.getElementById("referralrow"))
				document.getElementById("referralrow").style.display	= 'none';
			    //alert(document.getElementById("indexrow"));
			   // document.getElementById("indexrow").style.display='inline';
		}
		else if(formobj.consent_type.value=="Z")
		{
			formobj.consent_format.value="P";
			document.getElementById("referralrow").style.display	= 'inline';
			document.getElementById("indexrow").style.display='none';
		}
}
function check()
{
	var formobj=document.consent_format
	if(formobj.consent_format.value=="E")
	{
		document.getElementById("referralrow").style.display	= 'none';
		//document.getElementById("notreferral").style.display='inline';
	}
	else if(formobj.consent_format.value=="P")
	{
		//formobj.consent_type.value="Z"
		document.getElementById("referralrow").style.display	= 'inline';
		//document.getElementById("notreferral").style.display='none';
		document.getElementById("indexrow").style.display='none';
	}
}
//IN066781 starts
function modifyEmptyTD(obj)
{
	var bodyElement = obj.childNodes;
	var i;
	for(i=0;i<bodyElement.length;i++)
	{
		if (bodyElement[i].nodeType === Node.ELEMENT_NODE) {
		var cells = bodyElement[i].getElementsByTagName('td');
		if(cells != null || cells != undefined)
		{
			for(var tdElement = 0;tdElement < cells.length ;tdElement++)
			{
				if(cells[tdElement].innerHTML == '')
				{
					cells[tdElement].innerHTML = '&nbsp;';
				}
			}
		}
	}
}
}
//IN066781 ends


