/* 
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           created
12/01/2016	  IN057209		prathyusha	Intake And Output Chart Shift Total master set up										
26/06/2020	  IN072777		Durga Natarajan	   	AAKH-CRF-0097.2
--------------------------------------------------------------------------------------------------------------------
*/
function create(){
	f_query_add_mod.document.location.href='../../eCA/jsp/ChartSetupAddModify.jsp?mode=insert';
}

function apply()
{
	var ch_long_desc = f_query_add_mod.document.AddModifyChartSetupForm.long_desc;
	var ch_short_desc = f_query_add_mod.document.AddModifyChartSetupForm.short_desc;
	var ch_code = f_query_add_mod.document.AddModifyChartSetupForm.chart_code;
	var past_rec_scope_days = f_query_add_mod.document.AddModifyChartSetupForm.past_rec_scope_days;
	
	var fields = new Array(ch_code,ch_long_desc,ch_short_desc,past_rec_scope_days);
	var names = new Array(getLabel("eCA.ChartCode.label",'CA'),getLabel("Common.longdescription.label",'Common'),getLabel("Common.shortdescription.label",'Common'),getLabel("eCA.PastRecordsScope.label",'CA'));
				
		
	if(f_query_add_mod.checkFieldsofMst(fields,names,messageFrame))
	{
		if(f_query_add_mod.document.AddModifyChartSetupForm.Summ_required.checked== true){
			f_query_add_mod.document.AddModifyChartSetupForm.Summ_required.value = 'Y';
		}
		else{
			f_query_add_mod.document.AddModifyChartSetupForm.Summ_required.value = 'N';
		}

		/*if(f_query_add_mod.document.AddModifyChartSetupForm.change_at_trans.value == ""){
			f_query_add_mod.document.AddModifyChartSetupForm.change_at_trans.value = 'Y';
		}*/		
		
		/*if(f_query_add_mod.document.AddModifyChartSetupForm.change_at_trans.checked== true){
			f_query_add_mod.document.AddModifyChartSetupForm.change_at_trans.value = 'Y';
		}
		else{
			f_query_add_mod.document.AddModifyChartSetupForm.change_at_trans.value = 'N';
		}*/
	
		if(f_query_add_mod.document.AddModifyChartSetupForm.Summ_required_day.checked== true){
			f_query_add_mod.document.AddModifyChartSetupForm.Summ_required_day.value = 'Y';
		}
		else{
			f_query_add_mod.document.AddModifyChartSetupForm.Summ_required_day.value = 'N';
		}
		/*if(f_query_add_mod.document.AddModifyChartSetupForm.Summ_required_shift.checked==true){
			f_query_add_mod.document.AddModifyChartSetupForm.Summ_required_shift.value = 'Y';
		}
		else{
			f_query_add_mod.document.AddModifyChartSetupForm.Summ_required_shift.value = 'N';
		}*/
		if(f_query_add_mod.document.AddModifyChartSetupForm.enabled.checked==true){
			f_query_add_mod.document.AddModifyChartSetupForm.enabled.value = 'E';
		}
		else{
			f_query_add_mod.document.AddModifyChartSetupForm.enabled.value = 'D';
		}

		if(f_query_add_mod.document.AddModifyChartSetupForm != null)
		{
			if(f_query_add_mod.document.AddModifyChartSetupForm.mode.value=="modify")
			{
				
					if(f_query_add_mod.document.AddModifyChartSetupForm.chart_type.disabled == true)
					f_query_add_mod.document.AddModifyChartSetupForm.chart_type.disabled = false;

				if(f_query_add_mod.document.AddModifyChartSetupForm.Summ_required_day.disabled == true){
					f_query_add_mod.document.AddModifyChartSetupForm.Summ_required_day.disabled = false;
					if(f_query_add_mod.document.AddModifyChartSetupForm.Summ_required_day.checked == true){
						f_query_add_mod.document.AddModifyChartSetupForm.Summ_required_day.value = 'Y';
					}
				}
				/*if(f_query_add_mod.document.AddModifyChartSetupForm.Summ_required_shift.disabled == true){
					f_query_add_mod.document.AddModifyChartSetupForm.Summ_required_shift.disabled = false;
					if(f_query_add_mod.document.AddModifyChartSetupForm.Summ_required_shift.checked == true){
						f_query_add_mod.document.AddModifyChartSetupForm.Summ_required_shift.value = 'Y' ;
					}
				}*/
				if(f_query_add_mod.document.AddModifyChartSetupForm.Summ_required.disabled == true){
					f_query_add_mod.document.AddModifyChartSetupForm.Summ_required.disabled = false;
					if(f_query_add_mod.document.AddModifyChartSetupForm.Summ_required.checked == true){
						f_query_add_mod.document.AddModifyChartSetupForm.Summ_required.value = 'Y';
					}
				}
				if(f_query_add_mod.document.AddModifyChartSetupForm.change_at_trans.value == ''){
					f_query_add_mod.document.AddModifyChartSetupForm.change_at_trans.value = 'Y';
				}
				if(f_query_add_mod.document.AddModifyChartSetupForm.change_at_trans.disabled == true){
					f_query_add_mod.document.AddModifyChartSetupForm.change_at_trans.disabled = false;
					/*if(f_query_add_mod.document.AddModifyChartSetupForm.change_at_trans.checked == true){
						f_query_add_mod.document.AddModifyChartSetupForm.change_at_trans.value = 'Y';
					}*/
				}
		
				if(f_query_add_mod.document.AddModifyChartSetupForm.summ_req_yn.value == 'N'){
					blankFrameUpdateCopmTab.document.write("<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempformUpdateCopmTab' id='tempformUpdateCopmTab' method = 'post' action='../../eCA/jsp/ChartSetupIntermediateUpdateCompTab.jsp'><input type='hidden' name='ch_id' id='ch_id' value=\""+ch_code.value+"\"></form></body></html>");
					blankFrameUpdateCopmTab.document.tempformUpdateCopmTab.submit();				
				}
		}

		
		f_query_add_mod.document.AddModifyChartSetupForm.action='../../servlet/eCA.ChartSetupServlet';
		f_query_add_mod.document.AddModifyChartSetupForm.target='messageFrame';
		f_query_add_mod.document.AddModifyChartSetupForm.method='post';
		
		f_query_add_mod.document.AddModifyChartSetupForm.submit();
	 }
	}
}

