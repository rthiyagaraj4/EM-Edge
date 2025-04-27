<%@ page import="java.io.*, javax.servlet.*, javax.servlet.http.*" %>
<%@page import="com.google.gson.JsonObject"%>
<%@ page import="java.sql.*, java.util.HashMap" %>
<%@ page import="eBL.Common.*" %>
<%@ page import="webbeans.eCommon.ConnectionManager" %>
<script src="../js/BLServItemReportOptions.jsp" type="text/javascript"></script>


<%
	Connection con = null;
	try{
		request.setCharacterEncoding("UTF-8");
		con=ConnectionManager.getConnection(request);
		String destype	= request.getParameter( "destype" ) ;
		String login_user	= (String) session.getValue( "login_user" ) ;
		String report_dir	= "" ;
		String file_name	= "" ;
		String report_dir_path="";
		
		if ( destype	== null ) destype		= "V" ;
		if ( login_user 	== null ) login_user 	= "" ;

		if ( destype.equals( "F" ) || destype.equals( "V" )) {
	//		Connection con = (Connection) session.getValue( "connection" ) ;

		PreparedStatement pstmt = con.prepareCall( "select report_base_dir, dir_path_separator,report_dir from sm_db_info" ) ;
			ResultSet rs = pstmt.executeQuery() ;
			
			if ( rs != null && rs.next() ) {
				String report_base_dir		= rs.getString( "report_base_dir" ) ;
				String dir_path_separator	= rs.getString( "dir_path_separator" ) ;
				 report_dir_path	= rs.getString( "report_dir" ) ;
				 report_dir 	= report_base_dir + dir_path_separator + login_user + dir_path_separator ;
				
			}
				System.out.println("destype="+destype);
				System.out.println("login_user="+login_user);
				System.out.println("report_dir="+report_dir);
				System.out.println("file_name="+file_name);
				System.out.println("report_dir_path="+report_dir_path);
				
			rs.close();
			pstmt.close();
		}
	}catch(Exception e){
		System.err.println("Exception in report_options_form.jsp : "+e);
		out.println(e);
		}
		finally{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}
