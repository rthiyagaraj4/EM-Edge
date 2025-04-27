
var LocalErrors = new String();
var multipleclicks = 'false';
var def_series = new Array();
first_time  =true;    
var i = 0;
var readonly_bfore

function create() 
{		//alert(document.getElementById("parameters"));
	parameter = document.getElementById("parameters").value;	
	f_query_add_mod.location.href = "../../eMP/jsp/PaintEmergRegn.jsp?"+parameter+"" ;	
}

async function query() 
{
    var url = await PatientSearch('','','','','','','','N','Y','EMERG');
    if(url == true)
    {
		parameter = document.getElementById("parameters").value;		
         //parent.f_query_add_mod.location.href=url+"&"+parameter;
		  f_query_add_mod.location.href=url+"&"+parameter;
    }
}

function reset()
{
	if(f_query_add_mod.patient_sub!=null) {
		f_query_add_mod.patient_sub.location.reload();
		doValidation = false;
	}
}

/*
function fetchLocalNames(obj)
{
    var oth_name = obj.name

    if(oth_name.indexOf("oth_lang")  == -1 )
        oth_name = "document.forms[0]."+oth_name+"_oth_lang"

    if( obj.value != ""  && oth_name !=null )
    {
        var HTMLVal = new String();
        HTMLVal = "<HTML><head></head><BODY class='message'><form name='form1' id='form1' method='post' action='../../eMP/jsp/ServerValidation.jsp'><input type='hidden' name='process_id' id='process_id' value='9'><input type='hidden' name='name_fld' id='name_fld' value=\"" + obj.name +"\"><input type='hidden' name='param_val' id='param_val' value=\"" + obj.value +"\">"
        HTMLVal += "</form></BODY></HTML>";
        parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
        parent.parent.messageFrame.document.form1.submit();
    }
}
*/

/*
function callSearch(fromobj, toobj)
{

		var names_in_oth_lang = document.forms[0].names_in_oth_lang.value;
		var lang_dir = document.forms[0].language_direction.value;
		if(lang_dir == 'R')
		{	

			var jsp_name ="../../eMP/jsp/SearchStdOtherName.jsp?names_in_oth_lang="+names_in_oth_lang;

			if(fromobj.name == "family_name" || fromobj.name=="family_name_oth_lang")
				jsp_name ="../../eMP/jsp/SearchStdFamilyName.jsp?names_in_oth_lang="+names_in_oth_lang;

				var retVal =    new String();
				var dialogHeight= "28" ;
				var dialogWidth = "43" ;
				var status = "no";
				var arguments   = "" ;
				var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
				retVal = window.showModalDialog( jsp_name,arguments,features);

				if(retVal != null)
				{
					var arr = retVal.split("`");

					if( (fromobj.name).indexOf("oth_lang") == -1)
					{
						fromobj.value =arr[0]

						toobj =eval("document.forms[0]."+toobj)
						if(toobj !=null)
							toobj.value = arr[1]
					}
					else
					{
						toobj.value = arr[0]
						fromobj.value =arr[1]
					}
					//fromobj.focus();
				}
		}
}
*/
          
async function get_patient_id()
{
    var patient_id_back = await PatientSearch();

    if ((patient_id_back != null))
    {
        patient_id_back = unescape(patient_id_back)
        document.forms[0].family_link_no.value=patient_id_back;
        document.forms[0].family_link_no.focus();
    }
    else document.forms[0].family_link_no.focus();
}

