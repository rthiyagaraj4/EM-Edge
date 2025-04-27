package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __repinsurwisepatstatsframes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/repInsurWisePatStatsFrames.jsp", 1709551326389L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<script src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n<script src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script src=\"../../eCommon/js/common.js\"></script>\n<script src=\"../../eCommon/js/DateUtils.js\"></script>\n<script>\nfunction reset() {\n\tf_query_add_mod.document.reportInsWisePatStatsform.reset() ;\n\tf_query_add_mod.location.href =\'../../eOP/jsp/repInsurWisePatStats.jsp\';\n}\nfunction run() \n{\nvar fields = new Array ( f_query_add_mod.document.reportInsWisePatStatsform.p_from_date,f_query_add_mod.document.reportInsWisePatStatsform.p_to_date);\nvar visitDate=getLabel(\"eOP.VisitAdmDate.label\",\"op\");\nvar names = new Array(getLabel(\"Common.from.label\",\"Common\")+\" \"+visitDate,getLabel(\"Common.to.label\",\"Common\")+\" \"+visitDate);\nif(f_query_add_mod.checkFields( fields, names, messageFrame)) \n\t{\t\n\t\t \tif(validationonRun()){\n\n\n\t\t\t\tvar p_from_date\t\t\t\t= f_query_add_mod.document.reportInsWisePatStatsform.p_from_date.value;            \n\t\t\t\tvar p_to_date\t\t\t\t= f_query_add_mod.document.reportInsWisePatStatsform.p_to_date.value;              \n\t\t\t\tvar p_patient_class\t\t\t= f_query_add_mod.document.reportInsWisePatStatsform.p_patient_class.value;        \n\t\t\t\tvar p_fm_specialty_code\t\t= f_query_add_mod.document.reportInsWisePatStatsform.p_fm_specialty_code.value;        \n\t\t\t\tvar p_to_specialty_code\t\t= f_query_add_mod.document.reportInsWisePatStatsform.p_to_specialty_code.value;    \n\t\t\t\tvar p_fm_locn_code\t\t\t= f_query_add_mod.document.reportInsWisePatStatsform.p_fm_locn_code.value;         \n\t\t\t\tvar p_to_locn_code\t\t\t= f_query_add_mod.document.reportInsWisePatStatsform.p_to_locn_code.value;         \n\t\t\t\tvar p_fm_nursing_code\t\t= f_query_add_mod.document.reportInsWisePatStatsform.p_fm_nursing_code.value;      \n\t\t\t\tvar p_to_nursing_code\t\t= f_query_add_mod.document.reportInsWisePatStatsform.p_to_nursing_code.value;      \n\t\t\t\tvar p_from_pract_id\t\t\t= f_query_add_mod.document.reportInsWisePatStatsform.p_from_pract_id.value;        \n\t\t\t\tvar p_to_pract_id\t\t\t= f_query_add_mod.document.reportInsWisePatStatsform.p_to_pract_id.value;          \n\t\t\t\tvar p_from_bl_grp_id\t\t= f_query_add_mod.document.reportInsWisePatStatsform.p_from_bl_grp_id.value;       \n\t\t\t\tvar p_to_bl_grp_id\t\t\t= f_query_add_mod.document.reportInsWisePatStatsform.p_to_bl_grp_id.value;         \n\t\t\t\tvar p_from_cust_grp_code\t= f_query_add_mod.document.reportInsWisePatStatsform.p_from_cust_grp_code.value;   \n\t\t\t\tvar p_to_cust_grp_code\t\t= f_query_add_mod.document.reportInsWisePatStatsform.p_to_cust_grp_code.value;     \n\t\t\t\tvar p_from_cust_code\t\t= f_query_add_mod.document.reportInsWisePatStatsform.p_from_cust_code.value;   \n\t\t\t\tvar p_to_cust_code\t\t\t= f_query_add_mod.document.reportInsWisePatStatsform.p_to_cust_code.value;     \n\t\t\t\tvar p_policy_type_code\t\t= f_query_add_mod.document.reportInsWisePatStatsform.p_policy_type_code.value;     \n\t\t\t\tvar p_policy_number\t\t\t= f_query_add_mod.document.reportInsWisePatStatsform.p_policy_number.value; \n\t\t\t\tvar p_patient_id\t\t\t= f_query_add_mod.document.reportInsWisePatStatsform.p_patient_id.value;           \n\t\t\t\tvar p_order_by\t\t\t\t= f_query_add_mod.document.reportInsWisePatStatsform.p_order_by.value; \n\n\t\t\t\tvar p_facility_id\t\t\t= f_query_add_mod.document.reportInsWisePatStatsform.p_facility_id.value;     \n\t\t\t\tvar p_module_id\t\t\t\t= f_query_add_mod.document.reportInsWisePatStatsform.p_module_id.value;   \n\t\t\t\tvar p_report_id\t\t\t\t= f_query_add_mod.document.reportInsWisePatStatsform.p_report_id.value;     \n\t\t\t\tvar p_user_name\t\t\t\t= f_query_add_mod.document.reportInsWisePatStatsform.p_user_name.value;     \n\t\t\t\tvar p_function_id\t\t\t= f_query_add_mod.document.reportInsWisePatStatsform.p_function_id.value; \n\t\t\t\tvar p_function_name\t\t\t= f_query_add_mod.document.reportInsWisePatStatsform.p_function_name.value;           \n\t\t\t\tvar p_function_type\t\t\t= f_query_add_mod.document.reportInsWisePatStatsform.p_function_type.value; \n\n\t\t\t\tf_query_add_mod.document.reportInsWisePatStatsform.method\t= \'POST\';\n\t\t\t\tf_query_add_mod.document.reportInsWisePatStatsform.action\t= \'../../eCommon/jsp/report_options.jsp?p_from_date=\'+p_from_date+\'&p_to_date=\'+p_to_date+\'&p_patient_class=\'+p_patient_class+\'&p_fm_specialty_code=\'+p_fm_specialty_code+\'&p_to_specialty_code=\'+p_to_specialty_code+\'&p_fm_locn_code=\'+p_fm_locn_code+\'&p_to_locn_code=\'+p_to_locn_code+\'&p_fm_nursing_code=\'+p_fm_nursing_code+\'&p_to_nursing_code=\'+p_to_nursing_code+\'&p_from_pract_id=\'+p_from_pract_id+\'&p_to_pract_id=\'+p_to_pract_id+\'&p_from_bl_grp_id=\'+p_from_bl_grp_id+\'&p_to_bl_grp_id=\'+p_to_bl_grp_id+\'&p_from_cust_grp_code=\'+p_from_cust_grp_code+\'&p_to_cust_grp_code=\'+p_to_cust_grp_code+\'&p_from_cust_code=\'+p_from_cust_code+\'&p_to_cust_code=\'+p_to_cust_code+\'&p_policy_type_code=\'+p_policy_type_code+\'&p_policy_number=\'+p_policy_number+\'&p_patient_id=\'+p_patient_id+\'&p_order_by=\'+p_order_by+\'&p_facility_id=\'+p_facility_id+\'&p_module_id=\'+p_module_id+\'&p_report_id=\'+p_report_id+\'&p_user_name=\'+p_user_name+\'&p_function_id\t=\'+p_function_id+\'&p_function_name=\'+p_function_name+\'&p_function_type=\'+p_function_type+\'\';\t\n\t\t\t\tf_query_add_mod.document.reportInsWisePatStatsform.submit() ;\n\t\t\t}\n\t}\n}\nfunction chkGrtr(obj1,obj2)\n{\n\t\t\n\t\tif(isBefore(obj1.value,obj2.value,\"DMYHM\",localeName)==false)\n\t\t{\n\t\t\tvar error=getMessage(\"TO_DT_GR_EQ_FM_DT\",\"SM\");\n\t\t\tmessageFrame.location.href = \"../../eCommon/jsp/error.jsp?err_num=\"+error ;\n            return false;\n\t\t}\n\t\telse \n\t\t\treturn true;\n}\n\nfunction validationonRun(){\nif(chkGrtr(f_query_add_mod.document.reportInsWisePatStatsform.p_from_date,\n\t\t\t\tf_query_add_mod.document.reportInsWisePatStatsform.p_to_date)==true)\n\t\t\t{\n\t\t\t if(f_query_add_mod.CheckString(getLabel(\"Common.speciality.label\",\"Common\")+\" \"+getLabel(\"Common.code.label\",\"Common\"),f_query_add_mod.document.forms[0].p_fm_specialty_code,f_query_add_mod.document.forms[0].p_to_specialty_code,messageFrame))\n\t\t\t if(f_query_add_mod.CheckString(getLabel(\"Common.locationcode.label\",\"Common\"),f_query_add_mod.document.forms[0].p_fm_locn_code,f_query_add_mod.document.forms[0].p_to_locn_code,messageFrame))\n\t\t\t if(f_query_add_mod.CheckString(getLabel(\"Common.NursingUnitCode.label\",\"Common\"),f_query_add_mod.document.forms[0].p_fm_nursing_code,f_query_add_mod.document.forms[0].p_to_nursing_code,messageFrame))\n\t\t\t if(f_query_add_mod.CheckString(getLabel(\"Common.practitionerid.label\",\"Common\"),f_query_add_mod.document.forms[0].p_from_pract_id,f_query_add_mod.document.forms[0].p_to_pract_id,messageFrame))\n\t\t\t if(f_query_add_mod.CheckString(getLabel(\"Common.BillingGroup.label\",\"Common\"),f_query_add_mod.document.forms[0].p_from_bl_grp_id,f_query_add_mod.document.forms[0].p_to_bl_grp_id,messageFrame))\n\t\t\t if(f_query_add_mod.CheckString(getLabel(\"Common.BillingGroup.label\",\"Common\"),f_query_add_mod.document.forms[0].p_from_bl_grp_id,f_query_add_mod.document.forms[0].p_to_bl_grp_id,messageFrame))\n\t\t\t if(f_query_add_mod.CheckString(getLabel(\"Common.Customer.label\",\"Common\")+\" \"+getLabel(\"Common.GroupCode.label\",\"Common\"),f_query_add_mod.document.forms[0].p_from_cust_grp_code,f_query_add_mod.document.forms[0].p_to_cust_grp_code,messageFrame))\n\t\t\t if(f_query_add_mod.CheckString(getLabel(\"Common.CustomerCode.label\",\"Common\"),f_query_add_mod.document.forms[0].p_from_cust_code,f_query_add_mod.document.forms[0].p_to_cust_code,messageFrame))\n\n\t\t\t \treturn true;\n\t\t\t}else{\n\t\t\t\treturn false;\n\t\t\t}\n\n}\n</script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\'\tsrc=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" frameborder=0 scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' \t\tsrc=\'../../eOP/jsp/repInsurWisePatStats.jsp\' frameborder=0 style=\'height:80vh;width:100vw\'></iframe>\n\t<iframe name=\'messageFrame\' id=\'messageFrame\'\t\tsrc=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:12vh;width:100vw\'></iframe>\n\t<iframe name=\'dummyframe\' id=\'dummyframe\'\t\tsrc=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize  style=\'height:0vh;width:100vw\'></iframe>\n\n";
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
