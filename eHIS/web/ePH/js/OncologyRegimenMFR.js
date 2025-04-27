/*  This is new file created for oncology MFR ML-MMOH-CRF-1014*/
function changeCursor(obj) {   
	obj.style.cursor = "hand";
}

function checkHr(rowNum){
	obj = eval("document.formOngoIVPrescriptionMFR.InfOverHr"+rowNum);
	var ivType		= document.formOngoIVPrescriptionMFR.ivType.value; 
	if(obj.value != "" && parseInt(obj.value) == 24){
		eval("document.formOngoIVPrescriptionMFR.InfOverMin"+rowNum).value="0";
		return;
	}
/*	if(obj.value != "" && parseInt(obj.value) > 24 && ivType == "ivd"){ //Commented for ML-MMOH-CRF-1222
		alert(getMessage("INFUSE_OVER_CANNOT_GREATER","PH"));
		return false;
	} */
	if(obj.value == "")
		obj.value = "0";
}

function checkMin(rowNum){

	if(eval("document.formOngoIVPrescriptionMFR.InfOverHr"+rowNum).value != "" && parseInt(eval("document.formOngoIVPrescriptionMFR.InfOverHr"+rowNum).value) == 24){
		eval("document.formOngoIVPrescriptionMFR.InfOverMin"+rowNum).value="0";
		return;
	}
	if(eval("document.formOngoIVPrescriptionMFR.InfOverMin"+rowNum).value != "" && parseInt(eval("document.formOngoIVPrescriptionMFR.InfOverMin"+rowNum).value) > 59){
		alert(getMessage("INVALID_TIME_MINUTE","PH"));
		eval("document.formOngoIVPrescriptionMFR.InfOverMin"+rowNum).value="0";
	}
	if(eval("document.formOngoIVPrescriptionMFR.InfOverMin"+rowNum).value == "")
		eval("document.formOngoIVPrescriptionMFR.InfOverMin"+rowNum).value = "0";
	if(eval("document.formOngoIVPrescriptionMFR.InfOverHr"+rowNum).value=="")
		eval("document.formOngoIVPrescriptionMFR.InfOverHr"+rowNum).value="0";
}
function checkHrGap(rowNum){
	obj = eval("document.formOngoIVPrescriptionMFR.InfGapHr"+rowNum);
}

function checkMinGap(rowNum){

	
	if(eval("document.formOngoIVPrescriptionMFR.InfOverMin"+rowNum).value != "" && parseInt(eval("document.formOngoIVPrescriptionMFR.InfGapMin"+rowNum).value) > 59){
		alert(getMessage("INVALID_TIME_MINUTE","PH"));
	}
}

async function adminRate(i){

	frmObj	= document.formOngoIVPrescriptionMFR;

	var infuse_over_hr	= eval("frmObj.InfOverHr"+i).value;
	var infuse_over_min = eval("frmObj.InfOverMin"+i).value;
	var infuse_over		= eval("frmObj.infusion_over_insert_value"+i).value;
	var patient_id		= frmObj.patient_id.value;
	var encounter_id	= frmObj.encounter_id.value;
	var weight			= frmObj.weight.value;

	var dialogHeight= "35vh";
	var dialogWidth	= "45vw";
	var dialogTop	= "250";
	var center		= "1";
	var status		= "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";

	var retVal		= await window.showModalDialog("../jsp/IVPrescriptionAdminRate.jsp?weight="+weight+"&infuse_over="+infuse_over+"&patient_id="+patient_id+"&encounter_id="+encounter_id, arguments, features);
}

function addRow(obj,num){
	

		if(!calcTotals(document.formOngoIVPrescriptionMFR.noOfRows.value))
			return false


	if(validateCurrentRow(num)){
		populateDate(num); 
		if(obj.id == 'validate'+num){
			reCalculateDates(num);
			eval("document.formOngoIVPrescriptionMFR.validate"+num).style.visibility = 'hidden';
		}else{
			generateRow(obj,num);
			populateDate(parseFloat(num)+1,'add');
		}
	}
}

