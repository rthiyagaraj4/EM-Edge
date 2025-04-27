package jsp_servlet._eds._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import java.util.ArrayList;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __dsparameterforthefacilitycud extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eds/jsp/DSparameterForTheFacilityCUD.jsp", 1742465546000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\"StyleSheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\" />\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"javascript\" src=\"../../eDS/js/DSparameterForTheFacility.js\"></script>\n\t<script language=\"javascript\" src=\"../../eDS/js/DSCommon.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\t<script>\n\n\tvar nextMealPlanSeq;\n\tfunction getNextMealPlan(){\n\t\tnextMealPlanSeq=document.getElementById(\"mealPlanNextSeq\").value;\n\t}\n\tfunction enabledField(){\n\t\tif(document.getElementById(\"gracePeriodApplicableYn\").checked ==  true){\n\t\t\tdocument.getElementById(\"gracePeriod\").disabled = false;\n\t\t\tdocument.getElementById(\"grace_image\").style.visibility = \"visible\";\n\t\t}else{\n\t\t\tdocument.getElementById(\"gracePeriod\").disabled = true;\n\t\t\tdocument.getElementById(\"grace_image\").style.visibility = \'hidden\';\n\t\t\tdocument.getElementById(\"gracePeriod\").value = \"\";\n\t\t}\n\t}\n\t</script>\n\t</head>\n\t<body OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" Onload = \"CheckAllow()\"><!--CRF-600-->\n\t<br>\n\t<form target=\"messageFrame\" name=\"DSparameterForTheFacilityForm\" id=\"DSparameterForTheFacilityForm\">\n\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"insert\"/>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<script>\n\t\tdocument.getElementById(\"mode\").value=\"modify\";\n\t\t</script>\n\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<!-- Added Against ML-MMOH-CRF-1061 US2 Starts Here -->\t\t\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\n<!-- Added Against ML-MMOH-CRF-1061 US2 Ends Here -->\n\t\t<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'85%\' align=\'center\'>\t\t\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' align=\"left\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t</td>\n\t\t\t\t<td width=\"12%\">\n\t\t\t\t\t<input type=\"checkbox\" name=\"generateDefaultDietYn\" id=\"generateDefaultDietYn\" value=\"Y\" />\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t<td width=\"27%\" align=\"left\" class=\'label\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t</td>\n\t\t\t\t<td width=\"19%\" class=\'label\' align=\"left\">\n\t\t\t\t\t<input type=\"text\" name=\"labelMessage\" id=\"labelMessage\" maxlength=\'30\' size=\'20\'/><!-- EMR-4000 -->\n\t\t\t\t</td>\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' align=\"left\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t</td>\n\t\t\t\t<td>\n\t\t\t\t\t<input type=\"checkbox\" name=\"multiKitchenYn\" id=\"multiKitchenYn\" value=\"Y\"  onclick=\"enableKitchen();\" />\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' align=\"left\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' align=\"left\">\n\t\t\t\t\t<select name=\"kitchenCode\" id=\"kitchenCode\">\n\t\t\t\t\t<option value=\"\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"  selected>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t</option>\n\t\t\t\t\t</option>\n\t\t\t\t\t</select>\n\t\t\t\t</td>\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' align=\"left\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t</td>\n\t\t\t\t<td>\n\t\t\t\t\t<input type=\"text\" name=\"maxMealPlanCreatDays\" id=\"maxMealPlanCreatDays\" maxlength=\"2\" size=\"2\" onkeypress=\"return checkNumber();\"  />\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' align=\"left\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' align=\"left\">\n\t\t\t\t\t<input type=\"text\" name=\"mealPlanNextSeq\" id=\"mealPlanNextSeq\" maxlength=\"10\" size=\"2\" onkeypress=\"checkNumber()\"/>\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t</td>\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' align=\"left\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t</td>\n\t\t\t\t<td>\n\t\t\t\t\t<input type=\"checkbox\" name=\"acceptDietForIndMealYn\" id=\"acceptDietForIndMealYn\" id=\"acceptDietForIndMealYn\" value=\"Y\" onclick=\"chkBoxValue(this);\" /><!--ML-MMOH-CRF-0409-->\t\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t<td  class=\'label\' align=\"left\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t</td>\n\t\t\t\t<td>\n\t\t\t\t\t<input type=\"checkbox\" name=\"blInterfaceYn\" id=\"blInterfaceYn\" value=\"Y\" />\n\t\t\t\t</td>\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td  class=\'label\' align=\"left\" >\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="<!--ML-MMOH-CRF-406-->\n\t\t\t\t</td>\n\t\t\t\t<td>\n\t\t\t\t\t<input type=\"checkbox\" name=\"attendantOrderApplicableYn\" id=\"attendantOrderApplicableYn\" value=\"Y\" onclick=\"chkBoxValue(this);\"/><!--ML-MMOH-CRF-406-->\n\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t<!--ML-MMOH-CRF-412 STARTS-->\n\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t<td class=\'label\' align=\"left\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' align=\"left\">\n\t\t\t\t\t<input type=\"text\" name=\"attendantcount\" id=\"attendantcount\" id=\"attendantcount\" size=\"1\" maxlength=\"1\" onkeypress=\"checkDigit();restrictSpecialChars(event)\"  disabled=true><!-- 059955 -->\n\t\t\t\t\t<img id=\"attendant_count_check\" src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:hidden\'></img>\n\t\t\t\t</td>\t\t\t\t\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' align=\"left\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t</td>\n\t\t\t\t<td>\n\t\t\t\t\t<input type=\"checkbox\" name=\"gracePeriodApplicableYn\" id=\"gracePeriodApplicableYn\" value=\"Y\" onclick=\"enabledField();\"/>\n\t\t\t\t</td>\n\t\t\t\t<td  class=\'label\' align=\"left\" >\n\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' align=\"left\">\n\t\t\t\t\t<input type=\"text\" name=\"gracePeriod\" id=\"gracePeriod\" maxlength=\"2\" size=\"2\" onkeypress=\"gracePeriodCheck()\"/>\n\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t<img id=\"grace_image\" src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:hidden\'>\n\t\t\t\t\t<script type=\"text/javascript\">\n\t\t\t\t\tif(document.getElementById(\"gracePeriodApplicableYn\").checked ==  false){\n\t\t\t\t\t\tdocument.getElementById(\"gracePeriod\").disabled = true;\n\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t\t</td>\t\t\t\t\t\n\t\t\t</tr>\n\n\t<!-- ML-MMOH-CRF-0427 Starts -->\n\t\t\t<input type=\"checkbox\" name=\"RestrictDateRangeforInpatientsYN\" id=\"RestrictDateRangeforInpatientsYN\" id=\"RestrictDateRangeforInpatientsYN\" value=\"Y\" onclick=\"chkBoxValue(this);\" style=\'visibility:hidden\'/>\n\t\t\t<tr>\n\t\t\t\t<td  class=\'label\' align=\"left\" >\n\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' align=\"left\">\n\t\t\t\t\t<input type=\"text\" name=\"MaximumDaysAllowed\" id=\"MaximumDaysAllowed\" id=\"MaximumDaysAllowed\" maxlength=\"3\" size=\"1\" onkeypress=\"checkDigit()\"/>\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t<img id=\"count_check\" src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t<script type=\"text/javascript\">\n\t\t\t\t\tif(document.getElementById(\"RestrictDateRangeforInpatientsYN\").checked ==  false){\n\t\t\t\t\t\tdocument.getElementById(\"MaximumDaysAllowed\").disabled = true;\n\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t\t</td>\t\t\n\t\t\t\t<!--ML-MMOH-CRF-0406 STARTS-->\n\t\t\t\t<td class=\'label\' align=\"left\">\n\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t</td>\t\t\t\t\n\t\t\t\t<td>\n\t\t\t\t\t<input type=\"text\" name=\"Attendent_Label_Name\" id=\"Attendent_Label_Name\" id=\"Attendent_Label_Name\" value=\"\" maxlength=\"30\" onkeypress=\"restrictSpecialChars(event)\" size=\"18\">\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t</td>\t\t\t\t\n\t\t\t\t<!--ML-MMOH-CRF-0406 ENDS-->\n\t\t\t</tr>\n\t<!-- ML-MMOH-CRF-0427 Ends -->\n\n\t\t\t<!-- CRF-230 changes - Added for enabling Multifacility in Place OP order screen based on the inputs-->\n\t\t\t<tr>\n\t\t\t  <td class=\'label\' align=\"left\">";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\t\t\t  <td><input type=\"checkbox\" name=\"multiFacilityOPyn\" id=\"multiFacilityOPyn\"/></td>\n\t\t\t  <!--ML-MMOH-CRF-0412-->\n\t\t\t  <td  class=\'label\' align=\"left\" >";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n\t\t\t  <td class=\'label\' align=\"left\"><input type=\"text\" name=\"cutoffTimeforFreqBased\" id=\"cutoffTimeforFreqBased\" maxlength=\"2\" size=\"2\" onkeypress=\"checkNumber()\"/>\n\t\t\t    ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t\t\t  <!--ML-MMOH-CRF-0412-->\n\t\t  </tr>\n\t\t\t<tr>\n\t\t\t\t<!-- MMS-KH-CRF-29.1 Starts -->\n\t\t\t  <td class=\'label\' align=\"left\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t\t\t  <td><input type=\"checkbox\" id=\"enableDrugFoodYN\" name=\"enableDrugFoodYN\" id=\"enableDrugFoodYN\"/></td>\n\t\t\t  <!-- MMS-KH-CRF-29.1 Ends -->\n\t\t\t  <td class=\'label\' align=\"left\">";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\n\t\t\t  <td class=\'label\' align=\"left\"><input type=\"text\" name=\"NotificationMessageforPlaceDietOrder\" id=\"NotificationMessageforPlaceDietOrder\" id=\"NotificationMessageforPlaceDietOrder\" value=\"\" onkeypress=\"restrictSpecialChars(event)\" maxlength=\"150\" size=\"18\" disabled=\"true\">\n\t\t\t    <!--IN059007 --></td>\n\t\t  </tr>\n\n          <tr>\n\t\t\t<td></td>\n\t\t\t<td></td>\n\t\t\t<!-- Added by Santhosh for ML-MMOH-CRF-1961-->\n\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t<td class=\'label\' align=\"left\">";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td>\n\t\t\t  <td class=\'label\' align=\"left\"><input type=\"text\" name=\"InstructionInLabelFormula\" id=\"InstructionInLabelFormula\" value=\"\" maxlength=\"50\" size=\"18\">\n\t\t\t    </td>\n\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t<!--END -->\n\t\t  </tr>\n\t\n\n\t\t<!--ML-MMOH-CRF-0409 Starts-->\t\t\t\t\t\t\n\t\t\n\t\t\t<!--ML-MMOH-CRF-409 ENDS-->\n\t\t\t<!-- ML-MMOH-CRF-0600 Starts --> \n\t\t\t<tr>\n\t\t\t<td colspan=\"2\" align=\"left\" valign=\"top\" class=\"BORDER\"><table border=\'0\' cellpadding=3  cellspacing=\'0\' width=\'100%\'>\n\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td  colspan=\"2\" class=\"COLUMNHEADERCENTER\">\n                 \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"checkbox\" id=\"allow_op_em_yn\" name=\"allow_op_em_yn\" id=\"allow_op_em_yn\" value=\"Y\" onclick =\"chkBoxValue(this);\" />\n\t\t\t\t\t\t\n\t\t\t\t\t</td>\n                 \n\t\t\t\t</tr>\n\t\t\t  <tr>\n\t\t\t\t<td width=\"70%\" class=\"label\">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t  <input type=\"checkbox\" id=\"op_served_yn\" name=\"op_served_yn\" id=\"op_served_yn\" value=\"Y\" onclick=\"chkBoxValue(this);\" /></td>\n\t\t\t\t<td width=\"30%\" class=\"label\">";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t  <input type=\"checkbox\"  id=\"op_accept_yn\" name=\"op_accept_yn\" id=\"op_accept_yn\" value=\"Y\" onclick=\"chkBoxValue(this);\" /></td>\n\t\t\t  </tr>\n\t\t\t  </table>\n              \t\t  </td>\n\t\t\t\t<td colspan=\"2\" align=\"left\" valign=\"top\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t  <tr>\n\t\t\t\t    <td align=\"left\" valign=\"top\"><table border=\'0\' cellpadding=3  cellspacing=\'0\' width=\'100%\'>\n\t\t\t\t      <tr>\n\t\t\t\t        <td class=\"COLUMNHEADERCENTER\">&nbsp;\n\t\t\t\t          ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n\t\t\t          </tr>\n\t\t\t        </table></td>\n\t\t\t      </tr>\n\t\t\t\t  <tr>\n\t\t\t\t    <td align=\"left\" valign=\"top\"><table border=\'0\' cellpadding=3  cellspacing=\'0\' width=\'100%\'>\n\t\t\t\t      <tr>\n\t\t\t\t        <td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t          <input type=\"checkbox\" id=\"LATE_IRREGULAR_DIET_ORD_FOR_IP\" name=\"LATE_IRREGULAR_DIET_ORD_FOR_IP\" id=\"LATE_IRREGULAR_DIET_ORD_FOR_IP\" value=\"Y\" onclick=\"chkBoxValue(this);\" /></td>\n\t\t\t\t        <td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t          <input type=\"checkbox\" id=\"LATE_IRREGULAR_DIET_ORD_FOR_OP\" name=\"LATE_IRREGULAR_DIET_ORD_FOR_OP\" id=\"LATE_IRREGULAR_DIET_ORD_FOR_OP\" value=\"Y\" onclick=\"chkBoxValue(this);\" /></td>\n\t\t\t\t        <td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t          <input type=\"checkbox\" id=\"LATE_IRREGULAR_DIET_ORD_FOR_EM\" name=\"LATE_IRREGULAR_DIET_ORD_FOR_EM\" id=\"LATE_IRREGULAR_DIET_ORD_FOR_EM\" value=\"Y\" onclick=\"chkBoxValue(this);\" /></td>\n\t\t\t          </tr>\n\t\t\t\t      <tr>\n\t\t\t\t        <td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t          <input type=\"checkbox\" id=\"LATE_IRREGULAR_DIET_ORD_FOR_ST\" name=\"LATE_IRREGULAR_DIET_ORD_FOR_ST\" id=\"LATE_IRREGULAR_DIET_ORD_FOR_ST\" value=\"Y\" onclick=\"chkBoxValue(this);\" /></td>\n\t\t\t\t        <td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t          <input type=\"checkbox\" id=\"LATE_IRREGULAR_DIET_ORD_FOR_SP\" name=\"LATE_IRREGULAR_DIET_ORD_FOR_SP\" id=\"LATE_IRREGULAR_DIET_ORD_FOR_SP\" value=\"Y\" onclick=\"chkBoxValue(this);\" /></td>\n\t\t\t          </tr>\n\t\t\t        </table></td>\n\t\t\t      </tr>\n\t\t\t    </table></td>\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t  <td colspan=\"2\" align=\"center\" valign=\"top\" class=\"BORDER\"><table border=\'0\' cellpadding=3  cellspacing=\'0\' width=\'100%\'>\n\t\t\t\t<tr>\n\t\t\t\t  <td class=\"COLUMNHEADERCENTER\"><b>\n\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t<input type=\"checkbox\" id=\"allow_ip_yn\" name=\"allow_ip_yn\" id=\"allow_ip_yn\" value=\"Y\" onclick =\"chkBoxValue(this);\" />\n\t\t\t\t\t</b></td>\n\t\t\t\t</tr>\n\n\t\t\t\t<tr>\n\t\t\t\t  <td width=\"100%\" class=\"BORDERX\"><table border=\'0\' cellpadding=3  cellspacing=\'0\' width=\'100%\'>\n\t\t\t\t\t<tr>\n\t\t\t\t\t  <td width=\"33%\" class=\"label\">";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t<input type=\"checkbox\" id=\"ip_MealPrepared_yn\" name=\"ip_MealPrepared_yn\" id=\"ip_MealPrepared_yn\" value=\"Y\" onclick=\"chkBoxValue(this);\" /></td>\n\t\t\t\t\t  <td width=\"33%\" class=\"label\">";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t<input type=\"checkbox\" id=\"ip_MealReceived_yn\" name=\"ip_MealReceived_yn\" id=\"ip_MealReceived_yn\" value=\"Y\" onclick=\"chkBoxValue(this);\" /></td>\n\t\t\t\t\t  <td width=\"34%\" class=\"label\">";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t<input type=\"checkbox\" id=\"ip_MealServed_yn\" name=\"ip_MealServed_yn\" id=\"ip_MealServed_yn\" value=\"Y\" onclick=\"chkBoxValue(this);\" /></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t  </table></td>\n\t\t\t  <td colspan=\"2\">&nbsp;</td>\n\t\t  </tr>\n\n\t\t  <tr>\n\t\t\t<td colspan=\"2\" class=\"BORDER\">&nbsp;</td>\n\t\t\t\t  <td>&nbsp;\n\t\t\t\t</td>\n\t\t\t\t  <td>&nbsp;\n\t\t\t\t</td>\n\t\t\t\t \n\t\t\t</tr>\n\t\t\t<!-- ML-MMOH-CRF-0600 ENDS -->\n\n\t\t\t<!-- ML-MMOH-CRF-0825 STARTS -->\n\t\t\t<tr>\n\t\t\t<td class=\"BORDER\">&nbsp;</td>\n\t\t\t\t <td>&nbsp;\n\t\t\t\t</td>\n\t\t\t\t  <td>&nbsp;\n\t\t\t\t</td>\n\t\t\t\t  <td>&nbsp;\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td width=\"42%\" class=\"BORDERX\">&nbsp;</td>\n\t\t\t\t <td>&nbsp;\n\t\t\t\t</td>\n\t\t\t\t  <td>&nbsp;\n\t\t\t\t</td>\n\t\t\t\t  <td>&nbsp;\n\t\t\t\t</td>\n\t\t\t</tr>\t\t\t\t\n\t\t\t\t<!-- ML-MMOH-CRF-0825 ENDS -->\n\t\t\t\t<script type=\"text/javascript\">\n\t\t\t\tpopulateFields();\n\t\t\t\tfunction populateFields() {\n\t\t\t\t\tdocument.getElementById(\"mealPlanNextSeq\").value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\";\n\t\t\t\t\tdocument.getElementById(\"maxMealPlanCreatDays\").value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\";\n\t\t\t\t\tdocument.getElementById(\"cutoffTimeforFreqBased\").value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\";\n\t\t\t\t\tdocument.getElementById(\"labelMessage\").value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\";\n\t\t\t\t\tdocument.getElementById(\"gracePeriod\").value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\";\n\t\t\t\t\tdocument.getElementById(\"multiFacilityOPyn\").value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\";\n\t\t\t\t\tdocument.getElementById(\"MaximumDaysAllowed\").value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\";\n\t\t\t\t\t// <!--427 crf-->\n\t\t\t\t\t// <!--document.getElementById(\"GenerateNilByMouth_YN\").value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\";\n\t\t\t\t\t// <!--MMS-CRF-78.1--><!--Commented for 409 CRF-->\n\t\t\t\t\tdocument.getElementById(\"enableDrugFoodYN\").value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\";\n\t\t\t\t\t// <!-- MMS-KH-CRF-0029.1 -->\n\t\t\t\t\tdocument.getElementById(\"NotificationMessageforPlaceDietOrder\").value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"; //<!--ML-MMOH-CRF-0409-->\n\t\t\t\t\tdocument.getElementById(\"Attendent_Label_Name\").value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\";\n\t\t\t\t\t// <!--ML-MMOH-CRF-0406-->\n\t\t\t\t\tdocument.getElementById(\"attendantcount\").value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\";\n\t\t\t\t\t// <!--ML-MMOH-CRF-0412-->\n\t\t\t\t\tif(document.getElementById(\'InstructionInLabelFormula\'))\n\t\t\t\t\t\tdocument.getElementById(\'InstructionInLabelFormula\').value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" ; // <!-- Added by Santhosh for ML-MMOH-CRF-1961 -->\n\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t<script type=\"text/javascript\">\n\t\t\t\t\tdocument.getElementById(\"generateDefaultDietYn\").checked=true\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="<script type=\"text/javascript\">document.getElementById(\"multiKitchenYn\").checked=true;document.getElementById(\"multiKitchenYn\").disabled=false;</script>\n\n\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t<script type=\"text/javascript\">\n\t\t\t\t\t\tdocument.getElementById(\"acceptDietForIndMealYn\").checked=true;\n\t\t\t\t\t\t//document.getElementById(\"LATE_IRREGULAR_DIET_ORD_FOR_IP\").disabled=false;\n\t\t\t\t\t</script><!--ML-MMOH-CRF-0409-->\n\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="<script type=\"text/javascript\">document.getElementById(\"blInterfaceYn\").checked=true</script>\n\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="<script type=\"text/javascript\">document.getElementById(\"attendantOrderApplicableYn\").checked=true;document.getElementById(\"attendantcount\").disabled=false;document.getElementById(\'attendant_count_check\').style.visibility=\'visible\';</script><!--ML-MMOH-CRF-0412-->\n\t\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="<script type=\"text/javascript\">document.getElementById(\"gracePeriodApplicableYn\").checked=true;document.getElementById(\"gracePeriodApplicableYn\").disabled=true;document.getElementById(\"gracePeriod\").disabled = true;document.getElementById(\"grace_image\").style.visibility = \"visible\";</script>\n\t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="<script type=\"text/javascript\">document.getElementById(\"multiFacilityOPyn\").checked=true;</script>\n\t\t\t\t<!-- MMS-KH-CRF-29.1 -->\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="<script type=\"text/javascript\">document.getElementById(\"RestrictDateRangeforInpatientsYN\").checked=true;document.getElementById(\'count_check\').style.visibility=\'visible\';document.getElementById(\"MaximumDaysAllowed\").disabled = false;</script><!-- ML-MMOH-CRF-0427 -->\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="<script type=\"text/javascript\">document.getElementById(\"RestrictDateRangeforInpatientsYN\").checked=false;document.getElementById(\'count_check\').style.visibility=\'hidden\';document.getElementById(\"MaximumDaysAllowed\").disabled = true;</script><!-- ML-MMOH-CRF-0427 -->\n\t\t\t\t\n\t\t\t\t<!-- MMS-KH-CRF-29.1 Starts -->\n\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t<script type=\"text/javascript\">document.getElementById(\"enableDrugFoodYN\").checked=true;\n\t\t\t\t</script>\n\t\t\t\t<!-- MMS-KH-CRF-29.1 ends -->\n\t\t\t\t\n\t\t\t\t<!--%if(GenerateNilByMouth.equals(\"Y\"))%--><!--<script type=\"text/javascript\">document.getElementById(\"GenerateNilByMouth_YN\").checked=true;document.getElementById(\"GenerateNilByMouth_YN\").disabled=true;</script>--><!--MMS-CRF-78.1--><!--Commented for 409 CRF-->\n\t\t\t\t<!--ML-MMOH-CRF-0409 Starts-->\n\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t<script type=\"text/javascript\">\n\t\t\t\t\tdocument.getElementById(\"NotificationMessageforPlaceDietOrder\").disabled=false;\n\t\t\t\t</script>\t\t\t\t\t\t\t\n\t\t\t\t<!--ML-MMOH-CRF-0409 Ends-->\n\n\t\t\t\t<!--ML-MMOH-CRF-0600 Starts-->\n\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t<script type=\"text/javascript\">\n\t\t\t\tdocument.getElementById(\"allow_op_em_yn\").checked=true;\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\t<script type=\"text/javascript\">\n\t\t\t\t\tdocument.getElementById(\"op_served_yn\").checked=true;\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t<script type=\"text/javascript\">\n\t\t\t\t\tdocument.getElementById(\"op_accept_yn\").checked=true;\n\t\t\t\t\t</script>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\t<script type=\"text/javascript\">\n\t\t\t\t\tdocument.getElementById(\"ip_MealPrepared_yn\").checked=true;\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t<script type=\"text/javascript\">\n\t\t\t\t\tdocument.getElementById(\"ip_MealReceived_yn\").checked=true;\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t<script type=\"text/javascript\">\n\t\t\t\t\tdocument.getElementById(\"ip_MealServed_yn\").checked=true;\n\t\t\t\t\t</script>\n\t\t\t    ";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t\t<script type=\"text/javascript\">\n\t\t\t\t\tdocument.getElementById(\"allow_ip_yn\").checked=true;\n\t\t\t\t\t</script>\t\n\t\t\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t<!--ML-MMOH-CRF-0600 Ends-->\n\t\t\t\t<!--ML-MMOH-CRF-0825 Starts-->\n\t\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t<script type=\"text/javascript\">\n\t\t\t\t\tdocument.getElementById(\"LATE_IRREGULAR_DIET_ORD_FOR_IP\").checked=true;\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t\t<script type=\"text/javascript\">\n\t\t\t\t\tdocument.getElementById(\"LATE_IRREGULAR_DIET_ORD_FOR_OP\").checked=true;\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t\t\t<script type=\"text/javascript\">\n\t\t\t\t\tdocument.getElementById(\"LATE_IRREGULAR_DIET_ORD_FOR_EM\").checked=true;\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t\t<script type=\"text/javascript\">\n\t\t\t\t\tdocument.getElementById(\"LATE_IRREGULAR_DIET_ORD_FOR_ST\").checked=true;\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t\t\t\t<script type=\"text/javascript\">\n\t\t\t\t\tdocument.getElementById(\"LATE_IRREGULAR_DIET_ORD_FOR_SP\").checked=true;\n\t\t\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t\t\t<!--ML-MMOH-CRF-0825 Ends-->\n\t\t\t</table>\t\t\t\n\t\t\t\n";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"DS_PARAM_FOR_FACILITY\"/>\n\t\t\t<input type=\"hidden\" name=\"moduleId\" id=\"moduleId\" value=\"DS\"/>\n\t\t\t<input type=\"hidden\" name=\"facilityId\" id=\"facilityId\" value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"Attendent_Name\" id=\"Attendent_Name\" id=\"Attendent_Name\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\"/><!--ML-MMOH-CRF-0406-->\n\t\t\t<input type=\"hidden\" name=\"reset_generateDefaultDiet\" id=\"reset_generateDefaultDiet\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"reset_labelMessage\" id=\"reset_labelMessage\" value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"reset_multiKitchen\" id=\"reset_multiKitchen\" value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"reset_maxMealPlanCreatDays\" id=\"reset_maxMealPlanCreatDays\" value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"reset_mealPlanNextSeq\" id=\"reset_mealPlanNextSeq\" value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"reset_acceptDietForMeal\" id=\"reset_acceptDietForMeal\" value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"reset_blInterface\" id=\"reset_blInterface\" value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"reset_attendantOrderApplicable\" id=\"reset_attendantOrderApplicable\" value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"reset_cutOffTimeForLiquidFood\" id=\"reset_cutOffTimeForLiquidFood\" value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"reset_gracePeriodApplicable\" id=\"reset_gracePeriodApplicable\" value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"reset_gracePeriod\" id=\"reset_gracePeriod\" value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"reset_multiFacility\" id=\"reset_multiFacility\" value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\"/>\t\t\t\t\t\t\n\t\t\t<!-- CRF - 78.1 & CRF - 427 & MMS-KH-CRF-0029.1 -->\n\t\t\t<input type=\"hidden\" name=\"reset_GenerateNilByMouth\" id=\"reset_GenerateNilByMouth\" value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\"/>\t\t\t\n\t\t\t<input type=\"hidden\" name=\"GenerateNilByMouth_YN\" id=\"GenerateNilByMouth_YN\" value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\"/>\t\t\t<!--Added for 409 CRF-->\n\t\t\t<input type=\"hidden\" name=\"reset_RestrictDateRangeforInpatients\" id=\"reset_RestrictDateRangeforInpatients\" value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\"/>\t\t\t\n\t\t\t<input type=\"hidden\" name=\"reset_MaximumDaysAllowed_Value\" id=\"reset_MaximumDaysAllowed_Value\" value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\"/>\t\t\t\n\t\t\t<!-- CRF - 78.1 & CRF - 427 -->\t\t\t\n\t\t\t<!--ML-MMOH-CRF-0409 Starts-->\n\t\t\t<input type=\"hidden\" name=\"reset_LATE_IRREGULAR_DIET_ORD_FOR_IP\" id=\"reset_LATE_IRREGULAR_DIET_ORD_FOR_IP\" value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\"/>\t\t\t\n\t\t\t<input type=\"hidden\" name=\"reset_RestrictMealServingStartTime\" id=\"reset_RestrictMealServingStartTime\" value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\"/>\n\t\t\t<!-- MMS-KH-CRF-29.1 Starts -->\n\t\t\t<input type=\"hidden\" name=\"reset_enableDrugFoodYN\" id=\"reset_enableDrugFoodYN\" value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\"/>\t\t\t\n\t\t\t<!-- MMS-KH-CRF-29.1 Ends -->\n\t\t\t<input type=\"hidden\" name=\"reset_NotificationMessageforPlaceDietOrder\" id=\"reset_NotificationMessageforPlaceDietOrder\" value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\"/>\n\t\t\t<!--ML-MMOH-CRF-0409 Ends-->\t\t\t\t\n\t\t\t<input type=\"hidden\" name=\"reset_Attendent_Label_Name\" id=\"reset_Attendent_Label_Name\" value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\"><!--ML-MMOH-CRF-0406-->\n\t\t\t<input type=\"hidden\" name=\"reset_No_Of_Attendant\" id=\"reset_No_Of_Attendant\" value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\"><!--ML-MMOH-CRF-0412-->\n\t\t\t<!--ML-MMOH-CRF-0600 Starts-->\n\t\t\t<input type=\"hidden\" name=\"reset_op_em_served\" id=\"reset_op_em_served\" id =\"reset_op_em_served\" value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\">\n\t\t\t<input type=\"hidden\" name=\"reset_op_em_accept\" id=\"reset_op_em_accept\" id =\"reset_op_em_accept\" value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\">\n\t\t\t<input type=\"hidden\" name=\"reset_ip_MealPrepared\" id=\"reset_ip_MealPrepared\" id =\"reset_ip_MealPrepared\" value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\">\n\t\t\t<input type=\"hidden\" name=\"reset_ip_MealReceived\" id=\"reset_ip_MealReceived\" id =\"reset_ip_MealReceived\" value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\">\n\t\t\t<input type=\"hidden\" name=\"reset_ip_MealServed\" id=\"reset_ip_MealServed\" id =\"reset_ip_MealServed\" value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\">\n\t\t\t<input type=\"hidden\" name=\"reset_op_em_allow\" id=\"reset_op_em_allow\" id =\"reset_op_em_allow\" value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\">\n\t\t\t<input type=\"hidden\" name=\"reset_ip_allow\" id=\"reset_ip_allow\" id =\"reset_ip_allow\" value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\">\n\t\t\t<!--ML-MMOH-CRF-0600 Ends -->\n\t\t\t<!-- Added Against ML-MMOH-CRF-1061 US2 Starts Here -->\n\t\t\t<input type=\"hidden\" name=\"OPstatus_Ser_YN\" id=\"OPstatus_Ser_YN\" id =\"OPstatus_Ser_YN\" value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\">\n\t\t\t<input type=\"hidden\" name=\"OPstatus_Acc_YN\" id=\"OPstatus_Acc_YN\" id =\"OPstatus_Acc_YN\" value=\"Y\">\n\t\t\t<input type=\"hidden\" name=\"IPstatus_Pre_YN\" id=\"IPstatus_Pre_YN\" id =\"IPstatus_Pre_YN\" value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\">\n\t\t\t<input type=\"hidden\" name=\"IPstatus_Rec_YN\" id=\"IPstatus_Rec_YN\" id =\"IPstatus_Rec_YN\" value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\">\n\t\t\t<input type=\"hidden\" name=\"IPstatus_Ser_YN\" id=\"IPstatus_Ser_YN\" id=\"IPstatus_Ser_YN\" value=\"Y\"/>\n\t\t\t<input type=\"hidden\" name=\"reset_OPstatus_Ser\" id=\"reset_OPstatus_Ser\" id =\"reset_OPstatus_Ser\" value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\">\n\t\t\t<input type=\"hidden\" name=\"reset_OPstatus_Acc\" id=\"reset_OPstatus_Acc\" id =\"reset_OPstatus_Acc\" value=\"Y\">\n\t\t\t<input type=\"hidden\" name=\"reset_IPstatus_Pre\" id=\"reset_IPstatus_Pre\" id =\"reset_IPstatus_Pre\" value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\">\n\t\t\t<input type=\"hidden\" name=\"reset_IPstatus_Rec\" id=\"reset_IPstatus_Rec\" id =\"reset_IPstatus_Rec\" value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\">\n\t\t\t<input type=\"hidden\" name=\"reset_IPstatus_Ser\" id=\"reset_IPstatus_Ser\" id =\"reset_IPstatus_Ser\" value=\"Y\">\n\t\t\t<!-- Added Against ML-MMOH-CRF-1061 US2 Ends Here -->\n\t\t\t<!-- Added Against ML-MMOH-CRF-0825 Starts Here -->\n\t\t\t<input type=\"hidden\" name=\"reset_LATE_IRREGULAR_DIET_ORD_FOR_OP\" id=\"reset_LATE_IRREGULAR_DIET_ORD_FOR_OP\" value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"reset_LATE_IRREGULAR_DIET_ORD_FOR_EM\" id=\"reset_LATE_IRREGULAR_DIET_ORD_FOR_EM\" value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"reset_LATE_IRREGULAR_DIET_ORD_FOR_ST\" id=\"reset_LATE_IRREGULAR_DIET_ORD_FOR_ST\" value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"reset_LATE_IRREGULAR_DIET_ORD_FOR_SP\" id=\"reset_LATE_IRREGULAR_DIET_ORD_FOR_SP\" value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\"/>\n\t\t\t<!-- Added Against ML-MMOH-CRF-0825 Starts Here -->\n\t\t\t<!-- Added by Santhosh for ML-MMOH-CRF-1961-->\n\t\t\t<input type=\"hidden\" name=\"reset_InstructionInLabelFormula\" id=\"reset_InstructionInLabelFormula\" value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\"/>\n\t\t</form>\n\t</body>\n</html>\n<!-- 059916 -->\n<script>\n$(\'body\').bind(\'paste\',function(e) {\n    e.preventDefault(); return false; \n});\n</script>\n<!-- 059916 -->\n\n";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );
 
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

	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
	.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
	:"IeStyle.css" ;
	if(sStyle==null)sStyle="IeStyle.css";
	String facility_id	= (String)session.getAttribute("facility_id");
	String locale = (String) session.getAttribute("LOCALE");
	String generateDefaultDiet="",labelForDefaultDiet="",labelMessage="",blInterface="",inventoryInterface="",inventoryStoreCode="",multiKitchen="",kitchenCode="",chargeStdService="",dialyDietOrders="",maxMealPlanCreateDays="",trackMenuValidity="",mealPlanNextSeq="",acceptDietForMeal="",enableRDAAlert="",attendantOrderApplicable="",cutOffTimeForLiquidFood="",gracePeriod="",gracePeriodApplicable="", multifacility="";
	//ML-MMOH-CRF-0427
	String RestrictDateRangeforInpatients ="";
	String MaximumDaysAllowed_Value ="";
	//ML-MMOH-CRF-0427
	String GenerateNilByMouth="";//MMS-CRF-78.1
	String NotificationMessageforPlaceDietOrder="",RestrictMealServingStartTime="",LATE_IRREGULAR_DIET_ORD_FOR_IP="";//ML-MMOH-CRF-0409
	String Attendent_Label_Name="";//ML-MMOH-CRF-0406
	String No_Of_Attendant="";//ML-MMOH-CRF-0412
	//ML-MMOH-CRF-0600
	String op_em_served="",op_em_accept="",op_em_allow="";
	String ip_MealPrepared="",ip_MealReceived="",ip_MealServed="",ip_allow="";
	//ML-MMOH-CRF-0600
	//ML-MMOH-CRF-0825
	String LATE_IRREGULAR_DIET_ORD_FOR_OP="",LATE_IRREGULAR_DIET_ORD_FOR_EM="",LATE_IRREGULAR_DIET_ORD_FOR_ST="",LATE_IRREGULAR_DIET_ORD_FOR_SP="";
	//ML-MMOH-CRF-0825
	String enableDrugFoodYN="";//MMS-KH-CRF-0029.1-US008
	Connection con=null;
	con=ConnectionManager.getConnection(request);
	
	//Added by Santhosh for ML-MMOH-CRF-1961
	Boolean InstructionInLabelFormulaAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "DS","LABEL_STICKER_FORMULA");	
	String InstructionInLabelFormula = "";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	PreparedStatement stmt=null,stmtParam=null;
	ResultSet rs=null,rsParam=null;
	String sql = "",sqlParam="";

	try
	  {
		con=ConnectionManager.getConnection(request);
		
		sqlParam= "SELECT OPERATING_FACILITY_ID, GENERATE_DEFAULT_DIET_YN, LABEL_FOR_DEFAULT_DIET_YN, LABEL_MESSAGE, BL_INTERFACE_YN, INVENTORY_INTERFACE_YN, INVENTORY_STORE_CODE, MULTI_KITCHEN_YN, KITCHEN_CODE, CHARGE_STD_SERVICE_YN, DAILY_DIET_ORDERS_YN, MAX_MEAL_PLAN_CREAT_DAYS, TRACK_MENU_VALIDITY_YN, MEAL_PLAN_NEXT_SEQ, ACCEPT_DIET_FOR_IND_MEAL_YN, ENABLE_RDA_ALERT_YN, ATTENDANT_ORDER_APPLICABLE_YN, CUTOFF_TIME_FOR_ACK_LIQFOOD,GRACE_PERIOD, GRACE_PERIOD_APPLICABLE_YN, MULTIFACILITY_YN, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO,Restrict_Date_Inpatients_YN,MAXIMUM_DAYS_ALLOWED,GEN_MEALPLAN_FOR_NBM_PAT_YN,RESTRICT_MEAL_SERVING_ST_TIME,IRREGULAR_MEAL_ORD_MESSAGE,LATE_IRREGULAR_DIET_ORD_FOR_IP,Attendent_Label_Name,No_Of_Attendant,OP_EM_SERVED_YN,OP_EM_ACCEPT_YN,ALLOW_PLACE_ORD_OP_EM,IP_MEALPREPARED_YN,IP_MEALRECEIVED_YN,IP_MEALSERVED_YN,ALLOW_PLACE_ORD_IP,LATE_IRREGULAR_DIET_ORD_FOR_OP,LATE_IRREGULAR_DIET_ORD_FOR_EM,LATE_IRREGULAR_DIET_ORD_FOR_ST,LATE_IRREGULAR_DIET_ORD_FOR_SP, ENABLE_DRUG_FOOD_YN, INSTRUCTION_IN_LABEL FROM DS_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID=?";//MMS-CRF-78.1 //ML-MMOH-CRF-0409 AND ML-MMOH-CRF-0406 and ML-MMOH-CRF-0412 & CRF-600 & CRF-0825 & MMS-KH-CRF-0029.1-US008

		stmtParam=con.prepareStatement(sqlParam);
		stmtParam.setString(1,facility_id);
		rsParam=stmtParam.executeQuery();

		if(rsParam !=null)
		{
		while(rsParam.next())
		{ 
            _bw.write(_wl_block8Bytes, _wl_block8);

		generateDefaultDiet=rsParam.getString(2);
		labelForDefaultDiet=rsParam.getString(3);
		if(rsParam.getString(4) == null){
			labelMessage = "";
		}else{
			labelMessage=rsParam.getString(4);	
		}
		blInterface=rsParam.getString(5);
		inventoryInterface=rsParam.getString(6);
		inventoryStoreCode=rsParam.getString(7);
		if(rsParam.getString(8) == null){
			multiKitchen = "";
		}else{
			multiKitchen=rsParam.getString(8);	
		}
		if(rsParam.getString(9) == null){
			kitchenCode = "";
		}else{
			kitchenCode=rsParam.getString(9);
		}
		if(rsParam.getString(10) == null){
			chargeStdService = "";
		}else{
			chargeStdService=rsParam.getString(10);
		}
		if(rsParam.getString(11) == null){
			dialyDietOrders = "";
		}else{
			dialyDietOrders=rsParam.getString(11);
		}
		if(rsParam.getString(12) == null){
			maxMealPlanCreateDays = "";
		}else{
			maxMealPlanCreateDays=rsParam.getString(12);
		}

		trackMenuValidity=rsParam.getString(13);
		mealPlanNextSeq=rsParam.getString(14);
		acceptDietForMeal=rsParam.getString(15);
		enableRDAAlert=rsParam.getString(16);
		attendantOrderApplicable=rsParam.getString(17);
		if(rsParam.getString(18) == null){
			cutOffTimeForLiquidFood = "";
		}else{
			cutOffTimeForLiquidFood=rsParam.getString(18);
		}
		if(rsParam.getString(19) == null){
			gracePeriod = "";
		}else{
			gracePeriod = rsParam.getString(19);
		}
		if(rsParam.getString(20) == null){
			gracePeriodApplicable = "";
		}else{
			 gracePeriodApplicable = rsParam.getString(20);
		}

		//CRF-230 changes - Added for enabling Multifacility in Place OP order screen based on the inputs
		if(rsParam.getString("MULTIFACILITY_YN") == null){
			multifacility = "N";
		}else{
			 multifacility = rsParam.getString("MULTIFACILITY_YN");
		}
		//0427 starts
		if(rsParam.getString("Restrict_Date_Inpatients_YN")==null){
			//RestrictDateRangeforInpatients="N";
			RestrictDateRangeforInpatients="Y";
			//RestrictDateRangeforInpatients="";
		}else{
			RestrictDateRangeforInpatients=rsParam.getString("Restrict_Date_Inpatients_YN");
		}

		if(rsParam.getString("MAXIMUM_DAYS_ALLOWED")==null){
			MaximumDaysAllowed_Value="";
		}else{
			MaximumDaysAllowed_Value=rsParam.getString("MAXIMUM_DAYS_ALLOWED");
		}

		//0427 ends
		//MMS-CRF-78.1 starts
		if(rsParam.getString("GEN_MEALPLAN_FOR_NBM_PAT_YN")==null){
			GenerateNilByMouth="N";
		}else{
			GenerateNilByMouth=rsParam.getString("GEN_MEALPLAN_FOR_NBM_PAT_YN");
		}
		//MMS-CRF-78.1 ends

		//Added Against MMS-KH-CRF-0029.1-US008
		if(rsParam.getString("ENABLE_DRUG_FOOD_YN") == null){
			enableDrugFoodYN = "N";
		}else{
			 enableDrugFoodYN = rsParam.getString("ENABLE_DRUG_FOOD_YN");
		}//Added Against MMS-KH-CRF-0029.1-US008

		//ML-MMOH-CRF-0409 Starts
		if(rsParam.getString("IRREGULAR_MEAL_ORD_MESSAGE")==null){
			NotificationMessageforPlaceDietOrder="";
		}
		else{
			NotificationMessageforPlaceDietOrder=rsParam.getString("IRREGULAR_MEAL_ORD_MESSAGE");
		}
		
		//Added by Santhosh for ML-MMOH-CRF-1961
		if(rsParam.getString("INSTRUCTION_IN_LABEL")==null){
			InstructionInLabelFormula="";
		}
		else{
			InstructionInLabelFormula=rsParam.getString("INSTRUCTION_IN_LABEL");
		}
		
		
			RestrictMealServingStartTime=rsParam.getString("RESTRICT_MEAL_SERVING_ST_TIME");
			LATE_IRREGULAR_DIET_ORD_FOR_IP=rsParam.getString("LATE_IRREGULAR_DIET_ORD_FOR_IP");
			//ML-MMOH-CRF-0409 Ends
			Attendent_Label_Name=rsParam.getString("Attendent_Label_Name");//ML-MMOH-CRF-0406
			No_Of_Attendant=rsParam.getString("No_Of_Attendant");//ML-MMOH-CRF-0412
			if(No_Of_Attendant==null)No_Of_Attendant="";//ML-MMOH-CRF-0412
			if(No_Of_Attendant.equals("0"))No_Of_Attendant="";//ML-MMOH-CRF-0412
			if(kitchenCode == null) kitchenCode="";

					//ML-MMOH-CRF-0600
					op_em_served=rsParam.getString("op_em_served_yn");
					if(op_em_served=="" || op_em_served==null){
						op_em_served="N";
					}
					op_em_accept=rsParam.getString("op_em_accept_yn");
					if(op_em_accept=="" || op_em_accept==null){
						op_em_accept="N";
					}
					op_em_allow=rsParam.getString("ALLOW_PLACE_ORD_OP_EM");
					if(op_em_allow=="" || op_em_allow==null){
						op_em_allow="N";
					}
					ip_MealPrepared=rsParam.getString("ip_MealPrepared_yn");
					if(ip_MealPrepared=="" || ip_MealPrepared==null){
						ip_MealPrepared="N";
					}
					ip_MealReceived=rsParam.getString("ip_MealReceived_yn");
					if(ip_MealReceived=="" || ip_MealReceived==null){
						ip_MealReceived="N";
					}
					ip_MealServed=rsParam.getString("ip_MealServed_yn");
					if(ip_MealServed=="" || ip_MealServed==null){
						ip_MealServed="N";
					}
					ip_allow=rsParam.getString("ALLOW_PLACE_ORD_IP");
					if(ip_allow=="" || ip_allow==null){
						ip_allow="N";
					}
					//ML-MMOH-CRF-0600

					//ML-MMOH-CRF-0825 Starts
					LATE_IRREGULAR_DIET_ORD_FOR_OP=rsParam.getString("LATE_IRREGULAR_DIET_ORD_FOR_OP");
					if(LATE_IRREGULAR_DIET_ORD_FOR_OP=="" || LATE_IRREGULAR_DIET_ORD_FOR_OP==null){
						LATE_IRREGULAR_DIET_ORD_FOR_OP="N";
					}
					LATE_IRREGULAR_DIET_ORD_FOR_EM=rsParam.getString("LATE_IRREGULAR_DIET_ORD_FOR_EM");
					if(LATE_IRREGULAR_DIET_ORD_FOR_EM=="" || LATE_IRREGULAR_DIET_ORD_FOR_EM==null){
						LATE_IRREGULAR_DIET_ORD_FOR_EM="N";
					}
					LATE_IRREGULAR_DIET_ORD_FOR_ST=rsParam.getString("LATE_IRREGULAR_DIET_ORD_FOR_ST");
					if(LATE_IRREGULAR_DIET_ORD_FOR_ST=="" || LATE_IRREGULAR_DIET_ORD_FOR_ST==null){
						LATE_IRREGULAR_DIET_ORD_FOR_ST="N";
					}
					LATE_IRREGULAR_DIET_ORD_FOR_SP=rsParam.getString("LATE_IRREGULAR_DIET_ORD_FOR_SP");
					if(LATE_IRREGULAR_DIET_ORD_FOR_SP=="" || LATE_IRREGULAR_DIET_ORD_FOR_SP==null){
						LATE_IRREGULAR_DIET_ORD_FOR_SP="N";
					}
					//ML-MMOH-CRF-0825 Ends
				}
		}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception==" + e);
		} finally {
			if (rsParam != null) rsParam.close();
			if (stmtParam != null) stmtParam.close();			
		}
	
            _bw.write(_wl_block9Bytes, _wl_block9);

	String ser_status_code="MS";
	String MP_status_code="MP";
	String MR_status_code="MR";
	String patient_class_OP="OP";
	String patient_class_IP="IP";
	String OPstatus_Ser_YN="";
	String IPstatus_Pre_YN="";
	String IPstatus_Rec_YN="";

	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rst=null;
	String sql_served = "",sql_MP="",sql_MR="";

	try
	{
		conn=ConnectionManager.getConnection(request);				
		sql_served ="select STATUS_ACT_YN from DS_MEAL_ACK_STATUS_MAST where status_code = '"+ser_status_code+"' and patient_class='"+patient_class_OP+"' ";

		pstmt=conn.prepareStatement(sql_served);
		rst=pstmt.executeQuery();	
		while (rst != null && rst.next()) {
		OPstatus_Ser_YN = checkForNull(rst.getString(1));
	}
				
	sql_MP ="select STATUS_ACT_YN from DS_MEAL_ACK_STATUS_MAST where status_code ='"+MP_status_code+"' and patient_class='"+patient_class_IP+"' ";
	pstmt=conn.prepareStatement(sql_MP);
	rst=pstmt.executeQuery();	
	while (rst != null && rst.next()) {
			IPstatus_Pre_YN = checkForNull(rst.getString(1));
	}
			
	sql_MR ="select STATUS_ACT_YN from DS_MEAL_ACK_STATUS_MAST where status_code ='"+MR_status_code+"' and patient_class='"+patient_class_IP+"' ";
	pstmt=conn.prepareStatement(sql_MR);
	rst=pstmt.executeQuery();	
	while (rst != null && rst.next()) {
			IPstatus_Rec_YN = checkForNull(rst.getString(1));
	}			
	}catch (Exception e) {
		e.printStackTrace();
		System.err.println("266 Exception==" + e);
	} finally {
		if (rst != null) rst.close();
		if (pstmt != null) pstmt.close();
		ConnectionManager.returnConnection(conn);
	}

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

					try {sql= "SELECT KITCHEN_CODE, SHORT_DESC FROM DS_KITCHENS_LANG_VW WHERE (OPERATING_FACILITY_ID LIKE ? )AND(LANGUAGE_ID=? )AND(EFF_STATUS='E' ) ORDER BY  2 , 1";

							stmt=con.prepareStatement(sql);

							stmt.setString(1,facility_id);
							stmt.setString(2,locale);

							rs=stmt.executeQuery();

							if(rs!=null)
							{
							   while(rs.next())
									{
										String kitchen_code=rs.getString(1);
										String kitchen_desc=rs.getString(2);
										System.out.println("kitchenCode"+kitchenCode+"****");
										System.out.println("kitchen_code"+kitchen_code+"****");
										if(kitchenCode.equals(kitchen_code)) {System.out.println("I am in if condition"+kitchen_code+"****");
									
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kitchen_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(kitchen_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
 }
									   else {
									
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kitchen_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(kitchen_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
 }
									}
						  }
						}
					 catch (Exception e) {
								e.printStackTrace();
								System.err.println("Exception==" + e);
							} finally {
								if (rs != null)	rs.close();
								if (rsParam != null) rsParam.close();
								if (stmt != null) stmt.close();
								if (stmtParam != null) stmtParam.close();
								if (con != null)
									ConnectionManager.returnConnection(con, request);
							}
							
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(Attendent_Label_Name));

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

				String MaxAttendant= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.MaxAttendant.Label","ds_labels");
				MaxAttendant=MaxAttendant.replace("#",Attendent_Label_Name);
				
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(MaxAttendant));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
if(InstructionInLabelFormulaAppl){ 
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
}
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(mealPlanNextSeq));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(maxMealPlanCreateDays));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(cutOffTimeForLiquidFood));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(labelMessage));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(gracePeriod));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(multifacility));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(MaximumDaysAllowed_Value));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(GenerateNilByMouth));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(enableDrugFoodYN));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(NotificationMessageforPlaceDietOrder));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(Attendent_Label_Name));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(No_Of_Attendant));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(InstructionInLabelFormula));
            _bw.write(_wl_block68Bytes, _wl_block68);
