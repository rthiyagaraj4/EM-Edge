var errors = "" ;
var errors_order = "" ;  /*added for IN:034308*/
var operation = "" ;
var result = true;
var operation = "";
var dcount=0;
var ccount=0;
var ncount=0;
var fcount=0;
var ecount=0;
var ocount=0;
var section = new Array(5);


for (i=0;i<5 ;i++ )
{
	section[i] = '';
}

function create()
{
    var mode = f_query_add_mod.document.mp_param_form.operation.value ;
    if ( mode == "modify" )
        alert( getMessage("PARAM_DEFINED","MP") ) ;
}
function onSuccess()
{
	 f_query_add_mod.location.href ="../../eMP/jsp/mp_param_form.jsp?operation=modify" ;
}
//added  changes   for HSA-CRF-0226 [IN:050599] 
function UptContactDtls(obj){
  if(obj.checked==true){
	obj.value="Y";
  }else{
	obj.value="N"
  }
} 
//end changes for HSA-CRF-0226 [IN:050599] 
function reset()
{

	// Commented by Marimuthu on 27/10/2009 for incident IN008760
	/*
	var len = f_query_add_mod.document.mp_param_form.dflt_pat_ser_grp_type.options.length ;
    var initial_value = f_query_add_mod.document.mp_param_form.dflt_pat_ser_grp_type.value ;

	f_query_add_mod.dcount=f_query_add_mod.document.mp_param_form.dcount.value;
	f_query_add_mod.ccount=f_query_add_mod.document.mp_param_form.ccount.value;
	f_query_add_mod.ncount=f_query_add_mod.document.mp_param_form.ncount.value;
	f_query_add_mod.ecount=f_query_add_mod.document.mp_param_form.ecount.value;
	f_query_add_mod.fcount=f_query_add_mod.document.mp_param_form.fcount.value;
	f_query_add_mod.ocount=f_query_add_mod.document.mp_param_form.ocount.value;

	f_query_add_mod.section[0] = f_query_add_mod.document.mp_param_form.section0.value;
	f_query_add_mod.section[1] = f_query_add_mod.document.mp_param_form.section1.value;
	f_query_add_mod.section[2] = f_query_add_mod.document.mp_param_form.section2.value;
	f_query_add_mod.section[3] = f_query_add_mod.document.mp_param_form.section3.value;
	f_query_add_mod.section[4] = f_query_add_mod.document.mp_param_form.section4.value;

    f_query_add_mod.document.mp_param_form.reset() ;
	
	f_query_add_mod.document.mp_param_form.dcount.value = f_query_add_mod.dcount;
	f_query_add_mod.document.mp_param_form.ccount.value = f_query_add_mod.ccount;
	f_query_add_mod.document.mp_param_form.ncount.value = f_query_add_mod.ncount;
	f_query_add_mod.document.mp_param_form.ecount.value = f_query_add_mod.ecount;
	f_query_add_mod.document.mp_param_form.fcount.value = f_query_add_mod.fcount;
	f_query_add_mod.document.mp_param_form.ocount.value = f_query_add_mod.ocount;

	f_query_add_mod.document.mp_param_form.section0.value = f_query_add_mod.section[0];
	f_query_add_mod.document.mp_param_form.section1.value = f_query_add_mod.section[1];
	f_query_add_mod.document.mp_param_form.section2.value = f_query_add_mod.section[2];
	f_query_add_mod.document.mp_param_form.section3.value = f_query_add_mod.section[3];
	f_query_add_mod.document.mp_param_form.section4.value = f_query_add_mod.section[4];
	
	//if (f_query_add_mod.document.mp_param_form.operation.value=="insert")
	//{
		 //f_query_add_mod.digitenablecheck();
	//}
	if (f_query_add_mod.document.mp_param_form.operation.value=="modify")
	{
		if (f_query_add_mod.document.mp_param_form.d_alt_id1_exp_warn_yn.checked)
			f_query_add_mod.document.mp_param_form.alt_id1_exp_grace_days.disabled=false;
		else
			f_query_add_mod.document.mp_param_form.alt_id1_exp_grace_days.disabled=true;

		if (f_query_add_mod.document.mp_param_form.alt_id1_adv_alert_reqd_yn.checked)
			f_query_add_mod.document.mp_param_form.alt_id1_adv_alert_days.disabled=false;
		else
			f_query_add_mod.document.mp_param_form.alt_id1_adv_alert_days.disabled=true;

		if (f_query_add_mod.document.mp_param_form.d_alt_id2_exp_warn_yn.checked)
			f_query_add_mod.document.mp_param_form.alt_id2_exp_grace_days.disabled=false;
		else
			f_query_add_mod.document.mp_param_form.alt_id2_exp_grace_days.disabled=true;

		if (f_query_add_mod.document.mp_param_form.alt_id2_adv_alert_reqd_yn.checked)
			f_query_add_mod.document.mp_param_form.alt_id2_adv_alert_days.disabled=false;
		else
			f_query_add_mod.document.mp_param_form.alt_id2_adv_alert_days.disabled=true;

		if (f_query_add_mod.document.mp_param_form.d_alt_id3_exp_warn_yn.checked)
			f_query_add_mod.document.mp_param_form.alt_id3_exp_grace_days.disabled=false;
		else
			f_query_add_mod.document.mp_param_form.alt_id3_exp_grace_days.disabled=true;

		if (f_query_add_mod.document.mp_param_form.alt_id3_adv_alert_reqd_yn.checked)
			f_query_add_mod.document.mp_param_form.alt_id3_adv_alert_days.disabled=false;
		else
			f_query_add_mod.document.mp_param_form.alt_id3_adv_alert_days.disabled=true;

		if (f_query_add_mod.document.mp_param_form.d_alt_id4_exp_warn_yn.checked)
			f_query_add_mod.document.mp_param_form.alt_id4_exp_grace_days.disabled=false;
		else
			f_query_add_mod.document.mp_param_form.alt_id4_exp_grace_days.disabled=true;

		if (f_query_add_mod.document.mp_param_form.alt_id4_adv_alert_reqd_yn.checked)
			f_query_add_mod.document.mp_param_form.alt_id4_adv_alert_days.disabled=false;
		else
			f_query_add_mod.document.mp_param_form.alt_id4_adv_alert_days.disabled=true;		
	}//end of if
	enableNatFields(f_query_add_mod.document.mp_param_form.accept_national_id_no_yn,'N');
	if (f_query_add_mod.document.mp_param_form.operation.value=="insert")
	{
		f_query_add_mod.checkAlternateId( 0 ) ;
		f_query_add_mod.checkLegalNames(0);
	}
    if (f_query_add_mod.document.mp_param_form.addl_field1_prompt.value == "")
    {
        f_query_add_mod.document.mp_param_form.addl_field1_length.value="";
        f_query_add_mod.document.mp_param_form.addl_field1_section.value="";
        f_query_add_mod.document.mp_param_form.addl_field1_length.disabled=true;
        f_query_add_mod.document.mp_param_form.addl_field1_section.disabled=true;
    }
    if (f_query_add_mod.document.mp_param_form.addl_field2_prompt.value == "")
    {
        f_query_add_mod.document.mp_param_form.addl_field2_length.value="";
        f_query_add_mod.document.mp_param_form.addl_field2_section.value="";
        f_query_add_mod.document.mp_param_form.addl_field2_length.disabled=true;
        f_query_add_mod.document.mp_param_form.addl_field2_section.disabled=true;
    }
    if (f_query_add_mod.document.mp_param_form.addl_field3_prompt.value == "")
    {
        f_query_add_mod.document.mp_param_form.addl_field3_length.value="";
        f_query_add_mod.document.mp_param_form.addl_field3_section.value="";
        f_query_add_mod.document.mp_param_form.addl_field3_length.disabled=true;
        f_query_add_mod.document.mp_param_form.addl_field3_section.disabled=true;
    }
    if (f_query_add_mod.document.mp_param_form.addl_field4_prompt.value == "")
    {
        f_query_add_mod.document.mp_param_form.addl_field4_length.value="";
        f_query_add_mod.document.mp_param_form.addl_field4_section.value="";
        f_query_add_mod.document.mp_param_form.addl_field4_length.disabled=true;
        f_query_add_mod.document.mp_param_form.addl_field4_section.disabled=true;
    }
    if (f_query_add_mod.document.mp_param_form.addl_field5_prompt.value == "")
    {
        f_query_add_mod.document.mp_param_form.addl_field5_length.value="";
        f_query_add_mod.document.mp_param_form.addl_field5_section.value="";
        f_query_add_mod.document.mp_param_form.addl_field5_length.disabled=true;
        f_query_add_mod.document.mp_param_form.addl_field5_section.disabled=true;
    }
	 
    for( var i=0; i<len; i++ )
	{
        if ( f_query_add_mod.document.mp_param_form.dflt_pat_ser_grp_type.options[i].text == initial_value )
            f_query_add_mod.document.dflt_pat_ser_grp_type.selectedIndex = i ;
    }
	if ( f_query_add_mod.mp_param_form.operation.value == "insert" )
	{
	    f_query_add_mod.mp_param_form.nat_id_pat_ser_grp.disabled = true ;
    }
	if (f_query_add_mod.mp_param_form.name_in_oth_lang_yn.checked==true)
    {
        f_query_add_mod.mp_param_form.name_prefix_loc_lang_prompt.disabled = false;
        f_query_add_mod.mp_param_form.first_name_loc_lang_prompt.disabled = false;
        f_query_add_mod.mp_param_form.second_name_loc_lang_prompt.disabled = false;
        f_query_add_mod.mp_param_form.third_name_loc_lang_prompt.disabled = false;
        f_query_add_mod.mp_param_form.family_name_loc_lang_prompt.disabled = false;
        f_query_add_mod.mp_param_form.name_suffix_loc_lang_prompt.disabled = false;
	}
    else
    {
        f_query_add_mod.mp_param_form.name_prefix_loc_lang_prompt.value = "";
        f_query_add_mod.mp_param_form.first_name_loc_lang_prompt.value = "";
        f_query_add_mod.mp_param_form.second_name_loc_lang_prompt.value = "";
        f_query_add_mod.mp_param_form.third_name_loc_lang_prompt.value = "";
        f_query_add_mod.mp_param_form.family_name_loc_lang_prompt.value = "";
        f_query_add_mod.mp_param_form.name_suffix_loc_lang_prompt.value = "";
		

        f_query_add_mod.mp_param_form.name_prefix_loc_lang_prompt.disabled = true;
        f_query_add_mod.mp_param_form.first_name_loc_lang_prompt.disabled = true;
        f_query_add_mod.mp_param_form.second_name_loc_lang_prompt.disabled = true;
        f_query_add_mod.mp_param_form.third_name_loc_lang_prompt.disabled = true;
        f_query_add_mod.mp_param_form.family_name_loc_lang_prompt.disabled = true;
        f_query_add_mod.mp_param_form.name_suffix_loc_lang_prompt.disabled = true;
		
    }
	*/

	// End of Comment

	f_query_add_mod.document.location.reload();	
	f_query_add_mod.expandCollapse("pat_admin_tab");
	//f_query_add_mod.document.mp_param_form.all.tab1.scrollIntoView();
}//End of function reset

// begin of the validation of enableNames Accept Patient name as multiParts
function enableNames()
{
	if (mp_param_form.pat_name_as_multipart_yn.checked==true)
    {  document.mp_param_form.dflt_sndx_type.disabled =false;
	    
        
		document.mp_param_form.name_prefix_accept_yn.disabled = false;
        document.mp_param_form.first_name_accept_yn.disabled = false;
        document.mp_param_form.second_name_accept_yn.disabled = false;
        document.mp_param_form.third_name_accept_yn.disabled = false;
		document.mp_param_form.family_name_accept_yn.disabled = false;
		document.mp_param_form.name_suffix_accept_yn.disabled = false;
		document.mp_param_form.name_dervn_logic.value = "PR+< , >+FN+< , >+1N";
		if (document.mp_param_form.name_in_oth_lang_yn.checked==true)
        {
			document.mp_param_form.for_loc_lang.value = document.mp_param_form.name_dervn_logic.value;
	    }

		//document.mp_param_form.for_loc_lang.value = "";
	}
    else
    {
		document.mp_param_form.name_prefix_accept_yn.disabled = false;
        document.mp_param_form.dflt_sndx_type.options[0].selected=true;
		document.mp_param_form.first_name_accept_yn.disabled = true;
        document.mp_param_form.first_name_accept_yn.checked = false;
		document.mp_param_form.first_name_reqd_yn.checked = false;
		document.mp_param_form.first_name_order.value = "";
		document.mp_param_form.first_name_prompt.value = "";
		document.mp_param_form.first_name_order.disabled = true;
		document.mp_param_form.first_name_prompt.disabled =true;
		document.mp_param_form.first_name_reqd_yn.disabled = true;


		document.mp_param_form.second_name_accept_yn.disabled = true;
		document.mp_param_form.second_name_accept_yn.checked = false;
		document.mp_param_form.second_name_reqd_yn.checked = false;
        document.mp_param_form.second_name_order.value = "";
		document.mp_param_form.second_name_prompt.value = "";
		document.mp_param_form.second_name_order.disabled = true;
		document.mp_param_form.second_name_prompt.disabled =true;
		document.mp_param_form.second_name_reqd_yn.disabled = true;

		document.mp_param_form.third_name_accept_yn.disabled = true;
		document.mp_param_form.third_name_accept_yn.checked = false;
		document.mp_param_form.third_name_reqd_yn.checked = false;
		document.mp_param_form.third_name_order.value = "";
		document.mp_param_form.third_name_prompt.value = "";
		document.mp_param_form.third_name_reqd_yn.disabled = true;
		document.mp_param_form.third_name_order.disabled =true;
		document.mp_param_form.third_name_prompt.disabled = true;
		document.mp_param_form.dflt_sndx_type.disabled = true;

		document.mp_param_form.family_name_accept_yn.disabled = false;
		document.mp_param_form.name_suffix_accept_yn.disabled = false;
        document.mp_param_form.name_dervn_logic.value = "PR+< , >+FN";
		if (document.mp_param_form.name_in_oth_lang_yn.checked==true)
        {
			document.mp_param_form.for_loc_lang.value = document.mp_param_form.name_dervn_logic.value;
	    }

//        document.mp_param_form.name_dervn_logic.value.disabled = false;
//        document.mp_param_form.dflt_patient_name.disabled = true;
		//document.mp_param_form.for_loc_lang.value = "";
		
    }
} //end of function enableNames
function enableName()
{
		document.mp_param_form.name_prefix_accept_yn.disabled = false;
        document.mp_param_form.first_name_accept_yn.disabled = true;
        document.mp_param_form.second_name_accept_yn.disabled = true;
        document.mp_param_form.third_name_accept_yn.disabled = true;
		document.mp_param_form.family_name_accept_yn.disabled = false;
		document.mp_param_form.name_suffix_accept_yn.disabled = false;
		document.mp_param_form.for_loc_lang.disabled = true;
		document.mp_param_form.dflt_patient_name.disabled=true;

		
}
// End of the validation of enableNames
function enablefld(val)
{
   if (val == 1)
    {
        if (mp_param_form.addl_field1_prompt.value != "")
        {
			if(document.mp_param_form.addl_field1_length.disabled){
	            document.mp_param_form.addl_field1_length.disabled=false;
		        document.mp_param_form.addl_field1_length.focus();
			}
            document.mp_param_form.addl_field1_section.disabled=false;
		}
        else
        {
            document.mp_param_form.addl_field1_length.value="";
            document.mp_param_form.addl_field1_section.value="";
            document.mp_param_form.addl_field1_length.disabled=true;
            document.mp_param_form.addl_field1_section.disabled=true;
        }
    }
    else if (val == 2)
    {
        if (mp_param_form.addl_field2_prompt.value != "")
        {
			if(document.mp_param_form.addl_field2_length.disabled){
	            document.mp_param_form.addl_field2_length.disabled=false;
		        document.mp_param_form.addl_field2_length.focus();
			}
            document.mp_param_form.addl_field2_section.disabled=false;
        }
        else
        {
            document.mp_param_form.addl_field2_length.value="";
            document.mp_param_form.addl_field2_section.value="";
            document.mp_param_form.addl_field2_length.disabled=true;
            document.mp_param_form.addl_field2_section.disabled=true;

        }
    }
    else if (val == 3)
    {
        if (mp_param_form.addl_field3_prompt.value != "")
        {
			if(document.mp_param_form.addl_field3_length.disabled){
	            document.mp_param_form.addl_field3_length.disabled=false;
		        document.mp_param_form.addl_field3_length.focus();
			}
            document.mp_param_form.addl_field3_section.disabled=false;
        }
        else
        {
            document.mp_param_form.addl_field3_length.value="";
            document.mp_param_form.addl_field3_section.value="";
            document.mp_param_form.addl_field3_length.disabled=true;
            document.mp_param_form.addl_field3_section.disabled=true;
        }
    }
    else if (val == 4)
    {
        if (mp_param_form.addl_field4_prompt.value != "")
        {
			if(document.mp_param_form.addl_field4_length.disabled){
	            document.mp_param_form.addl_field4_length.disabled=false;
		        document.mp_param_form.addl_field4_length.focus();
			}
            document.mp_param_form.addl_field4_section.disabled=false;
        }
        else
        {
            document.mp_param_form.addl_field4_length.value="";
            document.mp_param_form.addl_field4_section.value="";
            document.mp_param_form.addl_field4_length.disabled=true;
            document.mp_param_form.addl_field4_section.disabled=true;

        }
    }
    else if (val == 5)
    {
        if (mp_param_form.addl_field5_prompt.value != "")
        {
			if(document.mp_param_form.addl_field5_length.disabled){
	            document.mp_param_form.addl_field5_length.disabled=false;
		        document.mp_param_form.addl_field5_length.focus();
			}
			document.mp_param_form.addl_field5_section.disabled=false;
        }
        else
        {
            document.mp_param_form.addl_field5_length.value="";
            document.mp_param_form.addl_field5_section.value="";
            document.mp_param_form.addl_field5_length.disabled=true;
            document.mp_param_form.addl_field5_section.disabled=true;
        }
    }

}//end of fuction enablefld
function checkadditionalfield(Obj,index)
{	   	
//	
	if(section[index] != Obj.value){
		switch(section[index]){
			case 'D':
				if(dcount != 0)
					dcount--;
				else
					dcount = 0;
				break;
			case 'C':
				if(ccount !=0)
					ccount--;
				else
					ccount = 0;
				break;
			case 'F':
				if(fcount !=0)
					fcount--;
				break;
			case 'E':
				if(ecount !=0)
					ecount--;
				else
					ecount = 0;
				break;
			case 'O':
				if(ocount !=0)
					ocount--;
				else
					ocount = 0;
				break;
			case 'N':
				if(ncount !=0)
					ncount--;
				else
					ncount = 0;
				break;
		}
	}
	

	if(section[index] == Obj.value && section[index] != '') {
		if(dcount >=4 || ccount >=4 || ncount >=4 || fcount >=4 || ecount >=4 || ocount >=4)	{	
			alert(getMessage("MAX_3_FLDS_SECN","MP"));
		
		}
//		assignCountValues();
		return;		
	}
	section[index] = Obj.value;
	if (Obj.value=='D'){ 
        ++dcount;
	}
    if (Obj.value=='C'){
       	++ccount;	
	}
	 if (Obj.value=='F'){
       	++fcount;	
	}
	 if (Obj.value=='E'){
       	++ecount;	
	}
	 if (Obj.value=='O'){
       	++ocount;	
	}
	 if (Obj.value=='N'){
      	++ncount;	
	}
	if(dcount >=4 || ccount >=4 || ncount >=4 || fcount >=4 || ecount >=4 || ocount >=4)	{
		alert(getMessage("MAX_3_FLDS_SECN","MP"));
	}

//	assignCountValues();
}//End of function checkadditionalfield

function checkValidity()
{
    operation = mp_param_form.operation.value;
	
	var options_array = new Array( getLabel('Common.general.label','common') , getLabel('eMP.NationalID.label','MP'), getLabel('Common.AlternateID.label','Common')+" 1" ) ;
    var options_value = new Array( "G", "N", "A" ) ;
    var len       = mp_param_form.dflt_pat_ser_grp_type.options.length ;
    var initial_value = mp_param_form.dflt_pat_ser_grp_type.value ;
	
    for( var i=0; i<len; i++ )
        mp_param_form.dflt_pat_ser_grp_type.remove( "dflt_pat_ser_grp_type" ) ;

    for( var i=0; i<options_array.length; i++ )
		{
			var options = document.createElement( "OPTION" ) ;
			options.text = options_array[i] ;
			options.value = options_value[i] ;
			if ( i == 1 ) 
				{
					if ( mp_param_form.nat_id_length.value > 0 && parseInt(mp_param_form.nat_id_count.value)>0) 
					{
						mp_param_form.dflt_pat_ser_grp_type.add( options ) ;
					}
				}
			else if ( i == 2 ) 
				{
					if ( parseInt(mp_param_form.alt_id_count.value)>0)
						{
							mp_param_form.dflt_pat_ser_grp_type.add( options ) ;
						}
				} 
			else 
				{
				mp_param_form.dflt_pat_ser_grp_type.add( options ) ;
				}
		}//end of for loop
		mp_param_form.dflt_pat_ser_grp_type.value = initial_value;
		if ( operation == "insert" )
		{
			if ( mp_param_form.nat_id_length.value > 0 )
				mp_param_form.nat_id_pat_ser_grp.disabled = false ;
			else
				mp_param_form.nat_id_pat_ser_grp.disabled = true ;
		}
	    if ( operation == "modify" )
		{
			var chartMaintenance = mp_param_form.chart_maintenance.value ;
			if ( chartMaintenance == "M" ) {
            mp_param_form.single_or_multi_files_ind.item(0).disabled    = true ;
        }
        if ( mp_param_form.name_prefix_accept_yn.value  == 'N' )
            mp_param_form.name_prefix_prompt.disabled = true ;
        if ( mp_param_form.first_name_accept_yn.value   == 'N' )
            mp_param_form.first_name_prompt.disabled = true ;
        if ( mp_param_form.second_name_accept_yn.value  == 'N' )
            mp_param_form.second_name_prompt.disabled = true ;
        if ( mp_param_form.third_name_accept_yn.value   == 'N' )
            mp_param_form.third_name_prompt.disabled = true ;
        if ( mp_param_form.family_name_accept_yn.value  == 'N' )
            mp_param_form.family_name_prompt.disabled = true ;
        if ( mp_param_form.name_suffix_accept_yn.value  == 'N' )
            mp_param_form.name_suffix_prompt.disabled = true ;
        if ( mp_param_form.alt_id1_exp_warn_yn.value == 'N' )
            mp_param_form.alt_id1_exp_grace_days.disabled = true ;
        if ( mp_param_form.alt_id2_exp_warn_yn.value == 'N' )
            mp_param_form.alt_id2_exp_grace_days.disabled = true ;
        if ( mp_param_form.alt_id3_exp_warn_yn.value == 'N' )
            mp_param_form.alt_id3_exp_grace_days.disabled = true ;
        if ( mp_param_form.alt_id4_exp_warn_yn.value == 'N' )
            mp_param_form.alt_id4_exp_grace_days.disabled = true ;
    }
  
    checkLegalNames( 0 ) ;
    checkAlternateId( 0 ) ;
}//end of function checkValidity


