async function callPatientSearch_report(target)
{

	var patient_id	=	document.formPhReppicklistProcess.patient_id;
	var retun_value =	"";
	return_value	=	await PatientSearch();
	if(return_value!=null)
	{
		patient_id.value	=	return_value;
	}
	else
	{
		patient_id.value	=	"";
	}
}


function run() {
	var frmObject = searchFrame.document.formPhReppicklistProcess;
	var p_facility_id = frmObject.p_ord_facility_id.value;
	var p_language_id = frmObject.p_language_id.value;
	var p_module_id = frmObject.p_module_id.value;
	var p_report_id = frmObject.p_report_id.value;
	var p_proc_date = frmObject.p_proc_date.value;
	var p_patient_id = frmObject.p_patient_id.value;
	var p_pick_list_yn=frmObject.p_pick_list_yn.value;
	//var p_ord_facility_id = frmObject.p_ord_facility_id.value;
	var p_locncode = frmObject.p_locncode.value;
	var p_nurs_unit_code = frmObject.p_nurs_unit_code.value;
	if(searchFrame.document.formPhReppicklistProcess) {
		var fields= new Array (frmObject.p_proc_date, frmObject.p_locncode, frmObject.p_fr_nurs_unit);
		var names= new Array (getLabel("ePH.PickListProccessDate.label","PH"),getLabel("ePH.DispenseLocation.label","PH"),getLabel("Common.nursingUnit.label","PH"));
		if(checkFields(fields,names,messageFrame)) {
				frmObject.p_fill_proc_dt.value = convertDate(frmObject.p_proc_date.value,'DMY',frmObject.locale.value,'en');
			//	searchFrame.document.formPhReppicklistProcess.submit();
				frmObject.action = "../../eCommon/jsp/report_options.jsp?p_facility_id="+p_facility_id+"&p_language_id="+p_language_id+"&p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&p_proc_date="+p_proc_date+"&p_patient_id="+p_patient_id+"&p_locncode="+p_locncode+"&p_nurs_unit_code="+p_nurs_unit_code+"&p_pick_list_yn="+p_pick_list_yn;
			//alert("p_facility_id="+p_facility_id+"&p_language_id="+p_language_id+"&p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&p_proc_date="+p_proc_date+"&p_patient_id="+p_patient_id+"&p_locncode="+p_locncode+"&p_nurs_unit_code="+p_nurs_unit_code+"&p_pick_list_yn="+p_pick_list_yn);
				frmObject.submit();
				
		}
	}
}


async function searchCode( target ) {
	
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
   	var ordering_facility_id = document.formPhReppicklistProcess.p_ord_facility_id.options[document.formPhReppicklistProcess.p_ord_facility_id.selectedIndex].value;		
	dataNameArray[0]   = "FACILITY_ID" ;
	dataValueArray[0]  = ordering_facility_id;
	dataTypeArray[0]   = STRING ;
	var sql="SELECT A.NURSING_UNIT_CODE code,SHORT_DESC description FROM IP_NURSING_UNIT_LANG_VW A WHERE  A.FACILITY_ID LIKE ? AND upper(NURSING_UNIT_CODE) LIKE upper(?) AND upper(SHORT_DESC )LIKE upper(?) AND EFF_STATUS='E' and a.language_id=";
	var language_id=document.formPhReppicklistProcess.locale.value;
	argumentArray[0]   = sql+"'"+language_id+"' order by code";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,3";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	retVal=await CommonLookup(getLabel("Common.NursingUnitSearch.label","Common"), argumentArray );
	if(retVal != null && retVal != "" ) {
    var ret1=unescape(retVal);
                    arr=ret1.split(",");
		document.formPhReppicklistProcess.p_nurs_unit_code.value=arr[0];
		target.value = arr[1];
		target.focus();
	}		
}

function clearTextFlds(){
	document.formPhReppicklistProcess.p_fr_nurs_unit.value="";
	document.formPhReppicklistProcess.p_to_nurs_unit.value="";
}

function reset() {
	searchFrame.formPhReppicklistProcess.reset();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

function fillComboOptions(obj) {
	
	document.formPhReppicklistProcess.p_fr_nurs_unit.value="";
	document.formPhReppicklistProcess.p_to_nurs_unit.value="";
	var formObjectHeader    = document.formPhReppicklistProcess;
	if(formObjectHeader.p_fill_proc_ty.value != "" && formObjectHeader.p_proc_date.value != "" ){
		var  xmlAppend = "";
        var p_fill_proc_dt ="";
		var bean_id				= formObjectHeader.ph_bean_id.value ;
		var bean_name			= formObjectHeader.ph_bean_name.value ;
		var p_fill_proc_ty		= formObjectHeader.p_fill_proc_ty.value;
		p_fill_proc_dt 		= formObjectHeader.p_proc_date.value;
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
var len =document.formPhReppicklistProcess.p_fill_proc_id.options.length;
	for(var i=0;i<len;i++) {
		document.formPhReppicklistProcess.p_fill_proc_id.remove("p_fill_proc_id") ;
	}


	var tp = "---"+getLabel("Common.defaultSelect.label","Common")+"---";
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	document.formPhReppicklistProcess.p_fill_proc_id.add(opt);
}


function addList(desc)	{ 
	var element = document.createElement('OPTION') ;
	element.value		=  desc ;
	element.text		= desc ;
	document.formPhReppicklistProcess.p_fill_proc_id.add(element);
}


function CheckDateT(obj){
	var locale=document.formPhReppicklistProcess.p_language_id.value;
	if(obj.value!=""){
		if(!validDate(obj.value, 'DMY',locale)){
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			//obj.select();
			//obj.focus();
			return false;
		}
	}
	else{
		obj.value=convertDate(obj,'DMY',locale,'en');
	}
}
