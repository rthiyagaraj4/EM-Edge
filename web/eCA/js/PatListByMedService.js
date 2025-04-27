	function changeViewListValue(Obj){
				if(Obj.checked==true){
					document.forms[0].viewList.text='ALL';
					document.forms[0].viewList.value='Z';
					document.PatCriteriaFrm.pract.disabled = false;
					document.PatCriteriaFrm.practSearch.disabled = false;
					document.PatCriteriaFrm.AttendPract.value = '';
					document.PatCriteriaFrm.pract.value = '';
				}
			}

function checkthisnumber(obj) {
	if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {		
		return true;
	}
	else {
  		if ( obj.value.length > 0 ) {
			alert(getMessage("NUM_ALLOWED",'CA'));
  			//alert("APP-SM0046 - Only number is allowed");
  			obj.select();
  			obj.focus();
  			return false;
  		}
  	}
}

function encTypeChange(obj){
	document.forms[0].medServiceCode.value = 'ALL';
	document.forms[0].medServiceDesc.value = "";

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
			document.forms[0].from_date1.value='';
			document.forms[0].from_date11.value='';
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
				if(obj.value == 'OP')
				{
					document.getElementById("visitType").disabled = false;
				}
				else
				{
					document.getElementById("visitType").selectedIndex = 0;
					document.getElementById("visitType").disabled = true;
				}
		}else if(obj.value == 'IP' || obj.value == 'DC'){
				document.getElementById("cal_pv").disabled=true;
				document.getElementById("cal_pv1").disabled=true;
				setDischargeDate(document.forms[0].discharged);
				document.getElementById("visitType").selectedIndex = 0;
				document.getElementById("visitType").disabled = true;
		}
		else
		{
				document.getElementById("visitType").selectedIndex = 0;
				document.getElementById("visitType").disabled = true;

		}

	if (obj.value == 'OP' || obj.value == 'EM' ){
				document.getElementById("wtl").style.display='none';
				document.getElementById("daysVal").style.visibility='hidden';
				document.getElementById("daysVal1").style.visibility='hidden';
				document.getElementById("adm_cal1").style.visibility='hidden';
				document.getElementById("adm_cal2").style.visibility='hidden';
		}else{
				document.getElementById("wtl").style='display';
				document.getElementById("daysVal").style.visibility='visible';
				document.getElementById("daysVal1").style.visibility='visible';
				document.getElementById("adm_cal1").style.visibility='visible';
				document.getElementById("adm_cal2").style.visibility='visible';
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
		if(document.getElementById("groupByMedService").disabled)
			document.getElementById("groupByMedService").disabled = false;
		if(document.getElementById("groupByEpisode").disabled)
			document.getElementById("groupByEpisode").disabled = false;
	}

	if(document.PatCriteriaFrm.patientId.value == '' && checkValue == 'Z')
		document.getElementById("patClsServ").style='display';
	else
		document.getElementById("patClsServ").style.display = 'none';

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
	var medServiceDesc = document.PatCriteriaFrm.medServiceDesc.value;
	var isDischarge = true;
	
	if(patientId == '' && document.PatCriteriaFrm.encounterType.value == 'Z')
	{
		if(medServiceDesc == '')
		{
			alert(getMessage("MEDICAL_SERVICE_BLNK", "CA"));
			medServiceDesc
			return false;
		}
	}

	if(fromDate.value != '' && toDate.value != '')
	{
		isDischarge = dateRangeValidation(fromDate, toDate, locale, '2', 'DMY');
	}
	else
	{
		if (patientId == '' && discharged.checked)
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
				if (!document.PatCriteriaFrm.more.value != getLabel("Common.lesscriteria.label","COMMON"))
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
		isPastVist = dateRangeValidation(patVistFromDate, patVistToDate, locale, '2', 'DMY');
	}
	else
	{
		if (patientId == '' &&  pastVist.checked)
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

	if(patientId == '' && (!isDischarge || !isPastVist))
	{
		top.content.workAreaFrame.PatResultFr.location.href = "../../eCommon/html/blank.html";
		if(!isDischarge && !isPastVist)
		{
			alert(getMessage("PAT_LST_LOCN_PAST_DISCH", "CA"));
			return false;
		}

		if(!isDischarge)
		{
			alert(getMessage("PAT_LST_LOCN_DISCH", "CA"));
			return false;
		}

		if(!isPastVist)
		{
			alert(getMessage("PAT_LST_LOCN_PAST", "CA"));
			return false;
		}
		return false;
	}
	/*

		ends here.
	*/

	if (document.PatCriteriaFrm.more.value==getLabel("Common.lesscriteria.label","COMMON"))
	makeVisible(document.PatCriteriaFrm.more,'N');
	var encounterType=document.PatCriteriaFrm.encounterType.value;
	var medServiceCode=document.PatCriteriaFrm.medServiceCode.value;
	var viewList=document.PatCriteriaFrm.viewList.value;
	var adm_fromdate=document.PatCriteriaFrm.from_date1.value;
	var adm_todate=document.PatCriteriaFrm.from_date11.value;
	var groupByMedService=document.PatCriteriaFrm.groupByMedService.value;
	var groupByEpisode=document.PatCriteriaFrm.groupByEpisode.value;
	var visitdate = document.PatCriteriaFrm.from_date1.value;
	var visitdate1 = document.PatCriteriaFrm.from_date11.value;
	var dischargedate = document.PatCriteriaFrm.from_date2.value;
	var dischargedate1 = document.PatCriteriaFrm.from_date22.value;
	var relnreqyn = document.PatCriteriaFrm.establish_reln_req_yn.value;
	
	var queueId = document.PatCriteriaFrm.queueId.value;
	var queueStatus = document.PatCriteriaFrm.queueStatus1.value;
	var sortOrder = document.PatCriteriaFrm.sortOrder.value;
	var checked_out = document.PatCriteriaFrm.CO.checked?"Y":"N";
	document.PatCriteriaFrm.order_by.value="";
	document.PatCriteriaFrm.re_order.value="";
	document.PatCriteriaFrm.anchor_id.value="";

	var attend_practId = document.PatCriteriaFrm.AttendPract.value;
	var speciality = document.PatCriteriaFrm.specialty_code.value;
	var visitType = document.PatCriteriaFrm.visitType.value;

	var passurl = '../jsp/PatListByMedServiceResultMain.jsp?encounterType='+encounterType+'&medServiceCode='+medServiceCode+'&viewList='+viewList+'&adm_fromdate='+adm_fromdate+'&adm_todate='+adm_todate+'&groupByMedService='+groupByMedService+'&groupByEpisode='+groupByEpisode+'&reln_req_yn='+relnreqyn+'&patientId='+patientId+'&queueId=' +queueId + '&queueStatus='+ queueStatus + '&sortOrder='+sortOrder+ '&checked_out='+checked_out+ '&attend_practId='+attend_practId+ '&speciality='+speciality+'&visitType='+visitType ;

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

	
			
	if(patientId == null || patientId == "")
	{
		var strMesg = getMessage("SPEC_LOCN_OR_PATIENT","CA");
		strMesg = strMesg.replace('$$','Medical Service');
		if(viewList != "S")
		{
			if(encounterType == "Z")
			{
			  if(medServiceCode == "ALL")
				{
				  if(attend_practId == "" && speciality == "")
				  {
					alert(strMesg);
					top.content.workAreaFrame.PatResultFr.location.href="../../eCommon/html/blank.html";
					return false;
				  }
				}
			}
		}
	}

	top.content.workAreaFrame.PatResultFr.location.href = passurl ;
	
}
 
