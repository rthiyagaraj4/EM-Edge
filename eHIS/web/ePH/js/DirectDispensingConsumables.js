//itemSearchlkp(bean_id, bean_name, bl_install_yn, bl_disp_charge_dtl_in_drug_lkp_yn, bl_disp_price_type_in_drug_lkp, take_home_medication, priority, patient_id, encounter_id, location_code, location_type)
function ConsumableitemSearch(){
	var item_desc			   =  	document.frm_disp_consumableItemcriteria.txt_item_desc.value;
	var bean_id			   =	document.frm_disp_consumableItemcriteria.bean_id.value;
	var bean_name			   =	document.frm_disp_consumableItemcriteria.bean_name.value;
	var bl_install_yn		   =	document.frm_disp_consumableItemcriteria.hdn_bl_install_yn.value;
	var bl_disp_charge_dtl_in_drug_lkp_yn	=	document.frm_disp_consumableItemcriteria.hdn_bl_disp_charge_dtl_in_drug_lkp_yn.value;
	var bl_disp_price_type_in_drug_lkp	=	document.frm_disp_consumableItemcriteria.hdn_bl_disp_price_type_in_drug_lkp.value;
	var patient_id			=	document.frm_disp_consumableItemcriteria.hdn_patient_id.value;
	var encounter_id			=	document.frm_disp_consumableItemcriteria.hdn_encounter_id.value;

	var retVal = itemSearchlkp(item_desc,bean_id, bean_name, bl_install_yn, bl_disp_charge_dtl_in_drug_lkp_yn, bl_disp_price_type_in_drug_lkp, 'N', 'R', patient_id, encounter_id, '', '');

	if(retVal != undefined || retVal!=null){
		var Item_Codes =  new Array();
		var	Trade_Codes = new Array();
		var Trade_Names = new Array();
		var i=0;
		var index=0;
		if(retVal.length>0){
			while(i<retVal.length){
				Item_Codes[index]=retVal[i++];
				Trade_Codes[index]=retVal[i++];
				Trade_Names[index++]=retVal[i++];
			}
		}
		if(Item_Codes.length>0 ){
			SetItemDetails(Item_Codes, Trade_Codes, Trade_Names );
		}
	}
}

