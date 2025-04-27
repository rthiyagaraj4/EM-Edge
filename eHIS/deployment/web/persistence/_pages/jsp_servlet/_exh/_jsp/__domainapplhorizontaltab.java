package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __domainapplhorizontaltab extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/DomainApplHorizontalTab.jsp", 1709122326632L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<HTML>\n<HEAD>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\' type=\'text/css\'></link>\n\n<script language=\"JavaScript\" src=\"../../eXH/js/DomainApplication.js\"></script>\n\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\t\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\" ></script>\n\n\n<script language=\"JavaScript\">\n//function load_first\nfunction load_first()\n{\n//alert(\"load_first\");\n//var tab1=document.getElementById(\"domains\");\n//var tabspan1=document.getElementById(\"domains_tabspan\");\nvar tab2=document.getElementById(\"applications\");\nvar tabspan2=document.getElementById(\"applications_tabspan\");\n\n//tab1.className=\'tabA\';\n//tabspan1.className=\'tabAspan\';\ntab2.className=\'tabClicked\';\ntabspan2.className=\'tabSpanclicked\';\n/*\ntab2.className=\'tabA\';\ntabspan2.className=\'tabAspan\';\ntab1.className=\'tabClicked\';\ntabspan1.className=\'tabSpanclicked\';\n*/\ndocument.forms[0].option.value=\"applications\";\nparent.f_query_add_mod.location.href =\'../../eXH/jsp/ApplicationAddModifyMaster.jsp?mode=I\';\n\n//document.forms[0].option.value=\"domains\";\n//parent.f_query_add_mod.location.href =\'../../eXH/jsp/InterfaceModuleSelectMaster.jsp?mode=I\';\n\nparent.messageFrame.location.href=\'../../eCommon/jsp/MstCodeError.jsp\';\n}\n//function callJSPs\nfunction callJSPs(str)\n{\n\n//var tab1=document.getElementById(\"domains\");\n//var tabspan1=document.getElementById(\"domains_tabspan\");\nvar tab2=document.getElementById(\"applications\");\nvar tabspan2=document.getElementById(\"applications_tabspan\");\n\nif(str==\'applications\')\n{\n//tab1.className=\'tabA\';\n//tabspan1.className=\'tabAspan\';\ntab2.className=\'tabClicked\';\ntabspan2.className=\'tabSpanclicked\';\n\ndocument.forms[0].option.value=\"applications\";\n\nparent.f_query_add_mod.location.href =\'../../eXH/jsp/ApplicationAddModifyMaster.jsp?mode=I\';\nparent.messageFrame.location.href=\'../../eCommon/jsp/MstCodeError.jsp\';\n}\n\nif(str==\'domains\')\n{\ntab1.className=\'tabClicked\';\ntabspan1.className=\'tabSpanclicked\';\ntab2.className=\'tabA\';\ntabspan2.className=\'tabAspan\';\n\ndocument.forms[0].option.value=\"domains\";\nparent.f_query_add_mod.location.href=\'../../eXH/jsp/InterfaceModuleSelectMaster.jsp?mode=I\';\nparent.messageFrame.location.href=\'../../eCommon/jsp/MstCodeError.jsp\';\n}\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</HEAD>\n<BODY  leftmargin=0 topmargin=0  bgcolor=\'\' onMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n<form name=\"MasterMenu_form\" id=\"MasterMenu_form\">\n\n   <table cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' border=0 align=\'center\'>\n  <tr><td class=\'white\'>\n\t\t<ul id=\"tablist\" class=\"tablist\" >\n\t\t\t <li class=\"tablistitem\" title=\'Application\'>\n\t\t\t\t<a onclick=\"callJSPs(\'applications\')\" class=\"tabA\" id=\"applications\" >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"applications_tabspan\">Application</span>\n\t\t\t\t</a>\n\t\t\t </li>\n\n<!--\t\t\t<li class=\"tablistitem\" title=\'Sub Domain\'>\n\t\t\t\t<a onclick=\"callJSPs(\'domains\')\" class=\"tabA\" id=\'domains\' >\n\t\t\t\t\t<span class=\"tabAspan\" id=\"domains_tabspan\">Sub Domain</span>\n\t\t\t\t</a>\n\t\t\t </li> -->\n\n\t   </ul>\n\t </td>\n   </tr>\n</table>\n \t<input type=hidden name=\'option\' id=\'option\' value=\'\'>\n\t<script>\n\tload_first();\n</script>\n</form>\t\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

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
sStyle = "IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
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
