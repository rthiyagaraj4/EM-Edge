clinicCodeArr = new Array();
clinicDescArr = new Array();
clinicTypeArr = new Array();
wardCodeArr = new Array();
wardDescArr = new Array();
dayCareCodArray =new Array();
dayCareDesArray =new Array();
OPEmerCodArray =new Array();
OPEmerDesArray =new Array();

		function changeViewListValue(Obj){
				if(Obj.checked==true){
					document.forms[0].viewList.text='ALL';
					document.forms[0].viewList.value='Z';
				}
		}

function checkthisnumber(obj){
	if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {		
		return true;
	}else{ 
  		if ( obj.value.length > 0 ){
  			alert(getMessage('ONLY_NUMBER_ALLOWED','CA'));
			obj.select();
  			obj.focus();
  			return false;
  		}
  	}
}

function locnTypeChange(obj){ 
		if(obj.value== 'IP'  || obj.value == 'DC'){	 
				document.forms[0].QS.disabled=true;
				document.forms[0].CI.disabled=true;
				document.forms[0].AAN.disabled=true;
				document.forms[0].VS.disabled=true;				
				document.forms[0].CIP.disabled=true;
				document.forms[0].TI.disabled=true;
				document.forms[0].RFI.disabled=true;
				document.forms[0].CO.disabled=true;
		}else{
				document.forms[0].QS.disabled=false;
				document.forms[0].CI.disabled=false;
				document.forms[0].AAN.disabled=false;
				document.forms[0].VS.disabled=false;				
				document.forms[0].CIP.disabled=false;
				document.forms[0].TI.disabled=false;
				document.forms[0].RFI.disabled=false;
				document.forms[0].CO.disabled=false;
		}
	

		if(obj.value == 'OP' || obj.value == 'EM'){
			document.forms[0].unscheduled.disabled = false;
			document.forms[0].past.disabled = false;
			document.forms[0].from_date1.value = '';
			document.forms[0].from_date1.disabled = false;
			document.forms[0].from_date11.value = '';
			document.forms[0].from_date11.disabled = false;
			document.forms[0].discharged.disabled = true;
			document.forms[0].from_date2.value = '';
			document.forms[0].from_date2.disabled = true;
			document.forms[0].from_date22.value = '';
			document.forms[0].from_date22.disabled = true;
			document.forms[0].past.checked=false;
			document.forms[0].discharged.checked = false;
		}else if(obj.value == 'IP' || obj.value == 'DC'){
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
		}else{
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
		}

		if(obj.value == 'OP' || obj.value == 'EM'){
				document.getElementById("cal_di").disabled=true;
				document.getElementById("cal_di1").disabled=true;
				setVisitDate(document.forms[0].past);
		}else if(obj.value == 'IP' || obj.value == 'DC'){
				document.getElementById("cal_pv").disabled=true;
				document.getElementById("cal_pv1").disabled=true;
				setDischargeDate(document.forms[0].discharged);
		}

		document.getElementById("locLed").innerText='Location';
		document.getElementById("locVal").style.visibility='visible';
		document.forms[0].locationCode.disabled = false;
		var optlen = document.forms[0].locationCode.options.length;
		for (i=0; i<optlen; i++){
			document.forms[0].locationCode.remove(0);
		}

		if (obj.value == 'OP' || obj.value == 'EM' ){
				document.getElementById("wtl").style.visibility='hidden';
				document.getElementById("daysVal").style.visibility='hidden';
				document.getElementById("daysVal1").style.visibility='hidden';
				document.getElementById("adm_cal1").style.visibility='hidden';
				document.getElementById("adm_cal2").style.visibility='hidden';
		}else{
				document.getElementById("wtl").style.visibility='visible';
				document.getElementById("daysVal").style.visibility='visible';
				document.getElementById("daysVal1").style.visibility='visible';
				document.getElementById("adm_cal1").style.visibility='visible';
				document.getElementById("adm_cal2").style.visibility='visible';
		}

		if(obj.value == 'Z' ){
			document.getElementById("locLed").innerText='';
			document.getElementById("locVal").style.visibility='hidden';
			document.forms[0].locationCode.disabled = true;
			var oOption = document.createElement("OPTION");
			oOption.text="All";
			oOption.value="*ALL";
			document.forms[0].locationCode.add(oOption);
		}else if(obj.value == 'OP') {
			document.getElementById("locLed").innerText='Clinic ';
			var oOption = document.createElement("OPTION");
			oOption.text="All";
			oOption.value="*ALL";
			document.forms[0].locationCode.add(oOption);
			for(j=0; j<clinicCodeArr.length; j++){
				if (clinicTypeArr[j]=='A'){
					var oOption = document.createElement("OPTION");
					oOption.text=clinicDescArr[j];
					oOption.value=clinicCodeArr[j];
					document.forms[0].locationCode.add(oOption);
				}			
			}
	}else if(obj.value == 'IP'){ 
		document.getElementById("locLed").innerText='Nursing Unit ';
		var oOption = document.createElement("OPTION");
		oOption.text="All";
			oOption.value="*ALL";
		document.forms[0].locationCode.add(oOption);
		for(j=0; j<wardCodeArr.length; j++) {
			var oOption = document.createElement("OPTION");
			oOption.text=wardDescArr[j];
			oOption.value=wardCodeArr[j];
			document.forms[0].locationCode.add(oOption);
		}
	}else if (obj.value=='DC'){
		document.getElementById("locLed").innerText='Day Care Units ';
		var oOption = document.createElement("OPTION");
		oOption.text="All";
		oOption.value="*ALL";
		document.forms[0].locationCode.add(oOption);
		for(j=0; j<dayCareCodArray.length; j++) {
			var oOption = document.createElement("OPTION");
			oOption.text=dayCareDesArray[j];
			oOption.value=dayCareCodArray[j];
			document.forms[0].locationCode.add(oOption);
		}
	}else if( obj.value=='EM'){
		document.getElementById("locLed").innerText='Emergency Units ';
		var oOption = document.createElement("OPTION");
		oOption.text="All";
		oOption.value="*ALL";
		document.forms[0].locationCode.add(oOption);
		for(j=0; j<OPEmerCodArray.length; j++) {
			var oOption = document.createElement("OPTION");
			oOption.text=OPEmerDesArray[j];
			oOption.value=OPEmerCodArray[j];
			document.forms[0].locationCode.add(oOption);
		}
	}
	
	if (obj.value == 'IP' || obj.value == 'DC'){
			document.getElementById("queueStatus").style.visibility='hidden';
	}else {
		document.getElementById("queueStatus").style.visibility='visible';
	}

	 var checkValue = obj.value;

	if((checkValue=='OP') || (checkValue=='IP')){
			document.getElementById("groupByEpisode").checked = true;
			document.getElementById("groupByEpisode").disabled = true;
			document.getElementById("groupByEpisode").value='Y';
	}else if(checkValue=='Z'){
		if(document.getElementById("groupByLocn").disabled)
			document.getElementById("groupByLocn").disabled = false;
		if(document.getElementById("groupByEpisode").disabled)
			document.getElementById("groupByEpisode").disabled = false;
	}
	 /***Ends Here***/
}

