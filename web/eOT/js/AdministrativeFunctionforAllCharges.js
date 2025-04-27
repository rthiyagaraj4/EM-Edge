/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
//MMS-QH-CRF-0199
 function expandMenu(obj,img_name){
	buildTable(obj);
 	setElipatical(obj);
        }

 function setElipatical(obj){
	 var maxLength = 30;
	 $('#'+obj+' > option').text(function(i, text) {
	 if (text.length > maxLength) {
	       return text.substr(0, maxLength) + '...';  
	    }
	 });
 }
 //MMS-QH-CRF-0199
/* buildTable funciton starts here*/
 function buildTable(obj){
	var formObj = document.forms[0];
	var disable_fields_YN = "";
	var index;
	var rec_implants_in_admin_notes_yn=formObj.rec_implants_in_admin_notes_yn.value;
	var rec_packs_in_admin_notes_yn=formObj.rec_packs_in_admin_notes_yn.value;
	var rec_equp_in_admin_notes_yn=formObj.rec_equp_in_admin_notes_yn.value;
	var rec_instr_in_admin_notes_yn=formObj.rec_instr_in_admin_notes_yn.value;

	/*
		menuOP (Operations/Procedures)
		menuASC(AdditionalSurgeryCharges)
		menuAC (Additional Charges)--> Changed to Surgical Accessories
		menuDC (Direct Consumption)
		menuPI (Prothesis/Implants)
		menuCP (Consumable Packs)
		menuE (Equipments)
		menuIC (Instrument/CSSD Pacls)
		menuORC (Operating Room Charges)
		menuHA (Holding Area usage)
		menuRR (Recovery Room usage)	
	*/
	var addnew_label = getLabel("Common.Add/New.label","Common");
	if(obj!=null && obj!=""){
		if(obj=="menuOP"){
	        var expand_flag=formObj.flag_op.value;
			if(expand_flag=="Y"){
			//parent.document.getElementById("tab_frame").rows="33%,*";
			document.getElementById("menuExpand1").style.display='Inline';
			document.getElementById("menuExpan1").style.display='Inline';
			formObj.flag_op.value="N";
			formObj.OP_arrow.src="../../eCommon/images/tree_handledownmiddle.gif";
			}else {
			document.getElementById("menuExpand1").style.display='none';
			document.getElementById("menuExpan1").style.display='none';
			formObj.flag_op.value="Y";
			formObj.OP_arrow.src="../../eCommon/images/tree_handlerightlast.gif";
			}

		}
		
		if(obj=="menuAC"){ 
	        var expand_flag=formObj.flag_ac.value;
			if(expand_flag=="Y"){
			if(rec_implants_in_admin_notes_yn=="Y")
	        {
			document.getElementById("menuExpand2A").style.display='Inline';
			}
			else if (rec_implants_in_admin_notes_yn=="N" && rec_packs_in_admin_notes_yn=="Y")
			{
			document.getElementById("menuExpand2B").style.display='Inline'
			}
			else if(rec_packs_in_admin_notes_yn=="N" && rec_equp_in_admin_notes_yn=="Y")
			{
            document.getElementById("menuExpand2C").style.display='Inline'
			}
			else if(rec_equp_in_admin_notes_yn=="N" && rec_instr_in_admin_notes_yn=="Y")
			{
            document.getElementById("menuExpand2D").style.display='Inline'
			}
			
			formObj.flag_ac.value="N";
			formObj.AC_arrow.src="../../eCommon/images/tree_handledownmiddle.gif";
			}else {
				if(rec_implants_in_admin_notes_yn=="Y")
	            {
			    document.getElementById("menuExpand2A").style.display='none';
				document.getElementById("menuExpand4").style.display='none';
				formObj.flag_pi.value="Y";
			    formObj.PI_arrow.src="../../eCommon/images/tree_handlerightlast.gif";
				}
				if(rec_packs_in_admin_notes_yn=="Y")
	            {
				document.getElementById("menuExpand2B").style.display='none';
				document.getElementById("menuExpand5").style.display='none';
				formObj.flag_cp.value="Y";
		        formObj.CP_arrow.src="../../eCommon/images/tree_handlerightlast.gif";
				}
				if(rec_equp_in_admin_notes_yn=="Y")
	            {
				document.getElementById("menuExpand2C").style.display='none';
				document.getElementById("menuExpand6").style.display='none';
				formObj.flag_eq.value="Y";
		        formObj.Eq_arrow.src="../../eCommon/images/tree_handlerightlast.gif";
			    }
				if(rec_instr_in_admin_notes_yn=="Y")
	            {
				document.getElementById("menuExpand2D").style.display='none';
				document.getElementById("menuExpand7").style.display='none';
				formObj.flag_ic.value="Y";
		        formObj.IC_arrow.src="../../eCommon/images/tree_handlerightlast.gif";
                }
			   formObj.flag_ac.value="Y";
			  formObj.AC_arrow.src="../../eCommon/images/tree_handlerightlast.gif";
           }
         }
		 if(obj=="menuASC"){ 
	        var expand_flag=formObj.flag_asc.value;
			if(expand_flag=="Y"){
			//parent.document.getElementById("tab_frame").rows="33%,*";
			document.getElementById("menuExpandASC").style.display='Inline';
			formObj.flag_asc.value="N";
			formObj.ASC_arrow.src="../../eCommon/images/tree_handledownmiddle.gif";
			}else {
			document.getElementById("menuExpandASC").style.display='none';
			formObj.flag_asc.value="Y";
			formObj.ASC_arrow.src="../../eCommon/images/tree_handlerightlast.gif";
			}
		}  
		if(obj=="menuDC"){ 
	        var expand_flag=formObj.flag_dc.value;
			if(expand_flag=="Y"){
			//parent.document.getElementById("tab_frame").rows="33%,*";
			document.getElementById("menuExpand3").style.display='Inline';
			formObj.flag_dc.value="N";
			formObj.DC_arrow.src="../../eCommon/images/tree_handledownmiddle.gif";
			}else {
			document.getElementById("menuExpand3").style.display='none';
			formObj.flag_dc.value="Y";
			formObj.DC_arrow.src="../../eCommon/images/tree_handlerightlast.gif";
			}
		}
		if(obj=="menuPI"){ 
	        var expand_flag=formObj.flag_pi.value;
			if(expand_flag=="Y"){
			document.getElementById("menuExpand4").style.display='Inline';
			formObj.flag_pi.value="N";
			formObj.PI_arrow.src="../../eCommon/images/tree_handledownmiddle.gif";
			 
			document.getElementById("menuExpand2A").style.display='inline';
			
			if(rec_packs_in_admin_notes_yn=="Y")
			{
			document.getElementById("menuExpand2B").style.display='none';
			document.getElementById("menuExpand5").style.display='none';
			formObj.flag_cp.value="Y";
			formObj.CP_arrow.src="../../eCommon/images/tree_handlerightlast.gif";
			}
			if(rec_equp_in_admin_notes_yn=="Y")
	        {
			document.getElementById("menuExpand2C").style.display='none';
			document.getElementById("menuExpand6").style.display='none';
			formObj.flag_eq.value="Y";
			formObj.Eq_arrow.src="../../eCommon/images/tree_handlerightlast.gif";
			}
			
			if(rec_instr_in_admin_notes_yn=="Y")
			{
			document.getElementById("menuExpand2D").style.display='none';
			document.getElementById("menuExpand7").style.display='none';
			formObj.flag_ic.value="Y";
			formObj.IC_arrow.src="../../eCommon/images/tree_handlerightlast.gif";
			}
			formObj.flag_ac.value="N";
			formObj.AC_arrow.src="../../eCommon/images/tree_handledownmiddle.gif";


			}else {
			
			document.getElementById("menuExpand4").style.display='none';
			formObj.flag_pi.value="Y";
			formObj.PI_arrow.src="../../eCommon/images/tree_handlerightlast.gif";

			document.getElementById("menuExpand2A").style.display='none';
			formObj.flag_ac.value="Y";
			formObj.AC_arrow.src="../../eCommon/images/tree_handlerightlast.gif";
			}
		}
		if(obj=="menuCP"){ 
	        var expand_flag=formObj.flag_cp.value;
			if(expand_flag=="Y"){
			document.getElementById("menuExpand5").style.display='Inline';
			formObj.flag_cp.value="N";
			formObj.CP_arrow.src="../../eCommon/images/tree_handledownmiddle.gif";
			
			if(rec_implants_in_admin_notes_yn=="Y")
	        {
			document.getElementById("menuExpand2A").style.display='none';
			document.getElementById("menuExpand4").style.display='none';
			formObj.flag_pi.value="Y";
			formObj.PI_arrow.src="../../eCommon/images/tree_handlerightlast.gif";
			}
			
			document.getElementById("menuExpand2B").style.display='inline';
			
			if(rec_equp_in_admin_notes_yn=="Y")
	        {
			document.getElementById("menuExpand2C").style.display='none';
			document.getElementById("menuExpand6").style.display='none';
			formObj.flag_eq.value="Y";
			formObj.Eq_arrow.src="../../eCommon/images/tree_handlerightlast.gif";
			}
			
			if(rec_instr_in_admin_notes_yn=="Y")
			{
			document.getElementById("menuExpand2D").style.display='none';
			document.getElementById("menuExpand7").style.display='none';
			formObj.flag_ic.value="Y";
			formObj.IC_arrow.src="../../eCommon/images/tree_handlerightlast.gif";
			}
			
			formObj.flag_ac.value="N";
			formObj.AC_arrow.src="../../eCommon/images/tree_handledownmiddle.gif";
			}else {
			document.getElementById("menuExpand5").style.display='none';
			formObj.flag_cp.value="Y";
			formObj.CP_arrow.src="../../eCommon/images/tree_handlerightlast.gif";

			//document.getElementById("menuExpand2A").style.display='none';
			document.getElementById("menuExpand2B").style.display='none';
			formObj.flag_ac.value="Y";
			formObj.AC_arrow.src="../../eCommon/images/tree_handlerightlast.gif";

			}
		}
		
		if(obj=="menuEq"){ 
		var expand_flag=formObj.flag_eq.value;
		if(expand_flag=="Y"){
		document.getElementById("menuExpand6").style.display='Inline';
		formObj.flag_eq.value="N";
		formObj.Eq_arrow.src="../../eCommon/images/tree_handledownmiddle.gif";
        
		if(rec_implants_in_admin_notes_yn=="Y")
	    {
		document.getElementById("menuExpand2A").style.display='none';
		document.getElementById("menuExpand4").style.display='none';
		formObj.flag_pi.value="Y";
		formObj.PI_arrow.src="../../eCommon/images/tree_handlerightlast.gif";
		}
		if(rec_packs_in_admin_notes_yn=="Y")
		{
		document.getElementById("menuExpand2B").style.display='none';
		document.getElementById("menuExpand5").style.display='none';
		formObj.flag_cp.value="Y";
		formObj.CP_arrow.src="../../eCommon/images/tree_handlerightlast.gif";
		}
		if(rec_instr_in_admin_notes_yn=="Y")
		{
		document.getElementById("menuExpand2D").style.display='none';
		document.getElementById("menuExpand7").style.display='none';
		formObj.flag_ac.value="Y";
		formObj.IC_arrow.src="../../eCommon/images/tree_handlerightlast.gif";
		}
		document.getElementById("menuExpand2C").style.display='inline';

		formObj.flag_ac.value="N";
		formObj.AC_arrow.src="../../eCommon/images/tree_handledownmiddle.gif";
		}else {
		document.getElementById("menuExpand6").style.display='none';
		formObj.flag_eq.value="Y";
		formObj.Eq_arrow.src="../../eCommon/images/tree_handlerightlast.gif";

		document.getElementById("menuExpand2C").style.display='none';
		formObj.flag_ac.value="Y";
		formObj.AC_arrow.src="../../eCommon/images/tree_handlerightlast.gif";
		}
		}
	  if(obj=="menuIC"){ 
		var expand_flag=formObj.flag_ic.value;
		if(expand_flag=="Y"){
		document.getElementById("menuExpand7").style.display='Inline';
		formObj.flag_ic.value="N";
		formObj.IC_arrow.src="../../eCommon/images/tree_handledownmiddle.gif";
        if(rec_implants_in_admin_notes_yn=="Y")
	    {
		document.getElementById("menuExpand2A").style.display='none';
		document.getElementById("menuExpand4").style.display='none';
		formObj.flag_pi.value="Y";
		formObj.PI_arrow.src="../../eCommon/images/tree_handlerightlast.gif";
		}
		if(rec_packs_in_admin_notes_yn=="Y")
		{
		document.getElementById("menuExpand2B").style.display='none';
		document.getElementById("menuExpand5").style.display='none';
		formObj.flag_cp.value="Y";
		formObj.CP_arrow.src="../../eCommon/images/tree_handlerightlast.gif";
		}
		if(rec_equp_in_admin_notes_yn=="Y")
	    {
		document.getElementById("menuExpand2C").style.display='none';
		document.getElementById("menuExpand6").style.display='none';
		formObj.flag_eq.value="Y";
		formObj.Eq_arrow.src="../../eCommon/images/tree_handlerightlast.gif";
		}
		document.getElementById("menuExpand2D").style.display='inline';
        
		formObj.flag_ac.value="N";
		formObj.AC_arrow.src="../../eCommon/images/tree_handledownmiddle.gif";

		}else {
		document.getElementById("menuExpand7").style.display='none';
		formObj.flag_ic.value="Y";
		formObj.IC_arrow.src="../../eCommon/images/tree_handlerightlast.gif";

		formObj.flag_ac.value="Y";
		formObj.AC_arrow.src="../../eCommon/images/tree_handlerightlast.gif";
		document.getElementById("menuExpand2D").style.display='none';
		}
		}
       if(obj=="menuOR"){ 
		var expand_flag=formObj.flag_or.value;
		if(expand_flag=="Y"){
		document.getElementById("menuExpand8").style.display='Inline';
		formObj.flag_or.value="N";
		formObj.OR_arrow.src="../../eCommon/images/tree_handledownmiddle.gif";
		}else {
		document.getElementById("menuExpand8").style.display='none';
		formObj.flag_or.value="Y";
		formObj.OR_arrow.src="../../eCommon/images/tree_handlerightlast.gif";
		}
		}
       if(obj=="menuHA"){ 
		var expand_flag=formObj.flag_ha.value;
		if(expand_flag=="Y"){
		document.getElementById("menuExpand9").style.display='Inline';
		formObj.flag_ha.value="N";
		formObj.HA_arrow.src="../../eCommon/images/tree_handledownmiddle.gif";
		}else {
		document.getElementById("menuExpand9").style.display='none';
		formObj.flag_ha.value="Y";
		formObj.HA_arrow.src="../../eCommon/images/tree_handlerightlast.gif";
		}
		}
	 if(obj=="menuRR"){ 
		var expand_flag=formObj.flag_rr.value;
		if(expand_flag=="Y"){
		document.getElementById("menuExpand10").style.display='Inline';
		formObj.flag_rr.value="N";
		formObj.RR_arrow.src="../../eCommon/images/tree_handledownmiddle.gif";
		}else {
		document.getElementById("menuExpand10").style.display='none';
		formObj.flag_rr.value="Y";
		formObj.RR_arrow.src="../../eCommon/images/tree_handlerightlast.gif";
		}
		}
		//Added by lakshmi for CRF-0601 starts here
		if(obj=="menuPR"){ 
		var expand_flag=formObj.flag_pr.value;
		if(expand_flag=="Y"){
		document.getElementById("menuExpand11").style.display='Inline';
		formObj.flag_pr.value="N";
		formObj.PR_arrow.src="../../eCommon/images/tree_handledownmiddle.gif";
		}else {
		document.getElementById("menuExpand11").style.display='none';
		formObj.flag_pr.value="Y";
		formObj.PR_arrow.src="../../eCommon/images/tree_handlerightlast.gif";
		}
		}
		//Added by lakshmi for CRF-0601 ends here
	}
}/* buildTable funciton ends here*/

		
  function setChkValue(obj)
  {    
		var st_interface_flag=document.forms[0].st_interface_flag.value;

		if(obj.name=='pi_complete')
	    {
		var rows=parent.parent.parent.AdminObjectCollect.implants_rows;
		
		var flag=true;
		if(obj.checked==true )
		{
		if(st_interface_flag=="Y")
		{	
		for(var jj=0;jj<rows.length;jj++) {
		if(rows[jj])
		{
		if((rows[jj].Stockavail =="" || rows[jj].Stockavail =="0") && rows[jj].db_mode!='D')
		{
		flag=false;
		alert(getMessage("PRC-OT0054","OT"));
		obj.checked=false;
		break;
		}else
		{
			flag=true;
			obj.checked=true
		}
		}
	    }
		}else
		{
			flag=true;
			obj.checked=true
		}
		}
		if(flag == true)
		{
			obj.value="Y";
		}
		else
		{
			obj.value="N";
		}
	
		}else{
		if(obj.checked)
		obj.value="Y";
		else{
		obj.value="N";
		}
		}
		return true;
  }
	

  function Class_row_pi()
  {
	  this.oper_code ="";
	  this.oper_desc="";
	  this.implants_code="";
	  this.implants_desc="";
	  this.oper_line_no ="";
	  this.manufacturer="";
	  this.batch="";
	  this.order="";
	  this.quantity ="";
	  this.remarks ="";
	  this.accessory_type="";
	  this.db_mode="";
	  this.recId="";
	  this.reserved_qty="";
	  this.requested_qty="";
	  this.Store_desc="";
	  this.sale_document_no ="";
	  this.sale_document_type ="";
	  this.req_store_code="";
	  this.Stockavail = "";
				
	  this.bill_str="";
	  this.panel_str="";
	  this.key="";
	  this.key_line="";
	  this.rate="";
  }

	function Class_row_cons()
	{
	  this.oper_code ="";
	  this.oper_desc="";
	  this.package_code="";
	  this.package_desc="";
	  this.oper_line_no ="";
	  this.quantity ="";
	  this.remarks ="";
	  this.order="";
	  this.accessory_type="";
	  this.db_mode="";
	  this.recId="";
	  this.bill_str="";
	  this.panel_str="";
	  this.key="";
	  this.key_line="";
	  this.reserved_qty="";
	  this.requested_qty="";
	  this.req_store_code="";
	  this.rate="";
	}

	function newRow_pi(){
	  var objrow = new Class_row_pi();
	   return(objrow);
	}
	function newRow_cons(){
	  var objrow = new Class_row_cons();
	   return(objrow);
	}
function addRow_pi(){
  var objrow = newRow_pi();
  var msg = trimString(getMessage("CODE_ALREADY_EXISTS","Common"));
  var rows=parent.parent.parent.AdminObjectCollect.implants_rows;
  var formObj = document.forms[0];
  var st_interface_flag=document.forms[0].st_interface_flag.value;
  var params = formObj.params.value;
  var mode =formObj.mode.value;
  var operation_pi=formObj.operation_pi.value;
  operation_pi=operation_pi.split("##")
  var key = formObj.oper_num.value+"@"+operation_pi[0]+"@I"+"@"+formObj.implant_code.value;
  var obj = formObj.operation_pi;
  var bill_flag = formObj.bill_flag.value;

//Addedb By DhanasekarV against the issue IN024474

  parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';

  if(chkEmpty_pi()){
	if(mode=='I'){
	   if(alreadyExist_pi()){
	 if(st_interface_flag=="N")
		{
		if(bill_flag=="true")// added by sathish to disable Billing Part
		{
		var retVal = callOrderLineCreation_pi(formObj.quantity_pi.value);
		retVal=trimString(retVal);
		var arr = retVal.split("@@");
		
		if(arr[0]=="BL0639"){
			alert(getMessage("BL0639","BL"));
			return false;
		}
		if(localTrimString(arr[2])!='')
			{
			var err_pat=localTrimString(arr[2]);
			alert(err_pat);
			return false;
			}
		}   
		}		
			objrow.oper_code=operation_pi[0];
			objrow.oper_desc=formObj.operation_pi.options[obj.selectedIndex].title;//MMS-QH-CRF-0199
			objrow.implant_code=formObj.implant_code.value;
			objrow.implant_desc=formObj.implant_desc.value;
			objrow.oper_line_no = formObj.oper_line_no.value
			objrow.quantity = formObj.quantity_pi.value;
			
			if(st_interface_flag=='Y')
		    {
			objrow.reserved_qty=formObj.Reservepicklist_pi.value;
			objrow.requested_qty=formObj.Requestpicklist_pi.value;
			objrow.sale_document_no = formObj.sale_document_no.value;
			objrow.sale_document_type = formObj.sale_document_type.value;
			
			objrow.req_store_code=formObj.reqstore_code.value;
			objrow.Stockavail = formObj.Stockavail_pi.value;
			if(formObj.Stockavail_pi.value =="" || formObj.Stockavail_pi.value =="0")
			{
			alert(getMessage("PRC-OT0054","OT"));
			return false;
			}
			objrow.Store_desc=formObj.conns_store_pi.value;
			}
			if(st_interface_flag=='N')
		    {
			objrow.manufacturer = formObj.manufacturer.value;
			objrow.batch = formObj.batch.value;
			}
			
			objrow.remarks = formObj.remarks_pi.value;
			
			
			
			objrow.recId = getRecId();
			 if(st_interface_flag=="N")
	     	{
			if(bill_flag=="true")
		    {
			//var retVal = callOrderLineCreation(formObj.quantity.value);
			var arr = retVal.split("@@");
			objrow.panel_str = arr[0];
			var temp_bill=arr[1].split("::");
			arr[1]=arr[1]+"::"+""+"::"+temp_bill[4];
			objrow.bill_str = arr[1];
			}
			} else
			{
				var retVal = Callbilling_ST(formObj.quantity_pi.value,formObj.reqstore_code.value,formObj.patient_id.value,formObj.encounter_id1.value,formObj.patient_class1.value,formObj.implant_code.value);
				objrow.bill_str = trimString(retVal);
			}
			objrow.key=key;
			objrow.key_line="";
			objrow.db_mode="I";
			rows.push(objrow);
			resetFields_pi();
			//parent.ResultsFrame.location.href='../../eOT/jsp/ImplantsDtls.jsp?'+params;
			//parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
		
	} else{
		 parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
	}

	createTable_pi();

   
	}else{
	  updateRow_pi();
	}
  }

}