function query(){
	f_query_add_mod.document.location.href = '../../eCA/jsp/ChartSetupQueryCriteria.jsp';
}

function DisableControls(){
	if(parent.f_query_add_mod.document.AddModifyChartSetupForm.Summ_required.checked==true){
		parent.f_query_add_mod.document.AddModifyChartSetupForm.day_summ_from.readOnly=false;
		parent.f_query_add_mod.document.AddModifyChartSetupForm.Summ_required_day.disabled=false;
		parent.f_query_add_mod.document.AddModifyChartSetupForm.Summ_required_day.checked=true;
		//parent.f_query_add_mod.document.AddModifyChartSetupForm.Summ_required_shift.disabled=false;
		parent.f_query_add_mod.document.AddModifyChartSetupForm.day_summ_from.readonly=false;
	}
	else if(parent.f_query_add_mod.document.AddModifyChartSetupForm.Summ_required.checked==false){
		// IN057209 start
		parent.f_query_add_mod.document.AddModifyChartSetupForm.day_summ_from.value='07:00';
		parent.f_query_add_mod.document.AddModifyChartSetupForm.day_summ_to.value='06:59';
		//IN057209 end
		parent.f_query_add_mod.document.AddModifyChartSetupForm.day_summ_from.readOnly=true;
		parent.f_query_add_mod.document.AddModifyChartSetupForm.Summ_required_day.disabled=true;
		parent.f_query_add_mod.document.AddModifyChartSetupForm.Summ_required_day.checked=false;
		//parent.f_query_add_mod.document.AddModifyChartSetupForm.Summ_required_shift.disabled=true;
		//parent.f_query_add_mod.document.AddModifyChartSetupForm.Summ_required_shift.checked=false;	
	}
}

function reverseSelSummYN(chart_id){
	if(parent.f_query_add_mod.document.AddModifyChartSetupForm != null){
		if(parent.f_query_add_mod.document.AddModifyChartSetupForm.mode.value=="modify"){
			if(parent.f_query_add_mod.document.AddModifyChartSetupForm.Summ_required.checked == false){
				parent.blankFrameSummYN.document.write("<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempformSummYN' id='tempformSummYN' method = 'post' action='../../eCA/jsp/ChartSetupIntermediateSummYN.jsp'><input type='hidden' name='ch_id' id='ch_id' value=\""+chart_id+"\"></form></body></html>");
				parent.blankFrameSummYN.document.tempformSummYN.submit();				
			}
		}
	}
	//alert("From JS:"+parent.f_query_add_mod.document.AddModifyChartSetupForm.summ_req_yn.value);
}

