/*
Sr No       Version         TFS/Incident        SCF/CRF   				Developer Name
---------------------------------------------------------------------------------------------
1           V210129           13523     		MOHE-CRF-0060				Shikha Seth
2           V210405           16612     	 	NMC-JD-SCF-0167-TF			Mohana Priya K
3           V210603           17147     	 	PMG2021-COMN-CRF-0077		MuthkumarN
4			V210624			  19106				Common-ICN-0040				Mohana Priya K
5	        V210713             	     	 	NMC-JD-SCF-0167-TP						Mohana Priya K
6			V211119			  23794				NMC-JD-SCF-0167.1						Mohana Priya K
7 			V220208			  28689				NMC-JD-CRF-0091				Manivel N
8           V220413           30399      		MMS-ME-SCF-0064-TF    		Mohanapriya K
9			V221107			 33910				TH-KW-CRF-0174				Mohanapriya K
---------------------------------------------------------------------------------------------
*/

/*var chkValue="";
var chkColumn="";
var tempPatientId="";
var tempPayerCode="";
*/

var alertShownFlag = false;

function reset()
{	
	interim_main_report.location.reload();
}

function reportOption(langVal)
{
	if(langVal.value=='A')
	{
		$('#p_report_id').val('BLRBLPRT_ALMOAR');
		$('#locale').val('ar');
	}
	else
	{
		$('#p_report_id').val('BLRBLPRT');
		$('#locale').val('en');
	}
}

function billNoFromToValidation(fromOrTo){
	if($("#from_bill_number").val()!=''  && $("#to_bill_number").val()!='' ){
		var fromBill=parseInt($("#from_bill_number").val());
		var toBill=parseInt($("#to_bill_number").val());
		if(fromBill>toBill){
			alert("From Bill number Cannot be Greater than To Bill Number");
			if(fromOrTo=='FROM'){
				$("#from_bill_number").val('');
				$("#from_bill_number_code").val('');
			}
			if(fromOrTo=='TO'){
				$("#to_bill_number_code").val('');
				$("#to_bill_number").val('');
			}
		}
	}	
}

function resetSrchCriteria(){
	var locale=$('#locale').val();
	var site_spec=$('#site_spec').val();
	
	$('input:text').each(function(){
		$(this).val('');
	});
	$('select').each(function(){
		$(this).val('**');
	});
	$('#hdnEpisode_id').val('');
	$('#from_bill_number_code').val('');
	$('#to_bill_number_code').val('');
	$('#dtlPrint').prop('checked', false);
	$('#outStdOnly').prop('checked', false);
	$('#episode_id').prop('disabled', true);
	$('#episode_idbut').prop('disabled', false);	
	$('#episode_type').val('O');
	$('#from_bill_date').val($('#todaysDate30').val());
	$('#to_bill_date').val($('#todaysDate').val());	
	$('#payer_type').val('B');
	//$('#language_option').val('E'); //V211119
	location.reload(); //V210713
	
/*if(site_spec=='true'){
		if(locale!='en')
		{
			$('#language_option').val('A');
			$('#p_report_id').val('BLRBLPRT_ALMOAR');
		}		
		else
		{
			$('#language_option').val('E');
			$('#p_report_id').val('BLRBLPRT');	
		}

		} */ //V210713
	// parent.body_frame.document.location.href =
	// '../../eCommon/html/blank.html';
}

function run() 
{	
	// alert(interim_main_report.body_frame.document.resultForm.rowClicked.value);
	var clicked = $(interim_main_report.body_frame.document).find('#rowClicked').val();
	if(clicked != undefined && clicked!='undefined'){
		runSingleBill(clicked);
	}
	else{
		alert('Select a record to run the report');
	}	
}

async function payergrouplookup(payer_group,option){	
	var formObj=document.BLReprintReport;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var title=getLabel("eBL.PAYER_GROUP.label","BL");
	var locale=formObj.locale.value;
	var query='';
	var payerdesc=formObj.payerdesc.value;
	
	if( (option=='BLUR')  && (payer_group.value=='')){
	formObj.payer_group.value= "";
	formObj.payerdesc.value="";	
	return;
	}
	
/*
 * if( (option=='BLUR') && (cust_desc.value!='')){ query="select cust_code code,
 * short_name description from ar_customer_lang_vw where
 * language_id='"+locale+"' and (status is null or status <> 'S') and
 * upper(cust_code) like upper(?) and upper(short_name) like upper(?) order by
 * 2"; }else{ query= "select '**' code , 'All Payers' description from dual
 * union all select cust_code code, short_name description from
 * ar_customer_lang_vw where language_id='"+locale+"' and (status is null or
 * status <> 'S') and upper(cust_code) like upper(?) and upper(short_name) like
 * upper(?) order by 2"; }
 */
	query= "SELECT code , description from ( select cust_group_code code, short_desc description  FROM ar_cust_group_lang_vw WHERE language_id = '"+locale+"' AND status IS NULL) where upper(code) like upper(?)  and upper(description) like upper(?)";
	
	argumentArray[0]	= query;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = payer_group.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	retVal = await CommonLookup( title, argumentArray );
	
 	if(retVal != null && retVal != ""){
   		
		formObj.payer_group.value= retVal[0];
		formObj.payerdesc.value= retVal[0];		
		// eval("formObj.oldKey"+index).value=trimString(cust_grp_code.value+"~~"+retVal[0]);
 	}else{
   		
		formObj.payer_group.value= "";
		formObj.payerdesc.value="";		
		// eval("formObj.oldKey"+index).value="";
 	}	
}

async function custLookUp(cust_desc,option){	
	var formObj=document.BLReprintReport;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var title=getLabel("Common.Payer.label","BL");
	var locale=formObj.locale.value;
	var payer_group=$("#payer_group").val();
	
	var query='';

	if( (option=='BLUR')  && (cust_desc.value=='')){
	formObj.cust_code.value= "";
	formObj.cust_desc.value="";	
	return;
	}
	
/*
 * if( (option=='BLUR') && (cust_desc.value!='')){ query="select cust_code code,
 * short_name description from ar_customer_lang_vw where
 * language_id='"+locale+"' and (status is null or status <> 'S') and
 * upper(cust_code) like upper(?) and upper(short_name) like upper(?) order by
 * 2"; }else{ query= "select '**' code , 'All Payers' description from dual
 * union all select cust_code code, short_name description from
 * ar_customer_lang_vw where language_id='"+locale+"' and (status is null or
 * status <> 'S') and upper(cust_code) like upper(?) and upper(short_name) like
 * upper(?) order by 2"; }
 */
	query= "Select code ,description from (SELECT '**' code, 'All Payers' description FROM DUAL UNION SELECT cust_code code, short_name description FROM ar_customer_lang_vw  WHERE language_id = 'en' and cust_group_code = nvl('"+payer_group+"',cust_group_code) AND (status IS NULL OR status <> 'S')) where upper(code) like upper(?)  and upper(description) like upper(?) order by 2";
	
	argumentArray[0]	= query;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = cust_desc.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;
	retVal = await CommonLookup( title, argumentArray );
	
 	if(retVal != null && retVal != ""){
   		
		formObj.cust_code.value= retVal[0];
		formObj.cust_desc.value= retVal[0];		
		// eval("formObj.oldKey"+index).value=trimString(cust_grp_code.value+"~~"+retVal[0]);
 	}else{
   		
		formObj.cust_code.value= "";
		formObj.cust_desc.value="";		
		// eval("formObj.oldKey"+index).value="";
 	}	
}


function search()
{
//	alert("3");
	//parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=&err_value=";
	parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=&err_value=";
		
	var frm  = document.BLReprintReport;
	var from_bill_number_code=frm.from_bill_number_code.value;					
	var from_bill_number=frm.from_bill_number.value;	
	var to_bill_number=frm.to_bill_number.value;
	var from_bill_date=frm.from_bill_date.value;
	var to_bill_date=frm.to_bill_date.value;
	var to_bill_number_code=frm.to_bill_number_code.value;
	var episode_type=frm.episode_type.value;
	var bill_type=frm.bill_type.value;
	var patientId = frm.patient_id.value;
	var episodeId = frm.episode_id.value;
	var visitId = frm.visit_id.value;
	var custcode = frm.cust_desc.value;
	var outStdOnly = 'N';
	var payer_group=frm.payer_group.value;
	var payer_type=frm.payer_type.value;
	var site_spec=frm.site_spec.value;//V210624
	if(site_spec=='true' || site_spec==true){  //V210624
		var language_option=frm.language_option.value; //V210405
	}
	
	
	var zerobill;
	var site3TierAlmoFeatureYN = frm.site3TierAlmoFeatureYN.value;//Added V200415 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1

	if ($('#zerobill').is(':checked'))
	{	
		zerobill='I'
	}
	else
		{
		zerobill='E';
		}
	
	
	//if((($.trim($('#site_id').val()) == 'ALMO') || ($.trim($('#site3TierAlmoFeatureYN').val()) == 'Y')) && ($.trim($('#demo_version').val()) == 'Y')) { 	//Added V200415 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	if((($.trim($('#site_id').val()) == 'ALMO') || ($.trim($('#site3TierAlmoFeatureYN').val()) == 'Y'))) {//removed demo_version against V210603
		if (patientId == "") {
			if(from_bill_date =='' || to_bill_date ==''){
				alert("Date cannot be blank");
				return false;
			}
		}
	}
	if(patientId == ""){
	// Added V170712-Gayathri/65520/starts
		if(from_bill_date ==''){
			alert(getMessage("BL00949","BL"));
		return false;
		}
		else if(to_bill_date ==''){
			alert(getMessage("BL00950","BL"));
		return false;	
		}
	
// Added V170712-Gayathri/65520/ends
	if(from_bill_date != '' && to_bill_date != ''){
		var starr = from_bill_date.split("/");
		var enarr = to_bill_date.split("/");
		var startdt = new Date();
		var enddt = new Date();		
		startdt.setFullYear(starr[2], starr[1]-1, starr[0]);
		enddt.setFullYear(enarr[2], enarr[1]-1, enarr[0]);
		var timeDiff;
		var daysDiff;
		timeDiff = enddt.getTime() - startdt.getTime();
		daysDiff =  Math.floor(timeDiff / (1000 * 60 * 60 * 24));
				
	if(daysDiff > 30 )
		{
				alert("Bill To Date Cannot be greater than 31 Days from Bill from Date");
				return false;
		}		
}	
}

if($('#outStdOnly').is(':checked')){	
	outStdOnly = 'Y';
}

if($('#saveSearchCriteria').is(':checked')){
    	$('input:text').each(function(){
    		$(this).attr('dflt_srch_value','Y');
    	});
    	$('select').each(function(){
    		$(this).attr('dflt_srch_value','Y');
    	});

    	$('#from_bill_number_code').attr('dflt_srch_value','Y');   
    	$('#to_bill_number_code').attr('dflt_srch_value','Y');
    	$('#dtlPrint').attr('dflt_srch_value','Y');
    	$('#outStdOnly').attr('dflt_srch_value','Y');
    	$('#consolidatedBillSettlement').attr('dflt_srch_value','Y');
    	
    	
    	fnAutoFillSaveCriteria('EBL_REPRINT_REPORT');
    }	
	//dummy_frame.location.href='../../eCommon/jsp/process.jsp';
	
	
	/*
	parent.body_frame.location.href="../../eBL/jsp/BLReprintProcess.jsp?from_bill_number_code="+from_bill_number_code+"&to_bill_number_code="+to_bill_number_code+
									"&from_bill_number="+from_bill_number+"&to_bill_number="+to_bill_number+
									"&from_bill_date="+from_bill_date+"&to_bill_date="+to_bill_date+
									"&episode_type="+episode_type+"&bill_type="+bill_type+"&patientId="+patientId+
									"&episodeId="+episodeId+"&visitId="+visitId+"&outStdOnly="+outStdOnly+"&cust_code="+custcode+
									"&payer_group="+payer_group+"&payer_type="+payer_type+"&zerobill="+zerobill; */ //commented against V210405
	 //V210624 Starts
	if(site_spec=='true' || site_spec==true){  
		parent.body_frame.location.href="../../eBL/jsp/BLReprintProcess.jsp?from_bill_number_code="+from_bill_number_code+"&to_bill_number_code="+to_bill_number_code+
		"&from_bill_number="+from_bill_number+"&to_bill_number="+to_bill_number+
		"&from_bill_date="+from_bill_date+"&to_bill_date="+to_bill_date+
		"&episode_type="+episode_type+"&bill_type="+bill_type+"&patientId="+patientId+
		"&episodeId="+episodeId+"&visitId="+visitId+"&outStdOnly="+outStdOnly+"&cust_code="+custcode+
		"&payer_group="+payer_group+"&payer_type="+payer_type+"&zerobill="+zerobill+"&language_option="+language_option;//V210405

	}else{
		parent.body_frame.location.href="../../eBL/jsp/BLReprintProcess.jsp?from_bill_number_code="+from_bill_number_code+"&to_bill_number_code="+to_bill_number_code+
		"&from_bill_number="+from_bill_number+"&to_bill_number="+to_bill_number+
		"&from_bill_date="+from_bill_date+"&to_bill_date="+to_bill_date+
		"&episode_type="+episode_type+"&bill_type="+bill_type+"&patientId="+patientId+
		"&episodeId="+episodeId+"&visitId="+visitId+"&outStdOnly="+outStdOnly+"&cust_code="+custcode+
		"&payer_group="+payer_group+"&payer_type="+payer_type+"&zerobill="+zerobill;

	}
	
	 //V210624 Ends
	

	//parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';	
}

// Added by Rajesh V
function trimString(sInString) {
	  return sInString.replace(/^\s+|\s+$/g,"");
}

function highlightRow(obj,qryClass){
	var frm =  document.resultForm;
	var rowClicked = frm.rowClicked.value;
	if(rowClicked != obj){
		
		if(rowClicked.length>0){
			$('#row'+rowClicked+' td' ).each(function(){
				$(this).attr('class','label');
			});	
			
			$('#row'+rowClicked+' td span' ).each(function(){
				$(this).attr('class','LABEL');
			});	
		}	
		
		$('#row'+obj+' td' ).each(function(){
			$(this).attr('class','LocalYellow');
			//Added by Jeyachitra for edge support
			//this.style.setProperty('padding-left', '3px', 'important');
			this.style.setProperty('padding-right', '0px', 'important');
			var img = $(this).find('#imgArrow' + obj)[0]; 
		    if (img) 
		    {
		        img.style.setProperty('padding-right', '3px', 'important');
		    }
			
		});
		
		$('#row'+obj+' td span' ).each(function(){
			$(this).attr('class','SpanYellow');
			
		});		
		
		frm.docType.value = document.getElementById("doc_typ_code"+obj).value;	
		frm.documentNumber.value = document.getElementById("doc_num"+obj).value;		
		frm.documentDate.value = document.getElementById("doc_date"+obj).value;		
		frm.billedAmount.value = document.getElementById("bill_tot_amt"+obj).value;		
		frm.patientId.value = document.getElementById("patient_id"+obj).value;
		// Karthik Commented to Remove Billing class code
		// frm.billingClassCode.value =
		// document.getElementById("bill_nat_code"+obj).value;
		frm.billingGroup.value = document.getElementById("bill_grp_id"+obj).value;
		frm.payerCode.value = document.getElementById("payer_code"+obj).value;
		frm.episodeType.value = document.getElementById("episode_type"+obj).value;
		frm.episodeId.value = document.getElementById("episode_id"+obj).value;
		frm.visitId.value = document.getElementById("visit_id"+obj).value;
		// frm.billPrintFlag.value =
		// document.getElementById("bill_print_flag"+obj).value;		
	}	
	frm.rowClicked.value = obj;
}

function tooltip(obj,indx){
	var table;
	
	table = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center' style='background-color:#E7E7E7 !important;'> ";
	// Karthik changed to use Billing class code (bill_nat_code) as hidden
	//if($.trim($('#bill_outstd_amt'+indx).text()) >= 0 && $.trim($('#bill_nat_code'+indx).val()) == 'C' && ( $.trim($('#site_id').val()) == 'ALMO' || $.trim($('#site3TierAlmoFeatureYN').val())== 'Y') && ($.trim($('#demo_version').val()) == 'N')) { //Added V200415 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1
	if($.trim($('#bill_outstd_amt'+indx).text()) >= 0 && $.trim($('#bill_nat_code'+indx).val()) == 'C' && ( $.trim($('#site_id').val()) == 'ALMO' || $.trim($('#site3TierAlmoFeatureYN').val())== 'Y')) { //removed demo_version against V210603
		table += "<tr> "+
					"<td class = 'contextMenuItem' onmouseOver='highlightDynamicTd(this)' onmouseOut='removeHighlight(this)' style='cursor:pointer' nowrap onclick='billSettlement("+indx+")'>" +
						"Bill Settlement "+
					"</td> "+
				"</tr> ";
	}
	
	var billTotAmtVal=$('#bill_tot_amt'+indx).text();
	//if((($.trim($('#site_id').val()) == 'ALMO') || ($.trim($('#site3TierAlmoFeatureYN').val()) == 'Y')) && ($.trim($('#demo_version').val()) == 'Y')){ //Added V200415 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	if((($.trim($('#site_id').val()) == 'ALMO') || ($.trim($('#site3TierAlmoFeatureYN').val()) == 'Y'))) { //removed demo_version against V210603
	
	table += "<tr> "+
	"<td class = 'contextMenuItem' onmouseOver='highlightDynamicTd(this)' onmouseOut='removeHighlight(this)' style='cursor:pointer' nowrap onclick='cancelSingleBill("+indx+")'>" +
			"Cancel"+
		"</td> "+
	"</tr> ";
	
		
	table += "<tr> "+
		"<td class = 'contextMenuItem' onmouseOver='highlightDynamicTd(this)' onmouseOut='removeHighlight(this)' style='cursor:pointer' nowrap onclick='reprintSingleBill("+indx+")'>" +
			"Reprint Bill"+
		"</td> "+
	"</tr> ";
		
	}
	else{

		table += "<tr> "+
					"<td class = 'contextMenuItem' onmouseOver='highlightDynamicTd(this)' onmouseOut='removeHighlight(this)' style='cursor:pointer' nowrap onclick='reprintSingleBill("+indx+")'>" +
						"Print"+
					"</td> "+
				"</tr> ";
		
	}
	if(($.trim($('#setlmt_ind'+indx).val()) =="X") && ($.trim($('#insBillAmt'+indx).val()) >0) && ($.trim($('#eSignYN').val()) == 'Y')){ //V221117
		table += "<tr> "+
					"<td class = 'contextMenuItem' onmouseOver='highlightDynamicTd(this)' onmouseOut='removeHighlight(this)' style='cursor:pointer' nowrap onclick='openESign("+indx+")'>" +
						"Patient E-Signature"+
					"</td> "+
				"</tr> ";
	}//V221107
       			"</table>";
		
		document.getElementById('t').innerHTML = table;
		resizeWindow(obj);
	
}