function updateRow_pi(){
	var formObj			= document.forms[0];
	var st_interface_flag=formObj.st_interface_flag.value;

	//var params			= formObj.params.value;
	var	implant_code	= formObj.implant_code.value;
	var	implant_desc	= formObj.implant_desc.value;
	var	quantity		= formObj.quantity_pi.value;

	if(st_interface_flag=="N")
	{
	var mfr				= formObj.manufacturer.value;
	var batch			= formObj.batch.value;
	}
	var	remarks			= formObj.remarks_pi.value;
	var mode			= formObj.mode.value;
    var recId			= formObj.recId.value;
	//var	oper_code		= formObj.oper_code.value;                          
	var	oper_code		= formObj.operation_pi.value; 
	
	oper_code=oper_code.split("##");
	
	var oper_desc		= formObj.operation_pi.options[formObj.operation_pi.selectedIndex].text;
	var line_no			= formObj.oper_line_no.value;
	
	var rows=parent.parent.parent.AdminObjectCollect.implants_rows;
	var bill_flag       = formObj.bill_flag.value;
	

		if(rows.length>0 && mode=='U'){        
			for(var jj=0;jj<rows.length;jj++){
				if(rows[jj]!=null) {
					if(rows[jj].recId==recId){
						var new_bill_str = "";
						var new_panel_str = "";
						if(st_interface_flag=="N")
	                   {
						if(mode=="U" && bill_flag=="true"){
							// call UpdateBillingDetailsValidation
							
							var result = updateBillingDetailsValidation(rows[jj].key,rows[jj].key_line,quantity,implant_code,"I",oper_code[0]);
							var result_arr = result.split("OTMS_SEP");
							new_bill_str = result_arr[0];
							new_panel_str = result_arr[1];
						}
					   }else
		                {
				
				          if(mode=="U" && bill_flag=="true"){
							var retVal = Callbilling_ST(quantity,formObj.reqstore_code.value,formObj.patient_id.value,formObj.encounter_id1.value,formObj.patient_class1.value,formObj.implant_code.value);
							new_bill_str = retVal;
						  }
		                 }

						rows[jj].quantity=quantity;
						if(st_interface_flag=="Y")
	                    {
						rows[jj].reserved_qty=formObj.Reservepicklist_pi.value;
			            rows[jj].requested_qty=formObj.Requestpicklist_pi.value;
			           // rows[jj].req_store_code=formObj.conns_store_pi.value;
                        rows[jj].req_store_code=formObj.reqstore_code.value;
			            rows[jj].Store_desc=formObj.conns_store_pi.value;
			            rows[jj].Stockavail=formObj.Stockavail_pi.value;
						if(formObj.Stockavail_pi.value =="" || formObj.Stockavail_pi.value =="0")
			            {
			             alert(getMessage("PRC-OT0054","OT"));
			              return false;
			            }
						rows[jj].sale_document_no = formObj.sale_document_no.value;
			            rows[jj].sale_document_type = formObj.sale_document_type.value;
						}

						if(st_interface_flag=="N")
	                    {
						rows[jj].manufacturer=mfr;
						rows[jj].batch=batch;
						}
						rows[jj].remarks=remarks;
			            if(rows[jj].db_mode=='L' && rows[jj].order=='1'){
							rows[jj].db_mode='U';
						}else if(rows[jj].db_mode=='L' && rows[jj].order=='2'){
							rows[jj].db_mode='I';
						}else if(rows[jj].db_mode=='L' || rows[jj].db_mode=="I" && rows[jj].order=='3'){
							rows[jj].oper_code=oper_code[0];
							rows[jj].oper_desc=oper_desc;
							rows[jj].oper_line_no=line_no;
							rows[jj].db_mode='I';
						}
						
						if(bill_flag=="true")
						{
						if(st_interface_flag=="N")
	                    {
						rows[jj].panel_str = new_panel_str;
						rows[jj].bill_str = new_bill_str;
						}
						else
							{
						     rows[jj].bill_str = new_bill_str;
							}
						}
						
						break;
					}
		         }else  
			continue;
		 }
      resetFields_pi();
// parent.ResultsFrame.location.href='../../eOT/jsp/SurgicalAccessoriesResult.jsp?'+params;
 //parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
 createTable_pi();
 }
}

function addRow_cons(){
  var objrow = newRow_cons();
  var msg = trimString(getMessage("CODE_ALREADY_EXISTS","Common"));
  var rows=parent.parent.parent.AdminObjectCollect.packs_rows;
  var formObj = document.forms[0];
  var params = formObj.params.value;
  var mode =formObj.mode.value;
  var obj = formObj.operation_cons;
  var bill_flag = formObj.bill_flag.value;
  var operation_cons=formObj.operation_cons.value;
  operation_cons=operation_cons.split("##");
   var key = formObj.oper_num.value+"@"+operation_cons[0]+"@C"+"@"+formObj.package_code.value;

   //Modified by DhanasekarV  against the issue IN024474

  parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';

  if(chkEmpty_cons()){
	if(mode=='I'){
	   if(alreadyExist_cons()){
		if(bill_flag=="true") //added by sathish to disable Billing Part
		{
		var retVal = callOrderLineCreation_cons(formObj.quantity_cons.value);
		retVal=trimString(retVal);
		var arr = retVal.split("@@");
		if(arr[0]=="BL0639"){
			alert(getMessage("BL0639","BL"));
			return false;
		}
		if(localTrimString(arr[2])!='')
			{
			var err_pat=localTrimString(arr[2]);
			alert(err_pat);
			return false;
			}
		}
			objrow.oper_code=operation_cons[0];
			objrow.oper_desc=formObj.operation_cons.options[obj.selectedIndex].title;//MMS-QH-CRF-0199
			objrow.package_code=formObj.package_code.value;
			objrow.package_desc=formObj.package_desc.value;
			objrow.oper_line_no = formObj.oper_line_no.value;
			objrow.quantity = formObj.quantity_cons.value;
			//objrow.reserved_qty=formObj.Reservepicklist_cons.value;
			//objrow.requested_qty=formObj.Requestpicklist_cons.value;
			objrow.remarks = formObj.remarks_cons.value;
			objrow.recId = getRecId_cons();
			//var retVal = callOrderLineCreation();
			if(bill_flag=="true")
		    {
			var arr = retVal.split("@@");
			objrow.panel_str = arr[0];
			var temp_bill=arr[1].split("::");
			arr[1]=arr[1]+"::"+""+"::"+temp_bill[4];
			objrow.bill_str = arr[1];
		    }
			//objrow.req_store_code=formObj.conns_store_cons.value;
			objrow.key=key;
			objrow.key_line="";
			objrow.db_mode="I";
			rows.push(objrow);
			resetFields_cons();
			//parent.DetailFrame.location.href='../../eOT/jsp/ConsumablePacksDtls.jsp?'+params;
			//parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
		
	} else{
		parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
	}
	createTable_cons();
	}else
	  updateRow_cons();
  }
}

function updateRow_cons(){
	var formObj = document.forms[0];
	var params = formObj.params.value;
	var bill_flag = formObj.bill_flag.value;
	var	package_code=formObj.package_code.value;
	var	package_desc=formObj.package_desc.value;
	var	quantity = formObj.quantity_cons.value;
	var	remarks = formObj.remarks_cons.value;
	var	operation_cons = formObj.operation_cons.value;
	var	quantity = formObj.quantity_cons.value;
	operation_cons=operation_cons.split("##");
	var mode =formObj.mode.value;
	var recId = formObj.recId.value;
	  var rows=parent.parent.parent.AdminObjectCollect.packs_rows;
		if(rows.length>0 && mode=='U'){        
			for(var jj=0;jj<rows.length;jj++){
				if(rows[jj]!=null) {
					if(rows[jj].recId==recId){
						//rows[jj].package_code=package_code;
						//rows[jj].package_desc=package_desc;	
			            rows[jj].quantity=quantity;
						//rows[jj].reserved_qty=formObj.Reservepicklist_cons.value;
			           // rows[jj].requested_qty=formObj.Requestpicklist_cons.value;
			            //rows[jj].req_store_code=formObj.conns_store_cons.value;
						var result = updateBillingDetailsValidation(rows[jj].key,rows[jj].key_line,quantity,package_code,"C",operation_cons[0]);
						var result_arr = result.split("OTMS_SEP");
						new_bill_str = result_arr[0];
						new_panel_str = result_arr[1];

						rows[jj].quantity=quantity;
						rows[jj].remarks=remarks;
			            if(rows[jj].db_mode=='L' && rows[jj].order=='1'){
							rows[jj].db_mode='U';
						}else if(rows[jj].db_mode=='L' && rows[jj].order=='2'){
							rows[jj].db_mode='I';
						}else if(rows[jj].db_mode=='L' && rows[jj].order=='3'){
							rows[jj].db_mode='I';
						}
						if(bill_flag=="true")
						{
							
						rows[jj].panel_str = new_panel_str;
						rows[jj].bill_str = new_bill_str;
						}
						break;
					}
		         }else  
			continue;
		 }
      resetFields_cons();
      createTable_cons();
 }
}

function chkEmpty_pi(){
	var formObj = document.forms[0];
	var operation			=getLabel("Common.operation.label","Common");
	var implant				=getLabel("Common.Implant.label","Common");
	//var consum_store		=getLabel("eOT.ConsumptionStore.Label","OT");
	var no_of_units		=getLabel("eOT.ActualUnits.Label","OT");
	var ConsumptionStore		=getLabel("eOT.ConsumptionStore.Label","OT");
	var st_interface_flag=formObj.st_interface_flag.value;
	if(st_interface_flag =="Y")
	{
	var fields = new Array(formObj.operation_pi,formObj.implant_desc,formObj.conns_store_pi,formObj.quantity_pi);
	var names = new Array(operation,implant,ConsumptionStore,no_of_units);
	}else
	{
	var fields = new Array(formObj.operation_pi,formObj.implant_desc,formObj.quantity_pi);
	var names = new Array(operation,implant,no_of_units);
	}
	var messageFrame = parent.parent.parent.parent.messageFrame;

	if(checkFields1( fields, names, messageFrame))
		return true;
}

function chkEmpty_cons(){
	var formObj = document.forms[0];
	var operation			=getLabel("Common.operation.label","Common");
	var package_cp			=getLabel("Common.Package.label","Common");
	var no_of_units		=getLabel("eOT.ActualUnits.Label","OT");
	//var ConsumptionStore		=getLabel("eOT.ConsumptionStore.Label","OT");
	var fields = new Array(formObj.operation_cons,formObj.package_desc,formObj.quantity_cons);
	var names = new Array(operation,package_cp,no_of_units);
	var messageFrame = parent.parent.parent.parent.messageFrame;

	if(checkFields1( fields, names, messageFrame))
		return true;
}

function callOrderLineCreation_pi(quantity){
	var formObj = document.forms[0];
	var oper_num = formObj.oper_num.value;
	var implant_code = formObj.implant_code.value;
	var oper_code = (formObj.operation_pi.value).split("##")[0];
	var param = "oper_num="+oper_num+"&acc_type=I&called_from=ACC_TAB&acc_code="+implant_code+"&oper_code="+oper_code+"&quantity="+quantity;
	var xmlStr ="<root></root>";
	var temp_jsp="OTOrderLineCreation.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	return responseText;
}

function callOrderLineCreation_cons(quantity){
	var formObj = document.forms[0];
	var oper_num = formObj.oper_num.value;
	var package_code = formObj.package_code.value;
	var oper_code = (formObj.operation_cons.value).split("##")[0];
	var param = "oper_num="+oper_num+"&acc_type=C&called_from=ACC_TAB&acc_code="+package_code+"&oper_code="+oper_code+"&quantity="+quantity;
	var xmlStr ="<root></root>";
	var temp_jsp="OTOrderLineCreation.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	return responseText;
}
function callOrderLineCreation_eq(){
	var formObj = document.forms[0];
	var oper_num = formObj.oper_num.value;
	var equip_code = formObj.equip_code.value;
	var quantity = formObj.quantity_eq.value;
	var oper_code = (formObj.operation_eq.value).split("##")[0];
	var param = "oper_num="+oper_num+"&acc_type=E&called_from=ACC_TAB&acc_code="+equip_code+"&oper_code="+oper_code+"&quantity="+quantity;
	var xmlStr ="<root></root>";
	var temp_jsp="OTOrderLineCreation.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	return responseText;

}
function localTrimString(sInString) {
  return sInString.replace(/^\s+|\s+$/g,"");
}
function alreadyExist_pi(){
	var formObj = document.forms[0];
	var codeDtl =parent.parent.parent.parent.AdministrativeFucntionFrame.code_pi; 

	var oper_code=formObj.oper_code.value;
	var implant_code = formObj.implant_code.value;
	var codeRecord = oper_code+implant_code;
	if(codeDtl.indexOf(codeRecord)>=0)
	   return false;
	else
	  return true;
}

function alreadyExist_cons(){
	var formObj = document.forms[0];
	var codeDtl = parent.parent.parent.parent.AdministrativeFucntionFrame.code_cons; 
	var oper_code=formObj.oper_code.value;
	var package_code = formObj.package_code.value;
	var codeRecord = oper_code+package_code;
	if(codeDtl.indexOf(codeRecord)>=0)
	   return false;
	else
	  return true;
}

function assignCodes_pi(obj){
	var formObj=document.forms[0];
	var codes =  obj.value;
    var arr = codes.split("##");
	formObj.oper_code.value=arr[0];
	formObj.oper_line_no.value=arr[1];
}

function assignCodes_cons(obj){
	var formObj=document.forms[0];
	var codes =  obj.value;
    var arr = codes.split("##");
	formObj.oper_code.value=arr[0];
	formObj.oper_line_no.value=arr[1];
}
function loadDBRows_pi(oper_code,oper_desc,line_no,implant_code,implant_desc,quantity,mfgr,batch,remarks,index,mode,order,bill_str,panel_str,key,key_line,req_store_code,reserved_qty, requested_qty,no_of_units,sale_document_no,sale_document_type,avail_stock,Store_desc,frm_pick_list,booking_num)
{   
	var objrow = newRow_pi();
	var rows=parent.parent.parent.AdminObjectCollect.implants_rows;
	var rowLength=parent.parent.parent.parent.AdminObjectCollect.implants_len;
	if(mode=='L' && rowLength==0){
	objrow.oper_code=oper_code;
	objrow.Store_desc=unescape(Store_desc);
	objrow.oper_desc=unescape(oper_desc);
	objrow.implant_code=implant_code;
	objrow.implant_desc=unescape(implant_desc);
	objrow.oper_line_no=line_no;
	objrow.quantity=quantity;


//	objrow.reserved_qty=reserved_qty;
//	objrow.requested_qty=requested_qty;

				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=chk_for_pick_list&implant_code="+implant_code+"&booking_num="+booking_num,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
if(retVal !="")
	  {
var arr1=retVal.split(",");
objrow.reserved_qty=arr1[0];
objrow.requested_qty=arr1[1];
	  }


	objrow.req_store_code=req_store_code;
	objrow.sale_document_no=sale_document_no;
	objrow.sale_document_type=sale_document_type;
	objrow.Stockavail=avail_stock;
	objrow.frm_pick_list=frm_pick_list;
	
	objrow.manufacturer=mfgr
	objrow.batch=batch;
	//objrow.remarks=unescape(remarks);Anitha
    objrow.remarks=decodeURIComponent(remarks,"UTF-8").replace(/\+/g," ");
	objrow.order=order;
	objrow.recId = index;
	objrow.db_mode=(order==1)?"L":"I";
	objrow.bill_str=bill_str;
	objrow.panel_str=panel_str;
	objrow.key=key;
	objrow.key_line=key_line;
	objrow.rate="";
	
	rows.push(objrow);
	}
}
function loadCodes(){
	
	var formObj = document.forms[0];
	if(formObj.st_interface_flag.value=="Y" )		{
		formObj.document.getElementById("DC").style.visibility='visible';
		formObj.document.getElementById("DC").style.display='inline';
		formObj.document.getElementById("DC_vw").style.visibility='visible';
		formObj.document.getElementById("DC_vw").style.display='inline';
	}else 
	{   
		formObj.document.getElementById("DC_vw").style.visibility='hidden';
		formObj.document.getElementById("DC_vw").style.display='none';
	}
}


  function ChkNumber(obj){
	var quantity_value=getLabel("Common.Quantity.label","Common");
	var quantity=obj.value;
	CheckNum(obj);
	if(obj.value!="" && quantity==0){
	  //Label: To Be Changed
	  alert(quantity_value + getMessage("VALUE_SHOULD_BE_GR_ZERO","common"));
	  obj.select();
	  obj.focus();
	}
}
function checkFields1( fields, names, messageFrame) {
    var errors = "" ;
    for( var i=0; i<fields.length; i++ ) {
        if(trimCheck(fields[i].value)) {
            fields[i].value = fields[i].value;
        }
        else {
			errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"<br>"
		}
    }
    if ( errors.length != 0 ) {
		messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors;
       return false ;
    }
    return true ;
}

function getRecId(){
  var rowLength=parent.parent.parent.parent.AdminObjectCollect.implants_len;
  var recId = rowLength+2;//Modified against SKR-SCF-1216
  parent.parent.parent.parent.AdminObjectCollect.implants_len = recId;
  return recId;
}

function getRecId_cons(){
    var rowLength=parent.parent.parent.parent.AdminObjectCollect.packs_len;
	var recId_cons = rowLength+2;		
	parent.parent.parent.parent.AdminObjectCollect.packs_len = recId_cons;
	return recId_cons;
}

function getRecId_eq(){	
    var rowLength=parent.parent.parent.parent.AdminObjectCollect.equipment_len;
	  var recId_cons = rowLength+1; //Modified against SKR-SCF-1216
	  //var recId_cons = rowLength+2;

	parent.parent.parent.parent.AdminObjectCollect.equipment_len = recId_cons;
	return recId_cons;
}

function getRecId_inst(){
    var rowLength=parent.parent.parent.parent.AdminObjectCollect.instrument_len;
	  var recId_cons = rowLength+2;	
  	parent.parent.parent.parent.AdminObjectCollect.instrument_len = recId_cons;
  	return recId_cons;
}

function sendparams_pi(index){
  var st_interface_flag=document.forms[0].st_interface_flag.value;	
  var rows = parent.parent.parent.AdminObjectCollect.implants_rows[index];
  var oper_code=rows.oper_code;
  var oper_desc=rows.oper_code+"##"+rows.oper_line_no;
  var line_no = rows.oper_line_no;
  var implant_code= rows.implant_code;
  var implant_desc = rows.implant_desc;
  var quantity=rows.quantity;
  var mfr="";
  var batch="";
  var sale_document_no="";
  var sale_document_type="";
  var reserved_qty ="";
  var requested_qty="";
  var req_store_code="";
  var Stockavail="";
  var Store_desc="";	

	if(st_interface_flag=="Y")
	{
	 sale_document_no=rows.sale_document_no;
     sale_document_type=rows.sale_document_type;
	 reserved_qty =rows.reserved_qty;
     requested_qty=rows.requested_qty;
     req_store_code=rows.req_store_code;
     Stockavail=rows.Stockavail;
	 Store_desc=rows.Store_desc;
	}
	
	if(st_interface_flag=='N')
	{
	 mfr = rows.manufacturer;
     batch = rows.batch;
	}
	
	var remarks=rows.remarks;
	var recId = rows.recId;
	var mode = "U";
	var order = rows.order;
	
	var str = oper_code+'::'+oper_desc+'::'+line_no+'::'+implant_code+'::'+implant_desc+'::'+quantity+'::'+mfr+'::'+batch+'::'+remarks+'::'+recId+'::'+mode+"::"+order+"::"+reserved_qty+"::"+requested_qty+"::"+req_store_code+"::"+Stockavail+"::"+Store_desc;
	splitString_pi(str);
}

function sendparams_cons(index){	
	var rows = parent.parent.parent.AdminObjectCollect.packs_rows[index];
	var oper_code=rows.oper_code;
	var oper_desc=rows.oper_code+"##"+rows.oper_line_no;
	var line_no = rows.oper_line_no;
	var instr_code= rows.package_code;
	var instr_desc = rows.package_desc;
    var tray_no=rows.quantity;
	var remarks=rows.remarks;
	var recId = rows.recId;
	var mode = "U";
	//var reserved_qty =rows.reserved_qty;
   // var requested_qty=rows.requested_qty;
    //var req_store_code=rows.req_store_code;
	var str = oper_code+'::'+oper_desc+'::'+line_no+'::'+instr_code+'::'+instr_desc+'::'+remarks+'::'+tray_no+'::'+recId+'::'+mode;
    splitString_cons(str);
}

function splitString_pi(strVal){
	var st_interface_flag=document.forms[0].st_interface_flag.value;
    var arr = strVal.split('::');
	var formObj = document.forms[0];
	var formObj = document.forms[0];
	formObj.oper_code.value=arr[0];
	formObj.operation_pi.value=arr[1];
	formObj.oper_line_no.value = arr[2];
	formObj.implant_code.value=arr[3];
	formObj.implant_desc.value=arr[4];
	formObj.quantity_pi.value=arr[5];
	if(st_interface_flag=='N')
	{
	formObj.manufacturer.value=arr[6];
	formObj.batch.value=arr[7];
	}
	formObj.remarks_pi.value=arr[8];
	formObj.recId.value = arr[9];
	formObj.mode.value = arr[10];
	if(st_interface_flag=='Y')
	{
	formObj.Reservepicklist_pi.value = arr[12];
	formObj.Requestpicklist_pi.value = arr[13];
	formObj.reqstore_code.value = arr[14];
	formObj.Stockavail_pi.value = arr[15];
	formObj.conns_store_pi.value = arr[16];
	formObj.Stockavail_pi.disabled=true;
	}

 
	
	
	
	/*if(arr[11]=="3"){
		formObj.operation.disabled=false;
		formObj.btn_cancel.disabled=true;
	}else{
		formObj.operation.disabled=true;
		formObj.btn_cancel.disabled=false;
	}*/
	formObj.operation_pi.disabled=true;
	formObj.btn_cancel.disabled=false;
	formObj.ImplantLookUp.disabled=true;
	formObj.implant_desc.disabled=true;
	
}

