 //saved on 29/10/2005
function query(){
	f_query_add_mod.location.href="../../ePH/jsp/QueryDispDrugPatientFrames.jsp";
}

function reset(clearBottom){
	
	if (clearBottom=="")
	{
		clearBottom=0;
	}
	url=frames.f_query_add_mod.location.href;

	if (url.indexOf('blank')!=-1)
	{
			return;
	}

	var formObj = frames.f_query_add_mod.f_queryCriteria.FormQueryDispDrugPatient;//.FormQueryPresVsDispDrug;
	formObj.reset();
	frames.f_query_add_mod.f_orderframe.location.href="../../eCommon/html/blank.html";
	if (clearBottom==0)
	{
		frames.messageFrame.location.href="../../eCommon/jsp/error.jsp";
	}


}
//for Patient Lookup

async function callPatientSearch(target){
	

	var patient_id = await PatientSearch();
 if(patient_id != null && patient_id != "" )  {		
		target.value = patient_id;		
 }
}

//for Drug Lookup
async function searchDrugName(obj){
	//alert("searchDrugName");

	var formObj = obj;
	//alert("formObj--->" +formObj.name);

	if (obj.searchby[0].checked==true)
	{
		retVal =await DrugSearch( "D", obj.Drug_Name,"QueryDDP" );
	}
	else
	{
		retVal =await DrugSearch( "T", obj.Drug_Name,"QueryDDP" );
	}
	var ret1=unescape(retVal);
	var arr=ret1.split(",");
	if(retVal != null && retVal != "" )  {
		
		formObj.Drug_Name.value = arr[1] ;
		formObj.Drug_Code.value = arr[0];
		//alert("formObj.Drug_Name.value" +formObj.Drug_Name.value+ "formObj.Drug_Code.value" +formObj.Drug_Code.value);
		
	}
		
}
function cleardrugname(obj)
{
	
	var formObj=document.FormQueryDispDrugPatient;
	if(obj.value == null ||obj.value == "")
	{
		formObj.Drug_Name.value ="";
		formObj.Drug_Code.value ="";
	}
	//alert("formObj.Drug_Name.value-->" +formObj.Drug_Name.value)
	//alert("formObj.Drug_Code.value -->" +formObj.Drug_Code.value)
}



function validateDate(obj){
	CheckDate(obj);
}


function loadOrderDetails(ordid,order_line_num){

parent.f_orderdetailsframe1.location.href="../../ePH/jsp/QueryDispDrugPatientOrderLine.jsp?order_id="+ordid+"&order_line_num="+order_line_num;
parent.OrderFrameSet.rows="2%,6%,60%,*";


}
function loadBatchDetails(dispno,drug_code){
	parent.f_orderdetailsframe1.location.href="../../ePH/jsp/QueryDispDrugPatientOrderLine.jsp?disp_no="+dispno+"&drug_code="+drug_code;
	parent.OrderFrameSet.rows="2%,6%,60%,*";

}

function loadPatientDetails(patid,name,age,gender){

	parent.f_patientdetailsframe.location.href="../../ePH/jsp/RegPrescriptionsPatientLine.jsp?patient_id="+patid+"&name="+name+"&age="+age+"&gender="+gender+"&called_from=DISPENSEDDRUGS_BYPATIENT";
                                                                                                                                                                                               
}

function callResultPage(){

//Chek if Patient Id is null


var formObj	=	document.FormQueryDispDrugPatient;

var fields=new Array();
var localeName = formObj.locale.value;

fields[0]=formObj.Patient_Id;

var names=new Array();
names[0]="Patient Id";

var errorPage	= "../../eCommon/jsp/error.jsp" ;
var blankObj 	= null ;
blankObject  = getBlankField( fields, names, parent.parent.messageFrame, errorPage) ;

if (blankObject!=null)
{
	blankObject.focus() ;
	parent.parent.reset(1);
	return;

}
	//Validate from date and to date
//	var dt_from	=	formObj.Dispense_Date_From.value;

var dt_from = convertDate(formObj.Dispense_Date_From.value,'DMY',localeName); 

var dt_to = convertDate(formObj.Dispense_Date_To.value,'DMY',localeName);  

	if (dt_from!="" && dt_to!=""){ 
	
		if(!doDateCheck(formObj.Dispense_Date_From,formObj.Dispense_Date_To,parent.parent.messageFrame)){
			formObj.Dispense_Date_To.select();
			formObj.Dispense_Date_To.focus(); 
			parent.parent.reset(1);
			return;
		}
	}

	var patient_id=formObj.Patient_Id.value;

	var drug_code	=	formObj.Drug_Code.value;

	parent.f_orderframe.location.href="../../ePH/jsp/QueryDispDrugPatientOrderFrame.jsp?patient_id="+patient_id+"&drug_code="+drug_code+"&dt_from="+dt_from+"&dt_to="+dt_to;
	parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";

}

function Duplicatecheck(){   /* Below code added for ML-BRU-SCF-0621[IN036565] -- Start */ 
	var patientId = document.FormQueryDispDrugPatient.Patient_Id.value; 
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
	document.FormQueryDispDrugPatient.Patient_Id.value=main_patientid;    
}/* code added for ML-BRU-SCF-0621[IN036565] -- End */
