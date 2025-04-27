<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page  contentType="text/html;charset=UTF-8" import= "java.util.*,java.sql.*,java.net.*,java.text.*,java.io.*,ecis.utils.*,eCommon.Common.*,webbeans.eCommon.*,com.ehis.util.*,java.util.HashMap, java.util.ArrayList" %>
<%@ include file="CommonInclude.jsp"%>

  <%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

			 String locale=(String)session.getAttribute("LOCALE");
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script language="JavaScript">
function onClose() { 

    let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = null;
    const dialogTag = parent.parent.document.getElementById("dialog_tag"); 
    parent.parent.document.querySelectorAll("#dialog_tag")[parent.parent.document.querySelectorAll("#dialog_tag").length-1].close();	   
    // dialog.close();
}
function onSubmit() { 
		var errmessage = report_server_form.message.value ;
		var languageID = report_server_form.languageID.value ;
		var rep_server_key= report_server_form.rep_server_key.value ; //PMG2012-CRF-0027 IN:037658
		var params		= report_server_form.params.value;
		var dest_locn_type= report_server_form.dest_locn_type.value;
		
		var arg_params=params; 		 
		/*Below line modified for this CRF PER-RH-0206*/
		//Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349
		if((report_server_form.p_report_id.value=="MRIPCSMB" || report_server_form.p_report_id.value=="MROPCSMB" || 	report_server_form.p_report_id.value=="MROPCSMS") && report_server_form.self_submit.value!=""){			
			document.report_server_form.action="../../eMR/jsp/ValidateReports.jsp?"+arg_params;
			document.report_server_form.submit();
		}
		else if(report_server_form.p_report_id.value=="MRDCCSMB" && report_server_form.self_submit.value!=""){ 			
			document.report_server_form.action="../../eMR/jsp/RhValidateReports.jsp?"+arg_params;
			document.report_server_form.submit();
		}
		/*Added By Dharma for Export Excel Start*/
		else if(report_server_form.isExportExlConfigAvialYN.value =="Y" && parent.report_options.report_options_form.file_format.value =='spreadsheet' ){			
				var isLangYN = (arg_params.search("p_language_id") );
				if(isLangYN==-1){
					arg_params	= arg_params+"&p_language_id=<%=locale%>"					
				}
			//Added By KAMATCHI S for ML-MMOH-CRF-1098.1 START
			//MRNIAREPY Added By Dharma on 29th Jan 2021 against ML-MMOH-CRF-1593
			if( report_server_form.p_report_id.value=="MRNIAREP" || report_server_form.p_report_id.value=="MRNIAREPY" || report_server_form.p_report_id.value=='AETOTVSR' || report_server_form.p_report_id.value=="STBRTVS1" || report_server_form.p_report_id.value=="STBRTVS2" 
			|| report_server_form.p_report_id.value=="IPBMIPCH" || report_server_form.p_report_id.value=="IPBYIPCH" || report_server_form.p_report_id.value=="IPBMIPCS_HSA" || report_server_form.p_report_id.value=="IPBYIPCS" || report_server_form.p_report_id.value=="IPBMIPCN"
			|| report_server_form.p_report_id.value=="IPBYIPCN")
				{		
				document.report_server_form.action="../../eMR/jsp/ValidateReports.jsp?"+arg_params+"&closeWindow=true";
				document.report_server_form.submit();
				}
			//Start. ML-MMOH-CRF-1342.1 added By Twinkle 
			else if(report_server_form.p_report_id.value=="MRDRBHTRW")
				{
				document.report_server_form.action="../../servlet/eSM.ExportExcelServletByWard?"+arg_params;
				document.report_server_form.submit();
		        setTimeout('window.close();',3000);	
				}
			else if(report_server_form.p_report_id.value=="MRDRBHTRS")
			{
			document.report_server_form.action="../../servlet/eSM.ExportExcelServletBySpeciality?"+arg_params;
			document.report_server_form.submit();
	        setTimeout('window.close();',3000);	
			}
			else if(report_server_form.p_report_id.value=="MRDRBHTRH")
			{
			document.report_server_form.action="../../servlet/eSM.ExportExcelServletByHospital?"+arg_params;
			document.report_server_form.submit();
	        setTimeout('window.close();',3000);	
			}
			//end. ML-MMOH-CRF-1342.1 added By Twinkle 
			//Added By KAMATCHI S for ML-MMOH-CRF-1098.1 END
			else{				
				document.report_server_form.action="../../servlet/eSM.exportExcelServlet?"+arg_params;
				document.report_server_form.submit();
		        setTimeout('window.close();',3000);	

				}
		} 
		/*Added By Dharma for Export Excel End*/		
		else {			
		if (errmessage=='')
		{ 
			var self_submit 	= report_server_form.self_submit.value ;
			var report_option	= parent.report_options.report_options_form.destype.value ;
			//var params		= report_server_form.params.value.toUpperCase() ;

			var url 		= "" ;
			var locale="<%=locale%>";
			if(languageID!=""){
				locale=languageID;
			}
			if ( self_submit == "" ) {
				document.location.href	=	"report_buttons.jsp?" +
									"self_submit=yes" +
									"&report_option=" + report_option +
									"&" + params ;
				return true ;
			}

			var regExp = /&/g ;
			var currenttime=report_server_form.currentDateTime.value;
			params = params.replace( regExp, "+" ) ;
			if ( report_option  == "V" ) {
				//Maheshwaran K added for the MOHE-SCF-0147 as on 24-02-2022
				if(report_server_form.reportServerEnableFlag.value=='Y')
					{
					var desformat = parent.report_options.report_options_form.file_format.value ;
					var folder_dir=parent.report_options.report_options_form.report_dir_path.value ;
					var extension = "" ;
					if ( desformat == "pdf" )	extension = ".pdf" ;
					if ( desformat == "htmlcss" ) extension = ".html" ;
					if ( desformat == "rtf" )	extension = ".rtf" ;
					if ( desformat == "xml" )	extension = ".xml" ;
					if ( desformat == "spreadsheet" )	extension = ".xls" ;
					report_server_form.destype.value	= "file" ;
					report_server_form.desformat.value	= parent.report_options.report_options_form.file_format.value ;	
					//	report_server_form.desname.value	= 	parent.report_options.report_options_form.report_dir.value + parent.report_options.report_options_form.file_name.value + extension ;					
					params=params.toUpperCase();
					params=params+"+P_LANGUAGE_ID="+locale;
					var file_name_dir=report_server_form.report.value+'_'+currenttime+extension ;
						report_server_form.desname.value=parent.report_options.report_options_form.report_dir.value+file_name_dir;
			
						//Added Against MOHE-CRF-0050.2-US002 & US005 (5288/5291) Starts
					if (report_server_form.desformat.value=="spreadsheet" && (report_server_form.report.value == "BLRRESFP" || report_server_form.report.value == "BLRRVAT" )) {
						url = report_server_form.reportserver.value+
						"?server="		+ report_server_form.server.value		+
						"+report=" 		+ report_server_form.report.value 		+
						"+desformat="	+ "enhancedspreadsheet"	+
						"+destype="		+ report_server_form.destype.value		+	
						"+desname="		+ report_server_form.desname.value		+	
						"+filename="		+ file_name_dir+							
					//	"+desname="		+ folder_dir+'/'+file_name_dir+						//File Path has been mapped to save the file in directoy for MOHE-SCF-0147						
						"+recursive_load=no";
					}else {							
						url = report_server_form.reportserver.value+
						"?server="		+ report_server_form.server.value		+
						"+report=" 		+ report_server_form.report.value 		+
						"+desformat="	+ report_server_form.desformat.value	+
						"+destype="		+ report_server_form.destype.value		+	
						"+desname="		+ report_server_form.desname.value		+	
						"+filename="	+ file_name_dir+							
					//	"+desname="		+ folder_dir+'/'+file_name_dir+						//File Path has been mapped to save the file in directoy for MOHE-SCF-0147						
						"+recursive_load=no";
					}
					//Added Against MOHE-CRF-0050.2-US002 & US005 (5288/5291) Ends
					if(rep_server_key==''){ //PMG2012-CRF-0027 IN:037658
						url=url+"+userid=" 		+ report_server_form.userid.value		+"+";
					}else{
						url=url+"+cmdkey=" 		+ rep_server_key		+"+";
					}	
					url=url+params;
					//+"&P_LANGUAGE_ID="+locale ;
					/*
					url = report_server_form.reportserver.value+
					"?server="		+ report_server_form.server.value		+
					"+report=" 		+ report_server_form.report.value 		+
					"+desformat="	+ report_server_form.desformat.value	+
					"+destype="		+ report_server_form.destype.value		+		
					"+desname="		+ folder_dir+'/'+file_name_dir+						//File Path has been mapped to save the file in directoy for MOHE-SCF-0147
					"+recursive_load=no";
					if(rep_server_key==''){ //PMG2012-CRF-0027 IN:037658
						url=url+"+userid=" 		+ report_server_form.userid.value		+"+";
					}else{
						url=url+"+cmdkey=" 		+ rep_server_key		+"+";
					}	
				url=url+params;
				//	url=url+params+"&p_file_format="+file_format+"&p_file_type="+file_type;
				//	alert("url : "+url);
						//+"&P_LANGUAGE_ID="+locale ;			
*/						
					}
				else {
					report_server_form.destype.value	= "cache" ;
					report_server_form.desformat.value	= parent.report_options.report_options_form.file_format.value ;
					params=params.toUpperCase();
					params=params+"+P_LANGUAGE_ID="+locale;					
						//Added Against MOHE-CRF-0050.2-US002 & US005 (5288/5291) Starts
					if (report_server_form.desformat.value=="spreadsheet" && (report_server_form.report.value == "BLRRESFP" || report_server_form.report.value == "BLRRVAT" )) {
						url = report_server_form.reportserver.value+
						"?server="		+ report_server_form.server.value		+
						"+report=" 		+ report_server_form.report.value 		+
						"+desformat="	+ "enhancedspreadsheet"	+
						"+destype="		+ report_server_form.destype.value		+					
						"+recursive_load=no";
					}else {							
						url = report_server_form.reportserver.value+
						"?server="		+ report_server_form.server.value		+
						"+report=" 		+ report_server_form.report.value 		+
						"+desformat="	+ report_server_form.desformat.value	+
						"+destype="		+ report_server_form.destype.value		+					
						"+recursive_load=no";
					}
					//Added Against MOHE-CRF-0050.2-US002 & US005 (5288/5291) Ends
					
					if(rep_server_key==''){ //PMG2012-CRF-0027 IN:037658
						url=url+"+userid=" 		+ report_server_form.userid.value		+"+";
					}else{
						url=url+"+cmdkey=" 		+ rep_server_key		+"+";
					}	
					url=url+params;
					//+"&P_LANGUAGE_ID="+locale ;
				}
			}
			
			if ( report_option == "P" ) {
	// By sbchand start on 20th June, 2001
				var myRegExp = /\\/g ;
				var printerName = report_server_form.queue_name.value ;
				printerName = printerName.replace( myRegExp, "\\\\" ) ;
				report_server_form.queue_name.value = printerName ;
	// By sbchand end on 20th June, 2001

				report_server_form.destype.value		= "printer" ;
				report_server_form.desname.value 		= report_server_form.queue_name.value ;
					params=params.toUpperCase();
					params=params+"+P_LANGUAGE_ID="+locale;
				url = report_server_form.reportserver.value 				+
					"?report=" 		+ report_server_form.report.value 		+
					"+server="		+ report_server_form.server.value		+
					"+destype="		+ report_server_form.destype.value		+
					"+desname="		+ report_server_form.desname.value		+
					"+recursive_load=no" 		+ 
					"+copies=" 		+ report_server_form.copies.value		+
					"+background=yes";//Copies included in the parameter

					if(rep_server_key==''){ //PMG2012-CRF-0027 IN:037658
						url=url+"+userid=" 		+ report_server_form.userid.value		+"+";
					}else{
						url=url+"+cmdkey=" 		+ rep_server_key		+"+";
					}	

					url=url+params;
			}

			if ( report_option == "F" ) {
				//Maheshwaran K added for the MOHE-SCF-0147 as on 24-02-2022
				if(report_server_form.reportServerEnableFlag.value=='Y')
					{
					var desformat = parent.report_options.report_options_form.file_format.value ;
					var folder_dir=parent.report_options.report_options_form.report_dir_path.value ;
					var extension = "" ;
					if ( desformat == "pdf" )	extension = ".pdf" ;
					if ( desformat == "htmlcss" ) extension = ".html" ;
					if ( desformat == "rtf" )	extension = ".rtf" ;
					if ( desformat == "xml" )	extension = ".xml" ;
					if ( desformat == "spreadsheet" )	extension = ".xls" ;
				report_server_form.destype.value	= 	"file" ;
				report_server_form.desformat.value	= 	parent.report_options.report_options_form.file_format.value ;
			//	report_server_form.desname.value	= 	parent.report_options.report_options_form.report_dir.value + parent.report_options.report_options_form.file_name.value + extension ;
				var file_name_dir=report_server_form.report.value+'_'+parent.report_options.report_options_form.file_name.value+extension ;
					report_server_form.desname.value=parent.report_options.report_options_form.report_dir.value+file_name_dir;
					params=params.toUpperCase();
					params=params+"+P_LANGUAGE_ID="+locale;
				url = report_server_form.reportserver.value 				+
					"?report=" 		+ report_server_form.report.value 		+
					"+server="		+ report_server_form.server.value		+
					"+destype="		+ report_server_form.destype.value		+
					"+desformat="	+ report_server_form.desformat.value	+
					"+filename="		+ file_name_dir+			    //File Path has been mapped to save the file in directoy for MOHE-SCF-0147
					"+desname="		+ report_server_form.desname.value		+		
					"+background=yes"	+
					"+recursive_load=no" ;

					if(rep_server_key==''){  //PMG2012-CRF-0027 IN:037658
						url=url+"+userid=" 		+ report_server_form.userid.value		+"+";
					}else{
						url=url+"+cmdkey=" 		+ rep_server_key		+"+";
					}	

					url=url+params;
					
		
					}
				else 
				{
				var desformat = parent.report_options.report_options_form.file_format.value ;

				var extension = "" ;

				if ( desformat == "pdf" )	extension = ".pdf" ;
				if ( desformat == "htmlcss" ) extension = ".html" ;
				if ( desformat == "rtf" )	extension = ".rtf" ;
				if ( desformat == "xml" )	extension = ".xml" ;
				if ( desformat == "spreadsheet" )	extension = ".xls" ;

				report_server_form.destype.value	= 	"file" ;
				report_server_form.desformat.value	= 	parent.report_options.report_options_form.file_format.value ;
				report_server_form.desname.value	= 	parent.report_options.report_options_form.report_dir.value + parent.report_options.report_options_form.file_name.value + extension ;

					params=params.toUpperCase();
					params=params+"+P_LANGUAGE_ID="+locale;
				url = report_server_form.reportserver.value 				+
					"?report=" 		+ report_server_form.report.value 		+
					"+server="		+ report_server_form.server.value		+
					"+destype="		+ report_server_form.destype.value		+
					"+desformat="	+ report_server_form.desformat.value	+
					"+desname="		+ report_server_form.desname.value		+		
					"+background=yes"	+
					"+recursive_load=no" ;

					if(rep_server_key==''){  //PMG2012-CRF-0027 IN:037658
						url=url+"+userid=" 		+ report_server_form.userid.value		+"+";
					}else{
						url=url+"+cmdkey=" 		+ rep_server_key		+"+";
					}	

					url=url+params;
					
					}
			}
				if(report_server_form.reportServerEnableFlag.value!='Y'){
				if ( report_option == "F" || report_option == "P" )
				url = url + "&closeWindow=true" ;
				}	 
				
			//parent.returnValue = url ;
			let dialogBody = parent.parent.document.getElementById('dialog-body');
            dialogBody.contentWindow.returnValue = url;
            const dialogTag = parent.parent.document.querySelectorAll("#dialog_tag")[parent.parent.document.querySelectorAll("#dialog_tag").length-1]; 	   
            dialogTag.close();
            
				}
		else
		{
			
			alert(getMessage("PRINT_ROUTING_NOT_DEFINED","Common"));
			let dialogBody = parent.parent.document.getElementById('dialog-body');
            dialogBody.contentWindow.returnValue = url;
            const dialogTag = parent.parent.document.querySelectorAll("#dialog_tag")[parent.parent.document.querySelectorAll("#dialog_tag").length-1]; 	   
            dialogTag.close();
		}
		//parent.close() ;
		
	}	
		return true ;
	}
	


	
	
