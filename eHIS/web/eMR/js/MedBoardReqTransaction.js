
function old_enableOtherDetails(name, value)
{
	if(name == 'charges_appllicable')
	{
		if(value =='Y')
		{
			document.forms[0].amount.value = "";
			document.forms[0].amount.disabled = false;
			document.forms[0].recp_no.value = "";
			document.forms[0].recp_no.disabled = false;
			document.forms[0].recp_dat.value = "";
			document.forms[0].recp_dat.disabled = false;
			document.getElementById("recp_dat_img").disabled = false;
		}
		else if(value =='N' || value =='')
		{
			document.forms[0].amount.value = "";
			document.forms[0].amount.disabled = true;
			document.forms[0].recp_no.value = "";
			document.forms[0].recp_no.disabled = true;
			document.forms[0].recp_dat.value = "";
			document.forms[0].recp_dat.disabled = true;
			document.getElementById("recp_dat_img").disabled = true;
		}
	}
	else if(name == 'additional_charges')
	{
		if(value =='Y')
		{
			document.forms[0].add_amount.value = "";
			document.forms[0].add_amount.disabled = false;
			document.forms[0].add_recp_no.value = "";
			document.forms[0].add_recp_no.disabled = false;
			document.forms[0].add_recp_dat.value = "";
			document.forms[0].add_recp_dat.disabled = false;
			document.getElementById("add_recp_dat_img").disabled = false;
		}
		else if(value =='N' || value =='')
		{
			document.forms[0].add_amount.value = "";
			document.forms[0].add_amount.disabled = true;
			document.forms[0].add_recp_no.value = "";
			document.forms[0].add_recp_no.disabled = true;
			document.forms[0].add_recp_dat.value = "";
			document.forms[0].add_recp_dat.disabled = true;
			document.getElementById("add_recp_dat_img").disabled = true;
		}
	}
}	

function restrictMovement()
{
	alert(getMessage("WELCOME","Common"));
}


function ChkDateNumberInput(fld, e, deci)
{
	if (parseInt(deci)>0)
	   var strCheck = '.0123456789 /:';
	else
	   var strCheck = '0123456789 /:';
	
	var whichCode = (window.Event) ? e.which : e.keyCode;
    if (whichCode == 13) return true;  // Enter
	key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}

function validateSplchars(obj)
{	
	var val = obj.value.toUpperCase();			
	obj.value = val;	
	var fields=new Array();
	var names=new Array();
	fields[0]=obj;
	names[0]=getLabel("Common.otheraltid.label","Common");
	if(SpecialCharCheck( fields, names,'',"A",''))
		return true;
	else
	{
		obj.select();
		obj.focus();
		return false;
	}
}

function popApplAddress(reln_type)
{
	if(reln_type == '')//----- Select -----
		document.MedBoardReqDetailTabsForm.appl_addr.disabled = true;
	else if(reln_type == '4')//Others
		document.MedBoardReqDetailTabsForm.appl_addr.disabled = false;
	else if(reln_type == '3') // Self
		document.MedBoardReqDetailTabsForm.appl_addr.disabled = false;
	else 
		document.MedBoardReqDetailTabsForm.appl_addr.disabled = false;
}


function EnDisRelation(obj)
{
	if(obj != '')
	{
		document.getElementById("requestorImg").style.visibility = "visible";
		document.forms[0].relationship_type.value	= "";
		document.forms[0].relationship_type.disabled	= true;
		document.forms[0].relationship.value		= "";
		document.forms[0].relationship.disabled		= true;
		document.forms[0].appl_addr.disabled		= false;
	}
	else
	{
		document.getElementById("requestorImg").style.visibility = "hidden";
		document.forms[0].relationship_type.value	= "";
		document.forms[0].relationship_type.disabled	= false;
		document.forms[0].relationship.value		= "";
		document.forms[0].relationship.disabled		= false;
		document.forms[0].appl_addr.disabled		= true;
	}
}


function enDisRequestor(obj)
{
	if(obj != '')
	{
		document.MedBoardReqDetailTabsForm.req_type.value="";
		document.MedBoardReqDetailTabsForm.req_type.disabled=true;
		document.MedBoardReqDetailTabsForm.Requestor_Code.value="";
		document.MedBoardReqDetailTabsForm.requestor_desc.value="";
		document.MedBoardReqDetailTabsForm.requestor_desc.disabled=true;
		document.MedBoardReqDetailTabsForm.search_Requestor.disabled=true;
	}
	else
	{
		document.MedBoardReqDetailTabsForm.req_type.value="";
		document.MedBoardReqDetailTabsForm.req_type.disabled=false;
		document.MedBoardReqDetailTabsForm.Requestor_Code.value="";
		document.MedBoardReqDetailTabsForm.requestor_desc.value="";
		document.MedBoardReqDetailTabsForm.requestor_desc.disabled=false;
		document.MedBoardReqDetailTabsForm.search_Requestor.disabled=false;
	}
}

async function popAddress()
{
	var call_function	= document.forms[0].call_function.value;
	var Despatch_mode	= document.forms[0].Despatch_mode.value;
	var request_id		= document.forms[0].reg_no.value;
	if(Despatch_mode != '')
	{
		var retVal		= new String();
		var dialogHeight= "20vh" ;
		var dialogWidth = "25vw" ;
		var status		= "no";
		var patient_id	= document.forms[0].patientId.value;
		var arguments		= "";
		var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

		if(Despatch_mode == 'O')
		{
			var  other_del_addr_line1 = document.forms[0].other_del_addr_line1.value;
			var  other_del_addr_line2 = document.forms[0].other_del_addr_line2.value;
			var  other_del_addr_line3 = document.forms[0].other_del_addr_line3.value;
			var  other_del_addr_line4 = document.forms[0].other_del_addr_line4.value;
			var  other_del_res_town_desc = document.forms[0].other_del_res_town_desc.value;
			var  other_del_res_town_code = document.forms[0].other_del_res_town_code.value;
			var  other_del_res_area_desc = document.forms[0].other_del_res_area_desc.value;
			var  other_del_res_area_code = document.forms[0].other_del_res_area_code.value;
			var  other_del_region_desc = document.forms[0].other_del_region_desc.value;
			var  other_del_region_code = document.forms[0].other_del_region_code.value;
			var  other_del_postal_desc = document.forms[0].other_del_postal_desc.value;
			var  other_del_postal_code = document.forms[0].other_del_postal_code.value;
			var  other_del_country_desc = document.forms[0].other_del_country_desc.value;
			var  other_del_country_code = document.forms[0].other_del_country_code.value;

			//retVal = window.showModalDialog( "../../eMR/jsp/MedRecAddressFrames.jsp?RelationShipType=OtherDeliveryAddress&call_function="+call_function+"&request_id="+request_id+"&other_del_addr_line1="+escape(other_del_addr_line1)+"&other_del_addr_line2="+escape(other_del_addr_line2)+"&other_del_addr_line3="+escape(other_del_addr_line3)+"&other_del_addr_line4="+escape(other_del_addr_line4)+"&other_del_res_town_desc="+escape(other_del_res_town_desc)+"&other_del_res_town_code="+escape(other_del_res_town_code)+"&other_del_res_area_desc="+escape(other_del_res_area_desc)+"&other_del_res_area_code="+escape(other_del_res_area_code)+"&other_del_region_desc="+escape(other_del_region_desc)+"&other_del_region_code="+escape(other_del_region_code)+"&other_del_postal_desc="+escape(other_del_postal_desc)+"&other_del_postal_code="+escape(other_del_postal_code)+"&other_del_country_desc="+escape(other_del_country_desc)+"&other_del_country_code="+escape(other_del_country_code),arguments,features);

			retVal =await window.showModalDialog( "../../eMR/jsp/MedRecAddressFrames.jsp?RelationShipType=OtherDeliveryAddress&call_function="+call_function+"&request_id="+request_id+"&other_del_addr_line1="+encodeURIComponent(other_del_addr_line1)+"&other_del_addr_line2="+encodeURIComponent(other_del_addr_line2)+"&other_del_addr_line3="+encodeURIComponent(other_del_addr_line3)+"&other_del_addr_line4="+encodeURIComponent(other_del_addr_line4)+"&other_del_res_town_desc="+encodeURIComponent(other_del_res_town_desc)+"&other_del_res_town_code="+encodeURIComponent(other_del_res_town_code)+"&other_del_res_area_desc="+encodeURIComponent(other_del_res_area_desc)+"&other_del_res_area_code="+encodeURIComponent(other_del_res_area_code)+"&other_del_region_desc="+encodeURIComponent(other_del_region_desc)+"&other_del_region_code="+encodeURIComponent(other_del_region_code)+"&other_del_postal_desc="+encodeURIComponent(other_del_postal_desc)+"&other_del_postal_code="+encodeURIComponent(other_del_postal_code)+"&other_del_country_desc="+encodeURIComponent(other_del_country_desc)+"&other_del_country_code="+encodeURIComponent(other_del_country_code),arguments,features);

			
			
			if(retVal != null)
			{
				var arr = retVal.split("~");

				document.forms[0].other_del_addr_line1.value = arr[0];
				document.forms[0].other_del_addr_line2.value= arr[1];
				document.forms[0].other_del_addr_line3.value= arr[2];
				document.forms[0].other_del_addr_line4.value= arr[3];

				document.forms[0].other_del_res_town_desc.value= arr[4];
				document.forms[0].other_del_res_town_code.value= arr[5];
				
				document.forms[0].other_del_res_area_desc.value= arr[6];
				document.forms[0].other_del_res_area_code.value= arr[7];

				document.forms[0].other_del_region_desc.value= arr[8];
				document.forms[0].other_del_region_code.value= arr[9];

				
				
				document.forms[0].other_del_postal_desc.value= arr[10];
				document.forms[0].other_del_postal_code.value= arr[11];

				document.forms[0].other_del_country_desc.value= arr[12];
				document.forms[0].other_del_country_code.value= arr[13];
			}
		}
		else if(Despatch_mode == 'P')
		{
			var  personal_del_addr_line1 = document.forms[0].personal_del_addr_line1.value;
			var  personal_del_addr_line2 = document.forms[0].personal_del_addr_line2.value;
			var  personal_del_addr_line3 = document.forms[0].personal_del_addr_line3.value;
			var  personal_del_addr_line4 = document.forms[0].personal_del_addr_line4.value;
			var  personal_del_res_town_desc = document.forms[0].personal_del_res_town_desc.value;
			var  personal_del_res_town_code = document.forms[0].personal_del_res_town_code.value;
			var  personal_del_res_area_desc = document.forms[0].personal_del_res_area_desc.value;
			var  personal_del_res_area_code = document.forms[0].personal_del_res_area_code.value;
			var  personal_del_region_desc = document.forms[0].personal_del_region_desc.value;
			var  personal_del_region_code = document.forms[0].personal_del_region_code.value;
			var  personal_del_postal_desc = document.forms[0].personal_del_postal_desc.value;
			var  personal_del_postal_code = document.forms[0].personal_del_postal_code.value;
			var  personal_del_country_desc = document.forms[0].personal_del_country_desc.value;
			var  personal_del_country_code = document.forms[0].personal_del_country_code.value;

			//retVal = window.showModalDialog( "../../eMR/jsp/MedRecAddressFrames.jsp?RelationShipType=PersonalDeliveryAddress&call_function="+call_function+"&request_id="+request_id+"&personal_del_addr_line1="+escape(personal_del_addr_line1)+"&personal_del_addr_line2="+escape(personal_del_addr_line2)+"&personal_del_addr_line3="+escape(personal_del_addr_line3)+"&personal_del_addr_line4="+escape(personal_del_addr_line4)+"&personal_del_res_town_desc="+escape(personal_del_res_town_desc)+"&personal_del_res_town_code="+escape(personal_del_res_town_code)+"&personal_del_res_area_desc="+escape(personal_del_res_area_desc)+"&personal_del_res_area_code="+escape(personal_del_res_area_code)+"&personal_del_region_desc="+escape(personal_del_region_desc)+"&personal_del_region_code="+escape(personal_del_region_code)+"&personal_del_postal_desc="+escape(personal_del_postal_desc)+"&personal_del_postal_code="+escape(personal_del_postal_code)+"&personal_del_country_desc="+escape(personal_del_country_desc)+"&personal_del_country_code="+escape(personal_del_country_code),arguments,features);

			retVal =await window.showModalDialog( "../../eMR/jsp/MedRecAddressFrames.jsp?RelationShipType=PersonalDeliveryAddress&call_function="+call_function+"&request_id="+request_id+"&personal_del_addr_line1="+encodeURIComponent(personal_del_addr_line1)+"&personal_del_addr_line2="+encodeURIComponent(personal_del_addr_line2)+"&personal_del_addr_line3="+encodeURIComponent(personal_del_addr_line3)+"&personal_del_addr_line4="+encodeURIComponent(personal_del_addr_line4)+"&personal_del_res_town_desc="+encodeURIComponent(personal_del_res_town_desc)+"&personal_del_res_town_code="+encodeURIComponent(personal_del_res_town_code)+"&personal_del_res_area_desc="+encodeURIComponent(personal_del_res_area_desc)+"&personal_del_res_area_code="+encodeURIComponent(personal_del_res_area_code)+"&personal_del_region_desc="+encodeURIComponent(personal_del_region_desc)+"&personal_del_region_code="+encodeURIComponent(personal_del_region_code)+"&personal_del_postal_desc="+encodeURIComponent(personal_del_postal_desc)+"&personal_del_postal_code="+encodeURIComponent(personal_del_postal_code)+"&personal_del_country_desc="+encodeURIComponent(personal_del_country_desc)+"&personal_del_country_code="+encodeURIComponent(personal_del_country_code),arguments,features);


			if(retVal != null)
			{
				var arr = retVal.split("~");

				document.forms[0].personal_del_addr_line1.value = arr[0];
				document.forms[0].personal_del_addr_line2.value= arr[1];
				document.forms[0].personal_del_addr_line3.value= arr[2];
				document.forms[0].personal_del_addr_line4.value= arr[3];

				document.forms[0].personal_del_res_town_desc.value= arr[4];
				document.forms[0].personal_del_res_town_code.value= arr[5];
				
				document.forms[0].personal_del_res_area_desc.value= arr[6];
				document.forms[0].personal_del_res_area_code.value= arr[7];

				document.forms[0].personal_del_region_desc.value= arr[8];
				document.forms[0].personal_del_region_code.value= arr[9];
				
				document.forms[0].personal_del_postal_desc.value= arr[10];
				document.forms[0].personal_del_postal_code.value= arr[11];

				document.forms[0].personal_del_country_desc.value= arr[12];
				document.forms[0].personal_del_country_code.value= arr[13];
			}
		}
	}
}

