function create(){
	f_query_add_mod.document.location.href="../../ePH/jsp/BuildMARRulesAddModify.jsp?mode="+MODE_INSERT;
}

function query(){
		f_query_add_mod.location.href="../../ePH/jsp/BuildMARRulesQueryCriteria.jsp?mode="+MODE_MODIFY;
}

function reset() {
	
	var url = f_query_add_mod.location.href;
    url = url.toLowerCase();

    if ( (url.indexOf("buildmarrulesquerycriteria")!=-1) ) {
        f_query_add_mod.document.query_form.reset();
    }
    else if ( (url.indexOf("buildmarrulesaddmodify")!=-1) )
    {
        if(f_query_add_mod.document.MAR_defaulting.mode.value == MODE_INSERT)
        {
            formObj =   f_query_add_mod.document.MAR_defaulting;
		    f_query_add_mod.document.MAR_defaulting.reset();
        }
        else {
		     f_query_add_mod.document.MAR_defaulting.reset();
        }
    }
}

function apply() {
    var formObj =   f_query_add_mod.document.MAR_defaulting;
	if (f_query_add_mod.document.MAR_defaulting!=undefined){
		var mode = formObj.mode.value;
		if( mode == MODE_INSERT ) {
			var fields = new Array ( formObj.APP_PAT_CLASSES,formObj.LOCATION,formObj.PRIORITY,formObj.FORM,formObj.MAR_DEFAULTING);
			var names= new Array (getLabel("Common.ApplicablePatientClass.label","Common"),getLabel("Common.Location.label","Common"), getLabel("Common.priority.label","Common"),getLabel("Common.Form.label","Common"),getLabel("ePH.MARDefaulting.label","ePH"));

			if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
			{
				eval(formApply(formObj,PH_CONTROLLER));
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;	
				if( result1 ) 	{
					 onSuccess();
				 }
			}
		}
		else if( mode == MODE_MODIFY )
		{ 
			var fields = new Array ( formObj.APP_PAT_CLASSES_CODE,formObj.LOCATION_CODE,formObj.PRIORITY_CODE,formObj.FORM_CODE,formObj.MAR_DEFAULTING);
			var names= new Array (getLabel("Common.ApplicablePatientClass.label","Common"),getLabel("Common.Location.label","Common"), getLabel("Common.priority.label","Common"),getLabel("Common.Form.label","Common"),getLabel("ePH.MARDefaulting.label","ePH"));
			if (f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
			{	
				eval(formApply(formObj,PH_CONTROLLER));
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				if( result1 ) 
				{
					//onSuccess();
				}
			}
			
		}
	}
	else{
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
}

function loadLocation(obj)
{
	var formObj=document.MAR_defaulting;
	var selected_pat_class=obj.value;
	var fieldToLoad="LOCATION";
	removeLocationItems();
	removeFormItems();
	
	if(obj.value == ""){
		document.forms[0].reset();
		return false;
	}
	
	var bean_id		= formObj.bean_id.value ;
	var bean_name	= formObj.bean_name.value ;

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr += " pat_class=\""+selected_pat_class+"\"";
	xmlStr += " fieldToLoad=\""+fieldToLoad+"\"";
	xmlStr +=" /></root>";
	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","BuildMARRulesValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +"&APP_PAT_CLASSES="+selected_pat_class+"&fieldToLoad="+fieldToLoad,false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
}

function loadForm(obj)
{

	var formObj=document.MAR_defaulting;
	var selected_pat_class=obj.value;
	var fieldToLoad="FORM";

	removeFormItems();
	
	if(obj.value == ""){
		document.forms[0].reset();
		return false;
	}

	var bean_id		= formObj.bean_id.value ;
	var bean_name	= formObj.bean_name.value ;

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr += " fieldToLoad=\""+fieldToLoad+"\"";
	xmlStr +=" /></root>";
	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","BuildMARRulesValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +"&fieldToLoad="+fieldToLoad,false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
}

function addLocation(value,text)	{

	var elem = document.createElement('OPTION') ;
	elem.value		=  value;		
	elem.text		=  text;		
	document.MAR_defaulting.LOCATION.add(elem);
}

function addForms(value,text)	{

	var elem = document.createElement('OPTION') ;
	elem.value		=  String(value);		
	elem.text		=  String(text);		
	document.MAR_defaulting.FORM.add(elem);
}

function removeLocationItems()
{
	var fieldObj=document.MAR_defaulting.LOCATION;
	var len =fieldObj.options.length; 
	for(var i=0;i<len;i++) {
		fieldObj.remove("LOCATION") ;
	}
	
	var sel = "---"+getLabel("Common.defaultSelect.label","Common")+"---";
	var opt_sel = document.createElement("OPTION") ;
	opt_sel.text = sel ;
	opt_sel.value = "" ;
	fieldObj.add(opt_sel);  
}

function removeFormItems()
{
	var fieldObj=document.MAR_defaulting.FORM;
	var len =fieldObj.options.length; 
	for(var i=0;i<len;i++) {
		fieldObj.remove("FORM") ;
	}
	
	var sel = "---"+getLabel("Common.defaultSelect.label","Common")+"---";
	var opt_sel = document.createElement("OPTION") ;
	opt_sel.text = sel ;
	opt_sel.value = "" ;
	fieldObj.add(opt_sel);  

}

function onSuccess() {
	   f_query_add_mod.document.MAR_defaulting.reset();
}
 
function assignResult( _result, _message, _flag, _invalidCode ) {
    result1 = _result ;
    message  = _message ;
    flag = _flag ;
    invalidCode = _invalidCode ;
}


function Modify(obj) {
	var pat_class		= obj.cells[0].innerText;
	var location_desc	= escape(obj.cells[1].innerText);
	var form_desc		= escape(obj.cells[2].innerText);
	var priority		= obj.cells[3].innerText;
	var mar_defaulting	= obj.cells[4].innerText;
	var form_code	= String(obj.cells[5].textContent);
	var location_code	= String(obj.cells[6].textContent);
	document.location.href="../../ePH/jsp/BuildMARRulesAddModify.jsp?mode="+MODE_MODIFY+"&APP_PAT_CLASSES="+pat_class+"&LOCATION_DESC="+location_desc+"&PRIORITY="+priority+"&FORM_DESC="+form_desc+"&MAR_DEFAULTING="+mar_defaulting+"&LOCATION_CODE="+location_code+"&FORM_CODE="+form_code;//+"&MAR_DEFAULTING_CODE="+mar_defaulting_code;
}
