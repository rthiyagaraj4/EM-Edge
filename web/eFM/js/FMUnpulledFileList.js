function run()
{

var function_id=searchResultFrame.document.getElementById("function_id").value;

  var error="";


  if (searchResultFrame.document.forms[0].p_src_fs_locn_code.value==""){
	 error = getMessage("CAN_NOT_BE_BLANK","Common");
	 error = error.replace("$",getLabel('eFM.FSLocation.label','FM'));
	 error = error +"<br>";
	}
	if(function_id == "FM_UNPULLED_FILES_FOR_BKG")
	{
	  if (searchResultFrame.document.forms[0].p_booking_date.value==""){
		 var error1 = getMessage("CAN_NOT_BE_BLANK","Common");
		 error1 = error1.replace("$",getLabel('Common.BookingDate.label','common'));
		 error = error + error1
		}

				 if (error=="")
		   {
			  if( searchResultFrame.CheckString(getLabel('Common.ClinicCode.label','common') , searchResultFrame.document.forms[0].p_fm_nursing_unit_code,searchResultFrame.document.forms[0].p_to_nursing_unit_code, messageFrame )  )
			  if( searchResultFrame.CheckString( getLabel('Common.practitionerid.label','common'), searchResultFrame.document.forms[0].p_fm_pract_id,searchResultFrame.document.forms[0].p_to_pract_id, messageFrame )  )
				  searchResultFrame.document.forms[0].action = "../../eCommon/jsp/report_options.jsp";
				  searchResultFrame.document.forms[0].target = "messageFrame";
				  searchResultFrame.document.forms[0].submit(); 

		   }
		   else
			 messageFrame.location.href = '../../eCommon/jsp/error.jsp?err_num='+error;
	}
	else
	{
		 if (searchResultFrame.document.forms[0].p_appt_date.value==""){
		 var error1 = getMessage("CAN_NOT_BE_BLANK","Common");
		 error1 = error1.replace("$",getLabel('Common.AppointmentDate.label','Common'));
		 error = error + error1
		}
		 
		 if (error=="")
		   {
			  if( searchResultFrame.CheckString(getLabel('Common.ClinicCode.label','common') , searchResultFrame.document.forms[0].p_fm_clinic_code,searchResultFrame.document.forms[0].p_to_clinic_code, messageFrame )  )
			  if( searchResultFrame.CheckString( getLabel('Common.practitionerid.label','common'), searchResultFrame.document.forms[0].p_fm_pract_id,searchResultFrame.document.forms[0].p_to_pract_id, messageFrame )  )
				  searchResultFrame.document.forms[0].action = "../../eCommon/jsp/report_options.jsp";
				  searchResultFrame.document.forms[0].target = "messageFrame";
				  searchResultFrame.document.forms[0].submit(); 

		   }
		   else
			 messageFrame.location.href = '../../eCommon/jsp/error.jsp?err_num='+error;

	}

   
}

function reset()
{
searchResultFrame.document.forms[0].reset(); 	//searchResultFrame.document.location.href='../../eFM/jsp/FMUnpulledFilesResult.jsp';
}

		function setvalue(obj)
		{
         if(obj.checked==true)
			 document.forms[0].p_print_tel_no.value = "Y";
		 else
			 document.forms[0].p_print_tel_no.value = "N";
		}

	async function searchCode1(target,facilityid)
	{
			var retVal = 	new String();
			var dialogHeight= "450px" ;
			var dialogWidth	= "750px" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			
			tit=getLabel("Common.clinic.label","common");

			if(document.getElementById("function_id").value=='FM_UNPULLED_FILES_FOR_BKG')
			{
			sql="select nursing_unit_code, LONG_DESC from IP_NURSING_UNIT_lang_vw where facility_id=`"+facilityid+"` and language_id=`"+localeName+"` ";
			search_code="nursing_unit_code";
			search_desc= "LONG_DESC";
			}
			else
			{
				sql="select CLINIC_CODE, LONG_DESC from OP_CLINIC_lang_vw where facility_id=`"+facilityid+"` and language_id=`"+localeName+"` ";
				search_code="CLINIC_CODE";
				search_desc= "LONG_DESC";
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


		async function searchCode2(target,facilityid)
		{
			var retVal = 	new String();
			var dialogHeight= "450px" ;
			var dialogWidth	= "750px" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var pract_type ="";
			if (target.name=="p_fm_pract_id")
			   pract_type = document.forms[0].fm_pract_type.value;
		    else
			   pract_type = document.forms[0].to_pract_type.value;

			tit=getLabel("Common.practitioner.label","common");
			sql="select PRACTITIONER_ID, PRACTITIONER_NAME from am_practitioner_lang_vw where pract_type = nvl(`"+pract_type+"`,pract_type) and language_id=`"+localeName+"`";
			search_code="PRACTITIONER_ID";
			search_desc= "PRACTITIONER_NAME";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}
