/*
---------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        		Description
---------------------------------------------------------------------------------------------------------------
07/09/2017	IN:065199		Mukesh M			Remarks added in Two lines shown in single line while clicking confirm button for medical item
05/10/2017	IN:064474	    Devindra			    GHL-CRF-0467		 
04/01/2019	IN:068345	    Devindra			     Required changes in item substitute mapping setup
29/05/2020	IN:072092	    Manickavasagam J			     GHL-CRF-0618		 
17/07/2020  IN:073201       Prabha         					SKR-SCF-1342
03/10/2023	  	50818  		Himanshu 						GHL-SCF-1738 
				 
---------------------------------------------------------------------------------------------------------------
*/

var radioval = "IC";
async function itemSearchlkp(item_desc,bean_id, bean_name, bl_install_yn, bl_disp_charge_dtl_in_drug_lkp_yn, bl_disp_price_type_in_drug_lkp, take_home_medication, priority, patient_id, encounter_id, location_code, location_type,patient_class){//patient_class addded for GHL-CRF-0467
	var dialogHeight= "90vh" ;
	var dialogWidth	= "80vw" ;
	var status = "no";
	var dialogUrl		= "../../ePH/jsp/ComsumableOrderItemLookup.jsp?item_desc="+encodeURIComponent(item_desc)+"&location_code="+location_code+"&location_type="+location_type+"&bean_id="+bean_id+"&bean_name="+bean_name+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_drug_lkp_yn="+bl_disp_charge_dtl_in_drug_lkp_yn+"&bl_disp_price_type_in_drug_lkp="+bl_disp_price_type_in_drug_lkp+"&take_home_medication="+take_home_medication+"&priority="+priority+"&patient_class="+patient_class; //patient_class addded for GHL-CRF-0467
	var dialogFeatures	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await top.window.showModalDialog(dialogUrl,"", dialogFeatures);
	//retVal = window.open(dialogUrl,"", dialogFeatures);
	return retVal;
}
async function itemSearch(){
	//alert("item");
	var frmObj = document.frm_consumableItemDetail;
	item_desc = frmObj.txt_item_desc.value;
	var location_code	    = frmObj.hdn_location_code.value;
	var location_type	    = frmObj.hdn_location_type.value;

	var bean_id			= frmObj.bean_id.value; 
	var bean_name	    = frmObj.bean_name.value;

	var bl_install_yn	=frmObj.hdn_bl_install_yn.value;
	var bl_disp_charge_dtl_in_drug_lkp_yn	=frmObj.hdn_bl_disp_charge_dtl_in_drug_lkp_yn.value;
	var bl_disp_price_type_in_drug_lkp	=frmObj.hdn_bl_disp_price_type_in_drug_lkp.value;
	var take_home_medication=frmObj.hdn_take_home_medication.value;
	var priority			=frmObj.hdn_priority.value;
	var patient_id			=frmObj.hdn_patient_id.value;
	var encounter_id			=frmObj.hdn_encounter_id.value;
	var patient_class		=frmObj.hdn_patient_class.value;//patient_class addded for GHL-CRF-0467
	retVal =await  itemSearchlkp(item_desc,bean_id, bean_name, bl_install_yn, bl_disp_charge_dtl_in_drug_lkp_yn, bl_disp_price_type_in_drug_lkp, take_home_medication, priority, patient_id, encounter_id, location_code, location_type,patient_class)//patient_class addded for GHL-CRF-0467
	if(retVal != undefined || retVal!=null){
		var Item_Codes =  new Array();
		var	Trade_Codes = new Array();
		var Trade_Names = new Array();
		var Available_Qty = new Array();
		var i=0;
		var index=0;
		if(retVal.length>0){
			while(i<retVal.length){
				Item_Codes[index]=retVal[i++];
				Trade_Codes[index]=retVal[i++];
				Trade_Names[index++]=retVal[i++];
				Available_Qty[index++]=retVal[i++];//Available_Qty Added By Himanshu for GHL-SCF-1738-->
			}
		}
		if(Item_Codes.length>0 ){
			addItemsForOrder(Item_Codes, Trade_Codes, Trade_Names, Available_Qty); //Available_Qty Added By Himanshu for GHL-SCF-1738-->
		}
	}
	else{ //added for KDAH-SCF-0326 [IN:056879] 
		frmObj.reset();
	}
}

async function itemSearchCommonLkp(){
	var frmObj = document.frm_consumableItemLkpCriteria;
	var item_desc = frmObj.txt_item_desc;
	var item_code = frmObj.hdn_item_code;
	var locale = frmObj.hdn_locale.value;

	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

//	var sql1 = frmObj.;
	var sql1 = "SELECT m.item_code code, m.long_desc description FROM mm_item_lang_vw m, st_item s WHERE m.language_id like (?) and UPPER (m.item_code) LIKE UPPER (?)  AND UPPER (m.long_desc) LIKE UPPER (?)  AND m.eff_status = 'E'  AND m.item_code = s.item_code   and s.medical_item_yn = 'Y' AND s.drug_item_yn = 'N' ";

	dataNameArray[0]	="m.language_id";
	dataValueArray[0]	=locale;
	dataTypeArray[0]	=STRING;

	argumentArray[0]	= sql1;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,3";
	argumentArray[5]   = frmObj.txt_item_desc.value ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;
	retVal = await CommonLookup(getLabel("Common.search.label","Common"), argumentArray);

	if(retVal == undefined || retVal == null || retVal == "" )
		return;
	item_code.value = retVal[0];
	item_desc.value = retVal[1];
}

function searchItem(){

	var frmObj = document.frm_consumableItemLkpCriteria;
		objform = parent.fram_cnItemLkpCriteria.frm_consumableItemLkpCriteria;
	if (objform.search_string.value == ""){
		var msg = getMessage("CAN_NOT_BE_BLANK","Common")
		    msg = msg.replace('$', getLabel("Common.searchtext.label","Common"));
		alert(msg);
		objform.search_string.value="";
		objform.search_string.focus();
		return false;
	}
	else if(objform.search_string.value.length <3){
		alert(getMessage("PH_CONSUM_SEARCH_MIN_CHAR","PH"));
		objform.search_string.value="";
		objform.search_string.focus();
		return false;
	}	
	else {
		search_string = objform.search_string.value;
		if (document.forms[0].searchby[0].checked) {
	
			radioval = "IC";
		}
		if (document.forms[0].searchby[1].checked) {
			radioval = "ID";
		}
		if (document.forms[0].searchby[2].checked) {
			radioval = "TC";
		}
		if (document.forms[0].searchby[3].checked) {
			radioval = "TN";
		}

		var item_code = "";
		var item_desc = "";
		var trade_name = "";
		var trade_id = "";
		var re = /%/g;
		search_string = search_string.replace(re, " ");
		if (search_string != "" && search_string != null) {
			if (objform.search_criteria.value == "S") {
				
				search_string = search_string + "%";
			}
			else {
				if (objform.search_criteria.value == "C") {
					
					search_string = "%" + search_string + "%";
				}
				else {
					search_string = "%" + search_string;
				}
			}
			search_string = escape(search_string);
			if (radioval == "IC") {
				
				item_code = search_string;
			}
			else {
					if (radioval == "ID") {
					item_desc = search_string;
				}
				else {
					if (radioval == "TC") {
						trade_id = search_string;
					}
					else{
						if (radioval == "TN") {
								trade_name = search_string;
						}
					}
				}
			}
		}
		else {
			item_code = "";
			item_desc = "";
			trade_id = "";
			trade_name = "";
		}
		p_Item_class = objform.p_Item_class.value;
		p_Item_analysis1 = objform.p_Item_analysis1.value;
		p_Item_analysis2 = objform.p_Item_analysis2.value;
		p_Item_analysis3 = objform.p_Item_analysis3.value;
	}

	var bean_id = frmObj.hdn_bean_id.value;
	var bean_name = frmObj.hdn_bean_name.value;
	var bl_install_yn	=frmObj.hdn_bl_install_yn.value;
	var bl_disp_charge_dtl_in_drug_lkp_yn	=frmObj.hdn_bl_disp_charge_dtl_in_drug_lkp_yn.value;
	var bl_disp_price_type_in_drug_lkp	=frmObj.hdn_bl_disp_price_type_in_drug_lkp.value;
	var search_string	=frmObj.search_string.value;
	var search_criteria	=frmObj.search_criteria.value;
	var p_Item_class	=frmObj.p_Item_class.value;
	var consignment	=frmObj.consignment.value;
	var Manufacturer	=frmObj.p_Manufacturer.value;
	var Item_analysis1	=frmObj.p_Item_analysis1.value;
	var Item_analysis2	=frmObj.p_Item_analysis2.value;
	var Item_analysis3	=frmObj.p_Item_analysis3.value;
		
	var take_home_medication=frmObj.hdn_take_home_medication.value;
	var priority			=frmObj.hdn_priority.value;
	var searchby1=frmObj.searchby.value;
	var store_name = frmObj.store_name.value; //added on 08/04/2010 for IN20551-- priya
	var disp_locn_code = frmObj.disp_locn_code.value; //added on 08/04/2010 for IN20551-- priya
	var CALL_FROM = frmObj.CALL_FROM.value; 
	//GHL-CRF-0467 starts
	var patient_class=frmObj.hdn_patient_class.value;//patient_class added for GHL-CRF-0467
	var split_stock=frmObj.hdn_split_stock.value;
	var split_stock1=split_stock.split('_');
	var consider_stock=	split_stock1[0];
	var allow_pres_without_stock_yn	=	split_stock1[1];
	//GHL-CRF-0467 ends
	var allow_alt_for_med_item = objform.allow_alt_for_med_item.value;	// Added for GHL-CRF-0548 [IN:068345] - Devindra
	parent.fram_cnItemLkpResult.location.href = '../../ePH/jsp/ComsumableOrderItemLookupResult.jsp?bean_id='+bean_id+"&bean_name="+bean_name+"&item_desc="+item_desc+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_drug_lkp_yn="+bl_disp_charge_dtl_in_drug_lkp_yn+"&bl_disp_price_type_in_drug_lkp="+bl_disp_price_type_in_drug_lkp+"&take_home_medication="+take_home_medication+"&priority="+priority+"&search_string="+search_string+"&search_criteria="+search_criteria+"&p_Item_class="+p_Item_class+"&consignment="+consignment+"&Manufacturer="+Manufacturer+"&Item_analysis1="+Item_analysis1+"&Item_analysis2="+Item_analysis2+"&Item_analysis3="+Item_analysis3+"&radioval=" + radioval+"&store_name=" + encodeURIComponent(store_name,"UTF-8")+"&disp_locn_code=" + disp_locn_code+"&CALL_FROM="+CALL_FROM+"&patient_class="+patient_class+"&consider_stock="+consider_stock+"&allow_pres_without_stock_yn="+allow_pres_without_stock_yn;//patient_class,consider_stock,allow_pres_without_stock_yn addded for GHL-CRF-0467
	parent.fram_cnItemLkpButtons.location.href = '../../ePH/jsp/ComsumableOrderItemLookupButtons.jsp?bean_id='+bean_id+"&bean_name="+bean_name+"&item_desc="+item_desc+"&consider_stock="+consider_stock+"&allow_alt_for_med_item="+allow_alt_for_med_item+"&CALL_FROM="+CALL_FROM;	//consider_stock added for GHL-CRF-0467 // allow_alt_for_med_item Added for GHL-CRF-0548 [IN:068345]  - - Devindra
}

