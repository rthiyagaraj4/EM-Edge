/*
Sr No     Version          TFS/Incident        SCF/CRF     			Developer Name
-------------------------------------------------------------------------------------
1         V200119			  12827     	GHL-CRF-0631			Nandhini M
2         V210419			  19422     	GHL-CRF-0639-US001		NandhiniM/MuthuN
-------------------------------------------------------------------------------------
*/

function reset()
{
	 PkgSubscriptionFrame.document.location.reload();
}

// For adding multiple price range for package
function showCalendar_LocalDt(index){
	showCalendar(index,'dd/mm/yyyy hh:mm:ss');
}
function addRow(tableID,function_id)
{
	
	var mode="";
	var table="";
	var rowCount="";
	var index="";
	var row="";
	var site_spec=eval(document.forms[0].site_spec.value);
	var SiteSpecific_VAT=document.forms[0].SiteSpec_VAT.value;//Added V171212-Gayathri/MMS-DM-CRF-0118
	var siteBLPkgBlngGrpYN = document.forms[0].siteBLPkgBlngGrpYN.value; //Added By Shikha For GHL-CRF-0520.1
	table = document.getElementById('"+tableID+"');	
	rowCount = table.rows.length;			
	index = rowCount-2;		
	row=document.getElementById('"+tableID+"').insertRow(rowCount);
	var siteBLpractYN = document.forms[0].pracMandatoryYN.value; 
	
	var cell1=row.insertCell(0);
	var cell2=row.insertCell(1);
	var cell3=row.insertCell(2);
	var cell4=row.insertCell(3);
	var cell5=row.insertCell(4);
	var cell6=row.insertCell(5);
	var cell7=row.insertCell(6);
	var cell8=row.insertCell(7);
	var cell9=row.insertCell(8);
		//Added By Shikha For GHL-CRF-0520.1
	if (siteBLPkgBlngGrpYN=="Y") {				
		var cell10=row.insertCell(9);			
		//Added V171212-Gayathri/MMS-DM-CRF-0118/Starts
		if(SiteSpecific_VAT=="Y"){
			var cell11=row.insertCell(10);
			//alert("cell11"+cell11);
		}
	}else { 	//Added By Shikha For GHL-CRF-0520.1
		var cell10=row.insertCell(9);
	}
	//Added V171212-Gayathri/MMS-DM-CRF-0118/Ends
	cell1.innerHTML="<a href='#' name='pkgDtls"+index+"' id='pkgDtls"+index+"' onClick=\"displaypkgDtls('"+index+"');\" >+</a> <input type='text' name='packageCode_"+index+"' id='packageCode_"+index+"'  value='' size='8' maxlength='8'  onKeyPress='return CheckForSpecChars_loc(event,packageCode_"+index+");' onBlur='pkgCodeLookup(packageDesc_"+index+",this,\""+index+"\");' ><input type='text' name='packageDesc_"+index+"' id='packageDesc_"+index+"'   onBlur='pkgDescLookUp(this,packageCode_"+index+",\""+index+"\")'  size='10'  maxlength='40' value=''><INPUT type='hidden' name='packageCode_temp_"+index+"' id='packageCode_temp_"+index+"' value=''><INPUT type='hidden' name='packageDesc_temp_"+index+"' id='packageDesc_temp_"+index+"' style='style='width:0px;' value=''><input type='button' class='button' name='packageBtn_"+index+"' id='packageBtn_"+index+"' value='?'  onClick='pkgLookUp(packageDesc_"+index+",packageCode_"+index+",\""+index+"\");'>";

	var blngClassTD=""
	if(function_id=="VISIT_REGISTRATION"){
		blngClassTD="<input type='text' name='blng_class_code"+index+"' id='blng_class_code"+index+"' value='OP' readOnly size='2' MAXLENGTH ='2' ><input type='text' name = 'blng_class_desc"+index+"' id='blng_class_desc"+index+"' value='OP' readOnly >"
	}else if(function_id=="ADMISSION"){
		var blng_class_code=document.forms[0].blng_class_code0.value;
		var blng_class_desc=document.forms[0].blng_class_desc0.value;
		blngClassTD="<input type='text' name='blng_class_code"+index+"' id='blng_class_code"+index+"' value='"+blng_class_code+"' readOnly size='2' MAXLENGTH ='2' ><input type='text' name = 'blng_class_desc"+index+"' id= 'blng_class_desc"+index+"' value='"+blng_class_desc+"' readOnly><INPUT type='hidden' name='blng_class_code_temp"+index+"' id='blng_class_code_temp"+index+"' value=''><INPUT type='hidden' name='blng_class_desc_temp"+index+"' id='blng_class_desc_temp"+index+"' value=''>"
	}else{

		blngClassTD=	"<input type='text' name='blng_class_code"+index+"' id='blng_class_code"+index+"' value='' size='2' MAXLENGTH ='2'  onBlur='blngClassCodeLookUp(blng_class_desc"+index+",this,\""+index+"\")'><input type='text' name = 'blng_class_desc"+index+"' id='blng_class_desc"+index+"' size='10'  onBlur='blngClassDescLookUp(this,blng_class_code"+index+",\""+index+"\")' value=''><INPUT type='hidden' name='blng_class_code_temp"+index+"' id='blng_class_code_temp"+index+"' value=''><INPUT type='hidden' name='blng_class_desc_temp"+index+"' id='blng_class_desc_temp"+index+"' value=''><input type='button' name='blng_class_button_"+index+"' id='blng_class_button_"+index+"' class='button' value='?' onclick='blngClassLookUp(blng_class_desc"+index+",blng_class_code"+index+",\""+index+"\")'>"
	}
	cell2.innerHTML=blngClassTD;
	//Added By Shikha For GHL-CRF-0520.1
	if (siteBLPkgBlngGrpYN=="Y") {	
		if(true){
			var frm = document.frmPkgSubs;
			var insBlngGrp = frm.insBlngGrp.value;					
			var insBlngGrpDesc = frm.insBlngGrpDesc.value;
			cell3.innerHTML="<input type='text' name='blngGrpCode_"+index+"' id='blngGrpCode_"+index+"' value='"+insBlngGrp+"' size='2' onBlur='blngGrpCodeLookUp(blngGrpDesc_"+index+",this,\""+index+"\")' ><input type='text' name = 'blngGrpDesc_"+index+"' id='blngGrpDesc_"+index+"' size='10' maxlength='15' onBlur='blngGrpDescLookUp(this,blngGrpCode_"+index+",\""+index+"\")' value='"+insBlngGrpDesc+"'><INPUT type='hidden' name='blngGrpCode_temp_"+index+"' id='blngGrpCode_temp_"+index+"' value=''><INPUT type='hidden' name='blngGrpDesc_temp_"+index+"' id='blngGrpDesc_temp_"+index+"' value=''><input type='button' name='blngGrp_button_"+index+"' id='blngGrp_button_"+index+"' class='button' value='?'  onclick='blngGrpLookUp(blngGrpDesc_"+index+",blngGrpCode_"+index+",\""+index+"\");'>";					
		}
		else{
			cell3.innerHTML="<input type='text' name='blngGrpCode_"+index+"' id='blngGrpCode_"+index+"' value='' size='2' onBlur='blngGrpCodeLookUp(blngGrpDesc_"+index+",this,\""+index+"\")'><input type='text' name = 'blngGrpDesc_"+index+"' id='blngGrpDesc_"+index+"' size='10' maxlength='15' onBlur='blngGrpDescLookUp(this,blngGrpCode_"+index+",\""+index+"\")' value=''><INPUT type='hidden' name='blngGrpCode_temp_"+index+"' id='blngGrpCode_temp_"+index+"' value=''><INPUT type='hidden' name='blngGrpDesc_temp_"+index+"' id='blngGrpDesc_temp_"+index+"' value=''><input type='button' name='blngGrp_button_"+index+"' id='blngGrp_button_"+index+"' class='button' value='?' onclick='blngGrpLookUp(blngGrpDesc_"+index+",blngGrpCode_"+index+",\""+index+"\");'>";					
		}			
		//Added by Rajesh V for CRF - 140
		if(true){
			var frm = document.frmPkgSubs;
			var insCustGrp = frm.insCustGrp.value;
			var insCust = frm.insCust.value;
			var insCustGrpDesc = frm.insCustGrpDesc.value;
			var insCustDesc = frm.insCustDesc.value;
			cell4.innerHTML="<input type='text' name='payerGrpCode_"+index+"' id='payerGrpCode_"+index+"' value='"+insCustGrp+"' size='2' onBlur='payerGrpCodeLookUp(payerGrpDesc_"+index+",this,\""+index+"\")' ><input type='text' name = 'payerGrpDesc_"+index+"' id='payerGrpDesc_"+index+"' size='10' maxlength='15' onBlur='payerGrpDescLookUp(this,payerGrpCode_"+index+",\""+index+"\")' value='"+insCustGrpDesc+"'><INPUT type='hidden' name='payerGrpCode_temp_"+index+"' id='payerGrpCode_temp_"+index+"' value=''><INPUT type='hidden' name='payerGrpDesc_temp_"+index+"' id='payerGrpDesc_temp_"+index+"' value=''><input type='button' name='payerGrp_button_"+index+"' id='payerGrp_button_"+index+"' class='button' value='?'  onclick='payerGrpLookUp(payerGrpDesc_"+index+",payerGrpCode_"+index+",\""+index+"\");'>";
			cell5.innerHTML="<input type='text' name='payerCode_"+index+"' id='payerCode_"+index+"' value='"+insCust+"' size='2' onBlur='payerCodeLookUp(payerDesc_"+index+",this,payerGrpCode_"+index+",\""+index+"\")' ><input type='text' name = 'payerDesc_"+index+"' id='payerDesc_"+index+"' size='10' maxlength='15' onBlur='payerDescLookUp(this,payerCode_"+index+",payerGrpCode_"+index+",\""+index+"\")' value='"+insCustDesc+"'><INPUT type='hidden' name='payerCode_temp_"+index+"' id='payerCode_temp_"+index+"' value=''><INPUT type='hidden' name='payerDesc_temp_"+index+"' id='payerDesc_temp_"+index+"' value=''><input type='button' name='payer_button_"+index+"' id='payer_button_"+index+"' class='button' value='?'  onclick='payerLookUp(payerDesc_"+index+",payerCode_"+index+",payerGrpCode_"+index+",\""+index+"\")'>";
		}
		else{
			cell4.innerHTML="<input type='text' name='payerGrpCode_"+index+"' id='payerGrpCode_"+index+"' value='' size='2' onBlur='payerGrpCodeLookUp(payerGrpDesc_"+index+",this,\""+index+"\")'><input type='text' name = 'payerGrpDesc_"+index+"' id='payerGrpDesc_"+index+"' size='10' maxlength='15' onBlur='payerGrpDescLookUp(this,payerGrpCode_"+index+",\""+index+"\")' value=''><INPUT type='hidden' name='payerGrpCode_temp_"+index+"' id='payerGrpCode_temp_"+index+"' value=''><INPUT type='hidden' name='payerGrpDesc_temp_"+index+"' id='payerGrpDesc_temp_"+index+"' value=''><input type='button' name='payerGrp_button_"+index+"' id='payerGrp_button_"+index+"' class='button' value='?' onclick='payerGrpLookUp(payerGrpDesc_"+index+",payerGrpCode_"+index+",\""+index+"\");'>";
			cell5.innerHTML="<input type='text' name='payerCode_"+index+"' id='payerCode_"+index+"' value='' size='2' onBlur='payerCodeLookUp(payerDesc_"+index+",this,payerGrpCode_"+index+",\""+index+"\")'><input type='text' name = 'payerDesc_"+index+"' id='payerDesc_"+index+"'  size='10' maxlength='15' onBlur='payerDescLookUp(this,payerCode_"+index+",payerGrpCode_"+index+",\""+index+"\")' value=''><INPUT type='hidden' name='payerCode_temp_"+index+"' id='payerCode_temp_"+index+"' value=''><INPUT type='hidden' name='payerDesc_temp_"+index+"' id='payerDesc_temp_"+index+"' value=''><input type='button' name='payer_button_"+index+"' id='payer_button_"+index+"' class='button' value='?' onclick='payerLookUp(payerDesc_"+index+",payerCode_"+index+",payerGrpCode_"+index+",\""+index+"\")'>";
		}
		//Added by Rajesh V for CRF - 140
		if(function_id=="EBL_PACKAGE_SUBS" || function_id=="ADMISSION"){
			/* Added V180316-Aravindh/MMS-DM-SCF-0493 -> '|| site_spec == true'*/
			if(site_spec=="true" || site_spec == true)
			{											
				cell6.innerHTML="<input type='text' name='fromDate_"+index+"' id='fromDate_"+index+"'  size='15' maxlength='20'  onBlur= 'callvalidate(\""+index+"\",\""+function_id+"\");' ><img id = 'fromDate__img_"+index+"' name='fromDate__img_"+index+"' src='../../eCommon/images/CommonCalendar.gif' onClick			=\"return showCalendar('fromDate_"+index+"','dd/mm/yyyy hh:mm:ss');\">";
			}
			else
			{
				cell6.innerHTML="<input type='text' name='fromDate_"+index+"'  id='fromDate_"+index+"' size='15' maxlength='20'  onBlur= 'callvalidate(\""+index+"\",\""+function_id+"\");' ><img id = 'fromDate__img_"+index+"' name='fromDate__img_"+index+"' src='../../eCommon/images/CommonCalendar.gif' onClick			=\"return showCalendar('fromDate_"+index+"','dd/mm/yyyy');\">";
			}			
		}else{
			/* Added V180316-Aravindh/MMS-DM-SCF-0493 -> '|| site_spec == true'*/
			if(site_spec=="true" || site_spec == true)
			{
				cell6.innerHTML="<input type='text' name='fromDate_"+index+"'  id='fromDate_"+index+"' size='15' maxlength='20'  onBlur= 'callvalidate(\""+index+"\",\""+function_id+"\");';><img id = 'fromDate_img_"+index+"' name='fromDate_img_"+index+"'	 src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('fromDate_"+index+"','dd/mm/yyyy hh:mm:ss');\" STYLE='display:inline;'>";
			}
			else
			{
				cell6.innerHTML="<input type='text' name='fromDate_"+index+"'  id='fromDate_"+index+"' size='15' maxlength='20'  onBlur= 'callvalidate(\""+index+"\",\""+function_id+"\");';><img id = 'fromDate_img_"+index+"' name='fromDate_img_"+index+"'	 src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('fromDate_"+index+"','dd/mm/yyyy');\" STYLE='display:inline;'>";					
			}					
		}			
		cell7.innerHTML="<input type='text' name='toDate_"+index+"' id='toDate_"+index+"' size='15' maxlength='20'  ReadOnly />";
		cell8.innerHTML="<input type='text' name='pkgAmt_"+index+"' id='pkgAmt_"+index+"' size='10' maxlength='10' />";
		//Added V171212-Gayathri/MMS-DM-CRF-0118
		if(SiteSpecific_VAT=="Y"){
			cell9.innerHTML="<input type='text' name='addl_charge_"+index+"' id='addl_charge_"+index+"' size='10' maxlength='10' />";			
			cell10.innerHTML="<input type='text' name='episodeType_"+index+"' id='episodeType_"+index+"' size='11' maxlength='11' onBlur='putdeci(this);' /><input type='hidden' name='strOPYN_"+index+"' id='strOPYN_"+index+"' value=''><input type='hidden' name='strEMYN_"+index+"' id='strEMYN_"+index+"' value=''><input type='hidden' name='strIPYN_"+index+"' id='strIPYN_"+index+"' value=''><input type='hidden' name='strDCYN_"+index+"' id='strDCYN_"+index+"' value=''>";		
			if(siteBLpractYN == "Y"){
				cell11.innerHTML="<input type='text' name='practitioner_name"+index+"' id='practitioner_name"+index+"' size='10' value='' onBlur='callPractSearch(practitioner_id"+index+",practitioner_name"+index+",\""+index+"\")'>&nbsp;<input type='hidden' name='practitioner_id"+index+"' id='practitioner_id"+index+"' value=''>&nbsp;<input type='button' class='button' name='generic_search"+index+"' id='generic_search"+index+"' value='?' onclick='callPractSearch(practitioner_id"+index+",practitioner_name"+index+",\""+index+"\");'><img src='../../eCommon/images/mandatory.gif'>";
			}else{
				cell11.innerHTML="<input type='text' name='practitioner_name"+index+"' id='practitioner_name"+index+"' size='10' value='' onBlur='callPractSearch(practitioner_id"+index+",practitioner_name"+index+",\""+index+"\")'>&nbsp;<input type='hidden' name='practitioner_id"+index+"' id='practitioner_id"+index+"' value=''>&nbsp;<input type='button' class='button' name='generic_search"+index+"' id='generic_search"+index+"' value='?' onclick='callPractSearch(practitioner_id"+index+",practitioner_name"+index+",\""+index+"\");'>";
			}
			if(function_id=="EBL_PACKAGE_SUBS")
			{
				parent.PkgSubscriptionDtls.document.frmPkgSubs.total_records.value=rowCount-1;
			}else{				
				document.forms[0].total_records.value=rowCount-1;
			}
		}
		//Added V171212-Gayathri/MMS-DM-CRF-0118			
		else{				
			cell9.innerHTML="<input type='text' name='episodeType_"+index+"' id='episodeType_"+index+"' size='11' maxlength='11' onBlur='putdeci(this);' /><input type='hidden' name='strOPYN_"+index+"' id='strOPYN_"+index+"' value=''><input type='hidden' name='strEMYN_"+index+"' id='strEMYN_"+index+"' value=''><input type='hidden' name='strIPYN_"+index+"' id='strIPYN_"+index+"' value=''><input type='hidden' name='strDCYN_"+index+"' id='strDCYN_"+index+"' value=''>";
		
			if(siteBLpractYN == "Y"){
				// align change against 33717 on 03-07-12 by MuthuN
				cell10.innerHTML="<input type='text' name='practitioner_name"+index+"' id='practitioner_name"+index+"' size='10' value='' onBlur='callPractSearch(practitioner_id"+index+",practitioner_name"+index+",\""+index+"\")'><input type='hidden' name='practitioner_id"+index+"' id='practitioner_id"+index+"' value=''>&nbsp;<input type='button' class='button' name='generic_search"+index+"' id='generic_search"+index+"' value='?' onclick='callPractSearch(practitioner_id"+index+",practitioner_name"+index+",\""+index+"\");'><img src='../../eCommon/images/mandatory.gif'>";
			} else {
				cell10.innerHTML="<input type='text' name='practitioner_name"+index+"' id='practitioner_name"+index+"' size='10' value='' onBlur='callPractSearch(practitioner_id"+index+",practitioner_name"+index+",\""+index+"\")'><input type='hidden' name='practitioner_id"+index+"' id='practitioner_id"+index+"' value=''>&nbsp;<input type='button' class='button' name='generic_search"+index+"' id='generic_search"+index+"' value='?' onclick='callPractSearch(practitioner_id"+index+",practitioner_name"+index+",\""+index+"\");'>";
			}
				
			if(function_id=="EBL_PACKAGE_SUBS")
			{
				parent.PkgSubscriptionDtls.document.frmPkgSubs.total_records.value=rowCount-1;
			}else{				
				document.forms[0].total_records.value=rowCount-1;
			}				
		}
	}else { 	//Ended By Shikha For GHL-CRF-0520.1
		//Added by Rajesh V for CRF - 140
		if(true){
			var frm = document.frmPkgSubs;
			var insCustGrp = frm.insCustGrp.value;
			var insCust = frm.insCust.value;
			var insCustGrpDesc = frm.insCustGrpDesc.value;
			var insCustDesc = frm.insCustDesc.value;
			cell3.innerHTML="<input type='text' name='payerGrpCode_"+index+"' id='payerGrpCode_"+index+"' value='"+insCustGrp+"' size='2' onBlur='payerGrpCodeLookUp(payerGrpDesc_"+index+",this,\""+index+"\")' ><input type='text' name = 'payerGrpDesc_"+index+"' id='payerGrpDesc_"+index+"' size='10' maxlength='15' onBlur='payerGrpDescLookUp(this,payerGrpCode_"+index+",\""+index+"\")' value='"+insCustGrpDesc+"'><INPUT type='hidden' name='payerGrpCode_temp_"+index+"' id='payerGrpCode_temp_"+index+"' value=''><INPUT type='hidden' name='payerGrpDesc_temp_"+index+"' id='payerGrpDesc_temp_"+index+"' value=''><input type='button' name='payerGrp_button_"+index+"' id='payerGrp_button_"+index+"' class='button' value='?'  onclick='payerGrpLookUp(payerGrpDesc_"+index+",payerGrpCode_"+index+",\""+index+"\");'>";
			cell4.innerHTML="<input type='text' name='payerCode_"+index+"' id='payerCode_"+index+"' value='"+insCust+"' size='2' onBlur='payerCodeLookUp(payerDesc_"+index+",this,payerGrpCode_"+index+",\""+index+"\")' ><input type='text' name = 'payerDesc_"+index+"' size='10' maxlength='15' onBlur='payerDescLookUp(this,payerCode_"+index+",payerGrpCode_"+index+",\""+index+"\")' value='"+insCustDesc+"'><INPUT type='hidden' name='payerCode_temp_"+index+"' id='payerCode_temp_"+index+"' value=''><INPUT type='hidden' name='payerDesc_temp_"+index+"' id='payerDesc_temp_"+index+"' value=''><input type='button' name='payer_button_"+index+"' id='payer_button_"+index+"' class='button' value='?'  onclick='payerLookUp(payerDesc_"+index+",payerCode_"+index+",payerGrpCode_"+index+",\""+index+"\")'>";
		}
		else{
			cell3.innerHTML="<input type='text' name='payerGrpCode_"+index+"' id='payerGrpCode_"+index+"' value='' size='2' onBlur='payerGrpCodeLookUp(payerGrpDesc_"+index+",this,\""+index+"\")'><input type='text' name = 'payerGrpDesc_"+index+"' id='payerGrpDesc_"+index+"' size='10' maxlength='15' onBlur='payerGrpDescLookUp(this,payerGrpCode_"+index+",\""+index+"\")' value=''><INPUT type='hidden' name='payerGrpCode_temp_"+index+"' id='payerGrpCode_temp_"+index+"' value=''><INPUT type='hidden' name='payerGrpDesc_temp_"+index+"' id='payerGrpDesc_temp_"+index+"' value=''><input type='button' name='payerGrp_button_"+index+"' id='payerGrp_button_"+index+"' class='button' value='?' onclick='payerGrpLookUp(payerGrpDesc_"+index+",payerGrpCode_"+index+",\""+index+"\");'>";
			cell4.innerHTML="<input type='text' name='payerCode_"+index+"' id='payerCode_"+index+"' value='' size='2' onBlur='payerCodeLookUp(payerDesc_"+index+",this,payerGrpCode_"+index+",\""+index+"\")'>&nbsp;<input type='text' name = 'payerDesc_"+index+"' id='payerDesc_"+index+"' size='10' maxlength='15' onBlur='payerDescLookUp(this,payerCode_"+index+",payerGrpCode_"+index+",\""+index+"\")' value=''><INPUT type='hidden' name='payerCode_temp_"+index+"' id='payerCode_temp_"+index+"' value=''><INPUT type='hidden' name='payerDesc_temp_"+index+"' id='payerDesc_temp_"+index+"' value=''><input type='button' name='payer_button_"+index+"' id='payer_button_"+index+"' class='button' value='?' onclick='payerLookUp(payerDesc_"+index+",payerCode_"+index+",payerGrpCode_"+index+",\""+index+"\")'>";
		}
		//Added by Rajesh V for CRF - 140
		if(function_id=="EBL_PACKAGE_SUBS" || function_id=="ADMISSION")			{
			/* Added V180316-Aravindh/MMS-DM-SCF-0493 -> '|| site_spec == true'*/
			if(site_spec=="true" || site_spec == true)
			{
				//cell5.innerHTML="<input type='text' name='fromDate_"+index+"' id='fromDate_"+index+"' id='fromDate_"+index+"' size='15' maxlength='20'  onBlur= 'isValidDateTime(this)' callvalidate(\""+index+"\",\""+function_id+"\"); ; ><img id = 'fromDate__img_"+index+"' name='fromDate__img_"+index+"' src='../../eCommon/images/CommonCalendar.gif' onClick			=showCalendar_LocalDt('fromDate_"+index+"');>";											
				cell5.innerHTML="<input type='text' name='fromDate_"+index+"'  id='fromDate_"+index+"' size='15' maxlength='20'   onBlur= 'callvalidate(\""+index+"\",\""+function_id+"\");' ><img id = 'fromDate__img_"+index+"' name='fromDate__img_"+index+"' src='../../eCommon/images/CommonCalendar.gif' onClick			=\"return showCalendar('fromDate_"+index+"','dd/mm/yyyy hh:mm:ss');\">";
			}
			else
			{
				cell5.innerHTML="<input type='text' name='fromDate_"+index+"'  id='fromDate_"+index+"' size='15' maxlength='20'   onBlur= 'callvalidate(\""+index+"\",\""+function_id+"\");' ><img id = 'fromDate__img_"+index+"' name='fromDate__img_"+index+"' src='../../eCommon/images/CommonCalendar.gif' onClick			=\"return showCalendar('fromDate_"+index+"','dd/mm/yyyy');\">";
			}			
		}else{
			/* Added V180316-Aravindh/MMS-DM-SCF-0493 -> '|| site_spec == true'*/
			if(site_spec=="true" || site_spec == true)
			{
				cell5.innerHTML="<input type='text' name='fromDate_"+index+"' ' id='fromDate_"+index+"' size='15' maxlength='20'   onBlur= 'callvalidate(\""+index+"\",\""+function_id+"\");';><img id = 'fromDate_img_"+index+"' name='fromDate_img_"+index+"'	 src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('fromDate_"+index+"','dd/mm/yyyy hh:mm:ss');\" STYLE='display:inline;'>";
			}
			else
			{
				cell5.innerHTML="<input type='text' name='fromDate_"+index+"'  id='fromDate_"+index+"'  size='15' maxlength='20'  onBlur= 'callvalidate(\""+index+"\",\""+function_id+"\");';><img id = 'fromDate_img_"+index+"' name='fromDate_img_"+index+"'	 src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('fromDate_"+index+"','dd/mm/yyyy');\" STYLE='display:inline;'>";					
			}					
		}			
		cell6.innerHTML="<input type='text' name='toDate_"+index+"' id='toDate_"+index+"' size='15' maxlength='20'  ReadOnly />";
		cell7.innerHTML="<input type='text' name='pkgAmt_"+index+"' id='pkgAmt_"+index+"' size='10' maxlength='10' />";
		//Added V171212-Gayathri/MMS-DM-CRF-0118
		if(SiteSpecific_VAT=="Y"){
			cell8.innerHTML="<input type='text' name='addl_charge_"+index+"' id='addl_charge_"+index+"' size='10' maxlength='10' />";
		
			cell9.innerHTML="<input type='text' name='episodeType_"+index+"' id='episodeType_"+index+"' size='11' maxlength='11' onBlur='putdeci(this);' /><input type='hidden' name='strOPYN_"+index+"' id='strOPYN_"+index+"' value=''><input type='hidden' name='strEMYN_"+index+"' id='strEMYN_"+index+"' value=''><input type='hidden' name='strIPYN_"+index+"' id='strIPYN_"+index+"' value=''><input type='hidden' name='strDCYN_"+index+"' id='strDCYN_"+index+"' value=''>";
			
			if(siteBLpractYN == "Y"){
				cell10.innerHTML="<input type='text' name='practitioner_name"+index+"' id='practitioner_name"+index+"' size='10' value='' onBlur='callPractSearch(practitioner_id"+index+",practitioner_name"+index+",\""+index+"\")'><input type='hidden' name='practitioner_id"+index+"' id='practitioner_id"+index+"' value=''>&nbsp;<input type='button' class='button' name='generic_search"+index+"' id='generic_search"+index+"' value='?' onclick='callPractSearch(practitioner_id"+index+",practitioner_name"+index+",\""+index+"\");'><img src='../../eCommon/images/mandatory.gif'>";
			} else {
				cell10.innerHTML="<input type='text' name='practitioner_name"+index+"' id='practitioner_name"+index+"' size='10' value='' onBlur='callPractSearch(practitioner_id"+index+",practitioner_name"+index+",\""+index+"\")'><input type='hidden' name='practitioner_id"+index+"' id='practitioner_id"+index+"' value=''>&nbsp;<input type='button' class='button' name='generic_search"+index+"' id='generic_search"+index+"' value='?' onclick='callPractSearch(practitioner_id"+index+",practitioner_name"+index+",\""+index+"\");'>";
			}

			if(function_id=="EBL_PACKAGE_SUBS")
			{
				parent.PkgSubscriptionDtls.document.frmPkgSubs.total_records.value=rowCount-1;
			}else{				
				document.forms[0].total_records.value=rowCount-1;
			}
		}
		//Added V171212-Gayathri/MMS-DM-CRF-0118
		else{
				
			cell8.innerHTML="<input type='text' name='episodeType_"+index+"' id='episodeType_"+index+"' size='11' maxlength='11' onBlur='putdeci(this);' /><input type='hidden' name='strOPYN_"+index+"' id='strOPYN_"+index+"' value=''><input type='hidden' name='strEMYN_"+index+"' id='strEMYN_"+index+"' value=''><input type='hidden' name='strIPYN_"+index+"' id='strIPYN_"+index+"' value=''><input type='hidden' name='strDCYN_"+index+"' id='strDCYN_"+index+"' value=''>";
				
			// align change against 33717 on 03-07-12 by MuthuN
				
			if(siteBLpractYN == "Y"){
				cell9.innerHTML="<input type='text' name='practitioner_name"+index+"' id='practitioner_name"+index+"' size='10' value='' onBlur='callPractSearch(practitioner_id"+index+",practitioner_name"+index+",\""+index+"\")'><input type='hidden' name='practitioner_id"+index+"' id='practitioner_id"+index+"' value=''>&nbsp;<input type='button' class='button' name='generic_search"+index+"' id='generic_search"+index+"' value='?' onclick='callPractSearch(practitioner_id"+index+",practitioner_name"+index+",\""+index+"\");'><img src='../../eCommon/images/mandatory.gif'>";
			} else {
				cell9.innerHTML="<input type='text' name='practitioner_name"+index+"' id='practitioner_name"+index+"' size='10' value='' onBlur='callPractSearch(practitioner_id"+index+",practitioner_name"+index+",\""+index+"\")'><input type='hidden' name='practitioner_id"+index+"' id='practitioner_id"+index+"' value=''>&nbsp;<input type='button' class='button' name='generic_search"+index+"' id='generic_search"+index+"' value='?' onclick='callPractSearch(practitioner_id"+index+",practitioner_name"+index+",\""+index+"\");'>";
			}

			if(function_id=="EBL_PACKAGE_SUBS")
			{
				parent.PkgSubscriptionDtls.document.frmPkgSubs.total_records.value=rowCount-1;
			}else{				
				document.forms[0].total_records.value=rowCount-1;
			}
		}
	}
}

