/*
---------------------------------------------------------------------------------------------
Sr No     	Version     Incident		SCF/CRF    			Developer Name
---------------------------------------------------------------------------------------------
1.		V210531		19058			MOHE-SCF-0107		Nandhini M
2			 V211130			26231		KDAH-SCF-0744-TF		Mohanapriya K
---------------------------------------------------------------------------------------------
*/

function pracstaffchange(indx)
{
		$('#drName_'+indx).val('');
		$('#practStaffType'+indx).val('');
		$('#docNam'+indx).val('');
}

async function callBGDesc(criteria,obj,code,grp){
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	var title = '';
	
			if(criteria == 'S'){
				sql = "Select description, code from (select short_desc description,blng_serv_code code from bl_blng_serv_lang_vw where nvl(status,'N') != 'S' and upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2 ";
				title = 'Billing Services';							
			}
			else if(criteria == 'BSG'){
				sql = "Select description, code from (SELECT short_desc description,SERV_GRP_CODE CODE FROM BL_BLNG_SERV_GRP_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2 ";
				title = 'Billing Service Group';
			}
			else if(criteria == 'BSGC'){
				if(grp.val() == ''){
					sql = "SELECT description, code FROM (SELECT short_desc description, serv_classification_code code FROM bl_serv_classification_lov_vw WHERE UPPER (language_id) = UPPER ('"+locale+"')) WHERE UPPER (description) LIKE UPPER (?) AND UPPER (code) LIKE UPPER (?) ORDER BY 2 "; //V210531
					
					/*sql = "Select description, code from (SELECT short_desc description,SERV_CLASSIFICATION_CODE CODE FROM BL_SERV_CLASSIFICATION_LANG_VW WHERE  upper(language_id) = upper('"+locale+"') Union Select 'All Classifications','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";*/
				}
				else{
					sql = "SELECT  description, code FROM (SELECT short_desc description, serv_classification_code code FROM bl_serv_classification_lov_vw WHERE UPPER (language_id) = UPPER ('"+locale+"') AND SUBSTR (serv_classification_code, 1, 2) = '"+grp.val()+"') WHERE UPPER (description) LIKE UPPER (?) AND UPPER (code) LIKE UPPER (?) ORDER BY 2 "; //V210531

					/*sql = "Select description, code from (SELECT short_desc description,SERV_CLASSIFICATION_CODE CODE FROM BL_SERV_CLASSIFICATION_LANG_VW WHERE  upper(language_id) = upper('"+locale+"') and substr(serv_classification_code,1,2) = '"+grp.val()+"' Union Select 'All Classifications','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";*/
				}
				
				title = 'Service Classification';
			}
			else if(criteria == 'ESG'){
				sql = "Select description, code from (SELECT short_desc description,PRT_GRP_HDR_CODE CODE FROM BL_BLNG_PRT_GRP_HDR_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Enterprise Service Group';
			}
			else if(criteria == 'ESGL'){
				sql = "Select description, code from (SELECT short_desc description,PRT_GRP_HDR_CODE||PRT_GRP_LINE_CODE CODE FROM BL_BLNG_PRT_GRP_LINE_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Enterprise Service Group Line';
			}
			
			else if(criteria == 'PG'){
				sql = "Select description, code from (select short_desc description,package_serv_group_code CODE from bl_package_serv_group_hdr  where OPERATING_FACILITY_ID = '"+facility_id+"' Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2"; //V211130
				title = 'Package Group';
			}
			else if(criteria == 'M'){
				sql = "Select description, code from (SELECT short_desc description,item_code CODE FROM mm_item_lang_vw WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Material Item';
			}
			else if(criteria == 'T'){
				sql = "Select description, code from (select short_desc description,sale_category_code CODE from bl_st_item_sale_catg_hdr Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Sale Category';
			}
			else if(criteria == 'P'){
				sql = "Select description, code from (select short_desc description,package_code CODE from BL_PACKAGE_LANG_VW WHERE upper(language_id) = upper('"+locale+"') AND OPERATING_FACILITY_ID = '"+facility_id+"' Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Package';
			}
			else if(criteria == 'OTP'){
				var orderCategory = $('#orderCategory').val();
				if(orderCategory !=''){					
					//sql = "Select description, code from (select short_desc description,order_type_code CODE from or_order_type_lang_vw WHERE upper(language_id) = upper('"+locale+"') AND order_category = '"+orderCategory+"' ) where upper(short_desc) like upper(?) and upper(code) like upper(?) order by 2";
					sql = "Select description, code from (SELECT short_desc description,order_type_code CODE FROM or_order_type_lang_vw WHERE  upper(language_id) = upper('"+locale+"')  AND order_category = '"+orderCategory+"'  ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				}
				else{
					//sql = "Select description, code from (select short_desc description,order_type_code CODE from or_order_type_lang_vw WHERE upper(language_id) = upper('"+locale+"') ) where upper(short_desc) like upper(?) and upper(code) like upper(?) order by 2 ";
					sql = "Select description, code from (SELECT short_desc description,order_type_code CODE FROM or_order_type_lang_vw WHERE  upper(language_id) = upper('"+locale+"') ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				}
				
				title = 'Order Type';
			}


	//alert(sql)
	//var sql="SELECT DESCRIPTION, CODE FROM (SELECT 'All' DESCRIPTION,'*ALL' CODE FROM DUAL UNION SELECT A.SHORT_DESC DESCRIPTION,A.SPECIALITY_CODE CODE FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B  WHERE A.LANGUAGE_ID='"+locale+"' AND  A.SPECIALITY_CODE = B.SPECIALITY_CODE ) WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?) ORDER BY 2";
	//alert('sql->'+sql)
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.val();
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	returnedValues =await CommonLookup(title, argumentArray );
	var ret1=unescape(returnedValues);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.val(arr[1]);
		code.val(arr[0]);	
	}
else
	{
	obj.val('');
	code.val('');		
	} 


}

function callSearchCriteria(){
	var servGroup = $('#serviceGroup').val();
	var classification = $('#hdnClassification').val();
	var servOrPanel = '';
	if($('#serviceOrPanel:checked').val()){
		servOrPanel = 'P';
	}
	else{
		servOrPanel = 'S';
	}
	var servPanelCode = $('#servPanelCode').val();
	var servPanelDesc = $('#servPanelDesc').val();
	var callingPage = '../../eBL/jsp/BLChargePatientNewOrderResult.jsp?servGroup='+servGroup+'&classification='+classification+
	'&servOrPanel='+servOrPanel+'&servPanelCode='+encodeURIComponent(servPanelCode)+'&servPanelDesc='+encodeURIComponent(servPanelDesc);
	parent.BLChargePatientExisOrderTraverse.document.location.href = callingPage;
	//parent.document.getElementsById('BL_mainFrame').rows = document.getElementById('allFramesNew').value;7%,0%,0%,6%,19%,30%,30%,0%,4%'
	parent.document.getElementById("pline").style.height = "8vh";
	parent.document.getElementById('BillingBanner').style.height = "0vh";
	parent.document.getElementById('BillingMenu').style.height = "0vh";
	parent.document.getElementById('BLChargePatientEncounterTab').style.height = "5vh";
	parent.document.getElementById('BLChargePatientEncounterTabPage').style.height = "19vh";
	parent.document.getElementById('BLChargePatientExisOrderTraverse').style.height = "31vh";
	parent.document.getElementById('BLChargePatientExisOrderServDetails').style.height = "20vh";
	parent.document.getElementById('BLChargePatientExisOrderServEdit').style.height = "0vh";
	//parent.document.getElementById('messageFrame').style.height = "8vh";
	//parent.messageFrame.location.href = '../../eCommon/jsp/error.jsp';
	parent.document.getElementById('messageFrame1').style.height = "8vh";
	parent.messageFrame1.location.href = '../../eCommon/jsp/error.jsp';
	
}

function resultResizeFrames(){
	document.getElementById('resizeLink').style.visibility = 'hidden';
	document.getElementById('resizeBtn').style.visibility = 'hidden';
	document.getElementById('resetLink').style.visibility = 'visible';
	document.getElementById('resetBtn').style.visibility = 'visible';
	//<input type='hidden' id='allFramesNewDtl' 	name='allFramesNewDtl' 	 value='7%,0%,0%,6%,0%,51%,32%,0%,4%'>
	//parent.document.getElementById('BL_mainFrame').rows=  parent.document.getElementById('allFramesNewDtl').value;
	//parent.PolicyCoverageMain.document.getElementById('ContainerCoverage').rows="100%,0%,0%";	
	parent.document.getElementById("pline").style.height = "7vh";
	parent.document.getElementById('BillingBanner').style.height = "0vh";
	parent.document.getElementById('BillingMenu').style.height = "0vh";
	parent.document.getElementById('BLChargePatientEncounterTab').style.height = "6vh";
	parent.document.getElementById('BLChargePatientEncounterTabPage').style.height = "0vh";
	parent.document.getElementById('BLChargePatientExisOrderTraverse').style.height = "51vh";
	parent.document.getElementById('BLChargePatientExisOrderServDetails').style.height = "32vh";
	parent.document.getElementById('BLChargePatientExisOrderServEdit').style.height = "0vh";
	parent.document.getElementById('messageFrame').style.height = "4vh";
}


function detailsResizeFrames(){
	document.getElementById('resizeLink').style.visibility = 'hidden';
	document.getElementById('resizeBtn').style.visibility = 'hidden';
	document.getElementById('resetLink').style.visibility = 'visible';
	document.getElementById('resetBtn').style.visibility = 'visible';
	//<input type='hidden' id='allFramesNewRcrd' 	name='allFramesNewRcrd'   value='7%,0%,0%,6%,0%,32%,52%,0%,4%'>
	//parent.document.getElementById('BL_mainFrame').rows=  document.getElementById('allFramesNewRcrd').value;
	//parent.PolicyCoverageMain.document.getElementById('ContainerCoverage').rows="100%,0%,0%";	
	parent.document.getElementById("pline").style.height = "7vh";
	parent.document.getElementById('BillingBanner').style.height = "0vh";
	parent.document.getElementById('BillingMenu').style.height = "0vh";
	parent.document.getElementById('BLChargePatientEncounterTab').style.height = "6vh";
	parent.document.getElementById('BLChargePatientEncounterTabPage').style.height = "0vh";
	parent.document.getElementById('BLChargePatientExisOrderTraverse').style.height = "32vh";
	parent.document.getElementById('BLChargePatientExisOrderServDetails').style.height = "52vh";
	parent.document.getElementById('BLChargePatientExisOrderServEdit').style.height = "0vh";
	parent.document.getElementById('messageFrame').style.height = "4vh";
}

function resultResetFrames(){
	document.getElementById('resizeLink').style.visibility = 'visible';
	document.getElementById('resizeBtn').style.visibility = 'visible';
	document.getElementById('resetLink').style.visibility = 'hidden';
	document.getElementById('resetBtn').style.visibility = 'hidden';
//	<input type='hidden' id='allFramesNew' 		name='allFramesNew'  	 value='7%,0%,0%,6%,19%,30%,30%,0%,4%'>
	//parent.document.getElementById('BL_mainFrame').rows=  document.getElementById('allFramesNew').value;
	//parent.PolicyCoverageMain.document.getElementById('ContainerCoverage').rows="36%,10%,54%";		
	parent.document.getElementById("pline").style.height = "7vh";
	parent.document.getElementById('BillingBanner').style.height = "0vh";
	parent.document.getElementById('BillingMenu').style.height = "0vh";
	parent.document.getElementById('BLChargePatientEncounterTab').style.height = "6vh";
	parent.document.getElementById('BLChargePatientEncounterTabPage').style.height = "19vh";
	parent.document.getElementById('BLChargePatientExisOrderTraverse').style.height = "30vh";
	parent.document.getElementById('BLChargePatientExisOrderServDetails').style.height = "30vh";
	parent.document.getElementById('BLChargePatientExisOrderServEdit').style.height = "0vh";
	parent.document.getElementById('messageFrame').style.height = "4vh";
}

function clearCode(obj){
	obj.val('');
}

function loadServiceDetails(obj){
	var prevClicked = $('#prevClicked').val();
	if(prevClicked.length>0){
		$('#resultTr_'+prevClicked +' td').each(function(){
			$(this).attr('class','LABEL');
		});
	}

	$('#resultTr_'+obj +' td').each(function(){
		$(this).attr('class','LocalYellow');
	});
	
	$('#prevClicked').val(obj);
	
	var frm = parent.BLChargePatientExisOrderTraverse.document.chargePatientNewOrderResult;
	var srchFrm = parent.BLChargePatientEncounterTabPage.document.newOrderSrchCriteria;
	var dtlFrm = parent.BLChargePatientExisOrderServDetails.document.newOrderDtlFrm;
	
	var servPanelCode =  $('#servCode_'+obj).text();
	//Check Duplicate
	var temp_jsp="../jsp/BLChargePatientNewOrderPersistence.jsp?func_mode=checkDuplicate&servPanelCode="+servPanelCode;
	
	var chkStr ="<root><SEARCH ";				
	chkStr +=" /></root>";
	//alert(temp_jsp)
	/*var chkDoc = new ActiveXObject( "Microsoft.XMLDom" ) ;
	var chkHttp = new ActiveXObject( "Microsoft.XMLHTTP" ) ;*/
	var chkDoc = "" ;
	var chkHttp = new XMLHttpRequest();
 
	//chkDoc.loadXML(chkStr);
	//alert(temp_jsp)
	chkDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	chkHttp.open("POST",temp_jsp,false);
	chkHttp.send(xmlDoc);
	
	var responseText=trimString(chkHttp.responseText);
	//Check Duplicate
	
	//alert(dtlFrm)

	if(responseText == 'Y'){
		/*if(srchFrm.serviceOrPanel.checked==true){
		alert(getMessage('BL2476','BL'));	
		}else{
		alert(getMessage('BL00910','BL'));
		}
		//alert('Service Already Added');
		return false;*/
	}
	
	if(dtlFrm != 'undefined' && dtlFrm != undefined){
		var xmlString=formXMLString(dtlFrm);
		//alert(xmlString)
		var res = formValidation(xmlString,"StoreServiceDetails");
		//alert('save happens')
	}
		
	var servOrPanel = $.trim($('#servOrPanel_'+obj).text());

	if(servOrPanel == 'Service'){
		servOrPanel = 'S';
	}
	else{
		servOrPanel = 'L';
	}
	var episodeType = srchFrm.episode_type.value;
	var episodeId = srchFrm.episode_id.value;
	var visitId = srchFrm.visit_id.value;
	var patientId = srchFrm.patient_id.value;
	var encounterId = srchFrm.encounter_id.value;

	var acctSeqNo = srchFrm.acctSeqNo.value;
	//var dateTime = (String) request.getParameter("dateTime");
	
	var servPanelDesc = $('#servDesc_'+obj).text();
	var rateIndicator = $.trim($('#rateInd_'+obj).text());
	if(rateIndicator == 'Rate'){
		rateIndicator = 'R';
	}
	else{
		rateIndicator = 'C';
	}
	
	var temp_jsp="../../eBL/jsp/BLChargePatientNewOrderPersistence.jsp?func_mode=getServiceDetails&servOrPanel="+servOrPanel+
				"&episodeType="+episodeType+
				"&episodeId="+episodeId+
				"&visitId="+visitId+
				"&patientId="+patientId+
				"&encounterId="+encounterId+
				"&servPanelCode="+servPanelCode+
				"&servPanelDesc="+encodeURIComponent(servPanelDesc)+"&rateIndicator="+rateIndicator+"&acctSeqNo="+acctSeqNo;
	var xmlStr ="<root><SEARCH ";				
	xmlStr +=" /></root>";
	//alert(temp_jsp)
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	var parserErrors = xmlDoc.getElementsByTagName("parsererror");

    
	//if (xmlDoc.parseError.errorCode != 0)
	if (parserErrors.length > 0) 
	{
		alert("Error in line " + xmlDoc.parseError.line +
				" position " + xmlDoc.parseError.linePos +
				"\nError Code: " + xmlDoc.parseError.errorCode +
				"\nError Reason: " + xmlDoc.parseError.reason +
				"Error Line: " + xmlDoc.parseError.srcText);
		return(null);
	}
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	
	//if (xmlDoc.parseError.errorCode != 0)
	if (parserErrors.length > 0) 
	{
		alert("Error in line " + xmlDoc.parseError.line +
				" position " + xmlDoc.parseError.linePos +
				"\nError Code: " + xmlDoc.parseError.errorCode +
				"\nError Reason: " + xmlDoc.parseError.reason +
				"Error Line: " + xmlDoc.parseError.srcText);
		return(null);
	}
	var responseText=trimString(xmlHttp.responseText);
	var resArr = responseText.split(":::");
	if(resArr[0] == 'N'){
		alert(resArr[1]);
	}
	else{
		//alert('No Error');
		parent.BLChargePatientExisOrderServDetails.document.location.href = '../jsp/BLChargePatientNewOrderDetails.jsp';
	}
	return true;
	
}

function recordDetails(){

	

	if($("#rowCount").val()==0)
		{
		alert(getMessage("BL9802","BL"));
		return;
		}
	
	var dtlFrm = document.forms[0];
	var submitFlag = true;
	
	


	
	$('input[id^=dateTime_]').each(function(){
		if($.trim($(this).val())==''){

			alert(getMessage('BL00911','BL')); 
			//alert('Charge Date / Time is Mandatory for all Services');
			submitFlag = false;
			return false;
		}		
	});
	
	var dateTimeArr = [];
	$('input[id^=dateTime_]').each(function(){
		var indx = $(this).attr('data-id');
		var blngCode = $('#servCode_'+indx).val();
		var dateVal=$(this).val();
		var dateArray = dateVal.split(":");
		var dateObj= dateVal.replace(":"+dateArray[2]," ");
		var key = blngCode+dateObj
		if($.inArray(key,dateTimeArr) != -1){
			var msg = $('#tdSno_' + indx).text();
			msg = msg.replace(/\s/g, '');
			//$(this).select();
		//	alert(getMessage('BL1382','BL')+' : SNo '+$('#tdSno_'+indx).text());
			alert(getMessage('BL1382','BL')+' : SNo '+msg);
			submitFlag = false;
			return false;
		}
		else{
			dateTimeArr.push(key);
		}
		
		
	});
	
	if(submitFlag){
		$('input[id^=qty_]').each(function(){
			if($.trim($(this).val())==''){
				
				alert(getMessage('BL00912','BL')); 
				//alert('Quantity is Mandatory for all Services');
				submitFlag = false;
				return false;
			}
		});
	}
	
	if(submitFlag){
		$('input[id^=drName_]').each(function(){
			if($.trim($(this).val())==''){
				
				alert(getMessage('BL00913','BL')); 
				//alert('Doctor Code is Mandatory for all Services');
				submitFlag = false;
				return false;
			}
		});
	}
	
	
	
	
	if(submitFlag){
		$('#serviceDtls tr').each(function(){
			if($(this).attr('data-id') > 0){
				var indx = $(this).attr('data-id');
				if($('#override_'+indx).val() == 'Y' && $('#policyIncl_'+indx).val() != $('#originalIncl_'+indx).val() && $.trim($('#reasCode'+indx).val()) == ''){

					alert(getMessage('BL00914','BL')+indx); 
					//alert('Action Reason is Mandatory for Row Number '+indx);
					submitFlag = false;
					return false;
				}
			}
		});
	}
	
	if(submitFlag){
		var xmlString=formXMLString(dtlFrm);
		//alert(xmlString)
		var res = formValidation(xmlString,"StoreServiceDetails");
		var srchFrm = parent.BLChargePatientEncounterTabPage.document.newOrderSrchCriteria;
		xmlString=formXMLString(srchFrm);
		res = formValidation(xmlString,"assignPatInfo");
		dtlFrm.method="post";
		dtlFrm.action="../../servlet/eBL.BLChargePatientNewOrderServlet";
		dtlFrm.target = "messageFrame1";
		dtlFrm.submit();
	}
}

function cancelNewOrder(obj){
	$('#deleteFlag_'+obj).val('Y');
	/*alert('nw')
	$('#tr_'+obj).remove();
	var rowCnt = $('#rowCount').val();
	$('#rowCount').val(rowCnt-1);
	hideToolTip();*/
	var servCode = $('#servCode_'+obj).val();
	var hh = $('#dateTime_'+obj).val();
	var temp_jsp="../jsp/BLChargePatientNewOrderPersistence.jsp?func_mode=removeRestriction&servCode="+servCode+"&hh="+hh;
	
	var chkStr ="<root><SEARCH ";				
	chkStr +=" /></root>";
	//var chkDoc = new ActiveXObject( "Microsoft.XMLDom" ) ;
	//var chkHttp = new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	//var chkDoc = "";
	 var chkDoc = new DOMParser().parseFromString(chkStr, "text/xml");

	    // Create XMLHttpRequest object
	    var chkHttp = new XMLHttpRequest();
	    chkHttp.open("POST", temp_jsp, false);
	    chkHttp.setRequestHeader("Content-Type", "text/xml"); // Set content type for XML
	    chkHttp.send(chkDoc); // Send the XML document
	
	var responseText=trimString(chkHttp.responseText);
	
	var dtlFrm = document.forms[0];
	var xmlString=formXMLString(dtlFrm);
	//alert(xmlString)
	var res = formValidation(xmlString,"StoreServiceDetails");
	parent.BLChargePatientExisOrderServDetails.document.location.href = '../jsp/BLChargePatientNewOrderDetails.jsp';
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

function isValidDate(obj){
	if(obj.value!=""){
		var flag=true;
		var RE_NUM =  /^\/?\d+$/;
		var str_date = obj.value;
		var arr_date = str_date.split('/');
		if (arr_date.length != 3) return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);//flag=false;
	
		if(arr_date[0]!=null)
		{
		if (arr_date[0].length !=2 ) flag=false;
		}
		if(arr_date[1]!=null)
		{
		if (arr_date[1].length !=2 ) flag=false;
		}
		if(arr_date[2]!=null)
		{
		if (arr_date[2].length !=4 ) flag=false;
		}
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

		if (flag==false){
			return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
		}
	}

	return true;
}

function cal_error (str_message,obj) {
	alert (str_message);
	obj.focus();
	obj.select();
	return false;
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
	var temp_jsp="../jsp/BLChargePatientNewOrderPersistence.jsp?func_mode="+last_link;
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var parserErrors = xmlDoc.getElementsByTagName("parsererror");

    
	//if (xmlDoc.parseError.errorCode != 0)
	if (parserErrors.length > 0) 
		{
			alert("Error in line " + xmlDoc.parseError.line +
					" position " + xmlDoc.parseError.linePos +
					"\nError Code: " + xmlDoc.parseError.errorCode +
					"\nError Reason: " + xmlDoc.parseError.reason +
					"Error Line: " + xmlDoc.parseError.srcText);
			return(null);
		}
		xmlHttp.open("POST",temp_jsp,false);
		//xmlHttp.send(xmlDoc);
		xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));
		var parserErrors = xmlDoc.getElementsByTagName("parsererror");

	    
		//if (xmlDoc.parseError.errorCode != 0)
		if (parserErrors.length > 0) 
		{
			alert("Error in line " + xmlDoc.parseError.line +
					" position " + xmlDoc.parseError.linePos +
					"\nError Code: " + xmlDoc.parseError.errorCode +
					"\nError Reason: " + xmlDoc.parseError.reason +
					"Error Line: " + xmlDoc.parseError.srcText);
			return(null);
		}
	var responseText=xmlHttp.responseText ;
	//eval(responseText);
	return true;
}

