package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import webbeans.eCommon.ConnectionManager;
import java.net.URLDecoder;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import java.util.ArrayList;
import eOT.HoldingAreaBean;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __holdingarea extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/HoldingArea.jsp", 1709120226000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<html>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\" />\n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script type=\'text/javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script type=\'text/javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script type=\'text/javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n<script type=\'text/javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script type=\'text/javascript\' src=\'../../eOT/js/HoldingArea.js\'></script>\n<script type=\'text/javascript\' src=\'../../eOT/js/OTCommon.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n<form name=\'HoldingAreaForm\' id=\'HoldingAreaForm\'  >\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<body onLoad=\"isRecordVitalEnable(); assignSpecialityCode();\" OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<body onLoad=\"isRecordVitalEnable(); assignSpecialityCode(); assignChkInOutTime();\" OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\t\t\t\t\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<table cellpadding=3  cellspacing=\'0\' border=\'0\' width=\'100%\' align=\'center\'>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n<tr>\n\t<td width=\'25%\' colspan=\"4\" class=\'CAGROUPHEADING\'>\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" \n\t</td> \n</tr>\n<tr>\n\t<td class=\'label\' width=\"25%\">\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" \n\t</td> \n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t<td class=\'fields\' width=\"25%\" >\n\t\t\t<input type=\'text\' class=\'fields\' name=\'check_in_date\' id=\'check_in_date\' size=\'8\'  value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' readonly>\n\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\'onClick=\"return showCalendar_loc_chk(\'check_in_date\');\"> \n\t\t\t<input type=\'text\' class=\'fields\' name=\'check_date_time\' id=\'check_date_time\' size=\'2\'  maxlength=\'5\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' onBlur=\'checkTime(this),checkInTimeChargeUnits(this);\' onkeypress=\"return checkForSpecCharsforIDTime(event);\" > <img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t</td>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'  disabled>\n\t\t\t<input type=\'text\' class=\'fields\' name=\'check_date_time\' id=\'check_date_time\' size=\'2\'  maxlength=\'5\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' onBlur=\'checkTime(this);\' disabled>\n\t</td>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t<td  class=\'label\' width=\"25%\"> \n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t<td  class=\'fields\' width=\"25%\" > \n\t\t\t<input type=\'hidden\' class=\'fields\' name=\'change_holding_code\' id=\'change_holding_code\' value=\'\'>\n\t\t\t<input type=\'text\' class=\'fields\' name=\'change_holding_desc\' id=\'change_holding_desc\' size=\'30\'  value=\'\' onBlur=\"if(this.value!=\'\')searchHoldingAreaBay(change_holding_code, change_holding_desc);\">\n\t\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'HoldingBayLookUp\' id=\'HoldingBayLookUp\' onClick=\'searchHoldingAreaBay(change_holding_code, change_holding_desc);\'><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t</td>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t<td  class=\'fields\' width=\"25%\" > \n\t\t\t<input type=\'hidden\' class=\'fields\' name=\'change_holding_code\' id=\'change_holding_code\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' disabled>\n\t\t\t<input type=\'text\' class=\'fields\' name=\'change_holding_desc\' id=\'change_holding_desc\' size=\'30\'  value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' onBlur=\"if(this.value!=\'\')searchHoldingAreaBay(change_holding_code, change_holding_desc);\" disabled>\t\t\n\t\t\t\n\t</td>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\n</tr>\n<tr>\n\t<td class=\'label\' width=\"25%\">\n\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t <td class=\'fields\' width=\"25%\" >\n\t ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t<input type=\'text\' class=\'fields\' name=\'change_out_date\' id=\'change_out_date\' size=\'8\'  value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' onblur=\'validateDate();\' onkeypress=\"return checkForSpecCharsforID(event);\" >\n\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\'onClick=\"return showCalendar_loc(\'change_out_date\');\"> \n\t\t\t<input type=\'text\' class=\'fields\' name=\'change_out_date_time\' id=\'change_out_date_time\' size=\'2\' onkeypress=\"return checkForSpecCharsforIDTime(event);\" maxlength=\'5\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' onBlur=\'if(document.forms[0].change_out_date.value!=\"\")validateDateTime();\' ><!--Added cur_date and cur_time Against TH-KW-CRF-0135-->\n\t\t\t\t<!--<img src=\'../../eCommon/images/mandatory.gif\'></img> -->\n\t\t\t\t<img id=\"hold_area_img\" src=\'../../eCommon/images/mandatory.gif\' style=\'position:absolute;visibility:visible\'></img>\t\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t<input type=\'text\' class=\'fields\' name=\'change_out_date\' id=\'change_out_date\' size=\'8\'  value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' onBlur=\'if(document.forms[0].change_out_date.value!=\"\")validateDateTime();\' ><!--Added cur_date and cur_time Against TH-KW-CRF-0135-->\n\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\n\t  </td> \n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t<input type=\'text\' class=\'fields\' name=\'change_out_date\' id=\'change_out_date\' size=\'8\'  value=\'\' onblur=\'validateDate();\' onkeypress=\"return checkForSpecCharsforID(event);\" >\n\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\'onClick=\"return showCalendar_loc(\'change_out_date\');\"> \n\t\t\t<input type=\'text\' class=\'fields\' name=\'change_out_date_time\' id=\'change_out_date_time\' size=\'2\' onkeypress=\"return checkForSpecCharsforIDTime(event);\" maxlength=\'5\' value=\'\' onBlur=\'if(document.forms[0].change_out_date.value!=\"\")validateDateTime();\' >\n\t\t\t\t<!--<img src=\'../../eCommon/images/mandatory.gif\'></img> -->\n\t\t\t\t<img id=\"hold_area_img\" src=\'../../eCommon/images/mandatory.gif\' style=\'position:absolute;visibility:visible\'></img>\t\n\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t<input type=\'text\' class=\'fields\' name=\'change_out_date\' id=\'change_out_date\' size=\'8\'  value=\'\' onblur=\'validateDate();\' onkeypress=\"return checkForSpecCharsforID(event);\" >\n\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\'onClick=\"return showCalendar_loc(\'change_out_date\');\"> \n\t\t\t<input type=\'text\' class=\'fields\' name=\'change_out_date_time\' id=\'change_out_date_time\' size=\'2\' onkeypress=\"return checkForSpecCharsforIDTime(event);\" maxlength=\'5\' value=\'\' onBlur=\'if(document.forms[0].change_out_date.value!=\"\")validateDateTime();\' >\n\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t <td class=\'fields\' width=\"25%\" >\n\t\t\t<input type=\'text\' class=\'fields\' name=\'change_out_date\' id=\'change_out_date\' size=\'8\'  value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' onblur=\'validateDate();\' onkeypress=\"return checkForSpecCharsforID(event);\"  disabled>\n\t\t\t<input type=\'text\' class=\'fields\' name=\'change_out_date_time\' id=\'change_out_date_time\' size=\'2\' onkeypress=\"return checkForSpecCharsforIDTime(event);\" maxlength=\'5\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'disabled> \n\t  </td> \n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\n\t\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t<td class=\'label\' width=\"25%\" id=\'chrg_unit_show_yn\' style=\'visible:inline;\'>\n\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" \n\t</td> \n\t <td class=\'fields\' width=\"25%\" id=\'pyble_unit_show_yn\' style=\'visible:inline;\' onkeypress=\"return checkSpecCharsforID(event);\" >\n\t ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t<input type=\'text\' class=\'fields\' name=\'charge_units\' id=\'charge_units\' size=\'3\' maxlength=\'3\' onblur=\"onBlurHoldingAreaChrgUnitspayale(serv_code);\" value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' tabindex=-1>\n\t\t\t<b id=\'cashcounter_desc\'></b>\n\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t<input type=\'text\' class=\'fields\' name=\'charge_units\' id=\'charge_units\' size=\'3\' maxlength=\'3\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' disabled>\n\t\t\t<b id=\'cashcounter_desc\'></b>\n\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t</td> \n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t<td class=\'label\' width=\"25%\" id=\'chrg_unit_show_yn\' style=\'visible:hidden;\'></td>\n\t\t<td class=\'fields\' width=\"25%\" id=\'pyble_unit_show_yn\' style=\'visible:hidden;\'></td>\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\n</tr>\n<tr>\n<td class=\'label\'></td>\n\t<td class=\"gridData\" colspan =\'3\' >\n\t\t<div id=\"charge_details\" style=\'display:none;\'>\n\t\t</div>\n\t</td>\n</tr>\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\n<tr>\n\t<td width=\'25%\' colspan=\"4\" class=\'CAGROUPHEADING\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" </td>\n</tr>\n\n<tr>\n\t<td class=\'label\' width=\"25%\">\n\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =" \n\t</td> \n\t\t<td class=\'fields\' width=\"25%\" >\n\t\t\t<input type=\'text\' class=\'fields\' name=\'check_in_date\' id=\'check_in_date\' size=\'8\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'  disabled> \n\t\t\t<input type=\'text\' class=\'fields\' name=\'checked_in_date_time\' id=\'checked_in_date_time\' size=\'2\'  value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' disabled>\n\t\t</td>\n\t<td  class=\'label\' width=\"25%\"> \n\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" \n\t</td> \n\t<td  class=\'fields\' width=\"25%\" > \n\t\t<input type=\'hidden\' name=\'holding_bay_code\' id=\'holding_bay_code\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n\t\t<input type=\'text\' class=\'fields\' name=\'holding_bay_desc\' id=\'holding_bay_desc\' size=\'25\'  value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' disabled>\n\t</td>\n</tr>\n<tr>\n\t<td class=\'label\' width=\"25%\">\n\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =" \n\t</td> \n\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' disabled>\n\t\t\t<input type=\'text\' class=\'fields\' name=\'checked_out_date_time\' id=\'checked_out_date_time\' size=\'2\'  value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' disabled>\n\t</td> \n\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t <td class=\'fields\' width=\"25%\" >\n\t\t\t<input type=\'text\' class=\'fields\' name=\'change_out_date\' id=\'change_out_date\' size=\'8\'  value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' disabled>\n\t</td> \n\n\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =" \n\t</td> \n\t <td class=\'fields\' width=\"25%\" id=\'pyble_unit_show_yn\' style=\'visible:inline;\' >\n\t\t\t<input type=\'text\' class=\'fields\' name=\'charge_units\' id=\'charge_units\' size=\'3\' maxlength=\'3\'onkeypress=\"return checkSpecCharsforID(event);\"  value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' disabled>\n\t\t\t\n\t</td> \n\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t<td class=\'label\' width=\"25%\"></td>\n\t\t<td class=\'label\' width=\"25%\"></td>\n\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\n</tr>\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n<tr>\n<td class=\'label\'></td>\n\t<td class=\"gridData\" colspan =\'3\' >\n\t\t<div id=\"charge_details\" style=\'visible:hidden;\'>\n\t\t</div>\n\t</td>\n</tr>\n\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n<tr>\n\t<td width=\'25%\' colspan=\"4\" class=\'CAGROUPHEADING\'>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</td>\n</tr>\n\n<tr>\n\t<td class=\'label\' width=\"25%\">\n\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =" \n\t</td> \n\t<td class=\'fields\' width=\"25%\" >\n\t\t\t\t<input type=\'text\' name=\'change_date\' id=\'change_date\' size=\'8\' value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'  readonly>\n\t\t<image src=\'../../eCommon/images/CommonCalendar.gif\'onClick=\"return showCalendar_loc_chk(\'change_date\');\"\">\n\t\t<input type=\'text\' name=\'change_date_time\' id=\'change_date_time\' size=\'2\'  maxlength=\'5\' value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\' onBlur=\'checkTimeFormat(this);checkInTimeChargeUnits(this);\' onkeypress=\"return checkForSpecCharsforIDTime(event);\">\n\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img> \n\t</td>\n\t<td  class=\'label\' width=\"25%\"> \n\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =" \n\t</td> \n\t<td  class=\'fields\' width=\"25%\" > \n\t\t\t<input type=\'hidden\' name=\'change_holding_code_1\' id=\'change_holding_code_1\'>\n\t\t<input type=\'text\' class=\'fields\' name=\'change_holding_desc_1\' id=\'change_holding_desc_1\' size=\'25\'  value=\'\' onBlur=\"if(this.value!=\'\')searchChangeHoldingAreaBay(change_holding_code_1, change_holding_desc_1);\">\n\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'HoldingBayLookUp\' id=\'HoldingBayLookUp\' onClick=\'searchChangeHoldingAreaBay(change_holding_code_1, change_holding_desc_1);\' >\n\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t</td>\n</tr>\n<tr>\n\t<td class=\'label\' width=\"25%\">\n\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =" \n\t</td> \n\t ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =" <!--Added by lakshmi against change in holding area issue -->\n\t <td class=\'fields\' width=\"25%\" >\n\t\t\t\t<input type=\'text\' name=\'change_date_1\' id=\'change_date_1\' size=\'8\' value=\'\'  readonly>\n\t\t<image src=\'../../eCommon/images/CommonCalendar.gif\'onClick=\"shwCalendar_loc(\'change_date_1\');\">\n\t\t<input type=\'text\' name=\'change_date_time_1\' id=\'change_date_time_1\' size=\'2\'  maxlength=\'5\' value=\'\' onBlur=\' if(document.forms[0].change_date_time_1.value!=\"\")validateDtTime();\' onkeypress=\"return checkForSpecCharsforIDTime(event);\">\n\t\t<img id=\"change_hold_img\" src=\'../../eCommon/images/mandatory.gif\' style=\'position:absolute;visibility:visible\'></img>\t\n\t\t<!--<img src=\'../../eCommon/images/mandatory.gif\'></img>-->\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t<td>\n\t\t<input type=\'text\' name=\'change_date_1\' id=\'change_date_1\' size=\'8\' value=\'\'  readonly>\n\t\t<image src=\'../../eCommon/images/CommonCalendar.gif\'onClick=\"shwCalendar_loc(\'change_date_1\');\">\n\t\t<input type=\'text\' name=\'change_date_time_1\' id=\'change_date_time_1\' size=\'2\'  maxlength=\'5\' value=\'\' onBlur=\' if(document.forms[0].change_date_time_1.value!=\"\")validateDtTime();\' onkeypress=\"return checkForSpecCharsforIDTime(event);\">\t\t\n\t</td>\n\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t<td class=\'label\' width=\"25%\" id=\'chrg_unit_show_yn_1\' style=\'visible:inline;\'>\n\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =" \n\t</td> \n\t <td class=\'fields\' width=\"25%\" id=\'pyble_unit_show_yn_1\' style=\'visible:inline;\'>\n\t\t\t<input type=\'text\' class=\'fields\' name=\'charge_units_1\' id=\'charge_units_1\' onkeypress=\"return checkSpecCharsforID(event);\" onblur=\"getServPanelDtls(serv_code_1);\" size=\'3\' maxlength=\'3\' value=\'\' tabindex=-1>\n\t\t</td> \n\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\n</tr>\n";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n<tr>\n<td class=\'label\'></td>\n\t<td class=\"gridData\" colspan =\'3\' >\n\t\t<div id=\"charge_details_1\" style=\'visible:hidden;\'>\n\t\t</div>\n\t</td>\n</tr>\n\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\n<tr>\n<td class=\"fields\" width=\"25%\"> </td>\n<td class=\"fields\" width=\"25%\"> </td>\n<td class=\"fields\" width=\"25%\"> </td>\n\n\t\n</tr>\n</table>\n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'>\n<input type=\'hidden\' name=\'cur_date\' id=\'cur_date\' value=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\'>\n<input type=\'hidden\' name=\'cur_time\' id=\'cur_time\' value=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'>\n<input type=\'hidden\' name=\'oper_num\' id=\'oper_num\' value=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'>\n<input type=\'hidden\' name=\'slate_user_id\' id=\'slate_user_id\' value=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\'>\n<input type=\'hidden\' name=\'called_from\' id=\'called_from\' value=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'>\n<input type=\'hidden\' name=\'size\' id=\'size\' value=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'>\n<input type=\'hidden\' name=\'holding_bay_size\' id=\'holding_bay_size\' value=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\'>\n<input type=\'hidden\' name=\'module_id\' id=\'module_id\' value=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'>\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'>\n<input type=\'hidden\' name=\'booking_num\' id=\'booking_num\' value=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'>\n<input type=\'hidden\' name=\'order_id\' id=\'order_id\' value=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'>\n<input type=\'hidden\' name=\'speciality_code\' id=\'speciality_code\' value=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\'>\n<input type=\'hidden\' name=\'oper_code\' id=\'oper_code\' value=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\'>\n<input type=\'hidden\' name=\'surgeon_code\' id=\'surgeon_code\' value=\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\'>\n<input type=\'hidden\' name=\'chargable_amt\' id=\'chargable_amt\' value=\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\'>\n<input type=\'hidden\' name=\'inventry_chk_yn_DB\' id=\'inventry_chk_yn_DB\' value=\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\'>\n<input type=\'hidden\' name=\'charge_hold_area_yn_DB\' id=\'charge_hold_area_yn_DB\' value=\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\'>\n<input type=\'hidden\' name=\'calc_chrge_units\' id=\'calc_chrge_units\' value=\'\'>\n<input type=\'hidden\' name=\'panel_str\' id=\'panel_str\' value=\'\'>\n<input type=\'hidden\' name=\'bl_panel_str\' id=\'bl_panel_str\' value=\'\'>\n<input type=\'hidden\' name=\'calc_chrge_units_1\' id=\'calc_chrge_units_1\' value=\'\'>\n<input type=\'hidden\' name=\'accession_num\' id=\'accession_num\' value=\'\'>\n<input type=\'hidden\' name=\'accession_num_1\' id=\'accession_num_1\' value=\'\'>\n<input type=\'hidden\' name=\'function_id_temp\' id=\'function_id_temp\' value=\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\'>\n<input type=\'hidden\' name=\'bill_acc_num_DB\' id=\'bill_acc_num_DB\' value=\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\'>\n<input type=\'hidden\' name=\'checked_in_date_DB\' id=\'checked_in_date_DB\' value=\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\'>\n<input type=\'hidden\' name=\'checked_in_time_DB\' id=\'checked_in_time_DB\' value=\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\'>\n<input type=\'hidden\' name=\'checked_out_date_DB\' id=\'checked_out_date_DB\' value=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\'>\n<input type=\'hidden\' name=\'checked_out_time_DB\' id=\'checked_out_time_DB\' value=\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\'>\n<input type=\'hidden\' name=\'holding_area_code_DB\' id=\'holding_area_code_DB\' value=\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\'>\n<input type=\'hidden\' name=\'modified_charge_units_DB\' id=\'modified_charge_units_DB\' value=\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\'>\n<input type=\'hidden\' name=\'calc_chargeable_units_DB\' id=\'calc_chargeable_units_DB\' value=\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\'>\n<input type=\'hidden\' name=\'bill_accession_num\' id=\'bill_accession_num\' value=\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\'>\n<input type=\'hidden\' name=\'bill_acc_num_add\' id=\'bill_acc_num_add\' value=\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\'>\n<input type=\'hidden\' name=\'service_code\' id=\'service_code\' value=\'\'>\n<input type=\'hidden\' name=\'service_code_1\' id=\'service_code_1\' value=\'\'>\n<input type=\'hidden\' name=\'hold_area_chrging_stg\' id=\'hold_area_chrging_stg\' value=\'\'>\n<input type=\'hidden\' name=\'chk_holding_area_chrg_yn_stg\' id=\'chk_holding_area_chrg_yn_stg\' value=\'\'>\n<input type=\'hidden\' name=\'include_exclude\' id=\'include_exclude\' value=\'\'>\n<input type=\'hidden\' name=\'appr_reqd_val\' id=\'appr_reqd_val\' value=\'\'>\n<input type=\'hidden\' name=\'inc_exe_blng_wdw\' id=\'inc_exe_blng_wdw\' value=\'\'>\n<input type=\'hidden\' name=\'reason_inc_exc\' id=\'reason_inc_exc\' value=\'\'>\n<input type=\'hidden\' name=\'hide_hold_bay_1\' id=\'hide_hold_bay_1\' value=\'\'>\n<input type=\'hidden\' name=\'holding_seq_num_DB\' id=\'holding_seq_num_DB\' value=\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\'>\n\n\n</form>\n\n\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );
 
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


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", " text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType(" text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
 request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);

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

            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
 String locale = (String)session.getAttribute("LOCALE"); 

            _bw.write(_wl_block7Bytes, _wl_block7);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	String function_id_temp = checkForNull(request.getParameter("function_id_temp"));
	String oper_num = checkForNull(request.getParameter("oper_num"));
	String facility_id = checkForNull(request.getParameter("facility_id"));
	String slate_user_id = checkForNull(request.getParameter("slate_user_id"));
	String called_from = checkForNull(request.getParameter("called_from"));
	String module_id = checkForNull(request.getParameter("module_id"));
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String booking_num = checkForNull(request.getParameter("booking_num"));
	String order_id = checkForNull(request.getParameter("order_id"));
	String speciality_code = checkForNull(request.getParameter("speciality_code"));
	String oper_code = checkForNull(request.getParameter("oper_code"));
	String surgeon_code = checkForNull(request.getParameter("surgeon_code"));
	String chargable_amt="";
	String bean_id = "HoldingAreaBean";
	String bean_name = "eOT.HoldingAreaBean";
	HoldingAreaBean hold_bean = (HoldingAreaBean) mh.getBeanObject(bean_id, request, bean_name );
	String cur_date="";
	String cur_time="";
	ArrayList date_list = hold_bean.getSysDateTime(); // date_time, date, time
    cur_date = (String)date_list.get(1);
	cur_time = (String)date_list.get(2);
	hold_bean.loadHoldingAreaDtls(oper_num);
	ArrayList hold_area_list = hold_bean.getHoldingAreaDtls();
	int size = hold_area_list.size();
	String inventry_chk_yn="";
	String sql="",bill_acc_num_DB="",checked_in_date_DB="",checked_in_time_DB="",checked_out_date_DB="",checked_out_time_DB="",holding_area_code_DB="",holding_area_desc_DB="",modified_charge_units_DB="",calc_chargeable_units_DB="",holding_seq_num_DB="",charge_hold_area_yn="",oper_num_with_hb="";
	String checked_in_date_DB_disp="",checked_out_date_DB_disp="";
	String mode="insert";
	int bill_acc_temp=1;
	Connection con = null;
	Statement pstmt  = null;
	ResultSet rst = null;
	Connection conn	=null;
	Statement stmt  = null ;
	ResultSet rst1   = null ;
	try{
		conn = ConnectionManager.getConnection(request);
		stmt = conn.createStatement();
//Added ADDED_DATE in query for 25523 by Anitha on 12/16/2010
	 sql="SELECT A.BL_ACCESSION_NUM BILL_ACCESSION_NUM,A.HOLDING_AREA_CODE HOLDING_AREA_CODE,B.HOLDING_AREA_DESC HOLDING_AREA_DESC,TO_CHAR(A.CHECKED_IN_DATE_TIME,'DD/MM/YYYY') CHECKED_IN_DATE,TO_CHAR(A.CHECKED_IN_DATE_TIME,'HH24:MI') CHK_IN_TIME,TO_CHAR(A.CHECKED_OUT_DATE_TIME,'DD/MM/YYYY') CHECKED_OUT_DATE,TO_CHAR(A.CHECKED_OUT_DATE_TIME,'HH24:MI') CHK_OUT_TIME,A.CHARGEABLE_UNITS MODIFIED_CHARGE_UNITS,A.CALC_CHARGEABLE_UNITS CALC_CHARGEABLE_UNITS,NVL(A.HOLDING_SEQ_NUM,0) HOLDING_SEQ_NUM FROM OT_OPER_HOLDING_DTLS A, OT_HOLDING_AREAS_LANG_VW B WHERE B.LANGUAGE_ID = '"+locale+"' AND A.OPERATING_FACILITY_ID ='"+facility_id+"' AND A.OPER_NUM ='"+oper_num+"' AND  HOLDING_SEQ_NUM = (SELECT MAX(HOLDING_SEQ_NUM) FROM OT_OPER_HOLDING_DTLS WHERE OPERATING_FACILITY_ID ='"+facility_id+"' AND OPER_NUM ='"+oper_num+"') AND A.HOLDING_AREA_CODE = B.HOLDING_AREA_CODE ORDER BY A.ADDED_DATE";

		rst1=stmt.executeQuery(sql);
		while(rst1 !=null && rst1.next())
		{
			bill_acc_num_DB=checkForNull(rst1.getString(1));
			holding_area_code_DB=checkForNull(rst1.getString(2));
			holding_area_desc_DB=checkForNull(rst1.getString(3));
			checked_in_date_DB=checkForNull(rst1.getString(4));
			checked_in_time_DB=checkForNull(rst1.getString(5));
			checked_out_date_DB=checkForNull(rst1.getString(6));
			checked_out_time_DB=checkForNull(rst1.getString(7));
			modified_charge_units_DB=checkForNull(rst1.getString(8));
			calc_chargeable_units_DB=checkForNull(rst1.getString(9));
			holding_seq_num_DB=checkForNull(rst1.getString(10));
		}
	}catch(Exception e){
		e.printStackTrace();
		System.err.println(" Exception in Holding Area.jsp Bill_Accc_Num--->  "+e);
	}finally{
			if(rst1!=null) rst1.close();
			if(stmt!=null)stmt.close();
			if(conn!=null) conn.close();
		}

		if(!holding_seq_num_DB.equals("")){
			mode="update";
		}

		if(!holding_seq_num_DB.equals("") && mode.equals("insert")){
			bill_acc_temp=Integer.parseInt(holding_seq_num_DB)+1;
		}
		