function splitString_cons(strVal){
    var arr = strVal.split('::');
	var formObj = document.forms[0];
	formObj.oper_code.value=arr[0];
	formObj.operation_cons.value=arr[1];
	formObj.oper_line_no.value = arr[2];
	formObj.package_code.value=arr[3];
	formObj.package_desc.value=arr[4];
	formObj.remarks_cons.value=arr[5];
	formObj.quantity_cons.value=arr[6];
	formObj.recId.value = arr[7];
	formObj.mode.value = arr[8];
	//formObj.Reservepicklist_cons.value = arr[9];
	//formObj.Requestpicklist_cons.value = arr[10];
	//formObj.conns_store_cons.value = arr[11];
	formObj.operation_cons.disabled=true;
	formObj.PackageLookUp.disabled=true;
	formObj.package_desc.disabled=true;
}

function removeRow(){
var formObj = document.forms[0];
var params = formObj.params.value;
var rows=parent.parent.parent.AdminObjectCollect.implants_rows;
var recId = document.forms[0].recId.value;
var mode = document.forms[0].mode.value;


if(rows.length>0 && mode=='U'){        
  for(var jj=0;jj<rows.length;jj++){
	 if(rows[jj]!=null){
		if(rows[jj].recId==recId){
			DeleteKey(rows[jj].key+rows[jj].key_line);
			 if( (rows[jj].db_mode=='L' || rows[jj].db_mode=='U') && (rows[jj].order=='1' ) )
				rows[jj].db_mode='D';
			 else
			  delete rows[jj];
			   break;
		}
	 }else
	continue;
 }//end for-Loop
   resetFields_pi();
   parent.parent.parent.parent.AdministrativeFucntionFrame.code_pi=new String();
   //abv line is for removing oper_code,implant_code combination from code_pi i.e refreshing that String field
   createTable_pi();
}//else
   resetFields_pi();
}

function removeRow_cons()
{
	var formObj = document.forms[0];
	//var params = formObj.params.value;
	var rows=parent.parent.parent.AdminObjectCollect.packs_rows;
	var recId = document.forms[0].recId.value;
	var mode = document.forms[0].mode.value;

	if(rows.length>0 && mode=='U'){        
	  for(var jj=0;jj<rows.length;jj++){
		 if(rows[jj]!=null){
			if(rows[jj].recId==recId){
				DeleteKey(rows[jj].key+rows[jj].key_line);
				 if( (rows[jj].db_mode=='L' || rows[jj].db_mode=='U') && (rows[jj].order=='1' ) )
					rows[jj].db_mode='D';
				 else
				  delete rows[jj];
				   break;
			}
		 }else
		continue;
	 }//end for-Loop
	   resetFields_cons();
	   parent.parent.parent.parent.AdministrativeFucntionFrame.code_cons=new String();
	   //abv line is for removing oper_code,implant_code combination from code_pi i.e refreshing that String field
	   createTable_cons();
	}
}

function DeleteKey(key){
	var xmlStr ="<root></root>";
	var temp_jsp="DeletePersistenceBeankey.jsp?del_key="+key;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	return responseText;
}

function resetFields_pi(){
	var formObj = document.forms[0];
	var st_interface_flag=document.forms[0].st_interface_flag.value;
	//formObj.operation.value=formObj.operation.value;
	//formObj.implant_code.value='';
	formObj.implant_desc.value='';
	//formObj.oper_code.value='';
	formObj.quantity_pi.value='';
	if(st_interface_flag=='N')
	{
	formObj.manufacturer.value='';
	formObj.batch.value='';
	}
	formObj.remarks_pi.value='';
    if(st_interface_flag=='Y')
	{
	formObj.Reservepicklist_pi.value=''
	formObj.Requestpicklist_pi.value='';
	formObj.sale_document_no.value=''
	formObj.sale_document_type.value=''
	formObj.conns_store_pi.value='';
    formObj.Stockavail_pi.value='';
	}
	
	formObj.mode.value='I';
	formObj.operation_pi.disabled=false;
    formObj.operation_pi.focus();
	formObj.ImplantLookUp.disabled=false;
	formObj.implant_desc.disabled=false;
	formObj.btn_cancel.disabled=false
}

function resetFields_cons(){
	var formObj = document.forms[0];
	//formObj.operation.value=formObj.operation.value;
	formObj.package_code.value='';
	formObj.package_desc.value='';
	formObj.oper_code.value='';
	formObj.quantity_cons.value='';
	formObj.remarks_cons.value='';
	formObj.mode.value='I';
	//formObj.Reservepicklist_cons.value = '';
	//formObj.Requestpicklist_cons.value = '';
	//formObj.conns_store_cons.value = '';
	formObj.operation_cons.disabled=false;
	formObj.PackageLookUp.disabled=false;
	formObj.package_desc.disabled=false;
    formObj.operation_cons.focus();
	//frmObj.InstrumentLookUp.disabled=false;	
}

function openDialogWindow_pi(strVal,index){
	var rows = parent.parent.parent.AdminObjectCollect.implants_rows[index];
	var remarks=encodeURIComponent(rows.remarks); 
	var size='100';
	window.showModalDialog('../../eOT/jsp/TextArea.jsp?heading='+encodeURIComponent(strVal)+'&remarks='+remarks+'&size='+size,window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
	}
	function openDialogWindow_dc(strVal,index){
	//var rows = parent.parent.parent.AdminObjectCollect.implants_rows[index];
	//var remarks=encodeURIComponent(rows.remarks); 
	var formObj=document.forms[0];

	var remarks=eval("formObj.remarks_dc_"+index).value;
	window.showModalDialog('../../eOT/jsp/TextArea.jsp?heading='+encodeURIComponent(strVal)+'&remarks='+remarks,window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
}

function openDialogWindow_cons(strVal,index){
var rows = parent.parent.parent.AdminObjectCollect.packs_rows[index];
var remarks=encodeURIComponent(rows.remarks); 
var size='100';
window.showModalDialog('../../eOT/jsp/TextArea.jsp?heading='+encodeURIComponent(strVal)+'&remarks='+remarks+'&size='+size,window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
}

function checkLimit(field, limit){
  if (field.value.length > limit){
		   //var msg = getMessage("REMARKS_CANNOT_EXCEED");
		   var msg = getMessage("MAX_LENGTH_DATA","OT");
		   var msgArray = msg.split("#");
		   alert(msgArray[0]+""+msgArray[1]+limit+msgArray[2]);
		   // Truncate at the limit
		   var revertField = field.value.slice(0, limit);
		   field.value = revertField;
		   field.focus();
	  }
}

function assignRecId_pi(){
	var rows = parent.parent.parent.AdminObjectCollect.implants_rows;
	parent.parent.parent.parent.AdminObjectCollect.implants_len=rows.length;	
}

function assignRecId_cons(){
	var rows = parent.parent.parent.AdminObjectCollect.packs_rows;
	parent.parent.parent.parent.AdminObjectCollect.packs_len=rows.length;	
}

function assignRecId_eq(){
	var rows = parent.parent.parent.AdminObjectCollect.equipment_rows;
	parent.parent.parent.parent.AdminObjectCollect.equipment_len=rows.length;	
}

function assignRecId(){
	var rows = parent.parent.parent.AdminObjectCollect.implants_rows;
	//parent.parent.parent.parent.AdminObjectCollect.implants_len=rows.length;	
}

function loadDBRows_cons(oper_code,oper_desc,line_no,package_code,package_desc,quantity,remarks,index,mode,order,bill_str,panel_str,key,key_line){ 
  var objrow = newRow_cons();
  var rows=parent.parent.parent.AdminObjectCollect.packs_rows;
  var rowLength=parent.parent.parent.AdminObjectCollect.packs_len;
  if(mode=='L' && rowLength==0){
	  objrow.oper_code=oper_code;
	  objrow.oper_desc=unescape(oper_desc);
	  objrow.package_code=package_code;
	  objrow.package_desc=unescape(package_desc);
	  objrow.oper_line_no=line_no;
	  objrow.quantity=quantity;
	  
	  //objrow.reserved_qty=reserved_qty;
	  //objrow.requested_qty=requested_qty;
	  //objrow.req_store_code=req_store_code;
	  
	  //objrow.remarks=remarks;Anitha
  	  objrow.remarks=decodeURIComponent(remarks,"UTF-8").replace(/\+/g," ");
	  objrow.recId = index;
	  //objrow.db_mode="L";
	  objrow.db_mode=(order==1)?"L":"I";
	  objrow.order = order;
	  objrow.bill_str=bill_str;
	  objrow.panel_str=panel_str;
	  objrow.key=key;
	  objrow.key_line=key_line;
	  objrow.rate="";
	  rows.push(objrow);
	  
	  }
}
/* Package Lookup*/

function searchPackage(obj,target){
	var code_name = obj.name;
	var desc_name = target.name;
	var tcode = obj.value;
	var tdesc = target.value;
	var sql='';
	var retVal =  new String();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var tit=getLabel("Common.Package.label","Common");
	var locale = document.forms[0].locale.value;
	var sql="SELECT LONG_DESC description, PACKAGE_CODE code FROM OT_PACKAGE_HDR_LANG_VW WHERE NVL(STATUS,'E') = 'E' and upper(LONG_DESC) like upper(?) and upper(PACKAGE_CODE) like upper(?) AND LANGUAGE_ID='"+locale+"'  order by 2";
	var locale = document.forms[0].locale.value;
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		if(target.name == desc_name){
			obj.value = arr[0];
			document.forms[0].target.disabled=true;
		}
	}else{
		target.value="";
		obj.value="";
	}
}
/*function searchPackage(obj,target){
	var code_name = obj.name;
	var desc_name = target.name;
	var tcode = obj.value;
	var tdesc = target.value;
	obj.value='';
	target.value='';
	var sql='';
	var retVal =  new String();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	//var tit="Search Package";
	var tit=getLabel("Common.Package.label","Common");
	var locale = document.forms[0].locale.value;
//Code altered by Selvam for PHASE 3 Delivery
//	var sql="SELECT SHORT_DESC description, PACKAGE_CODE code FROM OT_PACKAGE_HDR_LANG_VW WHERE NVL(STATUS,'E') = 'E' and upper(SHORT_DESC) like upper(?) and upper(PACKAGE_CODE) like upper(?) AND LANGUAGE_ID='"+locale+"'  order by 2";
	var sql="SELECT LONG_DESC description, PACKAGE_CODE code FROM OT_PACKAGE_HDR_LANG_VW WHERE NVL(STATUS,'E') = 'E' and upper(LONG_DESC) like upper(?) and upper(PACKAGE_CODE) like upper(?) AND LANGUAGE_ID='"+locale+"'  order by 2";
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		if(target.name == desc_name){
			obj.value = arr[0];
			document.forms[0].target.disabled=true;
		}
	}else{
		target.value=tdesc;
		obj.value=tcode;
	}
}*/

/* Impalnt LookUp */
 /*function searchProsthesis(obj,target){
	var dialogTop  = "40";
	var dialogHeight = "10";
	var dialogWidth  = "40";
	var arguments = "";
	var locale = document.forms[0].locale.value;
	var formObj = document.forms[0];
	var column_sizes = escape("30%,10%,25%,25%");               
	var column_descriptions=getLabel('Common.description.label','common')+','+getLabel('Common.code.label','common')+','+getLabel('Common.category1.label','common')+','+getLabel('Common.type.label','common');

	column_descriptions = encodeURIComponent(column_descriptions);
	var sql=escape("SELECT A.SHORT_DESC description, A.PROSTHESIS_CODE code FROM OT_PROSTHESIS_LANG_VW  A WHERE A.LANGUAGE_ID='"+locale+"' AND NVL(A.STATUS,'E') = 'E'");  // This query is to be modified as above.. (+) to be verified

	var title=encodeURIComponent(getLabel("Common.Implant.label","Common"));
	var features  = "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql//+"&search_criteria="+formObj.target.value;
	
	retVal=window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);
	
	if(retVal != null && retVal != "" ){
		var arr = retVal.split('::');
		obj.value = arr[1];
		target.value=arr[0];
	}else{
		target.value="";
		obj.value="";
	}
	var st_interface_flag=formObj.st_interface_flag.value;
	if(st_interface_flag =="Y")
	{
	formObj.conns_store_pi.value="";
	formObj.Stockavail_pi.value="";
	}
  }*/

  async function searchProsthesis(obj,target){

	var code_name = obj.name;
	var desc_name = target.name;
	var tcode = obj.value;
	var tdesc = target.value;
	var locale=document.forms[0].locale.value;
	var formObj = document.forms[0];
	var st_interface_flag=formObj.st_interface_flag.value;
	var sql='';
	var retVal =  new String();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var tit=encodeURIComponent(getLabel("Common.Implant.label","Common"));

	var sql="SELECT A.SHORT_DESC description, A.PROSTHESIS_CODE code FROM OT_PROSTHESIS_LANG_VW  A WHERE A.LANGUAGE_ID='"+locale+"' AND NVL(A.STATUS,'E') = 'E' and upper(SHORT_DESC) like upper(?) and upper(PROSTHESIS_CODE) like upper(?) order by 2";
	
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		if(target.name == desc_name){
			obj.value = arr[0];
			document.forms[0].target.disabled=true;
		}
	}else{
		target.value="";
		obj.value="";
	}

	if(st_interface_flag=="Y")
	{
		formObj.conns_store_pi.value="";
		formObj.Stockavail_pi.value="";
	}
}

async function searchStore(obj,target)
{
    var locale = document.forms[0].locale.value;
    var facility_id = document.forms[0].facility_id.value;
    var room_code = document.forms[0].oper_room_code.value;
	var implant_desc=document.forms[0].implant_desc.value;
	if(implant_desc=='')
	{
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		var Implant = getLabel("Common.Implant.label","Common");
		msg=msgArray[0]+Implant+msgArray[1];
		alert(msg);
		document.forms[0].conns_store_pi.value="";
		document.forms[0].Stockavail_pi.value="";
		return false;
	}else
	{
   // var room_code = document.forms[0].oper_room_code.value;
	var code_name = obj.name;
	var desc_name = target.name;
	var tcode = obj.value;
	var tdesc = target.value;
	var retVal =  new String();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	//var tit="Anatomical Site Search";
	var tit=getLabel("eOT.ConsumptionStore.Label","OT");

	var sql="SELECT B.SHORT_DESC description,A.STORE_CODE  Code FROM OT_STORES_FOR_THEATRE A,MM_STORE_LANG_VW B WHERE A.STORE_CODE   = B.STORE_CODE AND   A.OPERATING_FACILITY_ID ='"+facility_id+"'  AND   OPER_ROOM_CODE ='"+room_code+"' AND   STORE_TYPE   ='R' AND   B.LANGUAGE_ID  = '"+locale+"' AND   B.EFF_STATUS   ='E' and upper(b.SHORT_DESC) like upper(?) and upper(a.STORE_CODE) like upper(?) order by 1 ";

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].reqstore_code.value = arr[0];
		target.value=arr[1];
	}else{
		target.value="";
		document.forms[0].reqstore_code.value="";
	}

	var item_id=document.forms[0].implant_code.value;
	var store_code=document.forms[0].reqstore_code.value;
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open("POST","CommonValidation.jsp?func_mode=pick_lict_QOH&item_id="+item_id+"&store_code="+store_code,false);
	xmlHttp.send(xmlDoc);
    
	var retVal = localTrimString(xmlHttp.responseText); 
	if(retVal =="false")
	{
			alert(getMessage("ITEM_STORE_NOT_FOUND","ST"));
			document.forms[0].conns_store_pi.value="";
			document.forms[0].Stockavail_pi.value="";

	}else if(retVal =="false1")
	{
		alert(getMessage("APP-OT0143","OT"));
		document.forms[0].conns_store_pi.value="";
		document.forms[0].Stockavail_pi.value="";
	}else
	{
	document.forms[0].Stockavail_pi.value=retVal;
	document.forms[0].Stockavail_pi.disabled=true;
	}
	}

}


function openRemarksWindow(obj,from)
{
        if(from=='implants')
		var remarks=encodeURIComponent(document.forms[0].remarks_pi.value);
		else if(from=='consumables')
		var remarks=encodeURIComponent(document.forms[0].remarks_cons.value);
		else if(from=='equipments')
	    var remarks=encodeURIComponent(document.forms[0].remarks_eq.value);
		else if(from=='instrumnets')
	    var remarks=encodeURIComponent(document.forms[0].remarks_ic.value);
		var flag="1"	;
		var size="1000";
		var heading = getLabel("Common.remarks.label","common");
		var dialogHeight		= "9";
		var dialogWidth			= "32";
		var features			="dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		var arguments			= "";
		heading=encodeURIComponent(heading);
		var param='remarks='+remarks+'&heading='+heading+'&flag='+flag+'&size='+size;
		var params=unescape(param);
		var ret=""+window.showModalDialog("../../eOT/jsp/TextArea.jsp?"+param,arguments,features);
		if(flag=='1' && ret!="undefined" ){
			ret=ret.slice(0,ret.length);
			obj.value=ret;
		}
}
function callBillingWindow_pi(index){
	var rows=parent.parent.parent.AdminObjectCollect.implants_rows[index];
	var key = rows.key;
	var key_line = rows.key_line;
	var oper_code = rows.oper_code;

	var param = "order_id="+key+"&order_line_num="+key_line+"&called_from=SURG_ACC";
	var xmlStr ="<root></root>";
	var temp_jsp="GetBillDetailsFromPersistence.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	showBillingWindow(responseText,index,"Implants");
}

function callBillingWindow_cons(index){
	var rows=parent.parent.parent.AdminObjectCollect.packs_rows[index];
	var key = rows.key;
	var key_line = rows.key_line;
	var oper_code = rows.oper_code;
	var patient_id = "";
	var param = "order_id="+key+"&order_line_num="+key_line+"&called_from=SURG_ACC";
	var xmlStr ="<root></root>";
	var temp_jsp="GetBillDetailsFromPersistence.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	showBillingWindow(responseText,index,"Consumables");
}

function callBillingWindow_eq(index){
	var rows=parent.parent.parent.AdminObjectCollect.equipment_rows[index];
	var key = rows.key;
	var key_line = rows.key_line;
	var oper_code = rows.oper_code;
	var patient_id = "";
	var param = "order_id="+key+"&order_line_num="+key_line+"&called_from=SURG_ACC";
	var xmlStr ="<root></root>";
	var temp_jsp="GetBillDetailsFromPersistence.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText);
	showBillingWindow(responseText,index,"Equipments");	
}
function callBillingWindow_ic(index){
	var rows=parent.parent.parent.AdminObjectCollect.instrument_rows[index];
	var key = rows.key;
	var key_line = rows.key_line;
	var order_line_no = rows.order_line_no;
	//key_line="";
	var oper_code = rows.oper_code;
	var patient_id = "";
	var param = "order_id="+key+"&order_line_num="+key_line+"&called_from=SURG_ACC";
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var temp_jsp="GetBillDetailsFromPersistence.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	showBillingWindow(responseText,index,"Instruments");
}

async function showBillingWindow(str,index,from){
	var oper_num=document.forms[0].oper_num.value;
	var oper_code=document.forms[0].oper_code.value;
	var episode_type=document.forms[0].episode_type.value;

	if(from=="Implants")
	{
		var rows=parent.parent.parent.AdminObjectCollect.implants_rows[index];
		//var key=oper_num+"@"+oper_code+"@S@"+"S";
	}
	else if(from=="Consumables")
	{
		var rows=parent.parent.parent.AdminObjectCollect.packs_rows[index];
		//var key=oper_num+"@"+oper_code+"@S@"+"P";
	}
	else if(from=="Equipments")
	{
		var rows=parent.parent.parent.AdminObjectCollect.equipment_rows[index];
		//var key=oper_num+"@"+oper_code+"@S@"+"E";
	}
	else if(from=="Instruments")
	{
		var rows=parent.parent.parent.AdminObjectCollect.instrument_rows[index];
		///var key=oper_num+"@"+oper_code+"@S@"+"I";
	}
	var module_id = (rows.order==1)?"OT":"OR";
	var key=rows.key; 
	var key_line_no=rows.key_line;
	var arr = str.split("::");
	var order_id=rows.key;
	var order_line_no=rows.key_line; 
	var order_catalog_code=arr[2]; 
	var patient_id = arr[3];  
	var episode_type = episode_type;
	var episode_id=arr[5];         
	var visit_id=arr[6];
	var encounter_id=arr[7]; 
	var service_date=arr[8];  
	var pract_staff_ind=arr[9];          
	var pract_staff_id=arr[10];
	var service_panel_ind=arr[11]; 
	var service_panel_code=arr[12]; 
	//var original_qty = arr[19];//commented against SKR-SCF-1216_Muthu-190611
	var original_qty = 1;//Added against SKR-SCF-1216_Muthu-190611
	var revised_qty = rows.quantity;
	var total_qty = rows.quantity;
	var bl_panel_str = rows.panel_str;
	var bean_id="";

	var dialogTop = "100";
	var dialogHeight = "30" ;
	var dialogWidth = "70" ;
	var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var title=encodeURIComponent(getLabel("eBL.EDIT_ENTER_CHARGE_DETAILS.label","BL"));
	var arguments = "" ;
	var column_sizes = "";
	var column_descriptions ="";       
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"episode_type="+episode_type+"&"+"patient_id="+patient_id+"&"+"visit_id="+visit_id+"&"+"episode_id="+episode_id+"&"+"service_panel_code="+service_panel_code+"&"+"service_panel_ind="+service_panel_ind+"&"+"service_date="+service_date+"&"+"order_catalog_code="+order_catalog_code+"&"+"module_id="+module_id+"&encounter_id="+encounter_id+"&key="+key+"&key_line_no="+key_line_no+"&order_id="+order_id+"&order_line_no="+order_line_no+"&bean_id="+bean_id+"&total_qty="+total_qty+"&revise_qty="+revised_qty+"&original_qty="+original_qty+"&quantity="+revised_qty+"&qty="+revised_qty+"&p_serv_qty="+revised_qty+"&revised_qty="+revised_qty+"&serv_panel_qty="+revised_qty+"&modify_qty_yn=Y&p_str="+bl_panel_str; 

	var retVal = await window.showModalDialog("../../eBL/jsp/BLEnterEditChargeDtlMain.jsp?"+param,arguments,features);
	
	if(retVal!=null){
		var retArray  = retVal;
		//total_payable::patient_payable::patient_paid
		var arr = rows.bill_str.split("::");
		if(arr[6]=='L' || retArray[6]=="")
		{
			retArray[6]=null;
			retArray[7]=null;
		}
			rows.bill_str = retArray[1]+"::"+retArray[2]+"::"+retArray[3]+"::"+arr[3]+"::"+retArray[6]+"::"+arr[5]+"::"+arr[6]+"::"+retArray[7]+"::"+retArray[8];/* Here retArray[8] value is only for screen usage retArray[6]  value only for db insertion*/
			rows.rate = retArray[5];
		
		//rows.db_mode = (rows.order==1)?"U":"I";
		if(rows.db_mode!="I"){
			rows.db_mode = (rows.order==1 || rows.order==null || rows.order=="")?"U":"I";
			var pnl_str =  getPanelStr(patient_id,index,from);
			rows.panel_str =pnl_str.split("::")[13];
		}
		//if(service_panel_ind=="L"){
			var pnl_str =  getPanelStr(patient_id,index,from);
			rows.panel_str =pnl_str.split("::")[13];
		//}
		  if(from=="Implants")createTable_pi();
		  else if(from=="Consumables")createTable_cons();
		  else if(from=="Equipments")createTable_eq();
		  else if(from=="Instruments")createTable_ic();
	}
}

