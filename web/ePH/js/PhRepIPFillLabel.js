  function run()
{   
	var frmObject = searchFrame.document.formPHRepIPFillLabel;
	var fields = new Array (frmObject.p_nursing_unit,frmObject.p_fill_proc_id);
	var names = new Array (getLabel("Common.nursingUnit.label","Common"),getLabel("ePH.FillProcessID.label","PH"));
	if(checkFields(fields,names,messageFrame)) 
	{
		var formObj = searchFrame.document.formPHRepIPFillLabel;
		bean_id		= formObj.bean_id1.value ;
		bean_name	= formObj.bean_name1.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr ="<root><SEARCH " ;
		xmlStr += "bean_id1=\""+bean_id+"\" " ;
		xmlStr += "bean_name1=\""+bean_name+"\" " ;
		xmlStr += "p_nursing_unit=\""+formObj.nunit.value+"\" " ;
		xmlStr += "p_order_type=\""+formObj.p_order_type.value+"\" " ;
		xmlStr += "p_facility_id=\""+formObj.p_facility_id.value+"\" " ;
		xmlStr += "p_user_name=\""+formObj.p_user_name.value+"\" " ;
		xmlStr += "p_module_id=\""+formObj.p_module_id.value+"\" " ;
		xmlStr += "p_report_id=\""+formObj.p_report_id.value+"\" " ;
		xmlStr += "p_disp_fm_no=\""+formObj.p_disp_fm_no.value+"\" " ;
		xmlStr += "p_disp_to_no=\""+formObj.p_disp_to_no.value+"\" " ;
		xmlStr += "p_fill_prc_id=\""+formObj.p_fill_proc_id.value+"\" " ;
		xmlStr += "p_language_id=\""+formObj.p_language_id.value+"\" " ;
		xmlStr += "p_ord_facility_id=\""+formObj.p_ord_facility_id.value+"\" " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "ReportsValidate.jsp?&called_from=print_label ",false); 
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
	//alert(responseText);   
		eval( responseText ) ;	
      
	}
}


function reset()
{
	var formObj = searchFrame.document.formPHRepIPFillLabel;
	searchFrame.location.reload();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

async function searchNursingUnit(target){

	var formObj = document.formPHRepIPFillLabel;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	
	var ordering_facility_id = formObj.p_ord_facility_id.options[formObj.p_ord_facility_id.selectedIndex].value;
		
	dataNameArray[0]   = "FACILITY_ID" ;
	dataValueArray[0]  = ordering_facility_id;
	dataTypeArray[0]   = STRING ;


	

	argumentArray[0]   = formObj.SQL_PH_DISP_MEDICATION_SELECT32.value+"'"+formObj.language_id.value+"' ORDER BY 2";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,3";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;

	var retVal = await CommonLookup( getLabel("Common.nursingUnit.label","Common"), argumentArray );
	var str =unescape(retVal);
	var arr = str.split(",");
	if(retVal != null && retVal != "" )  {
		if(target.name=="p_nursing_unit") {
			formObj.nunit.value = arr[0];
			} 
			target.value = arr[1] ;
	   	    var n=target.value;
			//alert(formObj.nunit.value);
	  	    getFillid(formObj.nunit.value);
		}
	}

function clearList() 
{
	var len =document.formPHRepIPFillLabel.p_fill_proc_id.options.length;
	for(var i=0;i<len;i++) {
		document.formPHRepIPFillLabel.p_fill_proc_id.remove("fill_proc_id") ;
	}
}

function getFillid(nunit_code)
{
	var formObj = document.formPHRepIPFillLabel;
	bean_id		= document.formPHRepIPFillLabel.bean_id1.value ;
	bean_name	= document.formPHRepIPFillLabel.bean_name1.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();


	xmlStr ="<root><SEARCH " ;
	xmlStr += "nuint=\""+nunit_code+"\" " ;
	xmlStr += "bean_id1=\""+bean_id+"\" " ;
    xmlStr += "bean_name1=\""+bean_name+"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open( "POST", "ReportsValidate.jsp?&called_from=Fill_proc_id ",false); 
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;

}

function addEmpty()
{   

	var opt	= eval(document.createElement('OPTION'));
	opt.text = "---"+getLabel("Common.defaultSelect.label","Common")+"---";
	opt.value =	"";
	document.formPHRepIPFillLabel.p_fill_proc_id.options.add(opt);
}

function loadFillProcNos(fillProcNo)
{
	var opt			= document.createElement('OPTION') ;
	opt.value		=  fillProcNo ;
	opt.text		=  fillProcNo ;
	document.formPHRepIPFillLabel.p_fill_proc_id.add(opt);
}

 function setProcId(procid)
 {
	 document.formPHRepIPFillLabel.p_fill_prc_id.value =procid;
 }


function getDispNos(obj) 
{
	 var formObj = document.formPHRepIPFillLabel;
	 document.formPHRepIPFillLabel.p_fill_prc_id.value=obj.value;
	 bean_id		= document.formPHRepIPFillLabel.bean_id1.value ;
	 bean_name		= document.formPHRepIPFillLabel.bean_name1.value ;
	 var nunit		= document.formPHRepIPFillLabel.nunit.value;
	
	 var xmlHttp = new XMLHttpRequest();	
	 xmlStr ="<root><SEARCH " ;
	 xmlStr += "procid=\""+obj.value+"\" " ;
	 xmlStr += "nunit=\""+nunit+"\" " ;
	 xmlStr += "bean_id1=\""+bean_id+"\" " ;
     xmlStr += "bean_name1=\""+bean_name+"\" " ;
	 xmlStr +=" /></root>" ; 
	 var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
  	 xmlHttp.open( "POST", "ReportsValidate.jsp?&called_from=Disp_order_id",false); 
 	 xmlHttp.send( xmlDoc ) ;
	 responseText=xmlHttp.responseText ;
	 eval( responseText ) ;

}

function loadDispNos(fromdisp,todisp,fillProcId)
{
	document.formPHRepIPFillLabel.p_disp_fm_no.value=fromdisp;
	document.formPHRepIPFillLabel.p_disp_to_no.value=todisp;
	setProcId(fillProcId);
	
 }

 function assignResult(){
	 alert(getMessage("REPORT_SUBMITTED","PH"));
 }