//----------------------Forming Billing Accession Num Starts-----------------
if(function_id_temp.equals("33") && !oper_num_with_hb.equals("")){
		if(!bill_acc_num_DB.equals("")){
			oper_num_with_hb=bill_acc_num_DB.substring(0,12);
			bill_acc_temp=Integer.parseInt(holding_seq_num_DB)+1;

		}
}
//----------------------Forming Billing Accession Num Ends-----------------
			
	try{

		con = ConnectionManager.getConnection(request);
		pstmt = con.createStatement();
		 sql="SELECT NVL(BL_INTERFACE_FLAG,'N'),CHARGE_HOLDING_AREA_YN FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID='"+facility_id+"'";
		rst=pstmt.executeQuery(sql);
		if(rst !=null && rst.next())
		{
			inventry_chk_yn=rst.getString(1);
			charge_hold_area_yn=rst.getString(2);
		}
		if(inventry_chk_yn.equals("N"))	charge_hold_area_yn="N";
			 
	}catch(Exception e){
			e.printStackTrace();
			System.err.println("Err Msg from HoldingArea.jsp :"+e);
		}
		finally{
			if(rst!=null) rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null) con.close();
		}

if(function_id_temp.equals("")){ 
            _bw.write(_wl_block10Bytes, _wl_block10);
}else if( function_id_temp.equals("33")){
            _bw.write(_wl_block11Bytes, _wl_block11);
}
            _bw.write(_wl_block12Bytes, _wl_block12);