function getPanelStr(patient_id,index,from){
   if(from=="Implants")
   var rows=parent.parent.parent.AdminObjectCollect.implants_rows[index];
   else if(from=="Consumables")
   var rows=parent.parent.parent.AdminObjectCollect.packs_rows[index];
   else if(from=="Equipments")
   var rows=parent.parent.parent.AdminObjectCollect.equipment_rows[index];
   else if(from=="Instruments")
   var rows=parent.parent.parent.AdminObjectCollect.instrument_rows[index];

	//var order_id = rows.order_id;
	var order_id = "";
	var order_line_num = "";
	var oper_code = rows.oper_code;
	var key = rows.key;
	var key_line = rows.key_line;	
	
	var param = "key="+key+"&key_line="+key_line+"&order_id="+order_id+"&order_line_num="+order_line_num+"&oper_code="+oper_code+"&patient_id="+patient_id+"&called_from=SURG_ACC_EDIT";
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var temp_jsp="GetBillDetailsFromPersistence.jsp?"+param;
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	return responseText;	
	//showBillingWindow(responseText,index);
}

function loadDBRows_eq(oper_code,oper_desc,line_no,instr_code,instr_desc,tray_no,remarks,oper_line_status,index,mode,order,bill_str,panel_str,key,key_line,quantity,st_location, desiredDate){ 
  var objrow = newRow();
  var rows=parent.parent.parent.AdminObjectCollect.equipment_rows;
  var rowLength=parent.parent.parent.AdminObjectCollect.equipment_len;
  if(mode=='L' && rowLength==0){
	  objrow.oper_code=oper_code;
	  objrow.oper_desc=decodeURIComponent(oper_desc,"UTF-8").replace(/\+/g," ");
	  objrow.equip_code=instr_code;	  
	  objrow.equip_desc=decodeURIComponent(instr_desc,"UTF-8").replace(/\+/g," ");
	  objrow.oper_line_no=line_no;
	  objrow.equip_id=tray_no;
	  objrow.st_location=st_location;//CRF - 091
	  objrow.desiredDate=desiredDate;
	  //objrow.remarks=remarks;Anitha
  	  objrow.remarks=decodeURIComponent(remarks,"UTF-8").replace(/\+/g," ");
	  objrow.oper_line_status=oper_line_status; //Added for AMRI CRF 294
	  objrow.recId = index;
	  objrow.db_mode=(order==1)?"L":"I";
	  objrow.order = order;
	  objrow.bill_str=bill_str;
	  objrow.panel_str=panel_str;
	  objrow.key=key;
	  objrow.key_line=key_line;
	  objrow.quantity=quantity;
	  objrow.rate="";
	  rows.push(objrow);	
	 }
}

function isModified(rows){
	var modified_flag=false;
	
	if(rows.length>0){
		for(var i=0;i<rows.length;i++){
			if(rows[i]!=null){
				if(rows[i].db_mode!='L'){
					modified_flag=true;
					break;
				}
			} 
			continue;
		}
	}
	return modified_flag;
}

function isRowCommit(){
	var implants_rows = parent.parent.AdminObjectCollect.implants_rows;
	var packs_rows = parent.parent.AdminObjectCollect.packs_rows;

	var submit_flag = "F";
	if(isModified(implants_rows)){
		submit_flag = "T";
	}
	if(isModified(packs_rows)){
		submit_flag = "T";
	}
}

function recordCharges()
{	
	var frmObj = parent.parent.AdminObjectCollect;
	// oper_date=parent.parent.OtPatientLineFrame.OTPatientLineFrame.oper_date.value;
	 if(parent.parent.OtPatientLineFrame.OTPatientLineFrame.oper_date==null || parent.parent.OtPatientLineFrame.OTPatientLineFrame.oper_date=='undefined'){
		var oper_date="";
	}else{
		var oper_date=parent.parent.OtPatientLineFrame.OTPatientLineFrame.oper_date.value;
	}
	var hdrobj = parent.parent.AdministrativeFucntionFrame.AdministrativeFunctionforAllChargesForm;
	var tabobj = parent.parent.AdministrativeFunctionCompletionStatus.AdministrativeFunctionforAllChargesForm;
	var maxRecord=hdrobj.maxRecord.value;
	var oper_compl_yn=hdrobj.oper_compl_yn.checked;
	var slate_user_id=hdrobj.slate_user_id.value;
	var proc_chrg_cmp_yn=hdrobj.proc_chrg_cmp_yn.value;
	var include_exclude1=hdrobj.include_exclude1.value;
	var include_exclude_or=hdrobj.include_exclude_or.value;
	var action_reason_code1  =hdrobj.action_reason_code1.value;
	var action_reason_code_or=hdrobj.action_reason_code_or.value;
	if(oper_compl_yn==true)
	{
		oper_compl_yn="Y";
		//proc_chrg_cmp_yn = "Y";//47741
	}
	else
		oper_compl_yn="N";
	var bill_flag=hdrobj.bill_flag.value;
	var booking_num=hdrobj.booking_num.value;
	var implant_entry_cmp_yn=hdrobj.implant_entry_cmp_yn.value;
	var consumable_entry_cmp_yn=hdrobj.consumable_entry_cmp_yn.value;
	var equipment_entry_cmp_yn=hdrobj.equipment_entry_cmp_yn.value;
	var instrument_entry_cmp_yn=hdrobj.instrument_entry_cmp_yn.value;
	var hld_chrg_cmp_yn=hdrobj.hld_chrg_cmp_yn.value;
	var or_chrg_cmp_yn=hdrobj.or_chrg_cmp_yn.value;
	var rec_chrg_cmp_yn=hdrobj.rec_chrg_cmp_yn.value;
	var oper_num=hdrobj.oper_num.value;
	var surgeon_code=hdrobj.surgeon_code.value;
	var order_id=hdrobj.order_id.value;
	var pros_implants_req=tabobj.pi_complete.checked;
	var cons_packs_req=tabobj.cp_complete.checked;
	var equipments_req=tabobj.eq_complete.checked;
	var inst_cssd_req=tabobj.ic_complete.checked;
	var locale=hdrobj.locale.value;
	var st_interface_flag=hdrobj.st_interface_flag.value;
	var finalize_implants_in=tabobj.finalize_implants_in.value;
	var finalize_equp_in=tabobj.finalize_equp_in.value;
	var finalize_instr_in=tabobj.finalize_instr_in.value;
	var finalize_packs_in=tabobj.finalize_packs_in.value;
	var pros_implants_yn="N";
	var cons_packs_yn="N";
	var equipments_yn="N";
	var inst_cssd_yn="N";
	var recy_room_finalization_stage=hdrobj.recy_room_finalization_stage.value;
	var hold_finalization_stage=hdrobj.hold_finalization_stage.value;
	var oper_room_finalization_stage=hdrobj.oper_room_finalization_stage.value;
	var charge_holding_area_yn=hdrobj.charge_holding_area_yn.value;
	var charge_operating_room_yn=hdrobj.charge_operating_room_yn.value;
	var charge_recovery_room_yn=hdrobj.charge_recovery_room_yn.value;
	var checkInTime = hdrobj.checkInTime.value;
	var customerId = hdrobj.customer_id1.value;		
	var rec_chargeable_yn=hdrobj.rec_chargeable_yn.value;
	var or_chargeable_yn=hdrobj.or_chargeable_yn.value;
		
	if(pros_implants_req ==true)
		pros_implants_yn="Y";
	else
		pros_implants_yn="N";
	if(cons_packs_req ==true)
	{
		cons_packs_yn="Y";
		/*Added by Suma for checking sales finalization part added on 01/03/2010*/
		var facility_id = hdrobj.facility_id.value;			
		var accession_num=facility_id+"@"+ oper_num;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=chk_for_sales_finalize&accession_num="+accession_num,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
	if(retVal !="0")
	  {
		 var msg = getMessage("APP-OT0186","OT");
			alert(msg);
			tabobj.cp_complete.checked=false;
			cons_packs_yn="N";
	  }
	}
	else
		cons_packs_yn="N";

	if(equipments_req ==true)
		equipments_yn="Y";
	else
		equipments_yn="N";

	if(inst_cssd_req ==true)
		inst_cssd_yn="Y";
	else
		inst_cssd_yn="N";

	var doc_compl_rec=false;
	var doc_compl_or=false;
	var doc_compl_ha=false;
	var recv_bl_accession_num="";
	var rec_room_code="";
	var modified_charge_units="";
	var serv_code="";
	var oper_room_code_or="";
	var serv_code_or="";
	var modified_charge_units_or="";
	var or_bl_accession_num="";
	var final_val="";
	
	//RecoveryRoom
	if(bill_flag=="true" && charge_recovery_room_yn=='Y' && rec_chargeable_yn=='Y')
	{
		doc_compl_rec=hdrobj.doc_compl_rec.checked;
		recv_bl_accession_num=hdrobj.recv_bl_accession_num.value;
		rec_room_code=hdrobj.recovery_room_code.value;
		modified_charge_units=hdrobj.modified_charge_units.value;
		serv_code=hdrobj.serv_code.value;
	}
	//Oper room
	if(bill_flag=="true" && charge_operating_room_yn=="Y" && or_chargeable_yn=="Y")
	{
		doc_compl_or=hdrobj.doc_compl_or.checked;
		oper_room_code_or=hdrobj.oper_room_code_or.value;
		serv_code_or=hdrobj.serv_code_or.value;
		modified_charge_units_or=hdrobj.modified_charge_units_or.value;
		or_bl_accession_num=hdrobj.or_bl_accession_num.value;
	}
	//Holding Area    holding area chargeableyn is taking from query only not required conding here
	if(bill_flag=="true" && charge_holding_area_yn=='Y' && maxRecord>0)
	{
		doc_compl_ha=hdrobj.doc_compl_ha.checked;
		final_val=getHoldingAreaParam(maxRecord);
	}
	
	var patient_id=hdrobj.patient_id.value;

	if(doc_compl_rec ==true)
		var doc_compl_rec_yn="Y";
	else
		var doc_compl_rec_yn="N";

	if(doc_compl_or ==true)
		var doc_compl_or_yn="Y";
	else
		var doc_compl_or_yn="N";

	if(doc_compl_ha ==true)
		var doc_compl_ha_yn="Y";
	else
		var doc_compl_ha_yn="N";

	/* Note: hld_chrg_cmp_yn,or_chrg_cmp_yn,rec_chrg_cmp_yn values if 'Y' it should not call billing procedures with repsective functions this condition should include in ejb instead below code is written  doc_compl_ha,doc_compl_or_yn,doc_compl_rec_yn if these values 'N' it will not call billing procedures. pls remove the code when condition directly apply in ejb*/
	if(hld_chrg_cmp_yn=='Y')
		doc_compl_ha_yn='N';
	if(or_chrg_cmp_yn=='Y') 
		doc_compl_or_yn='N';
	if(rec_chrg_cmp_yn=='Y')
		doc_compl_rec_yn='N';
		var msg = getMessage("NO_CHANGE_TO_SAVE","common");
	//Modified by DhanasekarV against issue IN026140  on 28/01/2011
		oper_date =convertDate(oper_date,'DMY',locale,'en');
	//end
	var param	=	"booking_num="+booking_num+
					"&oper_num="+oper_num+
					"&surgeon_code="+surgeon_code+
					"&order_id="+order_id+
					"&pros_implants_yn="+pros_implants_yn+
					"&cons_packs_yn="+cons_packs_yn+
					"&equipments_yn="+equipments_yn+
					"&inst_cssd_yn="+inst_cssd_yn+
					"&doc_compl_rec_yn="+doc_compl_rec_yn+
					"&recv_bl_accession_num="+recv_bl_accession_num+
					"&rec_room_code="+rec_room_code+
					"&modified_charge_units="+modified_charge_units+
					"&serv_code="+serv_code+
					"&patient_id="+patient_id+
					"&doc_compl_or_yn="+doc_compl_or_yn+
					"&doc_compl_ha_yn="+doc_compl_ha_yn+
					"&oper_room_code_or="+oper_room_code_or+
					"&serv_code_or="+serv_code_or+
					"&modified_charge_units_or="+modified_charge_units_or+
					"&or_bl_accession_num="+or_bl_accession_num+
					"&final_val="+final_val+
					"&locale="+locale+
					"&st_interface_flag="+st_interface_flag+
					"&finalize_implants_in="+finalize_implants_in+
					"&finalize_equp_in="+finalize_equp_in+
					"&finalize_instr_in="+finalize_instr_in+
					"&finalize_packs_in="+finalize_packs_in+
					"&oper_compl_yn="+oper_compl_yn+
					"&slate_user_id="+slate_user_id+
					"&oper_date="+oper_date+
					"&charge_recovery_room_yn="+charge_recovery_room_yn+
					"&rec_chargeable_yn="+rec_chargeable_yn+
					"&rec_chrg_cmp_yn="+rec_chrg_cmp_yn+
					"&bill_flag="+bill_flag+
					"&or_chargeable_yn="+or_chargeable_yn+
					"&charge_operating_room_yn="+charge_operating_room_yn+
					"&charge_holding_area_yn="+charge_holding_area_yn+
					"&hld_chrg_cmp_yn="+hld_chrg_cmp_yn+
					"&or_chrg_cmp_yn="+or_chrg_cmp_yn+
					"&include_exclude1="+include_exclude1+
					"&include_exclude_or="+include_exclude_or+
					"&action_reason_code1="+action_reason_code1+
					"&action_reason_code_or="+action_reason_code_or+
					"&checkInTime="+checkInTime+
					"&customerId="+customerId+
					"&proc_chrg_cmp_yn="+proc_chrg_cmp_yn;
					
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr="<root>";
	var action = '../../servlet/eOT.AdministrativeFunctionforAllChargesServlet?'+param;
	if(proc_chrg_cmp_yn!='Y')
	xmlStr+=frmObj.createXMLForOperations();
	if(implant_entry_cmp_yn!='Y')
	xmlStr+=frmObj.createXMLForImplants();
	if(consumable_entry_cmp_yn!='Y')
	xmlStr+=frmObj.createXMLForPackage();
	if(equipment_entry_cmp_yn!='Y')
	xmlStr+=frmObj.createXMLForEquipments();
	if(instrument_entry_cmp_yn!='Y')
	xmlStr+=frmObj.createXMLForInstruments();
	xmlStr+="</root>";		
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",action,false);
	xmlHttp.send(xmlDoc);	
	var retVal = trimString(xmlHttp.responseText);
	if(retVal!=null && retVal!=" ")
	{
		if(retVal == "SUCCESS")
		{
			  alert(getMessage("RECORD_INSERTED","SM"));
			  window.returnValue=getMessage("RECORD_INSERTED","SM");
			  window.close();
		}
		else
		{
			  alert(retVal);
			  window.close();
			}
		}
 }

function getHoldingAreaParam(maxRecord){
	var final_val="";
	var hdrobj = parent.parent.AdministrativeFucntionFrame.AdministrativeFunctionforAllChargesForm;
	var xmlString ="";  
	for(var i=0;i<maxRecord;i++){
		var temp_val="";
		//chk_in_ha_date_time=eval("hdrobj.chk_in_ha_date_time_"+i).value;
		// chk_out_ha_date_time=eval("hdrobj.chk_out_ha_date_time_"+i).value;
		charge_units_ha=eval("hdrobj.charge_units_ha_"+i).value;
		bl_accession_num=eval("hdrobj.bl_accession_num_"+i).value;
		holding_area_code=eval("hdrobj.holding_area_code_"+i).value;
		modified_charge_units_ha=eval("hdrobj.modified_charge_units_ha_"+i).value;
		serv_code_ha=eval("hdrobj.serv_code_ha_"+i).value;

		chk_in_ha_date_time=eval("hdrobj.checked_in_date_time_"+i).value;
		chk_out_ha_date_time=eval("hdrobj.checked_out_date_time_"+i).value;
		calc_charge_units=eval("hdrobj.calc_charge_units_"+i).value;
		holding_seq_num=eval("hdrobj.holding_seq_num_"+i).value;
		include_exclude_ha=eval("hdrobj.include_exclude_ha_"+i).value;
		action_reason_code_ha=eval("hdrobj.action_reason_code_ha_"+i).value;
		if(include_exclude_ha=="")include_exclude_ha="null";
		if(action_reason_code_ha=="")action_reason_code_ha="null";
		temp_val="$$"+charge_units_ha+"$$"+bl_accession_num+"$$"+holding_area_code+"$$"+modified_charge_units_ha+"$$"+serv_code_ha+"$$"+chk_in_ha_date_time+"$$"+chk_out_ha_date_time+"$$"+calc_charge_units+"$$"+holding_seq_num+"$$"+include_exclude_ha+"$$"+action_reason_code_ha;
		final_val+=temp_val+"@@";
	}
   return final_val;
 }

