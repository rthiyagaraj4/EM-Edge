/*
Sr No        Version           TFS/Incident        SCF/CRF            		 	Developer Name
------------------------------------------------------------------------------------------------------------------------------
1            V210129             13523     		 MOHE-CRF-0060				Shikha Seth
2	     	 V210503			 8707		   PMG-IRB-BL-00039			  Mohana Priya K
3			V221023							TH-KW-CRF-0020.7		Mohanapriya
4			V221230							NMC-JD-CRF-0191.1 			Mohanapriya
5				V230127							TH-KW-CRF-0092			Mohanapriya
*/

function showServiceDetails(start,end){
	var serviceCode					= document.getElementById("serviceCode").value;
	var serviceClass 			= document.getElementById("serv_class_code").value;
	var billingService			= document.getElementById("bill_serv_code").value;
	var item 				= document.getElementById("item_code").value;
	var entServGroup			= document.getElementById("entServ_Grp_code").value;
	var entGrpLine			= document.getElementById("entGrp_Line_code").value;
	var fromDate			= document.getElementById("from__date").value;
	var toDate				= document.getElementById("to_date").value;

	var patientId			= document.getElementById("patient_id").value;
	var episodeId			= document.getElementById("episode_id").value;
	var visitId				= document.getElementById("visit_id").value;
	var locale				= document.getElementById("locale").value;
	
	var groupLineService		= document.getElementById("filterBy").value;
	var episodeType				= document.getElementById("episode_type").value;
	var serviceLocation		= document.getElementById("serviceLocation").value;
	var acctSeqNo		=  $('#acctSeqNo').val();
	
	var exemptAmt=	document.getElementById("exemptAmt").value;
	var servOrPkg = $("#servOrPkg").val();
	if(servOrPkg == 'P'){
		entServGroup = 'PK';
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
	
	var pDoc = parent.BillReceiptInfo.document;
	var depChkYn = '';
	var prePayChkYn = '';
	if($(pDoc).find('#depAdjChk').prop('checked')){
		depChkYn = 'Y';
	}
	else{
		depChkYn = 'N';
	}
	
	if($(pDoc).find('#prePayChk').prop('checked')){
		prePayChkYn = 'Y';
	}
	else{
		prePayChkYn = 'N';
	}
	
	
	var ipBill = $(pDoc).find('#inPatBillType').val();
	var billGenOpt =  $(pDoc).find('#billGenOpt').val();
	var billGenType =  $(pDoc).find('#billGenType').val();
	
	
	//$('#searchCriteriaDiv').hide();

	$('#resizeBtnSearch').attr('defValue','expand');
	$('#resizeBtnSearch').attr('src','../../eOT/images/ShowMore.gif');
	//document.getElementById('BL_mainFrame').rows =parent.parent.document.getElementById('allFramesExisting').value;
	
	
//	fnShowProgress();	

//	parent.BLChargePatientExisOrderServDetails.location.href = "../../eCommon/html/blank.html";
//	parent.BLChargePatientExisOrderServEdit.location.href = "../../eCommon/html/blank.html";
	//To Show Progress Bar
	parent.BillReceiptExisOrderDetails.location.href = "../../eBL/jsp/BillReceiptExistOrderGroup.jsp?serviceCode="+serviceCode+"&serviceClass="+serviceClass
	+"&billingService="+billingService+"&item="+item+"&entServGroup="+entServGroup+"&entGrpLine="+entGrpLine+"&fromDate="+fromDate+"&toDate="+toDate+
	"&groupLineService="+groupLineService+"&episodeType="+episodeType+"&patientId="+patientId+"&episodeId="+episodeId+"&visitId="+visitId+"&locale="+locale
	+"&serviceLocation="+serviceLocation+'&depChkYn='+depChkYn+'&prePayChkYn='+prePayChkYn+'&ipBill='+ipBill+
	"&acctSeqNo="+acctSeqNo+
	'&billGenOpt='+billGenOpt+'&billGenType='+billGenType+'&fromRcrd='+start+'&toRcrd='+end+'&exemptAmt='+exemptAmt;
	
	

	//alert('Details Loaded');
	//parent.document.getElementById('BL_mainFrame').rows = parent.document.getElementById('allFramesMessage').value;
}


function checkDateBL(entered_date)
{
	
var locale=document.forms[0].locale.value;
if(entered_date.value!="")
{
	if(validDate(entered_date.value,'DMY',locale))
	{
		return true;
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
	
}

async function tooltip(obj,indx,mode){
	
	
	var serviceLocation		= document.getElementById("serviceLocation").value;	
	var acctSeqNo		=  $('#acctSeqNo'+indx).val();//$('#acctSeqNo'+obj).val(); //document.getElementById("acctSeqNo").value;
	
	
	if($('#serv_grp_chk'+indx).prop('checked')){
		alert('All the Services in this group are Excluded');
		return false;
	}
	$('td[id^=serv_grp_code]').each(function(){
		$(this).removeClass('greyedData');
		$(this).addClass('gridDataBlue');
		//$(this).attr('background-color','#e5e5e5');
	});

	$('img[id^=imgArrow]').attr('src','../../eCommon/images/inactiveArrow.gif');
	$(obj).addClass('greyedData');
	$('#imgArrow'+indx).attr('src','../../eCommon/images/activeArrow.gif');

	var status = await populateService(indx,mode);

	/*Commented to Refresh tro Button*/
	/*var queryString = $("#queryString").val();
	if(status=='Y'){
		$(parent.BillReceiptExisOrderSearch.document).find('#add_mod').click();
		//document.location.href = '../jsp/BillReceiptExistOrderGroup.jsp?'+queryString;
	}*/
	var queryString = document.getElementById('queryString').value;
	if (status == 'Y') {
		
	    var addModElement = parent.BillReceiptExisOrderSearch.document.querySelector('#add_mod');
	   
	    
	    if (addModElement) {
	        addModElement.click();
	    }
	}
	/*else{
		$.ajax({
			type:"GET",
			url:"../jsp/BillReceiptExclusionPersistence.jsp",
			data:"func_mode=checkServicesExcluded",
			dataType:"text",
			async:false,
			success: function(data){
				if(data=='true'){
					//alert('reloading doc')
					document.location.href = '../jsp/BillReceiptExistOrderGroup.jsp?'+queryString;
				}
				else{
					//alert('No refresh')
				}
				
			},
			 error: function(data){
				 alert(data)
		      }
		});
	}/**/
	
	
}


function hideToolTip()	{
	  document.getElementById("tooltiplayer1").style.visibility = 'hidden';
}

function resizeWindowForServ(orderctlHDR)
{
    var orderctlHDR1 = orderctlHDR.id;

	var wdth = eval(document.getElementById('orderctlHDR1')).offsetWidth;
	var hght1 = eval(document.getElementById('orderctlHDR1')).offsetHeight;		
	// alert(wdth + ',' + hght1)
	var wdth1 = getPos(orderctlHDR).x +wdth;
	var hght = getPos(orderctlHDR).y ;	
	// alert(wdth1 + ',' + hght)
	bodwidth  = document.body.offsetWidth
	bodheight = document.body.offsetHeight
	
	var z = bodwidth- (event.x + wdth);	
	
	var x 	  = event.x;
	var y 	  = event.y;	
	
	x 	  = x + (document.getElementById("divtooltipServ1").offsetWidth);
	y 	  = hght + (document.getElementById("divtooltipServ1").offsetHeight);	
	
	if(x<bodwidth){
		x= wdth1;
		
	}else{			
		x = getPos(orderctlHDR).x;
		
	}
	if(y<bodheight){			
		y = hght;
		
	}else
	{
		y = y - (document.getElementById("divtooltipServ1").offsetHeight*2) + hght1 ;	
	}
	 //alert(x + ',' + y)
	 //alert(document.getElementById("divtooltipServ1").style.visibility)
	document.getElementById("divtooltipServ1").style.posLeft= x;
	document.getElementById("divtooltipServ1").style.posTop = hght;
	document.getElementById("divtooltipServ1").style.visibility='visible';
}

function showOrderDetails(obj,indx) {
	resizeWindowForServ(obj);

	$('td[id^=serv_grp_code]').each(function(){
		$(this).removeClass('greyedData');
		$(this).addClass('gridDataBlue');
	});
	$('#serv_grp_code'+indx).addClass('greyedData');
	$('img[id^=imgArrow]').attr('src','../../eCommon/images/inactiveArrow.gif');
	$('#imgArrow'+indx).attr('src','../../eCommon/images/activeArrow.gif');

	$('#tdOrderNo').html(': '+$('#orderNo'+indx).val());
	$('#tdQty').html(': '+$('#orderQty'+indx).val());
	$('#tdPhysician').html(': '+$('#physicianId'+indx).val());
	$('#tdServDept').html(': '+$('#servDept'+indx).val());
}
function tooltipforexcludeservice(obj,indx){	
	var status = populateServiceforexcludedservice(indx);	
	if(status=='Y'){
		$(parent.BillReceiptExisOrderSearch.document).find('#add_mod').click();	
	}		
}

async function populateService(obj,mode){
	var pDoc = parent.BillReceiptExisOrderSearch.document;
	var entServGroup					= $.trim($('#serv_grp_code'+obj).text());
	var entGrpLine						= '';	
	var serviceLocation		= document.getElementById("serviceLocation").value;
	var acctSeqNo		=  $('#acctSeqNo'+obj).val();


	var patientId						= pDoc.getElementById("patient_id").value;
	var episodeId						= pDoc.getElementById("episode_id").value;
	var visitId							= pDoc.getElementById("visit_id").value;
	var locale							= pDoc.getElementById("locale").value;
	
	var groupLineService				= "D";
	var episodeType						= pDoc.getElementById("episode_type").value;
	var entGroupName = $('#hdnServGrpDesc'+obj).val(); 

	var billGenOpt = $("#billGenOpt").val();
	var billGenType = $("#billGenType").val();
	//var direct_indirectchgs = pDoc.getElementById("direct_indirectchgs").value;
	
	var prevClicked = $('#prevClicked').val();
	if(prevClicked.length>0){
		/*$('#resultTr_'+prevClicked +' td:not(:nth-child(2))').each(function(){
			$(this).attr('class','fields');
		});*/
		$('#resultTROfFirst'+prevClicked +' td').each(function(){
			$(this).removeClass('YELLOW');
		});
		$('#resultTROfSecond'+prevClicked +' td' ).each(function(){
			$(this).removeClass('YELLOW');
		});
	}

	/*$('#resultTr_'+obj +' td:not(:nth-child(2))').each(function(){
		$(this).attr('class','YELLOW');
	});*/
	$('#resultTROfFirst'+obj +' td').each(function(){
		$(this).addClass('YELLOW');
	})
	$('#resultTROfSecond'+obj +' td').each(function(){
		$(this).addClass('YELLOW');
	})
	$('#prevClicked').val(obj);
	
	if(mode == 'entGroup'){
		pDoc = pDoc.getElementById("entGrp_Line_code").value;
	}
	else if(mode == 'entLine'){
		entGrpLine = $.trim($('#serv_line_code'+obj).text());
	}
	hideToolTip();
	var noOfDecimal = $(parent.BillReceiptTab.document).find('#noOfDecimal').val();
	var billCashBlngServSeparately = $(parent.BillReceiptTab.document).find('#billCashBlngServSeparately').val();
	var allow_service_selection_yn= $(parent.BillReceiptTab.document).find('#allow_service_selection_yn').val();
	var adhoc_discount_allowed_yn = $(parent.BillReceiptTab.document).find('#adhoc_discount_allowed_yn').val();
	var pkgClosedYn = $(parent.BillReceiptTab.document).find('#pkgClosedYn').val();
	var ipBill = $('#ipBill').val();
	var url="../../eBL/jsp/BillReceiptExistOrderServiceFrame.jsp?entServGroup="+entServGroup+"&entGrpLine="+entGrpLine
				+"&serviceLocation="+serviceLocation+"&groupLineService="+groupLineService
				+"&acctSeqNo="+acctSeqNo
				+"&episodeType="+episodeType+"&patientId="+patientId+"&episodeId="+episodeId+"&visitId="+visitId+"&locale="+locale
				+"&entGroupName="+encodeURIComponent(entGroupName)+'&noOfDecimal='+noOfDecimal+'&ipBill='+ipBill+
				"&billCashBlngServSeparately="+billCashBlngServSeparately+"&allow_service_selection_yn="+allow_service_selection_yn+
				"&billGenOpt="+billGenOpt+"&billGenType="+billGenType+"&adhoc_discount_allowed_yn="+adhoc_discount_allowed_yn+
				"&pkgClosedYn="+pkgClosedYn;
	
	var dialogHeight= "95vh" ;
	var dialogWidth	= "99vw" ;   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status: " + status + "; scroll=auto; center:yes";
	var popupWindow =await window.showModalDialog(url,null,features);  
	return popupWindow;

}

async function populateServiceforexcludedservice(obj){
	var pDoc = parent.BillReceiptExisOrderSearch.document;
	var serviceLocation		= document.getElementById("serviceLocation").value;
	var acctSeqNo		= document.getElementById("acctSeqNo").value;

	var patientId						= pDoc.getElementById("patient_id").value;
	var episodeId						= pDoc.getElementById("episode_id").value;
	var visitId							= pDoc.getElementById("visit_id").value;
	var locale							= pDoc.getElementById("locale").value;
	
	var groupLineService				= "D";
	var episodeType						= pDoc.getElementById("episode_type").value;
	

	var billGenOpt = $("#billGenOpt").val();
	var billGenType = $("#billGenType").val();
	
	
	var prevClicked = $('#prevClicked').val();
	if(prevClicked.length>0){
		
		$('#resultTROfFirst'+prevClicked +' td').each(function(){
			$(this).removeClass('YELLOW');
		});
		$('#resultTROfSecond'+prevClicked +' td' ).each(function(){
			$(this).removeClass('YELLOW');
		});
	}

	var noOfDecimal = $(parent.BillReceiptTab.document).find('#noOfDecimal').val();
	var billCashBlngServSeparately = $(parent.BillReceiptTab.document).find('#billCashBlngServSeparately').val();
	var allow_service_selection_yn= $(parent.BillReceiptTab.document).find('#allow_service_selection_yn').val();
	var adhoc_discount_allowed_yn = $(parent.BillReceiptTab.document).find('#adhoc_discount_allowed_yn').val();
	var pkgClosedYn = $(parent.BillReceiptTab.document).find('#pkgClosedYn').val();
	var ipBill = $('#ipBill').val();
	var url="../../eBL/jsp/BillReceiptExistOrderServiceFrame.jsp?episodeType="+episodeType+
		"&patientId="+patientId+"&episodeId="+episodeId+"&visitId="+visitId+"&locale="+locale+
		"&noOfDecimal="+noOfDecimal+"&ipBill="+ipBill+
		"&billCashBlngServSeparately="+billCashBlngServSeparately+
		"&allow_service_selection_yn="+allow_service_selection_yn+
		"&billGenOpt="+billGenOpt+"&billGenType="+billGenType+
		"&adhoc_discount_allowed_yn="+adhoc_discount_allowed_yn+
		"&pkgClosedYn="+pkgClosedYn;
				
	var dialogHeight= "95vh" ;//40
	var dialogWidth	= "99vw" ;   //80
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status: " + status + "; scroll=auto; center:yes";
	var popupWindow =await window.showModalDialog(url,null,features);  
	return popupWindow;

}
function excludeServices(){
	
	var frm = parent.serviceList.document.billReceiptServiceList;
	var xmStr = getExculdedServicesString();
	//alert(xmStr)
	var retVal = formValidation(xmStr,"excludeService");
	parent.window.returnValue = $('#hdnRefresh').val();
	parent.window.close();
}

function nextPrevExcludeServices(){
	
	var frm = parent.serviceList.document.billReceiptServiceList;
	var xmStr = getExculdedServicesString();
	//alert(xmStr)
	var retVal = formValidation(xmStr,"nextPrevExcluded");	
}

function excludeGroup(obj){
	var frm = document.existingOrderByGroup;
	var groupOrLine = $('#groupLineService').val();
	var funcName = '';
	var xmlStr ="<root><SEARCH ";
	if(groupOrLine == 'G'){
		xmlStr+= "serv_grp_code"+"=\"" + checkSpl($.trim($('#serv_grp_code'+obj).text())) + "\" ";
	}
	else if(groupOrLine == 'L'){
		xmlStr+= "serv_grp_code"+"=\"" + checkSpl($.trim($('#serv_grp_code'+obj).text())) + "\" "+
		"serv_line_code"+"=\"" + checkSpl($.trim($('#serv_line_code'+obj).text())) + "\" ";
	}
		
	xmlStr +=" /></root>";	
	if($('#serv_grp_chk'+obj).prop('checked')){
		if(groupOrLine == 'G'){
			funcName = 'excludeGroupAdd';
		}
		else if(groupOrLine == 'L'){
			funcName = 'excludeLineAdd';
		}
		
	}
	else{
		if(groupOrLine == 'G'){
			funcName = 'excludeGroupRemove';
		}
		else if(groupOrLine == 'L'){
			funcName = 'excludeLineRemove';
		}
	}
	var retVal = formValidation(xmlStr,funcName);
	var queryString = $("#queryString").val();
	document.location.href = '../jsp/BillReceiptExistOrderGroup.jsp?'+queryString;
}

function chkExcludeServ(indx){
	/*var blngServ = $.trim($('#serv_grp_code'+indx).text());
	var trxDocRef = $('#trxDocRef'+indx).val();
	var trxDocrefLineNum = $('#trxDocRefLineNum'+indx).val();
	var trxDocRefSeqNum = $('#trxDocRefSeqNum'+indx).val();
	var dataArray = excludedUnChecked.split('####');
	var servCode = blngServ+"::::"+trxDocRef+"::::"+trxDocrefLineNum+"::::"+trxDocRefSeqNum;
	if($('#serv_grp_chk'+indx).prop('checked')){
		dataArray.splice($.inArray(servCode, dataArray),1);		
	}
	else{
		dataArray.push(servCode);
		
	}
	excludedUnChecked = dataArray.join('####');*/
	$(parent.closeWinsow.document).find('#hdnRefresh').val('Y');
}

function fnSelectAll(){
	var check = 'N';
	if($('#serv_grp_chk_all').prop('checked')){
		check = 'Y';
		$('[id^=serv_grp_chk]').each(function(){
			$(this).attr('checked','checked');
		});				
	}
	else{
		$('[id^=serv_grp_chk]').each(function(){
			$(this).prop('checked',false);
		});
	}
	$(parent.closeWinsow.document).find('#hdnRefresh').val('Y');
}

function getExculdedServicesString(){
	var xmlStr ="<root><SEARCH ";
	$(parent.serviceList.document).find('input[id^=serv_grp_chk]').each(function(){
		if($(this).prop('checked')){			
			xmlStr+= $(this).attr('id')+"=\"Y" + "\" " ;
		}
		else{
			xmlStr+= $(this).attr('id')+"=\"N" + "\" " ;
		}
	});
	$(parent.serviceList.document).find('td[id^=serv_grp_code]').each(function(){
		xmlStr+= $(this).attr('id')+"=\"" + checkSpl($.trim($(this).text())) + "\" " ;
	});		
	
	$(parent.serviceList.document).find("input[type='hidden']").each(function(){
		xmlStr+= $(this).attr('id')+"=\"" + checkSpl($(this).val()) + "\" " ;
	});
	
	//xmlStr+= "excludedUnChecked"+"=\"" + checkSpl(window.parent.serviceList.excludedUnChecked) + "\" ";
	xmlStr +=" /></root>";	
	return xmlStr;
}
function formXMLString(frmObj)
{
    if( frmObj!=null && frmObj != "undefined" && frmObj.length >0)
	{	
		var xmlStr ="<root><SEARCH ";
		if(true)
		{
		var arrObj = frmObj.elements;
		for(var i=0;i<arrObj.length;i++)
		{
			var val = "" ;
			if(arrObj[i].type == "checkbox")
			{
				if(arrObj[i].checked)
				{
					val = arrObj[i].value;
					if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=\"Y" + "\" " ;
				}
				else{
					if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=\"" + "N" + "\" " ;
				}
	        }
		    else if(arrObj[i].type == "radio")
			{
				if(arrObj[i].checked)
				{
					val = arrObj[i].value;
			        if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
	            }
		    }
			else if(arrObj[i].type == "select-multiple" )
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
	xmlStr +=" /></root>";	
	}
	return xmlStr;
}

function formValidation(xmlStr,last_link)
{	
	var temp_jsp="../../eBL/jsp/BillReceiptExclusionPersistence.jsp?func_mode="+last_link;
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	/*if (xmlDoc.parseError.errorCode != 0)
	{
		alert("Error in line " + xmlDoc.parseError.line +
				" position " + xmlDoc.parseError.linePos +
				"\nError Code: " + xmlDoc.parseError.errorCode +
				"\nError Reason: " + xmlDoc.parseError.reason +
				"Error Line: " + xmlDoc.parseError.srcText);
		return(null);
	}*/
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	/*if (xmlDoc.parseError.errorCode != 0)
	{
		alert("Error in line " + xmlDoc.parseError.line +
				" position " + xmlDoc.parseError.linePos +
				"\nError Code: " + xmlDoc.parseError.errorCode +
				"\nError Reason: " + xmlDoc.parseError.reason +
				"Error Line: " + xmlDoc.parseError.srcText);
		return(null);
	}*/
	var responseText=xmlHttp.responseText;


	return responseText;

}

/*function formValidation(xmlStr, last_link) {	
    var temp_jsp = "../jsp/BillReceiptExclusionPersistence.jsp?func_mode=" + last_link;
    var xmlHttp = new XMLHttpRequest();
    
    // Parse the XML string
    var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

    // Check for parsing errors
    var parserError = xmlDoc.getElementsByTagName("parsererror");
    if (parserError.length > 0) {
        alert("Error parsing XML: " + parserError[0].textContent);
        return null;
    }

    // Send the XML document via an HTTP request
    xmlHttp.open("POST", temp_jsp, false);
    xmlHttp.send(xmlDoc);

    // You might want to check the response status here
    if (xmlHttp.status !== 200) {
        alert("Error with the HTTP request: " + xmlHttp.statusText);
        return null;
    }

    var responseText = $.trim(xmlHttp.responseText);
    return responseText;
}*/

function checkForSpecChars(event) {
	var strCheck = '1234567890.';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  
	if (strCheck.indexOf(key) == -1) return false;  
	return true ;
}

function findTotal(){
	var total_amount = 0;
	$('td[id^=net_amt]').each(function(){
		total_amount = parseFloat(total_amount) + parseFloat($.trim($(this).text()));
	});
	
	//total_amount = roundToTwo(total_amount);
	var summDoc = parent.BillReceiptExisOrderSummary.document;
	var paymentDoc = parent.BillReceiptWindow.document;
	$(summDoc).find('#payableAmount').html(total_amount);
	$(summDoc).find('#netPayableAmount').html(total_amount);
	
	var prevOutStanding = $(paymentDoc).find('#hdnOverAllOutStanding').val();
	var prevTotal = $(paymentDoc).find('#hdnPrevTotal').val();
	
	//alert(prevOutStanding)
	if(prevOutStanding != total_amount && prevOutStanding!='' && prevTotal!=''){
		var changeInAmount = parseFloat(prevTotal) - parseFloat(total_amount);
		//alert(changeInAmount)
		var oldSettlement = $(paymentDoc).find('#overAllOutStanding').val();
		//alert(oldSettlement)
		var newSettlement = parseFloat(oldSettlement) - parseFloat(changeInAmount);
		//alert(newSettlement)
		$(paymentDoc).find('#overAllOutStanding').val(newSettlement);
		$(paymentDoc).find('#hdnOverAllOutStanding').val(newSettlement);
		if(prevOutStanding!=''){
			//alert('Change in Bill Settlement Occurred. Kindly add the Settlements again');
			//$(paymentDoc).find('#clearBtn').click();
		}
		$(paymentDoc).find('#hdnPrevTotal').val(total_amount);
	}
	else{
		$(paymentDoc).find('#overAllOutStanding').val(total_amount);
		$(paymentDoc).find('#hdnOverAllOutStanding').val(total_amount);
		$(paymentDoc).find('#hdnPrevTotal').val(total_amount);
	}
	
}

function roundToTwo(num) {    
    return +(Math.round(num + "e+2")  + "e-2");
}

function changeDiscInd(gross,type,value,net){
	findPatPayable(gross,type,value,net);
}

function findPatPayable(gross,type,value,net){
	var patPayable = '';
	var amt_limit_ind = $(type).val();
	var disc = $(value).val();
	var grossAmt = $.trim($(gross).text());
    if ( trimCheck(disc) && isNaN(disc) == false && disc >= 0) {
    	if(amt_limit_ind != ''){
    		

    		if(amt_limit_ind == 'A'){
    			patPayable = grossAmt - disc;
    			//patPayable = roundToTwo(patPayable);
	
    		}
    		else{
    			var discAmount = grossAmt * disc / 100;
    			patPayable = (grossAmt ) - (discAmount);	    
    			//patPayable = roundToTwo(patPayable)
    		}
    		if(patPayable<0){
	    		alert('Discount Amount should be Lesser than '+grossAmt);
	    		$(value).val('');
	    		$(net).html(grossAmt);
	    	}
	    	else{
	    		$(net).html(patPayable);
	    	}
	        return true;
    	}
    	else{
    		alert('Please choose Amount / Percent Indicator');
    		$(value).val('');
    		$(net).html(grossAmt);
    		return false;
    	}
    	
    }
    else {
        if ( disc.length > 0 ) {

            alert(getMessage("NUM_ALLOWED", "SM"));
            $(value).val('');
            $(net).html(grossAmt);
            return false;
        }
    }
}

function grossAmtValidation(obj,obj1,obj2)
{
	var noOfDecimals = $('#noOfDecimals').val();
	if (obj.value >= 0 && obj.value<=100) {
		putDecimal_field($('#discountPer').get(0),17,noOfDecimals);	
	}else {
		alert("Enter value between 0 and 100");
		obj.value = '';//(discountPer);
		obj1.value='';
		obj2.value='';		
		return false;
	}
}

function findDiscount(gross,amt_limit_ind,value,net,other){
	
	var noOfDecimals = $('#noOfDecimals').val();
	if(amt_limit_ind == 'A'){ 
		putDecimal_field($('#discountAmt').get(0),17,noOfDecimals);
		if(parseFloat($('#actGrossAmt').val()) < parseFloat(0)){ 
				if(parseFloat($('#discountAmt').val()) > parseFloat(0)){
					alert(getMessage('BL6281','BL'));
					$('#hdnDiscPer').val('');
					$('#hdnDiscAmt').val('');
					$('#discountPer').val('');
					$('#discountAmt').val('');
					$('#netAfterDisc').val($('#actGrossAmt').val());
					return false;
				}
				else if(parseFloat($('#discountAmt').val()) < parseFloat($('#actGrossAmt').val())){
					alert(getMessage('BL6269','BL'));
					$('#hdnDiscPer').val('');
					$('#hdnDiscAmt').val('');
					$('#discountPer').val('');
					$('#discountAmt').val('');
					$('#netAfterDisc').val($('#actGrossAmt').val());
					return false;
				}
			
			
		}
		else if(parseFloat($('#discountAmt').val()) == parseFloat(0)){
			
		}
		else if(parseFloat($('#actGrossAmt').val()) > parseFloat(0)){
			if(parseFloat($('#discountAmt').val()) < parseFloat(0)){
				alert(getMessage('BL6281','BL'));
				$('#hdnDiscPer').val('');
				$('#hdnDiscAmt').val('');
				$('#discountPer').val('');
				$('#discountAmt').val('');
				$('#netAfterDisc').val($('#actGrossAmt').val());
				return false;
			}
			else if(parseFloat($('#discountAmt').val()) > parseFloat($('#actGrossAmt').val())){
				alert(getMessage('BL6269','BL'));
				$('#hdnDiscPer').val('');
				$('#hdnDiscAmt').val('');
				$('#discountPer').val('');
				$('#discountAmt').val('');
				$('#netAfterDisc').val($('#actGrossAmt').val());
				return false;
			}
		}
		if($('#discountAmt').val() == $('#hdnDiscAmt').val()){
			return false;
		}
	}
	else{
		putDecimal_field($('#discountPer').get(0),17,noOfDecimals);
		if($('#discountPer').val() > 100){
			alert(getMessage("BL6154", "BL"));
			$('#hdnDiscPer').val('');
			$('#hdnDiscAmt').val('');
			$('#discountPer').val('');
			$('#discountAmt').val('');
			$('#netAfterDisc').val($('#actGrossAmt').val());
			return false;
			
		}
		if($('#discountPer').val() == $('#hdnDiscPer').val()){			
			return false;
		}
	}
	var patPayable = '';
	var discAmount = '';
	var discPer = '';
	var disc = $(value).val();
	var grossAmt = $.trim($(gross).text());	
	if(grossAmt == 0){
		  alert(getMessage("BL6281", "BL"));  
		  value.value='';
		  other.value='';
		  if(amt_limit_ind == 'A'){ 
				$('#hdnDiscAmt').val('');
			}
			else{
				$('#hdnDiscPer').val('');
			}
		  return false;
	}
	
    if ( trimCheck(disc) && isNaN(disc) == false  ) {
    	if(amt_limit_ind != ''){
    		if(amt_limit_ind == 'A'){    			
    			patPayable = grossAmt - disc;
    			//patPayable = roundToTwo(patPayable);
    			
    			discPer = (disc/grossAmt)*100;	    		
    		}
    		else{    		
    			discAmount = grossAmt * disc / 100;
    			patPayable = (grossAmt ) - (discAmount);
    			//patPayable = roundToTwo(patPayable);
    		}
    		
    		$(net).val(patPayable);
    		putDecimal_field($(net).get(0),17,noOfDecimals);
    		if(amt_limit_ind == 'A' ){	    			
    			$('#discountPer').val(discPer);
    			putDecimal_field($('#discountPer').get(0),17,noOfDecimals);
    			putDecimal_field($('#discountAmt').get(0),17,noOfDecimals);
    			$('#hdnDiscPer').val($('#discountPer').val());
    			$('#hdnDiscAmt').val($('#discountAmt').val());
    		}
    		else{	    			
    			$('#discountAmt').val(discAmount);	    			
    			putDecimal_field($('#discountAmt').get(0),17,noOfDecimals);
    			putDecimal_field($('#discountPer').get(0),17,noOfDecimals);
    			$('#hdnDiscAmt').val($('#discountAmt').val());
    			$('#hdnDiscPer').val($('#discountPer').val());
    		}	    		
	        return true;
    	}
    	else{
    		alert(getMessage("BL00955", "BL"));
    		$('#hdnDiscPer').val('');
			$('#hdnDiscAmt').val('');
			$('#discountPer').val('');
			$('#discountAmt').val('');
			$('#netAfterDisc').val($('#actGrossAmt').val());
    		return false;
    	}
    	
    }
    else {
        if ( disc.length > 0 ) {
            alert(getMessage("NUM_ALLOWED", "SM"));         
            $('#hdnDiscPer').val('');
			$('#hdnDiscAmt').val('');
			$('#discountPer').val('');
			$('#discountAmt').val('');
			$('#netAfterDisc').val($('#actGrossAmt').val());        
            return false;
        }
    }
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
		
		if(!(checkDt(str_date))){
			return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
		}
		
		if(!(isValidTime(str_time))){
			return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
		}
	}

	return true;
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
       var time1arr=new Array()
       time1arr=time1.split(":")
			
            if(time1arr.length==3)
            {
                var time1hr=time1arr[0];
                var time1min=time1arr[1];
                var time1sec = time1arr[2];
				if (time1hr.length != 2 || time1min.length != 2 || time1sec.length != 2)
				{
					 retval=false;
				}

                time1hr=eval(time1hr)
                time1min=eval(time1min)
                time1sec = eval(time1sec)
                if(time1hr<=23)
                {
                    if(time1min>59)
                    {
                            retval=false;                      
                    }
                    if(time1sec>59){
                    	retval=false;
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

function payerHide(type){
	var maxPayer = $('#maxPayer').val();
	var billGenOpt = $('#billGenOpt').val();
	if(billGenOpt == 'C'){
		$('td[id^=tdCash]').each(function(){
			$(this).hide();
		});
		$('td[id^=cash]').each(function(){
			$(this).hide();
		});
		setTableWidth('100%','20%','80%');
	}
	if(maxPayer == 0){
		hidePayerTroLoop(1);
		if(type == 'G'){
			setTableWidth('100%','20%','80%');
		}
		else{
			setTableWidth('100%','20%','80%');
		}
		
	}
	else if(maxPayer == 1){
		hidePayerTroLoop(2);
		if(type == 'G'){
			setTableWidth('120%','17%','83%');
		}
		else{
			setTableWidth('130%','15%','85%');
		}
	}
	else if(maxPayer == 2){
		hidePayerTroLoop(3);
		if(type == 'G'){
			setTableWidth('150%','13%','87%');
		}
		else{
			setTableWidth('160%','12.5%','87.5%');
		}
	}
	else if(maxPayer == 3){
		hidePayerTroLoop(4);
		if(type == 'G'){
			setTableWidth('175%','11%','89%');
		}
		else{
			setTableWidth('190%','10.5%','89.5%');
		}
	}
	else if(maxPayer == 4){
		hidePayerTroLoop(5);
		if(type == 'G'){
			setTableWidth('200%','10%','90%');
		}
		else{
			setTableWidth('220%','9%','89%');
		}
	}
	else if(maxPayer == 5){
		hidePayerTroLoop(6);
		if(type == 'G'){
			setTableWidth('225%','9%','91%');
		}
		else{
			setTableWidth('250%','8%','92%');
		}
	}
	else if(maxPayer == 6){
		hidePayerTroLoop(6);
		if(type == 'G'){
			setTableWidth('250%','8%','92%');
		}
		else{
			setTableWidth('280%','7%','93%');
		}
	}
	else if(maxPayer == 7){
		setPayerDescforLastPayer(7);
		if(type == 'G'){
			setTableWidth('275%','7%','93%');
		}
		else{
			setTableWidth('320%','6%','94%');
		}
	}
	
}

function hidePayerTroLoop(obj){
	var totPayer = 7;
	for(var i = totPayer; i>=obj; i--){
		$('td[id^=payer'+i+']').each(function(){
			//alert($(this).attr('id'))
			$(this).hide();
		});
	}

	for(var j=1; j<=obj; j++){
		$('#payerSpan'+j+'Hdr').html($('#payerPolDesc'+j).val());
	}
}

function setPayerDescforLastPayer(obj){
	for(var j=1; j<=obj; j++){
		$('#payerSpan'+j+'Hdr').html($('#payerPolDesc'+j).val());
	}
}

function setTableWidth(table,firstCell,secondCell){
	$('#panel_categories_header_table').css('width',table);
	$('td[id^=firstMainCol]').each(function(){
		$(this).css('width',firstCell);		
	});
	$('td[id^=secondMainCol]').each(function(){
		$(this).css('width',secondCell);		
	});
}


function resizeWindow(orderctlHDR,indx)
{
    var orderctlHDR1 = orderctlHDR.id;
	var wdth = eval(document.getElementById('orderctlHDR1')).offsetWidth;
	var hght1 = eval(document.getElementById('orderctlHDR1')).offsetHeight;		
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
	
	x 	  = x + (eval(document.getElementById("tooltiplayer"+indx)).offsetWidth);
	y 	  = hght + (eval(document.getElementById("tooltiplayer"+indx)).offsetHeight);	
	
	if(x<bodwidth){
		x= wdth1;
		
	}else{			
		x = getPos(orderctlHDR).x;
		
	}
	if(y<bodheight){			
		y = hght;
		
	}else
	{
		y = y - (eval(document.getElementById("tooltiplayer"+indx)).offsetHeight*2) + hght1 ;	
	}

	eval(document.getElementById("tooltiplayer"+indx)).style.posLeft= x;
	if(y<0){
		if(hght>hght1){
			eval(document.getElementById("tooltiplayer"+indx)).style.posTop = hght;
		}
		else{
			eval(document.getElementById("tooltiplayer"+indx)).style.posTop = hght1;
		}
		
	}
	else{
		/*if(hght>y){
			document.getElementById("tooltiplayer1").style.posTop = hght;
		}
		else{*/
		eval(document.getElementById("tooltiplayer"+indx)).style.posTop = y;//document.getElementById("tooltiplayer1").style.posTop = y;
		//}
		
	}
	//alert(document.getElementById("tooltiplayer1").style.posTop)
	$('#tooltiplayer'+indx).css('visibility','visible');
	//document.getElementById("tooltiplayer1").style.visibility='visible'
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

function hideToolTip(obj)	{
	$('#tooltiplayer'+obj).css('visibility','hidden');	  
}

function hideOrderToolTip(obj)	{
	$('#divtooltipServ1').css('visibility','hidden');	  
	$('#serv_grp_code'+obj).removeClass('greyedData');
	$('#serv_grp_code'+obj).addClass('gridDataBlue');
	$('#imgArrow'+obj).attr('src','../../eCommon/images/inactiveArrow.gif');
}

function clearCode(obj){
	obj.value = '';
}

function refreshBillService(start,end){
	var pDoc = parent.serviceList.document;
	var entServGroup = $.trim($('#entServ_Grp_code').val());
	var entGrpLine = $.trim($('#entGrp_Line_code').val());
	var groupLineService = 'D';
	var episodeType = $(pDoc).find('#episodeType').val();
	var patientId = $(pDoc).find('#patientId').val();
	var episodeId = $(pDoc).find('#episodeId').val();
	var visitId = $(pDoc).find('#visitId').val();
	var locale = $('#locale').val();

	var blngServGrp= $.trim($('#serviceCode').val());
	var blngServClass= $.trim($('#serv_class_code').val());

	//var blngServClassName= ;
	
	if(blngServGrp == '' && entServGroup == '' && entGrpLine == '' && blngServClass == ''){
		alert(getMessage('BL00925','BL'));
		return false;
	}
	$(parent.closeWinsow.document).find('#orderDetails').hide();
	//parent.document.getElementById('parentFrame').rows = '5%,80%,15%';
		parent.document.getElementById('progressFrame').style.hight='5vh';
		parent.document.getElementById('serviceList').style.hight='80vh';
		parent.document.getElementById('closeWinsow').style.hight='15vh';
		
	var url="../../eBL/jsp/BillReceiptExistOrderService.jsp?entServGroup="+entServGroup+"&entGrpLine="+entGrpLine
	+"&groupLineService="+groupLineService
	+"&episodeType="+episodeType+"&patientId="+patientId+"&episodeId="+episodeId+"&visitId="+visitId+"&locale="+locale+
	"&serviceCode="+blngServGrp+"&serviceClass="+blngServClass+"&fromRcrd="+start+"&toRcrd="+end;
	parent.progressFrame.location.href = "../../eCommon/jsp/process.jsp";
	pDoc.location.href = url;
}

async function callCommonLookupCode(obj,code,sqlSelect,codeDesc,commonCode){
	var locale = document.forms[0].locale.value;
	var facility_id = $('#facilityId').val();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	var title = '';
	
	switch(sqlSelect){
			
		case 1:
		{
			sql = "select description,code "+
			"from ( "+
			"SELECT distinct a.action_reason_desc description,  "+
			      " a.action_reason_code code  "+
			" FROM   bl_action_reason_lang_vw a, bl_action_reason_by_type b "+
			" WHERE  a.action_reason_code  = b.action_reason_code  "+
			" AND    NVL(b.active_yn, 'N') = 'Y'  "+
			" AND    NVL(a.status, 'X')   <> 'S'  "+
			" and    upper(a.language_id)=upper('"+locale+"') "+
			" AND ACTION_TYPE='SD'  ) WHERE upper(description) like upper(?) and upper(code) like upper(?) ";
			title = 'Discount Reason';

		}
	}

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	if(codeDesc == '1'){
		argumentArray[4] = "1,2";
		argumentArray[5] = code.value;
		argumentArray[6] = CODE_LINK;
		argumentArray[7] = DESC_CODE;
	}
	else if(codeDesc == '2'){
		argumentArray[4] = "2,1";
		argumentArray[5] = obj.value;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;
	}

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
	} 
}
async function callCommonValidation(sqlSelect,obj,code,indx){
	//alert("1");
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
	switch(sqlSelect){
		
		case 1:
		{
			sql = "select description,code "+
			"from ( "+
			"SELECT distinct a.action_reason_desc description,  "+
			      " a.action_reason_code code  "+
			" FROM   bl_action_reason_lang_vw a, bl_action_reason_by_type b "+
			" WHERE  a.action_reason_code  = b.action_reason_code  "+
			" AND    NVL(b.active_yn, 'N') = 'Y'  "+
			" AND    NVL(a.status, 'X')   <> 'S'  "+
			" and    upper(a.language_id)=upper('"+locale+"') "+
			" AND ACTION_TYPE='SD'  ) WHERE upper(description) like upper(?) and upper(code) like upper(?) ";
			title = 'Discount Reason';

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
	argumentArray[4] = "2,1";
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
		
		if(sqlSelect == '1'){
			obj.value = arr[1];
			code.value = arr[0];	
			$('#prevReasonCode').val(arr[0]);
			$('#prevReasonDesc').val(arr[1]);	
		}		
	}
else
	{
	/*obj.value = '';
	code.value = '';	*/	
		//obj.value = returnedValues[1];
		obj.value=arr[1];
			code.value=arr[0];
	} 
}

function usePreviousReason(index){
	$('#adhocReason_'+index).val($('#prevReasonCode').val());
	$('#adhocReasonName_'+index).val($('#prevReasonDesc').val());
}

async function captureDiscount(type,index){
	var noOfDecimals = $(parent.closeWinsow.document).find('#noOfDecimal').val();
	var adhoc_discount_allowed_yn = $(parent.closeWinsow.document).find('#adhoc_discount_allowed_yn').val();

	/*For Checking the Service Discount*/
	var servDiscParam = 'calledFrom=checkForServiceDiscount'+
						'&blngServCode='+$.trim($('#serv_grp_code'+index).text())+
						'&trxDocRef='+$('#trxDocRef'+index).val()+
						'&trxDocRefLineNum='+$('#trxDocRefLineNum'+index).val()	;
						
	
	/*For Checking the Service Discount*/
	var params = '../jsp/BillReceiptRecordDiscount.jsp?blngServCode='+$.trim($('#serv_grp_code'+index).text())+
				'&blngServDesc='+encodeURIComponent($.trim($('#serv_grp_desc'+index).text()))+
				'&trxDocRef='+$('#trxDocRef'+index).val()+
				'&trxDocRefLineNum='+$('#trxDocRefLineNum'+index).val()+				
				'&serviceItemCode='+$('#serviceItemCode'+index).val()+
				'&moduleId='+$('#moduleId'+index).val()+
				'&serviceItemDesc='+encodeURIComponent($('#serviceItemDesc'+index).val())+
				'&episodeType='+$('#episodeType').val()+
				'&patientId='+$('#patientId').val()+
				'&episodeId='+$('#episodeId').val()+
				'&visitId='+$('#visitId').val()+
				'&serviceDate='+$.trim($('#chargeDateTime'+index).text())+
				'&noOfDecimals='+noOfDecimals;
	if(type == 'C'){
		params += '&gross='+$.trim($('#cashTotal'+index).text())+
				'&discount='+$.trim($('#cashDisc'+index).text())+
				'&net='+$.trim($('#cashNet'+index).text())+
				'&trxDocRefSeqNum='+$('#trxDocRefSeqNumC'+index).val()+
				'&payer=';
		
		servDiscParam += '&trxDocRefSeqNum='+$('#trxDocRefSeqNumC'+index).val();		
		
		if($.trim($('#trxDocRefSeqNumC'+index).val()) == ''){
			alert(getMessage('BL00945','BL'));
			return false;
		} 
	}
	else if(type=='P1'){
		params += '&gross='+$.trim($('#payer1Total'+index).text())+
		'&discount='+$.trim($('#payer1Disc'+index).text())+
		'&net='+$.trim($('#payer1Net'+index).text())+
		'&trxDocRefSeqNum='+$('#trxDocRefSeqNumP1'+index).val()+
		'&payer='+$('#payerCode1').val();
		
		servDiscParam += '&trxDocRefSeqNum='+$('#trxDocRefSeqNumP1'+index).val();
		
		if($.trim($('#trxDocRefSeqNumP1'+index).val()) == ''){
			alert(getMessage('BL00945','BL'));
			return false;
		} 
	}
	else if(type == 'P2'){
		params += '&gross='+$.trim($('#payer2Total'+index).text())+
		'&discount='+$.trim($('#payer2Disc'+index).text())+
		'&net='+$.trim($('#payer2Net'+index).text())+
		'&trxDocRefSeqNum='+$('#trxDocRefSeqNumP2'+index).val()+
		'&payer='+$('#payerCode2').val();
		
		servDiscParam += '&trxDocRefSeqNum='+$('#trxDocRefSeqNumP2'+index).val();
		
		if($.trim($('#trxDocRefSeqNumP2'+index).val()) == ''){
			alert(getMessage('BL00945','BL'));
			return false;
		} 
	}
	else if(type == 'P3'){
		params += '&gross='+$.trim($('#payer3Total'+index).text())+
		'&discount='+$.trim($('#payer3Disc'+index).text())+
		'&net='+$.trim($('#payer3Net'+index).text())+
		'&trxDocRefSeqNum='+$('#trxDocRefSeqNumP3'+index).val()+
		'&payer='+$('#payerCode3').val();
		
		servDiscParam += '&trxDocRefSeqNum='+$('#trxDocRefSeqNumP3'+index).val();
		
		if($.trim($('#trxDocRefSeqNumP3'+index).val()) == ''){
			alert(getMessage('BL00945','BL'));
			return false;
		} 
	}
	else if(type == 'P4'){
		params += '&gross='+$.trim($('#payer4Total'+index).text())+
		'&discount='+$.trim($('#payer4Disc'+index).text())+
		'&net='+$.trim($('#payer4Net'+index).text())+
		'&trxDocRefSeqNum='+$('#trxDocRefSeqNumP4'+index).val()+
		'&payer='+$('#payerCode4').val();
		
		servDiscParam += '&trxDocRefSeqNum='+$('#trxDocRefSeqNumP4'+index).val();
		
		if($.trim($('#trxDocRefSeqNumP4'+index).val()) == ''){
			alert(getMessage('BL00945','BL'));
			return false;
		} 
	}
	else if(type == 'P5'){
		params += '&gross='+$.trim($('#payer5Total'+index).text())+
		'&discount='+$.trim($('#payer5Disc'+index).text())+
		'&net='+$.trim($('#payer5Net'+index).text())+
		'&trxDocRefSeqNum='+$('#trxDocRefSeqNumP5'+index).val()+
		'&payer='+$('#payerCode5').val();
		
		servDiscParam += '&trxDocRefSeqNum='+$('#trxDocRefSeqNumP5'+index).val();
		
		if($.trim($('#trxDocRefSeqNumP5'+index).val()) == ''){
			alert(getMessage('BL00945','BL'));
			return false;
		} 
	}
	else if(type == 'P6'){
		params += '&gross='+$.trim($('#payer6Total'+index).text())+
		'&discount='+$.trim($('#payer6Disc'+index).text())+
		'&net='+$.trim($('#payer6Net'+index).text())+
		'&trxDocRefSeqNum='+$('#trxDocRefSeqNumP6'+index).val()+
		'&payer='+$('#payerCode6').val();
		
		servDiscParam += '&trxDocRefSeqNum='+$('#trxDocRefSeqNumP6'+index).val();
		
		if($.trim($('#trxDocRefSeqNumP6'+index).val()) == ''){
			alert(getMessage('BL00945','BL'));
			return false;
		} 
	}
	else if(type == 'P7'){
		params += '&gross='+$.trim($('#payer7Total'+index).text())+
		'&discount='+$.trim($('#payer7Disc'+index).text())+
		'&net='+$.trim($('#payer7Net'+index).text())+
		'&trxDocRefSeqNum='+$('#trxDocRefSeqNumP7'+index).val()+
		'&payer='+$('#payerCode7').val();
		
		servDiscParam += '&trxDocRefSeqNum='+$('#trxDocRefSeqNumP7'+index).val();
		
		if($.trim($('#trxDocRefSeqNumP7'+index).val()) == ''){
			alert(getMessage('BL00945','BL'));
			return false;
		} 
	}
	
	/*For Checking the Service Discount*/
	var allowedYn = 'N';
	$.ajax({
		type:"GET",
		url:"../jsp/BillReceiptAjax.jsp",
		data:servDiscParam,
		dataType:"text",
		async:false,
		success: function(data){
			allowedYn = $.trim(data);
		},
		 error: function(data){
			 alert(data)
	      }
	});
	if(allowedYn == 'N'){
		alert(getMessage('BL00944','BL'));
		return false;
	}
	else if(allowedYn == 'C'){
		alert(getMessage('BL00946','BL'));
		return false;
	}
	else if(allowedYn == 'P'){
		alert(getMessage('BL00957','BL'));
		
		return false;
	}
	else if(allowedYn == 'X'){
		alert(getMessage('BL00958','BL'));
		
		return false;
	}
	else if(allowedYn == 'A'){
		alert(getMessage('BL0046','BL'));
		
		return false;
	}
	/*For Checking the Service Discount*/
	var dialogHeight= "250px" ;
	var dialogWidth	= "700px" ;   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status: " + status + "; scroll=auto; center:yes";
	var popupWindow =await window.showModalDialog(params,null,features);
	
	if(popupWindow != undefined && popupWindow != 'popupWindow'){
		var data = popupWindow.split(":::");	
		
		if(type == 'C'){
			$('#cashDisc'+index).html(data[0]);
			$('#cashNet'+index).html(data[1]);
			
			putDecimal_Text($('#cashDisc'+index),17,noOfDecimals);
			putDecimal_Text($('#cashNet'+index),17,noOfDecimals);			
		}
		else if(type == 'P1'){
			$('#payer1Disc'+index).html(data[0]);
			$('#payer1Net'+index).html(data[1]);
			
			putDecimal_Text($('#payer1Disc'+index),17,noOfDecimals);
			putDecimal_Text($('#payer1Net'+index),17,noOfDecimals);			
		}
		else if(type == 'P2'){
			$('#payer2Disc'+index).html(data[0]);
			$('#payer2Net'+index).html(data[1]);
			
			putDecimal_Text($('#payer2Disc'+index),17,noOfDecimals);
			putDecimal_Text($('#payer2Net'+index),17,noOfDecimals);
		}
		else if(type == 'P3'){
			$('#payer3Disc'+index).html(data[0]);
			$('#payer3Net'+index).html(data[1]);
			
			putDecimal_Text($('#payer3Disc'+index),17,noOfDecimals);
			putDecimal_Text($('#payer3Net'+index),17,noOfDecimals);
		}
		else if(type == 'P4'){
			$('#payer4Disc'+index).html(data[0]);
			$('#payer4Net'+index).html(data[1]);
			
			putDecimal_Text($('#payer4Disc'+index),17,noOfDecimals);
			putDecimal_Text($('#payer4Net'+index),17,noOfDecimals);
		}
		else if(type == 'P5'){
			$('#payer5Disc'+index).html(data[0]);
			$('#payer5Net'+index).html(data[1]);
			
			putDecimal_Text($('#payer5Disc'+index),17,noOfDecimals);
			putDecimal_Text($('#payer5Net'+index),17,noOfDecimals);
		}
		else if(type == 'P6'){
			$('#payer6Disc'+index).html(data[0]);
			$('#payer6Net'+index).html(data[1]);
			
			putDecimal_Text($('#payer6Disc'+index),17,noOfDecimals);
			putDecimal_Text($('#payer6Net'+index),17,noOfDecimals);
		}
		else if(type == 'P7'){
			$('#payer7Disc'+index).html(data[0]);
			$('#payer7Net'+index).html(data[1]);
			
			putDecimal_Text($('#payer7Disc'+index),17,noOfDecimals);
			putDecimal_Text($('#payer7Net'+index),17,noOfDecimals);
		}
		$(parent.closeWinsow.document).find('#hdnRefresh').val('Y');
		$(parent.closeWinsow.document).find('#hdnDiscRefresh').val('Y');
		
		var commonDisc = 0;
		var commonNet = 0;
		commonDisc = parseFloat(commonDisc) + parseFloat($('#cashDisc'+index).text());
		commonNet = parseFloat(commonNet) + parseFloat($('#cashNet'+index).text());
		for(var i=1;i<=7;i++){
			commonDisc = parseFloat(commonDisc) + parseFloat($('#payer'+i+'Disc'+index).text());
			commonNet = parseFloat(commonNet) + parseFloat($('#payer'+i+'Net'+index).text());
		}
		
		$('#disc_amt'+index).html(commonDisc);
		$('#net_amt'+index).html(commonNet);
		putDecimal_Text($('#disc_amt'+index),17,noOfDecimals);
		putDecimal_Text($('#net_amt'+index),17,noOfDecimals);
		
	}
		
}

function checkAlpha(event){
	var strCheck = '1234567890.';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  
	if (strCheck.indexOf(key) == -1) return false;  
	return true ;
}
function checkAlpha1(event){
	var strCheck = '1234567890.-';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  
	if (strCheck.indexOf(key) == -1) return false;  
	return true ;
}



async function validate(){
	var adhoc_user_id = document.forms[0].adhoc_user_id.value;
	
	if($('#actGrossAmt').val() == 0){
		  alert(getMessage("BL6281", "BL"));  		
		  return false;
	}
	if($('#adhoc_user_id').val() == ""){
		  alert(getMessage("BL9112", "BL"));  		
		  return false;
	}
	if($('#user_password').val() == ""){
		  alert(getMessage("BL9113", "BL"));  		
		  return false;
	}
	
	if($('#discountPer').val() == '' || $('#discountAmt').val() == ''){
		alert(getMessage("BL00956", "BL"));
		return false;
	}
	
	if($('#discountCode').val() == ''){
		alert(getMessage('BL1356','BL'));
		return false;
	}
	var data = await callDiscount(adhoc_user_id);

	if(data.validUser=='Y' && data.error==''){
        var discountValues = $('#discountAmt').val() + ":::" + $('#netAfterDisc').val();

		
		window.returnValue =  $('#discountAmt').val()+":::"+$('#netAfterDisc').val();
		window.close();
	}
	/*else if(data.validUser=='N'){
		var dialogHeight= "14" ;
		var dialogWidth	= "22" ;
		var dialogTop = "225" ;
		var center = "1" ;	   
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;			

		var retVal = window.showModalDialog("../../eBL/jsp/BLFinDetailsAuthoriseMain.jsp",arguments,features);		

		
		var doAuth=true;
		if(retVal==null || retVal[3] == undefined){
			doAuth=false;
		}
		else{	
			var successfulUser=retVal[3];
			var data1 = callDiscount(successfulUser);
			if(data1.validUser=='Y' && data1.error==''){	
				window.returnValue =  $('#discountAmt').val()+":::"+$('#netAfterDisc').val();
				window.close();
			}			
			else{
				alert($.trim(data1.error));
			}
		}
	}*/
	else{
		alert($.trim(data.error));
	}
	

}

function callDiscount(discUserId){
	var data1;
	var params = "calledFrom=validateDiscount"+
				"&facilityId="+$('#facilityId').val()+
				"&patientId="+$('#patientId').val()+
				"&episodeType="+$('#episodeType').val()+
				"&episodeId="+$('#episodeId').val()+
				"&visitId="+$('#visitId').val()+
				"&trxDocRef="+$('#trxDocRef').val()+
				"&trxDocRefLineNum="+$('#trxDocRefLineNum').val()+
				"&trxDocRefSeqNum="+$('#trxDocRefSeqNum').val()+
				"&blngServCode="+$('#blngServCode').val()+
				"&serviceDate="+$('#serviceDate').val()+
				"&serviceItemCode="+$('#serviceItemCode').val()+
				"&moduleId="+$('#moduleId').val()+
				
				"&payer="+$('#payer').val()+
				"&discountCode="+$('#discountCode').val()+
				"&discountDesc="+encodeURIComponent($('#discountDesc').val())+
				"&gross="+$.trim($('#gross').text())+
				"&discountPer="+$('#discountPer').val()+
				"&discountAmt="+$('#discountAmt').val()+
				"&netAfterDisc="+$('#netAfterDisc').val()+
				"&discUserId="+discUserId;
	
	if($('#usePrevious').prop('checked')){
		params += "&usePrevious=Y";
	}
	else{
		params += "&usePrevious=N";
	}
	
	if($('#makeDefault').prop('checked')){
		params += "&makeDefault=Y";
	}
	else{
		params += "&makeDefault=N";
	}
	$.ajax({
		type:"GET",
		url:"../jsp/BillReceiptAjax.jsp",
		data:params,
		dataType:"json",
		async:false,
		success: function(data){
			data1 = data;
		},
		 error: function(data){
			 alert(data)
	      }
	});
	
	return data1;
}

async function packageClosure(){
	$(parent.BillReceiptTab.document).find('#pkgAlrdPop').val('Y');
	var noOfDecimal = $(parent.BillReceiptTab.document).find('#noOfDecimal').val();
	var dialogHeight= "42vh" ;
	var dialogWidth	= "60vw" ;   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status: " + status + "; scroll=auto; center:yes";
	var pDoc = parent.BillReceiptExisOrderSearch.document;
	var exisOrderDoc = parent.BillReceiptExisOrderDetails.document;
	if($(parent.BillReceiptInfo.document).find('#ipBillType').val()!='I'){
		var params = "../../eBL/jsp/BillReceiptPkgClosure.jsp?patient_id="+$(pDoc).find('#patient_id').val()+
					"&episode_type="+$(pDoc).find('#episode_type').val()+
					"&episode_id="+$(pDoc).find('#episode_id').val()+
					"&visit_id="+$(pDoc).find('#visit_id').val()+"&totalGroup="+$(parent.BillReceiptExisOrderDetails.document).find('#totalGroup').val()+"&noOfDecimal="+noOfDecimal;
		var popupWindow =await top.window.showModalDialog(params,null,features); 
		
		
		while(popupWindow == undefined || popupWindow == 'undefined'){
	        popupWindow = await window.showModalDialog(params,null,features); 
	      
	     } 
		if(popupWindow != 'undefined' && popupWindow != undefined){
			if(popupWindow != 'N'){
				var retVal = trimString(popupWindow).split("::");
				var totalCount=retVal[0];
				var pkgSeqNo=retVal[1];
				var packageCode=retVal[2];
				$(parent.BillReceiptTab.document).find('#pkgSeqNo').val(pkgSeqNo);
				$(parent.BillReceiptTab.document).find('#totalCount').val(totalCount);
				$(parent.BillReceiptTab.document).find('#packageCode').val(packageCode);
				$(parent.BillReceiptTab.document).find('#pkgClosedYn').val('Y');				
			}
			else{				
				$(parent.BillReceiptTab.document).find('#pkgClosedYn').val('N');
			}			
		}
	}
}

/*function computeBedCharge(){
	params = 'calledFrom=bedComputeYorN'+
			'&patientId='+$('#patient_id').val()+
			'&episodeId='+$('#episode_id').val()+
			'&visitId='+$('#visit_id').val()+
			'&episodeType='+$('#episode_type').val()+
			'&lastBedChargeDt='+$('#lastBedChargeDt').val()+
			'&computeUptoDt='+$('#computeUptoDt').val();
	$.ajax({
		type:"GET",
		url:"../jsp/BillReceiptAjax.jsp",
		data:params,
		dataType:"text",
		async:false,
		success: function(data){
			if($.trim(data) == 'Y'){
				bedComputationAlert();
			}
		},
		 error: function(data){
			 alert(data)
	      }
	});
}*/

// function computeBedCharge(){
// 	//alert($(parent.BillReceiptInfo.docuemnt).find('#computeUptoDt').val());
// 	//alert($(parent.BillReceiptInfo.document).find('#computeUptoDt').val());
// 	params = 'calledFrom=bedComputeAlert'+
// 			'&patientId='+$('#patient_id').val()+
// 			'&episodeId='+$('#episode_id').val()+
// 			'&visitId='+$('#visit_id').val()+
// 			'&episodeType='+$('#episode_type').val()+
// 			'&lastBedChargeDt='+$('#lastBedChargeDt').val()+
// 			'&encounterId='+$('#encounter_id').val();
// 	var suppressDischarge = 'Y';

// 	$.ajax({
// 		type:"GET",
// 		url:"../jsp/BillReceiptAjax.jsp",
// 		data:params,
// 		dataType:"json",
// 		async:false,  
// 		success: function(data){
// 			if(data.Success == 'Y'){
// 				if(data.alertMess != ''){
// 					callBedExemption(data.alertMess,data.exemptMessage,data.supDischargeDay,suppressDischarge);
// 				}				
// 			}
// 			else{
// 				alert(data.messageId);
// 			}
// 		},
// 		 error: function(data){
// 			 alert(data)
// 	      }
// 	});
// }

async function computeBedCharge() {
    try {
        // Gather all the parameters for the GET request
        const params = 'calledFrom=bedComputeAlert' +
            '&patientId=' + $('#patient_id').val() +
            '&episodeId=' + $('#episode_id').val() +
            '&visitId=' + $('#visit_id').val() +
            '&episodeType=' + $('#episode_type').val() +
            '&lastBedChargeDt=' + $('#lastBedChargeDt').val() +
            '&encounterId=' + $('#encounter_id').val();
        
        const suppressDischarge = 'Y';

        // Make the AJAX request and await the response
        const data = await $.ajax({
            type: "GET",
            url: "../jsp/BillReceiptAjax.jsp",
            data: params,
            dataType: "json",
            async: false
        });

        if (data.Success === 'Y') {
            if (data.alertMess !== '') {
                // Call the exemption function and wait for it to finish before continuing
                await callBedExemption(data.alertMess, data.exemptMessage, data.supDischargeDay, suppressDischarge);
            }
        } else {
            alert(data.messageId);
        }
    } catch (error) {
        alert(error);
    }
}


async function callBedExemption(alertMess,exemptMessage,supDischargeDay,suppressDischarge){
	alert(alertMess);
	if(supDischargeDay == 'Y'){

		var dialogHeight= "6" ;
	    var dialogWidth	= "20" ;
		var dialogTop = "225" ;
		var center = "1" ;	   
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;	
		var params = "../jsp/BLBedExemptionMessage.jsp?exemptMessage="+exemptMessage;
		var retVal = await window.showModalDialog(params,null,features);  
				
				
					if(retVal == "N"){											
						suppressDischarge = 'N';
					}else{
						suppressDischarge = 'Y';
					}
	}
	bedComputeMain(suppressDischarge);
				}				
			}
			else{
				alert(data.messageId);
			}
		},
		 error: function(data){
			 alert(data)
	      }
	});
}
async function callUnprocessedBill(){ //TH-KW-CRF-0092/V230127
	
	try{
	var params = '&patientId='+$('#patient_id').val()+
		'&episodeId='+$('#episode_id').val()+'&episode_type='+$('#episode_type').val()+'&visit_id='+$('#visit_id').val();//230606

		const data = await $.ajax({
			type:"GET",
			url:"../jsp/BillReceiptAjax.jsp",
			data:'calledFrom=callUnprocessedBill'+params,
			dataType:"json",
            async: false
        });

		if(data.Success == 'Y'){
			if(data.isValid == 'Y'){
					var dialogHeight= "6" ;
					var dialogWidth	= "20" ;
					var dialogTop = "225" ;
					var center = "1" ;	  
					var status="no";
					var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
					var arguments	= "" ;	
					
					//var params = "../jsp/BLBedExemptionMessage.jsp?exemptMessage="+(getMessage("BL0963","BLEXT"));
				//	var msg="Unbilled charges exist for previous encounter - Do you want to generate bill";
					var msg=getMessage("BL0975","BLEXT");
					var param = "../jsp/AlertYesNo.jsp?message="+msg;
					var retVal = await window.showModalDialog(param,null,features);  
					
					if(retVal == "1"){
						params+="&oldEncid="+data.encontID+"&billGenOpt="+$(parent.BillReceiptInfo.document).find('#billGenOpt').val()+
						"&cntrUserShift="+$(parent.BillReceiptInfo.document).find('#cntrUserShift').val()+"&cntrUserName="+$(parent.BillReceiptInfo.document).find('#cntrUserName').val()+"&pkgSeqNo="+$(parent.BillReceiptTab.document).find('#pkgSeqNo').val();
						
						$.ajax({
								type:"GET",
								url:"../jsp/BillReceiptAjax.jsp",
								data:'calledFrom=generateUnprocBill'+params,
								dataType:"text",
								async:false,  
								success: function(data){
									},
								error: function(data){
								 alert(data)
								}
							});
						}else{
							return false;
						}
					}
		}else {
            alert(data.messageId);
        }


	}catch (error) {
        alert(error);
    }
}

function bedComputeMain(suppressDischarge){
	//alert($(parent.BillReceiptInfo.docuemnt))
	//alert($(parent.BillReceiptInfo.docuemnt).find('#computeUptoDt').val());
	var pDoc = parent.BillReceiptInfo.document;
	params = 'calledFrom=bedComputeMain'+
	'&patientId='+$('#patient_id').val()+
	'&episodeId='+$('#episode_id').val()+
	'&visitId='+$('#visit_id').val()+
	'&episodeType='+$('#episode_type').val()+
	'&lastBedChargeDt='+$(parent.BillReceiptInfo.document).find('#lastBedChargeDt').val()+
	'&computeUptoDt='+$.trim($(parent.BillReceiptInfo.document).find('#computeUptoDt').text())+
	'&encounterId='+$('#encounter_id').val()+
	'&ipChkOutBasisInd='+$(parent.BillReceiptTab.document).find('#ipChkOutBasisInd').val()+
	'&suppressDischarge='+suppressDischarge;

	$.ajax({
		type:"GET",
		url:"../jsp/BillReceiptAjax.jsp",
		data:params,
		dataType:"text",
		async:false,
		success: function(data){
			if($.trim(data) == ''){
				alert(getMessage("BL00962", "BL"));
				$(pDoc).find('#trLastBedChargeDt').hide();
				$(pDoc).find('#trComputeUptoDt').hide();
			}
			else{
				alert($.trim(data));
			}
		},
		 error: function(data){
			 alert(data)
	      }
	});
}

function fnClearCode(obj){
	obj.value = '';
}

function checkAlways(obj){
	$('#pkgSelect'+obj).attr('checked','checked');
}
function checkUncheck(obj){
	
	var facilityId	= document.getElementById("facilityId").value;
	var patient_id  = document.getElementById("patientId").value;
	var total_records = document.getElementById("total_records").value;
	var bool =true ;
	
	var params='';
		if($(parent.BillReceiptExisOrderDetails.document).find('#billSelect'+obj).prop('checked')){
			 var pDoc = parent.BillReceiptExisOrderDetails.document;
			 if($.trim($(pDoc).find('#episode_type'+obj).text())=="Outpatient" ||$.trim($(pDoc).find('#episode_type'+obj).text())=="Inpatient"||$.trim($(pDoc).find('#episode_type'+obj).text())=="Daycare"||$.trim($(pDoc).find('#episode_type'+obj).text())=="Emergency")
				 {
				 var episodeType = $.trim($(pDoc).find('#episode_type'+obj).text());
				     result = episodeType.substring(0,1);
				   
				 }
			 else if($.trim($(pDoc).find('#episode_type'+obj).text())=="External"){
				 result='R';
			 }
			
		
			 params+="&episode_type="+result;
			 params+="&episode_id="+$(parent.BillReceiptExisOrderDetails.document).find('#episode_id'+obj).text();
			 params+="&visit_id="+$(parent.BillReceiptExisOrderDetails.document).find('#visit_id'+obj).text();
			params+="&facilityId="+facilityId;
		 }



	var totSetAmt = 0;
	 var negative = 'N';

	for(var i=1 ; i<total_records;i++)
		 
	{
	 if($(parent.BillReceiptExisOrderDetails.document).find('#billSelect'+i).prop('checked')){
		 var outstandAmount=parseFloat($(parent.BillReceiptExisOrderDetails.document).find('#tdOutStdAmt_'+i).text());
		 if(outstandAmount <0){
			 negative = 'Y';
			 
		 }
		} 
	}
	
	 if(negative=='Y')
	  { 
		  $.ajax({ 
			  async:false, type:"POST",
			  url:"../jsp/BLRefundValidation.jsp",
			  data:"&patientId="+patient_id+"&facilityId="+facilityId,
			  dataType:"text", 
			  success: function(data){ 
				 
				  
				  var retValue= $.trim(data);
					
				  if(retValue=='Y') { 
					  bool = false; 
					  alert(getMessage('BL5201','BL'));
					  $('#billSelect'+obj).attr('checked',false);
					  return false; }
				  }, 
					  error: function(data){
					  } 
					  }); 
		  }
	if(bool){
if(params!=''){
	 $.ajax({ 
		  type:"POST",
		  url:"../jsp/BillReceiptAjax.jsp?calledFrom=specialClinicValidate",
		  data:params,
			dataType:"json",
			async:false,
		  success: function(data){ 
			  
			  if(data.errorId != ''){
					alert(getMessage(data.errorId,'BL'));
					 $('#billSelect'+obj).attr('checked',false);
					return false;
				}
			  }, 
				  error: function(data){
				  } 
				  }); 
				  }
	}
	
}

function resetSearch(){
	$('input:text').each(function(){
		$(this).val('');
	});
	$('select').each(function(){
		$(this).val('');
	});
	$('#entGrp_Line_code').val('');
	$('#entServ_Grp_code').val('');
	$('#serv_class_code').val('');
}

function putDecimal_Text(Obj,maxvalue,deci)
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
					Obj.html(temp3);
				}
				else if(temp1.length != 0 && temp1.length <= (parseInt(maxvalue) -parseInt(deci)) && temp1.length <= maxvalue)
				{
					var temp3=temp1+'.';
					for(var m=0;m<deci;m++)
					temp3+="0";
					Obj.html(temp3);
				}
				if (temp1.length == 0 )
				{
			 		temp3="0.";
					for(var m=0;m<deci;m++)
					temp3+="0";
					Obj.html(temp3);
	 
				}
   
 
			}

		}else{
			var temp5=temp1.indexOf('.');
			var temp7=temp1.substring(0,temp5);
			var tempForMinus = temp7;
			var temp6=temp1.substring(temp7.length+1,(temp7.length+parseInt(deci)+1));
			
			/*Added new Logic for Rounding*/
			var nextDigit = temp1.substring(temp7.length+1,(temp7.length+parseInt(deci)+2));

			if(nextDigit.length>temp6.length){
				var lastDigit = nextDigit.substring(deci,parseInt(deci)+1);
				if(lastDigit>=5){
					if(temp6>(Math.pow(10,deci) - 2)){
						temp7 = parseFloat(temp7)+parseFloat(1);
						temp6=0;
					}
					else{
						if(temp6.charAt(0) == '0'){
							var temp10 = parseFloat(temp6)+parseFloat(1);
							temp6 = '0'+temp10;
						}
						else{
							temp6=parseFloat(temp6)+parseFloat(1);
						}												
					}					
					
				}
			}
			/*Added new Logic for Rounding*/
			var localTemp='';
			var len=parseInt(deci)-parseInt(temp6.toString().length);
			for(var m=0;m<len;m++){
				localTemp+='0';
			}
			
			if(temp5 == 0){
				Obj.html("0."+temp6+localTemp);
			}
			else if(temp5 == 1 && tempForMinus == '-'){
				Obj.html(temp7+"0."+temp6+localTemp);
			}
			else{
				Obj.html(temp7+"."+temp6+localTemp);
			}
	
		}
	}
}