async function showAuthoriseWindow() {
	var locale = $('#locale').val();
	var dialogHeight= "40vh" ;
	var dialogWidth	= "30vw" ;
	var dialogTop = "" ;
	var center = "1" ;														   
	var status="no";
	var overflow = "hidden";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;		
	
	var hdrFrm = parent.search_hdr.document.BLReprintReport;
	var facilityId=hdrFrm.facility_id.value;
	
	 var retVal = await window.showModalDialog("../../eBL/jsp/BLFinDetailsAuthoriseMain.jsp?mode=s&called_frm=EBL_TRANS_SETL_REPRNT",arguments,features);
	 return retVal;
}

async function cancelAll(indx) {
	
	
	parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=&err_value=";
	 var episodeType = $.trim($('#episode_type'+indx).text());
	 var hdrFrm = parent.search_hdr.document.BLReprintReport;
	 var facilityId=hdrFrm.facility_id.value;
	 var episodeType=hdrFrm.episode_type.value;
	 var selectedFrameDoc = parent.selectedFrame.document;
	 var lastIndex = $(selectedFrameDoc).find('#indexTrack').val();
	
	if(lastIndex == 'undefined' || lastIndex == undefined||lastIndex== '0'){
		alert('Please Select atleast one bill for Cancel');
		return false;
	}
	
	
$.ajax({
		
		type:"GET",
		url:"../../eBL/jsp/BLCashCounterValidation.jsp",
		data:"&facilityId="+facilityId+"&episode_type="+episodeType,	
		
		success: async function(data){
			if(data.indexOf('<!DOCTYPE html>')!=-1)
				data =  data.replace(/<!DOCTYPE html>/gi, "");
			if(trimString(data)=='success'){
			
			var doAuth=true;
			retVal= await showAuthoriseWindow();
		
			if(retVal[2]=='undefined'||retVal[2]==undefined){
				retVal[2]='';
				}	
	var params="";
	var params_cancel="";
	var hdrFrm = parent.search_hdr.document.BLReprintReport;
	var facilityId=hdrFrm.facility_id.value;
	
	var selectedFrameDoc = parent.selectedFrame.document;
	var totalRows = $(selectedFrameDoc).find('#indexTrack').val();
	for(var i=1;i<=totalRows;i++) {
				
		params=params+"&billdocType"+i+"="+parent.selectedFrame.document.getElementById("doc_typ_code"+i).value;
		params=params+"&billdocNum"+i+"="+parent.selectedFrame.document.getElementById("doc_num"+i).value;
		
		params_cancel=params_cancel+"&doc_typ_code"+i+"="+parent.selectedFrame.document.getElementById("doc_typ_code"+i).value;
		params_cancel=params_cancel+"&doc_num"+i+"="+parent.selectedFrame.document.getElementById("doc_num"+i).value;
		params_cancel=params_cancel+"&episode_type"+i+"="+parent.selectedFrame.document.getElementById("episode_type"+i).value;
		params_cancel=params_cancel+"&facility_id"+i+"="+facilityId;
		
	}
	params_cancel=params_cancel+"&lastRowIndex="+totalRows+"&cancel_reason_code="+retVal[2]+"&login_user="+retVal[4];

	if(retVal[0]=="Y"){
		
		var temp_jsp="../../eBL/jsp/BLCancelPackageValidation.jsp?action=submit?&facilityId="+facilityId+""+params+"&totalRows="+totalRows;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;		

		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		window.close();
		var reopenFlag=$.trim(xmlHttp.responseText);
		
		var confirmFlag='';
		if(reopenFlag=='Y') {
			confirmFlag=  window.confirm("Cancelling the bill will Re-open the package.Confirm?"); 
		}
		else cancelMultipleBill(params_cancel);
		
		
		if(confirmFlag) await cancelMultipleBill(params_cancel);
		
		}
			}
		
else
	{
	parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+data+"&err_value=Error"
	}
}
});
	}

function cancelMultipleBill(params_cancel) {
	var frm  = parent.search_hdr.document.BLReprintReport;
	var from_bill_number_code=frm.from_bill_number_code.value;					
	var from_bill_number=frm.from_bill_number.value;	
	var to_bill_number=frm.to_bill_number.value;
	var from_bill_date=frm.from_bill_date.value;
	var to_bill_date=frm.to_bill_date.value;
	var to_bill_number_code=frm.to_bill_number_code.value;
	var episode_type=frm.episode_type.value;
	var bill_type=frm.bill_type.value;
	var patientId = frm.patient_id.value;
	var episodeId = frm.episode_id.value;
	var visitId = frm.visit_id.value;
	var custcode = frm.cust_desc.value;
	var outStdOnly = "";

if($(parent.search_hdr.document).find('#outStdOnly').is(':checked')){
	
	outStdOnly = 'Y';
}else{
	outStdOnly = 'N';
}
	
	var payer_group=frm.payer_group.value;
	var payer_type=frm.payer_type.value;
	var zerobill;
	if ($(parent.search_hdr.document).find('#zerobill').is(':checked'))
	{	
		zerobill='I'
	}
	else
		{
		zerobill='E';
		}
	parent.dummy_frame.location.href='../../eCommon/jsp/process.jsp';
	
	$.ajax({
		type:"POST",
		url:"../../servlet/eBL.BLCancelRecordServlet?"+params_cancel,
		success: function(data){
			var hdrFrm = parent.search_hdr.document.BLReprintReport;
			var dummyDoc = parent.dummy_frame.document;
			var session='';
			var pgm_date='';
			var pgm_id='';
			var errorId=$.trim(data);
			
			
			var retVal = trimString(data).split(":::");
			
			
			
			if(retVal[0]=='Y')
			{
				pgm_id = retVal[1];
				session_id = retVal[2];
				pgm_date = retVal[3];
				var htmlVal = "<html><body>";
				htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
				htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+hdrFrm.facility_id.value+"'>";
			    htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+hdrFrm.locale.value+"'>";
			
				htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+pgm_id+"'>";
				htmlVal += "<input type='hidden' name='session_id' id='session_id' value='"+session_id+"'>";
				htmlVal += "<input type='hidden' name='pgm_date' id='pgm_date' value='"+pgm_date+"'>";
				htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+hdrFrm.p_module_id.value+"'>";
				htmlVal += "<input type='hidden' name='pgm_id' id='pgm_id' value='"+pgm_id+"'>";
				
				htmlVal += "</form></body></html>";
				
				dummyDoc.body.insertAdjacentHTML("afterbegin",htmlVal);
				dummyDoc.dummy_frm.action="../../eCommon/jsp/report_options.jsp";
				dummyDoc.dummy_frm.target="messageFrame";
				dummyDoc.dummy_frm.submit();
				 
				parent.body_frame.location.href="../../eBL/jsp/BLReprintProcess.jsp?from_bill_number_code="+from_bill_number_code+"&to_bill_number_code="+to_bill_number_code+
			"&from_bill_number="+from_bill_number+"&to_bill_number="+to_bill_number+
			"&from_bill_date="+from_bill_date+"&to_bill_date="+to_bill_date+
			"&episode_type="+episode_type+"&bill_type="+bill_type+"&patientId="+patientId+
			"&episodeId="+episodeId+"&visitId="+visitId+"&outStdOnly="+outStdOnly+"&cust_code="+custcode+
			"&payer_group="+payer_group+"&payer_type="+payer_type+"&zerobill="+zerobill;			
								
			
				parent.selectedFrame.location.href='../../eBL/jsp/BLReprintSelected.jsp';
				
				
				
				//parent.messageFrame1.location.href="../../eCommon/jsp/error.jsp?err_num="+"APP-SM0070 Operation Completed Successfully ...."+"&err_value=Error";
				parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+"APP-SM0070 Operation Completed Successfully ...."+"&err_value=Error";
				
			

				
				}
			else if(retVal[0]=='N')
			{
				
				parent.dummy_frame.location.href = '../../eCommon/html/blank.html';	
				var i =0;
				var j=1;
				var allError="";
				var err = retVal[1].split("<<");
				for(i=0 ; i<(err.length)-1;i++)
				{
					if(err[i]!='10'){
						allError+=err[i]+'\n';
						}				
					}		
					
				setTimeout(function(){alert(allError)}, 100)	
			
					return;
					
				}
				
			
		},
		 error: function(data){	
	      }
	});	
}

function showBtn(service) {
	
	if(service=='P') {
		parent.buttonFrame.document.getElementById("btnCancel").display="none";
		// alert(parent.buttonFrame.$("#btnCancel"));
		parent.buttonFrame.$("#btnCancel").hide();
		parent.buttonFrame.$("#btnReprint").show();
	}
	else if(service=='C') {
		parent.buttonFrame.document.getElementById("btnReprint").display="none";
		parent.buttonFrame.$("#btnReprint").hide();
		parent.buttonFrame.$("#btnCancel").show();
	}
	// alert( "APP-SM0070 Operation Completed Successfully ....");
}

function cancelSingleBill(indx){
	hideToolTip();
	//parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=&err_value=";
	parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=&err_value=";
	var docTypeCode = $.trim($('#doc_typ_code'+indx).text());
	var docNum = $.trim($('#doc_num'+indx).text());
	var episodeType = $.trim($('#episode_type'+indx).text());
	var strOperatingFacilityId = document.getElementById("strOperatingFacilityId"+indx).value; //V210129
	var locale = $('#locale').val();
	var dialogHeight= "40vh" ;
	var dialogWidth	= "30vw" ;
	var dialogTop = "" ;
	var center = "1" ;			
	
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;		
	
	var hdrFrm = parent.search_hdr.document.BLReprintReport;
	var facilityId=hdrFrm.facility_id.value;
	$.ajax({
		
		type:"GET",
		url:"../../eBL/jsp/BLCashCounterValidation.jsp",
		data:"&facilityId="+facilityId+"&episode_type="+episodeType,	
		
		success: async function(data){
			
			if(data.indexOf('<!DOCTYPE html>')!=-1)
				data =  data.replace(/<!DOCTYPE html>/gi, "");
			if(trimString(data)=='success'){
			 var retVal = await window.showModalDialog("../../eBL/jsp/BLFinDetailsAuthoriseMain.jsp?mode=s&called_frm=EBL_TRANS_SETL_REPRNT",arguments,features);
			 var doAuth=true;
			 var cancelReasonCode=retVal[2];
			 var login_user=retVal[4];
	 
			 if(cancelReasonCode=='undefined'||cancelReasonCode==undefined){
				 cancelReasonCode='';
			 }
	if(retVal[0]=="Y"){
		
		var temp_jsp="../../eBL/jsp/BLCancelPackageValidation.jsp?action=submit?&facilityId="+facilityId+"&billdocType1="+docTypeCode+"&billdocNum1="+docNum+"&totalRows=1";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;		


		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);	// any XML object can also be sent as a
								// parameter

		window.close();
		var reopenFlag=$.trim(xmlHttp.responseText);
		
		var confirmFlag='';
		if(reopenFlag.indexOf('<!DOCTYPE html>')!=-1)
		{
			reopenFlag = reopenFlag.replace(/<!DOCTYPE html>/gi, "");
			reopenFlag= trimString(reopenFlag);
		}
		if(reopenFlag=='Y') {
			confirmFlag=window.confirm("Cancelling the bill will Re-open the package.Confirm?"); 
		}
		else cancelBill(docTypeCode,docNum,episodeType,cancelReasonCode,login_user,strOperatingFacilityId); //V210129
		
		
		
		if(confirmFlag) cancelBill(docTypeCode,docNum,episodeType,cancelReasonCode,login_user,strOperatingFacilityId); //V210129
	}
	
			}
			else
				{
				parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+data+"&err_value=Error"
				}
		}
	});
	}


