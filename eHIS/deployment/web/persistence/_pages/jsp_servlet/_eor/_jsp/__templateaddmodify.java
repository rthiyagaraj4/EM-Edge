package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __templateaddmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/TemplateAddModify.jsp", 1709120036000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\'/>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\n<!-- \t<script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script>\n -->\t<script language=\"JavaScript\" src=\"../js/OrCommon.js\"></script>\n\t<!-- <script language=\"JavaScript\" src=\"../js/OrMessages.js\"></script> -->\n\t<script language=\"JavaScript\" src=\"../js/Template.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body  OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n\t<form name=\"templateAddModifyForm\" id=\"templateAddModifyForm\">\n\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\">\n\t\t\t<tr>\n\t\t\t\t<td align=\"right\" width=\"39%\" class=\"label\"> Prompt &nbsp</td>\n\t\t\t\t<td align=\"left\" width=\"61%\"> <input type=text name=\"templatePrompt\" id=\"templatePrompt\" value=\"\"> </td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t\t<br>\n\t\t\t\t</td>\n\t\t\t\t<td> </td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td align=\"right\" width=\"39%\" class=\"label\"> Row Position &nbsp</td>\n\t\t\t\t<td align=\"left\" width=\"61%\"> <input type=text name=\"templateRowPosition\" id=\"templateRowPosition\" value=\"\"> </td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t\t<br>\n\t\t\t\t</td>\n\t\t\t\t<td> </td>\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td align=\"right\" width=\"39%\" class=\"label\"> Column Position &nbsp</td>\n\t\t\t\t<td align=\"left\" width=\"61%\"> <input type=text name=\"templateColumnPosition\" id=\"templateColumnPosition\" value=\"\"> </td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t\t<br>\n\t\t\t\t</td>\n\t\t\t\t<td> </td>\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td align=\"right\" width=\"39%\" class=\"label\"> Column Span &nbsp</td>\n\t\t\t\t<td align=\"left\" width=\"61%\"> <input type=text name=\"templateColumnSpan\" id=\"templateColumnSpan\" value=\"\"> </td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t\t<br>\n\t\t\t\t</td>\n\t\t\t\t<td> </td>\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td align=\"right\" width=\"39%\" class=\"label\"> Label Position &nbsp</td>\n\t\t\t\t<td align=\"left\" width=\"61%\"> \n\t\t\t\t\t<select name=\"templateLabelSelect\" id=\"templateLabelSelect\" onchange=\"\">\n\t\t\t\t\t\t<option selected> Left </option>\n\t\t\t\t\t\t<option> Top </option>\n\t\t\t\t\t</select>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t\t<br>\n\t\t\t\t</td>\n\t\t\t\t<td> </td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t\t<br>\n\t\t\t\t</td>\n\t\t\t\t<td> </td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td align=\"right\" width=\"39%\"> <input type=button class=button value=\" Add \" onclick=\"\"> </td>\n\t\t\t\t<td align=\"left\" width=\"61%\"><input type=button class=button value=\"Clear\" onclick=\"javascript:clearAll()\"> </td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t\t<br>\n\t\t\t\t</td>\n\t\t\t\t<td> </td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t\t<br>\n\t\t\t\t</td>\n\t\t\t\t<td> </td>\n\t\t\t</tr>\n\t\t</table>\n\t</form>\n</body>\n</html>\n\n";
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



            _bw.write(_wl_block2Bytes, _wl_block2);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
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
