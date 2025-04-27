  var function_id = "PH_WS_TOKEN_SERIES" ;
var result = false ;
var message = "" ;
var flag = "" ;

function create() {
	f_query_add_mod.location.href="../../ePH/jsp/WsTokenSeriesFrames.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
}

function query() {
	f_query_add_mod.location.href="../../ePH/jsp/WsTokenSeriesQueryCriteria.jsp?function_id="+function_id ;
}

function apply() {
	if ( !checkIsValidForProceed( "wstokenseriesdetails", "apply" ) ) {
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}
	var formobj	= f_query_add_mod.ws_ts_header.document.formWsTokenSeries;
	var st= formobj.WS_LOCN.value ;
  	
	if(st=='')	{
		var mess=getMessage("PH_WORK_STATION_BLANK","PH");
		 messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+mess;
     	return false;
		}
	var frmobj	= f_query_add_mod.ws_ts_detail.document.formWsTokenSeriesDtls;
	if (makeChanges("Apply", 0)) {
	//alert(formApply( frmobj, PH_CONTROLLER ));
	
		eval( formApply( frmobj, PH_CONTROLLER ) ) ;
	}

	if ( message == 'PH_ATLEAST_ONE_SELECTED' )
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage(message,"PH");
	else
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	if( result ) {
		f_query_add_mod.ws_ts_header.location.href="../../ePH/jsp/WsTokenSeriesAddModify.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
		f_query_add_mod.ws_ts_button.location.href="../../eCommon/html/blank.html";
		f_query_add_mod.ws_ts_detail.location.href="../../eCommon/html/blank.html";
	}
	else {
		return false;
	}
}

function reset() {
	if ( checkIsValidForProceed( "wstokenseriesquerycriteria", "reset" ) )
		f_query_add_mod.document.query_form.reset();

	else if ( checkIsValidForProceed( "wstokenseriesaddmodify", "reset" ) ) {
		var frmobj = f_query_add_mod.ws_ts_header.document.formWsTokenSeries;
		frmobj.reset();
		frmobj.DISP_LOCN.disabled = false ;
		f_query_add_mod.ws_ts_button.location.href	="../../eCommon/html/blank.html"
		f_query_add_mod.ws_ts_detail.location.href	="../../eCommon/html/blank.html"
	}
}

function checkIsValidForProceed( urlName, mode ) {
	var url = f_query_add_mod.location.href;
	if (mode == "reset" && f_query_add_mod.ws_ts_header)
		url = f_query_add_mod.ws_ts_header.location.href;
	else if (mode == "apply" && f_query_add_mod.ws_ts_detail)
		url = f_query_add_mod.ws_ts_detail.location.href;

	url = url.toLowerCase();

	if ( (url.indexOf( urlName ) != -1) )
		return true;
	else
		return false;
}

function assignResult( _result, _message, _flag ) {
	result	= _result ;
	message	= _message ;
	flag	= _flag ;
}

function displayWorkStations( objval ) {
	var frmobj = document.formWsTokenSeries;
	if (objval != '') {	
		var bean_id = document.formWsTokenSeries.bean_id.value ;
		var bean_name = document.formWsTokenSeries.bean_name.value ;		
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;		
		xmlStr ="<root><SEARCH " ;
		xmlStr += "DISP_LOCN=\""+ checkSpl(objval) +"\" " ;
		xmlStr +=" /></root>" ;		
		//xmlDoc.loadXML( xmlStr );
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		//alert(objval);
		//parent.location.href	="../../ePH/jsp/WsTokenValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&DISP_LOCN="+objval;
		xmlHttp.open( "POST", "WsTokenValidate.jsp?func_mode=validate_ws&bean_id=" + bean_id + "&bean_name=" + bean_name + "&DISP_LOCN="+objval, false ) ;
		xmlHttp.send( xmlDoc );
		
		//alert("before"+xmlHttp.responseText);
		eval(xmlHttp.responseText);
		//alert("after");
		
	}
}

