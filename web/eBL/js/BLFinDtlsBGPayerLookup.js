
/*
Sr No        Version           Incident        SCF/CRF             Developer Name
----------------------------------------------------------------------------------
 1           V210211            12033       AMS-CRF-00249            Ram kumar S
*/

$(document).ready(function(){
	$('.ancResults').click(function(){
		var indx = this.rownum;
		var billingGroup = $('#billing_'+indx).text();
		var billingGroupCode = $('#billingCode_'+indx).val();
		var payerGroup = $('#payerGroup_'+indx).text();
		var payerGroupCode = $('#payerGroupCode_'+indx).val();
		var payer = $('#payer_'+indx).text();
		var payerCode = $('#payerCode_'+indx).val();
		var policy = $('#policy_'+indx).text();
		var policyCode = $('#policyCode_'+indx).val();
		var priority = $('#priority_'+indx).text();
		var cnt = $(parent.DisplayFrame.document).find('#tblDisplay tr:last').attr('rownum');
		var dataArray = $(parent.DisplayFrame.document).find('#precessedArray').val().split('####');
		var arrId = billingGroupCode+":::"+payerGroupCode+":::"+payerCode+":::"+policyCode+":::"+priority;
		var arrCnt = $.inArray(arrId,dataArray)
		if(arrCnt == -1){
			dataArray.push(arrId);
			parent.DisplayFrame.document.getElementById('precessedArray').value = dataArray.join('####')
		}
		else{
			alert('Payer already added');
			return false;
		}
		//alert(parent.DisplayFrame.document.getElementById('precessedArray').value)
		if(cnt == undefined){
			cnt = 1;
		}
		else{
			cnt++;
		}
		var tableContents = "<tr class='tr_class' id='tr_"+cnt+"' rownum='"+cnt+"'> "+
							"<td width='20%' class='label' nowrap> "+
								"<span id='billing_"+cnt+"'>"+billingGroup+"</span> "+
								"<input type='hidden' name='billingCode_"+cnt+"' id='billingCode_"+cnt+"' id='billingCode_"+cnt+"' value='"+billingGroupCode+"'> "+
							"</td> "+
							"<td width='20%' class='label' nowrap> "+
								"<span id='payerGroup_"+cnt+"'>"+payerGroup+"</span> "+
								"<input type='hidden' name='payerGroupCode_"+cnt+"' id='payerGroupCode_"+cnt+"' id='payerGroupCode_"+cnt+"' value='"+payerGroupCode+"'> "+
							"</td> "+
							"<td width='20%' class='label' nowrap> "+
								"<span id='payer_"+cnt+"'>"+payer+"</span> "+
								"<input type='hidden' name='payerCode_"+cnt+"' id='payerCode_"+cnt+"' id='payerCode_"+cnt+"' value='"+payerCode+"'> "+
							"</td> "+
							"<td width='20%' class='label' nowrap> "+
								"<span id='policy_"+cnt+"'>"+policy+"</span> "+
								"<input type='hidden' name='policyCode_"+cnt+"' id='policyCode_"+cnt+"' id='policyCode_"+cnt+"' value='"+policyCode+"'> "+
							"</td> "+
							"<td width='16%' class='label' nowrap> "+
							"<span id='priority_"+cnt+"'>"+priority+"</span> "+
							"</td> "+
							"<td width='4%' nowrap> "+
								"<input class='chk_box' rownum='"+cnt+"' type='checkbox' name='chk_"+cnt+"' id='chk_"+cnt+"' id='chk_"+cnt+"'> "+
							"</td> "+
							"</tr> ";
		$(parent.DisplayFrame.document).find('#tblDisplay tr:last').after(tableContents);
		
	});
	
	$('#removePayer').click(function(){
		//alert('remove')
		$('.chk_box').each(function(){
			if(this.checked){
				var cnt = this.rownum;
				
				var dataArray = parent.DisplayFrame.document.getElementById('precessedArray').value.split('####');
				var arrId = $('#billingCode_'+cnt).val()+":::"+
							$('#payerGroupCode_'+cnt).val()+":::"+
							$('#payerCode_'+cnt).val()+":::"+
							$('#policyCode_'+cnt).val()+":::"+
							$('#priority_'+cnt).text();
				//alert(arrId)
				dataArray.splice($.inArray(arrId, dataArray),1);
				parent.DisplayFrame.document.getElementById('precessedArray').value = dataArray.join('####')
				//alert(parent.DisplayFrame.document.getElementById('precessedArray').value)
				$('#tr_'+cnt).remove();
			}
		});
	});
	
	$('#btnClose').click(function(){
		var returnParam = '';
		var blngParam = '';
		var firstBG = '';
		var bgConflict = 'N';
		var orderCnt = 0;		
		$('.tr_class').each(function(){
			orderCnt++;
			//alert(orderCnt)
			var cnt = this.rownum;
			if(orderCnt == 1){
				var blngCode = $('#billingCode_'+cnt).val();
				firstBG = blngCode;
				var searchFrm = parent.SearchFrame.document.frmBGPayerSearch;
				var blnggrp			= searchFrm.blnggrp.value; 		
				var ExtBillingGroup = searchFrm.ext_blng_grp.value;
				var strCitizenYn = searchFrm.citizen_yn.value;
				var patient_id= searchFrm.patient_id.value;
				var encounter_date = searchFrm.encounter_date.value;
				var episode_type = searchFrm.episode_type.value;
				var function_id = searchFrm.function_id.value;
				
				var param = '&patient_id='+patient_id+'&episode_type='+episode_type+'&function_id='+function_id+
				'&blnggrp='+blnggrp+'&encounter_date='+encounter_date+'&citizen_yn='+strCitizenYn+'&ext_blng_grp='+ExtBillingGroup+
				'&billingGroup='+blngCode; 
				
				var xmlStr ="<root><SEARCH ";				
				xmlStr +=" /></root>";
				var temp_jsp="../../eBL/jsp/EncounterCommonValidation.jsp?func_mode=getBlngGrpParams"+param;
				
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

				xmlHttp.open("POST",temp_jsp,false);
				xmlHttp.send(xmlDoc);
			
				var responseText=xmlHttp.responseText ;
				blngParam = responseText;
			}
			if($('#billingCode_'+cnt).val() != firstBG){
				alert('Policies of Different Billing Groups cannot be added here');
				bgConflict = 'Y';
				return false;
			}
			returnParam += '~'+$('#billingCode_'+cnt).val()+'|'+$('#payerGroupCode_'+cnt).val()+'|'+$('#payerCode_'+cnt).val()+'|'+$('#policyCode_'+cnt).val()+'|'+$('#priority_'+cnt).text();
		});

		if(bgConflict == 'N'){
			if(returnParam.length>0){
				var xmlStr ="<root><SEARCH ";				
				xmlStr +=" /></root>";
				var temp_jsp="../../eBL/jsp/EncounterCommonValidation.jsp?func_mode=loadPayerFinDtls&payerDtls="+returnParam;
				
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

				xmlHttp.open("POST",temp_jsp,false);
				xmlHttp.send(xmlDoc);
			
				var responseText=xmlHttp.responseText ;
				parent.window.returnValue = blngParam;//$(parent.ResultFrame.document).find('#payerHdnVal').val();
				parent.window.close();
			}
			else{
				parent.window.close();
			}
		}				
	});
	
	$('.ancTag').click(function(){
		var indx = this.rownum;
		var billingGroup = $('#blngHdn_'+indx).val();
		parent.window.returnValue = escape(billingGroup);
		parent.window.close();
	});
	
	var clng_evnt = $('#clng_evnt').val();
	if(clng_evnt == 'B'){
		$('#blngGroup').blur();
	}
	else{
		$('#blngGroup').focus();
	}
});

