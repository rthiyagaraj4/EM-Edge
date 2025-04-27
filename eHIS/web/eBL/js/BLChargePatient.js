/*
Sr No        Version           TFS/Incident        SCF/CRF				Developer Name
------------------------------------------------------------------------------------------------
1          	 V210129             13523     		MOHE-CRF-0060			Shikha Seth
------------------------------------------------------------------------------------------------
*/
function reset()
{
 // 	patencdtlframe.location.reload();
  patencdtlframe.location.reload();
}	

function create()
{

}

function apply()
{

}

function checkValidDate(entered_date)
{
	
var locale=document.forms[0].locale.value;
if(entered_date.value!="")
{
	if(validDate(entered_date.value,'DMY',locale))
	{
		
	}
	else
	{	
		alert(getMessage("INVALID_DATE_FMT","SM"));
		entered_date.value='';
		return false;
	}
}
else
{
	return true;
}
}

function checkDateBL(entered_date)
	{
		
	var locale=document.forms[0].locale.value;
	if(entered_date.value!="")
	{
		if(validDate(entered_date.value,'DMY',locale))
		{
			if(!isBeforeNow(entered_date.value,'DMY',locale)){
				alert(getMessage("FROM_DT_NGE_CURR_DATE","SM"));
				entered_date.value='';
				return false;
			}			
			return true;
		}
		else
		{	
			alert(getMessage("INVALID_DATE_FMT","SM"));
			entered_date.value='';
			return false;
		}
	}
	else
	{
		return true;
	}
}

function chkDtLessEqualThanSysDateNew(entered_date,sysdate)
	{
		
		var locale=document.forms[0].locale.value;
	
	if(entered_date.value!="")
	{
		if((validDate(entered_date.value,'DMY',locale)))
		{
			var enteredDate = entered_date.value ;
			var sysDate = sysdate.value;
			if(isBeforeNow(enteredDate,'DMY',locale))
			{
				return true;
			}
			else
			{
				alert(getMessage("BL9114",'BL'));
				entered_date.select();
				return false;
			}
		}
		else
		{
			alert(getMessage("INVALID_DATE_FMT","SM"));
			entered_date.select();
			return false;
		}
	}
	else
	{
		return true;
	}
}


function showServiceDetails(){
	
	//alert("search clicked");
	var serviceCode																			= document.getElementById("serviceCode").value;
	var serviceClass 																		= document.getElementById("serv_class_code").value;
	var billingService																		= document.getElementById("bill_serv_code").value;
	var item 																				= document.getElementById("item_code").value;
	var entServGroup																		= document.getElementById("entServ_Grp_code").value;
	var entGrpLine																			= document.getElementById("entGrp_Line_code").value;
	var fromDate																			= document.getElementById("from__date").value;
	var toDate																				= document.getElementById("to_date").value;
	//alert("parent.document.getElementById('BL_mainFrame')"+parent.parent.document.getElementById('BL_mainFrame'));
	//top.parent.document.getElementById('BL_mainFrame').rows = document.getElementById('allFramesMessage').value;
	//<input type='hidden' id='allFramesMessage' 	name='allFramesMessage'   value='7%,0%,0%,6%,25%,6%,28%,23%,4%'>
	parent.document.getElementById("pline").style.height = "7vh";
	parent.document.getElementById('BillingBanner').style.height = "0vh";
	parent.document.getElementById('BillingMenu').style.height = "0vh";
	parent.document.getElementById('BLChargePatientEncounterTab').style.height = "6vh";
	parent.document.getElementById('BLChargePatientEncounterTabPage').style.height = "25vh";
	parent.document.getElementById('BLChargePatientExisOrderTraverse').style.height = "6vh";
	parent.document.getElementById('BLChargePatientExisOrderServDetails').style.height = "26vh";
	parent.document.getElementById('BLChargePatientExisOrderServEdit').style.height = "23vh";
	parent.document.getElementById('messageFrame1').style.height = "9vh";
			
	
	var billedYN = document.getElementById("billedYN").value;
	var direct_indirectchgs = document.getElementById("direct_indirectchgs").value;
	/*if(document.getElementById("billedYN").checked){
		billedYN = "Y";
	}
	else{
		billedYN = "N";
	}
	if(document.getElementById("direct_indirectchgs").checked){
		direct_indirectchgs = "D";
	}
	else{
		direct_indirectchgs = "I";
	}*/
	var patientId																			= document.getElementById("patient_id").value;
	var episodeId																			= document.getElementById("episode_id").value;
	var visitId																				= document.getElementById("visit_id").value;
	var locale																				= document.getElementById("locale").value;
	
	var groupLineService																	= document.getElementById("filterBy").value;
	var episodeType																			= document.getElementById("episode_type").value;
	var processed = document.getElementById("processed").value;
	var locale = document.getElementById("locale").value;
		
	var underChrgOnly;
	if($('#underChrgOnly').is(':checked')){
		underChrgOnly='Y';
	}
	else{
		underChrgOnly='N';
	}
		

	if(fromDate != '' && toDate != ''){
		var starr = fromDate.split("/");
		var enarr = toDate.split("/");
		var startdt = new Date();
		var enddt = new Date();
		startdt.setFullYear(starr[2], starr[1]-1, starr[0]);
		enddt.setFullYear(enarr[2], enarr[1]-1, enarr[0]);

		if(startdt>enddt)
		{			
			alert(getMessage('BL4115','BL'));     		
    		return false;
		}
	}
	if(processed == 'UC' && groupLineService != 'D'){
		alert(getMessage('BL00906','BL'));
		//alert('Choose Filter by Billing Service to retrieve Unconfirmed orders');
		return false;
	}
  	
	//alert("patient_id/episode_id/visit_id/locale::::::::"+patientId+"/"+episodeId+"/"+visitId+"/"+locale);
	//alert("serviceCode/serviceClass/billingService/item/entServGroup/entGrpLine/fromDate/toDate/billedYN/direct_indirectchgs/groupLineService/episodeType/patientId/episodeId/visitId/locale"+serviceCode+"/"+serviceClass+"/"+billingService+"/"+item+"/"+entServGroup+"/"+entGrpLine+"/"+fromDate+"/"+toDate+"/"+billedYN+"/"+direct_indirectchgs+"/"+groupLineService+"/"+episodeType+"/"+patientId+"/"+episodeId+"/"+visitId+"/"+locale);
	
	//alert("parent.location.href"+parent.location.href);
	
	
	fnShowProgress();	
	//alert('Frames Resetted');
	parent.BLChargePatientExisOrderServDetails.location.href = "../../eCommon/html/blank.html";
	parent.BLChargePatientExisOrderServEdit.location.href = "../../eCommon/html/blank.html";
	//To Show Progress Bar
	parent.BLChargePatientExisOrderServDetails.location.href = "../../eBL/jsp/BLChargePatientExisOrderServDetails.jsp?serviceCode="+serviceCode+"&serviceClass="+serviceClass
	+"&billingService="+billingService+"&item="+item+"&entServGroup="+entServGroup+"&entGrpLine="+entGrpLine+"&fromDate="+fromDate+"&toDate="+toDate+"&billedYN="+billedYN
	+"&direct_indirectchgs="+direct_indirectchgs+"&groupLineService="+groupLineService+"&episodeType="+episodeType+"&patientId="+patientId+"&episodeId="+episodeId+"&visitId="+visitId+"&locale="+locale+
	"&processed="+processed+"&underChrgOnly="+underChrgOnly;
	
	parent.messageFrame1.location.href = '../../eCommon/jsp/error.jsp';
	
	if(groupLineService == 'D'){
		//parent.document.getElementById('BL_mainFrame').rows = '7%,0%,0%,6%,25%,6%,51%,0%,5%';
		parent.document.getElementById("pline").style.height="7vh";
		parent.document.getElementById("BillingBanner").style.height="0vh";
		parent.document.getElementById("BillingMenu").style.height="0vh";
		parent.document.getElementById("BLChargePatientEncounterTab").style.height="6vh";
		parent.document.getElementById("BLChargePatientEncounterTabPage").style.height="24vh";
		parent.document.getElementById("BLChargePatientExisOrderTraverse").style.height="6vh";
		parent.document.getElementById("BLChargePatientExisOrderServDetails").style.height="49vh";
		parent.document.getElementById("BLChargePatientExisOrderServEdit").style.height="0vh";
		parent.document.getElementById("messageFrame1").style.height="6vh";
		
	}
	else{
		//parent.document.getElementById('BL_mainFrame').rows = parent.document.getElementById('allFramesMessage').value;
		
		parent.document.getElementById("pline").style.height = "7vh";
		parent.document.getElementById('BillingBanner').style.height = "0vh";
		parent.document.getElementById('BillingMenu').style.height = "0vh";
		parent.document.getElementById('BLChargePatientEncounterTab').style.height = "6vh";
		parent.document.getElementById('BLChargePatientEncounterTabPage').style.height = "24vh";
		parent.document.getElementById('BLChargePatientExisOrderTraverse').style.height = "6vh";
		parent.document.getElementById('BLChargePatientExisOrderServDetails').style.height = "26vh";
		parent.document.getElementById('BLChargePatientExisOrderServEdit').style.height = "23vh";
		parent.document.getElementById('messageFrame1').style.height = "9vh";
		
	}
	
}

function clearCode(obj){
	obj.value='';
}