function groupChangeDecimal(type,maxPayer,noOfDecimals){
	$('[id^=gross_amt]').each(function(){
		if($.trim($(this).text() != '')){
			putDecimal_Text($(this),17,noOfDecimals);				
		}
		else{
			$(this).html('0');
			putDecimal_Text($(this),17,noOfDecimals);
		}
	});
	
	
	
	$('[id^=disc_amt]').each(function(){
		if($.trim($(this).text() != '')){
			putDecimal_Text($(this),17,noOfDecimals);				
		}
		else{
			$(this).html('0');
			putDecimal_Text($(this),17,noOfDecimals);
		}
	});
	
	$('[id^=adhoc_disc_amt]').each(function(){
		if($.trim($(this).text() != '')){
			putDecimal_Text($(this),17,noOfDecimals);				
		}
		else{
			$(this).html('0');
			putDecimal_Text($(this),17,noOfDecimals);
		}
	});
	
	$('[id^=net_amt]').each(function(){
		if($.trim($(this).text() != '')){
			putDecimal_Text($(this),17,noOfDecimals);				
		}
		else{
			$(this).html('0');
			putDecimal_Text($(this),17,noOfDecimals);
		}
	});
	
	$('[id^=cashTotal]').each(function(){
		if($.trim($(this).text() != '')){
			putDecimal_Text($(this),17,noOfDecimals);				
		}
		else{
			$(this).html('0');
			putDecimal_Text($(this),17,noOfDecimals);
		}
	});
	
	
	if(type =='G'){
	$('[id^=cashAdhocAmount]').each(function(){
		if($.trim($(this).text() != '')){
			putDecimal_Text($(this),17,noOfDecimals);				
		}
		else{
			$(this).html('0');
			putDecimal_Text($(this),17,noOfDecimals);
		}
	});
	}
	else{
	$('[id^=cashDisc]').each(function(){
		if($.trim($(this).text() != '')){
			putDecimal_Text($(this),17,noOfDecimals);				
		}
		else{
			$(this).html('0');
			putDecimal_Text($(this),17,noOfDecimals);
		}
	});	
	}
	
	
	$('[id^=cashNet]').each(function(){
		if($.trim($(this).text() != '')){
			putDecimal_Text($(this),17,noOfDecimals);				
		}
		else{
			$(this).html('0');
			putDecimal_Text($(this),17,noOfDecimals);
		}
	});
	
	/*Generic for Max Payer*/
	for(var i=1;i<=maxPayer;i++){

		$('[id^=payer'+i+'Total]').each(function(){
			if($(this).attr('roundVal') == 'Y'){
				
				if($.trim($(this).text() != '')){

					putDecimal_Text($(this),17,noOfDecimals);				
				}
				else{
					$(this).html('0');
					putDecimal_Text($(this),17,noOfDecimals);
				}
				}
		});
			
		if(type =='G'){
		$('[id^=payer'+i+'AdhocAmount]').each(function(){
			if($.trim($(this).text() != '')){
				putDecimal_Text($(this),17,noOfDecimals);				
			}
			else{
				$(this).html('0');
				putDecimal_Text($(this),17,noOfDecimals);
			}
		});
		}
		else{
			$('[id^=payer'+i+'Disc]').each(function(){
				if($(this).attr('roundVal') == 'Y'){					
					if($.trim($(this).text() != '')){
						putDecimal_Text($(this),17,noOfDecimals);				
					}
					else{
						$(this).html('0');
						putDecimal_Text($(this),17,noOfDecimals);
					}
				}
			});	
		}
		
		$('[id^=payer'+i+'Net]').each(function(){
			if($.trim($(this).text() != '')){
				putDecimal_Text($(this),17,noOfDecimals);				
			}
			else{
				$(this).html('0');
				putDecimal_Text($(this),17,noOfDecimals);
			}
		});		
	}
	/*Generic for Max Payer*/
	
	/*if(maxPayer>0){}
	
	if(maxPayer>1){
	$('[id^=payer2Total]').each(function(){
		if($(this).attr('roundVal') == 'Y'){
			
			if($.trim($(this).text() != '')){

				putDecimal_Text($(this),17,noOfDecimals);				
			}
			else{
				$(this).text('0');
				putDecimal_Text($(this),17,noOfDecimals);
			}
		}
	});
	
	if(type =='G'){
	$('[id^=payer2AdhocAmount]').each(function(){
		if($.trim($(this).text() != '')){
			putDecimal_Text($(this),17,noOfDecimals);				
		}
		else{
			$(this).text('0');
			putDecimal_Text($(this),17,noOfDecimals);
		}
	});
	}
	else{
		$('[id^=payer2Disc]').each(function(){
			if($(this).attr('roundVal') == 'Y'){
				
				if($.trim($(this).text() != '')){

					putDecimal_Text($(this),17,noOfDecimals);				
				}
				else{
					$(this).text('0');
					putDecimal_Text($(this),17,noOfDecimals);
				}
			}
		});	
	}
	
	$('[id^=payer2Net]').each(function(){
		if($.trim($(this).text() != '')){
			putDecimal_Text($(this),17,noOfDecimals);				
		}
		else{
			$(this).text('0');
			putDecimal_Text($(this),17,noOfDecimals);
		}
	});
	}	
	
	if(maxPayer>2){
	$('[id^=payer3Total]').each(function(){
		if($(this).attr('roundVal') == 'Y'){
		
		if($.trim($(this).text() != '')){

			putDecimal_Text($(this),17,noOfDecimals);				
		}
		else{
			$(this).text('0');
			putDecimal_Text($(this),17,noOfDecimals);
		}
		}
	});
	
	if(type =='G'){
	$('[id^=payer3AdhocAmount]').each(function(){
		if($.trim($(this).text() != '')){
			putDecimal_Text($(this),17,noOfDecimals);				
		}
		else{
			$(this).text('0');
			putDecimal_Text($(this),17,noOfDecimals);
		}
	});
	}
	else{
		$('[id^=payer3Disc]').each(function(){
			if($(this).attr('roundVal') == 'Y'){
				
				if($.trim($(this).text() != '')){

					putDecimal_Text($(this),17,noOfDecimals);				
				}
				else{
					$(this).text('0');
					putDecimal_Text($(this),17,noOfDecimals);
				}
			}
		});	
	}
	
	$('[id^=payer3Net]').each(function(){
		if($.trim($(this).text() != '')){
			putDecimal_Text($(this),17,noOfDecimals);				
		}
		else{
			$(this).text('0');
			putDecimal_Text($(this),17,noOfDecimals);
		}
	});
	}
	
	if(maxPayer>3){
	$('[id^=payer4Total]').each(function(){
		if($(this).attr('roundVal') == 'Y'){
			
			if($.trim($(this).text() != '')){

				putDecimal_Text($(this),17,noOfDecimals);				
			}
			else{
				$(this).text('0');
				putDecimal_Text($(this),17,noOfDecimals);
			}
			}
	});
	
	if(type =='G'){
	$('[id^=payer4AdhocAmount]').each(function(){
		if($.trim($(this).text() != '')){
			putDecimal_Text($(this),17,noOfDecimals);				
		}
		else{
			$(this).text('0');
			putDecimal_Text($(this),17,noOfDecimals);
		}
	});
	}
	else{
		$('[id^=payer4Disc]').each(function(){
			if($(this).attr('roundVal') == 'Y'){
				
				if($.trim($(this).text() != '')){

					putDecimal_Text($(this),17,noOfDecimals);				
				}
				else{
					$(this).text('0');
					putDecimal_Text($(this),17,noOfDecimals);
				}
			}
		});	
	}
	
	$('[id^=payer4Net]').each(function(){
		if($.trim($(this).text() != '')){
			putDecimal_Text($(this),17,noOfDecimals);				
		}
		else{
			$(this).text('0');
			putDecimal_Text($(this),17,noOfDecimals);
		}
	});
	}
	
	if(maxPayer>4){
	$('[id^=payer5Total]').each(function(){
		if($(this).attr('roundVal') == 'Y'){
			
			if($.trim($(this).text() != '')){

				putDecimal_Text($(this),17,noOfDecimals);				
			}
			else{
				$(this).text('0');
				putDecimal_Text($(this),17,noOfDecimals);
			}
			}
	});
	
	if(type =='G'){
	$('[id^=payer5AdhocAmount]').each(function(){
		if($.trim($(this).text() != '')){
			putDecimal_Text($(this),17,noOfDecimals);				
		}
		else{
			$(this).text('0');
			putDecimal_Text($(this),17,noOfDecimals);
		}
	});
	}
	else{
		$('[id^=payer5Disc]').each(function(){
			if($(this).attr('roundVal') == 'Y'){
				
				if($.trim($(this).text() != '')){

					putDecimal_Text($(this),17,noOfDecimals);				
				}
				else{
					$(this).text('0');
					putDecimal_Text($(this),17,noOfDecimals);
				}
			}
		});	
	}
	
	$('[id^=payer5Net]').each(function(){
		if($.trim($(this).text() != '')){
			putDecimal_Text($(this),17,noOfDecimals);				
		}
		else{
			$(this).text('0');
			putDecimal_Text($(this),17,noOfDecimals);
		}
	});
	}*/
}

