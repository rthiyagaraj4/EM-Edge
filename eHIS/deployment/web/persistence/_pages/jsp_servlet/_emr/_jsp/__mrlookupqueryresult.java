package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __mrlookupqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/MRLookupQueryResult.jsp", 1719559200695L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eIP/jsp/ForSplChars.jsp", 1709116911640L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t<html>\n\t\t\t<head>\n\t\t\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t\t\t\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t\t\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t\t\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n\t\t\t\t<Script src=\"../../eIP/js/IPLookup.js\" language=\"JavaScript\"></Script>\n\t\t\t\t<script src=\"../../eMR/js/MRPatientMovementHistory.js\" language=\"JavaScript\" ></script>\n\t\t\t<script>\n\t\t\t\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t</head>\n\t\t\t\t\t<body onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\' >\n\t\t\t\t\t<form name=\'iplookupqueryresult\' id=\'iplookupqueryresult\'>\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t\t\t<SCRIPT LANGUAGE=\"JavaScript\">\t\t\t\t\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"navigate_table\").style.display=\"inline\";\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"table_header\").style.display=\"\";\t\t\n\t\t\t\t\t\t\t\t</SCRIPT>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\n\t\t\t\t\t<SCRIPT LANGUAGE=\"JavaScript\">\n\t\t\t\t\t\tdocument.getElementById(\"next\").style.display=\"none\";\n\t\t\t\t\t</SCRIPT>\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\n\t\t\t\t\t<SCRIPT LANGUAGE=\"JavaScript\">\n\t\t\t\t\t\tdocument.getElementById(\"next\").style.display=\"inline\";\n\t\t\t\t\t</SCRIPT>\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<SCRIPT LANGUAGE=\"JavaScript\">\n\t\t\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\'));\n\t\t\t\t\t</SCRIPT>\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t<input type=\'hidden\' name=\'jsp_name\' id=\'jsp_name\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" >\n\t\t\t\t\t\n\t\t\t\t\t<input type=\'hidden\' name=\'call_function\' id=\'call_function\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'called_from\' id=\'called_from\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'win_height\' id=\'win_height\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'win_width\' id=\'win_width\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'dialogTop\' id=\'dialogTop\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'modal\' id=\'modal\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'module\' id=\'module\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'model_window\' id=\'model_window\' value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'routine_tfr_yn\' id=\'routine_tfr_yn\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'no_of_days\' id=\'no_of_days\' value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'prog_id\' id=\'prog_id\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'bl_install\' id=\'bl_install\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'total_count\' id=\'total_count\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'targetURL\' id=\'targetURL\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'IPParamValue\' id=\'IPParamValue\' value=\"\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'leave_exp_dt_flag\' id=\'leave_exp_dt_flag\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'bed_block_period_max\' id=\'bed_block_period_max\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'bl_install_yn\' id=\'bl_install_yn\' value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'bl_interfaced_yn\' id=\'bl_interfaced_yn\' value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'bedBlock_normal\' id=\'bedBlock_normal\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'max_blk_type\' id=\'max_blk_type\' value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'oper_stn_id\' id=\'oper_stn_id\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'setup_bl_dtls_in_ip_yn\' id=\'setup_bl_dtls_in_ip_yn\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'allow_discharge_date\' id=\'allow_discharge_date\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'max_disch_period_for_dc\' id=\'max_disch_period_for_dc\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'sStyle\' id=\'sStyle\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'chg_nurs_unit_in_assign_bed_yn\' id=\'chg_nurs_unit_in_assign_bed_yn\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'sys_dt_time\' id=\'sys_dt_time\' value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'confirmIP\' id=\'confirmIP\' value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'p_service_type\' id=\'p_service_type\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'pat_check_in_allowed_yn\' id=\'pat_check_in_allowed_yn\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'priotity_status\' id=\'priotity_status\' value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'change_bed_class_yn\' id=\'change_bed_class_yn\' value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'deactivate_pseudo_bed_yn\' id=\'deactivate_pseudo_bed_yn\' value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'dflt_blk_prd_for_tfr_out\' id=\'dflt_blk_prd_for_tfr_out\' value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'bed_block_period_normal\' id=\'bed_block_period_normal\' value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'change_adm_dtls_duration\' id=\'change_adm_dtls_duration\' value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'reserve_bed_on_tfr_yn\' id=\'reserve_bed_on_tfr_yn\' value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'bed_block_period_max_type\' id=\'bed_block_period_max_type\' value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'allow_multiple_bed_for_resv_yn\' id=\'allow_multiple_bed_for_resv_yn\' value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" >\n\t\t\t\t\t<!-- venkat crf 41-->\n\t\t\t\t\n\t\t\t\t\t<input type=\'hidden\' name=\'result_count\' id=\'result_count\' value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'chc_for_pen_orders_bfr_dis_adv\' id=\'chc_for_pen_orders_bfr_dis_adv\' value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'dis_adv_allow_yn\' id=\'dis_adv_allow_yn\' value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>\n\t\t<!-- venkat crf 41-->\n\t\t\t\t\t<input type=\'hidden\' name=\'chc_for_pen_orders_bfr_dischrg\' id=\'chc_for_pen_orders_bfr_dischrg\' value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'dischrg_allow_yn\' id=\'dischrg_allow_yn\' value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>\n\n\t\t\t\t\t<input type=\'hidden\' name=\'allow_late_discharge_reason\' id=\'allow_late_discharge_reason\' value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'disch_reason_mand_yn\' id=\'disch_reason_mand_yn\' value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'transfer_wo_delink_yn\' id=\'transfer_wo_delink_yn\' value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'><!-- Added for the CRF HSA-CRF 0035 -->\n\n\t\t\t\t\t<input type=\'hidden\' name=\'CancelledReason\' id=\'CancelledReason\' value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'CancelledBy\' id=\'CancelledBy\' value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'CancelledDate\' id=\'CancelledDate\' value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'bed_no\' id=\'bed_no\' value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" >\n\t\t\t\t\t<!-- 10/17/2008-->\n\t\t\t\t\t<input type=\'hidden\' name=\'assign_bed\' id=\'assign_bed\' value=\" \" >\n\t\t\t\t\n\t\t\t\t\t<!-- 10/17/2008    end-->\n\t\t<!-- 0-7/09/2009    end-->\n\t\t\t\t\t\t<input type=\'hidden\' name=\'deceased_date_time\' id=\'deceased_date_time\' value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'maternal_death_yn\' id=\'maternal_death_yn\' value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =" \" >\n\t\t\t\t\t<input type=\'hidden\' name=\'indicator\' id=\'indicator\' value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'discharge_date_time\' id=\'discharge_date_time\' value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'age\' id=\'age\' value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'pre_disch_appl_yn\' id=\'pre_disch_appl_yn\' value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" ><!-- Added for the CRF -KDAH-CRF-0104  by Dharma    end-->\n\t\t\t\t\t<input type=\'hidden\' name=\'weight_on_admn_mandatory\' id=\'weight_on_admn_mandatory\' value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" > <!-- Added by Dharma on Oct27th against HSA-CRF-0181 [IN:049541] -->\n\t\t\t\t\t<input type=\'hidden\' name=\'restriction_for_wardReturn\' id=\'restriction_for_wardReturn\' value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" > <!-- Added by Sangeetha on 09-Nov-2016 against GHL-CRF-412.2 -->\n\n\t\t\t\t\n\n\t\t\t\t\t</form>\n\n\n\t\t\t\t\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:20%; visibility:hidden;\' bgcolor=\'blue\'>\n\t\t\t\t\t\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t\t\t\t\t\t<tr><td width=\'100%\' id=\'column\'></td></tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</div>\n\n\t\t\t\t\t</body>\n\t\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'></link>\n\t\t\t\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t\t\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t\t\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n\t\t\t\t<Script src=\"../../eIP/js/IPLookup.js\" language=\"JavaScript\"></Script>\n\t\t\t\t<script src=\"../../eMR/js/MRPatientMovementHistory.js\" language=\"JavaScript\" ></script> \n\t\t\t<script>\n\t\t\t\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t<SCRIPT LANGUAGE=\"JavaScript\">\n\t\t\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\'));\n\t\t\t\t\t</SCRIPT>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n</html>\n\n";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );
 
