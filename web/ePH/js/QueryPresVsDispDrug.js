  //saved on 29/10/2005
function query(){
	f_query_add_mod.location.href="../../ePH/jsp/QueryPresVsDispDrugFrames.jsp";
}

function clearData(obj) {
	obj = eval(obj);
	var len = obj.length;
	for (var i=0; i<=len; i++) {
		obj.remove("");
	}
	//var opt	= document.createElement('OPTION');
	//opt.value =	"";
	//opt.text = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--Select--";
	//obj.add(opt);
}
 
function addData(code, desc, obj) {
	alert(obj);
	obj = eval(obj);
	var opt	= eval(document.createElement('OPTION'));
	opt.value =	code;
	opt.text = desc;
	obj.add(opt); 
}

function callAdditionalCriteria()
{
parent.f_orderframe.location.href="../../ePH/jsp/QueryPresVsDispDrugAddnCriteria.jsp";
parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
}
function closeAdditionalCriteria()
{
parent.f_orderframe.location.href="../../eCommon/html/blank.html";
}

// lookup for Location

async function LocationSearch(target){
	var argumentArray  = new Array() ;
    var dataNameArray  = new Array() ;
    var dataValueArray = new Array() ;
    var dataTypeArray  = new Array() ;
    argumentArray[4]   = "1,2";

    argumentArray[1]   = dataNameArray ;
    argumentArray[2]   = dataValueArray ;
    argumentArray[3]   = dataTypeArray ;
	argumentArray[5]   = target.value ;
    argumentArray[6]   = DESC_LINK ;
    argumentArray[7]   = DESC_CODE ;

if (document.FormQueryPresVsDispDrug.Location_Type.value=="N")
{
	//Search for Nursing Unit
	argumentArray[0]   = "SELECT NURSING_UNIT_CODE CODE,LONG_DESC DESCRIPTION FROM IP_NURSING_UNIT_LANG_VW IP_NURSING_UNIT WHERE EFF_STATUS='E' AND NURSING_UNIT_CODE LIKE ? AND LONG_DESC LIKE ? AND LANGUAGE_ID = "+"'"+document.FormQueryPresVsDispDrug.language_id.value+"' "; //Modified for MOHE-SCF-0131
	retVal=await CommonLookup(getLabel("Common.NursingUnitSearch.label","Common"), argumentArray );
	var str =unescape(retVal);
	var arr = str.split(",");
	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if (retVal!="")
	{
		target.value = arr[1];
		document.FormQueryPresVsDispDrug.Nursing_Unit_Code.value=arr[0];
		populateDispenseLocation("N",arr[0]);
		
	}
}
else
{
	//argumentArray[0]   = "SELECT CLINIC_CODE CODE,LONG_DESC DESCRIPTION FROM OP_CLINIC_LANG_VW OP_CLINIC WHERE EFF_STATUS='E' AND CLINIC_TYPE='C' AND CLINIC_CODE LIKE ? AND SHORT_DESC LIKE ? AND LANGUAGE_ID ="+"'"+document.FormQueryPresVsDispDrug.language_id.value+"' "; //Modified for MOHE-SCF-0131

	argumentArray[0]   = "SELECT CLINIC_CODE CODE,LONG_DESC DESCRIPTION FROM OP_CLINIC_LANG_VW OP_CLINIC WHERE EFF_STATUS='E' AND CLINIC_TYPE IN('C','E') AND UPPER(CLINIC_CODE) LIKE  UPPER(?) AND upper(SHORT_DESC) LIKE  UPPER(?) AND LANGUAGE_ID ="+"'"+document.FormQueryPresVsDispDrug.language_id.value+"' "; //Modified for MOHE-SCF-0131 //Added E in clinic_type for ML-MMOH-SCF-0210


	retVal=await CommonLookup(getLabel("ePH.ClinicSearch.label","PH"), argumentArray );
	var str =unescape(retVal);
	var arr = str.split(",");
	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if (retVal!="")
	{
		target.value = arr[1];
		document.FormQueryPresVsDispDrug.Clinic_Code.value=arr[0];
		populateDispenseLocation("C",arr[0]);
	}
}

 
}

function disableLocationType(val) {
		if(val=="") {
			document.FormQueryPresVsDispDrug.Location_Type.value="";
			document.FormQueryPresVsDispDrug.Location_Type.disabled=false;
		}else if(val=="IP"){
			document.FormQueryPresVsDispDrug.Location_Type.value="N";
			document.FormQueryPresVsDispDrug.Location_Type.disabled=true;
		}else if(val=="OP") {
			document.FormQueryPresVsDispDrug.Location_Type.value="C";
			document.FormQueryPresVsDispDrug.Location_Type.disabled=true;
		}
}

function disableLocation(val)
{
	//document.FormQueryPresVsDispDrug.Location_Button.disabled=true;
	//clearData(document.FormQueryPresVsDispDrug.Location_Button);
	//addData("","  ---Select---   ",document.FormQueryPresVsDispDrug.Location_Button);

	if (val=="")
	{
		document.FormQueryPresVsDispDrug.Location.disabled=true;
		document.FormQueryPresVsDispDrug.Location.value="";
		document.FormQueryPresVsDispDrug.Location_Button.disabled=true;
		document.FormQueryPresVsDispDrug.Patient_Class.value="";
		document.FormQueryPresVsDispDrug.Patient_Class.disabled=false;
	}
	else
	{
		document.FormQueryPresVsDispDrug.Location.value="";
		document.FormQueryPresVsDispDrug.Location.disabled=false;
		document.FormQueryPresVsDispDrug.Location_Button.disabled=false;
		if(val=="N"){
			document.FormQueryPresVsDispDrug.Patient_Class.value="IP";
			document.FormQueryPresVsDispDrug.Patient_Class.disabled=true;
		}else if(val=="C") {
			document.FormQueryPresVsDispDrug.Patient_Class.value="OP";
			document.FormQueryPresVsDispDrug.Patient_Class.disabled=true;
		}

	}
	

}

