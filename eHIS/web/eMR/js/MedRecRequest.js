function reset() 
{
	if(f_query_add_mod.document.DeathRegister)
		f_query_add_mod.document.DeathRegister.reset();
	else if(f_query_add_mod.document.search_form)
	{
		f_query_add_mod.document.search_form.reset();
		//f_query_add_mod.document.search_form.clear.onclick();
		if(parent.frames[2].frames[2].name == "content")
			parent.frames[2].frames[2].document.location.href ='../../eCommon/html/blank.html';

	}
	// Added by Sridhar R on 7 OCT 2004,, to default the system date as Discharge dates...

	if(f_query_add_mod.document.search_form)
		{
			if(f_query_add_mod.document.forms[0].call_function.value == 'DIAG_RECODE')
				{
					/*f_query_add_mod.document.getElementById("discDate_img").style.visibility = "hidden";
					if(f_query_add_mod.document.getElementById("encDate_img"))
						f_query_add_mod.document.getElementById("encDate_img").style.visibility = "hidden";
					f_query_add_mod.document.getElementById("mand_gif3").style.visibility = "hidden";
					var obj_type =f_query_add_mod.document.forms[0].status;
					var length  = obj_type.length;
					for(i=0;i<length;i++) 
					{
						obj_type.remove(1);
					}
					//f_query_add_mod.document.getElementById("status").value = "";
					//f_query_add_mod.document.search_form.alt_id1_exp_date.value = f_query_add_mod.document.search_form.SystemDate.value;
					//f_query_add_mod.document.search_form.alt_id2_exp_date.value = f_query_add_mod.document.search_form.SystemDate.value;*/

                // f_query_add_mod.document.search_form.reset();
				f_query_add_mod.location.reload();

				}				
		}

			if(f_query_add_mod.document.search_form1)
			{
				f_query_add_mod.document.search_form1.reset();
			}
}


function run()
	{
		if (f_query_add_mod.document.DeathRegister)
		{
		if (f_query_add_mod.CheckString(getLabel("eMR.DeathDate.label","MR"), f_query_add_mod.document.DeathRegister.date_from,f_query_add_mod.document.DeathRegister.date_to, messageFrame))

			f_query_add_mod.document.DeathRegister.submit() ;
		}
   }

// added from ReportRequestQueryCriteria.jsp


 async function getRequestorType(obj,target) //Function to obtain Procedure classification
     {
				var retVal =    new String();               
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var locale = document.forms[0].locale.value;
                var tit = getLabel("eMR.RequestorType.label","MR");
                sql = "select requestor_code code, short_name description from MR_REQUESTOR_LANG_VW where LANGUAGE_ID ='"+locale+"' and eff_status='E' and upper(requestor_code) like upper(?) and upper(short_name) like upper(?) order by 2";					
			
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
					document.forms[0].requestor_desc.value=arr[1];					
					document.forms[0].requestor_code.value=arr[0];
				}
				else{
					document.forms[0].requestor_desc.value="";					
					document.forms[0].requestor_code.value="";
				}
		}



	function chkGetRequestor() //Call getRequestorType function if the description field is empty
	{
		
		if(document.forms[0].requestor_desc.value=="") {}
		else { getRequestorType(document.forms[0].requestor_lookup,document.forms[0].requestor_desc); }

	}


function check_date_to_from(obj)
{
	var t1 = CheckDate(obj);		
	if(!t1){obj.value=""; obj.focus();return;}
}

	function compareDates(obj)
    	{
			if(!doDateCheckAlert(document.forms[0].from_date,document.forms[0].to_date))
				{
					alert(getMessage("TO_DT_GR_EQ_FM_DT",'SM'));
					document.forms[0].to_date.select();
					document.forms[0].to_date.focus();
				}
	   }

	function Valid_DT(event)
		{
			var strCheck = '0123456789:/ ';
			var whichCode = (window.Event) ? event.which : event.keyCode;
			key = String.fromCharCode(whichCode);  // Get key value from key code
			if (strCheck.indexOf(key) == -1) return false;  // Not a valid key

		} 


	function clearAll()
	  {
			var callFunction = document.forms[0].call_function.value;
			parent.frames[2].document.location.href ='../../eCommon/html/blank.html'; 

			if(parent.messageFrame)
			parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
	  }

//added from MRPatientDetailsComponent.jsp

	 async  function showLookUp(val)
            {
                if(val == 'P')
                {
					var patientid= await PatientSearch('','','','','','','Y','','','OTHER');
					if(patientid != null)
						parent.criteriaFrame.document.getElementById("PatientId").value = patientid;
					else
						parent.criteriaFrame.document.getElementById('patientId').value = "";
                }
            }

			function validSplchars(obj)
			{				
				 var fields=new Array();
				 var names=new Array();
				 fields[0]=obj;
				 names[0]=getLabel("Common.patientId.label","Common");									
				if(SpecialCharCheck( fields, names,'',"A",''))
					return true;
				else
				{
					obj.select();
					obj.focus();
					return false;
				}
			}


			function enableSearchby(obj)
			{
				if (obj.value=='')
				{
					if (document.forms[0].searchby)
					{
						document.forms[0].searchby.disabled=false;
						document.forms[0].searchby.value='S';						
					}
				}
				else
				{
					if (document.forms[0].searchby)
					{
						document.forms[0].searchby.disabled=true;
						document.forms[0].searchby.value='';
					}
				}

			}

//added from ReportRequestQueryResult.jsp
	async function callModalWindow(req_id,call_func,pat_id )
	{
		var jsp_name	= "MedRecRequestRecordMain.jsp";
		var called_from = parent.frames[1].document.forms[0].called_from.value;
		var retVal		= new String();
		var dialogHeight= "33vh";	
		var dialogWidth	= "50vw";		
		var dialogTop	= "59" ;
		var center		= "1" ;
		var status		= "no";
		var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		retVal			=await  window.showModalDialog("../../eMR/jsp/"+jsp_name+"?call_function="+call_func+"&request_id="+req_id+"&PatientId="+pat_id+"&called_from="+called_from+"",arguments,features);

		parent.frames[2].document.location.reload();
	}

// added from MedRecRequestResult.jsp
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++
Function Name :	RemSelectAll()
Purpose : To Uncheck the Select All CheckBox when atleast 
		  one of the CheckBox is UnChecked..
+++++++++++++++++++++++++++++++++++++++++++++++++++++*/

function RemSelectAll()
{
	document.forms[0].chkAll.checked = false;
	document.forms[0].selectAll_yn.value == "";
}

async function RecodeDiagnosis(encID, PatID)
{
	var call_function = "DIAG_RECODE";
	var FacilityId = document.forms[0].FacilityId.value;
	var dialogHeight= "29vh" ;
	var dialogWidth = "50vw" ;
	var dialogTop 	= "58";
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = 	await window.showModalDialog("../../eMR/jsp/RecodeDiagnosis.jsp?Encounter_Id="+encID+"&FacilityId="+FacilityId+"&PatientId="+PatID+"&call_function="+call_function,arguments,features);
}

async function DiagnososTransmissionDtls(encID, PatID)
{	
	var call_function = "TRANSMIT_NOTIFY_REP";
	var FacilityId = document.forms[0].FacilityId.value;
	var dialogHeight= "31vh" ;
	var dialogWidth = "50vw" ;
	var dialogTop 	= "59";
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = 	await window.showModalDialog("../../eMR/jsp/RecodeDiagnosis.jsp?Encounter_Id="+encID+"&FacilityId="+FacilityId+"&PatientId="+PatID+"&call_function="+call_function,arguments,features);
}

async function DiagnososConfirmationDtls(encID, PatID)
{	
	var call_function = "CONF_TRANSMIT_NOTIFY_REP";
	var FacilityId = document.forms[0].FacilityId.value;
	var dialogHeight= "31vh" ;
	var dialogWidth = "50vw" ;
	var dialogTop 	= "59";
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = 	await window.showModalDialog("../../eMR/jsp/RecodeDiagnosis.jsp?Encounter_Id="+encID+"&FacilityId="+FacilityId+"&PatientId="+PatID+"&call_function="+call_function,arguments,features);
}

async function calladdmodifyMark(encounterId,func, pat_id)
{
	var FacilityId = document.forms[0].FacilityId.value;
	var dialogHeight= "23vh" ;
	var dialogWidth = "40vw" ;
	var dialogTop 	= "77";
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = 	await window.showModalDialog("../../eMR/jsp/MarkEncounterFrames.jsp?Encounter_Id="+encounterId+"&FacilityId="+FacilityId+"&patient_id="+pat_id+"&call_from="+func,arguments,features);
}

function chkForSelectAll(start,end)
{
	if(document.forms[0].name =='MedRecRequestResult')
	{
		if(document.forms[0].selectAll_yn)
		{
			if(document.forms[0].selectAll_yn.value == "YES")
			{
				document.forms[0].chkAll.checked = true;
				selectAll(document.forms[0].chkAll,start,end)
			}
			else
			if(document.forms[0].selectAll_yn.value == "NO")
			{
				document.forms[0].chkAll.checked = false;
				selectAll(document.forms[0].chkAll,start,end)
			}
		}
	}
}

function selectAll(Obj,start,end)
{
	if(Obj.checked)
	{
		for(var i=start;i<=end;i++)
		{
			if(eval("document.forms[0].chk"+i))
			{
			 	eval("document.forms[0].chk"+i).checked=true;
//				eval("document.forms[0].chk"+i).disabled=true;

				chkServices(eval("document.forms[0].chk"+i))
//			 	eval("document.forms[0].chk"+i).disabled=true;
			}
		}
		document.forms[0].selectAll_yn.value = "YES";
	}
	else
	{
		for(var i=start;i<=end;i++)
		{
			if(eval("document.forms[0].chk"+i))
			{
			 	eval("document.forms[0].chk"+i).checked=false;
//				eval("document.forms[0].chk"+i).disabled=false;
				chkServices(eval("document.forms[0].chk"+i))
//			 	eval("document.forms[0].chk"+i).disabled=false;
			}
		}
		document.forms[0].selectAll_yn.value = "NO";
//		parent.frames[3].document.forms[0].search.disabled = true;
	}
}

function submitPrevNext(from, to)
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

function chkServices(Obj)
{
	parent.frames[3].document.forms[0].search.disabled = false;
	if(Obj.checked)
	{
		document.forms[0].selectAll_yn.value = "";
		document.forms[0].temp1.value=document.forms[0].temp1.value+Obj.value+"$"+Obj.name+"$E~"
		document.forms[0].finalSelect.value=document.forms[0].temp1.value;
	}
	else
	{		
		document.forms[0].selectAll_yn.value = "";
		document.forms[0].temp1.value=document.forms[0].temp1.value+Obj.value+"$"+Obj.name+"$D~"
		document.forms[0].finalSelect.value=document.forms[0].temp1.value;
	}
}

function closeWin(enc,patid,changefunc,Patient_Class)
{
	showModalCurEnc(enc,patid,changefunc,Patient_Class);
}


async function showModalCurEnc(enc,patid,changefunc,Patient_Class)
{
	var bl_install_yn=document.forms[0].bl_install;
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
	retVal = await window.showModalDialog("../../eMR/jsp/"+jsp_name+"?encounterId="+enc+"&bl_instal="+bl_install_yn.value+"&call_function="+call_function+"&patientId="+patid+"&Patient_Class="+Patient_Class,arguments,features);
	if(retVal!=null && retVal!='')

	parent.frames[2].document.location.reload();
}