function displayTokens( objval ) {
	var frmobj = document.formWsTokenSeries;
	if (objval != '') {	
	frmobj.DISP_LOCN.disabled				= true ;
	var loc = frmobj.DISP_LOCN;
	//	parent.ws_ts_button.location.href	="../../ePH/jsp/WsTokenSeriesButtons.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
		parent.ws_ts_detail.location.href	="../../ePH/jsp/WsTokenSeriesDetails.jsp?function_id="+function_id+"&mode="+MODE_INSERT+"&locn_code="+loc.value+"&ws_st="+objval+"&jsp_flag=1"+"&firstTime=Y";
		parent.parent.messageFrame.location.href	="../../eCommon/jsp/MstCodeError.jsp";
	}
}
function addToWorkStationRelated(str1,str2)	{

	//alert("str1---"+str1);
	//alert("str2----"+str2);
	var formObj = document.formWsTokenSeries;		
	var element1 = document.createElement('OPTION') ;		
	element1.value		=  str1 ;		
	element1.text		=  str2 ;		
	formObj.WS_LOCN.add(element1);
		

}
function changeCursor(obj) {
	obj.style.cursor = "hand" ;
}

function makeChanges(mode, from) {
	var frmObj = "";
	var locObj = "";
	if (mode == "Apply") {
		frmObj	= f_query_add_mod.ws_ts_detail.document.formWsTokenSeriesDtls;
	}
	else {
		frmObj	= parent.ws_ts_detail.document.formWsTokenSeriesDtls;
	}
	var totalrecs	= parseInt(frmObj.totalrecs.value);
	var locnCode = frmObj.locn_code.value;
	var ws_st = frmObj.ws_st.value;
	//var xmlDoc	= new ActiveXObject("Microsoft.XMLDom");
	//var xmlHttp	= new ActiveXObject("Microsoft.XMLHTTP");
	
	var xmlDoc	= "";
	var xmlHttp	=new XMLHttpRequest();
	var arrObj	= frmObj.elements;

	var frmObjs = new Array();
	if(frmObj.name == null)
		frmObjs = frmObj
	else frmObjs[0] = frmObj

	var xmlStr ="<root><SEARCH ";

	for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
		frmObj = frmObjs[frmCount]
		var arrObj = frmObj.elements;

		for(var i=0;i<arrObj.length;i++) {
			var val = "" ;
			if(arrObj[i].type == "checkbox") {
				if(arrObj[i].checked) {
					arrObj[i].value="Y";
					val = arrObj[i].value;
				}
				else {
					arrObj[i].value="N";
					val = arrObj[i].value;
				}
			}
			else if(arrObj[i].type == "radio") {
				if(arrObj[i].checked)
					val = arrObj[i].value;
			}
			else if(arrObj[i].type == "select-multiple" ) {
				for(var j=0; j<arrObj[i].options.length; j++) {
					if(arrObj[i].options[j].selected)
						val+=arrObj[i].options[j].value +"~";
				}
				val= val.substring(0,val.lastIndexOf('~'));
			}
			else
				val = arrObj[i].value;
//alert("Val>>>"+val);
			val = checkSpl( val ) ;
			xmlStr+= arrObj[i].name+"=\"" + val + "\" " ;
		}
	}
	xmlStr +=" /></root>";

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	//alert(xmlStr);
	xmlHttp.open( "POST", "WsTokenSeriesDetails.jsp?function_id="+function_id+"&mode="+MODE_INSERT+"&totalrecs="+totalrecs+"&jsp_flag=3&locn_code="+locnCode+"&ws_st="+ws_st, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);

	var curr_mode = frmObj.jsp_flag.value;

	if (mode == 'Prev')
		parent.ws_ts_detail.location.href = "../../ePH/jsp/WsTokenSeriesDetails.jsp?function_id="+function_id+"&mode="+MODE_INSERT+"&from="+from+"&jsp_flag="+curr_mode+"&firstTime=N&locn_code="+locnCode+"&ws_st="+ws_st;
	else if (mode == 'Next')
		parent.ws_ts_detail.location.href = "../../ePH/jsp/WsTokenSeriesDetails.jsp?function_id="+function_id+"&mode="+MODE_INSERT+"&from="+from+"&jsp_flag="+curr_mode+"&firstTime=N&locn_code="+locnCode+"&ws_st="+ws_st;
	else if (mode == '1' || mode == '2')
		parent.ws_ts_detail.location.href = "../../ePH/jsp/WsTokenSeriesDetails.jsp?function_id="+function_id+"&mode="+MODE_INSERT+"&from="+from+"&jsp_flag="+mode+"&firstTime=N&locn_code="+locnCode+"&ws_st="+ws_st;
	else if (mode == 'Apply')
		return true;
}

