package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __progressbar extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/progressbar.jsp", 1709122376163L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\" />\t\t\n    <meta charset=\"utf-8\">\n    <title>Using with progress bar</title>\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <meta name=\"description\" content=\"demonstration of some noty capabilities\">\n\n    <link href=\'http://fonts.googleapis.com/css?family=PT+Sans:regular,italic,bold,bolditalic&amp;subset=latin,latin-ext,cyrillic\' rel=\'stylesheet\' type=\'text/css\'>\n    <style type=\"text/css\">\n        html {\n            height: 100%;\n            width: 100%;\n        }\n\n        body {\n            font-family: \'PT Sans\', Tahoma, Arial, serif;\n            line-height: 13px\n        }\n    </style>\n\n\t<!--\n\n    <link rel=\"StyleSheet\" type=\"text/css\" href=\"buttons.css\"></link>\n\t<link rel=\"StyleSheet\" type=\"text/css\" href=\"animate.css\"></link>\n\t<link rel=\"StyleSheet\" type=\"text/css\" href=\"font-awesome/css/font-awesome.min.css\"></link>\n\n\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\n\t\n    <script type=\"text/javascript\" src=\"notification_html.js\"></script>\t\n\n\t-->\n\n\t<link rel=\"StyleSheet\" type=\"text/css\" href=\"../../eXH/js/noty/buttons.css\"></link>\n<link rel=\"StyleSheet\" type=\"text/css\" href=\"../../eXH/js/noty/animate.css\"></link>\n<link rel=\"StyleSheet\" type=\"text/css\" href=\"../../eXH/js/noty/font-awesome/css/font-awesome.min.css\"></link>\n\n<script language=\"javascript\" src=\"../../eXH/js/noty/jquery-1.8.0.js\"></script>\n<script type=\"text/javascript\" src=\"../../eXH/js/noty/notification_html.js\"></script>\t\n<script language=\"javascript\" src=\"../../eXH/js/noty/packaged/jquery.noty.packaged.js\"></script>\n\n    <script type=\"text/javascript\">\n\n        function generate(type, text) {\n\n\t\t/*\n\n           noty({  \n\t\t\t   \"text\":text,\n\t\t\t   \"layout\":\"bottomRight\",\n\t\t\t   \"type\":type,\n\t\t\t   \"animateOpen\":{  \n\t\t\t\t  \"height\":\"toggle\"\n\t\t\t   },\n\t\t\t   \"animateClose\":{  \n\t\t\t\t  \"height\":\"toggle\"\n\t\t\t   },\n\t\t\t   \"speed\":500,\t\n\t\t\t   \"timeout\": 5000,\n\t\t\t   \"closeButton\":false,\n\t\t\t   \"closeOnSelfClick\":true,\n\t\t\t   \"closeOnSelfOver\":false,\n\t\t\t   \"modal\":false,\n\t\t\t   \"onShow\":\"\",\n\t\t\t   \"onClose\":\"\"\n\t\t\t}); \n\n\t\t\t*/\n\n\t\t\tvar n = noty({\n                text        : text,\n                type        : type,\n                dismissQueue: true,\n                progressBar : true,\n                timeout     : 5000,\n                layout      : \'bottomRight\',\n                closeWith   : [\'click\'],\n                theme       : \'relax\',\n                maxVisible  : 10,\n                animation   : {\n                    open: {height: \'toggle\'},\n\t\t\t\t\tclose: {height: \'toggle\'},\n                    easing: \'swing\',\n                    speed : 500\n                }\n            });\n\n        }\n\n        function generateAll() {\n            generate(\'success\', notification_html[0]); \n        }\n\n        $(document).ready(function () {\n\n            setTimeout(function () {\n                generateAll();\n            }, 500);\n\n        });\n\n    </script>\n\n</head>\n<body>\n\n    <div class=\"container\">\n        <div id=\"customContainer\"></div>\n    </div>\t\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

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
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
