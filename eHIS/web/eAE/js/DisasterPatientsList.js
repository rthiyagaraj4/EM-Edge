
 async function searchCode1(obj,target)
		{
			var retVal = 	new String();
			var dialogHeight= "45vh" ;
			var dialogWidth	= "75vw" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var locale="`"+document.repDisasterPatList.locale.value+"`";
			var facility_id="`"+document.repDisasterPatList.p_facility_id.value+"`";
			if (obj.name == "clinic") 
			{ 
			tit=encodeURIComponent(getLabel("Common.emergency.label","Common")+" "+getLabel("Common.clinic.label","Common"))
			//sql="select clinic_code, short_desc from op_clinic_lang_vw where facility_id ="+facility_id+"  and language_id = "+locale;
			sql="select clinic_code,short_desc from op_clinic_lang_vw where  facility_id ="+facility_id+"  and level_of_care_ind = `E` and language_id="+locale;
			search_code="clinic_code";
			search_desc= "short_desc";
			}
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal; 
			}
			else
				target.focus();
	}