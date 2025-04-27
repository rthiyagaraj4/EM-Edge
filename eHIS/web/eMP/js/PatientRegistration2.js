

function doDefaulting(from) 
{  
	if(from == 1)
	{
		document.getElementById('nationality_code').value = document.getElementById('dflt_nationality_code').value;
		document.getElementById('pat_ser_grp_code').value = document.getElementById('dflt_pat_ser_grp_code').value;
		document.getElementById('pref_facility_id').value = document.getElementById('dflt_pref_facility_id').value;

		if ( document.getElementById('nationality_code').value == '' || document.getElementById('nationality_code').value == null)
			document.getElementById('nationality_code').selectedIndex = 0;

		// IN CASE OF DEFAULTING A NON-AVAILABLE SERIES , SELECT WILL BECOME BLANK. TO AVOID THAT  THIS CHECKING IS MADE.....

		if ( document.getElementById('pat_ser_grp_code').value == '' || document.getElementById('pat_ser_grp_code').value == null)
			document.getElementById('pat_ser_grp_code').selectedIndex = 0;
		document.getElementById('pat_ser_grp_code').focus();
	}
	else if ( from == 2 )
	{ 
		f_query_add_mod.patient_sub.document.getElementById('nationality_code').value = f_query_add_mod.patient_sub.document.getElementById('dflt_nationality_code').value;

		f_query_add_mod.patient_sub.document.getElementById('pat_ser_grp_code').value = f_query_add_mod.patient_sub.document.getElementById('dflt_pat_ser_grp_code').value;

		f_query_add_mod.patient_sub.document.getElementById('pref_facility_id').value = f_query_add_mod.patient_sub.document.getElementById('dflt_pref_facility_id').value;

		// IN CASE OF DEFAULTING A NON-AVAILABLE SERIES , SELECT WILL BECOME BLANK. TO AVOID THAT  THIS CHECKING IS MADE.....

		if ( f_query_add_mod.patient_sub.document.getElementById('pat_ser_grp_code').value == '' || f_query_add_mod.patient_sub.document.getElementById('pat_ser_grp_code').value == null)

			f_query_add_mod.patient_sub.document.getElementById('pat_ser_grp_code').selectedIndex = 0;
		f_query_add_mod.patient_sub.document.getElementById('pat_ser_grp_code').focus();
	}
	
}

// ***********************************************************************
function checkAltIDLength(Obj,AltNum,Check,routine_chk,routine_name,alt_id_chk_digit_scheme,alt_id1_accept_alphanumeric_yn)
{ 
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
    var valLength = new String();
    valLength = Obj.value;
    valLength = valLength.length;
    var dup_chk = true;;

        if(Obj.value == '' || Obj.value == null)continue_exe = false
    chk_dig_mes = getMessage("ALT_ID_NO",'MP')

	if (alt_id1_accept_alphanumeric_yn==null || alt_id1_accept_alphanumeric_yn=='undefined') 
	alt_id1_accept_alphanumeric_yn = "Y";

    if(AltNum ==1)
    {
        if(document.getElementById('alt_id1_exp_date') !=null)
        {
            if(valLength>0) 
			{
				document.getElementById('alt_id1_exp_date').readOnly =false
				document.getElementById('altidexpdt1').disabled =false;
			}
            else            
			{
				document.getElementById('alt_id1_exp_date').readOnly =true; 
				document.getElementById('altidexpdt1').disabled =true;
				document.getElementById('alt_id1_exp_date').value=''; 
			}
        }

        if(document.getElementById('alt_id1_no_dup') != null)
        {
            if(document.getElementById('alt_id1_no_dup').value == Obj.value)
                dup_chk = false;
        }
        chk_dig_mes = chk_dig_mes.replace('$',document.getElementById('alt_id1_prompt').innerText)
    }
    if(AltNum ==2)
    {
        if(document.getElementById('alt_id2_exp_date') !=null)
        {
            if(valLength>0) 
			{
				document.getElementById('alt_id2_exp_date').readOnly =false
				document.getElementById('altidexpdt2').disabled =false;
			}
            else            
			{
				document.getElementById('alt_id2_exp_date').readOnly =true; 
				document.getElementById('altidexpdt2').disabled =true;
				document.getElementById('alt_id2_exp_date').value=''; 
			}
        }

        if(document.getElementById('alt_id2_no_dup') != null)
            if(document.getElementById('alt_id2_no_dup').value == Obj.value)
               dup_chk = false;
        chk_dig_mes = chk_dig_mes.replace('$',document.getElementById('alt_id2_prompt').innerText)
    }
    if(AltNum ==3)
    {
        if(document.getElementById('alt_id3_exp_date') !=null)
        {
            if(valLength>0) 
			{
				document.getElementById('alt_id3_exp_date').readOnly =false
				document.getElementById('altidexpdt3').disabled =false;
			}
            else            
			{
				document.getElementById('alt_id3_exp_date').readOnly =true; 
				document.getElementById('altidexpdt3').disabled =true;
				document.getElementById('alt_id3_exp_date').value=''; 
			}
        }

        if(document.getElementById('alt_id3_no_dup') != null)
            if(document.getElementById('alt_id3_no_dup').value == Obj.value)
                dup_chk = false;

        chk_dig_mes = chk_dig_mes.replace('$',document.getElementById('alt_id3_prompt').innerText)
    }
    if(AltNum ==4)
    {
        if(document.getElementById('alt_id4_exp_date') !=null)
        {
            if(valLength>0) 
			{
				document.getElementById('alt_id4_exp_date').readOnly =false
				document.getElementById('altidexpdt4').disabled =false;
			}
            else            
			{
				document.getElementById('alt_id4_exp_date').readOnly =true;
				document.getElementById('altidexpdt4').disabled =true;
				document.getElementById('alt_id4_exp_date').value=''; 
			}
        }

        if(document.getElementById('alt_id4_no_dup') != null)
            if(document.getElementById('alt_id4_no_dup').value == Obj.value)
               dup_chk = false;

      chk_dig_mes = chk_dig_mes.replace('$',document.getElementById('alt_id4_prompt').innerText)
    }

    var continue_exe = true;
    if (Check == 'Y')
    {
        if ( Obj.value.length != Obj.maxLength && Obj.value.length > 0){
            continue_exe = false;
                
                msg = getMessage("ALT_ID_CHARS",'MP')
                if(AltNum ==1)  msg =msg.replace('$',document.getElementById('alt_id1_prompt').innerText)
                if(AltNum ==2)  msg =msg.replace('$',document.getElementById('alt_id2_prompt').innerText)
                if(AltNum ==3)  msg =msg.replace('$',document.getElementById('alt_id3_prompt').innerText)
                if(AltNum ==4)  msg =msg.replace('$',document.getElementById('alt_id4_prompt').innerText)
                msg =msg.replace('@',Obj.maxLength)
                alert(msg);
				Obj.value='';
				Obj.focus();
        }
    }

	// added by dharma for GHL-CRF-524.1
	var alt_id1_alphanum_validate_yn = "N";
	if(document.getElementById('alt_id1_alphanum_validate_yn'))
		alt_id1_alphanum_validate_yn= document.getElementById('alt_id1_alphanum_validate_yn').value;
    if (((alt_id_chk_digit_scheme != '' && alt_id_chk_digit_scheme != 'null') || alt_id1_accept_alphanumeric_yn=='N') && alt_id1_alphanum_validate_yn == 'N' )
    {
        if(isNaN(Obj.value))
        {
            continue_exe = false ;
            alert(chk_dig_mes   )

        }
    }

    if(continue_exe)
    {
        var val = '10' ;
		var sStyle = document.forms[0].sStyle.value;     

		xmlStr+=" alt_id_no=\""+escape(Obj.value)+"\"";
		xmlStr+=" id_no=\""+escape(AltNum)+"\"";
		if(routine_chk == "Y")
			xmlStr+=" curr_ds_id=\""+routine_name+"\"";

		if(alt_id_chk_digit_scheme != null && alt_id_chk_digit_scheme!= "" && alt_id_chk_digit_scheme!= "null")
        {
			xmlStr+=" alt_id_chk_digit_scheme=\""+alt_id_chk_digit_scheme+"\"";
            val='12' ;
        }
		xmlStr+=" process_id=\""+val+"\"";
		xmlStr+=" operation=\""+document.getElementById('operation').value+"\"";

		 if(document.getElementById('first_time_only') !=null)
		  {
			  xmlStr+=" first_time_only=\""+document.getElementById('first_time_only').value+"\"";
			if(document.getElementById('first_time_only').value =="Y")
			document.getElementById('first_time_only').value = 'N'
		  }

		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		
		var url = "../../eMP/jsp/ServerValidationXML.jsp";
		xmlHttp.open("POST", url, false);
		xmlHttp.setRequestHeader("Content-type" ,"application/x-www-form-urlencoded");
		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText);
    }
    else
    {
        for( i=0; i<prev_set_objs.length;i++)
        {
           if(prev_set_objs[i] != null)
           {
               if(prev_set_objs[i].name == 'first_name' || prev_set_objs[i].name == 'second_name' || prev_set_objs[i].name == 'third_name' || prev_set_objs[i].name == 'family_name'||prev_set_objs[i].name.indexOf('oth_lang') != -1)
               {
                ChangeInitCase(prev_set_objs[i])
                putPatientName(prev_set_objs[i])
                if(prev_set_objs[i].name.indexOf('oth_lang') != -1)
                   putLocalLangPatientName(prev_set_objs[i])
                }
                 if( prev_set_objs[i].name == 'date_of_birth')
                 {
                    gotoNext( prev_set_objs[i])
                    document.getElementById('age_or_dob').disabled = false;
                 }

                prev_set_objs[i].value='';
                if(prev_set_objs[i].type == 'text')
                {
                    prev_set_objs[i].readOnly = false;
                            if(prev_set_objs[i].name == 'first_name')    parent.f_query_add_mod.patient_sub.document.getElementById('bf').disabled = false;
                            if(prev_set_objs[i].name == 'second_name')    parent.f_query_add_mod.patient_sub.document.getElementById('bs').disabled = false;
                            if(prev_set_objs[i].name == 'third_name')    parent.f_query_add_mod.patient_sub.document.getElementById('bt').disabled = false;
                            if(prev_set_objs[i].name == 'family_name')    parent.f_query_add_mod.patient_sub.document.getElementById('bfam').disabled = false;
                            if(prev_set_objs[i].name == 'first_name_oth_lang')    parent.f_query_add_mod.patient_sub.document.getElementById('bfo').disabled = false;
                            if(prev_set_objs[i].name == 'second_name_oth_lang')    parent.f_query_add_mod.patient_sub.document.getElementById('bso').disabled = false;
                            if(prev_set_objs[i].name == 'third_name_oth_lang')    parent.f_query_add_mod.patient_sub.document.getElementById('bto').disabled = false;
                            if(prev_set_objs[i].name == 'family_name_oth_lang')    parent.f_query_add_mod.patient_sub.document.getElementById('bfamo').disabled = false;
                }
                else
                    prev_set_objs[i].disabled = false;
            }
        }
        prev_set_objs= new Array();
    }
}

// ***********************************************************************





function clearValue(obj) {
	if (obj.name=='date_of_birth') {
		document.getElementById('b_time').value = "";
	}
}

function disableEnableYMDH(Obj) {	
      
		
		var dateVal = Obj.value;		

		var disp_newborn_age = document.forms[0].display_new_born_age_in_hrs.value;

		

		b_age = document.getElementById('b_age').value;
        b_months = document.getElementById('b_months').value;
        b_days = document.getElementById('b_days').value;
        b_hours = document.getElementById('b_hours').value;


		if(dateVal!="")	{

			if(Obj.name=='b_hours')	{
				document.getElementById('b_age').disabled = true;
				document.getElementById('b_months').disabled = true;
				document.getElementById('b_days').disabled = true;
			}
			else if(Obj.name=='b_age' || Obj.name=='b_months' || Obj.name=='b_days') {
				if(b_age!="" || b_months!="" || b_days!="") {					
					document.getElementById('b_hours').disabled = true;				
				}
			}
			else if(Obj.name=='date_of_birth') {
			//	document.getElementById('b_time').disabled = true;
			}
			else if(Obj.name=='b_time')	{
			//	document.getElementById('date_of_birth').disabled = true;
			//	document.getElementById('imgdateofbirth').disabled = true;
			//	document.getElementById('dateofbirth').disabled = true;
			}
		}
		else if(dateVal=="") {

			if(Obj.name=='b_hours')
			{
				document.getElementById('b_age').disabled = false;
				document.getElementById('b_months').disabled = false;
				document.getElementById('b_days').disabled = false;
				document.getElementById('date_of_birth').value = "";
				document.getElementById('dateofbirth').value = "";
				document.getElementById('b_time').value = "";
			
			}
			else if(Obj.name=='b_age' || Obj.name=='b_months' || Obj.name=='b_days') {

				if(b_age=="" && b_months =="" && b_days=="") {
					if(disp_newborn_age!="") {
						document.getElementById('b_hours').disabled = false;				
					}
				}
			}
			else if(Obj.name=='date_of_birth' && disp_newborn_age!="") {
			//	document.getElementById('b_time').disabled = false;
			}
			else if(Obj.name=='b_time')	{
			//	document.getElementById('date_of_birth').disabled = false;
			//	document.getElementById('imgdateofbirth').disabled = false;
			//	document.getElementById('dateofbirth').disabled = false;
			}
			
		}
}

