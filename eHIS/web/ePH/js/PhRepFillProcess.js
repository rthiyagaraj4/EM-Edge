  //saved on 02.11.2005
function run() {
	
	var frmObject = searchFrame.document.formPhRepFillProcess;


	
	if(searchFrame.document.formPhRepFillProcess) {
		var fields= new Array (frmObject.p_fill_proc_dt1, frmObject.p_fill_proc_ty, frmObject.p_fill_proc_id);
		var names= new Array (getLabel("ePH.FillProcessDate.label","PH"),getLabel("ePH.FillProcessType.label","PH"),getLabel("ePH.FillProcessID.label","PH"));
		
		if(checkFields(fields,names,messageFrame)) {
				frmObject.p_fill_proc_dt.value = convertDate(frmObject.p_fill_proc_dt1.value,'DMY',frmObject.locale.value,'en');
			if(CheckString(getLabel("Common.nursingUnit.label","Common"), searchFrame.document.formPhRepFillProcess.p_fr_nurs_unit, 
				searchFrame.document.formPhRepFillProcess.p_to_nurs_unit, messageFrame))
				{
				searchFrame.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
				searchFrame.document.forms[0].target="messageFrame";
				searchFrame.document.formPhRepFillProcess.submit();
				}

		}
	}
}


async function searchCode( target ) {
	/*if(target==document.formPhRepFillProcess.p_fr_nurs_unit)
		document.formPhRepFillProcess.p_fr_nurs_unit.value="";
	else
		document.formPhRepFillProcess.p_to_nurs_unit.value="";*/
	target.value="";
	if(document.formPhRepFillProcess.p_fill_proc_id.value!=""){
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
   	var ordering_facility_id = document.formPhRepFillProcess.p_ord_facility_id.options[document.formPhRepFillProcess.p_ord_facility_id.selectedIndex].value;
		
	dataNameArray[0]   = "FACILITY_ID" ;
	dataValueArray[0]  = ordering_facility_id;
	dataTypeArray[0]   = STRING ;


    dataNameArray[1] = "FILL_PROC_ID" ;
	dataValueArray[1] = parseInt(document.formPhRepFillProcess.p_fill_proc_id.value);
	dataTypeArray[1] = INT ;
	var language_id=document.formPhRepFillProcess.locale.value;
	
	
	argumentArray[0] = document.getElementById("SQL_PH_REPORTS_NURSUNIT_LOOKUP").value+"'"+language_id+"'";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "3,4";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;
	argumentArray[7] = CODE_DESC ;
	retArray = await CommonLookup( getLabel("Common.nursingUnit.label","Common"), argumentArray );
	var ret1=unescape(retArray);
 	arr=ret1.split(",");
	if(retArray != null && retArray != "" ) {
		target.value = arr[0];	/* if code need to be returned */
		target.focus();
	}
	}
	else
		checkField(document.formPhRepFillProcess.p_fill_proc_id,getLabel("ePH.FillProcessID.label","PH"));
}
function clearTextFlds(){
	document.formPhRepFillProcess.p_fr_nurs_unit.value="";
	document.formPhRepFillProcess.p_to_nurs_unit.value="";
}
function reset() {
	searchFrame.formPhRepFillProcess.reset();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}


function validateProcessDt(obj){
	var from = obj;
	var to = document.forms[0].sys_dt;

	var flag = ValidateDateTime(from ,to)
	if(!flag){
		alert(getMessage(" !!! ...Cannot be grater than sysdate","Common"));
		obj.focus();
		obj.select();
	}
}

function fillComboOptions(obj) {
	
	document.formPhRepFillProcess.p_fr_nurs_unit.value="";
	document.formPhRepFillProcess.p_to_nurs_unit.value="";
	var formObjectHeader    = document.formPhRepFillProcess;
	if(formObjectHeader.p_fill_proc_ty.value != "" && formObjectHeader.p_fill_proc_dt1.value != "" ){
		var  xmlAppend = "";
        var p_fill_proc_dt ="";
		var bean_id				= formObjectHeader.ph_bean_id.value ;
		var bean_name			= formObjectHeader.ph_bean_name.value ;
		var p_fill_proc_ty		= formObjectHeader.p_fill_proc_ty.value;
		p_fill_proc_dt 		= formObjectHeader.p_fill_proc_dt1.value;
        //alert("p_fill_proc_dt-------before date---->"+p_fill_proc_dt);
        var locale = formObjectHeader.locale.value;
		p_fill_proc_dt = convertDate(p_fill_proc_dt,"DMY",locale); 
		//alert("p_fill_proc_dt1---after--->"+p_fill_proc_dt);
 		removeOptions(formObjectHeader ,formObjectHeader.p_fill_proc_id);
		
		xmlAppend += "p_fill_proc_ty"+"=\""+p_fill_proc_ty+"\" " ;
		xmlAppend += "p_fill_proc_dt"+"=\""+p_fill_proc_dt+"\" " ;
		xmlAppend += "bean_id"+"=\""+bean_id+"\" " ;
		xmlAppend += "bean_name"+"=\""+bean_name+"\" " ;

		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;
		xmlStr =xmlStr + xmlAppend ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "FillProcessParamComboFill.jsp",false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		//alert(responseText);
		eval(responseText ) ;
	}
	else{
		removeOptions(formObjectHeader,formObjectHeader.p_fill_proc_id);
	}
}

function removeOptions()	{
var len =document.formPhRepFillProcess.p_fill_proc_id.options.length;
	for(var i=0;i<len;i++) {
		document.formPhRepFillProcess.p_fill_proc_id.remove("p_fill_proc_id") ;
	}


	var tp = "---"+getLabel("Common.defaultSelect.label","Common")+"---";
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	document.formPhRepFillProcess.p_fill_proc_id.add(opt);
}

function addList(desc)	{ 
	var element = document.createElement('OPTION') ;
	element.value		=  desc ;
	element.text		= desc ;
	document.formPhRepFillProcess.p_fill_proc_id.add(element);
}


// the below method is used for leap year calculation
function CheckDateT(obj){
	var locale=document.formPhRepFillProcess.p_language_id.value;
	if(obj.value!=""){
		if(!validDate(obj.value, 'DMY',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			obj.select();
			obj.focus();
			return false;
		}
	}
	else{
		obj.value=convertDate(obj,'DMY',locale,'en');
	}
}
