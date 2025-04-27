/*
Sr No        Version           Incident        		SCF/CRF             Developer Name
--------------------------------------------------------------------------------------
1            V210112            7661	     	 MOHE-CRF-0050.1         Ram kumar S
2            V210226      15050,15117,15109	 MOHE-CRF-0050.1         Ram kumar S
3            V210228       	 15239	 	 MOHE-CRF-0050.1         Ram kumar S
*/

$(function() {

	$('#detailRprtChkbx').prop('checked', true);
	$('#patientDtlsTbl').on('click','tr',function () {
	    $('tr.yellow').removeClass('yellow'); 
	    $(this).addClass('yellow'); 
	    var tableRowid = $(this).closest('tr').attr('id'); // table row ID 
	    parent.frames[1].$('#selectedRow').val("");
	    parent.frames[1].$('#selectedRow').val(tableRowid);
	});
//making visibility based on fucntion control
	if(window.name=="IntermDraftReport"){
		$("#serdate").hide();
		$("#billservgrp").hide();
		$("#serdate1").hide();
		$("#billservgrp1").hide();
		$("#PayerHid").attr('disabled', true);
		$("#detailRprtChkbx").show();
		$("#ReportPrintOptionLbl").hide();
		$("#ReportPrintOption").hide();
		if($('#servDateGrpSiteSpec').val() =="true"){
			$("#serdate").show();
			$("#billservgrp").show();
			$("#serdate1").show();
			$("#billservgrp1").show();
			var frameset=parent.document.getElementById("intermDrftRetFrame");
			frameset.setAttribute("rows","10%,33%,47%,2%,8%"); 
		}
		//Retrieving Report Print Option
		var facility_id = $('#facilityId').val();
		$.ajax({
			type:"POST",
			url:"../jsp/IntermDraftReportValidation.jsp",
			data:"CalledFor=reportPrintOption"+
				"&facId="+facility_id,
			dataType:"text",
			async:false,
			success: function(data){
				var responseText = trimString(data);
				var n1 = responseText.indexOf("~");
				var res1 = responseText.substr(n1+1);
				res1 = res1.split("~");
				if(res1[0]=="S"){
					 $('#reportType').val(res1[1]);
					if(res1[1] == "R"){
						$("#detailRprtChkbx").hide();
						$("#ReportPrintOptionLbl").show();
						$("#ReportPrintOption").show();
					}else{
						$("#detailRprtChkbx").show();
						$("#ReportPrintOptionLbl").hide();
						$("#ReportPrintOption").hide();
					}
				}else{
					 alert("Error else "+res1[1]);
				}
				},
				 error: function(data){
					 alert("Error  "+data);
			  }
		});	
		$('#langHid').val("");
	}
	$('#prcssBedChrg').click(function(){
		var siteIdVal= $('#siteIdVal').val();
		if(checkBackJob(siteIdVal)){
		if (confirm('Do you want to confirm?')) {
		var facility_id= $('#facilityId').val();
		$('#langHid').val("Bed Charges Computing");
		var selectRow=$('#selectedRow').val();
		var indexVal=selectRow.substr(selectRow.length-1);
		var patient_Id=parent.frames[2].$('#patientId'+indexVal).val();
		var episodeType=parent.frames[2].$('#episodeType'+indexVal).val();
		var episodeId=parent.frames[2].$('#admissionNo'+indexVal).val();
		var admissionDate=parent.frames[2].$('#admissionDate'+indexVal).val();
		var newdate=admissionDate.split(" ");
		admissionDate = newdate[0].split("/").reverse().join("-") +" "+newdate[1];
		var wsNo=$('#WS_NO').val();
		var userId=$('#p_user_id').val();
		$.ajax({
			type:"POST",
			url:"../jsp/IntermDraftReportValidation.jsp",
			data:"CalledFor=prcsBedCharge"+
			"&patient_Id="+patient_Id+
			"&episodeType="+episodeType+
			"&episodeId="+episodeId+
			"&admissionDate="+admissionDate+
			"&facId="+facility_id+
			"&wsNo="+wsNo+
			"&userId="+userId,
			dataType:"text",
			async:false,
			success: function(data){
				var responseText = trimString(data);
				var n1 = responseText.indexOf("~");
				var res1 = responseText.substr(n1+1);
				res1 = res1.split("~");
				if(res1[0]=="S"){
					$('#langHid').val("");
				}else if(res1[0]=="E"){    //V210228 modified
					alert(getMessage(res1[2],'BL'));
					return false;
				}else{
					 alert(res1[3]);
					 $('#langHid').val("");
				}
				},
				 error: function(data){
					 $('#langHid').val("");
					 alert(data);
			  }
		});	
		}
		}
	});
	
	$('#Recalculate').click(function(){
		var siteIdVal= $('#siteIdVal').val();
		if(checkBackJob(siteIdVal)){
		if (confirm('Do you want to confirm?')) {
			var frmAdminCode= $('#FrmAdmissionNo').val();
			var toAdminCode= $('#ToAdmissionNo').val();
			if(frmAdminCode!=toAdminCode){
				alert("Recalculation can be done only for same encounter");
			}else{
			var facility_id= $('#facilityId').val();
			var selectRow=$('#selectedRow').val();
			var indexVal=selectRow.substr(selectRow.length-1);
			var patient_Id=parent.frames[2].$('#patientId'+indexVal).val();
			var episodeType=parent.frames[2].$('#episodeType'+indexVal).val();
			var episodeId=parent.frames[2].$('#admissionNo'+indexVal).val();
			var wsNo=$('#WS_NO').val();
			var userId=$('#p_user_id').val();
			$.ajax({
				type:"POST",
				url:"../jsp/IntermDraftReportValidation.jsp",
				data:"CalledFor=reCalculate"+
				"&patient_Id="+patient_Id+
				"&episodeType="+episodeType+
				"&episodeId="+episodeId+
				"&facId="+facility_id+
				"&wsNo="+wsNo+
				"&userId="+userId,
				dataType:"text",
				async:false,
				success: function(data){
					var responseText = trimString(data);
					var n1 = responseText.indexOf("~");
					var res1 = responseText.substr(n1+1);
					res1 = res1.split("~");
					if(res1[0]=="S"){
						
					}else if(res1[0]=="E"){    //V210228 modified
						if(res1[1]==""){
							alert(res1[3]);
						}else{
							alert(getMessage(res1[1],'BL'));
						}
					}
					},
					 error: function(data){
						 alert(data);
				  }
			});	
			}
		} 
		}
	});
	
	$('#SearchBtn').click(function(){
		var siteIdVal= $('#siteIdVal').val();
		var searchFlag="false";
		var frmWardCode= $('#FrmNursingUnit').val();
		var toWardCode= $('#ToNursingUnit').val();
		var frmAdminCode= $('#FrmAdmissionNo').val();
		var toAdminCode= $('#ToAdmissionNo').val();
		var frmServDate= $('#frmServDate').val();
		var toServDate= $('#ToServDate').val();
		var frmBillServGrp= $('#FrmBillServGrp').val();
		var toBillServGrp= $('#ToBillServGrp').val();
		var siteSpec= $('#servDateGrpSiteSpec').val();
		//V210226 Starts
		if(siteSpec){
			if(frmWardCode=="" && toWardCode=="" && frmAdminCode=="" && toAdminCode=="" && frmServDate=="" && toServDate=="" && frmBillServGrp=="" && toBillServGrp==""){
				alert(getMessage("BL7448",'BLEXT'));
				return false;
			}else
				searchFlag="true";
		}else{
			if(frmWardCode=="" && toWardCode=="" && frmAdminCode=="" && toAdminCode==""){
				alert(getMessage("BL7448",'BLEXT'));
				return false;
			}else
				searchFlag="true";
		}
		//V210226 Ends
		if(checkBackJob(siteIdVal) && searchFlag=="true"){   //Modified V210226
		var facility_id= $('#facilityId').val();
		var reportType= $('#reportType').val();
		var billStageVal= $('#billStageVal').val();
		var option= $('#option').val();
		option = (option=="" || option==null) ? 'N' : option;
		var payableType= $('#payableType').val();
		var Payer= $('#Payer').val();
		var PayerAmtExceed= $('#PayerAmtExceed').val();
		$.ajax({
			type:"POST",
			url:"../jsp/IntermDraftReportValidation.jsp",
			data:"CalledFor=searchPatient"+
				"&facId="+facility_id+
				"&reportType="+reportType+
				"&option="+option+
				"&frmWardCode="+frmWardCode+
				"&toWardCode="+toWardCode+
				"&frmAdminCode="+frmAdminCode+
				"&toAdminCode="+toAdminCode+
				"&payableType="+payableType+
				"&Payer="+Payer+
				"&billStageVal="+billStageVal+
				"&frmServDate="+frmServDate+
				"&toServDate="+toServDate+
				"&frmBillServGrp="+frmBillServGrp+
				"&toBillServGrp="+toBillServGrp+
				"&PayerAmtExceed="+PayerAmtExceed,
			dataType:"text",
			async:false,
			success: function(data){
				var responseText = trimString(data);
				var n1 = responseText.indexOf("~");
				var res1 = responseText.substr(n1+1);
				res1 = res1.split("~");
				if(res1[0]=="S"){
					var jsonArr = JSON.parse(res1[1]);
					var patDtlsTbeName=parent.frames[2].document.getElementById("patientDtlsTbl");
					var rowCount = patDtlsTbeName.rows.length;
					if(jsonArr.length>0){
						$("#SearchBtn").attr('value', 'As on: '+getCurrentDateTime());
					if(rowCount>1){
						for(var s=rowCount;s>1;s--){
							parent.frames[2].document.getElementById("patientDtlsTbl").deleteRow(s-1);
						}
					}
					var colCount = patDtlsTbeName.rows[0].cells.length;
					for(var r=0;r<jsonArr.length;r++){
						var newRow = patDtlsTbeName.insertRow(r+1);
						newRow.setAttribute("id","patientRow"+r);
						if(jsonArr.length==1)
							$('#selectedRow').val("patientRow"+r);
						var jsonVal = jsonArr[r];
						for(var i=0; i<colCount; i++) {
							var newCell	= newRow.insertCell(i);
							if(i==0){
								newCell.innerHTML ="<input type='text' style='text-align:center;font-weight:bold;' maxlength='100' name='patientId"+r+"' id='patientId"+r+"' value='"+jsonVal.patId+"' onfocus='this.blur()' readonly>";
							}else if(i==1){
								newCell.innerHTML ="<input type='text' style='text-align:center;font-weight:bold;' maxlength='100' name='patientName"+r+"' id='patientName"+r+"' value='"+jsonVal.patName+"' onfocus='this.blur()' readonly>";
							}else if(i==2){
								var episodeTypeVal="";
								if(jsonVal.episodeType=="I"){
									episodeTypeVal="Inpatient";
								}else if(jsonVal.episodeType=="O"){
									episodeTypeVal="Outpatient";
								}else if(jsonVal.episodeType=="A"){
									episodeTypeVal="All";
								}else if(jsonVal.episodeType=="R"){
									episodeTypeVal="Referral";
								}else if(jsonVal.episodeType=="E"){
									episodeTypeVal="Emergency";
								}else if(jsonVal.episodeType=="D"){
									episodeTypeVal="Daycare";
								}
								newCell.innerHTML ="<select name='episodeType"+r+"' id='episodeType"+r+"' style='text-align:center; width:100px;font-weight:bold;' id='episodeType"+r+"' onfocus='this.blur()' readonly><option value='"+jsonVal.episodeType+"' >"+episodeTypeVal+"</option></select>";
							}else if(i==3){
								newCell.innerHTML ="<input type='text' style='text-align:center;font-weight:bold;' maxlength='100' name='admissionNo"+r+"' id='admissionNo"+r+"' value='"+jsonVal.admissNo+"' onfocus='this.blur()' readonly>";
							}else if(i==4){//V210226 Starts 
								var date=jsonVal.admissDate;
								var newdate=date.split(" ");
								date = newdate[0].split("-").reverse().join("/") +" "+newdate[1];
								newCell.innerHTML ="<input type='text' style='text-align:center;font-weight:bold;' maxlength='100' name='admissionDate"+r+"' id='admissionDate"+r+"' value='"+date+"' onfocus='this.blur()' readonly >";
								//V210226 Ends
							}else if(i==5){
								newCell.innerHTML ="<input type='text' style='text-align:center;font-weight:bold;' maxlength='100' name='nursingUnit"+r+"' id='nursingUnit"+r+"' value='"+jsonVal.nurseUnit+"' onfocus='this.blur()' readonly>";
							}else if(i==6){
								newCell.innerHTML ="<input type='text' style='text-align:center;font-weight:bold;' maxlength='100' name='room"+r+"' id='room"+r+"' value='"+jsonVal.rooM+"' onfocus='this.blur()' readonly>";
							}else if(i==7){
								newCell.innerHTML ="<input type='text' style='text-align:center;font-weight:bold;' maxlength='100' name='custCode"+r+"' id='custCode"+r+"' value='"+jsonVal.custCode+"' onfocus='this.blur()' readonly>";
							}else if(i==8){
								newCell.innerHTML ="<input type='text' style='text-align:center;font-weight:bold;' maxlength='100' name='bed"+r+"' id='bed"+r+"' value='"+jsonVal.beD+"' onfocus='this.blur()' readonly>";
							}else if(i==9){
								newCell.innerHTML ="<input type='text' style='text-align:center;font-weight:bold;' maxlength='100' name='bedClass"+r+"' id='bedClass"+r+"' value='"+jsonVal.bedClass+"' onfocus='this.blur()' readonly>";
							}else if(i==10){
								var unBilledAmt=parseFloat(jsonVal.unbilledAmt).toFixed(2); //Added V210226
								newCell.innerHTML ="<input type='text' style='text-align:center;font-weight:bold;' maxlength='100' name='UnbilledAmt"+r+"' id='UnbilledAmt"+r+"' value='"+unBilledAmt+"' onfocus='this.blur()' readonly>";//Modified V210226
							}else if(i==11){
								var unadjustAmt=parseFloat(jsonVal.unadjustAmt).toFixed(2); //Added V210226
								newCell.innerHTML ="<input type='text' style='text-align:center;font-weight:bold;' maxlength='100' name='unadjustAmt"+r+"' id='unadjustAmt"+r+"' value='"+unadjustAmt+"' onfocus='this.blur()' readonly>";//Modified V210226
							}else if(i==12){
								var outStandAmt=parseFloat(jsonVal.outStandAmt).toFixed(2); //Added V210226
								newCell.innerHTML ="<input type='text' style='text-align:center;font-weight:bold;' maxlength='100' name='outstndAmt"+r+"' id='outstndAmt"+r+"' value='"+outStandAmt+"' onfocus='this.blur()' readonly>";//Modified V210226
							}else if(i==13){
								var totalAmt=parseFloat(jsonVal.totalAmt).toFixed(2); //Added V210226
								newCell.innerHTML ="<input type='text' style='text-align:center;font-weight:bold;' maxlength='100' name='totAmt"+r+"' id='totAmt"+r+"' value='"+totalAmt+"' onfocus='this.blur()' readonly>"; //Modified V210226
							}else if(i==14){
								newCell.innerHTML ="<input type='text' style='text-align:center;font-weight:bold;' maxlength='100' name='dischrgeAdviceYN"+r+"' id='dischrgeAdviceYN"+r+"' value='"+jsonVal.disChrgeAdvStatus+"' onfocus='this.blur()' readonly>";
							}else if(i==15){
								newCell.innerHTML ="<input type='text' style='text-align:center;font-weight:bold;' maxlength='100' name='dischrgeAdviceDate"+r+"' id='dischrgeAdviceDate"+r+"' value='"+jsonVal.disChrgeAdvDate+"' onfocus='this.blur()' readonly>";
							}else if(i==16){
								newCell.innerHTML ="<input type='text' style='display:none;' hidden name='blngGrpId"+r+"' id='blngGrpId"+r+"' value='"+jsonVal.blngGrpId+"' >";
							}else if(i==17){
								newCell.innerHTML ="<input type='text' style='display:none;' hidden name='creditDocRefDesc"+r+"' id='creditDocRefDesc"+r+"' value='"+jsonVal.creditDocRefDesc+"' >";
							}
						}
					}	
				}else{
					alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));
					if(rowCount>1){
						for(var s=rowCount;s>1;s--){
							parent.frames[2].document.getElementById("patientDtlsTbl").deleteRow(s-1);
						}
					}
				}
				}else{
					 alert(res1[1]);
				}
				},
				 error: function(data){
					 alert(data);
			  }
		});
		}
	});
});