function disableFromText(){
	if(parent.f_query_add_mod.document.AddModifyChartSetupForm.Summ_required_day.checked==false){
		parent.f_query_add_mod.document.AddModifyChartSetupForm.day_summ_from.value='07:00';
		parent.f_query_add_mod.document.AddModifyChartSetupForm.day_summ_to.value='06:59';
		parent.f_query_add_mod.document.AddModifyChartSetupForm.day_summ_from.readOnly=true;
	}
	else if(parent.f_query_add_mod.document.AddModifyChartSetupForm.Summ_required_day.checked==true){
		parent.f_query_add_mod.document.AddModifyChartSetupForm.day_summ_from.readOnly=false;
	}
}

/*function disableSummReqd(){
	if((parent.f_query_add_mod.document.AddModifyChartSetupForm.Summ_required_day.checked=false) && (parent.f_query_add_mod.document.AddModifyChartSetupForm.Summ_required_shift.checked=false)){
		parent.f_query_add_mod.document.AddModifyChartSetupForm.Summ_required.checked==false;
	}
}*/

function onSuccess(){
	if(!(f_query_add_mod.document.AddModifyChartSetupForm==null)){
		if(!(f_query_add_mod.document.AddModifyChartSetupForm.mode==null)){
			if(f_query_add_mod.document.AddModifyChartSetupForm.mode.value == 'insert'){
				f_query_add_mod.location.reload();
			}
			else if(f_query_add_mod.document.AddModifyChartSetupForm.mode.value == 'modify'){
				f_query_add_mod.location.reload();
			}
			f_query_add_mod.location.reload();
			messageFrame.location.reload();
			}
	}
}

function reset(){
	 if(f_query_add_mod.document.forms[0]){
		 f_query_add_mod.document.forms[0].reset();
		 shiftSummaryRequiredChangedNew();
	}
	//IN072777 starts
		var temp=f_query_add_mod.document.forms[0].chart_type.value;
		
		if(temp==''){
			f_query_add_mod.document.getElementById("vital_signID").style = 'display'; 
			
		}else if(temp!=''){
			f_query_add_mod.document.getElementById("vital_signID").style = 'display'; 
		//IN072777 ends
		}
}
function shiftSummaryRequiredChangedNew(){
	
	if(f_query_add_mod.document.getElementById("Summ_required_day").checked){
		
		f_query_add_mod.document.getElementById("ShiftSummaryRequiredIdCheck").style = 'display'; 
		
	}else{
		f_query_add_mod.document.getElementById("ShiftSummaryRequiredIdCheck").style = 'display';
	}
	if(f_query_add_mod.document.AddModifyChartSetupForm.shift_summary_required.checked){
		f_query_add_mod.document.getElementById("ShiftSummaryRequiredId").style = 'display';
		f_query_add_mod.document.getElementById("shift_count").style = 'display';
		f_query_add_mod.document.getElementById("shift_duration").style = 'display';
		f_query_add_mod.document.AddModifyChartSetupForm.shift_summary_required.value='Y';
	}
	else{
		f_query_add_mod.document.getElementById("ShiftSummaryRequiredId").style = 'display';
		f_query_add_mod.document.AddModifyChartSetupForm.shift_summary_required.value='N';
		f_query_add_mod.document.getElementById("shift_count").style = 'display';
		f_query_add_mod.document.getElementById("shift_duration").style = 'display';
	}
	
}
function unchkSummYN(){
	if(parent.f_query_add_mod.document.AddModifyChartSetupForm.Summ_required_day.checked == false)
	{
		parent.f_query_add_mod.document.AddModifyChartSetupForm.Summ_required.checked = false;
		//IN057209 start
		document.getElementById("ShiftSummaryRequiredIdCheck").style.display = 'none'; 
		document.getElementById("ShiftSummaryRequiredId").style.display = 'none'; 
		document.getElementById("shift_count").style.display = 'none';
		document.getElementById("shift_duration").style.display = 'none';
		//IN057209 end
	}
	else if (parent.f_query_add_mod.document.AddModifyChartSetupForm.Summ_required_day.checked == true){
		parent.f_query_add_mod.document.AddModifyChartSetupForm.Summ_required.checked = true;
		//IN057209 start
		document.getElementById("ShiftSummaryRequiredIdCheck").style.display = 'inline';
		var shiftSummaryRequiredValue= document.AddModifyChartSetupForm.shift_summary_required.value;
		if(shiftSummaryRequiredValue == 'N'){
			document.getElementById("ShiftSummaryRequiredId").style.display = 'none'; 
			document.getElementById("shift_count").style.display = 'none';
			document.getElementById("shift_duration").style.display = 'none';
		}
		else{
			document.getElementById("ShiftSummaryRequiredId").style.display = 'inline'; 
			document.getElementById("shift_count").style.display = 'inline';
			document.getElementById("shift_duration").style.display = 'inline';
		}
		//IN057209 end
	}
} 

