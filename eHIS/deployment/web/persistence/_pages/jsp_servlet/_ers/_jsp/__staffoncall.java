package jsp_servlet._ers._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __staffoncall extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/StaffOnCall.jsp", 1709616101293L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--StaffOnCall.jsp\n*\tCopyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED\n*\tApplication\t\t:\teRS\n*\tPurpose \t\t:\t\n*\tCreated By\t\t:\tSuchilagna Panigrahi\n*\tCreated On\t\t:\t12th May 2005\n-->\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<head>\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"JavaScript\" src=\"../js/RSCommon.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<!-- <script language=\"javascript\" src=\"../../eRS/js/RSMessages.js\"></script> -->\n<script language=\"javascript\" src=\"../js/StaffOnCall.js\"></script>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<title>";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="</title>\n</head>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n</head>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<iframe name=\'commontoolbarFrame\'\tsrc=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:0vh;width:100vw\'></iframe>\n<iframe name=\'f_query_view\' src=\'../../eRS/jsp/StaffOnCallCriteria.jsp?";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' frameborder=0 scrolling=\'no\' style=\'height:12vh;width:100vw\'></iframe>\n<iframe name=\'f_query_detail\' src=\'../../eRS/jsp/StaffOnCallResult.jsp\' frameborder=0 style=\'height:26vh;width:100vw\'></iframe>\n<iframe name=\'messageFrame\'\tsrc=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:9vh;width:100vw\'></iframe>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n<iframe name=\'f_query_view\' src=\'../../eRS/jsp/StaffOnCallCriteria.jsp?";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' frameborder=0 scrolling=\'no\' style=\'height:12vh;width:100vw\'></iframe>\n<iframe name=\'f_query_detail\' src=\'../../eCommon/html/blank.html\' frameborder=0 style=\'height:71vh;width:100vw\'></iframe>\n<iframe name=\'messageFrame\'\tsrc=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:9vh;width:100vw\'></iframe>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n</html>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

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

String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
String params = request.getQueryString();
String source = url + params ;
String title="";
String mode=request.getParameter("p_mode")==null?"":request.getParameter("p_mode");

            _bw.write(_wl_block1Bytes, _wl_block1);

if(mode.equals("CA")) 
{
title="Staff On Call";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(title));
            _bw.write(_wl_block3Bytes, _wl_block3);

}
else
{

            _bw.write(_wl_block4Bytes, _wl_block4);

}
if(mode.equals("CA")) {
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(source));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf( request.getQueryString()));
            _bw.write(_wl_block7Bytes, _wl_block7);
}else{
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(source));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( request.getQueryString()));
            _bw.write(_wl_block9Bytes, _wl_block9);
}
            _bw.write(_wl_block10Bytes, _wl_block10);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