function admnolkp(admissionno,calledfor)
{
	var from_nursing_unit=$('#FrmNursingUnit').val();
	var to_nursing_unit=$('#ToNursingUnit').val();
	var billStage=$('#billStageVal').val();
	var facility_id = $('#facilityId').val();
	//var locale   =  $('#Language').val();
	var locale;
	var languageSiteSpec=document.forms[0].languageSiteSpec.value;
	if(languageSiteSpec=="true" || languageSiteSpec==true){
		locale   =  $('#Language').val();
	}else{
		locale=document.forms[0].locale.value;
	}//V231218-RBU-GHL-CRF-0023 and RBU-GHL-CRF-0025 
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;					
	var title = encodeURIComponent(getLabel("Common.AdmissionNo.label","common"));
	var column_sizes = escape("35%,35%,30%");               			
	var admno = encodeURIComponent(getLabel("Common.AdmissionNo.label","common"));
	var pat_id = encodeURIComponent(getLabel("Common.patientId.label","common"));
	var pat_name= encodeURIComponent(getLabel("Common.PatientName.label","common"));
	var column_descriptions =admno+","+pat_id+","+pat_name;
	//var sql="SELECT episode_id, patient_id, short_name  FROM lov_view WHERE facility_id ='"+facility_id+"'   AND (episode_type = 'I' OR episode_type = 'D')  AND cur_ward_code BETWEEN NVL ('"+from_nursing_unit+"' , '!!') AND NVL ('"+to_nursing_unit+"', '~~') "; 		
//	var sql="SELECT to_char(B.EPISODE_ID) EPISODE_ID,B.PATIENT_ID PATIENT_ID, decode(UPPER('"+locale+"'),'EN', D.short_name, D.short_name_loc_lang) SHORT_NAME FROM IP_OPEN_EPISODE A,  BL_EPISODE_FIN_DTLS B,  IP_EPISODE C,  MP_PATIENT_MAST D WHERE A.PATIENT_ID = B.PATIENT_ID   AND A.PATIENT_ID = C.PATIENT_ID  AND A.PATIENT_ID = D.PATIENT_ID   AND A.OPEN_EPISODE_ID = B.EPISODE_ID    AND A.OPEN_EPISODE_ID = C.EPISODE_ID     AND A.FACILITY_ID = '"+facility_id+"' AND B.OPERATING_FACILITY_ID = A.FACILITY_ID  AND C.FACILITY_ID = A.FACILITY_ID    AND (B.EPISODE_TYPE = 'I' or B.EPISODE_TYPE = 'D')    AND C.CUR_WARD_CODE BETWEEN NVL('"+from_nursing_unit+"','!!!!') AND NVL('"+to_nursing_unit+"','~~~~')     AND NVL(B.DISCHARGE_BILL_GEN_IND,'N') = 'N'";
//Corrected for PE Changes
	var sql="";
	var CalledFrom="";
	if(calledfor=="Frm"){
		CalledFrom="IntermDraftFrm";
		sql="SELECT EPISODE_ID EPISODE_ID,PATIENT_ID PATIENT_ID,SHORT_NAME SHORT_NAME FROM "+   //V210226 Modified (Space Removed)
		"( "+
		"SELECT B.EPISODE_ID EPISODE_ID, B.PATIENT_ID PATIENT_ID, "+ /* D.SHORT_NAME*/ 
		 "decode(UPPER('"+locale+"'),'EN', D.short_name, D.short_name_loc_lang)SHORT_NAME  "+
		"FROM IP_OPEN_EPISODE A, "+
		 "          BL_EPISODE_FIN_DTLS B,  "+
		 "          IP_EPISODE C, "+
		 "          MP_PATIENT_MAST D "+
		"WHERE A.PATIENT_ID = B.PATIENT_ID "+
		     "AND A.PATIENT_ID = C.PATIENT_ID "+
		     "AND A.PATIENT_ID = D.PATIENT_ID "+
		     "AND A.OPEN_EPISODE_ID = B.EPISODE_ID "+
		     "AND A.OPEN_EPISODE_ID = C.EPISODE_ID "+
		     "AND A.FACILITY_ID = '"+facility_id+"' "+
		     "AND B.OPERATING_FACILITY_ID = A.FACILITY_ID "+
		     "AND C.FACILITY_ID = A.FACILITY_ID "+
		     "AND (B.EPISODE_TYPE = 'I' or B.EPISODE_TYPE = 'D')  "+
		     "AND C.CUR_WARD_CODE BETWEEN NVL( '"+from_nursing_unit+"' ,'!!!!') AND NVL( '"+to_nursing_unit+"' ,'~~~~') "+
		     "AND NVL(B.DISCHARGE_BILL_GEN_IND,'N') = 'N'  "+
		     "AND "+billStage+"='1' "+
		      "union "+
		     "SELECT B.EPISODE_ID EPISODE_ID, B.PATIENT_ID PATIENT_ID, "+ /* D.SHORT_NAME*/
		    "decode(UPPER('"+locale+"'),'EN', D.short_name, D.short_name_loc_lang)SHORT_NAME  "+
		     "FROM       BL_EPISODE_FIN_DTLS B,  "+
		      "     IP_EPISODE C, "+
		      "     MP_PATIENT_MAST D "+
		     "WHERE B.PATIENT_ID = C.PATIENT_ID "+
		     "AND C.PATIENT_ID = D.PATIENT_ID "+
		     "AND B.EPISODE_ID = C.EPISODE_ID "+
		     "AND B.OPERATING_FACILITY_ID ='"+facility_id+"' "+
		     "AND B.OPERATING_FACILITY_ID = C.FACILITY_ID "+
		     "AND C.CANCELLATION_DATE_TIME IS NULL "+
		     "AND (B.EPISODE_TYPE = 'I' or B.EPISODE_TYPE = 'D')  "+
		     "AND C.CUR_WARD_CODE BETWEEN NVL('"+from_nursing_unit+"' ,'!!!!') AND NVL('"+to_nursing_unit+"','~~~~') "+
		     "AND NVL(B.DISCHARGE_BILL_GEN_IND,'N') = 'N'  "+
		     "AND "+billStage+"='2' "+
		     ") ";
	}else if(calledfor=="To"){
		CalledFrom="IntermDraftTo";
		sql="SELECT A.EPISODE_ID EPISODE_ID, "+
			"A.PATIENT_ID PATIENT_ID,  "+
			"B.SHORT_NAME SHORT_NAME "+
			"FROM   BL_EPISODE_FIN_DTLS A, "+
			"MP_PATIENT_MAST B, "+
			"IP_EPISODE C "+
			"WHERE  "+	
			"A.OPERATING_FACILITY_ID ='"+facility_id+"' AND  "+
			"A.EPISODE_TYPE in ('I','D') AND "+
			"A.OPERATING_FACILITY_ID = C.FACILITY_ID AND "+
			"A.PATIENT_ID   = B.PATIENT_ID AND "+
			"C.PATIENT_ID = A.PATIENT_ID AND     "+
			"C.EPISODE_ID = A.EPISODE_ID AND     "+
			"C.CUR_WARD_CODE           = DECODE('"+to_nursing_unit+"',NULL,C.CUR_WARD_CODE,'"+to_nursing_unit+"') AND   "+
			"NVL(A.DISCHARGE_BILL_GEN_IND,'N') = 'N'";
	}

	sql=escape(sql);
	var message='';
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"message="+message+"&target="+encodeURIComponent(admissionno.value)+"&srch_by_clmn_index=1"+"&col_show_hide=YYY&Called="+CalledFrom+"&"+"sql="+encodeURI(sql);
	retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);
	var arr=new Array();					
	if (retVal != null || retVal!="")
	{
		if(retVal!='undefined' && retVal!=undefined)
		{
			retVal=unescape(retVal);
			
			if(retVal != null && retVal.length>0)
			{
				
				//arr=retVal.split("::");
				arr=retVal.split("^~^");
				admissionno.value=arr[0];
				//V210226 Starts
				if(calledfor=="Frm"){
					$('#ToAdmissionNo').val(arr[0]);
				}else if(calledfor=="To"){
					$('#FrmAdmissionNo').val(arr[0]);
				}
				//V210226 Ends
			}
		}
	
	else{
		admissionno.value="";
		$('#FrmAdmissionNo').val("");
		$('#ToAdmissionNo').val("");
	}
	}
	else{
		admissionno.value="";
		$('#FrmAdmissionNo').val("");
		$('#ToAdmissionNo').val("");
	}
}

