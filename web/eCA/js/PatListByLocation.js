/*
-----------------------------------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------------------------------
?             100         ?           created
18/11/2011    IN29412     Dinesh T    AMS CRF
04/07/2012	  IN032180    Nijitha S   CA>Patient List By Location>System does not list the Unassigned OP patients.
08/01/2014	  IN045000    Nijitha S   ML-BRU-SCF-1130
06/04/2015	  IN048704	  Nijitha S	  HSA-CRF-0175
10/02/2016	  IN059126	  Karthi L	  By Location - System does not display Search, Clear & More Criteria buttons.
22/02/2016	  IN059520	  Ramesh G	
-----------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
05/10/2017	  IN063819		Krishna Gowtham	05/10/2017		Ramesh G			ML-MMOH-CRF-0805
23/10/2017	  IN064342		Krishna Gowtham		23/10/2017	Ramesh G			GHL-CRF-0468.1
08/07/2020     IN072184          Chandrashekar raju     	08/07/2020       Ramesh G      Modified for MMS-DM-CRF-0157.2
08/07/2020     IN072994          Chandrashekar raju    	08/07/2020			Ramesh G              Modified for MMS-DM-CRF-0170.1
14/09/2020	IN074034		Ramesh Goli			14/09/2020		Ramesh G			GHL-CRF-0613.1
12/02/2021	6451		SIVABAGYAM M		12/02/2021	RAMESH G	GHL-CRF-0623
-------------------------------------------------------------------------------------------------------------------------------
*/ 

clinicCodeArr = new Array();
clinicDescArr = new Array();
clinicTypeArr = new Array();
wardCodeArr = new Array();
wardDescArr = new Array();

dayCareCodArray =new Array();
dayCareDesArray =new Array();
OPEmerCodArray =new Array();
OPEmerDesArray =new Array();

function changeViewListValue(Obj)
{
	if(Obj.checked==true) 
	{
		document.forms[0].viewList.text=getLabel("Common.all.label","COMMON");
		document.forms[0].viewList.value='Z';
		document.PatCriteriaFrm.pract.disabled = false;
		document.PatCriteriaFrm.practSearch.disabled = false;
		document.PatCriteriaFrm.AttendPract.value = '';
		document.PatCriteriaFrm.pract.value = '';
	}
}

function checkthisnumber(obj){
	if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {		
		return true;
	}else{ 
  		if ( obj.value.length > 0 ){
			alert(getMessage("ONLY_NUMBER_ALLOWED","CA"));
  			obj.select();
  			obj.focus();
  			return false;
  		}
  	}
}

function locnTypeChange(obj)
{		
	if(obj== 'IP'  || obj == 'DC')
	{
		document.forms[0].QS.disabled=true;
		document.forms[0].CI.disabled=true;
		document.forms[0].AAN.disabled=true;
		document.forms[0].VS.disabled=true;				
		document.forms[0].CIP.disabled=true;
		document.forms[0].TI.disabled=true;
		document.forms[0].RFI.disabled=true;
		document.forms[0].CO.disabled=true;
		// commented below lines for IN059126
		/*if(parent.PatResultFr.resultFrameSet != null)
			parent.PatResultFr.resultFrameSet.rows="9%,0%,0%,*"; */
	}
	else
	{
		document.forms[0].QS.disabled=false;
		document.forms[0].CI.disabled=false;
		document.forms[0].AAN.disabled=false;
		document.forms[0].VS.disabled=false;				
		document.forms[0].CIP.disabled=false;
		document.forms[0].TI.disabled=false;
		document.forms[0].RFI.disabled=false;
		document.forms[0].CO.disabled=false;
	} 	

	if(obj == 'OP' || obj == 'EM')
	{
		document.getElementById('unscheduled').disabled = false;
		document.getElementById('past').disabled = false;
		document.getElementById('from_date1').value = '';
		document.getElementById('from_date1').disabled = false;
		document.getElementById('from_date11').value = '';
		document.getElementById('from_date11').disabled = false;
		document.getElementById('discharged').disabled = true;
		document.getElementById('from_date2').value = '';
		document.getElementById('from_date2').disabled = true;
		document.getElementById('from_date22').value = '';
		document.getElementById('from_date22').disabled = true;
		document.getElementById('past').checked=false;
		document.getElementById('discharged').checked = false;

		/*  if(document.forms[0].RP.checked == true)
		{
		document.forms[0].CBSR.disabled=true;
		document.forms[0].UCBSR.disabled=true;
		}
		else
		{
		document.forms[0].CBSR.disabled=true;
		document.forms[0].UCBSR.disabled=true;
		document.forms[0].OVR.disabled=true;
		document.forms[0].OCIP.disabled=true;
		document.forms[0].OA.disabled=true;
		document.forms[0].OAP.disabled=true;

		} */ 
	}
	else if(obj == 'IP' || obj == 'DC')
	{
		document.forms[0].unscheduled.disabled = true;
		document.forms[0].past.disabled = true;
		document.forms[0].from_date1.value = '';
		document.forms[0].from_date1.disabled = true;
		document.forms[0].from_date11.value = '';
		document.forms[0].from_date11.disabled = true;
		document.forms[0].discharged.disabled = false;
		document.forms[0].from_date2.disabled = false;
		document.forms[0].discharged.checked=false;
		document.forms[0].from_date22.value = '';
		document.forms[0].from_date2.value='';
		document.forms[0].from_date22.disabled = false;
		document.forms[0].from_date2.disabled=false;
		document.forms[0].unscheduled.checked = false;
		document.forms[0].past.checked = false;
		document.forms[0].adm_fromdate.value='';
		document.forms[0].adm_todate.value='';

		/*	if(document.forms[0].RP.checked == true)
		{
		document.forms[0].CBSR.disabled=false;
		document.forms[0].UCBSR.disabled=false;
		document.forms[0].OVR.disabled=false;
		document.forms[0].OA.disabled=false;
		document.forms[0].OCIP.disabled=true;
		document.forms[0].OAP.disabled=true;
		}
		else
		{
		document.forms[0].CBSR.disabled=true;
		document.forms[0].UCBSR.disabled=true;
		document.forms[0].OCIP.disabled=true;
		document.forms[0].OAP.disabled=true;
		document.forms[0].OVR.disabled=false;
		document.forms[0].OA.disabled=false;


		}*/	
	}
	else
	{ 
		document.forms[0].from_date1.value = '';
		document.forms[0].from_date2.value = '';
		document.forms[0].from_date11.value = '';
		document.forms[0].from_date22.value = '';
		document.forms[0].unscheduled.checked = false;
		document.forms[0].unscheduled.disabled = false;
		document.forms[0].past.disabled = false;
		document.forms[0].from_date1.disabled = false;
		document.forms[0].from_date11.disabled = false;
		document.forms[0].from_date22.disabled = false;
		document.forms[0].discharged.disabled = false;
		document.forms[0].from_date2.disabled = false;
		document.forms[0].past.checked = false;
		document.forms[0].discharged.checked = false;

		/*	if(document.forms[0].RP.checked == true)
		{
		document.forms[0].CBSR.disabled = false;
		document.forms[0].UCBSR.disabled= false;
		document.forms[0].OVR.disabled  = false;
		document.forms[0].OCIP.disabled = false;
		document.forms[0].OA.disabled   = false;
		document.forms[0].OAP.disabled  = false;

		}
		else
		{

		document.forms[0].CBSR.disabled=true;
		document.forms[0].UCBSR.disabled=true;
		document.forms[0].OVR.disabled=true;
		document.forms[0].OCIP.disabled=true;
		document.forms[0].OA.disabled=true;
		document.forms[0].OAP.disabled=true;


		} */
		document.getElementById("bedNo").value="";//IN29412
		var viewlist = document.forms[0].viewList.value;

		if(!viewlist=='S')
		{
			document.forms[0].locationCode.value = "";
		}
		else
		{
			document.forms[0].locationCode.value = "*ALL";
		}
	}

	if(obj == 'OP' || obj == 'EM')
	{
		document.getElementById("cal_di").disabled=true;
		document.getElementById("cal_di1").disabled=true;
		setVisitDate(document.forms[0].past);
	}
	else if(obj == 'IP' || obj == 'DC')
	{
		document.getElementById("cal_pv").disabled=true;
		document.getElementById("cal_pv1").disabled=true;
		setDischargeDate(document.forms[0].discharged);
	}

	document.getElementById("locLed").innerText=getLabel("Common.clinic.label","COMMON");
	document.getElementById("locVal").style.visibility='visible';
	document.getElementById("src_butn").style.visibility='visible';
	document.forms[0].locationDesc.disabled = false;
	document.forms[0].locationDesc.value="";
	document.getElementById("bedRow").style.display='none';//IN29412
	//var optlen = document.forms[0].locationCode.options.length;
	//for (i=0; i<optlen; i++){
	//	document.forms[0].locationCode.remove(0);
	//}

	if (obj == 'OP' || obj == 'EM' )
	{
		document.getElementById("wtl").style.display='none'; 
		document.getElementById("daysVal").style.visibility='hidden';
		document.getElementById("daysVal1").style.visibility='hidden';
		document.getElementById("adm_cal1").style.visibility='hidden';
		document.getElementById("adm_cal2").style.visibility='hidden';
	}
	else
	{
		document.getElementById("wtl").style.display='';
		document.getElementById("daysVal").style.visibility='visible';
		document.getElementById("daysVal1").style.visibility='visible';
		document.getElementById("adm_cal1").style.visibility='visible';
		document.getElementById("adm_cal2").style.visibility='visible';
	}

	if(obj == 'Z' )
	{
		document.getElementById("locLed").innerText='';
		document.getElementById("locVal").style.visibility='hidden';
		document.getElementById("src_butn").style.visibility='hidden';		
		//document.forms[0].locationDesc.disabled = true;
		document.getElementById("visitType").selectedIndex = 0;
		document.getElementById("visitType").disabled = true;
		//var oOption = document.createElement("OPTION");
		//oOption.text=getLabel("Common.all.label","COMMON");
		//oOption.value="*ALL";
		//document.forms[0].locationCode.add(oOption);
	}
	else if(obj == 'OP') 
	{
		document.getElementById("locLed").innerText=getLabel("Common.clinic.label","COMMON");
		document.forms[0].locationCode.value = "*ALL";//IN32180
		document.getElementById("visitType").disabled =false;
		//oOption = document.createElement("OPTION");
		//oOption.text=getLabel("Common.all.label","COMMON");
		//oOption.value="*ALL";
		//document.forms[0].locationCode.add(oOption);

		for(j=0; j<clinicCodeArr.length; j++)
		{
			if (clinicTypeArr[j]=='A')
			{
				//var oOption = document.createElement("OPTION");
				//oOption.text=clinicDescArr[j];
				//oOption.value=clinicCodeArr[j];
				//document.forms[0].locationCode.add(oOption);
			}	
		} 
		//document.forms[0].locationCode.selectedIndex = 1;
	}
	else if(obj == 'IP')
	{ 
		document.getElementById("locLed").innerText=getLabel("Common.nursingUnit.label","COMMON");
		document.getElementById("visitType").selectedIndex = 0;
		document.getElementById("visitType").disabled = true;
		//var oOption = document.createElement("OPTION");
		//oOption.text=getLabel("Common.all.label","COMMON");
		//	oOption.value="*ALL";
		//document.forms[0].locationCode.add(oOption);
		if(document.getElementById("hideBedNoYN").value=='N')  //IN074034
		document.getElementById("bedRow").style.display='inline';//IN29412
		for(j=0; j<wardCodeArr.length; j++) 
		{
			//var oOption = document.createElement("OPTION");
			//oOption.text=wardDescArr[j];
			//oOption.value=wardCodeArr[j];
			//document.forms[0].locationCode.add(oOption);
		}
	}
	else if (obj=='DC')
	{
		document.getElementById("locLed").innerText=getLabel("Common.DaycareUnit.label","COMMON");
		document.getElementById("visitType").selectedIndex = 0;
		document.getElementById("visitType").disabled = true;
		//var oOption = document.createElement("OPTION");
		//oOption.text=getLabel("Common.all.label","COMMON");
		//oOption.value="*ALL";
		//document.forms[0].locationCode.add(oOption);
		for(j=0; j<dayCareCodArray.length; j++) 
		{
		//var oOption = document.createElement("OPTION");
		//	oOption.text=dayCareDesArray[j];
		//oOption.value=dayCareCodArray[j];
		//	document.forms[0].locationCode.add(oOption);
		}
	}
	else if( obj=='EM')
	{
		document.getElementById("locLed").innerText=getLabel("Common.EmergencyUnits.label","COMMON");
		document.getElementById("visitType").selectedIndex = 0;
		document.getElementById("visitType").disabled = true;
		//var oOption = document.createElement("OPTION");
		//oOption.text=getLabel("Common.all.label","COMMON");
		//oOption.value="*ALL";
		//document.forms[0].locationCode.add(oOption);
		for(j=0; j<OPEmerCodArray.length; j++) 
		{
			//var oOption = document.createElement("OPTION");
			//oOption.text=OPEmerDesArray[j];
			//oOption.value=OPEmerCodArray[j];
			//	document.forms[0].locationCode.add(oOption);
		}
	}

	if (obj == 'IP' || obj == 'DC')
	{
		document.getElementById("queueStatus").style.visibility='hidden';
	}
	else 
	{
		document.getElementById("queueStatus").style.visibility='visible';
	}

	/**
	* Added on 01st Mar 2003 by Prakash.S
	* Enhancement in Search Result. 
	*/
	var checkValue = obj;

	if((checkValue=='OP') || (checkValue=='IP') || (checkValue=='DC') || (checkValue=='EM'))
	{
		document.getElementById("groupByEpisode").checked = true;
		document.getElementById("groupByEpisode").disabled = true;
		document.getElementById("groupByEpisode").value='Y';
	}
	else if(checkValue=='Z')
	{
		if(document.getElementById("groupByLocn").disabled)
		document.getElementById("groupByLocn").disabled = false;
		if(document.getElementById("groupByEpisode").disabled)
		document.getElementById("groupByEpisode").disabled = false;
	}	
}

