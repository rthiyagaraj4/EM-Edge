/*
Sr No           Version         Incident              SCF/CRF					Developer Name
1               V201125							MOHE-CRF-0050.3-US-004 			Palani Narayanan
*/

function reset()
{
	bl_cashier_report.location.reload();
}

async function run()
{
	
		var locale = frames[1].document.forms[0].locale.value;	
		var itemprice = frames[1].document.forms[0].itemprice.value;			
		var item_type = frames[1].document.forms[0].item_type.value;
		var itemstatus = frames[1].document.forms[0].itemstatus.value;
		var trdnamchk = frames[1].document.forms[0].trdnamchk .value;
		var FromItemCode = frames[1].document.forms[0].FromItemCode.value;	
		var ToItemCode = frames[1].document.forms[0].ToItemCode.value;
		var frmamendedBy_code = frames[1].document.forms[0].frmamendedBy_code.value;
		var toamendedBy_code = frames[1].document.forms[0].toamendedBy_code.value;
		var FromdAmendedDate = frames[1].document.forms[0].FromdAmendedDate.value;
		var TodAmendedDate = frames[1].document.forms[0].TodAmendedDate.value;
		var facility_id = frames[1].document.forms[0].facility_id.value;
		var login_user = frames[1].document.forms[0].login_user.value;
		var err_mess="";
		var log_rep_success_mes=getMessage("BL9323","BL");
		frames[1].document.forms[0].log_rep_success_mes.value=log_rep_success_mes;
			//ADDED ON 08/01/2021
			FromdAmendedDate = FromdAmendedDate.split(' ')[0];
			TodAmendedDate = TodAmendedDate.split(' ')[0];
		if(err_mess=="")
		{
			var temp_jsp = "../jsp/BLCommonAjax.jsp?functionMode=InsertItemPrice&p_report_id=BLRITLST"+"&p_facility_id="+facility_id+"&itemprice="+itemprice+"&item_type="+item_type+"&itemstatus="+itemstatus+"&trdnamchk="+trdnamchk+"&login_user="+login_user+"&FromItemCode="+FromItemCode+"&ToItemCode="+ToItemCode+"&frmamendedBy_code="+frmamendedBy_code+"&toamendedBy_code="+toamendedBy_code+"&FromdAmendedDate="+FromdAmendedDate+"&TodAmendedDate="+TodAmendedDate;
			var xmlHttp = new XMLHttpRequest();
			xmlHttp.open("POST", temp_jsp, false);
			xmlHttp.send();
			var responseText = trimString(xmlHttp.responseText);
			
			responseText = responseText.split("::");
			var P_SESSION_ID=responseText[0];
			var P_PGM_DATE=responseText[1];
			
			/*
			login_time=login_time.replace(/:/g,'');
			login_time=login_time.replace(/\s/g,'');
			logout_time=logout_time.replace(/:/g,'');
			logout_time=logout_time.replace(/\s/g,'');
			*/
			var url		= "../../eCommon/jsp/report_options_frameset.jsp?p_report_id=BLRITLST&p_module_id=BL&PGM_ID=BLRITLST"+"&PGM_DATE="+P_PGM_DATE+"&SESSION_ID="+P_SESSION_ID+"&P_FACILITY_ID="+facility_id+"&ND_FACILITY_ID="+facility_id+"&p_language_id="+locale+"&P_USER_ID="+login_user+"&PRICE_IND="+item_type+"&TRADE_NAME="+trdnamchk+"&ACTIVE="+itemstatus;
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
		//REMOVED ON 23/12/2020
		//frames[1].disable(true,err_mess); 
}