function enableDisableObjs(mode)
{
	if(mode == 'P')
	{
		document.forms[0].report_taken.value = document.forms[0].appl_name.value;
		document.forms[0].report_taken.disabled = false;

		if(document.forms[0].del_nric_no != null)
		{
			document.forms[0].del_nric_no.value = "";
			document.forms[0].del_nric_no.disabled = false;
		}
		document.forms[0].del_oth_alt_type.value = "";
		document.forms[0].del_oth_alt_type.disabled = false;

		document.forms[0].del_oth_alt_id.value = "";
		document.forms[0].del_oth_alt_id.disabled = false;

		document.forms[0].posted_date.value = "";
		document.forms[0].posted_date.disabled = true;
		document.getElementById("postImg").disabled = true;

		document.forms[0].address.disabled = false;
		document.forms[0].file_no.value = "";
		document.forms[0].file_no.disabled = true;
	}
	else if(mode == 'O')
	{
		document.forms[0].report_taken.value = "";
		document.forms[0].report_taken.disabled = true;

		if(document.forms[0].del_nric_no != null)
		{
			document.forms[0].del_nric_no.value = "";
			document.forms[0].del_nric_no.disabled = true;
		}
		document.forms[0].del_oth_alt_type.value = "";
		document.forms[0].del_oth_alt_type.disabled = true;

		document.forms[0].del_oth_alt_id.value = "";
		document.forms[0].del_oth_alt_id.disabled = true;

		document.forms[0].posted_date.value = "";
		document.forms[0].posted_date.disabled = false;
		document.getElementById("postImg").disabled = false;

		document.forms[0].address.disabled = false;
		document.forms[0].file_no.value = "";
		document.forms[0].file_no.disabled = false;

	}else
	{
		document.forms[0].report_taken.value = "";
		document.forms[0].report_taken.disabled = true;

		if(document.forms[0].del_nric_no != null)
		{
			document.forms[0].del_nric_no.value = "";
			document.forms[0].del_nric_no.disabled = true;
		}
		document.forms[0].del_oth_alt_type.value = "";
		document.forms[0].del_oth_alt_type.disabled = true;

		document.forms[0].del_oth_alt_id.value = "";
		document.forms[0].del_oth_alt_id.disabled = true;

		document.forms[0].posted_date.value = "";
		document.forms[0].posted_date.disabled = true;

		document.getElementById("postImg").disabled = true;
		document.forms[0].address.disabled = true;

		document.forms[0].file_no.value = "";
		document.forms[0].file_no.disabled = true;
	}
}