function validateCurrentRow(rowNum){
	formObj			= document.formOngoIVPrescriptionMFR;
	var totFlowDurn = formObj.TotFlowDurn.value;
	var totDurnation = formObj.TotDuration.value;
	var ivType		= formObj.ivType.value;

	infVolume		= eval("document.formOngoIVPrescriptionMFR.InfVolume"+rowNum).value;
	infRate			= eval("document.formOngoIVPrescriptionMFR.InfRate"+rowNum).value;
	infOverHr		= eval("document.formOngoIVPrescriptionMFR.InfOverHr"+rowNum).value;
	infOverMin		= eval("document.formOngoIVPrescriptionMFR.InfOverMin"+rowNum).value;
	startDateTime	= eval("document.formOngoIVPrescriptionMFR.StartDateTime"+rowNum).value;
	endDateTime		= eval("document.formOngoIVPrescriptionMFR.EndDateTime"+rowNum).value;

	endDateTime_prev = "";
	if(rowNum>1)
		endDateTime_prev= eval("document.formOngoIVPrescriptionMFR.EndDateTime"+(rowNum-1)).value;

	infGapHr		= eval("document.formOngoIVPrescriptionMFR.InfGapHr"+rowNum).value;
	infGapMin		= eval("document.formOngoIVPrescriptionMFR.InfGapMin"+rowNum).value;
	infusion_over_insert_value =  eval("document.formOngoIVPrescriptionMFR.infusion_over_insert_value"+rowNum).value;
	
	if(infVolume == "" || parseFloat(infVolume)==0 || infRate == "" || parseFloat(infRate)==0 || ((infOverHr == "" || parseFloat(infOverHr)==0) && (infOverMin == "" || parseFloat(infOverMin)==0)) || startDateTime=="" ){
		alert(getMessage("FLOW_RATE_VALUE_CANT_BE_BLANK","PH")+" "+rowNum);
		return false;
	}
	setInfuseOverValue(rowNum);
	locale = document.formOngoIVPrescriptionMFR.locale.value;

	if(rowNum > 1 && !isBefore(endDateTime_prev,startDateTime, "DMYHM",locale)){
		alert(getMessage("FLOW_RATE_START_DATE_LESS_THAN_PREV_END_DATE","PH")+rowNum);
		return false;
	}
	
	if(infGapMin != "" && parseInt(infGapMin) > 59){
		alert(getMessage("INVALID_TIME_MINUTE","PH"));
		return false;
	}

	var totFlowDurnInMin = getInfuseOverInMin(totFlowDurn.substring(0,totFlowDurn.indexOf(":")),totFlowDurn.substring(totFlowDurn.indexOf(":")+1)); 
	var totFlowDurnHr = parseFloat(totFlowDurnInMin/60); 
	totFlowDurnHr =Math.round(totFlowDurnHr*100)/100;
	
	var totDurnMin = getInfuseOverInMin(totDurnation.substring(0,totDurnation.indexOf(":")),totDurnation.substring(totDurnation.indexOf(":")+1)); 
	var totDurnHr = parseFloat(totDurnMin/60); 
	totDurnHr =Math.round(totDurnHr*100)/100; 

/*	if(ivType == "ivd"){ //Commented for ML-MMOH-CRF-1222
		if(parseFloat(infusion_over_insert_value) > 24 ){
			alert(getMessage("INFUSE_OVER_CANNOT_GREATER","PH")+"  - Flow Rate="+rowNum);
			return false;
		}
		if (parseFloat(totFlowDurnHr) > 24 && flag){
			alert(getMessage("TOT_FLOW_DURN_CANNOT_EXCEED24","PH")+"  - Flow Rate="+rowNum);
			return false;
		}
	} */
	document.formOngoIVPrescriptionMFR.TotFlowDurnHrs.value = totFlowDurnHr;
	document.formOngoIVPrescriptionMFR.TotDurnHrs.value = totDurnHr;
	return true;
}

function reCalculateDates(num){
	frmObj	= document.formOngoIVPrescriptionMFR;
	tot_rec = document.formOngoIVPrescriptionMFR.noOfRows.value;
	for(i= parseFloat(num)+1; i<=tot_rec; i++){

		populateDate(i,'modify')		;
	}
}