function typecheck(val)
{
	if (val==1)
	{
		if (mp_param_form.alt_id1_type.value == "")
		{
			mp_param_form.alt_id1_chk_digit_scheme.disabled = true ;
			mp_param_form.alt_id1_length.disabled = true ;
			mp_param_form.alt_id1_len_validation_yn.disabled = true ;
			mp_param_form.alt_id1_reqd_yn.disabled = true ;
			mp_param_form.alt_id1_unique_yn.disabled = true ;
			mp_param_form.alt_id1_exp_date_accept_yn.disabled = true ;
			mp_param_form.alt_id1_invoke_routine.disabled = true ;
			mp_param_form.alt_id1_exp_warn_yn.disabled = true ;
			mp_param_form.alt_id1_exp_grace_days.disabled = true;
			mp_param_form.alt_id1_adv_alert_reqd_yn.disabled = true;
			mp_param_form.alt_id1_adv_alert_days.disabled = true;
			mp_param_form.alt_id1_routine_name.disabled =true;
		}
		else if (mp_param_form.alt_id1_type.value != "")
		{
			mp_param_form.alt_id1_chk_digit_scheme.disabled = false ;
			mp_param_form.alt_id1_length.disabled = false ;
			mp_param_form.alt_id1_len_validation_yn.disabled = false ;
			mp_param_form.alt_id1_reqd_yn.disabled = false ;
			mp_param_form.alt_id1_unique_yn.disabled = false ;
			mp_param_form.alt_id1_exp_date_accept_yn.disabled = false ;
			mp_param_form.alt_id1_invoke_routine.disabled = false ;
		}

	
	}
	if (val==2)
	{
		if (mp_param_form.alt_id2_type.value == "")
		{

			mp_param_form.alt_id2_chk_digit_scheme.disabled = true ;
			mp_param_form.alt_id2_length.disabled = true ;
			mp_param_form.alt_id2_len_validation_yn.disabled = true ;
			mp_param_form.alt_id2_reqd_yn.disabled = true ;
			mp_param_form.alt_id2_unique_yn.disabled = true ;
			mp_param_form.alt_id2_exp_date_accept_yn.disabled = true ;
			mp_param_form.alt_id2_invoke_routine.disabled = true ;
			mp_param_form.alt_id2_routine_name.disabled =true;
			mp_param_form.alt_id2_exp_warn_yn.disabled = true ;
			mp_param_form.alt_id2_exp_grace_days.disabled = true;
			mp_param_form.alt_id2_adv_alert_reqd_yn.disabled = true;
			mp_param_form.alt_id2_adv_alert_days.disabled = true;

		}
		else if (mp_param_form.alt_id2_type.value != "")
		{
			mp_param_form.alt_id2_chk_digit_scheme.disabled = false ;
			mp_param_form.alt_id2_length.disabled = false ;
			mp_param_form.alt_id2_len_validation_yn.disabled = false ;
			mp_param_form.alt_id2_reqd_yn.disabled = false ;
			mp_param_form.alt_id2_unique_yn.disabled = false ;
			mp_param_form.alt_id2_exp_date_accept_yn.disabled = false ;
			mp_param_form.alt_id2_invoke_routine.disabled = false ;
		}
		if ( mp_param_form.alt_id2_type.value != '' ) 
		{
			document.getElementById('alt_id2_img').style.visibility='visible'
		}
		else
		{
			document.getElementById('alt_id2_img').style.visibility='hidden'
		}

	}
	if (val==3)
	{
		if (mp_param_form.alt_id3_type.value == "")
		{
			mp_param_form.alt_id3_chk_digit_scheme.disabled = true ;
			mp_param_form.alt_id3_length.disabled = true ;
			mp_param_form.alt_id3_len_validation_yn.disabled = true ;
			mp_param_form.alt_id3_reqd_yn.disabled = true ;
			mp_param_form.alt_id3_unique_yn.disabled = true ;
			mp_param_form.alt_id3_exp_date_accept_yn.disabled = true ;
			mp_param_form.alt_id3_invoke_routine.disabled = true ;
			mp_param_form.alt_id3_routine_name.disabled =true;
			mp_param_form.alt_id3_exp_warn_yn.disabled = true ;
			mp_param_form.alt_id3_exp_grace_days.disabled = true;
			mp_param_form.alt_id3_adv_alert_reqd_yn.disabled = true;
			mp_param_form.alt_id3_adv_alert_days.disabled = true;

		}
		else if (mp_param_form.alt_id3_type.value != "")
		{
			mp_param_form.alt_id3_chk_digit_scheme.disabled = false ;
			mp_param_form.alt_id3_length.disabled = false ;
			mp_param_form.alt_id3_len_validation_yn.disabled = false ;
			mp_param_form.alt_id3_reqd_yn.disabled = false ;
			mp_param_form.alt_id3_unique_yn.disabled = false ;
			mp_param_form.alt_id3_exp_date_accept_yn.disabled = false ;
			mp_param_form.alt_id3_invoke_routine.disabled = false ;
		}
		if ( mp_param_form.alt_id3_type.value != '' ) 
		{
			document.getElementById('alt_id3_img').style.visibility='visible'
		}
		else
		{
			document.getElementById('alt_id3_img').style.visibility='hidden'
		}
	}
	if (val==4)
	{
		if (mp_param_form.alt_id4_type.value == "")
		{
			mp_param_form.alt_id4_chk_digit_scheme.disabled = true ;
			mp_param_form.alt_id4_length.disabled = true ;
			mp_param_form.alt_id4_len_validation_yn.disabled = true ;
			mp_param_form.alt_id4_reqd_yn.disabled = true ;
			mp_param_form.alt_id4_unique_yn.disabled = true ;
			mp_param_form.alt_id4_exp_date_accept_yn.disabled = true ;
			mp_param_form.alt_id4_invoke_routine.disabled = true ;
			mp_param_form.alt_id4_routine_name.disabled =true;
			mp_param_form.alt_id4_exp_warn_yn.disabled = true ;
			mp_param_form.alt_id4_exp_grace_days.disabled = true;
			mp_param_form.alt_id4_adv_alert_reqd_yn.disabled = true;
			mp_param_form.alt_id4_adv_alert_days.disabled = true;

		}
		else if (mp_param_form.alt_id4_type.value != "")
		{
			mp_param_form.alt_id4_chk_digit_scheme.disabled = false ;
			mp_param_form.alt_id4_length.disabled = false ;
			mp_param_form.alt_id4_len_validation_yn.disabled = false ;
			mp_param_form.alt_id4_reqd_yn.disabled = false ;
			mp_param_form.alt_id4_unique_yn.disabled = false ;
			mp_param_form.alt_id4_exp_date_accept_yn.disabled = false ;
			mp_param_form.alt_id4_invoke_routine.disabled = false ;
		}
		if ( mp_param_form.alt_id4_type.value != '' ) 
		{
			document.getElementById('alt_id4_img').style.visibility='visible'
		}
		else
		{
			document.getElementById('alt_id4_img').style.visibility='hidden'
		}
	}
}//end of function typecheck
function apply()
{	
	 //Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551
	 var isNameDervnLogicNBAppl = f_query_add_mod.document.mp_param_form.isNameDervnLogicNBAppl.value;

	//ADDED BY PRITHIVI ON 10/05/2017 FOR KDAH-CRF-0362
	 if(f_query_add_mod.document.mp_param_form.aadhar_config_enabled_yn)
	 {
        if(f_query_add_mod.document.mp_param_form.aadhar_config_enabled_yn.checked == true)
		{
			var radios = f_query_add_mod.document.getElementsByName('aadhar_option_value');
			var index = 0, length = radios.length;
			var checkedYN = false;

			for ( ; index < length; index++) {
				//radios[index].checked = "disabled";
				if(radios[index].checked == true)
				{
					checkedYN = true;
				}
			}

			if(checkedYN == false)
			{
               alert("AADHAAR option is mandatory if AADHAAR card validation option is enabled"); 
			   messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="
			   return;
			}
		}
	 }
	 
	 dcount = f_query_add_mod.dcount;
	 ccount = f_query_add_mod.ccount;
	 fcount = f_query_add_mod.fcount;
	 ecount = f_query_add_mod.ecount;
	 ocount = f_query_add_mod.ocount;
	 ncount = f_query_add_mod.ncount;
	 var ret_val;
		 
	 if ( f_query_add_mod.document.mp_param_form.religion_desc.value=="" )
        {
			f_query_add_mod.document.mp_param_form.religion_code.value="";
		}
		 if(f_query_add_mod.document.mp_param_form.race_desc.value=="")
        {			
			f_query_add_mod.document.mp_param_form.default_race_code.value="";			 
		}

	 if ( f_query_add_mod.document.mp_param_form.language_desc.value=="" )
        {
			f_query_add_mod.document.mp_param_form.language_code.value="";
		}

	 alt_id1_is_unique = f_query_add_mod.document.mp_param_form.alt_id1_unique_yn.value;
	 family_org_id_accept_yn = f_query_add_mod.document.mp_param_form.family_org_id_accept_yn.value;
	 errors = "" ;

 	 operation = f_query_add_mod.document.mp_param_form.operation.value;	 	 
	
	var dflt_patient_name = f_query_add_mod.document.mp_param_form.dflt_patient_name.value;
	var module_instal_ind = f_query_add_mod.document.mp_param_form.module_instal_ind.value;

	
		if(module_instal_ind == "DMS") 
				var msg = getLabel("eMP.UM_DefaultPatientNameInEnglish.label","MP");
		 else
				var msg = getLabel("eMP.DefaultPatientNameInEnglish.label","MP");
	
			
	/* if(f_query_add_mod.document.mp_param_form.name_dervn_logic.value!=null)
	  {		 
		 var logic = new String();
		logic = f_query_add_mod.document.mp_param_form.name_dervn_logic.value;
		var pat_name_as_multipart_yn =f_query_add_mod.document.mp_param_form.pat_name_as_multipart_yn.value;
		name_count =0;		
		var logicElements = new Array();
		logicElements = logic.split('+');
		var i=0;

		for ( i=0;i<logicElements.length;i++)
		{		
			if(logicElements[i] == '1N'  )
			{
				if ( f_query_add_mod.document.mp_param_form.first_name_length.value != '' )
					name_count = name_count + parseInt(f_query_add_mod.document.mp_param_form.first_name_length.value);
				
				
			}
			else if ( logicElements[i] == '2N'  )
			{
				if ( f_query_add_mod.document.mp_param_form.second_name_length.value != '' )
					name_count = name_count +parseInt(f_query_add_mod.document.mp_param_form.second_name_length.value);
			}
			else if ( logicElements[i] == '3N' )
			{
				if ( f_query_add_mod.document.mp_param_form.third_name_length.value != '' )
					name_count = name_count + parseInt(f_query_add_mod.document.mp_param_form.third_name_length.value);
			}
			else if ( logicElements[i] == 'FN'  )
			{
				if ( f_query_add_mod.document.mp_param_form.family_name_length.value != '' )
					name_count = name_count +parseInt(f_query_add_mod.document.mp_param_form.family_name_length.value);
			}
			else if ( logicElements[i] == 'PR' )
			{
				if ( f_query_add_mod.document.mp_param_form.all.name_prefix_length.value != '' )
				{
					name_count = name_count + parseInt(f_query_add_mod.document.mp_param_form.name_prefix_length.value);				
				}
			}
			else if( logicElements[i] == 'SF')
			{
				if ( f_query_add_mod.document.mp_param_form.name_suffix_length.value != '' )
					name_count = name_count + parseInt(f_query_add_mod.document.mp_param_form.name_suffix_length.value);
			}
			
		}			
			var total=logic.length;		
			var count1=0;
			var n=0;
			for(n = 0; n< total; n++)
			{
				if(logic.charAt(n) == " ")
					count1++;			
			}  
			
			if(name_count+count1 >80)
			{
				alert(getMessage('LEN_OF_NAMES_CANNOT_EXCEED','MP'));

				if(f_query_add_mod.document.mp_param_form.d_first_name_accept_yn.checked==true)	
				f_query_add_mod.document.mp_param_form.first_name_length.disabled=false;

				if(f_query_add_mod.document.mp_param_form.d_second_name_accept_yn.checked==true)	
				f_query_add_mod.document.mp_param_form.second_name_length.disabled=false;

				if(f_query_add_mod.document.mp_param_form.d_third_name_accept_yn.checked==true)	
				f_query_add_mod.document.mp_param_form.third_name_length.disabled=false;

				if(f_query_add_mod.document.mp_param_form.d_family_name_accept_yn.checked==true)					
				f_query_add_mod.document.mp_param_form.family_name_length.disabled=false;

				if(f_query_add_mod.document.mp_param_form.d_name_prefix_accept_yn.checked==true)	
				f_query_add_mod.document.mp_param_form.name_prefix_length.disabled=false;

				if(f_query_add_mod.document.mp_param_form.d_name_suffix_accept_yn.checked==true)	
				f_query_add_mod.document.mp_param_form.name_suffix_length.disabled=false;

				if(f_query_add_mod.document.mp_param_form.pat_name_as_multipart_yn.checked==true)	
				f_query_add_mod.document.mp_param_form.name_dervn_logic.disabled=false;


				messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
				return false;

			}
		}


	 if(f_query_add_mod.document.mp_param_form.for_loc_lang.value!=null)
	  {		 
		 var logic = new String();
		logic = f_query_add_mod.document.mp_param_form.for_loc_lang.value;
		var pat_name_as_multipart_yn =f_query_add_mod.document.mp_param_form.pat_name_as_multipart_yn.value;
		name_count =0;		
		var logicElements = new Array();
		logicElements = logic.split('+');
		var i=0;

		for ( i=0;i<logicElements.length;i++)
		{		
			if(logicElements[i] == '1N'  )
			{
				if ( f_query_add_mod.document.mp_param_form.first_name_length.value != '' )
					name_count = name_count + parseInt(f_query_add_mod.document.mp_param_form.first_name_length.value);
				
				
			}
			else if ( logicElements[i] == '2N'  )
			{
				if ( f_query_add_mod.document.mp_param_form.second_name_length.value != '' )
					name_count = name_count +parseInt(f_query_add_mod.document.mp_param_form.second_name_length.value);
			}
			else if ( logicElements[i] == '3N' )
			{
				if ( f_query_add_mod.document.mp_param_form.third_name_length.value != '' )
					name_count = name_count + parseInt(f_query_add_mod.document.mp_param_form.third_name_length.value);
			}
			else if ( logicElements[i] == 'FN'  )
			{
				if ( f_query_add_mod.document.mp_param_form.family_name_length.value != '' )
					name_count = name_count +parseInt(f_query_add_mod.document.mp_param_form.family_name_length.value);
			}
			else if ( logicElements[i] == 'PR' )
			{
				if ( f_query_add_mod.document.mp_param_form.all.name_prefix_length.value != '' )
				{
					name_count = name_count + parseInt(f_query_add_mod.document.mp_param_form.name_prefix_length.value);				
				}
			}
			else if( logicElements[i] == 'SF')
			{
				if ( f_query_add_mod.document.mp_param_form.name_suffix_length.value != '' )
					name_count = name_count + parseInt(f_query_add_mod.document.mp_param_form.name_suffix_length.value);
			}
			
		}			
			var total=logic.length;		
			var count1=0;
			var n=0;
			for(n = 0; n< total; n++)
			{
				if(logic.charAt(n) == " ")
					count1++;			
			}  
			
			if(name_count+count1 >80)
			{
				alert(getMessage('LEN_OF_NAMES_CANNOT_EXCEED','MP'));
				
				if(f_query_add_mod.document.mp_param_form.d_first_name_accept_yn.checked==true)	
				f_query_add_mod.document.mp_param_form.first_name_length.disabled=false;

				if(f_query_add_mod.document.mp_param_form.d_second_name_accept_yn.checked==true)	
				f_query_add_mod.document.mp_param_form.second_name_length.disabled=false;

				if(f_query_add_mod.document.mp_param_form.d_third_name_accept_yn.checked==true)	
				f_query_add_mod.document.mp_param_form.third_name_length.disabled=false;

				if(f_query_add_mod.document.mp_param_form.d_family_name_accept_yn.checked==true)					
				f_query_add_mod.document.mp_param_form.family_name_length.disabled=false;

				if(f_query_add_mod.document.mp_param_form.d_name_prefix_accept_yn.checked==true)	
				f_query_add_mod.document.mp_param_form.name_prefix_length.disabled=false;

				if(f_query_add_mod.document.mp_param_form.d_name_suffix_accept_yn.checked==true)	
				f_query_add_mod.document.mp_param_form.name_suffix_length.disabled=false;

				if(f_query_add_mod.document.mp_param_form.name_in_oth_lang_yn.checked==true)	
				f_query_add_mod.document.mp_param_form.for_loc_lang.disabled=false;


				messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
				return false;

			}
		}*/


     if ( operation == "insert" )
     {
		 var nb_use_mother_ser1 =f_query_add_mod.document.mp_param_form.nb_use_mother_ser1.value;
		 var gen_patid_using_altid_rl_yn1 =f_query_add_mod.document.mp_param_form.gen_patid_using_altid_rl_yn.value;

			  		/*if ( f_query_add_mod.document.mp_param_form.gen_patid_using_altid_rl_yn.checked==true )
              {
				   if(f_query_add_mod.document.mp_param_form.relation_shp_length.value==''){
				   errors = getMessage("CAN_NOT_BE_BLANK","Common");
				   errors = errors.replace('$', getLabel('eMP.RelLevelLength.label','MP'));
				   messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + errors;
				   return;
				   }
			  }*/


		 if ( f_query_add_mod.document.mp_param_form.family_org_id_accept_yn.checked==true )
              {
				   if(f_query_add_mod.document.mp_param_form.org_member_relationship_code.value==''){
				   //errors = ("Relationship for Organization Member Cannot be blank");
				   errors = getMessage("CAN_NOT_BE_BLANK","Common");
				   errors = errors.replace('$', getLabel('eMP.RelationshipforOrganizationMember.label','MP'));
				   messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + errors;
				   return;
				   }
			  }




		 if ( (alt_id1_is_unique=="Y") && (family_org_id_accept_yn=="Y") )
              {
				   errors = getMessage("ORG_MEM_NOT_APP","MP");
				   messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + errors;
				   return;
			  }
		if ("valu="+f_query_add_mod.document.mp_param_form.patient_id_length.value.indexOf('.') == -1)
		{
			if ( ( f_query_add_mod.document.mp_param_form.patient_id_length.value < 5 ) ||
				(f_query_add_mod.document.mp_param_form.patient_id_length.value > 20 ) ) {
				errors = getMessage("PAT_ID_LEN_5_20","MP");
				
				//f_query_add_mod.document.mp_param_form.all.tab1.scrollIntoView();
				f_query_add_mod.expandCollapse("pat_admin_tab");
				f_query_add_mod.document.mp_param_form.patient_id_length.focus();
				messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + errors ;
				return false ;
			}
		}

	 			 /* if (f_query_add_mod.document.mp_param_form.gen_patid_using_altid_rl_yn.checked==true)
			{
				var alt_id1_length=f_query_add_mod.document.mp_param_form.alt_id1_length.value;
				var  pat_id_length=f_query_add_mod.document.mp_param_form.patient_id_length.value;
				var relation_shp_length=f_query_add_mod.document.mp_param_form.relation_shp_length.value;
				if(relation_shp_length==null||relation_shp_length=='') relation_shp_length='0';
				var resulted_pat_id_length=eval(f_query_add_mod.document.mp_param_form.alt_id1_length.value)+eval(relation_shp_length);
				var final_resulted_pat_id_length=eval(f_query_add_mod.document.mp_param_form.patient_id_length.value)-eval(relation_shp_length);

					if(pat_id_length!=resulted_pat_id_length)
				{
						var  msg=getMessage("ALT_ID1_LENGTH","MP");
						msg = msg.replace("$",final_resulted_pat_id_length);
						alert(msg);
						//alert(msg+final_resulted_pat_id_length);
						messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="
						return;
				}
		}*/

					if (gen_patid_using_altid_rl_yn1=='Y' && nb_use_mother_ser1=='Y')
				{
					var  msg=getMessage("PAT_SER_CANNOT_BE_SAME","MP");
					alert(msg);
					messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="
					return;
				}
				
			
					if (f_query_add_mod.document.mp_param_form.patient_no_ctrl.value=="")
					{
							//alert("Numbering Control Should not be blank")
								var msg = getMessage("CAN_NOT_BE_BLANK","Common");
								msg = msg.replace('$', getLabel('eMP.NumberingControl.label','MP'));
								alert(msg)
								messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="
								return;

					}

		 	var proceed = "Y"
			if(f_query_add_mod.document.mp_param_form.dflt_patient_name.value != "") {					
				if(f_query_add_mod.document.mp_param_form.first_name_reqd_yn.checked) {
					if(dflt_patient_name.length > parseInt(f_query_add_mod.document.mp_param_form.first_name_length.value)) {					
						proceed ="N";						
						
					}
				}
				if(f_query_add_mod.document.mp_param_form.second_name_reqd_yn.checked) {
					if(dflt_patient_name.length > parseInt(f_query_add_mod.document.mp_param_form.second_name_length.value)) {				
						proceed ="N";			
					}
				}				
				if(f_query_add_mod.document.mp_param_form.third_name_reqd_yn.checked) {
					if(dflt_patient_name.length > parseInt(f_query_add_mod.document.mp_param_form.third_name_length.value)) {					
						proceed ="N";			
					}
				}
				if(f_query_add_mod.document.mp_param_form.family_name_reqd_yn.checked) {
					if(dflt_patient_name.length > parseInt(f_query_add_mod.document.mp_param_form.family_name_length.value)) {					
						proceed ="N";			
						
					}
				}
			}				 
			if ( proceed == "N" )  {
				var errors = getMessage("CANNOT_EXCEED_MIN_LENGTH","MP");
				errors = errors.replace('#', msg);			
            }
		  
		  if (SplCharChkApply(f_query_add_mod.document.mp_param_form.name_dervn_logic))
			  {                
					if (SplCharChkApply(f_query_add_mod.document.mp_param_form.for_loc_lang))
					{
						checkLegalNamesOrdering() ;
						checkAlternateIdDuplicates() ;
					}
					else
						errors = getMessage("SPL_CHAR_NOT_ALL_NMDRVN","MP");
				}
				else
					errors = getMessage("SPL_CHAR_NOT_ALL_NMDRVN","MP");	
	  } //end of if operation
      if ( errors != "" )
		  {
                messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + errors ;
                return ;
            }
			
       if ( operation == "insert" )
	   {			   
			var fields = new Array ();
			var names = new Array ();
            if (f_query_add_mod.document.mp_param_form.accept_national_id_no_yn.checked)
			{
				fields = new Array (
                        f_query_add_mod.document.mp_param_form.patient_id_length,
                        f_query_add_mod.document.mp_param_form.nat_id_length,
                        f_query_add_mod.document.mp_param_form.dflt_pat_ser_grp_type,
                        f_query_add_mod.document.mp_param_form.name_dervn_logic,
                        f_query_add_mod.document.mp_param_form.alt_id1_type,
                        f_query_add_mod.document.mp_param_form.alt_id1_length,
                        f_query_add_mod.document.mp_param_form.maintain_doc_or_file
                    );
				names = new Array (
                        getLabel('eMP.PatientIDLength.label','MP'),
                        getLabel('eMP.NationalID.label','MP')+" " +getLabel('Common.length.label','common'),
                         getLabel('Common.Default.label','common')+ getLabel('eMP.eMP.PatientSeries.label.label','MP') + getLabel('Common.type.label','common'),
                        getLabel('eMP.NameDerivationLogic.label','MP'),
                        getLabel('Common.AlternateID.label','Common')+" 1",
                        getLabel('Common.length.label','common')+" "+getLabel('Common.of.label','common')+ " " + getLabel('Common.AlternateID.label','Common')+" 1",
                        getLabel('eMP.MRAdministrationBy.label','MP')
                        );
					
			}
			else
			{
						   
				fields = new Array (
                        f_query_add_mod.document.mp_param_form.patient_id_length,
                        f_query_add_mod.document.mp_param_form.dflt_pat_ser_grp_type,
                        f_query_add_mod.document.mp_param_form.name_dervn_logic,
                        f_query_add_mod.document.mp_param_form.alt_id1_type,
                        f_query_add_mod.document.mp_param_form.alt_id1_length,
						f_query_add_mod.document.mp_param_form.maintain_doc_or_file
                    );
				names = new Array (
                        getLabel('eMP.PatientIDLength.label','MP'),
                        getLabel('Common.Default.label','common')+ getLabel('eMP.eMP.PatientSeries.label.label','MP') + getLabel('Common.type.label','common'),
                        getLabel('eMP.NameDerivationLogic.label','MP'),
                        getLabel('Common.AlternateID.label','Common')+" 1",
                        getLabel('Common.length.label','common')+" "+getLabel('Common.of.label','common')+ " " + getLabel('Common.AlternateID.label','common')+" 1",
					    getLabel('eMP.MRAdministrationBy.label','MP')
                        );
	
			}

       //     if (f_query_add_mod.document.mp_param_form.accept_national_id_no_yn.checked)
			//{
				/*if (f_query_add_mod.document.mp_param_form.gen_patid_using_altid_rl_yn.checked)
				{
					fields = new Array (
                        f_query_add_mod.document.mp_param_form.patient_id_length,
                        f_query_add_mod.document.mp_param_form.nat_id_length,
                        f_query_add_mod.document.mp_param_form.dflt_pat_ser_grp_type,
                        f_query_add_mod.document.mp_param_form.name_dervn_logic,
                        f_query_add_mod.document.mp_param_form.alt_id1_type,
                        f_query_add_mod.document.mp_param_form.alt_id1_length,
                        f_query_add_mod.document.mp_param_form.maintain_doc_or_file,
                    );
						names = new Array (
                        getLabel('eMP.PatientIDLength.label','MP'),
                        getLabel('eMP.NationalID.label','MP')+" " +getLabel('Common.length.label','common'),
                         getLabel('Common.Default.label','common')+ getLabel('eMP.eMP.PatientSeries.label.label','MP') + getLabel('Common.type.label','common'),
                        getLabel('eMP.NameDerivationLogic.label','MP'),
                        getLabel('Common.AlternateID.label','Common')+" 1",
                        getLabel('Common.length.label','common')+" "+getLabel('Common.of.label','common')+ " " + getLabel('Common.AlternateID.label','Common')+" 1",
                        getLabel('eMP.MRAdministrationBy.label','MP'),
                        );
				}
				else{
				fields = new Array (
                        f_query_add_mod.document.mp_param_form.patient_id_length,
                        f_query_add_mod.document.mp_param_form.nat_id_length,
                        f_query_add_mod.document.mp_param_form.dflt_pat_ser_grp_type,
                        f_query_add_mod.document.mp_param_form.name_dervn_logic,
                        f_query_add_mod.document.mp_param_form.alt_id1_type,
                        f_query_add_mod.document.mp_param_form.alt_id1_length,
                        f_query_add_mod.document.mp_param_form.maintain_doc_or_file
                    );
				names = new Array (
                        getLabel('eMP.PatientIDLength.label','MP'),
                        getLabel('eMP.NationalID.label','MP')+" " +getLabel('Common.length.label','common'),
                         getLabel('Common.Default.label','common')+ getLabel('eMP.eMP.PatientSeries.label.label','MP') + getLabel('Common.type.label','common'),
                        getLabel('eMP.NameDerivationLogic.label','MP'),
                        getLabel('Common.AlternateID.label','Common')+" 1",
                        getLabel('Common.length.label','common')+" "+getLabel('Common.of.label','common')+ " " + getLabel('Common.AlternateID.label','Common')+" 1",
                        getLabel('eMP.MRAdministrationBy.label','MP')
                        );
				}	
			}
			else
			{
				/*if (f_query_add_mod.document.mp_param_form.gen_patid_using_altid_rl_yn.checked){

									fields = new Array (
                        f_query_add_mod.document.mp_param_form.patient_id_length,
                        f_query_add_mod.document.mp_param_form.dflt_pat_ser_grp_type,
                        f_query_add_mod.document.mp_param_form.name_dervn_logic,
                        f_query_add_mod.document.mp_param_form.alt_id1_type,
                        f_query_add_mod.document.mp_param_form.alt_id1_length,
						f_query_add_mod.document.mp_param_form.maintain_doc_or_file,
						f_query_add_mod.document.mp_param_form.relation_shp_length
                    );
				names = new Array (
                        getLabel('eMP.PatientIDLength.label','MP'),
                        getLabel('Common.Default.label','common')+ getLabel('eMP.eMP.PatientSeries.label.label','MP') + getLabel('Common.type.label','common'),
                        getLabel('eMP.NameDerivationLogic.label','MP'),
                        getLabel('Common.AlternateID.label','Common')+" 1",
                        getLabel('Common.length.label','common')+" "+getLabel('Common.of.label','common')+ " " + getLabel('Common.AlternateID.label','common')+" 1",
					    getLabel('eMP.MRAdministrationBy.label','MP'),
					    getLabel('eMP.RelLevelLength.label','MP')
                        );
				}esle{
									fields = new Array (
                        f_query_add_mod.document.mp_param_form.patient_id_length,
                        f_query_add_mod.document.mp_param_form.dflt_pat_ser_grp_type,
                        f_query_add_mod.document.mp_param_form.name_dervn_logic,
                        f_query_add_mod.document.mp_param_form.alt_id1_type,
                        f_query_add_mod.document.mp_param_form.alt_id1_length,
						f_query_add_mod.document.mp_param_form.maintain_doc_or_file
                    );
				names = new Array (
                        getLabel('eMP.PatientIDLength.label','MP'),
                        getLabel('Common.Default.label','common')+ getLabel('eMP.eMP.PatientSeries.label.label','MP') + getLabel('Common.type.label','common'),
                        getLabel('eMP.NameDerivationLogic.label','MP'),
                        getLabel('Common.AlternateID.label','Common')+" 1",
                        getLabel('Common.length.label','common')+" "+getLabel('Common.of.label','common')+ " " + getLabel('Common.AlternateID.label','common')+" 1",
					    getLabel('eMP.MRAdministrationBy.label','MP')
                        );
				}*/

	
			//}
            if(f_query_add_mod.document.mp_param_form.alt_id1_invoke_routine.checked)
            {
                fields[fields.length] = f_query_add_mod.document.mp_param_form.alt_id1_routine_name
                names[names.length] = getLabel('Common.routine.label','common')+" 1"
            }

            if(f_query_add_mod.document.mp_param_form.alt_id2_invoke_routine.checked)
            {
                fields[fields.length] = f_query_add_mod.document.mp_param_form.alt_id2_routine_name
                names[names.length] = getLabel('Common.routine.label','common')+" 2"
            }

            if(f_query_add_mod.document.mp_param_form.alt_id3_invoke_routine.checked)
            {
               fields[fields.length] = f_query_add_mod.document.mp_param_form.alt_id3_routine_name
                names[names.length] = getLabel('Common.routine.label','common')+" 3"
            }

            if(f_query_add_mod.document.mp_param_form.alt_id4_invoke_routine.checked)
            {
                fields[fields.length] = f_query_add_mod.document.mp_param_form.alt_id4_routine_name
                names[names.length] = getLabel('Common.routine.label','common')+" 4"
            }

            if ( f_query_add_mod.document.mp_param_form.alt_id2_type.value != '' ) {
                fields = fields.concat( f_query_add_mod.document.mp_param_form.alt_id2_length ) ;
                names = names.concat( getLabel('Common.length.label','common')+" "+getLabel('Common.of.label','common')+ " " + getLabel('Common.AlternateID.label','common')+" 2" ) ;
            }

            if ( f_query_add_mod.document.mp_param_form.alt_id3_type.value != '' ) {
                fields = fields.concat( f_query_add_mod.document.mp_param_form.alt_id3_length ) ;
                names = names.concat( getLabel('Common.length.label','common')+" "+getLabel('Common.of.label','common')+ " " + getLabel('Common.AlternateID.label','common')+" 3" ) ;
            }

            if ( f_query_add_mod.document.mp_param_form.alt_id4_type.value != '' ) {
                fields = fields.concat( f_query_add_mod.document.mp_param_form.alt_id4_length ) ;
                names = names.concat( getLabel('Common.length.label','common')+" "+getLabel('Common.of.label','common')+ " " + getLabel('Common.AlternateID.label','common')+" 4" ) ;
            }
			if(f_query_add_mod.document.getElementById('dflt_patient_name_mand').style.visibility=='visible')
		   {
			fields = fields.concat( f_query_add_mod.document.mp_param_form.dflt_patient_name ) ;
                names = names.concat( getLabel('eMP.DefaultPatientNameInEnglish.label','MP'));
		   }

		   if(f_query_add_mod.document.getElementById('myimage').style.visibility=='visible')
		   {
			fields = fields.concat( f_query_add_mod.document.mp_param_form.for_loc_lang ) ;
                names = names.concat(getLabel('eMP.NameDerivationLogic.label','MP')+" "+getLabel('eMP.ForLocLang.label','MP'));
		   }

		   //Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551
		   if(isNameDervnLogicNBAppl == 'true')
		   {
				fields = fields.concat( f_query_add_mod.document.mp_param_form.name_dervn_logic_nb ) ;
				names = names.concat(getLabel('eMP.NewbornNameDervLogic.label','MP'));

				fields = fields.concat( f_query_add_mod.document.mp_param_form.name_dervn_logic_nb_sb ) ;
				names = names.concat(getLabel('eMP.NewbornNameDervLogicSB.label','MP'));
		   }

			/*Maheshwaran K added for the Bru-HIMS-CRF-171 as on 12/12/2012*/
			/*Start*/
			 if(f_query_add_mod.document.getElementById('reasonCodeMand').style.visibility=='visible')
		   {
				fields = fields.concat( f_query_add_mod.document.mp_param_form.cancel_reason_code ) ;
                names = names.concat(getLabel('Common.ReasonforCancellation.label','common'));
		   }
		   /*End*/



/*		   			 if(f_query_add_mod.document.mp_param_form.reltn_mand_gif.style.visibility=='visible')
            {
                fields[fields.length] = f_query_add_mod.document.mp_param_form.relation_shp_length
                names[names.length] = getLabel('eMP.RelLevelLength.label','MP')
            }*/

            if ( f_query_add_mod.checkFieldsofMst( fields, names, messageFrame) )
            {
						result=true;
				 		ret_val=validate_min_cut();
						if(ret_val==false)
							result=false;
						   							
                if (result == true)
                {
					   
					namecheck(operation);					
					if (result==true)
					{
				    	nullcheck(operation);
						checkMinMax();
						
						if (result==true)
						{		 
							if (result==true)
							{

								
								if(f_query_add_mod.document.mp_param_form.gestation_two_del.value!="" && f_query_add_mod.document.mp_param_form.gestation_two_del.value==0){
									messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("PERIOD_BET_TWO_DEL","MP") ;
									return;
								}


							f_query_add_mod.document.mp_param_form.single_or_multi_files_ind[0].disabled=false;
					        f_query_add_mod.document.mp_param_form.single_or_multi_files_ind[1].disabled=false;	
					        f_query_add_mod.document.mp_param_form.single_or_multi_files_ind[2].disabled=false;
							
						if(f_query_add_mod.document.mp_param_form.single_or_multi_files_ind[0].checked == true)
							f_query_add_mod.document.mp_param_form.single_or_multi_files_ind.value='S';
						if(f_query_add_mod.document.mp_param_form.single_or_multi_files_ind[1].checked == true)
							f_query_add_mod.document.mp_param_form.single_or_multi_files_ind.value='M';	
						if(f_query_add_mod.document.mp_param_form.single_or_multi_files_ind[2].checked == true)
							f_query_add_mod.document.mp_param_form.single_or_multi_files_ind.value="B";
							
							if (f_query_add_mod.document.mp_param_form.separate_file_no_yn.item(0).checked){
								f_query_add_mod.document.mp_param_form.separate_file_no_yn.item(0).disabled=false;
								f_query_add_mod.document.mp_param_form.separate_file_no_yn.value = "Y";
							}else if(f_query_add_mod.document.mp_param_form.separate_file_no_yn.item(2).checked){
								f_query_add_mod.document.mp_param_form.separate_file_no_yn.item(2).disabled=false;
								f_query_add_mod.document.mp_param_form.separate_file_no_yn.value = "B";
							}else{
								f_query_add_mod.document.mp_param_form.separate_file_no_yn.value = "N";
							}	
							if((dcount != 5  && dcount != 4 ) && ( ccount != 5 && ccount != 4 ) && (fcount != 5 && fcount != 4) && (ecount != 5 && ecount != 4 ) && ( ocount != 5 && ocount != 4 ) && ( ncount != 5 && ncount !=4)){	
								if(f_query_add_mod.document.mp_param_form.accept_for_oth_pat_ser.checked)
									f_query_add_mod.document.mp_param_form.accept_for_oth_pat_ser.value='Y';
								else
									f_query_add_mod.document.mp_param_form.accept_for_oth_pat_ser.value='N';
								//alert(f_query_add_mod.document.mp_param_form.accept_for_oth_pat_ser.value)
								if(f_query_add_mod.document.mp_param_form.nb_use_mother_ser.checked){
									f_query_add_mod.document.mp_param_form.nb_use_mother_ser.value='Y';
								}else{
									f_query_add_mod.document.mp_param_form.nb_use_mother_ser.value='N';
								}
								f_query_add_mod.document.mp_param_form.submit() ;
							}else{	
								messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("MAX_3_FLDS_SECN","MP") ;
								return false;
							}
						}
							
						}
						
					}
					
	            }
				
            }			
        } //end of if operation == "insert"
		if(operation == "modify"){			
			if((alt_id1_is_unique=="Y") && (family_org_id_accept_yn=="Y")){
				errors = getMessage("ORG_MEM_NOT_APP","MP");
				messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + errors;
				return;
			}
			if(f_query_add_mod.document.mp_param_form.gestation_two_del.value!="" && f_query_add_mod.document.mp_param_form.gestation_two_del.value==0){
				messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("PERIOD_BET_TWO_DEL","MP") ;
				return;
			}
			/*  if (f_query_add_mod.document.mp_param_form.gen_patid_using_altid_rl_yn.checked==true){
				var alt_id1_length=f_query_add_mod.document.mp_param_form.alt_id1_length.value;
				var  pat_id_length=f_query_add_mod.document.mp_param_form.patient_id_length.value;
				var relation_shp_length=f_query_add_mod.document.mp_param_form.relation_shp_length.value;
				if(relation_shp_length==null||relation_shp_length=='') relation_shp_length='0';
				var resulted_pat_id_length=eval(f_query_add_mod.document.mp_param_form.alt_id1_length.value)+eval(relation_shp_length);
				var final_resulted_pat_id_length=eval(f_query_add_mod.document.mp_param_form.patient_id_length.value)-eval(relation_shp_length);
				if(pat_id_length!=resulted_pat_id_length){
					var  msg=getMessage("ALT_ID1_LENGTH","MP");
					msg = msg.replace("$",final_resulted_pat_id_length);
					alert(msg);
					//alert(msg+final_resulted_pat_id_length);
					messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="
					return;
				}
			}*/
			var proceed = "Y"
			if(f_query_add_mod.document.mp_param_form.dflt_patient_name.value != "") {					
				if(f_query_add_mod.document.mp_param_form.d_first_name_reqd_yn.checked) {
					if(dflt_patient_name.length > parseInt(f_query_add_mod.document.mp_param_form.first_name_length.value)) {
						//errors1="Default Name length Cannot Exceeds Family Name length";	
						proceed ="N";						
						
					}
				}
				if(f_query_add_mod.document.mp_param_form.d_second_name_reqd_yn.checked) {
					if(dflt_patient_name.length > parseInt(f_query_add_mod.document.mp_param_form.second_name_length.value)) {
						//errors1 +="Default Name length Cannot Exceeds Family Name length";	
						proceed ="N";			
					}
				}				
				if(f_query_add_mod.document.mp_param_form.d_third_name_reqd_yn.checked) {
					if(dflt_patient_name.length > parseInt(f_query_add_mod.document.mp_param_form.third_name_length.value)) {
						//errors1="Default Name length Cannot Exceeds Family Name length";		
						proceed ="N";			
					}
				}
				if(f_query_add_mod.document.mp_param_form.d_family_name_reqd_yn.checked) {
					if(dflt_patient_name.length > parseInt(f_query_add_mod.document.mp_param_form.family_name_length.value)) {
						//errors1="Default Name length Cannot Exceeds Family Name length";
						proceed ="N";			
						
					}
				}
			}			
			
			if ( proceed == "N" )  {
				var errors1 = getMessage('CANNOT_EXCEED_MIN_LENGTH','MP');				
				errors1 = errors1.replace('#', msg);					
                messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + errors1 ;
                return ;
            }
	
            var fields = new Array (
                        f_query_add_mod.document.mp_param_form.dflt_pat_ser_grp_type
                    );
            var names = new Array (
                        getLabel('Common.Default.label','common')+ getLabel('eMP.eMP.PatientSeries.label.label','MP') + getLabel('Common.type.label','common')
                        );
            if(f_query_add_mod.document.mp_param_form.alt_id1_invoke_routine.checked)
            {
                fields[fields.length] = f_query_add_mod.document.mp_param_form.alt_id1_routine_name
                names[names.length] = getLabel('Common.routine.label','common')+" 1"
            }

            if(f_query_add_mod.document.mp_param_form.alt_id2_invoke_routine.checked)
            {
                fields[fields.length] = f_query_add_mod.document.mp_param_form.alt_id2_routine_name
                names[names.length] = getLabel('Common.routine.label','common')+" 2"
            }

            if(f_query_add_mod.document.mp_param_form.alt_id3_invoke_routine.checked)
            {
               fields[fields.length] = f_query_add_mod.document.mp_param_form.alt_id3_routine_name
                names[names.length] = getLabel('Common.routine.label','common')+" 3"
            }

            if(f_query_add_mod.document.mp_param_form.alt_id4_invoke_routine.checked)
            {
                fields[fields.length] = f_query_add_mod.document.mp_param_form.alt_id4_routine_name
                names[names.length] = getLabel('Common.routine.label','common')+" 4"
            }
			if(f_query_add_mod.document.getElementById('dflt_patient_name_mand').style.visibility=='visible'){
				fields[fields.length]= f_query_add_mod.document.mp_param_form.dflt_patient_name ;
                names[names.length] =  getLabel('eMP.DefaultPatientNameInEnglish.label','MP');
		   }

		   //Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551
		   if(isNameDervnLogicNBAppl == 'true')
		   {
				fields = fields.concat( f_query_add_mod.document.mp_param_form.name_dervn_logic_nb ) ;
				names = names.concat(getLabel('eMP.NewbornNameDervLogic.label','MP'));

				fields = fields.concat( f_query_add_mod.document.mp_param_form.name_dervn_logic_nb_sb ) ;
				names = names.concat(getLabel('eMP.NewbornNameDervLogicSB.label','MP'));
		   }

			/*Maheshwaran K added for the Bru-HIMS-CRF-171 as on 12/12/2012*/
			/*Start*/
		    if(f_query_add_mod.document.getElementById('reasonCodeMand').style.visibility=='visible'){
				fields = fields.concat( f_query_add_mod.document.mp_param_form.cancel_reason_code ) ;
                names = names.concat(getLabel('Common.ReasonforCancellation.label','common'));
			/*End*/
		   }

			/*	   if(f_query_add_mod.document.getElementById('reltn_mand_gif').style.visibility=='visible')
			{
				fields[fields.length]= f_query_add_mod.document.mp_param_form.relation_shp_length ;
				names[names.length] =  getLabel('eMP.RelLevelLength.label','MP');
			}*/

            if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)){
				nullcheck(operation);
				checkMinMax();
				 ret_val=validate_min_cut();				
				if(ret_val==false)
					result=false;
				if(result==true){
                   /* if (f_query_add_mod.document.mp_param_form.d_separate_file_no_yn.item(0).checked)
					    f_query_add_mod.document.mp_param_form.separate_file_no_yn.value = "Y";
					else
						f_query_add_mod.document.mp_param_form.separate_file_no_yn.value = "N";
				   */
					//Added on 7/10/2002 by kumar for updating the following fields					
					if (f_query_add_mod.document.mp_param_form.d_alt_id1_exp_warn_yn.checked)
						f_query_add_mod.document.mp_param_form.d_alt_id1_exp_warn_yn.value = "Y";
					else
						f_query_add_mod.document.mp_param_form.d_alt_id1_exp_warn_yn.value = "N";
					if (f_query_add_mod.document.mp_param_form.d_alt_id2_exp_warn_yn.checked)
						f_query_add_mod.document.mp_param_form.d_alt_id2_exp_warn_yn.value = "Y";
					else
						f_query_add_mod.document.mp_param_form.d_alt_id2_exp_warn_yn.value = "N";
					if (f_query_add_mod.document.mp_param_form.d_alt_id3_exp_warn_yn.checked)
						f_query_add_mod.document.mp_param_form.d_alt_id3_exp_warn_yn.value = "Y";
					else
						f_query_add_mod.document.mp_param_form.d_alt_id3_exp_warn_yn.value = "N";
					if (f_query_add_mod.document.mp_param_form.d_alt_id4_exp_warn_yn.checked)
						f_query_add_mod.document.mp_param_form.d_alt_id4_exp_warn_yn.value = "Y";
					else
						f_query_add_mod.document.mp_param_form.d_alt_id4_exp_warn_yn.value = "N";

					if (f_query_add_mod.document.mp_param_form.alt_id1_adv_alert_reqd_yn.checked)
						f_query_add_mod.document.mp_param_form.alt_id1_adv_alert_reqd_yn.value = "Y";
					else
						f_query_add_mod.document.mp_param_form.alt_id1_adv_alert_reqd_yn.value = "N";
					if (f_query_add_mod.document.mp_param_form.alt_id2_adv_alert_reqd_yn.checked)
						f_query_add_mod.document.mp_param_form.alt_id2_adv_alert_reqd_yn.value = "Y";
					else
						f_query_add_mod.document.mp_param_form.alt_id2_adv_alert_reqd_yn.value = "N";
					if (f_query_add_mod.document.mp_param_form.alt_id3_adv_alert_reqd_yn.checked)
						f_query_add_mod.document.mp_param_form.alt_id3_adv_alert_reqd_yn.value = "Y";
					else
						f_query_add_mod.document.mp_param_form.alt_id3_adv_alert_reqd_yn.value = "N";
					if (f_query_add_mod.document.mp_param_form.alt_id4_adv_alert_reqd_yn.checked)
						f_query_add_mod.document.mp_param_form.alt_id4_adv_alert_reqd_yn.value = "Y";
					else
						f_query_add_mod.document.mp_param_form.alt_id4_adv_alert_reqd_yn.value = "N";

					//End of addition
					if (f_query_add_mod.document.mp_param_form.alt_id1_chk_digit_scheme.value != "")
                        f_query_add_mod.document.mp_param_form.alt_id1_chk_digit_scheme.disabled=false;

                    if (f_query_add_mod.document.mp_param_form.alt_id2_chk_digit_scheme.value != "")
                        f_query_add_mod.document.mp_param_form.alt_id2_chk_digit_scheme.disabled=false;

                    if (f_query_add_mod.document.mp_param_form.alt_id3_chk_digit_scheme.value != "")
                        f_query_add_mod.document.mp_param_form.alt_id3_chk_digit_scheme.disabled=false;

                    if (f_query_add_mod.document.mp_param_form.alt_id4_chk_digit_scheme.value != "")
                        f_query_add_mod.document.mp_param_form.alt_id4_chk_digit_scheme.disabled=false;

					f_query_add_mod.document.mp_param_form.single_or_multi_files_ind[0].disabled=false;
					f_query_add_mod.document.mp_param_form.single_or_multi_files_ind[1].disabled=false;	
					f_query_add_mod.document.mp_param_form.single_or_multi_files_ind[2].disabled=false;
							
					if(f_query_add_mod.document.mp_param_form.single_or_multi_files_ind[0].checked == true)
						f_query_add_mod.document.mp_param_form.single_or_multi_files_ind.value='S';
					if(f_query_add_mod.document.mp_param_form.single_or_multi_files_ind[1].checked == true)
						f_query_add_mod.document.mp_param_form.single_or_multi_files_ind.value='M';	
					if(f_query_add_mod.document.mp_param_form.single_or_multi_files_ind[2].checked == true)
						f_query_add_mod.document.mp_param_form.single_or_multi_files_ind.value="B";

					if (f_query_add_mod.document.mp_param_form.d_separate_file_no_yn.item(0).checked)
					{
						f_query_add_mod.document.mp_param_form.d_separate_file_no_yn.item(0).disabled=false;
						f_query_add_mod.document.mp_param_form.separate_file_no_yn.value = "Y";
					}
					else if(f_query_add_mod.document.mp_param_form.d_separate_file_no_yn.item(2).checked)
					{
						f_query_add_mod.document.mp_param_form.d_separate_file_no_yn.item(2).disabled=false;
						f_query_add_mod.document.mp_param_form.separate_file_no_yn.value = "B";
					}
					else 
					{
						f_query_add_mod.document.mp_param_form.separate_file_no_yn.value = "N";
					}	
								
					f_query_add_mod.document.mp_param_form.create_file_at_pat_regn_yn.disabled=false;
					f_query_add_mod.document.mp_param_form.create_file_at_admission.disabled=false;	
					f_query_add_mod.document.mp_param_form.create_file_at_reg_visit_yn.disabled=false;
					f_query_add_mod.document.mp_param_form.create_file_at_reg_att_yn.disabled=false;
					f_query_add_mod.document.mp_param_form.create_file_at_dc_admission_yn.disabled=false;
					f_query_add_mod.document.mp_param_form.maintain_doc_or_file.disabled=false;

					if(f_query_add_mod.document.mp_param_form.create_file_at_pat_regn_yn.checked==true)
						f_query_add_mod.document.mp_param_form.create_file_at_pat_regn_yn.value = "Y";

					if(f_query_add_mod.document.mp_param_form.create_file_at_admission.checked==true)
						f_query_add_mod.document.mp_param_form.create_file_at_admission.value = "Y";

					 if(f_query_add_mod.document.mp_param_form.create_file_at_reg_visit_yn.checked==true)
						f_query_add_mod.document.mp_param_form.create_file_at_reg_visit_yn.value = "Y";

					if(f_query_add_mod.document.mp_param_form.create_file_at_reg_att_yn.checked==true)
						f_query_add_mod.document.mp_param_form.create_file_at_reg_att_yn.value = "Y";

					if(f_query_add_mod.document.mp_param_form.create_file_at_dc_admission_yn.checked==true)
						f_query_add_mod.document.mp_param_form.create_file_at_dc_admission_yn.value = "Y";				

					if( (dcount != 5  && dcount != 4 ) && ( ccount != 5 && ccount != 4 ) && (fcount != 5 && fcount != 4) && (ecount != 5 && ecount != 4 ) && ( ocount != 5 && ocount != 4 ) && ( ncount != 5 && ncount !=4)){	
                  if (f_query_add_mod.document.mp_param_form.addl_field1_prompt.value != "")
                    {
                        f_query_add_mod.document.mp_param_form.addl_field1_prompt.disabled=false;
                        f_query_add_mod.document.mp_param_form.addl_field1_length.disabled=false;
                        f_query_add_mod.document.mp_param_form.addl_field1_section.disabled=false;
                    }
                    if (f_query_add_mod.document.mp_param_form.addl_field2_prompt.value != "")
                    {
                        f_query_add_mod.document.mp_param_form.addl_field2_prompt.disabled=false;
                        f_query_add_mod.document.mp_param_form.addl_field2_length.disabled=false;
                        f_query_add_mod.document.mp_param_form.addl_field2_section.disabled=false;
                    }
                    if (f_query_add_mod.document.mp_param_form.addl_field3_prompt.value != "")
                    {
                        f_query_add_mod.document.mp_param_form.addl_field3_prompt.disabled=false;
                        f_query_add_mod.document.mp_param_form.addl_field3_length.disabled=false;
                        f_query_add_mod.document.mp_param_form.addl_field3_section.disabled=false;
                    }
                    if (f_query_add_mod.document.mp_param_form.addl_field4_prompt.value != "")
                    {
                        f_query_add_mod.document.mp_param_form.addl_field4_prompt.disabled=false;
                        f_query_add_mod.document.mp_param_form.addl_field4_length.disabled=false;
                        f_query_add_mod.document.mp_param_form.addl_field4_section.disabled=false;
                    }
                    if (f_query_add_mod.document.mp_param_form.addl_field5_prompt.value != "")
                    {
                        f_query_add_mod.document.mp_param_form.addl_field5_prompt.disabled=false;
                        f_query_add_mod.document.mp_param_form.addl_field5_length.disabled=false;
                        f_query_add_mod.document.mp_param_form.addl_field5_section.disabled=false;
                    }
						 /*if(parent.forms[0].acpt_appt_rfrl_in_reg_pat_yn.value==null)
							 alert("null");*/
						
						 
						 
						var length = f_query_add_mod.document.mp_param_form.elements.length;
						for (var i=0;i<length ;++i )
						{
						   if (f_query_add_mod.document.mp_param_form.elements[i].disabled)
							   f_query_add_mod.document.mp_param_form.elements[i].disabled=false;
						}
						if(f_query_add_mod.document.mp_param_form.nb_use_mother_ser.checked){
							f_query_add_mod.document.mp_param_form.nb_use_mother_ser.value='Y';
						}else{
							f_query_add_mod.document.mp_param_form.nb_use_mother_ser.value='N';
						}
						f_query_add_mod.document.mp_param_form.submit() ;
						
					}else{			
					
					messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("MAX_3_FLDS_SECN","MP") ;
						return;
					}
//					f_query_add_mod.document.mp_param_form.submit() ;
                } //end of if result==true
            }//end of checkfields
        }//end of if operation==modify
}//end of function apply

