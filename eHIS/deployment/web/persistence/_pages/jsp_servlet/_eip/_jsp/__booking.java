package jsp_servlet._eip._jsp;

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
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __booking extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/Booking.jsp", 1737455169028L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n <!--\n\tThis is the main booking page.\n\tFrom this page create booking,revise booing and confirm bookings are called\n-->\n";
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\t\t\n\t<script src=\'../../eIP/js/Booking1.js\' language=\'javascript\'></script>\n\t<script src=\'../../eIP/js/Booking.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\talert(getMessage(\'IP_NO_OPER_STN_FOR_USER\',\'IP\'));\n\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' != \'IP\'){\n\t\t\t\t\t\t//location.href=\'../../eCommon/jsp/home.jsp?called_from=CA\';\n\t\t\t\t\t\twindow.close();\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\tdocument.location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t\t\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t<title>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</title>\n\t\t\t\t<script language=\'javascript\' src=\'../../eIP/js/Booking.js\'></script>\n\t\t\t\t<script language=\'javascript\' src=\'../../eIP/js/Booking1.js\'></script>\n\t\t\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" frameborder=0 scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\t\t\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' \t src=\"../../eIP/jsp/AddModifyBooking.jsp?chk_booking_limit_by=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&multi_book_pat_yn=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&block_bed_based_on=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&is_oa_yn=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&call_function=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&oa_wait_ref_no=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&oa_pref_date_time=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&oa_patient_id=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&oper_stn_id=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&Patient_Id=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&medical_service=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&booking_date_time=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&allowed_booking_type=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&unregistered_patients_bkg_yn=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&medical_speciality_desc=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&medical_speciality_code=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&physician_desc=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&physician_code=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&oper_room_code=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&oper_room_desc=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&patient_class=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&bl_interfaced_yn=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&capture_fin_dtls_yn=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&nursing_unit_code=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="&nursing_unit_desc=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&deactivate_pseudo_bed_yn=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&create_booking_with_conf_yn=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="&sqlsd2=";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&bkg_grace_period=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="&PreOpPreparationDays=";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" frameborder=0 style=\'vertical-scroll-bar:yes;height:80vh;width:100vw\'></iframe>\n\t\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' \t src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:11vh;width:100vw\'></iframe>\n\t\t\t\t<iframe name=\'dummyFrame\' id=\'dummyFrame\' \t src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:1vh;width:100vw\'></iframe>\t\n\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\talert(getMessage(\'NURS_UNIT_NOT_DEFINED\',\'IP\'));\n\t\t\t\t\t\t\tdocument.location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t\t\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t\t<title>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</title>\n\t\t\t\t\t\t\t\t<script language=\'javascript\' src=\'../js/Booking.js\'></script>\n\t\t\t\t\t\t\t\t<script language=\'javascript\' src=\'../js/Booking1.js\'></script>\n\t\t\t\t\t\t\t\t<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n\t\t\t\t\t\t\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" frameborder=0 scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' \t src=\'../../eIP/jsp/AddModifyBooking.jsp?chk_booking_limit_by=";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="&is_op_pending_referral_booking=";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="&referral_id=";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' frameborder=0 style=\'vertical-scroll-bar:yes;height:80vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' \t src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:10vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t\t<iframe name=\'dummyFrame\' id=\'dummyFrame\' \t src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:1vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t\t\t<script>alert(getMessage(\'OPER_STN_FUNC_RESTRN\',\'IP\'))</script>\n\t\t\t\t\t\t\t\t<script>document.location.href =\'../../eCommon/jsp/dmenu.jsp\'</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\t\n\t\t\t\t\t\t\t\t<title>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</title>\n\t\t\t\t\t\t\t\t<script language=\'javascript\' src=\'../js/ReviseBooking.js\'></script> \n\t\t\t\t\t\t\t\t<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script> \n\t\t\t\t\t\t\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\t\t\n\t\t\t\t\t\t\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\'  frameborder=0 scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' src=\'../jsp/AddModifyReviseBooking.jsp?function_id=AMEND_BOOKING&bkg_lst_ref_no=";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="&chk_booking_limit_by=";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' frameborder=0 style=\'vertical-scroll-bar:yes;height:80vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' \t  src=\'../jsp/ReviseBookingerror.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:10vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t\t<iframe name=\'dummyFrame\' id=\'dummyFrame\' \t src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:0vh;width:100vw\'></iframe>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</title>\n\t\t\t\t\t\t\t\t<script language=\'javascript\' src=\'../js/ConfirmBooking.js\'></script>        \n\t\t\t\t\t\t\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' frameborder=0 scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' \t src=\'../jsp/AddModifyConfirmBooking.jsp?chk_booking_limit_by=";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="&bkg_lst_ref_no=";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' frameborder=0 scrolling=\'yes\' scrolling=\'auto\' style=\'height:80vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' \t src=\'../jsp/ReviseBookingerror.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:10vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\t\t<iframe name=\'dummyFrame\' id=\'dummyFrame\' \t src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:0vh;width:100vw\'></iframe>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t<title>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</title>\n\t\t\t\t\t\t<script language=\'javascript\' src=\'../../eIP/js/Booking.js\'></script>\n\t\t\t\t\t\t<script language=\'javascript\' src=\'../../eIP/js/Booking1.js\'></script>\n\t\t\t\t\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =" frameborder=0 scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\t\t\t\t\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' \t src=\'../../eIP/jsp/AddModifyBooking.jsp?chk_booking_limit_by=";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="&is_ca_yn=";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="&ca_patient_id=";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="&block_bed_based_on";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' frameborder=0  style=\'vertical-scroll-bar:yes;height:80vh;width:100vw\'></iframe>\n\t\t\t\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' \t src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:10vh;width:100vw\'></iframe>\n\t\t\t\t\t\t<iframe name=\'dummyFrame\' id=\'dummyFrame\' \t src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:1vh;width:100vw\'></iframe>\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</title>\n\t\t\t\t\t\t<script language=\'javascript\' src=\'../../eIP/js/Booking.js\'></script>\n\t\t\t\t\t\t<script language=\'javascript\' src=\'../../eIP/js/Booking1.js\'></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t\t\t\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =" frameborder=0 scrolling=\'no\' noresize style=\'height:12vh;width:100vw\'></iframe>\n\t\t\t\t\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' \t src=\'../../eIP/jsp/AddModifyBooking.jsp?chk_booking_limit_by=";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' frameborder=0  style=\'vertical-scroll-bar:yes;height:80vh;width:100vw\'></iframe>\n\t\t\t\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' \t src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:10vh;width:100vw\'></iframe>\n\t\t\t\t\t\t<iframe name=\'dummyFrame\' id=\'dummyFrame\' \t src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:1vh;width:100vw\'></iframe>\t\n\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\talert(getMessage(\'OPER_STN_FUNC_RESTRN\',\'IP\'));\n\t\t\t\t\t\tdocument.location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t\t\t\t\t\t//window.parent.close();\n\t\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t<script>\n\t\t\t\talert(getMessage(\'IP_PARAM_NOT_FOUND\',\'IP\'));\n\t\t\t\tdocument.location.href =\'../../eCommon/jsp/dmenu.jsp\';\n\t\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t<script>\n\t\t\t\talert(getMessage(\'IP_PARAM_NOT_FOUND\',\'IP\'));\n\t\t\t\tdocument.location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t\t\t\t//window.parent.close();\n\t\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n</html>\n\n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
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

	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String  facilityId			= (String)session.getAttribute("facility_id");
	String  loginUser			= (String)session.getAttribute("login_user");
	String  bkg_lst_ref_no		= checkForNull(request.getParameter("bkg_lst_ref_no"));
	String  is_ca_yn			= checkForNull(request.getParameter("is_ca_yn"));
	String  ca_patient_id		= checkForNull(request.getParameter("ca_patient_id"));
	String  oa_patient_id		= checkForNull(request.getParameter("oa_patient_id"));
	String	callFrom			= checkForNull(request.getParameter("callFrom"));
	String  wating_ref_no		= checkForNull(request.getParameter("wait_lst_ref_no"));
	String  pref_date_time		= checkForNull(request.getParameter("oa_pref_date_time"));
	String  is_oa_yn			= checkForNull(request.getParameter("is_oa_yn"));
	String	oper_stn_id			= checkForNull(request.getParameter("oper_stn_id"));
	String  revise_booking_yn	= checkForNull(request.getParameter("revise_booking_yn"));
	String  Confirm_booking_yn	= checkForNull(request.getParameter("confirm_booking_yn"));
	String  cr_boook_conf_yn	= checkForNull(request.getParameter("create_booking_with_conf_yn"),"N");
	String  create_booking_yn	= checkForNull(request.getParameter("create_booking_yn"));
    String  call_func			= checkForNull(request.getParameter("call_func"));
	String  referral_ID			= checkForNull(request.getParameter("referral_id"));
	String  menu_id  			= checkForNull(request.getParameter("menu_id"));
	String	is_op_pending_referral_booking = "N";
	String	params						= "";
	String	source						= "";
	String	url							= " ";
	String  Patient_Id					= "";
	String  booking_date_time			= "";
	String  call_function				= "";
	String  chk_booking_limit_by		= "";
	String  medical_service				= "";
	String  medical_speciality_code		= "";
	String  medical_speciality_desc		= "";
	String  physician_code				= "";
	String  physician_desc				= "";
	String  unregistered_patients_bkg_yn= "";
	String bl_interfaced_yn				= "";
	String capture_fin_dtls_yn			= "";
	boolean result 						= true;
	boolean flag						= false;	
    String  allowed_booking_type		= "";
    String  multi_book_pat_yn			= "N";
    String  block_bed_based_on			= "P";
	String oper_room_code				= "";
	String patient_class				= "";
	String oper_room_desc				= "";
	String nursing_unit_code			= "";
	String nursing_unit_desc			= "";
	String deactivate_pseudo_bed_yn		= "N";
	String sysdate						= "";
	String bkg_grace_period				= "";
	String PreOpPreparationDays			= "";

	if(call_func.equals("OT"))
	{
		Patient_Id				= checkForNull(request.getParameter("Patient_Id"));
		medical_service			= checkForNull(request.getParameter("medical_service"));
		booking_date_time		= checkForNull(request.getParameter("booking_date_time"));
		if(booking_date_time!=null && !booking_date_time.equals(""))
			booking_date_time = DateUtils.convertDate(booking_date_time,"DMYHM",localeName,"en");
		medical_speciality_desc	= checkForNull(request.getParameter("medical_speciality_desc"));
		medical_speciality_code	= checkForNull(request.getParameter("medical_speciality_code"));
		physician_desc			= checkForNull(request.getParameter("physician_desc"));
		
		physician_code			= checkForNull(request.getParameter("physician_code"));
		oper_room_code			= checkForNull(request.getParameter("oper_room_code"));
		patient_class			= checkForNull(request.getParameter("patient_class"));
		oper_room_desc			= checkForNull(request.getParameter("oper_room_desc"));

		nursing_unit_code		= checkForNull(request.getParameter("nursing_unit_code"));
		nursing_unit_desc		= checkForNull(request.getParameter("nursing_unit_desc"));
		PreOpPreparationDays	= checkForNull(request.getParameter("PreOpPreparationDays"));
	}
