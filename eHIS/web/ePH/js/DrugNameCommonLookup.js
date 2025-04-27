/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
07/01/2019	IN068345     Prathyusha	                                     Required changes in item substitute mapping set up
10/01/2019	IN068344	 Manickavasagam 		  						 GHL-CRF-0549 [IN068344] 
10/01/2019	IN068344	 Manickavasagam 		  						 GHL-CRF-0549 [IN068344] 
29/05/2020	IN:072092	 Manickavasagam J			     GHL-CRF-0618
30/06/2020  IN072347			Shazana											            	GHL-CRF-0619  
06/01/2021  TFS-12457    Prabha				06/01/2020	Manickavasagam J  Alpha-PH -Drug master setup in Query mode
21/01/2021	TFS-12204    Prabha             21/01/2021  Manickavasagam J    MMS-DM-CRF-0177
03/02/2021	TFS-15266    Haribabu          03/02/2021   Manickavasagam J  NMC-JD-SCF-0159
16/04/2021  TFS id:-16341    Haribabu	 16/04/2021	 	 Manickavasagam J          NMC-JD-CRF-0097
03/01/2022	TFS-26862	 Prabha											  GHL-ICN-0090
--------------------------------------------------------------------------------------------------------------------
*/
var returnVal="";
var msg=true; 
var priviligeCheck="";
var drugTitle = getLabel("ePH.DrugSearch.label", "Common");

// First argument   - search is based on Generic Name - G or Drug Name - D or Trade Name - T
// Second argument  - target field
async function DrugSearch(searchBasedOn,target) {

	//alert("DrugSearch common LookUp")
	//alert("searchBasedOn-->"+searchBasedOn);
	var default_text	=	"";
	returnVal = new String();
	if (target!=""){
		default_text =encodeURIComponent(target.value,"UTF-8");
	}
	var dialogHeight= "700px" ;
	var dialogWidth	= "900px" ;
	var status = "no";
	var dialogUrl		= "../../ePH/jsp/DrugNameCommonLookup.jsp?select="+searchBasedOn+"&default_text="+escape(default_text)+"&identity=General&modalYN=Y"+"&title="+drugTitle;
	var dialogFeatures	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	returnVal = await top.window.showModalDialog(dialogUrl,"", dialogFeatures);
	
	if( returnVal == null || returnVal == "" || returnVal == undefined ){
		
		return "";
	}
	else{
	
		return returnVal.split(":::") ;
	}
}

/*
	This method will be called from medication order.
	First argument   - search is based on Generic Name - G or Drug Name - D or Trade Name - T
	Second argument  - target field
	Third argument	 - order type code
	Fourth argument  - patient class
*/
async function DrugSearchForPres(searchBasedOn,target,order_type_code,drug_codes,bean_id,res_by_service,service_code,patient_class,priority,discharge_yn,patient_id,encounter_id,date_of_birth,gender,source_type,source_code,drugorfluid,iv_prep_yn,calledfrom,disp_locn_code,home_leave_yn_val,alternateOrder,normalRx_yn) {//added home_leave_yn_val for Bru-HIMS-CRF-093[29960] -->//added for  JD-CRF-0198 [IN:058599] and normalRx_yn added for GHL-CRF-0549
	//alert("inside DrugNameCommonLookup===38);
	var default_text	=	"";
	returnVal = new String();

	if (target!=""){
		 default_text =encodeURIComponent(target.value,"UTF-8");
	}
	if(iv_prep_yn == undefined || iv_prep_yn==null)
		iv_prep_yn="";

	if(calledfrom == undefined || calledfrom==null)
		calledfrom="";
	
	if(disp_locn_code == undefined || disp_locn_code==null)
		disp_locn_code="";

	var dialogHeight= "85vh" ;
	var dialogWidth	= "65vw" ;
	var status = "no";
	var dialogUrl		= "../../ePH/jsp/DrugNameCommonLookup.jsp?discharge_yn="+discharge_yn+"&priority="+priority+"&select="+searchBasedOn+"&default_text="+escape(default_text)+"&order_type_code="+order_type_code+"&drug_codes="+drug_codes+"&identity=MedicationOrder&modalYN=Y&bean_id="+bean_id+"&res_by_service="+res_by_service+"&service_code="+service_code+"&patient_class="+patient_class+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&date_of_birth="+date_of_birth+"&gender="+gender+"&source_type="+source_type+"&source_code="+source_code+"&drugorfluid="+drugorfluid+"&iv_prep_yn="+iv_prep_yn+"&calledfrom="+calledfrom+"&disp_locn_code="+disp_locn_code+"&home_leave_yn_val="+home_leave_yn_val+"&alternateOrder="+alternateOrder+"&normalRx_yn="+normalRx_yn+"&title="+drugTitle;//added for  JD-CRF-0198 [IN:058599] and normalRx_yn added for GHL-CRF-0549
	var dialogFeatures	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	returnVal = await top.window.showModalDialog(dialogUrl,"", dialogFeatures);

	if( returnVal == null || returnVal == "" || returnVal == undefined ){
		return "";
	}else{
		return returnVal.split(":::") ;
	}
}


async function DrugSearchForIV(searchBasedOn,target,order_type_code,drug_codes,bean_id,res_by_service,service_code,patient_class,priority,drugorfluid,iv_medication_type,discharge_yn,source_type,source_code,patient_id, encounter_id,date_of_birth,gender,iv_prep_yn) {
	//alert("searchBasedOn="+searchBasedOn+" target="+target+" order_type_code="+order_type_code+" drug_codes="+drug_codes+" bean_id="+bean_id+" res_by_service="+res_by_service+" service_code="+service_code+" patient_class="+patient_class+" priority="+priority+" drugorfluid="+drugorfluid+" iv_medication_type="+iv_medication_type+" discharge_yn="+discharge_yn+" source_type="+source_type+" source_code="+source_code+" patient_id="+patient_id+" encounter_id="+ encounter_id+" iv_prep_yn="+iv_prep_yn);

	var default_text	=	"";
	returnVal = new String();

	if (target!=""){
		default_text =encodeURIComponent(trimString(target.value),"UTF-8");
	}

	var dialogHeight= "90vh" ;
	var dialogWidth	= "72vw" ;
	var status = "no";
	var dialogUrl		= "../../ePH/jsp/DrugNameCommonLookup.jsp?discharge_yn="+discharge_yn+"&select="+searchBasedOn+"&default_text="+escape(default_text)+"&order_type_code="+order_type_code+"&drug_codes="+drug_codes+"&identity=MedicationOrder&modalYN=Y&bean_id="+bean_id+"&res_by_service="+res_by_service+"&service_code="+service_code+"&patient_class="+patient_class+"&priority="+priority+"&drugorfluid="+drugorfluid+"&iv_medication_type="+iv_medication_type+"&source_type="+source_type+"&source_code="+source_code+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&iv_prep_yn="+iv_prep_yn+"&normalRx_yn=Y"+"&title="+drugTitle;//normalRx_yn added for GHL-CRF-0549
	var dialogFeatures	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	returnVal = await top.window.showModalDialog(dialogUrl,"", dialogFeatures);

	
	if( returnVal == null || returnVal == "" || returnVal == undefined ){
		return "";
	}
	else{
		return returnVal.split(":::") ;
	}
}

