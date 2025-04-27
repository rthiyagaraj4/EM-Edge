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
import java.net.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __addmodifybookappointment extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/AddModifyBookAppointment.jsp", 1741692675274L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n﻿\n";
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

    private final static java.lang.String  _wl_block6 ="                  \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>  \n\t<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script language=\'javascript\' src=\'../../eOA/js/OAResourceComponent.js\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"> </script>\n\t\t<script src=\'../../eOA/js/BookAppointment.js\' language=\'javascript\'></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>\n \n\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<script language = \'javascript\'> \n\t\tvar PSGCodeArray = new Array(); \n\t\tvar PSGYNArray = new Array(); \n\t\tvar NamePrefixArray = new Array(); \n\t\tvar PrefixSexArray = new Array();\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\tNamePrefixArray[";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="]=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"\n\t\tPrefixSexArray[";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t</script>\n </head>\n <body onLoad=\"field();FocusFirstElement();validateFirstVisitDefault();checkMaxPatCnclReason();";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="slotTime();";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\' onunload=\"clear_from_sess()\">\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t<script>\n\t\talert(getMessage(\'BKNG_NOT_ALLOWD\',\'OA\'));\n\t\twindow.close();\n\t\t</script>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t<script>alert(getMessage(\'APPT_SRLNO_NOT_DEFINED\',\'OA\'));\n\t\tparent.window.close()\n\t\t</script>\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t<script language=\'javascript\'>\n\t\tvar err_appt =getMessage(\"MAX_APPT_SRL_NO_EXCEEDED\",\'OA\');\n\t\talert(err_appt);\n\t\tparent.window.close();\n\t\t</script>\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\talert(getMessage(\"FR_TIME_CAN_NOT_SYS_TIME\",\"OA\"));\n\t\t\t\t\t\twindow.close();\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t<center>\n\t    \t<form name=\'Bkappt_form\' id=\'Bkappt_form\' action=\'../../servlet/eOA.BookAppointmentServlet\' method=\'post\' target=\'messageFrame\'>\n\n\t\t\t\n\t\t\t<input type=\'hidden\' name=\'name_drvn_logic\' id=\'name_drvn_logic\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t\t\t<input type=\'hidden\' name=\'appt_sr_no\' id=\'appt_sr_no\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\t\t\t<input type=\'hidden\' name=\'time_table_type\' id=\'time_table_type\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t\t<input type=\'hidden\' name=\'overbooked\' id=\'overbooked\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t\t<input type=\'hidden\' name=\'starttime\' id=\'starttime\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\t\t\t<input type=\'hidden\' name=\'endtime\' id=\'endtime\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\t\t\t<input type=\'hidden\' name=\'clinic_code\' id=\'clinic_code\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t\t\t<input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t\t\t<input type=\'hidden\' name=\'natcheck\' id=\'natcheck\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'contactvals\' id=\'contactvals\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'sec_value_count\' id=\'sec_value_count\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'REC_VALUE\' id=\'REC_VALUE\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'fromtimeh\' id=\'fromtimeh\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t\t\t<input type=\'hidden\' name=\'clinic_name_sec\' id=\'clinic_name_sec\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t\t\t<input type=\'hidden\' name=\'care_locn_desc_sec\' id=\'care_locn_desc_sec\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t\t<input type=\'hidden\' name=\'res_pri_class_desc\' id=\'res_pri_class_desc\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t\t<input type=\'hidden\' name=\'pract_name_pri\' id=\'pract_name_pri\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t\t\t<input type=\'hidden\' name=\'totimeh\' id=\'totimeh\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t\t<input type=\'hidden\' name=\'maxrecord\' id=\'maxrecord\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'radbookings\' id=\'radbookings\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'ipbookings\' id=\'ipbookings\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t\t\t<input type=\'hidden\' name=\'apptdate_time\' id=\'apptdate_time\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n\t\t\t<input type=\'hidden\' name=\'apptdate\' id=\'apptdate\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\t\t\n\t\t\t<input type=\'hidden\' name=\'order_id\' id=\'order_id\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t\t\t<input type=\'hidden\' name=\'order_line_num\' id=\'order_line_num\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\t\t\n\t\t\t<input type=\'hidden\' name=\'order_catalog_code\' id=\'order_catalog_code\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t\t\t<input type=\'hidden\' name=\'from_page\' id=\'from_page\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t\t\t<input type=\'hidden\' name=\'from_page1\' id=\'from_page1\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t\t\t<input type=\'hidden\' name=\'apptrefno\' id=\'apptrefno\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n\t\t\t<input type=\'hidden\' name=\'referral_id\' id=\'referral_id\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n\t\t\t<input type=\'hidden\' name=\'allow_referral_yn\' id=\'allow_referral_yn\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\t\t\t<input type=\'hidden\' name=\'allow_non_referral_yn\' id=\'allow_non_referral_yn\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t\t\t<input type=\'hidden\' name=\"CallingMode\" id=\"CallingMode\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t\t\t<input type=\"hidden\" name=\"from_wait_list\" id=\"from_wait_list\" value =\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t\t\t<input type=\"hidden\" name=\"waitListNo\" id=\"waitListNo\" value =\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" >\n\t\t\t<input type=\"hidden\" name=\"modify_from_time\" id=\"modify_from_time\" value =\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" >\n\t\t\t<input type=\"hidden\" name=\"modify_to_time\" id=\"modify_to_time\" value =\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" >\n\t\t\t<input type=\"hidden\" name=\"or_install_yn\" id=\"or_install_yn\" value =\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" >\n\t\t\t<input type=\"hidden\" name=\"rd_appt_yn\" id=\"rd_appt_yn\" value =\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" >\n\t\t\t <input type=\"hidden\" name=\"multi_speciality_yn\" id=\"multi_speciality_yn\" value =\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" > <!-- Added for the CRF - Bru-HIMS-CRF-0198 -->\n\t\t\t<input type=\"hidden\" name=\"isVirtualCons\" id=\"isVirtualCons\" value =\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" ><!-- Added by Ajay Hatwate for ML-MMOH-CRF-1930 -->\n\t\t\t<input type=\"hidden\" name=\"isVCEnbl\" id=\"isVCEnbl\" value =\"D\" ><!-- Added by Ajay Hatwate for ML-MMOH-CRF-1930 -->\n\t\t\t\n\t\t\t<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'100%\' align=\'center\' valign=\'top\'><tr><td>\n\n\t\t\t\t\n\t<tr>\n\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t<td  class=\'label\' nowrap>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="/";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td>\n\t\t\t<!--<td  class=\'label\' nowrap width=\'20%\'>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</td>-->\n\t\t\t\t\t<td class=\'fields\'  nowrap><b>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</b><input type=\'hidden\' name=\'appt_date\' id=\'appt_date\' value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" size=\'10\' maxlength=\'10\'>&nbsp;<input type=\'text\' name=\'From_timeval\' id=\'From_timeval\' value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" size=\'3\' maxlength=\'5\' onBlur=\'CheckTime(this,\"FM\")\' onKeyUp=\"javascript:formatTimePerPatient(this)\"> - <input type=\'text\' name=\'To_timeval\' id=\'To_timeval\' value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" size=\'3\' maxlength=\'5\' onBlur=\'CheckTime(this,\"TO\")\' onKeyUp=\"javascript:formatTimePerPatient(this)\"></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</td>\n\t\t\t\t\t\t<td class=\'fields\' nowrap width=\'28%\'><input type=\"text\" name=\"pract_override_reason_desc\" id=\"pract_override_reason_desc\" onblur=\"reasonForOverride(this,pract_override_reason_desc,\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\')\" size=\'35\' maxlength=\'30\'  ><input type=\'hidden\' name=\'pract_override_reason\' id=\'pract_override_reason\'></input><input type=\'button\' class=\'button\' value=\'?\'  name=\'search_reason\' id=\'search_reason\' onClick=\"reasonForOverrideLookup(this,pract_override_reason_desc,\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\');\"><img id = \'reason_mand\' src = \'../../eCommon/images/mandatory.gif\'></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t\t<td class=\'label\' colspan=6>&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t<!--<td  class=\'fields\'  nowrap width=\'30%\'><b>";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</b></td>-->\n\t</tr>\n\t<tr>\n\t\t\t<td  class=\'label\' nowrap width=\'25%\'>";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</td>\n\t\t\t<td  class=\'fields\'  nowrap ><b>";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</b><b>/";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</b>\n\t\t\t<input type=\'hidden\' name=\'clinic_name\' id=\'clinic_name\' value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\' size=\'15\' maxlength=\'4\'  >\n\t\t\t</td>\n\n\t\t\t<td  class=\'label\' nowrap width=\'25%\'>";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</td>\n\t\t\t<td  class=\'fields\'  nowrap ><select name = \'sel_service_code\' id = \'sel_service_code\'><option value=\"\">----------";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="---------</option>\n\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t<option value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</option>\n\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t<script>\n\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' == 1)\n\t\t\t\t\t   document.forms[0].sel_service_code.options[1].selected = true;\n\t\t\t\t\t</script>\n\t\t\t</select>\n\t\t\t</td>\t\t\t\n\n\n\t<!--<tr><td class=\'DEFAULTBLANKROW2PT\'  colspan=4>&nbsp;</td></tr>-->\n\t<tr>\n      \t\t\n\t\t\t<td  class=\'label\'  nowrap>";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</td>\n\n\t\t\t<td class=\'fields\' nowrap><select name=\'visit_type_short_desc\' id=\'visit_type_short_desc\' onChange=\"updContTabForVC(this);validateFirstVisit(this);setToTime(\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\',\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\');\" >\n\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t<option value=\'\'>--- ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =" ---\n\t\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t<option value=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="~";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\' selected>";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\n\t\t\t\t<script language=\"JavaScript\">\n\t\t\t\tvis_code_Array[";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="]\t\t= \'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\';\t\n\t\t\t\tmax_dur_Array[";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="]\t\t\t= \'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\';\n\t\t\t\tmax_appt_slots_Array[";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="]  = \'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\';\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\'>";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\';\n\t\t\t\t</script>\n\n\n\n\n\t\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\t<input type=\"hidden\" name=\"tmpCntrl\" id=\"tmpCntrl\">\n\t\t\t\t<select name=\'no_slots\' id=\'no_slots\' onchange =\'return val_multi_slot(this)\' >\n\t\t\t\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t<option value=\'\'>";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\' >";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\t\t<option value=\'\'>";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 =" \n\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t<option value=\'\'>";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t\t\n\t\t\t\n\t\t</select></td>\n\t\t\t";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t\t\t<input type=\'hidden\' name=\'no_slots\' id=\'no_slots\' value=\"0\" size=\'10\' maxlength=\'10\'></td>\n\t\t\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t\n\t\t\t\t\t<!--<td  class=\'label\' nowrap>";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="</td>\n\n\n\t\t\t\t\t<td class=\'fields\'  nowrap><b>";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\" size=\'3\' maxlength=\'5\' onBlur=\'CheckTime(this,\"FM\")\' > - <input type=\'text\' name=\'To_timeval\' id=\'To_timeval\' value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" size=\'3\' maxlength=\'5\' onBlur=\'CheckTime(this,\"TO\")\'></td>-->\n\n\t\t\t<td  class=\'label\'nowrap >";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</td>\n\n\t\t\t<!--<td class=\'fields\' nowrap><b>";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="</b></td>\n\t\t\t<td  class=\'label\'nowrap >";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="</td>-->\n\t\t\t<td class=\'fields\' nowrap><b>";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="/</b><b>";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="</b>\n\t\t\t\t<input type=\'hidden\' name=\'pame\' id=\'pame\' value=\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\' size=\'15\' maxlength=\'15\'  > \n\t\t\t\t<input type=\'hidden\' name=\'practitioner_name\' id=\'practitioner_name\' value=\'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\' size=\'15\' maxlength=\'15\'  > \n\t\t\t</td>\n\t</tr>\n\t<!--<tr><td class=\'DEFAULTBLANKROW2PT\'  colspan=4>&nbsp;</td></tr>-->\n\t<tr>\n\t\t\t\t<td  class=\"label\" nowrap>";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="</td>\n\n\t\t\t\t";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t\t\t\t\t<td class=\"fields\" nowrap ><input disabled type=\"text\"  name=\"pref_date\" id=\"pref_date\" maxlength=\"10\" size=\"10\"   value=\'\' onblur=\"validateDateTime1(this);prioritychk(this);\" onclick=\"prioritychk(this);\" ><img name=\"dob1\" id=\"dob1\" src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"if (!document.getElementById(\'pref_date\').disabled) { document.forms[0].pref_date.focus(); return showCalendar(\'pref_date\'); }\">\n\t\t\t\t\t\t\n\t\t\t\t\t<td  class=\"label\" nowrap>";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="</td>\n\t\t\t\t\t\t\n\t\t\t\t\t<td class=\"fields\" nowrap colspan=1><select name = \'priorty\' disabled><option value=\"\">----------";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="---------</option>\n\t\t\t\t\t<option value=\"U\">";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="</option>\n\t\t\t\t\t<option value=\"S\">";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="</option>\n\t\t\t\t\t<option value=\"N\">";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="</option></select><img id=\'prior\' src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t\t\t\t\t<b>";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="</b>\n\t\t\t\t\t";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t\t\t\t\t\t\n\t\t\t\t\t</td>\n\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n\t\t\t\t\t\t<td class=\"fields\" nowrap ><input type=\"text\"  name=\"pref_date\" id=\"pref_date\" maxlength=\"10\" size=\"10\"   value=\'\' onblur=\"validateDateTime1(this);prioritychk(this);\" onclick=\"prioritychk(this);\" ><img name=\"dob1\" id=\"dob1\" src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"if (!document.getElementById(\'pref_date\').disabled) { document.forms[0].pref_date.focus(); return showCalendar(\'pref_date\'); }\"></td>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td class=\"label\" nowrap>";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="</td>\t\t\t\t\t\t\t \n\t\t\t\t\t<td  class=\"fields\" nowrap colspan=1><select name = \'priorty\'><option value=\"\">----------";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n\t\t\t\t\t\t </td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t <td class=\'LABEL\'> ";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="</td>\n\t\t\t\t\t <td class=\'fields\'><input type=\'text\' name=\'ordPractDesc\' id=\'ordPractDesc\' value = \'";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\' size=30\' maxlength=\'30\' onBlur=\"getValues(pract_button,this,ordPractId)\"><input type=\'hidden\' name=\'ordPractId\' id=\'ordPractId\' value=\'";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\'><input type=\'button\' class=\'button\' readOnly name=\'pract_button\' id=\'pract_button\' value=\'?\' onClick=\"getValues(this,ordPractDesc,ordPractId)\";><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></td>\t\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\n\t\t\t<input type=\'hidden\' name=\'Forced\' id=\'Forced\' value=\'";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\'>\n\t\t\t<input type=\'hidden\' name=\'first_visit_flag\' id=\'first_visit_flag\' value=\'N\'> \n\t\t\t<input type=\'hidden\' name=\'other_visit_flag\' id=\'other_visit_flag\' value=\'N\'> \n\t\t\t<input type=\'hidden\' name=\'only_fv_allowed_flag\' id=\'only_fv_allowed_flag\' value=\'";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\'> \n\t\t\t<input type=\'hidden\' name=\'slot_appt_ctrl\' id=\'slot_appt_ctrl\' value=\'";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\'>\n\t\t\t<input type=\'hidden\' name=\'visit_limit_rule\' id=\'visit_limit_rule\' value=\'";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\'> \n\t\t\t<input type=\'hidden\' name=\'alcn_criteria\' id=\'alcn_criteria\' value=\'";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\'>\n\t\t\t<input type=\'hidden\' name=\'override_no_of_slots\' id=\'override_no_of_slots\' value=\'";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\'>\n\t\t\t<input type=\'hidden\' name=\'capture_fin_dtls_yn\' id=\'capture_fin_dtls_yn\' value=\'";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\'>\n\t\t\t<input type=\'hidden\' name=\'min_ela_per_resc_noshow_in_day\' id=\'min_ela_per_resc_noshow_in_day\' value=\'";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\'>\n\t\t\t<input type=\'hidden\' name=\'noshow_ctrl_by_splty_or_clinic\' id=\'noshow_ctrl_by_splty_or_clinic\' value=\'";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\'>\n\t\t\t<input type=\"hidden\" name=\'contact_num_reqd_yn\' id=\'contact_num_reqd_yn\' value=\'";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\'>\n\t\t\t<input type=\"hidden\" name=\'per_chk_for_no_show_alert\' id=\'per_chk_for_no_show_alert\' value=\'";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\'>\n\t\t\t<input type=\"hidden\" name=\'no_of_noshow_appts_for_alert\' id=\'no_of_noshow_appts_for_alert\' value=\'";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\'>\n\t\t\t<input type=\"hidden\" name=\'email_appl_yn\' id=\'email_appl_yn\' value=\'";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\'>\n\t\t\t<input type=\"hidden\" name=\'email_appl_for_appt_wo_pid_yn\' id=\'email_appl_for_appt_wo_pid_yn\' value=\'";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\'>\n\t\t\t<input type=\"hidden\" name=\'pat_email_appl_yn\' id=\'pat_email_appl_yn\' value=\'";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\'>\n\t\t\t<input type=\'hidden\' name=\'totime_value\' id=\'totime_value\' value=\'";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\'>\n\t\t\t<input type=\"hidden\" name=\"res_class\" id=\"res_class\" value=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\">\n\t\t\t<input type=\"hidden\" name=\"res_type\" id=\"res_type\" value=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\">\n\t\t\t<input type=\"hidden\" name=\'SecResCheck\' id=\'SecResCheck\' value=\'\'>\n\t\t\t<input type=\"hidden\" name=\"pre_admit_order_catalog_code\" id=\"pre_admit_order_catalog_code\" value =\"\" >\n\t\t\t<input type=\"hidden\" name=\"pre_admit_days\" id=\"pre_admit_days\" value =\"\" >\n\t\t\t<input type=\"hidden\" name=\"or_order_date\" id=\"or_order_date\" value =\"\" >\n\t\t\t<input type=\'hidden\' name=\'recurringDTTM\' id=\'recurringDTTM\' value=\'\' >\n\t\t\t<input type=\'hidden\' name=\'clinic_securityLevel\' id=\'clinic_securityLevel\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'patient_SecurityLevel\' id=\'patient_SecurityLevel\' value=\"\">\n\t\t\t<input type=\"hidden\" name=\'from_clear\' id=\'from_clear\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'SecurityLevel\' id=\'SecurityLevel\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'text5\' id=\'text5\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'text6\' id=\'text6\' value=\'\'>\n\t\t\t<input type=\"hidden\" name=\"sec_sel222\" id=\"sec_sel222\" value=\"\">\n\t\t\t<input type=\'hidden\' name=\'function\' id=\'function\' value=\'insert\'>\n\t\t\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'insert\'>\n\t\t\t<input type=\'hidden\' name=\'appt_ref_no\' id=\'appt_ref_no\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'ref_priority\' id=\'ref_priority\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'inpatient_yn\' id=\'inpatient_yn\' value=\'N\'> \n\t\t\t<input type=\'hidden\' name=\'maxRecord1\' id=\'maxRecord1\' value=\'\'> \n\t\t\t<input type=\'hidden\' name=\'last_encounter_id\' id=\'last_encounter_id\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'last_service_encounter_id\' id=\'last_service_encounter_id\' value=\'\'>\n\t\t\t<input type=\"hidden\" name=\"sec_req\" id=\"sec_req\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"sec_sel\" id=\"sec_sel\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"sec_sel222_final\" id=\"sec_sel222_final\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"book_apt_acr_cat_yn\" id=\"book_apt_acr_cat_yn\" value=\"N\">\t\n\t\t\t<input type=\"hidden\" name=\"chk_for_oth_appt\" id=\"chk_for_oth_appt\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"recurring_cur_select\" id=\"recurring_cur_select\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\'recur_wo_sec_res\' id=\'recur_wo_sec_res\' value=\'\'>\n\t\t\t<input type=\'Hidden\' name=\'globalFlag\' id=\'globalFlag\' value=\'\'>\n\t\t\t<input type=\'Hidden\' name=\'order_wtlt_code\' id=\'order_wtlt_code\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'no_show_date\' id=\'no_show_date\' value=\'\'>\n\t\t\t<input type=\"hidden\" name=\"recurringdays\" id=\"recurringdays\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\'pat_category\' id=\'pat_category\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'episode_type\' id=\'episode_type\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'Function_id\' id=\'Function_id\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'bl_future_admn_YN\' id=\'bl_future_admn_YN\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'bl_operation\' id=\'bl_operation\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'billing_mode\' id=\'billing_mode\' value=\'Add\'>\n\t\t\t<input type=\'hidden\' name=\'pkg_bill_type\' id=\'pkg_bill_type\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'pkg_bill_no\' id=\'pkg_bill_no\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'bl_success\' id=\'bl_success\' value=\'N\'>\n\t\t\t<input type=\'hidden\' name=\'package_flag\' id=\'package_flag\' value=\'N\'>\n\t\t\t<input type=\'hidden\' name=\'billing_group\' id=\'billing_group\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'gen\' id=\'gen\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'nationality_code\' id=\'nationality_code\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'Global\' id=\'Global\' value=\'";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\'>\n\t\t\t<input type=\'hidden\' name=\'facilityid\' id=\'facilityid\' value=\'";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\'>\n\t\t\t<input type=\'hidden\' name=\'rule_appl_yn\' id=\'rule_appl_yn\' value=\'";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\'>\n\t\t\t<input type=\'hidden\' name=\'rule_based_tr\' id=\'rule_based_tr\' value=\'";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\'>\n\t\t\t<input type=\'hidden\' name=\'patient_id_temp\' id=\'patient_id_temp\' value=\'";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\'>\n\t\t\t<input type=\'hidden\' name=\'name_prefix_temp\' id=\'name_prefix_temp\' value=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\">\n\t\t\t<input type=\'hidden\' name=\'first_name_temp\' id=\'first_name_temp\' value=\'";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\'>\n\t\t\t<input type=\'hidden\' name=\'second_name_temp\' id=\'second_name_temp\' value=\'";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\'>\n\t\t\t<input type=\'hidden\' name=\'third_name_temp\' id=\'third_name_temp\' value=\'";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\'>\n\t\t\t<input type=\'hidden\' name=\'family_name_temp\' id=\'family_name_temp\' value=\'";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\'>\n\t\t\t<input type=\'hidden\' name=\'name_suffix_temp\' id=\'name_suffix_temp\' value=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\">\n\t\t\t<input type=\'hidden\' name=\'name_prefix_oth_lang_temp\' id=\'name_prefix_oth_lang_temp\' value=\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\">\n\t\t\t<input type=\'hidden\' name=\'first_name_oth_lang_temp\' id=\'first_name_oth_lang_temp\' value=\'";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\'>\n\t\t\t<input type=\'hidden\' name=\'second_name_oth_lang_temp\' id=\'second_name_oth_lang_temp\' value=\'";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\'>\n\t\t\t<input type=\'hidden\' name=\'third_name_oth_lang_temp\' id=\'third_name_oth_lang_temp\' value=\'";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\'>\n\t\t\t<input type=\'hidden\' name=\'family_name_oth_lang_temp\' id=\'family_name_oth_lang_temp\' value=\'";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\'>\n\t\t\t<input type=\'hidden\' name=\'name_suffix_oth_lang_temp\' id=\'name_suffix_oth_lang_temp\' value=\"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\">\n\t\t\t<input type=\'hidden\' name=\'gender_temp\' id=\'gender_temp\' value=\'";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\'>\n\t\t\t<input type=\'hidden\' name=\'contact_no_temp\' id=\'contact_no_temp\' value=\'";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\'>\n\t\t\t<input type=\"hidden\" name=\"mob_num_req_yn\" id=\"mob_num_req_yn\" value =\"";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\" >\n\t\t\t<input type=\"hidden\" name=\"nationality_code_temp\" id=\"nationality_code_temp\" value =\"";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\" >\n\t\t\t<input type=\"hidden\" name=\"nat_desc_temp\" id=\"nat_desc_temp\" value =\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\" >\n\t\t\t<input type=\"hidden\" name=\"canldapptrefno\" id=\"canldapptrefno\" value =\"";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\" >\n\t\t\t<input type=\"hidden\" name=\"tempLangugaeID\" id=\"tempLangugaeID\" value =\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\" >\n\t\t\t<input type=\"hidden\" name=\"isSlotTimeAppl\" id=\"isSlotTimeAppl\" value =\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\" ><!--Added by Kamatchi S for NMC-JD-CRF-0104-->\n\t\t\t<input type=\"hidden\" name=\"or_appt_time\" id=\"or_appt_time\" value =\"";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\" ><!--Added by Kamatchi S for NMC-JD-CRF-0104-->\n\n\t</table>\n\n\n    \t\t\t<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\n\t\t\n         <tr>\n\n\t\t <td class=SECONDSELECTED id=\'patientDet\'  width=\'18%\' align=center style=\'cursor:pointer;\' nowrap onclick=\"javascript:dynFrameSize();callOnMouseClick1(this);patientDetClick();prioritychk(document.forms[0].pref_date)\"><font color=\'black\'>";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="</font></td>\n\n\n\t\t <td class=FIRSTNORMAL id=\'SecResource\'  width=\'20%\' align=center style=\'cursor:pointer;\' nowrap onclick=\"callOnMouseClick(this);show_second1();prioritychk(document.forms[0].pref_date);\" disabled><font color=\'black\'>";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="</font></td>\n\n\t\t";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\n\t\t<td class=FIRSTNORMAL id=\'financial_dtl\'  width=\'20%\' align=center style=\'cursor:pointer;\' nowrap onclick=\"callOnMouseClick2(this);call_billing_func();prioritychk(document.forms[0].pref_date);\" ><font color=\'black\'>";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="</font></td>\n\t\t<td colspan=\'1\'  width=\'50%\'>&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\n\t\t <td colspan=\'2\'  width=\'50%\'>&nbsp;</td>\n\t\t ";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\n\t\t </tr>\n\t</table>\n\n\t\t\t\n\t  \n    \t\t\t<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\t\t\t\t\n\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\'4\'>";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="</td>\n\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t    <td class=\'label\' nowrap width=\'20%\'>";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="</td>\n\n\n\t\t\t\t\t<td   class=\'fields\' colspan=\'2\'><input type=\'text\' name=\'source\' id=\'source\' value=\"";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\" size=\"14\" maxlength=\"14\" ";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="  onblur = \"if (document.forms[0].source.readOnly==false) \t\t{ChangeUpperCase(this);validpatient_refral(this,\'nonmodel\')}\" ><input type=\'button\' name=\'search1\' id=\'search1\' value=\'?\'  class=\"BUTTON\" onClick=\'OpenModel_refral()\'  id=\'ref_ser_but\' ";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 =" >\n\t\t\t\t\t</td>\n\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t</tr>\n\n\n\n\t\t\t</table>\n <div id=\'patDet\' style=\'visibility:visible\'>\n\n\t<table border=\'1\' cellpadding=\'2\' cellspacing=\'0\' width=\'100%\' align=\'center\' >\n\t\n\t\t\t<td class=\'COLUMNHEADER\' colspan=\'4\'>";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="</td>\n\t\t\n\t\t <tr>\n\t\t\t<td colspan=\'4\' >\t\n                  \t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 =" \t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 =" \t\n\t\t\t\t";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 =" \t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\t\n\t\t <tr>\n\n\t\t\t<td  id=\'blink_text\' nowrap>\n\t\t\t<font id=\'othApp\'></font>\n\t\t\t</td>\n\n\t\t\t</tr>\n\t</table>\n</div>\n\n\t<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'100%\' >\n\t\t\n\t\n\t\t<td class=\'COLUMNHEADER\' colspan=\'4\'>";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="</td>\n\n\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\n\n\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' width=\'18%\'>";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\n</td>\n\t\t\t\t\t<td class=\'fields\' nowrap width=\'28%\'><input type=\"text\" name=\"reason\" id=\"reason\" onblur=\"onblurcheck(this,reason,\'";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\')\" size=\'35\' maxlength=\'30\'  ><input type=hidden name=\'reason_for_contact\' id=\'reason_for_contact\'  size=\'30\' maxlength=\'30\' ></input><input type=\'button\' class=\'button\' value=\'?\'  name=\'search_reason\' id=\'search_reason\' onClick=\"callReasonSearch(this,reason,\'";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\');\"  >\n\t\t\t\t\t<img id = \'reason_mand\' src = \'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t</td>\t\n\n\t\t\t\t\t<td  class=\'label\' width=\'23%\' >";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="</td>\n\t\t\t\t\t\t\n\t\t\t\t\t<td class=\'fields\' width=\'23%\'><input type=\"text\"  name=\"rec_date\" id=\"rec_date\" maxlength=\"16\" size=\"13\"   value=\'\' onblur=\"validateDateTime(this)\"><img  style=\"cursor:pointer\" name= \"dob1\" src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"document.forms[0].rec_date.select();return showCalendar(\'rec_date\',null,\'hh:mm\');\" >\t\t\t\t\t\t\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hddDTTM\" id=\"hddDTTM\" value=\"";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hddDate\" id=\"hddDate\" value=\"\">\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hddBDate\" id=\"hddBDate\" value=\"\">\n\t\t\t\t\t</td>\n\n\t\t\t\t</tr>\n\n\n\t\t\t\t<tr>\n                  <td  class=\'label\'>";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="</td>\n\t\t\t\t\n\t\t\t\t  <td  class=\'fields\'>\n\t\t\t\t\t\t<!--Added by Thamizh selvi on 9th July 2018 against ML-MMOH-CRF-1058 Start-->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\n\t\t\t\t\t\t\t<textarea name=\'remarks\' rows=\"3\" cols=\"80\" maxlength=\"1000\" onkeyup=\'return imposeMaxLength(this);\' onblur=\'makeValidString(this);\'></textarea>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="<!--End-->\n\t\t\t\t\t\t\t<input type=\'text\' name=\'remarks\' id=\'remarks\' value=\"\" size=\'40\' maxlength=\'60\' onblur=\'makeValidString(this);\' >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 =" \n\t\t\t\t  </td>\n\n\t\t\t\t  <td  class=\'label\'  >";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="</td>\n\t\t\t\t\t  \n\t\t\t\t   <td  class=\'fields\'><select name=\'mode\' id=\'mode\' >\n\t\t\t\t\t\t\t<option value=\'E\'>";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\n\t\t\t\t\t\t\t<option value=\'T\'>";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\n\t\t\t\t\t\t\t<option value=\'F\'>";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\n\t\t\t\t\t\t\t<option value=\'I\' selected>";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\n\t\t\t\t\t\t\t<option value=\'W\'>";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\n\t\t\t\t\t\t\t<option value=\'O\'>";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\n\t\t\t\t\t\t\t</select>\n\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"label\"  nowrap>";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="</td>\n\t\t\t\t\t<td class=\'fields\' ><input type=\'text\' name=\'language_desc\' id=\'language_desc\' size=\'20\' maxlength=\'20\'  onblur=\'patientLanguage(this)\'value=\"";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\"><input type=\'button\' name=\'language_button\' id=\'language_button\' value=\'?\' class=\'button\' onclick=\'patientLanguageLookup(this);\'>";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="<img id = \'lang_mand\' src = \'../../eCommon/images/mandatory.gif\'>";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="<input type=\'hidden\' name=\'language_id\' id=\'language_id\' value=\"";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\"></td>\n\t\t\t\t\t<td class=\'label\' colspan=\'2\'>&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\n\t\t\t\t<tr>\n                  <td  class=\'label\'><a href=\'javascript:PatInsModalWindow()\'>Patient Instructions</a></td>\t\n\t\t\t\t  <td  colspan=3></td>\t\t\t\t  \n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\n\t\t\t</table>\n\t<input type=\'hidden\' name=\"hddPat_id_new\" id=\"hddPat_id_new\" value=\"";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\">\n\n\t";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\n\n\t<input type=\'hidden\' name=\'pat_name_as_multipart_yn\' id=\'pat_name_as_multipart_yn\' value=\'";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\'>\n\n\t<input type=\'hidden\' name=\'practname\' id=\'practname\' value=\'";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\'>\t\n\t<input type=\'hidden\' name=\'pract_id\' id=\'pract_id\' value=\'";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\'>\n\t<input type=\'hidden\' name=\'clinic_id\' id=\'clinic_id\' value=\'";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\'>\n\t<input type=\'hidden\' name=\'book_appt_wo_pid_yn\' id=\'book_appt_wo_pid_yn\' value=\'";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\'>\n\t<input type=\'hidden\' name=\'book_appt_across_catg_yn\' id=\'book_appt_across_catg_yn\' value=\'";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\'>\n\t<input type=\'hidden\' name=\'speciality_code\' id=\'speciality_code\' value=\'";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\'>\n\t<input type=\'hidden\' name=\'entitlement_by_pat_cat_yn\' id=\'entitlement_by_pat_cat_yn\' value=\'";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\'>\n\t<input type=\"hidden\" name=\"dtl_msg_yn\" id=\"dtl_msg_yn\" value=\"";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\">\n\t<input type=\'hidden\' name=\'service_code\' id=\'service_code\' value=\'";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\'>\n\t<input type=\'hidden\' name=\'obvisit_flag\' id=\'obvisit_flag\' value=\'";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\'>\n\t<input type=\'hidden\' name=\'break_flag\' id=\'break_flag\' value=\'";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\'> \n\t<input type=\'hidden\' name=\'ip_bkgs\' id=\'ip_bkgs\' value=\'";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\'> \n\n\t<input type=\'hidden\' name=\"hddPat_id\" id=\"hddPat_id\" value=\"";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\">\n\t<input type=\'hidden\' name=\'ca_patient_id_new\' id=\'ca_patient_id_new\' value=\"";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\">\n\n\t<input type=\"hidden\" name=\"clinic_type\" id=\"clinic_type\" value=\"";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\">\n\t<input type=\"hidden\" name=\"age_group_code\" id=\"age_group_code\" value=\"";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\">\n\n\n\t<input type=\'hidden\' name=\'req_id\' id=\'req_id\' value=\'";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\'> \n\t\n\t<input type=\'hidden\' name=\'bl_operational\' id=\'bl_operational\' value=\'";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\'>\n\n\n\n\n\t    <input type=\'hidden\' name=\'visit_type_ind\' id=\'visit_type_ind\' value=\'";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\'>\n\t\n\n\n\n\n\t<input type=\'hidden\' name=\"CallingMode1\" id=\"CallingMode1\" value=\"";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\">\n\t<input type=\'hidden\' name=\"patientid_CA\" id=\"patientid_CA\" value=\"";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\">\n\t<input type=\'hidden\' name=\"CallingMode_CA\" id=\"CallingMode_CA\" value=\"";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\">\n\t<input type=\'hidden\' name=\"sys_date\" id=\"sys_date\">\n\t";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\n\t<input type=\'hidden\' name=\'hdd_referal\' id=\'hdd_referal\' value=\'";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\'>\n\t<input type=\'hidden\' name=\'ServerTime\' id=\'ServerTime\' value=\'";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\' >\n\t<input type=\"hidden\" name=\"Serverdate\" id=\"Serverdate\" value=\"";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\">\n\n\n\t<input type=\'hidden\' name=\'block_break_appt\' id=\'block_break_appt\' value=\"";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\">\n\n\t<input type=\"hidden\" name=\"or_catalogue_code\" id=\"or_catalogue_code\" value =\"";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\" >\n\t<input type=\"hidden\" name=\"order_catalog_criteria\" id=\"order_catalog_criteria\" value =\"";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\" >\n\t<input type=\'hidden\' name=\'CurrentDate\' id=\'CurrentDate\' value=\'";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\'>\n\t<input type=\'hidden\' name=\'ip_installed_yn\' id=\'ip_installed_yn\' value=\'";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\'>\n\t<input type=\'hidden\' name=\'rad_installed_yn\' id=\'rad_installed_yn\' value=\'";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\'>\n\t<input type=\'hidden\' name=\'sys_date_time\' id=\'sys_date_time\' value=\'";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\'>\n\t<input type=\'hidden\' name=\'visit_type_cnt\' id=\'visit_type_cnt\' value=\'";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\'>\n<input type=\"hidden\" name=\'from_facility_id\' id=\'from_facility_id\' value=\'";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\'>\n<input type=\"hidden\" name=\'from_encounter_id\' id=\'from_encounter_id\' value=\'";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\'>\n<input type=\"hidden\" name=\'wait_list_num\' id=\'wait_list_num\' value=\'";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\'>\n<input type=\"hidden\" name=\'send_email_yn\' id=\'send_email_yn\' value=\'";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\'>\n<input type=\"hidden\" name=\'clinicInsYN\' id=\'clinicInsYN\' value=\'";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\'>\n<input type=\"hidden\" name=\'orderInsYN\' id=\'orderInsYN\' value=\'";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\'>\n<input type=\"hidden\" name=\'orderInsStandardYN\' id=\'orderInsStandardYN\' value=\'";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\'>\n<input type=\"hidden\" name=\'patInsSelectYN\' id=\'patInsSelectYN\' value=\'N\'>\n<input type=\"hidden\" name=\'procInsSelectYN\' id=\'procInsSelectYN\' value=\'N\'>\n<input type=\"hidden\" name=\'referral_id_old\' id=\'referral_id_old\' value=\'";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\'>\n<input type=\"hidden\" name=\'entered\' id=\'entered\' value=\'N\'>\n<input type=\"hidden\" name=\'customer_id\' id=\'customer_id\' value=\'";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\'>\n<input type=\"hidden\" name=\'term_set_id\' id=\'term_set_id\' value=\'";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\'>\n<input type=\"hidden\" name=\'linking_code\' id=\'linking_code\' value=\'";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\'>\n<input type=\"hidden\" name=\'wtListControl\' id=\'wtListControl\' value=\'";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\'>\n<input type=\"hidden\" name=\'slotsFromOrder\' id=\'slotsFromOrder\' value=\'";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\'>\n\n\n<input type=\"hidden\" name=\'follow_visit_type_yn\' id=\'follow_visit_type_yn\' value=\'";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\'>\n<input type=\"hidden\" name=\'visit_ind_count\' id=\'visit_ind_count\' value=\'";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="\'>\n<input type=\"hidden\" name=\'patCnclCount\' id=\'patCnclCount\' value=\'N\'><!--Bru-HIMS CRF 169 changes -->\n<input type=\"hidden\" name=\'MaxcancelAlert\' id=\'MaxcancelAlert\' value=\'";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\'><!--Fix for regression issue on Bru-HIMS CRF 169  -->\n<input type=\"hidden\" name=\'trans_exceed_reason_code\' id=\'trans_exceed_reason_code\' value=\'\'>\n<!--Below line added by senthil -->\n<input type=\"hidden\" name=\"max_slot_default_yn\" id=\"max_slot_default_yn\" value=\"";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\">\n<input type=\"hidden\" name=\"upt_contact_dtls_mp_yn\" id=\"upt_contact_dtls_mp_yn\" value=\"";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\"><!--added changes for HSA-CRF-0226 [IN:050599]-->\n<input type=\"hidden\" name=\"upd_pat_dtls_referral_yn\" id=\"upd_pat_dtls_referral_yn\" value=\"";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\"><!--Added by Dharma  on Apr 13th 2016 against HSA-CRF-0303 [IN:054572]-->\n<input type=\"hidden\" name=\"isIncRemarksLengthAppl\" id=\"isIncRemarksLengthAppl\" value=\"";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\">\n\n\t</script>\n\t<script>\n\n\t\tif(document.forms[0].from_wait_list.value==\"Y\")\n\t\t{\n\t\t\t\n\t\t\t\n\t\t\tdocument.forms[0].pref_date.disabled=true;\n\t\t\tdocument.forms[0].search1.disabled=true;\n\t\t\tdocument.forms[0].source.disabled=true;\n\t\t\tdocument.forms[0].priorty.disabled=true;\n\t\t\tdocument.getElementById(\'dob1\').disabled=true;\n\t\t\tparent.frames[2].document.getElementById(\'ffgh\').disabled=true;\n\t\t\t\n\n\t\t\tvar xmlDoc = \"\"\n\t\t\tvar xmlHttp = new XMLHttpRequest()\n\n\t\t\txmlStr =\"<root><SEARCH wait_list_val=\\\"\"+document.forms[0].from_wait_list.value+\"\\\" wait_list_num=\\\"\"+document.forms[0].waitListNo.value+\"\\\" clinic_id=\\\"\"+document.forms[0].clinic_id.value+\"\\\" prm_res_class=\\\"\"+document.getElementById(\'res_class\').value+\"\\\" alcn_criteria_pop=\\\"\"+document.getElementById(\'alcn_criteria\').value+\"\\\"  calledFor=\'WaitList\'/></root>\"\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\")\n\t\t\txmlHttp.open(\"POST\",\"../../eOA/jsp/BookAppointmentReferral.jsp\",false)\n\t\t\t\t\txmlHttp.send(xmlDoc)\n\t\t\t\t\tresponseText=xmlHttp.responseText\n\t\t\t\t\tresponseText = trimString(responseText)\n\t\t\t\t\teval(responseText)\n\n\t\t\tif(document.getElementById(\'patient_id\').value!=\'\'){\n\n\t\t\t\t\tvar HTMLVal = new String();\n\t\t\t\t\tparent.document.frames[0].document.forms[0].nationality_code1.disabled=false;\n\n\n\t\t\t\t\tvar u=parent.document.frames[0].document.forms[0].visit_type_short_desc.value;\n\t\t\t\t\tif(u!=\'\'){\n\t\t\t\t\t\tstrVisitArray = u.split(\"~\");\n\t\t\t\t\t\tvar u1=strVisitArray[0];\n\t\t\t\t\t\tvar u2=strVisitArray[1];\n\t\t\t\t\t}else{\n\t\t\t\t\t\tu2=\'\';\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\t/*\n\t\t\t\t\tvar xmlDoc = \"\"\n\t\t\t\t\tvar xmlHttp = new XMLHttpRequest()\n\t\t\t\t\txmlStr =\"<root><SEARCH step=\'P\' pat_id=\\\"\"+document.getElementById(\'patient_id\').value+\"\\\" alcn_criteria_pop=\\\"\"+document.getElementById(\'alcn_criteria\').value+\"\\\" service_code=\\\"\"+document.getElementById(\'service_code\').value+\"\\\" clinic_code=\\\"\"+document.getElementById(\'clinic_code\').value+\"\\\" ip_installed_yn=\\\"\"+document.getElementById(\'ip_installed_yn\').value+\"\\\"\t\t\t\t\trad_installed_yn=\\\"\"+document.getElementById(\'rad_installed_yn\').value+\"\\\"\t\t\t\t\tvisit_type_cd=\\\"\"+u2+\"\\\"age_group_code=\\\"\"+document.getElementById(\"age_group_code\").value+\"\\\"\t/></root>\"\n\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\")\n\t\t\t\t\txmlHttp.open(\"POST\",\"../../eOA/jsp/BookAppointmentValidations.jsp\",false)\n\t\t\t\t\txmlHttp.send(xmlDoc)\n\t\t\t\t\tresponseText=xmlHttp.responseText\n\t\t\t\t\tresponseText = trimString(responseText)\n\t\t\t\t\teval(responseText) */\n\n\t\t\t\t/*\tvar HTML=\"<html><body><form name=\'bkapptval\' id=\'bkapptval\' method=\'post\'  action=\'../../eOA/jsp/BookAppointmentValidations.jsp\'><input type=hidden name=\'step\' id=\'step\' value=\'P\'><input type=hidden name=\'alcn_criteria_pop\' id=\'alcn_criteria_pop\' value=\'\"+document.getElementById(\'alcn_criteria\').value+\"\'><input type=hidden name=\'service_code\' id=\'service_code\' value=\'\"+document.getElementById(\'service_code\').value+\"\'><input type=hidden name=\'clinic_code\' id=\'clinic_code\' value=\'\"+document.getElementById(\'clinic_code\').value+\"\'><input type=hidden name=\'ip_installed_yn\' id=\'ip_installed_yn\' value=\'\"+document.getElementById(\'ip_installed_yn\').value+\"\'><input type=hidden name=\'rad_installed_yn\' id=\'rad_installed_yn\' value=\'\"+document.getElementById(\'rad_installed_yn\').value+\"\'><input type=hidden name=\'visit_type_cd\' id=\'visit_type_cd\' value=\'\"+u2+\"\'><input type=hidden name=\'age_group_code\' id=\'age_group_code\' value=\'\"+document.getElementById(\"age_group_code\").value+\"\'></form></body></html>\";\n\n\t\t\t\t\tparent.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',HTML);\n\t\t\t\t\tparent.messageFrame.document.bkapptval.submit();*/\n\t\t\t\t}\n\t\t\t\t\n\t\t}\n\t</script>\n\n\t\t<script>\n\t\tif(document.forms[0].CallingMode.value==\'MR\')\n\t\t{\n\t\t\tvar req_id=document.forms[0].req_id.value;\n\t\t\n\t\t\t\tdocument.forms[0].pref_date.disabled=true;\n\t\t\t\tdocument.forms[0].search1.disabled=true;\n\t\t\t\tdocument.forms[0].source.disabled=true;\n\t\t\t\tdocument.forms[0].priorty.disabled=true;\n\t\t\t\tdocument.getElementById(\'dob1\').disabled=true;\n\t\t\t\tparent.frames[2].document.getElementById(\'ffgh\').disabled=true;\n\t\t\n\t\t\t\t\t\tvar xmlDoc = \"\"\n\t\t\t\t\t\t\tvar xmlHttp = new XMLHttpRequest()\n\t\t\t\t\t\t\txmlStr =\"<root><SEARCH steps=\'Mr_appt\' req_id=\\\"\"+document.forms[0].req_id.value+\"\\\"/></root>\"\n\t\t\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\")\n\t\t\t\t\t\t\txmlHttp.open(\"POST\",\"../../eOA/jsp/getbookapptvalue.jsp\",false)\n\t\t\t\t\t\t\txmlHttp.send(xmlDoc)\n\t\t\t\t\t\t\tresponseText=xmlHttp.responseText\n\t\t\t\t\t\t\tresponseText = trimString(responseText)\n\t\t\t\t\t\t\teval(responseText)\n\t\t\n\t\t\n\t\t\n\t\t}\n\t\t\n\t\t</script>\n\n\t\t<script>\n\t\t\tif(document.forms[0].CallingMode.value==\'OP\'){\n\t\t\t\tif(document.forms[0].hdd_referal.value!=\'N\'){\n\t\t\t\t\tif(document.forms[0].source.disabled) \n\t\t\t\t\t\tdocument.forms[0].source.disabled=false;\n\n\t\t\t\t\tdocument.forms[0].source.value=document.forms[0].hdd_referal.value;\n\t\t\t\t\tdocument.forms[0].source.focus();\n\t\t\t\t\tif(document.forms[0].search1.disabled) \n\t\t\t\t\t\tdocument.forms[0].search1.disabled=false;\n\t\t\t\t\tdocument.getElementById(\'search1\').focus();\n\t\t\t\t\tdocument.getElementById(\'search1\').disabled=true;\n\n\t\t\t\t}\n\t\t\t}\n\n\t\t\n\t\t</script>\n\n\n\t\t<script>\n\t\t\t\t\n\t\t\tfunction blink_close()\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'blink_text\').style.visibility=\'hidden\';\n\t\t\t\tsetTimeout(\'blink_open()\',1000);\n\t\t\t}\n\t\t\t\n\t\t\tfunction blink_open()\n\t\t\t{\n\t\t\t\t\n\t\t\tdocument.getElementById(\'blink_text\').style.visibility=\'visible\';\n\t\t\tsetTimeout(\'blink_close()\',1000);\n\t\t  }\n\t\t  /*if(\'";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\' !=\'\')\n\t\t {\n\t\t\tvar obj=document.forms[0].source;\t\t\t\n\t\t\tvalidpatient_refral(obj,\'model1\');\n\t\t\t\n\t\t\tif(document.getElementById(\'patient_id\').value !=\"\")\n\t\t\t\tvalidpatient(\'P\');\n\n\t\t }Commented for the CRF - Bru-HIMS-CRF-169*/\n\t\t</script>\n\n\t\t </form>\n\t\t<script>\n\t\t//parent.document.getElementById(\'mainFrame\').rows = \'*,0,5%,0\';\n\t\t\t\tparent.document.getElementById(\"f_query_add_mod\").style.height=\'85vh\'\n\t\t\t\tparent.document.getElementById(\"SecondaryFrame\").style.height=\'0vh\'\n\t\t\t\tparent.document.getElementById(\"ButtonFrame\").style.height=\'5vh\'\n\t\t\t\tparent.document.getElementById(\"messageFrame\").style.height=\'0vh\'\n\t\t</script>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );


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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle	=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	

	String clinic_type=checkForNull(request.getParameter("clinic_type"),"C");
	HashMap patInstructionsMap	=(HashMap)(session.getAttribute("patInstructionsMap")==null?new HashMap():session.getAttribute("patInstructionsMap"));
	HashMap prcInstructionMap	=(HashMap)(session.getAttribute("prcInstructionMap")==null?new HashMap():session.getAttribute("prcInstructionMap"));
	patInstructionsMap.clear();
	prcInstructionMap.clear();
	session.setAttribute("patInstructionsMap", patInstructionsMap);
	session.setAttribute("prcInstructionMap", prcInstructionMap);
	String facilityid=(String)session.getValue("facility_id");
	String Resource_type="";
	String sql5="";
	//venkat
	String dtl_msg_yn="";
	//venkat
	String res_type=checkForNull(request.getParameter("res_type"),"P");
	String or_catalogue_code=request.getParameter("or_catalogue_code");//From Schedule criteria order is selected
	if(or_catalogue_code ==null || or_catalogue_code.equals("null")) or_catalogue_code="";
	String from_page =checkForNull(request.getParameter("from_page"));
	String from_page1 =checkForNull(request.getParameter("from_page1"));
	String apptrefno=checkForNull(request.getParameter("apptrefno"));
	String canldapptrefno=checkForNull(request.getParameter("canldapptrefno"));
	int visit_ind_count=0;
	int clinicInstructionsCount=1;
	String upt_contact_dtls_mp_yn="";//added changes for HSA-CRF-0226 [IN:050599]

	String upd_pat_dtls_referral_yn = ""; //Added by Dharma  on Apr 13th 2016 against HSA-CRF-0303 [IN:054572]
	
	String max_slot_default_yn=""; //Added Senthil
	
	String clinicInsYN="N";
	String orderInsYN="N";
	String orderInsStandardYN="N";
	String multi_speciality_yn="N";//Added for the CRF - Bru-HIMS-CRF-0198
	String visit_type_ind=checkForNull(request.getParameter("visit_type_ind"));
	//String referral_id=request.getParameter("referral_id");
	//if(referral_id ==null) referral_id="";
	String spec_code="";
	String age_group_code="";
	String care_locn_ind_desc="";
	if(clinic_type.equals("C")){
		care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
	}else if(clinic_type.equals("E")){
		care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
	}else if(clinic_type.equals("D")){
		care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
	}
	String res_class_desc="";
	int visit_type_cnt=0;
	String cliniccode=checkForNull(request.getParameter("clinic_code"));
	if(res_type.equals("P")){
		res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
	}else if(res_type.equals("E")){
		res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
	}else if(res_type.equals("R")){
	   res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
	}else if(res_type.equals("O")){
		res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
	}
	String dttm="";
	String Forced=request.getParameter("Forced");
	if(Forced==null || Forced.equals("null"))
		Forced="N";
	//String globaluser = (String)p.getProperty("login_user");
	String Global=request.getParameter("Global");
	if(Global==null || Global.equals("null"))
		Global="N";
	String block_break_appt=request.getParameter("block_break_appt");
	if(block_break_appt==null || block_break_appt.equals("null"))
		block_break_appt="N";
	String order_id=request.getParameter("order_id");	
	if(order_id ==null || order_id.equals("null") )order_id ="";
	String order_line_num=request.getParameter("order_line_num");
	if(order_line_num ==null || order_line_num.equals("null")) order_line_num="";
	String order_catalog_code=request.getParameter("order_catalog_code");//From Pending order schedule
	if(order_catalog_code ==null || order_catalog_code.equals("null")) order_catalog_code="";
	String ca_mode=(String) session.getValue("CallMode1");
	if(ca_mode==null) ca_mode=""; 
	//MR by suman 
	String req_id=checkForNull(request.getParameter("req_id"));
	String create_wait_list_yn=checkForNull(request.getParameter("create_wait_list_yn"));
	//String create_wait_list_yn1="";
	String visit_flag_OP=checkForNull(request.getParameter("visit_flag_OP"),"N");
	String bl_operational			= (String)session.getValue("bl_operational"); 
	String capture_fin_dtls_yn=checkForNull(request.getParameter("capture_fin_dtls_yn"));
	String noshow_ctrl_by_splty_or_clinic=checkForNull(request.getParameter("noshow_ctrl_by_splty_or_clinic"));
	String min_ela_per_resc_noshow_in_day=checkForNull(request.getParameter("min_ela_per_resc_noshow_in_day"));
	String contact_num_reqd_yn= checkForNull(request.getParameter("contact_num_reqd_yn"),"N");
	//OPCheckout
	String from_facility_id= checkForNull(request.getParameter("from_facility_id"));
	String from_encounter_id= checkForNull(request.getParameter("from_encounter_id"));
	String no_of_noshow_appts_for_alert =checkForNull(request.getParameter("no_of_noshow_appts_for_alert"));
	String per_chk_for_no_show_alert    =checkForNull(request.getParameter("per_chk_for_no_show_alert"));
	String rd_appt_yn=request.getParameter("rd_appt_yn")==null?"N":request.getParameter("rd_appt_yn");
	String MaxcancelAlert=request.getParameter("MaxcancelAlert")==null?"N":request.getParameter("MaxcancelAlert");//fix for regression issue
	if(rd_appt_yn.equals(""))rd_appt_yn="N";
	String referral_id="";
	try{
		if(!from_page.equals("modifyappt")){
			referral_id=checkForNull((String)session.getAttribute("referral_id_app"));
		}else{
			referral_id=checkForNull(request.getParameter("referral_id"));
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	//Changes for Rutnin CRF Starts
	String rule_appl_yn	=checkForNull(request.getParameter("rule_appl_yn"),"N");
	String rule_based_tr	=checkForNull(request.getParameter("rule_based_tr"),"N");
	String patient_id_temp	=checkForNull(request.getParameter("patient_id_temp"));
	String name_prefix_temp	=checkForNull(request.getParameter("name_prefix_temp"));
	String first_name_temp	=checkForNull(request.getParameter("first_name_temp"));
	String second_name_temp	=checkForNull(request.getParameter("second_name_temp"));
	String third_name_temp	=checkForNull(request.getParameter("third_name_temp"));
	String family_name_temp	=checkForNull(request.getParameter("family_name_temp"));
	String name_suffix_temp	=checkForNull(request.getParameter("name_suffix_temp"));
	
	String name_prefix_oth_lang_temp	=checkForNull(request.getParameter("name_prefix_oth_lang_temp"));
	String first_name_oth_lang_temp	=checkForNull(request.getParameter("first_name_oth_lang_temp"));
	String second_name_oth_lang_temp	=checkForNull(request.getParameter("second_name_oth_lang_temp"));
	String third_name_oth_lang_temp	=checkForNull(request.getParameter("third_name_oth_lang_temp"));
	String family_name_oth_lang_temp	=checkForNull(request.getParameter("family_name_oth_lang_temp"));
	String name_suffix_oth_lang_temp	=checkForNull(request.getParameter("name_suffix_oth_lang_temp"));
	String gender_temp		=checkForNull(request.getParameter("gender_temp"));
	String contact_no_temp	=checkForNull(request.getParameter("contact_no_temp"));
	String prefPractYN		=checkForNull(request.getParameter("prefPractYN"),"Y");
	String nationality_code_temp		=checkForNull(request.getParameter("nationality_code_temp"));
	String language_code_temp		=checkForNull(request.getParameter("language_code_temp"));
	String term_set_id			= checkForNull(request.getParameter("term_set_id"));
	String linking_code			= checkForNull(request.getParameter("linking_code")); 	
	String mob_num_req_yn	="";
	String nat_desc_temp	="";
	String lang_desc_temp	="";
	String ord_pract_id	="";

	Connection conn = null;
	Statement stmt=null;
	Statement stmt1_p =null;
	Statement stmtas=null;
	Statement stmtsrl=null;
	Statement stmtc=null;
	Statement stmt2=null;
	Statement stmt1=null;
	Statement stmt7=null;
	Statement stmtt=null;
	Statement stmtap=null;
	Statement stmtlen=null;
	Statement stmtdt=null;
	Statement stmt_visit_type=null;
	Statement stmt_service=null;
	ResultSet rsas=null;
	ResultSet rst=null;
	ResultSet rs=null;
	ResultSet rssrl=null;
	ResultSet rsc=null;
	ResultSet rs1=null;
	ResultSet rs2=null;
	ResultSet rs3=null;
	ResultSet rsap=null;
	ResultSet rslen=null;
	ResultSet rs32=null;
	ResultSet rs_nid=null;
	ResultSet rs_ser=null;
	ResultSet rs_p=null;
	ResultSet obc=null;
	ResultSet rsdt=null;
	ResultSet rs_service=null;
	PreparedStatement pstmt =null;
	String service_code="";
	String allow_referral_yn = "";
	String allow_non_referral_yn = "";
	String enableReferralID  = "";
	String readonlyReferralID = "";
	String break_flag = "N";
	String only_fv_allowed_flag = "N";
	String currentDate="";
	String locale ="";
	String email_appl_yn="";
	String email_appl_for_appt_wo_pid_yn="";
	String pat_email_appl_yn="";
	String send_email_yn="N";
	String or_install_yn="";
	String follow_visit_type_yn="Y";
	String or_appt_time="";
	String ENTITLEMENT_BY_PAT_CAT_YN="";
	String customer_id=(String)session.getValue("CUSTOMER_ID");
	String language_req_yn ="";
	String tempLangugaeID="";

	boolean isIncRemarksLengthAppl = false;//Added by Thamizh selvi on 9th July 2018 against ML-MMOH-CRF-1058
	
	boolean isOverBookingAppl = false;//Added by Ashwini on 27-May-2020 for MOHE-CRF-0017

	boolean isSlotTimeAppl = false;//Added by Kamatchi S for NMC-JD-CRF-0104

	boolean isVIRTUAL_CONSULTATION = false;//Added by Kamatchi S for ML-MMOH-CRF-1930-US008

	try{
		conn = ConnectionManager.getConnection(request);
		isIncRemarksLengthAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "OA","INCREASE_APPT_REMARKS_LENGTH");//Added by Thamizh selvi on 9th July 2018 against ML-MMOH-CRF-1058
		
		isVIRTUAL_CONSULTATION  = eCommon.Common.CommonBean.isSiteSpecific(conn,"OP","VIRTUAL_CONSULTATION");

		isOverBookingAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "OA","SCH_APPT_OVER_BOOKING");//Added by Ashwini on 27-May-2020 for MOHE-CRF-0017

		isSlotTimeAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "OA","OR_CAT_SLOT_TIME_DEF");//Added by Kamatchi S for NMC-JD-CRF-0104
		Statement stmtn = conn.createStatement();
		stmtap=conn.createStatement();
		stmtas=conn.createStatement();
		stmt1=conn.createStatement();
		locale = (String)session.getAttribute("LOCALE");
		stmt=conn.createStatement();
		//String param_sql="select EMAIL_APPL_YN,EMAIL_APPL_FOR_APPT_WO_PID_YN,CONTACT_NUM_REQD_YN,SPLT_FUT_APPT_ALERT_YN,(select ENTITLEMENT_BY_PAT_CAT_YN from mp_param where module_id='MP')ENTITLEMENT_BY_PAT_CAT_YN ,(select ord_pract_id from or_order where order_id = '"+order_id+"' ) ord_pract_id , RULE_APPL_YN, MOB_NUM_REQ_YN,LANGUAGE_REQ_YN,max_slot_default_yn,upt_contact_dtls_mp_yn FROM oa_param where module_id='OA'";
		String param_sql="select EMAIL_APPL_YN,EMAIL_APPL_FOR_APPT_WO_PID_YN,CONTACT_NUM_REQD_YN,SPLT_FUT_APPT_ALERT_YN,(select ENTITLEMENT_BY_PAT_CAT_YN from mp_param where module_id='MP')ENTITLEMENT_BY_PAT_CAT_YN, (select upd_pat_dtls_referral_yn from mp_param where module_id='MP') upd_pat_dtls_referral_yn  ,(select ord_pract_id from or_order where order_id = '"+order_id+"' ) ord_pract_id , RULE_APPL_YN, MOB_NUM_REQ_YN,LANGUAGE_REQ_YN,max_slot_default_yn,upt_contact_dtls_mp_yn FROM oa_param where module_id='OA'";
		pstmt=conn.prepareStatement(param_sql);
		rs=pstmt.executeQuery() ;
		if(rs!=null && rs.next()){
			email_appl_yn=rs.getString("EMAIL_APPL_YN")==null?"N":rs.getString("EMAIL_APPL_YN");
			email_appl_for_appt_wo_pid_yn=rs.getString("EMAIL_APPL_FOR_APPT_WO_PID_YN")==null?"N":rs.getString("EMAIL_APPL_FOR_APPT_WO_PID_YN");
			contact_num_reqd_yn=rs.getString("CONTACT_NUM_REQD_YN")==null?"N":rs.getString("CONTACT_NUM_REQD_YN");
			ENTITLEMENT_BY_PAT_CAT_YN=rs.getString("ENTITLEMENT_BY_PAT_CAT_YN");
			rule_appl_yn = rs.getString("RULE_APPL_YN")==null?"N":rs.getString("RULE_APPL_YN");
			mob_num_req_yn=rs.getString("MOB_NUM_REQ_YN")==null?"N":rs.getString("MOB_NUM_REQ_YN");
			ord_pract_id=rs.getString("ord_pract_id")==null?"N":rs.getString("ord_pract_id");
			language_req_yn=rs.getString("LANGUAGE_REQ_YN")==null?"N":rs.getString("LANGUAGE_REQ_YN");
			  //below line was added by venkatesh.S(4008) on 16-Mar-2012 anaginst Bru-HIMS-CRF-168 [IN030287]_0A
			  dtl_msg_yn=rs.getString("SPLT_FUT_APPT_ALERT_YN")==null?"N":rs.getString("SPLT_FUT_APPT_ALERT_YN");
			 //end  Bru-HIMS-CRF-168 [IN030287]_0A
			 max_slot_default_yn=rs.getString("max_slot_default_yn")==null?"N":rs.getString("max_slot_default_yn");
			 /*Above line added by senthil*/
			 upt_contact_dtls_mp_yn=rs.getString("upt_contact_dtls_mp_yn")==null?"N":rs.getString("upt_contact_dtls_mp_yn");//added changes for HSA-CRF-0226 [IN:050599]
			  upd_pat_dtls_referral_yn=rs.getString("upd_pat_dtls_referral_yn")==null?"N":rs.getString("upd_pat_dtls_referral_yn");//Added by Dharma  on Apr 13th 2016 against HSA-CRF-0303 [IN:054572]
		}
		
		if(pstmt!=null){
			pstmt.close();
		}		
		if(from_page!=null && from_page.equals("modifyappt")){ 
			String appt_pat_ins="SELECT instruction_id,instruction_desc FROM oa_appt_pat_instructions WHERE facility_id = '"+facilityid+"' AND appt_ref_no = '"+apptrefno+"' ORDER BY display_order";
			String clinicInstr="SELECT a.instruction_id,a.display_order,a.default_linked_yn,b.instruction_desc FROM op_clinic_pat_instructions a, am_pat_instructions_lang_vw b  WHERE a.facility_id = '"+facilityid+"' AND a.clinic_code = '"+cliniccode+"' AND a.instruction_id = b.instruction_id AND b.language_id = '"+locale+"' AND a.instruction_id not in(SELECT  INSTRUCTION_ID FROM OA_APPT_PAT_INSTRUCTIONS WHERE facility_id = '"+facilityid+"' AND appt_ref_no='"+apptrefno+"') ORDER BY display_order";
			if(rs!=null)rs.close();
			rs=stmt.executeQuery(appt_pat_ins);
			HashMap patInstructionsMapResult=new java.util.HashMap();
			Integer tempInteger=null;
			while(rs!=null && rs.next()){
					String instructionID=rs.getString("instruction_id");
					String instructionDesc=rs.getString("instruction_desc");
					//String valueObject=instructionID+"|~"+instructionDesc+"|~Y";
					/*Above Line Commented by Senthil on 19-Oct-2011*/
					//String valueObject=instructionID+"==>"+instructionDesc+"==>Y";
					String valueObject=instructionID+"|~"+instructionDesc+"|~"+"Y";
					tempInteger=new Integer(clinicInstructionsCount);
					patInstructionsMapResult.put(tempInteger.toString(),valueObject);
					clinicInstructionsCount++;
			}
			if(rs!=null)rs.close();
			rs=stmt.executeQuery(clinicInstr);
			while(rs!=null && rs.next()){
				String instructionID=rs.getString("instruction_id");
				String instructionDesc=rs.getString("instruction_desc");
				//String default_linked_yn=rs.getString("DEFAULT_LINKED_YN");
				
				//String valueObject=instructionID+"|~"+instructionDesc+"|~"+"N";
				/*Above Line Commented by Senthil on 19-Oct-2011*/
				//String valueObject=instructionID+"==>"+instructionDesc+"==>"+"N";
				String valueObject=instructionID+"|~"+instructionDesc+"|~"+"N";
				tempInteger=new Integer(clinicInstructionsCount);
				patInstructionsMapResult.put(tempInteger.toString(),valueObject);
				clinicInstructionsCount++;
			}
			if(rs!=null)rs.close();
			if(clinicInstructionsCount > 1){
				clinicInsYN="Y";
				session.setAttribute("patInstructionsMap", patInstructionsMapResult);
			}
			String oa_apptSql="select order_id,patient_id,language_id from oa_appt where facility_id = '"+facilityid+"' AND appt_ref_no = '"+apptrefno+"'";
			if(rs!=null)rs.close();
			rs=stmt.executeQuery(oa_apptSql);
			String tempOrderID="";
			String tempPatientID="";
			
			if(rs!=null && rs.next()){
				tempOrderID=rs.getString("order_id")==null?"":rs.getString("order_id");
				tempPatientID=rs.getString("patient_id")==null?"":rs.getString("patient_id");
				tempLangugaeID=rs.getString("language_id")==null?"":rs.getString("language_id");
			}
			//Modified against PMG20089-CRF-0885.3 - Removed the OrderID Validations on Radiology Appointment without PatientID:
			/****Below "IF" Condition Description: 
			If it is Radiology appointment with patientid, OR If it is Normal appointment, 
			then it will check if orderid exists to show instructions button.
			If it is Radiology appointment without patientid, then it will show instructions button
			*****/
			//if(tempOrderID.equals("")){
			if( (("Y".equalsIgnoreCase(rd_appt_yn)) && (tempPatientID != "") && tempOrderID.equals("")) || ("N".equalsIgnoreCase(rd_appt_yn) && tempOrderID.equals("")) ){
			}else{
				int countProcInstructions=1;
				if(rs!=null)rs.close();
				String order_stand_ins="";
				String appt_prc_ins="SELECT instruction_desc FROM oa_appt_proc_instructions WHERE facility_id = '"+facilityid+"' AND appt_ref_no = '"+apptrefno+"'";
				rs=stmt.executeQuery(appt_prc_ins);
				if(rs!=null && rs.next()){
					order_stand_ins=rs.getString("INSTRUCTION_DESC")==null?"":rs.getString("INSTRUCTION_DESC");
					countProcInstructions++;
				}
				if(countProcInstructions>1){
					orderInsYN="Y";
					prcInstructionMap.put("prcIns",order_stand_ins);
					prcInstructionMap.put("patient_id",tempPatientID);
					prcInstructionMap.put("checked","Y");
					session.setAttribute("prcInstructionMap", prcInstructionMap);
				}
			}
		}else{//book appointment
		
			String order_stand_ins="";
			String clinicInsLinkSQL="Select a.INSTRUCTION_ID,a.DISPLAY_ORDER,a.DEFAULT_LINKED_YN,b.INSTRUCTION_DESC from op_clinic_pat_instructions a,am_pat_instructions_lang_vw b where a.facility_id=? and a.clinic_code=? and a.INSTRUCTION_ID =b.INSTRUCTION_ID and b.language_id=? order by DISPLAY_ORDER";
			String orderInsLinkSQL="select * from OR_ORDER_CATALOG_PREPS_INSTRN where ORDER_CATALOG_CODE=? and PAT_PREPS_OR_INSTRNS_IND in('IS','IM')";		
			if(rs!=null)rs.close();
			pstmt=conn.prepareStatement(clinicInsLinkSQL);
			pstmt.setString(1,facilityid);
			pstmt.setString(2,cliniccode);
			pstmt.setString(3,locale);
			rs=pstmt.executeQuery();
			HashMap patInstructionsMapResult=new java.util.HashMap();
			Integer tempInteger=null;
			while(rs!=null && rs.next()){
					String instructionID=rs.getString("instruction_id");
					String instructionDesc=rs.getString("instruction_desc");
					String default_linked_yn=rs.getString("DEFAULT_LINKED_YN");
					//String valueObject=instructionID+"|~"+instructionDesc+"|~"+default_linked_yn;
					/*Above line Commented by Senthil on 19-Oct-2011*/
				    //String valueObject=instructionID+"==>"+instructionDesc+"==>"+default_linked_yn;
					String valueObject=instructionID+"|~"+instructionDesc+"|~"+default_linked_yn;
					tempInteger=new Integer(clinicInstructionsCount);
					patInstructionsMapResult.put(tempInteger.toString(),valueObject);
					clinicInstructionsCount++;
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(clinicInstructionsCount > 1){
				clinicInsYN="Y";
				session.setAttribute("patInstructionsMap", patInstructionsMapResult);
			}
			if(rs!=null)rs.close();
			if(order_catalog_code!=null && !order_catalog_code.equals("")){//from pending orders			
				orderInsLinkSQL="SELECT ORDER_LINE_FIELD_VALUE FROM or_order_line_field_values WHERE  order_line_field_mnemonic ='PATIENT_INSTRNS' and ORDER_ID=? and ORDER_LINE_NUM=?";
				pstmt=conn.prepareStatement(orderInsLinkSQL);
				pstmt.setString(1,order_id);
				pstmt.setString(2,order_line_num);
				rs=pstmt.executeQuery();
				if(rs!=null && rs.next()){
					order_stand_ins=rs.getString("ORDER_LINE_FIELD_VALUE");
					prcInstructionMap.put("prcIns",order_stand_ins);
					prcInstructionMap.put("checked","Y");
					session.setAttribute("prcInstructionMap", prcInstructionMap);
					orderInsYN="Y";
				}
				if(pstmt!=null){
					pstmt.close();
				}
			}else if(or_catalogue_code!=null && !or_catalogue_code.equals("")){
				pstmt=conn.prepareStatement(orderInsLinkSQL);
				pstmt.setString(1,or_catalogue_code);
				rs=pstmt.executeQuery();
				while(rs!=null && rs.next()){
	//	if(rs.getString("PAT_PREPS_OR_INSTRNS_IND").equals("IS")){
	//Above line commented and below line Added for this incident  [IN:043350]
	if(rs.getString("PAT_PREPS_OR_INSTRNS_IND").equals("IS") && !checkForNull(rs.getString("PAT_PREPS_OR_INSTRNS_TXT")).equals("")){ 
	
						orderInsStandardYN="Y";
						order_stand_ins=rs.getString("PAT_PREPS_OR_INSTRNS_TXT");
						prcInstructionMap.put("prcIns",order_stand_ins);
						prcInstructionMap.put("checked","Y");
						orderInsYN="Y";
						session.setAttribute("prcInstructionMap", prcInstructionMap);
					}else{
						orderInsYN="Y";
					}
					break;
				}
				if(pstmt!=null){
					pstmt.close();
				}
			}
			if(rule_appl_yn.equals("Y")){
				String lan_natSQL="select (select long_desc description from mp_country_lang_vw where COUNTRY_CODE='"+nationality_code_temp+"' and language_id='"+locale+"')country_desc,(Select LONG_DESC description from MP_LANGUAGE_LANG_VW where  MP_LANGUAGE_ID='"+language_code_temp+"' and language_id='"+locale+"')lang_desc from dual";
				if(rs!=null)rs.close();
				rs=stmt.executeQuery(lan_natSQL);
				if(rs!=null && rs.next()){
					nat_desc_temp=rs.getString("country_desc")==null?"":rs.getString("country_desc");
					lang_desc_temp=rs.getString("lang_desc")==null?"":rs.getString("lang_desc");
				}
			}
		}
		
		

            _bw.write(_wl_block9Bytes, _wl_block9);

	rs32 = stmtn.executeQuery("select name_prefix,prefix_sex from mp_name_prefix");
	int k =0;
	while(rs32!=null && rs32.next()){
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(k));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(rs32.getString("name_prefix")));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(k));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(rs32.getString("prefix_sex")));
            _bw.write(_wl_block13Bytes, _wl_block13);
