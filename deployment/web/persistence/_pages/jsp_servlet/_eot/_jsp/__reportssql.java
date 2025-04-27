package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __reportssql extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/reportssql.jsp", 1709117280000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\nNotifListByOTWardReport.jsp\n\tString  sql_speciality = \"SELECT A.SPECIALITY_CODE CODE, B.SHORT_DESC DESCRIPTION FROM OT_SPECIALITIES A,  AM_SPECIALITY B WHERE A.SPECIALITY_CODE =  B.SPECIALITY_CODE AND UPPER(B.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.SPECIALITY_CODE) LIKE UPPER(?) ORDER BY 2\";\n\t//Code altered by Selvam for PHASE 3 Delivery\n\t//String  sql_ward = \"SELECT A.NURSING_UNIT_CODE CODE, A.SHORT_DESC DESCRIPTION FROM IP_NURSING_UNIT_LANG_VW A WHERE A.LANGUAGE_ID=\'\"+locale+\"\' AND FACILITY_ID = \'\"+facility_id+\"\' AND UPPER(A.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.NURSING_UNIT_CODE) LIKE UPPER(?) ORDER BY 2\";\n\tString  sql_ward = \"SELECT A.NURSING_UNIT_CODE CODE, A.LONG_DESC DESCRIPTION FROM IP_NURSING_UNIT_LANG_VW A WHERE A.LANGUAGE_ID=\'\"+locale+\"\' AND FACILITY_ID = \'\"+facility_id+\"\' AND UPPER(A.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.NURSING_UNIT_CODE) LIKE UPPER(?) ORDER BY 2\";\n\t//String  sql_oper_room = \"SELECT A.OPER_ROOM_CODE CODE, A.SHORT_DESC DESCRIPTION FROM OT_OPER_ROOM A WHERE OPERATING_FACILITY_ID = \'\"+facility_id+\"\' AND UPPER(A.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.OPER_ROOM_CODE) LIKE UPPER(?) ORDER BY 2\";\n\t//String  sql_oper_room = \"SELECT A.OPER_ROOM_CODE CODE, A.SHORT_DESC DESCRIPTION FROM OT_OPER_ROOM_LANG_VW A WHERE LANGUAGE_ID=\'\"+locale+\"\' AND OPERATING_FACILITY_ID = \'\"+facility_id+\"\' AND UPPER(A.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.OPER_ROOM_CODE) LIKE UPPER(?) ORDER BY 2\";\n\tString  sql_surgeon = \"SELECT PHYSICIAN_ID CODE, SHORT_NAME DESCRIPTION FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID = \'\"+facility_id+\"\' AND PRACT_TYPE IN (\'MD\', \'SG\') AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PHYSICIAN_ID) LIKE UPPER(?) ORDER BY 2\";\n\t//String sql_surgery_type = \"SELECT NATURE_CODE, SHORT_DESC FROM OT_NATURE_OF_SURGERY ORDER BY 2\";\n\tString sql_surgery_type = \"SELECT NATURE_CODE, SHORT_DESC FROM OT_NATURE_OF_SURGERY_LANG_VW WHERE LANGUAGE_ID=\'\"+locale+\"\' ORDER BY 2\";\n\n\tTheatreBookingsByOtRoomReports.jsp\n\n\tString  sql_speciality = \"SELECT A.SPECIALITY_CODE CODE, B.SHORT_DESC DESCRIPTION FROM OT_SPECIALITIES A,  AM_SPECIALITY B WHERE A.SPECIALITY_CODE =  B.SPECIALITY_CODE AND UPPER(B.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.SPECIALITY_CODE) LIKE UPPER(?) ORDER BY 2\";\n\t//String  sql_oper_room = \"SELECT OPER_ROOM_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_ROOM WHERE OPERATING_FACILITY_ID = \'\"+facility_id+\"\' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_ROOM_CODE) LIKE UPPER(?) ORDER BY 2\";\n\tString  sql_oper_room = \"SELECT OPER_ROOM_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID=\'\"+locale+\"\' AND OPERATING_FACILITY_ID = \'\"+facility_id+\"\' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_ROOM_CODE) LIKE UPPER(?) ORDER BY 2\";\n\tString  sql_surgeon = \"SELECT PHYSICIAN_ID CODE, SHORT_NAME DESCRIPTION FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID = \'\"+facility_id+\"\' AND PRACT_TYPE IN (\'MD\', \'SG\') AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PHYSICIAN_ID) LIKE UPPER(?) ORDER BY 2\";\n\t//Code altered by Selvam for PHASE 3 Delivery\n\t//String  sql_ward = \"SELECT NURSING_UNIT_CODE CODE, SHORT_DESC DESCRIPTION FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID=\'\"+locale+\"\' AND FACILITY_ID = \'\"+facility_id+\"\' AND  UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(NURSING_UNIT_CODE) LIKE UPPER(?) ORDER BY 2\";\n\tString  sql_ward = \"SELECT NURSING_UNIT_CODE CODE, LONG_DESC DESCRIPTION FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID=\'\"+locale+\"\' AND FACILITY_ID = \'\"+facility_id+\"\' AND  UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(NURSING_UNIT_CODE) LIKE UPPER(?) ORDER BY 2\";\n\n\tTheatreBookingsBySurgeonReoprts.jsp\n\n\tString  sql_speciality = \"SELECT A.SPECIALITY_CODE CODE, B.SHORT_DESC DESCRIPTION FROM OT_SPECIALITIES A,  AM_SPECIALITY B WHERE A.SPECIALITY_CODE =  B.SPECIALITY_CODE AND UPPER(B.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.SPECIALITY_CODE) LIKE UPPER(?) ORDER BY 2\";\n\tString  sql_oper_procedure = \"SELECT OPER_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_MAST WHERE UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_CODE) LIKE UPPER(?) ORDER BY 2\";\n\tString  sql_surgeon = \"SELECT PHYSICIAN_ID CODE, SHORT_NAME DESCRIPTION FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID = \'\"+facility_id+\"\' AND PRACT_TYPE IN (\'MD\', \'SG\') AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PHYSICIAN_ID) LIKE UPPER(?) ORDER BY 2\";\n\n\tPatientsToBEAdmittedForOperReports.jsp\n\n\tString surgery_date = \"\";\n\tif(facility_id == null) facility_id=\"\";\n\tString  sql_speciality = \"SELECT A.SPECIALITY_CODE CODE, B.SHORT_DESC DESCRIPTION FROM OT_SPECIALITIES A,  AM_SPECIALITY B WHERE A.SPECIALITY_CODE =  B.SPECIALITY_CODE AND UPPER(B.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.SPECIALITY_CODE) LIKE UPPER(?) ORDER BY 2\";\n\n\tString  sql_surgeon = \"SELECT PHYSICIAN_ID CODE, SHORT_NAME DESCRIPTION FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID = \'\"+facility_id+\"\' AND PRACT_TYPE IN (\'MD\', \'SG\') AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PHYSICIAN_ID) LIKE UPPER(?) ORDER BY 2\";\n\n\t//String  sql_oper_room = \"SELECT OPER_ROOM_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_ROOM WHERE OPERATING_FACILITY_ID = \'\"+facility_id+\"\' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_ROOM_CODE) LIKE UPPER(?) ORDER BY 2\";\n\n\tString  sql_oper_room = \"SELECT OPER_ROOM_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID=\'\"+locale+\"\' AND OPERATING_FACILITY_ID = \'\"+facility_id+\"\' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_ROOM_CODE) LIKE UPPER(?) ORDER BY 2\";\n\n\tWaitlistReports.jsp\n\n\tString  sql_oper_procedure = \"SELECT OPER_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_MAST WHERE UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_CODE) LIKE UPPER(?) ORDER BY 2\";\n\n\tString  sql_speciality = \"SELECT A.SPECIALITY_CODE CODE, B.SHORT_DESC DESCRIPTION FROM OT_SPECIALITIES A,  AM_SPECIALITY B WHERE A.SPECIALITY_CODE =  B.SPECIALITY_CODE AND UPPER(B.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.SPECIALITY_CODE) LIKE UPPER(?) ORDER BY 2\";\n\n\tString  sql_surgeon = \"SELECT PHYSICIAN_ID CODE, SHORT_NAME DESCRIPTION FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID = \'\"+facility_id+\"\' AND PRACT_TYPE IN (\'MD\', \'SG\') AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PHYSICIAN_ID) LIKE UPPER(?) ORDER BY 2\";\n\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

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
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