function cancelBill(docTypeCode,docNum,episodeType,cancelReasonCode,login_user,facility_id) { //V210129
	var frm  = parent.search_hdr.document.BLReprintReport;
	var from_bill_number_code=frm.from_bill_number_code.value;					
	var from_bill_number=frm.from_bill_number.value;	
	var to_bill_number=frm.to_bill_number.value;
	var from_bill_date=frm.from_bill_date.value;
	var to_bill_date=frm.to_bill_date.value;
	var to_bill_number_code=frm.to_bill_number_code.value;
	var episode_type=frm.episode_type.value;
	var bill_type=frm.bill_type.value;
	var patientId = frm.patient_id.value;
	var episodeId = frm.episode_id.value;
	var visitId = frm.visit_id.value;
	var custcode = frm.cust_desc.value;
	var outStdOnly = "";
	
	if($(parent.search_hdr.document).find('#outStdOnly').is(':checked')){
		
		outStdOnly = 'Y';
	}else{
		outStdOnly = 'N';
	}
	

	var payer_group=frm.payer_group.value;
	var payer_type=frm.payer_type.value;
	var zerobill;
	if ($(parent.search_hdr.document).find('#zerobill').is(':checked'))
		{	
		zerobill='I'
		}
	else
		{
		zerobill='E';
		}
	
	var selectedFrameDoc = parent.selectedFrame.document;
	var reportId = parent.search_hdr.document.BLReprintReport.p_report_id.value;
	var lastIndex =  $(selectedFrameDoc).find('#indexTrack').val();
	parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=&err_value=";
	parent.document.getElementById('dummy_frame').contentDocument.location.href='../../eCommon/jsp/process.jsp';
	
		$.ajax({
		type:"POST",
		url:"../../servlet/eBL.BLCancelRecordServlet?mode=single&doc_typ_code1="+docTypeCode+"&doc_num1="+docNum+"&episode_type1="+episodeType+"&cancel_reason_code="+cancelReasonCode+"&lastRowIndex=1"+"&login_user="+login_user+"&facility_id1="+facility_id, //V210129
		success: function(data){
			var hdrFrm = parent.search_hdr.document.BLReprintReport;
			var dummyDoc = parent.document.getElementById('dummy_frame');
			var session='';
			var pgm_date='';
			var pgm_id='';
			var errorId=$.trim(data);
			var retVal = trimString(data).split(":::");
			if(retVal[0]=='Y'){
				pgm_id = retVal[1];
				session_id = retVal[2];
				pgm_date = retVal[3];
			

			
				var htmlVal = "<html><body>";
				htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
				htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+hdrFrm.facility_id.value+"'>";
			    htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+hdrFrm.locale.value+"'>";
				htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+pgm_id+"'>";
				htmlVal += "<input type='hidden' name='session_id' id='session_id' value='"+session_id+"'>";
				htmlVal += "<input type='hidden' name='pgm_date' id='pgm_date' value='"+pgm_date+"'>";
				htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+hdrFrm.p_module_id.value+"'>";
				htmlVal += "<input type='hidden' name='pgm_id' id='pgm_id' value='"+pgm_id+"'>";
				
				htmlVal += "</form></body></html>";
				
				dummyDoc.contentDocument.body.insertAdjacentHTML("afterbegin",htmlVal);
				dummyDoc.contentDocument.dummy_frm.submit();
				
				parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+"APP-SM0070 Operation Completed Successfully ...."+"&err_value=Error";
				
				parent.body_frame.location.href="../../eBL/jsp/BLReprintProcess.jsp?from_bill_number_code="+from_bill_number_code+"&to_bill_number_code="+to_bill_number_code+
				"&from_bill_number="+from_bill_number+"&to_bill_number="+to_bill_number+
				"&from_bill_date="+from_bill_date+"&to_bill_date="+to_bill_date+
				"&episode_type="+episode_type+"&bill_type="+bill_type+"&patientId="+patientId+
				"&episodeId="+episodeId+"&visitId="+visitId+"&outStdOnly="+outStdOnly+"&cust_code="+custcode+
				"&payer_group="+payer_group+"&payer_type="+payer_type+"&zerobill="+zerobill;
				
				}
			else if(retVal[0]=='N'){
				var allError="";
				var i =0;
				var allError="";
				var err = retVal[1].split("<<");
				for(i=0 ; i<(err.length)-1;i++)
				{
					allError+=err[i]+'\n';
				}		
				parent.dummy_frame.location.href = '../../eCommon/html/blank.html';	
				//parent.messageFrame1.location.href="../../eCommon/jsp/error.jsp?err_num="+allError+"&err_value=Error";
				/*console.log(parent);
				console.log(parent.parent);*/
				/*console.log(parent.messageFrame1.location.href="../../eCommon/jsp/error.jsp?err_num="+allError+"&err_value=Error");
				console.log(parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+allError+"&err_value=Error");*/
				
				parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+allError+"&err_value=Error";
			}
			
				
			
		},
		
		 error: function(data)
		 {
	      }
	});
	
	
}
function insertConsolidatedBill(indx)
{
	
	var params="";
var docTypeCode = $.trim($('#doc_typ_code'+indx).text());
var docNum = $.trim($('#doc_num'+indx).text());
var docDate = $.trim($('#doc_date'+indx).text());
var billTotAmt = $.trim($('#bill_tot_amt'+indx).text());
var totOutStdAmt = $.trim($('#bill_outstd_amt'+indx).text());	

var patientId = $.trim($('#patient_id'+indx).text());
var episodeType = $.trim($('#episode_type'+indx).text());
var episodeId = $.trim($('#episode_id'+indx).text());
var visitId = $.trim($('#visit_id'+indx).text());

var totSetAmt = 0;
var selectedFrameDoc = parent.selectedFrame.document;

$(selectedFrameDoc).find('[id^=rem_slmt_amt]').each(function(){
	totSetAmt = parseFloat(totSetAmt)+parseFloat($(this).val());
});

if(totSetAmt == 0){
	alert(getMessage('BL8012','BL'));
	return false;
}

var trlast = $(parent.selectedFrame.document).find('#tblSelectedReport tr:last');
var hdrFrm  = parent.search_hdr.document.BLReprintReport;
var episodeType=hdrFrm.episode_type.value;
var facilityId=hdrFrm.facility_id.value;
 var selectedFrameDoc = parent.selectedFrame.document;
 var totalRows = $(selectedFrameDoc).find('#indexTrack').val();
 var negative = 'N';
 $(selectedFrameDoc).find('[id^=bill_outstd_amt]').each(function(){
	 if($(this).val()<0){
		negative ='Y';
	}
 });
 $(selectedFrameDoc).find('[id^=patient_id]').each(function(){
	 patientId = $(this).val();	
 });
 var bool =true ;

		/*
		 * if(negative=='Y'){ $.ajax({ async:false, type:"POST",
		 * url:"../jsp/BLRefundValidation.jsp",
		 * data:"&patientId="+patientId+"&facilityId="+facilityId,
		 * dataType:"text", success: function(data){ var retValue= $.trim(data);
		 * if(retValue=='Y'){ bool = false; //alert("Patient has not paid
		 * his/her outstanding bill,cannot proceed");
		 * alert(getMessage('BL5201','BL')); return false; } }, error:
		 * function(data){
		 *  } }); }
		 */
		if(bool){
		for(var i=1;i<=totalRows;i++) {
			
			params=params+"&billdocType"+i+"="+selectedFrameDoc.getElementById("doc_typ_code"+i).value;

			params=params+"&billdocNum"+i+"="+parent.selectedFrame.document.getElementById("doc_num"+i).value;
			params=params+"&billdocDate"+i+"="+parent.selectedFrame.document.getElementById("doc_date"+i).value;
			params=params+"&billTotalAmt"+i+"="+parent.selectedFrame.document.getElementById("bill_tot_amt"+i).value;
			params=params+"&billtotOutStdAmt"+i+"="+parent.selectedFrame.document.getElementById("bill_outstd_amt"+i).value;
			params=params+"&patient_id"+i+"="+parent.selectedFrame.document.getElementById("patient_id"+i).value;
			params=params+"&episode_type"+i+"="+parent.selectedFrame.document.getElementById("episode_type"+i).value;
			params=params+"&episode_id"+i+"="+parent.selectedFrame.document.getElementById("episode_id"+i).value;
			params=params+"&visit_id"+i+"="+parent.selectedFrame.document.getElementById("visit_id"+i).value;
			params=params+"&excempted_amt"+i+"="+parent.selectedFrame.document.getElementById("excempted_amt"+i).value;
			params=params+"&encounterFacilityId"+i+"="+parent.selectedFrame.document.getElementById("encounterFacilityId"+i).value;

			params=params+"&rem_slmt_amt"+i+"="+$(selectedFrameDoc).find("#rem_slmt_amt"+i).val();// parent.selectedFrame.document.getElementById("rem_slmt_amt"+i).value;
			if($(selectedFrameDoc).find('#bill_print_yn'+i).prop('checked')){
				params=params+"&bill_print_yn"+i+"=Y";
			}
			else{
				params=params+"&bill_print_yn"+i+"=N";
			}
			
		}
		var userSlmtAmt = '';
		$.ajax({
			
			type:"POST",
			url:"../jsp/BLBillDetailsPersistance.jsp",
			data:" &totalRows="+totalRows+"&params="+params,	
			dataType:"text",
			success: function(data){	
				userSlmtAmt = $.trim(data);
				var retVal;
				while(retVal===undefined){

				var billdoctype=parent.selectedFrame.document.getElementById("doc_typ_code1").value;
				var billdocnum=parent.selectedFrame.document.getElementById("doc_num1").value;
				var blnggrp=parent.selectedFrame.document.getElementById("bill_grp_id1").value;
				
				var center='1';
				var dialogTop = "0vh";
				var dialogHeight = "92vh" ;
				var dialogWidth = "90vw" ;
				var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;
				var title=encodeURIComponent(title);	
				var arguments = "" ;
				var column_sizes = escape("");               
				var column_descriptions ="";
				var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+
							"&"+"billdoctypecode="+billdoctype+"&"+"billdocnum="+billdocnum+"&"+"blnggrp="+blnggrp+
							"&episode_type="+episodeType+"&userSlmtAmt="+userSlmtAmt+"&negative="+negative;

				retVal=window.showModalDialog("../../eBL/jsp/BLBillSlmtMainIRB.jsp?"+param,arguments,features);
				}
				
				if(retVal=='SUCCESS'){
				parent.selectedFrame.location.href='../../eBL/jsp/BLReprintSelected.jsp';
				parent.body_frame.location.reload();
				parent.buttonFrame.location.href= '../../eBL/jsp/BLReprintBtn.jsp';
					
					
				}
				
				
			},
			 error: function(data){

		     }
		});
		}
			
 

 
}
	async function reprintSingleBill(indx){
	hideToolTip();
	var docTypeCode = $.trim($('#doc_typ_code'+indx).text());
	var docNum = $.trim($('#doc_num'+indx).text());
	var docDate = $.trim($('#doc_date'+indx).text());
	var billTotAmt = $.trim($('#bill_tot_amt'+indx).text());
	var patientId = $.trim($('#patient_id'+indx).text());
	// Karthik Commented to Remove Billing class code
	// var billNatCode = $.trim($('#bill_nat_code'+indx).text());
	var billGrpId = $.trim($('#bill_grp_id'+indx).text());
	var payerCode = $.trim($('#payer_code'+indx).text());
	var episodeType = $.trim($('#episode_type'+indx).text());
	var episodeType = $.trim($('#episode_type'+indx).text());
	var episodeId = $.trim($('#episode_id'+indx).text());
	var visitId = $.trim($('#visit_id'+indx).text());
	/* Added by Karthik to include login user in Param 17 */
	var login_user =$('#login_user').val();
	// var billPrintFlag = $.trim($('#bill_print_flag'+indx).text());
	var site_id= document.getElementById('site_id').value;
	//var demo_version= document.getElementById('demo_version').value;//Commented against V210603
	
	var billPaidAmt = $.trim($('#bill_paid_amt'+indx).text());
	var totOutStdAmt = $.trim($('#bill_outstd_amt'+indx).text());	
	/*
	 * V12122017 Rajesh V Modified for MMS-QH-CRF-0208.1 Getting locale from
	 * search hdr instead of body frame
	 */
	var locale = $(parent.search_hdr.document).find('#locale').val(); // $('#locale').val();
	var reportId = parent.search_hdr.document.BLReprintReport.p_report_id.value;
	var siteSpecAuditReportYN = parent.search_hdr.document.BLReprintReport.siteSpecAuditReportYN.value; // Added
																										// V20180720-Subha/ML-MMOH-CRF-1173
	var login_user =  parent.search_hdr.document.BLReprintReport.strLoggedUser.value;// Added V20180720-Subha/ML-MMOH-CRF-1173
	var detailed_yn ='';
	var p_detailed_yn = parent.search_hdr.document.BLReprintReport.dtlPrint.checked;
	var site3TierAlmoFeatureYN = parent.search_hdr.document.BLReprintReport.site3TierAlmoFeatureYN.value; //Added V200415 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	
	var chk_print_stamp_YN = "N";

	if(parent.buttonFrame != null)
		chk_print_stamp_YN = parent.buttonFrame.document.getElementById("hid_chk_print_stamp_YN").value;  // Added for NMC-JD-CRF-0091
																									
		if(p_detailed_yn == true)
			 detailed_yn = 'Y';
		else
			 detailed_yn = 'N';	
	// billPrintFlag replaced to detailed_yn
		var dialogHeight= "30vh" ;
		var dialogWidth	= "20vw" ;
		var dialogTop = "225" ;
		var center = "1" ;														   
		var status="no";
		var overflow="hidden";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+";overflow:"+overflow;
		var arguments	= "" ;		
		var hdrFrm  = parent.search_hdr.document.BLReprintReport;		
		var facilityId=hdrFrm.facility_id.value;
		
		//if(((site_id=='ALMO') || (site3TierAlmoFeatureYN == 'Y')) && (demo_version == 'Y')){ //Added V200415 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
		if(((site_id=='ALMO') || (site3TierAlmoFeatureYN == 'Y'))) { 
		//removed demo_version against V210603
		
		var retVal = await window.showModalDialog("../../eBL/jsp/BLFinDetailsAuthoriseMain.jsp?mode=s&called_frm=EBL_TRANS_SETL_REPRNT&print=Y",arguments,features);
		 var doAuth=true;
		
		 if(retVal[0]=='Y')
{


	$.ajax({
		type:"GET",
		url:"../jsp/BLCommonReportValidation.jsp",
		data:"func_mode=ReprintReport &p_report_id="+reportId+
			"&param1="+docTypeCode+
			"&param2="+docTypeCode+
			"&param3="+docNum+
			"&param4="+docNum+
			"&param5="+

			"&param6="+detailed_yn+
			"&param7="+"R"+
			"&param8="+locale+
			"&param9="+
			"&param10="+
			
			"&param11="+
			"&param12="+
			"&param13="+
			"&param14="+episodeType,
		dataType:"text",
		async:false,
		success: function(data){
			var hdrFrm = parent.search_hdr.document.BLReprintReport;
			var dummyDoc = parent.document.getElementById('dummy_frame');
			var retVal = trimString(data).split(":::");
			var session_id = '';
			var pgm_date = '';
			// var report_id='BLRCANBL';
			// hdrFrm.p_report_id.value = retVal;
			if(retVal.length == 2){
				if(retVal[0].indexOf('<!DOCTYPE html>')!=-1)
				{
					retVal[0] = retVal[0].replace(/<!DOCTYPE html>/gi, "");
					retVal[0]= trimString(retVal[0]);
				}
				session_id = retVal[0];
				pgm_date = retVal[1];
			}
			var htmlVal = "<html><body>";
			htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
			htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+hdrFrm.facility_id.value+"'>";
			htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+hdrFrm.locale.value+"'>";
			htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+hdrFrm.p_report_id.value+"'>";
			htmlVal += "<input type='hidden' name='p_session_id' id='p_session_id' value='"+session_id+"'>";
			htmlVal += "<input type='hidden' name='p_pgm_date' id='p_pgm_date' value='"+pgm_date+"'>";
			htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+hdrFrm.p_module_id.value+"'>";
			htmlVal += "<input type='hidden' name='p_pgm_id' id='p_pgm_id' value='"+hdrFrm.p_report_id.value+"'>";
			htmlVal += "<input type='hidden' name='P_PRT_DIG_STAMP' id='P_PRT_DIG_STAMP' value='"+chk_print_stamp_YN+"'>"; // Added for NMC-JD-CRF-0091
			
			htmlVal += "</form></body></html>";

			//dummyDoc.contentDocument.body.insertAdjacentHTML("AfterBegin",htmlVal);
			dummyDoc.contentDocument.body.insertAdjacentHTML("afterbegin",htmlVal);
			dummyDoc.contentDocument.dummy_frm.submit();
			//dummyDoc.contentDocument.submit();
		},
		 error: function(data){

	      }
	});
}
		} // Added V20180720-Subha/ML-MMOH-CRF-1173
		 else if(siteSpecAuditReportYN == "Y"){
				var responseText = false;
				var functionIdInSMFunction = "EBL_TRANS_SETL_REPRNT";
				$.ajax({
					type:"POST", //V220413
					url:"../jsp/BLReprintAuditTrailReportAjax.jsp?facilityId=" + facilityId + "&userId=" + login_user +
					"&patientId=" +patientId + "&episodeType=" + episodeType+ "&episodeId=" +episodeId + "&visitId=" +visitId
					 + "&docTypeCode="+docTypeCode + "&docNum=" +docNum+ "&billTotAmt="+billTotAmt+ "&totOutStdAmt=" + totOutStdAmt + "&billDocDate="+docDate,
					data:"",
					dataType:"text",
					async:false,
					success: function(data){
						var splitVal = trimString(data).split("::::");
						if(splitVal.length == 2) {
							if(splitVal[0] == "10") {
								alert(splitVal[1]);
							} else {
								responseText = splitVal[0];
							}
						}
					},
					error: function(xhr, ajaxopt, err){
						
					}
				});
				if(responseText == true || responseText == 'true') {
				 $.ajax({
						type:"POST",//V220413
						url:"../jsp/BLCommonReportValidation.jsp",
						data:"func_mode=ReprintReport &p_report_id="+reportId+
							"&param1="+docTypeCode+
							"&param2="+docTypeCode+
							"&param3="+docNum+
							"&param4="+docNum+
							"&param5="+

							"&param6="+detailed_yn+
							"&param7="+"R"+
							"&param8="+locale+
							"&param9="+
							"&param10="+
							
							"&param11="+
							"&param12="+
							"&param13="+
							"&param14="+episodeType+
							"&param17="+login_user+
							"&param20="+functionIdInSMFunction,
						dataType:"text",
						async:false,
						success: function(data){
							var hdrFrm = parent.search_hdr.document.BLReprintReport;
							var dummyDoc = parent.parent.dummyFrame.document;
							var retVal = trimString(data).split(":::");
							var session_id = '';
							var pgm_date = '';
							if(retVal.length == 2){
								session_id = retVal[0];
								pgm_date = retVal[1];
							}
							var htmlVal = "<html><body>";
							htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
							htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+hdrFrm.facility_id.value+"'>";
							htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+hdrFrm.locale.value+"'>";
							htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+hdrFrm.p_report_id.value+"'>";
							htmlVal += "<input type='hidden' name='p_session_id' id='p_session_id' value='"+session_id+"'>";
							htmlVal += "<input type='hidden' name='p_pgm_date' id='p_pgm_date' value='"+pgm_date+"'>";
							htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+hdrFrm.p_module_id.value+"'>";
							htmlVal += "<input type='hidden' name='p_pgm_id' id='p_pgm_id' value='"+hdrFrm.p_report_id.value+"'>";
							htmlVal += "<input type='hidden' name='P_PRT_DIG_STAMP' id='P_PRT_DIG_STAMP' value='"+chk_print_stamp_YN+"'>"; // Added for NMC-JD-CRF-0091
							
							htmlVal += "</form></body></html>";

							dummyDoc.body.insertAdjacentHTML("afterbegin",htmlVal);
							dummyDoc.dummy_frm.submit();
						},
						 error: function(data){

					      }
					});

		} 
			 }// Added V20180720-Subha/ML-MMOH-CRF-1173
		 else{
			 $.ajax({
					type:"GET",
					url:"../jsp/BLCommonReportValidation.jsp",
					data:"func_mode=ReprintReport &p_report_id="+reportId+
						"&param1="+docTypeCode+
						"&param2="+docTypeCode+
						"&param3="+docNum+
						"&param4="+docNum+
						"&param5="+

						"&param6="+detailed_yn+
						"&param7="+"R"+
						"&param8="+locale+
						"&param9="+
						"&param10="+
						
						"&param11="+
						"&param12="+
						"&param13="+
						"&param14="+episodeType,
					dataType:"text",
					async:false,
					success: function(data){
						var hdrFrm = parent.search_hdr.document.BLReprintReport;
						var dummyDoc = parent.parent.dummyFrame.document;
						var retVal = trimString(data).split(":::");
						var session_id = '';
						var pgm_date = '';
						// var report_id='BLRCANBL';
						// hdrFrm.p_report_id.value = retVal;
						if(retVal.length == 2){
							session_id = retVal[0];
							pgm_date = retVal[1];
						}
						var htmlVal = "<html><body>";
						htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
						htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+hdrFrm.facility_id.value+"'>";
						htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+hdrFrm.locale.value+"'>";
						htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+hdrFrm.p_report_id.value+"'>";
						htmlVal += "<input type='hidden' name='p_session_id' id='p_session_id' value='"+session_id+"'>";
						htmlVal += "<input type='hidden' name='p_pgm_date' id='p_pgm_date' value='"+pgm_date+"'>";
						htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+hdrFrm.p_module_id.value+"'>";
						htmlVal += "<input type='hidden' name='p_pgm_id' id='p_pgm_id' value='"+hdrFrm.p_report_id.value+"'>";
						htmlVal += "<input type='hidden' name='P_PRT_DIG_STAMP' id='P_PRT_DIG_STAMP' value='"+chk_print_stamp_YN+"'>"; // Added for NMC-JD-CRF-0091
						
						htmlVal += "</form></body></html>";

						dummyDoc.body.insertAdjacentHTML("afterbegin",htmlVal);
						dummyDoc.dummy_frm.submit();
					},
					 error: function(data){

				      }
				});

			 
		 }
		 

}