if(generateDefaultDiet.equals("Y"))
            _bw.write(_wl_block69Bytes, _wl_block69);
if(multiKitchen.equals("Y"))
            _bw.write(_wl_block70Bytes, _wl_block70);
if(acceptDietForMeal.equals("Y"))
            _bw.write(_wl_block71Bytes, _wl_block71);
if(blInterface.equals("Y"))
            _bw.write(_wl_block72Bytes, _wl_block72);
if(attendantOrderApplicable.equals("Y"))
            _bw.write(_wl_block73Bytes, _wl_block73);
if(gracePeriodApplicable.equals("Y"))
            _bw.write(_wl_block74Bytes, _wl_block74);
if(multifacility.equals("Y"))
            _bw.write(_wl_block75Bytes, _wl_block75);
if(RestrictDateRangeforInpatients.equals("Y"))
            _bw.write(_wl_block76Bytes, _wl_block76);
if(RestrictDateRangeforInpatients.equals("N"))
            _bw.write(_wl_block77Bytes, _wl_block77);
if(enableDrugFoodYN.equals("Y"))
            _bw.write(_wl_block78Bytes, _wl_block78);
if(LATE_IRREGULAR_DIET_ORD_FOR_IP.equals("Y") && acceptDietForMeal.equals("Y"))
            _bw.write(_wl_block79Bytes, _wl_block79);