function chkValidityOfTime(strfromTime){
	strfromTimeVal = strfromTime.value;
	strTemp = strfromTimeVal.indexOf(":");
	if(strTemp == -1 || strTemp != 2){
		alert(getMessage("INVALID_TIME_FMT","CA"));
		strfromTime.select();
		return false;
	}
	else
	{
		chkTime(strfromTime);
	}
}

function chkTime(strfromTime){
	strfromTimeVal = strfromTime.value;
	strSplitTime = strfromTimeVal.split(":");
	hr = strSplitTime[0];
	min = strSplitTime[1];
	if(strfromTime.value.length !=5)
	{
		alert(getMessage("INVALID_TIME_FMT","CA"));
				strfromTime.select();
		return false;
	}
	if(hr>23){
		alert(getMessage("INVALID_TIME_HOUR","CA"));
		strfromTime.select();
		return false;
	}
	if(min>59){
				alert(getMessage("INVALID_TIME_MINUTE","CA"));
		strfromTime.select();
		return false;
	}
	calculateTime(strfromTime)
}
function calculateTime(strfromTime){
	strfromTimeVal = strfromTime.value;
	strSplitTime = strfromTimeVal.split(":");
	hr = strSplitTime[0];
	min = strSplitTime[1];

	if(min>0){
		hr_1 = parseInt(hr,10)+24;		
	}
	else{
		hr_1 = parseInt(hr,10)+23;
	}	

	if(hr_1 >24){
		hr_1 = hr_1-24;
	}
	else if(hr_1 == 24){
		hr_1 = 0; ////value for IN057209
	}
	else if(hr_1 == 23){
		if(min == 0){
			hr_1 = 23;
		}
		else{
			hr_1 = 0;
		}
	}
/*	
	if(hr == "01" && min == "00"){
		hr_1 = 12;
	}
	if(hr == "00" && min !="00"){
		hr_1 = 0;
	}
*/    ////Commented for IN057209 
	min_1 = parseInt(min,10)+59;
	
	if(min_1 > 60){
		min_1 = min_1-60;
	}
	else if(min_1 == 60){
		min_1 = 0;
	}

	if(hr_1 >=0 && hr_1 <=9)	
	{
		hr_1 = "0" + hr_1
	}

	if(min_1 >=0 && min_1 <=9){
		min_1 = "0" + min_1;
	}

	finalToTime = hr_1+":"+min_1;
	parent.f_query_add_mod.document.AddModifyChartSetupForm.day_summ_to.value = finalToTime;
	//IN057209  start
	
	if(document.AddModifyChartSetupForm.shift_summary_required.checked){
		var numOfShifts=document.AddModifyChartSetupForm.no_of_shifts.value;
		var shiftHours=document.AddModifyChartSetupForm.shift_hours.value;
		if(numOfShifts == 3){
			parent.f_query_add_mod.document.AddModifyChartSetupForm.shift_one_summ_from.value = strfromTimeVal;
			
		}
		else if(numOfShifts == 2){
			document.AddModifyChartSetupForm.shift_three_summ_from.value="";
			document.AddModifyChartSetupForm.shift_three_summ_to.value="";
			parent.f_query_add_mod.document.AddModifyChartSetupForm.shift_one_summ_from.value = strfromTimeVal;
			//calculateShiftTimes(calculateShiftTimes)
		}
		else if((numOfShifts == 3 )&& (shiftHours == 12)){
			//alert("356");
			alert("Shift Duration Should be less than 12");
			//alert("continue");
			document.getElementById('shift_hours').select();
			
			return false;
		}
		else{
			alert("No of shifts should be either 2 or 3");
			document.AddModifyChartSetupForm.no_of_shifts.select();
			return false;
		}
		
		calculateShiftTimes(numOfShifts)
	}
	else{
		alert("Not Checked ");
	}
	
	//IN057209 end
}

