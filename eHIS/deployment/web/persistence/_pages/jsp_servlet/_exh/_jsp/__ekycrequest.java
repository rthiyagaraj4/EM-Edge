package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __ekycrequest extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/ekycrequest.jsp", 1742465510443L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<HTML>\n<HEAD>    \n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\t\n<script language=\"JavaScript\" src=\'../../eCommon/js/common.js\'> </script>\n<script Language=\"JavaScript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<script language=\"JavaScript\" src=\'../../eXH/js/Validate.js\'> </script>\n<SCRIPT LANGUAGE=\"JAVASCRIPT\" SRC=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<script Language=\"JavaScript\">\n//Added by prithivi for enotification requirement on 11/05/2016. these functions are used for filter out the details\n\n\n\tfunction AADHAAR()\n\t{\n\t\tvar aadhaarID = \"\";\n\t\t//var url = \"http://ekyc.mobilewaretech.com:2080/KDAHEKYC/kyc?EM_FACILITY_ID=KH&EM_USER_ID=SURESHM&AADHAAR_NO=523261344811&REQUEST_ID=12345678\";\n\n\t\tvar url = \"http://ekyc.mobilewaretech.com:2080/KDAHEKYC/kyc?EM_FACILITY_ID=dasdas&EM_USER_ID=dasdsa&AADHAAR_NO=936862739806&REQUEST_ID=dasdasdas\";\n\n\t\tvar errMessage = \"\";\n\n\t\talert(\"1\");\t\t\t\n\t\tvar dialogTop   = \"350\";\t\t\t     \n\t\tvar dialogHeight= \"25\" ;\n\t\tvar dialogWidth = \"55\" ;\t\t\t\t\t\t\t\t\t\t\t \n\t\tvar arguments   = \"\" ;\n\t\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; dialogTop:\" + dialogTop + \"; status: no\" ;\n\t\t//window.showModalDialog( url, arguments, features ) ;\n\t\t//window.open( url, arguments, features ) ;\n\t\twindow.open(\"http://ekyc.mobilewaretech.com:2080/KDAHEKYC/kyc?EM_FACILITY_ID=123&EM_USER_ID=123&AADHAAR_NO=123123465&REQUEST_ID=123456\",\"KADHKYC\",\'height=320,width=428,toolbar=no,menubar=no,scrollbars=yes, resizable=yes,location=no, directories=no, status=no,copyhistory=no\');\n\n\n\n\t}\n\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n  \n</HEAD>\n<BODY  leftmargin=0 topmargin=0  onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\'>\n<form name=\"FilterSearchForm\" id=\"FilterSearchForm\" target=\'\' action=\'\'>\n\n<input class=\'button\' type=\'button\'  name=\'aadhaar\' id=\'aadhaar\' value=\'AADHAAR\' onClick=\"AADHAAR()\"> \n\n\n \n</form>\t\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