function chkDetailsUnknown()
{
	if(document.forms[0].details_unknown.checked == true)
    {	
				
		readonly_bfore = parent.frames[0].document.getElementById('patient_id').readOnly
		document.getElementById('details_unknown').value="Y";
/*if(parent.frames[0].document.getElementById('patient_name')!=null)
		{	
parent.frames[0].document.getElementById('patient_name').value = "";
		}	*/
		if(document.forms[0].relgn_code != null)
		{
			document.getElementById('relgn_code').disabled = false;
			//document.getElementById('relgn_code').value = "";
		}
        

		
		if( document.forms[0].national_id_no != null )
        {
			document.forms[0].national_id_no.value = "";
            document.forms[0].national_id_no.readOnly = true;
			if(document.forms[0].nat_gif != null)	
				document.forms[0].nat_gif.style.visibility = 'hidden';	
		}
			
        if(document.getElementById('first_name') != null)
        {
            document.getElementById('first_name').disabled = true;
			if(document.getElementById('bf') != null)
	            document.getElementById('bf').disabled = true;
            document.getElementById('first_name').value=""
            putPatientName(document.getElementById('first_name'))
        }

        if(document.getElementById('second_name') != null)
        {
            document.getElementById('second_name').disabled = true;
			if(document.getElementById('bs') != null)
				document.getElementById('bs').disabled = true;
            document.getElementById('second_name').value=""
        }

        if(document.getElementById('third_name') != null)
        {
            document.getElementById('third_name').disabled = true;
			if(document.getElementById('bt') != null)
				document.getElementById('bt').disabled = true;
            document.getElementById('third_name').value=""
        }
		if(document.getElementById('family_name'))
			document.getElementById('family_name').value=document.getElementById('sex').value;
		if(document.getElementById('family_name') != null)
        {
         //   document.getElementById('family_name').value=document.getElementById('sex').value;
			document.getElementById('family_name').disabled = true;
			if (document.getElementById('bfam') != null)
				document.getElementById('bfam').disabled = true;
			document.getElementById('family_name').value=""
            putPatientName(document.getElementById('family_name'))
        }

        if(document.getElementById('first_name_oth_lang') != null)
        {
            document.getElementById('first_name_oth_lang').disabled = true;
			if (document.getElementById('bfo') != null)
				document.getElementById('bfo').disabled = true;
            document.getElementById('first_name_oth_lang').value=""
            putLocalLangPatientName(document.getElementById('first_name_oth_lang'))
        }

        if(document.getElementById('second_name_oth_lang') != null)
        {
            document.getElementById('second_name_oth_lang').disabled = true;
			if (document.getElementById('bso') != null)
	            document.getElementById('bso').disabled = true;
            document.getElementById('second_name_oth_lang').value=""
        }

        if(document.getElementById('third_name_oth_lang') != null)
        {
            document.getElementById('third_name_oth_lang').disabled = true;
            document.getElementById('bto').disabled = true;
            document.getElementById('third_name_oth_lang').value=""
        }

        if(document.getElementById('family_name_oth_lang') != null)
        {
            document.getElementById('family_name_oth_lang').disabled = true;
			if(document.getElementById('pat_name_as_multipart_yn').value == 'Y')
				document.getElementById('bfamo').disabled = true;
            document.getElementById('family_name_oth_lang').value=""
            putLocalLangPatientName(document.getElementById('family_name_oth_lang'))
        }

        if(document.getElementById('name_prefix') != null)
        {
            document.getElementById('name_prefix').disabled = true;
            document.getElementById('name_prefix').options[0].selected = true;
        }
        if(document.getElementById('name_prefix_oth_lang') != null)
        {
            document.getElementById('name_prefix_oth_lang').disabled = true;
            document.getElementById('name_prefix_oth_lang').options[0].selected = true;
        }
        if(document.getElementById('name_suffix') != null)
        {
			document.getElementById('name_suffix').disabled = true;
            document.getElementById('name_suffix').options[0].selected = true;
        }
        if(document.getElementById('name_suffix_oth_lang') != null)
        {
            document.getElementById('name_suffix_oth_lang').disabled = true;
            document.getElementById('name_suffix_oth_lang').options[0].selected = true;
        }
        if(document.getElementById('alt_id1_no') != null)
        {
            document.getElementById('alt_id1_no').disabled = true;
            document.getElementById('alt_id1_no').value="";
			
        }
		if(document.getElementById('alt_id1_reqd_yn') != null)
			if(document.getElementById('alt_id1_reqd_yn').value == 'Y')
				document.getElementById('alt1_gif').style.visibility = 'hidden';

        if(document.getElementById('alt_id1_exp_date') != null)
        {
            document.getElementById('alt_id1_exp_date').readOnly = true;
            document.getElementById('alt_id1_exp_date').value="";
			document.getElementById('altidexpdt1').disabled = true;
        }
		
		if(document.getElementById('alt_id2_no') != null)
        {
            document.getElementById('alt_id2_no').disabled = true;
            document.getElementById('alt_id2_no').value="";
        }
		if(document.getElementById('alt_id2_reqd_yn') != null)
			if(document.getElementById('alt_id2_reqd_yn').value == 'Y')
				document.getElementById('alt2_gif').style.visibility = 'hidden';

        if(document.getElementById('alt_id2_exp_date') != null)
        {
            document.getElementById('alt_id2_exp_date').readOnly = true;
            document.getElementById('alt_id2_exp_date').value="";
			document.getElementById('altidexpdt2').disabled = true;
        }
		if(document.getElementById('family_link_no') != null)
        {
            document.getElementById('family_link_no').readOnly = true;
            document.getElementById('head_pat_search').disabled = true;
            document.getElementById('family_link_no').value="";
        }
		if(document.getElementById('head_pat_search') != null)
        {
            document.getElementById('head_pat_search').disabled = true;
        }
		if(document.forms[0].flag.value!='Y')
		{
			while( 0 < document.getElementById('pat_ser_grp_code').options.length)
			{
				document.getElementById('pat_ser_grp_code').remove(0);
			}

			/*Adding the 'Select' option to the PAtient Series list as previous values are removed.*/
			var opt = document.createElement('Option');
			opt.value='';
			opt.text="---"+getLabel("Common.defaultSelect.label","Common")+"---";

			document.getElementById('pat_ser_grp_code').add(opt);
			
			for(var j=0; j< def_series.length;j++)
			{
				if(def_series[j] != null && def_series[j] != '')
				{
					var arr = def_series[j].split('`');
					var opt = document.createElement('Option');
					opt.value=arr[0];
					opt.text=arr[1];
					document.getElementById('pat_ser_grp_code').add(opt)
						
				}
			}
		}
        
		document.getElementById('patient_group').value = 'G'
	    parent.frames[0].document.getElementById('patient_id').value="" ;
		
       /*if(document.getElementById('pat_no_gen_yn').value != 'N') { */
            //parent.frames[0].document.getElementById('patient_id').readOnly = true;
		//}
		
		if(parent.frames[0].document.getElementById('patient_name_loc_lang') !=null)
            parent.frames[0].document.getElementById('patient_name_loc_lang').value="";

		document.getElementById('natimg').style.visibility = 'hidden';
		//document.getElementById('image1').style.visibility = 'hidden';//Added on 3/29/2005	

		if(document.getElementById('other_alt_id')!=null)
		{		
			document.getElementById('other_alt_id').options[0].selected=true;
			document.getElementById('other_alt_id').disabled = true;
			document.getElementById('other_alt_Id_text').value = '';
			document.getElementById('other_alt_Id_text').disabled = true;
		}
		//Added on 3/31/2005 to clear the head patient name when the Details Unknown is checked
		if(document.getElementById('head_pat_name') != null)
			document.getElementById('head_pat_name').innerHTML="&nbsp;";

		//Added on 3/31/2005 to disable the "Relationship to Head" field when the Details Unknown is checked.
		if(document.getElementById('relationship_to_head') != null)
		{
			document.getElementById('relationship_to_head_desc').disabled=true;
			document.getElementById('relationship_to_head_desc').value="";
			document.getElementById('relationship_to_head_desc').value="";
			document.getElementById('relationship_to_head_code_id').disabled=true;
			document.getElementById('relationship_to_head').disabled=true;
			//document.getElementById('relationship_to_head').options[0].selected = true;
		}

		 if( document.forms[0].relationship_level1_desc)
		{
		 document.forms[0].relationship_level1_desc.value="";
		 document.forms[0].relationship_level1_code.value="";
		 document.getElementById('relnlabel').innerHTML="&nbsp";
		 document.getElementById('relntext').innerHTML="&nbsp";
		}

		if(document.getElementById('ext_button') != null)
		{
				document.getElementById('ext_button').disabled = true;
		}	
		/*Added by Vinod 3/3/2006 - for new fields */
	if( document.forms[0].family_org_membership != null )
	{
		document.forms[0].family_org_membership.value = "";
		document.forms[0].family_org_membership.disabled = true;
		document.forms[0].family_org_mem_img.style.visibility = 'hidden';
	}
	if( document.forms[0].organization != null )
	{
		document.forms[0].organization.value = "";
		document.forms[0].organization.disabled = true;
		document.getElementById('org_id_btn').disabled = true;
	}
	/*
	if( document.forms[0].sub_organization != null )
	{
		document.forms[0].sub_organization.value = "";
		document.forms[0].sub_organization.disabled = true;
	}
	*/

	if( document.forms[0].sub_org_desc != null )
	{
		document.forms[0].sub_org_desc.value = "";
		document.forms[0].sub_organization.value = "";
		document.forms[0].sub_org_desc.disabled = true;
	}

	if( document.forms[0].mar_status_code != null )
	{
		document.forms[0].mar_status_code.value = "";
		document.forms[0].mar_status_desc.value = "";
		document.forms[0].mar_status_code.disabled = true;
		document.forms[0].mar_status_desc.disabled = true;
		document.forms[0].mar_status_code_id.disabled = true;
	}
	if( document.forms[0].pat_cat_code != null )
	{
		document.forms[0].pat_cat_code.value = "";
		document.forms[0].pat_cat_desc.value = "";
		document.forms[0].pat_cat_code.disabled = true;
		document.forms[0].pat_cat_desc.disabled = true;
		document.forms[0].pat_cat_code_id.disabled = true;
		document.forms[0].imgCategoryMan.style.visibility = 'hidden';
	}
	if( document.forms[0].pat_cat_code_exp_date != null )
	{
		document.forms[0].pat_cat_code_exp_date.value = "";
		document.forms[0].pat_cat_code_exp_date.disabled = true;
	}
	if( document.getElementById('imgCatExpDate') != null )
	{
		document.getElementById('imgCatExpDate').disabled = true;
	} 
	if( document.forms[0].ethnic_group != null )
	{
		document.forms[0].ethnic_group.value = "";
		document.forms[0].ethnic_group_desc.value = "";
		document.forms[0].ethnic_group.disabled = true;
		document.forms[0].ethnic_group_desc.disabled = true;
		document.forms[0].ethnic_group_id.disabled = true;
	}
	if( document.forms[0].place_of_birth_desc != null )
	{
		document.forms[0].place_of_birth_desc.value = "";
		document.forms[0].place_of_birth_desc.readOnly = true;
	}
	if( document.forms[0].place_of_birth != null )
	{
		document.forms[0].place_of_birth.value = "";
		document.forms[0].place_of_birth.readOnly = true;
	}
	if( document.getElementById('birth_place') != null )
	{
		document.getElementById('birth_place').disabled = true;
	}
	
	if( document.getElementById('name_prefix_img') != null )
	{
		document.getElementById('name_prefix_img').style.visibility = 'hidden';
	}
	if( document.getElementById('name_prefix_oth') != null )
	{
		document.getElementById('name_prefix_oth').style.visibility = 'hidden';
	}
	
	/*End added by Vinod*/
	
	 /* Added for IN:046495 by Dharma on 16th Jan 2014 Start*/
	  
	  if(document.getElementById('alt_id1_man_non_ctz') && document.getElementById('alt_id1_man_non_ctz').value=="true"){ 
			   if(document.getElementById('alt1_gif')){
				  document.Emergency_Regn.alt_id1_reqd_yn.value='N'; 
				  document.getElementById('alt1_gif').style.visibility='hidden';
			   }
			   if(document.getElementById('alt1_exp_date1')){
				  document.Emergency_Regn.alt_date1_reqd_yn.value='N';
				  document.getElementById('alt1_exp_date1').style.visibility='hidden';			
			   } 
		  }
		//Added by Maheshwaran K for AAKH-CRF-0145
		var isNatIdAltIdMandVisaType	= document.getElementById('isNatIdAltIdMandVisaType').value;//Maheshwaran added for AAKH-CRF-0145 as on 22-04-2022 
		if( isNatIdAltIdMandVisaType=="true"){
		getVisibleMandNatAltIds();	
		} 
		//Ends
 /* Added for IN:046495 by Dharma on 16th Jan 2014 End*/

	

		parent.patient_sub.focus();
    }

	if(document.forms[0].details_unknown.checked == false)
    {
	   
	   	//Below line added for this CRF ML-MMOH-SCF-0719
		if((document.forms[0].func_act && document.forms[0].func_act.value!="Visitreg") && (document.forms[0].func_act && document.forms[0].func_act.value!="")) {		
			if(parent.frames[0].document.getElementById('patient_name')!=null)
			{
			  parent.frames[0].document.getElementById('patient_name').value="";
			}
		}
		//End this CRF ML-MMOH-SCF-0719
		
		if(parent.frames[0].document.getElementById('patient_name_loc_lang')!=null)
		{
		  parent.frames[0].document.getElementById('patient_name_loc_lang').value="";
		}
		document.getElementById('details_unknown').value="N";
			
		if(document.forms[0].relgn_code != null)
		{
			document.getElementById('relgn_code').disabled = false;
		}
		   
		if ( (document.Emergency_Regn.nationality_code) && (document.getElementById('dflt_nationality_code').value=='') )
			document.getElementById('nationality_desc').value = '';
		else
		{
		//	document.getElementById('nationality_code').value=document.getElementById('dflt_nationality_code').value;
		//	document.getElementById('nationality_desc').value=document.getElementById('dflt_nationality_desc').value;
		}
		
		document.getElementById('natimg').style.visibility ='visible';
		document.getElementById('contry_code').disabled = false;
		document.getElementById('nationality_desc').readOnly = false;

		/*
		
		val = document.getElementById('pat_ser_grp_code').value;
        for(i=0;i<PSGCodeArray.length;i++)
        {
            if(PSGCodeArray[i] == val)
            {
                if(PSGYNArray[i] == "N")
                {
                    parent.frames[0].document.getElementById('patient_id').readOnly = false;
                    break;
                }
                else
                    parent.frames[0].document.getElementById('patient_id').readOnly =true ;
            }
        }

		*/
		//parent.frames[0].document.getElementById('patient_name').value = "";

		if( document.forms[0].national_id_no != null)
		{
					document.forms[0].national_id_no.readOnly = false;

			if(document.forms[0].nat_id_reqd_all_series.value == 'Y')
				document.forms[0].nat_gif.style.visibility = 'visible';	
		}
        if(document.getElementById('first_name') != null)
            if(document.getElementById('first_name').disabled == true)
            {
                document.getElementById('first_name').disabled = false;
                document.getElementById('bf').disabled = false;
				document.getElementById('first_name').value="";
            }
        if(document.getElementById('second_name') != null)
            if(document.getElementById('second_name').disabled == true)
            {
                document.getElementById('second_name').disabled = false;
                document.getElementById('bs').disabled = false;
				document.getElementById('second_name').value="";
            }
        if(document.getElementById('third_name') != null)
            if(document.getElementById('third_name').disabled == true)
            {
                document.getElementById('third_name').disabled = false;
                document.getElementById('bt').disabled = false;
				document.getElementById('third_name').value="";
            }
        if(document.getElementById('family_name') != null)
			if(document.getElementById('family_name').disabled == true)
            {
              
                 document.getElementById('family_name').disabled = false;
				document.getElementById('family_name').value="";
			}
								
				//Added by Mallikarjuna on 13/03/2003
                if(document.getElementById('bfam'))
				{
					document.getElementById('bfam').disabled = false;
				}  
				//End of the addition			
				
           
        if(document.getElementById('first_name_oth_lang') != null)
            if(document.getElementById('first_name_oth_lang').disabled == true)
            {
                document.getElementById('first_name_oth_lang').disabled = false;
                document.getElementById('bfo').disabled = false;
				document.getElementById('first_name_oth_lang').value = "";
            }
        if(document.getElementById('second_name_oth_lang') != null)
            if(document.getElementById('second_name_oth_lang').disabled == true)
            {
                document.getElementById('second_name_oth_lang').disabled = false;
                document.getElementById('bso').disabled = false;
				document.getElementById('second_name_oth_lang').value = "";
            }
        if(document.getElementById('third_name_oth_lang') != null)
            if(document.getElementById('third_name_oth_lang').disabled == true)
            {
                document.getElementById('third_name_oth_lang').disabled = false;
                document.getElementById('bto').disabled = false;
				document.getElementById('third_name_oth_lang').value = "";
            }
        if(document.getElementById('family_name_oth_lang') != null)
            if(document.getElementById('family_name_oth_lang').disabled == true)
            {
                document.getElementById('family_name_oth_lang').disabled = false;
				document.getElementById('family_name_oth_lang').value = "";
				if(document.getElementById('pat_name_as_multipart_yn').value == 'Y')
					document.getElementById('bfamo').disabled = false;
            }

        if(document.getElementById('name_prefix') != null)
            if(document.getElementById('name_prefix').disabled == true)
                document.getElementById('name_prefix').disabled = false;
        if(document.getElementById('name_suffix') != null)
            if(document.getElementById('name_suffix').disabled == true)
                document.getElementById('name_suffix').disabled = false;
        if(document.getElementById('name_suffix_oth_lang') != null)
        {
            document.getElementById('name_suffix_oth_lang').disabled = false;
            document.getElementById('name_suffix_oth_lang').options[0].selected = true;
        }
        if(document.getElementById('name_prefix') != null)
        {
            document.getElementById('name_prefix').disabled = false;
        }
        if(document.getElementById('name_prefix_oth_lang') != null)
        {
            document.getElementById('name_prefix_oth_lang').disabled = false;
        }
		
        if(document.getElementById('alt_id1_no') != null && document.getElementById('alt_id1_accept_oth_pat_ser_yn').value=="Y")
        {
            document.getElementById('alt_id1_no').disabled = false;
        }

		if(document.getElementById('alt_id1_reqd_yn') != null)
			if(document.getElementById('alt_id1_reqd_yn').value == 'Y')
				document.getElementById('alt1_gif').style.visibility = 'visible';

		if(document.getElementById('alt_id2_no') != null)
        {
			if(document.getElementById('alt_id2_accept_oth_pat_ser_yn').value=="Y")
				  document.getElementById('alt_id2_no').disabled = false;
        }		
		if(document.getElementById('alt_id2_reqd_yn') != null)
			if(document.getElementById('alt_id2_reqd_yn').value == 'Y' && document.getElementById('alt_id2_accept_oth_pat_ser_yn').value=="Y"){
			
				document.getElementById('alt2_gif').style.visibility = 'visible';
			}

		if (document.getElementById('pat_ser_grp_code').options.length <=1){
			if (document.getElementById('gender'))
				document.getElementById('gender').focus();
		}
		if( document.getElementById('other_alt_id') !=null)
			document.getElementById('other_alt_id').disabled=false;



    if( document.forms[0].alt_id1_no  != null )
    {
        document.forms[0].alt_id1_no.value = "";
    }
	if( document.forms[0].alt_id2_no  != null )
    {
        document.forms[0].alt_id2_no.value = "";
     }

    
    if(document.getElementById('family_link_no') != null)
       {
            document.getElementById('family_link_no').readOnly = false;
			document.getElementById('head_pat_search').disabled = false;
       }
	if(document.getElementById('head_pat_search') != null)
        {
            document.getElementById('head_pat_search').disabled = false;
        }

     if( document.forms[0].relationship_to_head)
	{
        if(!document.forms[0].relationship_to_head . disabled)
            document.forms[0].relationship_to_head . disabled = !document.forms[0].relationship_to_head . disabled

        if(document.forms[0].relationship_to_head . disabled)
		{
            //document.forms[0].relationship_to_head .options[0].selected= true;
		document.forms[0].relationship_to_head_desc.disabled= false;
		document.forms[0].relationship_to_head_code_id.disabled= false;
		}
	}
	  //below line commented for this incident [46630]

	 /*   if( document.forms[0].alt_id1_exp_date  != null )
        {
			document.getElementById('altidexpdt1').disabled = false; 
       }
		if( document.forms[0].alt_id2_exp_date  != null )
        {
			// document.forms[0].alt_id2_exp_date.disabled = false;
			document.getElementById('altidexpdt2').disabled = false;
        }*/
		//End incident [46630]
		
		if(document.getElementById('pat_ser_grpcode').value != document.getElementById('pat_ser_grp_code').value || first_time)
		{
			checkPatGenYN()
			first_time = false;
		}
		
		if(document.getElementById('ext_button') != null)
		{
			document.getElementById('ext_button').disabled = false;
		}
		//document.getElementById('image1').style.visibility = 'visible'; //Added on 3/29/2005	
		/*Added by Vinod 3/3/2006 - for new fields */				

	if( document.forms[0].family_org_membership != null )
	{
		document.forms[0].family_org_membership.disabled = false;
		document.forms[0].family_org_mem_img.style.visibility = 'visible';
	}
	/*
	if( document.forms[0].organization != null )
	{
		document.forms[0].organization.readOnly = false;
	}
	if( document.forms[0].all.org_id_btn != null )
	{
		document.forms[0].all.org_id_btn.disabled = false;
	}
	
	if( document.forms[0].sub_organization != null )
	{
		document.forms[0].sub_organization.disabled = false;
	}
	
	if( document.forms[0].sub_org_desc != null )
	{
		document.forms[0].sub_org_desc.disabled = false;
	}
	*/
	if( document.forms[0].mar_status_code != null )
	{
		document.forms[0].mar_status_code.disabled = false;
		document.forms[0].mar_status_desc.disabled = false;
		document.forms[0].mar_status_code_id.disabled = false;
	}
	if( document.forms[0].pat_cat_code != null )
	{	
		document.forms[0].pat_cat_code.disabled = false;
		document.forms[0].pat_cat_desc.disabled = false;
		document.forms[0].pat_cat_code_id.disabled = false;
		document.forms[0].imgCategoryMan.style.visibility = 'visible';
	}
	if( document.forms[0].pat_cat_code_exp_date != null )
	{
		document.forms[0].pat_cat_code_exp_date.disabled = false;
	}
	if( document.getElementById('imgCatExpDate') != null )
	{
		document.getElementById('imgCatExpDate').disabled = false;
	} 
	if( document.forms[0].ethnic_group != null )
	{
		document.forms[0].ethnic_group.disabled = false;
		document.forms[0].ethnic_group_desc.disabled = false;
		document.forms[0].ethnic_group_id.disabled = false;
	}
	if( document.forms[0].place_of_birth_desc != null )
	{
		document.forms[0].place_of_birth_desc.readOnly = false;
	}
	if( document.forms[0].place_of_birth != null )
	{
		document.forms[0].place_of_birth.readOnly = false;
	}
	if( document.getElementById('birth_place') != null )
	{
		document.getElementById('birth_place').disabled = false;
	}
	if( document.getElementById('name_prefix_img') != null )
	{
		document.getElementById('name_prefix_img').style.visibility = 'hidden';
	}
	if( document.getElementById('name_prefix_oth') != null )
	{
		document.getElementById('name_prefix_oth').style.visibility = 'hidden';
	}
	if(document.getElementById('name_prefix_img') && document.getElementById('name_prefix_reqd_yn').value == 'Y' )
		document.getElementById('name_prefix_img').style.visibility='visible'; 
	else if(document.getElementById('name_prefix_img'))
		document.getElementById('name_prefix_img').style.visibility='hidden';
	/*End added by Vinod*/
 /* Added for IN:046495 by Dharma on 16th Jan 2014 Start*/
	if(document.getElementById('citizen').checked==true) {
	  if(document.getElementById('alt_id1_man_non_ctz') && document.getElementById('alt_id1_man_non_ctz').value=="true"){ 
			   if(document.getElementById('alt1_gif')){
				  document.Emergency_Regn.alt_id1_reqd_yn.value='N'; 
				  document.getElementById('alt1_gif').style.visibility='hidden';
			   }
			   if(document.getElementById('alt1_exp_date1')){
				  document.Emergency_Regn.alt_date1_reqd_yn.value='N';
				  document.getElementById('alt1_exp_date1').style.visibility='hidden';			
			   } 
		  }
	}else{
		if(document.getElementById('alt_id1_man_non_ctz') && document.getElementById('alt_id1_man_non_ctz').value=="true" ) { 
			  if(document.getElementById('alt1_gif')){
				 document.getElementById('alt_id1_reqd_yn').value='Y'; 
				 document.getElementById('alt1_gif').style.visibility='visible';
				 document.getElementById('alt_id1_no').disabled=false;
			  }
			  if(document.getElementById('alt1_exp_date1')){
				 document.getElementById('alt_date1_reqd_yn').value='Y';
				 document.getElementById('alt1_exp_date1').style.visibility='visible';
			  }						
			}
	}
 /* Added for IN:046495 by Dharma on 16th Jan 2014 End*/

	var isNatIdOrAltIdMandVisaType	= document.getElementById('isNatIdOrAltIdMandVisaType').value;
	var isNatIdAltIdMandVisaType	= document.getElementById('isNatIdAltIdMandVisaType').value;//Maheshwaran added for AAKH-CRF-0145 as on 22-04-2022
	var isNatIdOrAltId1MandRes		= document.getElementById('isNatIdOrAltId1MandRes').value;
	//Maheshwaran added isNatIdAltIdMandVisaType for AAKH-CRF-0145 as on 22-04-2022
		if(isNatIdOrAltIdMandVisaType=="true" || isNatIdOrAltId1MandRes=="true" || isNatIdAltIdMandVisaType=="true"){
			getVisibleMandNatAltIds();
		}
	}
	
    if( document.forms[0].pat_ser_grp_code != null)
    {
		/*	flag is "Y" for AE. This condition does not default the Patient Series when called from AE.
			So commented by Vinod - 4/5/2006
			if(document.forms[0].flag.value!='Y')
		*/
		
		/*Added by Thamizh selvi on 24th July 2017 for ML-MMOH-CRF-0689 Start*/
		var called_from = document.forms[0].called_from.value;
		if(called_from == "MO_BID_REGN" || called_from == "MO_EBP_REGN"){
			if(document.forms[0].pat_ser_grp_code[1] != null){
				document.forms[0].pat_ser_grp_code[1].selected = true;
				document.forms[0].pat_ser_grp_code.disabled = true;
			}
		}/*End*/
        else if(document.forms[0].dflt_grp.value != '')
        {
			//document.forms[0].pat_ser_grp_code.value = document.forms[0].dflt_grp.value;
			//Commented the above line by Ashwin K for for AAKH-CRF-0150


			if(document.forms[0].pat_ser_grp_code.value == '') // Added if condition by Ashwin K for AAKH-CRF-0150
			{
			document.forms[0].pat_ser_grp_code.value = document.forms[0].dflt_grp.value;
			}
			// Ended if condition by Ashwin K for AAKH-CRF-0150

            if(document.forms[0].pat_ser_grp_code.value == '')
				  if(document.forms[0].pat_ser_grp_code[0])	
				 	document.forms[0].pat_ser_grp_code[0].selected = true;
			
		/*Added by Dharma on Feb 9th 2017 against GDOH-SCF-0244 [IN:063491] Start*/
		if(document.getElementById('isNatIdMandatory').value=="Y"){
			if(document.forms[0].dflt_grp.value == document.getElementById('nat_id_pat_ser_grp').value && document.forms[0].details_unknown.checked == false){
				document.getElementById('nat_gif').style.visibility="visible";
				document.getElementById('nat_id_reqd_all_series').value="Y";
			}else{
				document.getElementById('nat_gif').style.visibility="hidden";
				document.getElementById('nat_id_reqd_all_series').value="N";
			}
		}
		/*Added by Dharma on Feb 9th 2017 against GDOH-SCF-0244 [IN:063491] End*/
        }
        else
        {
           alert(getMessage("EMER_SER_NOT_DEFINED",'MP') );
		   if(document.forms[0].pat_ser_grp_code[0])
           document.forms[0].pat_ser_grp_code.options[0].selected = true;
        }
		//commented by sudhakar to check the impact of allowing to change patient series when the registration function invoked from AE unknown details is checked.
		//document.forms[0].pat_ser_grp_code.disabled = !document.forms[0].pat_ser_grp_code.disabled ;
		
		if(document.forms[0].flag.value=='Y')
        document.forms[0].pat_ser_grp_code.disabled =  false;		
    }

	if(parent.frames[0].document.getElementById('patient_id')!=null)
	{
			val = document.getElementById('pat_ser_grp_code').value;

			for(i=0;i<PSGCodeArray.length;i++)
			{
				if(PSGCodeArray[i] == val)
				{
					if(PSGYNArray[i] == "N")
					{
						parent.frames[0].document.getElementById('patient_id').readOnly = false;

						if(document.forms[0].details_unknown.checked == true)
						{
							alert(getMessage("PAT_ID_SERIES",'MP'))			
							if(parent.patient_main.document.forms[0].patient_id){
							  parent.patient_main.document.forms[0].patient_id.readOnly = false;
							  parent.patient_main.document.forms[0].patient_id.value = '';
							  parent.patient_main.document.forms[0].patient_id.focus();
							}
							document.getElementById('pat_no_gen_yn').value  = 'N';
						}

						break;
					}
					else{

						if(document.forms[0].details_unknown.checked == true)
						{
							document.getElementById('pat_no_gen_yn').value  = 'Y';
							if(parent.patient_main.document.forms[0].patient_id){								
								parent.patient_main.document.forms[0].patient_id.value = '';
							}
						}

						parent.frames[0].document.getElementById('patient_id').readOnly =true ;
					}
				}
			}
	}

}

