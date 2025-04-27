package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import javax.servlet.http.*;

public final class __demopractitionersearch extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/DemoPractitionerSearch.jsp", 1743142421375L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<HEAD>\n<TITLE></TITLE>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'></link>\n<script src=\"../../eCommon/js/ValidateControl.js\"></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<script>\nasync function searchCode(obj,target)\n\t{\n\t\t\tvar retVal = \tnew String();\n\t\t\tvar dialogHeight= \"28\" ;\n\t\t\tvar dialogWidth\t= \"43\" ;\n\t\t\tvar status = \"no\";\n\t\t\tvar arguments\t= \"\" ;\n\t\t\tvar sql=\"\";\n\t\t\tvar search_code=\"\";\n\t\t\tvar search_desc=\"\";\n\t\t\tvar tit=\"\";\n\t\t\t\n\t\t\t//alert(obj.name)\n\t\t\tif(obj.name==\"durationtype\")\n\t\t\t{\n\t\t\t\ttit=\"Duration Type\"\n\t\t\t\tsql=\"select DURN_TYPE, DURN_DESC from AM_DURATION_TYPE\";\n\t\t\t\tsearch_code=\"DURN_TYPE\";\n\t\t\t\tsearch_desc= \"DURN_DESC\";\n\t\t\t}\n\t\t\t\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\t\t\tretVal = await window.showModalDialog(\"../../eCommon/jsp/GeneralSearch.jsp?SQL=\"+sql+\"&search_code=\"+search_code+\"&search_desc=\"+search_desc+\"&title=\"+tit,arguments,features);\n\n\t\t\tif (!(retVal == null))\n\t\t\t{\n\t\t\t\ttarget.value=retVal;\n\t\t\t}\n\t\t\telse\n\t\t\t\ttarget.focus();\n\t}\n</script>\n<script>\nasync function GeneralPractitionerSearch(obj,target)\n{\n\t\t\tvar retVal = \tnew String();\n\t\t\tvar dialogHeight= \"30\" ;\n\t\t\tvar dialogWidth\t= \"50\" ;\n\t\t\tvar status = \"no\";\n\t\t\tvar arguments\t= \"\" ;\n\t\n\t\t\t//var sql=\"\";\n\t\t\t//var search_code=\"\";\n\t\t\t//var search_desc=\"\";\n\t\t\tvar tit=\"\";\n\t\t\t\n\t//alert(obj.name)\n\tif(obj.name==\"demo_button\")\n\t{\n\t\ttit=\"General Practitioner Search \"\n//\tsql=\"select DURN_TYPE, DURN_DESC from AM_DURATION_TYPE\";\n//\t\tsearch_code=\"DURN_TYPE\";\n//\t\tsearch_desc= \"DURN_DESC\";\n\t}\n\t\t\t\n\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\t\n\tretVal = await window.showModalDialog(\"../../eAM/jsp/GeneralPractitionerSearch.jsp?title=\"+tit,arguments,features);\n\n\t\t\tif (!(retVal == null))\n\t\t\t{\n\t\t\t\ttarget.value=retVal;\n\t\t\t}\n\t\t\telse\n\t\t\t\ttarget.focus();\n}\n</script>\n</HEAD>\n<BODY onLoad=\"Focusing(\'demo_call_text\')\" onMouseDown=\"CodeArrest();\" onKeyDown = \"lockKey();\">\n<br>\n<br>\n<form name=\"repDurationTypeForm\" id=\"repDurationTypeForm\" action=\"../../eCommon/jsp/report_options.jsp\" target=\"messageFrame\">\n<table width=\'80%\' align=\'center\' valign=\'top\'>\n\n<tr>\n\t\t<td width=\"100%\" class=\"Border\" align=\'center\'>\n\t\t<table width=\'80%\' cellPadding=\"0\" cellSpacing=\"0\"  align=\'center\' >\n\t\t<tr>\n\t\t\t<td>&nbsp;</td>\n\t\t\t<Td>&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td align=\'right\' width=\'30%\' class=\"label\"><fmt:message key=\"eAM.DemoCall.label\" bundle=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\"/>&nbsp;</td>\n\t\t\t<td width=\'20%\'  ><input type=text  name=\'demo_call_text\' id=\'demo_call_text\' size=\"16\" maxlength=\"16\" align=\"center\"><input type=\'button\' name=\'demo_button\' id=\'demo_button\' value=\'?\' class=\'button\' onclick=\'GeneralPractitionerSearch(this, demo_call_text)\'>\n\t\t\t</td>\n\t   </tr>\n\t\t<tr>\n\t\t\t<td>&nbsp;</td>\n\t\t\t<Td>&nbsp;</td>\n\t\t</tr>\n\t\n</table>\n</form>\n</BODY>\n</HTML>\n\n";
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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

//	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
//	String p_user_name		= (String) session.getValue( "login_user" ) ;

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",java.lang.String.class,pageContext, null ));
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
