package jsp_servlet._portal._jsp._schedule;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __confirmbookrequest extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/portal/jsp/schedule/ConfirmBookRequest.jsp", 1669269355953L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\r\n<!DOCTYPE html>\r\n<html>\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n<title>Confirm Book Request</title>\r\n<meta name=\"keywords\" content=\"\" />\r\n<meta name=\"description\" content=\"\" />\r\n<link rel=\"stylesheet\" href=\"../../css/style.css\" type=\"text/css\"/>\r\n<link rel=\"stylesheet\" href=\"../../css/style_ie.css\" type=\"text/css\"/>\r\n<script src=\"../../js/jquery.min.js\"></script>\r\n<style scoped>\r\n\r\n#bookedpopwrapper\r\n{\r\n\twidth:575px;\r\n\theight:auto;\r\n\tbackground-color:#ffffff;\r\n\t-moz-box-shadow: 0px 0px 10px  #ADADAD;\r\n\t-webkit-box-shadow: 0px 0px 10px  #ADADAD;\r\n\tbox-shadow: 0px 0px 10px  #ADADAD;\r\n}\r\n\r\n#bookedpopmsgbox\r\n{\r\n\twidth:564px;\r\n\theight:auto;\r\n\tmargin:5px 5px 5px 4px;\r\n\tborder:#92b82d solid 1px;\r\n\tbackground-color:#ffffff;\r\n\tdisplay:table;\r\n}\r\n\r\n</style>\r\n</head>\r\n<body>\r\n\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n<div id=\"bookedpopwrapper\">\r\n\t\r\n<div id=\"popheader\">\r\n<div class=\"row\">\r\n\t\t<div id=\"poptitle\">Confirmation\r\n        </div>\r\n        \r\n\t\t<div id=\"close\" onclick=\"cancelOperation()\">x\r\n        </div>\r\n    \r\n</div>\r\n</div>\r\n\r\n<div id=\"bookedpopmsgbox\" >\r\n\r\n<div id=\"resultholder\" >\r\n\t<div class=\"row\">\r\n    \t\r\n        <div id=\"resultcell\">\r\n        <span id=\"resulttitle\">Please confirm the details</span>\r\n\t\t<div class=\"bookedDetails\">\r\n\t\t\t<div class=\"bookedcontent\">\r\n\t\t\t<span class=\"contenbold\">";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =",</span><span class=\"contentnormal\"> ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="</span><br/>\r\n\t\t\t<div class=\"popupoverflow\" >\r\n\t\t\t\t<div class=\"floatleft\">\r\n\t\t\t\t\t<span class=\"contentnormalpopup\">Appointment Date and Time</span>\r\n\t\t\t\t</div>\r\n\t\t\t\t<div class=\"floatleft\">\r\n\t\t\t\t\t<span class=\"contentnormal\">:</span><span class=\"contenbold\">";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =", ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</span>\r\n\t\t\t\t\t<!-- <span class=\"contentnormal\">:</span><span class=\"contenbold\">16 Dec 2012, 2:30 - 3:00</span> -->\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t\t</div>\r\n\t\t</div>\r\n        \t<span><a href=\"#\" onclick=\"performOperation()\" class=\"popbtncenter\">Confirm</a></span>\r\n\t\t\t<span><a href=\"#\" onclick=\"cancelOperation()\" class=\"popbtncenter\">Cancel</a></span>\r\n        </div>\r\n         \r\n        \r\n    </div>\r\n    \r\n\r\n</div>\r\n\r\n</div>\r\n</div>\r\n<!-- #wrapper -->\r\n\r\n</body>\r\n</html>\r\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

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

String practitionerName = request.getParameter("practitionerName");
if(practitionerName == null){
	practitionerName = "";
}

String specialty = request.getParameter("specialty");
if(specialty == null){
	specialty = "";
}
String preferredDate = request.getParameter("preferredDate");
if(preferredDate == null){
	preferredDate = "";
}

String selectedTimeSlot = request.getParameter("selectedTimeSlot");
if(selectedTimeSlot == null){
	selectedTimeSlot = "";
}



            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(practitionerName ));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(specialty ));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(preferredDate ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(selectedTimeSlot ));
            _bw.write(_wl_block6Bytes, _wl_block6);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