function clearClick()
{
	/*var rows = "32%,*,8%";
	parent.myFrameSet.rows = rows;	*/
	top.content.workAreaFrame.PatResultFr.location.href="../../eCommon/html/blank.html";
	document.location.reload();
}	

function setVisitDate(obj){
	if(obj.checked == true)
	{
		var patientId = document.forms[0].patientId.value;
		/*
			Modified by Kishore Kumar N 06-05-2010, Tuning by Filter date
			Defaulting date minus 2 days to the current date.
		*/
		var locale = document.PatCriteriaFrm.locale.value;
		var fromDate = minusDate(document.PatCriteriaFrm.todaydate.value, 'DMY', locale, '2', 'd');
		document.PatCriteriaFrm.from_date1.value = fromDate;
		/*
			ends here.
		*/
		//Below validation for patientId has been commented by Archana Dhal related to incident no. IN022829.
		//if(!(patientId==""|| patientId==null))
		//{
			//document.forms[0].from_date1.value = document.forms[0].from_visit_date.value;
			document.PatCriteriaFrm.from_date1.readOnly = false;
			document.getElementById('cal_pv').disabled=false;
			//document.PatCriteriaFrm.cal_pv.disabled=false;
			document.PatCriteriaFrm.from_date11.value = document.PatCriteriaFrm.todaydate.value;
			document.PatCriteriaFrm.from_date11.readOnly = false;
			//document.PatCriteriaFrm.cal_pv1.disabled=false;
			document.getElementById('cal_pv1').disabled=false;
		/*}
		else
		{
			//document.PatCriteriaFrm.from_date1.value = document.PatCriteriaFrm.from_visit_date.value;
			document.PatCriteriaFrm.from_date1.readOnly = false;
			document.PatCriteriaFrm.all.cal_pv.disabled=false;
			document.PatCriteriaFrm.from_date11.value = document.PatCriteriaFrm.todaydate.value;
			document.PatCriteriaFrm.from_date11.readOnly = false;
			document.PatCriteriaFrm.all.cal_pv1.disabled=true;
		}*/
	}
	else{
		document.PatCriteriaFrm.from_date1.value = '';
		document.PatCriteriaFrm.from_date1.readOnly = true;
		document.getElementById('cal_pv').disabled=true;
		//document.PatCriteriaFrm.cal_pv.disabled=true;
		document.PatCriteriaFrm.from_date11.value = '';
		document.PatCriteriaFrm.from_date11.readOnly = true;
		//document.PatCriteriaFrm.all.cal_pv1.disabled=true;
		document.getElementById('cal_pv1').disabled=true;
	}
}