if(function_id_temp.equals("")){
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
if("".equals(checked_in_date_DB)) {
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(cur_date));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(cur_time));
            _bw.write(_wl_block18Bytes, _wl_block18);
}else{
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(checked_in_date_DB));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(checked_in_time_DB));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

if(size==0){

            _bw.write(_wl_block22Bytes, _wl_block22);
}else{
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(holding_area_code_DB));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(holding_area_desc_DB));
            _bw.write(_wl_block25Bytes, _wl_block25);
}
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
if("".equals(checked_out_time_DB)  && !"".equals(holding_area_desc_DB) ) { //Added holding_area_desc_DB Against TH-KW-CRF-0135
            _bw.write(_wl_block27Bytes, _wl_block27);
if("Y".equals(charge_hold_area_yn)) {
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(cur_date));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(cur_time));
            _bw.write(_wl_block30Bytes, _wl_block30);
}else {
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(cur_date));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(cur_time));
            _bw.write(_wl_block32Bytes, _wl_block32);
}
            _bw.write(_wl_block33Bytes, _wl_block33);
}else if("".equals(checked_out_time_DB)) { 
            _bw.write(_wl_block27Bytes, _wl_block27);
if("Y".equals(charge_hold_area_yn)) {
            _bw.write(_wl_block34Bytes, _wl_block34);
}else {
            _bw.write(_wl_block35Bytes, _wl_block35);
}
            _bw.write(_wl_block33Bytes, _wl_block33);
}else{
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(checked_out_date_DB));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(checked_out_time_DB));
            _bw.write(_wl_block38Bytes, _wl_block38);
}
            _bw.write(_wl_block39Bytes, _wl_block39);
