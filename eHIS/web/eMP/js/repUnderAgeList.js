function reset()
{
	f_query_add_mod.document.UnderAge.reset() ;
} 				   

function run()
{
	var fields = new Array( f_query_add_mod.document.UnderAge.p_from_birth_date,
                            f_query_add_mod.document.UnderAge.p_to_birth_date );

    //var names = new Array("Birth Date From", "Birth Date To");
	 var birthordelivery=f_query_add_mod.document.UnderAge.delivery_date_label.value;	 
	 var birthordeliverydate="";
	 var birthordeliverydate1="";
	 if(birthordelivery=="true"){
	   birthordeliverydate=getLabel('eMP.DeliveryDate.label','MP')+" "+getLabel('Common.from.label','common') ;
	   birthordeliverydate1=getLabel('eMP.DeliveryDate.label','MP')+ " "+ getLabel('Common.to.label','common');
	 }else{
	 birthordeliverydate=getLabel('eMP.BirthDateFrom.label','MP');
	 birthordeliverydate1=getLabel('Common.birthDate.label','common')+ " "+ getLabel('Common.to.label','common');
	 }
	 
	
    var names = new Array(birthordeliverydate, birthordeliverydate1);
    if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
	if( f_query_add_mod.doDateCheckMsg( 
		f_query_add_mod.document.UnderAge.p_from_birth_date, f_query_add_mod.document.UnderAge.p_to_birth_date, messageFrame,'DMY' ) ) 
	{
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
	    f_query_add_mod.document.forms[0].target="messageFrame";
	    f_query_add_mod.document.UnderAge.submit() ;
	}
	}
}

function onChangeFacilityId()
{
    var facltyid = document.repRegnAgeRelgnStat.P_facilityid.value;
	var optlength = document.repRegnAgeRelgnStat.p_age_range_code.options.length;
	if(facltyid=='All')
	{
		document.repRegnAgeRelgnStat.p_age_range_code.disabled=true;
	}
	else
	{
				document.repRegnAgeRelgnStat.p_age_range_code.disabled=false;
	for (var i=0; i<optlength; i++)
	{
		document.repRegnAgeRelgnStat.p_age_range_code.options.remove("p_age_range_code");
	}
		var HTMLVal="<html><body onKeyDown='lockKey()'><form name='GetAgeRangeForm' id='GetAgeRangeForm' method='get' action='../../eMP/jsp/GetAgeRange.jsp'>"+
				"<input type='hidden' name='facility' id='facility' value='"+facltyid+"'>"+
		"</form></body></html>";
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
		parent.messageFrame.document.GetAgeRangeForm.submit();
	}
}