function disableEnableDate()    {

	var disp_newborn_age = document.forms[0].display_new_born_age_in_hrs.value;
	
	var b_age = document.getElementById('b_age').value;
	var b_months = document.getElementById('b_months').value;
	var b_days = document.getElementById('b_days').value;
	var b_hours = document.getElementById('b_hours').value;

    if ( document.getElementById('age_or_dob').checked == true )
    {
	    document.getElementById('age_or_dob').value='Y';
        
        document.getElementById('date_of_birth').disabled = true;
        
        // Disable calendar icon (Make it unclickable)
        document.getElementById("imgdateofbirth").style.pointerEvents = "none";
        document.getElementById("imgdateofbirth").style.opacity = "0.5"; // Make it look disabled

		document.getElementById('b_time').disabled = true;
        
        if (b_hours === "") {
			document.getElementById('b_age').disabled = false;		
			document.getElementById('b_months').disabled = false;		
			document.getElementById('b_days').disabled = false;
		}

		if( disp_newborn_age == "" || b_age !="" || b_months !="" || b_days !="" ) {
			document.getElementById('b_hours').disabled = true;
		} else {
			document.getElementById('b_hours').disabled = false;
		}

		if(b_age!="")
			document.getElementById('b_age').focus();
		else if(b_months!="")
			document.getElementById('b_months').focus();
		else if(b_days!="")
			document.getElementById('b_days').focus();
		else if(b_hours!="" && disp_newborn_age!="")
			document.getElementById('b_hours').focus();			
		
		if(b_age == "" && b_months == "" && b_days == "" && b_hours == "") {
			document.getElementById('b_age').focus();
		}		
			
    }
    else if ( document.getElementById('age_or_dob').checked == false )
    {
	    document.getElementById('age_or_dob').value='N';
        document.getElementById('b_age').disabled = true;
        document.getElementById('b_months').disabled = true;
        document.getElementById('b_days').disabled = true;
        document.getElementById('b_hours').disabled = true;
        document.getElementById('date_of_birth').disabled = false;
        
        // Enable calendar icon (Make it clickable again)
        document.getElementById("imgdateofbirth").style.pointerEvents = "auto";
        document.getElementById("imgdateofbirth").style.opacity = "1"; // Restore visibility

        if (disp_newborn_age !== "" && document.getElementById("date_of_birth").value === "")
			document.getElementById('b_time').disabled = false;

        if (document.getElementById("date_of_birth").value !== "")
			document.getElementById('date_of_birth').focus();		
    }

    // Handle Hijri Date Fields (if applicable)
	if(document.getElementById('hij_appl_YN').value=='Y'){
        if (document.getElementById("age_or_dob").checked) {
			document.getElementById('date_of_birth_hj').disabled = true;
            document.getElementById("imgdateofbirth_hj").style.pointerEvents = "none";
            document.getElementById("imgdateofbirth_hj").style.opacity = "0.5";
        } else {
            document.getElementById("date_of_birth_hj").disabled = false;
            document.getElementById("imgdateofbirth_hj").style.pointerEvents = "auto";
            document.getElementById("imgdateofbirth_hj").style.opacity = "1";
        }
    }
}
// ***********************************************************************
function checkLength(Obj,SizeVal)   {
    if ( Obj.value.length > SizeVal )
    {
        var msg = getMessage("OBJ_CANNOT_EXCEED",'Common');
		msg = msg.replace('$', SizeVal);
		alert(msg);	
        Obj.select();
		return false;
    } else {
		if(Obj.name == 'general_remarks') {
			if(document.forms[0].doc_id1_desc)
				document.forms[0].doc_id1_desc.focus();
		}
	    return true;
	}
}
// ***********************************************************************
function setOcpnDesc(Obj)   {
    document.getElementById('empyr_ocpn_desc').value = '';
    if ( Obj == document.getElementById('empyr_ocpn_code') )
    {
        if ( document.getElementById('empyr_ocpn_code').value.length != 0 )
            document.getElementById('empyr_ocpn_desc').value = Obj.options[Obj.selectedIndex].text;
    }
    else if ( Obj == document.getElementById('empyr_ocpn_desc_temp') )
    {
        document.getElementById('empyr_ocpn_desc').value = Obj.value;
    }
}
// ***********************************************************************
function enableOcpnTemp()   {
    if ( document.getElementById('empyr_ocpn_code').selectedIndex != 0 )
    {
        document.getElementById('empyr_ocpn_desc_temp').value = '';
        document.getElementById('empyr_ocpn_desc_temp').disabled = true;
    }
    else if ( document.getElementById('empyr_ocpn_code').selectedIndex == 0 )
        document.getElementById('empyr_ocpn_desc_temp').disabled = false;
}
// ***********************************************************************
function copyDetails(Val) {  
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
    if(Val == 1)
    {
        if(document.getElementById('family_link_no') != null)
        {           
			if(document.getElementById('family_link_no').value.length > 0)
            {		
				xmlStr+=" process_id=\"8\" ";
				xmlStr+=" head_patient_id=\""+document.getElementById('family_link_no').value+"\"";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				
				var url = "../../eMP/jsp/ServerValidationXML.jsp";
				xmlHttp.open("POST", url, false);
				xmlHttp.setRequestHeader("Content-type" ,"application/x-www-form-urlencoded");
				xmlHttp.send(xmlDoc);
				eval(xmlHttp.responseText);
	
				if(document.getElementById('next_contact_name') != null)
					document.getElementById('next_contact_name').focus();
            }
		/*	else{
			
					document.getElementById('next_addr_line1').value ="";
					document.getElementById('next_addr_line2').value = "";    
					document.getElementById('next_addr_line3').value ="";	
					document.getElementById('contact1_res_town_code').value = "";	
					document.getElementById('n_town').value = "";
					document.getElementById('contact1_region_code').value ="";	
					document.getElementById('n_region').value ="";	
					document.getElementById('contact1_res_area_code').value = "";	
					document.getElementById('n_area').value ="";    
					document.getElementById('next_addr_line4').value = "";    
					document.getElementById('next_postal_code').value = "";	
					document.getElementById('next_postal_code1').value = "";    
					document.getElementById('next_country_code').value = "";	
					document.getElementById('next_country_desc').value = "";  
					document.getElementById('next_res_tel_no').value = "";
			     }*/
           }
    }
    if(Val == 2)
    {
        if(document.getElementById('next_addr_line1') != null)
            document.getElementById('next_addr_line1').value = document.getElementById('r_addr_line1').value;
      
		if(document.getElementById('next_addr_line2') != null)
		 document.getElementById('next_addr_line2').value = document.getElementById('r_addr_line2').value;

        if(document.getElementById('next_addr_line3') != null)
		 document.getElementById('next_addr_line3').value = document.getElementById('r_addr_line3').value;
		
		if(document.getElementById('contact1_res_town_code') != null)
            document.getElementById('contact1_res_town_code').value = document.getElementById('r_town_code').value;
		if(document.getElementById('n_town') != null)
            document.getElementById('n_town').value = document.getElementById('r_town').value;

		if(document.getElementById('contact1_region_code') != null)
            document.getElementById('contact1_region_code').value = document.getElementById('r_region_code').value;
		
		if(document.getElementById('n_region') != null)
            document.getElementById('n_region').value = document.getElementById('r_region').value;
		
		if(document.getElementById('contact1_res_area_code') != null)
            document.getElementById('contact1_res_area_code').value = document.getElementById('r_area_code').value;
		
		if(document.getElementById('n_area') != null)
            document.getElementById('n_area').value = document.getElementById('r_area').value;

        if(document.getElementById('next_addr_line4') != null)
			document.getElementById('next_addr_line4').value = document.getElementById('r_addr_line4').value;

        if(document.getElementById('next_postal_code') != null)
	        document.getElementById('next_postal_code').value = document.getElementById('r_postal_code').value;

		if(document.getElementById('next_postal_code1') != null)
	        document.getElementById('next_postal_code1').value = document.getElementById('r_postal_code1').value;

        if(document.getElementById('next_country_code') != null)
		    document.getElementById('next_country_code').value = document.getElementById('r_country_code').value;
		
		if(document.getElementById('next_country_desc') != null)
			document.getElementById('next_country_desc').value = document.getElementById('r_country_desc').value;

        if(document.getElementById('next_res_tel_no') != null)
		      document.getElementById('next_res_tel_no').value = document.getElementById('contact1_no').value;
	
	}
    if(Val == 3)
    {
		//Added on 25/08/2003 for populating values from contact address(Residence) to First Notify fields
		if(document.getElementById('first_addr_line1') != null)
            document.getElementById('first_addr_line1').value = document.getElementById('r_addr_line1').value;
        
		if(document.getElementById('first_addr_line2') != null)
			document.getElementById('first_addr_line2').value = document.getElementById('r_addr_line2').value;

        if(document.getElementById('first_addr_line3') != null)
	        document.getElementById('first_addr_line3').value = document.getElementById('r_addr_line3').value;

        if(document.getElementById('first_addr_line4') != null)
		    document.getElementById('first_addr_line4').value = document.getElementById('r_addr_line4').value;

        if(document.getElementById('first_postal_code') != null)
			document.getElementById('first_postal_code').value = document.getElementById('r_postal_code').value;

		if(document.getElementById('first_postal_code1') != null)
			document.getElementById('first_postal_code1').value = document.getElementById('r_postal_code1').value;
		
		if(document.getElementById('contact2_res_town_code') != null)
            document.getElementById('contact2_res_town_code').value = document.getElementById('r_town_code').value;

		if(document.getElementById('f_town') != null)
            document.getElementById('f_town').value = document.getElementById('r_town').value;
		
		if(document.getElementById('contact2_region_code') != null)
            document.getElementById('contact2_region_code').value = document.getElementById('r_region_code').value;
		
		if(document.getElementById('f_region') != null)
            document.getElementById('f_region').value = document.getElementById('r_region').value;
		
		if(document.getElementById('contact2_res_area_code') != null)
            document.getElementById('contact2_res_area_code').value = document.getElementById('r_area_code').value;
		if(document.getElementById('f_area') != null)
            document.getElementById('f_area').value = document.getElementById('r_area').value;

        if(document.getElementById('first_country_code') != null)
			document.getElementById('first_country_code').value = document.getElementById('r_country_code').value;

		if(document.getElementById('first_country_desc') != null)
			document.getElementById('first_country_desc').value = document.getElementById('r_country_desc').value;

        if(document.getElementById('first_res_tel_no') != null)
			document.getElementById('first_res_tel_no').value = document.getElementById('contact1_no').value;
						
		if(document.getElementById('first_addr_line1') != null)
			document.getElementById('first_addr_line1').focus();		

		//** End of addition on 25/08/2003 for populating values from contact address(Residence) to First Notify **//
    }
	if(Val == 4)
	{
		/*if(document.getElementById("m_addr_line1") != null)
			document.getElementById("m_addr_line1").value = document.getElementById("r_addr_line1").value;     
		
		if(document.getElementById("m_addr_line2") != null)
	       document.getElementById("m_addr_line2").value = document.getElementById("r_addr_line2").value;       
		
		if(document.getElementById("m_addr_line3") != null)
	       document.getElementById("m_addr_line3").value = document.getElementById("r_addr_line3").value; */
		
		if(document.forms[0].m_addr_line1 != null)
			document.forms[0].m_addr_line1.value = document.forms[0].r_addr_line1.value;     
		
		if(document.forms[0].m_addr_line2 != null)
	       document.forms[0].m_addr_line2.value = document.forms[0].r_addr_line2.value;       
		
		if(document.forms[0].m_addr_line3 != null)
	       document.forms[0].m_addr_line3.value = document.forms[0].r_addr_line3.value;
		
		if(document.getElementById("m_addr_line4") != null)
	       document.getElementById("m_addr_line4").value = document.getElementById("r_addr_line4").value;        
		
		if(document.getElementById('m_postal_code') != null)
	       document.getElementById('m_postal_code').value = document.getElementById('r_postal_code').value;		

		if(document.getElementById('m_postal_code1') != null)
	       document.getElementById('m_postal_code1').value = document.getElementById('r_postal_code1').value;
		
		if(document.getElementById('m_town_code') != null)
	       document.getElementById('m_town_code').value = document.getElementById('r_town_code').value;	
		
		if(document.getElementById('m_town') != null)
	       document.getElementById('m_town').value = document.getElementById('r_town').value;	
		
		if(document.getElementById('m_region_code') != null)
	       document.getElementById('m_region_code').value = document.getElementById('r_region_code').value;	
		
		if(document.getElementById('m_region') != null)
	       document.getElementById('m_region').value = document.getElementById('r_region').value;		
		
		if( document.getElementById('m_area_code') != null)
	       document.getElementById('m_area_code').value = document.getElementById('r_area_code').value;	
		
		if(document.getElementById('m_area') != null)
	       document.getElementById('m_area').value = document.getElementById('r_area').value;     
		
		if(document.getElementById('m_country_code') != null)
	       document.getElementById('m_country_code').value = document.getElementById('r_country_code').value;
		
		if(document.getElementById('m_country_desc') != null)
		   document.getElementById('m_country_desc').value = document.getElementById('r_country_desc').value;
		
		if(document.getElementById('contact1_no') != null)
	       document.getElementById('contact1_no').value = document.getElementById('contact1_no').value;
		
		if(document.getElementById('contact2_no') != null)
		   document.getElementById('contact2_no').value = document.getElementById('contact2_no').value;
		
		if(document.getElementById('m_contact_name') != null)
		   document.getElementById('m_contact_name').value = document.getElementById('r_contact_name').value;

		if(document.getElementById('r_invalid_yn')){
			if(document.getElementById('r_invalid_yn').checked==true)
					document.getElementById('m_invalid_yn').checked=true;
			else
				document.getElementById('m_invalid_yn').checked=false;
		}
		
		
		
		if(document.getElementById('m_addr_line1') != null)
			document.getElementById('m_addr_line1').focus();
		   
	}
	if(Val == 5) //Copying the details from firsttonotify to nextofkin
	{
		if(document.getElementById('next_contact_name') != null)
			document.getElementById('next_contact_name').value = document.getElementById('first_contact_name').value;

		if(document.getElementById('next_contact_relation') != null)	
		{
			document.getElementById('next_contact_relation').value = document.getElementById('first_contact_relation').value;
			document.getElementById('next_contact_relation_desc').value = document.getElementById('first_contact_relation_desc').value;
		}

		if(document.getElementById('contact1_new_nat_id_no') != null)
			document.getElementById('contact1_new_nat_id_no').value = document.getElementById('contact2_nat_id_no').value;
		
		if(document.getElementById('contact1_oth_alt_id_type') != null)
			document.getElementById('contact1_oth_alt_id_type').value = document.getElementById('notify_oth_alt_id_type').value;
		
		if(document.getElementById('contact1_oth_alt_id_no') != null)
		{
			document.getElementById('contact1_oth_alt_id_no').value = document.getElementById('notify_oth_alt_id_text').value;
			document.getElementById('contact1_oth_alt_id_no').disabled=false;
		}
		if(document.getElementById('next_job_title') != null)
			document.getElementById('next_job_title').value = document.getElementById('first_job_title').value;
		
		if(document.getElementById('next_res_tel_no') != null)
			document.getElementById('next_res_tel_no').value = document.getElementById('first_res_tel_no').value;
		
		if(document.getElementById('contact1_mob_tel_no') != null)
			document.getElementById('contact1_mob_tel_no').value = document.getElementById('contact2_mob_tel_no').value;
		
		if(document.getElementById('next_off_tel_no') != null)
			document.getElementById('next_off_tel_no').value = document.getElementById('first_off_tel_no').value;
		
		if(document.getElementById('contact1_email_id') != null)
			document.getElementById('contact1_email_id').value = document.getElementById('contact2_email_id').value;
		
		if(document.getElementById('next_addr_line1') != null)
			document.getElementById('next_addr_line1').value = document.getElementById('first_addr_line1').value;

		if(document.getElementById('next_addr_line2') != null)
			document.getElementById('next_addr_line2').value = document.getElementById('first_addr_line2').value;	

		if(document.getElementById('next_addr_line3') != null)
			document.getElementById('next_addr_line3').value = document.getElementById('first_addr_line3').value;

		if(document.getElementById('next_addr_line4') != null)
			document.getElementById('next_addr_line4').value = document.getElementById('first_addr_line4').value;

		if(document.getElementById('contact1_res_town_code') != null)
			document.getElementById('contact1_res_town_code').value = document.getElementById('contact2_res_town_code').value;

		if(document.getElementById('contact1_region_code') != null)
			document.getElementById('contact1_region_code').value = document.getElementById('contact2_region_code').value; 

		if(document.getElementById('contact1_res_area_code') != null)
			document.getElementById('contact1_res_area_code').value = document.getElementById('contact2_res_area_code').value;

		if(document.getElementById('next_postal_code') != null)
			document.getElementById('next_postal_code').value = document.getElementById('first_postal_code').value;

		if(document.getElementById('next_postal_code1') != null)
			document.getElementById('next_postal_code1').value = document.getElementById('first_postal_code1').value;

		if(document.getElementById('next_country_desc') != null)
			document.getElementById('next_country_desc').value = document.getElementById('first_country_desc').value;

		if(document.getElementById('next_country_code') != null)
			document.getElementById('next_country_code').value = document.getElementById('first_country_code').value;
	
		if(document.getElementById('n_area') != null)
			document.getElementById('n_area').value = document.getElementById('f_area').value;
	
		if(document.getElementById('n_region') != null)
			document.getElementById('n_region').value = document.getElementById('f_region').value;

		if(document.getElementById('n_town') != null)
			document.getElementById('n_town').value = document.getElementById('f_town').value;
	}
	if(Val == 6)
	{
			  
       /*Below line added for ML-MMOH-CRF-0860.2*/
		/*if(document.getElementById('first_contact_name') != null){
		    if(document.getElementById('next_contact_name').value.length>30){			 
			   document.getElementById('first_contact_name').value = document.getElementById('next_contact_name').value.substring(0,30);
			}else{*/
			   document.getElementById('first_contact_name').value = document.getElementById('next_contact_name').value;
			/*}
		}*/
        //End ML-MMOH-CRF-0860.2 		
	
		if(document.getElementById('first_contact_relation') != null)
		{
			document.getElementById('first_contact_relation').value = document.getElementById('next_contact_relation').value;
			document.getElementById('first_contact_relation_desc').value = document.getElementById('next_contact_relation_desc').value;

		}


		if(document.getElementById('contact2_nat_id_no') != null)
		document.getElementById('contact2_nat_id_no').value = document.getElementById('contact1_new_nat_id_no').value;
	
		if(document.getElementById('notify_oth_alt_id_type') != null)
			document.getElementById('notify_oth_alt_id_type').value = document.getElementById('contact1_oth_alt_id_type').value;
		
		if(document.getElementById('notify_oth_alt_id_text') != null)
		{
			document.getElementById('notify_oth_alt_id_text').value = document.getElementById('contact1_oth_alt_id_no').value;
			document.getElementById('notify_oth_alt_id_text').disabled=false;
		}
		if(document.getElementById('first_job_title') != null)
			document.getElementById('first_job_title').value = document.getElementById('next_job_title').value;

		if(document.getElementById('first_res_tel_no') != null)
			document.getElementById('first_res_tel_no').value = document.getElementById('next_res_tel_no').value;
	
		if(document.getElementById('contact2_mob_tel_no') != null)
			document.getElementById('contact2_mob_tel_no').value = document.getElementById('contact1_mob_tel_no').value;

		if(document.getElementById('first_off_tel_no') != null)
			document.getElementById('first_off_tel_no').value = document.getElementById('next_off_tel_no').value;
	
		if(document.getElementById('contact2_email_id') != null)
			document.getElementById('contact2_email_id').value = document.getElementById('contact1_email_id').value;

		if(document.getElementById('first_addr_line1') != null)
			document.getElementById('first_addr_line1').value = document.getElementById('next_addr_line1').value;

		if(document.getElementById('first_addr_line2') != null)
			document.getElementById('first_addr_line2').value = document.getElementById('next_addr_line2').value;	

		if(document.getElementById('first_addr_line3') != null)
			document.getElementById('first_addr_line3').value = document.getElementById('next_addr_line3').value;

		if(document.getElementById('first_addr_line4') != null)
			document.getElementById('first_addr_line4').value = document.getElementById('next_addr_line4').value;

		if(document.getElementById('contact2_res_town_code') != null)
			document.getElementById('contact2_res_town_code').value = document.getElementById('contact1_res_town_code').value;

		if(document.getElementById('contact2_region_code') != null)
			document.getElementById('contact2_region_code').value = document.getElementById('contact1_region_code').value; 

		if(document.getElementById('contact2_res_area_code') != null)
			document.getElementById('contact2_res_area_code').value = document.getElementById('contact1_res_area_code').value;

		if(document.getElementById('first_postal_code') != null)
			document.getElementById('first_postal_code').value = document.getElementById('next_postal_code').value;

		if(document.getElementById('first_postal_code1') != null)
			document.getElementById('first_postal_code1').value = document.getElementById('next_postal_code1').value;

		if(document.getElementById('first_country_desc') != null)
			document.getElementById('first_country_desc').value = document.getElementById('next_country_desc').value;
	
		if(document.getElementById('first_country_code') != null)
			document.getElementById('first_country_code').value = document.getElementById('next_country_code').value;

		if(document.getElementById('f_area') != null)
			document.getElementById('f_area').value = document.getElementById('n_area').value;

		if(document.getElementById('f_region') != null)
			document.getElementById('f_region').value = document.getElementById('n_region').value;

		if(document.getElementById('f_town') != null)
			document.getElementById('f_town').value = document.getElementById('n_town').value;
	}
	
	if(Val == 7)
	{ 
		if(document.getElementById('m_addr_line1') != null)
			document.getElementById('m_addr_line1').value = document.getElementById('a_addr_line1').value;     
		
		if(document.getElementById('m_addr_line2') != null)
	       document.getElementById('m_addr_line2').value = document.getElementById('a_addr_line2').value;       
		
		if(document.getElementById('m_addr_line3') != null)
	       document.getElementById('m_addr_line3').value = document.getElementById('a_addr_line3').value;       
		
		if(document.getElementById('m_addr_line4') != null)
	       document.getElementById('m_addr_line4').value = document.getElementById('a_addr_line4').value;        
		
		if(document.getElementById('m_postal_code') != null)
	       document.getElementById('m_postal_code').value = document.getElementById('alt_postal_code').value;	

		if(document.getElementById('m_postal_code1') != null)
	       document.getElementById('m_postal_code1').value = document.getElementById('alt_postal_code1').value;
		
		if(document.getElementById('m_town_code') != null)
	       document.getElementById('m_town_code').value = document.getElementById('a_town_code').value;	
		
		if(document.getElementById('m_town') != null)
	       document.getElementById('m_town').value = document.getElementById('a_town').value;	
		
		if(document.getElementById('m_region_code') != null)
	       document.getElementById('m_region_code').value = document.getElementById('a_region_code').value;	
		
		if(document.getElementById('m_region') != null)
	       document.getElementById('m_region').value = document.getElementById('a_region').value;	
		
		if( document.getElementById('m_area_code') != null)
	      document.getElementById('m_area_code').value = document.getElementById('a_area_code').value;	
		
		if(document.getElementById('m_area') != null)
	       document.getElementById('m_area').value = document.getElementById('a_area').value;    
		
		if(document.getElementById('m_country_code') != null)
	       document.getElementById('m_country_code').value = document.getElementById('a_country_code').value;
		
		if(document.getElementById('m_country_desc') != null)
		   document.getElementById('m_country_desc').value = document.getElementById('a_country_desc').value;	
		
		if(document.getElementById('m_contact_name') != null)
		   document.getElementById('m_contact_name').value = document.getElementById('a_contact_name').value;

		if(document.getElementById('a_invalid_yn')){
			if(document.getElementById('a_invalid_yn').checked==true)
					document.getElementById('m_invalid_yn').checked=true;
			else
				document.getElementById('m_invalid_yn').checked=false;
		}
		
		
		if(document.getElementById('m_addr_line1') != null)
			document.getElementById('m_addr_line1').focus();
		   
	}
    //Below added by Suji keerthi for ML-MMOH-CRF-1527 US008
   //Below Added on 24/07/2020 for populating values from contact address(Residence & Mailing) to Next of kin fields---->(Copy Patient Address)
	if(Val == 8)
    {
		if(document.getElementById('next_addr_line1') != null)
		    document.getElementById('next_addr_line1').value = document.getElementById('r_addr_line1').value;

		 if(document.getElementById('next_addr_line2') != null)
		    document.getElementById('next_addr_line2').value = document.getElementById('r_addr_line2').value;

		 if(document.getElementById('next_addr_line3') != null)
		    document.getElementById('next_addr_line3').value = document.getElementById('r_addr_line3').value;

		 if(document.getElementById('next_addr_line4') != null)
		    document.getElementById('next_addr_line4').value = document.getElementById('r_addr_line4').value;
        
		 if(document.getElementById('contact1_res_town_code') != null)
		    document.getElementById('contact1_res_town_code').value = document.getElementById('r_town_code').value;

		 if(document.getElementById('n_town') != null)
            document.getElementById('n_town').value = document.getElementById('r_town').value;

		 if(document.getElementById('contact1_region_code') != null)
		    document.getElementById('contact1_region_code').value = document.getElementById('r_region_code').value;

		 if(document.getElementById('n_region') != null)
            document.getElementById('n_region').value = document.getElementById('r_region').value;

		 if(document.getElementById('contact1_res_area_code') != null)
		    document.getElementById('contact1_res_area_code').value = document.getElementById('r_area_code').value;

		 if(document.getElementById('n_area') != null)
            document.getElementById('n_area').value = document.getElementById('r_area').value;

		 if(document.getElementById('next_postal_code') != null)
		    document.getElementById('next_postal_code').value = document.getElementById('r_postal_code').value;

		 if(document.getElementById('next_postal_code1') != null)
	        document.getElementById('next_postal_code1').value = document.getElementById('r_postal_code1').value;

		 if(document.getElementById('next_country_code') != null)
		    document.getElementById('next_country_code').value = document.getElementById('r_country_code').value;
		
		if(document.getElementById('next_country_desc') != null)
			document.getElementById('next_country_desc').value = document.getElementById('r_country_desc').value;

		if(document.getElementById('ra_contact_name') != null)
		   document.getElementById('ra_contact_name').value = document.getElementById('r_contact_name').value;

        if(document.getElementById('n_next_addr_line1') != null)
		    document.getElementById('n_next_addr_line1').value = document.getElementById('m_addr_line1').value;

		 if(document.getElementById('n_ma_addr_line2') != null)
		    document.getElementById('n_ma_addr_line2').value = document.getElementById('m_addr_line2').value;

		 if(document.getElementById('n_ma_addr_line3') != null)
		    document.getElementById('n_ma_addr_line3').value = document.getElementById('m_addr_line3').value;

		 if(document.getElementById('n_ma_addr_line4') != null)
		    document.getElementById('n_ma_addr_line4').value = document.getElementById('m_addr_line4').value;
        
		 if(document.getElementById('n_contact_ma_town_code') != null)
		    document.getElementById('n_contact_ma_town_code').value = document.getElementById('m_town_code').value;

		 if(document.getElementById('nkma_town') != null)
            document.getElementById('nkma_town').value = document.getElementById('m_town').value;

		 if(document.getElementById('n_contac_region_code') != null)
		    document.getElementById('n_contac_region_code').value = document.getElementById('m_region_code').value;

		 if(document.getElementById('contact1_region') != null)
            document.getElementById('contact1_region').value = document.getElementById('m_region').value;

		 if(document.getElementById('n_contact_ma_area_code') != null)
		    document.getElementById('n_contact_ma_area_code').value = document.getElementById('m_area_code').value;

		 if(document.getElementById('nkma_area') != null)
            document.getElementById('nkma_area').value = document.getElementById('m_area').value;

		 if(document.getElementById('n_ma_postal_code') != null)
		    document.getElementById('n_ma_postal_code').value = document.getElementById('m_postal_code').value;

		  if(document.getElementById('n_ma_postal_code1') != null)
	        document.getElementById('n_ma_postal_code1').value = document.getElementById('m_postal_code1').value;

		  if(document.getElementById('nkin_mail_country_code') != null)
		    document.getElementById('nkin_mail_country_code').value = document.getElementById('m_country_code').value;
		
		if(document.getElementById('nk_ma_country_desc') != null)
			document.getElementById('nk_ma_country_desc').value = document.getElementById('m_country_desc').value;
     
	    if(document.getElementById('ma_contact_name') != null)
		   document.getElementById('ma_contact_name').value = document.getElementById('m_contact_name').value;

		
	}
	//Ended for populating values from contact address(Residence & Mailing) to Next of kin fields---->(Copy Patient Address)
	//Below Added on 24/07/2020 for populating values from Related contacts,Next of kin(Residence) to Related contacts,Next of kin(Mailing)---->(Copy Residence Address)
	if(Val == 9)
    {
        if(document.getElementById('n_next_addr_line1') != null)
		    document.getElementById('n_next_addr_line1').value = document.getElementById('next_addr_line1').value;

		if(document.getElementById('n_ma_addr_line2') != null)
		    document.getElementById('n_ma_addr_line2').value = document.getElementById('next_addr_line2').value;

		if(document.getElementById('n_ma_addr_line3') != null)
		    document.getElementById('n_ma_addr_line3').value = document.getElementById('next_addr_line3').value;

		if(document.getElementById('n_ma_addr_line4') != null)
		    document.getElementById('n_ma_addr_line4').value = document.getElementById('next_addr_line4').value;

		if(document.getElementById('n_contact_ma_town_code') != null)
		    document.getElementById('n_contact_ma_town_code').value = document.getElementById('contact1_res_town_code').value;

		if(document.getElementById('nkma_town') != null)
            document.getElementById('nkma_town').value = document.getElementById('n_town').value;

		if(document.getElementById('n_contac_region_code') != null)
		    document.getElementById('n_contac_region_code').value = document.getElementById('contact1_region_code').value;

		if(document.getElementById('contact1_region') != null)
            document.getElementById('contact1_region').value = document.getElementById('n_region').value;

		if(document.getElementById('n_contact_ma_area_code') != null)
		    document.getElementById('n_contact_ma_area_code').value = document.getElementById('contact1_res_area_code').value;

		if(document.getElementById('nkma_area') != null)
            document.getElementById('nkma_area').value = document.getElementById('n_area').value;

		if(document.getElementById('n_ma_postal_code') != null)
		    document.getElementById('n_ma_postal_code').value = document.getElementById('next_postal_code').value;

		if(document.getElementById('n_ma_postal_code1') != null)
	        document.getElementById('n_ma_postal_code1').value = document.getElementById('next_postal_code1').value;
		
		if(document.getElementById('nkin_mail_country_code') != null)
		    document.getElementById('nkin_mail_country_code').value = document.getElementById('next_country_code').value;
		
		if(document.getElementById('nk_ma_country_desc') != null)
			document.getElementById('nk_ma_country_desc').value = document.getElementById('next_country_desc').value;
     
	    if(document.getElementById('ma_contact_name') != null)
		   document.getElementById('ma_contact_name').value = document.getElementById('ra_contact_name').value;

	}
	//Ended for populating values from Related contacts(Residence) to Related contacts(Mailing)---->(Copy Residence Address)
	//Below Added on 24/07/2020 for populating values from First To Notify(Residence & Mailing) to Next of kin fields---->(Copy First To Notify)
	if(Val == 10)
	{
        if(document.getElementById('next_addr_line1') != null)
		    document.getElementById('next_addr_line1').value = document.getElementById('first_addr_line1').value;

		 if(document.getElementById('next_addr_line2') != null)
		    document.getElementById('next_addr_line2').value = document.getElementById('first_addr_line2').value;

		 if(document.getElementById('next_addr_line3') != null)
		    document.getElementById('next_addr_line3').value = document.getElementById('first_addr_line3').value;

		 if(document.getElementById('next_addr_line4') != null)
		    document.getElementById('next_addr_line4').value = document.getElementById('first_addr_line4').value;
        
		 if(document.getElementById('contact1_res_town_code') != null)
		    document.getElementById('contact1_res_town_code').value = document.getElementById('contact2_res_town_code').value;

		 if(document.getElementById('n_town') != null)
            document.getElementById('n_town').value = document.getElementById('f_town').value;

		 if(document.getElementById('contact1_region_code') != null)
		    document.getElementById('contact1_region_code').value = document.getElementById('contact2_region_code').value;

		 if(document.getElementById('n_region') != null)
            document.getElementById('n_region').value = document.getElementById('f_region').value;

		 if(document.getElementById('contact1_res_area_code') != null)
		    document.getElementById('contact1_res_area_code').value = document.getElementById('contact2_res_area_code').value;

		 if(document.getElementById('n_area') != null)
            document.getElementById('n_area').value = document.getElementById('f_area').value;

		 if(document.getElementById('next_postal_code') != null)
		    document.getElementById('next_postal_code').value = document.getElementById('first_postal_code').value; 

		 if(document.getElementById('next_postal_code1') != null)
			document.getElementById('next_postal_code1').value = document.getElementById('first_postal_code1').value;

		if(document.getElementById('next_country_code') != null)
		    document.getElementById('next_country_code').value = document.getElementById('first_country_code').value;
		
		if(document.getElementById('next_country_desc') != null)
			document.getElementById('next_country_desc').value = document.getElementById('first_country_desc').value;

		if(document.getElementById('ra_contact_name') != null)
		   document.getElementById('ra_contact_name').value = document.getElementById('fton_ra_contact_name').value;


		if(document.getElementById('n_next_addr_line1') != null)
		    document.getElementById('n_next_addr_line1').value = document.getElementById('fton_mail_addr_line1').value;

		 if(document.getElementById('n_ma_addr_line2') != null)
		    document.getElementById('n_ma_addr_line2').value = document.getElementById('fton_mail_addr_line2').value;

		 if(document.getElementById('n_ma_addr_line3') != null)
		    document.getElementById('n_ma_addr_line3').value = document.getElementById('fton_mail_addr_line3').value;

		 if(document.getElementById('n_ma_addr_line4') != null)
		    document.getElementById('n_ma_addr_line4').value = document.getElementById('fton_mail_addr_line4').value;
        
		 if(document.getElementById('n_contact_ma_town_code') != null)
		    document.getElementById('n_contact_ma_town_code').value = document.getElementById('fst_to_no_ma_town_code').value;

		 if(document.getElementById('nkma_town') != null)
            document.getElementById('nkma_town').value = document.getElementById('contact2_res_town').value;

		 if(document.getElementById('n_contac_region_code') != null)
		    document.getElementById('n_contac_region_code').value = document.getElementById('fst_to_no_ma_reg_cod').value;

		 if(document.getElementById('contact1_region') != null)
            document.getElementById('contact1_region').value = document.getElementById('contact2_region').value;

		 if(document.getElementById('n_contact_ma_area_code') != null)
		    document.getElementById('n_contact_ma_area_code').value = document.getElementById('fst_to_no_ma_area_code').value;

		  if(document.getElementById('nkma_area') != null)
            document.getElementById('nkma_area').value = document.getElementById('contact2_res_area').value;

		 if(document.getElementById('n_ma_postal_code') != null)
		    document.getElementById('n_ma_postal_code').value = document.getElementById('fst_no_ma_pos_cod').value;

		 if(document.getElementById('n_ma_postal_code1') != null)
		    document.getElementById('n_ma_postal_code1').value = document.getElementById('fst_no_ma_pos_cod1').value;

		if(document.getElementById('nkin_mail_country_code') != null)
		    document.getElementById('nkin_mail_country_code').value = document.getElementById('first_mail_country_code').value;
		
		if(document.getElementById('nk_ma_country_desc') != null)
			document.getElementById('nk_ma_country_desc').value = document.getElementById('first_mail_country_desc').value;
     
	    if(document.getElementById('ma_contact_name') != null)
		   document.getElementById('ma_contact_name').value = document.getElementById('fton_ma_contact_name').value;
	}
	//Ended for populating values from First To Notify(Residence & Mailing) to Next of kin fields---->(Copy First To Notify)
	//Below Added on 24/07/2020 for populating values from contact address(Residence & Mailing) to First To Notify fields---->(Copy Patient Address)
	if(Val == 11)
	{
        if(document.getElementById('first_addr_line1') != null)
		    document.getElementById('first_addr_line1').value = document.getElementById('r_addr_line1').value;

		 if(document.getElementById('first_addr_line2') != null)
		    document.getElementById('first_addr_line2').value = document.getElementById('r_addr_line2').value;

		 if(document.getElementById('first_addr_line3') != null)
		    document.getElementById('first_addr_line3').value = document.getElementById('r_addr_line3').value;

		 if(document.getElementById('first_addr_line4') != null)
		    document.getElementById('first_addr_line4').value = document.getElementById('r_addr_line4').value;
        
		 if(document.getElementById("contact2_res_town_code") != null)
		    document.getElementById("contact2_res_town_code").value = document.getElementById("r_town_code").value;

		 if(document.getElementById('f_town') != null)
            document.getElementById('f_town').value = document.getElementById('r_town').value;

		 if(document.getElementById('contact2_region_code') != null)
		    document.getElementById('contact2_region_code').value = document.getElementById('r_region_code').value;

		 if(document.getElementById('f_region') != null)
            document.getElementById('f_region').value = document.getElementById('r_region').value;

		 if(document.getElementById('contact2_res_area_code') != null)
		    document.getElementById('contact2_res_area_code').value = document.getElementById('r_area_code').value;

		  if(document.getElementById('f_area') != null)
            document.getElementById('f_area').value = document.getElementById('r_area').value;

		 if(document.getElementById('first_postal_code') != null)
		    document.getElementById('first_postal_code').value = document.getElementById('r_postal_code').value;

		  if(document.getElementById('first_postal_code1') != null)
	        document.getElementById('first_postal_code1').value = document.getElementById('r_postal_code1').value;
		
		if(document.getElementById('first_country_code') != null)
		    document.getElementById('first_country_code').value = document.getElementById('r_country_code').value;
		
		if(document.getElementById('first_country_desc') != null)
			document.getElementById('first_country_desc').value = document.getElementById('r_country_desc').value;

		if(document.getElementById('fton_ra_contact_name') != null)
		   document.getElementById('fton_ra_contact_name').value = document.getElementById('r_contact_name').value;


        if(document.getElementById('fton_mail_addr_line1') != null)
		    document.getElementById('fton_mail_addr_line1').value = document.getElementById('m_addr_line1').value;

		 if(document.getElementById('fton_mail_addr_line2') != null)
		    document.getElementById('fton_mail_addr_line2').value = document.getElementById('m_addr_line2').value;

		 if(document.getElementById('fton_mail_addr_line3') != null)
		    document.getElementById('fton_mail_addr_line3').value = document.getElementById('m_addr_line3').value;

		 if(document.getElementById('fton_mail_addr_line4') != null)
		    document.getElementById('fton_mail_addr_line4').value = document.getElementById('m_addr_line4').value;
        
		 if(document.getElementById('fst_to_no_ma_town_code') != null)
		    document.getElementById('fst_to_no_ma_town_code').value = document.getElementById('m_town_code').value;

		 if(document.getElementById('contact2_res_town') != null)
            document.getElementById('contact2_res_town').value = document.getElementById('m_town').value;

		 if(document.getElementById('fst_to_no_ma_reg_cod') != null)
		    document.getElementById('fst_to_no_ma_reg_cod').value = document.getElementById('m_region_code').value;

		 if(document.getElementById('contact2_region') != null)
            document.getElementById('contact2_region').value = document.getElementById('m_region').value;

		 if(document.getElementById('fst_to_no_ma_area_code') != null)
		    document.getElementById('fst_to_no_ma_area_code').value = document.getElementById('m_area_code').value;

		 if(document.getElementById('contact2_res_area') != null)
            document.getElementById('contact2_res_area').value = document.getElementById('m_area').value;

		 if(document.getElementById('fst_no_ma_pos_cod') != null)
		    document.getElementById('fst_no_ma_pos_cod').value = document.getElementById('m_postal_code').value;

		 if(document.getElementById('fst_no_ma_pos_cod1') != null)
	        document.getElementById('fst_no_ma_pos_cod1').value = document.getElementById('m_postal_code1').value;

		if(document.getElementById('first_mail_country_code') != null)
		    document.getElementById('first_mail_country_code').value = document.getElementById('m_country_code').value;
		
		if(document.getElementById('first_mail_country_desc') != null)
			document.getElementById('first_mail_country_desc').value = document.getElementById('m_country_desc').value;
     
	    if(document.getElementById('fton_ma_contact_name') != null)
		   document.getElementById('fton_ma_contact_name').value = document.getElementById('m_contact_name').value;
	}
	//Ended for populating values from contact address(Residence & Mailing) to First To Notify fields---->(Copy Patient Address)
	//Below Added on 24/07/2020 for populating values from Related contacts,First To Notify(Residence) to Related contacts,First To Notify(Mailing)---->(Copy Residence Address)
	if(Val == 12)
    {
        if(document.getElementById('fton_mail_addr_line1') != null)
		    document.getElementById('fton_mail_addr_line1').value = document.getElementById('first_addr_line1').value;

		if(document.getElementById('fton_mail_addr_line2') != null)
		    document.getElementById('fton_mail_addr_line2').value = document.getElementById('first_addr_line2').value;

		if(document.getElementById('fton_mail_addr_line3') != null)
		    document.getElementById('fton_mail_addr_line3').value = document.getElementById('first_addr_line3').value;

		if(document.getElementById('fton_mail_addr_line4') != null)
		    document.getElementById('fton_mail_addr_line4').value = document.getElementById('first_addr_line4').value;

		if(document.getElementById('fst_to_no_ma_town_code') != null)
		    document.getElementById('fst_to_no_ma_town_code').value = document.getElementById('contact2_res_town_code').value;

		if(document.getElementById('contact2_res_town') != null)
            document.getElementById('contact2_res_town').value = document.getElementById('f_town').value;

		if(document.getElementById('fst_to_no_ma_reg_cod') != null)
		    document.getElementById('fst_to_no_ma_reg_cod').value = document.getElementById('contact2_region_code').value;

		if(document.getElementById('contact2_region') != null)
            document.getElementById('contact2_region').value = document.getElementById('f_region').value;

		if(document.getElementById('fst_to_no_ma_area_code') != null)
		    document.getElementById('fst_to_no_ma_area_code').value = document.getElementById('contact2_res_area_code').value;

		if(document.getElementById('contact2_res_area') != null)
            document.getElementById('contact2_res_area').value = document.getElementById('f_area').value;

		if(document.getElementById('fst_no_ma_pos_cod') != null)
		    document.getElementById('fst_no_ma_pos_cod').value = document.getElementById('first_postal_code').value;

		if(document.getElementById('fst_no_ma_pos_cod1') != null)
	        document.getElementById('fst_no_ma_pos_cod1').value = document.getElementById('first_postal_code1').value;
		
		if(document.getElementById('first_mail_country_code') != null)
		    document.getElementById('first_mail_country_code').value = document.getElementById('first_country_code').value;
		
		if(document.getElementById('first_mail_country_desc') != null)
			document.getElementById('first_mail_country_desc').value = document.getElementById('first_country_desc').value;
     
	    if(document.getElementById('fton_ma_contact_name') != null)
		   document.getElementById('fton_ma_contact_name').value = document.getElementById('fton_ra_contact_name').value;

	}
	//Ended for populating values from Related contacts(Residence) to Related contacts(Mailing)---->(Copy Residence Address)
	//Below Added on 24/07/2020 for populating values from Next of kin(Residence & Mailing) to First To Notify fields---->(Copy Next of Kin)
	if(Val == 13)
	{
        if(document.getElementById('first_addr_line1') != null)
		    document.getElementById('first_addr_line1').value = document.getElementById('next_addr_line1').value;

		 if(document.getElementById('first_addr_line2') != null)
		    document.getElementById('first_addr_line2').value = document.getElementById('next_addr_line2').value;

		 if(document.getElementById('first_addr_line3') != null)
		    document.getElementById('first_addr_line3').value = document.getElementById('next_addr_line3').value;

		 if(document.getElementById('first_addr_line4') != null)
		    document.getElementById('first_addr_line4').value = document.getElementById('next_addr_line4').value;
        
		 if(document.getElementById('contact2_res_town_code') != null)
		    document.getElementById('contact2_res_town_code').value = document.getElementById('contact1_res_town_code').value;

		 if(document.getElementById('f_town') != null)
            document.getElementById('f_town').value = document.getElementById('n_town').value;

		 if(document.getElementById('contact2_region_code') != null)
		    document.getElementById('contact2_region_code').value = document.getElementById('contact1_region_code').value;

		  if(document.getElementById('f_region') != null)
            document.getElementById('f_region').value = document.getElementById('n_region').value;

		 if(document.getElementById('contact2_res_area_code') != null)
		    document.getElementById('contact2_res_area_code').value = document.getElementById('contact1_res_area_code').value;

		  if(document.getElementById('f_area') != null)
            document.getElementById('f_area').value = document.getElementById('n_area').value;

		 if(document.getElementById('first_postal_code') != null)
		    document.getElementById('first_postal_code').value = document.getElementById('next_postal_code').value;

		 if(document.getElementById('first_postal_code1') != null)
		    document.getElementById('first_postal_code1').value = document.getElementById('next_postal_code1').value;
		
		if(document.getElementById('first_country_code') != null)
		    document.getElementById('first_country_code').value = document.getElementById('next_country_code').value;
		
		if(document.getElementById('first_country_desc') != null)
			document.getElementById('first_country_desc').value = document.getElementById('next_country_desc').value;

		if(document.getElementById('fton_ra_contact_name') != null)
		   document.getElementById('fton_ra_contact_name').value = document.getElementById('ra_contact_name').value;


         if(document.getElementById('fton_mail_addr_line1') != null)
		    document.getElementById('fton_mail_addr_line1').value = document.getElementById('n_next_addr_line1').value;

		 if(document.getElementById('fton_mail_addr_line2') != null)
		    document.getElementById('fton_mail_addr_line2').value = document.getElementById('n_ma_addr_line2').value;

		 if(document.getElementById('fton_mail_addr_line3') != null)
		    document.getElementById('fton_mail_addr_line3').value = document.getElementById('n_ma_addr_line3').value;

		 if(document.getElementById('fton_mail_addr_line4') != null)
		    document.getElementById('fton_mail_addr_line4').value = document.getElementById('n_ma_addr_line4').value;
        
		 if(document.getElementById('fst_to_no_ma_town_code') != null)
		    document.getElementById('fst_to_no_ma_town_code').value = document.getElementById('n_contact_ma_town_code').value;

		 if(document.getElementById('contact2_res_town') != null)
            document.getElementById('contact2_res_town').value = document.getElementById('nkma_town').value;

		 if(document.getElementById('fst_to_no_ma_reg_cod') != null)
		    document.getElementById('fst_to_no_ma_reg_cod').value = document.getElementById('n_contac_region_code').value;

		  if(document.getElementById('contact2_region') != null)
            document.getElementById('contact2_region').value = document.getElementById('contact1_region').value;

		 if(document.getElementById('fst_to_no_ma_area_code') != null)
		    document.getElementById('fst_to_no_ma_area_code').value = document.getElementById('n_contact_ma_area_code').value;

		 if(document.getElementById('contact2_res_area') != null)
            document.getElementById('contact2_res_area').value = document.getElementById('nkma_area').value;

		 if(document.getElementById('fst_no_ma_pos_cod') != null)
		    document.getElementById('fst_no_ma_pos_cod').value = document.getElementById('n_ma_postal_code').value;

		 if(document.getElementById('fst_no_ma_pos_cod1') != null)
		    document.getElementById('fst_no_ma_pos_cod1').value = document.getElementById('n_ma_postal_code1').value;
		
		if(document.getElementById('first_mail_country_code') != null)
		    document.getElementById('first_mail_country_code').value = document.getElementById('nkin_mail_country_code').value;
		
		if(document.getElementById('first_mail_country_desc') != null)
			document.getElementById('first_mail_country_desc').value = document.getElementById('nk_ma_country_desc').value;
     
	    if(document.getElementById('fton_ma_contact_name') != null)
		   document.getElementById('fton_ma_contact_name').value = document.getElementById('ma_contact_name').value;
	}
	//Ended for populating values from Next of kin(Residence & Mailing) to First To Notify fields---->(Copy Next of Kin)
	//Ended by Suji keerthi for ML-MMOH-CRF-1527 US008
	
	
}
// ***********************************************************************
function enableContactNo(obj)   {

    if ( obj == document.getElementById('contact3_mode') )
    {
   		document.getElementById('contact3_no').value = "";
		if ( document.getElementById('contact3_mode').value != '' )
        {    
		document.getElementById('contact3_no').disabled = false;
		document.getElementById('contact3_no').focus();
		}
        if ( document.getElementById('contact3_mode').value == '')
        {
           	document.getElementById('contact3_no').disabled = true;
            document.getElementById('contact3_no').value = ''
			document.getElementById('contact4_mode').focus();
	   }
    }

    if(obj == document.getElementById('contact4_mode'))
    {
		document.getElementById('contact4_no').value = "";
		if(document.getElementById('contact4_mode').value != '')
		{ 
		   document.getElementById('contact4_no').disabled = false;
		    document.getElementById('contact4_no').focus();
		}
        else if(document.getElementById('contact4_mode').value == '')
        {
			document.getElementById('contact4_no').disabled = true;
			document.getElementById('contact4_no').value = ''
			document.getElementById('contact5_mode').focus();
        }
    }

    if(obj == document.getElementById('contact5_mode'))
    {
		document.getElementById('contact5_no').value = "";
		if(document.getElementById('contact5_mode').value != '')
		{
            document.getElementById('contact5_no').disabled = false;
			document.getElementById('contact5_no').focus();
		}
        else if(document.getElementById('contact5_mode').value == '')
        {
            document.getElementById('contact5_no').disabled = true;
            document.getElementById('contact5_no').value = '';
			if(document.getElementById('r_addr_line1'))
				document.getElementById('r_addr_line1').focus();
        }
    }
    //Below added by Suji keerthi for ML-MMOH-CRF-1527 US008
	if ( obj == document.getElementById('nk_contact3_mode') )
    {
   		document.getElementById('nk_contact3_no').value = "";
		if ( document.getElementById('nk_contact3_mode').value != '' )
        {    
		document.getElementById('nk_contact3_no').disabled = false;
		document.getElementById('nk_contact3_no').focus();
		}
        if ( document.getElementById('nk_contact3_mode').value == '')
        {
           	document.getElementById('nk_contact3_no').disabled = true;
            document.getElementById('nk_contact3_no').value = ''
			document.getElementById('nk_contact4_mode').focus();
	   }
    }

	if(obj == document.getElementById('nk_contact4_mode'))
    {
		document.getElementById('nk_contact4_no').value = "";
		if(document.getElementById('nk_contact4_mode').value != '')
		{ 
		   document.getElementById('nk_contact4_no').disabled = false;
		    document.getElementById('nk_contact4_no').focus();
		}
        else if(document.getElementById('nk_contact4_mode').value == '')
        {
			document.getElementById('nk_contact4_no').disabled = true;
			document.getElementById('nk_contact4_no').value = ''
			document.getElementById('nk_contact5_mode').focus();
        }
    }

	 if(obj == document.getElementById('nk_contact5_mode'))
    {
		document.getElementById('nk_contact5_no').value = "";
		if(document.getElementById('nk_contact5_mode').value != '')
		{
            document.getElementById('nk_contact5_no').disabled = false;
			document.getElementById('nk_contact5_no').focus();
		}
        else if(document.getElementById('nk_contact5_mode').value == '')
        {
            document.getElementById('nk_contact5_no').disabled = true;
            document.getElementById('nk_contact5_no').value = '';
        }
    }

	if ( obj == document.getElementById('fton_contact3_mode') )
    {
   		document.getElementById('fton_contact3_no').value = "";
		if ( document.getElementById('fton_contact3_mode').value != '' )
        {    
		document.getElementById('fton_contact3_no').disabled = false;
		document.getElementById('fton_contact3_no').focus();
		}
        if ( document.getElementById('fton_contact3_mode').value == '')
        {
           	document.getElementById('fton_contact3_no').disabled = true;
            document.getElementById('fton_contact3_no').value = ''
			document.getElementById('fton_contact4_mode').focus();
	   }
    }

	if(obj == document.getElementById('fton_contact4_mode'))
    {
		document.getElementById('fton_contact4_no').value = "";
		if(document.getElementById('fton_contact4_mode').value != '')
		{ 
		   document.getElementById('fton_contact4_no').disabled = false;
		    document.getElementById('fton_contact4_no').focus();
		}
        else if(document.getElementById('fton_contact4_mode').value == '')
        {
			document.getElementById('fton_contact4_no').disabled = true;
			document.getElementById('fton_contact4_no').value = ''
			document.getElementById('fton_contact5_mode').focus();
        }
    }

	 if(obj == document.getElementById('fton_contact5_mode'))
    {
		document.getElementById('fton_contact5_no').value = "";
		if(document.getElementById('fton_contact5_mode').value != '')
		{
            document.getElementById('fton_contact5_no').disabled = false;
			document.getElementById('fton_contact5_no').focus();
		}
        else if(document.getElementById('fton_contact5_mode').value == '')
        {
            document.getElementById('fton_contact5_no').disabled = true;
            document.getElementById('fton_contact5_no').value = '';
        }
    }
	//Ended by Suji keerthi for ML-MMOH-CRF-1527 US008
}

