//itemSearchlkp(bean_id, bean_name, bl_install_yn, bl_disp_charge_dtl_in_drug_lkp_yn, bl_disp_price_type_in_drug_lkp, take_home_medication, priority, patient_id, encounter_id, location_code, location_type)
async function ConsumableitemSearch(){
  var item_desc			   =  	document.frm_disp_consumableItemcriteria.txt_item_desc.value;
  var bean_id			   =	document.frm_disp_consumableItemcriteria.bean_id.value;
  var bean_name			   =	document.frm_disp_consumableItemcriteria.bean_name.value;
  var bl_install_yn		   =	document.frm_disp_consumableItemcriteria.hdn_bl_install_yn.value;
  var bl_disp_charge_dtl_in_drug_lkp_yn	=	document.frm_disp_consumableItemcriteria.hdn_bl_disp_charge_dtl_in_drug_lkp_yn.value;
  var bl_disp_price_type_in_drug_lkp	=	document.frm_disp_consumableItemcriteria.hdn_bl_disp_price_type_in_drug_lkp.value;
  var patient_id			=	document.frm_disp_consumableItemcriteria.hdn_patient_id.value;
  var encounter_id			=	document.frm_disp_consumableItemcriteria.hdn_encounter_id.value;
  var store_name	=	document.frm_disp_consumableItemcriteria.store_name.value; //added on 08/04/2010 for IN20551-- priya
  var disp_locn_code	=	document.frm_disp_consumableItemcriteria.disp_locn_code.value; ////added on 08/04/2010 for IN20551-- priya

  var retVal = await itemSearchlkp_disp(item_desc,bean_id, bean_name, bl_install_yn, bl_disp_charge_dtl_in_drug_lkp_yn, bl_disp_price_type_in_drug_lkp, 'N', 'R', patient_id, encounter_id, '', '',store_name,disp_locn_code);

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
			await SetItemDetails(Item_Codes, Trade_Codes, Trade_Names );
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
	var bean_id  = "DispMedicationBean";
	var bean_name= "ePH.DispMedicationBean";

	xmlHttp.open( "POST", "DispMedicationValidate.jsp?identity=SetItemDetails"+"&bean_id=" + bean_id + "&bean_name=" + bean_name , false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);


}
function setItemValues(item_desc){
	 var params      = parent.Disp_cons_items_criteria.document.frm_disp_consumableItemcriteria.params.value;
	 parent.Disp_cons_items_criteria.document.frm_disp_consumableItemcriteria.txt_item_desc.value=item_desc;
     parent.Disp_cons_item_result.document.location.href="../../ePH/jsp/DispensingConsumablesItemsDetails.jsp?"+params;

}


async function assignval(item_code,disp_locn_code,rec_no) {
	    var  retVal		        = await callConsumableBatchSearchWindow(item_code, disp_locn_code);
		var locale=document.frm_consumableItemDatail.p_language_id.value //Added locale on 21/Oct/2010 for incident:24587
		//alert("locale=======87====>" +locale);
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
       
		 eval("document.frm_consumableItemDatail.alloc_qty_"+rec_no).disabled=false;


	    var batch_obj          = eval("document.frm_consumableItemDatail.batch_id_"+rec_no);
	      batch_obj.value             = batch_id;

	    var exp_date_obj        = document.getElementById("td_exp_date_"+rec_no);
         // exp_date_obj.innerText      = expiry_date;
          exp_date_obj.innerText      = convertDate(expiry_date,"DMY","en",locale); //Date Conversion done on 21/Oct/2010 regdng incident num:24587==By Sandhya
		  
//alert(" exp_date_obj.innerText=======114===" + exp_date_obj.innerText);
        var trade_name_obj       = document.getElementById("td_trade_name_"+rec_no);
          trade_name_obj.innerText    = trade_desc;

        var avail_qty_obj        = document.getElementById("td_avail_qty_"+rec_no);
          avail_qty_obj.innerText     = avail_qty;

        var trade_id_obj         = eval("document.frm_consumableItemDatail.trade_id_"+rec_no);
	      trade_id_obj.value          = trade_id;

		var expiary_date_obj     = eval("document.frm_consumableItemDatail.exp_date_"+rec_no);
	      expiary_date_obj.value      = expiry_date;
		 	

		var bin_loc_code_obj     = eval("document.frm_consumableItemDatail.bin_loc_code_"+rec_no);
	       bin_loc_code_obj.value     = bin_locn_code;
        
		var item_code_obj        = eval("document.frm_consumableItemDatail.item_code_"+rec_no);
	       item_code_obj.value        = item_code;

       


        var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();

   
		var xmlStr	="<root><SEARCH " ;
		xmlStr+=" batch_id=\""+ batch_id + "\" ";
		xmlStr+=" item_code=\""+ item_code + "\" ";
		xmlStr+=" item_name=\""+ encodeURIComponent(item_name)  + "\" ";
		xmlStr+=" store_code=\""+ store_code + "\" ";
		xmlStr+=" store_desc=\""+ store_desc + "\" ";
		xmlStr+=" expiry_date=\""+ expiry_date + "\" ";
		xmlStr+=" bin_locn_code=\""+ bin_locn_code + "\" ";
		xmlStr+=" bin_locn_desc=\""+ bin_locn_desc + "\" ";
		xmlStr+=" trade_id=\""+ trade_id + "\" ";
		xmlStr+=" trade_desc=\""+ trade_desc + "\" ";
		xmlStr+=" manufacturer_code=\""+ manufacturer_code + "\" ";
		xmlStr+=" manufacturer_desc=\""+ encodeURIComponent(manufacturer_desc) + "\" ";
		xmlStr+=" avail_qty=\""+ avail_qty + "\" ";
        xmlStr+= "sysdate=\"" + document.frm_consumableItemDatail.sysdate.value + "\" " ; 
		xmlStr+= "all_stages_bean_id=\"" + parent.Disp_cons_item_result.document.frm_consumableItemDatail.bean_id.value + "\" " ;
		xmlStr+= "all_stages_bean_name=\"" + parent.Disp_cons_item_result.document.frm_consumableItemDatail.bean_name.value + "\" " ;
		xmlStr+= "rec_no=\"" + rec_no + "\" " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

		var bean_id  = "DispMedicationBean";
		var bean_name= "ePH.DispMedicationBean";

		xmlHttp.open( "POST", "DispMedicationValidate.jsp?identity=SetBatchDetails"+"&bean_id=" + bean_id + "&bean_name=" + bean_name , false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);

   }

}