function calculateDiscNet(totalRows,maxPayer,noOfDecimals){
	for(var index=0;index<totalRows;index++){
		var commonDisc = 0;
		var commonNet = 0;
		commonDisc =  parseFloat($('#cashDisc'+index).text());
		commonNet =  parseFloat($('#cashNet'+index).text());
		
		for(var i=1;i<=maxPayer;i++){
			commonDisc = parseFloat(commonDisc) + parseFloat($('#payer'+i+'Disc'+index).text());
			commonNet = parseFloat(commonNet) + parseFloat($('#payer'+i+'Net'+index).text());
		}
		
		$('#disc_amt'+index).html(commonDisc);
		$('#net_amt'+index).html(commonNet);
		putDecimal_Text($('#disc_amt'+index),17,noOfDecimals);
		putDecimal_Text($('#net_amt'+index),17,noOfDecimals);
	}	
}

function slmtAmtValidate(obj){	
	var facility_id = $(parent.BillReceiptExisOrderSearch.document).find('#facility_id').val();	
	var patient_id  = $(parent.BillReceiptExisOrderSearch.document).find('#patient_id').val();
	var episode_id  = $(parent.BillReceiptExisOrderSearch.document).find('#episode_id').val();
	var visit_id    = $(parent.BillReceiptExisOrderSearch.document).find('#visit_id').val();
	var episode_type = $(parent.BillReceiptExisOrderSearch.document).find('#episode_type').val();
	var cust_amt    = $.trim($(parent.BillReceiptExisOrderSummary.document).find('#approxPayerAmt').text());
    var exempt_amt  = $(parent.BillReceiptExisOrderSummary.document).find('#exemptReq').val();
    var slmt_amt    = $(parent.BillReceiptExisOrderSummary.document).find('#slmtAmt').val();    
    var doc_amt     = $(parent.BillReceiptExisOrderSummary.document).find('#docAmt').val();
    var dep_amt     = $.trim($(parent.BillReceiptExisOrderSummary.document).find('#deposits').text());
    var cash_counter_code = $.trim($(parent.BillReceiptInfo.document).find('#cntrUserName').text()); 
    var user      = $.trim($(parent.BillReceiptInfo.document).find('#cntrUserId').text()); 
	
	var params = "facility_id="+facility_id+"&patient_id="+patient_id+
					"&episode_id="+episode_id+"&visit_id="+visit_id+
					"&episode_type="+episode_type+"&cust_amt="+cust_amt+
					"&exempt_amt="+exempt_amt+"&slmt_amt="+slmt_amt+
					"&doc_amt="+doc_amt+"&dep_amt="+dep_amt+
					"&cash_counter_code="+cash_counter_code+"&user="+user;
	$.ajax({
		type:"POST",
		url:"../jsp/BillHdrAjax.jsp?calledFrom=slmtAmtValidate",
		data:params,
		async:false,
		dataType:"json",
		success: function(data){			
			if(data.warningMsg != '' && $(parent.BillReceiptTab.document).find('#warnAlrdPop').val() == 'N'){
				try{
					alert(getMessage(data.warningMsg, "BL"));
				}
				catch(e){
					alert(data.warningMsg);
				}				
				$(parent.BillReceiptTab.document).find('#warnAlrdPop').val('Y');
			}

			if(data.errorYn == 'Y'){
				if(data.errorText != ''){
					alert(data.errorText);
				}
				if(data.errorId != ''){
					try{
						alert(getMessage(data.errorId, "BL"));
					}
					catch(e){
						alert(data.errorId);
					}					
				}
				//$(parent.BillReceiptExisOrderSummary.document).find('#slmtAmt').val(doc_amt);
				$(parent.BillReceiptExisOrderSummary.document).find('#slmtAmt').focus();
			}
		},
		error: function(data){
			alert("Error"+data)	;
			$(parent.BillReceiptExisOrderSummary.document).find('#slmtAmt').val(data.slmtAmt);
	     }
	});
	var noOfDecimals = $(parent.BillReceiptTab.document).find('#noOfDecimal').val();
	putDecimal($('#slmtAmt').get(0),17,noOfDecimals);	
}

