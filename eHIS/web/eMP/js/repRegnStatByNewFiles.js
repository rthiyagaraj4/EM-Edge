function reset() {
	f_query_add_mod.document.location.reload() ;
}

function run() 
{
	var fields = new Array ( f_query_add_mod.document.repMonStatNewFiles.P_facilityid );
    var names = new Array (f_query_add_mod.getLabel('Common.facility.label','common'));

	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
		var rep_type = f_query_add_mod.document.repMonStatNewFiles.p_type.value;
		var from	= f_query_add_mod.document.repMonStatNewFiles.P_fr_regn_date;
		var to		= f_query_add_mod.document.repMonStatNewFiles.P_to_regn_date ;  
		var fields = new Array( f_query_add_mod.document.repMonStatNewFiles.P_fr_regn_date,f_query_add_mod.document.repMonStatNewFiles.P_to_regn_date);
		if (rep_type=="M") 
		{
			var names = new Array(getLabel('Common.month.label','common')+" "+getLabel('Common.from.label','common'),getLabel('Common.month.label','common')+" "+getLabel('Common.to.label','common'));
			var dtformat = 'MY';
			var lbl = getLabel('Common.month.label','common');
		}else
		{
			var names = new Array(getLabel('Common.year.label','common')+" "+getLabel('Common.from.label','common'),getLabel('Common.year.label','common')+" "+getLabel('Common.to.label','common'));
			var dtformat = 'YY';
			var lbl = getLabel('Common.year.label','common');
		}
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
		//if( f_query_add_mod.checkmonths('Date', from , to, messageFrame ) )

			if( f_query_add_mod.doDateChkWithLabel(from , to, messageFrame, dtformat, lbl))
			{
				if (f_query_add_mod.trimCheck(from.value)) 
				{
					//f_query_add_mod.document.repMonStatNewFiles.p_fm_regndate.value = '01/' + from.value;
					f_query_add_mod.document.repMonStatNewFiles.P_fr_regn_date.value = from.value;
				}
				if (f_query_add_mod.trimCheck(to.value)) 
				{
					//f_query_add_mod.document.repMonStatNewFiles.p_to_regndate.value = f_query_add_mod.LastDate(to)+'/' + to.value;
					f_query_add_mod.document.repMonStatNewFiles.P_to_regn_date.value = to.value;
				}
			   if(f_query_add_mod.CheckString( getLabel('Common.Organization.label','common'),f_query_add_mod.document.repMonStatNewFiles.p_fr_org_id,f_query_add_mod.document.repMonStatNewFiles.p_to_org_id,messageFrame))     	
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
				f_query_add_mod.document.forms[0].target="messageFrame"
				f_query_add_mod.document.repMonStatNewFiles.submit() ;
			}		
	}
}
}

function onChangeFacilityId()
{
    var facltyid = document.repMonStatNewFiles.P_facilityid.value;
	var optlength = document.repMonStatNewFiles.p_age_range_code.options.length;
	if(facltyid=='All')
	{
		document.repMonStatNewFiles.p_age_range_code.disabled=true;
	}
	else
	{
				document.repMonStatNewFiles.p_age_range_code.disabled=false;
	for (var i=0; i<optlength; i++)
	{
		document.repMonStatNewFiles.p_age_range_code.options.remove("p_age_range_code");
	}
		var HTMLVal="<html><body><form name='GetAgeRangeForm' id='GetAgeRangeForm' method='get' action='../../eMP/jsp/GetAgeRange.jsp'>"+
				"<input type='hidden' name='facility' id='facility' value='"+facltyid+"'>"+
		"</form></body></html>";
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
		parent.messageFrame.document.GetAgeRangeForm.submit();
	}
}

async function searchCode(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "400px" ;
			var dialogWidth	= "700px" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var p_user_name = document.repMonStatNewFiles.p_user_name.value;
			var p_resp_id = document.repMonStatNewFiles.p_resp_id.value;			
			
			if(obj.name=="organization")
			{
				tit=getLabel('Common.Organization.label','common');
				sql="select family_org_id, family_org_name from mp_family_org";
				search_code="family_org_id";
				search_desc= "family_org_name"
			}
			/*else if(obj.name=="facility")
			{
				tit="Facility"
				sql="select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id =`"+ p_user_name+"` and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = `"+p_resp_id+"`) ";
				search_code="facility_id";
				search_desc= "facility_name";
			}*/
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}

function mychangerepMPRegnStatNew()
 {
	 if (document.getElementById("p_type").value=='M')
	 {		
		 document.getElementById("MY1").innerHTML=getLabel('Common.month.label','common');
		 document.getElementById("MY").innerHTML = "<input type='text' name='P_fr_regn_date' id='P_fr_regn_date'  maxlength='7' size='5' onBlur=\"validDateObj(this,'MY',localeName)\"><img src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.repMonStatNewFiles.P_fr_regn_date.select();return showCalendar('P_fr_regn_date','mm/y',null)\"><img align='center' src='../../eCommon/images/mandatory.gif'></img>"
		 document.getElementById("MY2").innerHTML = "<input type='text' name='P_to_regn_date' id='P_to_regn_date'  maxlength='7' size='5' onBlur=\"validDateObj(this,'MY',localeName)\"><img src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.repMonStatNewFiles.P_to_regn_date.select();return showCalendar('P_to_regn_date','mm/y',null)\"><img align='center' src='../../eCommon/images/mandatory.gif'></img>"
		  }
	 else  if (document.getElementById("p_type").value=='Y')
	 {		 
		 document.getElementById("MY1").innerHTML=getLabel('Common.year.label','common');
		 document.getElementById("MY").innerHTML = "<input type='text' name='P_fr_regn_date' id='P_fr_regn_date'  maxlength='4' size='4' onBlur=\"validDateObj(this,'YY',localeName)\"><img src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.repMonStatNewFiles.P_fr_regn_date.select();return showCalendar('P_fr_regn_date','y',null)\"><img align='center' src='../../eCommon/images/mandatory.gif'></img>"
		 document.getElementById("MY2").innerHTML = "<input type='text' name='P_to_regn_date' id='P_to_regn_date'  maxlength='4' size='4' onBlur=\"validDateObj(this,'YY',localeName)\"><img src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.repMonStatNewFiles.P_to_regn_date.select();return showCalendar('P_to_regn_date','y',null)\"><img align='center' src='../../eCommon/images/mandatory.gif'></img>"
		 }
 }	

