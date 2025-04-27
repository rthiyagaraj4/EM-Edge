package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __repdaterangecensusspecialty extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/RepDateRangeCensusSpecialty.jsp", 1727929546730L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link>\n</head>\n<script src=\'../../eIP/js/Rep2MasterList.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\'javascript\'></script>\n<script src=\"../../eCommon/js/common.js\" language=\'javascript\'></script>\n<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<script src=\"../../eCommon/js/messages.js\" language=\'javascript\'></script>\n\n\n<script>\nfunction reset() \n{\n\tf_query_add_mod.document.Rep2DailyIPCensusSpecialityForm.reset() ;\n}\n\nfunction run() \n{\n\t\n\t\t/*var frmdate = f_query_add_mod.document.Rep2DailyIPCensusSpecialityForm.P_FM_TRN_DATE;\n\t\tvar todate     = f_query_add_mod.document.Rep2DailyIPCensusSpecialityForm.P_TO_TRN_DATE ; \n\t\t\n\t\t\n\t\tif(frmdate.value == \"\") \n\t\t{\n\t\t\tvar err = getMessage(\'FROM_DATE_CANNOT_BE_BLANK\');\n\t\t\t\terr = err.replace(\'$\',\'From Date\');\n\n\n\t\tif(todate.value == \"\")\n\t\t\t{\n\t\n\t\t\t  err = err +\'<br>\'+ getMessage(\'TO_DT_NOT_BLANK\');\n\t\t\t\terr = err.replace(\'$\',\'To Date\');\n\t\t\t\t\n\n\t\t\t}\n\t\t\tmessageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+err;\n\n\t\t\treturn false;\n\t\t}\n\t\t\n\tif(todate.value != \"\")\n\t\t{\n\t\t\tif(doDateCheckAlert(frmdate,todate) == false ) {\n\t\t\t\t    todate.focus();\n                    todate.select();\n\t\t\t\t\tvar msg = getMessage(\"FM_DATE_GR_TO_DATE\");\n                    \tmessageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg;\n                }\n\t\t\telse\t\t\t\n\t\t\tf_query_add_mod.document.Rep2DailyIPCensusSpecialityForm.submit() ;\n\t\t}\n\t\telse\n\t{\n\t\t\tvar err1 = getMessage(\'TO_DT_NOT_BLANK\');\n\t\t\t\ttodate.focus();\n\t\t                \n\t\t\t\t//err1 = err1.replace(\'$\',\'To Date\');\n\t\t\t\tmessageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+err1;\n\t\t\treturn false;\n\t\t}*/\n\n\t\tif(f_query_add_mod.document.Rep2DailyIPCensusSpecialityForm)\n\t\t {\n\t\t /*\n\t\tvar fields = new Array(f_query_add_mod.document.Rep2DailyIPCensusSpecialityForm.P_FM_TRN_DATE,f_query_add_mod.document.Rep2DailyIPCensusSpecialityForm.P_TO_TRN_DATE);\n\t\t var names = new Array (getLabel(\'eIP.CensusDateRange.label\',\'IP\')+\' \'+getLabel(\'Common.from.label\',\'Common\') ,getLabel(\'eIP.CensusDateRange.label\',\'IP\')+\' \'+getLabel(\'Common.to.label\',\'Common\'))\n\n\t    // if(f_query_add_mod.checkFields( fields, names, messageFrame))\n\n\t     if(f_query_add_mod.checkFields( fields, names, messageFrame))\n\t\t {\n\t\t  f_query_add_mod.document.forms[0].action=\"../../eCommon/jsp/report_options.jsp\";\n          f_query_add_mod.document.forms[0].target=\"messageFrame\"\n\t\t  f_query_add_mod.document.Rep2DailyIPCensusSpecialityForm.submit() ;\n\t\t }\n\t\t }*/\n\n\t\t if(f_query_add_mod.document.Rep2DailyIPCensusSpecialityForm)\n\t\t {\n\t\t var fields = new Array(f_query_add_mod.document.Rep2DailyIPCensusSpecialityForm.census_date_from,f_query_add_mod.document.Rep2DailyIPCensusSpecialityForm.census_date_to);\n\t\t var names = new Array (getLabel(\'eIP.CensusDateRange.label\',\'IP\')+\' \'+getLabel(\'Common.from.label\',\'Common\') ,getLabel(\'eIP.CensusDateRange.label\',\'IP\')+\' \'+getLabel(\'Common.to.label\',\'Common\'))\n\n\t     if(f_query_add_mod.checkFields( fields, names, messageFrame))\n\t\t {\n\t\t\t  if(chkGrtr(f_query_add_mod.document.Rep2DailyIPCensusSpecialityForm.census_date_from,\n\t\t\t\tf_query_add_mod.document.Rep2DailyIPCensusSpecialityForm.census_date_to)==true)\n\t\t\t{\n\t\t\t\t f_query_add_mod.document.Rep2DailyIPCensusSpecialityForm.submit() ;\n\t\t\t\n\t\t\t}\n\t\t\n\t\t }\n\n\n\t\t }\n\t\t\n\t\t\t\n\t\t\n\t}\n\n\t\n\n</script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" frameborder=\'0\' scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\t<iframe scrolling=\"no\" name=\'f_query_add_mod\' id=\'f_query_add_mod\' src=\'../../eIP/jsp/Rep2DateRangeCensusSpecialty.jsp\'  frameborder=0 style=\'height:83vh;width:100vw\'></iframe>\n\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:9vh;width:100vw\'></iframe>\n</html>\n\n";
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf( source ));
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
