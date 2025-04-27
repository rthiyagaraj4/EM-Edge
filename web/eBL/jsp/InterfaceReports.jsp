<!DOCTYPE html>
<!-- JSP Created Against AAKH-CRF-0113.3 -->

<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %> 
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale=(String)session.getAttribute("LOCALE");
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%
	request.setCharacterEncoding("UTF-8");
	java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" );
	String reportServer	= (String) session.getValue( "report_server" );
	String userid		= (String) session.getValue( "report_connect_string" );
	String params		= request.getQueryString();
	String self_submit	= request.getParameter( "self_submit" );
	PreparedStatement pstmt1 = null ;
	ResultSet rs1 =null;
	String jdbc_username="";
	String jdbc_password="";
	String report_server="";
	String reoprt_connect_string="";
	String user_id="";
	
	String report		= "";
	String server		= "";
	String copies		= "";
	String queue_name	= "";
	String message		= "";

	String module_id		= request.getParameter( "p_module_id" );
	String report_id		= request.getParameter( "p_report_id" );
	String dest_locn_type	= request.getParameter( "dest_locn_type" );
	String dest_locn_code	= request.getParameter( "dest_locn_code" );

	String facility_id	= (String) session.getValue( "facility_id" );
	String ws_no		= (String) p.getProperty( "client_ip_address" );
	String report_option = request.getParameter( "report_option" );
	String languageID	= request.getParameter( "p_language_id" )==null?"": request.getParameter( "p_language_id" );

	String app_server_ip	= "";
	String rep_server_key	= "";
	if ( reportServer		== null ) reportServer	= "";
	if ( userid			== null ) userid		= "";
	if ( params 		== null ) params 		= "";
	if ( self_submit		== null ) self_submit	= "";

	if ( module_id		== null ) module_id 	= "";
	if ( report_id		== null ) report_id 	= "";
	if ( dest_locn_type 	== null ) dest_locn_type= "";
	if ( dest_locn_code	== null ) dest_locn_code= "";
	if ( facility_id		== null ) facility_id	= "";
	if ( ws_no			== null ) ws_no		= "";
	if ( report_option	== null ) report_option = "V";
	
	Connection con=null;
	try{
		con = ConnectionManager.getConnection(request);
		CallableStatement cs = con.prepareCall( "{ call report_routing( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?) }" );
		cs.setString( 1,	module_id );
		cs.setString( 2,	report_id );
		cs.setString( 3,	dest_locn_type );
		cs.setString( 4,	dest_locn_code );
		cs.setString( 5,	facility_id );
		cs.setString( 6,	ws_no );
		cs.setString( 7,	report_option );
		cs.registerOutParameter( 8,  Types.VARCHAR );
		cs.registerOutParameter( 9,  Types.VARCHAR );
		cs.registerOutParameter( 10, Types.VARCHAR );
		cs.registerOutParameter( 11, Types.VARCHAR );
		cs.registerOutParameter( 12, Types.VARCHAR );
		cs.registerOutParameter( 13, Types.VARCHAR );
		cs.registerOutParameter( 14, Types.VARCHAR );
		cs.registerOutParameter( 15, Types.VARCHAR );
		cs.registerOutParameter( 16, Types.VARCHAR );
		cs.registerOutParameter( 17, Types.VARCHAR );
		cs.execute() ;

		report	= cs.getString( 8 );
		server	= cs.getString( 9 );
		copies	= cs.getString( 10 );
		if(copies==null || copies.equals("null") || copies.equals("")) copies="1";
		queue_name	= cs.getString( 12 );
		message	= cs.getString( 15 );
		if (message==null) message="";
		app_server_ip = cs.getString( 16 );
		rep_server_key= cs.getString( 17 );
		if (rep_server_key==null) rep_server_key="";
     
		reportServer = "http://" + app_server_ip + reportServer;

		if(cs !=null)cs.close();
		
	String sql1="select USER_ID,app_password.decrypt(password),REPORT_SERVER,REPORT_CONNECT_STRING  from sm_db_info";
		
	pstmt1=con.prepareStatement(sql1);
	rs1=pstmt1.executeQuery();
	
	while(rs1.next())
	{
		jdbc_username	=rs1.getString(1);	
		jdbc_password	=rs1.getString(2);
		report_server =rs1.getString(3);
		reoprt_connect_string =rs1.getString(4);	
	}
	user_id = jdbc_username+"/"+jdbc_password+"@"+reoprt_connect_string;		
%>

<form name="report_server_form" id="report_server_form" method="Post">
	<input type="hidden" name="report_server" id="report_server" id="report_server" value="<%=report_server%>">
	<input type="hidden" name="user_id" id="user_id" id="user_id" value="<%=user_id%>">

	<input type="hidden"	name="reportserver" id="reportserver"	value="<%=reportServer%>">
	<input type="hidden" 	name="report" id="report"		value="<%=report%>">
	<input type="hidden" 	name="userid" id="userid"		value="<%=userid%>">
	<input type="hidden"	name="server" id="server"		value="<%=server%>">
	<input type="hidden"	name="desformat" id="desformat"	value="">
	<input type="hidden"	name="destype" id="destype"		value="">
	<input type="hidden"	name="desname" id="desname"		value="">
	<input type="hidden"	name="copies" id="copies"		value="<%=copies%>">
	<input type="hidden"	name="params" id="params"		value="<%=params%>">
	<input type="hidden"	name="queue_name" id="queue_name"	value="<%=queue_name%>">
	<input type="hidden"	name="message" id="message"		value="<%=message%>">

	<input type="hidden"	name="self_submit" id="self_submit"	value="<%=self_submit%>">
	<input type="hidden"	name="p_module_id" id="p_module_id"	value="<%=module_id%>">
	<input type="hidden"	name="p_report_id" id="p_report_id"	value="<%=report_id%>">
	<input type="hidden"	name="dest_locn_type" id="dest_locn_type"	value="<%=dest_locn_type%>">
	<input type="hidden"	name="dest_locn_code" id="dest_locn_code"	value="<%=dest_locn_code%>">
	<input type="hidden"	name="languageID" id="languageID"	value="<%=languageID%>">
	<input type="hidden"	name="rep_server_key" id="rep_server_key"	value="<%=rep_server_key%>">
</form>

<%	
	}catch(Exception e){out.println(e);e.printStackTrace();}
	finally { 
	ConnectionManager.returnConnection(con,request);
	}