function changeRadioSelection(){
	var frm = document.frmBGPayerSearch; 
	var payerGroup = frm.payerGroup.value.length;
	var payerGroupCode = frm.payerGroupCode.value.length;
	var payer = frm.payer.value.length;
	var payerCode = frm.payerCode.value.length;
	var policy = frm.policy.value.length;
	var policyCode = frm.policyCode.value.length;
	
	var rad = frm.bgSelection;
	var selection = '';
	for(var i=0;i<rad.length;i++){
		if(rad[i].checked){
			selection = rad[i].value;
		}
	}
	
	if(payerGroup > 0 || payerGroupCode>0 || payer>0 || payerCode>0 || policy>0 || policyCode>0){
		//alert('P');
		 $('input[name="bgSelection"][value="P"]').attr('checked',true);
		 if(frm.blngGroupCode.value.length<1){
			frm.blngGroup.value='';
			frm.blngGroupCode.value='';
		}
		 
		 if(selection != 'P'){
			 parent.ResultFrame.document.location.href = '../../eCommon/html/blank.html';
		 }
		 
	}
	else{
		//alert('B');
		 $('input[name="bgSelection"][value="B"]').attr('checked',true);
		 parent.ResultFrame.document.location.href = '../../eCommon/html/blank.html';
		 parent.DisplayFrame.document.getElementById('divResults').style.visibility = 'hidden';
	}
}
function fnChageSelection(){
	var frm = document.frmBGPayerSearch;
	var rad = frm.bgSelection;
	var selection = '';
	for(var i=0;i<rad.length;i++){
		if(rad[i].checked){
			selection = rad[i].value;
		}
	}
	
	if(selection == 'B'){
		/*frm.payerGroup.disabled = true;
		frm.payer.disabled = true;
		frm.policy.disabled = true;*/
		
		frm.payerGroup.value = '';
		frm.payer.value = '';
		frm.policy.value = '';
		
		/*frm.payerGroupBtn.disabled = true;
		frm.payerBtn.disabled = true;
		frm.policyBtn.disabled = true;*/
		
		frm.payerGroupCode.value = '';
		frm.payerCode.value = '';
		frm.policyCode.value = '';
		parent.DisplayFrame.document.getElementById('divResults').style.visibility = 'hidden';
	}
	else if(selection == 'P'){
		frm.payerGroup.disabled = false;
		frm.payer.disabled = false;
		frm.policy.disabled = false;
		
		frm.payerGroupBtn.disabled = false;
		frm.payerBtn.disabled = false;
		frm.policyBtn.disabled = false;
		if(frm.blngGroupCode.value.length<1){
			frm.blngGroup.value='';
			frm.blngGroupCode.value='';
		}		
	}
	parent.ResultFrame.document.location.href = '../../eCommon/html/blank.html';
	//parent.DisplayFrame.document.location.href = '../../eCommon/html/blank.html';
}

