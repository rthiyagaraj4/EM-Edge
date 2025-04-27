 function reset()
{


	if(f_query_add_mod.document.related_diagnosis)
	{
		f_query_add_mod.document.related_diagnosis.reset();

		//var sel=f_query_add_mod.document.related_diagnosis.all.P_Term_Set_Id.value;
		var sel=f_query_add_mod.document.getElementById('P_Term_Set_Id').value;
		if(sel=="" || sel==null)
		{
		 f_query_add_mod.document.getElementById('P_From_Term_Code').value="";
		 f_query_add_mod.document.getElementById('P_To_Term_Code').value="";
		 f_query_add_mod.document.getElementById('P_Free_Text').value="";
		 f_query_add_mod.document.getElementById('P_From_Term_Code').disabled=true;
		 f_query_add_mod.document.getElementById('P_To_Term_Code').disabled=true;
		 f_query_add_mod.document.getElementById('P_Free_Text').disabled=true;
		 f_query_add_mod.document.getElementById('diag_frmbutton').disabled=true;
		 f_query_add_mod.document.getElementById('diag_tobutton').disabled=true;
		 f_query_add_mod.document.getElementById('frm_diag_code').style.visibility="hidden";
		 f_query_add_mod.document.getElementById('to_diag_code').style.visibility="hidden";
		 f_query_add_mod.document.getElementById('start_ends_contains').disabled=true;
		}
		else
		{
		 f_query_add_mod.document.getElementById('P_From_Term_Code').disabled=false;
		 f_query_add_mod.document.getElementById('P_To_Term_Code').disabled=false;
		 f_query_add_mod.document.getElementById('P_Free_Text').disabled=false;
		 f_query_add_mod.document.getElementById('diag_frmbutton').disabled=false;
		 f_query_add_mod.document.getElementById('diag_tobutton').disabled=false;
		 //document.getElementById("frm_diag_code").style.visibility="visible";
		 //document.getElementById("to_diag_code").style.visibility="visible";
		}
	}

	if(f_query_add_mod.document.search_form_repVisitWthotMDS)
	{
		f_query_add_mod.document.getElementById('p_mds_lbl').style.visibility='hidden';
		f_query_add_mod.document.getElementById('p_mds_type1').style.visibility='hidden';
		f_query_add_mod.document.search_form_repVisitWthotMDS.reset() ;
	}

	if (f_query_add_mod.document.forms[0].name=="MROPBKED")
	{
		f_query_add_mod.location.reload();
	}

//added from repEncounterList.js
	if(f_query_add_mod.document.repencounterlist)
	{
	f_query_add_mod.document.repencounterlist.reset() ;
	}

//added from repVisitNotifiableCases.js
if(f_query_add_mod.document.repNotifiableCases)
{
	f_query_add_mod.document.repNotifiableCases.reset();
}

	// added from repListDischargeWithoutICD.js
if(f_query_add_mod.document.search_form_repDischarge)
{
   f_query_add_mod.document.search_form_repDischarge.reset();
}
	
	// added from repListDischargeICDgrp.js

    if(f_query_add_mod.document.search_form_Discharge)
		{
			f_query_add_mod.document.search_form_Discharge.reset();
		}

	// added from repProcEncounter.js
	if(f_query_add_mod.document.search_form)
		{
		   f_query_add_mod.document.search_form.reset();
		}
	// added from repBirthRegister.js
	if(f_query_add_mod.document.BirthRegister)
		{
		f_query_add_mod.document.BirthRegister.reset() ;
		
		}
	f_query_add_mod.document.forms[0].reset();
	if (f_query_add_mod.document.RepTablistStat)
	 f_query_add_mod.location.reload();
	if (f_query_add_mod.document.MRIPCSEG)
	 f_query_add_mod.location.reload();
	if (f_query_add_mod.document.MROPCSAT)
	 f_query_add_mod.location.reload();
	if (f_query_add_mod.document.MROPANPO)
	 f_query_add_mod.location.reload();
	if (f_query_add_mod.document.MRBNEODT)
	 f_query_add_mod.location.reload();
	if (f_query_add_mod.document.MRIPCSMH)
	 f_query_add_mod.location.reload();
	if (f_query_add_mod.document.MROPCSEG)
	 f_query_add_mod.location.reload();
	if (f_query_add_mod.document.MRBRH212)
	 f_query_add_mod.location.reload();
	if (f_query_add_mod.document.MRBLABRG)
	 f_query_add_mod.location.reload();
	if (f_query_add_mod.document.MRBRADEX)
	 f_query_add_mod.location.reload();
	if (f_query_add_mod.document.MRBLABWL)
	 f_query_add_mod.location.reload();
    if (f_query_add_mod.document.MRBRH207)
	 f_query_add_mod.location.reload();         //Added by Sangeetha for HSA-CRF-211 on 17-Aug-2016

//added from repMorbidityStatsNat.js
	if(f_query_add_mod.document.morbidity)
	{
		f_query_add_mod.document.morbidity.reset() ;
	}

//added from repMorbidityStatsAge.js
	if(f_query_add_mod.document.morbiditystat)
	{
		f_query_add_mod.document.morbiditystat.reset() ;
	}

// added from repMortalityStatsNat.js
if(f_query_add_mod.document.mortality)
	{
		f_query_add_mod.document.mortality.reset() ;
	}

// added form repMortalityStatsAge.js
if(f_query_add_mod.document.mortalityStatsAge)
	{
		f_query_add_mod.document.mortalityStatsAge.reset() ;
	}


// added from repDischargeStatbyICDSex.js
if(f_query_add_mod.document.repDischargeStats)
	{
		f_query_add_mod.document.repDischargeStats.reset();
	}


// added from repDischargeStatbyWardICDAge.js
if(f_query_add_mod.document.repDischargeStatsbyNursUnit)
	{
		f_query_add_mod.document.repDischargeStatsbyNursUnit.reset();
		}
		//Appointments for OPD - BCP REPORT 4/16/2009
	if(f_query_add_mod.document.repAppointmentsforopdBCP_Form)
	{
		f_query_add_mod.document.repAppointmentsforopdBCP_Form.reset();		
	}
	if(f_query_add_mod.document.repCurrentInpatientListBCP_Form)
	{
		f_query_add_mod.document.repCurrentInpatientListBCP_Form.reset();
	}
	if(f_query_add_mod.document.repInpatientAdmissionListBCP_Form)
	{
		f_query_add_mod.document.repInpatientAdmissionListBCP_Form.reset();
	}
	if(f_query_add_mod.document.repLabResultsListBCP_Form)
	{
		f_query_add_mod.document.repLabResultsListBCP_Form.reset();
	}
    if (f_query_add_mod.document.MRCSWKDT)   //Added by Sangeetha for HSA-CRF-0025.1 on 28-oct-2016
	{
		f_query_add_mod.location.reload();
	}
	/*Added by Thamizh selvi on 8th Nov 2016 against HSA-CRF-0213 Start*/
	if (f_query_add_mod.document.LeadingMorbidityMortality)  
	{	
		f_query_add_mod.location.reload();
	}
	/*End*/
	/*Added by Ashwini on 03-May-2019 for ML-MMOH-CRF-1292*/
	if (f_query_add_mod.document.NIAReportForm)  
	{
		f_query_add_mod.location.reload();
	}
	/*End ML-MMOH-CRF-1292*/

}	