function showServiceDetailsData(index)
{
	//alert("==========showPriceDetailsData====index============"+index);


//  alert("==========inside===showPriceDetailsData=========1service_ind-------"+(document.getElementById('service_ind'+index).value));
	var serviceInd					=	trimString(document.getElementById('service_ind'+index).value) ;
//	alert("==========inside===showPriceDetailsData=========2service_code"+document.getElementById('service_code'+index).value);
	var serviceCode					=	trimString(document.getElementById('service_code'+index).innerText) ;
//	alert("==========inside===showPriceDetailsData=========3service_description"+document.getElementById('service_description'+index).value);
	var serviceDescription			=	trimString(document.getElementById('service_description'+index).innerText );
//	alert("==========inside===showPriceDetailsData=========4price_ind"+document.getElementById('price_ind'+index).value);
	var priceInd					=	trimString(document.getElementById('price_ind'+index).value) ;
	//alert("==========inside===showPriceDetailsData=========5price_code"+document.getElementById('price_code'+index).value);
	var priceCode					=	trimString(document.getElementById('price_code'+index).innerText);
//	alert("==========inside===showPriceDetailsData=========6price_description"+document.getElementById('price_description'+index).value);
	var priceDescription			=	trimString(document.getElementById('price_description'+index).innerText);
//	alert("==========inside===showPriceDetailsData=========7policy_code"+document.getElementById('policy_code'+index).value);
	var policyCode					=	trimString(document.getElementById('policy_code'+index).innerText);
//	alert("==========inside===showPriceDetailsData=========8policy_desc"+document.getElementById('policy_desc'+index).value);
	var policyDesc   				=  	trimString(document.getElementById('policy_desc'+index).innerText);
//	alert("==========inside===showPriceDetailsData=========9cust_code"+document.getElementById('cust_code'+index).value);
	var custCode   					=  	trimString(document.getElementById('cust_code'+index).innerText);
//	alert("==========inside===showPriceDetailsData=========billing_class=="+document.getElementById('billing_class'+index).value);
	var custDesc					=  	trimString(document.getElementById('cust_desc'+index).innerText);
	var billingClass				=  	trimString(document.getElementById('billing_class'+index).value);
	//var billingClass				=  	document.forms[0].billingClass.value;
	var EffectiveTo					=  	trimString(document.getElementById('Effective_to'+index).value);
	var desc						=  	trimString(document.getElementById('Desc'+index).value);
	var EffectiveFrom				=  	trimString(document.getElementById('Effective_from'+index).value);
	var discApplicability			=  	trimString(document.getElementById('disc_applicability'+index).value);
	var chargeType					=  	trimString(document.getElementById('charge_type'+index).value);
//	alert("==========showPriceDetailsData============333333333");
			
	parent.additionalServiceDiscountDetails.location.href = "../../eBL/jsp/AdditionalServicePreApprovalRequestDetails.jsp?serviceInd="+serviceInd
	+"&serviceCode="+serviceCode+"&serviceDescription="+serviceDescription+"&priceInd="+priceInd+"&priceCode="+priceCode+"&priceDescription="+priceDescription+"&policyCode="+policyCode
	+"&policyDesc="+policyDesc+"&custCode="+custCode+"&custCode="+custCode+"&custDesc="+custDesc+"&billingClass="+billingClass+"&EffectiveTo="+EffectiveTo+"&desc="+desc+"&EffectiveFrom="+EffectiveFrom+"&discApplicability="+discApplicability+"&chargeType="+chargeType;
	
	parent.additionalServiceDiscountDetailsAdd.location.href = "../../eBL/jsp/AdditionalServiceDetailsAdd.jsp";
//	alert("==========showPriceDetailsData============4444444444");
}

function fnShowProgress(){
	//alert('show')
	//<input type='hidden' id='allFramesMessage' 	name='allFramesMessage'   value='7%,0%,0%,6%,25%,6%,28%,23%,4%'>
	//parent.document.getElementById('BL_mainFrame').rows = parent.document.getElementById('allFramesMessage').value;
	//parent.progressFrame.document.location.href = '../../eCommon/jsp/process.jsp';
		//alert('reseting done')
	parent.document.getElementById("pline").style.height = "7vh";
	parent.document.getElementById('BillingBanner').style.height = "0vh";
	parent.document.getElementById('BillingMenu').style.height = "0vh";
	parent.document.getElementById('BLChargePatientEncounterTab').style.height = "6vh";
	parent.document.getElementById('BLChargePatientEncounterTabPage').style.height = "25vh";
	parent.document.getElementById('BLChargePatientExisOrderTraverse').style.height = "6vh";
	parent.document.getElementById('BLChargePatientExisOrderServDetails').style.height = "28vh";
	parent.document.getElementById('BLChargePatientExisOrderServEdit').style.height = "23vh";
	parent.document.getElementById('messageFrame1').style.height = "9vh";
}


function fnHideProgress(type,resize){
	if(type == 'D' && (resize == 'UC' || resize == 'UP')){
		
	}
	else if(type == 'D' && resize != 'Y'){
		//parent.document.getElementById('BL_mainFrame').rows = '7%,0%,0%,6%,25%,6%,51%,0%,5%';
		parent.document.getElementById("pline").style.height="7vh";
		parent.document.getElementById("BillingBanner").style.height="0vh";
		parent.document.getElementById("BillingMenu").style.height="0vh";
		parent.document.getElementById("BLChargePatientEncounterTab").style.height="6vh";
		parent.document.getElementById("BLChargePatientEncounterTabPage").style.height="25vh";
		parent.document.getElementById("BLChargePatientExisOrderTraverse").style.height="6vh";
		parent.document.getElementById("BLChargePatientExisOrderServDetails").style.height="51vh";
		parent.document.getElementById("BLChargePatientExisOrderServEdit").style.height="0vh";
		parent.document.getElementById("messageFrame1").style.height="9vh";
	}
	else{
		//parent.document.getElementById('BL_mainFrame').rows = parent.document.getElementById('allFramesMessage').value;
		parent.document.getElementById("pline").style.height = "7vh";
		parent.document.getElementById('BillingBanner').style.height = "0vh";
		parent.document.getElementById('BillingMenu').style.height = "0vh";
		parent.document.getElementById('BLChargePatientEncounterTab').style.height = "6vh";
		parent.document.getElementById('BLChargePatientEncounterTabPage').style.height = "24vh";
		parent.document.getElementById('BLChargePatientExisOrderTraverse').style.height = "6vh";
		parent.document.getElementById('BLChargePatientExisOrderServDetails').style.height = "26vh";
		parent.document.getElementById('BLChargePatientExisOrderServEdit').style.height = "23vh";
		parent.document.getElementById('messageFrame1').style.height = "6vh";
	}
	
	
	//parent.progressFrame.document.location.href = '../../eCommon/html/blank.html'
		//alert('reseting done')
}


function loadTraverseFrame(service_code,service_class,billing_service,item,ent_servGroup,ent_GrpLine,
		from_date,to_date,billedYN,direct_indirectchgs,underChrgOnly,
		fromRcrd,toRcrd,constcnt,prevYn,nextYn){
	
	if(ent_servGroup!=''){
		parent.messageFrame1.location.href='../../eCommon/jsp/error.jsp';
	}
	if(parent.BLChargePatientExisOrderTraverse != undefined && parent.BLChargePatientExisOrderTraverse != 'undefined'){
		
		parent.BLChargePatientExisOrderTraverse.location.href = "../../eBL/jsp/BLChargePatientExisOrderTraverse.jsp?service_code="+service_code+"&service_class="+service_class+
		"&billing_service="+billing_service+"&item="+item+"&ent_servGroup="+ent_servGroup+"&ent_GrpLine="+ent_GrpLine+
		"&from_date="+from_date+"&to_date="+to_date+"&billedYN="+billedYN+"&direct_indirectchgs="+direct_indirectchgs+
		"&fromRcrd="+fromRcrd+"&toRcrd="+toRcrd+"&next="+nextYn+"&previous="+prevYn+"&constcnt="+constcnt+"&underChrgOnly"+underChrgOnly;
	}
	
	
	//alert('After traverse');
}

function goNext(service_code,service_class,billing_service,item,ent_servGroup,ent_GrpLine,
		from_date,to_date,billedYN,direct_indirectchgs,underChrgOnly,
				fromRcrd,toRcrd){
	parent.document.getElementById('BL_mainFrame').rows = parent.document.getElementById('allFramesNew').value;
	//parent.progressFrame.document.location.href = '../../eCommon/jsp/process.jsp'
	parent.BLChargePatientExisOrderServDetails.location.href = "../../eBL/jsp/BLChargePatientExisOrderServDetails.jsp?service_code="+service_code+"&service_class="+service_class+
														"&billing_service="+billing_service+"&item="+item+"&ent_servGroup="+ent_servGroup+"&ent_GrpLine="+ent_GrpLine+
														"&from_date="+from_date+"&to_date="+to_date+"&billedYN="+billedYN+"&direct_indirectchgs="+direct_indirectchgs+
														"&fromRcrd="+fromRcrd+"&toRcrd="+toRcrd+"&underChrgOnly="+underChrgOnly;
		//alert('reseting done')
}

function tooltip(obj,indx,mode){
	$('td[id^=serv_grp_code]').each(function(){
		$(this).removeClass('greyedData');
		$(this).addClass('gridDataBlue');
		//$(this).attr('background-color','#e5e5e5');
	});
	/*$('img[id^=imgArrow]').each(function(){
		$(this).attr('src','../../eCommon/images/inactiveArrow.gif');
	})*/
	$('img[id^=imgArrow]').attr('src','../../eCommon/images/inactiveArrow.gif');
	$(obj).addClass('greyedData');
	$('#imgArrow'+indx).attr('src','../../eCommon/images/activeArrow.gif');
	var pVal = $('#processed').val();
	var table;
	if(mode == 'entGroup'){
		viewExistingOrder(indx,mode);
		/*table = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center'> "+					
					"<tr> "+
						"<td class = 'contextMenuItem' style='cursor:pointer' nowrap onclick='viewExistingOrder("+indx+",\""+mode+"\")'>" +
							"View "+
						"</td> "+
					"</tr> "+					
				"</table>";*/
	}
	else if(mode == 'entLine'){
		viewExistingOrder(indx,mode);
		/*table = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center'> "+					
					"<tr> "+
						"<td class = 'contextMenuItem' style='cursor:pointer' nowrap onclick='viewExistingOrder("+indx+",\""+mode+"\")'>" +
							"View "+
						"</td> "+
					"</tr> "+					
				"</table>";*/
	}
	else{
		table = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center'> "+
					"<tr> "+
						"<td class = 'contextMenuItem' style='cursor:pointer' onmouseOver='highlightDynamicTd(this)' onmouseOut='removeHighlight(this)' nowrap onclick='updateExistingOrder("+indx+",\"cancelBLServ\")'>" +
							"Cancel "+
						"</td> " +
					"</tr>";
					if(pVal == 'UP'){
						table += "<tr> "+
									"<td class = 'contextMenuItem' style='cursor:pointer' onmouseOver='highlightDynamicTd(this)' onmouseOut='removeHighlight(this)' nowrap onclick='updateExistingOrder("+indx+",\"processBLServ\")'>" +
										"Process "+
									"</td> " +
								"</tr>";
					}
					else{
						var confirmedYn = $('#confirmedYn'+indx).val();
						if(confirmedYn != 'Y'){
							table += "<tr> "+
							"<td class = 'contextMenuItem' style='cursor:pointer' onmouseOver='highlightDynamicTd(this)' onmouseOut='removeHighlight(this)' nowrap onclick='updateExistingOrder("+indx+",\"confirmBLServ\")'>" +
								"Confirm "+
							"</td> "+
						"</tr> ";
						}						
					}

					/*"<tr> "+
						"<td class = 'contextMenuItem' style='cursor:pointer' onmouseOver='highlightDynamicTd(this)' onmouseOut='removeHighlight(this)' nowrap onclick='amendExistingOrder("+indx+",\"amendBLServ\")''>" +
							"Amend "+
						"</td> "+
					"</tr> "+
					"<tr> "+
					"<td class = 'contextMenuItem' nowrap style='cursor:pointer' onmouseOver='highlightDynamicTd(this)' onmouseOut='removeHighlight(this)' onclick='giveDiscount("+indx+",\"amendBLServ\")''>" +
						"Discount "+
					"</td> "+
				"</tr> "+*/
					table += "</table>";
		document.getElementById('t').innerHTML = table;
		resizeWindow(obj);
	}
	
}

