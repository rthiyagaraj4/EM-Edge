 function create() {
	f_query_add_mod.location.href = "../../eAM/jsp/addModifyMedicalTeam.jsp" ;
}

function query() {
	f_query_add_mod.location.href ="../../eAM/jsp/MedicalTeamQueryCriteria.jsp" ;
}
function apply()
{
	var fields = new Array (f_query_add_mod.document.facilityteam_form.teamid);
	
	var names  =  new Array ( getLabel('Common.TeamID.label','Common') );
	
	var messageFrame = parent.frames[1].frames[2]; 
	
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";

	if(f_query_add_mod.SpecialCharCheck(fields,names,messageFrame,"M", error_page))
	{	
		var fields=new Array();
		
		fields[0]= f_query_add_mod.document.facilityteam_form.teamid;
		fields[1]= f_query_add_mod.document.facilityteam_form.long_desc;
		fields[2]= f_query_add_mod.document.facilityteam_form.short_desc;	
		
		var names = new Array (				
				getLabel('Common.TeamID.label','Common'),
				getLabel('Common.longdescription.label','common'),
				getLabel('Common.shortdescription.label','common')
				);
				
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
			f_query_add_mod.document.facilityteam_form.submit();
		}	
	}	
}


function onSuccess() { 
   
	if(f_query_add_mod.document.facilityteam_form.function_name.value =="insert")
		f_query_add_mod.document.facilityteam_form.reset();
		
	
}

function reset() {
	f_query_add_mod.document.forms[0].reset();
}	
			


