/*
Sr No              Version                Incident              SCF/CRF                        Developer Name
1                 									            MOHE-CRF-0050.2-US-006 			       Palani Narayanan
*/
function reset()
{
	bl_cashier_report.location.reload();
}

async function run()
{
	
		var locale = frames[1].document.forms[0].locale.value;			
		var operator_id = frames[1].document.forms[0].operator_id.value;
		var cashcounter_code = frames[1].document.forms[0].cashcounter_code.value;
		var login_time = frames[1].document.forms[0].login_time.value;
		var logout_time = frames[1].document.forms[0].logout_time.value;	
		var facility_id = frames[1].document.forms[0].facility_id.value;
		var login_user = frames[1].document.forms[0].login_user.value;
		var err_mess="";
		var log_rep_success_mes=getMessage("BL9323","BL");
		frames[1].document.forms[0].log_rep_success_mes.value=log_rep_success_mes;
	
		if ((operator_id == null) || (operator_id=='') || (operator_id == ' '))
		{

			err_mess=getMessage("BL9784","BL")+"<br>";

		}
		if ((cashcounter_code == null) || (cashcounter_code=='') || (cashcounter_code == ' '))
		{

			err_mess+=getMessage("BL9538","BL")+"<br>";

		}
		if ((login_time == null) || (login_time=='') || (login_time == ' '))
		{

			err_mess+=getMessage("BL9785","BL")+"<br>";

		}
		if ((logout_time == null) || (logout_time=='') || (logout_time == ' '))
		{
		err_mess+=getMessage("BL9785","BL")+"<br>";
		}

		if(err_mess=="")
		{
			if(locale == 'en')
			{
				if(login_time != '')
					login_time=convertDate(login_time,'DMYHMS',locale,"en");
				if(logout_time != '')
					logout_time=convertDate(logout_time,'DMYHMS',locale,"en");
			}
			//login_time=login_time.replace(/\/|:| /g, "");
			//logout_time=logout_time.replace(/\/|:| /g, "");
			
			//logout_time=logout_time.replace(/\s/:/g,'');
			var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=validatsessionid&p_report_id=BLRSR001"+"&p_facility_id="+facility_id+"&p_cash_counter_code="+cashcounter_code+"&p_cash_counter_user_id="+operator_id+"&p_login_date_time="+login_time+"&p_logout_date_time="+logout_time+"&login_user="+login_user;
			var xmlHttp = new XMLHttpRequest();
			xmlHttp.open("POST", temp_jsp, false);
			xmlHttp.send();
			var responseText = trimString(xmlHttp.responseText);
			responseText = responseText.split("::");
			var P_SESSION_ID=responseText[0];
			var P_PGM_DATE=responseText[1];
			
			login_time=login_time.replace(/:/g,'');
			login_time=login_time.replace(/\s/g,'');
			logout_time=logout_time.replace(/:/g,'');
			logout_time=logout_time.replace(/\s/g,'');
			
			var url		= "../../eCommon/jsp/report_options_frameset.jsp?p_report_id=BLRSR001&p_module_id=BL&P_PGM_ID=BLRSR001"+"&p_cash_counter_code="+cashcounter_code+"&p_cash_counter_user_id="+operator_id+"&p_login_date_time="+login_time+"&p_logout_date_time="+logout_time+"&p_facility_id="+facility_id+"&P_PGM_DATE="+P_PGM_DATE+"&P_SESSION_ID="+P_SESSION_ID;
			var dialogHeight	= "11" ;
			var dialogWidth	= "25" ;
			var arguments	= "" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:no" ;
			var reportURL 	=await window.showModalDialog( url, arguments, features ) ;
			if ( reportURL != null ) {	
										reportURL		= "../../eCommon/jsp/report_process.jsp?" + reportURL ;
										var myBars 		= 'directories=no,location=no,menubar=no' ;
										var myOptions 	= 'width=' + window.screen.availwidth + ', height=' + window.screen.availheight + ', resizable=yes' ;
										var myFeatures 	= myBars + ', ' + myOptions ;
										var reportWindow 	= open( reportURL, '_blank', myFeatures ) ;
										reportWindow.title= "Medicom Report Viewer" ;
										reportWindow.resizeTo( screen.availWidth, screen.availHeight ) ;
										reportWindow.moveTo( 0,0 ) ;
										reportWindow.focus() ;
									}
		}
		//removed  below statement on03/12/2020
		//frames[1].disable(true,err_mess);

}