// added from MedRecRequestRecordDetail.jsp

function validateSplchars(obj)
{	
	var val = obj.value.toUpperCase();			
	obj.value = val;	
	var fields=new Array();
	var names=new Array();
	fields[0]=obj;
	names[0]= getLabel("Common.otheraltid.label","Common");
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

function EnDisRelation(obj)
{
	if(obj != '')
	{
		document.forms[0].relationship_type.value	= "";
		document.forms[0].relationship_type.disabled	= true;
		document.forms[0].relationship.value		= "";
		document.forms[0].relationship.disabled		= true;
	}
	else
	{
		document.forms[0].relationship_type.value	= "";
		document.forms[0].relationship_type.disabled	= false;
		document.forms[0].relationship.value		= "";
		document.forms[0].relationship.disabled		= false;
	}
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
	var retVal		= new String();
	var dialogHeight= "20vh" ;
	var dialogWidth = "25vw" ;
	var status		= "no";
	var patient_id	= document.forms[0].patientId.value;
	var arguments		= "";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

		var  del_addr_line1 = document.forms[0].del_addr_line1.value;
		var  del_addr_line2 = document.forms[0].del_addr_line2.value;
		var  del_addr_line3 = document.forms[0].del_addr_line3.value;
		var  del_addr_line4 = document.forms[0].del_addr_line4.value;
		var  del_res_town_desc = document.forms[0].del_res_town_desc.value;
		var  del_res_town_code = document.forms[0].del_res_town_code.value;
		var  del_res_area_desc = document.forms[0].del_res_area_desc.value;
		var  del_res_area_code = document.forms[0].del_res_area_code.value;
		var  del_region_desc = document.forms[0].del_region_desc.value;
		var  del_region_code = document.forms[0].del_region_code.value;
		var  del_postal_desc = document.forms[0].del_postal_desc.value;
		var  del_postal_code = document.forms[0].del_postal_code.value;
		var  del_country_desc = document.forms[0].del_country_desc.value;
		var  del_country_code = document.forms[0].del_country_code.value;

		retVal = await window.showModalDialog( "../../eMR/jsp/MedRecAddressFrames.jsp?RelationShipType=DeliveryAddress&del_addr_line1="+escape(del_addr_line1)+"&del_addr_line2="+escape(del_addr_line2)+"&del_addr_line3="+escape(del_addr_line3)+"&del_addr_line4="+escape(del_addr_line4)+"&del_res_town_desc="+escape(del_res_town_desc)+"&del_res_town_code="+escape(del_res_town_code)+"&del_res_area_desc="+escape(del_res_area_desc)+"&del_res_area_code="+escape(del_res_area_code)+"&del_region_desc="+escape(del_region_desc)+"&del_region_code="+escape(del_region_code)+"&del_postal_desc="+escape(del_postal_desc)+"&del_postal_code="+escape(del_postal_code)+"&del_country_desc="+escape(del_country_desc)+"&del_country_code="+escape(del_country_code),arguments,features);

		if(retVal != null)
		{
			var arr = retVal.split("~");

			document.forms[0].del_addr_line1.value = arr[0];
			document.forms[0].del_addr_line2.value= arr[1];
			document.forms[0].del_addr_line3.value= arr[2];
			document.forms[0].del_addr_line4.value= arr[3];

			document.forms[0].del_res_town_desc.value= arr[4];
			document.forms[0].del_res_town_code.value= arr[5];
			
			document.forms[0].del_res_area_desc.value= arr[6];
			document.forms[0].del_res_area_code.value= arr[7];

			document.forms[0].del_region_desc.value= arr[8];
			document.forms[0].del_region_code.value= arr[9];
			
			document.forms[0].del_postal_desc.value= arr[10];
			document.forms[0].del_postal_code.value= arr[10];

			document.forms[0].del_country_desc.value= arr[12];
			document.forms[0].del_country_code.value= arr[13];
		}
}

function enableDisableObjs(mode)
{
	if(mode == 'P')
	{
		document.forms[0].report_taken.value = document.forms[0].appl_name.value;
		document.forms[0].report_taken.disabled = false;

		document.forms[0].del_nric_no.value = "";
		document.forms[0].del_nric_no.disabled = false;

		document.forms[0].del_oth_alt_type.value = "";
		document.forms[0].del_oth_alt_type.disabled = false;

		document.forms[0].del_oth_alt_id.value = "";
		document.forms[0].del_oth_alt_id.disabled = false;

		document.forms[0].posted_date.value = "";
		document.forms[0].posted_date.disabled = true;
		document.getElementById("postImg").disabled = true;

		document.forms[0].address.disabled = true;
		document.forms[0].file_no.value = "";
		document.forms[0].file_no.disabled = true;
	}
	else if(mode == 'O')
	{
		document.forms[0].report_taken.value = "";
		document.forms[0].report_taken.disabled = true;

		document.forms[0].del_nric_no.value = "";
		document.forms[0].del_nric_no.disabled = true;

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

		document.forms[0].del_nric_no.value = "";
		document.forms[0].del_nric_no.disabled = true;

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
	var request_id	= document.forms[0].reg_no.value;
	var retVal		= new String();
	var dialogHeight= "30vh" ;
	var dialogWidth = "50vw" ;
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

		retVal =await  window.showModalDialog( "../../eMR/jsp/MedRecAddressFrames.jsp?RelationShipType=Others&call_function="+call_function+"&reln_type="+reln_type+"&request_id="+request_id+"&patient_id="+patient_id+"&Oth_appl_addr_line1="+escape(Oth_appl_addr_line1)+"&Oth_appl_addr_line2="+escape(Oth_appl_addr_line2)+"&Oth_appl_addr_line3="+escape(Oth_appl_addr_line3)+"&Oth_appl_addr_line4="+escape(Oth_appl_addr_line4)+"&Oth_appl_res_town_desc="+escape(Oth_appl_res_town_desc)+"&Oth_appl_res_town_desc="+escape(Oth_appl_res_town_desc)+"&Oth_appl_res_area_desc="+escape(Oth_appl_res_area_desc)+"&Oth_appl_region_desc="+escape(Oth_appl_region_desc)+"&Oth_appl_postal_code="+escape(Oth_appl_postal_code)+"&Oth_appl_country_desc="+escape(Oth_appl_country_desc)+"&Oth_appl_country_code="+escape(Oth_appl_country_code),arguments,features);

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
			document.forms[0].Oth_appl_postal_code.value= arr[10];
	
			document.forms[0].Oth_appl_country_desc.value= arr[12];
			document.forms[0].Oth_appl_country_code.value= arr[13];
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
		var appl_country_desc = document.forms[0].appl_country_desc.value;
		var appl_country_code = document.forms[0].appl_country_code.value;

		retVal = await window.showModalDialog( "../../eMR/jsp/MedRecAddressFrames.jsp?RelationShipType=Self&call_function="+call_function+"&reln_type="+reln_type+"&request_id="+request_id+"&patient_id="+patient_id+"&appl_addr_line1="+escape(appl_addr_line1)+"&appl_addr_line2="+escape(appl_addr_line2)+"&appl_addr_line3="+escape(appl_addr_line3)+"&appl_addr_line4="+escape(appl_addr_line4)+"&appl_res_town_code="+escape(appl_res_town_code)+"&appl_res_town_desc="+escape(appl_res_town_desc)+"&appl_res_area_code="+escape(appl_res_area_code)+"&appl_res_area_desc="+escape(appl_res_area_desc)+"&appl_region_code="+escape(appl_region_code)+"&appl_region_desc="+escape(appl_region_desc)+"&appl_postal_code="+escape(appl_postal_code)+"&appl_country_desc="+escape(appl_country_desc)+"&appl_country_desc="+escape(appl_country_desc),arguments,features);

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
			document.forms[0].appl_postal_code.value= arr[10];
			document.forms[0].appl_country_desc.value= arr[12];
			document.forms[0].appl_country_code.value= arr[13];
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

		retVal =await window.showModalDialog( "../../eMR/jsp/MedRecAddressFrames.jsp?RelationShipType=NKIN&call_function="+call_function+"&reln_type="+reln_type+"&request_id="+request_id+"&patient_id="+patient_id+"&nkin_addr_line1="+escape(nkin_addr_line1)+"&nkin_addr_line2="+escape(nkin_addr_line2)+"&nkin_addr_line3="+escape(nkin_addr_line3)+"&nkin_addr_line4="+escape(nkin_addr_line4)+"&nkin_res_town_desc="+escape(nkin_res_town_desc)+"&nkin_res_town_desc="+escape(nkin_res_town_desc)+"&nkin_res_area_desc="+escape(nkin_res_area_desc)+"&nkin_region_desc="+escape(nkin_region_desc)+"&nkin_postal_code="+escape(nkin_postal_code)+"&nkin_country_desc="+escape(nkin_country_desc)+"&nkin_country_code="+escape(nkin_country_code),arguments,features);

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
			document.forms[0].nkin_postal_code.value= arr[10];
			document.forms[0].nkin_country_desc.value= arr[12];
			document.forms[0].nkin_country_code.value= arr[13];
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

		retVal =await window.showModalDialog("../../eMR/jsp/MedRecAddressFrames.jsp?RelationShipType=FTON&call_function="+call_function+"&reln_type="+reln_type+"&request_id="+request_id+"&patient_id="+patient_id+"&fton_addr_line1="+escape(fton_addr_line1)+"&fton_addr_line2="+escape(fton_addr_line2)+"&fton_addr_line3="+escape(fton_addr_line3)+"&fton_addr_line4="+escape(fton_addr_line4)+"&fton_res_town_desc="+escape(fton_res_town_desc)+"&fton_res_town_desc="+escape(fton_res_town_desc)+"&fton_res_area_desc="+escape(fton_res_area_desc)+"&fton_region_desc="+escape(fton_region_desc)+"&fton_postal_code="+escape(fton_postal_code)+"&fton_country_desc="+escape(fton_country_desc)+"&fton_country_code="+escape(fton_country_code),arguments,features);

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
			document.forms[0].fton_postal_code.value= arr[10];
			document.forms[0].fton_country_desc.value= arr[12];
			document.forms[0].fton_country_code.value= arr[13];
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

		retVal = await window.showModalDialog( "../../eMR/jsp/MedRecAddressFrames.jsp?RelationShipType=EMPLR&call_function="+call_function+"&reln_type="+reln_type+"&request_id="+request_id+"&patient_id="+patient_id+"&emplr_addr_line1="+escape(emplr_addr_line1)+"&emplr_addr_line2="+escape(emplr_addr_line2)+"&emplr_addr_line3="+escape(emplr_addr_line3)+"&emplr_addr_line4="+escape(emplr_addr_line4)+"&emplr_res_town_desc="+escape(emplr_res_town_desc)+"&emplr_res_town_desc="+escape(emplr_res_town_desc)+"&emplr_res_area_desc="+escape(emplr_res_area_desc)+"&emplr_region_desc="+escape(emplr_region_desc)+"&emplr_postal_code="+escape(emplr_postal_code)+"&emplr_country_desc="+escape(emplr_country_desc)+"&emplr_country_code="+escape(emplr_country_code),arguments,features);

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
			document.forms[0].emplr_postal_code.value= arr[10];
			document.forms[0].emplr_country_desc.value= arr[12];
			document.forms[0].emplr_country_code.value= arr[13];
		}
	}
}