function updateNetAmountForCharge(indx){
	
	var obj = $('#grossAmt_'+indx).val();
	var obj1 = $('#servDisc_'+indx).val();
	var Amt = (obj - obj1);

		if ( trimCheck(obj) && isNaN(obj) == false ) {	
			
		var noOfDecimals = $(parent.BLChargePatientEncounterTab.document).find('#noOfDecimals').val();		 
		
	
		$('#total_'+indx).val(Amt);
	$('#patPayable_'+indx).val(Amt);
		 $('#hdnTotal_'+indx).val(Amt);	
		 $('#hdnPatPayable_'+indx).val(Amt);	
		 $('#adhocRate_'+indx).val('');	
		 $('#adhocDisc_'+indx).val('');	
		 $('#adhocReason_'+indx).val('');	
		 putDecimal($('#total_'+indx).get(0),17,noOfDecimals);	
		 putDecimal($('#patPayable_'+indx).get(0),17,noOfDecimals);	
			
		 findTotal();
    }
    else {
        if ( obj.length > 0 ) {
        	$('#grossAmt_'+indx).val('');
            alert(getMessage("NUM_ALLOWED", "SM"));
            
            return false;
        }
    }
}

function putdecimal(object)
{


	if(object.value!='')
	{
		var noOfDecimals = $(parent.BLChargePatientEncounterTab.document).find('#noOfDecimals').val();
	//var decimal=2;
	putDecimal(object,17,noOfDecimals);
	}
}
function checkAlpha(fld, e, deci)
{
/*		if (parseInt(deci)>0)
		   var strCheck = '.0123456789';
		else
		   var strCheck = '0123456789';
			
		var whichCode = (window.Event) ? e.which : e.keyCode;
		if (whichCode == 13) return true;  // Enter

		key = String.fromCharCode(whichCode);  // Get key value from key code

		if (strCheck.indexOf(key) == -1) return false;  // Not a valid key

		if(key == "." && fld.value.indexOf(key) != -1) return false; // Not more than one '.' char



		

	//alert('check for deci');
/*	var strCheck = '1234567890-';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  
	if (strCheck.indexOf(key) == -1) return false;  
	return true ;*/

}
function checkNegativeQtyPriv(indx){
	var qty = $('#qty_'+indx).val();
	if (  qty <= 0 || qty >= 0) {
       
    }
    else {
        if ( qty.length > 0 ) {

            alert(getMessage("NUM_ALLOWED", "SM"));
            $('#qty_'+indx).val('');
            return false;
        }
    }
	var tabDoc = parent.BLChargePatientEncounterTab.document;
	var enterNegative = $(tabDoc).find('#enterNegative').val();
	if(enterNegative != 'Y' && qty<0){
		alert(getMessage('BL9610','BL'));
		$('#qty_'+indx).val('');
	}
	
}