async function showATCClassification(){

	var dialogHeight= "94vh" ;
	var dialogWidth	= "96vw" ;
	var dialogTop = "60" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal = await window.showModalDialog("../../ePH/jsp/ATCClassificationFrames.jsp?called_from=generic_atc&mode="+MODE_INSERT,arguments,features);
	document.getElementById("drugCharacteristicsTable").style.display="none";
	//parent.document.getElementById("drugsearchframeset").rows = "4%,*";
	parent.document.getElementById("lookup_header").style.height="30vh";
	parent.document.getElementById("lookup_footer").style.height="70vh";

	var bean_id=document.frmDrugNameCommonLookupSearchCriteria.bean_id.value;
	if (document.frmDrugNameCommonLookupSearchCriteria.order_type != null){

		var res_by_service ="";
		if(document.frmDrugNameCommonLookupSearchCriteria.res_by_service.checked==true){
			res_by_service = "Y";
		}
			else{
			res_by_service = "N";
		}
		parent.lookup_footer.location.href = "../../ePH/jsp/DrugNameCommonLookupResult.jsp?searchBasedOn=ATC&Classification="+encodeURIComponent(retVal)+"&identity=MedicationOrder&order_type_code="+document.frmDrugNameCommonLookupSearchCriteria.order_type.value+"&bean_id="+bean_id+"&res_by_service="+res_by_service+"&service_code="+document.frmDrugNameCommonLookupSearchCriteria.service_code.value;
	}
	else{

		parent.lookup_footer.location.href = "../../ePH/jsp/DrugNameCommonLookupResult.jsp?searchBasedOn=ATC&Classification="+retVal+"&identity=General&bean_id=DrugSearchBean";
	}
}
async function showPharmacoClassification(){
	document.getElementById("drugCharacteristicsTable").style.display="none";
	parent.document.getElementById("drugsearchframeset").rows = "8%,*";
	var bean_id=document.frmDrugNameCommonLookupSearchCriteria.bean_id.value;
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var dialogTop = "60px" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal = await window.showModalDialog("../../ePH/jsp/PharmacologicalClassificationFrames.jsp?called_from=generic_atc&mode="+MODE_INSERT,arguments,features);
	

	if (document.frmDrugNameCommonLookupSearchCriteria.order_type != null){
		parent.lookup_footer.location.href = "../../ePH/jsp/DrugNameCommonLookupResult.jsp?searchBasedOn=Pharmaco&Classification="+retVal+"&bean_id="+bean_id+"&identity=MedicationOrder";	
	}else{
		parent.lookup_footer.location.href = "../../ePH/jsp/DrugNameCommonLookupResult.jsp?searchBasedOn=Pharmaco&Classification="+retVal+"&bean_id="+bean_id+"&identity=General";
	}

}
async function showOtherCriteria(){
     
	var retVal = new String();
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var status = "no";

	parent.lookup_footer.location.href = "../../eCommon/html/blank.html";

	var dialogUrl		= "../../ePH/jsp/DrugNameCommonLookupOtherCriteria.jsp?title=Other Criteria" ;
	var dialogFeatures	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status+"; dialogTop:261";
	returnVal = await window.showModalDialog(dialogUrl,"", dialogFeatures);

	parent.lookup_footer.location.href="../../eCommon/html/blank.html";

	if( returnVal == null || returnVal == "" )
		return "";
	else
		return returnVal.split("\"") ;

}
function closew() {
	//var dialogTag = parent.parent.document.getElementById("dialog_tag");    
    //dialogTag.close();
	parent.window.close();
}

function Display(obj){
	var drugFormObj=document.getElementById('drugCharacteristicsTable');

	if (obj=="DrugByCharacteristics_tab"){
		//parent.document.getElementById("drugsearchframeset").rows = "*,58%";
		drugFormObj.style="display";
		drugFormObj.style.visibility="visible";
	//	document.getElementById("drugcharacteristics").src="../../ePH/images/By Drug Characteristics_click.gif";
	//	document.getElementById("atcclassification").src="../../ePH/images/By ATC Classification.gif";
	//	document.getElementById("pharmaclassification").src="../../ePH/images/By Pharmacol. Classification.gif";
	//    commented as the By pharma classification tab has removed
		parent.lookup_footer.location.href = "../../eCommon/html/blank.html";

	}
	else if (obj=="ByATC_tab"){
		drugFormObj.style.visibility="hidden";
		//commented as the By pharma classification tab has removed
	/*	document.getElementById("drugcharacteristics").src="../../ePH/images/By Drug Characteristics.gif";
		document.getElementById("atcclassification").src="../../ePH/images/By ATC Classification_click.gif";
		document.getElementById("pharmaclassification").src="../../ePH/images/By Pharmacol. Classification.gif";*/
		parent.lookup_footer.location.href = "../../eCommon/html/blank.html";
		showATCClassification();
	}
//    commented as the By pharma classification tab has removed
/*	else if (obj=="pharmco"){
		drugFormObj.style.visibility="hidden";
		document.getElementById("drugcharacteristics").src="../../ePH/images/By Drug Characteristics.gif";
		document.getElementById("atcclassification").src="../../ePH/images/By ATC Classification.gif";
		document.getElementById("pharmaclassification").src="../../ePH/images/By Pharmacol. Classification_click.gif";
		parent.lookup_footer.location.href = "../../eCommon/html/blank.html";
		showPharmacoClassification();
	}*/
}
async function searchCode(target,objIdentify){
	
	var formObj=document.frmDrugNameCommonLookupSearchCriteria; //Added for MMS-DM-CRF-0177
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	globalDrugRelated  = new Array() ;
	index			   = 0;
	var retVal ="";
	var ret1 = "";
	var arr = "";

	if (objIdentify=='Manufacturer'){
		
		var language_id  = document.forms[0].language_id.value;
		argumentArray[0]   = document.frmDrugNameCommonLookupOtherCriteria.SQL_PH_DRUG_SEARCH_SELECT12.value+"'"+language_id+"'";
		argumentArray[1]   = dataNameArray ;
		argumentArray[2]   = dataValueArray ;
		argumentArray[3]   = dataTypeArray ;
		argumentArray[4]   = "1,2";
		argumentArray[5]   = target.value ;
		argumentArray[6]   = DESC_LINK ;
		argumentArray[7]   = CODE_DESC ;

		retVal =await  CommonLookup(getLabel("Common.Manufacturer.label","Common"), argumentArray );
		ret1=unescape(retVal);
		arr=ret1.split(",");
		
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		} 
		if(retVal != null && retVal != "" )  {
			target.value = arr[1] ;
		}
	}
	else if (objIdentify=='Name'){

		var nameType;
		target	=	document.frmDrugNameCommonLookupSearchCriteria.searchText.value;
		var titleToBeDisplayed = "";
		var id  = document.forms[0].locale.value;
		if (document.frmDrugNameCommonLookupSearchCriteria.search_by[0].checked){ 
			var GenericNameLookup =getLabel("Common.GenericNameLookup.label","Common")
			nameType	=	"G";
			titleToBeDisplayed = GenericNameLookup;
			argumentArray[0]   =document.frmDrugNameCommonLookupSearchCriteria.SQL_PH_DRUG_SEARCH_GENERIC.value+"'"+id+"'  ORDER BY 2";
		}
		else if (document.frmDrugNameCommonLookupSearchCriteria.search_by[1].checked){
			var DrugNameLookup =getLabel("ePH.DrugNameLookup.label","PH")
			nameType	=	"D";
			titleToBeDisplayed = DrugNameLookup;
			argumentArray[0]   ="SELECT DRUG_CODE code, DRUG_DESC description FROM PH_DRUG_LANG_VW PH_DRUG WHERE  UPPER(DISCONTINUED_YN)='N' AND UPPER(DRUG_CODE) LIKE UPPER(?) AND UPPER(DRUG_DESC) LIKE UPPER(?) AND UPPER(DRUG_YN)='Y' AND LANGUAGE_ID ='"+id+"' ORDER BY 2";			
		}
		else if (document.frmDrugNameCommonLookupSearchCriteria.search_by[2].checked){
			var TradeNameLookup =getLabel("ePH.TradeNameLookup.label","PH")
			nameType	=	"T";
			titleToBeDisplayed = TradeNameLookup;
    		argumentArray[0]   =document.frmDrugNameCommonLookupSearchCriteria.SQL_PH_DRUG_SEARCH_TRADE.value+"'"+id+"' ORDER BY 1";
		}
		//Added for MMS-DM-CRF-0177
		var pre_alloc_check = document.frmDrugNameCommonLookupSearchCriteria.pre_alloc_check.value;
		if(pre_alloc_check=="Y")
			{
			 if (document.frmDrugNameCommonLookupSearchCriteria.search_by[4].checked){
					var GenericTradeLookUp =getLabel("ePH.GenericName/TradeName.label","PH")
					nameType	=	"A";
					titleToBeDisplayed = GenericTradeLookUp;
		    		argumentArray[0]   =document.frmDrugNameCommonLookupSearchCriteria.SQL_PH_DRUG_SEARCH_GENERIC.value+"'"+id+"'";
		    		var generic_name =argumentArray[0];
		    		argumentArray[0] = generic_name + " UNION ALL " + document.frmDrugNameCommonLookupSearchCriteria.SQL_PH_DRUG_SEARCH_TRADE.value+"'"+id+"' ORDER BY 1";
		    		argumentArray[1]   = dataNameArray ;
		    		argumentArray[2]   = dataValueArray ;
		    		argumentArray[3]   = dataTypeArray ;
		    		argumentArray[4]   = "1,2,3,4";
		    		argumentArray[5]   = trimString(target); 
		    		argumentArray[6]   = DESC_LINK ; 
		    		argumentArray[7]   = DESC_CODE;
		    		retVal = await CommonLookupResults(titleToBeDisplayed,argumentArray);
					ret1=unescape(retVal);
					arr=ret1.split(",");
					if(arr[1]==undefined) 
					{
						arr[0]="";	
						arr[1]="";	
					} 
		    		if(retVal != null && retVal != "" )  {
		    			document.frmDrugNameCommonLookupSearchCriteria.code.value = arr[0];
		    			document.frmDrugNameCommonLookupSearchCriteria.searchText.value = arr[1];
		    			document.frmDrugNameCommonLookupSearchCriteria.generic_trade.value = arr[2];
		    			
		    			var bean_id		= formObj.bean_id.value ;
		    			var bean_name	= formObj.bean_name.value ;
		    			var xmlDoc="";
		    			var xmlHttp = new XMLHttpRequest();
		    			
		    			var code = document.frmDrugNameCommonLookupSearchCriteria.code.value;
		    			var generic_trade = document.frmDrugNameCommonLookupSearchCriteria.generic_trade.value;
		    			
		    			xmlStr	="<root><SEARCH " ;
		    			xmlStr += "code=\""+ code +"\" " ;
		    			xmlStr += "generic_trade=\""+ generic_trade +"\" " ;
		    			xmlStr +=" /></root>" ;
		    			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		    			xmlHttp.open( "POST", "DrugNameRelatedInfo.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&code="+code+"&generic_trade="+generic_trade+"&criteria=drugSearch" , false ) ;
		    			xmlHttp.send( xmlDoc ) ;
		    			eval(xmlHttp.responseText);
		    			
		    		 }
				}
			
			} //Added for MMS-DM-CRF-0177
		else{
		argumentArray[1]   = dataNameArray ;
		argumentArray[2]   = dataValueArray ;
		argumentArray[3]   = dataTypeArray ;
		argumentArray[4]   = "1,2";
		argumentArray[5]   = trimString(target) ;
		argumentArray[6]   = DESC_LINK ;
		argumentArray[7]   = DESC_CODE;

		retVal = await CommonLookup( titleToBeDisplayed, argumentArray );
		ret1=unescape(retVal);
		arr=ret1.split(",");
					if(arr[1]==undefined) 
					{
						arr[0]="";	
						arr[1]="";	
					} 
		if(retVal != null && retVal != "" )  {
			document.frmDrugNameCommonLookupSearchCriteria.code.value = arr[0];
			document.frmDrugNameCommonLookupSearchCriteria.searchText.value = arr[1];
		 }
	   } //Added for MMS-DM-CRF-0177
	}
}
function displayLegend(obj,identity){
	
	var formObj=document.getElementById('frmDrugNameCommonLookupSearchCriteria');
	//document.frmDrugNameCommonLookupSearchCriteria.code.value	=	"";
	//document.frmDrugNameCommonLookupSearchCriteria.searchText.value	=	"";
	if (obj.value=="G"){
		formObj.querySelector('[name="tdname"]').innerText=getLabel("Common.GenericName.label","Common");
		formObj.btnSearch.disabled = false;
	}
	else if (obj.value=="D"){
		formObj.querySelector('[name="tdname"]').innerText=getLabel("Common.DrugName.label","Common");
		formObj.btnSearch.disabled = false;
	}
	else if (obj.value=="T"){
		formObj.querySelector('[name="tdname"]').innerText=getLabel("Common.TradeName.label","Common");
		formObj.btnSearch.disabled = false;
	}
	else if (obj.value=="A"){
		formObj.querySelector('[name="tdname"]').innerText=getLabel("Common.name.label","Common");
		formObj.btnSearch.disabled = true;
	}
	else if (obj.value=="C"){
		formObj.querySelector('[name="tdname"]').innerText=getLabel("ePH.CommonName.label","PH");
		formObj.btnSearch.disabled = true;
	}

	/*if (identity=="MedicationOrder" && obj.value=="D"){
		formObj.imgMandatory.style.visibility="hidden";
	}
	else{*/
		formObj.imgMandatory.style.visibility="visible";
	//}
}