k++;
	}
            _bw.write(_wl_block14Bytes, _wl_block14);
if(isSlotTimeAppl){
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block16Bytes, _wl_block16);

String book_appt_yn = request.getParameter("book_appt_yn");
if(book_appt_yn.equals("N")){
            _bw.write(_wl_block17Bytes, _wl_block17);
}
String book_appt_wo_pid_yn = checkForNull(request.getParameter("book_appt_wo_pid_yn"));
String book_appt_across_catg_yn = checkForNull(request.getParameter("book_appt_across_catg_yn"));
String alcn_criteria = request.getParameter("alcn_criteria");
if(alcn_criteria==null || alcn_criteria.equals("null")) alcn_criteria="";
StringBuffer sql_srl_no= new StringBuffer("");
String override_no_of_slots=checkForNull(request.getParameter("override_no_of_slots_yn"));
String visit_limit_rule=checkForNull(request.getParameter("visit_limit_rule"),"N");
String slot_appt_ctrl=checkForNull(request.getParameter("slot_appt_ctrl"));
String visit_flag="";
String patientid=request.getParameter("ca_patient_id");
if (patientid.equals(null)|| patientid.equals("null"))patientid ="";
//String clinicname=request.getParameter("clinic_name");
String clinicname="";
String obvisit_flag=request.getParameter("obvisit_flag");
if (obvisit_flag==null|| obvisit_flag.equals("null"))obvisit_flag="";
java.lang.StringBuffer strbfr_sql1=new java.lang.StringBuffer();
String visitcode="";
String visitdesc="";
String visitind="";
String NameDrvnLogic="";
String appt_sr_no="";
String practid="";
String practname="";
String enable_virtual_cons="D";//Added by kamatchi S for ML-MMOH-CRF-1930-US008
String apptdate="";
String fromtime="";
String totime="";
String overbookedyn="N";
String timetableyn="";
String starttime="";
String endtime="";
String wait_list_num="";

