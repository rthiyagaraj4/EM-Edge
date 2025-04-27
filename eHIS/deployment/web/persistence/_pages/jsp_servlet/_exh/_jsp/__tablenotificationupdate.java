package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.text.DateFormat;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eXH.*;
import eXH.XHDBAdapter;
import java.io.*;
import java.util.*;

public final class __tablenotificationupdate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/TableNotificationUpdate.jsp", 1709117589392L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\t\n\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>TrackNotificationTable</title>\n</head>\n<body>\n<div id=\"resubmitteddata\">\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t</div>\n</body>\n</html>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	Connection con = null;
	PreparedStatement pst = null;
	PreparedStatement pst1 = null;
	ResultSet rs = null;

	String app_id = request.getParameter("app_id");
	String event_type = request.getParameter("event_type");
	String notification_status = request.getParameter("notification_status");
	
	String message_id = request.getParameter("message_id");
	List<String> messageIdList = Arrays.asList(message_id.split(","));
	
	//String[] message_id_array = message_id.split(",");
	String facility_id = null;

            _bw.write(_wl_block3Bytes, _wl_block3);
 
		try {
			for (int i = 0; i < messageIdList.size(); i++) {
				
				System.out.println("app_id..."+app_id);
				System.out.println("messageIdList.get(i)..."+messageIdList.get(i));
			
						con = ConnectionManager.getConnection();
						String facility_id_query = "SELECT FACILITY_ID FROM XH_NOTIFY_EVENT_MESSAGE_VW WHERE APPLICATION_ID = ? AND MESSAGE_ID = ?";
						pst1 = con.prepareStatement(facility_id_query); 
						
						pst1.setString(1, app_id);
						pst1.setString(2, messageIdList.get(i));
						rs = pst1.executeQuery();
						while(rs.next()){
							facility_id = rs.getString(1);
						}
						
						System.out.println("facility_id..."+facility_id);
					
						String updqry = "UPDATE XH_APPLICATION_MESSAGE SET MESSAGE_STATUS = NULL WHERE APPLICATION_ID = ? AND FACILITY_ID = ? AND MESSAGE_ID = ?";
				        
						pst = con.prepareStatement(updqry.toString());
						//for(int i = 0; i<message_id_array.length; i++){
						pst.setString(1, app_id);
						pst.setString(2, facility_id);
						pst.setString(3, messageIdList.get(i));
						
						pst.executeUpdate();
						con.commit();
						
						if (pst != null)
							pst.close();
						
						if (pst1 != null)
							pst1.close();
						
						if (con != null)
							con.close();
			}
		}
catch (Exception e1) {
		System.out.println("TableNotificationUpdate.jsp Exc1 : "
				+ e1.toString());
		e1.printStackTrace(System.err);
	} finally {
		
		if (pst != null)
			pst.close();
		
		if (pst1 != null)
			pst1.close();
		
		if (con != null)
			con.close();
	}

            _bw.write(_wl_block4Bytes, _wl_block4);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