function searchBasedOnCriteria(obj,identity,normalRx_yn){//normalRx_yn added for GHL-CRF-0549
	var formObj1=document.frmDrugNameCommonLookupSearchCriteria;
	var formObj2=document.frmDrugNameCommonLookupOtherCriteria;

	if (identity=="MedicationOrder")
		priviligeCheck = document.frmDrugNameCommonLookupSearchCriteria.priviligeCheck.options[document.frmDrugNameCommonLookupSearchCriteria.priviligeCheck.selectedIndex].value;
	if (formObj2!=undefined){
		//alert("searchbutton  1")
		var bean_id		= formObj2.bean_id.value ;
		var bean_name	= formObj2.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();

		xmlStr	="<root><SEARCH " ;
		xmlStr += "non_essential_restricted=\""+ formObj2.non_essential_restricted.value +"\" " ;
		xmlStr += "drug_type=\""+ formObj2.drug_type.value +"\" " ;
		xmlStr += "ingredient=\""+ formObj2.ingredient.value +"\" " ;
		xmlStr += "fluid=\""+ formObj2.fluid.value +"\" " ;
		xmlStr += "compound=\""+ formObj2.compound.value +"\" " ;
		xmlStr += "affects_pregnancy=\""+ formObj2.affects_pregnancy.value +"\" " ;
		xmlStr += "affects_lab_results=\""+ formObj2.affects_lab_results.value +"\" " ;
		xmlStr += "affects_breast_feed=\""+ formObj2.affects_breast_feed.value +"\" " ;
		xmlStr += "formulary=\""+ formObj2.formulary.value +"\" " ;
		xmlStr += "drug_class=\""+ formObj2.drug_class.value +"\" " ;
		xmlStr += "schedule_id=\""+ formObj2.schedule_id.value +"\" " ;
		xmlStr += "scope=\""+ formObj2.scope.value +"\" " ;
//		xmlStr += "disp_locn=\""+ formObj2.disp_locn.value +"\" " ;
		xmlStr += "manufacturer_short_name=\""+ formObj2.manufacturer_short_name.value +"\" " ;
		xmlStr += "manufacturer_code=\""+ formObj2.manufacturer_code.value +"\" " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "DrugNameRelatedInfo.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&criteria=Other&normalRx_yn="+normalRx_yn , false ) ;//normalRx_yn added for GHL-CRF-0549
		xmlHttp.send( xmlDoc ) ;
		const dialogTag = parent.document.getElementById("dialog_tag");    
	    dialogTag.close();
	}
	if (formObj1!==undefined){
		//alert("searchbutton 2")
		//alert("identity 2"+identity)
		var bean_id		= formObj1.bean_id.value ;
		var bean_name	= formObj1.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		//changes made for SRR20056-SCF-7624 IN27753 - Start
		var searchBy = "A";
		var label = getLabel("Common.name.label","Common");

		if (formObj1.search_by[0].checked){
			label =getLabel("Common.GenericName.label","Common")
			searchBy	=	"G";
		}
		else if (formObj1.search_by[1].checked){
			label =getLabel("Common.DrugName.label","Common")
			searchBy	=	"D";
		}
		else if (formObj1.search_by[2].checked){
			label =getLabel("Common.TradeName.label","Common")
			searchBy	=	"T";
		}
		else if (formObj1.search_by[3].checked){
			label =getLabel("ePH.CommonName.label","PH")
			searchBy	=	"C";
		}
		
		var pre_alloc_check = formObj1.pre_alloc_check.value;
		var default_disp_locn_select_yn = "";
		if(formObj1.default_disp_locn_select_yn)
			default_disp_locn_select_yn = formObj1.default_disp_locn_select_yn.value;//Added for TFS id:-16341
		var GenericTradeLookUp =getLabel("ePH.GenericName/TradeName.label","PH")
		if(pre_alloc_check=="Y")
			{
			if (formObj1.searchText.value == "" ){
				var msg = getMessage("CAN_NOT_BE_BLANK","Common")
			    msg = msg.replace('$', GenericTradeLookUp);
				alert(msg);
				formObj1.searchText.focus();
				return false;
			}
    		else if(formObj1.searchText.value.length <3){
    			var msg = getMessage("PH_DRG_SCH_ALL_CHAR", "PH");
    		    msg = msg.replace('$', GenericTradeLookUp);
    			alert(msg);
    			formObj1.searchText.focus();
    			return false;
    		}
		}	
		else
		{
	    	if (formObj1.searchText.value == "" ){
				//alert("APP-000001 "+label+" "+getLabel("Common.Cannotbeblank.label","Common"));
				var msg = getMessage("CAN_NOT_BE_BLANK","Common")
			    msg = msg.replace('$', label);
				alert(msg);
				formObj1.searchText.focus();
				return false;
			}
			else if(formObj1.searchText.value.length <3){
				var msg = getMessage("PH_DRG_SCH_ALL_CHAR", "PH");
			    msg = msg.replace('$', label);
				alert(msg);
				formObj1.searchText.focus();
				return false;
			}//changes made for SRR20056-SCF-7624 IN27753 - End
		}
		//Added for TFS id:-16341 start
		//if(pre_alloc_check=="Y" && default_disp_locn_select_yn=="Y"){ //commented for NMC-JD-CRF-0197

		if(default_disp_locn_select_yn=="Y") {

			var DispLocation =getLabel("ePH.DispenseLocation.label","PH")
			if (formObj1.default_disp_locn && formObj1.default_disp_locn.value == "" ){
				var msg = getMessage("CAN_NOT_BE_BLANK","Common");
			   msg = msg.replace('$', DispLocation);
				alert(msg);
				//formObj1.searchText.focus();
				return false;
			}
		}
		//}
		//Added for TFS id:-16341 end
		/* This is commented for SRR20056-SCF-7624 IN27753  this commented part is same in both identity=="General" and identity=="MedicationOrder", the same   brought in general as above.
		if(identity=="General"){
			if (formObj1.search_by[0].checked){
				var GenericName =getLabel("Common.GenericName.label","Common")
				searchBy	=	"G";
				label	=	GenericName;
			}
			else if (formObj1.search_by[1].checked){
				var DrugName =getLabel("Common.DrugName.label","Common")
				searchBy	=	"D";
				label	=	DrugName;
			}
			else if (formObj1.search_by[2].checked){
				var TradeName =getLabel("Common.TradeName.label","Common")
				searchBy	=	"T";
				label	=	TradeName;
			}
			else if (formObj1.search_by[3].checked){
				searchBy	=	"A";
				label	=	"Name";
			}
			if(formObj1.search_by[3].checked){
				if(formObj1.searchText.value.length <3){
					alert(getMessage("PH_DRG_SCH_ALL_CHAR","PH"));
					formObj1.searchText.focus();
					return false;
				}
			}
			else if (formObj1.searchText.value == ""){
				alert("APP-000001 "+label+getLabel("Common.Cannotbeblank.label","Common"));
				formObj1.searchText.focus();
				return false;
			}
			
		}
		else  This is commented for SRR20056-SCF-7624 IN27753 -End*/
		if (identity=="MedicationOrder"){
		/*	This is commented for SRR20056-SCF-7624 IN27753 -Start
    	if (formObj1.searchText.value == "" ){
				label =getLabel("Common.name.label","Common")
				if (formObj1.search_by[0].checked){
					label =getLabel("Common.GenericName.label","Common")
					searchBy	=	"G";
				}
				else if (formObj1.search_by[1].checked){
					label =getLabel("Common.DrugName.label","Common")
					searchBy	=	"D";
				}
				else if (formObj1.search_by[2].checked){
					label =getLabel("Common.TradeName.label","Common")
					searchBy	=	"T";
				}
				alert("APP-000001 "+label+" "+getLabel("Common.Cannotbeblank.label","Common"));
				formObj1.searchText.focus();
				return false;
			}
			else if(formObj1.searchText.value.length <3){
				alert(getMessage("PH_DRG_SCH_ALL_CHAR","PH"));
				formObj1.searchText.focus();
				return false;
			}		
			 This is commented for SRR20056-SCF-7624 IN27753 -End*/
			var res_by_service="";
			if(formObj1.res_by_service.checked==true){
				res_by_service="Y";
			}else{
				res_by_service="N";
			}

			var in_formulary_yn="";
			if(formObj1.in_formulary_yn.checked==true){
				in_formulary_yn="Y";
			}else{
				in_formulary_yn="N";
			}

			xmlStr += "order_type_code=\""+ formObj1.order_type.value +"\" " ;
			xmlStr += "res_by_service=\""+ res_by_service +"\" " ;
			xmlStr += "service_code=\""+ formObj1.service_code.value +"\" " ;
			xmlStr += "in_formulary_yn=\""+ in_formulary_yn +"\" " ;
			xmlStr += "priviligeCheck=\""+ priviligeCheck +"\" " ;
		/*	This is commented for SRR20056-SCF-7624 IN27753 -Start
			if (formObj1.search_by[0].checked)
				searchBy	=	"G";
			else if (formObj1.search_by[1].checked)
				searchBy	=	"D";
			else if (formObj1.search_by[2].checked)
				searchBy	=	"T";
			else if (formObj1.search_by[3].checked)
				searchBy	=	"A";
			 This is commented for SRR20056-SCF-7624 IN27753 -End*/
		}
		xmlStr += "identity=\""+ identity +"\" " ;
		xmlStr += "search_by=\""+ searchBy +"\" " ;
		xmlStr += "code=\""+ formObj1.code.value +"\" " ;
		//xmlStr += "name=\""+ checkSpl(formObj1.searchText.value) +"\" " ;
		xmlStr += "name=\""+ encodeURIComponent(formObj1.searchText.value) +"\" " ;
		if(formObj1.form_desc.value==""){
			 formObj1.form_code.value="";
		}
		xmlStr += "form_code=\""+ formObj1.form_code.value +"\" " ;		
		xmlStr += "strength_value=\""+ formObj1.strength_value.value +"\" " ;
		xmlStr += "strength_uom=\""+ formObj1.strength_uom.value +"\" " ;
		if(formObj1.route_desc.value==""){
			 formObj1.route_code.value="";
		}
		xmlStr += "route_code=\""+ formObj1.route_code.value +"\" " ;
		xmlStr += "drug_search_by=\""+ formObj1.drug_search_by.value +"\" " ;
		/* code added for Bru-HIMS-CRF-070 [IN029935] --Start --*/
		if(formObj1.npb_drug != undefined && formObj1.npb_drug.checked == true )
			xmlStr += "npb_drug=\""+ formObj1.npb_drug.value +"\" " ;
		else
			xmlStr += "npb_drug='D' " ;
		/* code added for Bru-HIMS-CRF-070 [IN029935] --End --*/		
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		//alert("load"+xmlStr)

		xmlHttp.open( "POST", "DrugNameRelatedInfo.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&criteria=Main&normalRx_yn="+normalRx_yn, false ) ; //normalRx_yn added for GHL-CRF-0549
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
		//alert(xmlHttp.responseText);
	}
}