function searchClick()
{
	var locationType=document.forms[0].locationType.value;
	var locationCode=document.forms[0].locationCode.value;
	var viewList=document.forms[0].viewList.value;
	var adm_fromdate=document.forms[0].adm_fromdate.value;
	var adm_todate=document.forms[0].adm_todate.value;
	var groupByLocn=document.forms[0].groupByLocn.value;
	var groupByEpisode=document.forms[0].groupByEpisode.value;
	var visitdate = document.forms[0].from_date1.value;
	var visitdate1 = document.forms[0].from_date11.value;
	var dischargedate = document.forms[0].from_date2.value;
	var dischargedate1 = document.forms[0].from_date22.value;
	var relnreqyn = document.forms[0].establish_reln_req_yn.value;
	var mode = document.forms[0].mode.value;
	var patientId = document.forms[0].patientId.value;
	var queueId = document.forms[0].queueId.value;
	var nationID = document.forms[0].nationID.value;
	var queueStatus = document.forms[0].queueStatus1.value;
	var sortOrder = document.forms[0].sortOrder.value;
	var frameProperty = document.forms[0].frameProperty.value;
	var checked_out = document.forms[0].CO.checked?"Y":"N";
	document.forms[0].order_by.value="";
	document.forms[0].re_order.value="";
	document.forms[0].anchor_id.value="";
	
	var passurl = '../jsp/PatientListByLocationResultMain.jsp?locationType='+locationType+'&locationCode='+locationCode+'&viewList='+viewList+'&adm_fromdate='+adm_fromdate+'&adm_todate='+adm_todate+'&groupByLocn='+groupByLocn+'&groupByEpisode='+groupByEpisode+'&reln_req_yn='+relnreqyn+'&mode='+mode +'&patientId='+patientId+'&queueId=' +queueId+'&nationID='+nationID+ '&queueStatus='+ queueStatus + '&sortOrder='+sortOrder+ '&checked_out='+checked_out ;
	if (visitdate=='' && visitdate1=='')	document.forms[0].past.checked = false;
	if (dischargedate=='' && dischargedate1=='') document.forms[0].discharged.checked = false; 
	
	if(document.forms[0].past.checked == true)
		passurl += '&past=Y&from_visit_date='+visitdate+'&to_visit_date='+visitdate1
	else
		passurl += '&past=';

	if(document.forms[0].discharged.checked == true) 
		passurl += '&discharged=Y&from_discharge_date='+dischargedate+'&to_discharge_date='+dischargedate1
	else
			passurl += '&discharged=';

	if(document.forms[0].unscheduled.checked == true)
		passurl += '&unscheduled_yn=Y'
	top.content.workAreaFrame.PatResultFr.location.href = passurl ;
}	

