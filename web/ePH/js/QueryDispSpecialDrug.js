 //saved on 29/10/2005
var firsttime=true;
function query(){
	f_query_add_mod.location.href="../../ePH/jsp/QueryDispSpecialDrugFrames.jsp";
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
	
	var formObj = frames.f_query_add_mod.f_queryCriteria.FormQueryDispSpecialDrug;
	formObj.reset();
	frames.f_query_add_mod.f_orderframe.location.href="../../eCommon/html/blank.html";
	if (clearBottom==0)
	{
		frames.messageFrame.location.href="../../eCommon/jsp/error.jsp";
	}
	


}
//for Patient Lookup
async function callPatientSearch(obj){
	var patient_id = await PatientSearch();
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
    var id=document.forms[0].language_id.value;
	
	//alert("id---->"+id);
	//var sql_1="SELECT   st.item_code code, 	 mm.short_desc description    FROM   mm_item_lang_vw  mm,    st_item  st 	WHERE    st.item_code = mm.item_code  and 	mm.eff_status =	'E'	     AND  st.drug_item_yn='Y'  AND    mm.language_id LIKE  ?      AND	    st .item_code   LIKE   UPPER(?)    AND upper(mm.short_desc)	 LIKE   upper(?)   order by 2";
	//argumentArray[0]   = "language_id";
	//argumentArray[0]   = document.forms[0].language_id.value;
	//argumentArray[0]   = STRING;
	//argumentArray[0]   = sql_1; //document.forms[0].SQL_PH_DRUG_ITEM_LINK_SELECT1.value
	
	argumentArray[0]   = "SELECT   DISTINCT    DRUG_CODE code,   DRUG_DESC description FROM    PH_DRUG_LANG_VW A,OR_ORDER_CATALOG B ,OR_ORDER_CATALOG_BY_PTCL C WHERE    DRUG_CODE LIKE ? AND   DRUG_DESC LIKE ?  AND   B.ORDER_CATEGORY='PH' AND B.ORDER_CATALOG_CODE=A.DRUG_CODE   AND B.ORDER_CATALOG_CODE=C.ORDER_CATALOG_CODE AND C.ORD_SPL_APPR_REQD_YN='Y' AND A.LANGUAGE_ID = '"+id+"' ORDER BY 1";
    argumentArray[4]   = "1,2";
    argumentArray[1]   = dataNameArray ;
    argumentArray[2]   = dataValueArray ;
    argumentArray[3]   = dataTypeArray ;
	argumentArray[5]   = target.value ;
    argumentArray[6]   = DESC_LINK ;
    argumentArray[7]   = CODE_DESC ;

	retVal=await CommonLookup('Drug Search', argumentArray );
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
		document.FormQueryDispSpecialDrug.Drug_Code.value=arr[0];
		//target.disabled=true;
		//document.FormQueryDispTrialDrug.Drug_Name_Button.disabled=true;
	
	}


}



function validateDate(obj){
	CheckDate(obj);
}
function loadDetailsfromSummary(drug_code,dt_from,dt_to,drug_desc,uom)
{
			
	if (firsttime)
  {
	   // parent.OrderFrameSet.rows="30%,4%,40%,*";
		firsttime=false;  
  }

 parent.f_orderdetailsframe.location.href="../../ePH/jsp/QueryDispSpecialDrugOrder.jsp?drug_code="+drug_code+"&dt_from="+dt_from+"&dt_to="+dt_to+"&fromSummary=1";
//parent.f_drugdetailsframe.location.href="../../ePH/jsp/QueryDispSpecialDrugDisplayDrug.jsp?drug_desc="+drug_desc;
//parent.f_totaldetailsframe.location.href="../../ePH/jsp/QueryDispSpecialDrugTotalDetails.jsp?drug_code="+drug_code+"&uom="+uom;
 parent.f_orderdetailsframe1.location.href="../../eCommon/html/blank.html"; 

}
function loadOrderDetails(ordid,order_line_num,patientdetails,summaryloaded){
parent.f_orderdetailsframe1.location.href="../../ePH/jsp/QueryDispSpecialDrugOrderLine.jsp?order_id="+ordid+"&order_line_num="+order_line_num+"&patient_details="+patientdetails;

if (summaryloaded==0)
	{ 
			//parent.OrderFrameSet.rows="4%,40%,12%,*";
	}
	else
	{
			//parent.OrderFrameSet.rows="20%,4%,38%,12%,*";

	}

}
function loadBatchDetails(dispno,patientdetails,summaryloaded){
	parent.f_orderdetailsframe1.location.href="../../ePH/jsp/QueryDispSpecialDrugOrderLine.jsp?disp_no="+dispno+"&patient_details="+patientdetails;

if (summaryloaded==0)
	{

	}
	else
	{


	} 

} 

function loadDrugDetails(drugdesc,uom,drugcode){  
parent.f_drugdetailsframe.location.href="../../ePH/jsp/QueryDispSpecialDrugDisplayDrug.jsp?drug_desc="+drugdesc;
parent.f_totaldetailsframe.location.href="../../ePH/jsp/QueryDispSpecialDrugTotalDetails.jsp?drug_code="+drugcode+"&uom="+uom; 
}

function callResultPage(){ 
var formObj	=	parent.document.f_queryCriteria.FormQueryDispSpecialDrug;								
var localeName = formObj.language_id.value; 
var fields	=new Array();
fields[0]=formObj.Drug_Name;

var names=new Array();
names[0]=getLabel("Common.DrugName.label","Common");

var errorPage	= "../../eCommon/jsp/error.jsp" ;
var blankObj 	= null ;
blankObject  = getBlankField( fields, names, parent.parent.messageFrame, errorPage) ;

if (blankObject!=null)
{
	blankObject.focus() ;

	return;
 
}
names[0]=getLabel("ePH.DispensedDateFrom.label","PH");
fields[1]=formObj.Dispense_Date_From;
blankObject  = getBlankField( fields, names, parent.parent.messageFrame, errorPage) ;

if (blankObject!=null)
{
	blankObject.focus() ;

	return;
 
}

names[0]=getLabel("ePH.DispensedDateTo.label","PH");
fields[2]=formObj.Dispense_Date_To;
blankObject  = getBlankField( fields, names, parent.parent.messageFrame, errorPage) ;

if (blankObject!=null)
{
	blankObject.focus() ;

	return;
 
}

var dt_from = convertDate(formObj.Dispense_Date_From.value,'DMY',localeName); 
var dt_to  = convertDate(formObj.Dispense_Date_To.value,'DMY',localeName); 
 
/*
	var dt_from	=	formObj.Dispense_Date_From.value;
	var dt_to	=	formObj.Dispense_Date_To.value;
*/

	if (dt_from!="" && dt_to!=""){
	
		if(!doDateCheck(formObj.Dispense_Date_From,formObj.Dispense_Date_To,parent.parent.messageFrame)){
			formObj.Dispense_Date_To.select();
			formObj.Dispense_Date_To.focus();
			parent.parent.reset(1);
			return;
		}
	}


	var drug_code	=	formObj.Drug_Code.value;
	parent.f_orderframe.location.href="../../ePH/jsp/QueryDispSpecialDrugOrder.jsp?drug_code="+drug_code+"&dt_from="+dt_from+"&dt_to="+dt_to;
	parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp"; 

}