function apply() {  
		
	if(f_query_add_mod.patient_sub==null) {  
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}
	else {  
	if(f_query_add_mod.patient_sub.Emergency_Regn.date_of_birth.disabled) {
        f_query_add_mod.patient_sub.Emergency_Regn.date_of_birth.disabled = false;
        f_query_add_mod.patient_sub.Emergency_Regn.date_of_birth.readOnly = true;
    }
	
if(f_query_add_mod.patient_sub.Emergency_Regn.hij_appl_YN.value=="Y") {
	if(f_query_add_mod.patient_sub.Emergency_Regn.date_of_birth_hj.disabled) {
        f_query_add_mod.patient_sub.Emergency_Regn.date_of_birth_hj.disabled = false;
        f_query_add_mod.patient_sub.Emergency_Regn.date_of_birth_hj.readOnly = true;
    }
}

/*Commented the below code for SRR20056-SCF-6368 [IN:025789] by Suresh M on 10.01.2010
   if(f_query_add_mod.patient_sub.document.getElementById('details_unknown').checked==true)
	{
	         if(f_query_add_mod.patient_sub.document.getElementById('sex').value =="M")
				sel_gender = getLabel("Common.male.label","common");
			else if(f_query_add_mod.patient_sub.document.getElementById('sex').value =="F")
				sel_gender = getLabel("Common.female.label","common");
			else if(f_query_add_mod.patient_sub.document.getElementById('sex').value =="U")
				sel_gender = getLabel("Common.unknown.label","common");
			if(f_query_add_mod.patient_sub.document.getElementById('family_name')) {
				f_query_add_mod.patient_sub.document.getElementById('family_name').value = getLabel("Common.unknown.label","common")+sel_gender;
			}
	
	}
	*/
	
	
	if(multipleclicks == 'false')
    {
	    multipleclicks='true';
		LocalErrors = '';
	    var Alt_error= new String();

		var canSave = new Boolean(true);
		var splField = new Array();
		var splFieldName = new Array();

		if(f_query_add_mod.patient_sub.document.getElementById('accept_national_id_no').value == "Y")
		{
			splField = new Array(f_query_add_mod.patient_main.document.getElementById('patient_id'),
								 f_query_add_mod.patient_sub.document.getElementById('national_id_no')
								 );
			splFieldName = new Array(getLabel("Common.patientId.label","common"),f_query_add_mod.patient_sub.document.getElementById('nat_id_prompt').value);
		}
		else
		{
			if(f_query_add_mod.patient_sub.document.getElementById('details_unknown').checked == false)
			{
				splField = new Array(f_query_add_mod.patient_main.document.getElementById('patient_id'));
				splFieldName = new Array(getLabel("Common.patientId.label","common"));
			}
		}

		if(f_query_add_mod.patient_sub.document.getElementById('family_link_no') != null)
		{
			splField[splField.length] = f_query_add_mod.patient_sub.document.getElementById('family_link_no')
			splFieldName[splFieldName.length]   = getLabel("eMP.HeadPatientID.label","MP")
		}

		if(f_query_add_mod.patient_sub.document.getElementById('func_act').value == 'Visitreg')
		{
			canSave = f_query_add_mod.patient_sub.SpecialCharCheck(splField, splFieldName, '',"A")
			if(!canSave)
				parent.commontoolbarFrame.location.href ='../jsp/EmergRegToolBar.jsp';
		}
		else
			canSave = f_query_add_mod.patient_sub.SpecialCharCheck(splField, splFieldName, messageFrame,"M","../../eCommon/jsp/error.jsp")
        if ( canSave )
		{

			f_query_add_mod.patient_main.document.getElementById('patient_name').focus();

			// VARIABLE TO CHECK WHETHER ANY 1 ERROR IS ENCOUNTERED SO THAT FORM IS BLOCKED FROM SUBMITION
			var errorsThere = new Boolean(false);
			
			f_query_add_mod.patient_sub.document.getElementById('patient_name').value = f_query_add_mod.patient_main.document.getElementById('patient_name').value;

			if( f_query_add_mod.patient_main.document.getElementById('patient_name_loc_lang') != null)
				f_query_add_mod.patient_sub.document.getElementById('patient_name_loc_lang').value = f_query_add_mod.patient_main.document.getElementById('patient_name_loc_lang').value;

			f_query_add_mod.patient_sub.document.getElementById('patient_id').value = f_query_add_mod.patient_main.document.getElementById('patient_id').value;

			//Added by Kamatchi S for AAKH-CRF-0145
				if(f_query_add_mod.patient_sub.document.getElementById('details_unknown').checked == false) {
		if(f_query_add_mod.patient_sub.document.getElementById('isNatIdAltIdMandVisaType').value == "true")

				{
			//	if(document.forms[0].details_unknown.checked==false)
			//	{
			if(f_query_add_mod.patient_sub.document.getElementById('visa_type').value=="" && f_query_add_mod.patient_sub.document.getElementById('citizen')[1].checked==true)
			{  
				canSave=checkForNull(getLabel('eMP.VisaType.label','MP'));
			}
			//	}
								}
            if ( canSave == false )
                errorsThere = true;
			
		
			if(f_query_add_mod.patient_sub.document.getElementById('isNatIdAltIdMandVisaType').value == "true" && f_query_add_mod.patient_sub.document.getElementById('citizen')[1].checked == true && f_query_add_mod.patient_sub.document.getElementById('visa_type').value == "W" && f_query_add_mod.patient_sub.document.getElementById('national_id_no').value == "")
			{
 
				if(f_query_add_mod.patient_sub.document.getElementById('nat_gif').style.visibility == "visible"){
					var message1=getLabel('eMP.ResidentWork.label','MP')
					error	= getMessage('RES_VISA_TYPE','MP');
					error = error.replace("#",f_query_add_mod.patient_sub.document.getElementById('nat_id_prompt').value);
					error = error.replace("$",message1);
					LocalErrors += error+ "<br>";
					canSave = false;
				}

			}
			if ( canSave == false )
                errorsThere = true;
			
 
			if(f_query_add_mod.patient_sub.document.getElementById('isNatIdAltIdMandVisaType').value == "true" && f_query_add_mod.patient_sub.document.getElementById('citizen')[1].checked==true && f_query_add_mod.patient_sub.document.getElementById('visa_type').value == "V" && f_query_add_mod.patient_sub.document.getElementById('alt_id1_no').value == "" && f_query_add_mod.patient_sub.document.getElementById('alt_id2_no').value == "")
			{
				if(f_query_add_mod.patient_sub.document.getElementById('alt1_gif').style.visibility == "visible" && f_query_add_mod.patient_sub.document.getElementById('alt2_gif').style.visibility == "visible"){
					var message1=f_query_add_mod.patient_sub.document.getElementById('altId1Desc').value;
					var message2=f_query_add_mod.patient_sub.document.getElementById('altId2Desc').value;
					var message3=getLabel('Common.Visit.label','common');
					error	= getMessage('VISIT_VISA_TYPE','MP');
					error = error.replace("#",message1);
					error = error.replace("@",message2);
					error = error.replace("$",message3);
					LocalErrors += error+ "<br>";
					canSave = false
				}
			}
			else if(f_query_add_mod.patient_sub.document.getElementById('isNatIdAltIdMandVisaType').value == "true" && f_query_add_mod.patient_sub.document.getElementById('citizen')[1].checked==true && f_query_add_mod.patient_sub.document.getElementById('visa_type').value == "V" && f_query_add_mod.patient_sub.document.getElementById('alt_id1_no').value == "")
			{
				if(f_query_add_mod.patient_sub.document.getElementById('alt1_gif').style.visibility == "visible"){
					var message1=f_query_add_mod.patient_sub.document.getElementById('altId1Desc').value;
					var message3=getLabel('Common.Visit.label','common');
					error	= getMessage('VISIT_VISA_TYPE','MP');
					error = error.replace("# and @",message1);
					error = error.replace("$",message3);
					LocalErrors += error+ "<br>";
					canSave = false
				}
			}
			else if(f_query_add_mod.patient_sub.document.getElementById('isNatIdAltIdMandVisaType').value == "true" && f_query_add_mod.patient_sub.document.getElementById('citizen')[1].checked==true && f_query_add_mod.patient_sub.document.getElementById('visa_type').value == "V" && f_query_add_mod.patient_sub.document.getElementById('alt_id2_no').value == "")
			{
				if(f_query_add_mod.patient_sub.document.getElementById('alt2_gif').style.visibility == "visible"){
					var message2=f_query_add_mod.patient_sub.document.getElementById('altId2Desc').value;
					var message3=getLabel('Common.Visit.label','common');
					error	= getMessage('VISIT_VISA_TYPE','MP');
					error = error.replace("# and @",message2);
					error = error.replace("$",message3);
					LocalErrors += error+ "<br>";
					canSave = false
				}
			}
				}
			/*End AAKH-CRF-0145*/
			//TO CHECK THE PATIENT SEX IS NOT NULL
			if (f_query_add_mod.patient_sub.document.getElementById('sex').selectedIndex == 0)
			{
				if(f_query_add_mod.patient_sub.document.getElementById('sex').value=="")
				{	
					canSave =  checkForNull(getLabel("Common.gender.label","common"));
//					checkForNull(canSave);
				}
			}
			if ( canSave == false )
				errorsThere = true;

			if (f_query_add_mod.patient_sub.document.getElementById('pat_ser_grp_code') != null)
			{
				if(f_query_add_mod.patient_sub.document.getElementById('pat_ser_grp_code').value =="")
				{
				canSave = checkForNull(getLabel("eMP.PatientSeries.label","MP"));
				//checkForNull(canSave);
				}
			}
			if ( canSave == false )
				errorsThere = true;
          	   /* Added for IN:046495 by Dharma on 16th Jan 2014 Start*/		  
			var tempflagchk = new Boolean(false);	
			if(f_query_add_mod.patient_sub.document.getElementById('details_unknown').checked ==false){
			if(f_query_add_mod.patient_sub.document.getElementById('alt_id1_reqd_yn').value == 'Y' && f_query_add_mod.patient_sub.document.getElementById('alt_id1_man_non_ctz') && f_query_add_mod.patient_sub.document.getElementById('alt_id1_man_non_ctz').value=="true" )
				{
					if(f_query_add_mod.patient_sub.document.getElementById('alt1_gif').style.visibility == 'visible') {	

						if(f_query_add_mod.patient_sub.document.getElementById('alt_id1_no').value=="")
						{
							 canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('alt_id1_no'),f_query_add_mod.patient_sub.document.getElementById('altId1Desc').value);
						}		 
					}
					if ( canSave == false ){
						errorsThere = true;
						tempflagchk=true;
					}	
				}
								
					if(f_query_add_mod.patient_sub.document.getElementById('alt_date1_reqd_yn').value == 'Y' && f_query_add_mod.patient_sub.document.getElementById('alt_id1_man_non_ctz') && f_query_add_mod.patient_sub.document.getElementById('alt_id1_man_non_ctz').value=="true")
				{   
					if(f_query_add_mod.patient_sub.document.getElementById('alt1_exp_date1').style.visibility == 'visible') {	

						if(f_query_add_mod.patient_sub.document.getElementById('altidexpdate1').value=="")
						{  
							canSave=checkForNull(getLabel('Common.expiryDate.label','common'));
						}		 
					}
					if ( canSave == false )
						errorsThere = true;
				}
			}
		//AAKH CRF 168
			  if ( f_query_add_mod.patient_sub.document.getElementById('alt_id1_no') != null && tempflagchk==false)
            {
								
				 if ( (!f_query_add_mod.patient_sub.document.getElementById('alt_id1_no').disabled) && (!f_query_add_mod.patient_sub.document.getElementById('family_org_membership')))
				{
		            pat_ser_grp_obj = f_query_add_mod.patient_sub.document.getElementById('pat_ser_grp_code');				
					
						if (f_query_add_mod.patient_sub.document.getElementById('alt1_gif').style.visibility=='visible')
						{
					//Added by Kamatchi S for AAKH-CRF-0145
					var isNatIdAltIdMandVisaType	= f_query_add_mod.patient_sub.document.getElementById('isNatIdAltIdMandVisaType').value;
					//Maheshwaran K added for AAKH-CRF-0168 as on 22-10-2022
					if( isNatIdAltIdMandVisaType == "true" && f_query_add_mod.patient_sub.document.getElementById('visa_type').value != "V"){
				//	if( isNatIdAltIdMandVisaType == "false"){
							canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('alt_id1_no'),f_query_add_mod.patient_sub.document.getElementById('altId1Desc').value);
					}
						}
					//}
                   
                    if ( canSave == false )
                        errorsThere = true;
                }
            }

           if ( f_query_add_mod.patient_sub.document.getElementById('alt_id2_no') != null )
            {
                if(!f_query_add_mod.patient_sub.document.getElementById('alt_id2_no').disabled)
                {
                   // if ( f_query_add_mod.patient_sub.document.getElementById('alt_id2_reqd_yn').value == 'Y' ){
					    if (f_query_add_mod.patient_sub.document.getElementById('alt2_gif').style.visibility=='visible') { 
					//Added by Kamatchi S for AAKH-CRF-0145
					var isNatIdAltIdMandVisaType	= f_query_add_mod.patient_sub.document.getElementById('isNatIdAltIdMandVisaType').value;			
					//Maheshwaran K added for AAKH-CRF-0168 as on 22-10-2022					
					if( isNatIdAltIdMandVisaType == "true" && f_query_add_mod.patient_sub.document.getElementById('alt2_gif').style.visibility=='visible' && f_query_add_mod.patient_sub.document.getElementById('visa_type').value != "V"){
				//	if( isNatIdAltIdMandVisaType == "false"){
                        canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('alt_id2_no'),f_query_add_mod.patient_sub.document.getElementById('altId2Desc').value);
					}
					/*var isNatIdOrAltId1MandRes	= f_query_add_mod.patient_sub.document.getElementById('isNatIdOrAltId1MandRes').value;
					if( isNatIdOrAltId1MandRes == "true"){
							canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('alt_id2_no'),f_query_add_mod.patient_sub.document.getElementById('altId2Desc').value);
					}*/
					}
                    if ( canSave == false )
                        errorsThere = true;
                }
            }
			//Ends aakh 168
			
          /* Added for IN:046495 by Dharma on 16th Jan 2014 End*/			 
		

			// TO CHECK THE PATIENT SEX MATCH WITH THE NAME PREFIX
	/*		if ( ( f_query_add_mod.patient_sub.document.getElementById('name_prefix') != null ) || ( f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_lang') != null ) )
            {
                if ( ( f_query_add_mod.patient_sub.document.getElementById('name_prefix').value.length != 0 ) || ( f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_lang').value.length != 0 ) )
                {
						if( f_query_add_mod.patient_sub.document.getElementById('sex').value != '' )
						canSave = checkPatSex();
				}
			}
			if ( canSave == false )
				errorsThere = true;

			// TO CHECK THE PATIENT SEX MATCH WITH THE NAME SUFFIX
			if ( ( f_query_add_mod.patient_sub.document.getElementById('name_suffix') != null ) || ( f_query_add_mod.patient_sub.document.getElementById('name_suffix_oth_lang') != null ) )
			 {
						if ( ( f_query_add_mod.patient_sub.document.getElementById('name_suffix').value.length != 0 ) || ( f_query_add_mod.patient_sub.document.getElementById('name_suffix_oth_lang').value.length != 0 ) )
						{
							canSave = checkPatSuffixSex();
						}
			}

			if ( canSave == false )
				errorsThere = true;
*/
  if (  f_query_add_mod.patient_sub.document.getElementById('name_prefix') != null ) 
            {
                if ( f_query_add_mod.patient_sub.document.getElementById('name_prefix').value.length != 0 ) 
                {
                    if( f_query_add_mod.patient_sub.document.getElementById('sex').value != '' )
					{	
                        canSave = checkPatSex();
					}
                }
            }
            if ( canSave == false )
                errorsThere = true;

		/*	if (  f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_lang') != null ) 
            {
                if ( f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_lang').value.length != 0 ) 
                {
                    if( f_query_add_mod.patient_sub.document.getElementById('sex').value != '' )
					{	
                        canSave = checkPatOthSex();
					}
                }
            }
            if ( canSave == false )
                errorsThere = true;*/

			 // TO CHECK THE PATIENT SEX MATCH WITH THE NAME PREFIX
            if ( f_query_add_mod.patient_sub.document.getElementById('name_suffix') != null )
            {
                if (  f_query_add_mod.patient_sub.document.getElementById('name_suffix').value.length != 0 ) 
                {
                    if( f_query_add_mod.patient_sub.document.getElementById('sex').value != '' )
					{	
                        canSave = checkPatSuffixSex();
					}
                }
            }
            if ( canSave == false )
                errorsThere = true;

		/*	if (  f_query_add_mod.patient_sub.document.getElementById('name_suffix_oth_lang') != null ) 
            {
                if ( f_query_add_mod.patient_sub.document.getElementById('name_suffix_oth_lang').value.length != 0 ) 
                {
                    if( f_query_add_mod.patient_sub.document.getElementById('sex').value != '' )
					{	
                        canSave = checkPatOthSuffixSex();
					}
                }
            }
            if ( canSave == false )
                errorsThere = true;*/
			// FIRST CHECK FOR THE PATIENT ID
			if ( f_query_add_mod.patient_sub.document.getElementById('pat_no_gen_yn').value == 'N')
			{
				if(f_query_add_mod.patient_main.document.getElementById('patient_id').value=="")
				{
					canSave = checkForNull(getLabel('Common.patientId.label','common'));
					//checkForNull(canSave);
				}
				if ( canSave == false )
					errorsThere = true;
			}

			if (f_query_add_mod.patient_sub.document.getElementById('accept_national_id_no').value=="Y" && f_query_add_mod.patient_sub.document.getElementById('citizen_yn').value=="Y")
			{
				if ( f_query_add_mod.patient_sub.document.getElementById('national_id_no') != null && !f_query_add_mod.patient_sub.document.getElementById('national_id_no').readOnly)
				{

					if(f_query_add_mod.patient_sub.document.getElementById('nat_id_reqd_all_series').value == "Y")
						canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('national_id_no'),f_query_add_mod.patient_sub.document.getElementById('nat_id_prompt').value);
					else
					{
						pat_ser_grp_obj = f_query_add_mod.patient_sub.document.getElementById('pat_ser_grp_code')
						if(f_query_add_mod.patient_sub.document.getElementById('nat_id_reqd_all_series').value=='N' && f_query_add_mod.patient_sub.pat_sergrp_id_types[pat_ser_grp_obj.selectedIndex] == "N")
						{
							canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('national_id_no'),f_query_add_mod.patient_sub.document.getElementById('nat_id_prompt').value);
						}
				   }
					if ( canSave == false )
						errorsThere = true;
				}
			}
	var dflt_patient_name = f_query_add_mod.patient_sub.document.getElementById('dflt_patient_name').value;
		//	var flag = '';
			// CHECKING FOR PATIENT NAME
			
			if(f_query_add_mod.patient_sub.document.forms[0].details_unknown.checked != true)
			{				
			if ( f_query_add_mod.patient_sub.document.getElementById('first_name') != null && trimString(f_query_add_mod.patient_sub.document.getElementById('first_name').value)== "")
			{
				if ( f_query_add_mod.patient_sub.document.getElementById('first_name_reqd_yn') != null)
					if ( f_query_add_mod.patient_sub.document.getElementById('first_name_reqd_yn').value == 'Y' ) {
						f_query_add_mod.patient_sub.document.getElementById('first_name').value = dflt_patient_name;
						f_query_add_mod.patient_sub.document.getElementById('first_name').onblur();
					//	flag='Y';
					}
						
			}

			if ( f_query_add_mod.patient_sub.document.getElementById('second_name') != null && trimString(f_query_add_mod.patient_sub.document.getElementById('second_name').value)== "")
			{
				if ( f_query_add_mod.patient_sub.document.getElementById('second_name_reqd_yn') != null)
				if ( f_query_add_mod.patient_sub.document.getElementById('second_name_reqd_yn').value == 'Y' ) {
					f_query_add_mod.patient_sub.document.getElementById('second_name').value = dflt_patient_name;
					f_query_add_mod.patient_sub.document.getElementById('second_name').onblur();
				//	flag='Y';
				}
			}

			if ( f_query_add_mod.patient_sub.document.getElementById('third_name') != null  && trimString(f_query_add_mod.patient_sub.document.getElementById('third_name').value)== "")
			{
				if ( f_query_add_mod.patient_sub.document.getElementById('third_name_reqd_yn') != null)
				if ( f_query_add_mod.patient_sub.document.getElementById('third_name_reqd_yn').value == 'Y' ) {
					f_query_add_mod.patient_sub.document.getElementById('third_name').value = dflt_patient_name;
					f_query_add_mod.patient_sub.document.getElementById('third_name').onblur();
				//	flag='Y';
				}
			}

			

			if ( f_query_add_mod.patient_sub.document.getElementById('family_name') != null  && trimString(f_query_add_mod.patient_sub.document.getElementById('family_name').value)== "")
			{
				if ( f_query_add_mod.patient_sub.document.getElementById('family_name_reqd_yn') != null)
				if ( f_query_add_mod.patient_sub.document.getElementById('family_name_reqd_yn').value == 'Y' ) {
					f_query_add_mod.patient_sub.document.getElementById('family_name').value = dflt_patient_name;
					f_query_add_mod.patient_sub.document.getElementById('family_name').onblur();
				//	flag='Y';
				}
			}

			if ( f_query_add_mod.patient_sub.document.getElementById('first_name') != null )
            {
				if ( f_query_add_mod.patient_sub.document.getElementById('first_name_reqd_yn') != null )
                if ( f_query_add_mod.patient_sub.document.getElementById('first_name_reqd_yn').value == 'Y' )
                    canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('first_name'),f_query_add_mod.patient_sub.document.getElementById('first_name_prompt').value);
                if ( canSave == false )
                    errorsThere = true;              
            }

			if ( f_query_add_mod.patient_sub.document.getElementById('second_name') != null )
            {
				if ( f_query_add_mod.patient_sub.document.getElementById('second_name_reqd_yn') != null )
                if ( f_query_add_mod.patient_sub.document.getElementById('second_name_reqd_yn').value == 'Y' )
                    canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('second_name'),f_query_add_mod.patient_sub.document.getElementById('second_name_prompt').value);
                if ( canSave == false )
                    errorsThere = true;              
            }

			if ( f_query_add_mod.patient_sub.document.getElementById('third_name') != null )
            {
				if ( f_query_add_mod.patient_sub.document.getElementById('third_name_reqd_yn') != null )
                if ( f_query_add_mod.patient_sub.document.getElementById('third_name_reqd_yn').value == 'Y' )
                    canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('third_name'),f_query_add_mod.patient_sub.document.getElementById('third_name_prompt').value);
                if ( canSave == false )
                    errorsThere = true;              
            }

			if ( f_query_add_mod.patient_sub.document.getElementById('family_name') != null )
            {
				if ( f_query_add_mod.patient_sub.document.getElementById('family_name_reqd_yn') != null )
                if ( f_query_add_mod.patient_sub.document.getElementById('family_name_reqd_yn').value == 'Y' )
                    canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('family_name'),f_query_add_mod.patient_sub.document.getElementById('family_name_prompt').value);
                if ( canSave == false )
                    errorsThere = true;              
            }

			if ( f_query_add_mod.patient_sub.document.getElementById('name_suffix') != null )
			{
				if ( f_query_add_mod.patient_sub.document.getElementById('name_suffix_reqd_yn')  !=null)
					if ( f_query_add_mod.patient_sub.document.getElementById('name_suffix_reqd_yn').value  =='Y')
					canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('name_suffix'),f_query_add_mod.patient_sub.document.getElementById('name_suffix_prompt').value);
				if ( canSave == false )
					errorsThere = true;
			}
			/*
			if ( f_query_add_mod.patient_sub.document.getElementById('name_prefix') != null )
			{
				if(f_query_add_mod.patient_sub.document.getElementById('name_prefix_reqd_yn') != null )
				{
					if(f_query_add_mod.patient_sub.document.getElementById('name_prefix_reqd_yn').value == 'Y')
					{
						canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('name_prefix'),f_query_add_mod.patient_sub.document.getElementById('name_prefix_prompt').value);
					}
				}
				if(canSave == false)
					errorsThere = true;
			}
			*/
			
			 // CHECKING FOR PATIENT NAME