function onSelect(mode) {
	var curr_mode = parent.ws_ts_detail.document.formWsTokenSeriesDtls.jsp_flag.value;
	if (mode == '1' && mode != curr_mode) {
		document.getElementById('select_tab').className	= "clicked";
		document.getElementById('assoc_tab').className	= "normal";
		makeChanges(mode, 0);
	}
	else if (mode == '2' && mode != curr_mode) {
		document.getElementById('select_tab').className	= "normal";
		document.getElementById('assoc_tab').className	= "clicked";
		makeChanges(mode, 0);
	}
}

function setDBMode(objval, recnum) {
	var dbModeObj	= eval("document.formWsTokenSeriesDtls.DB_MODE_" + recnum);
	var assocObjval	= eval("document.formWsTokenSeriesDtls.ASSO_YN_" + recnum +".value");
	if (assocObjval == "Y") {
		if (objval == "#~" && dbModeObj) {
			dbModeObj.value = "D";
		}
		else {
			dbModeObj.value = "M";
		}
	}
	else if (assocObjval == "N") {
		if (objval != "#~") {
			dbModeObj.value = "I";
		}
		else {
			dbModeObj.value = "D";
		}
	}
}

/*
function beforePost(xmlStr) {
	alert(xmlStr);
}
*/

function alertmessage(){
   alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
   parent.parent.f_query_add_mod.ws_ts_header.document.formWsTokenSeries.DISP_LOCN.disabled= false ;
}

function updateTempAssoDatas(frmObj,obj, index){
	
	var frmObj = frmObj;
	var bean_id = frmObj.bean_id.value;
	var bean_name = frmObj.bean_name.value;
	var tad_checked = ""; 
	if(obj.checked == true){
		tad_checked = "yes";
		eval("frmObj.default_"+index).disabled = false;
	}
	else if(obj.checked == false){
		tad_checked = "no";
		eval("frmObj.default_"+index).checked = false;
		eval("frmObj.default_"+index).disabled = true;
	}
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	
	xmlStr += " token_series =\""+obj.value+"\"";
	xmlStr += " tad_chkd =\""+tad_checked+"\"";
	xmlStr +=" /></root>";

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","WsTokenValidate.jsp?func_mode=validate_checked_items&bean_id=" + bean_id + "&bean_name=" + bean_name,false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
	//parent.frames[0].location.href="../../ePH/jsp/DrugMasterValidation.jsp?func_mode=sliding_scale&template_id="+obj.value+"&sld_chkd="+sld_chkd;
}

function unCheckOthers(frmObj,start, end, objno){
	var bean_id = frmObj.bean_id.value;
	var bean_name = frmObj.bean_name.value;
	for(i=parseInt(start); i<parseInt(end); i+=2)	{
		if(i!=objno){
			if(eval("frmObj.default_"+objno).checked==true){
				eval("frmObj.default_"+i).checked=false;
			}
		}
	}
				
    var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr += " defaultChk =\""+eval("frmObj.default_"+objno).checked+"\"";
	xmlStr += " code =\""+eval("frmObj.TS_CODE_"+objno).value+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","WsTokenValidate.jsp?func_mode=validate_default_check&bean_id=" + bean_id + "&bean_name=" + bean_name,false);
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
}
