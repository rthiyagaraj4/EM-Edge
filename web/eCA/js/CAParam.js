/*
---------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        		Rev.Date		Rev.Name 		Description
---------------------------------------------------------------------------------------------------------------
11/11/2015	IN057113			Karthi L							 			ML-MMOH-CRF-0335 - IN057113
28/07/2016	IN052053			Krishna Gowtham									AAKH-CRF-0062
13/07/2016	IN061885			Krishna Gowtham	13/07/2017		Ramesh G		      ML-MMOH-CRF-0537
01/11/2018  	IN063285      prathyusha                                      ML-MMOH-CRF-0757
22/01/2018  	IN062606      Sharanraj          01/02/2013 Ramesh G          ML-MMOH-CRF-0726
15/03/2018	IN066119	Raja S			15/03/2018		Ramesh G		ML-MMOH-CRF-1024
08/05/2018	IN066237   	Prakash C 		08/05/2018		Ramesh G		MMS-DM-CRF-0123
10/05/2018 IN065341             Sivabagyam M        10/05/2018  	Ramesh G        MMS-DM-CRF-0115
11/03/2019	IN069852			Raja S				11/03/2019  Ramesh G			JD-CRF-0206
9/03/2019		IN069244		SIVABAGYAM M			11/03/2019  Ramesh G		MMS-KH-CRF-0005.1

07/04/2019	IN070032	sivabagyam M 	07/04/2019		Ramesh G		MO-CRF-20101.6
29/01/2020  IN069384	SIVABAGYAM	M	29/01/2020		RAMESH G		AAKH-CRF-0097.1
12/02/2021	6451		SIVABAGYAM M		12/02/2021	RAMESH G	GHL-CRF-0623
02/06/2022	31884		Ramesh Goli			02/06/2022	Ramesh G 	MMS=DM-CRF-0208
28/10/2022  37743       SREENADH M      31/10/2022      Ramesh G        ML-MMOH-CRF-1654
26/05/2023  37743       RANJITH P R      29/05/2023      RAMESH G       AAKH-CRF-0164
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/


function apply() {
	var assign_chk_val = f_query_add_mod.document.ca_param_form.conf_pin_req_yn.checked;
	var site = f_query_add_mod.document.ca_param_form.site.value;
	var finacial_dtl_req_yn=false;
	if(site == true){
	finacial_dtl_req_yn = f_query_add_mod.document.ca_param_form.finacial_dtl_req_yn.checked;
	}
	if(assign_chk_val){
		f_query_add_mod.document.ca_param_form.conf_pin_req_yn.value = "Y";
	}
	else {
		f_query_add_mod.document.ca_param_form.conf_pin_req_yn.value = "N";
	}
	//added for IN063285 start
	if(site  == true){
		if(finacial_dtl_req_yn){
			f_query_add_mod.document.ca_param_form.finacial_dtl_req_yn.value = "Y";
			
		}
		else {
			f_query_add_mod.document.ca_param_form.finacial_dtl_req_yn.value = "N";
		}
	}
	//added for IN063285 end
	// f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
	// f_query_add_mod.document.forms[0].target="messageFrame";
	f_query_add_mod.document.ca_param_form.submit();
}
function reset() {
	//f_query_add_mod.document.forms[0].reset();
	f_query_add_mod.location.reload();
	if(f_query_add_mod.document.getElementById("ackVitals_SiteFlag").value!="false"){// Added site specific condition
	ackThirdPartyVital();//IN069384
	}
}
//IN069384 STARTS
function ackThirdPartyVital(){
	if(f_query_add_mod.document.getElementById("ackVitals_SiteFlag").value){
		if(f_query_add_mod.document.getElementById("ackThirdPartyVitals").checked){
			f_query_add_mod.document.getElementById("thirdpartdata").style="display";	
			f_query_add_mod.document.getElementById("titleTable").disabled =false; //32411
			f_query_add_mod.document.getElementById("ackThirdPartyVitals").value="Y";
		}
		else{
			f_query_add_mod.document.getElementById("thirdpartdata").style.display='none';
			f_query_add_mod.document.getElementById("titleTable").disabled =true; //32411
			f_query_add_mod.document.getElementById("ackThirdPartyVitals").value="N";
		}
		
	}
}
//IN069384 ENDS
function onSuccess() 
{
	f_query_add_mod.location.reload();
}
function assignVal(obj){
	var chk = obj.checked;
	if(chk){
		document.ca_param_form.conf_pin_req_yn.value = "Y";
	}else{
		document.ca_param_form.conf_pin_req_yn.value = "N";
	}
}
//IN069852 starts
function checkVitals(obj){
	var chk = obj.checked;
	if(chk){
		
		document.ca_param_form.ackThirdPartyVitals.value = "Y";
		document.getElementById("thirdpartdata").style='display';//IN069384
		}
	else
	{
		document.ca_param_form.ackThirdPartyVitals.value = "N";
		document.getElementById("thirdpartdata").style.display='none';//IN069384
		
		
	}
}

	
//IN069852 ends
//IN052053 Start
function validateMinMaxTime()
{
		var minmaxtimeallowed = document.getElementById("sum_menu_auto_ref").value;	
		var minmaxtimeforselfnotes = document.getElementById("self_note_auto_ref").value;//IN066237	
		if(minmaxtimeallowed < 1)
		{
			alert(getMessage("CA_MIN_MAX_TIME_AUTO_REFRESH",'CA'));
			document.getElementById("sum_menu_auto_ref").select();
			document.getElementById("sum_menu_auto_ref").focus();
		}
	//IN066237 starts
		if(minmaxtimeforselfnotes !="")
		{
			if(minmaxtimeforselfnotes < 1)
			{
				alert(getMessage("CA_MIN_MAX_TIME_AUTO_REFRESH",'CA'));
				document.getElementById("self_note_auto_ref").select();
				document.getElementById("self_note_auto_ref").focus();
			}	
		}
	//IN066237 ends	
}
function CheckForNums(event){
    var strCheck = '0123456789';
	var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);
	if (strCheck.indexOf(key) == -1) return false;
	return true ;	
}
//IN052053 End
//IN061885 Start
function validateMinMaxDays()
{
		var minmaxtimeallowed = document.getElementById("pend_dis_summ_grace_period").value;	
		var minmaxtime =document.getElementById("central_default_days").value;//IN065341
		if(minmaxtimeallowed < 1)
		{
			alert(getMessage("CA_MIN_MAX_DAYS_GRACE_PERIOD",'CA'));
			document.getElementById("pend_dis_summ_grace_period").select();
			document.getElementById("pend_dis_summ_grace_period").focus();
		}//IN065341--starts
		if(minmaxtime< 1)
		{
			alert(getMessage("CA_CNETRALISED_DEFAULT_DAYS",'CA'));
			document.getElementById("central_default_days").select();
			document.getElementById("central_default_days").focus();
		}//IN065341--ends
}
function CheckForNumsDays(event){
    var strCheck = '123456789';
	var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);
	if (strCheck.indexOf(key) == -1) return false;
	return true ;	
}	
//IN061885 End

//added for IN063285 start
function assignValForFinacialChk(obj){
	var chk = obj.checked;
	if(chk){
		document.ca_param_form.finacial_dtl_req_yn.value = "Y";
	}else{
		document.ca_param_form.finacial_dtl_req_yn.value = "N";
	}
}
//added for IN063285 end

//IN062606 Starts
function CheckForNumsHours(event){
    var strCheck = '0123456789';
	var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);
	if (strCheck.indexOf(key) == -1) return false;
	return true ;	
}

function validateMinMaxHours()
{
	var minmaxtimeallowed = document.getElementById("Time_frm_durn").value;	
	if(minmaxtimeallowed < 0 || minmaxtimeallowed >=24 || minmaxtimeallowed=="")
	{
		alert(getMessage("CA_MIN_MAX_HOURS_DURATION",'CA'));
		document.getElementById("Time_frm_durn").select();
		document.getElementById("Time_frm_durn").focus();
	}
	/*ML-MMOH-CRF-0726 starts*/
	if(isNaN(minmaxtimeallowed))
	{
		alert(getMessage("NUM_ALLOWED",'CA'));
		document.getElementById("Time_frm_durn").select();
		document.getElementById("Time_frm_durn").focus();
	}	
	/*ML-MMOH-CRF-0726 ends*/
}
// IN062606 Ends