function callChargeableUnits(){
	var formObj=document.forms[0];
	var charge_recovery_room_yn=formObj.charge_recovery_room_yn.value;
	var rec_chargeable_yn=formObj.rec_chargeable_yn.value;
	var bill_flag=formObj.bill_flag.value;
	if(trimString(charge_recovery_room_yn)=='Y' && trimString(rec_chargeable_yn)=='Y' && trimString(bill_flag)=="true")
	{
	var facility_id=formObj.facility_id.value;
	var recovery_end_time=formObj.recovery_end_time.value;
	var recovery_start_time=formObj.recovery_start_time.value;
	var recovery_room_code=formObj.recovery_room_code.value;
	if(recovery_end_time!="" && recovery_start_time!=""){
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "chk_in_dt_time="+recovery_start_time+"&chk_out_dt_time="+recovery_end_time+"&recovery_room_code="+recovery_room_code+"&facility_id="+facility_id;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","AdminFunctionChargeUnits.jsp?func_mode=callChargeUnits&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		var arrVal=retVal.split("##")
        if(arrVal[2]==null)arrVal[2]="";
        if(arrVal[3]==null)arrVal[3]="";
        if(arrVal[4]==null)arrVal[4]="";
		if(arrVal[2]!="" || arrVal[3]!="" || arrVal[4]!=""){
			if(arrVal[4]=="")
			{
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "func_mode=getErrmsg&msg_id="+arrVal[3];
			xmlHttp.open("GET","../../eOT/jsp/CommonValidation.jsp?"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			alert(retVal);
			}else
			{
				alert(arrVal[4]);
			}
			parent.parent.parent.AdministrativeFunctionCompletionStatus.AdministrativeFunctionforAllChargesForm.record.disabled=true;
			return;			
		}else{
			//formObj.modified_charge_units.value=arrVal[0];
			formObj.modified_charge_units.value=formObj.charge_units_rec.value;
			var units=formObj.charge_units_rec.value;
			formObj.calc_chrge_units_rec.value=arrVal[0];
			//var units=arrVal[0];
			var serv_code=arrVal[1];
            document.forms[0].serv_code.value=serv_code;
			callGetServPanelDtls(units,serv_code,"REC");		
		}
		}
	}
}

function callGetServPanelDtls(units, serv_code,from,i){
	var formObj=document.forms[0];
	var encounter_id=formObj.encounter_id1.value;
	var episode_id=formObj.episode_id.value;
	var episode_type=formObj.episode_type.value;
	var patient_class=formObj.patient_class1.value;
	var visit_id=formObj.visit_id1.value;
	var locale = formObj.locale.value;
	var facility_id=formObj.facility_id.value;
	var oper_num=formObj.oper_num.value;

	//var disabled="<img width=15px   align='texttop'  height='15px' src='../../eCommon/images/disabled.gif'></img>";
	// enabled ="<img width=15px   align='texttop'  height='15px' src='../../eCommon/images/enabled.gif'></img>";

	var module_id="OT";
	var patient_id=formObj.patient_id.value;
	var booking_num=formObj.booking_num.value;
	var order_id=formObj.order_id.value;

	if(from=="REC")
	{ 
		order_id=formObj.recv_bl_accession_num.value;
		var order_line_num="1";
	}
	else if(from=="OR")
	{
		order_id=formObj.or_bl_accession_num.value;
		var order_line_num="1";
	}
	else if(from=="HA")
	{
		holding_seq_num=eval(document.getElementById("holding_seq_num_"+i)).value;
		order_id=eval(document.getElementById("bl_accession_num_"+i)).value;
		order_line_num=holding_seq_num;
		j=i+1;
		//var order_line_num=j;
	}

	//var order_id=eval("document.getElementById("bl_accession_num_")"+i).value;
	var speciality_code=formObj.speciality_code.value;
	//var oper_code=formObj.oper_code.value;
	if(from=="REC")
	{
		var oper_code=formObj.recovery_room_code.value;
	}else if(from=="OR")
	{
		var oper_code=formObj.oper_room_code_or.value;
	}
	else if(from=="HA")
	{
		var oper_code=eval(document.getElementById("holding_area_code_"+i)).value;
	}
	var surgeon_code=formObj.surgeon_code.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "units="+units+"&serv_code="+serv_code+"&locale="+locale+"&facility_id="+facility_id+"&oper_num="+oper_num+"&module_id="+module_id+"&patient_id="+patient_id+"&booking_num="+booking_num+"&order_id="+order_id+"&order_line_num="+order_line_num+"&speciality_code="+speciality_code+"&oper_code="+oper_code+"&surgeon_code="+surgeon_code+"&encounter_id="+encounter_id+"&episode_id="+episode_id+"&episode_type="+episode_type+"&patient_class="+patient_class+"&visit_id="+visit_id;

	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","AdminFunctionChargeUnits.jsp?func_mode=callServPanel&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	var arrVal=retVal.split("$$");

	/*if(from=="REC")
	document.getElementById("cashcounter_desc_rec").innerText=arrVal[2];
	else if(from=="OR")
	document.getElementById("cashcounter_desc_or").innerText=arrVal[2];
	else if(from=="HA")
	eval("document.getElementById("cashcounter_desc_ha_")"+i).innerText=arrVal[2];*/

	//var arrVal=retVal.split("$$");
	//if(from=="REC"){
	var total=arrVal[2];
	var payable=arrVal[4];
	var paid = arrVal[7];
	var include_exclude="";
	var appr_reqd_val="";
	/*if(arrVal[5]=="I"){
		include_exclude=enabled;	
	}else{
		include_exclude=disabled;	
	}*/
	include_exclude=arrVal[5];	
	appr_reqd_val=arrVal[6];

	/*if(arrVal[6]=="Y"){
		appr_reqd_val=enabled;	
	}else{
		appr_reqd_val=disabled;	
	}*/
	if(from=="REC")
	{
		document.getElementById("charge_details_1").style.display='Inline';
		//formObj.include_exclude1.value=include_exclude;
		formObj.appr_reqd_val1.value=appr_reqd_val;
		callBillingWindow_rec1(from,i,"onblur");
	}
	else if(from=="OR")
	{
		document.getElementById("charge_details_or").style.display='Inline';
		//formObj.include_exclude_or.value=include_exclude;
		formObj.appr_reqd_val_or.value=appr_reqd_val;
		callBillingWindow_rec1(from,i,"onblur");
	}
	else if(from=="HA")
	{
		//document.getElementById("charge_details_ha_").style.display='Inline';
		eval(document.getElementById("charge_details_ha_"+i)).style.display='Inline';
		//eval("document.getElementById("include_exclude_ha_")"+i).value=include_exclude;
		eval(document.getElementById("appr_reqd_val_ha_"+i)r).value=appr_reqd_val;
		callBillingWindow_rec1(from,i,"onblur");
	}
		paintBillDetails(total,payable,paid,include_exclude,appr_reqd_val,from,i);
	//}
}

function getServPanelDtls(obj,from,i){
	var formObj=document.forms[0];
	var encounter_id=formObj.encounter_id1.value;
	var episode_id=formObj.episode_id.value;
	var episode_type=formObj.episode_type.value;
	var patient_class=formObj.patient_class1.value;
	var visit_id=formObj.visit_id1.value;
	
	var disabled="<img width=15px   align='texttop' height='15px' src='../../eCommon/images/disabled.gif'></img>";
	var enabled="<img width=15px   align='texttop' height='15px' src='../../eCommon/images/enabled.gif'></img>";
	
	if(from=="REC")
		var serv_code=formObj.serv_code.value;
	else if(from=="OR")
		var serv_code=formObj.serv_code_or.value;
	else if(from=="HA")
		var serv_code=eval("formObj.serv_code_ha_"+i).value;

	if(obj.value>0)
	{
		var locale = formObj.locale.value;
	if(from=="REC")
		var units_modified=formObj.charge_units_rec.value;
	else if(from=="OR")
		var units_modified=formObj.charge_units_or.value;
	else if(from=="HA")
	var units_modified=eval("formObj.charge_units_ha_"+i).value;	
	
	var facility_id=formObj.facility_id.value;
	var oper_num=formObj.oper_num.value;
	var module_id=formObj.module_id.value;
	var patient_id=formObj.patient_id.value;
	var booking_num=formObj.booking_num.value;
	var order_id=formObj.order_id.value;
	var speciality_code=formObj.speciality_code.value;
	var oper_code=formObj.oper_code.value;
	var surgeon_code=formObj.surgeon_code.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "units="+units_modified+"&serv_code="+serv_code+"&locale="+locale+"&facility_id="+facility_id+"&oper_num="+oper_num+"&module_id="+module_id+"&patient_id="+patient_id+"&booking_num="+booking_num+"&order_id="+order_id+"&speciality_code="+speciality_code+"&oper_code="+oper_code+"&surgeon_code="+surgeon_code+"&encounter_id="+encounter_id+"&episode_id="+episode_id+"&episode_type="+episode_type+"&patient_class="+patient_class+"&visit_id="+visit_id;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","AdminFunctionChargeUnits.jsp?func_mode=callServPanel&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	var arrVal=retVal.split("$$");
	var total=arrVal[2];
	var payable=arrVal[4];
	var paid = arrVal[7];
	var include_exclude="";
	var appr_reqd_val="";
	/*if(arrVal[5]=="I"){
		include_exclude=enabled;	
	}else{
		include_exclude=disabled;	
	}
	if(arrVal[6]=="Y"){
		appr_reqd_val=enabled;	
	}else{
		appr_reqd_val=disabled;	
	}*/
	include_exclude=arrVal[5];	
	appr_reqd_val=arrVal[6];

	if(from=="REC"){
		//document.getElementById("cashcounter_desc_rec").innerText=arrVal[2];
		formObj.calc_chrge_units_rec.value="4";
		formObj.modified_charge_units.value=units_modified;
		document.getElementById("charge_details_1").style.display='Inline';
		formObj.include_exclude1.value=include_exclude;
		formObj.appr_reqd_val1.value=appr_reqd_val;
		callBillingWindow_rec1(from,i,"onblur")
		paintBillDetails(total,payable,paid,include_exclude,appr_reqd_val,from,i);
	}else if(from=="OR"){
		//document.getElementById("cashcounter_desc_or").innerText=arrVal[2];
		formObj.modified_charge_units_or.value=units_modified;
		document.getElementById("charge_details_or").style.display='Inline';
		formObj.include_exclude_or.value=include_exclude;
		formObj.appr_reqd_val_or.value=appr_reqd_val;
		callBillingWindow_rec1(from,i,"onblur")
		paintBillDetails(total,payable,paid,include_exclude,appr_reqd_val,from,i);
	} else if(from=="HA")
	{   //eval("document.getElementById("cashcounter_desc_ha_")"+i).innerText=arrVal[2];
			eval("formObj.modified_charge_units_ha_"+i).value=units_modified;
			eval(document.getElementById("charge_details_ha_"+i)).style.display='Inline';
			eval(document.getElementById("include_exclude_ha_"+i)).innerText=include_exclude;
			eval(document.getElementById("appr_reqd_val_ha_"+i)).innerText=appr_reqd_val;
			callBillingWindow_rec1(from,i,"onblur")
			paintBillDetails(total,payable,paid,include_exclude,appr_reqd_val,from,i);
		}		
	}
	else
   {
		var msg = getMessage("APP-OT0068","OT");
		var msgArray = msg.split("#");
		var chargableunits = getLabel("eOT.ChargableUnits.Label","OT");
		
		msg=msgArray[0]+chargableunits+msgArray[1];
		alert(msg)
		obj.select();
   }
}

function callChargeableUnits_or(){
	var formObj=document.forms[0];
	var charge_holding_area_yn=formObj.charge_holding_area_yn.value;
	var charge_operating_room_yn=formObj.charge_operating_room_yn.value;
	var or_chargeable_yn=formObj.or_chargeable_yn.value;
	var bill_flag=formObj.bill_flag.value;
	
	if(trimString(charge_operating_room_yn)=="Y" && trimString(or_chargeable_yn)=="Y" && trimString(bill_flag)=="true")
	{
	var facility_id=formObj.facility_id.value;
	var check_into_or_time=formObj.check_into_or_time.value;
	var check_out_or_time=formObj.check_out_or_time.value;	
	var oper_room_code_or=formObj.oper_room_code_or.value;
    
	if(check_out_or_time!="" && check_into_or_time!=""){
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		var params = "chk_in_dt_time="+check_into_or_time+"&chk_out_dt_time="+check_out_or_time+"&oper_room_code="+oper_room_code_or+"&facility_id="+facility_id;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","AdminFunctionChargeUnits.jsp?func_mode=callORChargeUnits&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		var arrVal=retVal.split("##")
        if(arrVal[2]==null)arrVal[2]="";
        if(arrVal[3]==null)arrVal[3]="";
        if(arrVal[4]==null)arrVal[4]="";
		if(arrVal[2]!="" || arrVal[3]!="" || arrVal[4]!=""){
			if(arrVal[4]=="")
			{
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "func_mode=getErrmsg&msg_id="+arrVal[3];
				xmlHttp.open("GET","../../eOT/jsp/CommonValidation.jsp?"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				alert(retVal)
			}else
			{
				alert(arrVal[4])
			}
		parent.parent.parent.AdministrativeFunctionCompletionStatus.AdministrativeFunctionforAllChargesForm.record.disabled=true;
           
			return;
			
		}else{
				//formObj.charge_units_or.value=arrVal[0];
				//formObj.service_code.value=arrVal[1];
				//formObj.calc_chrge_units.value=arrVal[0];
				//formObj.modified_charge_units_or.value=arrVal[0];
				formObj.modified_charge_units_or.value=formObj.charge_units_or.value;
				//var units=arrVal[0];
				formObj.calc_chrge_units_or.value=arrVal[0];
				var units=formObj.charge_units_or.value;
				var serv_code=arrVal[1];
				document.forms[0].serv_code_or.value=serv_code;
				callGetServPanelDtls(units,serv_code,"OR");		
		}
	}
	}
}

function callChargeableUnits_ha(maxRecord){
	var formObj=document.forms[0];
	var charge_holding_area_yn=formObj.charge_holding_area_yn.value;
	var bill_flag=formObj.bill_flag.value;
	if(trimString(charge_holding_area_yn)=='Y' && trimString(bill_flag)=="true")
	{
		var facility_id=formObj.facility_id.value;
		for(var i=0;i<maxRecord;i++){
		chk_in_ha_date_time=eval("formObj.checked_in_date_time_"+i).value;
        chk_out_ha_date_time=eval("formObj.checked_out_date_time_"+i).value;
        charge_units_ha=eval("formObj.charge_units_ha_"+i).value;
       // bl_accession_num=eval("formObj.bl_accession_num_"+i).value;
       // chargeable_units=eval("formObj.chargeable_units_"+i).value;
        holding_area_code=eval("formObj.holding_area_code_"+i).value;
	 
	 if(chk_in_ha_date_time!="" && chk_out_ha_date_time!=""){
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "chk_in_dt_time="+chk_in_ha_date_time+"&chk_out_dt_time="+chk_out_ha_date_time+"&change_holding_code="+holding_area_code+"&facility_id="+facility_id;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","AdminFunctionChargeUnits.jsp?func_mode=callHAChargeUnits&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		var arrVal=retVal.split("##")
        if(arrVal[2]==null)arrVal[2]="";
        if(arrVal[3]==null)arrVal[3]="";
        if(arrVal[4]==null)arrVal[4]="";
		if(arrVal[2]!="" || arrVal[3]!="" || arrVal[4]!=""){
			if(arrVal[4]=="")
			{
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "func_mode=getErrmsg&msg_id="+arrVal[3];
				xmlHttp.open("GET","../../eOT/jsp/CommonValidation.jsp?"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				alert(retVal)
			}else
			{
				alert(arrVal[4])
			}
		   parent.parent.parent.AdministrativeFunctionCompletionStatus.AdministrativeFunctionforAllChargesForm.record.disabled=true;
			return;
			
		}else{
				 // eval("formObj.charge_units_ha_"+i).value=arrVal[0];
				//formObj.service_code.value=arrVal[1];
				//formObj.calc_chrge_units.value=arrVal[0];
				//formObj.modified_charge_units.value=arrVal[0];

				//var units=arrVal[0];
				var units=eval("formObj.charge_units_ha_"+i).value;
				var serv_code=arrVal[1];
				eval("formObj.modified_charge_units_ha_"+i).value=eval("formObj.charge_units_ha_"+i).value;
				eval("formObj.serv_code_ha_"+i).value=serv_code;
				callGetServPanelDtls(units,serv_code,"HA",i);		
		}
	}
	}
	}
}

async function searchInstrument(obj,target){
	var frmObj	=document.forms[0];//Added by lakshmi against CRF-0058
	var code_name = obj.name;
	var desc_name = target.name;
	var tcode = obj.value;
	var tdesc = target.value;
	var sql='';
	var retVal =  new String();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	//var tit="Search Instrument";
	var tit=getLabel("Common.Instrument.label","Common");
	var locale = document.forms[0].locale.value;
	//var sql="SELECT SHORT_DESC description, INSTR_CODE code FROM OT_INSTRUMENT WHERE NVL(STATUS,'E') = 'E' and upper(SHORT_DESC) like upper(?) and upper(INSTR_CODE) like upper(?) order by 2";
	//Code Altered by rajesh for PHASE 3.
	//var sql="SELECT SHORT_DESC description, INSTR_CODE code FROM OT_INSTRUMENT_LANG_VW WHERE NVL(STATUS,'E') = 'E' and upper(SHORT_DESC) like upper(?) and upper(INSTR_CODE) like upper(?) AND LANGUAGE_ID='"+locale+"'  order by 2";

	//Modified by lakshmi against CRF-0058 starts here
	if(frmObj.Ot_param.value=="Y"){
	//Added by Rajesh for CRF-0058 to enable search tro OTGeneralSearch
		var dialogTop  = "40";
		var dialogHeight = "10";
		var dialogWidth  = "50";
		var arguments = "";
		var desc=target.value;
		if(desc=="%") desc="*All";
		if(desc=="&") desc="~";
		var column_sizes = escape("40%,30%,30%");  
		var tit = getLabel('Common.description.label','Common')+','+getLabel('Common.code.label','Common')+','+getLabel('Common.Location.label','Common');
		var column_descriptions=encodeURIComponent(tit);
		var sql_temp ="SELECT LONG_DESC DESCRIPTION, INSTR_CODE CODE,DECODE(LOCATION,NULL,'',LOCATION) LOCATION FROM OT_INSTRUMENT_LANG_VW WHERE NVL(STATUS,'E') = 'E'  AND LANGUAGE_ID='"+locale+"' "; 	
		var sql=escape(sql_temp);
		var title=getLabel("Common.Instrument.label","common");
		title=encodeURIComponent(title);
		var features  = "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&search_criteria="+desc;
		retVal=window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);
		if(retVal != null && retVal != "" ){
			var arr_loc = retVal.split("::");
			target.value=arr_loc[0];
			if(target.name == desc_name){
				obj.value = arr_loc[1];
				if(arr_loc[2].length>0){
					frmObj.tray_no.value =arr_loc[2];
				}
				else{
					arr_loc[2]='';//
					frmObj.tray_no.value =arr_loc[2];//
				}
			}			
		}else{
				target.value="";
				obj.value="";
				frmObj.tray_no.value ="";
		}
	//Added by Rajesh for CRF-0058 to enable search tro OTGeneralSearch	
	}
	else{
		var sql="SELECT LONG_DESC DESCRIPTION, INSTR_CODE CODE FROM OT_INSTRUMENT_LANG_VW WHERE NVL(STATUS,'E') = 'E' AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(INSTR_CODE) LIKE UPPER(?) AND LANGUAGE_ID='"+locale+"'  ORDER BY 2";

		argumentArray[0] =sql;

		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "2,1";
		argumentArray[5] = target.value;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;

		retVal = await CommonLookup( tit, argumentArray );
		if(retVal != null && retVal != "" ){
			var ret1=unescape(retVal);
			arr=ret1.split(",");
			target.value=arr[1];
		if(target.name == desc_name){
			obj.value = arr[0];
			document.forms[0].target.disabled=true;
		}
		}else{
			target.value="";
			obj.value="";		
		}
		}
}	
//Modified by lakshmi against CRF-0058 ends here

function addRow_ic(){
  var objrow = newRow ();
  var msg = trimString(getMessage("CODE_ALREADY_EXISTS","Common"));
  var rows=parent.parent.parent.AdminObjectCollect.instrument_rows;
  var formObj = document.forms[0];
  
  var params = formObj.params.value;
  var mode =formObj.mode.value;
  var obj = formObj.operation_ic;
  operation_ic=formObj.operation_ic.value;
  operation_ic=operation_ic.split("##");
  var bill_flag=document.forms[0].bill_flag.value;  
 //Modified by DhanasekarV   against the issue IN024474
  parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';

  if(chkEmpty_ic()){
	if(mode=='I'){
	   if(alreadyExist_ic()){
		if(bill_flag=="true") // added by satihsh on 10-01-2009to diable billing part when interfaceto Patient billing check box unchecked 
		{
		var retVal = callOrderLineCreation_ic();
		retVal=trimString(retVal);
		var arr = retVal.split("@@");
		if(arr[0]=="BL0639"){
			alert(getMessage("BL0639","BL"));
			return false;
		 }
		 if(localTrimString(arr[2])!='')
			{
			var err_pat=localTrimString(arr[2]);
			alert(err_pat);
			return false;
			}
		 }
		var key = formObj.oper_num.value+"@"+operation_ic[0]+"@S"+"@"+formObj.instr_code.value;
		
		objrow.oper_code=operation_ic[0];
		//objrow.oper_desc=escape(formObj.operation.options[obj.selectedIndex].text);
		objrow.oper_desc=formObj.operation_ic.options[obj.selectedIndex].text;
		objrow.instr_code=formObj.instr_code.value;
		//objrow.instr_desc=escape(formObj.instr_desc.value);
		objrow.instr_desc=formObj.instr_desc.value;
		objrow.oper_line_no = formObj.oper_line_no.value;
		objrow.tray_no = formObj.tray_no.value;
		objrow.remarks = formObj.remarks_ic.value;
		objrow.quantity = formObj.quantity_ic.value;
		objrow.recId = getRecId_inst();
		objrow.db_mode="I";
        if(bill_flag=="true")
		{
			var arr = retVal.split("@@");
			objrow.panel_str = arr[0];
			var temp_bill=arr[1].split("::");
			arr[1]=arr[1]+"::"+""+"::"+temp_bill[4];
			objrow.bill_str = arr[1];
		}
			objrow.key=key;
			objrow.key_line="";
			rows.push(objrow);
			//rows.push(encodeURIComponent(objrow));
			resetFields_ic();
	} else{
		parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
	}
	//Added by lakshmi against RUT-CRF-0058
	if(formObj.Ot_param.value=="Y"){
		createTable_ic1();
	}
	else{
		createTable_ic();
	}
		}else
		  updateRow_ic();
	  }  
}

function newRow_ic(){
	var objrow = new Class_row_ic();
	return(objrow);
}

function Class_row_ic(){
  this.oper_code ="";
  this.oper_desc="";
  this.instr_code="";
  this.instr_desc="";
  this.oper_line_no ="";
  this.tray_no ="";
  this.remarks_ic ="";
  this.accessory_type="";
  this.db_mode="";
  this.recId="";
  this.order="";
  this.key="";
  this.key_line="";
  this.panel_str="";
  this.bill_str="";
  this.rate="";
}

function chkEmpty_ic(){
	var formObj = document.forms[0];
	var operation	=getLabel("Common.operation.label","Common");
	var instrument	=getLabel("Common.Instrument.label","Common");
	var no_of_units	=getLabel("eOT.ActualUnits.Label","OT");

	var fields = new Array(formObj.operation_ic,formObj.instr_desc,formObj.quantity_ic);
	var names = new Array(operation,instrument,no_of_units);
	var messageFrame = parent.parent.parent.parent.messageFrame;
	if(checkFields( fields, names, messageFrame))
		return true;
}

function alreadyExist_ic(){	
	var formObj = document.forms[0];
	var codeDtl =parent.parent.parent.parent.AdministrativeFucntionFrame.code_ic; 
	var oper_code=formObj.oper_code.value;
	var instr_code = formObj.instr_code.value;
	var codeRecord = oper_code+instr_code;
	if(codeDtl.indexOf(codeRecord)>=0)
	   return false;
	else
	  return true;
}

function resetFields_ic(){
	var formObj = document.forms[0];
	//formObj.operation.value=formObj.operation.value;
	formObj.instr_code.value='';
	formObj.instr_desc.value='';
	formObj.oper_line_no.value='';
	formObj.oper_code.value='';
	formObj.tray_no.value='';
	formObj.remarks_ic.value='';
	formObj.quantity_ic.value='';
	formObj.mode.value='I';
	formObj.operation_ic.disabled=false;
	formObj.InstrumentLookUp.disabled=false;
	formObj.instr_desc.disabled=false;
    formObj.operation_ic.focus();		
}

function assignCodes_ic(obj){
	var formObj = document.forms[0];
	var codes =  obj.value;
    var arr = codes.split("##");
	formObj.oper_code.value=arr[0];
	formObj.oper_line_no.value=arr[1];
}

function checkLimit(field, limit){
  if (field.value.length > limit){
		   //var msg = getMessage("REMARKS_CANNOT_EXCEED");
		   var msg = getMessage("MAX_LENGTH_DATA","OT");
		   var msgArray = msg.split("#");
		   alert(msgArray[0]+""+msgArray[1]+limit+msgArray[2]);
		   // Truncate at the limit
		   var revertField = field.value.slice(0, limit);
		   field.value = revertField;
		   field.focus();
	  }
}

function openDialogWindow_ic(strVal,index){
	var rows = parent.parent.parent.AdminObjectCollect.instrument_rows[index];
	var remarks=encodeURIComponent(rows.remarks); 
	var size='100';
	window.showModalDialog('../../eOT/jsp/TextArea.jsp?heading='+encodeURIComponent(strVal)+'&remarks='+remarks+'&size='+size,window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
}

function callAdditionalCharges()
{	
    var formObj=document.forms[0];
    var param="";
	var center='1';
	var dialogTop = "70";
	var dialogHeight = "42" ;
	var dialogWidth = "70" ;
	var retVal="";
	var patient_id=trimString(formObj.patient_id.value);
	var encounter_id=trimString(formObj.encounter_id1.value);
	var episode_id=trimString(formObj.episode_id.value);
	var visit_id=trimString(formObj.visit_id1.value);
	var episode_type=trimString(formObj.episode_type.value);
	var surgeon_code=trimString(formObj.surgeon_code.value);
	var ref_source_code=trimString(formObj.ref_source_code.value);
	var oper_num=trimString(formObj.oper_num.value);
	var order_id1=trimString(formObj.order_id1.value);
	var sec_key_main_oper_num=oper_num;
	var sec_key_main_order_id=order_id1;
	var str_order_catalog_code=trimString(formObj.str_order_catalog_code.value);
	var role_pract_id="";
	
	var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;  
	var arguments = "" ;
	var param="patient_id="+patient_id+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id+"&encounter_id="+encounter_id+"&pract_id="+surgeon_code+"&locn_code="+ref_source_code+"&sec_key_main_oper_num="+sec_key_main_oper_num+"&sec_key_main_order_id="+sec_key_main_order_id+"&str_order_catalog_code="+str_order_catalog_code+"&role_pract_id="+role_pract_id+"&function_id=VIEW";
	window.showModalDialog("../../eBL/jsp/BLSurgeryAddlChargeFrame.jsp?"+param,arguments,features);
}

function searchEquipments(obj,target){
	var code_name = obj.name;
	var desc_name = target.name;
	var tcode = obj.value;	
	var customer_id =document.forms[0].customer_id1.value;
	var tdesc = target.value;
	var sql='';
	var retVal =  new String();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var locale = document.forms[0].locale.value;
	var tit=getLabel("eOT.Equipments.Label","OT");

	var sql="SELECT LONG_DESC description, EQUIPMENT_CODE code FROM OT_EQUIPMENT_LANG_VW where LANGUAGE_ID ='"+locale+"'  AND NVL(STATUS,'E') = 'E' and upper(LONG_DESC) like upper(?) and upper(EQUIPMENT_CODE) like upper(?) order by 2";
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		if(target.name == desc_name){
			obj.value = arr[0];
			document.forms[0].equip_id.value = arr[0];
			document.forms[0].equip_id.disabled = true; 
			document.forms[0].target.disabled=true;
		}
	}else{
		target.value="";
		obj.value="";
	}
	//Added newly 29-05-2013 - 091
	if(customer_id =="RTN"){	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=call_eq_code&equip_code="+obj.value,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);	
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].st_location.value = arr[0];
		document.forms[0].st_location.disabled=true;  
		document.forms[0].target.disabled=true;
	}
	else {
		document.forms[0].st_location.value="";
		document.forms[0].target.disabled=true;
	}
	}
	//Added newly 29-05-2013 -091
}
function addRow_eq()
{
  var objrow = newRow_eq();
	var customer_id = document.forms[0].customer_id1.value;
	var msg = trimString(getMessage("CODE_ALREADY_EXISTS","Common"));
	var rows=parent.parent.parent.AdminObjectCollect.equipment_rows;
	var formObj = document.forms[0];
	var customer_id = formObj.customer_id1.value;
	var mode =formObj.mode.value;
	var obj = formObj.operation_eq;
	var bill_flag=document.forms[0].bill_flag.value;
	var chkDateRangeValidityFlag = true;
	var key = formObj.oper_num.value+"@"+formObj.oper_code.value+"@E"+"@"+formObj.equip_code.value;
		chkDateRangeValidityFlag = chkDateRangeValidity(formObj.desiredDate.value);

	//Modified by DhanasekarV
	parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';

	if(chkEmpty_eq()){
	if(chkDateRangeValidityFlag)
	{
	if(mode=='I'){
		if(alreadyExist_eq()){
			if(bill_flag=="true")  // added by sathish to disable Billing part
		{			 
			var retVal =callOrderLineCreation_eq();
			retVal=trimString(retVal);
			var arr = retVal.split("@@");
		
		if(arr[0]=="BL0639"){			
			alert(getMessage("BL0639","BL"));
			return false;
		}
		if(localTrimString(arr[2])!='')
			{			
				var err_pat=localTrimString(arr[2]);
				alert(err_pat);
				return false;
			}
		}
			objrow.oper_code=formObj.oper_code.value;
			objrow.oper_desc=formObj.operation_eq.options[obj.selectedIndex].title;//MMS-QH-CRF-0199
			objrow.equip_code=formObj.equip_code.value;
			objrow.equip_desc=formObj.equip_desc.value;
			objrow.oper_line_no = formObj.oper_line_no.value;
			objrow.equip_id = formObj.equip_id.value;
			objrow.quantity = formObj.quantity_eq.value;
			objrow.remarks =  formObj.remarks_eq.value;
			objrow.desiredDate = formObj.desiredDate.value;
			if (customer_id == "RTN")
				objrow.st_location = formObj.st_location.value;
			//ADDED FOR BILLING
			/*var retVal = callOrderLineCreation();
			var arr = retval.split("@@");
			panel_str = arr[0];
			bill_str = arr[1];*/
			objrow.recId = getRecId_eq();
			objrow.db_mode="I";
			//var retVal = callOrderLineCreation();
			if(bill_flag=="true")
			{
				var arr = retVal.split("@@");
				objrow.panel_str = arr[0];
				var temp_bill=arr[1].split("::");
				arr[1]=arr[1]+"::"+""+"::"+temp_bill[4];
				objrow.bill_str = arr[1];
			}
				objrow.key=key;
				objrow.key_line="";
				rows.push(objrow);
				resetFields_eq();
	} else{
		parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
	}
	//Added by lakshmi against RUT-CRF-0058
	if(formObj.Ot_param.value=="Y"){
		createTable_eq1();
	}
	else{
		createTable_eq();
	}
	}else
		updateRow_eq();
	}
	}
}