if(op_em_allow.equals("Y"))
            _bw.write(_wl_block80Bytes, _wl_block80);
if(op_em_served.equals("Y"))
            _bw.write(_wl_block81Bytes, _wl_block81);
if(op_em_accept.equals("Y"))
            _bw.write(_wl_block82Bytes, _wl_block82);
if(ip_MealPrepared.equals("Y"))
            _bw.write(_wl_block83Bytes, _wl_block83);
if(ip_MealReceived.equals("Y"))
            _bw.write(_wl_block84Bytes, _wl_block84);
if(ip_MealServed.equals("Y"))
            _bw.write(_wl_block85Bytes, _wl_block85);
if(ip_allow.equals("Y")){
            _bw.write(_wl_block86Bytes, _wl_block86);
}
            _bw.write(_wl_block87Bytes, _wl_block87);
if(LATE_IRREGULAR_DIET_ORD_FOR_IP.equals("Y"))
            _bw.write(_wl_block88Bytes, _wl_block88);
if(LATE_IRREGULAR_DIET_ORD_FOR_OP.equals("Y"))
            _bw.write(_wl_block89Bytes, _wl_block89);
if(LATE_IRREGULAR_DIET_ORD_FOR_EM.equals("Y"))
            _bw.write(_wl_block90Bytes, _wl_block90);