function fnSearch(){
	var frm = document.frmBGPayerSearch;
	var rad = frm.bgSelection;
	var selection = '';
	for(var i=0;i<rad.length;i++){
		if(rad[i].checked){
			selection = rad[i].value;
		}
	}
	var blngGroup = frm.blngGroupCode.value;
	var payerCode = frm.payerGroupCode.value;
	var payer = frm.payerCode.value;
	var policy = frm.policyCode.value;
	
	var patient_id = frm.patient_id.value;
	var episode_type = frm.episode_type.value;
	var function_id = frm.function_id.value;
	var blnggrp = frm.blnggrp.value;
	var ageVal = frm.ageVale.value;//V210211
	var encounter_date = frm.encounter_date.value;
	var citizen_yn = frm.citizen_yn.value;
	var ext_blng_grp = frm.ext_blng_grp.value;
	var previousBG = frm.previousBG.value;
	frm.previousBG.value = blngGroup;
	if(selection == 'B'){

		blngGroup = frm.blngGroup.value;
		parent.ResultFrame.document.location.href = '../jsp/BLFinDtlsBGPayerResults.jsp?selection=B&blngGroup='+encodeURIComponent(blngGroup)+
			'&patient_id='+encodeURIComponent(patient_id)+
			'&episode_type='+encodeURIComponent(episode_type)+
			'&function_id='+encodeURIComponent(function_id)+
			'&blnggrp='+encodeURIComponent(blnggrp)+
			'&encounter_date='+encodeURIComponent(encounter_date)+
			'&citizen_yn='+encodeURIComponent(citizen_yn)+
			'&ext_blng_grp='+encodeURIComponent(ext_blng_grp)+
			'&ageVal='+encodeURIComponent(ageVal);//V210211
		parent.DisplayFrame.location.href='../../eBL/jsp/BLFinDtlsBGPayerDisplay.jsp';
		parent.DisplayFrame.document.getElementById('divResults').style.visibility = 'hidden';
	}
	else if(selection == 'P'){
		//if(blngGroup.length>0){
			parent.ResultFrame.document.location.href = '../jsp/BLFinDtlsBGPayerResults.jsp?selection=P&blngGroup='+encodeURIComponent(blngGroup)+
			'&payerCode='+encodeURIComponent(payerCode)+'&payer='+encodeURIComponent(payer)+'&policy='+encodeURIComponent(policy)+
			'&patient_id='+encodeURIComponent(patient_id)+
			'&episode_type='+encodeURIComponent(episode_type)+
			'&function_id='+encodeURIComponent(function_id)+
			'&blnggrp='+encodeURIComponent(blnggrp)+
			'&encounter_date='+encodeURIComponent(encounter_date)+
			'&citizen_yn='+encodeURIComponent(citizen_yn)+
			'&ext_blng_grp='+encodeURIComponent(ext_blng_grp);

			if(blngGroup != previousBG){
				parent.DisplayFrame.location.href='../../eBL/jsp/BLFinDtlsBGPayerDisplay.jsp?visibility=Y';
			}
			else{
				parent.DisplayFrame.document.getElementById('divResults').style.visibility = 'visible';
			}
			
			//parent.DisplayFrame.document.getElementById('divResults').style.visibility = 'visible';
		//}
		//else{
		//	alert(getMessage('BL9301','BL'));
		//}
	}	
}