//alert(f_query_add_mod.patient_main.document.getElementById('patient_name').value);
		//	if(trimString(f_query_add_mod.patient_main.document.getElementById('patient_name').value)=="" || flag=='Y')
			if(trimString(f_query_add_mod.patient_main.document.getElementById('patient_name').value)=="")
			{
				var patForm = f_query_add_mod.patient_sub.document.all;
				var pat_name = f_query_add_mod.patient_main.document.getElementById('patient_name');
				if (patForm.first_name)
				{
					pat_name.value = trimString(patForm.first_name.value) ;
				}
				if (patForm.second_name)
				{
					pat_name.value  = pat_name.value + ' ' +trimString(patForm.second_name.value) ;
				}
				if (patForm.third_name)
				{
					pat_name.value  =  pat_name.value + ' ' + trimString(patForm.third_name.value) ;
				}
				if (patForm.family_name)
				{
					pat_name.value  =  pat_name.value +' ' + trimString(patForm.family_name.value) ;
				}
				if (trimString(f_query_add_mod.patient_main.document.getElementById('patient_name').value)=="")
					canSave=checkForNull(getLabel('Common.PatientName.label','common'));
			}
			
			if(f_query_add_mod.patient_main.document.getElementById('patient_name_loc_lang')) {
				if(trimString(f_query_add_mod.patient_main.document.getElementById('patient_name_loc_lang').value)=="")
				{
					var patForm = f_query_add_mod.patient_sub.document.all;
					var pat_name = f_query_add_mod.patient_main.document.getElementById('patient_name_loc_lang');
					if (patForm.first_name_oth_lang)
					{
						pat_name.value = trimString(patForm.first_name_oth_lang.value) ;
					}
					if (patForm.second_name_oth_lang)
					{
						pat_name.value  = pat_name.value + ' ' +trimString(patForm.second_name_oth_lang.value) ;
					}
					if (patForm.third_name_oth_lang)
					{
						pat_name.value  =  pat_name.value + ' ' + trimString(patForm.third_name_oth_lang.value) ;
					}
					if (patForm.family_name_oth_lang)
					{
						pat_name.value  =  pat_name.value +' ' + trimString(patForm.family_name_oth_lang.value) ;
					}
					if(f_query_add_mod.patient_sub.document.getElementById('pat_name_in_loc_lang_reqd_yn').value == "Y"){
						if (trimString(f_query_add_mod.patient_main.document.getElementById('patient_name_loc_lang').value)=="")
							canSave=checkForNull(getLabel('eMP.PatientNameLocal.label','MP'));
					}
				}
					if( f_query_add_mod.patient_main.document.getElementById('patient_name_loc_lang') != null)
						f_query_add_mod.patient_sub.document.getElementById('patient_name_loc_lang').value = f_query_add_mod.patient_main.document.getElementById('patient_name_loc_lang').value;

			}

		

			if ( canSave == false )
				errorsThere = true;

			f_query_add_mod.patient_sub.document.getElementById('patient_name').value = f_query_add_mod.patient_main.document.getElementById('patient_name').value;
		
			

			if ( f_query_add_mod.patient_sub.document.getElementById('first_name') != null )
			{
				if ( f_query_add_mod.patient_sub.document.getElementById('first_oth_name_reqd_yn') != null)
					if ( f_query_add_mod.patient_sub.document.getElementById('first_oth_name_reqd_yn').value == 'Y' )
						canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('first_name_oth_lang'),f_query_add_mod.patient_sub.document.getElementById('first_name_oth_prompt').value);
					if ( canSave == false )
						errorsThere = true;
			}

			if ( f_query_add_mod.patient_sub.document.getElementById('second_name') != null )
			{
				if ( f_query_add_mod.patient_sub.document.getElementById('second_oth_name_reqd_yn') != null)
				if ( f_query_add_mod.patient_sub.document.getElementById('second_oth_name_reqd_yn').value == 'Y' )
					canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('second_name_oth_lang'),f_query_add_mod.patient_sub.document.getElementById('second_name_oth_prompt').value);
				if ( canSave == false )
					errorsThere = true;
			}

			if ( f_query_add_mod.patient_sub.document.getElementById('third_name') != null )
			{
				if ( f_query_add_mod.patient_sub.document.getElementById('third_oth_name_reqd_yn') != null)
				if ( f_query_add_mod.patient_sub.document.getElementById('third_oth_name_reqd_yn').value == 'Y' )
					canSave =checkForNull1(f_query_add_mod.patient_sub.document.getElementById('third_name_oth_lang'),f_query_add_mod.patient_sub.document.getElementById('third_name_oth_prompt').value);
				if ( canSave == false )
					errorsThere = true;
			}

			if ( f_query_add_mod.patient_sub.document.getElementById('family_name') != null )
			{
				if ( f_query_add_mod.patient_sub.document.getElementById('family_oth_name_reqd_yn') != null)
				if ( f_query_add_mod.patient_sub.document.getElementById('family_oth_name_reqd_yn').value == 'Y' )
					canSave =checkForNull1(f_query_add_mod.patient_sub.document.getElementById('family_name_oth_lang'),f_query_add_mod.patient_sub.document.getElementById('family_name_oth_prompt').value);
				if ( canSave == false )
					errorsThere = true;
			}

			if ( f_query_add_mod.patient_sub.document.getElementById('name_suffix_oth_lang') != null )
			{
				if ( f_query_add_mod.patient_sub.document.getElementById('name_suffix_oth_name_reqd_yn') != null )
				if ( f_query_add_mod.patient_sub.document.getElementById('name_suffix_oth_name_reqd_yn').value == 'Y' )
					canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('name_suffix_oth_lang'),f_query_add_mod.patient_sub.document.getElementById('name_suffix_oth_prompt').value);
				if ( canSave == false )
					errorsThere = true;
			}

			if ( f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_lang') != null )
			{
				 if ( f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_name_reqd_yn') != null )
				if ( f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_name_reqd_yn').value == 'Y' )
					canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_lang'),f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_prompt').value);
				if ( canSave == false )
					errorsThere = true;
			}
			if (f_query_add_mod.patient_sub.document.getElementById('nationality_code'))
			 {
				if(f_query_add_mod.patient_sub.document.getElementById('nationality_desc').value=='')
					f_query_add_mod.patient_sub.document.getElementById('nationality_code').value='';

				if (f_query_add_mod.patient_sub.document.getElementById('nationality_code').value == '')
				{
					if(f_query_add_mod.patient_sub.document.getElementById('nationality_code').value =="")
					{
						canSave=checkForNull(getLabel('Common.nationality.label','common'));
							//checkForNull(canSave);
					}
				}
				if ( canSave == false )
					errorsThere = true;
			 }
			 
			}
			else {					
					if(f_query_add_mod.patient_sub.document.getElementById('first_name') != null) {
						f_query_add_mod.patient_sub.document.getElementById('first_name').value = "Unknown ";					
						f_query_add_mod.patient_sub.putPatientName(f_query_add_mod.patient_sub.document.getElementById('first_name'));				
					}
				
					if(f_query_add_mod.patient_sub.document.getElementById('family_name') != null) {   					
						if(f_query_add_mod.patient_sub.document.getElementById('sex').value != "") { 
							var sel_gender = "";
							if(f_query_add_mod.patient_sub.document.getElementById('sex').selectedIndex == 1)
								sel_gender = "Male";
							else if(f_query_add_mod.patient_sub.document.getElementById('sex').selectedIndex == 2)
								sel_gender = "Female";
							else if(f_query_add_mod.patient_sub.document.getElementById('sex').selectedIndex == 3)
								sel_gender = "Unknown";
							if(f_query_add_mod.patient_sub.document.forms[0].pat_name_as_multipart_yn.value == 'Y')
							{
								f_query_add_mod.patient_sub.document.getElementById('family_name').value = sel_gender;
							}else	{
								if(f_query_add_mod.patient_sub.document.getElementById('family_name')) {
									f_query_add_mod.patient_sub.document.getElementById('family_name').value ="Unknown " +sel_gender;
								}
							  }						
							f_query_add_mod.patient_sub.putPatientName( f_query_add_mod.patient_sub.document.getElementById('family_name'));
						  } 
					  }
					if(f_query_add_mod.patient_sub.document.getElementById('second_name_reqd_yn')  != null)
					{
						f_query_add_mod.patient_sub.document.getElementById('second_name').value =  "Unknown ";						
						f_query_add_mod.patient_sub.putPatientName( f_query_add_mod.patient_sub.document.getElementById('second_name'));
					}
					if(f_query_add_mod.patient_sub.document.getElementById('third_name_reqd_yn')  != null)
					{
						f_query_add_mod.patient_sub.document.getElementById('third_name').value =  "Unknown ";						
						f_query_add_mod.patient_sub.putPatientName( f_query_add_mod.patient_sub.document.getElementById('third_name'));
					}
				
				
				f_query_add_mod.patient_sub.document.getElementById('patient_name').value = f_query_add_mod.patient_main.document.getElementById('patient_name').value;

				if(f_query_add_mod.patient_sub.document.getElementById('first_name_oth_lang') )
				{
				 if(f_query_add_mod.patient_sub.document.getElementById('first_name_reqd_yn') != null) {
					f_query_add_mod.patient_sub.document.getElementById('first_name_oth_lang').value =getLabel("Common.unknown.label","common");			
					f_query_add_mod.patient_sub.putLocalLangPatientName(f_query_add_mod.patient_sub.document.getElementById('first_name_oth_lang'));
				  }
				}
				if(f_query_add_mod.patient_sub.document.getElementById('second_name_oth_lang')){
				if(f_query_add_mod.patient_sub.document.getElementById('second_name_reqd_yn')  != null)
				{
					f_query_add_mod.patient_sub.document.getElementById('second_name_oth_lang').value = getLabel("Common.unknown.label","common");
					f_query_add_mod.patient_sub.putLocalLangPatientName( f_query_add_mod.patient_sub.document.getElementById('second_name_oth_lang'));
				}
				}
				if(f_query_add_mod.patient_sub.document.getElementById('third_name_oth_lang')){
				if(f_query_add_mod.patient_sub.document.getElementById('third_name_reqd_yn')  != null)
				{
					f_query_add_mod.patient_sub.document.getElementById('third_name_oth_lang').value = getLabel("Common.unknown.label","common");
					f_query_add_mod.patient_sub.putLocalLangPatientName( f_query_add_mod.patient_sub.document.getElementById('third_name_oth_lang'));
				}
				}
//Added the below code for SRR20056-SCF-6368 [IN:025789] by Suresh M on 10.01.2010
				if(f_query_add_mod.patient_sub.document.getElementById('family_name_oth_lang') != null) { 					
						if(f_query_add_mod.patient_sub.document.getElementById('sex').value != "") { 
							var sel_gender = "";
							if(f_query_add_mod.patient_sub.document.getElementById('sex').selectedIndex == 1)
								sel_gender = getLabel("Common.male.label","common");
							else if(f_query_add_mod.patient_sub.document.getElementById('sex').selectedIndex == 2)
								sel_gender = getLabel("Common.female.label","common");
							else if(f_query_add_mod.patient_sub.document.getElementById('sex').selectedIndex == 3)
								sel_gender = getLabel("Common.unknown.label","common");
							if(f_query_add_mod.patient_sub.document.forms[0].pat_name_as_multipart_yn.value == 'Y')
							{
								f_query_add_mod.patient_sub.document.getElementById('family_name_oth_lang').value = sel_gender;
							}else	{
								if(f_query_add_mod.patient_sub.document.getElementById('family_name_oth_lang')) {
									f_query_add_mod.patient_sub.document.getElementById('family_name_oth_lang').value ="Unknown " +sel_gender;
								}
							  }						
							f_query_add_mod.patient_sub.putLocalLangPatientName( f_query_add_mod.patient_sub.document.getElementById('family_name_oth_lang'));
						  } 
					  }
// Ends SRR20056-SCF-6368 [IN:025789]		
				if(f_query_add_mod.patient_main.document.getElementById('patient_name_loc_lang')) {
					f_query_add_mod.patient_sub.document.getElementById('patient_name_loc_lang').value = f_query_add_mod.patient_main.document.getElementById('patient_name_loc_lang').value;
				}
			}