function searchClick()
{
	/*
		Added by Kishore Kumar N 06-05-2010, Tuning by Filter date

		and form(0) is changed to "PatCriteriaFrm"
	*/
	var patientId = document.PatCriteriaFrm.patientId.value;
	var discharged = document.PatCriteriaFrm.discharged;
	var pastVist = document.PatCriteriaFrm.past;
	var fromDate = document.PatCriteriaFrm.from_date2;
	var toDate = document.PatCriteriaFrm.from_date22;
	var locale = document.PatCriteriaFrm.locale.value;
	var maxVisitDays = document.PatCriteriaFrm.maxVisitDays.value;
	var maxDistDays = document.PatCriteriaFrm.maxDistDays.value;
	var isDischarge = true;
	var assign_confirm_referral_yn = document.forms[0].assign_confirm_referral_yn.value;//IN048704
	var siteSpecific = document.PatCriteriaFrm.past_visit_site_YN.value; //IN063819

	if(fromDate.value != '' && toDate.value != '')
	{
		isDischarge = dateRangeValidation(fromDate, toDate, locale, maxDistDays, 'DMY');
	}
	else
	{
		//if (patientId == '' && discharged.checked)//Commented for IN045000
		if (discharged.checked)//IN045000
		{
			top.content.workAreaFrame.PatResultFr.location.href = "../../eCommon/html/blank.html";

			if(fromDate.value == '')
			{
				alert(getMessage("FROM_DATE_NOT_BLANK", "CA"));
				if (document.PatCriteriaFrm.more.value != getLabel("Common.lesscriteria.label","COMMON"))
				{
					makeVisible(document.PatCriteriaFrm.more,'N');
				}
				fromDate.focus();
				return false;
			}

			if(toDate.value == '')
			{
				alert(getMessage("TO_DATE_NOT_BLANK", "CA"));
				//IN063819 Start
				//if (!document.PatCriteriaFrm.more.value != getLabel("Common.lesscriteria.label","COMMON"))
				if (document.PatCriteriaFrm.more.value != getLabel("Common.lesscriteria.label","COMMON"))
				//IN063819 End
				{
					makeVisible(document.PatCriteriaFrm.more,'N');
				}
				toDate.focus();
				return false;
			}
			return false;			
		}
	}

	var patVistFromDate = document.PatCriteriaFrm.from_date1;
	var patVistToDate = document.PatCriteriaFrm.from_date11;
	var isPastVist = true;

	if(patVistFromDate.value != '' && patVistToDate.value != '')
	{
		isPastVist = dateRangeValidation(patVistFromDate, patVistToDate, locale, maxVisitDays, 'DMY');
	}
	else
	{
		//if (patientId == '' &&  pastVist.checked)//Commented for IN045000
		if (pastVist.checked)//IN045000
		{
			top.content.workAreaFrame.PatResultFr.location.href = "../../eCommon/html/blank.html";
			
			if(patVistFromDate.value == '')
			{
				alert(getMessage("FROM_DATE_NOT_BLANK", "CA"));
				if (document.PatCriteriaFrm.more.value !=getLabel("Common.lesscriteria.label","COMMON"))
				{
					makeVisible(document.PatCriteriaFrm.more,'N');
				}

				patVistFromDate.focus();
				return false;
			}

			if(patVistToDate.value == '')
			{
				alert(getMessage("TO_DATE_NOT_BLANK", "CA"));
				if (document.PatCriteriaFrm.more.value != getLabel("Common.lesscriteria.label","COMMON"))
				{
					makeVisible(document.PatCriteriaFrm.more,'N');
				}
				patVistToDate.focus();
				return false;
			}
			return false;
		}
	}
	//IN063819 start
	//if(patientId == '' && (!isDischarge || !isPastVist))
	if(patientId == '' && (!isDischarge || !isPastVist) && siteSpecific == "N")
	//IN063819 end
	{
		top.content.workAreaFrame.PatResultFr.location.href = "../../eCommon/html/blank.html";
		if(!isDischarge && !isPastVist)
		{
			var msg =  getMessage("PAT_LST_LOCN_PAST_DISCH_LMT", "CA");
			msg = msg.replace('$D', maxDistDays);
			msg = msg.replace('$V', maxVisitDays);
			alert(msg);
			return false;
		}

		if(!isDischarge)
		{

			var msg =  getMessage("PAT_LST_LOCN_DISCH_LMT", "CA");
			msg = msg.replace('$D', maxDistDays);
			alert(msg);
			return false;
		}

		if(!isPastVist)
		{
			var msg =  getMessage("PAT_LST_LOCN_PAST_LMT", "CA");
			msg = msg.replace('$V', maxVisitDays);
			alert(msg);
			return false;
		}
		return false;
	}
	/*

		ends here.
	*/

	if (document.PatCriteriaFrm.more.value==getLabel("Common.lesscriteria.label","COMMON"))
	makeVisible(document.PatCriteriaFrm.more,'N');
	
	var locationType = document.PatCriteriaFrm.locationType.value;
	var locationCode = document.PatCriteriaFrm.locationCode.value;
	
	var viewList = document.PatCriteriaFrm.viewList.value;
	var adm_fromdate = document.PatCriteriaFrm.daysVal.value;
	var adm_todate = document.PatCriteriaFrm.daysVal1.value;
	var groupByLocn = document.PatCriteriaFrm.groupByLocn.value;
	
	var groupByEpisode = document.PatCriteriaFrm.groupByEpisode.value;
	var visitdate = document.PatCriteriaFrm.from_date1.value;
	var visitdate1 = document.PatCriteriaFrm.from_date11.value;
	var dischargedate = document.PatCriteriaFrm.from_date2.value;
	var dischargedate1 = document.PatCriteriaFrm.from_date22.value;
	var relnreqyn = document.PatCriteriaFrm.establish_reln_req_yn.value;
	var mode = document.PatCriteriaFrm.mode.value;
		
	var queueId = document.PatCriteriaFrm.queueId.value;
    var nationID = document.PatCriteriaFrm.nationID.value;
	var queueStatus = document.PatCriteriaFrm.queueStatus1.value;
	var sortOrder = document.PatCriteriaFrm.sortOrder.value;
	var frameProperty = document.PatCriteriaFrm.frameProperty.value;
	//var Discharged = document.PatCriteriaFrm.discharged.value;
	//alert("Discharged...."+discharged);
	var checked_out = document.PatCriteriaFrm.CO.checked?"Y":"N";
	var attend_practId = document.PatCriteriaFrm.AttendPract.value;
	var speciality = document.PatCriteriaFrm.specialty_code.value;
	var visitType = document.PatCriteriaFrm.visitType.value;
	var pre_dis_advc_prep_site_YN = document.PatCriteriaFrm.pre_dis_advc_prep_site_YN.value;//IN064342
	//if(document.getElementById("bedRow").style.display!='none')
		var bedNo= document.getElementById("bedNo").value;//IN29412
	 var bar_code_scaned_YN = document.PatCriteriaFrm.bar_code_scaned_YN.value;//Added for IN072184
	 var bar_code_site_yn = document.PatCriteriaFrm.bar_code_scan_site_YN.value;//Added for IN072184
	var virtualConsultation_yn=document.getElementById("virtualConsultation").value; //51215

	/*var RP_chk = document.PatCriteriaFrm.RP.value;
	var OVR_chk = document.PatCriteriaFrm.OVR.value;
	var OCIP_chk = document.PatCriteriaFrm.OCIP.value;
	var CBSR_chk = document.PatCriteriaFrm.CBSR.value;
	var UCBSR_chk = document.PatCriteriaFrm.UCBSR.value;
	var OA_chk = document.PatCriteriaFrm.OA.value;
	var OAP_chk = document.PatCriteriaFrm.OAP.value;*/

	//alert('RP_chk...'+RP_chk+'..OVR_chk...'+OVR_chk+'..OCIP_chk..'+OCIP_chk+'...CBSR_chk...'+CBSR_chk+'...OA_chk...'+OA_chk+'...OAP_chk...'+OAP_chk+'...UCBSR_chk....'+UCBSR_chk);
	
	document.PatCriteriaFrm.order_by.value="";
	document.PatCriteriaFrm.re_order.value="";
	document.PatCriteriaFrm.anchor_id.value="";
	//IN064342 start
	//var passurl = '../jsp/PatListByLocationResultMain.jsp?locationType='+locationType+'&locationCode='+locationCode+'&viewList='+viewList+'&adm_fromdate='+adm_fromdate+'&adm_todate='+adm_todate+'&groupByLocn='+groupByLocn+'&groupByEpisode='+groupByEpisode+'&reln_req_yn='+relnreqyn+'&mode='+mode +'&patientId='+patientId+'&queueId=' +queueId+'&nationID='+nationID+ '&queueStatus='+ queueStatus + '&sortOrder='+sortOrder+ '&checked_out='+checked_out+ '&attend_practId='+attend_practId+'&speciality='+speciality+'&visitType='+visitType ;   //+'&frameProperty='+frameProperty;
	var passurl = '../jsp/PatListByLocationResultMain.jsp?locationType='+locationType+'&locationCode='+locationCode+'&viewList='+viewList+'&adm_fromdate='+adm_fromdate+'&adm_todate='+adm_todate+'&groupByLocn='+groupByLocn+'&groupByEpisode='+groupByEpisode+'&reln_req_yn='+relnreqyn+'&mode='+mode +'&patientId='+patientId+'&queueId=' +queueId+'&nationID='+nationID+ '&queueStatus='+ queueStatus + '&sortOrder='+sortOrder+ '&checked_out='+checked_out+ '&attend_practId='+attend_practId+'&speciality='+speciality+'&visitType='+visitType+'&pre_dis_advc_prep_site_YN='+pre_dis_advc_prep_site_YN +'&bar_code_scaned_YN='+bar_code_scaned_YN+'&bar_code_site_yn='+bar_code_site_yn;//bar_code_scaned_YN,bar_code_site_yn added for IN072184
	//IN064342 end

	if (visitdate=='' && visitdate1=='')	document.PatCriteriaFrm.past.checked = false;

	if (dischargedate=='' && dischargedate1=='') document.PatCriteriaFrm.discharged.checked = false; 
	
	if(document.PatCriteriaFrm.past.checked == true)
		passurl += '&past=Y&from_visit_date='+visitdate+'&to_visit_date='+visitdate1
	else
		passurl += '&past=';

	if(document.PatCriteriaFrm.discharged.checked == true) 
		passurl += '&discharged=Y&from_discharge_date='+dischargedate+'&to_discharge_date='+dischargedate1
	else
			passurl += '&discharged=';

	if(document.PatCriteriaFrm.unscheduled.checked == true)
		passurl += '&unscheduled_yn=Y'
	
	//if(bedNo!=undefined)
		passurl+='&bedNo='+bedNo;//IN29412
	//alert("passurl.."+passurl);
	
	/*if(document.PatCriteriaFrm.RP.checked == true)
		passurl += '&RP_chk='+RP_chk+'&OVR_chk='+OVR_chk+'&OCIP_chk='+OCIP_chk+'&CBSR_chk='+CBSR_chk+'&UCBSR_chk='+UCBSR_chk+'&OA_chk='+OA_chk+'&OAP_chk='+OAP_chk;
*/
		passurl+='&assign_confirm_referral_yn='+assign_confirm_referral_yn;//IN048704
		passurl+='&virtualConsultation_yn='+virtualConsultation_yn; //51215

		top.content.workAreaFrame.PatResultFr.location.href = passurl ;
	
		if(patientId == null || patientId == "")
		{
			var strMesg = getMessage("SPEC_LOCN_OR_PATIENT","CA");
			if(locationType == 'OP')
		  {
			strMesg = strMesg.replace('$$','Clinic');
		  }
		  else if(locationType == 'DC')
		  {
			  strMesg = strMesg.replace('$$','Daycare Unit');
			  
		  }
		  else if(locationType == 'IP')
		  {
			  strMesg = strMesg.replace('$$','Nursing Unit');
			  strMesg = strMesg+"\n5. Bed No";//IN29412
		  }
		  else if(locationType == 'EM')
			{
			  strMesg = strMesg.replace('$$','Emergency Units');
			}
			else(locationType == 'Z')
			{
				strMesg = strMesg.replace('$$','Location');
			}
			
			if(viewList != "S")
			{
				if(locationType == "Z"|| locationCode == "*ALL")
				{
					if(attend_practId == "" && speciality == "" && bedNo=="")//IN29412
					{
						top.content.workAreaFrame.PatResultFr.location.href="../../eCommon/html/blank.html";
						alert(strMesg);				
						//return false;
					}
				}
			}
		}
	
	
}	