function chkSlmtValidationBillGen(){
  var facility_id = $(parent.BillReceiptExisOrderSearch.document).find('#facility_id').val();	
  var patient_id  = $(parent.BillReceiptExisOrderSearch.document).find('#patient_id').val();
  var episode_id  = $(parent.BillReceiptExisOrderSearch.document).find('#episode_id').val();
  var visit_id    = $(parent.BillReceiptExisOrderSearch.document).find('#visit_id').val();
  var episode_type = $(parent.BillReceiptExisOrderSearch.document).find('#episode_type').val();
  var cust_amt    = $.trim($(parent.BillReceiptExisOrderSummary.document).find('#approxPayerAmt').text());
  var exempt_amt  = $(parent.BillReceiptExisOrderSummary.document).find('#exemptReq').val();
  var slmt_amt    = $(parent.BillReceiptExisOrderSummary.document).find('#slmtAmt').val();    
  var doc_amt     = $(parent.BillReceiptExisOrderSummary.document).find('#docAmt').val();
  var dep_amt     = $.trim($(parent.BillReceiptExisOrderSummary.document).find('#deposits').text());
  var cash_counter_code = $.trim($(parent.BillReceiptInfo.document).find('#cntrUserName').text()); 
  var user      = $.trim($(parent.BillReceiptInfo.document).find('#cntrUserId').text()); 
  var params = "facility_id="+facility_id+"&patient_id="+patient_id+
					"&episode_id="+episode_id+"&visit_id="+visit_id+
					"&episode_type="+episode_type+"&cust_amt="+cust_amt+
					"&exempt_amt="+exempt_amt+"&slmt_amt="+slmt_amt+
					"&doc_amt="+doc_amt+"&dep_amt="+dep_amt+
					"&cash_counter_code="+cash_counter_code+"&user="+user;
	var status = true;
	$.ajax({
		type:"POST",
		url:"../jsp/BillHdrAjax.jsp?calledFrom=slmtAmtValidate",
		data:params,
		async:false,
		dataType:"json",
		success: function(data){	
			
			var exisOrderDoc = parent.BillReceiptExisOrderDetails.document;			
			if(data.errorYn == 'Y'){
				status = false;
				$(exisOrderDoc).find('#slmtErrorCheck').val('Y');
				if(data.errorText != ''){
					$(exisOrderDoc).find('#slmtError').val(data.errorText); 
				}
				if(data.errorId != ''){
					try{
						$(exisOrderDoc).find('#slmtError').val(getMessage(data.errorId, "BL")); 
					}
					catch(e){
						$(exisOrderDoc).find('#slmtError').val(data.errorId); 
					}
					
				}
				alert($(exisOrderDoc).find('#slmtError').val());	
			}
			
			if(status){ //V231116
				if(data.warningMsg != '' &&  data.warningMsg!=undefined && data.warningMsg!=null){
					try{
						$(exisOrderDoc).find('#slmtWarning').val(getMessage(data.warningMsg, "BL"));
					}
					catch(e){
						$(exisOrderDoc).find('#slmtWarning').val(data.warningMsg);
					}
					alert($(exisOrderDoc).find('#slmtWarning').val());				
				}
			}			
		},
		error: function(data){
				
	     }
	});
	return status;
}

