package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __repadmreg extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/repAdmReg.jsp", 1721727689750L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n<head>\n    ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n</head>\n<script src=\'../js/Rep2MasterList.js\' language=\'javascript\'></script>\n<!-- <script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script> -->\n<script src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n\nfunction reset()\n{\nf_query_add_mod.document.location.reload();\n}\n\nfunction run()\n{     \n\t\tif(f_query_add_mod.document.repAdmRegForm)\n\t\t{\n\t\tvar fields = new Array(f_query_add_mod.document.forms[0].P_fm_DATE,f_query_add_mod.document.forms[0].P_to_DATE);\n\t\tif (f_query_add_mod.doDateCheck(f_query_add_mod.document.forms[0].P_fm_DATE,f_query_add_mod.document.forms[0].P_to_DATE, messageFrame))\t \n\t\t\t{\n\t\t//var names = new Array (escape(\"Admission From Date\"),escape(\"Admission To Date\"))\n\t\tif (f_query_add_mod.document.forms[0].p_type.value == \"A\")\n\t\t     var names = new Array (escape(getLabel(\"eIP.AdmDateFrom.label\",\"IP\")),escape(getLabel(\"eIP.AdmDateTo.label\",\"IP\")))\n\t\telse if (f_query_add_mod.document.forms[0].p_type.value == \"D\")\n\t\t\t var names = new Array (escape(getLabel(\"eIP.DischargeDateFrom.label\",\"IP\")),escape(getLabel(\"eIP.DischargeDateTo.label\",\"IP\")))\n\t\tif(f_query_add_mod.checkFields( fields, names, messageFrame))\n\t\t   {\n\t\t\tif (f_query_add_mod.CheckString(getLabel(\"Common.speciality.label\",\"Common\"), f_query_add_mod.document.forms[0].P_FM_SPECIALITY_CODE,f_query_add_mod.document.forms[0].P_TO_SPECIALITY_CODE, messageFrame))\n\t\t\t\n\t\t\tif (f_query_add_mod.CheckString(getLabel(\"Common.Location.label\",\"Common\"), f_query_add_mod.document.forms[0].P_FM_CLINIC_CODE,f_query_add_mod.document.forms[0].P_TO_CLINIC_CODE, messageFrame))\n\t\t\t\tf_query_add_mod.document.forms[0].action=\"../../eCommon/jsp/report_options.jsp\"; \n\t\t\t    f_query_add_mod.document.forms[0].target=\"messageFrame\";\n\t\t     f_query_add_mod.document.repAdmRegForm.submit() ;\n\t\t\t}\n\t\t\t}\n\t\t}\n}\n</script>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" frameborder=\'0\' scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\t<iframe scrolling=\"no\" name=\'f_query_add_mod\' id=\'f_query_add_mod\' src=\'../jsp/repAdmRegForm.jsp\'  frameborder=0 style=\'height:83vh;width:100vw\'></iframe>\n\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:9vh;width:100vw\'></iframe>\n</html>\n\n";
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
String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf( source ));
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