function interDraftCommonLookup(obj, code,lookupName){
	var facilityId = $('#facilityId').val();
	//var locale   =  $('#Language').val();
	var locale;
	var formObj  = document.forms[0];
	var languageSiteSpec=formObj.languageSiteSpec.value;
	if(languageSiteSpec=="true" || languageSiteSpec==true){
		locale   =  $('#Language').val();
	}else{
		locale=formObj.locale.value;
	}//V231218-RBU-GHL-CRF-0023 and RBU-GHL-CRF-0025 
	var codeVal=code.value;
    codeVal = (codeVal=="" || codeVal==null || codeVal==undefined) ? '' : codeVal;
    var title = "";
	var sql   = "";
	switch (lookupName) {
		case 'nurseUnitFrm' :{
			sql="SELECT G.SHORT_DESC description,G.nursing_unit_code code "+
			"FROM ip_nursing_unit_lang_vw G "+
			"WHERE G.FACILITY_ID = '"+facilityId+"' " +
			"AND LANGUAGE_ID='"+locale+"' "+ 
			"and UPPER (G.SHORT_DESC) LIKE UPPER (?) AND UPPER (G.nursing_unit_code) LIKE UPPER (?) ORDER BY 1";
			title = getLabel("eBL.From.label", 'bl') +" "+ getLabel("eBL.NursingUnit.label", 'bl');
			break;
		}
		case 'nurseUnitTo' :{
			sql="SELECT distinct(G.SHORT_DESC) description ,D.CUR_WARD_CODE  code "+
			"FROM IP_WARD  G,IP_EPISODE D "+
			"WHERE G.WARD_CODE= D.CUR_WARD_CODE "+
			"AND G.FACILITY_ID=D.FACILITY_ID "+        
			"AND UPPER (G.SHORT_DESC) LIKE UPPER (?) AND UPPER (D.CUR_WARD_CODE) LIKE UPPER (?)  order by 1";
			title = getLabel("eBL.To.label", 'bl') +" "+ getLabel("eBL.NursingUnit.label", 'bl');
			break;
		}
		case 'Payer' :{
			sql="select long_name description,cust_code code from ar_customer_lang_vw where language_id='"+locale+"' "+ 
			"and UPPER (long_name) LIKE UPPER (?) AND UPPER (cust_code) LIKE UPPER (?) ORDER BY 2";
			title=getLabel("eBL.PAYER.label", 'bl');
			codeVal=obj.value;
			break;
		}
		
	}
	    var argumentArray  							= 	new Array() ;
		var dataNameArray  							= 	new Array() ;
		var dataValueArray 							= 	new Array() ;
		var dataTypeArray  							= 	new Array() ;
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray;
	    argumentArray[2] = dataValueArray;
	    argumentArray[3] = dataTypeArray;
	    argumentArray[4] = "1,2";							
	    argumentArray[5] = codeVal;
	    argumentArray[6] = CODE_LINK;						
	    argumentArray[7] = CODE_DESC;						

	retVal 										=   CommonLookup( title, argumentArray );
	if(retVal != null && retVal != "")
	{
		obj.value			=   retVal[0];
		var payableType=$('#payableType').val();
		if(lookupName =="Payer"){
	        $("#PayerHid").attr('disabled', false);
	        $('#PayerHid').val(retVal[1]);
	        $("#PayerHid").attr('disabled', true);
	        if(payableType=="P" || payableType=="B"){
	        	$('#Payer').val(""); 
	        	$('#PayerHid').val("");
	        }else{//Populating Payer name based on the code
	        	$.ajax({
	    			type:"POST",
	    			url:"../jsp/IntermDraftReportValidation.jsp",
	    			data:"CalledFor=popPayerName"+
	    				"&locale="+locale+
	    				"&payerCode="+ retVal[0],
	    			dataType:"text",
	    			async:false,
	    			success: function(data){
	    				var responseText = trimString(data);
	    				var n1 = responseText.indexOf("~");
	    				var res1 = responseText.substr(n1+1);
	    				res1 = res1.split("~");
	    				if(res1[0]=="S"){
	    					$("#PayerHid").attr('disabled', false);
	    			        $('#PayerHid').val(res1[1]);
	    			        $("#PayerHid").attr('disabled', true);
	    				}else{
	    					 alert(res1[1]);
	    				}
	    				},
	    				 error: function(data){
	    					 alert(data);
	    			  }
	    		});	
	        }
	        }else{
	        	code.value 			= 	retVal[1];

	        	//V210226 Starts
	        	if(lookupName=="nurseUnitFrm"){
					$('#ToNursingUnit').val(retVal[0]);
					$('#ToNursingUnitHid').val(retVal[1]);
				}else if(lookupName=="nurseUnitTo"){
					$('#FrmNursingUnit').val(retVal[0]);
					$('#FrmNursingUnitHid').val(retVal[1]);
				}
	        	//V210226 Ends
	        }
	}
	else
	{
        obj.value = '';
        if(lookupName =="Payer"){
        $("#PayerHid").attr('disabled', false);
        code.value = '';
        $("#PayerHid").attr('disabled', true);
        }else{
        	 code.value = '';
        }
	}

}




