package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __textblockeditorbutton extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/TextBlockEditorButton.jsp", 1726233381353L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------\n?             100            ?           created\n---------------------------------------------------------------------------------------------------------------\n-->\n\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<script>\nfunction storeEditorValue(){\nvar outData=parent.textBlockEditor.RTEditor0.contentDocument.body.innerHTML;\n//var outData=parent.textBlockEditor.RTEditor0.document.body.innerHTML;\noutData = outData.replace(\"<ADDRESS>\",\"\");\noutData = outData.replace(\"</ADDRESS>\",\"\");\n//outData = outData.replace( /\\\"/g, \"\'\" );  //[IN033786]\noutData = outData.replace( /<P\\s*[^>]*>\\s*&nbsp;\\s*<\\/P>/gi, \"\" ) ;\nif(outData!=\"\"){\n\t//document.parentWindow.returnValue = \"<ADDRESS>\"+outData+\"</ADDRESS>\";\n\t//window.parent.returnValue = \"<ADDRESS>\"+outData+\"</ADDRESS>\";\n\tparent.parent.document.getElementById(\'dialog-body\').contentWindow.returnValue = \"<ADDRESS>\"+outData+\"</ADDRESS>\";\n}else{\n\t//window.parent.returnValue = \"\";\n\tparent.parent.document.getElementById(\'dialog-body\').contentWindow.returnValue = \"\";\n\t//document.parentWindow.returnValue = \"\";\n}\n//window.parent.close();\nparent.parent.document.getElementById(\'dialog_tag\').close();\n//document.parentWindow.close();\n\n}\n</script>\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" id=\'test\'>\n<tr>\n\t<td class=\"LABEL\" align=\"right\" >\n\t\t<font size=\'1\'>\t\n\t\t\t<input type=\"button\" value=\"OK\" onclick=\"javascript:storeEditorValue();\"/>&nbsp;&nbsp;<input type=\"button\" value=\"Cancel\" onclick=\"parent.parent.document.getElementById(\'dialog_tag\').close();\"/>\t\t\t\t\t \n\t\t</font>\n\t</td>\n</tr>\n</table>\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

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

response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