function SetItemDetails(Item_Codes, Trade_Codes, Trade_Names){
   
	var bl_install_yn	= document.frm_disp_consumableItemcriteria.hdn_bl_install_yn.value ;
	var count           =0;
	if(parent.Disp_cons_item_result.document.frm_consumableItemDatail.count!=null){
	   count           = parent.Disp_cons_item_result.document.frm_consumableItemDatail.count.value;
	}

	var take_home_medication ="N";
	var priority	    ="R";
	

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	var xmlStr	="<root><SEARCH " ;
	xmlStr+=" itemCodes=\""+ Item_Codes + "\" ";
	xmlStr+=" tradeCodes=\""+ Trade_Codes + "\" ";
	xmlStr+=" tradeNames=\""+ Trade_Names + "\" ";
	xmlStr+=" take_home_medication=\""+ take_home_medication + "\" ";
	xmlStr+=" priority=\""+ priority + "\" ";
	xmlStr += " bl_install_yn=\""+ bl_install_yn + "\" ";
	xmlStr+= "all_stages_bean_id=\"" + parent.Disp_cons_item_result.document.frm_consumableItemDatail.bean_id.value + "\" " ;
	xmlStr+= "all_stages_bean_name=\"" + parent.Disp_cons_item_result.document.frm_consumableItemDatail.bean_name.value + "\" " ;
	xmlStr+= "count=\"" + count + "\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
//alert(xmlStr);
	var bean_id  = "DirectDispensingBean";
	var bean_name= "ePH.DirectDispensingBean";

	xmlHttp.open( "POST", "DirectDispValidate.jsp?identity=SetItemDetails"+"&bean_id=" + bean_id + "&bean_name=" + bean_name , false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
}
function setItemValues(item_desc){
	 var params      = parent.Disp_cons_items_criteria.document.frm_disp_consumableItemcriteria.params.value;
	 parent.Disp_cons_items_criteria.document.frm_disp_consumableItemcriteria.txt_item_desc.value=  decodeURIComponent(item_desc,"UTF-8"); //Decode added for MMS-SCF-0369 [IN:049801]
     parent.Disp_cons_item_result.document.location.href="../../ePH/jsp/DirectDispensingConsumablesItemsDetails.jsp?"+params;
}

function assignval(item_code,disp_locn_code,rec_no) {
	
	var  retVal		        = callConsumableBatchSearchWindow(item_code, disp_locn_code);
	var bl_install_yn          = document.frm_consumableItemDatail.bl_install_yn.value;	// Added for [IN:047652] 

	if(retVal!=undefined && retVal!=''){
		record					=	retVal.split("`");
		var batch_id			= record[0];
		var item_code			= record[1];
		var item_name			= record[2];
		var store_code			= record[3];
		var store_desc			= record[4];				
		var expiry_date			= record[6];
		var bin_locn_code		= record[7];
		var bin_locn_desc		= record[8];
		var trade_id			= record[9];
		var trade_desc			= record[10];
		var	manufacturer_code	= record[13];
		var manufacturer_desc	= record[14];
		var avail_qty			= record[15];
        var grossAmountDispYN   = ""; // Added for ML-BRU-CRF-0469 [IN:065426] - Start
        if(document.getElementById("grossAmountDispYN") !=undefined){
        	grossAmountDispYN = document.getElementById("grossAmountDispYN").value;
        } // Added for ML-BRU-CRF-0469 [IN:065426] - End
		eval("document.frm_consumableItemDatail.alloc_qty_"+rec_no).disabled=false;
		eval("document.frm_consumableItemDatail.batch_id_"+rec_no).value  = batch_id;

		eval(document.getElementById("td_exp_date_"+rec_no)).innerText      = expiry_date;
		eval(document.getElementById("alloc_qty_"+rec_no)).value      = "";//Added for AD-HOC MMSBETA ISSUE -Start
		eval(document.getElementById("td_ord_qty_"+rec_no)).innerText      = "";
		if(bl_install_yn=='Y'){		// if Added for [IN:047652] 
			eval(document.getElementById("td_gross_charge_amt_"+rec_no)).innerText      = "";
			eval(document.getElementById("td_pat_payable_amt_"+rec_no)).innerText      = "";//Added for AD-HOC MMSBETA ISSUE -Start
			if(grossAmountDispYN=="true"){ // Added for ML-BRU-CRF-0469 [IN:065426] 
			  eval(document.getElementById("td_gross_amt_"+rec_no)).innerText      = ""; // Added for ML-BRU-CRF-0469 [IN:065426]
			}
		}
		eval(document.getElementById("td_trade_name_"+rec_no)).innerText    = trade_desc;
		eval(document.getElementById("td_avail_qty_"+rec_no)).innerText     = avail_qty;
		eval("document.frm_consumableItemDatail.trade_id_"+rec_no).value          = trade_id;
		eval("document.frm_consumableItemDatail.exp_date_"+rec_no).value      = expiry_date;
		eval("document.frm_consumableItemDatail.bin_loc_code_"+rec_no).value     = bin_locn_code;
		eval("document.frm_consumableItemDatail.item_code_"+rec_no).value        = item_code;

		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();

		var xmlStr	="<root><SEARCH " ;
		xmlStr+=" batch_id=\""+ batch_id + "\" ";
		xmlStr+=" item_code=\""+ item_code + "\" ";
		xmlStr+=" item_name=\""+ item_name + "\" ";
		xmlStr+=" store_code=\""+ store_code + "\" ";
		xmlStr+=" store_desc=\""+ store_desc + "\" ";
		xmlStr+=" expiry_date=\""+ expiry_date + "\" ";
		xmlStr+=" bin_locn_code=\""+ bin_locn_code + "\" ";
		xmlStr+=" bin_locn_desc=\""+ bin_locn_desc + "\" ";
		xmlStr+=" trade_id=\""+ trade_id + "\" ";
		xmlStr+=" trade_desc=\""+ trade_desc + "\" ";
		xmlStr+=" manufacturer_code=\""+ manufacturer_code + "\" ";
		xmlStr+=" manufacturer_desc=\""+ encodeURIComponent(manufacturer_desc,"UTF-8") + "\" ";
		xmlStr+=" avail_qty=\""+ avail_qty + "\" ";
		xmlStr+= "sysdate=\"" + document.frm_consumableItemDatail.sysdate.value + "\" " ; 
		xmlStr+= "all_stages_bean_id=\"" + parent.Disp_cons_item_result.document.frm_consumableItemDatail.bean_id.value + "\" " ;
		xmlStr+= "all_stages_bean_name=\"" + parent.Disp_cons_item_result.document.frm_consumableItemDatail.bean_name.value + "\" " ;
		xmlStr+= "rec_no=\"" + rec_no + "\" " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

		var bean_id  = "DirectDispensingBean";
		var bean_name= "ePH.DirectDispensingBean";

		xmlHttp.open( "POST", "DirectDispValidate.jsp?identity=SetBatchDetails"+"&bean_id=" + bean_id + "&bean_name=" + bean_name , false ) ;
		xmlHttp.send( xmlDoc ) ;
		//alert(" assignval  "+xmlHttp.responseText);
		eval(xmlHttp.responseText);
   }
}

async function callConsumableBatchSearchWindow(item_code, store_code) {
	var includeZeroStockBatches	= "N";
	var includeExpiredBatches	= "N";
	var includeSuspendedBatches	= "N";
	var searchFunction			= "Y";
	var multipleSelect			= "Y";
	var dialogHeight			= "30vh";
	var dialogWidth				= "55vw";
	var dialogTop				= "100";
	var dialogLeft				= "200";
	var center					= "0";
	var status					= "no";
	var features				= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments				= "";
	retVal = await window.showModalDialog("../../eST/jsp/BatchSearchFrame.jsp?item_code="+item_code+"&store_code="+store_code+"&includeZeroStockBatches="+includeZeroStockBatches+"&includeExpiredBatches="+includeExpiredBatches+"&includeSuspendedBatches="+includeSuspendedBatches+"&searchFunction="+searchFunction+"&multipleSelect='N'", arguments, features);
	return retVal;
}

function getConsumableBillingDetails(rec_no){

	 var alloc_qty            =  eval("document.frm_consumableItemDatail.alloc_qty_"+rec_no).value;
	 var ord_qty              =  eval("document.frm_consumableItemDatail.hdn_ord_qty_"+rec_no).value;
	 var bl_install_yn        =  document.frm_consumableItemDatail.bl_install_yn.value;          
	 var ord_uom              =  eval("document.frm_consumableItemDatail.hdn_ord_uom_"+rec_no).value;
	 if(ord_qty==''&&alloc_qty!=''){
	  
		   ord_qty_obj        =  eval(document.getElementById("td_ord_qty_"+rec_no));
		   ord_qty_obj.innerHTML  ="<label>&nbsp;&nbsp;"+alloc_qty +" <b>"+ord_uom+"</b></label>";
		   ord_qty =alloc_qty;
	 }
     if(alloc_qty==''){
		alloc_qty ='0';
		ord_qty_obj        =  eval(document.getElementById("td_ord_qty_"+rec_no));
		ord_qty_obj.innerHTML  ="<label>&nbsp;&nbsp;"+alloc_qty +" <b>"+ord_uom+"</b></label>";
        ord_qty =alloc_qty;
	}
	// if(bl_install_yn=='Y'){
	if( verifyMoreqty(rec_no)){ // alloc_qty!=''){// cpmmented Added verifyMoreqty for AD-HOC MMS ADHOC Testing
		 //if(parseInt(alloc_qty)<=parseInt(ord_qty)){
		 var  patient_id					 =  document.frm_consumableItemDatail.patient_id.value;
		 var  encounter_id					 =  document.frm_consumableItemDatail.encounter_id.value;
		 var  sal_trn_type					 =  document.frm_consumableItemDatail.sal_trn_type.value;
		 var  sysdate						 =  document.frm_consumableItemDatail.sysdate.value;
		 var  store_code					 =  document.frm_consumableItemDatail.disp_locn_code.value;			 
		 var  tot_gross_charge_amount		 =  document.frm_consumableItemDatail.tot_cons_gross_charge_amount.value;
		 var  tot_groos_pat_payable			 =  document.frm_consumableItemDatail.tot_cons_groos_pat_payable.value;
		 var  tot_groos_amt			 =  document.frm_consumableItemDatail.tot_groos_amt.value; //  Added for ML-BRU-CRF-0469 [IN:065426]
			 
		 var  old_gross_charge_amount        =  eval("document.frm_consumableItemDatail.gross_charge_amount_"+rec_no).value;
		 var  old_groos_pat_payable          =  eval("document.frm_consumableItemDatail.groos_pat_payable_"+rec_no).value;
		 var  old_tot_groos_amt              =  eval("document.frm_consumableItemDatail.gross_amt_"+rec_no).value; //  Added for ML-BRU-CRF-0469 [IN:065426]
		 var  item_code                      =  eval("document.frm_consumableItemDatail.item_code_"+rec_no).value;

		 var batch_str = eval("document.frm_consumableItemDatail.trade_id_"+rec_no).value+";"+eval("document.frm_consumableItemDatail.batch_id_"+rec_no).value+";"+eval("document.frm_consumableItemDatail.exp_date_"+rec_no).value+";"+eval("document.frm_consumableItemDatail.bin_loc_code_"+rec_no).value+";"+alloc_qty+";"	
			
			var xmlStr ="<root><SEARCH ";	
			xmlStr+= "all_stages_bean_id=\"" + document.frm_consumableItemDatail.bean_id.value + "\" " ;
			xmlStr+= "all_stages_bean_name=\"" + document.frm_consumableItemDatail.bean_name.value + "\" " ;
			xmlStr+= "Srl_no=\"" + rec_no + "\" " ;	
			xmlStr+= "drug_code=\"" + item_code + "\" " ;				
			xmlStr+= "tot_alloc_qty=\"" + alloc_qty + "\" " ;
			xmlStr+= "patient_id=\"" + patient_id + "\" " ;
			xmlStr+= "encounter_id=\"" + encounter_id + "\" " ;
			xmlStr+= "sal_trn_type=\"" + sal_trn_type + "\" " ;
			xmlStr+= "sysdate=\"" + sysdate + "\" " ;
			xmlStr+= "store_code=\"" + store_code + "\" " ;
			xmlStr+= "batch_str=\"" + batch_str + "\" " ; //encodeURIComponent removed
			xmlStr+= "tot_gross_charge_amount=\"" + tot_gross_charge_amount + "\" " ;
			xmlStr+= "tot_groos_pat_payable=\""   + tot_groos_pat_payable + "\" " ;
			xmlStr+= "tot_groos_amt=\""   + tot_groos_amt + "\" " ; // Added for ML-BRU-CRF-0469 [IN:065426]
			xmlStr+= "old_gross_charge_amount=\"" + old_gross_charge_amount + "\" " ;
			xmlStr+= "old_groos_pat_payable=\""   + old_groos_pat_payable + "\" " ;
			xmlStr+= "old_tot_groos_amt=\""   + old_tot_groos_amt + "\" " ; // Added for ML-BRU-CRF-0469 [IN:065426]
			xmlStr+= "bl_install_yn=\""   + bl_install_yn + "\" " ;
			
			xmlStr +=" /></root>";	
			var bean_id  = "DirectDispensingBean";
			var bean_name= "ePH.DirectDispensingBean";						
			var temp_jsp="DirectDispValidate.jsp?identity=StoreConcumableBillingDetails"+"&bean_id="+bean_id+"&bean_name="+bean_name;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText ;
			eval(responseText);
	 /*  }else{
		   alert(getMessage("PH_ALLOC_QTY_LESS_OR_EQUAL_ORDERED_QTY","PH"));
	   }*/
	} 
	// }
}

function setConsumableBillingAmounts(err_msg,srl_no,gross_charge_amount,groos_pat_payable,tot_gross_charge_amount,tot_groos_pat_payable,gross_charge_amount_payable){ // gross_charge_amount_payable  Added for ML-BRU-CRF-0469 [IN:065426] 
	var disp_stage  ="D";// document.frm_consumableItemDatail.disp_stage.value;
	
	var grossAmountDispYN   = ""; // Added for ML-BRU-CRF-0469 [IN:065426] - Start
    if(document.getElementById("grossAmountDispYN") !=undefined){
    	grossAmountDispYN = document.getElementById("grossAmountDispYN").value;
    } // Added for ML-BRU-CRF-0469 [IN:065426] - End
	
	if(err_msg==''){
		eval(document.getElementById("gross_charge_amount_"+srl_no)).value                  =   gross_charge_amount;
		eval(document.getElementById("groos_pat_payable_"+srl_no)).value                    =   groos_pat_payable;	
		
		if(grossAmountDispYN=="true"){ // Added for ML-BRU-CRF-0469 [IN:065426] - Start 
			eval(document.getElementById("gross_amt_"+srl_no)).value                    =   gross_charge_amount_payable;
		} // Added for ML-BRU-CRF-0469 [IN:065426]  -End

		eval(document.getElementById("td_gross_charge_amt_"+srl_no)).innerHTML	="<label style='font-size:9;color:black'>&nbsp;&nbsp;"+gross_charge_amount+"</label>";
		eval(document.getElementById("td_pat_payable_amt_"+srl_no)).innerHTML	="<label style='font-size:9;color:black'>&nbsp;&nbsp;"+groos_pat_payable+"</label>";
		if(grossAmountDispYN=="true"){ // Added for ML-BRU-CRF-0469 [IN:065426] - Start 
			eval(document.getElementById("td_gross_amt_"+srl_no)).innerHTML	="<label style='font-size:9;color:black'>&nbsp;&nbsp;"+gross_charge_amount_payable+"</label>";
		} // Added for ML-BRU-CRF-0469 [IN:065426]  -End
		document.frm_consumableItemDatail.tot_cons_gross_charge_amount.value	=	tot_gross_charge_amount;
		document.frm_consumableItemDatail.tot_cons_groos_pat_payable.value	    =	tot_groos_pat_payable;

		select_obj = eval("document.frm_consumableItemDatail.select_"+srl_no); 
		if(disp_stage!='D'){
			select_obj.disabled=false;
		}
		select_obj.checked = true;
		select_obj.value   = "Y";

		var total_payable   = getLabel("ePH.TotalChargeAmount.label","PH");
		var patient_payable = getLabel("ePH.TotalPayableAmount.label","PH");
		//parent.f_disp_medication_all_stages_legends.document.getElementById("total_payable").innerHTML	="<label >"+total_payable+"      : "+tot_gross_charge_amount+"</label>";
		// parent.f_disp_medication_all_stages_legends.document.getElementById("patient_payable").innerHTML	="<label >"+patient_payable+"       : "+tot_groos_pat_payable+"</label>";
	}
	else{
         eval(document.getElementById("td_gross_charge_amt_"+srl_no)).innerHTML	="<label style='font-size:11;color:red'  title='"+err_msg+"'>&nbsp;&nbsp;"+getLabel("Common.Error.label","Common")+"</label>";
		 eval(document.getElementById("td_pat_payable_amt_"+srl_no)).innerHTML	="<label style='font-size:11;color:red'  title='"+err_msg+"'>&nbsp;&nbsp;"+getLabel("Common.Error.label","Common")+"</label>";
		 if(grossAmountDispYN=="true"){ // Added for ML-BRU-CRF-0469 [IN:065426] - Start 
				eval(document.getElementById("td_gross_amt_"+srl_no)).innerHTML	="<label style='font-size:11;color:red'  title='"+err_msg+"'>&nbsp;&nbsp;"+getLabel("Common.Error.label","Common")+"</label>";
				 eval(document.getElementById("td_gross_amt_"+srl_no)).value                  =   "";    	
		 } // Added for ML-BRU-CRF-0469 [IN:065426]  -End
		 eval(document.getElementById("gross_charge_amount_"+srl_no)).value                  =   "";
		 eval(document.getElementById("groos_pat_payable_"+srl_no)).value                    =   "";
		 select_obj = eval("document.frm_consumableItemDatail.select_"+srl_no);
         select_obj.checked = false;
		 select_obj.value   = "N";
		 select_obj.disabled=true;
	}
}

function setvalue (rec_no){
	var select_obj  = eval("document.frm_consumableItemDatail.select_"+rec_no);
	var selected_yn ="N";
	if(select_obj.checked==true){
		selected_yn ="Y";
	}

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	var xmlStr	="<root><SEARCH " ;
	xmlStr+=" rec_no=\""+ rec_no + "\" ";
	xmlStr+=" selected_yn=\""+ selected_yn + "\" ";	
	xmlStr+= "all_stages_bean_id=\"" + document.frm_consumableItemDatail.bean_id.value + "\" " ;
	xmlStr+= "all_stages_bean_name=\"" +document.frm_consumableItemDatail.bean_name.value + "\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var bean_id  = "DirectDispensingBean";
	var bean_name= "ePH.DirectDispensingBean";
	xmlHttp.open( "POST", "DirectDispValidate.jsp?identity=SetSelectedRecord"+"&bean_id=" + bean_id + "&bean_name=" + bean_name , false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
}

function RecordDetails(){
	//window.close();
	//Added for MMS AdhocTesting-Start
	if(parent.Disp_cons_item_result) {
		var count = parent.Disp_cons_item_result.document.frm_consumableItemDatail.count.value;
		var tot_cons_gross_charge_amount_tot,tot_cons_groos_pat_payable_tot;
		var tot_cons_gross_charge_amount =	0;
		var tot_cons_groos_pat_payable	 =  0;
		var tot_cons_gross_amount        =  0,tot_cons_gross_amount_tot=0; // Added for ML-BRU-CRF-0469 [IN:065426]
		var chk							=   "";
		for(var i=0;i<count;i++) {
			tot_cons_gross_charge_amount_tot = eval("parent.Disp_cons_item_result.document.frm_consumableItemDatail.gross_charge_amount_"+i+".value"); 
			if(tot_cons_gross_charge_amount_tot!=""){
				tot_cons_gross_charge_amount	=	tot_cons_gross_charge_amount+parseFloat(tot_cons_gross_charge_amount_tot);
			 }
			tot_cons_groos_pat_payable_tot = eval("parent.Disp_cons_item_result.document.frm_consumableItemDatail.groos_pat_payable_"+i+".value");

		   if(tot_cons_groos_pat_payable_tot!=""){
				tot_cons_groos_pat_payable		=	tot_cons_groos_pat_payable+parseFloat(tot_cons_groos_pat_payable_tot);
			}
		 if(eval("parent.Disp_cons_item_result.document.frm_consumableItemDatail.gross_amt_"+i)!=undefined){
			 tot_cons_gross_amount_tot = eval("parent.Disp_cons_item_result.document.frm_consumableItemDatail.gross_amt_"+i+".value"); // Added for ML-BRU-CRF-0469 [IN:065426] - Start
		 }
		   if(tot_cons_gross_amount_tot!="")
			   tot_cons_gross_amount = tot_cons_gross_amount + parseFloat(tot_cons_gross_amount_tot); // Added for ML-BRU-CRF-0469 [IN:065426] - End 
		}
		if(tot_cons_gross_charge_amount!="" || tot_cons_groos_pat_payable!="" || tot_cons_gross_amount!=""){ // || tot_cons_gross_amount!="" Added for ML-BRU-CRF-0469 [IN:065426] 
			/*window.returnValue=tot_cons_gross_charge_amount+"|"+tot_cons_groos_pat_payable+"|"+tot_cons_gross_amount; // +"|"+tot_cons_gross_amount Added for ML-BRU-CRF-0469 [IN:065426]
			window.close();*/
			parent.document.getElementById('dialog-body').contentWindow.returnValue = tot_cons_gross_charge_amount+"|"+tot_cons_groos_pat_payable+"|"+tot_cons_gross_amount; // +"|"+tot_cons_gross_amount Added for ML-BRU-CRF-0469 [IN:065426]
			parent.document.getElementById('dialog_tag').close();  

		}
		else{
			//window.close();
			parent.document.getElementById('dialog_tag').close();  

		}
	} 
	else {
		//window.close();
		parent.document.getElementById('dialog_tag').close();  

	}//Added for MMS AdhocTesting-End
}

function clearvalues(rec_no){
	var batch_obj          = eval("document.frm_consumableItemDatail.batch_id_"+rec_no);
	var grossAmountDispYN   = ""; // Added for ML-BRU-CRF-0469 [IN:065426] - Start
    if(document.getElementById("grossAmountDispYN") !=undefined){
    	grossAmountDispYN = document.getElementById("grossAmountDispYN").value;
    } // Added for ML-BRU-CRF-0469 [IN:065426] - End
	if(batch_obj.value==''){
		var exp_date_obj        = eval(document.getElementById("td_exp_date_"+rec_no));
		exp_date_obj.innerText      = "";

		var trade_name_obj       = eval(document.getElementById("td_trade_name_"+rec_no));
		trade_name_obj.innerText    = "";

		var avail_qty_obj        = eval(document.getElementById("td_avail_qty_"+rec_no));
		avail_qty_obj.innerText     = "";

		var trade_id_obj         = eval("document.frm_consumableItemDatail.trade_id_"+rec_no);
		trade_id_obj.value          = "";

		var expiary_date_obj     = eval("document.frm_consumableItemDatail.exp_date_"+rec_no);
		expiary_date_obj.value      = "";

		var bin_loc_code_obj     = eval("document.frm_consumableItemDatail.bin_loc_code_"+rec_no);
		bin_loc_code_obj.value     = "";

		var item_code_obj        = eval("document.frm_consumableItemDatail.item_code_"+rec_no);
		item_code_obj.value        = "";

		eval("document.frm_consumableItemDatail.alloc_qty_"+rec_no).disabled=true;	
		eval("document.frm_consumableItemDatail.alloc_qty_"+rec_no).value="";	

		eval(document.getElementById("gross_charge_amount_"+rec_no)).value                  =   "";
		eval(document.getElementById("groos_pat_payable_"+rec_no)).value                    =   "";			
		if(grossAmountDispYN=="true"){ // Added for ML-BRU-CRF-0469 [IN:065426] - Start 
			eval(document.getElementById("td_gross_amt_"+rec_no)).value                    =   "";	
		} // Added for ML-BRU-CRF-0469 [IN:065426]  -End

		eval(document.getElementById("td_gross_charge_amt_"+rec_no)).innerHTML	="<label style='font-size:9;color:black'>&nbsp;&nbsp;</label>";
		eval(document.getElementById("td_pat_payable_amt_"+rec_no)).innerHTML	="<label style='font-size:9;color:black'>&nbsp;&nbsp;</label>";
		if(grossAmountDispYN=="true"){ // Added for ML-BRU-CRF-0469 [IN:065426] - Start 
			eval(document.getElementById("td_gross_amt_"+rec_no)).innerHTML	="<label style='font-size:9;color:black'>&nbsp;&nbsp;</label>";
		} // Added for ML-BRU-CRF-0469 [IN:065426]  -End
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();

		var xmlStr	="<root><SEARCH " ;
		xmlStr+= "all_stages_bean_id=\"" + parent.Disp_cons_item_result.document.frm_consumableItemDatail.bean_id.value + "\" " ;
		xmlStr+= "all_stages_bean_name=\"" + parent.Disp_cons_item_result.document.frm_consumableItemDatail.bean_name.value + "\" " ;
		xmlStr+= "rec_no=\"" + rec_no + "\" " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

		var bean_id  = "DirectDispensingBean";
		var bean_name= "ePH.DirectDispensingBean";

		xmlHttp.open( "POST", "DirectDispValidate.jsp?identity=clearBatchDetails"+"&bean_id=" + bean_id + "&bean_name=" + bean_name , false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
	}
}

function verifyMoreqty(rec_no){ //Added for AD-HOC MMS ADHOC Testing
	var alloc_qty            =  eval("document.frm_consumableItemDatail.alloc_qty_"+rec_no).value;
	var td_avail_qty 		 =  eval(document.getElementById("td_avail_qty_"+rec_no));
	var td_avail = td_avail_qty.innerText;
	if(alloc_qty != '' || alloc_qty!='0'){
		if( parseInt(td_avail)< parseInt(alloc_qty)){
			alert(getMessage("PH_ALLOC_QTY_LESS_AVAIL_QTY","PH"));
			eval("document.frm_consumableItemDatail.alloc_qty_"+rec_no).focus();
			return false;
		}
	}
	return true;
}
