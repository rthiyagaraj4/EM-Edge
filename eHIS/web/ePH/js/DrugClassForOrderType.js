  var function_id		= "PH_DRUG_CLASS_ORDER_TYPE" ;
var result			= false ;
var message			= "" ;
var flag 			= "" ;

function create() {
	message = "" ;
	result	= false ;
	f_query_add_mod.location.href="../../ePH/jsp/DrugClassForOrderTypeAddModify.jsp?function_id="+function_id+"&mode="+MODE_INSERT+"&hdn_flg=0";
}

function query() {
	message = "" ;
	result	= false ;
	f_query_add_mod.location.href="../../ePH/jsp/DrugClassForOrderTypeQueryCriteria.jsp?function_id="+function_id ;
}

function apply() {
	if ( !checkIsValidForProceed( "drugclassforordertypeaddmodify" ) ) {
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}

	var status	= f_query_add_mod.document.formDrugClassForOrderType.apllystatus.value;
	var start	= 0;
	var totrecs = 0;

	if ( status == 'true' ) {
		start	= f_query_add_mod.document.formDrugClassForOrderType.begin.value;
		totrecs = f_query_add_mod.document.formDrugClassForOrderType.totrecs.value;

		makeChanges('apply', start, totrecs, totrecs);
		eval( formApply( f_query_add_mod.document.formDrugClassForOrderType, PH_CONTROLLER ) ) ;
	}
	
	if ( message == 'ATLEAST_ONE_SELECTED' )
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage(message,"Common");
	else
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	if( result ) {
		f_query_add_mod.location.href="../../eCommon/html/blank.html";
	}
	else {
		return false;
	}
}

function reset() {
	var status = "";

	if ( checkIsValidForProceed( "drugclassforordertypeaddmodify" ) ) {
		status = f_query_add_mod.document.formDrugClassForOrderType.apllystatus.value;
	}

	if ( checkIsValidForProceed( "drugclassforordertypequerycriteria" ) ) {
		f_query_add_mod.document.query_form.reset();
	}
	if ( checkIsValidForProceed( "drugclassforordertypeaddmodify" )  && status == 'true' ) {
		var flag = f_query_add_mod.document.formDrugClassForOrderType.hdn_flag.value;
		var begin = f_query_add_mod.document.formDrugClassForOrderType.begin.value;
		f_query_add_mod.location.href="../../ePH/jsp/DrugClassForOrderTypeAddModify.jsp?function_id="+function_id+"&hdn_flg="+flag+"&from="+begin+"&rstflag=1";
	}
}

function assignResult( _result, _message, _flag ) {
	result	= _result ;
	message	= _message ;
	flag	= _flag ;
}

/*function lockKey() {
	if(event.keyCode == 93)
		alert("Welcome to eHIS");
} dt:14/9/09*/
async function callOrderType(ordertypecode) {
	//alert("ordertypecode--------------->"+ordertypecode)
	var dialogHeight	= "70vh" ;
	var dialogWidth		= "60vw" ;
	var dialogTop		= "84" ;
	var dialogLeft		= "155" ;
	var center			= "0" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + ";dialogLeft:" + dialogLeft;
	var arguments		= "" ;
	retVal				= await top.window.showModalDialog( "../../ePH/jsp/DrugClassForOrderTypeLookup.jsp?code="+ordertypecode, arguments, features );
	//alert("retVal--------->"+retVal)
}

function changeCursor(obj) {
	obj.style.cursor = "hand" ;
}

function comboset(obj, cmbname, setcmbvalue) {
	var tempobj = eval(obj + cmbname);
	for ( i=0; i<=(tempobj.length-1); i++ ) {
		if (tempobj[i].value == setcmbvalue) {
			tempobj.selectedIndex = i;
			break;
		}
	}
}

function onSelect(flgval, start, count, totrecs) {
	//alert("flgval---------->"+flgval)
	//alert("flgval---------->"+start)
	//alert("flgval---------->"+count)
	//alert("flgval---------->"+totrecs)
	var acthdnval = parent.f_query_add_mod.document.formDrugClassForOrderType.hdn_flag.value;
	if (acthdnval != 0 && acthdnval != flgval)
		makeChanges('select', start, totrecs, totrecs);
	else if (acthdnval != flgval)
		location.href="../../ePH/jsp/DrugClassForOrderTypeAddModify.jsp?function_id="+function_id+"&hdn_flg="+flgval+"&firsttime=true";
}

function onAssoc(flgval, start, count, totrecs) {
	var acthdnval = parent.f_query_add_mod.document.formDrugClassForOrderType.hdn_flag.value;
	if (acthdnval != 0 && acthdnval != flgval) {
		makeChanges('assoc', start, totrecs, totrecs);
	}
	else if (acthdnval != flgval)
		location.href="../../ePH/jsp/DrugClassForOrderTypeAddModify.jsp?function_id="+function_id+"&hdn_flg="+flgval+"&firsttime=true";
}

