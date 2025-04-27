function reset()
{	
	interim_main_report.location.reload();
}

function run() 
{	
	var fields = new Array(interim_main_report.frames[0].document.forms[0].from_nursing_unit,
	interim_main_report.frames[0].document.forms[0].to_nursing_unit);
	var names = new Array(getLabel("Common.FromNursingUnit.label","Common"), getLabel("Common.ToNursingUnit.label","Common"));

	interim_main_report.frames[0].document.forms[0].L_AMOUNT.value=interim_main_report.frames[0].document.forms[0].pay_amt_exce.value;
	interim_main_report.frames[0].document.forms[0].L_FR_EPISODE_ID.value=interim_main_report.frames[0].document.forms[0].from_adm_no.value;
	interim_main_report.frames[0].document.forms[0].L_TO_EPISODE_ID.value=interim_main_report.frames[0].document.forms[0].to_adm_no.value;
	interim_main_report.frames[0].document.forms[0].L_FR_WARD_CODE.value=interim_main_report.frames[0].document.forms[0].from_nursing_unit_code.value;
	interim_main_report.frames[0].document.forms[0].L_TO_WARD_CODE.value=interim_main_report.frames[0].document.forms[0].to_nursing_unit_code.value;
	interim_main_report.frames[0].document.forms[0].L_PAYER.value=interim_main_report.frames[0].document.forms[0].payer_code.value;
	interim_main_report.frames[0].document.forms[0].L_PAY_TYPE.value=interim_main_report.frames[0].document.forms[0].payer_type.value;
	interim_main_report.frames[0].document.forms[0].L_SERV_CLASS_YN.value=interim_main_report.frames[0].document.forms[0].group_by.value;		
	
	//Added by Rajesh V
	var hdrFrm = interim_main_report.frames[0].document.forms[0];
	var dtlFrm = interim_main_report.body_frame.document.resultForm;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var detailYn = hdrFrm.dischargeYN;
	var detailYnVal = '';
	if(detailYn.checked){
		detailYnVal = 'Y';
	}
	else{
		detailYnVal = 'N';
	}
	var episodeTypeDesc = dtlFrm.episodeType.value;
	var ipText = dtlFrm.inpatientText.value;
	var opText = dtlFrm.outpatientText.value;
	var emText = dtlFrm.emergencyText.value;
	var exText = dtlFrm.externalText.value;
	var dcText = dtlFrm.daycareText.value;
	var episodeCode = '';
	if(episodeTypeDesc.length>0){
		if(episodeTypeDesc == ipText){
			episodeCode = 'I';
		}
		else if(episodeTypeDesc == opText){
			episodeCode = 'O';
		}
		else if(episodeTypeDesc == emText){
			episodeCode = 'E';	
		}
		else if(episodeTypeDesc == exText){
			episodeCode = 'R';
		}
		else if(episodeTypeDesc == dcText){
			episodeCode = 'D';
		}
	}
	var param1 = 	"&patientId="+dtlFrm.patientId.value+
					"&episodeType="+episodeCode+
					"&episodeId="+dtlFrm.admissionNo.value+
					"&detailRepYn="+detailYnVal;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eBL/jsp/BLCommonReportValidation.jsp?func_mode=interimChargeValidation"+param1,false);
	xmlHttp.send(xmlDoc);
	//alert(xmlHttp.responseText)
	/*var obj = new Object();
	obj =  xmlHttp.responseText;
	alert(obj.valueOf())
	alert(obj.recalcYn);
	alert(obj.sessionId);
	alert(obj.reportId);
	alert(obj.reportDate);
	alert(obj.errorCode);
	alert(obj.errorMsg);	*/
	var retVal = trimString(xmlHttp.responseText);
	var retValArr = retVal.split("::##");
	if(retValArr.length == 4){	//Array Length 4-> No Errors Else, Procedure Has throws some Exception
		
		hdrFrm.p_session_id.value = retValArr[1];
		hdrFrm.p_pgm_date.value = retValArr[3];
		hdrFrm.p_report_id.value = retValArr[2];
		hdrFrm.p_pgm_id.value = retValArr[2];
		
		var htmlVal = "<html><body>";
		htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
		htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+hdrFrm.facility_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+hdrFrm.locale.value+"'>";
		htmlVal += "<input type='hidden' name='p_pgm_id' id='p_pgm_id' value='"+hdrFrm.p_pgm_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+hdrFrm.p_report_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_session_id' id='p_session_id' value='"+hdrFrm.p_session_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_pgm_date' id='p_pgm_date' value='"+hdrFrm.p_pgm_date.value+"'>";
		htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+hdrFrm.p_module_id.value+"'>";
		
		
		
		htmlVal += "</form></body></html>";

		dummyFrame.document.body.insertAdjacentHTML("afterbegin",HTMLVal);
		dummyFrame.document.dummy_frm.submit();		
		//interim_main_report.frames[0].document.forms[0].submit();		
	}
	else{
		alert(retValArr[1]);
	}
	/*xmlDoc = new ActiveXObject( "Microsoft.XMLDom" ) ; 
	xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	

	var param=	"p_report_id="+hdrFrm.p_report_id.value+
				"&param1="+hdrFrm.L_FR_WARD_CODE.value+
				"&param2="+hdrFrm.L_TO_WARD_CODE.value+
				"&param3="+hdrFrm.L_FR_EPISODE_ID.value+
				"&param4="+hdrFrm.L_TO_EPISODE_ID.value+
				"&param5="+hdrFrm.L_PAY_TYPE.value+
				"&param6="+hdrFrm.L_PAYER.value+
				"&param7="+hdrFrm.L_AMOUNT.value+
				"&param8="+dtlFrm.patientId.value+
				"&param9="+dtlFrm.patientName.value+
				"&param10="+dtlFrm.episodeType.value+
				"&param11="+dtlFrm.admissionNo.value+
				"&param12="+dtlFrm.admissionDate.value+
				"&param13="+dtlFrm.lastBedChrgDt.value+
				"&param14="+dtlFrm.wardNo.value+
				"&param15="+dtlFrm.bedNo.value+
				"&param16="+dtlFrm.billingGroup.value+
				"&param17="+dtlFrm.payer.value+
				"&param18="+dtlFrm.policy.value+
				"&param19="+dtlFrm.unbilledAmt.value+
				"&param20="+dtlFrm.unAdjustAmt.value+
				"&param21="+dtlFrm.outStandBillAmt.value+
				"&param22="+dtlFrm.totalAmt.value;
	//var param="func_mode=get_Card_Details&card_id="+retVal[0];
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eBL/jsp/BLCommonReportValidation.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	//alert(xmlHttp.responseText);	
	var responseText=trimString(xmlHttp.responseText);	
	var responsetextArr = responseText.split(":::");
	hdrFrm.p_session_id.value = responsetextArr[0];
	hdrFrm.p_pgm_date.value = responsetextArr[1];	*/
	//Added by Rajesh V
		
	
	
}