//IN057209 start
function calculateShiftTimes(strfromTime){
	//alert("2");
	//alert(strfromTime+"strfromTime");
	//var input=document.getElementById('shift_hours').select();
	
	var numOfShifts=document.getElementById('no_of_shifts').value;
	var shiftHours=document.getElementById('shift_hours').value;
	//alert("shiftHours value:"+shiftHours);
	var strfromTimeVal =document.getElementById('shift_one_summ_from').value;
	//alert(strfromTimeVal);
	shiftHours = parseInt(shiftHours);
	if(isNaN(shiftHours) || shiftHours > 12 || shiftHours < 1){
		alert("Shift Duration should between 1 and 12");

		setTimeout(function() {
			document.getElementById('shift_hours').focus(); // Focus on the
															// field after alert
		}, 0); // Ensure alert is closed before refocusing
		
		return false;
	}
	else if(numOfShifts == 3 && shiftHours == 12){
		//document.getElementById('shift_hours').select();
		
		alert("Shift Duration Should be less than 12");
		//document.getElementById('shift_hours').value="";
	
		//document.getElementById('shift_hours').select();
		setTimeout(function() {
			document.getElementById('shift_hours').focus(); // Focus on the
															// field after alert
		}, 0); // Ensure alert is closed before refocusing
		return false;
	}
	
	else{
		
		strSplitTime = strfromTimeVal.split(":");
		hr = strSplitTime[0];

		min = strSplitTime[1];

		if(min>0){
			hr_1 = parseInt(hr,10)+parseInt(shiftHours,10);		
		}
		else{
			hr_1 = parseInt(hr,10)+(parseInt(shiftHours,10)-1);
		}	

		if(hr_1 >24){
			hr_1 = hr_1-24;
		}
		else if(hr_1 == 24){
			hr_1 = 0;
		}
		
		

		min_1 = parseInt(min,10)+59;
		
		if(min_1 > 60){
			min_1 = min_1-60;
		}
		else if(min_1 == 60){
			min_1 = 0;
		}

		if(hr_1 >=0 && hr_1 <=9)	
		{
			hr_1 = "0" + hr_1
		}

		if(min_1 >=0 && min_1 <=9){
			min_1 = "0" + min_1;
		}

		finalToTime = hr_1+":"+min_1;
		var disp_hrs1;
		parent.f_query_add_mod.document.AddModifyChartSetupForm.shift_one_summ_to.value = finalToTime;
		if((min_1+1) == 60 ){
				min_1="00";
				disp_hrs1=(parseInt(finalToTime,10) +01);

				
			}
			else{
				min_1=(parseInt(min_1,10) +01);
				disp_hrs1=parseInt(finalToTime,10);
				if(parseInt(min_1,10) < 10)
					min_1="0"+min_1;

				
			} 
		if(disp_hrs1 < 10){
		
			parent.f_query_add_mod.document.AddModifyChartSetupForm.shift_two_summ_from.value = "0"+disp_hrs1+":"+min_1;
		}
		else{
			if(disp_hrs1 == 24)
             parent.f_query_add_mod.document.AddModifyChartSetupForm.shift_two_summ_from.value =  "00:"+min_1;
			else
			parent.f_query_add_mod.document.AddModifyChartSetupForm.shift_two_summ_from.value =  disp_hrs1+":"+min_1;
		}
		textwo(shiftHours)
			

	}
	
}