function checkdigits()
{
    var errors ="";
    if (f_query_add_mod.document.mp_param_form.terminal_digit_reqd_yn.checked==true)
    {
        var digit=f_query_add_mod.document.mp_param_form.terminal_digit_count.value;

        if (digit=="0")
        {
            errors=errors + getMessage("DIGITS_BLANK","MP")+ "<br>";
        }
        else if (digit=="3")
        {
            if (f_query_add_mod.document.mp_param_form.terminal_digit1_position.value=="")
            {
                errors=errors + getMessage("TER_DIGIT1_BLANK","MP")+ "<br>";
            }
            if (f_query_add_mod.document.mp_param_form.terminal_digit2_position.value=="")
            {
                errors=errors + getMessage("TER_DIGIT2_BLANK","MP")+ "<br>";
            }
            if (f_query_add_mod.document.mp_param_form.terminal_digit3_position.value=="")
            {
                errors=errors + getMessage("TER_DIGIT3_BLANK","MP")+ "<br>";
            }
        }
        else if (digit=="4")
        {
            if (f_query_add_mod.document.mp_param_form.terminal_digit1_position.value=="")
            {
                errors=errors + getMessage("TER_DIGIT1_BLANK","MP")+ "<br>";
            }
            if (f_query_add_mod.document.mp_param_form.terminal_digit2_position.value=="")
            {
                errors=errors + getMessage("TER_DIGIT2_BLANK","MP")+ "<br>";
            }
            if (f_query_add_mod.document.mp_param_form.terminal_digit3_position.value=="")
            {
                errors=errors + getMessage("TER_DIGIT3_BLANK","MP")+ "<br>";
            }
            if (f_query_add_mod.document.mp_param_form.terminal_digit4_position.value=="")
            {
                errors=errors + getMessage("TER_DIGIT4_BLANK","MP")+ "<br>";
            }
        }
        else if (digit=="5")
        {
            if (f_query_add_mod.document.mp_param_form.terminal_digit1_position.value=="")
            {
                errors=errors + getMessage("TER_DIGIT1_BLANK","MP")+ "<br>";
            }
            if (f_query_add_mod.document.mp_param_form.terminal_digit2_position.value=="")
            {
                errors=errors + getMessage("TER_DIGIT2_BLANK","MP")+ "<br>";
            }
            if (f_query_add_mod.document.mp_param_form.terminal_digit3_position.value=="")
            {
                errors=errors + getMessage("TER_DIGIT3_BLANK","MP")+ "<br>";
            }
            if (f_query_add_mod.document.mp_param_form.terminal_digit4_position.value=="")
            {
                errors=errors + getMessage("TER_DIGIT4_BLANK","MP")+ "<br>";
            }
            if (f_query_add_mod.document.mp_param_form.terminal_digit5_position.value=="")
            {
                errors=errors + getMessage("TER_DIGIT5_BLANK","MP")+ "<br>";
            }

        }
    }//end of if reqd_yn == "Y"
    if (errors == "")
    {
        result = true;
    }
    else if (errors != "")
    {
        messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + errors ;
        result = false;
    }
return result;
}//end of function checkdigits
function namecheck(mode)
{
	result=true;
    var str="";
    if (mode=="insert")
    {
		
        if ((f_query_add_mod.document.mp_param_form.first_name_accept_yn.checked==false)&&
         (f_query_add_mod.document.mp_param_form.second_name_accept_yn.checked==false)&&
        (f_query_add_mod.document.mp_param_form.third_name_accept_yn.checked==false)&&
        (f_query_add_mod.document.mp_param_form.family_name_accept_yn.checked==false))
        {
			
            str= getMessage("ONE_NAME_SELECT","MP")+ "<br>";
            messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + str;
            result = false;
			
        }else{
			/* block added for IN:034308*/
			
			if (f_query_add_mod.document.mp_param_form.first_name_accept_yn.checked==true && f_query_add_mod.document.mp_param_form.first_name_order.value==''){
				str= getMessage("FN_ORDER_BLANK","MP")+ "<br>";				
				result = false;
			}


			if (f_query_add_mod.document.mp_param_form.second_name_accept_yn.checked==true && f_query_add_mod.document.mp_param_form.second_name_order.value==''){
				str= str+getMessage("SN_ORDER_BLANK","MP")+ "<br>";				
				result = false;
			}

			if (f_query_add_mod.document.mp_param_form.third_name_accept_yn.checked==true && f_query_add_mod.document.mp_param_form.third_name_order.value==''){
				str= str+getMessage("TN_ORDER_BLANK","MP")+ "<br>";				
				result = false;
			}

			if (f_query_add_mod.document.mp_param_form.family_name_accept_yn.checked==true && f_query_add_mod.document.mp_param_form.family_name_order.value==''){
				str= str+getMessage("FAM_ORDER_BLANK","MP")+ "<br>";			   
				result = false;
			}
			
			if(! result){
				 messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + str;
			}else{
				errors_order='';
				checkLegalNamesOrdering();
				
				if (errors_order!=''){
					messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + errors_order;
					result=false;
				}

			}

			/* end block for IN:034308*/
		}
			

			 

			
        return result;
    }
}//end of function namecheck
function nullcheck(mode)
{
    var str="";
        if (mode=="insert")
        {
			result=true;
            if ((f_query_add_mod.document.mp_param_form.alt_id1_type.value != "") &&
                (f_query_add_mod.document.mp_param_form.alt_id1_adv_alert_reqd_yn.checked == true))
            {
                if (f_query_add_mod.document.mp_param_form.alt_id1_adv_alert_days.value == "")
                {
                    str= str + getMessage("ALT_ID1_NO_OF_DAYS_BLANK","MP")+ "<br>";
                }
            }
            if ((f_query_add_mod.document.mp_param_form.alt_id2_type.value != "") &&
                (f_query_add_mod.document.mp_param_form.alt_id2_adv_alert_reqd_yn.checked == true))
            {
                if (f_query_add_mod.document.mp_param_form.alt_id2_adv_alert_days.value == "")
                {
                    str= str + getMessage("ALT_ID2_NO_OF_DAYS_BLANK","MP")+ "<br>";
                }
            }
            if ((f_query_add_mod.document.mp_param_form.alt_id3_type.value != "") &&
                (f_query_add_mod.document.mp_param_form.alt_id3_adv_alert_reqd_yn.checked == true))
            {
                if (f_query_add_mod.document.mp_param_form.alt_id3_adv_alert_days.value == "")
                {
                    str= str + getMessage("ALT_ID3_NO_OF_DAYS_BLANK","MP")+ "<br>";
                }
            }
            if ((f_query_add_mod.document.mp_param_form.alt_id4_type.value != "") &&
                (f_query_add_mod.document.mp_param_form.alt_id4_adv_alert_reqd_yn.checked == true))
            {
                if (f_query_add_mod.document.mp_param_form.alt_id4_adv_alert_days.value == "")
                {
                    str= str + getMessage("ALT_ID4_NO_OF_DAYS_BLANK","MP")+ "<br>";
                }
            }

            if (f_query_add_mod.document.mp_param_form.name_prefix_accept_yn.checked==true)
            {
                if (f_query_add_mod.document.mp_param_form.name_prefix_prompt.value == "")
                {
                    str= str + getMessage("PREFIX_PROM_BLANK","MP")+ "<br>";
                }
            }
            if (f_query_add_mod.document.mp_param_form.name_suffix_accept_yn.checked==true)
            {
                if (f_query_add_mod.document.mp_param_form.name_suffix_prompt.value == "")
                {
                    str= str + getMessage("SUFFIX_PROM_BLANK","MP")+ "<br>";
                }
            }
            if (f_query_add_mod.document.mp_param_form.first_name_accept_yn.checked==true)
            {
                    if (f_query_add_mod.document.mp_param_form.first_name_order.value == "")
                {
                    str= str + getMessage("FN_ORDER_BLANK","MP")+ "<br>";
                }
                if (f_query_add_mod.document.mp_param_form.first_name_prompt.value == "")
                {
                    str= str + getMessage("FN_PROMPT_BLANK","MP")+ "<br>";
                }
            }
            if (f_query_add_mod.document.mp_param_form.second_name_accept_yn.checked==true)
            {
                if (f_query_add_mod.document.mp_param_form.second_name_order.value == "")
                {
                    str= str + getMessage("SN_ORDER_BLANK","MP")+ "<br>";
                }
                if (f_query_add_mod.document.mp_param_form.second_name_prompt.value == "")
                {
                    str= str + getMessage("SN_PROMPT_BLANK","MP")+ "<br>";
                }
            }
            if (f_query_add_mod.document.mp_param_form.third_name_accept_yn.checked==true)
            {
                if (f_query_add_mod.document.mp_param_form.third_name_order.value == "")
                {
                    str= str + getMessage("TN_ORDER_BLANK","MP")+ "<br>";
                }
                if (f_query_add_mod.document.mp_param_form.second_name_prompt.value == "")
                {
                    str= str + getMessage("TN_PROMPT_BLANK","MP")+ "<br>";
                }
            }
            if (f_query_add_mod.document.mp_param_form.family_name_accept_yn.checked==true)
            {
                if (f_query_add_mod.document.mp_param_form.family_name_order.value == "")
                {
                    str= str + getMessage("FAM_ORDER_BLANK","MP")+ "<br>";
                }
                if (f_query_add_mod.document.mp_param_form.family_name_prompt.value == "")
                {
                    str= str + getMessage("FAM_PROMPT_BLANK","MP")+ "<br>";
                }
            }
        }
        else if (mode=="modify")
        {
            if (f_query_add_mod.document.mp_param_form.d_name_prefix_accept_yn.checked==true)
            {
                if (f_query_add_mod.document.mp_param_form.name_prefix_prompt.value == "")
                {
                    str = str + getMessage("PREFIX_PROM_BLANK","MP")+ "<br>";
                }
            }
            if (f_query_add_mod.document.mp_param_form.d_name_suffix_accept_yn.checked==true)
            {
                if (f_query_add_mod.document.mp_param_form.name_suffix_prompt.value == "")
                {
                    str = str + getMessage("SUFFIX_PROM_BLANK","MP")+ "<br>";
                }
            }
            if (f_query_add_mod.document.mp_param_form.d_first_name_accept_yn.checked==true)
            {
                if (f_query_add_mod.document.mp_param_form.first_name_prompt.value == "")
                {
                    str = str + getMessage("FN_PROMPT_BLANK","MP")+ "<br>";
                }
            }
            if (f_query_add_mod.document.mp_param_form.d_second_name_accept_yn.checked==true)
            {
                if (f_query_add_mod.document.mp_param_form.second_name_prompt.value == "")
                {
                    str = str + getMessage("SN_PROMPT_BLANK","MP")+ "<br>";
                }
            }
            if (f_query_add_mod.document.mp_param_form.d_third_name_accept_yn.checked==true)
            {
                if (f_query_add_mod.document.mp_param_form.third_name_prompt.value == "")
                {
                    str = str + getMessage("TN_PROMPT_BLANK","MP")+ "<br>";
                }
            }
            if (f_query_add_mod.document.mp_param_form.d_family_name_accept_yn.checked==true)
            {
                if (f_query_add_mod.document.mp_param_form.family_name_prompt.value == "")
                {
                    str = str + getMessage("FAM_PROMPT_BLANK","MP")+ "<br>";
                }
            }
        }
            if (f_query_add_mod.document.mp_param_form.addl_field1_prompt.value != "")
            {
                if (f_query_add_mod.document.mp_param_form.addl_field1_length.value == "")
                {
                    str= str + getMessage("FIELD1_SIZE_BLANK","MP")+ "<br>";
                }
                if (f_query_add_mod.document.mp_param_form.addl_field1_section.value == "")
                {
                    str= str + getMessage("FIELD1_SEC_BLANK","MP")+ "<br>";
                }

            }
            if (f_query_add_mod.document.mp_param_form.addl_field2_prompt.value != "")
            {
                if (f_query_add_mod.document.mp_param_form.addl_field2_length.value == "")
                {
                    str= str + getMessage("FIELD2_SIZE_BLANK","MP")+ "<br>";
                }
                if (f_query_add_mod.document.mp_param_form.addl_field2_section.value == "")
                {
                    str= str + getMessage("FIELD2_SEC_BLANK","MP")+ "<br>";
                }

            }
            if (f_query_add_mod.document.mp_param_form.addl_field3_prompt.value != "")
            {
                if (f_query_add_mod.document.mp_param_form.addl_field3_length.value == "")
                {
                    str= str + getMessage("FIELD3_SIZE_BLANK","MP")+ "<br>";
                }
                if (f_query_add_mod.document.mp_param_form.addl_field3_section.value == "")
                {
                    str= str + getMessage("FIELD3_SEC_BLANK","MP")+ "<br>";
                }

            }
            if (f_query_add_mod.document.mp_param_form.addl_field4_prompt.value != "")
            {
                if (f_query_add_mod.document.mp_param_form.addl_field4_length.value == "")
                {
                    str= str + getMessage("FIELD4_SIZE_BLANK","MP")+ "<br>";
                }
                if (f_query_add_mod.document.mp_param_form.addl_field4_section.value == "")
                {
                    str= str + getMessage("FIELD4_SEC_BLANK","MP")+ "<br>";
                }

            }
            if (f_query_add_mod.document.mp_param_form.addl_field5_prompt.value != "")
            {
                if (f_query_add_mod.document.mp_param_form.addl_field5_length.value == "")
                {
                    str= str + getMessage("FIELD5_SIZE_BLANK","MP")+ "<br>";
                }
                if (f_query_add_mod.document.mp_param_form.addl_field5_section.value == "")
                {
                    str= str + getMessage("FIELD5_SEC_BLANK","MP")+ "<br>";
                }
            }
		if (str == "")
        {
            result = true;
        }
        else if (str != "")
        {
            messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + str ;
            result = false;
        }


        return result;
}
function checkzero(obj)
{
    var val = obj.value;
	
	
if(val!="")
	{
	if (val.indexOf('.')==-1)
	{
		if (val == '0')
		{
			errors = getMessage("VALUE_GREAT_ZERO","MP");
			alert( errors ) ;
			obj.value="";
			obj.focus() ;
			return false ;
		}
		else if (val > 30)
		{
			errors = getMessage("MAX_LENGTH_30","MP");
			alert( errors ) ;
			obj.value="";
			
			obj.focus() ;
			return false ;
		}
	}
	}
    return true;
}