function calcTotals(num){
	frmObj	= document.formOngoIVPrescriptionMFR;
	totInfVol = 0.0;
	totFlowDurn = 0.0;
	totDurn = 0.0;
	totGap = 0.0;
	for(i=1;i<=num;i++){
		if(eval("document.formOngoIVPrescriptionMFR.InfVolume"+i).value != "")
			totInfVol=totInfVol+parseFloat(eval("document.formOngoIVPrescriptionMFR.InfVolume"+i).value);

		if(eval("document.formOngoIVPrescriptionMFR.infusion_over_insert_value"+i).value != "")
			totFlowDurn=totFlowDurn+parseFloat(eval("document.formOngoIVPrescriptionMFR.infusion_over_insert_value"+i).value);

		if(i<num){
			if(eval("document.formOngoIVPrescriptionMFR.InfGapHr"+i).value != "" || eval("document.formOngoIVPrescriptionMFR.InfGapMin"+i).value != ""){
			temp = getInfuseOverInMin(eval("document.formOngoIVPrescriptionMFR.InfGapHr"+i).value,eval("document.formOngoIVPrescriptionMFR.InfGapMin"+i).value); 
			temp = parseFloat(temp); 
			
			}else
				temp = 0;
			totGap = totGap + temp;
		}
	}
	totGap = parseFloat(totGap/60); 
	totGap =Math.round(totGap*100)/100;

	totFlowDurn = Math.round(totFlowDurn*10000)/10000;
	totDurn = totFlowDurn+totGap;

	totFlowDurn = getHrsMinStr(totFlowDurn);

	totFlowDurnStr = (totFlowDurn.substring(1,totFlowDurn.indexOf("H")-1))+":"+(totFlowDurn.substring(totFlowDurn.indexOf("H")+4,totFlowDurn.indexOf("M")-1));

	totDurn = getHrsMinStr(totDurn);
	totDurnStr = (totDurn.substring(1,totDurn.indexOf("H")-1))+":"+(totDurn.substring(totDurn.indexOf("H")+4,totDurn.indexOf("M")-1));
	baseVolume=frmObj.baseVolume.value;
	frmObj.TotInfVolume.value = totInfVol;
	frmObj.TotFlowDurn.value = totFlowDurnStr;
	frmObj.TotDuration.value = totDurnStr;
	return true;
}

