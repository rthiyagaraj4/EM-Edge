package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOT.ChkOutFromORBean;
import java.sql.Connection;
import java.sql.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.*;
import eOR.*;
import eOR.Common.*;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __checkoutfromor extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/CheckOutFromOR.jsp", 1709120192000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\" />\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script> \n<script language=\"Javascript\" src=\"../../eCommon/js/common.js\" ></script>\n<script language=\"Javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"Javascript\" src=\"../../eOT/js/OTCommon.js\"></script>\n<script language=\"JavaScript\" src=\"../../eOT/js/CheckOutFromOR.js\"></script>\n<script type=\'text/javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<body onload=\'assignLegend();callChargableUnits();\'OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<body onload=\'assignLegend();\'OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<form name=\'CheckOutFromORForm\' id=\'CheckOutFromORForm\'>\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\n\t<tr>\n\t\t<td colspan=\"8\" class=\'CAGROUPHEADING\'>\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t</td> \n\t</tr>\n\t<tr>\n\t\t<td colspan=\"6\" class=\'CAGROUPHEADING\'></td> \n\t</tr>\n\t<tr>\n\t\t<td class=\'label\' width=\'8%\'>\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" &nbsp;\n\t\t</td>\n\t\t<td class=\'label\' width=\'25%\'>\n\t\t\t<input type=\'checkbox\' name=\'check_out\' id=\'check_out\' onClick=\'validateCheckBox();\'>\n\t\t\t<input type=\'hidden\' name=\'check_out_time\' id=\'check_out_time\' size=\'3\' maxlength=\'3\' >\n\t\t</td>\n\n\t\t<td class=\'label\' width=\'15%\'>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t</td> \n\t\t<td >\n\t\t\t<select name=\"transfer\" id=\"transfer\" onchange=\"disableWardAndStatus(); assignLegend();\" >\n\t\t\t<option value=\'W\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</option>\n\t\t\t<option value=\'M\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</option>\n\t\t\t<option value=\'R\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</option>\n\t\t<!-- Added by Muthukumar on 06-02-12 -->\n\t\t\t<option value=\'H\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</option>\n\t\t<!-- Added by Muthukumar on 06-02-12 -->\n\t\t\t</select>&nbsp;\n\t\t\t\t<img id=\"img1\" src=\'../../eCommon/images/Blank1.gif\' >\n\t\t</td>\n\n\t\t<td class=\'label\' ></td> \n\t\t<td class=\'label\' align=\'right\' id=\"test\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" &nbsp;</td>\n\t\t<td class=\'label\' align=\'left\' nowrap>\n\t\t\t<input type=\'hidden\' name=\'ward_code\' id=\'ward_code\' value=\'\' >\n\t\t\t<!-- ML-MMOH-CRF-0752.3-US001 -->\n\t\t\t<input type=\'text\' name=\'ward_desc\' id=\'ward_desc\' id=\'hidedesc\' size=\'36\' onBlur=\"if(this.value!=\'\')srchCommonCode(ward_code,ward_desc,transfer.options[transfer.selectedIndex].text,document.forms[0].qry_sql.value);else ward_code.value=\'\' \">\n\t\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'CommonLookUp1\' id=\'CommonLookUp1\' id=\'hidelookup\'onClick=\"srchCommonCode(ward_code,ward_desc,transfer.options[transfer.selectedIndex].text,document.forms[0].qry_sql.value);\" >\n\t\t\t<img id=\"img2\" src=\'../../eCommon/images/Blank1.gif\' >\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t\t<td class=\'label\' align=\'right\' nowrap>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td> \n\t\t\t<td align=\'left\' nowrap>\n\t\t\t\t<input type=\'text\' name=\'check_in_dt_time\' id=\'check_in_dt_time\' size=\'15\'  value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' disabled>\n\t\t\t</td>\n\n\t\t\t<td class=\'label\' align=\'right\' nowrap>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t\t<td align=\'left\' nowrap width>\n\t\t\t\t<select name=\"status\" id=\"status\"  >\n\t\t\t\t\t<option value=\"\">---";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="---</option>\n\t\t\t\t\t<option value=\'I\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</option>\n\t\t\t\t\t<option value=\'E\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</option>\n\t\t\t\t</select>\t\t\t\t\n\t\t\t\t</td>\n\t</tr>\n\t<tr>\n\n\t<!-- Modified by DhanasekarV against issue IN026657 -->\n\t\t\t<td class=\'label\' align=\'right\' nowrap>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td> \n\t\t\t<td align=\'left\' nowrap>\n\t\t\t\t<!--input type=\'text\' name=\'check_out_date\' size=\'10\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' onblur=\"if(validateDate(check_out_date)==true && document.forms[0].check_out_date.value!=\'\') validateDateTime();\" onkeypress=\"return checkForSpecCharsforID(event);\" -->\n\t\t\t\t<input type=\'text\' name=\'check_out_date\' id=\'check_out_date\' size=\'10\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' onblur=\"if(isValidDate(check_out_date)==true && document.forms[0].check_out_date.value!=\'\') validateDateTime();\" onkeypress=\"return checkForSpecCharsforID(event);\" ><!--Modified Against SKR-SCF-1288-->\n\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\'onClick=\"return showCalendar(\'check_out_date\'); \">\n\t\t\t\t<input type=\'text\' name=\'check_out_time_or\' id=\'check_out_time_or\' size=\'4\' tabindex=\'0\' maxlength=\'6\' onkeypress=\"return checkSpecCharsforID(event);\" value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' onBlur=\'if(document.forms[0].check_out_date.value!=\"\")validateDateTime(); \'>\n\t\t\t\t<img id=\"img3\" src=\'../../eCommon/images/Blank1.gif\' >\t\t\t\t\t\n\t\t\t</td>\n\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t<td class=\'label\' tabindex=\'2\' width=\"25%\" id=\'pyble_unit_show_yn_td\'>\n\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" \n\t\t\t</td> \n\t\t\t <td class=\'fields\' width=\"25%\" id=\'pyble_unit_show_yn\' style=\'visible:inline;\'>\n\t\t\t\t\t<input type=\'text\' class=\'fields\' name=\'charge_units\' id=\'charge_units\' size=\'3\'  maxlength=\'3\' value=\'\' onblur=\"if(document.forms[0].check_out_time_or.value!=\'\')onBlurGetServPanelDtls(charge_units, serv_code);\" onkeypress=\"return checkForSpecCharsforID(event);\" tabindex=-1 disabled> <!--Modified Against SKR-SCF-1522-->\n\t\t\t\t\t<b id=\'cashcounter_desc\'></b>\n\t\t\t</td> \n\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t<td class=\'label\' width=\"25%\" id=\'pyble_unit_show_yn_td\'></td> \n\t\t\t <td class=\'fields\' width=\"25%\" id=\'pyble_unit_show_yn\' style=\'visible:inline;\' ></td> \n\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t</tr>\n\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t<tr>\n\t\t<td class=\'label\'></td>\n\t\t\t<td class=\"gridData\" colspan =\'3\' >\n\t\t\t\t<div id=\"charge_details_1\" style=\'visible:hidden;display:none\'>\n\t\t\t\t</div>\n\t\t</td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n</table>\n\t<input type=\"hidden\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' >\n\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t<input type=\'hidden\' name=\'bean_id\' id=\'bean_id\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' >\n\t<input type=\'hidden\' name=\'bean_name\' id=\'bean_name\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' >\n\t<input type=\'hidden\' name=\'params\' id=\'params\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' >\t\n\t<input type=\'hidden\' name=\'doc_comp_yn\' id=\'doc_comp_yn\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' >\t\n\t<input type=\'hidden\' name=\'check_out_flag\' id=\'check_out_flag\' value=\'N\' >\t\n\t<input type=\'hidden\' name=\'called_from\' id=\'called_from\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' >\n\t<input type=\'hidden\' name=\'slate_user_id\' id=\'slate_user_id\' value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t<input type=\'hidden\' name=\"order_id\" id=\"order_id\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t<input type=\'hidden\' name=\'oper_num\' id=\'oper_num\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' >\n\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' >\n\t<input type=\'hidden\' name=\'booking_num\' id=\'booking_num\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' >\n\t<input type=\'hidden\' name=\'speciality_code\' id=\'speciality_code\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' >\n\t<input type=\'hidden\' name=\'current_date_time_db\' id=\'current_date_time_db\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' >\n\t<input type=\'hidden\' name=\'module_id\' id=\'module_id\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' >\n\t<input type=\'hidden\' name=\'oper_room\' id=\'oper_room\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' >\n\t<input type=\'hidden\' name=\'oper_code\' id=\'oper_code\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' >\n\t<input type=\'hidden\' name=\'surgeon_code\' id=\'surgeon_code\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' >\n\t<input type=\'hidden\' name=\'check_in_recovery_time\' id=\'check_in_recovery_time\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' >\n\t<input type=\'hidden\' name=\"size\" id=\"size\" value=\'0\' >\n\t<input type=\'hidden\' name=\"size1\" id=\"size1\" value=\'0\' >\n\t<input type=\'hidden\' name=\"user_id\" id=\"user_id\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" >\n\t<input type=\'hidden\' name=\"no_of_verifications\" id=\"no_of_verifications\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t<input type=\'hidden\' name=\"role_id_1\" id=\"role_id_1\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t<input type=\'hidden\' name=\"role_id_2\" id=\"role_id_2\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t<input type=\'hidden\' name=\"role_id_3\" id=\"role_id_3\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t<input type=\'hidden\' name=\"role_id_4\" id=\"role_id_4\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t<input type=\'hidden\' name=\"checklist_completed_yn\" id=\"checklist_completed_yn\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t<input type=\'hidden\' name=\'post_oper_user1_completed_yn\' id=\'post_oper_user1_completed_yn\' value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t<input type=\'hidden\' name=\'post_oper_user2_completed_yn\' id=\'post_oper_user2_completed_yn\' value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t<input type=\'hidden\' name=\'post_oper_user3_completed_yn\' id=\'post_oper_user3_completed_yn\' value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t<input type=\'hidden\' name=\'post_oper_user4_completed_yn\' id=\'post_oper_user4_completed_yn\' value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t<input type=\'hidden\' name=\"old_post_oper_user1_id\" id=\"old_post_oper_user1_id\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t<input type=\'hidden\' name=\"old_post_oper_user2_id\" id=\"old_post_oper_user2_id\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t<input type=\'hidden\' name=\"old_post_oper_user3_id\" id=\"old_post_oper_user3_id\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t<input type=\'hidden\' name=\"old_post_oper_user4_id\" id=\"old_post_oper_user4_id\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t<input type=\'hidden\' name=\"check_for_check_list_compl\" id=\"check_for_check_list_compl\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t<input type=\'hidden\' name=\"current_date\" id=\"current_date\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\t<input type=\'hidden\' name=\"current_time\" id=\"current_time\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t<input type=\'hidden\' name=\"current_date_time\" id=\"current_date_time\" value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\t<input type=\'hidden\' name=\"verify_checklist_codes\" id=\"verify_checklist_codes\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t<input type=\'hidden\' name=\"chk_oper_room_yn\" id=\"chk_oper_room_yn\" value=\"\">\n\t<input type=\'hidden\' name=\"or_bill_accession_num\" id=\"or_bill_accession_num\" value=\"\">\n\t<input type=\'hidden\' name=\"calc_charge_units\" id=\"calc_charge_units\" value=\"\">\n\t<input type=\'hidden\' name=\"oper_room_chrging_stg\" id=\"oper_room_chrging_stg\" value=\"\">\n\t<input type=\'hidden\' name=\"episode_id\" id=\"episode_id\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t<input type=\'hidden\' name=\"episode_type\" id=\"episode_type\" value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t<input type=\'hidden\' name=\"visit_id\" id=\"visit_id\" value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t<input type=\'hidden\' name=\"oper_room_desc\" id=\"oper_room_desc\" value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t<input type=\'hidden\' name=\"oper_rm_chk_yn\" id=\"oper_rm_chk_yn\" value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t<input type=\'hidden\' name=\"charge_operating_room_yn\" id=\"charge_operating_room_yn\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t<input type=\'hidden\' name=\"bl_interface_flag\" id=\"bl_interface_flag\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t<input type=\'hidden\' name=\"chk_into_or_beforeConvert\" id=\"chk_into_or_beforeConvert\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n\t<input type=\'hidden\' name=\"customer_id\" id=\"customer_id\" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\"> <!-- Added against for MO-GN-5505 [IN058517] -->\n\t<input type=\'hidden\' name=\"bl_panel_str\" id=\"bl_panel_str\" value=\'\'>\n\t<input type=\'hidden\' name=\'include_exclude\' id=\'include_exclude\' value=\'\'>\n\t<input type=\'hidden\' name=\'appr_reqd_val\' id=\'appr_reqd_val\' value=\'\'>\n\t<input type=\'hidden\' name=\'reason_inc_exe\' id=\'reason_inc_exe\' value=\'\'>\n\t<input type=\'hidden\' name=\'inc_exe_blng_wdw\' id=\'inc_exe_blng_wdw\' value=\'\'>\n\n\t<input type=\'hidden\' name=\"bill_service_code\" id=\"bill_service_code\" value=\"\">\n\t<input type=\"hidden\" name=\"qry_sql\" id=\"qry_sql\" value=\"\" disabled>\n\t<input type=\"hidden\" name=\"multi_check_in_yn\" id=\"multi_check_in_yn\" id=\"multi_check_in_yn\" value=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\'><!-- PMG KDAH CRF-0001 -->\n</form>\n</html>\n\n";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
}

	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	String locale = (String)session.getAttribute("LOCALE"); 
	String facility_id = (String) session.getAttribute("facility_id");
	Connection conn=null;
	Statement stmt = null ;
	Statement stmt1 = null ;
	ResultSet resultSet			= null ;
	ResultSet resultSet1			= null ;
	String current_date	= "",current_time	= "",current_date_time= "",charge_operating_room_yn= "",bl_interface_flag= "",current_date_time_db="",current_time_db="";
	String multi_check_in_yn="";//PMG2016-KDAH-CRF-0001
	try
	{
		conn	= ConnectionManager.getConnection(request);
		}catch(Exception e){
			System.err.println("Err in ChkOutFromOR.jsp ----> "+e);
			e.printStackTrace();
		}
		finally{
			try{
					if(resultSet!=null) resultSet.close();
					if(stmt!=null) stmt.close();
					ConnectionManager.returnConnection(conn,request);
				}catch(Exception es){
					es.printStackTrace();
				}
		}
	
	String surgeon_doc_comp_yn = CommonBean.checkForNull(request.getParameter("surgeon_doc_comp_yn"));
	String nursing_doc_comp_yn = CommonBean.checkForNull(request.getParameter("nursing_doc_comp_yn"));
	String anaesthesia_doc_comp_yn = CommonBean.checkForNull(request.getParameter("anaesthesia_doc_comp_yn"));
	String called_from		= CommonBean.checkForNull(request.getParameter("called_from"));
	String slate_user_id	= CommonBean.checkForNull(request.getParameter("slate_user_id"));
	String oper_num			= CommonBean.checkForNull(request.getParameter("oper_num"));
	String order_id			= CommonBean.checkForNull(request.getParameter("order_id"));
	String module_id		= CommonBean.checkForNull(request.getParameter("module_id"));
	String patient_id		= CommonBean.checkForNull(request.getParameter("patient_id"));
	String oper_code		= CommonBean.checkForNull(request.getParameter("oper_code"));
	String surgeon_code		= CommonBean.checkForNull(request.getParameter("surgeon_code"));
	String mode	= CommonBean.checkForNull(request.getParameter("mode"));
	mode = CommonRepository.getCommonKeyValue("MODE_INSERT");
	String role_id_1		= "",role_id_2		= "",role_id_3		= "",role_id_4		= "",verify_checklist_codes="",old_post_oper_user1_id	= "",old_post_oper_user2_id	= "",old_post_oper_user3_id	= "",old_post_oper_user4_id	= "";
	String booking_num		= CommonBean.checkForNull(request.getParameter("booking_num"));
	String speciality_code	= CommonBean.checkForNull(request.getParameter("speciality_code"),"");
	String checklist_completed_yn = "N";
	String post_oper_user1_completed_yn = "N";
	String post_oper_user2_completed_yn = "N";
	String post_oper_user3_completed_yn = "N";
	String post_oper_user4_completed_yn = "N";
	String check_for_check_list_compl = "N";
	String no_of_verifications = "1";
	String bean_id = "ChkOutFromORBean";
	String bean_name = "eOT.ChkOutFromORBean";

	String check_in_recovery_time = "",cur_date="",cur_time="",doc_comp_yn="",chk_into_or="",episode_id="",episode_type="",visit_id="",oper_room_desc="",oper_rm_chk_yn="",patient_class="",bl_episode_type="",oper_room_code="",customer_id="",chk_into_or_beforeConvert="";
	// customer_id added against for MO-GN-5505 [IN058517]

	try
	{
		conn	= ConnectionManager.getConnection(request);
		stmt	= conn.createStatement() ;
		stmt1	= conn.createStatement() ;

		String sql_curr_date="SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') CUR_DATE,TO_CHAR(SYSDATE,'HH24:MI') CUR_TIME,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI')  CURRENT_DATE_TIME FROM DUAL";
		resultSet			= stmt.executeQuery(sql_curr_date);

		if(resultSet!=null && resultSet.next()){
			current_time_db = resultSet.getString("CUR_DATE");
			//current_time_db = resultSet.getString("CUR_TIME");
			current_date=checkForNull(com.ehis.util.DateUtils.convertDate(resultSet.getString("CUR_DATE"),"DMY","en",locale));
			current_time=resultSet.getString("CUR_TIME");
			//current_time = resultSet.getString("CUR_TIME");
			current_date_time_db = com.ehis.util.DateUtils.convertDate(resultSet.getString("CURRENT_DATE_TIME"),"DMYHM","en",locale);
			current_date_time=com.ehis.util.DateUtils.convertDate(resultSet.getString("CURRENT_DATE_TIME"),"DMYHM","en",locale);
		}

		String sql_param_check="SELECT BL_INTERFACE_FLAG,CHARGE_OPERATING_ROOM_YN,MULTI_CHECK_IN_YN FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID='"+facility_id+"'";//PMG2016-KDAH-CRF-0001
		resultSet			= stmt.executeQuery(sql_param_check);

		if(resultSet!=null && resultSet.next()){
				bl_interface_flag = resultSet.getString("BL_INTERFACE_FLAG");
				charge_operating_room_yn = resultSet.getString("CHARGE_OPERATING_ROOM_YN");
				multi_check_in_yn=resultSet.getString("MULTI_CHECK_IN_YN");//PMG2016-KDAH-CRF-0001
		}

		String sql_chk_in_or="SELECT A.EPISODE_ID EPISODE_ID,A.EPISODE_TYPE EPISODE_TYPE,A.VISIT_ID VISIT_ID,TO_CHAR(A.CHECK_INTO_OR_TIME,'DD/MM/YYYY HH24:MI') CHECK_INTO_OR_TIME,A.OPER_ROOM_CODE, (SELECT SHORT_DESC FROM OT_OPER_ROOM WHERE OPER_ROOM_CODE=A.OPER_ROOM_CODE) OPER_ROOM_DESC, A.PATIENT_CLASS PATIENT_CLASS FROM OT_POST_OPER_HDR A WHERE OPER_NUM='"+oper_num+"' AND OPERATING_FACILITY_ID='"+facility_id+"' ";

		resultSet1			= stmt1.executeQuery(sql_chk_in_or);
		if(resultSet1!=null && resultSet1.next()){
			chk_into_or_beforeConvert = CommonBean.checkForNull(resultSet1.getString("CHECK_INTO_OR_TIME")); //Added Against SKR-SCF-1288
			chk_into_or=checkForNull(com.ehis.util.DateUtils.convertDate(resultSet1.getString("CHECK_INTO_OR_TIME"),"DMYHM","en",locale));
			oper_room_code = CommonBean.checkForNull(resultSet1.getString("OPER_ROOM_CODE"));
			episode_id = CommonBean.checkForNull(resultSet1.getString("EPISODE_ID"));
			episode_type = CommonBean.checkForNull(resultSet1.getString("EPISODE_TYPE"));
			visit_id = CommonBean.checkForNull(resultSet1.getString("VISIT_ID"));
			oper_room_desc = CommonBean.checkForNull(resultSet1.getString("OPER_ROOM_DESC"));
			patient_class = CommonBean.checkForNull(resultSet1.getString("PATIENT_CLASS"));
		}

		if(resultSet1!=null) resultSet1.close();

		String sql_chk_eps_type="SELECT BL_EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS = '"+patient_class+"' AND EPISODE_TYPE ='"+episode_type+"' ";

		resultSet1			= stmt1.executeQuery(sql_chk_eps_type);
		if(resultSet1!=null && resultSet1.next()){
			bl_episode_type= CommonBean.checkForNull(resultSet1.getString("bl_episode_type"));	
		}

		if(resultSet1!=null) resultSet1.close();

		String sql_oper_room_chrg_yn="SELECT CHARGEABLE_YN FROM OT_OPER_ROOM_LANG_VW WHERE OPER_ROOM_CODE='"+oper_room_code+"' AND LANGUAGE_ID='"+locale+"'";
			resultSet1		= stmt1.executeQuery(sql_oper_room_chrg_yn);
			if(resultSet1!=null && resultSet1.next()){
				oper_rm_chk_yn = CommonBean.checkForNull(resultSet1.getString("CHARGEABLE_YN"));
			}
		/* Added start against for MO-GN-5505 [IN058517] */
		if(resultSet1!=null) resultSet1.close();
		
		String sql_customer_id="SELECT CUSTOMER_ID FROM SM_SITE_PARAM WHERE ROWNUM = 1";
		resultSet1		= stmt1.executeQuery(sql_customer_id);
		if(resultSet1!=null && resultSet1.next()){
				customer_id = CommonBean.checkForNull(resultSet1.getString("CUSTOMER_ID"));
			}
		/* Added end against for MO-GN-5505 [IN058517] */
				
		if ( mode == null || mode.equals("") )
			return ;
		if ( !(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
			return ;

		ChkOutFromORBean bean = (ChkOutFromORBean)getBeanObject( bean_id,bean_name,request);
		bean.clear();

		String list[] =  bean.getAllDocumentionReqdYN(facility_id);
		
		surgeon_doc_comp_yn=("N"==list[0].intern() )?"Y":surgeon_doc_comp_yn;
		nursing_doc_comp_yn=("N"==list[1].intern() )?"Y":nursing_doc_comp_yn;
		anaesthesia_doc_comp_yn=("N"==list[2].intern() )?"Y":anaesthesia_doc_comp_yn;
		
		String anaesthesia_eval_reqd_yn = bean.getAnaesthesiaApplicableYN(order_id);
		if("N".equals(anaesthesia_eval_reqd_yn)){
			doc_comp_yn=( surgeon_doc_comp_yn.equals("Y") && nursing_doc_comp_yn.equals("Y") )?"Y":"N";
		}else{
			doc_comp_yn=( surgeon_doc_comp_yn.equals("Y") && nursing_doc_comp_yn.equals("Y") &&  "Y".equals(anaesthesia_doc_comp_yn) )?"Y":"N";
		}

		ArrayList timeList = bean.getSysDateTime();
		cur_date= (String) timeList.get(1);
		cur_time = (String) timeList.get(2);
		bean.loadDisposalDtls(locale,facility_id,oper_num);
		check_for_check_list_compl = bean.getCheckListReqdYNFlag(locale,"23");	
		order_id			= CommonBean.checkForNull(request.getParameter("order_id"),"");

		int no_of_verifications_int = 1;

		ArrayList verify_checklist_arr = null;
		ArrayList user_info_arr = null;

		verify_checklist_arr	= new ArrayList();
		user_info_arr			= new ArrayList();

		verify_checklist_arr = bean.getOperChecklists(booking_num,oper_num,speciality_code,order_id); 
		if(verify_checklist_arr.size()>0){
			verify_checklist_codes=(String)verify_checklist_arr.get(0);
			no_of_verifications = (String)verify_checklist_arr.get(1);
			no_of_verifications=no_of_verifications==null?"1":no_of_verifications;
			no_of_verifications=no_of_verifications.equalsIgnoreCase("null")?"1":no_of_verifications;
			no_of_verifications=no_of_verifications.equals("null")?"1":no_of_verifications;
			no_of_verifications_int = Integer.parseInt(no_of_verifications);
			role_id_1 = (String)verify_checklist_arr.get(2);
			role_id_2 = (String)verify_checklist_arr.get(3);
			role_id_3 = (String)verify_checklist_arr.get(4);
			role_id_4 = (String)verify_checklist_arr.get(5);
		}else{
			verify_checklist_codes="";
			no_of_verifications = "";
			no_of_verifications_int = 1;
			role_id_1 = "";
			role_id_2 = "";
			role_id_3 = "";
			role_id_4 = "";
		}
		user_info_arr = (ArrayList)bean.getUserInfo(facility_id,booking_num,oper_num,"1",order_id);
		if(user_info_arr.size()>0){
			post_oper_user1_completed_yn = (String)user_info_arr.get(9);
			post_oper_user2_completed_yn = (String)user_info_arr.get(11);
			post_oper_user3_completed_yn = (String)user_info_arr.get(13);
			post_oper_user4_completed_yn = (String)user_info_arr.get(15);

			old_post_oper_user1_id		 = (String)user_info_arr.get(8);
			old_post_oper_user2_id		 = (String)user_info_arr.get(10);
			old_post_oper_user3_id		 = (String)user_info_arr.get(12);
			old_post_oper_user4_id		 = (String)user_info_arr.get(14);

			if(no_of_verifications_int==1){
				if(post_oper_user1_completed_yn.equals("Y"))
					checklist_completed_yn		 = "Y";
				else
					checklist_completed_yn		 = "N";
			}else if(no_of_verifications_int==2){ 
				if(post_oper_user1_completed_yn.equals("Y") && post_oper_user2_completed_yn.equals("Y"))
					checklist_completed_yn		 = "Y";
				else
					checklist_completed_yn		 = "N";
			}else if(no_of_verifications_int==3){ 
				if(post_oper_user1_completed_yn.equals("Y") && post_oper_user2_completed_yn.equals("Y") && post_oper_user3_completed_yn.equals("Y"))
					checklist_completed_yn		 = "Y";
				else
					checklist_completed_yn		 = "N";
			}else if(no_of_verifications_int==4){ 
				if(post_oper_user1_completed_yn.equals("Y") && post_oper_user2_completed_yn.equals("Y") && post_oper_user3_completed_yn.equals("Y") && post_oper_user4_completed_yn.equals("Y"))
				checklist_completed_yn		 = "Y";
			}else
				checklist_completed_yn		 = "N";
			}else{
				old_post_oper_user1_id		 = "";
				old_post_oper_user2_id		 = "";
				old_post_oper_user3_id		 = "";
				checklist_completed_yn		 = "N";
			}
		
		}catch(Exception e){
			System.err.println("Err in ChkOutFromOR.jsp ----> "+e);
			e.printStackTrace();
		}
	finally{
		try{
				if(resultSet1!=null) resultSet1.close();
				if(stmt1!=null) stmt1.close();
				ConnectionManager.returnConnection(conn,request);
			}catch(Exception es){
				es.printStackTrace();
			}
	}
	// till here
	// End of Verify CheckList Logic	

            _bw.write(_wl_block9Bytes, _wl_block9);
if(bl_interface_flag.equals("Y") && charge_operating_room_yn.equals("Y") && oper_rm_chk_yn.equals("Y")){
            _bw.write(_wl_block10Bytes, _wl_block10);
}else{
            _bw.write(_wl_block11Bytes, _wl_block11);
}
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(chk_into_or));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(current_date));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(current_date));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(current_time));
            _bw.write(_wl_block30Bytes, _wl_block30);