function showSearchResults(normalRx_yn){ //normalRx_yn added for GHL-CRF-0549

	parent.lookup_footer.location.href = "../../ePH/jsp/DrugNameCommonLookupResult.jsp?searchBasedOn=Drug&identity="+document.getElementById('identity').value+"&bean_id="+document.getElementById('bean_id').value+"&priviligeCheck="+priviligeCheck+"&normalRx_yn="+normalRx_yn; //normalRx_yn added for GHL-CRF-0549
}
function searchBasedOnCriteriaForAlternate(alternateOrder){//added for  JD-CRF-0198 [IN:058599]
	parent.lookup_footer.location.href = "../../ePH/jsp/DrugNameCommonLookupResult.jsp?searchBasedOn=Drug&identity="+document.frmDrugNameCommonLookupSearchCriteria.identity.value+"&bean_id="+document.frmDrugNameCommonLookupSearchCriteria.bean_id.value+"&alternateOrder="+alternateOrder;
}//added for  JD-CRF-0198 [IN:058599]
function callDrugDetailsDisplay(drug_code){

	loadPage(drug_code);
}
function DrugSearchModify(obj,generic_name,generic_id,strength_value,strength_uom_desc,form_code,route_code,pres_base_uom,drug_code, trade_code, trade_name, index,from_alt_screen_yn){ //from_alt_screen_yn added for GHL-CRF-0549
	var drugPrivilige = document.getElementById('priviligeCheck_fromSearch').value;
	var identity1 = document.getElementById('identity').value;
	var drug_desc = "document.frmDrugNameCommonLookupResult.drug_desc";
	if (identity1 == "MedicationOrder"){
		orderingPrivilige1 = "document.frmDrugNameCommonLookupResult.previligeGroupDrug_ordering_YN";
		orderingPrivilige = orderingPrivilige1+index.value
		if (identity1 == "MedicationOrder" && drugPrivilige =='A' && orderingPrivilige =='N'){ 
			alert(getMessage("INSUFFICIENT_PRIVILEGE_FOR_ORDERING_THE_DRUG","PH"));
			return false;
		}
	}
	msg=true;
	checkforpromptalertmsg(drug_code);
	if(msg==true){
		var identity=document.frmDrugNameCommonLookupResult.identity.value;
		var drugorfluid = document.frmDrugNameCommonLookupResult.drugorfluid.value;
		var retVal = "";
		var message="";
		if(identity == "MedicationOrder"){
			var diagnosis_found_yn = eval("document.frmDrugNameCommonLookupResult.diagnosis_found_yn"+index).value;
			var appl_for_age_grp_yn = eval("document.frmDrugNameCommonLookupResult.appl_for_age_grp_yn"+index).value;
			if(diagnosis_found_yn =='N'){
				message = getMessage("REQ_DIAG_PRES_NOT_FOUND",'PH');
			}
			if(appl_for_age_grp_yn =='N'){
				message =message+"\n"+getMessage("DRUG_NOT_APPL_TO_PAT_AGE_GRP",'PH');
			}
			if(message !=""){
				alert(message);
				return false;
			}
		}
		
		if(identity!="MedicationOrder"){
			//retVal=obj.children(0).value + ":::" + eval(drug_desc+index).value+":::"+generic_id+":::"+generic_name+":::"+trade_code+":::"+trade_name ;
			retVal=drug_code + ":::" + eval(drug_desc+index).value+":::"+generic_id+":::"+generic_name+":::"+trade_code+":::"+trade_name ; //drug_code modified for TFS-12457
		}
		else if(identity=="MedicationOrder" && (drugorfluid=="F" || drugorfluid=="IVF" || drugorfluid=="C" ) ){
			//retVal=obj.children(0).value+":::"+ obj.children(4).innerText+":::"+form_code+":::"+route_code+":::"+pres_base_uom+":::"+trade_code+":::"+trade_name;
			retVal=drug_code+":::"+ " "  +":::"+form_code+":::"+route_code+":::"+pres_base_uom+":::"+trade_code+":::"+trade_name; //drug_code modified and obj.children(4).innerText removed for TFS-12457
		}
		else if(drugorfluid=="C"){
			retVal=obj.children[0].value+":::"+ obj.children[4].innerText+":::"+form_code+":::"+route_code+":::"+pres_base_uom+":::"+trade_code+":::"+trade_name;
		}
		else {
			if(from_alt_screen_yn=="Y")
					retVal=drug_code+":::"+trade_code+":::"+trade_name; 
				
			else{
				var sel_drug_code=obj.children[0].value;
				if(sel_drug_code==undefined) //added for NMC-JD-SCF-0010
					sel_drug_code = drug_code;
				
				//alert(obj.children(0).name);
					retVal=sel_drug_code+":::"+trade_code+":::"+trade_name; 
			}


		}
		/*else{
			retVal=obj.children(0).value+":::"+obj.children(2).innerText+":::"+strength_value+":::"+strength_uom_desc;
		}*/
        if(parent.parent.document.getElementById('dialog-body'))
        {
		/*let dialogBody = parent.parent.document.getElementById('dialog-body');
	    dialogBody.contentWindow.returnValue = retVal;
	   // closew();
	   var dialogTag = parent.parent.document.getElementById("dialog_tag");    
       dialogTag.close();*/
        parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue=retVal;
    	parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();
        }
	     
	}
}
//GHL-CRF-0549 - start
function DrugSearchModify1(obj,generic_name,generic_id,strength_value,strength_uom_desc,form_code,route_code,pres_base_uom,drug_code, trade_code, trade_name, index,from_alt_screen_yn){
	var drugPrivilige = document.frmDrugNameCommonLookupResult.priviligeCheck_fromSearch.value;
	var identity1 = document.frmDrugNameCommonLookupResult.identity.value;
	var drug_desc = "document.frmDrugNameCommonLookupResult.drug_desc";
	if (identity1 == "MedicationOrder"){
		orderingPrivilige1 = "document.frmDrugNameCommonLookupResult.previligeGroupDrug_ordering_YN";
		orderingPrivilige = eval(orderingPrivilige1+index).value
		if (identity1 == "MedicationOrder" && drugPrivilige =='A' && orderingPrivilige =='N'){ 
			alert(getMessage("INSUFFICIENT_PRIVILEGE_FOR_ORDERING_THE_DRUG","PH"));
			return false;
		}
	}
	msg=true;
	checkforpromptalertmsg(drug_code);
	if(msg==true){
		var identity=document.frmDrugNameCommonLookupResult.identity.value;
		var drugorfluid = document.frmDrugNameCommonLookupResult.drugorfluid.value;
		var retVal = "";
		var message="";
		if(identity == "MedicationOrder"){
			var diagnosis_found_yn = eval("document.frmDrugNameCommonLookupResult.diagnosis_found_yn"+index).value;
			var appl_for_age_grp_yn = eval("document.frmDrugNameCommonLookupResult.appl_for_age_grp_yn"+index).value;
			if(diagnosis_found_yn =='N'){
				message = getMessage("REQ_DIAG_PRES_NOT_FOUND",'PH');
			}
			if(appl_for_age_grp_yn =='N'){
				message =message+"\n"+getMessage("DRUG_NOT_APPL_TO_PAT_AGE_GRP",'PH');
			}
			if(message !=""){
				alert(message);
				return false;
			}
		}
		
		if(identity!="MedicationOrder"){
			
			retVal=obj.children[0].value + ":::" + eval(drug_desc+index).value+":::"+generic_id+":::"+generic_name+":::"+trade_code+":::"+trade_name ;
		}
		else if(identity=="MedicationOrder" && (drugorfluid=="F" || drugorfluid=="IVF" || drugorfluid=="C" ) ){
			
			retVal=obj.children[0].value+":::"+ obj.children[4].innerText+":::"+form_code+":::"+route_code+":::"+pres_base_uom+":::"+trade_code+":::"+trade_name;
		}
		else if(drugorfluid=="C"){
			retVal=obj.children[0].value+":::"+ obj.children[4].innerText+":::"+form_code+":::"+route_code+":::"+pres_base_uom+":::"+trade_code+":::"+trade_name;
		}
		else {
			if(from_alt_screen_yn=="Y"){ 
					retVal=drug_code+":::"+trade_code+":::"+trade_name; 
			}else{
					retVal=obj.children[0].value+":::"+trade_code+":::"+trade_name; 
			}   //Added for TFS-16341

		}


		let dialogBody = parent.parent.document.getElementById('dialog-body');
	    dialogBody.contentWindow.returnValue = retVal;
	    //closew();
		var dialogTag = parent.parent.parent.document.getElementById("dialog_tag");    
        dialogTag.close();
	}
} // GHL-CRF-0549 - end