function newRow_eq(){
	var objrow = new Class_row_eq();
	return(objrow);
}
function Class_row_eq()
{
  this.oper_code ="";
  this.oper_desc="";
  this.equip_code="";
  this.equip_desc="";
  this.oper_line_no ="";
  this.equip_id ="";
  this.remarks ="";
  this.order="";
  this.accessory_type="";
  this.db_mode="";
  this.recId="";
  this.bill_str="";
  this.panel_str="";
  this.key="";
  this.key_line="";
  this.rate="";
  this.desiredDate="";
}
function chkEmpty_eq(){
	var formObj = document.forms[0];
	var operation =getLabel("Common.operation.label","Common");
	var equipment	=getLabel("Common.equipment.label","Common");
	var no_of_units		=getLabel("eOT.ActualUnits.Label","OT");
	var desiredDate =getLabel("eOT.DateTime.label","OT");	// 047546
	var customer_id = document.forms[0].customer_id1.value;
	var fields = new Array(formObj.operation_eq, formObj.equip_desc, formObj.quantity_eq, formObj.desiredDate);
	var names = new Array(operation, equipment, no_of_units, desiredDate);
	var messageFrame = parent.parent.parent.parent.messageFrame;
	if(checkFieldsOt( fields, names, messageFrame))
		return true;
}

function alreadyExist_eq(){
	var formObj = document.forms[0];
	var codeDtl = parent.parent.parent.parent.AdministrativeFucntionFrame.code_eq; 
	var oper_code=formObj.oper_code.value;
	var equip_code = formObj.equip_code.value;
	var codeRecord = oper_code+equip_code;
	if(codeDtl.indexOf(codeRecord)>=0)
	   return false;
	else
	  return true;
}

function resetFields_eq(){
	var formObj = document.forms[0];
	//formObj.operation.value=formObj.operation.value;
	var customer_id = formObj.customer_id1.value;
	formObj.equip_code.value='';
	formObj.equip_desc.value='';
	formObj.oper_code.value='';
	formObj.equip_id.value='';
	formObj.remarks_eq.value='';
	formObj.mode.value='I';
	formObj.operation_eq.disabled=false;
	formObj.EquipmentLookUp.disabled=false;
	formObj.equip_desc.disabled=false;
    formObj.operation_eq.focus();
	formObj.quantity_eq.value='';
	if (customer_id =="RTN")
	{
		formObj.st_location.value='';
	}	
}

function assignCodes_eq(obj){
	var formObj=document.forms[0];
	var codes =  obj.value;
    var arr = codes.split("##");
	formObj.oper_code.value=arr[0];
	formObj.oper_line_no.value=arr[1];
}

