package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __mp2displaydate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/MP2DisplayDate.jsp", 1709119241147L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n   ";
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

    private final static java.lang.String  _wl_block6 ="\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<Script src=\"../../eOA/js/ChangeDateFor2Vw.js\" language=\"JavaScript\"></Script>\n<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<head>\n</head>\n\n<script>\nfunction disable_go1()\n{\n\t\n\tif(document.forms[0].hddTracker.value==\"MR\" || document.forms[0].hddTracker.value==\"OP_RV\")\n\t{\n\t\t\n\t\tdocument.forms[0].go.disabled=true;\n\t\tdocument.forms[0].go1.disabled=true;\n\t\tdocument.forms[0].valid_date.disabled=true;\n\t\tdocument.forms[0].valid_date1.disabled=true;\n\t\tdocument.getElementById(\"cal1\").disabled=true;\n\t\tdocument.getElementById(\"cal2\").disabled=true;\n\t}else\n\t{\n\t\tdocument.forms[0].go.disabled=false;\n\t\tdocument.forms[0].go1.disabled=false;\n\t\tdocument.forms[0].valid_date.disabled=false;\n\t\tdocument.forms[0].valid_date1.disabled=false;\n\t\tdocument.getElementById(\"cal1\").disabled=false;\n\t\tdocument.getElementById(\"cal2\").disabled=false;\n\t}\n\t\n}\n</script>\n\t\t<body onload=\'disable_go1()\' OnMouseDown=\"CodeArrest();\" onKeyDown = \'lockKey()\'>\n\t\t<form name=image>\n\t\t\n<table border=0 width=\"100%\" cellspacing=\'2\' cellpadding=\'0\'>\n\t<tr>\n\t\t<td align=\"left\" width=\"50%\" valign=\"top\">\n\t\t<table border=0 width=100% cellspacing=\'0\' cellpadding=\'0\'>\n\t\t<tr valign=\"top\">\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<input type=hidden name=\"cur_dt\" id=\"cur_dt\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\t\n \n\t\t<td width=\"100\" class=label nowrap>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\n\t\t<td width=\"150\" class=\'fields\'><input type=text id = \'date_of_expiry\' size=10 maxlength = 10 name=\'valid_date\' id=\'valid_date\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' onblur=\"DateCheck_new1(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\',this,\'0\')\"  ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" onkeypress=\"return check_val(event)\" ><img src=\"../../eCommon/images/CommonCalendar.gif\" id=\'cal1\' onClick=\"document.forms[0].date_of_expiry.select();return showCalendar(\'date_of_expiry\');\"  ><img src=\"../../eCommon/images/mandatory.gif\" align=\'center\'></img></td>\n\t\t\t\n\t\t<td width=\"100\" class=\'label\' id = day1 ><b>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</b></td>\n\t\t\n\t\t<td class=\'button\' width=\"100\" valign=\"top\">\n\t\t\n\t\t\n\t\t<input type=\'button\' name=\'go\' id=\'go\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' onClick=\"blankdatechk(this);alt_fn(\'0\');\" class=\'button\' > \n\t\t\n\t\t\n\n\t\t<input type=hidden size=\'\' name=\'gggg\' id=\'gggg\' value=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" disabled style=\'visibility:hidden\'><input type=\'button\' value=\'\' class=\'button\' onClick=\'moveforward()\' style=\'visibility:hidden\'></td>\t\t\n\t </tr>\n</table>\n\t\t</td>\n\t\n\t\t<td width=\"50%\" valign=\"top\">\n\n<table border=0 width=100% cellspacing=\'0\' cellpadding=\'0\'>\n\t<tr valign=\"top\">\n\n\t\t<td  width=\"100\" class=label nowrap>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\n\t\t<td  width=\"150\" class=fields align=\'left\'><input id = \'date_of_expiry1\' type=text size=10 maxlength = 10 name=\'valid_date1\' id=\'valid_date1\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'  onblur=\"DateCheck_new2(\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\',this,\'1\')\" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" onkeypress=\"return check_val(event)\" ><img src=\"../../eCommon/images/CommonCalendar.gif\" id=\'cal2\' onClick=\"document.forms[0].date_of_expiry1.select();return showCalendar(\'date_of_expiry1\');\" style=\'visibility\' ><img src=\"../../eCommon/images/mandatory.gif\" align=\'center\'></img></td>\n\t\t\t\n\t\t<td width=\"100\" class=\'label\' id = day2 ><b>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</b></td>\n\t\t\t\n\t\t<td  class=\'button\' width=\"100\">\n\t\t\t\n\t\t\t\n\t\t\t<input type=\'button\' name=\'go1\' id=\'go1\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'  onClick=\"blankdatechk(this);alt_fn(\'1\');\" class=\'button\' > \n\t\t\t\n\t\t\t<input type=\'button\' value=\'\' class=\'button\' onClick=\'moveforward()\'  style=\'visibility:hidden\'> </td>\t\t\t\n\t\t\t\n\t</tr>\n</table>\n\t\t</td>\n\t</tr>\n\t\t</table>\n\t\t<input type=\'hidden\' name=\'move\' id=\'move\' value=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" >\n\t\t<input type=\'hidden\' name=\'clinic1\' id=\'clinic1\' value=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" >\n\t\t<input type=\'hidden\' name=\'practitioner1\' id=\'practitioner1\' value=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" >\n\t\t<input type=\'hidden\' name=\'clinic2\' id=\'clinic2\' value=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" >\n\t\t<input type=\'hidden\' name=\'practitioner2\' id=\'practitioner2\' value=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" >\n\t\t<input type=\'hidden\' name=\'date1\' id=\'date1\' value=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" >\n\t\t<input type=\'hidden\' name=\'changed_date\' id=\'changed_date\' value=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" >\n\t\t<input type=\'hidden\' name=\'ref_no\' id=\'ref_no\' value=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" >\n\t\t<input type=\'hidden\' name=\'reason_for_revise\' id=\'reason_for_revise\' value=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" >\n\t\t<input type=\'hidden\' name=\'old_clinic\' id=\'old_clinic\' value=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" >\n\t\t<input type=\'hidden\' name=\'old_practitioner\' id=\'old_practitioner\' value=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" >\n\t\t<input type=\'hidden\' name=\'Param\' id=\'Param\' value=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" >\n\t\t<input type=\'hidden\' name=\'hddTracker\' id=\'hddTracker\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' >\n\t\t<input type=\'hidden\' name=\'ca_patient_id\' id=\'ca_patient_id\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' >\n\t\t<input type=\'hidden\' name=\'ca_mode\' id=\'ca_mode\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' >\n\t\t<input type=\'hidden\' name=\'old_date\' id=\'old_date\' value=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" >\n\t\t<input type=\'hidden\' name=\'old_from_time\' id=\'old_from_time\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' >\n\t\t<input type=\'hidden\' name=\'old_to_time\' id=\'old_to_time\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' >\n\t\t<input type=\'hidden\' name=\'mode_find\' id=\'mode_find\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' >\n\t\t<input type=\'hidden\' name=\'pre_pat_alcn_catg_code\' id=\'pre_pat_alcn_catg_code\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' >\n\t\t<input type=\"hidden\" name=\"clinic_type1\" id=\"clinic_type1\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t<input type=\"hidden\" name=\"res_type1\" id=\"res_type1\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t\t<input type=\"hidden\" name=\"clinic_type2\" id=\"clinic_type2\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t\t<input type=\"hidden\" name=\"res_type2\" id=\"res_type2\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t\t<input type=\"hidden\" name=\"alcn_criteria\" id=\"alcn_criteria\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\t<input type=\"hidden\" name=\"slot_appt_ctrl\" id=\"slot_appt_ctrl\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t\t<input type=\"hidden\" name=\"visit_limit_rule\" id=\"visit_limit_rule\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t\t<input type=\"hidden\" name=\"override_no_of_slots_yn\" id=\"override_no_of_slots_yn\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t\t<input type=\"hidden\" name=\"oper_stn_id\" id=\"oper_stn_id\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t\t<input type=\'hidden\' name=\"req_id\" id=\"req_id\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t\t<input type=\"hidden\" name=\"install_yn_val\" id=\"install_yn_val\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t<input type=\"hidden\" name=\"from_facility_id\" id=\"from_facility_id\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t\t<input type=\"hidden\" name=\"from_encounter_id\" id=\"from_encounter_id\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t\t<input type=\"hidden\" name=\"contact_num_reqd_yn\" id=\"contact_num_reqd_yn\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t\t<input type=\"hidden\" name=\'min_ela_per_resc_noshow_in_day\' id=\'min_ela_per_resc_noshow_in_day\' value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>\n\t\t<input type=\"hidden\" name=\'noshow_ctrl_by_splty_or_clinic\' id=\'noshow_ctrl_by_splty_or_clinic\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>\n\t\t<input type=\"hidden\" name=\'capture_fin_dtls_yn\' id=\'capture_fin_dtls_yn\' value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>\n\t\t<input type=\"hidden\" name=\'no_of_noshow_appts_for_alert\' id=\'no_of_noshow_appts_for_alert\' value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>\n\t\t<input type=\"hidden\" name=\'per_chk_for_no_show_alert\' id=\'per_chk_for_no_show_alert\' value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>\n\t\t<input type=\"hidden\" name=\'speciality\' id=\'speciality\' value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\n\t\t<input type=\"hidden\" name=\'clinic_old\' id=\'clinic_old\' value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>\n\t\t<input type=\"hidden\" name=\'practitioner_old\' id=\'practitioner_old\' value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'>\n\t\t<input type=\"hidden\" name=\'practitioner_type\' id=\'practitioner_type\' value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'>\n\t\t<input type=\"hidden\" name=\'pref_start_date\' id=\'pref_start_date\' value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'>\n\t\t<input type=\"hidden\" name=\'pref_end_date\' id=\'pref_end_date\' value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'>\n\t\t<input type=\"hidden\" name=\'care_locn_ind\' id=\'care_locn_ind\' value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'>\n\t\t<input type=\"hidden\" name=\'visittype\' id=\'visittype\' value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'>\n\t\t<input type=\"hidden\" name=\'no_dwm\' id=\'no_dwm\' value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'>\n\t\t<input type=\"hidden\" name=\'dwm_desc\' id=\'dwm_desc\' value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'>\n\t\t<input type=\"hidden\" name=\'or_catalogue_code\' id=\'or_catalogue_code\' value=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'>\n\t\t<input type=\"hidden\" name=\'position\' id=\'position\' value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\'>\n\t\t<input type=\"hidden\" name=\'addtl_splty\' id=\'addtl_splty\' value=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\'>\n\t\t<input type=\"hidden\" name=\'rd_appt_yn\' id=\'rd_appt_yn\' value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'>\n";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block2Bytes, _wl_block2);
       // Modified for CRF - SRR -0425 -- Order Catalog.


        request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
    	String locale=(String)session.getAttribute("LOCALE");
		String mode_find="";
		String valid_date_display1="";
		String valid_date_display2="";
		mode_find=(String)request.getParameter("mode_find");
		if(mode_find==null || mode_find.equals("null")) mode_find="";
		String pre_pat_alcn_catg_code = request.getParameter("pre_pat_alcn_catg_code");
		if( pre_pat_alcn_catg_code == null) pre_pat_alcn_catg_code="";
		String clinic_code1=(String)request.getParameter("clinic_code1");
		String practitioner_id1=(String)request.getParameter("practitioner_id1");
		String clinic_code2=(String)request.getParameter("clinic_code2");
		String practitioner_id2=(String)request.getParameter("practitioner_id2");
		String create_wait_list_yn=request.getParameter("create_wait_list_yn");
			if(create_wait_list_yn ==null) create_wait_list_yn="";
		String date=(String)request.getParameter("Date");
		String date1=(String)request.getParameter("Date1");
		if(date1 == null)date1=date;
		String or_catalogue_code=request.getParameter("or_catalogue_code")==null?"":request.getParameter("or_catalogue_code");
		String value12=(String)request.getParameter("value12");
		if(value12 == null)value12="";
		String value13=(String)request.getParameter("value13");
		if(value13 == null) value13="";

		String old_clinic=(String)request.getParameter("old_clinic");
		if(old_clinic  == null || old_clinic.equals("null"))old_clinic="";

		String old_practitioner=(String)request.getParameter("old_practitioner");
		if(old_practitioner== null || old_practitioner.equals("null"))old_practitioner="";

		String Param=(String)request.getParameter("Param");
		if(Param == null || Param.equals("null")) Param="";

		String old_from_time = request.getParameter("old_from_time");
		if( old_from_time == null) old_from_time="";

		String old_to_time = request.getParameter("old_to_time");
		if( old_to_time == null) old_to_time="";

		String old_date=(String)request.getParameter("old_date");
		if(old_date  == null || old_date.equals("null")) old_date="";

		String valid_date = request.getParameter("valid_date");
		if( valid_date == null) valid_date="";


		String sysdate="";
		String ca_mode = request.getParameter("ca_mode");
		if(( ca_mode == null) || ca_mode.equals(""))  ca_mode="";
		String read_only_date="";

		String callingMode= request.getParameter("callingMode");
		String ca_patient_id=request.getParameter("ca_patient_id");

		String clinic_type2=request.getParameter("clinic_type2");
		String res_type2=request.getParameter("res_type2");

		String clinic_type1=request.getParameter("clinic_type1");
		String res_type1=request.getParameter("res_type1");


		if (clinic_type1==null) clinic_type1 = "C";
		if (res_type1==null) res_type1 = "P";

		if (clinic_type2==null) clinic_type2 = "C";
		if (res_type2==null) res_type2 = "P";

		String oper_stn_id=request.getParameter("oper_stn_id");
		if(oper_stn_id == null) oper_stn_id="";



		//MR by suman 
		String req_id=request.getParameter("req_id");
		if(req_id ==null) req_id="";
			String install_yn_val=request.getParameter("install_yn_val");
		if(install_yn_val ==null) install_yn_val="";


			 String from_facility_id= request.getParameter("from_facility_id");
		     if(from_facility_id ==null) from_facility_id="";
			String from_encounter_id= request.getParameter("from_encounter_id");
			if(from_encounter_id ==null) from_encounter_id="";


			 /*
			   Capture Fin Dtls YN Added On 4/24/2008  
			   Providing Common Capture Fin Dtls YN to Both Display Date && Resultpage
			   To Avoid Script Errors in ChangeDateFor2Vw.js
			*/

			String speciality=request.getParameter("speciality");
	        if(speciality ==null) speciality="";
            String clinic_old=request.getParameter("clinic_old");
			if(clinic_old ==null) clinic_old="";
			String practitioner_old=request.getParameter("practitioner_old");
		   if(practitioner_old ==null) practitioner_old="";
		   String practitioner_type=request.getParameter("practitioner_type");
		   if(practitioner_type ==null) practitioner_type="";
		   String pref_start_date=request.getParameter("pref_start_date");
			if(pref_start_date ==null) pref_start_date="";
			String pref_end_date=request.getParameter("pref_end_date");
			if(pref_end_date ==null) pref_end_date="";
			String care_locn_ind=request.getParameter("care_locn_ind");
			if(care_locn_ind ==null) care_locn_ind="";
			String visittype=(String)request.getParameter("visittype");
	        if(visittype == null || visittype.equals("null")) visittype ="";
			String no_dwm=request.getParameter("no_dwm");
			if(no_dwm ==null) no_dwm="";
			String dwm_desc=request.getParameter("dwm_desc");
	        if(dwm_desc ==null) dwm_desc="";
			String slot_appt_ctrl=request.getParameter("slot_appt_ctrl")==null?"":request.getParameter("slot_appt_ctrl");
			String visit_limit_rule=request.getParameter("visit_limit_rule")==null?"":request.getParameter("visit_limit_rule");
			String alcn_criteria=request.getParameter("alcn_criteria")==null?"":request.getParameter("alcn_criteria");
			String override_no_of_slots_yn=request.getParameter("override_no_of_slots_yn")==null?"":request.getParameter("override_no_of_slots_yn");
			String capture_fin_dtls_yn=request.getParameter("capture_fin_dtls_yn")==null?"N":request.getParameter("capture_fin_dtls_yn");
			String min_ela_per_resc_noshow_in_day=request.getParameter("min_ela_per_resc_noshow_in_day")==null?"":request.getParameter("min_ela_per_resc_noshow_in_day");
			String noshow_ctrl_by_splty_or_clinic=request.getParameter("noshow_ctrl_by_splty_or_clinic")==null?"":request.getParameter("noshow_ctrl_by_splty_or_clinic");
			String contact_num_reqd_yn=request.getParameter("contact_num_reqd_yn")==null?"N":request.getParameter("contact_num_reqd_yn");
			String no_of_noshow_appts_for_alert=request.getParameter("no_of_noshow_appts_for_alert")==null?"":request.getParameter("no_of_noshow_appts_for_alert");
			String per_chk_for_no_show_alert=request.getParameter("per_chk_for_no_show_alert")==null?"":request.getParameter("per_chk_for_no_show_alert");
			String position=request.getParameter("position")==null?"":request.getParameter("position");
			String addtl_splty=request.getParameter("addtl_splty")==null?"":request.getParameter("addtl_splty");
			String rd_appt_yn=request.getParameter("rd_appt_yn")==null?"N":request.getParameter("rd_appt_yn");

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

				Connection con = null;
				Statement stmt = null;
				ResultSet rs=null;
		
		
