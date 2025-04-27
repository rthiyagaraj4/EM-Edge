 //saved on 29/10/2005
var firsttime=true;
function query(){
	f_query_add_mod.location.href="../../ePH/jsp/QueryDispTrialDrugFrames.jsp";
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
	
	var formObj = frames.f_query_add_mod.f_queryCriteria.FormQueryDispTrialDrug;
	formObj.reset();
	frames.f_query_add_mod.f_orderframe.location.href="../../eCommon/html/blank.html";
	frames.f_query_add_mod.f_drugdetailsframe.location.href="../../eCommon/html/blank.html";
	frames.f_query_add_mod.f_orderdetailsframe.location.href="../../eCommon/html/blank.html";
	frames.f_query_add_mod.f_totaldetailsframe.location.href="../../eCommon/html/blank.html";
	frames.f_query_add_mod.f_orderdetailsframe1.location.href="../../eCommon/html/blank.html";
	if (clearBottom==0)
	{
		frames.messageFrame.location.href="../../eCommon/jsp/error.jsp";
	}
	

}
//for Patient Lookup
function callPatientSearch(obj){
	var patient_id = PatientSearch();
		if ((patient_id=="undefined")||(patient_id!="")) 
	{

	}
	else
	{
					obj.value = patient_id;
	}

}
//for Drug Lookup
/*function searchDrugName(obj){

	var formObj = obj;

	retVal =DrugSearch( "D", obj.Drug_Name);

	if(retVal != null && retVal != "" )  {
		formObj.Drug_Name.value = retVal[1] ;
		formObj.Drug_Code.value = retVal[0];
		
	}

}*/
async function DrugSearch( target ) {
    var argumentArray  = new Array() ;
    var dataNameArray  = new Array() ;
    var dataValueArray = new Array() ;
    var dataTypeArray  = new Array() ;

    var language_id  = document.FormQueryDispTrialDrug.locale.value;
	//argumentArray[0]   = document.FormQueryDispTrialDrug.Drug_Query.value;
	//alert("argumentArray[0]-------->"+argumentArray[0]);
	dataNameArray[0]="language_id";
	dataValueArray[0]=language_id
	dataTypeArray[0]=STRING;
	argumentArray[0]   = escape("SELECT DRUG_CODE code,DRUG_DESC description FROM PH_DRUG_LANG_VW A  WHERE UPPER(A.LANGUAGE_ID) like UPPER(?) AND DRUG_CODE LIKE ? AND DRUG_DESC LIKE ?   AND TRIAL_DRUG_YN='Y'");

    argumentArray[4]   = "2,3";
    argumentArray[1]   = dataNameArray ;
    argumentArray[2]   = dataValueArray ;
    argumentArray[3]   = dataTypeArray ;
	argumentArray[5]   = target.value ;
    argumentArray[6]   = DESC_LINK ;
    argumentArray[7]   = CODE_DESC ;

	retVal= await CommonLookup('Drug Search', argumentArray );
	var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if (retVal!="")
	{
		target.value = arr[1];
		document.FormQueryDispTrialDrug.Drug_Code.value=arr[0];
		//target.disabled=true;
		//document.FormQueryDispTrialDrug.Drug_Name_Button.disabled=true;
	
	}


}



function validateDate(obj){
	CheckDate(obj);
}


function loadOrderDetails(ordid,order_line_num,patientdetails,summaryloaded){
parent.f_orderdetailsframe1.location.href="../../ePH/jsp/QueryDispTrialDrugOrderLine.jsp?order_id="+ordid+"&order_line_num="+order_line_num+"&patient_details="+patientdetails;
if (summaryloaded==0)
	{
			//parent.OrderFrameSet.rows="4%,40%,8%,*";
	}
	else
	{
			//parent.OrderFrameSet.rows="20%,4%,40%,8%,*";

	}

}

function loadBatchDetails(dispno,patientdetails,summaryloaded){
	parent.f_orderdetailsframe1.location.href="../../ePH/jsp/QueryDispTrialDrugOrderLine.jsp?disp_no="+dispno+"&patient_details="+patientdetails;
	if (summaryloaded==0)
	{
			//parent.OrderFrameSet.rows="4%,40%,8%,*";
	}
	else
	{
			//parent.OrderFrameSet.rows="20%,4%,40%,8%,*";

	}


}
function loadDetailsfromSummary(drug_code,dt_from,dt_to,drug_desc,uom)
{
	if (firsttime)
  {
	   // parent.OrderFrameSet.rows="30%,4%,40%,*";
		firsttime=false;
  }
  parent.f_orderdetailsframe.location.href="../../ePH/jsp/QueryDispTrialDrugOrder.jsp?drug_code="+drug_code+"&dt_from="+dt_from+"&dt_to="+dt_to+"&fromSummary=1";
  //parent.f_drugdetailsframe.location.href="../../ePH/jsp/QueryDispTrialDrugDisplayDrug.jsp?drug_desc="+drug_desc;
 // parent.f_totaldetailsframe.location.href="../../ePH/jsp/QueryDispTrialDrugTotalDetails.jsp?drug_code="+drug_code+"&uom="+uom;
  parent.f_orderdetailsframe1.location.href="../../eCommon/html/blank.html";
  
  

}

function loadDrugDetails(drugdesc,uom,drugcode){
parent.f_drugdetailsframe.location.href="../../ePH/jsp/QueryDispTrialDrugDisplayDrug.jsp?drug_desc="+drugdesc;
parent.f_totaldetailsframe.location.href="../../ePH/jsp/QueryDispTrialDrugTotalDetails.jsp?drug_code="+drugcode+"&uom="+uom;
}

function callResultPage(){

//Chek if Patient Id is null


//var formObj	=	document.frames.FormQueryDispTrialDrug;
var formObj	=	document.getElementById('FormQueryDispTrialDrug');
var fields	=new Array();
var localeName = formObj.locale.value;

fields[0]=formObj.Drug_Name;
fields[1]=formObj.Dispense_Date_From;
fields[2]=formObj.Dispense_Date_To;
 
var names=new Array();
names[0]=getLabel("Common.DrugName.label","Common");
names[1]=getLabel("ePH.DispensedDateFrom.label","PH");
names[2]=getLabel("ePH.DispensedDateTo.label","PH");

var errorPage	= "../../eCommon/jsp/error.jsp" ;
var blankObj 	= null ;
blankObject  = getBlankField( fields, names, parent.parent.messageFrame, errorPage) ;

if (blankObject!=null)
{
	blankObject.focus() ;
	//parent.parent.reset(1);
	return;

}
	//Validate from date and to date

var dt_from = convertDate(formObj.Dispense_Date_From.value,'DMY',localeName);
var dt_to = convertDate(formObj.Dispense_Date_To.value,'DMY',localeName);

//	var dt_from	=	formObj.Dispense_Date_From.value;
//	var dt_to	=	formObj.Dispense_Date_To.value;

	if (dt_from!="" && dt_to!=""){
	
		if(!doDateCheck(formObj.Dispense_Date_From,formObj.Dispense_Date_To,parent.parent.messageFrame)){
			formObj.Dispense_Date_To.select();
			formObj.Dispense_Date_To.focus();
			parent.parent.reset(1);
			return;
		}
	}

//	var patient_id=formObj.Patient_Id.value;
	var drug_code	=	formObj.Drug_Code.value;

	parent.f_orderframe.location.href="../../ePH/jsp/QueryDispTrialDrugOrder.jsp?drug_code="+drug_code+"&dt_from="+dt_from+"&dt_to="+dt_to;
	parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";

}


