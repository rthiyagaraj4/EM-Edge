function show() {
}

function create() {
	f_query_add_mod.location.href = "../../eAM/jsp/Referral_Form.jsp" ;
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
	f_query_add_mod.location.href ="../../eAM/jsp/queryReferralForm.jsp?function=referral" ;
}
function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
  }
function apply() 
{
if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	f_query_add_mod.document.referral_form.add_country_code.disabled=false;

	if (f_query_add_mod.document.referral_form.function_name.value=="modify")
	{
		
	}
		var fields = new Array (
				 f_query_add_mod.document.referral_form.referral_code,
				 f_query_add_mod.document.referral_form.long_desc,
				 f_query_add_mod.document.referral_form.short_desc,
				 f_query_add_mod.document.referral_form.healthcare_setting_type,
				 f_query_add_mod.document.referral_form.org_type,
				 f_query_add_mod.document.referral_form.applicability1
					);
		var names = new Array (
					f_query_add_mod.getLabel("Common.code.label","Common")
					,f_query_add_mod.getLabel("Common.longdescription.label","Common")
					,f_query_add_mod.getLabel("Common.shortdescription.label","Common")
					,f_query_add_mod.getLabel("Common.HealthcareSettingType.label","Common")
					,f_query_add_mod.getLabel("Common.OrganisationType.label","Common"),
					f_query_add_mod.getLabel("Common.Applicability.label","common")				
					  );
		if(f_query_add_mod.document.referral_form.applicability1.value=='R' || f_query_add_mod.document.referral_form.applicability1.value=='B')
			{
				fields[6]= f_query_add_mod.document.referral_form.associated_ref_facility			
				names[6]= f_query_add_mod.getLabel("eAM.AssociatedEnterpriseFacilityforReferral.label","am")
			}
		/*else if(f_query_add_mod.document.referral_form.applicability1.value=='B')
			{
				fields[6]= f_query_add_mod.document.referral_form.associated_ref_facility			
				names[6]= "Associated Enterprise Facility for Both"
			}*/
	var spfields = new Array ( f_query_add_mod.document.referral_form.referral_code );
	var spnames  =  new Array ( f_query_add_mod.getLabel("Common.code.label","Common") );
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";
		
	if(f_query_add_mod.SpecialCharCheck(spfields,spnames,messageFrame,"M", error_page))
	{
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
		{
				if(f_query_add_mod.document.forms[0].applicability1.value != '' && f_query_add_mod.document.forms[0].applicability1.value != 'N' && f_query_add_mod.document.forms[0].pat_prefix.value == '' && f_query_add_mod.document.forms[0].patient_no.value == '' )
				{
					//var msg = "APP-AM0069 Atleast # or $ must be entered";
					//msg = msg.replace('#','Patient Prefix for identifying Source');
					//msg = msg.replace('$','Series for Ext Pat Numbering');
					var msg = f_query_add_mod.getMessage("ATLEAST_ENTER_ONE_VALUE","AM");
					msg = msg.replace('#',f_query_add_mod.getLabel("eAM.PatientPrefixforidentifyingSource.label","am"));
					msg = msg.replace('$',f_query_add_mod.getLabel("eAM.SeriesforExtPatNumbering.label","am"));
					frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"";
				}
				else if(f_query_add_mod.document.forms[0].applicability2.value != '' && f_query_add_mod.document.forms[0].applicability2.value != 'N' && f_query_add_mod.document.forms[0].donor_prefix.value == '' && f_query_add_mod.document.forms[0].donor_no.value == '' )
				{
					//var msg = "APP-AM0069 Atleast # or $ must be entered";
					//msg = msg.replace('#','Donor Prefix for identifying Source');
					//msg = msg.replace('$','Series for Donor Numbering');
					var msg = f_query_add_mod.getMessage("ATLEAST_ENTER_ONE_VALUE","AM");
					msg = msg.replace('#',f_query_add_mod.getLabel("eAM.DonorPrefixforidentifyingSource.label","am"));
					msg = msg.replace('$',f_query_add_mod.getLabel("eAM.SeriesforDonorNumbering.label","am"));
					frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"";
				}
			else
			{
					for(var i=0; i<f_query_add_mod.document.forms[0].length;i++)
					{
						if( f_query_add_mod.document.forms[0].elements[i].disabled ==true)
						{
							f_query_add_mod.document.forms[0].elements[i].disabled =false;
						}
					}
					 var mode=f_query_add_mod.document.forms[0].function1.value;
					 if(mode=="modify"){
					 var app_change=f_query_add_mod.document.forms[0].app_change.value;
					 var ref_change=f_query_add_mod.document.forms[0].ref_change.value;
					 if((app_change==f_query_add_mod.document.forms[0].applicability1.value) && (ref_change==f_query_add_mod.document.forms[0].associated_ref_facility.value))
					   f_query_add_mod.document.forms[0].change_val.value="N";
					 else
					  f_query_add_mod.document.forms[0].change_val.value="Y";
					}
				//alert(f_query_add_mod.document.forms[0].change_val.value);

				f_query_add_mod.document.referral_form.submit();
			}
		}
	}
}


