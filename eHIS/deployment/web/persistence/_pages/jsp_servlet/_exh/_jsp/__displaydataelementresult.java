package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __displaydataelementresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/DisplayDataElementResult.jsp", 1732873448157L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html> \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<link rel=\'StyleSheet\' href=\'../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\' type=\'text/css\'></link>\n<head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script Language=\"JavaScript\"  src=\"../eCommon/js/ValidateControl.js\" ></script>\n<script src=\'../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<script language=\"JavaScript\">\nfunction callFirst()\n{\n\n\n    if( data_element_form.mode.value==\'0\')\n\t{\n\tdata_element_form.action=\'../eXH/jsp/DataElementCrossRefNonTableValuesSetupqueryrecord.jsp\';\n\tdata_element_form.target=\"applnontablecodesearch\";\ndata_element_form.submit();\n\n\t}\n\telse {\n\n          data_element_form.action=\'../eXH/jsp/DataElementCrossRefNonTableValuesSetupqueryrecord.jsp\';\n\t      data_element_form.target=\"applnontablecodesearch\";\n\t      data_element_form.submit();\n\t    }\n//\t\tdocument.forms[0].nontabelementid.value\n\n//alert(parent.frames[2].frames[1].frames[1].frames[0].name);\n//parent.frames[2].frames[1].frames[1].frames[1].document.location.href=\'../../eXH/jsp/DataElementCrossRefNonTableValuesSetup.jsp?\';\n//applicationid=\'+parent.frames[2].frames[0].document.forms[0].application.value+\'&nontabelementid=\'+parent.frames[2].frames[1].frames[0].document.forms[0].nontabelementid.value;\n\n\n\n}\n</script>\n\n\n\n</head>\n<BODY CLASS=\"MESSAGE\" onLoad=\"callFirst();\" onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\'>\n<form name=\"data_element_form\" id=\"data_element_form\">\n<input type=\"hidden\" name=\"applicationid\" id=\"applicationid\" value=\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\'/>\n<input type=\"hidden\" name=\"nontabelementid\" id=\"nontabelementid\" value=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'/>\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'/>\n<p align=\"left\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</p>\n</form>\n</BODY>\n</html>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);
 
  String  message = "";
  String  applicationid = "";
  String  nontabelementid = "";
  String  mode = "";
  message =request.getParameter("message");
  applicationid=(String)request.getAttribute("applicationid");
  nontabelementid =(String) request.getAttribute("nontabelementid"); 
  mode =(String) request.getAttribute("mode"); 
		 

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(applicationid));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(nontabelementid));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(message));
            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