//ADDED FOR IN066119 START
function clinicalEventHistory(obj){
	document.ca_param_form.cln_hist_default_mode.value=obj.value;
}
//ADDED FOR IN066119 END

//IN070032 starts
function specimenWise(obj){
	document.ca_param_form.specimen_wise.value=obj.value;
}
//IN070032 ends
//IN069244 starts
async function callFunctionChart(target_id,target)
{
	target.value="";
		var retVal		   = new String();
		var argumentArray  = new Array(7); 
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var sql = "";
		sql="Select CHART_ID code, LONG_DESC description from ca_chart where eff_status='E' and upper(CHART_ID) like  upper(?) and upper(LONG_DESC) like upper(?) order by 2";
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] =DESC_LINK ;
		argumentArray[7] =CODE_DESC;
		var retVal = await CommonLookup( getLabel("Common.Chart.label","Common"), argumentArray );
		var str =unescape(retVal);
		var arr = str.split(",");
		if(retVal != null && retVal != "" )
			{
				target_id.value = arr[0] ; /* if code need to be returned */
				target.value =arr[1]; /* if desc need to be returned */
				
			}
		else
			{
				target.value="";
				target_id.value="";
			}
	}
// 69244 ends

//IN069384 starts
function thirdPartyData(obj){
	
	document.ca_param_form.third_party_vitals_view.value=obj.value;
}
//IN069384 ends
//6451
function hiding(obj){
	if(obj.checked)
	document.getElementById("bed_hide").value="Y";
	else
		document.getElementById("bed_hide").value="N";
		
}
//6451
//31884 Start.
function supInacPayClick(obj){
	if(obj.checked)
		document.getElementById("suspInacPatYN").value="Y";
	else
		document.getElementById("suspInacPatYN").value="N";
		
}
//31884 End.

