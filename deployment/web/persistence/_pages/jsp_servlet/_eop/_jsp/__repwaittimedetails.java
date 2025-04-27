package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __repwaittimedetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/repWaitTimeDetails.jsp", 1716521752508L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n <script>\nfunction chkGrtr(obj1,obj2)\n{\n\t\t\n\t\tif(isBefore(obj1.value,obj2.value,\"DMY\",localeName)==false)\n\t\t{\n\t\t\tvar error=getMessage(\"TO_DT_GR_EQ_FM_DT\",\"SM\");\n\t\t\tmessageFrame.location.href = \"../../eCommon/jsp/error.jsp?err_num=\"+error ;\n            return false;\n\t\t}\n\t\telse \n\t\t\treturn true;\n}\n\nfunction run() \n{  \n\t   \n\t  \n\n\t\tvar fromdate = f_query_add_mod.document.forms[0].fm_date;\n\t\tvar todate = f_query_add_mod.document.forms[0].to_date;\n\t\t\n\t\n\n\t\tvar fields = new Array ( f_query_add_mod.document.forms[0].fm_date,f_query_add_mod.document.forms[0].to_date);\n\t\tvar names = new Array ( getLabel(\"Common.fromdate.label\",\"Common\"),getLabel(\"Common.todate.label\",\"Common\"));\n\t\tif(f_query_add_mod.checkFields( fields, names, messageFrame)) \n\t\t{\n\t\t\tf_query_add_mod.document.forms[0].p_fm_locn_code.value = f_query_add_mod.document.forms[0].fm_locn_code.value;\n\t\t\tf_query_add_mod.document.forms[0].p_to_locn_code.value = f_query_add_mod.document.forms[0].to_locn_code.value;\n\t\t\t\n\t\t\tf_query_add_mod.document.forms[0].p_fm_practitioner_id.value = f_query_add_mod.document.forms[0].fm_practitioner_id.value;\n\t\t\tf_query_add_mod.document.forms[0].p_to_practitioner_id.value = f_query_add_mod.document.forms[0].to_practitioner_id.value;\n\t\t\tif( chkGrtr(fromdate, todate) == true ) \n\t\t\t{\n\t\t\t\tf_query_add_mod.document.forms[0].p_fm_date.value = fromdate.value;\n\t\t\t\tf_query_add_mod.document.forms[0].p_to_date.value = todate.value;\n\t\t\t\t\n         if(CheckString1(getLabel(\"Common.locationcode.label\",\"Common\"),f_query_add_mod.document.forms[0].fm_locn_code,f_query_add_mod.document.forms[0].to_locn_code,messageFrame))\n\t         if(CheckString1(getLabel(\"Common.practitionerid.label\",\"Common\"),f_query_add_mod.document.forms[0].fm_practitioner_id,f_query_add_mod.document.forms[0].to_practitioner_id,messageFrame))\n\t\t\t\t \n\t\t\t if(CheckString1(getLabel(\"Common.SpecialtyCode.label\",\"Common\"),f_query_add_mod.document.forms[0].p_fm_specialty_code,f_query_add_mod.document.forms[0].p_to_specialty_code,messageFrame))  \n\t\t\t\tf_query_add_mod.document.forms[0].action=\"../../eCommon/jsp/report_options.jsp\";\n\t\t\t\tf_query_add_mod.document.forms[0].target=\"messageFrame\";\n\t\t\t\tf_query_add_mod.document.forms[0].submit();\n\t\t\t}\t\n\t\t}\n\t\n\t\n\t\n}\n\n\nfunction reset() \n{\n\tf_query_add_mod.document.forms[0].reset();\n}\n\nfunction CheckString1(str ,fromobj,toobj,messageFrame) {\n\n\t var arr = new Array(toobj.value,fromobj.value);\n    if( trimCheck(fromobj.value) && trimCheck(toobj.value) ) {\n        if(fromobj.value <= toobj.value) {\n            return true;\n        }\n        else {\n\t\t\tvar error=getMessage(\"REMARKS_MUST_GR_EQUAL\",\"common\",arr);\n\t\t\n\t\t\terror=error.replace(\"$\",getLabel(\'Common.to.label\',\'common_labels\')+ \' \' +str);\n\t\t\terror=error.replace(\"#\",str);\n            messageFrame.location.href = \"../../eCommon/jsp/error.jsp?err_num=\"+error  ;\n            return false;\n        }\n    }\n    else {\n        return true;\n    }\n}\n\n\n</script>\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\'\tsrc=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" frameborder=0 scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' \tsrc=\'../../eOP/jsp/repWaitTimeDetailsList.jsp\' frameborder=0 style=\'height:80vh;width:100vw\'></iframe>\n\t<iframe name=\'messageFrame\' id=\'messageFrame\'\t\tsrc=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:12vh;width:100vw\'></iframe>\n\n</html>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
		

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( source));
            _bw.write(_wl_block9Bytes, _wl_block9);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