function SubmitLinkForDrug(from,to){
	document.frmDrugNameCommonLookupResult.from.value = from;
	document.frmDrugNameCommonLookupResult.to.value = to;
	document.frmDrugNameCommonLookupResult.searchBasedOn.value = "Drug";
	//document.frmDrugNameCommonLookupResult.priviligeCheck.value = priviligeDrugcheck;
	document.frmDrugNameCommonLookupResult.priviligeCheck.value = document.frmDrugNameCommonLookupResult.priviligeCheck_fromSearch.value
	document.frmDrugNameCommonLookupResult.submit();
}

function SubmitLinkForATC(from,to,Classification){
	
	document.frmDrugNameCommonLookupResult.from.value = from;
	document.frmDrugNameCommonLookupResult.to.value = to;
	document.frmDrugNameCommonLookupResult.searchBasedOn.value = "ATC";
	document.frmDrugNameCommonLookupResult.Classification.value = Classification;
	document.frmDrugNameCommonLookupResult.submit();
}

function clearCodeRelatedFields(obj){
	var formObj=document.frmDrugNameCommonLookupSearchCriteria;
	formObj.code.value="";
	var pre_alloc_yn = formObj.pre_alloc_check.value; //Added for NMC-JD-SCF-0159 -Start
	if(pre_alloc_yn=="Y")
		{
			var bean_id		= formObj.bean_id.value ;
			var bean_name	= formObj.bean_name.value ;
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			xmlStr	="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "DrugNameRelatedInfo.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&criteria=cleargenericcode" , false ) ;
			xmlHttp.send( xmlDoc ) ;
			eval(xmlHttp.responseText);   //Added for NMC-JD-SCF-0159 -End
		}
}