function clearClick(){	
	//var rows = "14.5%,*,8%";
	//parent.myFrameSet.rows = rows;	
	top.content.workAreaFrame.PatResultFr.location.href="../../eCommon/html/blank.html";
	document.location.reload();	
}

function setVisitDate(obj){
	if(obj.checked)
	{
		var patientId = document.PatCriteriaFrm.patientId.value;
		var siteSpecific = document.PatCriteriaFrm.past_visit_site_YN.value; //IN063819
		/*
			Modified by Kishore Kumar N 06-05-2010, Tuning by Filter date
			Defaulting date minus 2 days to the current date.
		*/
		var locale = document.PatCriteriaFrm.locale.value;
		var maxVisitDays = '';
		//IN063819 start
		//if(patientId == '')
		if(patientId == '' && siteSpecific == "N")
		//IN063819 end
		{
			maxVisitDays = document.PatCriteriaFrm.maxVisitDays.value;
			if(parseInt(maxVisitDays,10) > 30)
				maxVisitDays = '30';
			else
				maxVisitDays = maxVisitDays;
		}
		else
		{
			maxVisitDays = document.PatCriteriaFrm.days_backward_visits_pat_id.value;
		}

		var fromDate = minusDate(document.PatCriteriaFrm.todaydate.value, 'DMY', locale, maxVisitDays, 'd');
		document.PatCriteriaFrm.from_date1.value = fromDate;
		/*
			ends here.
		*/
		//Below validation for patientId has been commented by Archana Dhal related to incident no. IN022829.
		//if(!(patientId==""|| patientId==null))
		//{
			//document.PatCriteriaFrm.from_date1.value = document.PatCriteriaFrm.from_visit_date.value;
			document.PatCriteriaFrm.from_date1.readOnly = false;			
			document.getElementById("cal_pv").disabled=false;
			document.PatCriteriaFrm.from_date11.value = document.PatCriteriaFrm.todaydate.value;
			document.PatCriteriaFrm.from_date11.readOnly = false;
			document.getElementById("cal_pv1").disabled=false;
		/*}
		else
		{
			//document.PatCriteriaFrm.from_date1.value = document.PatCriteriaFrm.from_visit_date.value;
			document.PatCriteriaFrm.from_date1.readOnly = false;
			document.PatCriteriaFrm.all.cal_pv.disabled=false;
			//document.PatCriteriaFrm.from_date11.value = document.PatCriteriaFrm.from_date1.value
			document.PatCriteriaFrm.from_date11.value = document.PatCriteriaFrm.todaydate.value;
			document.PatCriteriaFrm.from_date11.readOnly = false;
			document.PatCriteriaFrm.all.cal_pv1.disabled=TRUE;
			//document.PatCriteriaFrm.from_date11.title='Can change only if Patient ID is given';
			//document.PatCriteriaFrm.all.cal_pv1.title='Can change only if Patient ID is given';
		
		}*/
	}
	else
	{
		document.PatCriteriaFrm.from_date1.value = '';
		document.PatCriteriaFrm.from_date1.readOnly = true;
		document.getElementById('cal_pv').disabled=true;
		document.PatCriteriaFrm.from_date11.value = '';
		document.PatCriteriaFrm.from_date11.readOnly = true;
		document.getElementById('cal_pv1').disabled=true;
	}
}