async function billSettlement(indx){
	hideToolTip();
	 var dialogHeight    = '95vh' ;
	 var dialogWidth = '80vw' ;	
	 var dialogTop = '100' ;	 
	 var center    = '1'  ;	
	 var arguments =   '';
	 var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; center:' + center +'; dialogTop:' + dialogTop +'; status=no;';	

	 var doctype = $.trim($('#doc_typ_code'+indx).text());
	 var docnum = $.trim($('#doc_num'+indx).text());
	 var blnggrp = $.trim($('#bill_grp_id'+indx).text());
	 var genlater = 'Y';
	 var param="billdoctypecode="+doctype+"&"+"billdocnum="+docnum+"&"+"blnggrp="+blnggrp+"&"+"billgenlater="+genlater;
	
	 var getUrl1  = "../../eBL/jsp/BLReprintPopupPage.jsp?"+param
	 // var getUrl1 =
		// "../../eBL/jsp/BLChargePatientEncounterFrame.jsp?encounter_date=21/04/2014&encounter_id=101079180001&patient_id=DU00003900&blng_grp_id=CASH&episode_id=10107918&visit_id=1&episode_type=O&payerGroup=null&payer=null&policy=null&policyNum=null&acctSeqNum=1";

	 var retVal = await top.window.showModalDialog(getUrl1,arguments,features)
	
	 window.returnValue = 'Y';
	 window.close();
	 location.reload();
	// parent.search_hdr.document.getElementById('search_but').click();
}



/*function resizeWindow(orderctlHDR)
{
    var orderctlHDR1 = orderctlHDR.id;
	var wdth = document.getElementById(orderctlHDR1).offsetWidth;
	var hght1 =document.getElementById(orderctlHDR1).offsetHeight;		
	var wdth1 = getPos(orderctlHDR).x +wdth;
	var hght = getPos(orderctlHDR).y ;	
	bodwidth  = document.body.offsetWidth
	bodheight = document.body.offsetHeight
	
	var z = bodwidth- (event.x + wdth);	
	
	var x 	  = event.x;
	var y 	  = event.y;	
	
	x 	  = x + (document.getElementById("tooltiplayer1").offsetWidth);
	y 	  = hght + (document.getElementById("tooltiplayer1").offsetHeight);	
	
	if(x<bodwidth){
		x= wdth1;
		
	}else{			
		x = getPos(orderctlHDR).x;
		
	}
	if(y<bodheight){			
		y = hght;
		
	}else
	{
		y = y - (document.getElementById("tooltiplayer1").offsetHeight*2) + hght1 ;	
	}
	document.getElementById("tooltiplayer1").style.Left= x+"px";
	document.getElementById("tooltiplayer1").style.Top = hght+"px";
	document.getElementById("tooltiplayer1").style.visibility='visible'
}
*/

function resizeWindow(orderctlHDR) {
    var orderctlHDR1 = orderctlHDR.id;
    var wdth = document.getElementById(orderctlHDR1).offsetWidth;
    var hght1 = document.getElementById(orderctlHDR1).offsetHeight;
    var wdth1 = getPos(orderctlHDR).x + wdth;
    var hght = getPos(orderctlHDR).y;
    var bodwidth = document.body.offsetWidth;
    var bodheight = document.body.offsetHeight;
    var x = event.clientX;
    var y = event.clientY;
 
    x += document.getElementById("tooltiplayer1").offsetWidth;
    y = hght + document.getElementById("tooltiplayer1").offsetHeight;
 
    if (x < bodwidth) {
        x = wdth1;
    } else {
        x = getPos(orderctlHDR).x;
    }
 
    if (y < bodheight) {
        y = hght;
    } else {
        y = y - (document.getElementById("tooltiplayer1").offsetHeight * 2) + hght1;
    }
 
    document.getElementById("tooltiplayer1").style.left = x + "px";
    document.getElementById("tooltiplayer1").style.top = hght + "px";
    document.getElementById("tooltiplayer1").style.visibility = 'visible';
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
                // alert("Could not find any reference for coordinate
				// positioning.");
            }
        }
        return coords;
    } catch(error) {
        // alert(error.msg);
        return coords;
    }billSettlement
}


function hideToolTip()	{
	  document.getElementById('tooltiplayer1').style.visibility = 'hidden';
}

function cancelTooltip(obj,indx){
	var table;
	// var site_id=parent.interim_main_report.resultForm.document.site_id.value;
	var site_id= $(parent.body_frame.document).find('#site_id').val();
	//var demo_version= $(parent.body_frame.document).find('#demo_version').val();//Commented against V210603
	var site3TierAlmoFeatureYN= $(parent.body_frame.document).find('#site3TierAlmoFeatureYN').val(); //Added V200415 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1

	
	
	
table = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center' style='background-color:#E7E7E7 !important;'> ";
	//if(((site_id=='ALMO') || (site3TierAlmoFeatureYN=='Y')) && (demo_version == 'Y')){ //Added V200415 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1
	if(((site_id=='ALMO') || (site3TierAlmoFeatureYN=='Y'))) { 		
	//removed demo_version against V210603
	
		table+="<tr> "+
						"<td class = 'contextMenuItem' style='cursor:pointer' onmouseOver='highlightDynamicTd(this)' onmouseOut='removeHighlight(this)' nowrap onclick='cancelRecord("+indx+")'>" +
							"Remove "+
						"</td> "+
					"</tr> ";
	}
	else{
		table = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center' style='background-color:#E7E7E7 !important;'> "+
		"<tr> "+
			"<td class = 'contextMenuItem' style='cursor:pointer' onmouseOver='highlightDynamicTd(this)' onmouseOut='removeHighlight(this)' nowrap onclick='cancelRecord("+indx+")'>" +
				"Cancel "+
			"</td> "+
		"</tr> ";
		
		
		
	}
				"</table>";
		document.getElementById('t').innerHTML = table;
		resizeWindow(obj);
}

function highlightDynamicTd(obj){
	$(obj).removeClass('contextMenuItem');
	$(obj).addClass('selectedcontextMenuItem');
}

function removeHighlight(obj){
	$(obj).removeClass('selectedcontextMenuItem');
	$(obj).addClass('contextMenuItem');
}

function cancelRecord(obj){
	hideToolTip();

	var docTypeCode =  $.trim($('#doc_typ_code'+obj).val());
	var docNum = $.trim($('#doc_num'+obj).val());
	var uniqueBillId = docTypeCode+"_"+docNum;
	var dataArray = selectedBills.split('####');
	dataArray.splice($.inArray(uniqueBillId, dataArray),1);
	selectedBills = dataArray.join('####');
	var selectedFrameDoc = parent.selectedFrame.document;
	var index = $(selectedFrameDoc).find('#indexTrack').val();
	// $(selectedFrameDoc).find('#indexTrack').val(index-1);
	var site_id= $(parent.body_frame.document).find('#site_id').val();
	//var demo_version= $(parent.body_frame.document).find('#demo_version').val();//Commented against V210603
	var site3TierAlmoFeatureYN= $(parent.body_frame.document).find('#site3TierAlmoFeatureYN').val(); //Added V200415 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1
	if(index == 1)
{ 
	$(selectedFrameDoc).find('#chkValue1').val("");
		$(selectedFrameDoc).find('#chkColumn1').val("");
		$(selectedFrameDoc).find('#tempPatientId1').val("");
		$(selectedFrameDoc).find('#tempPayerCode1').val("");
		parent.selectedFrame.location.href='../../eBL/jsp/BLReprintSelected.jsp';
		parent.buttonFrame.location.href= '../../eBL/jsp/BLReprintBtn.jsp';
	
		
	//if((site_id=='ALMO' || site3TierAlmoFeatureYN == 'Y') && (demo_version == 'Y')){ //Added V200415 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1
	if((site_id=='ALMO' || site3TierAlmoFeatureYN == 'Y')){ //removed demo_version against V210603
		parent.search_hdr.document.BLReprintReport.consolidatedBillSettlement.disabled=false;
		}
		parent.buttonFrame.$("#btnSettlement").hide();
	}
	$('#row'+obj).remove();
	dataArray.pop(uniqueBillId);


	var index = $(selectedFrameDoc).find('#indexTrack').val();
	reorderTable(obj,index);

	index = parseInt(index) - 1;	
	$(selectedFrameDoc).find('#indexTrack').val(index);
	}

function RemoveAllTooltip(obj){
	var table;
	

	table = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center' style='background-color:#E7E7E7 !important;'> "+
					"<tr> "+
						"<td class = 'contextMenuItem' style='cursor:pointer' onmouseOver='highlightDynamicTd(this)' onmouseOut='removeHighlight(this)' nowrap onclick='removeAllRecord()'>" +
							"Remove All"+
						"</td> "+
					"</tr> "+					
				"</table>";		
	
		document.getElementById('t').innerHTML = table;
		resizeWindow(obj);
}
function removeAllRecord(obj){
	hideToolTip();	
	parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	parent.selectedFrame.location.href='../../eBL/jsp/BLReprintSelected.jsp';
			
	parent.search_hdr.document.BLReprintReport.consolidatedBillSettlement.disabled=false;
	parent.buttonFrame.location.href= '../../eBL/jsp/BLReprintBtn.jsp';

	}	