function storeSelectedDrugs(i,objval){
	drugPrivilige = document.frmDrugNameCommonLookupResult.priviligeCheck_fromSearch.value;
	identity1 = document.frmDrugNameCommonLookupResult.identity.value;
	if (identity1 == "MedicationOrder"){
		orderingPrivilige1 = "document.frmDrugNameCommonLookupResult.previligeGroupDrug_ordering_YN";
		orderingPrivilige = eval(orderingPrivilige1+i).value
		if (identity1 == "MedicationOrder" && drugPrivilige =='A' && orderingPrivilige =='N'){
			alert(getMessage("INSUFFICIENT_PRIVILEGE_FOR_ORDERING_THE_DRUG","PH"));
		document.getElementById('drugSelect'+i).checked = false;
			return false;
		}
	}
	var formObj		= document.frmDrugNameCommonLookupResult;
	var bean_id		= formObj.bean_id.value ;
	var bean_name	= formObj.bean_name.value ;
	var diagnosis_found_yn	= eval("formObj.diagnosis_found_yn"+i).value;
	var appl_for_age_grp_yn	= eval("formObj.appl_for_age_grp_yn"+i).value;
	var message = "";
	if(diagnosis_found_yn =='N'){
		message = getMessage("REQ_DIAG_PRES_NOT_FOUND",'PH');
	}
	if(appl_for_age_grp_yn =='N'){
		message =message+"\n"+getMessage("DRUG_NOT_APPL_TO_PAT_AGE_GRP",'PH');
	}
	if(message !=""){
		alert(message);
		document.getElementById('drugSelect'+i).checked = false;
		return false;
	}

	if( document.getElementById('drugSelect'+i).checked==true){
		msg=true;
		checkforpromptalertmsg(objval.value);
	}
	if(msg!=false ){
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();

		xmlStr	="<root><SEARCH " ;
		var len = document.getElementById('resultTable').rows.length-1;
		for (var i=1;i<=len ;i++ ){

			if(document.getElementById('drugSelect'+i).checked==true && document.getElementById('drugSelect'+i).disabled==false){
				xmlStr += "drug_code"+i+"=\""+ eval("formObj.drug_code"+i).value +"\" " ;
				xmlStr += "line_no"+i+"=\""+ eval("formObj.line_no"+i).value +"\" " ;
				xmlStr += "trade_code"+i+"=\""+ eval("formObj.trade_code"+i).value +"\" " ;
				xmlStr += "trade_name"+i+"=\""+ eval("formObj.trade_name"+i).value +"\" " ;
				//	xmlStr += "fluid_ingredient_flag"+i+"=\""+ eval("formObj.all.fluid_ingredient_flag"+i).value +"\" " ;
				xmlStr += "select"+i+"=\"E\" " ;
			}
			else{
				xmlStr += "drug_code"+i+"=\""+ eval("formObj.drug_code"+i).value +"\" " ;
				xmlStr += "line_no"+i+"=\""+ eval("formObj.line_no"+i).value +"\" " ;
				//	xmlStr += "fluid_ingredient_flag"+i+"=\""+ eval("formObj.all.fluid_ingredient_flag"+i).value +"\" " ;
				xmlStr += "select"+i+"=\"D\" " ;
			}
		}
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "DrugNameRelatedInfo.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&criteria=StoreDrugs" , false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
	}
	else{
		document.getElementById('drugSelect'+i).checked=false;
	}
}

function enableDisableSelectButton(objValue){
	var formObj		= document.frmDrugNameCommonLookupResult;
	if(objValue=="false")
		formObj.btnSelect.disabled=false;
	else
		formObj.btnSelect.disabled=true;
}
function returnAllSelectedDrugs(){
	var formObj		= document.frmDrugNameCommonLookupResult;
	var bean_id		= formObj.bean_id.value ;
	var bean_name	= formObj.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "DrugNameRelatedInfo.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&criteria=getSelectedDrugs" , false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
}
function returnDrugs(selectedDrugs){
	while(selectedDrugs.indexOf("[") != -1){
		selectedDrugs = selectedDrugs.replace("[", "");
		selectedDrugs = selectedDrugs.replace(", ],", ", ,");
		selectedDrugs = selectedDrugs.replace(", ]]", ",");
		selectedDrugs = selectedDrugs.replace("],", ",");
		selectedDrugs = selectedDrugs.replace("]", "");
	}

	var drugs= selectedDrugs.split(",");
	var returnedDrugs="";

	Outer: for (var i=0;i<drugs.length ;i+=3 ){
		Inner:	for(var j=i+3;j<drugs.length;j+=3){
					if(trimString(drugs[i]) !=""){
						if(trimString(drugs[i])==trimString(drugs[j])){
							continue Outer;
						}
					}
				}
			returnedDrugs += trimString(drugs[i])+":::"+trimString(drugs[i+1])+":::";
			if((i+3)==drugs.length)
				returnedDrugs += trimString(drugs[i+2]);
			else
				returnedDrugs += trimString(drugs[i+2])+":::";
	}
	parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue = returnedDrugs;
	parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();
	
	//parent.parent.parent.parent.window[2].document.getElementById('dialog-body').contentWindow.returnValue = returnedDrugs;
	//parent.parent.parent.parent.window[2].document.getElementById('dialog_tag').close(); 
	
}

function CheckZero(obj){
	if(obj.value != ""){
		if(obj.value==0)	{
			alert(getMessage("VALUE_SHOULD_BE_GR_ZERO","Common"));
			obj.select();
			obj.focus();
		}
	}
}
function defaultSearchBy(search_by){
	if(search_by=="G")
		parent.lookup_header.frmDrugNameCommonLookupSearchCriteria.search_by[0].checked=true;
	else if(search_by=="D")
		parent.lookup_header.frmDrugNameCommonLookupSearchCriteria.search_by[1].checked=true;
	else if(search_by=="T")
		parent.lookup_header.frmDrugNameCommonLookupSearchCriteria.search_by[2].checked=true;
	else if(search_by=="C")
		parent.lookup_header.frmDrugNameCommonLookupSearchCriteria.search_by[3].checked=true;
	else if(search_by=="A")
		parent.lookup_header.frmDrugNameCommonLookupSearchCriteria.search_by[4].checked=true;
}

async function displayStock(drug_code,drug_name, trade_code,curr_store_desc,curr_store_code) {

	var bean_id	=	document.getElementById("bean_id").value;
		var dialogHeight	= "80vh";
		var dialogWidth		= "80vw";
		var dialogTop		= "";
		var dialogLeft		= "";
		var center			= "0";
		var status			= "no";
		var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments		= "";
		retVal 				= await window.showModalDialog("../../ePH/jsp/DrugSearchStockDetails.jsp?bean_id="+bean_id+"&drug_code="+drug_code+"&drug_desc="+drug_name+"&trade_code="+trade_code+"&curr_store_code="+curr_store_code+"&curr_store_desc="+curr_store_desc,arguments,features);
}
//strength_value AND drug_strength_uom added for ghl-crf-0548
async function displayAlternateDrugs(drug_code,store_code,drug_name,generic_id,route_code,identity, drug_class,order_type_code,STORE_CODE, patient_id, encounter_id,strength_value,drug_strength_uom,click_drug_name_yn,item_type_site_app){//added click_drug_name_yn for GHL-CRF-0549

	var bean_id = document.frmDrugNameCommonLookupResult.bean_id.value;
	var dialogHeight= "70vh" ;
	var dialogWidth	= "80vw" ;
	var dialogTop	= "";
	var dialogLeft	= "";
	var center		= "0";
	var status		= "no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	//alert("../../ePH/jsp/DrugSearchAlternateDrugs.jsp?bean_id="+bean_id+"&drug_code="+drug_code+"&store_code="+store_code+"&drug_name="+drug_name+"&generic_id="+generic_id+"&route_code="+route_code+"&drug_class="+drug_class+"&order_type_code="+order_type_code+" &identity="+identity+"&STORE_CODE="+STORE_CODE,arguments,features);
	//stringth_value added for ghl-crf-0548
	var	retVal 		= await top.window.showModalDialog("../../ePH/jsp/DrugSearchAlternateDrugs.jsp?bean_id="+bean_id+"&drug_code="+drug_code+"&store_code="+store_code+"&drug_name="+drug_name+"&generic_id="+generic_id+"&route_code="+route_code+"&drug_class="+drug_class+"&order_type_code="+order_type_code+" &identity="+identity+"&STORE_CODE="+STORE_CODE+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&strength_value="+strength_value+"&drug_strength_uom="+drug_strength_uom+"&click_drug_name_yn="+click_drug_name_yn,arguments,features);
//added for GHL-CRF-0549
	if(retVal!=undefined){
		window.returnValue = retVal;	
		window.close();
		
	}else{
		if(item_type_site_app==true || item_type_site_app=="true")
			eval("document.frmDrugNameCommonLookupResult.drug_clicked"+drug_code).value = "Y";
	}

}

async function showDrugInfo(external_product_id,drug_desc){
	var dialogHeight	="700px" ;
	var dialogWidth	="900px";
	var dialogTop	= "110" ;
	var dialogLeft	= "80" ;
	var center		= "0" ;
	var status		= "no";
	var features	= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	var retVal		= await window.showModalDialog("../../ePH/jsp/DisplayDrugInfoFrames.jsp?extprodid="+external_product_id+"&drugdesc="+drug_desc+"&JSFile=../../ePH/js/Prescription_1.js",arguments,features);
}

function checkforpromptalertmsg(drug_code){
		var formObj		= document.frmDrugNameCommonLookupResult;
		//var bean_id		= formObj.bean_id.value ; // commented for MMS-DM-CRF-0112
		//var bean_name	= formObj.bean_name.value ; // commented for MMS-DM-CRF-0112
		var bean_id		= ""; // Added for MMS-DM-CRF-0112 - Start
		var bean_name	= ""; 
		if(formObj=="undefined" || formObj==undefined){
			bean_name  = "ePH.DrugSearchBean";
			bean_id	   = "DrugSearchBean";
		}
		else{
			bean_id=  formObj.bean_id.value ;
			bean_name = formObj.bean_name.value ; 
		} // Added for MMS-DM-CRF-0112 - End
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();

		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "DrugNameRelatedInfo.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&drug_code="+drug_code+"&criteria=checkforpromptalertmsg" , false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
}

function returncheckforpromptalertmsg(promptalertmsg){   
	msg=confirm(decodeURIComponent(promptalertmsg));
}	

async function searchform(){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	var formObj		   = document.frmDrugNameCommonLookupSearchCriteria;
	var id  = document.forms[0].locale.value;
	//argumentArray[0]   = "SELECT FORM_CODE CODE, FORM_DESC DESCRIPTION FROM PH_FORM_LANG_VW PH_FORM WHERE EFF_STATUS='E' and upper(FORM_CODE) like upper(?) and upper(FORM_DESC) like upper(?) AND LANGUAGE_ID = '"+id+"' ORDER BY 2";
	argumentArray[0]   = formObj.SQL_PH_DRUG_SEARCH_FORM.value+"'"+id+"' ORDER BY 2";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = formObj.form_desc.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 	
	retVal = await CommonLookup(getLabel("ePH.Form.label","PH"), argumentArray );
	var ret1=unescape(retVal);	
	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal != null && retVal != "" )  {
		formObj.form_desc.value = arr[1] ;
		formObj.form_code.value = arr[0];
	}
}