function setDischargeDate(obj)
{
	var patientId = document.PatCriteriaFrm.patientId.value;
	var siteSpecific = document.PatCriteriaFrm.past_visit_site_YN.value; //IN063819
	if(obj.checked)
	{
		document.PatCriteriaFrm.from_date2.readOnly = false;
		document.getElementById('cal_di').disabled=false;		
		document.PatCriteriaFrm.from_date22.readOnly = false;
		document.getElementById('cal_di1').disabled=false;
		obj.value='Y';
		/*
			Modified by Kishore Kumar N 06-05-2010, Tuning by Filter date
			Defaulting date minus one week to the current date.
		*/
		var maxDistDays = ''
		//IN063819 start
		//if(patientId == '')
		if(patientId == '' && siteSpecific == "N")
		//IN063819 end
		{
			maxDistDays = document.PatCriteriaFrm.maxDistDays.value;
			if(parseInt(maxDistDays,10) > 30)
				maxDistDays = '30';
			else
				maxDistDays = maxDistDays;
		}
		else
		{
			maxDistDays = document.PatCriteriaFrm.days_backward_disch_pat_id.value;
		}

		var locale = document.PatCriteriaFrm.locale.value;
		var fromDate = minusDate(document.PatCriteriaFrm.todaydate.value, 'DMY', locale, maxDistDays, 'd');		
		document.PatCriteriaFrm.from_date22.value = document.PatCriteriaFrm.todaydate.value;
		document.PatCriteriaFrm.from_date2.value = fromDate;
		/*
			ends here.
		*/
	}
	else
	{
		document.PatCriteriaFrm.from_date2.value = '';
		document.PatCriteriaFrm.from_date2.readOnly = true;
		document.getElementById('cal_di').disabled=true;
		document.PatCriteriaFrm.from_date22.value = '';
		document.PatCriteriaFrm.from_date22.readOnly = true;
		document.getElementById('cal_di1').disabled=true;
		obj.value='N';
	}
}
function validateDate(obj,val,format,locale,toDate)
{
	var siteSpecific = document.PatCriteriaFrm.past_visit_site_YN.value; //IN063819
	var patientId = document.PatCriteriaFrm.patientId.value;	
	if(CheckDate(obj))
	{
		var compDate = '';
		var msgref = '';
	
		if(val == "V")
		{
			msgref = top.header.getMessage("INVALID_FROM_PAST_VISIT_DATE_DAYS","CA");
			//IN063819 start
			//if(patientId == '')
			if(patientId == '' && siteSpecific == "N")
			//IN063819 ends
			{
				compDate = document.forms[0].days_backward_visits;
				msgref = msgref.replace('$',document.forms[0].maxVisitDays.value);
			}
			else
			{
				compDate = document.forms[0].days_backward_visits;
				msgref = msgref.replace('$',document.forms[0].days_backward_visits_pat_id.value);
			}
		}
		else
		{
			msgref = top.header.getMessage("INVALID_FROM_DISCHARGE_DATE_DAYS","CA");
			//IN063819 start
			//if(patientId == '')
			if(patientId == '' && siteSpecific == "N")
			//IN063819 ends
			{
				compDate = document.forms[0].days_backward_discharges;
				msgref = msgref.replace('$',document.forms[0].maxDistDays.value);
			}
			else
			{
				compDate = document.forms[0].days_backward_discharges;
				msgref = msgref.replace('$',document.forms[0].days_backward_disch_pat_id.value);
			}
		}
		
		var CutOffDt	=	compDate.value;
		
		CutOffDt		= minusDate(CutOffDt,"DMY",locale,1,"d");
		
		if((isBefore(obj.value, CutOffDt,format, locale)))
		{	
			alert(msgref);
			obj.select();

			return false
		}
		// Addes By Arvind on 9/30/2010
		
		if(val=='V'){
			if(!(obj.value == null || obj.value == "" )){
				var days=daysBetween(obj.value,toDate.value,format,locale);		
				var rangeLimit=document.forms[0].maxVisitDays.value;	
				var outOfRange;
				if(parseInt(rangeLimit)>parseInt(days)){
					
					outOfRange=rangeLimit-days;
				}
				else{
					outOfRange=days-rangeLimit;
				}
				var backward_visits_pat_id = document.forms[0].days_backward_visits_pat_id.value //IN063819
				var minDate=document.forms[0].days_backward_visits.value;
				var duration=daysBetween(minDate,obj.value,format,locale);
				//IN063819 start
				//if ((patientId == null || patientId == "" )){
				if ((patientId == null || patientId == "" )&& siteSpecific == "N"){
				//IN063819 end
					if(parseInt(duration+2) >=0){
						if(isBefore(obj.value, CutOffDt,format, locale)==false && parseInt(days)>parseInt(rangeLimit) )			
						{
							var newTodate = minusDate(toDate.value, 'DMY', locale, outOfRange, 'd');
							alert(msgref);			
							toDate.value=newTodate;
							toDate.select();			
							return false	
						}
					}
					else{
						alert(msgref);
						obj.select();			
						return false
					}
				}else if(siteSpecific == "Y" && (parseInt(backward_visits_pat_id) < parseInt(days)))//IN063819 start
				{
					alert(msgref);
					obj.select();			
					return false
				}//IN063819 ends
			}
		}
		else {
			if(!(obj.value == null || obj.value == "" )){
				var days=daysBetween(obj.value,toDate.value,format,locale);		
				var rangeLimit=document.forms[0].maxDistDays.value;	
				var backward_disch_pat_id = document.forms[0].days_backward_disch_pat_id.value //IN063819
				var outOfRange;
				if(parseInt(rangeLimit)>parseInt(days)){
					
					outOfRange=rangeLimit-days;
				}
				else{
					outOfRange=days-rangeLimit;
				}
				var minDate=document.forms[0].days_backward_discharges.value;
				var duration=daysBetween(minDate,obj.value,format,locale);		
				//IN063819 Start
				//if ((patientId == null || patientId == "" )){
				if ((patientId == null || patientId == "" )&& siteSpecific == "N"){
				//IN063819 End
					if(parseInt(duration+2) >=0){
						if(isBefore(obj.value, CutOffDt,format, locale)==false && parseInt(days)>parseInt(rangeLimit) )		
						{
							var newTodate = minusDate(toDate.value, 'DMY', locale, outOfRange, 'd');
							alert(msgref);			
							toDate.value=newTodate;
							toDate.select();			
							return false	
						}
					}
					else{
						alert(msgref);
						obj.select();			
						return false
					}
				}
				else if(siteSpecific == "Y" && (parseInt(backward_disch_pat_id) < parseInt(days)))//IN063819 start
				{
					alert(msgref);
					obj.select();			
					return false
				}//IN063819 ends
			}
		}

	//End here 

	
  }
}