try
{
		con = ConnectionManager.getConnection(request);
				 stmt = con.createStatement();

		String sql_date="select to_char(sysdate,'dd/mm/yyyy') sys_date,to_char(to_date('"+valid_date+"','dd/mm/yyyy'),'Day') day1,to_char(to_date('"+date1+"','dd/mm/yyyy'),'Day') day2,replace(to_char(to_date('"+date+"','dd/mm/yyyy'), 'Day, Month,dd,yyyy'),' ','') from dual";
		rs=stmt.executeQuery(sql_date);

		rs.next();
		sysdate=rs.getString("sys_date");
		String day1=rs.getString("day1");
		String day2=rs.getString("day2");
		String display=rs.getString("sys_date");
		if(rs !=null) rs.close();

		day1=day1.trim();
String day_show1="";
		if(day1.equals("Sunday"))
		{
			day_show1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
		}else if(day1.equals("Monday"))
		{
			day_show1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
		}else if(day1.equals("Tuesday"))
		{
			day_show1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
		}else if(day1.equals("Wednesday"))
		{
			day_show1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
		}else if(day1.equals("Thursday"))
		{
			day_show1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
		}else if(day1.equals("Friday"))
		{
			day_show1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
		}else if(day1.equals("Saturday"))
		{
			day_show1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
		}

		valid_date_display1=DateUtils.convertDate(valid_date,"DMY","en",locale);


	day2=day2.trim();
String day_show2="";
		if(day2.equals("Sunday"))
		{
			day_show2=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
		}else if(day2.equals("Monday"))
		{
			day_show2=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
		}else if(day2.equals("Tuesday"))
		{
			day_show2=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
		}else if(day2.equals("Wednesday"))
		{
			day_show2=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
		}else if(day2.equals("Thursday"))
		{
			day_show2=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
		}else if(day2.equals("Friday"))
		{
			day_show2=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
		}else if(day2.equals("Saturday"))
		{
			day_show2=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
		}

		valid_date_display2=DateUtils.convertDate(date1,"DMY","en",locale);
		
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(valid_date_display1));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(read_only_date));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(day_show1));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(display));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(valid_date_display2));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(read_only_date));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(day_show2));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(display));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(clinic_code1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(practitioner_id1));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(clinic_code2));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(practitioner_id2));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(date1));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(date));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(value13));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(value12));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(old_clinic));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(old_practitioner ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(Param));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(ca_patient_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(ca_mode));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(old_date));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(old_from_time));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(old_to_time));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(mode_find));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(pre_pat_alcn_catg_code));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(clinic_type1));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(res_type1));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(clinic_type2));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(res_type2));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(alcn_criteria));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(slot_appt_ctrl));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(visit_limit_rule));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(override_no_of_slots_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(req_id));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(from_facility_id));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(from_encounter_id));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(contact_num_reqd_yn));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(min_ela_per_resc_noshow_in_day));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(noshow_ctrl_by_splty_or_clinic));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(capture_fin_dtls_yn));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(no_of_noshow_appts_for_alert));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(per_chk_for_no_show_alert));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(speciality));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(clinic_old));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(practitioner_old));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(pref_start_date));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(pref_end_date));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(care_locn_ind));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(visittype));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(no_dwm));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(dwm_desc));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(or_catalogue_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(position));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(addtl_splty));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block76Bytes, _wl_block76);

	if (rs != null) rs.close();
	if (stmt != null) stmt.close();
}catch(Exception e) { 
//out.println("date :" +e.toString());
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally
{
	
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block77Bytes, _wl_block77);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ScheduleDate.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Go.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ScheduleDate.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Go.label", java.lang.String .class,"key"));
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
}