function setDischargeDate(obj)
{
	if(obj.checked)
	{
		//document.PatCriteriaFrm.from_date2.value = document.PatCriteriaFrm.from_discharge_date.value;
		document.PatCriteriaFrm.from_date2.readOnly = false;
		/*document.PatCriteriaFrm.all.cal_di.disabled=false;*/
		document.getElementById('cal_di').disabled=false;
		//document.PatCriteriaFrm.from_date22.value = document.PatCriteriaFrm.todaydate.value;
		document.PatCriteriaFrm.from_date22.readOnly = false;
		//document.PatCriteriaFrm.all.cal_di1.disabled=false;
		document.getElementById('cal_di1').disabled=false;

		/*
			Modified by Kishore Kumar N 06-05-2010, Tuning by Filter date
			Defaulting date minus one week to the current date.
		*/
		var locale = document.PatCriteriaFrm.locale.value;
		var fromDate = minusDate(document.PatCriteriaFrm.todaydate.value, 'DMY', locale, '2', 'd');		
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
		//document.PatCriteriaFrm.cal_di.disabled=true;
		document.getElementById('cal_di').disabled=true;
		document.PatCriteriaFrm.from_date22.value = '';
		document.PatCriteriaFrm.from_date22.readOnly = true;
		document.getElementById('cal_di1').disabled=true;
		//document.PatCriteriaFrm.all.cal_di1.disabled=true;
	}
}

function validateDate(obj,val,format,locale)
{
	if(CheckDate(obj))
	{		
		var compDate = '';
		var msgref = '';

		if(val == 'V')
		{
			compDate = document.forms[0].from_visit_date;
			msgref =getMessage("INVALID_FROM_PAST_VISIT_DATE","CA");
		}
		else
		{
			compDate = document.forms[0].from_discharge_date;
			msgref = getMessage("INVALID_FROM_DISCHARGE_DATE","CA");
		}
		var CutOffDt	=	compDate.value;

		CutOffDt		= minusDate(CutOffDt,"DMY",locale,1,"d");
		if((isBefore( obj.value, CutOffDt,format, locale)))
		{	
			alert(msgref);
			obj.select();
			return false;
		}
		
	}
	
}