function enbl_disble(obj)
{
    if(obj.name == 'doc_id1_desc')
    {
		if(obj.value != "")
        {
            document.getElementById('doc_exp_dt1').disabled = false;
            document.getElementById('docexpdate1').disabled = false;
            document.getElementById('place_of_issue1').disabled = false;
            document.getElementById('issue_date1').disabled = false;
            document.getElementById('issuedt1').disabled = false;
            document.getElementById('doc_num1').disabled = false;
			document.getElementById('docexpdate1').disabled = false;
			document.getElementById('issuedt1').disabled = false;				         
			document.getElementById('doc1').style.visibility = 'visible';
			/*Rameez for SKR-SCF-0646 [IN:035259] on 05-Oct-12 -Begins*/
			document.getElementById('doc_id2_desc').disabled = false;
			document.getElementById('doc2_code_id2').disabled = false;
			/*Rameez-Ends*/
			
			/* Below line was added by Venkatesh.S on Feb/2013  against PMG2012-CRF-0006 [IN034693] */ 
			document.getElementById('doc1image').disabled = false;
			/* end PMG2012-CRF-0006 [IN034693] */
			/*Added by Rameswar on  16-03-2016 for MMS-DM-CRF-0035*/
			if (document.getElementById('iDocScanEnabled').value==1) {
			document.getElementById('doc1scan').disabled = false ;
			}else{
				document.getElementById('doc1scan').disabled = true ;
			}
			/*Added by Rameswar on  16-03-2016 for MMS-DM-CRF-0035*/
        }
        else
        {
            document.getElementById('doc_exp_dt1').disabled = true;
            document.getElementById('docexpdate1').disabled = true;
            document.getElementById('place_of_issue1').disabled = true;
            document.getElementById('issue_date1').disabled = true;
            document.getElementById('issuedt1').disabled = true;
            document.getElementById('doc_num1').disabled = true;
			document.getElementById('docexpdate1').disabled = true;
			document.getElementById('issuedt1').disabled = true;

            document.getElementById('doc_exp_dt1').value = '';
            document.getElementById('place_of_issue1').value = '';
            document.getElementById('issue_date1').value = '';
            document.getElementById('doc_num1').value = '';
			document.getElementById('doc1').style.visibility = 'hidden';
			
			/* Below line was added by Venkatesh.S on Feb/2013  against PMG2012-CRF-0006 [IN034693] */ 
			document.getElementById('doc1image').disabled = true;
			document.getElementById('doc1imageId').innerHTML=document.getElementById('doc1imageId').innerHTML;//This line added against the incident 38504 to clear the file path.
			/* end PMG2012-CRF-0006 [IN034693] */ 

			/*Added by Rameswar on  16-03-2016 for MMS-DM-CRF-0035*/
			
			document.getElementById('doc1scan').disabled = true ;
			
			/*Added by Rameswar on  16-03-2016 for MMS-DM-CRF-0035*/
			
			/*Rameez for SKR-SCF-0646 [IN:035259] on 05-Oct-12 -Begins
			document.getElementById('doc_id2_desc').value ="" ;            
			document.forms[0].doc_id2.value = "";

			document.getElementById('doc_exp_dt2').value="";
			document.getElementById('place_of_issue2').value="";
			document.getElementById('doc_num2').value = "";
			document.getElementById('docexpdate2').value ="";
			document.getElementById('issue_date2').value = "";

			document.getElementById("doc_exp_dt2").disabled = true;
            document.getElementById("place_of_issue2").disabled = true;
            document.getElementById("issue_date2").disabled = true;
            document.getElementById("doc_num2").disabled = true;
			document.getElementById("docexpdate2").disabled = true;
			document.getElementById("issuedt2").disabled = true;
			
			document.getElementById("doc_exp_dt2").value = '';
            document.getElementById("place_of_issue2").value = '';
            document.getElementById("issue_date2").value = '';
            document.getElementById("doc_num2").value = '';
			document.getElementById("doc2").style.visibility = 'hidden';	 			
			document.getElementById("doc_id3_desc").value ="" ;            
			document.forms[0].doc_id3.value = "";

			document.getElementById("doc_exp_dt3").value="";
			document.getElementById("place_of_issue3").value="";
			document.getElementById("doc_num3").value = "";
			document.getElementById("docexpdate3").value ="";
			document.getElementById("issue_date3").value = "";

			document.getElementById("doc_exp_dt3").disabled = true;
            document.getElementById("docexpdate3").disabled = true;
            document.getElementById("place_of_issue3").disabled = true;
            document.getElementById("issue_date3").disabled = true;
            document.getElementById("issuedt3").disabled = true;
            document.getElementById("doc_num3").disabled = true;
			document.getElementById("docexpdate3").disabled = true;
			document.getElementById("issuedt3").disabled = true;

            document.getElementById("doc_exp_dt3").value = '';
            document.getElementById("place_of_issue3").value = '';
            document.getElementById("issue_date3").value = '';
            document.getElementById("doc_num3").value = '';
			document.getElementById("doc3").style.visibility = 'hidden'; 	
			document.getElementById("doc_id4_desc").value ="" ;            
			document.forms[0].doc_id4.value = "";

			document.getElementById("doc_exp_dt4").value="";
			document.getElementById("place_of_issue4").value="";
			document.getElementById("doc_num4").value = "";
			document.getElementById("docexpdate4").value ="";
			document.getElementById("issue_date4").value = "";
			
			document.getElementById("doc_exp_dt4").disabled = true;
            document.getElementById("docexpdate4").disabled = true;
            document.getElementById("place_of_issue4").disabled = true;
            document.getElementById("issue_date4").disabled = true;
            document.getElementById("issuedt4").disabled = true;
            document.getElementById("doc_num4").disabled = true;
			document.getElementById("docexpdate4").disabled = true;
			document.getElementById("issuedt4").disabled = true;

            document.getElementById("doc_exp_dt4").value = '';
            document.getElementById("place_of_issue4").value = '';
            document.getElementById("issue_date4").value = '';
            document.getElementById("doc_num4").value = '';
			document.getElementById("doc4").style.visibility = 'hidden'; 	
			Rameez-Ends*/
        }
        
    }

    if(obj.name=='doc_id2_desc')
    {
		
		if(obj.value != "")
        {
            document.getElementById('doc_exp_dt2').disabled = false;
            document.getElementById('place_of_issue2').disabled = false;
            document.getElementById('issue_date2').disabled = false;
            document.getElementById('doc_num2').disabled = false;
			document.getElementById('docexpdate2').disabled = false;
			document.getElementById('issuedt2').disabled = false;			
			document.getElementById('doc2').style.visibility = 'visible';
			/*Rameez for SKR-SCF-0646 [IN:035259] on 05-Oct-12 -Begins*/
			document.getElementById('doc_id3_desc').disabled = false;
			document.getElementById("doc3_id").disabled = false;
			/*Rameez-Ends*/
		   /* Below line was added by Venkatesh.S on Feb/2013  against PMG2012-CRF-0006 [IN034693] */ 
			document.getElementById('doc2image').disabled = false;
			/* end PMG2012-CRF-0006 [IN034693] */ 
			/*Added by Rameswar on  16-03-2016 for MMS-DM-CRF-0035*/
			if (document.getElementById('iDocScanEnabled').value==1) {
			document.getElementById('doc2scan').disabled = false ;
			}else{
				document.getElementById('doc2scan').disabled = true ;
			}
			/*Added by Rameswar on  16-03-2016 for MMS-DM-CRF-0035*/
        }
        else
        {
            document.getElementById('doc_exp_dt2').disabled = true;
            document.getElementById('place_of_issue2').disabled = true;
            document.getElementById('issue_date2').disabled = true;
            document.getElementById('doc_num2').disabled = true;
			document.getElementById('docexpdate2').disabled = true;
			document.getElementById('issuedt2').disabled = true;

            document.getElementById('doc_exp_dt2').value = '';
            document.getElementById('place_of_issue2').value = '';
            document.getElementById('issue_date2').value = '';
            document.getElementById('doc_num2').value = '';
			document.getElementById('doc2').style.visibility = 'hidden';
			/* Below line was added by Venkatesh.S on Feb/2013  against PMG2012-CRF-0006 [IN034693] */ 
			document.getElementById('doc2image').disabled = true;
			document.getElementById('doc2imageId').innerHTML=document.getElementById('doc2imageId').innerHTML;//This line added against the incident 38504 to clear the file path.
			/* end PMG2012-CRF-0006 [IN034693] */ 
			/*Added by Rameswar on  16-03-2016 for MMS-DM-CRF-0035*/
			
			document.getElementById('doc2scan').disabled = true ;
			
			/*Added by Rameswar on  16-03-2016 for MMS-DM-CRF-0035*/
        }
        
    }

    if(obj.name=='doc_id3_desc')
    {
		
		if(obj.value != "")
        {
            document.getElementById('doc_exp_dt3').disabled = false;
            document.getElementById('docexpdate3').disabled = false;
            document.getElementById('place_of_issue3').disabled = false;
            document.getElementById('issue_date3').disabled = false;
            document.getElementById('issuedt3').disabled = false;
            document.getElementById('doc_num3').disabled = false;
			document.getElementById('docexpdate3').disabled = false;
			document.getElementById('issuedt3').disabled = false;
			document.getElementById('doc3').style.visibility = 'visible';
			/*Rameez for SKR-SCF-0646 [IN:035259] on 05-Oct-12 -Begins*/
			document.getElementById('doc_id4_desc').disabled = false;
			document.getElementById("doc4_id").disabled = false;
			/*Rameez-Ends*/
			/* Below line was added by Venkatesh.S on Feb/2013  against PMG2012-CRF-0006 [IN034693] */ 
			document.getElementById('doc3image').disabled = false;
			/* end PMG2012-CRF-0006 [IN034693] */ 
			/*Added by Rameswar on  16-03-2016 for MMS-DM-CRF-0035*/
			if (document.getElementById('iDocScanEnabled').value==1) {
			document.getElementById('doc3scan').disabled = false ;
			}else{
				document.getElementById('doc3scan').disabled = true ;
			}
			/*Added by Rameswar on  16-03-2016 for MMS-DM-CRF-0035*/
			
        }
        else
        {
            document.getElementById('doc_exp_dt3').disabled = true;
            document.getElementById('docexpdate3').disabled = true;
            document.getElementById('place_of_issue3').disabled = true;
            document.getElementById('issue_date3').disabled = true;
            document.getElementById('issuedt3').disabled = true;
            document.getElementById('doc_num3').disabled = true;
			document.getElementById('docexpdate3').disabled = true;
			document.getElementById('issuedt3').disabled = true;

            document.getElementById('doc_exp_dt3').value = '';
            document.getElementById('place_of_issue3').value = '';
            document.getElementById('issue_date3').value = '';
            document.getElementById('doc_num3').value = '';
			document.getElementById('doc3').style.visibility = 'hidden';
			/* Below line was added by Venkatesh.S on Feb/2013  against PMG2012-CRF-0006 [IN034693] */ 
			document.getElementById('doc3image').disabled = true;
			document.getElementById('doc3imageId').innerHTML=document.getElementById('doc3imageId').innerHTML;//This line added against the incident 38504 to clear the file path.
		   /* end PMG2012-CRF-0006 [IN034693] */ 
		   /*Added by Rameswar on  16-03-2016 for MMS-DM-CRF-0035*/
		   
			document.getElementById('doc3scan').disabled = true ;
			/*Added by Rameswar on  16-03-2016 for MMS-DM-CRF-0035*/

        }

        
    }

    if(obj.name=='doc_id4_desc')
    {
		if(obj.value != "")
        {
            document.getElementById('doc_exp_dt4').disabled = false;
            document.getElementById('docexpdate4').disabled = false;
            document.getElementById('place_of_issue4').disabled = false;
            document.getElementById('issue_date4').disabled = false;
            document.getElementById('issuedt4').disabled = false;
            document.getElementById('doc_num4').disabled = false;
			document.getElementById('docexpdate4').disabled = false;
			document.getElementById('issuedt4').disabled = false;
			document.getElementById('doc4').style.visibility = 'visible';
			/* Below line was added by Venkatesh.S on Feb/2013  against PMG2012-CRF-0006 [IN034693] */ 
			document.getElementById('doc4image').disabled = false;
			/* end PMG2012-CRF-0006 [IN034693] */ 
			/*Added by Rameswar on  16-03-2016 for MMS-DM-CRF-0035*/
			if (document.getElementById('iDocScanEnabled').value==1) {
			document.getElementById('doc4scan').disabled = false ;
			}else{
				document.getElementById('doc4scan').disabled = true ;
			}
			/*Added by Rameswar on  16-03-2016 for MMS-DM-CRF-0035*/
        }
        else
        {
            document.getElementById('doc_exp_dt4').disabled = true;
            document.getElementById('docexpdate4').disabled = true;
            document.getElementById('place_of_issue4').disabled = true;
            document.getElementById('issue_date4').disabled = true;
            document.getElementById('issuedt4').disabled = true;
            document.getElementById('doc_num4').disabled = true;
			document.getElementById('docexpdate4').disabled = true;
			document.getElementById('issuedt4').disabled = true;

            document.getElementById('doc_exp_dt4').value = '';
            document.getElementById('place_of_issue4').value = '';
            document.getElementById('issue_date4').value = '';
            document.getElementById('doc_num4').value = '';
			document.getElementById('doc4').style.visibility = 'hidden';
			/* Below line was added by Venkatesh.S on Feb/2013  against PMG2012-CRF-0006 [IN034693] */ 
			document.getElementById('doc4image').disabled = true;
			document.getElementById('doc4imageId').innerHTML=document.getElementById('doc4imageId').innerHTML;//This line added against the incident 38504 to clear the file path.
			/* end PMG2012-CRF-0006 [IN034693] */ 
			/*Added by Rameswar on  16-03-2016 for MMS-DM-CRF-0035*/
			
			document.getElementById('doc4scan').disabled = true ;
			
			/*Added by Rameswar on  16-03-2016 for MMS-DM-CRF-0035*/
        }
    }
}
function validatIssueDatechk(obj,othobj)
{
	if(obj.value.length > 0)
    { 
		if(validDate(obj.value,"DMY",localeName))
		{ 
			var issDate = obj.value;
			if (isAfterNow(issDate,"DMY",localeName))
			{ 
				alert(getMessage("ISSUE_DATE_GREATER",'MP'));
				obj.value = '';
				obj.focus();
				return false;
			}
		}
		else return false;
	}
	return ChkForIssueDate(othobj,obj,'Iss'); // To compare exp < Issue Date
}