if(bl_interface_flag.equals("Y") && charge_operating_room_yn.equals("Y") && oper_rm_chk_yn.equals("Y")){
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
}else{
            _bw.write(_wl_block33Bytes, _wl_block33);
}
            _bw.write(_wl_block34Bytes, _wl_block34);
if(bl_interface_flag.equals("Y") && charge_operating_room_yn.equals("Y") && oper_rm_chk_yn.equals("Y")){
            _bw.write(_wl_block35Bytes, _wl_block35);
 } 
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(doc_comp_yn));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(slate_user_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(oper_num));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(booking_num));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(current_time_db));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(oper_room_code));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(oper_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(surgeon_code));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(check_in_recovery_time));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(slate_user_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(no_of_verifications));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(role_id_1));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(role_id_2));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(role_id_3));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(role_id_4));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(checklist_completed_yn));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(post_oper_user1_completed_yn));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(post_oper_user2_completed_yn));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(post_oper_user3_completed_yn));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(post_oper_user4_completed_yn));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(old_post_oper_user1_id));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(old_post_oper_user2_id));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(old_post_oper_user3_id));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(old_post_oper_user4_id));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(check_for_check_list_compl));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(current_date));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(current_time));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(current_date_time));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(verify_checklist_codes));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(bl_episode_type));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(oper_room_desc));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(oper_rm_chk_yn));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(charge_operating_room_yn));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(bl_interface_flag));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(chk_into_or_beforeConvert));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(customer_id));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(multi_check_in_yn ));
            _bw.write(_wl_block86Bytes, _wl_block86);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.CheckOutFromOR.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CheckOut.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TransferTo.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Ward.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Mortuary.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.RecoveryRoom.Label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.home.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Ward.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.CheckinToORDateTime.Label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Intubated.Label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Extubated.Label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.CheckOutFromORDateTime.Label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ChargableUnits.Label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
