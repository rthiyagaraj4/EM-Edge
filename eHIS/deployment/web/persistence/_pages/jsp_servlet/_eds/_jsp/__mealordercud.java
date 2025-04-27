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
import eCommon.XSSRequestWrapper;
import java.sql.Statement;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __mealordercud extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eds/jsp/MealOrderCUD.jsp", 1742473370000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head> \n<style>\n\tdiv.listContentLayer {\n\t\twidth: 100%;\t\t\n\t\theight: 400px; \t\n\t\toverflow-x: auto;\n\t\toverflow-y: auto;\n\t\tmargin: 0 auto;\n\t}\n\t\n\ttable.mealOrderTable {\n\twidth: 100%;\t\t\n\tborder: none;\n\tbackground-color: #f7f7f7;\n\t}\n\t\n\ttable>tbody\t{  \n\toverflow: auto; \n\theight: 250px;\n\toverflow-x: hidden;\n\t}\n\tthead tr\t{\n\tposition:relative; \n\ttop: expression(offsetParent.scrollTop); \n\t}\n</style>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\"StyleSheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"></link>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\" />\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<Script language=\"JavaScript\" src=\"../../eDS/js/MealOrderForStaffs.js\"></Script>\n\t<script language=\"Javascript\" src=\"../../framework/js/PopupWindow.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eDS/js/DSCommon.js\"></script><!--Added Against ML-MMOH-CRF-0674-->\n\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/tableheaderscroll.js\'></script><!-- Supporting Js File For Fixed Header with scroll.... -->\n\t<script type=\"text/javascript\">\n\twindow.onload = function () { \n\t\tif(document.getElementById(\"Overlap_appt_dtls\")!=null){\n\t\t\tfxheaderInit(\'Overlap_appt_dtls\',350);\n\t\t}\n\t}\n\t</script>\n\n<IBATagLibs:initCalendar />\n</head>\n<body OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<form name=\"MealOrderForm\" id=\"MealOrderForm\" target=\"messageFrame\">\n\t\t<table border=\'0\' cellspacing=\'0\' width=\'85%\' align=\'center\'>\n\t\t<!--ML-MMOH-CRF-0684-US6 Starts-->\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<tr>\n\t\t\t<td class =\"label\" >\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n            </td>\n\t\t\t  <td  class=\'label\' >\n\t\t       <select name=\"menuType\" id=\"menuType\" id =\'menuType\'>\n\t\t\t\t<option value=\"\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" selected >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</option>\t\t\t\n\t\t\t\t   ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t       <option value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</option>\n\t\t\t  \t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t   </select>\n\t\t   <img id=\"menuTypeImage\" src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:visible\'></img>\t\t\t\n\t\t  </td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t<!--ML-MMOH-CRF-0684-US6 Ends-->\n\t\t<tr>\n\t\t\t<td class=\'label\' >\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t</td>\n\t\t\t<td  class=\'label\' >\n\t\t\t\t<select name=\"dietLocation\" id=\"dietLocation\" id =\'dietLocation\'>\n\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t<option value=\"\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t              <option value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" selected>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t              \t<option value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" >";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t</select>\n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t</td>\n\t\t</tr>\n\t\t\n\t\t<tr>\n\t\t\t\t<td class=\'label\' >\n\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t</td>\n\t\t\t\t<td  class=\'label\' >\t\t\t\t\n\t\t\t\t\t<select name=\"mealCategory\" id=\"mealCategory\" onChange=\"callPractitioner(this);changeMealType(this);\"><!--CRF-0678 & CRF-1006-US3 -->\n\t\t\t\t\t\t<option value=\"\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t              <option value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t</select>\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t</td>\n\t\t</tr>\n\t\t<!-- Added Against CRF-0678 Starts Here-->\n\t\t<tr id=\"practName\" style=\"display:none;\">\n\t\t\t<td class=\'label\' >\n\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\t\t\t\t\t\n\t\t\t</td>\n         \t<td class=\'label\' >\n\t\t\t<input type=text name=\'practitioner_name\' id=\'practitioner_name\'  onblur=\"callPractSearch1(this,practitioner_name,\'en\',\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\');\" value=\'\'  onblur=\"\" size=\'25\' >\n\t\t\t<input type=hidden name=\'practitioner\' id=\'practitioner\'  value=\'\' size=\'30\' maxlength=\'30\' ></input>\n\t\t\t<input type=\'button\' class=\'button\' value=\'?\'  name=\'search_pract\' id=\'search_pract\'  onClick=\"callPractSearch1(this,practitioner_name,\'en\',\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\');\" >\n\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t</td>\n       \t</tr>\t\t\t\t\n\t\t<!-- Added Against CRF-0678 Ends Here-->\n\t\t<tr>\n\t\t\t<td class=\'label\' >\n\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'label\' >\n\t\t\t\t\t<input type=\"text\" name=\"mealOrderFrom\" id=\"mealOrderFrom\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"  size=\"10\"onblur=\"validDateObj(this,\'DMY\',\'en\');ComparePeriodFromToTime(this,mealOrderTo);checkDateValidate(this);\" onkeypress=\"return Valid_DT(event)\" maxlength=\"10\" /><!-- CRF-0419-->\n\t\t\t\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendar(\'mealOrderFrom\');\"/>\t\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' >\n\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t</td>\n\t\t\t<td   class=\'label\' >\n\t\t\t\t\t<input type=\"text\" name=\"mealOrderTo\" id=\"mealOrderTo\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"  size=\"10\" onblur=\"validDateObj(this,\'DMY\',\'en\');ComparePeriodFromToTime(mealOrderFrom,this);checkDateValidate(this);\" onkeypress=\"return Valid_DT(event)\" maxlength=\"10\" /><!-- CRF-0419-->\n\t\t\t\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendar(\'mealOrderTo\');\"/>\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t</td>\n\t\t</tr>\n\t\t<!--/table-->\n\t\t<!--table border=\"0\" width=\"85%\" align=\'center\'-->\n\t\t<tr>\n\t\t\t\t<!--td width=\"40%\"-->\n\t\t\t<td class=\'label\' >\n\t\t\t\t\t<!--table border=\"0\" align=\"center\" -->\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t</td>\t\t\t\t\t\t\t\n\t\t\t\t\t<td class=\'label\'>\n\t\t\t\t\t\t<select name=\"DietType\" id=\"DietType\" id=\'DietType\' onKeyUp=\"diettype_Autocomplete()\"   onClick=\"Select();\"><!--Added Against ML-MMOH-CRF-0674-->\n\t\t\t\t\t\t\t<option value=\"\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t\t\t               <option value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t\t            ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t</select>\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t</td>\t\t\t\t\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' >\n\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t</td>\n\t\t\t<td class=\'label\'>\n\t\t\t\t\t<select name=\"MealClass\" id=\"MealClass\" id=\'MealClass\'>\n\t\t\t\t\t\t\t<option value=\"\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t</td>\n\t\t\t<td class=\'label\' id = \'MealTypeTD\'>\n\t\t\t\t<select name=\"MealType\" id=\"MealType\" id=\"MealType\"> \n\t\t\t\t\t<option value=\"\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t</option>\n\t\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t   <option value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' >\n\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t</td>\n\t\t\t<td class=\'label\'>\n\t\t\t\t<input type=\"text\" value=\"\" name=\"noOfOrders\" id=\"noOfOrders\" size=\"6\" maxlength=\"6\" onkeypress=\"chkMealOrders()\" /> \n\t\t\t\t\t\t\t\t\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td  align=\"center\" colspan=\"2\">\n\t\t\t<!--td  align=\"center\" colspan=\"2\" -->\n\t\t\t\t<input type=\"button\" class=\'BUTTON\' name=\"select\" id=\"select\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" onClick=\"selectItemsMenu();\"/>\n\t\t\t<!--</td>-->\n\t\t\t<!-- Added Against Start 832-CRF -->\n\t\t\t\t<input type=\"button\" class=\'BUTTON\' name=\"search\" id=\"search\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" onClick=\"searchItemMenu();\"/>\t\t\t\n\t\t\t<!-- Added Against End 832-CRF -->\n\t\t\t</td>\n\t\t</tr>\n\t\t\t<!--/table-->\n\t\t\t</td>\n\t\t</tr>\n\t\t<!--/table-->\n\t</table>\n\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t<!-- table border=\"0\" width=\"85%\" align=\'center\' style=\"overflow:auto\" -->\n\t<!--div id=\"listContentLayer\" style=\"visibility:visible;overflow:auto;height:270;width:450;border: 1px outset white\"  -->\n\t<div id=\"listContentLayer\" style=\"position:relative;height:335px;vertical-align:top;overflow:auto\"> \t\t\n\t<table border=\'1\' cellpadding=\'2\' cellspacing=\'0\' width=\'100%\' align=\'center\' id=\"mealOrderTable\">\n\t<THEAD>\n\t\t<tr>\n\t\t\n\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t<th align=\"center\">\n\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t</th>\n\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t</th>\n\n\t\t\t<th align=\"center\">\n\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t</th>\n\t\t\n\t\t\t<th align=\"center\">\n\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t</th>\n\t\t\t<th align=\"center\">\n\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t</th>\n\t\t\t<th align=\"center\">\n\t\t\t\t &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t</th>\t\t\t\t\t\n\t\t</tr>\n\t</THEAD>\t\n<TBODY>\t\n\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t<script>\n \tvar chkYN=\"\";\n\tif(";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =" == true) // Modified Against DS-Ml-MMOH-CRF-0832-US00402 [IN065739]\n\t\tchkYN=\"Y\";\n\telse\t\n\t\tchkYN=\"N\";\n\t\t\n\t//CRF-832\n\tparent.mealOrderArray[";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="] = new Array();\n\tif(chkYN==\"Y\"){\n\tparent.mealOrderArray[";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="][0] = \"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\";\t\n\tparent.mealOrderArray[";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="][1] = \"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="][2] = \"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="][3] = \"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\";\n\tparent.mealOrderArray[";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="][4] = \"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="][5] = \"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="][6] = \"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="][7] = \"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="][8] = \"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="][9] = \"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="][10] = \"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="][11] = \"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="][12] = \"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="][13] = \"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="][14] = \"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="][15] = \"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="][16] = \"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="][17] = \"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="][18] = \"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="][19] = \"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="][20] = \"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="][21] = \"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="][22] = \"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\";\n\t}else{\n\tparent.mealOrderArray[";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\";\t\n\t}\n//CRF-832\n\t</script>\n\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t</table>\n\t</div >\n\t<!--/table -->\n\t\t<input type=\'hidden\' name=\'mode\' id=\'mode\' />\n\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\'  value=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\' />\n\t\t<input type=\'hidden\' name=\'moduleId\' id=\'moduleId\'  value=\"DS\" />\n\t\t<input type=\'hidden\' name=\'functionId\' id=\'functionId\' value=\"DS_MEAL_ORDER_STAFF\"/>\n\t\t<input type=\'hidden\' name=\'viewCode\' id=\'viewCode\' value=\"mealOrderFrame\" />\n\t\t<input type=\'hidden\' name=\'fromDatepattern\' id=\'fromDatepattern\' value=\"dd/MM/yyyy\" />\n\t\t<input type=\'hidden\' name=\'toDatepattern\' id=\'toDatepattern\' value=\"dd/MM/yyyy\" />\n\t\t<input type=\'hidden\' name=\'recordId\' id=\'recordId\' />\n\t\t<input type=\'hidden\' name=\'rowId\' id=\'rowId\' />\n\t\t<input type=\'hidden\' name=\'staff_order_id\' id=\'staff_order_id\' />\n\t\t<input type=\'hidden\' name=\'last_addedById\' id=\'last_addedById\' />\n\t\t<input type=\'hidden\' name=\'orderedBy\' id=\'orderedBy\' />\n\t\t<input type=\'hidden\' name=\'last_modifiedById\' id=\'last_modifiedById\' />\n\t\t<input type=\'hidden\' name=\'total_cnt\' id=\'total_cnt\' />\n\t\t<input type=\'hidden\' name=\'rowCount1\' id=\'rowCount1\' value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\"/>\n\t\t<input type=\'hidden\' name=\'params\' id=\'params\' value=\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\' >\n\t\t<input type=\"hidden\" name=\"facilityId\" id=\"facilityId\" value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" />\n\t\t<input type=\"hidden\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" />\n\t\t<input type=\"hidden\" name=\"datepattern\" id=\"datepattern\" value=\"dd/MM/yyyy\" />\n\t\t<input type=\'hidden\' name=\'totalRows\' id=\'totalRows\' />\n\t\t<input type=\"hidden\" name=\"tabId\" id=\"tabId\" value=\"mealOrderTab\"/>\n\t\t <!-- Ml-MMOH-CRF-0674 Starts Here -->\n\t\t<INPUT type=\"hidden\" name=\"diettype_auto\" id=\"diettype_auto\" id=\"diettype_auto\" value=\"\">\n\t\t<INPUT type=\"hidden\" name=\"auto_flag\" id=\"auto_flag\" id=\"auto_flag\" value=\"false\">\n\t\t<!-- Ml-MMOH-CRF-0674 Ends Here -->\n\t\t<!-- Ml-MMOH-CRF-0684 Starts Here -->\n\t\t<input type=\"hidden\" name=\"menuType\" id=\"menuType\" value=\"\">\n\t\t<input type=\"hidden\" name=\"current_date\" id=\"current_date\" value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n\t\t<input type=\"hidden\" name=\"isMenuType\" id=\"isMenuType\" id =\"isMenuType\" value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n\t\t<!-- ML-MMOH-CRF-825 Start -->\n\t\t<input type=\"hidden\" name=\"LATE_IRREGULAR_DIET_ORD_FOR_ST\" id=\"LATE_IRREGULAR_DIET_ORD_FOR_ST\" id=\"LATE_IRREGULAR_DIET_ORD_FOR_ST\" value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" />\n\t\t<!-- ML-MMOH-CRF-825 End -->\n\t\t<!-- Ml-MMOH-CRF-0684 Ends Here -->\t\t\t\n\t</form>\n</body>\n</TBODY>\n<html>\n\n";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );
 
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
            _bw.write(_wl_block6Bytes, _wl_block6);
  
	    //Added Against MMS Vulnerability Issue - Starts
        request= new XSSRequestWrapper(request);
        response.addHeader("X-XSS-Protection", "1; mode=block");
        response.addHeader("X-Content-Type-Options", "nosniff");
	    //Added Against MMS Vulnerability Issue - Ends 
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
		.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
		:"IeStyle.css" ;
		if(sStyle==null)sStyle="IeStyle.css";
		String facility_id=(String)session.getAttribute("facility_id");
		String locale=(String)session.getAttribute("LOCALE");
		String params = request.getQueryString() ;
		request.setCharacterEncoding("UTF-8");
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);


	Connection con=null;
	PreparedStatement stmt=null;
	Statement st = null ;
	ResultSet rs=null;	

	String sql = "",current_date="",meal_category_code="",meal_category_description="",diet_type_code="",diet_type_description="",meal_class_code="",meal_class_description="",meal_type_code="",meal_type_description="";
	
	String rownum="",order_from_date="",order_to_date="",menu_type="",menu_type_descrption="",diet_type="",diet_type_desc="",meal_class="",meal_class_desc="",meal_category="",meal_category_desc="",noof_orders="",practId="",practName="",diet_req_location="",diet_req_location_desc="",meal_type="",meal_type_desc="",last_addedById="",orderedBy="",last_modifiedById="",staff_order_id="";//CRF-832
	String class_val = "";
	String mealOrderFromDate = checkForNull(request.getParameter("mealOrderFromDate"));
	String mealOrderToDate = checkForNull(request.getParameter("mealOrderToDate"));	
	String sql_curr_date="SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') CURRENT_DATE FROM DUAL";
	//ML-MMOH-CRF-0684_US6
	 String menu_type_code = "";
	 String menu_type_desc =  "";
 	//ML-MMOH-CRF-0684_US6
	//Added against ML-MMOH-CRF-0419
	String diet_location_code="",diet_location_description="",default_diet_request_location="";
	//Added against ML-MMOH-CRF-0419
	int rowCount = 0,total_cnt = 0;
	String mode="";
	String DELETE="DELETE";
	//ML-MMOH-CRF-825 starts
	PreparedStatement pstmt = null;
	String LATE_IRREGULAR_DIET_ORD_FOR_ST = "";
	//ML-MMOH-CRF-825 end
	try{
		con	= ConnectionManager.getConnection(request);
		st	= con.createStatement() ;
		rs	= st.executeQuery(sql_curr_date);
		while(rs!=null && rs.next()){
			current_date = com.ehis.util.DateUtils.convertDate(rs.getString("CURRENT_DATE"),"DMY","en",locale);
			}
		if(rs != null) rs.close();
		/* Added Againt Start ML-MMOH-CRF-825 */
		String SetupQuery = "select LATE_IRREGULAR_DIET_ORD_FOR_ST from DS_PARAM_FOR_FACILITY where OPERATING_FACILITY_ID = ? "; 
		pstmt = con.prepareStatement(SetupQuery);	
		pstmt.setString(1,facility_id);	
		rs	= pstmt.executeQuery();
		if(rs != null && rs.next()){
				LATE_IRREGULAR_DIET_ORD_FOR_ST=rs.getString("LATE_IRREGULAR_DIET_ORD_FOR_ST");
			}
		/* Added Againt End ML-MMOH-CRF-825 */	 	
		}catch ( Exception e ) {
			e.printStackTrace() ;
		}finally {
		try{
			if(rs!=null) rs.close();
			if(st!=null) st.close();
		}catch(Exception es){
			es.printStackTrace();
		} 
	}

            _bw.write(_wl_block9Bytes, _wl_block9);

			//ML-MMOH-CRF-0684
			boolean isMenuType = false;
			isMenuType = CommonBean.isSiteSpecific(con,"DS","DS_MENU_TYPE");
			//ML-MMOH-CRF-0684
		if(isMenuType){
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

					try{			
						String sql_Menu_Count="SELECT count(*) FROM ds_menu_type where eff_status ='E' and appl_for_staff_yn ='Y' AND DEFAULT_YN='Y'";
						stmt = con.prepareStatement(sql_Menu_Count);
						rs = stmt.executeQuery();
						int defaultcount=0;
						if(rs.next()){
							defaultcount=rs.getInt(1);
						}
					
						String sql_Menu_Type = "SELECT menu_type,short_desc,DEFAULT_YN FROM ds_menu_type where eff_status ='E' and appl_for_staff_yn ='Y' ORDER BY short_desc asc";
						stmt = con.prepareStatement(sql_Menu_Type);
						rs	= stmt.executeQuery();
						while(rs != null && rs.next()){
						menu_type_code=rs.getString(1);
						menu_type_desc=rs.getString(2);
						String temp=rs.getString(3);
						if(defaultcount == 1 && temp.equals("Y"))
					    {
				
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(menu_type_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(menu_type_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);

				     }
				    else
				    {
				   
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(menu_type_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(menu_type_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);

					}
					}
					}
					catch(Exception e){
						e.printStackTrace();
					}
					finally	{
						if(stmt != null){
							stmt.close();
						}
						if(rs != null){
							rs.close();
						}
					}
				
            _bw.write(_wl_block19Bytes, _wl_block19);
}
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
 try
				      { 
					  //Added Against CRF-0419 US08 Starts Here
					  /*sql="SELECT count(*) FROM ds_diet_request_loc_lang_vw WHERE language_id = 'en' and  eff_status = 'E' and DEFAULT_DIET_REQUEST_LOCATION='Y' ";*/
					  //Added against CRF-0419 US8
					  sql="SELECT SUM (eff_count) eff_count, SUM (default_count) default_count FROM (SELECT COUNT (*) eff_count, 0 default_count FROM ds_diet_request_loc_lang_vw b WHERE b.language_id = ? AND b.eff_status = 'E' UNION SELECT 0 eff_count, COUNT (*) default_count FROM ds_diet_request_loc_lang_vw d WHERE d.language_id = ? AND d.eff_status = 'E' AND d.default_diet_request_location = 'Y')";  
					  int eff_status_Count=0;//CEF-0419
					  int default_Count=0;
					  stmt=con.prepareStatement(sql);
					  stmt.setString(1,locale);
					  stmt.setString(2,locale);
					 rs=stmt.executeQuery();
					 if (rs.next())
					 {
					 eff_status_Count = rs.getInt(1);
					 default_Count = rs.getInt(2);
					 }
						
					 //Added Against CRF-0419 US8 Ends Here
					 if(default_Count != 1 && eff_status_Count != 1)
					 {
					
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

							}
							sql= "SELECT LOCATION_CODE, SHORT_DESC,DEFAULT_DIET_REQUEST_LOCATION FROM ds_diet_request_loc_lang_vw WHERE language_id = ? and eff_status = 'E' ORDER BY 2, 1";//Modified against CRF-0419		
							stmt=con.prepareStatement(sql);
							stmt.setString(1,locale);
							rs=stmt.executeQuery();
							if(rs!=null)
							{
							   while(rs.next())
							        {
								        diet_location_code=rs.getString(1);
								        diet_location_description=rs.getString(2);
									//Added against CRF-0419 Starts Here
									default_diet_request_location=rs.getString(3);
									 if(default_Count == 1 && default_diet_request_location.equalsIgnoreCase("Y"))
									 {
				
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(diet_location_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(diet_location_description));
            _bw.write(_wl_block26Bytes, _wl_block26);

								  }
								  else
								  {
								  
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(diet_location_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(diet_location_description));
            _bw.write(_wl_block29Bytes, _wl_block29);
  }	//Added against CRF-0419 Ends Here
									}
							}
					
            _bw.write(_wl_block30Bytes, _wl_block30);
 }catch(Exception e){
				e.printStackTrace();
			}
			finally{
			try{
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			}
			
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
 try
					      { 
							//Added against ML-MMOH-CRF-0678
							sql= "SELECT meal_category_code, description FROM ds_meal_category_lang_vw WHERE meal_category_code IN ('STF', 'ONC', 'STU','DOC','OPS') AND (language_id = ?) ORDER BY 2, 1";

							stmt=con.prepareStatement(sql);
							stmt.setString(1,locale);
							rs=stmt.executeQuery();
							if(rs!=null)
							{
							   while(rs.next())
							        {
								        meal_category_code=rs.getString(1);
								        meal_category_description=rs.getString(2);
					
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(meal_category_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(meal_category_description));
            _bw.write(_wl_block29Bytes, _wl_block29);
  
									}
							}
					
            _bw.write(_wl_block34Bytes, _wl_block34);
 }catch(Exception e){
						e.printStackTrace();
						}
				  finally{
					try{
						if(rs!=null) rs.close();
						if(stmt!=null) stmt.close();
					}catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(current_date));
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(current_date));
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
 try
								      {
										/* appl_staff_order_yn is added newly */
										//sql= "select DIET_TYPE,SHORT_DESC from DS_DIET_TYPE_LANG_VW where (LANGUAGE_ID = ?) and (EFF_STATUS='E') and (appl_staff_order_yn = 'Y') order by  2 , 1";//CRF-0419-US8 Commented Against ML-MMOH-CRF-0674
										// Added Against ML-MMOH-CRF-0674
										sql= "select DIET_TYPE,SHORT_DESC from DS_DIET_TYPE_LANG_VW where (LANGUAGE_ID = ?) and (EFF_STATUS='E') and (appl_staff_order_yn = 'Y') order by  LOWER (short_desc)";//CRF-0419-US8 
										stmt=con.prepareStatement(sql);
										stmt.setString(1,locale);
										rs=stmt.executeQuery();
										if(rs!=null)
										{
										   while(rs.next())
										        {
											        diet_type_code=rs.getString(1);
											        diet_type_description=rs.getString(2);
								                    
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(diet_type_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(diet_type_description));
            _bw.write(_wl_block46Bytes, _wl_block46);
  }
									  }
            _bw.write(_wl_block47Bytes, _wl_block47);
 }catch(Exception e){
				e.printStackTrace();
			}
		finally{
		try{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
}

            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
 try
								      {
										/* appl_staff_order_yn is added newly */
										sql= "select MEAL_CLASS as col_1_0_,SHORT_DESC as col_0_0_ from DS_MEAL_CLASS_LANG_VW where (EFF_STATUS='E') and (LANGUAGE_ID = ?) and (appl_staff_order_yn ='Y') order by  2 , 1";//CRF-0419-US8
										stmt=con.prepareStatement(sql);
										stmt.setString(1,locale);
										rs=stmt.executeQuery();
										if(rs!=null)
										{
										   while(rs.next())
										        {
											  	 	meal_class_code=rs.getString(1);
											   		meal_class_description=rs.getString(2);
								                    
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(meal_class_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(meal_class_description));
            _bw.write(_wl_block46Bytes, _wl_block46);
  }
									  }
            _bw.write(_wl_block50Bytes, _wl_block50);
 }catch(Exception e){
				e.printStackTrace();
				}
		finally{
		try{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		}

            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
 try
			  {
				sql= "select MEAL_TYPE,SHORT_DESC from DS_MEAL_TYPE_LANG_VW where LANGUAGE_ID = ? AND  EFF_STATUS='E' AND (NVL(DOC_MEAL_ORDER_YN, 'N') = 'Y' OR NVL(OPS_MEAL_ORDER_YN, 'N') = 'Y' OR NVL(ONC_MEAL_ORDER_YN, 'N') = 'Y' OR NVL(STF_MEAL_ORDER_YN, 'N') = 'Y' OR NVL(STU_MEAL_ORDER_YN, 'N') = 'Y') order by meal_order";
				//ML-MMOH-CRF-0820 & ML-MMOH-CRF-1006-US3 
				stmt=con.prepareStatement(sql);
				stmt.setString(1,locale);
				rs=stmt.executeQuery();
				if(rs!=null)
				{
				   while(rs.next())
						{
							meal_type_code=rs.getString(1);
							meal_type_description=rs.getString(2);
							
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(meal_type_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(meal_type_description));
            _bw.write(_wl_block29Bytes, _wl_block29);
  }
			  }
            _bw.write(_wl_block47Bytes, _wl_block47);
 }catch(Exception e){
			e.printStackTrace();
			}
		finally{
		try{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
}

            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
if(isMenuType){
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
}
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
try{
			if(mealOrderFromDate.equals(""))
					mealOrderFromDate=current_date;
			if(mealOrderToDate.equals(""))
					mealOrderToDate=current_date;

			con	= ConnectionManager.getConnection(request);
			String sql_OnLoadQuery="SELECT ROWNUM, staff_order_id, menu_type, menu_type_desc, order_from_date, order_to_date, meal_category, meal_cat_desc, practitioner_id, prac_name, location_code, diet_req_loc_desc,diet_type, diet_type_desc, meal_class, meal_class_desc, meal_type, meal_type_desc, no_of_meals_orders, added_by_id, ordered_by, modified_by,total_cnt FROM (SELECT ROWNUM, a.staff_order_id, a.menu_type, ds_get_desc.ds_menu_type (a.menu_type, ?, '2') menu_type_desc, TO_CHAR (a.order_from_date, 'DD/MM/YYYY') AS order_from_date, TO_CHAR (a.order_to_date, 'DD/MM/YYYY') AS order_to_date, a.meal_category, ds_get_desc.ds_meal_category (a.meal_category, ?, '1') meal_cat_desc, a.practitioner_id, am_get_desc.am_practitioner (a.practitioner_id, ?, '1') prac_name,  a.location_code, ds_get_desc.ds_diet_req_loc (a.location_code, ?, '2') diet_req_loc_desc, b.diet_type, ds_get_desc.ds_diet_type (b.diet_type, ?, '2') diet_type_desc, b.meal_class, ds_get_desc.ds_meal_class (b.meal_class, ?, '2') meal_class_desc, b.meal_type, ds_get_desc.ds_meal_type (b.meal_type, ?, '2') meal_type_desc, b.no_of_meals_orders, b.added_by_id, sm_get_desc.sm_appl_user (b.added_by_id, ?, '1') ordered_by, CASE WHEN b.modified_date > b.added_date THEN sm_get_desc.sm_appl_user (b.modified_by_id, ?, '1') WHEN a.modified_date > a.added_date  THEN sm_get_desc.sm_appl_user (a.modified_by_id, ?,'1') END modified_by,(no_of_meals_served + no_of_meals_received + no_of_meals_rejected) total_cnt FROM ds_staff_orders_hdr a, ds_staff_orders_dtl b WHERE a.facility_id = b.facility_id AND a.staff_order_id = b.staff_order_id AND NVL(a.eff_status,'A') != 'D' AND (   (   a.order_from_date BETWEEN TO_DATE (?, 'dd/mm/yyyy') AND TO_DATE (?, 'dd/mm/yyyy') OR a.order_to_date BETWEEN TO_DATE (?, 'dd/mm/yyyy') AND TO_DATE (?, 'dd/mm/yyyy') ) OR (   TO_DATE (?, 'dd/mm/yyyy') BETWEEN a.order_from_date AND a.order_to_date OR TO_DATE (?, 'dd/mm/yyyy') BETWEEN a.order_from_date AND a.order_to_date))  order by staff_order_id)"; //CRF-832 and Modified Against IN-065835
			stmt	= con.prepareStatement(sql_OnLoadQuery) ;					
			stmt.setString(1,locale);	
			stmt.setString(2,locale);	
			stmt.setString(3,locale);	
			stmt.setString(4,locale);	
			stmt.setString(5,locale);	
			stmt.setString(6,locale);	
			stmt.setString(7,locale);	
			stmt.setString(8,locale);	
			stmt.setString(9,locale);	
			stmt.setString(10,locale);	
			stmt.setString(11,mealOrderFromDate);	
			stmt.setString(12,mealOrderToDate);	
			stmt.setString(13,mealOrderFromDate);	
			stmt.setString(14,mealOrderToDate);	
			stmt.setString(15,mealOrderFromDate);	
			stmt.setString(16,mealOrderToDate);	
			rs	= stmt.executeQuery();
			while(rs!=null && rs.next()){ 
				staff_order_id =checkForNull(rs.getString("staff_order_id")); //hdr
				rownum =checkForNull(rs.getString("rownum"));
				order_from_date =checkForNull(rs.getString("order_from_date")); // hdr
				order_to_date =checkForNull(rs.getString("order_to_date")); // hdr
				menu_type =checkForNull(rs.getString("MENU_TYPE")); //hdr
				menu_type_descrption =checkForNull(rs.getString("MENU_TYPE_DESC"));
				diet_type =checkForNull(rs.getString("DIET_TYPE"));
				diet_type_desc =checkForNull(rs.getString("DIET_TYPE_DESC"));
				meal_class =checkForNull(rs.getString("MEAL_CLASS"));
				meal_class_desc =checkForNull(rs.getString("MEAL_CLASS_DESC"));
				meal_category =checkForNull(rs.getString("MEAL_CATEGORY")); // hdr
				meal_category_desc =checkForNull(rs.getString("MEAL_CAT_DESC"));
				noof_orders =checkForNull(rs.getString("NO_OF_MEALS_ORDERS"));
				practId =checkForNull(rs.getString("PRACTITIONER_ID")); //hdr
				practName =checkForNull(rs.getString("PRAC_NAME"));
				diet_req_location =checkForNull(rs.getString("LOCATION_CODE")); //hdr
				diet_req_location_desc =checkForNull(rs.getString("DIET_REQ_LOC_DESC"));
				meal_type =checkForNull(rs.getString("MEAL_TYPE"));
				meal_type_desc =checkForNull(rs.getString("MEAL_TYPE_DESC"));
				last_addedById =checkForNull(rs.getString("ADDED_BY_ID")); //hdr
				orderedBy =checkForNull(rs.getString("ORDERED_BY"));
				last_modifiedById =checkForNull(rs.getString("MODIFIED_BY"));
				total_cnt =rs.getInt("total_cnt");
				/*Added Against Start IN-065835 */  
				if(practName==""){
					practName="&nbsp";
				}
				if(orderedBy==""){
					orderedBy="&nbsp";
				}
				if(last_modifiedById==""){
					last_modifiedById="&nbsp";
				}
				/*Added Against End IN-065835 */  
				if(staff_order_id!=null)
				mode="update";
			
	 out.println("<tr>");
	 if(isMenuType){
	out.println("<td id='"+"menu_type"+rowCount+"' class='"+class_val+"'>"+menu_type_descrption+"</td><input type='hidden' name='"+"hid_menu_type_descrption"+rowCount+"' id='"+"hid_menu_type_descrption"+rowCount+"' value='"+menu_type+"'/>");	
	}
	out.println("<td id='"+"order_from_date"+rowCount+"' class='"+class_val+"'>"+order_from_date+"</td><input type='hidden' name='"+"hid_order_from_date"+rowCount+"' id='"+"hid_order_from_date"+rowCount+"' value='"+order_from_date+"'/>");	
	
	out.println("<td id='"+"order_to_date"+rowCount+"' class='"+class_val+"'>"+order_to_date+"</td><input type='hidden' name='"+"hid_order_to_date"+rowCount+"' id='"+"hid_order_to_date"+rowCount+"' value='"+order_to_date+"'/>");	
	
	if(isMenuType){ 
	if(total_cnt > 0){
	out.println("<td id='"+"diet_type"+rowCount+"' class='"+class_val+"'>"+ diet_type_desc +"</td><input type='hidden' name='"+"hid_diet_type"+rowCount+"' id='"+"hid_diet_type"+rowCount+"' value='"+diet_type+"'/>");
	}else{
	out.println("<td id='"+"diet_type"+rowCount+"' class='"+class_val+"'>"+"<a href=\"javascript:updateRecord1('" + menu_type_descrption + "','" + menu_type + "','" + order_from_date + "','" + order_to_date + "','" + diet_type_desc + "','" + diet_type + "','" + meal_class_desc + "','" + meal_class + "','" + meal_type_desc + "','" + meal_type + "','" + noof_orders + "','" + meal_category_desc + "','" + meal_category + "','" + practName + "','" + diet_req_location_desc + "','" + diet_req_location + "','"+practId+"','"+orderedBy+"','"+last_addedById+"','"+last_modifiedById+"','"+mode+"','"+staff_order_id+"','"+total_cnt+"','" + rowCount + "');\">" + diet_type_desc + "</a></td><input type='hidden' name='"+"hid_diet_type"+rowCount+"' id='"+"hid_diet_type"+rowCount+"' value='"+diet_type+"'/>");
	}
	}else{
 	if(total_cnt > 0){
	out.println("<td id='"+"diet_type"+rowCount+"' class='"+class_val+"'>"+ diet_type_desc +"</td><input type='hidden' name='"+"hid_diet_type"+rowCount+"' id='"+"hid_diet_type"+rowCount+"' value='"+diet_type+"'/>");
	}else{ 
	out.println("<td id='"+"diet_type"+rowCount+"' class='"+class_val+"'>"+"<a href=\"javascript:updateRecord('" + order_from_date + "','" + order_to_date + "','" + diet_type_desc + "','" + diet_type + "','" + meal_class_desc + "','" + meal_class + "','" + meal_type_desc + "','" + meal_type + "','" + noof_orders + "','" + meal_category_desc + "','" + meal_category + "','" + practName + "','" + diet_req_location_desc + "','" + diet_req_location + "','"+practId+"','"+orderedBy+"','"+last_addedById+"','"+last_modifiedById+"','"+mode+"','"+staff_order_id+"','"+total_cnt+"','" + rowCount + "');\">" + diet_type_desc + "</a></td><input type='hidden' name='"+"hid_diet_type"+rowCount+"' id='"+"hid_diet_type"+rowCount+"' value='"+diet_type+"'/>");
	}
	}
	out.println("<td id='"+"meal_class"+rowCount+"' class='"+class_val+"'>"+meal_class_desc+"</td><input type='hidden' name='"+"hid_meal_class"+rowCount+"' id='"+"hid_meal_class"+rowCount+"' value='"+meal_class+"'/>");		
	
	out.println("<td id='"+"meal_type"+rowCount+"' class='"+class_val+"'>"+meal_type_desc+"</td><input type='hidden' name='"+"hid_meal_type"+rowCount+"' id='"+"hid_meal_type"+rowCount+"'  value='"+meal_type+"'/>");		
	
	out.println("<td id='"+"noof_orders"+rowCount+"' class='"+class_val+"'>"+noof_orders+"</td><input type='hidden' name='hid_noof_orders"+rowCount+"' id='hid_noof_orders"+rowCount+"' id='hid_noof_orders"+rowCount+"' value='"+noof_orders+"'/>");	
	
	out.println("<td id='"+"meal_category"+rowCount+"' class='"+class_val+"'>"+meal_category_desc+"</td><input type='hidden' name='"+"hid_meal_category"+rowCount+"' id='"+"hid_meal_category"+rowCount+"' value='"+meal_category+"'/>");		
	
	out.println("<td id='"+"practId"+rowCount+"' class='"+class_val+"'>"+practName+"</td><input type='hidden' name='"+"hid_practId"+rowCount+"' id='"+"hid_practId"+rowCount+"' id='"+"hid_practId"+rowCount+"' value='"+practId+"'/>");		
	
	out.println("<td id='"+"diet_req_location"+rowCount+"' class='"+class_val+"'>"+diet_req_location_desc+"</td><input type='hidden' name='"+"mode"+rowCount+"' id='"+"mode"+rowCount+"' id='"+"mode"+rowCount+"' value='update'/><input type='hidden' name='"+"hid_diet_req_location"+rowCount+"' id='"+"hid_diet_req_location"+rowCount+"' id='hid_diet_req_location"+rowCount+"'    value='"+diet_req_location+"'/>");		
	
	out.println("<td id='"+"last_addedById"+rowCount+"' class='"+class_val+"'>"+orderedBy+"</td><input type='hidden' name='"+"hid_orderedby"+rowCount+"' id='"+"hid_orderedby"+rowCount+"' id='"+"hid_orderedby"+rowCount+"' value='"+last_addedById+"'/>");		
	
	out.println("<td id='"+"last_modifiedById"+rowCount+"' class='"+class_val+"'>"+last_modifiedById+"</td><input type='hidden' name='"+"hid_last_modifiedById"+rowCount+"' id='"+"hid_last_modifiedById"+rowCount+"' value='"+last_modifiedById+"'/>");	
		
	out.println("<input type='hidden' name='"+"hid_total_cnt"+rowCount+"' id='"+"hid_total_cnt"+rowCount+"' value='"+total_cnt+"'/>");
	
	if(total_cnt > 0){
	out.println("<td id='"+"staff_order_id"+rowCount+"' class='"+class_val+"'>"+ DELETE + "</a></td><input type='hidden' name='"+"hid_staff_order_id"+rowCount+"' id='"+"hid_staff_order_id"+rowCount+"' value='"+staff_order_id+"'/>");
	}else{
	out.println("<td id='"+"staff_order_id"+rowCount+"' class='"+class_val+"'>"+"<a href=\"javascript:deleteRecord('"+staff_order_id+"','" + rowCount + "');\">" + DELETE + "</a></td><input type='hidden' name='"+"hid_staff_order_id"+rowCount+"' id='"+"hid_staff_order_id"+rowCount+"' value='"+staff_order_id+"'/>");
	}

	out.println("</tr>"); 
	
	
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(isMenuType));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(menu_type_descrption));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(menu_type));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(order_from_date));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(order_to_date));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(diet_type_desc));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(diet_type));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(meal_class_desc));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(meal_class));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(meal_type_desc));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(meal_type));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(noof_orders));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(meal_category_desc));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(meal_category));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(practName));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(diet_req_location_desc));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(diet_req_location));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(practId));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(orderedBy));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(last_addedById));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(last_modifiedById));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(staff_order_id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(total_cnt));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(order_from_date));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(order_to_date));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(diet_type_desc));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(diet_type));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(meal_class_desc));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(meal_class));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(meal_type_desc));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(meal_type));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(noof_orders));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(meal_category_desc));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(meal_category));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(practName));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(diet_req_location_desc));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(diet_req_location));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(practId));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(orderedBy));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(last_addedById));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(last_modifiedById));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(staff_order_id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(total_cnt));
            _bw.write(_wl_block93Bytes, _wl_block93);

	rowCount++;
	}
	if(rowCount==0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); //history.go(-1);</script>");
		}				
	}catch(Exception e){
			System.err.println("Exception in catch MealOrderCUD.jsp==="+e);
			e.printStackTrace();
	}finally{
		try{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e){
			System.err.println("Exception in Final MealOrderCUD.jsp==="+e);
			e.printStackTrace();
		}
	}
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(params));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(current_date));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(isMenuType));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(LATE_IRREGULAR_DIET_ORD_FOR_ST));
            _bw.write(_wl_block102Bytes, _wl_block102);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.MenuType.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.DietRequestLocation.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.MealCategory.Label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.practitionerName.Label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.MealOrderFrom.Label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.MealOrderTo.Label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.DietType.Label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.MealClass.Label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.MealType.Label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.NoOfOrders.Label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.search.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.MenuType.Label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.MealOrderFrom.Label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.MealOrderTo.Label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.DietType.Label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.MealClass.Label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.MealType.Label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.NoOfOrders.Label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.MealCategory.Label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.practitionerName.Label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.DietRequestLocation.Label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderedBy.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.LastModifiedBy.label", java.lang.String .class,"key"));
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
}