function reset() 
{
	/*if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } */
	if (f_query_add_mod.document.forms[0] != null)
	{
	    f_query_add_mod.document.location.reload() ;
	}
   else 
	{
           f_query_add_mod.frames[0].document.location.reload() ;
           f_query_add_mod.frames[1].document.location.reload() ;
    }

}


function onSuccess() {
f_query_add_mod.location.reload();
}


function change() 
{

	
	if (referral_form.source_use_at_regn_yn.checked == true)
		referral_form.source_use_at_regn_yn.value="Y";
	else
		referral_form.source_use_at_regn_yn.value="N";

   	if (referral_form.source_use_at_visit_yn.checked == true)
		referral_form.source_use_at_visit_yn.value="Y";
	else
		referral_form.source_use_at_visit_yn.value="N";

	if (referral_form.source_use_at_adm_yn.checked == true)
	 	referral_form.source_use_at_adm_yn.value="Y";
	else
		referral_form.source_use_at_adm_yn.value="N";

	if (referral_form.dest_use_at_concl_yn.checked == true)
		referral_form.dest_use_at_concl_yn.value="Y";
	else
		referral_form.dest_use_at_concl_yn.value="N";

	if (referral_form.dest_use_at_disch_yn.checked == true)
		referral_form.dest_use_at_disch_yn.value="Y";
	else
		referral_form.dest_use_at_disch_yn.value="N";
}



function validateTC(TissueCollection)
{

	if(TissueCollection == "N" || TissueCollection == "")
	{
		
		document.forms[0].donor_prefix.disabled = true;
		
		document.forms[0].donor_prefix.value = "";
		document.forms[0].donor_no.disabled = true;
		document.forms[0].donor_no.value = "";
	}
	else
	{
		document.forms[0].donor_prefix.disabled = false;
		document.forms[0].donor_no.disabled = false;
	}
}

function chkLen(obj)
{
	if(obj.value != '')
	{
		if(obj.value.length < 2 )
		{
			alert(getMessage("NOT_LESS_THAN_2CHAR","AM"));
			obj.value="";
			obj.focus();
		}
	}
}


function changeStatus(chkVal)
{
	if(chkVal.checked == true)
		chkVal.value = "Y";
	else
		chkVal.value = "N";
}

function chkOrders(applicability)
{
	if(applicability == "N" || applicability == "")
	{
	
		document.forms[0].pat_prefix.disabled = true;
		document.forms[0].pat_prefix.value = "";
		document.forms[0].pat_prefix_img.style.visibility = "hidden";
		document.forms[0].patient_no.disabled = true;
		document.forms[0].patient_no.value = "";
		document.forms[0].pat_mand_img.style.visibility = "hidden";

		document.forms[0].associated_ref_facility.disabled = true;
		document.forms[0].associated_ref_facility.value = "";
		
		document.forms[0].laboratory.checked = false;
		document.forms[0].laboratory.disabled = true;
		document.forms[0].laboratory.value = "N";

		document.forms[0].radiology.checked = false;
		document.forms[0].radiology.disabled = true;
		document.forms[0].radiology.value = "N";

		document.forms[0].pharmacy.checked = false;
		document.forms[0].pharmacy.disabled = true;
		document.forms[0].pharmacy.value = "N";
	}
	else
	{
		document.forms[0].associated_ref_facility.disabled = false;
		document.forms[0].pat_prefix.disabled = false;
		document.forms[0].patient_no.disabled = false;
		document.forms[0].laboratory.disabled = false;
		document.forms[0].radiology.disabled = false;
		document.forms[0].pharmacy.disabled = false;
		document.forms[0].pat_mand_img.style.visibility = "visible";

	if(applicability == "B")
		document.forms[0].pat_mand_img.style.visibility = "visible";
	}

	if(applicability == "E")
	{

		document.forms[0].associated_ref_facility.value = "";
		document.forms[0].associated_ref_facility.disabled = true;
		document.forms[0].pat_mand_img.style.visibility = "hidden";
	}

}

