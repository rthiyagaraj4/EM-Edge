/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
12/08/2011	  IN027165		 Chowminya		Incident No: IN027165 - <Future order linked orders reschedule - started date update issue> 										
---------------------------------------------------------------------------------------------------------------
*/

function callDisplayOAResultsblock(date)
{
 alert(getMessage("SCHEDULE_BLOCK","OA")+" " +date);
}

function callDisplayOAResultsForOp(clinic, mon, yr,dt,colorclass){
	if(mon.length==1)
			mon="0"+mon
	if(dt.length==1)
			dt="0"+dt
	var dt=dt+"/"+mon+"/"+yr;
	var i_appt_ref_no=document.forms[0].apptrefno.value;
	var overbook1 = "N";
	if (colorclass=="OAYellow")overbook1="Y";
	var i_clinic_code=document.forms[0].clinic_code.value;
	var i_practitioner_id=document.forms[0].practitioner_id.value;
	var i_appt_date=document.forms[0].old_date.value;
	var new_appt_date=dt;
	var old_alcn_catg_code=document.forms[0].old_alcn_catg_code.value;
	var alcn_criteria=document.forms[0].alcn_criteria.value;
	var tfr_appt_across_catg_yn=document.forms[0].tfr_appt_across_catg_yn.value;
	var over_booked=document.forms[0].over_booked.value;
	var obook_appt_yn=document.forms[0].obook_appt_yn.value;			
	var team_id=document.forms[0].team_id.value;
	var Forced=document.forms[0].Forced.value;
	var res_type=document.forms[0].res_type.value;
	var clinic_type=document.forms[0].clinic_type.value;
	var visit_limit_rule=document.forms[0].visit_limit_rule.value;
	var slot_appt_ctrl=document.forms[0].slot_appt_ctrl.value;
	var old_visit_type_ind1=document.forms[0].old_visit_type_ind1.value;
	var old_alcn_catg_code1=document.forms[0].old_alcn_catg_code1.value;
	var no_of_slots_value1=document.forms[0].no_of_slots_value1.value;
	var patient_id1=document.forms[0].patient_id1.value;
	var old_pract_id1=document.forms[0].old_pract_id1.value;
	var old_clinic_code=document.forms[0].old_clinic_code.value; /*added by S.Sathish for IN019815 on Monday, March 15, 2010*/
	var order_id=document.forms[0].order_id.value; //--[IN027165]--

	var param_details="../../eOA/jsp/DisplayApptDetails.jsp?tfr_appt_across_catg_yn="+tfr_appt_across_catg_yn+"&old_alcn_catg_code="+old_alcn_catg_code+"&alcn_criteria="+alcn_criteria+"&i_appt_ref_no="+i_appt_ref_no+"&i_appt_ref_no="+i_appt_ref_no+"&i_clinic_code="+i_clinic_code+"&overbook1="+overbook1+"&i_practitioner_id="+i_practitioner_id+"&obook_appt_yn="+obook_appt_yn+"&over_booked="+over_booked+"&i_appt_date="+i_appt_date+"&new_appt_date="+new_appt_date+"&clinic_type="+clinic_type+"&res_type="+res_type+"&Forced="+Forced+"&visit_limit_rule="+visit_limit_rule+"&slot_appt_ctrl="+slot_appt_ctrl+"&old_visit_type_ind1="+old_visit_type_ind1+"&old_alcn_catg_code1="+old_alcn_catg_code1+"&no_of_slots_value1="+no_of_slots_value1+"&patient_id1="+patient_id1+"&old_pract_id1="+old_pract_id1+"&old_clinic_code="+old_clinic_code;
	var param="../../eOA/jsp/DisplayOAResultsForTransfer.jsp?tfr_appt_across_catg_yn="+tfr_appt_across_catg_yn+"&old_alcn_catg_code="+old_alcn_catg_code+"&alcn_criteria="+alcn_criteria+"&i_appt_ref_no="+i_appt_ref_no+"&i_clinic_code="+i_clinic_code+"&i_practitioner_id="+i_practitioner_id+"&obook_appt_yn="+obook_appt_yn+"&over_booked="+over_booked+"&i_team_id="+team_id+"&overbook1="+overbook1+"&i_appt_date="+i_appt_date+"&new_appt_date="+new_appt_date+"&clinic_type="+clinic_type+"&res_type="+res_type+"&Forced="+Forced+"&visit_limit_rule="+visit_limit_rule+"&slot_appt_ctrl="+slot_appt_ctrl+"&old_visit_type_ind1="+old_visit_type_ind1+"&old_alcn_catg_code1="+old_alcn_catg_code1+"&no_of_slots_value1="+no_of_slots_value1+"&patient_id1="+patient_id1+"&old_pract_id1="+old_pract_id1+"&old_clinic_code="+old_clinic_code+"&order_id="+order_id; //Modified --[IN027165]
	parent.appt_details.location.href=param_details;
	parent.DispOAResult.location.href=param;

}