function highlightDynamicTd(obj){
	$(obj).removeClass('contextMenuItem');
	$(obj).addClass('selectedcontextMenuItem');
}

function removeHighlight(obj){
	$(obj).removeClass('selectedcontextMenuItem');
	$(obj).addClass('contextMenuItem');
}

function viewExistingOrder(obj,mode){
	var pDoc = parent.BLChargePatientEncounterTabPage.document;
	var serviceCode																			= pDoc.getElementById("serviceCode").value;
	var serviceClass 																		= pDoc.getElementById("serv_class_code").value;
	var billingService																		= pDoc.getElementById("bill_serv_code").value;
	var item 																				= pDoc.getElementById("item_code").value;
	var entServGroup																		= $.trim($('#serv_grp_code'+obj).text());
	var entGrpLine																			= '';

	var patientId																			= pDoc.getElementById("patient_id").value;
	var episodeId																			= pDoc.getElementById("episode_id").value;
	var visitId																				= pDoc.getElementById("visit_id").value;
	var locale																				= pDoc.getElementById("locale").value;
	
	var groupLineService																	= "D";
	var episodeType																			= pDoc.getElementById("episode_type").value;
	var fromDate = pDoc.getElementById("from__date").value;
	var toDate = pDoc.getElementById("to_date").value;

	//parent.document.getElementById('BL_mainFrame').rows = '5%,5%,12%,8%,20%,5%,23%,18%,4%';
	var billedYN = pDoc.getElementById("billedYN").value;
	var direct_indirectchgs = pDoc.getElementById("direct_indirectchgs").value;
	var processed = $('#processed').val();
	
	var underChrgOnly;
	if($(pDoc).find('#underChrgOnly').is(':checked')){
		underChrgOnly='Y';
	}
	else{
		underChrgOnly='N';
	} 
		
	//alert("viewExistingOrder underChrgOnly "+underChrgOnly);
	
	var prevClicked = $('#prevClicked').val();
	if(prevClicked.length>0){
		$('#resultTr_'+prevClicked +' td:not(:first-child)').each(function(){
			$(this).attr('class','fields');
		});
	}

	$('#resultTr_'+obj +' td:not(:first-child)').each(function(){
		$(this).attr('class','YELLOW');
	});
	
	$('#prevClicked').val(obj);
	/*if(pDoc.getElementById("billedYN").checked){
		billedYN = "Y";
	}
	else{
		billedYN = "N";
	}
	if(pDoc.getElementById("direct_indirectchgs").checked){
		direct_indirectchgs = "D";
	}
	else{
		direct_indirectchgs = "I";
	}*/
	if(mode == 'entGroup'){
		pDoc = pDoc.getElementById("entGrp_Line_code").value;
	}
	else if(mode == 'entLine'){
		entGrpLine = $.trim($('#serv_line_code'+obj).text());
		//alert(entGrpLine.length)
	}
	hideToolTip();
	//parent.document.getElementById('BL_mainFrame').rows = parent.document.getElementById('allFramesMessage').value;
	parent.document.getElementById("pline").style.height = "7vh";
	parent.document.getElementById('BillingBanner').style.height = "0vh";
	parent.document.getElementById('BillingMenu').style.height = "0vh";
	parent.document.getElementById('BLChargePatientEncounterTab').style.height = "6vh";
	parent.document.getElementById('BLChargePatientEncounterTabPage').style.height = "24vh";
	parent.document.getElementById('BLChargePatientExisOrderTraverse').style.height = "6vh";
	parent.document.getElementById('BLChargePatientExisOrderServDetails').style.height = "26vh";
	parent.document.getElementById('BLChargePatientExisOrderServEdit').style.height = "23vh";
	parent.document.getElementById('messageFrame1').style.height = "6vh";
	parent.BLChargePatientExisOrderServEdit.location.href = "../../eBL/jsp/BLChargePatientExisOrderServDetails.jsp?serviceCode="+serviceCode+"&serviceClass="+serviceClass
	+"&billingService="+billingService+"&item="+item+"&entServGroup="+entServGroup+"&entGrpLine="+entGrpLine+"&billedYN="+billedYN
	+"&direct_indirectchgs="+direct_indirectchgs+"&groupLineService="+groupLineService+"&episodeType="+episodeType+"&patientId="+patientId
	+"&episodeId="+episodeId+"&visitId="+visitId+"&locale="+locale+"&reSize=Y"+"&processed="+processed
	+"&fromDate="+fromDate+"&toDate="+toDate+"&underChrgOnly="+underChrgOnly;

}

function ExistingOrder(obj,mode){
	hideToolTip();
	var srchFrm = parent.BLChargePatientEncounterTabPage.document.BLChargePatientEncounterExistingOrder;
	var servForAmend = formJsonObject(obj,srchFrm);
	persistTroAjax(servForAmend);
	var url="../../eBL/jsp/BLExistingOrderAmendService.jsp?servForAmend="+JSON.stringify(servForAmend);
	//alert(url);
	var dialogHeight= "30" ;
	var dialogWidth	= "60" ;													   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status: " + status + "; scroll=auto; center:yes";
	var popupWindow =window.showModalDialog(url,null,features);  
	if(popupWindow != undefined && popupWindow != 'undefined'){
		var retObj;
		try{
			retObj = JSON.parse(popupWindow);
		}
		catch(e){
			alert(e)
		}
		
		var frm = document.forms[0];
		frm.target='messageFrame';
		frm.method="post";
		frm.action="../../servlet/eBL.BLExistingOrderServlet?mode=amendService"+
					"&qty="+retObj.servQty+
					"&patPayable="+retObj.patPayable+
					"&drName="+retObj.physicianId;
		frm.submit();	
	}
	
}

function persistTroAjax(obj){
	$.ajax({
		type:"GET",
		url:"../jsp/BLChargePatientExistingOrderPersistence.jsp",
		data:"func_mode=persistExistingOrderBean&existingOrderObject="+JSON.stringify(obj),
		dataType:"text",
		async:false,
		 error: function(data){

	      }
	});
	/*var temp_jsp="../jsp/BLChargePatientExistingOrderPersistence.jsp?func_mode=persistExistingOrderBean&existingOrderObject="+JSON.stringify(obj);
	
	var chkStr ="<root><SEARCH ";				
	chkStr +=" /></root>";
	var chkDoc = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var chkHttp = new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	chkDoc.loadXML(chkStr);
	
	chkHttp.open("POST",temp_jsp,false);
	chkHttp.send(chkDoc);*/
}

async function giveDiscount(obj,mode){
	hideToolTip();
	var srchFrm = parent.BLChargePatientEncounterTabPage.document.BLChargePatientEncounterExistingOrder;
	var servForAmend = formJsonObject(obj,srchFrm);
	persistTroAjax(servForAmend);
	var url="../../eBL/jsp/BLExistingOrderDiscount.jsp?servForAmend="+JSON.stringify(servForAmend);
	//alert(url);
	var dialogHeight= "30" ;
	var dialogWidth	= "60" ;													   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status: " + status + "; scroll=auto; center:yes";
	var popupWindow =await window.showModalDialog(url,null,features);  
	if(popupWindow != undefined && popupWindow != 'undefined'){
		var retObj;
		try{
			retObj = JSON.parse(popupWindow);
		}
		catch(e){
			alert(e)
		}
		
		var frm = document.forms[0];
		frm.target='messageFrame';
		frm.method="post";
		frm.action="../../servlet/eBL.BLExistingOrderServlet?mode=discountService"+
					"&adhocDiscAmt="+retObj.adhocDiscAmt+
					"&patPayable="+retObj.patPayable+
					"&discReason="+retObj.discReason;
		frm.submit();	
	}

	

}

