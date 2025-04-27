
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
	{
		document.forms[0].appl_addr.disabled = true;
	}
	else if(reln_type == '4')//Others
	{
		document.forms[0].appl_addr.disabled = false;

	}
	else if(reln_type == '3') // Self
	{
		document.forms[0].appl_addr.disabled = false;
	}
	else 
	{
		document.forms[0].appl_addr.disabled = false;
	}
}


function enableOtherAltIdText(val) 
			{ // // added by mujafar for ML-MMOH-CRF-0762
			if(val != "")
			{
				
				document.forms[0].contact1_oth_alt_id_no.disabled= false;
				document.forms[0].contact1_oth_alt_id_no.value="";
			}
			else
			{
				document.forms[0].contact1_oth_alt_id_no.value="";
				document.forms[0].contact1_oth_alt_id_no.disabled= true;
			}
		}



function EnDisRelation(obj)
{ 
	
	
	if(document.forms[0].classification_appl_yn.value=="false") // added by mujafar for ML-MMOH-CRF-0762
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
	else
	{ // added by mujafar for ML-MMOH-CRF-0762
		if(obj != '')
		{
			var requestor_type_code = document.forms[0].req_type.value;
			
			var xmlDoc = ""
				var xmlHttp = new XMLHttpRequest()
				xmlStr ="<root><SEARCH requestor_type_code=\""+requestor_type_code+"\"  action='Med_Rec_Req_Detail' /></root>"
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
				xmlHttp.open("POST","../../eMR/jsp/MRIntermediate.jsp",false)
				xmlHttp.send(xmlDoc)
				responseText=xmlHttp.responseText
				responseText = trimString(responseText)
				
				document.forms[0].ret_val1.value ="N~N~N~N~N~N~N~N~N~N~N~N~N~N~N~N~N~N~N~N~N~N~N~N~N";//Modified by Kamatchi S for ML-MMOH-CRF-1464
			
				
					if(responseText != "" && responseText != "null")
					{  
						document.forms[0].req_type_status.value = responseText;
						document.forms[0].appl_addr.disabled=false;
						
						if(responseText == "N")
						{
							document.forms[0].relationship.value		= "";
							document.forms[0].relationship.disabled		= false;
							document.forms[0].relationImg.style.visibility = "visible";
							
							if(document.forms[0].requestor_desc !=null)
							{
								document.forms[0].requestor_desc.value='';
								document.forms[0].hdd_requestor_code.value='';
								document.forms[0].requestor_desc.disabled=true;
								document.forms[0].search_Requestor.disabled=true;
								document.forms[0].requestorImg.style.visibility='hidden';
								
							}
							
							
						
							if(document.forms[0].appl_name != null)
							{document.forms[0].appl_name.value =document.forms[0].next_of_kin_name.value ; 
							document.forms[0].appl_name.disabled = false;}
							
							document.forms[0].contact2_nat_id_no.value=document.forms[0].next_of_kin_nat_id_no.value;
							document.forms[0].contact2_nat_id_no.disabled=false;
							
							
							if(document.forms[0].contact1_oth_alt_id_type && document.forms[0].contact1_oth_alt_id_no)
							{ 
							if(document.forms[0].next_of_kin_alt_id_type.value!="")
							document.forms[0].contact1_oth_alt_id_type.value = document.forms[0].next_of_kin_alt_id_type.value;
							else
							document.forms[0].contact1_oth_alt_id_type.options[0].selected=true;
						
							document.forms[0].contact1_oth_alt_id_no.value = document.forms[0].next_of_kin_alt_id_no.value;
							
							}
							
							if(document.forms[0].relationship)
							{ // added by mujafar for ML-MMOH-CRF-0762
								if(document.forms[0].next_of_kin_relation_code.value!="")
								document.forms[0].relationship.value = document.forms[0].next_of_kin_relation_code.value;
								else
								document.forms[0].relationship.options[0].selected=true;
								
							}
							
							
							document.forms[0].contact1_oth_alt_id_type.disabled=false;
							document.forms[0].contact1_oth_alt_id_no.disabled=false;
							
					
						}
						else if(responseText == "P")
						{
							document.forms[0].relationship.value		= "";
							document.forms[0].relationship.disabled		= true;
							document.forms[0].relationImg.style.visibility = "hidden";
							document.forms[0].contact2_nat_id_no.value=document.forms[0].national_id_no.value;
							document.forms[0].contact2_nat_id_no.disabled=false;
							
							if(document.forms[0].requestor_desc !=null)
							{
								document.forms[0].requestor_desc.value='';
								document.forms[0].hdd_requestor_code.value='';
								document.forms[0].requestor_desc.disabled=true;
								document.forms[0].search_Requestor.disabled=true;
								document.forms[0].requestorImg.style.visibility='hidden';
								
							}
							
							if(document.forms[0].appl_name != null)
								document.forms[0].appl_name.value =document.forms[0].patient_name.value ;
							document.forms[0].appl_name.disabled = false;
							
							if(document.forms[0].contact1_oth_alt_id_type && document.forms[0].contact1_oth_alt_id_no)
							{
							if(document.forms[0].oth_alt_id_type.value!="")
							document.forms[0].contact1_oth_alt_id_type.value = document.forms[0].oth_alt_id_type.value;
							else
							document.forms[0].contact1_oth_alt_id_type.options[0].selected=true;	
							document.forms[0].contact1_oth_alt_id_no.value = document.forms[0].oth_alt_id_no.value;
							
							}
							document.forms[0].contact1_oth_alt_id_type.disabled=false;
							document.forms[0].contact1_oth_alt_id_no.disabled=false;
							
							
						}
						else
						{ 
							document.forms[0].relationship.value		= "";
							document.forms[0].relationship.disabled		= true;
							document.forms[0].relationImg.style.visibility = "hidden";
							
							if(document.forms[0].requestor_desc !=null)
							{
							document.forms[0].requestor_desc.value='';
							document.forms[0].hdd_requestor_code.value='';
							document.forms[0].requestor_desc.disabled=false;
							document.forms[0].search_Requestor.disabled=false;
							document.forms[0].requestorImg.style.visibility='visible';
							
							}
							
							if(document.forms[0].contact2_nat_id_no !=null){
							document.forms[0].contact2_nat_id_no.value="";
							document.forms[0].contact2_nat_id_no.disabled=true;
							}
							
							
							
							if(document.forms[0].contact1_oth_alt_id_type != null && document.forms[0].contact1_oth_alt_id_no != null)
							{
							document.forms[0].contact1_oth_alt_id_type.value = "";
							document.forms[0].contact1_oth_alt_id_no.value = "";
							document.forms[0].contact1_oth_alt_id_type.disabled=true;
							document.forms[0].contact1_oth_alt_id_no.disabled=true;
							}
							
							
							document.forms[0].appl_name.value = '';
							document.forms[0].appl_name.disabled = true;
						
						}
					}
					else
					{  
							document.forms[0].appl_addr.disabled=false;
							if(responseText == "null")
							document.forms[0].req_type_status.value = "";
							
							document.forms[0].appl_name.value = '';
							document.forms[0].appl_name.disabled = true;
							
							document.forms[0].relationship.value		= "";
							document.forms[0].relationship.disabled		= true;
							document.forms[0].relationImg.style.visibility = "hidden";	
							if(document.forms[0].contact2_nat_id_no !=null){
							document.forms[0].contact2_nat_id_no.value="";
							document.forms[0].contact2_nat_id_no.disabled=true;
							}
							if(document.forms[0].requestor_desc !=null)
							{
							document.forms[0].requestor_desc.value='';
							document.forms[0].hdd_requestor_code.value='';
							document.forms[0].requestor_desc.disabled=false;
							document.forms[0].search_Requestor.disabled=false;
							document.forms[0].requestorImg.style.visibility='visible';
							
							}
							
							if(document.forms[0].contact1_oth_alt_id_type != null && document.forms[0].contact1_oth_alt_id_no != null)
							{ 
							document.forms[0].contact1_oth_alt_id_type.value = "";
							document.forms[0].contact1_oth_alt_id_no.value = "";
							document.forms[0].contact1_oth_alt_id_type.disabled=true;
							document.forms[0].contact1_oth_alt_id_no.disabled=true;
							}
							
						
					}
			
					
			
		}
		else
		{ 
							document.forms[0].appl_addr.disabled=true;
							document.forms[0].appl_name.value = '';
							document.forms[0].appl_name.disabled = true;
							
							document.forms[0].relationship.value		= "";
							document.forms[0].relationship.disabled		= true;
							document.forms[0].relationImg.style.visibility = "hidden";	
							if(document.forms[0].contact2_nat_id_no !=null){
							document.forms[0].contact2_nat_id_no.value="";
							document.forms[0].contact2_nat_id_no.disabled=true;
							}
							if(document.forms[0].requestor_desc !=null)
							{
							document.forms[0].requestor_desc.value='';
							document.forms[0].requestor_desc.disabled=false;
							document.forms[0].search_Requestor.disabled=false;
							document.forms[0].requestorImg.style.visibility='hidden';
							
							}
							
							if(document.forms[0].contact1_oth_alt_id_type != null && document.forms[0].contact1_oth_alt_id_no != null)
							{ 
							document.forms[0].contact1_oth_alt_id_type.value = "";
							document.forms[0].contact1_oth_alt_id_no.value = "";
							document.forms[0].contact1_oth_alt_id_type.disabled=true;
							document.forms[0].contact1_oth_alt_id_no.disabled=true;
							}

			
			
		}
		
		
	} // added by mujafar for ML-MMOH-CRF-0762 end
	
}