function generateRow(obj,num) {
	var cnt = 1;
	var tbl = document.getElementById('mfrTable');
	var rwid=obj.parentNode.parentNode.rowIndex+1;
	var row = tbl.insertRow(rwid);
	var noOfRows = document.formOngoIVPrescriptionMFR.noOfRows.value;
	noOfRows = parseInt(noOfRows)+1;
	document.formOngoIVPrescriptionMFR.noOfRows.value = noOfRows;
	var volUom = document.getElementById("InfVolUnit1").innerHTML;
	var classvalue="";		
	if (Number(noOfRows)%2 == 0)
		classvalue = "" ;
	else
		classvalue = "" ;
	var oCell = "";

	oCell = row.insertCell(0);
	oCell.className=classvalue;
	label = getLabel('ePH.FlowRate.label','PH');
	label = " "+noOfRows;
	oCell.innerHTML="<td class='label'>&nbsp;<font style='font-size:11'> "+label+"</font></td>";

	oCell = row.insertCell(1);
	oCell.className=classvalue;
	oCell.innerHTML="<td >&nbsp;<input type='text' name='InfVolume"+noOfRows+"' id='InfVolume"+noOfRows+"' class='number' maxlength='5' size='5' onKeyPress='return allowValidNumber(this,event,5,0);' onchange='showValidateGif("+noOfRows+")'><label id='InfVolUnit"+noOfRows+"'><font style='font-size:11'>"+volUom+"</font></label></td>";
	
	oCell = row.insertCell(2);
	oCell.className=classvalue;
	oCell.innerHTML="<td>&nbsp;<input type='text' name='InfRate"+noOfRows+"' id='InfRate"+noOfRows+"' class='number'  value=''  maxlength='7' size='7' onKeyPress='return allowValidNumber(this,event,6,2);' onblur='setInfuseOverValue("+noOfRows+");populateDate("+noOfRows+")' onchange='showValidateGif("+noOfRows+")'><label id='InfRateUnit"+noOfRows+"'><font style='font-size:11'>"+volUom+"</font>/</label> <select name='InfRateHrMin"+noOfRows+"' id='InfRateHrMin"+noOfRows+"' onChange='setInfuseOverValue("+noOfRows+");populateDate("+noOfRows+");showValidateGif("+noOfRows+")'><option value='H' selected>"+getLabel("Common.Hour(s).label","Common")+"</option><option value='M'>"+getLabel("Common.Minute(s).label","Common")+"</option></select></td>";

	oCell = row.insertCell(3);
	label = getLabel('ePH.hr(s).label','PH');
	oCell.className=classvalue;
	oCell.innerHTML="<td>&nbsp;<input type='text'  width='3%' class='number' size='1' maxlength='2' name='InfOverHr"+noOfRows+"' id='InfOverHr"+noOfRows+"' value=''  onKeyPress='return allowValidNumber(this,event,3,0);'  onBlur='checkHr("+noOfRows+");setInfuseRateValue("+noOfRows+");populateDate("+noOfRows+")' onchange='showValidateGif("+noOfRows+")'> <b>:</b> <input type='text'  width='3%' class='number' size='1' maxlength='2' name='InfOverMin"+noOfRows+"' id='InfOverMin"+noOfRows+"' value=''  onKeyPress='return allowValidNumber(this,event,3,0);'  onBlur='checkMin("+noOfRows+");setInfuseRateValue("+noOfRows+");populateDate("+noOfRows+")' onchange='showValidateGif("+noOfRows+")'><font style='font-size:11'>"+label+"</font><input type='hidden' name='infusion_over_insert_value"+noOfRows+"' id='infusion_over_insert_value"+noOfRows+"'></td>";
	
	oCell = row.insertCell(4);
	oCell.className=classvalue;
	oCell.innerHTML="<td class='label' >&nbsp;<input type='text' disabled name='StartDateTime"+noOfRows+"' id='StartDateTime"+noOfRows+"' size='14' maxlength='16' onblur='return validateDate("+noOfRows+");populateDate("+noOfRows+")' onchange='showValidateGif("+noOfRows+")'>&nbsp;<IMG src='../../eCommon/images/CommonCalendar.gif' id=Calendar disabled onclick='showCalendarLocal("+noOfRows+")' >&nbsp;<img src='../../eCommon/images/mandatory.gif' ></img></td>";
	
	oCell = row.insertCell(5);
	oCell.className=classvalue;
	oCell.innerHTML="<td class='label' >&nbsp;<input type='text' name='EndDateTime"+noOfRows+"' id='EndDateTime"+noOfRows+"' size='14' disabled></td>";
	
	oCell = row.insertCell(6);
	oCell.className=classvalue;
	oCell.innerHTML="<td class='label' >&nbsp;<input type='text' name='InfGapHr"+noOfRows+"' id='InfGapHr"+noOfRows+"'  width='3%' class='number' size='1' maxlength='2' value=''  onKeyPress='return allowValidNumber(this,event,3,0);'  onBlur='checkHrGap("+noOfRows+")' onchange='showValidateGif("+noOfRows+")'> <b>:</b> <input type='text' name='InfGapMin"+noOfRows+"' id='InfGapMin"+noOfRows+"'  width='3%' class='number' size='1' maxlength='2' value=''  onKeyPress='return allowValidNumber(this,event,3,0);'  onBlur='checkMinGap("+noOfRows+")' onchange='showValidateGif("+noOfRows+")'><font style='font-size:11'>"+label+"</font><input type='hidden' name='InfGapInHr"+noOfRows+"' id='InfGapInHr"+noOfRows+"'></td>";

	oCell = row.insertCell(7);
	label = getLabel('ePH.AdminRate.label','PH');
	oCell.className=classvalue;
	if(document.formOngoIVPrescriptionMFR.adminRateHidden.value == ""){
		oCell.innerHTML="<td class='label' >&nbsp;<a href onClick='adminRate("+noOfRows+")' onMouseOver='changeCursor(this);' id='adminrate"+noOfRows+"'><font style='font-size:11'>"+label+"</font></a> <img src='../../eCommon/images/enabled.gif'  onMouseOver='changeCursor(this)' onclick='addRow(this,"+noOfRows+")' id='validate"+noOfRows+"'><img src='../../eCommon/images/nolines_plus.gif'  onMouseOver='changeCursor(this)' onclick='addRow(this,"+noOfRows+")' id='add"+noOfRows+"'>	<img src='../../eCommon/images/disabled.gif'  onMouseOver='changeCursor(this)' onclick='deleteRow(this,"+noOfRows+")' id='del"+noOfRows+"'></td>";
	}else{
		oCell.innerHTML="<td class='label' >&nbsp; <img src='../../eCommon/images/enabled.gif'  onMouseOver='changeCursor(this)' onclick='addRow(this,"+noOfRows+")' id='validate"+noOfRows+"'><img src='../../eCommon/images/nolines_plus.gif'  onMouseOver='changeCursor(this)' onclick='addRow(this,"+noOfRows+")' id='add"+noOfRows+"'>	<img src='../../eCommon/images/disabled.gif'  onMouseOver='changeCursor(this)' onclick='deleteRow(this,"+noOfRows+")' id='del"+noOfRows+"'></td>";
	}
	eval("document.getElementById("validate")"+num).style.visibility = "hidden";
	eval("document.getElementById("add")"+num).style.visibility = "hidden";
	eval("document.getElementById("del")"+num).style.visibility = "hidden";
}

function showCalendarLocal(noOfRows){
	showCalendar("StartDateTime"+noOfRows,null,'hh:mm');
	eval("document.formOngoIVPrescriptionMFR.StartDateTime"+noOfRows).focus();
	return false;
}