async function DisplayApplAddress(reln_type)
{
	var retVal			= new String();
	var dialogHeight	= "400px" ;
	/*Added by Thamizh selvi on 9th Feb 2018 against ML-MMOH-CRF-0860.2 Start*/
	var isAddressLengthIncAppl = document.forms[0].isAddressLengthIncAppl.value;
	if(isAddressLengthIncAppl == "true")
		var dialogHeight	= "400px" ;
	/*End*/
	var dialogWidth		= "700px" ;
	var status			= "no";
	var call_function	= document.forms[0].call_function.value;
	var request_id		= document.forms[0].reg_no.value;
	var requestor_type	= document.forms[0].req_type.value;
	var requestor_desc	= document.forms[0].requestor_desc.value;
	var requestor_code	= document.forms[0].Requestor_Code.value;
	if(reln_type == '')
	{
		if(requestor_type != '' && requestor_desc == '')
		{
			var error = getMessage('CAN_NOT_BE_BLANK','Common');
			error = error.replace('$',getLabel("Common.Requestor.label","Common"));
			alert(error);
			return;
		}
	}

	var patient_id = "";
	if(call_function == 'MEDICAL_BOARD_REQUEST')
	{
		//if(parent.parent.frames[0].document.forms[0].patient_id)
		if(document.forms[0].patient_id)
			patient_id		=  document.forms[0].patient_id.value;
	}
	else if(document.forms[0].patient_id)
		patient_id		=  document.forms[0].patient_id.value;
	else
		patient_id = "";

	var arguments		= "";
	var calling_from	= "";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	if(reln_type == '')//----- Select -----
	{
		document.forms[0].appl_addr.disabled = false;
	}
	else if(reln_type == '4')//Others
	{
		document.forms[0].appl_addr.disabled = false;

		var  Oth_appl_addr_line1	= document.forms[0].Oth_appl_addr_line1.value;
		var  Oth_appl_addr_line2	= document.forms[0].Oth_appl_addr_line2.value;
		var  Oth_appl_addr_line3	= document.forms[0].Oth_appl_addr_line3.value;
		var  Oth_appl_addr_line4	= document.forms[0].Oth_appl_addr_line4.value;
		var  Oth_appl_res_town_desc = document.forms[0].Oth_appl_res_town_desc.value;
		var  Oth_appl_res_town_code = document.forms[0].Oth_appl_res_town_code.value;
		var  Oth_appl_res_area_desc = document.forms[0].Oth_appl_res_area_desc.value;
		var  Oth_appl_res_area_code = document.forms[0].Oth_appl_res_area_code.value;
		var  Oth_appl_region_desc	= document.forms[0].Oth_appl_region_desc.value;
		var  Oth_appl_region_code	= document.forms[0].Oth_appl_region_code.value;
		var  Oth_appl_postal_desc	= document.forms[0].Oth_appl_postal_desc.value;
		var  Oth_appl_postal_code	= document.forms[0].Oth_appl_postal_code.value;
		var  Oth_appl_country_desc	= document.forms[0].Oth_appl_country_desc.value;
		var  Oth_appl_country_code	= document.forms[0].Oth_appl_country_code.value;

		/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
		var  other_contact_no1		= document.forms[0].other_contact_no1.value;
		var  other_contact_no2		= document.forms[0].other_contact_no2.value;
		var  other_appl_email_id	= document.forms[0].other_appl_email_id.value;
		/*ML-MMOH-CRF-0707*/

//		retVal = window.showModalDialog( "../../eMR/jsp/MedRecAddressFrames.jsp?RelationShipType=Others&call_function="+call_function+"&reln_type="+reln_type+"&request_id="+request_id+"&patient_id="+patient_id+"&Oth_appl_addr_line1="+escape(Oth_appl_addr_line1)+"&Oth_appl_addr_line2="+escape(Oth_appl_addr_line2)+"&Oth_appl_addr_line3="+escape(Oth_appl_addr_line3)+"&Oth_appl_addr_line4="+escape(Oth_appl_addr_line4)+"&Oth_appl_res_town_desc="+escape(Oth_appl_res_town_desc)+"&Oth_appl_res_town_desc="+escape(Oth_appl_res_town_desc)+"&Oth_appl_res_area_desc="+escape(Oth_appl_res_area_desc)+"&Oth_appl_region_desc="+escape(Oth_appl_region_desc)+"&Oth_appl_postal_code="+escape(Oth_appl_postal_code)+"&Oth_appl_country_desc="+escape(Oth_appl_country_desc)+"&Oth_appl_country_code="+escape(Oth_appl_country_code),arguments,features);
		//retVal = window.showModalDialog( "../../eMR/jsp/MedRecAddressFrames.jsp?RelationShipType=Others&call_function="+call_function+"&reln_type="+reln_type+"&request_id="+request_id+"&patient_id="+patient_id+"&Oth_appl_addr_line1="+escape(Oth_appl_addr_line1)+"&Oth_appl_addr_line2="+escape(Oth_appl_addr_line2)+"&Oth_appl_addr_line3="+escape(Oth_appl_addr_line3)+"&Oth_appl_addr_line4="+escape(Oth_appl_addr_line4)+"&Oth_appl_res_town_desc="+escape(Oth_appl_res_town_desc)+"&Oth_appl_res_town_code="+escape(Oth_appl_res_town_code)+"&Oth_appl_res_area_code="+escape(Oth_appl_res_area_code)+"&Oth_appl_postal_desc="+escape(Oth_appl_postal_desc)+"&Oth_appl_region_code="+escape(Oth_appl_region_code)+"&Oth_appl_res_area_desc="+escape(Oth_appl_res_area_desc)+"&Oth_appl_region_desc="+escape(Oth_appl_region_desc)+"&Oth_appl_postal_code="+escape(Oth_appl_postal_code)+"&Oth_appl_country_desc="+escape(Oth_appl_country_desc)+"&Oth_appl_country_code="+escape(Oth_appl_country_code),arguments,features);

		retVal =await window.showModalDialog( "../../eMR/jsp/MedRecAddressFrames.jsp?RelationShipType=Others&call_function="+call_function+"&reln_type="+reln_type+"&request_id="+request_id+"&patient_id="+patient_id+"&Oth_appl_addr_line1="+encodeURIComponent(Oth_appl_addr_line1)+"&Oth_appl_addr_line2="+encodeURIComponent(Oth_appl_addr_line2)+"&Oth_appl_addr_line3="+encodeURIComponent(Oth_appl_addr_line3)+"&Oth_appl_addr_line4="+encodeURIComponent(Oth_appl_addr_line4)+"&Oth_appl_res_town_desc="+encodeURIComponent(Oth_appl_res_town_desc)+"&Oth_appl_res_town_code="+encodeURIComponent(Oth_appl_res_town_code)+"&Oth_appl_res_area_code="+encodeURIComponent(Oth_appl_res_area_code)+"&Oth_appl_postal_desc="+encodeURIComponent(Oth_appl_postal_desc)+"&Oth_appl_region_code="+encodeURIComponent(Oth_appl_region_code)+"&Oth_appl_res_area_desc="+encodeURIComponent(Oth_appl_res_area_desc)+"&Oth_appl_region_desc="+encodeURIComponent(Oth_appl_region_desc)+"&Oth_appl_postal_code="+encodeURIComponent(Oth_appl_postal_code)+"&Oth_appl_country_desc="+encodeURIComponent(Oth_appl_country_desc)+"&Oth_appl_country_code="+encodeURIComponent(Oth_appl_country_code)+"&other_contact_no1="+encodeURIComponent(other_contact_no1)+"&other_contact_no2="+encodeURIComponent(other_contact_no2)+"&other_appl_email_id="+encodeURIComponent(other_appl_email_id),arguments,features);

		

		if(retVal != null)
		{
			var arr = retVal.split("~");
 			document.forms[0].Oth_appl_addr_line1.value = arr[0];
			document.forms[0].Oth_appl_addr_line2.value= arr[1];
			document.forms[0].Oth_appl_addr_line3.value= arr[2];
			document.forms[0].Oth_appl_addr_line4.value= arr[3];

			document.forms[0].Oth_appl_res_town_desc.value= arr[4];
			document.forms[0].Oth_appl_res_town_code.value= arr[5];
			
			document.forms[0].Oth_appl_res_area_desc.value= arr[6];
			document.forms[0].Oth_appl_res_area_code.value= arr[7];

			document.forms[0].Oth_appl_region_desc.value= arr[8];
			document.forms[0].Oth_appl_region_code.value= arr[9];
			
			document.forms[0].Oth_appl_postal_desc.value= arr[10];
			//document.forms[0].Oth_appl_postal_code.value= arr[10];
			document.forms[0].Oth_appl_postal_code.value= arr[11];	
			document.forms[0].Oth_appl_country_desc.value= arr[12];
			document.forms[0].Oth_appl_country_code.value= arr[13];

			/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
			document.forms[0].other_contact_no1.value= arr[14];
			document.forms[0].other_contact_no2.value= arr[15];
			document.forms[0].other_appl_email_id.value= arr[16];
			/*ML-MMOH-CRF-0707*/
		}
	}
	else if(reln_type == '3') // Self
	{
		//alert('modal window');
		document.forms[0].appl_addr.disabled = false;
			
		var appl_addr_line1		= document.forms[0].appl_addr_line1.value;
		var appl_addr_line2		= document.forms[0].appl_addr_line2.value;
		var appl_addr_line3		= document.forms[0].appl_addr_line3.value;
		var appl_addr_line4		= document.forms[0].appl_addr_line4.value;
		var appl_res_town_code	= document.forms[0].appl_res_town_code.value;
		var appl_res_town_desc	= document.forms[0].appl_res_town_desc.value;
		var appl_res_area_code	= document.forms[0].appl_res_area_code.value;
		var appl_res_area_desc	= document.forms[0].appl_res_area_desc.value;
		var appl_region_code	= document.forms[0].appl_region_code.value;
		var appl_region_desc	= document.forms[0].appl_region_desc.value;
		var appl_postal_code	= document.forms[0].appl_postal_code.value;
		var appl_postal_desc	= document.forms[0].appl_postal_desc.value;
		var appl_country_desc = document.forms[0].appl_country_desc.value;
		var appl_country_code = document.forms[0].appl_country_code.value;

		/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
		var  self_contact_no1		= document.forms[0].self_contact_no1.value;
		var  self_contact_no2		= document.forms[0].self_contact_no2.value;
		var  self_appl_email_id		= document.forms[0].self_appl_email_id.value;
		/*ML-MMOH-CRF-0707*/

		//alert(appl_postal_code);

	//	retVal = window.showModalDialog( "../../eMR/jsp/MedRecAddressFrames.jsp?RelationShipType=Self&call_function="+call_function+"&reln_type="+reln_type+"&request_id="+request_id+"&patient_id="+patient_id+"&appl_addr_line1="+escape(appl_addr_line1)+"&appl_addr_line2="+escape(appl_addr_line2)+"&appl_addr_line3="+escape(appl_addr_line3)+"&appl_addr_line4="+escape(appl_addr_line4)+"&appl_res_town_code="+escape(appl_res_town_code)+"&appl_res_town_desc="+escape(appl_res_town_desc)+"&appl_res_area_code="+escape(appl_res_area_code)+"&appl_res_area_desc="+escape(appl_res_area_desc)+"&appl_region_code="+escape(appl_region_code)+"&appl_region_desc="+escape(appl_region_desc)+"&appl_postal_code="+escape(appl_postal_code)+"&appl_country_desc="+escape(appl_country_desc)+"&appl_country_desc="+escape(appl_country_desc),arguments,features);
		//retVal = window.showModalDialog( "../../eMR/jsp/MedRecAddressFrames.jsp?RelationShipType=Self&call_function="+call_function+"&reln_type="+reln_type+"&request_id="+request_id+"&patient_id="+patient_id+"&appl_addr_line1="+escape(appl_addr_line1)+"&appl_addr_line2="+escape(appl_addr_line2)+"&appl_addr_line3="+escape(appl_addr_line3)+"&appl_addr_line4="+escape(appl_addr_line4)+"&appl_res_town_code="+escape(appl_res_town_code)+"&appl_res_town_desc="+escape(appl_res_town_desc)+"&appl_res_area_code="+escape(appl_res_area_code)+"&appl_res_area_desc="+escape(appl_res_area_desc)+"&appl_region_code="+escape(appl_region_code)+"&appl_region_desc="+escape(appl_region_desc)+"&appl_postal_code="+escape(appl_postal_code)+"&appl_country_desc="+escape(appl_country_desc)+"&appl_country_code="+escape(appl_country_code),arguments,features);

		retVal =await window.showModalDialog( "../../eMR/jsp/MedRecAddressFrames.jsp?RelationShipType=Self&call_function="+call_function+"&reln_type="+reln_type+"&request_id="+request_id+"&patient_id="+patient_id+"&appl_addr_line1="+encodeURIComponent(appl_addr_line1)+"&appl_addr_line2="+encodeURIComponent(appl_addr_line2)+"&appl_addr_line3="+encodeURIComponent(appl_addr_line3)+"&appl_addr_line4="+encodeURIComponent(appl_addr_line4)+"&appl_res_town_code="+encodeURIComponent(appl_res_town_code)+"&appl_res_town_desc="+encodeURIComponent(appl_res_town_desc)+"&appl_res_area_code="+encodeURIComponent(appl_res_area_code)+"&appl_res_area_desc="+encodeURIComponent(appl_res_area_desc)+"&appl_region_code="+encodeURIComponent(appl_region_code)+"&appl_region_desc="+encodeURIComponent(appl_region_desc)+"&appl_postal_code="+encodeURIComponent(appl_postal_code)+"&appl_postal_desc="+encodeURIComponent(appl_postal_desc)+"&appl_country_desc="+encodeURIComponent(appl_country_desc)+"&appl_country_code="+encodeURIComponent(appl_country_code)+"&self_contact_no1="+encodeURIComponent(self_contact_no1)+"&self_contact_no2="+encodeURIComponent(self_contact_no2)+"&self_appl_email_id="+encodeURIComponent(self_appl_email_id),arguments,features);

		
		if(retVal != null)
		{
			var arr = retVal.split("~");
			document.forms[0].appl_addr_line1.value = arr[0];
			document.forms[0].appl_addr_line2.value= arr[1];
			document.forms[0].appl_addr_line3.value= arr[2];
			document.forms[0].appl_addr_line4.value= arr[3];
			document.forms[0].appl_res_town_desc.value= arr[4];
			document.forms[0].appl_res_town_code.value= arr[5];
			document.forms[0].appl_res_area_desc.value= arr[6];
			document.forms[0].appl_res_area_code.value= arr[7];
			document.forms[0].appl_region_desc.value= arr[8];
			document.forms[0].appl_region_code.value= arr[9];
			document.forms[0].appl_postal_desc.value= arr[10];			
			document.forms[0].appl_postal_code.value= arr[11];			
			document.forms[0].appl_country_desc.value= arr[12];
			document.forms[0].appl_country_code.value= arr[13];

			/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
			document.forms[0].self_contact_no1.value= arr[14];
			document.forms[0].self_contact_no2.value= arr[15];
			document.forms[0].self_appl_email_id.value= arr[16];
			/*ML-MMOH-CRF-0707*/
		}
	}
	else if(reln_type == '0') // Next OF Kin
	{
		var values ='';
		
		document.forms[0].appl_addr.disabled = false;

		var  nkin_addr_line1 = document.forms[0].nkin_addr_line1.value;
		var  nkin_addr_line2 = document.forms[0].nkin_addr_line2.value;
		var  nkin_addr_line3 = document.forms[0].nkin_addr_line3.value;
		var  nkin_addr_line4 = document.forms[0].nkin_addr_line4.value;
		var  nkin_res_town_desc = document.forms[0].nkin_res_town_desc.value;
		var  nkin_res_town_code = document.forms[0].nkin_res_town_code.value;
		var  nkin_res_area_desc = document.forms[0].nkin_res_area_desc.value;
		var  nkin_res_area_code = document.forms[0].nkin_res_area_code.value;
		var  nkin_region_desc = document.forms[0].nkin_region_desc.value;
		var  nkin_region_code = document.forms[0].nkin_region_code.value;
		var  nkin_postal_desc = document.forms[0].nkin_postal_desc.value;
		var  nkin_postal_code = document.forms[0].nkin_postal_code.value;
		var  nkin_country_desc = document.forms[0].nkin_country_desc.value;
		var  nkin_country_code = document.forms[0].nkin_country_code.value;

		/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
		var  nkin_contact_no1		= document.forms[0].nkin_contact_no1.value;
		var  nkin_contact_no2		= document.forms[0].nkin_contact_no2.value;
		var  nkin_appl_email_id		= document.forms[0].nkin_appl_email_id.value;
		/*ML-MMOH-CRF-0707*/

//		retVal = window.showModalDialog( "../../eMR/jsp/MedRecAddressFrames.jsp?RelationShipType=NKIN&call_function="+call_function+"&reln_type="+reln_type+"&request_id="+request_id+"&patient_id="+patient_id+"&nkin_addr_line1="+escape(nkin_addr_line1)+"&nkin_addr_line2="+escape(nkin_addr_line2)+"&nkin_addr_line3="+escape(nkin_addr_line3)+"&nkin_addr_line4="+escape(nkin_addr_line4)+"&nkin_res_town_desc="+escape(nkin_res_town_desc)+"&nkin_res_town_desc="+escape(nkin_res_town_desc)+"&nkin_res_area_desc="+escape(nkin_res_area_desc)+"&nkin_region_desc="+escape(nkin_region_desc)+"&nkin_postal_code="+escape(nkin_postal_code)+"&nkin_country_desc="+escape(nkin_country_desc)+"&nkin_country_code="+escape(nkin_country_code),arguments,features);
		//retVal = window.showModalDialog( "../../eMR/jsp/MedRecAddressFrames.jsp?RelationShipType=NKIN&call_function="+call_function+"&reln_type="+reln_type+"&request_id="+request_id+"&patient_id="+patient_id+"&nkin_addr_line1="+escape(nkin_addr_line1)+"&nkin_addr_line2="+escape(nkin_addr_line2)+"&nkin_addr_line3="+escape(nkin_addr_line3)+"&nkin_addr_line4="+escape(nkin_addr_line4)+"&nkin_res_town_desc="+escape(nkin_res_town_desc)+"&nkin_res_town_code="+escape(nkin_res_town_code)+"&nkin_postal_desc="+escape(nkin_postal_desc)+"&nkin_region_code="+escape(nkin_region_code)+"&nkin_res_area_code="+escape(nkin_res_area_code)+"&nkin_res_area_desc="+escape(nkin_res_area_desc)+"&nkin_region_desc="+escape(nkin_region_desc)+"&nkin_postal_code="+escape(nkin_postal_code)+"&nkin_country_desc="+escape(nkin_country_desc)+"&nkin_country_code="+escape(nkin_country_code),arguments,features);

		retVal =await window.showModalDialog( "../../eMR/jsp/MedRecAddressFrames.jsp?RelationShipType=NKIN&call_function="+call_function+"&reln_type="+reln_type+"&request_id="+request_id+"&patient_id="+patient_id+"&nkin_addr_line1="+encodeURIComponent(nkin_addr_line1)+"&nkin_addr_line2="+encodeURIComponent(nkin_addr_line2)+"&nkin_addr_line3="+encodeURIComponent(nkin_addr_line3)+"&nkin_addr_line4="+encodeURIComponent(nkin_addr_line4)+"&nkin_res_town_desc="+encodeURIComponent(nkin_res_town_desc)+"&nkin_res_town_code="+encodeURIComponent(nkin_res_town_code)+"&nkin_postal_desc="+encodeURIComponent(nkin_postal_desc)+"&nkin_region_code="+encodeURIComponent(nkin_region_code)+"&nkin_res_area_code="+encodeURIComponent(nkin_res_area_code)+"&nkin_res_area_desc="+encodeURIComponent(nkin_res_area_desc)+"&nkin_region_desc="+encodeURIComponent(nkin_region_desc)+"&nkin_postal_code="+encodeURIComponent(nkin_postal_code)+"&nkin_country_desc="+encodeURIComponent(nkin_country_desc)+"&nkin_country_code="+encodeURIComponent(nkin_country_code)+"&nkin_contact_no1="+encodeURIComponent(nkin_contact_no1)+"&nkin_contact_no2="+encodeURIComponent(nkin_contact_no2)+"&nkin_appl_email_id="+encodeURIComponent(nkin_appl_email_id),arguments,features);

		if(retVal != null)
		{
			var arr = retVal.split("~");
			document.forms[0].nkin_addr_line1.value = arr[0];
			document.forms[0].nkin_addr_line2.value= arr[1];
			document.forms[0].nkin_addr_line3.value= arr[2];
			document.forms[0].nkin_addr_line4.value= arr[3];
			document.forms[0].nkin_res_town_desc.value= arr[4];
			document.forms[0].nkin_res_town_code.value= arr[5];
			document.forms[0].nkin_res_area_desc.value= arr[6];
			document.forms[0].nkin_res_area_code.value= arr[7];
			document.forms[0].nkin_region_desc.value= arr[8];
			document.forms[0].nkin_region_code.value= arr[9];
			document.forms[0].nkin_postal_desc.value= arr[10];
			//document.forms[0].nkin_postal_code.value= arr[10];
			document.forms[0].nkin_postal_code.value= arr[11];
			document.forms[0].nkin_country_desc.value= arr[12];
			document.forms[0].nkin_country_code.value= arr[13];

			/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
			document.forms[0].nkin_contact_no1.value= arr[14];
			document.forms[0].nkin_contact_no2.value= arr[15];
			document.forms[0].nkin_appl_email_id.value= arr[16];
			/*ML-MMOH-CRF-0707*/
		}
	}else if(reln_type == '1') // FIRST TO NOTIFY
	{
		document.forms[0].appl_addr.disabled = false;

		var  fton_addr_line1 = document.forms[0].fton_addr_line1.value;
		var  fton_addr_line2 = document.forms[0].fton_addr_line2.value;
		var  fton_addr_line3 = document.forms[0].fton_addr_line3.value;
		var  fton_addr_line4 = document.forms[0].fton_addr_line4.value;
		var  fton_res_town_desc = document.forms[0].fton_res_town_desc.value;
		var  fton_res_town_code = document.forms[0].fton_res_town_code.value;
		var  fton_res_area_desc = document.forms[0].fton_res_area_desc.value;
		var  fton_res_area_code = document.forms[0].fton_res_area_code.value;
		var  fton_region_desc = document.forms[0].fton_region_desc.value;
		var  fton_region_code = document.forms[0].fton_region_code.value;
		var  fton_postal_desc = document.forms[0].fton_postal_desc.value;
		var  fton_postal_code = document.forms[0].fton_postal_code.value;
		var  fton_country_desc = document.forms[0].fton_country_desc.value;
		var  fton_country_code = document.forms[0].fton_country_code.value;

		/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
		var  fton_contact_no1		= document.forms[0].fton_contact_no1.value;
		var  fton_contact_no2		= document.forms[0].fton_contact_no2.value;
		var  fton_appl_email_id		= document.forms[0].fton_appl_email_id.value;
		/*ML-MMOH-CRF-0707*/

//		retVal = window.showModalDialog("../../eMR/jsp/MedRecAddressFrames.jsp?RelationShipType=FTON&call_function="+call_function+"&reln_type="+reln_type+"&request_id="+request_id+"&patient_id="+patient_id+"&fton_addr_line1="+escape(fton_addr_line1)+"&fton_addr_line2="+escape(fton_addr_line2)+"&fton_addr_line3="+escape(fton_addr_line3)+"&fton_addr_line4="+escape(fton_addr_line4)+"&fton_res_town_desc="+escape(fton_res_town_desc)+"&fton_res_town_desc="+escape(fton_res_town_desc)+"&fton_res_area_desc="+escape(fton_res_area_desc)+"&fton_region_desc="+escape(fton_region_desc)+"&fton_postal_code="+escape(fton_postal_code)+"&fton_country_desc="+escape(fton_country_desc)+"&fton_country_code="+escape(fton_country_code),arguments,features);
		//retVal = window.showModalDialog("../../eMR/jsp/MedRecAddressFrames.jsp?RelationShipType=FTON&call_function="+call_function+"&reln_type="+reln_type+"&request_id="+request_id+"&patient_id="+patient_id+"&fton_addr_line1="+escape(fton_addr_line1)+"&fton_addr_line2="+escape(fton_addr_line2)+"&fton_addr_line3="+escape(fton_addr_line3)+"&fton_addr_line4="+escape(fton_addr_line4)+"&fton_res_town_desc="+escape(fton_res_town_desc)+"&fton_res_town_code="+escape(fton_res_town_code)+"&fton_res_area_desc="+escape(fton_res_area_desc)+"&fton_res_area_code="+escape(fton_res_area_code)+"&fton_region_code="+escape(fton_region_code)+"&fton_postal_desc="+escape(fton_postal_desc)+"&fton_region_desc="+escape(fton_region_desc)+"&fton_postal_code="+escape(fton_postal_code)+"&fton_country_desc="+escape(fton_country_desc)+"&fton_country_code="+escape(fton_country_code),arguments,features);

		retVal =await window.showModalDialog("../../eMR/jsp/MedRecAddressFrames.jsp?RelationShipType=FTON&call_function="+call_function+"&reln_type="+reln_type+"&request_id="+request_id+"&patient_id="+patient_id+"&fton_addr_line1="+encodeURIComponent(fton_addr_line1)+"&fton_addr_line2="+encodeURIComponent(fton_addr_line2)+"&fton_addr_line3="+encodeURIComponent(fton_addr_line3)+"&fton_addr_line4="+encodeURIComponent(fton_addr_line4)+"&fton_res_town_desc="+encodeURIComponent(fton_res_town_desc)+"&fton_res_town_code="+encodeURIComponent(fton_res_town_code)+"&fton_res_area_desc="+encodeURIComponent(fton_res_area_desc)+"&fton_res_area_code="+encodeURIComponent(fton_res_area_code)+"&fton_region_code="+encodeURIComponent(fton_region_code)+"&fton_postal_desc="+encodeURIComponent(fton_postal_desc)+"&fton_region_desc="+encodeURIComponent(fton_region_desc)+"&fton_postal_code="+encodeURIComponent(fton_postal_code)+"&fton_country_desc="+encodeURIComponent(fton_country_desc)+"&fton_country_code="+encodeURIComponent(fton_country_code)+"&fton_contact_no1="+encodeURIComponent(fton_contact_no1)+"&fton_contact_no2="+encodeURIComponent(fton_contact_no2)+"&fton_appl_email_id="+encodeURIComponent(fton_appl_email_id),arguments,features);

		if(retVal != null)
		{
			var arr = retVal.split("~");
			document.forms[0].fton_addr_line1.value = arr[0];
			document.forms[0].fton_addr_line2.value= arr[1];
			document.forms[0].fton_addr_line3.value= arr[2];
			document.forms[0].fton_addr_line4.value= arr[3];
			document.forms[0].fton_res_town_desc.value= arr[4];
			document.forms[0].fton_res_town_code.value= arr[5];
			document.forms[0].fton_res_area_desc.value= arr[6];
			document.forms[0].fton_res_area_code.value= arr[7];
			document.forms[0].fton_region_desc.value= arr[8];
			document.forms[0].fton_region_code.value= arr[9];
			document.forms[0].fton_postal_desc.value= arr[10];
			//document.forms[0].fton_postal_code.value= arr[10];
			document.forms[0].fton_postal_code.value= arr[11];
			document.forms[0].fton_country_desc.value= arr[12];
			document.forms[0].fton_country_code.value= arr[13];

			/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
			document.forms[0].fton_contact_no1.value= arr[14];
			document.forms[0].fton_contact_no2.value= arr[15];
			document.forms[0].fton_appl_email_id.value= arr[16];
			/*ML-MMOH-CRF-0707*/
		}
	} else if(reln_type == '2') // EMPLOYER
	{
		document.forms[0].appl_addr.disabled = false;

		var  emplr_addr_line1 = document.forms[0].emplr_addr_line1.value;
		var  emplr_addr_line2 = document.forms[0].emplr_addr_line2.value;
		var  emplr_addr_line3 = document.forms[0].emplr_addr_line3.value;
		var  emplr_addr_line4 = document.forms[0].emplr_addr_line4.value;
		var  emplr_res_town_desc = document.forms[0].emplr_res_town_desc.value;
		var  emplr_res_town_code = document.forms[0].emplr_res_town_code.value;
		var  emplr_res_area_desc = document.forms[0].emplr_res_area_desc.value;
		var  emplr_res_area_code = document.forms[0].emplr_res_area_code.value;
		var  emplr_region_desc = document.forms[0].emplr_region_desc.value;
		var  emplr_region_code = document.forms[0].emplr_region_code.value;
		var  emplr_postal_desc = document.forms[0].emplr_postal_desc.value;
		var  emplr_postal_code = document.forms[0].emplr_postal_code.value;
		var  emplr_country_desc = document.forms[0].emplr_country_desc.value;
		var  emplr_country_code = document.forms[0].emplr_country_code.value;

		/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
		var  emplr_contact_no1		= document.forms[0].emplr_contact_no1.value;
		var  emplr_contact_no2		= document.forms[0].emplr_contact_no2.value;
		var  emplr_appl_email_id	= document.forms[0].emplr_appl_email_id.value;
		/*ML-MMOH-CRF-0707*/

//		retVal = window.showModalDialog( "../../eMR/jsp/MedRecAddressFrames.jsp?RelationShipType=EMPLR&call_function="+call_function+"&reln_type="+reln_type+"&request_id="+request_id+"&patient_id="+patient_id+"&emplr_addr_line1="+escape(emplr_addr_line1)+"&emplr_addr_line2="+escape(emplr_addr_line2)+"&emplr_addr_line3="+escape(emplr_addr_line3)+"&emplr_addr_line4="+escape(emplr_addr_line4)+"&emplr_res_town_desc="+escape(emplr_res_town_desc)+"&emplr_res_town_desc="+escape(emplr_res_town_desc)+"&emplr_res_area_desc="+escape(emplr_res_area_desc)+"&emplr_region_desc="+escape(emplr_region_desc)+"&emplr_postal_code="+escape(emplr_postal_code)+"&emplr_country_desc="+escape(emplr_country_desc)+"&emplr_country_code="+escape(emplr_country_code),arguments,features);
		//retVal = window.showModalDialog( "../../eMR/jsp/MedRecAddressFrames.jsp?RelationShipType=EMPLR&call_function="+call_function+"&reln_type="+reln_type+"&request_id="+request_id+"&patient_id="+patient_id+"&emplr_addr_line1="+escape(emplr_addr_line1)+"&emplr_addr_line2="+escape(emplr_addr_line2)+"&emplr_addr_line3="+escape(emplr_addr_line3)+"&emplr_addr_line4="+escape(emplr_addr_line4)+"&emplr_res_town_desc="+escape(emplr_res_town_desc)+"&emplr_res_town_code="+escape(emplr_res_town_code)+"&emplr_res_area_desc="+escape(emplr_res_area_desc)+"&emplr_region_desc="+escape(emplr_region_desc)+"&emplr_postal_code="+escape(emplr_postal_code)+"&emplr_postal_desc="+escape(emplr_postal_desc)+"&emplr_region_code="+escape(emplr_region_code)+"&emplr_res_area_code="+escape(emplr_res_area_code)+"&emplr_country_desc="+escape(emplr_country_desc)+"&emplr_country_code="+escape(emplr_country_code),arguments,features);

		retVal =await window.showModalDialog( "../../eMR/jsp/MedRecAddressFrames.jsp?RelationShipType=EMPLR&call_function="+call_function+"&reln_type="+reln_type+"&request_id="+request_id+"&patient_id="+patient_id+"&emplr_addr_line1="+encodeURIComponent(emplr_addr_line1)+"&emplr_addr_line2="+encodeURIComponent(emplr_addr_line2)+"&emplr_addr_line3="+encodeURIComponent(emplr_addr_line3)+"&emplr_addr_line4="+encodeURIComponent(emplr_addr_line4)+"&emplr_res_town_desc="+encodeURIComponent(emplr_res_town_desc)+"&emplr_res_town_code="+encodeURIComponent(emplr_res_town_code)+"&emplr_res_area_desc="+encodeURIComponent(emplr_res_area_desc)+"&emplr_region_desc="+encodeURIComponent(emplr_region_desc)+"&emplr_postal_code="+encodeURIComponent(emplr_postal_code)+"&emplr_postal_desc="+encodeURIComponent(emplr_postal_desc)+"&emplr_region_code="+encodeURIComponent(emplr_region_code)+"&emplr_res_area_code="+encodeURIComponent(emplr_res_area_code)+"&emplr_country_desc="+encodeURIComponent(emplr_country_desc)+"&emplr_country_code="+encodeURIComponent(emplr_country_code)+"&emplr_contact_no1="+encodeURIComponent(emplr_contact_no1)+"&emplr_contact_no2="+encodeURIComponent(emplr_contact_no2)+"&emplr_appl_email_id="+encodeURIComponent(emplr_appl_email_id),arguments,features);


		if(retVal != null)
		{
			var arr = retVal.split("~");
			document.forms[0].emplr_addr_line1.value = arr[0];
			document.forms[0].emplr_addr_line2.value= arr[1];
			document.forms[0].emplr_addr_line3.value= arr[2];
			document.forms[0].emplr_addr_line4.value= arr[3];
			document.forms[0].emplr_res_town_desc.value= arr[4];
			document.forms[0].emplr_res_town_code.value= arr[5];
			document.forms[0].emplr_res_area_desc.value= arr[6];
			document.forms[0].emplr_res_area_code.value= arr[7];
			document.forms[0].emplr_region_desc.value= arr[8];
			document.forms[0].emplr_region_code.value= arr[9];
			document.forms[0].emplr_postal_desc.value= arr[10];
			//document.forms[0].emplr_postal_code.value= arr[10];
			document.forms[0].emplr_postal_code.value= arr[11];
			document.forms[0].emplr_country_desc.value= arr[12];
			document.forms[0].emplr_country_code.value= arr[13];

			/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
			document.forms[0].emplr_contact_no1.value= arr[14];
			document.forms[0].emplr_contact_no2.value= arr[15];
			document.forms[0].emplr_appl_email_id.value= arr[16];
			/*ML-MMOH-CRF-0707*/
		}
	}

	if(requestor_type != '')
	{
		document.forms[0].appl_addr.disabled = false;
		var mode = document.forms[0].mode.value;
		var  requestor_addr_line1	= document.forms[0].requestor_addr_line1.value;
		var  requestor_addr_line2	= document.forms[0].requestor_addr_line2.value;
		var  requestor_addr_line3	= document.forms[0].requestor_addr_line3.value;
		var  requestor_addr_line4	= document.forms[0].requestor_addr_line4.value;
		var  requestor_res_town_desc= document.forms[0].requestor_res_town_desc.value;
		var  requestor_res_town_code= document.forms[0].requestor_res_town_code.value;
		var  requestor_res_area_desc= document.forms[0].requestor_res_area_desc.value;
		var  requestor_res_area_code= document.forms[0].requestor_res_area_code.value;
		var  requestor_region_desc	= document.forms[0].requestor_region_desc.value;
		var  requestor_region_code	= document.forms[0].requestor_region_code.value;
		var  requestor_postal_desc	= document.forms[0].requestor_postal_desc.value;
		var  requestor_postal_code	= document.forms[0].requestor_postal_code.value;
		var  requestor_country_desc	= document.forms[0].requestor_country_desc.value;
		var  requestor_country_code	= document.forms[0].requestor_country_code.value;

		/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
		var  requestor_contact_no1		= document.forms[0].requestor_contact_no1.value;
		var  requestor_contact_no2		= document.forms[0].requestor_contact_no2.value;
		var  requestor_appl_email_id	= document.forms[0].requestor_appl_email_id.value;
		/*ML-MMOH-CRF-0707*/

//		retVal = window.showModalDialog( "../../eMR/jsp/MedRecAddressFrames.jsp?mode="+mode+"&requestor_Type="+requestor_type+"&requestor_code="+requestor_code+"&call_function="+call_function+"&reln_type="+reln_type+"&request_id="+request_id+"&patient_id="+patient_id+"&requestor_addr_line1="+escape(requestor_addr_line1)+"&requestor_addr_line2="+escape(requestor_addr_line2)+"&requestor_addr_line3="+escape(requestor_addr_line3)+"&requestor_addr_line4="+escape(requestor_addr_line4)+"&requestor_res_town_desc="+escape(requestor_res_town_desc)+"&requestor_res_town_desc="+escape(requestor_res_town_desc)+"&requestor_res_area_desc="+escape(requestor_res_area_desc)+"&requestor_region_desc="+escape(requestor_region_desc)+"&requestor_postal_code="+escape(requestor_postal_code)+"&requestor_country_desc="+escape(requestor_country_desc)+"&requestor_country_code="+escape(requestor_country_code),arguments,features);
		//retVal = window.showModalDialog( "../../eMR/jsp/MedRecAddressFrames.jsp?mode="+mode+"&requestor_Type="+requestor_type+"&requestor_code="+requestor_code+"&call_function="+call_function+"&reln_type="+reln_type+"&request_id="+request_id+"&patient_id="+patient_id+"&requestor_addr_line1="+escape(requestor_addr_line1)+"&requestor_addr_line2="+escape(requestor_addr_line2)+"&requestor_addr_line3="+escape(requestor_addr_line3)+"&requestor_region_code="+escape(requestor_region_code)+"&requestor_res_area_code="+escape(requestor_res_area_code)+"&requestor_postal_desc="+escape(requestor_postal_desc)+"&requestor_addr_line4="+escape(requestor_addr_line4)+"&requestor_res_town_desc="+escape(requestor_res_town_desc)+"&requestor_res_town_code="+escape(requestor_res_town_code)+"&requestor_res_area_desc="+escape(requestor_res_area_desc)+"&requestor_region_desc="+escape(requestor_region_desc)+"&requestor_postal_code="+escape(requestor_postal_code)+"&requestor_country_desc="+escape(requestor_country_desc)+"&requestor_country_code="+escape(requestor_country_code),arguments,features);

		retVal =await window.showModalDialog( "../../eMR/jsp/MedRecAddressFrames.jsp?mode="+mode+"&requestor_Type="+requestor_type+"&requestor_code="+requestor_code+"&call_function="+call_function+"&reln_type="+reln_type+"&request_id="+request_id+"&patient_id="+patient_id+"&requestor_addr_line1="+encodeURIComponent(requestor_addr_line1)+"&requestor_addr_line2="+encodeURIComponent(requestor_addr_line2)+"&requestor_addr_line3="+encodeURIComponent(requestor_addr_line3)+"&requestor_region_code="+encodeURIComponent(requestor_region_code)+"&requestor_res_area_code="+encodeURIComponent(requestor_res_area_code)+"&requestor_postal_desc="+encodeURIComponent(requestor_postal_desc)+"&requestor_addr_line4="+encodeURIComponent(requestor_addr_line4)+"&requestor_res_town_desc="+encodeURIComponent(requestor_res_town_desc)+"&requestor_res_town_code="+encodeURIComponent(requestor_res_town_code)+"&requestor_res_area_desc="+encodeURIComponent(requestor_res_area_desc)+"&requestor_region_desc="+encodeURIComponent(requestor_region_desc)+"&requestor_postal_code="+encodeURIComponent(requestor_postal_code)+"&requestor_country_desc="+encodeURIComponent(requestor_country_desc)+"&requestor_country_code="+encodeURIComponent(requestor_country_code)+"&requestor_contact_no1="+encodeURIComponent(requestor_contact_no1)+"&requestor_contact_no2="+encodeURIComponent(requestor_contact_no2)+"&requestor_appl_email_id="+encodeURIComponent(requestor_appl_email_id),arguments,features);

		if(retVal != null)
		{
			var arr = retVal.split("~");
			document.forms[0].requestor_addr_line1.value = arr[0];
			document.forms[0].requestor_addr_line2.value= arr[1];
			document.forms[0].requestor_addr_line3.value= arr[2];
			document.forms[0].requestor_addr_line4.value= arr[3];
			document.forms[0].requestor_res_town_desc.value= arr[4];
			document.forms[0].requestor_res_town_code.value= arr[5];
			document.forms[0].requestor_res_area_desc.value= arr[6];
			document.forms[0].requestor_res_area_code.value= arr[7];
			document.forms[0].requestor_region_desc.value= arr[8];
			document.forms[0].requestor_region_code.value= arr[9];
			document.forms[0].requestor_postal_desc.value= arr[10];
			//document.forms[0].requestor_postal_code.value= arr[10];
			document.forms[0].requestor_postal_code.value= arr[11];
			document.forms[0].requestor_country_desc.value= arr[12];
			document.forms[0].requestor_country_code.value= arr[13];

			/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
			document.forms[0].requestor_contact_no1.value= arr[14];
			document.forms[0].requestor_contact_no2.value= arr[15];
			document.forms[0].requestor_appl_email_id.value= arr[16];
			/*ML-MMOH-CRF-0707*/

			document.forms[0].mode.value="Modify";
		}	
	}
}


