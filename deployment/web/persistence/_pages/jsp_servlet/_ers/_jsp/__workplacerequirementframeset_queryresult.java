package jsp_servlet._ers._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __workplacerequirementframeset_queryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/WorkPlaceRequirementFrameset_QueryResult.jsp", 1709618673554L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n*\tCopyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED\n*\tApplication\t\t:\teRS\n*\tPurpose \t\t:\n*\tCreated By\t\t:\tSuresh.S\n*\tCreated On\t\t:\t9 Dec 2004\n-->\n<html>\n<head>\n<title><fmt:message key=\"eRS.WorkPlaceRequirementQryResult.label\" bundle=\"";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\"/></title>\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"JavaScript\" src=\"../js/RSCommon.js\"></script>\n<!-- <script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script> -->\n<script language=\"javascript\" src=\"../js/WorkplaceRequirement.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<iframe name=\'frame_qryResulttop\' id=\'frame_qryResulttop\' src=\'../../eRS/jsp/WorkplaceRequirementQueryResult.jsp?";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\' frameborder=0 scrolling=\'auto\' noresize style=\'height:45vh;width:100vw\'></iframe>\n<iframe name=\'frame_qryResulutHdr\' id=\'frame_qryResulutHdr\' src=\'../../eCommon/html/blank.html\'\nframeborder=0 scrolling=\'auto\' noresize style=\'height:8vh;width:100vw\'></iframe>\n<iframe name=\'frame_qryResultbottom\' id=\'frame_qryResultbottom\' src=\'../../eCommon/html/blank.html\'\nframeborder=0 scrolling=\'auto\' noresize style=\'height:47vh;width:100vw\'></iframe>\n\n</html>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

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
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block1Bytes, _wl_block1);

String workplace_code = request.getParameter("workplace_code")==null?"": request.getParameter("workplace_code");
String locn_type	  = request.getParameter("locn_type")==null?"": request.getParameter("locn_type");
String workplace_desc       = request.getParameter("workplace_desc")==null?"":request.getParameter("workplace_desc");
String requirement = request.getParameter("requirement")==null?"":request.getParameter("requirement");
String qryString = "workplace_code="+workplace_code+"&locn_type="+locn_type+"&workplace_desc="+workplace_desc+"&requirement="+requirement;

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(qryString));
            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
