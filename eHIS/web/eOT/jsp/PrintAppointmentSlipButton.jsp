<!DOCTYPE html>
<!-- Page created for RePrint Appointment Slips - IN34756 - Rajesh V 30/10/2012-->
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

  <%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

			 String locale=(String)session.getAttribute("LOCALE");
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eOT/js/PrintAppointmentSlip.js' language='javascript'></script>

<%
request.setCharacterEncoding("UTF-8");	
	java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
	String reportServer	= (String) session.getValue( "report_server" ) ;
	String userid		= (String) session.getValue( "report_connect_string" ) ;
	String params 		= request.getQueryString() ;
	String self_submit	= request.getParameter( "self_submit" ) ;

	String report		= "" ;
	String server		= "" ;
	String copies		= "" ;
	String queue_name		= "" ;
	String message		= "" ;

	String module_id		= request.getParameter( "p_module_id" ) ;
	String report_id		= request.getParameter( "p_report_id" ) ;
	String dest_locn_type	= request.getParameter( "dest_locn_type" ) ;
	String dest_locn_code	= request.getParameter( "dest_locn_code" ) ;
	String facility_id	= (String) session.getValue( "facility_id" ) ;
	String ws_no		= (String) p.getProperty( "client_ip_address" )  ;
	String report_option	= request.getParameter( "report_option" ) ;
	String languageID	= request.getParameter( "p_language_id" )==null?"": request.getParameter( "p_language_id" );
	String report_ssl_yn	= (String) session.getValue( "report_ssl_yn" ) ; //AWS Server Issue
	String app_server_ip	= "" ;

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

		Connection con=null;
		try{
		con = ConnectionManager.getConnection(request);
		CallableStatement cs = con.prepareCall( "{ call report_routing( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?) }" ) ;
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
		cs.registerOutParameter( 16, Types.VARCHAR ) ;
		cs.registerOutParameter( 17, Types.VARCHAR ) ;//Added by MuthuN against report_routing Procedure Change on 2/15/2013
		cs.execute() ;

		report	= cs.getString( 8 ) ;
		server	= cs.getString( 9 ) ;
		copies	= cs.getString( 10 ) ;
		queue_name	= cs.getString( 12 ) ;
		message	= cs.getString( 15 ) ;
		if (message==null) message="";
		app_server_ip = cs.getString( 16 ) ;

		//reportServer = "http://" + app_server_ip + reportServer ;
		//AWS Server Issue
		if(report_ssl_yn.equals("Y")){
			reportServer = "https://" + app_server_ip + reportServer ;
		}else{
			reportServer = "http://" + app_server_ip + reportServer ;
		}
		//AWS Server Issue
		if(cs !=null)cs.close() ;
%>

<form name="report_server_form" id="report_server_form">
	<input type="hidden"	name="reportserver" id="reportserver"	value="<%= reportServer %>">
	<input type="hidden" 	name="report" id="report"		value="<%= report %>">
	<input type="hidden" 	name="userid" id="userid"		value="<%= userid %>">
	<input type="hidden"	name="server" id="server"		value="<%= server %>">
	<input type="hidden"	name="desformat" id="desformat"		value="">
	<input type="hidden"	name="destype" id="destype"		value="">
	<input type="hidden"	name="desname" id="desname"		value="">
	<input type="hidden"	name="copies" id="copies"		value="<%= copies %>">
	<input type="hidden"	name="params" id="params"		value="<%= params %>">
	<input type="hidden"	name="queue_name" id="queue_name"		value="<%= queue_name %>">
	<input type="hidden"	name="message" id="message"		value="<%= message %>">
	<input type="hidden"	name="self_submit" id="self_submit"	value="<%= self_submit %>">
	<input type="hidden"	name="p_module_id" id="p_module_id"	value="<%= module_id %>">
	<input type="hidden"	name="p_report_id" id="p_report_id"	value="<%= report_id %>">
	<input type="hidden"	name="dest_locn_type" id="dest_locn_type"	value="<%= dest_locn_type %>">
	<input type="hidden"	name="dest_locn_code" id="dest_locn_code"	value="<%= dest_locn_code %>">
	<input type="hidden"	name="languageID" id="languageID"	value="<%= languageID %>">
</form>

<%
	if ( self_submit.equals( "yes" ) )
		out.println( "<script language='JavaScript'>onSubmit();</script>" ) ;
%>

<center>
	<input type='submit' class='BUTTON' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick='onSubmit();'>
	<input type='button' class='BUTTON' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='parent.close();'>
</center>
<%
}catch(Exception e){out.println(e);e.printStackTrace();}
			finally { 
	ConnectionManager.returnConnection(con,request);
}
%>