function textwo(shiftHours){
	
	//alert("alertCount"+alertCount);
	//var numOfShifts=document.AddModifyChartSetupForm.no_of_shifts.value;
	var numOfShifts=document.getElementById('no_of_shifts').value;
	if(numOfShifts == 2){
		
	
		if(shiftHours < 12){

			modifiedShiftHours=24 - (1*shiftHours);
        }
		else{
			modifiedShiftHours=shiftHours;
		}
    }
	else
	{
		modifiedShiftHours=shiftHours;
	}
    
	var finalTwoTime;
	var strfromtwoTimeValTo =document.AddModifyChartSetupForm.shift_two_summ_from.value;
	
	strfromtwoTimeValTo = strfromtwoTimeValTo.split(":");
	
	
	hr = strfromtwoTimeValTo[0];

	min = strfromtwoTimeValTo[1];

	if(min>0){
		
		hr_1 = parseInt(hr,10)+parseInt(modifiedShiftHours,10);		
	}
	else{
		hr_1 = parseInt(hr,10)+((parseInt(modifiedShiftHours,10))-1);
		
	}	

	if(hr_1 >24){
		hr_1 = hr_1-24;
	}
	else if(hr_1 == 24)
	{
		hr_1 = 0;
	}

	min_1 = parseInt(min,10)+59;
	
	if(min_1 > 60){
		min_1 = min_1-60;
	}
	else if(min_1 == 60){
		min_1 = 0;
	}

	if(hr_1 >=0 && hr_1 <=9)	
	{
		hr_1 = "0" + hr_1
	}

	if(min_1 >=0 && min_1 <=9){
		min_1 = "0" + min_1;
	}

	finalTwoTime = hr_1+":"+min_1;
	
	
	parent.f_query_add_mod.document.AddModifyChartSetupForm.shift_two_summ_to.value = finalTwoTime;
	var threeToValue=document.AddModifyChartSetupForm.shift_two_summ_to.value;
//	alert(parseInt(threeToValue,10) +01+":00");
	
	//var numOfShifts=document.AddModifyChartSetupForm.no_of_shifts.value;
	var numOfShifts=document.getElementById('no_of_shifts').value;
	var disp_hrs;
	if((min_1+1) == 60 )
	{
		min_1="00";
		disp_hrs=(parseInt(finalTwoTime,10) +01);
	}
	else
	{
		min_1=(parseInt(min_1,10) +01);
		disp_hrs=parseInt(finalTwoTime,10);
		if(parseInt(min_1,10) < 10)
					min_1="0"+min_1;
	} 
			
	if(numOfShifts == 3)
	{
		if(disp_hrs < 10){
			parent.f_query_add_mod.document.AddModifyChartSetupForm.shift_three_summ_from.value = "0"+disp_hrs+":"+min_1;
		}
		else{
			if(disp_hrs == 24)
			parent.f_query_add_mod.document.AddModifyChartSetupForm.shift_three_summ_from.value = "00:"+min_1;
			else
			parent.f_query_add_mod.document.AddModifyChartSetupForm.shift_three_summ_from.value = disp_hrs+":"+min_1;
		}
		
		texthree(shiftHours)
		
	}
	
}

function texthree(shiftHours){

	var modifiedShiftHours;
	//var numOfShifts=document.AddModifyChartSetupForm.no_of_shifts.value;
	var numOfShifts=document.getElementById('no_of_shifts').value;
		if(shiftHours >8 || shiftHours < 8){
			
			modifiedShiftHours=24 - (2*shiftHours);
		//alert(modifiedShiftHours);
	}
		else{
			modifiedShiftHours=shiftHours;
		}
	
	var strfromtwoTimeValTo =document.AddModifyChartSetupForm.shift_three_summ_from.value;
	strfromtwoTimeValTo = strfromtwoTimeValTo.split(":");
	hr = strfromtwoTimeValTo[0];

	min = strfromtwoTimeValTo[1];

	if(min>0){
		
		hr_1 = parseInt(hr,10)+parseInt(modifiedShiftHours,10);		
	}
	else{
		hr_1 = parseInt(hr,10)+((parseInt(modifiedShiftHours,10))-1);
		
	}	


	if(hr_1 >24){
		hr_1 = hr_1-24;
	}
	else if(hr_1 == 24){
		hr_1 = 0;
	}
	
	min_1 = parseInt(min,10)+59;

	if(min_1 > 60){
		min_1 = min_1-60;
	}
	else if(min_1 == 60){
		min_1 = 0;
	}

	if(hr_1 >=0 && hr_1 <=9)	
	{
		hr_1 = "0" + hr_1;
	}

	if(min_1 >=0 && min_1 <=9){
		min_1 = "0" + min_1;
	}

	
		finalTwoTime = hr_1+":"+min_1;

	
	parent.f_query_add_mod.document.AddModifyChartSetupForm.shift_three_summ_to.value = finalTwoTime;

}