function formJsonObject(obj,srchFrm){
	var servForCancel = {};
	var chargeLogicYn = $(parent.BLChargePatientEncounterTabPage.document).find('#chargeLogicYN').val();
	servForCancel.episodeType = srchFrm.episode_type.value;
	servForCancel.episodeId = srchFrm.episode_id.value;
	servForCancel.visitId = srchFrm.visit_id.value;
	servForCancel.encounterId = srchFrm.encounter_id.value;
	servForCancel.patientId = srchFrm.patient_id.value;
	
	if(chargeLogicYn == 'Y'){
		servForCancel.orderId = $('#primKeyMain'+obj).val();
		servForCancel.orderLineNum = $('#primKeyLineNo'+obj).val();
		servForCancel.subModuleId = $('#primKeyModId'+obj).val();
		servForCancel.subRegnLineNum =  $('#secKeyLineNo'+obj).val();
		servForCancel.subRegnNum = $('#secKeyMain'+obj).val();
	}
	else{
		servForCancel.orderId = $('#trxDocRef'+obj).val();//$('#primKeyMain'+obj).val();
		servForCancel.orderLineNum = $('#trxDocRefLineNum'+obj).val();//$('#primKeyLineNo'+obj).val();
		servForCancel.subModuleId = $('#module_id'+obj).val();
		servForCancel.subRegnLineNum =  $('#trxDocRefLineNum'+obj).val();//$('#secKeyLineNo'+obj).val();
		servForCancel.subRegnNum = $('#trxDocRef'+obj).val();//$('#secKeyMain'+obj).val();
	}

	
	
	servForCancel.servOrPanel = "S";//$('#servOrPanel'+obj).val();
	servForCancel.servCode =$.trim($('#serv_grp_code'+obj).text());
	servForCancel.servDesc =encodeURIComponent($.trim($('#serv_grp_desc'+obj).text()));
	
	servForCancel.itemCode = $('#itemCode'+obj).val();
	servForCancel.itemDesc = '';
	servForCancel.baseQty = $('#servQty'+obj).val();
	servForCancel.baseChargeAmount = $.trim($('#gross_amt'+obj).text());
	servForCancel.adhocDiscount = $.trim($('#adhoc_disc_amt'+obj).text());
	servForCancel.disc_amt = $.trim($('#disc_amt'+obj).text());
	servForCancel.netChargeAmount = $.trim($('#net_amt'+obj).text());
	servForCancel.physicianId = $('#physicianId'+obj).val();
	servForCancel.servedpanelQty = $('#servedPanelQty'+obj).val();
	servForCancel.uomCode = $('#uomCode'+obj).val();
	servForCancel.practStaffInd = $('#practStaffInd'+obj).val();
	servForCancel.inclExclInd = $('#inclExclInd'+obj).val();
	servForCancel.reason = $('#reason'+obj).val();
	servForCancel.futureOrder = '';
	servForCancel.futureOrderChargeLater = '';
	servForCancel.remarks = $('#remarks'+obj).val();
	servForCancel.packInd = $('#trxDocRefLineNum'+obj).val();
	servForCancel.dailyProcessInd = $('#dailyProcessInd'+obj).val();
	servForCancel.bedTypeCode = $('#bedType'+obj).val();
	
	servForCancel.tokenSeriesCode = $('#tokenSeriesCode'+obj).val();
	servForCancel.tokenSeriesNo = $('#tokenSeriesNo'+obj).val();
	servForCancel.dispLocn = $('#dispLocn'+obj).val();
	
	servForCancel.trxDocRef = $('#trxDocRef'+obj).val();
	servForCancel.trxDocRefLineNum = $('#trxDocRefLineNum'+obj).val();
	servForCancel.trxDocRefSeqNum = $('#trxDocRefSeqNum'+obj).val();
	servForCancel.confirmedYn = $('#confirmedYn'+obj).val();
	servForCancel.baseRate = $('#baseRate'+obj).val();
	servForCancel.rateIndicator = $('#rateIndicator'+obj).val();
	servForCancel.chargeDateTime = $.trim($('#chargeDateTime'+obj).text());
	
	var existingOrderFrm = parent.BLChargePatientEncounterTabPage.document.BLChargePatientEncounterExistingOrder
	servForCancel.acctSeqNo = existingOrderFrm.acctSeqNo.value;
	servForCancel.payerGroup = existingOrderFrm.payerGroup.value;
	servForCancel.payer = existingOrderFrm.payer.value;
	servForCancel.policy = existingOrderFrm.policy.value;
	servForCancel.policyNum = existingOrderFrm.policyNum.value;
	
	
	return servForCancel;
}

function updateExistingOrder(obj,mode){
	hideToolTip();
	var srchFrm = parent.BLChargePatientEncounterTabPage.document.BLChargePatientEncounterExistingOrder;
	if(mode == 'cancelBLServ'){
		var cancelYn = confirm("Are you sure want to cancel the Service?");
		if(!cancelYn){
			return false;
		}
		var tabDoc = parent.BLChargePatientEncounterTab.document;		
		var cancelPrivilege = $(tabDoc).find('#cancelConfirmedService').val();
		if($('#confirmedYn'+obj).val() == 'Y' && cancelPrivilege != 'Y'){
			alert(getMessage('BL1176','BL'));
			return false;
		}
		var inDirectPrivilege = $(tabDoc).find('#cancelIndirect').val();
		if(inDirectPrivilege != 'Y' && $('#primKeyModId'+obj).val() != 'BL' && $('#primKeyModId'+obj).val() != '' ){
			//alert('User is not authorized to cancel the service '+$.trim($('#serv_grp_code'+obj).text()));
			alert(getMessage('BL1358','BL'));
			return false;
		}
		
		//Added by Rajesh - Showing Error or Warning
		var error = $('#errorCode'+obj).val();
		var warning = $('#warningMess'+obj).val();
		
		if(warning != ''){
			alert(getMessage(warning,'BL'));		
		}
		
		if(error != ''){
			alert(getMessage(error,'BL'));			
			return false;
		}
		//Added by Rajesh - Showing Error or Warning
	}
	else if(mode == 'confirmBLServ'){
		var tabDoc = parent.BLChargePatientEncounterTab.document;
		var confirmPrivilege = $(tabDoc).find('#confirmServiceRequest').val();
		if(confirmPrivilege != 'Y'){
			alert(getMessage('BL1175','BL'));
			return false;
		}
	}
	var servForCancel = formJsonObject(obj,srchFrm);
	persistTroAjax(servForCancel);	
	
	var frm = document.forms[0];
	frm.target='messageFrame1';
	frm.method="post";
	frm.action="../../servlet/eBL.BLExistingOrderServlet?mode="+mode+
				"&servForCancel="+JSON.stringify(servForCancel);
	frm.submit();
}