async function show_Reference_details(appt_no2,fac_id2)
{
var dialogHeight= "23" ;
var dialogWidth	= "54" ;
var dialogTop = "190" ;
var center = "1" ;
var status="no";
var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
var arguments	= "" ;
await window.showModalDialog("../../eOA/jsp/SecApptReferenceFrame.jsp?appt_no2="+appt_no2+"&fac_id2="+fac_id2,arguments,features);
}

var u1;

function row(Obj)
{
	u1=Obj.rowIndex;
}

async function callBookAppointmentDetails(from_time,to_time){//calling transfer appointment frame

	/* Added for ML-BRU-CRF-0628.1 */
	ext_slot=document.forms[0].p_o_ext_slot_status.value;
	var s_arr=ext_slot.split("|");
	if (s_arr[u1-1] =='Y') {
		var error;
		error=getMessage("BRU_HEALTH_SLOT_SELECTED","OA");
		error=error.replace("Book", getLabel("Common.Reschedule.label","Common"))
		alert(error);

	}else{

	var sys_date=document.forms[0].sys_date.value;
	var sys_time=document.forms[0].sys_time.value;
	var appt_date=document.forms[0].appt_date.value;
	var systotime=sys_time.split(":");
	var tosystime=new Date(1,1,1,systotime[0],systotime[1],0,0);
	var apptfromtime=from_time.split(":");
	var appttotime=to_time.split(":");

	if(appttotime == "00,00")
	{
		appttotime[0] = "23";
		appttotime[1] = "59";
	}

	var fromappttime=new Date(1,1,1,apptfromtime[0],apptfromtime[1],0,0);
	var toappttime=new Date(1,1,1,appttotime[0],appttotime[1],0,0);
	var tfr_allowed = "N";
	
	if(compare_date(sys_date,appt_date)){		
		tfr_allowed = "Y";
	}else{
		if(compareDateEqual(appt_date,appt_date,sys_date)){
			if(toappttime<tosystime){
				tfr_allowed = "N";
				alert(getMessage('TRANS_TIME_IS_LESS_SYSTIME','OA'));
			}else{
				tfr_allowed = "Y";
			}
		}else{
			tfr_allowed = "N";
		}
	}
	if(tfr_allowed == "Y"){
		var appt_ref_no=document.forms[0].appt_ref_no.value;
		
		var clinic_code=document.forms[0].clinic_code.value;
		var pract_id=document.forms[0].pract_id.value;
		var appt_date=document.forms[0].appt_date.value;
		var old_date=document.forms[0].old_date.value;
		var overbooked_yn=document.forms[0].overbooked_yn.value;
		var over_booked=document.forms[0].over_booked.value;
		var team_id="";
		if (parent.frames[0].document.forms[0].team_id)
			team_id=parent.frames[0].document.forms[0].team_id.value;
		var no_of_slots_value=document.forms[0].no_of_slots_value.value;
		var patient_id=document.forms[0].patient_id.value;
		var p_o_time_tab_type=document.forms[0].P_O_TIME_TAB_TYPE.value;
		var new_day=document.forms[0].new_day.value;
		var res_type=document.forms[0].res_type.value;
		var clinic_type=document.forms[0].clinic_type.value;
		var alcn_criteria=document.forms[0].alcn_criteria.value;
		var sys_date=document.forms[0].sys_date.value;	
		var order_id=document.forms[0].order_id.value; //--[IN027165]--
	
		var retVal = 	new String();
		var dialogHeight= "85vh" ;
		var dialogTop = "0" ;
		var dialogWidth	= "85vw" ;
		var center = "1" ;
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		var call_transfer_flag="Y";
		var visit_type_ind = parent.apptdairy.document.forms[0].old_visit_type_ind1.value;
		var slot_appt_ctrl = parent.apptdairy.document.forms[0].slot_appt_ctrl.value;
		var from_appt_date = parent.apptdairy.document.forms[0].old_date.value;
		var from_practitioner_id = parent.apptdairy.document.forms[0].practitioner_id.value;
		var from_clinic_code= parent.apptdairy.document.forms[0].clinic_code.value;
		if (parseInt(no_of_slots_value)>0){
			var xmlDoc = ""
			var xmlHttp = new XMLHttpRequest()
			xmlStr ="<root><SEARCH clinic_code=\""+clinic_code+"\" practitioner_id=\""+pract_id+"\" fromTime=\""+from_time+"\" no_of_slots=\""+no_of_slots_value+"\"  toTime=\""+to_time+"\" clinic_date=\""+appt_date+"\" visit_type_ind=\""+visit_type_ind+"\" appt_ref_no=\""+appt_ref_no+"\" slot_appt_ctrl= \""+slot_appt_ctrl+"\" from_appt_date =\""+from_appt_date+"\" from_clinic_code =\""+from_clinic_code+"\" from_practitioner_id =\""+from_practitioner_id+"\" alcn_criteria=\""+alcn_criteria+"\" res_type=\""+res_type+"\" clinic_type=\""+clinic_type+"\"  steps='1' calling_from='TRANSFER' /></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","VisitValidation.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			responseText = trimString(responseText)
			eval(responseText) 
			if (responseText.length==2)
				call_transfer_flag="Y";
			else call_transfer_flag="N";
		}
        if (parseInt(no_of_slots_value)<0 || call_transfer_flag=="Y"){
			if (patient_id==""){
				var Forced=document.forms[0].Forced.value;
				retVal = await top.window.showModalDialog("../../eOA/jsp/TransferAppointmentDetailsFrame.jsp?i_appt_ref_no="+appt_ref_no+"&i_clinic_code="+clinic_code+"&i_practitioner_id="+pract_id+"&i_appt_date="+appt_date+"&i_from_time="+from_time+"&i_to_time="+to_time+"&team_id="+team_id+"&over_booked="+over_booked+"&overbooked_yn="+overbooked_yn+"&new_day="+new_day+"&i_time_table_type="+p_o_time_tab_type+"&old_date="+old_date+"&Forced="+Forced+"&clinic_type="+clinic_type+"&res_type="+res_type+"&alcn_criteria="+alcn_criteria+"&sys_date="+sys_date,arguments,features);
			}else{
				var xmlDoc = ""
				var xmlHttp = new XMLHttpRequest()
				xmlStr ="<root><SEARCH patient_id=\""+patient_id+"\"  fromTime=\""+from_time+"\"  toTime=\""+to_time+"\" clinic_date=\""+appt_date+"\" appt_ref_no=\""+appt_ref_no+"\" order_id=\""+order_id+"\" steps='4' alcn_criteria=\""+alcn_criteria+"\" res_type=\""+res_type+"\" clinic_type=\""+clinic_type+"\" /></root>"
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
				xmlHttp.open("POST","VisitValidation.jsp",false)
				xmlHttp.send(xmlDoc)
				responseText=xmlHttp.responseText
				responseText = trimString(responseText)
				eval(responseText) 
				//Bru-HIMS-CRF 169 changes start
				var patcnclcount=parent.appt_pat_details.document.forms[0].pat_cncl_count.value;
				//Bru-HIMS-CRF 169 changes end
				if (responseText.length==2){
					var Forced=document.forms[0].Forced.value;
					var url="../../eOA/jsp/TransferAppointmentDetailsFrame.jsp?i_appt_ref_no="+appt_ref_no+"&i_clinic_code="+clinic_code+"&i_practitioner_id="+pract_id+"&i_appt_date="+appt_date+"&i_from_time="+from_time+"&i_to_time="+to_time+"&new_day="+new_day+"&over_booked="+over_booked+"&team_id="+team_id+"&overbooked_yn="+overbooked_yn+"&i_time_table_type="+p_o_time_tab_type+"&old_date="+old_date+"&Forced="+Forced+"&clinic_type="+clinic_type+"&res_type="+res_type+"&alcn_criteria="+alcn_criteria+"&sys_date="+sys_date+"&order_id="+order_id+"&pat_cncl_count="+patcnclcount; //modified--[IN027165]--Bru-HIMS-CRF-169[30288]
					
					retVal = await top.window.showModalDialog(url,arguments,features);
					
				}
			}
			if(retVal=='closed'){
				setTimeout('close_main_wind()',1000);
			}
		}
	}
	}
}