</script>

<%
request.setCharacterEncoding("UTF-8");	
	java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
	String reportServer	= (String) session.getValue( "report_server" ) ;
	String userid		= (String) session.getValue( "report_connect_string" ) ;
	String params 		= request.getQueryString() ;
	String self_submit	= request.getParameter( "self_submit" ) ;


//	Output Parameters for Stored Procedure

	String report		= "" ;
	String server		= "" ;
	String copies		= "" ;
	//String report_mode	= "" ;
	String queue_name		= "" ;
	//String report_tool	= "" ;
	//String status		= "" ;
	String message		= "" ;
	String reportServerEnableFlag="";	

//	Input Parameters for Stored Procedure

	String module_id		= request.getParameter( "p_module_id" ) ;
	String report_id		= request.getParameter( "p_report_id" ) ;
	String dest_locn_type	= request.getParameter( "dest_locn_type" ) ;
	String dest_locn_code	= request.getParameter( "dest_locn_code" ) ;

//	String facility_id	= (String) session.getValue( "facility_id" ) ;
     String facility_id = replaceNull(request.getParameter("facility_id"));
    if(facility_id == null || facility_id.equals("") || facility_id.equals("undefined")) {
        facility_id = (String) session.getAttribute("facility_id");
    }  
	String report_ssl_yn	= (String) session.getValue( "report_ssl_yn" ) ;
	String ws_no		= (String) p.getProperty( "client_ip_address" )  ;
	String report_option	= request.getParameter( "report_option" ) ;
	String languageID	= request.getParameter( "p_language_id" )==null?"": request.getParameter( "p_language_id" );
	java.text.SimpleDateFormat dateTimeFormat = new java.text.SimpleDateFormat( "yyyyMMddHHmmss" ) ;
	String currentDateTime = dateTimeFormat.format( new java.util.Date() ) ; //Maheshwaran added to get currenttime