async function callCommonValidation(sqlSelect,obj,code){
	//alert("3");
	var frm = document.frmBGPayerSearch;
	var rad = frm.bgSelection;
	var selection = '';
	for(var i=0;i<rad.length;i++){
		if(rad[i].checked){
			selection = rad[i].value;
		}
	}
	var locale = frm.locale.value;
	var facility_id = frm.facility_id.value;
	if(selection == 'B'){
		if(sqlSelect != 1){
			var argumentArray  = new Array();
			var dataNameArray  = new Array();
			var dataValueArray = new Array();
			var dataTypeArray  = new Array();
			var sql = '';
			var title = '';
			switch(sqlSelect){
				case 2:
				{
					sql = "Select description,code from (Select short_name description,cust_code code from ar_customer_lang_vw "+
							"Where  upper(language_id) = upper('"+locale+"') union  Select 'All Payer','**' From Dual) where upper(description) like upper(?) and upper(code) like upper(?) ";

					title = 'Payer';
					break;
				}
				case 3:
				{
								sql="select description,code from (select short_desc description, cust_group_code code from ar_cust_group_lang_vw where "+
							"upper(language_id) = upper('"+locale+"') union Select 'All Payer Group','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) "+
					" order by 2";

					title = 'Payer Group';
					break;
				}
				case 4:
				{
					sql="select short_desc description,policy_type_code code from bl_ins_policy_types_lang_vw where nvl(status,'A') !='S' and operating_facility_id = '"+facility_id+"' and upper(language_id) = upper('"+locale+"') and upper(short_desc) like upper(?) and upper(policy_type_code) like upper(?) order by 2";
					title = 'Policy';
					break;
				}
				
			}


			//var sql="SELECT DESCRIPTION, CODE FROM (SELECT 'All' DESCRIPTION,'*ALL' CODE FROM DUAL UNION SELECT A.SHORT_DESC DESCRIPTION,A.SPECIALITY_CODE CODE FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B  WHERE A.LANGUAGE_ID='"+locale+"' AND  A.SPECIALITY_CODE = B.SPECIALITY_CODE ) WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?) ORDER BY 2";
			argumentArray[0] = sql;
			argumentArray[1] = dataNameArray;
			argumentArray[2] = dataValueArray;
			argumentArray[3] = dataTypeArray;
			argumentArray[4] = "2,1";
			argumentArray[5] = obj.value;
			argumentArray[6] = DESC_LINK;
			argumentArray[7] = DESC_CODE;

			returnedValues = await CommonLookup(title, argumentArray );
			var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			if((returnedValues != null) && (returnedValues != "") )  {
				obj.value = arr[1];
				code.value = arr[0];	
			}
			else
			{
			obj.value = arr[1];
			code.value = arr[0];		
				//obj.value = returnedValues[1];
			} 
		}
		else{
			var patient_id = frm.patient_id.value;
			var episode_type = frm.episode_type.value;
			var function_id = frm.function_id.value;
			var blnggrp = frm.blnggrp.value;
			var encounter_date = frm.encounter_date.value;
			var citizen_yn = frm.citizen_yn.value;
			var ext_blng_grp = frm.ext_blng_grp.value;
			var blngGroup = frm.blngGroup.value;
			parent.ResultFrame.document.location.href = '../jsp/BLFinDtlsBGPayerResults.jsp?selection=B&blngGroup='+encodeURIComponent(blngGroup)+
				'&patient_id='+encodeURIComponent(patient_id)+
				'&episode_type='+encodeURIComponent(episode_type)+
				'&function_id='+encodeURIComponent(function_id)+
				'&blnggrp='+encodeURIComponent(blnggrp)+
				'&encounter_date='+encodeURIComponent(encounter_date)+
				'&citizen_yn='+encodeURIComponent(citizen_yn)+
				'&ext_blng_grp='+encodeURIComponent(ext_blng_grp);
			//parent.DisplayFrame.document.getElementById('divResults').style.visibility = 'hidden';
		}
	}
	else if(selection == 'P'){
		var argumentArray  = new Array();
		var dataNameArray  = new Array();
		var dataValueArray = new Array();
		var dataTypeArray  = new Array();
		var sql = '';
		var title = '';
		switch(sqlSelect){
				
			case 1:
			{
				sql = frm.queryForJs.value;
				sql="select description, code  from ("+sql+
						"Union Select 'All Billing Group','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?)  order by 2";
				title = 'Billing Group';
				break;
			}
			case 2:
			{
				
				sql = "Select description,code from (Select short_name description,cust_code code from ar_customer_lang_vw "+
						"Where  upper(language_id) = upper('"+locale+"') union  Select 'All Payer','**' From Dual) where upper(description) like upper(?) and upper(code) like upper(?) ";

				title = 'Payer';
				break;
			}
			case 3:
			{
							sql="select description,code from (select short_desc description, cust_group_code code from ar_cust_group_lang_vw where "+
						"upper(language_id) = upper('"+locale+"') union Select 'All Payer Group','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) "+
				" order by 2";

				title = 'Payer Group';
				break;
			}
			case 4:
			{
				sql="select short_desc description,policy_type_code code from bl_ins_policy_types_lang_vw where nvl(status,'A') !='S' and operating_facility_id = '"+facility_id+"' and upper(language_id) = upper('"+locale+"') and upper(short_desc) like upper(?) and upper(policy_type_code) like upper(?) order by 2";
				title = 'Policy';
				break;
			}
			
		}


		//var sql="SELECT DESCRIPTION, CODE FROM (SELECT 'All' DESCRIPTION,'*ALL' CODE FROM DUAL UNION SELECT A.SHORT_DESC DESCRIPTION,A.SPECIALITY_CODE CODE FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B  WHERE A.LANGUAGE_ID='"+locale+"' AND  A.SPECIALITY_CODE = B.SPECIALITY_CODE ) WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?) ORDER BY 2";
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray;
		argumentArray[2] = dataValueArray;
		argumentArray[3] = dataTypeArray;
		argumentArray[4] = "2,1";
		argumentArray[5] = obj.value;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;

		returnedValues = await CommonLookup(title, argumentArray );
		var ret1=unescape(returnedValues);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		if((returnedValues != null) && (returnedValues != "") )  {
			obj.value = arr[1];
			code.value = arr[0];	
		}
		else
		{
		obj.value = '';
		code.value = '';		
			//obj.value = returnedValues[1];
		} 

	}
	
}

