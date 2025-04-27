package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __repwalkinwithoutappt extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/repWalkinWithoutAppt.jsp", 1709551940362L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script>\nfunction reset() {\n\tf_query_add_mod.document.repWalkinWithoutApptform.reset() ;\n}\n\nfunction chkGrtrMth(obj1,obj2)\n{\n\t\t\n\t\tif(isBefore(obj1.value,obj2.value,\"MM\",localeName)==false)\n\t\t{\n\t\t\tvar str = getLabel(\"Common.to.label\",\"Common\")+\" \"+getLabel(\"Common.month.label\",\"Common\");\n\t\t\tvar str1 = getLabel(\"Common.month.label\",\"Common\");\n\n\t\t\tvar error=getMessage(\"REMARKS_MUST_GR_EQUAL\",\"common\");\n\t\t\terror=error.replace(\"$\",str);\n\t\t\terror=error.replace(\"#\",str1);\n\t\t\tmessageFrame.location.href = \"../../eCommon/jsp/error.jsp?err_num=\"+error ;\n            return false;\n\t\t}\n\t\telse \n\t\t\treturn true;\n}\nfunction chkGrtrYear(obj1,obj2)\n{\n\t\t\n\t\tif(isBefore(obj1.value,obj2.value,\"YY\",localeName)==false)\n\t\t{\n\t\t\tvar str = getLabel(\"Common.to.label\",\"Common\")+\" \"+getLabel(\"Common.year.label\",\"Common\");\n\t\t\tvar str1 = getLabel(\"Common.year.label\",\"Common\");\n\n\t\t\tvar error=getMessage(\"REMARKS_MUST_GR_EQUAL\",\"common\");\n\t\t\terror=error.replace(\"$\",str);\n\t\t\terror=error.replace(\"#\",str1);\n\t\t\tmessageFrame.location.href = \"../../eCommon/jsp/error.jsp?err_num=\"+error ;\n            return false;\n\t\t}\n\t\telse \n\t\t\treturn true;\n}\n\nfunction run() \n{\n\tvar fields = new Array( f_query_add_mod.document.repWalkinWithoutApptform.p_fm_mon,\n\tf_query_add_mod.document.repWalkinWithoutApptform.p_to_mon,\n\tf_query_add_mod.document.repWalkinWithoutApptform.p_fm_year,\n\tf_query_add_mod.document.repWalkinWithoutApptform.p_to_year);\n\tvar names = new Array(getLabel(\"Common.month.label\",\"Common\")+\" \"+getLabel(\"Common.from.label\",\"Common\"), getLabel(\"Common.month.label\",\"Common\")+\" \"+getLabel(\"Common.to.label\",\"Common\"),getLabel(\"Common.year.label\",\"Common\")+\" \"+getLabel(\"Common.from.label\",\"Common\"),getLabel(\"Common.year.label\",\"Common\")+\" \"+getLabel(\"Common.to.label\",\"Common\"));\n\tif(f_query_add_mod.checkFields( fields, names, messageFrame))\n\t{\t\n\tvar frommon = f_query_add_mod.document.repWalkinWithoutApptform.p_fm_mon;\n\tvar tomon     = f_query_add_mod.document.repWalkinWithoutApptform.p_to_mon ;   \n\tvar fromyear = f_query_add_mod.document.repWalkinWithoutApptform.p_fm_year;\n\tvar toyear     = f_query_add_mod.document.repWalkinWithoutApptform.p_to_year ; \n\t\n\tif(fromyear.value == toyear.value)\n    {\n\t  if(chkGrtrMth(frommon,tomon) == true)\n\t  {\n\t\tif(chkGrtrYear(fromyear,toyear) == true) \n\t\t{\n\t\t\tif (frommon.value!=\"\" && fromyear.value!=\"\")\n\t\t\tf_query_add_mod.document.repWalkinWithoutApptform.p_fr_month.value = frommon.value + \'/\' + fromyear.value ;\n\t\t\tif (tomon.value!=\"\" && toyear.value!=\"\")\n\t\t\tf_query_add_mod.document.repWalkinWithoutApptform.p_to_month.value = tomon.value + \'/\' + toyear.value ;\n\t\t\tif(f_query_add_mod.CheckString( getLabel(\"Common.locationcode.label\",\"Common\"),f_query_add_mod.document.repWalkinWithoutApptform.p_fm_locn_code,f_query_add_mod.document.repWalkinWithoutApptform.p_to_locn_code,messageFrame))\n\t\t\tif(f_query_add_mod.CheckString( getLabel(\"Common.speciality.label\",\"Common\"),f_query_add_mod.document.repWalkinWithoutApptform.p_fm_specialty_code,f_query_add_mod.document.repWalkinWithoutApptform.p_to_specialty_code,messageFrame))\n\t\t\tif(f_query_add_mod.CheckString( getLabel(\"Common.ServiceCode.label\",\"Common\"),f_query_add_mod.document.repWalkinWithoutApptform.p_fm_service_code,f_query_add_mod.document.repWalkinWithoutApptform.p_to_service_code,messageFrame)){\n\t\t\tf_query_add_mod.document.repWalkinWithoutApptform.submit() ;\n\t\t\t}\n\t\t}\n\t  }\t\t\n\t}\n\telse\n\t{\n\t\tif(chkGrtrYear(fromyear,toyear) == true) \n\t\t{\n\t\t\tf_query_add_mod.document.repWalkinWithoutApptform.p_fr_month.value = frommon.value + \'/\' + fromyear.value ;\n\t\t\tf_query_add_mod.document.repWalkinWithoutApptform.p_to_month.value = tomon.value + \'/\' + toyear.value ;\n\t\t\tif(f_query_add_mod.CheckString( getLabel(\"Common.locationcode.label\",\"Common\"),f_query_add_mod.document.repWalkinWithoutApptform.p_fm_locn_code,f_query_add_mod.document.repWalkinWithoutApptform.p_to_locn_code,messageFrame))\n\t\t\tif(f_query_add_mod.CheckString( getLabel(\"Common.SpecialtyCode.label\",\"Common\"),f_query_add_mod.document.repWalkinWithoutApptform.p_fm_specialty_code,f_query_add_mod.document.repWalkinWithoutApptform.p_to_specialty_code,messageFrame))\n\t\t\tif(f_query_add_mod.CheckString( getLabel(\"Common.ServiceCode.label\",\"Common\"),f_query_add_mod.document.repWalkinWithoutApptform.p_fm_service_code,f_query_add_mod.document.repWalkinWithoutApptform.p_to_service_code,messageFrame)){\n\t\t\t\tf_query_add_mod.document.repWalkinWithoutApptform.submit() ;\n\t\t\t}\n\t\t}\n\t}\n\n\t\t/*if(frommon.value == \"\" && fromyear.value != \"\") \n\t\t{\n\t\t\tvar err = getMessage(\'CAN_NOT_BE_BLANK\',\'COMMON\');\n\t\t\t\terr = err.replace(\'$\',getLabel(\"Common.from.label\",\"Common\")+\"\"+getLabel(\"Common.month.label\",\"Common\"));\n\t\t\t\talert(err);\n\t\t\treturn false;\n\t\t}\n\n\t\tif(frommon.value != \"\" && fromyear.value == \"\")\n\t\t{\n\t\t\tvar err = getMessage(\'CAN_NOT_BE_BLANK\',\'COMMON\');\n\t\t\t\terr = err.replace(\'$\',getLabel(\"Common.from.label\",\"Common\")+\"\"+getLabel(\"Common.year.label\",\"Common\"));\n\t\t\t\talert(err);\n\t\t\treturn false;\n\t\t}\n\t\t\n\t\tif(tomon.value == \"\" && toyear.value != \"\") \n\t\t{\n\t\t\tvar err = getMessage(\'CAN_NOT_BE_BLANK\',\'COMMON\');\n\t\t\t\terr = err.replace(\'$\',getLabel(\"Common.to.label\",\"Common\")+\"\"+getLabel(\"Common.month.label\",\"Common\"));\n\t\t\t\talert(err);\n\t\t\treturn false;\n\t\t}\n\n\t\tif(tomon.value != \"\" && toyear.value == \"\")\n\t\t{\n\t\t\tvar err = getMessage(\'CAN_NOT_BE_BLANK\',\'COMMON\');\n\t\t\t\terr = err.replace(\'$\',getLabel(\"Common.to.label\",\"Common\")+\"\"+getLabel(\"Common.year.label\",\"Common\"));\n\t\t\t\talert(err);\n\t\t\treturn false;\n\t\t}\n\n\tif(fromyear.value == toyear.value)\n    {\n\t  if( f_query_add_mod.CheckString(getLabel(\"Common.month.label\",\"Common\"), frommon , tomon, messageFrame ) ) \n\t  {\n\t\tif( f_query_add_mod.CheckString(getLabel(\"Common.year.label\",\"Common\"), fromyear , toyear, messageFrame ) ) \n\t\t{\n\t\t\tif (frommon.value!=\"\" && fromyear.value!=\"\")\n\t\t\tf_query_add_mod.document.repWalkinWithoutApptform.p_fr_month.value = frommon.value + \'/\' + fromyear.value ;\n\t\t\tif (tomon.value!=\"\" && toyear.value!=\"\")\n\t\t\tf_query_add_mod.document.repWalkinWithoutApptform.p_to_month.value = tomon.value + \'/\' + toyear.value ;\n\t\t\tif(f_query_add_mod.CheckString( getLabel(\"Common.locationcode.label\",\"Common\"),f_query_add_mod.document.repWalkinWithoutApptform.p_fm_locn_code,f_query_add_mod.document.repWalkinWithoutApptform.p_to_locn_code,messageFrame))\n\t\t\tif(f_query_add_mod.CheckString( getLabel(\"Common.speciality.label\",\"Common\"),f_query_add_mod.document.repWalkinWithoutApptform.p_fm_specialty_code,f_query_add_mod.document.repWalkinWithoutApptform.p_to_specialty_code,messageFrame))\n\t\t\tif(f_query_add_mod.CheckString( getLabel(\"Common.ServiceCode.label\",\"Common\"),f_query_add_mod.document.repWalkinWithoutApptform.p_fm_service_code,f_query_add_mod.document.repWalkinWithoutApptform.p_to_service_code,messageFrame)){\n\t\t\tf_query_add_mod.document.repWalkinWithoutApptform.submit() ;\n\t\t\t}\n\t\t}\n\t  }\t\t\n\t}\n\telse\n\t{\n\t\tif( f_query_add_mod.CheckString(getLabel(\"Common.year.label\",\"Common\"), fromyear , toyear, messageFrame ) ) \n\t\t{\n\t\t\tf_query_add_mod.document.repWalkinWithoutApptform.p_fr_month.value = frommon.value + \'/\' + fromyear.value ;\n\t\t\tf_query_add_mod.document.repWalkinWithoutApptform.p_to_month.value = tomon.value + \'/\' + toyear.value ;\n\t\t\tif(f_query_add_mod.CheckString( getLabel(\"Common.locationcode.label\",\"Common\"),f_query_add_mod.document.repWalkinWithoutApptform.p_fm_locn_code,f_query_add_mod.document.repWalkinWithoutApptform.p_to_locn_code,messageFrame))\n\t\t\tif(f_query_add_mod.CheckString( getLabel(\"Common.SpecialtyCode.label\",\"Common\"),f_query_add_mod.document.repWalkinWithoutApptform.p_fm_specialty_code,f_query_add_mod.document.repWalkinWithoutApptform.p_to_specialty_code,messageFrame))\n\t\t\tif(f_query_add_mod.CheckString( getLabel(\"Common.ServiceCode.label\",\"Common\"),f_query_add_mod.document.repWalkinWithoutApptform.p_fm_service_code,f_query_add_mod.document.repWalkinWithoutApptform.p_to_service_code,messageFrame)){\n\t\t\t\tf_query_add_mod.document.repWalkinWithoutApptform.submit() ;\n\t\t\t}\n\t\t}\n\t}*/\n}\n}\n</script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\'\tsrc=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" frameborder=0 scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' \t\tsrc=\'../../eOP/jsp/repWalkinWithoutApptform.jsp\' frameborder=0 style=\'height:80vh;width:100vw\'></iframe>\n\t<iframe name=\'messageFrame\' id=\'messageFrame\'\t\tsrc=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:12vh;width:100vw\'></iframe>\n\n";
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
 request.setCharacterEncoding("UTF-8"); 
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
