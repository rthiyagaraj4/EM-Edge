<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*" %>
<HTML>  
<script language="JavaScript">
	function SubmitReport() 
		{
		var errmessage = rh_validate_report_server_form.message.value ;
		var params		= rh_validate_report_server_form.params.value ;
				
		if (errmessage=='')
		{
			var self_submit 	= rh_validate_report_server_form.self_submit.value ;
			var report_option	= parent.parent.report_options.report_options_form.destype.value ;
			
			var url 		= "" ;
			var regExp = /&/g ;
			params = params.replace( regExp, "+" ) ;

			if ( report_option  == "V" ) {
				rh_validate_report_server_form.destype.value	= "cache" ;
				rh_validate_report_server_form.desformat.value	= "pdf" ;

				url = rh_validate_report_server_form.reportserver.value 				+
					"?server="		+ rh_validate_report_server_form.server.value		+
					"+report=" 		+ rh_validate_report_server_form.report.value 		+
					"+desformat="	+ rh_validate_report_server_form.desformat.value	+
					"+destype="		+ rh_validate_report_server_form.destype.value		+
					"+userid=" 		+ rh_validate_report_server_form.userid.value		+
					"+recursive_load=no" 		+ 
					"+" + params.toUpperCase() ;
			}

			if ( report_option == "P" ) {
	// By sbchand start on 20th June, 2001
				var myRegExp = /\\/g ;
				var printerName = rh_validate_report_server_form.queue_name.value ;
				printerName = printerName.replace( myRegExp, "\\\\" ) ;
				rh_validate_report_server_form.queue_name.value = printerName ;
	// By sbchand end on 20th June, 2001

				rh_validate_report_server_form.destype.value		= "printer" ;
				rh_validate_report_server_form.desname.value 		= rh_validate_report_server_form.queue_name.value ;

				url = rh_validate_report_server_form.reportserver.value 				+
					"?report=" 		+ rh_validate_report_server_form.report.value 		+
					"+userid=" 		+ rh_validate_report_server_form.userid.value		+
					"+server="		+ rh_validate_report_server_form.server.value		+
					"+destype="		+ rh_validate_report_server_form.destype.value		+
					"+desname="		+ rh_validate_report_server_form.desname.value		+
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

				rh_validate_report_server_form.destype.value	= 	"file" ;
				rh_validate_report_server_form.desformat.value	= 	parent.report_options.report_options_form.file_format.value ;
				rh_validate_report_server_form.desname.value	= 	parent.report_options.report_options_form.report_dir.value + parent.report_options.report_options_form.file_name.value + extension ;

				url = rh_validate_report_server_form.reportserver.value 				+
					"?report=" 		+ rh_validate_report_server_form.report.value 		+
					"+userid=" 		+ rh_validate_report_server_form.userid.value		+
					"+server="		+ rh_validate_report_server_form.server.value		+
					"+desformat="	+ rh_validate_report_server_form.desformat.value	+
					"+destype="		+ rh_validate_report_server_form.destype.value		+
					"+desname="		+ rh_validate_report_server_form.desname.value		+
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
 </script>
 <body>
 <form name="rh_validate_report_server_form" id="rh_validate_report_server_form">
		<%
		request.setCharacterEncoding("UTF-8");	
		java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
		String userid		= (String) session.getValue( "report_connect_string" ) ;
		String params=request.getQueryString();
		String p_frm_date=request.getParameter("p_fm_Date");
		String p_report_type=request.getParameter("p_type");
		String reportServer=request.getParameter("reportserver");
		String report=request.getParameter("report");
		String server=request.getParameter("server");
		String queue_name=request.getParameter("queue_name");
		String message=request.getParameter("message");
		String self_submit=request.getParameter("self_submit");
		String module_id=request.getParameter("p_module_id");
		String report_id=request.getParameter("p_report_id");
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
		try
			{
			diag_cs = con.prepareCall("{call MR_DC_MORB_MORT_SUMMARY_RH206(?,?)}");
						
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
		catch(SQLException e)
			{
			e.printStackTrace();
			System.out.println("Exception occurred while calling the MR_DC_MORB_MORT_SUMMARY_RH206 Procedure "+e);
			}
		finally	
			{
			try
				{
				if(diag_cs!=null)
				diag_cs.close();
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

