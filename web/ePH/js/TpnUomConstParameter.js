  //saved on 07/11/2005
var function_id = "PH_TPN_CONST_UOM";
var result		= false;
var message		= "";
var flag		= "";

function create() {
	f_query_add_mod.location.href="../../ePH/jsp/TpnUomConstFrames.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
}

function apply() {
	if ( !checkIsValidForProceed( "TpnUomConstdetails", "apply" ) ) {
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}

	var frmobj	= f_query_add_mod.f_tpn_cons_uom_dtl.document.formTpnUomConstDtls;
	if (makeChanges("Apply", 0)) {
		eval(formApply(frmobj, PH_CONTROLLER));
	}

	if ( message == 'PH_ATLEAST_ONE_SELECTED' )
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage(message,"PH");
	else
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	if( result ) {
		f_query_add_mod.f_tpn_param.location.href="../../ePH/jsp/TpnUomConstParameter.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
		f_query_add_mod.f_tpn_cons_uom_hdr.location.href="../../eCommon/html/blank.html";
		f_query_add_mod.f_tpn_cons_uom_dtl.location.href="../../eCommon/html/blank.html";
	}
	else {
		return false;
	}
}

function reset() {
	if ( checkIsValidForProceed( "TpnUomConstquerycriteria", "reset" ) )
		f_query_add_mod.document.query_form.reset();

	else if ( checkIsValidForProceed( "TpnUomConstaddmodify", "reset" ) ) {
		var frmobj = f_query_add_mod.f_tpn_param.document.formTpnUomConst;
		frmobj.reset();
		clearData(frmobj.ORDER_SRC_LOCN);
		clearData(frmobj.DISPENSE_LOCN);
		frmobj.ORDER_FCY.disabled			= false;
		frmobj.ORDER_SRC_TYPE.disabled		= false;
		frmobj.ORDER_SRC_LOCN.disabled		= false;
		frmobj.PERFORM_FCY.disabled			= false;
		frmobj.DISPENSE_LOCN.disabled		= false;
		f_query_add_mod.f_tpn_param.document.getElementById("DISP_LOCN_DESC").innerText		= "";
		f_query_add_mod.f_tpn_cons_uom_hdr.location.href	="../../eCommon/html/blank.html"
		f_query_add_mod.f_tpn_cons_uom_dtl.location.href	="../../eCommon/html/blank.html"
	}
}

function checkIsValidForProceed( urlName, mode ) {
	var url = f_query_add_mod.location.href;
	if (mode == "reset" && f_query_add_mod.f_tpn_param)
		url = f_query_add_mod.f_tpn_param.location.href;
	else if (mode == "apply" && f_query_add_mod.f_tpn_cons_uom_dtl)
		url = f_query_add_mod.f_tpn_cons_uom_dtl.location.href;

	url = url.toLowerCase();

	if ( (url.indexOf( urlName ) != -1) )
		return true;
	else
		return false;
}

function assignResult( _result, _message, _flag ) {
	result	= _result;
	message	= _message;
	flag	= _flag;
}

function displayLocnType( objval ) {
	var frmobj = document.formTpnUomConst;
	if (objval != '') {
		var locnType = objval.split('|');
		if (locnType[1] == 'P')
			document.getElementById("DISP_LOCN_DESC").innerHTML = "<B>"+getLabel("Common.pharmacy.label","Common")+"</B>";
		else if (locnType[1] == 'C')
			document.getElementById("DISP_LOCN_DESC").innerHTML = "<B>"+getLabel("Common.clinic.label","Common")+"</B>";
		else if (locnType[1] == 'N')
			document.getElementById("DISP_LOCN_DESC").innerHTML = "<B>"+getLabel("Common.nursingUnit.label","Common")+"</B>";

		var ord_fcy_id		= frmobj.ORDER_FCY.value;
		var ord_src_type	= frmobj.ORDER_SRC_TYPE.value;
		var order_src_locn	= frmobj.ORDER_SRC_LOCN.value;
		var perform_fcy_id	= frmobj.PERFORM_FCY.value;
		var disp_locn_code	= locnType[0];

		var errorPage	= "../../eCommon/jsp/MstCodeError.jsp";
		var blankObj 	= null;
		var fields	= new Array(frmobj.ORDER_FCY, frmobj.ORDER_SRC_TYPE, frmobj.ORDER_SRC_LOCN, frmobj.PERFORM_FCY, frmobj.DISPENSE_LOCN);
		var names	= new Array(getLabel("Common.OrderingFacility.label","Common"), getLabel("ePH.OrderingSourceType.label","PH"), getLabel("ePH.OrderingSourceLocation.label","PH"), getLabel("Common.PerformingFacility.label","Common"), getLabel("ePH.DispenseLocation.label","PH") );

		blankObject  = getBlankField( fields, names, parent.parent.messageFrame, errorPage);
		if(blankObject==null) {
			frmobj.ORDER_FCY.disabled					= true;
			frmobj.ORDER_SRC_TYPE.disabled				= true;
			frmobj.ORDER_SRC_LOCN.disabled				= true;
			frmobj.PERFORM_FCY.disabled					= true;
			frmobj.DISPENSE_LOCN.disabled				= true;
			parent.f_tpn_cons_uom_hdr.location.href	="../../ePH/jsp/TpnUomConstButtons.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
			parent.f_tpn_cons_uom_dtl.location.href	="../../ePH/jsp/TpnUomConstDetails.jsp?function_id="+function_id+"&mode="+MODE_INSERT+"&ord_fcy_id="+ord_fcy_id+"&ord_src_type="+ord_src_type+"&order_src_locn="+order_src_locn+"&perform_fcy_id="+perform_fcy_id+"&disp_locn_code="+disp_locn_code+"&jsp_flag=1"+"&firstTime=Y";
			parent.parent.messageFrame.location.href	="../../eCommon/jsp/MstCodeError.jsp";
		}
		else {
			blankObject.focus();
		}
	}
}

