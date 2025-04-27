package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import eCA.*;
import webbeans.eCommon.*;

public final class __vitalsignbuttons extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/VitalSignButtons.jsp", 1709116466588L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<html>\n<head>\n<script language=\'javascript\' src=\'../js/VitalSign.js\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\"VitalSignButtonForm\" id=\"VitalSignButtonForm\">\n<table width=\"100%\" height=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n    <tr >\n       <td align=\"right\" valign=\"middle\">\n\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t<input type=\'button\' class=\'button\' name=\'Record\' id=\'Record\' id=\'Record\' value=\'Acknowledge\' ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" onclick =\'ackResultGraph()\'/>\n\t\t<input type=\'button\' class=\'button\' name=\'Delete\' id=\'Delete\' id=\'Delete\' value=\'Delete\' ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" onclick =\'updateGraph()\'/>\n\t\t<input type=\'button\' class=\'button\' name=\'Critical\' id=\'Critical\' id=\'Critical\' value=\'Critical\' ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" onclick =\'criticalGraph()\'/>\t\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" onclick =\'ackResult()\'/>\n\t\t<input type=\'button\' class=\'button\' name=\'Delete\' id=\'Delete\' id=\'Delete\' value=\'Delete\' ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" onclick =\'update()\'/>\n\t\t<input type=\'button\' class=\'button\' name=\'Critical\' id=\'Critical\' id=\'Critical\' value=\'Critical\' ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" onclick =\'critical()\'/>\t\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" onclick =\'ackResultDT()\'/>\n\t\t<input type=\'button\' class=\'button\' name=\'Delete\' id=\'Delete\' id=\'Delete\' value=\'Delete\' ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" onclick =\'updateDT()\'/>\n\t\t<input type=\'button\' class=\'button\' name=\'Critical\' id=\'Critical\' id=\'Critical\' value=\'Critical\' ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" onclick =\'criticalDT()\'/>\t\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t</td>\n    </tr>\t\n</table>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

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
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	dit History     Name      	Rev.Date	Rev.Name	Description
-------------------------------------------------------------------------------------------------------------------
11/04/2019	IN069244	Ramya Maddena	 25/01/2019	Ramesh Goli	   MMS-KH-CRF-0005.1
01/11/2023      Srinivasa N T                                   Ramesh Goli         AAKH-CRF-0165
-------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

request.setCharacterEncoding("UTF-8");
String totDiscCount = request.getParameter("totDiscCount")==null?"0":request.getParameter("totDiscCount");
String graphMode=request.getParameter("graphMode")==null?"":request.getParameter("graphMode");
String disableString="disabled";
if(!"0".equals(totDiscCount))
	disableString="";

            _bw.write(_wl_block3Bytes, _wl_block3);
if((graphMode).equals("G")) {
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(disableString));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(disableString));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(disableString));
            _bw.write(_wl_block7Bytes, _wl_block7);
}else if((graphMode).equals("T")){ 
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(disableString));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(disableString));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(disableString));
            _bw.write(_wl_block10Bytes, _wl_block10);
}else{ 
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(disableString));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(disableString));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(disableString));
            _bw.write(_wl_block13Bytes, _wl_block13);
} 
            _bw.write(_wl_block14Bytes, _wl_block14);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
