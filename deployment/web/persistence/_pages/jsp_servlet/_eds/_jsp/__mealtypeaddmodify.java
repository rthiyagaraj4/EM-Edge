package jsp_servlet._eds._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eDS.Common.DlQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __mealtypeaddmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eds/jsp/MealTypeAddModify.jsp", 1709116744000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/CommonLookup.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script language=\'javascript\' src=\'../../eDS/js/MealType.js\'></script>\n<script language=\'javascript\' src=\'../../eDS/js/DSCommon.js\'></script>\n<script language=\'javascript\' src=\'../../eDS/js/jquery-latest.js\'></script> <!-- ML-MMOH-CRF-409 -->\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onload=\"parent.commontoolbarFrame.document.forms[0].apply.disabled=false; Onload_enab_disb();\" OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'><!-- Added Against ML-MOH-CRF-0825 -->\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<br>\t\n\t\t<form name=\"mealClass_form\" id=\"mealClass_form\"  onload=\'FocusFirstElement()\'  action=\"../../servlet/eDS.MealTypeServlet\" method=\"post\" target=\"messageFrame\">\n\t\t\t<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'75%\' align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' align=\"right\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"meal_Type\" id=\"meal_Type\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" onkeypress=\"restrictSpecialChars(event)\" size=\"4\" maxlength=\"4\" onkeyup=\"setFieldToUpperCase(this)\"  onkeypress=\"return checkAlpha(event)\" ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="/>\n\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' align=\"right\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"long_Desc\" id=\"long_Desc\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"  onkeypress=\"restrictSpecialChars(event)\" size=\"30\" maxlength=\"30\" />\n\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"right\" class=\'label\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"short_Desc\" id=\"short_Desc\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" onkeypress=\"restrictSpecialChars(event)\" size=\"15\" maxlength=\"15\" />\n\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"right\" class=\'label\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"order_no\" id=\"order_no\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" size=\"2\" maxlength=\"2\" onblur=\"CheckPosNumber(this);CheckConstraint(this);\" ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" />\n\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"right\" class=\'label\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"enabled_Yn\" id=\"enabled_Yn\"  checked=\"checked\"/>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"enabled_Yn\" id=\"enabled_Yn\"/>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"enabled_Yn\" id=\"enabled_Yn\"  checked=\"checked\"/>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t</td>\n\t\t\t\t<!-- CRF-230 changes - For adding meal type for Place OPmealorder-->\n\t\t\t\t</tr>\n\t\t\t\t<!-- Added Against Start ML-MMOH-CRF-0825 -->\n\t\t\t\t<tr>\n\t\t\t\t<td></td>\n\t\t\t\t<td></td>\n\t\t\t\t\t<td align=\"right\" class=\'label\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td align=\"right\" class=\'label\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td align=\"right\" class=\'label\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<!-- Added Against End ML-MMOH-CRF-0825 -->\n\t\t\t\t<!-- Added Against Start ML-MOH-CRF-1006 -->\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"right\" class=\'label\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"ipmealorder_yn\" id=\"ipmealorder_yn\"  checked=\"checked\" onclick=\"enable_disable(this);\"/> <!-- Added Against ML-MOH-CRF-0825 -->\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"ipmealorder_yn\" id=\"ipmealorder_yn\" onclick=\"enable_disable(this);\"/> <!-- Added Against ML-MOH-CRF-0825 -->\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t<input type=\"checkbox\" name=\"ipmealorder_yn\" id=\"ipmealorder_yn\" onclick=\"enable_disable(this);\"/>\n\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t</td>\t\t\t\t\t\n\t\t\t\t\t <!-- Added Against ML-MOH-CRF-0825 Starts -->\n\t\t\t\t\t <!-- Inpatient  -->\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"ServingStartTime\" id=\"ServingStartTime\" id=\"ServingStartTime\" size=\"5\" maxlength=\"5\"  onkeyup=\"enableDisabletextField(\'ServingStartTime\',\'ServingEndTime\');\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =">(hh24:mi)\n\t\t\t\t\t</td>\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"ServingEndTime\" id=\"ServingEndTime\" id=\"ServingEndTime\" size=\"5\" maxlength=\"5\"  onkeyup=\"enableDisabletextField(\'ServingStartTime\',\'ServingEndTime\');\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =">(hh24:mi)\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"IrregularStartTime\" id=\"IrregularStartTime\" id=\"IrregularStartTime\" size=\"5\" maxlength=\"5\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" >(hh24:mi)\n\t\t\t\t\t</td>\t\t\t\t\t\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"IrregularEndTime\" id=\"IrregularEndTime\" id=\"IrregularEndTime\" size=\"5\" maxlength=\"5\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" >(hh24:mi)\n\t\t\t\t\t</td>\n\t\t\t\t\t<!-- Added Against End ML-MOH-CRF-0825  -->\n\t\t\t\t</tr>\t\n\t\t\t\t<!-- Added Against End ML-MOH-CRF-1006 -->\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"right\" class=\'label\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"opmealorder_yn\" id=\"opmealorder_yn\"  checked=\"checked\" onclick=\"enable_disable(this);\"/> <!-- Added Against ML-MOH-CRF-0825 -->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"opmealorder_yn\" id=\"opmealorder_yn\" onclick=\"enable_disable(this);\"/> <!-- Added Against ML-MOH-CRF-0825 -->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"opmealorder_yn\" id=\"opmealorder_yn\" onclick=\"enable_disable(this);\"/>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<!-- Added Against ML-MOH-CRF-0825 Starts -->\n\t\t\t\t\t<!-- OutPatient  -->\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"OpServingStartTime\" id=\"OpServingStartTime\" id=\"OpServingStartTime\" size=\"5\" maxlength=\"5\"  onkeyup=\"enableDisabletextField(\'OpServingStartTime\',\'OpServingEndTime\');\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =">(hh24:mi)\n\t\t\t\t\t</td>\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"OpServingEndTime\" id=\"OpServingEndTime\" id=\"OpServingEndTime\" size=\"5\" maxlength=\"5\"  onkeyup=\"enableDisabletextField(\'OpServingStartTime\',\'OpServingEndTime\');\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =">(hh24:mi)\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"OpIrregularStartTime\" id=\"OpIrregularStartTime\" id=\"OpIrregularStartTime\" size=\"5\" maxlength=\"5\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" >(hh24:mi)\n\t\t\t\t\t</td>\t\t\t\t\t\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"OpIrregularEndTime\" id=\"OpIrregularEndTime\" id=\"OpIrregularEndTime\" size=\"5\" maxlength=\"5\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" >(hh24:mi)\n\t\t\t\t\t</td>\n\t\t\t\t\t<!-- Added Against End ML-MOH-CRF-0825 -->\n\t\t\t\t</tr>\n\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"right\" class=\'label\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"emmealorder_yn\" id=\"emmealorder_yn\"  checked=\"checked\" onclick=\"enable_disable(this);\"/> <!-- Added Against ML-MOH-CRF-0825 -->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"emmealorder_yn\" id=\"emmealorder_yn\" onclick=\"enable_disable(this);\"/> <!-- Added Against ML-MOH-CRF-0825 -->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"emmealorder_yn\" id=\"emmealorder_yn\" onclick=\"enable_disable(this);\"/>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t</td>\t\n\t\t\t\t\t<!-- Added Against End ML-MOH-CRF-0825 Starts -->\n\t\t\t\t\t<!-- EmergencyPatient  -->\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"EmServingStartTime\" id=\"EmServingStartTime\" id=\"EmServingStartTime\" size=\"5\" maxlength=\"5\"  onkeyup=\"enableDisabletextField(\'EmServingStartTime\',\'EmServingEndTime\');\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =">(hh24:mi)\n\t\t\t\t\t</td>\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"EmServingEndTime\" id=\"EmServingEndTime\" id=\"EmServingEndTime\" size=\"5\" maxlength=\"5\"  onkeyup=\"enableDisabletextField(\'EmServingStartTime\',\'EmServingEndTime\');\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =">(hh24:mi)\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"EmIrregularStartTime\" id=\"EmIrregularStartTime\" id=\"EmIrregularStartTime\" size=\"5\" maxlength=\"5\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" >(hh24:mi)\n\t\t\t\t\t</td>\t\t\t\t\t\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"EmIrregularEndTime\" id=\"EmIrregularEndTime\" id=\"EmIrregularEndTime\" size=\"5\" maxlength=\"5\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =" >(hh24:mi)\n\t\t\t\t\t</td>\n\t\t\t\t\t<!-- Added Against End ML-MOH-CRF-0825 Ends -->\n\t\t\t\t</tr>\n\n\t\t\t\t<!-- MMS-QH-CRF-0079 STARTS Place Supplementary Diet Order-->\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"right\" class=\'label\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"supldietorder_yn\" id=\"supldietorder_yn\"  checked=\"checked\" onclick=\"enable_disable(this);\"/> <!-- Added Against ML-MOH-CRF-0825 -->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"supldietorder_yn\" id=\"supldietorder_yn\" onclick=\"enable_disable(this);\"/> <!-- Added Against ML-MOH-CRF-0825 -->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"supldietorder_yn\" id=\"supldietorder_yn\" onclick=\"enable_disable(this);\"/>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<!-- Added Against End ML-MOH-CRF-0825 Starts -->\n\t\t\t\t\t<!-- Supplementary Order  -->\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"SupplementServingStartTime\" id=\"SupplementServingStartTime\" id=\"SupplementServingStartTime\" size=\"5\" maxlength=\"5\"  onkeyup=\"enableDisabletextField(\'SupplementServingStartTime\',\'SupplementServingEndTime\');\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =">(hh24:mi)\n\t\t\t\t\t</td>\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"SupplementServingEndTime\" id=\"SupplementServingEndTime\" id=\"SupplementServingEndTime\" size=\"5\" maxlength=\"5\"  onkeyup=\"enableDisabletextField(\'SupplementServingStartTime\',\'SupplementServingEndTime\');\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =">(hh24:mi)\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"SupplementIrregularStartTime\" id=\"SupplementIrregularStartTime\" id=\"SupplementIrregularStartTime\" size=\"5\" maxlength=\"5\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" >(hh24:mi)\n\t\t\t\t\t</td>\t\t\t\t\t\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"SupplementIrregularEndTime\" id=\"SupplementIrregularEndTime\" id=\"SupplementIrregularEndTime\" size=\"5\" maxlength=\"5\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" >(hh24:mi)\n\t\t\t\t\t</td>\n\t\t\t\t\t<!-- Added Against End ML-MOH-CRF-0825 Ends -->\n\t\t\t\t</tr>\n\t\t\t\t<!-- MMS-QH-CRF-0079 ENDS -->\t\t\t\t\n\t\t\t\t<!-- ML-MMOH-CRF-0820 STARTS-->\n\t\t\t<BR>\t\n\t\t\t<BR>\t\n\t\t\t<!-- Place Staff Meal Order  -->\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td align=\"right\" class=\'label\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t\n\t\t\t<!--tr>\n\t\t\t<td-->\n\t\t\t<!--Added Against Start ML-MMOH-CRF-1006 -->\n\t<!--div id=\"MealTypeCheck\" style=\"visibility:visible;overflow:auto;height:125;width:200;border: 1px outset white\" align=\"right\" -->\n\t   <!--table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'100%\' align=\'center\'-->\n\t\t  <!--tr-->\n\t\t\t<!--td-->\n\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t<!--input type=\"checkbox\" name=\"docMealOrderYn\"  checked=\"checked\" /-->\n\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t<!--input type=\"checkbox\" name=\"docMealOrderYn\" /-->\n\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\n\t\t\t<BR>\n\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t<!--input type=\"checkbox\" name=\"opsMealOrderYn\"  checked=\"checked\"/-->\n\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t<!--input type=\"checkbox\" name=\"opsMealOrderYn\"--/>\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t<!--fmt:message key=\"eDS.OTParamedicStaff.Label\" bundle=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\"/-->\n\t\t\t<!--BR-->\n\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t<!--input type=\"checkbox\" name=\"oncMealOrderYn\"  checked=\"checked\" /-->\n\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t<!--input type=\"checkbox\" name=\"oncMealOrderYn\"/-->\n\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t<!--fmt:message key=\"eDS.OnCallStaff.Label\" bundle=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\"/-->\n\t\t\t<BR>\n\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t<!--input type=\"checkbox\" name=\"stcMealOrderYn\"  checked=\"checked\" /-->\n\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t<!--input type=\"checkbox\" name=\"stcMealOrderYn\"/>\n\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t<!--fmt:message key=\"eDS.Staff.Label\" bundle=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t<!--input type=\"checkbox\" name=\"stuMealOrderYn\"  checked=\"checked\"/-->\n\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t<!--input type=\"checkbox\" name=\"stuMealOrderYn\"/-->\n\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t<!--fmt:message key=\"eDS.Students.Label\" bundle=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\"/-->\n\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t<!--input type=\"checkbox\" id=\"mealTypeId\" name=\"check\" value=\"<!%=meal_category_code%>\">\n\t\t\t\t<!%=meal_category_description%><BR-->\t\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t<!--/td-->\n\t\t<!--/tr-->\n\t  <!--/table-->\n\t<!--/div-->\n\t\t\t<!--/td >\t\t\t\t\t\n\t\t</tr-->\n\t\t\t<!-- Start 825 -->\n\t\t\t<tr>\n\t\t\t\t\t<td align=\"right\" class=\'label\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"docMealOrderYn\" id=\"docMealOrderYn\"  checked=\"checked\" onclick=\"enable_disable(this);\"/>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"docMealOrderYn\" id=\"docMealOrderYn\" onclick=\"enable_disable(this);\"/>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"docMealOrderYn\" id=\"docMealOrderYn\" id=\"docMealOrderYn\" onclick=\"enable_disable(this);\"/>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"DocServingStartTime\" id=\"DocServingStartTime\" id=\"DocServingStartTime\" size=\"5\" maxlength=\"5\"  onkeyup=\"enableDisabletextField(\'DocServingStartTime\',\'DocServingEndTime\');\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 =">(hh24:mi)\n\t\t\t\t\t</td>\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"DocServingEndTime\" id=\"DocServingEndTime\" id=\"DocServingEndTime\" size=\"5\" maxlength=\"5\"  onkeyup=\"enableDisabletextField(\'DocServingStartTime\',\'DocServingEndTime\');\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =">(hh24:mi)\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"DocIrregularStartTime\" id=\"DocIrregularStartTime\" id=\"DocIrregularStartTime\" size=\"5\" maxlength=\"5\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 =" >(hh24:mi)\n\t\t\t\t\t</td>\t\t\t\t\t\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"DocIrregularEndTime\" id=\"DocIrregularEndTime\" id=\"DocIrregularEndTime\" size=\"5\" maxlength=\"5\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 =" >(hh24:mi)\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"right\" class=\'label\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"opsMealOrderYn\" id=\"opsMealOrderYn\"  checked=\"checked\" onclick=\"enable_disable(this);\"/>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"opsMealOrderYn\" id=\"opsMealOrderYn\" onclick=\"enable_disable(this);\"/>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"opsMealOrderYn\" id=\"opsMealOrderYn\" onclick=\"enable_disable(this);\"/>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"OpsServingStartTime\" id=\"OpsServingStartTime\" id=\"OpsServingStartTime\" size=\"5\" maxlength=\"5\"  onkeyup=\"enableDisabletextField(\'OpsServingStartTime\',\'OpsServingEndTime\');\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 =">(hh24:mi)\n\t\t\t\t\t</td>\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"OpsServingEndTime\" id=\"OpsServingEndTime\" id=\"OpsServingEndTime\" size=\"5\" maxlength=\"5\"  onkeyup=\"enableDisabletextField(\'OpsServingStartTime\',\'OpsServingEndTime\');\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =">(hh24:mi)\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"OpsIrregularStartTime\" id=\"OpsIrregularStartTime\" id=\"OpsIrregularStartTime\" size=\"5\" maxlength=\"5\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 =" >(hh24:mi)\n\t\t\t\t\t</td>\t\t\t\t\t\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"OpsIrregularEndTime\" id=\"OpsIrregularEndTime\" id=\"OpsIrregularEndTime\" size=\"5\" maxlength=\"5\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"oncMealOrderYn\" id=\"oncMealOrderYn\"  checked=\"checked\" onclick=\"enable_disable(this);\"/>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"oncMealOrderYn\" id=\"oncMealOrderYn\" onclick=\"enable_disable(this);\"/>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"oncMealOrderYn\" id=\"oncMealOrderYn\" onclick=\"enable_disable(this);\"/>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"OncServingStartTime\" id=\"OncServingStartTime\" id=\"OncServingStartTime\" size=\"5\" maxlength=\"5\"  onkeyup=\"enableDisabletextField(\'OncServingStartTime\',\'OncServingEndTime\');\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 =">(hh24:mi)\n\t\t\t\t\t</td>\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"OncServingEndTime\" id=\"OncServingEndTime\" id=\"OncServingEndTime\" size=\"5\" maxlength=\"5\"  onkeyup=\"enableDisabletextField(\'OncServingStartTime\',\'OncServingEndTime\');\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 =">(hh24:mi)\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"OncIrregularStartTime\" id=\"OncIrregularStartTime\" id=\"OncIrregularStartTime\" size=\"5\" maxlength=\"5\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 =" >(hh24:mi)\n\t\t\t\t\t</td>\t\t\t\t\t\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"OncIrregularEndTime\" id=\"OncIrregularEndTime\" id=\"OncIrregularEndTime\" size=\"5\" maxlength=\"5\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"stcMealOrderYn\" id=\"stcMealOrderYn\"  checked=\"checked\" onclick=\"enable_disable(this);\"/>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"stcMealOrderYn\" id=\"stcMealOrderYn\" onclick=\"enable_disable(this);\"/>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"stcMealOrderYn\" id=\"stcMealOrderYn\" onclick=\"enable_disable(this);\"/>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"StaffServingStartTime\" id=\"StaffServingStartTime\" id=\"StaffServingStartTime\" size=\"5\" maxlength=\"5\"  onkeyup=\"enableDisabletextField(\'StaffServingStartTime\',\'StaffServingEndTime\');\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 =">(hh24:mi)\n\t\t\t\t\t</td>\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"StaffServingEndTime\" id=\"StaffServingEndTime\" id=\"StaffServingEndTime\" size=\"5\" maxlength=\"5\"  onkeyup=\"enableDisabletextField(\'StaffServingStartTime\',\'StaffServingEndTime\');\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 =">(hh24:mi)\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"StaffIrregularStartTime\" id=\"StaffIrregularStartTime\" id=\"StaffIrregularStartTime\" size=\"5\" maxlength=\"5\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 =" >(hh24:mi)\n\t\t\t\t\t</td>\t\t\t\t\t\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"StaffIrregularEndTime\" id=\"StaffIrregularEndTime\" id=\"StaffIrregularEndTime\" size=\"5\" maxlength=\"5\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"stuMealOrderYn\" id=\"stuMealOrderYn\"  checked=\"checked\" onclick=\"enable_disable(this);\"/>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"stuMealOrderYn\" id=\"stuMealOrderYn\" onclick=\"enable_disable(this);\"/>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"stuMealOrderYn\" id=\"stuMealOrderYn\" onclick=\"enable_disable(this);\"/>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"StudentServingStartTime\" id=\"StudentServingStartTime\" id=\"StudentServingStartTime\" size=\"5\" maxlength=\"5\"  onkeyup=\"enableDisabletextField(\'StudentServingStartTime\',\'StudentServingEndTime\');\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 =">(hh24:mi)\n\t\t\t\t\t</td>\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"StudentServingEndTime\" id=\"StudentServingEndTime\" id=\"StudentServingEndTime\" size=\"5\" maxlength=\"5\"  onkeyup=\"enableDisabletextField(\'StudentServingStartTime\',\'StudentServingEndTime\');\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 =">(hh24:mi)\n\t\t\t\t\t</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"StudentIrregularStartTime\" id=\"StudentIrregularStartTime\" id=\"StudentIrregularStartTime\" size=\"5\" maxlength=\"5\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 =" >(hh24:mi)\n\t\t\t\t\t</td>\t\t\t\t\t\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<input type=\"text\" name=\"StudentIrregularEndTime\" id=\"StudentIrregularEndTime\" id=\"StudentIrregularEndTime\" size=\"5\" maxlength=\"5\" onkeypress=\"return checkForSpecCharsforID_mt(event);\" onBlur=\"isValidTime(this);\" disabled=\"true\" value=";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 =" >(hh24:mi)\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\n\t\t\t<!--Added Against End ML-MMOH-CRF-1006 -->\n\t\t\t\t<!-- ML-MMOH-CRF-0820 ENDS -->\n\t</table>\n\t\t\t<!--ML-MMOH-CRF-409 STARTS-->\n\t\t\t<!--ENABLE THE IRREGULAR START AND END TIME TEXT FIELDS IN QUERY MODE IF THE SERVING START TIME AND END TIME IS FILLED STARTS-->\n\t\t\n\t";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\n\t\t<!--script type=\"text/javascript\">\n\t\t\t$(\'#IrregularStartTime\').prop(\'disabled\', false);\n\t\t\t$(\'#IrregularEndTime\').prop(\'disabled\', false);\n\t\t</script-->\n\n\t";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\t<!--script type=\"text/javascript\">\n\t\t\t$(\'#ServingStartTime\').prop(\'disabled\', false);\n\t\t\t$(\'#ServingEndTime\').prop(\'disabled\', false);\n\t\t</script-->\t\n\t";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\t\t<!--ENABLE THE IRREGULAR START AND END TIME TEXT FIELDS IN QUERY MODE IF THE SERVING START TIME AND END TIME IS FILLED ENDS-->\n\t\t<!--ML-MMOH-CRF-409 ENDS-->\n\t\n\t\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\'>\n\t\t<input type=\'hidden\' name=\'updMealType\' id=\'updMealType\' value=\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\'>\n\t\t<input type=\'hidden\' name=\'updLongDesc\' id=\'updLongDesc\' value=\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\'>\n\t\t<input type=\'hidden\' name=\'updShortDesc\' id=\'updShortDesc\' value=\'";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\'>\n\t\t<input type=\'hidden\' name=\'updOrder\' id=\'updOrder\' value=\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\'>\n\t\t<input type=\'hidden\' name=\'updEnabledYn\' id=\'updEnabledYn\' value=\'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\'>\n\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\'>\n\t\t<input type=\'hidden\' name=\'acceptDietForIndMealYn\' id=\'acceptDietForIndMealYn\' value=\'";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\'>\n\t\t<input type=\'hidden\' name=\'irregular_diet_ord_yn\' id=\'irregular_diet_ord_yn\' value=\'";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\'>\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );
 
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
 
		String mealType = "";
		String shortDesc = "";
		String longDesc = "";
		String enabledYn = "";
		String order = "";
		String opmealorder_yn = "";
		String emmealorder_yn = "";
		String supldietorder_yn = "";//MMS-QH-CRF-0079
		String stmealorder_yn = "";//ML-MMOH-CRF-0820
		String mealTypeCode = request.getParameter("mealType");
		String disabled_flag = "";
		String readOnlyFlag = "";
		String facility_id	= (String)session.getAttribute("facility_id");
		String mode = request.getParameter("mode");
		//ML_MMOH_CRF_0409 STARTS
		String Serving_Start_Time="";
		String Serving_End_Time="";
		String Irregular_Start_Time="";
		String Irregular_End_Time="";	
		String IRREGULAR_DIET_ORD_YN="",IRREGULAR_MEAL_ORD_MESSAGE="",acceptDietForIndMealYn="",lateIrregularDietOrdForOp = ""; //ML-MMOH-CRF-409
		//Added Against Start ML-MOH-CRF-1006
		String ipmealorder_yn = ""; 
		String meal_category_code = ""; 
		String meal_category_description = ""; 
		String docMealOrderYn = ""; 
		String opsMealOrderYn = ""; 
		String oncMealOrderYn = ""; 
		String stcMealOrderYn = ""; 
		String stuMealOrderYn = ""; 
		//Added Against End ML-MOH-CRF-1006
		Connection con = null;
		ResultSet rst = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;//ML-MMOH-CRF-409
		ResultSet rs1 = null;//ML-MMOH-CRF-409
		/* Added Against Start ML-MOH-CRF-825 */
		String Op_Serving_Start_Time="",Op_Serving_End_Time="",Op_Irregular_Start_Time="",Op_Irregular_End_Time="";
		String Em_Serving_Start_Time="",Em_Serving_End_Time="",Em_Irregular_Start_Time="",Em_Irregular_End_Time="";
		String Supplement_Serving_Start_Time="",Supplement_Serving_End_Time="",Supplement_Irregular_Start_Time="",Supplement_Irregular_End_Time="";
		String Doc_Serving_Start_Time="",Doc_Serving_End_Time="",Doc_Irregular_Start_Time="",Doc_Irregular_End_Time="";
		String Ops_Serving_Start_Time="",Ops_Serving_End_Time="",Ops_Irregular_Start_Time="",Ops_Irregular_End_Time="";
		String Onc_Serving_Start_Time="",Onc_Serving_End_Time="",Onc_Irregular_Start_Time="",Onc_Irregular_End_Time="";
		String Staff_Serving_Start_Time="",Staff_Serving_End_Time="",Staff_Irregular_Start_Time="",Staff_Irregular_End_Time="";
		String Student_Serving_Start_Time="",Student_Serving_End_Time="",Student_Irregular_Start_Time="",Student_Irregular_End_Time="";
		/* Added Against End ML-MOH-CRF-825 */
		String setupquery = "select ACCEPT_DIET_FOR_IND_MEAL_YN,LATE_IRREGULAR_DIET_ORD_FOR_IP,IRREGULAR_MEAL_ORD_MESSAGE,LATE_IRREGULAR_DIET_ORD_FOR_OP from DS_PARAM_FOR_FACILITY where OPERATING_FACILITY_ID = ? ";//ML-MMOH-CRF-409

		if("modify".equals(mode)){
   		try{
   			disabled_flag = "disabled";
   			readOnlyFlag = "readonly";
	   		con = ConnectionManager.getConnection(request);
	   		pstmt = con.prepareStatement(DlQuery.DL_GET_MEAL_TYPE);
	   		pstmt.setString(1,mealTypeCode);
	   		rst = pstmt.executeQuery();
	   		while(rst.next()){
	   			mealType = rst.getString("meal_type");
	   			longDesc = rst.getString("long_desc");
	   			shortDesc = rst.getString("short_desc");
	   			order = Integer.toString(rst.getInt("meal_order"));
	   			opmealorder_yn = rst.getString("opmealorder_yn");
	   			emmealorder_yn=rst.getString("em_meal_order_yn");
				supldietorder_yn=rst.getString("suppl_diet_order_yn");//MMS-QH-CRF-0079
				stmealorder_yn=rst.getString("st_meal_order_yn");//ML-MMOH-CRF-0820
	   			enabledYn = rst.getString("eff_status");
				//ML_MMOH_CRF_0409 Starts
				Serving_Start_Time=checkForNull(rst.getString("Serving_Start_Time"));
				Serving_End_Time=checkForNull(rst.getString("Serving_End_Time"));
				Irregular_Start_Time=checkForNull(rst.getString("Irregular_Start_Time"));
				Irregular_End_Time=checkForNull(rst.getString("Irregular_End_Time"));
				//ML_MMOH_CRF_0409 Ends
				//Added Against Start ML-MMOH-CRF-1006
				ipmealorder_yn = checkForNull(rst.getString("ip_meal_order_yn"));
				docMealOrderYn = checkForNull(rst.getString("DOC_MEAL_ORDER_YN"));
				opsMealOrderYn = checkForNull(rst.getString("OPS_MEAL_ORDER_YN"));
				oncMealOrderYn = checkForNull(rst.getString("ONC_MEAL_ORDER_YN"));
				stcMealOrderYn = checkForNull(rst.getString("STF_MEAL_ORDER_YN"));
				stuMealOrderYn = checkForNull(rst.getString("STU_MEAL_ORDER_YN"));
				//Added Against End ML-MMOH-CRF-1006
				//Added Against ML-MMOH-CRF-0825 Starts
				Op_Serving_Start_Time=checkForNull(rst.getString("Serving_Start_Time_OP"));
				Op_Serving_End_Time=checkForNull(rst.getString("Serving_End_Time_OP"));
				Op_Irregular_Start_Time=checkForNull(rst.getString("Irregular_Start_Time_OP"));
				Op_Irregular_End_Time=checkForNull(rst.getString("Irregular_End_Time_OP"));
				Em_Serving_Start_Time=checkForNull(rst.getString("Serving_Start_Time_EM"));
				Em_Serving_End_Time=checkForNull(rst.getString("Serving_End_Time_EM"));
				Em_Irregular_Start_Time=checkForNull(rst.getString("Irregular_Start_Time_EM"));
				Em_Irregular_End_Time=checkForNull(rst.getString("Irregular_End_Time_EM"));
				Supplement_Serving_Start_Time=checkForNull(rst.getString("Serving_Start_Time_SUP"));
				Supplement_Serving_End_Time=checkForNull(rst.getString("Serving_End_Time_SUP"));
				Supplement_Irregular_Start_Time=checkForNull(rst.getString("Irregular_Start_Time_SUP"));
				Supplement_Irregular_End_Time=checkForNull(rst.getString("Irregular_End_Time_SUP"));
				Doc_Serving_Start_Time=checkForNull(rst.getString("Serving_Start_Time_DOC"));
				Doc_Serving_End_Time=checkForNull(rst.getString("Serving_End_Time_DOC"));
				Doc_Irregular_Start_Time=checkForNull(rst.getString("Irregular_Start_Time_DOC"));
				Doc_Irregular_End_Time=checkForNull(rst.getString("Irregular_End_Time_DOC"));
				Ops_Serving_Start_Time=checkForNull(rst.getString("Serving_Start_Time_OPS"));
				Ops_Serving_End_Time=checkForNull(rst.getString("Serving_End_Time_OPS"));
				Ops_Irregular_Start_Time=checkForNull(rst.getString("Irregular_Start_Time_OPS"));
				Ops_Irregular_End_Time=checkForNull(rst.getString("Irregular_End_Time_OPS"));
				Onc_Serving_Start_Time=checkForNull(rst.getString("Serving_Start_Time_ONC"));
				Onc_Serving_End_Time=checkForNull(rst.getString("Serving_End_Time_ONC"));
				Onc_Irregular_Start_Time=checkForNull(rst.getString("Irregular_Start_Time_ONC"));
				Onc_Irregular_End_Time=checkForNull(rst.getString("Irregular_End_Time_ONC"));
				Staff_Serving_Start_Time=checkForNull(rst.getString("Serving_Start_Time_STF"));
				Staff_Serving_End_Time=checkForNull(rst.getString("Serving_End_Time_STF"));
				Staff_Irregular_Start_Time=checkForNull(rst.getString("Irregular_Start_Time_STF"));
				Staff_Irregular_End_Time=checkForNull(rst.getString("Irregular_End_Time_STF"));
				Student_Serving_Start_Time=checkForNull(rst.getString("Serving_Start_Time_STU"));
				Student_Serving_End_Time=checkForNull(rst.getString("Serving_End_Time_STU"));
				Student_Irregular_Start_Time=checkForNull(rst.getString("Irregular_Start_Time_STU"));
				Student_Irregular_End_Time=checkForNull(rst.getString("Irregular_End_Time_STU"));
				//Added Against ML-MMOH-CRF-0825 Ends
	   		}
   		}
   		catch(Exception e){
	   		System.err.println("Error in Meal Class->"+e);
   		}
   		finally{
   			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e){
				System.err.println("Exception in Meal Class:"+e);
			}
		//ML-MMOH-CRF-409
   		}
   }
   	try{
   			
   		con = ConnectionManager.getConnection(request);	   		
		pstmt1 = con.prepareStatement(setupquery);	 
		pstmt1.setString(1,facility_id);	
		rs1	= pstmt1.executeQuery();
		while(rs1 != null && rs1.next()){
			IRREGULAR_DIET_ORD_YN = rs1.getString("LATE_IRREGULAR_DIET_ORD_FOR_IP");
			IRREGULAR_MEAL_ORD_MESSAGE = rs1.getString("IRREGULAR_MEAL_ORD_MESSAGE");
			acceptDietForIndMealYn=rs1.getString("ACCEPT_DIET_FOR_IND_MEAL_YN");				
		}
		if(pstmt1!=null) pstmt1.close();
		if(rs1!=null) rs1.close();
		
		
   		}catch(Exception e){
	   		System.err.println("Error in Meal Class->"+e);
			e.printStackTrace();
   		}finally{
   			try{
				if(pstmt1!=null) pstmt1.close();
				if(rs1!=null) rs1.close();
				ConnectionManager.returnConnection(con);
			}catch(Exception e){
				System.err.println("Exception in Meal Class:"+e);
				e.printStackTrace();
			}
   		}
		//ML-MMOH-CRF-409

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(mealType ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(disabled_flag ));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(longDesc ));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(shortDesc ));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(order ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(disabled_flag ));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
if("modify".equals(mode)){
							if("E".equals(enabledYn)){ 
            _bw.write(_wl_block20Bytes, _wl_block20);
}
							else{
            _bw.write(_wl_block21Bytes, _wl_block21);
}
						}
						else{ 
            _bw.write(_wl_block22Bytes, _wl_block22);
} 
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
if("modify".equals(mode)){
						if("Y".equals(ipmealorder_yn)){
            _bw.write(_wl_block28Bytes, _wl_block28);
}else{
            _bw.write(_wl_block29Bytes, _wl_block29);
}
					}else{
            _bw.write(_wl_block30Bytes, _wl_block30);
}
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(Serving_Start_Time));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(Serving_End_Time));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(Irregular_Start_Time));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(Irregular_End_Time));
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
if("modify".equals(mode)){	
							if("Y".equals(opmealorder_yn)){ 
            _bw.write(_wl_block36Bytes, _wl_block36);
}
							else{
            _bw.write(_wl_block37Bytes, _wl_block37);
}
						}
						else{ 
            _bw.write(_wl_block38Bytes, _wl_block38);
} 
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(Op_Serving_Start_Time));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(Op_Serving_End_Time));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(Op_Irregular_Start_Time));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(Op_Irregular_End_Time));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
if("modify".equals(mode)){	
							if("Y".equals(emmealorder_yn)){ 
            _bw.write(_wl_block44Bytes, _wl_block44);
}
							else{
            _bw.write(_wl_block45Bytes, _wl_block45);
}
						}
						else{ 
            _bw.write(_wl_block46Bytes, _wl_block46);
} 
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(Em_Serving_Start_Time));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(Em_Serving_End_Time));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(Em_Irregular_Start_Time));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(Em_Irregular_End_Time));
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
if("modify".equals(mode)){	
							if("Y".equals(supldietorder_yn)){ 
            _bw.write(_wl_block52Bytes, _wl_block52);
}
							else{
            _bw.write(_wl_block53Bytes, _wl_block53);
}
						}
						else{ 
            _bw.write(_wl_block54Bytes, _wl_block54);
} 
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(Supplement_Serving_Start_Time));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(Supplement_Serving_End_Time));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(Supplement_Irregular_Start_Time));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(Supplement_Irregular_End_Time));
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
	
			//if("modify".equals(mode)){
			//if("Y".equals(docMealOrderYn)){ 
            _bw.write(_wl_block61Bytes, _wl_block61);