function SubmitLink(from,to){
	document.frmItemNameCommonLookupResult.hdn_from.value = from;
	document.frmItemNameCommonLookupResult.hdn_to.value = to;
	//document.frmItemNameCommonLookupResult.submit();
/*======================================================================================================*/
//above stmt commented and below code added for IN24820 --12/11/2010-- priya
	var frmObj = parent.frames[0].document.frm_consumableItemLkpCriteria;
	var CALL_FROM = frmObj.CALL_FROM.value; // Added for GHL-CRF-0549
	//if (frmObj.search_string.value != "") {
		objform = parent.fram_cnItemLkpCriteria.frm_consumableItemLkpCriteria;
		search_string = objform.search_string.value;
		if (parent.frames[0].document.forms[0].searchby[0].checked) {
	
			radioval = "IC";
		}
		if (parent.frames[0].document.forms[0].searchby[1].checked) {
			radioval = "ID";
		}
		if (parent.frames[0].document.forms[0].searchby[2].checked) {
			radioval = "TC";
		}
		if (parent.frames[0].document.forms[0].searchby[3].checked) {
			radioval = "TN";
		}

		var item_code = "";
		var item_desc = "";
		var trade_name = "";
		var trade_id = "";
		var re = /%/g;
		search_string = search_string.replace(re, " ");
		if (search_string != "" && search_string != null) {
			if (objform.search_criteria.value == "S") {
				
				search_string = search_string + "%";
			} else {
				if (objform.search_criteria.value == "C") {
					
					search_string = "%" + search_string + "%";
				} else {
					search_string = "%" + search_string;
				}
			}
			search_string = escape(search_string);
			if (radioval == "IC") {
				
				item_code = search_string;
			} else {
					if (radioval == "ID") {
					item_desc = search_string;
				}else {
					if (radioval == "TC") {
						trade_id = search_string;
					}
					else{
						if (radioval == "TN") {
								trade_name = search_string;
						}
					}
				}
			}

	}
	else {
			item_code = "";
			item_desc = "";
			trade_id = "";
			trade_name = "";
		}
		p_Item_class = objform.p_Item_class.value;
		p_Item_analysis1 = objform.p_Item_analysis1.value;
		p_Item_analysis2 = objform.p_Item_analysis2.value;
		p_Item_analysis3 = objform.p_Item_analysis3.value;


	var bean_id = frmObj.hdn_bean_id.value;
	var bean_name = frmObj.hdn_bean_name.value;
	var bl_install_yn	=frmObj.hdn_bl_install_yn.value;
	var bl_disp_charge_dtl_in_drug_lkp_yn	=frmObj.hdn_bl_disp_charge_dtl_in_drug_lkp_yn.value;
	var bl_disp_price_type_in_drug_lkp	=frmObj.hdn_bl_disp_price_type_in_drug_lkp.value;
	var search_string	=frmObj.search_string.value;
	var search_criteria	=frmObj.search_criteria.value;
	var p_Item_class	=frmObj.p_Item_class.value;
	var consignment	=frmObj.consignment.value;
	var Manufacturer	=frmObj.p_Manufacturer.value;
	var Item_analysis1	=frmObj.p_Item_analysis1.value;
	var Item_analysis2	=frmObj.p_Item_analysis2.value;
	var Item_analysis3	=frmObj.p_Item_analysis3.value;
		
	var take_home_medication=frmObj.hdn_take_home_medication.value;
	var priority			=frmObj.hdn_priority.value;
	var searchby1=frmObj.searchby.value;
	var store_name = frmObj.store_name.value; //added on 08/04/2010 for IN20551-- priya
	var disp_locn_code = frmObj.disp_locn_code.value; //added on 08/04/2010 for IN20551-- priya
	//GHL-CRF-0467 starts
	var split_stock=frmObj.hdn_split_stock.value;
	var split_stock1=split_stock.split('_');
	var consider_stock=	split_stock1[0];
	var allow_pres_without_stock_yn	=	split_stock1[1];
	//GHL-CRF-0467 ends
	var allow_alt_for_med_item = objform.allow_alt_for_med_item.value; // Added for GHL-CRF-0548 [IN:068345] - Devindra
	parent.fram_cnItemLkpResult.location.href = '../../ePH/jsp/ComsumableOrderItemLookupResult.jsp?bean_id='+bean_id+"&bean_name="+bean_name+"&item_desc="+item_desc+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_drug_lkp_yn="+bl_disp_charge_dtl_in_drug_lkp_yn+"&bl_disp_price_type_in_drug_lkp="+bl_disp_price_type_in_drug_lkp+"&take_home_medication="+take_home_medication+"&priority="+priority+"&search_string="+search_string+"&search_criteria="+search_criteria+"&p_Item_class="+p_Item_class+"&consignment="+consignment+"&Manufacturer="+Manufacturer+"&Item_analysis1="+Item_analysis1+"&Item_analysis2="+Item_analysis2+"&Item_analysis3="+Item_analysis3+"&radioval=" + radioval+"&store_name=" + store_name+"&disp_locn_code=" + disp_locn_code+"&hdn_from="+from+"&hdn_to="+to+"&consider_stock="+consider_stock+"&allow_pres_without_stock_yn="+allow_pres_without_stock_yn;	//consider_stock,allow_pres_without_stock_yn Added for GHL-CRF-0467
	parent.fram_cnItemLkpButtons.location.href = '../../ePH/jsp/ComsumableOrderItemLookupButtons.jsp?bean_id='+bean_id+"&bean_name="+bean_name+"&item_desc="+item_desc+"&consider_stock="+consider_stock+"&allow_alt_for_med_item="+allow_alt_for_med_item+"&CALL_FROM="+CALL_FROM;	//consider_stock Added for GHL-CRF-0467 // allow_alt_for_med_item Added for GHL-CRF-0548 [IN:068345] - Devindra
/*======================================================================================================*/


}

function storeSelectedItem(index,preferredDrug){
  
	  if (preferredDrug == undefined )
	  {
			preferredDrug = '';
	  }
	var formObj		= document.frmItemNameCommonLookupResult;
	var bean_id		= formObj.hdn_bean_id.value ;
	var bean_name	= formObj.hdn_bean_name.value ;

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	var xmlStr	="<root><SEARCH " ;

	if(eval("formObj.chk_itemSelect"+index).checked==true && eval("formObj.chk_itemSelect"+index).disabled==false){
		xmlStr += "item_code"+index+"=\""+ eval("formObj.hdn_item_code"+index).value +"\" " ;
		xmlStr += "line_no"+index+"=\""+ eval("formObj.hdn_line_no"+index).value +"\" " ;
		xmlStr += "trade_code"+index+"=\""+ eval("formObj.hdn_trade_code"+index).value +"\" " ;
		xmlStr += "trade_name"+index+"=\""+ eval("formObj.hdn_trade_name"+index).value +"\" " ;
		
		//	xmlStr += "fluid_ingredient_flag"index+"=\""+ eval("formObj.all.fluid_ingredient_flag"index).value +"\" " ;
		xmlStr += "select"+index+"=\"E\" " ;
		
	}
	else{
		
		xmlStr += "item_code"+index+"=\""+ eval("formObj.hdn_item_code"+index).value +"\" " ;
		xmlStr += "line_no"+index+"=\""+ eval("formObj.hdn_line_no"+index).value +"\" " ;
		//	xmlStr += "fluid_ingredient_flag"index+"=\""+ eval("formObj.all.fluid_ingredient_flag"index).value +"\" " ;
		xmlStr += "select"+index+"=\"D\" " ;
	}
	xmlStr+=" index=\""+ index + "\" ";

	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ConsumableOrderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&validate=storeSelectedItemLKP"+"&preferredDrug="+preferredDrug , false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
}

function enableDisableSelectButton(objValue){
	var formObj		= parent.fram_cnItemLkpButtons.document.frm_consumableItemLkpButtons;
	if(objValue=="false")
		formObj.btn_itemSelect.disabled=false;
	else
		formObj.btn_itemSelect.disabled=true;
}

