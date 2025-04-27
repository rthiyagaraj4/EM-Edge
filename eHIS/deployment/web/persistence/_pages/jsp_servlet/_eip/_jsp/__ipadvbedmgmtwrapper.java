package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __ipadvbedmgmtwrapper extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/IPAdvBedMgmtWrapper.jsp", 1738425911557L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eIP/js/IPAdvBedMgmtTrns.js\' language=\'javascript\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\t<title>Graphical Bed Chart</title>\n\t<script type=\"text/javascript\">\n\t\t//fullScreen() ;\n\t\tfunction fullScreen() {\n\t\t\twindow.resizeTo( screen.availWidth, screen.availHeight ) ;\n\t\t\twindow.moveTo( 0,0 ) ;\n\t\t}\n\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head> \n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\'    src=\'../../eCommon/jsp/commonToolbar.jsp\' frameborder=0 scrolling=\'no\' noresize style=\'height:0%;width:100vw\'></iframe> \n\t<iframe name=\'serachFrame\' id=\'serachFrame\' \t\tsrc=\'../../eIP/jsp/IPAdvBedMgmtCriteria.jsp?called_from=bed_mgmt_trns&function_id=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' noresize framespacing=0 frameborder=no border=0 style=\'height:3.1%;width:100vw\'></iframe><iframe name=\'status\' id=\'status\' src=\'../jsp/IPAdvBedMgmtColorSchema.jsp\' noresize framespacing=0 frameborder=no border=0 scrolling=\'auto\' style=\'height:6.5%;width:100vw\'></iframe><iframe name=\'adv_bed_mgmt\' id=\'adv_bed_mgmt\' \t\tsrc=\'../../eCommon/html/blank.html\' noresize framespacing=0 frameborder=no border=0 scrolling=\'no\' style=\'height:80vh;width:100vw\'></iframe><iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/MstCodeError.jsp\' noresize framespacing=0 frameborder=no border=0 scrolling=\'auto\' style=\'height:0%;width:100vw\'></iframe>\n</html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	request.setCharacterEncoding("UTF-8");
	//String url="../../eCommon/jsp/commonToolbar.jsp?";
	//String params = request.getQueryString() ;
	//String source = url + params ;
	//Below code was added by N Munisekhar on 08-JAN-2013 against [IN037130]
	String function_id=request.getParameter("function_id");
    if(function_id == null) function_id = "";
	//String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	//	String source = url;

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block5Bytes, _wl_block5);
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