async function callConsumableBatchSearchWindow(item_code, store_code) {
	
	var includeZeroStockBatches	= "N";
	var includeExpiredBatches	= "N";
	var includeSuspendedBatches	= "N";
	var searchFunction			= "Y";
	var multipleSelect			= "Y";
	var dialogHeight			= "80vh";
	var dialogWidth				= "80vw";
	var dialogTop				= "10";
	var dialogLeft				= "10";
	var center					= "0";
	var status					= "no";
	var features				= "dialogHeight:" + dialogHeight +"; dialogLeft"+dialogLeft+ "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments				= "";
	retVal =await window.showModalDialog("../../eST/jsp/BatchSearchFrame.jsp?item_code="+item_code+"&store_code="+store_code+"&includeZeroStockBatches="+includeZeroStockBatches+"&includeExpiredBatches="+includeExpiredBatches+"&includeSuspendedBatches="+includeSuspendedBatches+"&searchFunction="+searchFunction+"&multipleSelect='N'", arguments, features);
	return retVal;
}
function getConsumableBillingDetails(rec_no){

         var alloc_qty            =  eval("document.frm_consumableItemDatail.alloc_qty_"+rec_no).value;
		 var ord_qty              =  eval("document.frm_consumableItemDatail.hdn_ord_qty_"+rec_no).value;
		 var bl_install_yn        =  document.frm_consumableItemDatail.bl_install_yn.value;          
		 var ord_uom              =  eval("document.frm_consumableItemDatail.hdn_ord_uom_"+rec_no).value;
		 var disp_stage        	=  document.frm_consumableItemDatail.disp_stage.value; // Added for [IN:047712]
		 var flag        	   	=  document.frm_consumableItemDatail.flag.value;	   // Added for [IN:047712]
		 if(ord_qty==''&&alloc_qty!=''){
             
			   ord_qty_obj        =  document.getElementById("td_ord_qty_"+rec_no);
			   ord_qty_obj.innerHTML  ="<label>&nbsp;&nbsp;"+alloc_qty +" <b>"+ord_uom+"</b></label>";
               ord_qty =alloc_qty;


		 }
		 if(alloc_qty=='')
			  alloc_qty ='0';
        var flag =document.frm_consumableItemDatail.flag.value;
		if(alloc_qty != '' || alloc_qty!='0')
		{
			if(parseInt(document.getElementById("td_avail_qty_"+rec_no).innerText) < parseInt(alloc_qty))
			{
				alert(getMessage("PH_ALLOC_QTY_LESS_AVAIL_QTY","PH"));
				if(!(flag == 'Y' || disp_stage == 'D'))// if Added for [IN:047712]
				eval("document.frm_consumableItemDatail.alloc_qty_"+rec_no).focus();
				return;
			}
				
		}

		if(flag=='Y'&&alloc_qty =='0'){
			alert(getMessage("PH_ISSUE_QTY_BLANK","PH"));
			eval("document.frm_consumableItemDatail.alloc_qty_"+rec_no).focus();
			return;
		}

	   // if(bl_install_yn=='Y'){
			 if(alloc_qty!='' && alloc_qty!='0'){
				 if(parseInt(alloc_qty)<=parseInt(ord_qty)){
					 var  patient_id					 =  document.frm_consumableItemDatail.patient_id.value;
					 var  encounter_id					 =  document.frm_consumableItemDatail.encounter_id.value;
					 var  sal_trn_type					 =  document.frm_consumableItemDatail.sal_trn_type.value;
					 var  sysdate						 =  document.frm_consumableItemDatail.sysdate.value;
					 var  store_code					 =  document.frm_consumableItemDatail.disp_locn_code.value;			 
					 var  tot_gross_charge_amount		 =  document.frm_consumableItemDatail.tot_cons_gross_charge_amount.value;
					 var  tot_groos_pat_payable			 =  document.frm_consumableItemDatail.tot_cons_groos_pat_payable.value;
						 
					 var  old_gross_charge_amount        =  eval("document.frm_consumableItemDatail.gross_charge_amount_"+rec_no).value;
					 var  old_groos_pat_payable          =  eval("document.frm_consumableItemDatail.groos_pat_payable_"+rec_no).value;
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
						xmlStr+= "batch_str=\"" + batch_str + "\" " ;
						xmlStr+= "tot_gross_charge_amount=\"" + tot_gross_charge_amount + "\" " ;
						xmlStr+= "tot_groos_pat_payable=\""   + tot_groos_pat_payable + "\" " ;
						xmlStr+= "old_gross_charge_amount=\"" + old_gross_charge_amount + "\" " ;
						xmlStr+= "old_groos_pat_payable=\""   + old_groos_pat_payable + "\" " ;
						xmlStr+= "bl_install_yn=\""   + bl_install_yn + "\" " ;
						
						xmlStr +=" /></root>";	
						var bean_id  = "DispMedicationBean";
						var bean_name= "ePH.DispMedicationBean";
						
						var temp_jsp="DispMedicationValidate.jsp?identity=StoreConcumableBillingDetails"+"&bean_id="+bean_id+"&bean_name="+bean_name;


						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest() ;
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST",temp_jsp,false);
						xmlHttp.send(xmlDoc);
						responseText=xmlHttp.responseText ;
						eval(responseText);
				   }else{
                       alert(getMessage("PH_ALLOC_QTY_LESS_OR_EQUAL_ORDERED_QTY","PH"));
				   }
			 } 
      // }
        


	
}

