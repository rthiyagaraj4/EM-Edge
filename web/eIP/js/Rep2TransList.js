function reset()
{	
	f_query_add_mod.document.forms[0].reset();
}

function run()
{
	if(f_query_add_mod.document.RepInpatientsbyPractitioner)
	{
		if( f_query_add_mod.doDateCheck(f_query_add_mod.document.RepInpatientsbyPractitioner.p_fm_admission_date,f_query_add_mod.document.RepInpatientsbyPractitioner.p_to_admission_date, messageFrame )  )
		if( f_query_add_mod.CheckString('Specialty Code', f_query_add_mod.document.RepInpatientsbyPractitioner.p_fm_specialty_code,f_query_add_mod.document.RepInpatientsbyPractitioner.p_to_specialty_code, messageFrame )  )
		if( f_query_add_mod.CheckString('Practitioner ID', f_query_add_mod.document.RepInpatientsbyPractitioner.p_fm_practitioner_id,f_query_add_mod.document.RepInpatientsbyPractitioner.p_to_practitioner_id, messageFrame )  )
		{
			//Added By Srikanta .......1/11/2007...11.50am.....Starts
			var fields = new Array(f_query_add_mod.document.RepInpatientsbyPractitioner.p_fm_admission_date,f_query_add_mod.document.RepInpatientsbyPractitioner.p_to_admission_date);
var names;
names = new Array ("Admission  From Date ",
"Admission  To Date ");
if(f_query_add_mod.checkFields( fields, names, messageFrame))
{
	f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
	f_query_add_mod.document.forms[0].target="messageFrame";
	f_query_add_mod.document.RepInpatientsbyPractitioner.submit() ;
			
}
//Added By Srikanta .......1/11/2007...11.50am.....Ends
		}
	}
	else if(f_query_add_mod.document.RepPractitionerExpiredDischarge)
	{
		if( f_query_add_mod.doDateCheck(f_query_add_mod.document.RepPractitionerExpiredDischarge.p_fm_discharge_date,f_query_add_mod.document.RepPractitionerExpiredDischarge.p_to_discharge_date, messageFrame )  )
		if( f_query_add_mod.CheckString('Specialty Code', f_query_add_mod.document.RepPractitionerExpiredDischarge.p_fm_specialty_code,f_query_add_mod.document.RepPractitionerExpiredDischarge.p_to_specialty_code, messageFrame )  )
		if( f_query_add_mod.CheckString('Practitioner ID', f_query_add_mod.document.RepPractitionerExpiredDischarge.p_fm_practitioner_id,f_query_add_mod.document.RepPractitionerExpiredDischarge.p_to_practitioner_id, messageFrame )  )
		{
			f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
			f_query_add_mod.document.forms[0].target="messageFrame";
			f_query_add_mod.document.RepPractitionerExpiredDischarge.submit() ;
		}
	}
	else if(f_query_add_mod.document.RepYearlyAnnualStatistics)
	{
		
		var fields = new Array(f_query_add_mod.document.RepYearlyAnnualStatistics.p_trn_date);
		 var names = new Array (getLabel('Common.statistics.label','Common') )

	     if(f_query_add_mod.checkFields( fields, names, messageFrame))
		 {
			
		 f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
		 f_query_add_mod.document.forms[0].target="messageFrame";				
		 f_query_add_mod.document.RepYearlyAnnualStatistics.submit() ;
		 }
		}
	else if(f_query_add_mod.document.RepMthlyAnnualStatisticsform)
	{
		if(f_query_add_mod.document.RepMthlyAnnualStatisticsform.p_trn_date.value == "")
		{
			var err = f_query_add_mod.getMessage("CAN_NOT_BE_BLANK");
			err = err.replace('$','Statistics Month');
			messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+err;
			f_query_add_mod.document.RepMthlyAnnualStatisticsform.p_trn_date.focus();
		}
		else
		{
			f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
			f_query_add_mod.document.forms[0].target="messageFrame";
			f_query_add_mod.document.RepMthlyAnnualStatisticsform.submit() ;
		}
	}
	else if(f_query_add_mod.document.RepDailyAnnualStatistics)
	{
		var fields = new Array(f_query_add_mod.document.RepDailyAnnualStatistics.p_trn_date);
		var names = new Array( getLabel ('Common.statistics.label','Common'))
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
		f_query_add_mod.document.forms[0].target="messageFrame";
		f_query_add_mod.document.RepDailyAnnualStatistics.submit() ;
		}
		}
	else
		if(f_query_add_mod.document.RepDailyServiceList)
	    {
		
		var fields = new Array(f_query_add_mod.document.RepDailyServiceList.p_trn_date);
		var names = new Array(getLabel('Common.admissiondate.label','Common'));
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
	    f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
        f_query_add_mod.document.forms[0].target="messageFrame";
		f_query_add_mod.document.RepDailyServiceList.submit() ;
		}


	}

}//e.o.run


function doDateCheck(from,to) 
{
    var fromarray; var toarray;
    var fromdate = from.value ;
    var todate = to.value ;

    if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
			var fromdt = new Date(fromarray[1],fromarray[0],"01");
            var todt = new Date(toarray[1],toarray[0],"01");
			if(Date.parse(todt) < Date.parse(fromdt)) {
                var error = f_query_add_mod.getMessage("FR_TRN_MNYR_GR_TO_TRN_MNYR");
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;
                return false;
            }
            else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
    }
	return true;
}