function setDate(Status)
{
	if(Status == '1')
	{
		document.getElementById("collectImg").style.visibility = "Hidden";
		document.forms[0].collect_date.value = "";
		document.forms[0].collect_date.disabled = true;
		document.getElementById("collect_img").disabled = true;

		document.getElementById("appln_col1").innerText = "";
		document.getElementById("appln_col2").innerText = "";
	}
	else if(Status == '2')
	{
		document.getElementById("collectImg").style.visibility = "visible";
		document.forms[0].collect_date.value = "";
		document.forms[0].collect_date.disabled = false;
		document.getElementById("collect_img").disabled = false;
		
		document.getElementById("appln_col1").innerText = getLabel("eMR.ApplicationCompletionDates.label","MR");
		//document.getElementById("appln_col2").innerText = document.forms[0].sysdate.value;
		document.getElementById("appln_col2").innerText = convertDate(document.forms[0].sysdate.value,'DMYHM','en',localeName);
	}
	else
	{
		document.getElementById("collectImg").style.visibility = "visible";
		document.forms[0].collect_date.value = "";
		document.forms[0].collect_date.disabled = true;
		document.getElementById("collect_img").disabled = true;
		
		document.getElementById("appln_col1").innerText = "";
		document.getElementById("appln_col2").innerText = "";
	}
}