public String singleToDoubleQuotes(String strDB)
{
	/*
	String strModified="";
	try
	{
		if((strDB != null) ||(strDB !=""))
		{
			StringBuffer stringbuffer = new StringBuffer(strDB);
			int i = 0;
			for(int j = 0; strDB.indexOf('\'', i) != -1; j++)
			{
				i = strDB.indexOf('\'', i);
				stringbuffer.insert(i + j, "'");
				i++;
			}
			strModified=stringbuffer.toString();
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}*/
	if(strDB == null) strDB = "";
	return strDB.replaceAll("'","''");
}


	// By Annadurai 2/23/2004 starts., to handle NullPointerException.
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet cancelBedDetail= null;synchronized(session){
                cancelBedDetail=(webbeans.eCommon.RecordSet)pageContext.getAttribute("cancelBedDetail",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(cancelBedDetail==null){
                    cancelBedDetail=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("cancelBedDetail",cancelBedDetail,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String locale					= (String)session.getAttribute("LOCALE");
	Connection con					= null;
	
	
	
	ResultSet rs					= null;

	Statement paramstmt				= null;
	ResultSet paramrs				= null; 
	PreparedStatement pstmt			= null;



			
	 
	
	String ward_return			= "";


	
	String chc_for_pen_orders_bfr_dis_adv ="";
    String dis_adv_allow_yn               ="";
	String chc_for_pen_orders_bfr_dischrg ="";
	String chk_pen_ward_rtn_bfr_dis_adv	  =""; //Added by Sangeetha on 9-Nov-16 for GHL-CRF-412.2
    String dischrg_allow_yn               ="";
    int result_count=0;
		
	String tfr_req_stat				= "";	
	String facility_id				= "";
	String login_user				= "";
	String oper_stn_id				= "";
	String show_bed_yn				= "";
	String wherecondn				= "";
	String wc_for_bed_ref			= "";
	String function_name			= "";
	String fam_name_search			= "";
	String pat_check_in_allowed_yn	= "N";
	String setup_bl_dtls_in_ip_yn	= "N";
	String routine_tfr_yn			= "";
	String req_stat_tout			= "";
	String priotity_status			= "";
	String date_of_birth_converted  = "";
	String cutt_of_time				= "";
	String req_no					= "";
	String perm_fs_locn				= "";
	

	String bl_operational			= (String)session.getAttribute("bl_operational");
	facility_id						= (String)session.getAttribute("facility_id");
	login_user						= (String)session.getAttribute("login_user");
	oper_stn_id						= checkForNull(request.getParameter("opst"));
	show_bed_yn						= checkForNull(request.getParameter("show_bed_yn"));
	wherecondn						= checkForNull(request.getParameter("wherecondn"));
	//out.println("wherecondn::"+wherecondn);
	function_name					= checkForNull(request.getParameter("function_name"));
	routine_tfr_yn					= checkForNull(request.getParameter("routine_tfr_yn"));
	String discharge_type			= checkForNull(request.getParameter("discharge_type"));
	String discharge_status			= checkForNull(request.getParameter("discharge_status"));
	String ServiceCode				= checkForNull(request.getParameter("ServiceCode"));
	String SubServiceCode			= checkForNull(request.getParameter("SubServiceCode")); 
	int change_admission_dtls		= 0;
	String pat_class = checkForNull(request.getParameter("pat_class")); 
	System.out.println("pat_class value::"+pat_class);

	String disc_from_date			= checkForNull(request.getParameter("disc_from_date"));
		if(!disc_from_date.equals(""))
			disc_from_date			= DateUtils.convertDate(disc_from_date,"DMY",locale,"en"); 
	String disc_to_date				= checkForNull(request.getParameter("disc_to_date"));
		if(!disc_to_date.equals(""))
			disc_to_date			= DateUtils.convertDate(disc_to_date,"DMY",locale,"en"); 
	// added for assign bed on 3/8/2005 by Sridhar R 
	String chg_nurs_unit_in_assign_bed_yn		= checkForNull(request.getParameter("chg_nurs_unit_in_assign_bed_yn"),"N");
	String bl_interfaced_yn			= "";
	String Lodger_Max_RefNo			= "";
	String Lodger_Next_RefNo		= "";
	String Lodger_Period			= "";
	String Acc_Period				= "";
	String Acc_Period_unit			= "";
	String deactivate_pseudo_bed_yn	= "";
	String cancel_reason_code		= "";
	String cancellation_date_time	= "";
	String cancelled_by_id			= "";
	String contact_reason			= "";
	String modified_By_rslt			= "";
	String reason_for_modification  = "";
	String reserve_bed_on_tfr_yn    = "";
	String res_reserve_bed_intraward_yn    = "";//Maheshwaran
	String bed_block_period_max    = "";
	String bed_block_period_max_type= "";


	String discharge_date_time_display = "&nbsp;";
	
	String discharge_date_time_display_report=""; //Added this line for this incident [40702]

	int IP_param_No_Acc_Persons		= 0;
	int bed_block_period_dis		= 0;
	int dis_date_chk_days			= 0;
	int dflt_blk_prd_for_tfr_out	= 0;
	int bed_block_period_normal		= 0;
	String status_value				= "";	
	String status_value_converted   = "";
	String call_func				= "";	
	String confirmIP				= checkForNull(request.getParameter("confirmIP"));
	String p_service_type			= checkForNull(request.getParameter("p_service_type"));
	String targetURL				= checkForNull(request.getParameter("targetURL"));
	String color_code_scheme		= "";
		if (show_bed_yn==null) show_bed_yn = "Y";
	String clinic_list				= checkForNull(request.getParameter("clinic_list"), "1");
		if(clinic_list.length() == 0) clinic_list="('')";
	String call_function			=	checkForNull(request.getParameter("param"));

	String pend_order_status="";

	/*
		Vairable Added :
			On:10/28/2010,For:FD-PMG20089-CRF-0862,By:Chiranjeevi.C
	*/
	String exclude_nda_pats			=	checkForNull(request.getParameter("exclude_nda_pats"),"N");


	//10/16/2008 5089_MF-CRF-0017 enhancement startcall_function put request scope
	request.setAttribute("call_function",call_function);

	String paramsValue				=	checkForNull((String) session.getAttribute("paramsValue"));
	String menu_id					=	checkForNull(request.getParameter("menu_id"));

	String allow_discharge_date		= checkForNull(request.getParameter("allow_discharge_date"));
	String max_disch_period_for_dc_str	= checkForNull(request.getParameter("max_disch_period_for_dc"));
	String patientName			= checkForNull(request.getParameter("patientName"));
	//String patientName				=  java.net.URLDecoder.decode(patientName1,"UTF-8");
	String asgn_bed_mark_arvl		= "";
	String link_font_color          = "";
	String sys_dt_time				= "";

	String function_id				= checkForNull(request.getParameter("function_id"));
	String allow_late_discharge_reason="";
	String disch_reason_mand_yn="";
	String transfer_wo_delink_yn="";//Added for the CRF HSA-CRf-0035

	int max_disch_period_for_dc		= 0;

	String deceased_date_time		= "";
	String maternal_death_yn		= "";
	String indicator				= "";
	String age						= "";
	int n_Age						= 0;
	String allow_multiple_bed_for_resv_yn		= "";
	int  max_disch_period_for_predc				= 0;
	String  allow_discharge_date_predc			= "";
	String  discharge_checklist_app_yn			= "";
	String  dis_date_chk_days_unit				= "";
	String  diag_update_period_max_unit			= "";
	String  serverdate				= "";
	String  patient_file_no						= "";
	String  pat_ser_grp_code					= "";

	if(! max_disch_period_for_dc_str.equals(""))
		max_disch_period_for_dc		= Integer.parseInt(max_disch_period_for_dc_str);
	if(pat_class.equals("IP")||pat_class.equals("DC"))
	{
			try
			{
				// Following Code is to Check the Module with Billing Interface 
				con							= ConnectionManager.getConnection(request);
				paramstmt					= con.createStatement();
				String bed_class_allowed    = "";

				String mp_param_table		= "";
				String mp_param_colns		= "";
				String mp_param_criteria	= "";
				String mother_cut_off_age	= "";
				String mother_max_age		= "";
				String mo_install_sql		= "";
				String mo_install_yn		= "";
				String pre_disch_appl_yn	= "";//Added for the CRF -KDAH-CRF-0104  by Dharma
				String pre_dis_initiate_yn	= "";//Added for the CRF -KDAH-CRF-0104  by Dharma
				String weight_on_admn_mandatory	= ""; //Added by Dharma on Oct27th against HSA-CRF-0181 [IN:049541] 

				
				
				
				
				
				paramrs = paramstmt.executeQuery(" SELECT weight_on_admn_mandatory,pre_disch_appl_yn,bl_interfaced_yn, setup_bl_dtls_in_ip_yn, pat_check_in_allowed_yn, discharge_checklist_app_yn, diag_update_period_max_unit,	TO_CHAR (SYSDATE, 'dd/mm/rrrr hh24:mi') serverdate,priority_applicable_yn, change_bed_class_yn, bed_block_period_dis, dis_date_chk_days, deactivate_pseudo_bed_yn,       dflt_blk_prd_for_tfr_out, bed_block_period_normal, lodger_max_srl_no, lodger_next_srl_no, max_stay_of_lodger_after_disc, dflt_gate_pass_period, dflt_gate_pass_unit, max_allowed_accom_pers,change_admission_dtls, TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi') sys_dt_time, reserve_bed_on_tfr_yn,RES_RESERVE_BED_INTRAWARD_YN,bed_block_period_max, bed_block_period_max_type, allow_multiple_bed_for_resv_yn, dis_date_chk_days, ALLOW_LATE_DISCHARGE_REASON, DISCH_REASON_MAND_YN, transfer_wo_delink_yn,dis_date_chk_days_unit,CHK_FOR_PEN_ORDERS_BFR_DIS_ADV,DIS_ADV_ALLOW_YN,CHK_FOR_PEN_ORDERS_BFR_DIS,DIS_ALLOW_YN,CHK_PEN_WARD_RTN_BFR_DIS_ADV, max_disch_period_for_dc,TO_CHAR (SYSDATE - DECODE (dis_date_chk_days_unit, 'H', dis_date_chk_days / 24, dis_date_chk_days),'dd/mm/rrrr hh24:mi') allow_discharge_date"+mp_param_colns+" "+mo_install_sql+" FROM IP_PARAM "+mp_param_table+" WHERE facility_id='"+facility_id+"' "+mp_param_criteria+" ");  // "CHK_PEN_WARD_RTN_BFR_DIS_ADV" Added by Sangeetha on 9-Nov-16 for GHL-CRF-412.2
			

				while(paramrs.next()){
						Lodger_Max_RefNo				= checkForNull(paramrs.getString("lodger_max_srl_no"));
						Lodger_Next_RefNo				= checkForNull(paramrs.getString("lodger_next_srl_no"));
						Lodger_Period					= checkForNull(paramrs.getString("max_stay_of_lodger_after_disc"));
						Acc_Period						= checkForNull(paramrs.getString("dflt_gate_pass_period"));
						Acc_Period_unit					= checkForNull(paramrs.getString("dflt_gate_pass_unit"));
						IP_param_No_Acc_Persons			= paramrs.getInt("max_allowed_accom_pers");
						bl_interfaced_yn				= checkForNull(paramrs.getString("bl_interfaced_yn"));
						setup_bl_dtls_in_ip_yn			= checkForNull(paramrs.getString("setup_bl_dtls_in_ip_yn"));
						pat_check_in_allowed_yn	        = checkForNull(paramrs.getString("pat_check_in_allowed_yn"));
						priotity_status					= checkForNull(paramrs.getString("priority_applicable_yn"));
						bed_class_allowed				= checkForNull(paramrs.getString("change_bed_class_yn"));
						deactivate_pseudo_bed_yn		= checkForNull(paramrs.getString("deactivate_pseudo_bed_yn"));
						bed_block_period_dis			= paramrs.getInt("bed_block_period_dis");
						dis_date_chk_days				= paramrs.getInt("dis_date_chk_days");
						dflt_blk_prd_for_tfr_out		= paramrs.getInt("dflt_blk_prd_for_tfr_out");
						bed_block_period_normal	        = paramrs.getInt("bed_block_period_normal");
						change_admission_dtls			= paramrs.getInt("change_admission_dtls");
						sys_dt_time						= paramrs.getString("sys_dt_time");
						reserve_bed_on_tfr_yn			= checkForNull(paramrs.getString("reserve_bed_on_tfr_yn"));
						res_reserve_bed_intraward_yn	= checkForNull(paramrs.getString("RES_RESERVE_BED_INTRAWARD_YN"));
						
						bed_block_period_max			= checkForNull(paramrs.getString("bed_block_period_max"));
						bed_block_period_max_type		= checkForNull(paramrs.getString("bed_block_period_max_type"));
						allow_multiple_bed_for_resv_yn	= checkForNull(paramrs.getString("allow_multiple_bed_for_resv_yn"),"N");
						max_disch_period_for_predc		= paramrs.getInt("max_disch_period_for_dc");
						allow_discharge_date_predc		= checkForNull(paramrs.getString("allow_discharge_date"));
						discharge_checklist_app_yn		= checkForNull(paramrs.getString("discharge_checklist_app_yn"));
						dis_date_chk_days_unit			= checkForNull(paramrs.getString("dis_date_chk_days_unit"));
						diag_update_period_max_unit		= checkForNull(paramrs.getString("diag_update_period_max_unit"));
						serverdate						= checkForNull(paramrs.getString("serverdate"));
					// Below code added by venkatesh on 09/November/2011 against the KDAH-CRF-0041
						chc_for_pen_orders_bfr_dis_adv=checkForNull(paramrs.getString("CHK_FOR_PEN_ORDERS_BFR_DIS_ADV"));
						dis_adv_allow_yn=checkForNull(paramrs.getString("DIS_ADV_ALLOW_YN"));

						chk_pen_ward_rtn_bfr_dis_adv=checkForNull(paramrs.getString("CHK_PEN_WARD_RTN_BFR_DIS_ADV")); //Added by Sangeetha on 9-Nov-16 for GHL-CRF-412.2
							
						// venkatesh KDAH-CRF-0041 END
						
						chc_for_pen_orders_bfr_dischrg =checkForNull(paramrs.getString("CHK_FOR_PEN_ORDERS_BFR_DIS"));
						dischrg_allow_yn  =checkForNull(paramrs.getString("DIS_ALLOW_YN"));

						allow_late_discharge_reason=checkForNull(paramrs.getString("allow_late_discharge_reason"));
						disch_reason_mand_yn=checkForNull(paramrs.getString("disch_reason_mand_yn"));
						transfer_wo_delink_yn=checkForNull(paramrs.getString("transfer_wo_delink_yn"));//Added for the CRF HSA-CRF-0035
						
						if(call_function.equals("PrepareDischargeAdvice")){
							mother_cut_off_age			= checkForNull(paramrs.getString("mother_cut_off_age"));
							mother_max_age				= checkForNull(paramrs.getString("mother_max_age"));
						}
						if(call_function.equals("CANCEL_DISCHARGE_PATIENT"))
							mo_install_yn				=  checkForNull(paramrs.getString("mo_install_yn"),"N");
						pre_disch_appl_yn	= checkForNull(paramrs.getString("pre_disch_appl_yn"));//Added for the CRF -KDAH-CRF-0104  by Dharma
						weight_on_admn_mandatory = checkForNull(paramrs.getString("weight_on_admn_mandatory"));//Added by Dharma on Oct27th against HSA-CRF-0181 [IN:049541] 
						
				}	

				if(paramrs != null)			paramrs.close();
				if(paramstmt != null)		paramstmt.close();
				//Added by kishore on 5/15/2004
				
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

				try
				{

					String nurs_unit_code		= "";
					StringBuffer where_criteria = new StringBuffer();
					StringBuffer where_criteria_count = new StringBuffer();
					StringBuffer sql			= new StringBuffer();
					String class_val			= "QRYODDSMALL";
					String bl_install_yn		=	checkForNull(request.getParameter("bl_install_yn"));
					String bedBlock_normal		=	checkForNull(request.getParameter("bedBlock_normal"));
					String max_blk_type			=	checkForNull(request.getParameter("max_blk_type"));
					String whereClause			=	checkForNull(request.getParameter("whereclause"));
					String whereClauseCount		=	checkForNull(request.getParameter("whereclausecount"));
					String from					=	checkForNull(request.getParameter("from"));
					String to					=	checkForNull(request.getParameter("to"));
					String soundex_type			=	checkForNull(request.getParameter("soundex"));
					String no_of_days			=	checkForNull(request.getParameter("no_of_days"));
					String nursing_unit_code	=	checkForNull(request.getParameter("nursing_unit"));
					String from_nursing_unit	=	checkForNull(request.getParameter("from_nursing_unit"));
					String to_nursing_unit_code	=	checkForNull(request.getParameter("to_nursing_unit"));
					String to_Splcode			=	checkForNull(request.getParameter("to_Splcode"));
					String speciality_code		=	checkForNull(request.getParameter("Splcode"));
					String from_Splcode			=	checkForNull(request.getParameter("from_Splcode"));
					String encounter_id			=	checkForNull(request.getParameter("encounter_id"));
					
					String practitioner_id		=	checkForNull(request.getParameter("practid"));
					String from_practid			=	checkForNull(request.getParameter("from_practid"));
					String from_date			=	checkForNull(request.getParameter("from_date"));
					if(!from_date.equals(""))
						from_date = DateUtils.convertDate(from_date,"DMY",locale,"en"); 
					String to_date				=	checkForNull(request.getParameter("to_date"));
					if(!to_date.equals(""))
						to_date = DateUtils.convertDate(to_date,"DMY",locale,"en"); 
					String chk_in_lodger_min_date= checkForNull(request.getParameter("chk_in_lodger_min_date"));
					String patient_id			=	checkForNull(request.getParameter("patient_id"));
					String gender				=	checkForNull(request.getParameter("gender"));
					String Modified_By				=	checkForNull(request.getParameter("user_name"));
					String modified_date_from	=	checkForNull(request.getParameter("modified_from_date"));
					if(!modified_date_from.equals(""))
						modified_date_from = DateUtils.convertDate(modified_date_from,"DMY",locale,"en"); 
					String modified_date_to		=	checkForNull(request.getParameter("modified_to_date"));
					if(!modified_date_to.equals(""))
						modified_date_to = DateUtils.convertDate(modified_date_to,"DMY",locale,"en"); 
					
					String name_prefix			=	checkForNull(request.getParameter("name_prefix"));
					String name_suffix			=	checkForNull(request.getParameter("name_suffix"));
					String first_name			=	checkForNull(request.getParameter("first_name"));
					String second_name			=	checkForNull(request.getParameter("second_name"));
					String third_name			=	checkForNull(request.getParameter("third_name"));
					String family_name			=	checkForNull(request.getParameter("family_name"));
					//Added by kumar on 18/03/2003 for Malaysia Enhancements
					String searchby				=	checkForNull(request.getParameter("searchby"), "S");
					String pat_name_as_multipart_yn = checkForNull(request.getParameter("pat_name_as_multipart_yn"));
					String patient_name			= "";
					String nursing_unit_short_desc= "";
					String service_short_desc	= "";
					String subservice_short_desc="";
					String bed_no				= "";
					int baby_count				= 0;
					String room_no				= "";
					String bed_class_short_desc	= "";
					String bed_type_short_desc	= "";
					String to_nursing_unit_short_desc = "";
					String to_bed_class_short_desc = "";
					String to_bed_type_short_desc = "";
					String blocked_bedno		= "";
					String specialty_short_desc	= "";
					String referral_id			= "";
					String practitioner_name	= "";
					String prev_val				= "";
					String prev_val2			= "";
					String Sex					= "";
					String admission_date_time	= "";
					String adm_date_display		= "";
					String discharge_date_time	= "";
					String adt_status			= "";
					String patient_status		= "";
					String ip_leave_status		= "";
					String leave_exp_dt			= "";
					String leave_exp_dt_flag	= "N";
					String date_of_birth		= "";
					String priority				= "";
					String priority_code		= "";
					String pat_dtls_unknown_yn	= "";
					String contact1_name		= "";
					String contact2_name		= "";


					//Added by Devang for Spl. chars
					name_prefix				= singleToDoubleQuotes(name_prefix);
					name_suffix				= singleToDoubleQuotes(name_suffix);
					nursing_unit_code		= singleToDoubleQuotes(nursing_unit_code);
					from_nursing_unit		= singleToDoubleQuotes(from_nursing_unit);
					from_Splcode			= singleToDoubleQuotes(from_Splcode);
					speciality_code			= singleToDoubleQuotes(speciality_code);
					to_nursing_unit_code	= singleToDoubleQuotes(to_nursing_unit_code);
					to_Splcode				= singleToDoubleQuotes(to_Splcode);
					from_practid			= singleToDoubleQuotes(from_practid);
					practitioner_id			= singleToDoubleQuotes(practitioner_id);
					String jsp_name			= checkForNull(request.getParameter("jsp_name"));
					//out.println("jsp_name:"+jsp_name);
					String called_from		= checkForNull(request.getParameter("called_from"));
					String win_height		= checkForNull(request.getParameter("win_height"));
					String dialogTop		= checkForNull(request.getParameter("dialogTop"));
					String win_width		= checkForNull(request.getParameter("win_width"));
					String modal			= checkForNull(request.getParameter("modal"));
					//out.println("modal:"+modal);
					String module			= checkForNull(request.getParameter("module"));
					String model_window		= checkForNull(request.getParameter("model_window"));
				//	String function_id		= checkForNull(request.getParameter("function_id"));


					String prog_id			= checkForNull(request.getParameter("prog_id"));
					String p_practitioner_id= checkForNull(request.getParameter("practitioner_id"));
					call_func				= checkForNull(request.getParameter("call_function"));
					String Disc_Chk			= checkForNull(request.getParameter("Disc_Chk"));
					String bed_class_code	= checkForNull(request.getParameter("Bedcode"));
					String bed_type_code	= checkForNull(request.getParameter("bed_type_code"));
					String cancelled_id		= checkForNull(request.getParameter("cancel_pract_id")); 
					String cancel_reason_desc		= "";
					String discharge_type_desc		= "";
					String discharge_status_desc	= "";
					String location_desc	= "";
					String patient_class	= "";
					//out.println("whereClause::"+whereClause);
						 



					
					
            _bw.write(_wl_block8Bytes, _wl_block8);

					if(whereClause.equals(""))
					{
						
								where_criteria.append(" where a.facility_id='");
								where_criteria.append(facility_id);
								where_criteria.append("' ");
							
							
							
							
						

					

						
						if(!wherecondn.equals(""))
						{
							
								if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
								{
										where_criteria.append(" and a.nursing_unit_code='"+nursing_unit_code+"' ");
									
								}
								else
								{
										where_criteria.append(" and exists (Select locn_code from AM_OS_USER_LOCN_ACCESS_VW b where b.facility_id = a.facility_id and b.locn_code = a.nursing_unit_code and b.locn_type = 'N' and b.oper_stn_id='"+oper_stn_id+"' and b.appl_user_id='"+login_user+"' ");

																		
											where_criteria.append(" and b.");
											where_criteria.append(wherecondn);
											where_criteria.append("='Y' )"); 

								}
							
							
						}
						else
						{				
							if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
							{
									where_criteria.append(" and a.nursing_unit_code='");
									where_criteria.append(nursing_unit_code);
									where_criteria.append("' ");
								
							}
						}
						
						
							if(speciality_code!=null && !speciality_code.equals(""))
							{
									where_criteria.append(" and specialty_code='");
									where_criteria.append(speciality_code);
									where_criteria.append("' ");
							}

							if(practitioner_id!=null && !practitioner_id.equals(""))
							{
									if(!no_of_days.equals(""))
									{
										where_criteria.append(" and practitioner_id='");
										where_criteria.append(practitioner_id);
										where_criteria.append("' ");
									}
									
										where_criteria.append(" and attend_practitioner_id='");
										where_criteria.append(practitioner_id);
										where_criteria.append("' ");
									
									
							}
					
							if(from_date!=null && !from_date.equals(""))
							{
									where_criteria.append(" and trunc(admission_date_time) >= to_date('");
									where_criteria.append(from_date);
									where_criteria.append("' , 'dd/mm/rrrr') ");
								
							}	
							if(to_date!=null && !to_date.equals(""))
							{
									where_criteria.append(" and trunc(admission_date_time) <= to_date('");
									where_criteria.append(to_date);
									where_criteria.append("' , 'dd/mm/rrrr') ");
								
							}
								
							
						

						
							if(patient_id!=null && !patient_id.equals("")){
								
									where_criteria.append(" and a.patient_id like '");
									where_criteria.append(patient_id);
									where_criteria.append("%' ");
								
							}

							if(encounter_id != null && !encounter_id.equals(""))
							{
									where_criteria.append(" and a.encounter_id='");
									where_criteria.append(encounter_id);
									where_criteria.append("' ");
								
							}	

							if(gender!=null && !gender.equals(""))
							{
									where_criteria.append(" and b.sex='");
									where_criteria.append(gender);
									where_criteria.append("' ");
								
							}

							if(name_prefix!=null && !name_prefix.equals(""))
							{
								where_criteria.append(" and name_prefix='");
								where_criteria.append(name_prefix);
								where_criteria.append("' ");
							}

							if(name_suffix!=null && !name_suffix.equals(""))
							{
								where_criteria.append(" and name_suffix='");
								where_criteria.append(name_suffix);
								where_criteria.append("' ");
							}
								
								if (pat_name_as_multipart_yn.equals("Y"))
								{
									if(first_name!=null && !first_name.equals(""))
									{
										where_criteria.append(" and upper(first_name) like upper('");
										where_criteria.append(first_name);
										where_criteria.append("') || '%' ");
									}

									if(second_name!=null && !second_name.equals(""))
									{
										where_criteria.append(" and upper(second_name) like upper('" );
										where_criteria.append(second_name);
										where_criteria.append("') || '%' ");
									}

									if(third_name!=null && !third_name.equals(""))
									{
										where_criteria.append(" and upper(third_name) like upper('");
										where_criteria.append(third_name);
										where_criteria.append("') || '%' ");
									}

									if(family_name!=null && !family_name.equals(""))
									{
										where_criteria.append(" and upper(family_name) like upper('" );
										where_criteria.append(family_name);
										where_criteria.append("') || '%' ");
									}
								}
								else
								{	
									if (searchby.equals("C"))
									{
										if(!family_name.equals(""))
										{
											where_criteria.append(" and upper(family_name) like '%' || upper('");
											where_criteria.append(family_name);
											where_criteria.append("') || '%' ");
										}
									}
									else if (searchby.equals("E"))
									{
										if(!family_name.equals(""))
										{
											where_criteria.append(" and upper(family_name) like '%' || upper('");
											where_criteria.append(family_name);
											where_criteria.append("') ");			  						}
									}
									else
									{
										if(!family_name.equals(""))
										{
											where_criteria.append(" and upper(family_name) like upper('");
											where_criteria.append(family_name);
											where_criteria.append("') || '%' ");
										}
									}
								}
							
						
						
						if( p_practitioner_id!=null && !p_practitioner_id.equals(""))
						{
							where_criteria.append(" and (practitioner_id ='");
							where_criteria.append( p_practitioner_id);
							where_criteria.append("'  ");
							where_criteria.append(" or encounter_id in ");
							where_criteria.append("(select encounter_id  ");
							where_criteria.append(" from PR_ENCOUNTER_PRACT ");
							where_criteria.append(" where operating_facility_Id= '");
							where_criteria.append(facility_id);
							where_criteria.append("'  ");
							where_criteria.append(" and practitioner_id= '");
							where_criteria.append(p_practitioner_id);
							where_criteria.append("' )) ");
						}
								

						if( clinic_list.length() >= 4)
						{
							where_criteria.append(" and nursing_unit_code in ");
							where_criteria.append(clinic_list);
							where_criteria.append("");
						}

						
						
					}//E.O BUILDING WHERE-CLAUSE
					else
					{
						where_criteria.append( whereClause) ;
						where_criteria_count.append( whereClauseCount) ;
					}
					int start = 0 ;
					int end = 0 ;
					int i=1;
					
					if (from.equals(""))
						start = 1 ;
					else
						start = Integer.parseInt( from ) ;
					
					if (to.equals(""))
						end = 12 ;
					else
						end = Integer.parseInt( to ) ;
					// The SQL below is constructed to count the number of record returned for the given criteria. The corresponding tables are used for the respective functions.
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" select count(*) ");
					sql.append(" FROM IP_OPEN_ENCOUNTER a, MP_PATIENT b "+where_criteria.toString() );
					sql.append(" and a.patient_id = b.patient_id");
						if(sql.length() > 0) sql.delete(0,sql.length());
						sql.append(" select a.cnt+b.cnt from (select count(1) cnt from IP_PATIENT_LAST_ENCOUNTER_VW a "+where_criteria.toString()+" and trunc(discharge_date_time) >= trunc(sysdate-"+no_of_days+") ) a, (select count(1) cnt from IP_OPEN_ENCOUNTER_VW a "+where_criteria.toString()+" ) b");

					if(rs!=null)	rs.close();
					
							if(!no_of_days.equals(""))
							{
								if(sql.length() > 0) sql.delete(0,sql.length());
								sql.append(" select room_no, IP_GET_DESC.IP_BED_CLASS(bed_class_code,'"+locale+"','2') bed_class_short_desc, IP_GET_DESC.IP_BED_TYPE(bed_type_code,'"+locale+"','2') bed_type_short_desc, to_char(admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time,null discharge_date_time,null deceased_date_time, gender, AM_GET_DESC.AM_SPECIALITY(specialty_code,'"+locale+"','2') specialty_short_desc, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"','2') service_short_desc, am_get_desc.AM_SUBSERVICE(SERVICE_CODE, SUBSERVICE_CODE,'"+locale+"','2') subservice_short_desc, nursing_unit_code, AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1') practitioner_short_name, encounter_id, patient_id, decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name))patient_name, IP_GET_DESC.IP_NURSING_UNIT(facility_id,nursing_unit_code,'"+locale+"','2') nursing_unit_short_desc, bed_no, practitioner_id, 0 baby_count, IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID, NURSING_UNIT_CODE,'"+locale+"','2') location_desc,null maternal_death_yn,null indicator, 'IP' patient_class,a.pat_ser_grp_code,to_char(a.date_of_birth, 'dd/mm/rrrr hh24:mi') date_of_birth, get_age(a.date_of_birth) age  from IP_OPEN_ENCOUNTER_VW a "+where_criteria.toString()+" UNION ALL select room_no, IP_GET_DESC.IP_BED_CLASS(bed_class_code,'"+locale+"','2') bed_class_short_desc, IP_GET_DESC.IP_BED_TYPE(bed_type_code,'"+locale+"','2') bed_type_short_desc, to_char(admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time, to_char(discharge_date_time,'dd/mm/rrrr hh24:mi') discharge_date_time,to_char(deceased_date_time,'dd/mm/rrrr hh24:mi') deceased_date_time, gender, AM_GET_DESC.AM_SPECIALITY(specialty_code,'"+locale+"','2') specialty_short_desc, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"','2') service_short_desc, am_get_desc.AM_SUBSERVICE(SERVICE_CODE, SUBSERVICE_CODE,'"+locale+"','2') subservice_short_desc, nursing_unit_code, AM_GET_DESC.AM_PRACTITIONER(practitioner_id,'"+locale+"','1') practitioner_short_name, encounter_id, patient_id, decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name, IP_GET_DESC.IP_NURSING_UNIT(facility_id,nursing_unit_code,'"+locale+"','2') nursing_unit_short_desc, bed_no, practitioner_id, 0 baby_count, IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID, NURSING_UNIT_CODE,'"+locale+"','2') location_desc,case when a.discharge_type_code is not null then (select maternal_death_yn from ip_discharge_type where discharge_type_code = a.discharge_type_code ) end maternal_death_yn, case when 	a.discharge_type_code is not null then (select indicator from ip_discharge_type  where discharge_type_code = a.discharge_type_code ) end indicator, 'IP' patient_class ,a.pat_ser_grp_code,to_char(a.date_of_birth, 'dd/mm/rrrr hh24:mi') date_of_birth, get_age(a.date_of_birth) age from IP_PATIENT_LAST_ENCOUNTER_VW a"+where_criteria.toString()+" and trunc(discharge_date_time) >= trunc(sysdate-"+no_of_days+") order by specialty_short_desc, practitioner_short_name, admission_date_time, encounter_id");
							}
							else
							{
							
									String order_by = "";
									
									if(sql.length() > 0) sql.delete(0,sql.length());
								
									sql.append(" select a.pre_dis_initiate_yn,a.room_num room_no, ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2) bed_class_short_desc, ip_get_desc.ip_bed_type(a.bed_type_code,'"+locale+"',2)bed_type_short_desc, to_char(a.admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time,TO_CHAR (a.admission_date_time,'rrrrmmdd hh24:mi') admission_date_time1 ,b.sex gender, am_get_desc.am_speciality(a.specialty_code,'"+locale+"',2) specialty_short_desc, a.nursing_unit_code, am_get_desc.am_practitioner(a.attend_practitioner_id, '"+locale+"', 1) practitioner_short_name, a.encounter_id, a.patient_id, to_char(b.date_of_birth, 'dd/mm/rrrr hh24:mi') date_of_birth, get_age(b.date_of_birth) age , decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, ip_get_desc.ip_nursing_unit(a.facility_id, a.nursing_unit_code,'"+locale+"',2) nursing_unit_short_desc, a.bed_num bed_no, a.blocked_bed_no, a.attend_practitioner_id practitioner_id, a.oth_adt_status, a.ip_leave_status, a.leave_expiry_date_time, decode(sign(( a.leave_expiry_date_time - sysdate)),-1,'Y','N') leave_flag, DECODE (a.pat_curr_locn_type, 'N', ip_get_desc.ip_nursing_unit (a.facility_id, a.pat_curr_locn_code, '"+locale+"', 2 ),'C', op_get_desc.op_clinic (a.facility_id, a.pat_curr_locn_code, '"+locale+"', '2' ), 'E', op_get_desc.op_clinic (a.facility_id, a.pat_curr_locn_code,'"+locale+"','2' ),'Y', op_get_desc.op_clinic (a.facility_id,  a.pat_curr_locn_code, '"+locale+"', '2'  ),  'O', (SELECT short_desc  FROM ot_oper_room_lang_vw   WHERE oper_room_code = a.pat_curr_locn_code  AND language_id ='"+locale+"'),'W', (SELECT short_desc   FROM rd_clinic_lang_vw  WHERE clinic_code = a.pat_curr_locn_code  AND language_id = '"+locale+"'),  'R', (SELECT short_desc  FROM am_facility_room_lang_vw   WHERE room_num = a.pat_curr_locn_code  AND language_id = '"+locale+"')) location_desc, a.patient_class,b.pat_dtls_unknown_yn,b.pat_ser_grp_code");

									
									

									
									sql.append(" from IP_OPEN_ENCOUNTER a, MP_PATIENT b");

									

									
									sql.append(" "+where_criteria.toString()+" AND a.patient_id = b.patient_id ");
												
										sql.append(" and a.patient_class in('"+pat_class+"') ")	;	
											

										

										order_by = " order by specialty_short_desc, practitioner_short_name, admission_date_time1 DESC ";
									
									
										sql.append(order_by); 
								
							}
						
					
				
		//out.println("sql.toString()-->"+sql.toString());
					int maxRecords=0;
			
					pstmt = con.prepareStatement(sql.toString());
					rs= pstmt.executeQuery();
					

						out.println("<table align='right' style='display:none' id='navigate_table'><tr><td aling ='right'>");
						if ( !(start <= 1) ){
								out.println("<A HREF='../jsp/MRLookupQueryResult.jsp?jsp_name="+jsp_name+"&win_height="+win_height+"&win_width="+win_width+"&dialogTop="+dialogTop+"&pat_class="+pat_class+"&param="+call_function+"&no_of_days="+no_of_days+"&modal="+modal+"&from="+(start-12)+"&to="+(end-12)+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"&whereclausecount="+URLEncoder.encode(where_criteria_count.toString())+"&targetURL="+targetURL+"&confirmIP="+URLEncoder.encode(confirmIP)+"&called_from="+URLEncoder.encode(called_from)+"&menu_id="+URLEncoder.encode(menu_id)+"&disc_from_date="+URLEncoder.encode(disc_from_date)+"&chg_nurs_unit_in_assign_bed_yn="+chg_nurs_unit_in_assign_bed_yn+"&disc_to_date="+URLEncoder.encode(disc_to_date)+"&function_name="+URLEncoder.encode(function_name)+"&call_function="+URLEncoder.encode(call_func)+"&opst="+URLEncoder.encode(oper_stn_id)+"&function_id="+URLEncoder.encode(function_id)+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
						}
								out.println("<A  HREF='../jsp/MRLookupQueryResult.jsp?jsp_name="+jsp_name+"&win_height="+win_height+"&win_width="+win_width+"&dialogTop="+dialogTop+"&pat_class="+pat_class+"&param="+call_function+"&no_of_days="+no_of_days+"&modal="+modal+"&from="+(start+12)+"&to="+(end+12)+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"&whereclausecount="+URLEncoder.encode(where_criteria_count.toString())+"&targetURL="+targetURL+"&confirmIP="+URLEncoder.encode(confirmIP)+"&called_from="+URLEncoder.encode(called_from)+"&menu_id="+URLEncoder.encode(menu_id)+"&disc_from_date="+URLEncoder.encode(disc_from_date)+"&chg_nurs_unit_in_assign_bed_yn="+chg_nurs_unit_in_assign_bed_yn+"&disc_to_date="+URLEncoder.encode(disc_to_date)+"&function_name="+URLEncoder.encode(function_name)+"&call_function="+ URLEncoder.encode(call_func) +"&opst="+URLEncoder.encode(oper_stn_id)+"&function_id="+URLEncoder.encode(function_id)+"'"+" text-decoration='none' style='display:none' id='next'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
								out.println("</td></tr></table></p>");
								out.println("<br><br>");				
					out.println(" <table cellspacing=0 cellpadding=0 align='center' width='130%' border='1' cellpadding=0 cellspacing=0>");
				
					out.println("<thead id='table_header' style='display:none'>");
								
								out.println("<tr>");
								out.println("<th>&nbsp;</th>");
								out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AdmissionDateTime.label","common_labels")+"&nbsp;"+"</th>");
								
							
								out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounterid.label","common_labels")+"&nbsp;"+"</th>");
							
								out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+"&nbsp;"+"</th>");
								
								out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+"&nbsp;"+"</th>");
								out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")+"&nbsp;"+"</th>");
								out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+"&nbsp;"+"</th>");
								
								
								if (!show_bed_yn.equals("N")){ 
											out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BedClass.label","common_labels")+"&nbsp;"+"</th>");
												out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedtype.label","common_labels")+"&nbsp;"+"</th>");
										
												out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels")+"&nbsp;"+"</th>");
												
												out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomno.label","common_labels")+"&nbsp;"+"</th>");
											
								}
							
								
								
									out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.currentlocation.label","common_labels")+"&nbsp;"+"</th>");
							
								
								out.println("</tr>");
					out.println("</thead>");
				
							int initCount				= 1 ;
							int z						= 0 ;
							int records_to_show			= 12 ;
					if(rs!=null)
					{
						if ( start != 0 )
						{
							for( int j=1; j<start; i++,j++ )
							{
								rs.next() ;
							}
							initCount+=start;
							--initCount;
						}
									
						while (rs!=null && (z < records_to_show) && rs.next() )
						{
							
								if(maxRecords==0){
            _bw.write(_wl_block9Bytes, _wl_block9);
}//Added by kishore on 5/15/2004
								z++;
							admission_date_time=rs.getString("admission_date_time");
							if(admission_date_time == null) admission_date_time="&nbsp;";
							if(!admission_date_time.equals("&nbsp;")){
								adm_date_display = DateUtils.convertDate(admission_date_time,"DMYHM","en",locale); 
							}
							n_Age = 0;
							
							if ( !no_of_days.equals(""))
							{
								discharge_date_time=rs.getString("discharge_date_time");
								
							discharge_date_time_display_report=checkForNull(discharge_date_time);					
								
								if(discharge_date_time == null) discharge_date_time="&nbsp;";
								bed_no = rs.getString("bed_no");
								if(bed_no == null) bed_no="&nbsp;";
								
							}
							specialty_short_desc=rs.getString("specialty_short_desc");
							if(specialty_short_desc == null) specialty_short_desc="&nbsp;";
							encounter_id=rs.getString("encounter_id");
							if(encounter_id == null) encounter_id="";
							
							if(referral_id == null) referral_id="";

							
							
							
							Sex =rs.getString("gender");
							
							if(Sex == null )
								Sex="";
							else if (Sex.equals("M"))
								Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
							else if (Sex.equals("F"))
								Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
							else 
								Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

							patient_id = rs.getString("patient_id");
								if( patient_id == null) patient_id="";
							

							patient_name=rs.getString("patient_name");
							if ((patient_name == null) || (patient_name.equals("null"))) 
								patient_name="";
									nurs_unit_code =rs.getString("nursing_unit_code");
									if( nurs_unit_code == null) nurs_unit_code="";
								
								nursing_unit_short_desc=rs.getString("nursing_unit_short_desc");
									if(nursing_unit_short_desc== null) nursing_unit_short_desc="&nbsp;";

								  location_desc = rs.getString("location_desc");
									if(location_desc == null) location_desc = "&nbsp;";
								
								
								bed_no = rs.getString("bed_no");
								
								if( bed_no == null){ bed_no="&nbsp;";}

									if(bed_no == null) bed_no="&nbsp;";
								
								room_no = rs.getString("room_no");
									if( room_no == null) room_no="&nbsp;";

								bed_class_short_desc = rs.getString("bed_class_short_desc");
									if( bed_class_short_desc == null) bed_class_short_desc="&nbsp;";
								bed_type_short_desc = rs.getString("bed_type_short_desc");
									if( bed_type_short_desc == null) bed_type_short_desc="&nbsp;";
							
								practitioner_id=rs.getString("practitioner_id");
									if(practitioner_id == null) practitioner_id="";
							
							practitioner_name=rs.getString("practitioner_short_name");
								if((practitioner_name == null) || (practitioner_name.equals("null"))) 	practitioner_name="";

						 
								patient_class = rs.getString("patient_class");
									if((patient_class == null) || (patient_class.equals("null")))
										patient_class="";
							
								if(class_val.equals("QRYEVENSMALL"))
									class_val = "QRYODDSMALL";
								else
									class_val = "QRYEVENSMALL";
							
							out.println("<tr>");

							if(!(jsp_name.equals("") && modal.equals("") ) )
							{
								if(!prev_val.equals(specialty_short_desc) || !prev_val2.equals(practitioner_name) )
								{
									String disp_value = specialty_short_desc;
									if (!practitioner_name.equals(""))
										disp_value = disp_value+"/"+practitioner_name;

										
										out.println("<td class='CAGROUPHEADING' colspan='12' align='left'>"+disp_value+"</td></tr><tr>");
									
								}

								out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap> ");

								if(!call_function.equals("IPList"))
								{	
									out.print("<a href=\"javascript:closeWin('"+encounter_id+"','"+patient_id+"','N')\">+</a></td>");
								}
								
									discharge_date_time_display = "&nbsp;";
										if(!(discharge_date_time==null || discharge_date_time.equals("&nbsp;")))
											discharge_date_time_display = DateUtils.convertDate(discharge_date_time,"DMYHM","en",locale);
									
										out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+adm_date_display+"</td>");
										if(bed_no.equals("&nbsp;"))
										{
												
													out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap><a href=\"javascript:showModal('"+encounter_id+"','"+patient_id+"','"+practitioner_id+"','"+nurs_unit_code+"','"+Sex+"','"+"" +"','"+patient_class+"','"+color_code_scheme+"','"+status_value+"','"+tfr_req_stat+"','')\">"+encounter_id+"</a></td>");
										}
												
													if(pend_order_status.equals("Y")){
														result_count=1;
													}else{
														result_count=0;
													}

													out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap><a href=\"javascript:showModal('"+encounter_id+"','"+patient_id+"','"+practitioner_id+"','"+nurs_unit_code+"','"+Sex+"','"+bed_no+"','"+patient_class+"','"+color_code_scheme+"','"+status_value+"','"+tfr_req_stat+"','"+n_Age+"','','','"+discharge_date_time_display+"','"+maternal_death_yn+"','"+indicator+"','"+req_no+"','"+perm_fs_locn+"','','','','"+result_count+"','"+facility_id+"')\">"+encounter_id+"</a></td>");


												
												//10/16/2008 5089_MF-CRF-0017 enhance ment start
											
										
										
									
									
									
							}
							else
							{
								
								
								if(!prev_val.equals(specialty_short_desc) || !prev_val2.equals(practitioner_name) )
								{
									if ( !no_of_days.equals("") )		
									{ 
										String prac = rs.getString("practitioner_short_name");
										if(prac == null) prac = "";
										String disp_value = specialty_short_desc;
										if (!practitioner_name.equals(""))
											disp_value = disp_value+"/"+practitioner_name;
										String cols = "";
										
										
											cols = "13";
										

										if(bed_no.equals("")) bed_no="&nbsp;";
											out.println("<td class='CAGROUPHEADING' colspan='"+cols+"' align='left' nowrap>"+specialty_short_desc+"/"+prac+"</td></tr><tr>");
									}									
									else if ( !no_of_days.equals(""))		
									{
										
										String disp_value = specialty_short_desc;
										if (!practitioner_name.equals(""))
										disp_value = disp_value+"/"+practitioner_name;
										out.println("<td class='CAGROUPHEADING' colspan='10' align='left' nowrap>"+disp_value+"</td></tr><tr>");
									}
									else
									{
										out.println("<td class='CAGROUPHEADING' colspan='8' align='left' nowrap>"+specialty_short_desc+"/"+practitioner_name+"</td></tr><tr>");
									
									}
								}

									out.println("<td nowrap class='"+class_val+"'> ");
									String changeCallFunc = "";
									if( !no_of_days.equals("") && discharge_date_time != "&nbsp;")
										changeCallFunc = "Y";
									else
										changeCallFunc = "N";

									out.print("<a href=\"javascript:closeWin2('"+encounter_id+"','"+patient_id+"','"+changeCallFunc+"')\">");								
									out.print("+</a></td>" );
									out.println("<td nowrap class='"+class_val+"' nowrap>"+adm_date_display+"</td>");

								 discharge_date_time_display = "&nbsp;";
								if(!(discharge_date_time==null || discharge_date_time.equals("&nbsp;") || discharge_date_time.equals("")))
									discharge_date_time_display = DateUtils.convertDate(discharge_date_time,"DMYHM","en",locale);

								if (   !no_of_days.equals("") )	
								{
									
									out.println("<td nowrap class='"+class_val+"'>"+discharge_date_time_display+"</td>");
								}
									out.println("<td nowrap class='"+class_val+"'>"+encounter_id+"</td>");	
								
							}
							out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' >"+patient_id+"</td>");
							
							if ((patient_name.trim()).equals(""))
								patient_name = "&nbsp;";
							out.println("<td  class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+patient_name+"</td>");
							
							out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+Sex+"</td>");
							out.println("<td  class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+nursing_unit_short_desc+"</td>");
							
							if (!show_bed_yn.equals("N"))
							{
									out.println("<td style='background-color:"+color_code_scheme+"' nowrap class='"+class_val+"'>"+bed_class_short_desc+"</td>");
									out.println("<td style='background-color:"+color_code_scheme+"' nowrap class='"+class_val+"'>"+bed_type_short_desc+"</td>");
								
							}

							
							if (!show_bed_yn.equals("N"))
							{
									if(bed_no == null) bed_no  = "&nbsp;";
									out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+bed_no+"</td>");
								
								out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+room_no+"</td>");
								
							}
								out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+location_desc+"</td>");
							
							out.println("</tr>");
							prev_val  = specialty_short_desc;
							prev_val2 = practitioner_name;
							i++;
							maxRecords++;
						}//End of While
					}
				out.println("</table>");
				if(maxRecords<12 || !(rs.next())){ 
            _bw.write(_wl_block10Bytes, _wl_block10);
}else{  
            _bw.write(_wl_block11Bytes, _wl_block11);
}
				if(maxRecords==0){
            _bw.write(_wl_block12Bytes, _wl_block12);
}
					
				
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(win_height));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(win_width));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dialogTop));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(modal));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(module));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(model_window));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(routine_tfr_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(no_of_days));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(prog_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(bl_operational));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(p_practitioner_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(targetURL));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(leave_exp_dt_flag));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bed_block_period_max));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(bl_install_yn));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(bedBlock_normal));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(max_blk_type));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(setup_bl_dtls_in_ip_yn));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(allow_discharge_date));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(max_disch_period_for_predc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(chg_nurs_unit_in_assign_bed_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(sys_dt_time));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(confirmIP));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(p_service_type));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(pat_check_in_allowed_yn));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(priotity_status));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(bed_class_allowed));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(deactivate_pseudo_bed_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(dflt_blk_prd_for_tfr_out));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(bed_block_period_normal));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(change_admission_dtls));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(reserve_bed_on_tfr_yn));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(bed_block_period_max_type));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(allow_multiple_bed_for_resv_yn));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(result_count));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf( chc_for_pen_orders_bfr_dis_adv));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(dis_adv_allow_yn));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf( chc_for_pen_orders_bfr_dischrg));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(dischrg_allow_yn));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(allow_late_discharge_reason));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(disch_reason_mand_yn));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(transfer_wo_delink_yn));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonforRejection.label","common_labels")));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.RejectedBy.label","ip_labels")));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.RejectedDate.label","ip_labels")));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(deceased_date_time));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(maternal_death_yn));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(indicator));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(discharge_date_time_display));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(age));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(pre_disch_appl_yn));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(weight_on_admn_mandatory));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(chk_pen_ward_rtn_bfr_dis_adv));
            _bw.write(_wl_block77Bytes, _wl_block77);
 

					
					
					
					if(rs != null)				rs.close();
					
					if(paramstmt != null)		paramstmt.close();
					if(paramrs != null)			paramrs.close();

				}catch(Exception e)
				{
					//out.println("Exception @tryCatch : "+e.getMessage());
					e.printStackTrace();
				}
				finally
				{
						out.print("<script>if(parent.frames[1].document.forms[0]!= null)");
						out.print("if(parent.frames[1].document.forms[0].search)");
						out.print("parent.frames[1].document.forms[0].search.disabled=false</script>");
					
				}

				
				
				
				if(rs != null)				rs.close();
				if(paramstmt != null)		paramstmt.close();
				if(paramrs != null)			paramrs.close();
			}
			
			catch(Exception e)
			{ 
				//out.println("Error in MRLookupQueryResult : "+e.toString());	
				e.printStackTrace();
			}
			finally
			{
				ConnectionManager.returnConnection(con,request);
			}
	}
	else
	if(pat_class.equals("OP")||pat_class.equals("EM"))
	{ 
		
		try
			{
				// Following Code is to Check the Module with Billing Interface 
				con							= ConnectionManager.getConnection(request);
				paramstmt					= con.createStatement();
				String bed_class_allowed    = "";

				String mp_param_table		= "";
				String mp_param_colns		= "";
				String mp_param_criteria	= "";
				String mother_cut_off_age	= "";
				String mother_max_age		= "";
				String mo_install_sql		= "";
				String mo_install_yn		= "";
				String pre_disch_appl_yn	= "";//Added for the CRF -KDAH-CRF-0104  by Dharma
				String pre_dis_initiate_yn	= "";//Added for the CRF -KDAH-CRF-0104  by Dharma
				String weight_on_admn_mandatory	= ""; //Added by Dharma on Oct27th against HSA-CRF-0181 [IN:049541] 

				
				
				
				
				
				paramrs = paramstmt.executeQuery(" SELECT weight_on_admn_mandatory,pre_disch_appl_yn,bl_interfaced_yn, setup_bl_dtls_in_ip_yn, pat_check_in_allowed_yn, discharge_checklist_app_yn, diag_update_period_max_unit,	TO_CHAR (SYSDATE, 'dd/mm/rrrr hh24:mi') serverdate,priority_applicable_yn, change_bed_class_yn, bed_block_period_dis, dis_date_chk_days, deactivate_pseudo_bed_yn,       dflt_blk_prd_for_tfr_out, bed_block_period_normal, lodger_max_srl_no, lodger_next_srl_no, max_stay_of_lodger_after_disc, dflt_gate_pass_period, dflt_gate_pass_unit, max_allowed_accom_pers,change_admission_dtls, TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi') sys_dt_time, reserve_bed_on_tfr_yn,RES_RESERVE_BED_INTRAWARD_YN,bed_block_period_max, bed_block_period_max_type, allow_multiple_bed_for_resv_yn, dis_date_chk_days, ALLOW_LATE_DISCHARGE_REASON, DISCH_REASON_MAND_YN, transfer_wo_delink_yn,dis_date_chk_days_unit,CHK_FOR_PEN_ORDERS_BFR_DIS_ADV,DIS_ADV_ALLOW_YN,CHK_FOR_PEN_ORDERS_BFR_DIS,DIS_ALLOW_YN,CHK_PEN_WARD_RTN_BFR_DIS_ADV, max_disch_period_for_dc,TO_CHAR (SYSDATE - DECODE (dis_date_chk_days_unit, 'H', dis_date_chk_days / 24, dis_date_chk_days),'dd/mm/rrrr hh24:mi') allow_discharge_date"+mp_param_colns+" "+mo_install_sql+" FROM IP_PARAM "+mp_param_table+" WHERE facility_id='"+facility_id+"' "+mp_param_criteria+" ");  // "CHK_PEN_WARD_RTN_BFR_DIS_ADV" Added by Sangeetha on 9-Nov-16 for GHL-CRF-412.2
			

				while(paramrs.next()){
						Lodger_Max_RefNo				= checkForNull(paramrs.getString("lodger_max_srl_no"));
						Lodger_Next_RefNo				= checkForNull(paramrs.getString("lodger_next_srl_no"));
						Lodger_Period					= checkForNull(paramrs.getString("max_stay_of_lodger_after_disc"));
						Acc_Period						= checkForNull(paramrs.getString("dflt_gate_pass_period"));
						Acc_Period_unit					= checkForNull(paramrs.getString("dflt_gate_pass_unit"));
						IP_param_No_Acc_Persons			= paramrs.getInt("max_allowed_accom_pers");
						bl_interfaced_yn				= checkForNull(paramrs.getString("bl_interfaced_yn"));
						setup_bl_dtls_in_ip_yn			= checkForNull(paramrs.getString("setup_bl_dtls_in_ip_yn"));
						pat_check_in_allowed_yn	        = checkForNull(paramrs.getString("pat_check_in_allowed_yn"));
						priotity_status					= checkForNull(paramrs.getString("priority_applicable_yn"));
						bed_class_allowed				= checkForNull(paramrs.getString("change_bed_class_yn"));
						deactivate_pseudo_bed_yn		= checkForNull(paramrs.getString("deactivate_pseudo_bed_yn"));
						bed_block_period_dis			= paramrs.getInt("bed_block_period_dis");
						dis_date_chk_days				= paramrs.getInt("dis_date_chk_days");
						dflt_blk_prd_for_tfr_out		= paramrs.getInt("dflt_blk_prd_for_tfr_out");
						bed_block_period_normal	        = paramrs.getInt("bed_block_period_normal");
						change_admission_dtls			= paramrs.getInt("change_admission_dtls");
						sys_dt_time						= paramrs.getString("sys_dt_time");
						reserve_bed_on_tfr_yn			= checkForNull(paramrs.getString("reserve_bed_on_tfr_yn"));
						res_reserve_bed_intraward_yn	= checkForNull(paramrs.getString("RES_RESERVE_BED_INTRAWARD_YN"));
						
						bed_block_period_max			= checkForNull(paramrs.getString("bed_block_period_max"));
						bed_block_period_max_type		= checkForNull(paramrs.getString("bed_block_period_max_type"));
						allow_multiple_bed_for_resv_yn	= checkForNull(paramrs.getString("allow_multiple_bed_for_resv_yn"),"N");
						max_disch_period_for_predc		= paramrs.getInt("max_disch_period_for_dc");
						allow_discharge_date_predc		= checkForNull(paramrs.getString("allow_discharge_date"));
						discharge_checklist_app_yn		= checkForNull(paramrs.getString("discharge_checklist_app_yn"));
						dis_date_chk_days_unit			= checkForNull(paramrs.getString("dis_date_chk_days_unit"));
						diag_update_period_max_unit		= checkForNull(paramrs.getString("diag_update_period_max_unit"));
						serverdate						= checkForNull(paramrs.getString("serverdate"));
					// Below code added by venkatesh on 09/November/2011 against the KDAH-CRF-0041
						chc_for_pen_orders_bfr_dis_adv=checkForNull(paramrs.getString("CHK_FOR_PEN_ORDERS_BFR_DIS_ADV"));
						dis_adv_allow_yn=checkForNull(paramrs.getString("DIS_ADV_ALLOW_YN"));

						chk_pen_ward_rtn_bfr_dis_adv=checkForNull(paramrs.getString("CHK_PEN_WARD_RTN_BFR_DIS_ADV")); //Added by Sangeetha on 9-Nov-16 for GHL-CRF-412.2
							
						// venkatesh KDAH-CRF-0041 END
						
						chc_for_pen_orders_bfr_dischrg =checkForNull(paramrs.getString("CHK_FOR_PEN_ORDERS_BFR_DIS"));
						dischrg_allow_yn  =checkForNull(paramrs.getString("DIS_ALLOW_YN"));

						allow_late_discharge_reason=checkForNull(paramrs.getString("allow_late_discharge_reason"));
						disch_reason_mand_yn=checkForNull(paramrs.getString("disch_reason_mand_yn"));
						transfer_wo_delink_yn=checkForNull(paramrs.getString("transfer_wo_delink_yn"));//Added for the CRF HSA-CRF-0035
						
						if(call_function.equals("PrepareDischargeAdvice")){
							mother_cut_off_age			= checkForNull(paramrs.getString("mother_cut_off_age"));
							mother_max_age				= checkForNull(paramrs.getString("mother_max_age"));
						}
						if(call_function.equals("CANCEL_DISCHARGE_PATIENT"))
							mo_install_yn				=  checkForNull(paramrs.getString("mo_install_yn"),"N");
						pre_disch_appl_yn	= checkForNull(paramrs.getString("pre_disch_appl_yn"));//Added for the CRF -KDAH-CRF-0104  by Dharma
						weight_on_admn_mandatory = checkForNull(paramrs.getString("weight_on_admn_mandatory"));//Added by Dharma on Oct27th against HSA-CRF-0181 [IN:049541] 
						
				}	

				if(paramrs != null)			paramrs.close();
				if(paramstmt != null)		paramstmt.close();
				//Added by kishore on 5/15/2004
				
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block78Bytes, _wl_block78);

				try
				{

					String nurs_unit_code		= "";
					StringBuffer where_criteria = new StringBuffer();
					StringBuffer where_criteria_count = new StringBuffer();
					StringBuffer sql			= new StringBuffer();
					String class_val			= "QRYODDSMALL";
					String bl_install_yn		=	checkForNull(request.getParameter("bl_install_yn"));
					String bedBlock_normal		=	checkForNull(request.getParameter("bedBlock_normal"));
					String max_blk_type			=	checkForNull(request.getParameter("max_blk_type"));
					String whereClause			=	checkForNull(request.getParameter("whereclause"));
					String whereClauseCount		=	checkForNull(request.getParameter("whereclausecount"));
					String from					=	checkForNull(request.getParameter("from"));
					String to					=	checkForNull(request.getParameter("to"));
					String Qloc1			=	checkForNull(request.getParameter("Qloc1"));
					String Qloctype			=	checkForNull(request.getParameter("Qloctype")); // Qloc
					String Qloc			=	checkForNull(request.getParameter("Qloc"));
					String no_of_days			=	checkForNull(request.getParameter("no_of_days"));
					String nursing_unit_code	=	checkForNull(request.getParameter("nursing_unit"));
					String from_nursing_unit	=	checkForNull(request.getParameter("from_nursing_unit"));
					String to_nursing_unit_code	=	checkForNull(request.getParameter("to_nursing_unit"));
					String to_Splcode			=	checkForNull(request.getParameter("to_Splcode"));
					String speciality_code		=	checkForNull(request.getParameter("speciality_code")); // practid_desc
					String from_Splcode			=	checkForNull(request.getParameter("from_Splcode"));
					String encounter_id			=	checkForNull(request.getParameter("encounter_id1"));
					
					String practitioner_id		=	checkForNull(request.getParameter("practid1")); 
					String from_practid			=	checkForNull(request.getParameter("from_practid"));
					String from_date			=	checkForNull(request.getParameter("from_date1"));
					if(!from_date.equals(""))
						from_date = DateUtils.convertDate(from_date,"DMY",locale,"en"); 
					String to_date				=	checkForNull(request.getParameter("to_date1"));
					if(!to_date.equals(""))
						to_date = DateUtils.convertDate(to_date,"DMY",locale,"en"); 
					String chk_in_lodger_min_date= checkForNull(request.getParameter("chk_in_lodger_min_date"));
					String patient_id			=	checkForNull(request.getParameter("patient_id"));
					String gender				=	checkForNull(request.getParameter("gender"));
					String Modified_By				=	checkForNull(request.getParameter("user_name"));
					String modified_date_from	=	checkForNull(request.getParameter("modified_from_date"));
					if(!modified_date_from.equals(""))
						modified_date_from = DateUtils.convertDate(modified_date_from,"DMY",locale,"en"); 
					String modified_date_to		=	checkForNull(request.getParameter("modified_to_date"));
					if(!modified_date_to.equals(""))
						modified_date_to = DateUtils.convertDate(modified_date_to,"DMY",locale,"en"); 
					
					String name_prefix			=	checkForNull(request.getParameter("name_prefix"));
					String name_suffix			=	checkForNull(request.getParameter("name_suffix"));
					String first_name			=	checkForNull(request.getParameter("first_name"));
					String second_name			=	checkForNull(request.getParameter("second_name"));
					String third_name			=	checkForNull(request.getParameter("third_name"));
					String family_name			=	checkForNull(request.getParameter("family_name"));
					//Added by kumar on 18/03/2003 for Malaysia Enhancements
					String searchby				=	checkForNull(request.getParameter("`"), "S");
					String pat_name_as_multipart_yn = checkForNull(request.getParameter("pat_name_as_multipart_yn"));
					String patient_name			= "";
					String nursing_unit_short_desc= "";
					String service_short_desc	= "";
					String subservice_short_desc="";
					String bed_no				= "";
					int baby_count				= 0;
					String room_no				= "";
					String bed_class_short_desc	= "";
					String bed_type_short_desc	= "";
					String to_nursing_unit_short_desc = "";
					String to_bed_class_short_desc = "";
					String to_bed_type_short_desc = "";
					String blocked_bedno		= "";
					String specialty_short_desc	= "";
					String referral_id			= "";
					String practitioner_name	= "";
					String prev_val				= "";
					String prev_val2			= "";
					String Sex					= "";
					String visit_adm_date_time	= "";
					String adm_date_display		= "";
					String discharge_date_time	= "";
					String adt_status			= "";
					String patient_status		= "";
					String ip_leave_status		= "";
					String leave_exp_dt			= "";
					String leave_exp_dt_flag	= "N";
					String date_of_birth		= "";
					String priority				= "";
					String priority_code		= "";
					String pat_dtls_unknown_yn	= "";
					String contact1_name		= "";
					String contact2_name		= "";


					//Added by Devang for Spl. chars
					name_prefix				= singleToDoubleQuotes(name_prefix);
					name_suffix				= singleToDoubleQuotes(name_suffix);
					nursing_unit_code		= singleToDoubleQuotes(nursing_unit_code);
					from_nursing_unit		= singleToDoubleQuotes(from_nursing_unit);
					from_Splcode			= singleToDoubleQuotes(from_Splcode);
					speciality_code			= singleToDoubleQuotes(speciality_code);
					to_nursing_unit_code	= singleToDoubleQuotes(to_nursing_unit_code);
					to_Splcode				= singleToDoubleQuotes(to_Splcode);
					from_practid			= singleToDoubleQuotes(from_practid);
					practitioner_id			= singleToDoubleQuotes(practitioner_id);
					String jsp_name			= checkForNull(request.getParameter("jsp_name"));
					//out.println("jsp_name:"+jsp_name);
					String called_from		= checkForNull(request.getParameter("called_from"));
					String win_height		= checkForNull(request.getParameter("win_height"));
					String dialogTop		= checkForNull(request.getParameter("dialogTop"));
					String win_width		= checkForNull(request.getParameter("win_width"));
					String modal			= checkForNull(request.getParameter("modal"));
					//out.println("modal:"+modal);
					String module			= checkForNull(request.getParameter("module"));
					String model_window		= checkForNull(request.getParameter("model_window"));
				//	String function_id		= checkForNull(request.getParameter("function_id"));


					String prog_id			= checkForNull(request.getParameter("prog_id"));
					String p_practitioner_id= checkForNull(request.getParameter("practitioner_id"));
					call_func				= checkForNull(request.getParameter("call_function"));
					String Disc_Chk			= checkForNull(request.getParameter("Disc_Chk"));
					String bed_class_code	= checkForNull(request.getParameter("Bedcode"));
					String bed_type_code	= checkForNull(request.getParameter("bed_type_code"));
					String cancelled_id		= checkForNull(request.getParameter("cancel_pract_id")); 
					String cancel_reason_desc		= "";
					String discharge_type_desc		= "";
					String discharge_status_desc	= "";
					String location_desc	= "";
					String location_type = "";
					String patient_class	= "";
					//out.println("whereClause::"+whereClause);
						 



					
					
            _bw.write(_wl_block8Bytes, _wl_block8);

					if(whereClause.equals(""))
					{
						
								where_criteria.append(" where a.facility_id='");
								where_criteria.append(facility_id);
								where_criteria.append("' ");
							
							
							
							
						

					

						
						/*if(!wherecondn.equals(""))
						{
							
								if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
								{
										where_criteria.append(" and a.nursing_unit_code='"+nursing_unit_code+"' ");
									
								}
								else
								{
										where_criteria.append(" and exists (Select locn_code from AM_OS_USER_LOCN_ACCESS_VW b where b.facility_id = a.facility_id and b.locn_code = a.nursing_unit_code and b.locn_type = 'N' and b.oper_stn_id='"+oper_stn_id+"' and b.appl_user_id='"+login_user+"' ");

																		
											where_criteria.append(" and b.");
											where_criteria.append(wherecondn);
											where_criteria.append("='Y' )"); 

								}
							
							
						}*/
						//else
						//{				
							if(Qloc!=null && !Qloc.equals(""))
							{
									where_criteria.append(" and a.ASSIGN_CARE_LOCN_CODE='");
									where_criteria.append(Qloc);
									where_criteria.append("' ");
								
							}
						//}
						
						
							if(speciality_code!=null && !speciality_code.equals(""))
							{
									where_criteria.append(" and specialty_code='");
									where_criteria.append(speciality_code);
									where_criteria.append("' ");
							}

							if(practitioner_id!=null && !practitioner_id.equals(""))
							{
									
									
										where_criteria.append(" and a.attend_practitioner_id='");
										where_criteria.append(practitioner_id);
										where_criteria.append("' ");
									
									
							}
					
							if(from_date!=null && !from_date.equals(""))
							{
									where_criteria.append(" and trunc(a.VISIT_ADM_DATE_TIME) >= to_date('");
									where_criteria.append(from_date);
									where_criteria.append("' , 'dd/mm/rrrr') ");
								
							}	
							if(to_date!=null && !to_date.equals(""))
							{
									where_criteria.append(" and trunc(a.VISIT_ADM_DATE_TIME) <= to_date('");
									where_criteria.append(to_date);
									where_criteria.append("' , 'dd/mm/rrrr') ");
								
							}
								
							
						

						
							if(patient_id!=null && !patient_id.equals("")){
								
									where_criteria.append(" and a.patient_id like '");
									where_criteria.append(patient_id);
									where_criteria.append("%' ");
								
							}

							if(encounter_id != null && !encounter_id.equals(""))
							{
									where_criteria.append(" and a.encounter_id='");
									where_criteria.append(encounter_id);
									where_criteria.append("' ");
								
							}	

							

							

							
								
								
						
						
					
								

						if( clinic_list.length() >= 4)
						{
							where_criteria.append(" and nursing_unit_code in ");
							where_criteria.append(clinic_list);
							where_criteria.append("");
						}

						
						
					}//E.O BUILDING WHERE-CLAUSE
					else
					{
						where_criteria.append( whereClause) ;
						where_criteria_count.append( whereClauseCount) ;
					}
					int start = 0 ;
					int end = 0 ;
					int i=1;
					
					if (from.equals(""))
						start = 1 ;
					else
						start = Integer.parseInt( from ) ;
					
					if (to.equals(""))
						end = 12 ;
					else
						end = Integer.parseInt( to ) ;
					

					
					
							
							
									String order_by = "";
									
									if(sql.length() > 0) sql.delete(0,sql.length());
								
									//sql.append(" select a.pre_dis_initiate_yn,a.room_num room_no, ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2) bed_class_short_desc, ip_get_desc.ip_bed_type(a.bed_type_code,'"+locale+"',2)bed_type_short_desc, to_char(a.admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time, b.sex gender, am_get_desc.am_speciality(a.specialty_code,'"+locale+"',2) specialty_short_desc, a.nursing_unit_code, am_get_desc.am_practitioner(a.attend_practitioner_id, '"+locale+"', 1) practitioner_short_name, a.encounter_id, a.patient_id, to_char(b.date_of_birth, 'dd/mm/rrrr hh24:mi') date_of_birth, get_age(b.date_of_birth) age , decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, ip_get_desc.ip_nursing_unit(a.facility_id, a.nursing_unit_code,'"+locale+"',2) nursing_unit_short_desc, a.bed_num bed_no, a.blocked_bed_no, a.attend_practitioner_id practitioner_id, a.oth_adt_status, a.ip_leave_status, a.leave_expiry_date_time, decode(sign(( a.leave_expiry_date_time - sysdate)),-1,'Y','N') leave_flag, DECODE (a.pat_curr_locn_type, 'N', ip_get_desc.ip_nursing_unit (a.facility_id, a.pat_curr_locn_code, '"+locale+"', 2 ), 'R', a.pat_curr_locn_code, op_get_desc.op_clinic (a.facility_id, a.pat_curr_locn_code, '"+locale+"', 1)) location_desc, a.patient_class,b.pat_dtls_unknown_yn,b.pat_ser_grp_code");
									
									
									sql.append("SELECT TO_CHAR (a.visit_adm_date_time, 'dd/mm/rrrr hh24:mi') visit_date_time,TO_CHAR (a.visit_adm_date_time, 'rrrrmmdd hh24:mi') visit_date_time1,a.encounter_id, b.patient_id, b.patient_name, DECODE (sex, 'M', 'Male', 'F', 'Female', 'U', 'Unknown') gender,DECODE (assign_care_locn_type,'C', 'Clinic','E', 'Procedure Unit')location_type,DECODE(a.assign_care_locn_type,'C', op_get_desc.op_clinic (a.facility_id, assign_care_locn_code,'"+locale+"','1'), 'E', op_get_desc.op_clinic (a.facility_id,assign_care_locn_code,'"+locale+"','1')) location_desc,am_get_desc.am_speciality(a.specialty_code,'"+locale+"',2) specialty_short_desc,am_get_desc.am_practitioner(a.attend_practitioner_id, '"+locale+"', 1) practitioner_short_name ");
									
									
									
									

									
									

									
									sql.append("  from  pr_encounter a, mp_patient b ");

									

									
									sql.append(" "+where_criteria.toString()+" AND a.patient_id = b.patient_id ");
												
										sql.append(" and a.patient_class in('"+pat_class+"') and visit_status != '09' AND discharge_date_time IS NULL  ")	;	
											

										

										order_by = " order by specialty_short_desc, practitioner_short_name, visit_date_time1 DESC ";
									
									
										sql.append(order_by); 
								
							
						
					
				
			//out.println("sql.toString()-->"+sql.toString());
					int maxRecords=0;
			
					pstmt = con.prepareStatement(sql.toString());
					rs= pstmt.executeQuery();
					

						out.println("<table align='right' style='display:none' id='navigate_table'><tr><td align ='right'>");
						if ( !(start <= 1) ){
								out.println("<A HREF='../jsp/MRLookupQueryResult.jsp?jsp_name="+jsp_name+"&win_height="+win_height+"&win_width="+win_width+"&dialogTop="+dialogTop+"&pat_class="+pat_class+"&param="+call_function+"&no_of_days="+no_of_days+"&modal="+modal+"&from="+(start-12)+"&to="+(end-12)+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"&whereclausecount="+URLEncoder.encode(where_criteria_count.toString())+"&targetURL="+targetURL+"&confirmIP="+URLEncoder.encode(confirmIP)+"&called_from="+URLEncoder.encode(called_from)+"&menu_id="+URLEncoder.encode(menu_id)+"&disc_from_date="+URLEncoder.encode(disc_from_date)+"&chg_nurs_unit_in_assign_bed_yn="+chg_nurs_unit_in_assign_bed_yn+"&disc_to_date="+URLEncoder.encode(disc_to_date)+"&function_name="+URLEncoder.encode(function_name)+"&call_function="+URLEncoder.encode(call_func)+"&opst="+URLEncoder.encode(oper_stn_id)+"&function_id="+URLEncoder.encode(function_id)+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
						}
								out.println("<A  HREF='../jsp/MRLookupQueryResult.jsp?jsp_name="+jsp_name+"&win_height="+win_height+"&win_width="+win_width+"&dialogTop="+dialogTop+"&pat_class="+pat_class+"&param="+call_function+"&no_of_days="+no_of_days+"&modal="+modal+"&from="+(start+12)+"&to="+(end+12)+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"&whereclausecount="+URLEncoder.encode(where_criteria_count.toString())+"&targetURL="+targetURL+"&confirmIP="+URLEncoder.encode(confirmIP)+"&called_from="+URLEncoder.encode(called_from)+"&menu_id="+URLEncoder.encode(menu_id)+"&disc_from_date="+URLEncoder.encode(disc_from_date)+"&chg_nurs_unit_in_assign_bed_yn="+chg_nurs_unit_in_assign_bed_yn+"&disc_to_date="+URLEncoder.encode(disc_to_date)+"&function_name="+URLEncoder.encode(function_name)+"&call_function="+ URLEncoder.encode(call_func) +"&opst="+URLEncoder.encode(oper_stn_id)+"&function_id="+URLEncoder.encode(function_id)+"'"+" text-decoration='none' style='display:none' id='next'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
								out.println("</td></tr></table></p>");
								out.println("<br><br>");				
					out.println(" <table cellspacing=0 cellpadding=0 align='center' width='130%' border='1' cellpadding=0 cellspacing=0>");
				
					out.println("<thead id='table_header' style='display:none'>");
								
								out.println("<tr>");
								out.println("<th>&nbsp;</th>");
			out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VisitDate.label","common_labels")+"/"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.time.label","common_labels")+"</th>");
								
							
								out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounterid.label","common_labels")+"&nbsp;"+"</th>");
							
								out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+"&nbsp;"+"</th>");
								
								out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+"&nbsp;"+"</th>");
								out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")+"&nbsp;"+"</th>");
								out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels")+"&nbsp;"+"</th>");
								out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"&nbsp;"+"</th>");
								
							
								
								out.println("</tr>");
					out.println("</thead>");
				
							int initCount				= 1 ;
							int z						= 0 ;
							int records_to_show			= 12 ;
					if(rs!=null)
					{
						if ( start != 0 )
						{
							for( int j=1; j<start; i++,j++ )
							{
								rs.next() ;
							}
							initCount+=start;
							--initCount;
						}
									
						while (rs!=null && (z < records_to_show) && rs.next() )
						{
							
								if(maxRecords==0){
            _bw.write(_wl_block9Bytes, _wl_block9);
}//Added by kishore on 5/15/2004
								z++;
							visit_adm_date_time=rs.getString("visit_date_time");
							if(visit_adm_date_time == null) visit_adm_date_time="&nbsp;";
							if(!visit_adm_date_time.equals("&nbsp;")){
								adm_date_display = DateUtils.convertDate(visit_adm_date_time,"DMYHM","en",locale); 
							}
							n_Age = 0;
							
							
							
							encounter_id=rs.getString("encounter_id");
							if(encounter_id == null) encounter_id="";
							
							if(referral_id == null) referral_id="";

							
							
							
							Sex =rs.getString("gender");
							
							if(Sex == null )
								Sex="";
							else if (Sex.equals("Male"))
								Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
							else if (Sex.equals("Female"))
								Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
							else 
								Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

							patient_id = rs.getString("patient_id");
								if( patient_id == null) patient_id="";
							

							patient_name=rs.getString("patient_name");
							if ((patient_name == null) || (patient_name.equals("null"))) 
								patient_name="";
									

								  location_desc = rs.getString("location_desc");
									if(location_desc == null) location_desc = "&nbsp;";
								
								
								location_type = rs.getString("location_type");
									if(location_type == null) location_type = "&nbsp;";  // specialty_short_desc
								
								specialty_short_desc = rs.getString("specialty_short_desc");
									if(specialty_short_desc == null) specialty_short_desc = "&nbsp;";
									
								practitioner_name=rs.getString("practitioner_short_name");
								if((practitioner_name == null) || (practitioner_name.equals("null"))) 	practitioner_name="";
							

						 
								
							
								if(class_val.equals("QRYEVENSMALL"))
									class_val = "QRYODDSMALL";
								else
									class_val = "QRYEVENSMALL";
							
							out.println("<tr>");

							if(!(jsp_name.equals("") && modal.equals("") ) )
							{
								if(!prev_val.equals(specialty_short_desc) || !prev_val2.equals(practitioner_name) )
								{
									String disp_value = specialty_short_desc;
									if (!practitioner_name.equals(""))
										disp_value = disp_value+"/"+practitioner_name;

										
										out.println("<td class='CAGROUPHEADING' colspan='12' align='left'>"+disp_value+"</td></tr><tr>");
									
								}

								out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap> ");

								if(!call_function.equals("IPList"))
								{	
									out.print("<a href=\"javascript:closeWin('"+encounter_id+"','"+patient_id+"','N')\">+</a></td>");
								}
								
									discharge_date_time_display = "&nbsp;";
										if(!(discharge_date_time==null || discharge_date_time.equals("&nbsp;")))
											discharge_date_time_display = DateUtils.convertDate(discharge_date_time,"DMYHM","en",locale);
									
										out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+adm_date_display+"</td>");
										if(bed_no.equals("&nbsp;"))
										{
												
													out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap><a href=\"javascript:showModal('"+encounter_id+"','"+patient_id+"','"+practitioner_id+"','"+nurs_unit_code+"','"+Sex+"','"+"" +"','"+patient_class+"','"+color_code_scheme+"','"+status_value+"','"+tfr_req_stat+"','')\">"+encounter_id+"</a></td>");
										}
												
													if(pend_order_status.equals("Y")){
														result_count=1;
													}else{
														result_count=0;
													}

													out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap><a href=\"javascript:showModal('"+encounter_id+"','"+patient_id+"','"+practitioner_id+"','"+nurs_unit_code+"','"+Sex+"','"+bed_no+"','"+patient_class+"','"+color_code_scheme+"','"+status_value+"','"+tfr_req_stat+"','"+n_Age+"','','','"+discharge_date_time_display+"','"+maternal_death_yn+"','"+indicator+"','"+req_no+"','"+perm_fs_locn+"','','','','"+result_count+"','"+facility_id+"')\">"+encounter_id+"</a></td>");


												
												//10/16/2008 5089_MF-CRF-0017 enhance ment start
											
										
										
									
									
									
							}
							else
							{
								
								
								if(!prev_val.equals(specialty_short_desc) || !prev_val2.equals(practitioner_name) )
								{
									if ( !no_of_days.equals("") )		
									{ 
										String prac = rs.getString("practitioner_short_name");
										if(prac == null) prac = "";
										String disp_value = specialty_short_desc;
										if (!practitioner_name.equals(""))
											disp_value = disp_value+"/"+practitioner_name;
										String cols = "";
										
										
											cols = "13";
										

										if(bed_no.equals("")) bed_no="&nbsp;";
											out.println("<td class='CAGROUPHEADING' colspan='"+cols+"' align='left' nowrap>"+specialty_short_desc+"/"+prac+"</td></tr><tr>");
									}									
									else if ( !no_of_days.equals(""))		
									{
										
										String disp_value = specialty_short_desc;
										if (!practitioner_name.equals(""))
										disp_value = disp_value+"/"+practitioner_name;
										out.println("<td class='CAGROUPHEADING' colspan='10' align='left' nowrap>"+disp_value+"</td></tr><tr>");
									}
									else
									{
										out.println("<td class='CAGROUPHEADING' colspan='8' align='left' nowrap>"+specialty_short_desc+"/"+practitioner_name+"</td></tr><tr>");
									
									}
								}

									out.println("<td nowrap class='"+class_val+"'> ");
									String changeCallFunc = "";
									if( !no_of_days.equals("") && discharge_date_time != "&nbsp;")
										changeCallFunc = "Y";
									else
										changeCallFunc = "N";

									out.print("<a href=\"javascript:closeWin1('"+encounter_id+"','"+patient_id+"','"+changeCallFunc+"')\">");								
									out.print("+</a></td>" );
									out.println("<td nowrap class='"+class_val+"' nowrap>"+adm_date_display+"</td>");

								 discharge_date_time_display = "&nbsp;";
								if(!(discharge_date_time==null || discharge_date_time.equals("&nbsp;") || discharge_date_time.equals("")))
									discharge_date_time_display = DateUtils.convertDate(discharge_date_time,"DMYHM","en",locale);

								if (   !no_of_days.equals("") )	
								{
									
									out.println("<td nowrap class='"+class_val+"'>"+discharge_date_time_display+"</td>");
								}
									out.println("<td nowrap class='"+class_val+"'>"+encounter_id+"</td>");	
								
							}
							out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' >"+patient_id+"</td>");
							
							if ((patient_name.trim()).equals(""))
								patient_name = "&nbsp;";
							out.println("<td  class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+patient_name+"</td>");
							
							out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+Sex+"</td>");
							out.println("<td  class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+location_type+"</td>");
							
							
								out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+location_desc+"</td>");
							
							out.println("</tr>");
							prev_val  = specialty_short_desc;
							prev_val2 = practitioner_name;
							i++;
							maxRecords++;
						}//End of While
					}
				out.println("</table>");
				if(maxRecords<12 || !(rs.next())){ 
            _bw.write(_wl_block10Bytes, _wl_block10);
}else{  
            _bw.write(_wl_block11Bytes, _wl_block11);
}
				if(maxRecords==0){
            _bw.write(_wl_block79Bytes, _wl_block79);
}
					
				
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(win_height));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(win_width));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dialogTop));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(modal));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(module));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(model_window));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(routine_tfr_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(no_of_days));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(prog_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(bl_operational));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(p_practitioner_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(targetURL));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(leave_exp_dt_flag));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bed_block_period_max));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(bl_install_yn));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(bedBlock_normal));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(max_blk_type));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(setup_bl_dtls_in_ip_yn));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(allow_discharge_date));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(max_disch_period_for_predc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(chg_nurs_unit_in_assign_bed_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(sys_dt_time));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(confirmIP));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(p_service_type));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(pat_check_in_allowed_yn));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(priotity_status));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(bed_class_allowed));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(deactivate_pseudo_bed_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(dflt_blk_prd_for_tfr_out));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(bed_block_period_normal));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(change_admission_dtls));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(reserve_bed_on_tfr_yn));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(bed_block_period_max_type));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(allow_multiple_bed_for_resv_yn));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(result_count));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf( chc_for_pen_orders_bfr_dis_adv));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(dis_adv_allow_yn));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf( chc_for_pen_orders_bfr_dischrg));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(dischrg_allow_yn));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(allow_late_discharge_reason));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(disch_reason_mand_yn));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(transfer_wo_delink_yn));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonforRejection.label","common_labels")));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.RejectedBy.label","ip_labels")));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.RejectedDate.label","ip_labels")));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(deceased_date_time));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(maternal_death_yn));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(indicator));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(discharge_date_time_display));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(age));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(pre_disch_appl_yn));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(weight_on_admn_mandatory));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(chk_pen_ward_rtn_bfr_dis_adv));
            _bw.write(_wl_block77Bytes, _wl_block77);
 

					
					
					
					if(rs != null)				rs.close();
					
					if(paramstmt != null)		paramstmt.close();
					if(paramrs != null)			paramrs.close();

				}catch(Exception e)
				{
					//out.println("Exception @tryCatch : "+e.getMessage());
					e.printStackTrace();
				}
				finally
				{
						out.print("<script>if(parent.frames[1].document.forms[0]!= null)");
						out.print("if(parent.frames[1].document.forms[0].search)");
						out.print("parent.frames[1].document.forms[0].search.disabled=false</script>");
					
				}

				
				
				
				if(rs != null)				rs.close();
				if(paramstmt != null)		paramstmt.close();
				if(paramrs != null)			paramrs.close();
			}
			
			catch(Exception e)
			{ 
				//out.println("Error in MRLookupQueryResult : "+e.toString());	
				e.printStackTrace();
			}
			finally
			{
				ConnectionManager.returnConnection(con,request);
			}	
		
		
	}
	


            _bw.write(_wl_block80Bytes, _wl_block80);
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