function reset() {
	IntermDraftReport.document.location.reload();   
	IntermDraftReportTable.document.location.reload();         
	IntermDraftReport.document.location.href = '../../eCommon/jsp/blank.html';  
}

function process(date){
	   var parts = date.split("/");
	   return new Date(parts[2], parts[1] - 1, parts[0]);
	}


function dateRegEx(e){  //Added for Character Restriction in date field
	  var pattern = new RegExp("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$");			
	  if (e.value.search(pattern)===0){															
	    return true;
	  }
	  else {
	    alert("Please provide valid date in format DD/MM/YYYY");											
	    document.getElementById(e.id).value=getCurrentDate();									
	    document.getElementById(e.id).focus();
	    return false; 
	  } 
}

function getCurrentDate()								
{
	var currentdate = new Date(); 
		var month=("0" + (currentdate.getMonth() + 1)).slice(-2);
		datetime = 	   currentdate.getDate() + "/"
				+  month  + "/" 
				+  currentdate.getFullYear();
				return datetime;
}

//Function to Trim String
function trim(str) {
	if(str != ""){
		return str.replace(/^\s+|\s+$/g,'');
	}
	return "";
} 


function moveFrame() {
	var temp = document.body.scrollLeft;
	scrollValue = temp;

	if (parent.IntermDraftReport.location.href.indexOf(".jsp") != -1) {
		parent.IntermDraftReport.document.body.scrollLeft = temp;
	}
}

