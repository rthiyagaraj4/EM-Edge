package jsp_servlet._ecommon._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __alertheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecommon/jsp/AlertHeader.jsp", 1709116502467L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n\t<head>\n\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\n\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n\t\t<title>Alert</title>\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\' />\n\t</head>\n\t<body>\n\t\t<!-- <input type=\"button\" style=\"background: url(../../eAlert/images/Alerticon.png) no-repeat center;width:24px;height:24px;border:0;cursor:pointer;\" onclick=\"showalert()\"/>\n\t\t<span id=\"unackalerts\" class=\"ALERTCOUNT\" style=\"vertical-align:top;align:left;\"></span> -->\n\t\t\n\t\t<div class=\"countcontainer\" onclick=\"showalert()\" style=\"cursor:pointer\">\n\n\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"background:transparent;\">\n\t\t\t\t<tr>\n\t\t\t\t    <td width=\"16\" height=\"27\" align=\"left\" valign=\"bottom\"><img src=\"../../eAlert/images/Alert_Icon.PNG\" width=\"16\" height=\"16\" /></td>\n\t\t\t\t    \t<td width=\"73%\" height=\"27\" align=\"left\" valign=\"top\">\n\t\t\t\t    \t<div id=\"countdiv\" class=\"countdigit\" style=\"display:block\">\n\t\t\t\t    \t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t    \t\t<td width=\"4\" align=\"left\" valign=\"top\"><img src=\"../../eAlert/images/CountLeft.png\" width=\"4\" height=\"16\" /></td>\n\t\t\t\t\t\t\t    \t<td background=\"../../eAlert/images/CountCenter.png\">\n\t\t\t\t\t\t\t    \t\t<span class=\"countnum\" id=\"unackalerts\"></span>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td width=\"4\" align=\"right\" valign=\"top\"><img src=\"../../eAlert/images/CountRight.png\" width=\"4\" height=\"16\" /></td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\n\t\t\n\t</body>\n\t<script type=\"text/javascript\">\n\tfunction showalert()\n\t{\n\t\twindow.showModalDialog(\"../../eAlert/jsp/AlertContainer.jsp\", null, \"dialogWidth:330px; dialogHeight:470px; center:yes; status:no; toolbar:no\");\n\t}\n\t\n\tfunction unackalertcount(){\n\t\tvar unAckAlerts = getUnacknowledgedAlerts(\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\");\n\t\tvar countdiv = document.getElementById(\"countdiv\");\n\t\tif(unAckAlerts == \"0\"){\n\t\t\tdocument.getElementById(\"unackalerts\").innerHTML = \"\";\n\t\t\tcountdiv.style.display = \'none\';\n\t\t}\n\t\telse{\n\t\t\tdocument.getElementById(\"unackalerts\").innerHTML = unAckAlerts;\n\t\t\tcountdiv.style.display = \'block\';\n\t\t}\n\t\t//document.getElementById(\"unackalerts\").innerHTML = getUnacknowledgedAlerts(\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\");  \n\t}\n\t\n\twindow.setInterval(\"unackalertcount()\", \"60000\");\n\tunackalertcount();\n\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</html>\n\n";
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String p_user_name= (String) session.getValue( "login_user" ) ;
	
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(p_user_name));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(p_user_name));
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