//Added by Rajesh V	
function trimString(sInString) {
	  return sInString.replace(/^\s+|\s+$/g,"");
}

function highlightRow(obj,qryClass){
	var frm =  document.resultForm;
	var rowClicked = frm.rowClicked.value;
	
	//alert(rowClicked);
	//alert(obj);
	if(rowClicked != obj){
		
		if(rowClicked.length>0){
			document.getElementById('row'+rowClicked+'_col1').className =  qryClass;
			document.getElementById('row'+rowClicked+'_col2').className =  qryClass;
			document.getElementById('row'+rowClicked+'_col3').className =  qryClass;
			document.getElementById('row'+rowClicked+'_col4').className =  qryClass;
			document.getElementById('row'+rowClicked+'_col5').className =  qryClass;
			document.getElementById('row'+rowClicked+'_col6').className =  qryClass;
			document.getElementById('row'+rowClicked+'_col7').className =  qryClass;
			document.getElementById('row'+rowClicked+'_col8').className =  qryClass;
			document.getElementById('row'+rowClicked+'_col9').className =  qryClass;
			document.getElementById('row'+rowClicked+'_col10').className =  qryClass;
			document.getElementById('row'+rowClicked+'_col11').className =  qryClass;
			document.getElementById('row'+rowClicked+'_col12').className =  qryClass;
			document.getElementById('row'+rowClicked+'_col13').className =  qryClass;
			document.getElementById('row'+rowClicked+'_col14').className =  qryClass;
			document.getElementById('row'+rowClicked+'_col15').className =  qryClass;
		}		
		
		document.getElementById('row'+obj+'_col1').className =  "YELLOW";
		document.getElementById('row'+obj+'_col2').className =  "YELLOW";
		document.getElementById('row'+obj+'_col3').className =  "YELLOW";
		document.getElementById('row'+obj+'_col4').className =  "YELLOW";
		document.getElementById('row'+obj+'_col5').className =  "YELLOW";
		document.getElementById('row'+obj+'_col6').className =  "YELLOW";
		document.getElementById('row'+obj+'_col7').className =  "YELLOW";
		document.getElementById('row'+obj+'_col8').className =  "YELLOW";
		document.getElementById('row'+obj+'_col9').className =  "YELLOW";
		document.getElementById('row'+obj+'_col10').className =  "YELLOW";
		document.getElementById('row'+obj+'_col11').className =  "YELLOW";
		document.getElementById('row'+obj+'_col12').className =  "YELLOW";
		document.getElementById('row'+obj+'_col13').className =  "YELLOW";
		document.getElementById('row'+obj+'_col14').className =  "YELLOW";
		document.getElementById('row'+obj+'_col15').className =  "YELLOW";
		
		
		frm.patientId.value = document.getElementById("patient_id"+obj).value;
		frm.patientName.value = document.getElementById("patient_name"+obj).value;
		frm.episodeType.value = document.getElementById("episode_type"+obj).value;
		frm.admissionNo.value = document.getElementById("adm_no"+obj).value;
		frm.admissionDate.value = document.getElementById("adm_date"+obj).value;
		frm.lastBedChrgDt.value = document.getElementById("last_bed_chr_date"+obj).value;
		frm.wardNo.value = document.getElementById("ward"+obj).value;
		frm.bedNo.value = document.getElementById("bed_no"+obj).value;
		frm.billingGroup.value = document.getElementById("blng_grp_id"+obj).value;
		frm.payer.value = document.getElementById("cust_desc"+obj).value;
		frm.policy.value = document.getElementById("policy"+obj).value;
		frm.unbilledAmt.value = document.getElementById("unbill_amt"+obj).value;
		frm.unAdjustAmt.value = document.getElementById("unadjust_dep"+obj).value;
		frm.outStandBillAmt.value = document.getElementById("outstand_amt"+obj).value;
		frm.totalAmt.value = document.getElementById("total_amt"+obj).value;
		
		/*alert(frm.patientId.value+'->'+frm.patientName.value+'->'+frm.episodeType.value+'->'+frm.admissionNo.value+'->'+
				frm.admissionDate.value+'->'+frm.lastBedChrgDt.value+'->'+frm.wardNo.value+'->'+frm.bedNo.value+'->'+
				frm.billingGroup.value+'->'+frm.payer.value+'->'+frm.policy.value+'->'+frm.unbilledAmt.value+'->'+
				frm.unAdjustAmt.value+'->'+frm.outStandBillAmt.value+'->'+frm.totalAmt.value)*/
	}
	
	frm.rowClicked.value = obj;
}
//Added by Rajesh V