if(("Y".equals(inventry_chk_yn) && "Y".equals(charge_hold_area_yn))){
	
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
if(modified_charge_units_DB.equals("")){
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(modified_charge_units_DB));
            _bw.write(_wl_block43Bytes, _wl_block43);
}else{
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(modified_charge_units_DB));
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block46Bytes, _wl_block46);
}else{
            _bw.write(_wl_block47Bytes, _wl_block47);
}
            _bw.write(_wl_block48Bytes, _wl_block48);
}else if(function_id_temp.equals("33")){ 
	//Added below lines for 25523 by Anitha on 12/16/2010
	checked_in_date_DB_disp=com.ehis.util.DateUtils.convertDate(checked_in_date_DB,"DMY","en",locale);
	checked_out_date_DB_disp=com.ehis.util.DateUtils.convertDate(checked_out_date_DB,"DMY","en",locale);

	
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(checked_in_date_DB_disp));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(checked_in_time_DB));
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(holding_area_code_DB));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(holding_area_desc_DB));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
if(!"".equals(checked_out_date_DB) && !"".equals(checked_out_time_DB)) {
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(checked_out_date_DB_disp));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(checked_out_time_DB));
            _bw.write(_wl_block59Bytes, _wl_block59);
}else{
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(cur_date));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(cur_time));
            _bw.write(_wl_block61Bytes, _wl_block61);
}
            _bw.write(_wl_block62Bytes, _wl_block62);
