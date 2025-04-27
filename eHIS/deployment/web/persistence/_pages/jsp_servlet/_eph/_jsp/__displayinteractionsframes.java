package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __displayinteractionsframes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DisplayInteractionsFrames.jsp", 1723551362027L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 =" <!--This file is saved on 07/11/2005-->\n<!doctype html public \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n<html>\n<head>\n<title> <fmt:message key=\"ePH.DrugToDrugInteractions.label\" bundle=\"";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\"/> </title>\n<meta name=\"Generator\" content=\"EditPlus\">\n<meta name=\"Author\" content=\"\">\n<meta name=\"Keywords\" content=\"\">\n<meta name=\"Description\" content=\"\">\n</head>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<iframe name=\"f_interactions\" id=\"f_interactions\" frameborder=\"3\" scrolling=\"auto\" noresize src=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\" style=\"height:85vh;width:100vw\"></iframe><iframe name=\"f_interactionsclose\" id=\"f_interactionsclose\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../ePH/jsp/DisplayInteractionsButton.jsp?JSFile=";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\" style=\"height:15vh;width:100vw\"></iframe>\n</html>\n\n";
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
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block1Bytes, _wl_block1);

String patientid=request.getParameter("patientid");
String orderid=request.getParameter("orderid");
String encounterid=request.getParameter("encounterid");
String url;
url="../../ePH/jsp/DisplayInteractions.jsp?patientid="+patientid+"&orderid="+orderid+"&encounterid="+encounterid;
String JSFile=request.getParameter("JSFile");

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(url));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(JSFile));
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