function makeChanges(mode, start, count, totrecs) {
	//alert("totrecs----------->"+totrecs)
	//alert('MODE : ' + mode + '\n' + 'START : ' +start + '\n' + 'COUNT : ' + count + '\n' + 'TOTRECS : ' + totrecs + '\n' + 'BEGINVAL : ' + beginval);
	var frmObj			= "" ;
	var ordtypecode		= "ORDER_TYPE_";
	var ordtypedesc		= "ORDER_TYPE_NAME_";
	var cmbname			= "DRUG_CLASS_";
	var avlindb			= "AVLINDB_";
	var dbmode			= "DB_MODE_";
	var paramstring 	= "";
	var flag			= "";

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;

	if (mode != 'apply') {
		frmObj = "parent.f_query_add_mod.document.formDrugClassForOrderType.";
		flag = parent.f_query_add_mod.document.formDrugClassForOrderType.hdn_flag.value;
	}
	else {
		frmObj = "f_query_add_mod.document.formDrugClassForOrderType.";
		flag = f_query_add_mod.document.formDrugClassForOrderType.hdn_flag.value;
	}
	if (mode == 'select')
		flag = 1;
	if (mode == 'assoc')
		flag = 2;

	var startCount = eval(parseInt(start) + parseInt(count) ) ;
	for (var itemnum = start; itemnum < startCount; itemnum++) {
		if ( itemnum < totrecs ) {
			tempobj = eval(frmObj + ordtypecode + itemnum);
			tempobj1 = eval(frmObj + ordtypedesc + itemnum);
			tempobj2 = eval(frmObj + cmbname + itemnum);
			tempobj3 = eval(frmObj + avlindb + itemnum);
			tempobj4 = eval(frmObj + dbmode + itemnum);

			if (tempobj && tempobj1 && tempobj2) {
				xmlStr += tempobj.name +"=\""+ tempobj.value +"\" " ;
				xmlStr += tempobj1.name +"=\""+ tempobj1.value +"\" " ;
				xmlStr += tempobj2.name +"=\""+ tempobj2.value +"\" " ;
				xmlStr += tempobj3.name +"=\""+ tempobj3.value +"\" " ;
				xmlStr += tempobj4.name +"=\""+ tempobj4.value +"\" " ;
				//alert(tempobj.name + " : " + tempobj.value + "\n" + tempobj1.name + " : " + tempobj1.value + "\n" +tempobj2.name + " : " + tempobj2.value + "\n" +tempobj3.name + " : " + tempobj3.value + "\n" +tempobj4.name + " : " + tempobj4.value);
			}
		}
		else break;
	}
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "DrugClassForOrderTypeAddModify.jsp?function_id="+function_id+"&hdn_flg=3&start="+start+"&numrecs="+startCount, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;

	var orgcnt = "";
	var acthdnval = "";
	if (mode != 'apply') {
		orgcnt = parent.f_query_add_mod.document.formDrugClassForOrderType.actualcnt.value;
		acthdnval = parent.f_query_add_mod.document.formDrugClassForOrderType.hdn_flag.value;
	}

	if (mode == 'next') {
		var nextfrom = 0;
		if (acthdnval == 2)
			nextfrom = parent.f_query_add_mod.document.formDrugClassForOrderType.from.value;
		else
			nextfrom = start+count;
		var beginval = parent.f_query_add_mod.document.formDrugClassForOrderType.begin.value;

		parent.f_query_add_mod.location.href="../../ePH/jsp/DrugClassForOrderTypeAddModify.jsp?function_id="+function_id+"&from="+nextfrom+"&hdn_flg="+flag+"&orgcnt="+orgcnt+"&beginval="+beginval;
	}
	else if (mode == 'prev') {
		var prevfrom = 0;
		if (acthdnval == 2) {
			prevfrom = start-count;
		}
		else
			prevfrom = start-count;
		if (prevfrom < 0)
			prevfrom = 0;
		parent.f_query_add_mod.location.href="../../ePH/jsp/DrugClassForOrderTypeAddModify.jsp?function_id="+function_id+"&from="+prevfrom+"&hdn_flg="+flag+"&prevflg=1";
	}
	else if (mode == 'assoc' || mode == 'select') {
		parent.f_query_add_mod.location.href="../../ePH/jsp/DrugClassForOrderTypeAddModify.jsp?function_id="+function_id+"&from=0&hdn_flg="+flag;
	}
	else if (mode == 'apply') {
		return true;
	}
}

function setIMDmode(val, itemnum) {
	var orgdrgclass = "parent.f_query_add_mod.document.formDrugClassForOrderType.ORIGINAL_VAL_"
	var avlindb		= "parent.f_query_add_mod.document.formDrugClassForOrderType.AVLINDB_";
	var dbmode		= "parent.f_query_add_mod.document.formDrugClassForOrderType.DB_MODE_";
	var tempobj		= eval(orgdrgclass + itemnum);
	var tempobj1	= eval(avlindb + itemnum);
	var tempobj2	= eval(dbmode + itemnum);

	if ( tempobj.value == '~' && (val == 'G' || val == 'N' || val == 'C') && tempobj1.value == 'N')
		tempobj2.value = "I";
	if ( tempobj.value == '~' && (val == 'G' || val == 'N' || val == 'C') && tempobj1.value == 'Y')
		tempobj2.value = "M";

	if ( (tempobj.value == 'G' || tempobj.value == 'N' || tempobj.value == 'C') && val == "~" && tempobj1.value == 'Y')
		tempobj2.value = "D";
	if ( (tempobj.value == 'G' || tempobj.value == 'N' || tempobj.value == 'C') && val == "~" && tempobj1.value == 'N')
		tempobj2.value = "DN";

	if ( (tempobj.value == 'G' || tempobj.value == 'N' || tempobj.value == 'C') && (val == 'G' || val == 'N' || val == 'C') && tempobj1.value == 'N' )
		tempobj2.value = "I";
	if ( (tempobj.value == 'G' || tempobj.value == 'N' || tempobj.value == 'C') && (val == 'G' || val == 'N' || val == 'C') && tempobj1.value == 'Y' )
		tempobj2.value = "M";

	if ( tempobj.value == val )
		tempobj2.value = "DN";
}

function checkIsValidForProceed( urlName ) {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();

	if ( (url.indexOf( urlName ) != -1) )
		return true;
	else
		return false;
}