// example data
/*
call_func = "OT";
Patient_Id = "0000010013";
medical_speciality_desc= "Gen Med's";
medical_speciality_code = "01";
physician_desc ="Nanda Kumar";
physician_code ="NANDA";
booking_date_time = "25/10/2007 10:36";
*/

	if(call_func.equals("OP_Pending_Referral_Booking"))
		is_op_pending_referral_booking = "Y";

	if((!ca_patient_id.equals("")) && is_ca_yn.equals("Y"))
		call_function = "CA_Task_IP_Booking";
	else if((ca_patient_id.equals("")) && is_ca_yn.equals("Y"))
	      call_function = "CA_Clinician_IP_Booking";
	else if(is_oa_yn.equals("Y"))
		  call_function = "OA_IP_Booking";
	else 
		call_function = "IP_Booking";
	
	if(is_ca_yn.equals("") && is_oa_yn.equals(""))	
	{
		url	= "../../eCommon/jsp/commonToolbar.jsp?" ;
		params = request.getQueryString() ;
		source = url + params ;
	}
	else
	{
		 url	= "../../eCommon/jsp/commonToolbar.jsp?home_required_yn=N&module_id=IP&function_id=BOOKING&function_name=Create%20Booking&function_type=F&access=NYNNN";
		 params = request.getQueryString() ;
		 source = url + params ;
	}

	Connection	con		= null;
	ResultSet	rs		= null; 
	Statement	stmt	= null;
	ResultSet	rs1		= null; 
	ResultSet	rset	= null; 
	Statement	stmt1	= null;
	
	try
	{
		con		= ConnectionManager.getConnection(request);		
		stmt	= con.createStatement();		
		rs		= stmt.executeQuery(" select 1, allowed_booking_type, unregistered_patients_bkg_yn, chk_booking_limit_by, multi_book_pat_yn, bl_interfaced_yn, capture_fin_dtls_yn, block_bed_based_on,deactivate_pseudo_bed_yn,to_char(sysdate,'dd/mm/rrrr hh24:mi') sdate,bkg_grace_period from IP_PARAM where facility_id='"+facilityId+"' ");

		if(rs.next())
		{       
			multi_book_pat_yn			= checkForNull(rs.getString("multi_book_pat_yn"),"N");
			allowed_booking_type		= rs.getString("allowed_booking_type");
			chk_booking_limit_by		= rs.getString("chk_booking_limit_by");
			bl_interfaced_yn			= checkForNull(rs.getString("BL_INTERFACED_YN"));
			capture_fin_dtls_yn			= checkForNull(rs.getString("CAPTURE_FIN_DTLS_YN"));
			block_bed_based_on			= checkForNull(rs.getString("block_bed_based_on"),"P");
			unregistered_patients_bkg_yn= checkForNull(rs.getString("unregistered_patients_bkg_yn"));  
			deactivate_pseudo_bed_yn    = checkForNull(rs.getString("deactivate_pseudo_bed_yn"),"N");  
			sysdate						= checkForNull(rs.getString("sdate"));
			bkg_grace_period			= checkForNull(rs.getString("bkg_grace_period"));

			if( !(callFrom.equals("Revise") || callFrom.equals("Confirm")) )
			{
				StringBuffer operSql = new StringBuffer();
				operSql.append("SELECT a.oper_stn_id OPER_STN_ID, a.create_booking_yn, a.create_booking_with_conf_yn, a.revise_booking_yn, a.confirm_booking_yn FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='");
				operSql.append(facilityId);	
				operSql.append("' AND a.facility_id = b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='");
				operSql.append(loginUser);
				operSql.append("' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))");
				stmt1 = con.createStatement();
				rs1   = stmt1.executeQuery(operSql.toString());

				if(rs1!=null)
				{
					if(rs1.next())
					{
						oper_stn_id		   = checkForNull(rs1.getString("OPER_STN_ID"));
						create_booking_yn  = checkForNull(rs1.getString("create_booking_yn"));	
						cr_boook_conf_yn   = checkForNull(rs1.getString("create_booking_with_conf_yn"));	
						revise_booking_yn  = checkForNull(rs1.getString("revise_booking_yn"));
						Confirm_booking_yn = checkForNull(rs1.getString("confirm_booking_yn"));	
					}	
					else
					{	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(menu_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
			result = false;
					}
				}
			}

			if (!oper_stn_id.equals("") && result && call_func.equals("OT"))
			{
				url	= "../../eCommon/jsp/commonToolbar.jsp?home_required_yn=N&module_id=IP&function_id=BOOKING&function_name=Create%20Booking&function_type=F&access=NYNNN";
				params = request.getQueryString() ;
				source = url + params ;				
				
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(source));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(chk_booking_limit_by));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(multi_book_pat_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(block_bed_based_on));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(is_oa_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(call_func));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(wating_ref_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(pref_date_time));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(oa_patient_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(medical_service));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(booking_date_time));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(allowed_booking_type));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(unregistered_patients_bkg_yn));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(java.net.URLEncoder.encode(medical_speciality_desc,"UTF-8")));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(medical_speciality_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(java.net.URLEncoder.encode(physician_desc,"UTF-8")));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(physician_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(oper_room_code));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(java.net.URLEncoder.encode(oper_room_desc,"UTF-8")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(capture_fin_dtls_yn));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(nursing_unit_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(deactivate_pseudo_bed_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(cr_boook_conf_yn));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(java.net.URLEncoder.encode(sysdate)));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(bkg_grace_period));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(PreOpPreparationDays));
            _bw.write(_wl_block42Bytes, _wl_block42);

			}
			else if (!oper_stn_id.equals("") && result)
			{
				try
				{
					if(!(callFrom.equals("Revise") || callFrom.equals("Confirm")))
					{
						//Checking for the oprator station acces for nursing units
						StringBuffer sql = new StringBuffer();
						sql.append("SELECT distinct(locn_code) FROM am_locn_for_oper_stn WHERE facility_id = '"+facilityId+"' ");
						sql.append(" AND locn_type = 'N' AND eff_status = 'E' AND oper_stn_id = '"+oper_stn_id+"' ");
						rset = stmt.executeQuery(sql.toString());

	

						if (!rset.next())
						{ 
            _bw.write(_wl_block43Bytes, _wl_block43);
		result = false;
						}
						if (rset != null)   rset.close();
					}
				}
				catch(Exception e) 
				{ 
					result = false; 
					//out.println(e.toString());
					e.printStackTrace();
				}

				
				/*if(!(callFrom.equals("Revise") || callFrom.equals("Confirm")))
				{
					StringBuffer  sqltfr = new StringBuffer();
					sqltfr.append("select create_booking_yn,CREATE_BOOKING_WITH_CONF_YN,REVISE_BOOKING_YN,CONFIRM_BOOKING_YN from am_oper_stn where facility_id = '");
					sqltfr.append(facilityId);
					sqltfr.append("' and oper_stn_id = (select oper_stn_id from am_user_for_oper_stn  ");
					sqltfr.append(" where facility_id='");
					sqltfr.append(facilityId);
					sqltfr.append("' and appl_user_id ='");
					sqltfr.append(loginUser);
					sqltfr.append("' and trunc(sysdate) between eff_date_from and nvl(eff_date_to,trunc(sysdate)))");

					rs = stmt.executeQuery(sqltfr.toString());		
					if(rs!= null)
					{		
						if(rs.next())			
						{			
							create_booking_yn  = checkForNull(rs.getString(1));	
							cr_boook_conf_yn   = checkForNull(rs.getString(2));	
							revise_booking_yn  = checkForNull(rs.getString(3));
							Confirm_booking_yn = checkForNull(rs.getString(4));	
						}
					}
				}*/
//out.println("<script>alert(\"revise_booking_yn:"+revise_booking_yn+"\");</script>");
//out.println("<script>alert(\"Confirm_booking_yn:"+Confirm_booking_yn+"\");</script>");
				if(create_booking_yn.equals("Y") || cr_boook_conf_yn.equals("Y") || revise_booking_yn.equals("Y") || Confirm_booking_yn.equals("Y"))
				{
					flag = true;
				}

				if(flag)
				{		
					if(is_ca_yn.equals("") && is_oa_yn.equals(""))
					{	
						if(bkg_lst_ref_no == "")
						{
							if(create_booking_yn.equals("Y") || cr_boook_conf_yn.equals("Y"))
							{	
								
								
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(chk_booking_limit_by));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(allowed_booking_type));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(multi_book_pat_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(block_bed_based_on));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(unregistered_patients_bkg_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(capture_fin_dtls_yn));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(is_op_pending_referral_booking));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(referral_ID));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(deactivate_pseudo_bed_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(cr_boook_conf_yn));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(java.net.URLEncoder.encode(sysdate)));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(bkg_grace_period));
            _bw.write(_wl_block49Bytes, _wl_block49);

							}
							else
							{	
            _bw.write(_wl_block50Bytes, _wl_block50);
	}
						}
						else
						{	
							if(callFrom.equals("Revise"))
							{	
							
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(java.net.URLEncoder.encode(bkg_lst_ref_no)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(multi_book_pat_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(block_bed_based_on));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(capture_fin_dtls_yn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(deactivate_pseudo_bed_yn));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(chk_booking_limit_by));
            _bw.write(_wl_block54Bytes, _wl_block54);
	}

							if(callFrom.equals("Confirm"))
							{	
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(chk_booking_limit_by));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(java.net.URLEncoder.encode(bkg_lst_ref_no)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(multi_book_pat_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(block_bed_based_on));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(capture_fin_dtls_yn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(deactivate_pseudo_bed_yn));
            _bw.write(_wl_block57Bytes, _wl_block57);
	}
						}
					}
					else if(is_ca_yn.equals("Y"))
					{
						
						
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(source));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(chk_booking_limit_by));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(is_ca_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(java.net.URLEncoder.encode(call_function)));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(java.net.URLEncoder.encode(ca_patient_id)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(allowed_booking_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(multi_book_pat_yn));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(block_bed_based_on));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(unregistered_patients_bkg_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(capture_fin_dtls_yn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(deactivate_pseudo_bed_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(cr_boook_conf_yn));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(java.net.URLEncoder.encode(sysdate)));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(bkg_grace_period));
            _bw.write(_wl_block64Bytes, _wl_block64);

					}
					else
					{
						
						
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(source));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(chk_booking_limit_by));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(is_oa_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(java.net.URLEncoder.encode(call_function)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(java.net.URLEncoder.encode(wating_ref_no)));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(java.net.URLEncoder.encode(pref_date_time)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(java.net.URLEncoder.encode(oa_patient_id)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(allowed_booking_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(multi_book_pat_yn));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(block_bed_based_on));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(unregistered_patients_bkg_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(capture_fin_dtls_yn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(deactivate_pseudo_bed_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(cr_boook_conf_yn));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(java.net.URLEncoder.encode(sysdate)));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(bkg_grace_period));
            _bw.write(_wl_block67Bytes, _wl_block67);
	}
				}
				else
				{
					if(is_ca_yn.equals(""))
					{	
            _bw.write(_wl_block68Bytes, _wl_block68);
	}
					else
					{	
            _bw.write(_wl_block68Bytes, _wl_block68);
	}
				}
			}
		}
		else
		{
			if(is_ca_yn.equals(""))
			{	
            _bw.write(_wl_block69Bytes, _wl_block69);
	}
			else
			{ 
            _bw.write(_wl_block70Bytes, _wl_block70);
	}
		}
		if(rs!=null) rs.close();
		if(rs1!=null) rs.close();
		if(rset!=null) rset.close();
		if(stmt!=null) stmt.close();
		if(stmt1!=null) stmt1.close();

	}catch(Exception e)
	{	
		//out.println("Exception in Booking.jsp : "+ e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block71Bytes, _wl_block71);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.booking.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.booking.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.revisebooking.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ConfirmBooking.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.booking.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.booking.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }
}