function checkPatIdLength() {
    if (mp_param_form.patient_id_length.value.indexOf('.') == -1)
	{
		if ( ( mp_param_form.patient_id_length.value < 5 ) ||
			( mp_param_form.patient_id_length.value > 20 ) ) {
			errors = getMessage("PAT_ID_LEN_5_20","MP");
			alert( errors ) ;
			mp_param_form.patient_id_length.focus() ;
			return false ;
		}
	}
    return true ;
}

function checkAltIdLength(obj) {
    var val= obj.value;
	if (val.indexOf('.') == -1)
	{
		if ( ( val < 5 ) ||
			( val > 20 ) ) {
			errors = getMessage("ALT_ID_LEN_5_20","MP");
			alert( errors ) ;
			obj.focus() ;
			return false ;
		}
	}
    return true ;
}

function checkNatIdLength() {
	if (mp_param_form.nat_id_length.value.indexOf('.') == -1)
	{
		if (    ( mp_param_form.nat_id_length.value < 5 ) ||
			( mp_param_form.nat_id_length.value > 20 ) ) {
			errors = getMessage("NAT_ID_LEN_5_20","MP");
			alert( errors ) ;
			mp_param_form.nat_id_length.focus() ;
			return false ;
		}

		if ( mp_param_form.nat_id_length.value == 0 )
			mp_param_form.nat_id_pat_ser_grp.disabled = true ;
		else
			mp_param_form.nat_id_pat_ser_grp.disabled = false ;

		var options_array = new Array( getLabel('Common.general.label','common'), getLabel('eMP.NationalID.label','MP'), getLabel('Common.AlternateID.label','common')+" 1" ) ;
		var options_value = new Array( "G", "N", "A" ) ;
		var len     = mp_param_form.dflt_pat_ser_grp_type.options.length ;

		for( var i=0; i<len; i++ )
			mp_param_form.dflt_pat_ser_grp_type.remove( "dflt_pat_ser_grp_type" ) ;

		for( var i=0; i<options_array.length; i++ ) {
			var options = document.createElement( "OPTION" ) ;
			options.text = options_array[i] ;
			options.value = options_value[i] ;
			//Modified on 12/03/2003 
			if ( i == 1 ) {
				if ( mp_param_form.nat_id_length.value > 0 && parseInt(mp_param_form.nat_id_count.value)>0 ) {
					mp_param_form.dflt_pat_ser_grp_type.add( options ) ;
				}
			} 
			
			else if ( i == 2 ) {
				
				if ( parseInt(mp_param_form.alt_id_count.value)>0 ) {
					mp_param_form.dflt_pat_ser_grp_type.add( options ) ;
				}
			} 
			else {
				mp_param_form.dflt_pat_ser_grp_type.add( options ) ;
				}
		}
		//Modification ends here
	}
    return true ;
}

function validToken( token ) {
    var validTokens = new Array( "PR", "1N", "2N", "3N", "FN", "SF" ) ;
    var result  = false ;

    for( var i=0; i<validTokens.length && !result ; i++ ) {
        if ( token == validTokens[i] ) result = true ;
    }

    return result ;
}
/*
function checkName(val) {
    if (val == "1")
    {
        if (mp_param_form.for_loc_lang.value != "")
        {
            checkNameDervnLogic();
        }
    }
}
*/
function checkNameDervnLogic(obj) {
    var formula = obj.value.split( "+" ) ;
    var valid   = false ;

    var error   = getMessage("INVALID_PAT_DRVN_LOGIC","MP");
    if (formula=="")
    {
        error   = getMessage("NAME_DRVN_BLANK","MP");
        alert( error ) ;
        obj.focus();
        return false;
    }
    else if (formula != "")
    {
        for( var i=0; i<formula.length; i++ ) {

            if ( i == 0 ) {
                if ( !( formula[i] == "1N" || formula[i] == "PR" || formula[i] == "FN" ) ) {
                    alert( error ) ;
                    obj.focus();
                    return false ;
                }
            }
        }

        for( var i=0; i<formula.length; i++ ) {

            var f       = formula[i] ;
            var len     = f.length ;
            var isConstant  = false ;
            var start   = f.substring( 0, 1 ) ;
            var end     = f.substring( len-1, len ) ;
            var isOk    = true ;

            if ( start == "<" && end == ">" )
                isConstant = true ;

            if ( !isConstant ) {
                if ( !validToken( f ) ) {
                    alert( error ) ;
                    obj.focus();
                    return false ;
                }
            }
        }
    }
    return true ;
}

  function  CheckNumRange(obj)
  {
    var val =obj.value;
  if(val>72)
	  {
	  alert("The age in hours exceeding the setup in MP parameter");
	  }
  }

