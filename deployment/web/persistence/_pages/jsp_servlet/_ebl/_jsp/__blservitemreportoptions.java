package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import java.io.*;
import ecis.utils.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.ArrayList;
import eCommon.XSSRequestWrapper;
import com.google.gson.JsonObject;

public final class __blservitemreportoptions extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLServItemReportOptions.jsp", 1726130402000L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

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

    private final static java.lang.String  _wl_block1 ="  \r\n\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n\r\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
 
// Set the character encoding for the request
	request.setCharacterEncoding("UTF-8");
	request = new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

            _bw.write(_wl_block1Bytes, _wl_block1);

	System.err.println("In BLServItemReportOptions.jsp");
    Connection con = null;
	PreparedStatement pstmt = null;
	CallableStatement cs = null;
	ResultSet rs = null;
	String report_dir = "";
	String file_name = "";
	String report_dir_path = "";
	String derived_report_connect_string = "";
	String derived_user = "";
	String derived_password = "";
	String userid = "";
	String reportServer = "";
	String report_ssl_yn = "";
	String reportServerEnableFlag = "";
	
    JsonObject jsonResponse = new JsonObject();

	 // Retrieve parameters from the request
	 String destype = request.getParameter("destype");
	 String report_option = request.getParameter("report_option");
	 String fileFormat = request.getParameter("fileFormat");
	 String fileName = request.getParameter("fileName");
	 String params = request.getParameter("params");
	 String self_submit = request.getParameter("self_submit");
	 String locale = request.getParameter("locale");
	 String login_user = (String) session.getAttribute("login_user");
	 
	 if ( reportServer		== null ) reportServer	= "" ;
	 if (destype == null) destype = "V";
	 if (login_user == null) login_user = "";
	
	 if (destype.equals("F") || destype.equals("V")) {
	 	try{
	 		 // Obtain the database connection
	         con = ConnectionManager.getConnection(request);
	 	
	      pstmt = con.prepareStatement("SELECT report_base_dir, dir_path_separator, report_dir,report_connect_string,report_server,report_ssl_yn,USER_ID,  app_password.decrypt(password) as password  FROM sm_db_info");
	      
	      rs = pstmt.executeQuery();
	
	      if (rs != null && rs.next()) {
	          String report_base_dir = rs.getString("report_base_dir");
	          String dir_path_separator = rs.getString("dir_path_separator");
	          report_dir_path = rs.getString("report_dir");
	          reportServer = rs.getString("report_server");
	          report_ssl_yn = rs.getString("report_ssl_yn");
	          derived_report_connect_string = rs.getString("report_connect_string");
	          derived_user = rs.getString("USER_ID");
	          derived_password = rs.getString("password");
	          
	          report_dir = report_base_dir + dir_path_separator + login_user + dir_path_separator;
	         
	          userid = derived_user + "/"+ derived_password + "@"+ derived_report_connect_string;
	          
	          System.err.println("Report_dir: "+report_dir+", report_dir_path: "+report_dir_path+", userid: "+userid);
	          jsonResponse.addProperty("report_dir", report_dir);
	          jsonResponse.addProperty("userid", userid);
	      }
	 	}catch(Exception ex){
	 		ex.printStackTrace();
	 	}finally{
	 		try{
	 			 if(rs != null) rs.close();
	 	         if(pstmt != null) pstmt.close();
	 	         if (con != null) ConnectionManager.returnConnection(con, request);
	 		}catch(Exception e){
	 			e.printStackTrace();
	 		}
	 	}
	 }
	
	 // Retrieve other request parameters
	 String module_id = request.getParameter("p_module_id");
	 String report_id = request.getParameter("p_report_id");
	 String dest_locn_type = request.getParameter("dest_locn_type");
	 String dest_locn_code = request.getParameter("dest_locn_code");
	// String facility_id = (String) session.getAttribute("facility_id");
	String facility_id = request.getParameter("facility_id");
	System.out.println("Report Option page facility_id= "+facility_id);


	 String ws_no = (String) ((java.util.Properties) session.getAttribute("jdbc")).getProperty("client_ip_address");
	 String languageID = request.getParameter("p_language_id") == null ? "" : request.getParameter("p_language_id");
	 
	 // Default values for parameters
	 if (module_id == null) module_id = "BL";
	 if (report_id == null) report_id = "BLRPRLST";
	 if (dest_locn_type == null) dest_locn_type = "";
	 if (dest_locn_code == null) dest_locn_code = "";
	 if (facility_id == null) facility_id = "";
	 if (ws_no == null) ws_no = "";
	 if (report_option == null) report_option = "V";
	 try {
		 // Obtain the database connection
         con = ConnectionManager.getConnection(request);
		 
        // Perform the stored procedure call
        cs = con.prepareCall("{ call report_routing(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
        cs.setString(1, module_id);
        cs.setString(2, report_id);
        cs.setString(3, dest_locn_type);
        cs.setString(4, dest_locn_code);
        cs.setString(5, facility_id);
        cs.setString(6, ws_no);
        cs.setString(7, report_option);
        cs.registerOutParameter(8, Types.VARCHAR);
        cs.registerOutParameter(9, Types.VARCHAR);
        cs.registerOutParameter(10, Types.VARCHAR);
        cs.registerOutParameter(11, Types.VARCHAR);
        cs.registerOutParameter(12, Types.VARCHAR);
        cs.registerOutParameter(13, Types.VARCHAR);
        cs.registerOutParameter(14, Types.VARCHAR);
        cs.registerOutParameter(15, Types.VARCHAR);
        cs.registerOutParameter(16, Types.VARCHAR);
        cs.registerOutParameter(17, Types.VARCHAR);
        System.err.println("Before Execute: ");
        cs.execute();

        // Retrieve output parameters
        String report = cs.getString(8);
        String server = cs.getString(9);
        String copies = cs.getString(10);
        String queue_name = cs.getString(12);
        
        String status = cs.getString(14);
        String message = cs.getString(15);
        String app_server_ip = cs.getString(16);
        String rep_server_key = cs.getString(17);
        
        System.err.println("remaining out params : "+cs.getString(11)+", "+cs.getString(13)+", "+cs.getString(14));
		System.err.println("After Execute: "+status+", "+report+", "+server+", "+copies+", "+queue_name+", "+message+", "+app_server_ip+", "+rep_server_key);
		
        if (copies == null || copies.equals("null") || copies.equals("")) copies = "1";
        if (message == null) message = "";
        if (status == null) status = "";

        // Determine the report server URL
        if (report_ssl_yn == null) report_ssl_yn = "";
        if (report_ssl_yn.equals("Y")) {
            reportServer = "https://" + app_server_ip + reportServer;
        } else {
            reportServer = "http://" + app_server_ip + reportServer;
        }

     // Construct the JSON response
        jsonResponse.addProperty("status", status);
        jsonResponse.addProperty("reportServer", reportServer);
        jsonResponse.addProperty("report", report);
        jsonResponse.addProperty("server", server);
        jsonResponse.addProperty("copies", copies);
        jsonResponse.addProperty("queue_name", queue_name);
        jsonResponse.addProperty("message", message);
        jsonResponse.addProperty("rep_server_key", rep_server_key);
        jsonResponse.addProperty("reportServerEnableFlag", reportServerEnableFlag); 

 
    } catch (Exception e) {
        // Log and handle exceptions
        System.err.println("Exception in report_options_form.jsp: " + e);
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        
        out.print("{\"status\": \"error\", \"message\": \"" + e.getMessage() + "\"}");
    } finally {
    	if(cs != null )cs.close();
        if (con != null) ConnectionManager.returnConnection(con, request);
    }
	 System.err.println("jsonResponse.toString() "+jsonResponse.toString());
     out.println(jsonResponse.toString());

            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
