<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*" %>
<HTML>  
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language="JavaScript">
	function SubmitReport() 
		{
		var errmessage = validate_report_server_form.message.value ;
		var params		= validate_report_server_form.params.value ;
		if (errmessage=='')
		{
			var self_submit 	= validate_report_server_form.self_submit.value ;
			var report_option	= parent.parent.report_options.report_options_form.destype.value ;
			var url 		= "" ;
			var regExp = /&/g ;
			params = params.replace( regExp, "+" ) ;

			if ( report_option  == "V" ) {
				validate_report_server_form.destype.value	= "cache" ;
				validate_report_server_form.desformat.value	= "pdf" ;

				url = validate_report_server_form.reportserver.value 				+
					"?server="		+ validate_report_server_form.server.value		+
					"+report=" 		+ validate_report_server_form.report.value 		+
					"+desformat="	+ validate_report_server_form.desformat.value	+
					"+destype="		+ validate_report_server_form.destype.value		+
					"+userid=" 		+ validate_report_server_form.userid.value		+
					"+recursive_load=no" 		+ 
					"+" + params.toUpperCase() ;
			}

			if ( report_option == "P" ) {
	// By sbchand start on 20th June, 2001
				var myRegExp = /\\/g ;
				var printerName = validate_report_server_form.queue_name.value ;
				printerName = printerName.replace( myRegExp, "\\\\" ) ;
				validate_report_server_form.queue_name.value = printerName ;
	// By sbchand end on 20th June, 2001

				validate_report_server_form.destype.value		= "printer" ;
				validate_report_server_form.desname.value 		= validate_report_server_form.queue_name.value ;

				url = validate_report_server_form.reportserver.value 				+
					"?report=" 		+ validate_report_server_form.report.value 		+
					"+userid=" 		+ validate_report_server_form.userid.value		+
					"+server="		+ validate_report_server_form.server.value		+
					"+destype="		+ validate_report_server_form.destype.value		+
					"+desname="		+ validate_report_server_form.desname.value		+
					"+recursive_load=no" 		+ 
					"+background=yes"	+
					"+" + params.toUpperCase() ;
			}

			if ( report_option == "F" ) {
				var desformat = parent.report_options.report_options_form.file_format.value ;
				var extension = "" ;

				if ( desformat == "pdf" )	extension = ".pdf" ;
				if ( desformat == "htmlcss" ) extension = ".html" ;
				if ( desformat == "rtf" )	extension = ".rtf" ;
				if ( desformat == "xml" )	extension = ".xml" ;

				validate_report_server_form.destype.value	= 	"file" ;
				validate_report_server_form.desformat.value	= 	parent.report_options.report_options_form.file_format.value ;
				validate_report_server_form.desname.value	= 	parent.report_options.report_options_form.report_dir.value + parent.report_options.report_options_form.file_name.value + extension ;

				url = validate_report_server_form.reportserver.value 				+
					"?report=" 		+ validate_report_server_form.report.value 		+
					"+userid=" 		+ validate_report_server_form.userid.value		+
					"+server="		+ validate_report_server_form.server.value		+
					"+desformat="	+ validate_report_server_form.desformat.value	+
					"+destype="		+ validate_report_server_form.destype.value		+
					"+desname="		+ validate_report_server_form.desname.value		+
					"+background=yes"	+
					"+recursive_load=no" 		+ 				
					"+" + params.toUpperCase() ;
			}
			if ( report_option == "F" || report_option == "P" )
			url = url + "&closeWindow=true" ;
			parent.returnValue = url ;
			}
		else
			{
			alert(getMessage("PRINT_ROUTING_NOT_DEFINED"));
			}		
		parent.close() ;
		return true ;
	}
	/*Added By KAMATCHI S for ML-MMOH-CRF-1098.1 START*/
	function excelreport()
	{
		var errmessage = validate_report_server_form.message.value ;
		var params		= validate_report_server_form.params.value ;
		if (errmessage=='')
		{
				document.validate_report_server_form.action="../../servlet/eSM.exportExcelServlet?"+params;
				document.validate_report_server_form.submit();
		        setTimeout('window.close();',3000);	
		}
		return true ;
	}
	/*Added By KAMATCHI S for ML-MMOH-CRF-1098.1 END*/
 </script>
 <body>
 <form name="validate_report_server_form" id="validate_report_server_form" method="Post">
		<%
		request.setCharacterEncoding("UTF-8");	
		java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
		String userid		= (String) session.getValue( "report_connect_string" ) ;
		String params=request.getQueryString();
		String p_frm_date=request.getParameter("p_fm_Date");
		//Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349
		String report_id=request.getParameter("p_report_id");
		String p_report_type = "";
				
		/*Added By KAMATCHI S for ML-MMOH-CRF-1098.1 START*/
		String p_facility_id = "";
		String p_fm_Date = "";
		String p_to_Date = "";
		String report_type = "";
		String p_language_id = "";
		String appl_type = "";
		String p_from_date_cn = "";
		String p_to_date_cn = "";
		/*Added By KAMATCHI S for ML-MMOH-CRF-1098.1 END*/
		String p_year	= "";
		String p_year_cn	= "";
		
		if (report_id.equals("MRIPCSMB"))
		{
			p_report_type=request.getParameter("p_type");
		}
		else if (report_id.equals("MROPCSMB") || report_id.equals("MROPCSMS"))
		{
			p_report_type=request.getParameter("report_type");
		}
		/*Added By KAMATCHI S for ML-MMOH-CRF-1098.1 START*/
		//MRNIAREPY Added By Dharma on 29th Jan 2021 against ML-MMOH-CRF-1593
		else if (report_id.equals("MRNIAREP") || report_id.equals("MRNIAREPY"))
		{
			 p_facility_id		= checkForNull(request.getParameter( "p_facility_id" )) ;
			 p_fm_Date			= checkForNull(request.getParameter( "p_fm_Date" )) ;
			 p_to_Date			= checkForNull(request.getParameter( "p_to_Date" )) ;
			 p_from_date_cn		= checkForNull(request.getParameter( "p_from_date_cn" )) ;
			 p_to_date_cn		= checkForNull(request.getParameter( "p_to_date_cn" )) ;
			
			 report_type		= checkForNull(request.getParameter( "report_type" )) ;
			 p_language_id		= request.getParameter( "p_language_id" )==null?"en": request.getParameter( "p_language_id" );
			 appl_type			= checkForNull(request.getParameter( "appl_type" )) ;
			 p_year			= checkForNull(request.getParameter( "p_year" )) ;
			 p_year_cn			= checkForNull(request.getParameter( "p_year_cn" )) ;
		}
		/*Added By KAMATCHI S for ML-MMOH-CRF-1098.1 END*/
		String reportServer=request.getParameter("reportserver");
		String report=request.getParameter("report");
		String server=request.getParameter("server");
		String queue_name=request.getParameter("queue_name");
		String message=request.getParameter("message");
		String self_submit=request.getParameter("self_submit");
		String module_id=request.getParameter("p_module_id");
		String dest_locn_type=request.getParameter("dest_locn_type");
		String dest_locn_code=request.getParameter("dest_locn_code");
		if ( reportServer		== null ) reportServer	= "" ;
		if ( userid			== null ) userid		= "" ;
		if ( params 		== null ) params 		= "" ;
		if ( self_submit		== null ) self_submit	= "" ;
		if ( module_id		== null ) module_id 	= "" ;
		if ( report_id		== null ) report_id 	= "" ;
		if ( dest_locn_type 	== null ) dest_locn_type= "" ;
		if ( dest_locn_code	== null ) dest_locn_code= "" ;
		%>
		<input type="hidden"	name="reportserver" id="reportserver"	value="<%= reportServer %>">
		<input type="hidden" 	name="report" id="report"		value="<%= report %>">
		<input type="hidden" 	name="userid" id="userid"		value="<%= userid %>">
		<input type="hidden"	name="server" id="server"		value="<%= server %>">
		<input type="hidden"	name="params" id="params"		value="<%= params %>">
		<input type="hidden"	name="queue_name" id="queue_name"		value="<%= queue_name %>">
		<input type="hidden"	name="message" id="message"		value="<%= message %>">
		<input type="hidden"	name="desformat" id="desformat"		value="">
		<input type="hidden"	name="destype" id="destype"		value="">
		<input type="hidden"	name="desname" id="desname"		value="">
		<input type="hidden"	name="self_submit" id="self_submit"	value="<%= self_submit %>">
		<input type="hidden"	name="p_module_id" id="p_module_id"	value="<%= module_id %>">
		<input type="hidden"	name="p_report_id" id="p_report_id"	value="<%= report_id %>">
		<input type="hidden"	name="dest_locn_type" id="dest_locn_type"	value="<%= dest_locn_type %>">
		<input type="hidden"	name="dest_locn_code" id="dest_locn_code"	value="<%= dest_locn_code %>">
		<%
		Connection con			= ConnectionManager.getConnection(request);
		CallableStatement diag_cs = null;
		/*Added By KAMATCHI S for ML-MMOH-CRF-1098.1 START*/
		CallableStatement callStmt1 = null;
		CallableStatement callStmt2 = null;
		PreparedStatement pstmt1		= null;
		PreparedStatement pstmt2		= null;
		String psql="";
		String psql1="";
		String dsql="";
		String dsql1="";
		/*Added By KAMATCHI S for ML-MMOH-CRF-1098.1 START*/
		try
			{
			
			//Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349
			if (report_id.equals("MRIPCSMB"))
			{
				diag_cs = con.prepareCall("{call MR_IP_MORB_MORT_SUMMARY_PD206(?,?)}");
			}
			else if (report_id.equals("MROPCSMB") || report_id.equals("MROPCSMS"))
			{
				diag_cs = con.prepareCall("{call MR_OP_MORB_MORT_SUMMARY_PL206(?,?)}");
			}
			
			if(report_id.equals("MRIPCSMB")||report_id.equals("MROPCSMB") || report_id.equals("MROPCSMS"))
			{
			diag_cs.setString( 1 ,p_report_type );
			diag_cs.setString( 2 ,p_frm_date);
		
			boolean return_value=diag_cs.execute();
			if(return_value==false)
				{
				%><script>
				SubmitReport();	
				</script><%
				}
			}
			/*Added By KAMATCHI S for ML-MMOH-CRF-1098.1 START*/
			else if(report_id.equals("MRNIAREP"))
			{
			dsql="DELETE FROM nia_report_temp_table";
			dsql1="DELETE FROM nia_rep_pre_cmt_temp_tbl";
				
			pstmt1 = con.prepareStatement(dsql);
			pstmt2 = con.prepareStatement(dsql1);
			pstmt1.executeUpdate();
			pstmt2.executeUpdate();
				
			con.commit();
				
			psql="{call MR_DATA_INSERT_FOR_PRE_NIA_REP(?,?,?,?,?,?)}";
			psql1="{call MR_DATA_INSERT_FOR_NIA_REP(?,?,?,?,?,?)}";


				
			callStmt1 = con.prepareCall( psql ) ;
			callStmt1.setString( 1,	p_facility_id  ) ;
			callStmt1.setString( 2,	p_from_date_cn ) ;
			callStmt1.setString( 3,	p_to_date_cn  ) ;
			callStmt1.setString( 4,  report_type ) ;
			callStmt1.setString( 5,  p_language_id ) ;
			callStmt1.setString( 6,	appl_type ) ;
			
			boolean value1=callStmt1.execute() ;
			
			callStmt2 = con.prepareCall( psql1 ) ;
			callStmt2.setString( 1,	p_facility_id  ) ;
			callStmt2.setString( 2,	p_fm_Date ) ;
			callStmt2.setString( 3,	p_to_Date  ) ;
			callStmt2.setString( 4,  report_type ) ;
			callStmt2.setString( 5,  p_language_id ) ;
			callStmt2.setString( 6,	appl_type ) ;
			
			boolean value2=callStmt2.execute() ;
			
			if(value1==false && value2==false)
			{
				%><script>
				excelreport();	
				</script><%
	
			}
		
			}/*Added By KAMATCHI S for ML-MMOH-CRF-1098.1 END*/
			else if(report_id.equals("MRNIAREPY")){
			psql="{call mr_data_insert_for_nia_yer(?,?,?,?,?,?)}";
			psql1="{call mr_data_insert_for_pre_nia_yer(?,?,?,?,?,?)}";


				
			callStmt1 = con.prepareCall( psql ) ;
			callStmt1.setString( 1,	p_facility_id  ) ;
			callStmt1.setString( 2,	p_year ) ;
			callStmt1.setString( 3,	p_year_cn  ) ;
			callStmt1.setString( 4,  report_type ) ;
			callStmt1.setString( 5,  p_language_id ) ;
			callStmt1.setString( 6,	appl_type ) ;
			
			boolean value1=callStmt1.execute() ;
			
			callStmt2 = con.prepareCall( psql1 ) ;
			callStmt2.setString( 1,	p_facility_id  ) ;
			callStmt2.setString( 2,	p_year ) ;
			callStmt2.setString( 3,	p_year_cn  ) ;
			callStmt2.setString( 4,  report_type ) ;
			callStmt2.setString( 5,  p_language_id ) ;
			callStmt2.setString( 6,	appl_type ) ;
			
			boolean value2=callStmt2.execute() ;
			
			if(value1==false && value2==false)
			{
				%><script>
				excelreport();	
				</script><%
	
			}

			}
			else if(report_id.equals("AETOTVSR")){
				int j=1;
				psql="{call TOTAL_AE_VISIT_REG_REP_PRC(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
				callStmt1 = con.prepareCall( psql ) ;
				callStmt1.setString( j++, checkForNull(request.getParameter("p_language_id")) ) ;
				callStmt1.setString( j++, checkForNull(request.getParameter("p_facility_id")) ) ;
				callStmt1.setString( j++, checkForNull(request.getParameter("P_PRIORITY_ZONE")) ) ;
				callStmt1.setString( j++, checkForNull(request.getParameter("report_type")) ) ;
				callStmt1.setString( j++, checkForNull(request.getParameter("p_fm_Date")) ) ;
				callStmt1.setString( j++, checkForNull(request.getParameter("p_to_Date")) ) ;
				callStmt1.setString( j++, checkForNull(request.getParameter("P_FM_TREAT_CODE")) ) ;
				callStmt1.setString( j++, checkForNull(request.getParameter("P_TO_TREAT_CODE")) ) ;
				callStmt1.setString( j++, checkForNull(request.getParameter("P_TERM_SET_ID")) ) ;
				callStmt1.setString( j++, checkForNull(request.getParameter("P_Free_Text")) ) ;
				callStmt1.setString( j++, checkForNull(request.getParameter("start_ends_contains")) ) ;
				callStmt1.setString( j++, checkForNull(request.getParameter("P_FM_TERM_CODE")) ) ;
				callStmt1.setString( j++, checkForNull(request.getParameter("P_TO_TERM_CODE")) ) ;

				boolean value=callStmt1.execute() ;
			
				if(value==false) {%>
					<script>
						excelreport();	
					</script>
				<%}

			}
			
		
			}
		catch(SQLException e)
			{
			e.printStackTrace();
			System.out.println("Exception occurred while calling the MR_IP_MORB_MORT_SUMMARY_PD206 Procedure "+e);
			}
		finally	
			{
			try
				{
				if(diag_cs!=null)
				diag_cs.close();
				if(callStmt1!=null)
				callStmt1.close();
				if(callStmt2!=null)
				callStmt2.close();
				}
			catch(Exception e)	
				{}
			try
				{
				ConnectionManager.returnConnection(con,request);
				}
			catch(Exception e)	
				{
				}
			}				
		
		%>
	</form>
<%
if ( self_submit.equals( "yes" ) )
		out.println( "<script language='JavaScript'>SubmitReport();</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>" ) ;
%></BODY>
</HTML>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
%>