//String DMY = "dd/MM/yyyy";	
practid=checkForNull(request.getParameter("i_practitioner_id"));

//practname=checkForNull(request.getParameter("i_practitioner_name"));

//if(locale.equals("en")){
		//practname=java.net.URLDecoder.decode(practname);
//}
apptdate= checkForNull(request.getParameter("i_appt_date"));
fromtime=request.getParameter("i_from_time");
if(fromtime!=null){
	fromtime=fromtime.trim();
}
totime=request.getParameter("i_to_time");
if(totime!=null){
	totime=totime.trim();
}
overbookedyn=request.getParameter("i_over_booked");
if(Forced.equals("Y")) overbookedyn="N";
timetableyn=request.getParameter("i_time_table_type");
stmtsrl=conn.createStatement();
stmtlen=conn.createStatement();
//commented as part of PE and is combined with OA param query
/*String sql_mp_param="select ENTITLEMENT_BY_PAT_CAT_YN from mp_param where module_id='MP'";
rssrl=stmtsrl.executeQuery(sql_mp_param);
if(rssrl!=null){
	if(rssrl.next()){
					ENTITLEMENT_BY_PAT_CAT_YN=rssrl.getString("ENTITLEMENT_BY_PAT_CAT_YN");
	}
}*/
if(rssrl  !=null) rssrl.close();
String sql_wait_list_pass="SELECT DECODE(WAIT_LIST_PRIORITY,'U',1,'S',2,3) PRIORITY, MODIFIED_DATE, WAIT_LIST_NO FROM pr_wait_list WHERE PREFERRED_DATE_TIME=TO_DATE(?,'dd/mm/yyyy') AND LOCN_CODE =?  AND wait_list_status='O' AND ROWNUM='1' ORDER BY priority,modified_date";
pstmt=conn.prepareStatement(sql_wait_list_pass);
pstmt.setString(1,apptdate);
pstmt.setString(2,cliniccode);
rssrl=pstmt.executeQuery();
if(rssrl!=null){
	if(rssrl.next()){
		wait_list_num=rssrl.getString("WAIT_LIST_NO");
		if(wait_list_num ==null) wait_list_num="";
	}
}
if(pstmt!=null){
	pstmt.close();
}
if(rssrl  !=null) rssrl.close();
if (timetableyn.equals("3")){
	sql_srl_no.setLength(0);
	sql_srl_no.append(" select count(1) count from oa_clinic_break where facility_id =? and clinic_code =? and care_locn_type_ind=? and resource_class =? and day_no = (select day_no from sm_day_of_week where trim(day_of_week) = trim(to_char(to_date(?,'dd/mm/yyyy'),'DAY'))) and to_char(break_start_time,'hh24:mi') = ?");
	if(practid.equals("")){
		sql_srl_no.append(" and practitioner_id is null");
	}else{
		sql_srl_no.append(" and practitioner_id = ?");
	}
	pstmt=conn.prepareStatement(sql_srl_no.toString());
	pstmt.setString(1,facilityid);
	pstmt.setString(2,cliniccode);
	pstmt.setString(3,clinic_type);
	pstmt.setString(4,res_type);
	pstmt.setString(5,apptdate);
	pstmt.setString(6,totime);
	if(!practid.equals("")){
		pstmt.setString(7,practid);
	}
	rssrl=pstmt.executeQuery();
	sql_srl_no.setLength(0);
	if(rssrl!=null && rssrl.next()){
		if (rssrl.getInt("count")>0){
			break_flag = "Y";
		}
	}
	if(pstmt!=null){
		pstmt.close();
	}
}
if(rssrl !=null) rssrl.close();
if(rssrl !=null) rssrl.close();
if(! visit_limit_rule.equals("N")){
	// to be fired only when visit limit rule is either max or exact
	sql_srl_no.setLength(0);
	sql_srl_no.append(" select max_patients_per_day,max_first_visits,max_other_visits,nvl(total_first_visit,0)+nvl(total_first_visits_blocked,0) total_first_visit,nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0)+nvl(total_other_visits_blocked,0) total_other_visits  from oa_clinic_schedule where facility_id =? and clinic_code =? and care_locn_type_ind=? and resource_class=? and CLINIC_DATE =to_date(?,'dd/mm/yyyy') ");
	if(practid.equals("")){
		sql_srl_no.append(" and practitioner_id is null");
	}else{
		sql_srl_no.append(" and practitioner_id = ?");
	}
	pstmt=conn.prepareStatement(sql_srl_no.toString());
	pstmt.setString(1,facilityid);
	pstmt.setString(2,cliniccode);
	pstmt.setString(3,clinic_type);
	pstmt.setString(4,res_type);
	pstmt.setString(5,apptdate);
	if(!practid.equals("")){
		pstmt.setString(6,practid);
	}
	rssrl=pstmt.executeQuery();
	sql_srl_no.setLength(0);
	if(rssrl!=null){
		if(rssrl.next()){
			if (rssrl.getInt("max_patients_per_day")==rssrl.getInt("max_first_visits"))
				only_fv_allowed_flag = "Y";
			else
				only_fv_allowed_flag = "N";
			 if (obvisit_flag.equals("")|| obvisit_flag.equals("N")){
				if (!(visit_limit_rule.equals("N"))){
					if (rssrl.getInt("max_first_visits")==rssrl.getInt("total_first_visit")&&rssrl.getInt("max_first_visits")>=0)
						visit_flag ="O";
					if (rssrl.getInt("max_other_visits")==rssrl.getInt("total_other_visits")&&rssrl.getInt("max_other_visits")>=0)
						visit_flag ="F";
					if (visit_limit_rule.equals("E")&&rssrl.getInt("max_first_visits")==0)
						visit_flag ="O";
					if (visit_limit_rule.equals("E")&&rssrl.getInt("max_other_visits")==0)
						visit_flag ="F";

				}
			}
		}
	}
	if(pstmt!=null){
		pstmt.close();
	}
}
pstmt=conn.prepareStatement("select speciality_code,service_code, allow_referral_yn, allow_non_referral_yn,age_group_code,long_desc,multi_speciality_yn from op_clinic_lang_vw  where facility_id=?  and clinic_code =? and language_id=?");
pstmt.setString(1,facilityid);
pstmt.setString(2,cliniccode);
pstmt.setString(3,locale);
rsas=pstmt.executeQuery();
if(rsas!=null && rsas.next()){
	clinicname=rsas.getString("long_desc");
	service_code=rsas.getString("service_code");
	allow_referral_yn = rsas.getString("allow_referral_yn");
	allow_non_referral_yn = rsas.getString("allow_non_referral_yn");
	spec_code=rsas.getString("SPECIALITY_CODE");
	multi_speciality_yn=rsas.getString("multi_speciality_yn");//Added for the CRF - Bru-HIMS-CRF-0198
	age_group_code=rsas.getString("age_group_code");
	if(age_group_code==null) age_group_code="";
}
if(pstmt!=null){
	pstmt.close();
}
int nextno=0;
int maxno=0; 
if(rsas !=null) rsas.close();
pstmt=conn.prepareStatement("select next_srl_no,max_srl_no from oa_appt_srl_no where facility_id =?");
pstmt.setString(1,facilityid);
rsas=pstmt.executeQuery();