// By sbchand start on 25th July, 2001
	String app_server_ip	= "" ;
	String rep_server_key	= "" ;
// By sbchand end on 25th July, 2001

	if ( reportServer		== null ) reportServer	= "" ;
	if ( userid			== null ) userid		= "" ;
	if ( params 		== null ) params 		= "" ;
	if ( self_submit		== null ) self_submit	= "" ;

	if ( module_id		== null ) module_id 	= "" ;
	if ( report_id		== null ) report_id 	= "" ;
	if ( dest_locn_type 	== null ) dest_locn_type= "" ;
	if ( dest_locn_code	== null ) dest_locn_code= "" ;
	if ( facility_id		== null ) facility_id	= "" ;
	if ( ws_no			== null ) ws_no		= "" ;
	if ( report_option	== null ) report_option = "V" ;

	//params = params.toUpperCase();

//	params = params.replace( '&', '+' ) ;

		Connection con=null;
		int count	= 0;
		String isExportExlConfigAvialYN = "N";
		
		/*Added By Dharma for Export Excel End*/
//		Connection con = (Connection) session.getValue( "connection" ) ;
	
		
		try{
		con = ConnectionManager.getConnection(request);
		/*Added By Dharma for Export Excel Start*/
		String sqlRep = "select count(*) tot from SM_REP_EXL_EXPORT where REPORT_ID = '"+report_id+"' "; 
		PreparedStatement pstmt = con.prepareCall( sqlRep  ) ;
		ResultSet rs = pstmt.executeQuery() ;
	
		if ( rs != null && rs.next() ) {
			count	= rs.getInt("tot");
		}
		
		if(count > 0){
			isExportExlConfigAvialYN	= "Y";
		}
		if(pstmt!=null)
			pstmt.close();
		if(rs!=null)
			rs.close();
		/*Added By Dharma for Export Excel End*/
		//Maheshwaran K added for the MOHE-SCF-0147 as on 24-02-2022 
		con = ConnectionManager.getConnection(request);
		HashMap hashdata  = eCommon.Common.CommonBean.getSiteSpecificDetails(con,"SM","REPORT_SERVER_POST");
		reportServerEnableFlag = (String)hashdata.get("value1");
		CallableStatement cs = con.prepareCall( "{ call report_routing( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?) }" ) ;
		//PMG2012-CRF-0027 IN:037658  additional parameter added
		cs.setString( 1,	module_id ) ;
		cs.setString( 2,	report_id ) ;
		cs.setString( 3,	dest_locn_type ) ;
		cs.setString( 4,	dest_locn_code ) ;
		cs.setString( 5,	facility_id ) ;
		cs.setString( 6,	ws_no ) ;
		cs.setString( 7,	report_option ) ;
		cs.registerOutParameter( 8,  Types.VARCHAR ) ;
		cs.registerOutParameter( 9,  Types.VARCHAR ) ;
		cs.registerOutParameter( 10, Types.VARCHAR ) ;
		cs.registerOutParameter( 11, Types.VARCHAR ) ;
		cs.registerOutParameter( 12, Types.VARCHAR ) ;
		cs.registerOutParameter( 13, Types.VARCHAR ) ;
		cs.registerOutParameter( 14, Types.VARCHAR ) ;
		cs.registerOutParameter( 15, Types.VARCHAR ) ;
// By sbchand start on 25th July, 2001
		cs.registerOutParameter( 16, Types.VARCHAR ) ;
		cs.registerOutParameter( 17, Types.VARCHAR ) ;
// By sbchand end on 25th July, 2001
		cs.execute() ;

		report	= cs.getString( 8 ) ;
		server	= cs.getString( 9 ) ;
		copies	= cs.getString( 10 ) ;	
		if(report_id.equals("STBMFGLB") || report_id.equals("STBREPLB")  || report_id.equals("STBITLB2")){				
		copies=	request.getParameter( "p_no_labels" )==null?"1": request.getParameter( "p_no_labels" );
		}		
		if(copies==null || copies.equals("null") || copies.equals("")) copies="1";
		//report_mode	= cs.getString( 11 ) ;
		queue_name	= cs.getString( 12 ) ;
		//report_tool	= cs.getString( 13 ) ;
		//status	= cs.getString( 14 ) ;
		message	= cs.getString( 15 ) ;
		if (message==null) message="";
// By sbchand start on 25th July, 2001
		app_server_ip = cs.getString( 16 ) ;
		rep_server_key= cs.getString( 17 ) ;//PMG2012-CRF-0027 IN:037658
		if (rep_server_key==null) rep_server_key="";
		if (report_ssl_yn==null) report_ssl_yn="";
		if(report_ssl_yn.equals("Y")){
			reportServer = "https://" + app_server_ip + reportServer ;
		}else{
			reportServer = "http://" + app_server_ip + reportServer ;
		}
// By sbchand end on 25th July, 2001

		if(cs !=null)cs.close() ;
%>

<form name="report_server_form" id="report_server_form" method="Post">
	<input type="hidden"	name="reportserver" id="reportserver"	value="<%=reportServer%>">
	<input type="hidden" 	name="report" id="report"		value="<%=report%>">
	<input type="hidden" 	name="userid" id="userid"		value="<%=userid%>">
	<input type="hidden"	name="server" id="server"		value="<%=server%>">
	<input type="hidden"	name="desformat" id="desformat"		value="">
	<input type="hidden"	name="destype" id="destype"		value="">
	<input type="hidden"	name="desname" id="desname"		value="">
	<input type="hidden"	name="copies" id="copies"		value="<%=copies%>">
	<input type="hidden"	name="params" id="params"		value="<%=params%>">
	<input type="hidden"	name="queue_name" id="queue_name"		value="<%=queue_name%>">
	<input type="hidden"	name="message" id="message"		value="<%=message%>">

	<input type="hidden"	name="self_submit" id="self_submit"	value="<%=self_submit%>">
	<input type="hidden"	name="p_module_id" id="p_module_id"	value="<%=module_id%>">
	<input type="hidden"	name="p_report_id" id="p_report_id"	value="<%=report_id%>">
	<input type="hidden"	name="dest_locn_type" id="dest_locn_type"	value="<%=dest_locn_type%>">
	<input type="hidden"	name="dest_locn_code" id="dest_locn_code"	value="<%=dest_locn_code%>">
	<input type="hidden"	name="languageID" id="languageID"	value="<%=languageID%>">
	<input type="hidden"	name="rep_server_key" id="rep_server_key"	value="<%=rep_server_key%>">
	<input type="hidden"	name="reportServerEnableFlag" id="reportServerEnableFlag"	value="<%=reportServerEnableFlag%>">
	<input type="hidden"	name="currentDateTime" id="currentDateTime"	value="<%=currentDateTime%>">
	<input type="hidden"	name="isExportExlConfigAvialYN" id="isExportExlConfigAvialYN"	value="<%=isExportExlConfigAvialYN%>"><!-- /*Added By Dharma for Export Excel -->
</form>

<% 
	if ( self_submit.equals( "yes" ) )
		out.println( "<script language='JavaScript'>onSubmit();</script>" ) ;
%>

<center>
<!--
	<img src="../images/BBrun.gif" 		alt="OK" 		onClick="onSubmit();">
	<img src="../images/BBcancel.gif" 	alt="Cancel" 	onClick="parent.close();">
-->

	<input type='submit' class='BUTTON' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick='onSubmit();'>
	<input type='button' class='BUTTON' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='onClose();'>
</center>
<%
}catch(Exception e){
		System.err.println("Exception in report_buttons.jsp : "+e);
	out.println(e);
	e.printStackTrace();
	}
			finally { 
	ConnectionManager.returnConnection(con,request);
}
%>
<%!
    public String replaceNull(String input) {
        return (input == null) ? "" : input;
    }
%>