async function searchroute(){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	var formObj		   = document.frmDrugNameCommonLookupSearchCriteria;
	var id  = document.forms[0].locale.value;
	//argumentArray[0]   = "SELECT ROUTE_CODE CODE, ROUTE_DESC DESCRIPTION FROM PH_ROUTE_LANG_VW PH_ROUTE WHERE EFF_STATUS='E' and upper(ROUTE_CODE) like upper(?) and upper(ROUTE_DESC) like upper(?) AND LANGUAGE_ID = '"+id+"' ORDER BY 2"
	argumentArray[0]   = formObj.SQL_PH_DRUG_SEARCH_ROUTE.value+"'"+id+"' ORDER BY 2";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = formObj.route_desc.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 	
	retVal = await CommonLookup(getLabel("Common.Route.label","Common"), argumentArray );	
	var ret1=unescape(retVal);	
	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal != null && retVal != "" )  {
		formObj.route_desc.value = arr[1] ;
		formObj.route_code.value = arr[0];
	}
}

function dispTitle(error_code, error_text, sys_message_id, row_count){
	if ((error_code == "10" && error_text!="") || sys_message_id!=""){
		if (error_code=="10" && error_text!=""){
			eval(document.getElementById("BL_ERROR"+row_count)).title = error_text;
		}
		if(sys_message_id!=""){
			error_text = getMessage(sys_message_id,'BL');
			eval(document.getElementById('BL_ERROR'+row_count)).title = error_text;
		}
	}
}

function showAlert(obj,generic_name,generic_id,strength_value,strength_uom_desc,form_code,route_code,pres_base_uom,drug_code, trade_code, trade_name, index){
	
if (!(confirm(getMessage("PREFERRED/DRUG_ITEM_INSRUCTION",'PH')))){
	DrugSearchModify(obj,generic_name,generic_id,strength_value,strength_uom_desc,form_code,route_code,pres_base_uom,drug_code, trade_code, trade_name, index);
	}

}

async function showPreferredDrugs(drug_code,billingPrefereneBasisInd,billingPreferredItemCode,searchBasedOn,identity,drugDesc,disp_charge_dtl_in_drug_lkp_yn,disp_price_type_in_drug_lkp,bl_install_yn,billingPriority){
	var bean_id = document.frmDrugNameCommonLookupResult.bean_id.value;
	var dialogHeight	="30" ;
	var dialogWidth		="65";
	var dialogTop		= "250" ;
	var dialogLeft		= "70" ;
	var center			= "0" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	var retVal		= await window.showModalDialog("../../ePH/jsp/DrugSearchPreferredDrugs.jsp?drugCode="+drug_code+"&bean_id="+bean_id+"&billing_preference_basis="+billingPrefereneBasisInd+"&item_code="+billingPreferredItemCode+"&searchBasedOn="+searchBasedOn+"&identity="+identity+"&drugDesc="+drugDesc+"&disp_charge_dtl_in_drug_lkp_yn="+disp_charge_dtl_in_drug_lkp_yn+"&disp_price_type_in_drug_lkp="+disp_price_type_in_drug_lkp+"&bl_install_yn="+bl_install_yn+"&billingPriority="+billingPriority,arguments,features);
	if (retVal != undefined){
		parent.window.close();
		top.window.returnValue = retVal;	
	}
}

function preferredDrugSearchModify(obj,generic_name,generic_id,strength_value,strength_uom_desc,form_code,route_code,pres_base_uom,drug_code, trade_code, trade_name, index){
	if (eval("document.frmDrugNameCommonLookupResult.previligeGroupDrug_ordering_YN"+index).value == 'N'){
		alert(getMessage("INSUFFICIENT_PRIVILEGE_FOR_ORDERING_THE_DRUG","PH"));
		return false;
	}
	
	msg=true;
	checkforpromptalertmsg(drug_code);
	if(msg==true){
		var identity=document.frmDrugNameCommonLookupResult.identity.value;
		var drugorfluid = document.frmDrugNameCommonLookupResult.drugorfluid.value;
		var retVal = "";
		var message="";
		if(identity == "MedicationOrder"){
			var diagnosis_found_yn = eval("document.frmDrugNameCommonLookupResult.diagnosis_found_yn"+index).value;
			var appl_for_age_grp_yn = eval("document.frmDrugNameCommonLookupResult.appl_for_age_grp_yn"+index).value;
			if(diagnosis_found_yn =='N'){
				message = getMessage("REQ_DIAG_PRES_NOT_FOUND",'PH');
			}
			if(appl_for_age_grp_yn =='N'){
				message =message+"\n"+getMessage("DRUG_NOT_APPL_TO_PAT_AGE_GRP",'PH');
			}
			if(message !=""){
				alert(message);
				return false;
			}
		}
	
		if(identity!="MedicationOrder"){
			retVal=obj.children(0).value + ":::" + obj.children(4).innerText+":::"+generic_id+":::"+generic_name ;
		}
		else if(identity=="MedicationOrder" && (drugorfluid=="F" || drugorfluid=="IVF" || drugorfluid=="C" ) ){

			retVal=obj.children(0).value+":::"+ obj.children(4).innerText+":::"+form_code+":::"+route_code+":::"+pres_base_uom+":::"+trade_code+":::"+trade_name;
		}
		else if(drugorfluid=="C"){
			retVal=obj.children(0).value+":::"+ obj.children(4).innerText+":::"+form_code+":::"+route_code+":::"+pres_base_uom+":::"+trade_code+":::"+trade_name;
		}
		else {
			retVal=obj.children(0).value+":::"+trade_code+":::"+trade_name;
			
		}
		/*else{
			retVal=obj.children(0).value+":::"+obj.children(2).innerText+":::"+strength_value+":::"+strength_uom_desc;
		}*/
		
		if (retVal != undefined){
			top.window.returnValue = retVal;	
			parent.window.close();			
		}
	}
}

function checkforpromptalertmsg1(drug_code){
	var formObj		= document.frmDrugNameCommonLookupResult1;
	var bean_id		= formObj.bean_id.value ;
	var bean_name	= formObj.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "DrugNameRelatedInfo.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&drug_code="+drug_code+"&criteria=checkforpromptalertmsg" , false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
}

function defaultSearchBy1(search_by){
	if(search_by=="G")
		parent.parent.lookup_header.frmDrugNameCommonLookupSearchCriteria.search_by[0].checked=true;
	else if(search_by=="D")
		parent.lookup_header.frmDrugNameCommonLookupSearchCriteria.search_by[1].checked=true;
	else if(search_by=="T")
		parent.lookup_header.frmDrugNameCommonLookupSearchCriteria.search_by[2].checked=true;
	else if(search_by=="A")
		parent.lookup_header.frmDrugNameCommonLookupSearchCriteria.search_by[3].checked=true;
}