if(rsas!=null){
	if(rsas.next()){
		nextno=rsas.getInt("next_srl_no");
		maxno=rsas.getInt("max_srl_no");
	}else{
            _bw.write(_wl_block18Bytes, _wl_block18);
}
}
if(pstmt!=null){
	pstmt.close();
}

	if(maxno<nextno || maxno==nextno) {
	
            _bw.write(_wl_block19Bytes, _wl_block19);
}


	if (patientid.equals("")) {		
		if (allow_referral_yn.equals("Y") && allow_non_referral_yn.equals("Y"))
		{
			enableReferralID  = "";
			readonlyReferralID = "";			
		}
		else if (allow_referral_yn.equals("Y"))
		{
			enableReferralID  = "";
			readonlyReferralID = "";			
		}
		else if (allow_non_referral_yn.equals("Y"))
		{
			enableReferralID  = "disabled";
			readonlyReferralID = "readonly";			
		}
		else
		{
			enableReferralID  = "disabled";
			readonlyReferralID = "readonly";			
		}
	}
	
	if(from_page.equals("modifyappt")) {
		if(patientid.equals("") || patientid.equals("dummy_patinetID") || !allow_referral_yn.equals("Y") ){
			enableReferralID  = "disabled";
			readonlyReferralID = "readonly";		
		} else {
			readonlyReferralID = "";	
			enableReferralID = "";
		}

	}