function populateApplName(relationship_type)
{

	var popNameFor ="";

	if(relationship_type == "0" )
		popNameFor = "NKIN";
	else if (relationship_type == "1")
		popNameFor = "FTON";
	else if(relationship_type == "2" )
		popNameFor = "EMP";

	if(relationship_type == "0" || relationship_type == "1" || relationship_type == "2" )
	{
		document.getElementById("relationImg").style.visibility = "hidden";
		document.forms[0].appl_name.value = "";
		document.forms[0].relationship.value = "";
		document.forms[0].relationship.disabled = true;
		var patientid	= parent.frames[2].document.forms[0].patient_id.value

		var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dummy_form' id='dummy_form' method='post'  action='../../eMR/jsp/MedRecRequestValidation.jsp' ><input type='hidden' name='Criteria' id='Criteria' value='populateApplName'><input type='hidden' name='popNameFor' id='popNameFor' value='"+popNameFor+"'><input type='hidden' name='patientId' id='patientId' value='"+patientid+"'><input type='hidden' name='relationCode' id='relationCode' value='"+relationship_type+"'></form></body></html>";
		parent.frames[4].document.write(HTMLVal);
		parent.frames[4].document.dummy_form.submit();

	}
	else if(relationship_type == "3")
	{
		document.getElementById("relationImg").style.visibility = "hidden";
		document.forms[0].relationship.value = "";
		document.forms[0].relationship.disabled = true;
//		document.forms[0].appl_name.value = document.forms[0].pat_nam.value;
		document.forms[0].appl_name.value = parent.frames[2].document.forms[0].patient_name.value;
		document.forms[0].appl_name.disabled = true;
	}
	else if(relationship_type == "4")
	{
		document.getElementById("relationImg").style.visibility = "visible";
		document.forms[0].relationship.value = "";
		document.forms[0].relationship.disabled = false;
		document.forms[0].appl_name.value = "";
		document.forms[0].appl_name.disabled = false;
	}
	else
	{
		document.getElementById("relationImg").style.visibility = "hidden";
		document.forms[0].appl_name.value = "";
		document.forms[0].appl_name.disabled = false;
		document.forms[0].relationship.value = "";
		document.forms[0].relationship.disabled = true;
	}
}