async function processBulk(mode){
	var chargeLogicYn = '';
	var frm;
	var confirmServiceRequest = '';
	var cancelConfirmedService = '';
	var cancelIndirect = '';

	if($('#hdnReSize').val() == 'UP'){
		chargeLogicYn = $(parent.BillReceiptTab.document).find('#chargeLogicYN').val();
		frm = parent.BillReceiptTab.document.ChargePatientEncounterTabsForm;
	}
	else{
		chargeLogicYn = $(parent.BLChargePatientEncounterTabPage.document).find('#chargeLogicYN').val();
		frm = parent.BLChargePatientEncounterTabPage.document.BLChargePatientEncounterExistingOrder;
		var tabDoc = parent.BLChargePatientEncounterTab.document;
		confirmServiceRequest = $(tabDoc).find('#confirmServiceRequest').val();
		cancelConfirmedService = $(tabDoc).find('#cancelConfirmedService').val();
		cancelIndirect = $(tabDoc).find('#cancelIndirect').val();
	}

	var formParams = '';
	var errWarnParams = '';
	var lastIndex = $('#panel_categories_header_table tr:last').attr('data-id');
	var totSelected = 0;
	
	var privelege = frm.privForIndirect.value;
	var totalChecked = 0;
	if(mode == 'cancelAll'){
		
		var cancelYn = confirm("Are you sure want to cancel the Service?");
		if(!cancelYn){
			return false;
		}
		
		/*Moved the validation to the top */
		for(i=0;i<=lastIndex;i++){
			if($('#chk_blng_serv'+i).prop("checked")){
				totSelected = parseInt(totSelected) + 1; 
			}
		}
		if(totSelected < 1){
			if($('#hdnReSize').val() == 'UP'){
				alert(getMessage('BL00929','BL')); 
			}
			else{
				alert(getMessage('BL00907','BL')); 
			}		
			return false;
		}
		else if(totSelected > 50){
			if($('#hdnReSize').val() == 'UP'){
				alert(getMessage('BL00930','BL')); 
			}
			else{
				alert(getMessage('BL00908','BL')); 
			}
			return false;
		}
		/*Moved the validation to the top */
		
		//Added by Rajesh - Showing Error or Warning
		var errorCount = 0;
		var warningCount = 0;

		var consWarning = '';
		var consError = '';

		//Added by Rajesh - Showing Error or Warning
		
		formParams = 'episodeType='+frm.episode_type.value+'&'+
		'episodeId='+frm.episode_id.value+'&'+
		'visitId='+frm.visit_id.value+'&'+
		'encounterId='+frm.encounter_id.value+'&'+
		'patientId='+frm.patient_id.value+'&'+
		'acctSeqNo='+frm.acctSeqNo.value+'&'+
		'payerGroup='+frm.payerGroup.value+'&'+
		'payer='+frm.payer.value+'&'+
		'policy='+frm.policy.value+'&'+
		'policyNum='+frm.policyNum.value+'&';
		
		for(i=0;i<=lastIndex;i++){
			if($('#chk_blng_serv'+i).prop("checked")){
				
				if($('#confirmedYn'+i).val() == 'Y' && cancelConfirmedService != 'Y'){
					alert(getMessage('BL1176','BL'));
					return false;
				}
				
				if(privelege == 'N' && $('#primKeyModId'+i).val() != 'BL' && $('#primKeyModId'+i).val() != ''){
					//alert('User is not authorized to cancel the service '+$.trim($('#serv_grp_code'+i).text()));
					alert(getMessage('BL1358','BL'));
					return false;
				}
				
				//Added by Rajesh - Showing Error or Warning
				if($('#warningMess'+i).val() != ''){

					warningCount = parseInt(warningCount)+parseInt(1);
					errWarnParams = errWarnParams+'&warningMess'+warningCount+'='+$('#warningMess'+i).val();
					errWarnParams = errWarnParams+'&warningTrx'+warningCount+'='+$('#labelTrDoc_'+i).text();
					errWarnParams = errWarnParams+'&warningServ'+warningCount+'='+$.trim($('#serv_grp_code'+i).text());
					/*consWarning = consWarning + $('#warningMess'+i).val()+':::';
					warnTrxDoc = warnTrxDoc + $('#labelTrDoc_'+i).text()+':::';
					warnServCode = warnServCode + $.trim($('#serv_grp_code'+i).text())+':::';*/												
				}
				
				if($('#errorCode'+i).val() != ''){
					errorCount = parseInt(errorCount) + parseInt(1);
					errWarnParams = errWarnParams+'&errorMess'+errorCount+'='+$('#errorCode'+i).val();
					errWarnParams = errWarnParams+'&errorTrx'+errorCount+'='+$('#labelTrDoc_'+i).text();
					errWarnParams = errWarnParams+'&errorServ'+errorCount+'='+$.trim($('#serv_grp_code'+i).text());
					/*consError = consError + $('#errorCode'+i).val() +':::';
					errTrxDoc = errTrxDoc + $('#labelTrDoc_'+i).text() + ':::';
					errServCode = errServCode + $.trim($('#serv_grp_code'+i).text()) + ':::';*/								
					
					$('#chk_blng_serv'+i).prop('checked',false);
				}
				else{
					
				
				//Added by Rajesh - Showing Error or Warning
				
				//totalChecked = parseInt(totalChecked) + 1; 
				formParams += 'trxDocRef'+i+'='+$('#trxDocRef'+i).val()+'&'+
				'trxDocRefLineNum'+i+'='+$('#trxDocRefLineNum'+i).val()+'&'+
				'trxDocRefSeqNum'+i+'='+$('#trxDocRefSeqNum'+i).val()+'&';
				
				if(chargeLogicYn == 'Y'){
					formParams += 'primKeyLineNo'+i+'='+$('#primKeyLineNo'+i).val()+'&'+
					'primKeyMain'+i+'='+$('#primKeyMain'+i).val()+'&'+
					'primKeyModId'+i+'='+$('#primKeyModId'+i).val()+'&'+
					'secKeyMain'+i+'='+$('#secKeyMain'+i).val()+'&'+
					'secKeyLineNo'+i+'='+$('#secKeyLineNo'+i).val()+'&';
				}
				else{
					formParams += 'primKeyLineNo'+i+'='+$('#trxDocRefLineNum'+i).val()+'&'+
					'primKeyMain'+i+'='+$('#trxDocRef'+i).val()+'&'+
					'primKeyModId'+i+'='+$('#module_id'+i).val()+'&'+
					'secKeyMain'+i+'='+$('#trxDocRef'+i).val()+'&'+
					'secKeyLineNo'+i+'='+$('#trxDocRefLineNum'+i).val()+'&';
				}
				
				formParams += 'confirmedYn'+i+'='+$('#confirmedYn'+i).val()+'&'+
				'servedPanelQty'+i+'='+$('#servedPanelQty'+i).val()+'&'+
				'servQty'+i+'='+$('#servQty'+i).val()+'&'+
				'physicianId'+i+'='+$('#physicianId'+i).val()+'&'+
				'uomCode'+i+'='+$('#uomCode'+i).val()+'&'+
				'practStaffInd'+i+'='+$('#practStaffInd'+i).val()+'&'+
				'inclExclInd'+i+'='+$('#inclExclInd'+i).val()+'&'+
				'reason'+i+'='+$('#reason'+i).val()+'&'+
				'remarks'+i+'='+$('#remarks'+i).val()+'&'+
				'dailyProcessInd'+i+'='+$('#dailyProcessInd'+i).val()+'&'+
				'bedType'+i+'='+$('#bedType'+i).val()+'&'+
				'tokenSeriesCode'+i+'='+$('#tokenSeriesCode'+i).val()+'&'+
				
				'tokenSeriesNo'+i+'='+$('#tokenSeriesNo'+i).val()+'&'+
				'dispLocn'+i+'='+$('#dispLocn'+i).val()+'&'+				
				'servOrPanel'+i+'='+'S'+'&'+
				'baseRate'+i+'='+$('#baseRate'+i).val()+'&'+
				'rateIndicator'+i+'='+$('#rateIndicator'+i).val()+'&'+
				'netChargeAmount'+i+'='+$.trim($('#net_amt'+i).text())+'&'+
				'servCode'+i+'='+$.trim($('#serv_grp_code'+i).text())+'&'+
				'itemCode'+i+'='+$('#itemCode'+i).val()+'&';
				}
			}
			
		}
		//Added by Rajesh - Showing Error or Warning
		var bool = false;
		
		if(errorCount > 0){ 
			bool = true;
		}
		
		if(warningCount > 0){
			bool = true;			
		}
		
		$('#selAllChk').prop('checked',false);
		$('#spTotalAmt').text('0.00');
		var selAll = true;
		for(j=0;j<=lastIndex;j++){
			if($('#chk_blng_serv'+j).prop("checked")){
				totalChecked = parseInt(totalChecked) + 1;
				calculateTotal(j);
			}
			else{
				selAll = false;
			}
		}
		
		if(selAll){
			$('#selAllChk').prop('checked',true);
		}
		
		
		if(bool){
			$.ajax({
				type:"POST",
				url:"../jsp/BLChargePatientMsgPersistence.jsp?func_mode=storeErrWarn",
				data:"warningCount="+warningCount+"&errorCount="+errorCount+errWarnParams,
				dataType:"text",
				async:false,
				 error: function(data){

			      }
			});
			
			var url="../../eBL/jsp/BLChargePatientConsErrorDisp.jsp";
			var dialogHeight= "45vh" ;
			var dialogWidth	= "49vw" ;													   
			var status="no";
			var features	= " dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status: " + status + "; scroll=no; center:yes";
			var popupWindow =await window.showModalDialog(url,null,features);  
			if(errorCount > 0){
				return false;
			}
			//return false;
		}

		
		//Added by Rajesh - Showing Error or Warning
	}
	else if(mode == 'confirmAll'){

		if(confirmServiceRequest != 'Y'){
			alert(getMessage('BL1175','BL'));
			return false;
		}

		var alreadyConfirmed = false;
		var notConfirmed = 0;
		var totalSelected = 0;
		for(alC=0;alC<=lastIndex;alC++){
			if($('#chk_blng_serv'+alC).prop("checked")){
				totalSelected = parseInt(totalSelected)+1;
				if($('#confirmedYn'+alC).val() == 'Y'){
					$('#chk_blng_serv'+alC).prop("checked",false);
					calculateTotal(alC);
					alreadyConfirmed = true;
					notConfirmed = parseInt(notConfirmed)+1;
				}
			}
		}
		
		if(alreadyConfirmed){
			if(notConfirmed == totalSelected){
				$('#spTotalAmt').text('0.00');
				alert(getMessage('BL00936','BL'));
				$('#selAllChk').prop('checked',false);				
				return false;
			}
			else{
				alert(getMessage('BL00931','BL'));
			}
		}
		for(i=0;i<=lastIndex;i++){
			if($('#chk_blng_serv'+i).prop("checked")){
				totalChecked = parseInt(totalChecked) + 1; 
				formParams += 'trxDocRef'+i+'='+$('#trxDocRef'+i).val()+'&'+
				'trxDocRefLineNum'+i+'='+$('#trxDocRefLineNum'+i).val()+'&'+
				'trxDocRefSeqNum'+i+'='+$('#trxDocRefSeqNum'+i).val()+'&';
				if(chargeLogicYn == 'Y'){
					formParams += 'primKeyLineNo'+i+'='+$('#primKeyLineNo'+i).val()+'&'+
					'primKeyMain'+i+'='+$('#primKeyMain'+i).val()+'&'+
					'primKeyModId'+i+'='+$('#primKeyModId'+i).val()+'&';
				}
				else{
					formParams += 'primKeyLineNo'+i+'='+$('#trxDocRefLineNum'+i).val()+'&'+
					'primKeyMain'+i+'='+$('#trxDocRef'+i).val()+'&'+
					'primKeyModId'+i+'='+$('#module_id'+i).val()+'&';
				}
				
				formParams += 'confirmedYn'+i+'='+$('#confirmedYn'+i).val()+'&'+
				'servOrPanel'+i+'='+'S'+'&'+
				'servCode'+i+'='+$.trim($('#serv_grp_code'+i).text())+'&'+
				'itemCode'+i+'='+$('#itemCode'+i).val()+'&';
			}
		}
		
		if(totalChecked < 1){
			if($('#hdnReSize').val() == 'UP'){
				alert(getMessage('BL00929','BL')); 
			}
			else{
				alert(getMessage('BL00907','BL')); 
			}
			
			//alert('Please select records to Cancel / Process / Confirm');
			return false;
		}
		else if(totalChecked > 50){
			if($('#hdnReSize').val() == 'UP'){
				alert(getMessage('BL00930','BL')); 
			}
			else{
				alert(getMessage('BL00908','BL')); 
			}
			//alert('Only 50 records can be Cancel / Process / Confirm at a time');
			return false;
		}
	}
	else if(mode == 'processAll'){
		formParams = 'episodeType='+frm.episode_type.value+'&'+
		'episodeId='+frm.episode_id.value+'&'+
		'visitId='+frm.visit_id.value+'&'+
		'encounterId='+frm.encounter_id.value+'&'+
		'patientId='+frm.patient_id.value+'&';
		for(i=0;i<=lastIndex;i++){
			if($('#chk_blng_serv'+i).prop("checked")){
				totalChecked = parseInt(totalChecked) + 1; 
				if(chargeLogicYn == 'Y'){
					formParams += 'primKeyMain'+i+'='+$('#primKeyMain'+i).val()+'&'+
					'primKeyModId'+i+'='+$('#primKeyModId'+i).val()+'&'+
					'secKeyMain'+i+'='+$('#secKeyMain'+i).val()+'&'+
					'secKeyLineNo'+i+'='+$('#secKeyLineNo'+i).val()+'&';
				}
				else{
					formParams += 'primKeyMain'+i+'='+$('#trxDocRef'+i).val()+'&'+
					'primKeyModId'+i+'='+$('#module_id'+i).val()+'&'+
					'secKeyMain'+i+'='+$('#trxDocRef'+i).val()+'&'+
					'secKeyLineNo'+i+'='+$('#trxDocRefLineNum'+i).val()+'&';
				}
				
			}
		}
		
		if(totalChecked < 1){
			if($('#hdnReSize').val() == 'UP'){
				alert(getMessage('BL00929','BL')); 
			}
			else{
				alert(getMessage('BL00907','BL')); 
			}
			
			//alert('Please select records to Cancel / Process / Confirm');
			return false;
		}
		else if(totalChecked > 50){
			if($('#hdnReSize').val() == 'UP'){
				alert(getMessage('BL00930','BL')); 
			}
			else{
				alert(getMessage('BL00908','BL')); 
			}
			//alert('Only 50 records can be Cancel / Process / Confirm at a time');
			return false;
		}
	}
	 
	
	
	formParams += 'lastIndex='+lastIndex;
	//alert(formParams);
	$.ajax({
		type:"POST",
		url:"../jsp/BLChargePatientExistingOrderPersistence.jsp?func_mode="+mode,
		data:formParams,
		dataType:"text",
		async:false,
		 error: function(data){

	      }
	});
	//return false;
	var currFrm = document.forms[0];
	currFrm.target='messageFrame1';
	currFrm.method="post";
	currFrm.action="../../servlet/eBL.BLExistingOrderServlet?mode="+mode;
	currFrm.submit();
}