function openDialogWindow_eq(strVal,index){
  var rows = parent.parent.parent.AdminObjectCollect.equipment_rows[index];
  var remarks=encodeURIComponent(rows.remarks); 
  var size='100'; window.showModalDialog('../../eOT/jsp/TextArea.jsp?heading='+encodeURIComponent(strVal)+'&remarks='+remarks+'&size='+size,window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
}

function callOrderLineCreation_ic(){
	var formObj = document.forms[0];
	var oper_num = formObj.oper_num.value;
	var instr_code = formObj.instr_code.value;
	var quantity = formObj.quantity_ic.value;
	var oper_code = (formObj.operation_ic.value).split("##")[0];
	var param = "oper_num="+oper_num+"&acc_type=S&called_from=ACC_TAB&acc_code="+instr_code+"&oper_code="+oper_code+"&quantity="+quantity;
	var xmlStr ="<root></root>";
	var temp_jsp="OTOrderLineCreation.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	return responseText;
}

function sendparams_ic(index){
	//var rows = parent.parent.ObjectCollect.instrument_rows[index];
	var rows = parent.parent.parent.AdminObjectCollect.instrument_rows[index];
	var oper_code=rows.oper_code;
	var oper_desc=rows.oper_code+"##"+rows.oper_line_no;
	var line_no = rows.oper_line_no;
	var instr_code= rows.instr_code;
	var instr_desc = rows.instr_desc;
    var tray_no=rows.tray_no;
	var remarks=rows.remarks;
	var quantity=rows.quantity;
	var recId = rows.recId;
	var mode = "U";
	var str = oper_code+'::'+oper_desc+'::'+line_no+'::'+instr_code+'::'+instr_desc+'::'+remarks+'::'+tray_no+'::'+recId+'::'+mode+'::'+quantity;
	//var frmObj = parent.parent.RecordFrame.RecordFrame;
	splitString_ic(str);
}

function splitString_ic(strVal){
    var arr = strVal.split('::');
	var formObj = document.forms[0];
	formObj.oper_code.value=arr[0];
	formObj.operation_ic.value=arr[1];
	formObj.oper_line_no.value = arr[2];
	formObj.instr_code.value=arr[3];
	formObj.instr_desc.value=arr[4];
	formObj.remarks_ic.value=arr[5];
	formObj.tray_no.value=arr[6];
	formObj.recId.value = arr[7];
	formObj.mode.value = arr[8];
	formObj.quantity_ic.value = arr[9];
	formObj.operation_ic.disabled=true;
	formObj.InstrumentLookUp.disabled=true;
	formObj.instr_desc.disabled=true;
}

function removeRow_ic(){

var formObj = document.forms[0];
var rows=parent.parent.parent.AdminObjectCollect.instrument_rows;
var recId = document.forms[0].recId.value;
var mode = document.forms[0].mode.value;
if(rows.length>0 && mode=='U' ){        
  for(var jj=0;jj<rows.length;jj++){
	 if(rows[jj]!=null){
		if(rows[jj].recId==recId){
			DeleteKey(rows[jj].key+rows[jj].key_line);
			if( (rows[jj].db_mode=='L' || rows[jj].db_mode=='U') && (rows[jj].order=='1' ) )
				rows[jj].db_mode='D';
			 else
			  delete rows[jj];
			   break;
		}
	 }else
	continue;
 }//end for-Loop
 resetFields_ic();
  parent.parent.parent.parent.AdministrativeFucntionFrame.code_ic=new String();
   //abv line is for removing oper_code,implant_code combination from code_ic i.e refreshing that String field
   	  //Added by Rajesh for CRF-0057 
	  if(formObj.Ot_param.value=="Y"){
		createTable_ic1();
	  }
	  else{
		createTable_ic();
	  }
	  //Added by Rajesh for CRF-0057 
}else
   resetFields_ic();
}

function sendparams_eq(index){
	var rows = parent.parent.parent.AdminObjectCollect.equipment_rows[index];
	var customer_id =document.forms[0].customer_id1.value;
	var oper_code=rows.oper_code;
	var oper_desc=rows.oper_code+"##"+rows.oper_line_no;
	var line_no = rows.oper_line_no;
	var instr_code= rows.equip_code;
	var instr_desc = rows.equip_desc;
    var tray_no=rows.equip_id;
	var remarks=rows.remarks;
	var recId = rows.recId;
	 var quantity=rows.quantity;
	 var location_no=rows.st_location;
	 var desiredDate = '';
    	desiredDate = rows.desiredDate;
	var mode = "U";
	if (customer_id == "RTN")
		var str = oper_code+'::'+oper_desc+'::'+line_no+'::'+instr_code+'::'+instr_desc+'::'+remarks+'::'+tray_no+'::'+recId+'::'+mode+'::'+quantity+'::'+location_no+'::'+desiredDate;
	else
		var str = oper_code+'::'+oper_desc+'::'+line_no+'::'+instr_code+'::'+instr_desc+'::'+remarks+'::'+tray_no+'::'+recId+'::'+mode+'::'+quantity+'::'+desiredDate;
	splitString_eq(str);
}

function splitString_eq(strVal)
{
    var arr = strVal.split('::');
	var formObj = document.forms[0];
	var customer_id =formObj.customer_id1.value;
	formObj.oper_code.value=arr[0];
	formObj.operation_eq.value=arr[1];
	formObj.oper_line_no.value = arr[2];
	formObj.equip_code.value=arr[3];
	formObj.equip_desc.value=arr[4];
	formObj.remarks_eq.value=arr[5];
	formObj.equip_id.value=arr[6];	
	formObj.recId.value = arr[7];
	formObj.mode.value = arr[8];
	formObj.quantity_eq.value = arr[9];
	if(customer_id == "RTN")
	{
	formObj.st_location.value = arr[10];	
	formObj.st_location.disabled=true;//CRF - 091
	if(formObj.st_location.value == "undefined")
	{
		formObj.st_location.value='';
		formObj.st_locationdisabled=true;//CRF - 091
	}
		if(formObj.desiredDate.value == "undefined")
			formObj.desiredDate.value='';
		else
			formObj.desiredDate.value = arr[11];
	}
	else
	{
		if(formObj.desiredDate.value == "undefined")
			formObj.desiredDate.value='';
		else
			formObj.desiredDate.value = arr[10];
	}
	formObj.operation_eq.disabled=true;
	formObj.EquipmentLookUp.disabled=true;	
	formObj.equip_desc.disabled=true;
	//formObj.equip_id.disabled=true;//Added for Common Equipment Issue
}
function removeRow_eq(){

var formObj = document.forms[0];
var rows=parent.parent.parent.AdminObjectCollect.equipment_rows;
var recId = document.forms[0].recId.value;
var mode = document.forms[0].mode.value;
if(rows.length>0 && mode=='U'){        
  for(var jj=0;jj<rows.length;jj++){
	 if(rows[jj]!=null){
		if(rows[jj].recId==recId){
			DeleteKey(rows[jj].key+rows[jj].key_line);
			if( (rows[jj].db_mode=='L' || rows[jj].db_mode=='U') && (rows[jj].order=='1' ) )
			 {rows[jj].db_mode='D';}
			 else
			  delete rows[jj];
			   break;
		}
	 }else
	continue;
 }//end for-Loop
 resetFields_eq();
 parent.parent.parent.parent.AdministrativeFucntionFrame.code_eq=new String();
   //abv line is for removing oper_code,implant_code combination from code_eq i.e refreshing that String field
 	  //Added by Rajesh for CRF-0057 
	  if(formObj.Ot_param.value=="Y"){
		createTable_eq1();
	  }
	  else{
		createTable_eq();
	  }
	  //Added by Rajesh for CRF-0057 
}else
   resetFields_eq();
}

function updateRow_eq(){	
	var formObj = document.forms[0];
	var	equip_code=formObj.equip_code.value;
	var	equip_desc=formObj.equip_desc.value;
	var	equip_id = formObj.equip_id.value;
	var	remarks = formObj.remarks_eq.value;
	var	quantity = formObj.quantity_eq.value;
	var	operation_eq = formObj.operation_eq.value;
	operation_eq=operation_eq.split("##");
	var bill_flag=document.forms[0].bill_flag.value;
	var mode =formObj.mode.value;
	var recId = formObj.recId.value;
	var desiredDate = '';
	if(formObj.desiredDate != null)
		desiredDate = formObj.desiredDate.value;
	var rows=parent.parent.parent.AdminObjectCollect.equipment_rows;
		if(rows.length>0 && mode=='U'){        
			for(var jj=0;jj<rows.length;jj++){
				if(rows[jj]!=null) {
					if(rows[jj].recId==recId){
						//rows[jj].equip_code=equip_code;
						//rows[jj].equip_desc=equip_desc;	
						var new_bill_str = "";
						var new_panel_str = "";
						if(mode=="U" && bill_flag=="true"){
							// call UpdateBillingDetailsValidation
							
							var result = updateBillingDetailsValidation(rows[jj].key,rows[jj].key_line,quantity,equip_code,"E",operation_eq[0]);
							
							var result_arr = result.split("OTMS_SEP");
							new_bill_str = result_arr[0];
							new_panel_str = result_arr[1];
						}
			            rows[jj].equip_id=equip_id;
						rows[jj].remarks=remarks;
						rows[jj].quantity=quantity;
						rows[jj].desiredDate=desiredDate;
			           if(rows[jj].db_mode=='L' && rows[jj].order=='1'){
							rows[jj].db_mode='U';
						}else if(rows[jj].db_mode=='L' && rows[jj].order=='2'){
							rows[jj].db_mode='I';
						}else if(rows[jj].db_mode=='L' && rows[jj].order=='3'){
							rows[jj].db_mode='I';
						}
					    if(bill_flag=="true")
						{
						rows[jj].panel_str = new_panel_str;
						rows[jj].bill_str = new_bill_str;
						}
						break;
							
					}
		         }else  
			continue;
		 }
      resetFields_eq();
	  //Added by Rajesh for CRF-0057 
	  if(formObj.Ot_param.value=="Y"){
		createTable_eq1();
	  }
	  else{
		createTable_eq();
	  }
	  //Added by Rajesh for CRF-0057 
	}
}

function updateRow_ic(){
	var formObj = document.forms[0];	
	var	instr_code=formObj.instr_code.value;
	var	bill_flag=formObj.bill_flag.value;
	var	instr_desc=formObj.instr_desc.value;
	var	tray_no = formObj.tray_no.value;
	var	remarks = formObj.remarks_ic.value;
	var oper_line_no = formObj.oper_line_no.value;
	var quantity = formObj.quantity_ic.value;
	var operation_ic = formObj.operation_ic.value;
	operation_ic=operation_ic.split("##");
	var mode =formObj.mode.value;
	var recId = formObj.recId.value;
	var new_bill_str="";
	var new_panel_str="";
	
	var rows=parent.parent.parent.AdminObjectCollect.instrument_rows;
		if(rows.length>0 && mode=='U'){        
			for(var jj=0;jj<rows.length;jj++){
				if(rows[jj]!=null) {
					if(rows[jj].recId==recId){
						if(mode=="U" && bill_flag=="true"){
							var result = updateBillingDetailsValidation(rows[jj].key,rows[jj].key_line,quantity,instr_code,"S",operation_ic[0]);
							var result_arr = result.split("OTMS_SEP");
							new_bill_str = result_arr[0];
							new_panel_str = result_arr[1];
						}
						rows[jj].quantity=quantity;
						rows[jj].tray_no=tray_no;
						rows[jj].remarks=remarks;
						if(rows[jj].db_mode=='L' && rows[jj].order=='1'){
							rows[jj].db_mode='U';
						}else if(rows[jj].db_mode=='L' && (rows[jj].order=='2' || rows[jj].order=='3' ) ){
							rows[jj].db_mode='I';
						}
						   if(bill_flag=="true")
						{
							
						rows[jj].panel_str = new_panel_str;
						rows[jj].bill_str = new_bill_str;
						}
						break;
      				}
		         }else  
			continue;
		 }
      resetFields_ic();
	  //Added by Rajesh for CRF-0057 
	  if(formObj.Ot_param.value=="Y"){
		createTable_ic1();
	  }
	  else{
		createTable_ic();
	  }
	  //Added by Rajesh for CRF-0057 
}
}

function updateBillingDetailsValidation(key,key_line,p_qty,acc_code,acc_type,oper_code){
	var formObj = document.forms[0];
	//var oper_code = formObj.oper_code.value;
	var locale = formObj.locale.value;
	var oper_num = formObj.oper_num.value;
	
	var order_id = "";
	var order_line_num = "";
	//var key_line = "";
	var param = "order_id="+order_id+"&order_line_num="+order_line_num+"&oper_code="+oper_code+"&key="+key+"&key_line="+key_line+"&locale="+locale+"&p_qty="+p_qty+"&oper_num="+oper_num+"&oper_code="+oper_code+"&acc_code="+acc_code+"&acc_type="+acc_type;
	var xmlStr ="<root></root>";
	var temp_jsp="UpdateBillingDetailsValidation.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	return responseText;
}

function loadDBRows_ic(oper_code,oper_desc,line_no,instr_code,instr_desc,tray_no,remarks,index,oper_num,mode,order,bill_str,panel_str,key,key_line,quantity){
  var rows=parent.parent.parent.AdminObjectCollect.instrument_rows;
  var rowLength=parent.parent.parent.AdminObjectCollect.instrument_len;

   if(mode=='L' && rowLength==0){
	
	  var objrow = newRow();
	  objrow.oper_code=oper_code;
	  objrow.oper_desc=decodeURIComponent(oper_desc,"UTF-8").replace(/\+/g," ");
	  objrow.instr_code=instr_code;
	  objrow.instr_desc=decodeURIComponent(instr_desc,"UTF-8").replace(/\+/g," ");
	  objrow.oper_line_no=line_no;
	  objrow.tray_no=tray_no;
	  //objrow.Location=tray_no;
	  //objrow.remarks=remarks;Anitha
  	  objrow.remarks=decodeURIComponent(remarks,"UTF-8").replace(/\+/g," ");
	  objrow.recId = index;
	  objrow.db_mode=(order==1)?"L":"I";
	  objrow.order=order;
	  objrow.bill_str=bill_str;
	  objrow.panel_str=panel_str;
	  objrow.key=key;
	  objrow.key_line=key_line;
	  objrow.quantity=quantity;
	  objrow.rate="";
	  rows.push(objrow);
	}
}

function assignRecId_ic(){
	var rows = parent.parent.parent.AdminObjectCollect.instrument_rows;
	parent.parent.parent.parent.AdminObjectCollect.instrument_len=rows.length;	
}

function Class_row_eq()
   {
  this.oper_code ="";
  this.oper_desc="";
  this.equip_code="";
  this.equip_desc="";
  this.oper_line_no ="";
  this.equip_id ="";
  this.remarks ="";
  this.order="";
  this.accessory_type="";
  this.db_mode="";
  this.recId="";
  this.bill_str="";
  this.panel_str="";
  this.key="";
  this.key_line="";
  this.rate="";
 }

function newRow(){
  var objrow = new Class_row_eq();
   return(objrow);
}

function validateCheckBox_rec()
{
	var formObj=document.forms[0];
    var charge_units_rec=formObj.charge_units_rec.value;
    var doc_compl_rec=formObj.doc_compl_rec;
    var trfr_ward_code=formObj.trfr_ward_code.value;
	
    trfr_ward_code=trimString(trfr_ward_code)
	 if(trfr_ward_code=='')
	{  
        doc_compl_rec.checked=false;
	    doc_compl_rec.value="N";
		var msg = trimString(getMessage("APP-OT0137","OT"));
		alert(msg)
	}
	
	else if(charge_units_rec=='' )
	{   
		doc_compl_rec.checked=false;
	    doc_compl_rec.value="N";

		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		var chargableunits = getLabel("eOT.ChargableUnits.Label","OT");
		msg=msgArray[0]+chargableunits+msgArray[1];
		alert(msg);
	}	

	if(doc_compl_rec.checked)
    {
		doc_compl_rec.value="Y";
	}
	else
	{
    doc_compl_rec.value="N";
	}
}

function validateCheckBox_ha()
{
	var formObj=document.forms[0];
   // var charge_units_ha=formObj.charge_units_ha.value;
    var doc_compl_ha=formObj.doc_compl_ha;
	if(doc_compl_ha.checked)
    {
		doc_compl_ha.value="Y";
	}
	else
	{
		doc_compl_ha.value="N";
	}
}

function validateCheckBox_or()
{
	var formObj=document.forms[0];
    var charge_units_or=formObj.charge_units_or.value;
    var doc_compl_or=formObj.doc_compl_or;
	if(charge_units_or=='')
	{   
	doc_compl_or.checked=false;
	doc_compl_or.value="N";
	var msg = getMessage("CANNOT_BE_BLANK","OT");
	var msgArray = msg.split("&");
	var chargableunits = getLabel("eOT.ChargableUnits.Label","OT");
	msg=msgArray[0]+chargableunits+msgArray[1];
	alert(msg);
	}
	if(doc_compl_or.checked)
    {
    doc_compl_or.value="Y";
	}
	else
	{
    doc_compl_or.value="N";
	}

}

function validateCheckBox_op(obj)
{
	
	var formObj=document.forms[0];
   // var oper_compl_yn=formObj.oper_compl_yn.value;
	if(obj.checked)
    {
    obj.value="Y";
	}
	else
	{
    obj.value="N";
	}
}

function loadAccChkflag()
{
var formObj=parent.AdministrativeFucntionFrame;
}
function holdingChargebleyn()
{   
	var formObj=document.forms[0];
	var facility_id=formObj.facility_id.value;
	var oper_num=formObj.oper_num.value;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open("POST","CommonValidation.jsp?func_mode=holdingChargebleyn&facility_id="+facility_id+"&oper_num="+oper_num,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText); 
}

async function callOTSalesWindow_admin() {
	var formObj =document.forms[0];
    var oper_num=formObj.oper_num.value;
    var patient_id=formObj.patient_id.value;
    var patient_class=formObj.patient_class1.value;
    var encounter_id=formObj.encounter_id1.value;
    var p_ord_practitioner_id=formObj.p_ord_practitioner_id.value;
   // var slate_user_id=formObj.slate_user_id.value;

    var facility_id=formObj.facility_id.value;
	var facility_opernum=facility_id+'@'+oper_num;
	var store_code="";

	//Modified by DhanasekarV against issueIN026316 on 8/02/2011
	var user_id = formObj.slate_user_id.value;
		user_id = user_id.toUpperCase();

	var sal_trn_type = "I";
	if (patient_class == "IP") {
		sal_trn_type = "I";
	}
	if (patient_class == "OP") {
		sal_trn_type = "O";
	}
	if (patient_class == "EM") {
		sal_trn_type = "E";
	}
	if (patient_class == "DC") {
		sal_trn_type = "D";
	}

	
	var retVal = "";
	var dialogHeight = "40";
	var dialogWidth = "65";
	var dialogTop = "200";
	var center = "1";
	var status = "no";
	var tit=encodeURIComponent(getLabel("eOT.ConsumablesUsed.Label","OT"));
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: yes " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+";title:"+tit;
	var arguments = "";

	var url = "../../eST/jsp/Sales.jsp?tit="+tit+"&mode=" + MODE_INSERT + "&function_id=ST_SALES&module_id=OT&ref_no="+facility_opernum+"&patient_id=" + patient_id + "&encounter=" + encounter_id + "&store_code=" + store_code + "&sal_trn_type=" + sal_trn_type+"&p_ord_practitioner_id="+p_ord_practitioner_id+"&slate_user_id="+user_id;
	retVal = await window.showModalDialog(url, arguments, features);
}

async function callOTSalesWindow_view()
{
	var formObj =document.forms[0];
    var oper_num=formObj.oper_num.value;
    var facility_id=formObj.facility_id.value;
	var facility_opernum=facility_id+'@'+oper_num;
		var retVal = "";
	var dialogHeight = "20";
	var dialogWidth = "65";
	var dialogTop = "160";
	var center = "1";
	var status = "no";
	var tit=encodeURIComponent(getLabel("eOT.ViewConsumablesUsed.Label","OT"));

	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: yes " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+";title:"+tit;
	var arguments = "";

	var url = "../../eOT/jsp/SalesQuerypage.jsp?tit="+tit+"&mode=" + MODE_INSERT + "&function_id=ST_SALES&module_id=OT&ref_no="+facility_opernum+"&oper_num="+oper_num;;//&patient_id=" + pat_id + "&encounter=" + encounter + "&store_code=" + store_code + "&sal_trn_type=" + sal_trn_type;

	retVal = await window.showModalDialog(url, arguments, features);
}

function Callbilling_ST(Qty,req_store,patient_id,encounter_id,pat_class,item_code)
{

	var formObj = document.forms[0];
	var oper_num = formObj.oper_num.value;
	//var item_code = formObj.item_id.value;
	var st_charge_based_yn = formObj.st_charge_based_yn.value;
	var param = "oper_num="+oper_num+"&p_Qty="+Qty+"&req_store="+req_store+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&pat_class="+pat_class+"&item_code="+item_code+"&st_charge_based_yn="+st_charge_based_yn;
	var xmlStr ="<root></root>";
	var temp_jsp="AdminSTbillingCharges.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	return responseText;
}

function checkForSpecCharsforID(event)
{
    var strCheck = '0123456789:/ ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}

function paintBillDetails(Total,Payable,Paid,include_exclude,Appr_reqd_val,from,i){
	if(Paid=='')Paid='0.0';
	var lbl_total=getLabel("Common.total.label","common_labels")+" "+getLabel("eOT.Payable.Label","ot_labels");
	var lbl_payable=getLabel("Common.PatientPayable.label","common_labels");
	var lbl_paid=getLabel("Common.PatientPaid.label","common_labels");
	var included=getLabel("eOT.Included.Label","ot_labels");
	var app_reqd=getLabel("eOT.ApprovalRequired.Label","ot_labels");
	var disabled="<img width=15px   align='texttop' height='15px' src='../../eCommon/images/disabled.gif'></img>";
	var enabled ="<img width=15px   align='texttop' height='15px' src='../../eCommon/images/enabled.gif'></img>";
	var formObj=document.forms[0];
	if(from=="REC")
	{
	var inc_exc=formObj.include_exclude1.value;
	var appr_reqd_val=formObj.appr_reqd_val1.value;
	}
	else if(from=="OR")
	{
	var inc_exc=formObj.include_exclude_or.value;
	var appr_reqd_val=formObj.appr_reqd_val_or.value;
	}
	else if(from=="HA")
	{
	var inc_exc=eval(document.getElementById("include_exclude_ha_"+i)).value;
	var appr_reqd_val=eval(document.getElementById("appr_reqd_val_ha_"+i)).value;
	}

	if(Appr_reqd_val==""){
		Appr_reqd_val=appr_reqd_val;
	}
	if(include_exclude.length==1)
	{
	if(include_exclude=="I"){
		include_exclude=enabled;
	}else 
	{
		include_exclude=disabled;
	}
	}
	if(Appr_reqd_val.length==1)
	{
	if(Appr_reqd_val=="Y"){
		Appr_reqd_val=enabled;
	}else 
	{
		Appr_reqd_val=disabled;
	}
	}
	var str="<font width='15px'>"+included+include_exclude+"</font>&nbsp;&nbsp;";
	str+="<font width='15px'>"+app_reqd+Appr_reqd_val+"</font>&nbsp;&nbsp;";
	str+= "<B><font color='Indigo' >"+lbl_total+":&nbsp;"+Total+"</font>&nbsp;&nbsp;";
	str+="<font color='crimson' >"+lbl_payable+":&nbsp;"+Payable+"</font>&nbsp;&nbsp;";
	str+="<font color='green'>"+lbl_paid+":&nbsp;"+Paid+"</font>&nbsp;&nbsp;</B>";
	str+="<a class='gridLink' href=\"javascript:callBillingWindow_rec('"+from+"','"+i+"','');\"><img src='../../eOT/images/dollar.png'></img></a>";
	if(from=="REC")
	eval(document.getElementById("charge_details_1")).innerHTML = str;
	else if(from=="OR")
	eval(document.getElementById("charge_details_or")).innerHTML = str;
	else if(from=="HA")
	eval(document.getElementById("charge_details_ha_")+i).innerHTML = str;
}



function callBillingWindow_rec1(from,i,flag){
	var formObj=document.forms[0];
	var oper_num=formObj.oper_num.value;
	var bay_code="";
	var service_code="";
	var charge_units="";
	var key="";
	var key_line="";
	if(from =="REC")
	{
		bay_code=formObj.recovery_room_code.value;
		service_code=formObj.serv_code.value;
		charge_units=formObj.charge_units_rec.value;
		key=formObj.recv_bl_accession_num.value;
		key_line = "1";
	}
	else if(from=="OR"){
		bay_code=formObj.oper_room_code.value;
		service_code=formObj.serv_code_or.value;
		charge_units=formObj.charge_units_or.value;
		key=formObj.or_bl_accession_num.value;
		key_line = "1";
	}
	else if(from=="HA"){
		bay_code=eval(document.getElementById("holding_area_code_"+i)).value 
		service_code=eval(document.getElementById("serv_code_ha_"+i)).value;
		charge_units=eval(document.getElementById("charge_units_ha_"+i)).value;
		key=eval(document.getElementById("bl_accession_num_"+i)).value;
		var j=parseInt(i);
		j=parseInt(j)+1;
		key_line = j;
	}
	//	var key_line = "";
	pushAllValuestoOR(key,key_line,oper_num,bay_code,service_code,charge_units,from,flag);
	var param = "order_id="+key+"&order_line_num="+key_line+"&called_from=SURG_ACC";
	var xmlStr ="<root></root>";
	var temp_jsp="GetBillDetailsFromPersistence.jsp?"+param;
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	if (flag!="onblur")
	{  
		showBillingWindow_rec(from,responseText,"1",i);
	}	
}

function callBillingWindow_rec(from,i,flag){
	var formObj=document.forms[0];
	var oper_num=formObj.oper_num.value;
	var bay_code="";
	var service_code="";
	var charge_units="";
	var key="";
	var key_line="";
	if(from =="REC")
	{
		bay_code=formObj.recovery_room_code.value;
		service_code=formObj.serv_code.value;
		charge_units=formObj.charge_units_rec.value;
		key=formObj.recv_bl_accession_num.value;
		key_line = "1";
	}
	else if(from=="OR"){
		bay_code=formObj.oper_room_code.value;
		service_code=formObj.serv_code_or.value;
		charge_units=formObj.charge_units_or.value;
		key=formObj.or_bl_accession_num.value;
		key_line = "1";
	}
	else if(from=="HA"){
		bay_code=eval(document.getElementById("holding_area_code_"+i)).value 
		service_code=eval(document.getElementById("serv_code_ha_"+i)).value;
		charge_units=eval(document.getElementById("charge_units_ha_"+i)).value;
		key=eval(document.getElementById("bl_accession_num_"+i)).value;
		var j=parseInt(i);
		j=parseInt(j)+1;
		key_line = j;
	}
	//	var key_line = "";
	//pushAllValuestoOR(key,key_line,oper_num,bay_code,service_code,charge_units,from,flag);
	var param = "order_id="+key+"&order_line_num="+key_line+"&called_from=SURG_ACC";
	var xmlStr ="<root></root>";
	var temp_jsp="GetBillDetailsFromPersistence.jsp?"+param;
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	if (flag!="onblur")
	{  
		showBillingWindow_rec(from,responseText,"1",i);
	}	
}

function pushAllValuestoOR(key,key_line,oper_num,bay_code,service_code,charge_units,from){
	if (from=="REC")
	{
		room_id="RR";
	}else if(from=="OR")
	{
		room_id="OR";
	}else if(from=="HA")
    {
		room_id="HB";
	}
	var formObj=document.forms[0];
	var patient_id=formObj.patient_id.value;
	var encounter_id=formObj.encounter_id1.value;
	var episode_id=formObj.episode_id.value;
	var visit_id=formObj.visit_id1.value;
	var serv_date=formObj.serv_date.value;
	var pract_staff_id=formObj.surgeon_code1.value;
	var patient_class=formObj.patient_class1.value;
	var bl_episode_type=formObj.episode_type.value;
	var order_id1=formObj.order_id1.value;
	//var bill_info_reqd_dtls=formObj.bill_info_reqd_dtls.value;
	var param = "key="+key+"&key_line="+key_line+"&oper_num="+oper_num+"&bay_code="+bay_code+"&service_code="+service_code+"&charge_units="+charge_units+"&room_id="+room_id+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&episode_id="+episode_id+"&visit_id="+visit_id+"&serv_date="+serv_date+"&pract_staff_id="+pract_staff_id+"&patient_class="+patient_class+"&bl_episode_type="+bl_episode_type+"&order_id1="+order_id1+"&called_from=PassBillDetails";
	var xmlStr ="<root></root>";
	var temp_jsp="AdminFunctionRoomCharges.jsp?"+param;
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText);
}

async function showBillingWindow_rec(from,str,key,i){
	var formObj=document.forms[0];
	var title=encodeURIComponent(getLabel("eBL.EDIT_ENTER_CHARGE_DETAILS.label","BL"));
	var arr = str.split("::");
	var column_sizes = "";
	var column_descriptions ="";       
	var episode_type = arr[4];
	var patient_id=arr[3];
	var visit_id=arr[6];
	var episode_id=arr[5];         
	var service_panel_code=arr[12];     //---service code returining from billing proc
	var service_panel_ind=arr[11];;						  //---to be check
	var service_date=arr[8];							  //---to be chedk
	var order_catalog_code=arr[2];      
	var module_id = "OT";
	var encounter_id=arr[7]; 
	var key=arr[0]; 
	var key_line_no=arr[1];//--- to be check
	//var order_id=formObj.order_id.value; 
	//var order_line_no="1";		
	var order_id=arr[0]; 
	var order_line_no=arr[1];	
	//order_line_no=parseInt(order_line_no)+1;
	//key_line_no=parseInt(key_line_no)+1;

	var bean_id=""; 
	if(from=="REC")
	{
		var total_qty =formObj.charge_units_rec.value;				//---to be check
		var revised_qty = formObj.charge_units_rec.value;
		//var original_qty = formObj.calc_chrge_units_rec.value;//commented against SKR-SCF-1233_Muthu-190619 //calc_chrge_units,charge_units
		var original_qty = 1;//Added against SKR-SCF-1233_Muthu-190619
	}
	else if(from=="OR")
	{
		var total_qty =formObj.charge_units_or.value;				//---to be check
		var revised_qty = formObj.charge_units_or.value;
		//var original_qty = formObj.calc_chrge_units_or.value;//commented against SKR-SCF-1233_Muthu-190619    //calc_chrge_units,charge_units
		var original_qty = 1;//Added against SKR-SCF-1233_Muthu-190619
	} else if(from=="HA")
	{
		var total_qty =eval(document.getElementById("charge_units_ha_"+i)).value;				//---to be check
		var revised_qty = eval(document.getElementById("charge_units_ha_"+i)).value;	
		//var original_qty = eval("document.getElementById("calc_charge_units_")"+i).value;//commented against SKR-SCF-1233_Muthu-190619  //calc_chrge_units,charge_units 
		var original_qty = 1;//Added against SKR-SCF-1233_Muthu-190619
	}
	var bl_panel_str = arr[13];	//Panel Str returing from units
	var index_val="";
	var dialogTop = "100";
	var dialogHeight = "30" ;
	var dialogWidth = "70" ;
	var inc_exe=""; //dummy var created for painting the bill details in front end
	var apprvl_reqd_yn="";  //dummy var created for painting the bill details in front end
	var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments = "" ;
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"episode_type="+episode_type+"&"+"patient_id="+patient_id+"&"+"visit_id="+visit_id+"&"+"episode_id="+episode_id+"&"+"service_panel_code="+service_panel_code+"&"+"service_panel_ind="+service_panel_ind+"&"+"service_date="+service_date+"&"+"order_catalog_code="+order_catalog_code+"&"+"module_id="+module_id+"&encounter_id="+encounter_id+"&key="+key+"&key_line_no="+key_line_no+"&order_id="+order_id+"&order_line_no="+order_line_no+"&bean_id="+bean_id+"&total_qty="+total_qty+"&revise_qty="+revised_qty+"&original_qty="+original_qty+"&quantity="+revised_qty+"&qty="+revised_qty+"&p_serv_qty="+revised_qty+"&revised_qty="+revised_qty+"&serv_panel_qty="+revised_qty+"&modify_qty_yn=Y&p_str="+bl_panel_str; 
    
	var retVal = await window.showModalDialog("../../eBL/jsp/BLEnterEditChargeDtlMain.jsp?"+param,arguments,features);
		if(retVal!=null){
			var retArray  = retVal;		    
			
			if(from=="REC") 
			{
				formObj.include_exclude1.value=retArray[6];
				formObj.action_reason_code1.value=retArray[7];
			}
			else if(from=="OR")
			{
				formObj.include_exclude_or.value=retArray[6];
				formObj.action_reason_code_or.value=retArray[7];
			}
			else if(from=="HA")
			{
				eval(document.getElementById("include_exclude_ha_"+i)).value = retArray[6];
				eval(document.getElementById("action_reason_code_ha_"+i)).value = retArray[7];
			}			paintBillDetails(retArray[1],retArray[2],retArray[3],retArray[8],apprvl_reqd_yn,from,i);
		}
}

async function callBillingWindow_st(index,Appr_reqd,include_exclude,total_amt,pat_pay,pat_paid,reason_code,req_store_code,quantity,item_code,sale_document_no,sale_document_type,override_value){
	var flag=true;
	var  tabobj = parent.parent.AdministrativeFunctionCompletionStatus.AdministrativeFunctionforAllChargesForm;
	var  hdrobj = parent.parent.AdministrativeFucntionFrame.AdministrativeFunctionforAllChargesForm;
	var is_pi_complete=tabobj.pi_complete.checked;
	var patient_id=hdrobj.patient_id.value;
	var encounter_id=hdrobj.encounter_id1.value;
	var mm_item_code=hdrobj.mm_item_code.value;
	var patient_class=hdrobj.patient_class1.value;
	var facility_id=hdrobj.facility_id.value;

	var rows =parent.parent.parent.AdminObjectCollect.implants_rows[index];
	var dialogTop = "100";
	var dialogHeight = "30" ;
	var dialogWidth = "70" ;
	var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var title=encodeURIComponent(getLabel("eBL.EDIT_ENTER_CHARGE_DETAILS.label","BL"));
	var arguments = "" ;
	var column_sizes = "";
	var index_val="";
	var param = "title="+title+"&"+"Appr_reqd="+Appr_reqd+"&"+"include_exclude="+include_exclude+"&"+"total_amt="+total_amt+"&"+"pat_pay="+pat_pay+"&"+"pat_paid="+pat_paid+"&"+"reason_code="+reason_code+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&mm_item_code="+mm_item_code+"&req_store_code="+req_store_code+"&quantity="+quantity+"&item_code="+item_code+"&patient_class="+patient_class+"&facility_id="+facility_id+"&sale_document_no="+sale_document_no+"&sale_document_type="+sale_document_type+"&override_value="+override_value;
	var retVal = await window.showModalDialog("../../eOT/jsp/ShowbillingST.jsp?"+param,arguments,features);
	if(retVal!=null){
	if(retVal =="CANCEL")
	{
		var arr = rows.bill_str.split("::");
		rows.bill_str = arr[0]+"::"+arr[1]+"::"+arr[2]+"::"+arr[3]+"::"+arr[4]+"::"+arr[5]+"::"+arr[6]+"::"+arr[7]+"::"+arr[8]+"::"+arr[9];
    }
	else{
	var retArray  = retVal.split("*");
	var arr = rows.bill_str.split("::");
	if(typeof retArray[0]=='undefined' || trimString(retArray[0])=="") 					retArray[0]=null;
	if(typeof retArray[1]=='undefined' || trimString(retArray[1])=="") 					retArray[1]=null;

	//rows.bill_str = total_amt+"::"+pat_pay+"::"+pat_paid+"::"+arr[3]+"::"+retArray[1]+"::"+arr[5]+"::"+arr[6]+"::"+retArray[0]+"::"+retArray[1];
		rows.bill_str = retArray[2]+"::"+retArray[3]+"::"+retArray[4]+"::"+arr[3]+"::"+retArray[1]+"::"+arr[5]+"::"+arr[6]+"::"+retArray[0]+"::"+retArray[1]+"::"+arr[9];
	}
	if(rows.db_mode!="I"){
		rows.db_mode = (rows.order==1 || rows.order==null || rows.order=="")?"U":"I";
	}
	createTable_pi();
	}
}

//Added by lakshmi for crf-0601
function callSummaryOfMedReport()
{
	var formObj=document.forms[0];		
	if (formObj.customer_id1.value == 'SRR')
	{
	if(formObj.p_facility_id.value =='SI' ){
		formObj.p_report_id.value="OTSMCHRG";
	}
	else{
		formObj.p_report_id.value="OTSMCHRH"; 
		//formObj.p_report_id.value="OTSMCHRG"; 
	}
    }  	
}

/*Added by lakshmi for crf-0601 starts here*/
function OnPrintReport()
{	
	var formObj = document.forms[0];
	if (formObj.p_report_id.value =='OTSMCHRG' && document.AdministrativeFunctionforAllChargesForm.summary.checked== true)
	{
		var htmlVal = "<html><body onKeyDown='lockKey()'>";
		htmlVal += "<form name='frm_temp1' id='frm_temp1'  action='../../eCommon/jsp/report_options.jsp' >";
		htmlVal += "<input type='hidden' name='p_patient_id' id='p_patient_id' value='"+formObj.p_patient_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_oper_num' id='p_oper_num' value='"+formObj.p_oper_num.value+"'>";
		htmlVal += "<input type='hidden' name='p_operating_facility_id' id='p_operating_facility_id' value='"+formObj.p_facility_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+formObj.p_report_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+formObj.locale.value+"'>";
		htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='OT'>";
		/*for(var i =0 ;i<parent.frames.length;i++)
			{
		alert(parent.frames(i).name);
			}*/
		htmlVal += "</form></body></html>";
		parent.dummy_rep_frame.document.body.insertAdjacentHTML("afterBegin",htmlVal);
		parent.parent.dummy_rep_frame.document.frm_temp1.submit();	
	}
	else if (formObj.p_report_id.value =='OTSMCHRH' && document.AdministrativeFunctionforAllChargesForm.summary.checked== true)
	{
		var htmlVal = "<html><body onKeyDown='lockKey()'>";
		htmlVal += "<form name='frm_temp1' id='frm_temp1'  action='../../eCommon/jsp/report_options.jsp' >";
		htmlVal += "<input type='hidden' name='p_patient_id' id='p_patient_id' value='"+formObj.p_patient_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_oper_num' id='p_oper_num' value='"+formObj.p_oper_num.value+"'>";
		htmlVal += "<input type='hidden' name='p_operating_facility_id' id='p_operating_facility_id' value='"+formObj.p_facility_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+formObj.p_report_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+formObj.locale.value+"'>";
		htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='OT'>";
		htmlVal += "</form></body></html>";
		parent.dummy_rep_frame.document.body.insertAdjacentHTML("afterBegin",htmlVal);
		parent.parent.dummy_rep_frame.document.frm_temp1.submit();	
	}
	else if (formObj.p_report_id.value =='OTSMCHRP' && document.AdministrativeFunctionforAllChargesForm.pros_impl.checked== true)
	{
		var htmlVal = "<html><body onKeyDown='lockKey()'>";
		htmlVal += "<form name='frm_temp1' id='frm_temp1'  action='../../eCommon/jsp/report_options.jsp' >";
		htmlVal += "<input type='hidden' name='p_patient_id' id='p_patient_id' value='"+formObj.p_patient_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_oper_num' id='p_oper_num' value='"+formObj.p_oper_num.value+"'>";
		htmlVal += "<input type='hidden' name='p_operating_facility_id' id='p_operating_facility_id' value='"+formObj.p_facility_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+formObj.p_report_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+formObj.locale.value+"'>";
		htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='OT'>";
		htmlVal += "</form></body></html>";
		parent.dummy_rep_frame.document.body.insertAdjacentHTML("afterBegin",htmlVal);
		parent.parent.dummy_rep_frame.document.frm_temp1.submit();	
	}
}
/*Added by lakshmi for crf-0601 ends here*/

//Added by lakshmi for crf-0601 report3
function callProsthesisImplantsReport()
{
	var formObj=document.forms[0];
	if (formObj.customer_id1.value == 'SRR')
	{
		formObj.p_report_id.value="OTSMCHRP";
	}	
}

//Added by lakshmi for crf-0601 for validation of check box
function validateCheckboxSummary()
{
	if(document.AdministrativeFunctionforAllChargesForm.summary.checked== true) 
	{  
		document.AdministrativeFunctionforAllChargesForm.pros_impl.checked=false; 
		callSummaryOfMedReport();
	} 
}

function validateCheckboxProsthesis()
{
	if(document.AdministrativeFunctionforAllChargesForm.pros_impl.checked== true) 
	{
		document.AdministrativeFunctionforAllChargesForm.summary.checked=false;  
		callProsthesisImplantsReport();
	}
}
function showCalWithTime(id, format, showsTime, showsOtherMonths, name) {
	fmt = format;
	{
		calend = format;
		if (showsTime) {
			time = true;
		} else {
			time = false;
		}
		var cal;
		currentDateElement = document.getElementById(id);
		cal = new PopupWindow();
		cal.offsetX = 50;
		cal.offsetY = 50;
		cal.setSize(250, 200);
		cal.autoHide();
		cal.setUrl("../../framework/jsp/Calendar.jsp");
		cal.refresh();
		cal.showPopup(name);
		return false;
	}
}

function validateDate(val){
	var date=new Date();
	var month=date.getMonth();
	var date1=date.getDate();
	var year=date.getYear();
	var hour=date.getHours();
	var minute=date.getMinutes();
	month+=1;
	if(date1<=9){
		date1="0"+""+date1;
	}
	if(month<=9){
		month="0"+""+month;
	}
	if(hour<=9){
		hour="0"+""+hour;
	}
	if(minute<=9){
		minute="0"+""+minute;
	}
	var sysDate=date1+"/"+month+"/"+year+" "+hour+":"+minute;
	if(isValidDateTime(val))
	{
		
	}
	else
	{
		document.getElementById("desiredDate").value="";
	}
	return false;
}

function isValidDateTime(obj){
	var flag=true;
	if(obj!=""){
		var str=obj;
		var dateValArr = str.split(' ');
		if (dateValArr[0] =="" || dateValArr[1]=="")
		{
			alert(getMessage('INVALID_DATE_FMT','SM'));
			flag=false;
		}
		else
		{
			if(checkDate1(dateValArr[0])==true && checkTime(dateValArr[1])==true)
			{flag=true;}
			else
			{flag=false;}
		}
	}
	return flag;
}

function checkDate1(objval)
{
	var flag=true;
	var RE_NUM =  /^\/?\d+$/;
	var str_date = objval;
	var arr_date = str_date.split('/');
	if (arr_date.length != 3)
	{
		alert(getMessage('INVALID_DATE_FMT','SM'));
		flag=false;
	}
	else
	{
		if (!arr_date[0]) flag=false;
		if (!RE_NUM.exec(arr_date[0])) flag=false;
		if (!arr_date[1]) flag=false;
		if (!RE_NUM.exec(arr_date[1])) flag=false;
		if (!arr_date[2]) flag=false;
		if (arr_date[2].length!=4) flag=false;
		var dt_date = new Date();
		dt_date.setDate(1);
		if (arr_date[1] < 1 || arr_date[1] > 12) flag=false;
		dt_date.setMonth(arr_date[1]-1);
		var dt_numdays = new Date(arr_date[2], arr_date[1], 0);
		dt_date.setDate(arr_date[0]);
		if (dt_date.getMonth() != (arr_date[1]-1)) flag=false;
		var alphaFilter =/^[0-9]+$/;   
	   	if (!(alphaFilter.test(arr_date[2])))  flag=false;

		if (flag==false){
			alert(getMessage('INVALID_DATE_FMT','SM'));
		}
	}
	return flag;
}

function checkTime(timeBox){
	if(timeBox=="" || timeBox==null || typeof timeBox=='undefined' )
	{
		alert(getMessage('INVALID_DATE_FMT','SM'));
		return false;
	}
	else
	{
		if(parseInt(timeBox.length)<=parseInt(5))
		{
		   time=timeBox;
		   time1=time.split(':')
		   if (!/\d{2}:\d{2}/.test(time)){
			   alert(getMessage('INVALID_DATE_FMT','SM'));
			   return false;
		   }
		   else if (time1[0] >23 || time1[1]>59) {
			   alert(getMessage('INVALID_DATE_FMT','SM'));
			   return false;
		   }
		   else 
		   	return true;
		}
	}
}

function chkDateRangeValidity(val)
{
	var locale = document.forms[0].locale.value;
	var checkInDateTime = document.forms[0].checkInTime.value;
	var valDate = val.substring(0, 10);
	var checkInTime = checkInDateTime.substring(0, 10);
	var oneWeekDate = document.forms[0].oneWeekDate.value;
	if(isAfter(valDate, oneWeekDate, "DMY", locale))
	{
		alert(getMessage("APP-OT0222","OT"));
		return false;
	}
	else if(isAfter(checkInDateTime, val, "DMYHM", locale))
	{
		alert(getMessage("APP-OT0223","OT") + " " + checkInDateTime);//47546
		return false;
	}
	else
		return true;
}

function checkFieldsOt( fields, names, messageFrame,val) {
    var errors = "" ;
    for( var i=0; i<fields.length; i++ ) 
    {
        if(trimCheck(fields[i].value)) 
        {
            fields[i].value = trimString(fields[i].value);
			if (val=="Y")
				fields[i].style.backgroundColor='#FFFFFF';
        }
        else 
        {
			errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"<br>";
			if (val=="Y")
				fields[i].style.backgroundColor='#FFFF66';
		}
    }
    if (errors.length != 0 )
	{
		errors = encodeURIComponent(errors);
		messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors;
		return false ;
	}
	return true ;
}
//Added Against ML-MMOH-CRF-1939-US004
function createXMLForOperations(){
		var rows=parent.ObjectCollect.rows;
		var bill_flag=document.forms[0].bill_flag.value;
		var len = rows.length;
		var table_name = "OT_POST_OPER_DTLS";
		var xmlString ="";
		for(var i=0;i<len;i++){
		if(rows[i]!=null){
		xmlString+="<PROC_DTL"+i+" ";
		xmlString+="oper_num=\""+document.forms[0].oper_num.value+"\""+" ";
		xmlString+="oper_code=\""+rows[i].oper_code+"\""+" ";
		xmlString+="right_left_flag=\""+rows[i].side_applicable+"\""+" ";
		xmlString+="oper_remarks=\""+decodeURIComponent(rows[i].remarks,"UTF-8")+"\""+" ";
		xmlString+="oper_line_num=\""+rows[i].line_no+"\""+" ";
		xmlString+="order_line_num=\""+rows[i].order_line_no+"\""+" ";
		xmlString+="oper_line_status=\""+rows[i].chk_status+"\""+" ";
		xmlString+="cancel_remarks=\""+decodeURIComponent(rows[i].cancel_remarks,"UTF-8")+"\""+" ";

		if(bill_flag=="true")
		{
		xmlString+="bill_str=\""+rows[i].rate+"::"+rows[i].bill_str+"\""+" ";
		xmlString+="panel_str=\""+escape(rows[i].panel_str)+"\""+" ";
		}
		xmlString+="order_id=\""+rows[i].order_id+"\""+" ";

		if(rows[i].db_mode=="L")
		xmlString+="db_mode=\""+"U"+"\""+" ";
		else
		xmlString+="db_mode=\""+rows[i].db_mode+"\""+" ";

		xmlString+="table_name=\""+table_name+"\""+" />";
		}
		}
		return xmlString;
		}

function getCatalogCode(oper_code){
	var sql="SELECT ORDER_CATALOG_CODE FROM OT_OPER_MAST WHERE OPER_CODE='"+oper_code+"'";
	var param="sql="+sql+"&flag=MED_SER";
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var resTxt=trimString(xmlHttp.responseText);
	return resTxt;
  }
 
function getPanelStr_op(index){
	var op_rows = parent.parent.parent.AdminObjectCollect.op_rows[index];
	var order_id = op_rows.order_id;
	var order_line_num = op_rows.order_line_no;
	var oper_code = op_rows.oper_code;
	var patient_id = document.forms[0].patient_id.value;
	var param = "order_id="+order_id+"&order_line_num="+order_line_num+"&oper_code="+oper_code+"&patient_id="+patient_id+"&called_from=RECORD_SURGEON";
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var temp_jsp="GetBillDetailsFromPersistence.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	return responseText;
  }
function ReplaceAll(Source,stringToFind,stringToReplace){
  var temp = Source;

    var index = temp.indexOf(stringToFind);

        while(index != -1){

            temp = temp.replace(stringToFind,stringToReplace);

            index = temp.indexOf(stringToFind);

        }
        return temp;
}

function openDialogWindow_op(strVal,index){
		var rows = parent.parent.parent.AdminObjectCollect.op_rows[index];
	    var cancel_remarks=rows.cancel_remarks;
		var remarks=rows.remarks;
		var strVal=encodeURIComponent(strVal);
		var chk_status=rows.chk_status; 
		var cancel_remarks=cancel_remarks; 
		var size="2000";
		remarks=encodeURIComponent(remarks,"UTF-8");
		 remarks=decodeURIComponent(remarks,"UTF-8");
		 cancel_remarks=encodeURIComponent(cancel_remarks,"UTF-8");
		 cancel_remarks=decodeURIComponent(cancel_remarks,"UTF-8");		 
		var oper_num=document.forms[0].oper_num.value;
		var called_from="Operation_Dtls";
		var temp_index=index+1
		var flag="1"	;
		
		var heading = getLabel("eOT.PreOperativeComments.Label","ot");
		var dialogHeight		= "9";
		var dialogWidth			= "32";
		var features			="dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		var arguments			= "";

      var param='index='+temp_index+'&called_from='+called_from+'&oper_num='+oper_num+'&cancel_remarks='+cancel_remarks+'&chk_status='+chk_status+'&size='+size+'&remarks='+remarks+'&heading='+heading;
		window.showModalDialog("../../eOT/jsp/TextArea.jsp?"+param,arguments,features);
	 }
		//Added by Muthu for RUT-CRF-0057
function openDialogWindow_eq_img(strVal,index,equip_code){
  var rows = parent.parent.parent.AdminObjectCollect.equipment_rows[index];
  var equip_code=encodeURIComponent(rows.equip_code);
 var title=encodeURIComponent(getLabel("Common.equipment.label","Common"));
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	var params = equip_code;
	var xmlStr ="<root><SEARCH ";
	xmlStr +="/></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=check_Image_flag&equipment_code="+equip_code,false);
	xmlHttp.send(xmlDoc);	
	var sql_image_flag = trimString(xmlHttp.responseText);	
//Newly Added on 12-1-2012
//RUT-CRF-0091 by MuthuN Starts Here
	var eq_location_array=sql_image_flag.split("~BR~");
	loc_eq=encodeURIComponent(eq_location_array[0]); 
	image_eq=eq_location_array[1];
	//RUT-CRF-0091 by MuthuN Ends Here
if(!sql_image_flag == "")
	{
		var dialogHeight 		= "0";
		var dialogWidth  		= "40";
		var dialogTop   		= "200";
		var dialogLeft   		= "100";
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		var arguments			= "";
		var	param="image="+image_eq + "&location=" + loc_eq;
		retVal=window.showModalDialog("../../eOT/jsp/AdminEquipmentFrame.jsp?"+param,arguments,features);}
	else
	{
		alert(getMessage("NO_RECORD_FOUND","Common"));
		//Modified by rajesh for CRF-0057 26-9-12
	}	
}