function validateDate(obj){
	CheckDate(obj);

}

//This function populates the dispense location list box on the basis of selected location code
function populateDispenseLocation(type,val ) 
{
	//document.getElementById("Disp_Locn").innerText = "";

	var bean_id		= document.FormQueryPresVsDispDrug.bean_id.value ;
	var bean_name	= document.FormQueryPresVsDispDrug.bean_name.value ;

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	xmlStr ="<root><SEARCH " ;
	xmlStr += "Location=\""+ val +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "QueryPresVsDispDrugTemporary.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +  "&type="+type+"&code=" + val, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
	
}

function loadOrderDetails(ordid,displocncode,displocndesc){
	
	parent.f_orderdetailsframe.location.href="../../ePH/jsp/QueryPresVsDispDrugOrderLine.jsp?order_id="+ordid +"&disp_locn_code=" + displocncode;
//	parent.OrderFrameSet.rows="60%,10%,*";

}



function callResultPage(){

	var formObj	=	document.FormQueryPresVsDispDrug;
	//Validate from date and to date
	//var dt_from	=	formObj.Order_Date_From.value;
	//var dt_to	=	formObj.Order_Date_To.value;
	var locale				=	formObj.language_id.value;
	var dt_from				=	convertDate(formObj.Order_Date_From.value,'DMY',locale,"en"); 
	var dt_to				=	convertDate(formObj.Order_Date_To.value,'DMY',locale,"en");
	if (dt_from!="" && dt_to!=""){
	
		if(!doDateCheck1(formObj.Order_Date_From,formObj.Order_Date_To)){
			formObj.Order_Date_To.select();
			formObj.Order_Date_To.focus();
			return;
		}
	}


	var order_id		=	formObj.Order_Id.value;
	var order_type		=	formObj.Order_Type.value;
	var order_status	=	formObj.Order_Status.value;
	var patient_class	=	formObj.Patient_Class.value;
	var location_type	=	formObj.Location_Type.value;
	var patient_id		=	formObj.patient_id.value;
	
	var location_code="";
	if (location_type=='N')
	{
		 location_code		=	formObj.Nursing_Unit_Code.value;
	}
	else if (location_type=='C')
	{
		 location_code		=	formObj.Clinic_Code.value;
	}
	//var disp_locn_code	=	formObj.Disp_Locn.value;
	
	parent.f_orderframe.location.href="../../ePH/jsp/QueryPresVsDispDrugOrderFrame.jsp?dt_from="+dt_from+"&dt_to="+dt_to+"&order_id="+order_id+"&order_type="+order_type+"&order_status="+order_status+"&patient_class="+patient_class+"&location_type="+location_type+"&location_code="+location_code+"&patient_id="+patient_id;
	if(parent.parent.messageFrame!=null)
	parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";

}

function doDateCheck1(from,to,messageFrame) {
	
    var fromarray; var toarray;
    var fromdate = from.value ;
    var todate = to.value ;
    if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
            var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
            if(Date.parse(todt) < Date.parse(fromdt)) {
				
				alert(getMessage("TO_DATE_EQUAL_GREATER_FROM_DATE","PH"));				
                return false;
            }
            else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
    }
return true;
}



async function callPatientSearch(){
	var formObj=document.FormQueryPresVsDispDrug;
	var patient_id = await PatientSearch();
 if(patient_id != null && patient_id != "" )  
 {
	 		 formObj.patient_id.value = patient_id;

 }

}

function reset(){
	
	url=frames.f_query_add_mod.location.href;

	if (url.indexOf('blank')!=-1)
	{
			return;
	}

	var formObj = frames.f_query_add_mod.f_queryCriteria.FormQueryPresVsDispDrug;//.FormQueryPresVsDispDrug;
	//formObj.Patient_Class.value="";
	//formObj.Patient_Class.disabled=false;
	formObj.Location_Type.value="";
	formObj.Location_Type.disabled=false;
	formObj.reset();
	frames.f_query_add_mod.f_orderframe.location.href="../../eCommon/html/blank.html";
	frames.messageFrame.location.href="../../eCommon/jsp/error.jsp";
}
 
function Duplicatecheck(){   /* Below code added for ML-BRU-SCF-0621[IN036565] -- Start */
	var patientId = document.FormQueryPresVsDispDrug.patient_id.value;
	if( (patientId != null) && (patientId !="")){	
		var	bean_id			= "QueryPatientDrugProfileBean" ;
		var	bean_name		= "ePH.QueryPatientDrugProfileBean";
		var xmlStr ="<root><SEARCH ";	
		xmlStr+= "patientId=\"" + patientId + "\" " ;	
		xmlStr+= "chkPatientID=\"false\" " ;
		xmlStr+= "bean_id=\"" + bean_id + "\" " ;	
		xmlStr+= "bean_name=\"" + bean_name + "\" " ;	
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "QueryPatientDrugProfileValidation.jsp?func_mode=Duplicate&bean_id=" + bean_id + "&bean_name=" +bean_name+"&patientId="+patientId, false ) ;	
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;		
		eval(responseText);	
	}		
} 

function mergedPatientAlert(main_patientid){ 
	msg = getMessage('PATIENT_MERGED_VALID','MP');
	msg= msg.replace('#',main_patientid);
	alert(msg);
	document.FormQueryPresVsDispDrug.patient_id.value=main_patientid;    
}/* code added for ML-BRU-SCF-0621[IN036565] -- End */