//Bru-HIMS-CRF 169 changes start
	if(referral_id != null && !(referral_id.equals(""))){
		enableReferralID  = "disabled";
		readonlyReferralID = "readonly";		
	}
//Bru-HIMS-CRF 169 changes end	
	String pat_name_as_multipart_yn="";
	//String prefix="";
	//String suffix="";
	String srl_no="";
	String sys_date_time="";
	//stmt=conn.createStatement();
	if(rs !=null) rs.close();

	if(apptdate!=null && !(apptdate.equals(""))){
		stmtt=conn.createStatement();
		sql_srl_no.setLength(0);		
		//rst=stmtt.executeQuery("select to_char(start_time,'hh24:mi') start_time,to_char(end_time,'hh24:mi') end_time,srl_no from oa_clinic_schedule where clinic_code='"+cliniccode+"' and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_type+"' and trunc(clinic_date)=to_date('"+apptdate+"','DD/MM/YYYY') and facility_id='"+facilityid+"' and nvl(practitioner_id,'X')=nvl('"+practid+"','X')  and nvl(schedule_status,'X')!='B'");
		sql_srl_no.append("select to_char(start_time,'hh24:mi') start_time,to_char(end_time,'hh24:mi') end_time,srl_no from oa_clinic_schedule where clinic_code='"+cliniccode+"' and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_type+"' and trunc(clinic_date)=to_date('"+apptdate+"','DD/MM/YYYY') and facility_id='"+facilityid+"'   and nvl(schedule_status,'X')!='B'");
		if(practid.equals("")){
			sql_srl_no.append(" and practitioner_id is null");
		}else{
			sql_srl_no.append(" and practitioner_id = '"+practid+"'");
		}
		rst=stmtt.executeQuery(sql_srl_no.toString());
		sql_srl_no.setLength(0);
		if(rst != null && rst.next()){
			starttime=rst.getString("start_time");
			endtime=rst.getString("end_time");
			srl_no=rst.getString("srl_no");
			if (overbookedyn.equals("Y") && fromtime.equals("") &&totime.equals("")){
				fromtime=endtime;
				totime=endtime;
			}

			if(totime.equals("00:00"))
				totime = "23:59";
				
			obc =stmtt.executeQuery("select substr(to_date('"+apptdate+" "+totime+"','dd/mm/yyyy HH24:mi')- sysdate,0,1) diff, to_char(sysdate,'dd/mm/yyyy') toDate , to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time from dual");
			String obtm="";
			if(obc!=null && obc.next()){
				obtm=obc.getString("diff");
				currentDate=obc.getString("toDate");
				sys_date_time=obc.getString("sys_date_time");
			}
			
			//Added by Ashwini on 27-May-2020 for MOHE-CRF-0017
			if(isOverBookingAppl)
			{
				if(obtm.equals("-") && !overbookedyn.equals("Y")){
            _bw.write(_wl_block20Bytes, _wl_block20);
}
			}else
			{
				if(obtm.equals("-")){
            _bw.write(_wl_block20Bytes, _wl_block20);
}
			}
		}
	}

		String ip_installed_yn = "";
		String rad_installed_yn = "";
		String rsapsql="select (select nvl(install_yn,'N') from sm_module where module_id = 'IP') ip_install_yn, (select to_char(sysdate,'dd/mm/yyyy') from dual) sysdt , (select to_char(sysdate,'hh24:mi') from dual) systm,(select to_char(sysdate,'dd/mm/yyyy') from dual) dttm ,(select nvl(operational_yn,'N') from sm_modules_facility where facility_id = ? and module_id = 'RD') rad_install_yn,(select OPERATIONAL_YN from sm_modules_facility where module_id='OR' and facility_id =?)or_install_yn,(select to_char(appt_time,'hh24:mi') from OR_ORDER_CATALOG where order_catalog_code = '"+or_catalogue_code+"') or_appt_time,(select FOLLOW_VISIT_TYPE_YN from OR_ORDER_CATALOG where order_catalog_code = '"+or_catalogue_code+"') follow_visit_type_yn  from dual ";
		pstmt=conn.prepareStatement(rsapsql.toString());
		pstmt.setString(1,facilityid);
		pstmt.setString(2,facilityid);
		rsap=pstmt.executeQuery();
		String str14="";
		if(rsap!=null && rsap.next()){
			ip_installed_yn = rsap.getString("ip_install_yn");
			if(ip_installed_yn==null || ip_installed_yn.equals(""))
				ip_installed_yn="N";

			or_install_yn= rsap.getString("or_install_yn")==null?"N":rsap.getString("or_install_yn");
			follow_visit_type_yn= rsap.getString("follow_visit_type_yn")==null?"Y":rsap.getString("follow_visit_type_yn");
			or_appt_time= rsap.getString("or_appt_time")==null?"":rsap.getString("or_appt_time");
			rad_installed_yn= rsap.getString("rad_install_yn");
			if(rad_installed_yn==null || rad_installed_yn.equals(""))
				rad_installed_yn="N";

			str14=rsap.getString("systm");
			dttm=rsap.getString("dttm");
		}else{
			ip_installed_yn = "N";
			rad_installed_yn= "N";
			str14=rsap.getString("systm");
			dttm=rsap.getString("dttm");
		}
		if(pstmt!=null){
			pstmt.close();
		}

	int ip_bkgs = 0;
	String vCallMD=(String) session.getValue("CallMode");
	String vCallMD1=(String) session.getValue("CallMode1");
	String patientid_CA=(String) session.getValue("patientid");

	String from_wait_list=(String) session.getValue("from_wait_list");
	if(from_wait_list ==null) from_wait_list="N";
	String waitListNo=(String) session.getValue("waitListNo");
	if(waitListNo ==null) waitListNo="";
	
	String wtListControl = checkForNull(request.getParameter("wtListControl"));
	//System.out.println("wtListControl AddModifyBookAppointment:"+wtListControl);
	//System.out.println("waitListNo AddModifyBookAppointment:"+request.getParameter("waitListNo"));
	if(wtListControl.equals("B")){
		from_wait_list = "Y";
		waitListNo = checkForNull(request.getParameter("waitListNo"));
		vCallMD="OP";
	}

	if(rs1 !=null)rs1.close();
	if(res_type.equals("P")){
		sql5  = "select pract_type res_type,AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,'1')practname,enable_virtual_cons from am_practitioner where practitioner_id= ? and practitioner_id is not null" ;
		pstmt=conn.prepareStatement(sql5);
		pstmt.setString(1,locale);
		pstmt.setString(2,practid);
	}else if(res_type.equals("R")){
		sql5  = "select room_type res_type,AM_GET_DESC.AM_FACILITY_ROOM(OPERATING_FACILITY_ID, room_num,?,'1')practname from am_facility_room where room_num =? and OPERATING_FACILITY_ID=? and room_num is not null";
		pstmt=conn.prepareStatement(sql5);
		pstmt.setString(1,locale);
		pstmt.setString(2,practid);
		pstmt.setString(3,facilityid);
	}else{
		sql5  = "select resource_type res_type,AM_GET_DESC.AM_RESOURCE(FACILITY_ID, RESOURCE_ID,?,'1')practname from am_resource where resource_id = ? and facility_id= ? and resource_Class=? and resource_id is not null" ;
		pstmt=conn.prepareStatement(sql5);
		pstmt.setString(1,locale);
		pstmt.setString(2,practid);
		pstmt.setString(3,facilityid);
		pstmt.setString(4,res_type);
	}
	rs1=pstmt.executeQuery();
	if(rs1!=null && rs1.next()){
		Resource_type = rs1.getString("res_type") ;
		practname = rs1.getString("practname") ;
		if(isVIRTUAL_CONSULTATION && res_type.equals("P")){
		enable_virtual_cons = rs1.getString("enable_virtual_cons") ;//Added by Kamatchi S for ML-MMOH-CRF-1930-US008
		}
	}
	if(pstmt!=null){
		pstmt.close();
	}
	if(rs1 !=null)rs1.close();	
	
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(NameDrvnLogic));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf( appt_sr_no));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf( timetableyn));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(overbookedyn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( starttime));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(endtime));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf( cliniccode));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(practid));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(fromtime));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(clinicname));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(care_locn_ind_desc));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(res_class_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(practname));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(totime));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(ip_bkgs));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(apptdate));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(fromtime));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(apptdate));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(from_page));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(from_page1));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(apptrefno));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(allow_referral_yn));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(allow_non_referral_yn));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(vCallMD));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(from_wait_list));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(waitListNo));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(fromtime));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(totime));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(or_install_yn));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(multi_speciality_yn));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(isVIRTUAL_CONSULTATION));
            _bw.write(_wl_block58Bytes, _wl_block58);

			String apptdate_display=DateUtils.convertDate(apptdate,"DMY","en",locale);
	
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(apptdate_display));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(apptdate));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(fromtime));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(totime));
            _bw.write(_wl_block66Bytes, _wl_block66);
