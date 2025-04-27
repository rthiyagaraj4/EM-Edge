package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import eBL.*;
import eBL.Common.*;
import eCommon.Common.*;

public final class __biilingreportcriteriaframes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BiilingReportCriteriaFrames.jsp", 1743572558227L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n-----------------------------------------------------------------------------------------------\nDate       Edit History   Name        Description\n-----------------------------------------------------------------------------------------------\n09/01/13      100         Bmohankumar  created\n-----------------------------------------------------------------------------------------------\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n\n<HTML>   \n \n<HEAD>  \n</HEAD>    \n<!--\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'</link> \n-->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\' type=\'text/css\'/>\t\t\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script> \n\t\t<script language=\"javascript\" src=\'../js/ReportCriteriaScript.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n\t\t<script>\n\t\tfunction run()  \n\t\t{\n\t\t\t\n\n\t\t\tvar formsObj =  parent.frames[2].BillingReportCriteria.BillingReportCriteriaForm.document.forms[0];\n\n\t\t\tvar p_episode_type =formsObj.p_episode_type.value;\t \n\t\t\tvar p_fm_date\t=formsObj.p_fm_date.value;\t \n\t\t\tvar p_to_date =formsObj.p_to_date.value;\n\t\t\t\n\t\t\tvar pat_id =   formsObj.patient_id.value;\n\t\t\t\n\t\t\tif(pat_id !=\'\' && pat_id !=\'undefined\')\t\t\n\t\t\tformsObj.p_patient_id.value =   pat_id;\n\t\t\telse\n\t\t\t\tformsObj.p_patient_id.value =   \'\';\n\n\t\t\tformsObj.p_report_id.value =   formsObj.sum_yn.value;\n\t\t\tformsObj.pgm_id.value =   formsObj.sum_yn.value;\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\tvar ep_id = formsObj.episode_id.value;\n\t\t\t\n\t\t\t\n\t\t\tif(p_episode_type == \'O\' && ep_id !=\"\")\n\t\t\t{\t\n\t\t\t\n\t\t\tvar e_id =  ep_id.substring(0,8);\n\n\t\t\tvar v_id =  ep_id.substring(8,ep_id.length);\t\t\t\n\t\t\t\t\n\t\t\tformsObj.p_episode_id.value =  e_id;\n\t\t\tformsObj.p_visit_id.value =    v_id;\n\t\t\t\n\t\t\t}\n\t\t\t\n\n\t\t\t\n\t\t\tif(p_episode_type==undefined || p_episode_type==\'\')\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL00028\",\"BL\"));\n\t\t\t\treturn;\n\t\t\t}\n\t\t\tif(p_fm_date==undefined || p_fm_date==\'\')\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL00004\",\"BL\"));\n\t\t\t\treturn;\n\t\t\t}\n\t\t\tif(p_to_date==undefined || p_to_date==\'\')\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL8560\",\"BL\"));\n\t\t\t\treturn;\n\t\t\t}\n\t\t\t//Spl Char Issue\n\t\t\tvar dummyDoc = parent.frames[2].messageFrame.document;\n\t\t\tvar htmlVal = \"<html><body>\";\n\t\t\t\thtmlVal += \"<form name=\'dummy_frm\' id=\'dummy_frm\'  action=\'../../eCommon/jsp/report_options.jsp\' >\";\n\t\t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_patient_id\' id=\'p_patient_id\' value=\'\"+formsObj.p_patient_id.value+\"\'>\";\n\t\t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_episode_type\' id=\'p_episode_type\' value=\'\"+formsObj.p_episode_type.value+\"\'>\";\n\t\t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_episode_id\' id=\'p_episode_id\' value=\'\"+formsObj.p_episode_id.value+\"\'>\";\n\t\t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_visit_id\' id=\'p_visit_id\' value=\'\"+formsObj.p_visit_id.value+\"\'>\";\n\t\t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_language_Id\' id=\'p_language_Id\' value=\'\"+formsObj.locale.value+\"\'>\";\n\t\t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_facility_id\' id=\'p_facility_id\' value=\'\"+formsObj.facilityId.value+\"\'>\";\n\t\t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_report_id\' id=\'p_report_id\' value=\'\"+formsObj.p_report_id.value+\"\'>\";\n\t\t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_module_id\' id=\'p_module_id\' value=\'\"+formsObj.p_module_id.value+\"\'>\";\n\t\t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_policy_type_code\' id=\'p_policy_type_code\' value=\'\"+formsObj.p_policy_type_code.value+\"\'>\";\n\t\t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_payer_grp_code\' id=\'p_payer_grp_code\' value=\'\"+formsObj.p_payer_grp_code.value+\"\'>\";\n\t\t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_cust_code\' id=\'p_cust_code\' value=\'\"+formsObj.p_cust_code.value+\"\'>\";\n\t\t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_fm_date\' id=\'p_fm_date\' value=\'\"+formsObj.p_fm_date.value+\"\'>\";\n\t\t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_to_date\' id=\'p_to_date\' value=\'\"+formsObj.p_to_date.value+\"\'>\";\n\t\t\t\thtmlVal += \"<input type=\'hidden\' name=\'pgm_id\' id=\'pgm_id\' value=\'\"+formsObj.pgm_id.value+\"\'>\";\n\t\t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_physician_id\' id=\'p_physician_id\' value=\'\"+formsObj.p_physician.value+\"\'>\";\n\t\t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_specialty_code\' id=\'p_specialty_code\' value=\'\"+formsObj.p_specialty_code.value+\"\'>\";\n\n\t\t\t\thtmlVal += \"</form></body></html>\";\n\n\t\t\tdummyDoc.body.insertAdjacentHTML(\"afterbegin\",htmlVal);\n\t\t\tdummyDoc.dummy_frm.submit();\n\t\t\t//Spl Char Issue\n\t\t\t//formsObj.submit();\n\t\t\t\t\t\t\n\t\t}\n\t\t</script>\t\n\t\t\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:6vh;width:100vw\'></iframe>\n\t\t\t <iframe name=\'BillingReportCriteria\' id=\'BillingReportCriteria\' \tsrc=\'BillingReportCriteria.jsp\' frameborder=0 scrolling=\'auto\' noresize style=\'height:87vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\'\t\tsrc=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' noresize style=\'height:7vh;width:100vw\'></iframe> \n\n\t\n\n\n</HTML>  \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
			String function_id=request.getParameter("function_id");
			if(function_id==null || function_id.equals("")) function_id="";
			String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
			String source = url + params ;


            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(source));
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
