package jsp_servlet._ecommon._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __emdashboard extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecommon/jsp/EMDashboard.jsp", 1709116504826L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<HTML>\n<HEAD>\n<title>EM Dashboard</title>\n</HEAD>\n<script>\n\nfunction openDashBoard()\n{\t\t\n\t\n\n\t//window.open(\"../../eCommon/jsp/EMDashboardValidate.jsp?username=\"+document.forms[0].username.value, \'EM\', \'location=0,height=700,width=1050,top=0,left=200,resizable=yes,titlebar=yes,title=EMDashboard\');\n\n\tvar url_arr=document.forms[0].url.value.split(\".jsp\");\n\tvar dash_url=url_arr[0]+\"Validate.jsp?username=\"+document.forms[0].username.value;\n\tMyObject = new ActiveXObject( \"WScript.Shell\" )   \n\n\t\t  \n\t\n   try{\t \n       MyObject.Exec(\"C:\\\\Program Files\\\\Google\\\\Chrome\\\\Application\\\\chrome.exe --new-window \" +dash_url\t);\n      \n   }catch(exception){\n\t   window.open(\"../../eCommon/jsp/EMDashboardValidate.jsp?username=\"+document.forms[0].username.value, \'EM\', \'location=0,height=700,width=1600,top=0,left=0,resizable=yes,titlebar=yes,title=EMDashboard\');\n   }\n          \n\n\tparent.frames[2].location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t\n}\n\n\n</script>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n<BODY >\n\n<form name=\"emdash\" id=\"emdash\" >\n  <input type=\"hidden\" name=\"username\" id=\"username\" value=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\">\n  <input type=\"hidden\" name=\"url\" id=\"url\" value=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\">\n  \n</form>\n\n</BODY>\n \n\n</HTML>\n\t<script >\n\n\topenDashBoard();\n\t</script>\n\n\n";
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

String user_id				= (String) session.getAttribute( "login_user" ) ;
String url=request.getRequestURL().toString();


	
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(url));
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