function updateNetAmountDr(indx){
	
	var srchFrm = parent.BLChargePatientEncounterTabPage.document.newOrderSrchCriteria;			
	var episodeType = srchFrm.episode_type.value;
	var episodeId = srchFrm.episode_id.value;
	var visitId = srchFrm.visit_id.value;
	var patientId = srchFrm.patient_id.value;
	var encounterId = srchFrm.encounter_id.value;
	var acctSeqNo = srchFrm.acctSeqNo.value;
	var rateIndicator = $('#rateInd_'+indx).val();
	var servPanelCode = $('#servCode_'+indx).val();
	var servOrPanel = $('#servOrPanel_'+indx).val();
	var servPanelDesc = $('#servDesc_'+indx).val();
	var quantity = $('#qty_'+indx).val();
	var drName=$('#drName_'+indx).val();
	$.ajax({
		type:"GET",
		url:"../jsp/BLChargePatientNewOrderPersistence.jsp",
		data:"func_mode=updateServiceDetails&servOrPanel="+servOrPanel+
				"&episodeType="+episodeType+
				"&episodeId="+episodeId+
				"&visitId="+visitId+
				"&patientId="+patientId+
				"&encounterId="+encounterId+
				"&servPanelCode="+servPanelCode+
				"&servPanelDesc="+encodeURIComponent(servPanelDesc)+
				"&rateIndicator="+rateIndicator+"&quantity="+quantity+"&acctSeqNo="+acctSeqNo+
				"&drName="+drName,
				dataType:"json",
		success: function(responseText){
			if(responseText.Success == 'Y'){
				
				var gamount=responseText.GrossAmount;
				var payable=responseText.PatNetChargeAmount;
				var ttotal=responseText.NetChargeAmount;
				//alert(gamount);
				$('#grossAmt_'+indx).val(parseFloat(gamount).toFixed(2));
				
				$('#total_'+indx).val(parseFloat(ttotal).toFixed(2));
				$('#patPayable_'+indx).val(parseFloat(payable).toFixed(2));
				
				var noOfDecimals = $(parent.BLChargePatientEncounterTab.document).find('#noOfDecimals').val(); 
			 
			
				$('#servDisc_'+indx).val(responseText.PatDiscAmount);
				$('#panelStr_'+indx).val(responseText.PanelString);
				$('#patPaid_'+indx).val(responseText.PatientPaid);		
				putDecimal($('#servDisc_'+indx).get(0),17,noOfDecimals);	
				findTotal();
			}
			else{
				alert(responseText.Error);
			}
		},
		error: function(data){
			//alert(data);
		}
	});
	
		
}
function updateNetAmount(indx){
	//alert('To be done');
	/*if($('#qty_'+indx).val()=='')
		{
		alert(getMessage("BL00302","BL"));
		$('#qty_'+indx).val('');
		}*/
		 if($('#qty_'+indx).val()==0)
		{
		alert(getMessage("BL9018","BL"));
		$('#qty_'+indx).val('');
		}
		 var qty= $('#qty_'+indx).val();	 
		 
	//	 $('#qtyhidden_'+indx).val(qty);
		 
		 
		  var qty_hidden= $('#qtyhidden_'+indx).val();
		  
			 if(parseInt(qty)!=parseInt(qty_hidden))
		{
		var srchFrm = parent.BLChargePatientEncounterTabPage.document.newOrderSrchCriteria;			
	var episodeType = srchFrm.episode_type.value;
	var episodeId = srchFrm.episode_id.value;
	var visitId = srchFrm.visit_id.value;
	var patientId = srchFrm.patient_id.value;
	var encounterId = srchFrm.encounter_id.value;
	var acctSeqNo = srchFrm.acctSeqNo.value;
	var rateIndicator = $('#rateInd_'+indx).val();
	var servPanelCode = $('#servCode_'+indx).val();
	var servOrPanel = $('#servOrPanel_'+indx).val();
	var servPanelDesc = $('#servDesc_'+indx).val();
	var quantity = $('#qty_'+indx).val();
	var drName=$('#drName_'+indx).val();
	$.ajax({
		type:"GET",
		url:"../jsp/BLChargePatientNewOrderPersistence.jsp",
		data:"func_mode=updateServiceDetails&servOrPanel="+servOrPanel+
				"&episodeType="+episodeType+
				"&episodeId="+episodeId+
				"&visitId="+visitId+
				"&patientId="+patientId+
				"&encounterId="+encounterId+
				"&servPanelCode="+servPanelCode+
				"&servPanelDesc="+encodeURIComponent(servPanelDesc)+
				"&rateIndicator="+rateIndicator+"&quantity="+quantity+"&acctSeqNo="+acctSeqNo+
				"&drName="+drName,
				dataType:"json",
		success: function(responseText){
			if(responseText.Success == 'Y'){
				
				var gamount=responseText.GrossAmount;
				var payable=responseText.PatNetChargeAmount;
				var ttotal=responseText.NetChargeAmount;
				//alert(gamount);
				$('#grossAmt_'+indx).val(parseFloat(gamount).toFixed(2));
				
				$('#total_'+indx).val(parseFloat(ttotal).toFixed(2));
				$('#patPayable_'+indx).val(parseFloat(payable).toFixed(2));
				
				var noOfDecimals = $(parent.BLChargePatientEncounterTab.document).find('#noOfDecimals').val(); 
			 
			
				$('#servDisc_'+indx).val(responseText.PatDiscAmount);
				$('#panelStr_'+indx).val(responseText.PanelString);
				$('#patPaid_'+indx).val(responseText.PatientPaid);		
				putDecimal($('#servDisc_'+indx).get(0),17,noOfDecimals);	
				findTotal();
			}
			else{
				alert(responseText.Error);
			}
		},
		error: function(data){
			//alert(data);
		}
	});
	/*var temp_jsp="../jsp/BLChargePatientNewOrderPersistence.jsp?func_mode=updateServiceDetails&servOrPanel="+servOrPanel+
				"&episodeType="+episodeType+
				"&episodeId="+episodeId+
				"&visitId="+visitId+
				"&patientId="+patientId+
				"&encounterId="+encounterId+
				"&servPanelCode="+servPanelCode+
				"&servPanelDesc="+encodeURIComponent(servPanelDesc)+"&rateIndicator="+rateIndicator+"&quantity="+quantity+"&acctSeqNo="+acctSeqNo;
	var xmlStr ="<root><SEARCH ";				
	xmlStr +=" /></root>";
	//alert(temp_jsp)
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	//alert(xmlHttp.responseText)
	var responseText=JSON.parse(xmlHttp.responseText);
	
	if(responseText.Success == 'Y'){
		$('#grossAmt_'+indx).val(responseText.GrossAmount);
		$('#total_'+indx).val(responseText.NetChargeAmount);
		$('#patPayable_'+indx).val(responseText.PatNetChargeAmount);
		$('#servDisc_'+indx).val(responseText.PatDiscAmount);
		findTotal();
	}
	else{
		alert(responseText.Error);
	}*/
}
			
		 $('#qtyhidden_'+indx).val(qty);
			
			
}
function findTotal(){
	var total_amount = 0;
	var pat_payable = 0;
	var noOfDecimals = $(parent.BLChargePatientEncounterTab.document).find('#noOfDecimals').val();
	$('input[id^=total_]').each(function(){
		total_amount = parseFloat(total_amount) + parseFloat($(this).val());
	});
	$('input[id^=patPayable_]').each(function(){
		pat_payable = parseFloat(pat_payable) + parseFloat($(this).val());
	});
	
	$('#net_amount').text(total_amount);
	
	$('#pat_payable_amount').text(pat_payable);
	
	
	if($.trim($('#net_amount').text() != '')){
		putDecimal_Text_WOR($('#net_amount'),17,2);				
	}
	else{
		$('#net_amount').text('0');
		putDecimal_Text_WOR($('#net_amount'),17,noOfDecimals);
	}
	
	if($.trim($('#pat_payable_amount').text() != '')){
		putDecimal_Text_WOR($('#pat_payable_amount'),17,noOfDecimals);				
	}
	else{
		$('#pat_payable_amount').text('0');
		putDecimal_Text_WOR($('#pat_payable_amount'),17,noOfDecimals);
	}
	


	
	var noOfDecimals = $(parent.BLChargePatientEncounterTab.document).find('#noOfDecimals').val();
	$('[id^=net_amount]').each(function(){
		if($.trim($(this).text() != '')){
			putDecimal_Text($(this),17,noOfDecimals);				
		}
		else{
			$(this).text('0');
			putDecimal_Text($(this),17,noOfDecimals);
		}
	});
	
	$('[id^=pat_payable_amount]').each(function(){
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

function findPatPayable(indx,obj){
	var patPayable = '';
	var amt_limit_ind = $('#adhocRate_'+indx).val();
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
    	if(amt_limit_ind != ''){
    		var grossAmt = $('#grossAmt_'+indx).val();
    		var servDisc = $('#servDisc_'+indx).val();
    		var discVal = obj.value;
    		var discAmount = '';
    		//alert(grossAmt +','+servDisc+','+discVal)
    		if(amt_limit_ind == 'A'){
    			patPayable = grossAmt - (parseInt(servDisc)  + parseInt(discVal));
    			patPayable = roundToTwo(patPayable);
    			discAmount = roundToTwo(discVal);    			
    		}
    		else{
    			discAmount = grossAmt * discVal / 100;
    			patPayable = (grossAmt - servDisc ) - (discAmount);	    
    			discAmount = roundToTwo(discAmount);
    			patPayable = roundToTwo(patPayable)
    		}
    		if(patPayable<0){

    			alert(getMessage('BL00904','BL')+grossAmt); 
	    		//alert('Discount Amount should be Lesser than '+grossAmt);
	    		$('#adhocRate_'+indx).val('');
	    		obj.value = '0';
	    		$('#total_'+indx).val($('#hdnTotal_'+indx).val());
	    		$('#patPayable_'+indx).val($('#hdnPatPayable_'+indx).val());
	    	}
	    	else{
	    		$('#total_'+indx).val(patPayable);
	    		$('#patPayable_'+indx).val(patPayable);
	    		$('#adhocAmount_'+indx).val(discAmount);
	    	}
	    	findTotal();
	        return true;
    	}
    	else{
    		alert(getMessage("BL00905", "BL"));
    		//alert('Please choose Amount / Percent Indicator');
    		obj.value = '';
    		$('#total_'+indx).val($('#hdnTotal_'+indx).val());
    		$('#patPayable_'+indx).val($('#hdnPatPayable_'+indx).val());
    		findTotal();
    		return false;
    	}
    	
    }
    else {
        if ( obj.value.length > 0 ) {

            alert(getMessage("NUM_ALLOWED", "SM"));
            obj.value = '';
            return false;
        }
    }
}

function changeDiscInd(indx){
	findPatPayable(indx,document.getElementById('adhocDisc_'+indx));
}

function resetNewOrder(){
	$('input:text').each(function(){
		$(this).val('');
	});
	$('select').each(function(){
		$(this).val('');
	});
	$('#hdnClassification').val('');
	$('#serviceOrPanel').attr('checked',false);
}

function chkDupl(serviceCode,date,indx){
	
	var dateVal=date.value;
	var dateArray = dateVal.split(":");
	var dateObj= dateVal.replace(":"+dateArray[2]," ");
	//alert("index/ serviceCode/ dateObj :: "+indx +"/"+ serviceCode.value +"/"+ dateObj);
		
	$('[id^=tr_]').each(function(){
		var index = $(this).attr('data-id');
		
		if(index != indx){
		var servCode=$('#servCode_'+index).val();
		var timeDate=$('#dateTime_'+index).val();
		var timeDateArray = timeDate.split(":");
		var timeDateObj= timeDate.replace(":"+timeDateArray[2]," ");
		
		//alert("index / servCode / timeDateObj :: "+index +"/"+ servCode +"/"+ timeDateObj);
		if(dateObj==timeDateObj && serviceCode.value==servCode){
			alert(getMessage("BL1382", "BL"));
			//$('#dateTime_'+index).focus();
			return false;
		}
		}
	});
	
}
function putDecimal_Text(Obj,maxvalue,deci)
{
	//alert(Obj.value);
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
					var temp3=temp2+"."+temp1.substring(count,temp1.length);
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