function deleteRow(obj,num) {
	var tbl = document.getElementById('mfrTable');
	var rwid=obj.parentNode.parentNode.rowIndex;
	tbl.deleteRow(rwid);
	currentRow = parseInt(rwid)-1;
	document.formOngoIVPrescriptionMFR.noOfRows.value = currentRow;
	calcTotals(document.formOngoIVPrescriptionMFR.noOfRows.value);
	eval("document.getElementById("add")"+currentRow).style.visibility = "visible";
	if(currentRow != 1)
		eval("document.getElementById("del")"+currentRow).style.visibility = "visible";
}

function setInfuseOverValue(row){

	var formObj		= document.formOngoIVPrescriptionMFR;

	var infVol		= eval("formObj.InfVolume"+row).value;
	var InfRate		= eval("formObj.InfRate"+row).value;
	var InfRateHrMin= eval("formObj.InfRateHrMin"+row).value;
	var ivType		= formObj.ivType.value;

	if(InfRate !="" && infVol != ""){
		var unit = 	InfRateHrMin;
		if(InfRate!="" && parseFloat(InfRate)!=0) {
			if(unit == "H"){
				InfRate = infVol * 60/InfRate;
			}
			else{
				InfRate = infVol/InfRate;
			}
			InfRate = InfRate/60;
			InfRate = Math.round(InfRate*100)/100;
			
			HrsMinStr = getHrsMinStr(InfRate,"single");

			eval("formObj.infusion_over_insert_value"+row).value = InfRate;
		
			hrs = HrsMinStr.substring(1,HrsMinStr.indexOf("H")-1);
			min = HrsMinStr.substring(HrsMinStr.indexOf("H")+4,HrsMinStr.indexOf("M")-1);

			eval("formObj.InfOverHr"+row).value = Math.floor(hrs);
			eval("formObj.InfOverMin"+row).value = Math.floor(min);

		}else{
			alert(getMessage("PRES_IV_INF_RATE_NOT_BLANK","PH"));
		}
		
	}
}     

function setInfuseRateValue(row){
	admnFrmObj	=document.formOngoIVPrescriptionMFR;

	var InfOverHr		= eval("admnFrmObj.InfOverHr"+row).value==""?0:eval("admnFrmObj.InfOverHr"+row).value;
	var InfOverMin		= eval("admnFrmObj.InfOverMin"+row).value==""?0:eval("admnFrmObj.InfOverMin"+row).value;
	var volume			= eval("admnFrmObj.InfVolume"+row).value==""?0:eval("admnFrmObj.InfVolume"+row).value;
	var ivType			= admnFrmObj.ivType.value;
	var InfRateHrMin	= eval("admnFrmObj.InfRateHrMin"+row).value;

	InfOverMin = parseFloat(InfOverMin);
	var InfuseOverInMin = getInfuseOverInMin(InfOverHr,InfOverMin); 
	var InfuseOverInHr = parseFloat(InfuseOverInMin/60); 

	InfuseOverInHr =Math.round(InfuseOverInHr*10000)/10000;

	if(volume == "" || volume ==0){
		alert(getMessage("FLD_VOL_CANT_BLNK_ZERO","PH"));
		//fluidFrmObj.stock_value.focus(); //commented on 15/2/2010 for the incident number 19289(scripterror)
		//admnFrmObj.stock_value.focus();
		return false;
	}else if (InfuseOverInMin == 0){
		alert(getMessage("INFS_OVR_CANT_BLANK_ZERO","PH"));
		return false;
	}else{
		if(InfRateHrMin == "H")
			var infusion_value = (volume)/(InfuseOverInHr);
		else
			var infusion_value = (volume)/(InfuseOverInMin);

		eval("admnFrmObj.infusion_over_insert_value"+row).value = InfuseOverInHr;
		infusion_value = Math.round(infusion_value*100)/100;
		eval("admnFrmObj.InfRate"+row).value = infusion_value;
		
	}
}

