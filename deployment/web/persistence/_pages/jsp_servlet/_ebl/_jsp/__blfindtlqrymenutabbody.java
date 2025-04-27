package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __blfindtlqrymenutabbody extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLFinDtlQryMenuTabBody.jsp", 1709114512791L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n<script>\n\nfunction tab_click2(objName,errorMsg)\n{\n\tselectTab(objName);\n\ttab_click1(objName);\n}\nfunction tab_click1(objName)\n{\n\tif(\tobjName==\"pymtdet_tab\")\n\t{\n\t\tdocument.getElementById(\"pymtdet_focus\").scrollIntoView(true);\n\t}\n\telse if(objName==\"adjdet_tab\")\n\t{\n\t\tdocument.getElementById(\"adjdet_focus\").scrollIntoView(true);\n\t}\n\telse if(objName==\"exmtdet_tab\")\n\t{\n\t\tdocument.getElementById(\"exmtdet_focus\").scrollIntoView(true);\n\t}\n\telse if(objName==\"remdet_tab\")\n\t{\n\t\tdocument.getElementById(\"remdet_focus\").scrollIntoView(true);\n\t}\n\telse if(objName==\"writoffdet_tab\")\n\t{\n\t\tdocument.getElementById(\"writoffdet_focus\").scrollIntoView(true);\n\t}\n}\n</script>\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n \t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\'javascript\' src=\'../js/AddModifyPatFinDetails.js\'></script> \n\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\n<body onSelect=\"codeArrestThruSelect()\" onload=\'\' onKeyPress=\'return ChkKey(event);\'OnMouseDown=\"CodeArrest()\"  onKeyDown=\'lockKey()\'>\n<form>\n\n<ul id=\"tablist\" class=\"tablist\">\n\t<script>prevTabObj=\'pymtdet_tab\'</script>\n\t<li class=\"tablistitem\" title=\"Payment Details\">\n\t\t<a onclick=\"javascript:tab_click2(\'pymtdet_tab\',\'\')\" id=\"pymtdet_tab\" class=\"tabClicked\"  >\n\t\t\t<span class=\"tabSpanclicked\" id=\"pymtdet_tabspan\">Payment Details</span>\n\t\t</a>\n\t</li>\n\n\t<li class=\"tablistitem\" title=\"Adjustment Details\">\n\t\t<a onclick=\"javascript:tab_click2(\'adjdet_tab\',\'\')\" id=\"adjdet_tab\" class=\"tabA\"  >\n\t\t\t<span class=\"tabAspan\" id=\"adjdet_tabspan\">Adjustment Details</span>\n\t\t</a>\n\t</li>\n\t\t\n\t<li class=\"tablistitem\" title=\"Exemption Details\">\n\t\t<a onclick=\"javascript:tab_click2(\'exmtdet_tab\',\'\')\" id=\"exmtdet_tab\" class=\"tabA\"  >\n\t\t\t<span class=\"tabAspan\" id=\"exmtdet_tabspan\">Exemption Details</span>\n\t\t</a>\n\t</li>\n\n\t<li class=\"tablistitem\" title=\"Reminder Details\">\n\t\t<a onclick=\"javascript:tab_click2(\'remdet_tab\',\'\')\" id=\"remdet_tab\" class=\"tabA\"  >\n\t\t\t<span class=\"tabAspan\" id=\"remdet_tabspan\">Reminder Details</span>\n\t\t</a>\n\t</li>\n\n\t<li class=\"tablistitem\" title=\"Write-off Details\">\n\t\t<a onclick=\"javascript:tab_click2(\'writoffdet_tab\',\'\')\" id=\"writoffdet_tab\" class=\"tabA\"  >\n\t\t\t<span class=\"tabAspan\" id=\"writoffdet_tabspan\">Write-off Details</span>\n\t\t</a>\n\t</li>\n</ul>\n<a name=\'pymtdet_focus\'> </a>\n<table width=\'100%\' cellpadding=\'0\' cellspacing=\'1\' border =\'0\' width=\'100%\'>\n\t<tr>\n\t\t<td>Payment Detail</td>\n\t</tr>\n</table>\n\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n\n\n<ul id=\"tablist\" class=\"tablist\">\n\t<script>prevTabObj=\'pymtdet_tab\'</script>\n\t<li class=\"tablistitem\" title=\"Payment Details\">\n\t\t<a onclick=\"javascript:tab_click2(\'pymtdet_tab\',\'\')\" id=\"pymtdet_tab\" class=\"tabA\"  >\n\t\t\t<span class=\"tabAspan\" id=\"pymtdet_tabspan\">Payment Details</span>\n\t\t</a>\n\t</li>\n\n\t<li class=\"tablistitem\" title=\"Adjustment Details\">\n\t\t<a onclick=\"javascript:tab_click2(\'adjdet_tab\',\'\')\" id=\"adjdet_tab\" class=\"tabClicked\"  >\n\t\t\t<span class=\"tabSpanclicked\" id=\"adjdet_tabspan\">Adjustment Details</span>\n\t\t</a>\n\t</li>\n\t\t\n\t<li class=\"tablistitem\" title=\"Exemption Details\">\n\t\t<a onclick=\"javascript:tab_click2(\'exmtdet_tab\',\'\')\" id=\"exmtdet_tab\" class=\"tabA\"  >\n\t\t\t<span class=\"tabAspan\" id=\"exmtdet_tabspan\">Exemption Details</span>\n\t\t</a>\n\t</li>\n\n\t<li class=\"tablistitem\" title=\"Reminder Details\">\n\t\t<a onclick=\"javascript:tab_click2(\'remdet_tab\',\'\')\" id=\"remdet_tab\" class=\"tabA\"  >\n\t\t\t<span class=\"tabAspan\" id=\"remdet_tabspan\">Reminder Details</span>\n\t\t</a>\n\t</li>\n\n\t<li class=\"tablistitem\" title=\"Write-off Details\">\n\t\t<a onclick=\"javascript:tab_click2(\'writoffdet_tab\',\'\')\" id=\"writoffdet_tab\" class=\"tabA\"  >\n\t\t\t<span class=\"tabAspan\" id=\"writoffdet_tabspan\">Write-off Details</span>\n\t\t</a>\n\t</li>\n</ul>\n<a name=\'adjdet_focus\'> </a>\n<table width=\'100%\' cellpadding=\'0\' cellspacing=\'1\' border =\'0\' width=\'100%\'>\n<tr>\n\t<td >Adjustment Details</td>\n</tr>\n</table>\n\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n\n\n<ul id=\"tablist\" class=\"tablist\">\n\t<script>prevTabObj=\'pymtdet_tab\'</script>\n\t<li class=\"tablistitem\" title=\"Payment Details\">\n\t\t<a onclick=\"javascript:tab_click2(\'pymtdet_tab\',\'\')\" id=\"pymtdet_tab\" class=\"tabA\"  >\n\t\t\t<span class=\"tabAspan\" id=\"pymtdet_tabspan\">Payment Details</span>\n\t\t</a>\n\t</li>\n\n\t<li class=\"tablistitem\" title=\"Adjustment Details\">\n\t\t<a onclick=\"javascript:tab_click2(\'adjdet_tab\',\'\')\" id=\"adjdet_tab\" class=\"tabA\"  >\n\t\t\t<span class=\"tabAspan\" id=\"adjdet_tabspan\">Adjustment Details</span>\n\t\t</a>\n\t</li>\n\t\t\n\t<li class=\"tablistitem\" title=\"Exemption Details\">\n\t\t<a onclick=\"javascript:tab_click2(\'exmtdet_tab\',\'\')\" id=\"exmtdet_tab\" class=\"tabClicked\"  >\n\t\t\t<span class=\"tabSpanclicked\" id=\"exmtdet_tabspan\">Exemption Details</span>\n\t\t</a>\n\t</li>\n\n\t<li class=\"tablistitem\" title=\"Reminder Details\">\n\t\t<a onclick=\"javascript:tab_click2(\'remdet_tab\',\'\')\" id=\"remdet_tab\" class=\"tabA\"  >\n\t\t\t<span class=\"tabAspan\" id=\"remdet_tabspan\">Reminder Details</span>\n\t\t</a>\n\t</li>\n\n\t<li class=\"tablistitem\" title=\"Write-off Details\">\n\t\t<a onclick=\"javascript:tab_click2(\'writoffdet_tab\',\'\')\" id=\"writoffdet_tab\" class=\"tabA\"  >\n\t\t\t<span class=\"tabAspan\" id=\"writoffdet_tabspan\">Write-off Details</span>\n\t\t</a>\n\t</li>\n</ul>\n<a name=\'exmtdet_focus\'> </a>\n<table width=\'100%\' cellpadding=\'0\' cellspacing=\'1\' border =\'0\' width=\'100%\'>\n<tr>\n\t<td >Exemption Details</td>\n</tr>\n</table>\n\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n\n\n<ul id=\"tablist\" class=\"tablist\">\n\t<script>prevTabObj=\'pymtdet_tab\'</script>\n\t<li class=\"tablistitem\" title=\"Payment Details\">\n\t\t<a onclick=\"javascript:tab_click2(\'pymtdet_tab\',\'\')\" id=\"pymtdet_tab\" class=\"tabA\"  >\n\t\t\t<span class=\"tabAspan\" id=\"pymtdet_tabspan\">Payment Details</span>\n\t\t</a>\n\t</li>\n\n\t<li class=\"tablistitem\" title=\"Adjustment Details\">\n\t\t<a onclick=\"javascript:tab_click2(\'adjdet_tab\',\'\')\" id=\"adjdet_tab\" class=\"tabA\"  >\n\t\t\t<span class=\"tabAspan\" id=\"adjdet_tabspan\">Adjustment Details</span>\n\t\t</a>\n\t</li>\n\t\t\n\t<li class=\"tablistitem\" title=\"Exemption Details\">\n\t\t<a onclick=\"javascript:tab_click2(\'exmtdet_tab\',\'\')\" id=\"exmtdet_tab\" class=\"tabA\"  >\n\t\t\t<span class=\"tabAspan\" id=\"exmtdet_tabspan\">Exemption Details</span>\n\t\t</a>\n\t</li>\n\n\t<li class=\"tablistitem\" title=\"Reminder Details\">\n\t\t<a onclick=\"javascript:tab_click2(\'remdet_tab\',\'\')\" id=\"remdet_tab\" class=\"tabClicked\"  >\n\t\t\t<span class=\"tabSpanclicked\" id=\"remdet_tabspan\">Reminder Details</span>\n\t\t</a>\n\t</li>\n\n\t<li class=\"tablistitem\" title=\"Write-off Details\">\n\t\t<a onclick=\"javascript:tab_click2(\'writoffdet_tab\',\'\')\" id=\"writoffdet_tab\" class=\"tabA\"  >\n\t\t\t<span class=\"tabAspan\" id=\"writoffdet_tabspan\">Write-off Details</span>\n\t\t</a>\n\t</li>\n</ul>\n<a name=\'remdet_focus\'> </a>\n<table width=\'100%\' cellpadding=\'0\' cellspacing=\'1\' border =\'0\' width=\'100%\'>\n<tr>\n\t<td >Reminder Details</td>\n</tr>\n</table>\n\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n\n\n<ul id=\"tablist\" class=\"tablist\">\n\t<script>prevTabObj=\'pymtdet_tab\'</script>\n\t<li class=\"tablistitem\" title=\"Payment Details\">\n\t\t<a onclick=\"javascript:tab_click2(\'pymtdet_tab\',\'\')\" id=\"pymtdet_tab\" class=\"tabA\"  >\n\t\t\t<span class=\"tabAspan\" id=\"pymtdet_tabspan\">Payment Details</span>\n\t\t</a>\n\t</li>\n\n\t<li class=\"tablistitem\" title=\"Adjustment Details\">\n\t\t<a onclick=\"javascript:tab_click2(\'adjdet_tab\',\'\')\" id=\"adjdet_tab\" class=\"tabA\"  >\n\t\t\t<span class=\"tabAspan\" id=\"adjdet_tabspan\">Adjustment Details</span>\n\t\t</a>\n\t</li>\n\t\t\n\t<li class=\"tablistitem\" title=\"Exemption Details\">\n\t\t<a onclick=\"javascript:tab_click2(\'exmtdet_tab\',\'\')\" id=\"exmtdet_tab\" class=\"tabA\"  >\n\t\t\t<span class=\"tabAspan\" id=\"exmtdet_tabspan\">Exemption Details</span>\n\t\t</a>\n\t</li>\n\n\t<li class=\"tablistitem\" title=\"Reminder Details\">\n\t\t<a onclick=\"javascript:tab_click2(\'remdet_tab\',\'\')\" id=\"remdet_tab\" class=\"tabA\"  >\n\t\t\t<span class=\"tabAspan\" id=\"remdet_tabspan\">Reminder Details</span>\n\t\t</a>\n\t</li>\n\n\t<li class=\"tablistitem\" title=\"Write-off Details\">\n\t\t<a onclick=\"javascript:tab_click2(\'writoffdet_tab\',\'\')\" id=\"writoffdet_tab\" class=\"tabClicked\"  >\n\t\t\t<span class=\"tabSpanclicked\" id=\"writoffdet_tabspan\">Write-off Details</span>\n\t\t</a>\n\t</li>\n</ul>\n<a name=\'writoffdet_focus\'> </a>\n<table width=\'100%\' cellpadding=\'0\' cellspacing=\'1\' border =\'0\' width=\'100%\'>\n<tr>\n\t<td >Write-off Detail</td>\n</tr>\n</table>\n\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n<br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n\n</form>\n</body>\n\n</html>\n\n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);


	String tab_chk="";

	try
	{
		tab_chk=request.getParameter("tab_chk");
		if(tab_chk==null) tab_chk="";
//		System.out.println("tab_chk:"+tab_chk);
	}
	catch(Exception eX)
	{
			out.println("Error= "+eX);
	}

            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

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