function setDate(Status)
{
	if(Status == '1')
	{
		document.getElementById("collectImg").style.visibility = "Hidden";
	}
	else if(Status == '2')
	{
		document.getElementById("collectImg").style.visibility = "visible";
	}
	else
	{
		document.getElementById("collectImg").style.visibility = "visible";
	}
}

function populateApplName(relationship_type)
{
	if(relationship_type == "0")
	{

		document.forms[0].appl_name.value = "";
		document.forms[0].relationship.value = "";
		document.forms[0].relationship.disabled = true;

		var patientid	= document.forms[0].patientId.value;
		var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dummy_form' id='dummy_form' method='post'  action='../../eMR/jsp/MedRecRequestValidation.jsp' ><input type='hidden' name='Criteria' id='Criteria' value='populateApplName'><input type='hidden' name='patientId' id='patientId' value='"+patientid+"'><input type='hidden' name='relationCode' id='relationCode' value='"+relationship_type+"'></form></body></html>";
		parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[3].document.dummy_form.submit();
	}
	else if(relationship_type == "4")
	{
		document.forms[0].relationship.value = "";
		document.forms[0].relationship.disabled = false;
		document.forms[0].appl_name.value = "";
		document.forms[0].appl_name.disabled = false;
	}
	else if(relationship_type == "3")
	{
		document.forms[0].relationship.value = "";
		document.forms[0].relationship.disabled = true;

		document.forms[0].appl_name.value = document.forms[0].pat_nam.value;
		document.forms[0].appl_name.disabled = true;
	}
	else
	{
		document.forms[0].appl_name.value = "";
		document.forms[0].appl_name.disabled = false;

		document.forms[0].relationship.value = "";
		document.forms[0].relationship.disabled = true;
	}

}

async function Modal_Contact_Details()
{
	var retVal		= new String();
	var dialogHeight= "23" ;
	var dialogWidth = "39" ;
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
	var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='popReq' id='popReq' method='post' action='../../eMR/jsp/MedRecRequestValidation.jsp'><input type='hidden' name='req_type' id='req_type' value='"+req_type+"'><input type='hidden' name='Criteria' id='Criteria' value='populateRequestor'></form></body></html>";
	parent.frames[3].document.write(HTMLVal)
	parent.frames[3].document.popReq.submit();
}

// Added by SRIDHAR R on 22 NOV 2004 for Tabs
// function tab_click - Will Scroll the view between Two Tabs ...
function tab_click(objName)
{
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
		var error=getMessage("MRDATE1_LT_DATE2",'MR');
		if(call_function == 'RECEIVE_MEDICAL_REPORT')
		{
			if(ValidateDateTime(document.forms[0].hdd_CollectDate,obj))
			{
				var errr=getMessage("MRDATE1_GT_DATE2",'MR');
				errr= errr.replace('$',getLabel("Common.ReceivedDate.label","Common"));
				errr= errr.replace('#',getLabel("eMR.CollectDate.label","MR"));
				alert(errr)
//				alert("Receive date should be less than Collect Date...")
				obj.select();
				obj.focus();
				return;
			}
			if(ValidateDateTime(obj,document.forms[0].hdd_PrepareDate))
			{
				error= error.replace('$',getLabel("Common.ReceivedDate.label","Common"));
				error= error.replace('#',getLabel("Common.PrepareDate.label","Common"));
				alert(error)
				
				obj.select();
				obj.focus();
				return;
			}
		}
	
		if(call_function == 'DELIVER_MEDICAL_REPORT')
		{
			if(ValidateDateTime(obj,document.forms[0].hdd_RecieveDate))
			{
				error= error.replace('$',getLabel("eMR.DeliveredDate.label","MR"));
				error= error.replace('#',getLabel("Common.ReceivedDate.label","Common"));
				alert(error)
				obj.select();
				obj.focus();
				return;
			}
		}


		if(call_function == 'REVISE_MEDICAL_REPORT')
		{
			if(ValidateDateTime(obj,document.forms[0].sysdate))
			{
				error= error.replace('$',getLabel("eMR.RevisedDate.label","MR"));
				error= error.replace('#',getLabel("Common.SystemDate.label","Common"));
				alert(error)
//				alert("Revise date cannot be less than System Date")
				obj.select();
				obj.focus();
				return;
			}

			if(ValidateDateTime(obj,document.forms[0].hdd_CollectDate))
			{
				error= error.replace('$',getLabel("eMR.RevisedDate.label","MR"));
				error= error.replace('#',getLabel("eMR.CollectDate.label","MR"));
				alert(error)
//				alert("Revise date cannot be less than Collect Date")
				obj.select();
				obj.focus();
				return;
			}
			// new added

			if(document.forms[0].old_revised_collect_date.value != '')
			{
				if(ValidateDateTime(obj,document.forms[0].old_revised_collect_date))
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
	if(obj.value != '' )
	{
		if(!doDateTimeChk(obj))
		{
			alert( getMessage("INVALID_DATE_TIME",'SM') );
			obj.value = "";
			obj.focus();
			return ;
		}
	}
}

function selectIndicator(obj)
{
	var REQUESTOR_CODE = obj;
	var patientId = document.forms[0].patientId.value;
	var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='querydept' id='querydept' method='post' action='../../eMR/jsp/MedRecRequestValidation.jsp'><input type='hidden' name='REQUESTOR_CODE' id='REQUESTOR_CODE' value='"+REQUESTOR_CODE+"'><input type='hidden' name='patientId' id='patientId' value='"+patientId+"'><input type='hidden' name='Criteria' id='Criteria' value='MedBoardMembers'></form></body></html>";
	parent.frames[3].document.write(HTMLVal)
	parent.frames[3].document.querydept.submit();
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


async function getSpecialtyValue(aSpecialty, getFacilitID)
{
	var facility_id	   = getFacilitID;
	var target		   = document.forms[0].dept_spl;
	var retVal		   = new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var locale = document.forms[0].locale.value;	

	sql = "Select speciality_code code, short_desc description from AM_SPECIALITY_LANG_VW where LANGUAGE_ID ='"+locale+"' and eff_status like 'E' and upper(speciality_code) like upper(?) and  upper(short_desc) like upper(?) ";
	tit = getLabel("Common.speciality.label.label","Common");
	
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
		var preparedDt	= prepared.value;
		var result = "Pass";
		if(collectDt != '')
		{
			if (ValidateDateTime(collect,prepared))
			{
				var error=getMessage("MRDATE1_GT_DATE2",'MR');
				var call_function = document.forms[0].call_function.value;
				error= error.replace('$',getLabel("Common.PrepareDate.label","Common"));
				error= error.replace('#',getLabel("eMR.CollectDate.label","MR"));
				alert(error)
	//			alert("Prepare date should be less than collect date...")
				document.forms[0].prepare_date.select();
				document.forms[0].prepare_date.focus();
				result = "Fail";
			}
		}
	}
}


function CompareReqDate(obj,obj2)
{
	var dtVal=obj.value;		
	if(obj.value!='')
	{
		if(doDateTimeChk(obj))
		{	
			if(obj.value!='' && obj2.value!='')
			{
				if(!ValidateDateTime(obj2,obj))
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
			var str = getMessage("INVALID_DATE_TIME",'SM');
			alert(str);
			obj.value='';
		}
	}
}


function CompareSysDatePrp(obj)
{
	var obj2 = document.forms[0].sysdate;
	var dtVal=obj.value;		
	if(obj.value!='')
	{
	if(doDateTimeChk(obj))
	{	
	if(obj.value!='' && obj2.value!='')
	{
	if(!ValidateDateTime(obj,obj2))
		{
			var str = getMessage("MRDATE1_GT_DATE2",'MR');
			str = str.replace('$',getLabel("Common.PrepareDate.label","Common"));
			str = str.replace('#',getLabel("Common.SystemDate.label","Common"));
			alert(str);	
			obj.value='';	
			obj.focus();	
		}
	}
	}
	else
		{
		var str = getMessage("INVALID_DATE_TIME",'SM');
		alert(str);
		obj.value='';
		}
	}
}


function CompareSysforRecdDate(obj)
{
	var obj2 = document.forms[0].sysdate;
	var dtVal=obj.value;		
	if(obj.value!='')
	{
		if(doDateTimeChk(obj))
		{	
			if(obj.value!='' && obj2.value!='')
			{
				if(!ValidateDateTime(obj,obj2))
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
			}
		}
		else
		{
			var str = getMessage("INVALID_DATE_TIME",'SM');
			alert(str);
			obj.value='';
		}
	}
}

function CompareRegnDate(obj,sysdate)
{
	var fromdate = obj.value;
	var result = "Pass";
	var regndate = sysdate.value
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
	}
	if(result == "Pass" && fromdate != '')
	{
		if (ValidateDateTime(sysdate,obj))
		{
			var error=getMessage("MRDATE1_GT_DATE2",'MR');
			error= error.replace('$',getLabel("eMR.ApplicationDateTime.label","MR"));
			error= error.replace('#',getLabel("Common.regndatetime.label","Common"));
			alert(error);
			//appln date shud nnot be greater than regn date ...
			obj.select();
			obj.focus();
		}
	}
}

function CompareSysDate(obj,sysdate)
{
	var fromdate = obj.value;
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
	}
	if(result == "Pass")
	{
		if(fromdate != '')
		{
			if (ValidateDateTime(obj,sysdate))
			{

				var error=getMessage("MRDATE1_LT_DATE2",'MR');
				var call_function = document.forms[0].call_function.value;

				if(call_function == 'PREPARE_MEDICAL_REPORT')
				{
					error= error.replace('$',getLabel("Common.PrepareDate.label","Common"));
					error= error.replace('#',getLabel("Common.SystemDate.label","Common"));
					alert(error)
					
				}
				else if(call_function == 'RECEIVE_MEDICAL_REPORT')
				{
					error= error.replace('$',getLabel("Common.ReceivedDate.label","Common"));
					error= error.replace('#',getLabel("Common.SystemDate.label","Common"));
					alert(error)
					
				}
				else if(call_function == 'DELIVER_MEDICAL_REPORT')
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

				obj.select();
				obj.focus();
				result = "Fail";
			}
		}
	}
}


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

function getPractIDToBeDelete(obj)
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


	var facility_id		=document.forms[0].facility_id.value;
	var sql=" SELECT b.practitioner_id practitioner_id, c.practitioner_name practitioner_name, d.desc_sysdef practitioner_type, b.SPECIALTY_CODE primary_specialty,b.gender gender, b.PRACT_DESGNATION job_title FROM am_pract_all_splty_vw b, am_practitioner c, am_pract_type d, am_speciality e WHERE c.pract_type in ('MD','SG','DN','PS') and b.facility_id = '"+facility_id+"' AND c.practitioner_id = b.practitioner_id AND c.PRIMARY_SPECIALITY_CODE = b.SPECIALTY_CODE   AND b.SPECIALTY_CODE = e.speciality_code   AND c.pract_type = d.pract_type AND c.pract_type LIKE (?)AND b.SPECIALTY_CODE LIKE UPPER (?) AND ( UPPER(b.practitioner_id) LIKE UPPER (NVL (?, b.practitioner_id)) AND UPPER (c.practitioner_name) LIKE UPPER (NVL (?, c.practitioner_name)))AND b.sex LIKE (?) AND (b.job_title LIKE (?) OR b.job_title IS NULL) ";

	sql2=" SELECT b.practitioner_id practitioner_id, c.practitioner_name practitioner_name, d.desc_sysdef practitioner_type, b.SPECIALTY_CODE primary_specialty,b.gender gender,   b.PRACT_DESGNATION job_title FROM am_pract_all_splty_vw b, am_practitioner c, am_pract_type d, am_speciality e WHERE c.pract_type in ('MD','SG','DN','PS') and b.facility_id = '"+facility_id+"' AND c.practitioner_id = b.practitioner_id AND c.PRIMARY_SPECIALITY_CODE = b.SPECIALTY_CODE AND b.SPECIALTY_CODE = e.speciality_code   AND c.pract_type = d.pract_type AND c.pract_type LIKE (?)AND b.SPECIALTY_CODE LIKE UPPER (?) AND ( UPPER (b.practitioner_id) LIKE UPPER (NVL (?,b.practitioner_id)) OR UPPER (c.practitioner_name) LIKE UPPER (NVL (?, c.practitioner_name)))AND b.sex LIKE (?) AND (b.job_title LIKE (?) OR b.job_title IS NULL) ";

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" +practName_FName + "\"";
	xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue) + "\"";
	xmlStr += " sql=\"" +escape(sql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" + "" + "\"";
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);	
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
	var facility_id =document.forms[0].facility_id.value;
	var argumentArray=new Array(8);
	var req_type = document.forms[0].req_type.value;
	var locale = document.forms[0].locale.value;
	
	title=getLabel("Common.Requestor.label","Common");

	var function_called = document.forms[0].new_func_id.value ;
	if(function_called == 'APP_FOR_MED_BOARD')
	{
		argumentArray[0]=" select requestor_code code, short_name description from MR_REQUESTOR_LANG_VW where LANGUAGE_ID ='"+locale+"' and INDICATOR ='5' and EFF_STATUS like ? and facility_id like ? and upper(REQUESTOR_CODE) like upper(nvl(?,REQUESTOR_CODE)) and upper(short_name) like upper(nvl(?,short_name)) ";
	}
	else
	{
		argumentArray[0]=" select requestor_code code, short_name description from MR_REQUESTOR_LANG_VW where LANGUAGE_ID ='"+locale+"' and INDICATOR like ? and EFF_STATUS like ? and facility_id like ? and upper(REQUESTOR_CODE) like upper(nvl(?,REQUESTOR_CODE)) and upper(short_name) like upper(nvl(?,short_name)) ";
	}

		argumentArray[1]=new Array("INDICATOR","EFF_STATUS","facility_id");
		argumentArray[2]=new Array(req_type,"E",facility_id);
		argumentArray[3]=new Array(STRING,STRING,STRING);
		argumentArray[4]="4,5";
		argumentArray[5]=document.forms[0].requestor_desc.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;
			
	var retVal=await CommonLookup(title,argumentArray);
	
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].Requestor_desc_hid.value	=	arr[0];
		document.forms[0].Requestor_Code.value		=	arr[0];

		document.forms[0].requestor_desc.value		=	arr[1];
		document.forms[0].Requestor_desc_hid.value	= document.forms[0].requestor_desc.value;
		//selectIndicator(arr[0]);
	}
	else
	{
		document.forms[0].Requestor_desc_hid.value	=	"";		document.forms[0].requestor_desc.value		=	"";
	}
}