function callSysdate(rec_count)
{
	var function_id =	eval("document.forms[0].function_id").value;	
	
	if (function_id=="VISIT_REGISTRATION" || function_id=="ADMISSION")
	{
		if(eval("document.forms[0].fromDate_"+rec_count).value == ''){
		var enctrDate =	eval("document.forms[0].sysDate").value;		
		eval("document.forms[0].fromDate_"+rec_count).value=enctrDate;
		}
		//eval("document.forms[0].fromDate_"+rec_count).select();	
		//eval("document.getElementById("fromDate__img_")"+rec_count).style.display='none';
	}

}
//parent.PkgSubscriptionHeader.document.frmPkgSubs.total_records.value = rowCount;
//For Clearing the bean by putting package code
/*function clearBean(val)
{
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "packageCode=\"" + val + "\" " ;
	xmlStr +=" /></root>";
	var updation=formValidation(xmlStr,"CLEAR_BEAN");
}
*/

function showCalendar_eff(Val1)
{				
	return showCalendar(Val1);				
}

function validDateChk(obj)
{	
	var locale=document.forms[0].locale.value;		
	if(obj.value!="")
	{
	if(validDate(obj.value,'DMY',locale))
	{
		return true;
	}
	else{
		alert(getMessage("INVALID_DATE_FMT","SM"));
		//obj.select();
		obj.value="";
		return false;
		}
	}
	else
	{
		return true;
	}
}

function toFromdateChk(obj)
{	
  if(!(obj.value==""))
	{
		var locale=document.forms[0].locale.value;			
		var from_date=document.forms[0].effFromDate.value;
		var to_date=document.forms[0].effToDate.value;
		if(validDateChk(obj))
		{
			
			 if((!isBefore(from_date,to_date,'DMY',locale)))
			   {
					alert(getMessage("BL4115",'BL'));					
					//obj.select();
					obj.value="";
				}
				else{		 
					return false;
					}
		}
	}
	else{
		return false;
		}
}

