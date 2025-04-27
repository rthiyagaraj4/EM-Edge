package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __blreprintaudittrailreportmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLReprintAuditTrailReportMain.jsp", 1737916686781L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate     \t   Edit History              Name     \t\t\tDescription\n--------------------------------------------------------------------------------------------------------------\n10-JULY-2018      100           \tSubha Sundari M          Created\n---------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\' type=\'text/css\'/>\n\t<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\"src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n\t<script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\' ></script>\n\t<script language=\'javascript\' src=\'../../eBL/js/BLReprintAuditTrailReport.js\' ></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n</head>\n<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\'\tsrc=\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' frameborder=0 scrolling=\'no\' style=\'height:6vh;width:100vw\'></iframe><iframe name=\"reprintaudittrail\" id=\"reprintaudittrail\" SRC=\"../../eBL/jsp/BLReprintAuditTrailReport.jsp\" frameborder=0 noresize style=\"height:90vh;width:100vw\"></iframe>\n\t<iframe name=\"dummyFrame\" id=\"dummyFrame\"  src=\'../../eCommon/html/blank.html\' frameborder=0 noresize style=\'height:0vh;width:100vw\'></iframe>\t\t\t\n\t<iframe name=\"messageFrame\" id=\"messageFrame\"  src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize style=\'height:4vh;width:100vw\'></iframe>\n\n<body>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

		request.setCharacterEncoding("UTF-8");
		String url = "../../eCommon/jsp/commonToolbar.jsp?";
		String params = request.getQueryString();
		String source = url + params;
		System.out.println("Subha ->BLReprintAuditTrailReportMain.jsp: " + source);
	
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf( source));
            _bw.write(_wl_block5Bytes, _wl_block5);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