// added from MedicalRequestButtons.jsp

function openCAModal()
{
	var patient_class	= parent.frames[1].document.forms[0].patient_class.value;
	var episode_id		= parent.frames[1].document.forms[0].encounter_id.value;
	var note_type		= parent.frames[2].document.forms[0].rep_type.value;
	var patient_id		= parent.frames[2].document.forms[0].patientId.value;
	var accession_num	= parent.frames[2].document.forms[0].accession_num.value;

//	var visit_adm_date	= parent.frames[1].document.forms[0].encounter_date.value;

	var action_url		= "../../eCA/jsp/RecClinicalNotesModal.jsp?title=Record Notes&function_id=SPCL_NOTE&event_class=MDR$&Field_Ref=parent.frames[2].document.forms[0].accession_num&note_type="+note_type+"&patient_class="+patient_class+"&episode_id="+episode_id+"&patient_id="+patient_id+"&accession_num="+accession_num;

	var retVal=window.open(action_url,null,"height=450,width=790,top=120,left=0,status=NO,toolbar=no,menubar=no,location=no");
}

function closeME()
{
	var call_function = document.forms[0].call_function.value;
	if(call_function == "PREPARE_MEDICAL_REPORT")
	{
		if( document.forms[0].called_from.value == "CA" && parent.frames[2].document.forms[0].accession_num.value !='' )
		{
			for(var i=0; i<parent.frames[2].document.forms[0].length;i++)
			{
				parent.frames[2].document.forms[0].elements(i).disabled = false;
			}
			parent.frames[2].document.forms[0].action = "../../servlet/eMR.PrepareReportServlet";
			parent.frames[2].document.MedicalRecordReqForm.submit();
			window.close();
		}
		else
			window.close();
	}
	else
		window.close();
}



async function printReport()
{
	var accession_num	= parent.frames[2].document.forms[0].accession_num.value;
	// accession_num  - value from detail form...

	if(accession_num == '')
	{
//		alert("A note must be recorded...Cannot proceed");
		alert(getMessage("NOTE_DOESNOT_EXIST",'MR'));
	}
	else
	{
		var retVal		= 	new String();
		var dialogTop	=	"60";
		var dialogHeight=	"32" ;
		var dialogWidth	=	"50" ;
		var	title		=	getLabel("eMR.MedicalReport.label","MR");
		var features	=	"dialogTop:"+dialogTop+"; dialogHeight:"+dialogHeight+"; dialogWidth:"+dialogWidth+"; status=no" ;
		var header = "";

		var patientId		=	document.forms[0].patientId.value;
		var patient_line	=	document.forms[0].patient_line.value;
		var episode_type	=	document.forms[0].episode_type.value;
		var request_id		=	document.forms[0].request_id.value;
		var call_function	=	document.forms[0].call_function.value;
//		var accession_num	=	document.forms[0].accession_num.value;
	
		var arrMain			=	patient_line.split("|");
		var arrPatient		=	arrMain[0].split(",");
		var patient_id		=	arrMain[1].substring(3,arrMain[1].length);

		var check = arrPatient.length;
		if(parseInt(check)==3)
		{	
			header = "<table width='100%' border=0 cellpadding=0 cellspacing=0 align=center>"+
			"<tr><td align=center><h3>"+document.forms[0].facility_name.value+"</h3></td></tr>"+
			"<br><tr><td align=center><h4>"+encodeURIComponent(title)+"</h4></td></tr></table>"+
			"<BR><table width='100%' border='1' cellpadding=0 cellspacing=0 align=center><tr><td>"+
			"<table width='100%' border=0 cellpadding=0 cellspacing=0 align=center>"+
			"<tr><td nowrap><b>"+getLabel("Common.patientId.label","Common")+"</b></td><td nowrap><font size='2'>: "+patient_id+"</font></td>"+
			"<td nowrap><b>"+getLabel("Common.name.label","Common")+"</b></td><td colspan='3'><table width='100%' border='0' cellpadding=0 cellspacing=0><tr><td nowrap><font size='2'>: "+((arrPatient[0]==null)?"":arrPatient[0])+"</font></td></tr><tr><td>"+" "+"</td></tr></table></td></tr><tr><td nowrap><b>Sex</b></td><td nowrap><font size='2'>: "+((arrPatient[2]==null)?"":arrPatient[2])+"</font></td><td nowrap><b>"+getLabel("Common.age.label","Common")+"</b></td><td nowrap><font size='2'>: "+((arrPatient[1]==null)?"":arrPatient[1])+"</font></td></tr>";
		}else if(parseInt(check)==4)
		{
			header = "<table width='100%' border=0 cellpadding=0 cellspacing=0 align=center>"+
			"<tr><td align=center><h3>"+document.forms[0].facility_name.value+"</h3></td></tr><br><tr><td align=center><h4>"+encodeURIComponent(title)+"</h4></td></tr></table>"+
			"<br><table width='100%' border='1' cellpadding=0 cellspacing=0 align=center><tr><td>"+
			"<table width='100%' border=0 cellpadding=0 cellspacing=0 align=center>"+
			"<tr><td nowrap><b>"+getLabel("Common.patientId.label","Common")+"</b></td><td><font size='2'>: "+patient_id+"</font></td>"+
			"<td nowrap><b>"+getLabel("Common.name.label","Common")+"</b></td><td colspan='3'><table width='100%' border='0' cellpadding=0 cellspacing=0><tr><td><font size='2'>: "+((arrPatient[0]==null)?"":arrPatient[0])+"</font></td></tr><tr><td><font size='2'>&nbsp;"+((arrPatient[1]==null)?"":arrPatient[1])+"</font></td></tr></table></td></tr><tr><td nowrap><b>Sex</b></td><td nowrap><font size='2'>: "+((arrPatient[3]==null)?"":arrPatient[3])+"</font></td><td nowrap><b>"+getLabel("Common.age.label","Common")+"</b></td><td nowrap><font size='2'>: "+((arrPatient[2]==null)?"":arrPatient[2])+"</font></td></tr>";
		}

		header +="<th colspan='6'>&nbsp;</th>";
		
		var arguments	=	header;

		retVal = 	await window.showModalDialog("../../eMR/jsp/ViewMedicalReport.jsp?patientId="+patientId+"&request_id="+request_id+"&accession_num="+accession_num+"&episode_type="+episode_type+"&call_function="+call_function,arguments,features);
	}
}