function payTypeChange(s){
	var payableType=s.value;
	if(payableType == "P" || payableType == "B"){
		$('#Payer').val("");
		$('#PayerHid').val("");
	}
}

function onBlurEvent(r){
	if(r=="1"){
		var frmAdmNo=$('#FrmAdmissionNo').val();
		var toAdmNo= $('#ToAdmissionNo').val();
		if(frmAdmNo!="" && toAdmNo!="" && frmAdmNo>toAdmNo){
			alert(getMessage("BL7060",'BL'));
			return false;
		}
	}
}

function getCurrentDateTime()								//V201222 Modified
{
	var currentdate = new Date(); 
	var minutes=currentdate.getMinutes();
	if(minutes.length==1){
		minutes="0"+minutes;
	}
		var month=("0" + (currentdate.getMonth() + 1)).slice(-2);
		datetime = 	   currentdate.getDate() + "/"
		+  month  + "/" 
		+  currentdate.getFullYear()+ " "  
		+  currentdate.getHours() + ":"  
		+  minutes+ ":"
		+  currentdate.getSeconds();
				return datetime;
}

function checkBackJob(siteId){
	if(siteId=="ALMO"){
		var FacId= window.frames["IntermDraftReport"].$('#facilityId').val();
		var frmEpisodeId= window.frames["IntermDraftReport"].$('#FrmAdmissionNo').val();
		var toEpisodeId= window.frames["IntermDraftReport"].$('#ToAdmissionNo').val();
		$.ajax({
			type:"POST",
			url:"../jsp/IntermDraftReportValidation.jsp",
			data:"CalledFor=backJobCheck"+
				"&facId="+FacId+
				"&frmEpisodeId="+frmEpisodeId+
				"&toEpisodeId="+toEpisodeId,
			dataType:"text",
			async:false,
			success: function(data){
				var responseText = trimString(data);
				var n1 = responseText.indexOf("~");
				var res1 = responseText.substr(n1+1);
				res1 = res1.split("~");
				if(res1[0]=="S" && res1[1]!=""){
				 $('#dialog-confirm').dialog('open');
				}
				},
				error: function(data){
					alert(data);
			    }
			});	
	}else{
		return true;
	}
}


