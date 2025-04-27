package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __chromepocmaster extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/ChromePOCMaster.jsp", 1709122305976L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n<head>\n    <title></title>\n    <link rel=\"stylesheet\" href=\"../../eXH/Kendo/styles/kendo.common.min.css\" />\n    <link rel=\"stylesheet\" href=\"../../eXH/Kendo/styles/kendo.default.min.css\" />\n    <link rel=\"stylesheet\" href=\"../../eXH/Kendo/styles/kendo.default.mobile.min.css\" />\n\n    <Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\n    <script src=\"../../eXH/Kendo/js/kendo.all.min.js\" type=\"text/javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n    \n\n</head>\n<body>\n\n        <div id=\"example\">\n            <div id=\"window\">\n\t\t\t\t\t\t\t<!--\n\n                <h4>Armchair 402</h4>\n                <div class=\"armchair\"><img src=\"../content/web/window/armchair-402.png\" alt=\"Armchair 402\" /> Artek Alvar Aalto - Armchair 402</div>\n                <p>Alvar Aalto is one of the greatest names in modern architecture and design. Glassblowers at the iittala factory still meticulously handcraft the legendary vases that are variations on one theme, fluid organic shapes that let the end user decide the use. Interpretations of the shape in new colors and materials add to the growing Alvar Aalto Collection that remains true to his original design.</p>\n\n                <p>Born Hugo Alvar Henrik Aalto (February 3, 1898 - May 11, 1976) in Kuortane, Finland, was noted for his humanistic approach to modernism. He studied architecture at the Helsinki University of Technology from 1916 to 1921. In 1924 he married architect Aino Marsio.</p>\n\n                <p>Alvar Aalto was one of the first and most influential architects of the Scandinavian modern movement, and a member of the Congres Internationaux d\'Architecture Moderne. Major architectural works include the Finlandia Hall in Helsinki, Finland, and the campus of Helsinki University of Technology.</p>\n\n                <p>Source: <a href=\"https://www.aalto.com/about-alvar-aalto.html\" title=\"About Alvar Aalto\">www.aalto.com</a></p>\n\t\t\t\t-->\n            </div>\n\n            <span id=\"undo\" style=\"display:none\" class=\"k-button hide-on-narrow\">Click here to open the window.</span>\n\n            <div class=\"responsive-message\"></div>\n\n            <script>\n                $(document).ready(function() {\n\t\t\t\t\tparent.document.getElementsByTagName(\"frameset\").item(0).rows = \'7%,90%,3%\';\n                    var myWindow = $(\"#window\"),\n                        undo = $(\"#undo\");\n\t\t\t\t\t\tundo.fadeIn();\n\n                    undo.click(function() {\n\t\t\t\t\t\tparent.document.getElementsByTagName(\"frameset\").item(0).rows = \'7%,90%,3%\';\n                        myWindow.data(\"kendoWindow\").open();\n                        undo.fadeOut();\n                    });\n\n                    function onClose() {\n\t\t\t\t\t\tparent.document.getElementsByTagName(\"frameset\").item(0).rows = \'7%,40%,53%\';\n                        undo.fadeIn();\n                    }\n\t\t\t\t\t/*\n                    myWindow.kendoWindow({\n                        width: \"750px\",\n                        title: \"About Alvar Aalto\",\n                        visible: false,\n                        actions: [\n                            \"Pin\",\n                            \"Minimize\",\n                            \"Maximize\",\n                            \"Close\"\n                        ],\n                        close: onClose\n                    }).data(\"kendoWindow\").center().open();\n\t\t\t\t\t*/\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t myWindow.kendoWindow({\n                        width: \"600px\",\n                        height: \"300px\",\n                        title: \"About Alvar Aalto\",\n\t\t\t\t\t\tcontent: \"../../eCommon/jsp/CommonLookup.jsp?title=DataGroup\",\n\t\t\t\t\t\tiframe: true,\n                        visible: false,\n                        actions: [\n                            \"Pin\",\n                            \"Minimize\",\n                            \"Maximize\",\n                            \"Close\"\n                        ],\n                        close: onClose\n                    }).data(\"kendoWindow\").center().close();\n                });\n            </script>\n\n            <style>\n\n                #example {\n                    min-height:500px;\n                }\n                #undo {\n                    text-align: center;\n                    position: absolute;\n                    white-space: nowrap;\n                    padding: 1em;\n                    cursor: pointer;\n                }\n                .armchair {\n                \tfloat: left;\n                \tmargin: 30px 30px 120px 30px;\n                \ttext-align: center;\n                }\n                .armchair img {\n                    display: block;\n                    margin-bottom: 10px;\n                }\n                .k-window-content a {\n                    color: #BBB;\n                }\n                .k-window-content p {\n                    margin-bottom: 1em;\n                }\n\n                @media screen and (max-width: 1023px) {\n                    div.k-window {\n                        display: none !important;\n                    }\n                }\n            </style>\n        </div>\n\n\n</body>\n</html>\n\n";
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