if(rule_based_tr.equals("Y") && prefPractYN.equals("N")){
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block70Bytes, _wl_block70);
}else{
            _bw.write(_wl_block71Bytes, _wl_block71);
}
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(care_locn_ind_desc));
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(care_locn_ind_desc));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(clinicname));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(clinicname));
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);


			stmt_service=conn.createStatement();
			int serviceCount = 0;
			String service_sql="select service_code,short_desc from am_service_lang_vw where language_id='"+locale+"' and eff_status='E' and service_code in(select service_code from op_clinic where clinic_code ='"+cliniccode+"' and facility_id='"+facilityid+"' union SELECT b.service_code FROM OP_CLINIC_FOR_SERVICE b WHERE b.clinic_code ='"+cliniccode+"' AND b.facility_id='"+facilityid+"')";
			rs_service=stmt_service.executeQuery(service_sql);
			while(rs_service!=null && rs_service.next()){
				serviceCount++;
				
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(rs_service.getString("service_code")));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(rs_service.getString("short_desc")));
            _bw.write(_wl_block82Bytes, _wl_block82);
}		 
				
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(serviceCount));
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(timetableyn));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(totime));
            _bw.write(_wl_block87Bytes, _wl_block87);

				long orApptTimeMin = 0;
				long difference = 0;
				long maxSlots = 0;
				double addSlotsMod = 0.0;
				// Added by Kamatchi S for NMC-JD-CRF-0104
				if(!or_appt_time.equals("") && isSlotTimeAppl)
				{
				if(or_appt_time.equals("00:00"))
					or_appt_time ="";
				}
			//Below Condition is modified by kamatchi S for NMC-JD-CRF-0104
			if((rd_appt_yn.equals("Y") && follow_visit_type_yn.equals("N") && !or_appt_time.equals("")) || (!or_appt_time.equals("") && isSlotTimeAppl)){
				String sample = "00:00";
				SimpleDateFormat format = new SimpleDateFormat("HH:mm");				
				java.util.Date date1 = format.parse(fromtime);
				java.util.Date date2 = format.parse(totime);	
				java.util.Date date3 = format.parse(or_appt_time);
				java.util.Date date4 = format.parse(sample);			
				 orApptTimeMin = ((date3.getTime() - date4.getTime())/(1000 * 60));
				 difference = ((date2.getTime() - date1.getTime())/(1000 * 60));
				 maxSlots = orApptTimeMin/difference;
				 addSlotsMod = orApptTimeMin%difference;			
				if(addSlotsMod > 0)
					maxSlots = maxSlots + 1;				
			} 
			String max_appt_slots="";
			stmt_visit_type=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			//Added by Kamatchi S for ML-MMOH-CRF-1930 US008
			if(isVIRTUAL_CONSULTATION && res_type.equals("P")){
				if(enable_virtual_cons.equals("E"))
					{
					strbfr_sql1=strbfr_sql1.append("select b.short_desc ,a.visit_type_code,b.visit_type_ind,nvl(a.MAX_APPT_SLOTS,NVL((select MAX_APPT_SLOTS from op_visit_type where facility_id=a.facility_id and visit_type_code=a.visit_type_code),1)) max_appt_slots ,nvl(a.MAX_APPT_DURATION,NVL((select MAX_APPT_DURATION from op_visit_type where facility_id=a.facility_id and visit_type_code=a.visit_type_code),1)) max_appt_dur, b.VIRTUAL_CONSULTATION from op_visit_type_for_clinic a, op_visit_type_lang_vw b where a.facility_id='"+facilityid+"' AND a.facility_id=b.facility_id  AND a.VISIT_TYPE_CODE=b.VISIT_TYPE_CODE   AND b.LANGUAGE_ID='"+locale+"' and a.eff_status='E' and a.clinic_code='"+cliniccode+"' and b.visit_type_ind != 'E' ");	
					}
				if(enable_virtual_cons.equals("D"))
					{
					strbfr_sql1=strbfr_sql1.append("select b.short_desc ,a.visit_type_code,b.visit_type_ind,nvl(a.MAX_APPT_SLOTS,NVL((select MAX_APPT_SLOTS from op_visit_type where facility_id=a.facility_id and visit_type_code=a.visit_type_code),1)) max_appt_slots ,nvl(a.MAX_APPT_DURATION,NVL((select MAX_APPT_DURATION from op_visit_type where facility_id=a.facility_id and visit_type_code=a.visit_type_code),1)) max_appt_dur, b.VIRTUAL_CONSULTATION from op_visit_type_for_clinic a, op_visit_type_lang_vw b where a.facility_id='"+facilityid+"' AND a.facility_id=b.facility_id  AND a.VISIT_TYPE_CODE=b.VISIT_TYPE_CODE   AND b.LANGUAGE_ID='"+locale+"' and a.eff_status='E' and a.clinic_code='"+cliniccode+"' and b.visit_type_ind != 'E' AND b.VIRTUAL_CONSULTATION='D' ");	
					}	
			
			}
			else{
			strbfr_sql1=strbfr_sql1.append("select b.short_desc ,a.visit_type_code,b.visit_type_ind,nvl(a.MAX_APPT_SLOTS,NVL((select MAX_APPT_SLOTS from op_visit_type where facility_id=a.facility_id and visit_type_code=a.visit_type_code),1)) max_appt_slots ,nvl(a.MAX_APPT_DURATION,NVL((select MAX_APPT_DURATION from op_visit_type where facility_id=a.facility_id and visit_type_code=a.visit_type_code),1)) max_appt_dur,b.VIRTUAL_CONSULTATION from op_visit_type_for_clinic a, op_visit_type_lang_vw b where a.facility_id='"+facilityid+"' AND a.facility_id=b.facility_id  AND a.VISIT_TYPE_CODE=b.VISIT_TYPE_CODE   AND b.LANGUAGE_ID='"+locale+"' and a.eff_status='E' and a.clinic_code='"+cliniccode+"' and b.visit_type_ind != 'E' ");
			}
			if(rd_appt_yn.equals("Y")){
				strbfr_sql1.append( " and b.rd_appl_yn = 'Y'");
			}else{
			if(Forced.equals("N")){
				if(visit_flag.equals("")){
					if(visit_flag_OP.equals("N") || visit_flag_OP.equals("")){
						if(!obvisit_flag.equals("")&&!obvisit_flag.equals("A")){
							if(obvisit_flag.equals("F")){
								strbfr_sql1.append(" and b.visit_type_ind = 'F'");
							}else if(obvisit_flag.equals("O")){
								strbfr_sql1.append( " and b.visit_type_ind != 'F'");
							}
						}
					}else{
						if(!vCallMD.equals("RSCAPPT"))
							strbfr_sql1.append( " and b.visit_type_ind != 'F'");
					}
				}else{
					if(visit_flag_OP.equals("N") || visit_flag_OP.equals("")){
						if(visit_flag.equals("F")){
							strbfr_sql1.append(" and b.visit_type_ind = 'F'");
						}else if(visit_flag.equals("O")){
							strbfr_sql1.append(" and b.visit_type_ind != 'F'");
						}
					 }else{
						 strbfr_sql1.append(" and b.visit_type_ind != 'F'");
					}
				}
			}
			}
			if(!from_page.equals("")){
				if(!visit_type_ind.equals("")){
					strbfr_sql1.append(" and a.visit_type_code = '"+visit_type_ind+"'");	
				}
			}
			strbfr_sql1.append(" order by b.short_desc");
			if(from_page.equals("modifyappt")){
				strbfr_sql1.setLength(0);
				strbfr_sql1.append("SELECT short_desc, a.visit_type_code, a.visit_type_ind,NVL (b.max_appt_slots, 1) max_appt_slots,NVL (b.max_appt_duration, 1) max_appt_dur FROM op_visit_type_lang_vw a, op_visit_type_for_clinic b WHERE a.visit_type_code = '"+visit_type_ind+"' AND a.visit_type_code = b.visit_type_code AND a.facility_id = b.facility_id AND a.facility_id = '"+facilityid+"' AND b.clinic_code = '"+cliniccode+"' AND a.language_id = '"+locale+"'");
			}
			rs1=stmt_visit_type.executeQuery(strbfr_sql1.toString());
			rs1.last();
			visit_type_cnt = rs1.getRow();
			rs1.beforeFirst();
			strbfr_sql1.setLength(0)	;
			
			if(visit_type_cnt > 1)
			{
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);

			}
			while(rs1!=null && rs1.next()){
			visitcode=rs1.getString("visit_type_code");
			visitdesc=rs1.getString("short_desc");
			visitind=rs1.getString("visit_type_ind");
			 max_appt_slots=rs1.getString("max_appt_slots");
			
			if (max_appt_slots==null) max_appt_slots="";
			int max_dur = rs1.getInt("max_appt_dur");
			if(visit_type_cnt<1)
			{
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(visitcode));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(visitind));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(visitdesc));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(visit_ind_count));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(visitcode+"~"+visitind));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(visit_ind_count));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(max_dur));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(visit_ind_count));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(max_appt_slots));
            _bw.write(_wl_block99Bytes, _wl_block99);
}else {
			
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(visitcode));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(visitind));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(visitdesc));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(visit_ind_count));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(visitcode+"~"+visitind));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(visit_ind_count));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(max_dur));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(visit_ind_count));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(max_appt_slots));
            _bw.write(_wl_block101Bytes, _wl_block101);
}
			visit_ind_count++;
			}
			if(rs1 !=null)rs1.close();
				
            _bw.write(_wl_block102Bytes, _wl_block102);