function selectItem(index,promptAlert){
	var altItemReqYn = "false"; // Added for GHL-CRF-0548 [IN:068345] - Start - Devindra
	 var alt_img      = "";	 	 
	 if(document.frmItemNameCommonLookupResult.item_type_yn!=undefined){		 
		 altItemReqYn = document.frmItemNameCommonLookupResult.item_type_yn.value;		 
	 }	 
	 if(eval("document.frmItemNameCommonLookupResult.alt_img_"+index)!=undefined){		 
		 alt_img=eval("document.frmItemNameCommonLookupResult.alt_img_"+index).style.visibility;		 
	 }	
	 if(altItemReqYn=="true" && alt_img!="hidden" && eval("document.frmItemNameCommonLookupResult.alt_need_to_open"+index).value=="true"){			 
		    var formObj		= document.frmItemNameCommonLookupResult;		    
			var bean_id		= formObj.hdn_bean_id.value ;
			var bean_name	= formObj.hdn_bean_name.value ;   		 	  		    		    		   
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();			
			xmlStr	="<root><SEARCH " ;
			xmlStr += "item_code=\""+ eval("formObj.hdn_item_code"+index).value +"\" " ;			
			xmlStr += "item_tech_code=\""+ eval("formObj.item_tech_code"+index).value +"\" " ;
			xmlStr += "act_patient_class=\""+formObj.act_patient_class.value+"\"" ;						
			//xmlStr += "promptAlert=\""+promptAlert+"\" " ;
			xmlStr+=" index=\""+ index + "\" ";
			xmlStr+=" promptAlert=\""+ promptAlert + "\" ";
			xmlStr += "available_qty=\""+ eval("formObj.hdn_available_qty"+index).value +"\" " ; //Added By Himanshu for GHL-SCF-1738-->
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "ConsumableOrderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&validate=saveSelectedDrug", false ) ;
			xmlHttp.send( xmlDoc ) ;
			eval(xmlHttp.responseText);			
	 } // Added for GHL-CRF-0548 [IN:068345] - End - Devindra
   else{	   
	
	if (promptAlert == 'Y')
	{  
	      if (!(confirm(getMessage("PREFERRED/DRUG_ITEM_INSRUCTION",'PH'))))
	      {
			var retVal = "";
			var formObj = document.frmItemNameCommonLookupResult;
			var item_code = eval("formObj.hdn_item_code"+index).value;
			var trade_code = eval("formObj.hdn_trade_code"+index).value;
			var trade_name = eval("formObj.hdn_trade_name"+index).value;
			var available_qty= eval("formObj.hdn_available_qty"+index).value; //Added By Himanshu for GHL-SCF-1738-->
			retVal=item_code+":::"+trade_code+":::"+trade_name+":::"+available_qty;
			//parent.window.returnValue = retVal.split(":::") ;
			parent.parent.document.querySelectorAll("#dialog-body")[parent.parent.document.querySelectorAll("#dialog-body").length -1 ].contentWindow.returnValue = retVal.split(":::") ;
			//parent.window.close();
			parent.parent.document.querySelectorAll("#dialog_tag")[parent.parent.document.querySelectorAll("#dialog_tag").length -1].close();
	      }	
	}
	else{
		
		var retVal = "";
		var formObj = document.frmItemNameCommonLookupResult;
		var item_code = eval("formObj.hdn_item_code"+index).value;
		var trade_code = eval("formObj.hdn_trade_code"+index).value;
		var trade_name = eval("formObj.hdn_trade_name"+index).value;
		var available_qty= eval("formObj.hdn_available_qty"+index).value; //Added By Himanshu for GHL-SCF-1738-->
		retVal=item_code+":::"+trade_code+":::"+trade_name+":::"+available_qty;
		//parent.window.returnValue = retVal.split(":::") ;
		parent.parent.document.querySelectorAll("#dialog-body")[parent.parent.document.querySelectorAll("#dialog-body").length -1 ].contentWindow.returnValue = retVal.split(":::") ;
		//parent.window.close();
		parent.parent.document.querySelectorAll("#dialog_tag")[parent.parent.document.querySelectorAll("#dialog_tag").length -1].close();
	}  // else Added for GHL-CRF-0548 [IN:068345]
	}
}
function returnAllSelectedDrugs(){

	var formObj		= parent.fram_cnItemLkpResult.document.frmItemNameCommonLookupResult;
	var bean_id		= formObj.hdn_bean_id.value ;
	var bean_name	= formObj.hdn_bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ConsumableOrderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&validate=getSelectedDrugs" , false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText
//	alert("responseText "+responseText)
	eval(responseText);
}

function returnItems(selectedItems){

	while(selectedItems.indexOf("[") != -1){
		selectedItems = selectedItems.replace("[", "");
		selectedItems = selectedItems.replace(", ],", ", ,");
		selectedItems = selectedItems.replace(", ]]", ",");
		selectedItems = selectedItems.replace("],", ",");
		selectedItems = selectedItems.replace("]", "");
	}

	var items= selectedItems.split(",");
	var retVal="";
	for (var i=0;i<items.length ;i+=3 ){
		retVal += trimString(items[i])+":::"+trimString(items[i+1])+":::";
		if((i+3)==items.length)
			retVal += trimString(items[i+2]);
		else
			retVal += trimString(items[i+2])+":::";
	}
	//parent.window.returnValue = retVal.split(":::");
	
	//window.close();
	
	parent.parent.document.querySelectorAll("#dialog-body")[parent.parent.document.querySelectorAll("#dialog-body").length -1 ].contentWindow.returnValue = retVal.split(":::");
	parent.parent.document.querySelectorAll("#dialog_tag")[parent.parent.document.querySelectorAll("#dialog_tag").length -1].close();
	
	
}