function populateDate(rowNum,frm){
	var beanId		= document.formOngoIVPrescriptionMFR.beanId.value;
	var beanName	= document.formOngoIVPrescriptionMFR.beanName.value;
	var startDate	= eval("document.formOngoIVPrescriptionMFR.StartDateTime"+rowNum).value;
	var infusion_over_insert_value	= eval("document.formOngoIVPrescriptionMFR.infusion_over_insert_value"+rowNum).value;
	var durnUnit	= "H";
	var mode = 'MFR'
	if(frm == "add" || frm == "modify"){
		prevRow = rowNum-1;
		EndDatePrev	= eval("document.formOngoIVPrescriptionMFR.EndDateTime"+prevRow).value;
		InfGapHrPrev	= eval("document.formOngoIVPrescriptionMFR.InfGapHr"+prevRow).value;
		InfGapMinPrev	= eval("document.formOngoIVPrescriptionMFR.InfGapMin"+prevRow).value;
		InfGapHrPrev	= InfGapHrPrev==""?"0":InfGapHrPrev;
		InfGapMinPrev	= InfGapMinPrev==""?"0":InfGapMinPrev;
		InfGap = getInfuseOverInMin(InfGapHrPrev,InfGapMinPrev);
		InfGap = parseFloat(InfGap/60); 
		InfGap =Math.round(InfGap*100)/100;

		eval("document.formOngoIVPrescriptionMFR.InfGapInHr"+prevRow).value = InfGap;
		InfGap = getInfuseOverInMin(InfGapHrPrev,InfGapMinPrev);
		if(parseInt(InfGapHrPrev) == 0 && parseInt(InfGapMinPrev) == 0 )
			eval("document.formOngoIVPrescriptionMFR.StartDateTime"+rowNum).value = EndDatePrev;
		else{
			var qryString	= beanId+"&bean_name="+beanName+"&validate=POPULATEENDDATE1&start_date="+EndDatePrev+"&durn_value="+InfGap+"&durn_unit=M&mode=MFRStart"+"&rowNum="+rowNum;
			submitXML(qryString, "");
		}
	}
	if(frm == "modify"){
		startDate = eval("document.formOngoIVPrescriptionMFR.StartDateTime"+parseFloat(rowNum)).value;
		min=eval("document.formOngoIVPrescriptionMFR.InfOverMin"+rowNum).value;
		hr=eval("document.formOngoIVPrescriptionMFR.InfOverHr"+rowNum).value;
		infusionInMin = getInfuseOverInMin(hr,min);

		var qryString	= beanId+"&bean_name="+beanName+"&validate=POPULATEENDDATE1&start_date="+startDate+"&durn_value="+infusionInMin+"&durn_unit=M"+"&mode="+mode+"&rowNum="+parseFloat(rowNum);
		submitXML(qryString, "");		
	}
	else if(infusion_over_insert_value != ""){
		min=eval("document.formOngoIVPrescriptionMFR.InfOverMin"+rowNum).value;
		hr=eval("document.formOngoIVPrescriptionMFR.InfOverHr"+rowNum).value;
		infusionInMin = getInfuseOverInMin(hr,min);

		var qryString	= beanId+"&bean_name="+beanName+"&validate=POPULATEENDDATE1&start_date="+startDate+"&durn_value="+infusionInMin+"&durn_unit=M"+"&mode="+mode+"&rowNum="+rowNum;
		submitXML(qryString, "");		
	}
   
}

function setStartDate(startDate,rowNum){

	eval("document.formOngoIVPrescriptionMFR.StartDateTime"+rowNum).value = startDate;
}

function setEndDate(endDate,rowNum){
	if(endDate != "null")
		eval("document.formOngoIVPrescriptionMFR.EndDateTime"+rowNum).value = endDate;
	else
		eval("document.formOngoIVPrescriptionMFR.EndDateTime"+rowNum).value = "";
}

