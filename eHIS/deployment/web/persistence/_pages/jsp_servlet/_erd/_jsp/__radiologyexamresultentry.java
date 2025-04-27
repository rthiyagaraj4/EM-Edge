package jsp_servlet._erd._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;
import java.text.*;

public final class __radiologyexamresultentry extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eRD/jsp/RadiologyExamResultEntry.jsp", 1658294514750L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n<HTML>\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\' type=\'text/css\' />\r\n\r\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\r\n\t<script language=\"javascript\" src=\'../../eCommon/js/CommonLookup.js\'></script>\r\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\r\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\r\n\t<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\r\n\t<script language=\"JavaScript\" src=\"../../eOR/js/TeleRadiologyOrders.js\"></script>\r\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\r\n\t<script language=\'javascript\' src=\'../../eCommon/js/jquery.js\'></script>\r\n\t<script>\r\n\t\t//To disable reset btn\r\n\t\t$(document).ready(function () {\r\n\t\t\t commontoolbarFrame.document.forms(0).reset.disabled = true;\r\n\t\t});\r\n\t</script>\r\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\r\n<FRAMESET ROWS =\'6%,18%,64%,7%,5%\' framespacing=0 name=\'RadiologyExamResultEntry\' >\r\n\t<FRAME name=\'commontoolbarFrame\' src=\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' frameborder=0 scrolling=\'no\'  noresize>\r\n\t<FRAME name=\'RadiologyExamSearchHdr\' src=\'../../eRD/jsp/RadiologyExamSearchCriteria.jsp?";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' frameborder=0>\r\n\t<FRAME name=\'RadiologyExamSearchValues\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'auto\'>\r\n\t<FRAME name=\'RadiologyExamSubmit\' src=\'../../eCommon/html/blank.html\' frameborder=0>\r\n\t<FRAME name=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\'>\r\n\t\r\n</FRAMESET>\r\n</HTML>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

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

/*
Sr No        Version              TFS              SCF/CRF           	   				 Developer Name
-------------------------------------------------------------------------------------------------------
1            V211228            26735       PMG2021-COMN-CRF-0089.1-TF-US001            Mohanapriya K
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	String params = request.getQueryString();
	System.err.println("params--"+params);
	if(params==null || params.equals("")) params="";
	String function_id=request.getParameter("function_id");
	String module_id=request.getParameter("module_id");
	if(function_id==null || function_id.equals("")) function_id="";
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?home_required_yn=Y";
	String source = url + params;
	

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(source));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(params));
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