function ChkForIssueDate(othobj,obj,flag)
{
	if(obj.value.length > 0 && othobj.value.length > 0 )
    {
		if(validDate(obj.value,"DMY",localeName))
		{
			if(validDate(othobj.value,"DMY",localeName))
			{
				var issDate = obj.value;
				var expDate = othobj.value;

				if ( !isAfter(expDate,issDate,"DMY",localeName) )
				{
						alert(getMessage("DOC_ISS_DT_LESS_EXP_DT",'MP'));
						if (flag != null && flag=='Iss')
						{
							obj.value = '';
							obj.focus();
						}
						else
						{
							othobj.value = '';
							othobj.focus();
						}
						return false;
				}
			}
			else return false;
		}
		else return false;
	}
    return true;
	
}

function enable_disable(function_id)
{
	form_name = document.forms[0]
    if(function_id == "NEWBORN_REG")
    {
        form_name.sex.disabled = true;
        form_name.age_or_dob.disabled = true;
        form_name.b_age.disabled = true;
        form_name.b_months.disabled = true;
        form_name.b_days.disabled = true;
        form_name.date_of_birth.disabled = true;
    }
    else if(function_id == 'PAT_REG')
    {
        var start_num = 0
        for(var i=0; i<form_name.elements.length;i++)
        {
            if(form_name.elements[i].name == "r_addr_line1")
            {
                start_num = i ;
                break;
            }
             else
                form_name.elements[i].disabled = true;
        }

        var start_now = false
        for(var i=start_num; i<form_name.elements.length;i++)
        {
            if(form_name.elements[i].name == "next_contact_relation")
            {
                start_now =true;
            }
             if(start_now)
                form_name.elements[i].disabled = true;
        }
        
		if(document.getElementById('dobcal')!=null)
		document.getElementById('dobcal').disabled=true;
		if (document.getElementById('altidexpdt1'))
			document.getElementById('altidexpdt1').disabled=true;
		if (document.getElementById('altidexpdt2'))
			document.getElementById('altidexpdt2').disabled=true;
		if (document.getElementById('altidexpdt3'))
			document.getElementById('altidexpdt3').disabled=true;
		if (document.getElementById('altidexpdt4'))
			document.getElementById('altidexpdt4').disabled=true;

		document.getElementById('docexpdate1').disabled=true;
		document.getElementById('docexpdate2').disabled=true;
		document.getElementById('docexpdate3').disabled=true;
		document.getElementById('docexpdate4').disabled=true;
		document.getElementById('issuedt1').disabled=true;
		document.getElementById('issuedt2').disabled=true;
		document.getElementById('issuedt3').disabled=true;
		document.getElementById('issuedt4').disabled=true;
    }
}