function trimString(sInString) {
	  return sInString.replace(/^\s+|\s+$/g,"");
}

async function exemptReqValidate(obj){
	var noOfDecimals = $(parent.BillReceiptTab.document).find('#noOfDecimal').val();
	var facility_id = $(parent.BillReceiptExisOrderSearch.document).find('#facility_id').val();	
    var doc_amt         = $(parent.BillReceiptExisOrderSummary.document).find('#slmtAmt').val();
    var slmt_amt    = $(parent.BillReceiptExisOrderSummary.document).find('#slmtAmt').val();    
    var exempt_amt  = $(parent.BillReceiptExisOrderSummary.document).find('#exemptReq').val();
    var user      = $.trim($(parent.BillReceiptInfo.document).find('#cntrUserId').text());
    var patient_id  = $(parent.BillReceiptExisOrderSearch.document).find('#patient_id').val();
	var episode_id  = $(parent.BillReceiptExisOrderSearch.document).find('#episode_id').val();
	var visit_id    = $(parent.BillReceiptExisOrderSearch.document).find('#visit_id').val();
	var episode_type = $(parent.BillReceiptExisOrderSearch.document).find('#episode_type').val();
	var cust_amt    = $.trim($(parent.BillReceiptExisOrderSummary.document).find('#approxPayerAmt').text());
	 var dep_amt     = $.trim($(parent.BillReceiptExisOrderSummary.document).find('#deposits').text());
	 var cash_counter_code = $.trim($(parent.BillReceiptInfo.document).find('#cntrUserName').text()); 
	 putDecimal($('#exemptReq').get(0),17,noOfDecimals);	
    var pDoc = parent.BillReceiptExisOrderSearch.document;
	var locale	= pDoc.getElementById("locale").value;
	var exemptType="";
	var assignTo="";
    var dialogHeight= "6" ;
	var dialogWidth	= "23" ;
	var dialogTop = "225" ;
	var center = "" ;	   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + ";  status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var param="&user="+ user+"&locale="+locale+"&facility_id="+facility_id+"&exempt_amt="+exempt_amt;
	var count=$(parent.BillReceiptTab.document).find('#count').val();
	if(count== 0){
		alert(getMessage("BL1372", "BL"));
		return false;
	}
	
	var retVal = await window.showModalDialog("../../eBL/jsp/BillReceiptExemptValidation.jsp?"+param,null,features);
	if(retVal !=null && retVal!= "null" && retVal !='undefined'){
		exemptType=retVal[1];
		assignTo=retVal[0];
		
		$(parent.BillReceiptInfo.document).find('#exemptType').val(exemptType);
		$(parent.BillReceiptInfo.document).find('#assignTo').val(assignTo);
		$(parent.BillReceiptInfo.document).find('#exemptAmt').val(exempt_amt);		
		}
		else{
			return false;
		}	

	$.ajax({
		type:"POST",
		url:"../jsp/BillHdrAjax.jsp?calledFrom=exemptReqValidate&&facility_id="+facility_id+"&exempt_amt="+exempt_amt+"&slmt_amt="+slmt_amt+"&doc_amt="+doc_amt+"&user="+user+"&locale="+locale+"&exemptType="+exemptType+"&patient_id="+patient_id+
		"&episode_id="+episode_id+"&visit_id="+visit_id+
		"&episode_type="+episode_type+"&cust_amt="+cust_amt+"&dep_amt="+dep_amt+
		"&cash_counter_code="+cash_counter_code,		
		async:false,
		dataType:"json",
		success: function(data){
			
			if(data.errorYn == 'Y'){
				if(data.errorText != ''){
					alert(data.errorText);
				}
				if(data.errorId != ''){
					try{
						alert(getMessage(data.errorId, "BL"));
					}
					catch(e){
						alert(data.errorId);
					}					
				}				
				
		 $(parent.BillReceiptExisOrderSummary.document).find('#exemptReq').val("0.00");
			putDecimal($('#exemptReq').get(0),17,noOfDecimals);
			}

		/*	var dataArr =trimString(data).split(":");
			alert(dataArr);
			alert(dataArr[2]);
			if(dataArr[0]=='N'){
				if(dataArr[1]!=""){
				 alert(getMessage(dataArr[1], "BL")); 
				 $(parent.BillReceiptExisOrderSummary.document).find('#exemptReq').val("0.00");
				}else if(dataArr[2]!=""){
					alert(dataArr[2]);
					$(parent.BillReceiptExisOrderSummary.document).find('#exemptReq').val("0.00");
				}
			}*/
			if(data.errorYn == 'N'){
			$(parent.BillReceiptExisOrderSummary.document).find('#slmtAmt').val(data.slmtAmt);
			putDecimal($('#slmtAmt').get(0),17,noOfDecimals);	
			}
		},
		error: function(data){
			alert("Error"+data);
	     }
	});
}