%>

<script language="JavaScript">
function callReportOptionsFrameset( params ) {
	var reportserver = document.getElementById("reportserver").value;
	var report_server = document.getElementById("report_server").value;
	reportserver = reportserver+report_server;
	var params = document.getElementById("params").value;
	var user_id = document.getElementById("user_id").value;
	var server = document.getElementById("server").value;
	var report = document.getElementById("report").value;
	var languageID = document.getElementById("languageID").value;
	var self_submit = document.getElementById("self_submit").value;
	var regExp = /&/g ;
	params = params.replace( regExp, "+" ) ;
	params=params.toUpperCase();
	var locale="<%=locale%>";
	if(languageID!=""){
		locale=languageID;
	}
	params=params+"+P_LANGUAGE_ID="+locale;
	var url = reportserver+
			"?server="		+ server+
			"+report=" 		+ report+
			"+desformat=pdf+destype=cache+recursive_load=no+userid="+user_id+
			"+SELF_SUBMIT=YES+REPORT_OPTION=V+"+params;
	if ( url != null ) {  
	var reportURL		= "../../eCommon/jsp/report_process.jsp?" + url ;
	var myBars 		= 'directories=no,location=no,menubar=no' ;
	var myOptions 	= 'width=' + window.screen.availwidth + ', height=' + window.screen.availheight + ', resizable=yes' ;
	var myFeatures 	= myBars + ', ' + myOptions ;
	var reportWindow 	= open(reportURL, '_blank', myFeatures);

	reportWindow.title= "Medicom Report Viewer";
	reportWindow.resizeTo(screen.availWidth, screen.availHeight);
	reportWindow.moveTo( 0,0 );
	reportWindow.focus();
	}
}	
</script>
<%
if ( params == null ) params = "" ;
	out.println( "<script language=\"JavaScript\">callReportOptionsFrameset(\"" + java.net.URLDecoder.decode(params) + "\")</script>" ) ;
%>
<!--JSP Created Against AAKH-CRF-0113.3-->

