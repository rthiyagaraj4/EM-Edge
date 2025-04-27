package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __setupparameterforfacilityhiddenform extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/SetUpParameterForFacilityHiddenForm.jsp", 1709120350000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n\t<script language=\'javascript\' src=\'../../eOT/js/SetUpParameterForFacility.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\"SetUpParameterForFacilityHiddenForm\" id=\"SetUpParameterForFacilityHiddenForm\"  action=\"../../servlet/eOT.SetUpParameterForFacilityServlet\" method=\"post\" target=\"messageFrame\"> \n\n\t<input type=\'hidden\' name=\"OPERATING_FACILITY_ID\" id=\"OPERATING_FACILITY_ID\"          value=\"\">\n\t<input type=\'hidden\' name=\"BOOKING_NUM_YEAR\" id=\"BOOKING_NUM_YEAR\"               value=\"\">\n\t<input type=\'hidden\' name=\"NEXT_BOOKING_NUM\" id=\"NEXT_BOOKING_NUM\"               value=\"\">\n\t<input type=\'hidden\' name=\"MAX_BOOKING_NUM\" id=\"MAX_BOOKING_NUM\"                value=\"\">\n\t<input type=\'hidden\' name=\"UNIT_OT_TIME\" id=\"UNIT_OT_TIME\"                   value=\"\">\n\t<input type=\'hidden\' name=\"START_OT_BOOKING_TIME\" id=\"START_OT_BOOKING_TIME\"          value=\"\">\n\t<input type=\'hidden\' name=\"END_OT_BOOKING_TIME\" id=\"END_OT_BOOKING_TIME\"            value=\"\">\n\t<input type=\'hidden\' name=\"START_HOL_BOOK_TIME\" id=\"START_HOL_BOOK_TIME\"            value=\"\">\n\t<input type=\'hidden\' name=\"END_HOL_BOOK_TIME\" id=\"END_HOL_BOOK_TIME\"              value=\"\">\n\t<input type=\'hidden\' name=\"OPER_NUM_DATE_IP\" id=\"OPER_NUM_DATE_IP\"               value=\"\">\n\t<input type=\'hidden\' name=\"OPER_NUM_DATE_OP\" id=\"OPER_NUM_DATE_OP\"               value=\"\">\n\t<input type=\'hidden\' name=\"NEXT_OPER_NUM_IP\" id=\"NEXT_OPER_NUM_IP\"               value=\"\">\n\t<input type=\'hidden\' name=\"MAX_OPER_NUM_IP\" id=\"MAX_OPER_NUM_IP\"                value=\"\">\n\t<input type=\'hidden\' name=\"NEXT_OPER_NUM_OP\" id=\"NEXT_OPER_NUM_OP\"               value=\"\">\n\t<input type=\'hidden\' name=\"MAX_OPER_NUM_OP\" id=\"MAX_OPER_NUM_OP\"                value=\"\">\n\t<input type=\'hidden\' name=\"OT_SEC1_NOTICE_FM_TIME\" id=\"OT_SEC1_NOTICE_FM_TIME\"         value=\"\">\n\t<input type=\'hidden\' name=\"OT_SEC1_NOTICE_TO_TIME\" id=\"OT_SEC1_NOTICE_TO_TIME\"         value=\"\">\n\t<input type=\'hidden\' name=\"OT_SEC2_NOTICE_FM_TIME\" id=\"OT_SEC2_NOTICE_FM_TIME\"         value=\"\">\n\t<input type=\'hidden\' name=\"OT_SEC2_NOTICE_TO_TIME\" id=\"OT_SEC2_NOTICE_TO_TIME\"         value=\"\">\n\t<input type=\'hidden\' name=\"OT_SEC3_NOTICE_FM_TIME\" id=\"OT_SEC3_NOTICE_FM_TIME\"         value=\"\">\n\t<input type=\'hidden\' name=\"OT_SEC3_NOTICE_TO_TIME\" id=\"OT_SEC3_NOTICE_TO_TIME\"         value=\"\">\n\t<input type=\'hidden\' name=\"LAST_STK_UPDATED_DATE\" id=\"LAST_STK_UPDATED_DATE\"          value=\"\">\n\t<input type=\'hidden\' name=\"BL_INTERFACE_FLAG\" id=\"BL_INTERFACE_FLAG\"              value=\"\">\n\t<input type=\'hidden\' name=\"DEF_ST_STORE\" id=\"DEF_ST_STORE\"                   value=\"\">\n\t<input type=\'hidden\' name=\"ST_DOC_TYPE_SLI\" id=\"ST_DOC_TYPE_SLI\"                value=\"\">\n\t<input type=\'hidden\' name=\"ST_DOC_TYPE_SLO\" id=\"ST_DOC_TYPE_SLO\"                value=\"\">\n\t<input type=\'hidden\' name=\"ST_DOC_TYPE_SLR\" id=\"ST_DOC_TYPE_SLR\"                value=\"\">\n\t<input type=\'hidden\' name=\"ST_DOC_TYPE_RTI\" id=\"ST_DOC_TYPE_RTI\"                value=\"\">\n\t<input type=\'hidden\' name=\"ST_DOC_TYPE_RTO\" id=\"ST_DOC_TYPE_RTO\"                value=\"\">\n\t<input type=\'hidden\' name=\"ST_DOC_TYPE_RTR\" id=\"ST_DOC_TYPE_RTR\"                value=\"\">\n\t<input type=\'hidden\' name=\"ST_INTERFACE_FLAG\" id=\"ST_INTERFACE_FLAG\"              value=\"\">\n\t<input type=\'hidden\' name=\"WAIT_LIST_NUM_YEAR\" id=\"WAIT_LIST_NUM_YEAR\"             value=\"\">\n\t<input type=\'hidden\' name=\"NEXT_WAITLIST_NUM\" id=\"NEXT_WAITLIST_NUM\"              value=\"\">\n\t<input type=\'hidden\' name=\"MAX_WAITLIST_NUM\" id=\"MAX_WAITLIST_NUM\"               value=\"\">\n\t<input type=\'hidden\' name=\"PRINT_BOOKING_SLIP\" id=\"PRINT_BOOKING_SLIP\"             value=\"\">\n\t<input type=\'hidden\' name=\"CSSD_INTERFACE_YN\" id=\"CSSD_INTERFACE_YN\"              value=\"\">\n\t<input type=\'hidden\' name=\"SS_DCO_TYPE_CODE\" id=\"SS_DCO_TYPE_CODE\"               value=\"\">\n\t<input type=\'hidden\' name=\"INV_DOC_TYPE\" id=\"INV_DOC_TYPE\"                   value=\"\">\n\t<input type=\'hidden\' name=\"MED_SER_GRP_CODE\" id=\"MED_SER_GRP_CODE\"               value=\"\">\n\t<input type=\'hidden\' name=\"CSSD_STORE_CODE\" id=\"CSSD_STORE_CODE\"                value=\"\">\n\t<input type=\'hidden\' name=\"SEC_TASKS_PORTER_TRFR_IN\" id=\"SEC_TASKS_PORTER_TRFR_IN\"       value=\"\">\n\t<input type=\'hidden\' name=\"SEC_TASKS_PORTER_TRFR_OUT\" id=\"SEC_TASKS_PORTER_TRFR_OUT\"      value=\"\">\n\t<input type=\'hidden\' name=\"CHECKLIST_ALERT_TYPE\" id=\"CHECKLIST_ALERT_TYPE\"           value=\"\">\n\t<input type=\'hidden\' name=\"PAC_REVIEW_ORDERABLE\" id=\"PAC_REVIEW_ORDERABLE\"           value=\"\">\n\t<input type=\'hidden\' name=\"WARN_LIMIT_WAITLIST_DAYS\" id=\"WARN_LIMIT_WAITLIST_DAYS\"       value=\"\">\n\t<input type=\'hidden\' name=\"WARN_UNSCHEDULED_CASES_ONLY\" id=\"WARN_UNSCHEDULED_CASES_ONLY\"    value=\"\">\n\t<input type=\'hidden\' name=\"BIOMET_CHK_ON_PAT_CHK_IN_TO_OT\" id=\"BIOMET_CHK_ON_PAT_CHK_IN_TO_OT\" value=\"\">\n\t<input type=\'hidden\' name=\"IPBOOKING_WITH_THEATRE_YN\" id=\"IPBOOKING_WITH_THEATRE_YN\"      value=\"\">\n\t<input type=\'hidden\' name=\"BKG_FIN_ALERT_FOR_OP\" id=\"BKG_FIN_ALERT_FOR_OP\"           value=\"\">\n\t<input type=\'hidden\' name=\"BKG_FIN_ALERT_FOR_EM\" id=\"BKG_FIN_ALERT_FOR_EM\"           value=\"\">\n\t<input type=\'hidden\' name=\"CHK_SURGEON_DOC_CMPL_FOR_STS\" id=\"CHK_SURGEON_DOC_CMPL_FOR_STS\"   value=\"\">\n\t<input type=\'hidden\' name=\"CHK_NURSING_DOC_CMPL_FOR_STS\" id=\"CHK_NURSING_DOC_CMPL_FOR_STS\"   value=\"\">\n\t<input type=\'hidden\' name=\"CHK_INTRA_DOC_CMPL_FOR_STS\" id=\"CHK_INTRA_DOC_CMPL_FOR_STS\"     value=\"\">\n\t<input type=\'hidden\' name=\"DISP_LAST_ANTIB_PREOP_YN\" id=\"DISP_LAST_ANTIB_PREOP_YN\"       value=\"\">\n\t<input type=\'hidden\' name=\"NO_OF_SWAB_COUNT_REQD\" id=\"NO_OF_SWAB_COUNT_REQD\"          value=\"\">\n </form>\n</body>\n </html>\n\n\n\n";
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
 String locale = (String)session.getAttribute("LOCALE"); 
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
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
