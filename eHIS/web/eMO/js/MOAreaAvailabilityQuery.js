function query() {

	criteria.location.href ="../../eMO/jsp/MOAreaAvailabilityQueryCriteria.jsp";
}
function reset() {
	
		if(result.document.MOAreaAvailabilityQueryResult_form)
		result.document.MOAreaAvailabilityQueryResult_form.reset() ;
			if(criteria.document.AreaAvailForm)
		criteria.document.AreaAvailForm.reset() ;
		criteria.document.forms[0].area_code.options[0].selected = true;
		criteria.document.forms[0].Area_Type.focus();
}