function dispMandatoryImage(id)
{

    if(id == null)
    {
        id = pat_sergrp_id_types[document.getElementById('pat_ser_grp_code').selectedIndex]
    }
	var temp = document.getElementById('accept_national_id_no').value;
	var isNatIdOrAltId1MandRes		= document.getElementById('isNatIdOrAltId1MandRes').value;
	var isNatIdOrAltIdMandVisaType		= document.getElementById('isNatIdOrAltIdMandVisaType').value;
	var isNatIdAltIdMandVisaType		= document.getElementById('isNatIdAltIdMandVisaType').value;//Maheshwaran added for AAKH-CRF-0145 as on 22-04-2022
	var isValidateNatId				= "Y";
	//Maheshwaran added -isNatIdAltIdMandVisaType for AAKH-CRF-0145 as on 22-04-2022
	if((isNatIdOrAltId1MandRes == "true" || isNatIdOrAltIdMandVisaType=="true"  || isNatIdAltIdMandVisaType=="true") && document.getElementById('nat_id_reqd_all_series').value=='N'){
		isValidateNatId		= "N";
	}

    if (document.getElementById('accept_national_id_no').value == 'Y')
	{
		if(document.getElementById('patient_group').value != 'N' && document.getElementById('nat_id_reqd_all_series').value=='Y'||pat_sergrp_id_types[document.getElementById('pat_ser_grp_code').selectedIndex] != "N")
			document.getElementById('nat_gif').style.visibility='hidden'
		if (document.getElementById('nat_id_reqd_all_series').value=='Y' && isValidateNatId=="Y")
			document.getElementById('nat_gif').style.visibility='visible';
	}
	
   /*if(document.getElementById("alt_id1_reqd_yn").value != 'Y' && pat_sergrp_id_types[document.getElementById("pat_ser_grp_code").selectedIndex] != "A")
	{
		document.getElementById("alt1_gif").style.visibility='hidden';
	}*/
    if(id=='N')
    {
		
		if (document.getElementById('accept_national_id_no').value == 'Y')
		{	  
		   var isNatIdMandatory	= document.getElementById('isNatIdMandatory').value;
			/*isNatIdMandatory added by Dharma on Feb 9th 2017 against GDOH-SCF-0244 [IN:063491]*/

		  // if(document.getElementById('patient_group').value == 'N' || document.getElementById('nat_id_reqd_all_series').value=='Y'||pat_sergrp_id_types[document.getElementById('pat_ser_grp_code').selectedIndex] == "N")
			
		  if((isNatIdMandatory!="Y") && (isValidateNatId=="Y") && (document.getElementById('patient_group').value == 'N' || document.getElementById('nat_id_reqd_all_series').value=='Y'||pat_sergrp_id_types[document.getElementById('pat_ser_grp_code').selectedIndex] == "N")){
			   document.getElementById('nat_gif').style.visibility='visible';
		  }
		}
	    if (document.getElementById('alt_id1_accept_oth_pat_ser_yn').value == 'N')
		{
		   document.getElementById('alt_id1_no').value = "";
		   document.getElementById('alt_id1_no').disabled = true;	
		   document.getElementById('alt1_gif').style.visibility='hidden';/*Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772]*/
		   
		}
	    else
		   document.getElementById('alt_id1_no').disabled = false;

		/*Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] Start*/
		if(document.getElementById('alt_id2_no')!=null && document.getElementById('alt_id2_no')!='undefined'){
			if (document.getElementById('alt_id2_accept_oth_pat_ser_yn').value == 'N'){
			   document.getElementById('alt_id2_no').value = "";
			   document.getElementById('alt_id2_no').disabled = true;	
			   document.getElementById('alt2_gif').style.visibility='hidden';
			} else{
			   document.getElementById('alt_id2_no').disabled = false;
			}
		}
		if(document.getElementById('alt_id3_no')!=null && document.getElementById('alt_id3_no')!='undefined'){
			if (document.getElementById('alt_id3_accept_oth_pat_ser_yn').value == 'N'){
			   document.getElementById('alt_id3_no').value = "";
			   document.getElementById('alt_id3_no').disabled = true;	
			   document.getElementById('alt3_gif').style.visibility='hidden';
			} else{
			   document.getElementById('alt_id3_no').disabled = false;
			}
		}

		if(document.getElementById('alt_id4_no')!=null && document.getElementById('alt_id4_no')!='undefined'){
			if (document.getElementById('alt_id4_accept_oth_pat_ser_yn').value == 'N'){
			   document.getElementById('alt_id4_no').value = "";
			   document.getElementById('alt_id4_no').disabled = true;	
			   document.getElementById('alt4_gif').style.visibility='hidden';
			} else{
			   document.getElementById('alt_id4_no').disabled = false;
			}
		}

		/*Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] End*/

    }
    else if(id=='A')
    {
        if (document.getElementById('alt_id1_accept_oth_pat_ser_yn').value == 'N' && pat_sergrp_id_types[document.getElementById('pat_ser_grp_code').selectedIndex] != "A") {
		   document.getElementById('alt_id1_no').disabled = true;
	   }else{
			/*Modified by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] Start*/

			
			/*if(document.getElementById('alt_id1_reqd_yn').value == 'Y' || pat_sergrp_id_types[document.getElementById('pat_ser_grp_code').selectedIndex] == "A") {
				document.getElementById('alt1_gif').style.visibility='visible';
				document.getElementById('alt_id1_no').disabled = false;
			}*/

			if(document.getElementById('alt_id1_reqd_yn').value == 'Y') {
			   document.getElementById('alt1_gif').style.visibility='visible';
			}
			if(pat_sergrp_id_types[document.getElementById('pat_ser_grp_code').selectedIndex] == "A"){
				 document.getElementById('alt_id1_no').disabled = false;
			}
			/*Modified by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] End*/
		   
	   }
		/*Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] Start*/
		if(document.getElementById('alt_id2_no')!=null && document.getElementById('alt_id2_no')!='undefined'){
			   if (document.getElementById('alt_id2_accept_oth_pat_ser_yn').value == 'N' && pat_sergrp_id_types[document.getElementById('pat_ser_grp_code').selectedIndex] != "A")  {
				   document.getElementById('alt_id2_no').disabled = true;
			   } else {

					if(document.getElementById('alt_id2_reqd_yn').value == 'Y') {
					   document.getElementById('alt2_gif').style.visibility='visible';
					}
					if(pat_sergrp_id_types[document.getElementById('pat_ser_grp_code').selectedIndex] == "A"){
						 document.getElementById('alt_id2_no').disabled = false;
					}
			   }
		}

		if(document.getElementById('alt_id3_no')!=null && document.getElementById('alt_id3_no')!='undefined'){
			   if (document.getElementById('alt_id3_accept_oth_pat_ser_yn').value == 'N' && pat_sergrp_id_types[document.getElementById('pat_ser_grp_code').selectedIndex] != "A")  {
				   document.getElementById('alt_id3_no').disabled = true;
			   } else {
				   
					if(document.getElementById('alt_id3_reqd_yn').value == 'Y') {
					   document.getElementById('alt3_gif').style.visibility='visible';
					}
					if(pat_sergrp_id_types[document.getElementById('pat_ser_grp_code').selectedIndex] == "A"){
						document.getElementById('alt_id3_no').disabled = false;
					}
			   }
		}

		if(document.getElementById('alt_id4_no')!=null && document.getElementById('alt_id4_no')!='undefined'){
			   if (document.getElementById('alt_id4_accept_oth_pat_ser_yn').value == 'N' && pat_sergrp_id_types[document.getElementById('pat_ser_grp_code').selectedIndex] != "A")  {
				   document.getElementById('alt_id4_no').disabled = true;
			   } else {
				   
					if(document.getElementById('alt_id4_reqd_yn').value == 'Y') {
					   document.getElementById('alt4_gif').style.visibility='visible';
					 }
					if(pat_sergrp_id_types[document.getElementById('pat_ser_grp_code').selectedIndex] == "A"){
						document.getElementById('alt_id4_no').disabled = false;
					}
			   }
		}
		/*Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] End*/

    }
	else
	{
	   if (document.getElementById('alt_id1_accept_oth_pat_ser_yn').value == 'N')
		{
		   document.getElementById('alt_id1_no').value = "";
		   document.getElementById('alt_id1_no').disabled = true;
		   if (document.getElementById('alt1_gif'))
		   document.getElementById('alt1_gif').style.visibility='hidden';
		}
	   else
		{
		   if ( (pat_sergrp_id_types[document.getElementById('pat_ser_grp_code').selectedIndex] != "A") && (document.getElementById('alt_id1_reqd_yn').value == 'N') && (document.getElementById('family_org_membership')) && (document.getElementById('family_org_membership').value=='4'))
	      {	
		     document.getElementById('alt1_gif').style.visibility='hidden'
		     document.getElementById('alt_id1_no').disabled = false;
	      }
	   
		}

		/*Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] Start*/
		if(document.getElementById('alt_id2_no')!=null && document.getElementById('alt_id2_no')!='undefined'){

			if (document.getElementById('alt_id2_accept_oth_pat_ser_yn').value == 'N'){
			   document.getElementById('alt_id2_no').value = "";
			   document.getElementById('alt_id2_no').disabled = true;
			   if (document.getElementById('alt2_gif'))
			   document.getElementById('alt2_gif').style.visibility='hidden';
			} else {
			   if ( (pat_sergrp_id_types[document.getElementById('pat_ser_grp_code').selectedIndex] != "A") && (document.getElementById('alt_id2_reqd_yn').value == 'N') && (document.getElementById('family_org_membership')) && (document.getElementById('family_org_membership').value=='4'))
			  {	
				 document.getElementById('alt2_gif').style.visibility='hidden'
				 document.getElementById('alt_id2_no').disabled = false;
			  }
		   
			}
		}

		if(document.getElementById('alt_id3_no')!=null && document.getElementById('alt_id3_no')!='undefined'){

			if (document.getElementById('alt_id3_accept_oth_pat_ser_yn').value == 'N'){
			   document.getElementById('alt_id3_no').value = "";
			   document.getElementById('alt_id3_no').disabled = true;
			   if (document.getElementById('alt3_gif'))
			   document.getElementById('alt3_gif').style.visibility='hidden';
			} else {
			   if ( (pat_sergrp_id_types[document.getElementById('pat_ser_grp_code').selectedIndex] != "A") && (document.getElementById('alt_id3_reqd_yn').value == 'N') && (document.getElementById('family_org_membership')) && (document.getElementById('family_org_membership').value=='4'))
			  {	
				 document.getElementById('alt3_gif').style.visibility='hidden'
				 document.getElementById('alt_id3_no').disabled = false;
				 
			  }
		   
			}
		}

		if(document.getElementById('alt_id4_no')!=null && document.getElementById('alt_id4_no')!='undefined'){

			if (document.getElementById('alt_id4_accept_oth_pat_ser_yn').value == 'N'){
			   document.getElementById('alt_id4_no').value = "";
			   document.getElementById('alt_id4_no').disabled = true;
			   if (document.getElementById('alt4_gif'))
			   document.getElementById('alt4_gif').style.visibility='hidden';
			} else {
				   if ( (pat_sergrp_id_types[document.getElementById('pat_ser_grp_code').selectedIndex] != "A") && (document.getElementById('alt_id4_reqd_yn').value == 'N') && (document.getElementById('family_org_membership')) && (document.getElementById('family_org_membership').value=='4')) {	
					 document.getElementById('alt4_gif').style.visibility='hidden'
					 document.getElementById('alt_id4_no').disabled = false;
				  }
		   	}
		}

		/*Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] End*/

	}

    if ( (pat_sergrp_id_types[document.getElementById('pat_ser_grp_code').selectedIndex] != "A") && (document.getElementById('alt_id1_reqd_yn').value == 'N') && (document.getElementById('family_org_membership')) && (document.getElementById('family_org_membership').value=='4'))
	{			
		document.getElementById('alt1_gif').style.visibility='hidden';
	}
}