function fnClearCode(obj){
	obj.value = '';
}

function movePrevthis(start,end)
{
	var frm =  document.forms[0];
	var blngGroup = frm.blngGroupCode.value;
	var payerCode = frm.payerGroupCode.value;
	var payer = frm.payerCode.value;
	var policy = frm.policyCode.value;
	
	var patient_id = frm.patient_id.value;
	var episode_type = frm.episode_type.value;
	var function_id = frm.function_id.value;
	var blnggrp = frm.blnggrp.value;
	var encounter_date = frm.encounter_date.value;
	var citizen_yn = frm.citizen_yn.value;
	var ext_blng_grp = frm.ext_blng_grp.value;
	var strt = start-20;
	var endd= end-20;
	document.location.href='../../eBL/jsp/BLFinDtlsBGPayerResults.jsp?from='+strt+'&to='+endd+'&selection=P&blngGroup='+encodeURIComponent(blngGroup)+
	'&payerCode='+encodeURIComponent(payerCode)+'&payer='+encodeURIComponent(payer)+'&policy='+encodeURIComponent(policy)+
	'&patient_id='+encodeURIComponent(patient_id)+
	'&episode_type='+encodeURIComponent(episode_type)+
	'&function_id='+encodeURIComponent(function_id)+
	'&blnggrp='+encodeURIComponent(blnggrp)+
	'&encounter_date='+encodeURIComponent(encounter_date)+
	'&citizen_yn='+encodeURIComponent(citizen_yn)+
	'&ext_blng_grp='+encodeURIComponent(ext_blng_grp);
}
	