// 37743 STARTS
function chComplntDetlsClick(obj)
{
	if(obj.checked){
		document.getElementById("chiefComplaintMandYN").value="Y";
	}
	else
		document.getElementById("chiefComplaintMandYN").value="N";
}
function chComplntRemarksClick(obj)
{
	if(obj.checked){
		document.getElementById("chiefRemarksYN").value="Y";
	}
	else
		document.getElementById("chiefRemarksYN").value="N";
}
//37743 ENDS

//32411 Start.
function ackthirdpartyvitalsDC_YNClick(obj)
{
	if(obj.checked){
		
		document.getElementById("ackthirdpartyvitalsDC_YN").value="Y";
	}
	else{
		document.getElementById("ackthirdpartyvitalsDC_YN").value="N";
		document.getElementById('selectAll').checked=false;
	}
}
function ackthirdpartyvitalsEM_YNClick(obj)
{
	if(obj.checked){
		document.getElementById("ackthirdpartyvitalsEM_YN").value="Y";
	}
	else{
		document.getElementById("ackthirdpartyvitalsEM_YN").value="N";
		document.getElementById('selectAll').checked=false;
	}
}
function ackthirdpartyvitalsIP_YNClick(obj)
{
	if(obj.checked){
		document.getElementById("ackthirdpartyvitalsIP_YN").value="Y";
	}
	else{
		document.getElementById("ackthirdpartyvitalsIP_YN").value="N";
		document.getElementById('selectAll').checked=false;
	}
}
function ackthirdpartyvitalsOP_YNClick(obj)
{
	if(obj.checked){
		document.getElementById("ackthirdpartyvitalsOP_YN").value="Y";
	}
	else{
		document.getElementById("ackthirdpartyvitalsOP_YN").value="N";
		document.getElementById('selectAll').checked=false;
	}
}

function checkAllVal(){
	

	var result=true;
	if(!(document.getElementById('thirdpartyvitalsDC').checked)){
		result=false;
		return;		
	}
	if(!(document.getElementById('thirdpartyvitalsEM').checked)){
		result=false;
		return;		
	}
	if(!(document.getElementById('thirdpartyvitalsIP').checked)){
		result=false;
		return;		
	}
	if(!(document.getElementById('thirdpartyvitalsOP').checked)){
		result=false;
		return;		
	}
	
	if(result)
		document.getElementById('selectAll').checked=true;
	else
		document.getElementById('selectAll').checked=false;
		
}

function checkAll() {
	var selectAll = document.getElementById('selectAll').checked;
	
	 if(selectAll){
		document.getElementById('thirdpartyvitalsDC').checked = true;
		document.getElementById("ackthirdpartyvitalsDC_YN").value="Y";
		document.getElementById('thirdpartyvitalsEM').checked = true;
		document.getElementById("ackthirdpartyvitalsEM_YN").value="Y";
		document.getElementById('thirdpartyvitalsIP').checked = true;
		document.getElementById("ackthirdpartyvitalsIP_YN").value="Y";
		document.getElementById('thirdpartyvitalsOP').checked = true;
		document.getElementById("ackthirdpartyvitalsOP_YN").value="Y";
	
	}
	else{
		document.getElementById('thirdpartyvitalsDC').checked = false;
		document.getElementById("ackthirdpartyvitalsDC_YN").value="N";
		document.getElementById('thirdpartyvitalsEM').checked = false;
		document.getElementById("ackthirdpartyvitalsEM_YN").value="N";
		document.getElementById('thirdpartyvitalsIP').checked = false;
		document.getElementById("ackthirdpartyvitalsIP_YN").value="N";
		document.getElementById('thirdpartyvitalsOP').checked = false;
		document.getElementById("ackthirdpartyvitalsOP_YN").value="N";
	}
}

function PatientsTable(obj)
{   
    var titleTable= document.getElementById("titleTable");
    var chk = obj.checked;
	if(chk){
		document.ca_param_form.ackThirdPartyVitals.value = "Y";
		titleTable.disabled = false;
		document.getElementById('selectAll').checked=true;
		checkAll();
	}
	else{
		document.ca_param_form.ackThirdPartyVitals.value = "N";
		document.getElementById('selectAll').checked=false;
		checkAll();
		titleTable.disabled = true;
		
	}
	
	
}
//32411 Ends. 