function clearClick()
{	
	top.content.workAreaFrame.PatResultFr.location.href="../../eCommon/html/blank.html";
	document.location.reload();	
}

function setVisitDate(obj)
{
	if(obj.checked == true)
	{
		document.forms[0].from_date1.value = document.forms[0].from_visit_date.value;
		document.forms[0].from_date1.readOnly = false;
		document.forms[0].cal_pv.disabled=false;
		document.forms[0].from_date11.value = document.forms[0].todaydate.value;
		document.forms[0].from_date11.readOnly = false;
		document.forms[0].cal_pv1.disabled=false;
	}else
	{
		document.forms[0].from_date1.value = '';
		document.forms[0].from_date1.readOnly = true;
		document.forms[0].cal_pv.disabled=true;
		document.forms[0].from_date11.value = '';
		document.forms[0].from_date11.readOnly = true;
		document.forms[0].cal_pv1.disabled=true;
	}
}

function setDischargeDate(obj)
{
	if(obj.checked == true)
	{
		document.forms[0].from_date2.value = document.forms[0].from_discharge_date.value;
		document.forms[0].from_date2.readOnly = false;
		document.forms[0].cal_di.disabled=false;
		document.forms[0].from_date22.value = document.forms[0].todaydate.value;
		document.forms[0].from_date22.readOnly = false;
		document.forms[0].cal_di1.disabled=false;
	}
	else
	{
		document.forms[0].from_date2.value = '';
		document.forms[0].from_date2.readOnly = true;
		document.forms[0].cal_di.disabled=true;
		document.forms[0].from_date22.value = '';
		document.forms[0].from_date22.readOnly = true;
		document.forms[0].cal_di1.disabled=true;
	}
}

function validateDate(obj,val)
{
	
	if(!ChkDate(obj))
	{
		alert(top.header.getMessage("INVALID_DATE_FMT","CA"));
		obj.focus();
	}
	else
	{
		var compDate = '';
		var msgref = '';
		if(val == 'V')
		{
			compDate = document.forms[0].from_visit_date;
			
			msgref = "INVALID_FROM_PAST_VISIT_DATE";
		}
		else
		{
			compDate = document.forms[0].from_discharge_date;
			msgref = "INVALID_FROM_DISCHARGE_DATE";
		}
		if(!doDateCheckAlert(compDate,obj))
		{
			
			alert(top.content.workAreaFrame.PatCriteriaFr.getMessage(msgref,'CA'));
			obj.focus();
		}
	}
}

function checkboxChk(obj)
{ 
	if(obj.name=="groupByLocn")
	{
		if(document.getElementById("groupByLocn").checked==false ||document.getElementById("groupByLocn").checked==true)
		{
			if((document.forms[0].locationType.value=='IP') || (document.forms[0].locationType.value=='OP') || (document.forms[0].locationType.value=='EM') || (document.forms[0].locationType.value=='DC'))
			{
				document.getElementById("groupByEpisode").disabled=false;
			}
		}
		if((document.getElementById("groupByEpisode").disabled) && (document.getElementById("groupByEpisode").checked))
		{
			document.getElementById("groupByEpisode").disabled = false;
		}else if((!document.getElementById("groupByEpisode").disabled) && (!document.getElementById("groupByEpisode").checked))
		{
			document.getElementById("groupByEpisode").disabled = true;
			document.getElementById("groupByEpisode").value = 'Y';
			document.getElementById("groupByEpisode").checked = true;
		}
		else if((!document.getElementById("groupByEpisode").disabled) && (document.getElementById("groupByEpisode").checked))
		{
			if(document.forms[0].locationType.value=='Z')
			{
				document.getElementById("groupByEpisode").disabled = false;
			}
			else
			{
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
			}
		}
	}
	if(obj.checked ==true) obj.value='Y'
	else obj.value = 'N'
}

function defaultGroupBy()
{
	var chkLocn = document.getElementById("groupByLocn").checked ; 
	if(chkLocn)
	{
		document.getElementById("groupByEpisode").value='Y';
		document.getElementById("groupByEpisode").disabled=true;
	}
}

function showCalendarValidate(str)
{
	var flg = showCalendar(str);
	document.getElementById(str).focus();
	return flg;
}
