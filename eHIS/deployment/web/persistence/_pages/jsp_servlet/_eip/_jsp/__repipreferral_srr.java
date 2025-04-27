package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __repipreferral_srr extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/RepIPReferral_SRR.jsp", 1710354087723L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\t\n<script src=\"../../eCommon/js/DateUtils.js\"></script>\n<script src=\"../../eCommon/js/common.js\"></script>\n\n<script>\nfunction reset()\n{\n\t//f_query_add_mod.document.RepIpReferral.reset() ;\n\tf_query_add_mod.document.location.reload() ;\n}\n\nfunction run() \n{\n\tvar fromdate = f_query_add_mod.document.RepIpReferral.p_fm_admn_date;\n\tvar todate   = f_query_add_mod.document.RepIpReferral.p_to_admn_date ;   \n\tf_query_add_mod.document.RepIpReferral.p_fm_admn_date.value = fromdate.value ;\n\tf_query_add_mod.document.RepIpReferral.p_to_admn_date.value = todate.value ;\n\t//if( f_query_add_mod.doDateCheck( f_query_add_mod.document.RepIpReferral.p_fm_admn_date,f_query_add_mod.document.RepIpReferral.p_to_admn_date, messageFrame )  )\n\t\n\t//if( f_query_add_mod.doDateCheck(\'Referral Date\', f_query_add_mod.document.RepIpReferral.p_fm_admn_date,f_query_add_mod.document.RepIpReferral.p_to_admn_date)  )\n\tif( !f_query_add_mod.doDateCheckAlert( f_query_add_mod.document.RepIpReferral.p_fm_admn_date,f_query_add_mod.document.RepIpReferral.p_to_admn_date )  )\n\t{\t\t\t\t\n\t\t\t\tvar error=getMessage(\"TO_DT_GR_EQ_FM_DT\",\"SM\");\t\t\t\t\t\n\t\t\t\tmessageFrame.location.href = \"../../eCommon/jsp/error.jsp?err_num=\"+error; \n\t\t\t\treturn;\n\t}\t\n\t\tif( f_query_add_mod.CheckString(getLabel(\'Common.practitionerid.label\',\'Common\'), f_query_add_mod.document.RepIpReferral.p_fm_pract_id,f_query_add_mod.document.RepIpReferral.p_to_pract_id, messageFrame )  )\n\t\t\tif( f_query_add_mod.CheckString(getLabel(\'Common.locationcode.label\',\'Common\'), f_query_add_mod.document.RepIpReferral.p_fm_location,f_query_add_mod.document.RepIpReferral.p_to_location, messageFrame )  )\n\t\t\t\tif( f_query_add_mod.CheckString(getLabel(\'Common.SpecialityCode.label\',\'Common\'), f_query_add_mod.document.RepIpReferral.p_fm_specialty,f_query_add_mod.document.RepIpReferral.p_to_specialty, messageFrame )  )\n\t\t\t\t\tf_query_add_mod.document.RepIpReferral.submit() ;\n\t\n}\n\nfunction doDateCheck(str,from,to){\n\t    var fromdate = from.value ;\n\t\tvar todate = to.value ;\n\t\tif(fromdate!=\'\' && todate!=\'\')\n\t\t{\n\t\t\tvar greg_fromDate = convertDate(fromdate,\"DMY\",localeName,\"en\");\n\t\t\tvar greg_toDate = convertDate(todate,\"DMY\",localeName,\"en\");\n\t\t\t\n\t\t\tif(f_query_add_mod.isBefore(greg_fromDate,greg_toDate,\"DMY\",\"en\"))\n\t\t\t{\n\t\t\t\t\n\t\t\t\treturn true;\n\t\t\t}\n\t\t\telse \n\t\t\t{\n\t\t\t\tvar error=f_query_add_mod.getMessage(\"REMARKS_MUST_GR_EQUAL\",\"common\");\n\t\t\t\terror=error.replace(\"$\",str);\n\t\t\t\terror=error.replace(\"#\",str);\n\t\t\t\tmessageFrame.location.href = \"../../eCommon/jsp/error.jsp?err_num=\"+error  ;\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t\telse\n\t\t\treturn true;\n\n\n}\n\n</script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\'\tsrc=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" frameborder=0 scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' \t\tsrc=\'../jsp/Rep2IPReferral_SRR.jsp\' frameborder=0 style=\'height:80vh;width:100vw\'></iframe><iframe name=\'messageFrame\' id=\'messageFrame\'\t\tsrc=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:12vh;width:100vw\'></iframe>\n\n";
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
 request.setCharacterEncoding("UTF-8");  
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
            _bw.write(_wl_block5Bytes, _wl_block5);

	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf( source ));
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