function moveData(indx,isForALL,disableSlmt,selectAll){
	var selectedFrameDoc = parent.selectedFrame.document;
	var chkBill='';
	var locale=$('#locale').val(); //added against MOHE-CRF-0038.4
	 chkBill=parent.search_hdr.document.BLReprintReport.consolidatedBillSettlement.checked;
	 var siteSpecBillItemDateWiseYN=parent.buttonFrame.document.reprintBtn.siteSpecBillItemDateWiseYN.value; // Added
																												// by
																												// Subha-V20180731/ML-MMOH-CRF-1173
	 var site3TierAlmoFeatureYN=parent.buttonFrame.document.reprintBtn.site3TierAlmoFeatureYN.value; //Added V200415 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1
	 var index = $(selectedFrameDoc).find('#indexTrack').val();
	if(index=='undefined'||index==undefined) index=0;
	if(index==0){
		
		var episodeType = $.trim($('#episode_type'+indx).text());
		// Commented by Subha-V20180809/ML-MMOH-CRF-1173/Starts
			/*
			 * if(episodeType=='I'&&chkBill== false) {
			 * parent.buttonFrame.$('#payer_type').show();
			 * parent.buttonFrame.$('#report_type').show();
			 * 
			 * }else{ parent.buttonFrame.$('#payer_type').hide();
			 * parent.buttonFrame.$('#report_type').hide(); }
			 */
		// Commented by Subha-V20180809/ML-MMOH-CRF-1173/Starts
		// Added by Subha-V20180809/ML-MMOH-CRF-1173/Starts
		if(siteSpecBillItemDateWiseYN == "Y") {
			if(episodeType=='I'&&chkBill== false)
			{
				parent.buttonFrame.$('#payer_type').show();
				parent.buttonFrame.$('#report_type').show();	
			
			}else{
				parent.buttonFrame.$('#payer_type').hide();
				parent.buttonFrame.$('#report_type').hide();
			}
		} else {
			parent.buttonFrame.$('#payer_type').hide();
			parent.buttonFrame.$('#report_type').hide();
		}
		// Added by Subha-V20180809/ML-MMOH-CRF-1173/Ends
	}
	$('#doc_typ_chk'+indx).attr('checked',false);
	var docTypeCode = $.trim($('#doc_typ_code'+indx).text());
	var docNum = $.trim($('#doc_num'+indx).text());
	var docDate = $.trim($('#doc_date'+indx).text());
	var billTotAmt = $.trim($('#bill_tot_amt'+indx).text());
	var patientId = $.trim($('#patient_id'+indx).text());
// Karthik Commented to Remove Billing class code
// var billNatCode = $.trim($('#bill_nat_code'+indx).text());
	var billGrpId = $.trim($('#bill_grp_id'+indx).text());
	var payerCode = $.trim($('#payer_code'+indx).text());
	var episodeType = $.trim($('#episode_type'+indx).text());
	
	var episodeId = $.trim($('#episode_id'+indx).text());
	var visitId = $.trim($('#visit_id'+indx).text());
	var strOperatingFacilityId = document.getElementById('strOperatingFacilityId'+indx).value;
// var billPrintFlag = $.trim($('#bill_print_flag'+indx).text());
	
	var billPaidAmt = $.trim($('#bill_paid_amt'+indx).text());	
	var totOutStdAmt = $.trim($('#bill_outstd_amt'+indx).text());	
	var uniqueBillId = docTypeCode+"_"+docNum;
	var selectedBills = window.parent.selectedFrame.selectedBills;
	var dataArray = selectedBills.split('####');
	var arrCnt = $.inArray(uniqueBillId,dataArray)
	var selectedFrameDoc = parent.selectedFrame.document;
	var tempPatientId = $(selectedFrameDoc).find('#tempPatientId1').val();
	var tempPayerCode = $(selectedFrameDoc).find('#tempPayerCode1').val();
	var chkColumn = $(selectedFrameDoc).find('#chkColumn1');
	var chkValue = $(selectedFrameDoc).find('#chkValue1');
	
	var selectedFrameDoc = parent.selectedFrame.document;
	var index = $(selectedFrameDoc).find('#indexTrack').val();

	var site_id= document.getElementById('site_id').value;
	//var demo_version= document.getElementById('demo_version').value;//Commented against V210603
	var excemptedAmt = $.trim($('#excempted_amt'+indx).text());
	var drugPenalty = $.trim($('#drug_penalty'+indx).text());
	if(chkBill==false){
	
	parent.buttonFrame.$("#btnSettlement").hide();
	parent.buttonFrame.$("#btnCancel").show();
	parent.buttonFrame.$("#btnReprint").show();
	}
		
	//if(disableSlmt == true && (site_id == 'ALMO' || site3TierAlmoFeatureYN == 'Y' ) && demo_version == 'Y'){ //Added V200415 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1
	if(disableSlmt == true && (site_id == 'ALMO' || site3TierAlmoFeatureYN == 'Y' )){ //removed demo_version against V210603
		if(chkBill == true){
			$(selectedFrameDoc).find('[id^=rem_slmt_amt]').each(function(){
				$(this).prop('disabled',false);
			});
			
			$(selectedFrameDoc).find('[id^=bill_print_yn]').each(function(){
				$(this).prop('disabled',false);
			});
			
			$(parent.buttonFrame.document).find("#btnSettlement").show();
			$(parent.buttonFrame.document).find("#btnCancel").hide();
			$(parent.buttonFrame.document).find("#btnReprint").hide();
			$(parent.buttonFrame.document).find("#report_type").hide();
			$(parent.buttonFrame.document).find("#payer_type").hide();
		}
		else{
			$(selectedFrameDoc).find('[id^=rem_slmt_amt]').each(function(){
				$(this).prop('disabled',true);
			});
			
			$(selectedFrameDoc).find('[id^=bill_print_yn]').each(function(){
				$(this).prop('disabled',true);
			});
			
			$(parent.buttonFrame.document).find("#btnSettlement").hide();
			$(parent.buttonFrame.document).find("#btnCancel").show();
			$(parent.buttonFrame.document).find("#btnReprint").show();
			$(parent.buttonFrame.document).find("#report_type").show();
			$(parent.buttonFrame.document).find("#payer_type").show();
		}
	}
	
	var trlast = $(parent.selectedFrame.document).find('#tblSelectedReport tr:last');
	var lastIndex =  $(trlast).attr('indexval');
	
	//if((site_id=="SHALM")&&(chkBill==true)&&(demo_version=='Y')){//Commented against V210603
	if((site_id=="SHALM")&&(chkBill==true)){//removed demo_version against V210603
	
		if((chkBill == true)&&(arrCnt == -1)){
	// if(chkBill == true)
	// {
		
		parent.buttonFrame.$("#btnSettlement").show();
		parent.buttonFrame.$("#btnCancel").hide();
		parent.buttonFrame.$("#btnReprint").hide();
		$(parent.buttonFrame.document).find("#report_type").hide();
		$(parent.buttonFrame.document).find("#payer_type").hide();
		// if(arrCnt == -1){
		
			
	if((totOutStdAmt!=0.00)&&(totOutStdAmt >= 1)){
				
		if(index==0) {			
			$(selectedFrameDoc).find('input[id=tempPatientId1]').val(patientId);
			$(selectedFrameDoc).find('#tempPayerCode1').val(payerCode);
		}
		
		if(index==1){
			
			if(tempPatientId==patientId) {
				
				chkColumn.val("PI");
				chkValue.val(patientId);
	
			}
			else if((tempPayerCode==payerCode)&&(tempPayerCode!="")) 
			{				
				chkColumn.val("PA");
				chkValue.val(payerCode);			
			}
		
			else {
				alert("Either Patient Id or Payer Code should match");
				dataArray.pop(uniqueBillId);				
				return;
			}		
		}
		
		if (index>1) {		
			
			if(chkColumn.val()=="PI") {
				if(chkValue.val()!=patientId) {
					alert("Patient Id Not Matched ");
					dataArray.pop(uniqueBillId);
						return					
				}				
			}
			else if (chkColumn.val()=="PA") {
				if(chkValue.val()!=payerCode) {
					alert("Payer Code Not Matched");
					dataArray.pop(uniqueBillId);
					
					return;
				}			
			}			
		}
		}
			else{
				alert("Refund or Zero Bill-Cannot Settle the Bill");
				dataArray.pop(uniqueBillId);				
				return;
			}		
		
			dataArray.push(uniqueBillId);
			window.parent.selectedFrame.selectedBills = dataArray.join('####');			
		}
		else{			
			if(isForALL==false){
			alert('Bill Aready Added');
			}
			return false;
		}
		
	}
	else if((site_id!="SHALM")&&(chkBill==true)){
			
		if((chkBill == true)&&(arrCnt == -1)){
			parent.buttonFrame.$("#btnSettlement").show();
			parent.buttonFrame.$("#btnCancel").hide();
			parent.buttonFrame.$("#btnReprint").hide();
		
		if(payerCode=="")
		{
			
			
			if(totOutStdAmt!=0.00){
					if(index==0) {						
						$(selectedFrameDoc).find('input[id=tempPatientId1]').val(patientId);
						$(selectedFrameDoc).find('#tempPayerCode1').val(payerCode);
					}
					
					if(index>=1) {
						
						if(tempPatientId==patientId) {
							
							chkColumn.val("PI");
							chkValue.val(patientId);					
				
						}
					
						else {
							alert("Patient Id Not Matched ");
							dataArray.pop(uniqueBillId);
							return;
						}
					
					}					
						}

						else {
							alert("Zero Bill-Cannot Settle the Bill");
							dataArray.pop(uniqueBillId);
							return ;
							}
							}
					else{
						alert("Payer bill cannot be settled");
						dataArray.pop(uniqueBillId);
						return;
					}
				dataArray.push(uniqueBillId);
				window.parent.selectedFrame.selectedBills = dataArray.join('####');
			}
			else{
				
				if(isForALL==false){
					
				alert('Bill Aready Added');
				}
				return false;
			}			
		}	
	
	if((arrCnt == -1)&&(chkBill==false)){		
		
		if ( index > 50-1 ) {
			//if( (site_id == 'ALMO' || site3TierAlmoFeatureYN == 'Y') && demo_version == 'Y'){ //Added V200415 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1
			if( (site_id == 'ALMO' || site3TierAlmoFeatureYN == 'Y')){ //removed demo_version against V210603
			
		if(alertShownFlag==false || alertShownFlag==null || alertShownFlag=="" ) {
				alert("Already 50 rows selected, Can't proceed");
								alertShownFlag=true;					
			}else if(selectAll == 0 ){
				alert("Already 50 rows selected, Can't proceed");
				alertShownFlag=true;		
			}
			
			dataArray.pop(uniqueBillId);
				return;		
			}
	}		
		
	dataArray.push(uniqueBillId);
	window.parent.selectedFrame.selectedBills = dataArray.join('####');
}

else if(chkBill==false){
	
	if(isForALL==false){
	
	alert('Bill Aready Added');
	return;
	}
	else {
		//if((site_id == 'ALMO' || site3TierAlmoFeatureYN == 'Y') && demo_version == 'Y'){ //Added V200415 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1
		if((site_id == 'ALMO' || site3TierAlmoFeatureYN == 'Y')){//removed demo_version against V210603
			if(alertShownFlag==false || alertShownFlag==null || alertShownFlag=="") {
				alert("Some of the bills are already added");
				alertShownFlag=true;
			}
		}
		return;
	}
}

	if(index>=0 && chkBill==false){
		parent.search_hdr.document.BLReprintReport.consolidatedBillSettlement.disabled=true;
				
	}
	index = parseInt(index) + 1;
	
	$(selectedFrameDoc).find('#indexTrack').val(index);
	
	var hiddenIds="<input type='hidden' id='doc_typ_code"+index+"' name='doc_typ_code"+index+"' value='"+docTypeCode+"' >"+
	"<input type='hidden' name='doc_num"+index+"' id='doc_num"+index+"' value='"+docNum+"' >"+
	"<input type='hidden' id='doc_date"+index+"' name='doc_date"+index+"' value='"+docDate+"' >  "+
	"<input type='hidden' id='bill_tot_amt"+index+"' name='bill_tot_amt"+index+"' value='"+billTotAmt+"' > "+
	"<input type='hidden' id='bill_paid_amt"+index+"' name='bill_paid_amt"+index+"' value='"+billPaidAmt+"' >  "+
	"<input type='hidden' id='bill_outstd_amt"+index+"' name='bill_outstd_amt"+index+"' value='"+totOutStdAmt+"' > "+ 
	"<input type='hidden' id='patient_id"+index+"' name='patient_id"+index+"' value='"+patientId+"'> "+
	"<input type='hidden' id='bill_grp_id"+index+"' name='bill_grp_id"+index+"' value='"+billGrpId+"' > "+
	"<input type='hidden' id='payer_code"+index+"' name='payer_code"+index+"' value='"+payerCode+"' > "+
	"<input type='hidden'  id='episode_type"+index+"' name='episode_type"+index+"'  value='"+episodeType+"'  > "+
	"<input type='hidden' id='episode_id"+index+"' name='episode_id"+index+"' value='"+episodeId+"' > "+
	"<input type='hidden'  id='visit_id"+index+"' name='visit_id"+index+"' value='"+visitId+"'  > "+
	"<input type='hidden'  id='encounterFacilityId"+index+"' name='encounterFacilityId"+index+"' value='"+strOperatingFacilityId+"'  > "+
	"<input type='hidden'  id='excempted_amt"+index+"' name='excempted_amt"+index+"' value='"+excemptedAmt+"' > "+
	 "<input type='hidden' id='drug_penalty"+index+"'  name='drug_penalty"+index+"' value='"+drugPenalty+"' > "+
	 "<input type='hidden' id='hdn_rem_slmt_amt"+index+"' name='hdn_rem_slmt_amt"+index+"' value='"+totOutStdAmt+"'>"+
	"<input type='hidden' id='hdn_bill_print_yn"+index+"' name='hdn_bill_print_yn"+index+"'>";

		var tableRow = "<tr id=row"+index+" indexval="+index+"> "+						
		
		"<td id='row"+index+"_col1' class='LABEL' width='7%' style='white-space: nowrap'> "+docTypeCode+"</td> "+

		"<td id='row"+index+"_col2' class='LABEL' width='10%' class='fields' style='white-space: nowrap' onclick='cancelTooltip(this,"+index+");'	onmouseover='hideToolTip();'> "+docNum+
			" &nbsp; "+
			"<img align='right' src='../../eCommon/images/inactiveArrow.gif' id='imgArrow"+index+"'> "+
		"</td> "+

		"<td id='row"+index+"_col3' class='LABEL' width='13%' class='fields'style='white-space: nowrap'> "+docDate+"</td> "+

		"<td id='row"+index+"_col4' class='LABEL' width='13%' class='fields' style='white-space: nowrap'> "+billTotAmt+
			 
		"</td> "+

		"<td id='row"+index+"_col13' class='LABEL' width='13%' class='fields'style='white-space: nowrap'> "+billPaidAmt+
			
			"</td> "+
 
		"<td id='row"+index+"_col14' class='LABEL' width='13%' class='fields'style='white-space: nowrap'> "+totOutStdAmt+
		"</td> ";
		//if((site_id == 'ALMO' || site3TierAlmoFeatureYN == 'Y') && demo_version == 'Y'){ //Added V200415 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1
		if((site_id == 'ALMO' || site3TierAlmoFeatureYN == 'Y')){ //removed demo_version against V210603
			if(chkBill == true){
				tableRow = tableRow + "<td width='9%' id='row"+index+"_col15'  class='fields' style='white-space: nowrap'>" +
				"<input type='text' data-id='"+index+"' id='rem_slmt_amt"+index+"' name='rem_slmt_amt"+index+"' value='"+totOutStdAmt+"' size='10' maxlength = '17' onkeypress='return checkAlpha(event);' onblur='checkRemSlmtAmt(this)'> "+
				"</td>"+
				"<td width='6%' data-id='"+index+"' id='row"+index+"_col16' class='fields' style='white-space: nowrap'>" +
				"<input type='checkbox' id='bill_print_yn"+index+"' name='bill_print_yn"+index+"' "+
				"</td>";
				
			}
			else{
				tableRow = tableRow + "<td width='9%' data-id='"+index+"' class='fields' style='white-space: nowrap'>" +
				"<input type='text' id='rem_slmt_amt"+index+"' name='rem_slmt_amt"+index+"' value='"+totOutStdAmt+"' size='10' disabled maxlength = '17' onkeypress='return checkAlpha(event);' onblur='checkRemSlmtAmt(this)'> "+
				"</td>"+
				"<td width='6%' data-id='"+index+"' class='fields' style='white-space: nowrap'>" +
				"<input type='checkbox' disabled id='bill_print_yn"+index+"' name='bill_print_yn"+index+"' "+
				"</td>";				
			}
			
		}
	
		tableRow = tableRow + "<td id='row"+index+"_col5' width='6%' class='LABEL' style='white-space: nowrap'> "+patientId+
		"</td> "+			
// Karthik Commented to Remove Billing class code
// "<td id='row"+index+"_col6' class='QRYEVEN' width='6%' > "+billNatCode+
// "<input type='hidden' name='bill_nat_code"+index+"' id='bill_nat_code"+index+"' value='"+billNatCode+"'>
// "+
// "</td> "+

		"<td id='row"+index+"_col7' class='LABEL' width='5%' style='white-space: nowrap'> "+billGrpId+
		"</td> "+

		"<td id='row"+index+"_col8' class='LABEL' width='8%' class='fields' style='white-space: nowrap'> "+payerCode+
		"</td> "+

		"<td id='row"+index+"_col9' width='7%' class='LABEL' style='white-space: nowrap'> "+episodeType+
		"</td> "+

		"<td id='row"+index+"_col10' width='7%' class='LABEL' style='white-space: nowrap'> "+episodeId+
		"</td> "+		
			

		"<td id='row"+index+"_col11' class='LABEL' width='6%' style='white-space: nowrap'> "+visitId+
		"</td>  ";
		//if((site_id == 'ALMO' || site3TierAlmoFeatureYN == 'Y') && demo_version == 'Y'){ //Added V200415 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1
		if((site_id == 'ALMO' || site3TierAlmoFeatureYN == 'Y')){//removed demo_version against V210603
	
			tableRow = tableRow +"<td id='row"+index+"_col12' class='LABEL' width='8%' style='white-space: nowrap'>"+excemptedAmt+
	    "</td> "+
	   

	 "<td id='row"+index+"_col13' class='LABEL' width='8%' style='white-space: nowrap'>"+drugPenalty+
	"</td> ";
		}
		 
	 
	"</tr> ";		
	/*
	 * var tableRow = "<tr id=row"+index+" indexval="+index+"> "+
	 *  "<td id='row"+index+"_col1' class='QRYEVEN' width='7%' > "+docTypeCode+ "<input * type='hidden' id='doc_typ_code"+index+"' name='doc_typ_code"+index+"' id='doc_typ_code"+index+"'
	 * value='"+docTypeCode+"' ></td> "+
	 *  "<td id='row"+index+"_col2' class='QRYEVEN' width='10%' class='fields'  onclick='cancelTooltip(this,"+index+");'	onmouseover='hideToolTip();'>
	 * "+docNum+ "<input type='hidden' name='doc_num"+index+"' id='doc_num"+index+"'
	 * id='doc_num"+index+"' value='"+docNum+"' > &nbsp; "+ "<img align='right'
	 * src='../../eCommon/images/inactiveArrow.gif' id='imgArrow"+index+"'> "+ "</td> "+
	 *  "<td id='row"+index+"_col3' class='QRYEVEN' width='13%' class='fields'>
	 * "+docDate+ "<input type='hidden' id='doc_date"+index+"'
	 * name='doc_date"+index+"' id='doc_date"+index+"' value='"+docDate+"' > "+ "</td> "+
	 *  "<td id='row"+index+"_col4' class='QRYEVEN' width='6%' class='fields'>
	 * "+billTotAmt+ "<input type='hidden' id='bill_tot_amt"+index+"'
	 * name='bill_tot_amt"+index+"' id='bill_tot_amt"+index+"' value='"+billTotAmt+"' > "+ "</td> "+
	 *  "<td id='row"+index+"_col13' class='QRYEVEN' width='6%' class='fields'>
	 * "+billPaidAmt+ "<input type='hidden' id='bill_paid_amt"+index+"'
	 * name='bill_paid_amt"+index+"' id='bill_paid_amt"+index+"' value='"+billPaidAmt+"' > "+ "</td> "+
	 *  "<td id='row"+index+"_col14' class='QRYEVEN' width='6%' class='fields'>
	 * "+totOutStdAmt+ "<input type='hidden' id='bill_outstd_amt"+index+"'
	 * name='bill_outstd_amt"+index+"' id='bill_outstd_amt"+index+"' value='"+totOutStdAmt+"' > "+ "</td> "+
	 *  "<td id='row"+index+"_col5' width='7%' class='QRYEVEN'> "+patientId+ "<input * type='hidden' id='patient_id"+index+"' name='patient_id"+index+"' id='patient_id"+index+"'
	 * value='"+patientId+"'> "+ "</td> "+ // Karthik Commented to Remove
	 * Billing class code // "<td id='row"+index+"_col6' class='QRYEVEN' width='6%' >
	 * "+billNatCode+ // "<input type='hidden' name='bill_nat_code"+index+"' id='bill_nat_code"+index+"'
	 * value='"+billNatCode+"'> // "+ // "</td> "+
	 *  "<td id='row"+index+"_col7' class='QRYEVEN' width='6%' > "+billGrpId+ "<input * type='hidden' id='bill_grp_id"+index+"' name='bill_grp_id"+index+"' id='bill_grp_id"+index+"'
	 * value='"+billGrpId+"' > "+ "</td> "+
	 *  "<td id='row"+index+"_col8' class='QRYEVEN' width='7%' class='fields'>
	 * "+payerCode+ "<input type='hidden' id='payer_code"+index+"'
	 * name='payer_code"+index+"' id='payer_code"+index+"' value='"+payerCode+"' > "+ "</td> "+
	 *  "<td id='row"+index+"_col9' width='7%' class='QRYEVEN'> "+episodeType+ "<input * type='hidden' id='episode_type"+index+"' name='episode_type"+index+"' id='episode_type"+index+"'
	 * value='"+episodeType+"' > "+ "</td> "+
	 *  "<td id='row"+index+"_col10' width='7%' class='QRYEVEN' > "+episodeId+ "<input * type='hidden' id='episode_id"+index+"' name='episode_id"+index+"' id='episode_id"+index+"'
	 * value='"+episodeId+"' > "+ "</td> "+
	 * 
	 *  "<td id='row"+index+"_col11' class='QRYEVEN' width='6%'> "+visitId+ "<input * type='hidden' id='visit_id"+index+"' name='visit_id"+index+"' id='visit_id"+index+"'
	 * value='"+visitId+"' > "+ "</td> "+
	 * 
	 *  "<td id='row"+index+"_col12' class='QRYEVEN' width='6%'>"+excemptedAmt+ "<input * type='hidden' id='excempted_amt"+index+"' name='excempted_amt"+index+"' id='excempted_amt"+index+"'
	 * value='"+excemptedAmt+"' > "+ "</td> "+
	 * 
	 *  "<td id='row"+index+"_col13' class='QRYEVEN' width='6%'>"+drugPenalty+ "<input * type='hidden' id='drug_penalty"+index+"' name='drug_penalty"+index+"' id='drug_penalty"+index+"'
	 * value='"+drugPenalty+"' > "+ "</td> "+
	 * 
	 *  "</tr> ";
	 */
		$(selectedFrameDoc).find('#tblSelectedReport').show();
		$(parent.buttonFrame.document).find('#btnDiv').show();
	
		$(selectedFrameDoc).find('#selectedReportBody').append(hiddenIds);
		$(selectedFrameDoc).find('#selectedReportBody').append(tableRow);
		
		//if(disableSlmt == true && (site_id == 'ALMO' || site3TierAlmoFeatureYN == 'Y') && demo_version == 'Y'){ //Added V200415 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1
		if(disableSlmt == true && (site_id == 'ALMO' || site3TierAlmoFeatureYN == 'Y')){ //removed demo_version against V210603
			if(chkBill == true){
				$(selectedFrameDoc).find('[id^=rem_slmt_amt]').each(function(){
					$(this).prop('disabled',false);
				});
				
				$(selectedFrameDoc).find('[id^=bill_print_yn]').each(function(){
					$(this).prop('disabled',false);
				});
				
			}
			else{
				$(selectedFrameDoc).find('[id^=rem_slmt_amt]').each(function(){
					$(this).prop('disabled',true);
				});
				
				$(selectedFrameDoc).find('[id^=bill_print_yn]').each(function(){
					$(this).prop('disabled',true);
				});
			}
		}
}