function onSuccess(){
	//alert(parent.BLChargePatientEncounterTabPage.document.getElementById('add_mod'););
}

function newOrderTooltip(obj,indx){
	var servOrPanel = $('#servOrPanel_'+indx).val();
	$('td[id^=td_serv_code_]').each(function(){
		$(this).removeClass('greyedData');
		//$(this).addClass('gridDataBlue');
		//$(this).attr('background-color','#e5e5e5');
	});
	
	$('img[id^=imgArrow]').attr('src','../../eCommon/images/inactiveArrow.gif');
	$(obj).addClass('greyedData');
	$('#imgArrow'+indx).attr('src','../../eCommon/images/activeArrow.gif');
	var table = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center'> ";
					;
	if(servOrPanel == 'L'){
		table += "<tr> "+
					"<td class = 'contextMenuItem' style='cursor:pointer' onmouseOver='highlightDynamicTd(this)' onmouseOut='removeHighlight(this)' nowrap onclick='editPanel("+indx+")'>" +
						"Edit "+
					"</td> "+
				"</tr> ";	
	}
			table += "<tr> "+
						"<td class = 'contextMenuItem' style='cursor:pointer' onmouseOver='highlightDynamicTd(this)' onmouseOut='removeHighlight(this)' nowrap onclick='cancelNewOrder("+indx+")'>" +
							"Cancel "+
						"</td> "+
					"</tr> "+				
				"</table>";
			
	document.getElementById('t').innerHTML = table;
	resizeWindow(obj);
}

async function editPanel(indx){
	var dialogTop = "100";
    var dialogHeight = "30" ;
    var dialogWidth = "70" ;
    var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
    var title=encodeURIComponent(getLabel("eBL.EDIT_ENTER_CHARGE_DETAILS.label","BL"));
    var arguments = "" ;
    var column_sizes = "";
	var index_val="";
	var column_descriptions ="";

	var newOrderDoc = parent.BLChargePatientEncounterTabPage.document;
	
	var episode_type = $(newOrderDoc).find('#episode_type').val();
	
	var patient_id = $(newOrderDoc).find('#patient_id').val();
	var visit_id = $(newOrderDoc).find('#visit_id').val();
	var episode_id = $(newOrderDoc).find('#episode_id').val();
	var service_panel_code = $('#servCode_'+indx).val();
	var service_panel_ind = $('#servOrPanel_'+indx).val();

	var service_date = $('#dateTime_'+indx).val();
	var dateArr = service_date.split(' ');
	var timeArr = dateArr[1].split(':');
	service_date = dateArr[0]+' '+timeArr[0]+':'+timeArr[1];
	var original_qty = $('#qty_'+indx).val();
	var bl_panel_str = encodeURIComponent($('#panelStr_'+indx).val());
	var dirIndirChrgsFlag='Y';
	/*var order_catalog_code = $(newOrderDoc).find('#').val();
	var encounter_id = $(newOrderDoc).find('#encounter_id').val();
	var key_line_no = $(newOrderDoc).find('#').val();
	var total_qty = $(newOrderDoc).find('#').val();
	var original_qty = $(newOrderDoc).find('#').val();
	var revised_qty = $(newOrderDoc).find('#').val();*/
    var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"episode_type="+episode_type+"&"+"patient_id="+patient_id+
    "&"+"visit_id="+visit_id+"&"+"episode_id="+episode_id+"&"+"service_panel_code="+service_panel_code+"&"+"service_panel_ind="+service_panel_ind+"&"+
    "service_date="+service_date+/*"&"+"order_catalog_code="+order_catalog_code+"&"+"module_id="+module_id+"&encounter_id="+encounter_id+
    "&key="+rows.key+"&key_line_no="+key_line_no+"&order_id="+rows.key+"&order_line_no="+key_line_no+"&bean_id="+bean_id+"&total_qty="+total_qty+"&revise_qty="+revised_qty+*/
    "&original_qty="+original_qty+/*"&quantity="+revised_qty+"&qty="+revised_qty+"&p_serv_qty="+revised_qty+"&revised_qty="+revised_qty+"&serv_panel_qty="+revised_qty+*/
    "&modify_qty_yn=Y&p_str="+bl_panel_str+"&dirIndirChrgsFlag="+dirIndirChrgsFlag;
	var retVal = await window.showModalDialog("../../eBL/jsp/BLEnterEditChargeDtlMain.jsp?"+param,arguments,features);
	if(retVal != undefined && retVal != 'undefined'){
		var retValArr = retVal.split("<DELIM>");
		
		$('#panelStr_'+indx).val(retValArr[0]);
		$('#total_'+indx).val(retValArr[1]);
		$('#hdnTotal_'+indx).val(retValArr[1]);
		$('#patPayable_'+indx).val(retValArr[2]);
		$('#hdnPatPayable_'+indx).val(retValArr[2]);
		$('#patPaid_'+indx).val(retValArr[3]);
		
		findTotal();
	}
	
}