function apply()
{
	var call_function = document.forms[0].call_function.value;
	if(call_function == "MEDICAL_REPORT_REQUEST")
	{
		var fields = new Array();
		fields[0] = parent.frames[2].document.forms[0].appl_type;
		fields[1] = parent.frames[2].document.forms[0].appln_date;
		fields[2] = parent.frames[2].document.forms[0].rep_type;
		fields[3] = parent.frames[2].document.forms[0].pract_desc;

		var names = new Array (	getLabel("eMR.ApplicationType.label","MR"), getLabel("eMR.ApplicationDateTime.label","MR"), getLabel("Common.ReportType.label","Common"), getLabel("eMR.RequestedPractitioner.label","MR"));

		if(checkMandatory( fields, names)) 
		{
			for(var i=0; i<parent.frames[2].document.forms[0].length;i++)
			{
				parent.frames[2].document.forms[0].elements(i).disabled = false;
			}

			var EncIDS = parent.frames[1].document.forms[0].encIDS.value;
			parent.frames[2].document.forms[0].EncounterIDS.value = EncIDS;
			
			parent.frames[2].document.forms[0].action = "../../servlet/eMR.MedRecRequestServlet";
			parent.frames[2].document.MedicalRecordReqForm.submit();
		}
	}
	else if(call_function == "MEDICAL_REPORT_STATUS")
	{
		var fields = new Array();
		fields[0] = parent.frames[2].document.forms[0].appl_status;

		if(parent.frames[2].document.getElementById("collectImg").style.visibility == "visible")
		{
			fields[1] = parent.frames[2].document.forms[0].collect_date;
			fields[2] = parent.frames[2].document.forms[0].pract_desc;
			var names = new Array (	getLabel("eMR.ApplicationStatus.label","MR"), getLabel("eMR.CollectDate.label","MR"), getLabel("eMR.RequestedPractitioner.label","MR"));
		}
		else
		{
			fields[1] = parent.frames[2].document.forms[0].pract_desc;
			var names = new Array (getLabel("eMR.ApplicationStatus.label","MR"), getLabel("eMR.RequestedPractitioner.label","MR"));
		}

		if(checkMandatory( fields, names)) 
		{
			for(var i=0; i<parent.frames[2].document.forms[0].length;i++)
			{
				parent.frames[2].document.forms[0].elements(i).disabled = false;
			}

			parent.frames[2].document.forms[0].action = "../../servlet/eMR.PrepareReportServlet";
			parent.frames[2].document.MedicalRecordReqForm.submit();
		}
	}
	else if(call_function == "FORWARD_MEDICAL_REPORT")
	{
		var fields = new Array();
		fields[0] = parent.frames[2].document.forms[0].fwd_pract_desc;
		var names = new Array (getLabel("eMR.ForwardedPractitioner.label","MR"));
		if(checkMandatory( fields, names)) 
		{
			parent.frames[2].document.forms[0].action = "../../servlet/eMR.PrepareReportServlet";
			parent.frames[2].document.MedicalRecordReqForm.submit();
		}
	}
	else if(call_function == "PREPARE_MEDICAL_REPORT")
	{
		var fields	= new Array(parent.frames[2].document.forms[0].prepare_date,parent.frames[2].document.forms[0].prep_pract_desc);
		var names	= new Array (getLabel("Common.PrepareDate.label","Common"),getLabel("eMR.PreparedbyPractitioner.label","MR"));
		if(checkMandatory( fields, names)) 
		{
			for(var i=0; i<parent.frames[2].document.forms[0].length;i++)
			{
				parent.frames[2].document.forms[0].elements(i).disabled = false;
			}
			parent.frames[2].document.forms[0].action = "../../servlet/eMR.PrepareReportServlet";
			parent.frames[2].document.MedicalRecordReqForm.submit();
		}
	}
	else if(call_function == "RECEIVE_MEDICAL_REPORT")
	{
		var fields	= new Array(parent.frames[2].document.forms[0].receive_date);
		var names	= new Array (getLabel("Common.ReceivedDate.label","Common"));
		if(checkMandatory( fields, names)) 
		{
			for(var i=0; i<parent.frames[2].document.forms[0].length;i++)
			{
				parent.frames[2].document.forms[0].elements(i).disabled = false;
			}
			parent.frames[2].document.forms[0].action = "../../servlet/eMR.PrepareReportServlet";
			parent.frames[2].document.MedicalRecordReqForm.submit();
		}
	}
	else if(call_function == "DELIVER_MEDICAL_REPORT")
	{
		var fields	= new Array(parent.frames[2].document.forms[0].delivered_date);
		var names	= new Array (getLabel("eMR.DeliveredDate.label","MR"));
			
		if(checkMandatory( fields, names)) 
		{
			for(var i=0; i<parent.frames[2].document.forms[0].length;i++)
			{
				parent.frames[2].document.forms[0].elements(i).disabled = false;
			}
			parent.frames[2].document.forms[0].action = "../../servlet/eMR.PrepareReportServlet";
			parent.frames[2].document.MedicalRecordReqForm.submit();
		}
	}
	else if(call_function == "REVISE_MEDICAL_REPORT")
	{
		var fields = new Array();
		fields[0] = parent.frames[2].document.forms[0].revised_collect_date;
		fields[1] = parent.frames[2].document.forms[0].authorised_by;
		var names = new Array (	getLabel("eMR.RevisedCollectDate.label","MR"), getLabel("Common.authorizedby.label","Common"));
		if(checkMandatory( fields, names)) 
		{
			parent.frames[2].document.forms[0].called_from.value='';
			if(parent.frames[2].document.forms[0].called_from.value=='')
			{					
				for(var i=0; i<parent.frames[2].document.forms[0].length;i++)
				{
					parent.frames[2].document.forms[0].elements(i).disabled = false;
				}
				
				parent.frames[2].document.forms[0].action = "../../servlet/eMR.MedRecRequestServlet";
				parent.frames[2].document.MedicalRecordReqForm.submit();
			}
		}
	}
}

function checkMandatory( fields, names)
	{
		var errors = "" ;
		for( var i=0; i<fields.length; i++ ) 
		{
			if(CheckVal(fields[i].value)) 
			{
			}
			else
			{
				errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(names[i]))+"\n";
			}
		}
		if ( errors.length != 0 )
		{
			alert(errors) ;
			return false ;
		}
		return true ;
	}