// function tab_click - Will Scroll the view between Two Tabs ...
function tab_click(objName)
{
	if(objName == 'requestor_details')
	{
		if(document.getElementById("tab1"))
			document.getElementById("tab1").scrollIntoView();
	
		if(document.forms[0].reg_no && document.forms[0].reg_no.disabled == false)	
			document.forms[0].reg_no.focus();
		else if(document.forms[0].relationship_type && document.forms[0].relationship_type.disabled == false)	
			document.forms[0].relationship_type.focus();
		else if(document.getElementById("tab1"))
			document.getElementById("tab1").focus();
	}
	else if(objName == 'report_details')
	{
		if(document.getElementById("tab2"))
			document.getElementById("tab2").scrollIntoView();

		if(document.forms[0].rep_type && document.forms[0].rep_type.disabled == false)	
			document.forms[0].rep_type.focus();
		else if(document.forms[0].delivered_date && document.forms[0].delivered_date.disabled==false)	
			document.forms[0].delivered_date.focus();
		else if(document.getElementById("tab2"))
			document.getElementById("tab2").focus();
	}
	else if(objName == 'other_details')
	{
		if(document.getElementById("tab3"))
		{
			document.getElementById("tab3").scrollIntoView();
			document.getElementById("tab3").focus();
		}
	}
}