%>


	
<%
request.setCharacterEncoding("UTF-8");	
	java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
	String reportServer	= (String) session.getValue( "report_server" ) ;
	String userid		= (String) session.getValue( "report_connect_string" ) ;

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
	System.out.println("module_id 1 = " + module_id);
	String report_id		= request.getParameter( "p_report_id" ) ;
	String dest_locn_type	= request.getParameter( "dest_locn_type" ) ;
	String dest_locn_code	= request.getParameter( "dest_locn_code" ) ;
	String self_submit      = request.getParameter("self_submit");
	String params           = request.getQueryString();
	String t=request.getQueryString();
	System.out.println("t " + t);
	String customerCode = request.getParameter("CustomerCode");
    System.out.println("Received CustomerCode: " + customerCode);
	String test = request.getParameter("PriceIndicator");
	System.out.println("PriceIndicator test " + test);
	System.out.println("params 303 =" + params);
	//String facility_id	= (String) session.getValue( "facility_id" ) ;
	String facility_id = request.getParameter("facility_id");
	System.out.println("facility_id 91 =" + facility_id);
	String report_ssl_yn	= (String) session.getValue( "report_ssl_yn" ) ;
	String ws_no		= (String) p.getProperty( "client_ip_address" )  ;
	String report_option	= request.getParameter( "report_option" ) ;
	String languageID	= request.getParameter( "p_language_id" )==null?"": request.getParameter( "p_language_id" );
	java.text.SimpleDateFormat dateTimeFormat = new java.text.SimpleDateFormat( "yyyyMMddHHmmss" ) ;
	String currentDateTime = dateTimeFormat.format( new java.util.Date() ) ; 

	String app_server_ip	= "" ;
	String rep_server_key	= "" ;


	if ( reportServer		== null ) reportServer	= "" ;
	if ( userid			== null ) userid		= "" ;
	if ( params 		== null ) params 		= "" ;
	if ( self_submit		== null ) self_submit	= "" ;
	if ( module_id		== null ) module_id 	= "BL" ;
	if ( report_id		== null ) report_id 	= "BLRPRLST" ;
	if ( dest_locn_type 	== null ) dest_locn_type= "" ;
	if ( dest_locn_code	== null ) dest_locn_code= "" ;
	if ( facility_id		== null ) facility_id	= "" ;
	if ( ws_no			== null ) ws_no		= "" ;
	if ( report_option	== null ) report_option = "V" ;
	
	System.out.println("dest_locn_type="+dest_locn_type);
	System.out.println("dest_locn_code="+dest_locn_code);
	System.out.println("module_id="+module_id);
	System.out.println("report="+report);
	System.out.println("userid="+userid);
	System.out.println("server="+server);
	System.out.println("params 334="+params);
	System.out.println("copies="+copies);
	System.out.println("queue_name="+queue_name);
	System.out.println("message="+message);
	System.out.println("self_submit="+self_submit);
	System.out.println("report_id="+report_id);
	System.out.println("languageID="+languageID);
	System.out.println("rep_server_key="+rep_server_key);
	
	try{
	con = ConnectionManager.getConnection(request);
		HashMap hashdata  = eCommon.Common.CommonBean.getSiteSpecificDetails(con,"SM","REPORT_SERVER_POST");
		reportServerEnableFlag = (String)hashdata.get("value1");
		CallableStatement cs = con.prepareCall( "{ call report_routing( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?) }" ) ;
		//PMG2012-CRF-0027 IN:037658  additional parameter added
		cs.setString( 1,	"BL" ) ;
		cs.setString( 2,	"BLRPRLST" ) ;
		cs.setString( 3,	dest_locn_type ) ;
		cs.setString( 4,	dest_locn_code ) ;
		cs.setString( 5,	"GH" ) ;
		cs.setString( 6,	ws_no ) ;
		cs.setString( 7,	"V" ) ;
		cs.registerOutParameter( 8,  Types.VARCHAR ) ;
		cs.registerOutParameter( 9,  Types.VARCHAR ) ;
		cs.registerOutParameter( 10, Types.VARCHAR ) ;
		cs.registerOutParameter( 11, Types.VARCHAR ) ;
		cs.registerOutParameter( 12, Types.VARCHAR ) ;
		cs.registerOutParameter( 13, Types.VARCHAR ) ;
		cs.registerOutParameter( 14, Types.VARCHAR ) ;
		cs.registerOutParameter( 15, Types.VARCHAR ) ;
		//By sbchand start on 25th July, 2001
		cs.registerOutParameter( 16, Types.VARCHAR ) ;
		cs.registerOutParameter( 17, Types.VARCHAR ) ;
		//By sbchand end on 25th July, 2001
		cs.execute() ;

		report	= cs.getString( 8 ) ;
		server	= cs.getString( 9 ) ;
		copies	= cs.getString( 10 ) ;	
		
		if(copies==null || copies.equals("null") || copies.equals("")) copies="1";
		//report_mode	= cs.getString( 11 ) ;
		queue_name	= cs.getString( 12 ) ;
		//report_tool	= cs.getString( 13 ) ;
		//status	= cs.getString( 14 ) ;
		message	= cs.getString( 15 ) ;
		if (message==null) message="";
		//By sbchand start on 25th July, 2001
		app_server_ip = cs.getString( 16 ) ;
		rep_server_key= cs.getString( 17 ) ;//PMG2012-CRF-0027 IN:037658
		if (rep_server_key==null) rep_server_key="";
		if (report_ssl_yn==null) report_ssl_yn="";
		if(report_ssl_yn.equals("Y")){
			reportServer = "https://" + app_server_ip + reportServer ;
		}else{
			reportServer = "http://" + app_server_ip + reportServer ;
		}
		
		System.out.println("Input Parameters:");
        System.out.println("module_id = " + module_id);
        System.out.println("report_id = " + report_id);
        System.out.println("dest_locn_type = " + dest_locn_type);
        System.out.println("dest_locn_code = " + dest_locn_code);
        System.out.println("facility_id = " + facility_id);
        System.out.println("ws_no = " + ws_no);
        System.out.println("report_option = " + report_option);

        System.out.println("Output Parameters:");
        System.out.println("report = " + report);
        System.out.println("server = " + server);
        System.out.println("copies = " + copies);
        System.out.println("queue_name = " + queue_name);
        System.out.println("message = " + message);
        System.out.println("app_server_ip = " + app_server_ip);
        System.out.println("rep_server_key = " + rep_server_key);


		if(cs !=null)cs.close() ;
	
%>

<%}catch(Exception e){
		System.err.println("Exception in report_options_form.jsp : "+e);
		out.println(e);
		}
		finally{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}
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
	
	
	
	
</form>