function checkNumberingControl( option ) {
    
	if ( operation == "insert" ) {
        if ( option == "S" ) {
            mp_param_form.separate_file_no_yn.item(1).checked   = true ;
        //    mp_param_form.separate_file_no_yn.item(0).disabled  = false ;
			mp_param_form.separate_file_no_yn.value = "N";
          //  mp_param_form.separate_file_no_yn.item(1).disabled  = false ;
        }

        if ( option == "M" ) {
            mp_param_form.separate_file_no_yn.item(0).checked   = true ;
			mp_param_form.separate_file_no_yn.value = "Y";
           // mp_param_form.separate_file_no_yn.item(0).disabled  = true ;
            mp_param_form.separate_file_no_yn.item(1).disabled  = false ;
        }
    if(option=="A")
		{
		  mp_param_form.separate_file_no_yn.item(0).disabled  = false ;
          mp_param_form.separate_file_no_yn.item(1).disabled  = false ;
	
		  }
	
	if(option=="F")
		{
		  mp_param_form.separate_file_no_yn.item(0).disabled  = false ;
          mp_param_form.separate_file_no_yn.item(1).disabled  = false ;
	
		  }
	if(option=="B")
	{
		mp_param_form.separate_file_no_yn.item(2).checked   = true ;
		mp_param_form.separate_file_no_yn.value = "B";

	}
}

    if ( operation == "modify" ) {
        if ( option == "S" ) {
            //mp_param_form.d_separate_file_no_yn.item(1).checked = true ;
            mp_param_form.d_separate_file_no_yn.item(0).disabled    = true ;
            mp_param_form.d_separate_file_no_yn.item(1).disabled    = true ;
            if (mp_param_form.separate_file_no_yn.value=="Y")
            {
                mp_param_form.d_separate_file_no_yn.item(0).checked=true;
                mp_param_form.d_separate_file_no_yn.item(1).checked=false;
            }
            else
            {
                mp_param_form.d_separate_file_no_yn.item(1).checked=true;
                mp_param_form.d_separate_file_no_yn.item(0).checked=false;
            }
        }

        if ( option == "M" ) {
            mp_param_form.d_separate_file_no_yn.item(0).checked = true ;
			mp_param_form.d_separate_file_no_yn.item(0).disabled    = true ;
            mp_param_form.d_separate_file_no_yn.item(1).disabled    = true ;
			//mp_param_form.separate_file_no_yn.value = "Y" ;
            /*if (mp_param_form.single_or_multi_files_ind.item(0).disabled==false)
            {
                mp_param_form.d_separate_file_no_yn.item(0).disabled    = false ;
                mp_param_form.d_separate_file_no_yn.item(1).disabled    = false ;
                if (mp_param_form.d_separate_file_no_yn.item(0).checked==true)
                {
                    mp_param_form.separate_file_no_yn.value = "Y" ;
                }
                else
                    mp_param_form.separate_file_no_yn.value = "N" ;
            } */


        }
		if(option == "B")
		{
			mp_param_form.d_separate_file_no_yn.item(2).checked = true ;
			mp_param_form.separate_file_no_yn.value = "B";
		}
    }
}

function chkMedicalAdminFields(obj)
{

	if(obj.checked == true)
	{
		obj.value='Y';
		mp_param_form.create_file_yn.value='Y';

		mp_param_form.single_or_multi_files_ind.item(0).disabled = false;
		mp_param_form.single_or_multi_files_ind.item(1).disabled = false;
		mp_param_form.single_or_multi_files_ind.item(2).disabled = true;

		mp_param_form.separate_file_no_yn.item(0).disabled = false;
		mp_param_form.separate_file_no_yn.item(1).disabled = false;
		mp_param_form.separate_file_no_yn.item(2).disabled = true;

		mp_param_form.create_file_at_pat_regn_yn.disabled = false;
		mp_param_form.create_file_at_admission.disabled = false;
		mp_param_form.create_file_at_reg_visit_yn.disabled = false;
		mp_param_form.create_file_at_reg_att_yn.disabled = false;
		mp_param_form.create_file_at_dc_admission_yn.disabled = false;
		
		mp_param_form.single_or_multi_files_ind.item(1).checked = true;
		mp_param_form.separate_file_no_yn.item(0).checked = true;


		
	}
	else if(obj.checked == false)
	{
		obj.value='N';
		mp_param_form.create_file_yn.value='N';

		mp_param_form.single_or_multi_files_ind.item(0).disabled = true;
		mp_param_form.single_or_multi_files_ind.item(1).disabled = true;
		mp_param_form.single_or_multi_files_ind.item(2).disabled = false;

		mp_param_form.separate_file_no_yn.item(0).disabled = true;
		mp_param_form.separate_file_no_yn.item(1).disabled = true;
		mp_param_form.separate_file_no_yn.item(2).disabled = false;

		mp_param_form.create_file_at_pat_regn_yn.disabled = true;
		mp_param_form.create_file_at_admission.disabled = true;
		mp_param_form.create_file_at_reg_visit_yn.disabled = true;
		mp_param_form.create_file_at_reg_att_yn.disabled = true;
		mp_param_form.create_file_at_dc_admission_yn.disabled = true;

		mp_param_form.single_or_multi_files_ind.item(2).checked = true;
		mp_param_form.separate_file_no_yn.item(2).checked = true;

		mp_param_form.single_or_multi_files_ind.value = "";
		mp_param_form.separate_file_no_yn.value = "";		

		mp_param_form.create_file_at_pat_regn_yn.checked = false;
		mp_param_form.create_file_at_admission.checked = false;
		mp_param_form.create_file_at_reg_visit_yn.checked = false;
		mp_param_form.create_file_at_reg_att_yn.checked = false;
		mp_param_form.create_file_at_dc_admission_yn.checked = false;


	}

}

function checkLegalNames( row ) {
    var result = true ;

    if ( operation == "modify" ) {
        //added by DHeeraj - 11/7/02 - Begin
            if ( mp_param_form.d_name_prefix_accept_yn.checked == true  ){
                mp_param_form.name_prefix_prompt.disabled = false
                if(mp_param_form.name_in_oth_lang_yn.checked == true) {
                            mp_param_form.name_prefix_loc_lang_prompt.disabled = false
                }else{
                            mp_param_form.name_prefix_loc_lang_prompt.disabled = true
                }
            } else {
                    mp_param_form.name_prefix_prompt.disabled = true
                    mp_param_form.name_prefix_loc_lang_prompt.disabled = true
            }

			//first name
            if ( mp_param_form.d_first_name_accept_yn.checked == true  ){
                mp_param_form.first_name_prompt.disabled = false
                if(mp_param_form.name_in_oth_lang_yn.checked == true) {
                            mp_param_form.first_name_loc_lang_prompt.disabled = false
                }else{
                            mp_param_form.first_name_loc_lang_prompt.disabled = true
                }
            } else {
                    mp_param_form.first_name_prompt.disabled = true
                    mp_param_form.first_name_loc_lang_prompt.disabled = true
            }

			//second name
			if ( mp_param_form.d_second_name_accept_yn.checked == true  ){
                mp_param_form.second_name_prompt.disabled = false
                if(mp_param_form.name_in_oth_lang_yn.checked == true) {
                            mp_param_form.second_name_loc_lang_prompt.disabled = false
                }else{
                            mp_param_form.second_name_loc_lang_prompt.disabled = true
                }
            } else {
                    mp_param_form.second_name_prompt.disabled = true
                    mp_param_form.second_name_loc_lang_prompt.disabled = true
            }

			//third name
            if ( mp_param_form.d_third_name_accept_yn.checked == true  ){
                mp_param_form.third_name_prompt.disabled = false
                if(mp_param_form.name_in_oth_lang_yn.checked == true) {
                            mp_param_form.third_name_loc_lang_prompt.disabled = false
                }else{
                            mp_param_form.third_name_loc_lang_prompt.disabled = true
                }
            } else {
                    mp_param_form.third_name_prompt.disabled = true
                    mp_param_form.third_name_loc_lang_prompt.disabled = true
            }

			//family name
            if ( mp_param_form.d_family_name_accept_yn.checked == true  ){
                mp_param_form.family_name_prompt.disabled = false
                if(mp_param_form.name_in_oth_lang_yn.checked == true) {
                            mp_param_form.family_name_loc_lang_prompt.disabled = false
                }else{
                            mp_param_form.family_name_loc_lang_prompt.disabled = true
                }
            } else {
                    mp_param_form.family_name_prompt.disabled = true
                    mp_param_form.family_name_loc_lang_prompt.disabled = true
            }

			//suffix
            if ( mp_param_form.d_name_suffix_accept_yn.checked == true  ){
                mp_param_form.name_suffix_prompt.disabled = false
                if(mp_param_form.name_in_oth_lang_yn.checked == true) {
                            mp_param_form.name_suffix_loc_lang_prompt.disabled = false
                }else{
                            mp_param_form.name_suffix_loc_lang_prompt.disabled = true
                }
            } else {
                    mp_param_form.name_suffix_prompt.disabled = true
                    mp_param_form.name_suffix_loc_lang_prompt.disabled = true
            }

		
		//added by DHeeraj - 11/7/02 - End

        return ;
    }

    // Prefix
    if ( row == 1 || row == 0 ) {
        if (    mp_param_form.name_prefix_accept_yn.checked == true ) {
			mp_param_form.name_prefix_accept_yn.value='Y';
            mp_param_form.name_prefix_reqd_yn.disabled  = false ;
            mp_param_form.name_prefix_length.disabled  = false ;
            mp_param_form.name_prefix_prompt.disabled       = false ;
			if (mp_param_form.name_in_oth_lang_yn.checked)
				mp_param_form.name_prefix_loc_lang_prompt.disabled = false ;
			//added newly for Reqd for Orgn Member start
			if(mp_param_form.family_org_id_accept_yn.checked==true){
				if(mp_param_form.name_prefix_reqd_yn.checked==false){
				mp_param_form.name_pfx_reqd_for_org_mem_yn.disabled=false;
				mp_param_form.name_pfx_reqd_for_org_mem_yn.checked=false;
				mp_param_form.name_pfx_reqd_for_org_mem_yn.value="N";
				}else if((!mp_param_form.family_org_id_accept_yn.checked==true && mp_param_form.name_prefix_reqd_yn.checked==true)){
					mp_param_form.name_prefix_reqd_yn.disabled=true;
					mp_param_form.name_prefix_reqd_yn.disabled=true;
				}
				if(mp_param_form.family_org_id_accept_yn.checked==true && mp_param_form.name_prefix_reqd_yn.checked==true && mp_param_form.name_pfx_reqd_for_org_mem_yn.checked==true && mp_param_form.name_prefix_reqd_yn.checked==true)
					mp_param_form.name_prefix_reqd_yn.disabled=true;
			}else{
				if(mp_param_form.name_prefix_reqd_yn.checked==false){
					mp_param_form.name_prefix_reqd_yn_new.value='N';
				}else{
					mp_param_form.name_prefix_reqd_yn_new.value='Y'
				}
			}
			/*if(mp_param_form.name_prefix_reqd_yn.checked==false && mp_param_form.family_org_id_accept_yn.checked==true){
				mp_param_form.name_pfx_reqd_for_org_mem_yn.disabled=false;
				mp_param_form.name_pfx_reqd_for_org_mem_yn.checked=false;
				mp_param_form.name_pfx_reqd_for_org_mem_yn.value="N";
			}else if(mp_param_form.name_prefix_reqd_yn.checked==true){
					mp_param_form.name_prefix_reqd_yn.disabled=true;
				
			}*/

        } else {
			
            mp_param_form.name_prefix_reqd_yn.disabled  = true ;
            mp_param_form.name_prefix_length.disabled  = true ;
            mp_param_form.name_prefix_length.value  = "" ;
            mp_param_form.name_prefix_prompt.disabled  = true ;
			mp_param_form.name_prefix_loc_lang_prompt.disabled = true ;
            mp_param_form.name_prefix_reqd_yn.checked       = false ;
            mp_param_form.name_prefix_prompt.value      = "" ;
			mp_param_form.name_prefix_loc_lang_prompt.value = "";
			//added newly for Reqd for Orgn Member
			mp_param_form.name_pfx_reqd_for_org_mem_yn.disabled=true;
			mp_param_form.name_pfx_reqd_for_org_mem_yn.checked=false;
			mp_param_form.name_pfx_reqd_for_org_mem_yn.value="N";
        }
    }

    // First Name

    if ( row == 2 || row == 0 ) {
        if ( mp_param_form.first_name_accept_yn.checked == true ) {
            mp_param_form.first_name_reqd_yn.disabled       = false ;
            mp_param_form.first_name_length.disabled       = false ;
            mp_param_form.first_name_order.disabled     = false ;
            mp_param_form.first_name_prompt.disabled        = false ;
			if (mp_param_form.name_in_oth_lang_yn.checked)
				mp_param_form.first_name_loc_lang_prompt.disabled = false ;
        } else {
            mp_param_form.first_name_reqd_yn.disabled       = true ;
            mp_param_form.first_name_length.value       = "" ;
            mp_param_form.first_name_length.disabled       = true ;
            mp_param_form.first_name_order.disabled     = true ;
            mp_param_form.first_name_prompt.disabled        = true ;	
			mp_param_form.first_name_loc_lang_prompt.disabled = true ;
			//mp_param_form.first_name_accept_yn.disabled = true;
            mp_param_form.first_name_reqd_yn.checked        = false ;
            mp_param_form.first_name_order.value        = "" ;
            mp_param_form.first_name_prompt.value       = "" ;
			mp_param_form.first_name_loc_lang_prompt.value = "";
        }
    }

    // Second Name

    if ( row == 3 || row == 0 ) {
        if ( mp_param_form.second_name_accept_yn.checked == true ) {
            mp_param_form.second_name_reqd_yn.disabled  = false ;
            mp_param_form.second_name_length.disabled  = false ;
            mp_param_form.second_name_order.disabled        = false ;
            mp_param_form.second_name_prompt.disabled       = false ;
			if (mp_param_form.name_in_oth_lang_yn.checked)
				mp_param_form.second_name_loc_lang_prompt.disabled = false ;
        } else {
            mp_param_form.second_name_reqd_yn.disabled  = true ;
            mp_param_form.second_name_length.value  = "" ;
            mp_param_form.second_name_length.disabled  = true ;
            mp_param_form.second_name_order.disabled        = true ;
            mp_param_form.second_name_prompt.disabled       = true ;
			mp_param_form.second_name_loc_lang_prompt.disabled = true ;
            //mp_param_form.second_name_accept_yn.disabled = true;
			mp_param_form.second_name_reqd_yn.checked       = false ;
            mp_param_form.second_name_order.value       = "" ;
            mp_param_form.second_name_prompt.value      = "" ;
			mp_param_form.second_name_loc_lang_prompt.value = "";
        }
    }

    // Third Name

    if ( row == 4 || row == 0 ) {
        if ( mp_param_form.third_name_accept_yn.checked == true ) {
            mp_param_form.third_name_reqd_yn.disabled       = false ;
            mp_param_form.third_name_length.disabled       = false ;
            mp_param_form.third_name_order.disabled     = false ;
            mp_param_form.third_name_prompt.disabled        = false ;
			if (mp_param_form.name_in_oth_lang_yn.checked)
				mp_param_form.third_name_loc_lang_prompt.disabled = false ;
        } else {
            mp_param_form.third_name_reqd_yn.disabled   = true ;
            mp_param_form.third_name_length.value   = "" ;
            mp_param_form.third_name_length.disabled   = true ;
            mp_param_form.third_name_order.disabled     = true ;
            mp_param_form.third_name_prompt.disabled        = true ;
			//mp_param_form.third_name_accept_yn.disabled = true;
            mp_param_form.third_name_reqd_yn.checked        = false ;
            mp_param_form.third_name_order.value        = "" ;
            mp_param_form.third_name_prompt.value       = "" ;
			mp_param_form.third_name_loc_lang_prompt.disabled = true;
			mp_param_form.third_name_loc_lang_prompt.value = "";
        }
    }

    // Family Name

    if ( row == 5 || row == 0 ) {
        if ( mp_param_form.family_name_accept_yn.checked == true ) {
            mp_param_form.family_name_reqd_yn.disabled  = false ;
            mp_param_form.family_name_length.disabled  = false ;
			mp_param_form.family_name_reqd_yn.checked  = true ;
            mp_param_form.family_name_order.disabled        = false ;
            mp_param_form.family_name_prompt.disabled       = false ;
			if (mp_param_form.name_in_oth_lang_yn.checked)
				mp_param_form.family_name_loc_lang_prompt.disabled = false ;
        } else {
            mp_param_form.family_name_reqd_yn.disabled  = true ;
            mp_param_form.family_name_length.value  = "" ;
            mp_param_form.family_name_length.disabled  = true ;
            mp_param_form.family_name_order.disabled        = true ;
            mp_param_form.family_name_prompt.disabled       = true ;

            mp_param_form.family_name_reqd_yn.checked       = false ;
            mp_param_form.family_name_order.value       = "" ;
            mp_param_form.family_name_prompt.value      = "" ;
			mp_param_form.family_name_loc_lang_prompt.disabled = true;
			mp_param_form.family_name_loc_lang_prompt.value = "";
        }
    }

    // Suffix

    if ( row == 6 || row == 0 ) {
        if ( mp_param_form.name_suffix_accept_yn.checked == true ) {
            mp_param_form.name_suffix_reqd_yn.disabled  = false ;
            mp_param_form.name_suffix_length.disabled  = false ;
            mp_param_form.name_suffix_prompt.disabled       = false ;
			if (mp_param_form.name_in_oth_lang_yn.checked)
				mp_param_form.name_suffix_loc_lang_prompt.disabled = false ;
        } else {
            mp_param_form.name_suffix_reqd_yn.disabled  = true ;
            mp_param_form.name_suffix_length.value  = "" ;
            mp_param_form.name_suffix_length.disabled  = true ;
            mp_param_form.name_suffix_prompt.disabled       = true ;

            mp_param_form.name_suffix_reqd_yn.checked       = false ;
            mp_param_form.name_suffix_prompt.value      = "" ;
			mp_param_form.name_suffix_loc_lang_prompt.disabled = true;
			mp_param_form.name_suffix_loc_lang_prompt.value = "";
        }
    }

    return result ;
}


function checkLegalNamesOrdering() {
    var result = true ;
    var count  = 0 ;
    var array1 = new Array(
                f_query_add_mod.document.mp_param_form.first_name_order.value,
                f_query_add_mod.document.mp_param_form.second_name_order.value,
                f_query_add_mod.document.mp_param_form.third_name_order.value,
                f_query_add_mod.document.mp_param_form.family_name_order.value
            ) ;
    var array2 = new Array(
                f_query_add_mod.document.mp_param_form.first_name_order.value,
                f_query_add_mod.document.mp_param_form.second_name_order.value,
                f_query_add_mod.document.mp_param_form.third_name_order.value,
                f_query_add_mod.document.mp_param_form.family_name_order.value
            ) ;
	
    for( var i=0; i<array1.length; i++ )
        if ( array1[i] != "" ) 
			count++ ;
		
	
    for( var i=0; i<array1.length; i++ ) 
	{	
		
        if ( array1[i] != "" ) 
			{
				
				if ( array1[i] < 1 || array1[i] > 4 ) 
				{
					errors = errors + getMessage("LEGAL_NM_1_4","MP")+ "<br>";
					result = false ;
				}
	            if ( array1[i] > count ) 
				{
		            var msg = getMessage("MAX_LEGAL_NM_ORD","MP");
					msg = msg.replace("%",count);
					errors = errors+ msg+"<br>";
					return false ;
				}
			}
    }

    if ( result ) {
        br_x:for( var i=0; i<array1.length; i++ ) {  /* loop identifier added IN:034308*/
            for( var j=0; j<array2.length; j++ ) {
                if ( array1[i] != "" ) {
                    if ( i != j ) {
                        if ( array1[i] == array2[j] ){
							result = false ;
								errors_order=getMessage("DUPL_LEGAL_NM_ORD","MP");  /* 2 lines added for IN:034308*/
								break br_x;
						}
                    }
                }
            }
        }
		
        if ( !result )
            errors = errors + getMessage("DUPL_LEGAL_NM_ORD","MP")+ "<br>";
			
    }

    return result ;
}

function disableAlternateId( row ) {
    if ( row == 1 ) {
        mp_param_form.alt_id1_chk_digit_scheme.value = "" ;
        mp_param_form.alt_id1_length.value      = "" ;
        mp_param_form.alt_id1_reqd_yn.checked       = false ;
        mp_param_form.alt_id1_unique_yn.checked     = false ;
        mp_param_form.alt_id1_exp_warn_yn.checked   = false ;
        mp_param_form.alt_id1_exp_grace_days.value  = "" ;
        mp_param_form.alt_id1_reqd_yn.checked       = false ;
        mp_param_form.alt_id1_exp_date_accept_yn.checked = false ;
        mp_param_form.alt_id1_invoke_routine.checked = false ;
        mp_param_form.alt_id1_routine_name.value ="" ;
        mp_param_form.alt_id1_len_validation_yn.checked = false ;
        mp_param_form.alt_id1_adv_alert_reqd_yn.checked = false ;
        mp_param_form.alt_id1_adv_alert_days.value  = "" ;
		mp_param_form.accept_for_oth_pat_ser.checked = false;
		mp_param_form.accept_alphanumeric.checked = false;		
		/*Added by Dharma on Apr 3rd 2015 against HSA-CRF-0191 [IN:049772] Start*/
		mp_param_form.alt_id1_chng_allowed_yn.checked		= false ;
		mp_param_form.Accept_oth_alt_id_yn.checked			= false ;
		/*Added by Dharma on Apr 3rd 2015 against HSA-CRF-0191 [IN:049772] End*/
		mp_param_form.alt_id1_pat_sch_exact_yn.checked= false;//Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]

        typecheck(1);
    }

    if ( row == 2 ) {
        mp_param_form.alt_id2_chk_digit_scheme.value = "" ;
        mp_param_form.alt_id2_length.value      = "" ;
        mp_param_form.alt_id2_reqd_yn.checked       = false ;
        mp_param_form.alt_id2_unique_yn.checked     = false ;
        mp_param_form.alt_id2_exp_warn_yn.checked   = false ;
        mp_param_form.alt_id2_exp_grace_days.value  = "" ;
        mp_param_form.alt_id2_exp_date_accept_yn.checked = false ;
        mp_param_form.alt_id2_invoke_routine.checked = false ;
        mp_param_form.alt_id2_routine_name.value ="" ;
        mp_param_form.alt_id2_len_validation_yn.checked = false ;
        mp_param_form.alt_id2_adv_alert_reqd_yn.checked = false ;
        mp_param_form.alt_id2_adv_alert_days.value  = "" ;

		/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] Start */
		mp_param_form.alt_id2_accept_oth_pat_ser_yn.checked    = false ;
		mp_param_form.alt_id2_accept_alphanumeric_yn.checked   = false ;
		mp_param_form.alt_id2_chng_allowed_yn.checked			= false ;
		/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] End */
		mp_param_form.alt_id2_pat_sch_exact_yn.checked=false;//Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]


        typecheck(2);
    }

    if ( row == 3 ) {
        mp_param_form.alt_id3_chk_digit_scheme.value = "" ;
        mp_param_form.alt_id3_length.value      = "" ;
        mp_param_form.alt_id3_reqd_yn.checked       = false ;
        mp_param_form.alt_id3_unique_yn.checked     = false ;
        mp_param_form.alt_id3_exp_warn_yn.checked   = false ;
        mp_param_form.alt_id3_exp_grace_days.value  = "" ;
        mp_param_form.alt_id3_exp_date_accept_yn.checked = false ;
        mp_param_form.alt_id3_invoke_routine.checked = false ;
        mp_param_form.alt_id3_len_validation_yn.checked = false ;
        mp_param_form.alt_id3_adv_alert_reqd_yn.checked = false ;
        mp_param_form.alt_id3_adv_alert_days.value  = "" ;
        mp_param_form.alt_id3_routine_name.value ="" ;

		/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] Start */
		mp_param_form.alt_id3_accept_oth_pat_ser_yn.checked    = false ;
		mp_param_form.alt_id3_accept_alphanumeric_yn.checked   = false ;
		mp_param_form.alt_id3_chng_allowed_yn.checked			= false ;
		/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] End */
		mp_param_form.alt_id3_pat_sch_exact_yn.checked			= false;//Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]


        typecheck(3);
    }

    if ( row == 4 ) {
        mp_param_form.alt_id4_chk_digit_scheme.value = "" ;
        mp_param_form.alt_id4_length.value      = "" ;
        mp_param_form.alt_id4_reqd_yn.checked       = false ;
        mp_param_form.alt_id4_unique_yn.checked     = false ;
        mp_param_form.alt_id4_exp_warn_yn.checked   = false ;
        mp_param_form.alt_id4_exp_grace_days.value  = "" ;
        mp_param_form.alt_id4_exp_date_accept_yn.checked = false ;
        mp_param_form.alt_id4_invoke_routine.checked = false ;
        mp_param_form.alt_id4_len_validation_yn.checked = false ;
        mp_param_form.alt_id4_adv_alert_reqd_yn.checked = false ;
        mp_param_form.alt_id4_adv_alert_days.value  = "" ;
        mp_param_form.alt_id4_routine_name.value ="" ;

		/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] Start */
		mp_param_form.alt_id4_accept_oth_pat_ser_yn.checked    = false ;
		mp_param_form.alt_id4_accept_alphanumeric_yn.checked   = false ;
		mp_param_form.alt_id4_chng_allowed_yn.checked			= false ;
		/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] End */

		mp_param_form.alt_id4_pat_sch_exact_yn.checked			= false ;//Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]

        typecheck(4);
    }
}

