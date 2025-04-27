function create() {
	f_query_add_mod.location.href = "../../eMP/jsp/addPatientNumbering.jsp" ;
	
	
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
	f_query_add_mod.location.href ="../../eMP/jsp/queryPagePatientNumber.jsp?function=religion" ;
}

function apply() 
{
	/*if(f_query_add_mod.document.patientnumbering_form.gen_pat_id_yn.checked)
				f_query_add_mod.document.patientnumbering_form.gen_pat_id_yn.value='Y';
			else
				f_query_add_mod.document.patientnumbering_form.gen_pat_id_yn.value='N';*/
	
	
	 if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	if(f_query_add_mod.document.patientnumbering_form.email_appl_yn.checked)
				f_query_add_mod.document.patientnumbering_form.email_appl_yn.value='Y';
			else
				f_query_add_mod.document.patientnumbering_form.email_appl_yn.value='N';
	
	if (f_query_add_mod.document.patientnumbering_form.function_name.value == 'insert')
	{

//		f_query_add_mod.document.patientnumbering_form.year_pat_ser.value='Y';	
		

		if(f_query_add_mod.document.patientnumbering_form.gen_pid_using_alt_id1_rule_yn.checked)
	{
		f_query_add_mod.document.patientnumbering_form.gen_pid_using_alt_id1_rule_yn.value='Y';	
		//alert("patientNumbering no.41 "+f_query_add_mod.document.patientnumbering_form.pid_use_alt_id1_or_sys_gen.item[0]?.checked)
		if(f_query_add_mod.document.patientnumbering_form.pid_use_alt_id1_or_sys_gen.item[0]?.checked == true)
		f_query_add_mod.document.patientnumbering_form.pid_use_alt_id1_or_sys_gen.value='A';
		else if(f_query_add_mod.document.patientnumbering_form.pid_use_alt_id1_or_sys_gen.item[1]?.checked == true)
		f_query_add_mod.document.patientnumbering_form.pid_use_alt_id1_or_sys_gen.value='S';
	}
	else
	{
		f_query_add_mod.document.patientnumbering_form.gen_pid_using_alt_id1_rule_yn.value='N';	
		f_query_add_mod.document.patientnumbering_form.pid_use_alt_id1_or_sys_gen.value='';	
		f_query_add_mod.document.patientnumbering_form.separator_value.value='';
		f_query_add_mod.document.patientnumbering_form.separator_position.value='';

	}


	
	
		

	/*alert("genPidUsingAid1RuleYn1"+f_query_add_mod.document.patientnumbering_form.genPidUsingAid1RuleYn1.value);
	alert("gen_pid_using_alt_id1_rule_yn"+f_query_add_mod.document.patientnumbering_form.gen_pid_using_alt_id1_rule_yn.value);
	alert("patCtrlVal"+f_query_add_mod.document.patientnumbering_form.patCtrlVal.value);
	alert("pid_use_alt_id1_or_sys_gen"+f_query_add_mod.document.patientnumbering_form.pid_use_alt_id1_or_sys_gen.value);
	alert("separator_value"+f_query_add_mod.document.patientnumbering_form.separator_value.value);
	alert("separator_position"+f_query_add_mod.document.patientnumbering_form.separator_position.value);*/


		if(f_query_add_mod.document.patientnumbering_form.gen_pid_using_alt_id1_rule_yn.value=='N')
	{
		var fields = new Array (f_query_add_mod.document.patientnumbering_form.pat_ser_grp_code,f_query_add_mod.document.patientnumbering_form.long_desc,f_query_add_mod.document.patientnumbering_form.short_desc,f_query_add_mod.document.patientnumbering_form.id_type);
	var names = new Array ( f_query_add_mod.getLabel('Common.code.label','common'), f_query_add_mod.getLabel('Common.longdescription.label','common'), f_query_add_mod.getLabel('Common.shortdescription.label','common'), f_query_add_mod.getLabel('eMP.SeriesType.label','MP'));

	//For Restricting Special Characters in Patient Series Code
	var specialCharfields = new Array (f_query_add_mod.document.patientnumbering_form.pat_ser_grp_code);
	var specialChars = new Array ( f_query_add_mod.getLabel('Common.code.label','common'));

	if(f_query_add_mod.SpecialCharCheck(specialCharfields,specialChars,messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")) 
	{
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {

			if(f_query_add_mod.document.patientnumbering_form.gen_pat_id_yn.checked)
				f_query_add_mod.document.patientnumbering_form.gen_pat_id_yn.value='Y';
			else
				f_query_add_mod.document.patientnumbering_form.gen_pat_id_yn.value='N';

			if(f_query_add_mod.document.patientnumbering_form.email_appl_yn.checked)
				f_query_add_mod.document.patientnumbering_form.email_appl_yn.value='Y';
			else
				f_query_add_mod.document.patientnumbering_form.email_appl_yn.value='N';
	
			
			f_query_add_mod.document.getElementById("pat_ser_chk_dig_scheme").disabled=false;
			f_query_add_mod.document.getElementById("gen_pat_id_yn").disabled=false;
			f_query_add_mod.document.getElementById("id_type").disabled=false;
			if(f_query_add_mod.document.getElementById("prefix_reqd_yn").checked)
	               f_query_add_mod.document.getElementById("prefix_reqd_yn").value="Y";
			else
				   f_query_add_mod.document.getElementById("prefix_reqd_yn").value="N";
			f_query_add_mod.document.getElementById("pat_no_ctrl").disabled=false;
			f_query_add_mod.document.getElementById("pat_no_ctrl").disabled=false;
			f_query_add_mod.document.getElementById("pat_no_ctrl").disabled=false;
         	f_query_add_mod.document.getElementById("family_no_link_yn").disabled=false;		
			f_query_add_mod.document.getElementById("name_in_oth_lang_yn").disabled=false;
			f_query_add_mod.document.getElementById("email_appl_yn").disabled=false;
			if (f_query_add_mod.document.patientnumbering_form.dflt_pat_ser_cnt.value == 1)
			{
			
			if(f_query_add_mod.document.patientnumbering_form.year_pat_ser.checked)
	               f_query_add_mod.document.patientnumbering_form.year_pat_ser.value="Y";
			else 
				   f_query_add_mod.document.patientnumbering_form.year_pat_ser.value="N";
			}
			
			f_query_add_mod.document.patientnumbering_form.submit();
			
			if(f_query_add_mod.document.patientnumbering_form.associ_num_series) {
				if(f_query_add_mod.document.patientnumbering_form.associ_num_series.value!="")
				{	
					
					if(f_query_add_mod.document.getElementById("gen_pat_id_yn"))
						f_query_add_mod.document.getElementById("gen_pat_id_yn").disabled=true;
					if(f_query_add_mod.document.getElementById("prefix_reqd_yn"))
						f_query_add_mod.document.getElementById("prefix_reqd_yn").disabled=true;
					if(f_query_add_mod.document.getElementById("pat_no_ctrl"))
						f_query_add_mod.document.getElementById("pat_no_ctrl").disabled=true;
					if(f_query_add_mod.document.getElementById("pat_no_ctrl"))
						f_query_add_mod.document.getElementById("pat_no_ctrl").disabled=true;
					if(f_query_add_mod.document.getElementById("pat_no_ctrl"))
						f_query_add_mod.document.getElementById("pat_no_ctrl").disabled=true;
					if(f_query_add_mod.document.getElementById("pat_ser_chk_dig_scheme"))
						f_query_add_mod.document.getElementById("pat_ser_chk_dig_scheme").disabled=true;
					if(f_query_add_mod.document.getElementById("family_no_link_yn").value)
						f_query_add_mod.document.getElementById("family_no_link_yn").disabled =true;
					if(f_query_add_mod.document.getElementById("name_in_oth_lang_yn"))
						f_query_add_mod.document.getElementById("name_in_oth_lang_yn").disabled=true;
					if(f_query_add_mod.document.getElementById("email_appl_yn"))
						f_query_add_mod.document.getElementById("email_appl_yn").disabled=true;
				}
			}
		}
	}	
	}
	
	
	
	else if(f_query_add_mod.document.patientnumbering_form.gen_pid_using_alt_id1_rule_yn.value=='Y')
	{
		
	var fields = new Array (f_query_add_mod.document.patientnumbering_form.pat_ser_grp_code,f_query_add_mod.document.patientnumbering_form.long_desc,f_query_add_mod.document.patientnumbering_form.short_desc,f_query_add_mod.document.patientnumbering_form.id_type,f_query_add_mod.document.patientnumbering_form.separator_value,f_query_add_mod.document.patientnumbering_form.separator_position);
	var names = new Array ( f_query_add_mod.getLabel('Common.code.label','common'), f_query_add_mod.getLabel('Common.longdescription.label','common'), f_query_add_mod.getLabel('Common.shortdescription.label','common'), f_query_add_mod.getLabel('eMP.SeriesType.label','MP'),
	f_query_add_mod.getLabel('eMP.SeparatorValue.label','MP'),
	f_query_add_mod.getLabel('eMP.SeparatorPosition.label','MP'));

	//For Restricting Special Characters in Patient Series Code
	var specialCharfields = new Array (f_query_add_mod.document.patientnumbering_form.pat_ser_grp_code);
	var specialChars = new Array ( f_query_add_mod.getLabel('Common.code.label','common'));

	if(f_query_add_mod.SpecialCharCheck(specialCharfields,specialChars,messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")) 
	{
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {

			if(f_query_add_mod.document.patientnumbering_form.gen_pat_id_yn.checked)
				f_query_add_mod.document.patientnumbering_form.gen_pat_id_yn.value='Y';
			else
				f_query_add_mod.document.patientnumbering_form.gen_pat_id_yn.value='N';

			if(f_query_add_mod.document.patientnumbering_form.email_appl_yn.checked)
				f_query_add_mod.document.patientnumbering_form.email_appl_yn.value='Y';
			else
				f_query_add_mod.document.patientnumbering_form.email_appl_yn.value='N';
			
			if(f_query_add_mod.document.patientnumbering_form.prefix_reqd_yn.checked)
				f_query_add_mod.document.patientnumbering_form.prefix_reqd_yn.value='Y';
			else
				f_query_add_mod.document.patientnumbering_form.prefix_reqd_yn.value='N';
						
			f_query_add_mod.document.getElementById("pat_ser_chk_dig_scheme").disabled=false;
			f_query_add_mod.document.getElementById("gen_pat_id_yn").disabled=false;
			f_query_add_mod.document.getElementById("id_type").disabled=false;
			f_query_add_mod.document.getElementById("separator_value").disabled=false;
			f_query_add_mod.document.getElementById("separator_position").disabled=false;

			if(f_query_add_mod.document.getElementById("prefix_reqd_yn"))
				f_query_add_mod.document.getElementById("prefix_reqd_yn").disabled=false;
			if(f_query_add_mod.document.getElementById("pat_no_ctrl"))
				f_query_add_mod.document.getElementById("pat_no_ctrl").disabled=false;
			if(f_query_add_mod.document.getElementById("pat_no_ctrl"))
				f_query_add_mod.document.getElementById("pat_no_ctrl").disabled=false;
			if(f_query_add_mod.document.getElementById("pat_no_ctrl"))
				f_query_add_mod.document.getElementById("pat_no_ctrl").disabled=false;
			if(f_query_add_mod.document.patientnumbering_form.family_no_link_yn.value)
			f_query_add_mod.document.patientnumbering_form.family_no_link_yn.disabled =false;
			if(f_query_add_mod.document.patientnumbering_form.name_in_oth_lang_yn)
			f_query_add_mod.document.patientnumbering_form.name_in_oth_lang_yn.disabled=false;
			if(f_query_add_mod.document.patientnumbering_form.email_appl_yn)
			f_query_add_mod.document.patientnumbering_form.email_appl_yn.disabled=false;
			if (f_query_add_mod.document.patientnumbering_form.dflt_pat_ser_cnt.value == 1)
			{
			if(f_query_add_mod.document.patientnumbering_form.year_pat_ser.checked)
	               f_query_add_mod.document.patientnumbering_form.year_pat_ser.value="Y";
			else
				   f_query_add_mod.document.patientnumbering_form.year_pat_ser.value="N";
			}
			f_query_add_mod.document.patientnumbering_form.submit();	
			
			if(f_query_add_mod.document.patientnumbering_form.associ_num_series) {
				if(f_query_add_mod.document.patientnumbering_form.associ_num_series.value!="")
				{	
					if(f_query_add_mod.document.getElementById("gen_pat_id_yn"))
						f_query_add_mod.document.getElementById("gen_pat_id_yn").disabled=true;
					if(f_query_add_mod.document.getElementById("prefix_reqd_yn"))
						f_query_add_mod.document.getElementById("prefix_reqd_yn").disabled=true;
					if(f_query_add_mod.document.getElementById("pat_no_ctrl"))
						f_query_add_mod.document.getElementById("pat_no_ctrl").disabled=true;
					if(f_query_add_mod.document.getElementById("pat_no_ctrl"))
						f_query_add_mod.document.getElementById("pat_no_ctrl").disabled=true;
					if(f_query_add_mod.document.getElementById("pat_no_ctrl"))
						f_query_add_mod.document.getElementById("pat_no_ctrl").disabled=true;
					if(f_query_add_mod.document.getElementById("pat_ser_chk_dig_scheme"))
						f_query_add_mod.document.getElementById("pat_ser_chk_dig_scheme").disabled=true;
					if(f_query_add_mod.document.getElementById("family_no_link_yn"))
						f_query_add_mod.document.getElementById("family_no_link_yn").disabled =true;
					if(f_query_add_mod.document.getElementById("name_in_oth_lang_yn"))
						f_query_add_mod.document.getElementById("name_in_oth_lang_yn").disabled=true;
					if(f_query_add_mod.document.getElementById("email_appl_yn"))
						f_query_add_mod.document.getElementById("email_appl_yn").disabled=true;
				}
			}
		} 
	}	
	}
}	
	
	if (f_query_add_mod.document.patientnumbering_form.function_name.value == 'modify')
	{
		

	var fields = new Array (f_query_add_mod.document.patientnumbering_form.pat_ser_grp_code,f_query_add_mod.document.patientnumbering_form.long_desc,f_query_add_mod.document.patientnumbering_form.short_desc,f_query_add_mod.document.patientnumbering_form.id_type);
	var names = new Array ( f_query_add_mod.getLabel('Common.code.label','common'), f_query_add_mod.getLabel('Common.longdescription.label','common'), f_query_add_mod.getLabel('Common.shortdescription.label','common'), f_query_add_mod.getLabel('eMP.SeriesType.label','MP'));

	//For Restricting Special Characters in Patient Series Code
	var specialCharfields = new Array (f_query_add_mod.document.patientnumbering_form.pat_ser_grp_code);
	var specialChars = new Array ( f_query_add_mod.getLabel('Common.code.label','common'));

	if(f_query_add_mod.SpecialCharCheck(specialCharfields,specialChars,messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")) 
	{
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
			
			f_query_add_mod.document.getElementById("pat_ser_chk_dig_scheme").disabled=false;
			f_query_add_mod.document.getElementById("gen_pat_id_yn").disabled=false;
			f_query_add_mod.document.getElementById("id_type").disabled=false;

			if(f_query_add_mod.document.getElementById("prefix_reqd_yn"))
				f_query_add_mod.document.getElementById("prefix_reqd_yn").disabled=false;
			if(f_query_add_mod.document.getElementById("pat_no_ctrl"))
				f_query_add_mod.document.getElementById("pat_no_ctrl").disabled=false;
			if(f_query_add_mod.document.getElementById("pat_no_ctrl"))
			f_query_add_mod.document.getElementById("pat_no_ctrl").disabled=false;
			 if(f_query_add_mod.document.getElementById("pat_no_ctrl"))
			 f_query_add_mod.document.getElementById("pat_no_ctrl").disabled=false;
	    		if(f_query_add_mod.document.getElementById("family_no_link_yn"))
				f_query_add_mod.document.getElementById("family_no_link_yn").disabled=false;		
			   if(f_query_add_mod.document.getElementById("name_in_oth_lang_yn"))
			f_query_add_mod.document.getElementById("name_in_oth_lang_yn").disabled=false;
			
			 if(f_query_add_mod.document.getElementById("email_appl_yn"))
				f_query_add_mod.document.getElementById("email_appl_yn").disabled=false;
			 if (f_query_add_mod.document.patientnumbering_form.dflt_pat_ser_cnt.value == 1){

			if(f_query_add_mod.document.patientnumbering_form.year_pat_ser.checked)
	               f_query_add_mod.document.patientnumbering_form.year_pat_ser.value="Y";

			else
				   f_query_add_mod.document.patientnumbering_form.year_pat_ser.value="N";
		}

			f_query_add_mod.document.patientnumbering_form.submit();
		    f_query_add_mod.location.reload();		
		}
	}	
	}
}



function onSuccess() {
	f_query_add_mod.location.reload();
}



function reset() 
{
	if(f_query_add_mod.document.forms[0].name == "patientnumbering_form") 
	{
		f_query_add_mod.document.patientnumbering_form.reset() ;
		if (f_query_add_mod.document.patientnumbering_form.function_name.value == 'modify')
			f_query_add_mod.change();
		else
		{
			if (f_query_add_mod.document.patientnumbering_form.patCtrlVal.value=='Z')
			{
				f_query_add_mod.document.patientnumbering_form.pat_no_ctrl.item[0].disabled = false;
				f_query_add_mod.document.patientnumbering_form.pat_no_ctrl.item[0].selected = true ;		
				f_query_add_mod.document.patientnumbering_form.pat_no_ctrl.item[1].disabled = true ;
				f_query_add_mod.document.patientnumbering_form.pat_no_ctrl.item[2].disabled = true ;
			}
			else if (f_query_add_mod.document.patientnumbering_form.patCtrlVal.value=='U')
			{
				f_query_add_mod.document.patientnumbering_form.pat_no_ctrl.item[1].selected = true ;
				f_query_add_mod.document.patientnumbering_form.pat_no_ctrl.item[1].disabled = false;
				f_query_add_mod.document.patientnumbering_form.pat_no_ctrl.item[0].disabled = true ;
				f_query_add_mod.document.patientnumbering_form.pat_no_ctrl.item[2].disabled = true ;
			}
			else if (f_query_add_mod.document.patientnumbering_form.patCtrlVal.value=='C')
			{
				f_query_add_mod.document.patientnumbering_form.pat_no_ctrl.item[0].selected = true ;
				f_query_add_mod.document.patientnumbering_form.pat_no_ctrl.item[0].disabled = false;
				f_query_add_mod.document.patientnumbering_form.pat_no_ctrl.item[1].disabled = false ;
				f_query_add_mod.document.patientnumbering_form.pat_no_ctrl.item[2].disabled = true ;
			}
		}
	}
	else
		f_query_add_mod.document.forms[0].reset();
		//f_query_add_mod.location.href ="../../eMP/jsp/queryPagePatientNumber.jsp?function=religion" ;
		//f_query_add_mod.document.query_form.reset() ;
}
function CodeLen(Obj)
{


		if(Obj.value.length<2 && Obj.value!="")
		{
			//alert("APP-MP0079 - Code should not be less than 2 Characters");
			alert(getMessage("CODE_2_CH","MP"));
			//Obj.select();
			Obj.value = '';
			Obj.focus();
		}

}
function func(val)
{
		if(val=="S")
			patientnumbering_form.site_or_facility.value="S";
		if(val=="F")
			patientnumbering_form.site_or_facility.value="F";


		//parent.fr_pat_num_com.location.href="../jsp/addPatientNumberMPcommon.jsp?numctrl="+val;

}


function change1(obj)
{
	if(patientnumbering_form.gen_pat_id_yn.checked == true)
	{
		patientnumbering_form.gen_pat_id_yn.value='Y';
		
		if(patientnumbering_form.genPidUsingAid1RuleYn1.value=="Y")
		{
			
			Enast();
			patientnumbering_form.gen_pid_using_alt_id1_rule_yn.disabled = false;
			
		}
		else
			patientnumbering_form.gen_pid_using_alt_id1_rule_yn.disabled = true;
	}
	else
	{
		patientnumbering_form.gen_pat_id_yn.value='N';
		patientnumbering_form.gen_pid_using_alt_id1_rule_yn.checked = false;
		patientnumbering_form.gen_pid_using_alt_id1_rule_yn.value='N';
		patientnumbering_form.gen_pid_using_alt_id1_rule_yn.disabled = true;
		SepAltid();
	}

}

function change()
{
	 if(patientnumbering_form.gen_pat_id_yn.checked == false)
		 {
			patientnumbering_form.gen_pat_id_yn.value='N';
			patientnumbering_form.pat_no_ctrl.item[2].disabled = false;
			patientnumbering_form.pat_no_ctrl.item[2].checked = true;
			patientnumbering_form.pat_no_ctrl.item[0].disabled = true;
			patientnumbering_form.pat_no_ctrl.item[1].disabled= true;
		 }

		else
		{
			patientnumbering_form.gen_pat_id_yn.value='Y';
			genPidUsingAid1RuleYn = patientnumbering_form.genPidUsingAid1RuleYn1.value;

			if(genPidUsingAid1RuleYn=="Y") {
			    patientnumbering_form.patCtrlVal.value = "N";
			} else {
				patientnumbering_form.patCtrlVal.value=patientnumbering_form.patNoCtrl.value;
			}

			if(genPidUsingAid1RuleYn=="Y") { 
				patientnumbering_form.pat_no_ctrl.item[1].disabled = true;
				patientnumbering_form.pat_no_ctrl.item[2].checked = true;
				patientnumbering_form.pat_no_ctrl.item[0].disabled = true;
				patientnumbering_form.pat_no_ctrl.item[2].disabled= false; 
			}  else if(patientnumbering_form.patNoCtrl.value =="U")	{
				patientnumbering_form.pat_no_ctrl.item[1].disabled = false;
				patientnumbering_form.pat_no_ctrl.item[1].checked = true;
				patientnumbering_form.pat_no_ctrl.item[0].disabled = true;
				patientnumbering_form.pat_no_ctrl.item[2].disabled= true;
			} else if(patientnumbering_form.patNoCtrl.value =="Z") {
				patientnumbering_form.pat_no_ctrl.item[2].disabled = true;
				patientnumbering_form.pat_no_ctrl.item[0].checked = true;
				patientnumbering_form.pat_no_ctrl.item[0].disabled = false;
				patientnumbering_form.pat_no_ctrl.item[1].disabled= true;
			} else	if(patientnumbering_form.patNoCtrl.value =="C")	{
				patientnumbering_form.pat_no_ctrl.item[1].disabled = false;
				patientnumbering_form.pat_no_ctrl.item[0].checked = true;
				patientnumbering_form.pat_no_ctrl.item[0].disabled = false;
				patientnumbering_form.pat_no_ctrl.item[2].disabled= true;
			}
		}
}


function change2(){
		//alert(patientnumbering_form.patCtrlVal.value);

	if(patientnumbering_form.gen_pid_using_alt_id1_rule_yn.checked == true)
	{
		 if(patientnumbering_form.gen_pat_id_yn.checked == true && patientnumbering_form.gen_pid_using_alt_id1_rule_yn.checked == true)
		 {
			patientnumbering_form.pat_no_ctrl.item[2].disabled = false;
			patientnumbering_form.pat_no_ctrl.item[2].checked = true;
			patientnumbering_form.pat_no_ctrl.item[0].disabled = true;
			patientnumbering_form.pat_no_ctrl.item[1].disabled= true;

			//patientnumbering_form.id_type.item[1].selected = true ;			
			//patientnumbering_form.id_type.disabled = true;
		 }
			var pat_dig_ser	= patientnumbering_form.pat_ser_chk_dig_scheme;
			patientnumbering_form.pat_ser_chk_dig_scheme.value='';
			patientnumbering_form.pat_ser_chk_dig_scheme.disabled=true;
			//patientnumbering_form.prefix_reqd_yn.checked= false;
			//patientnumbering_form.prefix_reqd_yn.value='N';
			//patientnumbering_form.prefix_reqd_yn.disabled=true;
	}else
	{
	
			//patientnumbering_form.prefix_reqd_yn.disabled=false;
			SepAltid();
			patientnumbering_form.pat_ser_chk_dig_scheme.disabled=false;
			patientnumbering_form.patCtrlVal.value=patientnumbering_form.patNoCtrl.value;

			if(patientnumbering_form.patNoCtrl.value =="U")
			{
				patientnumbering_form.pat_no_ctrl.item[1].disabled = false;
				patientnumbering_form.pat_no_ctrl.item[1].checked = true;
				patientnumbering_form.pat_no_ctrl.item[0].disabled = true;
				patientnumbering_form.pat_no_ctrl.item[2].disabled= true;

			}
			if(patientnumbering_form.patNoCtrl.value =="Z")
			{
				patientnumbering_form.pat_no_ctrl.item[2].disabled = true;
				patientnumbering_form.pat_no_ctrl.item[0].checked = true;
				patientnumbering_form.pat_no_ctrl.item[0].disabled = false;
				patientnumbering_form.pat_no_ctrl.item[1].disabled= true;

			}
			if(patientnumbering_form.patNoCtrl.value =="C")
			{
				patientnumbering_form.pat_no_ctrl.item[1].disabled = false;
				patientnumbering_form.pat_no_ctrl.item[0].checked = true;
				patientnumbering_form.pat_no_ctrl.item[0].disabled = false;
				patientnumbering_form.pat_no_ctrl.item[2].disabled= true;

			}
	}

}

function disablePrefix(obj)
{
		
	if (obj.value=='VDG')
	{
		patientnumbering_form.prefix_reqd_yn.checked = false;
		patientnumbering_form.prefix_reqd_yn.value = 'N';
		patientnumbering_form.prefix_reqd_yn.disabled = true;
		patientnumbering_form.gen_pat_id_yn.checked = true;
		patientnumbering_form.gen_pat_id_yn.value = 'Y';
		patientnumbering_form.gen_pat_id_yn.disabled = true;
		change();
	}
	else
	{
		patientnumbering_form.prefix_reqd_yn.disabled = false;
		patientnumbering_form.gen_pat_id_yn.disabled = false;
		if(obj.value=="")
		{
			patientnumbering_form.prefix_reqd_yn.checked =true;
		}
	} 
}


function disablePrefix1(obj)
{
	
	if(obj.value==""){
   if(patientnumbering_form.function_name.value=="modify" )
		{
   if(patientnumbering_form.document.getElementById("prefix_reqd_yn1").value=='Y')
	patientnumbering_form.document.getElementById("prefix_reqd_yn").checked=true;
	else
     patientnumbering_form.document.getElementById("prefix_reqd_yn").checked=false;
	if(patientnumbering_form.document.getElementById("gen_pat_id_yn1").value=='Y')
	 patientnumbering_form.document.getElementById("gen_pat_id_yn").checked=true;
	else
     patientnumbering_form.document.getElementById("gen_pat_id_yn").checked=false;
	if(patientnumbering_form.document.getElementById("name_in_oth_lang_yn1").value=='Y')
	 patientnumbering_form.document.getElementById("name_in_oth_lang_yn").checked=true;
	else
    patientnumbering_form.document.getElementById("name_in_oth_lang_yn").checked=false;
	if(patientnumbering_form.document.getElementById("family_no_link_yn1").value=='Y')
	 patientnumbering_form.document.getElementById("family_no_link_yn").checked=true;
	else
    patientnumbering_form.document.getElementById("family_no_link_yn").checked=false;
	
	if(patientnumbering_form.document.getElementById("email_appl_yn1").value=='Y')
	  patientnumbering_form.document.getElementById("email_appl_yn").checked=true;
	else
   	patientnumbering_form.document.getElementById("email_appl_yn").checked=false;	
	if(patientnumbering_form.document.getElementById("patCtrlVal1").value=='Z')
	 patientnumbering_form.document.getElementById("pat_no_ctrl").item[0].checked=true;
	else
    patientnumbering_form.document.getElementById("pat_no_ctrl").item[0].checked=false;
	if(patientnumbering_form.document.getElementById("patCtrlVal1").value=='U')
	  patientnumbering_form.document.getElementById("pat_no_ctrl").item[1].checked=true;
	else
    patientnumbering_form.document.getElementById("pat_no_ctrl").item[1].checked=false;
	if(patientnumbering_form.document.getElementById("patCtrlVal1").value=='C')
	  patientnumbering_form.document.getElementById("pat_no_ctrl").item[2].checked=true;
	else
    patientnumbering_form.document.getElementById("pat_no_ctrl").item[2].checked=false;	
			
		}
	if(patientnumbering_form.pat_ser_chk_dig_scheme)
	if(patientnumbering_form.function_name.value=="insert" )
	patientnumbering_form.pat_ser_chk_dig_scheme.disabled = false;
	if(patientnumbering_form.function_name.value=="insert" )
		{
	patientnumbering_form.prefix_reqd_yn.disabled = false;
	patientnumbering_form.gen_pat_id_yn.disabled = false;
    patientnumbering_form.pat_no_ctrl.item[0].disabled = false;
	patientnumbering_form.document.getElementById("family_no_link_yn").disabled=true;		
	}
	 if(patientnumbering_form.function_name.value=="modify" )
		{
		if(patientnumbering_form.document.getElementById("associated_pat_ser_grp_code1").value!="")
		{
		patientnumbering_form.document.getElementById("email_appl_yn").disabled=true;
		patientnumbering_form.document.getElementById("name_in_oth_lang_yn").disabled=true;
		 patientnumbering_form.document.getElementById("family_no_link_yn").disabled=true;		
		}
		if(patientnumbering_form.document.getElementById("associated_pat_ser_grp_code1").value=="")
       {
		 patientnumbering_form.document.getElementById("email_appl_yn").disabled=false;
		 if(patientnumbering_form.document.getElementById("name_in_oth_lang_yn1").value=='Y')
		 patientnumbering_form.document.getElementById("name_in_oth_lang_yn").disabled=false;
		if(patientnumbering_form.document.getElementById("family_no_link_yn1").value=='Y')
		 patientnumbering_form.document.getElementById("family_no_link_yn").disabled=false;	
		} 
		}
		}else{
	 
      	
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root><SEARCH ";
		           

				xmlStr+=" process_id=\"36\" ";
				xmlStr+=" pat_ser_grp_code=\""+document.getElementById("associ_num_series").value+"\"";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				var url = "../../eMP/jsp/ServerValidationXML.jsp";
				xmlHttp.open("POST",url,false);
				xmlHttp.setRequestHeader("Content-type" ,"application/x-www-form-urlencoded");
				xmlHttp.send(xmlDoc);
				eval(xmlHttp.responseText);
           
					}
     		      }



function SepAltid()
{
	//var gen_pid_using_alt_id1_rule_yn = patientnumbering_form.gen_pid_using_alt_id1_rule_yn.value;
	if (patientnumbering_form.gen_pid_using_alt_id1_rule_yn.checked == true)
	{
	patientnumbering_form.gen_pid_using_alt_id1_rule_yn.value='Y';
		patientnumbering_form.separator_value.value="";
		patientnumbering_form.separator_value.disabled=false;
		patientnumbering_form.separator_position.item[0].selected=true;
		patientnumbering_form.separator_position.disabled=false;
		patientnumbering_form.s1.style.visibility='visible';
		patientnumbering_form.s2.style.visibility='visible';
		patientnumbering_form.pid_use_alt_id1_or_sys_gen.item[0].checked=true;
		patientnumbering_form.pid_use_alt_id1_or_sys_gen.item[0].disabled = false;
		patientnumbering_form.pid_use_alt_id1_or_sys_gen.item[1].disabled = false;
		
	}
	else if(patientnumbering_form.gen_pid_using_alt_id1_rule_yn.checked == false)
	{
		patientnumbering_form.gen_pid_using_alt_id1_rule_yn.value='N';
		patientnumbering_form.pid_use_alt_id1_or_sys_gen.value='';
		patientnumbering_form.separator_value.value="";
		patientnumbering_form.separator_value.disabled=true;
		//patientnumbering_form.separator_position.item[0].selected=true;
		patientnumbering_form.separator_position.disabled=true;	
		if(patientnumbering_form.genPidUsingAid1RuleYn1.value=="Y")
		{
		patientnumbering_form.s1.style.visibility='hidden';
		patientnumbering_form.s2.style.visibility='hidden';
		}
		
		if(patientnumbering_form.pid_use_alt_id1_or_sys_gen.type!='hidden')
		{
		patientnumbering_form.pid_use_alt_id1_or_sys_gen.item[0].checked=false;
		patientnumbering_form.pid_use_alt_id1_or_sys_gen.item[1].checked=false;
		patientnumbering_form.pid_use_alt_id1_or_sys_gen.item[0].disabled = true;
		patientnumbering_form.pid_use_alt_id1_or_sys_gen.item[1].disabled = true;
		}
		
	}
	
}


function CheckForSpecChars1(event){
    var strCheck = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode );
	return true ;
} 

function Enast()
{
	patientnumbering_form.s1.style.visibility='hidden';
	patientnumbering_form.s2.style.visibility='hidden';
	patientnumbering_form.gen_pid_using_alt_id1_rule_yn.value='N';	

}

function chkNumCtl(obj)
{
	if(obj.value == 'S')
	{
		patientnumbering_form.patCtrlVal.value=patientnumbering_form.patNoCtrl.value;

	if(patientnumbering_form.patNoCtrl.value =="U")
			{
				patientnumbering_form.pat_no_ctrl.item[1].disabled = false;
				patientnumbering_form.pat_no_ctrl.item[1].checked = true;
				patientnumbering_form.pat_no_ctrl.item[0].disabled = true;
				patientnumbering_form.pat_no_ctrl.item[2].disabled= true;

			}
			if(patientnumbering_form.patNoCtrl.value =="Z")
			{
				patientnumbering_form.pat_no_ctrl.item[2].disabled = true;
				patientnumbering_form.pat_no_ctrl.item[0].checked = true;
				patientnumbering_form.pat_no_ctrl.item[0].disabled = false;
				patientnumbering_form.pat_no_ctrl.item[1].disabled= true;

			}
			if(patientnumbering_form.patNoCtrl.value =="C")
			{
				patientnumbering_form.pat_no_ctrl.item[1].disabled = false;
				patientnumbering_form.pat_no_ctrl.item[0].checked = true;
				patientnumbering_form.pat_no_ctrl.item[0].disabled = false;
				patientnumbering_form.pat_no_ctrl.item[2].disabled= true;

			}
	}
	else
	{
		patientnumbering_form.pat_no_ctrl.item[2].disabled = false;
			patientnumbering_form.pat_no_ctrl.item[2].checked = true;
			patientnumbering_form.pat_no_ctrl.item[0].disabled = true;
			patientnumbering_form.pat_no_ctrl.item[1].disabled= true;
	}
	
}

function enaEmail()
{
	if(patientnumbering_form.email_appl_yn.checked)
		patientnumbering_form.email_appl_yn.value='Y';
	else
		patientnumbering_form.email_appl_yn.value='N';

}
function enableDefault()
{
	if(patientnumbering_form.default_yn.checked)
		patientnumbering_form.default_yn.value='Y';
	else
		patientnumbering_form.default_yn.value='N';

}

function CallBDYearPrefixSeries()
{
	if(patientnumbering_form.year_pat_ser.checked == true)	
	{

		patientnumbering_form.year_pat_ser.value = 'Y';
		patientnumbering_form.prefix_reqd_yn.checked = false;
		patientnumbering_form.prefix_reqd_yn.disabled = true;
		patientnumbering_form.pat_ser_chk_dig_scheme.disabled=true;
		patientnumbering_form.prefix_reqd_yn.value = 'N';

		}
	else  if (patientnumbering_form.year_pat_ser.checked == false)
		{
		patientnumbering_form.year_pat_ser.value = 'N';
		patientnumbering_form.prefix_reqd_yn.checked = true;
		patientnumbering_form.prefix_reqd_yn.disabled = false;
		patientnumbering_form.pat_ser_chk_dig_scheme.disabled=false;
		patientnumbering_form.prefix_reqd_yn.value = 'Y';

		}
	
}


function checkIsValidForProceed()
{

	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}