//Incident Fix Against for the Inci no : 34725  as on 04/09/2012	
			if(f_query_add_mod.patient_sub.document.getElementById('language_desc'))
{			
if(f_query_add_mod.patient_sub.document.getElementById('language_desc').value == "")
	{
	f_query_add_mod.patient_sub.document.getElementById('language_code').value="";
	}
}
// 34725 End
			// CHECKING FOR PATIENT DATE OF BIRTH
			if(f_query_add_mod.patient_sub.document.getElementById('date_of_birth').value =="")
			{
				canSave = checkForNull(getLabel('Common.birthDate.label','common'));
					//checkForNull(canSave);
			}
			if ( canSave == false )
				errorsThere = true;
			/* CHECKING FOR Maintain Organization - 
				Membership/Organization/Alternate Id 1 */		
			//Below Added by Suji keerthi on 04-Dec-2019 for KDAH-CRF-0522
			if ( (f_query_add_mod.patient_sub.document.getElementById('pat_cat_code')) && (f_query_add_mod.patient_sub.document.getElementById('pat_cat_reqd_yn').value == 'Y') && (f_query_add_mod.patient_sub.document.getElementById('imgCategoryMan').style.visibility == 'visible') )
			{
				if(f_query_add_mod.patient_sub.document.getElementById('pat_cat_code').value =="")
					{
				canSave=checkForNull(getLabel('Common.category.label','common'));
				}
					if ( canSave == false )
					errorsThere = true;
		   }
	
			if (f_query_add_mod.patient_sub.document.getElementById('family_org_id_accept_yn').value == 'Y')
			{
				if ( (f_query_add_mod.patient_sub.document.getElementById('pat_cat_code')) && (f_query_add_mod.patient_sub.document.getElementById('entitlement_by_pat_cat_yn').value == 'Y') && (f_query_add_mod.patient_sub.document.getElementById('imgCategoryMan').style.visibility == 'visible') )
				{
					if(f_query_add_mod.patient_sub.document.getElementById('pat_cat_code').value =="")
						{
					canSave=checkForNull(getLabel('Common.category.label','common'));
					//checkForNull(canSave);
					}
						if ( canSave == false )
						errorsThere = true;
			   }
				if  ( (f_query_add_mod.patient_sub.document.getElementById('family_org_membership')) && (f_query_add_mod.patient_sub.document.getElementById('family_org_mem_img').style.visibility == 'visible'))
				{
					if(f_query_add_mod.patient_sub.document.getElementById('family_org_membership').value =="")
					{
						canSave=checkForNull(getLabel('eMP.membership.label','MP'));
						//checkForNull(canSave);
					}
						if ( canSave == false )
						errorsThere = true;
				   /* Below Line Modified for IN:046495 by Dharma on 16th Jan 2014*/
				    /* if (f_query_add_mod.patient_sub.document.getElementById('family_org_membership').value != 4)
				   {*/
				   

				   
				    
				   //Below line modified for this incident [61782]
				   
				  if (f_query_add_mod.patient_sub.document.getElementById('family_org_membership').value != 4 && tempflagchk==false){
				 
					  if (f_query_add_mod.patient_sub.document.getElementById('alt1_gif').style.visibility=='visible')
					  {
						  canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('alt_id1_no'),f_query_add_mod.patient_sub.document.getElementById('altId1Desc').value);
	 				      if ( canSave == false )
							errorsThere = true;
					  }
					  if (f_query_add_mod.patient_sub.document.getElementById('org_sub_org').style.visibility=='visible')
					  {
						if(f_query_add_mod.patient_sub.document.getElementById('organization').value =="")
						{
								canSave=checkForNull(getLabel('Common.Organization.label','Common'));
								//checkForNull(canSave);
						}
						if ( canSave == false )
						errorsThere = true;
						  
						if(f_query_add_mod.patient_sub.document.getElementById('sub_organization').value =="")
						{
							canSave=checkForNull(getLabel('eMP.suborgn.label','MP'));
								//checkForNull(canSave);
						}
						if ( canSave == false )
						errorsThere = true;
					  }	  
					 /*For Organization Member this check doen't apply*/
					if ( (f_query_add_mod.patient_sub.document.getElementById('family_org_membership').value != 1)  && (f_query_add_mod.patient_sub.document.getElementById('rel')) && (f_query_add_mod.patient_sub.document.getElementById('rel').style.visibility=='visible') )
					 {
						if(f_query_add_mod.patient_sub.document.getElementById('relationship_to_head').value =="")
							{
							canSave=checkForNull(getLabel('Common.relationship.label','common'));
								//checkForNull(canSave);
						}
						if ( canSave == false )
							errorsThere = true;
				    }
				}
			  }
			}
			else
			 if ( f_query_add_mod.patient_sub.document.getElementById('relationship_to_head'))
			{
				if ( !f_query_add_mod.patient_sub.document.getElementById('rel').style.visibility=='visible')
				{
					if(f_query_add_mod.patient_sub.document.getElementById('relationship_to_head').value =="")
						{
							canSave=checkForNull(getLabel('Common.relationship.label','common'));
							//	checkForNull(canSave);
						}
					if ( canSave == false )
						errorsThere = true;
					 }
			}
			/*
			if (f_query_add_mod.patient_sub.document.getElementById('family_org_membership'))
			{
				if ( (f_query_add_mod.patient_sub.document.getElementById('family_org_membership').value == '1') && (f_query_add_mod.patient_sub.document.getElementById('name_prefix_img')) && (f_query_add_mod.patient_sub.document.getElementById('name_prefix_img').style.visibility=='visible') )
				{
					canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('name_prefix'),f_query_add_mod.patient_sub.document.getElementById('name_prefix_prompt').value);
						if ( canSave == false )
						errorsThere = true;
				}
			}
			*/

			if ( (f_query_add_mod.patient_sub.document.getElementById('name_prefix_img')) && (f_query_add_mod.patient_sub.document.getElementById('name_prefix_img').style.visibility=='visible'))
			{
				canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('name_prefix'),f_query_add_mod.patient_sub.document.getElementById('name_prefix_prompt').value);
				if ( canSave == false )
					errorsThere = true;
			}

			if ( (f_query_add_mod.patient_sub.document.getElementById('entitlement_by_pat_cat_yn').value == 'Y') && (f_query_add_mod.patient_sub.document.getElementById('exp_val_appl_yn').value == 'Y') &&(f_query_add_mod.patient_sub.document.getElementById('imgCatExpDateMan').style.visibility=='visible')  )
			{
				if(f_query_add_mod.patient_sub.document.getElementById('pat_cat_code_exp_date').value =="")
					{

				canSave=checkForNull(getLabel('eMP.categoryexpirydate.label','MP'));
				//checkForNull(canSave);
				}
					if ( canSave == false )
					errorsThere = true;
			}
			/* End of Membership Type validations*/ 
				
			 /* Added for IN:046495 by Dharma on 16th Jan 2014 Start*/
		/*	var tempflagchk = new Boolean(false);	
			if(f_query_add_mod.patient_sub.document.getElementById('details_unknown') .checked ==false){
				if(f_query_add_mod.patient_sub.document.getElementById('alt_id1_reqd_yn').value == 'Y' && f_query_add_mod.patient_sub.document.getElementById('alt_id1_man_non_ctz') && f_query_add_mod.patient_sub.document.getElementById('alt_id1_man_non_ctz').value=="true" )
				{
					if(f_query_add_mod.patient_sub.document.getElementById('alt1_gif').style.visibility == 'visible') {	

						if(f_query_add_mod.patient_sub.document.getElementById('alt_id1_no').value=="")
						{
							 canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('alt_id1_no'),f_query_add_mod.patient_sub.document.getElementById('altId1Desc').value);
						}		 
					}
					if ( canSave == false ){
						errorsThere = true;
						tempflagchk=true;
					}	
				}
				
					if(f_query_add_mod.patient_sub.document.getElementById('alt_date1_reqd_yn').value == 'Y' && f_query_add_mod.patient_sub.document.getElementById('alt_id1_man_non_ctz') && f_query_add_mod.patient_sub.document.getElementById('alt_id1_man_non_ctz').value=="true")
				{
					if(f_query_add_mod.patient_sub.document.getElementById('alt1_exp_date1').style.visibility == 'visible') {	

						if(f_query_add_mod.patient_sub.document.getElementById('altidexpdate1').value=="")
						{
							canSave=checkForNull(getLabel('Common.expiryDate.label','common'));
						}		 
					}
					if ( canSave == false )
						errorsThere = true;
				}
			}*/
          /* Added for IN:046495 by Dharma on 16th Jan 2014 End*/

			// CHECKING FOR ALTERNATE ID'S

			if(f_query_add_mod.patient_sub.document.getElementById('race_required_yn').value == 'Y') {

				if(f_query_add_mod.patient_sub.document.getElementById('image1').style.visibility == 'visible') {	

					if(f_query_add_mod.patient_sub.document.getElementById('race_code').value =="") {						 
						canSave = checkForNull(getLabel("Common.race.label","common"));
					}	
				}
				
				if(canSave == false )
					errorsThere = true;
			}
			/*Below Added by Mano for ML-MMOH-CRF-0736 */
			
			if(f_query_add_mod.patient_sub.document.getElementById('religion_reqd_yn').value == 'Y') {

				if(f_query_add_mod.patient_sub.document.getElementById('image2').style.visibility == 'visible') {	

					if(f_query_add_mod.patient_sub.document.getElementById('relgn_desc').value =="") {						 
						canSave = checkForNull(getLabel("Common.religion.label","common"));
					}	
				}
				
				if(canSave == false )
					errorsThere = true;
			}
            /* End of CRF-0736 by Mano */
		if(f_query_add_mod.patient_sub.document.getElementById('isNatIdAltIdMandVisaType').value=="false")// Added for AAKH CRF 145
			 {
			if(!f_query_add_mod.patient_sub.document.getElementById('alt_id1_no').readOnly && !f_query_add_mod.patient_sub.document.getElementById('alt_id1_no').disabled && (!f_query_add_mod.patient_sub.document.getElementById('family_org_membership')))
			{
				 /* Below Line Modified for IN:046495 by Dharma on 16th Jan 2014*/
				/*if(f_query_add_mod.patient_sub.document.getElementById('alt_id1_no') != null)
				{*/
				//Below line added for this incident [61782]
				if(f_query_add_mod.patient_sub.document.getElementById('alt_id1_no') != null && tempflagchk==false)
				{
					if(f_query_add_mod.patient_sub.document.getElementById('alt_id1_reqd_yn').value == 'Y')
						canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('alt_id1_no'),f_query_add_mod.patient_sub.document.getElementById('altId1Desc').value);
					if(f_query_add_mod.patient_sub.document.getElementById('Alt_Id1_Unique_Yn1').value == 'Y' && f_query_add_mod.patient_sub.document.getElementById('error_alt_no1').value.length > 0)
					{
						//errorsThere = true;
					   // Alt_error= Alt_error+f_query_add_mod.patient_sub.document.getElementById('error_alt_no1').value+'<br>';
					}

					if(canSave == false)
						errorsThere = true;
				}
			}
			//Added for Alternate ID 2
			if 	(f_query_add_mod.patient_sub.document.getElementById('alt_id2_no') != null)
			{
				if (!f_query_add_mod.patient_sub.document.getElementById('alt_id2_no').readOnly && !f_query_add_mod.patient_sub.document.getElementById('alt_id2_no').disabled)
				{				
					if ( f_query_add_mod.patient_sub.document.getElementById('alt_id2_reqd_yn').value == 'Y' )
						canSave = checkForNull1(f_query_add_mod.patient_sub.document.getElementById('alt_id2_no'),f_query_add_mod.patient_sub.document.getElementById('altId2Desc').value);
					if ( f_query_add_mod.patient_sub.document.getElementById('Alt_Id1_Unique_Yn2').value == 'Y' && f_query_add_mod.patient_sub.document.getElementById('error_alt_no2').value.length > 0)
					{
						//errorsThere = true;
					   // Alt_error= Alt_error+f_query_add_mod.patient_sub.document.getElementById('error_alt_no1').value+'<br>';
					}

					if ( canSave == false )
						errorsThere = true;
				}
			}
			}
			if ( f_query_add_mod.patient_sub.document.getElementById('details_unknown') .checked &&  f_query_add_mod.patient_sub.document.getElementById('dflt_grp') == ""  )
			{
				errorsThere = true;
				Alt_error+=f_query_add_mod.patient_sub.getMessage("EMER_SER_NOT_DEFINED",'MP')
			}