function CheckForSpecChars_loc(event,obj){
	
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
	if(obj.value.length==0)
	{

		if('_'.indexOf(key)!=-1)
			return false;
	}

    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

function chkSpecial(event,obj)
{
	return CheckForSpecChars_loc(event,obj);

}

function putdeci(object)
{	
	if(object.value!='')
	{
	//var decimal=parent.PkgDefHeader.document.forms[0].noofdecimal.value;
	var decimal=eval(document.frmPkgSubs.noofdecimal).value;	
	putDecimal(object,17,decimal);
	}
}

async function apply()
{
	var patientId=PkgSubscriptionFrame.PkgSubscriptionHeader.document.frmPkgDefHeader.patientId.value;
	var totRec=0;
	//Added against V200119 GHL-CRF-0631
	//var siteBLpractYN = PkgSubscriptionFrame.PkgSubscriptionHeader.document.frmPkgDefHeader.siteBLPkgBlngGrpYN.value; //added against GHL-CRF-0631  commented against KDAH-SCF-0812-TF
	var siteBLpractYN =PkgSubscriptionFrame.PkgSubscriptionDtls.document.frmPkgSubs.pracMandatoryYN.value; //added against KDAH-SCF-0812-TF

	var isPractCode=PkgSubscriptionFrame.PkgSubscriptionDtls.document.frmPkgSubs.practitioner_name0.value;
	var flag="false";
	//var practflag="false";//Commented 28-01-2021
	var practflag=true;//Added 28-01-2021
	//Added against V200119 GHL-CRF-0631	
	
	var submit="false";
	var selectCheckBoxList=PkgSubscriptionFrame.PkgSubscriptionHeader.document.frmPkgDefHeader.selectCheckBoxList.value;
	var isEmptyPackageCode=PkgSubscriptionFrame.PkgSubscriptionDtls.document.frmPkgSubs.packageCode_0.value;	
	
	var messageId=$(PkgSubscriptionFrame.PkgSubscriptionHeader.document).find('#strMessageId').val();
	var messageText=$(PkgSubscriptionFrame.PkgSubscriptionHeader.document).find('#strErrorText').val();
	
	
	if(patientId=="")
	{
		alert(getMessage("BL0002","BL"));
		document.location.reload();
	}
	else if(isEmptyPackageCode=='' && selectCheckBoxList==''){
		alert("Please Select a Package to Subscribe or Associate");
		commontoolbarFrame.location.reload();
	}else{
		
		if(isEmptyPackageCode=='' && selectCheckBoxList!='' ){

			  var noEncounterToAssociate=PkgSubscriptionFrame.PkgSubscriptionHeader.document.frmPkgDefHeader.noEncounterToAssociate.value;

			  if(noEncounterToAssociate=='true'){
			  alert("No Package/Encounter Selected to Associate");
			  commontoolbarFrame.location.reload();
			  return;
			  }
		}
		//MMS-DM-SCF-0083
		var reqId = checkJobStatusForEncounter(patientId);
		if(reqId > 0){
			var dialogHeight= "17" ;
			var dialogWidth	= "37" ;
			var dialogTop = "225" ;
			var center = "1" ;														   
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;	
			retVal = await window.showModalDialog("../../eBL/jsp/BLCheckProcessedCount.jsp?closeDisable=Y&reqId="+reqId,arguments,features); 
			if(retVal != 'Y' && retVal != 'F'){
				alert('Cannot save changes, while financial calculation in progress');
				commontoolbarFrame.location.reload();
				return;
			}
			alert('Financial Calaculation is completed for the Previous Request, Save Again');
			commontoolbarFrame.location.reload();
			return;
		}
		//MMS-DM-SCF-0083
		if(PkgSubscriptionFrame.PkgSubscriptionDtls.document.forms[0].total_records.value!=''){
		totRec=parseInt(PkgSubscriptionFrame.PkgSubscriptionDtls.document.forms[0].total_records.value);
		}
	
		if(totRec>0){
	for(var i=0;i<totRec;i++){
	if(submit=="false"){
	if(eval(PkgSubscriptionFrame.PkgSubscriptionDtls.document.forms[0].packageCode_+i).value !=""){
			//Added V180416-Gayathri/MMS-DM-SCF-0399/Starts
		if(eval(PkgSubscriptionFrame.PkgSubscriptionDtls.document.forms[0].payerGrpCode_+i).value !=""){
			if(eval(PkgSubscriptionFrame.PkgSubscriptionDtls.document.forms[0].payerCode_+i).value !=""){
								
				flag="true";
				//submit="true";
	}		
			else{
				alert(getMessage("BL0746","BL"));
				}
								
								
		}
		else if(eval(PkgSubscriptionFrame.PkgSubscriptionDtls.document.forms[0].payerGrpCode_+i).value ==""){
							
			if(eval(PkgSubscriptionFrame.PkgSubscriptionDtls.document.forms[0].payerCode_+i).value !=""){
								
				alert(getMessage("BL0746","BL"));
								
				eval(PkgSubscriptionFrame.PkgSubscriptionDtls.document.forms[0].payerCode_+i).value="";
				eval(PkgSubscriptionFrame.PkgSubscriptionDtls.document.forms[0].payerDesc_+i).value="";
				eval(PkgSubscriptionFrame.PkgSubscriptionDtls.document.forms[0].pkgAmt_+i).value="";
				eval(PkgSubscriptionFrame.PkgSubscriptionDtls.document.forms[0].addl_charge_+i).value="";
			}
							
			else{							
				if(eval(PkgSubscriptionFrame.PkgSubscriptionDtls.document.forms[0].pkgAmt_+i).value==""){								
				}								
				else
					flag="true";	
					//submit="true";	
			}
							
							
							
		}
						
		else{
			flag="true";
			//submit="true";	
		}						
	}	
          //Added V180416-Gayathri/MMS-DM-SCF-0399/Ends
	}
	//added against V200119 GHL-CRF-0631 starts
	if(siteBLpractYN == "Y" && eval(PkgSubscriptionFrame.PkgSubscriptionDtls.document.forms[0].practitioner_name+i).value ==""){
			alert("APP-BL0926 Practitioner Cannot be Blank");
			//practflag="false"; //Commented 28-01-2021
			practflag=false; //Added 28-01-2021					
		}
		else{ 
			//Added 28-01-2021
			if(practflag)
			practflag=true;					
			//practflag="true"; //Commented 28-01-2021
			//Added 28-01-2021
		}							
		}
		
		if(siteBLpractYN == "Y" && flag=="true" && practflag){
			submit="true";
		}
		else if(siteBLpractYN == "N" && flag=="true")
		{
			submit="true";
		}
		else{
			submit="false";
		}
		//added against V200119 GHL-CRF-0631 ends
		var selectCheckBoxList=PkgSubscriptionFrame.PkgSubscriptionHeader.document.frmPkgDefHeader.selectCheckBoxList.value;
		if(selectCheckBoxList!=''){
			submit="true";
		}
		if(submit=="true")
		{			
			if(messageId!='' || messageText!='')
			{
				if(messageId!='')
				{
					alert(messageId);
					commontoolbarFrame.location.reload();
					return;
				}
				else if(messageText!='')
				{
					alert(messageText);
					commontoolbarFrame.location.reload();
					return;
				}
			}			
			PkgSubscriptionFrame.PkgSubscriptionDtls.document.forms[0].submit();			
		}
	}	
		if(submit=="false"){
			messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';	
		}
	}
}

async function getPatID()
{	
//alert("1");
		var pat_id=await PatientSearch();		
		if( pat_id != null )						
		document.forms[0].patientId.value = pat_id ;					
		document.forms[0].patientId.focus ();					
}

async function onSuccess1(reqId)
{	
	var PackageSeqno = parent.PkgSubscriptionHeader.document.frmPkgDefHeader.strPackageSeqno.value;
	var strpkgCode="";
	var strpkgamt="";
	var packseqno = new Array();
	packseqno = PackageSeqno.split("^");
	var function_id="PKG_BILLING";
	var tot_package_amt=0.0;
	var strblngclass="";

	for(var i=0;i<packseqno.length-1;i++)
	{			
		var pkgAmount = eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.pkgAmt_"+i).value;		
		var pkgCode   = eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.packageCode_"+i).value;
		var blng_class =  eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.blng_class_code"+i).value;
		var  pkg_amout =  eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.pkgAmt_"+i).value;		
		tot_package_amt =parseFloat(tot_package_amt)+parseFloat(pkgAmount);
		strpkgCode = strpkgCode+"^"+pkgCode;
		strpkgamt =strpkgamt+"^"+pkg_amout;		
		strblngclass=strblngclass+"^"+blng_class;
	}
	//Add for NMC-JD-CRF-0084 05-02-2021 Starts
	var facilityId= parent.PkgSubscriptionHeader.document.frmPkgDefHeader.facilityId.value;
	var function_id1= parent.PkgSubscriptionHeader.document.frmPkgDefHeader.function_id.value;//14240
	//var patientid1= parent.PkgSubscriptionHeader.document.frmPkgDefHeader.patientId.value;
	var blPkgDepositSubscription= parent.PkgSubscriptionHeader.document.frmPkgDefHeader.blPkgDepositSubscription.value;
	var sysdate= parent.PkgSubscriptionHeader.document.frmPkgDefHeader.sysdateparam.value;
	//Add for NMC-JD-CRF-0084 05-02-2021 Ends
	if(parseInt(tot_package_amt)>0 )//|| packseqno[i]!="")
	{
		var patientid= parent.PkgSubscriptionHeader.document.frmPkgDefHeader.patientId.value;
		var eid="";
		var episodetype="R";
		var retVal="";
		var center='1';
		var dialogTop	= '70';
		var dialogHeight	= '100vh';
		var dialogWidth		= '90vw';
		var features		= 'dialogTop:' + dialogTop + '; dialogHeight:' + dialogHeight +'; center: ' + center + '; dialogWidth: ' + dialogWidth + '; status=no' ;
		var  arguments 		= "";
		var  column_sizes  		= escape("");
		var  column_descriptions  	= "";
		var msg="";
		
		param="column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&patient_id="+patientid+"&encounter_id="+eid+"&episode_type="+episodetype+"&episode_id="+eid+"&packseqno="+PackageSeqno+"&function_id="+function_id+"&pkgAmount="+strpkgamt+"&pkgCode="+strpkgCode+"&tot_package_amt="+tot_package_amt+"&blng_class="+strblngclass+"&modeOfCall=Subscription";		
	var retvalYN=""; //changed on 21-02-2021
	//add for NMC-JD-CRF-0084 05-02-2021 STARTS
	if(blPkgDepositSubscription=="true")
	{
	retvalYN=pkgDepositpkgParmChk(strpkgCode,function_id1,facilityId,sysdate);   //changed on 21-02-2021
		if(retvalYN=='Y')
		{
			retVal=await top.window.showModalDialog("../../eBL/jsp/BLEnterReceiptRefundFrame.jsp?"+param,arguments,features);
			while(retVal==null || retVal =="" || retVal==undefined || retVal=='undefined')
			{			
				retVal= await top.window.showModalDialog("../../eBL/jsp/BLEnterReceiptRefundFrame.jsp?"+param,arguments,features);		
			}//Commented by Palani on 11-02-2021
		}
	}
	else
		{
			retVal=await top.window.showModalDialog("../../eBL/jsp/BLEnterReceiptRefundFrame.jsp?"+param,arguments,features);	
		//Added by Palani on 11-02-2021
		while(retVal==null || retVal =="" || retVal==undefined || retVal=='undefined')
		{
			
					retVal=await top.window.showModalDialog("../../eBL/jsp/BLEnterReceiptRefundFrame.jsp?"+param,arguments,features);		
		}
		}		
	//}//Commented by Palani on 11-02-2021
}
	//add for NMC-JD-CRF-0084 05-02-2021 ENDS
	/*for(var i=0;i<packseqno.length-1;i++)
	{		
		//alert(" packseqno["+i+"]="+ packseqno[i])
		var pkgAmount = eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.pkgAmt_"+i).value;		
		var pkgCode   = eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.packageCode_"+i).value;
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "packseqno=\"" + packseqno[i] + "\" " ;					
		xmlStr+= "pkgCode=\"" + pkgCode + "\" " ;					
		xmlStr+= "pkgAmount=\"" + pkgAmount + "\" " ;											
		xmlStr +=" /></root>";
		var temp_jsp="PkgSubscriptionValidation.jsp?func_mode=GET_PKG_DEPOSIT_DTLS&function_id="+function_id;					
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		var responseText=trimString(xmlHttp.responseText );	
	var patientid=parent.PkgSubscriptionHeader.document.frmPkgDefHeader.patientId.value;
	var eid="";
	var episodetype="O";
	var retVal="";
	var center='1';
	var dialogTop	= '70';
	var dialogHeight	= '42';
	var dialogWidth		= '70';
	var features		= 'dialogTop:' + dialogTop + '; dialogHeight:' + dialogHeight +'; center: ' + center + '; dialogWidth: ' + dialogWidth + '; status=no' ;
	var  arguments 		= "";
	var  column_sizes  		= escape("");
	var  column_descriptions  	= "";
	var msg="";
	if(parseInt(pkgAmount)>0 )//|| packseqno[i]!="")
		{		
			var param="column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&patient_id="+patientid+"&encounter_id="+eid+"&episode_type="+episodetype+"&episode_id="+eid+"&packseqno="+packseqno[i]+"&function_id="+function_id+"&pkgAmount="+pkgAmount+"&pkgCode="+pkgCode;
			retVal=window.showModalDialog("../../eBL/jsp/BLEnterReceiptRefundFrame.jsp?"+param,arguments,features);		
			
			if( responseText=='Y' && retVal!="C"){
				while(retVal!="Y" && retVal!="C" ){				
					var param="column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&patient_id="+patientid+"&encounter_id="+eid+"&episode_type="+episodetype+"&episode_id="+eid+"&packseqno="+packseqno[i]+"&function_id="+function_id+"&pkgAmount="+pkgAmount+"&pkgCode="+pkgCode;
					retVal=window.showModalDialog("../../eBL/jsp/BLEnterReceiptRefundFrame.jsp?"+param,arguments,features);		
					
				}
			}else{
				retVal="Y";					
			}
		}	
	}*/
	if(retVal =="Y")
	{	
		if(document.forms[0].function_id.value=="EBL_PACKAGE_SUBS"){
			if(reqId>0){
				progressInBackground(reqId);
			}
			else{
				msg=getMessage("RECORD_INSERTED","SM")		
				parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;	
				parent.parent.frames[1].location.reload();
			}			
		}else{			
			alert(getMessage("RECORD_INSERTED","SM"));	
			//parent.parent.document.location.reload();
			parent.parent.frames[1].location.reload();
		}		
	}
	else if(retVal=="C"){
		if(document.forms[0].function_id.value=="EBL_PACKAGE_SUBS"){
			msg=getMessage("RECORD_INSERTED","SM")		
			parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;	
			parent.parent.frames[1].location.reload();
		}else{			
			alert(getMessage("RECORD_INSERTED","SM"));	
			//parent.parent.document.location.reload();
			parent.parent.frames[1].location.reload();
		}
	}
	else{ //changed on 21-02-2021
		if(parseInt(tot_package_amt)>0 ){
			
			if(document.forms[0].function_id.value=="EBL_PACKAGE_SUBS"){
				if(retvalYN=="Y")
			{
			
				msg="Bill Already Generated";
				parent.parent.messageFrame.location.href='../eCommon/jsp/error.jsp?err_num='+msg;	
				parent.parent.frames[1].location.reload();
			}
			else
			{
				msg="APP-SM0070 Operation Completed Successfully...";
				parent.parent.messageFrame.location.href='../eCommon/jsp/error.jsp?err_num='+msg;	
				parent.parent.frames[1].location.reload();
				}	
			}
		}
		
		else{
			progressInBackground(reqId);
			/*msg=getMessage("RECORD_INSERTED","SM")		
			parent.parent.messageFrame.location.href='../eCommon/jsp/error.jsp?err_num='+msg;	
			parent.parent.frames[1].location.reload();*/
		}		
	}
//	parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+err_mess;
	//}
}

 function progressInBackground(reqId){	
	var msg = '';
	var cnt = 1;
	var status = 'I';				
	status = checkProgress(reqId);
	if(status == 'C'){
		msg=getMessage("RECORD_INSERTED","SM");
		alert(msg);
		//alert('url '+parent.parent.messageFrame.location.href='../eCommon/jsp/error.jsp?err_num='+msg);
		parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;//Added V200907 MUTHUN 3TierAlmoFeature	
		parent.parent.PkgSubscriptionFrame.location.reload();
		parent.parent.commontoolbarFrame.location.reload();
	}
	else if(status == 'F'){
		msg='Recalculation Job Failed';
		alert(msg);
		parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;	
		parent.parent.PkgSubscriptionFrame.location.reload();
		parent.parent.commontoolbarFrame.location.reload();
	}
	else{
		var intr = setInterval(function chkProg(){
			cnt++;
			status = checkProgress(reqId);
			if(status == 'C'){
				clearInterval(intr);
				msg=getMessage("RECORD_INSERTED","SM");
				alert(msg);
				parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;	
				parent.parent.PkgSubscriptionFrame.location.reload();
				parent.parent.commontoolbarFrame.location.reload();
			}
			else if(status == 'F'){
				clearInterval(intr);
				msg='Recalculation Job Failed';
				alert(msg);
				parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;	
				parent.parent.PkgSubscriptionFrame.location.reload();
				parent.parent.commontoolbarFrame.location.reload();
			}
			else if(cnt == 5){
				clearInterval(intr);
				var dialogHeight= "14" ;
				var dialogWidth	= "32" ;
				var dialogTop = "225" ;
				var center = "1" ;														   
				var status="no";
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
				var arguments	= "" ;	
				//var modPatientId = document.getElementById("hiddenPatientId").value;
				retVal =  window.showModalDialog("../../eBL/jsp/BLCheckProcessedCount.jsp?reqId="+reqId,arguments,features); 
				msg=getMessage("RECORD_INSERTED","SM");
				alert(msg);
				parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;	
				parent.parent.PkgSubscriptionFrame.location.reload();
				parent.parent.commontoolbarFrame.location.reload();
			}			
		}, 3000);
	}
}

function checkProgress(reqId){
	var progress = 'I';
	/*
	$.ajax({
		type:"GET",
		url:"../jsp/PkgSubscriptionValidation.jsp?reqId="+reqId,
		data:"func_mode=getProgressStatus",
		dataType:"text",
		async:false,
		success: function(data){
			progress = $.trim(data);
			
		},
		 error: function(data){
			 progress = 'I';
	      }
	});*/
	var temp_jsp="PkgSubscriptionValidation.jsp?func_mode=getProgressStatus&reqId="+reqId;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";				
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var progress=trimString(xmlHttp.responseText);	
	
	return progress;
}

function trimString(sInString) {
	  return sInString.replace(/^\s+|\s+$/g,"");
}

/*function packageLookup(obg,rec_count,clng_evnt)
{	
		var tt="";
		var target			= obg;		
		var retVal			=  new String();
		if(clng_evnt == 'B')
		{
			if( target.value == "")
			{
				target.value = "";
				eval("document.forms[0].packageDesc_"+rec_count).value="";	

				eval("document.forms[0].episodeType_"+rec_count).value="";	
	eval("document.forms[0].fromDate_"+rec_count).value="";	
	eval("document.forms[0].toDate_"+rec_count).value="";	
		eval("document.forms[0].pkgAmt_"+rec_count).value="";
				return;
			}
		}
	
		var dialogTop	= "40";
		var dialogHeight		= "10" ;
		var dialogWidth	= "40" ;
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var search_desc			= "";
		var title			= getLabel("eBL.PACKAGE_DTL.label",'BL');
		var locale  = document.forms[0].locale.value;		
		//var sql1="select  PACKAGE_CODE code,SHORT_DESC description from bl_package_lang_vw where LANGUAGE_ID = '"+locale+"' AND nvl(status,'x') != 'S'  and upper(PACKAGE_CODE) like upper(?) and upper(SHORT_DESC) like upper(?)"; 
		if(eval("document.forms[0].function_id").value=="VISIT_REGISTRATION"){
			var sql1="select  a.PACKAGE_CODE code,a.SHORT_DESC description from bl_package_lang_vw a, bl_package b where a.package_code=b.package_code and a.operating_Facility_id=b.operating_facility_id and nvl(b.order_Catalog_yn,'N')='Y' AND a.LANGUAGE_ID = '"+locale+"' AND nvl(a.status,'x') != 'S'  and upper(a.PACKAGE_CODE) like upper(?) and upper(a.SHORT_DESC) like upper(?)"; 
		}else{
			var sql1="select  a.PACKAGE_CODE code,a.SHORT_DESC description from bl_package_lang_vw a, bl_package b where a.package_code=b.package_code and a.operating_Facility_id=b.operating_facility_id and nvl(b.order_Catalog_yn,'N')='N' AND a.LANGUAGE_ID = '"+locale+"' AND nvl(a.status,'x') != 'S'  and upper(a.PACKAGE_CODE) like upper(?) and upper(a.SHORT_DESC) like upper(?)"; 
		}
		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();
		argArray[0] = sql1;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "2,1";		
		if(target.value=="undefined" ||target.value==null){		
			tt="";
			}else{
			tt=target.value;
			}
		
		argArray[5] = tt;
		argArray[6] = DESC_LINK;
		argArray[7] = DESC_CODE;				
		retArray = CommonLookup( title, argArray );		
		if(retArray != null && retArray !="")
		{
//			target.value=retArray[0];
			eval("document.forms[0].packageCode_"+rec_count).value=retArray[0];	
			eval("document.forms[0].packageDesc_"+rec_count).value=retArray[1];		
		
		}

	if(rec_count==0){
	callSysdate(rec_count);}
if(eval("document.forms[0].packageCode_"+rec_count).value!="")
	{
	checkForDuplicate(eval("document.forms[0].packageCode_"+rec_count).value,rec_count);
	}
}
*/
function callvalidate(rec_count,function_id,calledFrom)
{
	var siteParam=document.forms[0].siteParam.value;
	if(calledFrom=="PkgAssocnExisting")
	{		
		var functionId=$('#functionId').val();
		var xmlString=formXMLString(rec_count,null,calledFrom);
		var updation=formValidation(xmlString,functionId,calledFrom);		
		return true;
	}

	if(calledFrom=='Pkgsubsheader')
	{
		var functionId=$('#function_id').val();	
		var xmlString=formXMLString(rec_count,null,calledFrom);
		var updation=formValidation(xmlString,functionId,calledFrom);		
		return true;		
	}
	
	if(eval("document.forms[0].fromDate_"+rec_count).value!= ""){		
		/* GHL-SCF-1016  Karthik on 8/10/2016 - For Medicity Extra Alert will be thrown to the User if the User Selects any future Date while Subscribing a Package - Starts */
		if(siteParam=='MC'){
			var locale=document.forms[0].locale.value;
			var  selDate=eval("document.forms[0].fromDate_"+rec_count).value;
			selDate=selDate.substring(0,10);
			var sysDate=getCurrentDate("DMY", locale);
			if( isBefore(selDate,sysDate, "DMY" , locale) == false ) {
				var resp = confirm("Package is Subscribed for Future Date. Do You Want to Continue ?");
				if(resp == false ){
					eval("document.forms[0].fromDate_"+rec_count).value='';
					return false;
				}
			}
		}
		/* GHL-SCF-1016  Karthik on 8/10/2016 - For Medicity Extra Alert will be thrown to the User if the User Selects any future Date while Subscribing a Package - Ends */
		
		var result=isValidDateTime(eval("document.forms[0].fromDate_"+rec_count));
		
		if(result==false){
			eval("document.forms[0].fromDate_"+rec_count).value='';
			return false;
		}
	
		if( eval("document.forms[0].fromDate_"+rec_count).value!= "" && eval("document.forms[0].toDate_"+rec_count).value!= "" ){
			
			var fromDate=eval("document.forms[0].fromDate_"+rec_count).value;
			var toDate=eval("document.forms[0].toDate_"+rec_count).value;
			
			 if (isAfter(fromDate, toDate, 'DMYHMS', 'en') ){
				 alert(getMessage("BL4115","BL"));
				 eval("document.forms[0].fromDate_"+rec_count).value="";
				 eval("document.forms[0].toDate_"+rec_count).value="";
				 return false;
			 }
		}
		if(function_id=="EBL_PACKAGE_SUBS")
		{	
			 if(eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.packageCode_"+rec_count).value==""){
				 //alert("Package code cannot be null");
				 alert(getMessage("BL8501",'BL'));
				 eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.fromDate_"+rec_count).value="";
				 return false;
			 }else{	
				
				 //condition added by Vijay for KDAH-SCF-0404
				 if(eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.blng_class_code"+rec_count).value!="" || eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.blng_class_desc"+rec_count).value!=""){
				//var subsFromDate=eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.fromDate_"+rec_count).value;	
			//	if(subsFromDate!=""){
				var xmlString=formXMLString(rec_count,function_id);
					var updation=formValidation(xmlString,function_id);
				 }		
			 }
		 }
		 else{		
			 if(eval("document.frmPkgSubs.packageCode_"+rec_count).value==""){
				// alert("Package code cannot be null");
				alert(getMessage("BL8501",'BL'));
				 eval("document.frmPkgSubs.fromDate_"+rec_count).value="";
				 return false;
			 }
			 else{	
				//var subsFromDate=eval("document.frmPkgSubs.fromDate_"+rec_count).value;	
				//if(subsFromDate!=""){
				var xmlString=formXMLString(rec_count,function_id);
					var updation=formValidation(xmlString,function_id);
					//alert(updation);
			 }
		 }
	}
}