function doDateCheckLoc(fromDate,toDate,currDate,format,locale)
{	

	msgref = top.header.getMessage("INVALID_FROM_PAST_VISIT_DATE_DAYS","CA");
	msgref = msgref.replace('$',document.forms[0].maxVisitDays.value);
	
	var siteSpecific = document.PatCriteriaFrm.past_visit_site_YN.value; //IN063819
	if (!(fromDate.value == null || fromDate.value == "" ))
	{
		var patientId = document.forms[0].patientId.value; 
		/*if(patientId==""|| patientId==null)
		{
			//document.forms[0].from_date11.value = fromDate.value ;
			document.forms[0].from_date11.value = toDate.value ;
			document.forms[0].from_date11.readOnly = true;
		}
		else
		{
			document.forms[0].from_date11.readOnly = false;
		}*/

		
		if((fromDate.value != '' && !validDate(fromDate.value, format, locale)))
		{
			fromDate.focus();
			return false;
		}
		if((toDate.value != '' && !validDate(toDate.value, format, locale)))
		{
			alert(getMessage("INVALID_DATE_FMT", "SM"));////Added by Archana Dhal related to incident no. IN022829.
			//alert(msg);
			toDate.select();
			toDate.focus();
			return false;
		}
		

		if(isBeforeNow(fromDate.value, format, locale))
		{
			if (!(toDate.value == null || toDate.value == "" ))
			{
				if(isBeforeNow(toDate.value, format, locale))
				{
					if(isAfter(toDate.value, fromDate.value, format, locale))
						return true;
					else
					{
						alert(top.header.getMessage("TO_DT_GR_EQ_FM_DT","CA"));
						//IN063819 start
						//if(patientId==""|| patientId==null)
						if((patientId==""|| patientId==null)&&(siteSpecific == "N"))
						//IN063819 end
						{
							fromDate.focus();
							return false;
						}
						else
						{
							toDate.focus();
							return false;
						}
					}
				}
				else
				{
					alert(top.header.getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
					toDate.focus();
					return false;
				}
			}
		}
		else
		{
			alert(top.header.getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
			fromDate.focus();
			return false;
		}
		
	}
	
	
 }

function checkboxChk(obj)
{ 
	if(obj.name=="groupByLocn")
	{
		if(document.getElementById("groupByLocn").checked==false ||document.getElementById("groupByLocn").checked==true)
		{
			if((document.forms[0].locationType.value=='IP') || (document.forms[0].locationType.value=='OP') || (document.forms[0].locationType.value=='EM') || (document.forms[0].locationType.value=='DC')){
				document.getElementById("groupByEpisode").disabled=false;
			}
		}
		if((document.getElementById("groupByEpisode").disabled) && (document.getElementById("groupByEpisode").checked)){
					document.getElementById("groupByEpisode").disabled = false;
		}else if((!document.getElementById("groupByEpisode").disabled) && (!document.getElementById("groupByEpisode").checked)){
			document.getElementById("groupByEpisode").disabled = true;
			document.getElementById("groupByEpisode").value = 'Y';
			document.getElementById("groupByEpisode").checked = true;
		}else if((!document.getElementById("groupByEpisode").disabled) && (document.getElementById("groupByEpisode").checked)){
						if(document.forms[0].locationType.value=='Z'){
								document.getElementById("groupByEpisode").disabled = false;
						}else{
								document.getElementById("groupByEpisode").disabled = true;
						}
		}
	}
	else if(obj.name=="groupByEpisode")
	{
		if(obj.checked == false)
		{
			if(document.getElementById("groupByLocn").checked)
			{
				document.getElementById("groupByLocn").checked = false;
				document.getElementById("groupByLocn").value = 'N';
			}
		}
	}
	if(obj.checked ==true) 
		obj.value='Y'
	else 
		obj.value = 'N'
}

function defaultGroupBy(){
	var chkLocn = document.getElementById("groupByLocn").checked ; 
	if(chkLocn){
		document.getElementById("groupByEpisode").value='Y';
		document.getElementById("groupByEpisode").disabled=true;
	}
}

function showCalendarValidate(str){
	var flg = showCalendar(str);
	eval(document.getElementById(str).focus());
	return flg;
}

//
		function callWrapper(encounter_id)
		{
			var HTMLVal = "<html>";
			HTMLVal += "<form name='wrapperForm' id='wrapperForm' action='../../eCA/jsp/OpenChartWrapper.jsp' method='post'>";
			HTMLVal += "<input type='hidden' name=encounter_id id=encounter_id value='" + encounter_id + "'>";			
			HTMLVal += "</form>";			
			HTMLVal += "</html>";
			//alert(HTMLVal);
			top.content.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			top.content.messageFrame.document.wrapperForm.submit();
			
		}
		//
		function callmakeless()
		{
		//alert("here");
		}

		function doDateCheck(from,to,obj,obj1) {
			if(CheckSystemDateLesser(obj,obj1)){
				if(!doDateCheckAlert(from,to)){
					alert(top.header.getMessage("TO_DT_GR_EQ_FM_DT","CA"));
					obj.select();
					obj.focus();
					return false;
				}
			}
		}

       function checkboxes(){
				var ql_ref = document.forms[0].ql_ref.value;
				if(ql_ref==''){
				document.forms[0].QS.checked=true;
				checkAll(document.forms[0].QS);
		}
		}
		function checkboxes1()
		{
			var patientId = document.forms[0].patientId.value;
			var locationType=document.forms[0].locationType.value; 
		
			if(locationType == 'OP' || locationType == 'EM')
		 {
			document.forms[0].past.disabled = false;
			document.forms[0].discharged.disabled = true;
			document.forms[0].discharged.checked = false;
			if(document.forms[0].past.checked == true)
			 {
				//Below validation for patientId has been commented by Archana Dhal related to incident no. IN022829.
				if(!(patientId==""|| patientId==null))
				{
				    document.forms[0].past.checked= true;
			        document.forms[0].past.value = "1";
				    //document.forms[0].from_date1.value =   document.forms[0].from_visit_date.value;
					document.forms[0].from_date1.readOnly = false;
					document.getElementById('cal_pv').disabled=false;
					//document.forms[0].from_date11.value = document.forms[0].todaydate.value;
					document.forms[0].from_date11.readOnly = false;
					document.getElementById('cal_pv1').disabled=false;
				}
				else
					{
					    document.forms[0].past.checked= true;
			            document.forms[0].past.value = "1";
						//document.forms[0].from_date1.value = document.forms[0].from_visit_date.value;
						document.forms[0].from_date1.readOnly = false;
						document.getElementById('cal_pv').disabled=false;
						//document.forms[0].from_date11.value = document.forms[0].from_date1.value
						//document.forms[0].from_date11.value = document.forms[0].todaydate.value
						document.forms[0].from_date11.readOnly = false;
						document.getElementById('cal_pv1').disabled=false;
				
					}
			 }
			 else
			 {				
				document.forms[0].past.checked= false;
			    document.forms[0].past.value = "0";
				document.forms[0].from_date1.value = '';
				document.forms[0].from_date1.readOnly = true;
				document.getElementById('cal_pv').disabled=true;
				document.forms[0].from_date11.value = '';
				document.forms[0].from_date11.readOnly = true;
				document.getElementById('cal_pv1').disabled=true;
			 }
		}else if(locationType == 'IP' || locationType == 'DC'){
			document.forms[0].past.disabled = true;
			document.forms[0].discharged.disabled = false;
			document.forms[0].past.checked = false;
			if(document.forms[0].discharged.checked == true)
			 {
			    document.forms[0].discharged.checked= true;
			    document.forms[0].discharged.value = "Y";
				//document.forms[0].from_date2.value = document.forms[0].from_discharge_date.value;
				document.forms[0].from_date2.readOnly = false;
				document.getElementById('cal_di').disabled=false;
				//document.forms[0].from_date22.value = document.forms[0].todaydate.value;
				document.forms[0].from_date22.readOnly = false;
				document.getElementById('cal_di1').disabled=false;
			 }
			 else
			 {
				document.forms[0].discharged.checked= false;
			    document.forms[0].discharged.value = "N";
				document.forms[0].from_date2.value = '';
				document.forms[0].from_date2.readOnly = true;
				document.getElementById('cal_di').disabled=true;
				document.forms[0].from_date22.value = '';
				document.forms[0].from_date22.readOnly = true;
				document.getElementById('cal_di1').disabled=true;
			 }
		}else{ 
			document.forms[0].past.disabled = false;
			document.forms[0].discharged.disabled = false;
			if(document.forms[0].past.checked == true)
			 {
				//Below validation for patientId has been commented by Archana Dhal related to incident no. IN022829.			    		
				//if(!(patientId==""|| patientId==null))
				//{
				    document.forms[0].past.checked= true;
			        document.forms[0].past.value = "1";
				    //document.forms[0].from_date1.value =   document.forms[0].from_visit_date.value;
					document.forms[0].from_date1.readOnly = false;
					document.getElementById('cal_pv').disabled=false;
					//document.forms[0].from_date11.value = document.forms[0].todaydate.value;
					document.forms[0].from_date11.readOnly = false;
					document.getElementById('cal_pv1').disabled=false;
				/*}
				else
					{
					    document.forms[0].past.checked= true;
			            document.forms[0].past.value = "1";
						//document.forms[0].from_date1.value = document.forms[0].from_visit_date.value;
						document.forms[0].from_date1.readOnly = false;
						document.forms[0].all.cal_pv.disabled=false;
						//document.forms[0].from_date11.value = document.forms[0].from_date1.value
						//document.forms[0].from_date11.value = document.forms[0].todaydate.value
						document.forms[0].from_date11.readOnly = true;
						document.forms[0].all.cal_pv1.disabled=true;
				
					}*/
			 }
			 else
			 {
				document.forms[0].past.checked= false;
			    document.forms[0].past.value = "0";
				document.forms[0].from_date1.value = '';
				document.forms[0].from_date1.readOnly = true;
				document.getElementById('cal_pv').disabled=true;
				document.forms[0].from_date11.value = '';
				document.forms[0].from_date11.readOnly = true;
				document.getElementById('cal_pv1').disabled=true;
			 }
			if(document.forms[0].discharged.checked == true)
			 {
				document.forms[0].discharged.checked= true;
			    document.forms[0].discharged.value = "Y";
				//document.forms[0].from_date2.value = document.forms[0].from_discharge_date.value;
				document.forms[0].from_date2.readOnly = false;
				document.getElementById('cal_di').disabled=false;
				//document.forms[0].from_date22.value = document.forms[0].todaydate.value;
				document.forms[0].from_date22.readOnly = false;
				document.getElementById('cal_di1').disabled=false;
			 }
			 else
			 {
				document.forms[0].discharged.checked= false;
			    document.forms[0].discharged.value = "N";
				document.forms[0].from_date2.value = '';
				document.forms[0].from_date2.readOnly = true;
				document.getElementById('cal_di').disabled=true;
				document.forms[0].from_date22.value = '';
				document.forms[0].from_date22.readOnly = true;
				document.getElementById('cal_di1').disabled=true;
			 }
		}
	}

		function checkAll(obj){
			if(obj.checked==true){	 
					document.forms[0].CI.checked=true;
					document.forms[0].AAN.checked=true;
					document.forms[0].VS.checked=true;				
					document.forms[0].CIP.checked=true;
					document.forms[0].TI.checked=true;
					document.forms[0].RFI.checked=true;
					document.forms[0].CO.checked=false;
					if(document.forms[0].CO.checked==true)
						document.forms[0].queueStatus.value=' 01,02,03,04,05,06,07';
					else
						document.forms[0].queueStatus.value=' 01,02,03,04,05,06';							
			}else{
					document.forms[0].CI.checked=false;
					document.forms[0].AAN.checked=false;
					document.forms[0].VS.checked=false;				
					document.forms[0].CIP.checked=false;
					document.forms[0].TI.checked=false;
					document.forms[0].RFI.checked=false;
					document.forms[0].CO.checked=false;
					document.forms[0].queueStatus.value='';
			}


		}	

function makeVisible(obj,tab_menu_yn)
{
	var groupByLocn = document.forms[0].groupByLocn.value;
	var groupByEpisode = document.forms[0].groupByEpisode.value;
	var locationType = document.forms[0].locationType.value;
	var locationCode = document.forms[0].locationCode.value;
	var val = obj.value;
	var rows;
	
	if (document.forms[0].more.value == getLabel("Common.lesscriteria.label","COMMON")) 
		bool = 'no';
	else 
		bool = 'yes';

	if(val == getLabel("Common.search.label","COMMON"))
	{
		bool = 'no';
	}
	
	if(bool == 'yes')  //if more criteria buttons comes into act
	{
		if(tab_menu_yn == "Y" || tab_menu_yn == "y")
		{
			rows = "58%,*,8%"; 
		}
		else
		{
			rows = "58%,*,8%";
		}

		//parent.myFrameSet.removeAttribute(rows);
		//parent.myFrameSet.rows = rows;
		parent.document.getElementById('PatCriteriaFr').style.height="54vh";
		parent.document.getElementById('PatResultFr').style.height="34vh";
		parent.document.getElementById('colorRefframe').style.height="8vh";
		document.getElementById("moreCriteria").style.display = '';
		document.forms[0].more.value = getLabel("Common.lesscriteria.label","COMMON")
		document.forms[0].frameProperty.value = 'Y';		
		
		if(groupByLocn == 'Y' && groupByEpisode == 'Y')
		{	
			if((locationType == 'OP' || locationType == 'IP') && locationCode == '*ALL')
			{
				rows1 = "0%,11%,13%,*";   //0%,9%,9%,*
			}
			else if(locationType == 'IP' && locationCode == '*ALL')
			{	
				rows1='60%,*,10%,0';	
			}
			else if(locationType == 'Z')
			{
				if(tab_menu_yn == "Y" || tab_menu_yn == "y")
				{
					rows1 = "9%,9%,9%,*";
				}
				else
				{
					rows1 = "9%,9.5%,11%,*"; 
				}
			}
			else
			{
				rows1 = "0%,0%,9%,*";
			}
		}
		else if(groupByLocn == 'N' && groupByEpisode == 'Y')
		{
			if(locationType == 'IP' || locationType == 'OP')
			{
				rows1 = "0%,0%,0%,*";
			}
			else
			{
				rows1 = "9%,0%,0%,*";
			}
		}
		else if(groupByLocn == 'N' && groupByEpisode == 'N')
		{
			rows1 = "0%,0%,0%,*";
		}
		if(parent.PatResultFr.resultFrameSet != null)
		{
			if(parent.PatResultFr.resultFrameSet.rows != '7%,0%,0%,*')
				parent.PatResultFr.resultFrameSet.rows = rows1;
		}
	}
	else if(bool == 'no')
	{
		if(tab_menu_yn == "Y" || tab_menu_yn == "y")
		{
			rows = "27%,*,8%";
		}
		else
		{
			rows = "30%,*,8%";
		}

		//parent.myFrameSet.removeAttribute(rows);
		//parent.myFrameSet.rows = rows;
		parent.document.getElementById('PatCriteriaFr').style.height="28vh";
		parent.document.getElementById('PatResultFr').style.height="60vh";
		parent.document.getElementById('colorRefframe').style.height="8vh";
		document.getElementById("moreCriteria").style.display = 'none';
		document.forms[0].more.value = getLabel("Common.morecriteria.label","COMMON")
		document.forms[0].frameProperty.value = 'N';

		if(groupByLocn == 'Y' && groupByEpisode == 'Y')
		{
			if((locationType == 'OP' || locationType == 'IP') && locationCode == '*ALL')
			{
				rows1 = "0%,5.5%,5.5%,*";
			}
			else if(locationType == 'Z')
			{
				if(tab_menu_yn == "Y" || tab_menu_yn == "y")
				{
					rows1 = "5.5%,5.5%,5.5%,*";
				}
				else
				{
					rows1 = "4.6%,6%,6%,*"; 
				}
			}
			else
			{
				rows1 = "0%,0%,4.5%,*";
			}
		}
		else if(groupByLocn == 'N' && groupByEpisode == 'Y')
		{
			if(locationType == 'IP' || locationType == 'OP')
			{
				rows1 = "0%,0%,0%,*";
			}
			else
			{
				rows1 = "5.5%,0%,0%,*"; 
			}
		}
		else if(groupByLocn == 'N' && groupByEpisode == 'N')
		{
			rows1 = "0%,0%,0%,*";
		}

		if(parent.PatResultFr.resultFrameSet != null)
		{
			if(parent.PatResultFr.resultFrameSet.rows != '7%,0%,0%,*')
				parent.PatResultFr.resultFrameSet.rows = rows1;
		}
	}
	checkboxes1();					
}

function appendStatus(obj)
{
	var v=document.forms[0].queueStatus.value;
	var va=obj.value;
	var val='';
	var vv='';

	if (obj.checked)
	{
		if (v=='')
		{
			v=va;
		}
		else
		{
			v=v+','+va
		}
	}
	else
	{
		val=va;
		
		if (v==val)
		{
			v='';
		}
		if(v.length ==3)
		{
			v='';
		}

		val=va+','
		
		if (v.indexOf(val))
		{
			v=v.replace(val,'');
		}

		vv=','+va

		if (v.indexOf(vv))
		{
			v=v.replace(vv,'');
		}
	}
	document.forms[0].queueStatus.value=v;
}

			function strcon(){
					var v=document.forms[0].queueStatus.value;
					var split = v.split(',');
					var test_temp=new Array();
					var fin='';
					var a=',';
					for(i=0;i<(split.length);i++){
						if ( split.length-1 ==i ) a='';
							test_temp[i]=split[i]
								fin=fin+"~"+test_temp[i]+"~"+a;
					}
					fin=fin.replace(' ','');
					document.forms[0].queueStatus1.value=fin;
			}

			async function callPatientSearch(){
				
						var pat_id = await  PatientSearch();
						//alert(pat_id);
						if(pat_id != null)	document.getElementById("patientId").value = pat_id;
						document.getElementById("patientId").focus();
			}

			function checkDuplicate(obj)	 {
						ChangeUpperCase(obj);
						if(obj.value != ""){
							var HTMLVal = "<html><body><form name='frmDuplicateId' id='frmDuplicateId' method='post' action='../../eCA/jsp/CAValidatePatientId.jsp'><input type='hidden' name='patient_id' id='patient_id' value='"+escape(obj.value)+"'><input type='hidden' name='fromFunction' id='fromFunction' value='PatListByLocation'></form></body></html>";
							top.content.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
							top.content.messageFrame.document.frmDuplicateId.submit();
							if(document.forms[0].past.checked)
								{
									document.forms[0].from_date11.readOnly = false;
									document.forms[0].cal_pv1.disabled=false ;
								}
						}
						else
						{
							/*document.forms[0].from_date11.value = document.forms[0].from_date1.value ;
							document.forms[0].from_date11.readOnly = true;
							document.getElementById('cal_pv1').disabled=true;
							var locale = document.PatCriteriaFrm.locale.value;
							var maxVisitDays = document.PatCriteriaFrm.maxVisitDays.value;
							var fromDate = minusDate(document.PatCriteriaFrm.todaydate.value, 'DMY', locale, maxVisitDays, 'd');
							document.PatCriteriaFrm.from_date11.value = document.PatCriteriaFrm.todaydate.value;*/
						}
			}

			function changeLocnCode(obj){
				if(obj.value=='*ALL')
					document.forms[0].groupByLocn.disabled=false;
				else	
				{
					document.forms[0].groupByLocn.checked=true;
					document.forms[0].groupByLocn.disabled=true;
					document.forms[0].groupByLocn.value='Y';
				}
			}

			function disBtn(obj)
			{
				//obj.disabled = true;
			}
			
		
			async function getClinicCode()			
			{
				var target			= document.forms[0].locVal;
				var stdval          = document.forms[0].locVal.value;
				var val				= document.forms[0].facilityid.value;
				var pract_id		= document.forms[0].ca_practitioner_id.value;
				var retVal			=  new String();
				var dialogTop		= "40";
				var dialogHeight	= "10" ;
				var dialogWidth		= "40" ;
				var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
				var arguments		= "" ;
				var search_desc		= "";
				//var title			= getLabel("Common.practitioner.label","COMMON");
				var title			= document.getElementById("locLed").innerText;
				var locale			= document.forms[0].locale.value;
				var loc_type		= document.forms[0].locationType.value;

				var sql="Select locn_code code,decode(locn_type,'C',OP_GET_DESC.OP_CLINIC('"+val+"',locn_code,'"+locale+"','1'), 'W',IP_GET_DESC.IP_NURSING_UNIT('"+val+"',locn_code,'"+locale+"','1') ) description  from ca_pract_by_locn_view where  upper(locn_code) like upper(?) AND UPPER(decode(locn_type,'C',OP_GET_DESC.OP_CLINIC('"+val+"',locn_code,'"+locale+"','1'), 'W',IP_GET_DESC.IP_NURSING_UNIT('"+val+"',locn_code,'"+locale+"','1') )) like upper(?) AND practitioner_id= '"+pract_id+"' and locn_type in ('C','W') and facility_id = '"+val+"' and PATIENT_CLASS = '"+loc_type+"' order by 2";

				var argArray		= new Array();
				var namesArray		= new Array();
				var valuesArray		= new Array();
				var datatypesArray	= new Array();
		
				argArray[0] = sql;
				argArray[1] = namesArray;
				argArray[2] = valuesArray;
				argArray[3] = datatypesArray;
				argArray[4] = "1,2";
				argArray[5] = target.value;
				argArray[6] = DESC_LINK;
				argArray[7] = CODE_DESC;
								
				retArray = await CommonLookup( title, argArray );	
					var ret1=unescape(retArray);
					var arr=ret1.split(",");
					if(arr[1]==undefined) 
					{
						arr[0]="";	
						arr[1]="";	
					} 
				if(retArray != null && retArray !="")
				{

					document.forms[0].locationCode.value = arr[0];
					document.forms[0].locationDesc.value = arr[1];
					//document.forms[0].performed_by_code.value = retArray[0];
					
						
				}
				else
				{
					var viewlist = document.forms[0].viewList.value;
					if(!viewlist=='S')
					{
						document.forms[0].locationCode.value = "";
						document.forms[0].locationDesc.value = "";
					}
					else
					{
						document.forms[0].locationCode.value = "*ALL";
						document.forms[0].locationDesc.value = "";
					}
					//document.forms[0].performed_by_code.value = "";
					
				}

			}

/*function getClinicCode1(obj)
{
	//alert("hi");
	if (obj.value!= "")
	{
		getClinicCode();
	}
	else
	{
		document.forms[0].locationCode.value = "*ALL";
	}
}*/

async function getClinicCode1(obj)
{
	//alert("hi");
	if (obj.value!= "")
	{
		await getClinicCode2();
	}
	else
	{
		document.forms[0].locationCode.value = "*ALL";
	}
}
async function getClinicCode2()
{
    var target			= document.forms[0].locVal;
	var stdval          = document.forms[0].locVal.value;
	var facilityid		= document.forms[0].facilityid.value;
	var pract_id		= document.forms[0].ca_practitioner_id.value;
	var locale			= document.forms[0].locale.value;
	var loc_type		= document.forms[0].locationType.value;
	var title			= document.getElementById("locLed").innerText;
			
	var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/PatListByLocationIntermediate.jsp'><input type='hidden' name='target' id='target' value='"+target+"'><input type=hidden name='selFunVal' id='selFunVal' value='ClinicCode'><input type=hidden name='stdval' id='stdval' value='"+stdval+"'><input type=hidden name='pract_id' id='pract_id' value='"+pract_id+"'><input type=hidden name='facilityid' id='facilityid' value='"+facilityid+"'><input type=hidden name='locale' id='locale' value='"+locale+"'><input type=hidden name='loc_type' id='loc_type' value='"+loc_type+"'><input type=hidden name='title' id='title' value='"+title+"'></form></body></html>";
	parent.frames[3].document.write(HTMLVal);
    parent.frames[3].document.tempform1.submit(); 

}
function populatePract1(obj)
{
	//alert();
	if (obj.value != "")
	{
		populatePract2(obj);
	}
	else
	{
		document.forms[0].AttendPract.value = "";
	}
}
function populatePract2(obj)
{
		var target			= document.forms[0].pract;
		var stdval          = document.forms[0].AttendPract.value;
		var facilityid      = document.forms[0].facilityid.value;
		var locale			= document.forms[0].locale.value;
		var practitioner    = obj.value;
	 
		var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/PatListByLocationIntermediate.jsp'><input type='hidden' name='target' id='target' value='"+target+"'><input type=hidden name='selFunVal' id='selFunVal' value='AttendingPractitioner'><input type=hidden name='stdval' id='stdval' value='"+stdval+"'><input type=hidden name='practitionerValue' id='practitionerValue' value='"+practitioner+"'><input type=hidden name='facilityid' id='facilityid' value='"+facilityid+"'><input type=hidden name='locale' id='locale' value='"+locale+"'></form></body></html>";
		
		parent.frames[3].document.write(HTMLVal);
		parent.frames[3].document.tempform1.submit(); 
       
}
/*function populatePract1(obj)
{
	if (obj.value != "")
	{
		populatePract();
	}
	else
	{
		document.forms[0].AttendPract.value = "";
	}
}
*/

async function populatePract()
{
		var target			= document.forms[0].pract;
		var stdval          = document.forms[0].AttendPract.value;
		var facilityid      = document.forms[0].facilityid.value;
		var locale			= document.forms[0].locale.value;
       
		var retVal			= new String();
		var dialogTop		= "40";
		var dialogHeight	= "10" ;
		var dialogWidth		= "40" ;
		var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		= "" ;
		var search_desc		= "";
		var title			= getLabel("Common.practitioner.label","Common");
		//IN059520 Start
		//var sql="Select a.practitioner_id code , b.practitioner_name  description from am_pract_for_facility_vw a, am_practitioner_lang_vw b where a.operating_facility_id = '"+facilityid+"' and a.practitioner_id = b.practitioner_id and b.language_id = '"+locale+"' and a.eff_status = 'E' and  upper(a.practitioner_id) like upper(?) and upper(b.practitioner_name) like upper(?) order by b.practitioner_name";
		var sql="Select a.practitioner_id code , b.practitioner_name  description from am_pract_for_facility_vw a, am_practitioner_lang_vw b where a.operating_facility_id = '"+facilityid+"' and a.practitioner_id = b.practitioner_id   AND a.eff_status = b.eff_status and b.language_id = '"+locale+"' and a.eff_status = 'E' and  upper(a.practitioner_id) like upper(?) and upper(b.practitioner_name) like upper(?) order by b.practitioner_name"; 
		//IN059520 End.
		var argArray		= new Array();
		var namesArray		= new Array();
		var valuesArray		= new Array();
		var datatypesArray	= new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retVal = await CommonLookup( title, argArray )
		var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		} 
		if (retVal != null && retVal != '' && retVal != "null")
		{
		   	document.forms[0].pract.value = arr[1];
		   	document.forms[0].AttendPract.value = arr[0];
		}
		else
		{
			document.forms[0].pract.value = "";
			document.forms[0].AttendPract.value = "";
		} 
}

function getSpecialty1(obj)
{
   if (obj.value != "")
	{
		getSpecialty3(obj);
	}
	else
	{
		document.forms[0].specialty_code.value = "";
	}
}
function getSpecialty3(obj)
{
	
	    var target			= document.forms[0].specialty;
		var stdval          = document.forms[0].specialty_code.value;
		var pract			= document.forms[0].AttendPract.value;
		var facilityid      = document.forms[0].facilityid.value;
		var locale			= document.forms[0].locale.value;
		var Specialty		= obj.value;
		
       
           var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/PatListByLocationIntermediate.jsp'><input type='hidden' name='target' id='target' value='"+target+"'><input type=hidden name='selFunVal' id='selFunVal' value='ByLocationSpeciality'><input type=hidden name='stdval' id='stdval' value='"+stdval+"'><input type=hidden name='pract' id='pract' value='"+pract+"'><input type=hidden name='facilityid' id='facilityid' value='"+facilityid+"'><input type=hidden name='locale' id='locale' value='"+locale+"'><input type=hidden name='Specialty' id='Specialty' value='"+Specialty+"'></form></body></html>";
		   
		  parent.frames[3].document.write(HTMLVal);
		  parent.frames[3].document.forms[0].submit(); 
}

/*function getSpecialty1(obj)
{
	if (obj.value != "")
	{
		getSpecialty();
	}
	else
	{
		document.forms[0].specialty_code.value = "";
	}
}
*/
async function getSpecialty()
{
		var target			= document.forms[0].specialty;
		var stdval          = document.forms[0].specialty_code.value;
		var pract			= document.forms[0].AttendPract.value;
		var facilityid      = document.forms[0].facilityid.value;
		var locale			= document.forms[0].locale.value;
       
		var retVal			= new String();
		var dialogTop		= "40";
		var dialogHeight	= "10" ;
		var dialogWidth		= "40" ;
		var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		= "" ;
		var search_desc		= "";
		var title			= getLabel("Common.Specialty.label","Common");
		
		var sql="select a.SPECIALITY_CODE code, a.SHORT_DESC description from AM_SPECIALITY_lang_vw  a where eff_status = 'E' and LANGUAGE_ID='"+locale+"'" ;

		if(pract != '')
			sql = sql + " and SPECIALITY_CODE  in (select nvl(PRIMARY_SPECIALITY_CODE,'***') PRIMARY_SPECIALITY_CODE from am_practitioner where practitioner_id='"+pract+"' union all select SPECIALITY_CODE from AM_PRACT_SPECIALITIES where FACILITY_ID='"+facilityid+"' and PRACTITIONER_ID='"+pract+"' )";

		sql = sql + " and upper(a.SPECIALITY_CODE) like upper(?) and upper(a.SHORT_DESC) like upper(?) order by 2";

		var argArray		= new Array();
		var namesArray		= new Array();
		var valuesArray		= new Array();
		var datatypesArray	= new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retVal = await CommonLookup( title, argArray )
		var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		} 
		if (retVal != null && retVal != '' && retVal != "null")
		{
		   	document.forms[0].specialty.value = arr[1];
		   	document.forms[0].specialty_code.value = arr[0];
		}
		else
		{
			document.forms[0].specialty.value = "";
			document.forms[0].specialty_code.value = "";
		} 
}
async function callFunction3(sql,title,targetDesc, targetCode)
{
	   var argArray		= new Array();
	   var namesArray		= new Array();
	   var valuesArray		= new Array();
	   var datatypesArray	= new Array();

	   argArray[0] = sql;
	   argArray[1] = namesArray;
	   argArray[2] = valuesArray;
	   argArray[3] = datatypesArray;
	   argArray[4] = "1,2";
	   argArray[5] = target.value;
	   argArray[6] = DESC_LINK;
	   argArray[7] = CODE_DESC;
	   retVal = await CommonLookup( title, argArray );		   
	   var ret1=unescape(retVal);
	   var arr=ret1.split(",");
	   if(arr[1]==undefined) 
	   {
		   arr[0]="";	
		   arr[1]="";	
	   } 
	   if (retVal != null && retVal != '' && retVal != "null")
	   {
		   targetDesc.value = arr[1];
		   targetCode.value = arr[0];
	   }
	   else
	   {
		   targetDesc.value = "";
		   targetCode.value = "";
	   } 
	   //return retVal;
}

