function reset()
{
	bl_cashier_report.location.reload();
}

function run()
{
		var locale = frames[1].document.forms[0].locale.value;			
		var operator_id = frames[1].document.forms[0].operator_id.value;
		var cashcounter_code = frames[1].document.forms[0].cashcounter_code.value;
		var login_time = frames[1].document.forms[0].login_time.value;
		var logout_time = frames[1].document.forms[0].logout_time.value;	

		var err_mess="";

		var log_rep_success_mes=getMessage("BL9323","BL");
		frames[1].document.forms[0].log_rep_success_mes.value=log_rep_success_mes;
	
		if ((operator_id == null) || (operator_id=='') || (operator_id == ' '))
		{
//			alert(getMessage("BL9784","BL"));
			err_mess=getMessage("BL9784","BL")+"<br>";
//			return false;
		}
		if ((cashcounter_code == null) || (cashcounter_code=='') || (cashcounter_code == ' '))
		{
//			alert(getMessage("BL9538","BL"));
			err_mess+=getMessage("BL9538","BL")+"<br>";
//			return false;
		}
		if ((login_time == null) || (login_time=='') || (login_time == ' '))
		{
//			alert(getMessage("BL9785","BL"));
			err_mess+=getMessage("BL9785","BL")+"<br>";
//			return false;
		}
		if ((logout_time == null) || (logout_time=='') || (logout_time == ' '))
		{
//			return;
		}

		if(err_mess=="")
		{
			if(locale != 'en')
			{
				if(login_time != '')
					login_time=convertDate(login_time,'DMYHMS',locale,"en");
				if(logout_time != '')
					logout_time=convertDate(logout_time,'DMYHMS',locale,"en");
			}
			frames[1].document.forms[0].submit();
		}
		frames[1].disable(true,err_mess);

}
