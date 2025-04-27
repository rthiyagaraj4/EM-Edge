  
/*******************************************************************************/
async function loadPage(obj){
	var dialogHeight= "90vh" ;
	var dialogWidth	= "90vw " ;
	var status = "no" ;
	var drug_code = obj;
	var title = getLabel("ePH.DrugDetail.label", "Common");
	//alert("loadpage code:-"+drug_code);
	
	var dialogUrl		= "../../ePH/jsp/DrugDetailFrames.jsp?drug_code="+drug_code+"&title="+title;
	var dialogFeatures	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	await top.window.showModalDialog(dialogUrl,"",dialogFeatures);	

}
/******************************************************************************/
function CharecteristicsButton(obj,licenceRights){
/*parent.DrugDetails_Buttons.document.getElementById("characteristics").src="../../ePH/images/Characteristics_click.gif"	;
parent.DrugDetails_Buttons.document.getElementById("dosagedetails").src="../../ePH/images/DosageDispDetails.gif"
parent.DrugDetails_Buttons.document.getElementById("TradeNames").src="../../ePH/images/TradeNames.gif"
parent.DrugDetails_Buttons.document.getElementById("GenericIngredients").src="../../ePH/images/GenericIngredients.gif"
if(licenceRights != "PHBASIC"){
	parent.DrugDetails_Buttons.document.getElementById("inventorydetails").src="../../ePH/images/InventoryItems.gif";
}*/
parent.Button_Specific_Jsp.location.href="../../ePH/jsp/DrugDetailsCharecteristics.jsp";
}
/************************************************************************************/
function DosageDispensingButton(obj,licenceRights){
/*parent.DrugDetails_Buttons.document.getElementById("characteristics").src="../../ePH/images/Characteristics.gif"	;
parent.DrugDetails_Buttons.document.getElementById("dosagedetails").src="../../ePH/images/DosageDispDetails_click.gif"
parent.DrugDetails_Buttons.document.getElementById("TradeNames").src="../../ePH/images/TradeNames.gif"
parent.DrugDetails_Buttons.document.getElementById("GenericIngredients").src="../../ePH/images/GenericIngredients.gif"		
if(licenceRights != "PHBASIC"){
	parent.DrugDetails_Buttons.document.getElementById("inventorydetails").src="../../ePH/images/InventoryItems.gif";
}*/
parent.Button_Specific_Jsp.location.href="../../ePH/jsp/DispensingRules.jsp";
}
/******************************************************************************/
function GenericButton(obj,licenceRights){
/*parent.DrugDetails_Buttons.document.getElementById("characteristics").src="../../ePH/images/Characteristics.gif"	;
parent.DrugDetails_Buttons.document.getElementById("dosagedetails").src="../../ePH/images/DosageDispDetails.gif"
parent.DrugDetails_Buttons.document.getElementById("TradeNames").src="../../ePH/images/TradeNames.gif"
parent.DrugDetails_Buttons.document.getElementById("GenericIngredients").src="../../ePH/images/GenericIngredients_click.gif"
if(licenceRights != "PHBASIC"){
	parent.DrugDetails_Buttons.document.getElementById("inventorydetails").src="../../ePH/images/InventoryItems.gif";
}*/
parent.Button_Specific_Jsp.location.href="../../ePH/jsp/DrugDetailsGeneric.jsp";
}

/************************************************************************************/
function TradeNamesButton(obj,licenceRights){
/*parent.DrugDetails_Buttons.document.getElementById("characteristics").src="../../ePH/images/Characteristics.gif"	;
parent.DrugDetails_Buttons.document.getElementById("dosagedetails").src="../../ePH/images/DosageDispDetails.gif"
parent.DrugDetails_Buttons.document.getElementById("TradeNames").src="../../ePH/images/TradeNames_click.gif"
parent.DrugDetails_Buttons.document.getElementById("GenericIngredients").src="../../ePH/images/GenericIngredients.gif"
if(licenceRights != "PHBASIC"){
	parent.DrugDetails_Buttons.document.getElementById("inventorydetails").src="../../ePH/images/InventoryItems.gif";
}*/
parent.Button_Specific_Jsp.location.href="../../ePH/jsp/DrugDetailsTradeNames.jsp";

}
/************************************************************************************/
function InventoryItemsButton(obj,licenceRights)
{
	/*parent.DrugDetails_Buttons.document.getElementById("characteristics").src="../../ePH/images/Characteristics.gif"	;
	parent.DrugDetails_Buttons.document.getElementById("dosagedetails").src="../../ePH/images/DosageDispDetails.gif"
	parent.DrugDetails_Buttons.document.getElementById("TradeNames").src="../../ePH/images/TradeNames.gif"
	parent.DrugDetails_Buttons.document.getElementById("GenericIngredients").src="../../ePH/images/GenericIngredients.gif"
	if(licenceRights != "PHBASIC"){
		parent.DrugDetails_Buttons.document.getElementById("inventorydetails").src="../../ePH/images/InventoryItems_click.gif";
	}*/
	parent.Button_Specific_Jsp.location.href="../../ePH/jsp/DrugDetailsInventoryItems.jsp";
}
/************************************************************************************/

async function showImage(drug_code, trade_code){
	var dialogHeight= "30vh" ;
	var dialogWidth	= "50vw" ;
	var dialogTop = "111" ;
	var center = "1" ;
	var status="no";
	if(drug_code == undefined)
		drug_code="";
	if(trade_code == undefined)
		trade_code="";

	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal = await window.showModalDialog("../../ePH/jsp/DrugTradeImage.jsp?drug_code="+drug_code+"&trade_code="+trade_code,arguments,features);
}
/*****************************************************************************************/

function diagnosislistButton(obj,licenceRights){
/*parent.DrugDetails_Buttons.document.getElementById("characteristics").src="../../ePH/images/Characteristics.gif"	;
parent.DrugDetails_Buttons.document.getElementById("dosagedetails").src="../../ePH/images/DosageDispDetails.gif"
parent.DrugDetails_Buttons.document.getElementById("TradeNames").src="../../ePH/images/TradeNames.gif"
parent.DrugDetails_Buttons.document.getElementById("GenericIngredients").src="../../ePH/images/GenericIngredients_click.gif"
if(licenceRights != "PHBASIC"){
	parent.DrugDetails_Buttons.document.getElementById("inventorydetails").src="../../ePH/images/InventoryItems.gif";
}*/
	parent.Button_Specific_Jsp.location.href="../../ePH/jsp/DrugDetailsDiagnosisList.jsp";
}
/*****************************************************************************************/

function ageGroupButton(obj,licenceRights){
	parent.Button_Specific_Jsp.location.href="../../ePH/jsp/DrugDetailsAgeGroupList.jsp";
}