function showAlertOnCheck(i,objval){
	var checkboxObj ="document.frmDrugNameCommonLookupResult.drugSelect"
	if (eval(checkboxObj+i).checked){
		if (!(confirm(getMessage("PREFERRED/DRUG_ITEM_INSRUCTION",'PH')))){
			storeSelectedDrugs(i,objval);
		}
	}
	else{
		eval("document.frmDrugNameCommonLookupResult.drugSelect"+i).checked = false;
		storeSelectedDrugs(i,objval);
	}
} 

//function allowAlternatewindow(item_type_site_app,drug_code){
	function allowAlternateWindow(drug_code,store_code,drug_name,generic_id,route_code,identity, drug_class,order_type_code,STORE_CODE, patient_id, encounter_id,strength_value,drug_strength_uom,click_drug_name_yn,item_type_site_app,generic_name,index,strength_value1,strength_uom_desc,form_code,route_code,pres_base_uom,drug_code, trade_code, trade_name,disp_alt_yn,npb_yn,mm_item_type_available,formulary_billing_app){//STREGTH-VALUE MODIFIED TO STRENGTH_VALUE1 FOR GHL-ICN-0035 and formulary_billing_grp added for GHL-CRF-0618
	var flag = true;
	
	if(item_type_site_app=="true" || item_type_site_app==true ){
		drug_clicked_yn= eval("document.frmDrugNameCommonLookupResult.drug_clicked"+drug_code).value ;
		//GHL-CRF-0618 - start
		if(formulary_billing_app==true || formulary_billing_app=="true")
			drug_clicked_yn = "N";
		//GHL-CRF-0618 - end
		if(drug_clicked_yn=="Y" || (disp_alt_yn=="N" && npb_yn=="N") || mm_item_type_available=="false"){
		DrugSearchModify(eval("document.getElementById(drug_name)"+i),generic_name,generic_id,strength_value,strength_uom_desc,form_code,route_code,pres_base_uom,drug_code, trade_code, trade_name, index,"Y")
		}
		else{
		 displayAlternateDrugs(drug_code,store_code,drug_name,generic_id,route_code,identity, drug_class,order_type_code,STORE_CODE, patient_id, encounter_id,strength_value,drug_strength_uom,click_drug_name_yn,item_type_site_app)
		//eval("document.getElementById("drug_name")"+i).onclick();
		}
		return flag;
	}
	else
		return flag;
return 
}
//GHL-CRF-0618 - start
async function formularyNonPreference(drug_code,patient_id,encounter_id,bean_id,bean_name){

		var dialogHeight= "12" ;
		var dialogWidth	= "32" ;
		var dialogTop = "195" ;
		var center = "1" ;
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+";scroll:no";
		var arguments	= "" ;
		retVal = await window.showModalDialog("../../ePH/jsp/PhNonPreferableRemarks.jsp?item_code="+drug_code+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&bean_id="+bean_id+"&bean_name="+bean_name+"&called_from=D",arguments,features);


		if(retVal!=undefined && retVal==true){
			return true;
		}else{
			return false;
		}


} //GHL-CRF-0618 - end
//added for ghl-crf-0619 start
function checkBrand(drug_code,patient_id,encounter_id,bean_id,bean_name,drug_desc){ 	
	//added for GHL-CRF-0619
	drug_desc= decodeURIComponent(drug_desc,"UTF-8"); //added for GHL-ICN-0090
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	var xmlStr = "<root><SEARCH /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml"); 
	xmlHttp.open( "POST", "DrugNameRelatedInfo.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&drug_code="+drug_code+"&encounter_id="+encounter_id+"&drug_desc="+drug_desc+"&patient_id="+patient_id+"&criteria=checkforBrand" , false ) ; //drug_desc added for GHL-SCF-0090 
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	eval(responseText);  
	if(result){
		if(remarks!=""){
		message = message +"\n" +" Remarks: "+remarks;

		}
			if(confirm("Selected Brand " + drug_desc_new + " is different from the last Brand " + message)){	 //drug_desc changed to drug_desc_new for GHL-SCF-0090
 				return true;
			}								
		else{ 
			return false;
		}		
	}
	else{
		return true;
	}
		
}
//added for GHL-CRF-0619
function assignResult(_result, _message, _flag, _invalidCode,_remarks,_drug_desc) { // _drug_desc ADDED for GHL-SCF-0090
	result = _result;
	message = _message;
	remarks = _remarks;
	drug_desc_new = _drug_desc  //ADDED for GHL-SCF-0090
	flag = _flag;
	if (_invalidCode == null) {
		_invalidCode = "";
	}
	invalidCode = _invalidCode;
}//end 

//Added for MMS-DM-CRF-0177
function saveFormCode(obj)
{
	var formObj		   = document.frmDrugNameCommonLookupSearchCriteria;
	formObj.form_code.value = obj.value;
}
//Added for MMS-DM-CRF-0177

//Added for MMS-DM-CRF-0177

async function CommonLookupResults(title,pArgumentArray)
{
	returnVal = new String();
	var dialogHeight= "30" ;
	var dialogWidth	= "50" ;
	var status = "no";

   var dialogUrl		= "../../ePH/jsp/DrugNameGenericCommonLookup.jsp?title="+title;
    	
    	pArgumentArray[9] = title;
 
    var dialogFeatures	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	var dialogArguments = pArgumentArray ;
	returnVal = await window.showModalDialog(dialogUrl,dialogArguments, dialogFeatures);
	
	if( returnVal == null || returnVal == "" )
		return "";
	else
		return returnVal.split("\"") ;
 }

function valtextNew(comp) {
    var txt=comp.value
    CallDescFrameNew(this);
}

function initializeTextNew() {
	chkBothCriteria = true ;
    var argArray = window.dialogArguments ;
    document.getElementById("search_text").value = argArray[5] ;
	
	var functionId = argArray[11];
	if(functionId == "DefaultSearchCriteria")
		document.forms[0].search_criteria.options.value = argArray[10] ;
	
    makeValidString( document.getElementById("search_text") ) ;
    if(argArray[5] !='' )
    {
        fromCalledPage = true
        CallDescFrameNew() ;
    }
}

function CallDescFrameNew() {
	var url = "../../ePH/jsp/DrugNameGenericCommonLookupResult.jsp?"+formQueryString();
    parent.lookup_detail.location.href = url;
}


function ModifyNew(indx){
    var argArray = window.dialogArguments ;
    var displayOrder    = argArray[7] ;
	var ret=eval("document.getElementById(hd_)"+indx).value;
	
	ret=ret.split("~");
    var code1=ret[1];
    var code2=ret[2];
    var code3=ret[3];
    
    if( displayOrder == DESC_CODE ) {
        var temp = code1;
        code1 = code2;
        code2 = temp ;
    }
    var retVal = code1 + "\"" + code2 + "\"" + code3;
    top.window.returnValue = retVal ;
    top.close()
}

function addListItem(listObject, code, text, selectedValue) {
	if (selectedValue == null) {
		selectedValue = "";
	}
	var listOption = createListOption(code, text, selectedValue);
	eval(listObject + ".add(listOption)");
}

function clearListItems(listObject) {
	var select_option = "---" + getLabel("Common.defaultSelect.label", "Common") + "---";
	var len = eval(listObject + ".options.length");
	for (i = 0; i < len; i++) {
		eval(listObject + ".remove(0)");
	}
	var listOption = createListOption("", select_option);
	eval(listObject + ".add(listOption)");
}

function createListOption(code, text, selectedValue) {
	var listOption = document.createElement("OPTION");
	listOption.text = text;
	listOption.value = code;
	if (code == selectedValue) {
		listOption.selected = true;
	}
	return listOption;
}

//Added for MMS-DM-CRF-0177

//Added for NMC-JD-SCF-0159 - Start
async function searchCodeNew(target,objIdentify)
{
	var formObj=document.frmDrugNameCommonLookupSearchCriteria;
	var pre_alloc_yn = formObj.pre_alloc_check.value;
	if(pre_alloc_yn=="Y")
		{
		await searchCode(target,objIdentify)
		}
	}
//Added for NMC-JD-SCF-0159 - End
//Added for TFS id:-16341 start
function setDefaultDispLocn(obj,bean_id,bean_name){

	var disp_locn_code=obj.value;

		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		var xmlStr = "<root><SEARCH /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml"); 
		xmlHttp.open( "POST", "DrugNameRelatedInfo.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&disp_locn_code="+disp_locn_code+"&criteria=setDispLocnCode" , false ) ; 
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);  
}
//Added for TFS id:-16341 end