function populateData ( obj ) {

	document.getElementById("DISP_LOCN_DESC").innerText = "";
	var ord_src_type = document.formTpnUomConst.ORDER_SRC_TYPE.value;
	if (obj.value != '' && ord_src_type != '') {
		var objname		= obj.name;
		var bean_id		= document.formTpnUomConst.bean_id.value;
		var bean_name	= document.formTpnUomConst.bean_name.value;

		var xmlDoc		= "";
		var xmlHttp		= new XMLHttpRequest();

		xmlStr ="<root><SEARCH ";
		xmlStr += obj.name+"=\""+ checkSpl(obj.value) +"\" ";
		xmlStr +=" /></root>";

		xmlDoc.loadXML( xmlStr );
		if (objname == "ORDER_SRC_TYPE") {
			xmlHttp.open( "POST", "TpnUomConstValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=ORDER_SRC_TYPE" + "&object=" + objname, false );
		}
		else if (objname == "PERFORM_FCY") {
			xmlHttp.open( "POST", "TpnUomConstValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=PERFORM_FCY" + "&ord_src_type=" + ord_src_type + "&object=" + objname, false );
		}

		xmlHttp.send( xmlDoc );
		responseText=xmlHttp.responseText;
		eval( responseText );
	}
	else {
		clearData('document.formTpnUomConst.ORDER_SRC_LOCN');
		clearData('document.formTpnUomConst.DISPENSE_LOCN');
	}
}

function clearData(obj) {
	obj = eval(obj);
	var len = obj.length;
	for (var i=0; i<=len; i++) {
		obj.remove("");
	}
	var opt	= document.createElement('OPTION');
	opt.value =	"";
	opt.text =   "----" +getLabel("Common.defaultSelect.label","PH")+" ----          ";
	obj.add(opt);
}

function addData(code, desc, obj) {
	obj = eval(obj);
	var opt	= eval(document.createElement('OPTION'));
	opt.value =	code;
	opt.text = desc;
	obj.add(opt);
}

function changeCursor(obj) {
	obj.style.cursor = "pointer";
}

function beforePost(xmlStr) {
//	alert(xmlStr);
}

function makeChanges(mode, from) {
	var frmObj = "";
	var locObj = "";
	if (mode == "Apply") {
		frmObj	= f_query_add_mod.f_tpn_cons_uom_dtl.document.formTpnUomConstDtls;
	}
	else {
		frmObj	= parent.f_tpn_cons_uom_dtl.document.formTpnUomConstDtls;
	}
	var totalrecs	= parseInt(frmObj.totalrecs.value);

	var xmlDoc	= "";
	var xmlHttp	= new XMLHttpRequest();
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
			var val = "";
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

			val = checkSpl( val );
			xmlStr+= arrObj[i].name+"=\"" + val + "\" ";
		}
	}
	xmlStr +=" /></root>";

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "TpnUomConstDetails.jsp?function_id="+function_id+"&mode="+MODE_INSERT+"&totalrecs="+totalrecs+"&jsp_flag=3", false );
	xmlHttp.send( xmlDoc );
	responseText=xmlHttp.responseText;
//	alert(responseText);

	var curr_mode = frmObj.jsp_flag.value;

	if (mode == 'Prev')
		parent.f_tpn_cons_uom_dtl.location.href = "../../ePH/jsp/TpnUomConstDetails.jsp?function_id="+function_id+"&mode="+MODE_INSERT+"&from="+from+"&jsp_flag="+curr_mode+"&firstTime=N";
	else if (mode == 'Next')
		parent.f_tpn_cons_uom_dtl.location.href = "../../ePH/jsp/TpnUomConstDetails.jsp?function_id="+function_id+"&mode="+MODE_INSERT+"&from="+from+"&jsp_flag="+curr_mode+"&firstTime=N";
	else if (mode == '1' || mode == '2')
		parent.f_tpn_cons_uom_dtl.location.href = "../../ePH/jsp/TpnUomConstDetails.jsp?function_id="+function_id+"&mode="+MODE_INSERT+"&from="+from+"&jsp_flag="+mode+"&firstTime=N";
	else if (mode == 'Apply')
		return true;
}

function onSelect(mode) {
	var curr_mode = parent.f_tpn_cons_uom_dtl.document.formTpnUomConstDtls.jsp_flag.value;
	if (mode == '1' && mode != curr_mode) {
		document.getElementById("select_tab").className	= "clicked";
		document.getElementById("assoc_tab").className	= "normal";
		makeChanges(mode, 0);
	}
	else if (mode == '2' && mode != curr_mode) {
		document.getElementById("select_tab").className	= "normal";
		document.getElementById("assoc_tab").className	= "clicked";
		makeChanges(mode, 0);
	}
}

function setDBMode(obj, recnum) {
	var dbModeObj	= eval("document.formTpnUomConstDtls.DB_MODE_" + recnum);
	var assocObjval	= eval("document.formTpnUomConstDtls.ASSO_YN_" + recnum +".value");
	if (obj.checked) {
		if (dbModeObj.value == "DN" || dbModeObj.value == "D") {
			dbModeObj.value = "I";
		}
	}
	else {
		if (dbModeObj.value == "I" || dbModeObj.value == "DN") {
			dbModeObj.value = "D";
		}
	}
}
