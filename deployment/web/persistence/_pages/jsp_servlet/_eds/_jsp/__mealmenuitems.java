package jsp_servlet._eds._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eDS.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.net.URLEncoder;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __mealmenuitems extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eds/jsp/mealMenuItems.jsp", 1738425328000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="<!--Modified against AMS-CRF-0112-->\n";
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

    private final static java.lang.String  _wl_block7 ="\n \n<head target=\"_self\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script> ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script language=\"javascript\" src=\"../../eDS/js/PlaceDietOrder.js\"></script>\n\t<script language=\"Javascript\" src=\"../../framework/js/PopupWindow.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<!--ML-MMOH-CRF-0427 US3 start-->\n\t<script type=\"text/javascript\" src=\"../../eDS/js/PlaceDietOrder.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eDS/js/PlaceDietOrderPHIS.js\"></script>\n\t\n\t<link rel=\"stylesheet\" href=\"../../eDS/css/jquery-ui.css\">\n\t<script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\n\t<script src=\"https://code.jquery.com/ui/1.12.1/jquery-ui.min.js\"></script>\n\t<link rel=\"stylesheet\" href=\"https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css\">\n\t\n    <!--<script type=\"text/javascript\" src=\"../../eDS/js/common/semiDisabledDateTime/datepicker-ar.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eDS/js/common/semiDisabledDateTime/common.datepicker-bg.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eDS/js/common/semiDisabledDateTime/datepicker-en.js\"></script> --> \n\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\n\t<!--<script type=\"text/javascript\" src=\"../../eDS/js/common/semiDisabledDateTime/datepicker-ar.js\"></script>\n  \t<script type=\"text/javascript\" src=\"../../eDS/js/common/semiDisabledDateTime/datepicker-th.js\"></script>-->\n\t<script type=\"text/javascript\" src=\"../../eDS/js/common/semiDisabledDateTime/datepicker-";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =".js\"></script>\n\t<!--ML-MMOH-CRF-0427  US3ends-->\n\t<script > var lblAdditionalInstruction=getLabel(\"eDS.AdditionalInstruction.Label\",\"DS\")\t</script><!-- Added aginst AMS-CRF-112-->\n</head>\n<body>\n<script type=\"text/javascript\" src=\"../../eOT/js/wz_tooltip.js\"></script><!--Added Against AMS-CRF-0112-->\n\t<form>\n\t<a name= \"reload\" id= \"reload\" href=\"Reload\" style=\'visibility:hidden\'>Reload</a>\n\t<input type=\"hidden\" name=\"MealItemsArray\" id=\"MealItemsArray\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"/>\n\t<input type=\"hidden\" name=\"totalItems\" id=\"totalItems\" value=\"\"/>\n\t<input type=\"hidden\" name=\"paramValues\" id=\"paramValues\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"/>\n\t<script>\n\tvar subtotal=0;\n\tvar gt=0;\n\tvar MealItems=document.getElementById(\"MealItemsArray\").value;\n\tvar itemList=(MealItems).split(\',\');\n\tvar MealItemsArray=new Array();\n\tvar k=0;\n\tfor(var i=0;i<(itemList.length/9);i++) {\n\t\tMealItemsArray[i]=new Array();\n\t\tfor(var j=0;j<9;j++,k++) {\n\t\t\tMealItemsArray[i][j]=itemList[k];\n\t\t}\n\t}\n\t</script>\n\t\t<table class=\'chkFormChange\' width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'90%\' align=\'center\' id=\"listContentTable\" style=\"overflow-x:scroll;\">\n\t\t\t\t\t<tr align=\"left\">\n\t\t\t\t\t\t<td colspan=\"1\" noWrap class=\"label\" >\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td colspan=\"1\">\n\t\t\t\t\t\t\t<input type=\"text\" name=\"dateForMenu\" id=\"dateForMenu\" id=\"dateForMenu\" size=\"10\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" onblur=\"isValidDate(this);return getDayRefNoForMealMenu(this.value,\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\',\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\');\"  onmouseover=\"return getDayRefNoForMealMenu(this.value,\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\');\">\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<!--ML-MMOH-CRF-0427 US3 start-->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\"  name=\'datepickerimg\' id=\'datepickerimg\' onclick=\"grayOutCalendar(\'dateForMenu\',";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =",\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\')\">\n\t\t\t\t\t\t\t\t<!--img src=\'../../eCommon/images/mandatory.gif\' /-->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\t\n\t\t\t\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'dateForMenu\');\">\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t<!--ML-MMOH-CRF-0427 US3 ends-->\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n \t\t\t\t\t\t\t<!--img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'dateForMenu\');\"-->\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td colspan=\"1\" noWrap class=\"label\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" :\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<TD>\n\t\t\t\t\t\t\t<select name=\"dayRef\" id=\"dayRef\">\n\t\t\t\t\t\t\t\t<option value=\"\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</option>\n\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</option>\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tdocument.getElementById(\"dayRef\").value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\";\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<td noWrap>\n\t\t\t\t\t\t\t<input type=\"button\" name=\"fecth\" id=\"fecth\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" onclick=\"refreshWithNewData(\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\');\" class=\"Button\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t<div style=\"overflow-y: scroll;height:65vh;width:100%;\">\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n<style>\n\t.ALLTABLES{\n\t   width:980px;\n\t   min-width: 100%;\n\t   overflow-x:auto;\n\t   height:auto;\t \n\t}\n\t\n\t.ALLTABLESDATA{\n\t\ttable-layout: fixed;\n\t\twidth: 100%;\n\t    margin-bottom:10px;\n\t}\n\t\n\t.widthSmallpx{\n\t width:160 px;\n\t}\n\t\n\t.widthBigpx{\n\t width:350px;\n\t}\n\n\t.TABSCENTER{\n\tdisplay:table;\n\ttext-align :center;\n\tvertical-align :middle;\n\t}\n\t</style>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t<table border=\'1\' cellpadding=\'2\' cellspacing=\'0\' width=\'90%\' align=\'center\' bordercolor=\"#9999FF\" >\n\t\t<tr>\n\t\t\t<th colspan=\"3\">\n\t\t\t\t<img id=\"showHideArrow";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" src=\"../../eDS/css/arrow-up.png\" alt=\"Arrow\" align=\"left\" onclick=\"showHideTab(\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\');\" />\n\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="-";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t<input type=\"text\" name=\"subtotal";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" id=\"subtotal";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" size=4 style=\"background:transparent;align:right;color=white;border=0\" readonly=\"true\" class=\"label\" />\n\t\t\t\t<input type=\"text\" name=\"Uom";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" id=\"Uom";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" size=4 style=\"background:transp arent;align:left;color=white;border=0\" readonly=\"true\" class=\"label\" />\n\t\t\t</th>\n\t\t</tr>\n\t</table>\t\n\t<!-- KDAH-CRF-0352-Scroll Start -->\n\t\t<div class=\"TABSCENTER\" id=\"showHideTab";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" >\n\t\t<div  class= \"ALLTABLES\" >\n\t<table class=\"ALLTABLESDATA\" width=\"90%\" border=\'1\' cellpadding=\'2\' cellspacing=\'0\' align=\'center\' bordercolor=\"#9999FF\" id=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t<!-- KDAH-CRF-0352-Scroll End -->\n\t\t<tr align=\"center\">\n\t\t<!--Modified Against KDAH-CRF-0352 Serve US4-->\n\t\t\t<td class=\"data widthSmallpx\"> <!-- KDAH-CRF-0352-Scroll -->\n\t\t\t\t<input type=\'checkbox\' id=\"serveChkUnchkAll";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" checked=\"checked\" onclick=\"chkUnchkAll(\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\')\" /> \n\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t</td>\n\t<!-- KDAH-CRF-0352-Scroll Start -->\n\t\t\t<td class=\"data widthSmallpx\" > Item </td>\n\t\t\t<td class=\"data widthBigpx\"> ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" </td>\n\t<!-- KDAH-CRF-0352-Scroll End -->\n\t<!--Added Against KDAH-CRF-0352 US4 Starts Here-->\t\t\t\t\t\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t\t\n\t\t\t<td class=\"data widthSmallpx\" > ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" </td><!-- KDAH-CRF-0352-Scroll -->\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t<!--Added Against KDAH-CRF-0352 US4 Ends Here-->\t\t\t\t\t\t\t\n\t</tr>\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t<td class=\"widthSmallpx\">";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td><!-- KDAH-CRF-0352-Scroll -->\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t<tr>\n\t\t<!--Modified Against KDAH-CRF-0352 Serve US4-->\n\t\t\t<td align=\'center\' class=\"widthSmallpx\"><!-- KDAH-CRF-0352-Scroll -->\n\t\t\t\t<input type=\'checkbox\' name=\"check";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" id=\"check";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" id=\"serveChkUnchk";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" checked=\"checked\" onclick=\"updateCalori(\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\',\'true\',\' \',this,\'chk\');return changeIT(\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\',this)\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" /> ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t</td>\n\t\t\t\t\t\t\t\t\n\t\t\t<td id=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="_";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" class=\"label widthSmallpx\" ><!-- KDAH-CRF-0352-Scroll -->\n\t\t\t\t<div id=\"div";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</div>\n\t\t\t\t<input type=\"hidden\" name=\"mealType";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" id=\"mealType";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\"/>\n\t\t\t\t<input type=\"hidden\" name=\"itemCode";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" id=\"itemCode";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\"/>\n\t\t\t\t<input type=\"hidden\" name=\"menuCode";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" id=\"menuCode";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\"/>\n\t\t\t\t<input type=\"hidden\" name=\"foodItemDesc";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" id=\"foodItemDesc";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\"/>\n\t\t\t\t<input type=\"hidden\" name=\"dietType";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" id=\"dietType";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\"/>\n\t\t\t\t<input type=\"hidden\" name=\"menuSL";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" id=\"menuSL";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" value=\"\"/>\n\t\t\t\t<input type=\"hidden\" name=\"mealmenuSL";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" id=\"mealmenuSL";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" value=\"0\"/>\n\t\t\t\t<input type=\"hidden\" name=\"reviewType";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" id=\"reviewType";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" value=\"N\"/>\n\t\t\t\t<!--input type=\"hidden\" name=\"methodFlag";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" value=\"9\"/-->\n\t\t\t\t<input type=\"hidden\" name=\"methodFlag";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" id=\"methodFlag";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" value=\"5\"/><!-- Modified Against AMRI-SCF-0701-->\n\t\t\t\t<input type=\"hidden\" name=\"itemType";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" id=\"itemType";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\"/>\n\t\t\t\t<input type=\"hidden\" name=\"servingCodeUom";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" id=\"servingCodeUom";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\"/>\n\t\t\t\t<input type=\"hidden\" name=\"servingCodeUomDesc";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" id=\"servingCodeUomDesc";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\"/>\n\t\t<!-- Modified against KDAH-CRF-0352-->\n\t\t\t\t<input type=\"hidden\" name=\"mealTypeDesc";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" id=\"mealTypeDesc";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\"/>\n\t\t\t</td>\n\t\t\t<td class=\"widthBigpx\"><!-- KDAH-CRF-0352-Scroll -->\n\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t<input type=\"text\" name=\"itemQty";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" id=\"itemQty";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" onkeydown=\"return chkifPositive(event, this);\" onblur=\"updateCalori(\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\',\'true\',\' \',this,\'true\');return changeOfQty(\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\');\" size=\"4\" value=\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\'/>\n\t\t\t\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="<!--Modified against KDAH-CRF-0352-->\n\t\t\t\t<input type=\"hidden\" name=\"calori";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" id=\"calori";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" />\n\t\t\t\t<input type=\"hidden\" name=\"calorificContPerUom";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" id=\"calorificContPerUom";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\"\tvalue=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\"/>\n\t\t\t\t<input type=\"hidden\" size=4 name=\"energy\" id=\"energy\" value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\" /><!--Modified Against KDAH-CRF-0352 -->\n\t\t\t\t<input type=\"hidden\" size=4 name=\"energyUomDesc\" id=\"energyUomDesc\" value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" /><!--Modified Against KDAH-CRF-0352 -->\n\t\t\t\t<input type=\"hidden\" size=4 name=\"NutrientDesc";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" id=\"NutrientDesc";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" /><!--Modified Against KDAH-CRF-0352 ICN-#65555-->\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" size=4 name=\"NutrientUomQty";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\" id=\"NutrientUomQty";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\" /><!--Modified Against KDAH-CRF-0352 ICN-#65555-->\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t<input type=\"hidden\" size=4 name=\"energyUomDesc\" id=\"energyUomDesc\" value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\" /><!--Modified Against KDAH-CRF-0352 -->\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t(\n\t\t\t\t<input type=\"text\" size=4 name=\"totalCal";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\" id=\"totalCal";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\"  style=\"background:transparent;border=0\" readonly=\"true\" class=\"label\" />\n\t\t\t\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="<!--Modified Against KDAH-CRF-0352 -->\n\t\t\t\t)\n\t\t\t<script>\n\t\t\t\tvar caloriPerMeal;\n\t\t\t\tvar calorific_Cont_Per_Uom=\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\';\n\t\t\t\tvar item_Qty=\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\';\n\t\t\t\tif(calorific_Cont_Per_Uom==0 || item_Qty==0)\n\t\t\t\t\tcaloriPerMeal=0;\n\t\t\t\telse\n\t\t\t\t\tcaloriPerMeal=parseInt(\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\")*parseInt(\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\");\n\t\t\t\tdocument.getElementById(\"calori";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\").value=caloriPerMeal;\n\t\t\t\tdocument.getElementById(\"totalCal";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\").value=caloriPerMeal;\n\t\t\t</script>\n\t\t\t<input type=\"hidden\" name=\"Qty";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\" id=\"Qty";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\" />\n\t\t\t<input type=\"hidden\" name=\"IntQty";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\" id=\"IntQty";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" />\n\t\t\t\t\t\t\t\t</td>\t\t\t\t\t\t\t\t\t\t\t\t\t\t \n\t\t<input type=\"hidden\" name=\"foodItem";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\" id=\"foodItem";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\" />\n<!--Added Against KDAH-CRF-0352 US4 Starts Here-->\t\t\t\t\t\t\t\t\t\t\t \n";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t\t\t\t\t<input type=\"hidden\" size=4 name=\"ServingUomColcnt";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" id=\"ServingUomColcnt";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\" />\n\t\t\t\t";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n\t\t\t\t\t<td class=\"widthSmallpx\"><!-- KDAH-CRF-0352-Scroll -->\n\t\t\t\t\t<input type=\"text\" size=20 name=\"ServingUom";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\" id=\"ServingUom";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\"  style=\"background:transparent;border=0\" readonly=\"true\" class=\"label\" />\n\t\t\t\t\t<script>\t\t\t\t\t\n\t\t\t\t\t\tdocument.getElementById(\"ServingUom";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\").value=\'";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\';\n\t\t\t\t\t</script>\n\t\t\t\t\t</td><!-- Alignment -->\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t\t\t\t<input type=\"hidden\" size=4 name=\"ServingUomColcnt";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\" value=\"0\" />\n\t\t\t\t";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n<!--Added Against KDAH-CRF-0352 US4 Ends Here-->\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar reviewType=\'";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\';\n\t\t\t\t\t\t\tif(reviewType!=\'M\')\n\t\t\t\t\t\t\t\tsubtotal=parseInt(subtotal)+parseInt(document.getElementById(\"calori";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\").value);\n\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<!--Modified Against KDAH-CRF-0352 Serve US4 -->\n\t\t\t\t\t\t\t<td align =\'center\' class=\"widthSmallpx\"><!-- KDAH-CRF-0352-Scroll -->\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"reviewType";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\"/>\n";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\n\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\"check";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\"  id=\"serveChkUnchk";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\" onclick=\"updateCalori(\'";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n\t\t\t\t\t\t\t<td id=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\" class=\"label\" style=\"FONT-SIZE: 8pt;COLOR: Brown;\">\n\t\t\t\t\t\t\t\t<div id=\"div";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\" style=\"FONT-SIZE: 8pt;COLOR: Brown;\" >";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="</div>\n";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\" class=\"label\">\n\t\t\t\t\t\t\t\t<div id=\"div";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\" >";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"mealType";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\"/>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"itemCode";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\"/>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"menuCode";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\"/>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"foodItemDesc";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\"/>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"dietType";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\"/>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"menuSL";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"mealmenuSL";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\" value=\"0\"/>\n";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\n\t\t\t\t\t\t<input type=\"hidden\" name=\"mealmenuSL";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\" value=\"2\"/>\n";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\n\t\t\t\t\t\t<input type=\"hidden\" name=\"reviewType";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\"/>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"methodFlag";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\" value=\"5\"/>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"itemType";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\"/>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"servingCodeUom";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\"/>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"servingCodeUomDesc";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\"/><!-- Modified against KDAH-CRF-0352-->\n\t\t\t\t\t\t<input type=\"hidden\" name=\"mealTypeDesc";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\"/>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\n\t\t\t\t\t\t\t<input type=\"text\" name=\"itemQty";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\'/>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="<!-- Modified against KDAH-CRF-0352-->\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tvar counter=";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 =";\n\t\t\t\t\t\t\t\tif(document.getElementById(\'reviewType\'+counter).value==\'M\')\n\t\t\t\t\t\t\t\t\tdocument.getElementById(\"itemQty\"+counter).readOnly=true;\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"calori";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\" />\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"calorificContPerUom";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\"/>\n\t\t\t\t\t\t\t<input type=\"hidden\" size=4 name=\"energy\" id=\"energy\" value=\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\" /><!--Modified Against KDAH-CRF-0352-->\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<input type=\"hidden\" size=4 name=\"NutrientDesc";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\" /><!--Modified Against KDAH-CRF-0352 ICN-#65555-->\n\t\t\t\t\t\t\t<input type=\"hidden\" size=4 name=\"NutrientUomQty";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\" /><!--Modified Against KDAH-CRF-0352 ICN-#65555-->\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<input type=\"hidden\" size=4 name=\"energyUomDesc\" id=\"energyUomDesc\" value=\"";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\" /><!--Modified Against KDAH-CRF-0352-->\n\t\t\t\t\t\t\t(\n\t\t\t\t\t\t\t\t<input type=\"text\" size=4 name=\"totalCal";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\"  style=\"background:transparent;border=0\" readonly=\"true\" class=\"label\" />\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="<!--Modified against KDAH-CRF-0352-->\n\t\t\t\t\t\t\t )\n\t\t\t\t<script>\n\t\t\t\t\tvar caloriPerMeal;\n\t\t\t\t\tvar calorific_Cont_Per_Uom=\'";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\';\n\t\t\t\t\tvar item_Qty=\'";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\';\n\t\t\t\t\tif(calorific_Cont_Per_Uom==0 || item_Qty==0)\n\t\t\t\t\t\tcaloriPerMeal=0;\n\t\t\t\t\telse \n\t\t\t\t\t\tcaloriPerMeal=parseInt(\"";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\");\n\t\t\t\t\tdocument.getElementById(\"calori";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\").value=caloriPerMeal;\n\t\t\t\t\tdocument.getElementById(\"totalCal";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\").value=caloriPerMeal;\n\t\t\t\t</script>\n\t\t\t\t<input type=\"hidden\" name=\"Qty";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\" />\n\t\t\t\t<input type=\"hidden\" name=\"IntQty";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\" />\n\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t<input type=\"hidden\" name=\"foodItem";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\" />\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t<!-- Added Against ICN-#65555 0352 KDAH-CRF-0352 US4 Starts Here-->\n\t";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\" />\n\t\t\t";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\n\t\t\t\t<td>&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\n\t\t\t\t<td>\n\t\t\t\t<input type=\"text\" size=4 name=\"ServingUom";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\"  style=\"background:transparent;border=0\" readonly=\"true\" class=\"label\" />&nbsp;\n\t\t\t\t<script>\t\t\t\t\t\t\t\t\t\n\t\t\t\tdocument.getElementById(\"ServingUom";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\';\n\t\t\t\t</script>\n\t\t\t\t</td>\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\n\t\t\t<input type=\"hidden\" size=4 name=\"ServingUomColcnt";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\" value=\"0\" />\n\t\t\t";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\n\t\t<!--Added Against ICN-#65555 0352 KDAH-CRF-0352 US4 Ends Here-->\t\t\t\t\t\n\t\t</tr>\n\t\t<script>\n\t\t\tvar reviewType=\'";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\';\n\t\t\tif(reviewType!=\'M\')\n\t\t\t\tsubtotal=parseInt(subtotal)+parseInt(document.getElementById(\"calori";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\").value);\n\t\t</script>\n";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\n\t\t\t<input type=\"hidden\" name=\"tabSize";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\" id=\"tabSize";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\"> ";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\n\t\t\t<input type=\"hidden\" name=\"";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\" id=\"";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\">\n";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\n\t\t\t<!--Added Against KDAH-CRF-0352 US4 Starts Here-->\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td colSpan=\"3\">Total</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\n\t\t\t\t\t<td><input type=\"text\" size=20 name=\"Kcalo_Total";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\" id=\"Kcalo_Total";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\"  style=\"background:transparent;border=0\" readonly=\"true\" class=\"label\" value=\'";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\'/>&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\n\t\t\t\t<!--Added Against KDAH-CRF-0352 US4 Ends Here-->\t\t\t\t\t\t\t\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td align=\"right\" colspan=\"3\" class=\"label\" >\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t// AAKH-CRF-0065 Sp2Us2Us3 start\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\' != \'";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\'){\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t$(\"#serveChkUnchkAll\"+\'";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\').prop(\"checked\", false);\n\t\t\t\t\t\t\t}\t\n\t\t\t\t\t\t\t// AAKH-CRF-0065 Sp2Us2Us3 end\n\t\t\t\t\t\t\tgt=parseInt(gt)+parseInt(subtotal);\n\t\t\t\t\t\t\tvar uom;\n\t\t\t\t\t\t\tdocument.getElementById(\"subtotal";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\").value=subtotal;\n\t\t\t\t\t\t\t//Commented Against ICN-#65555 0352\n\t\t\t\t\t\t\t/*if(document.getElementById(\"energy\") != null && document.getElementById(\"energy\") != \"\") {\n\t\t\t\t\t\t\t\tuom = document.getElementById(\"energy\").value;\n\t\t\t\t\t\t\t}*/\n\t\t\t\t\t\t\t\n\t\t\t\t\t//Added Against ICN-#65555 0352 starts Here\n\t\t\t\t\tif(document.getElementById(\"energyUomDesc\") != null && document.getElementById(\"energyUomDesc\") != \"\"){\n\t\t\t\t\t\tuom=document.getElementById(\"energyUomDesc\").value;\n\t\t\t\t\t}\n\t\t\t\t\t//Added Against ICN-#65555 0352 Ends Here\n\n\t\t\t\t\t\t\t\tvar uomLower;\n\t\t\t\t\t\t\t\tif(uom != \"\" && uom != null)\n\t\t\t\t\t\t\t\t\t uomLower = uom.toLowerCase();\n\t\t\t\t\t\t\t\telse uomLower=\"\";\n\t\t\t\t\t\t\t\t\tdocument.getElementById(\"Uom";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\").value= uomLower;\n\t\t\t\t\t\t\t\tsubtotal=0;\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\t\t\t\t\t\n\t\t\t\t\t<!--Added against AMS-CRF-112 Starts Here-->\n\t\t\t\t\t<!-- KDAH-CRF-0352-Scroll Start -->\t\t\n\t\t\t\t\t</table>\n\t\t\t\t\t</div>\t\t\t\t\t\n\t\t\t\t\t<table border=\'1\' cellpadding=\'2\' cellspacing=\'0\' width=\'90%\' align=\'center\' bordercolor=\"#9999FF\">\n\t\t\t\t\t<!-- KDAH-CRF-0352-Scroll End -->\t\t\n\t\t\t\t\t<tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\t\t\t\t\t\t\n\t\t\t\t\t\t<input type=\'hidden\' id=\"DBAdditionalInstruction";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\" name=\"DBAdditionalInstruction";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\"><!--Added against AMS-CRF-112 Ends Here-->\t\n\t\t\t\t\t\t\n\t\t\t\t\t   <input type=\'hidden\' id=\"AdditionalInstruction";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\" name=\"AdditionalInstruction";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\"><!--Modified Against ICN-64406 -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\t\t\t\t\t\n\t\t\t\t\t\t<input type=\'hidden\' id=\"DBAdditionalInstruction";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\n\t\t\t\t\t<td align=\"left\">\t\t\t\t\t\t\t\n\t\t\t\t\t\t<a href=\"javascript:callBlank()\" onclick=\"return openDialogWindow1(lblAdditionalInstruction,document.forms[0].AdditionalInstruction";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 =",document.forms[0].DBAdditionalInstruction";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 =",\'150\')\" OnMouseOver=\"Tip(additionalInstructionToolTip(document.forms[0].AdditionalInstruction";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="),JUMPHORZ,true)\"  onmouseout=\"UnTip()\"> + ";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 =" <!--Modified Against ICN-64406 -->\n\t\t\t\t\t\t</a>\t\t\t\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\n\t\t\t\t<!-- Added Against CRF-0112 Ends Here-->\n\t\t\t\t\t<td align=\"right\" colspan=\"3\">\n\t\t\t\t\t\t<a href=\"javascript:callBlank()\" onclick=\"return AddItem(\'";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\');\"> + ";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 =" </a>\n\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\n\t\t\t\t\t</tr>\t\t\t\t\t\n\t\t\t\t</table>\n\t\t\t\t</div>\n\t\t\t\t<table>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td> &nbsp; </td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\n\t\t\t\t\t\t</div>\n";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\n\t\t<input type=\"hidden\" name=\"mealTypelen\" id=\"mealTypelen\" value=\"";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\"/>\n\t\t<input type=\"hidden\" name=\"textlen\" id=\"textlen\" value=\"";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\" />\n\n\t\t<table border=\'1\' cellpadding=\'2\' cellspacing=\'0\' width=\'90%\' align=\'center\' bordercolor=\"#9999FF\" style=\"overflow-x:scroll;\"><tr><!-- KDAH-CRF-0352-Scroll -->\n\t\t<tbody id=\"dispGTClorie\" align=\"center\" BORDER = 1 style=\"overflow:auto;\" class=\"label\"></tbody>\n\t\t<td>\n\t\t<script>\n\t\t\tvar cal1;\n\t\t\tvar uom;\n\t\t\t//Commented Against ICN-#65555 0352 starts Here\n\t\t\t/*if(document.getElementById(\"energy\") != null && document.getElementById(\"energy\") != \"\"){\n\t\t\t\tcal1=document.getElementById(\"energy\").value;\n\t\t\t}*/\n\t\t\t//Commented Against ICN-#65555 0352 Ends Here\n\t\t\t\n\t\t\t//Added Against ICN-#65555 0352 starts Here\n\t\tif(document.getElementById(\"energyUomDesc\") != null && document.getElementById(\"energyUomDesc\") != \"\"){\n\t\t\tcal1=document.getElementById(\"energyUomDesc\").value;\n\t\t}\n\t\t//Added Against ICN-#65555 0352 Ends Here\n\n\t\t\tvar cal;\n\t\t\tif(cal1 != \"\" && cal1 != null)\n\t\t\t\tcal=cal1.toLowerCase();\n\t\t\telse\n\t\t\t\tcal = \"\";\n\n\t\t\tvar tbodyObj = document.all(\"dispGTClorie\");\n\t\t\tif(tbodyObj.rows.length>=1)\n\t\t\t\ttbodyObj.deleteRow(0);\n\t\t\tvar newRow1 = tbodyObj.insertRow(0);\n\t\t\tvar labelCel = newRow1.insertCell(newRow1.cells.length);\n\n\t\t\tlabelCel.className = \"lable\";\n\t\t\tlabelCel.style.fontWeight = \"700\";\n\t\t\tlabelCel.style.fontSize =\"8pt\";\n\t\t\tlabelCel.style.color =\"#2B1B17\";\n\t\t\tlabelCel.setAttribute(\"border\", \"0px\");\n\t\t\tlabelCel.align = \"left\";\n\t\t\tlabelCel.colSpan = \"9\";\n\n\t\t\tvar label=getLabel(\"eOT.CalorieGrandTotal.Label\",\"OT\");\n\t\t\t//Commented Against ICN-#65555 0352\n\t\t/*if(document.getElementById(\"energy\") != null && document.getElementById(\"energy\") != \"\"){\n\t\t\tuom=document.getElementById(\"energy\").value;\n\t\t}*/\n\t\t//Added Against ICN-#65555 0352 starts Here\n\t\tif(document.getElementById(\"energyUomDesc\") != null && document.getElementById(\"energyUomDesc\") != \"\"){\n\t\t\tuom=document.getElementById(\"energyUomDesc\").value;\n\t\t}\n\t\t//Added Against ICN-#65555 0352 Ends Here\n\t\tvar uomLowr;\n\t\tif(uom != \"\" && uom != null)\n\t\t\tuomLowr = uom.toLowerCase();\n\t\telse\n\t\t\tuomLowr = \"\";\n\t\tlabelCel.appendChild(document.createTextNode(label+\" :\" +gt+\" \"+uomLowr));\n\t\t\t</script>\n\t\t\t</td></tr></table>\n\t\t\t<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'90%\' align=\'center\' id=\"listContentTable\" style=\"overflow-x:scroll;\"><!-- KDAH-CRF-0352-Scroll -->\n\t\t\t<tr>\n\t\t\t\t<td align=\"right\">\n\t\t\t\t\t\n\t\t\t\t\t<!-- input type=\"button\" name=\"update\" value=\"Ok\" class=\"Button\" onclick=\"return updateAllFields();\" /--> <!-- Commented Against KDAH-CRF-0349.1[IN062717]US1 -->\n\t\t\t\t\t<input type=\"button\" name=\"update\" id=\"update\" value=\"Update for Current Date\" class=\"Button\" onclick=\"return updateAllFields();\" /> <!-- Added Against KDAH-CRF-0349.1[IN062717]US1 -->\n\t\t\t\t\t<input type=\"button\" name=\"updateAll\" id=\"updateAll\" value=\"Update for All\" class=\"Button\" onclick=\"return updateAllFieldsAll();\" /> <!-- Added Against KDAH-CRF-0349.1[IN062717]US2 -->\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t<input type=\"hidden\" name=\"foodItemCode\" id=\"foodItemCode\" value=\"\"/>\n\t\t<input type=\"hidden\" name=\"itemType\" id=\"itemType\" value=\"\"/>\n\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\"/>\n\t\t<input type=\"hidden\" name=\"insertMethod\" id=\"insertMethod\" value=\"";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\" />\n\n\t\t<br />\n\t\t\t<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'90%\' align=\'center\' id=\"addItem\" class=\"webglobeBoxBorder\" style=\"overflow-x:scroll;\"><!-- KDAH-CRF-0352-Scroll -->\n\t\t\t<tr>\n\t\t\t\t<th colspan=\"1\" align=\"right\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\n\t\t\t\t</th>\n\t\t\t\t<Th id=\"getName\" colspan=\"3\" align=\"left\"></Th>\n\t\t\t</tr>\n\t\t\t<tr align=\"center\">\n\t\t\t<!-- KDAH-CRF-0349-US004 Starts -->\n\t\t\t<td align=\"right\" class=\"label\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\n\t\t\t</td>\n\t\t\t<td>\n\t\t\t<select name=\"additemType\" id=\"additemType\" id=\"additemType\" >\n\t\t\t\t<option value=\"\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\n\t\t\t\t</option>\n\t\t\t";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\n\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\n\t\t\t\t\t</option>\n\t\t\t";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\n\t\t\t\t</select>\t\t\t\t\n\t\t\t\t</td>\n\t\t\t<!-- KDAH-CRF-0349-US004 Ends -->\n\t\t\t\t<td class=\"label\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\n\t\t\t\t</td>\t\t\t\t\n\t\t\t\t<td colspan=\"1\">\n\t\t\t\t\t<input type=\"text\" name=\"foodDesc\" id=\"foodDesc\" id=\"ItemS\" maxlength=\"8\" size=\"8\" onblur=\"getFoodLookup_mealMenuItems(this);\" value=\"\"/>\n\t\t\t\t\t<input type=\"button\" name=\"click\" id=\"click\" value=\"?\" onClick=\'showLookup_mealMenuItems(document.getElementById(\"foodDesc\"));\' class=\"button\"/>\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t<td class=\"label\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\n\t\t\t\t</td>\n\t\t\t\t<td>\n\t\t\t\t\t<INPUT type=\"text\" name=\"Qty\" id=\"Qty\"  onkeydown=\"return chkifPositive(event,this);\" size=\"6\"> <!-- IN::41066 -->\t\t\t\n\t\t\t\t</td>\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td colspan=\"3\" align=\"right\">\n\t\t\t\t\t<input type=\"button\" name=\"ADD\" id=\"ADD\" value=\"";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\" onclick=\"return addNewItem();\" class=\"Button\">\n\t\t\t\t</td>\n\t\t\t\t<td colspan=\"1\" align=\"right\" id=\"hiddn\">\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t  \n          \t<input type=\"hidden\" name=\"encounterId\" id=\"encounterId\"  value=\'";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\' />\n\t\t\t<input type=\"hidden\" name=\"patientId\" id=\"patientId\" value=\'";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\'/>\n\t\t\t<input type=\"hidden\" name=\"patientClass\" id=\"patientClass\" value=\'";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\'/>\n\t\t\t<input type=\"hidden\" name=\"mealClass\" id=\"mealClass\" value=\'";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\'/>\n\t\t\t<input type=\"hidden\" name=\"to\" id=\"to\" />\n\t\t\t<input type=\"hidden\" name=\"from\" id=\"from\" />\n\t\t\t<input type=\"hidden\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"language_Id\" id=\"language_Id\" value=\"";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"toPattern\" id=\"toPattern\" value=\"dd/MM/yyyy\" />\n\t\t\t<input type=\"hidden\" name=\"fromPattern\" id=\"fromPattern\" value=\"dd/MM/yyyy\" />\n\t\t\t<input type=\"hidden\" name=\"profileSL\" id=\"profileSL\" value=\'";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\'/>\n\t\t\t<input type=\"hidden\" name=\"dietTypesForMeals\" id=\"dietTypesForMeals\" value=\"";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\" />\n\t\t\t<input type=\"hidden\" name=\"dateFrom\" id=\"dateFrom\" value=\"";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"dateFromPattern\" id=\"dateFromPattern\" value=\"dd/MM/yyyy\" />\n\t\t\t<input type=\"hidden\" name=\"dateTo\" id=\"dateTo\" value=\"";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"dateTo.pattern\" id=\"dateTo.pattern\" value=\"dd/MM/yyyy\" />\n\t\t\t<input type=\"hidden\" name=\"cycleDayRef\" id=\"cycleDayRef\" value=\"\" />\n\t\t\t<input type=\"hidden\" name=\"mealTypesforDietTypes\" id=\"mealTypesforDietTypes\" value=\"";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"kitchenCode\" id=\"kitchenCode\" />\n\t\t\t<INPUT type=\"hidden\" name=\"servingUomCode\" id=\"servingUomCode\">\n\t\t\t<input type=\"hidden\" name=\"addedFacilityId\" id=\"addedFacilityId\" />\n\t\t\t<input type=\"hidden\" name=\"itemCal\" id=\"itemCal\" />\n\t\t\t<input type=\"hidden\" name=\"subTotalItemCal\" id=\"subTotalItemCal\" />\n\t\t\t<input type=\"hidden\" name=\"totalItemCal\" id=\"totalItemCal\" />\n\t\t\t<input type=\"hidden\" name=\"foodType\" id=\"foodType\" />\n\t\t\t<input type=\"hidden\" name=\"isMealMenuDisplay\" id=\"isMealMenuDisplay\" value=\"";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\" />\n\t\t\t<!--ML-MMOH-CRF-0427-->\n\t\t\t<input type=\"hidden\" name=\"profileFlag\" id=\"profileFlag\" id=\"profileFlag\" value=\"";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\" />\n\t\t\t<input type=\"hidden\" name=\"restrict_date_inpatients_yn\" id=\"restrict_date_inpatients_yn\" id=\"restrict_date_inpatients_yn\" value=\"";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\" />\n\t\t\t<input type=\"hidden\" name=\"maximum_days_allowed\" id=\"maximum_days_allowed\" id=\"maximum_days_allowed\" value=\"";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\" />\n\t\t\t<input type=\"hidden\" name=\"allValue\" id=\"allValue\" id=\"allValue\" value=\"\" /> <!-- Added Against  KDAH-CRF-0349.1 [IN062717]US2 -->\n\t\t\t<!-- MMS-KH-CRF-0029.1-US008 -->\n\t\t\t<input type=\"hidden\" name=\"enableDrugYN\" id=\"enableDrugYN\" id=\"enableDrugYN\" value=\"";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\"/>\n\t\t\t<!--ML-MMOH-CRF-0427-->\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t</form>\n\t<script>\n\t\tvar count = \'";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\';\n\t\tfunction AddItem(val)\n\t\t{\n\t\t\t// 055388 Start\n\t\t\tif(val != \'-\')\n\t\t\t\tdocument.getElementById(\"getName\").innerText=val;\n\t\t\telse\n\t\t\t\talert(\"No Meal types are available\");\n\t\t\t// 055388 End\n\t\t}\n\t</script>\n</body> \n\n";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );
 
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
            _bw.write(_wl_block7Bytes, _wl_block7);
  //Added Against MMS Vulnerability Issue - Starts
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
    //Added Against MMS Vulnerability Issue - Ends
	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
	if(sStyle==null)
		sStyle="IeStyle.css";
	String itemsArray=request.getParameter("MealItemsArray");
	String dateFrom=request.getParameter("dateFrom");
	String dateTo=request.getParameter("dateTo");
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id	= (String)session.getAttribute("facility_id");
	String dayRefNo = request.getParameter("dayRef");
	String menuDate = request.getParameter("dateForMeanu");
	String dietTypes = request.getParameter("dietTypesForMeals");
	String mealTypes = request.getParameter("mealTypesforDietTypes");
	String prlSl =request.getParameter("profileSL");
	String kCode =request.getParameter("kitchenCode");
	String eID = request.getParameter("encounterId");
	String dType = request.getParameter("dietType");
	String mClass=request.getParameter("mealClass");
	String patientClass = request.getParameter("patientClass");
	//ML-MMOH-CRF-0427 US3 starts
	String restrict_date_inpatients_yn=checkForNull(request.getParameter("restrict_date_inpatients_yn"));
	String maximum_days_allowed=checkForNull(request.getParameter("maximum_days_allowed"));
	boolean profileFlag=Boolean.valueOf(request.getParameter("profileFlag"));
	//ML-MMOH-CRF-0427 US3 ends
	String params = request.getQueryString();
	String enableDrugYN="";//MMS-KH-CRF-0029.1-US008

	boolean isAdditionalInstructions = false;//Added Against AMS-CRF-112
	boolean isMealMenuDisplay = false;//Added Against KDAH-CRF-0352-US6	

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(itemsArray));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(params));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(menuDate));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(mClass));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(dType));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(mClass));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(dType));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block18Bytes, _wl_block18);

								if(restrict_date_inpatients_yn.equals("Y") && profileFlag){
							
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(maximum_days_allowed));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block21Bytes, _wl_block21);
	
							}else{
							
            _bw.write(_wl_block22Bytes, _wl_block22);
	
							}
						
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(dayRefNo));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(dayRefNo));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(dayRefNo));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dietTypes));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(mealTypes));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(prlSl));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(eID));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(dType));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(mClass));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patientClass));
            _bw.write(_wl_block30Bytes, _wl_block30);

						String dietTypeStr="",menuCode="",mealTypeStr="",kitchenCode="",mealClass="",dayRef="",encounterId="",dateForMenu="",profileSL="",item_Type="",item_Code="",itemShortDesc="",item_Qty="",meal_Type="",meal_Type1="",mealTypeShortDesc="",serving_Uom_Code="",calorific_Cont_Per_Uom="",itemSL="",energy_Uom="",reviewType="",reviewSLNo="",AdditionalInstruction="",DBAdditionalInstruction="",additionalInstrDate="",serving_Uom_Desc="",energy_Uom_Desc="",NutrientDesc_temp="",NutrientUomQty="",dsNutrientValues="";//Modified against Ams-CRf-0112,KDAH-CRF-0352, and ICN-#65555 and IN:067604
						ArrayList<String> mealList = new ArrayList<String>();
						Connection connection   = null ;
						PreparedStatement pstmt = null ;
						ResultSet resultSet = null ,rs = null,rs1=null,rs2=null ;
						int counter=0,i=0,k=0;
						int chkUnchkCnt = 0, chkedCnt = 0, menuItemsCnt = 0;
						String menuCodeVal = "";//054259

						try
						{

							String bean_id = "UpdateMealMenuObject";
							String bean_name = "eDS.UpdateMealMenuObject";
							UpdateMealMenuObject bean = (UpdateMealMenuObject)mh.getBeanObject( bean_id, request, bean_name );
							LinkedHashMap updateMealsDetailsMap = (LinkedHashMap)session.getAttribute("ALLMENUITEMSMAP");	
							UpdateMealMenuObject updateMealMenuObject = null;
							LinkedHashMap allMenuItems = new LinkedHashMap();
							ArrayList allMenuItemsList = new ArrayList();
							ArrayList menuItemsList = new ArrayList();
							ArrayList reviewedMenuItemsList = new ArrayList();

							dietTypeStr=request.getParameter("dietTypesForMeals");
							//System.err.println("159,dietTypeStr==="+dietTypeStr);
							mealTypeStr=request.getParameter("mealTypesforDietTypes");
							//System.err.println("161,mealTypeStr==="+mealTypeStr);
							kitchenCode=request.getParameter("kitchenCode");
							mealClass=request.getParameter("mealClass");
							dayRef=request.getParameter("dayRef");
							encounterId=request.getParameter("encounterId");
							dateForMenu=request.getParameter("dateForMeanu");
							profileSL=request.getParameter("profileSL");
							//System.err.println("168,profileSL==="+profileSL);
							String mealTypeDesc = "";//054259
							String[] dietType = dietTypeStr.split(",");
							String[] mealType = mealTypeStr.split(",");
							//System.err.println("170,dietType==="+dietType.length);
							//System.err.println("171,mealType==="+mealType.length);
							connection = ConnectionManager.getConnection(request);
							String dietTypeSql="select meal_type,short_desc from ds_meal_type";
							pstmt=connection.prepareStatement(dietTypeSql);
							rs2 = pstmt.executeQuery();
							HashMap dietTypeMap=new HashMap();
							while(rs2 != null && rs2.next())
								dietTypeMap.put(rs2.getString(1), rs2.getString(2));							
		                        	isAdditionalInstructions = CommonBean.isSiteSpecific(connection,"DS","PLACE_DIET_ORDER_INSTR");//Added against Ams-CRf-0112									
							

            _bw.write(_wl_block31Bytes, _wl_block31);

							for(i=0; i < dietType.length; i++)
							{
								String menuCodesql="select menu.SHORT_DESC , menu.MENU_CODE from DS_DIET_MENU_TIME_TABLE menuTimeTable, DS_MEAL_TYPE mealType, DS_MENU menu where menuTimeTable.MEAL_TYPE=mealType.MEAL_TYPE and menuTimeTable.MENU_CODE=menu.MENU_CODE and ((menuTimeTable.OPERATING_FACILITY_ID='"+facility_id+"' )and(menuTimeTable.KITCHEN_CODE='"+kitchenCode+"' )and(menuTimeTable.DIET_TYPE='"+dietType[i]+"' )and(menuTimeTable.MEAL_TYPE='"+mealType[i].trim()+"' )and(menuTimeTable.MEAL_CLASS='"+mealClass+"' )and(menuTimeTable.DAY_NO='"+Integer.parseInt(dayRef)+"' )) and menu.EFF_STATUS ='E'  order by  mealType.MEAL_ORDER , 2 , 1";	//Added EFF_STATUS Against AMS-SCF-0835 and Added EFF_STATUS in ds_menu against ML-MMOH-SCF-1881
								pstmt = connection.prepareStatement(menuCodesql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
								//System.err.println("185,menuCodesql==="+menuCodesql);
								resultSet = pstmt.executeQuery();
								//054259
								if(mealType[i] != null && mealType[i].trim().length() > 0)
									mealTypeDesc = dietTypeMap.get((mealType[i]).trim()).toString();
									
								//System.err.println("191,mealTypeDesc==="+mealTypeDesc);	
								//System.err.println("194,mealType[i]==="+mealType[i]);	
								//054259
								mealList.clear();
								while(resultSet != null && resultSet.next())
								{
									menuCode = resultSet.getString(2);
									mealList.add(menuCode);
								}

//Added Against KDAH-CRF-0352 US4 & US6 starts Here
isMealMenuDisplay = CommonBean.isSiteSpecific(connection,"DS","DS_MEAL_MENU_ITEMS");
//System.err.println("205, isMealMenuDisplay===>"+isMealMenuDisplay);
//KDAH-CRF-0352-Scroll Starts here
if(isMealMenuDisplay){

            _bw.write(_wl_block32Bytes, _wl_block32);
}else{
            _bw.write(_wl_block2Bytes, _wl_block2);
}
            _bw.write(_wl_block2Bytes, _wl_block2);

// KDAH-CRF-0352-Scroll Ends here
		LinkedHashMap allMenuItemsnew = new LinkedHashMap();
		ArrayList allMenuItemsListnew = new ArrayList();									
		ArrayList menuItemsListnew = new ArrayList();
		ArrayList reviewedMenuItemsListnew = new ArrayList();
		String fooditemcodetemp ="''";								
		if(mealList != null)
		{
		for(int j=0; j<mealList.size(); j++)
		{
		if(updateMealsDetailsMap == null)
			{												
				UpdateMealMenuObject updateMealMenuObjectnew = new UpdateMealMenuObject();
				updateMealMenuObjectnew.setMealList(mealList.get(j));
				updateMealMenuObjectnew.setLocale(locale);
				updateMealMenuObjectnew.setFacilityId(facility_id);
				updateMealMenuObjectnew.setKitchenCode(kitchenCode);
				updateMealMenuObjectnew.setDietType(dietType[i]);
				updateMealMenuObjectnew.setMealClass(mealClass);
				updateMealMenuObjectnew.setDayRef(dayRef);
				updateMealMenuObjectnew.setMealType(mealType[i].trim());
				updateMealMenuObjectnew.setEncounterId(encounterId);
				updateMealMenuObjectnew.setProfileSL(profileSL);
				updateMealMenuObjectnew.setDateforMenu(dateForMenu);											
				allMenuItemsnew = bean.getAllMenuItems(updateMealMenuObjectnew);
				menuItemsListnew = (ArrayList)allMenuItemsnew.get("MENUITEMS");
				reviewedMenuItemsListnew = (ArrayList)allMenuItemsnew.get("REVIEWEDMENUITEMS");
			}	
			else
			{
				allMenuItemsListnew = (ArrayList)(((LinkedHashMap)updateMealsDetailsMap.get("MEALTYPEMENUITEMSLISTMAP")).get(mealType[i].toString()));												
				if(allMenuItemsListnew != null)
				{
					menuItemsListnew = (ArrayList)allMenuItemsListnew.get(0);
					reviewedMenuItemsListnew = (ArrayList)allMenuItemsListnew.get(1);
				}
				else
				{
					menuItemsListnew = new ArrayList();
					reviewedMenuItemsListnew = new ArrayList();
				}
			}											
										//Modified Against 	ICN-#65555 0352							
			if(menuItemsListnew != null)
				{												
					for(int z=0; z<menuItemsListnew.size(); z++)
						{ 
						/* Setup related items for Assign DietType - Eg-Breakfast (Carrot,Idly, Milk) */
						updateMealMenuObject = (UpdateMealMenuObject)menuItemsListnew.get(z);
										if(mealType[i].trim().equalsIgnoreCase(updateMealMenuObject.getMealType()))
											{
												if(z==0)
												fooditemcodetemp="'"+updateMealMenuObject.getItemCode()+"'";
												else
												fooditemcodetemp+=",'"+updateMealMenuObject.getItemCode()+"'";
												}
												}
										}				
										//Modified Against 	ICN-#65555 0352
									/* Newly Added items for Assign DietType - Eg-Breakfast (Dosai) */	
											if(reviewedMenuItemsListnew != null)
										  {
												for(int z=0; z<reviewedMenuItemsListnew.size(); z++)
												{
													updateMealMenuObject = (UpdateMealMenuObject)reviewedMenuItemsListnew.get(z);
										if(mealType[i].trim().equalsIgnoreCase(updateMealMenuObject.getMealType()))
												{
														  if(z==0)
															fooditemcodetemp+=","+"'"+updateMealMenuObject.getItemCode()+"'";
															else
															fooditemcodetemp+=",'"+updateMealMenuObject.getItemCode()+"'";
															
															}
												}																
										}
						
								
								}	
							}	
			String nutrient_desc="",nutrient_code="";
		//Commented against ICN-#65555 0352							
		//	String ItemDescsql="SELECT DISTINCT nutrient_code, ds_get_desc.ds_nutrients (nutrient_code, ?, '2') nutrient_desc, SUM(CONTENT_VALUE) totkcal,am_get_desc.am_uom (b.uom_code, ?, '2') serving_uom_desc FROM ds_food_item_nutrients a, ds_nutrients b WHERE a.food_item_code IN ("+fooditemcodetemp+") AND b.nutrients_code = a.nutrient_code GROUP BY nutrient_code, uom_code";
		//Modified against ICN-#65555 0352
		String ItemDescsql="SELECT  nutrient_code, nutrient_desc, sum(totkcal) totkcal,serving_uom_desc FROM(SELECT c.item_code, c.item_qty, a.nutrient_code, a.food_item_code,b.short_desc nutrient_desc, c.item_qty * a.content_value totkcal,am_get_desc.am_uom (b.uom_code, ?, '2') serving_uom_desc  FROM ds_menu_item c, ds_food_item_nutrients a, ds_nutrients b WHERE c.item_code IN ("+fooditemcodetemp+") AND a.food_item_code = c.item_code  AND b.nutrients_code = a.nutrient_code   AND menu_code = ? AND item_code NOT IN (SELECT item_code FROM ds_epsd_diet_prof_dtl_reviewed dtlreviewed WHERE dtlreviewed.operating_facility_id = ? AND (dtlreviewed.encounter_id = ?)           AND (dtlreviewed.profile_sl = ?) AND dtlreviewed.MEAL_TYPE = ? AND (   (    (dtlreviewed.serving_date IS NOT NULL) AND (TO_CHAR (dtlreviewed.serving_date, 'dd/mm/yyyy') = ?)) OR ((    (dtlreviewed.serving_date IS NULL) AND (dtlreviewed.cycle_day_ref = '"+Integer.parseInt(dayRef)+"'))))) UNION ALL SELECT dtlreviewed.item_code, dtlreviewed.item_qty,a.nutrient_code, a.food_item_code, b.short_desc nutrient_desc,       case when dtlreviewed.review_type = 'M' THEN 0 else dtlreviewed.item_qty * a.content_value END totkcal,am_get_desc.am_uom (b.uom_code, ?, '2') serving_uom_desc FROM ds_epsd_diet_prof_dtl_reviewed dtlreviewed,ds_food_item_nutrients a,ds_nutrients b WHERE dtlreviewed.operating_facility_id = ? AND (dtlreviewed.encounter_id = ?) AND (dtlreviewed.profile_sl = ?)  AND dtlreviewed.item_code IN ("+fooditemcodetemp+") AND a.food_item_code = dtlreviewed.item_code AND b.nutrients_code = a.nutrient_code AND dtlreviewed.MEAL_TYPE =? AND (   (    (dtlreviewed.serving_date IS NOT NULL) AND (TO_CHAR (dtlreviewed.serving_date, 'dd/mm/yyyy') = ?)) OR ((    (dtlreviewed.serving_date IS NULL) AND (dtlreviewed.cycle_day_ref = '"+Integer.parseInt(dayRef)+"') ))) ) Group by  nutrient_code, nutrient_desc, serving_uom_desc ";	
		//System.err.println("mealMenuItems.jsp,ItemDescsql========="+ItemDescsql);
			pstmt = connection.prepareStatement(ItemDescsql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE); 
			//Modified against ICN-#65555 0352
				pstmt.setString(1,locale);
				pstmt.setString(2,menuCode);
				pstmt.setString(3,facility_id);								
				pstmt.setString(4,encounterId);	
				pstmt.setString(5,profileSL);
				pstmt.setString(6,mealType[i].trim());
				pstmt.setString(7,dateForMenu);
				pstmt.setString(8,locale);
				pstmt.setString(9,facility_id);
				pstmt.setString(10,encounterId);
				pstmt.setString(11,profileSL);
				pstmt.setString(12,mealType[i].trim());
				pstmt.setString(13,dateForMenu);
				resultSet = pstmt.executeQuery();
				
				//Added Against KDAH-CRF-0352 US4 Ends Here

            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(mealType[i].trim()));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(mealTypeDesc.trim()));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(mealType[i].trim()));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(mealTypeDesc.trim()));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

		int count_nutrients=0;
		int rows_count =0;
		if (resultSet.last()) {
				rows_count = resultSet.getRow();			
				resultSet.beforeFirst();
			}
		String Kcalo_Total[]=new String[rows_count];
		String NutrientDesc[]=new String[rows_count];
		while(resultSet != null && resultSet.next())
		{
			nutrient_code= resultSet.getString(1);				
			nutrient_desc = resultSet.getString(2);	
			NutrientDesc[count_nutrients]=nutrient_desc;
			Kcalo_Total[count_nutrients]=resultSet.getString(3)+" "+resultSet.getString(4);
			count_nutrients++;

            _bw.write(_wl_block2Bytes, _wl_block2);

//System.err.println("374, isMealMenuDisplay===>"+isMealMenuDisplay);
if(isMealMenuDisplay){//KDAH-CRF-0352-US6

            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(nutrient_desc));
            _bw.write(_wl_block50Bytes, _wl_block50);
	
	}

            _bw.write(_wl_block2Bytes, _wl_block2);

	}
	//String ServingUomQty[]=new String[count_nutrients];

            _bw.write(_wl_block51Bytes, _wl_block51);