function enablePract(obj)
{
	if(obj.value != null || obj.value != '')
	{
		if(obj.value == 'S')
		{
			document.PatCriteriaFrm.pract.disabled = true;
			document.PatCriteriaFrm.practSearch.disabled = true;
			document.PatCriteriaFrm.AttendPract.value = document.PatCriteriaFrm.ca_practitioner_id.value;
			document.PatCriteriaFrm.pract.value = document.PatCriteriaFrm.pract_name.value;
		}
		else
		{
			document.PatCriteriaFrm.pract.disabled = false;
			document.PatCriteriaFrm.practSearch.disabled = false;
			document.PatCriteriaFrm.AttendPract.value = '';
			document.PatCriteriaFrm.pract.value = '';
		}
	}
}
/*function checkRPAll(obj)
{
	
	var locationType = document.PatCriteriaFrm.locationType.value;
	
	if(obj.checked)
	{
			
		document.PatCriteriaFrm.RP.value="Y";
		if((locationType=='IP')||(locationType=='DC'))
		{
			
			document.forms[0].CBSR.disabled=false;
			document.forms[0].UCBSR.disabled=false;

		}
		else if((locationType=='OP')||(locationType=='EM'))
		{
			document.forms[0].CBSR.disabled=true;
			document.forms[0].UCBSR.disabled=true;
			
			document.forms[0].OVR.disabled=false;
			document.forms[0].OCIP.disabled=false;
			document.forms[0].OA.disabled=false;
			document.forms[0].OAP.disabled=false;

		}
		else
		{
			
			document.forms[0].CBSR.disabled=false;
			document.forms[0].UCBSR.disabled=false;
			document.forms[0].OVR.disabled=false;
			document.forms[0].OCIP.disabled=false;
			document.forms[0].OA.disabled=false;
			document.forms[0].OAP.disabled=false;


		}


	}
	else
	{
		
			document.PatCriteriaFrm.RP.value="N";
			document.forms[0].CBSR.disabled=true;
			document.forms[0].UCBSR.disabled=true;
			document.forms[0].OVR.disabled=true;
			document.forms[0].OCIP.disabled=true;
			document.forms[0].OA.disabled=true;
			document.forms[0].OAP.disabled=true;



	}


}
function checkRPField(obj)
{
	if(obj.checked)
	{
		obj.value="Y";
	}
	else
	{
		obj.value="N";	
	}

}*/

