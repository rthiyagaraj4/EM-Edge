 function create() {
	f_query_add_mod.location.href = "../../eIP/jsp/addModifyFacilityTeam.jsp" ;
}

function query() {
	f_query_add_mod.location.href ="../../eIP/jsp/FacilityTeamQueryCriteria.jsp" ;
}
function apply()
{
	var fields=new Array();

	fields[0]= f_query_add_mod.document.facilityteam_form.facility;
	fields[1]= f_query_add_mod.document.facilityteam_form.teamid;
	fields[2]= f_query_add_mod.document.facilityteam_form.long_desc;
	fields[3]= f_query_add_mod.document.facilityteam_form.short_desc;	
	
	var names = new Array (	
			"Facility ID",
			"Team ID",
			getLabel('Common.longdescription.label','common'),
			getLabel('Common.shortdescription.label','common')
			);
			
	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
		f_query_add_mod.document.facilityteam_form.submit();
	}	

}


function onSuccess() { 
   
	if(f_query_add_mod.document.facilityteam_form.function_name.value =="insert")
		f_query_add_mod.document.facilityteam_form.reset();
		
	
}

function reset() {
	f_query_add_mod.document.forms[0].reset();
}	
			