//alert(f_query_add_mod.patient_sub.document.getElementById('accept_national_id_no').value)
//Added by Mallikarjuna on 13/03/2003 for National ID Validation with Date of Birth & Sex.
if (f_query_add_mod.patient_sub.document.getElementById('accept_national_id_no').value=="Y")
			{		
				if (f_query_add_mod.patient_sub.document.getElementById('national_id_no').value != "" && f_query_add_mod.patient_sub.document.getElementById('nat_data_source_id') != null)
				{ //This existing issue corrected for natinal id not equals empty added ML-MMOH-CRF-0780
					if (f_query_add_mod.patient_sub.document.getElementById('nat_data_source_id').value=="NRIC" && f_query_add_mod.patient_sub.document.getElementById('invoke_routine').value=="Y")
					{
						if (f_query_add_mod.patient_sub.document.getElementById('date_of_birth').value != '')
						{
							var dob = f_query_add_mod.patient_sub.document.getElementById('date_of_birth').value;
							dob = dob.substring(8,10) + dob.substring(3,5)+dob.substring(0,2);
							if (f_query_add_mod.patient_sub.document.getElementById('national_id_no').value.length >= 6)
							{
								if (dob!=f_query_add_mod.patient_sub.document.getElementById('national_id_no').value.substring(0,6))
								{
									var natmsg = f_query_add_mod.patient_sub.getMessage("MISMATCH_NAT_DOB",'MP');
									natmsg = natmsg.replace('#',f_query_add_mod.patient_sub.document.getElementById('nat_id_prompt').value);
									LocalErrors += natmsg+ ' <br>';
									canSave =false;
								}
							}
							if (f_query_add_mod.patient_sub.document.getElementById('national_id_no').value.length >= 12)
							{
								var sexIdent = f_query_add_mod.patient_sub.document.getElementById('national_id_no').value.substring(8,12);
								if (!isNaN(sexIdent))
								{
									var sexIdent = f_query_add_mod.patient_sub.document.getElementById('national_id_no').value.substring(11,12);
									if (parseInt(sexIdent) == 1 || parseInt(sexIdent) == 3 || parseInt(sexIdent) == 5 || parseInt(sexIdent) == 7 || parseInt(sexIdent) == 9)
									{ 
										sexIdent = "M";
									}
									else
										sexIdent = "F";
										
																		
									//Below condtion modified for this CRF ML-MMOH-CRF-0778
									if ((sexIdent!=f_query_add_mod.patient_sub.document.getElementById('sex').value) && (f_query_add_mod.patient_sub.document.getElementById('checkNatIdWithGender') && f_query_add_mod.patient_sub.document.getElementById('checkNatIdWithGender').value=="false"))
									{
									    
										var natmsg = f_query_add_mod.patient_sub.getMessage("MISMATCH_NAT_SEX",'MP');
										natmsg = natmsg.replace('#',f_query_add_mod.patient_sub.document.getElementById('nat_id_prompt').value);
										LocalErrors += natmsg+ ' <br>';
										canSave =false;
									}
								}
								else
								{
									var natmsg = f_query_add_mod.patient_sub.getMessage("NAT_ID_9_12",'MP');
									natmsg = natmsg.replace('#',f_query_add_mod.patient_sub.document.getElementById('nat_id_prompt').value);
									LocalErrors += natmsg+ ' <br>';									
									canSave =false;
								}
							}
						}
					}
				}
			}
			//End of the addition
			/*Added by Dharma on Feb 20th 2017 against GDOH-CRF-0140 [IN:063489] Start*/ 
			if(f_query_add_mod.patient_sub.document.getElementById('national_id_no') && f_query_add_mod.patient_sub.document.getElementById('isValidateNatIDWithDOB').value=="true"){
				var dobVal		= f_query_add_mod.patient_sub.document.getElementById('date_of_birth').value;
				var natIdVal	= f_query_add_mod.patient_sub.document.getElementById('national_id_no').value;
				if(dobVal!= "" && natIdVal!=""){
					if(!f_query_add_mod.patient_sub.fnChkDOBNatIDValidation(dobVal,natIdVal)){
						var natmsg = f_query_add_mod.patient_sub.getMessage("MISMATCH_NAT_DOB",'MP');
						natmsg = natmsg.replace('#', f_query_add_mod.patient_sub.document.getElementById('nat_id_prompt').value);
						LocalErrors += natmsg + ' <br>';
						canSave =false;
					}
				}
			}
			/*Added by Dharma on Feb 20th 2017 against GDOH-CRF-0140 [IN:063489] End*/ 
			/*Added by Thamizh selvi on 24th Mar 2017 for GDOH-CRF-0145 Start*/
			if(f_query_add_mod.patient_sub.document.getElementById('national_id_no') && f_query_add_mod.patient_sub.document.getElementById('chkGenderWithNatID').value=="true"){
				var gender	= f_query_add_mod.patient_sub.document.getElementById('sex').value;
				var natId	= f_query_add_mod.patient_sub.document.getElementById('national_id_no').value;
				if(gender!= "" && natId!=""){
					if(!f_query_add_mod.patient_sub.chkNatIDWithGender(gender,natId)){
						var errmsg = f_query_add_mod.patient_sub.getMessage('MISMATCH_NAT_SEX','MP');
						errmsg = errmsg.replace('National ID', f_query_add_mod.patient_sub.document.getElementById('nat_id_prompt').value);
						LocalErrors += errmsg + ' <br>';
						canSave =false;
					}
				}
			}/*End*/

			if(f_query_add_mod.patient_sub.document.getElementById('isNatIdAltIdMandVisaType').value=="false")//Added for AAKH-CRF-0145
			{
			if(f_query_add_mod.patient_sub.document.getElementById('citizen_yn').value == "N")
			{
			 if(f_query_add_mod.patient_sub.document.getElementById('national_id_no').value.length > 0)
				{
					
					var nat_id_prmt_1=f_query_add_mod.patient_sub.document.getElementById('nat_id_prompt').value;
					
					var msg1=f_query_add_mod.patient_sub.getMessage("NRIC_FOR_NONCITIZEN",'MP');
					msg1=msg1.replace('$',nat_id_prmt_1)
					alert(msg1);
					//alert(f_query_add_mod.patient_sub.getMessage("NRIC_FOR_NONCITIZEN",'MP'));
					canSave =false;
					errorsThere = true;
				}
			}
			 }

			if( ((f_query_add_mod.patient_sub.document.getElementById('nationality_code'))) && (f_query_add_mod.patient_sub.document.getElementById('nationality_code').value == f_query_add_mod.patient_sub.document.getElementById('dflt_nationality_code').value)	 )
				{
					if((f_query_add_mod.patient_sub.document.getElementById('citizen_yn').value == "N") || (f_query_add_mod.patient_sub.document.getElementById('legal').value == "N"))
					{
						var resmsg = f_query_add_mod.patient_sub.getMessage("RES_STATUS_FOR_CITIZEN",'MP');
						resmsg = resmsg.replace('#',f_query_add_mod.patient_sub.document.getElementById('nationality_desc').value);
						alert(resmsg);
						errorsThere = true;
						canSave = false;

					}
				}

			//Added for Maximum age validation
			var maxAge = f_query_add_mod.patient_sub.document.getElementById('max_patient_age').value;
			var actAge = f_query_add_mod.patient_sub.document.getElementById('b_age').value;
			var actMonth = f_query_add_mod.patient_sub.document.getElementById('b_months').value;
			var actDay = f_query_add_mod.patient_sub.document.getElementById('b_days').value;
			if (maxAge != '')
			{
				if (parseInt(actAge) > parseInt(maxAge) || 
					((parseInt(actAge) == parseInt(maxAge)) && (parseInt(actMonth) > 0 || parseInt(actDay) > 0)))
				{
					LocalErrors += f_query_add_mod.patient_sub.getMessage("MAX_PATIENT_AGE",'MP')+" "+maxAge+" "+getLabel("Common.Years.label","common");
					canSave = false;
				}
			}
		//	if(!doDateCheckAlert(f_query_add_mod.patient_sub.document.getElementById('date_of_birth'), f_query_add_mod.patient_sub.document.getElementById('ServerDate'),f_query_add_mod.patient_sub.document.getElementById('other_era_diff').value))
			if(f_query_add_mod.patient_sub.document.getElementById('date_of_birth').value!="")
			{
				if (!f_query_add_mod.patient_sub.isBeforeNow(f_query_add_mod.patient_sub.document.getElementById('date_of_birth').value,"DMY",localeName)) 
				{
					LocalErrors += f_query_add_mod.patient_sub.getMessage('DOB_CHECK','Common') + ' <br>';
					canSave = false;
				}
			}
			//end of validation
			//Added for Billing
			if(f_query_add_mod.patient_sub.document.getElementById('transaction_continue').value == "N")
			{
				LocalErrors += f_query_add_mod.patient_sub.getMessage("EM_BLNG_GRP_NOT_DEFINED",'MP') + ' <br>';
				canSave = false;
			}
			if(canSave == false)  errorsThere = true;

			if(canSave == true && errorsThere == false)
			{ 
				
				if(f_query_add_mod.patient_sub.Emergency_Regn.details_unknown.disabled == true)
					f_query_add_mod.patient_sub.Emergency_Regn.details_unknown.disabled = false;

				if(f_query_add_mod.patient_sub.document.getElementById('details_unknown').checked)
				{
					f_query_add_mod.patient_sub.document.getElementById('pat_ser_grp_code').disabled = false;
					if(f_query_add_mod.patient_sub.document.getElementById('first_name') != null)
						f_query_add_mod.patient_sub.document.getElementById('first_name').disabled = false

					if(f_query_add_mod.patient_sub.document.getElementById('second_name') != null)
						f_query_add_mod.patient_sub.document.getElementById('second_name').disabled = false

					if(f_query_add_mod.patient_sub.document.getElementById('third_name') != null)
						f_query_add_mod.patient_sub.document.getElementById('third_name').disabled = false

					if(f_query_add_mod.patient_sub.document.getElementById('family_name') != null)
						f_query_add_mod.patient_sub.document.getElementById('family_name').disabled = false
			
			//Added the below code for SRR20056-SCF-6368 [IN:025789] by Suresh M on 10.01.2010
					if(f_query_add_mod.patient_sub.document.getElementById('first_name_oth_lang') != null)
						f_query_add_mod.patient_sub.document.getElementById('first_name_oth_lang').disabled = false

					if(f_query_add_mod.patient_sub.document.getElementById('second_name_oth_lang') != null)
						f_query_add_mod.patient_sub.document.getElementById('second_name_oth_lang').disabled = false

					if(f_query_add_mod.patient_sub.document.getElementById('third_name_oth_lang') != null)
						f_query_add_mod.patient_sub.document.getElementById('third_name_oth_lang').disabled = false

					if(f_query_add_mod.patient_sub.document.getElementById('family_name_oth_lang') != null)
						f_query_add_mod.patient_sub.document.getElementById('family_name_oth_lang').disabled = false
			// Ends Suresh M
				
				}
				f_query_add_mod.patient_sub.Emergency_Regn.pat_ser_grp_code.disabled=false;
				
				 if(f_query_add_mod.patient_sub.document.getElementById('family_link_no'))
					 f_query_add_mod.patient_sub.document.getElementById('family_link_no').disabled=false;

				 if(f_query_add_mod.patient_sub.document.getElementById('family_org_sub_id'))
					 f_query_add_mod.patient_sub.document.getElementById('family_org_sub_id').disabled=false;
				 if(f_query_add_mod.patient_sub.document.getElementById('family_org_id'))
					 f_query_add_mod.patient_sub.document.getElementById('family_org_id').disabled=false;
				  if(f_query_add_mod.patient_sub.document.getElementById('relationship_to_head'))
				{
					 f_query_add_mod.patient_sub.document.getElementById('relationship_to_head_desc').disabled=false;
					 f_query_add_mod.patient_sub.document.getElementById('relationship_to_head_code_id').disabled=false;
					 f_query_add_mod.patient_sub.document.getElementById('relationship_to_head').disabled=false;
				}
				 // f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
//				 f_query_add_mod.document.forms[0].target="messageFrame";
				  
				 f_query_add_mod.patient_sub.Emergency_Regn.action="../../servlet/eMP.PatientRegistrationServlet";
				 f_query_add_mod.patient_sub.Emergency_Regn.target="messageFrame";
				 f_query_add_mod.patient_sub.Emergency_Regn.submit();
				
				if(f_query_add_mod.patient_sub.document.getElementById('details_unknown').checked)
				{
					f_query_add_mod.patient_sub.document.getElementById('pat_ser_grp_code').disabled = true;
					if(f_query_add_mod.patient_sub.document.getElementById('first_name') != null)
						f_query_add_mod.patient_sub.document.getElementById('first_name').disabled = true

					if(f_query_add_mod.patient_sub.document.getElementById('second_name') != null)
						f_query_add_mod.patient_sub.document.getElementById('second_name').disabled = true

					if(f_query_add_mod.patient_sub.document.getElementById('third_name') != null)
						f_query_add_mod.patient_sub.document.getElementById('third_name').disabled = true

					if(f_query_add_mod.patient_sub.document.getElementById('family_name') != null)
						f_query_add_mod.patient_sub.document.getElementById('family_name').disabled = true

				//Added the below code for SRR20056-SCF-6368 [IN:025789] by Suresh M on 10.01.2010
					if(f_query_add_mod.patient_sub.document.getElementById('first_name_oth_lang') != null)
						f_query_add_mod.patient_sub.document.getElementById('first_name_oth_lang').disabled = true

					if(f_query_add_mod.patient_sub.document.getElementById('second_name_oth_lang') != null)
						f_query_add_mod.patient_sub.document.getElementById('second_name_oth_lang').disabled = true

					if(f_query_add_mod.patient_sub.document.getElementById('third_name_oth_lang') != null)
						f_query_add_mod.patient_sub.document.getElementById('third_name_oth_lang').disabled = true

					if(f_query_add_mod.patient_sub.document.getElementById('family_name_oth_lang') != null)
						f_query_add_mod.patient_sub.document.getElementById('family_name_oth_lang').disabled = true
				// Ends Suresh M
				}

			}
			else
			{
				
				multipleclicks='false';

				var sStyle = f_query_add_mod.patient_sub.document.Emergency_Regn.sStyle.value;

				if(f_query_add_mod.patient_sub.document.getElementById('func_act').value != 'Visitreg')
				{
					var s = "<html><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><head><META HTTP-EQUIV='Content-Type' CONTENT='text/html;charset=UTF-8'>" +
							"</head><body onKeyDown='lockKey()'><form name='f' id='f' method='post' action='../../eCommon/jsp/error.jsp'>"+
							"<input type='hidden' name='err_num' id='err_num' value='"+LocalErrors+"'>"
							"</form></body></html>" ;
						messageFrame.document.body.insertAdjacentHTML('afterbegin',s);
						messageFrame.document.f.action='../../servlet/eMP.PatientRegistrationServlet';
						messageFrame.document.f.submit();
						//f_query_add_mod.document.f.target="messageFrame";
						//f_query_add_mod.document.f.submit();
				}
				else
				{
					var s = "<html> <head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link></head>" +
							"<body class='message' onKeyDown='lockKey()'><script>document.writeln('"+LocalErrors+"');"+
							" parent.commontoolbarFrame.location.href ='../jsp/EmergRegToolBar.jsp'; "+
						"</script></body>" +
						"</html>"
					messageFrame.document.open();
					messageFrame.document.writeln(s);
				}
			}
	    }
		
		else{
			multipleclicks='false';
		}
	}
	}
	}