function CheckVal(inString)
	{
		var startPos;
		var ch;
		startPos = 0;
		strlength = inString.length;

		for(var i=0;i<=strlength;i++) {
			ch = inString.charAt(startPos);
			if((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
				startPos++;
			}
		}
		if(startPos == inString.length) return false;
		else return true;
	}

	
// added from DiagnosisQueryResult.jsp


	function chkMax(Obj)
{
	if(Obj.value.length >75)
	{
		var error = getMessage('REMARKS_XCEED_2000_CHARS','MR');
		error	= error.replace('2000','75');
		alert(error)
		Obj.focus();
	}
}

function Proceed()
{
	var j = document.forms[0].NumRecords.value;
	var formFields ="";
	for(var m=1; m<j; m++)
	{
		formFields += document.forms[0]["recodedCode" + m].name + "/" + document.forms[0]["recodedCode" + m].value;

	}
		document.forms[0].formFields.value = formFields;

		document.forms[0].action="../../servlet/eMR.DiagnosisRecodeServlet";
		document.forms[0].submit();
}


function getDiagnosis(obj,j)
{ 	
	var DiagCode = obj.value;
	if(DiagCode != '')
	{
		var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='diag_form' id='diag_form' method='post' action='../../eMR/jsp/MedRecRequestValidation.jsp?'><input type='hidden' name='DiagCode' id='DiagCode' value='"+DiagCode+"'><input type='hidden' name='j' id='j' value='"+j+"'><input type='hidden' name='Criteria' id='Criteria' value='getDiagnosis'></form></body></html>";
		parent.frames[2].document.write(HTMLVal)
		parent.frames[2].document.diag_form.submit();
	}
	else if(DiagCode == '')
	{
		eval("document.getElementById('Description')"+j).innerText="         ";
	}
}

async function show_window(j)
{
	var scheme = document.forms[0].scheme.value;
	var scheme_desc	= document.forms[0].scheme_desc.value;
	var Encounter_Id= document.forms[0].Encounter_Id.value;
	var p_auth_yn="N";

	if (scheme == 5)
	{
		var retVal = "test Value";
		var dialogHeight= "28vh" ;
		var dialogWidth = "43vw" ;
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
		var arguments   = "" ;
		retVal =await  window.showModalDialog("../../eCA/html/eCISLUE.html",arguments,features);

		var arr = new Array();
		arr = retVal.split("|");
		var stra = arr[0];
		var strc = arr[1];
		var strb = arr[2];

		eval("document.forms[0].recodedCode"+j).value=stra;
		eval("document.forms[0].Description"+j).value=strb;
	}

	if (scheme == 1 || scheme == 2)
	{
		var retVal =    new String();
		var dialogHeight= "27.22vh" ;
		var dialogWidth = "44vw" ;
		var status = "no";

		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	
		var cause_ind='';
		if(scheme=="2")
			cause_ind=document.forms[0].cause_ind.value

		retVal = await window.showModalDialog("PaintConsultationFrame.jsp?title="+scheme_desc+"&CodeList&p_diag_code="+scheme+"&p_diag_scheme_desc="+scheme_desc+"&Encounter_Id="+Encounter_Id+"&p_auth_yn="+p_auth_yn+"&cause_indicator=",arguments,features);
		
		if (!(retVal == null))
		{
			var retdata;
			if(scheme=="2")
			{
				retdata	= retVal.split("/") ;
				retVal	= retdata[0];
			}

			eval("document.forms[0].recodedCode"+j).value=retVal;
		}
		eval("document.forms[0].recodedCode"+j).focus();
	}
}


function RecodeTransDetail(obj,obj2)
{
	var call_function = 'TRANSMIT_NOTIFY_REP';
	var srl_no_val = obj.value;
	var pat_id = document.forms[0].PatientId.value;
	var Encounter_Id = document.forms[0].Encounter_Id.value;
	var diag_code = document.forms[0].diag_code.value;
	var diag_code_scheme_desc = document.forms[0].diag_code_scheme_desc.value;
	var DIAG_CODE_SCHEME = document.forms[0].DIAG_CODE_SCHEME.value;

	parent.frames[1].document.location.href ="../../eMR/jsp/DiagnosisTransmissionDetails.jsp?srl_no="+srl_no_val+"&patient_id="+pat_id+"&diag_code="+diag_code+"&diag_code_scheme="+DIAG_CODE_SCHEME+"&diag_code_scheme_desc="+diag_code_scheme_desc+"&Encounter_Id="+Encounter_Id+"&call_function="+call_function+"&recorded_date="+obj2+" ";
}

function RecodeConfDetail(obj)
{
	var call_function = 'CONF_TRANSMIT_NOTIFY_REP';
	var srl_no_val = obj.value;
	var pat_id = document.forms[0].PatientId.value;
	var Encounter_Id = document.forms[0].Encounter_Id.value;
	var diag_code = document.forms[0].diag_code.value;
	var diag_code_scheme_desc = document.forms[0].diag_code_scheme_desc.value;
	var DIAG_CODE_SCHEME = document.forms[0].DIAG_CODE_SCHEME.value;

	parent.frames[1].document.location.href ="../../eMR/jsp/DiagnosisTransmissionDetails.jsp?srl_no="+srl_no_val+"&patient_id="+pat_id+"&diag_code="+diag_code+"&diag_code_scheme="+DIAG_CODE_SCHEME+"&diag_code_scheme_desc="+diag_code_scheme_desc+"&Encounter_Id="+Encounter_Id+"&call_function="+call_function+" ";
}

// added from addModifyMarkEncounter.jsp

function beforeGetuser(target_id,target)
{
	if(target.name == 'marked_by')
	{
		if(document.forms[0].marked_by_hid.value != document.forms[0].marked_by.value)
		{
			if(document.forms[0].marked_by.value != "")
				 getuser(target_id,target);
		}
	}
	else if(target.name == 'closed_by')
	{
		if(document.forms[0].closed_by_hid.value != document.forms[0].closed_by.value)
		{
			if(document.forms[0].closed_by.value != "")
				 getuser(target_id,target);
		}
	}
}


async function getuser(target_id, target)
{
	var facility_id = document.forms[0].facility_id.value;
	var locale = document.forms[0].locale.value;
	var argumentArray=new Array(8);
	var title=getLabel("Common.user.label","Common");
 
	argumentArray[0]="select appl_user_id code, appl_user_name description from SM_APPL_USER_LANG_VW where LANGUAGE_ID ='"+locale+"' and EFF_STATUS like ? and upper(APPL_USER_ID) like upper(nvl(?,APPL_USER_ID)) and upper(APPL_USER_NAME) like upper(nvl(?,APPL_USER_NAME)) ";

	argumentArray[1]=new Array("EFF_STATUS");
	argumentArray[2]=new Array("E");
	argumentArray[3]=new Array(STRING,STRING);
	argumentArray[4]="2,3";
	argumentArray[5]=target.value;
	argumentArray[6]=CODE_DESC_LINK;
	argumentArray[7]=CODE_DESC;

			
	var retVal= await CommonLookup(title,argumentArray);
	
	var ret1=unescape(retVal);
	arr=ret1.split(",");
	if(retVal != null && retVal != "" )
	{
		
		if(target.name == 'marked_by')
		{
			document.forms[0].marked_by_hid.value	=	arr[0];		
			document.forms[0].marked_by.value		=	arr[1];
		}
		else
		{
			document.forms[0].closed_by_hid.value	=	arr[0];
			document.forms[0].closed_by.value		=	arr[1];
		}
	}
	else
	{
		nationality_code.value = arr[0]; 
		nationality_desc.value = arr[1]; 
		desc.value=arr[1];
		code.value=arr[0];
		if(target.name == 'marked_by')
		{
			document.forms[0].marked_by_hid.value	= "";
			document.forms[0].marked_by.value		= "";
		}
		else if(target.name == 'closed_by')
		{
			document.forms[0].closed_by_hid.value	= "";
			document.forms[0].closed_by.value	= "";
		}
	}
}

function closeWindow()
	{
		//window.close();
	const dialogTag = parent.parent.document.getElementById("dialog_tag");
	dialogTag.close();
	}

	function submitPage1()
	{
		if(document.forms[0].isMLCAppl.value == 'false'){
		if (document.forms[0].mlc.checked==true)
		{
			if(!document.forms[0].mlc.disabled)//to tisable prompt when the mlc_yn is already Y through some other function.
			{
				if (document.forms[0].marked_by.value=='')
				{
					var str = getMessage("CAN_NOT_BE_BLANK",'Common');
					str = str.replace('$',getLabel("Common.MarkedBy.label","Common"));
					alert(str);		
					return;
				}
				if (document.forms[0].marked_date.value=='')
				{
					var str = getMessage("CAN_NOT_BE_BLANK",'Common');
					str = str.replace('$',getLabel("Common.MarkedDate.label","Common"));
					alert(str);		
					return;
				}
			}
			if (document.forms[0].mlc_yn_temp.value=='Y')
			{
				if (document.forms[0].closed_by.value=='')
				{
					var str = getMessage("CAN_NOT_BE_BLANK",'Common');
					str = str.replace('$',getLabel("eMR.ClosedBy.label","MR"));
					alert(str);		
					return;
				}
				if (document.forms[0].closed_date.value=='')
				{
					var str = getMessage("CAN_NOT_BE_BLANK",'Common');
					str = str.replace('$',getLabel("eMR.ClosedDate.label","MR"));
					alert(str);		
					return;
				}
			}
		}
		if (document.forms[0].oscc.checked==true)
		{
			if (document.forms[0].marked_by.value=='')
			{
				var str = getMessage("CAN_NOT_BE_BLANK",'Common');
				str = str.replace('$',getLabel("Common.MarkedBy.label","Common"));
				alert(str);		
				return;
			}
			if (document.forms[0].marked_date.value=='')
			{
				var str = getMessage("CAN_NOT_BE_BLANK",'Common');
				str = str.replace('$',getLabel("Common.MarkedDate.label","Common"));
				alert(str);		
				return;
			}
			if((document.forms[0].mlc_yn_temp.value!='N')||(document.forms[0].oscc_yn_temp.value!='N'))
			{
				if (document.forms[0].closed_by.value=='')
				{
					var str = getMessage("CAN_NOT_BE_BLANK",'Common');
					str = str.replace('$',getLabel("eMR.ClosedBy.label","MR"));
					alert(str);		
					return;
				}
				if (document.forms[0].closed_date.value=='')
				{
					var str = getMessage("CAN_NOT_BE_BLANK",'Common');
					str = str.replace('$',getLabel("eMR.ClosedDate.label","MR"));
					alert(str);		
					return;
				}
			}
		}
		}
		document.forms[0].mlc.disabled=false;
		document.forms[0].oscc.disabled=false;
		if (document.forms[0].mlc.checked==true)
		{document.forms[0].mlc.value='Y';}

		if (document.forms[0].oscc.checked==true) 
			{ document.forms[0].oscc.value='Y';}

		if(document.forms[0].isMLCAppl.value == 'false'){
		document.forms[0].marked_by.disabled=false;
		document.forms[0].marked_date.disabled=false;
		}else{
			document.forms[0].record_button.disabled = true;
		}
	//	alert("2161");
		console.log(document.forms[0]);
		document.forms[0].action="../../servlet/eMR.MarkEncounterServlet";
		document.forms[0].target = "messageFrame";
		document.forms[0].submit();
	}


function compareDates0(obj)
{
	/*if(!doDateCheckAlert(document.forms[0].marked_date,document.forms[0].closed_date))
		{
			var str = getMessage("MRDATE1_LT_DATE2",'MR');
			str = str.replace('$',getLabel("eMR.ClosedDate.label","MR"));
			str = str.replace('#',getLabel("Common.MarkedDate.label","Common"));
			alert(str);			
			document.forms[0].closed_date.select();
			document.forms[0].closed_date.focus();
		}*/

		/*Added by Ashwini on 16-Jul-2018 for ML-MMOH-CRF-1140*/
		var isDateTimeAppl = document.forms[0].isDateTimeAppl.value;

		if(isDateTimeAppl == 'true')
		{
			var dateFormat = 'DMYHM';
		}else
		{
			var dateFormat = 'DMY';
		}
		/*End ML-MMOH-CRF-1140*/

		if(document.forms[0].marked_date.value!='' && document.forms[0].closed_date.value!='')
		{
			var greg_MarkedDate = convertDate(document.forms[0].marked_date.value,dateFormat,localeName,'en');
			var greg_ClosedDate = convertDate(document.forms[0].closed_date.value,dateFormat,localeName,'en');
			
			//if(isBefore(greg_ClosedDate,greg_MarkedDate,'DMY','en'))
			if(!isAfter(greg_ClosedDate,greg_MarkedDate,dateFormat,'en'))
			{
				
				var str = getMessage("MRDATE1_LT_DATE2",'MR');
				/*Modified by Ashwini on 16-Jul-2018 for ML-MMOH-CRF-1140*/
				if(isDateTimeAppl == 'true')
				{
					str = str.replace('$',getLabel("eMR.ClosedDate.label","MR")+"/"+getLabel("Common.time.label","Common"));
					str = str.replace('#',getLabel("Common.MarkedDate.label","Common")+"/"+getLabel("Common.time.label","Common"));
				}else
				{
					str = str.replace('$',getLabel("eMR.ClosedDate.label","MR"));
					str = str.replace('#',getLabel("Common.MarkedDate.label","Common"));
				}

				alert(str);			
				document.forms[0].closed_date.select();
				document.forms[0].closed_date.focus();
				return false;
			}
		}
}

function compareDates1(obj)//function to compare closed date with system date
{

	
	/*var dtVal=document.forms[0].closed_date.value;		
	var hddDTTM=document.forms[0].sys_date.value;		
	if(!doDateCheckAlert(document.forms[0].closed_date,document.forms[0].sys_date)) 
		{	
			var str = getMessage("MRDATE1_GT_DATE2",'MR');
			str = str.replace('$',getLabel("eMR.ClosedDate.label","MR"));
			str = str.replace('#',getLabel("Common.SystemDate.label","Common"));
			alert(str);		
			document.forms[0].closed_date.value='';	
			document.forms[0].closed_date.focus();			
		}*/

		/*Added by Ashwini on 16-Jul-2018 for ML-MMOH-CRF-1140*/
		var isDateTimeAppl = document.forms[0].isDateTimeAppl.value;

		if(isDateTimeAppl == 'true')
		{
			var dateFormat = 'DMYHM';
		}else
		{
			var dateFormat = 'DMY';
		}
		/*End ML-MMOH-CRF-1140*/

		if(!validDateObj(obj,dateFormat,localeName))
			return false;
		else
		{
			var greg_ClosedDate = convertDate(obj.value,dateFormat,localeName,'en');
	
			if(!isBeforeNow(greg_ClosedDate,dateFormat,'en'))
			{	
					var str = getMessage("MRDATE1_GT_DATE2",'MR');

					/*Modified by Ashwini on 16-Jul-2018 for ML-MMOH-CRF-1140*/
					if(isDateTimeAppl == 'true')
					{
						str = str.replace('$',getLabel("eMR.ClosedDate.label","MR")+"/"+getLabel("Common.time.label","Common"));
						str = str.replace('#',getLabel("Common.SystemDate.label","Common")+"/"+getLabel("Common.time.label","Common"));
					}else
					{
						str = str.replace('$',getLabel("eMR.ClosedDate.label","MR"));
						str = str.replace('#',getLabel("Common.SystemDate.label","Common"));
					}
					
					//alert(str);		
					document.forms[0].closed_date.value='';	
					document.forms[0].closed_date.focus();	
					return false;
			}

			compareDates0(obj);
			
		}
}


function date_Validate(obj){
	

	var dtVal=document.forms[0].marked_date.value;	

	/*Added by Ashwini on 16-Jul-2018 for ML-MMOH-CRF-1140*/
	var isDateTimeAppl = document.forms[0].isDateTimeAppl.value;

	if(isDateTimeAppl == 'true')
	{
		var dateFormat = 'DMYHM';
	}else
	{
		var dateFormat = 'DMY';
	}
	/*End ML-MMOH-CRF-1140*/
	
	//var hddDTTM=document.forms[0].sys_date.value;	

	var t1 = document.forms[0].mlc_yn_temp.value; //check for values already entered
	if (t1=='N')
	{
		/*if(!doDateCheckAlert(document.forms[0].marked_date,document.forms[0].sys_date)) {	
				var str = getMessage("MRDATE1_GT_DATE2",'MR');
				str = str.replace('$',getLabel("Common.MarkedDate.label","Common"));
				str = str.replace('#',getLabel("Common.SystemDate.label","Common"));
				alert(str);							
				document.forms[0].marked_date.value='';	
				document.forms[0].marked_date.focus();			
		}*/
		
		if(!validDateObj(obj,dateFormat,localeName))
			return false;
		else
		{
			var greg_MarkedDate = convertDate(obj.value,dateFormat,localeName,'en');
			var encounter_date	= document.forms[0].encounter_date.value;
			
			//Added by Ashwini on 16-Jul-2018 for ML-MMOH-CRF-1140
			if(isDateTimeAppl == 'true')
			{
				encounter_date = encounter_date.replace('$',' ');
			}

			if(!isAfter(greg_MarkedDate,encounter_date,dateFormat,'en'))
			{
				var str = getMessage("MRDATE1_LT_DATE2",'MR');

				/*Modified by Ashwini on 16-Jul-2018 for ML-MMOH-CRF-1140*/
				if(isDateTimeAppl == 'true')
				{
					str = str.replace('$',getLabel("Common.MarkedDate.label","Common")+"/"+getLabel("Common.time.label","Common"));
					str = str.replace('#',getLabel("Common.encounterdate.label","Common")+"/"+getLabel("Common.time.label","Common"));
				}else
				{
					str = str.replace('$',getLabel("Common.MarkedDate.label","Common"));
					str = str.replace('#',getLabel("Common.encounterdate.label","Common"));
				}
				/*End ML-MMOH-CRF-1140*/

				alert(str);							
				document.forms[0].marked_date.value='';	
				document.forms[0].marked_date.focus();	
				return false;
			}

			if(!isBeforeNow(greg_MarkedDate,dateFormat,'en'))
			{
				var str = getMessage("MRDATE1_GT_DATE2",'MR');

				/*Modified by Ashwini on 16-Jul-2018 for ML-MMOH-CRF-1140*/
				if(isDateTimeAppl == 'true')
				{
					str = str.replace('$',getLabel("Common.MarkedDate.label","Common")+"/"+getLabel("Common.time.label","Common"));
					str = str.replace('#',getLabel("Common.SystemDate.label","Common")+"/"+getLabel("Common.time.label","Common"));
				}else
				{
					str = str.replace('$',getLabel("Common.MarkedDate.label","Common"));
					str = str.replace('#',getLabel("Common.SystemDate.label","Common"));
				}
				/*End ML-MMOH-CRF-1140*/

				alert(str);							
				document.forms[0].marked_date.value='';	
				document.forms[0].marked_date.focus();	
				return false;
			}
			
			compareDates0(obj);
			
		}
		
	}
	
}


function setvalue(obj)
{
	if(obj.checked)
	{
		obj.value='Y';	
		if(document.forms[0].isMLCAppl.value == 'false'){
		document.forms[0].marked_by.disabled=false;
		document.forms[0].marked_date.disabled=false;
		document.getElementById("cal1").disabled=false;	 
		//document.forms[0].record_button.disabled=false;

		document.forms[0].search_user.disabled=false;
		}
			document.forms[0].record_button.disabled=false;
	}
	else 
	{
		obj.value='N';	
		if(document.forms[0].oscc.checked==false && document.forms[0].mlc.checked==false)
		{
			if(document.forms[0].isMLCAppl.value == 'false'){
			document.forms[0].marked_by.disabled=true;
			document.forms[0].marked_date.disabled=true;
			document.getElementById("cal1").disabled=true;		
			document.forms[0].search_user.disabled=false;
			}
			document.forms[0].record_button.disabled=true;

		}
		
	}
}


function setImg()
{
	if(document.forms[0].isMLCAppl.value == 'false'){
	if (document.forms[0].mlc.checked==true||document.forms[0].oscc.checked==true)
	{
		document.forms[0].mlc.value='Y'; 
		if (document.forms[0].mlc_yn_temp.value=='N')
		{document.getElementById("img1").style.visibility='visible';
		document.getElementById("img2").style.visibility='visible';}
	}
	else
	{document.getElementById("img1").style.visibility='hidden';
	 document.getElementById("img2").style.visibility='hidden';
	}
	
	if (document.forms[0].oscc.checked==true) 
		{ document.forms[0].oscc.value='Y';
		  if ((document.forms[0].mlc_yn_temp.value!='N')||(document.forms[0].oscc_yn_temp.value!='N'))
			{
			  document.getElementById("img3").style.visibility='visible';		  document.getElementById("img4").style.visibility='visible';
			}
			else {document.getElementById("img3").style.visibility='hidden';
	 	  document.getElementById("img4").style.visibility='hidden';}
		}
	
	}
}

//added from DiagnosisQueryDetail.jsp

function apply1()
{
	var t1 = document.forms[0].recode.value;
	if (document.forms[0].recode.value==''||document.forms[0].recode.value==' ')
	{
		var str = getMessage("CAN_NOT_BE_BLANK",'Common');
		str = str.replace('$',getLabel("eMR.Recode.label","MR"));
		alert(str);		
		return;
	}
	document.diagnosis_recode.submit();
}

function getDiagnosis1(obj)
{ 	
	var DiagCode = obj.value;
	if(DiagCode != '')
	{
		var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='diag_form' id='diag_form' method='post' action='../../eMR/jsp/MedRecRequestValidation.jsp'><input type='hidden' name='DiagCode' id='DiagCode' value='"+DiagCode+"'><input type='hidden' name='Criteria' id='Criteria' value='getDiagnosis1'></form></body></html>";
		parent.frames[2].document.write(HTMLVal)
		parent.frames[2].document.diag_form.submit();
	}
	else
	{
		document.forms[0].record.disabled=true;
	}
}


async function show_window1(scheme)
{

	var s = document.diagnosis_recode.scheme.value;
	var scheme_desc= document.diagnosis_recode.scheme_desc.value; 
	var Encounter_Id= document.diagnosis_recode.Encounter_Id.value ;

   var  p_auth_yn="N";

	if (s == 5)
	{
		var retVal = "test Value";
		var dialogHeight= "28vh" ;
		var dialogWidth = "43vw" ;
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
		var arguments   = "" ;
		retVal = await window.showModalDialog("../../eCA/html/eCISLUE.html",arguments,features);

		var arr = new Array();
		arr = retVal.split("|");
		var stra = arr[0];
		var strc = arr[1];
		var strb = arr[2];

		document.diagnosis_recode.recode.value       = stra;
		document.diagnosis_recode.Recoded_Description.value  = strb;
		document.diagnosis_recode.term_id.value      = strc;

	}
	if (s == 1 || s == 2)
	{
		var retVal =    new String();
		var dialogHeight= "27.22vh" ;
		var dialogWidth = "44vw" ;
		var status = "no";

		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	
		var cause_ind='';
		if(scheme=="2")
			cause_ind=document.forms[0].cause_ind.value

		retVal = await window.showModalDialog("PaintConsultationFrame.jsp?title="+scheme_desc+" Code List&p_diag_code="+s+"&p_diag_scheme_desc="+scheme_desc+"&Encounter_Id="+Encounter_Id+"&p_auth_yn="+p_auth_yn+"&cause_indicator=",arguments,features);
		if (!(retVal == null))
		{
			var retdata;
			if(scheme=="2")
			{
			 retdata=retVal.split("/") ;
			retVal=retdata[0];

			if(retdata[1]==document.forms[0].cause_ind.options[1].value)
					document.forms[0].cause_ind.options[1].selected=true;
			}
			document.diagnosis_recode.recode.value=retVal;
		}
			document.diagnosis_recode.recode.focus();
	}
}

function valid_ch(event){
		var strCheck = '0123456789.+-*abcdefghijlkmnopqrstuvwxyzABCDEFGHIJLKMNOPQRSTUVWXYZ';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  // Get key value from key code
		if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	}


// added from DiagnosisTransmissionDetails.jsp


function submitPage2()
{
	if(document.forms[0].transmission_name.value=='')
	{
		if (document.forms[0].trm_name.value=='')
		{
			var str = getMessage("CAN_NOT_BE_BLANK",'Common');
			str = str.replace('$',getLabel("eMR.TransmissionName.label","MR"));
			alert(str);		
			return;
		}			
		if (document.forms[0].trm_datetime.value=='')
		{
			var str = getMessage("CAN_NOT_BE_BLANK",'Common');
			str = str.replace('$',getLabel("eMR.TransmissionDateTime.label","MR"));
			alert(str);		
			return;
		}

		if (document.forms[0].trm_location.value=='')
		{
			var str = getMessage("CAN_NOT_BE_BLANK",'Common');
			str = str.replace('$',getLabel("Common.Location.label","Common"));
			alert(str);		
			return;
		}
	}
	if(document.forms[0].confirmatin_name.value==''&&document.forms[0].transmission_name.value!='')
	{		    
		if (document.forms[0].com_name.value=='')
		{
			var str = getMessage("CAN_NOT_BE_BLANK",'Common');
			str = str.replace('$',getLabel("eMR.CommunicationName.label","MR"));
			alert(str);		
			return;
		}
		if (document.forms[0].com_desig.value=='')
		{
			var str = getMessage("CAN_NOT_BE_BLANK",'Common');
			str = str.replace('$',getLabel("Common.designation.label","Common"));
			alert(str);		
			return;
		}
		if (document.forms[0].conf_datetime.value=='')
		{
			var str = getMessage("CAN_NOT_BE_BLANK",'Common');
			str = str.replace('$',getLabel("eMR.AckDateTime.label","MR"));
			alert(str);		
			return;
		}
		
	}
	
	var operation = document.forms[0].operation.value;
	if(operation=='insert'){	
		document.forms[0].action="../../servlet/eMR.DiagTransmissionServlet"; 
		document.forms[0].target="messageFrame";
		document.markencounter_Form.submit();
	}
	
}

// Functions added for Buddhish date validation	

function compareWithRcdate(obj)
{
	
	var ar = obj.value.split(" ");
	var dtVal= ar[0];
	var hddDTTM=document.forms[0].recorded_date.value;		

	if(obj.value!='')
	{
		if(validDate(obj.value,"DMYHM",localeName))
		{	
			if(dtVal!='' && hddDTTM!='')
			{
				var recorded_date1 = convertDate(hddDTTM,"DMY",localeName,"en");
				var obj1 = convertDate(dtVal,"DMY",localeName,"en");
				
				if(!isBefore(recorded_date1,obj1,'DMY',localeName))
				{
					var str = getMessage("MRDATE1_LT_DATE2",'MR');
					str = str.replace('$',getLabel("Common.datetime.label","Common"));
					str = str.replace('#',getLabel("Common.recordeddate.label","Common"));
					alert(str);
					obj.value='';
					obj.focus();
				}
			}
		}
		/*else
		{
			if(obj.id=='confdatetime')
			{
				return false;
			}
			else
			{
				var str = getMessage("INVALID_DATE_TIME",'SM');
				alert(str);
				obj.value='';
			}
		}*/
	}
}

function compareWithSysDt(obj){
	
	var dtVal=obj.value;	
	var hddDTTM=document.forms[0].sys_date.value;
	// coe added for 21569
	if(hddDTTM==''){
		
		var dttm = getCurrentDate('DMYHM' ,localeName);	
		hddDTTM=dttm;
	}
	
	if(obj.value!='')
	{
		if(validDate(dtVal,"DMYHM",localeName))
		{	
			if(dtVal !='' && hddDTTM !='')
			{
				//var sys_date1 = convertDate(hddDTTM,"DMYHM",localeName,"en");
				//var obj1 = convertDate(dtVal,"DMYHM",localeName,"en");
				
				if(!isBeforeNow(dtVal,"DMYHM",localeName))
				{
					var str = getMessage("MRDATE1_GT_DATE2",'MR');
					str = str.replace('$',getLabel("Common.datetime.label","Common"));
					str = str.replace('#',getLabel("Common.SystemDate.label","Common"));
					alert(str);	
					obj.value='';	
					obj.focus();	
				}
			}
		}
		/*else
		{
			if(obj.id=='confdatetime')
			{
				return false;
			}
			else
			{
				var str = getMessage("INVALID_DATE_TIME",'SM');
				alert(str);
				obj.value='';
			}
		}*/
	}
}

function chkDates(obj)
{
	var continue_YN = "Y";
	
	if(obj.value != "")
	{
			if( validDate(obj.value,"DMYHM",localeName) == false )
			{
				continue_YN = "N";	
				alert( getMessage("INVALID_DATE_TIME",'SM') );
				obj.select();
				return false;
			}
			else if (continue_YN == "Y")
			{
				if(document.forms[0].trm_datetime.value!='' && document.forms[0].conf_datetime.value!='')
				{
					var trm_datetime1 = document.forms[0].trm_datetime.value;
					var conf_datetime1 = document.forms[0].conf_datetime.value;
					if( isBefore(trm_datetime1,conf_datetime1,"DMYHM",localeName) == false )
					{
							var str = getMessage("MRDATE1_LT_DATE2",'MR');
							str = str.replace('$',getLabel("eMR.AckDateTime.label","MR"));
							str = str.replace('#',getLabel("eMR.TransmissionDateTime.label","MR"));
							alert(str);	
							document.forms[0].conf_datetime.select();
							document.forms[0].conf_datetime.focus();
					}
				}
			}
	}
}

// End of Buddhish date validation fns 

function compareDates2(obj)
{
	var continue_YN = "Y";
	if(obj.value!='')
	{
		var a=obj.value.split(" ")
		splitdate=a[0];
		if(!CheckZeroMonths(splitdate))
		{
			continue_YN = "N";
			alert( getMessage("INVALID_DATE_TIME",'SM') );
			obj.focus();
			obj.select();
			return false;
		}


		if(doDateTimeChk(obj) && continue_YN == "Y")
		{
			if(document.forms[0].trm_datetime.value!='' && document.forms[0].conf_datetime.value!='')
			{
				if(!ValidateDateTime(document.forms[0].trm_datetime,document.forms[0].conf_datetime))
				{
					var str = getMessage("MRDATE1_LT_DATE2",'MR');
					str = str.replace('$',getLabel("eMR.AckDateTime.label","MR"));
					str = str.replace('#',getLabel("eMR.TransmissionDateTime.label","MR"));
					alert(str);	
					document.forms[0].conf_datetime.select();
					document.forms[0].conf_datetime.focus();
				}
			}
/*			else
				date_Validate1(this);Validate_withRcdate(this)*/
		}
	}
}

function CheckZeroMonths(Object2) 
{
	var datefield = Object2;
    if (MonthChk(Object2) == false) 
	{
        return false;
    }
    else 
	{
        return true;
    }
}


function MonthChk(Object3) 
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


function Validate_withRcdate(obj)
{
	
	var dtVal=obj.value;	
	var hddDTTM=document.forms[0].recorded_date.value;	
	if(obj.value!='')
	{
		if(doDateTimeChk(obj))
		{	
			if(obj.value!='' && document.forms[0].recorded_date.value!='')
			{
				if(!ValidateDateTime(document.forms[0].recorded_date,obj))
				{
					var str = getMessage("MRDATE1_LT_DATE2",'MR');
					str = str.replace('$',getLabel("Common.datetime.label","Common"));
					str = str.replace('#',getLabel("Common.recordeddate.label","Common"));
					alert(str);
					obj.value='';
					obj.focus();
				}
			}
		}
		else
		{
			if(obj.id=='confdatetime')
			{
				return false;
			}
			else
			{
				var str = getMessage("INVALID_DATE_TIME",'SM');
				alert(str);
				obj.value='';
			}
		}
	}
}

function date_Validate1(obj){
	
	var dtVal=obj.value;	
	
	var hddDTTM=document.forms[0].sys_date.value;	
	if(obj.value!='')
	{
	if(doDateTimeChk(obj))
	{	
	if(obj.value!='' && document.forms[0].sys_date.value!='')
	{
	if(!ValidateDateTime(obj,document.forms[0].sys_date))
		{
			var str = getMessage("MRDATE1_GT_DATE2",'MR');
			str = str.replace('$',getLabel("Common.datetime.label","Common"));
			str = str.replace('#',getLabel("Common.SystemDate.label","Common"));
			alert(str);	
			obj.value='';	
			obj.focus();	
		}
	}
	}
	else
		{
			if(obj.id=='confdatetime')
			{
				return false;
			}
			else
			{
				var str = getMessage("INVALID_DATE_TIME",'SM');
				alert(str);
				obj.value='';
			}
		}
	}
}

function setvalue1(obj)
{
 if(obj.checked)
	{
	 obj.value='Y';	
	}
else obj.value='N';	
}

// added from MedicalRequestorAddress.jsp

async function searchCountry(obj,target)
{
	var locale = document.forms[0].locale.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";				
	if(obj.name=="contry_code" || obj.name=="country_desc")
	{
		if(target.name=="country_desc")
		{
			tit = getLabel("Common.country.label.label","Common");
			sql = "Select country_code code, short_name description from MP_COUNTRY_LANG_VW where language_id ='"+locale+"' and eff_status='E' and upper(country_code) like upper(?) and upper(short_name) like upper(?) and eff_status = 'E'";
		}
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
		if(target.name == 'country_desc')
		document.forms[0].country_desc.value= arr[1];
		document.forms[0].country_code.value=arr[0];
	}
	else
	{
		target.value='';
	}
}


function CloseME1()
{
	var condition = '';

	if(document.forms[0].r_addr_line1)
		condition += document.forms[0].r_addr_line1.value +"~";
	else
		condition += ""+"~";

	if(document.forms[0].r_addr_line2)
		condition += document.forms[0].r_addr_line2.value +"~";
	else
		condition += ""+"~";

	if(document.forms[0].r_addr_line3)
		condition += document.forms[0].r_addr_line3.value +"~";
	else
		condition += ""+"~";

	if(document.forms[0].r_addr_line4)
		condition += document.forms[0].r_addr_line4.value +"~";
	else
		condition += ""+"~";

	if(document.forms[0].r_town_code)
	{
		condition += document.forms[0].r_town_code.value +"~";
		condition += document.forms[0].r_town.value +"~";
	}
	else
	{
		condition += ""+"~";
		condition += ""+"~";
	}

	if(document.forms[0].r_area_code)
	{	
		condition += document.forms[0].r_area_code.value +"~";
		condition += document.forms[0].r_area.value +"~";
	}
	else
	{
		condition += ""+"~";
		condition += ""+"~";
	}

	if(document.forms[0].r_region_code)
	{
		condition += document.forms[0].r_region_code.value +"~";
		condition += document.forms[0].r_region.value +"~";
	}
	else
	{
		condition += ""+"~";
		condition += ""+"~";
	}
	
	if(document.forms[0].r_postal_code)
	{
		condition += document.forms[0].r_postal_code.value +"~";
		condition += document.forms[0].r_postal.value +"~";
	}
	else
	{
		condition += ""+"~";
		condition += ""+"~";
	}

		condition += document.forms[0].country_desc.value +"~";
		condition += document.forms[0].country_code.value +"~";

	window.returnValue=condition;
	window.close();
}

// added from MedRecRequestCriteria.jsp

function ComparePeriodFromToTime(from,to)
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
			if(!CheckZeroMonths1(splitdate))
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
			if(!CheckZeroMonths1(splitdate))
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
			PeriodcheckDateTime(frdt,tdt);
		}
		else
			return ;
	}

}