function dispMandatoryImageForOthNames ()
{

        if(document.getElementById('first_oth_name_reqd_yn')!=null)
        {
            document.getElementById('first_oth_name_reqd_yn').value='N'
            document.getElementById('first_oth').style.visibility = "hidden"
        }
        if(document.getElementById('second_oth_name_reqd_yn')!=null)
        {
            document.getElementById('second_oth_name_reqd_yn').value='N'
            document.getElementById('sec_oth').style.visibility = "hidden"
        }
        if(document.getElementById('third_oth_name_reqd_yn')!=null)
        {
            document.getElementById('third_oth_name_reqd_yn').value='N'
            document.getElementById('third_oth').style.visibility = "hidden"
        }
        if(document.getElementById('family_oth_name_reqd_yn')!=null)
        {
            document.getElementById('family_oth_name_reqd_yn').value='N'
            document.getElementById('fam_oth').style.visibility = "hidden"
        }
        if(document.getElementById('name_prefix_oth_name_reqd_yn')!=null)
        {
            document.getElementById('name_prefix_oth_name_reqd_yn').value='N'
			if ( document.getElementById('name_prefix_oth'))
	            document.getElementById('name_prefix_oth').style.visibility = "hidden"
        }
        if(document.getElementById('name_suffix_oth_name_reqd_yn')!=null)
        {
            document.getElementById('name_suffix_oth_name_reqd_yn').value='N'
			 if(document.getElementById('name_suffix_oth') != null)
	            document.getElementById('name_suffix_oth').style.visibility = "hidden"
        }	 

	if(pat_name_in_loc_lang[document.getElementById('pat_ser_grp_code').selectedIndex] == 'Y')
    {
		document.getElementById('pat_name_in_loc_lang_reqd_yn').value = "Y";		
        if( (document.getElementById('first_name_reqd_yn')!=null) && (document.getElementById('first_name_reqd_yn').value == 'Y') )
        {
            if(document.getElementById('first_oth_name_reqd_yn') != null)
            {
                document.getElementById('first_oth_name_reqd_yn').value='Y'
                document.getElementById('first_oth').style.visibility = "visible"
            }
        }
        if( (document.getElementById('second_name_reqd_yn')!=null) && (document.getElementById('second_name_reqd_yn').value == 'Y') )
        {
            if(document.getElementById('second_oth_name_reqd_yn') != null)
            {
                document.getElementById('second_oth_name_reqd_yn').value='Y'
                document.getElementById('sec_oth').style.visibility = "visible"
            }
        }
        if( ( document.getElementById('third_name_reqd_yn')!=null) && (document.getElementById('third_name_reqd_yn').value == 'Y') )
        {
            if(document.getElementById('third_oth_name_reqd_yn') != null)
            {
                document.getElementById('third_oth_name_reqd_yn').value='Y'
                document.getElementById('third_oth').style.visibility = "visible"
            }
        }
        if( (document.getElementById('family_name_reqd_yn')!=null) && (document.getElementById('family_name_reqd_yn').value == 'Y') )
        {
            if(document.getElementById('family_oth_name_reqd_yn') != null)
            {
                document.getElementById('family_oth_name_reqd_yn').value='Y'
                document.getElementById('fam_oth').style.visibility = "visible"
            }
        }
        if ( document.getElementById('name_prefix_reqd_yn') !=null )
        {
			if ( document.getElementById('name_prefix_reqd_yn').value == 'Y' )
			{
				if ( (document.getElementById('name_prefix_oth_name_reqd_yn') != null) && (document.getElementById('names_in_oth_lang').value == 'Y') )
				{
					document.getElementById('name_prefix_oth_name_reqd_yn').value='Y'
					if (document.getElementById('name_prefix_oth'))
						document.getElementById('name_prefix_oth').style.visibility = "visible"
				}
			}
			else
			{
				if(document.getElementById('name_prefix_oth_name_reqd_yn') != null)
				{
					document.getElementById('name_prefix_oth_name_reqd_yn').value='N'
					if (document.getElementById('name_prefix_oth'))
						document.getElementById('name_prefix_oth').style.visibility = "hidden"
				}
			}
        }
		else
			if ( (document.getElementById('name_pfx_reqd_for_org_mem_yn')) && (document.getElementById('name_pfx_reqd_for_org_mem_yn').value == 'Y') )
			{
				if(document.getElementById('name_prefix_oth_name_reqd_yn') != null)
				{
					document.getElementById('name_prefix_oth_name_reqd_yn').value='Y'
					if (document.getElementById('name_prefix_oth'))
						document.getElementById('name_prefix_oth').style.visibility = "visible"
				}
			}

        if( (document.getElementById('name_suffix_reqd_yn')!=null) && (document.getElementById('name_suffix_reqd_yn').value == 'Y') )
        {
            if(document.getElementById('name_suffix_oth_name_reqd_yn') != null)
            {
                document.getElementById('name_suffix_oth_name_reqd_yn').value='Y'
				if(document.getElementById('name_suffix_oth') != null)
				   document.getElementById('name_suffix_oth').style.visibility = "visible"
            }
        }
    } else {
		document.getElementById('pat_name_in_loc_lang_reqd_yn').value = "N";		 		 
	}
}
//Included for change patient header