function openDialogWindow_ic_img(strVal,index,instr_code){
  var rows = parent.parent.parent.AdminObjectCollect.instrument_rows[index];
  var instr_code=encodeURIComponent(rows.instr_code);
  var instr_desc=encodeURIComponent(rows.instr_desc);

	var title=encodeURIComponent(getLabel("Common.equipment.label","Common"));
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	var params = instr_code;
	var xmlStr ="<root><SEARCH ";
	xmlStr +="/></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=check_CSSD_Image_flag&instr_code="+instr_code,false);
	xmlHttp.send(xmlDoc);	
	var sql_cssd_image_flag = trimString(xmlHttp.responseText);
	//RUT-CRF-0091 by MuthuN Starts Here
	var ins_location_array=sql_cssd_image_flag.split("~BR~");
	loc_ic=encodeURIComponent(ins_location_array[0]);
	image_ic=ins_location_array[1];
	//RUT-CRF-0091 by MuthuN Ends Here
	//Modified by Rajesh for CRF-0057 for opening image always
	var dialogHeight 		= "0";
		var dialogWidth  		= "40";
		var dialogTop   		= "200";
		var dialogLeft   		= "100";
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		var arguments			= "";
		
		var	param="instr_code="+instr_code+"&instr_desc="+instr_desc; 
		param=param+"&image="+image_ic;
		param=param+"&location="+loc_ic;
		retVal=window.showModalDialog("../../eOT/jsp/AdminInstrumentFrame.jsp?"+param,arguments,features);
	//Modified by Rajesh for CRF-0057 for opening image always
}	//Added by Muthu for RUT-CRF-0057

 
function loadDBRows_op(line_no,oper_code,oper_desc,side_applicable,remarks,order_line_no,order_id,bill_str,panel_str,mode,oper_line_status,cancel_remarks,bill_yn,billed_yn,fpp_category,Include_Fpp_yn,isIncludeFpp,count,bill_flag){
   var rowLeng = parent.parent.parent.AdminObjectCollect.oprowLength;
   var rows    = parent.parent.parent.AdminObjectCollect.op_rows;
   if(mode=='L' && rowLeng==0){
	   var objrow = newRow();
	   objrow.oper_code=oper_code;
	   objrow.oper_desc=unescape(oper_desc);
	   objrow.side_applicable=side_applicable;
	   if(side_applicable=="R"){
		  objrow.side_applicable_desc=rightSide_title;
		  objrow.side_applicable_yn="Y";
	   }else if(side_applicable=='B'){
		   objrow.side_applicable_yn="Y";
		  objrow.side_applicable_desc=bilateral_title;
	   }else if(side_applicable=='L'){
		   objrow.side_applicable_yn="Y";
		  objrow.side_applicable_desc=leftSide_title;
	   }else if( side_applicable=='N' || side_applicable=='') {
		   objrow.side_applicable_yn="N";
	      objrow.side_applicable_desc=notApplicable_title;
	   }
	   objrow.line_no=line_no;
	   objrow.remarks=remarks;
	   objrow.order_id = order_id
	   objrow.order_line_no=order_line_no;
	   objrow.db_mode="I";
	   objrow.chk_status=oper_line_status;
	   objrow.oper_line_status=oper_line_status;
	   objrow.cancel_remarks=cancel_remarks;
	   objrow.bill_str=bill_str;
	   objrow.posted_yn=bill_str.split("::")[9];
	   objrow.panel_str=panel_str;
	   objrow.rate="";
	   objrow.bill_yn=bill_yn;
	   objrow.billed_yn=billed_yn; 
	   //if(Include_Fpp_yn == 'Y' && isIncludeFpp && count == 1 && bill_flag == 'true') objrow.fpp_category = fpp_category;
	   if(fpp_category == "S" || fpp_category == "M" || fpp_category == "C") objrow.fpp_category = fpp_category;
	   else objrow.fpp_category ="";
	  rows.push(objrow);
	 }
 } 
 
 /*  pls below functions chage to admin js function after working billing window showing properly*/
function callBillingWindow_op(index)
   {
	var op_rows = parent.parent.parent.AdminObjectCollect.op_rows[index];
	var order_id = op_rows.order_id;
	var order_line_num = op_rows.order_line_no;
	var oper_code = op_rows.oper_code;
	var patient_id = document.forms[0].patient_id.value;
	var param = "order_id="+order_id+"&order_line_num="+order_line_num+"&oper_code="+oper_code+"&patient_id="+patient_id+"&called_from=Adminfunction";

	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var temp_jsp="GetBillDetailsFromPersistence.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	showBillingWindow_op(responseText,index);	
   }

    async function showBillingWindow_op(str,index){
	    var op_rows = parent.parent.parent.AdminObjectCollect.op_rows[index];
		var arr = str.split("::");
		var panel_str_key="";
			var post_flag = (op_rows.posted_yn=="X")?true:false;
	if(post_flag){
				var oper_num = document.forms[0].oper_num.value;
				var module_id="OT";    
				var order_id= oper_num;
				var order_line_no=arr[1];
				var key=op_rows.order_id;
				var key_line_no=arr[1];
			}else{
				var module_id="OR";    
				var order_id= op_rows.order_id;
		       		 var order_line_no=arr[1];
				var key=op_rows.order_id;
				var key_line_no=arr[1];
		   } 
		    key_line_no = arr[20]; //50485
			var order_catalog_code=getCatalogCode(arr[2]); 
			var patient_id = arr[3];          
			var episode_type = arr[4];
			var episode_id=arr[5];         
			var visit_id=arr[6];
			var encounter_id=arr[7]; 
			var service_date=arr[8];  
			var pract_staff_ind=arr[9];          
			var pract_staff_id=arr[10];
			var service_panel_ind=arr[11]; 
			var service_panel_code=arr[12];     
			var bean_id=""; 
			var dialogTop = "100";
			var dialogHeight = "30" ;
			var dialogWidth = "70" ;
			var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
			var title=encodeURIComponent(getLabel("eBL.EDIT_ENTER_CHARGE_DETAILS.label","BL"));
			var arguments = "" ;
			var column_sizes = "";
			var column_descriptions ="";   
			//var incl_excl_ind="E";
            var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"episode_type="+episode_type+"&"+"patient_id="+patient_id+"&"+"visit_id="+visit_id+"&"+"episode_id="+episode_id+"&"+"service_panel_code="+service_panel_code+"&"+"service_panel_ind="+service_panel_ind+"&"+"service_date="+service_date+"&"+"order_catalog_code="+order_catalog_code+"&"+"module_id="+module_id+"&encounter_id="+encounter_id+"&key="+key+"&key_line_no="+key_line_no+"&order_id="+order_id+"&order_line_no="+order_line_no+"&bean_id="+bean_id; 
			var retVal = await window.showModalDialog("../../eBL/jsp/BLEnterEditChargeDtlMain.jsp?"+param,arguments,features);
			if(retVal!=null){
				var retArray  = retVal;
				var arr = op_rows.bill_str.split("::");
				if(arr[6]=='L' || retArray[6]=="")
				{
				retArray[6]=null;
				retArray[7]=null;
				} 
				op_rows.bill_str = retArray[1]+"::"+retArray[2]+"::"+retArray[3]+"::"+arr[3]+"::"+retArray[6]+"::"+arr[5]+"::"+arr[6]+"::"+retArray[7]+"::"+retArray[8];
				//Commented by DhanasekarV against the issue IN025278
				op_rows.rate = retArray[5];
				op_rows.db_mode = "U";
				var pnl_str =  getPanelStr_op(index);
				op_rows.panel_str =pnl_str.split("::")[13];
				//Commented by DhanasekarV against the issue IN025278
				createTable_op();
			}
   }
 
 

