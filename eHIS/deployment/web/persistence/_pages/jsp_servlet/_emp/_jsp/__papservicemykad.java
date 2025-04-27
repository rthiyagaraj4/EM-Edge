package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import java.io.File;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import webbeans.eCommon.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.ArrayList;

public final class __papservicemykad extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/PapServiceMyKad.jsp", 1709118667840L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n<script src=\"../../eMP/IRISMyKad/jquery-3.2.1.min.js\"></script>\n<script src=\"../../eMP/js/CardReaderMyKad.js\"></script>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\nreadCarderData();\t\t\n</script>\n <input name=\"func_name\" id=\"func_name\" id=\"func_name\" type=\"hidden\" value=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\">\n\t<div id=\"preloader\" style=\"width: 100%; text-align: center;\">\n\t\t<span id=\"InProgress\"><br>Card Reading In Progress...<br></span>\n\t\t<img src=\"../../eCommon/images/LoadingCircle.gif\" alt=\"\" style=\"position: absolute; top: 40%;left: 40%;display: block;\" />\n\t</div>\n\t<div id=\"fingerFail\">\n\t\t<div class=\"message\"></div>\n\t\t<br>\n\t\t<button class=\"Ok\">OK</button> \n\t</div>\n\t<div id=\"overwrite\">\n\t\t<div class=\"message\"></div>\n\t\t<br>\n\t\t<button class=\"Ok\">OK</button> \n\t\t<button class=\"Cancel\">Cancel</button>\n\t</div>\n\t<style>\n      #confirm {\n         display: none;\n         background-color: #F3F5F6;\n         color: #000000;\n         border: 1px solid #aaa;\n         position: fixed;\n         width: 320px;\n         height: 130px;\n         left: 30%;\n\t\t font:150px;\n         margin-left: -100px;\n         padding: 10px 20px 10px;\n         box-sizing: border-box;\n         text-align: center;\n      }\n\t   #fingerFail {\n         display: none;\n         background-color: #F3F5F6;\n         color: #000000;\n         border: 1px solid #aaa;\n         position: fixed;\n         width: 320px;\n         height: 130px;\n         left: 30%;\n         margin-left: -100px;\n         padding: 10px 20px 10px;\n         box-sizing: border-box;\n         text-align: center;\n      }\n\t   #overwrite {\n         display: none;\n         background-color: #F3F5F6;\n         color: #000000;\n         border: 1px solid #aaa;\n         position: fixed;\n         width: 320px;\n         height: 130px;\n         left: 30%;\n         margin-left: -100px;\n         padding: 10px 20px 10px;\n         box-sizing: border-box;\n         text-align: center;\n      }\n      #confirm button {\n     /*    background-color: #FFFFFF;*/\n         display: inline-block;\n      /*   border-radius: 12px;\n         border: 4px solid #aaa;*/\n         padding: 5px;\n         text-align: center;\n         width: 60px;\n         cursor: pointer;\n      }\n      #confirm .message {\n         text-align: left;\n      }\n \n</html>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );
	
			private String checkForNull(String inputString)
			{
				return (inputString==null)	?	""	:	inputString;
			}
			public static String checkForNull(String inputString, String defaultValue)
			{
				return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
			}
		

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

request.setCharacterEncoding("UTF-8");
String func_name = checkForNull(request.getParameter("func_name")); 

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(func_name));
            _bw.write(_wl_block3Bytes, _wl_block3);
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