if(LATE_IRREGULAR_DIET_ORD_FOR_ST.equals("Y"))
            _bw.write(_wl_block91Bytes, _wl_block91);
if(LATE_IRREGULAR_DIET_ORD_FOR_SP.equals("Y"))
            _bw.write(_wl_block92Bytes, _wl_block92);
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(Attendent_Label_Name));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(generateDefaultDiet));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(labelMessage));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(multiKitchen));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(maxMealPlanCreateDays));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(mealPlanNextSeq));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(acceptDietForMeal));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(blInterface));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(attendantOrderApplicable));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(cutOffTimeForLiquidFood));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(gracePeriodApplicable));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(gracePeriod));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(multifacility));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(GenerateNilByMouth));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(GenerateNilByMouth));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(RestrictDateRangeforInpatients));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(MaximumDaysAllowed_Value));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(LATE_IRREGULAR_DIET_ORD_FOR_IP));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(RestrictMealServingStartTime));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(enableDrugFoodYN));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(NotificationMessageforPlaceDietOrder));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(Attendent_Label_Name));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(No_Of_Attendant));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(op_em_served));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(op_em_accept));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(ip_MealPrepared));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(ip_MealReceived));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(ip_MealServed));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(op_em_allow));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(ip_allow));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(OPstatus_Ser_YN));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(IPstatus_Pre_YN));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(IPstatus_Rec_YN));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(OPstatus_Ser_YN));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(IPstatus_Pre_YN));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(IPstatus_Rec_YN));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(LATE_IRREGULAR_DIET_ORD_FOR_OP));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(LATE_IRREGULAR_DIET_ORD_FOR_EM));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(LATE_IRREGULAR_DIET_ORD_FOR_ST));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(LATE_IRREGULAR_DIET_ORD_FOR_SP));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(InstructionInLabelFormula));
            _bw.write(_wl_block135Bytes, _wl_block135);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.DefaultDietForPatientsWoOrders.Label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Labelmessage.Label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.MultiKitchen.Label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.KitchenCode.Label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.select.Label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.MaxMealPlanAllowed.Label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.NextMealPlanNo.Label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AcceptDietTypeForMealType.Label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.InterfacePatBilling.Label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.OrdersAppl.Label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.GracePeriodApplicable.Label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.gracePeriod.Label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Hours.Label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.MaximumDaysAllowed.Label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.PatientCareTakerLabel.Label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.MultiFacilityOP.Label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.CutOffTimeToAckFreq.Label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Hours.Label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.EnableDrugFoodYN.Label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.NotificationMessageforPlaceDietOrder.Label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.InstructionInLabelFormula.Label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.AllowPlaceDietOrderforOP/EM.Label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.served.Label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.accept.Label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.ServingLateTime.Label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Inpatients.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Outpatients.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.EmergencyPatients.Label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.StaffOrders.Label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.SupplementaryOrders.Label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.AllowPlaceDietOrderforIP.Label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.MealPrepared.Label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.MealReceived.Label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.MealServed.Label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