/*function checkPatSex()  {
    var arLength = f_query_add_mod.patient_sub.NamePrefixArray.length;
    var q = 0;
    var res = new Boolean(false);
        while ( q <= arLength  )
        {
			if ( (f_query_add_mod.patient_sub.document.getElementById('name_prefix').value!='')  && ( unescape(f_query_add_mod.patient_sub.NamePrefixArray[q]) == f_query_add_mod.patient_sub.document.getElementById('name_prefix').value ) )
            {
				if(f_query_add_mod.patient_sub.PrefixSexArray[q] != f_query_add_mod.patient_sub.document.getElementById('sex').value && f_query_add_mod.patient_sub.PrefixSexArray[q] != 'B')
                {
                //LocalErrors = LocalErrors +f_query_add_mod.patient_sub.getMessage("SEX_MIS_PREFIX",'MP')	+ " <br>";
				var msg = f_query_add_mod.patient_sub.getMessage("PATIENT_SEX_MISMATCH",'MP');
					msg = msg.replace('$',f_query_add_mod.patient_sub.document.forms[0].name_prefix_prompt.value);
					LocalErrors = LocalErrors +msg	+ " <br>";
                res = false;
                }
                else
                    res = true;
            }

			if( (f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_lang').value!='') && (unescape(f_query_add_mod.patient_sub.NamePrefixLocArray[q]) == f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_lang').value) )
            {
				if(f_query_add_mod.patient_sub.PrefixSexArray[q] != f_query_add_mod.patient_sub.document.getElementById('sex').value && f_query_add_mod.patient_sub.PrefixSexArray[q] != 'B')
                {
					var msg = f_query_add_mod.patient_sub.getMessage("PATIENT_SEX_MISMATCH",'MP');
					msg = msg.replace('$',f_query_add_mod.patient_sub.document.forms[0].name_prefix_oth_prompt.value);
					LocalErrors = LocalErrors +msg	+ " <br>";
					res = false;
                }
                else
                    res = true;
            }
            q++;
        }

    return res;
}
function checkPatSuffixSex()  {
    var arLength = f_query_add_mod.patient_sub.NameSuffixArray.length;
    var q = 0;
    var res = new Boolean(false);
        while ( q <= arLength  )
        {
			if ( (f_query_add_mod.patient_sub.document.getElementById('name_suffix').value!='')  && ( unescape(f_query_add_mod.patient_sub.NameSuffixArray[q]) == f_query_add_mod.patient_sub.document.getElementById('name_suffix').value ) )
            {
				if(f_query_add_mod.patient_sub.SuffixSexArray[q] != f_query_add_mod.patient_sub.document.getElementById('sex').value && f_query_add_mod.patient_sub.SuffixSexArray[q] != 'B')
                {
					var msg = f_query_add_mod.patient_sub.getMessage("PATIENT_SEX_MISMATCH",'MP');
					msg = msg.replace('$',f_query_add_mod.patient_sub.document.forms[0].name_suffix_prompt.value);
					LocalErrors = LocalErrors +msg	+ " <br>";
                res = false;
                }
                else
                    res = true;
            }

			if( (f_query_add_mod.patient_sub.document.getElementById('name_suffix_oth_lang').value!='') && (unescape(f_query_add_mod.patient_sub.NameSuffixLocArray[q]) == f_query_add_mod.patient_sub.document.getElementById('name_suffix_oth_lang').value) )
            {
				if(f_query_add_mod.patient_sub.SuffixSexArray[q] != f_query_add_mod.patient_sub.document.getElementById('sex').value && f_query_add_mod.patient_sub.SuffixSexArray[q] != 'B')
                {
					var msg = f_query_add_mod.patient_sub.getMessage("PATIENT_SEX_MISMATCH",'MP');
					msg = msg.replace('$',f_query_add_mod.patient_sub.document.forms[0].name_suffix_oth_prompt.value);
					LocalErrors = LocalErrors +msg	+ " <br>";
					res = false;
                }
                else
                    res = true;
            }
            q++;
        }
    return res;
}
*/
function checkPatSex()  {
    var arLength = f_query_add_mod.patient_sub.NamePrefixArray.length;
    var q = 0;
    var res = new Boolean(false);
        while ( q <= arLength  )
        {
			if ( (f_query_add_mod.patient_sub.document.getElementById('name_prefix').value!='')  && ( unescape(f_query_add_mod.patient_sub.NamePrefixArray[q]) == f_query_add_mod.patient_sub.document.getElementById('name_prefix').value ) )
            {
				if(f_query_add_mod.patient_sub.PrefixSexArray[q] != f_query_add_mod.patient_sub.document.getElementById('sex').value && f_query_add_mod.patient_sub.PrefixSexArray[q] != 'B')
                {
					var msg = f_query_add_mod.patient_sub.getMessage("PATIENT_SEX_MISMATCH",'MP');
					if(localeName=='en')
					{
					msg = msg.replace('$',f_query_add_mod.patient_sub.document.forms[0].name_prefix_prompt.value);
					}
					else
					{
					msg = msg.replace('$',f_query_add_mod.patient_sub.document.forms[0].name_prefix_oth_prompt.value);
					}
					LocalErrors = LocalErrors +msg	+ " <br>";
                res = false;
                }
                else
                    res = true;
            }
            q++;
        }
    return res;
}