async function reportPrint(bill_type,lastIndex){
	
	var frm = $(parent.selectedFrame.document).find('#selectedBillForm');
	var site_id= parent.search_hdr.document.BLReprintReport.site_id.value;
	//var demo_version=parent.search_hdr.document.BLReprintReport.demo_version.value;//Commented against V210603
	
	 var selectedFrameDoc = parent.selectedFrame.document;
	 var totalRows = $(selectedFrameDoc).find('#indexTrack').val();
	// Added V20180720-Subha/ML-MMOH-CRF-1173/Starts
	 var episode_id = "";
	 var patient_id = "";
	 var episode_type = "";
	 var visit_id = "";
	 var doc_typ_code = "";
	 var doc_num = "";
	 var bill_tot_amt = "";
	 var doc_date = "";
	 var bill_outstd_amt = "";
	// Added V20180720-Subha/ML-MMOH-CRF-1173/Ends
	 for(var i=1;i<=totalRows;i++) {
		episode_id=selectedFrameDoc.getElementById("episode_id"+i).value;
	 }
	var login_user =  parent.search_hdr.document.BLReprintReport.strLoggedUser.value; // Added V20180720-Subha/ML-MMOH-CRF-1173
	var siteSpecAuditReportYN = parent.search_hdr.document.BLReprintReport.siteSpecAuditReportYN.value; // Added
	// V20180727-Subha/ML-MMOH-CRF-1173
	// var episodeId = $.trim($('#episode_id'+lastIndex).text());
	
	var param16=$('#bilparam').val();
	
	var report_type=$('#report_type').val();
	var detailed_yn ='';
	var p_detailed_yn ;
	
	var payer_type=$('#payer_type').val();
	var facilityId = $('#facilityId').val();	
	var site3TierAlmoFeatureYN = parent.search_hdr.document.BLReprintReport.siteSpecAuditReportYN.value; //Added V200415 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1
// var param16= $('#bilparam').val();
	/*
	 * var action =
	 * '../../servlet/eBL.ReprintReportServlet?mode=insertSyProgBulk&'+
	 * 'lastRowIndex='+lastIndex+'&'+ 'billType='+bill_type+'&'+
	 * '&facilityId='+facilityId;
	 * 
	 */
	/*
	 * V12122017 Rajesh V Modified for MMS-QH-CRF-0208.1 Added hdrLocale and
	 * passing it as request param to ReprintReportServlet
	 */
	var hdrLocale = $(parent.search_hdr.document).find('#locale').val();
	var dialogHeight= "30vh" ;
	var dialogWidth	= "20vw" ;
	var dialogTop = "225" ;
	var center = "1" ;														   
	var status="no";
	var overflow = "hidden";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+";overflow:"+overflow;
	var arguments	= "" ;		
	var hdrFrm  = parent.search_hdr.document.BLReprintReport;		

	detailed_yn ='';
	p_detailed_yn = parent.search_hdr.document.BLReprintReport.dtlPrint.checked;	
	if(p_detailed_yn == true)			 detailed_yn = 'Y';
	else			 detailed_yn = 'N';	
	
	// Added for NMC-JD-CRF-0091
	var chk_print_stamp_YN = "N";
	if(parent.buttonFrame != null)
		chk_print_stamp_YN = parent.buttonFrame.document.getElementById("hid_chk_print_stamp_YN").value;  // Added for NMC-JD-CRF-0091
	
	//if((site_id == 'ALMO' || site3TierAlmoFeatureYN == 'Y') && demo_version == 'Y'){ //Added V200415 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN& AAKH-SCF-0404.1
	if((site_id == 'ALMO' || site3TierAlmoFeatureYN == 'Y')){//removed demo_version against V210603
	var retVal = await window.showModalDialog("../../eBL/jsp/BLFinDetailsAuthoriseMain.jsp?mode=s&called_frm=EBL_TRANS_SETL_REPRNT&print=Y",arguments,features);
	 var doAuth=true;
			
	if(retVal[0]=='Y')
	{

		$.ajax({
		type: "Post",
		url:'../../servlet/eBL.ReprintReportServlet?mode=insertSyProgBulk&'+
			'lastRowIndex='+lastIndex+'&'+
			'billType='+bill_type+'&'+
			'payer_type='+payer_type+'&'+
			'detailed_yn='+detailed_yn+'&'+
			'facilityId='+facilityId+'&'+
			'param16='+param16+'&'+
			'episode_id='+episode_id+'&'+
			'report_type='+report_type+'&'+
			'hdrLocale='+hdrLocale,
		data:$(frm).serialize(),
		dataType:"json",
		async:false,
		success: function(data){
				if(data.Success == 'Y'){
				var hdrFrm = parent.search_hdr.document.BLReprintReport;
				
				var dummyDoc = parent.dummy_frame.document;//
				var htmlVal = "<html><body>";
				htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
				htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+hdrFrm.facility_id.value+"'>";
				htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+hdrFrm.locale.value+"'>";
				htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+bill_type+"'>";
				htmlVal += "<input type='hidden' name='p_detailed_YN' id='p_detailed_YN' value='"+detailed_yn+"'>";
				htmlVal += "<input type='hidden' name='p_session_id' id='p_session_id' value='"+data.sessionId+"'>";
				htmlVal += "<input type='hidden' name='p_pgm_date' id='p_pgm_date' value='"+data.pgmDate+"'>";
				htmlVal += "<input type='hidden' name='P_PRT_DIG_STAMP' id='P_PRT_DIG_STAMP' value='"+chk_print_stamp_YN+"'>"; // Added for NMC-JD-CRF-0091
// htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='IN'>";
				
				if($('#report_type').val()=='I' || $('#report_type').val()=='D' )
					{
					
				htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='IN'>";
					}
				else
					{
					
					htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+hdrFrm.p_module_id.value+"'>";	
					}
				htmlVal += "<input type='hidden' name='p_pgm_id' id='p_pgm_id' value='"+bill_type+"'>";		
				htmlVal += "</form></body></html>";
				dummyDoc.body.insertAdjacentHTML("afterbegin",htmlVal);
				dummyDoc.dummy_frm.action="../../eCommon/jsp/report_options.jsp";
				dummyDoc.dummy_frm.target="messageFrame";
				//dummyDoc.dummy_frm.submit();
				parent.dummy_frame.document.forms[0].submit();
			}
			else{
				alert(data.errorMessage);
			}		
		}, 
		 error: function(data){

	      }
	});
	}
			}
			// Added V20180720-Subha/ML-MMOH-CRF-1173/Starts
			 else if(siteSpecAuditReportYN == "Y"){
					var responseText = false;
					var checkPrintAll=false;
					for(var i=1;i<=totalRows;i++) {
						if(checkPrintAll == 'false' || checkPrintAll == false) {
						episode_id=selectedFrameDoc.getElementById("episode_id"+i).value;
						patient_id = selectedFrameDoc.getElementById("patient_id"+i).value;
						episode_type=selectedFrameDoc.getElementById("episode_type"+i).value;
						visit_id = selectedFrameDoc.getElementById("visit_id"+i).value;
						doc_typ_code=selectedFrameDoc.getElementById("doc_typ_code"+i).value;
						doc_num = selectedFrameDoc.getElementById("doc_num"+i).value;
						bill_tot_amt=selectedFrameDoc.getElementById("bill_tot_amt"+i).value;
						doc_date = selectedFrameDoc.getElementById("doc_date"+i).value;
						bill_outstd_amt=selectedFrameDoc.getElementById("bill_outstd_amt"+i).value;
						 
					$.ajax({
						type:"POST", //V220413
						url:"../jsp/BLReprintAuditTrailReportAjax.jsp?facilityId=" + facilityId + "&userId=" + login_user +
						"&patientId=" +patient_id + "&episodeType=" + episode_type + "&episodeId=" +episode_id + "&visitId=" +visit_id
						 + "&docTypeCode="+doc_typ_code + "&docNum=" +doc_num+ "&billTotAmt="+bill_tot_amt+ "&totOutStdAmt=" + bill_outstd_amt + "&billDocDate="+doc_date,
						data:"",
						dataType:"text",
						async:false,
						success: function(data){
							var splitVal = trimString(data).split("::::");
							if(splitVal.length == 2) {
								if(splitVal[0] == "10") {
									alert(splitVal[1]);
									checkPrintAll=true;
									responseText = false;
								} else {
									responseText = splitVal[0];
								}
							}
						},
						error: function(xhr, ajaxopt, err){
							
						}
					});
					}else {
						responseText = false;
					}
					}
					if(responseText == true || responseText == 'true') {
						$.ajax({
							type: "Post",
							url:'../../servlet/eBL.ReprintReportServlet?mode=insertSyProgBulk&'+
								'lastRowIndex='+lastIndex+'&'+
								'billType='+bill_type+'&'+
								'payer_type='+payer_type+'&'+
								'detailed_yn='+detailed_yn+'&'+
								'facilityId='+facilityId+'&'+
								'param16='+param16+'&'+
								'episode_id='+episode_id+'&'+
								'report_type='+report_type+'&'+
								'hdrLocale='+hdrLocale+'&'+
								'siteSpecAuditReportYN='+siteSpecAuditReportYN,
							data:$(frm).serialize(),
							dataType:"json",
							async:false,
							success: function(data){
									if(data.Success == 'Y'){
									var hdrFrm = parent.search_hdr.document.BLReprintReport;
									
									var dummyDoc = parent.parent.dummyFrame.document;
									var htmlVal = "<html><body>";
									htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
									htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+hdrFrm.facility_id.value+"'>";
									htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+hdrFrm.locale.value+"'>";
									htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+bill_type+"'>";
									htmlVal += "<input type='hidden' name='p_detailed_YN' id='p_detailed_YN' value='"+detailed_yn+"'>";
									htmlVal += "<input type='hidden' name='p_session_id' id='p_session_id' value='"+data.sessionId+"'>";
									htmlVal += "<input type='hidden' name='p_pgm_date' id='p_pgm_date' value='"+data.pgmDate+"'>";
									htmlVal += "<input type='hidden' name='P_PRT_DIG_STAMP' id='P_PRT_DIG_STAMP' value='"+chk_print_stamp_YN+"'>";// Added for NMC-JD-CRF-0091
// htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='IN'>";
									
									if($('#report_type').val()=='I' || $('#report_type').val()=='D' )
										{
										
									htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='IN'>";
										}
									else
										{
										
										htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+hdrFrm.p_module_id.value+"'>";	
										}
									htmlVal += "<input type='hidden' name='p_pgm_id' id='p_pgm_id' value='"+bill_type+"'>";		
									htmlVal += "</form></body></html>";
									dummyDoc.body.insertAdjacentHTML("afterbegin",htmlVal);
									dummyDoc.dummy_frm.action="../../eCommon/jsp/report_options.jsp";
									dummyDoc.dummy_frm.target="messageFrame";
									dummyDoc.dummy_frm.submit();
								}
								else{
									alert(data.errorMessage);
								}		
							}, 
							 error: function(data){

						      }
						});

			} 
				 }
			// Added V20180720-Subha/ML-MMOH-CRF-1173/Ends
			else{
				$.ajax({
					type: "Post",
					url:'../../servlet/eBL.ReprintReportServlet?mode=insertSyProgBulk&'+
						'lastRowIndex='+lastIndex+'&'+
						'billType='+bill_type+'&'+
						'payer_type='+payer_type+'&'+
						'detailed_yn='+detailed_yn+'&'+
						'facilityId='+facilityId+'&'+
						'param16='+param16+'&'+
						'episode_id='+episode_id+'&'+
						'report_type='+report_type+'&'+
						'hdrLocale='+hdrLocale,
					data:$(frm).serialize(),
					dataType:"json",
					async:false,
					success: function(data){
							if(data.Success == 'Y'){
							var hdrFrm = parent.search_hdr.document.BLReprintReport;
							
							var dummyDoc = parent.parent.dummyFrame.document;
							var htmlVal = "<html><body>";
							htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
							htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+hdrFrm.facility_id.value+"'>";
							htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+hdrFrm.locale.value+"'>";
							htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+bill_type+"'>";
							htmlVal += "<input type='hidden' name='p_detailed_YN' id='p_detailed_YN' value='"+detailed_yn+"'>";
							htmlVal += "<input type='hidden' name='p_session_id' id='p_session_id' value='"+data.sessionId+"'>";
							htmlVal += "<input type='hidden' name='p_pgm_date' id='p_pgm_date' value='"+data.pgmDate+"'>";
							htmlVal += "<input type='hidden' name='P_PRT_DIG_STAMP' id='P_PRT_DIG_STAMP' value='"+chk_print_stamp_YN+"'>"; // Added for NMC-JD-CRF-0091
// htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='IN'>";
							
							if($('#report_type').val()=='I' || $('#report_type').val()=='D' )
								{
								
							htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='IN'>";
								}
							else
								{
								
								htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+hdrFrm.p_module_id.value+"'>";	
								}
							htmlVal += "<input type='hidden' name='p_pgm_id' id='p_pgm_id' value='"+bill_type+"'>";		
							htmlVal += "</form></body></html>";
							dummyDoc.body.insertAdjacentHTML("afterbegin",htmlVal);
							dummyDoc.dummy_frm.action="../../eCommon/jsp/report_options.jsp";
							dummyDoc.dummy_frm.target="messageFrame";
							dummyDoc.dummy_frm.submit();
						}
						else{
							alert(data.errorMessage);
						}		
					}, 
					 error: function(data){

				      }
				});				
			}	
}

async function insertSyProgParamBulk(){	
	var frm = $(parent.selectedFrame.document).find('#selectedBillForm');	
	var trlast = $(parent.selectedFrame.document).find('#tblSelectedReport tr:last');
	var lastIndex =  $(trlast).attr('indexval');
	var bill_type = parent.search_hdr.document.BLReprintReport.p_report_id.value;
	var facilityId = $('#facilityId').val();
	var siteSpec=parent.search_hdr.document.BLReprintReport.site_spec.value;
	var locale='';
	if(siteSpec=='true'){
		locale = parent.search_hdr.document.getElementById('language_option').value;
	}
	else{
		locale = parent.search_hdr.document.getElementById('locale').value;
	}	
	if(lastIndex == 'undefined' || lastIndex == undefined){
		alert('Please Select atleast one bill for Print');
		return false;
	}		
	
	var reportId= parent.frames[0].document.forms[0].p_report_id.value;
	
	if($('#report_type').val()=='I' && $('#payer_type').val()=='C' )
	{
		if(siteSpec=='true' && locale=='A')
		{
				bill_type='INRSRWRT_ALMOAR';
				$('#bilparam').val('I');
		}
		else
		{
			bill_type='INRSRWRT';
			$('#bilparam').val('I');
		}
		}	
	
	else if($('#report_type').val()=='I' && $('#payer_type').val()=='I')
		{
			if(siteSpec=='true' && locale=='A')
			{
			bill_type='INRSRWRT_ALMOAR';
			$('#bilparam').val('I');
			}
			else 
			{
				bill_type='INRSRWRT';
				$('#bilparam').val('I');			
			}
		}
	
	
	if($('#report_type').val()=='D' && $('#payer_type').val()=='C' )
	{

		if(siteSpec=='true' && locale=='A')
		{
			bill_type='INRSRGDT_ALMOAR';
			$('#bilparam').val('D');
	
		}	
		else{
		bill_type='INRSRGDT';
		$('#bilparam').val('D');
		}
			
	}


else if($('#report_type').val()=='D' && $('#payer_type').val()=='I')
	{
	if(siteSpec=='true' && locale=='A')
	{
		
		bill_type='INRSRGDT_ALMOAR';
		$('#bilparam').val('D');

	}	
	else{
			bill_type='INRSRGDT';
			$('#bilparam').val('D');
		}
	}
	

	
		
	if($('#payer_type').val()=='B'){
		
		
		if($('#report_type').val()=='I'){
			
			if(siteSpec=='true' && locale=='A')
			{
			
				$('#bilparam').val('I');
				// alert('bilparam '+$('#bilparam').val());
				await reportPrint('INRSRWRT_ALMOAR',lastIndex);
			}	
			else
			{	
			$('#bilparam').val('I');
			// alert('bilparam '+$('#bilparam').val());
			await reportPrint('INRSRWRT',lastIndex);
			}
		}
			/*
			 * var delay=5000; //1 second
			 * 
			 * setTimeout(function() {
			 * 
			 * reportPrint('INRSRWRT',lastIndex);
			 *  }, delay);
			 *  }
			 */
		else if($('#report_type').val()=='D')
			{
			if(siteSpec=='true' && locale=='A')
			{
				$('#bilparam').val('D');
				await reportPrint('INRSRGDT_ALMOAR',lastIndex);
				
			}
			else{
			$('#bilparam').val('D');
			await reportPrint('INRSRGDT',lastIndex);
			// reportPrint('INRSRGDT',lastIndex);
			}
			}
		else
			{
			$('#bilparam').val('');
			await reportPrint(reportId,lastIndex);
			}
		
	}else{
			await reportPrint(bill_type,lastIndex);
	}


	// $(frm).attr('action',action);

	// $(frm).submit();
}

function onSuccess(){
	
}
// For Defaulting Patient Encounter Details

function callPatValidation(obj)
{
	var frm = document.forms[0];
	var patient_id=obj.value;	
	if(patient_id!=""){
	var xmlStr ="<root><SEARCH ";				
	xmlStr +=" /></root>";
	var temp_jsp="../../eBL/jsp/EncounterCommonValidation.jsp?func_mode=CHK_PAT_ID&patient_id="+patient_id;					
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
		obj.value="";
	}
	
	}
}

function defaultEncounter(obj){
	var patId = document.forms[0].patient_id.value;
	var patClass = document.forms[0].episode_type.value;
	var facilityId = document.forms[0].facility_id.value;
	// if(document.forms[0].hdnEpisode_id.value < 1){
	if(obj == 'patId'){
		if(patId.length>0 && patClass.length>0){
				var xmlStr ="<root><SEARCH ";				
				xmlStr +=" /></root>";
				var temp_jsp="../../eBL/jsp/EncounterCommonValidation.jsp?func_mode=defaultEncounter&pat_id="+patId+"&epsdType="+patClass+"&facility_id="+facilityId;					
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST",temp_jsp,false);
				xmlHttp.send(xmlDoc);
				var responseText=trimString(xmlHttp.responseText);
				// alert(responseText)
				if(responseText != 'N' && responseText.length>0){
					var retArr = responseText.split(":::");
					document.forms[0].episode_id.value = retArr[0]=='0'?'':retArr[0];
					document.forms[0].hdnEpisode_id.value = retArr[0]=='0'?'':retArr[0];
					document.forms[0].visit_id.value = retArr[2]=='0'?'':retArr[2];
					// document.forms[0].Effective_from.value = retArr[1];
				}
				else{
					document.forms[0].episode_id.value = '';
					document.forms[0].hdnEpisode_id.value = '';
				document.forms[0].visit_id.value ='';
					// document.forms[0].Effective_from.value = '';
				}
		}
	}
	else if(obj == 'epsdType'){
		if(patId.length>0 && patClass.length>0){
			var xmlStr ="<root><SEARCH ";				
			xmlStr +=" /></root>";
			var temp_jsp="../../eBL/jsp/EncounterCommonValidation.jsp?func_mode=defaultEncounter&pat_id="+patId+"&epsdType="+patClass+"&facility_id="+facilityId;						
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);
			var responseText=trimString(xmlHttp.responseText);
			// alert(responseText)
			if(responseText != 'N' && responseText.length>0){
				var retArr = responseText.split(":::");
				document.forms[0].episode_id.value = retArr[0];
				document.forms[0].hdnEpisode_id.value = retArr[0];
				document.forms[0].Effective_from.value = retArr[1];
			}
			else{
				document.forms[0].episode_id.value = '';
				document.forms[0].hdnEpisode_id.value = '';
				document.forms[0].Effective_from.value = '';
			}
		}
	}
	// }
}


async function PatientIdLookup()
{	
			var pat_id=await PatientSearch();		
			var frm = document.forms[0];
			if( pat_id != null ){
				document.getElementById("patient_id").value = pat_id ;
			}					
			else{
				frm.patient_id.value = '';				
			}
			
}	