//V210503 Starts
function selectallexclude(idx){
	var index = idx;
	var i;
	if(document.getElementById('selectall').checked){
		for(i=0;i<index;i++){
			$('#serv_grp_chk'+i).prop('checked','checked')	
			chkExcludeServValidate(i);
		}
	}else{
		for(i=0;i<index;i++){
			$('#serv_grp_chk'+i).prop('checked','')	
		}
	}
}
//V210503 Ends

function chkExcludeServValidate(indx){
	var facility_id = $('#facility_id').val();
	var patientId  = $('#patientId').val();
	var episodeType = $('#episodeType').val();
	var episodeId   = $('#episodeId').val();
	var visitId    = $('#visitId').val();
	var trxDocRef = $('#trxDocRef'+indx).val();
	var trxDocRefLineNum = $('#trxDocRefLineNum'+indx).val();
	var serv_grp_chk ="";
	if($('#serv_grp_chk'+indx).prop('checked')){
		serv_grp_chk = 'Y';
	}else{
		serv_grp_chk = 'N';	
	}
	
	var pkgClosedYn = $(parent.closeWinsow.document).find('#pkgClosedYn').val();
	var billCashBlngServSeparately = $('#billCashBlngServSeparately').val();
	var params = "calledFrom=chkExcludeServValidate"+
					"&facility_id="+facility_id+"&patient_id="+patientId+
					"&episode_type="+episodeType+"&episode_id="+episodeId+"&visit_id="+visitId+
					"&trxDocRef="+trxDocRef+"&trxDocRefLineNum="+trxDocRefLineNum+
					"&serv_grp_chk="+serv_grp_chk+
					"&billCashBlngServSeparately="+billCashBlngServSeparately+
					"&pkgClosedYn="+pkgClosedYn;
	$.ajax({
		type:"POST",
		url:"../jsp/BillHdrAjax.jsp",
		data:params,
		async:false,
		dataType:"json",
		success: function(data){

			if(data.allowYn == 'N'){
				if(data.errorId != ''){
					alert(getMessage(data.errorId, "BL")); 				
				}else if(data.errorText != ''){
					alert(data.errorText);
				}
				
				if(serv_grp_chk == 'Y'){
					$('#serv_grp_chk'+indx).prop('checked','');
				}
				else{
					$('#serv_grp_chk'+indx).prop('checked','checked');
				}
			}
			else{
				$(parent.closeWinsow.document).find('#hdnRefresh').val('Y');
			}
		},
		error: function(data){
			$(parent.closeWinsow.document).find('#hdnRefresh').val('Y');
	     }
	});
}
async function additionalId(desc,code,codeDesc)
{
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	var title="Additional Id Proof";	
	var sql='';		
	sql = "select description,code from (SELECT NVL (a.short_desc, a.long_desc) description,a.alt_id_type code  " + 
			"FROM mp_alternate_id_type_lang_vw a WHERE  a.eff_status = 'E' and  UPPER (language_id) = UPPER ('en')  UNION SELECT decode(ACCEPT_NATIONAL_ID_NO_YN,'Y',NAT_ID_PROMPT,'') description,'****' code FROM MP_PARAM ) where upper(description) like upper(?)  and upper(code) like upper(?) ORDER BY 1"
	
	argumentArray[0]	= sql;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	
	if(codeDesc == '1'){		
		argumentArray[4] = "1,2";
		argumentArray[5] = code.value;
		argumentArray[6] = CODE_LINK;
		argumentArray[7] = DESC_CODE;
	}
	else if(codeDesc == '2'){		
		argumentArray[4] = "2,1";
		argumentArray[5] = desc.value;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;
	} 
		var retVal =await CommonLookup(title, argumentArray);	
		var ret1=unescape(retVal);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) 
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		}

	 	if(retVal != null && retVal != ""){   	
			code.value= arr[0];
			desc.value= arr[1];						
		}else{   		
			code.value= arr[1];
			desc.value= arr[0];			
		}

		
		/*if(retVal != null && retVal != ""){   	
			code.value= retVal[0];
			desc.value= retVal[1];						
		}else{   		
			code.value= retVal[1];
			desc.value= retVal[0];			
		}*/	
}

