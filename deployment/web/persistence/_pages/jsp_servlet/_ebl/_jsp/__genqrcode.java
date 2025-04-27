package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.Hashtable;
import eBL.BLReportIdMapper;
import com.google.gson.JsonObject;
import java.sql.Date;
import java.text.*;
import java.text.SimpleDateFormat;
import org.json.simple.JSONObject;
import eBL.BLInsuranceImageBean;
import eBL.BLInsuranceImage;
import com.ehis.persist.PersistenceHelper;

public final class __genqrcode extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/genQRCode.jsp", 1737917053986L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n<HTML>\n<HEAD>\n<style>\n#loading {\n    background: url(\'../../eBL/images/giphy.gif\') no-repeat center center;\n    position: absolute;\n    top: 0;\n    left: 0;\n    height: 100%;\n    width: 100%;\n    z-index: 9999999;\n}\n\n#success {\n    background: url(\'../../eBL/images/success.gif\') no-repeat center center;\n    position: absolute;\n    top: 0;\n    left: 0;\n    height: 100%;\n    width: 100%;\n    z-index: 9999999;\n}\n</style>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n$(function() {\n$(\'#success\').hide();\n});\n\n\nfunction genQRCode(facility_id,patientid,episode_id,functionMode,logInId,episodeType,WsNo,visitId,docNum,docTypeCode,qrCode)\n{ \n\tvar xmlStr =\"<root><SEARCH \";\n\txmlStr +=\" /></root>\";\n\tvar xmlDoc = \"\";\n\tvar xmlHttp = new XMLHttpRequest();\t\t\t\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\tvar temp_jsp=\"../../eBL/jsp/BLCommonAjax.jsp?functionMode=\"+functionMode+\"&patientid=\"+patientid+\"&episode_id=\"+episode_id+\"&facility_id=\"+facility_id+\"&logInId=\"+logInId+\"&episodeType=\"+episodeType+\"&WsNo=\"+WsNo+\"&visitId=\"+visitId+\"&docNum=\"+docNum+\"&docTypeCode=\"+docTypeCode+\"&qrCode=\"+qrCode; \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\txmlHttp.open(\"POST\",temp_jsp,false);\n\txmlHttp.send(xmlDoc);\n\tresponseText = trimString(xmlHttp.responseText);\t\n\tif(responseText!=\"\"){\n\t\t$(\'#loading\').hide();\n\t\t$(\'#message\').html(\"Code Generated Successfully\");\n\t\t$(\'#success\').show();\n\t\twindow.open(\'\', \'_self\', \'\');\n\t\twindow.close();\n\t}\n}\n\n//Trim String\nfunction trimString(sInString)\n{\n  sInString = sInString.replace( /^\\s+/g, \"\" );// strip leading\n  return sInString.replace( /\\s+$/g, \"\" );// strip trailing\n}\n\n</script>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t<script>\n\t\tgenQRCode(\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\',\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'); \n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n</HEAD>\n<BODY onload=\"window.resizeTo(600,600);\">\n<div id=\"loading\"></div>\n<p id=\"message\">QR Code getting Generated</p>\n<div id=\"success\"></div>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

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
/*
Sr No        Version           Incident        SCF/CRF             			Developer Name
-------------------------------------------------------------------------------------------
 1           V210407                        AMS-CRF-0238,AMRI-CRF-0473,    
											GHL-CRF-0635				      Ram kumar S

*/ 
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String facility_id = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");
	String calling_from_2T=request.getParameter("calling_from_2T") == null ? "N":request.getParameter("calling_from_2T");
	String episode_id = request.getParameter("episode_id") == null ? "" : request.getParameter("episode_id");
	String functionMode = request.getParameter("functionMode") == null ? "" : request.getParameter("functionMode");
	String login_id = request.getParameter("p_login_user") == null ? "" : request.getParameter("p_login_user");
	String episode_type = request.getParameter("episode_type") == null ? "" : request.getParameter("episode_type");
	String WS_No = request.getParameter("ADDED_AT_WS_NO") == null ? "" : request.getParameter("ADDED_AT_WS_NO");
	String visit_id = request.getParameter("visit_id") == null ? "" : request.getParameter("visit_id");
	String docNum = request.getParameter("p_doc_num") == null ? "" : request.getParameter("p_doc_num");
	String docTypeCode = request.getParameter("p_doc_type_code") == null ? "" : request.getParameter("p_doc_type_code");
	String qrCode = request.getParameter("qr_Code") == null ? "" : request.getParameter("qr_Code");
	String client_ip_address = request.getRemoteAddr();
	System.err.println("request  "+request.getQueryString());
	System.err.println("patient_id  "+patient_id);
	System.err.println("facility_id  "+facility_id);
	System.err.println("calling_from_2T  "+calling_from_2T);
	System.err.println("episode_id  "+episode_id);
	System.err.println("functionMode  "+functionMode);
	System.err.println("login_id  "+login_id);
	System.err.println("episode_type  "+episode_type);
	System.err.println("WS_No  "+WS_No);
	System.err.println("visit_id  "+visit_id);
	System.err.println("docNum  "+docNum);
	System.err.println("docTypeCode  "+docTypeCode);
	System.err.println("qrCode  "+qrCode);
	
	
	Connection con = null;
	PreparedStatement pstmt=null; 
	ResultSet rs =null;
	PreparedStatement pstmt1=null; 
	ResultSet rs1 =null;
	HttpSession httpSession = request.getSession(false);
	String jdbc_username="";
	String jdbc_password="";
	String jdbc_dns="";
	String jdbc_driver="";
	String login_app_user="";
	try
	{	
		con =  ConnectionManager.getConnection(request);
		String sql = "select app_password.decrypt(appl_user_password) from sm_appl_user where appl_user_id = ?";
		String sql1="select USER_ID,app_password.decrypt(password),CONNECT_STRING,DB_DRIVER  from sm_db_info" ;
			
		pstmt=con.prepareStatement(sql);
		pstmt1=con.prepareStatement(sql1);
		pstmt.setString(1,login_id);	
		
		rs=	pstmt.executeQuery();
		rs1=pstmt1.executeQuery();
		while(rs.next())
		{
			login_app_user	=rs.getString(1);	
		}
		while(rs1.next())
			{
				jdbc_username	=rs1.getString(1);	
				jdbc_password	=rs1.getString(2);
				jdbc_dns	=rs1.getString(3);
				jdbc_driver =rs1.getString(4);	
			}	
		}
		catch(Exception e)
		{
			System.err.println(e);
			e.printStackTrace();
		}
		finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (rs1 != null) {
					rs1.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (pstmt1 != null) {
					pstmt1.close();
				}
				if (con != null) {
					ConnectionManager.returnConnection(con);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}	
	
	//String jdbc_props = "";
	session.putValue("facility_id",facility_id);
	session.putValue("login_user",login_app_user);
	session.putValue("connection_pooling_yn","Y");
	session.putValue("LOCALE","en");
	session.putValue("PREFERRED_STYLE","IeStyle.css");
	
	Properties p = new Properties() ;
	
	p.setProperty( "login_user",login_app_user ) ;	
	p.setProperty("connection_pooling_yn","Y") ;	
	p.setProperty("client_ip_address",client_ip_address) ;
	p.setProperty("strLogged_dns",jdbc_dns);
	p.setProperty("strLogged_driver",jdbc_driver) ;
	p.setProperty("ecis_jdbc_user",jdbc_username);
	p.setProperty("ecis_jdbc_password",jdbc_password);
	session.putValue( "jdbc",p );
	System.out.println("120==>>"+calling_from_2T);
	
            _bw.write(_wl_block3Bytes, _wl_block3);
 
	if(calling_from_2T.equals("Y"))
	{
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(functionMode));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(login_id));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(WS_No));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(docNum));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(docTypeCode));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(qrCode));
            _bw.write(_wl_block6Bytes, _wl_block6);
 }
            _bw.write(_wl_block7Bytes, _wl_block7);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