function run() {
	var siteIdVal= window.frames["IntermDraftReport"].$('#siteIdVal').val();
	var admFlag="true";
	var frmAdmNo= window.frames["IntermDraftReport"].$('#FrmAdmissionNo').val();
	var toAdmNo= window.frames["IntermDraftReport"].$('#ToAdmissionNo').val();
	if(frmAdmNo==''){
		alert(getMessage("BL00948",'BL'));
		window.frames["IntermDraftReport"].$('#FrmAdmissionNo').focus();
		admFlag="false";
		return false;
	}//V231221 RBU-GHL-CRF-0023
	if(frmAdmNo!=toAdmNo){
		alert(getMessage("BL2098",'BLEXT'));
		admFlag="false";
		return false;
	}
	if(checkBackJob(siteIdVal) && admFlag=="true"){
	var servDateGrpSiteSpec=window.frames["IntermDraftReport"].$("#servDateGrpSiteSpec").val();
	if(servDateGrpSiteSpec==true){
		servDateGrpSiteSpec ='Y';
	}else{
		servDateGrpSiteSpec ='N';
	}
	var detailCheked="N";
	if(window.frames["IntermDraftReport"].$("#detailRprtChkbx").prop('checked') == true){
		 detailCheked="Y";
	}
	var facility_id = window.frames["IntermDraftReport"].$('#facilityId').val();
	//var Locale=window.frames["IntermDraftReport"].$("#Language").val();
	var Locale;
	var languageSiteSpec=window.frames["IntermDraftReport"].$("#languageSiteSpec").val();
	if(languageSiteSpec=="true" || languageSiteSpec==true){
		Locale   =  window.frames["IntermDraftReport"].$("#Language").val();
	}else{
		Locale=window.frames["IntermDraftReport"].$("#locale").val();
	}//V231218-RBU-GHL-CRF-0023 and RBU-GHL-CRF-0025 
	var frmServDate= window.frames["IntermDraftReport"].$('#frmServDate').val();
	frmServDate = (frmServDate=="" || frmServDate==null) ? '01/01/1900' : frmServDate;
	var toServDate= window.frames["IntermDraftReport"].$('#ToServDate').val();
	toServDate = (toServDate=="" || toServDate==null) ? '31/12/4900' : toServDate;
	var frmBillServGrp= window.frames["IntermDraftReport"].$('#FrmBillServGrp').val();
	var toBillServGrp= window.frames["IntermDraftReport"].$('#ToBillServGrp').val();
	var wsNo=window.frames["IntermDraftReport"].$('#WS_NO').val();
	var userId=window.frames["IntermDraftReport"].$('#p_user_id').val();
	var p_report_id="BLRBLPRT";
	var p_module_id = "BL";
	//Retrieving Table Values
	var patDtlsTbeName=window.frames["IntermDraftReportTable"].document.getElementById("patientDtlsTbl");
	var rowCount = patDtlsTbeName.rows.length;
	var data = [];
	if(rowCount>1){
		for(var t=0;t<rowCount-1;t++){
			var obj = {};
			var patId=window.frames["IntermDraftReportTable"].$('#patientId'+t).val();
			var episodeType=window.frames["IntermDraftReportTable"].$('#episodeType'+t).val();
			var episodeId=window.frames["IntermDraftReportTable"].$('#admissionNo'+t).val();
			var blngGrp=window.frames["IntermDraftReportTable"].$('#blngGrpId'+t).val();
			var custDocRefDesc=window.frames["IntermDraftReportTable"].$('#creditDocRefDesc'+t).val();
			var custCode=window.frames["IntermDraftReportTable"].$('#custCode'+t).val();
			obj['patId']=patId;
			obj['episodeType']=episodeType;
			obj['episodeId']=episodeId;
			obj['blngGrp']=blngGrp;
			obj['custDocRefDesc']=custDocRefDesc;
			obj['custCode']=custCode;
			data.push(obj);
		}
	}
	$.ajax({
		type:"POST",
		url:"../jsp/IntermDraftReportValidation.jsp",
		data:"CalledFor=reportGeneration"+
			"&facId="+facility_id+
			"&p_report_id="+p_report_id+
			"&data="+JSON.stringify(data)+
			"&param6="+detailCheked+
			"&param7=I"+
			"&param17="+userId+
			"&param8="+Locale+
			"&param21="+frmServDate+
			"&param22="+toServDate+
			"&param23="+frmBillServGrp+
			"&param24="+toBillServGrp+
			"&param25="+servDateGrpSiteSpec,
		dataType:"text",
		async:false,
		success: function(data){
			var dummyDoc = window.frames["dummy_frame"].document;
			var responseText = trimString(data);
			var n1 = responseText.indexOf("~");
			var res1 = responseText.substr(n1+1);
			res1 = res1.split("~");
			var retVal = trimString(res1[1]).split(":::");
			var session_id;
			var pgm_date;
			var reportIdFinal;
			if(retVal.length == 3){
				session_id = trimString(retVal[0]);
				pgm_date = trimString(retVal[1]);
				reportIdFinal= trimString(retVal[2]);
			}
			var htmlVal = "<html><body>";
			htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
			htmlVal += "<input type='hidden' name='P_LANGUAGE_ID' id='P_LANGUAGE_ID' value='"+Locale+"'>";	
			htmlVal += "<input type='hidden' name='P_FACILITY_ID' id='P_FACILITY_ID' value='"+facility_id+"'>";
			htmlVal += "<input type='hidden' name='P_SESSION_ID' id='P_SESSION_ID' value='"+session_id+"'>";
			htmlVal += "<input type='hidden' name='P_PGM_DATE' id='P_PGM_DATE' value='"+trim(pgm_date)+"'>";
			htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+p_module_id+"'>";
			htmlVal += "<input type='hidden' name='P_PGM_ID' id='P_PGM_ID' value='"+reportIdFinal+"'>";	
			htmlVal += "<input type='hidden' name='SESSION_ID' id='SESSION_ID' value='"+session_id+"'>";
			htmlVal += "<input type='hidden' name='PGM_DATE' id='PGM_DATE' value='"+trim(pgm_date)+"'>";
			htmlVal += "<input type='hidden' name='PGM_ID' id='PGM_ID' value='"+reportIdFinal+"'>";	
			htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+reportIdFinal+"'>";	
			htmlVal += "</form></body></html>";
			dummyDoc.body.insertAdjacentHTML("afterbegin",htmlVal);
			dummyDoc.dummy_frm.submit();
			},
			error: function(data){
				alert(data);
		    }
		});	
	}
}