async function fnUnBillServReq(indx){
	//alert("2874 fnUnBillServReq");
	var dialogHeight= "80vh" ;//40
	var dialogWidth	= "96vw" ;   //80
	var status="no";
    var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status: " + status + "; scroll=auto; center:yes";
    var arguments = "" ;    
	var facilityId = $('#facilityId').val();
	var episode_id   = $.trim($('#episode_id'+indx).text());
	var visit_id   = $('#visit_id'+indx).text();	
	var episode_type   = $.trim($('#episode_type'+indx).text());
	 var result='';
	if(episode_type=="Outpatient" ||episode_type=="Inpatient"||episode_type=="Daycare"||episode_type=="Emergency")
	 {	 
	     result = episode_type.substring(0,1);	   
	 }
	else if(episode_type=="External"){
		result='R';	
	}

	var patient_id   = $('#patient_id').val();
	var noOfDecimals = $('#noofdeci').val();//$(parent.BillReceiptTab.document).find('#noOfDecimal').val();
	var episodeType= result;
	
	var retVal = await top.window.showModalDialog("../../eBL/jsp/BillReceiptUnbillServReqMain.jsp?episode_id="+episode_id+'&visit_id='+visit_id+'&episode_type='+episodeType+'&patient_id='+patient_id+'&noOfDecimals='+noOfDecimals,arguments,features);   
}

function putDecimal_field(Obj,maxvalue,deci)
{
	var temp1=Obj.value;
	var temp4=Obj.value.length;
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
			Obj.value=temp3;
		}
         
	else if(temp1.length <= (parseInt(maxvalue) -parseInt(deci)) && temp1.length <= maxvalue)
		{
			var temp3=temp1+'.';
			for(var m=0;m<deci;m++)
			temp3+="0";
			Obj.value=temp3;		
		}
      if (temp1.length == 0 )
		{
	 		temp3="0.";
			for(var m=0;m<deci;m++)
			temp3+="0";
			Obj.value=temp3;	 
	 } 
	 }
	}else{
		var temp5=temp1.indexOf('.');
		var temp7=temp1.substring(0,temp5);
		var tempForMinus = temp7;
		var temp6=temp1.substring(temp7.length+1,(temp7.length+parseInt(deci)+1));
		
		/*Added new Logic for Rounding*/
		var nextDigit = temp1.substring(temp7.length+1,(temp7.length+parseInt(deci)+2));

		if(nextDigit.length>temp6.length){
			var lastDigit = nextDigit.substring(deci,parseInt(deci)+1);
			if(lastDigit>=5){
				if(temp6>(Math.pow(10,deci) - 2)){
					temp7 = parseFloat(temp7)+parseFloat(1);
					temp6=0;
				}
				else{
					if(temp6.charAt(0) == '0'){
						var temp10 = parseFloat(temp6)+parseFloat(1);
						temp6 = '0'+temp10;
					}
					else{
						temp6=parseFloat(temp6)+parseFloat(1);
					}												
				}				
			}
		}
		/*Added new Logic for Rounding*/
		var localTemp='';
		var len=parseInt(deci)-parseInt(temp6.toString().length);
		for(var m=0;m<len;m++){
			localTemp+='0';
		}
		
		if(temp5 == 0){
			Obj.value="0."+temp6+localTemp;
		}
		else if(temp5 == 1 && tempForMinus == '-'){
			Obj.value=temp7+"0."+temp6+localTemp;
		}
		else{
			Obj.value=temp7+"."+temp6+localTemp;
		}	
		}
	}
}