function CheckTerm(str ,fromobj,toobj,messageFrame) {
				

	 var arr = new Array(toobj.value,fromobj.value);
    if( trimCheck(fromobj.value) && trimCheck(toobj.value) ) {
        if(fromobj.value <= toobj.value) {
            return true;
        }
        else {
			
			var error=getMessage("REMARKS_MUST_GR_EQUAL","common");

			error=error.replace("$",getLabel('Common.to.label','common_labels')+ ' ' +str);
			error=error.replace("#",str);
            messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
            return false;
        }
    }
    else {
        return true;
    }
}
function run()
{
 
	if(f_query_add_mod.document.related_diagnosis){

			f_query_add_mod.document.forms[0].p_all_facility_id.focus();

		if(f_query_add_mod.document.forms[0].P_Group_By.value == 'P')
			f_query_add_mod.document.forms[0].p_report_id.value='MRPATLDGP';
		else if(f_query_add_mod.document.forms[0].P_Group_By.value == 'D')
			f_query_add_mod.document.forms[0].p_report_id.value='MRPATLDGD';


		//f_query_add_mod.document.forms[0].p_facility_id.value = f_query_add_mod.document.forms[0].p_all_facility_id.value;


		var fields = new Array();
		var names  = new Array();

		if(f_query_add_mod.document.forms[0].P_From_Date.value == '' || f_query_add_mod.document.forms[0].P_To_Date.value == '') {
		
			fields[0]=f_query_add_mod.document.forms[0].P_From_Date.value;
			names[0] = getLabel("eMR.PeriodRange.label","MR");

			if(f_query_add_mod.document.forms[0].P_Term_Set_Id.value == '') {
							
					fields[1]=f_query_add_mod.document.forms[0].P_From_Date.value;
					names[1] = getLabel("Common.TermSet.label","Common");


			}
			
		}
		else if(f_query_add_mod.document.forms[0].P_Term_Set_Id.value == '') {
							
					fields[0]=f_query_add_mod.document.forms[0].P_From_Date.value;
					names[0] = getLabel("Common.TermSet.label","Common");


		}


			if(f_query_add_mod.checkFields(fields, names, messageFrame)){
							
				if( f_query_add_mod.CheckTerm(getLabel("Common.TermCode.label","Common"), f_query_add_mod.document.forms[0].P_From_Term_Code,f_query_add_mod.document.forms[0].P_To_Term_Code, messageFrame )  )
			
				if(chkGrtrDate( f_query_add_mod.document.forms[0].P_From_Date, f_query_add_mod.document.forms[0].P_To_Date) )
					{
	
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
				f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.related_diagnosis.submit();
				
					}
			}
			
	}
	
	

	
	/*Below lines added by Venkateshs against MMS-DM-CRF-0057 */
	if(f_query_add_mod.document.new_report_form){

		 f_query_add_mod.document.forms[0].p_report_id.value='MRICDCODE';
			var fields = new Array()
			var names  = new Array() 
			var formObj=f_query_add_mod.document.new_report_form;
			var fields = new Array(formObj.P_From_Date,formObj.P_To_Date,formObj.p_diag_set);
			var names  = new Array ( getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"),getLabel("Common.TermSet.label","Common"));
			if ( f_query_add_mod.checkFields(fields, names, messageFrame) )
			{
			
			if( f_query_add_mod.CheckString1( getLabel("eMR.TerminologyGroup.label","MR"),f_query_add_mod.document.forms[0].p_frm_term_grp_id, f_query_add_mod.document.forms[0].p_to_term_grp_id, messageFrame ) ) 	
		    if( f_query_add_mod.CheckTerm(getLabel("Common.TermCode.label","Common"), f_query_add_mod.document.forms[0].P_From_Term_Code,f_query_add_mod.document.forms[0].P_To_Term_Code, messageFrame )  )
			if(chkGrtrDate( f_query_add_mod.document.forms[0].P_From_Date, f_query_add_mod.document.forms[0].P_To_Date) )
				{
				
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
				f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.forms[0].submit() ;
				}
			
			}
		
	}
/* end MMS-DM-CRF-0057 */

/*START added by Sangeetha on 05-oct-2016 for GDOH-CRF-0082 */
if(f_query_add_mod.document.ICD10PMBReport){

			var fields = new Array()
			var names  = new Array() 
			var formObj=f_query_add_mod.document.ICD10PMBReport;
			var fields = new Array(formObj.P_FM_DATE,formObj.P_TO_DATE);
			var names1  = new Array ( getLabel("eMR.AdmVisitMonth.label","MR"));
			var names  = new Array ( getLabel("Common.from.label","Common")+" "+getLabel("eMR.AdmVisitMonth.label","MR"),getLabel("Common.to.label","Common")+" "+getLabel("eMR.AdmVisitMonth.label","MR"));
			if ( f_query_add_mod.checkFields(fields, names, messageFrame) )
			{
		    if( f_query_add_mod.checkmonths( names1,f_query_add_mod.document.forms[0].P_FM_DATE, f_query_add_mod.document.forms[0].P_TO_DATE, messageFrame ) )
			
			if( f_query_add_mod.CheckString1( getLabel("Common.patientId.label","Common"),f_query_add_mod.document.forms[0].p_fm_patient_id, f_query_add_mod.document.forms[0].p_to_patient_id, messageFrame ) )

			if( f_query_add_mod.CheckString1( getLabel("Common.BillingGroup.label","Common"),f_query_add_mod.document.forms[0].p_from_bl_grp_id, f_query_add_mod.document.forms[0].p_to_bl_grp_id, messageFrame ) ) 
				
			if( f_query_add_mod.CheckString1( getLabel("Common.Customer.label","Common"),f_query_add_mod.document.forms[0].p_from_cust_code, f_query_add_mod.document.forms[0].p_to_cust_code, messageFrame ) ) 

			if( f_query_add_mod.CheckTerm(getLabel("eMR.ICD10CODE.label","MR"), f_query_add_mod.document.forms[0].p_from_termcode,f_query_add_mod.document.forms[0].p_to_termcode, messageFrame )  )
				{ 
			    //added by Sangeetha on 17-oct-2016 for GDOH-CRF-0082
				var p_fm_patient_id		= f_query_add_mod.document.forms[0].p_fm_patient_id.value; 
				var p_to_patient_id		= f_query_add_mod.document.forms[0].p_to_patient_id.value; 
				var P_FM_DATE			= f_query_add_mod.document.forms[0].P_FM_DATE.value; 
				var P_TO_DATE			= f_query_add_mod.document.forms[0].P_TO_DATE.value; 
				var p_from_bl_grp_id	= f_query_add_mod.document.forms[0].p_from_bl_grp_id.value; 
				var p_to_bl_grp_id		= f_query_add_mod.document.forms[0].p_to_bl_grp_id.value; 
				var p_from_cust_code	= f_query_add_mod.document.forms[0].p_from_cust_code.value; 
				var p_to_cust_code		= f_query_add_mod.document.forms[0].p_to_cust_code.value; 
				var p_from_termcode		= f_query_add_mod.document.forms[0].p_from_termcode.value; 
				var p_to_termcode		= f_query_add_mod.document.forms[0].p_to_termcode.value;  
				var P_REPORT_TYPE		= f_query_add_mod.document.forms[0].P_REPORT_TYPE.value; 
				var visitType_hdn		= f_query_add_mod.document.forms[0].visitType_hdn.value	;

				if(f_query_add_mod.document.forms[0].p_visit_type1.checked)
					{var p_visit_type1		= f_query_add_mod.document.forms[0].p_visit_type1.value	;}
				else{var p_visit_type1		="";}

				if(f_query_add_mod.document.forms[0].p_visit_type2.checked)
					{var p_visit_type2		= f_query_add_mod.document.forms[0].p_visit_type2.value	;}
				else{var p_visit_type2		="";}

				if(f_query_add_mod.document.forms[0].p_visit_type3.checked)
					{var p_visit_type3		= f_query_add_mod.document.forms[0].p_visit_type3.value	;}
				else{var p_visit_type3		="";}

				var P_facility_id		= f_query_add_mod.document.forms[0].P_facility_id.value	;
				var p_module_id			= f_query_add_mod.document.forms[0].p_module_id.value	;
				var p_report_id			= f_query_add_mod.document.forms[0].p_report_id.value	;
				var p_user_name			= f_query_add_mod.document.forms[0].p_user_name.value	;
				var p_language_id		= f_query_add_mod.document.forms[0].p_language_id.value	;
				var CurrentDate			= f_query_add_mod.document.forms[0].CurrentDate.value	;

				f_query_add_mod.document.ICD10PMBReport.method	= 'POST';

				f_query_add_mod.document.ICD10PMBReport.action	= '../../eCommon/jsp/report_options.jsp?p_fm_patient_id='+p_fm_patient_id+'&p_to_patient_id='+p_to_patient_id+'&P_FM_DATE='+P_FM_DATE+'&P_TO_DATE='+P_TO_DATE+'&p_from_bl_grp_id='+p_from_bl_grp_id+'&p_to_bl_grp_id='+p_to_bl_grp_id+'&p_from_cust_code='+p_from_cust_code+'&p_to_cust_code='+p_to_cust_code+'&p_from_termcode='+p_from_termcode+'&p_to_termcode='+p_to_termcode+'&P_REPORT_TYPE='+P_REPORT_TYPE+'&visitType_hdn='+visitType_hdn+'&p_visit_type1='+p_visit_type1+'&p_visit_type2='+p_visit_type2+'&p_visit_type3='+p_visit_type3+'&P_facility_id='+P_facility_id+'&p_module_id='+p_module_id+'&p_report_id='+p_report_id+'&p_user_name='+p_user_name+'&p_language_id='+p_language_id+'&CurrentDate='+CurrentDate;
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
				f_query_add_mod.document.forms[0].target="messageFrame" ;
				f_query_add_mod.document.ICD10PMBReport.submit() ;
				}
			}
		
	}
/*END added by Sangeetha on 05-oct-2016 for GDOH-CRF-0082*/

if(f_query_add_mod.document.HAAD_Diseasereport_Form)
{

  f_query_add_mod.document.forms[0].p_report_id.value='MRHADDIS';
			var fields = new Array()
			var names  = new Array() 
			var formObj=f_query_add_mod.document.HAAD_Diseasereport_Form;
			var fields = new Array(formObj.P_From_Date,formObj.P_To_Date);
			var names  = new Array ( getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"));
			if ( f_query_add_mod.checkFields(fields, names, messageFrame) )
			{
			
		
			if(chkGrtrDate( f_query_add_mod.document.forms[0].P_From_Date, f_query_add_mod.document.forms[0].P_To_Date) ) 
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
				f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.forms[0].submit() ;
			}
}

	if(f_query_add_mod.document.DRG_expForm){

		var fields = new Array(f_query_add_mod.document.forms[0].p_fr_specialty_code,f_query_add_mod.document.forms[0].p_to_specialty_code);

		var names  = new Array ( getLabel("eMR.FromSpeciality.label","MR"),getLabel("eMR.ToSpeciality.label","MR"));


		if(f_query_add_mod.checkFields(fields, names, messageFrame)){
			if( f_query_add_mod.CheckString1(getLabel("Common.speciality.label","Common"), f_query_add_mod.document.DRG_expForm.p_fr_specialty_code,f_query_add_mod.document.DRG_expForm.p_to_specialty_code, messageFrame )  )
		
		if(chkGrtrDate( f_query_add_mod.document.forms[0].p_fr_adm_date, f_query_add_mod.document.forms[0].p_to_adm_date) )  

		if(chkGrtrDate( f_query_add_mod.document.forms[0].p_fr_dis_date, f_query_add_mod.document.forms[0].p_to_dis_date) )  

			
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
		f_query_add_mod.document.forms[0].target="messageFrame";
		f_query_add_mod.document.DRG_expForm.submit();

		}
	}
	
	if(f_query_add_mod.document.Principal_Diagnosis){
		
	if(chkGrtrDate( f_query_add_mod.document.forms[0].p_fr_adm_date, f_query_add_mod.document.forms[0].p_to_adm_date) ) 
		if(chkGrtrDate( f_query_add_mod.document.forms[0].p_fr_dis_date, f_query_add_mod.document.forms[0].p_to_dis_date) )  
		
		if(chkGrtrDate( f_query_add_mod.document.forms[0].p_fr_period_date, f_query_add_mod.document.forms[0].p_to_period_date) )
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
		f_query_add_mod.document.forms[0].target="messageFrame";
		f_query_add_mod.document.forms[0].submit();
			
	}
	if(f_query_add_mod.document.Diag_proc){	
		
	if(chkGrtrDate( f_query_add_mod.document.forms[0].p_fr_adm_date, f_query_add_mod.document.forms[0].p_to_adm_date) ) 
		if(chkGrtrDate( f_query_add_mod.document.forms[0].p_fr_dis_date, f_query_add_mod.document.forms[0].p_to_dis_date) ) 
		
		if(chkGrtrDate( f_query_add_mod.document.forms[0].p_fr_period_date, f_query_add_mod.document.forms[0].p_to_period_date) )

			if( f_query_add_mod.CheckString1(getLabel("Common.speciality.label","Common"), f_query_add_mod.document.forms[0].p_fr_specialty_code,f_query_add_mod.document.forms[0].p_to_specialty_code, messageFrame )  )
				if( f_query_add_mod.CheckString1(getLabel("Common.Location.label","Common"), f_query_add_mod.document.forms[0].p_fr_location_code,f_query_add_mod.document.forms[0].p_to_location_code, messageFrame )  )
				if( f_query_add_mod.CheckString1(getLabel("Common.service.label","Common"), f_query_add_mod.document.forms[0].p_fr_service_code,f_query_add_mod.document.forms[0].p_to_service_code, messageFrame )  )


				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
				f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.forms[0].submit();
			
	}

	

	
	
	
//copied from mr reports js...
	if(f_query_add_mod.document.MRBRADEX)
	{	
		var errors = "" ; 
		var fields = new Array(f_query_add_mod.document.MRBRADEX.p_fm_Date,f_query_add_mod.document.MRBRADEX.p_to_Date);
		
		var reptype= f_query_add_mod.document.MRBRADEX.report_type.value;
		
		if(reptype=="M")
		{		
			var names  = new Array ( getLabel("Common.FromMonth.label","Common"),getLabel("Common.ToMonth.label","Common"));
		}
		else if(reptype=="Y")
		{
		var names  = new Array ( getLabel("eIP.FromYear.label","IP"),getLabel("eIP.ToYear.label","IP"));
		}
		else
		{
			var names  = new Array ( getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"));
		}

		if(reptype=="M")
		{			  
			var names1  = new Array ( getLabel("Common.month.label","Common"));
			
			if(f_query_add_mod.checkFields(fields, names, messageFrame))
			{   
				if( f_query_add_mod.checkmonths( names1,f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ) )
				{	 
					f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
					f_query_add_mod.document.forms[0].target="messageFrame";
					f_query_add_mod.document.MRBRADEX.submit() ;
					
				}
			}	
		}
		else if(reptype=="Y")
		{
			var names1  = new Array ( getLabel("Common.year.label","Common"));
			if(f_query_add_mod.checkFields( fields, names, messageFrame))
			{
				if( f_query_add_mod.CheckString( names1,f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ) )
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
				f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.MRBRADEX.submit() ;
			}
		}
		else
		{
		   if(f_query_add_mod.checkFields( fields, names, messageFrame))
		   {
			   if( f_query_add_mod.doDateCheck(f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ) )
				   f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
				   f_query_add_mod.document.forms[0].target="messageFrame";
				   f_query_add_mod.document.MRBRADEX.submit() ;
			}
		}
	}
	////////

//copy ended... 

	//added from repEncounterList.js
 /*if(f_query_add_mod.document.repencounterlist)
 {
	 
	 if(f_query_add_mod.document.repencounterlist.p_patient_id.value == "")
	 {
		
		var err = getMessage("CAN_NOT_BE_BLANK","Common");
		err = err.replace('$',getLabel("Common.patientId.label","Common"));
		alert(err);
	 }
	 else
	 {
		f_query_add_mod.document.repencounterlist.submit() ;
	 }
 }*/
 



//added from repVisitNotifiableCases.js
 if(f_query_add_mod.document.repNotifiableCases)
 {
	 var formObj=f_query_add_mod.document.repNotifiableCases;			
			
	var fields = new Array(formObj.p_diag_set);
	var names  = new Array ( getLabel("Common.diagnosis.label","Common")+' '+getLabel("Common.Set.label","Common"));
	
		 if ( f_query_add_mod.checkFields(fields, names, messageFrame) )
	//if( f_query_add_mod.doDateCheck( f_query_add_mod.document.forms[0].p_fr_diag_date, f_query_add_mod.document.forms[0].p_to_diag_date, messageFrame ) ) 
	if( doDateCheckAlertLocal(getLabel("Common.DiagnosisDate.label","Common"),f_query_add_mod.document.forms[0].p_fr_diag_date,f_query_add_mod.document.forms[0].p_to_diag_date,messageFrame ) )
	if( f_query_add_mod.CheckString1(getLabel("Common.DiagnosisCode.label","Common"), f_query_add_mod.document.forms[0].p_fr_diagnosis_code,f_query_add_mod.document.forms[0].p_to_diagnosis_code, messageFrame )  )
	if( f_query_add_mod.CheckString1(getLabel("Common.locationcode.label","Common"), f_query_add_mod.document.forms[0].p_fr_clinic_code,f_query_add_mod.document.forms[0].p_to_clinic_code, messageFrame )  )
	if( f_query_add_mod.CheckString1(getLabel("Common.practitionerid.label","Common"), f_query_add_mod.document.forms[0].p_fr_physician_id,f_query_add_mod.document.forms[0].p_to_physician_id, messageFrame )  )
	if( f_query_add_mod.CheckString1(getLabel("Common.practitionertype.label","Common"), f_query_add_mod.document.forms[0].fm_pract_type,f_query_add_mod.document.forms[0].to_pract_type, messageFrame )  )
		{
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
		f_query_add_mod.document.forms[0].target="messageFrame"
		f_query_add_mod.document.forms[0].submit();
		}
 }
	// added from repListDischargeWithoutICD.js
if(f_query_add_mod.document.search_form_repDischarge)
{
	   if( f_query_add_mod.CheckString( getLabel("Common.locationcode.label","Common"),f_query_add_mod.document.forms[0].p_fm_loc_code, f_query_add_mod.document.forms[0].p_to_loc_code, messageFrame ) ) 
		//if( f_query_add_mod.doDateCheck( f_query_add_mod.document.forms[0].p_fm_discharge_date, f_query_add_mod.document.forms[0].p_to_discharge_date, messageFrame ) ) {
		if( doDateCheckAlertLocal( getLabel("Common.dischargedate.label","Common"),f_query_add_mod.document.forms[0].p_fm_discharge_date,f_query_add_mod.document.forms[0].p_to_discharge_date, messageFrame ) ) {
		//if( f_query_add_mod.CheckString( getLabel("Common.nursingUnit.label","Common"),f_query_add_mod.document.forms[0].p_fm_nursing_unit_code, f_query_add_mod.document.forms[0].p_to_nursing_unit_code, messageFrame ) )
         var fields = new Array(f_query_add_mod.document.search_form_repDischarge.p_fm_discharge_date,f_query_add_mod.document.search_form_repDischarge.p_to_discharge_date);
          var names  = new Array ( getLabel("Common.from.label","Common")+' '+getLabel("Common.dischargedate.label","Common"),getLabel("Common.to.label","Common")+' '+getLabel("Common.dischargedate.label","Common"));
  if ( f_query_add_mod.checkFields(fields, names, messageFrame) ){

		    f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
			f_query_add_mod.document.forms[0].target="messageFrame";
 			f_query_add_mod.document.forms[0].submit() ;
  }
	}
}

/*For Function Visit Without MDS Developed On 3/21/2008*/
if(f_query_add_mod.document.search_form_repVisitWthotMDS)
{

	var fields="";
	var names="";
		var formObj=f_query_add_mod.document.search_form_repVisitWthotMDS;
		
			if( f_query_add_mod.CheckString1( getLabel("Common.locationcode.label","Common"),formObj.p_fr_locn_code, formObj.p_to_locn_code, messageFrame ) ) 
			if( doDateCheckAlertLocal( getLabel("Common.encounterdate.label","Common"),formObj.p_fr_vst_date1,formObj.p_to_vst_date1, messageFrame ) ) 
			{
				if(formObj.p_mds_type.value == null || formObj.p_mds_type.value == undefined||formObj.p_mds_type.value==''){

			 fields = new Array(formObj.p_fr_vst_date1,formObj.p_to_vst_date1);
			 names  = new Array ( getLabel("Common.from.label","Common")+' '+getLabel("Common.encounterdate.label","Common"),getLabel("Common.to.label","Common")+' '+getLabel("Common.encounterdate.label","Common"));
				}
				else{

					 fields = new Array(formObj.p_fr_vst_date1,formObj.p_to_vst_date1,formObj.p_diag_set);
			 names  = new Array (getLabel("Common.from.label","Common")+' '+getLabel("Common.encounterdate.label","Common"),getLabel("Common.to.label","Common")+' '+getLabel("Common.encounterdate.label","Common"),getLabel("Common.diagnosis.label","Common")+' '+getLabel("Common.Set.label","Common"));

				}


		if(formObj.p_mds_type.value == '' || formObj.p_mds_type.value == null || formObj.p_mds_type.value == undefined)
			formObj.p_diag_set.value = "";

			
		  if ( f_query_add_mod.checkFields(fields, names, messageFrame) )
			{
				f_query_add_mod.document.forms[0].p_to_vst_date.value =	convertDate(f_query_add_mod.document.forms[0].p_to_vst_date1.value,"DMY",localeName,"en");

				f_query_add_mod.document.forms[0].p_fr_vst_date.value =		convertDate(f_query_add_mod.document.forms[0].p_fr_vst_date1.value,"DMY",localeName,"en");
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
				f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.forms[0].submit() ;
			 }
		  }
}

if(f_query_add_mod.document.repencounterlist)
{
		var formObj=f_query_add_mod.document.repencounterlist;
		
			
			
			var fields = new Array(formObj.p_patient_id,formObj.p_fr_enc_date,formObj.p_to_enc_date);
			var names  = new Array ( getLabel("Common.patientId.label","Common"),getLabel("Common.from.label","Common")+' '+getLabel("Common.encounterdate.label","Common"),getLabel("Common.to.label","Common")+' '+getLabel("Common.encounterdate.label","Common"));
		  
		  if ( f_query_add_mod.checkFields(fields, names, messageFrame) )
			{
			  f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
				f_query_add_mod.document.forms[0].target="messageFrame";
						f_query_add_mod.document.forms[0].submit() ;
			 }
		  }


// added from repListDischargeICDgrp.js

    if(f_query_add_mod.document.search_form_Discharge)
	{
		
	var formObj=f_query_add_mod.document.search_form_Discharge;			
			
	var fields = new Array(formObj.p_diag_set,formObj.p_fm_discharge_date,formObj.p_to_discharge_date);
	var names  = new Array ( getLabel("Common.diagnosis.label","Common")+' '+getLabel("Common.Set.label","Common"),getLabel("Common.from.label","Common")+' '+getLabel("Common.dischargedate.label","Common"),getLabel("Common.to.label","Common")+' '+getLabel("Common.dischargedate.label","Common"));
	
		 if ( f_query_add_mod.checkFields(fields, names, messageFrame) )
		if( doDateCheckAlertLocal( getLabel("Common.dischargedate.label","Common"),f_query_add_mod.document.forms[0].p_fm_discharge_date, f_query_add_mod.document.forms[0].p_to_discharge_date, messageFrame ) )
		{
			if( f_query_add_mod.CheckString( getLabel("eMR.DiagnosisGroupCode.label","MR"),f_query_add_mod.document.forms[0].p_fm_diag_grp_code, f_query_add_mod.document.forms[0].p_to_diag_grp_code, messageFrame ) ) 
			{
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
				f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.forms[0].submit() ;
			}
		}
	}

// added from repProcEncounter.js
if(f_query_add_mod.document.search_form)
	{
		
		 if ( (f_query_add_mod.document.search_form.call_function.value != null) && (f_query_add_mod.document.search_form.call_function.value != '') )
		 {
			 var call_function = f_query_add_mod.document.search_form.call_function.value;
			 if  ( (call_function == 'MRBWEHUA') || (call_function == 'MRBWEHUD') ||	(call_function == 'MRBCANNT') )
			 {
				 var fields = new Array(f_query_add_mod.document.search_form.alt_id1_exp_date,f_query_add_mod.document.search_form.alt_id2_exp_date);
				 var names  = new Array ( getLabel("Common.from.label","Common")+' '+getLabel("Common.Period.label","Common"),getLabel("Common.to.label","Common")+' '+getLabel("Common.Period.label","Common"));
				 if ( f_query_add_mod.checkFields(fields, names, messageFrame) )
				 {
					 
					// if( f_query_add_mod.doDateCheck( f_query_add_mod.document.forms[0].alt_id1_exp_date, f_query_add_mod.document.forms[0].alt_id2_exp_date, messageFrame ) ) 
					if( f_query_add_mod.CheckString( getLabel("Common.expiryDate.label","Common"),f_query_add_mod.document.forms[0].alt_id1_exp_date, f_query_add_mod.document.forms[0].alt_id2_exp_date, messageFrame  ) )
						f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
						f_query_add_mod.document.forms[0].target="messageFrame";
						f_query_add_mod.document.forms[0].submit() ;
				 }
			 }
		 }
		 else
		{
		 var fields = new Array(f_query_add_mod.document.search_form.p_patient_id,f_query_add_mod.document.search_form.p_encounter_id);
		 var names  = new Array ( getLabel("Common.patientId.label","Common"),getLabel("Common.encounterid.label","Common"));
		 if ( f_query_add_mod.checkFields(fields, names, messageFrame) )
		 {
			
			// if( f_query_add_mod.doDateCheck( f_query_add_mod.document.forms[0].p_fm_proc_date, f_query_add_mod.document.forms[0].p_to_proc_date, messageFrame ) ) 
			if( doDateCheckAlertLocal( getLabel("eMR.ProcedureDate.label","MR"),f_query_add_mod.document.forms[0].p_fm_proc_date, f_query_add_mod.document.forms[0].p_to_proc_date, messageFrame ) )
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
			f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.forms[0].submit() ;
		 }
		}
		
}



		// added from repBirthRegister.js
if (f_query_add_mod.document.BirthRegister)
	{
	
		//if (f_query_add_mod.doDateCheck(f_query_add_mod.document.BirthRegister.date_from,f_query_add_mod.document.BirthRegister.date_to, messageFrame))
		if (doDateCheckAlertLocal(getLabel("Common.birthDate.label","Common"), f_query_add_mod.document.BirthRegister.date_from,f_query_add_mod.document.BirthRegister.date_to, messageFrame))
		if (f_query_add_mod.CheckString(getLabel("eMR.TypeofDelivery.label","MR"), f_query_add_mod.document.BirthRegister.p_fm_delivery,f_query_add_mod.document.BirthRegister.p_to_delivery, messageFrame))
		if (f_query_add_mod.CheckString(getLabel("Common.AttendingPractitioner.label","Common"), f_query_add_mod.document.BirthRegister.p_fm_attend_pract,f_query_add_mod.document.BirthRegister.p_to_attend_pract, messageFrame))
		//if (f_query_add_mod.CheckString('Attending Nurse', f_query_add_mod.document.BirthRegister.p_fm_attend_nurse,f_query_add_mod.document.BirthRegister.p_to_attend_nurse, messageFrame))
		if (f_query_add_mod.CheckString(getLabel("eMP.AttendingNurse.label","MP"), f_query_add_mod.document.BirthRegister.p_fm_attend_midwife,f_query_add_mod.document.BirthRegister.p_to_attend_midwife, messageFrame))
		{
			f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
			f_query_add_mod.document.forms[0].target="messageFrame";
			f_query_add_mod.document.BirthRegister.submit() ;
			
		}
		
			
	}

// added from repDischargeStatbyWardICDAge.js
	if(f_query_add_mod.document.repDischargeStatsbyNursUnit)
	{
		


		
				var formObj=f_query_add_mod.document.repDischargeStatsbyNursUnit;			
			
	var fields = new Array(formObj.p_age_range,formObj.p_diag_set);
	var names  = new Array (getLabel("Common.AgeRange.label","Common"), getLabel("Common.diagnosis.label","Common")+' '+getLabel("Common.Set.label","Common"));
	
		 if ( f_query_add_mod.checkFields(fields, names, messageFrame) )				 
				if( chkGrtrDate( f_query_add_mod.document.forms[0].p_fr_pref_date,		f_query_add_mod.document.forms[0].p_to_pref_date ) ) 
				if( f_query_add_mod.CheckString(getLabel("Common.NursingUnitCode.label","Common"), f_query_add_mod.document.forms[0].p_fr_nursing_unit,f_query_add_mod.document.forms[0].p_to_nursing_unit, messageFrame )  )
				{
					f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
				f_query_add_mod.document.forms[0].target="messageFrame";
					f_query_add_mod.document.forms[0].submit();
					}
			

	}
// added from repDischargeStatbyICDSex.js
	if(f_query_add_mod.document.repDischargeStats)
	{
		
    //if(f_query_add_mod.doDateCheck( f_query_add_mod.document.forms[0].p_fr_discharge_date, f_query_add_mod.document.forms[0].p_to_discharge_date, messageFrame ) )

	var formObj=f_query_add_mod.document.repDischargeStats;			
			
	var fields = new Array(formObj.p_diag_set);
	var names  = new Array ( getLabel("Common.diagnosis.label","Common")+' '+getLabel("Common.Set.label","Common"));
	
		 if ( f_query_add_mod.checkFields(fields, names, messageFrame) )

	if(chkGrtrDate( f_query_add_mod.document.forms[0].p_fr_discharge_date, f_query_add_mod.document.forms[0].p_to_discharge_date) )
		{
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
		f_query_add_mod.document.forms[0].target="messageFrame";
		f_query_add_mod.document.forms[0].submit();
		}
	}


	if (f_query_add_mod.document.MRIPDLRG)
	{
		
		var fields = new Array ( f_query_add_mod.document.MRIPDLRG.P_FM_ADMN_DATE,f_query_add_mod.document.MRIPDLRG.P_TO_ADMN_DATE);
		var names  = new Array ( getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"));
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{

			if (f_query_add_mod.doDateCheck( f_query_add_mod.document.MRIPDLRG.P_FM_ADMN_DATE,f_query_add_mod.document.MRIPDLRG.P_TO_ADMN_DATE, messageFrame))
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
			f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.MRIPDLRG.submit() ;
		}
	}
	
	if (f_query_add_mod.document.MRBNEODT)
	{
		
		var fields = new Array ( f_query_add_mod.document.MRBNEODT.p_fm_date,f_query_add_mod.document.MRBNEODT.p_to_date,f_query_add_mod.document.MRBNEODT.p_days);
		var names  = new Array ( getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"),getLabel("eMR.NeonatalDeathsoccuredwithin.label","MR"));
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
			f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
			f_query_add_mod.document.forms[0].target="messageFrame";
			f_query_add_mod.document.MRBNEODT.submit() ;
		}
	}
	
	/*--- below line(s) added by venkatesh.S  and Emp:ID-4008  on 18/Jan/2012 aganist  KDAH-CRF-0032---*/
	if (f_query_add_mod.document.lab_test_rep)
	  {
	 
	  
	  var fields = new Array ( f_query_add_mod.document.lab_test_rep.P_FM_ADMN_DATE,f_query_add_mod.document.lab_test_rep.P_TO_ADMN_DATE);
		var names  = new Array ( "From Date","To Date");
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
			{
					
				if( doDateCheckAlert1(f_query_add_mod.document.lab_test_rep.P_FM_ADMN_DATE, f_query_add_mod.document.lab_test_rep.P_TO_ADMN_DATE) )
				
					f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
				f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.lab_test_rep.submit() ;
			}

	  
	  }
	
/* ----end KDAH-CRF-0032---*/
	
	
	if (f_query_add_mod.document.MRBNOTDL)
		
	{
		//if( f_query_add_mod.CheckString(getLabel("eMR.NotificationDate.label","MR"), f_query_add_mod.document.MRBNOTDL.P_FM_ADMN_DATE,f_query_add_mod.document.MRBNOTDL.P_TO_ADMN_DATE, messageFrame )  )
			//f_query_add_mod.document.MRBNOTDL.submit() ;
	
	
		var fields = new Array ( f_query_add_mod.document.MRBNOTDL.P_FM_ADMN_DATE,f_query_add_mod.document.MRBNOTDL.P_TO_ADMN_DATE);
		var names  = new Array ( "From Date","To Date");
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
			{
					
				if( doDateCheckAlert1(f_query_add_mod.document.MRBNOTDL.P_FM_ADMN_DATE, f_query_add_mod.document.MRBNOTDL.P_TO_ADMN_DATE) )
				
					f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
				f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.MRBNOTDL.submit() ;
			}
		
	}
  if (f_query_add_mod.document.MROPBKED)
	{
		
		if (f_query_add_mod.document.MROPBKED.p_location_type.value=='C')
		{
			var fields = new Array ( 		f_query_add_mod.document.MROPBKED.P_FM_DATE,f_query_add_mod.document.MROPBKED.P_TO_DATE);
			var names  = new Array ( getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"));			
		}
		else
		if (f_query_add_mod.document.MROPBKED.p_location_type.value=='E')
		{
			var fields = new Array ( f_query_add_mod.document.MROPBKED.P_FM_DATE,f_query_add_mod.document.MROPBKED.P_TO_DATE, f_query_add_mod.document.MROPBKED.P_FM_LOC_TYPE_CODE,f_query_add_mod.document.MROPBKED.P_TO_LOC_TYPE_CODE);
			var names  = new Array ( getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"), getLabel("eMR.FromProcedureUnit.label","MR"),getLabel("eMR.ToProcedureUnit.label","MR"));
		}
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
			if (f_query_add_mod.doDateCheck(f_query_add_mod.document.MROPBKED.P_FM_DATE,f_query_add_mod.document.MROPBKED.P_TO_DATE, messageFrame))
			if (f_query_add_mod.CheckString(getLabel("Common.speciality.label","Common"), f_query_add_mod.document.MROPBKED.P_FM_SPECIALITY_CODE,f_query_add_mod.document.MROPBKED.P_TO_SPECIALITY_CODE, messageFrame))
			if (f_query_add_mod.document.MROPBKED.p_location_type.value=='C')
			{
				if (f_query_add_mod.CheckString(getLabel("Common.clinic.label","Common"), f_query_add_mod.document.MROPBKED.P_FM_LOC_TYPE_CODE,f_query_add_mod.document.MROPBKED.P_TO_LOC_TYPE_CODE, messageFrame))
					f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
					f_query_add_mod.document.forms[0].target="messageFrame";
					f_query_add_mod.document.MROPBKED.submit() ;
			}
			else
			if (f_query_add_mod.document.MROPBKED.p_location_type.value=='E')
			{
				if (f_query_add_mod.CheckString(getLabel("Common.ProcedureUnit.label","Common"), f_query_add_mod.document.MROPBKED.P_FM_LOC_TYPE_CODE,f_query_add_mod.document.MROPBKED.P_TO_LOC_TYPE_CODE, messageFrame))
					f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
					f_query_add_mod.document.forms[0].target="messageFrame";
					f_query_add_mod.document.MROPBKED.submit() ;
			}
		}
	}
if (f_query_add_mod.document.MROPBKHC)
	{
		
		var fields = new Array ( f_query_add_mod.document.MROPBKHC.P_FM_DATE,f_query_add_mod.document.MROPBKHC.P_TO_DATE);
		var names  = new Array ( getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"));
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
			if (f_query_add_mod.checkmonths(getLabel("Common.RegnDate.label","Common"), f_query_add_mod.document.MROPBKHC.P_FM_DATE,f_query_add_mod.document.MROPBKHC.P_TO_DATE, messageFrame))
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
				f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.MROPBKHC.submit() ;
		}
	}
if (f_query_add_mod.document.MRIPCSMH)
	{	 
		
		var fields = new Array(f_query_add_mod.document.MRIPCSMH.p_fm_Date,f_query_add_mod.document.MRIPCSMH.p_to_Date);
		var reptype=f_query_add_mod.document.MRIPCSMH.report_type.value;
		if(reptype=="M")
		{		
		var names  = new Array ( getLabel("Common.FromMonth.label","Common"),getLabel("Common.ToMonth.label","Common"));
		}
		else if(reptype=="Y")
		{
		var names  = new Array ( getLabel("eIP.FromYear.label","IP"),getLabel("eIP.ToYear.label","IP"));
		}
		else
		{
			var names  = new Array ( getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"));
		}
		if(reptype=="M")
		{					  
	
		var names1  = new Array ( getLabel("Common.month.label","Common"));
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		    {
	     if( f_query_add_mod.checkmonths( names1,f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ) )
	    	 f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
			f_query_add_mod.document.forms[0].target="messageFrame";
		     f_query_add_mod.document.MRIPCSMH.submit() ;
			}	
		}
		else if(reptype=="Y")
		{
		var names1  = new Array ( getLabel("Common.year.label","Common"));
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		    {
		if( f_query_add_mod.CheckString( names1,f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ) )
			f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
		f_query_add_mod.document.forms[0].target="messageFrame";
		     f_query_add_mod.document.MRIPCSMH.submit() ;
			}
		}
		else
		{
			if(f_query_add_mod.checkFields( fields, names, messageFrame))
		    {
		   if( f_query_add_mod.doDateCheck(f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ) )
			   f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
			f_query_add_mod.document.forms[0].target="messageFrame";
		     f_query_add_mod.document.MRIPCSMH.submit() ;
			}
		}
		
	}
if (f_query_add_mod.document.MRIPCSEG)
	{	 
		
		var fields = new Array(f_query_add_mod.document.MRIPCSEG.p_fm_Date,f_query_add_mod.document.MRIPCSEG.p_to_Date);
		var reptype=f_query_add_mod.document.MRIPCSEG.report_type.value;
		if(reptype=="M")
		{		
		var names  = new Array ( getLabel("Common.FromMonth.label","Common"),getLabel("Common.ToMonth.label","Common"));
		}
		else if(reptype=="Y")
		{
		var names  = new Array ( getLabel("eIP.FromYear.label","IP"),getLabel("eIP.ToYear.label","IP"));
		}
		else
		{
			var names  = new Array ( getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"));
		}
		if(reptype=="M")
		{					  
	
		var names1  = new Array ( getLabel("Common.month.label","Common"));
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		    {
	     if( f_query_add_mod.checkmonths( names1,f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ) )
	    	 f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
			f_query_add_mod.document.forms[0].target="messageFrame";
		     f_query_add_mod.document.MRIPCSEG.submit() ;
			}	
		}
		else if(reptype=="Y")
		{
		var names1  = new Array ( getLabel("Common.year.label","Common"));
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		    {
		if( f_query_add_mod.CheckString( names1,f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ) )
			f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
		f_query_add_mod.document.forms[0].target="messageFrame";
		     f_query_add_mod.document.MRIPCSEG.submit() ;
			}
		}
		else
		{
			if(f_query_add_mod.checkFields( fields, names, messageFrame))
		    {
		   if( f_query_add_mod.doDateCheck(f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ) )
			   f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
			f_query_add_mod.document.forms[0].target="messageFrame";
		     f_query_add_mod.document.MRIPCSEG.submit() ;
			}
		}
		
	}
if (f_query_add_mod.document.MROPANPO)
	{	 
		
		var fields = new Array(f_query_add_mod.document.MROPANPO.p_fm_Date,f_query_add_mod.document.MROPANPO.p_to_Date);
		var reptype=f_query_add_mod.document.MROPANPO.report_type.value;
		if(reptype=="M")
		{		
		var names  = new Array ( getLabel("Common.FromMonth.label","Common"),getLabel("Common.ToMonth.label","Common"));
		}
		else if(reptype=="Y")
		{
		var names  = new Array ( getLabel("eIP.FromYear.label","IP"),getLabel("eIP.ToYear.label","IP"));
		}
		else
		{
			var names  = new Array ( getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"));
		}
		if(reptype=="M")
		{					  
	
		var names1  = new Array ( getLabel("Common.month.label","Common"));
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		    {
	     if( f_query_add_mod.checkmonths( names1,f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ) )
	    	 f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
			f_query_add_mod.document.forms[0].target="messageFrame";
		     f_query_add_mod.document.MROPANPO.submit() ;
			}	
		}
		else if(reptype=="Y")
		{
		var names1  = new Array ( getLabel("Common.year.label","Common"));
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		    {
		if( f_query_add_mod.CheckString( names1,f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ) )
			f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
		f_query_add_mod.document.forms[0].target="messageFrame";
		     f_query_add_mod.document.MROPANPO.submit() ;
			}
		}
		else
		{
			if(f_query_add_mod.checkFields( fields, names, messageFrame))
		    {
		   if( f_query_add_mod.doDateCheck(f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ) )
			   f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
			f_query_add_mod.document.forms[0].target="messageFrame";
		     f_query_add_mod.document.MROPANPO.submit() ;
			}
		}
		
	}

//modified by Sangeetha on 28/10/2016 for HSA-CRF-0025.1 
if (f_query_add_mod.document.MRCSWKDT)
	{
		var fields = new Array(f_query_add_mod.document.MRCSWKDT.P_FR_CENSUS_DATE,f_query_add_mod.document.MRCSWKDT.P_TO_CENSUS_DATE);
		var reptype=f_query_add_mod.document.MRCSWKDT.report_type.value;
		if(reptype=="M")
		{		
		var names  = new Array ( getLabel("Common.FromMonth.label","Common"),getLabel("Common.ToMonth.label","Common"));
		}
		else
		{
			var names  = new Array (  getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"));
		}
		if(reptype=="M")
		{					  
	
		var names1  = new Array ( getLabel("Common.month.label","Common"));
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		    {
	     if( f_query_add_mod.checkmonths( names1,f_query_add_mod.document.forms[0].P_FR_CENSUS_DATE, f_query_add_mod.document.forms[0].P_TO_CENSUS_DATE, messageFrame ) )
	    	 {
	    	 f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
			f_query_add_mod.document.forms[0].target="messageFrame";
		     f_query_add_mod.document.MRCSWKDT.submit() ;}
			}	
		}
		else if(reptype=="W")
		{
        var fields = new Array ( f_query_add_mod.document.MRCSWKDT.P_FR_CENSUS_DATE,f_query_add_mod.document.MRCSWKDT.P_TO_CENSUS_DATE);
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
		f_query_add_mod.document.forms[0].target="messageFrame";
			f_query_add_mod.document.MRCSWKDT.submit() ;
		}

		}
		else
		{
			if(f_query_add_mod.checkFields( fields, names, messageFrame))
		    {
		   if( f_query_add_mod.doDateCheck(f_query_add_mod.document.forms[0].P_FR_CENSUS_DATE, f_query_add_mod.document.forms[0].P_TO_CENSUS_DATE, messageFrame ) )
			   f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
			f_query_add_mod.document.forms[0].target="messageFrame";
		     f_query_add_mod.document.MRCSWKDT.submit() ;
			}
		}
		
	}

/*Added by Thamizh selvi on 7th Nov 2016 against HSA-CRF-0213 Start*/
if (f_query_add_mod.document.LeadingMorbidityMortality)
	{	

		
		var fields = new Array(f_query_add_mod.document.LeadingMorbidityMortality.p_fm_Date,f_query_add_mod.document.LeadingMorbidityMortality.p_to_Date);
		var reptype=f_query_add_mod.document.LeadingMorbidityMortality.report_type.value;
		
		if(reptype=="M")
		{	
			var names  = new Array ( getLabel("Common.from.label","Common")+" "+getLabel("Common.Discharge.label","Common")+" "+getLabel("Common.month.label","Common"),getLabel("Common.to.label","Common")+" "+getLabel("Common.Discharge.label","Common")+" "+getLabel("Common.month.label","Common"));
		}
		else if(reptype=="Y")
		{
			var names  = new Array ( getLabel("Common.from.label","Common")+" "+getLabel("Common.Discharge.label","Common")+" "+getLabel("Common.year.label","Common"),getLabel("Common.to.label","Common")+" "+getLabel("Common.Discharge.label","Common")+" "+getLabel("Common.year.label","Common"));
		}
		else
		{
			var names  = new Array ( getLabel("Common.from.label","Common")+" "+getLabel("Common.dischargedate.label","Common"),getLabel("Common.to.label","Common")+" "+getLabel("Common.dischargedate.label","Common"));	
		}
		
		
		if(reptype=="M")
		{					  
	
			var names1  = new Array ( getLabel("Common.Discharge.label","Common")+" "+getLabel("Common.month.label","Common"));
			if(f_query_add_mod.checkFields( fields, names, messageFrame))
			{
				if( f_query_add_mod.checkmonths( names1,f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ) )
				{
					if( f_query_add_mod.CheckString(getLabel('eMR.Chapter.label','MR'), f_query_add_mod.document.forms[0].p_from_chap,f_query_add_mod.document.forms[0].p_to_chap, messageFrame ))
					{
						if( f_query_add_mod.CheckTerm(getLabel("eMR.ICD10CODE.label","MR"), f_query_add_mod.document.forms[0].p_from_termcode,f_query_add_mod.document.forms[0].p_to_termcode, messageFrame )  )
							{
							
							f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
						f_query_add_mod.document.forms[0].target="messageFrame";
							f_query_add_mod.document.LeadingMorbidityMortality.submit() ;
							}
	
					}
				}
			}	
		}
		else if(reptype=="Y")
		{
			var names1  = new Array ( getLabel("Common.Discharge.label","Common")+" "+getLabel("Common.year.label","Common"));
			if(f_query_add_mod.checkFields( fields, names, messageFrame))
			{
				if( f_query_add_mod.CheckString( names1,f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ) )
				{
					if( f_query_add_mod.CheckString(getLabel('eMR.Chapter.label','MR'), f_query_add_mod.document.forms[0].p_from_chap,f_query_add_mod.document.forms[0].p_to_chap, messageFrame ))
					{
						if( f_query_add_mod.CheckTerm(getLabel("eMR.ICD10CODE.label","MR"), f_query_add_mod.document.forms[0].p_from_termcode,f_query_add_mod.document.forms[0].p_to_termcode, messageFrame )  ){
							
							f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
						f_query_add_mod.document.forms[0].target="messageFrame";
							f_query_add_mod.document.LeadingMorbidityMortality.submit() ;}
					}
				}
			}
		}
		else
		{
			if(f_query_add_mod.checkFields( fields, names, messageFrame))
			{
				if( doDateCheckAlertLocal( getLabel("Common.dischargedate.label","Common"),f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ) )
				{
					if( f_query_add_mod.CheckString(getLabel('eMR.Chapter.label','MR'), f_query_add_mod.document.forms[0].p_from_chap,f_query_add_mod.document.forms[0].p_to_chap, messageFrame ))
					{
						if( f_query_add_mod.CheckTerm(getLabel("eMR.ICD10CODE.label","MR"), f_query_add_mod.document.forms[0].p_from_termcode,f_query_add_mod.document.forms[0].p_to_termcode, messageFrame )  )
							{
							
							f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
						f_query_add_mod.document.forms[0].target="messageFrame";
							f_query_add_mod.document.LeadingMorbidityMortality.submit() ;}
					}
				}
			}
		}
		
	}
/*End*/

/*Added by Ashwini on 03-May-2019 for ML-MMOH-CRF-1292*/
if (f_query_add_mod.document.NIAReportForm)
{
		var fields = new Array(f_query_add_mod.document.NIAReportForm.p_fm_Date,f_query_add_mod.document.NIAReportForm.p_to_Date);
		var reptype = f_query_add_mod.document.NIAReportForm.report_type.value;
		if(reptype=="M")
		{	
			var names  = new Array ( getLabel("Common.from.label","Common")+" "+getLabel("Common.month.label","Common"),getLabel("Common.to.label","Common")+" "+getLabel("Common.month.label","Common"));
		}
		else if(reptype=="Y")
		{
			var names  = new Array ( getLabel("Common.from.label","Common")+" "+getLabel("Common.year.label","Common"),getLabel("Common.to.label","Common")+" "+getLabel("Common.year.label","Common"));
		}

		if(reptype=="M")
		{
			var names1  = new Array (getLabel("Common.month.label","Common"));
			if(f_query_add_mod.checkFields( fields, names, messageFrame))
			{
				if( f_query_add_mod.checkmonths( names1,f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ) )
				{
					f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
					f_query_add_mod.document.forms[0].target="messageFrame";
					f_query_add_mod.document.NIAReportForm.submit() ;
				}
			}	
		}
		else if(reptype=="Y")
		{
			var names1  = new Array (getLabel("Common.year.label","Common"));
			if(f_query_add_mod.checkFields( fields, names, messageFrame))
			{
				if( f_query_add_mod.CheckString( names1,f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ) )
				{f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
				f_query_add_mod.document.forms[0].target="messageFrame";
					f_query_add_mod.document.NIAReportForm.submit() ;
				}
			}
		}
		/*Added By Dharma on 28th Jan 2021 against ML-MMOH-CRF-1593 Start */
		else if(reptype=="6" || reptype =="12"){
			var names  = new Array (getLabel("Common.year.label","Common"));
			var fields = new Array(f_query_add_mod.document.NIAReportForm.p_year);
			if(f_query_add_mod.checkFields( fields, names, messageFrame)) {
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
				f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.NIAReportForm.submit() ;
			}
		}
		/*Added By Dharma on 28th Jan 2021 against ML-MMOH-CRF-1593 Start */ 
}
/*End ML-MMOH-CRF-1292*/

if (f_query_add_mod.document.MROPCSEG)
	{	 
		
		var fields = new Array(f_query_add_mod.document.MROPCSEG.p_fm_Date,f_query_add_mod.document.MROPCSEG.p_to_Date);
		var reptype=f_query_add_mod.document.MROPCSEG.report_type.value;
		if(reptype=="M")
		{		
		var names  = new Array ( getLabel("Common.FromMonth.label","Common"),getLabel("Common.ToMonth.label","Common"));
		}
		else if(reptype=="Y")
		{
		var names  = new Array ( getLabel("eIP.FromYear.label","IP"),getLabel("eIP.ToYear.label","IP"));
		}
		else
		{
			var names  = new Array (  getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"));
		}
		if(reptype=="M")
		{					  
	
		var names1  = new Array ( getLabel("Common.month.label","Common"));
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		    {
	     if( f_query_add_mod.checkmonths( names1,f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ) )
	    	 f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
			f_query_add_mod.document.forms[0].target="messageFrame";
		     f_query_add_mod.document.MROPCSEG.submit() ;
			}	
		}
		else if(reptype=="Y")
		{
		var names1  = new Array ( getLabel("Common.year.label","Common"));
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		    {
		if( f_query_add_mod.CheckString( names1,f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ) )
			f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
		f_query_add_mod.document.forms[0].target="messageFrame";
		     f_query_add_mod.document.MROPCSEG.submit() ;
			}
		}
		else
		{
			if(f_query_add_mod.checkFields( fields, names, messageFrame))
		    {
		   if( f_query_add_mod.doDateCheck(f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ) )
			   f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
			f_query_add_mod.document.forms[0].target="messageFrame";
		     f_query_add_mod.document.MROPCSEG.submit() ;
			}
		}
		
	}
	/*Mahesh*/
	if (f_query_add_mod.document.MRBRH212)
	{	 
		var fields = new Array(f_query_add_mod.document.MRBRH212.p_fm_Date,f_query_add_mod.document.MRBRH212.p_to_Date);
		var reptype=f_query_add_mod.document.MRBRH212.report_type.value;
		if(reptype=="M")
		{		
		var names  = new Array ( getLabel("Common.FromMonth.label","Common"),getLabel("Common.ToMonth.label","Common"));
		}
		else if(reptype=="Y")
		{
		var names  = new Array ( getLabel("eIP.FromYear.label","IP"),getLabel("eIP.ToYear.label","IP"));
		}
		else
		{
			var names  = new Array (  getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"));
		}
		if(reptype=="M")
		{					  
	
		var names1  = new Array ( getLabel("Common.month.label","Common"));
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		    {
	     if( f_query_add_mod.checkmonths( names1,f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ) )
		 
			/*Added by Ashwini on 21-Oct-2019 for ML-MMOH-CRF-1357*/
			if (f_query_add_mod.CheckString(getLabel("Common.NursingUnitCode.label","Common"), f_query_add_mod.document.forms[0].p_fm_care_code, f_query_add_mod.document.forms[0].p_to_care_code, messageFrame))
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
			f_query_add_mod.document.forms[0].target="messageFrame";
		     f_query_add_mod.document.MRBRH212.submit() ;
			}	
		}
		else if(reptype=="Y")
		{
		var names1  = new Array ( getLabel("Common.year.label","Common"));
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		    {
		if( f_query_add_mod.CheckString( names1,f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ) )
			
			/*Added by Ashwini on 21-Oct-2019 for ML-MMOH-CRF-1357*/
			if (f_query_add_mod.CheckString(getLabel("Common.NursingUnitCode.label","Common"), f_query_add_mod.document.forms[0].p_fm_care_code, f_query_add_mod.document.forms[0].p_to_care_code, messageFrame))
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
			f_query_add_mod.document.forms[0].target="messageFrame";
		     f_query_add_mod.document.MRBRH212.submit() ;
			}
		}
		else
		{
			if(f_query_add_mod.checkFields( fields, names, messageFrame))
		    {
		   if( f_query_add_mod.doDateCheck(f_query_add_mod.document.forms[0].p_fm_Date, f_query_add_mod.document.forms[0].p_to_Date, messageFrame ) )
			
		    /*Added by Ashwini on 21-Oct-2019 for ML-MMOH-CRF-1357*/
			if (f_query_add_mod.CheckString(getLabel("Common.NursingUnitCode.label","Common"), f_query_add_mod.document.forms[0].p_fm_care_code, f_query_add_mod.document.forms[0].p_to_care_code, messageFrame))
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
			f_query_add_mod.document.forms[0].target="messageFrame";
		     f_query_add_mod.document.MRBRH212.submit() ;
			}
		}
		
	}
	/*mahesh*/

//Added by sangeetha for HSA-CRF-211 on 17-Aug-2016
if(f_query_add_mod.document.MRBRH207){

    var fields = new Array ( f_query_add_mod.document.forms[0].p_fm_Date);
	var reptype=f_query_add_mod.document.getElementById('report_type').value;
	//Below added by Suji Keerthi for PAS-MR-ML-MMOH-CRF-1356-01-MR Other Report-PER RH-207
	    if(reptype=="D")
		{		
			var names  = new Array ( getLabel("Common.date.label","Common") );
			
		}
	//Ended by Suji Keerthi for PAS-MR-ML-MMOH-CRF-1356-01-MR Other Report-PER RH-207
		else if(reptype=="M")
		{		
			var names  = new Array ( getLabel("Common.month.label","Common") );
			
		}
		else if (reptype=="Y")
		{
			var names  = new Array ( getLabel("Common.year.label","Common") );
		}
            	
			if(f_query_add_mod.checkFields( fields, names, messageFrame))
		    {
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
				f_query_add_mod.document.forms[0].target="messageFrame";
		     f_query_add_mod.document.MRBRH207.submit() ;
			}
}

if (f_query_add_mod.document.MROPCSAT)
	{
		
		var fields = new Array ( f_query_add_mod.document.MROPCSAT.p_fm_Date,f_query_add_mod.document.MROPCSAT.p_to_Date);
		var reptype=f_query_add_mod.document.MROPCSAT.p_type.value;
		
		if(reptype=="M")
		{		
		var names  = new Array ( getLabel("Common.FromMonth.label","Common"),getLabel("Common.ToMonth.label","Common"));
		}
		else if(reptype=="Y")
		{
		var names  = new Array ( getLabel("eIP.FromYear.label","IP"),getLabel("eIP.ToYear.label","IP"));
		}
		else
		{
			var names  = new Array ( getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"));
		}
		if(reptype=="M")
		{		
		var names1  = new Array ( getLabel("Common.month.label","Common"));
		}
		else if(reptype=="Y")
		{
		var names1  = new Array ( getLabel("Common.year.label","Common"));
		}
		else
		{
			var names1  = new Array ( getLabel("Common.date.label","Common"));
		}
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{ 
			if (reptype=='M')
			{
				var names1 = new Array (escape(getLabel("Common.month.label","Common")))
				if( f_query_add_mod.checkmonths(names1, f_query_add_mod.document.MROPCSAT.p_fm_Date,f_query_add_mod.document.MROPCSAT.p_to_Date,messageFrame ))
					f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
				f_query_add_mod.document.forms[0].target="messageFrame";
					f_query_add_mod.document.MROPCSAT.submit() ;
			}
			if (reptype=='D')
			{
			if (f_query_add_mod.doDateCheck(f_query_add_mod.document.MROPCSAT.p_fm_Date,f_query_add_mod.document.MROPCSAT.p_to_Date, messageFrame))
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
			f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.MROPCSAT.submit() ;	
			}
			if (reptype=='Y')
			{
				var names1 = new Array (escape(getLabel("Common.year.label","Common")));
				if( f_query_add_mod.CheckString(names1, f_query_add_mod.document.MROPCSAT.p_fm_Date,f_query_add_mod.document.MROPCSAT.p_to_Date,messageFrame ))
					f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
				f_query_add_mod.document.forms[0].target="messageFrame";
					f_query_add_mod.document.MROPCSAT.submit() ;
			}

		}
	}
if (f_query_add_mod.document.RepTablistStat)
	{
 if(f_query_add_mod.document.forms[0].p_report_by.value=="DC"){
	var fields = new Array ( f_query_add_mod.document.RepTablistStat.p_patient_class,f_query_add_mod.document.RepTablistStat.p_diag_set,f_query_add_mod.document.RepTablistStat.P_FM_DATE,f_query_add_mod.document.RepTablistStat.P_TO_DATE,f_query_add_mod.document.RepTablistStat.p_range_id);
	   }
	  else{

		  var fields = new Array ( f_query_add_mod.document.RepTablistStat.p_patient_class,f_query_add_mod.document.RepTablistStat.p_diag_set,f_query_add_mod.document.RepTablistStat.P_FM_DATE,f_query_add_mod.document.RepTablistStat.P_TO_DATE);
	   }
		var diag_set_label=getLabel("Common.diagnosis.label","Common")+" "+getLabel("Common.Set.label","Common")
		var diag_patName_label=getLabel("Common.patientclass.label","Common");
		var Frm_Date_label=getLabel("Common.fromdate.label","Common");
		var To_Date_label=getLabel("Common.todate.label","Common");
		var Age_Range=getLabel("Common.AgeRange.label","Common");
		if(f_query_add_mod.document.forms[0].p_report_by.value=="DC"){

		var names  = new Array ( diag_patName_label,diag_set_label,Frm_Date_label,To_Date_label,Age_Range);
		}else{

		var names  = new Array ( diag_patName_label,diag_set_label,Frm_Date_label,To_Date_label);
		}

		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
			
			if (!chkGrtrDate(f_query_add_mod.document.RepTablistStat.P_FM_DATE,f_query_add_mod.document.RepTablistStat.P_TO_DATE))
			{
				return;
			}
			f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
			f_query_add_mod.document.forms[0].target="messageFrame";
			f_query_add_mod.document.RepTablistStat.submit() ;
		}





		/*if(f_query_add_mod.document.RepTablistStat.p_report_for.value=="P")
		{
		/*var fields = new Array (f_query_add_mod.document.RepTablistStat.P_FM_DATE,f_query_add_mod.document.RepTablistStat.P_TO_DATE);
		var names  = new Array ( getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"));*/
       /* var fields = new Array (f_query_add_mod.document.RepTablistStat.P_FM_DATE,f_query_add_mod.document.RepTablistStat.P_TO_DATE,f_query_add_mod.document.RepTablistStat.p_diag_set,f_query_add_mod.document.RepTablistStat.P_TO_DATE,f_query_add_mod.document.RepTablistStat.p_patient_class);
		var diag_set_label=getLabel("Common.diagnosis.label","Common")+" "+getLabel("Common.Set.label","Common")
		var diag_patName_label=getLabel("Common.patientclass.label");
		var names  = new Array ( getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"),diag_set_label,diag_patName_label);  

		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
			
			if (!chkGrtrDate(f_query_add_mod.document.RepTablistStat.P_FM_DATE,f_query_add_mod.document.RepTablistStat.P_TO_DATE))
			{
				return;
			}
			f_query_add_mod.document.RepTablistStat.submit() ;
		}
		}
		if(f_query_add_mod.document.RepTablistStat.p_report_for.value=="D")
		{
		var fields = new Array (f_query_add_mod.document.RepTablistStat.P_FM_DATE);
		var names  = new Array ( getLabel("Common.date.label","Common"));
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
			f_query_add_mod.document.RepTablistStat.submit() ;
		}
		}*/
	}


//added from repMorbidityStatsNatForm.jsp

if (f_query_add_mod.document.morbidity)
	{

		if(f_query_add_mod.document.morbidity.p_include_free_text_yn_val.value == 'Y')
			f_query_add_mod.document.morbidity.p_include_free_text_yn.value='Y';
		else
			f_query_add_mod.document.morbidity.p_include_free_text_yn.value='N';

		if(f_query_add_mod.document.morbidity.p_incl_nat_grp_val.value == 'Y')
			f_query_add_mod.document.morbidity.p_incl_nat_grp.value='Y';
		else
			f_query_add_mod.document.morbidity.p_incl_nat_grp.value='N';

		var fields = new Array ( f_query_add_mod.document.morbidity.range_id,f_query_add_mod.document.morbidity.p_diag_disp_opt,f_query_add_mod.document.morbidity.p_diag_set);
	    var names  = new Array ( getLabel("Common.AgeRange.label","Common"),getLabel("Common.print.label","Common"),getLabel("Common.diagnosis.label","Common")+' '+getLabel("Common.Set.label","Common"));
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
			if (f_query_add_mod.CheckString1(getLabel("Common.nationality.label","Common"), f_query_add_mod.document.morbidity.p_fm_nationality,f_query_add_mod.document.morbidity.p_to_nationality, messageFrame))

			//if (f_query_add_mod.checkmonths(getLabel("eMR.PrefMonth.label","MR"), f_query_add_mod.document.morbidity.pref_month_from,f_query_add_mod.document.morbidity.pref_month_to, messageFrame))
			//if (f_query_add_mod.CheckString(getLabel("eMR.PrefMonth.label","MR"), f_query_add_mod.document.morbidity.pref_month_from,f_query_add_mod.document.morbidity.pref_month_to, messageFrame))
			if (chkMthYr(getLabel("eMR.PrefMonth.label","MR"), f_query_add_mod.document.morbidity.pref_month_from,f_query_add_mod.document.morbidity.pref_month_to, messageFrame))
{
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
			f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.morbidity.submit() ;
				}
			
				
		}
	}

//added from repMorbidityStatsAge.js
if (f_query_add_mod.document.morbiditystat)
	{
		if(f_query_add_mod.document.morbiditystat.p_include_free_text_yn_val.value == 'Y')
			f_query_add_mod.document.morbiditystat.p_include_free_text_yn.value='Y';
		else
			f_query_add_mod.document.morbiditystat.p_include_free_text_yn.value='N';

		var fields = new Array ( f_query_add_mod.document.morbiditystat.range_id,f_query_add_mod.document.morbiditystat.p_diag_set);
	    var names  = new Array ( getLabel("Common.AgeRange.label","Common"),getLabel("Common.diagnosis.label","Common")+' '+getLabel("Common.Set.label","Common"));
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
			//if (f_query_add_mod.checkmonths(getLabel("eMR.PrefMonth.label","MR"),  f_query_add_mod.document.morbiditystat.pref_month_from,f_query_add_mod.document.morbiditystat.pref_month_to,messageFrame))
			//if (f_query_add_mod.CheckString(getLabel("eMR.PrefMonth.label","MR"),  f_query_add_mod.document.morbiditystat.pref_month_from,f_query_add_mod.document.morbiditystat.pref_month_to,messageFrame))
			if (chkMthYr(getLabel("eMR.PrefMonth.label","MR"),  f_query_add_mod.document.morbiditystat.pref_month_from,f_query_add_mod.document.morbiditystat.pref_month_to,messageFrame))
				{
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
				f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.morbiditystat.submit() ;
				
				}
		}
	}

// added from repMortalityStatsNat.js

if (f_query_add_mod.document.mortality)
	{
		if(f_query_add_mod.document.mortality.p_include_free_text_yn_val.value == 'Y')
			f_query_add_mod.document.mortality.p_include_free_text_yn.value='Y';
		else
			f_query_add_mod.document.mortality.p_include_free_text_yn.value='N';



		var fields = new Array ( f_query_add_mod.document.mortality.range_id,f_query_add_mod.document.mortality.p_diag_set);
	    var names  = new Array ( getLabel("Common.AgeRange.label","Common"),getLabel("Common.diagnosis.label","Common")+' '+getLabel("Common.Set.label","Common"));
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
			if (f_query_add_mod.CheckString1(getLabel("Common.nationality.label","Common"), f_query_add_mod.document.mortality.p_fm_nationality,f_query_add_mod.document.mortality.p_to_nationality, messageFrame))
			//if (f_query_add_mod.checkmonths(getLabel("eMR.PrefMonth.label","MR"), f_query_add_mod.document.mortality.pref_month_from,f_query_add_mod.document.mortality.pref_month_to, messageFrame))
			//if (f_query_add_mod.CheckString(getLabel("eMR.PrefMonth.label","MR"), f_query_add_mod.document.mortality.pref_month_from,f_query_add_mod.document.mortality.pref_month_to, messageFrame))
			if (chkMthYr(getLabel("eMR.PrefMonth.label","MR"), f_query_add_mod.document.mortality.pref_month_from,f_query_add_mod.document.mortality.pref_month_to, messageFrame))
				{
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
				f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.mortality.submit() ;
				}
				
		}
	}

// added form repMortalityStatsAge.js

if (f_query_add_mod.document.mortalityStatsAge)
	{

			if(f_query_add_mod.document.mortalityStatsAge.p_include_free_text_yn_val.value == 'Y')
			f_query_add_mod.document.mortalityStatsAge.p_include_free_text_yn.value='Y';
		else
			f_query_add_mod.document.mortalityStatsAge.p_include_free_text_yn.value='N';


		var fields = new Array ( f_query_add_mod.document.mortalityStatsAge.range_id,f_query_add_mod.document.mortalityStatsAge.p_diag_set);
	    var names  = new Array ( getLabel("Common.AgeRange.label","Common"),getLabel("Common.diagnosis.label","Common")+' '+getLabel("Common.Set.label","Common"));
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
			//if (f_query_add_mod.checkmonths(getLabel("eMR.PrefMonth.label","MR"), f_query_add_mod.document.mortalityStatsAge.pref_month_from,f_query_add_mod.document.mortalityStatsAge.pref_month_to, messageFrame))
			//if (f_query_add_mod.CheckString(getLabel("eMR.PrefMonth.label","MR"), f_query_add_mod.document.mortalityStatsAge.pref_month_from,f_query_add_mod.document.mortalityStatsAge.pref_month_to, messageFrame))
			if (chkMthYr(getLabel("eMR.PrefMonth.label","MR"), f_query_add_mod.document.mortalityStatsAge.pref_month_from,f_query_add_mod.document.mortalityStatsAge.pref_month_to, messageFrame))
				{
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
				f_query_add_mod.document.forms[0].target="messageFrame";
				
				f_query_add_mod.document.mortalityStatsAge.submit() ;
				}
				
		}
	}

	if(f_query_add_mod.document.repAppointmentsforopdBCP_Form)
	 {
			var fields = new Array ( f_query_add_mod.document.forms[0].p_fr_date,f_query_add_mod.document.forms[0].p_to_date);

			var names  = new Array ( getLabel("Common.FromAppointDate.label","Common"),getLabel("Common.TOAppointDate.label","Common"));

		//	var names  = new Array ( "From Appointment Date","To Appointment Date");
			if(f_query_add_mod.checkFields( fields, names, messageFrame))
			{
			if( f_query_add_mod.CheckString(getLabel("Common.locationcode.label","Common"), f_query_add_mod.document.forms[0].p_fr_locn_code,f_query_add_mod.document.forms[0].p_to_locn_code, messageFrame ) )
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
			f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.forms[0].submit();
	
			}
	 }
	 if(f_query_add_mod.document.repLabResultsListBCP_Form)
	{
			var fields = new Array ( f_query_add_mod.document.repLabResultsListBCP_Form.p_fr_nursing_unit);
			var names  = new Array (getLabel("Common.locationcode.label","Common"));
			if(f_query_add_mod.checkFields( fields, names, messageFrame))
				{
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
				f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.forms[0].submit(); 
				}
	}

	 	if(f_query_add_mod.document.repCurrentInpatientListBCP_Form)
	{
			if( f_query_add_mod.CheckString(getLabel("Common.locationcode.label","Common"), f_query_add_mod.document.forms[0].p_fr_locn_code,f_query_add_mod.document.forms[0].p_to_locn_code, messageFrame )  )
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
			f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.forms[0].submit();
	}

	if(f_query_add_mod.document.repInpatientAdmissionListBCP_Form)
	 {
			var fields = new Array ( f_query_add_mod.document.forms[0].p_fr_adm_date,f_query_add_mod.document.forms[0].p_to_adm_date);
			var names  = new Array ( getLabel("Common.FRPrefAdmissionDate.label","Common"),getLabel("Common.ToPrefAdmissionDate.label","Common"));

			if(f_query_add_mod.checkFields( fields, names, messageFrame))
			{
			if( f_query_add_mod.CheckString(getLabel("Common.locationcode.label","Common"), f_query_add_mod.document.forms[0].p_fr_locn_code,f_query_add_mod.document.forms[0].p_to_locn_code, messageFrame ) )
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
			f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.forms[0].submit();
	
			}

		 }
		 //Added for this CRF HSA-CRF-0225
	 if (f_query_add_mod.document.DischargeSummaryReport)
	{
	        var fields = new Array ( f_query_add_mod.document.forms[0].P_FM_DATE,f_query_add_mod.document.forms[0].P_TO_DATE);
			var names  = new Array ( getLabel("Common.from.label","Common")+" "+getLabel("Common.dischargedate.label","Common"),getLabel("Common.to.label","Common")+" "+getLabel("Common.dischargedate.label","Common"));

			if(f_query_add_mod.checkFields( fields, names, messageFrame))
			{ 
			 if (doDateCheckAlerTCheck(getLabel("Common.dischargedate.label","Common"), f_query_add_mod.document.forms[0].P_FM_DATE,f_query_add_mod.document.forms[0].P_TO_DATE, messageFrame))
			 if( f_query_add_mod.CheckString(getLabel('Common.NursingUnitCode.label','common'), f_query_add_mod.document.forms[0].P_NURSING_FROM,f_query_add_mod.document.forms[0].P_NURSING_TO, messageFrame ))
			 if( f_query_add_mod.CheckString(getLabel('Common.Discharge.label','common')+' '+getLabel('Common.practitionerid.label','common'), f_query_add_mod.document.forms[0].P_FM_PRACTITIONER,f_query_add_mod.document.forms[0].P_TO_PRACTITIONER, messageFrame )  )
	         if( f_query_add_mod.CheckString(getLabel('Common.speciality.label','common')+' '+getLabel('Common.code.label','common'), f_query_add_mod.document.forms[0].P_SPECIALITY_FROM,f_query_add_mod.document.forms[0].P_SPECIALITY_TO, messageFrame ))
             if( f_query_add_mod.CheckString(getLabel('Common.service.label','common'), f_query_add_mod.document.forms[0].P_SERVICE_FROM,f_query_add_mod.document.forms[0].P_SERVICE_TO, messageFrame )) 			 
            	 f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
				f_query_add_mod.document.forms[0].target="messageFrame";
            	 f_query_add_mod.document.forms[0].submit();
			  
	         }
	}		 
	//End
	/*Added By Dharma on 14th Nov 2018 against ML-MMOH-CRF-0735 [IN:062857] Start*/
	if(f_query_add_mod.document.searchFormRepDisposedPatDtls) {
		var fields="";
		var names="";
		var formObj=f_query_add_mod.document.searchFormRepDisposedPatDtls;
		var report_id = f_query_add_mod.document.searchFormRepDisposedPatDtls.p_report_id.value;
		var temp_val = getLabel("eMR.DisposedDate.label","MR"); // Modified by boopathi for ML-MMOH-CRF-0723.
		if(report_id == 'MRINPDTL')
			temp_val = getLabel("eMR.InactiveDate.label","MR");
		/*if(formObj.p_disp_fm_date.value=="" && formObj.p_disp_to_date.value=="" && formObj.p_dispose_pat_id.value==""){
			var error=getMessage("ANY_ONE_CRITERIA","common");		
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
			return false;
		}
		if(formObj.p_disp_fm_date.value!="" || formObj.p_disp_to_date.value!=""){*/
			var fields = new Array (formObj.p_disp_fm_date,formObj.p_disp_to_date);
			var names  = new Array ( getLabel("Common.from.label","Common")+" "+temp_val,getLabel("Common.to.label","Common")+" "+temp_val);
			if (f_query_add_mod.checkFields(fields, names, messageFrame) ) {
				if( doDateCheckAlertLocal( temp_val,formObj.p_disp_fm_date,formObj.p_disp_to_date, messageFrame ) )  {
					f_query_add_mod.document.forms[0].p_disp_to_date.value =	convertDate(f_query_add_mod.document.forms[0].p_disp_to_date.value,"DMY",localeName,"en");
					f_query_add_mod.document.forms[0].p_disp_fm_date.value =		convertDate(f_query_add_mod.document.forms[0].p_disp_fm_date.value,"DMY",localeName,"en");
					f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
					f_query_add_mod.document.forms[0].target="messageFrame";
					f_query_add_mod.document.forms[0].submit();
				 }else{
					 return false;
				 }
			 }else{
				 return false;
			 }
		/*}
		if(formObj.p_dispose_pat_id.value!="" ){
			f_query_add_mod.document.forms[0].submit();
		}*/
	}
	/*Added By Dharma on 14th Nov 2018 against ML-MMOH-CRF-0735 [IN:062857] End*/
	/*Added by Lakshmanan for ML-MMOH-CRF-2030 on 01-07-2023 Start*/
	if (f_query_add_mod.document.NotifiableDiagListReport)
	{
	        var fields = new Array ( f_query_add_mod.document.forms[0].P_FM_DATE,f_query_add_mod.document.forms[0].P_TO_DATE);
			var names  = new Array ( getLabel("Common.from.label","Common")+" "+getLabel("Common.date.label","Common"),getLabel("Common.to.label","Common")+" "+getLabel("Common.date.label","Common"));

			if(f_query_add_mod.checkFields( fields, names, messageFrame))
			{ 
			 if (doDateCheckAlerTCheck(getLabel("Common.DateRange.label","Common"), f_query_add_mod.document.forms[0].P_FM_DATE,f_query_add_mod.document.forms[0].P_TO_DATE, messageFrame)) 			 
				 f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
				f_query_add_mod.document.forms[0].target="messageFrame";
				 f_query_add_mod.document.forms[0].submit();
			  
	         }
	}		 
	/*Added by Lakshmanan for ML-MMOH-CRF-2030 on 01-07-2023 End*/
	
}
 //Added for this CRF HSA-CRF-0225
function doDateCheckAlerTCheck(str,from,to,messageFrame){
		var fromdate = from.value ;
		var todate = to.value ;
		var greg_fromDate = convertDate(fromdate,"DMY",localeName,"en");
		var greg_toDate = convertDate(todate,"DMY",localeName,"en");
		if(from.value!=""&& to.value!=""){
				
		if(f_query_add_mod.isBefore(greg_fromDate,greg_toDate,"DMY","en"))
		{
		 	return true;
		
		}
		else 
		{ 			
			var error=getLabel("Common.Dischargedatecheck.label","Common");			
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
			return false;
		}
		}
		return true;
}
 //End for this CRF HSA-CRF-0225

function chkMthYr(str,fromDate,toDate,messageFrame)
{
	if(fromDate.value != "" && toDate.value != "")
	{
		if( isBefore(fromDate.value,toDate.value,"MY",localeName) == false)
		{
			var error=getMessage("REMARKS_MUST_GR_EQUAL","common");
			
			error=error.replace("$",getLabel("Common.to.label","Common")+" "+str);
			error=error.replace("#",str);
            messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
            return false;
		}
		else
			return true;
	}
	else
		return true;
}

function chkGrtrDate(obj1,obj2)
{
	if( obj1.value != "" && obj2.value != "" )
	{
		if(isBefore(obj1.value,obj2.value,"DMY",localeName) == false)
		{
			var msg = getMessage("TO_DT_GR_EQ_FM_DT","SM");
			alert(msg);
			obj2.select();
			return false;
		}
		else
			return true;
	}
	else 
		return true;
}

// added from repProcEncounter.js
function disbutt(obj)
{
 if (obj.value!="")
		document.forms[0].encounter_id.disabled=false;
 else
		document.forms[0].encounter_id.disabled=true;
}

async function callSearchScreen(){
		var patientid=await PatientSearch('','','','','','','Y','','','OTHER');;
		if(patientid !=null)
		document.forms[0].p_patient_id.value = patientid;
		 document.forms[0].p_patient_id.focus();
		 if (document.forms[0].p_patient_id.value!="")
				document.forms[0].encounter_id.disabled=false;
		 else
				document.forms[0].encounter_id.disabled=true;
	}

function CheckNumVal(obj)
{
	if (parseInt(obj.value) <= 0)
	{
		alert(getMessage('IP_VAL_NOT_LESS_ZERO',"IP"));
		obj.select();
	}
	else
	{
		CheckNum(obj);
	}
}

 async function searchCoderepProcEnc(obj,target)
{
		var retVal = 	new String();
		var dialogHeight= "400px" ;
		var dialogWidth	= "700px" ;
		var dialogTop	= "95" ;

		var features	="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments	= "" ;
		retVal =await window.showModalDialog("../jsp/EncounterDisplayFrame.jsp?patient_id="+document.forms[0].p_patient_id.value+"&enc_type="+document.forms[0].p_enc_type.value,arguments,features);
		if(retVal !=null)
			target.value = retVal;
			target.focus();
}

function setValue(Obj)
{
	if(Obj.value == "S")
		document.forms[0].p_report_id.value = "MRRMICDS";
	else
		document.forms[0].p_report_id.value = "MRRMICDD";
}

function repvisibile()
{
		
	if(document.forms[0].p_report_by.value=="IP")
	{
	document.forms[0].p_report_id.value="MRBICDDT"
	/*document.getElementById("rep1").innerHTML=getLabel("eMR.ReportOn.label","MR")+'&nbsp;';
	document.getElementById("rep2").innerHTML='<SELECT NAME=p_report_on><option value=V>'+getLabel("eMR.Visited.label","MR")+'</option><option value=T>'+getLabel("eMR.Treated.label","MR")+'</option><option value=>'+getLabel("Common.Both.label","Common")+'</option></SELECT>';*/

	document.getElementById('r1').style.display="none";		
	document.getElementById('r2').style.display="none";
	document.getElementById('imgAgeGrop').style.display="none";
	}
	else
	{
	document.forms[0].p_report_id.value="MRBICDST"
	/*document.getElementById('rep1').innerHTML='&nbsp;';
	document.getElementById('rep2').innerHTML='&nbsp;';*/
	document.getElementById('r1').style.display="inline";		
	document.getElementById('r2').style.display="inline";
	document.getElementById('imgAgeGrop').style.display="inline";




	}
}

function mychange()
 {
	  if (document.getElementById('p_report_for').value=='D')
		  document.getElementById('MY2').innerHTML=getLabel("Common.date.label","Common")+"&nbsp;"
	  else
		   document.getElementById('MY2').innerHTML=getLabel("Common.fromdate.label","Common")+"&nbsp;"
	

	 if (document.getElementById('p_report_for').value=='P')
	 {
		document.getElementById('test').innerHTML=getLabel("Common.todate.label","Common");
		document.getElementById('test1').innerHTML="<input type='text' name='P_TO_DATE' id='P_TO_DATE' id='census_mth' maxlength='10' onBlur='validateDate(this);' size='10'><img  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].P_TO_DATE.select();return showCalendar('census_mth','dd/mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"; 		 
	 }	 else	 {
		document.getElementById('test').innerHTML="";
		document.getElementById('test1').innerHTML="";
	 }
 }

// added from repAdmRegForm.jsp

async function searchCode1repAdm(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "400px" ;
			var dialogWidth	= "700px" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
		   
			if(obj.name=="special")
			{
				tit=getLabel("Common.speciality.label","Common");
				sql="select speciality_code,short_Desc from am_speciality"; 
				search_code="speciality_code";
			    search_desc= "short_Desc";
			}
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);
			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}
	
	 function ValidStringrepAdm(event)
{
	if((((event.keyCode>=48) && (event.keyCode<=57))
		||((event.keyCode>=65) && (event.keyCode<=90))
		||((event.keyCode>=97) && (event.keyCode<=122))
		||(event.keyCode==42)||(event.keyCode==95)))
	{
		return true
	}
	else
	{	
		return false
	}
}

async function searchCode2repAdm(obj,target)
{
	var retVal = 	new String();
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var facility = document.forms[0].p_facility_id.value; 
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var tit="";
    var specfrom=  document.forms[0].P_FM_SPECIALITY_CODE.value
	var specto=  document.forms[0].P_TO_SPECIALITY_CODE.value
//Added By Rameswar on 30th Apr 2015 against  HSA-CRF-0194.1 IN:05353 
//Start
	var encntype= "";
	var whereClause	= "where facility_id=`"+facility+"`"; 
	var appl_patient_class	= ""; 
	if(document.forms[0].p_encounter_type!=null){
		encntype= document.forms[0].p_encounter_type.value;
	}

	if(obj.name=="P_FM_CLINIC") {
		tit=getLabel("Common.Location.label","Common");
		if(encntype=="DC") {
				appl_patient_class	= " and APPL_PATIENT_CLASS = `DC`";
		}else if(encntype=="IP") {
				appl_patient_class	= " and APPL_PATIENT_CLASS =`IP`";
		}
		
		sql = "select nursing_unit_code, short_desc from ip_nursing_unit "+whereClause+appl_patient_class;
		search_code="NURSING_UNIT_CODE";
		search_desc= "short_desc";	
	

	}
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

	if (!(retVal == null))
	{
		target.value=retVal;
	}
	else
		target.focus();
}

// added from repWklyReponDeathForm.java

function DateSetup()
{
var dates = document.forms[0].P_FR_CENSUS_DATE.value;
var dd = dates.split("/");
var dat = eval(dd[0]);
var dd1 = eval(dd[0])+6;
var mm = eval(dd[1]);
var yy = eval(dd[2]);
	if(mm=="04"||mm=="06"||mm=="09"||mm=="11")
	{
		if(dd1>"30")
		{
			var dd2 = dd1-30;
			mm = eval(dd[1])+1;
			document.forms[0].P_TO_CENSUS_DATE.value = dd2+"/"+mm+"/"+dd[2];
		}
		else
		{
			document.forms[0].P_TO_CENSUS_DATE.value = dd1+"/"+mm+"/"+dd[2];
		}
	}
	if(mm=="01"||mm=="03"||mm=="05"||mm=="07"
		||mm=="08"||mm=="10")
	{
		if(dd1>"31")
		{
			var dd2 = dd1-31;
			mm = eval(dd[1])+1;
			document.forms[0].P_TO_CENSUS_DATE.value = dd2+"/"+mm+"/"+dd[2];
		}
		else
		{
			document.forms[0].P_TO_CENSUS_DATE.value = dd1+"/"+mm+"/"+dd[2];
		}
	}
	if(mm=="12")
	{
		if(dd1>"31")
		{
			var dd2 = dd1-31;
			mm = "01";
			yy = eval(dd[2])+1;
			document.forms[0].P_TO_CENSUS_DATE.value = dd2+"/"+mm+"/"+yy;
		}
		else
		{
			document.forms[0].P_TO_CENSUS_DATE.value = dd1+"/"+mm+"/"+dd[2];
		}
	}
	else if(mm=="02")
	{
		if (yy % 100 == 0)
		{
			if (yy % 400 == 0)
			{
				if(dd1>"29")
				{
					var dd2 = dd1-29;
					mm = eval(dd[1])+1;
					document.forms[0].P_TO_CENSUS_DATE.value =dd2+"/"+mm+"/"+dd[2];
				}
				else
				{
				document.forms[0].P_TO_CENSUS_DATE.value = dd1+"/"+mm+"/"+dd[2];
				}
			}
		}
		else if ((yy % 4) == 0)
		{
			if(dd1>"29")
			{
				var dd2 = dd1-29;
				mm = eval(dd[1])+1;
				document.forms[0].P_TO_CENSUS_DATE.value = dd2+"/"+mm+"/"+dd[2];
			}
			else
			{
				document.forms[0].P_TO_CENSUS_DATE.value = dd1+"/"+mm+"/"+dd[2];
			}
		}
		else 
		{
			if(dd1>"28")
			{
				var dd2 = dd1-28;
				mm = eval(dd[1])+1;
				document.forms[0].P_TO_CENSUS_DATE.value = dd2+"/"+mm+"/"+dd[2];
			}
			else
			{
				document.forms[0].P_TO_CENSUS_DATE.value = dd1+"/"+mm+"/"+dd[2];
			}
		}
	}
}

// added from repIPCensusbyBedClassForm.jsp
function mychangerepIP()
 {
	 if (document.getElementById('report_type').value=='M')
	 {
		 document.forms[0].p_report_id.value="MRIPCSEG";
		 document.getElementById('MY1').innerHTML=getLabel("Common.month.label","Common")+"&nbsp;"
		  document.getElementById('MY').innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date' id='census_mth' maxlength='7' size='7' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('census_mth','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById('report_type').value=='Y')
	 {
		 document.forms[0].p_report_id.value="MRIPCSEG";
		 document.getElementById('MY1').innerHTML=getLabel("Common.year.label","Common")+"&nbsp;"
		 document.getElementById('MY').innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date' id='census_date' maxlength='4' size='4' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('census_date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	  else  if (document.getElementById('report_type').value=='D')
	 {
		 document.forms[0].p_report_id.value="MRIPCSEG";
		 document.getElementById('MY1').innerHTML=getLabel("Common.date.label","Common")+"&nbsp;"
		 document.getElementById('MY').innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date' id='census_date' maxlength='10' size='10'readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('census_date','dd/mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }

	  if (document.getElementById('report_type').value=='M')
	 {
		 document.forms[0].p_report_id.value="MRIPCSEG";
		  document.getElementById('MY3').innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='7' size='7' readonly onblur=\"ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById('report_type').value);\"><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById('report_type').value=='Y')
	 {
		
		 document.forms[0].p_report_id.value="MRIPCSEG";
		 document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='4' size='4' readonly onblur=\"ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById('report_type').value);\"><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	  else  if (document.getElementById('report_type').value=='D')
	 {
		 document.forms[0].p_report_id.value="MRIPCSEG";
		 document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date' maxlength='10' size='10' readonly onblur=\"ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById('report_type').value);\"><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','dd/mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
 }
 /*Mahesh*/
 function mychangerepDC212()
 {
	 if (document.getElementById('report_type').value=='M')
	 {
		 document.forms[0].p_report_id.value="MRBRH212";
		 document.getElementById("MY1").innerHTML=getLabel("Common.month.label","Common")+"&nbsp;"
		  document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='7' size='7' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById('report_type').value=='Y')
	 {
		 document.forms[0].p_report_id.value="MRBRH212";
		 document.getElementById("MY1").innerHTML=getLabel("Common.year.label","Common")+"&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='4' size='4' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 if (document.getElementById('report_type').value=='M')
	 {
		 document.forms[0].p_report_id.value="MRBRH212";
		  document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='7' size='7' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById('report_type').value=='Y')
	 {
		
		 document.forms[0].p_report_id.value="MRBRH212";
		 document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='4' size='4' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	
 }
 /*Mahesh*/

 //Added By Sangeetha for HSA-CRF-211 on 17-Aug-2016
 function mychangerepDC207()
 {
     //Below added by Suji Keerthi for ML-MMOH-CRF-1356 on Jan-22,2021
	 if (document.getElementById('report_type').value=='D')
	 {
		 document.getElementById("MY1").innerHTML=getLabel("Common.date.label","Common")+"&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='7' size='7' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','dd/mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 //Ended by Suji Keerthi for ML-MMOH-CRF-1356 on Jan-22,2021
	 else if (document.getElementById('report_type').value=='M')
	 {
		 document.getElementById("MY1").innerHTML=getLabel("Common.month.label","Common")+"&nbsp;"
		  document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date' maxlength='7' size='7' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById('report_type').value=='Y')
	 {
		 document.getElementById("MY1").innerHTML=getLabel("Common.year.label","Common")+"&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='4' size='4' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 
 } 
 

// added from repIPCensusinMatHospForm.java

function mychangerepIPCensusin()
 {
	 if (document.getElementById('report_type').value=='M')
	 {
		 document.forms[0].p_report_id.value="MRIPCSMH";
		 document.getElementById("MY1").innerHTML=getLabel("Common.month.label","Common")+"&nbsp;"
		  document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='7' size='7' readonly onblur=\"ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById('report_type').value);\"><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById('report_type').value=='Y')
	 {
		 document.forms[0].p_report_id.value="MRIPCSMH";
		 document.getElementById("MY1").innerHTML=getLabel("Common.year.label","Common")+"&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='4' size='4' readonly onblur=\"ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById('report_type').value);\"><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	  else  if (document.getElementById('report_type').value=='D')
	 {
		 document.forms[0].p_report_id.value="MRIPCSMH";
		 document.getElementById("MY1").innerHTML=getLabel("Common.date.label","Common")+"&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='10' size='10'readonly onblur=\"ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById('report_type').value);\"><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','dd/mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }

	  if (document.getElementById('report_type').value=='M')
	 {
		 document.forms[0].p_report_id.value="MRIPCSMH";
		  document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='7' size='7' readonly onblur=\"ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById('report_type').value);\"><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById('report_type').value=='Y')
	 {
		
		 document.forms[0].p_report_id.value="MRIPCSMH";
		 document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='4' size='4' readonly onblur=\"ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById('report_type').value);\"><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	  else  if (document.getElementById('report_type').value=='D')
	 {
		 document.forms[0].p_report_id.value="MRIPCSMH";
		 document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='10' size='10' readonly onblur=\"ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById('report_type').value);\"><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','dd/mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
 }			

// added from repIPCensusbyMorbidityForm.jsp



async function searchCoderepIPCensusbyMorbidity(obj,target)
	{		   
			var retVal = 	new String();
			var dialogHeight= "80vh" ;
			var dialogWidth	= "60vw" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			//var allfacilityid	=	document.repIPCensusbyMorbidityForm.p_all_facility_id.value;
			
       
            if(obj.name=="locn")
		{
			tit=getLabel("eMR.DiagnosisGroup.label","MR");
			sql="select DIAG_GROUP_CODE,DIAG_GROUP_DESC from mr_diag_group";
			search_code="DIAG_GROUP_CODE";
			search_desc= "DIAG_GROUP_DESC";
		}
		else
		{
		    tit=getLabel("eMR.TabulationList.label","MR");
			sql="select TAB_LIST_NO,SHORT_DESC from mr_tab_list";
			search_code="TAB_LIST_NO";
			search_desc= "SHORT_DESC";
		}


		
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}


function mychangerepIPCensusbyMorbidity()
 {
	 if (document.getElementById("p_type").value=='D')
	 {
		 document.forms[0].p_report_id.value="MRIPCSMB";
		 document.getElementById("MY1").innerHTML=getLabel("Common.date.label","Common")+"&nbsp;"
		  document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='10' size='8' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','dd/mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
		 //  document.getElementById("MY2").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date' id='census_dt1' maxlength='10' size='8' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('census_dt1','dd/mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 
	 }
	 else  if (document.getElementById("p_type").value=='M')
	 {
		 document.forms[0].p_report_id.value="MRIPCSMB";
		 document.getElementById("MY1").innerHTML=getLabel("Common.month.label","Common")+"&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='5' size='5' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
		 //document.getElementById("MY2").innerHTML = "<input type='text' name='p_to_Date'  id='census_mth1' maxlength='5' size='5' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('census_mth1','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById("p_type").value=='Y')
	 {
		 document.forms[0].p_report_id.value="MRIPCSMB";
		 document.getElementById("MY1").innerHTML=getLabel("Common.year.label","Common")+"&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='4' size='4' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
		 //document.getElementById("MY2").innerHTML = "<input type='text' name='p_to_Date'  id='census_date1' maxlength='4' size='4' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('census_date1','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
 }			


 // added from repIPAnnualCensusofBedForm.jsp
function ValidStringrepIPAnnual(event)
{
	if((event.keyCode>=48) && (event.keyCode<=57))
		
	{
		return true
	}
	else
	{	
		return false
	}
}

//added from repOPAttbySpclClinicForm.jsp

async function searchCoderepOPED(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "80vh" ;
			var dialogWidth	= "50vw" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
	       
			if(obj.name=="special")
			{
				tit=getLabel("Common.speciality.label","Common");
    			sql="select distinct SPECIALTY_CODE,SPECIALTY_DESC from XT_SPECIALTY_VW"; 
				search_code="SPECIALTY_CODE";
				search_desc= "SPECIALTY_DESC";
			}
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}
/* Added by Vinod on 10/20/2005 
	To change the Location type's Legend  on selecting List Values in  
*/
	function changeLocationType(obj)
	{
		if ( obj.value=='E')
		{
			document.getElementById('loc_type_legend').innerHTML=getLabel("Common.ProcedureUnit.label","Common")+"&nbsp ";
			document.getElementById('fm_loc_type').innerHTML="<input type=text onkeypress='return ValidStringrepOPED(event)' name='P_FM_LOC_TYPE_CODE' id='P_FM_LOC_TYPE_CODE' size='4' maxlength='4'><input type='button' name='special' id='special' value='?' class='button' onclick='searchCode1repOPED(this, P_FM_LOC_TYPE_CODE)'>&nbsp;<img id='mandatory1' align='center' src='../../eCommon/images/mandatory.gif'>";
			document.getElementById('to_loc_type').innerHTML="<input type=text onkeypress='return ValidStringrepOPED(event)' name='P_TO_LOC_TYPE_CODE' id='P_TO_LOC_TYPE_CODE' size='4' maxlength='4'><input type='button' name='special' id='special' value='?' class='button' onclick='searchCode1repOPED(this, P_TO_LOC_TYPE_CODE)'>&nbsp;<img id='mandatory1' align='center' src='../../eCommon/images/mandatory.gif'>";
		}
		else
		if ( obj.value=='C')
		{
			document.getElementById('loc_type_legend').innerHTML=getLabel("Common.clinic.label","Common")+"&nbsp";
			document.getElementById('fm_loc_type').innerHTML="<input type=text onkeypress='return ValidStringrepOPED(event)' name='P_FM_LOC_TYPE_CODE' id='P_FM_LOC_TYPE_CODE' size='4' maxlength='4'><input type='button' name='special' id='special' value='?' class='button' onclick='searchCode1repOPED(this, P_FM_LOC_TYPE_CODE)'>&nbsp;";
			document.getElementById('to_loc_type').innerHTML="<input type=text onkeypress='return ValidStringrepOPED(event)' name='P_TO_LOC_TYPE_CODE' id='P_TO_LOC_TYPE_CODE' size='4' maxlength='4'><input type='button' name='special' id='special' value='?' class='button' onclick='searchCode1repOPED(this, P_TO_LOC_TYPE_CODE)'>&nbsp;";
		}
	}
/* Added by Vinod on 10/20/2005 
	To default the Location type List box's value  on selecting Emergency  
*/
	function disableLocationType(obj)
	{
		if ( obj.value == 'EM' )
		{
			if (document.getElementById('p_location_type').value == 'E')
			{
				document.getElementById('p_location_type').value == 'C';
				document.getElementById('p_location_type').selectedIndex=0;
			}
			document.getElementById('p_location_type').disabled=true;
			document.getElementById('loc_type_legend').innerHTML=getLabel("Common.clinic.label","Common")+"&nbsp";
		}
		else
		if ( obj.value == 'OP' )
		{
			document.getElementById('p_location_type').disabled=false;
			document.getElementById('p_location_type').selectedIndex=0;
			document.getElementById('loc_type_legend').innerHTML=getLabel("Common.clinic.label","Common")+"&nbsp";
		}
		else
			document.getElementById('p_location_type').disabled=true;
		/* On change repaint the Clinic/PU and speciality fields*/
		document.getElementById('fm_loc_type').innerHTML="<input type=text onkeypress='return ValidStringrepOPED(event)' name='P_FM_LOC_TYPE_CODE' id='P_FM_LOC_TYPE_CODE' size='4' maxlength='4'><input type='button' name='special' id='special' value='?' class='button' onclick='searchCode1repOPED(this, P_FM_LOC_TYPE_CODE)'>&nbsp;";
		document.getElementById('to_loc_type').innerHTML="<input type=text onkeypress='return ValidStringrepOPED(event)' name='P_TO_LOC_TYPE_CODE' id='P_TO_LOC_TYPE_CODE' size='4' maxlength='4'><input type='button' name='special' id='special' value='?' class='button' onclick='searchCode1repOPED(this, P_TO_LOC_TYPE_CODE)'>&nbsp;";
		document.getElementById('fm_splty').innerHTML="<input type=text onkeypress='return ValidStringrepOPED(event)' name='P_FM_SPECIALITY_CODE' id='P_FM_SPECIALITY_CODE' size='4' maxlength='4'><input type='button' name='special' id='special' value='?' class='button' onclick='searchCoderepOPED(this, P_FM_SPECIALITY_CODE)'>&nbsp;";
		document.getElementById('to_splty').innerHTML="<input type=text onkeypress='return ValidStringrepOPED(event)' name='P_TO_SPECIALITY_CODE' id='P_TO_SPECIALITY_CODE' size='4' maxlength='4'><input type='button' name='special' id='special' value='?' class='button' onclick='searchCoderepOPED(this, P_TO_SPECIALITY_CODE)'>&nbsp;";
	}

	async function searchCode1repOPED(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "80vh" ;
			var dialogWidth	= "60vw" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
		   var specfrom=  document.forms[0].P_FM_SPECIALITY_CODE.value
	        var specto=  document.forms[0].P_TO_SPECIALITY_CODE.value
	 
			if(obj.name=="special")
			{
				if (document.getElementById('p_location_type').value == 'C')
				{
					tit=getLabel("Common.clinic.label","Common");
				}
				else
				if (document.getElementById('p_location_type').value == 'E')
				{
					tit=getLabel("Common.ProcedureUnit.label","Common");
				}
			if (document.forms[0].p_patient_class.value=='OP') 
			{
				 if (document.forms[0].p_location_type.value=='C')
				 {
		 			sql= "select clinic_code,long_desc from op_clinic  where SPECIALIST_CLINIC_YN=`Y` and CARE_LOCN_TYPE_IND =`C`" 
				 }
				 else
				 if (document.forms[0].p_location_type.value=='E')
				 {
		 			sql= "select clinic_code,long_desc from op_clinic  where CARE_LOCN_TYPE_IND =`E` " 
				 }
				//sql= "select clinic_code,short_desc from op_clinic  where LEVEL_OF_CARE_IND=`A` and speciality_code between `"+specfrom+"`and `"+specto+"` " 
			}
			else
			if(document.forms[0].p_patient_class.value=='EM')
			{
				sql= "select clinic_code,long_desc from op_clinic  where LEVEL_OF_CARE_IND=`E`and CARE_LOCN_TYPE_IND = `C`" 
			}		
			else
			{
				sql= "select clinic_code,long_desc from op_clinic  where ( LEVEL_OF_CARE_IND=`A` and SPECIALIST_CLINIC_YN=`Y` and CARE_LOCN_TYPE_IND = `C`) or LEVEL_OF_CARE_IND = `E` "
			}

			search_code="clinic_code";
			search_desc= "long_desc";
			}
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}
function ValidStringrepOPED(event)
{
	if((((event.keyCode>=48) && (event.keyCode<=57))
		||((event.keyCode>=65) && (event.keyCode<=90))
		||((event.keyCode>=97) && (event.keyCode<=122))
		||(event.keyCode==42)||(event.keyCode==95)))
	{
		return true
	}
	else
	{	
		return false
	}
}


//added from repOPAttbySpclClinicForm.jsp

	function mychangerepOPAtt()
 {
	 if (document.getElementById("p_type").value=='M')
	 {
		 document.forms[0].p_report_id.value="MROPCSAT";
		 document.getElementById("MY1").innerHTML=getLabel("Common.month.label","Common")+"&nbsp;"
		  document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date' maxlength='7' size='7' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById("p_type").value=='Y')
	 {
		 document.forms[0].p_report_id.value="MROPCSAT";
		 document.getElementById("MY1").innerHTML=getLabel("Common.year.label","Common")+"&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='4' size='4' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById("p_type").value=='D')
	 {
		 document.forms[0].p_report_id.value="MROPCSAT";
		 document.getElementById("MY1").innerHTML=getLabel("Common.date.label","Common")+"&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date' maxlength='10' size='10' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','dd/mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 if (document.getElementById("p_type").value=='M')
	 {
		 document.forms[0].p_report_id.value="MROPCSAT";
		 //document.getElementById("MY2").innerHTML="Month&nbsp;"
		  document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='7' size='7' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById("p_type").value=='Y')
	 {
		 document.forms[0].p_report_id.value="MROPCSAT";
		// document.getElementById("MY2").innerHTML="Year&nbsp;"
		 document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='4' size='4' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById("p_type").value=='D')
	 {
		 document.forms[0].p_report_id.value="MROPCSAT";
		// document.getElementById("MY2").innerHTML="Date&nbsp;"
		 document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='10' size='10' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','dd/mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
 }			
function ValidStringrepOPAtt(event)
{
	if((((event.keyCode>=48) && (event.keyCode<=57))
		||((event.keyCode>=65) && (event.keyCode<=90))
		||((event.keyCode>=97) && (event.keyCode<=122))
		||(event.keyCode==42)||(event.keyCode==95)))
	{
		return true
	}
	else
	{	
		return false
	}
}



// added from repOPReftoEmergencyForm.jsp


function mychangerepOPRefto()
 {
	 if (document.getElementById("p_type").value=='M')
	 {
		 document.forms[0].p_report_id.value="MROPRFLS";
		 document.getElementById("MY1").innerHTML=getLabel("Common.month.label","Common")+"&nbsp;"
		  document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='7' size='7' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById("p_type").value=='Y')
	 {
		 document.forms[0].p_report_id.value="MROPRFLS";
		 document.getElementById("MY1").innerHTML=getLabel("Common.year.label","Common")+"&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='4' size='4' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	  else  if (document.getElementById("p_type").value=='D')
	 {
		 document.forms[0].p_report_id.value="MROPRFLS";
		 document.getElementById("MY1").innerHTML=getLabel("Common.date.label","Common")+"&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date' maxlength='10' size='10'readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','dd/mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }

	  if (document.getElementById("p_type").value=='M')
	 {
		 document.forms[0].p_report_id.value="MROPRFLS";
		  document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='7' size='7' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById("p_type").value=='Y')
	 {
		
		 document.forms[0].p_report_id.value="MROPRFLS";
		 document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='4' size='4' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	  else  if (document.getElementById("p_type").value=='D')
	 {
		 document.forms[0].p_report_id.value="MROPRFLS";
		 document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='10' size='10' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','dd/mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }

 }
	async function searchCoderepOPRefto(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "80vh" ;
			var dialogWidth	= "60vw" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			//var facilityid = "<%=p_facility_id%>";
			var facilityid = document.forms[0].p_facility_id.value;
			
			
           
			tit=getLabel("Common.speciality.label","Common");
			sql="select distinct SPECIALTY_CODE,SPECIALTY_DESC from XT_SPECIALTY_VW";
			search_code="SPECIALTY_CODE";
			search_desc= "SPECIALTY_DESC";
			
		
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}

function ValidStringrepOPRefto(event)
{
	if((((event.keyCode>=48) && (event.keyCode<=57))
		||((event.keyCode>=65) && (event.keyCode<=90))
		||((event.keyCode>=97) && (event.keyCode<=122))
		||(event.keyCode==42)||(event.keyCode==95)))
	{
		return true
	}
	else
	{	
		return false
	}
}


// added from repOPMorbidityForm.jsp

	async function searchCoderepOPMorbidity(obj,target)
	{		   
			var retVal = 	new String();
			var dialogHeight= "80vh" ;
			var dialogWidth	= "60vw";
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var facilityid =document.forms[0].p_facility_id.value;

			var p_location_type1=document.forms[0].p_location_type1.value;
			//var allfacilityid	=	document.repIPCensusbyMorbidityForm.p_all_facility_id.value;
		/*	
            if(obj.name=="locn")
		{
		    tit=getLabel("Common.Location.label","Common");
			if	(document.forms[0].p_location_type1.value=="A")
			{
			sql="select clinic_code, long_desc from op_clinic where facility_id=`"+facilityid+"`  and level_of_Care_ind = `A` ";
			search_code="clinic_code";
			search_desc= "long_desc"
			}
			if	(document.forms[0].p_location_type1.value=="E")
			{
			sql="select clinic_code, long_desc from op_clinic where facility_id=`"+facilityid+"`  and level_of_Care_ind = `E` ";
			search_code="clinic_code";
			search_desc= "long_desc"
			}
		}
            if(obj.name=="tablist")
		{
            tit=getLabel("eMR.TabulationList.label","MR");
			sql="select TAB_LIST_NO,SHORT_DESC from mr_tab_list";
			search_code="TAB_LIST_NO";
			search_desc= "SHORT_DESC";
		}*/
		
			/*Added by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349*/
			if(obj.value=="")
			{
				
				tit=getLabel("Common.all.label","Common")+" "+getLabel("Common.clinic.label","Common");
				
				sql="SELECT a.clinic_code, b.short_desc FROM mr_report_per_pl206 a, op_clinic b where a.facility_id = b.facility_id and a.clinic_code = b.clinic_code and a.facility_id = `"+facilityid+"`";
 
				search_code="a.clinic_code";
				search_desc= "b.short_desc";
			}
			if(obj.value=="SC")
			{
				
				tit=getLabel("Common.SpecialistClinic.label","Common");
				
				sql="SELECT a.clinic_code, b.short_desc FROM mr_report_per_pl206 a, op_clinic b where a.facility_id = b.facility_id and a.clinic_code = b.clinic_code and a.facility_id = `"+facilityid+"` and a.service_code = `SC`";

				search_code="a.clinic_code";
				search_desc= "b.short_desc";
			}
			if(obj.value=="PU")
			{
				
				tit=getLabel("Common.PAC.label","Common");

				sql="SELECT a.clinic_code, b.short_desc FROM mr_report_per_pl206 a, op_clinic b where a.facility_id = b.facility_id and a.clinic_code = b.clinic_code and a.facility_id = `"+facilityid+"` and a.service_code = `PU`";
				 
				search_code="a.clinic_code";
				search_desc= "b.short_desc";
			}
			if(obj.value=="ED")
			{
				
				tit=getLabel("eMR.EmergencyDepartment.label","MR");

				sql="SELECT a.clinic_code, b.short_desc FROM mr_report_per_pl206 a, op_clinic b where a.facility_id = b.facility_id and a.clinic_code = b.clinic_code and a.facility_id = `"+facilityid+"` and a.service_code = `ED`";

				search_code="a.clinic_code";
				search_desc= "b.short_desc";
			}
			if(obj.value=="ST")
			{
				
				tit=getLabel("Common.Staff.label","Common")+" "+getLabel("Common.clinic.label","Common");
				
				sql="SELECT a.clinic_code, b.short_desc FROM mr_report_per_pl206 a, op_clinic b where a.facility_id = b.facility_id and a.clinic_code = b.clinic_code and a.facility_id = `"+facilityid+"` and a.service_code = `ST`";
								
				search_code="a.clinic_code";
				search_desc= "b.short_desc";
			}
			/*End ML-MMOH-CRF-1349*/

		
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit)+"&dispDescFirst=dispDescFirst",arguments,features);
			var ret1=unescape(retVal);

			if (!(retVal == null))
			{
				arr=ret1.split("::");
				target.value=arr[1];
				//Added by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349
				getVisitType();
			}
			else
				target.focus();
	}
 function mychangerepOPMorbidity()
 {  
          
	 if (document.getElementById('report_type').value=='M')
	 {   
	    if(document.getElementById("p_type").value=="D"){
		   document.forms[0].p_report_id.value="MROPCSMB";
		 }else{
		   document.forms[0].p_report_id.value="MROPCSMS"; 
		 }
		 
		 document.getElementById("MY1").innerHTML=getLabel("Common.month.label","Common")+"&nbsp;"
		  document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='7' size='7' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById('report_type').value=='Y')
	 {
	    if(document.getElementById("p_type").value=="D"){
		   document.forms[0].p_report_id.value="MROPCSMB";
		 }else{
		   document.forms[0].p_report_id.value="MROPCSMS"; 
		 }
		 
		 document.getElementById("MY1").innerHTML=getLabel("Common.year.label","Common")+"&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='4' size='4' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	  else  if (document.getElementById('report_type').value=='D')
	 {
	    if(document.getElementById("p_type").value=="D"){
		  document.forms[0].p_report_id.value="MROPCSMB";
		 }else {
		   document.forms[0].p_report_id.value="MROPCSMS";
		 }
		 document.getElementById("MY1").innerHTML=getLabel("Common.date.label","Common")+"&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='10' size='10'readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','dd/mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }

	 /* if (document.getElementById('report_type').value=='M')
	 {
		 document.forms[0].p_report_id.value="MROPCSMB";
		  //document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date' id='census_mth1' maxlength='7' size='7' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('census_mth1','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById('report_type').value=='Y')
	 {
		
		 document.forms[0].p_report_id.value="MROPCSMB";
		// document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date' id='census_date1' maxlength='4' size='4' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('census_date1','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	  else  if (document.getElementById('report_type').value=='D')
	 {
		 document.forms[0].p_report_id.value="MROPCSMB";
		 //document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date' id='census_date1' maxlength='10' size='10' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('census_date1','dd/mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }*/
 }
 
 /*Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349*/
 function clearvalrepOPMorbidity()
 {
	 document.forms[0].p_clinic.value = "";

	 var service_code = document.forms[0].p_location_type1.value;

	if(service_code == 'SC' || service_code == 'ST' || service_code == 'PU')
	{
		document.forms[0].p_visit_type.disabled = false;
	}else
	{
		document.forms[0].p_visit_type.disabled = true;
	}

	 /*if	(document.forms[0].p_location_type1.value=="")
	 {
	 document.forms[0].p_clinic.value="";
	 document.forms[0].locn.disabled=true;
	 document.forms[0].p_clinic.readOnly=true;
	 }
	 else
	 {
	 document.forms[0].p_clinic.value="";
	 document.forms[0].locn.disabled=false;
	 document.forms[0].p_clinic.readOnly=false;
	}*/
 }
 function ValidStringrepOPMorbidity(event)
{
	if((((event.keyCode>=48) && (event.keyCode<=57))
		||((event.keyCode>=65) && (event.keyCode<=90))
		||((event.keyCode>=97) && (event.keyCode<=122))
		||(event.keyCode==42)||(event.keyCode==95)))
	{
		return true
	}
	else
	{	
		return false
	}
}

// added from repOPAntePostForm.jsp

function mychangerepOPAntePost()
 {
	 if (document.getElementById('report_type').value=='M')
	 {
		 document.forms[0].p_report_id.value="MROPANPO";
		 document.getElementById("MY1").innerHTML=getLabel("Common.month.label","Common")+"&nbsp";
		  document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='7' size='7' readonly onblur='ValidateDt(this,this,document.getElementById(\"current_date\").document.getElementById(\"report_type\").value); ValidateDt(this,document.forms[0].p_to_Date,document.forms[0].current_date,document.getElementById(\"report_type\").value); ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\"report_type\").value);'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('p_fm_Date','mm/y',null);document.getElementById('p_fm_Date').blur();\" >&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>";
	 }

	 else  if (document.getElementById('report_type').value=='Y')
	 {
		 document.getElementById('p_report_id').value="MROPANPO";
		 document.getElementById("MY1").innerHTML=getLabel("Common.year.label","Common")+"&nbsp;";
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='4' size='4' readonly onblur='ValidateDt(this,this,document.forms[0].current_date,document.getElementById(\"report_type\").value); ValidateDt(this,document.forms[0].p_to_Date,document.forms[0].current_date,document.getElementById(\"report_type\").value); ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\"report_type\").value);'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('p_fm_Date','y',null);document.forms[0].p_fm_Date.blur();\" >&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>";
	 }
	  else  if (document.getElementById('report_type').value=='D')
	 {
		 document.forms[0].p_report_id.value="MROPANPO";
		 document.getElementById("MY1").innerHTML=getLabel("Common.date.label","Common")+"&nbsp;";
	 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='10' size='10' readonly onblur='ValidateDt(this,this,document.forms[0].current_date,document.getElementById(\"report_type\").value); ValidateDt(this,document.forms[0].p_to_Date,document.forms[0].current_date,document.getElementById(\"report_type\").value); ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\"report_type\").value);'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('p_fm_Date','dd/mm/y',null);document.forms[0].p_fm_Date.blur();\" >&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	
		/* var str = "<input type='text' name='p_fm_Date' id='p_fm_Date' id='census_date' maxlength='10' size='10' readonly " ;
		 str + ="	 Onblur='ValidateDt(this,document.forms[0].p_fm_Date,document.forms[0].current_date,document.getElementById('report_type'));" 		;
		 str+ =" ValidateDt(this,document.forms[0].p_to_Date,document.forms[0].current_date,document.getElementById('report_type')); " 					  ;
		 str+ =" ValidateDt(this,document.forms[0].p_fm_Date,document.forms[0].p_to_Date,document.getElementById('report_type'));'> " 					   ;
		 str + =" <input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('census_mth','mm/y',null);\" >&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>";
		 document.getElementById("MY").innerHTML = str;	
		 alert(str);									 */
	 }

	  if (document.getElementById('report_type').value=='M')
	 {
		 document.forms[0].p_report_id.value="MROPANPO";
		  document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date' maxlength='7' size='7' readonly onblur='ValidateDt(this,this,document.forms[0].current_date,document.getElementById(\"report_type\").value); ValidateDt(this,document.forms[0].p_fm_Date,document.forms[0].current_date,document.getElementById(\"report_type\").value); ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\"report_type\").value);'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('p_to_Date','mm/y',null);document.forms[0].p_to_Date.blur();\" >&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById('report_type').value=='Y')
	 {
		
		 document.forms[0].p_report_id.value="MROPANPO";
		 document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date' maxlength='4' size='4' readonly onblur='ValidateDt(this,this,document.forms[0].current_date,document.getElementById(\"report_type\").value); ValidateDt(this,document.forms[0].p_fm_Date,document.forms[0].current_date,document.getElementById(\"report_type\").value); ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\"report_type\").value);' ><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('p_to_Date','y',null);document.forms[0].p_to_Date.blur();\" >&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	  else  if (document.getElementById('report_type').value=='D')
	 {
		 document.forms[0].p_report_id.value="MROPANPO";
		// document.getElementById("MY").innerHTML="To&nbsp;"
		 document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='10' size='10' readonly onblur='ValidateDt(this,this,document.forms[0].current_date,document.getElementById(\"report_type\").value); ValidateDt(this,document.forms[0].p_fm_Date,document.forms[0].current_date,document.getElementById(\"report_type\").value); ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\"report_type\").value);'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('p_to_Date','dd/mm/y',null);document.forms[0].p_to_Date.blur();\" >&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
 }			

 /* Added By Vinod 12/22/2005
	 To validate date fields in reports PL-209 and PL-212.
	 -> Date fields should not accept future dates.  To should not be less then From Date.	  */
  function ValidateDt(obj,Date1,Date2,type)
  {
	  /* Date2 should be less than Date1
		  type determines whether the selected type is "D"ay ,"M"onth or "Y"ear
	  */
	  
	 
	  var error = getMessage('MRDATE1_GT_DATE2','MR');
	  if ( Date1.value=='' ||  Date2.value=='')
	  {
		  return ;
	  }
	  else
	  {
		  if (type=='D')
		  {
			  var frm = 	 Date1.value;
			  var to  = 	 Date2.value;
			  var frm_arr	= frm.split("/");
			  var to_arr	    = to.split("/");

			  /*Modified by Ashwini on 04-Feb-2019 for ML-MMOH-SCF-1145*/
			  var frm_date = new Date(frm_arr[2],frm_arr[1]-1,frm_arr[0]) ;
			  var to_date = new Date(to_arr[2],to_arr[1]-1,to_arr[0]) ;

			  if (Date.parse(to_date) < Date.parse(frm_date))
			  {
			      if (Date2.name=='current_date')
				  {
					  if (Date1.name=='p_fm_Date')
						  error = error.replace('$',getLabel("Common.DateFrom.label","Common"));
					  else
					   	  error = error.replace('$',getLabel("Common.todate.label","Common")); // For p_to_Date
					  error = error.replace('#',getLabel("Common.CurrentDate.label","Common"));
					  alert(error);
					  Date1.value='';
				      Date1.focus();
				  }
				  else
				  {
					  error = error.replace('$',getLabel("Common.DateFrom.label","Common"));
					  error = error.replace('#',getLabel("Common.todate.label","Common"));
					  alert(error);
					  //Date1.select();
					  if (obj.name=='p_fm_Date')
					  {
					  		Date1.value='';
							Date1.focus();
					  }
					  else
					  {
					  		Date2.value='';
							Date2.focus();
					  }
				  }
			  }
		  }
		  else
		  if (type=='M')
		  {
			  var frm			= 	 Date1.value;
			  var to			= 	 Date2.value;
			  var frm_arr	=	 frm.split("/");
			  var to_arr	    =   to.split("/");
			  var flag = false;
			  if (frm_arr.length==3)
			  {
				  frm_arr[0]= frm_arr[1]	 ;
				  frm_arr[1]= frm_arr[2]	 ;
			  }
			   if (to_arr.length==3)
			  {
				  to_arr[0]= to_arr[1]	 ;
				  to_arr[1]= to_arr[2]	 ;
			  }
			  if ( parseInt(to_arr[1]) < parseInt(frm_arr[1]) )
			  {
				 flag = true;
			  }
			  // Modified By Dharma on Aug 11th 2016 against ML-MMOH-SCF-0472 [IN:061192]
			  //else if  ( ( parseInt(to_arr[1]) <= parseInt(frm_arr[1]) ) &&  (parseInt(to_arr[0]) < parseInt(frm_arr[0])) )
			  else if  ( ( parseInt(to_arr[1]) <= parseInt(frm_arr[1]) ) &&  (to_arr[0].valueOf() < frm_arr[0].valueOf()) )
			  {
				  flag = true;
			  }

			  if (flag==true)
			  {
				   if (Date2.name=='current_date')
				  {
					  if (Date1.name=='p_fm_Date')
						  error = error.replace('$',getLabel("eMR.MonthFrom.label","MR"));
					  else
					   	  error = error.replace('$',getLabel("Common.ToMonth.label","Common")); // For p_to_Date
					  error = error.replace('#',getLabel("eMR.CurrentMonth.label","MR"));
					  alert(error);
					  //Date1.select();
					  Date1.value='';
				      Date1.focus();
				  }
				  else
				  {
					  error = error.replace('$',getLabel("eMR.MonthFrom.label","MR"));
					  error = error.replace('#',getLabel("Common.ToMonth.label","Common"));
					  alert(error);
					  if (obj.name=='p_fm_Date')
					  {
					  		Date1.value='';
							Date1.focus();
					  }
					  else
					  {
					  		Date2.value='';
							Date2.focus();
					  }
				  }
			  }
		  }
		  else
		  if (type=='Y')
		  {
			  var frm			= 	 Date1.value;
			  var to			= 	 Date2.value;
  			  var frm_arr	=	 '';
  			  var to_arr	    =   '';
			  if (frm.indexOf("/") != -1)
			  {
				  frm_arr	=	 frm.split("/");
				  if (frm_arr.length==3)
				  {
					  frm= frm_arr[2]	 ;
				  }
				  else
				  if (frm_arr.length==2)
				  {
					  frm= frm_arr[1]	 ;
				  }
			  }
			  if (to.indexOf("/") != -1)
			  {
				  to_arr	=	 to.split("/");
				  if (to_arr.length==3)
				  {
					  to= to_arr[2] ;
				  }
				  else
				  if (to_arr.length==2)
				  {
					  to= to_arr[1] ;
				  }
			  }
			  var flag = false;

			 if ( to < frm )
			 {
				   if (Date2.name=='current_date')
				  {
					  if (Date1.name=='p_fm_Date')
						  error = error.replace('$',getLabel("eMR.YearFrom.label","MR"));
					  else
					   	  error = error.replace('$',getLabel("eIP.ToYear.label","IP")); // For p_to_Date
					  error = error.replace('#',getLabel("Common.CurrentYear.label","Common"));
					  alert(error);
					  Date1.value='';
				      Date1.focus();
				  }
				  else
				  {
					  error = error.replace('$',getLabel("eMR.YearFrom.label","MR"));
					  error = error.replace('#',getLabel("eIP.ToYear.label","IP"));
					  alert(error);
					  if (obj.name=='p_fm_Date')
					  {
					  		Date1.value='';
							Date1.focus();
					  }
					  else
					  {
					  		Date2.value='';
							Date2.focus();
					  }
				  }
			 }
		  }
	  }
	  return;
  }


//added from repOPAttforEmgyDeptForm.jsp

 function mychangerepOPAttforEmgy()
 {
	 if (document.getElementById('p_type').value=='M')
	 {
		 document.forms[0].p_report_id.value="MROPCSED";
		 document.getElementById("MY1").innerHTML=getLabel("Common.month.label","Common")+"&nbsp;"
		  document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='7' size='7' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById("p_type").value=='Y')
	 {
		 document.forms[0].p_report_id.value="MROPCSED";
		 document.getElementById("MY1").innerHTML=getLabel("Common.year.label","Common")+"&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='4' size='4' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	  else  if (document.getElementById("p_type").value=='D')
	 {
		 document.forms[0].p_report_id.value="MROPCSED";
		 document.getElementById("MY1").innerHTML=getLabel("Common.date.label","Common")+"&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='10' size='10'readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','dd/mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }

	  if (document.getElementById("p_type").value=='M')
	 {
		 document.forms[0].p_report_id.value="MROPCSED";
		  document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='7' size='7' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById("p_type").value=='Y')
	 {
		
		 document.forms[0].p_report_id.value="MROPCSED";
		 document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='4' size='4' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	  else  if (document.getElementById("p_type").value=='D')
	 {
		 document.forms[0].p_report_id.value="MROPCSED";
		 document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='10' size='10' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('p_to_Date','dd/mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
 }	

// added from repAEAtttoEmgyDeptForm.jsp
 function mychangerepAEAttforEmgy()
 {
	 if (document.getElementById('report_type').value=='M')
	 {
		 document.forms[0].p_report_id.value="MRAECSCT";
		 document.getElementById("MY1").innerHTML=getLabel("Common.month.label","Common")+"&nbsp;"
		  document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date' id='census_mth' maxlength='7' size='7' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('census_mth','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById('report_type').value=='Y')
	 {
		 document.forms[0].p_report_id.value="MRAECSCT";
		 document.getElementById("MY1").innerHTML=getLabel("Common.year.label","Common")+"&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date' id='census_date' maxlength='4' size='4' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('census_date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	  else  if (document.getElementById('report_type').value=='D')
	 {
		 document.forms[0].p_report_id.value="MRAECSCT";
		 document.getElementById("MY1").innerHTML=getLabel("Common.date.label","Common")+"&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date' id='census_date' maxlength='10' size='10'readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('census_date','dd/mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }

	  if (document.getElementById('report_type').value=='M')
	 {
		 document.forms[0].p_report_id.value="MRAECSCT";
		  document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date' id='census_mth1' maxlength='7' size='7' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('census_mth1','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById('report_type').value=='Y')
	 {
		
		 document.forms[0].p_report_id.value="MRAECSCT";
		 document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date' id='census_date1' maxlength='4' size='4' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('census_date1','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	  else  if (document.getElementById('report_type').value=='D')
	 {
		 document.forms[0].p_report_id.value="MRAECSCT";
		 document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date' id='census_date1' maxlength='10' size='10' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('census_date1','dd/mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
 }
 			
		
// added from repOPAttbyRaceForm.jsp

 function ValidStringrepOPAttbyRace(event)
{
	if((((event.keyCode>=48) && (event.keyCode<=57))
		||((event.keyCode>=65) && (event.keyCode<=90))
		||((event.keyCode>=97) && (event.keyCode<=122))
		||(event.keyCode==42)||(event.keyCode==95)))
	{
		return true
	}
	else
	{	
		return false
	}
}
	
	async function searchCoderepOPAttbyRace(obj,target)
	{
			var loctype = document.forms[0].p_location_type.value;
			var facility = document.forms[0].p_facility_id.value;
			var retVal = 	new String();
			var dialogHeight= "28vh" ;
			var dialogWidth	= "43vw" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			if(obj.name=="clinic")
			{
				tit=getLabel("Common.clinic.label","Common");
				sql="select clinic_code, long_desc from op_clinic where facility_id=`"+facility+"` and CARE_LOCN_TYPE_IND=nvl(`"+loctype+"`,CARE_LOCN_TYPE_IND)"; 
				search_code="clinic_code";
				search_desc= "long_desc";
			}
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);
			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}

/*Modified by Ashwini on 27-Feb-2020 for ML-MMOH-SCF-1452*/
function clinicclearrepOPAttbyRace()
{
	document.forms[0].p_clinic.value = "";

	var service = document.forms[0].p_location_type.value;

	if(service == "")
	{
		document.forms[0].p_clinic.disabled = true;
		document.forms[0].clinic.disabled = true;
	}else
	{
		document.forms[0].p_clinic.disabled = false;
		document.forms[0].clinic.disabled = false;
	}
}
/*End ML-MMOH-SCF-1452*/

function mychangerepOPAttbyRace()
 {
	 if (document.getElementById('report_type').value=='M')
	 {
		 document.forms[0].p_report_id.value="MROPCSEG";
		 document.getElementById("MY1").innerHTML=getLabel("Common.month.label","Common")+"&nbsp;"
		  document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='7' size='7' readonly onblur='ValidateDt(this,this,document.forms[0].current_date,document.getElementById(\"report_type\").value); ValidateDt(this,document.forms[0].p_to_Date,document.forms[0].current_date,document.getElementById(\"report_type\").value); ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\"report_type\").value);'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('p_fm_Date','mm/y',null);document.forms[0].p_fm_Date.blur();\" >&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById('report_type').value=='Y')
	 {
		 document.forms[0].p_report_id.value="MROPCSEG";
		 document.getElementById("MY1").innerHTML=getLabel("Common.year.label","Common")+"&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='4' size='4' readonly onblur='ValidateDt(this,this,document.forms[0].current_date,document.getElementById(\"report_type\").value); ValidateDt(this,document.forms[0].p_to_Date,document.forms[0].current_date,document.getElementById(\"report_type\").value); ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\"report_type\").value);'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('p_fm_Date','y',null);document.forms[0].p_fm_Date.blur();\" >&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	  else  if (document.getElementById('report_type').value=='D')
	 {
		 document.forms[0].p_report_id.value="MROPCSEG";
		 document.getElementById("MY1").innerHTML=getLabel("Common.date.label","Common")+"&nbsp;"
	 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='10' size='10' readonly onblur='ValidateDt(this,this,document.forms[0].current_date,document.getElementById(\"report_type\").value); ValidateDt(this,document.forms[0].p_to_Date,document.forms[0].current_date,document.getElementById(\"report_type\").value); ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\"report_type\").value);'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('p_fm_Date','dd/mm/y',null);document.forms[0].p_fm_Date.blur();\" >&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }

	  if (document.getElementById('report_type').value=='M')
	 {
		 document.forms[0].p_report_id.value="MROPCSEG";
		  document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='7' size='7' readonly onblur='ValidateDt(this,this,document.forms[0].current_date,document.getElementById(\"report_type\").value); ValidateDt(this,document.forms[0].p_fm_Date,document.forms[0].current_date,document.getElementById(\"report_type\").value); ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\"report_type\").value);'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('p_to_Date','mm/y',null);document.forms[0].p_to_Date.blur();\" >&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById('report_type').value=='Y')
	 {
		
		 document.forms[0].p_report_id.value="MROPCSEG";
		 document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='4' size='4' readonly onblur='ValidateDt(this,this,document.forms[0].current_date,document.getElementById(\"report_type\").value); ValidateDt(this,document.forms[0].p_fm_Date,document.forms[0].current_date,document.getElementById(\"report_type\").value); ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\"report_type\").value);' ><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('p_to_Date','y',null);document.forms[0].p_to_Date.blur();\" >&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	  else  if (document.getElementById('report_type').value=='D')
	 {
		 document.forms[0].p_report_id.value="MROPCSEG";
		 document.getElementById("MY3").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date'  maxlength='10' size='10' readonly onblur='ValidateDt(this,this,document.forms[0].current_date,document.getElementById(\"report_type\").value); ValidateDt(this,document.forms[0].p_fm_Date,document.forms[0].current_date,document.getElementById(\"report_type\").value); ValidateDt(this,p_fm_Date,p_to_Date,document.getElementById(\"report_type\").value);'><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"return showCalendar('p_to_Date','dd/mm/y',null);document.forms[0].p_to_Date.blur();\" >&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
 }			

 //  Function Cancer Notification / Regestry Form 
 //added from  repWEHUADRequestCriteria.jsp


 function submitFormrepWEHUADReqCri(event)
{
	var strCheck = '0123456789:/ ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}

/*function CompareSysDate(obj,sysdate)
{
	var fromdate = obj.value;
	var SystemDate = sysdate.value;

	var result = "Pass";
	if(fromdate != '')
	{
		if (ValidateDateTime(obj,sysdate))
		{
//			alert(self.getMessage('DIS_DATE_NOT_LESS_ADM_DATE','IP'));
			alert("Encounter Period From cannot be less than System Date")
			obj.select();
			obj.focus();
			result = "Fail";
		}

		if(result == "Pass")
		{
			CompareDateTime(obj,document.forms[0].alt_id2_exp_date);
		}
	}
}

function CompareDateTime(obj1,obj2)
{
	if(obj1.value != '' && obj2.value != '')
	{
		if (ValidateDateTime(obj2,obj1))
		{
//			alert(self.getMessage('DIS_DATE_NOT_LESS_ADM_DATE','IP'));
			alert("Encounter Period To cannot be less than Encounter Period From")
			obj2.select();
			obj2.focus();

		}
	}
}
*/

/*^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^*/
//// CODED ON 05 AUG 2004 BY SRIDHAR 
//// FUNC USED TO COMPARE [PERIOD FROM] DATE WITH [PERIOD TO] 
//// Func will return an alert message if TO DATE is Less than FROM DATE
function ComparePeriodFromToTimerepWEHUADReqCri(from,to)
{
	
	var continue_YN = "";
		
		if(to.value != '' )
		{
			if(!doDateTimeChk(to))
			{
				continue_YN = "N";
				alert( getMessage("INVALID_DATE_TIME",'SM') );
				to.focus();
				to.select();
				return ;
			}
			else
				continue_YN = "Y";
			
			var a=to.value.split(" ")
			splitdate=a[0];
			if(!CheckZeroMonthsrepWEHUADReqCri(splitdate))
			{
				continue_YN = "N";
				alert( getMessage("INVALID_DATE_TIME",'SM') );
				to.focus();
				to.select();
				return ;
			}
			else
				continue_YN = "Y";
		}

		if(from.value != '' )
		{
			if(!doDateTimeChk(from))
			{
				continue_YN = "N";
				alert( getMessage("INVALID_DATE_TIME",'SM') );
				from.focus();
				from.select();
				return ;
			}
			else
				continue_YN = "Y";

			var a=from.value.split(" ")
			splitdate=a[0];
			if(!CheckZeroMonthsrepWEHUADReqCri(splitdate))
			{
				continue_YN = "N";
				alert( getMessage("INVALID_DATE_TIME",'SM') );
				from.focus();
				from.select();
				return ;
			}
			else
				continue_YN = "Y";
		}


	if(continue_YN == "Y")
	{
		if(from.value != '' && to.value != '')
		{
			var frdt = from.value;
			var tdt = to.value;
			PeriodcheckDateTimerepWEHUADReqCri(frdt,tdt);
		}
		else
			return ;
	}

}

/// ADDED by SRIDHAR R On 01 OCT 2004
/// This function will check for month value... It will fire an alert msg if the month contains zeroes...
function CheckZeroMonthsrepWEHUADReqCri(Object2) 
{
	var datefield = Object2;
    if (MonthChkrepWEHUADReqCri(Object2) == false) 
	{
        return false;
    }
    else 
	{
        return true;
    }
}

function MonthChkrepWEHUADReqCri(Object3) 
{
    var strDate;
    var strDay;
    var strMonth;
    var strYear;
    var datefield = Object3;
    var strDateArray = new Array();

    strDate = datefield;
    if (strDate.length == 0) return true;

if(Object3.indexOf('.') > 0) return false;

    strDateArray = strDate.split("/");
    if (strDateArray.length != 3) {
        return false;
    }
    else {
        strDay = strDateArray[0];
        strMonth = strDateArray[1];
        strYear = strDateArray[2];
    }


    if (strYear.length < 4 || strYear.length > 4) return false;

    if (isNaN(strDay)==true) return false;
    if (isNaN(strMonth)==true) return false;
    if (isNaN(strYear)==true) return false;

    if (strYear < 1800) return false;

        if (strMonth>12 || strMonth<1)  return false;

    if ((strMonth == 1 || strMonth == 3 || strMonth == 5 || strMonth == 7 || strMonth == 8 || strMonth == 10 || strMonth == 12) && (strDay > 31 || strDay < 1)) return false;

    if ((strMonth == 4 || strMonth == 6 || strMonth == 9 || strMonth == 11) && (strDay > 30 || strDay < 1)) return false;

    if (strMonth == 2) {
        if (strDay < 1) return false;

        if (LeapYear(strYear) == true) {
            if (strDay > 29) return false;
        }
        else {
            if (strDay > 28) return false;
        }
    }
    return true;
}


function PeriodcheckDateTimerepWEHUADReqCri(obj1,obj2)
{	
	var a=obj1.split(" ")
	splitdate=a[0];
	splittime=a[1]

	var splitdate1 = a[0].split("/")
	var splittime1 = a[1].split(":")

	 var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]));

	 a=obj2.split(" ")
	 splitdate=a[0];
	 splittime=a[1]

	 splitdate1 = a[0].split("/")
	 splittime1 = a[1].split(":")

	 var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]));

	 if(Date.parse(to_date) < Date.parse(from_date))
	{
		alert( getMessage("TO_DT_GR_EQ_FM_DT",'SM') );
		document.forms[0].alt_id2_exp_date.focus();
		document.forms[0].alt_id2_exp_date.select();
		return false;
	}
}

function clearAllrepWEHUADReqCri()
{	
	parent.frames[2].document.location.href ='../../eCommon/html/blank.html';
	if(parent.frames[3])
	parent.frames[3].document.location.reload();
	if(parent.messageFrame)
	parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
			
}

function callSearchScreenrepWEHUADReqCri()
{
	var patientid=PatientSearch('','','','','','','Y','','','VIEW');
	
	if(patientid !=null)
	document.forms[0].PatientId.value = patientid; 
	document.forms[0].PatientId.focus();
}


function CheckNumValrepWEHUADReqCri(obj)
{
	if (parseInt(obj.value) <= 0)
	{
		alert(getMessage('IP_VAL_NOT_LESS_ZERO',"IP"));
		obj.select();
	}
	else
	{
		CheckNum(obj);
	}
}

// added from repWEHUADRequestResult.jsp


		async function RecodeDiagnosisrepWEHUADReqRes(encID, PatID)
		{
			var call_function = document.forms[0].call_function.value;
			var FacilityId = document.forms[0].FacilityId.value;
			var dialogHeight= "29vh" ;
			var dialogWidth = "50vw" ;
			var dialogTop 	= "58";
			var center = "1" ;
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;
			retVal =await 	window.showModalDialog("../../eMR/jsp/repWEHUADRecodeDiagnosis.jsp?Encounter_Id="+encID+"&FacilityId="+FacilityId+"&PatientId="+PatID+"&call_function="+call_function,arguments,features);

			//parent.frames[0].document.forms[0].reset.onclick();
			//parent.frames[1].document.forms[0].clear.onclick();
		}

		function submitPrevNextrepWEHUADReqRes(from, to)
		{
			if(document.forms[0].chkAll)
			{
					if(document.forms[0].chkAll.checked)
					{
						document.forms[0].chkAll.checked = true;
					}
					else
					{
						document.forms[0].chkAll.checked = false;
					}
			}
			document.forms[0].finalSelect.value=document.forms[0].temp1.value;
			document.forms[0].from.value = from;
			document.forms[0].to.value = to; 
			document.forms[0].submit();
		}
		 

		function closeWinrepWEHUADReqRes(enc,patid,changefunc,Patient_Class)
		{
			showModalCurEncrepWEHUADReqRes(enc,patid,changefunc,Patient_Class);
		}

		async function showModalCurEncrepWEHUADReqRes(enc,patid,changefunc,Patient_Class)
		{
			//var bl_install_yn=document.forms[0].bl_install;
			var call_function = document.forms[0].call_function.value;

			var jsp_name="CurrentEncounterMain.jsp";
			var win_height = "30.8vh";
			var win_width= "50vw";
			var retVal = 	new String();
			var dialogHeight= win_height ;
			var dialogWidth	= win_width ;
			var dialogTop = "58" ;
			var center = "1" ;
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;
			retVal =await window.showModalDialog("../../eMR/jsp/"+jsp_name+"?encounterId="+enc+"&call_function="+call_function+"&patientId="+patid+"&Patient_Class="+Patient_Class,arguments,features);
			if(retVal!=null && retVal!='')

			parent.frames[2].document.location.reload();
		}

// added from repWEHUADDiagnosisQueryResult.jsp


function submitFormrepWEHUADiagQRes(code,recordNo)
{
	document.forms[0].diag_code.value = code;
	document.forms[0].recordNo.value = recordNo;

	var replaceTxt  = "";

		if(document.forms[0].call_function.value == "MRBWEHUA")
			replaceTxt  = getLabel("eMR.WEHUA1A2.label","MR");
		if(document.forms[0].call_function.value == "MRBWEHUD")
			replaceTxt  = getLabel("eMR.WEHUD1D2.label","MR");
		if(document.forms[0].call_function.value == "MRBCANNT")
			replaceTxt  = getLabel("eMR.CancerNotificationRegistryForm.label","MR");


	var error = getMessage('MR_CONFIRM_PRINT','MR');
	error = error.replace('#',replaceTxt);
	var	proceed = confirm(error);
							
	if(proceed)
	{
		document.forms[0].action="../../servlet/eMR.RepWEHUADDiagServlet";
		document.forms[0].submit();
	}
}



//added from repMorbidityStatsNatForm.jsp
async function searchCoderepMorbidityStatsNat(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "400px" ;//28
			var dialogWidth	= "700px";//43
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			if(obj.name=="locn")
			{
				tit=getLabel("Common.nationality.label","Common");
				sql="select country_code, long_desc from mp_country_lang_vw where language_id=`"+localeName+"`";
				search_code="country_code";
				search_desc= "long_desc";
			}

			if(obj.name=="locn1")
			{
				tit=getLabel("Common.nationality.label","Common");
				sql="select country_code, long_desc from mp_country_lang_vw where language_id=`"+localeName+"`";
				search_code="country_code";
				search_desc= "long_desc";
			}
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}


// added from repMortalityStatsNatForm.jsp

async function searchCodeMortalityStats(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "400px" ;//28
			var dialogWidth	= "700px" ;//43
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			if(obj.name=="locn")
			{
				tit=getLabel("Common.nationality.label","Common");
				sql="select country_code, long_desc from mp_country_lang_vw where language_id=`"+localeName+"`";
				search_code="country_code";
				search_desc= "long_desc";
			}

			if(obj.name=="locn1")
			{
				tit=getLabel("Common.nationality.label","Common");
				sql="select country_code, long_desc from mp_country_lang_vw where language_id=`"+localeName+"`";
				search_code="country_code";
				search_desc= "long_desc";
			}
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal =await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}


// added from repDischargeStatbyWardICDAge.js

	
async function searchCodeDischargeStat(obj,target)
    {
	        
            var retVal =    new String();
            var dialogHeight= "90vh" ;
            var dialogWidth = "80vw" ;
            var status = "no";
            var arguments   = "" ;
            var sql="";
            var search_code="";
            var search_desc="";
            var tit="";
            var facilityid =document.forms[0].p_facility_id.value;
            if(obj.name=="nursing_unit")
            {
                tit=getLabel("Common.nursingUnit.label","Common");
                sql="select Nursing_unit_code, short_desc from IP_NURSING_UNIT_LANG_VW where Facility_id = `"+facilityid+"` and language_id=`"+localeName+"`";
                search_code="Nursing_unit_code";
                search_desc= "short_desc"
                facilityid = "facility_id";
            }

            var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
            retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);
         
		
			 
            if (!(retVal == null))
            {
                target.value=retVal;
            }
            else
                target.focus();
    }


//added from repBirthRegisterForm.jsp
 async function searchCoderepBirth(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "400px" ;
			var dialogWidth	= "700px" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			if(obj.name=="locn")
			{
				tit=getLabel("eMR.TypeofDelivery.label","MR");
				//sql="select NOD_TYPE, short_desc from mp_nod_type"; 
				sql="select NOD_TYPE, short_desc from mp_nod_type_lang_vw where language_id=`"+localeName+"` ";
				search_code="NOD_TYPE";
				search_desc= "short_desc";
			}
			else if(obj.name=="locn1")
			{
				tit=getLabel("eMR.TypeofDelivery.label","MR");
				//sql="select NOD_TYPE, short_desc from mp_nod_type"; 
				sql="select NOD_TYPE, short_desc from mp_nod_type_lang_vw where language_id=`"+localeName+"` ";
				search_code="NOD_TYPE";
				search_desc= "short_desc";
			}
			else if(obj.name=="Pract")
			{
				tit=getLabel("Common.AttendingPractitioner.label","Common");
				//sql="SELECT practitioner_id, practitioner_name FROM  am_practitioner"; 
				sql= "SELECT practitioner_id, practitioner_name FROM  am_practitioner_lang_vw where language_id=`"+localeName+"` ";
				search_code="practitioner_id";
				search_desc= "practitioner_name";
			}
			else if(obj.name=="Nurse")
			{
				tit=getLabel("eMP.AttendingNurse.label","MP");
				//sql="SELECT practitioner_id, practitioner_name FROM  am_practitioner"; 
				sql="SELECT practitioner_id, practitioner_name FROM  am_practitioner_lang_vw where language_id=`"+localeName+"` ";
				search_code="practitioner_id";
				search_desc= "practitioner_name";
			}
			else if(obj.name=="Cunurse")
			{
				tit=getLabel("eMR.AttendingCommunityNurse.label","MR");
				//sql="SELECT practitioner_id, practitioner_name FROM  am_practitioner"; 
				sql="SELECT practitioner_id, practitioner_name FROM  am_practitioner_lang_vw where language_id=`"+localeName+"` ";
				search_code="practitioner_id";
				search_desc= "practitioner_name";
			}
			else if(obj.name=="Nationlty")
			{
				tit=getLabel("Common.nationality.label","Common");
				sql="select country_code, long_desc from mp_country_lang_vw where language_id=`"+localeName+"`";
				search_code="country_code";
				search_desc= "long_desc";
			}
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);
			var ret1=unescape(retVal);
		/* arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}*/
		 	
		 	alert("ret1 -->"+ ret1)
		 	//alert("arr[1] ---> "+arr[1])
		 	
			if (!(retVal == null))
			{
				target.value=ret1;
			}
			else
				target.focus();
	}


	// added from repListDischargeICDgrp.js

async function searchCodeDischarge(obj,target)
	{
		
		
			var retVal = 	new String();
			var dialogHeight= "400px" ;
			var dialogWidth	= "700px" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit=getLabel("eMR.DiagnosisGroup.label","MR");			
			//sql="select DIAG_GROUP_CODE, DIAG_GROUP_DESC  from mr_diag_group where group_type=`D`";
			//sql="select DIAG_GROUP_CODE, DIAG_GROUP_DESC  from mr_diag_group_lang_vw where language_id=`"+localeName+"` AND group_type=`D`"; 
			
			var t_set_id=document.forms[0].p_diag_set.value;
			
			/*if(t_set_id=='ALL')
			{
				
				sql="select term_group_id,term_group_desc from mr_term_group_hdr a,mr_term_set b where a.term_set_id=b.term_set_id and b.diag_spec_yn=`Y`";
				
			}
			else*/
			
			sql="select term_group_id,term_group_desc from mr_term_group_hdr where term_set_id=`"+t_set_id+"`";
			

			search_code="TERM_GROUP_ID";
			search_desc= "TERM_GROUP_DESC ";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal =await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);
			 
			
			 
			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
}


	// added from repListDischargeWithoutICD.js

async function searchCoderepDischarge(obj,target)
	{

			var retVal = 	new String();
			var dialogHeight= "80vh" ;
			var dialogWidth	= "60vw" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var facility_id = "`" +document.forms[0].p_facility_id.value+"`"
			var tit=getLabel("Common.nursingUnit.label","Common");			
			//sql="select nursing_unit_code,short_desc from ip_nursing_unit where facility_id = "+facility_id;
			sql="select nursing_unit_code,short_desc from ip_nursing_unit_lang_vw where language_id=`"+localeName+"` AND facility_id = "+facility_id;
			search_code="nursing_unit_code";
			search_desc= "short_desc";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);
			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
}

//added from repVisitNotifiableCases.js

async function searchCoderepVisitNotifiable(obj,target)
    {
            var retVal =    new String();
            var dialogHeight= "400px" ;
            var dialogWidth = "700px" ;
            var status = "no";
            var arguments   = "" ;
            var sql="";
            var search_code="";
            var search_desc="";
            var tit="";
            var facilityid = document.forms[0].p_facility_id.value;
			var from_pract_type = repNotifiableCases.fm_pract_type.value;
			var to_pract_type = repNotifiableCases.to_pract_type.value;

			var t_set_id=document.forms[0].p_diag_set.value;
            if(obj.name=="locationcode")
            {
				tit=getLabel("Common.Location.label","Common");
				if(document.forms[0].encounter_type.value == "O")
				{               
                //sql="select Clinic_code, short_desc from OP_clinic where Facility_id = `"+facilityid+"` ";
				sql="select Clinic_code, short_desc from OP_clinic_lang_vw where language_id=`"+localeName+"` AND Facility_id = `"+facilityid+"` ";
                search_code="clinic_code";
                search_desc= "short_desc"
                facilityid = "facility_id";
				}
				else
				{
                //sql="select Nursing_unit_code, short_desc from IP_NURSING_UNIT where Facility_id = `"+facilityid+"` ";
				sql="select nursing_unit_code,short_desc from ip_nursing_unit_lang_vw where language_id=`"+localeName+"` AND facility_id = `"+facilityid+"` ";
                search_code="Nursing_unit_code";
                search_desc= "short_desc"
                facilityid = "facility_id";
				}
            }

            if(obj.name=="Practitionerid1")
            {
                tit=getLabel("Common.practitioner.label","Common");
                //sql="select PRACTITIONER_ID, PRACTITIONER_NAME from am_practitioner where PRACT_TYPE=nvl(`"+from_pract_type+"`,PRACT_TYPE) ";
				sql="SELECT practitioner_id, practitioner_name FROM  am_practitioner_lang_vw where language_id=`"+localeName+"` and  PRACT_TYPE=nvl(`"+from_pract_type+"`,PRACT_TYPE)"; 
                search_code="PRACTITIONER_ID";
                search_desc= "PRACTITIONER_NAME"
            }           

            if(obj.name=="Practitionerid2")
            {
                tit=getLabel("Common.practitioner.label","Common");
                //sql="select PRACTITIONER_ID, PRACTITIONER_NAME from am_practitioner where PRACT_TYPE=nvl(`"+to_pract_type+"`,PRACT_TYPE) ";
				sql="SELECT practitioner_id, practitioner_name FROM  am_practitioner_lang_vw where language_id=`"+localeName+"` and  PRACT_TYPE=nvl(`"+to_pract_type+"`,PRACT_TYPE)";
                search_code="PRACTITIONER_ID";
                search_desc= "PRACTITIONER_NAME"
            }           
		
            if(obj.name=="Diagnosis") 
            {
                tit=getLabel("Common.diagnosis.label","Common");
             //   sql="select diag_code, short_desc from MR_ICD_CODE ";

			 sql="select term_code, short_desc from MR_TERM_CODE where term_set_id=`"+t_set_id+"` and diagnosis_yn=`Y`";
			 search_code="term_code";
             search_desc= "short_desc"
            }

            var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
            retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

            if (!(retVal == null))
            {
                target.value=retVal;
            }
            else
                target.focus();
    }

   /*Below lines added by Venkateshs against MMS-DM-CRF-0057 */
async function searchgrpCode(obj,target){
	     
    		 var retVal =    new String();
            var dialogHeight= "28vh" ;
            var dialogWidth = "43vw" ;
            var status = "no";
            var arguments   = "" ;
            var sql="";
            var search_code="";
            var search_desc="";
            var tit="";
			
			if(target.name=="P_From_Term_Code"){
				term_grp_code=document.forms[0].p_frm_term_grp_id.value;}
			if(target.name=="P_To_Term_Code"){
				term_grp_code=document.forms[0].p_to_term_grp_id.value;} 
	 
	         tit=getLabel("Common.diagnosis.label","Common");

			if(document.forms[0].p_diag_set.value !="" && term_grp_code =="" ){
			sql="select a.TERM_CODE,a.short_desc FROM MR_TERM_CODE_LANG_VW a,mr_term_group_dtl b where b.term_set_id = `"+document.forms[0].p_diag_set.value+"` AND a.term_set_id = b.term_set_id AND a.term_code = b.term_code  AND a.language_id =`"+localeName+"`  ";}
   
			if(term_grp_code !="" && document.forms[0].p_diag_set.value !=""){
			sql="select a.TERM_CODE,a.short_desc FROM MR_TERM_CODE_LANG_VW a,mr_term_group_dtl b where b.term_group_id =`"+term_grp_code+"` AND a.term_set_id =`"+document.forms[0].p_diag_set.value+"` AND a.term_set_id = b.term_set_id AND a.term_code = b.term_code  AND a.language_id = `"+localeName+"` ";}
			 
			
			
			 search_code="a.term_code"; 
             search_desc= "a.short_desc"
	     
			var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
            retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);
			if (!(retVal == null))
            {
                target.value=retVal;
            }
            else
                target.focus();
	
	}
	/* end MMS-DM-CRF-0057 */
//added by Sangeetha on 06-oct-2016 for GDOH-CRF-0082
async function termCodeLookup(obj,target){
	     
    		var retVal =    new String();
            var dialogHeight= "28vh" ;
            var dialogWidth = "43vw";
            var search_code="";
            var search_desc="";
            var tit="";
			var term_set_id = "ICD10";
			
		     if(obj.name == 'from_term_code' || obj.name == 'to_term_code'){
             tit=getLabel("Common.TermCode.label","Common");
			 
			 sql="select TERM_CODE, short_desc FROM MR_TERM_CODE_LANG_VW where term_set_id=`"+term_set_id+"` and language_id = `"+localeName+"` ";
			
			 search_code="TERM_CODE"; 
             search_desc= "short_desc";

			 }
	     
			var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
            retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);
			if (!(retVal == null))
            {
                target.value=retVal;
            }
            else
                target.focus();
	
	}


	
	//added from repEncounterList.js
async function searchCoderepEnc(obj,target,p_class)
{ 
	var retVal = 	new String();
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var tit="";
	var search_text=""
	if((obj.name=="patient_class")||(obj.name=="p_patient_class"))
	{  
		tit=getLabel("Common.patientclass.label","Common");
		//sql="select 'All' patinet_class, 'All' facility_id from dual union select distinct PATIENT_CLASS,decode(patient_class,'DC','Day Care','EM','Emegency','OP','Outpatient','IP','Inpatient') facility_id from pr_encounter";
		sql="select 'All' PATIENT_CLASS, 'All' SHORT_DESC from dual union select PATIENT_CLASS, SHORT_DESC  from AM_PATIENT_CLASS_LANG_VW where LANGUAGE_ID = '"+localeName+"'";
		
		
		search_code="patinet_class";
		search_desc="SHORT_DESC";


	}  
	
		
	else if(obj.name=="patient_id")
	{
		tit=getLabel("Common.patientId.label","Common");
		if ((p_class.value !='')  && (p_class.value !='All'))
			sql="select distinct a1.patient_id patient_id ,a2.patient_name patient_name from pr_encounter a1,mp_patient a2 where a1.patient_id=a2.patient_id and a1.patient_class = '"+p_class.value+"'";
		else
             sql="select distinct a1.patient_id patient_id ,a2.patient_name patient_name from pr_encounter a1,mp_patient a2 where a1.patient_id=a2.patient_id ";   
		search_code= "patient_id";
		search_desc= "patient_name";
	}
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	//retVal = await 
	retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);
	if (!(retVal == null))
	{
		if(retVal=='All')
		{
			retVal=getLabel("Common.all.label","Common");
		}

		target.value=retVal;
	}
	else
		target.focus();
	}

	function checkreport(obj)
	{
        if (obj.value =='1')
		{
			document.forms[0].p_report_id.value = "MRBENLST"; 
		}
		else if (obj.value =='2')
			{
			document.forms[0].p_report_id.value = "MRBENLET";
			}
	}

async function searchCodelocn(obj,target)
	{  
			var loctype = document.forms[0].p_location_type.value;
			var facility = document.forms[0].p_facility_id.value;
			var retVal = 	new String();
			var dialogHeight= "80vh" ;
			var dialogWidth	= "60vw" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			
			/*Modified by Ashwini on 29-Jul-2019 for ML-MMOH-CRF-1352*/
			if(obj.value=="")
			{
				
				tit=getLabel("Common.all.label","Common")+" "+getLabel("Common.clinic.label","Common");
				
				sql="SELECT a.clinic_code, b.short_desc FROM mr_report_of_op_attendance a, op_clinic b where a.facility_id = b.facility_id and a.clinic_code = b.clinic_code and a.facility_id = `"+facility+"`";
 
				search_code="a.clinic_code";
				search_desc= "b.short_desc";
			}
			if(obj.value=="SC")
			{
				
				tit=getLabel("Common.SpecialistClinic.label","Common");
				
				sql="SELECT a.clinic_code, b.short_desc FROM mr_report_of_op_attendance a, op_clinic b where a.facility_id = b.facility_id and a.clinic_code = b.clinic_code and a.facility_id = `"+facility+"` and a.service_code = `SC`";

				//sql="select clinic_code,long_desc from op_clinic where facility_id=`"+facility+"` and level_of_Care_ind = `A` and care_locn_type_ind = `C` and specialist_clinic_yn = `Y` "; 
                 
				//sql="select clinic_code, short_desc from op_clinic where facility_id=`"+facility+"` and CARE_LOCN_TYPE_IND=nvl(`"+loctype+"`,CARE_LOCN_TYPE_IND)"; 
				search_code="a.clinic_code";
				search_desc= "b.short_desc";
			}
			if(obj.value=="PU")
			{
				
				tit=getLabel("Common.PAC.label","Common");

				sql="SELECT a.clinic_code, b.short_desc FROM mr_report_of_op_attendance a, op_clinic b where a.facility_id = b.facility_id and a.clinic_code = b.clinic_code and a.facility_id = `"+facility+"` and a.service_code = `PU`";

				//sql="select clinic_code, long_desc from op_clinic  where facility_id=`"+facility+"` and care_locn_type_ind = `E`";
				//sql="select * from op_clinic where facility_id=`"+facility+"` level_of_Care_ind = 'A' and care_locn_type_ind = 'C' and specialist_clinic_yn = 'Y' "; 

				 
				search_code="a.clinic_code";
				search_desc= "b.short_desc";
			}
			if(obj.value=="ED")
			{
				
				tit=getLabel("eMR.EmergencyDepartment.label","MR");

				sql="SELECT a.clinic_code, b.short_desc FROM mr_report_of_op_attendance a, op_clinic b where a.facility_id = b.facility_id and a.clinic_code = b.clinic_code and a.facility_id = `"+facility+"` and a.service_code = `ED`";

				//sql="select clinic_code, long_desc from op_clinic where facility_id=`"+facility+"` and level_of_Care_ind = `E` and care_locn_type_ind = `C` and specialist_clinic_yn = `Y`";
				//sql="select * from op_clinic where facility_id=`"+facility+"` level_of_Care_ind = 'A' and care_locn_type_ind = 'C' and specialist_clinic_yn = 'Y' "; 
								
				
				search_code="a.clinic_code";
				search_desc= "b.short_desc";
			}
			if(obj.value=="ST")
			{
				
				tit=getLabel("Common.Staff.label","Common")+" "+getLabel("Common.clinic.label","Common");
				
				sql="SELECT a.clinic_code, b.short_desc FROM mr_report_of_op_attendance a, op_clinic b where a.facility_id = b.facility_id and a.clinic_code = b.clinic_code and a.facility_id = `"+facility+"` and a.service_code = `ST`";
								
				search_code="a.clinic_code";
				search_desc= "b.short_desc";
			}
			/*if(obj.value=="SCED")
			{
				
				tit=getLabel("eMR.SpecialistClinicandEmergencyDepartment.label","MR");
				sql="select clinic_code, long_desc from op_clinic where facility_id=`"+facility+"` and level_of_care_ind in(`A`, `E`) and care_locn_type_ind = `C` and specialist_clinic_yn = `Y`";
				//sql="select * from op_clinic where facility_id=`"+facility+"` level_of_Care_ind = 'A' and care_locn_type_ind = 'C' and specialist_clinic_yn = 'Y' "; 
				
				search_code="clinic_code";
				search_desc= "long_desc";
			}*/
			/*End ML-MMOH-CRF-1352*/

			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}

function CheckFromDate(obj)
{
	var flag1=true;
	if(obj.value.length>0)
	CheckDate(obj); // checks for valid date
	var todate=document.forms[0].morbstatnatageto.value;
	if(obj.value.length > 0 && todate.length > 0 ) 
	{
		if(!localdoDateCheck(obj,document.forms[0].morbstatnatageto))
			flag1=false;
	}
	return flag1;
}

function CheckToDate(obj)
{
				var flag=true;
				if(obj.value.length>0)
				{
					CheckDate(obj);
					if(!localdoDateCheck(document.forms[0].morbstatnatagefrom,obj))
					{
						flag= false;
					}
					
				}
				return flag;
				
}


function localdoDateCheck(from,to) 
{
		
		var fromarray; var toarray;
		var fromdate = from.value ;
		var todate = to.value ;

		
		if(fromdate.length<=0 && trimCheck(todate))
		{
			alert(getMessage('FROM_DATE_CANNOT_BE_BLANK','SM') );
			from.select();
			from.focus();
			return false;
		}
		else if(todate.length<=0 && trimCheck(fromdate))
		{
			alert( getMessage('INVALID_TO_DT','SM') );
			to.select();
			to.focus();
			return false;
		}
		else if(fromdate.length > 0 && todate.length > 0 ) 
		{
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			/*Modified by Ashwini on 04-Feb-2019 for ML-MMOH-SCF-1145*/
			var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
			var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);	
			if(Date.parse(todt) < Date.parse(fromdt)) 
			{
				alert( getMessage('TO_DT_GR_EQ_FM_DT','SM') );
				to.select();
				to.focus();
				return false;
			}
			else if(Date.parse(todt) >= Date.parse(fromdt)) 
				return true;
		}
	return true;
}



function doDateCheckAlertLocal(str,from,to,messageFrame){
	    var fromdate = from.value ;
		var todate = to.value ;
		var greg_fromDate = convertDate(fromdate,"DMY",localeName,"en");
		var greg_toDate = convertDate(todate,"DMY",localeName,"en");
		if(from.value!=""&&to.value!=""){
		if(f_query_add_mod.isBefore(greg_fromDate,greg_toDate,"DMY","en"))
		{
			
			return true;
		}
		else 
		{
			var error=f_query_add_mod.getMessage("REMARKS_MUST_GR_EQUAL","common");
			
			error=error.replace("$",getLabel("Common.to.label","Common")+" "+str);
			error=error.replace("#",str);
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
			return false;
		}
		}
		return true;
}

function doDateCheckAlert1(from,to){
	
			    var fromdate = from.value ;
		var todate = to.value ;
		var greg_fromDate = convertDate(fromdate,"DMY",localeName,"en");
		var greg_toDate = convertDate(todate,"DMY",localeName,"en");
	
		if(from.value!=""&&to.value!=""){
		/*--- below line(s) added by venkatesh.S  and Emp:ID-4008  on 18/Jan/2012 aganist  KDAH-CRF-0032---*/
		if(f_query_add_mod.document.forms[0].name=='lab_test_rep')
		{ 
		
		var d1 = fromdate.replace(/^(\d{1,2}\/)(\d{1,2}\/)(\d{4})$/,"$2$1$3");
		 var d2=   todate.replace(/^(\d{1,2}\/)(\d{1,2}\/)(\d{4})$/,"$2$1$3");
		 var date1=new Date(d1);
		 var date2=new Date(d2);
         var oneDay=1000*60*60*24;
         var datedifferen=Math.ceil((date2.getTime()-date1.getTime())/oneDay)
		
	    var daterange=f_query_add_mod.document.lab_test_rep.datarange.value;
	  
		if (datedifferen >=daterange)
		{   alert(getMessage("DATE_RANGE_CAN_NOT_EXCEED","MR"))  
			return false;
		}
		
		
		}
		/* ----end KDAH-CRF-0032---*/
		
    if(f_query_add_mod.isBefore(greg_fromDate,greg_toDate,"DMY","en"))
		{
			
			return true;
		}
		else 
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
			f_query_add_mod.document.MRBNOTDL.P_TO_ADMN_DATE.select();
			return false;
		}
		
		
		}
		return true;

}
function disableLocationTypeMRBDSWDG(obj){
	if ( obj.value == 'OP' || obj.value=='B'){
		document.getElementById('p_location_type').disabled=false;
		document.getElementById('p_location_type').value='';
		document.getElementById('p_fm_loc_code').value='';
		document.getElementById('p_to_loc_code').value='';
        document.getElementById('p_fm_loc_code').disabled=true;
	    document.getElementById('locn').disabled=true;
	    document.getElementById('p_to_loc_code').disabled=true;
	    document.getElementById('locn1').disabled=true;

		}
		else if(obj.value == 'EM'){
			document.getElementById("p_location_type").value='C';
//			document.getElementById('p_location_type').value='C';
			document.getElementById("p_location_type").disabled=true;
		document.getElementById('p_fm_loc_code').value='';
		document.getElementById('p_to_loc_code').value='';
        document.getElementById('p_fm_loc_code').disabled=false;
	    document.getElementById('locn').disabled=false;
	    document.getElementById('p_to_loc_code').disabled=false;
	    document.getElementById('locn1').disabled=false;

		}
}
async function searchCoderepDischarge(obj,target)
	{
			var tit = "";
			var retVal = 	new String();
			var dialogHeight= "400px" ;
			var dialogWidth	= "700px" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var facility_id= "`" +document.forms[0].p_facility_id.value+"`"
			
			if (document.forms[0].p_enc_type.value=='OP')
			{
				 search_code="clinic_code";
				 search_desc= "short_desc";
				 if (document.forms[0].p_location_type.value=='C')
				 {
					tit=encodeURIComponent(getLabel("Common.clinic.label","Common"));			
					sql= "select clinic_code,short_desc from op_clinic  where CARE_LOCN_TYPE_IND =`C` and facility_id="+facility_id+" ";
					//sql= "select clinic_code,short_desc from op_clinic  where CARE_LOCN_TYPE_IND =`C`" 
					
				 }
				 else
				 if (document.forms[0].p_location_type.value=='E')
				 {
				    tit=encodeURIComponent(getLabel("Common.ProcedureUnit.label","Common"));		
					sql= "select clinic_code,short_desc from op_clinic  where CARE_LOCN_TYPE_IND =`E` and Facility_id ="+facility_id+" " ;
					
				 }
			}
			else
			if(document.forms[0].p_enc_type.value=='EM')
			{
					tit=encodeURIComponent(getLabel("Common.clinic.label","Common"));		
					sql= "select clinic_code,short_desc from op_clinic  where LEVEL_OF_CARE_IND=`E`and CARE_LOCN_TYPE_IND = `C` and Facility_id ="+facility_id+" " ;
					search_code="clinic_code";
					search_desc= "short_desc";
			}	
			else
			if(document.forms[0].p_enc_type.value=='B')
			{
				 search_code="clinic_code";
				 search_desc= "short_desc";
				if (document.forms[0].p_location_type.value=='C')
				 {
					tit=encodeURIComponent(getLabel("Common.clinic.label","Common"));		
					sql= "select clinic_code,short_desc from op_clinic  where CARE_LOCN_TYPE_IND =`C` and Facility_id = "+facility_id+" " ;
					
				 }
				 else
				 if (document.forms[0].p_location_type.value=='E')
				 {
				   tit=encodeURIComponent(getLabel("Common.ProcedureUnit.label","Common"));		
					sql= "select clinic_code,short_desc from op_clinic  where CARE_LOCN_TYPE_IND =`E` and Facility_id = "+facility_id+" " ;
					
				 }
			}	

			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);
       if (!(retVal == null))
            {
                target.value=retVal;
            }
            else
                target.focus();
}
function clearDetail1(obj){
if(obj.value==null||obj.value==""){
    document.forms[0].p_fm_loc_code.value='';
    document.forms[0].p_to_loc_code.value='';
	document.forms[0].p_fm_loc_code.disabled=true;
	document.forms[0].locn.disabled=true;
	document.forms[0].p_to_loc_code.disabled=true;
	document.forms[0].locn1.disabled=true;
	
	}
	else{
	document.forms[0].p_fm_loc_code.value='';
    document.forms[0].p_to_loc_code.value='';
    document.forms[0].p_fm_loc_code.disabled=false;
	document.forms[0].locn.disabled=false;
	document.forms[0].p_to_loc_code.disabled=false;
	document.forms[0].locn1.disabled=false;
	}
}




function val(obj)
{
	if (obj!=null)
	{
	 if(morbidity.p_incl_nat_grp_val.checked == true){
		 morbidity.p_incl_nat_grp_val.value='Y';
		  morbidity.p_incl_nat_grp.value='Y';
	 
	 }
	 else if(morbidity.p_incl_nat_grp_val.checked == false)
		{
		 morbidity.p_incl_nat_grp.value='N';
		 morbidity.p_incl_nat_grp_val.value='N';

		}
	
	}
}
/*Developed On 3/21/2008 For VisitWithOutMDS*/
async function searchCoderepVisitWthotMDS(obj,target)

{
			var tit = "";
			var retVal = 	new String();
			var dialogHeight= "400px" ;
			var dialogWidth	= "700px" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var facility_id= "`" +document.forms[0].p_facility_id.value+"`"
			
			var formObj=document.search_form_repVisitWthotMDS;
				 search_code="clinic_code";
				 search_desc= "short_desc";
				 if (formObj.p_patient_class.value=='EM' || formObj.p_patient_class.value=='OP')
				 {

					tit=encodeURIComponent(getLabel("Common.clinic.label","Common"));			
					sql= "select clinic_code,short_desc from op_clinic  where CARE_LOCN_TYPE_IND =`C` and facility_id="+facility_id+" ";
					
				 }
				 else
				 if (formObj.p_patient_class.value=='DC' || formObj.p_patient_class.value=='IP')
				 {
				    tit=encodeURIComponent(getLabel("Common.ProcedureUnit.label","Common"));		
					sql= "select clinic_code,short_desc from op_clinic  where CARE_LOCN_TYPE_IND =`E` and Facility_id ="+facility_id+" " ;
					
				 }
		

			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal =  await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);
       if (!(retVal == null))
            {
                target.value=retVal;
            }
            else
                target.focus();
}

/*Comparing From&To Dates  For VisitWithoutMDS On 3/21/2008*/
/*function compareDates(fromdate, todate)
{
	if(fromdate.value != "" && todate.value!="")
	{
		var greg_fromdate		= convertDate(fromdate.value,"DMY",localeName,"en");
		var greg_todate			= convertDate(todate.value,"DMY",localeName,"en");

		if(!isAfter(greg_todate,greg_fromdate,'DMY','en'))
		//if(isBefore(greg_todate,greg_fromdate,'DMY','en'))
		{		
			var error=getMessage("MRDATE1_LT_DATE2",'MR');
			error= error.replace('$',getLabel("Common.todate.label","Common"));
			error= error.replace('#',getLabel("Common.fromdate.label","Common"));
			alert(error);
			todate.select();
			todate.focus();
		}
	}
}*/	 

/*Comparing clearDetailFor  VisitWithoutMDS  on 3/21/2008*/

function clearDetailForMDS(obj)
{
if(obj.value==null||obj.value==""){
    document.forms[0].p_fr_locn_code.value='';
    document.forms[0].p_to_locn_code.value='';
	document.forms[0].p_fr_locn_code.disabled=true;
	document.forms[0].locn.disabled=true;
	document.forms[0].p_to_locn_code.disabled=true;
	document.forms[0].locn1.disabled=true;
	
	}
	else{
	document.forms[0].p_fr_locn_code.value='';
    document.forms[0].p_to_locn_code.value='';
    document.forms[0].p_fr_locn_code.disabled=false;
	document.forms[0].locn.disabled=false;
	document.forms[0].p_to_locn_code.disabled=false;
	document.forms[0].locn1.disabled=false;
	}
}

function disableLocnTypes()
{
	document.forms[0].p_fr_locn_code.value='';
    document.forms[0].p_to_locn_code.value='';
	document.forms[0].p_fr_locn_code.disabled=true;
	document.forms[0].locn.disabled=true;
	document.forms[0].p_to_locn_code.disabled=true;
	document.forms[0].locn1.disabled=true;
}


async function beforeSerachSpeciality(obj1,obj2,obj3,obj4,obj5){
	
		
		if(obj2.value!="")
			await searchSpecialty(obj1,obj2,obj3,obj4);
		else
	{
		obj1.value="";
		obj3.value="";
		obj4.value="";
		obj5.value="";
	}

		}


async function searchSpecialty(obj1,target,obj3,obj4){	
		  
		   var argumentArray  = new Array() ;
			var dataNameArray  = new Array() ;
			var dataValueArray = new Array() ;
			var dataTypeArray  = new Array() ;
			var retVal = 	new String();

			
			var sql="";
			
		
			var tit=getLabel("Common.speciality.label","Common");			
			
			sql="SELECT SPECIALITY_CODE CODE,SHORT_DESC DESCRIPTION FROM AM_SPECIALITY where eff_status='E' AND upper(SPECIALITY_CODE) like upper(?) and upper(SHORT_DESC) like upper(?) order by SHORT_DESC ";
			
			
			
			
			argumentArray[0] = sql;
			argumentArray[1] = dataNameArray ;
			argumentArray[2] = dataValueArray ;
			argumentArray[3] = dataTypeArray ;
			argumentArray[4]="1,2";
			argumentArray[5]=target.value;
			argumentArray[6]=CODE_DESC_LINK;
			argumentArray[7]=CODE_DESC;
		
		retVal = await CommonLookup(tit, argumentArray );
		
			if(retVal != null && retVal != "")
		{
			target.value =retVal[0] ;
			//target.value =retVal[1] ;
			 obj3.value=retVal[0];
			 obj4.value="";

			
		}
		else
			target.value ="";

	

}


/*
function beforeSerachSpeciality_nonSeq(obj1,obj2,obj3){
	
	if(obj2.value != "")
			searchSpecialty_nonSeq(obj1,obj2,obj3);
		else
			obj3.value = "";
		}

function searchSpecialty_nonSeq(obj1,target,obj3){	
		  
		   var argumentArray  = new Array() ;
			var dataNameArray  = new Array() ;
			var dataValueArray = new Array() ;
			var dataTypeArray  = new Array() ;
			var retVal = 	new String();

			
			var sql="";
			
		
			var tit=getLabel("Common.speciality.label","Common");			
			
			sql="SELECT SPECIALITY_CODE CODE,SHORT_DESC DESCRIPTION FROM AM_SPECIALITY where eff_status='E' AND upper(SPECIALITY_CODE) like upper(?) and upper(SHORT_DESC) like upper(?) order by SHORT_DESC ";
			
			
			
			
			argumentArray[0] = sql;
			argumentArray[1] = dataNameArray ;
			argumentArray[2] = dataValueArray ;
			argumentArray[3] = dataTypeArray ;
			argumentArray[4]="1,2";
			argumentArray[5]=target.value;
			argumentArray[6]=CODE_DESC_LINK;
			argumentArray[7]=CODE_DESC;
		
		retVal = CommonLookup(tit, argumentArray );
		
			if(retVal != null && retVal != "")
		{
			target.value =retVal[1] ;
			 obj3.value=retVal[0];
			 

			
		}
		else
			target.value ="";

	

}
*/
async function beforeSearchServices(obj1,obj2,obj3){
	
	if(obj2.value != "")
			await searchServices(obj1,obj2,obj3);
		else
			obj3.value = "";
		}

async function searchServices(obj1,target,obj3){
	var argumentArray  = new Array() ;
			var dataNameArray  = new Array() ;
			var dataValueArray = new Array() ;
			var dataTypeArray  = new Array() ;
			var retVal = 	new String();

			var tit=getLabel("Common.service.label","Common");
			var language=document.forms[0].language.value;
			
			sql="SELECT SERVICE_CODE CODE, SHORT_DESC  DESCRIPTION FROM AM_SERVICE_LANG_VW WHERE LANGUAGE_ID='"+language+"' AND upper(SERVICE_CODE) like upper(?) and upper(SHORT_DESC) like upper(?) order by SHORT_DESC ";
			

		
			
			argumentArray[0] = sql;
			argumentArray[1] = dataNameArray ;
			argumentArray[2] = dataValueArray ;
			argumentArray[3] = dataTypeArray ;
			argumentArray[4]="1,2";
			argumentArray[5]=target.value;
			argumentArray[6]=CODE_DESC_LINK;
			argumentArray[7]=CODE_DESC;
		
		retVal = await CommonLookup(tit, argumentArray );
			if(retVal != null && retVal != "")
		{
			//target.value =retVal[1] ;
			target.value =retVal[0] ;
			 obj3.value=retVal[0];
			 
		}
		else
			target.value ="";

}




async function beforeGetLoc(loginuser,fac_id,obj1,obj2,target){
	
	
	if(target.value != "")
			await getLocn(loginuser,fac_id,obj1,obj2,target);
		else
			obj2.value = "";


}

async function getLocn(loginuser,fac_id,obj1,obj2,target)
{
	
   var retVal =    new String();
   var retVal =    new String();
   var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";				
   var locale="";				
   var spec_code="";				
   var oper_id="";				
   var locale=document.forms[0].language.value; 
   
  spec_code=obj1.value;
   var patient_class = document.forms[0].p_location_type.value;
   tit=getLabel("Common.Location.label",'Common')

	   
		if(patient_class == 'OP')
		{
				sql="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id ='"+fac_id+"' and  language_id='"+locale+"' and eff_status ='E' and level_of_care_ind ='A' ";

				if(!spec_code=="")
				{
				sql=sql+" and speciality_code='"+spec_code+"' ";
				}

				sql=sql+" AND (facility_id,CLINIC_TYPE,CLINIC_CODE) in (select facility_id, locn_type, locn_code from AM_OS_USER_LOCN_ACCESS_VW where facility_id ='"+fac_id+"' and appl_user_id = '"+loginuser+"' ) and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc))";

	 

				sql=sql+"  ORDER BY  2";
		}
		else if (patient_class == 'EM')
		{	
				sql="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id ='"+fac_id+"' and  language_id='"+locale+"' and eff_status ='E' and level_of_care_ind = 'E' and care_locn_type_ind = 'C' ";

				if(!spec_code=="")
				{
				sql=sql+" and speciality_code='"+spec_code+"' ";
				}

				sql=sql+" AND (facility_id,CLINIC_TYPE,CLINIC_CODE) in (select facility_id, locn_type, locn_code from AM_OS_USER_LOCN_ACCESS_VW where facility_id ='"+fac_id+"'  and appl_user_id = '"+loginuser+"' ) and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc))";

	 

				sql=sql+"  ORDER BY  2";
		
		}
		else if(patient_class == 'IP')
		{
			sql="select a.nursing_unit_code code,a.short_desc description from ip_nursing_unit_lang_vw a, am_os_user_locn_access_vw b where a.language_id='"+locale+"' and a.facility_id='"+fac_id+"' and a.patient_class='IP' and a.facility_id=b.facility_id and a.EFF_STATUS = 'E' and a.nursing_unit_code=b.locn_code and a.locn_type=b.locn_type and b.locn_type = 'N'  and b.appl_user_id='"+loginuser+"'  and  upper(a.nursing_unit_code) like upper(?) and upper(a.short_desc) like upper(?)";

				 

				sql=sql+"  ORDER BY  2";
		}
		else if(patient_class == 'DC')
		{

			sql="select a.nursing_unit_code code,a.short_desc description from ip_nursing_unit_lang_vw a, am_os_user_locn_access_vw b where a.language_id='"+locale+"' and a.facility_id='"+fac_id+"' and a.patient_class='DC' and a.facility_id=b.facility_id and a.EFF_STATUS = 'E' and a.nursing_unit_code=b.locn_code and a.locn_type=b.locn_type and b.locn_type = 'N' and b.appl_user_id='"+loginuser+"'  and  upper(a.nursing_unit_code) like upper(?) and upper(a.short_desc) like upper(?)";
			sql=sql+"  ORDER BY  2";

		}
		else
		{
				sql="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id ='"+fac_id+"' and  language_id='"+locale+"' and eff_status ='E' ";

				if(!spec_code=="")
				{
				sql=sql+" and speciality_code='"+spec_code+"' ";
				}

				sql=sql+" AND (facility_id,CLINIC_TYPE,CLINIC_CODE) in (select facility_id, locn_type, locn_code from AM_OS_USER_LOCN_ACCESS_VW where facility_id ='"+fac_id+"'  and appl_user_id = '"+loginuser+"' ) and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc))";

	 

				sql=sql+"  ORDER BY  2";


		}
   
   
  				
				
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4]="1,2";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;
		
		retVal = await CommonLookup(tit, argumentArray );
		
		if(retVal != null && retVal != "")
		{
			target.value = retVal[0] ;
			//target.value = retVal[1] ;
			obj2.value = retVal[0];
			
		}
		else
			target.value ="";

}
function resetParameter(obj){
	
	
		
		document.forms[0].p_fr_location_code.value="";
		document.forms[0].from_location.value="";

		document.forms[0].to_location.value="";
		document.forms[0].p_to_location_code.value="";

		document.forms[0].p_fr_specialty_code.value="";
		document.forms[0].p_to_specialty_code.value="";

		document.forms[0].from_speciality.value="";
		document.forms[0].to_speciality.value="";

		document.forms[0].to_service.value="";
		document.forms[0].p_to_service_code.value="";

		document.forms[0].from_service.value="";
		document.forms[0].p_fr_service_code.value="";


		

	
}

function _FromDate(obj){
			var from = obj.value;
			var to   = document.forms[0].CurrentDate.value;
			var fromarray;
			var toarray;
			fromarray  = from.split("/");
			toarray    = to.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
			var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
			if (CheckDate(obj)){
				if(Date.parse(todt) < Date.parse(fromdt)) {//DATE_NOT_LESS_SYSDATE
					var invaldtFrom = getMessage("FROM_DT_NGE_CURR_DATE","SM") ;
					var decs_fromDate=getLabel('Common.from.label','common_labels')+" "+getLabel("Common.Procedure.label","common_labels")+" "+getLabel("Common.date.label","common_labels");
					invaldtFrom = invaldtFrom.replace('From date',decs_fromDate);
					alert(invaldtFrom);
					document.forms[0].p_fm_proc_date.select();
					document.forms[0].p_fm_proc_date.focus();
					}
				}
}
function _ToDate(obj){
			var from = obj.value;
			var to   = document.forms[0].CurrentDate.value;
			var fromarray;
			var toarray;
			fromarray  = from.split("/");
			toarray    = to.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
			var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
			if (CheckDate(obj)){
				if(Date.parse(todt) < Date.parse(fromdt)) {//DATE_NOT_LESS_SYSDATE
					var invaldtFrom = getMessage("FROM_DT_NGE_CURR_DATE","SM") ;
					var decs_ToDate=getLabel('Common.to.label','common_labels')+" "+getLabel("Common.Procedure.label","common_labels")+" "+getLabel("Common.date.label","common_labels");
					invaldtFrom = invaldtFrom.replace('From date',decs_ToDate);
					alert(invaldtFrom);
					document.forms[0].p_to_proc_date.select();
					document.forms[0].p_to_proc_date.focus();
					}
				}
}


function CheckString1(str ,fromobj,toobj,messageFrame) {

	 var arr = new Array(toobj.value,fromobj.value);
    if( trimCheck(fromobj.value) && trimCheck(toobj.value) ) {
        if(fromobj.value <= toobj.value) {
            return true;
        }
        else {
			var error=getMessage("REMARKS_MUST_GR_EQUAL","common",arr);
		
			error=error.replace("$",getLabel('Common.to.label','common_labels')+ ' ' +str);
			error=error.replace("#",str);
            messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
            return false;
        }
    }
    else {
        return true;
    }
}


function _GRDate(obj){
			var from = obj.value;
			var to   = document.forms[0].CurrentDate.value;
			var fromarray;
			var toarray;
			fromarray  = from.split("/");
			toarray    = to.split("/");
			var fromdt = new Date(fromarray[1]-1,fromarray[0]);
			var todt = new Date(toarray[1]-1,toarray[0]);
				if(Date.parse(todt) < Date.parse(fromdt)) {//DATE_NOT_LESS_SYSDATE
					var invaldtFrom = getMessage("FROM_DT_NGE_CURR_DATE","SM") ;
					var decs_ToDate=getLabel('Common.to.label','common_labels')+" "+getLabel("eMR.PrefMonth.label","mr_labels");
					var last_date='Current ' +getLabel('Common.month.label','common_labels');
					invaldtFrom = invaldtFrom.replace('From date',decs_ToDate);
					invaldtFrom = invaldtFrom.replace('Current date',last_date);
					alert(invaldtFrom);

						document.forms[0].pref_month_to.select();
						document.forms[0].pref_month_to.focus();
				}
}

function _GRDate1(obj){
			var from = obj.value;
			var to   = document.forms[0].CurrentDate.value;
			var fromarray;
			var toarray;
			fromarray  = from.split("/");
			toarray    = to.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
			var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
				if(Date.parse(todt) < Date.parse(fromdt)) {//DATE_NOT_LESS_SYSDATE
					var invaldtFrom = getMessage("FROM_DT_NGE_CURR_DATE","SM") ;
					var decs_ToDate=getLabel('Common.to.label','common_labels')+" "+getLabel("Common.dischargedate.label","common_labels");
					invaldtFrom = invaldtFrom.replace('From date',decs_ToDate);
					alert(invaldtFrom);
					if(parent.f_query_add_mod.document.repDischargeStats)
					{
						document.forms[0].p_to_discharge_date.select();
						document.forms[0].p_to_discharge_date.focus();
					}
					if(parent.f_query_add_mod.document.repDischargeStatsbyNursUnit)
					{
						document.forms[0].p_to_pref_date.select();
						document.forms[0].p_to_pref_date.focus();
					}

				}
}
//*********************************************************************************************************
function validateDmissionDate_From(obj) {
		var from = obj.value;
	
		var to   = document.forms[0].CurrentDate.value;
       var fromarray;
		var toarray;
		fromarray  = from.split("/");
		toarray    = to.split("/");
		/*Modified by Ashwini on 04-Feb-2019 for ML-MMOH-SCF-1145*/
		var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
		var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
		//if (CheckDate(obj)){
		if (!isBeforeNow(obj.value,"DMY",localeName)){
			if(Date.parse(todt) < Date.parse(fromdt)) {
					var invaldt = getMessage("DATE1_GT_DATE2",'IP') ;
					var census_date_from=(getLabel("Common.from.label","Common")+" "+getLabel("Common.admissiondate.label","Common"));
					var sys_date=getLabel("Common.CurrentDate.label","Common");
					invaldt=invaldt.replace('$',census_date_from);
					invaldt=invaldt.replace('#',sys_date);
					alert(invaldt);
					obj.value='';
					obj.focus();
					
				}
			}
		}

		function validateDmissionDate_To(obj) {
		var from = obj.value;
	
		var to   = document.forms[0].CurrentDate.value;
       var fromarray;
		var toarray;
		fromarray  = from.split("/");
		toarray    = to.split("/");
		/*Modified by Ashwini on 04-Feb-2019 for ML-MMOH-SCF-1145*/
		var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
		var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
		//if (CheckDate(obj)){
		if (!isBeforeNow(obj.value,"DMY",localeName)){

			if(Date.parse(todt) < Date.parse(fromdt)) {
					var invaldt = getMessage("DATE1_GT_DATE2",'IP') ;
					var census_date_from=(getLabel("Common.to.label","Common")+" "+getLabel("Common.admissiondate.label","Common"));
					var sys_date=getLabel("Common.CurrentDate.label","Common");
					invaldt=invaldt.replace('$',census_date_from);
					invaldt=invaldt.replace('#',sys_date);
					alert(invaldt);
					obj.value='';
					obj.focus();
					
				}
			}
		}

//******************************************************************************************************************
function validateDischarge_From(obj) {
		var from = obj.value;
	
		var to   = document.forms[0].CurrentDate.value;
       var fromarray;
		var toarray;
		fromarray  = from.split("/");
		toarray    = to.split("/");
		/*Modified by Ashwini on 04-Feb-2019 for ML-MMOH-SCF-1145*/
		var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
		var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
		//if (CheckDate(obj)){
		if (!isBeforeNow(obj.value,"DMY",localeName)){

			if(Date.parse(todt) < Date.parse(fromdt)) {
					var invaldt = getMessage("DATE1_GT_DATE2",'IP') ;
					var census_date_from=(getLabel("Common.from.label","Common")+" "+getLabel("Common.dischargedate.label","Common"));
					var sys_date=getLabel("Common.CurrentDate.label","Common");
					invaldt=invaldt.replace('$',census_date_from);
					invaldt=invaldt.replace('#',sys_date);
					alert(invaldt);
					obj.value='';
					obj.focus();
					
				}
			}
		}

		function validateDischarge_To(obj) {
		var from = obj.value;
	
		var to   = document.forms[0].CurrentDate.value;
       var fromarray;
		var toarray;
		fromarray  = from.split("/");
		toarray    = to.split("/");
		/*Modified by Ashwini on 04-Feb-2019 for ML-MMOH-SCF-1145*/
		var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
		var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
		//if (CheckDate(obj)){
		if (!isBeforeNow(obj.value,"DMY",localeName)){

			if(Date.parse(todt) < Date.parse(fromdt)) {
					var invaldt = getMessage("DATE1_GT_DATE2",'IP') ;
					var census_date_from=(getLabel("Common.to.label","Common")+" "+getLabel("Common.dischargedate.label","Common"));
					var sys_date=getLabel("Common.CurrentDate.label","Common");
					invaldt=invaldt.replace('$',census_date_from);
					invaldt=invaldt.replace('#',sys_date);
					alert(invaldt);
					obj.value='';
					obj.focus();
					
				}
			}
		}

//*****************************************************

function validatePeriod_From(obj) {
		var from = obj.value;
	
		var to   = document.forms[0].CurrentDate.value;
       var fromarray;
		var toarray;
		fromarray  = from.split("/");
		toarray    = to.split("/");
		/*Modified by Ashwini on 04-Feb-2019 for ML-MMOH-SCF-1145*/
		var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
		var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
		//if (CheckDate(obj)){
		if (!isBeforeNow(obj.value,"DMY",localeName)){

			if(Date.parse(todt) < Date.parse(fromdt)) {
					var invaldt = getMessage("DATE1_GT_DATE2",'IP') ;
					var census_date_from=(getLabel("Common.from.label","Common")+" "+getLabel("Common.Period.label","Common")+" "+getLabel("Common.DateRange.label","Common"));
					var sys_date=getLabel("Common.CurrentDate.label","Common");
					invaldt=invaldt.replace('$',census_date_from);
					invaldt=invaldt.replace('#',sys_date);
					alert(invaldt);
					obj.value='';
					obj.focus();
					
				}
			}
		}
//added by Sangeetha on 12-oct-2016 for GDOH-CRF-0082
function validatePeriod_from_PMB(obj) {
	
		var from = obj.value;
	
		var to   = document.forms[0].CurrentDate.value;
        var fromarray;
		var toarray;
		fromarray  = from.split("/");
		toarray    = to.split("/");

		var fromdt = new Date(fromarray[1],fromarray[0]);
		var todt = new Date(toarray[1],toarray[0]);

		if (!isBeforeNow(obj.value,"MY",localeName)){

			if(Date.parse(todt) < Date.parse(fromdt)) {
				 
					var invaldt		 = getMessage("REMARKS_SHOULD_LS_EQUAL",'common') ;
					var vis_adm_date = (getLabel("Common.from.label","Common")+" "+getLabel("eMR.AdmVisitMonth.label","MR"));
					var currentDate  = "Current month/year";
					invaldt=invaldt.replace('$',vis_adm_date);
					invaldt=invaldt.replace('#',currentDate);
					alert(invaldt);
					obj.value='';
					obj.focus();
					
				}
			}
		}

//added by Sangeetha on 12-oct-2016 for GDOH-CRF-0082
function validatePeriod_to_PMB(obj) {
		var from = obj.value;
	
		var to   = document.forms[0].CurrentDate.value;
       var fromarray;
		var toarray;
		fromarray  = from.split("/");
		toarray    = to.split("/");
		var fromdt = new Date(fromarray[1],fromarray[0]);
		var todt = new Date(toarray[1],toarray[0]);
		
		if (!isBeforeNow(obj.value,"MY",localeName)){

			if(Date.parse(todt) < Date.parse(fromdt)) {
					var invaldt = getMessage("REMARKS_SHOULD_LS_EQUAL",'common');
                    var vis_adm_date = (getLabel("Common.to.label","Common")+" "+getLabel("eMR.AdmVisitMonth.label","MR"));
					var currentDate  = "Current month/year";
					invaldt=invaldt.replace('$',vis_adm_date);
					invaldt=invaldt.replace('#',currentDate);
					alert(invaldt);
					obj.value='';
					obj.focus();
					
				}
			}
		}
		
		
/*Below lines added by Venkateshs against MMS-DM-CRF-0057 */
function validatePeriod_From_1(obj) {
		var from = obj.value;
	
		var to   = document.forms[0].CurrentDate.value;
       var fromarray;
		var toarray;
		fromarray  = from.split("/");
		toarray    = to.split("/");
		/*Modified by Ashwini on 04-Feb-2019 for ML-MMOH-SCF-1145*/
		var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
		var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
		//if (CheckDate(obj)){
		if (!isBeforeNow(obj.value,"DMY",localeName)){

			if(Date.parse(todt) < Date.parse(fromdt)) {
					var invaldt = getMessage("DATE1_GT_DATE2",'IP') ;
					var census_date_from=(getLabel("Common.fromdate.label","Common"));
					var sys_date=getLabel("Common.CurrentDate.label","Common");
					invaldt=invaldt.replace('$',census_date_from);
					invaldt=invaldt.replace('#',sys_date);
					alert(invaldt);
					obj.value='';
					obj.focus();
					
				}
			}
		}
		   /* end MMS-DM-CRF-0057 */

		function validatePeriod_To(obj) {
		var from = obj.value;
	
		var to   = document.forms[0].CurrentDate.value;
       var fromarray;
		var toarray;
		fromarray  = from.split("/");
		toarray    = to.split("/");
		/*Modified by Ashwini on 04-Feb-2019 for ML-MMOH-SCF-1145*/
		var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
		var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
		//if (CheckDate(obj)){
		if (!isBeforeNow(obj.value,"DMY",localeName)){

			if(Date.parse(todt) < Date.parse(fromdt)) {
					var invaldt = getMessage("DATE1_GT_DATE2",'IP') ;
					var census_date_from=(getLabel("Common.to.label","Common")+" "+getLabel("Common.Period.label","Common")+" "+getLabel("Common.DateRange.label","Common"));
					var sys_date=getLabel("Common.CurrentDate.label","Common");
					invaldt=invaldt.replace('$',census_date_from);
					invaldt=invaldt.replace('#',sys_date);
					alert(invaldt);
					obj.value='';
					obj.focus();
					
				}
			}
		}
/*Below lines added by Venkateshs against MMS-DM-CRF-0057 */		
function validatePeriod_To_1(obj) {
		var from = obj.value;
	
		var to   = document.forms[0].CurrentDate.value;
       var fromarray;
		var toarray;
		fromarray  = from.split("/");
		toarray    = to.split("/");
		/*Modified by Ashwini on 04-Feb-2019 for ML-MMOH-SCF-1145*/
		var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
		var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
		//if (CheckDate(obj)){
		if (!isBeforeNow(obj.value,"DMY",localeName)){

			if(Date.parse(todt) < Date.parse(fromdt)) {
					var invaldt = getMessage("DATE1_GT_DATE2",'IP') ;
					var census_date_from=(getLabel("Common.todate.label","Common"));
					var sys_date=getLabel("Common.CurrentDate.label","Common");
					invaldt=invaldt.replace('$',census_date_from);
					invaldt=invaldt.replace('#',sys_date);
					alert(invaldt);
					obj.value='';
					obj.focus();
					
				}
			}
		}
		/* end MMS-DM-CRF-0057 */
//********************************************************************************************
function ComparePeriodFromToAdmissionDate(from,to)
    {
	
    var frdt = from.value;
	var tdt = to.value;
	var greg_tdt = "";
	var greg_frdt = "";

	if(frdt !="" && validDate(frdt,"DMY","en"))
	{
		greg_frdt = convertDate(frdt,"DMY",localeName,"en");
		
	}

	if(to !="" && validDate(tdt,"DMY","en"))
	{
		greg_tdt = convertDate(tdt,"DMY",localeName,"en");
	}

	if(greg_frdt != "" && greg_tdt !="")
	{


		if(greg_tdt < greg_frdt)
		{
		
			var message= getMessage("DATE1_LT_DATE2",'IP') ;

			var toAdmission=(getLabel("Common.to.label","Common")+" "+getLabel("Common.admissiondate.label","Common"));
			var fromAdmission=(getLabel("Common.from.label","Common")+" "+getLabel("Common.admissiondate.label","Common"));
				message=message.replace('$',toAdmission);
				message=message.replace('#',fromAdmission);
				alert(message);

			to.focus();
			to.select();
		}
	}
}

//*************************************************************************************************************
function ComparePeriodFromToDischargeDate(from,to)
    {
	
    var frdt = from.value;
	var tdt = to.value;
	var greg_tdt = "";
	var greg_frdt = "";

	if(frdt !="" && validDate(frdt,"DMY","en"))
	{
		greg_frdt = convertDate(frdt,"DMY",localeName,"en");
		
	}

	if(to !="" && validDate(tdt,"DMY","en"))
	{
		greg_tdt = convertDate(tdt,"DMY",localeName,"en");
	}

	if(greg_frdt != "" && greg_tdt !="")
	{


		if(greg_tdt < greg_frdt)
		{
		
			var message= getMessage("DATE1_LT_DATE2",'IP') ;

			var toAdmission=(getLabel("Common.to.label","Common")+" "+getLabel("Common.dischargedate.label","Common"));
			var fromAdmission=(getLabel("Common.from.label","Common")+" "+getLabel("Common.dischargedate.label","Common"));
				message=message.replace('$',toAdmission);
				message=message.replace('#',fromAdmission);
				alert(message);

			to.focus();
			to.select();
		}
	}
}
//***********************************************************************
function ComparePeriodFromToPeriodDate(from,to)
    {
	
    var frdt = from.value;
	var tdt = to.value;
	var greg_tdt = "";
	var greg_frdt = "";

	if(frdt !="" && validDate(frdt,"DMY","en"))
	{
		greg_frdt = convertDate(frdt,"DMY",localeName,"en");
		
	}

	if(to !="" && validDate(tdt,"DMY","en"))
	{
		greg_tdt = convertDate(tdt,"DMY",localeName,"en");
	}

	if(greg_frdt != "" && greg_tdt !="")
	{


		if(greg_tdt < greg_frdt)
		{
		
			var message= getMessage("DATE1_LT_DATE2",'IP') ;

			var toAdmission=(getLabel("Common.to.label","Common")+" "+getLabel("Common.Period.label","Common")+" "+getLabel("Common.DateRange.label","Common"));
			var fromAdmission=(getLabel("Common.from.label","Common")+" "+getLabel("Common.Period.label","Common")+" "+getLabel("Common.DateRange.label","Common"));
				message=message.replace('$',toAdmission);
				message=message.replace('#',fromAdmission);
				alert(message);

			to.focus();
			to.select();
		}
	}
}
//30 Sep 2010  IN024014  changed function name validate_date_xyz 
function validate_date_xyz(obj,ref,chk) {

		if (CheckDate(obj))
		{ 
			
			if(ref == "FROM_DATE_LESS_SYSDATE" )
			{   	
				if(chk =="A"){
					
				from = document.forms[0].p_fr_date;
				to   = document.forms[0].sys_date;
				}
				else if(chk =="P"){
				
				from = document.forms[0].p_fr_adm_date;
				to   = document.forms[0].sys_date;
			}
			}else if(ref=="TO_DT_GR_EQ_FM_DT")
			{
					
				if(chk =="A"){
					
				from = document.forms[0].p_to_date;
				to =   document.forms[0].p_fr_date;	

				}
				else if(chk =="P"){
					
				from = document.forms[0].p_to_adm_date;
				to   = document.forms[0].p_fr_adm_date;
				}
			}else if (ref=="TO_DATE_LESS_SYSDATE")
			{
				
				if(chk =="A"){
					
				from = document.forms[0].p_to_date;
				to   = document.forms[0].sys_date;
				}
				else if(chk =="P"){
					
				from = document.forms[0].p_to_adm_date;
				to   = document.forms[0].sys_date;
				}
			}
			
            var fromarray;
			var toarray;
			var fromdate = from.value ;
			var todate = to.value ;
			
            if(fromdate.length > 0 && todate.length > 0 ) {
				fromarray = fromdate.split("/");
				toarray = todate.split("/");
				/*Modified by Ashwini on 04-Feb-2019 for ML-MMOH-SCF-1145*/
				var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
				var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
				
					
				if(!doDateCheckAlert(to,obj)){
				if(ref == "FROM_DATE_LESS_SYSDATE" )
					{
					
							var invaldt = parent.parent.frames[0].getMessage("FROM_DATE_LESS_SYSDATE","SM") ; 
					} else
							var invaldt = parent.parent.frames[0].getMessage("TO_DATE_LESS_SYSDATE","SM") ; 

				alert(invaldt);
				from.value="";
				}
				else if((ref == "FROM_DATE_LESS_SYSDATE" )||(ref == "TO_DATE_LESS_SYSDATE" )){
					
					if(chk =="A"){
					from = document.forms[0].p_fr_date;
					to   = document.forms[0].p_to_date;
					}
					else if(chk =="P"){
					from = document.forms[0].p_fr_adm_date;
					to   = document.forms[0].p_to_adm_date;
					}
					if (to.value!=""){
						fromarray  = from.value.split("/");
						toarray    = to.value.split("/");
						/*Modified by Ashwini on 04-Feb-2019 for ML-MMOH-SCF-1145*/
						var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
						var todt   = new Date(toarray[2],toarray[1]-1,toarray[0]);
						if(Date.parse(todt) < Date.parse(fromdt)) {
						var invaldt = parent.parent.frames[0].getMessage("TO_DT_GR_EQ_FM_DT","SM") ;
						alert(invaldt);
						to.value="";
						to.focus();
						}
						return true;
					}

				}
				else if(Date.parse(todt) <= Date.parse(fromdt)) return true;
				
			}
			return true;
		}
		else{
		obj.value="";        
		obj.focus();
		obj.select();
		return false;
		}
}



function dateCheckforWeek(from_date,to_date){
    var fromdate=from_date.value;
    var todate =to_date.value;
	var fromarray;
    var toarray;	
	if(fromdate.length > 0 && todate.length > 0 ) 
	{  
		fromarray = fromdate.split("/");
		toarray = todate.split("/");		
		var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
		var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);	
		var date_diff = Math.round((Date.parse(todt)-Date.parse(fromdt))/1000/60/60/24)		
		if(date_diff>7) {
		  msg = getMessage("DATE_RANGE_WEEK","MR");
      		alert(msg);
			to_date.value="";
			to_date.focus();
			to_date.select();				
			return false;
	    }
	  return true;
	}
	return true;
}
 async function searchCode1(obj,target)
{
	var facilityid	   = document.forms[0].p_facility_id.value;
	var retVal         = new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";				
	var sql="";	

   	tit=getLabel("Common.Location.label","Common");
   // sql="select clinic_code code, short_desc description from OP_clinic where Facility_id = '"+facilityid+"'  and CARE_LOCN_TYPE_IND!='E' and CARE_LOCN_TYPE_IND In ('C','P') and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2 ";

    sql="SELECT   clinic_code code, short_desc description FROM op_clinic WHERE facility_id = '"+facilityid+"'     AND level_of_care_ind != 'E' AND care_locn_type_ind IN ('C', 'E')and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(short_desc) like upper(nvl(?,short_desc))ORDER BY 2 ";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_DESC_LINK  ;
	argumentArray[7] = CODE_DESC ;

	var retVal= await CommonLookup(tit,argumentArray);
	if(retVal==null || retVal=="")
	target.value="";
	else
	target.value=retVal[0].split(',')[0];
}

async function searchCoderepAppointmentsforopdBCP_Form(obj,target)
{
	var facilityid	   = document.forms[0].p_facility_id.value;
	var retVal         = new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";				
	var sql="";	

   
	tit=getLabel("Common.Location.label","Common");
	sql="select nursing_unit_code code,short_desc description from ip_nursing_unit where facility_id = '"+facilityid+"'  and upper(nursing_unit_code) like upper(nvl(?,nursing_unit_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2 ";

			
			/*else
	{
		    tit="OT Room";
			sql="select oper_room_code code,short_desc description from ot_oper_room where operating_facility_id='"+facilityid+"' and upper(oper_room_code) like upper(nvl(?,oper_room_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2 ";
	} */
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_DESC_LINK  ;
	argumentArray[7] = CODE_DESC ;

	var retVal = await CommonLookup(tit,argumentArray);
	if(retVal == null || retVal == "")
		target.value="";
	else
		target.value=retVal[0].split(',')[0]; 
}


function _GRDate2(obj){
		if(obj.name=="P_FM_DATE"){
			var from = obj.value;
			var to   = document.forms[0].CurrentDate.value;
			var fromarray;
			var toarray;
			fromarray  = from.split("/");
			toarray    = to.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
			var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
				if(Date.parse(todt) < Date.parse(fromdt)) {//DATE_NOT_LESS_SYSDATE
					var invaldtFrom = getMessage("FROM_DT_NGE_CURR_DATE","SM") ;
//					var decs_ToDate=getLabel('Common.from.label','common_labels')+" "+getLabel("Visit/Admission Date");
//					invaldtFrom = invaldtFrom.replace('From date',decs_ToDate);
					alert(invaldtFrom);
						document.forms[0].P_FM_DATE.select();
						document.forms[0].P_FM_DATE.focus();

					/*if(parent.f_query_add_mod.document.repDischargeStats)
					{
						document.forms[0].p_to_discharge_date.select();
						document.forms[0].p_to_discharge_date.focus();
					}
					if(parent.f_query_add_mod.document.repDischargeStatsbyNursUnit)
					{
						document.forms[0].p_to_pref_date.select();
						document.forms[0].p_to_pref_date.focus();
					}*/

				}
		}else{
			var from = obj.value;
			var to   = document.forms[0].CurrentDate.value;
			var fromarray;
			var toarray;
			fromarray  = from.split("/");
			toarray    = to.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
			var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
				if(Date.parse(todt) < Date.parse(fromdt)) {//DATE_NOT_LESS_SYSDATE
					var invaldtFrom = getMessage("TO_DT_NGE_CURR_DATE","SM") ;
//					var decs_ToDate=getLabel('Common.to.label','common_labels')+" "+getLabel("Visit/Admission Date";
//					invaldtFrom = invaldtFrom.replace('To Date',decs_ToDate);
					alert(invaldtFrom);
						document.forms[0].P_TO_DATE.select();
						document.forms[0].P_TO_DATE.focus();

					/*if(parent.f_query_add_mod.document.repDischargeStats)
					{
						document.forms[0].p_to_discharge_date.select();
						document.forms[0].p_to_discharge_date.focus();
					}
					if(parent.f_query_add_mod.document.repDischargeStatsbyNursUnit)
					{
						document.forms[0].p_to_pref_date.select();
						document.forms[0].p_to_pref_date.focus();
					}*/

				}

		}
}


/*function doDateCheckAlert1(from,to) {
    var fromarray; var toarray;
    var fromdate = from.value ;
    var todate = to.value ;
    if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
            var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
            if(Date.parse(todt) > Date.parse(fromdt)) {
				return false;
           }
           else if(Date.parse(todt) <= Date.parse(fromdt)) return true;
    }
return true;
}*/
function validate_date1(obj,ref) {
	

	if (CheckDate(obj))
	{
		if(ref == "MR_FROM_DATE_LESS_SYSDATE" )
		{
			from = document.forms[0].p_fr_adm_date;
			to =   document.forms[0].sys_date;
		}else if(ref=="TO_DT_GR_EQ_FM_DT")
		{
			
			from = document.forms[0].p_to_adm_date;
			to =   document.forms[0].p_fr_adm_date;
		}else if (ref=="MR_TO_DATE_LESS_SYSDATE")
		{
			from = document.forms[0].p_to_adm_date;
			to =  document.forms[0].sys_date;
		}
		
		var fromarray;
		var toarray;
		var fromdate = from.value ;
		var todate = to.value ;
		
		if(fromdate.length > 0 && todate.length > 0 ) {
				fromarray = fromdate.split("/");
				toarray = todate.split("/");
				/*Modified by Ashwini on 04-Feb-2019 for ML-MMOH-SCF-1145*/
				var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
				var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
				
				//if(Date.parse(todt) > Date.parse(fromdt)) {
					if(!doDateCheckAlert1(document.forms[0].sys_date,obj)){
						//msg=geteMRMessage(ref);
				   if(ref == "MR_FROM_DATE_LESS_SYSDATE" )
					{
				var invaldt = parent.parent.frames[0].getMessage("MR_FROM_DATE_LESS_SYSDATE","MR") ; 
					}
					 else if(ref == "MR_TO_DATE_LESS_SYSDATE" ){
				var invaldt = parent.parent.frames[0].getMessage("MR_TO_DATE_LESS_SYSDATE","MR") ; 
		           }                
			            alert(invaldt);
					    from.value="";
				}
				else if((ref == "MR_FROM_DATE_LESS_SYSDATE" )||(ref == "MR_TO_DATE_LESS_SYSDATE" )){
					from = document.forms[0].p_fr_adm_date;
					to   = document.forms[0].p_to_adm_date;
					if (to.value!=""){
						fromarray  = from.value.split("/");
						toarray    = to.value.split("/");
						/*Modified by Ashwini on 04-Feb-2019 for ML-MMOH-SCF-1145*/
						var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
						var todt   = new Date(toarray[2],toarray[1]-1,toarray[0]);
						if(Date.parse(todt) < Date.parse(fromdt)) {
						var invaldt = parent.parent.frames[0].getMessage("TO_DT_GR_EQ_FM_DT","SM") ;
							alert(invaldt);
							to.value="";
							to.focus();
					}
					return true;
				}

			}
		  }
		return true;
	}
	else{
		obj.value="";        
		obj.focus();
		obj.select();
		return false;
	}
	}


async function searchCoderepCurrentMedicationList(obj,target)
{
	var facilityid	   = document.forms[0].p_facility_id.value;
	var retVal         = new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";				
	var sql="";	
      	if(obj.name=="nursing")
        {   
		    tit=getLabel("Common.Location.label","Common");
			sql="select nursing_unit_code code, short_desc description from ip_nursing_unit where  facility_id = '"+facilityid+"' and upper(nursing_unit_code) like upper(nvl(?,nursing_unit_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2 ";
		}
	
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_DESC_LINK  ;
		argumentArray[7] = CODE_DESC ;

	var retVal= await CommonLookup(tit,argumentArray);
	if(retVal==null || retVal=="")
	target.value="";
	else
	target.value=retVal[0].split(',')[0];
}


/*
function searchCoderepCurrentMedicationList(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var facilityid = document.forms[0].p_facility_id.value;
           if(obj.name=="nursing")
			{
				tit="Nursing Unit"
				sql=" ";
				search_code="nursing_unit_code";
				search_desc= "short_desc";
			}

			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	} */
/*
function searchCoderepAppointmentsforopdBCP_Form_12(obj,target)
    {
			var retVal =    new String();
            var dialogHeight= "28" ;
            var dialogWidth = "43" ;
            var status = "no";
            var arguments   = "" ;
            var sql="";
            var search_code="";
            var search_desc="";
            var tit="";
            var facilityid = document.forms[0].p_facility_id.value;
			if(obj.name=="locationcode")
            {
				tit="Location"
                sql="select nursing_unit_code,short_desc from ip_nursing_unit where facility_id = `"+facilityid+"` ";
				search_code="nursing_unit_code";
				search_desc= "short_desc";
				facilityid = "facility_id";
				               
            }
		else{
				 tit="OT Room"
				 sql="select oper_room_code,short_desc from ot_oper_room where operating_facility_id=`"+facilityid+"` ";
                search_code="oper_room_code";
                search_desc= "short_desc"
                facilityid = "operating_facility_id";

			  }
            var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
            retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

            if (!(retVal == null))
            {
                target.value=retVal;
            }
            else
                target.focus();
    }
*/


function labvalidate_date(obj) {
		var from = obj.value;
	
		var to   = document.forms[0].sys_date.value;
       var fromarray;
		var toarray;
		fromarray  = from.split("/");
		toarray    = to.split("/");
		/*Modified by Ashwini on 04-Feb-2019 for ML-MMOH-SCF-1145*/
		var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
		var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);

		if (CheckDate(obj)){
		
					if(Date.parse(todt) < Date.parse(fromdt)) {
					    var invaldt_from = getMessage("MR_FROM_DATE_LESS_SYSDATE",'MR') ;
					    var invaldt_to = getMessage("MR_TO_DATE_LESS_SYSDATE",'MR') ;
					if(obj.name == "p_fr_adm_date")
					{
						var census_date_from=invaldt_from;
					} else
					{
						var census_date_from=invaldt_to;
					}
					alert(census_date_from);
					obj.value='';
					obj.focus();
					
				}
			}
		}
			



   function ComparePeriodFromToTime(from,to)
    {
  
	/*Modified by Ashwini on 04-Feb-2019 for ML-MMOH-SCF-1145*/
	var frm = 	 from.value;
	var to  = 	 to.value;

	var frm_arr	= frm.split("/");
	var to_arr	= to.split("/");

	var greg_frdt = new Date(frm_arr[2],frm_arr[1]-1,frm_arr[0]) ;
	var greg_tdt = new Date(to_arr[2],to_arr[1]-1,to_arr[0]) ;

	if(greg_frdt != "" && greg_tdt !="")
	{	
		if(Date.parse(greg_tdt) < Date.parse(greg_frdt))
		{
		
			alert( getMessage("TO_DT_GR_EQ_FM_DT",'SM') );
			document.forms[0].p_to_adm_date.focus();
			document.forms[0].p_to_adm_date.select();
		}
	}
}


//********DRG Exception Report


async function searchCode(obj,target)
    {
            var sql="";
			var sqlSecond="";
            var tit="";
            var facilityid = document.forms[0].p_facility_id.value;
			var dataNameArray  = new Array() ;
			var dataValueArray = new Array() ;
			var dataTypeArray  = new Array() ;

			/*var practitionerName="";
			var practitionerValue="";
			var speciality="";
			var practitionerTypeValue="";*/
			var locale = document.forms[0].p_language_id.value;

			target.value=trimString(target.value);
			
			if(target.value=="" && window.event.target == target)
				return;
			
			var argumentArray=new Array(8);

             if(obj.name=="fromSpecialty" || obj.name=="toSpecialty")
            {
				tit=getLabel("Common.speciality.label","Common");;

				//SQL

                argumentArray[0]="Select speciality_code code, short_desc description from AM_SPECIALITY_LANG_VW where LANGUAGE_ID ='"+locale+"' and eff_status like 'E' and upper(speciality_code) like upper(?) and  upper(short_desc) like upper(?)";

				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1, 2";
				argumentArray[5]= target.value;
				argumentArray[6]= CODE_DESC_LINK;
				argumentArray[7]= CODE_DESC;
			             

			var retVal=await CommonLookup(tit,argumentArray);

			if(retVal==null || retVal=="")
			{
				target.value="";
				if(target.name == 'p_fr_specialty_code')
					document.forms[0].from_speciality.value="";

				if(target.name == 'p_to_specialty_code')
					document.forms[0].to_speciality.value="";

			}
			else
			{
				target.value=retVal[0];
				if(target.name == 'p_fr_specialty_code')
					document.forms[0].from_speciality.value=retVal[1];

				if(target.name == 'p_to_specialty_code')
					document.forms[0].to_speciality.value=retVal[1];

			}
		

		}

	}



	function allowPositiveNumber() 
	{
		var key = window.event.keyCode;
		/*var rep = parent.frames[0].document.forms[0].Report.value
		if(rep=="MRIPCSMB")
		{
			if(((key >=48 ) && (key<58)) ||(key==46)) 
			{
				return true;
			}
			else
				return false;
		}
		else
		{*/
			if(((key >=48 ) && (key<58))) 
			{
				return true;
			}
			else
				return false;
		//}
	}


	function validateDisch_From(obj) {
		var from = obj.value;
	
		var to   = document.forms[0].CurrentDate.value;
       var fromarray;
		var toarray;
		fromarray  = from.split("/");
		toarray    = to.split("/");
		/*Modified by Ashwini on 04-Feb-2019 for ML-MMOH-SCF-1145*/
		var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
		var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
//		if (CheckDate(obj)){
		if (!isBeforeNow(obj.value,"DMY",localeName)){

			if(Date.parse(todt) < Date.parse(fromdt)) {
					var invaldt = getMessage("DATE1_GT_DATE2",'IP') ;
					var census_date_from=(getLabel("Common.from.label","Common")+" "+getLabel("eMR.DischPeriod.label","MR"));
					var sys_date=getLabel("Common.CurrentDate.label","Common");
					invaldt=invaldt.replace('$',census_date_from);
					invaldt=invaldt.replace('#',sys_date);
					alert(invaldt);
					obj.value='';
					obj.focus();
					
				}
			}
		}

		function validateDisch_To(obj) {
		var from = obj.value;
	
		var to   = document.forms[0].CurrentDate.value;
       var fromarray;
		var toarray;
		fromarray  = from.split("/");
		toarray    = to.split("/");
		/*Modified by Ashwini on 04-Feb-2019 for ML-MMOH-SCF-1145*/
		var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
		var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
		//if (CheckDate(obj)){
		if (!isBeforeNow(obj.value,"DMY",localeName)){
			if(Date.parse(todt) < Date.parse(fromdt)) {
					var invaldt = getMessage("DATE1_GT_DATE2",'IP') ;
					var census_date_from=(getLabel("Common.to.label","Common")+" "+getLabel("eMR.DischPeriod.label","MR"));
					var sys_date=getLabel("Common.CurrentDate.label","Common");
					invaldt=invaldt.replace('$',census_date_from);
					invaldt=invaldt.replace('#',sys_date);
					alert(invaldt);
					obj.value='';
					obj.focus();
					
				}
			}
		}


	function ComparePeriodFromToDischDate(from,to,obj)
    {
	
    var frdt = from.value;
	var tdt = to.value;
	var greg_tdt = "";
	var greg_frdt = "";

	if(frdt !="" && validDate(frdt,"DMY","en"))
	{
		greg_frdt = convertDate(frdt,"DMY",localeName,"en");
		
	}

	if(to !="" && validDate(tdt,"DMY","en"))
	{
		greg_tdt = convertDate(tdt,"DMY",localeName,"en");
	}

	if(greg_frdt != "" && greg_tdt !="")
	{


		if(greg_tdt < greg_frdt)
		{
		
			var message= getMessage("DATE1_LT_DATE2",'IP') ;
			if(obj == 'disch') {
				var toAdmission=(getLabel("Common.to.label","Common")+" "+getLabel("eMR.DischPeriod.label","MR"));
				var fromAdmission=(getLabel("Common.from.label","Common")+" "+getLabel("eMR.DischPeriod.label","MR"));
			}
			else {
				var toAdmission=(getLabel("Common.to.label","Common")+" "+getLabel("Common.admission.label","Common")+" "+getLabel("Common.Period.label","Common"));
				var fromAdmission=(getLabel("Common.from.label","Common")+" "+getLabel("Common.admission.label","Common")+" "+getLabel("Common.Period.label","Common"));
			}
				message=message.replace('$',toAdmission);
				message=message.replace('#',fromAdmission);
				alert(message);

			to.focus();
			to.select();
		}
	}
}

function validateAdmin_From(obj) {
		var from = obj.value;
	
		var to   = document.forms[0].CurrentDate.value;
       var fromarray;
		var toarray;
		fromarray  = from.split("/");
		toarray    = to.split("/");
		/*Modified by Ashwini on 04-Feb-2019 for ML-MMOH-SCF-1145*/
		var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
		var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
		//if (CheckDate(obj)){
		if (!isBeforeNow(obj.value,"DMY",localeName)){

			if(Date.parse(todt) < Date.parse(fromdt)) {
					var invaldt = getMessage("DATE1_GT_DATE2",'IP') ;
					var census_date_from=(getLabel("Common.from.label","Common")+" "+getLabel("Common.admission.label","Common")+" "+getLabel("Common.Period.label","Common"));
					var sys_date=getLabel("Common.CurrentDate.label","Common");
					invaldt=invaldt.replace('$',census_date_from);
					invaldt=invaldt.replace('#',sys_date);
					alert(invaldt);
					obj.value='';
					obj.focus();
					
				}
			}
		}

		function validateAdmin_To(obj) {
		var from = obj.value;
	
		var to   = document.forms[0].CurrentDate.value;
       var fromarray;
		var toarray;
		fromarray  = from.split("/");
		toarray    = to.split("/");
		/*Modified by Ashwini on 04-Feb-2019 for ML-MMOH-SCF-1145*/
		var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
		var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
		//if (CheckDate(obj)){
		if (!isBeforeNow(obj.value,"DMY",localeName)){

			if(Date.parse(todt) < Date.parse(fromdt)) {
					var invaldt = getMessage("DATE1_GT_DATE2",'IP') ;
					var census_date_from=(getLabel("Common.to.label","Common")+" "+getLabel("Common.admission.label","Common")+" "+getLabel("Common.Period.label","Common"));
					var sys_date=getLabel("Common.CurrentDate.label","Common");
					invaldt=invaldt.replace('$',census_date_from);
					invaldt=invaldt.replace('#',sys_date);
					alert(invaldt);
					obj.value='';
					obj.focus();
					
				}
			}
		}

function BeforesearchCodeDRG1(obj1,obj2)
{
	if(document.forms[0].from_speciality.value != "")
		searchCodeDRG(obj1,obj2);
	else
		document.forms[0].p_fr_specialty_code.value = "";
}

function BeforesearchCodeDRG2(obj1,obj2)
{
	if(document.forms[0].to_speciality.value != "")
		searchCodeDRG(obj1,obj2);
	else
		document.forms[0].p_to_specialty_code.value = "";
}
async function searchCodeDRG(obj,target)
    {

            var sql="";
			var sqlSecond="";
            var tit="";
            var facilityid = document.forms[0].p_facility_id.value;
			var dataNameArray  = new Array() ;
			var dataValueArray = new Array() ;
			var dataTypeArray  = new Array() ;
			var locale = document.forms[0].p_language_id.value;

			
			
			var argumentArray=new Array(8);
			tit=getLabel("Common.speciality.label","Common");;

				//SQL

                argumentArray[0]="Select speciality_code code, short_desc description from AM_SPECIALITY_LANG_VW where LANGUAGE_ID ='"+locale+"' and eff_status like 'E' and upper(speciality_code) like upper(?) and  upper(short_desc) like upper(?)";

				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1, 2";
				argumentArray[5]= target.value;
				argumentArray[6]= CODE_DESC_LINK;
				argumentArray[7]= CODE_DESC;
			             

			var retVal= await CommonLookup(tit,argumentArray);
			var ret1=unescape(retVal);
		 	arr=ret1.split(",");
			if(retVal==null || retVal=="")
			{
				target.value="";
				if(target.name == 'from_speciality')
				{
					document.forms[0].from_speciality.value="";
					document.forms[0].p_fr_specialty_code.value="";
				}

				if(target.name == 'to_speciality')
				{
					document.forms[0].to_speciality.value="";
					document.forms[0].p_to_specialty_code.value="";
				}

			}
			else
			{
				target.value=arr[1];
				if(target.name == 'from_speciality')
					document.forms[0].p_fr_specialty_code.value=arr[0];

				if(target.name == 'to_speciality')
					document.forms[0].p_to_specialty_code.value=arr[0];

			}
		


	}

/*8/18/2009 Morbidity Statistics by Diagnosis Set / Nationality / Age */
function chkVal(obj){
	 if(morbidity.p_include_free_text_yn_val.checked == true)
	{
		morbidity.p_include_free_text_yn_val.value="Y";
		morbidity.p_include_free_text_yn.value="Y";
	}
	 else
	{
 		morbidity.p_include_free_text_yn_val.value="N";
 		morbidity.p_include_free_text_yn.value="N";
	}
}

function chkValmorbiditystat(obj){
	
	if(morbiditystat.p_include_free_text_yn_val.checked == true)
	{
		morbiditystat.p_include_free_text_yn_val.value="Y";
		morbiditystat.p_include_free_text_yn.value="Y";
	}
	 else
	{
 		morbiditystat.p_include_free_text_yn_val.value="N";
 		morbiditystat.p_include_free_text_yn.value="N";
	}


}

function chkValmortality(obj){
	
	if(mortality.p_include_free_text_yn_val.checked == true)
	{
		mortality.p_include_free_text_yn_val.value="Y";
		mortality.p_include_free_text_yn.value="Y";
	}
	 else
	{
 		mortality.p_include_free_text_yn_val.value="N";
 		mortality.p_include_free_text_yn.value="N";
	}

}
function chkValmortalityStatsAge(obj){
	

	 if(mortalityStatsAge.p_include_free_text_yn_val.checked == true)
	{
		mortalityStatsAge.p_include_free_text_yn_val.value="Y";
		mortalityStatsAge.p_include_free_text_yn.value="Y";
	}
	 else
	{
 		mortalityStatsAge.p_include_free_text_yn_val.value="N";
 		mortalityStatsAge.p_include_free_text_yn.value="N";
	}


}

async function funPatient1()
{

	var patid=await PatientSearch('','','','','','','Y','','','OTHER');
	if( patid ==null)patid="";
	document.forms[0].p_patient_id.value = patid;
}

//added by Sangeetha on 05-oct-2016 for GDOH-CRF-0082
function searchPatient1(obj)
{

	var patid=PatientSearch('','','','','','','Y','','','OTHER');
	if( patid ==null)patid="";
	if(obj.name == 'fm_patient_id')
	    document.forms[0].p_fm_patient_id.value = patid;
	if(obj.name == 'to_patient_id')
	     document.forms[0].p_to_patient_id.value = patid;
}

/*Below lines modified  by Venkateshs against MMS-DM-CRF-0057 */
async function call_Diagnosis(field,obj)
{ 
	var dialogTop	  = "10px";//50
	var dialogHeight  = "500px";//35
	var dialogWidth   = "800px";//50
	var features    ="dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments   = "" ;
	var term_grp_code ="";
	var diag_code	= document.forms[0].diag_code.value;
	var diag_desc  = document.forms[0].diag_desc.value;
	if(document.new_report_form)
	var term_set   = document.forms[0].p_diag_set.value;
	var encounter_id	= '';
	if(document.new_report_form){
	var function_id=document.forms[0].function_id.value; 
	var term_set   = document.forms[0].p_diag_set.value;}
    else
	var term_set   = document.forms[0].P_Term_Set_Id.value;
	
	
	if(field.name=="P_From_Term_Code" && document.new_report_form){ 
	  term_grp_code=document.forms[0].p_frm_term_grp_id.value;  }
	if(field.name=="P_To_Term_Code" && document.new_report_form){
	   term_grp_code=document.forms[0].p_to_term_grp_id.value;} 
	

	var params  = "../../eMR/jsp/PaintConsultationFrame.jsp?term_set_id="+term_set+"&p_diag_code=";		
	params     +=diag_code+"&p_diag_scheme_desc="+diag_desc+"&term_grp_code="+term_grp_code+"&function_id="+function_id+"&Encounter_Id="+encounter_id+"&cause_indicator="; 
	

	var retVal = await window.showModalDialog(params,arguments,features);
	if (!(retVal == null))
	{
		 var retdata;
		 retdata = retVal.split("/")  ;		 
		 objname=field.name;
		 eval("document.forms[0]."+ objname+".value=retdata[0]");	
    }
}
/*end MMS-DM-CRF-0057 */
function enable_code()
{
	document.forms[0].P_From_Term_Code.value='';
	document.forms[0].P_To_Term_Code.value='';
	document.forms[0].P_Free_Text.value='';
	/*Below lines added by Venkateshs against MMS-DM-CRF-0057 */
	if(document.new_report_form)
	var sel=document.forms[0].p_diag_set.value;
    else 
	var sel=document.forms[0].P_Term_Set_Id.value;
	
	/*Tuesday, December 29, 2009 , to enable/disable free text area a/c to free_text_applicable_yn */
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST","../../eMR/jsp/AdverseEventType.jsp?validate=FREE_TEXT_YN&termSetID="+sel,false);
	xmlHttp.send(null);
	responseText=xmlHttp.responseText;  
	var proceed = trimString(responseText); 
	proceed=proceed.substring(0,1);

	if(sel=="" || sel==null)
	{
	
	 document.forms[0].P_From_Term_Code.value="";
	 document.forms[0].P_To_Term_Code.value="";
	 document.forms[0].P_Free_Text.value="";
	 /*Below lines added by Venkateshs against MMS-DM-CRF-0057 */
	 if(document.new_report_form){
	document.forms[0].p_frm_term_grp_id.value="";
	document.forms[0].p_to_term_grp_id.value=""
	document.forms[0].p_frm_term_grp_id.disabled=true;
	document.forms[0].p_to_term_grp_id.disabled=true;
	document.forms[0].fm_diag_button.disabled=true;
	document.forms[0].to_diag_button.disabled=true; }
	/* end MMS-DM-CRF-0057 */
	
	 document.forms[0].P_From_Term_Code.disabled=true;
	 document.forms[0].P_To_Term_Code.disabled=true;
	 document.forms[0].P_Free_Text.disabled=true;
	 document.forms[0].diag_frmbutton.disabled=true;
	 document.forms[0].diag_tobutton.disabled=true;

	
	 document.forms[0].start_ends_contains.disabled=true;
	 document.forms[0].start_ends_contains.value="S";
	 
	 document.getElementById('frm_diag_code').style.visibility="hidden";
	 document.getElementById('to_diag_code').style.visibility="hidden";
	}
	else 
	{
	 /*Below lines added by Venkateshs against MMS-DM-CRF-0057 */
	 if(document.new_report_form){
	document.forms[0].p_frm_term_grp_id.disabled=false;
	document.forms[0].p_to_term_grp_id.disabled=false;
	document.forms[0].fm_diag_button.disabled=false;
	document.forms[0].to_diag_button.disabled=false;
	/* end MMS-DM-CRF-0057 */
	}
	
	 document.forms[0].P_From_Term_Code.disabled=false;
	 document.forms[0].P_To_Term_Code.disabled=false;
	 if(proceed == "Y")
		document.forms[0].P_Free_Text.disabled=false;
	 else
		document.forms[0].P_Free_Text.disabled=true;
	 document.forms[0].diag_frmbutton.disabled=false;
	 document.forms[0].diag_tobutton.disabled=false;

	
	  if(proceed == "Y")
		 document.forms[0].start_ends_contains.disabled=false;
	  else
		{
		  document.forms[0].start_ends_contains.disabled=true;
		  document.forms[0].start_ends_contains.value="S";
		}
		
	 //document.getElementById("frm_diag_code").style.visibility="visible";
	 //document.getElementById("to_diag_code").style.visibility="visible";
	}
}
//9/22/2009
function CheckForSpecChars_freetext(event){
    var strCheck = '"+%?@#$~';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return true;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return false ;
}


function doDateCheckAlertLocal_rep(str,from,to,messageFrame){
	    var fromdate = from.value ;
		var todate = to.value ;
		var greg_fromDate = convertDate(fromdate,"DMY",localeName,"en");
		var greg_toDate = convertDate(todate,"DMY",localeName,"en");
		if(from.value!=""&&to.value!=""){
		if(f_query_add_mod.isBefore(greg_fromDate,greg_toDate,"DMY","en"))
		{
			
			return true;
		}
		else 
		{
			var error=f_query_add_mod.getMessage("REMARKS_MUST_GR_EQUAL","common");
			
			error=error.replace("$",getLabel("Common.to.label","Common")+" "+str);
			error=error.replace("#",str);
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
			return false;
		}
		}
		return true;
}

function validate_date(obj) {
	


		if(obj.value!=''){
		
			if(isBeforeNow(obj.value,"DMY","en"))
				return true;
			else {
			
				alert(getMessage("START_DATE_GREATER_SYSDATE","COMMON"));
				obj.select();
				obj.focus();
				return false ;
			}
		}
  }
function bbastatyn(obj)
{
	if(obj.checked)
	document.getElementById('bba_stat_yn').value='I';
	else
	document.getElementById('bba_stat_yn').value="";
}


/*Below line added for this CRF PER RH-206*/

function mychangerepDCCensusbyMorbidity()
 { 
	 if (document.getElementById('p_type').value=='D')
	 {
		 document.forms[0].p_report_id.value="MRDCCSMB";
		 document.getElementById("MY1").innerHTML=getLabel("Common.date.label","Common")+"&nbsp;"
		  document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='10' size='8' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','dd/mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
		 //  document.getElementById("MY2").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date' id='census_dt1' maxlength='10' size='8' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('census_dt1','dd/mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 
	 }
	 else  if (document.getElementById('p_type').value=='M')
	 {
		 document.forms[0].p_report_id.value="MRDCCSMB";
		 document.getElementById("MY1").innerHTML=getLabel("Common.month.label","Common")+"&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='5' size='5' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
		 //document.getElementById("MY2").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date' id='census_mth1' maxlength='5' size='5' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('census_mth1','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById('p_type').value=='Y')
	 {
		 document.forms[0].p_report_id.value="MRDCCSMB";
		 document.getElementById("MY1").innerHTML=getLabel("Common.year.label","Common")+"&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_fm_Date' id='p_fm_Date'  maxlength='4' size='4' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_fm_Date.select();return showCalendar('p_fm_Date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
		 //document.getElementById("MY2").innerHTML = "<input type='text' name='p_to_Date' id='p_to_Date' id='census_date1' maxlength='4' size='4' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_to_Date.select();return showCalendar('census_date1','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
 }	
 
 //End PER RH-206

 function SpCharChkForICD10(event)
{
	var strCheck = '0123456789.abcdefghijlkmnopqrstuvwxyzABCDEFGHIJLKMNOPQRSTUVWXYZ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
} 
/*Added by Ashwini on 26-Aug-2019 for ML-MMOH-CRF-1348*/
function enableSpecialty(obj)
{
	if(obj.value == 'SC')
	{
		document.forms[0].p_fm_speciality_code.disabled = false;
		document.forms[0].speciality_code.disabled = false;
	}else
	{
		document.forms[0].p_fm_speciality_code.disabled = true;
		document.forms[0].speciality_code.disabled = true;
		document.forms[0].p_fm_speciality_code.value = "";
	}
}
/*End ML-MMOH-CRF-1348*/

/*Added by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349*/
function getVisitType()
{
	var service_code = document.forms[0].p_location_type1.value;
	var clinic_code = document.forms[0].p_clinic.value;
	var facility_id = document.forms[0].p_facility_id.value;
	var language_id = document.forms[0].language_id.value;

	clear_list(document.forms[0].p_visit_type); 
	optSel	= document.createElement("OPTION");
	optSel.text = "------- "+getLabel("Common.defaultSelect.label","common_labels")+" -------";
	optSel.value= ''; 
	parent.frames[1].document.forms[0].p_visit_type.add(optSel);

	var xmlDoc=""
	var xmlHttp = new XMLHttpRequest()
	xmlStr = "<root><SEARCH service_code=\""+service_code+"\" clinic_code=\""+clinic_code+"\" facility_id=\""+facility_id+"\" language_id=\""+language_id+"\" action='getVisitType' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eMR/jsp/MRIntermediate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText = xmlHttp.responseText
	responseText = trimString(responseText)

	if(responseText.length>1)
	{
		var retVal_arr = responseText.split("~");

		for(var i=0;i<retVal_arr.length-1;i++){
			var code_desc_arr = retVal_arr[i].split("##");
			var element 	= parent.frames[1].document.createElement("OPTION");
			element.value 	= code_desc_arr[0];
			element.text 	= code_desc_arr[1] ;
			parent.frames[1].document.forms[0].p_visit_type.add(element);
		}
	}
}

function clear_list(obj){
  while(obj.options.length > 0){
   obj.remove(obj.options[0]);
 }
}
/*End ML-MMOH-CRF-1349*/

/*Added by Ashwini on 21-Oct-2019 for ML-MMOH-CRF-1357*/
async function searchNursingUnitCode(obj,target)
{
	var retVal = new String();
	var dialogHeight = "80vh";
	var dialogWidth	= "60vw";
	var status = "no";
	var arguments = "";
	var sql = "";
	var search_code = "";
	var search_desc = "";
	var facility_id = document.MRBRH212.p_facility_id.value;
	var tit = "";
	if(obj.name == "nurse")
	{	
		tit = getLabel("Common.nursingUnit.label","Common");
		sql = "select nursing_unit_code, short_Desc from ip_nursing_unit where appl_patient_class = 'DC' and facility_id = '"+facility_id+"' ";
		search_code = " nursing_unit_code";
		search_desc = "short_desc";
	}	
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+escape(sql)+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

	if(!(retVal == null))
	{
		target.value = retVal;
	}
	else
		target.focus();
}
/*End ML-MMOH-CRF-1357*/
//Added by Ashwin K for ML-MMOH-SCF-1859-TF on 28-02-2022
function DateComparison(from,format,to) 
{
	var fromdate = from.value ;
	var todate = to.value ;
	var flg2 = validDateObj_MR(to,format,localeName);
	if(flg2 && fromdate != '')
	{
		var greg_fromdate = convertDate(from.value,format,localeName,"en");
		var greg_todate = convertDate(to.value,format,localeName,"en");
		if(!isBefore(greg_fromdate,greg_todate,format,'en'))
		{
			if(format == 'DMY')
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				to.value = "";
				return false;
			}
			else if(format == 'MY')
			{
				var msg = getMessage("REMARKS_MUST_GR_EQUAL","COMMON");
				var replace1 = getLabel('Common.to.label','common')+" "+getLabel('Common.month.label','common');
				var replace2 = getLabel('Common.month.label','common');
				msg=msg.replace('$',replace1);
				msg=msg.replace('#',replace2);
				alert(msg);
				to.value = "";
				return false;
			}
			else if(format == 'YY')
			{
				var msg = getMessage("REMARKS_MUST_GR_EQUAL","COMMON");
				var replace1 = getLabel('Common.to.label','common')+" "+getLabel('Common.year.label','common');
				var replace2 = getLabel('Common.year.label','common');
				msg=msg.replace('$',replace1);
				msg=msg.replace('#',replace2);
				alert(msg);
				to.value = "";
				return false;
			}
			
		}	
	}
	return true;
}

function validDateObj_MR(date, format, locale){
	if(date.value != ''){
		var dateValue=date.value;
		var dateArray="";
		var dateArray1;
		var checkFlag=true;
		if(format=="DMY"){
			dateArray=dateValue.split("/");
			if(dateArray[2]==0){
				checkFlag=false;
			}else{
				if(locale=='th'){
					if(dateArray[2]<=543){
						checkFlag=false;
					}
				}
			}
		}else if(format=="DMYHM"){
			dateArray1=dateValue.split(" ");
			dateArray=(dateArray1[0]).split("/");
			if(dateArray[2]==0){
				checkFlag=false;
			}else{
				if(locale=='th'){
					if(dateArray[2]<=543){
						checkFlag=false;
					}
				}
			}
		}else if(format=="YY"){
			if(date==0){
				checkFlag=false;
			}else{
				if(locale=='th'){
					if(dateArray[2]<=543){
						checkFlag=false;
					}
				}
			}
		}else if(format=="MY"){
			dateArray=dateValue.split("/");
			if(dateArray[1]==0){
				checkFlag=false;
			}else{
				if(locale=='th'){
					if(dateArray[2]<=543){
						checkFlag=false;
					}
				}
			}
		}	
		if(checkFlag){
			if(!validDate(date.value,format,locale)){
				if(top.header != null){
					alert(top.header.getMessage("INVALID_DATE_FMT", "SM"));
				}else{
					alert(getMessage("INVALID_DATE_FMT", "SM"));
				}
				//date.select();
				//date.focus();
				date.value = "";
				return false;
			}else{
				return true;
			}
		}else{
			var msg=getMessage("INVALID_VALUE", "COMMON");
			alert(msg.replace('#',getLabel("Common.date.label","Common")));
			//date.select();
			//date.focus();
			date.value = "";
			return false;
		}
	}
}

//Ended by Ashwin K for ML-MMOH-SCF-1859-TF on 28-02-2022



//Added by Lakshmanan for ML-MMOH-CRF-2030 as on 01-07-2023 - Start
function validateToDate_MR(obj) {
		var to = obj.value;	  
		var fromdt=document.forms[0].P_FM_DATE.value;
		var dateAftMnth=plusDate(fromdt, 'DMY', 'en', 1, 'M');	
		if(obj.value!=''){
			if(!isBeforeNow(obj.value,"DMY",localeName)) {
				alert(getMessage("START_DATE_GREATER_SYSDATE","COMMON"));
				obj.select();
				obj.focus();
				return false ;
			}
		}
			if (fromdt!='') {
			if (isBetween(fromdt, dateAftMnth, to, 'DMY', 'en') == false && DateComparison(document.forms[0].P_FM_DATE,'DMY',obj)==true) {
					var census_date_from=getLabel("Common.DateRange.label","Common");
					var invaldt = getMessage("DATE1_GT_DATE2",'IP') ;
					var msg=getMessage("ONE_MONTH", "MR");
					invaldt=invaldt.replace('$',census_date_from);
					invaldt=invaldt.replace('#',msg);
					alert(invaldt);
					obj.value='';
					obj.focus();
				}
			}
		}	
function validateFromDate_MR(obj) {
		var from = obj.value;		
		var todt=document.forms[0].P_TO_DATE.value;
		if(obj.value!=''){
			if(!isBeforeNow(obj.value,"DMY",localeName)) {
				alert(getMessage("START_DATE_GREATER_SYSDATE","COMMON"));
				obj.select();
				obj.focus();
				return false ;
			}
		}
			var dateAftMnth=plusDate(from, 'DMY', 'en', 1, 'M');
			if (todt!='') {
			if (isBetween(from, dateAftMnth, todt, 'DMY', 'en') == false && DateComparison(obj,'DMY',document.forms[0].P_TO_DATE)==true) {
					var census_date_from=getLabel("Common.DateRange.label","Common");
					var invaldt = getMessage("DATE1_GT_DATE2",'IP') ;
					var msg=getMessage("ONE_MONTH", "MR");
					invaldt=invaldt.replace('$',census_date_from);
					invaldt=invaldt.replace('#',msg);
					alert(invaldt);
					obj.value='';
					obj.focus();
				}
			}
		}			

function getLocationType(obj) {
	var length = document.forms[0].locationType.length;
		for(i=0;i<length;i++)
		{
		document.forms[0].locationType.remove(1);
		}
	
	var HTMLVal = "<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eMR/jsp/EncTypeLocationList.jsp'><input type='hidden' name='encounterType' id='encounterType' value='" +obj.value + "'></form></BODY></HTML>";
	parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.messageFrame.document.form1.submit();
			
}
async function callSearchScreen_MR(){
		var patientid=await PatientSearch('','','','','','','Y','','','OTHER');;
		if(patientid !=null)
		document.forms[0].p_patient_id.value = patientid;
		 document.forms[0].p_patient_id.focus();
	}
function populateLocationType(obj){
		var p_enc_type=document.forms[0].p_enc_type.value;
		var opt;
		var length = document.forms[0].p_location_type.length;
		for(i=0;i<length;i++)
		{		document.forms[0].p_location_type.remove(1);
		}
		if (p_enc_type =="IP"){
		opt=document.createElement("OPTION");
		opt.text=getLabel("Common.nursingUnit.label","Common");
		opt.value='N';
		document.forms[0].p_location_type.add(opt);
		} else if (p_enc_type=="EM") {
			opt=document.createElement("OPTION");
			opt.text=getLabel("Common.EmergencyUnits.label","Common");
			opt.value='E';
			document.forms[0].p_location_type.add(opt);
		} else if (p_enc_type=="OP"){
			opt=document.createElement("OPTION");
			opt.text=getLabel("Common.clinic.label","Common");
			opt.value='C';
			document.forms[0].p_location_type.add(opt);
			opt=document.createElement("OPTION");
			opt.text=getLabel("Common.ProcedureUnit.label","Common");
			opt.value='P';
			document.forms[0].p_location_type.add(opt);
		} else if (p_enc_type=="DC") {
			opt=document.createElement("OPTION");
			opt.text=getLabel("Common.nursingUnit.label","Common");
			opt.value='N';
			document.forms[0].p_location_type.add(opt);
		}
}

//Added by Lakshmanan for ML-MMOH-CRF-2030 as on 01-07-2023 - End