function close_main_wind(){
	parent.window.returnValue='closed';
	parent.window.close();
}

function compare_date(sys,to)
{
	
	
if(sys!="" && to!="" )
		{
			
			if(isBefore(sys,to,'DMY',localeName))
				{
					
					if(isBetween(to, to, sys,'DMY',localeName)==true)
		{
		
		return false;
		}
		else
			{
		
		return true;
			}
				
				
			}
			else
			{
				
				return false;
				
				
			}
		}
}

function compareDateEqual(from,to,sys)
{	
	

	if(from!="" && to!="" )
		{

	
	if(isBetween(from, to, sys,'DMY',localeName)==true)
	{
		
	return true;
	}
	else
			{
		
		return false;
			}
	
}
}
async function open_loc_lookup(obj)
{
	var location_val=document.forms[0].b_loc_val.value;
	locn_type=document.forms[0].clinic_type.value;
	var care_locn_ind=document.forms[0].clinic_type.value;
	var order_catalog_code=document.forms[0].order_catalog_code.value;
	var rd_appt_yn=document.forms[0].rd_appt_yn.value;
	//var speciality_code=document.forms[0].speciality_code.value;
	
	/*Below Line Added  and Commented for this SCF ML-BRU-SCF-0240 [IN:033238]*/	
	var clinic_code=document.forms[0].clinic_code.value;  	
	//document.forms[0].practitioner.value="";
	//document.forms[0].practitioner_name.value="";
	//End 
	
	var dialogTop = "60" ;
	var dialogHeight= "37" ;
	var dialogWidth	= "60" ;
	var status = "no";
	var arguments	= "" ;
	var tit="locn_Srch";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await top.window.showModalDialog("../../eOA/jsp/OALocationlookupframe.jsp?locn_type="+locn_type+"&location_val="+encodeURIComponent(location_val)+"&care_locn_ind="+care_locn_ind+"&order_catalog_code="+order_catalog_code+"&rd_appt_yn="+rd_appt_yn+"&function_id=TRANSFER_CANCEL_APPT",arguments,features);
	if(retVal!=null){
		var rvalues=retVal.split("~");
		var code=rvalues[0];
		var desc=rvalues[1];
		var open_to_all_pract_yn=rvalues[2];
		document.forms[0].b_loc_val.value=desc;
		document.forms[0].clinic_code.value=code;
		document.forms[0].open_to_all_pract_yn.value=open_to_all_pract_yn;
		
		var primary_resource_class=rvalues[3];		
		document.forms[0].res_type.value=primary_resource_class;		
		/*Below Line Added and Commented for this SCF ML-BRU-SCF-0240 [IN:033238]*/			
		if(clinic_code!="" && clinic_code!=code){		
        document.forms[0].practitioner.value="";
	    document.forms[0].practitioner_name.value="";
        change_schedule(document.forms[0].practitioner,document.forms[0].practitioner_name);		
		}		
		//change_schedule(document.forms[0].practitioner,document.forms[0].practitioner_name);
		//End [IN:033238]
	}else{
		document.forms[0].b_loc_val.value="";
		document.forms[0].clinic_code.value="";
		document.forms[0].open_to_all_pract_yn.value="";
		/*Below Line Added for this SCF ML-BRU-SCF-0240 [IN:033238]*/	
		document.forms[0].practitioner.value="";
	    document.forms[0].practitioner_name.value="";
		change_schedule(document.forms[0].practitioner,document.forms[0].practitioner_name);
		 //End SCF ML-BRU-SCF-0240 [IN:033238]
	}
}
function ena_loc_lookup(obj){
		if(obj.value==null || obj.value==''){
			var location_val=document.forms[0].b_loc_val.value;
			callthis(obj,location_val);
	}else{
		open_loc_lookup();	
	}
}

function checkPatientStatus(){//This function is to check patient status and alert the user accordingly.
	var patientid=document.displayresults.patient_id.value;
	if(patientid !=""){
		var active_yn =document.displayresults.active_yn.value;
		var suspend_yn =document.displayresults.suspend_yn.value;
		var deceased_yn =document.displayresults.deceased_yn.value;
		if(deceased_yn=="Y"){
			alert(getMessage("PATIENT_DECEASED","OA"));
			window.close();
		}else if(suspend_yn=="Y"){
			alert(getMessage("PATIENT_SUSPENDED","OA"));
			window.close();
		}else if(active_yn=="N"){
			alert(getMessage("PATIENT_INACTIVE","OA"));
			window.close();
		}
	}
}