async function insertConsolidatedBill(obj)
{	
	var params=" ";
	var facilityId	= document.getElementById("facilityId").value;
	var episodeType = '';//document.getElementById("episode_type").value;
	var total_records = document.getElementById("total_records").value;
	var encounterFacilityId = document.getElementById("encounterFacilityId").value; //V210129
	var bill_print_yn= "";
 	var docType='';
	var docNum='';	
	var patient_id  = $(parent.BillReceiptTab.document).find('#patient_id').val();
    var result='';
	 var i;
	 var count=0;
	 var totSetAmt = 0;
	//	var negative = 'N';
	 var queryString=$(parent.BillReceiptTab.document).find('#queryString').val();
	 var pDoc = parent.BillReceiptExisOrderDetails.document;
	 $(parent.BillReceiptExisOrderDetails.document).find('[id^=billSelect]').each(function(){	 
		 if($(this).prop('checked')){
			 count = count+1;
		 }	
	 });	
	 
	 if(count <=0 ){
		 alert(getMessage('BL1259','BL'));
		 return;
	 }
	 for(var i=1 ; i<total_records;i++){		
		 if($(parent.BillReceiptExisOrderDetails.document).find('#billSelect'+i).prop('checked')){
			 if(parseFloat($.trim($(parent.BillReceiptExisOrderDetails.document).find('#remSlmtAmt'+i).val()))==0)
			 {
			 	alert(getMessage('BL8012','BL'));
				return false;
			 }
			 totSetAmt=parseFloat(totSetAmt)+parseFloat($.trim($(parent.BillReceiptExisOrderDetails.document).find('#remSlmtAmt'+i).val()));					 
		 }
	 }
	 if(totSetAmt==0)
	 {
		alert(getMessage('BL8012','BL'));
		return false;
	 }
	 for(var i=1 ; i<total_records;i++){
		 if($(parent.BillReceiptExisOrderDetails.document).find('#billSelect'+i).prop('checked')){
			
			 if($.trim($(pDoc).find('#episode_type'+i).text())=="Outpatient" ||$.trim($(pDoc).find('#episode_type'+i).text())=="Inpatient"||$.trim($(pDoc).find('#episode_type'+i).text())=="Daycare"||$.trim($(pDoc).find('#episode_type'+i).text())=="Emergency")
			 {
				 episodeType = $.trim($(pDoc).find('#episode_type'+i).text());
				 result = episodeType.substring(0,1);			   
			 }
			 else if($.trim($(pDoc).find('#episode_type'+i).text())=="External"){
				 result='R';
			 }			
		
			 params+="&episode_type"+i+"="+result;
			 params+="&episode_id"+i+"="+$.trim($(parent.BillReceiptExisOrderDetails.document).find('#episode_id'+i).text());
			 params+="&visit_id"+i+"="+$.trim($(parent.BillReceiptExisOrderDetails.document).find('#visit_id'+i).text());
			 params+="&billdocDate"+i+"="+$.trim($(parent.BillReceiptExisOrderDetails.document).find('#trx_date'+i).text());
			 params+="&billdocType"+i+"="+$.trim($(parent.BillReceiptExisOrderDetails.document).find('#doc_type'+i).text());
			 params+="&billdocNum"+i+"="+$.trim($(parent.BillReceiptExisOrderDetails.document).find('#doc_num'+i).text());
			 params+="&custCode"+i+"="+$.trim($(parent.BillReceiptExisOrderDetails.document).find('#cust_code'+i).text());
			 params+="&billtotOutStdAmt"+i+"="+$.trim($(parent.BillReceiptExisOrderDetails.document).find('#tdOutStdAmt_'+i).text());
			 params+="&refundAmnt"+i+"="+$.trim($(parent.BillReceiptExisOrderDetails.document).find('#tdRfndAmt_'+i).text());
			 params+="&rem_slmt_amt"+i+"="+$.trim($(parent.BillReceiptExisOrderDetails.document).find('#remSlmtAmt'+i).val());
			 params+="&patient_id"+i+"="+$.trim($(parent.BillReceiptTab.document).find('#patient_id').val());
			 params+="&excempted_amt"+i+"="+$.trim($(parent.BillReceiptExisOrderDetails.document).find('#tdExemAmt'+i).text());
			 if($(parent.BillReceiptExisOrderDetails.document).find('#bill_print_yn'+i).prop('checked')){					
				params=params+"&bill_print_yn"+i+"=Y";					
			}
			else{
				params=params+"&bill_print_yn"+i+"=N";
			}
		 }
		 else{
			continue;
		 }		
	}
	 
	var i=1;	
	var userSlmtAmt = '';
	var docTpe='';	

	$.ajax({			
		type:"POST",
		url:"../jsp/BillOutstPersistence.jsp",
		data:" &totalRows="+total_records+"&params="+params,	
		dataType:"text",
		success:async function(data){
			
			userSlmtAmt=$.trim(data);				
			var retVal;
			var i=1;		
			
			for( i=1 ; i<total_records;i++){					  
				if($(parent.BillReceiptExisOrderDetails.document).find('#billSelect'+i).prop('checked'))
				{
					 if($.trim($(pDoc).find('#episode_type'+i).text())=="Outpatient" ||$.trim($(pDoc).find('#episode_type'+i).text())=="Inpatient"||$.trim($(pDoc).find('#episode_type'+i).text())=="Daycare"||$.trim($(pDoc).find('#episode_type'+i).text())=="Emergency")
					 {
						 episodeType = $.trim($(pDoc).find('#episode_type'+i).text());
					     result = episodeType.substring(0,1);						   
					 }
					 else if($.trim($(pDoc).find('#episode_type'+i).text())=="External"){
						 result='R';
					 }					
						
					 docType=$.trim($(parent.BillReceiptExisOrderDetails.document).find('#doc_type'+i).text());
					 docNum=$.trim($(parent.BillReceiptExisOrderDetails.document).find('#doc_num'+i).text());
					 episodeType=result;					
				 }					
			}
			const processedData = settlementData(docType, docNum, episodeType, userSlmtAmt, encounterFacilityId, queryString);
					
		},
		error: function(data){
		}
		
	});
}

async function settlementData(docType, docNum, episodeType, userSlmtAmt, encounterFacilityId, queryString){
	var center='1';
	var dialogTop = "0vh";
	var dialogHeight = "92vh" ;
	var dialogWidth = "90vw" ;
	var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;
	//var title=encodeURIComponent(title);
	var title=getLabel("eBL.BILL_SLMT_DTL.label","BL");
	title=encodeURIComponent(title);
	var arguments = "" ;
	var column_sizes = escape("");               
	var column_descriptions ="";
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+
				"&billdoctypecode="+docType+"&billdocnum="+docNum+"&"+"blnggrp="+"CASH"+
				"&episode_type="+episodeType+"&userSlmtAmt="+userSlmtAmt+"&encounterFacilityId="+encounterFacilityId; //V210129
	retVal= await top.window.showModalDialog("../../eBL/jsp/BLBillSlmtMainIRB.jsp?"+param,arguments,features);
	
	if(retVal=='SUCCESS'){
		parent.BillReceiptExisOrderDetails.location.href='../../eBL/jsp/BillReceiptOutstBill.jsp?'+queryString;		
	}
	else return;	
}

function checkAlpha(event){
	var strCheck = '1234567890.-';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  
	if (strCheck.indexOf(key) == -1) return false;  
	return true ;
}

function checkRemSlmtAmt(obj){
	var noofdecimal = $(parent.BillReceiptTab.document).find('#noOfDecimal').val();
	var index = $(obj).attr('data-id');
	putDecimal($(obj).get(0),17,noofdecimal);
	var outStndAmt =$('#tdOutStdAmt_'+index).text();
	var slmtAmt =$(obj).val();
	if(slmtAmt>=0 || slmtAmt<0){
	}
	else{
		alert(getMessage("NUM_ALLOWED", "SM"));
		$(obj).val('');
		$(obj).focus();
		return false;
	}
	if(outStndAmt<0){
		if(slmtAmt<0){
			if(parseFloat(slmtAmt) < parseFloat(outStndAmt)){
			alert(getMessage('BL9674','BL'));		
			
			$(obj).focus();
				return false;
			}
		}
	 
		if(slmtAmt>0){
			if(parseFloat(outStndAmt) < 0 && parseFloat(slmtAmt) > 0){
				alert(getMessage('BL0623','BL'));
				$(obj).focus();				
				return false;
			}
		}
	} 
	else{
		if(parseFloat(slmtAmt) > parseFloat(outStndAmt)){
			alert(getMessage('BL9674','BL'));		
			$(obj).focus();			
			return false;
		} 
		if(parseFloat(outStndAmt) > 0 && parseFloat(slmtAmt) < 0){
			alert(getMessage('BL0623','BL'));			
			$(obj).focus();
			return false;
		}
	}
}

function reset(){
        $('input:checkbox').removeAttr('checked');
		var indx = $('#index').val();
        for(var i=1;i<indx;i++){
        	$('#remSlmtAmt'+i).val($('#tdOutStdAmt_'+i).text());
        }
}

function disableExistingOrder(){
	var doc = parent.BillReceiptExisOrderSearch.document;
	$(doc).find('input:text').each(function(){
		$(this).prop('readonly',true);
	});
	$(doc).find('select').each(function(){
		$(this).prop('disabled',true);
	});
	$(doc).find('.button').each(function(){
		$(this).prop('disabled',true);
	});
	$(doc).find('#from_bill_date_cal').prop('disabled',true);
	$(doc).find('#to_bill_date_cal').prop('disabled',true);
}

function enableExistingOrder(){
	var doc = parent.BillReceiptExisOrderSearch.document;
	$(doc).find('input:text').each(function(){
		$(this).prop('readonly',false);
	});
	$(doc).find('select').each(function(){
		$(this).prop('disabled',false);
	});
	$(doc).find('.button').each(function(){
		$(this).prop('disabled',false);
	});
	$(doc).find('#from_bill_date_cal').prop('disabled',false);
	$(doc).find('#to_bill_date_cal').prop('disabled',false);
}

function clearAndDisableSearchFields(){
	resetExistingOrder();
	disableExistingOrder();
}

function highlightDynamicTd(obj){
	$(obj).removeClass('contextMenuItem');
	$(obj).addClass('selectedcontextMenuItem');
}

function removeHighlight(obj){
	$(obj).removeClass('selectedcontextMenuItem');
	$(obj).addClass('contextMenuItem');
}

function returnDateObj(obj){
	var dateTime = obj.split(" ");
	var date = dateTime[0].split("/");
	var time = dateTime[1].split(":");
	var dateObj = new Date(date[2],date[1]-1,date[0],time[0],time[1]);
	return dateObj;
}

function userValidation(obj,cld_frm)
{
	if($('#adhoc_user_id').val() != $('#hdnUserId').val()){
		$('#user_password').val('');
	}
	
	var user_name = document.forms[0].adhoc_user_id.value;
	var pass_wrd = document.forms[0].user_password.value;

	var cal_frm_obj="";
	if(cld_frm=="U")
	{
		cal_frm_obj=obj.value;		
	}
	else if(cld_frm=="P")
	{
		cal_frm_obj=obj.value;	

		if(cal_frm_obj != '' && user_name == '')
		{
			alert(getMessage("BL9112","BL"));
			$('#user_password').val('');
			return false;
		}
	}

		var params = "calledFrom=user_pass"+
		"&user_name="+user_name+
		"&pass_wrd="+pass_wrd;
		
		$.ajax({
			type:"GET",
			url:"../jsp/BillReceiptAjax.jsp",
			data:params,
			dataType:"json",
			async:false,
			success: function(data){			
				if(data.valid_user_pass_YN == 'N'){
					alert(getMessage('BL1232','BL'));
					
					$('#user_password').val('');
					return false;
				}
				else if(data.valid_user_YN  == 'N'){
					
					alert(getMessage('BL2095','BL'));
					$('#adhoc_user_id').val('');
					return false;
				}		
			},
			 error: function(data){
				 alert(data)
		      }
		});
		$('#hdnUserId').val($('#adhoc_user_id').val());
	return true;
	}	
	
//V221023	
function  validatePKID(pkid,called){
	var service_location=parent.BillReceiptExisOrderSearch.BLChargePatientEncounterExistingOrder.document.getElementById("serviceLocation").value;
		if(service_location=='' ){
			document.getElementById("queue_id").value='';
			alert(getMessage('BL0951','BLEXT'));
			return false;
		}
	else if(pkid.value==''){
		alert(getMessage('BL0952','BLEXT'));
		return false;
	} 
	else{
		var p_operating_facility_id = document.forms[0].facilityId.value;
		var p_Patient_id = document.forms[0].patient_id.value;
		var p_episode_type = document.forms[0].episode_type.value;
		var p_episode_id = document.forms[0].episode_id.value;
		var encounter_id = document.forms[0].encounter_id.value;
		var p_visit_id = document.forms[0].visit_id.value;
	
		var params="calledFrom=QueuePKID&called="+called+"&pkid="+pkid.value+"&service_location="+service_location+"&p_operating_facility_id="+p_operating_facility_id+"&p_Patient_id="+p_Patient_id+"&p_episode_type="+p_episode_type+"&p_episode_id="+p_episode_id+"&p_visit_id="+p_visit_id+"&encounter_id="+encounter_id;
		
		$.ajax({
			type:"GET",
			url:"../jsp/BillReceiptAjax.jsp",
			data:params,
			dataType:"text",
			async:false,
			success: function(data){
				
			},
		 error: function(data){
			
	     		 }
		});
	}
}

//V221230
async function refNumLookup(){
	//alert("ref");
	var frm = document.forms[0];
	var facility_id = document.forms[0].facilityId.value;
	var patient_id = document.forms[0].patient_id.value;
	var episode_type = document.forms[0].episode_type.value;
	
	var qryParam = '&patient_id='+patient_id+'&episode_type='+episode_type+'&facility_id='+facility_id;
	
	
	var retVal				= new String();
	var dialogTop			= "40";
	var dialogHeight		= "900px" ;
	var dialogWidth			= "800px" ;
	var features			= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var message				="";
	
	var title = getLabel("eBL.OrgBillRefNo.label", 'bl');		

	var column_sizes = escape("10%");

	var column_descriptions = 'Reference Number';
	var sql="";			
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&col_show_hide=Y"+qryParam;
	
	var  retVal=await window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?called_for=Org_Bill_ref_num&"+param,arguments,features);
	
	if (retVal != null && retVal!="" && retVal!="undefined" )
	 {
		  retVal=unescape(retVal);
		  var arr=retVal.split("^~^");
		  frm.orgBillRefNum.value = arr[0];
	 }
	return retVal;
	
}