function showValidateGif(i){

	eval("document.formOngoIVPrescriptionMFR.validate"+i).style.visibility = 'visible';
}
function saveMFR(drug_code){

	num = document.formOngoIVPrescriptionMFR.noOfRows.value;
	notValidate = "N";
	if(parseInt(num) > 1){
		if(!calcTotals(num))
			return false;
	}else{
		alert(getMessage("MORE_THAN_ONE_FLOW_RATE_REQUIRED","PH"));
		return false;
	}
	for(i=1; i<=num; i++){
		if(eval("document.formOngoIVPrescriptionMFR.validate"+i).style.visibility == 'visible')
			notValidate ="Y";
	}
	if(notValidate == "Y"){
		alert(getMessage("CHANGES_TO_BE_SAVED","PH"));
		return false;
	}
	infVolume		= eval("document.formOngoIVPrescriptionMFR.InfVolume"+num).value;
	infRate			= eval("document.formOngoIVPrescriptionMFR.InfRate"+num).value;
	infOverHr		= eval("document.formOngoIVPrescriptionMFR.InfOverHr"+num).value;
	infOverMin		= eval("document.formOngoIVPrescriptionMFR.InfOverMin"+num).value;
	startDateTime	= eval("document.formOngoIVPrescriptionMFR.StartDateTime"+num).value;
	endDateTime		= eval("document.formOngoIVPrescriptionMFR.EndDateTime"+num).value;

	totFlowDurnHrs = document.formOngoIVPrescriptionMFR.TotFlowDurnHrs.value;
	totDurnHrs = document.formOngoIVPrescriptionMFR.TotDurnHrs.value;

	if((infVolume == "" || parseFloat(infVolume)==0) && (infRate == "" || parseFloat(infRate)==0) && ((infOverHr == "" || parseFloat(infOverHr)==0) && (infOverMin == "" || parseFloat(infOverMin)==0)) && startDateTime=="" ){
		num = num -1;
		document.formOngoIVPrescriptionMFR.noOfRows.value = num;
	}

	for(i=1; i<=num; i++){
		valid = validateCurrentRow(i);
		if (!valid)
		{
			break;
		}
	}
	if(valid){
		beanId			= document.formOngoIVPrescriptionMFR.beanId.value;
		beanName		= document.formOngoIVPrescriptionMFR.beanName.value;
		patient_id		= document.formOngoIVPrescriptionMFR.patient_id.value;
		encounter_id	= document.formOngoIVPrescriptionMFR.encounter_id.value;
//		totDurnHrs		= document.formOngoIVPrescriptionMFR.TotDurnHrs.value;
		flowStartDate	= document.formOngoIVPrescriptionMFR.StartDateTime1.value;
		ivType			= document.formOngoIVPrescriptionMFR.ivType.value;
		ocurrance_num	= document.formOngoIVPrescriptionMFR.ocurrance_num.value;
		flowEndDate		= eval("document.formOngoIVPrescriptionMFR.EndDateTime"+num).value;

		var xmlStr		= "<root><SEARCH " + buildXMLString(document.formOngoIVPrescriptionMFR) + " /></root>";

			var qryString	= beanId+"&bean_name="+beanName+"&validate=SAVE_MFR&patient_id="+patient_id+"&encounter_id="+encounter_id+"&flowStartDate="+flowStartDate+"&flowEndDate="+flowEndDate+"&drug_code="+drug_code+"&srlNo="+ocurrance_num;;

		submitXML(qryString, xmlStr);
		

		var retval= new Array();
		retval[0] = document.formOngoIVPrescriptionMFR.TotInfVolume.value;
		retval[1] = num;
		retval[2] = document.formOngoIVPrescriptionMFR.StartDateTime1.value;
		retval[3] = eval("document.formOngoIVPrescriptionMFR.EndDateTime"+num).value;

		window.returnValue=retval;
		window.close();
	}
}
async function showMultipleFlowRateOnco(patient_id,bean_id,bean_name,infusion_rate_uom,order_id,drug_code,srlNo){


	var dialogTop		= "";
 	var dialogHeight	= "40vh";
 	var dialogWidth		= "65vw";
	var dialogLeft		= "180";
 	var features		= "Width:" + dialogWidth + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogLeft:" + dialogLeft +"; dialogTop:" + dialogTop +"; scroll=no; status=no";
	
 	var arguments		= "";
 	var retVal 			= await window.showModalDialog("../jsp/OncologyPrescriptionMFRView.jsp?patient_id="+patient_id+"&bean_id="+bean_id+"&bean_name="+bean_name+"&infusion_rate_uom="+infusion_rate_uom+"&order_id="+order_id+"&drug_code="+drug_code+"&srlNo="+srlNo,arguments,features);
 }


function buildXMLString(frmObj) {
	var xmlStr = "";
	var arrObj = frmObj.elements;
	var frmObjs = new Array()
	if(frmObj.name == null)
		frmObjs = frmObj;
	else frmObjs[0] = frmObj;


	for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
		frmObj = frmObjs[frmCount]
		var arrObj = frmObj.elements;

		for(var i=0;i<arrObj.length;i++) {
			var val = "";
			if(arrObj[i].type == "checkbox") {
				if(arrObj[i].checked) 
					val = "Y";
				else 
					val ="N";
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" ";
			}
			else if(arrObj[i].type == "radio") {
				if(arrObj[i].checked) {
					val = arrObj[i].value;
					if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" ";
				}
			}
			else if(arrObj[i].type == "select-multiple") {
				for(var j=0; j<arrObj[i].options.length; j++) {
					if(arrObj[i].options[j].selected)
						val+=arrObj[i].options[j].value +"~"
				}
				val= val.substringing(0,val.lastIndexOf('~'))
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" ";
			}
			else {
				val = arrObj[i].value;
				if(arrObj[i].value == null) arrObj[i].value = "";
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" ";
			}
		}
	}
	return xmlStr;
}