/* Karthik added this method to call user defined lookup page */
async function callEpisodeDialog(){
	
	var frm = document.forms[0];
	var patient_id = frm.patient_id.value;
	var episode_type = document.forms[0].episode_type.value;
	var episode_id = document.forms[0].episode_id.value;
	var facility_id = document.forms[0].facility_id.value;
	var qryParam='&patient_id='+patient_id+'&episode_type='+episode_type+'&episode_id='+episode_id+'&facility_id='+facility_id;
	

	var retVal				= new String();
	var dialogTop			= "40";
	var dialogHeight		= "90vh" ;
	var dialogWidth			= "60vw" ;
	var features			= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var message				="";
	
	var title = "Select Episode";		

	var column_sizes = escape("10%,10%,10%,10%,25%,10%,25%");

	var column_descriptions = 'PATIENT ID'+','+'EPISODE TYPE'+','+'EPISODE ID'+','+'VISIT ID'+','+'CLINIC DATE'+','+'CLINIC CODE'+','+'CLINIC DESC';
	var sql="";			
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&col_show_hide=YYYYYYY"+qryParam;
	
	var  retVal=await window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?called_for=REPRINT_HDR_EPISODE_LOOKUP&"+param,arguments,features);
	
	if (retVal != null && retVal!="" && retVal!="undefined" )
	 {
		  retVal=unescape(retVal);
		  var arr=retVal.split("^~^");
		  frm.patient_id.value = arr[0];
		  frm.episode_id.value = arr[2];
		  frm.visit_id.value = arr[3];
		  // retVal=arr[2]+"::"+arr[0]+"::"+arr[4]+"::";
	 }
	return retVal;
	
}


async function episodeLookup(obj,code){
	//alert("1");
	var frm = document.forms[0];
	var patient_id = frm.patient_id.value;
	// alert('start frm.patient_id.value->'+frm.patient_id.value);
	var episode_type = frm.episode_type.value;
	/*
	 * if(patient_id.length<1){ alert("Enter Patient Id"); return false; }
	 */
	if(episode_type.length<1){
		alert(getMessage('BL9142','BL'));
		return false;
	}
	
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	if((episode_type == 'I') || (episode_type == 'D')){
		if(patient_id == ''){
			sql = "Select patient_id code,episode_id description from bl_episode_fin_dtls where episode_type= '"+episode_type+"' and upper(episode_id) like upper(?) and upper(episode_type) like upper(?) order by 2"
		}
		else{
			sql = "Select patient_id code,episode_id description from bl_episode_fin_dtls where patient_id = '"+patient_id+"' and episode_type= '"+episode_type+"' and upper(episode_id) like upper(?) and upper(episode_type) like upper(?) order by 2"
		}
		
	}
	else if((episode_type == 'O') || (episode_type == 'R') || (episode_type == 'E')){
		if(patient_id == ''){
			sql = "Select patient_id code,episode_id description from bl_visit_fin_dtls where episode_type = '"+episode_type+"' and upper(episode_id) like upper(?) and upper(episode_type) like upper(?) order by 2"
		}
		else{
			sql = "Select patient_id code,episode_id description from bl_visit_fin_dtls where patient_id = '"+patient_id+"' and episode_type = '"+episode_type+"' and upper(episode_id) like upper(?) and upper(episode_type) like upper(?) order by 2"
		}		
	}
	else{
		if(patient_id == ''){
			sql = "Select patient_id code,episode_id description from bl_visit_fin_dtls where  upper(episode_id) like upper(?) and upper(patient_id) like upper(?) order by 2"
		}
		else{
			sql = "Select patient_id code,episode_id description from bl_visit_fin_dtls where patient_id = '"+patient_id+"'  and upper(episode_id) like upper(?) and upper(patient_id) like upper(?) order by 2"
		}
	}
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	// returnedValues = CommonLookup("Legend", argumentArray );
	retVal = await callOperation(patient_id,episode_type,obj.value,facility_id);
	// alert('retVal->'+retVal);
	if((retVal != null) && (returnedValues != "") )  {
		var returnedValues = retVal.split("::");
		// alert(returnedValues.length)
		if(returnedValues.length == 4){
			obj.value = returnedValues[0];
			code.value = returnedValues[0];	
			frm.patient_id.value = returnedValues[1];

		}
		else if(returnedValues.length == 3){
			// alert('3 here')
			obj.value = returnedValues[0];
			code.value = returnedValues[0];	

		}	
	}
}

// Search Frames
async function callDialog(param){
	var dialogTop			= "40";
	var dialogHeight		= "10";
	var dialogWidth			= "40";
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var arguments			= "";
	retVal=await window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);
	return retVal;
}

function callOperation(patient_id,episode_type,episode_id,facility_id){	
	var column_sizes = escape("40%,30%,30%");                       	  
	var tit = getLabel('Common.patientId.label','Common') + ',' +
				getLabel('Common.episodeid.label','Common') + ',' 
			+ 'Encounter Date' ;
	// alert('fid->'+facility_id)
	var column_descriptions=encodeURIComponent(tit);

	var sqlTemp = '';
	if(patient_id.length>1){

		var column_sizes = escape("50%,50%");                       	  
		var tit = getLabel('Common.episodeid.label','Common') + ',' 
					+ 'Encounter Date' ;

		var column_descriptions=encodeURIComponent(tit);

		var sqlTemp = '';
		// sqlTemp = "Select to_char(Episode_Id)
		// Episode_Id,to_char(Enc_Regn_Date_Time,'dd/mm/yyyy')
		// Enc_Regn_Date_Time From Bl_Encounter_Payer_Priority Where
		// operating_facility_id = '"+facility_id+"' and Patient_Id =
		// '"+patient_id+"' and episode_type='"+episode_type+"' ";
		// sqlTemp = "Select to_char(Episode_Id1) Episode_Id1,
		// to_char(Enc_Regn_Date_Time1) Enc_Regn_Date_Time1 from (Select
		// distinct(to_char(Episode_Id))
		// Episode_Id1,to_char(Enc_Regn_Date_Time,'dd/mm/yyyy')
		// Enc_Regn_Date_Time1,operating_facility_id,patient_id,episode_type
		// From Bl_Encounter_Payer_Priority ) Where operating_facility_id =
		// '"+facility_id+"' and Patient_Id = '"+patient_id+"' and
		// episode_type='"+episode_type+"' ";
		sqlTemp = "Select  Episode_Id1 Episode_Id2, Enc_Regn_Date_Time1 Enc_Regn_Date_Time2 from (Select distinct(to_char(Episode_Id)) Episode_Id1,to_char(Enc_Regn_Date_Time,'dd/mm/yyyy') Enc_Regn_Date_Time1,operating_facility_id,patient_id,episode_type  From Bl_Encounter_Payer_Priority ) Where operating_facility_id = '"+facility_id+"' and Patient_Id = '"+patient_id+"' ";
		if(episode_type != '**'){
			sqlTemp = sqlTemp + "and episode_type='"+episode_type+"'  ";
		}
		
		var sql=escape(sqlTemp);
		
		var title=getLabel("Common.episodeid.label","common");
		
		title=encodeURIComponent(title);
		
		var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="
		+sql+"&search_criteria="+episode_id;
	}
	else{
		var column_sizes = escape("40%,30%,30%");                       	  
		var tit =	getLabel('Common.episodeid.label','Common') + ',' +
					 getLabel('Common.patientId.label','Common') + ',' 
					+ 'Encounter Date' ;

		var column_descriptions=encodeURIComponent(tit);

		var sqlTemp = '';
		sqlTemp = "Select  Episode_Id1 Episode_Id2, patient_id1 patient_id2, Enc_Regn_Date_Time1 Enc_Regn_Date_Time2 from (Select distinct(to_char(Episode_Id)) Episode_Id1,patient_id patient_id1,to_char(Enc_Regn_Date_Time,'dd/mm/yyyy') Enc_Regn_Date_Time1,operating_facility_id,patient_id,episode_type  From Bl_Encounter_Payer_Priority ) Where operating_facility_id = '"+facility_id+"' ";
		if(episode_type != '**'){
			sqlTemp = sqlTemp + "and episode_type='"+episode_type+"'  ";
		}
		var sql=escape(sqlTemp);
		
		var title=getLabel("Common.episodeid.label","common");
		
		title=encodeURIComponent(title);
		
		var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="
		+sql+"&search_criteria="+episode_id;
	}

	
	retVal=callDialog(param);	
	
	return retVal;
}

async function billNoLkup(bill_number_desc,bill_number_code,empty_chk)
{		
	var retVal				= new String();
	var dialogTop			= "40";
	var dialogHeight		= "90vh" ;
	var dialogWidth			= "60vw" ;
	var features			= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var message				="";
	
	var title = "Bill Number";		

	var column_sizes = escape("50%,50%");
	var targetVal = bill_number_desc.value;
	var column_descriptions = 'Document Number'+','+'Document Type';
	var sql="";	
	var doc_type_code='';
	
	if( $('#from_bill_number_code').val()!='' || $('#to_bill_number_code').val()!='')
	{
		if($('#from_bill_number_code').val()!='') doc_type_code=$('#from_bill_number_code').val();
		if($('#to_bill_number_code').val()!='') doc_type_code=$('#to_bill_number_code').val();
	}
	
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&col_show_hide=YY&target="+targetVal+"&billNumberDesc="+targetVal+"&facilityId="+$('#facility_id').val();
	param += "&patient_id="+$('#patient_id').val() + "&episode_id="+$('#episode_id').val() + "&episode_type="+$('#episode_type').val() + "&cust_code="+$('#cust_code').val() + "&doc_type_code="+doc_type_code + "&visit_id="+$('#visit_id').val();
	


	var  retVal=await window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?called_for=BILL_DOC_LOOKUP&"+param,arguments,features);
	retVal = unescape(retVal)
	// alert(retVal)
	if(retVal != undefined && retVal !="undefined")
	{					
		var retArray = retVal.split("^~^");
		bill_number_code.value=retArray[1];
		bill_number_desc.value=retArray[0];								
	}
	else
	{
		bill_number_code.value="";
		bill_number_desc.value="";	
	}
	// return retVal;
	// alert("bill look up");
	/*
	 * if(empty_chk=='Y' && bill_number_desc.value=='') { return false; } var
	 * locale = document.forms[0].locale.value; var facility_id =
	 * document.forms[0].facility_id.value;
	 * 
	 * var target = document.forms[0].from_bill_number; var retVal = new
	 * String(); var dialogTop = "40"; var dialogHeight = "10" ; var dialogWidth =
	 * "40" ; var features = "dialogTop:"+dialogTop+"dialogHeight:" +
	 * dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ; var
	 * arguments = "" ; var search_desc = ""; var title =
	 * getLabel("eBL.FromBillNumber.label","COMMON"); var
	 * episode_typ=document.forms[0].episode_type.value; //
	 * alert("episode_typ"+episode_typ); // var sql1="SELECT DISTINCT
	 * G.NURSING_UNIT_CODE code, G.SHORT_DESC description FROM
	 * IP_NURSING_UNIT_LANG_VW G, IP_OPEN_EPISODE I WHERE G.FACILITY_ID
	 * ='"+facility_id+"' ";// AND G.NURSING_UNIT_CODE = i.CUR_WARD_CODE AND
	 * UPPER(G.LANGUAGE_ID) = UPPER('"+locale+"') ";
	 * 
	 * //var sql1="SELECT doc_type_code , doc_num FROM bl_bill_hdr WHERE NVL
	 * (bill_status, '$') <> 'C' AND NVL (bill_trx_type_code, 'N') = 'D' AND
	 * episode_type = '"+episode_typ+"' and upper(doc_type_code) like upper(?)
	 * and upper(doc_num) like upper(?) order by 2 ";//WHERE NVL (bill_status,
	 * '$') <> 'C' AND NVL (bill_trx_type_code, 'N') = 'D' AND episode_type =
	 * '"+episode_typ"' "; var sql1="SELECT doc_type_code code, doc_num
	 * description FROM bl_bill_hdr where upper(doc_type_code) like upper(?) and
	 * upper(doc_num) like upper(?) order by 1 ";//WHERE NVL (bill_status, '$') <>
	 * 'C' AND NVL (bill_trx_type_code, 'N') = 'D' AND episode_type =
	 * '"+episode_typ"' ";
	 * 
	 * var argArray = new Array(); var namesArray = new Array(); var valuesArray =
	 * new Array(); var datatypesArray = new Array(); argArray[0] = sql1;
	 * argArray[1] = namesArray; argArray[2] = valuesArray; argArray[3] =
	 * datatypesArray; argArray[4] = "1,2"; argArray[5] =
	 * bill_number_desc.value; argArray[6] = DESC_LINK; argArray[7] = DESC_CODE;
	 * retArray = CommonLookup( title, argArray ); // alert("retArray
	 * :"+retArray); //retArray=unescape(retArray);
	 */
	
}


function clearCode(obj){
	obj.value = '';
}
	
	
function showCalendar_loc(Val1, Val2)
{	
		if (Val2.disabled == true)		
		{
			return false;
		}
		else
		{
			return showCalendar(Val1,null,null);
		}
}
// Search Frames

