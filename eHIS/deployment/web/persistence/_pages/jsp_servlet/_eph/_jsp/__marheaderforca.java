package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __marheaderforca extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/MARHeaderForCA.jsp", 1709120918769L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<head>\n\t<script language=\"JavaScript\" src=\"../js/MedicationAdministrationFixedTime.js\"></script>\n\t<script src=\'../js/CAMenu.js\' language=\'javascript\'></script>\n\t";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\' type=\'text/css\'></link>\n\n\n\t<script language=\"JavaScript\">\n\t\tfunction onApply() {\n\t\t\tparent.apply() ;\n\t\t\tparent.commontoolbarFrame.location.href=\'../../eCommon/html/process.html\';\n\t\t}\n\t</script>\n</head>\n\n<!-- <body class=\"COMMON_TOOLBAR\" leftmargin=0 topmargin=0> -->\n<body class=\"COMMON_TOOLBAR\" leftmargin=0 topmargin=0 onMouseDown=\"\" onKeyDown=\"lockKey()\">\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<form name=\"MARheaderForCA_form\" id=\"MARheaderForCA_form\">\n<table width=\"100%\" cellspacing=\'0\' cellpading=\'0\'>\n\t<tr class=\"COMMONTOOLBARFUNCTION\">\n\t\t<td align=\"left\" class=\"COMMONTOOLBARFUNCTION\">\n\t\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t</td>\n\t</tr>\n\t<tr class=\"COMMON_TOOLBAR\">\n\t\t<td class=\"COMMON_TOOLBAR\">\n\t\t\t<table width=\"100%\" cellspacing=\'0\' cellpading=\'0\'>\n\t\t\t\t<tr class=\"COMMON_TOOLBAR\">\n\t\t\t\t\t<td class=\"COMMON_TOOLBAR\" align=\"left\" width=\"50%\">\n\t\t\t\t\t\t<table cellspacing=\'0\' cellpading=\'0\'>\n\t\t\t\t\t\t\t<tr class=\"COMMON_TOOLBAR\">\n\t\t\t\t\t\t\t<td class=\"COMMON_TOOLBAR\">\n\t\t\t\t\t\t\t\t<input type=\'button\' onclick=\"onApply();\" value=\'Apply\' name=\'apply\' id=\'apply\' class=\'BUTTON\'></input>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\"COMMON_TOOLBAR\">\n\t\t\t\t\t\t\t\t<input type=\'button\' onclick=\"closeFunction();\" value=\'Close\' name=\'home\' id=\'home\' class=\'BUTTON\' ></input>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\n\t\t\t\t\t<td class=\"COMMON_TOOLBAR\" align=\"right\" width=\"50%\">\n\t\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</td>\n\t</tr>\n</table>\n\n</form>\n</body>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

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

String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block2Bytes, _wl_block2);

	String module_id		= request.getParameter( "module_id" ) ;
	String function_id	= request.getParameter( "function_id" ) ;
	String function_name 	= request.getParameter( "function_name" ) ;
	String function_type	= request.getParameter( "function_type" ) ;
	
	if ( module_id		== null ) module_id 	= "" ;
	if ( function_id		== null ) function_id 	= "" ;
	if ( function_name	== null ) function_name	= "" ;
	if ( function_type	== null ) function_type	= "F" ;

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf( function_name ));
            _bw.write(_wl_block4Bytes, _wl_block4);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
