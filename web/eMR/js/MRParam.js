var prevTabObj=null;

function create() 
{
	
	f_query_add_mod.location.href = "../../eMR/jsp/AddModifyMRParam.jsp" ;
}

function edit() 
{
	
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function apply() 
{
	/// Added by Sridhar R on 8 Dec 2004
	/// To validate Age range..
/*if(f_query_add_mod.document.MRParamDiagProc_form.drg_calculation_yn.checked==true){

            var fields = new Array (f_query_add_mod.document.MRParamDiagProc_form.auth_appl_stage);
	        var names = new Array (getLabel("eMR.StageWhichAuthorizationApplicable.label","eMR"))
				
				if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
					
			  f_query_add_mod.document.MRParamDiagProc_form.submit();
	
			}

			else{
			
            frames[0].location.reload();
			return false;
			}
      }*/




	var proceed = "Y";

	var adult_min_age=f_query_add_mod.document.MRParamDiagProc_form.adult_min_age.value;
	var adult_min_unit=f_query_add_mod.document.MRParamDiagProc_form.adult_min_unit.value;
	var adult_max_age=f_query_add_mod.document.MRParamDiagProc_form.adult_max_age.value;
	var adult_max_unit=f_query_add_mod.document.MRParamDiagProc_form.adult_max_unit.value;

	var msg = parent.parent.frames[0].getMessage('MIN_GRT_TO_MAX','MP');
	var UnitMsg = parent.parent.frames[0].getMessage('CAN_NOT_BE_BLANK',"Common");
	UnitMsg = UnitMsg.replace('$',getLabel("Common.age.label","Common")+' '+getLabel("Common.Unit.label","Common"));
	
    f_query_add_mod.document.MRParamDiagProc_form.mr_pay_int_mode.value = f_query_add_mod.document.MRParamDiagProc_form.mr_pay_int_mode_type.value;
	
	if(!convertAge(adult_min_age, adult_min_unit,adult_max_age,adult_max_unit))
	{
		proceed = "N";
		messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+msg+'&err_value=0' ;
	}
	if(!ChkUnit(adult_min_age, adult_min_unit, adult_max_age, adult_max_unit))
	{
		proceed = "N";
		messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+UnitMsg+'&err_value=0' ;
	}
	
	var max_pri_diag_indicate_co_death=f_query_add_mod.document.MRParamDiagProc_form.max_pri_diag_indicate_co_death.value;

	var UnitMsg1 = parent.parent.frames[0].getMessage('CAN_NOT_BE_BLANK',"Common");
	UnitMsg1 = UnitMsg1.replace('$',getLabel("eMR.MaxPrimaryDiagnosisCauseOfDeath.label","MR"));

	if(max_pri_diag_indicate_co_death == "")
	{
		proceed = "N";
		messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+UnitMsg1+'&err_value=0' ;
	}
	
	/*Added by Thamizh selvi on 10th July 2017 for ML-MMOH-CRF-0719 Start*/
	var incompReqCancelApplicable	= f_query_add_mod.document.MRParamDiagProc_form.IncompReqCancelApplicable.value;
	if(incompReqCancelApplicable == "true"){
		var incompleteReqCancel		= f_query_add_mod.document.MRParamDiagProc_form.incompleteReqCancel.value;
		var errMsg					= parent.parent.frames[0].getMessage('CAN_NOT_BE_BLANK',"Common");
		if(incompleteReqCancel == ""){
			errMsg					= errMsg.replace('$',getLabel("eMR.IncompleteReqCancellation.label","MR"));
			proceed = "N";
			messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+errMsg+'&err_value=0' ;
			f_query_add_mod.document.MRParamDiagProc_form.incompleteReqCancel.focus();
		}
	}/*End*/

	var pead_min_age=f_query_add_mod.document.MRParamDiagProc_form.pead_min_age.value;
	var pead_min_unit=f_query_add_mod.document.MRParamDiagProc_form.pead_min_unit.value;
	var pead_max_age=f_query_add_mod.document.MRParamDiagProc_form.pead_max_age.value;
	var pead_max_unit=f_query_add_mod.document.MRParamDiagProc_form.pead_max_unit.value;

	if(!convertAge(pead_min_age, pead_min_unit, pead_max_age, pead_max_unit))
	{
		proceed = "N";
		messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+msg+'&err_value=0' ;
	}
	if(!ChkUnit(pead_min_age, pead_min_unit, pead_max_age, pead_max_unit))
	{
		proceed = "N";
		messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+UnitMsg+'&err_value=0' ;
	}


	var newborn_min_age		= f_query_add_mod.document.MRParamDiagProc_form.newborn_min_age.value;
	var newborn_min_unit	= f_query_add_mod.document.MRParamDiagProc_form.newborn_min_unit.value;
	var newborn_max_age		= f_query_add_mod.document.MRParamDiagProc_form.newborn_max_age.value;
	var newborn_max_unit	= f_query_add_mod.document.MRParamDiagProc_form.newborn_max_unit.value;

	if(!convertAge(newborn_min_age, newborn_min_unit, newborn_max_age, newborn_max_unit))
	{
		proceed = "N";
		messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+msg+'&err_value=0' ;
	}
	if(!ChkUnit(newborn_min_age, newborn_min_unit, newborn_max_age, newborn_max_unit))
	{
		proceed = "N";
		messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+UnitMsg+'&err_value=0' ;
	}

	/// End of Addition..
	var recode_proc_YN=f_query_add_mod.document.MRParamDiagProc_form.allow_recode_proc_yn;
	var OT_proc_YN=f_query_add_mod.document.MRParamDiagProc_form.allow_ot_proc_recode_yn;
	var Non_OT_proc_YN=f_query_add_mod.document.MRParamDiagProc_form.allow_non_ot_proc_recode_yn;
	if(recode_proc_YN.checked==true){
		if(OT_proc_YN.checked==false && Non_OT_proc_YN.checked ==false){
				var msg=getMessage("SLCT_OT_NONOT_PROC","MR");
				messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+msg+'&err_value=0' ;
				proceed="N";	
		}

	}

		var str="";

		 if (f_query_add_mod.document.MRParamDiagProc_form.addl_field1_prompt.value != "")
            {
                if (f_query_add_mod.document.MRParamDiagProc_form.addl_field1_length.value == "")
                {
                    str= str + getMessage("FIELD1_SIZE_BLANK","MP")+ "<br>";
                }
                if (f_query_add_mod.document.MRParamDiagProc_form.addl_field1_section.value == "")
                {
                    str= str + getMessage("FIELD1_SEC_BLANK","MP")+ "<br>";
                }

            }
            if (f_query_add_mod.document.MRParamDiagProc_form.addl_field2_prompt.value != "")
            {
                if (f_query_add_mod.document.MRParamDiagProc_form.addl_field2_length.value == "")
                {
                    str= str + getMessage("FIELD2_SIZE_BLANK","MP")+ "<br>";
                }
                if (f_query_add_mod.document.MRParamDiagProc_form.addl_field2_section.value == "")
                {
                    str= str + getMessage("FIELD2_SEC_BLANK","MP")+ "<br>";
                }

            }
            if (f_query_add_mod.document.MRParamDiagProc_form.addl_field3_prompt.value != "")
            {
                if (f_query_add_mod.document.MRParamDiagProc_form.addl_field3_length.value == "")
                {
                    str= str + getMessage("FIELD3_SIZE_BLANK","MP")+ "<br>";
                }
                if (f_query_add_mod.document.MRParamDiagProc_form.addl_field3_section.value == "")
                {
                    str= str + getMessage("FIELD3_SEC_BLANK","MP")+ "<br>";
                }

            }
            if (f_query_add_mod.document.MRParamDiagProc_form.addl_field4_prompt.value != "")
            {
                if (f_query_add_mod.document.MRParamDiagProc_form.addl_field4_length.value == "")
                {
                    str= str + getMessage("FIELD4_SIZE_BLANK","MP")+ "<br>";
                }
                if (f_query_add_mod.document.MRParamDiagProc_form.addl_field4_section.value == "")
                {
                    str= str + getMessage("FIELD4_SEC_BLANK","MP")+ "<br>";
                }

            }
            if (f_query_add_mod.document.MRParamDiagProc_form.addl_field5_prompt.value != "")
            {
                if (f_query_add_mod.document.MRParamDiagProc_form.addl_field5_length.value == "")
                {
                    str= str + getMessage("FIELD5_SIZE_BLANK","MP")+ "<br>";
                }
                if (f_query_add_mod.document.MRParamDiagProc_form.addl_field5_section.value == "")
                {
                    str= str + getMessage("FIELD5_SEC_BLANK","MP")+ "<br>";
                }
            }
			/*Below line Added for this CRF*/
			if(f_query_add_mod.document.MRParamDiagProc_form.diag_class_mand){
			         if(f_query_add_mod.document.MRParamDiagProc_form.diag_class_mand.checked==true) 
			            f_query_add_mod.document.MRParamDiagProc_form.diag_class_mand.value="Y";
			         else
			            f_query_add_mod.document.MRParamDiagProc_form.diag_class_mand.value="N";
			}

			/*var proc_type_setup			=	f_query_add_mod.document.MRParamDiagProc_form.proc_type_setup;//Added On 12/8/2009 for SRR-CRF-303.1

			if(recode_proc_YN.checked==true){
				if(OT_proc_YN.checked!=false && Non_OT_proc_YN.checked !=false){
					proc_type_setup.disabled=false;
					if(proc_type_setup.value==""){
					str= str + "Allow New Procedure Recode cannot be Blank"+ "<br>";	
					proceed = "N"
					}
				}
			}*/
			if (str != "")
			 {
				messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + str ;
			    proceed = "N"
			 }
	
/*
	var max_pri_diag_indicate_co_death=f_query_add_mod.document.MRParamDiagProc_form.max_pri_diag_indicate_co_death.value;
	var max_oth_dis_comp_indi_co_death=f_query_add_mod.document.MRParamDiagProc_form.max_oth_dis_comp_indi_co_death.value;
			
	    error  = getMessage("CANNOT_BE_ZERO","Common");
		error = error.replace('$', getLabel("eMR.MaxPrimaryDiagnosisCauseOfDeath.label","MR"));			
		
		if(max_pri_diag_indicate_co_death=="0"){ 		
			proceed="N";		
		messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+error+'&err_value=0' ;
		}

		error1  = getMessage("CANNOT_BE_ZERO","Common");
		error1 = error1.replace('$', getLabel("eMR.MaxOtherDiseaseCauseOfDeath.label","MR"));		
		
		if(max_oth_dis_comp_indi_co_death=="0"){ 			
			proceed="N";		
		messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+error1+'&err_value=0' ;
		}
*/



	if(proceed == "Y")
	{
		
		var fn_status = f_query_add_mod.document.MRParamDiagProc_form.function_name.value ;
		
		if(fn_status=="insert")	
		{
			//var errors = new String;
			//var fields = new //Array(f_query_add_mod.document.MRParamDiagProc_form.diag_code_scheme,f_query_add_mod.document.MRParamDiagProc_form.proc_code_scheme);

		//	var names = new Array ( getLabel("eMR.DiagnosisCodeScheme.label","MR"),getLabel("eMR.ProcedureCodeScheme.label","MR"));
			//if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
			//{
				f_query_add_mod.document.MRParamDiagProc_form.proc_type_setup.disabled=false;//Added On 12/8/2009 for SRR-CRF-303.1
				f_query_add_mod.document.MRParamDiagProc_form.submit();
				f_query_add_mod.document.MRParamDiagProc_form.function1.value='modify';
				f_query_add_mod.document.MRParamDiagProc_form.function_name.value='modify';
			/*}
			else
			{
			}*/
		}
		else if(fn_status=="modify")
		{
			//var errors = new String;
			//var fields = new //Array(f_query_add_mod.document.MRParamDiagProc_form.diag_code_scheme,f_query_add_mod.document.MRParamDiagProc_form.proc_code_scheme);

			//var names = new Array ( getLabel("eMR.DiagnosisCodeScheme.label","MR"),getLabel("eMR.ProcedureCodeScheme.label","MR"));
			//if(f_query_add_mod.checkFields( fields, names, messageFrame)) 
			//{		document.forms[0].drg_calculation_yn.disabled = true;

				 if (f_query_add_mod.document.MRParamDiagProc_form.addl_field1_prompt.value != "")
                    {
                        f_query_add_mod.document.MRParamDiagProc_form.addl_field1_prompt.disabled=false;
                        f_query_add_mod.document.MRParamDiagProc_form.addl_field1_length.disabled=false;
                        f_query_add_mod.document.MRParamDiagProc_form.addl_field1_section.disabled=false;
                    }
                    if (f_query_add_mod.document.MRParamDiagProc_form.addl_field2_prompt.value != "")
                    {
                        f_query_add_mod.document.MRParamDiagProc_form.addl_field2_prompt.disabled=false;
                        f_query_add_mod.document.MRParamDiagProc_form.addl_field2_length.disabled=false;
                        f_query_add_mod.document.MRParamDiagProc_form.addl_field2_section.disabled=false;
                    }
                    if (f_query_add_mod.document.MRParamDiagProc_form.addl_field3_prompt.value != "")
                    {
                        f_query_add_mod.document.MRParamDiagProc_form.addl_field3_prompt.disabled=false;
                        f_query_add_mod.document.MRParamDiagProc_form.addl_field3_length.disabled=false;
                        f_query_add_mod.document.MRParamDiagProc_form.addl_field3_section.disabled=false;
                    }
                    if (f_query_add_mod.document.MRParamDiagProc_form.addl_field4_prompt.value != "")
                    {
                        f_query_add_mod.document.MRParamDiagProc_form.addl_field4_prompt.disabled=false;
                        f_query_add_mod.document.MRParamDiagProc_form.addl_field4_length.disabled=false;
                        f_query_add_mod.document.MRParamDiagProc_form.addl_field4_section.disabled=false;
                    }
                    if (f_query_add_mod.document.MRParamDiagProc_form.addl_field5_prompt.value != "")
                    {
                        f_query_add_mod.document.MRParamDiagProc_form.addl_field5_prompt.disabled=false;
                        f_query_add_mod.document.MRParamDiagProc_form.addl_field5_length.disabled=false;
                        f_query_add_mod.document.MRParamDiagProc_form.addl_field5_section.disabled=false;
                    }
					
					//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
					if(f_query_add_mod.document.MRParamDiagProc_form.isDeceasedDiagClassDeathRegAppl.value == "true")
					{
						f_query_add_mod.document.MRParamDiagProc_form.primary_diag_class.disabled = false;
						f_query_add_mod.document.MRParamDiagProc_form.pri_mand_postmortem_ip_yn.disabled = false;
						f_query_add_mod.document.MRParamDiagProc_form.pri_mand_postmortem_dc_yn.disabled = false;
						f_query_add_mod.document.MRParamDiagProc_form.pri_mand_postmortem_op_yn.disabled = false;
						f_query_add_mod.document.MRParamDiagProc_form.pri_mand_postmortem_ae_yn.disabled = false;
						f_query_add_mod.document.MRParamDiagProc_form.pri_mand_non_postmortem_ip_yn.disabled = false;
						f_query_add_mod.document.MRParamDiagProc_form.pri_mand_non_postmortem_dc_yn.disabled = false;
						f_query_add_mod.document.MRParamDiagProc_form.pri_mand_non_postmortem_op_yn.disabled = false;
						f_query_add_mod.document.MRParamDiagProc_form.pri_mand_non_postmortem_ae_yn.disabled = false;
						f_query_add_mod.document.MRParamDiagProc_form.secondary_diag_class.disabled = false;
						f_query_add_mod.document.MRParamDiagProc_form.sec_mand_postmortem_ip_yn.disabled = false;
						f_query_add_mod.document.MRParamDiagProc_form.sec_mand_postmortem_dc_yn.disabled = false;
						f_query_add_mod.document.MRParamDiagProc_form.sec_mand_postmortem_op_yn.disabled = false;
						f_query_add_mod.document.MRParamDiagProc_form.sec_mand_postmortem_ae_yn.disabled = false;
						f_query_add_mod.document.MRParamDiagProc_form.sec_mand_non_postmortem_ip_yn.disabled = false;
						f_query_add_mod.document.MRParamDiagProc_form.sec_mand_non_postmortem_dc_yn.disabled = false;
						f_query_add_mod.document.MRParamDiagProc_form.sec_mand_non_postmortem_op_yn.disabled = false;
						f_query_add_mod.document.MRParamDiagProc_form.sec_mand_non_postmortem_ae_yn.disabled = false;
					}

				f_query_add_mod.document.MRParamDiagProc_form.auth_at_stage.disabled=false;
				f_query_add_mod.document.MRParamDiagProc_form.drg_calculation_yn.disabled=false;
				f_query_add_mod.document.MRParamDiagProc_form.diag_enc_level.disabled=false;//Maheshwaran K added for the CRF : SKR-CRF-0020 as on 13/08/2013
				f_query_add_mod.document.MRParamDiagProc_form.proc_type_setup.disabled=false;//Added On 12/8/2009 for SRR-CRF-303.1
				f_query_add_mod.document.MRParamDiagProc_form.submit();
				f_query_add_mod.document.MRParamDiagProc_form.auth_at_stage.disabled=true;
				f_query_add_mod.document.MRParamDiagProc_form.drg_calculation_yn.disabled=true;
				f_query_add_mod.document.MRParamDiagProc_form.diag_enc_level.disabled=true;//Maheshwaran K added for the CRF : SKR-CRF-0020 as on 13/08/2013
				f_query_add_mod.document.MRParamDiagProc_form.function1.value='modify';
				f_query_add_mod.document.MRParamDiagProc_form.function_name.value='modify';
			//}
		}
		else
		{
			
			messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num= '
		}

		f_query_add_mod.location.href='../../eMR/jsp/AddModifyMRParam.jsp'
	}
}

function onSuccess() 
{
	
	f_query_add_mod.location.href='../../eMR/jsp/AddModifyMRParam.jsp'
}

function reset() 
{
	
	f_query_add_mod.location.reload();

	f_query_add_mod.document.MRParamDiagProc_form.adult_max_unit.value = f_query_add_mod.document.MRParamDiagProc_form.hdd_adult_max_age_unit.value ; 

	f_query_add_mod.document.MRParamDiagProc_form.adult_min_unit.value = f_query_add_mod.document.MRParamDiagProc_form.hdd_adult_min_age_unit.value ; 

	f_query_add_mod.document.MRParamDiagProc_form.newborn_max_unit.value = f_query_add_mod.document.MRParamDiagProc_form.hdd_nb_max_age_unit.value ; 

	f_query_add_mod.document.MRParamDiagProc_form.newborn_min_unit.value = f_query_add_mod.document.MRParamDiagProc_form.hdd_nb_min_age_unit.value ; 

	f_query_add_mod.document.MRParamDiagProc_form.pead_max_unit.value = f_query_add_mod.document.MRParamDiagProc_form.hdd_pead_max_age_unit.value ; 

	f_query_add_mod.document.MRParamDiagProc_form.pead_min_unit.value = f_query_add_mod.document.MRParamDiagProc_form.hdd_pead_min_age_unit.value ; 
	


}


/// Function Added by Sridhar R on 8 Dec 2004...
/// Function used to compare max & min Age by converting yrs, months into Days...
function convertAge(minAge, minUnit, maxAge, maxUnit)
{
	
	if(minAge == '' && minUnit == '')
	{
		minAge = "0";
		minUnit = "D";
	}
	if(maxAge == '' && maxUnit == '')
	{
		maxAge = "0";
		maxUnit = "D";
	}

	if(minUnit == 'D')
		minAge = parseInt(minAge)*1;
	else if(minUnit == 'M')
		minAge = parseInt(minAge)*12;
	else if(minUnit == 'Y')
		minAge = parseInt(minAge)*365;

//		alert("minAge in "+minUnit+" is : "+minAge);

/////////////////////////////////////////////////////////

	if(maxUnit == 'D')
		maxAge = parseInt(maxAge)*1;
	else if(maxUnit == 'M')
		maxAge = parseInt(maxAge)*12;
	else if(maxUnit == 'Y')
		maxAge = parseInt(maxAge)*365;

//	alert("maxAge in "+maxUnit+" is : "+maxAge);

	if(maxAge >= minAge)
		return true;
	else
		return false;

}


/// Function Added by Sridhar R on 8 Dec 2004...
/// Function used to check whether unit is selected for a entered age...
function ChkUnit(minAge, minUnit, maxAge, maxUnit)
{
	
	if(minAge != '' && minUnit == '' && parseInt(minAge) != '0')
		return false;
	
	if(maxAge != '' && maxUnit == '' && parseInt(maxAge) != '0')
		return false;
	else
		return true;

}
//added
function chkAge(unit,age)
{
	
	if(age.value =='')
		unit.value="";
}

function clearUnit(val,unit)
{
	
	if(val == '')
		unit.value="";
}


function CheckZeroVal(obj) 
{
		
/*--- below line(s) added by venkatesh.S  and Emp:ID-4008  on 18/Jan/2012 aganist  KDAH-CRF-0032---*/
var field_name=obj.name

if(field_name=='rep_date_range')
{

      if(obj.value == '0' || obj.value == '00' || obj.value == '000' || obj.value == '0000')
	{		 
		alert(getMessage("VALUE_GREAT_ZERO","MP")) ;
		obj.value="";
		obj.focus();
		}
	
	if(obj.value=='null' || obj.value=='')
		{
		var label=getLabel("eMR.NotifyDisLabTestReportDateRange.label","MR");
		var error=getMessage("CAN_NOT_BE_BLANK","Common")
		alert (error.replace("$",label))
		obj.value="";
		obj.focus();
		}
document.MRParamDiagProc_form.rep_date_range.value=obj.value;

/* ----end KDAH-CRF-0032---*/

	
} }

function beforeG6pdVal(target)
{
	var g6pd_discr_msr_desc=document.MRParamDiagProc_form.g6pd_discr_msr_desc.value ;
	if (g6pd_discr_msr_desc != target.value) 
	{
		if ( target.value != "" ) 
			getG6pdVal(target,target)
		else
		   document.MRParamDiagProc_form.g6pd_discr_msr_id.value = "";
	}
}

async function getG6pdVal(target,obj)
{
	var g6pd_discr_msr_desc=document.MRParamDiagProc_form.g6pd_discr_msr_desc.value ;
	if ( (g6pd_discr_msr_desc != target.value) || (obj.type=="button") )
	{
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		argumentArray[0] ="select discr_msr_id code, short_desc description from am_discr_msr where result_type='L' and eff_status='E' and Upper(discr_msr_id) like upper(?) and upper(short_desc) like upper(?)";
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2"; 
		argumentArray[5] = 	target.value;
		argumentArray[6] = CODE_DESC_LINK ;
		argumentArray[7] = CODE_DESC ;
	    retVal = await CommonLookup(getLabel("Common.g6pd.label","Common"), argumentArray );
	    //console.log(retVal) ;
		if(retVal != null && retVal != "")
		{
			target.value =  retVal[0].split(',')[1] ; //retVal[1] ;
			document.MRParamDiagProc_form.g6pd_discr_msr_id.value = retVal[0].split(',')[0]; //retVal[0];
			document.MRParamDiagProc_form.g6pd_discr_msr_desc.value =  retVal[0].split(',')[1] ; //retVal[1];
		}
		else
		{
			target.value = "" ;
			document.MRParamDiagProc_form.g6pd_discr_msr_id.value = "";
			document.MRParamDiagProc_form.g6pd_discr_msr_desc.value ="";
		}
	}
	return;
}

function beforeSiccVal(target)
{
	var sicc_discr_msr_desc=document.MRParamDiagProc_form.sicc_discr_msr_desc.value ;
	if  (sicc_discr_msr_desc != target.value) 
	{
		if ( target.value != "" ) 
			getSiccVal(target,target)
		else
		   document.MRParamDiagProc_form.sicc_discr_msr_id.value = "";
	}

}


async function getSiccVal(target,obj)
{
	var sicc_discr_msr_desc=document.MRParamDiagProc_form.sicc_discr_msr_desc.value ;
	if  ( (sicc_discr_msr_desc != target.value) || (obj.type=="button") )
	{
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;						
		var dataTypeArray  = new Array() ;
		argumentArray[0] ="select discr_msr_id code, short_desc description from am_discr_msr where result_type='L' and eff_status='E'and Upper(discr_msr_id) like upper(?) and upper(short_desc) like upper(?)"
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2"; 
		argumentArray[5] = 	target.value;
		argumentArray[6] = CODE_DESC_LINK ;
		argumentArray[7] = CODE_DESC ;
		retVal = await CommonLookup(getLabel("Common.sicc.label","Common"), argumentArray );
		
//		console.log("2: " + retVal);
		if(retVal != null && retVal != "")
		{
			target.value = retVal[0].split(',')[1] ; // retVal[1] ;
			document.MRParamDiagProc_form.sicc_discr_msr_id.value = retVal[0].split(',')[0]; // retVal[0];
			document.MRParamDiagProc_form.sicc_discr_msr_desc.value = retVal[0].split(',')[1] ;//retVal[1];
		}
		else
		{
			target.value = "" ;
			document.MRParamDiagProc_form.sicc_discr_msr_id.value = "";
			document.MRParamDiagProc_form.sicc_discr_msr_desc.value ="";
		}
	}
	return;
}
function checkME1(obj){
		var chk_OT_proc=document.forms[0].chk_OT_proc.value
if (obj.checked==true)
 {
	if(chk_OT_proc=="true"){
		document.forms[0].allow_ot_proc_recode_yn.disabled = false;
	}else{
		document.forms[0].allow_ot_proc_recode_yn.disabled = true;
	}
		document.forms[0].allow_non_ot_proc_recode_yn.disabled = false;
 }
 else{
    document.forms[0].allow_ot_proc_recode_yn.disabled = true;
    document.forms[0].allow_non_ot_proc_recode_yn.disabled = true;
	document.forms[0].allow_ot_proc_recode_yn.checked=false;
	document.forms[0].allow_non_ot_proc_recode_yn.checked=false;

}

   
}



function checkME2(obj){
	if (obj.checked==true)
	{
document.forms[0].max_level_for_op_yn.disabled = false;
document.forms[0].max_level_for_ip_yn.disabled = false;
document.forms[0].max_level_for_dc_yn.disabled = false;
document.forms[0].max_level_for_em_yn.disabled = false;

	}else{
document.forms[0].max_level_for_op_yn.disabled = true;
document.forms[0].max_level_for_ip_yn.disabled = true;
document.forms[0].max_level_for_dc_yn.disabled = true;
document.forms[0].max_level_for_em_yn.disabled = true;
document.forms[0].grace_period.value = "";

document.forms[0].max_level_for_op_yn.checked  = false;
document.forms[0].max_level_for_ip_yn.checked  = false;
document.forms[0].max_level_for_dc_yn.checked  = false;
document.forms[0].max_level_for_em_yn.checked  = false;
	}
}

function checkME3(){
	var diag=document.forms[0].allow_recode_diag_yn.checked;
	
	var proc=document.forms[0].allow_recode_proc_yn.checked;
	
	if ((diag==true) ||(proc==true)){
		document.forms[0].recode_for_op_yn.disabled = false;
		document.forms[0].recode_for_ip_yn.disabled = false;
		document.forms[0].recode_for_dc_yn.disabled = false;
		document.forms[0].recode_for_em_yn.disabled = false;
		document.forms[0].recode_allow_beynd_max_lev_yn.disabled = false;
		document.forms[0].drg_calculation_yn.disabled = false;
		if(document.forms[0].auth_at_stage.value==""){
			document.forms[0].auth_at_stage.disabled = false;
			document.forms[0].auth_at_stage.options[0].selected=true;
		}
		//document.forms[0].grace_period.disabled = false;
	
	}
	else{
		document.forms[0].recode_for_op_yn.disabled = true;
		document.forms[0].recode_for_ip_yn.disabled = true;
		document.forms[0].recode_for_dc_yn.disabled = true;
		document.forms[0].recode_for_em_yn.disabled = true;
		document.forms[0].recode_allow_beynd_max_lev_yn.disabled = true;
		document.forms[0].drg_calculation_yn.disabled = true;
		//document.forms[0].grace_period.disabled = true;
		document.forms[0].grace_period.value = "";
		document.forms[0].auth_at_stage.value = "";
		document.forms[0].auth_at_stage.disabled = true;
//		document.forms[0].auth_at_stage.value = "";//Hidden Vairable
		
		document.forms[0].recode_allow_beynd_max_lev_yn.value="";

		document.forms[0].recode_for_op_yn.checked = false;
		document.forms[0].recode_for_ip_yn.checked = false;
		document.forms[0].recode_for_dc_yn.checked = false;
		document.forms[0].recode_for_em_yn.checked = false;
		document.forms[0].recode_allow_beynd_max_lev_yn.checked = false;
		document.forms[0].drg_calculation_yn.checked = false;

		document.forms[0].max_level_for_op_yn.checked  = false;
        document.forms[0].max_level_for_ip_yn.checked  = false;
        document.forms[0].max_level_for_dc_yn.checked  = false;
        document.forms[0].max_level_for_em_yn.checked  = false;
		document.forms[0].max_level_for_op_yn.disabled = true;
        document.forms[0].max_level_for_ip_yn.disabled = true;
        document.forms[0].max_level_for_dc_yn.disabled = true;
        document.forms[0].max_level_for_em_yn.disabled = true;

	}
}
function checkME4(obj){


if(obj.checked==true){
		
		document.forms[0].auth_at_stage.disabled = false;

	}	
	else{
    document.forms[0].auth_at_stage.disabled = true;

     }
}
function checkME5(obj){



if(obj.checked==true){

		
		document.forms[0].grace_period.disabled = false;

	}	
	else{
		
    document.forms[0].grace_period.disabled = true;

     }
}
/*function _ChkNumberInput(id, e, deci)
{

if (parseInt(deci)>0)
   var strCheck = '.123';
else
   var strCheck = '123';
	
var whichCode = (window.Event) ? e.which : e.keyCode;
if (whichCode == 13) return true; 

key = String.fromCharCode(whichCode);  
if (strCheck.indexOf(key) == -1) {
	alert("Enter serial number range of 1 2 3");
	//messageFrame.location.href=src='../../eCommon/jsp/MstCodeError.jsp?';
	
	return false;
}  

if(key == "." && id.value.indexOf(key) != -1) return false; 
}*/


function opValidate(obj){
	if( (document.forms[0].recode_allow_beynd_max_lev_yn.checked==true) && (document.forms[0].recode_for_op_yn.checked==true)  ){

		document.forms[0].max_level_for_op_yn.disabled=false;
	}else{
		document.forms[0].max_level_for_op_yn.disabled=true;
		document.forms[0].max_level_for_op_yn.checked=false;
	}

}
function ipValidate(obj){
	if( (document.forms[0].recode_for_ip_yn.checked==true) && (document.forms[0].recode_allow_beynd_max_lev_yn.checked==true) ){
		document.forms[0].max_level_for_ip_yn.disabled=false;
	}else{
		document.forms[0].max_level_for_ip_yn.disabled=true;
		document.forms[0].max_level_for_ip_yn.checked=false;
	}

}

function dcValidate(obj){
	if( (document.forms[0].recode_for_dc_yn.checked==true) && (document.forms[0].recode_allow_beynd_max_lev_yn.checked==true) ){
		document.forms[0].max_level_for_dc_yn.disabled=false;
	}else{
		document.forms[0].max_level_for_dc_yn.disabled=true;
		document.forms[0].max_level_for_dc_yn.checked=false;
	}

}

function emValidate(obj){
	if( (document.forms[0].recode_for_em_yn.checked==true) && (document.forms[0].recode_allow_beynd_max_lev_yn.checked==true) ){
		document.forms[0].max_level_for_em_yn.disabled=false;
	}else{
		document.forms[0].max_level_for_em_yn.disabled=true;
		document.forms[0].max_level_for_em_yn.checked=false;
	}

}
function changeValue(obj){
//	document.forms[0].auth_at_stage.value=obj.value;
//alert(document.forms[0].auth_at_stage.value)
}

function tab_click(objName)
    {
		selectTab(objName);
        tab_click1(objName);
    }


function selectTab(tabObj){	 			
		if(prevTabObj!=null){
				document.getElementById(prevTabObj).className="tabA";
				document.getElementById(prevTabObj+"span").className="tabAspan";
			}
			document.getElementById(tabObj).className="tabClicked";
			document.getElementById(tabObj+"span").className="tabSpanclicked";
			prevTabObj=tabObj
}


 function tab_click1(objName)
	{	
		 
		   if(objName=="general")
			{				
			   	
			  document.getElementById('general_div').style.visibility='visible';
				document.getElementById('general_div').style.display='';
				document.getElementById('Diagnosis_div').style.visibility='hidden';
				document.getElementById('Diagnosis_div').style.display='none';
			}
		   if(objName=="Diagnosis")
			{
			 

			  document.getElementById('Diagnosis_div').style.visibility='visible';
			  document.getElementById('Diagnosis_div').style.display='';
				document.getElementById('general_div').style.visibility='hidden';
				document.getElementById('general_div').style.display='none';

				 
				
			}
	}



function CheckForSpecChars(event){
    var strCheck = '123456789';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}
function CheckForSpecChars1(event){
    var strCheck = '0123456789';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

 function valid_dat(Obj){  
	var temp=0; 
	if(Obj.value!=""){
		if ((Obj.value=="0")||(Obj.value=="00")){ 
			alert(getMessage("INVALID_POSITIVE_NUMBER","Common"));
			Obj.focus();	
			}
		}
	}

function checkDecimal(obj)
{
	if (obj.value != '')
	{
		if (isNaN(obj.value) == false && obj.value >= 0)
		{
			if (obj.value.indexOf('.') != -1)
			{
				//alert(getMessage("INVALID_INTEGER","MP"));
				alert(getMessage("INVALID_INTEGER","MR"));
				obj.select();
				obj.focus();
			}			
		}
	}
}
function enablefld(val)
{
   if (val == 1)
    {
        if (MRParamDiagProc_form.addl_field1_prompt.value != "")
        {
			if(document.MRParamDiagProc_form.addl_field1_length.disabled){
	            document.MRParamDiagProc_form.addl_field1_length.disabled=false;
		        document.MRParamDiagProc_form.addl_field1_length.focus();
			}
            document.MRParamDiagProc_form.addl_field1_section.disabled=false;
		}
        else
        {
            document.MRParamDiagProc_form.addl_field1_length.value="";
            document.MRParamDiagProc_form.addl_field1_section.value="";
            document.MRParamDiagProc_form.addl_field1_length.disabled=true;
            document.MRParamDiagProc_form.addl_field1_section.disabled=true;
        }
    }
    else if (val == 2)
    {
        if (MRParamDiagProc_form.addl_field2_prompt.value != "")
        {
			if(document.MRParamDiagProc_form.addl_field2_length.disabled){
	            document.MRParamDiagProc_form.addl_field2_length.disabled=false;
		        document.MRParamDiagProc_form.addl_field2_length.focus();
			}
            document.MRParamDiagProc_form.addl_field2_section.disabled=false;
        }
        else
        {
            document.MRParamDiagProc_form.addl_field2_length.value="";
            document.MRParamDiagProc_form.addl_field2_section.value="";
            document.MRParamDiagProc_form.addl_field2_length.disabled=true;
            document.MRParamDiagProc_form.addl_field2_section.disabled=true;

        }
    }
    else if (val == 3)
    {
        if (MRParamDiagProc_form.addl_field3_prompt.value != "")
        {
			if(document.MRParamDiagProc_form.addl_field3_length.disabled){
	            document.MRParamDiagProc_form.addl_field3_length.disabled=false;
		        document.MRParamDiagProc_form.addl_field3_length.focus();
			}
            document.MRParamDiagProc_form.addl_field3_section.disabled=false;
        }
        else
        {
            document.MRParamDiagProc_form.addl_field3_length.value="";
            document.MRParamDiagProc_form.addl_field3_section.value="";
            document.MRParamDiagProc_form.addl_field3_length.disabled=true;
            document.MRParamDiagProc_form.addl_field3_section.disabled=true;
        }
    }
    else if (val == 4)
    {
        if (MRParamDiagProc_form.addl_field4_prompt.value != "")
        {
			if(document.MRParamDiagProc_form.addl_field4_length.disabled){
	            document.MRParamDiagProc_form.addl_field4_length.disabled=false;
		        document.MRParamDiagProc_form.addl_field4_length.focus();
			}
            document.MRParamDiagProc_form.addl_field4_section.disabled=false;
        }
        else
        {
            document.MRParamDiagProc_form.addl_field4_length.value="";
            document.MRParamDiagProc_form.addl_field4_section.value="";
            document.MRParamDiagProc_form.addl_field4_length.disabled=true;
            document.MRParamDiagProc_form.addl_field4_section.disabled=true;

        }
    }
    else if (val == 5)
    {
        if (MRParamDiagProc_form.addl_field5_prompt.value != "")
        {
			if(document.MRParamDiagProc_form.addl_field5_length.disabled){
	            document.MRParamDiagProc_form.addl_field5_length.disabled=false;
		        document.MRParamDiagProc_form.addl_field5_length.focus();
			}
			document.MRParamDiagProc_form.addl_field5_section.disabled=false;
        }
        else
        {
            document.MRParamDiagProc_form.addl_field5_length.value="";
            document.MRParamDiagProc_form.addl_field5_section.value="";
            document.MRParamDiagProc_form.addl_field5_length.disabled=true;
            document.MRParamDiagProc_form.addl_field5_section.disabled=true;
        }
    }

}
/*Added on 12/7/2009 for SRR-CRF-303.1*/

/*function ListValues(){
//	alert(document.forms[0].proc_type_setup.value)
	/*var proc_type_setup						=  document.forms[0].proc_type_setup;
	var allow_ot_proc_recode_yn			= document.forms[0].allow_ot_proc_recode_yn;
	var allow_non_ot_proc_recode_yn	= document.forms[0].allow_non_ot_proc_recode_yn;
	var allow_recode_proc_yn				= document.forms[0].allow_recode_proc_yn;
	var proc_type_mand						= document.getElementById("proc_type_mand");
	if(allow_recode_proc_yn.checked==true){	 
		if(proc_type_setup.value==""){
			proc_type_mand.style.visibility="visible";
		}else{
			proc_type_mand.style.visibility="hidden";
		}
	}else{
			proc_type_mand.style.visibility="hidden";
	}
}*/

function checkProcType(obj){
	var proc_type_setup	=  document.forms[0].proc_type_setup;
	var proc_type_mand	= document.getElementById('proc_type_mand');
	var allow_ot_proc_recode_yn			= document.forms[0].allow_ot_proc_recode_yn;
	var allow_non_ot_proc_recode_yn	= document.forms[0].allow_non_ot_proc_recode_yn;


	if (obj.checked==false){
			if(!proc_type_setup.options[3]){
				var opt= document.createElement('Option');
				opt.text="---"+getLabel("Common.Select.label","MR")+"---";
				opt.value=""; 
				proc_type_setup.add(opt)
				proc_type_setup.options[3].selected=true;
				proc_type_setup.disabled=true;
			}

//			proc_type_setup.options[3].selected=true;
//			proc_type_setup.disabled=true;
	}/*else{
		if(allow_ot_proc_recode_yn.checked!=false && allow_non_ot_proc_recode_yn.checked!=false ){
			proc_type_setup.options[0].selected=true;
			proc_type_setup.disabled=false;
			proc_type_mand.style.visibility="visible";
		}

	}*/
}
function poplulateProclistvals(){
	var allow_ot_proc_recode_yn			= document.forms[0].allow_ot_proc_recode_yn;
	var allow_non_ot_proc_recode_yn	= document.forms[0].allow_non_ot_proc_recode_yn;
	var allow_recode_proc_yn				= document.forms[0].allow_recode_proc_yn;
	var proc_type_mand						= document.getElementById('proc_type_mand');

	var proc_type_setup	=  document.forms[0].proc_type_setup;
	var len = proc_type_setup.options.length;
	var proc_type_setup	=  document.forms[0].proc_type_setup;
	var len = proc_type_setup.options.length;
		if(allow_ot_proc_recode_yn.checked==true && allow_non_ot_proc_recode_yn.checked==true){
			proc_type_setup.remove(3);
			proc_type_setup.options[0].selected=true;
			proc_type_setup.disabled=false;
		}else if(allow_ot_proc_recode_yn.checked==true){
			proc_type_setup.remove(3);
			proc_type_setup.options[1].selected=true;
			proc_type_setup.disabled=true;
		}else if(allow_non_ot_proc_recode_yn.checked==true){
			proc_type_setup.remove(3);
			proc_type_setup.options[2].selected=true;
			proc_type_setup.disabled=true;
		}else{
//			var opt= document.createElement('Option');
//			opt.text="---Select---";
//			opt.value=""; 
//			proc_type_setup.add(opt)
////			proc_type_setup.options[3].text="---Select---";
////			proc_type_setup.options[3].value=""; 
////			proc_type_setup.add(opt)
//
			if(!proc_type_setup.options[3]){
				var opt= document.createElement('Option');
				opt.text="---"+getLabel("Common.Select.label","MR")+"---";
				opt.value=""; 
				proc_type_setup.add(opt)
				proc_type_setup.options[3].selected=true;
				proc_type_setup.disabled=true;
			}
			return false;
		}
}

/*Added by Thamizh selvi on 16th Feb 2017 for ML-MMOH-CRF-0777 Start*/
function zeroValChk(obj)
{
	if(obj.value == '0' || obj.value == '00')
	{		 
		alert(getMessage("VALUE_GREAT_ZERO","MP")) ;
		obj.value="";
		obj.focus();
	}
}
/*End*/

/*Added by Ashwini on 12-Oct-2017 for ML-MMOH-CRF-0720*/
function medReportConfig()
{
	var returnVal = "";
	var mr_hdr_line1=document.forms[0].mr_hdr_line1.value;
	var mr_hdr_line2=document.forms[0].mr_hdr_line2.value;
	var mr_hdr_line3=document.forms[0].mr_hdr_line3.value;
	var mr_hdr_line4=document.forms[0].mr_hdr_line4.value;
	var mr_hdr_line5=document.forms[0].mr_hdr_line5.value;
	var mr_hdr_line6=document.forms[0].mr_hdr_line6.value;
	var mr_hdr_line7=document.forms[0].mr_hdr_line7.value;//Added By Dharma on 27/11/2019 against  ML-MMOH-CRF-1360
	var mr_sign_line1=document.forms[0].mr_sign_line1.value;
	var mr_sign_line2=document.forms[0].mr_sign_line2.value;
	var mr_sign_line3=document.forms[0].mr_sign_line3.value;
	var mr_sign_line4=document.forms[0].mr_sign_line4.value;
	var mr_sign_line5=document.forms[0].mr_sign_line5.value;
	var mr_sign_line6=document.forms[0].mr_sign_line6.value;
	var mr_sign_line7=document.forms[0].mr_sign_line7.value;
	var mr_sign_line8=document.forms[0].mr_sign_line8.value;//Added by Ashwini on 16-Oct-2018 for ML-MMOH-CRF-1282
	var mr_sign_line9=document.forms[0].mr_sign_line9.value;//Added By Dharma on 29/11/2019 against  ML-MMOH-CRF-1365
	
	var dialogHeight ='30vh' ;
	var dialogWidth = '50vw' ;
	
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
	var arguments = "";
	returnVal = window.showModalDialog("../../eMR/jsp/MedReportConfig.jsp?mr_hdr_line1="+mr_hdr_line1+"&mr_hdr_line2="+mr_hdr_line2+"&mr_hdr_line3="+mr_hdr_line3+"&mr_hdr_line4="+mr_hdr_line4+"&mr_hdr_line5="+mr_hdr_line5+"&mr_hdr_line6="+mr_hdr_line6+"&mr_sign_line1="+mr_sign_line1+"&mr_sign_line2="+mr_sign_line2+"&mr_sign_line3="+mr_sign_line3+"&mr_sign_line4="+mr_sign_line4+"&mr_sign_line5="+mr_sign_line5+"&mr_sign_line6="+mr_sign_line6+"&mr_sign_line7="+mr_sign_line7+"&mr_sign_line8="+mr_sign_line8+"&mr_hdr_line7="+mr_hdr_line7+"&mr_sign_line9="+mr_sign_line9,arguments,features); 
	
	if(returnVal!=""&&returnVal!=null )
	{
		var finalresults=returnVal.split("||");
		document.forms[0].mr_hdr_line1.value= finalresults[0]
		document.forms[0].mr_hdr_line2.value= finalresults[1]
		document.forms[0].mr_hdr_line3.value= finalresults[2]
		document.forms[0].mr_hdr_line4.value= finalresults[3]
		document.forms[0].mr_hdr_line5.value= finalresults[4]
		document.forms[0].mr_hdr_line6.value= finalresults[5]
		document.forms[0].mr_sign_line1.value= finalresults[6]
		document.forms[0].mr_sign_line2.value= finalresults[7]
		document.forms[0].mr_sign_line3.value= finalresults[8]
		document.forms[0].mr_sign_line4.value= finalresults[9]
		document.forms[0].mr_sign_line5.value= finalresults[10]
		document.forms[0].mr_sign_line6.value= finalresults[11]
		document.forms[0].mr_sign_line7.value= finalresults[12]
		document.forms[0].mr_sign_line8.value= finalresults[13] //Added by Ashwini on 16-Oct-2018 for ML-MMOH-CRF-1282
		document.forms[0].mr_hdr_line7.value= finalresults[14];//Added By Dharma on 27/11/2019 against  ML-MMOH-CRF-1360
		document.forms[0].mr_sign_line9.value= finalresults[15]//Added By Dharma on 29/11/2019 against  ML-MMOH-CRF-1365
	}
}

function closeMedRepConfig()
{
	var mr_hdr_line1=document.getElementById('mr_hdr_line1').value;
	var mr_hdr_line2=document.getElementById('mr_hdr_line2').value;
	var mr_hdr_line3=document.getElementById('mr_hdr_line3').value;
	var mr_hdr_line4=document.getElementById('mr_hdr_line4').value;
	var mr_hdr_line5=document.getElementById('mr_hdr_line5').value;
	var mr_hdr_line6=document.getElementById('mr_hdr_line6').value;
	var mr_hdr_line7=document.getElementById('mr_hdr_line7').value;
	
	var mr_sign_line1=document.getElementById('mr_sign_line1').value;
	var mr_sign_line2=document.getElementById('mr_sign_line2').value;
	var mr_sign_line3=document.getElementById('mr_sign_line3').value;
	var mr_sign_line4=document.getElementById('mr_sign_line4').value;
	var mr_sign_line5=document.getElementById('mr_sign_line5').value;
	var mr_sign_line6=document.getElementById('mr_sign_line6').value;
	var mr_sign_line7=document.getElementById('mr_sign_line7').value;
	var mr_sign_line8=document.getElementById('mr_sign_line8').value; //Added by Ashwini on 16-Oct-2018 for ML-MMOH-CRF-1282
	var mr_sign_line9=document.getElementById('mr_sign_line9').value;//Added By Dharma on 29/11/2019 against  ML-MMOH-CRF-1365
		var closevalue = mr_hdr_line1+"||"+mr_hdr_line2+"||"+mr_hdr_line3+"||"+mr_hdr_line4+"||"+mr_hdr_line5+"||"+mr_hdr_line6+"||"+mr_sign_line1+"||"+mr_sign_line2+"||"+mr_sign_line3+"||"+mr_sign_line4+"||"+mr_sign_line5+"||"+mr_sign_line6+"||"+mr_sign_line7+"||"+mr_sign_line8+"||"+mr_hdr_line7+"||"+mr_sign_line9;
	
	window.returnValue = closevalue;
	
	window.close();	
}

function MedRepConfigSpclCharChck(event)
{
	var strCheck = " 0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ`~!@$^*()-_={}[]:;<>?,'./";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key 
}

function imposeMaxLength(obj)
{
	/*Added By Dharma on 29/11/2019 against  ML-MMOH-CRF-1365 Start*/
	var fieldName	= obj.name;
	var fieldNameDisp	= " 2 "+getLabel("Common.of.label","common")+" "+getLabel("Common.Header.label","common");
	if(fieldName=="mr_sign_line9"){
		fieldNameDisp = " 9 "+getLabel("Common.of.label","common")+" "+getLabel("Common.Signature.label","common");
	}
	/*Added By Dharma on 29/11/2019 against  ML-MMOH-CRF-1365 End*/
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
	if (obj.getAttribute && obj.value.length>mlength)
	{
		var error = getMessage("REMARKS_CANNOT_EXCEED","common");
		var remarks = getLabel("Common.Line.label","common")+fieldNameDisp;
		error = error.replace("$",remarks);
		error = error.replace("#",mlength)//Modified By Dharma on 29/11/2019 against  ML-MMOH-CRF-1365
		alert(error);
		obj.value=obj.value.substring(0,mlength);
	}
}

/*End ML-MMOH-CRF-0720*/
/* Added by Ajay Hatwate for ML-MMOH-CRF-1741 */
function updateCrossCheckFields(obj){
	if(obj.checked){
		document.MRParamDiagProc_form.crossCheckDfltMand.disabled=false;
	}else{
		document.MRParamDiagProc_form.crossCheckDfltMand.value="N";
		document.MRParamDiagProc_form.crossCheckDfltMand.checked=false;
		document.MRParamDiagProc_form.crossCheckDfltMand.disabled=true;
	}
}
/* end of ML-MMOH-CRF-1741 */

/*Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742*/
function changeValuePrimary(obj){

	var primary_diag_class = obj.value;

	if(primary_diag_class != ""){
		document.MRParamDiagProc_form.pri_mand_postmortem_ip_yn.value = "N";
		document.MRParamDiagProc_form.pri_mand_postmortem_ip_yn.checked = false;
		document.MRParamDiagProc_form.pri_mand_postmortem_ip_yn.disabled = false;
		document.MRParamDiagProc_form.pri_mand_postmortem_dc_yn.value = "N";
		document.MRParamDiagProc_form.pri_mand_postmortem_dc_yn.checked = false;
		document.MRParamDiagProc_form.pri_mand_postmortem_dc_yn.disabled = false;
		document.MRParamDiagProc_form.pri_mand_postmortem_op_yn.value = "N";
		document.MRParamDiagProc_form.pri_mand_postmortem_op_yn.checked = false;
		document.MRParamDiagProc_form.pri_mand_postmortem_op_yn.disabled = false;
		document.MRParamDiagProc_form.pri_mand_postmortem_ae_yn.value = "N";
		document.MRParamDiagProc_form.pri_mand_postmortem_ae_yn.checked = false;
		document.MRParamDiagProc_form.pri_mand_postmortem_ae_yn.disabled = false;
		document.MRParamDiagProc_form.pri_mand_non_postmortem_ip_yn.value = "N";
		document.MRParamDiagProc_form.pri_mand_non_postmortem_ip_yn.checked = false;
		document.MRParamDiagProc_form.pri_mand_non_postmortem_ip_yn.disabled = false;
		document.MRParamDiagProc_form.pri_mand_non_postmortem_dc_yn.value = "N";
		document.MRParamDiagProc_form.pri_mand_non_postmortem_dc_yn.checked = false;
		document.MRParamDiagProc_form.pri_mand_non_postmortem_dc_yn.disabled = false;
		document.MRParamDiagProc_form.pri_mand_non_postmortem_op_yn.value = "N";
		document.MRParamDiagProc_form.pri_mand_non_postmortem_op_yn.checked = false;
		document.MRParamDiagProc_form.pri_mand_non_postmortem_op_yn.disabled = false;
		document.MRParamDiagProc_form.pri_mand_non_postmortem_ae_yn.value = "N";
		document.MRParamDiagProc_form.pri_mand_non_postmortem_ae_yn.checked = false;
		document.MRParamDiagProc_form.pri_mand_non_postmortem_ae_yn.disabled = false;
	}else{
		document.MRParamDiagProc_form.pri_mand_postmortem_ip_yn.value = "N";
		document.MRParamDiagProc_form.pri_mand_postmortem_ip_yn.checked = false;
		document.MRParamDiagProc_form.pri_mand_postmortem_ip_yn.disabled = true;
		document.MRParamDiagProc_form.pri_mand_postmortem_dc_yn.value = "N";
		document.MRParamDiagProc_form.pri_mand_postmortem_dc_yn.checked = false;
		document.MRParamDiagProc_form.pri_mand_postmortem_dc_yn.disabled = true;
		document.MRParamDiagProc_form.pri_mand_postmortem_op_yn.value = "N";
		document.MRParamDiagProc_form.pri_mand_postmortem_op_yn.checked = false;
		document.MRParamDiagProc_form.pri_mand_postmortem_op_yn.disabled = true;
		document.MRParamDiagProc_form.pri_mand_postmortem_ae_yn.value = "N";
		document.MRParamDiagProc_form.pri_mand_postmortem_ae_yn.checked = false;
		document.MRParamDiagProc_form.pri_mand_postmortem_ae_yn.disabled = true;
		document.MRParamDiagProc_form.pri_mand_non_postmortem_ip_yn.value = "N";
		document.MRParamDiagProc_form.pri_mand_non_postmortem_ip_yn.checked = false;
		document.MRParamDiagProc_form.pri_mand_non_postmortem_ip_yn.disabled = true;
		document.MRParamDiagProc_form.pri_mand_non_postmortem_dc_yn.value = "N";
		document.MRParamDiagProc_form.pri_mand_non_postmortem_dc_yn.checked = false;
		document.MRParamDiagProc_form.pri_mand_non_postmortem_dc_yn.disabled = true;
		document.MRParamDiagProc_form.pri_mand_non_postmortem_op_yn.value = "N";
		document.MRParamDiagProc_form.pri_mand_non_postmortem_op_yn.checked = false;
		document.MRParamDiagProc_form.pri_mand_non_postmortem_op_yn.disabled = true;
		document.MRParamDiagProc_form.pri_mand_non_postmortem_ae_yn.value = "N";
		document.MRParamDiagProc_form.pri_mand_non_postmortem_ae_yn.checked = false;
		document.MRParamDiagProc_form.pri_mand_non_postmortem_ae_yn.disabled = true;
	}
}

function changeValueSecondary(obj){

	var secondary_diag_class = obj.value;

	if(secondary_diag_class != ""){
		document.MRParamDiagProc_form.sec_mand_postmortem_ip_yn.value = "N";
		document.MRParamDiagProc_form.sec_mand_postmortem_ip_yn.checked = false;
		document.MRParamDiagProc_form.sec_mand_postmortem_ip_yn.disabled = false;
		document.MRParamDiagProc_form.sec_mand_postmortem_dc_yn.value = "N";
		document.MRParamDiagProc_form.sec_mand_postmortem_dc_yn.checked = false;
		document.MRParamDiagProc_form.sec_mand_postmortem_dc_yn.disabled = false;
		document.MRParamDiagProc_form.sec_mand_postmortem_op_yn.value = "N";
		document.MRParamDiagProc_form.sec_mand_postmortem_op_yn.checked = false;
		document.MRParamDiagProc_form.sec_mand_postmortem_op_yn.disabled = false;
		document.MRParamDiagProc_form.sec_mand_postmortem_ae_yn.value = "N";
		document.MRParamDiagProc_form.sec_mand_postmortem_ae_yn.checked = false;
		document.MRParamDiagProc_form.sec_mand_postmortem_ae_yn.disabled = false;
		document.MRParamDiagProc_form.sec_mand_non_postmortem_ip_yn.value = "N";
		document.MRParamDiagProc_form.sec_mand_non_postmortem_ip_yn.checked = false;
		document.MRParamDiagProc_form.sec_mand_non_postmortem_ip_yn.disabled = false;
		document.MRParamDiagProc_form.sec_mand_non_postmortem_dc_yn.value = "N";
		document.MRParamDiagProc_form.sec_mand_non_postmortem_dc_yn.checked = false;
		document.MRParamDiagProc_form.sec_mand_non_postmortem_dc_yn.disabled = false;
		document.MRParamDiagProc_form.sec_mand_non_postmortem_op_yn.value = "N";
		document.MRParamDiagProc_form.sec_mand_non_postmortem_op_yn.checked = false;
		document.MRParamDiagProc_form.sec_mand_non_postmortem_op_yn.disabled = false;
		document.MRParamDiagProc_form.sec_mand_non_postmortem_ae_yn.value = "N";
		document.MRParamDiagProc_form.sec_mand_non_postmortem_ae_yn.checked = false;
		document.MRParamDiagProc_form.sec_mand_non_postmortem_ae_yn.disabled = false;
	}else{
		document.MRParamDiagProc_form.sec_mand_postmortem_ip_yn.value = "N";
		document.MRParamDiagProc_form.sec_mand_postmortem_ip_yn.checked = false;
		document.MRParamDiagProc_form.sec_mand_postmortem_ip_yn.disabled = true;
		document.MRParamDiagProc_form.sec_mand_postmortem_dc_yn.value = "N";
		document.MRParamDiagProc_form.sec_mand_postmortem_dc_yn.checked = false;
		document.MRParamDiagProc_form.sec_mand_postmortem_dc_yn.disabled = true;
		document.MRParamDiagProc_form.sec_mand_postmortem_op_yn.value = "N";
		document.MRParamDiagProc_form.sec_mand_postmortem_op_yn.checked = false;
		document.MRParamDiagProc_form.sec_mand_postmortem_op_yn.disabled = true;
		document.MRParamDiagProc_form.sec_mand_postmortem_ae_yn.value = "N";
		document.MRParamDiagProc_form.sec_mand_postmortem_ae_yn.checked = false;
		document.MRParamDiagProc_form.sec_mand_postmortem_ae_yn.disabled = true;
		document.MRParamDiagProc_form.sec_mand_non_postmortem_ip_yn.value = "N";
		document.MRParamDiagProc_form.sec_mand_non_postmortem_ip_yn.checked = false;
		document.MRParamDiagProc_form.sec_mand_non_postmortem_ip_yn.disabled = true;
		document.MRParamDiagProc_form.sec_mand_non_postmortem_dc_yn.value = "N";
		document.MRParamDiagProc_form.sec_mand_non_postmortem_dc_yn.checked = false;
		document.MRParamDiagProc_form.sec_mand_non_postmortem_dc_yn.disabled = true;
		document.MRParamDiagProc_form.sec_mand_non_postmortem_op_yn.value = "N";
		document.MRParamDiagProc_form.sec_mand_non_postmortem_op_yn.checked = false;
		document.MRParamDiagProc_form.sec_mand_non_postmortem_op_yn.disabled = true;
		document.MRParamDiagProc_form.sec_mand_non_postmortem_ae_yn.value = "N";
		document.MRParamDiagProc_form.sec_mand_non_postmortem_ae_yn.checked = false;
		document.MRParamDiagProc_form.sec_mand_non_postmortem_ae_yn.disabled = true;
	}
}
/*End ML-MMOH-CRF-1742*/

