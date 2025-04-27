package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.net.*;
import eCommon.XSSRequestWrapper;

public final class __aemanagepatgipatientmang extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AEManagePatGIPatientMang.jsp", 1733806104968L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<head>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t<iframe name=\'processBar\' frameborder=0  noresize  scrolling=\'no\' style=\'height:0vh;width:99vw;display: none;\'></iframe>\n\t\t<iframe name=\'criteria0\' src=\'../../eCommon/html/blank.html\' frameborder=0  scrolling=\'no\'style=\'height:0vh;width:99vw;display: none;\'></iframe>\n\t\t\n\t\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t\t<iframe name=\'pat_result\' src=\'../../eAE/jsp/AEManagePatGIWaitListResult.jsp?";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' frameborder=0  scrolling=\'yes\'style=\'height:87vh;width:99vw\'></iframe>\t\t\n\t\t\t<!-- <frame name=\'result\' src=\'../../eAE/jsp/AEManagePatGIFrameLayer.jsp?";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' frameborder=0  scrolling=\'yes\'> -->\n\t\t\t<iframe name=\'result\' src=\'../../eCommon/html/blank.html\' frameborder=0  scrolling=\'no\'style=\'height:0vh;width:99vw;display: none;\'></iframe>\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t<iframe name=\'result\' src=\'../../eAE/jsp/AEManagePatGIFrameLayer.jsp?";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' frameborder=0  scrolling=\'yes\'style=\'height:87vh;width:99vw\'></iframe>\n\t      <!--   <frame name=\'pat_result\' src=\'../../eAE/jsp/AEManagePatGIWaitListResult.jsp?";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' frameborder=0  scrolling=\'yes\'>\t -->\t\n\t        <iframe name=\'pat_result\'src=\'../../eCommon/html/blank.html\' frameborder=0  scrolling=\'no\'style=\'height:0vh;width:99vw;display: none;\'></iframe>\t\t\n\t    ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<iframe name=\'status\' src=\'../../eAE/jsp/BedColorStandard.jsp\' frameborder=0 noresize scrolling=\'no\'style=\'height:6vh;width:99vw\'></iframe>\n\t\t\t<iframe name=\'dummy_frame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0  scrolling=\'no\'style=\'height:0vh;width:99vw;display: none;\'></iframe>\n\t<script>\n\n\tif(\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"==\"others_tab\"){ \n\t\n\t\t//parent.AEMPSearchResultFrame.frameSetId.rows=\'0%,0%,*,0%,6%,0%\';\n\t}\n\telse{\n\t\n\t\t//parent.AEMPSearchResultFrame.frameSetId.rows=\'0%,0%,*,%0,6%,0%\';\n\t}\n\t</script>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n</html>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );
 

public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}



    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , false );
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
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
		String tabInd= request.getParameter("tabIndicator");
		String s=request.getQueryString();
		
            _bw.write(_wl_block2Bytes, _wl_block2);

		if (tabInd.equals("others_tab")){
	    
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(s));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(s));
            _bw.write(_wl_block5Bytes, _wl_block5);
}else if(tabInd.equals("char_tab")){
			
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(s));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(s));
            _bw.write(_wl_block8Bytes, _wl_block8);
}
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(tabInd));
            _bw.write(_wl_block10Bytes, _wl_block10);
            _bw.write(_wl_block11Bytes, _wl_block11);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
