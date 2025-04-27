function reset() {
	f_query_add_mod.document.repRegnStatByDlyModeOutcome.reset() ;
}

function run() 
{
	var fields = new Array ( f_query_add_mod.document.repRegnStatByDlyModeOutcome.p_facilityid );
    var names = new Array (f_query_add_mod.getLabel('Common.facility.label','common'));

	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
		
		var from = f_query_add_mod.document.repRegnStatByDlyModeOutcome.p_fr_birth_date;
		var to     = f_query_add_mod.document.repRegnStatByDlyModeOutcome.p_to_birth_date ; 
		var rep_by     = f_query_add_mod.document.repRegnStatByDlyModeOutcome.p_type.value ;
		if(rep_by=='A')
		{
		var fields = new Array( f_query_add_mod.document.repRegnStatByDlyModeOutcome.p_fr_birth_date,f_query_add_mod.document.repRegnStatByDlyModeOutcome.p_to_birth_date,f_query_add_mod.document.repRegnStatByDlyModeOutcome.p_type,f_query_add_mod.document.repRegnStatByDlyModeOutcome.p_range_id );
		var names = new Array(getLabel('Common.month.label','common')+" "+getLabel('Common.from.label','common'),getLabel('Common.month.label','common')+" "+getLabel('Common.to.label','common'),getLabel('Common.ReportBy.label','common'),getLabel('Common.AgeRange.label','common'));
		}else{
		var fields = new Array( f_query_add_mod.document.repRegnStatByDlyModeOutcome.p_fr_birth_date,f_query_add_mod.document.repRegnStatByDlyModeOutcome.p_to_birth_date,f_query_add_mod.document.repRegnStatByDlyModeOutcome.p_type );
		var names = new Array(getLabel('Common.month.label','common')+" "+getLabel('Common.from.label','common'),getLabel('Common.month.label','common')+" "+getLabel('Common.to.label','common'),getLabel('Common.ReportBy.label','common'));
		}
		
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
		//if( f_query_add_mod.checkmonths('Date', from , to, messageFrame ) ) 
		if( f_query_add_mod.doDateChkWithLabel(from , to, messageFrame, 'MY', getLabel('Common.month.label','common'))) 

		{
			if (f_query_add_mod.trimCheck(from.value)) 
			{
				//f_query_add_mod.document.repRegnStatByDlyModeOutcome.p_fm_regndate.value = '01/' + from.value;
				f_query_add_mod.document.repRegnStatByDlyModeOutcome.p_fr_birth_date.value = from.value;
			}
			if (f_query_add_mod.trimCheck(to.value)) 
			{
				//f_query_add_mod.document.repRegnStatByDlyModeOutcome.p_to_regndate.value = f_query_add_mod.LastDate(to)+'/' + to.value;
				f_query_add_mod.document.repRegnStatByDlyModeOutcome.p_to_birth_date.value = to.value;
			}
			f_query_add_mod.document.repRegnStatByDlyModeOutcome.submit() ;
		}		
	}
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
			var p_user_name = document.repRegnStatByDlyModeOutcome.p_user_name.value;
			var p_resp_id = document.repRegnStatByDlyModeOutcome.p_resp_id.value;
			
			//alert(obj.name)
			if(obj.name=="delivery")
			{
				tit=getLabel('eMP.DeliveryType.label','MP');
				sql="select nod_type, short_desc FROM mp_nod_type";
				search_code="nod_type";
				search_desc= "short_desc"
			}
			if(obj.name=="agerange")
			{
				tit=getLabel('Common.AgeRange.label','common');
				sql="select range_id, long_desc from am_summ_range where range_type=`A` and  trunc(sysdate) between nvl(trunc(eff_date_from),trunc(sysdate)) and nvl(trunc(eff_date_to),trunc(sysdate)) and eff_status =`E`";
				search_code="range_id";
				search_desc= "long_desc"
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


function mychangerepMPRegnStat()
 {
	 if (document.getElementById("p_type").value=='A')
	 {	
		document.forms[0].p_report_id.value="MPBSTAGN";	
		document.getElementById("MY1").innerHTML=getLabel('Common.AgeRange.label','common');	
		document.getElementById("age_del").innerHTML = "<input type='text' name='p_range_id' id='p_range_id' id='age_type' maxlength='10' size='10'><input type='button' name='agerange' id='agerange' value='?' class='button' onClick=\"document.repRegnStatByDlyModeOutcome.p_range_id.select();searchCode(this, p_range_id)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
		  }
	 else  if (document.getElementById("p_type").value=='D')
	 {	
		 document.forms[0].p_report_id.value="MPBSTDDO";	
		 document.getElementById("MY1").innerHTML=getLabel('eMP.DeliveryType.label','MP');
		 document.getElementById("age_del").innerHTML = "<input type='text' name='p_fm_del_type' id='p_fm_del_type' id='del_type' maxlength='10' size='10'><input type='button' name='delivery' id='delivery' value='?' class='button' onClick=\"document.repRegnStatByDlyModeOutcome.p_fm_del_type.select();searchCode(this, p_fm_del_type)\">&nbsp;"
		 }
 }	