function enableAlternateId( row ) {

    if ( row == 1 ) {
        mp_param_form.alt_id1_length.disabled       = false ;
        mp_param_form.alt_id1_reqd_yn.disabled      = false ;
        mp_param_form.alt_id1_unique_yn.disabled    = false ;
//        mp_param_form.alt_id1_exp_warn_yn.disabled  = false ;
  //      mp_param_form.alt_id1_exp_grace_days.disabled   = false ;
		mp_param_form.accept_for_oth_pat_ser.disabled = false;
		mp_param_form.accept_for_oth_pat_ser.value = 'N';
		mp_param_form.accept_alphanumeric.disabled = false;

		/*Added by Dharma on Apr 3rd 2015 against HSA-CRF-0191 [IN:049772] Start*/
		mp_param_form.alt_id1_chng_allowed_yn.disabled		= false ;
		mp_param_form.Accept_oth_alt_id_yn.disabled			= false ;
		/*Added by Dharma on Apr 3rd 2015 against HSA-CRF-0191 [IN:049772] End*/
		mp_param_form.alt_id1_pat_sch_exact_yn.disabled=false;//Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]
    }

    if ( row == 2 ) {
        mp_param_form.alt_id2_length.disabled       = false ;
        mp_param_form.alt_id2_reqd_yn.disabled      = false ;
        mp_param_form.alt_id2_unique_yn.disabled    = false ;

		/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] Start */
        mp_param_form.alt_id2_accept_oth_pat_ser_yn.disabled    = false ;
		mp_param_form.alt_id2_accept_alphanumeric_yn.disabled   = false ;
		mp_param_form.alt_id2_chng_allowed_yn.disabled			= false ;
		/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] End */
		mp_param_form.alt_id2_pat_sch_exact_yn.disabled= false;//Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]


    //    mp_param_form.alt_id2_exp_warn_yn.disabled  = false ;
      //  mp_param_form.alt_id2_exp_grace_days.disabled   = false ;
    }

    if ( row == 3 ) {
        mp_param_form.alt_id3_length.disabled       = false ;
        mp_param_form.alt_id3_reqd_yn.disabled      = false ;
        mp_param_form.alt_id3_unique_yn.disabled    = false ;
        //mp_param_form.alt_id3_exp_warn_yn.disabled  = false ;
        //mp_param_form.alt_id3_exp_grace_days.disabled   = false ;

		/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] Start */
		mp_param_form.alt_id3_accept_oth_pat_ser_yn.disabled    = false ;
		mp_param_form.alt_id3_accept_alphanumeric_yn.disabled   = false ;
		mp_param_form.alt_id3_chng_allowed_yn.disabled			= false ;
		/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] End */
		mp_param_form.alt_id3_pat_sch_exact_yn.disabled			= false	;//Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]

    }

    if ( row == 4 ) {
        mp_param_form.alt_id4_length.disabled       = false ;
        mp_param_form.alt_id4_reqd_yn.disabled      = false ;
        mp_param_form.alt_id4_unique_yn.disabled    = false ;
        //mp_param_form.alt_id4_exp_warn_yn.disabled  = false ;
        //mp_param_form.alt_id4_exp_grace_days.disabled   = false ;

		/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] Start */
		mp_param_form.alt_id4_accept_oth_pat_ser_yn.disabled    = false ;
        mp_param_form.alt_id4_accept_alphanumeric_yn.disabled   = false ;
        mp_param_form.alt_id4_chng_allowed_yn.disabled			= false ;
		/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] End */
		mp_param_form.alt_id4_pat_sch_exact_yn.disabled			= false ;//Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]
    }
}

function checkAlternateId( row ) {
    if ( operation == "modify" ) {
		if ( row == 1) {
			if ( mp_param_form.d_alt_id1_exp_warn_yn.checked  == true ) {
				mp_param_form.alt_id1_exp_grace_days.disabled   = false ;
			} else {
				mp_param_form.alt_id1_exp_grace_days.disabled   = true ;
				mp_param_form.alt_id1_exp_grace_days.value  = "" ;
			}
		}

		if ( row == 2) {
			if ( mp_param_form.d_alt_id2_exp_warn_yn.checked  == true ) {
				mp_param_form.alt_id2_exp_grace_days.disabled   = false ;
			} else {
				mp_param_form.alt_id2_exp_grace_days.disabled   = true ;
				mp_param_form.alt_id2_exp_grace_days.value  = "" ;

			}
		}

		if ( row == 3) {
			if ( mp_param_form.d_alt_id3_exp_warn_yn.checked  == true ) {				
				mp_param_form.alt_id3_exp_grace_days.disabled   = false ;
			} else {
				mp_param_form.alt_id3_exp_grace_days.disabled   = true ;
				mp_param_form.alt_id3_exp_grace_days.value  = "" ;

			}
		}

		if ( row == 4) {
			if ( mp_param_form.d_alt_id4_exp_warn_yn.checked  == true ) {
				mp_param_form.alt_id4_exp_grace_days.disabled   = false ;
			} else {
				mp_param_form.alt_id4_exp_grace_days.disabled   = true ;
				mp_param_form.alt_id4_exp_grace_days.value  = "" ;

			}
		}		
        return ;
    }

    if ( mp_param_form.alt_id1_type.value == '' ) {
        mp_param_form.alt_id2_type.disabled = true ;
        mp_param_form.alt_id2_type.value = '' ;
		mp_param_form.accept_for_oth_pat_ser.disabled = true;
		mp_param_form.accept_alphanumeric.disabled = true;
		/*Added by Dharma on Apr 3rd 2015 against HSA-CRF-0191 [IN:049772] Start*/
		mp_param_form.alt_id1_chng_allowed_yn.disabled		= true ;
		mp_param_form.Accept_oth_alt_id_yn.disabled			= true ;
		/*Added by Dharma on Apr 3rd 2015 against HSA-CRF-0191 [IN:049772] End*/

		/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] Start */
		mp_param_form.alt_id1_pat_sch_exact_yn.disabled=true;//Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]
	

		mp_param_form.alt_id2_accept_oth_pat_ser_yn.disabled    = true ;
		mp_param_form.alt_id2_accept_alphanumeric_yn.disabled   = true ;
		mp_param_form.alt_id2_chng_allowed_yn.disabled			= true ;

		mp_param_form.alt_id2_pat_sch_exact_yn.disabled			= true ;//Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]

		mp_param_form.alt_id3_accept_oth_pat_ser_yn.disabled    = true ;
		mp_param_form.alt_id3_accept_alphanumeric_yn.disabled   = true ;
		mp_param_form.alt_id3_chng_allowed_yn.disabled			= true ;

		mp_param_form.alt_id3_pat_sch_exact_yn.disabled			= true ;//Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]

		mp_param_form.alt_id4_accept_oth_pat_ser_yn.disabled    = true ;
		mp_param_form.alt_id4_accept_alphanumeric_yn.disabled   = true ;
		mp_param_form.alt_id4_chng_allowed_yn.disabled			= true ;
		/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] End */
		mp_param_form.alt_id4_pat_sch_exact_yn.disabled			= true ;//Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280] 



	    disableAlternateId( 2 ) ;

    } else {
        mp_param_form.alt_id2_type.disabled = false ;
    }

    if ( mp_param_form.alt_id2_type.value == '' ) {
        mp_param_form.alt_id3_type.disabled = true ;
        mp_param_form.alt_id3_type.value = '' ;

		/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] Start */
		mp_param_form.alt_id2_accept_oth_pat_ser_yn.disabled    = true ;
		mp_param_form.alt_id2_accept_alphanumeric_yn.disabled   = true ;
		mp_param_form.alt_id2_chng_allowed_yn.disabled			= true ;

		mp_param_form.alt_id2_pat_sch_exact_yn.disabled			= true ;//Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]

		mp_param_form.alt_id3_accept_oth_pat_ser_yn.disabled    = true ;
		mp_param_form.alt_id3_accept_alphanumeric_yn.disabled   = true ;
		mp_param_form.alt_id3_chng_allowed_yn.disabled			= true ;

		mp_param_form.alt_id3_pat_sch_exact_yn.disabled			= true ;//Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]

		mp_param_form.alt_id4_accept_oth_pat_ser_yn.disabled    = true ;
		mp_param_form.alt_id4_accept_alphanumeric_yn.disabled   = true ;
		mp_param_form.alt_id4_chng_allowed_yn.disabled			= true ;
		/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] End */

		mp_param_form.alt_id4_pat_sch_exact_yn.disabled			= true ;//Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]

        disableAlternateId( 3 ) ;
    } else {
        mp_param_form.alt_id3_type.disabled = false ;
    }

    if ( mp_param_form.alt_id3_type.value == '' ) {
        mp_param_form.alt_id4_type.disabled = true ;
        mp_param_form.alt_id4_type.value = '' ;

		/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] Start */
		mp_param_form.alt_id3_accept_oth_pat_ser_yn.disabled    = true ;
		mp_param_form.alt_id3_accept_alphanumeric_yn.disabled   = true ;
		mp_param_form.alt_id3_chng_allowed_yn.disabled			= true ;

		mp_param_form.alt_id3_pat_sch_exact_yn.disabled			= true ;//Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]

		mp_param_form.alt_id4_accept_oth_pat_ser_yn.disabled    = true ;
		mp_param_form.alt_id4_accept_alphanumeric_yn.disabled   = true ;
		mp_param_form.alt_id4_chng_allowed_yn.disabled			= true ;
		/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] End */
		mp_param_form.alt_id4_pat_sch_exact_yn.disabled			= true ;//Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]

        disableAlternateId( 4 ) ;
    } else {
        mp_param_form.alt_id4_type.disabled = false ;
    }

	/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] Start */
	if ( mp_param_form.alt_id4_type.value == '' ) {
		mp_param_form.alt_id4_accept_oth_pat_ser_yn.disabled    = true ;
		mp_param_form.alt_id4_accept_alphanumeric_yn.disabled   = true ;
		mp_param_form.alt_id4_chng_allowed_yn.disabled			= true ;

		mp_param_form.alt_id4_pat_sch_exact_yn.disabled			= true ;//Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]
	}
	/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] Start */


    if ( row == 1 || row == 0 ) {
        if ( mp_param_form.alt_id1_type.value == '' ) {
            disableAlternateId( 1 ) ;
        } else {
            enableAlternateId( 1 ) ;
        }
    }

    if ( row == 2 || row == 0 ) {
        if ( mp_param_form.alt_id2_type.value == '' ) {
            disableAlternateId( 2 ) ;
        } else {
            enableAlternateId( 2 ) ;
        }
    }

    if ( row == 3 || row == 0 ) {
        if ( mp_param_form.alt_id3_type.value == ''  ) {
            disableAlternateId( 3 ) ;
        } else {
            enableAlternateId( 3 ) ;
        }
    }

    if ( row == 4 || row == 0 ) {
        if ( mp_param_form.alt_id4_type.value == ''  ) {
            disableAlternateId( 4 ) ;
        } else {
            enableAlternateId( 4 ) ;
        }
    }

    if ( row == 1 || row == 0 ) {
        if ( mp_param_form.alt_id1_exp_warn_yn.checked  == true ) {
            mp_param_form.alt_id1_exp_grace_days.disabled   = false ;
        } else {
            mp_param_form.alt_id1_exp_grace_days.disabled   = true ;
            mp_param_form.alt_id1_exp_grace_days.value  = "" ;

        }
    }

    if ( row == 2 || row == 0 ) {
        if ( mp_param_form.alt_id2_exp_warn_yn.checked  == true ) {
            mp_param_form.alt_id2_exp_grace_days.disabled   = false ;
        } else {
            mp_param_form.alt_id2_exp_grace_days.disabled   = true ;
            mp_param_form.alt_id2_exp_grace_days.value  = "" ;

        }
    }

    if ( row == 3 || row == 0 ) {
        if ( mp_param_form.alt_id3_exp_warn_yn.checked  == true ) {
            mp_param_form.alt_id3_exp_grace_days.disabled   = false ;
        } else {
            mp_param_form.alt_id3_exp_grace_days.disabled   = true ;
            mp_param_form.alt_id3_exp_grace_days.value  = "" ;

        }
    }

    if ( row == 4 || row == 0 ) {
        if ( mp_param_form.alt_id4_exp_warn_yn.checked  == true ) {
            mp_param_form.alt_id4_exp_grace_days.disabled   = false ;
        } else {
            mp_param_form.alt_id4_exp_grace_days.disabled   = true ;
            mp_param_form.alt_id4_exp_grace_days.value  = "" ;

        }
    }
}

function checkAlternateIdLength( row ) {

    var error   = getMessage("ALT_ID_LEN_5_20","MP")+ "<br>";

    if ( row == 1 || row == 0 ) {
        if ( mp_param_form.alt_id1_length.value.length != 0 ) {
            if ( mp_param_form.alt_id1_length.value != 0 ) {
                if (    ( mp_param_form.alt_id1_length.value < 5 ) ||
                    ( mp_param_form.alt_id1_length.value > 20 ) ) {
                    alert( error ) ;
                    mp_param_form.alt_id1_length.focus() ;
                    return false ;
                }
            }
        }
    }

    if ( row == 2 || row == 0 ) {
        if ( mp_param_form.alt_id2_length.value.length != 0 ) {
            if ( mp_param_form.alt_id2_length.value != 0 ) {
                if (    ( mp_param_form.alt_id2_length.value < 5 ) ||
                    ( mp_param_form.alt_id2_length.value > 20 ) ) {
                    alert( error ) ;
                    mp_param_form.alt_id2_length.focus() ;
                    return false ;
                }
            }
        }
    }

    if ( row == 3 || row == 0 ) {
        if ( mp_param_form.alt_id3_length.value.length != 0 ) {
            if ( mp_param_form.alt_id3_length.value != 0 ) {
                if (    ( mp_param_form.alt_id3_length.value < 5 ) ||
                    ( mp_param_form.alt_id3_length.value > 20 ) ) {
                    alert( error ) ;
                    mp_param_form.alt_id3_length.focus() ;
                    return false ;
                }
            }
        }
    }

    if ( row == 4 || row == 0 ) {
        if ( mp_param_form.alt_id4_length.value.length != 0 ) {
            if ( mp_param_form.alt_id4_length.value != 0 ) {
                if (    ( mp_param_form.alt_id4_length.value < 5 ) ||
                    ( mp_param_form.alt_id4_length.value > 20 ) ) {
                    alert( error ) ;
                    mp_param_form.alt_id4_length.focus() ;
                    return false ;
                }
            }
        }
    }
}

function checkAlternateIdDuplicates() {
    var result = true ;
    var array1 = new Array(
                f_query_add_mod.document.mp_param_form.alt_id1_type.value,
                f_query_add_mod.document.mp_param_form.alt_id2_type.value,
                f_query_add_mod.document.mp_param_form.alt_id3_type.value,
                f_query_add_mod.document.mp_param_form.alt_id4_type.value
            ) ;
    var array2 = new Array(
                f_query_add_mod.document.mp_param_form.alt_id1_type.value,
                f_query_add_mod.document.mp_param_form.alt_id2_type.value,
                f_query_add_mod.document.mp_param_form.alt_id3_type.value,
                f_query_add_mod.document.mp_param_form.alt_id4_type.value
            ) ;

    if ( result ) {
        for( var i=0; i<array1.length; i++ ) {
            for( var j=0; j<array2.length; j++ ) {
                if ( array1[i] != "" ) {
                    if ( i != j ) {
                        if ( array1[i] == array2[j] ) result = false ;
                    }
                }
            }
        }

        if ( !result )
            errors = errors + getMessage("DUP_ALT_ID1","MP")+ "<br>";
    }
    return result ;
}

function setLocLang()
{
    if (document.mp_param_form.name_in_oth_lang_yn.checked==true)
    {	
		document.mp_param_form.myimage.style.visibility='visible';
		document.mp_param_form.for_loc_lang.disabled=false;
		document.mp_param_form.dflt_patient_name.disabled=false;
		document.mp_param_form.dflt_patient_name_mand.style.visibility='visible';
		document.mp_param_form.for_loc_lang.value = document.mp_param_form.name_dervn_logic.value;
		document.mp_param_form.long_name_dervn_logic_local.disabled = false;
		document.mp_param_form.long_name_dervn_logic_local.value = document.mp_param_form.name_dervn_logic.value;
		document.mp_param_form.name_in_oth_lang_yn.focus();
		if (document.mp_param_form.operation.value=="insert")
		{
			if (document.mp_param_form.name_prefix_accept_yn.checked)
				document.mp_param_form.name_prefix_loc_lang_prompt.disabled = false;
			if (document.mp_param_form.first_name_accept_yn.checked)
				document.mp_param_form.first_name_loc_lang_prompt.disabled = false;
			if (document.mp_param_form.second_name_accept_yn.checked)
				document.mp_param_form.second_name_loc_lang_prompt.disabled = false;
			if (document.mp_param_form.third_name_accept_yn.checked)
				document.mp_param_form.third_name_loc_lang_prompt.disabled = false;
			if (document.mp_param_form.family_name_accept_yn.checked)
				document.mp_param_form.family_name_loc_lang_prompt.disabled = false;
			if (document.mp_param_form.name_suffix_accept_yn.checked)
				document.mp_param_form.name_suffix_loc_lang_prompt.disabled = false;
		}
		else
		{
			
			document.mp_param_form.name_prefix_loc_lang_prompt.disabled = false;
			document.mp_param_form.first_name_loc_lang_prompt.disabled = false;
			document.mp_param_form.second_name_loc_lang_prompt.disabled = false;
			document.mp_param_form.third_name_loc_lang_prompt.disabled = false;
			document.mp_param_form.family_name_loc_lang_prompt.disabled = false;
			document.mp_param_form.name_suffix_loc_lang_prompt.disabled = false;
		}
    }
    else
    {
		document.mp_param_form.myimage.style.visibility='hidden';
		document.mp_param_form.name_in_oth_lang_yn.focus();
		document.mp_param_form.dflt_patient_name_mand.style.visibility= 'hidden';
		document.mp_param_form.for_loc_lang.disabled=true;
		document.mp_param_form.for_loc_lang.value = "";
		document.mp_param_form.dflt_patient_name.disabled=true;
		document.mp_param_form.dflt_patient_name.value="";
        document.mp_param_form.name_prefix_loc_lang_prompt.value = "";
        document.mp_param_form.first_name_loc_lang_prompt.value = "";
        document.mp_param_form.second_name_loc_lang_prompt.value = "";
        document.mp_param_form.third_name_loc_lang_prompt.value = "";
        document.mp_param_form.family_name_loc_lang_prompt.value = "";
        document.mp_param_form.name_suffix_loc_lang_prompt.value = "";
		document.mp_param_form.long_name_dervn_logic_local.disabled=true;
		document.mp_param_form.long_name_dervn_logic_local.value = "";
		

        document.mp_param_form.name_prefix_loc_lang_prompt.disabled = true;
        document.mp_param_form.first_name_loc_lang_prompt.disabled = true;
        document.mp_param_form.second_name_loc_lang_prompt.disabled = true;
        document.mp_param_form.third_name_loc_lang_prompt.disabled = true;
        document.mp_param_form.family_name_loc_lang_prompt.disabled = true;
        document.mp_param_form.name_suffix_loc_lang_prompt.disabled = true; //changed to true by Dheeraj
    }
}

function enableNatFields(obj,calling)
{
//	alert("1");
	var frm ;
	if (calling=='N') 
	{
		frm = f_query_add_mod.document.mp_param_form;
		frm1 = f_query_add_mod.document.all;
	}
	else
	{
		frm = document.mp_param_form;
		frm1 = document.all;
	}

	if (obj.checked==false) 
		{
		if (frm.operation.value == "insert")
		{
			frm.nat_prompt.value = "";
			frm.nat_id_accept_alphanumeric_yn.checked= false;
			frm.nat_id_accept_alphanumeric_yn.value = "N";
			frm.nat_reqd_for_all_ser.checked= false;
			frm.nat_reqd_for_all_ser.value = "N";
			frm.nat_id_length.value = "";
			frm.chk_len.checked = false;
			frm.nat_chk_dig_scheme.value = "";			
			frm.nat_chk_dig_scheme.disabled = true;
			frm.nat_invoke_routine.value = "";
			frm.nat_invoke_routine.checked = false;
			frm.nat_id_routine_name.value = "";
			frm.nat_id_routine_name.disabled = true;
			frm.id_change_allowed_for_series.value = "";			
		}		
		//frm.ext_system_interface_yn.value = "";			
		frm.ext_system_interface_yn.disabled = true;
		frm.nat_prompt.disabled = true;
		frm.nat_reqd_for_all_ser.disabled=true;
		frm.nat_id_length.disabled = true;
		frm.chk_len.disabled = true;					       
		frm1.nat_gif.style.visibility='hidden'
		frm.nat_invoke_routine.disabled = true;          		
		frm.id_change_allowed_for_series.disabled = true;
		frm.nat_id_accept_alphanumeric_yn.disabled=true;
	}
	else
	{					
		frm.nat_prompt.disabled = false;	
		frm.nat_reqd_for_all_ser.disabled=false;
		frm1.nat_gif.style.visibility='visible'
		frm.ext_system_interface_yn.disabled = false;
		if (frm.operation.value == "insert")
		{			
			frm.nat_id_length.disabled = false;
			frm.chk_len.disabled = false;					       
			frm.nat_chk_dig_scheme.disabled = false;          
			frm.nat_invoke_routine.disabled = false;
			frm.nat_invoke_routine.value = "Y";
			frm.nat_reqd_for_all_ser.value = "Y";
			//frm.nat_id_accept_alphanumeric_yn.value = "Y";
			frm.nat_id_accept_alphanumeric_yn.disabled = false;
		}
		//document.mp_param_form.nat_id_routine_name.disabled = true;         
		if(frm.ext_system_interface_yn.checked == false)
			frm.id_change_allowed_for_series.disabled = false;
	}
}