if(("Y".equals(inventry_chk_yn) && "Y".equals(charge_hold_area_yn))){
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(modified_charge_units_DB));
            _bw.write(_wl_block64Bytes, _wl_block64);
}else{
            _bw.write(_wl_block65Bytes, _wl_block65);
}
            _bw.write(_wl_block66Bytes, _wl_block66);
if(("Y".equals(inventry_chk_yn) && "Y".equals(charge_hold_area_yn))){
            _bw.write(_wl_block67Bytes, _wl_block67);
}
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(cur_date));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(cur_time));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
if("Y".equals(charge_hold_area_yn)) {
            _bw.write(_wl_block75Bytes, _wl_block75);
}else {
            _bw.write(_wl_block76Bytes, _wl_block76);
}
            _bw.write(_wl_block2Bytes, _wl_block2);
if(("Y".equals(inventry_chk_yn) && "Y".equals(charge_hold_area_yn))){
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);
}else{
            _bw.write(_wl_block65Bytes, _wl_block65);
}
            _bw.write(_wl_block79Bytes, _wl_block79);
if(("Y".equals(inventry_chk_yn) && "Y".equals(charge_hold_area_yn))){
            _bw.write(_wl_block80Bytes, _wl_block80);
}
            _bw.write(_wl_block2Bytes, _wl_block2);
 } 
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(cur_date));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(cur_time));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(oper_num));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(slate_user_id));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(size));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(size));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(booking_num));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(oper_code));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(surgeon_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(chargable_amt));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(inventry_chk_yn));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(charge_hold_area_yn));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(function_id_temp));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(bill_acc_num_DB));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(checked_in_date_DB));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(checked_in_time_DB));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(checked_out_date_DB));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(checked_out_time_DB));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(holding_area_code_DB));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(modified_charge_units_DB));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(calc_chargeable_units_DB));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(oper_num_with_hb));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(bill_acc_temp));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(holding_seq_num_DB));
            _bw.write(_wl_block112Bytes, _wl_block112);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.HoldingAreaDetails.Label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.CheckedInDateTime.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.HoldingBay.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.CheckedOutDateTime.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ChargableUnits.Label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.HoldingAreaDetails.Label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.CheckedInDateTime.Label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.HoldingBay.Label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.CheckedOutDateTime.Label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ChargableUnits.Label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ChangeHoldingBay.Label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.CheckedInDateTime.Label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.HoldingBay.Label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.CheckedOutDateTime.Label", java.lang.String .class,"key"));
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