function checkPatOthSex()  
{
    var arLength = f_query_add_mod.patient_sub.NamePrefixArray.length;
    var q = 0;
    var res = new Boolean(false);
	while ( q <= arLength  )
	{
		if( (f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_lang').value!='') && (unescape(f_query_add_mod.patient_sub.NamePrefixLocArray[q]) == f_query_add_mod.patient_sub.document.getElementById('name_prefix_oth_lang').value) )
		{
			if(f_query_add_mod.patient_sub.PrefixSexArray[q] != f_query_add_mod.patient_sub.document.getElementById('sex').value && f_query_add_mod.patient_sub.PrefixSexArray[q] != 'B')
			{
				var msg = f_query_add_mod.patient_sub.getMessage("PATIENT_SEX_MISMATCH",'MP');
				msg = msg.replace('$',f_query_add_mod.patient_sub.document.forms[0].name_prefix_oth_prompt.value);
				LocalErrors = LocalErrors +msg	+ " <br>";
				res = false;
			}
			else
				res = true;
		}
            q++;
    }
    return res;
}
function checkPatSuffixSex()  {
    var arLength = f_query_add_mod.patient_sub.NameSuffixArray.length;
    var q = 0;
    var res = new Boolean(false);
        while ( q <= arLength  )
        {
			if ( (f_query_add_mod.patient_sub.document.getElementById('name_suffix').value!='')  && ( unescape(f_query_add_mod.patient_sub.NameSuffixArray[q]) == f_query_add_mod.patient_sub.document.getElementById('name_suffix').value ) )
            {
				if(f_query_add_mod.patient_sub.SuffixSexArray[q] != f_query_add_mod.patient_sub.document.getElementById('sex').value && f_query_add_mod.patient_sub.SuffixSexArray[q] != 'B')
                {
					var msg = f_query_add_mod.patient_sub.getMessage("PATIENT_SEX_MISMATCH",'MP');
					if(localeName=='en')
					{
					msg = msg.replace('$',f_query_add_mod.patient_sub.document.forms[0].name_suffix_prompt.value);
					}
					else
					{
					msg = msg.replace('$',f_query_add_mod.patient_sub.document.forms[0].name_suffix_oth_prompt.value);
					}
					LocalErrors = LocalErrors +msg	+ " <br>";
                res = false;
                }
                else
                    res = true;
            }
            q++;
        }
    return res;
}
function checkPatOthSuffixSex()  {
    var arLength = f_query_add_mod.patient_sub.NameSuffixArray.length;
    var q = 0;
    var res = new Boolean(false);
    while ( q <= arLength  )
    {
			if( (f_query_add_mod.patient_sub.document.getElementById('name_suffix_oth_lang').value!='') && (unescape(f_query_add_mod.patient_sub.NameSuffixLocArray[q]) == f_query_add_mod.patient_sub.document.getElementById('name_suffix_oth_lang').value) )
            {
				if(f_query_add_mod.patient_sub.SuffixSexArray[q] != f_query_add_mod.patient_sub.document.getElementById('sex').value && f_query_add_mod.patient_sub.SuffixSexArray[q] != 'B')
                {
					var msg = f_query_add_mod.patient_sub.getMessage("PATIENT_SEX_MISMATCH",'MP');
					msg = msg.replace('$',f_query_add_mod.patient_sub.document.forms[0].name_suffix_oth_prompt.value);
					LocalErrors = LocalErrors +msg	+ " <br>";
					res = false;
                }
                else
                    res = true;
            }
            q++;
        }
    return res;
}

 //END of the function
/*
function CheckNationalityLength(Obj,ActLength,CkecklenYN)
{
//  CheckNationalityLength(this,'"+id_length+"','"+id_checklen_yn+"'); should be called from InsertEmerRegn.jsp
    if(CkecklenYN == "Y")
        if(Obj.value.length != ActLength)
        {
            alert("Length Should be entered Fully");
            Obj.focus();
        }
}
*/
function AssignValues(Obj)
{
	if(document.getElementById('details_unknown').checked)
	{
    if(document.getElementById('first_name') != null)
    {
        var sel_gender = "";
			if(document.getElementById('sex').selectedIndex == 1)
				sel_gender = getLabel("Common.male.label","common");
			else if(document.getElementById('sex').selectedIndex == 2)
				sel_gender = getLabel("Common.female.label","common");
			else if(document.getElementById('sex').selectedIndex == 3)
				sel_gender = getLabel("Common.unknown.label","common");
            document.getElementById('first_name').value = getLabel("Common.unknown.label","common")+sel_gender;
	}
	}
}

/*function AssignValues(Obj)
{
    if(document.getElementById('first_name') != null)
    {
        if((document.getElementById('first_name').value == null || document.getElementById('first_name').value == "") && document.getElementById('details_unknown').checked == true)
            document.getElementById('first_name').value = "Unknown "+document.getElementById('sex').options[document.getElementById('sex').selectedIndex].text;
    }
}
*/
function onSuccess()
{
	f_query_add_mod.location.href = '../../eCommon/html/blank.html'
}
function enableFields()
{
}

 /*3/8/2006 This  function is taken from eHIS_Thai written by Meghanath */
function assignUnknowValues()
{	
	if(document.getElementById('details_unknown').checked)
	{
		if ( document.getElementById('first_name') != null ) {
			document.getElementById('first_name').value = "Unknown";
			parent.parent.f_query_add_mod.patient_sub.putPatientName(document.getElementById('first_name'));
		}
	
		if(document.getElementById('family_name') != null )
		{
			var sel_gender = "";
			if(document.getElementById('sex').selectedIndex == 1)
				sel_gender = "Male";
			else if(document.getElementById('sex').selectedIndex == 2)
				sel_gender = "Female";
			else if(document.getElementById('sex').selectedIndex == 3)
				sel_gender = "Unknown";
			if(document.forms[0].pat_name_as_multipart_yn.value == 'Y'){
				document.getElementById('family_name').value = sel_gender;
			}else{
				document.getElementById('family_name').value = "Unknown" +sel_gender;			
			}		
			parent.parent.f_query_add_mod.patient_sub.putPatientName(document.getElementById('family_name'));
		}		
		if ( document.getElementById('second_name_reqd_yn')  !=null ){
			document.getElementById('second_name').value = "Unknown";			
			parent.parent.f_query_add_mod.patient_sub.putPatientName(document.getElementById('second_name'));
		}
		if ( document.getElementById('third_name_reqd_yn')  !=null ){
			document.getElementById('third_name').value = "Unknown";
			parent.parent.f_query_add_mod.patient_sub.putPatientName(document.getElementById('third_name'));
		}
		document.getElementById('patient_name').value = document.getElementById('patient_name').value;
//Added the below code for SRR20056-SCF-6368 [IN:025789] by Suresh M on 10.01.2010
	
		if(document.getElementById('first_name_oth_lang')  !=null){			
				document.getElementById('first_name_oth_lang').value = getLabel("Common.unknown.label","common");
			parent.parent.f_query_add_mod.patient_sub.putLocalLangPatientName(document.getElementById('first_name_oth_lang'));
		}
		if(document.getElementById('second_name_oth_lang')  !=null){			
				document.getElementById('second_name_oth_lang').value = getLabel("Common.unknown.label","common");
			parent.parent.f_query_add_mod.patient_sub.putLocalLangPatientName(document.getElementById('second_name_oth_lang'));
		}
		if(document.getElementById('third_name_oth_lang')  !=null){			 
				document.getElementById('third_name_oth_lang').value = getLabel("Common.unknown.label","common");
			parent.parent.f_query_add_mod.patient_sub.putLocalLangPatientName(document.getElementById('third_name_oth_lang'));
		}
		if(document.getElementById('family_name_oth_lang') != null )
		{	
			var sel_gender = "";
			if(document.getElementById('sex').selectedIndex == 1)
				sel_gender =getLabel("Common.male.label","common");
			else if(document.getElementById('sex').selectedIndex == 2)
				sel_gender = getLabel("Common.female.label","common");
			else if(document.getElementById('sex').selectedIndex == 3)
				sel_gender = getLabel("Common.unknown.label","common");
			if(document.forms[0].pat_name_as_multipart_yn.value == 'Y'){
				document.getElementById('family_name_oth_lang').value = sel_gender;
			}else{				
				document.getElementById('family_name_oth_lang').value = getLabel("Common.unknown.label","common") +sel_gender;
			}		
			parent.parent.f_query_add_mod.patient_sub.putLocalLangPatientName(document.getElementById('family_name_oth_lang'))
		}
			
	// Ends SRR20056-SCF-6368 [IN:025789]
	}
}

var PSGCodeArray = new Array(); 
var PSGYNArray = new Array(); 
/*var NamePrefixArray = new Array(); 
var NamePrefixLocArray = new Array(); 
var PrefixSexArray = new Array();
var NameSuffixArray = new Array();
var NameSuffixLocArray = new Array();
var SuffixSexArray = new Array();*/

i=0 ;
function ChangeInitCase(obj)
{
  var name=obj.value;
  var spltval = name.split(" ") ;
  var temp_name = ""
 for(var i=0;i<spltval.length;i++)
 {
	var length= obj.value.length;
	var letter = spltval[i].substring(0,length-(length-1));
	var rest = spltval[i].substring(1,length);
	letter=letter.toUpperCase();
	rest=rest.toLowerCase();
	var  namenow= letter.concat(rest);
	temp_name+= namenow+" ";
 }
 obj.value= temp_name.substring(0,temp_name.length-1);

}
function enableimg()
{
if(document.getElementById('family_link_no').value.length!=0)
document.getElementById('rel').style.visibility = 'visible';
else
document.getElementById('rel').style.visibility = 'hidden';
}
function enableAltID()
 { 
	if(document.Emergency_Regn.other_alt_id.selectedIndex != 0){
		document.Emergency_Regn.other_alt_Id_text.disabled = false;
		document.Emergency_Regn.other_alt_Id_text.value="";
 }
	else 
		document.Emergency_Regn.other_alt_Id_text.disabled = true;
}
async function search_Country(obj,target)
{	
	if(obj.value != '')
	{
		var retVal =    new String();
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var tit="";				
		
			
		if(target.name == 'nationality_desc')
		{
			tit=getLabel("Common.nationality.label","common");
			sql="Select country_code code, long_desc description from Mp_Country_lang_vw where eff_status='E' and  upper(country_code) like upper(?) and upper(long_desc) like upper(?)  and language_id='"+localeName+"' order by 2";
		}
		argumentArray[0] = sql;
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
			if(target.name == 'nationality_desc')
			{
				document.forms[0].nationality_code.value= arr[0];
				clr_race();
			}
			else if(target.name == 'r_country_desc')
				document.forms[0].r_country_code.value= arr[0];
			else if(target.name == 'm_country_desc')
				document.forms[0].m_country_code.value= arr[0];
			else if(target.name == 'first_country_desc')
				document.forms[0].first_country_code.value= arr[0];
			else if(target.name == 'next_country_desc')
				document.forms[0].next_country_code.value= arr[0];
			else if(target.name == 'empyr_country_desc')
				document.forms[0].empyr_country_code.value= arr[0];
		}
		else
		{
			target.value='';
		}
	}
	/*
	else 
	{
		document.Emergency_Regn.all.image1.style.visibility = "hidden";
	}
	*/
}
function clr_race()
{
	if( (document.getElementById('nationality_code')) && (document.getElementById('nationality_code').value == document.getElementById('dflt_nationality_code').value))
	{
		if(document.getElementById('default_race_code').value != '') {
			document.getElementById('race_code').value = document.getElementById('default_race_code').value;
			document.getElementById('race_desc').value = document.getElementById('default_race_desc').value;
		}		
			
		if(document.getElementById('national_id_no').value.length == 0)
			document.getElementById('national_id_no').disabled = false;
		/*
		if(document.getElementById('race_required_yn').value == 'Y')
			document.Emergency_Regn.all.image1.style.visibility = "visible";
		*/
	}
	else
	{	
		//document.getElementById('race_code').options[0].selected = "true";
		document.getElementById('race_code').value = "";
		document.getElementById('race_desc').value = "";
		//document.Emergency_Regn.all.image1.style.visibility = "hidden";
	}
}
function change_stat_dis(){	 

	if(document.Emergency_Regn.citizen[0].checked==true) {
		
		
		if (document.getElementById('nationality_code')) {
			document.Emergency_Regn.nationality_code.value = document.Emergency_Regn.dflt_nationality_code.value;		
			document.Emergency_Regn.nationality_desc.value = document.Emergency_Regn.dflt_nationality_desc.value;
		}		

		if(document.Emergency_Regn.default_race_code.value != '') {
			document.Emergency_Regn.race_code.value =  document.Emergency_Regn.default_race_code.value;
			document.Emergency_Regn.race_desc.value =  document.Emergency_Regn.default_race_desc.value;
		}	

		

		document.Emergency_Regn.legal[0].checked=true;
		document.Emergency_Regn.citizen_yn.value='Y';
		document.Emergency_Regn.legal_yn.value='Y';
		document.Emergency_Regn.legal[0].disabled=true;
		document.Emergency_Regn.legal[1].disabled=true;

		  /* Added for IN:046495 by Dharma on 16th Jan 2014 Start*/
		  if(document.Emergency_Regn.alt_id1_man_non_ctz && document.Emergency_Regn.alt_id1_man_non_ctz.value=="true"){ 
			   if(document.forms[0].alt1_gif){
				  document.Emergency_Regn.alt_id1_reqd_yn.value='N'; 
				  document.forms[0].alt1_gif.style.visibility='hidden';
			   }
			   if(document.forms[0].alt1_exp_date1){
				  document.Emergency_Regn.alt_date1_reqd_yn.value='N';
				  document.forms[0].alt1_exp_date1.style.visibility='hidden';			
			   } 
		  }	  
		  /* Added for IN:046495 by Dharma on 16th Jan 2014 End*/
			//Maheshwaran added isNatIdAltIdMandVisaType for AAKH-CRF-0145 as on 22-04-2022
			if(document.Emergency_Regn.isNatIdOrAltIdMandVisaType.value=="true" || document.Emergency_Regn.isNatIdOrAltId1MandRes.value=="true" || document.Emergency_Regn.isNatIdAltIdMandVisaType.value=="true"){
				if(document.forms[0].visa_type){
					document.Emergency_Regn.visa_type.value="W";
					document.Emergency_Regn.visa_type.disabled=true;
				}
				if(document.forms[0].details_unknown.checked == false){
					getVisibleMandNatAltIds();
	
				}else{
					if(document.getElementById('citizen')[0].checked==true){
						document.Emergency_Regn.visa_type.value="";
						document.Emergency_Regn.visa_type.disabled=true;
						document.getElementById('madimg').style.visibility ='hidden';
					}
				}
			}
						
	} else {
		document.Emergency_Regn.legal[0].checked=true;
		document.Emergency_Regn.citizen_yn.value='N';		
	}
}

function select_val(){

	if(document.Emergency_Regn.legal[0].checked==true) {
		document.Emergency_Regn.legal_yn.value='Y';
	} else {
		document.Emergency_Regn.legal_yn.value='N';
	}
	
}

function callassignUnknowValues()
{
if(document.getElementById('sex').value!="")
	assignUnknowValues();
else
	{
	parent.patient_main.document.getElementById('patient_name').value="";
	parent.patient_main.document.getElementById('patient_name_loc_lang').value="";
	document.getElementById('patient_name').value = "";
	document.getElementById('family_name').value="";
	document.getElementById('patient_name_loc_lang').value = "";
	document.getElementById('family_name_oth_lang').value="";
	}
}
function checkPatientId()   {
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	var sStyle = document.forms[0].sStyle.value;

	if(document.getElementById('patient_id').value.length != document.getElementById('patient_id').maxLength && document.getElementById('patient_id').value.length > 0)
	{
		var msg = getMessage("PAT_ID_CH",'MP');
		msg = msg.replace('$', document.getElementById('patient_id').maxLength);
		alert(msg);					
		document.getElementById('patient_id').focus();
	}

	if(document.getElementById('patient_id').value.length == document.getElementById('patient_id').maxLength)
	{
		var pat_id = document.getElementById('patient_id').value;
		pat_id = pat_id.substring(0,2);
		if (pat_id != parent.frames[1].document.forms[0].pat_ser_grp_code.value && prefixReqd == "Y")
		{				
			var msg = getMessage("PAT_SER_PREFIX",'MP');
			msg = msg.replace('$', parent.frames[1].document.forms[0].pat_ser_grp_code.value);
			alert(msg);
			document.getElementById('patient_id').focus();
		}
		else
		{
			/*var HTMLVal = new String();
			HTMLVal = "<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY class='message'><form name='form1' id='form1' method='post' action='ServerValidation.jsp'><input type='hidden' name='process_id' id='process_id' value='3'><input name='pat_id' id='pat_id' type='hidden' value=\""+document.getElementById('patient_id').value+"\"></form></BODY></HTML>";
			parent.parent.messageFrame.document.open()
			parent.parent.messageFrame.document.writeln(HTMLVal);
			parent.parent.messageFrame.document.form1.submit();*/

			xmlStr+=" process_id=\"3\" ";
			xmlStr+=" pat_id=\""+document.getElementById('patient_id').value+"\"";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			
			var url = "../../eMP/jsp/ServerValidationXML.jsp";
			xmlHttp.open("POST", url, false);
			xmlHttp.setRequestHeader("Content-type" ,"application/x-www-form-urlencoded");
			xmlHttp.send(xmlDoc);
			eval(xmlHttp.responseText);
		}
	}
	if(document.getElementById('patient_id').value.length == 0)
	{
		parent.patient_sub.focus();
	}
}       

function loadPatSeriesManual()
{
	if (document.getElementById('patient_id').value.length==0)
	{
		if (document.getElementById('patient_id').readOnly==false)
		{
			prefixReqd = parent.frames[1].pat_sergrp_reqd_yn[parent.frames[1].document.getElementById('pat_ser_grp_code').selectedIndex];
			if (prefixReqd == "Y")
				document.getElementById('patient_id').value = parent.frames[1].document.forms[0].pat_ser_grp_code.value;
		}
	}
}
function loadPatSeriesManual()
{
	if (document.getElementById('patient_id').value.length==0)
	{
		if (document.getElementById('patient_id').readOnly==false)
		{
			prefixReqd = parent.frames[1].pat_sergrp_reqd_yn[parent.frames[1].document.getElementById('pat_ser_grp_code').selectedIndex];
			if (prefixReqd == "Y")
				document.getElementById('patient_id').value = parent.frames[1].document.forms[0].pat_ser_grp_code.value;
		}
	}
}
var PSGCodeArray = new Array(); 
var PSGYNArray = new Array(); 
var NamePrefixArray = new Array(); 
var NamePrefixLocArray = new Array(); 
var PrefixSexArray = new Array();
i=0 ;
function ChangeInitCase(obj)
{
  var name=obj.value;
  var spltval = name.split(" ") ;
  var temp_name = ""
 for(var i=0;i<spltval.length;i++)
 {
	var length= obj.value.length;
	var letter = spltval[i].substring(0,length-(length-1));
	var rest = spltval[i].substring(1,length);
	letter=letter.toUpperCase();
	rest=rest.toLowerCase();
	var  namenow= letter.concat(rest);
	temp_name+= namenow+" ";
 }
 obj.value= temp_name.substring(0,temp_name.length-1);

}
function enableimg()
{
if(document.getElementById('family_link_no').value.length!=0)
document.getElementById('rel').style.visibility = 'visible';
else
document.getElementById('rel').style.visibility = 'hidden';
}
function enableAltID()
 { 
	if(document.Emergency_Regn.document.getElementById('other_alt_id').selectedIndex != 0){
		document.Emergency_Regn.document.getElementById('other_alt_Id_text').disabled = false;
		document.Emergency_Regn.document.getElementById('other_alt_Id_text').other_alt_Id_text.value="";
 }
	else 
		document.Emergency_Regn.document.getElementById('other_alt_Id_text').disabled = true;
}

function change_status_emer()
{	
	
	if (document.Emergency_Regn.nationality_code) {
		document.Emergency_Regn.nationality_code.value = "";
		document.Emergency_Regn.nationality_desc.value = "";
	}

	if(document.Emergency_Regn.citizen[0].checked == true) {

		//document.Emergency_Regn.all.citizen_yn.value	= 'Y';
		document.getElementById('citizen_yn').value	= 'Y';
		//document.Emergency_Regn.all.legal_yn.value='Y';
		document.getElementById('legal_yn').value	= 'Y';
		document.Emergency_Regn.legal[0].checked		= true;
		document.Emergency_Regn.legal[0].disabled		= true;
		document.Emergency_Regn.legal[1].disabled		= true;

		if (document.Emergency_Regn.nationality_code) {
			document.getElementById('nationality_code').value = document.getElementById('nationality_code').value;		
			document.getElementById('nationality_desc').value = document.getElementById('dflt_nationality_desc').value;	
		}

		if(document.getElementById('default_race_code').value != '') {
			document.getElementById('race_code').value =  document.getElementById('default_race_code').value;
			document.getElementById('race_desc').value =  document.getElementById('default_race_desc').value;
		}	
		//Maheshwaran added for AAKH-CRF-0145	
		if(document.forms[0].details_unknown.checked == false)
			{	
			if(document.Emergency_Regn.isNatIdAltIdMandVisaType.value=="true" ){
			getVisibleMandNatAltIds();
			}
			}
		//Ends	
	} else	{

		document.getElementById('citizen_yn').value='N';
		document.Emergency_Regn.legal[0].disabled=false;
		document.Emergency_Regn.legal[1].disabled=false;

		if (document.Emergency_Regn.nationality_code) {
			document.getElementById('nationality_code').value='';
			document.getElementById('nationality_desc').value='';	
		}
		document.getElementById('race_code').value = "";
		document.getElementById('race_desc').value = "";

		/* Added for IN:046495 by Dharma on 16th Jan 2014 Start*/
		if(document.Emergency_Regn.details_unknown .checked ==false){
			if(document.Emergency_Regn.alt_id1_man_non_ctz && document.Emergency_Regn.alt_id1_man_non_ctz.value=="true" ) { 
			  if(document.getElementById('alt1_gif')){
				 document.getElementById('alt_id1_reqd_yn').value='Y'; 
				 document.getElementById('alt1_gif').style.visibility='visible';
				 document.getElementById('alt_id1_no').disabled=false;
			  }
			  if(document.getElementById('alt1_exp_date1')){
				 document.getElementById('alt_date1_reqd_yn').value='Y';
				 document.getElementById('alt1_exp_date1').style.visibility='visible';
			  }						
			}
		}
		/* Added for IN:046495 by Dharma on 16th Jan 2014 End*/ 

			if(document.Emergency_Regn.isNatIdOrAltIdMandVisaType.value=="true" || document.Emergency_Regn.isNatIdOrAltId1MandRes.value=="true"){

				if(document.getElementById('visa_type')){
					document.Emergency_Regn.visa_type.value="W";
					document.Emergency_Regn.visa_type.disabled=false;
				}
				if(document.forms[0].details_unknown.checked == false){
					getVisibleMandNatAltIds();
				}
			}
		//Added for AAKH-CRF-0145
		if(document.forms[0].details_unknown.checked == false)
			{
			if(document.Emergency_Regn.isNatIdAltIdMandVisaType.value=="true" ){
			getVisibleMandNatAltIds();
			}
			}		


	}
}