function moveNextthis(start,end)
{
	var frm =  document.forms[0];
	var blngGroup = frm.blngGroupCode.value;
	var payerCode = frm.payerGroupCode.value;
	var payer = frm.payerCode.value;
	var policy = frm.policyCode.value;
	
	var patient_id = frm.patient_id.value;
	var episode_type = frm.episode_type.value;
	var function_id = frm.function_id.value;
	var blnggrp = frm.blnggrp.value;
	var encounter_date = frm.encounter_date.value;
	var citizen_yn = frm.citizen_yn.value;
	var ext_blng_grp = frm.ext_blng_grp.value;
	var strt = start +20;
	var endd= end+20 ;
	document.location.href='../../eBL/jsp/BLFinDtlsBGPayerResults.jsp?from='+strt+'&to='+endd+'&selection=P&blngGroup='+encodeURIComponent(blngGroup)+
	'&payerCode='+encodeURIComponent(payerCode)+'&payer='+encodeURIComponent(payer)+'&policy='+encodeURIComponent(policy)+
	'&patient_id='+encodeURIComponent(patient_id)+
	'&episode_type='+encodeURIComponent(episode_type)+
	'&function_id='+encodeURIComponent(function_id)+
	'&blnggrp='+encodeURIComponent(blnggrp)+
	'&encounter_date='+encodeURIComponent(encounter_date)+
	'&citizen_yn='+encodeURIComponent(citizen_yn)+
	'&ext_blng_grp='+encodeURIComponent(ext_blng_grp);
	
}