/*function searchCode(obj,target) //Function to obtain Postal code 
{
	
	var retVal =    new String();               
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	var tit="";				
	if(obj.name=="postal_code")
	{					
		tit=getLabel("eMP.postalcode.label","mp");
		sql="Select postal_code code, short_desc description from mp_postal_code where eff_status='E' and upper(postal_code) like upper(?) and upper(short_desc) like upper(?) order by 1";					
	}
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK  ;
	argumentArray[7] = CODE_DESC ;

	retVal = await CommonLookup( tit, argumentArray );				
	if(retVal != null && retVal != "" )
	{					
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		
		if(target.name == 'add_postal_desc')
			document.forms[0].add_postal_code.value= arr[0];
			document.forms[0].add_postal_desc.value= arr[1];
	}
	else{
		target.value='';
	}
}*/
	function goHomePage(){
				parent.location.href='../../eCommon/jsp/dmenu.jsp';
		}
		
		function chcol(ro)
		{

				var prev=0;
				var prevcol='MENUSUBLEVELCOLOR';
				document.getElementById('t').rows(prev).cells(0).className=prevcol;
				prevcol=ro.cells(0).className;
				ro.cells(0).className="MENUSELECTEDCOLOR";
				prev=ro.rowIndex;
		}

		function callJSPs(val)
		{
			
		
      
			if(val == 'HealthCare_Setting_Type')
				parent.frames[1].location.href = '../../eAM/jsp/HealthCareSettingType.jsp?module_id=AM&function_id=HCARE_SET_TYPE&function_name=HealthCare Setting Type&function_type=F&access=YYYNN';

			if(val == 'HealthCare_Setting_Type_Restrictions')
				parent.frames[1].location.href = '../../eAM/jsp/HealthCareSettingTypeRestrictions.jsp?module_id=AM&function_id=HCARE_SET_TYPE_RSTRN&function_name=HealthCare Setting Type Restrictions&function_type=F&access=YYYNN';

			if(val == 'ExternalReferralSource')
				parent.frames[1].location.href = '../../servlet/eAM.ReferralServlet?module_id=AM&function_id=REFERRAL&function_name=External / Referral Source&function_type=F&access=YYYNN';

			if(val == 'Referral_ID_Numbering')
				parent.frames[1].location.href = '../../eAM/jsp/ReferralIDNumbering.jsp?module_id=AM&function_id=REF_ID_NUM_FOR_FCY&function_name=Referral ID Numbering&function_type=F&access=YYYNN';
		
			if(val == 'ExternalReferralSource')
			parent.frames[1].location.href = '../../servlet/eAM.ReferralServlet?module_id=AM&function_id=REFERRAL&function_name=External / Referral Source&function_type=F&access=YYYNN';
			
			if(val == 'Referral_Speciality')
				parent.frames[1].location.href = '../../eAM/jsp/SpecialtyForExternalReferralSource.jsp?module_id=AM&function_id=SPLTY_FOR_EXT_REF_SRC&function_name=Specialty for External Referral Source &function_type=F&access=YYYNN';

			if(val == 'ExternalPractitioner')
				parent.frames[1].location.href = '../../eAM/jsp/ExternalPractitioner.jsp?module_id=AM&function_id=EXT_PRACT&function_name=External Practitioner&function_type=F&access=YYYNN';

			if(val == 'ExternalPractitionerForRef')
				parent.frames[1].location.href = '../../eAM/jsp/PractForExternalReferral.jsp?module_id=AM&function_id=EXT_PRACT_REF_SRC&function_name=External Practitioner for Referral Source &function_type=F&access=YYYNN';

		}
