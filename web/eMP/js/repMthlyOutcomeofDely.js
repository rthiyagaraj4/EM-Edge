function reset() {
	f_query_add_mod.document.repMthlyOutcomeofDely.reset() ;

	if (f_query_add_mod.document.getElementById("p_type").value=='D')
	 {	
		 f_query_add_mod.document.forms[0].p_report_id.value="MPBMODLW";	
		 f_query_add_mod.document.getElementById("MY1").innerHTML=getLabel('eMP.WeightRange.label','MP');	
		f_query_add_mod.document.getElementById("age_del").innerHTML = "<input type='text' name='p_range_id' id='p_range_id' id='age_type' maxlength='10' size='10'><input type='button' name='agerange' id='agerange' value='?' class='button' onClick=\"document.repMthlyOutcomeofDely.p_range_id.select();searchCode(this, p_range_id)\"><img align='center' src='../../eCommon/images/mandatory.gif'></img>"
  }
}

function run() 
{
	var fields = new Array ( f_query_add_mod.document.repMthlyOutcomeofDely.P_facilityid );
    var names = new Array (f_query_add_mod.getLabel('Common.facility.label','common'));

	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
		
		var from = f_query_add_mod.document.repMthlyOutcomeofDely.p_fr_birth_date;
		var to     = f_query_add_mod.document.repMthlyOutcomeofDely.p_to_birth_date ;  
		var rep_by     = f_query_add_mod.document.repMthlyOutcomeofDely.p_type.value ;
		if(rep_by=='D')
		{
			var fields = new Array( f_query_add_mod.document.repMthlyOutcomeofDely.p_fr_birth_date,f_query_add_mod.document.repMthlyOutcomeofDely.p_to_birth_date,f_query_add_mod.document.repMthlyOutcomeofDely.p_type,f_query_add_mod.document.repMthlyOutcomeofDely.p_range_id );
			var names = new Array(getLabel('Common.month.label','common')+" "+getLabel('Common.from.label','common'),getLabel('Common.month.label','common')+" "+getLabel('Common.to.label','common'),getLabel('Common.ReportBy.label','common'),getLabel('eMP.WeightRange.label','MP'));
		}else{
			var fields = new Array( f_query_add_mod.document.repMthlyOutcomeofDely.p_fr_birth_date,f_query_add_mod.document.repMthlyOutcomeofDely.p_to_birth_date,f_query_add_mod.document.repMthlyOutcomeofDely.p_type );
			var names = new Array(getLabel('Common.month.label','common')+" "+getLabel('Common.from.label','common'),getLabel('Common.month.label','common')+" "+getLabel('Common.to.label','common'),getLabel('Common.ReportBy.label','common'));
		}
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
		//if( f_query_add_mod.checkmonths('Date', from , to, messageFrame ) ) 
		if( f_query_add_mod.doDateChkWithLabel(from , to, messageFrame, 'MY', getLabel('Common.month.label','common'))) 

		{
			if (f_query_add_mod.trimCheck(from.value)) 
			{
				//f_query_add_mod.document.repMthlyOutcomeofDely.p_fm_regndate.value = '01/' + from.value;
				f_query_add_mod.document.repMthlyOutcomeofDely.p_fr_birth_date.value = from.value;
			}
			if (f_query_add_mod.trimCheck(to.value)) 
			{
				//f_query_add_mod.document.repMthlyOutcomeofDely.p_to_regndate.value = f_query_add_mod.LastDate(to)+'/' + to.value;
				f_query_add_mod.document.repMthlyOutcomeofDely.p_to_birth_date.value = to.value;
			}
			f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
			f_query_add_mod.document.forms[0].target="messageFrame";
			f_query_add_mod.document.repMthlyOutcomeofDely.submit() ;
		}		
	}
}
}

function mychgrepMPMthlyOtcome()
 {
	 if (document.getElementById("p_type").value=='D')
	 {	
		 document.forms[0].p_report_id.value="MPBMODLW";	
		 document.getElementById("MY1").innerHTML=getLabel('eMP.WeightRange.label','MP');	
		document.getElementById("age_del").innerHTML = "<input type='text' name='p_range_id' id='p_range_id' id='age_type' maxlength='10' size='10'><input type='button' name='agerange' id='agerange' value='?' class='button' onClick=\"document.repMthlyOutcomeofDely.p_range_id.select();searchCode(this, p_range_id)\"><img align='center' src='../../eCommon/images/mandatory.gif'></img>"
		  }
	 else  if (document.getElementById("p_type").value=='B')
	 {	
		 document.forms[0].p_report_id.value="MPBMODLP";	
		 document.getElementById("MY1").innerHTML=getLabel('eMP.BornWhere.label','MP');
		 document.getElementById("age_del").innerHTML = "<select name='p_born_at' id='p_born_at' ><option value='I' selected>"+getLabel('eMP.InFacility.label','MP')+"</option><option value='H'>"+getLabel('Common.home.label','common')+"</option><option value='A'>"+getLabel('eMP.Ambulance.label','MP')+"</option><option value='O'>"+getLabel('eMP.OtherModesofTpt.label','MP')+"</option><option value='B'>"+getLabel('eMP.BornBeforeArrival.label','MP')+"</option></select>"
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
			var p_user_name = document.repMthlyOutcomeofDely.p_user_name.value;
			var p_resp_id = document.repMthlyOutcomeofDely.p_resp_id.value;
						
			if(obj.name=="agerange")
			{
				tit="Wieght Range"
				sql="select range_id, long_desc from am_summ_range where range_type=`W` and  trunc(sysdate) between nvl(trunc(eff_date_from),trunc(sysdate)) and nvl(trunc(eff_date_to),trunc(sysdate)) and eff_status =`E`";
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