function submitXML(qryString, xmlStr,eval_yn) {

//commented by Anbarasi
	//var xmlDoc	= new ActiveXObject("Microsoft.XMLDom");
	//var xmlHttp	= new ActiveXObject("Microsoft.XMLHTTP");
	var xmlDoc = ""; 
	var xmlHttp = new XMLHttpRequest();

	if (xmlStr != "")
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open("POST", "OncologyRegimenValidate.jsp?bean_id="+qryString, false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;

	eval(responseText);
}

function getHrsMinStr(HMvalue,display){
	//alert("Original hmvalue="+HMvalue);
	hrs = Math.floor(HMvalue);
	//alert("hmvalue after floor()="+hrs);
	HMvalue = HMvalue * 60;
	//alert("1="+HMvalue);
	min = HMvalue % 60;
	//alert("minutes before round up"+min);
	min = Math.round(min);
	if(display != "single"){
		if(hrs <= 9)
			hrs = "0"+hrs;
		if(min<=9)
			min = "0"+min;
	}
	return( '['+hrs + ' Hrs ' + min + ' Mins]' );
 }
 
 function getInfuseOverInMin(hr, mi){
	if(hr == "")
		hr = 0;
	if(mi == "")
		mi = 0;
	tot = parseFloat(hr*60)+parseFloat(mi);
	return tot;
 }

function calculateViewValues(formObj,tot_volume,tot_flow_durn,tot_gap,tot_durn,n,tot_flow_durn,infusion_vol_str_unit_desc){
	//document.getElementById("TotInfVolUnit").innerHTML = tot_volume+" "+volumeUom;
	document.getElementById("TotInfVolUnit").innerHTML = tot_volume+" "+infusion_vol_str_unit_desc;	   //volumeUom is replaced by infusion_vol_str_unit_desc to this function for SKR-SCF-215.1

	tot_flow_durn = getHrsMinStr(tot_flow_durn);

	tot_flow_durnStr = (tot_flow_durn.substring(1,tot_flow_durn.indexOf("H")-1))+":"+(tot_flow_durn.substring(tot_flow_durn.indexOf("H")+4,tot_flow_durn.indexOf("M")-1));
	document.getElementById("TotFlowDurn").innerHTML = tot_flow_durnStr;

	tot_durn = getHrsMinStr(tot_durn);
	tot_durnStr = (tot_durn.substring(1,tot_durn.indexOf("H")-1))+":"+(tot_durn.substring(tot_durn.indexOf("H")+4,tot_durn.indexOf("M")-1));
	document.getElementById("TotDuration").innerHTML = tot_durnStr;
	for(i=0;i<n;i++){
		inf_over = eval("formObj.InfOverInHrs"+i).value;
		inf_over = getHrsMinStr(inf_over);
		inf_overStr = (inf_over.substring(1,inf_over.indexOf("H")-1))+":"+(inf_over.substring(inf_over.indexOf("H")+4,inf_over.indexOf("M")-1));
		eval("document.getElementById("InfOver")"+i).innerHTML = inf_overStr;

		inf_gap = eval("formObj.InfGapInHrs"+i).value;
		inf_gap = getHrsMinStr(inf_gap);
		inf_gapStr = (inf_gap.substring(1,inf_gap.indexOf("H")-1))+":"+(inf_gap.substring(inf_gap.indexOf("H")+4,inf_gap.indexOf("M")-1));
		eval("document.getElementById("InfGap")"+i).innerHTML = inf_gapStr;

	}
}

function validateDate(num){
	startDateTime	= eval("document.formOngoIVPrescriptionMFR.StartDateTime"+num).value;
	if(startDateTime == ""){
		alert(getMessage("INVALID_DATE_TIME",'PH'));
		return false;
	}else{
		if(validDate(startDateTime, "DMYHM",document.formOngoIVPrescriptionMFR.locale.value)){
			if(chkSingleDigitForHrsMinFormat(startDateTime, "DMYHM"))
			{
				 alert(getMessage("INVALID_DATE_TIME",'PH'));
				 eval("document.formOngoIVPrescriptionMFR.StartDateTime"+num).focus();
				 return false;
			}
			populateDate(num);
			return true;
		}
		else{
		   alert(getMessage("INVALID_DATE_TIME",'PH'));
		   eval("document.formOngoIVPrescriptionMFR.StartDateTime"+num).focus();
		   return false;
		  }
	}
}

function chkSingleDigitForHrsMinFormat(date,format)
{
	if(format!="DMYHM")
	{
		return false;
	}
	else
	{
		 var dttime = date.split(" ");
		 var time="";
		 if(dttime.length>1)
		 {
			time=dttime[1];
			if(time!=null || time!="")
			{
				var time1arr=new Array();
				time1arr=time.split(":");
				if(time1arr.length>1)
				{
					 hr=time1arr[0];
					 min=time1arr[1];
					 if((hr.length<2) || (min.length<2))					 
						return true;
					 else
						return false;
					 
				}
				else
				{
					 return false;
				}				 
			}     
			else
			{
				return false;
			}
		 }
		 else 
		 {
			 return false;
		 }
	}
}