if (timetableyn.equals("1")&& overbookedyn.equals("N")&& Forced.equals("N") ) {
            _bw.write(_wl_block103Bytes, _wl_block103);

			//Condition Modified by kamatchi S for NMC-JD-CRF-0104
			if((rd_appt_yn.equals("Y") && follow_visit_type_yn.equals("N") && !or_appt_time.equals("")) || (!or_appt_time.equals("") && isSlotTimeAppl)){
				max_appt_slots = Long.toString(maxSlots) ;
			}
				//Modified by kamatchi S for NMC-JD-CRF-0104
				if(visit_type_cnt<=1 || (!or_appt_time.equals("") && isSlotTimeAppl))
				{
				
				if(Integer.parseInt(max_appt_slots) >1)
				
				{
				
				
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);

					int default_slot=Integer.parseInt(max_appt_slots); //Line Modified for CRF Bru-HIMS-CRF-279 [IN:033084]
					if(follow_visit_type_yn.equals("N")){
						default_slot=Integer.parseInt(max_appt_slots);
					}
				for(int m=1;m<=Integer.parseInt(max_appt_slots);m++){
					if(m==default_slot)
					{
					
					
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(m));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(m));
            _bw.write(_wl_block107Bytes, _wl_block107);
}else
					{
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(m));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(m));
            _bw.write(_wl_block105Bytes, _wl_block105);
	}
				 }
				}else
				{
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(max_appt_slots));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(max_appt_slots));
            _bw.write(_wl_block105Bytes, _wl_block105);
}
			 }else {
            _bw.write(_wl_block112Bytes, _wl_block112);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);
}
			
            _bw.write(_wl_block114Bytes, _wl_block114);
}else{
            _bw.write(_wl_block115Bytes, _wl_block115);
}		
			
		
		
            _bw.write(_wl_block116Bytes, _wl_block116);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(apptdate_display));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(apptdate));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(fromtime));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(totime));
            _bw.write(_wl_block119Bytes, _wl_block119);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(res_class_desc));
            _bw.write(_wl_block121Bytes, _wl_block121);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(res_class_desc));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(practname));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(practname));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(practname));
            _bw.write(_wl_block126Bytes, _wl_block126);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block127Bytes, _wl_block127);
if(create_wait_list_yn.equals("N")) {
            _bw.write(_wl_block128Bytes, _wl_block128);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block129Bytes, _wl_block129);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block130Bytes, _wl_block130);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block131Bytes, _wl_block131);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block132Bytes, _wl_block132);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block133Bytes, _wl_block133);
 if(overbookedyn.equals("Y")) {
            _bw.write(_wl_block134Bytes, _wl_block134);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block135Bytes, _wl_block135);
}
            _bw.write(_wl_block136Bytes, _wl_block136);
}else {
            _bw.write(_wl_block137Bytes, _wl_block137);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block138Bytes, _wl_block138);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block130Bytes, _wl_block130);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block131Bytes, _wl_block131);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block132Bytes, _wl_block132);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block133Bytes, _wl_block133);
 if(overbookedyn.equals("Y")) {
            _bw.write(_wl_block134Bytes, _wl_block134);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block135Bytes, _wl_block135);
}
            _bw.write(_wl_block139Bytes, _wl_block139);
}
            _bw.write(_wl_block140Bytes, _wl_block140);

					String fromOrdPract = "";
					String fromOrdPractName = "";
					if(!or_catalogue_code.equals("")){
						if(res_type.equals("P")){
								fromOrdPract = practid;
								fromOrdPractName = practname;
							}else{
								fromOrdPract = "";
								fromOrdPractName = "";
							}		
					
						if(!order_id.equals("")){								
							String ordPractSql="select ord_pract_id,am_get_desc.am_practitioner(ord_pract_id,'"+localeName+"','1') practName from or_order where order_id = '"+order_id+"'";
							if(rs1!=null)rs1.close();
							rs1=stmt.executeQuery(ordPractSql);
							if(rs1!=null && rs1.next()){
								fromOrdPract=rs1.getString("ord_pract_id")==null?"":rs1.getString("ord_pract_id");
								fromOrdPractName=rs1.getString("practName")==null?"":rs1.getString("practName");										
							}
					    }
				
            _bw.write(_wl_block141Bytes, _wl_block141);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(fromOrdPractName));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(fromOrdPract));
            _bw.write(_wl_block144Bytes, _wl_block144);
}
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(Forced));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(only_fv_allowed_flag));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(slot_appt_ctrl));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(visit_limit_rule));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(alcn_criteria));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(override_no_of_slots));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(capture_fin_dtls_yn));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(min_ela_per_resc_noshow_in_day));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(noshow_ctrl_by_splty_or_clinic));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(contact_num_reqd_yn));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(per_chk_for_no_show_alert));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(no_of_noshow_appts_for_alert));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(email_appl_yn));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(email_appl_for_appt_wo_pid_yn));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(pat_email_appl_yn));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(totime));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(res_type));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(Resource_type));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(Global));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(rule_appl_yn));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(rule_based_tr));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(patient_id_temp));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(name_prefix_temp));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(first_name_temp));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(second_name_temp));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(third_name_temp));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(family_name_temp));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(name_suffix_temp));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(name_prefix_oth_lang_temp));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(first_name_oth_lang_temp));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(second_name_oth_lang_temp));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(third_name_oth_lang_temp));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(family_name_oth_lang_temp));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(name_suffix_oth_lang_temp));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(gender_temp));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(contact_no_temp));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(mob_num_req_yn));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(nationality_code_temp));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(nat_desc_temp));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(canldapptrefno));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(tempLangugaeID));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(isSlotTimeAppl));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(or_appt_time));
            _bw.write(_wl_block189Bytes, _wl_block189);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block190Bytes, _wl_block190);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block191Bytes, _wl_block191);
if(bl_operational.equals("Y") && capture_fin_dtls_yn.equals("Y")) {
            _bw.write(_wl_block192Bytes, _wl_block192);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block193Bytes, _wl_block193);
}else {
            _bw.write(_wl_block194Bytes, _wl_block194);
}
            _bw.write(_wl_block195Bytes, _wl_block195);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block196Bytes, _wl_block196);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(readonlyReferralID));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(enableReferralID));
            _bw.write(_wl_block200Bytes, _wl_block200);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block201Bytes, _wl_block201);
            {java.lang.String __page ="../../eMP/jsp/natAltIDComponent.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("bodyFrame"), weblogic.utils.StringUtils.valueOf("parent.f_query_add_mod")},{ weblogic.utils.StringUtils.valueOf("submitFrame"), weblogic.utils.StringUtils.valueOf("parent.messageFrame")},{ weblogic.utils.StringUtils.valueOf("op_call"), weblogic.utils.StringUtils.valueOf("OA")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block206Bytes, _wl_block206);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block207Bytes, _wl_block207);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block210Bytes, _wl_block210);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(dttm));
            _bw.write(_wl_block212Bytes, _wl_block212);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block213Bytes, _wl_block213);
 if(isIncRemarksLengthAppl){ 
            _bw.write(_wl_block214Bytes, _wl_block214);
 }else{ 
            _bw.write(_wl_block215Bytes, _wl_block215);
 } 
            _bw.write(_wl_block216Bytes, _wl_block216);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block217Bytes, _wl_block217);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block218Bytes, _wl_block218);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block219Bytes, _wl_block219);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block220Bytes, _wl_block220);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block221Bytes, _wl_block221);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block222Bytes, _wl_block222);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block223Bytes, _wl_block223);
if(rule_appl_yn.equals("Y")){
            _bw.write(_wl_block224Bytes, _wl_block224);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(lang_desc_temp));
            _bw.write(_wl_block226Bytes, _wl_block226);
if(language_req_yn.equals("Y")){
            _bw.write(_wl_block227Bytes, _wl_block227);
}
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(language_code_temp));
            _bw.write(_wl_block229Bytes, _wl_block229);
}
            _bw.write(_wl_block105Bytes, _wl_block105);
if(clinicInsYN.equals("Y") || orderInsYN.equals("Y")){
            _bw.write(_wl_block230Bytes, _wl_block230);
}
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block232Bytes, _wl_block232);
	


	String vPat_id="";
	vPat_id=(String) session.getValue("Pat_id");
	if(vPat_id==null) vPat_id="";

	if(vPat_id.equals("N")){
		patientid=patientid;
	}else{
		patientid=vPat_id;
	}
				String ca_patient_id_new="";
				
		if(from_page.equals("")) {
				ca_patient_id_new=(String)(session.getValue("ca_patient_id_new")==null?"":session.getValue("ca_patient_id_new"));
				if(ca_patient_id_new.equals(null) ||ca_patient_id_new ==null) ca_patient_id_new="";			
	    }


	
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(pat_name_as_multipart_yn));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(practname));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(practid));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(cliniccode));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(book_appt_wo_pid_yn));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(book_appt_across_catg_yn));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(spec_code));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(ENTITLEMENT_BY_PAT_CAT_YN));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(dtl_msg_yn));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(obvisit_flag));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(break_flag));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(ip_bkgs));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(ca_patient_id_new));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(age_group_code));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(req_id));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(bl_operational));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(visit_type_ind));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(ca_mode));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(patientid_CA));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(vCallMD1));
            _bw.write(_wl_block256Bytes, _wl_block256);
String ref_id="";
		ref_id=(String) session.getValue("ref_id");
	if(ref_id==null) ref_id="N";
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(ref_id));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(str14));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(dttm));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(block_break_appt));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(or_catalogue_code));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(or_catalogue_code));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(currentDate));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(ip_installed_yn));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(rad_installed_yn));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(sys_date_time));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(visit_type_cnt));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(from_facility_id));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(from_encounter_id));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(wait_list_num));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(send_email_yn));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(clinicInsYN));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(orderInsYN));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(orderInsStandardYN));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(customer_id));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(linking_code));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(wtListControl));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(Long.toString(maxSlots)));
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(follow_visit_type_yn));
            _bw.write(_wl_block282Bytes, _wl_block282);
            out.print( String.valueOf(visit_ind_count));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(MaxcancelAlert));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(max_slot_default_yn));
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(upt_contact_dtls_mp_yn));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(upd_pat_dtls_referral_yn));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(isIncRemarksLengthAppl));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block289Bytes, _wl_block289);

			
	        if(stmt!=null) stmt.close();
			if(rs!=null) rs.close();
    		if(rs1!=null) rs1.close();
    		if(rs2!=null) rs2.close();
    		if(rs3!=null) rs3.close();
    		if(rsas!=null) rsas.close();
    		if(rsap!=null) rsap.close();
    		if(rsc!=null) rsc.close();
    		if(rst!=null) rst.close();
			if(rs_nid!=null) rs_nid.close();
			if(rs_ser!=null) rs_ser.close();
			if(rs_p!=null) rs_p.close();
			if(obc!=null) obc.close();
			if(stmtas !=null) stmtas.close();
			if (rsdt!=null) rsdt.close();
			if (rs_service!=null) rs_service.close();
			if (rs32 !=null) rs32.close();
			if (rslen !=null)	 rslen.close();
			if (rssrl !=null) rssrl.close();
			
			if(stmt1_p  !=null) stmt1_p.close();
    		if(stmtas !=null) stmtas.close();
			if(stmtsrl !=null) stmtsrl.close();
    		if(stmtap !=null) stmtap.close();
    		if(stmtc !=null) stmtc.close();
    		if(stmt7!=null) stmt7.close();
    		if(stmtt!=null) stmtt.close();
    		if(stmt1!=null) stmt1.close();
    		if(stmt2!=null) stmt2.close();
			if(stmtlen!=null) stmtlen.close();
			if(stmtdt!=null) stmtdt.close();
			if(stmtn !=null) stmtn.close();
			if(stmt_visit_type !=null) stmt_visit_type.close();
			if(stmt_service !=null) stmt_service.close();

			if(pstmt!=null){
				pstmt.close();
			}


	