var currentTab = new String();
currentTab = "demogrp_tab";
var previousTab = new String();
previousTab = "demogrp_tab";

async function tab_click(objName) {
	// FIRST CHANGE THE CURRENT SELECTED TAB

        if (objName == 'demogrp_tab')
            parent.patient_sub.moveToTab(1);
        else if (objName == 'cmodeaddr_tab')
            parent.patient_sub.moveToTab(2);            
        else if (objName == 'rlcnts_tab')
            parent.patient_sub.moveToTab(3);
        else if (objName == 'others_tab')
            parent.patient_sub.moveToTab(4);
        else if (objName == 'pat_docs_tab')
            parent.patient_sub.moveToTab(6);
        else if(objName == 'add_mod_dtl')
            parent.patient_sub.moveToTab(7);
        else if(objName == 'parent_dtls')
            parent.patient_sub.moveToTab(8);
        else if (objName == 'findtl_tab')
            await chkOnSub();
    }

function invokeTab(objName) {
	// FIRST CHANGE THE CURRENT SELECTED TAB

	selectTab(objName);
	parent.patient_sub.goToTab(objName);
}

async function goToTab(objName) {

	if (objName == 'demogrp_tab') {
			document.getElementById('demo').style.display = 'inline';
			document.getElementById('addr').style.display = 'none';
			document.getElementById('NextOfKin').style.display = 'none';
			document.getElementById('FirstToNotify').style.display = 'none';
			document.getElementById('EmplyrDtls').style.display = 'none';						
			document.getElementById('pat_docs_tab').style.display = 'none';
			if(document.getElementById('add_mod_dtl'))
				document.getElementById('add_mod_dtl').style.display = 'none';						
		} else if(objName == 'cmodeaddr_tab') {
			document.getElementById('demo').style.display = 'none';
			document.getElementById('addr').style.display = 'inline';
			document.getElementById('NextOfKin').style.display = 'none';
			document.getElementById('FirstToNotify').style.display = 'none';
			document.getElementById('EmplyrDtls').style.display = 'none';						
			document.getElementById('pat_docs_tab').style.display = 'none';
			if(document.getElementById('add_mod_dtl'))
				document.getElementById('add_mod_dtl').style.display = 'none';	
		} else if(objName == 'rlcnts_tab') {
			document.getElementById('demo').style.display = 'none';
			document.getElementById('addr').style.display = 'none';
			document.getElementById('NextOfKin').style.display = 'inline';
			document.getElementById('FirstToNotify').style.display = 'none';
			document.getElementById('EmplyrDtls').style.display = 'none';						
			document.getElementById('pat_docs_tab').style.display = 'none';	
			if(document.getElementById('add_mod_dtl'))
				document.getElementById('add_mod_dtl').style.display = 'none';	
		} else if(objName == 'kin') {
			document.getElementById('demo').style.display = 'none';
			document.getElementById('addr').style.display = 'none';
			document.getElementById('NextOfKin').style.display = 'inline';
			document.getElementById('FirstToNotify').style.display = 'none';
			document.getElementById('EmplyrDtls').style.display = 'none';						
			document.getElementById('pat_docs_tab').style.display = 'none';
			if(document.getElementById('add_mod_dtl'))
				document.getElementById('add_mod_dtl').style.display = 'none';	
		} else if(objName == 'kin1') {
			document.getElementById('demo').style.display = 'none';
			document.getElementById('addr').style.display = 'none';
			document.getElementById('NextOfKin').style.display = 'none';
			document.getElementById('FirstToNotify').style.display = 'inline';
			document.getElementById('EmplyrDtls').style.display = 'none';						
			document.getElementById('pat_docs_tab').style.display = 'none';	
			if(document.getElementById('add_mod_dtl'))
				document.getElementById('add_mod_dtl').style.display = 'none';	
		} else if(objName == 'empyr') {
			document.getElementById('demo').style.display = 'none';
			document.getElementById('addr').style.display = 'none';
			document.getElementById('NextOfKin').style.display = 'none';
			document.getElementById('FirstToNotify').style.display = 'none';
			document.getElementById('EmplyrDtls').style.display = 'inline';						
			document.getElementById('pat_docs_tab').style.display = 'none';	
			if(document.getElementById('add_mod_dtl'))
				document.getElementById('add_mod_dtl').style.display = 'none';	
		} else if(objName == 'pat_docs_tab') {
			document.getElementById('demo').style.display = 'none';
			document.getElementById('addr').style.display = 'none';
			document.getElementById('NextOfKin').style.display = 'none';
			document.getElementById('FirstToNotify').style.display = 'none';
			document.getElementById('EmplyrDtls').style.display = 'none';						
			document.getElementById('pat_docs_tab').style.display = 'inline';	
			if(document.getElementById('add_mod_dtl'))
				document.getElementById('add_mod_dtl').style.display = 'none';	
		} else if(objName == 'add_mod_dtl') {
			document.getElementById('demo').style.display = 'none';
			document.getElementById('addr').style.display = 'none';
			document.getElementById('NextOfKin').style.display = 'none';
			document.getElementById('FirstToNotify').style.display = 'none';
			document.getElementById('EmplyrDtls').style.display = 'none';						
			document.getElementById('pat_docs_tab').style.display = 'none'		
			if(document.getElementById('add_mod_dtl'))
				document.getElementById('add_mod_dtl').style.display = 'inline';	
		} else if(objName == 'findtl_tab') {
			chkOnSub();					
		}	
    }