function formXMLString(rec_count,function_id,calledFrom)
{	
	var xmlStr ="<root><SEARCH ";
	if(function_id=="EBL_PACKAGE_SUBS")
	{
		var packageCode=eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.packageCode_"+rec_count).value;	
		var subsFromDate=eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.fromDate_"+rec_count).value;	
		var blng_class_code = eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.blng_class_code"+rec_count).value;//GHL-CRF-0520.1
		var payerGrpCode=eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.payerGrpCode_"+rec_count).value;	
		var payerGrpDesc=eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.payerGrpDesc_"+rec_count).value;	
		var payerCode=eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.payerCode_"+rec_count).value;	
		var episodetype=eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.episodeType_"+rec_count).value;//Added by muthu on 27-6-12
		var practitioner_id=eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.practitioner_id"+rec_count).value; //Added by muthu on 27-6-12
		var practitioner_name=eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.practitioner_name"+rec_count).value; //Added by muthu on 27-6-12
		var payerDesc=eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.payerDesc_"+rec_count).value;
		var pkg_sysdate_dflt = parent.PkgSubscriptionDtls.document.frmPkgSubs.pkg_sysdate_dflt.value;
		var site_spec=parent.PkgSubscriptionDtls.document.getElementById('site_spec').value;
		//Added By Shikha For GHL-CRF-0520.1
		var siteBLPkgBlngGrpYN = eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.siteBLPkgBlngGrpYN.value");		
		if(siteBLPkgBlngGrpYN=="Y"){
			var blngGrpCode=eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.blngGrpCode_"+rec_count).value;	 	
			var blngGrpDesc=eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.blngGrpDesc_"+rec_count).value;
		}
		//Ended By Shikha For GHL-CRF-0520.1
	}
	else if(calledFrom=='PkgAssocnExisting' && function_id==null)
	{
		//return false;
		var packageCode=eval("parent.PkgSubscriptionDtls.document.pkgSubsExistingPkgFrm.pkg_code_hdn"+rec_count).value;	
		var subsFromDate=eval("parent.PkgSubscriptionDtls.document.pkgSubsExistingPkgFrm.from_date"+rec_count).value;	
		var blng_class_code = eval("parent.PkgSubscriptionDtls.document.pkgSubsExistingPkgFrm.blngClassCodeHdn"+rec_count).value
		var payerGrpCode=eval("parent.PkgSubscriptionDtls.document.pkgSubsExistingPkgFrm.payer_group_code"+rec_count).value;	
		//var payerGrpDesc=eval("parent.PkgSubscriptionDtls.document.pkgSubsExistingPkgFrm.payer_group_desc"+rec_count).value;	
		var payerCode=eval("parent.PkgSubscriptionDtls.document.pkgSubsExistingPkgFrm.payer_code"+rec_count).value;	
		var episodetype=$(parent.PkgSubscriptionDtls.document).find('#episode_type'+rec_count).val();	
		//	var episodetype=eval("parent.PkgSubscriptionDtls.document.getElementById('episode_type'"+rec_count)).value;
		var practitioner_id=eval("parent.PkgSubscriptionDtls.document.pkgSubsExistingPkgFrm.practioner_id"+rec_count).value; 
		var practitioner_name=$(parent.PkgSubscriptionDtls.document).find('practioner_name'+rec_count).val(); 
		var payerDesc=$(parent.PkgSubscriptionDtls.document).find('payer_desc'+rec_count).val();
		var pkg_sysdate_dflt = parent.PkgSubscriptionDtls.document.frmPkgSubs.pkg_sysdate_dflt.value;
		var site_spec=parent.PkgSubscriptionDtls.document.getElementById('site_spec').value;	
		//var blngGrpCode=eval("parent.PkgSubscriptionDtls.document.pkgSubsExistingPkgFrm.blngGrpCode_"+rec_count).value;			
	}
	else if(calledFrom=='Pkgsubsheader' && function_id==null)
	{	
		//return false;
		var packageCode=eval("parent.PkgSubscriptionDtls.document.pkgSubsExistingPkgFrm.pkg_code_hdn"+rec_count).value;	
		var subsFromDate=eval("parent.PkgSubscriptionDtls.document.pkgSubsExistingPkgFrm.from_date"+rec_count).value;	
		var blng_class_code ='';// eval("parent.PkgSubscriptionDtls.document.pkgSubsExistingPkgFrm.blngClassCodeHdn"+rec_count).value
		var payerGrpCode='';//eval("parent.PkgSubscriptionDtls.document.pkgSubsExistingPkgFrm.payer_group_code"+rec_count).value;	
		var payerGrpDesc='';//eval("parent.PkgSubscriptionDtls.document.pkgSubsExistingPkgFrm.payer_group_desc"+rec_count).value;	
		var payerCode='';//eval("parent.PkgSubscriptionDtls.document.pkgSubsExistingPkgFrm.payer_code"+rec_count).value;	
		var episodetype=$(parent.PkgSubscriptionDtls.document).find('#episode_type'+rec_count).text();	
		//	var episodetype=eval("parent.PkgSubscriptionDtls.document.getElementById('episode_type'"+rec_count)).value;
		var practitioner_id= ''; //eval("parent.PkgSubscriptionDtls.document.pkgSubsExistingPkgFrm.practioner_id"+rec_count).value; 
		var practitioner_name=$(parent.PkgSubscriptionDtls.document).find('practioner_name'+rec_count).text(); 
		var payerDesc= ''; //$(parent.PkgSubscriptionDtls.document).find('payer_desc'+rec_count).val();
		var pkg_sysdate_dflt = parent.PkgSubscriptionDtls.document.frmPkgSubs.pkg_sysdate_dflt.value;
		var site_spec=parent.PkgSubscriptionDtls.document.getElementById('site_spec').value;
		var blngGrpCode='';		
	}
	else{
		var packageCode=eval("document.frmPkgSubs.packageCode_"+rec_count).value;	
		var subsFromDate=eval("document.frmPkgSubs.fromDate_"+rec_count).value;	
		var blng_class_code=eval("document.frmPkgSubs.blng_class_code"+rec_count).value;	
		var payerGrpCode=eval("document.frmPkgSubs.payerGrpCode_"+rec_count).value;	
		var payerGrpDesc=eval("document.frmPkgSubs.payerGrpDesc_"+rec_count).value;	
		var payerCode=eval("document.frmPkgSubs.payerCode_"+rec_count).value;	
		var payerDesc=eval("document.frmPkgSubs.payerDesc_"+rec_count).value;
		var episodetype=eval("document.frmPkgSubs.episodeType_"+rec_count).value;//Added by muthu on 27-6-12
		var practitioner_id=eval("document.frmPkgSubs.practitioner_id"+rec_count).value; //Added by muthu on 27-6-12
		var practitioner_name=eval("document.frmPkgSubs.practitioner_name"+rec_count).value; //Added by muthu on 27-6-12
		var pkg_sysdate_dflt = /*parent.PkgSubscriptionDtls.*/document.frmPkgSubs.pkg_sysdate_dflt.value;
		var site_spec=document.getElementById('site_spec').value;
		//Added By Shikha For GHL-CRF-0520.1 
		var siteBLPkgBlngGrpYN = eval("document.frmPkgSubs.siteBLPkgBlngGrpYN.value");		
		if(siteBLPkgBlngGrpYN=="Y"){
			var blngGrpCode=eval("document.frmPkgSubs.blngGrpCode_"+rec_count).value;	 	
			var blngGrpDesc=eval("document.frmPkgSubs.blngGrpDesc_"+rec_count).value; 
		}
		//Ended By Shikha For GHL-CRF-0520.1
	}	
	xmlStr+= "packageCode=\"" + packageCode + "\" " ;
	xmlStr+= "rec_count=\"" + rec_count + "\" " ;
	xmlStr+= "subsFromDate=\"" + subsFromDate + "\" " ;
	xmlStr+= "blng_class_code=\"" +blng_class_code+ "\" " ;
	xmlStr+= "payerGrpCode=\"" +payerGrpCode+ "\" " ;
	xmlStr+= "payerGrpDesc=\"" +encodeURIComponent(payerGrpDesc)+"\" " ;
	xmlStr+= "payerCode=\"" +payerCode+ "\" " ;
	xmlStr+= "payerDesc=\"" +encodeURIComponent(payerDesc)+ "\" " ;
	xmlStr+= "episodetype=\"" +episodetype+ "\" " ;
	xmlStr+= "practitioner_id=\"" +practitioner_id+ "\" " ;//Added by muthu on 27-6-12
	xmlStr+= "practitioner_name=\"" +practitioner_name+ "\" " ;//Added by muthu on 27-6-12
	xmlStr+= "pkg_sysdate_dflt=\"" +pkg_sysdate_dflt+ "\" " ;
	xmlStr+= "site_spec=\"" +site_spec+"\" " ;
	xmlStr+= "blngGrpCode=\"" +blngGrpCode+ "\" " ;//Added By Shikha For GHL-CRF-0520.1
	xmlStr+= "blngGrpDesc=\"" +encodeURIComponent(blngGrpDesc)+"\" " ;//Added By Shikha For GHL-CRF-0520.1
	xmlStr +=" /></root>";	
	return xmlStr;
}

function formValidation(xmlStr,function_id,calledFrom)
{	   		
	if(calledFrom=="PkgAssocnExisting" || calledFrom=="Pkgsubsheader")
	{
		var temp_jsp="PkgSubscriptionValidation.jsp?function_id="+function_id+"&calledFrom="+calledFrom;		
	}		
	else
	{
	var temp_jsp="PkgSubscriptionValidation.jsp?function_id="+function_id;
	}		
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=xmlHttp.responseText ;
	eval(responseText);
	return true;
}