function resizeWindow(orderctlHDR)
{
    var orderctlHDR1 = orderctlHDR.id;
	var wdth = eval(document.getElementById('orderctlHDR1')).offsetWidth;
	var hght1 = eval(document.getElementById('orderctlHDR1').offsetHeight;		
	//alert(eval("document.all."+orderctlHDR1).scrollLeft);
	//alert(eval("document.all."+orderctlHDR1).scrollTop);
	//alert(eval("document.all."+orderctlHDR1).scrollWidth);
	//alert(eval("document.all."+orderctlHDR1).scrollHeight);
	//alert(wdth + ',' + hght1)
	var wdth1 = getPos(orderctlHDR).x +wdth;
	var hght = getPos(orderctlHDR).y ;	
	//alert(wdth1 + ',' + hght)
	bodwidth  = document.body.offsetWidth
	bodheight = document.body.offsetHeight
	
	var z = bodwidth- (event.x + wdth);	
	
	var x 	  = event.x;
	var y 	  = event.y;	
	
	x 	  = x + (document.getElementById('tooltiplayer1').offsetWidth);
	y 	  = hght + (document.getElementById('tooltiplayer1').offsetHeight);	
	
	if(x<bodwidth){
		x= wdth1;
		
	}else{			
		x = getPos(orderctlHDR).x;
		
	}
	if(y<bodheight){			
		y = hght;
		
	}else
	{
		y = y - (document.getElementById('tooltiplayer1').offsetHeight*2) + hght1 ;	
	}
	//alert(x + ',' + y)
	document.getElementById("tooltiplayer1").style.left= x + "px";
	if(y<0){
		if(hght>hght1){
			document.getElementById("tooltiplayer1").style.Top = hght + "px";
		}
		else{
			document.getElementById("tooltiplayer1").style.top = hght1 + "px";
		}
		
	}
	else{
		/*if(hght>y){
			document.getElementById("tooltiplayer1").style.posTop = hght;
		}
		else{*/
			document.getElementById("tooltiplayer1").style.top = y + "px";
		//}
		
	}
	//alert(document.getElementById("tooltiplayer1").style.posTop)
	document.getElementById('tooltiplayer1').style.visibility='visible'
}

function getPos(inputElement) {
    var coords =  new Object();
    coords.x = 0;
    coords.y = 0;
    try {
        targetElement = inputElement;
		
        if(targetElement.x && targetElement.y){
            coords.x = targetElement.x;
            coords.y = targetElement.y;
        } else {
            if(targetElement.offsetParent) {
                coords.x += targetElement.offsetLeft;
                coords.y += targetElement.offsetTop;
                while(targetElement = targetElement.offsetParent) {
                    coords.x += targetElement.offsetLeft;
                    coords.y += targetElement.offsetTop;
                }
            } else {
                //alert("Could not find any reference for coordinate positioning.");
            }
        }
        return coords;
    } catch(error) {
        //alert(error.msg);
        return coords;
    }
}


function hideToolTip()	{
	  document.getElementById('tooltiplayer1').style.visibility = 'hidden'
}


async function callCommonValidation(sqlSelect,obj,code,dependVal,indx){
	//alert("2");
	var oldVal = obj.value;
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	var title = '';
	var loc_code_desc = '';
	var loc_code_link = ''
		var type = '';
	switch(sqlSelect){
	
		case 1:
			{
			type = dependVal.value;
			
			sql = "select NAME description, PRACTITIONER_ID code FROM BL_AM_PRACT_STAFF_VW WHERE upper(PRACTITIONER_ID) like upper(?) and upper(NAME) like upper(?) and FACILITY_ID = '"+facility_id+"' AND UPPER(LANGUAGE_ID) = UPPER('"+locale+"')  AND PRACT_STAFF_IND = '"+type+"' order by 1 ";
			if(type == 'P'){
				title = 'Practitioner';
			}
			else{
				title = 'Other Staff';
			}
			
			loc_code_desc = CODE_DESC;
			loc_code_link = CODE_LINK;
			
			break;
			}
			
		case 2:
		{
			var locale = $('#locale').val();
				sql = "select description,code "+
				"from ( "+
				"select action_reason_desc description, action_reason_code code from bl_action_reason_lang_VW a where nvl(status,'!') != 'S' "+
					"and upper(language_id) = upper('"+locale+"') "+
					"and exists (select b.action_type from bl_action_type b, bl_action_reason_by_type c "+
					"where b.action_type = c.action_type "+
					"and b.action_type = 'OV' "+
					"and c.action_reason_code = a.action_reason_code "+
					"and c.active_yn = 'Y') "+
					") WHERE  upper(code) like upper(?) and upper(description) like upper(?) ";
		title = 'Action Reason';
		loc_code_desc = CODE_DESC;
		loc_code_link = CODE_LINK;
		break;
		}
		
		case 3:
		{
			sql="select description,code from (select short_desc description, cust_group_code code from ar_cust_group_lang_vw where status is null and "+
			"acc_entity_code  in (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') and upper(language_id) = upper('"+locale+"') "+
			" union Select 'All Payer Group','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) "+
			" order by 2";

			title = 'Payer Group';
			loc_code_desc = DESC_CODE;
			loc_code_link = DESC_LINK;
			break;
		}
		
		case 4:
		{
			var cn = $('#location_type').val();
			if(cn == ''){
				
				alert(getMessage('BL00909','BL')); 
				//alert('Please Select Location');
				return false;
			}

			if(cn == 'C'){
				sql="Select description, code from (select short_desc description,clinic_code code from OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E' Union Select 'All Clinic','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Clinic';
			}
			else if(cn == 'W'){
				sql = "Select description, code from (SELECT LONG_DESC DESCRIPTION, NURSING_UNIT_CODE CODE  FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND  FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E' Union Select 'All Nursing Unit','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Nursing Unit';
			}	
			
			loc_code_desc = DESC_CODE;
			loc_code_link = DESC_LINK;
			break;
		}
		
			
	}


	//var sql="SELECT DESCRIPTION, CODE FROM (SELECT 'All' DESCRIPTION,'*ALL' CODE FROM DUAL UNION SELECT A.SHORT_DESC DESCRIPTION,A.SPECIALITY_CODE CODE FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B  WHERE A.LANGUAGE_ID='"+locale+"' AND  A.SPECIALITY_CODE = B.SPECIALITY_CODE ) WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?) ORDER BY 2";
	//alert('sql->'+sql)
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	if(sqlSelect == 1 || sqlSelect == 2){
		argumentArray[4] = "1,2";
	}
	else{
		argumentArray[4] = "2,1";
	}
	
	argumentArray[5] = obj.value;
	argumentArray[6] = loc_code_link;
	argumentArray[7] = loc_code_desc;

	returnedValues = await CommonLookup(title, argumentArray );
	
	var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			
	if((returnedValues != null) && (returnedValues != "") )  {
		if(sqlSelect != '1' && sqlSelect != '2'){
			obj.value = arr[1];
			code.value = arr[0];	
		}
		else{
			obj.value = arr[0];
			code.value = arr[1];	
		}
	}
else
	{
	obj.value = '';
	code.value = '';	
	if(sqlSelect == 1){
		$('#practStaffType'+indx).val('')
	}
		//obj.value = returnedValues[1];
	} 


	if(sqlSelect == 1){
		if(oldVal != obj.value){
			if($('#servOrPanel_'+indx).val() == 'L'){
				updateNetAmount(indx);
			}
		}
		if(obj.value != ''){
			$.ajax({
				type:"POST",
				url:"../jsp/BillHdrAjax.jsp?calledFrom=practStaffType&type="+type+"&code="+obj.value,		
				async:false,
				dataType:"text",
				success: function(data){											
					$('#practStaffType'+indx).val(data);
				},
				error: function(data){
					alert("Error"+data)	;
			     }
			});
		}
		else{
			$('#practStaffType'+indx).val('')
		}
		
		
	}
}

async function doctorCodeValidation(sqlSelect,obj,code,dependVal,indx,codeOrDesc){
	var oldVal = $('#hdnDoctor'+indx).val();
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	var title = '';
	var loc_code_desc = '';
	var loc_code_link = ''
		var type = '';
	switch(sqlSelect){
	
		case 1:
			{
			type = dependVal.value;
			
			sql = "select NAME description, PRACTITIONER_ID code FROM BL_AM_PRACT_STAFF_VW WHERE  upper(NAME) like upper(?) and upper(PRACTITIONER_ID) like upper(?) and FACILITY_ID = '"+facility_id+"' AND UPPER(LANGUAGE_ID) = UPPER('"+locale+"')  AND PRACT_STAFF_IND = '"+type+"' order by 1 ";
			if(type == 'P'){
				title = 'Practitioner';
			}
			else{
				title = 'Other Staff';
			}
			
			loc_code_desc = CODE_DESC;
			loc_code_link = CODE_LINK;
			
			break;
			}
			
		case 2:
		{
			var locale = $('#locale').val();
				sql = "select description,code "+
				"from ( "+
				"select action_reason_desc description, action_reason_code code from bl_action_reason_lang_VW a where nvl(status,'!') != 'S' "+
					"and upper(language_id) = upper('"+locale+"') "+
					"and exists (select b.action_type from bl_action_type b, bl_action_reason_by_type c "+
					"where b.action_type = c.action_type "+
					"and b.action_type = 'OV' "+
					"and c.action_reason_code = a.action_reason_code "+
					"and c.active_yn = 'Y') "+
					") WHERE  upper(code) like upper(?) and upper(description) like upper(?) ";
		title = 'Action Reason';
		loc_code_desc = CODE_DESC;
		loc_code_link = CODE_LINK;
		break;
		}
		
		case 3:
		{
			sql="select description,code from (select short_desc description, cust_group_code code from ar_cust_group_lang_vw where status is null and "+
			"acc_entity_code  in (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') and upper(language_id) = upper('"+locale+"') "+
			" union Select 'All Payer Group','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) "+
			" order by 2";

			title = 'Payer Group';
			loc_code_desc = DESC_CODE;
			loc_code_link = DESC_LINK;
			break;
		}
		
		case 4:
		{
			var cn = $('#location_type').val();
			if(cn == ''){
				
				alert(getMessage('BL00909','BL')); 
				//alert('Please Select Location');
				return false;
			}

			if(cn == 'C'){
				sql="Select description, code from (select short_desc description,clinic_code code from OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E' Union Select 'All Clinic','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Clinic';
			}
			else if(cn == 'W'){
				sql = "Select description, code from (SELECT LONG_DESC DESCRIPTION, NURSING_UNIT_CODE CODE  FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND  FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E' Union Select 'All Nursing Unit','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Nursing Unit';
			}	
			
			loc_code_desc = DESC_CODE;
			loc_code_link = DESC_LINK;
			break;
		}
		
			
	}


	//var sql="SELECT DESCRIPTION, CODE FROM (SELECT 'All' DESCRIPTION,'*ALL' CODE FROM DUAL UNION SELECT A.SHORT_DESC DESCRIPTION,A.SPECIALITY_CODE CODE FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B  WHERE A.LANGUAGE_ID='"+locale+"' AND  A.SPECIALITY_CODE = B.SPECIALITY_CODE ) WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?) ORDER BY 2";
	//alert('sql->'+sql)
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	if(codeOrDesc == '1'){
		argumentArray[4] = "1,2";
		argumentArray[5] = code.value;
		argumentArray[6] = CODE_LINK;
		argumentArray[7] = DESC_CODE;
	}
	else if(codeOrDesc == '2'){
		argumentArray[4] = "2,1";
		argumentArray[5] = obj.value;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;
	}
	
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
		$('#hdnDoctor'+indx).val(arr[0]);
	}
else
	{
	obj.value = arr[1];
	code.value = arr[0];	
	if(sqlSelect == 1){
		$('#practStaffType'+indx).val('')
	}
		//obj.value = returnedValues[1];
	} 

	if(sqlSelect == 1){
		if(oldVal != code.value){			
			if($('#servOrPanel_'+indx).val() == 'L'){
				updateNetAmountDr(indx);
			}
		}
		if(code.value != ''){
			$.ajax({
				type:"POST",
				url:"../jsp/BillHdrAjax.jsp?calledFrom=practStaffType&type="+type+"&code="+code.value,		
				async:false,
				dataType:"text",
				success: function(data){											
					$('#practStaffType'+indx).val(data);
				},
				error: function(data){
					alert("Error"+data)	;
			     }
			});
		}
		else{
			$('#practStaffType'+indx).val('')
		}
		
		
	}
}
async function callCommonValidationCode(sqlSelect,obj,code){
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	var title = '';
	switch(sqlSelect){
	
		case 1:
			{
			sql = "select NAME description, PRACTITIONER_ID code FROM BL_AM_PRACT_STAFF_VW WHERE upper(PRACTITIONER_ID) like upper(?) and upper(NAME) like upper(?) and FACILITY_ID = '"+facility_id+"' AND UPPER(LANGUAGE_ID) = UPPER('"+locale+"')  AND PRACT_STAFF_IND = 'P' order by 1 ";
			title = 'Practitioner';
			break;
			}
			
		case 2:
		{
		sql = "select description,code "+
				"from ( "+
				"SELECT distinct a.action_reason_desc description,  "+
				      " a.action_reason_code code  "+
				" FROM   bl_action_reason_lang_vw a, bl_action_reason_by_type b "+
				" WHERE  a.action_reason_code  = b.action_reason_code  "+
				" AND    NVL(b.active_yn, 'N') = 'Y'  "+
				" AND    NVL(a.status, 'X')   <> 'S'  "+
				" and    upper(a.language_id)=upper('en') "+
				" AND ACTION_TYPE='SD'  ) WHERE upper(description) like upper(?) and upper(code) like upper(?) ";
		title = 'Discount Reason';
		break;
		}
		
		case 3:
		{
			sql="select description,code from (select long_desc description, cust_group_code code from ar_cust_group_lang_vw where status is null and "+
			"cust_group_code in (Select Distinct Cust_Group_Code From Bl_Cust_By_Cust_Group Where Cust_Code In (Select Cust_Code From Ar_Customer_Lang_Vw "+
			"where acc_entity_code  in (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') and upper(language_id) = upper('"+locale+"') "+
			"and nvl(patient_flag,'N')  ='Y' And Nvl(Insurance_Yn, 'N') = 'Y' )) "+
			"And Acc_Entity_Code In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') and upper(language_id) = upper('"+locale+"') union Select 'All Payer Group','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) "+
			" order by 2";

			title = 'Payer Group';
			break;
		}
		
			
	}


	//var sql="SELECT DESCRIPTION, CODE FROM (SELECT 'All' DESCRIPTION,'*ALL' CODE FROM DUAL UNION SELECT A.SHORT_DESC DESCRIPTION,A.SPECIALITY_CODE CODE FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B  WHERE A.LANGUAGE_ID='"+locale+"' AND  A.SPECIALITY_CODE = B.SPECIALITY_CODE ) WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?) ORDER BY 2";
	//alert('sql->'+sql)
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
	code.value =arr[0];		
		//obj.value = returnedValues[1];
	} 


}