var currentTab = new String();
var previousTab = new String();
previousTab = "ch";
var prefixReqd;
 function tab_click(objName){
	 //alert("objName :"+objName);
	changeTab(objName);
 }
function changeTab(TabName) { //functions to simulate the pabbed pane consisting mother, child and father tabs.

//alert("TabName :"+TabName);
 if (TabName == 'ch'){
	 
        document.getElementById('ch').className='IPCAHIGHERLEVELCOLOR';
		document.getElementById('Character_tab').style.display='';
		document.getElementById('address_tab').style.display='none';
		document.getElementById('Character_tab').style.position='relative';
		document.forms[0].applicability1.style.display='';
        document.forms[0].associated_ref_facility.style.display='';
		document.forms[0].patient_no.style.display='';
		document.forms[0].applicability2.style.display='';
		document.forms[0].donor_prefix.style.display='';
		document.forms[0].donor_no.style.display='';
		

			
    }else if (TabName == 'ad'){
      //  document.getElementById('character').className='IPCAHIGHERLEVELCOLOR';
		document.getElementById('Character_tab').style.display='none';
		document.getElementById('address_tab').style.display='';
		document.getElementById('address_tab').style.position='relative';
		document.forms[0].applicability1.style.visibility='none';
        document.forms[0].associated_ref_facility.style.display='none';
		document.forms[0].patient_no.style.display='none';
		document.forms[0].applicability2.style.display='none';
		document.forms[0].donor_prefix.style.display='none';
		document.forms[0].donor_no.style.display='none';
	}
if (currentTab == 'ch')
	{

		document.getElementById('ch').className='IPCAHIGHERLEVELCOLOR';
	}
	 else if (currentTab == 'ad')
	{
		
		document.getElementById('ad').className='IPCAHIGHERLEVELCOLOR';
	}	
	 // CHANGE THE CURRENT TAB WHICH IS SELECTED NOW...............	 
	if (TabName == 'ch')
	{
		
		document.getElementById('ch').className='IPCASELECTEDCOLOR';
	}
	else if (TabName == 'ad')
	{
		document.getElementById('ad').className='IPCASELECTEDCOLOR';
		document.getElementById('ch').className='IPCAHIGHERLEVELCOLOR';
	}
		
   currentTab = TabName;
}



function sendToValidation(Val,areaobj,messageFrame,prev_region)
{
	if(prev_region == undefined || prev_region == "undefined") {
		prev_region = "";
	}
	var HTMLVal = new String();
	if ( Val == 7 )
	{
        if(areaobj.value !='')
        {
            HTMLVal = "<HTML><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eAM/jsp/ReferralValidation.jsp'><input type='hidden' name='process_id' id='process_id' value='7'>";
			
			var mode =areaobj.name

			if( mode=="m_region_code")
			{
				HTMLVal += "<input name='region_code' id='region_code' type='hidden' value='"+document.getElementById("m_region").value + "'><input name='prev_region' id='prev_region' type='hidden' value='"+prev_region+ "'>";
			}
			if( mode=="m_area_code")
			{
				HTMLVal += "<input name='res_area_code' id='res_area_code' type='hidden' value='"+document.getElementById("m_area").value + "'>";
			}
			if( mode=="m_town_code")
			{
				HTMLVal += "<input name='res_town_code' id='res_town_code' type='hidden' value='"+document.getElementById("m_town").value + "'>";
			}

			if( mode=="m_postal_code")
			{
				HTMLVal += "<input name='postal_code' id='postal_code' type='hidden' value='"+document.getElementById("m_postal_code").value + "'>";
			}
			
			/*	if ( mode== "m_postal_code" || mode == "next_postal_code" || mode=="first_postal_code" || mode=="employ_postal_code")
				HTMLVal += "<input name='postal_code' id='postal_code' type='hidden' value='"+areaobj.value + "'>";*/
           
            HTMLVal += "<input type='hidden' name='mode' id='mode' value='"+mode+"'></form></BODY></HTML>" ;
		    parent.messageFrame.document.write(HTMLVal);
			parent.messageFrame.form1.submit();
        }
    }
} // END OF THE FUNCTION