function validateShiftNo(){

	if(document.AddModifyChartSetupForm.shift_summary_required.checked){
		
		var numOfShifts=document.AddModifyChartSetupForm.no_of_shifts.value;
		var strfromTimeVal=document.AddModifyChartSetupForm.day_summ_from.value; 
		var shiftHours=document.AddModifyChartSetupForm.shift_hours.value;
		if(numOfShifts == 3){
			parent.f_query_add_mod.document.AddModifyChartSetupForm.shift_one_summ_from.value = strfromTimeVal;
			//calculateShiftTimes(calculateShiftTimes)
		}
		else if(numOfShifts == 2){
			//alert( "else");
		
			parent.f_query_add_mod.document.AddModifyChartSetupForm.shift_one_summ_from.value = strfromTimeVal;
			document.AddModifyChartSetupForm.shift_three_summ_from.value="";
			document.AddModifyChartSetupForm.shift_three_summ_to.value="";
			
		//	calculateShiftTimes(calculateShiftTimes);
		}
		else if(numOfShifts == 3 && shiftHours == 12){
			alert("Shift Duration Should be less than 12");
//			document.AddModifyChartSetupForm.shift_hours.select();
			document.getElementById('shift_hours').value="";
			return false;
		}
		else{
			alert("No of shifts should be either 2 or 3");
//			document.AddModifyChartSetupForm.no_of_shifts.value="";
//			document.getElementById('no_of_shifts').value="";
			setTimeout(function() {
				document.getElementById('no_of_shifts').focus(); // Focus on the
																// field after alert
			}, 0); // Ensure alert is closed before refocusing
			return false;
		}
		
		calculateShiftTimes(numOfShifts);
	}
	else{
		alert("Not Checked ");
	}
}

function shiftSummaryRequiredChanged(){
	if(document.AddModifyChartSetupForm.shift_summary_required.checked){
		//alert('if');
		document.getElementById("ShiftSummaryRequiredId").style.display = 'inline'; 
		document.getElementById("shift_count").style.display = 'inline';
		document.getElementById("shift_duration").style.display = 'inline';
		//alert(document.AddModifyChartSetupForm.shift_summary_required.value);
		document.AddModifyChartSetupForm.shift_summary_required.value='Y';
	}
	else{
	//	alert('else');
		document.getElementById("ShiftSummaryRequiredId").style.display = 'none'; 
		//alert(document.AddModifyChartSetupForm.shift_summary_required.value);
		document.AddModifyChartSetupForm.shift_summary_required.value='N';
		document.getElementById("shift_count").style.display = 'none';
		document.getElementById("shift_duration").style.display = 'none';
	}
	calculateShiftTimes()
}

//IN057209 end

function CheckForNumsAndColon(event){
    var strCheck = '0123456789:';
	var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	//if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		//return (event.keyCode -= 32);
	return true ;	
}

function resetMsgFrame(){
	parent.messageFrame.document.location.href='../../eCommon/jsp/MstCodeError.jsp';
}
function disableConfig(obj)
{
	if(obj.value == "IO")
	{
		document.AddModifyChartSetupForm.change_at_trans.value = 'Y';
		document.AddModifyChartSetupForm.change_at_trans.disabled = true;
	}
	else
	{
		document.AddModifyChartSetupForm.change_at_trans.disabled = false;
	}
	//IN072777 starts
	var temp=document.forms[0].chart_type.value;
	if(temp=='')
		document.getElementById("vital_signID").style.display = 'inline';	
	else if(temp!='')
		document.getElementById("vital_signID").style.display = 'none';	
	//IN072777 ends
}

function checkForMinus(obj)
{
	if(obj.value != '')
	{
		if(obj.value.indexOf("-") > -1)
		{
			//alert("APP-CA00034 Negative values are not allowed");
			alert(getMessage("POSITIVE_NUMBER_ALLOWED","CA"))
			obj.select();
			return false;
		}
		if(parseInt(obj.value,10)  == 0)
		{
				//alert("APP-CA00035  values should be greater than zero");
				alert(getMessage("INVALID_POSITIVE_NUMBER","Common"));
				obj.select();
				return false;
		}
	}
}

//IN072777 starts
function checkVitalSign(obj)
{
	if(obj.checked== true)
		document.AddModifyChartSetupForm.thirdParty_vitals_appl_YN.value = "Y";
	else
		document.AddModifyChartSetupForm.thirdParty_vitals_appl_YN.value = "N";
}
//IN072777 ends

