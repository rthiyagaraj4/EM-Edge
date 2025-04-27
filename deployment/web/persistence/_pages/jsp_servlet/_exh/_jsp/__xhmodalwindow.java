package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __xhmodalwindow extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/XHModalWindow.jsp", 1741326218678L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\t<kendo:window name=\"window\" title=\"About Alvar Aalto\" draggable=\"true\" resizable=\"true\" width=\"600\" close=\"onClose\">\n\t\t<kendo:window-content>\n\t\t\t<h4>Armchair 402</h4>\n\t\t\t<div class=\"armchair\">\n\t            <img src=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\"\n\t                    alt=\"Armchair 402\" />\n\t            Artek Alvar Aalto - Armchair 402\n\t        </div>\n\t\n\t        <p>\n\t            Alvar Aalto is one of the greatest names in modern architecture and design.\n\t            Glassblowers at the iittala factory still meticulously handcraft the legendary\n\t            vases that are variations on one theme, fluid organic shapes that let the end user\n\t            ecide the use. Interpretations of the shape in new colors and materials add to the\n\t            growing Alvar Aalto Collection that remains true to his original design.\n\t        </p>\n\t\n\t        <p>\n\t            Born Hugo Alvar Henrik Aalto (February 3, 1898 - May 11, 1976) in Kuortane, Finland,\n\t            was noted for his humanistic approach to modernism. He studied architecture at the\n\t            Helsinki University of Technology from 1916 to 1921. In 1924 he married architect\n\t            Aino Marsio.\n\t        </p>\n\t\n\t        <p>\n\t            Alvar Aalto was one of the first and most influential architects of the Scandinavian\n\t            modern movement, and a member of the Congres Internationaux d\'Architecture Moderne.\n\t            Major architectural works include the Finlandia Hall in Helsinki, Finland,\n\t            and the campus of Helsinki University of Technology.\n\t        </p>\n\t\n\t        <p>\n\t            Source:\n\t            <a href=\"https://www.aalto.com/about-alvar-aalto.html\" title=\"About Alvar Aalto\">www.aalto.com</a>\n\t        </p>\n\t\t</kendo:window-content>\t\n\t</kendo:window>    \n\t\n\t<span id=\"undo\" style=\"display:none\" class=\"k-button hide-on-arrow\">Click here to open the window.</span>\n\n\t<div class=\"responsive-message\"></div>\n\t\n\t<script>\n\t    function onClose() {\n\t        $(\"#undo\").show();\n\t    }\n\t\n\t    $(document).ready(function() {\n\t        $(\"#undo\").bind(\"click\", function() {\n\t                $(\"#window\").data(\"kendoWindow\").open();\n\t                $(\"#undo\").hide();\n\t            });\n\t    });\n\t</script>\t\n\t\n\t<style>\n\t    #example {\n\t        min-height:500px;\n\t    }\n\t\n\t    #undo {\n\t        text-align: center;\n\t        position: absolute;\n\t        white-space: nowrap;\n\t        padding: 1em;\n\t        cursor: pointer;\n\t    }\n\t    .armchair {\n\t        float: left;\n\t        margin: 30px 30px 120px 30px;\n\t        text-align: center;\n\t    }\n\t    .armchair img {\n\t        display: block;\n\t        margin-bottom: 10px;\n\t    }\n\t\t.k-window-content p {\n\t\t\tmargin-bottom: 1em;\n\t\t}\n\t\t.k-window-content a {\n\t\t\tcolor: #BBB;\n\t\t}\n\t    @media screen and (max-width: 1023px) {\n\t        div.k-window {\n\t            display: none !important;\n\t        }\n\t    }\n\t</style>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${armchair}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block4Bytes, _wl_block4);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.UrlTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.core.UrlTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setValue(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("/resources/web/window/armchair-402.png", java.lang.String .class,"value"));
        __tag0.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("armchair", java.lang.String .class,"var"));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }
}