function enDisRequestor(obj)
{
	if(obj != '')
	{
		document.forms[0].req_type.value="";
		document.forms[0].req_type.disabled=true;

		document.forms[0].Requestor_Code.value="";
		document.forms[0].requestor_desc.value="";
		document.forms[0].requestor_desc.disabled=true;

		document.forms[0].search_Requestor.disabled=true;
	}
	else
	{
		document.forms[0].req_type.value="";
		document.forms[0].req_type.disabled=false;

		document.forms[0].Requestor_Code.value="";
		document.forms[0].requestor_desc.value="";
		document.forms[0].requestor_desc.disabled=false;

		document.forms[0].search_Requestor.disabled=false;
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
		var dialogHeight= "80vh" ;
		var dialogWidth = "80vw" ; //Modified by Ashwini for ML-MMOH-SCF-0670 on 06-Mar-2017
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
			
			retVal = await window.showModalDialog( "../../eMR/jsp/MedRecAddressFrames.jsp?RelationShipType=OtherDeliveryAddress&call_function="+call_function+"&request_id="+request_id+"&other_del_addr_line1="+encodeURIComponent(other_del_addr_line1)+"&other_del_addr_line2="+encodeURIComponent(other_del_addr_line2)+"&other_del_addr_line3="+encodeURIComponent(other_del_addr_line3)+"&other_del_addr_line4="+encodeURIComponent(other_del_addr_line4)+"&other_del_res_town_desc="+encodeURIComponent(other_del_res_town_desc)+"&other_del_res_town_code="+encodeURIComponent(other_del_res_town_code)+"&other_del_res_area_desc="+encodeURIComponent(other_del_res_area_desc)+"&other_del_res_area_code="+encodeURIComponent(other_del_res_area_code)+"&other_del_region_desc="+encodeURIComponent(other_del_region_desc)+"&other_del_region_code="+encodeURIComponent(other_del_region_code)+"&other_del_postal_desc="+encodeURIComponent(other_del_postal_desc)+"&other_del_postal_code="+encodeURIComponent(other_del_postal_code)+"&other_del_country_desc="+encodeURIComponent(other_del_country_desc)+"&other_del_country_code="+encodeURIComponent(other_del_country_code),arguments,features);


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
		
			retVal = await window.showModalDialog( "../../eMR/jsp/MedRecAddressFrames.jsp?RelationShipType=PersonalDeliveryAddress&call_function="+call_function+"&request_id="+request_id+"&personal_del_addr_line1="+encodeURIComponent(personal_del_addr_line1)+"&personal_del_addr_line2="+encodeURIComponent(personal_del_addr_line2)+"&personal_del_addr_line3="+encodeURIComponent(personal_del_addr_line3)+"&personal_del_addr_line4="+encodeURIComponent(personal_del_addr_line4)+"&personal_del_res_town_desc="+encodeURIComponent(personal_del_res_town_desc)+"&personal_del_res_town_code="+encodeURIComponent(personal_del_res_town_code)+"&personal_del_res_area_desc="+encodeURIComponent(personal_del_res_area_desc)+"&personal_del_res_area_code="+encodeURIComponent(personal_del_res_area_code)+"&personal_del_region_desc="+encodeURIComponent(personal_del_region_desc)+"&personal_del_region_code="+encodeURIComponent(personal_del_region_code)+"&personal_del_postal_desc="+encodeURIComponent(personal_del_postal_desc)+"&personal_del_postal_code="+encodeURIComponent(personal_del_postal_code)+"&personal_del_country_desc="+encodeURIComponent(personal_del_country_desc)+"&personal_del_country_code="+encodeURIComponent(personal_del_country_code),arguments,features);

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
		/*Added By Dharma on Apr 13th 2020 against ML-MMOH-CRF-1314 Start*/
		if(document.forms[0].isAcceptRequestByPractAppl.value=="true"){
			document.getElementById("natIDRow").style.display	= 'block';
			document.getElementById("lblDelDateTD").style.display	= 'block';
			document.getElementById("fldDelDateTD").style.display	= 'block';
			document.getElementById("lblDatePostedTD").style.display	= 'none';
			document.getElementById("fldDatePostedTD").style.display	= 'none';
		}
		/*Added By Dharma on Apr 13th 2020 against ML-MMOH-CRF-1314 End*/
		if(document.forms[0].del_nric_no != null)
		{
			document.forms[0].del_nric_no.value = "";
			/*Added By Dharma on Apr 13th 2020 against ML-MMOH-CRF-1314 Start*/
			if(document.forms[0].classification_ind.value=='P'){
				document.forms[0].del_nric_no.value = document.forms[0].national_id_no.value;
			}
			/*Added By Dharma on Apr 13th 2020 against ML-MMOH-CRF-1314 End*/
			document.forms[0].del_nric_no.disabled = false;
		}
		if(document.forms[0].isAcceptRequestByPractAppl.value=="true"){
			document.getElementById("altIDRow").style.display	= 'block';
		}
		document.forms[0].del_oth_alt_type.value = "";
		document.forms[0].del_oth_alt_type.disabled = false;

		document.forms[0].del_oth_alt_id.value = "";
		//document.forms[0].del_oth_alt_id.disabled = false;//Commented By Dharma on Apr 13th 2020 against ML-MMOH-CRF-1314
		
		document.forms[0].posted_date.value = "";
		document.forms[0].posted_date.disabled = true;
		document.getElementById("postImg").disabled = true;

		document.forms[0].address.disabled = false;
		
		document.forms[0].file_no.value = "";
		document.forms[0].file_no.disabled = true;
		/*Added By Dharma on Apr 13th 2020 against ML-MMOH-CRF-1314 Start*/
		if(document.forms[0].isAcceptRequestByPractAppl.value=="true"){
			document.getElementById("postAgeNoRow").style.display = 'none';
		}
		/*Added By Dharma on Apr 13th 2020 against ML-MMOH-CRF-1314 End*/
	}
	else if(mode == 'O')
	{
		/*Added By Dharma on Apr 13th 2020 against ML-MMOH-CRF-1314 Start*/
		if(document.forms[0].isAcceptRequestByPractAppl.value=="true"){
			document.getElementById("lblDelDateTD").style.display	= 'none';
			document.getElementById("fldDelDateTD").style.display	= 'none';
			document.getElementById("lblDatePostedTD").style.display	= 'block';
			document.getElementById("fldDatePostedTD").style.display	= 'block';
		}
		/*Added By Dharma on Apr 13th 2020 against ML-MMOH-CRF-1314 End*/
		
		document.forms[0].report_taken.value = "";
		document.forms[0].report_taken.disabled = true;
		if(document.forms[0].isAcceptRequestByPractAppl.value=="true"){
			document.getElementById("natIDRow").style.display	= 'none';
		}
		
		if(document.forms[0].del_nric_no != null)
		{
			document.forms[0].del_nric_no.value = "";
			document.forms[0].del_nric_no.disabled = true;
		}
		
		document.forms[0].del_oth_alt_type.value = "";
		document.forms[0].del_oth_alt_type.disabled = true;

		document.forms[0].del_oth_alt_id.value = "";
		document.forms[0].del_oth_alt_id.disabled = true;
		/*Added By Dharma on Apr 13th 2020 against ML-MMOH-CRF-1314 Start*/
		if(document.forms[0].isAcceptRequestByPractAppl.value=="true"){
			document.getElementById("altIDRow").style.display	= 'none';
		}
		/*Added By Dharma on Apr 13th 2020 against ML-MMOH-CRF-1314 End*/
		
		document.forms[0].posted_date.value = "";
		document.forms[0].posted_date.disabled = false;
		document.getElementById("postImg").disabled = false;

		document.forms[0].address.disabled = false;
		/*Added By Dharma on Apr 13th 2020 against ML-MMOH-CRF-1314 Start*/
		if(document.forms[0].isAcceptRequestByPractAppl.value=="true"){
			document.getElementById("postAgeNoRow").style.display = 'block';
		}
		/*Added By Dharma on Apr 13th 2020 against ML-MMOH-CRF-1314 End*/
		
		document.forms[0].file_no.value = "";
		document.forms[0].file_no.disabled = false;
	}else
	{
		/*Added By Dharma on Apr 13th 2020 against ML-MMOH-CRF-1314 Start*/
	if(document.forms[0].isAcceptRequestByPractAppl.value=="true"){
		document.getElementById("lblDelDateTD").style.display	= 'none';
		document.getElementById("fldDelDateTD").style.display	= 'none';
		document.getElementById("lblDatePostedTD").style.display	= 'none';
		document.getElementById("fldDatePostedTD").style.display	= 'none';

		document.getElementById("altIDRow").style.display	= 'block';
		document.getElementById("natIDRow").style.display	= 'block';
		document.getElementById("postAgeNoRow").style.display	= 'block';
	}
	/*Added By Dharma on Apr 13th 2020 against ML-MMOH-CRF-1314 End*/
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
	
	
	var request_id		= document.forms[0].reg_no.value;
	var requestor_type	= document.forms[0].req_type.value;
	var requestor_desc	= document.forms[0].requestor_desc.value;
	var requestor_code	= document.forms[0].Requestor_Code.value;
	
	
	if(reln_type == '')
	{
		if(requestor_type != '' && requestor_desc == '')
		{
			var error=getMessage("CAN_NOT_BE_BLANK","Common");
			error= error.replace('$',getLabel("Common.Requestor.label","Common"));
			alert(error);
			return;
		}
	}

	var retVal		= new String();
	var dialogHeight= "90vh" ;
	var dialogWidth = "54vw" ;
	
	/*Below line added for ML-MMOH-CRF-0860.2*/
	if(document.forms[0].increasedaddressLength && document.forms[0].increasedaddressLength.value=="true"){ 
	   dialogHeight= "600px" ;
	  // dialogWidth = "55" ;	
	}	
	//End ML-MMOH-CRF-0860.2
	
	
	var status		= "no";
	var patient_id	= document.forms[0].patientId.value;
	var call_function = document.forms[0].call_function.value;
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

		retVal = await window.showModalDialog( "../../eMR/jsp/MedRecAddressFrames.jsp?RelationShipType=Others&call_function="+call_function+"&reln_type="+reln_type+"&request_id="+request_id+"&patient_id="+patient_id+"&Oth_appl_addr_line1="+encodeURIComponent(Oth_appl_addr_line1)+"&Oth_appl_addr_line2="+encodeURIComponent(Oth_appl_addr_line2)+"&Oth_appl_addr_line3="+encodeURIComponent(Oth_appl_addr_line3)+"&Oth_appl_addr_line4="+encodeURIComponent(Oth_appl_addr_line4)+"&Oth_appl_res_town_desc="+encodeURIComponent(Oth_appl_res_town_desc)+"&Oth_appl_res_town_code="+encodeURIComponent(Oth_appl_res_town_code)+"&Oth_appl_res_area_desc="+encodeURIComponent(Oth_appl_res_area_desc)+"&Oth_appl_res_area_code="+encodeURIComponent(Oth_appl_res_area_code)+"&Oth_appl_region_desc="+encodeURIComponent(Oth_appl_region_desc)+"&Oth_appl_region_code="+encodeURIComponent(Oth_appl_region_code)+"&Oth_appl_postal_desc="+encodeURIComponent(Oth_appl_postal_desc)+"&Oth_appl_postal_code="+encodeURIComponent(Oth_appl_postal_code)+"&Oth_appl_country_desc="+encodeURIComponent(Oth_appl_country_desc)+"&Oth_appl_country_code="+encodeURIComponent(Oth_appl_country_code)+"&other_contact_no1="+encodeURIComponent(other_contact_no1)+"&other_contact_no2="+encodeURIComponent(other_contact_no2)+"&other_appl_email_id="+encodeURIComponent(other_appl_email_id),arguments,features);

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

		retVal = await window.showModalDialog( "../../eMR/jsp/MedRecAddressFrames.jsp?RelationShipType=Self&call_function="+call_function+"&reln_type="+reln_type+"&request_id="+request_id+"&patient_id="+patient_id+"&appl_addr_line1="+encodeURIComponent(appl_addr_line1)+"&appl_addr_line2="+encodeURIComponent(appl_addr_line2)+"&appl_addr_line3="+encodeURIComponent(appl_addr_line3)+"&appl_addr_line4="+encodeURIComponent(appl_addr_line4)+"&appl_res_town_code="+encodeURIComponent(appl_res_town_code)+"&appl_res_town_desc="+encodeURIComponent(appl_res_town_desc)+"&appl_res_area_code="+encodeURIComponent(appl_res_area_code)+"&appl_res_area_desc="+encodeURIComponent(appl_res_area_desc)+"&appl_region_code="+encodeURIComponent(appl_region_code)+"&appl_region_desc="+encodeURIComponent(appl_region_desc)+"&appl_postal_code="+encodeURIComponent(appl_postal_code)+"&appl_postal_desc="+encodeURIComponent(appl_postal_desc)+"&appl_country_desc="+encodeURIComponent(appl_country_desc)+"&appl_country_code="+encodeURIComponent(appl_country_code)+"&self_contact_no1="+encodeURIComponent(self_contact_no1)+"&self_contact_no2="+encodeURIComponent(self_contact_no2)+"&self_appl_email_id="+encodeURIComponent(self_appl_email_id),arguments,features);


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
			document.forms[0].appl_postal_code.value= arr[10];
			document.forms[0].appl_postal_desc.value= arr[11];
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

		retVal =await  window.showModalDialog( "../../eMR/jsp/MedRecAddressFrames.jsp?RelationShipType=NKIN&call_function="+call_function+"&reln_type="+reln_type+"&request_id="+request_id+"&patient_id="+patient_id+"&nkin_addr_line1="+encodeURIComponent(nkin_addr_line1)+"&nkin_addr_line2="+encodeURIComponent(nkin_addr_line2)+"&nkin_addr_line3="+encodeURIComponent(nkin_addr_line3)+"&nkin_addr_line4="+encodeURIComponent(nkin_addr_line4)+"&nkin_res_town_desc="+encodeURIComponent(nkin_res_town_desc)+"&nkin_res_town_code="+encodeURIComponent(nkin_res_town_code)+"&nkin_res_area_desc="+encodeURIComponent(nkin_res_area_desc)+"&nkin_res_area_code="+encodeURIComponent(nkin_res_area_code)+"&nkin_region_desc="+encodeURIComponent(nkin_region_desc)+"&nkin_region_code="+encodeURIComponent(nkin_region_code)+"&nkin_postal_desc="+encodeURIComponent(nkin_postal_desc)+"&nkin_postal_code="+encodeURIComponent(nkin_postal_code)+"&nkin_country_desc="+encodeURIComponent(nkin_country_desc)+"&nkin_country_code="+encodeURIComponent(nkin_country_code)+"&nkin_contact_no1="+encodeURIComponent(nkin_contact_no1)+"&nkin_contact_no2="+encodeURIComponent(nkin_contact_no2)+"&nkin_appl_email_id="+encodeURIComponent(nkin_appl_email_id),arguments,features);


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

		retVal = await window.showModalDialog("../../eMR/jsp/MedRecAddressFrames.jsp?RelationShipType=FTON&call_function="+call_function+"&reln_type="+reln_type+"&request_id="+request_id+"&patient_id="+patient_id+"&fton_addr_line1="+encodeURIComponent(fton_addr_line1)+"&fton_addr_line2="+encodeURIComponent(fton_addr_line2)+"&fton_addr_line3="+encodeURIComponent(fton_addr_line3)+"&fton_addr_line4="+encodeURIComponent(fton_addr_line4)+"&fton_res_town_desc="+encodeURIComponent(fton_res_town_desc)+"&fton_res_town_code="+encodeURIComponent(fton_res_town_code)+"&fton_res_area_desc="+encodeURIComponent(fton_res_area_desc)+"&fton_res_area_code="+encodeURIComponent(fton_res_area_code)+"&fton_region_desc="+encodeURIComponent(fton_region_desc)+"&fton_region_code="+encodeURIComponent(fton_region_code)+"&fton_postal_desc="+encodeURIComponent(fton_postal_desc)+"&fton_postal_code="+encodeURIComponent(fton_postal_code)+"&fton_country_desc="+encodeURIComponent(fton_country_desc)+"&fton_country_code="+encodeURIComponent(fton_country_code)+"&fton_contact_no1="+encodeURIComponent(fton_contact_no1)+"&fton_contact_no2="+encodeURIComponent(fton_contact_no2)+"&fton_appl_email_id="+encodeURIComponent(fton_appl_email_id),arguments,features);


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

		retVal =await window.showModalDialog( "../../eMR/jsp/MedRecAddressFrames.jsp?RelationShipType=EMPLR&call_function="+call_function+"&reln_type="+reln_type+"&request_id="+request_id+"&patient_id="+patient_id+"&emplr_addr_line1="+encodeURIComponent(emplr_addr_line1)+"&emplr_addr_line2="+encodeURIComponent(emplr_addr_line2)+"&emplr_addr_line3="+encodeURIComponent(emplr_addr_line3)+"&emplr_addr_line4="+encodeURIComponent(emplr_addr_line4)+"&emplr_res_town_desc="+encodeURIComponent(emplr_res_town_desc)+"&emplr_res_town_code="+encodeURIComponent(emplr_res_town_code)+"&emplr_res_area_desc="+encodeURIComponent(emplr_res_area_desc)+"&emplr_res_area_code="+encodeURIComponent(emplr_res_area_code)+"&emplr_region_desc="+encodeURIComponent(emplr_region_desc)+"&emplr_region_code="+encodeURIComponent(emplr_region_code)+"&emplr_postal_desc="+encodeURIComponent(emplr_postal_desc)+"&emplr_postal_code="+encodeURIComponent(emplr_postal_code)+"&emplr_country_desc="+encodeURIComponent(emplr_country_desc)+"&emplr_country_code="+encodeURIComponent(emplr_country_code)+"&emplr_contact_no1="+encodeURIComponent(emplr_contact_no1)+"&emplr_contact_no2="+encodeURIComponent(emplr_contact_no2)+"&emplr_appl_email_id="+encodeURIComponent(emplr_appl_email_id),arguments,features);


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

		retVal =await  window.showModalDialog( "../../eMR/jsp/MedRecAddressFrames.jsp?mode="+mode+"&requestor_Type="+requestor_type+"&requestor_code="+requestor_code+"&call_function="+call_function+"&reln_type="+reln_type+"&request_id="+request_id+"&patient_id="+patient_id+"&requestor_addr_line1="+encodeURIComponent(requestor_addr_line1)+"&requestor_addr_line2="+encodeURIComponent(requestor_addr_line2)+"&requestor_addr_line3="+encodeURIComponent(requestor_addr_line3)+"&requestor_addr_line4="+encodeURIComponent(requestor_addr_line4)+"&requestor_res_town_desc="+encodeURIComponent(requestor_res_town_desc)+"&requestor_res_town_code="+encodeURIComponent(requestor_res_town_code)+"&requestor_res_area_desc="+encodeURIComponent(requestor_res_area_desc)+"&requestor_res_area_code="+encodeURIComponent(requestor_res_area_code)+"&requestor_region_desc="+encodeURIComponent(requestor_region_desc)+"&requestor_region_code="+encodeURIComponent(requestor_region_code)+"&requestor_postal_desc="+encodeURIComponent(requestor_postal_desc)+"&requestor_postal_code="+encodeURIComponent(requestor_postal_code)+"&requestor_country_desc="+encodeURIComponent(requestor_country_desc)+"&requestor_country_code="+encodeURIComponent(requestor_country_code)+"&requestor_contact_no1="+encodeURIComponent(requestor_contact_no1)+"&requestor_contact_no2="+encodeURIComponent(requestor_contact_no2)+"&requestor_appl_email_id="+encodeURIComponent(requestor_appl_email_id),arguments,features);

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
			document.forms[0].requestor_postal_code.value= arr[11];
			document.forms[0].requestor_country_desc.value= arr[12];
			document.forms[0].requestor_country_code.value= arr[13];
			
			/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
			document.forms[0].requestor_contact_no1.value= arr[14];
			document.forms[0].requestor_contact_no2.value= arr[15];
			document.forms[0].requestor_appl_email_id.value= arr[16];
			/*ML-MMOH-CRF-0707*/

//			document.forms[0].mode.value="Modify";
		}	
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

		var patientid	= document.forms[0].patientId.value;
		var HTMLVal = " <html><body><form name='dummy_form' id='dummy_form' method='post'  action='../../eMR/jsp/MedRecRequestValidation.jsp' ><input type='hidden' name='popNameFor' id='popNameFor' value='"+popNameFor+"'><input type='hidden' name='Criteria' id='Criteria' value='populateApplName'><input type='hidden' name='patientId' id='patientId' value='"+patientid+"'><input type='hidden' name='relationCode' id='relationCode' value='"+relationship_type+"'></form></body></html>";
		parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[3].document.dummy_form.submit();
	}
	else if(relationship_type == "3")
	{
		document.forms[0].relationship.value = "";
		document.forms[0].relationship.disabled = true;
		document.forms[0].appl_name.value = document.forms[0].patient_name.value;
		document.forms[0].appl_name.disabled = true;
		document.getElementById("relationImg").style.visibility = "hidden";
	}
	else if(relationship_type == "4")
	{
		document.forms[0].relationship.value = "";
		document.forms[0].relationship.disabled = false;
		document.forms[0].appl_name.value = "";
		document.forms[0].appl_name.disabled = false;
		document.getElementById("relationImg").style.visibility = "visible";
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

async function Modal_Contact_Details()
{
	var retVal		= new String();
	var dialogHeight= "80vh" ;
	var dialogWidth = "80vw" ;
	var status		= "no";
	var patient_id	= document.forms[0].patientId.value;
	var concat_address_hidden	= document.forms[0].concat_address_hidden.value;
	var concat_address_hidden= document.forms[0].addr1_type.value+"^^"						+ document.forms[0].addr_line1.value+"^^"											+ document.forms[0].addr_line2.value+"^^"											+ document.forms[0].addr_line3.value+"^^"											+ document.forms[0].addr_line4.value+"^^"											+ document.forms[0].res_town_code.value+"^^"										+ document.forms[0].res_area_code.value+"^^"										+ document.forms[0].postal_code.value+"^^"											+ document.forms[0].region_code.value+"^^"											+ document.forms[0].country_code.value+"^^"
		+ document.forms[0].contact1_name.value+"^^"
		+ document.forms[0].invalid1_yn.value+"^^"
		+ document.forms[0].addr2_type.value+"^^"
		+ document.forms[0].mail_addr_line1.value+"^^"
		+ document.forms[0].mail_addr_line2.value+"^^"
		+ document.forms[0].mail_addr_line3.value+"^^"
		+ document.forms[0].mail_addr_line4.value+"^^"
		+ document.forms[0].mail_res_town_code.value+"^^"
		+ document.forms[0].mail_res_area_code.value+"^^"
		+ document.forms[0].mail_postal_code.value+"^^"
		+ document.forms[0].mail_region_code.value+"^^"
		+ document.forms[0].mail_country_code.value+"^^"
		+ document.forms[0].contact2_name.value+"^^"
		+ document.forms[0].invalid2_yn.value +"^^"
		+ document.forms[0].contact1_no.value+"^^"
		+ document.forms[0].contact2_no.value+"^^"
		+ document.forms[0].email.value+"^^"
		+ document.forms[0].change_address.value +"^^"
		+ document.forms[0].res_town_desc.value +"^^"
		+ document.forms[0].res_area_desc.value +"^^"
		+ document.forms[0].region_desc.value +"^^"
		+ document.forms[0].mail_res_town_desc.value +"^^"
		+ document.forms[0].mail_res_area_desc.value +"^^"
		+ document.forms[0].mail_region_desc.value +"^^" 
		+ document.forms[0].country_desc.value  +"^^"									
		+ document.forms[0].mail_country_desc.value;
	var arguments		= concat_address_hidden;
	var calling_from	= "";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	retVal = await window.showModalDialog( "../../eMP/jsp/ContactDetailsFrame.jsp?patient_id="+patient_id+"&readonly_yn=Y",arguments,features);

	if(retVal != null)
	{
		 document.forms[0].concat_address_hidden.value=retVal;
		 var arr_concat_vals=retVal.split("^^");
		
		 document.forms[0].addr1_type.value			= arr_concat_vals[0];  
		 document.forms[0].addr_line1.value			= arr_concat_vals[1]; 
		 document.forms[0].addr_line2.value			= arr_concat_vals[2]; 
		 document.forms[0].addr_line3.value			= arr_concat_vals[3]; 
		 document.forms[0].addr_line4.value			= arr_concat_vals[4]; 
		 document.forms[0].res_town_code.value		= arr_concat_vals[5]; 
		 document.forms[0].res_area_code.value		= arr_concat_vals[6]; 
		 document.forms[0].postal_code.value		= arr_concat_vals[7]; 
		 document.forms[0].region_code.value		= arr_concat_vals[8]; 
		 document.forms[0].country_code.value		= arr_concat_vals[9]; 
		 document.forms[0].contact1_name.value		= arr_concat_vals[10]; 
		 document.forms[0].invalid1_yn.value		= arr_concat_vals[11]; 
		 document.forms[0].addr2_type.value			= arr_concat_vals[12]; 
		 document.forms[0].mail_addr_line1.value	= arr_concat_vals[13];
		 document.forms[0].mail_addr_line2.value	= arr_concat_vals[14];
		 document.forms[0].mail_addr_line3.value	= arr_concat_vals[15];
		 document.forms[0].mail_addr_line4.value	= arr_concat_vals[16]; 
		 document.forms[0].mail_res_town_code.value	= arr_concat_vals[17]; 
		 document.forms[0].mail_res_area_code.value	= arr_concat_vals[18]; 
		 document.forms[0].mail_postal_code.value   = arr_concat_vals[19]; 
		 document.forms[0].mail_region_code.value	= arr_concat_vals[20]; 
		 document.forms[0].mail_country_code.value	= arr_concat_vals[21]; 
		 document.forms[0].contact2_name.value		= arr_concat_vals[22]; 
		 document.forms[0].invalid2_yn.value		= arr_concat_vals[23]; 
		 document.forms[0].contact1_no.value		= arr_concat_vals[24];
		 document.forms[0].contact2_no.value		= arr_concat_vals[25];
		 document.forms[0].email.value				= arr_concat_vals[26];
		 document.forms[0].change_address.value		= 'Y';
		 document.forms[0].res_town_desc.value		= arr_concat_vals[27];
		 document.forms[0].res_area_desc.value		= arr_concat_vals[28];
		 document.forms[0].region_desc.value		= arr_concat_vals[29];
		 document.forms[0].mail_res_town_desc.value = arr_concat_vals[30];
		 document.forms[0].mail_res_area_desc.value = arr_concat_vals[31];
		 document.forms[0].mail_region_desc.value	= arr_concat_vals[32];
		 document.forms[0].country_desc.value		= arr_concat_vals[33];
		 document.forms[0].mail_country_desc.value	= arr_concat_vals[34];
	}
}



function populateRequestor(req_type)
{
	var HTMLVal = "<html><body><form name='popReq' id='popReq' method='post' action='../../eMR/jsp/MedRecRequestValidation.jsp'><input type='hidden' name='req_type' id='req_type' value='"+req_type+"'><input type='hidden' name='Criteria' id='Criteria' value='populateRequestor'></form></body></html>";
	parent.frames[3].document.write(HTMLVal)
	parent.frames[3].document.popReq.submit();
}



// Added by SRIDHAR R on 22 NOV 2004 for Tabs
// function tab_click - Will Scroll the view between Two Tabs ...
function tab_click(objName)
{
/*

	if(objName == 'requestor_details')
	{
		document.getElementById("tab1").scrollIntoView();
		if(document.forms[0].reg_no && document.forms[0].reg_no.disabled == false)	
			document.forms[0].reg_no.focus();
		else if(document.forms[0].relationship_type && document.forms[0].relationship_type.disabled == false)	
			document.forms[0].relationship_type.focus();
	}
	else if(objName == 'report_details')
	{
		document.getElementById("tab2").scrollIntoView();
		if(document.forms[0].rep_type && document.forms[0].rep_type.disabled == false)	
			document.forms[0].rep_type.focus();
		else if(document.forms[0].delivered_date && document.forms[0].delivered_date.disabled==false)	
			document.forms[0].delivered_date.focus();
	}
	else if(objName == 'other_details')
	{
		document.getElementById("tab3").scrollIntoView();
		document.getElementById("tab3").focus();
	}
*/
}



function validateDate(obj)
{
		var validatevalue	= obj.value
		var prepared		= document.forms[0].hdd_PrepareDate.value;
		var Collect			= document.forms[0].hdd_CollectDate.value;
		var Receive			= document.forms[0].hdd_RecieveDate.value;
		var call_function	= document.forms[0].call_function.value;

	if(validatevalue != '')
	{
			var greg_ReceivedDateTime = convertDate(obj.value,'DMYHM',localeName,'en');
			var error=getMessage("MRDATE1_LT_DATE2",'MR');

			if(call_function == 'RECEIVE_MEDICAL_REPORT')
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
						alert(error);
						obj.value="";
						obj.select();
						obj.focus();
						return;
					}
			}
			
		
			if(call_function == 'DELIVER_MEDICAL_REPORT')
			{
				//if(ValidateDateTime(obj,document.forms[0].hdd_RecieveDate))
				if(isBefore(greg_ReceivedDateTime,document.forms[0].hdd_RecieveDate.value,'DMYHM','en'))
				{
					var err=getMessage("MRDATE1_GTR_DATE2",'MR');
					err= err.replace('$',getLabel("eMR.DeliveredDate.label","MR"));
					err= err.replace('#',getLabel("Common.ReceivedDate.label","Common"));
					alert(err)
					obj.value="";
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
					alert(error);
	//				("Revise date cannot be less than System Date")
					obj.value="";
					obj.select();
					obj.focus();
					return;
				}

				//if(ValidateDateTime(obj,document.forms[0].hdd_CollectDate))
				if(isBefore(greg_ReceivedDateTime,document.forms[0].hdd_CollectDate.value,'DMYHM','en'))
				{
					error= error.replace('$',getLabel("eMR.RevisedDate.label","MR"));
					error= error.replace('#',getLabel("eMR.CollectDate.label","MR"));
					alert(error);
	//				("Revise date cannot be less than Collect Date")
					obj.value="";
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
						alert(error);
						obj.value="";
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
	if(!validDateObj(obj,'DMYHM',localeName))
	{
		obj.value = '';
		//obj.focus();
		return ;
	}
}

function closewindow()
{
	if(document.forms[0].called_from.value=='CA')
	{
		if(document.forms[0].accession_num.value!='')
		{
			document.forms[0].action = "../../servlet/eMR.PrepareReportServlet";
			document.MedicalRecordReqForm.submit();
		}
	}
	else 
		window.close();
}



function chklim(obj,maxSize)	
{
   var len  = obj.value;
	if ( obj.value.length > maxSize )
	{	
		var msg = ""; // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
		 if(obj.name == "remarks_hod")
		  {msg = getMessage("REMARKS_CANNOT_EXCEED",'Common');
			msg= msg.replace("$",getLabel("eMR.HODCoordinatorRemarks.label",'MR'));
			msg = msg.replace("#","200");}
		else if(obj.name == "remarks") 
		{
			msg = getMessage("REMARKS_CANNOT_EXCEED",'Common');
			if(document.forms[0].isAcceptRequestByPractAppl.value == "true")
			msg= msg.replace("$",getLabel("eMR.MRDRemarks.label",'MR'));	
			else
			msg= msg.replace("$",getLabel("Common.remarks.label",'Common'));
		
			msg = msg.replace("#","200");
		}
		else if(obj.name == "remarks_pract") 
		{
			msg = getMessage("REMARKS_CANNOT_EXCEED",'Common');
			msg= msg.replace("$",getLabel("Common.practitioner.label",'Common')+" "+getLabel("Common.remarks.label",'Common'));
			msg = msg.replace("#","200");
		}
		 else
		{msg = getMessage("REQ_DOCS_CANT_XCEED_100_CHARS",'MR');}
	
	alert(msg);
	obj.value="";
	    obj.focus();
	    obj.select();
	}
}


function getMedicalTeamHead(Obj)
{
	if (Obj.value == "")
	{
		document.forms[0].pract_desc.value = "";
	}
	else if(document.forms[0].pract_desc.value == "")
	{
		var teamId		= document.forms[0].team_id.value;
		var HTMLVal = "<html><body><form name='querydept' id='querydept' method='post' action='../../eMR/jsp/MedRecRequestValidation.jsp'><input type='hidden' name='team_id' id='team_id' value='"+teamId+"'><input type='hidden' name='Criteria' id='Criteria' value='populatePractitioner'></form></body></html>";
		parent.frames[3].document.write(HTMLVal)
		parent.frames[3].document.querydept.submit();
	}
}


function PopulateMedicalTeam()
{ 	
	var selected = document.forms[0].team_id;
	while ( selected.options.length > 0 )
		selected.remove(selected.options[0]);
	var	str1	= "" ;
	var	str2	= "----- "+getLabel("Common.defaultSelect.label","Common")+" -----";
	var element = parent.frames[1].document.createElement('OPTION');
	element.text = str2; 
	element.value= str1;
	document.forms[0].team_id.add(element);

	var ippractid		= document.forms[0].practitioner_id.value;
	if(ippractid != '')
	{
		var HTMLVal = "<html><body><form name='querydept' id='querydept' method='post' action='../../eMR/jsp/MedRecRequestValidation.jsp'><input type='hidden' name='ippractid' id='ippractid' value='"+ippractid+"'><input type='hidden' name='Criteria' id='Criteria' value='populateMedicalTeams'></form></body></html>";
		parent.frames[3].document.write(HTMLVal)
		parent.frames[3].document.querydept.submit();
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
	var retVal		   = new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var locale	= document.forms[0].locale.value;
	var isSpecialtyDefaultApp = document.forms[0].isSpecialtyDefaultApp.value;
	
//whereCond Added By Dharma on 2nd Dec 2019 against ML-MMOH-CRF-1454 
	
	var whereCond	= "";
	if(isSpecialtyDefaultApp=="true"){
		whereCond = " and mr_appl_yn='Y' ";
	}
	sql = " Select speciality_code code, short_desc description from AM_SPECIALITY_LANG_VW where LANGUAGE_ID ='"+locale+"' and eff_status like 'E' "+whereCond+" and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) ";
	tit=getLabel("Common.speciality.label","Common");
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
		/*Added By Dharma on 2nd Dec 2019 against ML-MMOH-CRF-1454 Start*/
		if(isSpecialtyDefaultApp=="true"){
			var fieldsToClearArr = new Array();
			fieldsToClearArr.push(document.forms[0].pract_desc);
			fieldsToClearArr.push(document.forms[0].practitioner_id);
			fieldsToClearArr.push(document.forms[0].fwd_hod_desc);
			fieldsToClearArr.push(document.forms[0].fwd_hod_id);
			fieldsToClearArr.push(document.forms[0].medical_team_val);
			fieldsToClearArr.push(document.forms[0].inform_hod_desc);
			fieldsToClearArr.push(document.forms[0].inform_hod_practitioner_id);
			fieldsToClearArr.push(document.forms[0].medical_team_val1);
			fnClearValues(fieldsToClearArr);
		
			if(document.forms[0].call_function.value =="FORWARD_MEDICAL_REPORT" || document.forms[0].call_function.value =="REQUEST_RETURNED" || document.forms[0].call_function.value =="REJECTED_BY_PRACT_TO_MRD"){ //Code modified by Suji Keerthi for ML-MMOH-SCF-1837 //Code modified by Suji Keerthi for PAS-HSA-Medical Records-Medical Report
				Splcode	= document.forms[0].Splcode.value;
				var xmlDoc=""
				var xmlHttp = new XMLHttpRequest()
				xmlStr = "<root><SEARCH Splcode=\""+Splcode+"\" facility_id=\""+facility_id+"\" action='getMedicalTeam' /></root>"
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
				xmlHttp.open("POST","../../eMR/jsp/MRIntermediate.jsp",false)
				xmlHttp.send(xmlDoc)
				responseText = xmlHttp.responseText
				responseText = trimString(responseText)
				
				document.forms[0].medical_team_val.options.length = 0;
				var	str1	= "" ;
				var	str2	= "----- "+getLabel("Common.defaultSelect.label","Common")+" -----";
				var element = parent.frames[1].document.createElement('OPTION');
				element.text = str2; 
				element.value= str1;
				document.forms[0].medical_team_val.add(element);
				if(responseText!=""){
					var retVal_arr = responseText.split("@#");
					for(var i=0;i<retVal_arr.length-1;i++){
						var code_desc_arr = retVal_arr[i].split("|~|");
						element 	= parent.frames[1].document.createElement("OPTION");
						element.value 	= code_desc_arr[0];
						element.text 	= code_desc_arr[1] ;
						element.title	= code_desc_arr[2];
						document.forms[0].medical_team_val.add(element);
					}
				}
				document.forms[0].medical_team_val1.options.length = 0;
				var element = parent.frames[1].document.createElement('OPTION');
				element.text = str2; 
				element.value= str1;
				document.forms[0].medical_team_val1.add(element);
				if(responseText!=""){
					var retVal_arr = responseText.split("@#");
					for(var i=0;i<retVal_arr.length-1;i++){
						var code_desc_arr = retVal_arr[i].split("|~|");
						element 	= parent.frames[1].document.createElement("OPTION");
						element.value 	= code_desc_arr[0];
						element.text 	= code_desc_arr[1] ;
						element.title	= code_desc_arr[2];
						document.forms[0].medical_team_val1.add(element);
					}
				}					
			}
		}
		/*Added By Dharma on 2nd Dec 2019 against ML-MMOH-CRF-1454 End*/
	}
	else
	{
		document.forms[0].dept_spl.value = "";
		document.forms[0].Splcode.value = "";
	}
} // End of getSpecialtyValue.

function fnClearValues(fieldsToClearArr){
	if(fieldsToClearArr.length > 0){
		for(i=0;i<fieldsToClearArr.length;i++){
			if(fieldsToClearArr[i]!=null){
				fieldsToClearArr[i].value	= "";
			}
		}
	}
}

async function searchCode(obj,target)
{
	var retVal = 	new String();
	var dialogHeight= "80vh" ;
	var dialogWidth	= "80vw" ;
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var tit="";
	if(obj.name=="search_spl")
	{
		tit=getLabel("Common.speciality.label","Common");
		sql=" select SPECIALITY_CODE,SHORT_DESC from AM_SPECIALITY order by SHORT_DESC "; 
		search_code="SPECIALITY_CODE";
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

function CompareCollectDate(collect,prepared)
{
	var revised_collect_date = document.forms[0].old_revised_collect_date.value;
	//var revised = document.forms[0].old_revised_collect_date;
	if(prepared.value != '')
	{
		var collectDt	= collect.value;
		//var preparedDt	= prepared.value;
		var preparedDt =  convertDate(prepared.value,'DMYHM',localeName,'en');
		//var result = "Pass";
		if(revised_collect_date != '')
		{
			//if (ValidateDateTime(revised,prepared))
			if(isAfter(preparedDt,revised_collect_date,'DMYHM','en'))
			{
				var error=getMessage("MRDATE1_GT_DATE2",'MR');
				//var call_function = document.forms[0].call_function.value;
				error= error.replace('$',getLabel("Common.PrepareDate.label","Common"));
				error= error.replace('#',getLabel("eMR.RevisedCollectDate.label","MR"));
				alert(error)
	//			("Prepare date should be less than revised collect date...")
				document.forms[0].prepare_date.select();
				document.forms[0].prepare_date.focus();
				//result = "Fail";
			}
		}
		else if(collectDt != '')
		{
			//if (ValidateDateTime(collect,prepared))
			if(isAfter(preparedDt,collectDt,'DMYHM','en'))
			{
				var error=getMessage("MRDATE1_GT_DATE2",'MR');
				//var call_function = document.forms[0].call_function.value;
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
				var greg_prepareDateTime = convertDate(obj.value,'DMYHM',localeName,'en');
				if(isBefore(greg_prepareDateTime,obj2.value,'DMYHM','en'))
				//if(!ValidateDateTime(obj2,obj))
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
		//if(doDateTimeChk(obj))
		if(validDateObj(obj,'DMYHM',localeName))
		{	

			var greg_prepareDateTime = convertDate(obj.value,'DMYHM',localeName,'en');
			
			//if(obj.value!='' && obj2.value!='')
			//{
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
					//obj.focus();	
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

function CompareRegnDate(obj,sysdate)
{
	//var fromdate = obj.value;
	//var result = "Pass";
	//var regndate = sysdate.value
	/*if(obj.value != '' )
	{
		if(!doDateTimeChk(obj))
		{
//			( getMessage("INVALID_DATE_TIME",'SM') );
			obj.focus();
			obj.value = "";
			result = "Fail";
			return ;
		}
	}*/

	if(!validDateObj(obj,'DMYHM',localeName))
	{
		obj.value = "";
		//result = "Fail";
		return false;
	}
	//if(result == "Pass" && fromdate != '')
	else
	{
		var greg_LetterDateTime = convertDate(obj.value,'DMYHM',localeName,'en');
		//if (ValidateDateTime(sysdate,obj))
		if(isAfterNow(greg_LetterDateTime,'DMYHM','en'))
		{
			var error=getMessage("MRDATE1_GT_DATE2",'MR');
			error= error.replace('$',getLabel("eMR.LetterDateTime.label","MR"));
			error= error.replace('#',getLabel("Common.regndatetime.label","Common"));
			alert(error);
			//appln date shud nnot be greater than regn date ...
			obj.select();
			obj.focus();
		}
		return true;
	}
}


function CompareSysDate(obj,sysdate)
{
	//var fromdate = obj.value;
	//var SystemDate = sysdate.value;
	//var result = "Pass";

	/*if(obj.value != '' )
	{
		if(!doDateTimeChk(obj))
		{
//			( getMessage("INVALID_DATE_TIME",'SM') );
			obj.focus();
			obj.value = "";
			result = "Fail";
			return ;
		}
	}*/

	if(!validDateObj(obj,'DMYHM',localeName))
	{
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

				if(call_function == 'PREPARE_MEDICAL_REPORT')
				{
					error= error.replace('$',getLabel("Common.PrepareDate.label","Common"));
					error= error.replace('#',getLabel("Common.SystemDate.label","Common"));
					alert(error)
					//("Prepare date cannot be less than System Date")
				}
				else if(call_function == 'RECEIVE_MEDICAL_REPORT')
				{
					error= error.replace('$',getLabel("Common.ReceivedDate.label","Common"));
					error= error.replace('#',getLabel("Common.SystemDate.label","Common"));
					alert(error)
					//("Receive date cannot be less than System Date")
				}
				else if(call_function == 'DELIVER_MEDICAL_REPORT')
				{
					error= error.replace('$',getLabel("eMR.DeliveredDate.label","MR"));
					error= error.replace('#',getLabel("Common.SystemDate.label","Common"));
					alert(error)
					//("Deliver date cannot be less than System Date")
				}
				else
				{  
					if(obj.name == "appln_date") // added for ML-MMOH-CRF-0704
					{
						error= error.replace('$',getLabel("eMR.ApplicationDate.label","MR"));
						error= error.replace('#',getLabel("Common.SystemDate.label","Common"));
					}
					else if(obj.name == "appln_col_date") // added for ML-MMOH-CRF-0704
					{
						error= error.replace('$',getLabel("eMR.ApplicationCompletionDates.label","MR"));
						error= error.replace('#',getLabel("Common.SystemDate.label","Common"));
					}
					else
					{
						error= error.replace('$',getLabel("eMR.CollectDate.label","MR"));
						error= error.replace('#',getLabel("Common.SystemDate.label","Common"));
					}
					alert(error)
					//("Collect date cannot be less than System Date")
				}

				obj.select();
				//obj.focus();
				//result = "Fail";
				return false;
			}
			else
				return true;
		//}
	}
}


//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// Added by Sridhar on 2 FEB 2004
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
	{getPractID(document.forms[0].fwd_pract_id_search);}
	else
	{    // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
		document.forms[0].fwd_practitioner_id.value ="";
		if(document.forms[0].isAcceptRequestByPractAppl.value=='true' && (document.forms[0].call_function.value =="REJECTED_BY_PRACT_TO_HOD" ||document.forms[0].call_function.value == "FORWARD_TO_HOD" || document.forms[0].call_function.value =="REQUEST_ACCEPTED"))
			{ 
					document.getElementById("practImg1").style.display='none';
					document.getElementById("pracdate").style.display='none';
					document.getElementById("practImg2").style.display='none';
					document.getElementById("pract_assign_date").value="";
				
			}
	}
}
//Maheshwaran K added for ML-MMOH-CRF-0391
function BeforeInformGetPractitioner()
{
	//added by mujafar for ML-MMOH-CRF-0716
	if((document.forms[0].call_function.value =="FORWARD_MEDICAL_REPORT" || document.forms[0].call_function.value =="REJECTED_BY_PRACT_TO_MRD" || document.forms[0].call_function.value =="REQUEST_RETURNED") && document.forms[0].isMedicalTeamApplicable.value == "true")
	{ // modified by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
		if(document.forms[0].inform_hod_desc.value !="")
		{
			getPractID(document.forms[0].inform_hod_pract_id_search);
			if(document.getElementById("medical_team_val1"))document.getElementById("medical_team_val1").options[0].selected=true;
			document.getElementById("medical_team_val1").disabled = true;
		}
		else
		{
			document.forms[0].inform_hod_practitioner_id.value ="";
			document.getElementById("medical_team_val1").disabled = false;
		}
	}
	if((document.forms[0].call_function.value =="FORWARD_TO_HOD" || document.forms[0].call_function.value =="REQUEST_ACCEPTED")  && document.forms[0].isMedicalTeamApplicable.value == "true")
	{ // added by mujafar for ML-MMOH-CRF-1279
		if(document.forms[0].inform_hod_desc2.value !="")
		{
			getPractID(document.forms[0].inform_hod_pract_id_search2);
			if(document.getElementById("medical_team_val2"))document.getElementById("medical_team_val2").options[0].selected=true;
			document.getElementById("medical_team_val2").disabled = true;
		}
		else
		{
			document.forms[0].inform_hod_practitioner_id2.value ="";
			document.getElementById("medical_team_val2").disabled = false;
		}
	}
	else
	{
	
	
		if(document.forms[0].inform_hod_desc.value !="")
			getPractID(document.forms[0].inform_hod_pract_id_search);
		else
			document.forms[0].inform_hod_practitioner_id.value ="";
	
	}
	
	
}
//End
function BeforeGetPractitioner() {
	if(document.forms[0].pract_desc.value !="")
		getPractID(document.forms[0].pract_id_search);
	else
		document.forms[0].practitioner_id.value ="";
}
/*Added By Dharma on Dec 1st 2015 against against ML-MMOH-CRF-0391 [IN:057157] Start*/
function BeforeGetAckHOD() {
	if((document.forms[0].call_function.value =="FORWARD_TO_HOD" || document.forms[0].call_function.value =="REJECTED_BY_PRACT_TO_HOD" )&& document.forms[0].isMedicalTeamApplicable.value == "true")
	{ //added by mujafar for ML-MMOH-CRF-0716
		// modified by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
		if(document.forms[0].ack_hod_co_ord_desc.value !="")
		{
		getPractID(document.forms[0].ack_hod_co_ord_search);
			if(document.getElementById("medical_team_val_ack")){
				document.getElementById("medical_team_val_ack").options[0].selected=true;
				document.getElementById("medical_team_val_ack").disabled = true;
			}
		}
		else{
			document.forms[0].ack_hod_co_ord_id.value ="";
			if(document.getElementById("medical_team_val_ack")){
				document.getElementById("medical_team_val_ack").disabled = false;
			}
		}
		
	}
	else
	if(document.forms[0].call_function.value =="REQUEST_ACCEPTED" && document.forms[0].isMedicalTeamApplicable.value == "true")
	{
		
		if(document.forms[0].ack_hod_co_ord_desc.value !="")
		{
		getPractID(document.forms[0].ack_hod_co_ord_search);
			if(document.getElementById("medical_team_val_ack_1")){
				document.getElementById("medical_team_val_ack_1").options[0].selected=true;
				document.getElementById("medical_team_val_ack_1").disabled = true;
			}
		}
		else
		{
		document.forms[0].ack_hod_co_ord_id.value ="";
			if(document.getElementById("medical_team_val_ack_1")){
				document.getElementById("medical_team_val_ack_1").disabled = false;
			}
		}
		
	}
	
	else
	{
	if(document.forms[0].ack_hod_co_ord_desc.value !="")
		getPractID(document.forms[0].ack_hod_co_ord_search);
	else
		document.forms[0].ack_hod_co_ord_id.value ="";
	}
}
function BeforeFwdGetFwdHod() {

	if((document.forms[0].call_function.value =="FORWARD_MEDICAL_REPORT" || document.forms[0].call_function.value =="REJECTED_BY_PRACT_TO_MRD" || document.forms[0].call_function.value =="REQUEST_RETURNED") && document.forms[0].isMedicalTeamApplicable.value == "true")
	{ //added by mujafar for ML-MMOH-CRF-0716
  // modified by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
		if(document.forms[0].fwd_hod_desc.value !="")
		{
			getPractID(document.forms[0].fwd_hod_id_search);
			if(document.getElementById("medical_team_val"))document.getElementById("medical_team_val").options[0].selected=true;
			document.getElementById("medical_team_val").disabled = true;
		}
		else
		{ 	
		document.forms[0].fwd_hod_id.value ="";
		
		document.getElementById("medical_team_val").disabled = false;
		}
	}
	
	else
	{ 
	
		if(document.forms[0].fwd_hod_desc.value !="")
		getPractID(document.forms[0].fwd_hod_id_search);
		else
		document.forms[0].fwd_hod_id.value ="";
	
	
	
	}
	
		
}

function mrteam_change()
{ //added by mujafar for ML-MMOH-CRF-0716
	if(document.forms[0].call_function.value == "FORWARD_MEDICAL_REPORT" || document.forms[0].call_function.value == "REJECTED_BY_PRACT_TO_MRD" || document.forms[0].call_function.value == "REQUEST_RETURNED")
	{ // modified by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
	if(document.forms[0].medical_team_val)
	{
		if(document.forms[0].medical_team_val.options.value != "")
		{
		document.forms[0].fwd_hod_desc.disabled=true;
		document.forms[0].fwd_hod_id_search.disabled=true;
		}
		else
		{
			document.forms[0].fwd_hod_desc.disabled=false;
		document.forms[0].fwd_hod_id_search.disabled=false;
		}
	}
	
	if(document.forms[0].medical_team_val1)
	{
		if(document.forms[0].medical_team_val1.options.value != "")
		{
		document.forms[0].inform_hod_desc.disabled=true;
		document.forms[0].inform_hod_pract_id_search.disabled=true;
		}
		else
		{
			document.forms[0].inform_hod_desc.disabled=false;
		document.forms[0].inform_hod_pract_id_search.disabled=false;
		}
	}
	}
	if(document.forms[0].call_function.value == "FORWARD_TO_HOD" || document.forms[0].call_function.value == "REJECTED_BY_PRACT_TO_HOD" )
	{ // modified by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
	if(document.forms[0].medical_team_val_ack)
	{
		if(document.forms[0].medical_team_val_ack.options.value != "")
		{
		document.forms[0].ack_hod_co_ord_desc.disabled=true;
		document.forms[0].ack_hod_co_ord_search.disabled=true;
		}
		else
		{
			document.forms[0].ack_hod_co_ord_desc.disabled=false;
		document.forms[0].ack_hod_co_ord_search.disabled=false;
		}
	}
	if(document.forms[0].medical_team_val2)
	{ // added by mujafar for ML-MMOH-CRF-1279
		
		if(document.forms[0].medical_team_val2.options.value != "")
		{
		document.forms[0].inform_hod_desc2.disabled=true;
		document.forms[0].inform_hod_pract_id_search2.disabled=true;
		}
		else
		{
			document.forms[0].inform_hod_desc2.disabled=false;
		document.forms[0].inform_hod_pract_id_search2.disabled=false;
		}
	}
	
	
	}
	
	
	if(document.forms[0].call_function.value == "REQUEST_ACCEPTED" )
	{ 
	if(document.forms[0].medical_team_val_ack_1)
	{
		if(document.forms[0].medical_team_val_ack_1.options.value != "")
		{ 
		document.forms[0].ack_hod_co_ord_desc.disabled=true;
		document.forms[0].ack_hod_co_ord_search.disabled=true;
		}
		else
		{
			document.forms[0].ack_hod_co_ord_desc.disabled=false;
		document.forms[0].ack_hod_co_ord_search.disabled=false;
		}
	}
		if(document.forms[0].medical_team_val2)
	{ // added by mujafar for ML-MMOH-CRF-1279
		
		if(document.forms[0].medical_team_val2.options.value != "")
		{
		document.forms[0].inform_hod_desc2.disabled=true;
		document.forms[0].inform_hod_pract_id_search2.disabled=true;
		}
		else
		{
			document.forms[0].inform_hod_desc2.disabled=false;
		document.forms[0].inform_hod_pract_id_search2.disabled=false;
		}
	}
	
	}
	
	
	
	
	
}


function BeforeInformToPract() {
	
	if(document.forms[0].inform_to_pract_desc.value !="")
		getPractID(document.forms[0].inform_to_pract_search);
	else
		document.forms[0].inform_to_pract_id.value ="";
}

/*Added By Dharma on Dec 1st 2015 against against ML-MMOH-CRF-0391 [IN:057157] End*/

function getPractID(obj)
{ 

	var practName_FName	= "";
	var practName_FValue= "";
	var practId_FName	= "";
	if(obj.name == 'fwd_pract_id_search') {
		var target			= document.forms[0].fwd_pract_desc;
		practId_FName		= document.forms[0].fwd_practitioner_id.name;
	}
	else if(obj.name == 'inform_hod_pract_id_search') { 
		var target			= document.forms[0].inform_hod_desc;
		practId_FName		= document.forms[0].inform_hod_practitioner_id.name;	
	}
	else if(obj.name == 'inform_hod_pract_id_search2') { // added by mujafar for ML-MMOH-CRF-1279
		var target			= document.forms[0].inform_hod_desc2;
		practId_FName		= document.forms[0].inform_hod_practitioner_id2.name;	
	}
	
	else if(obj.name == 'prep_pract_id_search')	{
		var target			= document.forms[0].prep_pract_desc;
		practId_FName		= document.forms[0].prep_practitioner_id.name;
	}else if(obj.name == 'ack_hod_co_ord_search') {
		var target			= document.forms[0].ack_hod_co_ord_desc;
		practId_FName		= document.forms[0].ack_hod_co_ord_id.name;
	}else if(obj.name == 'fwd_hod_id_search') {
		var target			= document.forms[0].fwd_hod_desc;
		practId_FName		= document.forms[0].fwd_hod_id.name;
	}else if(obj.name == 'inform_to_pract_search')	{
		var target			= document.forms[0].inform_to_pract_desc;
		practId_FName		= document.forms[0].inform_to_pract_id.name;
	}else{
		var target			= document.forms[0].pract_desc;
		practId_FName		= document.forms[0].practitioner_id.name;
	}

	practName_FName		= target.name;
	practName_FValue	= target.value;

	var specialty_code  = "";

	if(document.forms[0].Splcode != null)
		specialty_code = document.forms[0].Splcode.value;
	else
		specialty_code  = "";

	var facility_id		= document.forms[0].facility_id.value;
	
	//specialty_code,isSpecialtyDefaultApp Added By Dharma on 9th Dec 2019 aginst ML-MMOH-CRF-1454
	var isSpecialtyDefaultApp = document.forms[0].isSpecialtyDefaultApp.value;
	getPractitioner(obj, target,facility_id,"Q2",specialty_code,isSpecialtyDefaultApp);
	
	if(document.forms[0].isMedicalTeamApplicable.value == "true")
	{ //added by mujafar for ML-MMOH-CRF-0716
		if(obj.name == 'inform_hod_pract_id_search')
		{ 
			if(document.forms[0].inform_hod_desc.value != "")
			{
				if(document.getElementById("medical_team_val1"))
				{document.getElementById("medical_team_val1").options[0].selected=true;
				document.getElementById("medical_team_val1").disabled = true;
				}
			}
			else
			{
				if(document.getElementById("medical_team_val1"))
				{document.getElementById("medical_team_val1").options[0].selected=true;
				document.getElementById("medical_team_val1").disabled = false;
				}
			}
		}
		else
		if(obj.name == 'inform_hod_pract_id_search2')
		{ // added by mujafar for ML-MMOH-CRF-1279
			if(document.forms[0].inform_hod_desc2.value != "")
			{
				if(document.getElementById("medical_team_val2"))
				{document.getElementById("medical_team_val2").options[0].selected=true;
				document.getElementById("medical_team_val2").disabled = true;
				}
			}
			else
			{
				if(document.getElementById("medical_team_val2"))
				{document.getElementById("medical_team_val2").options[0].selected=true;
				document.getElementById("medical_team_val2").disabled = false;
				}
			}
		}
		else
		if(obj.name == 'fwd_hod_id_search') 
		{
			
			if(document.forms[0].fwd_hod_desc.value != "")
			{
				if(document.getElementById("medical_team_val"))
				{document.getElementById("medical_team_val").options[0].selected=true;
				document.getElementById("medical_team_val").disabled = true;
				}
			}
			else
			{ 
				if(document.getElementById("medical_team_val"))
				{document.getElementById("medical_team_val").options[0].selected=true;
				document.getElementById("medical_team_val").disabled = false;
				}
			}
		
		}
		else
		if(obj.name == 'ack_hod_co_ord_search') { //ack_hod_co_ord_desc
			
			if(document.forms[0].ack_hod_co_ord_desc.value != "")
			{
				if(document.getElementById("medical_team_val_ack")){
					document.getElementById("medical_team_val_ack").options[0].selected=true;
					document.getElementById("medical_team_val_ack").disabled = true;
				}
			}
			else
			{ 
				if(document.getElementById("medical_team_val_ack")){
					document.getElementById("medical_team_val_ack").options[0].selected=true;
					document.getElementById("medical_team_val_ack").disabled = false;
				}
			}
		}



	}

/*

	var sql= "SELECT a.Practitioner_id practitioner_id, a.Practitioner_name practitioner_name,d.desc_sysdef practitioner_type,e.short_desc primary_specialty,DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(b.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_pract_for_facility_vw a, am_practitioner b, am_pract_type d,  am_speciality e WHERE a.operating_facility_id='"+facility_id+"' AND a.practitioner_id = b.practitioner_id AND  b.primary_speciality_code = e.speciality_code AND  b.pract_type = d.pract_type AND b.pract_type LIKE (?)  AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  OR  UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND (b.JOB_TITLE LIKE (?) OR b.JOB_TITLE IS NULL)";


	sql2="SELECT a.Practitioner_id practitioner_id, a.Practitioner_name practitioner_name,d.desc_sysdef practitioner_type,e.short_desc primary_specialty,DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(b.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_pract_for_facility_vw a, am_practitioner b, am_pract_type d,  am_speciality e WHERE a.operating_facility_id='"+facility_id+"' AND a.practitioner_id = b.practitioner_id AND  b.primary_speciality_code = e.speciality_code AND  b.pract_type = d.pract_type AND b.pract_type LIKE (?)  AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  AND  UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND (b.JOB_TITLE LIKE (?) OR b.JOB_TITLE IS NULL)";

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" +practName_FName + "\"";
	xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue) + "\"";
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
	else if(objName == 'inform_hod_desc2')
	{ // added by mujafar for ML-MMOH-CRF-1279
		var arr;
		if (retVal != null)
		{
			arr=retVal.split("~");
			document.forms[0].inform_hod_practitioner_id2.value=arr[0];
			document.forms[0].inform_hod_desc2.value=arr[1];
		}
		else
		{
			document.forms[0].inform_hod_practitioner_id2.value="";
			document.forms[0].inform_hod_desc2.value="";			
		}
	}
	else if(objName == 'inform_hod_desc')//Maheshwaran added this condition for ML-MMOH-CRF-0391
	{
		var arr;
		if (retVal != null)
		{
			arr=retVal.split("~");
			document.forms[0].inform_hod_practitioner_id.value=arr[0];
			document.forms[0].inform_hod_desc.value=arr[1];
		}
		else
		{
			document.forms[0].inform_hod_practitioner_id.value="";
			document.forms[0].inform_hod_desc.value="";			
		}
	}
	else if(objName == 'ack_hod_co_ord_desc')
	{
		var arr;
		if (retVal != null)
		{
			arr=retVal.split("~");
			document.forms[0].ack_hod_co_ord_id.value=arr[0];
			document.forms[0].ack_hod_co_ord_desc.value=arr[1];
		}
		else
		{
			document.forms[0].ack_hod_co_ord_id.value="";
			document.forms[0].ack_hod_co_ord_desc.value="";			
		}
	}
	else if(objName == 'inform_to_pract_desc')
	{
		var arr;
		if (retVal != null)
		{
			arr=retVal.split("~");
			document.forms[0].inform_to_pract_id.value=arr[0];
			document.forms[0].inform_to_pract_desc.value=arr[1];
		}
		else
		{
			document.forms[0].inform_to_pract_id.value="";
			document.forms[0].inform_to_pract_desc.value="";			
		}
	}
	else if(objName == 'fwd_hod_desc')
	{
		var arr;
		if (retVal != null)
		{
			arr=retVal.split("~");
			document.forms[0].fwd_hod_id.value=arr[0];
			document.forms[0].fwd_hod_desc.value=arr[1];
		}
		else
		{
			document.forms[0].fwd_hod_id.value="";
			document.forms[0].fwd_hod_desc.value="";			
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
			
			if(document.forms[0].isAcceptRequestByPractAppl.value=='true' && (document.forms[0].call_function.value =="FORWARD_TO_HOD" || document.forms[0].call_function.value =="REJECTED_BY_PRACT_TO_HOD"  ||document.forms[0].call_function.value =="REQUEST_ACCEPTED"))
			{ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
					document.getElementById("practImg1").style.display='inline';
					document.getElementById("pracdate").style.display='inline';
					document.getElementById("practImg2").style.display='inline';
					var pract_assign_date1 = fnGetRegistrationDateTime();
					document.getElementById("pract_ass_date").innerHTML = pract_assign_date1;
					document.getElementById("pract_assign_date").value=pract_assign_date1;
					
			}
		}
		else
		{
			document.forms[0].fwd_practitioner_id.value="";
			document.forms[0].fwd_pract_desc.value="";	

if(document.forms[0].isAcceptRequestByPractAppl.value=='true' && (document.forms[0].call_function.value =="FORWARD_TO_HOD" || document.forms[0].call_function.value =="REJECTED_BY_PRACT_TO_HOD"  ||document.forms[0].call_function.value =="REQUEST_ACCEPTED"))
{ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
					document.getElementById("practImg1").style.display='none';
					document.getElementById("pracdate").style.display='none';
					document.getElementById("practImg2").style.display='none';
					document.getElementById("pract_assign_date").value="";
					}
		}
	}
} 



function fnGetRegistrationDateTime(){ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
	
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH  action='getSysDateTime' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eMR/jsp/MRIntermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		return responseText
	
}







//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// Added by Sridhar on 5 APR 2004
// Function will check for empty values before calling up the common lookup func..

function beforeLookupSearch()
{
	if(document.forms[0].Requestor_desc_hid.value != document.forms[0].requestor_desc.value)
	{
		if(document.forms[0].requestor_desc.value != "")
			 LookupSearch();
	}
}

/* Modified to CommonLookup on 06/02/04 by Sridhar */
async function LookupSearch()
{
	var facility_id = document.forms[0].facility_id.value;
	var argumentArray=new Array(8);
	var req_type = document.forms[0].req_type.value;
	var locale = document.forms[0].locale.value;
	var title = getLabel("Common.Requestor.label","Common");;
	var isRequestorAddrDispApp = document.forms[0].isRequestorAddrDispApp.value;//Added By Dharma on 13t Dec 2019 against ML-MMOH-CRF-1362
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
		argumentArray[0]=" select requestor_code code, short_name description,ADDR_LINE1 ADDR_LINE1 from MR_REQUESTOR_LANG_VW where LANGUAGE_ID ='"+locale+"' and INDICATOR ='"+req_type+"' and EFF_STATUS like ? and facility_id like ? and upper(REQUESTOR_CODE) like upper(nvl(?,REQUESTOR_CODE)) and upper(short_name) like upper(nvl(?,short_name)) ";
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

		 var arr=ret1.split(",");

			if(arr[1]==undefined) 

			{

				arr[0]="";	

				arr[1]="";	

			}

		document.forms[0].Requestor_desc_hid.value	=	arr[0];
		document.forms[0].Requestor_Code.value		=	arr[0];
		document.forms[0].hdd_requestor_code.value  =   arr[0]; // added by mujafar for ML-MMOH-CRF-0762
		document.forms[0].requestor_desc.value		=	arr[1];
		
		document.forms[0].Requestor_desc_hid.value	= document.forms[0].requestor_desc.value;
		document.forms[0].mode.value				= "insert";
//		selectIndicator(arr[0]);
		/*Added By Dharma on 13t Dec 2019 against ML-MMOH-CRF-1362 Start*/
		if(isRequestorAddrDispApp=="true"){
			fnDisplayRequestorAddr(arr[0]);
		}
		/*Added By Dharma on 13t Dec 2019 against ML-MMOH-CRF-1362 End*/
	}
	else
	{
		document.forms[0].Requestor_desc_hid.value	= "";		
		document.forms[0].requestor_desc.value		= "";
		document.forms[0].mode.value				= "modify";
	}
}

// below function added by mujafar for ML-MMOH-CRF-0718
function getSelfPractitioner(loginID)
{ 
	if(loginID!="")
			{
				
				var xmlDoc = ""
				var xmlHttp = new XMLHttpRequest()
				xmlStr ="<root><SEARCH loginID=\""+loginID+"\"  action='Self_Prepare_Fwd_Practitioner' /></root>"
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
				xmlHttp.open("POST","../../eMR/jsp/MRIntermediate.jsp",false)
				xmlHttp.send(xmlDoc)
				responseText=xmlHttp.responseText
				responseText = trimString(responseText)
				var fields="";
				var pract_ID="";
				var pract_name="";
				if(responseText!="")
				{
					fields=responseText.split("~~");
					pract_ID = fields[0];
					pract_name=fields[1];
				}
				
				if(responseText!="")
				{
					document.forms[0].fwd_pract_desc.value=pract_name;
					document.forms[0].fwd_pract_desc.disabled = true;
					document.forms[0].fwd_pract_id_search.disabled=true;
					document.forms[0].fwd_practitioner_id.value=pract_ID;
					
					if(document.forms[0].isAcceptRequestByPractAppl.value=="true")
					{ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
					document.getElementById("practImg1").style.display='inline';
					document.getElementById("pracdate").style.display='inline';
					document.getElementById("practImg2").style.display='inline';
					
					var pract_assign_date1 = fnGetRegistrationDateTime();
					document.getElementById("pract_ass_date").innerHTML = pract_assign_date1;
					document.getElementById("pract_assign_date").value=pract_assign_date1;
					}
			
					
				}
				else
				{ 
					alert(getLabel("eMR.SelectAcceptReject.label","mr"));
					document.forms[0].status.value = "A";
				}
				
				
		
				
			}
	
	
}
// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316 start
function check_pract_status()
{
var prac_status=document.forms[0].prac_status.value;
var call_function = document.forms[0].call_function.value;	
var SystemDate_display = document.forms[0].SystemDate_display.value;
var called_from = document.forms[0].called_from.value;


if(call_function == "PREPARE_MEDICAL_REPORT" || call_function == "ACCEPTED_BY_PRACTITIONER" )
{

if(prac_status == "RM")
{
if(called_from == "CA")
parent.frames[4].document.getElementById("savedraft").disabled=true;
document.getElementById("Prep").style.display='none';
document.getElementById("Returnb").style.display='none';
document.getElementById("Rejec").style.display='inline';	


document.getElementById("prep_date1").style.display='inline';
document.getElementById("prep_date").style.display='none';
document.getElementById("prep_date2").style.display='none';
document.getElementById("prep_date3").style.display='none';
document.getElementById("prep_date4").style.display='inline';

document.getElementById("Prep1").style.display='none';
document.getElementById("Returnb1").style.display='none';
document.getElementById("Rejec1").style.display='inline';	
document.getElementById("prepare_date_Img").style.display='none';	
document.getElementById("prepare_date").value='';	
//document.getElementById("reject_medical_rep_reason_1").value='';
rejectReturnReason("RM");
	
	
}
else if(prac_status == "RH")
{ 
if(called_from == "CA")
parent.frames[4].document.getElementById("savedraft").disabled=true;
document.getElementById("Rejec").style.display='none';
document.getElementById("Returnb").style.display='inline';
document.getElementById("Prep").style.display='none';	

document.getElementById("prep_date1").style.display='none';
document.getElementById("prep_date").style.display='none';
document.getElementById("prep_date2").style.display='inline';
document.getElementById("prep_date3").style.display='none';
document.getElementById("prep_date4").style.display='inline';


document.getElementById("Rejec1").style.display='none';
document.getElementById("Returnb1").style.display='inline';
document.getElementById("Prep1").style.display='none';	
document.getElementById("prepare_date_Img").style.display='none';		
document.getElementById("prepare_date").value='';		
//document.getElementById("reject_medical_rep_reason_1").value='';
rejectReturnReason("RH");
	
	
}
else
{

if(called_from == "CA" )
parent.frames[4].document.getElementById("savedraft").disabled=false;
document.getElementById("Prep").style.display='inline';	
document.getElementById("Returnb").style.display='none';	
document.getElementById("Rejec").style.display='none';

document.getElementById("prep_date1").style.display='none';
document.getElementById("prep_date").style.display='inline';
document.getElementById("prep_date3").style.display='inline';
document.getElementById("prep_date4").style.display='none';

document.getElementById("prep_date2").style.display='none';

document.getElementById("Prep1").style.display='inline';	
document.getElementById("Returnb1").style.display='none';	
document.getElementById("Rejec1").style.display='none';	
document.getElementById("prepare_date_Img").style.display='inline';
document.getElementById("prepare_date").value=SystemDate_display;			
}
}		
}
/*Added By Dharma on 4th Mar 2020 against ML-MMOH-CRF-1473 Start*/
function rejectReturnReason(practStatus){
	var reason	= "";
	if(practStatus=="RM"){
		reason = "rejectToMRDbyPract";
	}else if(practStatus=="RH"){
		reason = "returnToHODbyPract";
	}
	var xmlDoc=""
	var xmlHttp = new XMLHttpRequest()
	xmlStr = "<root><SEARCH  action='getMRReason' reason=\""+reason+"\" /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eMR/jsp/MRIntermediate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText = xmlHttp.responseText
	responseText = trimString(responseText)

	document.forms[0].reject_medical_rep_reason_1.options.length = 0;
	var	str1	= "" ;
	var	str2	= "----- "+getLabel("Common.defaultSelect.label","Common")+" -----";
	var element = parent.frames[1].document.createElement('OPTION');
	element.text = str2; 
	element.value= str1;
	document.forms[0].reject_medical_rep_reason_1.add(element);
	if(responseText!=""){
		var retVal_arr = responseText.split("@#");
		for(var i=0;i<retVal_arr.length-1;i++){
			var code_desc_arr = retVal_arr[i].split("~");
			element 	= parent.frames[1].document.createElement("OPTION");
			element.value 	= code_desc_arr[0];
			element.text 	= code_desc_arr[1] ;
			document.forms[0].reject_medical_rep_reason_1.add(element);
		}
	}

	
}
/*Added By Dharma on 4th Mar 2020 against ML-MMOH-CRF-1473 End*/

function check_status1()
{
	var status=document.forms[0].status.value;
	var isRejectRequestApplicable = document.forms[0].isRejectRequestApplicable.value; // added by mujafar for ML-MMOH-CRF-0713
	var isSelfStatusMRPApplicable = document.forms[0].isSelfStatusMRPApplicable.value; // added by mujafar for ML-MMOH-CRF-0718
	var isMedicalTeamApplicable = document.forms[0].isMedicalTeamApplicable.value; // added by mujafar for ML-MMOH-CRF-0716
	var call_function = document.forms[0].call_function.value;
	var isAcceptRequestByPractAppl = document.forms[0].isAcceptRequestByPractAppl.value;  // added by mujafar for ML-MMOH-CRF-1316
	
	
	
	if(call_function == "FORWARD_TO_HOD" || call_function == "REJECTED_BY_PRACT_TO_HOD" ) 
	{	
	if(status == "R") {
		document.getElementById("collectImg5").style.display='inline';
		document.getElementById("collectImg6").style.display='inline'; 
		document.getElementById("acc").style.display='none';
		document.getElementById("rej").style.display='inline'; 
		if(isRejectRequestApplicable=="true" && document.forms[0].call_function && (call_function == "FORWARD_TO_HOD" || call_function == "REJECTED_BY_PRACT_TO_HOD" )){
		document.getElementById("accept1").style.display='inline'; 
		document.getElementById("asnpract").style.display='none'; 
		document.getElementById("reject_reason_1").style.display='inline';
		document.getElementById("accept2").style.display='none';  
		document.getElementById("reject_medrep_reason_desc").style.display='inline';
		document.getElementById("reject_medical_rep_reason").options.value="";
		document.getElementById("reject_medical_rep_reason").style.visibility = "visible"; 
		document.getElementById("reject_medical_rep_reason_img").style.visibility = "visible";
		document.getElementById("reject_by_1").style.display='inline';
		document.getElementById("reject_by_2").style.display='inline'; 
		document.getElementById("practImg1").style.display='none';
		document.getElementById("practImg2").style.display='none';
		document.getElementById("pract_assign_date").value="";
		
		}
			
		document.forms[0].fwd_pract_desc.disabled = true;
		document.forms[0].fwd_pract_id_search.disabled=true;
		document.forms[0].ack_hod_co_ord_desc.disabled = true;
		document.forms[0].ack_hod_co_ord_search.disabled=true;
		
		document.forms[0].inform_hod_desc2.disabled=true; // added by mujafar for ML-MMOH-CRF-1279
		document.forms[0].inform_hod_pract_id_search2.disabled=true;
		
		if(isMedicalTeamApplicable == "true") {
			if(document.forms[0].medical_team_val_ack){
			
				document.forms[0].medical_team_val_ack.value="";
				document.getElementById("medical_team_val_ack").disabled = true;
			}
			
			document.forms[0].medical_team_val2.value=""; // added by mujafar for ML-MMOH-CRF-1279
			document.getElementById("medical_team_val2").disabled = true;
		
		}
		document.forms[0].inform_to_pract_desc.disabled = true;
		document.forms[0].inform_to_pract_search.disabled=true;
		
	
		if(document.forms[0].call_function && (document.forms[0].call_function.value=="FORWARD_TO_HOD" || document.forms[0].call_function.value=="REJECTED_BY_PRACT_TO_HOD" )){
		   if(document.getElementById("acknow_coordinator_img"))document.getElementById("acknow_coordinator_img").style.visibility = "hidden";	
		   if(document.getElementById("informtopract_img"))document.getElementById("informtopract_img").style.visibility = "hidden";
		}
		
		
		document.forms[0].fwd_pract_desc.value = "";
		document.forms[0].fwd_practitioner_id.value = "";
		document.forms[0].ack_hod_co_ord_desc.value = "";
		document.forms[0].ack_hod_co_ord_id.value = "";
		document.forms[0].inform_to_pract_desc.value = "";
		document.forms[0].inform_to_pract_id.value = "";
		
		document.forms[0].inform_hod_practitioner_id2.value = ""; // added by mujafar for ML-MMOH-CRF-1279
		
		
	
	}else if(status == "A" || status =="S" ){  // modified by mujafar for ML-MMOH-CRF-0718
		if(isRejectRequestApplicable=="true" && (document.forms[0].call_function.value=="FORWARD_TO_HOD" || document.forms[0].call_function.value=="REJECTED_BY_PRACT_TO_HOD" )){ 
		
		document.getElementById("collectImg5").style.display='inline';
		document.getElementById("collectImg6").style.display='inline'; 
		document.getElementById("acc").style.display='inline';
		document.getElementById("rej").style.display='none'; 
		
		document.getElementById("accept1").style.display='inline'; 
		document.getElementById("asnpract").style.display='inline'; 
		document.getElementById("reject_reason_1").style.display='none';
		document.getElementById("accept2").style.display='inline'; 
		document.getElementById("reject_medrep_reason_desc").style.display='none'; 
		document.getElementById("reject_by_1").style.display='none';
		document.getElementById("reject_by_2").style.display='none'; 
		document.getElementById("practImg1").style.display='inline';
		
		
		
		}
		
		document.getElementById("acc").style.display='inline';
		document.getElementById("rej").style.display='none';
		document.forms[0].img_remarks.style.visibility = "Hidden";//Added by Ashwini for ML-MMOH-SCF-0667 on 06-Mar-2017
		document.forms[0].fwd_pract_desc.disabled = false;
		document.forms[0].fwd_pract_id_search.disabled=false;
		document.forms[0].ack_hod_co_ord_desc.disabled = false;
		document.forms[0].ack_hod_co_ord_search.disabled=false;
		
			document.forms[0].inform_hod_desc2.disabled = false; // added by mujafar for ML-MMOH-CRF-1279
			document.forms[0].inform_hod_pract_id_search2.disabled=false;
			 
		
			if(document.forms[0].medical_team_val_ack && isMedicalTeamApplicable == "true")
			{  
			if(document.forms[0].medical_team_val_ack.value == "" && document.forms[0].ack_hod_co_ord_desc.value != "")
			{
			document.getElementById("medical_team_val_ack").disabled = true;
			document.forms[0].ack_hod_co_ord_desc.disabled = false;
			document.forms[0].ack_hod_co_ord_search.disabled=false;
			
			}
			else
			if(document.forms[0].medical_team_val_ack.value != "" && document.forms[0].ack_hod_co_ord_desc.value == "")
			{
				document.forms[0].ack_hod_co_ord_desc.disabled = true;
				document.forms[0].ack_hod_co_ord_search.disabled=true;
				document.getElementById("medical_team_val_ack").disabled = false;
			}
			else
			{
				document.getElementById("medical_team_val_ack").disabled = false;
			}
			}
			
			
			
			if(document.forms[0].medical_team_val2 && isMedicalTeamApplicable == "true")
			{   // added by mujafar for ML-MMOH-CRF-1279
			if(document.forms[0].medical_team_val2.value == "" && document.forms[0].inform_hod_desc2.value != "")
			{
			document.getElementById("medical_team_val2").disabled = true;
			document.forms[0].inform_hod_desc2.disabled = false;
			document.forms[0].inform_hod_pract_id_search2.disabled=false;
			
			}
			else
			if(document.forms[0].medical_team_val2.value != "" && document.forms[0].inform_hod_desc2.value == "")
			{
				document.forms[0].inform_hod_desc2.disabled = true;
				document.forms[0].inform_hod_pract_id_search2.disabled=true;
				document.getElementById("medical_team_val2").disabled = false;
			}
			else
			{
				document.getElementById("medical_team_val2").disabled = false;
			}
			}
				
	
		
		document.forms[0].inform_to_pract_desc.disabled = false;
		document.forms[0].inform_to_pract_search.disabled=false;
		
		
		if(document.forms[0].call_function && (document.forms[0].call_function.value=="FORWARD_TO_HOD" || document.forms[0].call_function.value=="REJECTED_BY_PRACT_TO_HOD" )){
		    if(document.getElementById("acknow_coordinator_img"))document.getElementById("acknow_coordinator_img").style.visibility = "visible";	
		    if(document.getElementById("informtopract_img"))document.getElementById("informtopract_img").style.visibility = "visible";
		}
		if(status=="A" && isSelfStatusMRPApplicable == "true")
		{ 
			document.forms[0].fwd_pract_desc.value = "";
			
			document.getElementById("practImg1").style.display='none';
			document.getElementById("pracdate").style.display='none';
			document.getElementById("practImg2").style.display='none';
			document.getElementById("pract_assign_date").value="";
			
		}
		if(status =="S" && isSelfStatusMRPApplicable == "true")
		{ 
			var loginID=document.forms[0].loginUserID.value;
			if(loginID!="")
			getSelfPractitioner(loginID);
		}
		
	
	}
	}
	
	
}
// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316 end
function check_status() {

	var status=document.forms[0].status.value;
	var isRejectRequestApplicable = document.forms[0].isRejectRequestApplicable.value; // added by mujafar for ML-MMOH-CRF-0713
	var isSelfStatusMRPApplicable = document.forms[0].isSelfStatusMRPApplicable.value; // added by mujafar for ML-MMOH-CRF-0718
	var isMedicalTeamApplicable = document.forms[0].isMedicalTeamApplicable.value; // added by mujafar for ML-MMOH-CRF-0716
	var call_function = document.forms[0].call_function.value;
	var isAcceptRequestByPractAppl = document.forms[0].isAcceptRequestByPractAppl.value;  // added by mujafar for ML-MMOH-CRF-1316
	// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
	if(call_function == "FORWARD_TO_HOD") // added by mujafar for ML-MMOH-CRF-0714
	{	
	if(status == "R") {
		document.getElementById("collectImg5").style.display='inline';
		document.getElementById("collectImg6").style.display='inline'; 
		document.getElementById("acc").style.display='none';
		document.getElementById("rej").style.display='inline'; 
		
		if(isRejectRequestApplicable=="true" && document.forms[0].call_function && call_function == "FORWARD_TO_HOD"){ // added by mujafar for ML-MMOH-CRF-0713
		document.getElementById("collectImg5").style.display='none';
		document.getElementById("collectImg6").style.display='none'; 
		document.getElementById("collectImg7").style.display='inline';
		document.getElementById("collectImg8").style.display='inline';
		document.getElementById("acc").style.display='none';
		document.getElementById("rej").style.display='none';
		document.getElementById("reject_by_1").style.display='inline';
		document.getElementById("reject_by_2").style.display='inline';
		document.getElementById("reject_on_1").style.display='inline';
		document.getElementById("reject_on_2").style.display='inline';
		document.getElementById("reject_reason_1").style.display='inline';
		document.getElementById("reject_medrep_reason_desc").style.display='inline';
		document.getElementById("reject_medical_rep_reason").options.value="";
		document.getElementById("reject_medical_rep_reason").style.visibility = "visible"; 
		document.getElementById("reject_medical_rep_reason_img").style.visibility = "visible";
		if(isAcceptRequestByPractAppl == 'true')
		{ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
			document.getElementById("accept1").style.display='none';
			document.getElementById("accept2").style.display='none';			
		}
		}
		document.forms[0].img_remarks.style.visibility = "visible"; //Added by Ashwini for ML-MMOH-SCF-0667 on 06-Mar-2017
		document.forms[0].fwd_pract_desc.disabled = true;
		document.forms[0].fwd_pract_id_search.disabled=true;
		document.forms[0].ack_hod_co_ord_desc.disabled = true;
		document.forms[0].ack_hod_co_ord_search.disabled=true;
		if(isMedicalTeamApplicable == "true") //added by mujafar for ML-MMOH-CRF-0716
		{
			if(document.forms[0].medical_team_val_ack){
				document.forms[0].medical_team_val_ack.value="";
				document.getElementById("medical_team_val_ack").disabled = true;
			}
		}
		document.forms[0].inform_to_pract_desc.disabled = true;
		document.forms[0].inform_to_pract_search.disabled=true;
		
		//Added for this CRF ML-MMOH-CRF-0712
		if(document.forms[0].call_function && document.forms[0].call_function.value=="FORWARD_TO_HOD"){
		   if(document.getElementById("acknow_coordinator_img"))document.getElementById("acknow_coordinator_img").style.visibility = "hidden";	
		   if(document.getElementById("informtopract_img"))document.getElementById("informtopract_img").style.visibility = "hidden";
		}
		//End this CRF ML-MMOH-CRF-0712
		
		document.forms[0].fwd_pract_desc.value = "";
		document.forms[0].fwd_practitioner_id.value = "";
		document.forms[0].ack_hod_co_ord_desc.value = "";
		document.forms[0].ack_hod_co_ord_id.value = "";
		document.forms[0].inform_to_pract_desc.value = "";
		document.forms[0].inform_to_pract_id.value = "";
		
	
	}else if(status == "A" || status =="S" ){  // modified by mujafar for ML-MMOH-CRF-0718
		document.getElementById("collectImg5").style.display='inline';
		document.getElementById("collectImg6").style.display='inline';
		if(isRejectRequestApplicable=="true" && document.forms[0].call_function && call_function == "FORWARD_TO_HOD"){ // added by mujafar for ML-MMOH-CRF-0713
		document.getElementById("collectImg7").style.display='none';
		document.getElementById("collectImg8").style.display='none';
		document.getElementById("reject_by_1").style.display='none';
		document.getElementById("reject_by_2").style.display='none';
		document.getElementById("reject_on_1").style.display='none';
		document.getElementById("reject_on_2").style.display='none';
		document.getElementById("reject_reason_1").style.display='none';
		document.getElementById("reject_medrep_reason_desc").style.display='none';
		document.getElementById("reject_medical_rep_reason").style.visibility = "hidden";
		document.getElementById("reject_medical_rep_reason_img").style.visibility = "hidden";
		}
		
		document.getElementById("acc").style.display='inline';
		document.getElementById("rej").style.display='none';
		document.forms[0].img_remarks.style.visibility = "Hidden";//Added by Ashwini for ML-MMOH-SCF-0667 on 06-Mar-2017
		document.forms[0].fwd_pract_desc.disabled = false;
		document.forms[0].fwd_pract_id_search.disabled=false;
		document.forms[0].ack_hod_co_ord_desc.disabled = false;
		document.forms[0].ack_hod_co_ord_search.disabled=false;
		
		
			if(document.forms[0].medical_team_val_ack && isMedicalTeamApplicable == "true")
			{  //added by mujafar for ML-MMOH-CRF-0716
			if(document.forms[0].medical_team_val_ack.value == "" && document.forms[0].ack_hod_co_ord_desc.value != "")
			{
			document.getElementById("medical_team_val_ack").disabled = true;
			document.forms[0].ack_hod_co_ord_desc.disabled = false;
			document.forms[0].ack_hod_co_ord_search.disabled=false;
			
			}
			else
			if(document.forms[0].medical_team_val_ack.value != "" && document.forms[0].ack_hod_co_ord_desc.value == "")
			{
				document.forms[0].ack_hod_co_ord_desc.disabled = true;
				document.forms[0].ack_hod_co_ord_search.disabled=true;
				document.getElementById("medical_team_val_ack").disabled = false;
			}
			else
			{
				document.getElementById("medical_team_val_ack").disabled = false;
			}
			}
				
	
		
		document.forms[0].inform_to_pract_desc.disabled = false;
		document.forms[0].inform_to_pract_search.disabled=false;
		
		//Added for this CRF ML-MMOH-CRF-0712
		if(document.forms[0].call_function && document.forms[0].call_function.value=="FORWARD_TO_HOD"){
		    if(document.getElementById("acknow_coordinator_img"))document.getElementById("acknow_coordinator_img").style.visibility = "visible";	
		    if(document.getElementById("informtopract_img"))document.getElementById("informtopract_img").style.visibility = "visible";
		}
		if(status=="A" && isSelfStatusMRPApplicable == "true")
		{ // added by mujafar for ML-MMOH-CRF-0718
			document.forms[0].fwd_pract_desc.value = "";
		}
		//End this CRF ML-MMOH-CRF-0712
		
		if(status =="S" && isSelfStatusMRPApplicable == "true")
		{ // added by mujafar for ML-MMOH-CRF-0718
			var loginID=document.forms[0].loginUserID.value;
			if(loginID!="")
			getSelfPractitioner(loginID);
		}
		
	
	}
	}
	else if(call_function == "RECEIVE_MEDICAL_REPORT")
	{
		if(status == "R")
		{ 
			document.getElementById("reject_by_3").style.display='inline';
			document.getElementById("reject_by_4").style.display='inline';
			document.getElementById("reject_on_3").style.display='inline';
			document.getElementById("reject_on_4").style.display='inline';
			document.getElementById("reject_reason_3").style.display='inline';
			document.getElementById("reject_medrep_reason_desc_1").style.display='inline';
			document.getElementById("reject_medical_rep_reason_1").style.visibility = "visible"; 
			document.getElementById("reject_medical_rep_reason_img_1").style.visibility = "visible"; 
			document.getElementById("ReceiveDt_img").disabled=true;
			document.getElementById("ReceiveDt").value="";
			document.getElementById("ReceiveDt").disabled=true; 
			
		}
		else if(status == "A")
		{
			
			document.getElementById("reject_by_3").style.display='none';
			document.getElementById("reject_by_4").style.display='none';
			document.getElementById("reject_on_3").style.display='none';
			document.getElementById("reject_on_4").style.display='none';
			document.getElementById("reject_reason_3").style.display='none';
			document.getElementById("reject_medrep_reason_desc_1").style.display='none';
			document.getElementById("reject_medical_rep_reason_1").style.visibility = "hidden";
			document.getElementById("reject_medical_rep_reason_img_1").style.visibility = "hidden";
			document.getElementById("ReceiveDt_img").disabled=false;
			document.getElementById("ReceiveDt").disabled=false;
			
		}
		
	}
	
}

/*Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707*/
function RequestorTypeValue()
{  
		if(document.forms[0].classification_appl_yn.value == "true") // added by mujafar for ML-MMOH-CRF-0762
			var ReqTypeValue	= document.forms[0].requestor_type_ind.value;
		else
			var ReqTypeValue	= document.forms[0].indicator_req.value;
		
		for(var i=0;i<document.forms[0].req_type.options.length;i++ )
		{
			if(document.forms[0].req_type.options[i].value == ReqTypeValue)
				document.forms[0].req_type.options[i].selected=true;
		}
		
		if(document.forms[0].classification_appl_yn.value == "true")
		{ // added by mujafar for ML-MMOH-CRF-0762
			
			var otheraltval = document.forms[0].oth_alt_type.value;
			if(document.forms[0].contact1_oth_alt_id_type){
			for(var i=0;i<document.forms[0].contact1_oth_alt_id_type.options.length;i++ )
				{
			if(document.forms[0].contact1_oth_alt_id_type.options[i].value == otheraltval)
				document.forms[0].contact1_oth_alt_id_type.options[i].selected=true;
				}
				document.forms[0].contact1_oth_alt_id_no.value=document.forms[0].oth_alt_id.value;
			}
		}
}
async function DisplayAddress()
{ // added by mujafar for ML-MMOH-CRF-0762
	var  req_type_status = document.forms[0].req_type_status.value;
	
	
	if(req_type_status == "N") reln_type = '0';
	else if(req_type_status == "P") reln_type = '3';
	else if(req_type_status == "O" || req_type_status == "" ) reln_type = '4';
	
	var request_id		= document.forms[0].reg_no.value;
	var requestor_type	= document.forms[0].req_type.value;
	var requestor_desc	= document.forms[0].requestor_desc.value;
	var requestor_code	= document.forms[0].Requestor_Code.value;
	
	
	
	if(reln_type == '')
	{
		if(requestor_type != '' && requestor_desc == '')
		{
			var error=getMessage("CAN_NOT_BE_BLANK","Common");
			error= error.replace('$',getLabel("Common.Requestor.label","Common"));
			alert(error);
			return;
		}
	}

	var retVal		= new String();
	var dialogHeight= "80vh" ;
	var dialogWidth = "80vw" ;
	
	/*Below line added for ML-MMOH-CRF-0860.2*/
	if(document.forms[0].increasedaddressLength && document.forms[0].increasedaddressLength.value=="true"){
	   dialogHeight= "80vh" ;
	  // dialogWidth = "55" ;	
	}	

	
	
	var status		= "no";
	var patient_id	= document.forms[0].patientId.value;
	var call_function = document.forms[0].call_function.value;
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

		retVal = await window.showModalDialog( "../../eMR/jsp/MedRecAddressFrames.jsp?RelationShipType=Others&call_function="+call_function+"&reln_type="+reln_type+"&request_id="+request_id+"&patient_id="+patient_id+"&Oth_appl_addr_line1="+encodeURIComponent(Oth_appl_addr_line1)+"&Oth_appl_addr_line2="+encodeURIComponent(Oth_appl_addr_line2)+"&Oth_appl_addr_line3="+encodeURIComponent(Oth_appl_addr_line3)+"&Oth_appl_addr_line4="+encodeURIComponent(Oth_appl_addr_line4)+"&Oth_appl_res_town_desc="+encodeURIComponent(Oth_appl_res_town_desc)+"&Oth_appl_res_town_code="+encodeURIComponent(Oth_appl_res_town_code)+"&Oth_appl_res_area_desc="+encodeURIComponent(Oth_appl_res_area_desc)+"&Oth_appl_res_area_code="+encodeURIComponent(Oth_appl_res_area_code)+"&Oth_appl_region_desc="+encodeURIComponent(Oth_appl_region_desc)+"&Oth_appl_region_code="+encodeURIComponent(Oth_appl_region_code)+"&Oth_appl_postal_desc="+encodeURIComponent(Oth_appl_postal_desc)+"&Oth_appl_postal_code="+encodeURIComponent(Oth_appl_postal_code)+"&Oth_appl_country_desc="+encodeURIComponent(Oth_appl_country_desc)+"&Oth_appl_country_code="+encodeURIComponent(Oth_appl_country_code)+"&other_contact_no1="+encodeURIComponent(other_contact_no1)+"&other_contact_no2="+encodeURIComponent(other_contact_no2)+"&other_appl_email_id="+encodeURIComponent(other_appl_email_id),arguments,features);

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

		retVal = await window.showModalDialog( "../../eMR/jsp/MedRecAddressFrames.jsp?RelationShipType=Self&call_function="+call_function+"&reln_type="+reln_type+"&request_id="+request_id+"&patient_id="+patient_id+"&appl_addr_line1="+encodeURIComponent(appl_addr_line1)+"&appl_addr_line2="+encodeURIComponent(appl_addr_line2)+"&appl_addr_line3="+encodeURIComponent(appl_addr_line3)+"&appl_addr_line4="+encodeURIComponent(appl_addr_line4)+"&appl_res_town_code="+encodeURIComponent(appl_res_town_code)+"&appl_res_town_desc="+encodeURIComponent(appl_res_town_desc)+"&appl_res_area_code="+encodeURIComponent(appl_res_area_code)+"&appl_res_area_desc="+encodeURIComponent(appl_res_area_desc)+"&appl_region_code="+encodeURIComponent(appl_region_code)+"&appl_region_desc="+encodeURIComponent(appl_region_desc)+"&appl_postal_code="+encodeURIComponent(appl_postal_code)+"&appl_postal_desc="+encodeURIComponent(appl_postal_desc)+"&appl_country_desc="+encodeURIComponent(appl_country_desc)+"&appl_country_code="+encodeURIComponent(appl_country_code)+"&self_contact_no1="+encodeURIComponent(self_contact_no1)+"&self_contact_no2="+encodeURIComponent(self_contact_no2)+"&self_appl_email_id="+encodeURIComponent(self_appl_email_id),arguments,features);


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
			document.forms[0].appl_postal_code.value= arr[10];
			document.forms[0].appl_postal_desc.value= arr[11];
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

		retVal = await window.showModalDialog( "../../eMR/jsp/MedRecAddressFrames.jsp?RelationShipType=NKIN&call_function="+call_function+"&reln_type="+reln_type+"&request_id="+request_id+"&patient_id="+patient_id+"&nkin_addr_line1="+encodeURIComponent(nkin_addr_line1)+"&nkin_addr_line2="+encodeURIComponent(nkin_addr_line2)+"&nkin_addr_line3="+encodeURIComponent(nkin_addr_line3)+"&nkin_addr_line4="+encodeURIComponent(nkin_addr_line4)+"&nkin_res_town_desc="+encodeURIComponent(nkin_res_town_desc)+"&nkin_res_town_code="+encodeURIComponent(nkin_res_town_code)+"&nkin_res_area_desc="+encodeURIComponent(nkin_res_area_desc)+"&nkin_res_area_code="+encodeURIComponent(nkin_res_area_code)+"&nkin_region_desc="+encodeURIComponent(nkin_region_desc)+"&nkin_region_code="+encodeURIComponent(nkin_region_code)+"&nkin_postal_desc="+encodeURIComponent(nkin_postal_desc)+"&nkin_postal_code="+encodeURIComponent(nkin_postal_code)+"&nkin_country_desc="+encodeURIComponent(nkin_country_desc)+"&nkin_country_code="+encodeURIComponent(nkin_country_code)+"&nkin_contact_no1="+encodeURIComponent(nkin_contact_no1)+"&nkin_contact_no2="+encodeURIComponent(nkin_contact_no2)+"&nkin_appl_email_id="+encodeURIComponent(nkin_appl_email_id),arguments,features);

		
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
			document.forms[0].nkin_postal_code.value= arr[11];
			document.forms[0].nkin_country_desc.value= arr[12];
			document.forms[0].nkin_country_code.value= arr[13];

			/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
			document.forms[0].nkin_contact_no1.value= arr[14];
			document.forms[0].nkin_contact_no2.value= arr[15];
			document.forms[0].nkin_appl_email_id.value= arr[16];
			/*ML-MMOH-CRF-0707*/
		}
	} 
	
	
// added by mujafar for ML-MMOH-CRF-0762 end
	
}

/*Added by Ashwini on 11-Oct-2019 for ML-MMOH-CRF-1359*/
function MedRecReqCheckForSpecChars(event){ 
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}

function SpeCharCheck(which) {
fldval = which.value;
fldval = fldval.replace(/^\s+/,""); // strip leading spaces
if (/[^a-z0-9\s]/i.test(fldval)) { // only alphanumeric and space allowed
var error = getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED",'SM');
alert (error);
which.value = "";
which.focus();
return false;
}
}
/*End ML-MMOH-CRF-1359*/
/*Added By Dharma on 13t Dec 2019 against ML-MMOH-CRF-1362 Start*/
function fnDisplayRequestorAddr(requestorId){
	var facility_id 	= document.forms[0].facility_id.value;
	var xmlDoc=""
	var xmlHttp = new XMLHttpRequest()
	xmlStr = "<root><SEARCH requestorId=\""+requestorId+"\" facility_id=\""+facility_id+"\" action='getRequestorAddress' /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eMR/jsp/MRIntermediate.jsp",false);
	xmlHttp.send(xmlDoc)
	responseText = xmlHttp.responseText;
	responseText = trimString(responseText);
	var requestorAddrArr	= responseText.split("$@^");
	var i = 0;
	var addressLine1	= requestorAddrArr[i++];
	var addressLine2	= requestorAddrArr[i++];
	var addressLine3	= requestorAddrArr[i++];
	var addressLine4	= requestorAddrArr[i++];
	var townCode		= requestorAddrArr[i++];
	var townDesc		= requestorAddrArr[i++];
	var areaCode		= requestorAddrArr[i++];
	var areaDesc		= requestorAddrArr[i++];
	var regionCode		= requestorAddrArr[i++];
	var regionDesc		= requestorAddrArr[i++];
	var postalCode		= requestorAddrArr[i++];
	var PostalDesc		= requestorAddrArr[i++];
	var countryCode		= requestorAddrArr[i++];
	var countryName		= requestorAddrArr[i++];
	var contactNo1		= requestorAddrArr[i++];
	var contactNo2		= requestorAddrArr[i++];
	var emailId			= requestorAddrArr[i++];
	document.forms[0].Oth_appl_addr_line1.value			= addressLine1;
	document.forms[0].Oth_appl_addr_line2.value			= addressLine2;
	document.forms[0].Oth_appl_addr_line3.value			= addressLine3;
	document.forms[0].Oth_appl_addr_line4.value			= addressLine4;
	document.forms[0].Oth_appl_res_town_code.value		= townCode;
	document.forms[0].Oth_appl_res_town_desc.value		= townDesc;
	document.forms[0].Oth_appl_res_area_code.value		= areaCode;
	document.forms[0].Oth_appl_res_area_desc.value		= areaDesc;
	document.forms[0].Oth_appl_region_code.value		= regionCode;
	document.forms[0].Oth_appl_region_desc.value		= regionDesc;
	document.forms[0].Oth_appl_postal_code.value		= postalCode;
	document.forms[0].Oth_appl_postal_desc.value		= PostalDesc;
	document.forms[0].Oth_appl_country_code.value		= countryCode;
	document.forms[0].Oth_appl_country_desc.value		= countryName;
	document.forms[0].other_contact_no1.value			= contactNo1;
	document.forms[0].other_contact_no2.value			= contactNo2;
	document.forms[0].other_appl_email_id.value			= emailId;
}
/*Added By Dharma on 13t Dec 2019 against ML-MMOH-CRF-1362 End*/