function checkboxChk(obj){ 
	if(obj.name=="groupByMedService"){
		if(document.getElementById("groupByMedService").checked==false ||document.getElementById("groupByMedService").checked==true){
			if((document.forms[0].encounterType.value=='IP') || (document.forms[0].encounterType.value=='OP') || (document.forms[0].encounterType.value=='EM') || (document.forms[0].encounterType.value=='DC')){
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
						if(document.forms[0].encounterType.value=='Z'){
								document.getElementById("groupByEpisode").disabled = false;
						}else{
								document.getElementById("groupByEpisode").disabled = true;
						}
		}
	}else if(obj.name=="groupByEpisode"){
		if(obj.checked == false){
			if(document.getElementById("groupByMedService").checked){
				document.getElementById("groupByMedService").checked = false;
			}
		}
	}
	if(obj.checked ==true) obj.value='Y'
	else obj.value = 'N'
}

function defaultGroupBy(){
	var chkLocn = document.getElementById("groupByMedService").checked ; 
	if(chkLocn){
		document.getElementById("groupByEpisode").value='Y';
		document.getElementById("groupByEpisode").disabled=true;
	}
}

function showCalendarValidate(str){
	var flg = showCalendar(str);
	document.getElementById(str).focus();
	return flg;
}

/*function CheckSystemDateLesser(from,today) { //args objects 1st is this object & second is the date in dd/mm/yyyy
 if(today != "" && from.value !="" )
	 {
				var fromarray;
				var toarray;
				var fromdate =from.value ;
				var todate =today ;
				
				if(fromdate.length > 0 && todate.length > 0 )
				{
						fromarray = fromdate.split("/");
						toarray = todate.split("/");
						var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
						var todt = new Date(toarray[2],toarray[1],toarray[0]);
						if(Date.parse(todt) < Date.parse(fromdt))
						{
							//var msg =getCAMessage("DATE_GREATER_SYSDATE");
							var msg =getMessage("FROM_DATE_GREATER_SYSDATE","CA");	
							alert(msg);
							//top.messageframe.location.href = '../../eCommon/jsp/error.jsp?err_num='+msg;
							from.focus();
							from.select();
							return false;
						}
						else if(Date.parse(todt) >= Date.parse(fromdt))
						{
							parent.parent.messageFrame.location.href = '../../eCommon/jsp/error.jsp?';
							return true;
						}
				}
			return true;
	 }
	 return true;
}
*/
function CheckSystemDateLesser(from,to,sysDate,format,locale)
{	
		if(!(from.value == "" ))
		{
		var patientId = document.forms[0].patientId.value;
		//Below validation for patientId has been commented by Archana Dhal related to incident no. IN022829.
		//if(patientId==""|| patientId==null)
		//{
			//document.forms[0].from_date11.value = document.forms[0].todaydate.value ;/*Commented by kishore kumar N on 06-05-2010.*/
			//document.forms[0].from_date11.readOnly = true;
		/*}
		else
		{
			document.forms[0].from_date11.readOnly = false;
		}*/
		document.forms[0].from_date11.readOnly = false;
		//Below Date Validation is added by Archana Dhal related to incident no. IN022829.
		if((to.value != '' && !validDate(to.value, format, locale)))
		{
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			//alert(msg);
			to.select();
			to.focus();
			return false;
		}
				 
		 
		 if(!isBeforeNow(from.value,format,locale))
			{
			
				alert(top.header.getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
				/*from.select();*/
				from.value="";
				from.focus();
				return false;
				
			}
			else
			{ 
			 if(!(to.value == "" ))
				{
				   if(isBeforeNow(to.value,format,locale))

				{
					if(isAfter(to.value,from.value, format, locale))
					{
						return true;
					}
					else
					{
						alert(top.header.getMessage("TO_DT_GR_EQ_FM_DT","CA")); 
						return false;
					}
				}
				else
				{
					alert(top.header.getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
					//to.select();
					to.value="";
					to.focus();
					return false;
				}
				}
			}
		
		}
		else
	{
			if((!to.value==""))
			{
				if(!isBeforeNow(to.value, format, locale))
				{
					alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
					//to.select();
					to.value="";
					to.focus();
					return false;
				}
			}
	}
}
	/*function doDateCheck(from,to,obj,obj1) {
				if(CheckSystemDateLesser(obj,obj1)){ 
					if(!doDateCheckAlert(from,to)){
						//alert("APP-SM0012 - To Date should be greater than or equal to From Date");
						//alert(top.header.getCAMessage("TO_DT_GR_EQ_FM_DT"));
						alert(top.header.getMessage("TO_DT_GR_EQ_FM_DT","CA"));
						obj.select();
						obj.focus();
						return false;
					}
				}
			}*/
					
			function makeVisible(obj,tab_menu_yn){
					var groupByMedService=document.forms[0].groupByMedService.value;
					var groupByEpisode=document.forms[0].groupByEpisode.value;
					var encounterType=document.forms[0].encounterType.value;
					var medServiceCode=document.forms[0].medServiceCode.value;
					var val =obj.value;
					var rows;
					//if (document.forms[0].more.value=='<< Less Criteria') bool='no';
					if (document.forms[0].more.value==getLabel("Common.lesscriteria.label","COMMON")) bool='no';
					else bool='yes';

					if(val=='Search'){
						bool='no';
					}

					if(bool == 'yes'){
							if(tab_menu_yn == "Y" || tab_menu_yn == "y"){
								rows = "45%,*,10%";
							}
							else{
								rows = "62%,*,10%";
							}
							/*parent.myFrameSet.removeAttribute(rows);
							parent.myFrameSet.rows = rows;*/
							parent.document.getElementById('PatCriteriaFr').style.height="81vh";
							parent.document.getElementById('PatResultFr').style.height="10vh";
							parent.document.getElementById('colorRefframe').style.height="8vh";
							document.getElementById("moreCriteria").style='display';
							document.getElementById("more2Criteria").style='display';
							//document.forms[0].more.value='<< Less Criteria'
							document.forms[0].more.value=getLabel("Common.lesscriteria.label","COMMON");
							document.forms[0].frameProperty.value='Y';

							if(groupByMedService=='Y' && groupByEpisode=='Y'){
								if((encounterType=='OP' || encounterType=='IP') && medServiceCode=='ALL'){
									rows1 = "0%,13%,16%,*";
								}else if(encounterType=='Z'){
									if(tab_menu_yn == "Y" || tab_menu_yn == "y"){
											rows1 ="9%,9%,9%,*";
										}
										else{
											rows1 ="10%,12%,15%,*";
										}
										//rows1 ="9%,9%,9%,*";		
								}else{
										rows1 ="0%,12%,15%,*";
								}
							}else if(groupByMedService=='N' && groupByEpisode=='Y'){
								
								if(encounterType=='Z')
								{
									rows1 ="10%,0%,0%,*";
								}
								else
								{
								
									rows1 ="0%,0%,0%,*";
								}

								/*
								if(encounterType=='IP' || encounterType=='OP'){
										rows1 = "0%,0%,0%,*";
								}else 
								{
									rows1 ="10%,0%,0%,*";
								}*/
								
							}else if(groupByMedService=='N' && groupByEpisode=='N'){
										rows1 ="0%,0%,0%,*";
							}
							
							if(parent.PatResultFr.resultFrameSet != null)
							{
								parent.PatResultFr.resultFrameSet.rows=rows1;
							}

					}else if(bool == 'no'){
							if(tab_menu_yn == "Y" || tab_menu_yn == "y"){
								rows = "22%,*,8%";	
							}
							else{
								rows = "32%,*,8%";
							}
										
						//	parent.myFrameSet.removeAttribute(rows);
						//	parent.myFrameSet.rows = rows;
						//	parent.myFrameSet.noResize = true;
							parent.document.getElementById('PatCriteriaFr').style.height="33vh";//41
							parent.document.getElementById('PatResultFr').style.height="57vh";//49
							parent.document.getElementById('colorRefframe').style.height="8vh";
							document.getElementById("moreCriteria").style.display = 'none';
							document.getElementById("more2Criteria").style.display = 'none';
							//document.forms[0].more.value='More Criteria >>'
							document.forms[0].more.value=getLabel("Common.morecriteria.label","COMMON");
							document.forms[0].frameProperty.value='N';

							if(groupByMedService=='Y' && groupByEpisode=='Y'){
								if((encounterType=='OP' || encounterType=='IP') && medServiceCode=='ALL'){
										rows1 = "0%,6.5%,8%,*";
								}else if(encounterType=='Z'){
									if(tab_menu_yn == "Y" || tab_menu_yn == "y"){
										rows1 ="9%,9%,9%,*";
										}
										else{
										rows1 ="5.5%,5.5%,8%,*";
										}
								
									//	rows1 ="5.5%,5.5%,5.5%,*";
								}else{
										rows1 ="0%,6.5%,8%,*";
								}
							}else if(groupByMedService=='N' && groupByEpisode=='Y'){
								
								if(encounterType=='Z')
								{
									rows1 ="5.5%,0%,0%,*";
								}
								else
								{
									rows1 = "0%,0%,0%,*";
								}
								
								/*if(encounterType=='IP' || encounterType=='OP'){
										rows1 = "0%,0%,0%,*";
								}else{
										rows1 ="5.5%,0%,0%,*";
										//rows1 ="0%,0%,0%,*";
								}*/
							}else if(groupByMedService=='N' && groupByEpisode=='N'){
												rows1 ="0%,0%,0%,*";
								}
								
								
								if(parent.PatResultFr.resultFrameSet != null)
								{
									parent.PatResultFr.resultFrameSet.rows=rows1;
									parent.PatResultFr.resultFrameSet.noResize=true;
								}
						
					}
					
			}

			function checkboxes(){
					document.forms[0].QS.checked=true;
					checkAll(document.forms[0].QS);
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
					if(document.forms[0].CO.checked==true)	document.forms[0].queueStatus.value=' 01,02,03,04,05,06,07';
					else		document.forms[0].queueStatus.value=' 01,02,03,04,05,06';							
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

			function appendStatus(obj){
				var v=document.forms[0].queueStatus.value;
				var va=obj.value;
				var val='';
				var vv='';
				if (obj.checked){
					if (v==''){
						v=va;
					}else{
						v=v+','+va
					}
				}else{
					val=va;
					if (v==val){
						v='';
					}
					if(v.length ==3){
							v='';
					}
					val=va+','
					if (v.indexOf(val)){
							v=v.replace(val,'');
					}
							 vv=','+va
					if (v.indexOf(vv)){
							v=v.replace(vv,'');
					}
				}
				document.forms[0].queueStatus.value=v;
			}


			function ChkDateFormat(obj){
					if(!ChkDate(obj)){
						//alert(top.header.getCAMessage("INVALID_DATE_FMT"));
						alert(top.header.getMessage("INVALID_DATE_FMT","CA"));
						obj.focus();
					}
			}

			async function callPatientSearch(){
					var pat_id =  await PatientSearch();
					if(pat_id != null)  document.getElementById("patientId").value = pat_id;
			}

			function checkDuplicate(obj)
				{
					ChangeUpperCase(obj);

					if(document.PatCriteriaFrm.encounterType.value == 'Z' && obj.value =='')
						document.getElementById("patClsServ").style.display = 'inline';
					else
						document.getElementById("patClsServ").style.display = 'none';

					if(obj.value != ""){
						var HTMLVal = "<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='frmDuplicateId' id='frmDuplicateId' method='post' action='../../eCA/jsp/CAValidatePatientId.jsp'><input type='hidden' name='patient_id' id='patient_id' value='"+escape(obj.value)+"'><input type='hidden' name='fromFunction' id='fromFunction' value='PatListByMedService'></form></body></html>";
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
						//document.forms[0].from_date11.value = document.forms[0].todaydate.value ;
						document.forms[0].from_date11.readOnly = true;
						document.forms[0].cal_pv1.disabled=true;
						
					}
				}

			function disBtn(obj)
			{
				//obj.disabled = true;
			}

async function populateService(obj,ca_practitioner_id,facilityId)
{
		
		var patient_class=obj.value;		
		var target			= document.forms[0].medServiceDesc;
		var retVal			=  new String();
		var dialogTop	= "40";
		var dialogHeight		= "10" ;
		var dialogWidth	= "40" ;
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var search_desc			= "";
		var title				=getLabel("Common.MedicalService.label","COMMON");
		var locale =document.forms[0].locale.value; 
		
		if (patient_class == "Z")
			var sql="select DISTINCT a.SERVICE_CODE code,b.SHORT_DESC description from CA_PRACT_BY_SPLTY_LOCN_VIEW a,AM_SERVICE_LANG_VW B where FACILITY_ID='"+facilityId+"' and upper(B.SHORT_DESC) like upper(?)and A.SERVICE_CODE like upper(?) and PRACTITIONER_ID='"+ca_practitioner_id+"' and a.service_code =  b.SERVICE_CODE AND B.LANGUAGE_ID = '"+locale+"'";	
		else
			var sql="select DISTINCT a.SERVICE_CODE code,B.SHORT_DESC description from CA_PRACT_BY_SPLTY_LOCN_VIEW A,AM_SERVICE_LANG_VW B  where FACILITY_ID='"+facilityId+"' and upper(B.SHORT_DESC) like upper(?)and A.SERVICE_CODE like upper(?) and PRACTITIONER_ID='"+ca_practitioner_id+"' and PATIENT_CLASS='"+patient_class+"' AND A.SERVICE_CODE = B.SERVICE_CODE AND B.LANGUAGE_ID = '"+locale+"'"; 

		var argArray		= new Array();
		var namesArray		= new Array();
		var valuesArray		= new Array();
		var datatypesArray	= new Array();

		
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "2,1";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		
		retArray = await CommonLookup( title, argArray );
		
		var arr=new Array();
		
		if (retArray != null  && retArray != "")
		{
			var retVal=unescape(retArray);
		    arr=retVal.split(",");
		    
		   	document.forms[0].medServiceDesc.value=arr[1];
			document.forms[0].medServiceCode.value=arr[0];
		}
		else
		{	
			document.forms[0].medServiceCode.value="ALL";
			document.forms[0].medServiceDesc.value="";
		}
}

async function getServiceCode(obj1,obj2,ca_practitioner_id,facilityId)
{
	if(obj1.value!="")
	{
		await populateService(obj2,ca_practitioner_id,facilityId);
	}
	else
	{
		document.forms[0].medServiceCode.value="ALL";
		document.forms[0].medServiceDesc.value="";	
	}
}

async function populatePract1(obj)
{
	if (obj.value != "")
	{
		await populatePract();
	}
	else
	{
		document.forms[0].AttendPract.value = "";
	}
}

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
		
		var sql="Select a.practitioner_id code , b.practitioner_name  description from am_pract_for_facility_vw a, am_practitioner_lang_vw b where a.operating_facility_id = '"+facilityid+"' and a.practitioner_id = b.practitioner_id and b.language_id = '"+locale+"' and a.eff_status = 'E' and  upper(a.practitioner_id) like upper(?) and upper(b.practitioner_name) like upper(?) order by b.practitioner_name";

		var argArray		= new Array();
		var namesArray		= new Array();
		var valuesArray		= new Array();
		var datatypesArray	= new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";

		//alert(target.value);
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retArray = await CommonLookup( title, argArray );
		
		var arr=new Array();

		if (retArray != null && retArray != '' && retArray != "null")
		{
			var retVal=unescape(retArray);
		    arr=retVal.split(",");
		    
		   	document.forms[0].pract.value = arr[1];
		   	document.forms[0].AttendPract.value = arr[0];
		}
		else
		{
			document.forms[0].pract.value = "";
			document.forms[0].AttendPract.value = "";
		} 
}

async function getSpecialty1(obj)
{
	if (obj.value != "")
	{
		await getSpecialty();
	}
	else
	{
		document.forms[0].specialty_code.value = "";
	}
}

async function getSpecialty()
{
	var target			= document.forms[0].specialty;
	var stdval          = document.forms[0].specialty_code.value;
	var pract			= document.forms[0].AttendPract.value;
	var facilityid      = document.forms[0].facilityid.value;
   
	var retVal			= new String();
	var dialogTop		= "40";
	var dialogHeight	= "10" ;
	var dialogWidth		= "40" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments		= "" ;
	var search_desc		= "";
	var title			= getLabel("Common.Specialty.label","Common");
	
	var sql="select a.SPECIALITY_CODE code, a.SHORT_DESC description from AM_SPECIALITY a where eff_status = 'E' ";

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
	retArray = await CommonLookup( title, argArray )

	var arr=new Array();

	if (retArray != null && retArray != '' && retArray != "null")
	{
		var retVal=unescape(retArray);
	    arr=retVal.split(",");
		document.forms[0].specialty.value = arr[1];
		document.forms[0].specialty_code.value = arr[0];
	}
	else
	{
		document.forms[0].specialty.value = "";
		document.forms[0].specialty_code.value = "";
	} 
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
function visitTypeChange(obj)
{
	//
}

