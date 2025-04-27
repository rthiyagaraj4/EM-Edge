/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
//Page created for RePrint Appointment Slips - IN34756 - Rajesh V 30/10/2012

function onSubmit() {
	var langChk = parent.main.document.getElementById('languageSel').value;
	if(langChk==''){
		alert('Please Select a language');
		return false;
	}
		var errmessage = report_server_form.message.value ;
		var languageID = report_server_form.languageID.value ;
		var errmessage = report_server_form.message.value ;
		var languageID = report_server_form.languageID.value ;
		if (errmessage=='');
		{
			var self_submit 	= report_server_form.self_submit.value ;
			var report_option	= parent.main.document.getElementById('reportOption').value ;
			var params		= report_server_form.params.value;
			var url 		= "" ;
			var locale=parent.main.document.getElementById('languageSel').value;
			if ( self_submit == "" ) {
				document.location.href	=	"PrintAppointmentSlipButton.jsp?" +
									"self_submit=yes" +
									"&report_option=" + report_option +
									"&" + params ;
				return true ;
			}

			var regExp = /&/g ;
			params = params.replace( regExp, "+" ) ;
			if ( report_option  == "V" ) {
				report_server_form.destype.value	= "cache" ;
				report_server_form.desformat.value	= parent.main.document.getElementById('fileFormat').value ;
					params=params.toUpperCase();
					params=params+"+P_LANGUAGE_ID="+locale;
					url = report_server_form.reportserver.value 				+
					"?server="		+ report_server_form.server.value		+
					"+report=" 		+ report_server_form.report.value 		+
					"+desformat="	+ report_server_form.desformat.value	+
					"+destype="		+ report_server_form.destype.value		+
					"+userid=" 		+ report_server_form.userid.value		+
					"+recursive_load=no" 		+ 
					"+" + params ;
					
			}

			if ( report_option == "P" ) {
				var myRegExp = /\\/g ;
				var printerName = report_server_form.queue_name.value ;
				printerName = printerName.replace( myRegExp, "\\\\" ) ;
				report_server_form.queue_name.value = printerName ;

				report_server_form.destype.value		= "printer" ;
				report_server_form.desname.value 		= report_server_form.queue_name.value ;
					params=params.toUpperCase();
					params=params+"+P_LANGUAGE_ID="+locale;
				url = report_server_form.reportserver.value 				+
					"?report=" 		+ report_server_form.report.value 		+
					"+userid=" 		+ report_server_form.userid.value		+
					"+server="		+ report_server_form.server.value		+
					"+destype="		+ report_server_form.destype.value		+
					"+desname="		+ report_server_form.desname.value		+
					"+recursive_load=no" 		+ 
					"+background=yes"	+
					"+" + params;
			}

			if ( report_option == "F" ) {
				var desformat = parent.main.document.getElementById('fileFormat').value ;

				var extension = "" ;

				if ( desformat == "pdf" )	extension = ".pdf" ;
				if ( desformat == "htmlcss" ) extension = ".html" ;
				if ( desformat == "rtf" )	extension = ".rtf" ;
				if ( desformat == "xml" )	extension = ".xml" ;
				if ( desformat == "spreadsheet" )	extension = ".xls" ;

				report_server_form.destype.value	= 	"file" ;
				report_server_form.desformat.value	= 	parent.main.document.getElementById('fileFormat').value ;
				report_server_form.desname.value	= 	parent.main.report_options_form.report_dir.value + parent.main.report_options_form.file_name.value + extension ;


					params=params.toUpperCase();
					params=params+"+P_LANGUAGE_ID="+locale;
				url = report_server_form.reportserver.value 				+
					"?report=" 		+ report_server_form.report.value 		+
					"+userid=" 		+ report_server_form.userid.value		+
					"+server="		+ report_server_form.server.value		+
					"+desformat="	+ report_server_form.desformat.value	+
					"+destype="		+ report_server_form.destype.value		+
					"+desname="		+ report_server_form.desname.value		+
					"+background=yes"	+
					"+recursive_load=no" 		+ 				
					"+" + params;
			}
			
			if ( report_option == "F" || report_option == "P" )
				url = url + "&closeWindow=true" ;
			
			//parent.returnValue = url ;
			let dialogBody = parent.parent.document.getElementById('dialog-body');
			dialogBody.contentWindow.returnValue = url;
		}
		/*else if(errmessage!='')
		{
			alert(getMessage("PRINT_ROUTING_NOT_DEFINED","Common"));
		}*/
		//parent.close() ;
		const dialogTag = parent.parent.document.getElementById('dialog_tag');    
		dialogTag.close();
		return true ;
	}