function changeTab(TabName) {
	// RESET THE OLD TAB WHICH IS SELECTED FIRST .............
	if (currentTab == 'demogrp_tab')

		document.getElementById("demogrp_tab").src = '../../eCommon/images/LDemographics.gif';

	else if (currentTab == 'cmodeaddr_tab')
		document.getElementById("cmodeaddr_tab").src = '../../eCommon/images/LContactModeAddr.gif';
	else if (currentTab == 'rlcnts_tab')
		document.getElementById("rlcnts_tab").src = '../../eCommon/images/LRelatedContacts.gif';
	else if (currentTab == 'others_tab')
		document.getElementById("others_tab").src = '../../eCommon/images/LOthers.gif';
	else if (currentTab == 'pat_docs_tab')
		document.getElementById("pat_docs_tab").src = '../../eMP/images/Patient Documents-click.gif';
	else if (currentTab == 'add_mod_dtl')

		document.getElementById("add_mod_dtl").src = '../../eMP/images/Who done it_click.gif';

	else if (currentTab == 'parent_dtls')
		document.getElementById("parent_dtls").src = '../../eMP/images/Parent Details_click.gif';
	else if (currentTab == 'findtl_tab')
		document.getElementById("findtl_tab").src = '../../eBL/images/Financial Details_click.gif';

	// CHANGE THE CURRENT TAB WHICH IS SELECTED NOW...............

    if (TabName == 'demogrp_tab')
        document.getElementById('demogrp_tab').src = '../../eCommon/images/Demographics.gif';
    else if (TabName == 'cmodeaddr_tab')
        document.getElementById('cmodeaddr_tab').src = '../../eCommon/images/ContactModeAddr.gif';
    else if (TabName == 'rlcnts_tab')
        document.getElementById('rlcnts_tab').src = '../../eCommon/images/RelatedContacts.gif';
    else if (TabName == 'others_tab')
        document.getElementById('others_tab').src = '../../eCommon/images/Others.gif';
    else if (TabName == 'pat_docs_tab')
         document.getElementById('pat_docs_tab').src = '../../eMP/images/Patient Documents.gif';
    else if (TabName == 'findtl_tab')
        document.getElementById('findtl_tab').src = '../../eBL/images/Financial Details.gif';
    else if (TabName == 'add_mod_dtl')
        document.getElementById('add_mod_dtl').src = '../../eMP/images/Who done it.gif';
    else if (TabName == 'parent_dtls')
        document.getElementById('parent_dtls').src = '../../eMP/images/Parent Details.gif';

	// FINALY SET THE CURRENT TAB TO THE PASSED PARAMETER
	if (TabName == currentTab)
		previousTab = 'demogrp_tab';
	else
		previousTab = currentTab;
	currentTab = TabName;
}

async function getFinDtl(qryStr) {

	var retVal;

	/*
	 * var dialogHeight= "41"; var dialogWidth = "65"; var dialogTop = "85";
	 */

	var dialogTop = "0px";
	var dialogHeight = "90vh";
	var dialogWidth = "90vw";

	var center = "1";
	var status = "no";
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:"
			+ dialogWidth + "; center: " + center + "; status: " + status
			+ "; dialogTop :" + dialogTop;
	var arguments = "";

	var url = "../../eBL/jsp/AddModifyPatFinDetailsMain.jsp?" + qryStr;
	retVal = await top.window.showModalDialog(url, arguments, features);

	if (retVal == null)
		retVal = "";
	return retVal;

}
async function chkOnSub() {
	var package_flag = "N";
	var ins_auth_flag = "N";
	var upd_pat_flag = "N";
	var patient_id = "<%=patient%>";
	if (parent.frames[1].document.forms[0].mother_patient_id) {
		var mother_patient_id = parent.frames[1].document.forms[0].mother_patient_id.value;
		if (mother_patient_id != '')
			patient_id = mother_patient_id;

	}

	var show_hide_blng_class = "SHOW";
	var billing_group = parent.frames[1].document.forms[0].billing_group;

	/*
	 * Start of modifications for billing enhancement on 8th Jan 04
	 * ---------------
	 */

	/* end of modifications for billing enhancement on 8th Jan 04--------------- */

	var billing_mode = parent.frames[1].document.forms[0].billing_mode;
	var bl_data_from_repos_yn = "N";
	var data_source_id = parent.frames[1].document.forms[0].datasource_id;

	if (data_source_id.value != '' && billing_group.value != '') {
		bl_data_from_repos_yn = "Y";
	}

	if (billing_group.value != '')
		billing_mode.value = "Modify";
	var operation = parent.frames[1].document.forms[0].bl_operation.value;

	if (billing_mode.value == "Modify") {
		operation = "Update";
	}

	if (operation == 'Insert') {
		operation = '';
		billing_mode.value = '';
	}
	parent.frames[1].document.forms[0].bl_success.value = "N";
	// Added for Billing Enhancements

	var calling_module_id = "MP";
	var calling_function_id = "CHG_PAT_DTLS";

	//end of Addition
	
	var episode="";
    var record="";
        
    var qryStr="operation="+operation+"&upd_pat_flag="+upd_pat_flag+"&patient_id="+patient_id+"&show_hide_blng_class="+show_hide_blng_class+"&billing_mode="+billing_mode.value;
    	
	qryStr += "&calling_module_id="+calling_module_id+"&calling_function_id="+calling_function_id;
    qryStr += "&bl_data_from_repos_yn="+bl_data_from_repos_yn+"&data_source_id="+data_source_id.value;
        
		var nationality_yn = "N";
		if (parent.frames[1].document.forms[0].nationality_code) 
		{
			parent.frames[1].document.forms[0].dflt_nat_id_chk_val.value = parent.frames[1].document.forms[0].nationality_code.value;
			if(parent.frames[1].document.forms[0].nationality_code.value == parent.frames[1].document.forms[0].dflt_nationality_code.value)
			{
				nationality_yn = "Y";
			}
			else 
			{
				nationality_yn = "N";
			}
		}
		qryStr+="&nationality_yn="+nationality_yn;
		
		//Added for this CRF CRF GDOH-CRF-0029 [IN:048764] 
		var pat_regn_date_time="";		
		if(parent.frames[1].document.forms[0].disas_regn_date_time)
		pat_regn_date_time=parent.frames[1].document.forms[0].disas_regn_date_time.value;		
		qryStr+="&pat_regn_date_time="+pat_regn_date_time;

	/* Start of modifications for billing enhancement on 8th Jan 04 --------------- */
	qryStr+="&patient_class=XT";
	/*End of modifications for billing enhancement on 8th Jan 04 --------------- */



    var returnArray = new Array();
    

	returnArray = await getFinDtl(qryStr);
	parent.patient_main.invokeTab('demogrp_tab');
	//tab_click(previousTab);
    if(returnArray.length>0)
    {
        billing_group.value         = returnArray[0]; 
        billing_mode.value          = "Modify"
		parent.frames[1].document.forms[0].bl_success.value = "Y";
    } else {
        parent.frames[1].document.forms[0].bl_success.value = "N";
		return false;
	}	
 }

 function ValidateFileType(obj){
 	
 	var condition="";/*Added by Rameswar on  13-04-2016 for MMS-QF-SCF-0532 TF*/          
 	
 		if(obj.value!=""){
		/*Modified By Dharma against AMS-SCF-0516 [IN:064237] on 19th May 2017 Start*/
		//var fileType=obj.value.substr(obj.value.indexOf(".")+1,4).toUpperCase(); 
		var fileTypeArr = obj.value.split(/[\s.]+/);
		var fileType	= fileTypeArr[fileTypeArr.length-1].toUpperCase();
		/*Modified By Dharma against AMS-SCF-0516 [IN:064237] on 19th May 2017 End*/
		if(document.getElementById('fileTypeSiteSpec').value == 'true')
 	{
	
		condition=(fileType!='JPG' && fileType!='JPEG');
 	}else{
	
 		condition=(fileType!='JPG' && fileType!='GIF' && fileType!='PDF');
 	}
		
		if(condition){			
			alert(getMessage("INVALID_FILE_TYPE","MP"));			
			if(obj.name=="doc1image"){
				document.getElementById('doc1imageId').innerHTML=document.getElementById('doc1imageId').innerHTML;
			}else if(obj.name=="doc2image"){
				document.getElementById('doc2imageId').innerHTML=document.getElementById('doc2imageId').innerHTML;
			}else if(obj.name=="doc3image"){
				document.getElementById('doc3imageId').innerHTML=document.getElementById('doc3imageId').innerHTML;
			}else if(obj.name=="doc4image"){
				document.getElementById('doc4imageId').innerHTML=document.getElementById('doc4imageId').innerHTML;
			}
		}
		else
		{
			
			var fileInput = obj;
			
			//console.log("Inside PatientRegistration2 JS 2607 fileInput.files[0] ");
			//console.log(fileInput.files[0]);
			if (fileInput.files && fileInput.files[0]) 
		        var file = fileInput.files[0];
		        
			//console.log("Inside PatientRegistration2 JS 2612 file Size : "+file.size);
			
			if(file){
				if(file.size > 2147483648){
					alert(getMessage("FILE_GREATER_2GB","MP"));										
					if(obj.name=="doc1image"){
						document.getElementById('doc1imageId').innerHTML=document.getElementById('doc1imageId').innerHTML;
					}else if(obj.name=="doc2image"){
						document.getElementById('doc2imageId').innerHTML=document.getElementById('doc2imageId').innerHTML;
					}else if(obj.name=="doc3image"){
						document.getElementById('doc3imageId').innerHTML=document.getElementById('doc3imageId').innerHTML;
					}else if(obj.name=="doc4image"){
						document.getElementById('doc4imageId').innerHTML=document.getElementById('doc4imageId').innerHTML;
					}					
		        }
				
			}
			/*var fso, f;
			fso = new ActiveXObject("Scripting.FileSystemObject");	 
			if(fso.FileExists(obj.value)){ 
				file=fso.getFile(obj.value);				
				if(file.size > 2147483648){
					alert(getMessage("FILE_GREATER_2GB","MP"));										
					if(obj.name=="doc1image"){
						document.getElementById("doc1imageId").innerHTML=document.getElementById("doc1imageId").innerHTML;
					}else if(obj.name=="doc2image"){
						document.getElementById("doc2imageId").innerHTML=document.getElementById("doc2imageId").innerHTML;
					}else if(obj.name=="doc3image"){
						document.getElementById("doc3imageId").innerHTML=document.getElementById("doc3imageId").innerHTML;
					}else if(obj.name=="doc4image"){
						document.getElementById("doc4imageId").innerHTML=document.getElementById("doc4imageId").innerHTML;
					}					
		        }
            }*/
		}
	}
}

function onkeyPressEvent(e){ 
	return false;
}
function displayScanner(){

if(document.getElementById('iDocScanEnabled').value==1){
document.getElementById('doc1scan').style.visibility='visible';
document.getElementById('doc2scan').style.visibility='visible';
document.getElementById('doc3scan').style.visibility='visible';
document.getElementById('doc4scan').style.visibility='visible';
}
}

