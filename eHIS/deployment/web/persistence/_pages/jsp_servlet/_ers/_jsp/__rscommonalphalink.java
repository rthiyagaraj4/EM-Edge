package jsp_servlet._ers._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __rscommonalphalink extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/RSCommonAlphaLink.jsp", 1709117443400L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n*************************************************************************\n*\tFile Name\t\t\t\t\t: RSCommonAlphaLink.jsp\n*\tDescription\t\t\t\t    : To display Alphabetical Links in RS Master Functions\n*\tAuthors\t\t\t\t\t\t: Prakash.S\n*\tVersion\t\t\t\t\t\t: 1.0\n*\tDate\t\t\t\t\t\t: 08th Jan 2003\n*\tRevision History\t\t\t:\n***************************************************************************\n-->\n<script>\nfunction changeAlphaColor(obj){\n\tif(obj==\"celloth\"){\n\t\tcelloth.className=\"clicked\";\n\t\t\tfor(var i=0;i<=25;i++){\n\t\t\t\tvar cell =eval(\"cell\"+i);\n\t\t\t\tcell.className=\"normal\";\n\t\t\t}\n\t}\n\telse{\n\t\tfor(var i=0;i<=25;i++){\n\t\t\tvar chk=eval(obj);\n\t\t\tvar cell =eval(\"cell\"+i);\n\t\t\t\tif(chk==cell){\n\t\t\t\t\tchk.className=\"clicked\";\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\tcell.className=\"normal\";\n\t\t\t\t}\n\t\tcelloth.className=\"normal\";\n\t\t}\n\t}\n}\n</script>\n<table border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" align=\'left\'>\n\t<tr>\n\t\t";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\t</tr>\n</table>\n";
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


		String splitLinkStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String linkStr="";

		for(int i=0; i<26; i++){
			String alphabet = String.valueOf(splitLinkStr.charAt(i)) ;
			linkStr += "<td class='normal' align='center' id='cell"+i+"' width='3%'><a href=javascript:callOnAlphaLink('"+alphabet+"','cell"+i+"')  >"+alphabet+"</a></td>";
		}

		if(!linkStr.equals(""))
			linkStr += "<td class='normal' id='celloth'  align='center' width='7%'><a href=javascript:callOnAlphaLink('OTH','celloth') >Others</a></td>";
			out.println(linkStr);
		
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