if(mealList != null)
{
for(int j=0; j<mealList.size(); j++)
{
	chkUnchkCnt = 0;
	menuItemsCnt = 0;
	chkedCnt = 0;
	menuCodeVal = mealList.get(j);//054259
	if(updateMealsDetailsMap == null)
	{
		updateMealMenuObject = new UpdateMealMenuObject();
		updateMealMenuObject.setMealList(mealList.get(j));
		updateMealMenuObject.setLocale(locale);
		updateMealMenuObject.setFacilityId(facility_id);
		updateMealMenuObject.setKitchenCode(kitchenCode);
		updateMealMenuObject.setDietType(dietType[i]);
		updateMealMenuObject.setMealClass(mealClass);
		updateMealMenuObject.setDayRef(dayRef);
		updateMealMenuObject.setMealType(mealType[i].trim());
		updateMealMenuObject.setEncounterId(encounterId);
		updateMealMenuObject.setProfileSL(profileSL);
		updateMealMenuObject.setDateforMenu(dateForMenu);
		allMenuItems = bean.getAllMenuItems(updateMealMenuObject);
		menuItemsList = (ArrayList)allMenuItems.get("MENUITEMS");
		reviewedMenuItemsList = (ArrayList)allMenuItems.get("REVIEWEDMENUITEMS");

            _bw.write(_wl_block3Bytes, _wl_block3);

if(isMealMenuDisplay){//KDAH-CRF-0352-US6

            _bw.write(_wl_block52Bytes, _wl_block52);
updateMealMenuObject.setMealList(mealList.get(j));
            _bw.write(_wl_block53Bytes, _wl_block53);

}

            _bw.write(_wl_block3Bytes, _wl_block3);
	
		}
		else
		{
			allMenuItemsList = (ArrayList)(((LinkedHashMap)updateMealsDetailsMap.get("MEALTYPEMENUITEMSLISTMAP")).get(mealType[i].toString()));												
			if(allMenuItemsList != null)
			{
				menuItemsList = (ArrayList)allMenuItemsList.get(0);
				reviewedMenuItemsList = (ArrayList)allMenuItemsList.get(1);
			}//054259
			else
			{
				menuItemsList = new ArrayList();
				reviewedMenuItemsList = new ArrayList();
			}
		}						
						
		if(menuItemsList != null)
		{
			chkedCnt = menuItemsList.size();
			for(int z=0; z<menuItemsList.size(); z++)
			{
				updateMealMenuObject = (UpdateMealMenuObject)menuItemsList.get(z);
				k = 0;
				itemSL = updateMealMenuObject.getItemSL();
				item_Type = updateMealMenuObject.getItemType();
				item_Code = updateMealMenuObject.getItemCode();
				//System.err.println("280,item_Code==="+item_Code);
				itemShortDesc = updateMealMenuObject.getItemShortDesc();
				item_Qty = updateMealMenuObject.getItemQty();
				//Added against AMS-CRF-0112 Starts here
				if(isAdditionalInstructions)
				{
					additionalInstrDate=checkForNull(updateMealMenuObject.getAdditionalInstrDate());
				if(additionalInstrDate.equals(menuDate))
					AdditionalInstruction=checkForNull(updateMealMenuObject.getAdditionalInstructions2(mealType[i].trim()));//Added against AMS-CRF-0112 	
				else													
					AdditionalInstruction="";
				}
				//Added against AMS-CRF-0112 Ends here
				meal_Type = updateMealMenuObject.getMealType();
				mealTypeShortDesc = updateMealMenuObject.getMealTypeShortDesc();
				//Added Against KDAH-CRF-0352 Starts Here
				serving_Uom_Code = updateMealMenuObject.getServingUomCode();
				serving_Uom_Desc=updateMealMenuObject.getServingUomDesc();
				//Added Against KDAH-CRF-0352 Ends Here
				if(updateMealMenuObject.getCalorificContPerUom() != null)//054259
					calorific_Cont_Per_Uom = updateMealMenuObject.getCalorificContPerUom();
				//Added Against KDAH-CRF-0352 starts Here
				energy_Uom = updateMealMenuObject.getEnergyUom();
				energy_Uom_Desc=updateMealMenuObject.getEnergyUomDesc();
				//Added Against KDAH-CRF-0352 Ends Here
				//Added Against KDAH-CRF-0352 starts Here and ICN-#65555
				NutrientDesc_temp = updateMealMenuObject.getNutrientDesc();
				NutrientUomQty=updateMealMenuObject.getServingUomQty();
				dsNutrientValues=checkForNull(updateMealMenuObject.getdsNutriValue()); //14 Added Against IN:067604 by SelvinM
				// Added Against IN:067604 Start by SelvinM
				if(dsNutrientValues.length()>0)
				{
				StringTokenizer tokenizer = new StringTokenizer(dsNutrientValues, "$$");        				
				while(tokenizer.hasMoreTokens()){						
					System.err.println("522,==="+tokenizer.nextToken());				
					NutrientDesc_temp = tokenizer.nextToken();
					NutrientUomQty = tokenizer.nextToken();
					}  					
				}
				// Added Against IN:067604 End by SelvinM
				//Added Against KDAH-CRF-0352 Ends Here and ICN-#65555
				reviewType = "F";											

            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(mealType[i].trim()));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(mealTypeDesc.trim()));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(mealType[i].trim()));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(mealTypeDesc.trim()));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            out.print( String.valueOf(menuItemsCnt));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(meal_Type));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(item_Code));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(meal_Type));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(item_Code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(itemShortDesc));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(meal_Type));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(item_Code));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(mealList.get(j)));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(itemShortDesc));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(dietType[i]));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(item_Type));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(serving_Uom_Code));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(serving_Uom_Desc));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(mealTypeDesc));
            _bw.write(_wl_block92Bytes, _wl_block92);
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(mealType[i].trim()));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(mealTypeDesc.trim()));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(Double.parseDouble(item_Qty)));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(serving_Uom_Desc));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(k));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(k));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(calorific_Cont_Per_Uom));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(energy_Uom));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(energy_Uom_Desc));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(NutrientDesc_temp));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(NutrientUomQty));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(energy_Uom_Desc));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(energy_Uom_Desc));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(Float.parseFloat(calorific_Cont_Per_Uom)));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(item_Qty));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(item_Qty));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(calorific_Cont_Per_Uom));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(k));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(Double.parseDouble(item_Qty)));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(Double.parseDouble(item_Qty)));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(mealType[i].trim()));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(mealTypeDesc.trim()));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(mealType[i].trim()));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(mealTypeDesc.trim()));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(item_Code));
            _bw.write(_wl_block126Bytes, _wl_block126);

	if(isMealMenuDisplay){//KDAH-CRF-0352-US6
				int m=0;														
				String NutrientDesctemp[]=new String[count_nutrients];
				String ServingUomQtytemp[]=new String[count_nutrients];
				HashMap<String,String> NutrientUOMQtyMap=new HashMap<String,String>();
				if(count_nutrients>0)
				{
				/* Added Against IN:067604 Start by SelvinM */
				//for(String Nutrient:checkForNull(updateMealMenuObject.getNutrientDesc()).split(","))
				for(String Nutrient:checkForNull(NutrientDesc_temp).split(","))
				/* Added Against IN:067604 End by SelvinM */
				{
					NutrientDesctemp[m]=Nutrient; //Eg-Fat,Vitamin (Carrot)
					m++;
				}
				m=0;
				/* Added Against IN:067604 Start by SelvinM */
				//for(String ServingUomQtytemp2:checkForNull(updateMealMenuObject.getServingUomQty()).split(","))
				for(String ServingUomQtytemp2:checkForNull(NutrientUomQty).split(","))
				/* Added Against IN:067604 End by SelvinM */
				{
					if(!ServingUomQtytemp2.equals("") && count_nutrients!=0 )
					{
						ServingUomQtytemp[m]=ServingUomQtytemp2; //Eg-5%, 7 Gram (Carrot)
						m++;
					}
				}
				m=0;
				for(;m<NutrientDesctemp.length;m++)
				{
					NutrientUOMQtyMap.put(NutrientDesctemp[m],ServingUomQtytemp[m]);
				}
				m=0;
				String ServingUomQtytempVal="";
				for(;m<count_nutrients;m++)
				{														
					ServingUomQtytempVal=checkForNull(NutrientUOMQtyMap.get(NutrientDesc[m]));//Fat,5% & protein,"" & vitamin,7gm
				
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(NutrientDesctemp.length));
            _bw.write(_wl_block129Bytes, _wl_block129);

				if(ServingUomQtytempVal.equalsIgnoreCase("")){
				
            _bw.write(_wl_block130Bytes, _wl_block130);

				}
				else{
				
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(counter));
            out.print( String.valueOf(m));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(counter));
            out.print( String.valueOf(m));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(counter));
            out.print( String.valueOf(m));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(ServingUomQtytempVal));
            _bw.write(_wl_block135Bytes, _wl_block135);

				}
				}														
				}
				else
				{
				
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block137Bytes, _wl_block137);

				}
	}//KDAH-CRF-0352-US6
				
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(reviewType));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(k));
            _bw.write(_wl_block140Bytes, _wl_block140);

						counter++;k++;
						menuItemsCnt++;
						chkUnchkCnt++;
					}
				}
				if(reviewedMenuItemsList != null)
				{
					for(int z=0; z<reviewedMenuItemsList.size(); z++)
					{
						updateMealMenuObject = (UpdateMealMenuObject)reviewedMenuItemsList.get(z);
						item_Type = updateMealMenuObject.getItemType();
						item_Code = updateMealMenuObject.getItemCode();
						itemShortDesc = updateMealMenuObject.getItemShortDesc();
						item_Qty = updateMealMenuObject.getItemQty();
						reviewType= updateMealMenuObject.getReviewType();
						meal_Type1 = updateMealMenuObject.getMealType();
						mealTypeShortDesc = updateMealMenuObject.getMealTypeShortDesc();
						//Added Against KDAH-CRF-0352 Starts here
						serving_Uom_Code = updateMealMenuObject.getServingUomCode();
						serving_Uom_Desc=updateMealMenuObject.getServingUomDesc();
						//Added Against KDAH-CRF-0352 Ends Here
						reviewSLNo= updateMealMenuObject.getReviewSLNo();
						if(updateMealMenuObject.getCalorificContPerUom() != null)
							calorific_Cont_Per_Uom = updateMealMenuObject.getCalorificContPerUom();
						//Modified Against KDAH-CRF-0352 starts Here
						energy_Uom = updateMealMenuObject.getEnergyUom();
						energy_Uom_Desc = updateMealMenuObject.getEnergyUomDesc();
						//Modified Against KDAH-CRF-0352 Ends Here
						//Added Against KDAH-CRF-0352 starts Here and ICN-#65555
						NutrientDesc_temp = updateMealMenuObject.getNutrientDesc(); //18
						NutrientUomQty=updateMealMenuObject.getServingUomQty(); //19
						/* Added Against IN:067604 Start by SelvinM */
						dsNutrientValues=checkForNull(updateMealMenuObject.getdsNutriValue()); //14 Added Against IN:067604 by SelvinM
						// Added Against IN:067604 Start by SelvinM
						if(dsNutrientValues.length()>0)
						{
						StringTokenizer tokenizer = new StringTokenizer(dsNutrientValues, "$$");        				
						while(tokenizer.hasMoreTokens()){						
							System.err.println("683,==="+tokenizer.nextToken());				
							NutrientDesc_temp = tokenizer.nextToken();
							NutrientUomQty = tokenizer.nextToken();
							}  					
						}
						// Added Against IN:067604 End by SelvinM
						//Added Against KDAH-CRF-0352 Ends Here and ICN-#65555
						//Added against AMS-CRF-0112 Starts here
						if(isAdditionalInstructions)
						{
							additionalInstrDate=checkForNull(updateMealMenuObject.getAdditionalInstrDate());
						if(additionalInstrDate.equals(menuDate))
							AdditionalInstruction=checkForNull(updateMealMenuObject.getAdditionalInstructions2(mealType[i].trim()));//Added against AMS-CRF-0112 
						else
							AdditionalInstruction="";													
						}
									
						if((mealType[i].trim()).equals(meal_Type1)) 
						{

            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(reviewType));
            _bw.write(_wl_block142Bytes, _wl_block142);

							if(!reviewType.equals("M")) 
							{
								chkUnchkCnt++;

            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(mealType[i].trim()));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(mealTypeDesc.trim()));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(mealType[i].trim()));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(mealTypeDesc.trim()));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(i));
            out.print( String.valueOf(menuItemsCnt));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            _bw.write(_wl_block2Bytes, _wl_block2);

							}
							else
							{

            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(mealType[i].trim()));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(mealTypeDesc.trim()));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(mealType[i].trim()));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(mealTypeDesc.trim()));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(i));
            out.print( String.valueOf(menuItemsCnt));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            _bw.write(_wl_block2Bytes, _wl_block2);

							}

            _bw.write(_wl_block146Bytes, _wl_block146);

						if(reviewType.equals("M"))
						{

            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(meal_Type1));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(item_Code));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(meal_Type1));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(item_Code));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(itemShortDesc));
            _bw.write(_wl_block150Bytes, _wl_block150);
 
						}
						else
						{

            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(meal_Type1));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(item_Code));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(meal_Type1));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(item_Code));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(itemShortDesc));
            _bw.write(_wl_block150Bytes, _wl_block150);

						}

            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(meal_Type1));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(item_Code));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(mealList.get(j)));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(itemShortDesc));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(dietType[i]));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(reviewSLNo));
            _bw.write(_wl_block142Bytes, _wl_block142);

						if(reviewSLNo == null)
						{

            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block160Bytes, _wl_block160);

						}
						else
						{

            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block162Bytes, _wl_block162);

						}

            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(reviewType));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(item_Type));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(serving_Uom_Code));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(serving_Uom_Desc));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(mealTypeDesc));
            _bw.write(_wl_block169Bytes, _wl_block169);
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(mealType[i].trim()));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(mealTypeDesc.trim()));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(k));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(Double.parseDouble(item_Qty)));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(serving_Uom_Desc));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(k));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(k));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(calorific_Cont_Per_Uom));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(energy_Uom));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(NutrientDesc_temp));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(NutrientUomQty));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(energy_Uom_Desc));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(energy_Uom_Desc));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(Float.parseFloat(calorific_Cont_Per_Uom)));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(item_Qty));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(item_Qty));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(calorific_Cont_Per_Uom));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(k));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(item_Qty));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(Double.parseDouble(item_Qty)));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(mealType[i].trim()));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(mealTypeDesc.trim()));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(mealType[i].trim()));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(mealTypeDesc.trim()));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(item_Code));
            _bw.write(_wl_block189Bytes, _wl_block189);
						
		if(isMealMenuDisplay){//KDAH-CRF-0352-US6		
			int m=0;														
			String NutrientDesctemp[]=new String[count_nutrients];
			String ServingUomQtytemp[]=new String[count_nutrients];
			HashMap<String,String> NutrientUOMQtyMap=new HashMap<String,String>();
			if(count_nutrients>0)
			{
			/* Added Against IN:067604 Start by SelvinM */
			//for(String Nutrient:checkForNull(updateMealMenuObject.getNutrientDesc()).split(","))
			for(String Nutrient:checkForNull(NutrientDesc_temp).split(","))
			/* Added Against IN:067604 End by SelvinM */
			{
				NutrientDesctemp[m]=Nutrient;
				m++;
			}
			m=0;
			/* Added Against IN:067604 Start by SelvinM */
			//for(String ServingUomQtytemp2:checkForNull(updateMealMenuObject.getServingUomQty()).split(","))
			for(String ServingUomQtytemp2:checkForNull(NutrientUomQty).split(","))
			/* Added Against IN:067604 End by SelvinM */
			{
				if(!ServingUomQtytemp2.equals("") && count_nutrients!=0 )
				{
					ServingUomQtytemp[m]=ServingUomQtytemp2;
					m++;
				}
			}
			m=0;
			for(;m<NutrientDesctemp.length;m++)
			{
				NutrientUOMQtyMap.put(NutrientDesctemp[m],ServingUomQtytemp[m]);
			}
			m=0;
			String ServingUomQtytempVal="";
			for(;m<count_nutrients;m++)
			{														
				ServingUomQtytempVal=checkForNull(NutrientUOMQtyMap.get(NutrientDesc[m]));
			
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(NutrientDesctemp.length));
            _bw.write(_wl_block190Bytes, _wl_block190);

			if(ServingUomQtytempVal.equalsIgnoreCase(""))
			
            _bw.write(_wl_block191Bytes, _wl_block191);

			else{
			
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(counter));
            out.print( String.valueOf(m));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(counter));
            out.print( String.valueOf(m));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(counter));
            out.print( String.valueOf(m));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(ServingUomQtytempVal));
            _bw.write(_wl_block194Bytes, _wl_block194);

			}
			}														
			}
			else
			{
			
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block196Bytes, _wl_block196);

			}
			}//KDAH-CRF-0352-US6
			
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(reviewType));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(k));
            _bw.write(_wl_block199Bytes, _wl_block199);
 
					counter++;k++;
					menuItemsCnt++;
					chkedCnt++;
					meal_Type = meal_Type1;
					}
				}
			}

            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(i));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(i));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(menuItemsCnt));
            _bw.write(_wl_block202Bytes, _wl_block202);
            _bw.write(_wl_block2Bytes, _wl_block2);

			}

            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(mealType[i].trim()));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(mealType[i].trim()));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(mealType[i].trim()));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(menuCodeVal));
            _bw.write(_wl_block205Bytes, _wl_block205);

			}

            _bw.write(_wl_block2Bytes, _wl_block2);