function validateDate(obj)
{
	var validatevalue = obj.value
	var prepared = document.forms[0].hdd_PrepareDate.value;
	var Collect	 = document.forms[0].hdd_CollectDate.value;
	var Receive	 = document.forms[0].hdd_RecieveDate.value;
	var call_function = document.forms[0].call_function.value;

	
	if(validatevalue != '')
	{

		var greg_ReceivedDateTime = convertDate(obj.value,'DMYHM',localeName,'en');
		var error=getMessage("MRDATE1_LT_DATE2",'MR');

		if(call_function == 'RECEIVE_MEDICAL_BOARD')
		{
						
			if(document.forms[0].hid_revised_collect_date != null)
			{
				if(document.forms[0].hid_revised_collect_date.value == '')
				{
					//if(ValidateDateTime(document.forms[0].hdd_CollectDate,obj))
					if(isAfter(greg_ReceivedDateTime,document.forms[0].hdd_CollectDate.value,'DMYHM','en'))
					{
						var err1=getMessage("MRDATE1_GT_DATE2",'MR');
						err1= err1.replace('$',getLabel("Common.ReceivedDate.label","Common"));
						err1= err1.replace('#',getLabel("eMR.CollectDate.label","MR"));
						alert(err1);
						obj.select();
						obj.focus();
						return;
					}
				}
				else
				{
					//if(ValidateDateTime(document.forms[0].hid_revised_collect_date,obj))
					if(isAfter(greg_ReceivedDateTime,document.forms[0].hid_revised_collect_date.value,'DMYHM','en'))
					{
						var err2=getMessage("MRDATE1_GT_DATE2",'MR');
						err2= err2.replace('$',getLabel("Common.ReceivedDate.label","Common"));
						err2= err2.replace('#',getLabel("eMR.RevisedCollectDate.label","MR"));
						alert(err2);
						obj.select();
						obj.focus();
						return;
					}
				}

			}
			else
			{
				//if(ValidateDateTime(document.forms[0].hdd_CollectDate,obj))
				if(isAfter(greg_ReceivedDateTime,document.forms[0].hdd_CollectDate.value,'DMYHM','en'))
				{
					var err3=getMessage("MRDATE1_GT_DATE2",'MR');
					err3= err3.replace('$',getLabel("Common.ReceivedDate.label","Common"));
					err3= err3.replace('#',getLabel("eMR.CollectDate.label","MR"));
					alert(err3);
					obj.select();
					obj.focus();
					return;
				}
			}

			//if(ValidateDateTime(obj,document.forms[0].hdd_PrepareDate))
			if(isBefore(greg_ReceivedDateTime,document.forms[0].hdd_PrepareDate.value,'DMYHM','en'))
			{
				error= error.replace('$',getLabel("Common.ReceivedDate.label","Common"));
				error= error.replace('#',getLabel("Common.PrepareDate.label","Common"));
				alert(error)
				//("Receive date cannot be less than prepare Date")
				obj.select();
				obj.focus();
				return;
			}
		}
	
		if(call_function == 'DELIVER_MEDICAL_BOARD')
		{
			//if(ValidateDateTime(obj,document.forms[0].hdd_RecieveDate))
			if(isBefore(greg_ReceivedDateTime,document.forms[0].hdd_RecieveDate.value,'DMYHM','en'))
			{
				var err=getMessage("MRDATE1_GTR_DATE2",'MR');
				err= err.replace('$',getLabel("eMR.DeliveredDate.label","MR"));
				err= err.replace('#',getLabel("Common.ReceivedDate.label","Common"));
				alert(err);
				obj.select();
				obj.focus();
				return;
			}
		}


		if(call_function == 'REVISE_MEDICAL_REPORT')
		{
			//if(ValidateDateTime(obj,document.forms[0].sysdate))
			if(isBeforeNow(greg_ReceivedDateTime,'DMYHM','en'))
			{
				error= error.replace('$',getLabel("eMR.RevisedDate.label","MR"));
				error= error.replace('#',getLabel("Common.SystemDate.label","Common"));
				alert(error)
				obj.select();
				obj.focus();
				return;
			}

			//if(ValidateDateTime(obj,document.forms[0].hdd_CollectDate))
			if(isBefore(greg_ReceivedDateTime,document.forms[0].hdd_CollectDate.value,'DMYHM','en'))
			{
				error= error.replace('$',getLabel("eMR.RevisedDate.label","MR"));
				error= error.replace('#',getLabel("eMR.CollectDate.label","MR"));
				alert(error)
//				("Revise date cannot be less than Collect Date")
				obj.select();
				obj.focus();
				return;
			}

			if(document.forms[0].old_revised_collect_date.value != '')
			{
				//if(ValidateDateTime(obj,document.forms[0].old_revised_collect_date))
				if(isBefore(greg_ReceivedDateTime,document.forms[0].old_revised_collect_date.value,'DMYHM','en'))
				{
					error= error.replace('$',getLabel("eMR.RevisedDate.label","MR"));
					error= error.replace('#',getLabel("eMR.RevisedCollectDate.label","MR"));
					alert(error)
					obj.select();
					obj.focus();
					return;
				}
			}
		}
	}
}

function chkDateVal(obj)
{
	/*if(obj.value != '' )
	{
		if(!doDateTimeChk(obj))
		{
			alert( getMessage("INVALID_DATE_TIME",'SM') );
			obj.value = "";
			obj.focus();
			return ;
		}
	}*/

	if(!validDateObj(obj,'DMYHM',localeName))
	{
		obj.value = '';
		obj.focus();
		return ;
	}
}

function chklim(obj,maxSize)	
{
   var len  = obj.value;
	if ( obj.value.length > maxSize )
	{
	    alert(getMessage("REMARKS_NOT_EXCEED_200_CH",'SM'));
	    obj.focus();
	    obj.select();
	}
}

function BeforeGetSpecialtyValue(obj1,obj2)
{
	if(document.forms[0].dept_spl.value != "")
		getSpecialtyValue(obj1,obj2);
	else
		document.forms[0].Splcode.value = "";
}

// To get the Specialty using common lookup.
async function getSpecialtyValue(aSpecialty, getFacilitID)
{
	var facility_id	   = getFacilitID;
	var target		   = document.forms[0].dept_spl;
	var locale		   = document.forms[0].locale.value;
	var retVal		   = new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	var sql = " Select speciality_code code, short_desc description from AM_SPECIALITY_LANG_VW where LANGUAGE_ID ='"+locale+"' and eff_status like 'E' and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) ";
	var tit = getLabel("Common.speciality.label","Common");

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1, 2";
	argumentArray[5] = aSpecialty.value;
	argumentArray[6] = CODE_DESC_LINK;
	argumentArray[7] = CODE_DESC;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].Splcode.value=arr[0];
		document.forms[0].dept_spl.value=arr[1];
	}
	else
	{
		document.forms[0].dept_spl.value = "";
		document.forms[0].Splcode.value = "";
	}
} // End of getSpecialtyValue.


function CompareCollectDate(collect,prepared)
{
	
	if(prepared.value != '')
	{
		var collectDt	= collect.value;
		//var preparedDt	= prepared.value;
		//var result = "Pass";
		var preparedDt =  convertDate(prepared.value,'DMYHM',localeName,'en');

		if(collectDt != '')
		{
			//if (ValidateDateTime(collect,prepared))
			if(isAfter(preparedDt,collectDt,'DMYHM','en'))
			{
				var error=getMessage("MRDATE1_GT_DATE2",'MR');
				var call_function = document.forms[0].call_function.value;
				error= error.replace('$',getLabel("Common.PrepareDate.label","Common"));
				error= error.replace('#',getLabel("eMR.CollectDate.label","MR"));
				alert(error)
	//			("Prepare date should be less than collect date...")
				document.forms[0].prepare_date.select();
				document.forms[0].prepare_date.focus();
				//result = "Fail";
			}
		}
		
	}
}

function CompareReqDate(obj,obj2)
{
	//var dtVal=obj.value;		
	//if(obj.value!='')
	//{
		//if(doDateTimeChk(obj))
		if(validDateObj(obj,'DMYHM',localeName))
		{	
			if(obj.value!='' && obj2.value!='')
			{
				//if(!ValidateDateTime(obj2,obj))
				var greg_prepareDateTime = convertDate(obj.value,'DMYHM',localeName,'en');
				if(isBefore(greg_prepareDateTime,obj2.value,'DMYHM','en'))
				{
					var str = getMessage("MRDATE1_LT_DATE2",'MR');
					str = str.replace('$',getLabel("Common.datetime.label","Common"));
					str = str.replace('#',getLabel("Common.RequestDate.label","Common"));
					alert(str);	
					obj.value='';	
					obj.focus();	
				}
			}
		}
		else
		{
			//var str = getMessage("INVALID_DATE_TIME",'SM');
			//alert(str);
			obj.value='';
			return false;
		}
	//}
}


function CompareSysDatePrp(obj)
{
	//var obj2 = document.forms[0].sysdate;
	//var dtVal=obj.value;		
	if(obj.value!='')
	{
		if(validDateObj(obj,'DMYHM',localeName))
		{
	
			var greg_prepareDateTime = convertDate(obj.value,'DMYHM',localeName,'en');
			
	
			/*if(doDateTimeChk(obj))
			{	
			if(obj.value!='' && obj2.value!='')
			{*/
			//if(!ValidateDateTime(obj,obj2))
				if(isAfterNow(greg_prepareDateTime,'DMYHM','en'))
				{
					var str = getMessage("MRDATE1_GT_DATE2",'MR');
					str = str.replace('$',getLabel("Common.PrepareDate.label","Common"));
					str = str.replace('#',getLabel("Common.SystemDate.label","Common"));
					alert(str);	
					obj.value='';	
					obj.focus();	
				}
			//}
		}
		else
		{
				//var str = getMessage("INVALID_DATE_TIME",'SM');
				//alert(str);
				obj.value='';
		}
	}		
}


function CompareSysforRecdDate(obj)
{
	//var obj2 = document.forms[0].sysdate;
	//var dtVal=obj.value;		
	if(obj.value!='')
	{
		//if(doDateTimeChk(obj))
		if(validDateObj(obj,'DMYHM',localeName))
		{	
			//if(obj.value!='' && obj2.value!='')
			//{
				//if(!ValidateDateTime(obj,obj2))
				var greg_ReceivedDateTime = convertDate(obj.value,'DMYHM',localeName,'en');
				if(isAfterNow(greg_ReceivedDateTime,'DMYHM','en'))
				{
					var str = getMessage("MRDATE1_GT_DATE2",'MR');
					if(obj.name=="delivered_date")
					{
						str = str.replace('$',getLabel("eMR.DeliveredDate.label","MR"));
					}
					else
					{
						str = str.replace('$',getLabel("Common.ReceivedDate.label","Common"));
					}
					str = str.replace('#',getLabel("Common.SystemDate.label","Common"));
					alert(str);	
					obj.value='';	
					obj.focus();	
				}
			//}
		}
		else
		{
			//var str = getMessage("INVALID_DATE_TIME",'SM');
			//alert(str);
			obj.value='';
		}
	}
}



function compareDates(obj,sysdate)
{
	
	if(obj.value !='')// DateUtils.js
	{
		var fromDt	= convertDate(document.forms[0].from_date.value,"DMY",localeName,"en");
		var toDt	= convertDate(document.forms[0].to_date.value,"DMY",localeName,"en");
		if(!isBefore(fromDt,sysdate,'DMY',localeName))// DateUtils.js
		{
			var error=getMessage("MRDATE1_GT_DATE2",'MR');
			error= error.replace('$',getLabel("eMR.ApplicationDateTime.label","MR"));
			error= error.replace('#',getLabel("Common.regndatetime.label","Common"));
			alert(error);
			//obj.select();
			obj.value="";
			obj.focus();
		}
	}
}