function SplCharsChkForNameDrvn(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ< >+,';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}

function SplCharChkApply(obj)
{
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ< >+,';
	var str = obj.value;
	for (i=0;i<str.length;i++){
		if (strCheck.indexOf(str.substring(i,i+1)) == -1) return false;
	}
	return true;
}

function checkMinMax()
{
	result = true;
	var str = "";
	if ((f_query_add_mod.document.mp_param_form.min_weight.value != '') && (f_query_add_mod.document.mp_param_form.max_weight.value != ''))
	{
		if (parseFloat(f_query_add_mod.document.mp_param_form.min_weight.value) >= parseFloat(f_query_add_mod.document.mp_param_form.max_weight.value))
		{
			str = getMessage("WEIGHT_RANGE_CHK","MP") + "<br>";			
            result = false;
		}
	}
	if ((f_query_add_mod.document.mp_param_form.min_length.value != '') && (f_query_add_mod.document.mp_param_form.max_length.value != ''))
	{
		if (parseFloat(f_query_add_mod.document.mp_param_form.min_length.value) >= parseFloat(f_query_add_mod.document.mp_param_form.max_length.value))
		{
			str += getMessage("LENGTH_RANGE_CHK","MP")  + "<br>";			
            result = false;
		}
	}
	if ((f_query_add_mod.document.mp_param_form.min_head_circum.value != '') && (f_query_add_mod.document.mp_param_form.max_head_circum.value != ''))
	{		
		if (parseFloat(f_query_add_mod.document.mp_param_form.min_head_circum.value) >= parseFloat(f_query_add_mod.document.mp_param_form.max_head_circum.value))
		{
			str += getMessage("HEAD_CIRCUM_RANGE_CHK","MP")  + "<br>";
            result = false;
		}
	}
	if ((f_query_add_mod.document.mp_param_form.min_chest_circum.value != '') && (f_query_add_mod.document.mp_param_form.max_chest_circum.value != ''))
	{
		if (parseFloat(f_query_add_mod.document.mp_param_form.min_chest_circum.value) >= parseFloat(f_query_add_mod.document.mp_param_form.max_chest_circum.value))
		{
			str += getMessage("CHEST_CIRCUM_RANGE_CHK","MP") + "<br>";
            result = false;
		}
	}
	if ((f_query_add_mod.document.mp_param_form.min_gestation.value != '') && (f_query_add_mod.document.mp_param_form.max_gestation.value != ''))
	{
		if (parseFloat(f_query_add_mod.document.mp_param_form.min_gestation.value) >= parseFloat(f_query_add_mod.document.mp_param_form.max_gestation.value))
		{
			str += getMessage("GESTATION_RANGE_CHK","MP") + "<br>";
            result = false;

		}
	}

	if (str!='')
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + str ;
				

}

function checkDecimal(obj)
{ 
	if (obj.value != '')
	{
		if (isNaN(obj.value) == false && obj.value >= 0)
		{
			if (obj.value.indexOf('.') != -1)
			{
				alert(getMessage("INVALID_INTEGER","MP"));
				obj.select();
				obj.focus();
			}		
		}
	}
}

function checkTerminalDigitLength()
{
	var str = "";
	if (f_query_add_mod.document.mp_param_form.terminal_digit1_position.value != '')
	{
		if (parseInt(f_query_add_mod.document.mp_param_form.terminal_digit1_position.value) > parseInt(f_query_add_mod.document.mp_param_form.patient_id_length.value))
		{
			str = getMessage("PATID_GREATER","MP","MP") + "<br>";			
            result = false;
		}
	}
	if (result)
	{
		if (f_query_add_mod.document.mp_param_form.terminal_digit2_position.value != '')
		{
			if (parseInt(f_query_add_mod.document.mp_param_form.terminal_digit2_position.value) > parseInt(f_query_add_mod.document.mp_param_form.patient_id_length.value))
			{
				str = getMessage("PATID_GREATER","MP") + "<br>";			
				result = false;
			}
		}
	}
	if (result)
	{
		if (f_query_add_mod.document.mp_param_form.terminal_digit3_position.value != '')
		{
			if (parseInt(f_query_add_mod.document.mp_param_form.terminal_digit3_position.value) > parseInt(f_query_add_mod.document.mp_param_form.patient_id_length.value))
			{
				str = getMessage("PATID_GREATER","MP") + "<br>";			
				result = false;
			}
		}
	}
	if (result)
	{
		if (f_query_add_mod.document.mp_param_form.terminal_digit4_position.value != '')
		{
			if (parseInt(f_query_add_mod.document.mp_param_form.terminal_digit4_position.value) > parseInt(f_query_add_mod.document.mp_param_form.patient_id_length.value))
			{
				str = getMessage("PATID_GREATER","MP") + "<br>";			
				result = false;
			}
		}
	}
	if (result)
	{
		if (f_query_add_mod.document.mp_param_form.terminal_digit5_position.value != '')
		{
			if (parseInt(f_query_add_mod.document.mp_param_form.terminal_digit5_position.value) > parseInt(f_query_add_mod.document.mp_param_form.patient_id_length.value))
			{
				str = getMessage("PATID_GREATER","MP") + "<br>";			
				result = false;
			}
		}
	}
	if (str!='')
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + str ;
}
//The following function enables-disables the MR Administration fields depending on the MR Administration By list box value
function enableMRAdmin(obj)
{
	var operation = document.forms[0].operation.value;	
	if(operation=="insert")
	{
	if(obj.value=='F')//If File is selected
	{
	if(document.mp_param_form.single_or_multi_files_ind[0])
		document.mp_param_form.single_or_multi_files_ind[0].disabled=false;
	if(document.mp_param_form.single_or_multi_files_ind[1])
		document.mp_param_form.single_or_multi_files_ind[1].disabled=false;
	if(document.mp_param_form.separate_file_no_yn)
		{document.mp_param_form.separate_file_no_yn[0].disabled=false;
		document.mp_param_form.separate_file_no_yn[1].disabled=false;}

	if(document.mp_param_form.create_file_at_pat_regn_yn)
		document.mp_param_form.create_file_at_pat_regn_yn.disabled=false;
	if(document.mp_param_form.create_file_at_admission)
		document.mp_param_form.create_file_at_admission.disabled=false;
	if(document.mp_param_form.create_file_at_reg_visit_yn)
		document.mp_param_form.create_file_at_reg_visit_yn.disabled=false;
	if(document.mp_param_form.create_file_at_reg_att_yn)
		document.mp_param_form.create_file_at_reg_att_yn.disabled=false;
	if(document.mp_param_form.create_file_at_dc_admission_yn)
		document.mp_param_form.create_file_at_dc_admission_yn.disabled=false;
	}
	else if(obj.value=='D')//IF document is selected
	{
	if(document.mp_param_form.single_or_multi_files_ind[0])
		document.mp_param_form.single_or_multi_files_ind[0].disabled=true;
	if(document.mp_param_form.single_or_multi_files_ind[1])
		document.mp_param_form.single_or_multi_files_ind[1].disabled=true;
	if(document.mp_param_form.single_or_multi_files_ind)		
		document.mp_param_form.single_or_multi_files_ind.value="S";
	if(document.mp_param_form.separate_file_no_yn[0])
		 document.mp_param_form.separate_file_no_yn[0].disabled=true;
	if(document.mp_param_form.separate_file_no_yn[1])
		 document.mp_param_form.separate_file_no_yn[1].disabled=true;
	if(document.mp_param_form.separate_file_no_yn)		
		document.mp_param_form.separate_file_no_yn.value="N";	

	if(document.mp_param_form.create_file_at_pat_regn_yn)
		{document.mp_param_form.create_file_at_pat_regn_yn.checked=false;
		document.mp_param_form.create_file_at_pat_regn_yn.disabled=true;
		document.mp_param_form.create_file_at_pat_regn_yn.value="N";}
	if(document.mp_param_form.create_file_at_admission)
		{ document.mp_param_form.create_file_at_admission.checked=false;
		document.mp_param_form.create_file_at_admission.disabled=true;
		document.mp_param_form.create_file_at_admission.value="N";}
	if(document.mp_param_form.create_file_at_reg_visit_yn)
		{document.mp_param_form.create_file_at_reg_visit_yn.checked=false;
	document.mp_param_form.create_file_at_reg_visit_yn.disabled=true;
		document.mp_param_form.create_file_at_reg_visit_yn.value="N";}
	if(document.mp_param_form.create_file_at_reg_att_yn)
		{document.mp_param_form.create_file_at_reg_att_yn.checked=false; 
		document.mp_param_form.create_file_at_reg_att_yn.disabled=true;
		document.mp_param_form.create_file_at_reg_att_yn.value="N";}
		if(document.mp_param_form.create_file_at_dc_admission_yn)
		{document.mp_param_form.create_file_at_dc_admission_yn.checked=false; 
		document.mp_param_form.create_file_at_dc_admission_yn.disabled=true;
		document.mp_param_form.create_file_at_dc_admission_yn.value="N";}
	}
	}
}
function uomcheck(Obj)
{
	if(Obj.value=='K')
		document.getElementById('h_unit_of_wt_nb').value='K';
	else if(Obj.value=='L')
		document.getElementById('h_unit_of_wt_nb').value='L';	
    else if((Obj.value=='C') && (Obj.name=="unit_of_circum_nb"))
		document.getElementById('h_unit_of_circum_nb').value='C';
	else if((Obj.value=='I') && (Obj.name=="unit_of_circum_nb"))
		document.getElementById('h_unit_of_circum_nb').value='I';
	else if((Obj.value=='C') && (Obj.name=="unit_of_chest_circum_nb"))
		document.getElementById('h_unit_of_chest_circum_nb').value='C';
	else if((Obj.value=='I') && (Obj.name=="unit_of_chest_circum_nb"))
		document.getElementById('h_unit_of_chest_circum_nb').value='I';
    else if((Obj.value=='C') && (Obj.name=="unit_of_length_nb"))
		document.getElementById('h_unit_of_length_nb').value='C';
	else if((Obj.value=='I') && (Obj.name=="unit_of_length_nb"))
		document.getElementById('h_unit_of_length_nb').value='I';
    else if(Obj.value=='W')
		document.getElementById('h_unit_of_gest_nb').value='W';
    else if(Obj.value=='D')
		document.getElementById('h_unit_of_gest_nb').value='D';

}
function GeneralClick()
{
	if(document.forms[0].create_file_at_pat_regn_yn.checked==true)
	  document.forms[0].create_file_at_pat_regn_yn.value="Y";
    else
		document.forms[0].create_file_at_pat_regn_yn.value="N";
	
	if(document.forms[0].create_file_at_admission.checked==true)
		  document.forms[0].create_file_at_admission.value="Y";
	else
		document.forms[0].create_file_at_admission.value="N";
	
	if(document.forms[0].create_file_at_reg_visit_yn.checked==true)
		  document.forms[0].create_file_at_reg_visit_yn.value="Y";
	else
		document.forms[0].create_file_at_reg_visit_yn.value="N";

	if(document.forms[0].create_file_at_reg_att_yn.checked==true)
		  document.forms[0].create_file_at_reg_att_yn.value="Y";
	else
		document.forms[0].create_file_at_reg_att_yn.value="N";
	if(document.forms[0].create_file_at_dc_admission_yn.checked==true)
		  document.forms[0].create_file_at_dc_admission_yn.value="Y";
	else
		document.forms[0].create_file_at_dc_admission_yn.value="N";

	/*if(document.forms[0].alt_id1_rule_in_gen_pat_id_yn.checked==true){
// some chnages
	document.forms[0].alt_id1_rule_in_gen_pat_id_yn.value="Y";
	}
    else
		document.forms[0].alt_id1_rule_in_gen_pat_id_yn.value="N";*/
}
function Slnochk()
{
	if(document.forms[0].slno_yn.checked==true)
		document.forms[0].slno_yn.value = "Y";
	else
		document.forms[0].slno_yn.value = "N";
}
function roundOffChk(obj){
	if(obj.checked==true)
		obj.value = "Y";
	else
		obj.value = "N";
}

function chkSetValue( chkbox ){

if(chkbox.checked == true)
    {
    chkbox.value =  "Y";
    
    }else
    {
    
    chkbox.value  = "N";
    }
                               }
function chkRoutine (src_obj,dest_obj)
{
    if(src_obj.checked)
	{
       // dest_obj.value = "Y";
		dest_obj.disabled = false;
	}
    else
    {
        dest_obj.options(0).selected = true;
        dest_obj.disabled = true;
    }
}

function chkCheckExpiry1(obj){
    if (obj.checked == true ){
        document.mp_param_form.alt_id1_exp_warn_yn.disabled = false;
        document.mp_param_form.alt_id1_adv_alert_reqd_yn.disabled = false;
    } else
    {
        document.mp_param_form.alt_id1_exp_warn_yn.checked = false;
        document.mp_param_form.alt_id1_adv_alert_reqd_yn.checked = false;
        document.mp_param_form.alt_id1_exp_grace_days.value = "";
        document.mp_param_form.alt_id1_adv_alert_days.value = "";
        
        document.mp_param_form.alt_id1_exp_warn_yn.disabled = true;
        document.mp_param_form.alt_id1_adv_alert_reqd_yn.disabled = true;
        document.mp_param_form.alt_id1_exp_grace_days.disabled = true;
        document.mp_param_form.alt_id1_adv_alert_days.disabled = true;

    }
                            
}


function valid_dat(Obj){ 
	var temp=0;
	if(Obj.value!=""){
		if ((Obj.value=="0")||(Obj.value=="00")){ 
			alert(getMessage("INVALID_POSITIVE_NUMBER","Common"));
			Obj.focus();			
		}else{
			if((Obj.name == "max_age_of_moth") && document.mp_param_form.min_age_of_moth.value>0){							
				validate_max();						
			}
			/*if(Obj.name == "cut_age_of_moth") {
				if(document.mp_param_form.min_age_of_moth.value>0 && document.mp_param_form.max_age_of_moth.value>0)	{					
					validate_min_cut();				
				}
			}*/
			
		}
	}

}
function validate_min_cut(){	
	var min = frames[1].document.forms[0].min_age_of_moth.value;		
	var cutoff = frames[1].document.forms[0].cut_age_of_moth.value;		
	
	if(min!="" && cutoff!=""){
		if(parseInt(cutoff) > parseInt(min)){						
			//alert(getMessage("CUTOFF_AGE_LE_MIN_AGE","MP"));
			//frames[1].document.forms[0].cut_age_of_moth.focus();
			var str=getMessage("CUTOFF_AGE_LE_MIN_AGE","MP");
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + str ;			
			return false;
		}	
		else
			return true;
	}
	
		
}

function validate_max(){
	
	var min = document.mp_param_form.min_age_of_moth.value;	
	var max = document.mp_param_form.max_age_of_moth.value;	
	var cutoff = document.mp_param_form.cut_age_of_moth.value;		
	
	if(min!="" && max!=""){
		if(parseInt(min) > parseInt(max)){						
			alert(getMessage("MIN_GRT_TO_MAX","MP"));
			document.mp_param_form.max_age_of_moth.focus();							
		}
		/*else{
		
			if(cutoff !=""){
				if(parseInt(cutoff) > parseInt(max)){
					alert(getMessage("CUT_GRT_TO_MAX","MP"));
					document.mp_param_form.cut_age_of_moth.focus();					
				}
			
				if(parseInt(cutoff) < parseInt(min) ){
					alert(getMessage("CUT_LESS_TO_MIN","MP"));
					document.mp_param_form.cut_age_of_moth.focus();					
				}
			}
		}*/
	}
		
}
function chkCheckExpiry2(obj){
    if (obj.checked == true ){
        document.mp_param_form.alt_id2_exp_warn_yn.disabled = false;
        document.mp_param_form.alt_id2_adv_alert_reqd_yn.disabled = false;
    } else
    {
        document.mp_param_form.alt_id2_exp_warn_yn.checked = false;
        document.mp_param_form.alt_id2_adv_alert_reqd_yn.checked = false;
        document.mp_param_form.alt_id2_exp_grace_days.value = "";
        document.mp_param_form.alt_id2_adv_alert_days.value = "";

        document.mp_param_form.alt_id2_exp_warn_yn.disabled = true;
        document.mp_param_form.alt_id2_adv_alert_reqd_yn.disabled = true;
        document.mp_param_form.alt_id2_exp_grace_days.disabled = true;
        document.mp_param_form.alt_id2_adv_alert_days.disabled = true;

    }
                            
}



	
function chkCheckExpiry3(obj){
    if (obj.checked == true ){
        document.mp_param_form.alt_id3_exp_warn_yn.disabled = false;
        document.mp_param_form.alt_id3_adv_alert_reqd_yn.disabled = false;
    } else
    {
        document.mp_param_form.alt_id3_exp_warn_yn.checked = false;
        document.mp_param_form.alt_id3_adv_alert_reqd_yn.checked = false;
        document.mp_param_form.alt_id3_exp_grace_days.value = "";
        document.mp_param_form.alt_id3_adv_alert_days.value = "";

        document.mp_param_form.alt_id3_exp_warn_yn.disabled = true;
        document.mp_param_form.alt_id3_adv_alert_reqd_yn.disabled = true;
        document.mp_param_form.alt_id3_exp_grace_days.disabled = true;
        document.mp_param_form.alt_id3_adv_alert_days.disabled = true;

    }
                            
                                }
function chkCheckExpiry4(obj){
    if (obj.checked == true ){
        document.mp_param_form.alt_id4_exp_warn_yn.disabled = false;
        document.mp_param_form.alt_id4_adv_alert_reqd_yn.disabled = false;
        
    } else
    {
        document.mp_param_form.alt_id4_exp_warn_yn.checked = false;
        document.mp_param_form.alt_id4_adv_alert_reqd_yn.checked = false;
        document.mp_param_form.alt_id4_exp_grace_days.value = "";
        document.mp_param_form.alt_id4_adv_alert_days.value = "";

        document.mp_param_form.alt_id4_exp_warn_yn.disabled = true;
        document.mp_param_form.alt_id4_adv_alert_reqd_yn.disabled = true;
        document.mp_param_form.alt_id4_exp_grace_days.disabled = true;
        document.mp_param_form.alt_id4_adv_alert_days.disabled = true;

    }
                            
 }

function series(obj){
    var n=document.forms[0].id_change_allowed_for_series.options.length;
    
    for(var i=0;i<n;i++)
    {
        document.forms[0].id_change_allowed_for_series.remove("id_change_allowed_for_series");
    }

    if (obj.checked == true)
    {
        var opt=document.createElement("OPTION");
        opt.text    =   "---------"+getLabel("Common.defaultSelect.label","Common")+"---------";
        opt.value   =   "";
        document.mp_param_form.id_change_allowed_for_series.add(opt);
        opt=document.createElement("OPTION");
        opt.text=getLabel('eMP.NationalIDSeries.label','MP');
        opt.value="N";
        document.mp_param_form.id_change_allowed_for_series.add(opt);
        opt=document.createElement("OPTION");
        opt.text=getLabel('eMP.Allseries.label','MP');
        opt.value="A";
        document.mp_param_form.id_change_allowed_for_series.add(opt);
        opt=document.createElement("OPTION");
        opt.text=getLabel('eMP.NewBorn.label','MP');
        opt.value="B";
        document.mp_param_form.id_change_allowed_for_series.add(opt);
    }
    else
    {
        var opt=document.createElement("OPTION");
        opt.text    =   "---------"+getLabel("Common.defaultSelect.label","Common")+"---------";
        opt.value   =   "";
        document.mp_param_form.id_change_allowed_for_series.add(opt);
        opt=document.createElement("OPTION");
        opt.text=getLabel('eMP.NationalIDSeries.label','MP');
        opt.value="N";
        document.mp_param_form.id_change_allowed_for_series.add(opt);
    }
}
function digits(digits){

    if (digits == "0")
    {
        document.mp_param_form.terminal_digit1_position.value = "";
        document.mp_param_form.terminal_digit2_position.value = "";
        document.mp_param_form.terminal_digit3_position.value = "";
        document.mp_param_form.terminal_digit4_position.value = "";
        document.mp_param_form.terminal_digit5_position.value = "";

        
        document.getElementById('digits').style.visibility = 'hidden';
        document.mp_param_form.terminal_digit1_position.style.visibility = 'hidden';
        document.mp_param_form.img1.style.visibility = 'hidden';
        document.mp_param_form.terminal_digit2_position.style.visibility = 'hidden';
        document.mp_param_form.img2.style.visibility = 'hidden';
        document.mp_param_form.terminal_digit3_position.style.visibility = 'hidden';
        document.mp_param_form.img3.style.visibility = 'hidden';
        document.mp_param_form.terminal_digit4_position.style.visibility = 'hidden';
        document.mp_param_form.img4.style.visibility = 'hidden';
        document.mp_param_form.terminal_digit5_position.style.visibility = 'hidden';
        document.mp_param_form.img5.style.visibility = 'hidden';

    }
    else if (digits == "3")
    {

        document.getElementById('digits').style.visibility = 'visible';
        document.mp_param_form.terminal_digit1_position.style.visibility = 'visible';
        document.mp_param_form.img1.style.visibility = 'visible';
        document.mp_param_form.terminal_digit2_position.style.visibility = 'visible';
        document.mp_param_form.img2.style.visibility = 'visible';
        document.mp_param_form.terminal_digit3_position.style.visibility = 'visible';
        document.mp_param_form.img3.style.visibility = 'visible';
        document.mp_param_form.terminal_digit4_position.style.visibility = 'hidden';
        document.mp_param_form.img4.style.visibility = 'hidden';
        document.mp_param_form.terminal_digit5_position.style.visibility = 'hidden';
        document.mp_param_form.img5.style.visibility = 'hidden';

    
    }
    else if (digits == "4")
    {

        document.getElementById('digits').style.visibility = 'visible';
        document.mp_param_form.terminal_digit1_position.style.visibility = 'visible';
        document.mp_param_form.img1.style.visibility = 'visible';
        document.mp_param_form.terminal_digit2_position.style.visibility = 'visible';
        document.mp_param_form.img2.style.visibility = 'visible';
        document.mp_param_form.terminal_digit3_position.style.visibility = 'visible';
        document.mp_param_form.img3.style.visibility = 'visible';
        document.mp_param_form.terminal_digit4_position.style.visibility = 'visible';
        document.mp_param_form.img4.style.visibility = 'visible';
        document.mp_param_form.terminal_digit5_position.style.visibility = 'hidden';
        document.mp_param_form.img5.style.visibility = 'hidden';

    }
    else if (digits == "5")
    {
    
        document.getElementById('digits').style.visibility = 'visible';
        document.mp_param_form.terminal_digit1_position.style.visibility = 'visible';
        document.mp_param_form.img1.style.visibility = 'visible';
        document.mp_param_form.terminal_digit2_position.style.visibility = 'visible';
        document.mp_param_form.img2.style.visibility = 'visible';
        document.mp_param_form.terminal_digit3_position.style.visibility = 'visible';
        document.mp_param_form.img3.style.visibility = 'visible';
        document.mp_param_form.terminal_digit4_position.style.visibility = 'visible';
        document.mp_param_form.img4.style.visibility = 'visible';
        document.mp_param_form.terminal_digit5_position.style.visibility = 'visible';
        document.mp_param_form.img5.style.visibility = 'visible';

    }

//  parent.messageFrame.location.href = '../../eMP/jsp/paramdigits.jsp?digits='+digits;
}
function lencheck(obj)
{
    var len=obj.value;
    var msg ="";
    if (len=="" || len.indexOf('.')!=-1) return true;
    var patlength = document.mp_param_form.patient_id_length.value; 
    if (trimCheck(patlength)=="")
    {
        msg = getMessage("PATID_LEN","MP")+ "<br>";
        document.mp_param_form.terminal_digit1_position.value = "";
        document.mp_param_form.terminal_digit2_position.value = "";
        document.mp_param_form.terminal_digit3_position.value = "";
        document.mp_param_form.terminal_digit4_position.value = "";
        document.mp_param_form.terminal_digit5_position.value = "";
        obj.focus();
    }
    else
    {
        if (parseInt(len) >parseInt(patlength))
        {
            msg = getMessage("PATID_GREATER","MP")+ "<br>";
            obj.focus();
        }   
    }
    if (msg != "")
    {
        parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + msg ;
    }
}
function enablecheck1()
{
    if (document.mp_param_form.alt_id1_adv_alert_reqd_yn.checked==true)
    {
        document.mp_param_form.alt_id1_adv_alert_days.disabled=false;
    }
    else if (document.mp_param_form.alt_id1_adv_alert_reqd_yn.checked==false)
    {
        document.mp_param_form.alt_id1_adv_alert_days.disabled=true;
        document.mp_param_form.alt_id1_adv_alert_days.value="";
    }
}
function enablecheck2()
{
    if (document.mp_param_form.alt_id2_adv_alert_reqd_yn.checked==true)
    {
        document.mp_param_form.alt_id2_adv_alert_days.disabled=false;
    }
    else if (document.mp_param_form.alt_id2_adv_alert_reqd_yn.checked==false)
    {
        document.mp_param_form.alt_id2_adv_alert_days.disabled=true;
        document.mp_param_form.alt_id2_adv_alert_days.value="";
    }
}
function enablecheck3()
{
    if (document.mp_param_form.alt_id3_adv_alert_reqd_yn.checked==true)
    {
        document.mp_param_form.alt_id3_adv_alert_days.disabled=false;
    }
    else if (document.mp_param_form.alt_id3_adv_alert_reqd_yn.checked==false)
    {
        document.mp_param_form.alt_id3_adv_alert_days.disabled=true;
        document.mp_param_form.alt_id3_adv_alert_days.value="";
    }
}
function enablecheck4()
{
    if (document.mp_param_form.alt_id4_adv_alert_reqd_yn.checked==true)
    {
        document.mp_param_form.alt_id4_adv_alert_days.disabled=false;
    }
    else if (document.mp_param_form.alt_id4_adv_alert_reqd_yn.checked==false)
    {
        document.mp_param_form.alt_id4_adv_alert_days.disabled=true;
        document.mp_param_form.alt_id4_adv_alert_days.value="";
    }
}
function digitenablecheck()
{
    if (document.mp_param_form.terminal_digit_reqd_yn.checked==true)
    {
        document.mp_param_form.terminal_digit_count.disabled=false;
    }
    else if (document.mp_param_form.terminal_digit_reqd_yn.checked==false)
    {
        document.mp_param_form.terminal_digit_count.disabled=true;
        document.mp_param_form.terminal_digit_count.value="0";
        digits("0");
    }
    
}
//Added on 3/31/2005
function assignCountValues(){
///	alert("2");
	document.mp_param_form.dcount.value = dcount;
	document.mp_param_form.ccount.value = ccount;
	document.mp_param_form.fcount.value = fcount;
	document.mp_param_form.ecount.value = ecount;
	document.mp_param_form.ocount.value = ocount;
	document.mp_param_form.ncount.value = ncount;	
}

function checkForMode(objCheck)
{
			
		if(objCheck.checked== true)
		{
			
			objCheck.value='Y'
		}
		else
		{
			objCheck.value='N'
		}
	
}

function maintainOrgMembership(obj)
{
		if (obj.checked==true)
		{
				document.mp_param_form.mapped_alt_id_org_member_id_ins.disabled=false;
			var opt=parent.frames[1].document.createElement('OPTION');
			opt.value='ID1';
			opt.text=getLabel("Common.identification.label","Common")+'1';
			parent.frames[1].document.forms[0].mapped_alt_id_org_member_id_ins.add(opt);
			parent.frames[1].document.forms[0].mapped_alt_id_org_member_id_ins.value='ID1';
			document.mp_param_form.mapped_alt_id_org_member_id_ins.disabled=true;

			if(document.mp_param_form.mapped_alt_id_org_member_id){
			document.mp_param_form.mapped_alt_id_org_member_id.value='ID1';
			document.mp_param_form.mapped_alt_id_org_member_id.disabled=true;
			}
			document.mp_param_form.dflt_alt_id1_in_emp_id_yn.value='Y';
			document.mp_param_form.dflt_alt_id1_in_emp_id_yn.checked=true;
			document.mp_param_form.family_org_id_accept_yn.value='Y';
			document.mp_param_form.family_org_id_accept_yn_new.value='Y';
			var HTMLVal="<html><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eMP/jsp/mp_param_validation.jsp'><input type='hidden' name=callfunction id=callfunction value='populateRelation'></form></body></html>";
			parent.frames[3].document.write(HTMLVal);
			parent.frames[3].document.tempform1.submit();
			document.forms[0].org_member_relationship_code.disabled=false;

			document.forms[0].name_pfx_reqd_for_org_mem_yn.disabled=false;
			document.forms[0].name_pfx_reqd_for_org_mem_yn.checked=false;
			document.forms[0].name_pfx_reqd_for_org_mem_yn.value='N'

			document.forms[0].name_prefix_accept_yn.disabled=false;
			document.forms[0].name_prefix_accept_yn.checked=false;
			document.forms[0].name_prefix_accept_yn.value='N'
			//commenetd
			document.forms[0].name_prefix_reqd_yn.value='N'
			document.forms[0].name_prefix_reqd_yn.checked=false;
			document.forms[0].name_prefix_reqd_yn.disabled=true;

		} 
		else
		{
			var altid_mbr=document.forms[0].mapped_alt_id_org_member_id_ins;
			while(altid_mbr.options.length>1) altid_mbr.options.remove(1);
			document.mp_param_form.org_member_relationship_code.value='';
			document.mp_param_form.org_member_relationship_code.value='';
			document.mp_param_form.family_org_id_accept_yn.value='N';
			document.mp_param_form.family_org_id_accept_yn_new.value='N';
			document.forms[0].org_member_relationship_code.disabled=true;
			document.forms[0].org_member_relationship_code.selectedIndex=0;
			document.forms[0].name_pfx_reqd_for_org_mem_yn.disabled=true;
			document.forms[0].name_pfx_reqd_for_org_mem_yn.checked=false;
			document.forms[0].name_pfx_reqd_for_org_mem_yn.value='N'
			document.forms[0].name_prefix_reqd_yn.value='N'
			document.forms[0].name_prefix_reqd_yn.checked=false;
			document.forms[0].name_prefix_reqd_yn.disabled=true;
			document.forms[0].name_prefix_accept_yn.disabled=false;
			document.forms[0].name_prefix_accept_yn.checked=false;
			document.forms[0].name_prefix_accept_yn.value='N'
			var select = document.forms[0].org_member_relationship_code;
			var length = select.length;
			for(i=0;i<length;i++)
			select.remove(0);
			 var opt=document.createElement("OPTION");
			opt.text    =   "----------"+getLabel("Common.defaultSelect.label","Common")+"----------";
			opt.value   =   "";
			opt.selected	=  true;
			select.add(opt);
		}
}

function check_fmorg_fun(obj){
	if(obj.checked==true){
		document.forms[0].name_pfx_reqd_for_org_mem_yn.value='Y'
		document.forms[0].name_prefix_reqd_yn.value='Y'
		document.forms[0].name_prefix_reqd_yn_new.value='Y'
		document.forms[0].name_prefix_reqd_yn.checked=true;
		document.forms[0].name_prefix_reqd_yn.disabled=true;
	}else{
		document.forms[0].name_pfx_reqd_for_org_mem_yn.value='N'
		document.forms[0].name_prefix_reqd_yn.value='N'
		document.forms[0].name_prefix_reqd_yn_new.value='N'
		document.forms[0].name_prefix_reqd_yn.checked=false;
		document.forms[0].name_prefix_reqd_yn.disabled=false;
	}
	
}

function chkAltID1Unq(obj)
{
	if (obj.checked==true)
		document.mp_param_form.alt_id1_unique_yn.value='Y';				
	else
		document.mp_param_form.alt_id1_unique_yn.value='N';				
}

function validatelength(obj)
{
	var name_prefix_length = trimString(document.mp_param_form.name_prefix_length.value);
	var first_name_length = trimString(document.mp_param_form.first_name_length.value);
	var second_name_length = trimString(document.mp_param_form.second_name_length.value);
	var third_name_length = trimString(document.mp_param_form.third_name_length.value);
	var family_name_length = trimString(document.mp_param_form.family_name_length.value);
	var name_suffix_length = trimString(document.mp_param_form.name_suffix_length.value);

	if(name_prefix_length != "")
	{
		name_prefix_length=parseInt(name_prefix_length);
	}
	else
	{
		name_prefix_length=0;
		name_prefix_length=parseInt(name_prefix_length);
	}

	if(first_name_length != "")
	{
		first_name_length=parseInt(first_name_length);
	}
	else
	{
		first_name_length=0;
		first_name_length=parseInt(first_name_length);
	}

	if(second_name_length != "")
	{
		second_name_length=parseInt(second_name_length);
	}
	else
	{
		second_name_length=0;
		second_name_length=parseInt(second_name_length);
	}

	if(third_name_length != "")
	{
		third_name_length=parseInt(third_name_length);
	}
	else
	{
		third_name_length=0;
		third_name_length=parseInt(third_name_length);
	}

	if(family_name_length != "")
	{
		family_name_length=parseInt(family_name_length);
	}
	else
	{
		family_name_length=0;
		family_name_length=parseInt(family_name_length);
	}

	if(name_suffix_length != "")
	{
		name_suffix_length=parseInt(name_suffix_length);
	}
	else
	{
		name_suffix_length=0;
		name_suffix_length=parseInt(name_suffix_length);
	}
	//alert(name_prefix_length + first_name_length + second_name_length + third_name_length + family_name_length + name_suffix_length);

	/*if((name_prefix_length + first_name_length + second_name_length + third_name_length + family_name_length + name_suffix_length) > 80)
	{
		alert(getMessage('LEN_OF_NAMES_CANNOT_EXCEED','MP'));
		obj.value="";
		obj.focus();
	}
	*/
	var msg_txt="";
	if(name_prefix_length>80){
		msg_txt="Prefix";
	}

	if(first_name_length>80){
		msg_txt="First Name";
	}

	if(second_name_length>80){
		msg_txt="Second Name";
	}

	if(third_name_length>80){
		msg_txt="Third Name";
	}

	if(family_name_length>80){
		msg_txt="Family Name";
	}

	if(name_suffix_length>80){
		msg_txt="Suffix";
	}

	
	if(msg_txt!=""){
		var errors1 = getMessage('NAME_EXCEED_MAX_LEN','MP');				
		errors1 = errors1.replace('#', msg_txt);
		alert(errors1);
		obj.value="";
		obj.focus();
	}

	if(msg_txt==""){
		if((name_prefix_length + first_name_length + second_name_length + third_name_length + family_name_length + name_suffix_length) > 280)
		{
			alert(getMessage('LEN_OF_NAMES_EXCEED','MP'));
			obj.value="";
			obj.focus();
		}
	}
	

}

function tabs_alignment(choice)
{
	if(choice==1) {
	    //tab_click1('legal_names_tab');
		expandCollapse("legal_names_tab");
	} else if(choice==2) {
		//tab_click1('alt_id_chk_tab');
		expandCollapse("alt_id_chk_tab");
	} else if(choice==3) {
		//tab_click1('new_born_tab');
		expandCollapse("new_born_tab");
	} else if(choice==4) {
		//tab_click1('others_tab');
		expandCollapse("others_tab");
	}
	
}



/** Lookup for Language **/

async function searchLanguage(obj,target)
{
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	//var locale=document.forms[0].locale.value;
	var tit="";				
	if(target.name == 'language_desc')
	{
		tit=getLabel("Common.Language.label","Common");
		sql="Select LANG_ID code,LONG_NAME description from MP_LANGUAGE where  eff_status='E' and  upper(LANG_ID) like upper(?) and upper(LONG_NAME) like upper(?) order by 2";
	}

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		if(target.name == 'language_desc')
		{
		document.forms[0].language_code.value= arr[0];
		}
	}
	else{
		target.value='';
	}
}