if(isMealMenuDisplay){//KDAH-CRF-0352-US6

            _bw.write(_wl_block206Bytes, _wl_block206);

					for(int m=0;m<count_nutrients;m++)
					{									
					
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(i));
            out.print( String.valueOf(m));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(i));
            out.print( String.valueOf(m));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(Kcalo_Total[m]));
            _bw.write(_wl_block210Bytes, _wl_block210);
}
            _bw.write(_wl_block211Bytes, _wl_block211);

}//KDAH-CRF-0352-US6

            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(chkedCnt));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(chkUnchkCnt));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(i));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(i));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(i));
            _bw.write(_wl_block217Bytes, _wl_block217);
 if(isAdditionalInstructions) 
						{
						
						String DBAdditionalInstructionsql="select MEAL_ADDT_INST  from DS_ADDT_INST_FOR_MEAL   where MEAL_TYPE='"+mealType[i].trim()+"' and  ENCOUNTER_ID='"+encounterId+"' and PROFILE_SL='"+profileSL+"' and (to_char(MENU_DATE , 'dd/mm/yyyy')='"+menuDate+"')  ";
						pstmt = connection.prepareStatement(DBAdditionalInstructionsql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
						resultSet = pstmt.executeQuery();		
									DBAdditionalInstruction="";								
						while(resultSet != null && resultSet.next())
							{
								DBAdditionalInstruction = checkForNull(resultSet.getString(1));						
							}
								
						if(AdditionalInstruction.equals("") || AdditionalInstruction.equals("null"))
						{
						
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(mealType[i].trim()));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(mealType[i].trim()));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(DBAdditionalInstruction));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(mealType[i].trim()));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(mealType[i].trim()));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(DBAdditionalInstruction));
            _bw.write(_wl_block222Bytes, _wl_block222);
}else {
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(mealType[i].trim()));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(mealType[i].trim()));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(DBAdditionalInstruction));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(mealType[i].trim()));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(mealType[i].trim()));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(AdditionalInstruction));
            _bw.write(_wl_block222Bytes, _wl_block222);
}
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(mealType[i].trim()));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(mealType[i].trim()));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(mealType[i].trim()));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(mealType[i].trim()));
            _bw.write(_wl_block227Bytes, _wl_block227);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block228Bytes, _wl_block228);
	}
					if(menuCode!=""){	//Added Against ML-MMOH-SCF-1881
					
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(mealType[i].trim()));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(mealTypeDesc.trim()));
            _bw.write(_wl_block230Bytes, _wl_block230);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block231Bytes, _wl_block231);
	}
					
            _bw.write(_wl_block232Bytes, _wl_block232);
								
			}
			//MMS-KH-CRF-0029.1-US008 Start
			String enableDrugFood="select ENABLE_DRUG_FOOD_YN from DS_PARAM_FOR_FACILITY where OPERATING_FACILITY_ID = '"+facility_id+"'";
			pstmt=connection.prepareStatement(enableDrugFood);						
			rs2=pstmt.executeQuery();
			while(rs2 != null && rs2.next()){
				enableDrugYN=checkForNull(rs2.getString("ENABLE_DRUG_FOOD_YN"));
			}
			if(rs2!=null) rs2.close();
			if(pstmt!=null) pstmt.close();
			//MMS-KH-CRF-0029.1-US008 Ends

            _bw.write(_wl_block233Bytes, _wl_block233);

					}
				catch(Exception e) 
				{
					e.printStackTrace();
					System.err.println("Exception in mealMenuItems.jsp=="+e);
				}
				finally{
					if(resultSet!=null) resultSet.close();
					if(rs!=null) rs.close();
					if(rs1!=null) rs1.close();
					if(rs2!=null) rs2.close();
					if(pstmt!=null) pstmt.close();
					if(connection!=null)
						ConnectionManager.returnConnection(connection,request);
				}

            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(i));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(new Integer(com.iba.ehis.core.util.AppConstants.CREATE).toString()));
            _bw.write(_wl_block237Bytes, _wl_block237);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block238Bytes, _wl_block238);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block239Bytes, _wl_block239);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block240Bytes, _wl_block240);

				try{
						String sql_meal ="SELECT DS_GET_DESC.DS_ITEM_TYPE(ITEM_TYPE,'"+locale+"','2'),ITEM_TYPE FROM DS_item_type WHERE NVL (EFF_STATUS, 'E') = 'E'";
						connection			= ConnectionManager.getConnection(request);
						pstmt			= connection.prepareStatement(sql_meal) ;
						rs				= pstmt.executeQuery();
						while(rs!=null && rs.next()){
						item_Code=rs.getString(2);
						itemShortDesc=rs.getString(1);
						if(itemShortDesc != null && !itemShortDesc.equals("")){
						
			
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(item_Code));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(itemShortDesc));
            _bw.write(_wl_block243Bytes, _wl_block243);

						}
						}
						}catch(Exception e){
						e.printStackTrace();
					   }finally{
						try{
						if(rs!=null)rs.close();
						if(pstmt!=null)pstmt.close();
						if(connection!=null) ConnectionManager.returnConnection(connection,request);
						}catch(Exception e){}
						}
			
            _bw.write(_wl_block244Bytes, _wl_block244);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block245Bytes, _wl_block245);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block246Bytes, _wl_block246);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(request.getParameter("encounterId")));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(request.getParameter("patientId")));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(request.getParameter("patientClass")));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(request.getParameter("mealClass")));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(request.getParameter("profileSL")));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(dietTypeStr));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(dateFrom));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(dateTo));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(mealTypeStr));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(isMealMenuDisplay));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(profileFlag));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(restrict_date_inpatients_yn));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(maximum_days_allowed));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(enableDrugYN));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block264Bytes, _wl_block264);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.menuForDate.Label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.orDietCycle.Label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.serve.Label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.qty.Label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.AdditionalInstruction.Label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.addItem.Label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AddItemto.Label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Itemtype.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.SelectItem.Label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.qty.Label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Add.label", java.lang.String .class,"key"));
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
}