function resetExistingOrder(){
	$('input:text').each(function(){
		$(this).val('');
	});
	$('select').each(function(){
		$(this).val('');
	});
	
	$('#serv_class_code').val('');
	$('#bill_serv_code').val('');
	$('#item_code').val('');
	$('#entServ_Grp_code').val('');
	$('#entGrp_Line_code').val('');	
	$('#processed').val('P');
	$('#filterBy').val('G');
	$('#underChrgOnly').prop('checked', false);
		
}

async function showRemarks(indx){

	var dialogHeight= "10" ;
    var dialogWidth      = "22" ;
    var dialogTop = "200" ;
    var center = "1" ;                                                                                              
    var status="no";
    var features  = "overflow:auto; scrollbars:no; dialogHeight:"+dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
    var arguments = "" ;    
  
	var remarks = $('#remarks'+indx).val();
	
	var retVal = await window.showModalDialog("../../eBL/jsp/BLCaptureRemarksForDC.jsp?remarks="+encodeURIComponent(remarks),arguments,features);	

    if(retVal != undefined){
    	 $('#remarks'+indx).val(retVal);
    }
   
}

function calculateTotal(indx){
	noOfDecimals=$(parent.BLChargePatientEncounterTab.document).find('#noOfDecimals').val();
	var amt = $.trim($('#net_amt'+indx).text());
	if(amt == ''){
		amt = 0;
	}
	var total = $.trim($('#spTotalAmt').text());
	if(total == ''){
		total = 0;
	}
	if($('#chk_blng_serv'+indx).prop("checked")){
		total = parseFloat(total) + parseFloat(amt);
	}
	else{
		total = parseFloat(total) - parseFloat(amt);
	}

	$('#spTotalAmt').text(roundToTwo(total));
	
	$('[id^=spTotalAmt]').each(function(){
		if($.trim($(this).text() != '')){
			putDecimal_Text($(this),17,noOfDecimals);				
		}
		else{
			$(this).text('0');
			putDecimal_Text($(this),17,noOfDecimals);
		}
	});
}

function roundToTwo(num) {    
    return +(Math.round(num + "e+2")  + "e-2");
}

function fnSelectAll(){
	var check = 'N';

	if($('#selAllChk').prop('checked')){
		check = 'Y';
		$('[id^=chk_blng_serv]').each(function(){
			 $(this).prop('checked', true);
		});				
	}
	else{
		$('[id^=chk_blng_serv]').each(function(){
			$(this).prop('checked',false);
		});
	}
	
	if(check == 'Y'){
		$('#spTotalAmt').text('0.00');
		$('[id^=resultTr_]').each(function(){
			var index = $(this).attr('data-id');
			calculateTotal(index);
		});
	}
	else{
		$('#spTotalAmt').text('0.00');
	}
	
}
function roundToTwo(num) {    
    return +(Math.round(num + "e+2")  + "e-2");
}

function checkZero(obj){	
	var val = obj.value;

	if(val==0) {
		alert("Quantity can not be Zero.");
		$(obj).val('');
		return false;
	}
	
}

function putDecimal_Text(Obj,maxvalue,deci)
{
	var temp1=$.trim(Obj.text());
	//alert(temp1)
		//Obj.text(temp1);		
	//alert(roundToTwo(temp1));
	var temp4=temp1.length;
	var count=parseInt(maxvalue) -parseInt(deci);
	if (parseInt(deci) > 0)
	{
		if(temp1.indexOf('.') <0)
		{
			if (temp4 <= parseInt(maxvalue))
			{
				if(temp1.length > (parseInt(maxvalue) -parseInt(deci)) && temp1.length <= maxvalue)
				{
					var temp2=temp1.substring(0,count);
					var temp3=temp2+"."+temp1.substring(count,temp1.length)
					if(temp3.length-1 < parseInt(maxvalue))
					{
						for(var t=0;t <=(parseInt(maxvalue)+1-temp3.length);t++)
						{
							temp3+="0";
						}
					}
					Obj.text(temp3);
				}
				else if(temp1.length <= (parseInt(maxvalue) -parseInt(deci)) && temp1.length <= maxvalue)
				{
					var temp3=temp1+'.';
					for(var m=0;m<deci;m++)
					temp3+="0";				
					Obj.text(temp3);				
				}
				if (temp1.length == 0 )
				{
			 		temp3="0.";
					for(var m=0;m<deci;m++)
					temp3+="0";					
					Obj.text(temp3);	 
				}   
			}
		}else{
			
			var temp5=temp1.indexOf('.');
			var temp7=temp1.substring(0,temp5);
			var temp6=temp1.substring(temp7.length+1,(temp7.length+parseInt(deci)+1));
			var nextDigit = temp1.substring(temp7.length+1,(temp7.length+parseInt(deci)+2));

			if(nextDigit.length>temp6.length){
				var lastDigit = nextDigit.substring(deci,parseInt(deci)+1);
				if(lastDigit>=5){
					if(temp6>98){
						temp7 = parseInt(temp7)+1;
						temp6=0;
					}
					else{
						if(temp6.charAt(0) == '0'){
							var temp10 = parseInt(temp6)+1;
							temp6 = '0'+temp10;
						}
						else{
							temp6=parseInt(temp6)+1;
						}												
					}					
					
				}
			}
			var localTemp='';
			var len=parseInt(deci)-parseInt(temp6.length);
			for(var m=0;m<len;m++){
				localTemp+='0';
			}
		
			Obj.text(temp7+"."+temp6+localTemp);
	
		}
	}
//	alert("last")
}


function episodeOption(obj) {	
	$.ajax({
		type:"POST",
		url:"../jsp/BillHdrAjax.jsp?calledFrom=episodeOption&episodeType="+obj.value,		
		async:false,
		dataType:"text",
		success: function(data){							
			//alert("success"+data);
			var dataArr = data.split(":::");
			 $('#optionList').empty();
		
			 if (obj.value == 'R') {
				 $("#optionList").append('<option value=A>All</option>');
			 }
			
			for(var i =0 ; i< dataArr.length-1 ; i++) {
				//alert(dataArr[i]);
				var dataArr1 = dataArr[i].split("::");
				
				$("#optionList").append('<option value='+dataArr1[0]+'>'+dataArr1[1]+'</option>');
			}
			
			if(obj.value == 'O' || obj.value == 'E'){
				$("#optionList").val('A');
			}
		},
		error: function(data){
			alert("Error"+data)	;
	     }
	});
} 

/*Added this function for Rounding the Text Fields Without Rounding*/
function putDecimal_Text_WOR(Obj,maxvalue,deci)
{
	var temp1=$.trim(Obj.text());
	var temp4=temp1.length;
	var count=parseInt(maxvalue) -parseInt(deci);
	if (parseInt(deci) > 0)
	{
		if(temp1.indexOf('.') <0)
		{
			if (temp4 <= parseInt(maxvalue))
			{
				if(temp1.length > (parseInt(maxvalue) -parseInt(deci)) && temp1.length <= maxvalue)
				{
					var temp2=temp1.substring(0,count);
					var temp3=temp2+"."+temp1.substring(count,temp1.length)
					if(temp3.length-1 < parseInt(maxvalue))
					{
						for(var t=0;t <=(parseInt(maxvalue)+1-temp3.length);t++)
						{
							temp3+="0";
						}
					}
					Obj.text(temp3);
				}
				else if(temp1.length <= (parseInt(maxvalue) -parseInt(deci)) && temp1.length <= maxvalue)
				{
					var temp3=temp1+'.';
					for(var m=0;m<deci;m++)
					temp3+="0";				
					Obj.text(temp3);				
				}
				if (temp1.length == 0 )
				{
			 		temp3="0.";
					for(var m=0;m<deci;m++)
					temp3+="0";					
					Obj.text(temp3);	 
				}   
			}
		}else{
			var temp5=temp1.indexOf('.');
			var temp7=temp1.substring(0,temp5);
			var temp6=temp1.substring(temp7.length+1,(temp7.length+parseInt(deci)+1));
			var localTemp='';
			var len=parseInt(deci)-parseInt(temp6.length);
			for(var m=0;m<len;m++){
				localTemp+='0';
			}
		
			Obj.text(temp7+"."+temp6+localTemp);
	
		}
	}
}
//V210129 START
async function getFacility(obj,code,val) {		
	var loc_code_desc = '';
	var loc_code_link = ''
	var locale = document.forms[0].locale.value;	
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	var title = '';
	var loc_code_desc = '';
	var loc_code_link = ''
		
	sql="select description,code from (SELECT facility_name description, facility_id code FROM sm_facility_param_lang_vw WHERE upper(language_id) = upper('"+locale+"') "+
	" union select 'All Facility' description, '**' code  from dual ) where upper(description) like upper(?) and upper(code) like upper(?) "+
	" order by 2";
	title = 'Facility';
	loc_code_desc = DESC_CODE;
	loc_code_link = DESC_LINK;
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray;
		argumentArray[2] = dataValueArray;
		argumentArray[3] = dataTypeArray;		
		if (val==1) {
			argumentArray[4] = "1,2";	
			argumentArray[5] = code;		
		}
		if (val==2) {
			argumentArray[4] = "2,1";	
			argumentArray[5] = obj.value;
		}
		argumentArray[6] = loc_code_link;
		argumentArray[7] = loc_code_desc;
		returnedValues = await CommonLookup(title, argumentArray );		
		if((returnedValues != null) && (returnedValues != "") )  {							
			$('#facilityidName').val(returnedValues[1]);
			$('#facilityid').val( returnedValues[0]);
		}	
}
//V210129 END