function addItemsForOrder(ItemCodes, TradeCodes, TradeNames, available_Qty){
	
	var formObj = document.frm_consumableItemDetail;

	var patient_id = formObj.hdn_patient_id.value;
	var encounter_id = formObj.hdn_encounter_id.value;
	var bean_id = formObj.bean_id.value;
	var bean_name	= formObj.bean_name.value ;
	var bl_install_yn	= formObj.hdn_bl_install_yn.value ;
	var bl_disp_charge_dtl_in_rx_yn	= formObj.hdn_bl_disp_charge_dtl_in_rx_yn.value ;
	var take_home_medication=formObj.hdn_take_home_medication.value;
	var priority	=formObj.hdn_priority.value;
	var pract_id	= formObj.hdn_pract_id.value ;
	var resp_id		= formObj.hdn_resp_id.value ;
	var order_date_time= formObj.hdn_order_date_time.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	var	episode_type = formObj.hdn_act_patient_class.value;
	if(episode_type!='')
		episode_type = episode_type.substring(0,1);
	if(episode_type=='X')
		episode_type='R';

	var xmlStr	="<root><SEARCH " ;
	xmlStr+=" order_date_time=\""+ order_date_time + "\" ";
	xmlStr+=" itemCodes=\""+ ItemCodes + "\" ";
	xmlStr+=" tradeCodes=\""+ TradeCodes + "\" ";
	xmlStr+=" tradeNames=\""+ TradeNames + "\" ";
	xmlStr+=" take_home_medication=\""+ take_home_medication + "\" ";
	xmlStr+=" priority=\""+ priority + "\" ";
	xmlStr += " pract_id=\""+ pract_id + "\" ";
	xmlStr += " resp_id=\""+ resp_id + "\" ";
	xmlStr += " bl_install_yn=\""+ bl_install_yn + "\" ";
	xmlStr += " bl_disp_charge_dtl_in_rx_yn=\""+ bl_disp_charge_dtl_in_rx_yn + "\" ";
	xmlStr += " episode_type=\""+ episode_type + "\" ";
	xmlStr += " patient_id=\""+ patient_id + "\" ";
	xmlStr += " encounter_id=\""+ encounter_id + "\" ";
	xmlStr += " available_Qty=\""+ available_Qty + "\" "; //Added By Himanshu for GHL-SCF-1738-->
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open( "POST", "ConsumableOrderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&validate=addItemsForOrder" , false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
}

function loadItemDetails(){
	var formObj = document.frm_consumableItemDetail;

	var bean_id = formObj.bean_id.value;
	var bean_name	= formObj.bean_name.value ;
	var take_home_medication =formObj.hdn_take_home_medication.value;
	var priority	=formObj.hdn_priority.value;
	var pract_id	= formObj.hdn_pract_id.value ;
	var resp_id		= formObj.hdn_resp_id.value ;
	var bl_install_yn	= formObj.hdn_bl_install_yn.value ;
	var bl_disp_charge_dtl_in_rx_yn	= formObj.hdn_bl_disp_charge_dtl_in_rx_yn.value ;
	var order_date_time		= formObj.hdn_order_date_time.value ;
	var call_mode		= formObj.hdn_call_mode.value ;
	var called_from		= formObj.hdn_called_from.value ;
	var patient_id		= formObj.hdn_patient_id.value ;	//Added for GHL-CRF-0470
	var encounter_id		= formObj.hdn_encounter_id.value ;	//Added for GHL-CRF-0470

	parent.fram_cnItemList.document.location.href ='../../ePH/jsp/ConsumableOrderItemList.jsp?bean_id=' + bean_id + '&bean_name=' + bean_name+'&take_home_medication='+take_home_medication+'&priority='+priority+'&pract_id='+pract_id+'&resp_id='+resp_id+'&bl_install_yn='+bl_install_yn+'&bl_disp_charge_dtl_in_rx_yn='+bl_disp_charge_dtl_in_rx_yn+'&order_date_time='+order_date_time+"&call_mode="+call_mode+"&patient_id="+patient_id+"&encounter_id="+encounter_id;	// patient_id and encounter_id modified for GHL-CRF-0470

	parent.fram_cnButtons.document.location.href ='../../ePH/jsp/ConsumableOrderButtons.jsp?bean_id=' + bean_id + '&bean_name=' + bean_name+'&take_home_medication='+take_home_medication+'&priority='+priority+'&pract_id='+pract_id+'&resp_id='+resp_id+'&bl_install_yn='+bl_install_yn+'&bl_disp_charge_dtl_in_rx_yn='+bl_disp_charge_dtl_in_rx_yn+"&called_from="+called_from;
}

function defaultItem(defaultIndex){
	
	var lst_formObj = document.frm_consumableItemList;
	var formObj = parent.fram_cnItemDetail.document.frm_consumableItemDetail;
	try{
		var bean_id		= lst_formObj.hdn_bean_id.value;
		var bean_name	= lst_formObj.hdn_bean_name.value ;			
		var patient_id	= formObj.hdn_patient_id.value;	
		var encounter_id= formObj.hdn_encounter_id.value;
		var patient_class= formObj.hdn_patient_class.value;		
		var act_patient_class = formObj.hdn_act_patient_class.value;
		var location_code = formObj.hdn_location_code.value;
		var location_type = formObj.hdn_location_type.value;
		var take_home_medication =formObj.hdn_take_home_medication.value;
		var priority	=formObj.hdn_priority.value;
		var pract_id	= formObj.hdn_pract_id.value ;
		var resp_id		= formObj.hdn_resp_id.value ;
		var bl_install_yn	= formObj.hdn_bl_install_yn.value ;
		var bl_disp_charge_dtl_in_rx_yn	= formObj.hdn_bl_disp_charge_dtl_in_rx_yn.value ;
		var bl_disp_charge_dtl_in_drug_lkp_yn	=formObj.hdn_bl_disp_charge_dtl_in_drug_lkp_yn.value;
		var bl_disp_price_type_in_drug_lkp	=formObj.hdn_bl_disp_price_type_in_drug_lkp.value;
		var order_date_time		= formObj.hdn_order_date_time.value ;
		var height				= formObj.hdn_height.value;
		var height_uom			= formObj.hdn_height_unit.value;
		var weight				= formObj.hdn_weight.value;
		var weight_uom			= formObj.hdn_weight_unit.value;
		var bsa				= formObj.hdn_bsa.value;
		var bsa_uom		= getLabel("Common.BSA.label","Common");
		var bmi			= formObj.hdn_bmi.value;
		var room_num		= formObj.hdn_room_num.value ;
		var bed_num		= formObj.hdn_bed_num.value ;
		var facility_id		= formObj.hdn_facility_id.value ;
		var called_from		= formObj.hdn_called_from.value ;
		var allow_pres_without_stock_yn		= formObj.hdn_allow_pres_without_stock_yn.value ;
		parent.fram_cnItemDetail.document.location.href ='../../ePH/jsp/ConsumableOrderItemDetail.jsp?bean_id=' + bean_id + '&bean_name=' + bean_name+'&take_home_medication='+take_home_medication+'&priority='+priority+'&pract_id='+pract_id+'&resp_id='+resp_id+'&bl_install_yn='+bl_install_yn+'&bl_disp_charge_dtl_in_rx_yn='+bl_disp_charge_dtl_in_rx_yn+"&bl_disp_charge_dtl_in_drug_lkp_yn="+bl_disp_charge_dtl_in_drug_lkp_yn+"&bl_disp_price_type_in_drug_lkp="+bl_disp_price_type_in_drug_lkp+'&order_date_time='+order_date_time+"&call_mode=modify"+"&defaultIndex="+defaultIndex+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&act_patient_class="+act_patient_class+"&location_code="+location_code+"&location_type="+location_type+"&height="+height+"&weight="+weight+"&height_unit="+height_uom+"&weight_unit="+weight_uom+"&bsa="+bsa+"&bsa_uom="+bsa_uom+"&bmi="+bmi+"&facility_id="+facility_id+"&bed_num="+bed_num+"&room_num="+room_num+"&called_from="+called_from+"&allow_pres_without_stock_yn="+allow_pres_without_stock_yn;
	}catch(e){
	}
}
function changeCol(obj){
	obj.className="FOCUSDRUGS";
}

function changeBorder(obj){
	obj.className="CLICKDRUGS";
}

function realCol(obj,classVal){
	obj.className=classVal;
}

function conClearItem(){
	var formObj = document.frm_consumableItemDetail;
	var bean_id = formObj.bean_id.value;
	var bean_name	= formObj.bean_name.value ;
	var item_code		= formObj.hdn_item_code.value ;
	var index		= formObj.hdn_defaultIndex.value ;
	if(item_code==null || item_code==''){
		var msg = getMessage("CAN_NOT_BE_BLANK","Common")
		    msg = msg.replace('$', getLabel("Common.ItemName.label","Common"));
		alert(msg);
		return false;
	}
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	var xmlStr	="<root><SEARCH " ;
	xmlStr+=" item_code=\""+ item_code + "\" ";
	xmlStr+=" index=\""+ index + "\" ";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open( "POST", "ConsumableOrderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&validate=removeItem" , false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
	var url = parent.fram_cnItemList.location.href;
	parent.fram_cnItemList.location.href = url;

	formObj.hdn_item_code.value = "";
	formObj.txt_item_desc.value = "";
	formObj.txt_qty_value.value = "";
	formObj.td_disp_locn_desc.innerText = "";
	formObj.lbl_qty_unit_desc.innerText = "";
	formObj.lbl_authorize.style.visibility = "hidden";
	formObj.lbl_apprvl.style.visibility = "hidden";
	formObj.lbl_cosign.style.visibility = "hidden";
	formObj.slt_trade_desc.clear;

	var len =formObj.slt_trade_desc.options.length;
	for(var i=0;i<len;i++) {
		formObj.slt_trade_desc.remove("slt_trade_desc") ;
	}
	var tp = "  --- "+getLabel("ePH.Select.label","PH")+" ---  " ;
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	formObj.slt_trade_desc.add(opt);
}

function confirmItem(){
	var formObj = document.frm_consumableItemDetail;

	var bean_id = formObj.bean_id.value;
	var bean_name	= formObj.bean_name.value ;
	var item_code		= formObj.hdn_item_code.value ;
	var allow_alternate_yn = formObj.allow_alt_chk.value; // Added for GHL-CRF-0548 [IN:068345] - Devindra
	var performingFacilityId		= formObj.performingFacilityId.value ;
	if(item_code==null || item_code==''){
		var msg = getMessage("CAN_NOT_BE_BLANK","Common")
		    msg = msg.replace('$', getLabel("Common.ItemName.label","Common"));
		alert(msg);
		return false;
	}
	var trade_code		= formObj.slt_trade_desc.options[formObj.slt_trade_desc.selectedIndex].value;
	if(trade_code!="")
		var trade_name		= formObj.slt_trade_desc.options[formObj.slt_trade_desc.selectedIndex].text;
	else
		var trade_name = "";
	var qty_value		= formObj.txt_qty_value.value ;
	if(qty_value==null || qty_value=='' || qty_value=='0'){
		alert(getMessage("ABS_QTY_CANNOT_ZERO","PH"));
		return false;
	}
	
	
	//<!--//Added By Himanshu for GHL-SCF-1738-->
	var allow_pres_without_stock_yn=formObj.hdn_allow_pres_without_stock_yn.value;
	var hdn_available_qty		= parseInt(formObj.hdn_available_qty.value) ;
	if(allow_pres_without_stock_yn=="N"){
		if(hdn_available_qty<parseInt(qty_value))
		{
			alertNoAvailStock();
			return false;
		}
	}
	
	var index		= formObj.hdn_defaultIndex.value ;
	var MedicationRemarks	=	eval("parent.fram_cnItemList.frm_consumableItemList.MedicationRemarks_"+index).value; //Added for GHL-CRF-0470
	if(MedicationRemarks==null || MedicationRemarks == undefined){	//Added for GHL-CRF-0470
		MedicationRemarks="";
	}
	var take_home_medication =formObj.hdn_take_home_medication.value;
	var priority	=formObj.hdn_priority.value;
	var pract_id	= formObj.hdn_pract_id.value ;
	var resp_id		= formObj.hdn_resp_id.value ;
	var bl_install_yn	= formObj.hdn_bl_install_yn.value ;
	var bl_disp_charge_dtl_in_rx_yn	= formObj.hdn_bl_disp_charge_dtl_in_rx_yn.value ;
	var bl_disp_charge_dtl_in_drug_lkp_yn	=formObj.hdn_bl_disp_charge_dtl_in_drug_lkp_yn.value;
	var bl_disp_price_type_in_drug_lkp	=formObj.hdn_bl_disp_price_type_in_drug_lkp.value;
	var order_date_time		= formObj.hdn_order_date_time.value ;
	var	episode_type = formObj.hdn_act_patient_class.value;
	var patient_id = formObj.hdn_patient_id.value;
	var encounter_id = formObj.hdn_encounter_id.value;
	var patient_class = formObj.hdn_patient_class.value;
	if(episode_type!='')
		episode_type = episode_type.substring(0,1);
	if(episode_type=='X')
		episode_type='R';

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	var xmlStr	="<root><SEARCH " ;
	xmlStr+=" item_code=\""+ item_code + "\" ";
	xmlStr+=" trade_code=\""+ trade_code + "\" ";
	//xmlStr+=" trade_name=\""+ encodeURIComponent(trade_name) + "\" ";
	xmlStr+=" trade_name=\""+ encodeURIComponent(trade_name,"UTF-8") + "\" ";
	xmlStr+=" qty_value=\""+ qty_value + "\" ";
	xmlStr+=" index=\""+ index + "\" ";
	xmlStr+=" take_home_medication=\""+ take_home_medication + "\" ";
	xmlStr+=" priority=\""+ priority + "\" ";
	xmlStr += " pract_id=\""+ pract_id + "\" ";
	xmlStr += " resp_id=\""+ resp_id + "\" ";
	xmlStr += " bl_install_yn=\""+ bl_install_yn + "\" ";
	xmlStr += " bl_disp_charge_dtl_in_rx_yn=\""+ bl_disp_charge_dtl_in_rx_yn + "\" ";
	xmlStr += " episode_type=\""+ episode_type + "\" ";
	xmlStr += " patient_id=\""+ patient_id + "\" ";
	xmlStr += " encounter_id=\""+ encounter_id + "\" ";
	xmlStr += " performingFacilityId=\""+ performingFacilityId + "\" ";
	xmlStr += " medication_remarks=\""+ MedicationRemarks + "\" ";	//Added for GHL-CRF-0470
	xmlStr += " allow_alternate_yn=\""+ allow_alternate_yn + "\" ";	// Added for GHL-CRF-0548 [IN:068345] - Devindra
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open( "POST", "ConsumableOrderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&validate=confirmItem" , false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);

	var act_patient_class = formObj.hdn_act_patient_class.value;
	var location_code = formObj.hdn_location_code.value;
	var location_type = formObj.hdn_location_type.value;
	var height				= formObj.hdn_height.value;
	var height_uom			= formObj.hdn_height_unit.value;
	var weight				= formObj.hdn_weight.value;
	var weight_uom			= formObj.hdn_weight_unit.value;
	var bsa				= formObj.hdn_bsa.value;
	var bsa_uom		= getLabel("Common.BSA.label","Common");
	var bmi			= formObj.hdn_bmi.value;
	var room_num		= formObj.hdn_room_num.value ;
	var bed_num		= formObj.hdn_bed_num.value ;
	var facility_id		= formObj.hdn_facility_id.value ;
	var called_from		= formObj.hdn_called_from.value ;

	parent.fram_cnItemDetail.document.location.href ='../../ePH/jsp/ConsumableOrderItemDetail.jsp?bean_id=' + bean_id + '&bean_name=' + bean_name+'&take_home_medication='+take_home_medication+'&priority='+priority+'&pract_id='+pract_id+'&resp_id='+resp_id+'&bl_install_yn='+bl_install_yn+'&bl_disp_charge_dtl_in_rx_yn='+bl_disp_charge_dtl_in_rx_yn+"&bl_disp_charge_dtl_in_drug_lkp_yn="+bl_disp_charge_dtl_in_drug_lkp_yn+"&bl_disp_price_type_in_drug_lkp="+bl_disp_price_type_in_drug_lkp+'&order_date_time='+order_date_time+"&call_mode=new"+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&act_patient_class="+act_patient_class+"&location_code="+location_code+"&location_type="+location_type+"&height="+height+"&weight="+weight+"&weight_unit="+weight_uom+"&bsa="+bsa+"&bsa_uom="+bsa_uom+"&bmi="+bmi+"&facility_id="+facility_id+"&bed_num="+bed_num+"&room_num="+room_num+"&called_from="+called_from+"&medication_remarks="+MedicationRemarks+"&height_unit="+height_uom;	// medication_remarks added for GHL-CRF-0470 //height added at end for skr-scf-1342

	parent.fram_cnItemList.document.location.href ='../../ePH/jsp/ConsumableOrderItemList.jsp?bean_id=' + bean_id + '&bean_name=' + bean_name+'&take_home_medication='+take_home_medication+'&priority='+priority+'&pract_id='+pract_id+'&resp_id='+resp_id+'&bl_install_yn='+bl_install_yn+'&bl_disp_charge_dtl_in_rx_yn='+bl_disp_charge_dtl_in_rx_yn+'&order_date_time='+order_date_time+"&call_mode=modify"+"&medication_remarks="+MedicationRemarks;	//medication_remarks modified for GHL-CRF-0470

	parent.fram_cnButtons.document.location.href ='../../ePH/jsp/ConsumableOrderButtons.jsp?bean_id=' + bean_id + '&bean_name=' + bean_name+'&take_home_medication='+take_home_medication+'&priority='+priority+'&pract_id='+pract_id+'&resp_id='+resp_id+'&bl_install_yn='+bl_install_yn+'&bl_disp_charge_dtl_in_rx_yn='+bl_disp_charge_dtl_in_rx_yn+"&called_from="+called_from;

}

async function displayChargeDetails(){
	var formObj = parent.fram_cnItemDetail.document.frm_consumableItemDetail;

	var bean_id = formObj.bean_id.value;
	var bean_name	= formObj.bean_name.value ;

	var patient_id = formObj.hdn_patient_id.value;
	var encounter_id = formObj.hdn_encounter_id.value;
	var act_patient_class = formObj.hdn_act_patient_class.value;
	var take_home_medication =formObj.hdn_take_home_medication.value;

	var dialogHeight= "64vh" ;
	var dialogWidth	= "82vw" ;
	var dialogTop	= "" ;
	var dialogLeft	= "0" ;
	var center		= "1" ;
	var status		= "no";
	var scroll		= "yes";
	var features	= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;

	retVal = await top.window.showModalDialog("../../ePH/jsp/ChargeDetail.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&actual_patient_class="+act_patient_class+"&take_home_medication="+take_home_medication+"&rx_order_type=MS",arguments,features);

	if(retVal!= undefined && retVal!=null && retVal!="")
		alertBLErrorDrugs(retVal, 'ChargeDetail');
}

function alertBLErrorDrugs(blErrorDrugs, called_from){
	blError = true;
	blErrorDrugs = blErrorDrugs.substring(1,blErrorDrugs.length-2);
	blErrorDrugs = blErrorDrugs.split(',');
	var bl_alert_msg=getMessage("ERROR_IN_BILLING",'PH')+"\n";
	var count=0;
	var item_codes = new Array();

	for(var i=0; i<blErrorDrugs.length; i++){
		item_codes[count++]	= trimString(blErrorDrugs[i++]);
		item_desc	= trimString(blErrorDrugs[i++]);
		bl_error_code = trimString(blErrorDrugs[i++]);
		bl_sys_message_id = trimString(blErrorDrugs[i++]);
		bl_error_text = trimString(blErrorDrugs[i]);

		if ((bl_error_code == "10" && bl_error_text =="") || bl_sys_message_id!=""){
			if(bl_sys_message_id!=""){
				bl_error_text = getMessage(bl_sys_message_id,'BL');
			}
		}
		bl_alert_msg += item_desc+"  "+ bl_error_text+"\n";
	}
	alert(bl_alert_msg);

	if(called_from!=undefined && (called_from =='ChargeDetail' || called_from=='CONFIRM')){
		deleteBLErrorItems(item_codes);
	}
}

function deleteBLErrorItems(item_codes){

	var formObj = parent.fram_cnItemDetail.document.frm_consumableItemDetail;

	var bean_id = formObj.bean_id.value;
	var bean_name	= formObj.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	var xmlStr	="<root><SEARCH " ;
	xmlStr+=" itemCodes=\""+ item_codes + "\" ";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open( "POST", "ConsumableOrderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&validate=deleteBLErrorItems" , false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);

	var patient_id = formObj.hdn_patient_id.value;
	var encounter_id = formObj.hdn_encounter_id.value;
	var patient_class = formObj.hdn_patient_class.value;
	var act_patient_class = formObj.hdn_act_patient_class.value;
	var location_code = formObj.hdn_location_code.value;
	var location_type = formObj.hdn_location_type.value;
	var take_home_medication =formObj.hdn_take_home_medication.value;
	var priority	=formObj.hdn_priority.value;
	var pract_id	= formObj.hdn_pract_id.value ;
	var resp_id		= formObj.hdn_resp_id.value ;
	var bl_install_yn	= formObj.hdn_bl_install_yn.value ;
	var bl_disp_charge_dtl_in_rx_yn	= formObj.hdn_bl_disp_charge_dtl_in_rx_yn.value ;
	var bl_disp_charge_dtl_in_drug_lkp_yn	=formObj.hdn_bl_disp_charge_dtl_in_drug_lkp_yn.value;
	var bl_disp_price_type_in_drug_lkp	=formObj.hdn_bl_disp_price_type_in_drug_lkp.value;
	var order_date_time		= formObj.hdn_order_date_time.value ;
	var height				= formObj.hdn_height.value;
	var height_uom			= formObj.hdn_height_unit.value;
	var weight				= formObj.hdn_weight.value;
	var weight_uom			= formObj.hdn_weight_unit.value;
	var bsa				= formObj.hdn_bsa.value;
	var bsa_uom		= getLabel("Common.BSA.label","Common");
	var bmi			= formObj.hdn_bmi.value;
	var room_num		= formObj.hdn_room_num.value ;
	var bed_num		= formObj.hdn_bed_num.value ;
	var facility_id		= formObj.hdn_facility_id.value ;
	var called_from		= formObj.hdn_called_from.value ;

	parent.fram_cnItemDetail.document.location.href ='../../ePH/jsp/ConsumableOrderItemDetail.jsp?bean_id=' + bean_id + '&bean_name=' + bean_name+'&take_home_medication='+take_home_medication+'&priority='+priority+'&pract_id='+pract_id+'&resp_id='+resp_id+'&bl_install_yn='+bl_install_yn+'&bl_disp_charge_dtl_in_rx_yn='+bl_disp_charge_dtl_in_rx_yn+"&bl_disp_charge_dtl_in_drug_lkp_yn="+bl_disp_charge_dtl_in_drug_lkp_yn+"&bl_disp_price_type_in_drug_lkp="+bl_disp_price_type_in_drug_lkp+'&order_date_time='+order_date_time+"&call_mode=new"+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&act_patient_class="+act_patient_class+"&location_code="+location_code+"&location_type="+location_type+"&height="+height+"&weight="+weight+"&height_unit="+height_uom+"&weight_unit="+weight_uom+"&bsa="+bsa+"&bsa_uom="+bsa_uom+"&bmi="+bmi+"&facility_id="+facility_id+"&bed_num="+bed_num+"&room_num="+room_num+"&called_from="+called_from;

	parent.fram_cnItemList.document.location.href ='../../ePH/jsp/ConsumableOrderItemList.jsp?bean_id=' + bean_id + '&bean_name=' + bean_name+'&take_home_medication='+take_home_medication+'&priority='+priority+'&pract_id='+pract_id+'&resp_id='+resp_id+'&bl_install_yn='+bl_install_yn+'&bl_disp_charge_dtl_in_rx_yn='+bl_disp_charge_dtl_in_rx_yn+'&order_date_time='+order_date_time+"&call_mode=modify";

	parent.fram_cnButtons.document.location.href ='../../ePH/jsp/ConsumableOrderButtons.jsp?bean_id=' + bean_id + '&bean_name=' + bean_name+'&take_home_medication='+take_home_medication+'&priority='+priority+'&pract_id='+pract_id+'&resp_id='+resp_id+'&bl_install_yn='+bl_install_yn+'&bl_disp_charge_dtl_in_rx_yn='+bl_disp_charge_dtl_in_rx_yn+"&called_from="+called_from;
}

function clearAll(){
	var formObj = parent.fram_cnItemDetail.document.frm_consumableItemDetail;

	var bean_id		= formObj.bean_id.value;
	var bean_name	= formObj.bean_name.value ;
	var patient_id			= formObj.hdn_patient_id.value;
	var encounter_id		= formObj.hdn_encounter_id.value;
	var location_type		= formObj.hdn_location_type.value;
	var location_code		= formObj.hdn_location_code.value;
	var patient_class		= formObj.hdn_patient_class.value;
	var resp_id				= formObj.hdn_resp_id.value ;
	var act_patient_class	= formObj.hdn_act_patient_class.value;
	var order_date_time		= formObj.hdn_order_date_time.value;
	var pract_id			= formObj.hdn_pract_id.value;
	var priority			= formObj.hdn_priority.value;
	var bl_install_yn		= formObj.hdn_bl_install_yn.value;
	var bl_disp_charge_dtl_in_rx_yn		= formObj.hdn_bl_disp_charge_dtl_in_rx_yn.value;
	var bl_disp_charge_dtl_in_drug_lkp_yn		= formObj.hdn_bl_disp_charge_dtl_in_drug_lkp_yn.value;
	var bl_disp_price_type_in_drug_lkp		= formObj.hdn_bl_disp_price_type_in_drug_lkp.value;
	var take_home_medication		    = formObj.hdn_take_home_medication.value;
	var called_from		    = formObj.hdn_called_from.value;
	var height				= formObj.hdn_height.value;
	var weight				= formObj.hdn_weight.value;
	var height_uom			= formObj.hdn_height_unit.value;
	var weight_uom			= formObj.hdn_weight_unit.value;
	var bsa				= formObj.hdn_bsa.value;
	var bsa_uom			= getLabel("Common.BSA.label","Common");
	var bmi				= formObj.hdn_bmi.value;
	var room_num		= formObj.hdn_room_num.value ;
	var bed_num			= formObj.hdn_bed_num.value ;
	var facility_id		= formObj.hdn_facility_id.value ;
	var mode = "blank";

	if(called_from=="TAB" || called_from=="ORDERSET"){
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr	="<root><SEARCH " ;
		xmlStr+=" called_from=\""+ called_from + "\" ";
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

		xmlHttp.open( "POST", "ConsumableOrderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&validate=cancel" , false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
		parent.parent.f_prescription.location.href="../../ePH/jsp/ConsumableOrder.jsp?priority="+priority+"&location_code="+location_code+"&location_type="+location_type+"&pract_id="+pract_id+"&resp_id="+resp_id+"&act_patient_class="+act_patient_class+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&mode="+mode+"&order_date_time="+order_date_time+"&height="+height+"&weight="+weight+"&take_home_medication="+take_home_medication+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+"&bl_disp_charge_dtl_in_drug_lkp_yn="+bl_disp_charge_dtl_in_drug_lkp_yn+"&bl_disp_price_type_in_drug_lkp="+bl_disp_price_type_in_drug_lkp+"&height_uom="+height_uom+"&weight_uom="+weight_uom+"&bsa="+bsa+"&bsa_uom="+bsa_uom+"&bmi="+bmi+"&facility_id="+facility_id+"&bed_num="+bed_num+"&room_num="+room_num+"&call_mode=new"+"&called_from=TAB";
	}
	else{
		//window.close();
		toCloseTopShowModal();
		/*var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr	="<root><SEARCH " ;
		xmlStr+=" called_from=\""+ called_from + "\" ";
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

		xmlHttp.open( "POST", "ConsumableOrderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&validate=cancel" , false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
		parent.window.close()*/
	}
}

function release(){
	document.frm_consumableOrderButtons.btn_item_search.disabled = true;//added for KDAH-SCF-0326 [IN:056879] 
	var formObj = parent.fram_cnItemDetail.document.frm_consumableItemDetail;
	var bean_id = formObj.bean_id.value;
	var bean_name	= formObj.bean_name.value ;
	var item_code		= formObj.hdn_item_code.value ;
	var trade_code = "";
	var trade_name = "";
	var qty_value = "";
	var index = "";
	if(!(item_code==null || item_code=='')){
		trade_code		= formObj.slt_trade_desc.options[formObj.slt_trade_desc.selectedIndex].value;
		if(trade_code!="")
			trade_name		= formObj.slt_trade_desc.options[formObj.slt_trade_desc.selectedIndex].text;
		else
			trade_name = "";
		if(trade_name!="")
			trade_name = encodeURIComponent(trade_name,"UTF-8"); //added for IN24579 --26/10/2010-- priya
		qty_value		= formObj.txt_qty_value.value ;
		if(qty_value==null || qty_value=='' || qty_value=='0'){
			alert(getMessage("ABS_QTY_CANNOT_ZERO","PH"));
			return false;
		}
		index		= formObj.hdn_defaultIndex.value ;
	}

	var patient_id			= formObj.hdn_patient_id.value;
	var encounter_id		= formObj.hdn_encounter_id.value;
	var location_type		= formObj.hdn_location_type.value;
	var location_code		= formObj.hdn_location_code.value;
	var patient_class		= formObj.hdn_patient_class.value;
	var act_patient_class	= formObj.hdn_act_patient_class.value;
	var priority			= formObj.hdn_priority.value;
	var take_home_medication= formObj.hdn_take_home_medication.value;
	var height				= formObj.hdn_height.value;
	var height_uom			= formObj.hdn_height_unit.value;
	var allow_alternate_yn = formObj.allow_alt_chk.value; // Added for GHL-CRF-0548 [IN:068345] - Devindra
	var weight				= formObj.hdn_weight.value;
	var weight_uom			= formObj.hdn_weight_unit.value;
	var bsa				    = formObj.hdn_bsa.value;
	var bsa_uom		        = getLabel("Common.BSA.label","Common");
	var bmi			        = formObj.hdn_bmi.value;
	var pract_id	        = formObj.hdn_pract_id.value ;
	var resp_id		        = formObj.hdn_resp_id.value ;
	var room_num		    = formObj.hdn_room_num.value ;
	var bed_num		        = formObj.hdn_bed_num.value ;
	var order_date_time		= formObj.hdn_order_date_time.value ;
	//var order_date_time		=  parent.parent.f_header.document.prescription_header_form.sys_date.value;
	var facility_id		    = formObj.hdn_facility_id.value ;
	var bl_install_yn	    =formObj.hdn_bl_install_yn.value;
	var bl_disp_charge_dtl_in_rx_yn		= formObj.hdn_bl_disp_charge_dtl_in_rx_yn.value;
	var allow_pres_without_stock_yn		= formObj.hdn_allow_pres_without_stock_yn.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	var called_from		= formObj.hdn_called_from.value ;
	var source_type = "";
	var source_code = "";

	if(called_from=='TAB'){
		source_type = parent.parent.f_header.document.prescription_header_form.source_type.value;
		source_code = parent.parent.f_header.document.prescription_header_form.source_code.value;
	}else{
		source_type = location_type;
		source_code = location_code;
	}
	var xmlStr	="<root><SEARCH " ;
	xmlStr+=" facility_id=\""+ facility_id + "\" ";
	xmlStr+=" patient_id=\""+ patient_id + "\" ";
	xmlStr+=" encounter_id=\""+ encounter_id + "\" ";
	xmlStr+=" patient_class=\""+ patient_class + "\" ";
	xmlStr+=" act_patient_class=\""+ act_patient_class + "\" ";
	xmlStr+=" location_type=\""+ location_type + "\" ";
	xmlStr+=" location_code=\""+ location_code + "\" ";
	xmlStr+=" height=\""+ height + "\" ";
	xmlStr+=" height_uom=\""+ height_uom + "\" ";
	xmlStr+=" weight=\""+ weight + "\" ";
	xmlStr+=" weight_uom=\""+ weight_uom + "\" ";
	xmlStr+=" bsa=\""+ bsa + "\" ";
	xmlStr+=" bsa_uom=\""+ bsa_uom + "\" ";
	xmlStr+=" bmi=\""+ bmi + "\" ";
	xmlStr+=" room_num=\""+ room_num + "\" ";
	xmlStr+=" bed_num=\""+ bed_num + "\" ";
	xmlStr+=" order_date_time=\""+ order_date_time + "\" ";
	xmlStr+=" take_home_medication=\""+ take_home_medication + "\" ";
	xmlStr+=" priority=\""+ priority + "\" ";
	xmlStr+=" pract_id=\""+ pract_id + "\" ";
	xmlStr+=" resp_id=\""+ resp_id + "\" ";
	xmlStr+=" item_code=\""+ item_code + "\" ";
	xmlStr+=" trade_code=\""+ trade_code + "\" ";
	xmlStr+=" trade_name=\""+ trade_name + "\" ";
	xmlStr+=" qty_value=\""+ qty_value + "\" ";
	xmlStr+=" index=\""+ index + "\" ";
	xmlStr+=" called_from=\""+ called_from + "\" ";
	xmlStr += " bl_install_yn=\""+ bl_install_yn + "\" ";
	xmlStr += " bl_disp_charge_dtl_in_rx_yn=\""+ bl_disp_charge_dtl_in_rx_yn + "\" ";
	xmlStr += " source_type=\""+ source_type + "\" ";
	xmlStr += " source_code=\""+ source_code + "\" ";
	xmlStr += " allow_alternate_yn=\""+ allow_alternate_yn + "\" ";	// Added for GHL-CRF-0548 [IN:068345] - Devindra
	xmlStr += " allow_pres_without_stock_yn=\""+ allow_pres_without_stock_yn + "\" ";	
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ConsumableOrderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&validate=release" , false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText= xmlHttp.responseText
	eval(responseText);
}

async function calFormApply(){//print_ord_sht_rule_ind Added for Bru-HIMS-CRF-393_1.0//removed print_ord_sht_rule_ind for KAUH-SCF-0229 [IN:056384] 
	var formarray  =new Array(parent.fram_cnItemDetail.document.frm_consumableItemDetail);
	


	eval( formApply( formarray,PH_CONTROLLER) ) ;
	var formobj=parent.fram_cnItemDetail.document.frm_consumableItemDetail;
	var patient_class = formobj.hdn_patient_class.value;
	var bean_id = formobj.bean_id.value;
	var bean_name = formobj.bean_name.value;
	
	var xmlStr	="<root><SEARCH " ; //added for KAUH-SCF-0229 [IN:056384] Start
	xmlStr +=" /></root>" ;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","ConsumableOrderValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate=GetPrintOrdShtRuleInd",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	var print_ord_sht_rule_ind=trimString(responseText); //added for KAUH-SCF-0229 [IN:056384] End
	
	if( result ){
		//if(parent.parent.f_header.document.prescription_header_form.external_prescription.value =="true"){
			if(patient_class=='OP' || patient_class=='EM'){

				var fldString="";
				var xmlStr	="<root><SEARCH " ;
					xmlStr +=" /></root>" ;
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

				xmlHttp.open("POST","ConsumableOrderValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate=GET_TRNGROUPREF",false);
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText ;
				responseText=trimString(responseText);

				if(responseText != undefined && responseText!=null && responseText!=""){
					var dialogHeight	="12vh" ;
					var dialogWidth	="30vw";
					var dialogTop	= "300" ;
					var dialogLeft	= "300" ;
					var center			= "1" ;
					var status			="no";
					var features	= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
					var arguments	= "";
					retVal = await window.showModalDialog("../../ePH/jsp/TokenListForOrders.jsp?trn_group_ref="+responseText,arguments,features);
				}
			}
	//	}
		alert(getMessage("RECORD_INSERTED", "PH"));
// Code added for printing prescription for Medical Items --IN23133-- 18/08/2010-- priya
			var patient_id=parent.parent.f_header.document.prescription_header_form.patient_id.value;
			var encounter_id=parent.parent.f_header.document.prescription_header_form.encounter_id.value;
			//var patient_class="XT";
			var locn_code=parent.parent.f_header.document.prescription_header_form.source_code.value;
			var print_yn="N";
			//Added for Bru-HIMS-CRF-393_1.0-Start
			var print_confirm="";
				if(print_ord_sht_rule_ind=="C"){
				 print_confirm=confirm(getMessage("PH_PRINT_PRESCRIPTION", "PH"));
			}
			else if(print_ord_sht_rule_ind=="S"){
				print_confirm="true";
			}
			//Added for Bru-HIMS-CRF-393_1.0-End
			if(print_confirm){
				print_yn="Y";
				var xmlStr	="<root><SEARCH " ;
				xmlStr+=" patient_id=\""+ patient_id + "\" ";
				xmlStr+=" encounter_id=\""+ encounter_id + "\" ";
				xmlStr+=" print_yn=\""+ print_yn + "\" ";
				xmlStr+=" patient_class=\""+ patient_class + "\" ";
				xmlStr+=" locn_code=\""+ locn_code + "\" ";
				xmlStr+=" prescriptionPrint=\""+ "Y" + "\" ";
				xmlStr +=" /></root>" ;
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST", "ConsumableOrderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&validate=onLinePrinting" , false ) ;
				xmlHttp.send( xmlDoc ) ;
				eval(xmlHttp.responseText);
			}
		if(parent.parent.f_header.document.prescription_header_form.external_prescription.value =="true"){
			top.parent.window.close();
		}
		else{
			var formObj = parent.parent.f_header.document.prescription_header_form;
			var patient_id     = formObj.patient_id.value;
			var encounter_id   = formObj.encounter_id.value;
			var order_set_code   = formObj.order_set_code.value;
			var formobj=parent.parent.f_header.prescription_header_form;
			var xmlStr	="<root><SEARCH " ;
			xmlStr+=" patient_id=\""+ patient_id + "\" ";
			xmlStr+=" encounter_id=\""+ encounter_id + "\" ";
			xmlStr+=" order_set_code=\""+ order_set_code + "\" ";
			xmlStr +=" /></root>" ;

			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","ConsumableOrderValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&validate=clearData",false);
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText ;
			//eval(responseText);

			parent.parent.parent.criteriaCategoryButtonFrame.location.reload();
			//parent.parent.parent.parent.tabFrame.location.reload();
		}
	}
	else{
		alert(getMessage("EXCEPTION_OCCURED_WHILE_INSERTION", "PH"));
	}
}

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

function dispTitle(error_code, error_text, sys_message_id, row_count){
	if ((error_code == "10" && error_text!="") || sys_message_id!=""){
		if (error_code=="10" && error_text!=""){
			document.getElementById("BL_ERROR"+row_count).title = error_text;
		}
		if(sys_message_id!=""){
			error_text = getMessage(sys_message_id,'BL');
			document.getElementById("BL_ERROR"+row_count).title = error_text;
		}
	}
}

function setSelected_yn(index){
	var formObj = document.frm_consumableItemList;
	var bean_id = formObj.hdn_bean_id.value;
	var bean_name	= formObj.hdn_bean_name.value ;
	if(eval("formObj.chk_Select"+index).checked == true)
		eval("formObj.chk_Select"+index).value = "Y";
	else
		eval("formObj.chk_Select"+index).value = "N";

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	var xmlStr	="<root><SEARCH " ;
	xmlStr += "item_code=\""+ eval("formObj.hdn_item_code"+index).value +"\" " ;
	xmlStr += "index=\""+ eval("formObj.hdn_index"+index).value +"\" " ;
	
	xmlStr += "chk_Select=\""+ eval("formObj.chk_Select"+index).value +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open( "POST", "ConsumableOrderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&validate=setSelected_yn" , false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
}

async function displayStock(item_code,item_name, trade_code,store_code, curr_store_desc, qty_uom_desc) {
	var bean_id	=	document.frmItemNameCommonLookupResult.hdn_bean_id.value;
	var bean_name	=	document.frmItemNameCommonLookupResult.hdn_bean_name.value;
	var dialogHeight	= "80vh";
	var dialogWidth		= "70vw";
	var dialogTop		= "250";
	var dialogLeft		= "200";
	var center			= "0";
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "";
	retVal 				=await  window.showModalDialog("../../ePH/jsp/ConsumableOrderItemStockDetails.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&item_code="+item_code+"&item_name="+item_name+"&trade_code="+trade_code+"&store_code="+store_code+"&curr_store_desc="+curr_store_desc+"&qty_uom_desc="+qty_uom_desc,arguments,features);
}

function noItemAlert(){
	var msg = getMessage("CAN_NOT_BE_BLANK","Common")
		msg = msg.replace('$', getLabel("Common.ItemName.label","Common"));
	alert(msg);
	return false;
}

function changeCursor(obj) {
	obj.style.cursor = "pointer";
}

 async function showImage(item_code, trade_code){
	var dialogHeight= "30vh" ;
	var dialogWidth	= "50vw" ;
	var dialogTop = "111" ;
	var center = "1" ;
	var status="no";
	if(item_code == undefined)
		item_code="";
	if(trade_code == undefined)
		trade_code="";

	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var retVal = await window.showModalDialog("../../ePH/jsp/DrugTradeImage.jsp?drug_code="+item_code+"&trade_code="+trade_code+"&drugyesno=N",arguments,features);
}

async function showPreferredItems(bl_preference_item_code,bl_preference_basis_ind,bean_id,bean_name,bl_disp_charge_dtl_in_drug_lkp_yn,bl_disp_price_type_in_drug_lkp,bl_install_yn,order_type_code,take_home_medication,bl_preference_priority){

	//alert(bl_preference_item_code+"===== "+bl_preference_basis_ind+"===== "+bean_id+"===== "+bean_name+"===== "+order_type_code+"===== "+bl_preference_priority)

if (bl_preference_basis_ind == 'G')
{
	alert(getMessage("PREFERRED_ITEM_SETUP_CANNOT_BE_GENERIC","PH"));
}
else{
	var dialogHeight	="70vh" ;
	var dialogWidth		="65vw";
	var dialogTop		= "250" ;
	var dialogLeft		= "70" ;
	var center			= "0" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	var retVal		=await  window.showModalDialog("../../ePH/jsp/ConsumableOrderPreferredItems.jsp?bl_preference_item_code="+bl_preference_item_code+"&bean_id="+bean_id+"&bean_name="+bean_name+"&order_type_code"+order_type_code+"&bl_preference_priority="+bl_preference_priority,arguments,features);
	if (retVal != undefined)
	{
		//commented by Anbarasi
		//parent.window.close();
		 const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();
		//top.window.returnValue = retVal;	
		let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = retVal;
	}

	}
}
function consumablereset()

{
	
	
	parent.frames[0].document.forms[0].reset();
	parent.frames[1].location.href="../../eCommon/html/blank.html";
	
}
function returnAllSelectedDrugs_preferred(){

	var formObj		= document.forms[0];
	var bean_id		= formObj.hdn_bean_id.value ;
	var bean_name	= formObj.hdn_bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ConsumableOrderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&validate=getSelectedDrugs" , false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
}
function enableDisableSelectButton_preferred(objValue){
	
	var formObj		= document.forms[0];
	if(objValue == 'false')
		formObj.selectPreferredItem.disabled	=	false;
	else
		formObj.selectPreferredItem.disabled	=	true;
}

function checkSplChars(obj)	{
	if(!CheckChars(obj))	{
		alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","PH"));
		obj.value="";
		//obj.select();
	}
}

			function storeVal(currad) {
					//radioval = currad;
					document.frm_consumableItemLkpCriteria.searchby.value=currad;
			}
			
function selectOne(){
	alert(getMessage("PH_ATLEAST_ONE_SELECTED","PH"));
	return false;
}

function ChkForZero(obj){
	
	if(parseFloat(obj.value) == '0'){
		alert(getMessage("ABS_QTY_CANNOT_ZERO","PH"));
		var qty_value		= frm_consumableItemDetail.txt_qty_value.value='' ;
	}

}

// added for SRR20056-SCF-6434 [IN:025880]
function loadFrameDetails(params){
	if(document.frm_consumableItemDetail.txt_item_desc.value ==null || document.frm_consumableItemDetail.txt_item_desc.value =="" ){
		parent.fram_cnItemList.document.location.href="../../ePH/jsp/ConsumableOrderItemList.jsp?params="+params;
		parent.fram_cnButtons.document.location.href="../../ePH/jsp/ConsumableOrderButtons.jsp?params="+params;
	}
}

function alertDupFound (){//added for KDAH-SCF-0326 [IN:056879] 
	alert(getMessage("PH_DUPLICATE_ITEM_NOT_ALLOWED","PH"));
	return false;
}

//GHL-CRF-0470 starts

async function callMedicationRemarks(index){
	var formobj		=	document.frm_consumableItemList;
	var MedicationRemarks	=	eval("formobj.MedicationRemarks_"+index).value;
	var item_code	=	eval("formobj.hdn_item_code"+index).value;
	var bean_id = formobj.hdn_bean_id.value;
	var bean_name	= formobj.hdn_bean_name.value ;
	var mode=formobj.mode.value;
	var dialogHeight= "53vh" ;
	var dialogWidth	= "38vw" ;
	var dialogTop = "" ;
	var dialogLeft ="";
	var center = "0" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" +dialogTop+"; dialogLeft :"+dialogLeft;
	var arguments	= "" ;
	var dialogUrl		="../../ePH/jsp/MedicationRemarks.jsp?mode="+mode+"&item_code="+item_code+"&index="+index+"&MedicationRemarks="+encodeURIComponent(MedicationRemarks);
	retVal = await window.showModalDialog(dialogUrl,arguments,features);
	if(retVal!= undefined && retVal!=null){
		eval("formobj.MedicationRemarks_"+index).value=retVal;	//Modified for GHL-CRF-0470 // decodeURIComponent(retVal) changed to retVal for IN:065199
		eval("formobj.hdn_remarks"+index).value=decodeURIComponent(retVal);	//Modified for GHL-CRF-0470
	}
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr	="<root><SEARCH " ;
	xmlStr += "item_code=\""+ eval("formobj.hdn_item_code"+index).value +"\" " ;
	xmlStr += "index=\""+ eval("formobj.hdn_index"+index).value +"\" " ;
	xmlStr += "medication_remarks=\""+ eval("formobj.MedicationRemarks_"+index).value +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ConsumableOrderValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&validate=itemRemarks" , false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);	
}

function savedrugIndicationRemarks(medication_indicate){
	var medication_indicate_new = encodeURIComponent(medication_indicate.value);
	//window.returnValue=medication_indicate_new;
	//window.close();
	let dialogBody = parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = medication_indicate_new;
    
    const dialogTag = parent.document.getElementById("dialog_tag");    
    dialogTag.close();   
}
function checkDrugIndMaxLimit(obj,maxLeng) { 
	if(obj.value.length > maxLeng) {
		val = obj.value;
		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$",getLabel("ePH.MedicationRemarks.label","PH"));
		msg = msg.replace("#",maxLeng);
		obj.value = val.substring(0,(val.length)-1);
		alert(msg);
		obj.focus();
		return false;
	} 
	else 
		return true;
}
function displayToolTipRemark(obj,index){	//Added for GHL-CRF-0470
	obj.title = eval("document.frm_consumableItemList.hdn_remarks"+index).value;	
}
//GHL-CRF-0470 ends
	async function displayAlternateItem(item_code,item_tech_name,act_patient_class){ // Added for GHL-CRF-0548 [IN:068345] - Start - Devindra		 		
		var frmObj = document.frmItemNameCommonLookupResult;
		var bl_install_yn	=   frmObj.bl_install_yn.value;
		var bl_disp_charge_dtl_in_drug_lkp_yn	=frmObj.bl_disp_charge_dtl_in_drug_lkp_yn.value;
		var bl_disp_price_type_in_drug_lkp	=frmObj.bl_disp_price_type_in_drug_lkp.value;
		var take_home_medication=frmObj.take_home_medication.value;		
		var priority			=frmObj.priority.value;
		var from = frmObj;
		var store_name = frmObj.store_name.value; 
		var disp_locn_code = frmObj.disp_locn_code.value;
		var patient_id = frmObj.patient_id.value;
		var encounter_id = frmObj.encounter_id.value;
		var dialogHeight= "80vh" ;
		var dialogWidth	= "70vw" ;
		var dialogTop	= "270";
		var dialogLeft	= "200";
		var center		= "0";
		var status		= "no";
		var features	= "dialogHeight:" + dialogHeight +"; dialogLeft:"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "";	
		var dialogUrl = "../../ePH/jsp/ItemSearchAlternateItem.jsp?bl_disp_charge_dtl_in_drug_lkp_yn="+bl_disp_charge_dtl_in_drug_lkp_yn+"&bl_disp_price_type_in_drug_lkp="+bl_disp_price_type_in_drug_lkp+"&item_code="+item_code+"&priority="+priority+"&take_home_medication="+take_home_medication+"&store_name="+store_name+"&disp_locn_code="+disp_locn_code+"&bl_install_yn="+bl_install_yn+"&item_tech_name="+item_tech_name+"&act_patient_class="+act_patient_class+"&patient_id="+patient_id+"&encounter_id="+encounter_id;
		var	retVal 		=await window.showModalDialog(dialogUrl,arguments,features);
	 if(retVal!=undefined){
		parent.window.returnValue = retVal;
		parent.window.close();
	 }
	} 
function checkAllowAlternate(obj){
	if(obj.checked==true)
		obj.value="Y";
	else
		obj.value="N"
}
function selectAltItem(index,promptAlert){	
	if (promptAlert == 'Y')
	{  
	      if (!(confirm(getMessage("PREFERRED/DRUG_ITEM_INSRUCTION",'PH'))))
	      {
			var retVal = "";
			var formObj = document.frmAltItemSearchAlternateItemResult;
			var item_code = eval("formObj.hdn_item_code"+index).value;
			var trade_code = eval("formObj.hdn_trade_code"+index).value;
			var trade_name = eval("formObj.hdn_trade_name"+index).value;
			retVal=item_code+":::"+trade_code+":::"+trade_name;
			parent.parent.window.returnValue = retVal.split(":::") ;
			parent.window.close();			
	      }	
	}
	else{
		var retVal = "";
		var formObj = document.frmAltItemSearchAlternateItemResult;
		var item_code = eval("formObj.hdn_item_code"+index).value;
		var trade_code = eval("formObj.hdn_trade_code"+index).value;
		var trade_name = eval("formObj.hdn_trade_name"+index).value;
		retVal=item_code+":::"+trade_code+":::"+trade_name;
		parent.window.returnValue = retVal.split(":::") ;				
		parent.window.close();
	}
}
function selectItemIfAltItemNotAppl(index,promptAlert){
	if (promptAlert == 'Y')
	{  
	      if (!(confirm(getMessage("PREFERRED/DRUG_ITEM_INSRUCTION",'PH'))))
	      {
			var retVal = "";
			var formObj = document.frmItemNameCommonLookupResult;
			var item_code = eval("formObj.hdn_item_code"+index).value;
			var trade_code = eval("formObj.hdn_trade_code"+index).value;
			var trade_name = eval("formObj.hdn_trade_name"+index).value;
			retVal=item_code+":::"+trade_code+":::"+trade_name;
			parent.window.returnValue = retVal.split(":::") ;
			parent.window.close();
	      }	
	}
	else{
		var retVal = "";
		var formObj = document.frmItemNameCommonLookupResult;
		var item_code = eval("formObj.hdn_item_code"+index).value;
		var trade_code = eval("formObj.hdn_trade_code"+index).value;
		var trade_name = eval("formObj.hdn_trade_name"+index).value;
		retVal=item_code+":::"+trade_code+":::"+trade_name;
		parent.window.returnValue = retVal.split(":::") ;
		parent.window.close();
	}
}
//GHL-CRF-0618 - start
async function formularyNonPreference(drug_code,patient_id,encounter_id,bean_id,bean_name){
		var dialogHeight= "70vh" ;
		var dialogWidth	= "60vw" ;
		var dialogTop = "195" ;
		var center = "1" ;
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+";scroll:no";
		var arguments	= "" ;
		retVal =await window.showModalDialog("../../ePH/jsp/PhNonPreferableRemarks.jsp?item_code="+drug_code+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&called_from=M",arguments,features);


		if(retVal!=undefined && retVal==true){
			return true;
		}else{
			return false;
		}

} 

function closeRemarksWindow(){
window.returnValue = true;
window.close();   
}

function saveNonPreRemForMedItem(item_code,patient_id,encounter_id,bean_id,bean_name){
	var formobj = document.formNonPreferenceRemarks;
	var remarks_code = formobj.non_prefered_item_remarks.value;

	var xmlStr	="<root><SEARCH " ;
//	var xmlDoc		= new ActiveXObject("Microsoft.XMLDom") ;
//	var xmlHttp		= new ActiveXObject("Microsoft.XMLHTTP") ;
	var xmlDoc = ""; 
	var xmlHttp = new XMLHttpRequest();
	xmlStr		+="bean_id"+"=\""+ bean_id+"\" " ;
	xmlStr		+="bean_name"+"=\""+ bean_name+"\" " ;
	xmlStr += "patient_id=\""+patient_id +"\" " ;
	xmlStr += "encounter_id=\""+encounter_id +"\" " ;
	xmlStr += "item_code=\""+item_code +"\" " ;
	xmlStr += "remarks_code=\""+remarks_code +"\" " ;
	
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","ConsumableOrderValidate.jsp?validate=nonPreferenceRemarks&bean_id="+ bean_id + "&bean_name="+bean_name, false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);

} 
//GHL-CRF-0618 - end
// Added for GHL-CRF-0548 [IN:068345] - End - Devindra
//Added By Himanshu for GHL-SCF-1738-->
function alertNoAvailStock(){
	alert(getMessage("PH_NO_STOCK_AVAIL_DRUG", "PH"));
	return_val=false;
}