function CompareRegnDate(obj,sysdate)
{
	
	if(!validDateObj(obj,'DMYHM',localeName))
	{
		obj.value = "";
		//result = "Fail";
		return false;
	}
	//if(obj.value != '')
	else
	{
		var fromdate = convertDate(obj.value,"DMYHM",localeName,"en");
		//if (!isBefore(sysdate,obj))
		if(isAfterNow(fromdate,'DMYHM','en'))
		{
			var error=getMessage("MRDATE1_GT_DATE2",'MR');
			error= error.replace('$',getLabel("eMR.ApplicationDateTime.label","MR"));
			error= error.replace('#',getLabel("Common.regndatetime.label","Common"));
			alert(error);
			//appln date shud nnot be greater than regn date ...
			obj.select();
			obj.focus();
			return false;
		}
		else
			return true;
	}
}


function CompareSysDate(obj,sysdate)
{
	/*var fromdate = obj.value;
	var SystemDate = sysdate.value;
	var result = "Pass";

	if(obj.value != '' )
	{
		if(!doDateTimeChk(obj))
		{
//			alert( getMessage("INVALID_DATE_TIME",'SM') );
			obj.focus();
			obj.value = "";
			result = "Fail";
			return ;
		}


	}*/

	if(!validDateObj(obj,'DMYHM',localeName))
	{
		obj.focus();
		obj.value = "";
		//result = "Fail";
		return false;
	}
	//if(result == "Pass")
	else
	{

		var greg_comparedDate = convertDate(obj.value,'DMYHM',localeName,'en');
	
				//if(fromdate != '')
				//{
					//if (ValidateDateTime(obj,sysdate))
					if(isBeforeNow(greg_comparedDate,'DMYHM','en'))
					{

						var error=getMessage("MRDATE1_LT_DATE2",'MR');
						var call_function = document.forms[0].call_function.value;

						if(call_function == 'PREPARE_MEDICAL_BOARD')
						{
							error= error.replace('$',getLabel("Common.PrepareDate.label","Common"));
							error= error.replace('#',getLabel("Common.SystemDate.label","Common"));
							alert(error)
						}
						else if(call_function == 'RECEIVE_MEDICAL_BOARD')
						{
							error= error.replace('$',getLabel("Common.ReceivedDate.label","Common"));
							error= error.replace('#',getLabel("Common.SystemDate.label","Common"));
							alert(error)
						}
						else if(call_function == 'DELIVER_MEDICAL_BOARD')
						{
							error= error.replace('$',getLabel("eMR.DeliveredDate.label","MR"));
							error= error.replace('#',getLabel("Common.SystemDate.label","Common"));
							alert(error)
						}
						else
						{
							if(obj.name == "appln_date")
							{
								error= error.replace('$',getLabel("eMR.ApplicationDate.label","MR"));
								error= error.replace('#',getLabel("Common.SystemDate.label","Common"));
							}
							else
							{
								error= error.replace('$',getLabel("eMR.CollectDate.label","MR"));
								error= error.replace('#',getLabel("Common.SystemDate.label","Common"));
							}
							alert(error)
						}

						//obj.select();
						obj.value="";
						obj.focus();
						//result = "Fail";
						return false;
					}
					else
						return true;
				//}
	}
}

// This Function will check for empty values before calling up the common lookup func..
function BeforePrepGetPractitioner()
{
	if(document.forms[0].prep_pract_desc.value !="")
		getPractID(document.forms[0].prep_pract_id_search);
	else
		document.forms[0].prep_practitioner_id.value ="";
}


function BeforeFwdGetPractitioner()
{
	if(document.forms[0].fwd_pract_desc.value !="")
		getPractID(document.forms[0].fwd_pract_id_search);
	else
		document.forms[0].fwd_practitioner_id.value ="";
}

function BeforeGetPractitioner()
{
	if(document.forms[0].pract_desc.value !="")
		getPractID(document.forms[0].pract_id_search);
	else
		document.forms[0].practitioner_id.value ="";
}

function getPractID(obj)
{
	var practName_FName	= "";
	var practName_FValue= "";
	var practId_FName	= "";

	if(obj.name == 'fwd_pract_id_search')
	{
		var target			= document.forms[0].fwd_pract_desc;
		practId_FName		= document.forms[0].fwd_practitioner_id.name;
	}
	else if(obj.name == 'prep_pract_id_search')
	{
		var target			= document.forms[0].prep_pract_desc;
		practId_FName		= document.forms[0].prep_practitioner_id.name;
	}
	else
	{
		var target			= document.forms[0].pract_desc;
		practId_FName		= document.forms[0].practitioner_id.name;
	}

	practName_FName		= target.name;
	practName_FValue	= target.value;

	var specialty_code ="";
	if(document.forms[0].Splcode)
		specialty_code = document.forms[0].Splcode.value;
	else
		specialty_code = "";

	var facility_id		=   document.forms[0].Facility_Id.value;

	getPractitioner(obj, target,facility_id,"Q2");

	/*
	var sql= "SELECT a.Practitioner_id practitioner_id, a.Practitioner_name practitioner_name,d.desc_sysdef practitioner_type,e.short_desc primary_specialty,DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(b.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_pract_for_facility_vw a, am_practitioner b, am_pract_type d,  am_speciality e WHERE a.operating_facility_id='"+facility_id+"' AND a.practitioner_id = b.practitioner_id AND  b.primary_speciality_code = e.speciality_code AND  b.pract_type = d.pract_type AND b.pract_type LIKE (?)  AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  OR  UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND (b.JOB_TITLE LIKE (?) OR b.JOB_TITLE IS NULL)";

	sql2="SELECT a.Practitioner_id practitioner_id, a.Practitioner_name practitioner_name,d.desc_sysdef practitioner_type,e.short_desc primary_specialty,DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(b.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_pract_for_facility_vw a, am_practitioner b, am_pract_type d,  am_speciality e WHERE a.operating_facility_id='"+facility_id+"' AND a.practitioner_id = b.practitioner_id AND  b.primary_speciality_code = e.speciality_code AND  b.pract_type = d.pract_type AND b.pract_type LIKE (?)  AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  AND  UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND (b.JOB_TITLE LIKE (?) OR b.JOB_TITLE IS NULL)";

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" +practName_FName+ "\"";
	xmlStr += " practName_FValue=\"" +practName_FValue+ "\"";
	xmlStr += " sql=\"" +escape(sql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" +specialty_code+ "\"";
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);	
	*/


} // End of getPractID().

// To be Called by GeneralPractitionerLookup to set the Practitioner.
function PractLookupRetVal(retVal,objName)
{
	if(objName == 'pract_desc')
	{
		var arr;
		if (retVal != null)
		{
			arr=retVal.split("~");
			document.forms[0].practitioner_id.value=arr[0];
			document.forms[0].pract_desc.value=arr[1];
		}
		else
		{
			document.forms[0].practitioner_id.value="";
			document.forms[0].pract_desc.value="";			
		}
	}
	else if(objName == 'prep_pract_desc')
	{
		var arr;
		if (retVal != null)
		{
			arr=retVal.split("~");
			document.forms[0].prep_practitioner_id.value=arr[0];
			document.forms[0].prep_pract_desc.value=arr[1];
		}
		else
		{
			document.forms[0].prep_practitioner_id.value="";
			document.forms[0].prep_pract_desc.value="";			
		}
	}
	else
	{
		var arr;
		if (retVal != null)
		{
			arr=retVal.split("~");
			document.forms[0].fwd_practitioner_id.value=arr[0];
			document.forms[0].fwd_pract_desc.value=arr[1];
		}
		else
		{
			document.forms[0].fwd_practitioner_id.value="";
			document.forms[0].fwd_pract_desc.value="";			
		}
	}
} 

// Function will check for empty values before calling up the common lookup func..
function beforeLookupSearch()
{
	if(document.forms[0].Requestor_desc_hid.value != document.forms[0].requestor_desc.value)
	{
		if(document.forms[0].requestor_desc.value != "")
			 LookupSearch();
	}
}

async function LookupSearch()
{
	var facility_id =  document.forms[0].Facility_Id.value;
	var locale = document.forms[0].locale.value;
	var argumentArray=new Array(8);
	var req_type = document.forms[0].req_type.value;

	title=getLabel("Common.Requestor.label","Common");

	var function_called = document.forms[0].new_func_id.value ;

	/*Modified by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707*/
	if(function_called == 'APP_FOR_MED_BOARD')
	{
		argumentArray[0]=" select requestor_code code, short_name description from MR_REQUESTOR_LANG_VW where LANGUAGE_ID ='"+locale+"' and INDICATOR ='5' and EFF_STATUS like ? and facility_id like ? and upper(REQUESTOR_CODE) like upper(nvl(?,REQUESTOR_CODE)) and upper(short_name) like upper(nvl(?,short_name)) ";
		argumentArray[1]=new Array("INDICATOR","EFF_STATUS","facility_id");
		argumentArray[2]=new Array(req_type,"E",facility_id);
		argumentArray[3]=new Array(STRING,STRING,STRING);
	}
	else
	{
		argumentArray[0]=" select requestor_code code, short_name description from MR_REQUESTOR_LANG_VW where LANGUAGE_ID ='"+locale+"' and INDICATOR ='"+req_type+"' and EFF_STATUS like ? and facility_id like ? and upper(REQUESTOR_CODE) like upper(nvl(?,REQUESTOR_CODE)) and upper(short_name) like upper(nvl(?,short_name)) ";
		argumentArray[1]=new Array("EFF_STATUS","facility_id");
		argumentArray[2]=new Array("E",facility_id);
		argumentArray[3]=new Array(STRING,STRING);
	}
		argumentArray[4]="4,5";
		argumentArray[5]=document.forms[0].requestor_desc.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;
			
	var retVal= await CommonLookup(title,argumentArray);
	
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].Requestor_desc_hid.value	=	arr[0];
		document.forms[0].Requestor_Code.value		=	arr[0];

		document.forms[0].requestor_desc.value		=	arr[1];
		document.forms[0].Requestor_desc_hid.value	= document.forms[0].requestor_desc.value;
		document.forms[0].mode.value = "insert";
		//selectIndicator(arr[0]);
	}
	else
	{
		document.forms[0].Requestor_desc_hid.value	=	"";		
		document.forms[0].requestor_desc.value		=	"";
	}
}

/*Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707*/
function RequestorTypeValueForBoard()
{
		var ReqTypeValue	= document.forms[0].indicator_req.value;
		for(var i=0;i<document.forms[0].req_type.options.length;i++ )
		{
			if(document.forms[0].req_type.options[i].value == ReqTypeValue)
				document.forms[0].req_type.options[i].selected=true;
		}
}