//Added V171212-Gayathri/MMS-DM-CRF-0118/Starts
function callPkgPrice_VAT(pkgPrice,rec_count,finalepisodetype,strOPYN,strEMYN,strIPYN,strDCYN,function_id,effToDate,addl_charge)
{
	var error_codes=new Array();
	var msg="";
	var temp7="";
	var temp5=finalepisodetype.indexOf('/');
	if(temp5==0)
		var temp7=finalepisodetype.substring(1,finalepisodetype.length);
	else
		temp7=finalepisodetype;
	var noofdecimal = document.forms[0].noofdecimal.value;
	if(function_id=="EBL_PACKAGE_SUBS")
	{
		//Added Newly Sarath for pkg closure checking
		var pkgcodeclosure = eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.packageCode_"+rec_count).value;
		var payerGrpCodeclosure=eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.payerGrpCode_"+rec_count).value;	
		var payerCodeclosure=eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.payerCode_"+rec_count).value;
		//Added By Shikha For GHL-CRF-0520.1
		var siteBLPkgBlngGrpYN = eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.siteBLPkgBlngGrpYN.value");	
		var blngGrpCodeclosureTemp ="";
		if(siteBLPkgBlngGrpYN=="Y"){			
			var blngGrpCodeclosure = eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.blngGrpCode_"+rec_count).value;
			blngGrpCodeclosureTemp = "&blngGrpCodeclosure="+blngGrpCodeclosure;
		}
		//Ended By Shikha For GHL-CRF-0520.1
		$.ajax({
			type:'POST',
			url:"../jsp/PkgSubscriptionValidation.jsp?pkgcodeclosure="+pkgcodeclosure+"&func_mode=ChkForPkgClosure&payerGrpCodeclosure="+payerGrpCodeclosure+"&payerCodeclosure="+payerCodeclosure+blngGrpCodeclosureTemp,
			async:false,
			dataType:"json",
			success : function(data){
				reqId=data.reqId;
			}
		});
		if(reqId == 'N'){
			eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.packageCode_"+rec_count).value="";
			eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.packageDesc_"+rec_count).value="";
			eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.payerGrpCode_"+rec_count).value="";	
			eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.payerGrpDesc_"+rec_count).value="";	
			eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.payerCode_"+rec_count).value="";
			eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.payerDesc_"+rec_count).value="";
			eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.blng_class_code"+rec_count).value="";
			eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.blng_class_desc"+rec_count).value="";
			eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.episodeType_"+rec_count).value="";
			eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.pkgAmt_"+rec_count).value="";	
			eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.addl_charge_"+rec_count).value="";	
			eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.toDate_"+rec_count).value="";

			//Added By Shikha For GHL-CRF-0520.1
			var siteBLPkgBlngGrpYN = eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.siteBLPkgBlngGrpYN.value");
			if(siteBLPkgBlngGrpYN=="Y"){
			eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.blngGrpCode_"+rec_count).value="";
			eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.blngGrpDesc_"+rec_count).value="";
			}
		 	//Added By Shikha For GHL-CRF-0520.1
			alert(getMessage("BL8678",'BL'));
			return false;
		}
		//Added Newly Sarath for pkg closure checking ends*/		
		if(parent.PkgSubscriptionDtls.document.frmPkgSubs.strMessageId.value!=""){
			
			if((parent.PkgSubscriptionDtls.document.frmPkgSubs.strMessageId.value).indexOf('|') != -1){
				error_codes=(parent.PkgSubscriptionDtls.document.frmPkgSubs.strMessageId.value).split('|');
				for(var i=0;i<error_codes.length;i++){
					msg=msg+"\n"+getMessage(error_codes[i],"BL");
				}
			}else{
				msg=getMessage(parent.PkgSubscriptionDtls.document.frmPkgSubs.strMessageId.value,"BL");
			}
		}else if(parent.PkgSubscriptionDtls.document.frmPkgSubs.strErrorText.value!=""){
			msg=strErrorText			
		}
		if(msg!=""){
			alert(msg);
			eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.packageCode_"+rec_count).value=""
			eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.packageDesc_"+rec_count).value=""
			parent.PkgSubscriptionDtls.document.frmPkgSubs.strMessageId.value="";
			parent.PkgSubscriptionDtls.document.frmPkgSubs.strErrorText.value="";
			return false;
		}
	  eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.pkgAmt_"+rec_count).value=pkgPrice;
	  eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.addl_charge_"+rec_count).value=addl_charge;
	 //var v_pkg_amt = eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.pkgAmt_"+rec_count);
	  putDecimal(eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.pkgAmt_"+rec_count),17,noofdecimal);
	  // Commmented V180316-Aravindh/MMS-DM-SCF-0493
	  /*
	  //Added V171212-Gayathri/MMS-DM-CRF-0118
	  if(addl_charge1='E'){
	   putDecimal(eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.addl_charge_"+rec_count),17,noofdecimal);
	  }
	  */
	  eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.episodeType_"+rec_count).value=temp7;
	  eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.strOPYN_"+rec_count).value=strOPYN;
	  eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.strEMYN_"+rec_count).value=strEMYN;
	  eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.strIPYN_"+rec_count).value=strIPYN;
	  eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.strDCYN_"+rec_count).value=strDCYN;
	  eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.toDate_"+rec_count).value=effToDate;
	}else{		
		//Added Newly Sarath for pkg closure checking
		var pkgcodeclosure = eval("document.frmPkgSubs.packageCode_"+rec_count).value;
		var payerGrpCodeclosure=eval("document.frmPkgSubs.payerGrpCode_"+rec_count).value;
		var payerCodeclosure=eval("document.frmPkgSubs.payerCode_"+rec_count).value;

		//Added By Shikha For GHL-CRF-0520.1
		var siteBLPkgBlngGrpYN = eval("document.frmPkgSubs.siteBLPkgBlngGrpYN.value");	
		var blngGrpCodeclosureTemp ="";
		if(siteBLPkgBlngGrpYN=="Y"){			
			var blngGrpCodeclosure = eval("document.frmPkgSubs.blngGrpCode_"+rec_count).value;
			blngGrpCodeclosureTemp = "&blngGrpCodeclosure="+blngGrpCodeclosure;
		}
		//Ended By Shikha For GHL-CRF-0520.1
		$.ajax({
			type:'POST',
			url:"../jsp/PkgSubscriptionValidation.jsp?pkgcodeclosure="+pkgcodeclosure+"&func_mode=ChkForPkgClosure&payerGrpCodeclosure="+payerGrpCodeclosure+"&payerCodeclosure="+payerCodeclosure+blngGrpCodeclosureTemp,
			async:false,
			dataType:"json",
			success : function(data){
				reqId=data.reqId;
			}
		});
		if(reqId == 'N'){
			eval("document.frmPkgSubs.packageCode_"+rec_count).value="";
			eval("document.frmPkgSubs.packageDesc_"+rec_count).value="";
			//eval("document.frmPkgSubs.payerGrpCode_"+rec_count).value="";
			//eval("document.frmPkgSubs.payerGrpDesc_"+rec_count).value="";
			//eval("document.frmPkgSubs.payerCode_"+rec_count).value="";
			//eval("document.frmPkgSubs.payerDesc_"+rec_count).value="";
			alert(getMessage("BL8678",'BL'));
			return false;
		}
		//Added Newly Sarath for pkg closure checking*/
		
		/*	if(document.frmPkgSubs.strMessageId.value!=""){
			alert(getMessage('"+strMessageId+"','BL'));
			eval("document.frmPkgSubs.packageCode_"+rec_count).value=""
			eval("document.frmPkgSubs.packageDesc_"+rec_count).value=""
			return false;
		}else if(document.frmPkgSubs.strErrorText.value!=""){
			alert(strErrorText)
			return false;
		}*/
		
		if(eval("document.frmPkgSubs.packageCode_"+rec_count).value!="" ){
		if(document.frmPkgSubs.strMessageId.value!=""){
			
			if((document.frmPkgSubs.strMessageId.value).indexOf('|') != -1){
				error_codes=(document.frmPkgSubs.strMessageId.value).split('|');
				for(var i=0;i<error_codes.length;i++){
					msg=msg+"\n"+getMessage(error_codes[i],"BL");
				}
			}else{
				msg=getMessage(document.frmPkgSubs.strMessageId.value,"BL");
			}
		}else if(document.frmPkgSubs.strErrorText.value!=""){
			msg=strErrorText			
		}
		if(msg!=""){
			alert(msg);
			eval("document.frmPkgSubs.packageCode_"+rec_count).value=""
			eval("document.frmPkgSubs.packageDesc_"+rec_count).value=""
			document.frmPkgSubs.strMessageId.value="";
			document.frmPkgSubs.strErrorText.value="";
	
			return false;
		}
	  eval("document.frmPkgSubs.pkgAmt_"+rec_count).value=pkgPrice;
	  eval("document.frmPkgSubs.addl_charge_"+rec_count).value=addl_charge;
	  putDecimal(eval("document.frmPkgSubs.pkgAmt_"+rec_count),17,noofdecimal);
	  putDecimal(eval("document.frmPkgSubs.addl_charge_"+rec_count),17,noofdecimal);
	  eval("document.frmPkgSubs.episodeType_"+rec_count).value=temp7;
	  eval("document.frmPkgSubs.strOPYN_"+rec_count).value=strOPYN;
	  eval("document.frmPkgSubs.strEMYN_"+rec_count).value=strEMYN;
	  eval("document.frmPkgSubs.strIPYN_"+rec_count).value=strIPYN;
	  eval("document.frmPkgSubs.strDCYN_"+rec_count).value=strDCYN;
	  eval("document.frmPkgSubs.toDate_"+rec_count).value=effToDate;
	}
	} 
}
//Added V171212-Gayathri/MMS-DM-CRF-0118/Ends

function callPkgPrice(pkgPrice,rec_count,finalepisodetype,strOPYN,strEMYN,strIPYN,strDCYN,function_id,effToDate,ChildMap)
{
	var error_codes=new Array();
	var msg="";
	var temp7="";
	var temp5=finalepisodetype.indexOf('/');
	if(temp5==0)
		var temp7=finalepisodetype.substring(1,finalepisodetype.length);
	else
		temp7=finalepisodetype;
	var noofdecimal = document.forms[0].noofdecimal.value;
	var SiteSpecific_VAT="N";//Added V180522-Aravindh/GHL-SCF-1341
	var allowMsterChildPack="N";
	//Added V180522-Aravindh/GHL-SCF-1341/if-condition
	if(parent.PkgSubscriptionDtls != undefined && parent.PkgSubscriptionDtls != "undifined" && parent.PkgSubscriptionDtls != null && parent.PkgSubscriptionDtls != "null") {
		SiteSpecific_VAT=parent.PkgSubscriptionDtls.document.frmPkgSubs.SiteSpec_VAT.value;// Added by Aravindh/03-05-2018/GHL-SCF-1330
	
	}
	if(function_id=="EBL_PACKAGE_SUBS")
	{
		//Added Newly Sarath for pkg closure checking
		var pkgcodeclosure = eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.packageCode_"+rec_count).value;
		var payerGrpCodeclosure=eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.payerGrpCode_"+rec_count).value;	
		var payerCodeclosure=eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.payerCode_"+rec_count).value;
		var packageCode=eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.packageCode_"+rec_count).value;
		var fromdate=eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.fromDate_"+rec_count).value;
		var toDate=eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.toDate_"+rec_count).value;		
		//Added By Shikha For GHL-CRF-0520.1
		var siteBLPkgBlngGrpYN = eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.siteBLPkgBlngGrpYN.value");	
		var blngGrpCodeclosureTemp ="";
		if(siteBLPkgBlngGrpYN=="Y"){			
			var blngGrpCodeclosure = eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.blngGrpCode_"+rec_count).value;
			blngGrpCodeclosureTemp = "&blngGrpCodeclosure="+blngGrpCodeclosure;
		}
		//Ended By Shikha For GHL-CRF-0520.1		
		$.ajax({
			type:'POST',
			url:"../jsp/PkgSubscriptionValidation.jsp?pkgcodeclosure="+pkgcodeclosure+"&func_mode=ChkForPkgClosure&payerGrpCodeclosure="+payerGrpCodeclosure+"&payerCodeclosure="+payerCodeclosure+blngGrpCodeclosureTemp,
			async:false,
			dataType:"json",
			success : function(data){
				reqId=data.reqId;
			}
		});
		if(reqId == 'N'){
			eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.packageCode_"+rec_count).value="";
			eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.packageDesc_"+rec_count).value="";
			eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.payerGrpCode_"+rec_count).value="";	
			eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.payerGrpDesc_"+rec_count).value="";	
			eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.payerCode_"+rec_count).value="";
			eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.payerDesc_"+rec_count).value="";
			eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.blng_class_code"+rec_count).value="";
			eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.blng_class_desc"+rec_count).value="";
			eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.episodeType_"+rec_count).value="";
			eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.pkgAmt_"+rec_count).value="";	
			eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.toDate_"+rec_count).value="";
			eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.blngGrpCode_"+rec_count).value=""; 	//Added By Shikha For GHL-CRF-0520.1
			eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.blngGrpDesc_"+rec_count).value=""; 	//Added By Shikha For GHL-CRF-0520.1
			alert(getMessage("BL8678",'BL'));
			return false;
		}
		//Added Newly Sarath for pkg closure checking ends*/		
		if(ChildMap == "Y"){
		$.ajax({
			type:'POST',
			url:"../jsp/PkgSubscriptionValidation.jsp?func_mode=ChildPack&packageCode="+packageCode+"&fromdate="+fromdate+"&toDate="+toDate,
			async:false,
			dataType:"json",
			success : function(data){
				count=data.count;
				if(count > 0){
				var confirmFlag=window.confirm("Child package exists for the master package. Do you Confirm?");  
				
				if(confirmFlag){
					return true;
				
				}
				else {
					eval("document.frmPkgSubs.packageCode_"+rec_count).value="";
					eval("document.frmPkgSubs.packageDesc_"+rec_count).value="";
					return false;
				}
				}
			}
		});
		}	
		if(parent.PkgSubscriptionDtls.document.frmPkgSubs.strMessageId.value!=""){
			
			if((parent.PkgSubscriptionDtls.document.frmPkgSubs.strMessageId.value).indexOf('|') != -1){
				error_codes=(parent.PkgSubscriptionDtls.document.frmPkgSubs.strMessageId.value).split('|');
				for(var i=0;i<error_codes.length;i++){
					msg=msg+"\n"+getMessage(error_codes[i],"BL");
				}
			}else{
				msg=getMessage(parent.PkgSubscriptionDtls.document.frmPkgSubs.strMessageId.value,"BL");
			}
		}else if(parent.PkgSubscriptionDtls.document.frmPkgSubs.strErrorText.value!=""){
			msg=strErrorText			
		}
		if(msg!=""){
			alert(msg);
			eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.packageCode_"+rec_count).value=""
			eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.packageDesc_"+rec_count).value=""
			parent.PkgSubscriptionDtls.document.frmPkgSubs.strMessageId.value="";
			parent.PkgSubscriptionDtls.document.frmPkgSubs.strErrorText.value="";
			return false;
		}
	  eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.pkgAmt_"+rec_count).value=pkgPrice;
	  //Added by Aravindh/03-05-2018/GHL-SCF-1330/if condition
	  if(SiteSpecific_VAT == "Y") {
		  eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.addl_charge_"+rec_count).value=addl_charge;
		  putDecimal(eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.addl_charge_"+rec_count),17,noofdecimal);
	  }
	 //var v_pkg_amt = eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.pkgAmt_"+rec_count);
	  putDecimal(eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.pkgAmt_"+rec_count),17,noofdecimal);
	  //Commented below line by Aravindh/03-05-2018/GHL-SCF-1330
	  //putDecimal(eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.addl_charge_"+rec_count),17,noofdecimal);
	  eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.episodeType_"+rec_count).value=temp7;
	  eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.strOPYN_"+rec_count).value=strOPYN;
	  eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.strEMYN_"+rec_count).value=strEMYN;
	  eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.strIPYN_"+rec_count).value=strIPYN;
	  eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.strDCYN_"+rec_count).value=strDCYN;
	  eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.toDate_"+rec_count).value=effToDate;
	}else{		
		//Added Newly Sarath for pkg closure checking
		var pkgcodeclosure = eval("document.frmPkgSubs.packageCode_"+rec_count).value;
		var payerGrpCodeclosure=eval("document.frmPkgSubs.payerGrpCode_"+rec_count).value;
		var payerCodeclosure=eval("document.frmPkgSubs.payerCode_"+rec_count).value;
		var packageCode=eval("document.frmPkgSubs.packageCode_"+rec_count).value;
		var fromdate=eval("document.frmPkgSubs.fromDate_"+rec_count).value;
		var toDate=eval("document.frmPkgSubs.toDate_"+rec_count).value;

		//Added By Shikha For GHL-CRF-0520.1
		var siteBLPkgBlngGrpYN = eval("document.frmPkgSubs.siteBLPkgBlngGrpYN.value");	
		var blngGrpCodeclosureTemp ="";
		if(siteBLPkgBlngGrpYN=="Y"){			
			var blngGrpCodeclosure = eval("document.frmPkgSubs.blngGrpCode_"+rec_count).value;
			blngGrpCodeclosureTemp = "&blngGrpCodeclosure="+blngGrpCodeclosure;
		}
		//Ended By Shikha For GHL-CRF-0520.1
		$.ajax({
			type:'POST',
			url:"../jsp/PkgSubscriptionValidation.jsp?pkgcodeclosure="+pkgcodeclosure+"&func_mode=ChkForPkgClosure&payerGrpCodeclosure="+payerGrpCodeclosure+"&payerCodeclosure="+payerCodeclosure+blngGrpCodeclosureTemp,
			async:false,
			dataType:"json",
			success : function(data){
				reqId=data.reqId;
			}
		});
		if(reqId == 'N'){
			eval("document.frmPkgSubs.packageCode_"+rec_count).value="";
			eval("document.frmPkgSubs.packageDesc_"+rec_count).value="";
			//eval("document.frmPkgSubs.payerGrpCode_"+rec_count).value="";
			//eval("document.frmPkgSubs.payerGrpDesc_"+rec_count).value="";
			//eval("document.frmPkgSubs.payerCode_"+rec_count).value="";
			//eval("document.frmPkgSubs.payerDesc_"+rec_count).value="";
			alert(getMessage("BL8678",'BL'));
			return false;
		}		
		if(ChildMap == "Y"){			
		$.ajax({
			type:'POST',
			url:"../jsp/PkgSubscriptionValidation.jsp?func_mode=ChildPack&packageCode="+packageCode+"&fromdate="+fromdate+"&toDate="+toDate,
			async:false,
			dataType:"json",
			success : function(data){
				count=data.count;

			if(count > 0){
				var confirmFlag=window.confirm("Child package exists for the master package. Do you Confirm?");  
				
				if(confirmFlag){
					return true;
				
				}
				else {
					eval("document.frmPkgSubs.packageCode_"+rec_count).value="";
					eval("document.frmPkgSubs.packageDesc_"+rec_count).value="";
					return false;
				}
				}
			}
		});
		
		}
		if(eval("document.frmPkgSubs.packageCode_"+rec_count).value!="" ){
		if(document.frmPkgSubs.strMessageId.value!=""){
			
			if((document.frmPkgSubs.strMessageId.value).indexOf('|') != -1){
				error_codes=(document.frmPkgSubs.strMessageId.value).split('|');
				for(var i=0;i<error_codes.length;i++){
					msg=msg+"\n"+getMessage(error_codes[i],"BL");
				}
			}else{
				msg=getMessage(document.frmPkgSubs.strMessageId.value,"BL");
			}
		}else if(document.frmPkgSubs.strErrorText.value!=""){
			msg=strErrorText			
		}
		if(msg!=""){
					alert(msg);
			eval("document.frmPkgSubs.packageCode_"+rec_count).value=""
			eval("document.frmPkgSubs.packageDesc_"+rec_count).value=""
			document.frmPkgSubs.strMessageId.value="";
			document.frmPkgSubs.strErrorText.value="";
	
			return false;
		}
	  eval("document.frmPkgSubs.pkgAmt_"+rec_count).value=pkgPrice;
	
	  putDecimal(eval("document.frmPkgSubs.pkgAmt_"+rec_count),17,noofdecimal);
	
	  eval("document.frmPkgSubs.episodeType_"+rec_count).value=temp7;
	  eval("document.frmPkgSubs.strOPYN_"+rec_count).value=strOPYN;
	  eval("document.frmPkgSubs.strEMYN_"+rec_count).value=strEMYN;
	  eval("document.frmPkgSubs.strIPYN_"+rec_count).value=strIPYN;
	  eval("document.frmPkgSubs.strDCYN_"+rec_count).value=strDCYN;
	  eval("document.frmPkgSubs.toDate_"+rec_count).value=effToDate;
	}
	} 
}

function callPatValidation(obj)
{
	var patient_id=obj.value;	
	if(patient_id!=""){
		var function_id = "PAT_CHK";
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "patient_id=\"" + patient_id + "\" " ;					
		xmlStr +=" /></root>";	
		var temp_jsp="PkgSubscriptionValidation.jsp?func_mode=CHK_PAT_ID&function_id="+function_id;					
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		var responseText=trimString(xmlHttp.responseText);
		if(responseText=="N")
		{
			alert(getMessage("INVALID_PATIENT","MP"));
			//obj.select();
			obj.value='';
			//obj.focus();
		}else if(responseText=="Y"){
			callPackagesubspage()
		}		
	}
}

function callPackagesubspage()
{
	var patientId=parent.PkgSubscriptionHeader.document.frmPkgDefHeader.patientId.value;
	var params=parent.PkgSubscriptionHeader.document.frmPkgDefHeader.params.value;
	/* Karthik added for adding Package Association along with subscription 43507  -   MMS-QH-CRF-0139  - Starts*/
	var siteParam=parent.PkgSubscriptionHeader.document.frmPkgDefHeader.siteParam.value;	
	/* Karthik added for adding Package Association along with subscription 43507  -   MMS-QH-CRF-0139  - Ends*/
	if(patientId=="") {
		alert(getMessage("BL0002","BL"));
		parent.PkgSubscriptionHeader.document.frmPkgDefHeader.patientId.select();
	}
	else{	
		
		parent.PkgSubscriptionDtls.location.href="../../eBL/jsp/PkgSubscriptionDtls.jsp?patientId="+patientId+"&params="+params+"&siteParam="+siteParam;

	}	
}

async function subscribePackageFromVisit(patient_id,calling_module_id)
{
	var firstVisitDateTime=document.forms[0].firstVisitDateTime.value;
	//Added by Rajesh V for CRF - 140
	var insCustGrp = '';
	var insCust = '';
	var insCustGrpDesc = '';
	var insCustDesc = '';
	var priorityOneParam = '';
	var allPayerCode ='';
	var allPayerGroupCode='';
	var allowedPayersList='';
	if(parent.MainFrame2.InsuranceFrame != undefined){
		if(parent.MainFrame2.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame != undefined){
			var insBodyFrm = parent.MainFrame2.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.add_modify_pat_fin_det_insmain;			
			
			if(insBodyFrm.name == 'add_modify_pat_fin_det_insmain'){
				var totalRecord = insBodyFrm.total_records.value;
				if(totalRecord>0){
					for(var indx=0;indx<totalRecord;indx++){						
						if(eval('parent.MainFrame2.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.add_modify_pat_fin_det_insmain.priority'+indx).value==1){
							insCustGrp = eval('parent.MainFrame2.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.add_modify_pat_fin_det_insmain.ins_cust_group_code'+indx).value;
							insCust = eval('parent.MainFrame2.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.add_modify_pat_fin_det_insmain.cust_3'+indx).value;
							insCustGrpDesc = eval('parent.MainFrame2.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.add_modify_pat_fin_det_insmain.ins_cust_group_name'+indx).value;
							insCustDesc = eval('parent.MainFrame2.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.add_modify_pat_fin_det_insmain.payer_desc'+indx).value;
							break;
						}						
					}
				}
			}
		}
	}
	if(insCustGrp.length>0){
		priorityOneParam = '&insCustGrp='+insCustGrp+'&insCust='+insCust+'&insCustGrpDesc='+encodeURIComponent(insCustGrpDesc)+
							'&insCustDesc='+encodeURIComponent(insCustDesc);
	}

	//alert(insCustGrp + ','+ insCust +','+insCustGrpDesc+','+insCustDesc);
	//Added by Rajesh V for CRF - 140
	var function_id="";
	var bed_type="";
	if(calling_module_id=="OP")
		function_id="VISIT_REGISTRATION";	
	else if(calling_module_id=="IP"){		
		function_id="ADMISSION";	
		bed_type=document.forms[0].bed_type.value;
		//alert('bed_type='+bed_type);
		//alert('document.forms[0].name='+document.forms[0].name);
		}
	var package_enabled_yn=document.forms[0].package_enabled_yn.value;
	var patient_id=patient_id;
	var center='1';
	var dialogTop	= '10';
	var dialogHeight	= '80vh';
	var dialogWidth		= '83vw';
	var features = 'dialogTop:' + dialogTop + '; dialogHeight:' + dialogHeight + '; center:' + center + '; dialogWidth:' + dialogWidth + '; status=no; scrollbars=yes';
	var title=encodeURIComponent(getLabel("eBL.Pack_Subs.label","BL"));
	//var title=encodeURIComponent("Package Subscription");
	var  arguments 		= "";
	var  column_sizes  		= escape("");
	var  column_descriptions  	= "";
	var param="title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&patientId="+patient_id+"&function_id="+function_id+"&bed_type="+bed_type+"&package_enabled_yn="+package_enabled_yn+'&firstVisitDateTime='+firstVisitDateTime;
	//Added by Rajesh V for CRF - 140
	param = param+priorityOneParam;
	//Added by Rajesh V for CRF - 140
	//alert("param"+param);
	// Karthik added code for MMS-RY-SCF-0065
	if(parent.MainFrame2.InsuranceFrame != undefined){
		if(parent.MainFrame2.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame != undefined){
			if(insBodyFrm.name == 'add_modify_pat_fin_det_insmain'){
				var totalRecord = insBodyFrm.total_records.value;
				if(totalRecord>0){
					for(var indx=0;indx<totalRecord;indx++){
						insCustGrp = eval('parent.MainFrame2.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.add_modify_pat_fin_det_insmain.ins_cust_group_code'+indx).value;
						insCust = eval('parent.MainFrame2.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.add_modify_pat_fin_det_insmain.cust_3'+indx).value;
						if(allPayerCode.indexOf("'" + insCust +"'")<0){ // Removes Duplicate entry in the payer list
						allPayerCode+= "'" + insCust +"',";
						}
						if(allPayerGroupCode.indexOf("'" + insCustGrp +"'")<0){  // Removes Duplicate entry in the payer list
						allPayerGroupCode+= "'" + insCustGrp +"',";
						}
					}
					if(allPayerGroupCode!=''){
					allPayerCode=allPayerCode.substring(0, allPayerCode.length -1 );
					allPayerGroupCode=allPayerGroupCode.substring(0, allPayerGroupCode.length -1 );
					allowedPayersList= "&allPayerCode="+allPayerCode+"&allPayerGroupCode="+allPayerGroupCode;
					}
				}
			}
		}
	}
/*	if(insCustGrp.length>0){
		allPayerCode=parent.MainFrame2.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.add_modify_pat_fin_det_insmain.allPayerCode.value;
		allPayerGroupCode=	parent.MainFrame2.InsuranceFrame.AddModifypatFinDetailsInsBodyFrame.add_modify_pat_fin_det_insmain.allPayerGroupCode.value;
		allowedPayersList= "&allPayerCode="+allPayerCode+"&allPayerGroupCode="+allPayerGroupCode;
		}*/
	param = param + allowedPayersList ;
	retVal=await top.window.showModalDialog("../../eBL/jsp/PkgSubscriptionDtls.jsp?"+param,arguments,features);	
	//if(retVal=="Y" && function_id=="VISIT_REGISTRATION"){
	//callPkgDeposit(patient_id,function_id)
	//}
}

async function packageSubsDetails(function_id)
{	
	var frmObj="";	
	
	frmObj =  document.frmPkgSubs;	
    if( frmObj!=null && frmObj != "undefined" )
	{	
		var xmlStr ="<root><SEARCH ";
		if(true)
		{
			var arrObj = frmObj.elements;
			
			for(var i=0;i<arrObj.length;i++)
			{
				var val = "" ;
				if(arrObj[i].type == "select-multiple" )
				{
					for(var j=0; j<arrObj[i].options.length; j++)
				    {
						if(arrObj[i].options[j].selected)
							val+=arrObj[i].options[j].value +"~"
		            }
			        val= val.substring(0,val.lastIndexOf('~'))
				    if(arrObj[i].name != null && arrObj[i].name != "")
					    xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
				}
			    else
				{
					val = arrObj[i].value;
			        if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
		        }
			}
		}
	}    
	var charge_logic_yn = frmObj.charge_logic_yn.value;
	var temp_jsp="PkgSubscriptionValidation.jsp?func_mode=STORE_VALUES&function_id="+function_id;
	xmlStr +=" /></root>";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var Empty = false;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");;
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=xmlHttp.responseText ;
	/*for(let s = 0;s<document.getElementById("pkgSubs_tabId").rows.length;s++)
	{	
		var element1 = document.getElementById("pkgAmt_" + s);
		console.log(element1);
		if (element1 && (element1.value === null || element1.value === ""))
		{
			Empty=true;
			break;
			
		}
		
	}
	
	if(Empty==true)
	{
		parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();
	}
	else
	{
	eval(responseText);
	}*/
	await eval(responseText);
	window.returnValue='Y';
	window.close();
}


function closeSubs()
{
	window.close();
}

//Function for duplicate service/item check
function checkForDuplicate(item,index)
{
	item=item.value
	var total_records = 0;
	total_records = document.forms[0].total_records.value;
	if(total_records>1)
	{
		var xmlStr ="<root><SEARCH ";
		for(var i=0;i<total_records; i++)
		{
			xmlStr+= "code_"+i+"=\"" + eval("document.forms[0].packageCode_"+i).value + "\" ";
		}
		xmlStr+= "item=\"" + item + "\" " ;		
		xmlStr+= "index=\"" + index + "\" " ;		
		xmlStr+= "total_records=\"" + total_records + "\" " ;
		xmlStr +=" /></root>";		
		var updation=formValidation(xmlStr,"DUPLICATE_CHECK");
	}
}

function duplicateAlert(index)
{
	eval("document.forms[0].packageCode_"+index).value= "";
	eval("document.forms[0].packageDesc_"+index).value= "";
	eval("document.forms[0].fromDate_"+index).value= "";
	eval("document.forms[0].pkgAmt_"+index).value= "";
	eval("document.forms[0].episodeType_"+index).value= "";
	eval("document.forms[0].strOPYN_"+index).value= "";
	eval("document.forms[0].strEMYN_"+index).value= "";
	eval("document.forms[0].strIPYN_"+index).value= "";
	eval("document.forms[0].strDCYN_"+index).value= "";

	alert(getMessage("BL8507",'BL'));
}

async function pkgCodeLookup(packageDesc,packageCode,index){
	var formObj=document.frmPkgSubs;
	var chargeLogic =formObj.charge_logic_yn.value; 
	var facilityId=formObj.facility_id.value;//Added against NMC-JD-SCF-0086
	if(formObj!=null){
		if( ( eval("formObj.packageCode_"+index+".value")!='' || eval("formObj.packageDesc_"+index+".value")!='' ) || (eval("formObj.packageCode_temp_"+index+".value") != eval("formObj.packageCode_"+index+".value")) )
		{
			if(eval("formObj.packageCode_"+index).value != ""){	
	
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var title=getLabel("Common.Package.label","common");
				var locale=formObj.locale.value;				
				var function_id=formObj.function_id.value;
				var sql=""	
				if(function_id=="VISIT_REGISTRATION"){
					sql="select  a.PACKAGE_CODE code,a.SHORT_DESC description from bl_package_lang_vw a, bl_package b where a.package_code=b.package_code and a.operating_Facility_id=b.operating_facility_id and nvl(b.order_Catalog_yn,'N')='Y' AND a.LANGUAGE_ID = '"+locale+"' and b.operating_facility_id = '"+facilityId+"' AND nvl(a.status,'x') != 'S'  and  b.eff_from_date <= trunc(sysdate) and nvl(b.eff_to_date,trunc(sysdate)) >= trunc(sysdate) and nvl(b.approved_yn,'N') = 'Y' AND NVL (OP_YN,'N') = 'Y' and upper(a.PACKAGE_CODE) like upper(?) and upper(a.SHORT_DESC) like upper(?)"; 
				}
				else if(function_id=="ADMISSION"){
					sql="select  a.PACKAGE_CODE code,a.SHORT_DESC description from bl_package_lang_vw a, bl_package b where a.package_code=b.package_code and a.operating_Facility_id=b.operating_facility_id and nvl(b.order_Catalog_yn,'N')='N' AND a.LANGUAGE_ID = '"+locale+"' and b.operating_facility_id = '"+facilityId+"' AND nvl(a.status,'x') != 'S'  and  b.eff_from_date <= trunc(sysdate) and nvl(b.eff_to_date,trunc(sysdate)) >= trunc(sysdate) and nvl(b.approved_yn,'N') = 'Y'  AND NVL (IP_YN,'N') = 'Y' and upper(a.PACKAGE_CODE) like upper(?) and upper(a.SHORT_DESC) like upper(?)";
				}
				else{
					sql="select  a.PACKAGE_CODE code,a.SHORT_DESC description from bl_package_lang_vw a, bl_package b where a.package_code=b.package_code and a.operating_Facility_id=b.operating_facility_id and nvl(b.order_Catalog_yn,'N')='N' AND a.LANGUAGE_ID = '"+locale+"' and b.operating_facility_id = '"+facilityId+"'  AND nvl(a.status,'x') != 'S'  and  b.eff_from_date <= trunc(sysdate) and nvl(b.eff_to_date,trunc(sysdate)) >= trunc(sysdate) and nvl(b.approved_yn,'N') = 'Y'  and upper(a.PACKAGE_CODE) like upper(?) and upper(a.SHORT_DESC) like upper(?)"; 
				}
				argumentArray[0]   = sql ;
				argumentArray[1]   = dataNameArray ;
				argumentArray[2]   = dataValueArray ;
				argumentArray[3]   = dataTypeArray ;
				argumentArray[4]   = "2,1"; // Changed by Subha for MMS-RY-SCF-0068 on V19042018
				argumentArray[5]   = packageCode.value ;
				argumentArray[6]   = CODE_LINK ; // Changed by Subha for MMS-RY-SCF-0068 on V19042018
				argumentArray[7]   = DESC_CODE ; // Changed by Subha for MMS-RY-SCF-0068 on V19042018
				
				retVal = await CommonLookup( title, argumentArray );
				eval("formObj.packageDesc_"+index).value="";	
				eval("formObj.episodeType_"+index).value="";
				var fromDateStr="";
				if(formObj.firstVisitDateTime!=null) fromDateStr = formObj.firstVisitDateTime.value;
				eval("formObj.fromDate_"+index).value=fromDateStr;	
				eval("formObj.toDate_"+index).value="";	
				eval("formObj.pkgAmt_"+index).value="";
				if(retVal != null && retVal != ""){
					
					var ret1=unescape(retVal);
					
						 	var arr=ret1.split(",");
						 	if(arr[1]==undefined) 
					 		{
						 		arr[0]="";	
						 		arr[1]="";	
					 		}
					
					
					
					
					
					
					
					
					packageDesc.value = arr[1];
					packageCode.value =arr[0] ;
					eval("formObj.packageCode_temp_"+index).value= arr[0];
					eval("formObj.packageDesc_temp_"+index).value= arr[1];				
					if(packageCode!="")
					{		
						if(chargeLogic=='N')
							{
						checkForDuplicate(packageCode,index);
							}
						else
							callSysdate(index);
					}
					if(index==0){
						callSysdate(index);
					}	
					//Added By Vijay For KDAH-SCf-0404
				if(eval("formObj.blng_class_code"+index).value!=''|| eval("formObj.blng_class_code"+index).value!='')
					{
					
					callvalidate(index,function_id);					
					}
				}else{
					packageDesc.value = "";
					packageCode.value = "" ;	
					eval("formObj.packageCode_"+index).value= "";
					eval("formObj.packageDesc_temp_"+index).value="";										
				}
			} else {					//else Condition added by Subha for MMS-RY-SCF-0068 on v13042018
				packageDesc.value = "";
			}
		}
	}	
}

function pkgDescLookUp(packageDesc,packageCode,index){
	var formObj=document.frmPkgSubs;
	if(formObj!=null){
		//Commented by Subha for MMS-RY-SCF-0068 on V28032018
		//if(( eval("formObj.packageCode_"+index+".value")!='' || eval("formObj.packageDesc_"+index+".value")!='' ) || eval("formObj.packageDesc_temp_"+index+".value") != eval("formObj.packageDesc_"+index+".value"))
		if(eval("formObj.packageDesc_"+index+".value") != eval("formObj.packageDesc_temp_"+index+".value")) //Added by Subha for MMS-RY-SCF-0068 on V28032018
				{
			if(eval("formObj.packageDesc_"+index).value != "") {
				show_pkgLookUp(packageDesc,packageCode,index);
			} else {						//else Condition added by Subha for MMS-RY-SCF-0068 on v13042018
				packageCode.value = "" ;
			}
		}
	}
}

async function pkgLookUp(packageDesc,packageCode,index){
	var formObj=document.frmPkgSubs;
		if(formObj!=null){
			if(eval("formObj.packageDesc_"+index).value == ""){
					await show_pkgLookUp(packageDesc,packageCode,index);
			}
		}
}

async function show_pkgLookUp(packageDesc,packageCode,index){	
	var formObj=document.frmPkgSubs;
	var patId=formObj.patientId.value;	
	var facilityId=formObj.facility_id.value;//Added against NMC-JD-SCF-0086
	var chargeLogic =formObj.charge_logic_yn.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var title=getLabel("Common.Package.label","common");
	var locale=formObj.locale.value;
//	alert("locale"+locale);
	var function_id=formObj.function_id.value;
	//alert("function_id "+function_id);
	var sql=""	;
	if(function_id=="VISIT_REGISTRATION"){
		sql="select  a.PACKAGE_CODE code,a.SHORT_DESC description from bl_package_lang_vw a, bl_package b where  a.package_code=b.package_code and a.operating_Facility_id=b.operating_facility_id and nvl(b.order_Catalog_yn,'N')='Y' AND a.LANGUAGE_ID = '"+locale+"' and b.operating_Facility_id='"+facilityId+"' AND nvl(a.status,'x') != 'S' and  b.eff_from_date <= trunc(sysdate) and nvl(b.eff_to_date,trunc(sysdate)) >= trunc(sysdate)  and nvl(b.approved_yn,'N') = 'Y' AND NVL (OP_YN,'N') = 'Y' and upper(a.PACKAGE_CODE) like upper(?) and upper(a.SHORT_DESC) like upper(?)";//Added against NMC-JD-SCF-0086
	}
	else if(function_id=="ADMISSION"){
		sql="select  a.PACKAGE_CODE code,a.SHORT_DESC description from bl_package_lang_vw a, bl_package b where   a.package_code=b.package_code and a.operating_Facility_id=b.operating_facility_id and nvl(b.order_Catalog_yn,'N')='N' AND a.LANGUAGE_ID = '"+locale+"' and b.operating_Facility_id='"+facilityId+"' AND nvl(a.status,'x') != 'S'  and  b.eff_from_date <= trunc(sysdate) and nvl(b.eff_to_date,trunc(sysdate)) >= trunc(sysdate) and nvl(b.approved_yn,'N') = 'Y' AND NVL (IP_YN,'N') = 'Y' and upper(a.PACKAGE_CODE) like upper(?) and upper(a.SHORT_DESC) like upper(?)";//Added against NMC-JD-SCF-0086
	}
	else{
		//sql="select  a.PACKAGE_CODE code,a.SHORT_DESC description from bl_package_lang_vw a, bl_package b where	a.operating_Facility_id='"+facilityId+"' and a.package_code=b.package_code and a.operating_Facility_id=b.operating_facility_id and nvl(b.order_Catalog_yn,'N')='N' AND a.LANGUAGE_ID = '"+locale+"' AND nvl(a.status,'x') != 'S'  and  b.eff_from_date <= trunc(sysdate) and nvl(b.eff_to_date,trunc(sysdate)) >= trunc(sysdate) and nvl(b.approved_yn,'N') = 'Y' and upper(a.PACKAGE_CODE) like upper(?) and upper(a.SHORT_DESC) like upper(?)";//Added against NMC-JD-SCF-0086
		var sql="select  a.PACKAGE_CODE code,a.SHORT_DESC description from bl_package_lang_vw a, bl_package b where a.package_code=b.package_code and a.operating_Facility_id = b.operating_facility_id and nvl(b.order_Catalog_yn,'N')='N' AND a.LANGUAGE_ID = '"+locale+"' and  b.operating_facility_id='"+facilityId+"' AND nvl(a.status,'x') != 'S'  and  b.eff_from_date <= trunc(sysdate) and nvl(b.eff_to_date,trunc(sysdate)) >= trunc(sysdate) and nvl(b.approved_yn,'N') = 'Y' and upper(a.PACKAGE_CODE) like upper(?) and upper(a.SHORT_DESC) like upper(?)";//Added against NMC-JD-SCF-0086
		//alert(sql);
	}
	argumentArray[0]   = sql ;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = packageDesc.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; // Changed by Subha for MMS-RY-SCF-0068 on V19042018
	retVal = await CommonLookup( title, argumentArray );
	var ret1=unescape(retVal);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	
	
	
	eval("formObj.packageDesc_"+index).value="";

	eval("formObj.episodeType_"+index).value="";	
	var fromDateStr="";
	if(formObj.firstVisitDateTime!=null) 
	fromDateStr = formObj.firstVisitDateTime.value;
	eval("formObj.fromDate_"+index).value=fromDateStr;		
	eval("formObj.toDate_"+index).value="";	
	eval("formObj.pkgAmt_"+index).value="";
	if(retVal != null && retVal != ""){
		packageDesc.value = arr[1];
		packageCode.value =arr[0] ;
		eval("formObj.packageCode_"+index).value= arr[0];
		eval("formObj.packageDesc_temp_"+index).value= arr[1];
		
		/* Karthik added validation here to perform extra check for Multi encounter cases while subscription - Starts */
//		var totalEncountersSelected=formObj.totalEncountersSelected.value;
		var allowSubscription=true;
//			if(totalEncountersSelected > 1){//multiple encounters are selected
		
		var temp_jsp="../../eBL/jsp/PkgSubscriptionAssociationDtlsValidation.jsp?action=count&patId="+patId;

		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		var responseText=xmlHttp.responseText;	
		
		var multipleEncounters="N";	
		if(responseText.indexOf("MULTIPLE_ENCOUNTER_SUCCESS")!=-1){ 
			multipleEncounters="Y";
			}else{
				multipleEncounters="N";	
			}
		
		var checkAcrossEncounter =	isAcrossEncounterSupported(arr[0]);
		if(checkAcrossEncounter=="N"){				
			if(multipleEncounters=="Y"){					
			alert("For this Package "+arr[1]+" Multiple Encounters Could not be Applied");
			allowSubscription=false;
			packageDesc.value = "";
			packageCode.value = "" ;	
			eval("formObj.packageCode_"+index).value= "";
			eval("formObj.packageDesc_temp_"+index).value="";
			}
		}
		/* Karthik added validation here to perform extra check for Multi encounter cases while subscription - Ends */
		if(allowSubscription==true){
			if(packageCode!="")
			{
				if(chargeLogic=='N')
					{
				checkForDuplicate(packageCode,index);
					}
				else
					callSysdate(index);
			}
			if(index==0){
				callSysdate(index);
			}		
			//Added By Vijay For KDAH-SCF-0404
			if(eval("formObj.blng_class_code"+index).value!=''|| eval("formObj.blng_class_code"+index).value!='')
			{
				callvalidate(index,function_id);					
			}
		}
	}else{
		packageDesc.value = "";
		packageCode.value = "" ;	
		eval("formObj.packageCode_"+index).value= "";
		eval("formObj.packageDesc_temp_"+index).value="";										
	}
}

function pkgSubsDateManipulation(index){
	var pkgFromDate=eval("document.forms[0].fromDate_"+index).value;
	var pkgToDate=eval("document.forms[0].toDate_"+index).value;
//	if(pkgFromDate!=''){
		$.ajax({
		        url:"../../eBL/jsp/PkgSubscriptionDateValidation.jsp",
		        type:'post',
		        async:false,
		        data: {
		              fromDate:pkgFromDate,
		              toDate:pkgToDate
		          },
	
		        success: function(data) {
		           var obj = jQuery.parseJSON(data);
		           eval("document.forms[0].fromDate_"+index).value=obj.fromDate;
		           eval("document.forms[0].toDate_"+index).value=obj.toDate;
		        }
		});	
//	}
}

/* Karthik added validation here to perform extra check for Multi encounter cases while subscription - Ends */
function isAcrossEncounterSupported(packageCodeList){	
	var URL="../../eBL/jsp/PkgSubscriptionAssociationDtlsValidation.jsp?action=across_encounter_check&packageCodeList="+packageCodeList;
	var xmlHttp = new XMLHttpRequest() ;
	xmlHttp.open("POST",URL,false);
	xmlHttp.send();
	var responseText=trimString(xmlHttp.responseText); 				

	var acrossEncounterParameter="N";
	if(responseText.indexOf("SUCCESS_ACROSS_ENCOUNTER")!=-1){ // If across encounter is true as SUCCESS_ACROSS_ENCOUNTER is  found
	acrossEncounterParameter="Y";
	}else{//across encounter is false as SUCCESS_ACROSS_ENCOUNTER is  found
	acrossEncounterParameter="N";	
	}	
	return acrossEncounterParameter;
}
/* Karthik added validation here to perform extra check for Multi encounter cases while subscription - Ends */

async function blngClassCodeLookUp(blng_class_desc,blng_class_code,index){
	var formObj=document.frmPkgSubs;
	if(formObj!=null){
		if(eval("formObj.blng_class_code_temp"+index+".value") != eval("formObj.blng_class_code"+index+".value"))
		{
			if(eval("formObj.blng_class_code"+index).value != ""){	
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var title=getLabel("Common.BillingClass.label","common");
				var locale=formObj.locale.value;
				var function_id=formObj.function_id.value;				
				argumentArray[0]	=  "select blng_class_code code, short_desc description from bl_blng_class_lang_vw where language_id='"+locale+"' and  (status is null or status != 'S') and upper(blng_class_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
				argumentArray[1]   = dataNameArray ;
				argumentArray[2]   = dataValueArray ;
				argumentArray[3]   = dataTypeArray ;
				argumentArray[4]   = "1,2";
				argumentArray[5]   = blng_class_code.value ;
				argumentArray[6]   = DESC_LINK ;
				argumentArray[7]   = CODE_DESC ;
				retVal = await CommonLookup( title, argumentArray );
var ret1=unescape(retVal);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
				if(retVal != null && retVal != ""){
					blng_class_desc.value = arr[1];
					blng_class_code.value =arr[0] ;
					eval("formObj.blng_class_code_temp"+index).value= arr[0];
					eval("formObj.blng_class_desc_temp"+index).value= arr[1];
				}else{
					blng_class_desc.value = "";
					blng_class_code.value = "" ;	
					eval("formObj.blng_class_code_temp"+index).value= "";
					eval("formObj.blng_class_desc_temp"+index).value="";										
				}
				callvalidate(index,function_id);			
			}
		}
	}	
}

function blngClassDescLookUp(blng_class_desc,blng_class_code,index){
	var formObj=document.frmPkgSubs;
	if(formObj!=null){
		if(eval("formObj.blng_class_desc_temp"+index+".value") != eval("formObj.blng_class_desc"+index+".value"))
		{
			if(eval("formObj.blng_class_desc"+index).value != "")
				show_blngClassLookUp(blng_class_desc,blng_class_code,index);
		}
	}
}

async function blngClassLookUp(blng_class_desc,blng_class_code,index){
	var formObj=document.frmPkgSubs;
		if(formObj!=null){
			if(eval("formObj.blng_class_desc"+index).value == ""){
					await show_blngClassLookUp(blng_class_desc,blng_class_code,index);
			}
		}
}

async function show_blngClassLookUp(blng_class_desc,blng_class_code,index){	
	var formObj=document.frmPkgSubs;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var title=getLabel("Common.BillingClass.label","common");
	var locale=formObj.locale.value;
	var function_id=formObj.function_id.value;

	argumentArray[0]	=  "select blng_class_code code, short_desc description from bl_blng_class_lang_vw where language_id='"+locale+"' and (status is null or status != 'S') and upper(blng_class_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = blng_class_desc.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	retVal = await CommonLookup( title, argumentArray );
	//alert("retVal value:"+retVal);
	var ret1=unescape(retVal);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
 	if(retVal != null && retVal != ""){
   		blng_class_desc.value = arr[1];
 		blng_class_code.value =arr[0] ;
		eval("formObj.blng_class_code_temp"+index).value= arr[0];
		eval("formObj.blng_class_desc_temp"+index).value= arr[1];			
 	}else{
   		blng_class_desc.value = "";
   		blng_class_code.value = "" ;
		eval("formObj.blng_class_code_temp"+index).value= "";
		eval("formObj.blng_class_desc_temp"+index).value="";				
 	}	
	callvalidate(index,function_id);			
}

async function payerGrpCodeLookUp(payerGrpDesc,payerGrpCode,index){	
	var formObj=document.frmPkgSubs;
	var locale=formObj.locale.value;	
	//Karthik added code for MMS-RY-SCF-0065
	var sql='';
	if(formObj.function_id.value != 'EBL_PACKAGE_SUBS'){
		var allPayerGroupCode=formObj.allPayerGroupCode.value;
		sql="select cust_group_code code, short_desc description from ar_cust_group_lang_vw where language_id='"+locale+"' and cust_group_code in ("+allPayerGroupCode+") and (status is null or status != 'S') and upper(cust_group_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
	}else{
		sql="select cust_group_code code, short_desc description from ar_cust_group_lang_vw where language_id='"+locale+"' and (status is null or status != 'S') and upper(cust_group_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
	}
	
	if(formObj!=null){
		if(eval("formObj.payerGrpCode_temp_"+index+".value") != eval("formObj.payerGrpCode_"+index+".value"))
		{
			if(eval("formObj.payerGrpCode_"+index).value != ""){	
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var title=getLabel("eBL.PAYER_GROUP.label","BL");
			
				argumentArray[0]	= sql ;
				argumentArray[1]   = dataNameArray ;
				argumentArray[2]   = dataValueArray ;
				argumentArray[3]   = dataTypeArray ;
				argumentArray[4]   = "1,2";
				argumentArray[5]   = payerGrpCode.value ;
				argumentArray[6]   = DESC_LINK ;
				argumentArray[7]   = CODE_DESC ;
				retVal = await CommonLookup( title, argumentArray );
				var ret1=unescape(retVal);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
				eval("formObj.payerCode_"+index).value= "";
				eval("formObj.payerDesc_"+index).value= "";
				eval("formObj.payerCode_temp_"+index).value= "";
				eval("formObj.payerDesc_temp_"+index).value= "";
				if(retVal != null && retVal != ""){
					payerGrpDesc.value = arr[1];
					payerGrpCode.value =arr[0] ;
					eval("formObj.payerGrpCode_temp_"+index).value= arr[0];
					eval("formObj.payerGrpDesc_temp_"+index).value= arr[1];
				}else{
					payerGrpDesc.value = "";
					payerGrpCode.value = "" ;	
					eval("formObj.payerGrpCode_temp_"+index).value= "";
					eval("formObj.payerGrpDesc_temp_"+index).value="";							
				}
			}
		}
	}	
}

function payerGrpDescLookUp(payerGrpDesc,payerGrpCode,index){
	var formObj=document.frmPkgSubs;
	if(formObj!=null){
		if(eval("formObj.payerGrpDesc_temp_"+index+".value") != eval("formObj.payerGrpDesc_"+index+".value"))
		{
			if(eval("formObj.payerGrpDesc_"+index).value != "")
				show_payerGrpLookUp(payerGrpDesc,payerGrpCode,index);
		}
	}
}

async function payerGrpLookUp(payerGrpDesc,payerGrpCode,index){
	var formObj=document.frmPkgSubs;
		if(formObj!=null){
			if(eval("formObj.payerGrpDesc_"+index).value == ""){
					await show_payerGrpLookUp(payerGrpDesc,payerGrpCode,index);
			}
		}
}

async function show_payerGrpLookUp(payerGrpDesc,payerGrpCode,index){
	var formObj=document.frmPkgSubs;
	var locale=formObj.locale.value;
	//Karthik added code for MMS-RY-SCF-0065
	var sql='';
	if(formObj.function_id.value != 'EBL_PACKAGE_SUBS' && formObj.allPayerGroupCode.value!=''){ // Extra condition check
		var allPayerGroupCode=formObj.allPayerGroupCode.value;
		sql="select cust_group_code code, short_desc description from ar_cust_group_lang_vw where language_id='"+locale+"'  and cust_group_code in ("+allPayerGroupCode+") and (status is null or status != 'S') and upper(cust_group_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
	}else{
		sql="select cust_group_code code, short_desc description from ar_cust_group_lang_vw where language_id='"+locale+"' and (status is null or status != 'S') and upper(cust_group_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
	}

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var title=getLabel("eBL.PAYER_GROUP.label","BL");
	
	argumentArray[0]	= sql ;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = payerGrpDesc.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	retVal = await CommonLookup( title, argumentArray );
	var ret1=unescape(retVal);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	eval("formObj.payerCode_"+index).value= "";
	eval("formObj.payerDesc_"+index).value= "";
	eval("formObj.payerCode_temp_"+index).value= "";
	eval("formObj.payerDesc_temp_"+index).value= "";
 	if(retVal != null && retVal != ""){
   		payerGrpDesc.value = arr[1];
 		payerGrpCode.value =arr[0] ;
		eval("formObj.payerGrpCode_temp_"+index).value= arr[0];
		eval("formObj.payerGrpDesc_temp_"+index).value= arr[1];			
 	}else{
   		payerGrpDesc.value = "";
   		payerGrpCode.value = "" ;
		eval("formObj.payerGrpCode_temp_"+index).value= "";
		eval("formObj.payerGrpDesc_temp_"+index).value="";				
 	}	
}

async function payerCodeLookUp(payerDesc,payerCode,payerGrpCode,index){
	var formObj=document.frmPkgSubs;
	var locale=formObj.locale.value;	
	//Karthik added code for MMS-RY-SCF-0065
	var sql='';
	if(formObj.function_id.value != 'EBL_PACKAGE_SUBS'){
		var allPayerCode=formObj.allPayerCode.value;
		sql= "select a.cust_code code, a.short_name description   from ar_customer_lang_vw a, BL_CUST_BY_CUST_GROUP b where a.cust_code=b.cust_code and b.cust_group_code='"+payerGrpCode.value+"' and a.cust_code in("+allPayerCode+") and a.language_id='"+locale+"' and (status is null or status <> 'S')  and upper(a.cust_code) like upper(?)  and upper(a.short_name) like upper(?) order by 2";
	}else{
		sql= "select a.cust_code code, a.short_name description   from ar_customer_lang_vw a, BL_CUST_BY_CUST_GROUP b where a.cust_code=b.cust_code and b.cust_group_code='"+payerGrpCode.value+"' and a.language_id='"+locale+"' and (status is null or status <> 'S')  and upper(a.cust_code) like upper(?)  and upper(a.short_name) like upper(?) order by 2";
	}	
	if(formObj!=null){
		if(eval("formObj.payerCode_temp_"+index+".value") != eval("formObj.payerCode_"+index+".value"))
		{
			if(eval("formObj.payerCode_"+index).value != ""){	
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var title=getLabel("eBL.PAYER_GROUP.label","BL");
				var function_id=formObj.function_id.value;				
				argumentArray[0]	= sql; 
				argumentArray[1]   = dataNameArray ;
				argumentArray[2]   = dataValueArray ;
				argumentArray[3]   = dataTypeArray ;
				argumentArray[4]   = "1,2";
				argumentArray[5]   = payerCode.value ;
				argumentArray[6]   = DESC_LINK ;
				argumentArray[7]   = CODE_DESC ;
				retVal = await CommonLookup( title, argumentArray );
var ret1=unescape(retVal);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
				if(retVal != null && retVal != ""){
					payerDesc.value = arr[1];
					payerCode.value =arr[0] ;
					eval("formObj.payerCode_temp_"+index).value= arr[0];
					eval("formObj.payerDesc_temp_"+index).value= arr[1];
					//alert("index="+index)					
				}else{
					payerDesc.value = "";
					payerCode.value = "" ;	
					eval("formObj.payerCode_temp_"+index).value= "";
					eval("formObj.payerDesc_temp_"+index).value="";								
				}
				callvalidate(index,function_id);			
			}
		}
	}	
}

function payerDescLookUp(payerDesc,payerCode,payerGrpCode,index){
	var formObj=document.frmPkgSubs;
	if(formObj!=null){
		if(eval("formObj.payerDesc_temp_"+index+".value") != eval("formObj.payerDesc_"+index+".value"))
		{
			if(eval("formObj.payerDesc_"+index).value != "")
				show_payerLookUp(payerDesc,payerCode,payerGrpCode,index);
		}
	}
}

async function payerLookUp(payerDesc,payerCode,payerGrpCode,index){
	var formObj=document.frmPkgSubs;
		if(formObj!=null){
			if(eval("formObj.payerDesc_"+index).value == ""){
					await show_payerLookUp(payerDesc,payerCode,payerGrpCode,index);
			}
		}
}

async function show_payerLookUp(payerDesc,payerCode,payerGrpCode,index){	
	var formObj=document.frmPkgSubs;
	var locale=formObj.locale.value;
	//Karthik added code for MMS-RY-SCF-0065
	var sql='';
	if(formObj.function_id.value != 'EBL_PACKAGE_SUBS'){
		var allPayerCode=formObj.allPayerCode.value;
		sql="select a.cust_code code, a.short_name description   from ar_customer_lang_vw a, BL_CUST_BY_CUST_GROUP b where a.cust_code=b.cust_code and b.cust_group_code='"+payerGrpCode.value+"' and a.cust_code in("+allPayerCode+")  and a.language_id='"+locale+"' and (status is null or status != 'S')  and upper(a.cust_code) like upper(?)  and upper(a.short_name) like upper(?) order by 2";
	}else{
		sql="select a.cust_code code, a.short_name description   from ar_customer_lang_vw a, BL_CUST_BY_CUST_GROUP b where a.cust_code=b.cust_code and b.cust_group_code='"+payerGrpCode.value+"'   and a.language_id='"+locale+"' and (status is null or status != 'S')  and upper(a.cust_code) like upper(?)  and upper(a.short_name) like upper(?) order by 2";
	}
	
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var title=getLabel("eBL.PAYER_GROUP.label","BL");
	var function_id=formObj.function_id.value;
	
	argumentArray[0]	=  sql;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = payerDesc.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	retVal = await CommonLookup( title, argumentArray );
	var ret1=unescape(retVal);
//	alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
 	if(retVal != null && retVal != ""){
   		payerDesc.value = arr[1];
 		payerCode.value =arr[0] ;
		eval("formObj.payerCode_temp_"+index).value= arr[0];
		eval("formObj.payerDesc_temp_"+index).value= arr[1];
		
		
 	}else{
   		payerDesc.value = "";
   		payerCode.value = "" ;
		eval("formObj.payerCode_temp_"+index).value= "";
		eval("formObj.payerDesc_temp_"+index).value="";				
 	}	
	callvalidate(index,function_id);			
}

/*For enquiry package  */
async function displaypkgDtls(index)
{
	var retVal				= new String();
	var dialogTop			= "10";
	var dialogHeight		= "900vh" ;
	var dialogWidth			= "800vw" ;
	var features			= "dialogTop:"+dialogTop+"; dialogHeight:"+dialogHeight+"; dialogWidth:"+dialogWidth+";status=no" ;
	var sql					= "";
	//var title				= "";
	var title=encodeURIComponent(getLabel("eBL.PACKAGE_DTL.label","BL"))
	var packageCode			= document.getElementById('packageCode_'+index).value;
	var blng_class_code		= document.getElementById('blng_class_code'+index).value;
	var payerGrpCode		= document.getElementById('payerGrpCode_'+index).value;
	var payerCode			= document.getElementById('payerCode_'+index).value;

	var param = "title="+title+"&packageCode="+packageCode+"&billingClass="+blng_class_code+"&customerGrp="+payerGrpCode+"&customerCode="+payerCode;
	if(packageCode != null&& packageCode != "")
		retVal=await window.showModalDialog("../../eBL/jsp/PkgEnqMain.jsp?"+param,arguments,features);	
}
//Added for NMC-JD-CRF-0084 on 260121 starts
function pkgDepositpkgParmChk1(Mul_pack_code){
	var frm = document.frmPkgSubs;
	var sysDate = frm.sysDate.value;
	var function_id = frm.function_id.value;
	var facility_id = frm.facility_id.value;
	Mul_pack_code = Mul_pack_code.replace(/^\[(.+)\]$/,'$1');
	Mul_pack_code = Mul_pack_code.split(",");
	var pkgcode_length=Mul_pack_code.length;
	if(pkgcode_length>0)
	{
		if (pkgcode_length==1)
		{
			var value	=Mul_pack_code;
				var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=validateParamPkgSubcDeposit&sysDate="+sysDate+"&function_id="+function_id+"&facility_id="+facility_id+"&Mul_pack_code="+value;
					var xmlHttp = new XMLHttpRequest();
					xmlHttp.open("POST", temp_jsp, false);
					xmlHttp.send();
					var responseText = trimString(xmlHttp.responseText);
					return responseText;
		}
		else
		{
		
			for(var i=0;i<pkgcode_length;i++)
				{
					var value	=Mul_pack_code[i];
					var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=validateParamPkgSubcDeposit&sysDate="+sysDate+"&function_id="+function_id+"&facility_id="+facility_id+"&Mul_pack_code="+value;
					var xmlHttp = new XMLHttpRequest();
					xmlHttp.open("POST", temp_jsp, false);
					xmlHttp.send();
					var responseText = trimString(xmlHttp.responseText);
					if(responseText=="Y")
					return responseText;
				}
		return responseText;
}
}
}
//Added for NMC-JD-CRF-0084 on 260121 Ends
//Added for NMC-JD-CRF-0084 on 260121 Strats
async function sitecallPkgDeposit(patient_id,funct_mode,Mul_pack_code)
{	

var Mul_pack_code=Mul_pack_code;
var retval=pkgDepositpkgParmChk1(Mul_pack_code);

if(retval=="Y")
{
	var function_id="PKG_BILLING";
	var eid="";
	var episodetype="R";
	var retVal="";
	var center='1';
	var dialogTop	= '70';
	var dialogHeight	= '42';
	var dialogWidth		= '70';
	var features		= 'dialogTop:' + dialogTop + '; dialogHeight:' + dialogHeight +'; center: ' + center + '; dialogWidth: ' + dialogWidth + '; status=no' ;
	var  arguments 		= "";
	var  column_sizes  		= escape("");
	var  column_descriptions  	= "";
	var msg="";
	var param="column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&patient_id="+patient_id+"&encounter_id="+eid+"&episode_type="+episodetype+"&episode_id="+eid+"&function_id="+function_id+"&funct_mode="+funct_mode;
	
	retVal=window.showModalDialog("../../eBL/jsp/BLEnterReceiptRefundFrame.jsp?"+param,arguments,features);
	while(retVal==null || retVal =="" || retVal==undefined || retVal=='undefined')
	{
		retVal=await window.showModalDialog("../../eBL/jsp/BLEnterReceiptRefundFrame.jsp?"+param,arguments,features);		
	}
}
}

	//add for NMC-JD-CRF-0084 05-02-2021 STARTS

function pkgDepositpkgParmChk(Mul_pack_code,function_id,facility_id,sysDate){
	Mul_pack_code = Mul_pack_code.replace(/\^/g,"");
	Mul_pack_code = Mul_pack_code.split(",");
	var pkgcode_length=Mul_pack_code.length;
	if(pkgcode_length>0)
	{
		if (pkgcode_length==1)
		{
				
			var value	=Mul_pack_code;
			var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=validateParamPkgSubcDeposit&sysDate="+sysDate+"&function_id="+function_id+"&facility_id="+facility_id+"&Mul_pack_code="+value;
					var xmlHttp = new XMLHttpRequest();
					xmlHttp.open("POST", temp_jsp, false);
					xmlHttp.send();
					var responseText = trimString(xmlHttp.responseText);
					
					return responseText;
		}
		else
		{
		
			for(var i=0;i<pkgcode_length;i++)
				{
					var value	=Mul_pack_code[i];
					var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=validateParamPkgSubcDeposit&sysDate="+sysDate+"&function_id="+function_id+"&facility_id="+facility_id+"&Mul_pack_code="+value;
					var xmlHttp = new XMLHttpRequest();
					xmlHttp.open("POST", temp_jsp, false);
					xmlHttp.send();
					var responseText = trimString(xmlHttp.responseText);
					if(responseText=="Y")
					return responseText;
				}
		return responseText;
}
}
}
//add for NMC-JD-CRF-0084 05-02-2021 ENDS


//Added for NMC-JD-CRF-0084 on 260121 Ends
async function callPkgDeposit(patient_id,funct_mode)
{	
	var function_id="PKG_BILLING";
	var eid="";
	var episodetype="R";
	var retVal="";
	var center='1';
	var dialogTop	= '70';
	var dialogHeight	= '80vh';
	var dialogWidth		= '75vw';
	var features		= 'dialogTop:' + dialogTop + '; dialogHeight:' + dialogHeight +'; center: ' + center + '; dialogWidth: ' + dialogWidth + '; status=no' ;
	var  arguments 		= "";
	var  column_sizes  		= escape("");
	var  column_descriptions  	= "";
	var msg="";
	var param="column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&patient_id="+patient_id+"&encounter_id="+eid+"&episode_type="+episodetype+"&episode_id="+eid+"&function_id="+function_id+"&funct_mode="+funct_mode;
	retVal=await window.showModalDialog("../../eBL/jsp/BLEnterReceiptRefundFrame.jsp?"+param,arguments,features);
	while(retVal==null || retVal =="" || retVal==undefined || retVal=='undefined')
	{
		retVal=await window.showModalDialog("../../eBL/jsp/BLEnterReceiptRefundFrame.jsp?"+param,arguments,features);		
	}
}

//Added Newly by MuthuN against 33044 on 15-6-2012
async function callPractSearch(obj,target,index){
	var formObj=document.frmPkgSubs;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var title=getLabel("Common.practitioner.label","common");
	var locale=formObj.locale.value;
	//V210419 starts
	var sitespec =formObj.siteBLPkgBlngGrpYN1.value;
    if(sitespec=='Y')
    {
        var dialogTop            = "40";
        var dialogHeight        = "10" ;
        var dialogWidth            = "40" ;
        var features            ="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
        var arguments            = "" ;                   
		var column_sizes = escape("35%,35%,30%");
		var prac_name = encodeURIComponent(getLabel("eBL.practitionername.label","eBL"));
		var prac_spec = encodeURIComponent(getLabel("eBL.practitionerspeciality.label","eBL"));
		var prac_id= encodeURIComponent(getLabel("eBL.practitionerid.label","eBL"));
		var column_descriptions =prac_name+","+prac_spec+","+prac_id;   
           
		var sql = "SELECT a.practitioner_name practitioner_name, b.long_desc practitioner_speciality, a.practitioner_id practitioner_id FROM am_practitioner a, am_speciality b WHERE a.primary_speciality_code = b.speciality_code AND a.eff_status = 'E'";
		sql=escape(sql);
		var message='';
		var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=1"+"&col_show_hide=YYY";
		retVal=await window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);
		var arr=new Array();                   
		if (retVal != null || retVal!="")
		{
			if(retVal!='undefined' && retVal!=undefined)
			{
				retVal=unescape(retVal);
				if(retVal != null && retVal.length>0)
				{
					arr=retVal.split("^~^");
					target.value=arr[0]; //added against V210419
					obj.value=arr[2];
				}
			}
			else
			{
				target.value="";
				obj.value=""; //added against  V210419
			}
		}
		else{
			target.value="";
			obj.value=""; //added against V210419
		}
	}else{
		var sql	=  "select SHORT_NAME description, PRACTITIONER_ID code from am_practitioner_lang_vw where UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) and language_id='"+locale+"'";
		argumentArray[0]	= sql;
		argumentArray[1]   = dataNameArray ;
		argumentArray[2]   = dataValueArray ;
		argumentArray[3]   = dataTypeArray ;	
		argumentArray[4]   = "2,1";	
		argumentArray[5]   = target.value ;
		argumentArray[6]   = DESC_LINK ;
		argumentArray[7]   = DESC_CODE ;
		retVal = await CommonLookup( title, argumentArray );
		if(retVal != null && retVal != ""){
			var ret1=unescape(retVal);
			arr=ret1.split(",");   		
			obj.value =arr[0] ;
			target.value = arr[1];
		}else{
			target.value = "";
			obj.value = "" ;
		}	
	}
	//V210419 Ends
}
//Added Newly by MuthuN against 33044 on 15-6-2012

//MMS-DM-SCF-0083
function checkJobStatusForEncounter(patientId){	
	var reqId = 0;
	$.ajax({
		type:"GET",
		url:"../jsp/PkgSubscriptionValidation.jsp",
		data:"func_mode=checkForMultEnc&patientId="+patientId,
		dataType:"text",
		async:false,
		success: function(data){
			reqId = parseInt($.trim(data));
			
		},
		 error: function(data){
			 reqId = 0;
	      }
	});
	return reqId;
}

function isValidDateTime(obj){		
	if(obj.value!=""){
		var flag=true;
		var RE_NUM =  /^\/?\d+$/;
		var dateTimeObj = obj.value;
		var dateTimeArr = dateTimeObj.split(" ");
		if(dateTimeArr.length != 2)  flag=false;
		var str_date = dateTimeArr[0];
		var str_time = dateTimeArr[1];

		if(!(checkDt1(str_date))){
			//return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
			alert(getMessage('INVALID_DATE_FMT','SM'));
			return false;
		}

		if(str_time!=undefined && str_time!='undefined'){
		if(!(isValidTime(str_time))){			
			//return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
			alert(getMessage('INVALID_DATE_FMT','SM'));
			return false;
		}
		}
	}
	return true;
}

function checkDt1(date1)
{
	if (date1.value != undefined)
	{
		date1 = date1.value;
	}
	else
	{
		date1=date1;
	}
    retval=true
    var date1arr=new Array()

    date1arr=date1.split("/")

    if(date1arr.length==3)
    {
        var date1d=date1arr[0]
        var date1m=date1arr[1]
        var date1y=date1arr[2]
        
        if(date1d.length != 2) return false;
        if(date1m.length != 2) return false;
        if(date1y.length != 4) return false;

		if (isNaN(date1d)==true) return false;
		if (isNaN(date1m)==true) return false;
		if (isNaN(date1y)==true) return false;

        date1d=eval(date1d)
        date1m=eval(date1m)
        date1yy=eval(date1y);

		if(date1m<=12)
        {
            if((date1m==1 || date1m==3 || date1m==5 || date1m==7 || date1m==8 || date1m==10 || date1m==12) && (date1d>31))
            {
                retval= false
            }

            if((date1m==4 || date1m==6 || date1m==9 || date1m==11 ) && (date1d>30))
            {
                retval= false
            }
            if ((date1y.length <4) || (date1y.length >4))
            {
                retval= false
            }
            if (date1m == 2) {
                if (date1d< 1) return false;

                if (LeapYear(date1yy) == true) {
                    if (date1d> 29) return false;
                }
                else {
                    if (date1d > 28) return false;
                }
            }

            if (isNaN(date1d)==true) retval = false;
            if (isNaN(date1m)==true) retval = false;
            if (isNaN(date1yy)==true) retval = false;
        }
        else
        {
            retval= false;
        }
    }
    else
    {
        retval= false;
    }
    return retval;
}

function isValidTime(time1)
{
	if (time1.value != undefined)
	{
		time1 = time1.value;
	}
	else
	{
		time1=time1;
	}
   time1=trimString(time1); 
   var retval=true;
   var strCheck = ':0123456789';
    for(var i=0;i<=time1.length;i++) {
        if (strCheck.indexOf(time1.charAt(i)) == -1){
            retval = false;
            break;
        }
    }	
    if (retval)
    {		
       var time1arr=new Array();
       time1arr=time1.split(":");
            if(time1arr.length==3)
            {
                var time1hr=time1arr[0];
                var time1min=time1arr[1];
                var time1sec = time1arr[2];
				if (time1hr.length != 2 || time1min.length != 2)
				{
					 retval=false;
				}
                time1hr=eval(time1hr)
                time1min=eval(time1min)

                if(time1hr<=23)
                {
                    if(time1min>59)
                    { 
                    	retval=false; 
                    }else{
                    	if(time1sec>59) {
                    		 retval=false; 
                    	}                    	                                               
                    }                   
                }
                else
                        retval=false;
            }
            else{	            	
                retval=false;
			}        
    }		
    return retval;
}

function cal_error (str_message,obj) {
	alert (str_message);
	//obj.focus();
	//obj.select();
	obj.value="";
	return false;
}

function dateDisplay(rec_count,effToDate,calledFrom)
{
//	alert('called from in date disp' +calledFrom)
	/*alert('message id '+$('#strMessageId').val());
	alert('error text '+$('strErrorText').val());
	*/var msg="";
	var error_codes=new Array();
	
if(calledFrom=='Pkgsubsheader')
{
	
	if($('#strMessageId').val()!=""){
		
		if($('#strMessageId').val().indexOf('|') != -1){
			error_codes=($('#strMessageId').val()).split('|');
			for(var i=0;i<error_codes.length;i++){
				msg=msg+"\n"+getMessage(error_codes[i],"BL");
				$('#strMessageId').val(msg);
				//alert('msg in loop '+msg);
			}
		}else{
			msg=getMessage($('#strMessageId').val(),"BL");
			$('#strMessageId').val(msg);
		}
	}else if($('#strErrorText').val()!=""){
		msg=strErrorText;			
		$('#strErrorText').val(msg);
	}
	
	if(msg!=""){
		alert(msg);
		/*eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.packageCode_"+rec_count).value=""
		eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.packageDesc_"+rec_count).value=""
		*//*parent.PkgSubscriptionDtls.document.frmPkgSubs.strMessageId.value="";
		parent.PkgSubscriptionDtls.document.frmPkgSubs.strErrorText.value="";*/
		/*$('#strMessageId').val('');
		$('#strErrorText').val('');*/
		
		$(parent.PkgSubscriptionDtls.document).find('#to_date'+rec_count).text(effToDate);
		return false;
	}
	else
		{
		$('#strErrorText').val('');
		$('#strMessageId').val('');
		}
}
	
	else if(calledFrom=='PkgAssocnExisting')
		{
		
		/*alert('in else if');
		alert('error id '+parent.PkgSubscriptionDtls.document.frmPkgSubs.strMessageId.value);
		alert('error text'+parent.PkgSubscriptionDtls.document.frmPkgSubs.strErrorText.value);
		*/	if(parent.PkgSubscriptionDtls.document.frmPkgSubs.strMessageId.value!=""){
			
			if((parent.PkgSubscriptionDtls.document.frmPkgSubs.strMessageId.value).indexOf('|') != -1){
				error_codes=(parent.PkgSubscriptionDtls.document.frmPkgSubs.strMessageId.value).split('|');
				for(var i=0;i<error_codes.length;i++){
					msg=msg+"\n"+getMessage(error_codes[i],"BL");
					parent.PkgSubscriptionHeader.document.frmPkgDefHeader.strMessageId.value=msg;
					
				}
			}else{
				msg=getMessage(parent.PkgSubscriptionDtls.document.frmPkgSubs.strMessageId.value,"BL");
				parent.PkgSubscriptionHeader.document.frmPkgDefHeader.strMessageId.value=msg;
			}
		}else if(parent.PkgSubscriptionDtls.document.frmPkgSubs.strErrorText.value!=""){
			msg=strErrorText			
			parent.PkgSubscriptionHeader.document.frmPkgDefHeader.strErrorText.value=msg;
		}
		if(msg!=""){
			alert(msg);
			//eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.packageCode_"+rec_count).value=""
			//eval("parent.PkgSubscriptionDtls.document.frmPkgSubs.packageDesc_"+rec_count).value=""
			parent.PkgSubscriptionDtls.document.frmPkgSubs.strMessageId.value="";
			parent.PkgSubscriptionDtls.document.frmPkgSubs.strErrorText.value="";
			$(parent.PkgSubscriptionDtls.document).find('#to_date'+rec_count).text(effToDate);
			return false;
		}		
		else
			{
			parent.PkgSubscriptionHeader.document.frmPkgDefHeader.strMessageId.value='';
			parent.PkgSubscriptionHeader.document.frmPkgDefHeader.strErrorText.value='';
			}
		}

	/**//*	alert(parent.name);
	alert(parent.frames[1].name);
	*/	//return false;
	$(parent.PkgSubscriptionDtls.document).find('#to_date'+rec_count).text(effToDate);
}

//Added By Shikha For GHL-CRF-0520.1
async function blngGrpCodeLookUp(blngGrpDesc,blngGrpCode,index){		
    var formObj=document.frmPkgSubs;
    var locale=formObj.locale.value;		
    var facility_id=formObj.facility_id.value;
    var function_id=formObj.function_id.value; 	//Added By Shikha For GHL-CRF-0520.1
    var sql='';
    if(formObj.function_id.value != 'EBL_PACKAGE_SUBS'){
        var allBlngGroupCode=formObj.allBlngGroupCode.value;
        sql="select blng_grp_id code, short_desc description from bl_blng_grp_lang_vw where language_id='"+locale+"' and blng_grp_id in ("+allBlngGroupCode+") and (status is null or status <> 'S') AND ((blcommon.IS_FUNCTION_APPLICABLE_YN('BL','BL_BLNG_GRP_FACILITY') = 'N') OR ((blcommon.IS_FUNCTION_APPLICABLE_YN('BL','BL_BLNG_GRP_FACILITY') = 'Y') AND (blng_grp_id IN(SELECT b.blng_Grp_id FROM bl_blng_grp_facility b WHERE  b.facility_id = '"+facility_id+"')))) and upper(blng_grp_id) like upper(?) and upper(short_desc) like upper(?) order by 2";		
    }else{
        sql="select blng_grp_id code, short_desc description from bl_blng_grp_lang_vw where language_id='"+locale+"' and (status is null or status <> 'S') AND ((blcommon.IS_FUNCTION_APPLICABLE_YN('BL','BL_BLNG_GRP_FACILITY') = 'N') OR ((blcommon.IS_FUNCTION_APPLICABLE_YN('BL','BL_BLNG_GRP_FACILITY') = 'Y') AND (blng_grp_id IN(SELECT b.blng_Grp_id FROM bl_blng_grp_facility b WHERE  b.facility_id = '"+facility_id+"')))) and upper(blng_grp_id) like upper(?) and upper(short_desc) like upper(?) order by 2";		
    }	
	if(formObj!=null){
		if(eval("formObj.blngGrpCode_temp_"+index+".value") != eval("formObj.blngGrpCode_"+index+".value"))
		{
			if(eval("formObj.blngGrpCode_"+index).value != ""){	
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var title=getLabel("eBL.BillingGroup.label","BL");
			
				argumentArray[0]	= sql ;
				argumentArray[1]   = dataNameArray ;
				argumentArray[2]   = dataValueArray ;
				argumentArray[3]   = dataTypeArray ;
				argumentArray[4]   = "1,2";
				argumentArray[5]   = blngGrpCode.value ;
				argumentArray[6]   = DESC_LINK ;
				argumentArray[7]   = CODE_DESC ;
				retVal = await CommonLookup( title, argumentArray );				
				if(retVal != null && retVal != ""){
  					blngGrpDesc.value = retVal[1];
  					blngGrpCode.value =retVal[0] ;
  					eval("formObj.blngGrpCode_temp_"+index).value= retVal[0];
  					eval("formObj.blngGrpDesc_temp_"+index).value= retVal[1];
				}else{
  					blngGrpDesc.value = "";
  					blngGrpCode.value = "" ;	
  					eval("formObj.blngGrpCode_temp_"+index).value= "";
  					eval("formObj.blngGrpDesc_temp_"+index).value="";										
				}
			}
		}		
		if(eval("formObj.blng_class_code"+index).value!=''|| eval("formObj.blng_class_code"+index).value!='')
		{
			  callvalidate(index,function_id);					
		}
	}		
}

function blngGrpDescLookUp(blngGrpDesc,blngGrpCode,index){
	var formObj=document.frmPkgSubs;
	if(formObj!=null){
		if(eval("formObj.blngGrpDesc_temp_"+index+".value") != eval("formObj.blngGrpDesc_"+index+".value"))
		{
			if(eval("formObj.blngGrpDesc_"+index).value != "")
				show_blngGrpLookUp(blngGrpDesc,blngGrpCode,index);
		}
	}
}

function blngGrpLookUp(blngGrpDesc,blngGrpCode,index){
  var formObj=document.frmPkgSubs;
	if(formObj!=null){
		if(eval("formObj.blngGrpDesc_"+index).value == ""){
				show_blngGrpLookUp(blngGrpDesc,blngGrpCode,index);
		}
	}
}

async function show_blngGrpLookUp(blngGrpDesc,blngGrpCode,index){
    var formObj=document.frmPkgSubs;
    var locale=formObj.locale.value;
    var facility_id=formObj.facility_id.value;
    var function_id=formObj.function_id.value;
    var sql='';
    if(formObj.function_id.value != 'EBL_PACKAGE_SUBS' && formObj.allBlngGroupCode.value!=''){ // Extra condition check
        var allBlngGroupCode=formObj.allBlngGroupCode.value;
        sql="select blng_grp_id code, short_desc description from bl_blng_grp_lang_vw where language_id='"+locale+"'  and blng_grp_id in ("+allBlngGroupCode+") and (status is null or status <> 'S') AND ((blcommon.IS_FUNCTION_APPLICABLE_YN('BL','BL_BLNG_GRP_FACILITY') = 'N') OR ((blcommon.IS_FUNCTION_APPLICABLE_YN('BL','BL_BLNG_GRP_FACILITY') = 'Y') AND (blng_grp_id IN(SELECT b.blng_Grp_id FROM bl_blng_grp_facility b WHERE  b.facility_id = '"+facility_id+"')))) and upper(blng_grp_id) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
    }else{
        sql="select blng_grp_id code, short_desc description from bl_blng_grp_lang_vw where language_id='"+locale+"' and (status is null or status <> 'S') AND ((blcommon.IS_FUNCTION_APPLICABLE_YN('BL','BL_BLNG_GRP_FACILITY') = 'N') OR ((blcommon.IS_FUNCTION_APPLICABLE_YN('BL','BL_BLNG_GRP_FACILITY') = 'Y') AND (blng_grp_id IN(SELECT b.blng_Grp_id FROM bl_blng_grp_facility b WHERE  b.facility_id = '"+facility_id+"')))) and upper(blng_grp_id) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
    }

  	var argumentArray  = new Array() ;
  	var dataNameArray  = new Array() ;
  	var dataValueArray = new Array() ;
  	var dataTypeArray  = new Array() ;
  	var title=getLabel("eBL.BillingGroup.label","BL");
	
  	argumentArray[0]	= sql ;
  	argumentArray[1]   = dataNameArray ;
  	argumentArray[2]   = dataValueArray ;
  	argumentArray[3]   = dataTypeArray ;
  	argumentArray[4]   = "1,2";
  	argumentArray[5]   = blngGrpDesc.value ;
  	argumentArray[6]   = DESC_LINK ;
  	argumentArray[7]   = CODE_DESC ;
  	retVal = await CommonLookup( title, argumentArray );	
   	if(retVal != null && retVal != ""){
        blngGrpDesc.value = retVal[1];
        blngGrpCode.value =retVal[0] ;
        eval("formObj.blngGrpCode_temp_"+index).value= retVal[0];
        eval("formObj.blngGrpDesc_temp_"+index).value= retVal[1];			
   	}else{
        blngGrpDesc.value = "";
        blngGrpCode.value = "" ;
        eval("formObj.blngGrpCode_temp_"+index).value= "";
        eval("formObj.blngGrpDesc_temp_"+index).value="";				
   	}	 	
   	if(eval("formObj.blng_class_code"+index).value!=''|| eval("formObj.blng_class_code"+index).value!='')
  	{
  		  callvalidate(index,function_id);					
  	}
}
//Ended By Shikha For GHL-CRF-0520.1

