function reset()
{	
	f_query_add_mod.document.RepPD207Form.reset() ;
}

function run()
{
	var fields = new Array(f_query_add_mod.document.RepPD207Form.p_trn_date);
	var reptype=f_query_add_mod.document.getElementById("p_report_type").value;
	if(reptype=="M")
	{		
		var names  = new Array ( "Census Month");
		f_query_add_mod.document.RepPD207Form.p_report_id.value="MRBPD207"
	}
	else
	{
		var names  = new Array ( "Census Year");
		f_query_add_mod.document.RepPD207Form.p_report_id.value="MRBPD207"
	}
	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
		f_query_add_mod.document.forms[0].target="messageFrame";
		f_query_add_mod.document.RepPD207Form.submit() ;
	}
}

function mychange()
 {
	 if (document.getElementById("p_report_type").value=='M')
	 {
		document.getElementById("MY1").innerHTML="Census Month&nbsp;"
		document.getElementById("MY").innerHTML = "<input type='text' name='p_trn_date' id='p_trn_date' maxlength='5' size='5' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_trn_date.select();return showCalendar('p_trn_date','mm/y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
	 else  if (document.getElementById("p_report_type").value=='Y')
	 {
		 document.getElementById("MY1").innerHTML="Census Year&nbsp;"
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_trn_date' id='p_trn_date' maxlength='4' size='4' readonly><input type='image'  src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].p_trn_date.select();return showCalendar('p_trn_date','y',null)\">&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>"
	 }
 }			