function makeVisible1(field,obj,tab_menu_yn){

	var groupByLocn=field.document.forms[0].groupByLocn.value;
	var groupByEpisode=field.document.forms[0].groupByEpisode.value;
	var locationType=field.document.forms[0].locationType.value;
	var locationCode=field.document.forms[0].locationCode.value;
	//var RP_chk=document.forms[0].RP.value;
	var val =obj.value;
	var rows;
	/*if (field.document.forms[0].more.value==getLabel("Common.lesscriteria.label","COMMON")) bool='no';
	else bool='yes';
	
	if(val==getLabel("Common.search.label","COMMON")){
		bool='no';
	} */
	/*
					bool='no';
					if(bool == 'yes'){
							if(tab_menu_yn == "Y" || tab_menu_yn == "y"){
								rows = "50%,*,10%"; //45
							}
							else{
								
								//rows = "48%,*,10%"; //40 
								//rows = "55%,*,10%";
								rows = "63%,*,10%";
																
							}
 
							parent.parent.myFrameSet.removeAttribute(rows);
							parent.parent.myFrameSet.rows = rows;
							field.document.getElementById("moreCriteria").style.display = 'inline';
							//document.getElementById("more2Criteria").style.display = 'inline';
							field.document.forms[0].more.value=getLabel("Common.lesscriteria.label","COMMON")
							field.document.forms[0].frameProperty.value='Y';
							if(groupByLocn=='Y' && groupByEpisode=='Y'){
								if((locationType=='OP' || locationType=='IP') && locationCode=='*ALL'){
										/*if(RP_chk=="Y")
										{
											rows1 = "9%,9%,9%,*";
										}
										else
										{*//*
						rows1 = "0%,9%,9%,*";
					//}
					
			}else if(locationType=='Z'){
				if(tab_menu_yn == "Y" || tab_menu_yn == "y"){
						rows1 ="9%,9%,9%,*";
						
					}
					else{

							/*if(RP_chk=="Y")
							{
								rows1 ="10%,9.5%,7.5%,*";
							}
							else
							{*//*
								rows1 ="7%,7.5%,7.5%,*";
							//}
						//6.8,6.8%
					}
					//rows1 ="9%,9%,9%,*";
			}else{
					rows1 ="0%,0%,9%,*";
			}
		}else if(groupByLocn=='N' && groupByEpisode=='Y'){
			if(locationType=='IP' || locationType=='OP'){
				/*	if(RP_chk="Y")
					{
						rows1 = "9%,0%,0%,*";
					}
					else
					{*//*
						rows1 = "0%,0%,0%,*";
					//}
			}else{
					rows1 ="9%,0%,0%,*";
					
			}
		}else if(groupByLocn=='N' && groupByEpisode=='N'){
					rows1 ="0%,0%,0%,*";
		}
	//	alert('rows'+rows1);
		if(parent.parent.PatResultFr.resultFrameSet != null)
		{
			parent.parent.PatResultFr.resultFrameSet.rows=rows1;
		}

}else if(bool == 'no'){
	
		*/
		if(tab_menu_yn == "Y" || tab_menu_yn == "y"){
			rows = "27%,*,8%";			
		}
		else{			
			rows = "25%,*,8%";//13						
		}
		//rows = "14.5%,*,8%";
		//parent.parent.myFrameSet.removeAttribute(rows);
		//parent.parent.myFrameSet.rows = rows;
		field.document.getElementById("moreCriteria").style.display = 'none';
		//document.getElementById("more2Criteria").style.display = 'none';
		field.document.forms[0].more.value=getLabel("Common.morecriteria.label","COMMON")
		field.document.forms[0].frameProperty.value='N';
		//alert('here'+document.forms[0].more.value,document.forms[0].frameProperty.value);

		if(groupByLocn=='Y' && groupByEpisode=='Y'){
			if((locationType=='OP' || locationType=='IP') && locationCode=='*ALL'){
					/*if(RP_chk=='Y')
					{
						rows1 = "5.5%,5.5%,5.5%,*";
					}
					else
					{*/
						rows1 = "0%,5.5%,5.5%,*";
					//}
			}else if(locationType=='Z'){
				if(tab_menu_yn == "Y" || tab_menu_yn == "y"){
					rows1 ="5.5%,5.5%,5.5%,*";
				}
				else{
					rows1 ="4.6%,5.5%,4.6%,*"; 
				}
			}else{
				rows1 ="0%,0%,4.5%,*";
			}
		}else if(groupByLocn=='N' && groupByEpisode=='Y'){
			if(locationType=='IP' || locationType=='OP'){
			/*	if(RP_chk=='Y')
				{
					rows1 = "5.5%,0%,0%,*";
				}
				else
				{*/
					rows1 = "0%,0%,0%,*";
				//}
			}else{
				rows1 ="5.5%,0%,0%,*"; 
			}
		}else if(groupByLocn=='N' && groupByEpisode=='N'){
						rows1 ="0%,0%,0%,*";
			}
			
 
		if(parent.parent.PatResultFr.resultFrameSet != null)
		{
			parent.parent.PatResultFr.resultFrameSet.rows=rows1;
		}
					
		//checkboxes1();					
}
function visitTypeChange(obj)
{
	//
}
//Adding start for IN072184