function CheckZeroMonths1(Object2) 
{
	var datefield = Object2;
    if (MonthChk1(Object2) == false) 
	{
        return false;
    }
    else 
	{
        return true;
    }
}




function MonthChk1(Object3) 
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


function PeriodcheckDateTime(obj1,obj2)
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


function clearAll1()
{	
	//document.forms[0].reset();
	parent.frames[2].document.location.href ='../../eCommon/html/blank.html';
	if(parent.frames[3])
	parent.frames[3].document.location.reload();
	if(parent.messageFrame)
	parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
			
}

async function callSearchScreen()
{
	var patientid=await PatientSearch('','','','','','','Y','','','VIEW');
	
		if(patientid !=null)
		document.forms[0].PatientId.value = patientid; 
		document.forms[0].PatientId.focus();
	
}

function CheckNumVal(obj)
{
	if (parseInt(obj.value) <= 0)
	{
		alert(getMessage('IP_VAL_NOT_LESS_ZERO','IP'));
		obj.select();
	}
	else
	{
		CheckNum(obj);
	}
}

function sendtomain(encid){
			parent.window.returnValue=encid;
			//parent.window.close();  
	
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();
    
			}


//function for MedRecRequestRecordHeader.jsp	
function displayCurEncDetail(admission_date_time,practitioner_name,specialty_short_desc,encounter_id,admission_type_short_desc,patient_type_short_desc,patientId)
{
	var facility_name;
	var admission_date_time;
	var practitioner_name; 
	var specialty_short_desc;
	var encounter_id;
	var admission_type_short_desc; 
	var  patient_type_short_desc;
	var temp="admission_date_time="+admission_date_time+"&practitioner_name="+practitioner_name+"&specialty_short_desc="+specialty_short_desc+"&encounter_id="+encounter_id+"&admission_type_short_desc="+admission_type_short_desc+"&patient_type_short_desc="+patient_type_short_desc;
	parent.frames[2].location.href="../jsp/LastAdmissionResult.jsp?encounter_id='"+encounter_id+"'&patientId='"+patientId+"'";	

}
//Added by Ajay Hatwate for GHL-CRF-0650
function enableOthMlcFlds(obj){
	
	if(obj.checked){
	obj.value = 'Y';

	document.forms[0].mlc_death.disabled = false;
	document.forms[0].police_rep_no.disabled = false;
	document.forms[0].police_stn_dtls.disabled = false;
	document.forms[0].outside_mlc_dtls.disabled = false;
	document.forms[0].date_of_mlc_capture.disabled = false;

	if(document.forms[0].date_of_mlc_capture.value == ''){
		document.forms[0].date_of_mlc_capture.value = getCurrentDate("DMYHMS","en");
	}
	document.forms[0].mlc_remarks.disabled = false;
	
	
	}else{
		obj.value = 'N';
		document.forms[0].mlc_death.disabled = true;
		document.forms[0].mlc_death.value = 'N';
		document.forms[0].mlc_death.checked = false;
		
		document.forms[0].police_rep_no.disabled = true;
		document.forms[0].police_rep_no.value = '';
		document.forms[0].police_stn_dtls.disabled = true;
		document.forms[0].police_stn_dtls.value = '';
		document.forms[0].outside_mlc_dtls.disabled = true;
		document.forms[0].outside_mlc_dtls.value = '';
		document.forms[0].date_of_mlc_capture.disabled = true;
		document.forms[0].date_of_mlc_capture.value = '';
		document.forms[0].mlc_remarks.disabled = true;	
		document.forms[0].mlc_remarks.value = '';	
	}
}
function updateSelf(Obj){
	if(Obj.checked){
		Obj.value = 'Y';
	}else{
		Obj.value = 'N';
	}
}
function validateMlcCapture(obj){
	var fromDate = document.forms[0].visit_date_time.value;
	var toDate ='';
	fromDate = fromDate.replace('$', ' ');
	toDate = getCurrentDate("DMYHMS","en");
	if(obj.value!=''){
			if(!isBetween(fromDate, toDate, obj.value, "DMYHMS", "en")){
				obj.value = "";
				alert(getMessage("MLC_CAPTURE_DATE_CANNOT_FUTURE",'AE'));
				obj.select();
			}
	}
}
function maxLengthPaste(field,maxChars)
{
      event.returnValue=false;
      if((field.value.length +  window.clipboardData.getData("Text").length) > maxChars) {	 
	     var errors1 = getMessage('OBJ_CANNOT_EXCEED','Common');
		errors1 = errors1.replace('$', maxChars);		  
		  alert(errors1);  
	    return false;
      }
      event.returnValue=true;
}