/** end of Language Lookup **/




/** Lookup for Religion **/

async function searchReligion(obj,target)
{
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	//var locale=document.forms[0].locale.value;
	var tit="";				
	if(target.name == 'religion_desc')
	{
		tit=getLabel("Common.religion.label","common");
		sql="Select RELGN_CODE code,LONG_DESC description from MP_RELIGION where  eff_status='E' and  upper(RELGN_CODE) like upper(?) and upper(LONG_DESC) like upper(?) order by 2";
	}

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		if(target.name == 'religion_desc')
		{
		document.forms[0].religion_code.value= arr[0];
		}
	}
	else{
		target.value='';
	}
}




/** end of Religion Lookup **/



/** Lookup for Nationality **/

async function searchNationality(obj,target)
{
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	//var locale=document.forms[0].locale.value;
	var tit="";				
	if(target.name == 'citizen_nationality_desc')
	{
		tit=getLabel("Common.nationality.label","common");
		
		sql="select country_code code, long_desc description from mp_country where eff_status='E' and ( sysdate between nvl(eff_date_from,to_date('01/01/1472','dd/mm/rrrr') ) and nvl(eff_date_to,to_date('31/12/5000','dd/mm/rrrr') ) ) and upper(country_code) like upper(?) and upper(long_desc) like upper(?) order by long_desc";
	}

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		if(target.name == 'citizen_nationality_desc')
		{
		document.forms[0].citizen_nationality_code.value= arr[0];
		}
	}
	else{
		target.value='';
		document.forms[0].citizen_nationality_code.value='';
	}
}




/** end of Nationality Lookup **/




/** Lookup for Race **/

async function searchRace(obj,target)
{
	
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	//var locale=document.forms[0].locale.value;
	var tit="";				
	if(target.name == 'race_desc')
	{
		tit=getLabel("Common.race.label","common");
		
		sql="select race_code code, long_desc description from mp_race where eff_status='E' and ( sysdate between nvl(eff_date_from,to_date('01/01/1472','dd/mm/rrrr') ) and nvl(eff_date_to,to_date('31/12/5000','dd/mm/rrrr') ) ) and upper(race_code) like upper(?) and upper(long_desc) like upper(?) order by long_desc";
	}

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		if(target.name == 'race_desc')
		{
		document.forms[0].default_race_code.value= arr[0];
		}
	}
	else{
		
	    target.value='';
	   

	}
}

function  enabledisabelalt_pat(obj){
   if(obj.checked){
    
	 document.mp_param_form.gen_patid_using_altid_rl_yn.disabled=true;
     document.mp_param_form.gen_patid_using_altid_rl_yn.checked=false;
      }else{

     document.mp_param_form.single_patient_numbering_yn.disabled=true;
     document.mp_param_form.single_patient_numbering_yn.checked=false;
     document.mp_param_form.gen_patid_using_altid_rl_yn.disabled=false;
     document.mp_param_form.gen_patid_using_altid_rl_yn.checked=true;
}
}
function generateAltIDRule(obj)
{
//	var gen_patid_using_altid_rl_yn=document.forms.gen_patid_using_altid_rl_yn;
		var length=document.forms[0].alt_id1_unique_yn;
		var unique=document.forms[0].alt_id1_len_validation_yn;

	if (obj.checked==true)
	{
		
		
		
		
		document.mp_param_form.nb_use_mother_ser.value='N';
		document.mp_param_form.nb_use_mother_ser.disabled=true;
		document.mp_param_form.nb_use_mother_ser.checked=false;
		document.mp_param_form.single_patient_numbering_yn.checked=false;		
	    document.mp_param_form.single_patient_numbering_yn.disabled=true;
	    document.mp_param_form.mapped_alt_id_org_member_id_ins.disabled=false;
			var opt=parent.frames[1].document.createElement('OPTION');
			opt.value='ID1';
			opt.text=getLabel("Common.identification.label","Common")+'1';
			parent.frames[1].document.forms[0].mapped_alt_id_org_member_id_ins.add(opt);
			parent.frames[1].document.forms[0].mapped_alt_id_org_member_id_ins.value='ID1';
			document.mp_param_form.mapped_alt_id_org_member_id_ins.disabled=true;
		var patient_id_length=document.mp_param_form.patient_id_length.value;
		var alt_id1_length=document.mp_param_form.alt_id1_length.value;
			

		length.checked=false;
		length.disabled=true;
		
		unique.checked=false;
		unique.disabled=true;
		document.mp_param_form.gen_patid_using_altid_rl_yn.value='Y';
	/*	if (document.mp_param_form.gen_patid_using_altid_rl_yn.value=='Y')
		{
			alt_id1_length=patient_id_length-4;
			document.mp_param_form.varable_patient_id_length.value=alt_id1_length;
//			alert("Vairable length==>"+document.mp_param_form.varable_patient_id_length.value)
		}*/
		document.mp_param_form.family_org_id_accept_yn.value='Y';
		document.mp_param_form.family_org_id_accept_yn_new.value='Y';
		document.mp_param_form.family_org_id_accept_yn.checked=true;
		document.mp_param_form.family_org_id_accept_yn.disabled=true;
		document.getElementById('rlnsp').style.visibility='visible';
//		document.getElementById('reltn_mand_gif').style.visibility='visible';
//		document.mp_param_form.relation_shp_length.disabled=false;
		maintainOrgMembership(document.mp_param_form.family_org_id_accept_yn)
		document.forms[0].family_no_link_yn.value='Y';
		document.forms[0].family_no_link_yn_new.value='Y';
		document.forms[0].family_no_link_yn.checked=true;
		document.forms[0].family_no_link_yn.disabled=true;

	}else{
		
				
		document.mp_param_form.nb_use_mother_ser.value='Y';
		document.mp_param_form.nb_use_mother_ser.disabled=false;
		document.mp_param_form.nb_use_mother_ser.checked=false;

				var altid_mbr=document.forms[0].mapped_alt_id_org_member_id_ins;
			//while(altid_mbr.options.length>1) altid_mbr.options.remove(1);
		length.checked=false;
		length.disabled=false;
		
		unique.checked=false;
		unique.disabled=false;

		document.mp_param_form.gen_patid_using_altid_rl_yn.value='N';
		document.mp_param_form.family_org_id_accept_yn_new.value='N';
		document.mp_param_form.family_org_id_accept_yn.value='N';
		document.mp_param_form.family_org_id_accept_yn.checked=false;
		document.mp_param_form.family_org_id_accept_yn.disabled=false;
		document.getElementById('rlnsp').style.visibility='hidden';
		maintainOrgMembership(document.mp_param_form.family_org_id_accept_yn)
		document.forms[0].org_member_relationship_code.disabled=true;
		document.forms[0].family_no_link_yn.value='N';
		document.forms[0].family_no_link_yn_new.value='N';
		document.forms[0].family_no_link_yn.checked=false;
		document.forms[0].family_no_link_yn.disabled=false;
		document.mp_param_form.single_patient_numbering_yn.checked=false;		
	    document.mp_param_form.single_patient_numbering_yn.disabled=false;
		document.mp_param_form.single_patient_numbering_yn.cvalue="N";
//			alert("In else" +document.mp_param_form.gen_patid_using_altid_rl_yn.value)

	}

	
}

/*function checkValues()
{
	var relation_length=document.mp_param_form.relation_shp_length.value;
	if (!(relation_length==3|| relation_length==4))
	{
		var  msg=getMessage("REL_LEVEL_LENGTH","MP");
						alert(msg);
						relation_length='';
//						messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="
//						return;
//		alert("Length 3 OR Length 4 accepted")
			
	}
}*/

/*function lengthDerivation(obj)
{
	var patient_id_length=document.mp_param_form.patient_id_length.value;
	var relation_length=obj.value;
	var vairable_patient_id_length=document.mp_param_form.patient_id_length.value;
//	alert("relation_length==>" +relation_length)
//	alert("patient_id_length==>" +patient_id_length)
//	var alt_id1_length="";
	if(relation_length!=0)
	{
	vairable_patient_id_length=patient_id_length-relation_length;
	}
			alert("alt_id1_length==>" +vairable_patient_id_length);
}*/


/** end of Race Lookup **/


function callfocusfun(){
	//parent.frames[1].tab4.scrollIntoView();
	expandCollapse("legal_names_tab");
}

function calllfocusoth(){
	//parent.frames[1].tab10.scrollIntoView();
	expandCollapse("others_tab");
}

function exp_focus(){
	//parent.frames[1].tab5.scrollIntoView();
	expandCollapse("alt_id_chk_tab");
}


function UnCheckLength()
{
	var length=document.forms[0].d_alt_id1_unique_yn;
	var unique=document.forms[0].h_alt_id1_len_validation_yn;
	if (document.forms[0].gen_patid_using_altid_rl_yn.checked==true)
	{
		length.checked=false;
		length.disabled=true;
		
		unique.checked=false;
		unique.disabled=true;
	}
}

function sel_familyLink(obj){
if(obj.checked){
document.forms[0].family_no_link_yn.value='Y';
document.forms[0].family_no_link_yn_new.value='Y';
}else{
document.forms[0].family_no_link_yn.value='N';
document.forms[0].family_no_link_yn_new.value='N';
}
//alert(document.forms[0].family_no_link_yn.value)
//alert(document.forms[0].family_no_link_yn_new.value)
}

function enaChkDigit(obj)
{
	if(obj.checked == true)
	{
		document.forms[0].nat_chk_dig_scheme.value = "";			
		document.forms[0].nat_chk_dig_scheme.disabled = true;
	}
	else
		document.forms[0].nat_chk_dig_scheme.disabled = false; 
}

/*
function chk_chg_allowed_ser(obj)
{
	if(obj.checked==true)
	{
		document.mp_param_form.id_change_allowed_for_series.value="";
		document.mp_param_form.id_change_allowed_for_series.disabled=true;
	}
	else if(obj.checked==false)
	{
		document.mp_param_form.id_change_allowed_for_series.disabled=false;
	}

}
*/

function generateSinglePatientNoAppl(obj){
	if(obj.checked == true){
		document.mp_param_form.gen_patid_using_altid_rl_yn.disabled=true;
		document.mp_param_form.single_patient_numbering_yn.value="Y";
	}else{
		document.mp_param_form.gen_patid_using_altid_rl_yn.disabled=false;
		document.mp_param_form.single_patient_numbering_yn.value="N";
	}
}

function CheckPositiveNumberMP(obj) {

    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
    }else {
        if ( obj.value.length > 0 ) {
            alert(getMessage("INVALID_POSITIVE_NUMBER", "Common"));
            obj.select();
            obj.focus();
        }else if ( obj.value.length == 0 )
            obj.value = 1;
    }
}

async function searchRelationship(obj,target)
{
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	var tit="";		
	tit=getLabel("Common.relationship.label","common");
	sql="select relationship_code code,short_desc description from mp_relationship where upper(relationship_code) like upper(?) and upper(short_desc) like upper(?) and eff_status='E' order by 2";

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;

	retVal = await CommonLookup( tit, argumentArray );
	 
	if(retVal != null && retVal != "" ) {
		var ret1=unescape(retVal);
		arr=ret1.split(",");		 
		target.value=arr[1];		 
		if(target.name == 'default_relationship_desc') {
			document.forms[0].default_relationship.value= arr[0];
		}	
	}else{
		if(target.name == 'default_relationship_desc'){
			target.value='';
			document.forms[0].default_relationship.value='';
		}		
	}
}

// Function added for RUT-CRF-0007-MPI (IN023391) on 16.09.2010 by Suresh M
function chkForNumeric(event){
    var strCheck = '0123456789 ';
    var whichCode = (window.Event) ? event.which : event.keyCode;	 
    key = String.fromCharCode(whichCode);  // Get key value from key code	 
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}

// Function added for RUT-CRF-0007-MPI (IN023391) on 16.09.2010 by Suresh M
function checkForZero(obj){	 
	if(obj.value == '0' || obj.value == '00' || obj.value == '000'){		 
		alert(getMessage("VALUE_GREAT_ZERO","MP")) ;
		obj.value="";
		obj.focus();
	}
}

function subNewBornHW(obj){
	if(obj.value == "H")
	 document.forms[0].sub_multi_birth_hw.value = "H";
	else if(obj.value == "W"){
	 document.forms[0].sub_multi_birth_hw.value = "W"; 	
	 if(document.mp_param_form.mul_birth_regn_within_hours.value !="" &&
		 document.mp_param_form.mul_birth_regn_within_hours.value > 38){
		alert(getMessage("SUBSEQUENT_DELY_WEEKS","MP"));
		document.mp_param_form.mul_birth_regn_within_hours.select();
		document.mp_param_form.mul_birth_regn_within_hours.focus();
	 }	 
	}
}

function validateValue(obj){		 
	if(obj.value != "" && obj.value > 0){
	  if(document.mp_param_form.sub_multi_birth_hw[1].checked && obj.value >38 ){
		alert(getMessage("SUBSEQUENT_DELY_WEEKS","MP"));
		obj.select();
		obj.focus();
	  }
	}
 }  

function checkZero(obj){
	if(obj.value=='0'){
		alert(getMessage("VALUE_GREAT_ZERO","MP"));
		obj.select();
		obj.focus();
	}
}
/*Maheshwaran K added for the Bru-HIMS-CRF-171 as on 12/12/2012*/
function makemand(obj){ 
	if(obj.value==""){
		document.getElementById('reasonCodeMand').style.visibility="hidden"; 
		document.mp_param_form.cancel_reason_code.value = "";
		document.mp_param_form.cancel_reason_code.disabled=true;
	}else{
		document.getElementById('reasonCodeMand').style.visibility="visible"; 
		if(document.mp_param_form.cancel_reason_code.disabled==true)
			document.mp_param_form.cancel_reason_code.disabled=false;
	}
}

/*Added by Ashwini on 18-Jan-2017 for ML-MMOH-CRF-0895*/
function removeSpace(obj)
{
	if(TrimStr(obj.value) == "")
	{
		obj.value = "";
	}else
	{
		obj.value = TrimStr(obj.value);
	}
}

/*Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551*/
function SplCharsChkForNBNameDrvn(event) {
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ< >+,()/';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}

function checkNBNameDervnLogic(obj) {
    var formula = obj.value.split( "+" ) ;
    var valid   = false ;
    var error   = getMessage("INVALID_VALUE","Common") ;

	if(obj.name == "name_dervn_logic_nb")
	{
		error = error.replace('#', getLabel('eMP.NewbornNameDervLogic.label','MP')) ;
	}else if(obj.name == "name_dervn_logic_nb_sb")
	{
		error = error.replace('#', getLabel('eMP.NewbornNameDervLogicSB.label','MP')) ;
	}
	
	if (formula != "")
    {
        for( var i=0; i<formula.length; i++ ) {
            if ( i == 0 ) {
                if ( !( formula[i] == "PR" || formula[i] == "1N" || formula[i] == "2N" || formula[i] == "3N" || formula[i] == "FN" || formula[i] == "SE" || formula[i] == "B/O") ) {
                    alert( error ) ;
                    obj.select() ;
                    return false ;
                }
            }
        }

        for( var i=0; i<formula.length; i++ ) {
            var f       = formula[i] ;
            var len     = f.length ;
            var isConstant  = false ;
            var start   = f.substring( 0, 1 ) ;
            var end     = f.substring( len-1, len ) ;

            if ( start == "<" && end == ">" )
                isConstant = true ;

            if ( !isConstant ) {
                if ( !validTokenNB( f ) ) {
                    alert( error ) ;
					obj.select() ;
                    return false ;
                }
            }
        }
    }
    return true ;
}

function validTokenNB( token ) {
    var validTokens = new Array( "PR", "1N", "2N", "3N", "FN", "SF", "SE", "NU", "NT", "B/O", "TWIN" ) ;
    var result  = false ;

    for( var i=0; i<validTokens.length && !result ; i++ ) {
        if ( token == validTokens[i] ) result = true ;
    }

    return result ;
}
/*End ML-MMOH-CRF-1551*/