//}else{
            _bw.write(_wl_block62Bytes, _wl_block62);
//}
            _bw.write(_wl_block63Bytes, _wl_block63);
//if("Y".equals(opsMealOrderYn)){ 
            _bw.write(_wl_block64Bytes, _wl_block64);
//}else{
            _bw.write(_wl_block65Bytes, _wl_block65);
//}
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block67Bytes, _wl_block67);
//if("Y".equals(oncMealOrderYn)){ 
            _bw.write(_wl_block68Bytes, _wl_block68);
//}else{
            _bw.write(_wl_block69Bytes, _wl_block69);
//}
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block71Bytes, _wl_block71);
//if("Y".equals(stcMealOrderYn)){ 
            _bw.write(_wl_block72Bytes, _wl_block72);
//}else{
            _bw.write(_wl_block73Bytes, _wl_block73);
//}
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block67Bytes, _wl_block67);
//if("Y".equals(stuMealOrderYn)){ 
            _bw.write(_wl_block75Bytes, _wl_block75);
//}else{
            _bw.write(_wl_block76Bytes, _wl_block76);
//}
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block78Bytes, _wl_block78);
//} // Modify Mode End
			/* else{ //Insert Mode Start
				try{
				String ds_meal_category_sql= "SELECT MEAL_CATEGORY_CODE, DESCRIPTION FROM DS_MEAL_CATEGORY_LANG_VW WHERE MEAL_CATEGORY_CODE IN ('STF', 'ONC', 'STU','DOC','OPS') AND (LANGUAGE_ID = ?) ORDER BY 2, 1";
				con = ConnectionManager.getConnection(request);
				pstmt1 = con.prepareStatement(ds_meal_category_sql);
				pstmt1.setString(1,locale);
				rs1	= pstmt1.executeQuery();
				while(rs1 != null && rs1.next()){
				meal_category_code = rs1.getString(1);
				meal_category_description = rs1.getString(2); */
				
				
            _bw.write(_wl_block79Bytes, _wl_block79);

				/* } // end of while
				}catch(Exception e){
				e.printStackTrace();
				}finally{
				try{
					if(rs1!=null) rs1.close();
					if(pstmt1!=null) pstmt1.close();
					ConnectionManager.returnConnection(con);
					}catch(Exception e){
					e.printStackTrace();
					}
				}
				} // end of insert mode */
				
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
if("modify".equals(mode)){	
							if("Y".equals(docMealOrderYn)){ 
            _bw.write(_wl_block81Bytes, _wl_block81);
}
							else{
            _bw.write(_wl_block82Bytes, _wl_block82);
}
						}
						else{ 
            _bw.write(_wl_block83Bytes, _wl_block83);
} 
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(Doc_Serving_Start_Time));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(Doc_Serving_End_Time));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(Doc_Irregular_Start_Time));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(Doc_Irregular_End_Time));
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
if("modify".equals(mode)){	
							if("Y".equals(opsMealOrderYn)){ 
            _bw.write(_wl_block89Bytes, _wl_block89);
}
							else{
            _bw.write(_wl_block90Bytes, _wl_block90);
}
						}
						else{ 
            _bw.write(_wl_block91Bytes, _wl_block91);
} 
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(Ops_Serving_Start_Time));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(Ops_Serving_End_Time));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(Ops_Irregular_Start_Time));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(Ops_Irregular_End_Time));
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
if("modify".equals(mode)){	
							if("Y".equals(oncMealOrderYn)){ 
            _bw.write(_wl_block96Bytes, _wl_block96);
}
							else{
            _bw.write(_wl_block97Bytes, _wl_block97);
}
						}
						else{ 
            _bw.write(_wl_block98Bytes, _wl_block98);
} 
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(Onc_Serving_Start_Time));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(Onc_Serving_End_Time));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(Onc_Irregular_Start_Time));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(Onc_Irregular_End_Time));
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
if("modify".equals(mode)){	
							if("Y".equals(stcMealOrderYn)){ 
            _bw.write(_wl_block103Bytes, _wl_block103);
}
							else{
            _bw.write(_wl_block104Bytes, _wl_block104);
}
						}
						else{ 
            _bw.write(_wl_block105Bytes, _wl_block105);
} 
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(Staff_Serving_Start_Time));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(Staff_Serving_End_Time));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(Staff_Irregular_Start_Time));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(Staff_Irregular_End_Time));
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
if("modify".equals(mode)){	
							if("Y".equals(stuMealOrderYn)){ 
            _bw.write(_wl_block110Bytes, _wl_block110);
}
							else{
            _bw.write(_wl_block111Bytes, _wl_block111);
}
						}
						else{ 
            _bw.write(_wl_block112Bytes, _wl_block112);
} 
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(Student_Serving_Start_Time));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(Student_Serving_End_Time));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(Student_Irregular_Start_Time));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(Student_Irregular_End_Time));
            _bw.write(_wl_block117Bytes, _wl_block117);

		//if(!(Serving_Start_Time.equals("")&&Serving_End_Time.equals("")) && IRREGULAR_DIET_ORD_YN.equals("Y") && acceptDietForIndMealYn.equals("Y")){
	
            _bw.write(_wl_block118Bytes, _wl_block118);
//IN059007
		//}if(IRREGULAR_DIET_ORD_YN.equals("Y") && acceptDietForIndMealYn.equals("Y")){
	
            _bw.write(_wl_block119Bytes, _wl_block119);

		//} //Added Against Start ML-MOH-CRF-825
	
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(mealType));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(longDesc));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(shortDesc));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(order));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(enabledYn));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(acceptDietForIndMealYn));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(IRREGULAR_DIET_ORD_YN));
            _bw.write(_wl_block129Bytes, _wl_block129);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.MealType.Label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.LongDescription.Label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ShortDescription.Label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Order.Label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Enabled.Label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.ServingStartTime.Label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EndTime.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.LateIrregularDietOrderStartTime.Label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EndTime.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.PlaceIPMealOrder.Label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PlaceOPMealOrder.Label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.PlaceEMMealOrder.Label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.PlaceSupplementaryDietOrder.Label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.PlaceStaffMealOrder.Label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.DoctorOnCall.Label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.OTParamedicStaff.Label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.OnCallStaff.Label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.Staff.Label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.Students.Label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