///// ---
}catch(Exception e){
	//out.println(e);
	e.printStackTrace();
}finally{
    ConnectionManager.returnConnection(conn,request);
}


            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block290Bytes, _wl_block290);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.apptdate.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.time.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.ReasonForOverride.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.visittype.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.apptdate.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag13 = null ;
        int __result__tag13 = 0 ;

        if (__tag13 == null ){
            __tag13 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
        }
        __tag13.setPageContext(pageContext);
        __tag13.setParent(null);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.time.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag13;
        __result__tag13 = __tag13.doStartTag();

        if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag13.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag13);
            return true;
        }
        _activeTag=__tag13.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag13);
        __tag13.release();
        return false;
    }

    private boolean _jsp__tag14(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag14 = null ;
        int __result__tag14 = 0 ;

        if (__tag14 == null ){
            __tag14 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag14);
        }
        __tag14.setPageContext(pageContext);
        __tag14.setParent(null);
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resource.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag14;
        __result__tag14 = __tag14.doStartTag();

        if (__result__tag14!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag14== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag14.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag14);
            return true;
        }
        _activeTag=__tag14.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag14);
        __tag14.release();
        return false;
    }

    private boolean _jsp__tag15(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag15 = null ;
        int __result__tag15 = 0 ;

        if (__tag15 == null ){
            __tag15 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag15);
        }
        __tag15.setPageContext(pageContext);
        __tag15.setParent(null);
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resource.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag15;
        __result__tag15 = __tag15.doStartTag();

        if (__result__tag15!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag15== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag15.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag15);
            return true;
        }
        _activeTag=__tag15.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag15);
        __tag15.release();
        return false;
    }

    private boolean _jsp__tag16(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag16 = null ;
        int __result__tag16 = 0 ;

        if (__tag16 == null ){
            __tag16 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag16);
        }
        __tag16.setPageContext(pageContext);
        __tag16.setParent(null);
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PreferredDate.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag16;
        __result__tag16 = __tag16.doStartTag();

        if (__result__tag16!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag16== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag16.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag16);
            return true;
        }
        _activeTag=__tag16.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag16);
        __tag16.release();
        return false;
    }

    private boolean _jsp__tag17(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag17 = null ;
        int __result__tag17 = 0 ;

        if (__tag17 == null ){
            __tag17 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag17);
        }
        __tag17.setPageContext(pageContext);
        __tag17.setParent(null);
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag17;
        __result__tag17 = __tag17.doStartTag();

        if (__result__tag17!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag17== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag17.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag17);
            return true;
        }
        _activeTag=__tag17.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag17);
        __tag17.release();
        return false;
    }

    private boolean _jsp__tag18(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag18 = null ;
        int __result__tag18 = 0 ;

        if (__tag18 == null ){
            __tag18 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag18);
        }
        __tag18.setPageContext(pageContext);
        __tag18.setParent(null);
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag18;
        __result__tag18 = __tag18.doStartTag();

        if (__result__tag18!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag18== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag18.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag18);
            return true;
        }
        _activeTag=__tag18.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag18);
        __tag18.release();
        return false;
    }

    private boolean _jsp__tag19(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag19 = null ;
        int __result__tag19 = 0 ;

        if (__tag19 == null ){
            __tag19 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag19);
        }
        __tag19.setPageContext(pageContext);
        __tag19.setParent(null);
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.urgent.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag19;
        __result__tag19 = __tag19.doStartTag();

        if (__result__tag19!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag19== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag19.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag19);
            return true;
        }
        _activeTag=__tag19.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag19);
        __tag19.release();
        return false;
    }

    private boolean _jsp__tag20(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag20 = null ;
        int __result__tag20 = 0 ;

        if (__tag20 == null ){
            __tag20 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag20);
        }
        __tag20.setPageContext(pageContext);
        __tag20.setParent(null);
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.semiurgent.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag20;
        __result__tag20 = __tag20.doStartTag();

        if (__result__tag20!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag20== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag20.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag20);
            return true;
        }
        _activeTag=__tag20.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag20);
        __tag20.release();
        return false;
    }

    private boolean _jsp__tag21(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag21 = null ;
        int __result__tag21 = 0 ;

        if (__tag21 == null ){
            __tag21 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag21);
        }
        __tag21.setPageContext(pageContext);
        __tag21.setParent(null);
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Normal.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag21;
        __result__tag21 = __tag21.doStartTag();

        if (__result__tag21!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag21== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag21.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag21);
            return true;
        }
        _activeTag=__tag21.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag21);
        __tag21.release();
        return false;
    }

    private boolean _jsp__tag22(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag22 = null ;
        int __result__tag22 = 0 ;

        if (__tag22 == null ){
            __tag22 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag22);
        }
        __tag22.setPageContext(pageContext);
        __tag22.setParent(null);
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.overbooking.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag22;
        __result__tag22 = __tag22.doStartTag();

        if (__result__tag22!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag22== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag22.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag22);
            return true;
        }
        _activeTag=__tag22.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag22);
        __tag22.release();
        return false;
    }

    private boolean _jsp__tag23(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag23 = null ;
        int __result__tag23 = 0 ;

        if (__tag23 == null ){
            __tag23 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag23);
        }
        __tag23.setPageContext(pageContext);
        __tag23.setParent(null);
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag23;
        __result__tag23 = __tag23.doStartTag();

        if (__result__tag23!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag23== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag23.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag23);
            return true;
        }
        _activeTag=__tag23.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag23);
        __tag23.release();
        return false;
    }

    private boolean _jsp__tag24(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag24 = null ;
        int __result__tag24 = 0 ;

        if (__tag24 == null ){
            __tag24 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag24);
        }
        __tag24.setPageContext(pageContext);
        __tag24.setParent(null);
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag24;
        __result__tag24 = __tag24.doStartTag();

        if (__result__tag24!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag24== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag24.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag24);
            return true;
        }
        _activeTag=__tag24.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag24);
        __tag24.release();
        return false;
    }

    private boolean _jsp__tag25(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag25 = null ;
        int __result__tag25 = 0 ;

        if (__tag25 == null ){
            __tag25 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag25);
        }
        __tag25.setPageContext(pageContext);
        __tag25.setParent(null);
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.urgent.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag25;
        __result__tag25 = __tag25.doStartTag();

        if (__result__tag25!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag25== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag25.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag25);
            return true;
        }
        _activeTag=__tag25.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag25);
        __tag25.release();
        return false;
    }

    private boolean _jsp__tag26(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag26 = null ;
        int __result__tag26 = 0 ;

        if (__tag26 == null ){
            __tag26 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag26);
        }
        __tag26.setPageContext(pageContext);
        __tag26.setParent(null);
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.semiurgent.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag26;
        __result__tag26 = __tag26.doStartTag();

        if (__result__tag26!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag26== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag26.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag26);
            return true;
        }
        _activeTag=__tag26.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag26);
        __tag26.release();
        return false;
    }

    private boolean _jsp__tag27(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag27 = null ;
        int __result__tag27 = 0 ;

        if (__tag27 == null ){
            __tag27 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag27);
        }
        __tag27.setPageContext(pageContext);
        __tag27.setParent(null);
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Normal.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag27;
        __result__tag27 = __tag27.doStartTag();

        if (__result__tag27!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag27== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag27.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag27);
            return true;
        }
        _activeTag=__tag27.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag27);
        __tag27.release();
        return false;
    }

    private boolean _jsp__tag28(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag28 = null ;
        int __result__tag28 = 0 ;

        if (__tag28 == null ){
            __tag28 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag28);
        }
        __tag28.setPageContext(pageContext);
        __tag28.setParent(null);
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.overbooking.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag28;
        __result__tag28 = __tag28.doStartTag();

        if (__result__tag28!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag28== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag28.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag28);
            return true;
        }
        _activeTag=__tag28.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag28);
        __tag28.release();
        return false;
    }

    private boolean _jsp__tag29(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag29 = null ;
        int __result__tag29 = 0 ;

        if (__tag29 == null ){
            __tag29 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag29);
        }
        __tag29.setPageContext(pageContext);
        __tag29.setParent(null);
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderingPractitioner.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag29;
        __result__tag29 = __tag29.doStartTag();

        if (__result__tag29!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag29== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag29.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag29);
            return true;
        }
        _activeTag=__tag29.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag29);
        __tag29.release();
        return false;
    }

    private boolean _jsp__tag30(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag30 = null ;
        int __result__tag30 = 0 ;

        if (__tag30 == null ){
            __tag30 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag30);
        }
        __tag30.setPageContext(pageContext);
        __tag30.setParent(null);
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag30;
        __result__tag30 = __tag30.doStartTag();

        if (__result__tag30!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag30== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag30.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag30);
            return true;
        }
        _activeTag=__tag30.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag30);
        __tag30.release();
        return false;
    }

    private boolean _jsp__tag31(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag31 = null ;
        int __result__tag31 = 0 ;

        if (__tag31 == null ){
            __tag31 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag31);
        }
        __tag31.setPageContext(pageContext);
        __tag31.setParent(null);
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.SecondaryResources.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag31;
        __result__tag31 = __tag31.doStartTag();

        if (__result__tag31!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag31== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag31.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag31);
            return true;
        }
        _activeTag=__tag31.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag31);
        __tag31.release();
        return false;
    }

    private boolean _jsp__tag32(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag32 = null ;
        int __result__tag32 = 0 ;

        if (__tag32 == null ){
            __tag32 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag32);
        }
        __tag32.setPageContext(pageContext);
        __tag32.setParent(null);
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.financialdetails.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag32;
        __result__tag32 = __tag32.doStartTag();

        if (__result__tag32!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag32== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag32.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag32);
            return true;
        }
        _activeTag=__tag32.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag32);
        __tag32.release();
        return false;
    }

    private boolean _jsp__tag33(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag33 = null ;
        int __result__tag33 = 0 ;

        if (__tag33 == null ){
            __tag33 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag33);
        }
        __tag33.setPageContext(pageContext);
        __tag33.setParent(null);
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referral.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag33;
        __result__tag33 = __tag33.doStartTag();

        if (__result__tag33!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag33== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag33.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag33);
            return true;
        }
        _activeTag=__tag33.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag33);
        __tag33.release();
        return false;
    }

    private boolean _jsp__tag34(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag34 = null ;
        int __result__tag34 = 0 ;

        if (__tag34 == null ){
            __tag34 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag34);
        }
        __tag34.setPageContext(pageContext);
        __tag34.setParent(null);
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.identification.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag34;
        __result__tag34 = __tag34.doStartTag();

        if (__result__tag34!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag34== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag34.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag34);
            return true;
        }
        _activeTag=__tag34.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag34);
        __tag34.release();
        return false;
    }

    private boolean _jsp__tag35(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag35 = null ;
        int __result__tag35 = 0 ;

        if (__tag35 == null ){
            __tag35 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag35);
        }
        __tag35.setPageContext(pageContext);
        __tag35.setParent(null);
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag35;
        __result__tag35 = __tag35.doStartTag();

        if (__result__tag35!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag35== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag35.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag35);
            return true;
        }
        _activeTag=__tag35.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag35);
        __tag35.release();
        return false;
    }

    private boolean _jsp__tag36(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag36 = null ;
        int __result__tag36 = 0 ;

        if (__tag36 == null ){
            __tag36 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag36);
        }
        __tag36.setPageContext(pageContext);
        __tag36.setParent(null);
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag36;
        __result__tag36 = __tag36.doStartTag();

        if (__result__tag36!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag36== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag36.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag36);
            return true;
        }
        _activeTag=__tag36.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag36);
        __tag36.release();
        return false;
    }

    private boolean _jsp__tag37(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag37 = null ;
        int __result__tag37 = 0 ;

        if (__tag37 == null ){
            __tag37 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag37);
        }
        __tag37.setPageContext(pageContext);
        __tag37.setParent(null);
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonForContact.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag37;
        __result__tag37 = __tag37.doStartTag();

        if (__result__tag37!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag37== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag37.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag37);
            return true;
        }
        _activeTag=__tag37.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag37);
        __tag37.release();
        return false;
    }

    private boolean _jsp__tag38(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag38 = null ;
        int __result__tag38 = 0 ;

        if (__tag38 == null ){
            __tag38 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag38);
        }
        __tag38.setPageContext(pageContext);
        __tag38.setParent(null);
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReceivingDateTime.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag38;
        __result__tag38 = __tag38.doStartTag();

        if (__result__tag38!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag38== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag38.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag38);
            return true;
        }
        _activeTag=__tag38.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag38);
        __tag38.release();
        return false;
    }

    private boolean _jsp__tag39(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag39 = null ;
        int __result__tag39 = 0 ;

        if (__tag39 == null ){
            __tag39 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag39);
        }
        __tag39.setPageContext(pageContext);
        __tag39.setParent(null);
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag39;
        __result__tag39 = __tag39.doStartTag();

        if (__result__tag39!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag39== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag39.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag39);
            return true;
        }
        _activeTag=__tag39.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag39);
        __tag39.release();
        return false;
    }

    private boolean _jsp__tag40(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag40 = null ;
        int __result__tag40 = 0 ;

        if (__tag40 == null ){
            __tag40 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag40);
        }
        __tag40.setPageContext(pageContext);
        __tag40.setParent(null);
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.mode.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag40;
        __result__tag40 = __tag40.doStartTag();

        if (__result__tag40!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag40== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag40.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag40);
            return true;
        }
        _activeTag=__tag40.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag40);
        __tag40.release();
        return false;
    }

    private boolean _jsp__tag41(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag41 = null ;
        int __result__tag41 = 0 ;

        if (__tag41 == null ){
            __tag41 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag41);
        }
        __tag41.setPageContext(pageContext);
        __tag41.setParent(null);
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.email.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag41;
        __result__tag41 = __tag41.doStartTag();

        if (__result__tag41!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag41== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag41.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag41);
            return true;
        }
        _activeTag=__tag41.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag41);
        __tag41.release();
        return false;
    }

    private boolean _jsp__tag42(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag42 = null ;
        int __result__tag42 = 0 ;

        if (__tag42 == null ){
            __tag42 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag42);
        }
        __tag42.setPageContext(pageContext);
        __tag42.setParent(null);
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.telephone.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag42;
        __result__tag42 = __tag42.doStartTag();

        if (__result__tag42!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag42== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag42.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag42);
            return true;
        }
        _activeTag=__tag42.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag42);
        __tag42.release();
        return false;
    }

    private boolean _jsp__tag43(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag43 = null ;
        int __result__tag43 = 0 ;

        if (__tag43 == null ){
            __tag43 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag43);
        }
        __tag43.setPageContext(pageContext);
        __tag43.setParent(null);
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fax.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag43;
        __result__tag43 = __tag43.doStartTag();

        if (__result__tag43!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag43== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag43.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag43);
            return true;
        }
        _activeTag=__tag43.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag43);
        __tag43.release();
        return false;
    }

    private boolean _jsp__tag44(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag44 = null ;
        int __result__tag44 = 0 ;

        if (__tag44 == null ){
            __tag44 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag44);
        }
        __tag44.setPageContext(pageContext);
        __tag44.setParent(null);
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.InPerson.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag44;
        __result__tag44 = __tag44.doStartTag();

        if (__result__tag44!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag44== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag44.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag44);
            return true;
        }
        _activeTag=__tag44.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag44);
        __tag44.release();
        return false;
    }

    private boolean _jsp__tag45(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag45 = null ;
        int __result__tag45 = 0 ;

        if (__tag45 == null ){
            __tag45 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag45);
        }
        __tag45.setPageContext(pageContext);
        __tag45.setParent(null);
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Web.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag45;
        __result__tag45 = __tag45.doStartTag();

        if (__result__tag45!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag45== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag45.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag45);
            return true;
        }
        _activeTag=__tag45.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag45);
        __tag45.release();
        return false;
    }

    private boolean _jsp__tag46(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag46 = null ;
        int __result__tag46 = 0 ;

        if (__tag46 == null ){
            __tag46 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag46);
        }
        __tag46.setPageContext(pageContext);
        __tag46.setParent(null);
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.other.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag46;
        __result__tag46 = __tag46.doStartTag();

        if (__result__tag46!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag46== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag46.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag46);
            return true;
        }
        _activeTag=__tag46.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag46);
        __tag46.release();
        return false;
    }

    private boolean _jsp__tag47(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag47 = null ;
        int __result__tag47 = 0 ;

        if (__tag47 == null ){
            __tag47 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag47);
        }
        __tag47.setPageContext(pageContext);
        __tag47.setParent(null);
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Language.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag47;
        __result__tag47 = __tag47.doStartTag();

        if (__result__tag47!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag47== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag47.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag47);
            return true;
        }
        _activeTag=__tag47.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag47);
        __tag47.release();
        return false;
    }
}
