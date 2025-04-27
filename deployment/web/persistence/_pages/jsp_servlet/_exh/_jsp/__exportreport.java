package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.Connection;
import com.ehis.util.DateUtils;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eXH.XHDBAdapter;
import java.util.*;
import com.ehis.util.*;

public final class __exportreport extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/ExportReport.jsp", 1709122332913L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<HTML>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t\n\n<HEAD>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'></link>\n<script language=\"javascript\" src=\"../../eXH/js/XHAjaxUtil.js\"></script>\n<script type=\"text/javascript\" src=\"../../eXH/js/trackNotificationTable.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<title>Report Option</title>\n</HEAD>\n<body>\n<form id=\"ExportReportFormId\" name=\"ExportReportForm\" id=\"ExportReportForm\" method=\"post\">\n\t<table style=\"width: 100%;\">\n\t\t<tr>\n\t\t\t<td>\n\n\t\t\t\t<table style=\"width: 80%;\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=label>Report Option</td>\n\t\t\t\t\t\t<td></td>\n\t\t\t\t\t\t<td></td>\n\t\t\t\t\t\t<td></td>\n\t\t\t\t\t\t<td></td>\n\t\t\t\t\t\t<td></td>\n\t\t\t\t\t\t<td></td>\n\t\t\t\t\t\t<td></td>\n\t\t\t\t\t\t<td class=label><select id=\"reportOption\">\n\t\t\t\t\t\t\t\t<option value=\"View\">View</option>\n\t\t\t\t\t\t\t\t<option value=\"Print\">Print</option>\n\t\t\t\t\t\t\t\t<option value=\"Save\">Save</option></td>\n\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=label>File Format</td>\n\t\t\t\t\t\t<td></td>\n\t\t\t\t\t\t<td></td>\n\t\t\t\t\t\t<td></td>\n\t\t\t\t\t\t<td></td>\n\t\t\t\t\t\t<td></td>\n\t\t\t\t\t\t<td></td>\n\t\t\t\t\t\t<td></td>\n\t\t\t\t\t\t<td class=label><select id=\"fileFormat\" name=\"fileType\" id=\"fileType\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t\t\t\t<option value=\"SpreadSheet\">SpreadSheet</option></td>\n\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr></tr>\n\t\t\t\t\t<tr></tr>\n\t\t\t\t\t<tr></tr>\n\t\t\t\t\t<tr></tr>\n\t\t\t\t\t<tr></tr>\n\t\t\t\t\t<tr></tr>\n\n\t\t\t\t</table> <br /> <br /> <br /> <br /> <br />\n\t\t\t\t<table>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td></td>\n\t\t\t\t\t\t<td></td>\n\t\t\t\t\t\t<td></td>\n\t\t\t\t\t\t<td></td>\n\t\t\t\t\t\t<td></td>\n\t\t\t\t\t\t<td></td>\n\t\t\t\t\t\t<td></td>\n\t\t\t\t\t\t<td></td>\n\t\t\t\t\t\t<td></td>\n\t\t\t\t\t\t<td></td>\n\t\t\t\t\t\t<td></td>\n\t\t\t\t\t\t<td></td>\n\t\t\t\t\t\t<td></td>\n\t\t\t\t\t\t<td></td>\n\t\t\t\t\t\t\t<td class=label align=\"center\"><button\n\t\t\t\t\t\t\t\tonclick=\"exportingTrackNotification()\">OK</button>\n\t\t\t\t\t\t\t<button onclick=\"closeExportReport()\">Cancel</button></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</center>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n\t<iframe id = \"dummyFrame\" style = \"display:none\"> </iframe>\n\t\n\t<input type=\'hidden\' name=\'app_id\' id=\'app_id\' id=\'app_id\' value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>\n\t<input type=\'hidden\' name=\'event_type\' id=\'event_type\' id=\'event_type\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n\t<input type=\'hidden\' name=\'notification_status\' id=\'notification_status\' id=\'notification_status\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\t<input type=\'hidden\' name=\'specimen_from_date\' id=\'specimen_from_date\' id=\'specimen_from_date\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t<input type=\'hidden\' name=\'specimen_to_date\' id=\'specimen_to_date\' id=\'specimen_to_date\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t<input type=\'hidden\' name=\'onlyRequiredColumnCompleteQuery\' id=\'onlyRequiredColumnCompleteQuery\' id=\'onlyRequiredColumnCompleteQuery\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
 																	    
request.setCharacterEncoding("UTF-8");
String locale = ((String)session.getAttribute("LOCALE"));
String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
session.putValue("PatientSearch","true" );

String app_id = request.getParameter("app_id");
String event_type = request.getParameter("event_type");
String notification_status = request.getParameter("notification_status");
String specimen_from_date = (String)request.getParameter("specimen_from_date");
String specimen_to_date = (String)request.getParameter("specimen_to_date");
String onlyRequiredColumnCompleteQuery = (String)request.getParameter("onlyRequiredColumnCompleteQuery");


            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf( app_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( event_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( notification_status));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( specimen_from_date));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( specimen_to_date));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( onlyRequiredColumnCompleteQuery));
            _bw.write(_wl_block13Bytes, _wl_block13);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
