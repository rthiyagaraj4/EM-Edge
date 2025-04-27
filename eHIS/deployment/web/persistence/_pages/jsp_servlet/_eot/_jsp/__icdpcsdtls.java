package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOT.*;
import eOT.Common.*;
import eCommon.Common.*;

public final class __icdpcsdtls extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/ICDPCSDtls.jsp", 1709120228000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\'/>\n<!--<script language=\"JavaScript\" src=\"../../eOT/js/Hashtable.js\"></script>-->\n<script language=\"JavaScript\" src=\"../../eOT/js/ICDPCS.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<style>\nOPTION.AUTO,TD.AUTO {\n\t\t\tFONT-FAMILY: VERDANA;\n\t\t\tFONT-SIZE: 9PT;\n\t\t\tBACKGROUND-COLOR: #00ff66;\n\t\t\tBORDER-STYLE: SOLID;\n\t\t\tBORDER-LEFT-COLOR: #B2B6D7;\n\t\t\tBORDER-RIGHT-COLOR: #B2B6D7;\n\t\t\tBORDER-TOP-COLOR: #E2E3F0;\n\t\t\tBORDER-BOTTOM-COLOR: #E2E3F0;\n}\nOPTION.MANDATORY,TD.MANDATORY{\n\t\t\tFONT-FAMILY: VERDANA ;\n\t\t\tFONT-SIZE: 9PT ;\n\t\t\tBACKGROUND-COLOR: #cc0033;\n\t\t\tCOLOR:WHITE;\n\t\t\tBORDER-STYLE:SOLID;\n\t\t\tBORDER-LEFT-COLOR: #B2B6D7;\n\t\t\tBORDER-RIGHT-COLOR: #B2B6D7;\n\t\t\tBORDER-TOP-COLOR: #E2E3F0;\n\t\t\tBORDER-BOTTOM-COLOR: #E2E3F0;\n }\n OPTION.OPTIONAL,TD.OPTIONAL{\n\t\t\tFONT-FAMILY: VERDANA ;\n\t\t\tFONT-SIZE: 9PT ;\n\t\t\tCOLOR:BROWN;\n\t\t\tBACKGROUND-COLOR: gold;\n\t\t\tCOLOR:BROWN\n\t\t\tBORDER-STYLE: SOLID;\n\t\t\tBORDER-LEFT-COLOR: #B2B6D7;\n\t\t\tBORDER-RIGHT-COLOR: #B2B6D7;\n\t\t\tBORDER-TOP-COLOR: #E2E3F0;\n\t\t\tBORDER-BOTTOM-COLOR: #E2E3F0;\n }\n TD.SEN {\n\tBACKGROUND-COLOR: LightYellow ;\n\tFONT-SIZE: 9PT ;\n\tBORDER-STYLE: SOLID;\n\tBORDER-LEFT-COLOR: #B2B6D7;\n\tBORDER-RIGHT-COLOR: #B2B6D7;\n\tBORDER-TOP-COLOR: #E2E3F0;\n\tBORDER-BOTTOM-COLOR: #E2E3F0 \n}\n</style>\n</head>\n<body onLoad=\"createTable();\" OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\"ICDPCSDetailForm\" id=\"ICDPCSDetailForm\" >\n<div id=\"test\"></div>\n<SPAN Style=\"position:absolute;visibility:hidden\" id=\"tooltip\"></SPAN>\n<input type=\"hidden\"  name=\"doc_comp\" id=\"doc_comp\" value=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\" >\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

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
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block1Bytes, _wl_block1);
	
String  surgeon_doc_comp_yn = 																CommonBean.checkForNull(request.getParameter("surgeon_doc_comp_yn")); 

            _bw.write(_wl_block2Bytes, _wl_block2);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(surgeon_doc_comp_yn));
            _bw.write(_wl_block5Bytes, _wl_block5);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
