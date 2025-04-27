package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __sectiontemplate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/SectionTemplate.jsp", 1735282910881L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\n<head>\n\t\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\'javascript\' src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../js/SectionTemplate.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<iframe name=\'CASectionTemplateHeaderFrame\' id=\'CASectionTemplateHeaderFrame\' src=\'../../eCA/jsp/CASectionTemplateHeader.jsp\' frameborder=no noresize scrolling=no framespacing=NO border=0 style=\'height:6vh;width:99vw\'></iframe>\n<iframe name=\'CASectionTemplateListFrame\' id=\'CASectionTemplateListFrame\' src=\'../../eCommon/html/blank.html\' frameborder=1 noresize framespacing=NO border=1 style=\'height:29vh;width:99vw;border: none\'></iframe>\n<iframe name=\'CASectionTemplatePreviewFrame\' id=\'CASectionTemplatePreviewFrame\' src=\'../../eCommon/html/blank.html\' frameborder=0 noresize scrolling=no framespacing=NO border=0 style=\'height:6vh;width:99vw\'></iframe>\n<iframe name=\'CASectionTemplateDetailFrame\' id=\'CASectionTemplateDetailFrame\' src=\'../../eCommon/html/blank.html\' frameborder=0 noresize  framespacing=NO border=0 style=\'height:46vh;width:99vw\'></iframe>\n<iframe name=\'CASectionTemplateToolbarFrame\' id=\'CASectionTemplateToolbarFrame\' src=\'../../eCommon/html/blank.html\' frameborder=0 noresize  scrolling=no framespacing=NO border=0 style=\'height:7vh;width:99vw\'></iframe>\n<iframe name=\'Dummy_frame\' id=\'Dummy_frame\' src=\'../../eCommon/html/blank.html\' frameborder=0 noresize framespacing=NO border=0 style=\'display:none;height:0vh;width:99vw;  margin-bottom:0vh;\'></iframe>\n</head>\n</html>\n\n<!-- <iframe name=\'CASectionTemplateHeaderFrame\' id=\'CASectionTemplateHeaderFrame\' src=\'../../eCA/jsp/CASectionTemplateHeader.jsp\' frameborder=no noresize scrolling=no framespacing=NO border=0 style=\'height:10%;width:100vw\'></iframe><iframe name=\'CASectionTemplateListFrame\' id=\'CASectionTemplateListFrame\' src=\'../../eCA/jsp/CASectionTemplateList.jsp\' frameborder=1 noresize framespacing=NO border=1 style=\'height:47%;width:100vw\'></iframe><iframe name=\'CASectionTemplatePreviewFrame\' id=\'CASectionTemplatePreviewFrame\' src=\'../../eCA/jsp/CASectionTemplatePreview.jsp\' frameborder=0 noresize scrolling=no framespacing=NO border=0 style=\'height:5%;width:100vw\'></iframe><iframe name=\'CASectionTemplateDetailFrame\' id=\'CASectionTemplateDetailFrame\' src=\'../../eCA/jsp/CASectionTemplateDetail.jsp\' frameborder=0 noresize scrolling=no framespacing=NO border=0 style=\'height:38%;width:100vw\'></iframe><iframe name=\'Dummy_frame\' id=\'Dummy_frame\' src=\'../../eCommon/html/blank.html\' frameborder=0 noresize framespacing=NO border=0 style=\'height:0%;width:100vw\'></iframe>\n -->\n\n<!--  <frameset rows=\'10%,85%,5%\' border=0>\n\t<frame name=\'CASectionTemplateHeaderFrame\' id=\'CASectionTemplateHeaderFrame\' src=\'../../eCA/jsp/CASectionTemplateHeader.jsp\' frameborder=no noresize scrolling=no framespacing=NO border=0>\n\t<frameset cols=\'40%,60%,0%\'>\n\t\t<frame name=\'CASectionTemplateDetailFrame\' id=\'CASectionTemplateDetailFrame\' src=\'../../eCA/jsp/CASectionTemplateDetail.jsp\' frameborder=0 noresize scrolling=no framespacing=NO border=0> \n\t\t<frame name=\'CASectionTemplateListFrame\' id=\'CASectionTemplateListFrame\' src=\'../../eCA/jsp/CASectionTemplateList.jsp\' frameborder=1 noresize framespacing=NO border=1> \n\t\t<frame name=\'Dummy_frame\' id=\'Dummy_frame\' src=\'../../eCommon/html/blank.html\' frameborder=0 noresize framespacing=NO border=0> \n\t</frameset>\n<frame name=\'CASectionTemplatePreviewFrame\' id=\'CASectionTemplatePreviewFrame\' src=\'../../eCA/jsp/CASectionTemplatePreview.jsp\' frameborder=0 noresize scrolling=no framespacing=NO border=0>\n</frameset> -->\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
