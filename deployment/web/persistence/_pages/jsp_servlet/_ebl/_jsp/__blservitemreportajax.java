package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.google.gson.JsonObject;
import java.sql.*;
import java.util.HashMap;
import eBL.Common.*;
import webbeans.eCommon.ConnectionManager;

public final class __blservitemreportajax extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/ebl/jsp/BLServItemReportAjax.jsp", 1726130402000L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n<script src=\"../js/BLServItemReportOptions.jsp\" type=\"text/javascript\"></script>\r\n\r\n\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n\r\n\r\n\t\r\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\r\n\r\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\r\n\t\r\n<form name=\"report_server_form\" id=\"report_server_form\" method=\"Post\">\r\n\t<input type=\"hidden\"\tname=\"reportserver\" id=\"reportserver\"\tvalue=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\">\r\n\t\r\n\t<input type=\"hidden\" \tname=\"report\" id=\"report\"\t\tvalue=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\">\r\n\t<input type=\"hidden\" \tname=\"userid\" id=\"userid\"\t\tvalue=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\">\r\n\t<input type=\"hidden\"\tname=\"server\" id=\"server\"\t\tvalue=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">\r\n\t<input type=\"hidden\"\tname=\"desformat\" id=\"desformat\"\t\tvalue=\"\">\r\n\t<input type=\"hidden\"\tname=\"destype\" id=\"destype\"\t\tvalue=\"\">\r\n\t<input type=\"hidden\"\tname=\"desname\" id=\"desname\"\t\tvalue=\"\">\r\n\t<input type=\"hidden\"\tname=\"copies\" id=\"copies\"\t\tvalue=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\r\n\t<input type=\"hidden\"\tname=\"params\" id=\"params\"\t\tvalue=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\r\n\t<input type=\"hidden\"\tname=\"queue_name\" id=\"queue_name\"\t\tvalue=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\r\n\t<input type=\"hidden\"\tname=\"message\" id=\"message\"\t\tvalue=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\r\n\r\n\t<input type=\"hidden\"\tname=\"self_submit\" id=\"self_submit\"\tvalue=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\r\n\t<input type=\"hidden\"\tname=\"p_module_id\" id=\"p_module_id\"\tvalue=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\r\n\t<input type=\"hidden\"\tname=\"p_report_id\" id=\"p_report_id\"\tvalue=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\r\n\t<input type=\"hidden\"\tname=\"dest_locn_type\" id=\"dest_locn_type\"\tvalue=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\r\n\t<input type=\"hidden\"\tname=\"dest_locn_code\" id=\"dest_locn_code\"\tvalue=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\r\n\t<input type=\"hidden\"\tname=\"languageID\" id=\"languageID\"\tvalue=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\r\n\t<input type=\"hidden\"\tname=\"rep_server_key\" id=\"rep_server_key\"\tvalue=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\r\n\t<input type=\"hidden\"\tname=\"reportServerEnableFlag\" id=\"reportServerEnableFlag\"\tvalue=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\r\n\t\r\n\t\r\n\t\r\n\t\r\n</form>\r\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

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

            _bw.write(_wl_block2Bytes, _wl_block2);

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
	

            _bw.write(_wl_block3Bytes, _wl_block3);
}catch(Exception e){
		System.err.println("Exception in report_options_form.jsp : "+e);
		out.println(e);
		}
		finally{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(reportServer));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(report));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(userid));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(server));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(copies));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(params));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(queue_name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(message));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(self_submit));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(report_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(dest_locn_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(dest_locn_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(languageID));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rep_server_key));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(reportServerEnableFlag));
            _bw.write(_wl_block20Bytes, _wl_block20);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
