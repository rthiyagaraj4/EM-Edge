package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __repadmissionlist_srr extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/RepAdmissionList_SRR.jsp", 1710353705942L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n</head>\n<script src=\'../js/Rep2MasterList_SRR.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n\nfunction run(){\n\tvar error=\"\";\n\n\tvar Deceasedperiod=getLabel(\'Common.admissiondate.label\',\'common\');\n\t\tvar names = new Array(getLabel(\"Common.from.label\",\"Common\")+\" \"+Deceasedperiod,getLabel(\"Common.to.label\",\"Common\")+\" \"+Deceasedperiod);\n\n\tif(f_query_add_mod.document.forms[0].p_fm_admission_date.value==\"\"\n\t&&f_query_add_mod.document.forms[0].p_to_admission_date.value==\"\")\n\t{\n\n\t\tfor(i=0;i<2;i++)\n\t\t{\n\t\terror += getMessage(\"SHOULD_NOT_BE_BLANK\",\"Common\",new Array(encodeURIComponent(names[i])))+\"<br>\";\n\n\t\t}\n\t\t\n\t}\n\telse if(f_query_add_mod.document.forms[0].p_fm_admission_date.value!=\"\"\n\t&&f_query_add_mod.document.forms[0].p_to_admission_date.value==\"\")\n\t{\n\n\t\terror = getMessage(\"SHOULD_NOT_BE_BLANK\",\"Common\",new Array(encodeURIComponent(names[1])))+\"<br>\";\n\n}\n\telse  if(f_query_add_mod.document.forms[0].p_fm_admission_date.value==\"\"\n\t&&f_query_add_mod.document.forms[0].p_to_admission_date.value!=\"\")\n\t{\n\t\terror = getMessage(\"SHOULD_NOT_BE_BLANK\",\"Common\",new Array(encodeURIComponent(names[0])))+\"<br>\";\n\n\t}\n\telse if(f_query_add_mod.document.forms[0].p_fm_admission_date.value!=\"\"\n\t&&f_query_add_mod.document.forms[0].p_to_admission_date.value!=\"\")\n\t{\n\n\t\tvar obj1=f_query_add_mod.document.forms[0].p_fm_admission_date;\n\t\tvar obj2=f_query_add_mod.document.forms[0].p_to_admission_date;\n\n\t\tif(isBefore(obj1.value,obj2.value,\"DMYHM\",localeName)==false)\n\t\t{\n\t\t\tvar error=getMessage(\"TO_DT_GR_EQ_FM_DT\",\"SM\");\n\t\t\tvar Deceasedperiod=getLabel(\"Common.admissiondate.label\",\"common\"); \n\t\t\tvar from_Deceased=getLabel(\'Common.to.label\',\'common_labels\')+\" \"+Deceasedperiod;\n\t\t\tvar to_Deceased=getLabel(\'Common.from.label\',\'common_labels\')+\" \"+Deceasedperiod;\n\t\t\terror = error.replace(\'To Date\',from_Deceased);\n\t\t\terror = error.replace(\'From Date\',to_Deceased);\n\t\t//\tmessageFrame.location.href = \"../../eCommon/jsp/error.jsp?err_num=\"+error ;\n\t\t}\n\t\t\n\t}\n\t if ( error.length != 0 )\n\t\t{\n        \n\t\t   messageFrame.document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+error;\n       \n        }\n\t\telse\n\t\t{\n       \n\t\tvar dttime \n\t\t var dt\n        var time\n\t\tvar p_fm_admission_date=f_query_add_mod.document.forms[0].p_fm_admission_date.value;\n\n\t\t\tdttime = p_fm_admission_date.split(\" \");\n\t\t\tvar from=f_query_add_mod.document.forms[0].p_fm_admission_date.value;\n\t\t\tvar to=f_query_add_mod.document.forms[0].p_to_admission_date.value;\n\n\t\t\t if(dttime.length>1)\n\t\t\t{\n\t\t\t\t\t  dt=dttime[0]\n\t\t\t\ttime=dttime[1]\n\t\t\t}\n\n\t\t\tf_query_add_mod.document.forms[0].p_fm_admission_date.value=dt+time;\n\n\n\t\t\t   var p_to_admission_date=f_query_add_mod.document.forms[0].p_to_admission_date.value;\n\n\t\t\t\t dttime = p_to_admission_date.split(\" \");\n\n\t\t\t if(dttime.length>1)\n\t\t\t{\n\t\t\t\t\t  dt=dttime[0]\n\t\t\t\ttime=dttime[1]\n\t\t\t}\n\n\t\t\tf_query_add_mod.document.forms[0].p_to_admission_date.value=dt+time;;\n\t\t\t\t\t\n\t\t\tf_query_add_mod.document.Rep2AdmissionForm.submit() ;\n\n\t\t\tf_query_add_mod.document.forms[0].p_fm_admission_date.value=from;\n\t\t\tf_query_add_mod.document.forms[0].p_to_admission_date.value=to;\n\t\t}\n\t}\n</script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" frameborder=\'0\' scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\t<iframe scrolling=\"no\" name=\'f_query_add_mod\' id=\'f_query_add_mod\' src=\'../jsp/Rep2AdmissionDet_SRR.jsp\'  frameborder=0 style=\'height:80vh;width:100vw\'></iframe><iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:40%;width:100vw\'></iframe>\n</html>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block9Bytes, _wl_block9);
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