function setConsumableBillingAmounts(err_msg,srl_no,gross_charge_amount,groos_pat_payable,tot_gross_charge_amount,tot_groos_pat_payable){

     var disp_stage  = document.frm_consumableItemDatail.disp_stage.value;
	 var flag        = document.frm_consumableItemDatail.flag.value;
	if(err_msg==''){
			document.getElementById("gross_charge_amount_"+srl_no).value                  =   gross_charge_amount;
			document.getElementById("groos_pat_payable_"+srl_no).value                    =   groos_pat_payable;					
			document.getElementById("td_gross_charge_amt_"+srl_no).innerHTML	="<label style='font-size:9;color:black'>&nbsp;&nbsp;"+gross_charge_amount+"</label>";
			document.getElementById("td_pat_payable_amt_"+srl_no).innerHTML	="<label style='font-size:9;color:black'>&nbsp;&nbsp;"+groos_pat_payable+"</label>";

			document.frm_consumableItemDatail.tot_cons_gross_charge_amount.value	=	tot_gross_charge_amount;
			document.frm_consumableItemDatail.tot_cons_groos_pat_payable.value	    =	tot_groos_pat_payable;
          
			select_obj = eval("document.frm_consumableItemDatail.select_"+srl_no); 
			if(disp_stage!='D'&& flag=='N'){
			   select_obj.disabled=false;
			}
			//select_obj.checked = true;
		   // select_obj.value   = "Y";

			var total_payable   = getLabel("ePH.TotalChargeAmount.label","PH");
			var patient_payable = getLabel("ePH.TotalPayableAmount.label","PH");
			
			//parent.f_disp_medication_all_stages_legends.document.getElementById("total_payable").innerHTML	="<label >"+total_payable+"      : "+tot_gross_charge_amount+"</label>";
		   // parent.f_disp_medication_all_stages_legends.document.getElementById("patient_payable").innerHTML	="<label >"+patient_payable+"       : "+tot_groos_pat_payable+"</label>";
	}else{

         document.getElementById("td_gross_charge_amt_"+srl_no).innerHTML	="<label style='font-size:11;color:red'  title='"+err_msg+"'>&nbsp;&nbsp;"+getLabel("Common.Error.label","Common")+"</label>";
		 document.getElementById("td_pat_payable_amt_"+srl_no).innerHTML	="<label style='font-size:11;color:red'  title='"+err_msg+"'>&nbsp;&nbsp;"+getLabel("Common.Error.label","Common")+"</label>";
		 document.getElementById("gross_charge_amount_"+srl_no).value                  =   "";
		 document.getElementById("groos_pat_payable_"+srl_no).value                    =   "";
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

	var bean_id  = "DispMedicationBean";
	var bean_name= "ePH.DispMedicationBean";

	xmlHttp.open( "POST", "DispMedicationValidate.jsp?identity=SetSelectedRecord"+"&bean_id=" + bean_id + "&bean_name=" + bean_name , false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
}

function RecordDetails(){
	window.close();
}

function clearvalues(rec_no){
	var batch_obj          = eval("document.frm_consumableItemDatail.batch_id_"+rec_no);
	var bl_install_yn          = document.frm_consumableItemDatail.bl_install_yn.value;
	// batch_obj.value             = "";
	if(batch_obj.value==''){
		var exp_date_obj        = document.getElementById("td_exp_date_"+rec_no);
		exp_date_obj.innerText      = "";

		var trade_name_obj       = document.getElementById("td_trade_name_"+rec_no);
		trade_name_obj.innerText    = "";

		var avail_qty_obj        = document.getElementById("td_avail_qty_"+rec_no);
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
		//	eval("document.getElementById("gross_charge_amount_")"+rec_no).value                  =   "";
		//	eval("document.getElementById("groos_pat_payable_")"+rec_no).value                    =   "";
		if(bl_install_yn=='Y'){
			document.getElementById("td_gross_charge_amt_"+rec_no).innerHTML	="<label style='font-size:9;color:black'>&nbsp;&nbsp;</label>";
			document.getElementById("td_pat_payable_amt_"+rec_no).innerHTML	="<label style='font-size:9;color:black'>&nbsp;&nbsp;</label>";
		}
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr	="<root><SEARCH " ;
		xmlStr+= "all_stages_bean_id=\"" + parent.Disp_cons_item_result.document.frm_consumableItemDatail.bean_id.value + "\" " ;
		xmlStr+= "all_stages_bean_name=\"" + parent.Disp_cons_item_result.document.frm_consumableItemDatail.bean_name.value + "\" " ;
		xmlStr+= "rec_no=\"" + rec_no + "\" " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

		var bean_id  = "DispMedicationBean";
		var bean_name= "ePH.DispMedicationBean";

		xmlHttp.open( "POST", "DispMedicationValidate.jsp?identity=clearBatchDetails"+"&bean_id=" + bean_id + "&bean_name=" + bean_name , false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
	}
}

/************* Function added on 08/04/2010 for IN20551--- priya-- passed 2 addtnl parameters store_name and disp_locn_code ***********/
async function itemSearchlkp_disp(item_desc,bean_id, bean_name, bl_install_yn, bl_disp_charge_dtl_in_drug_lkp_yn, bl_disp_price_type_in_drug_lkp, take_home_medication, priority, patient_id, encounter_id, location_code, location_type,store_name,disp_locn_code){
	//alert("inside itemSearchlkp");
	var dialogHeight= "85vh" ;
	var dialogWidth	= "85vw" ;
	var status = "no";

	var dialogUrl		= "../../ePH/jsp/ComsumableOrderItemLookup.jsp?item_desc="+encodeURIComponent(item_desc,"UTF-8")+"&location_code="+location_code+"&location_type="+location_type+"&bean_id="+bean_id+"&bean_name="+bean_name+"&bl_install_yn="+bl_install_yn+"&bl_disp_charge_dtl_in_drug_lkp_yn="+bl_disp_charge_dtl_in_drug_lkp_yn+"&bl_disp_price_type_in_drug_lkp="+bl_disp_price_type_in_drug_lkp+"&take_home_medication="+take_home_medication+"&priority="+priority+"&store_name="+encodeURIComponent(store_name,"UTF-8")+"&disp_locn_code="+disp_locn_code+"&CALL_FROM=DISP"; //added encodeURIComponent for item_desc for IN26595 --18/02/2011-- priya
	var dialogFeatures	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal =await window.showModalDialog(dialogUrl,"", dialogFeatures);
	return retVal;
}