function barcodeScan(evnt,pat_id){
	var keyVal	= parseInt(evnt.keyCode);
	 var bar_code_site_yn = document.PatCriteriaFrm.bar_code_scan_site_YN.value;
	   if(bar_code_site_yn =="Y" && pat_id.value!="" && pat_id.value.length>1 && keyVal==17){
		  document.PatCriteriaFrm.bar_code_scaned_YN.value="Y";
	   }else{
		   if(document.PatCriteriaFrm.bar_code_scaned_YN.value == "")//Added condition for testing issue raised by IN072994
		   	   document.PatCriteriaFrm.bar_code_scaned_YN.value="N";
		   }
		 
}//Adding end for IN072184
//6451 STARTS
function checkfields()
{
	if(document.getElementById("bedNo").value!='')
	{
		if(document.getElementById("patientId").value=='' && document.getElementById("bedSearchAllowed").value=='N' ){
			alert(getMessage("PATIENTIDMANDATE","CA"));
			document.getElementById("patientId").focus();
			top.content.workAreaFrame.PatResultFr.location.href="../../eCommon/html/blank.html";
			return false;
		}
		else
		{
		searchClick();
		return true;
		}
		}
	else
	{
	searchClick();
	return true;
	}
	
	}
  //6451 ENDS
  //51215  Start.
  function checkVirtualCons(obj){
	  if(obj.checked){
		  document.forms[0].virtualConsultation.value='Y';
	  }else{
		 document.forms[0].virtualConsultation.value='N'; 
	  }	 
  }
  //51215  End.