async function runSingleBill(indx){
	// var hdr =
	var result = interim_main_report.body_frame.document;
	result.getElementById('tooltiplayer1').style.visibility = 'hidden'
// hideToolTip();
	var docTypeCode = $.trim($($(result).find('#doc_typ_code'+indx)).text());
	var docNum = $.trim($($(result).find('#doc_num'+indx)).text());
	var docDate = $.trim($($(result).find('#doc_date'+indx)).text());
	var billTotAmt = $.trim($($(result).find('#bill_tot_amt'+indx)).text());
	var patientId = $.trim($($(result).find('#patient_id'+indx)).text());
// Karthik Commented to Remove Billing class code
// var billNatCode = $.trim($($(result).find('#bill_nat_code'+indx)).text());
	var billGrpId = $.trim($($(result).find('#bill_grp_id'+indx)).text());
	var payerCode = $.trim($($(result).find('#payer_code'+indx)).text());
	var episodeType = $.trim($($(result).find('#episode_type'+indx)).text());
	
	var episodeId = $.trim($($(result).find('#episode_id'+indx)).text());
	var visitId = $.trim($($(result).find('#visit_id'+indx)).text());
	// var billPrintFlag =
	// $.trim($($(result).find('#bill_print_flag'+indx)).text());
	
	var billPaidAmt = $.trim($($(result).find('#bill_paid_amt'+indx)).text());
	var totOutStdAmt = $.trim($($(result).find('#bill_outstd_amt'+indx)).text());
	/*
	 * V12122017 Rajesh V Modified for MMS-QH-CRF-0208.1 Getting locale from
	 * search hdr instead of body frame
	 */
	var locale = $(interim_main_report.search_hdr.document).find('#locale').val();// $(result).find('#locale').val();
	var site_id= interim_main_report.search_hdr.document.BLReprintReport.site_id.value;
	//var demo_version=interim_main_report.search_hdr.document.BLReprintReport.demo_version.value;//Commented against V210603
	
	
	var reportId = interim_main_report.search_hdr.document.BLReprintReport.p_report_id.value;
	var siteSpecAuditReportYN = interim_main_report.search_hdr.document.BLReprintReport.siteSpecAuditReportYN.value; // Added
																														// V20180720-Subha/ML-MMOH-CRF-1173
	var login_user =  interim_main_report.search_hdr.document.BLReprintReport.strLoggedUser.value;// Added
																									// V20180720-Subha/ML-MMOH-CRF-1173
																				
	var chk_print_stamp_YN = "N";
	if(interim_main_report.buttonFrame != null)
		chk_print_stamp_YN = interim_main_report.buttonFrame.document.getElementById("hid_chk_print_stamp_YN").value;  // Added for NMC-JD-CRF-0091

	
		var detailed_yn ='';
		var p_detailed_yn = interim_main_report.search_hdr.document.BLReprintReport.dtlPrint.checked;
		var site3TierAlmoFeatureYN = interim_main_report.search_hdr.document.BLReprintReport.site3TierAlmoFeatureYN.value;  //Added V200415 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1
		
		if(p_detailed_yn == true)  			 detailed_yn = 'Y';
		else 			 detailed_yn = 'N';	
		var dialogHeight= "20vh" ;
		var dialogWidth	= "30vw" ;
		var dialogTop = "225" ;
		var center = "1" ;														   
		var status="no";
		var overflow = "hidden";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+";overflow:"+overflow;
		var arguments	= "" ;		
		var hdrFrm  = interim_main_report.search_hdr.document.BLReprintReport;	
		
		var facilityId=hdrFrm.facility_id.value;
		
		//if((site_id == 'ALMO' || site3TierAlmoFeatureYN == 'Y') && demo_version == 'Y'){ //Added V200415 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1
		if((site_id == 'ALMO' || site3TierAlmoFeatureYN == 'Y')){ //removed demo_version against V210603
			var retVal = await window.showModalDialog("../../eBL/jsp/BLFinDetailsAuthoriseMain.jsp?mode=s&called_frm=EBL_TRANS_SETL_REPRNT&print=Y",arguments,features);
			 var doAuth=true;
			
			 if(retVal[0]=='Y')
	{


		$.ajax({
			type:"GET",
			url:"../jsp/BLCommonReportValidation.jsp",
			data:"func_mode=ReprintReport &p_report_id="+reportId+
				"&param1="+docTypeCode+
				"&param2="+docTypeCode+
				"&param3="+docNum+
				"&param4="+docNum+
				"&param5="+

				"&param6="+detailed_yn+
				"&param7="+"R"+
				"&param8="+locale+
				"&param9="+
				"&param10="+
				
				"&param11="+
				"&param12="+
				"&param13="+
				"&param14="+episodeType,
			dataType:"text",
			async:false,
			success: function(data){
			var hdrFrm = interim_main_report.search_hdr.document.BLReprintReport;	
			
			var dummyDoc = frames[1].document.getElementById('dummy_frame');//Added by Jeyachitra for edge support
				var retVal = trimString(data).split(":::");
				var session_id = '';
				var pgm_date = '';
				if(retVal.length == 2){
					//Added by jeyachitra for edge support
					if(retVal[0].indexOf('<!DOCTYPE html>')!=-1)
					{
						retVal[0] = retVal[0].replace(/<!DOCTYPE html>/gi, "");
						retVal[0]= trimString(retVal[0]);
					}
					session_id = retVal[0];
					pgm_date = retVal[1];
				}
				var htmlVal = "<html><body>";
				htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
				htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+hdrFrm.facility_id.value+"'>";
				htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+hdrFrm.locale.value+"'>";
				htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+hdrFrm.p_report_id.value+"'>";
				htmlVal += "<input type='hidden' name='p_session_id' id='p_session_id' value='"+session_id+"'>";
				htmlVal += "<input type='hidden' name='p_pgm_date' id='p_pgm_date' value='"+pgm_date+"'>";
				htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+hdrFrm.p_module_id.value+"'>";
				htmlVal += "<input type='hidden' name='p_pgm_id' id='p_pgm_id' value='"+hdrFrm.p_report_id.value+"'>";				
				htmlVal += "<input type='hidden' name='P_PRT_DIG_STAMP' id='P_PRT_DIG_STAMP' value='"+chk_print_stamp_YN+"'>"; // Added for NMC-JD-CRF-0091
				
				htmlVal += "</form></body></html>";

				
	            // Added by Jeyachitra for edge support
				dummyDoc.contentDocument.body.insertAdjacentHTML("afterbegin",htmlVal);
				dummyDoc.contentDocument.dummy_frm.submit();
			 },
			 error: function(data){

		      }
		});
	}
			} // Added V20180720-Subha/ML-MMOH-CRF-1173
			 else if(siteSpecAuditReportYN == "Y"){
				var responseText = false;
				var functionIdInSMFunction = "EBL_TRANS_SETL_REPRNT";
				$.ajax({
					type:"POST",//V220413
					url:"../jsp/BLReprintAuditTrailReportAjax.jsp?facilityId=" + facilityId + "&userId=" + login_user +
					"&patientId=" +patientId + "&episodeType=" + episodeType+ "&episodeId=" +episodeId + "&visitId=" +visitId
					 + "&docTypeCode="+docTypeCode + "&docNum=" +docNum+ "&billTotAmt="+billTotAmt+ "&totOutStdAmt=" + totOutStdAmt + "&billDocDate="+docDate,
					data:"",
					dataType:"text",
					async:false,
					success: function(data){
						var splitVal = trimString(data).split("::::");
						if(splitVal.length == 2) {
							if(splitVal[0] == "10") {
								alert(splitVal[1]);
							} else {
								responseText = splitVal[0];
							}
						}
					},
					error: function(xhr, ajaxopt, err){
						debugger;
						alert("error->"+xhr);
						alert("error1->"+ajaxopt);
					}
				});
				if(responseText == true || responseText == 'true') {
				 $.ajax({
						type:"POST", //V220413
						url:"../jsp/BLCommonReportValidation.jsp",
						data:"func_mode=ReprintReport &p_report_id="+reportId+
							"&param1="+docTypeCode+
							"&param2="+docTypeCode+
							"&param3="+docNum+
							"&param4="+docNum+
							"&param5="+

							"&param6="+detailed_yn+
							"&param7="+"R"+
							"&param8="+locale+
							"&param9="+
							"&param10="+
							
							"&param11="+
							"&param12="+
							"&param13="+
							"&param14="+episodeType+
							"&param17="+login_user+
							"&param20="+functionIdInSMFunction,
						dataType:"text",
						async:false,
						success: function(data){
			var hdrFrm = interim_main_report.search_hdr.document.BLReprintReport;
			var dummyDoc = parent.parent.dummyFrame.document;
							var retVal = trimString(data).split(":::");
							var session_id = '';
							var pgm_date = '';
							if(retVal.length == 2){
								session_id = retVal[0];
								pgm_date = retVal[1];
							}
							var htmlVal = "<html><body>";
							htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
							htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+hdrFrm.facility_id.value+"'>";
							htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+hdrFrm.locale.value+"'>";
							htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+hdrFrm.p_report_id.value+"'>";
							htmlVal += "<input type='hidden' name='p_session_id' id='p_session_id' value='"+session_id+"'>";
							htmlVal += "<input type='hidden' name='p_pgm_date' id='p_pgm_date' value='"+pgm_date+"'>";
							htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+hdrFrm.p_module_id.value+"'>";
							htmlVal += "<input type='hidden' name='p_pgm_id' id='p_pgm_id' value='"+hdrFrm.p_report_id.value+"'>";
							htmlVal += "<input type='hidden' name='P_PRT_DIG_STAMP' id='P_PRT_DIG_STAMP' value='"+chk_print_stamp_YN+"'>"; // Added for NMC-JD-CRF-0091
							
							htmlVal += "</form></body></html>";

							dummyDoc.body.insertAdjacentHTML("afterbegin",htmlVal);
							dummyDoc.dummy_frm.submit();
						},
						 error: function(data){

					      }
					});

		} 
			 }// Added V20180720-Subha/ML-MMOH-CRF-1173
			 else{
				 $.ajax({
						type:"GET",
						url:"../jsp/BLCommonReportValidation.jsp",
						data:"func_mode=ReprintReport &p_report_id="+reportId+
							"&param1="+docTypeCode+
							"&param2="+docTypeCode+
							"&param3="+docNum+
							"&param4="+docNum+
							"&param5="+

							"&param6="+detailed_yn+
							"&param7="+"R"+
							"&param8="+locale+
							"&param9="+
							"&param10="+
							
							"&param11="+
							"&param12="+
							"&param13="+
							"&param14="+episodeType,
						dataType:"text",
						async:false,
						success: function(data){
			var hdrFrm = interim_main_report.search_hdr.document.BLReprintReport;
			var dummyDoc = dummyFrame.document;
							var retVal = trimString(data).split(":::");
							var session_id = '';
							var pgm_date = '';
							// var report_id='BLRCANBL';
							// hdrFrm.p_report_id.value = retVal;
							if(retVal.length == 2){
								session_id = retVal[0];
								pgm_date = retVal[1];
							}
							var htmlVal = "<html><body>";
							htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
							htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+hdrFrm.facility_id.value+"'>";
							htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+hdrFrm.locale.value+"'>";
							htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+hdrFrm.p_report_id.value+"'>";
							htmlVal += "<input type='hidden' name='p_session_id' id='p_session_id' value='"+session_id+"'>";
							htmlVal += "<input type='hidden' name='p_pgm_date' id='p_pgm_date' value='"+pgm_date+"'>";
							htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+hdrFrm.p_module_id.value+"'>";
							htmlVal += "<input type='hidden' name='p_pgm_id' id='p_pgm_id' value='"+hdrFrm.p_report_id.value+"'>";
							htmlVal += "<input type='hidden' name='P_PRT_DIG_STAMP' id='P_PRT_DIG_STAMP' value='"+chk_print_stamp_YN+"'>"; // Added for NMC-JD-CRF-0091
							
							htmlVal += "</form></body></html>";

							dummyDoc.body.insertAdjacentHTML("afterbegin",htmlVal);
							dummyDoc.dummy_frm.submit();
						},
						 error: function(data){

					      }
					});

				 
			 }
			 

	}

function reorderTable (rowId,totalRows) 
{
	var site_id= $(parent.body_frame.document).find('#site_id').val();
	//var demo_version= $(parent.body_frame.document).find('#demo_version').val();//Commented against V210603
	var j=1;
	var selectedFrameDoc = parent.selectedFrame.document;
	
	for(var i=rowId;i<totalRows;i++) 
	{
	var temp=parseInt(i)+1;
	$(selectedFrameDoc).find("#doc_typ_code"+i).val($(selectedFrameDoc).find("#doc_typ_code"+temp).val());
	$(selectedFrameDoc).find("#doc_num"+i).val($(selectedFrameDoc).find("#doc_num"+temp).val());
	selectedFrameDoc.getElementById("doc_num"+i).value=selectedFrameDoc.getElementById("doc_num"+temp).value;
	$(selectedFrameDoc).find("#doc_date"+i).val($(selectedFrameDoc).find("#doc_date"+temp).val());
	$(selectedFrameDoc).find("#bill_tot_amt"+i).val($(selectedFrameDoc).find("#bill_tot_amt"+temp).val());
	$(selectedFrameDoc).find("#bill_paid_amt"+i).val($(selectedFrameDoc).find("#bill_paid_amt"+temp).val());
	$(selectedFrameDoc).find("#bill_outstd_amt"+i).val($(selectedFrameDoc).find("#bill_outstd_amt"+temp).val());
	$(selectedFrameDoc).find("#patient_id"+i).val($(selectedFrameDoc).find("#patient_id"+temp).val());		
	$(selectedFrameDoc).find("#bill_grp_id"+i).val($(selectedFrameDoc).find("#bill_grp_id"+temp).val());
	$(selectedFrameDoc).find("#payer_code"+i).val($(selectedFrameDoc).find("#payer_code"+temp).val());
	$(selectedFrameDoc).find("#episode_type"+i).val($(selectedFrameDoc).find("#episode_type"+temp).val());
	$(selectedFrameDoc).find("#episode_id"+i).val($(selectedFrameDoc).find("#episode_id"+temp).val());
	$(selectedFrameDoc).find("#visit_id"+i).val($(selectedFrameDoc).find("#visit_id"+temp).val());
	$(selectedFrameDoc).find("#excempted_amt"+i).val($(selectedFrameDoc).find("#excempted_amt"+temp).val());
	$(selectedFrameDoc).find("#drug_penalty"+i).val($(selectedFrameDoc).find("#drug_penalty"+temp).val());
	$(selectedFrameDoc).find("#rem_slmt_amt"+i).val($(selectedFrameDoc).find("#rem_slmt_amt"+temp).val());	
	if($(selectedFrameDoc).find("#bill_print_yn"+temp).prop("checked")){
		$(selectedFrameDoc).find("#bill_print_yn"+i).prop("checked","checked");
	}
	else{
		$(selectedFrameDoc).find("#bill_print_yn"+i).prop("checked","");
	}

	var t=selectedFrameDoc.getElementById("row"+i+"_col2");
	var site3TierAlmoFeatureYN= $(parent.body_frame.document).find('#site3TierAlmoFeatureYN').val(); //Added V200415 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN  & AAKH-SCF-0404.1
	$(selectedFrameDoc).find("row"+temp).attr("id","row"+i);
	$(selectedFrameDoc).find("row"+temp+"_col2").attr("id","row"+i+"_col2");
	selectedFrameDoc.getElementById("row"+temp).id = "row"+i;
	selectedFrameDoc.getElementById("row"+temp+"_col2").id = "row"+i+"_col2"; // TO DO : change the id for all columns
	$(selectedFrameDoc).find("#rem_slmt_amt"+temp).removeAttr('name');
	$(selectedFrameDoc).find("#bill_print_yn"+temp).removeAttr('name');
	//if((site_id == 'ALMO' || site3TierAlmoFeatureYN == 'Y') && demo_version == 'Y'){//Added V200415 SHIKHA against AAKH-CRF-0112 site3TierAlmoFeatureYN & AAKH-SCF-0404.1
	if((site_id == 'ALMO' || site3TierAlmoFeatureYN == 'Y')){//removed demo_version against V210603
		$(selectedFrameDoc).find("#rem_slmt_amt"+temp).attr({name : "rem_slmt_amt"+i});
		$(selectedFrameDoc).find("#bill_print_yn"+temp).attr({name : "bill_print_yn"+i});
		selectedFrameDoc.getElementById("rem_slmt_amt"+temp).name = "rem_slmt_amt"+i;
		selectedFrameDoc.getElementById("bill_print_yn"+temp).name = "bill_print_yn"+i;
		$(selectedFrameDoc).find("#rem_slmt_amt"+temp).attr("data-id",i);
		$(selectedFrameDoc).find("#rem_slmt_amt"+temp).attr("id","rem_slmt_amt"+i);
		$(selectedFrameDoc).find("#bill_print_yn"+temp).attr("id","bill_print_yn"+i);
	}

	$(selectedFrameDoc).find("#row"+i+"_col2").prop('onclick',null).off('click');
	$(selectedFrameDoc).find("#row"+i+"_col2").click(function(j) {return function(){
	cancelTooltip(selectedFrameDoc.getElementById("row"+j+"_col2"),j);
    return false;
	}}(parseInt(i)));
	}
	$(selectedFrameDoc).find("#doc_typ_code"+totalRows).remove();
	$(selectedFrameDoc).find("#doc_num"+totalRows).remove();
	$(selectedFrameDoc).find("#doc_date"+totalRows).remove();
	$(selectedFrameDoc).find("#bill_tot_amt"+totalRows).remove();
	$(selectedFrameDoc).find("#bill_paid_amt"+totalRows).remove();
	$(selectedFrameDoc).find("#bill_outstd_amt"+totalRows).remove();
	$(selectedFrameDoc).find("#patient_id"+totalRows).remove();
	$(selectedFrameDoc).find("#bill_grp_id"+totalRows).remove();
	$(selectedFrameDoc).find("#payer_code"+totalRows).remove();
	$(selectedFrameDoc).find("#episode_type"+totalRows).remove();
	$(selectedFrameDoc).find("#episode_id"+totalRows).remove();
	$(selectedFrameDoc).find("#visit_id"+totalRows).remove();
	$(selectedFrameDoc).find("#excempted_amt"+totalRows).remove();
	$(selectedFrameDoc).find("#drug_penalty"+totalRows).remove();
/*
 * $(selectedFrameDoc).find("#rem_slmt_amt"+totalRows).remove();
 * $(selectedFrameDoc).find("#bill_print_yn"+totalRows).remove();
 */
}

function resetFlag() {
	alertShownFlag = false;
}

function checkAlpha(event){
	var strCheck = '1234567890.-';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  
	if (strCheck.indexOf(key) == -1) return false;  
	return true ;
}

function checkRemSlmtAmt(obj){

	var noofdecimal= $(parent.body_frame.document).find('#noofdecimal').val();
	
	var index = $(obj).attr('data-id');
	putDecimal($('#rem_slmt_amt'+index).get(0),17,noofdecimal);
	var outStndAmt =$('#bill_outstd_amt'+index).val();
	var slmtAmt = $('#rem_slmt_amt'+index).val();

	if(slmtAmt>=0 || slmtAmt<0){
		
	}
	else{
		alert(getMessage("NUM_ALLOWED", "SM"));
		$('#rem_slmt_amt'+index).val('');
		$('#rem_slmt_amt'+index).focus();
		return false;
	}
	
	/*
	 * if(parseFloat(slmtAmt) > parseFloat(outStndAmt)){
	 * alert(getMessage('BL9674','BL')); $('#rem_slmt_amt'+index).focus();
	 * return false; }
	 * 
	 * if(parseFloat(outStndAmt) > 0 && parseFloat(slmtAmt) < 0){
	 * alert(getMessage('BL0623','BL')); $('#rem_slmt_amt'+index).focus();
	 * return false; }
	 */

	if(outStndAmt<0){
		if(slmtAmt<0){
			if(parseFloat(slmtAmt) < parseFloat(outStndAmt)){
			alert(getMessage('BL9674','BL'));
			$('#rem_slmt_amt'+index).focus();
				return false;
			}
		}
	 
		if(slmtAmt>0){
			if(parseFloat(outStndAmt) < 0 && parseFloat(slmtAmt) > 0){
				alert(getMessage('BL0623','BL'));
				$('#rem_slmt_amt'+index).focus();
				return false;
			}
		}
	} 
	else{
		if(parseFloat(slmtAmt) > parseFloat(outStndAmt)){
			alert(getMessage('BL9674','BL'));
			$('#rem_slmt_amt'+index).focus();
			return false;
		} 
		if(parseFloat(outStndAmt) > 0 && parseFloat(slmtAmt) < 0){
			alert(getMessage('BL0623','BL'));
			$('#rem_slmt_amt'+index).focus();
			return false;
		}
	}
}

function selPrintStamp() {
	var siteEnableDigitalSignatureYN = document.getElementById('siteEnableDigitalSignatureYN').value;
	
	if(siteEnableDigitalSignatureYN == "Y"){
		var chk_print_stamp_YN = document.getElementById("chk_print_stamp_YN");
		
		if(chk_print_stamp_YN.checked) {
			document.getElementById("hid_chk_print_stamp_YN").value = "Y";
		} else {
			document.getElementById("hid_chk_print_stamp_YN").value = "N";
		}
	}
	
}

//V221107
function openESign(indx){
	var docTypeCode = $.trim($('#doc_typ_code'+indx).text());
	var docNum = $.trim($('#doc_num'+indx).text());
	var patientId = $.trim($('#patient_id'+indx).text());
	var episodeType = $.trim($('#hdnEpisodeType'+indx).text());
	var episodeId = $.trim($('#hdnEpisodeId'+indx).text());
	var visitId = $.trim($('#hdnVisitId'+indx).text());
	var mpi_id =document.getElementById("mpi_id"+indx).value;
	var returnVal=validate_eSignature();
	if(returnVal!='' && returnVal!='undefined' && returnVal!=undefined ){
		var params="docTypeCode="+docTypeCode+"&docNum="+docNum+"&visitId="+visitId+"&episodeType="+episodeType+"&episodeId="+episodeId+"&patientId="+patientId+"&mpi_id="+mpi_id+"&image="+encodeURIComponent(returnVal);
		 $.ajax({
			type:"POST",
			url:"../jsp/BLCommonAjax.jsp",
			data:"functionMode=PatientSign&"+params,
			dataType:"text",
			async:false,
			success: function(data){
				
			},
			error: function(data){
		  }
		});
	}
}

