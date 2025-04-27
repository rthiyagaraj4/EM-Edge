package jsp_servlet._eds._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import java.sql.Connection;
import eCommon.Common.CommonBean;
import eCommon.Common.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import eDS.DSCommonBean;
import eDS.*;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __placedietordercud extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eds/jsp/PlaceDietOrderCUD.jsp", 1738425366000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"-->\n<!-- DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"> -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html> \n<head>\n<!-- CRF-427 -->\n\t<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\"/>\n\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=5,8,9\" >\n\t<meta charset=\"utf-8\">\n<!-- CRF-427 -->\n<!-- Added Against Start CRF-673 -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n<!-- Added Against End CRF-673 -->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t <link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t <link rel=\'StyleSheet1\' href=\'../../eCommon/html/body.css\' type=\'text/css\'/>\n\t <style type=\"text/css\">\n\t\t@import url(../../eDS/css/skin.css);\t\t\n\t </style>\n\n\t<!-- <script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script> AAKH-CRF-0065 -->\n\t<script language=\"JavaScript\" src=\"../../framework/js/PopupWindow.js\" type=\"text/javascript\"></script>\n\t<script type=\"text/javascript\" src=\"../../eDS/js/navbar.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eDS/js/simpletreemenu.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../framework/js/hashtable.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"Javascript\" src=\"../../framework/js/PopupWindow.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eDS/js/DSCommon.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eDS/js/PlaceDietOrder.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eDS/js/json.js\"></script>\n\t<script language=\"javascript\" src=\"../../eDS/js/PlaceDietOrderPHIS.js\"></script>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eDS/css/jquery-ui.css\"/>\n\t<script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\n\t<script src=\"https://code.jquery.com/ui/1.12.1/jquery-ui.min.js\"></script>\n\t<link rel=\"stylesheet\" href=\"https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css\">\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eDS/js/common/semiDisableDate/jquery.datetimepicker.css\"/>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eDS/js/common/semiDisableDate/jquery-ui-timepicker-addon.css\"/>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eDS/js/common/semiDisableDate/timepicker.css\"/>\n\t<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery-ui-timepicker-addon/1.6.3/jquery-ui-timepicker-addon.min.js\"></script>\n\t\n\t<!-- ML-MMOH-CRF-409 -->\n\t<script src=\"../../eDS/js/Moment.js\"></script>\n\t<script src=\"../../eDS/js/MomentRange.js\"></script>\n\t<!-- ML-MMOH-CRF-409 -->  \n\n\t<script type=\"text/javascript\" src=\"../../eDS/js/common/semiDisabledDateTime/datepicker-";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =".js\"></script>  \n\t<!--427-->\n\n\t<script type=\"text/javascript\">\n     _NavBar_pageID = \"Home\"; /* disable the current page from the menu */\n\tvar profileSL;\n\tvar myString = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\tvar dateSplit=\"\";\n\tif(myString.length>0){\n\t\tdateSplit= myString.split(\" \");\n\t\tvar str1 = new String(dateSplit);\n\t\tvar years=\"\";\n\t\tvar months=\"\";\n\t\tvar days=\"\";\n\t\tvar indx1=0;\n\t\tvar indx2=0;\n\t\tvar indx3=0;\n\tif(~str1.indexOf(\"Y\")){\n\t\tindx1=str1.indexOf(\"Y\");\n\tif(indx1>0)years=str1.substring(0,indx1);\n\t} \n\tif(~str1.indexOf(\"M\")){\n\t\tindx2=str1.indexOf(\"M\");\n\tif(indx1>0)  months=str1.substring(++indx1,indx2);\n\tif(indx1==0) months=str1.substring(0,indx2);\n\t}\n\tif(~str1.indexOf(\"D\")){\n\t\tindx3=str1.indexOf(\"D\");\t   \n\tif(indx1>0 && indx2>0)   days=str1.substring(++indx2,indx3);\n\tif(indx1==0 && indx2>0)  days=str1.substring(++indx2,indx3);\n\tif(indx1>0 && indx2==0)  days=str1.substring(++indx1,indx3);\n\tif(indx1==0 && indx2==0) days=str1.substring(0,indx3);\t   \n\t}\t\n\n\tif(years.indexOf(\",\")==0) years=years.replace(\",\", \"\");\n\tif(months.indexOf(\",\")==0) months=months.replace(\",\", \"\");\n\tif(days.indexOf(\",\")==0) days=days.replace(\",\", \"\");\n\t}\n\n\tvar mealTypesArr = new Array();\n\tfunction hide()\n\t{\n\t\tdocument.getElementById(\"police_response1\").style.display = \'none\';\n\t\tdocument.getElementById(\"contentsForAssignDietType\").style.display = \'none\';\n\t\tdocument.getElementById(\"attendentListLayer\").style=\"display\";\n\t\tdocument.getElementById(\"dietlistContentLayer\").style.display = \'none\';\n\t\tdocument.getElementById(\"attendent\").style=\"display\";\n\t\tdocument.getElementById(\"pateint\").style.display = \'none\';\n\t\tdocument.getElementById(\"addAttendent\").style=\"display\";\n\t\tdocument.getElementById(\"dietOrders\").style.display = \'none\';\n\t\tdocument.getElementById(\"dietselect\").style.display = \'none\';\n\t\tdocument.getElementById(\"remarks\").style.visibility = \'hidden\';\n\t\tdocument.getElementById(\"SideMenuId\").style.visibility = \'hidden\'; //MMS-QH-CRF-0190\n\t\tdocument.getElementById(\"SideMenu\").style.visibility = \'hidden\'; //MMS-QH-CRF-0190\n\t}\n\n\tfunction show()\n\t{\n\t\tdocument.getElementById(\"police_response1\").style=\"display\";\n\t\tdocument.getElementById(\"contentsForAssignDietType\").style=\"display\";\n\t\tdocument.getElementById(\"attendentListLayer\").style.display = \'none\';\n\t\tdocument.getElementById(\"dietlistContentLayer\").style=\"display\";\n\t\tdocument.getElementById(\"attendent\").style.display = \'none\';\n\t\tdocument.getElementById(\"pateint\").style=\"display\";\n\t\tdocument.getElementById(\"addAttendent\").style.display = \'none\';\n\t\tdocument.getElementById(\"dietOrders\").style=\"display\";\n\t\tdocument.getElementById(\"dietselect\").style=\"display\";\n\t\tdocument.getElementById(\"remarks\").style.visibility = \'visible\';\n\t\tdocument.getElementById(\"SideMenuId\").style.visibility = \'visible\'; //MMS-QH-CRF-0190\n\t\tdocument.getElementById(\"SideMenu\").style.visibility = \'visible\'; //MMS-QH-CRF-0190\n\t}\n\n// AAKH-CRF-0065 start \n\t$(document).ready(function()\n\t{\n\t\t$(\".text\").change(function()\n\t\t{\n\t\t\tchkFormValChange = true;\n\t\t});\n\t\t$(\".chkFormChange\").change(function()\n\t\t{\n\t\t\tchkFormValChange = true;\n\t\t});\n\t\t$(\"textarea\").change(function()\n\t\t\t{\n\t\t\tchkFormValChange = true;\n\t\t});\n\t\t$(\"select\").change(function()\n\t\t{\n\t\t\tvar chkStatusChng = $(this).attr(\"id\");\n\t\t\tif(chkStatusChng != \'status\')\n\t\t\t{\n\t\t\t\tchkFormValChange = true;\n\t\t\t}\n\t\t});\n\t});\n\t/* window.onbeforeunload = function() \n\t{\n\t\tvar xmlDoc = \"\" ;\n\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\tvar xmlStr =\"<root><SEARCH \";\n\t\txmlStr +=\" /></root>\";\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\tvar params = \"func_mode=chkSessionVal\";\n\t\txmlHttp.open(\"GET\",\"../../eDS/jsp/DLCommonValidation.jsp?\"+params,false);\n\t\txmlHttp.send(xmlDoc);\n\t\tvar retVal = trimString(xmlHttp.responseText);\n\t\tif((chkFormValChange || retVal == \'true\') && !closeWindowFlag)\n\t\t\t\treturn getMessage(\"DS_DISCARD_CHANGES\",\"DS\");\n\t\telse if(exclusionFlag==true && !closeWindowFlag)\n\t\t\t\treturn \"The Changes to Meal Exclusions will not be Saved. Are you sure you wish to continue?\";\n}; */\nwindow.onbeforeunload = function(event) {\n    // Perform any checks or prepare data to be sent\n    var retVal = \'\';\n    var url = \"../../eDS/jsp/DLCommonValidation.jsp\";\n    var params = \"func_mode=chkSessionVal\";\n    var data = new URLSearchParams(params).toString();\n\n    // Use sendBeacon to send the data asynchronously\n    if (navigator.sendBeacon) {\n        var fullUrl = url + \"?\" + data;\n        navigator.sendBeacon(fullUrl);\n    }\n\n    // Custom messages for the user\n    if ((chkFormValChange || retVal == \'true\') && !closeWindowFlag) {\n        event.returnValue = getMessage(\"DS_DISCARD_CHANGES\", \"DS\");\n        return getMessage(\"DS_DISCARD_CHANGES\", \"DS\");\n    } else if (exclusionFlag == true && !closeWindowFlag) {\n        event.returnValue = \"The Changes to Meal Exclusions will not be Saved. Are you sure you wish to continue?\";\n        return \"The Changes to Meal Exclusions will not be Saved. Are you sure you wish to continue?\";\n    }\n};\n\n// AAKH-CRF-0065 end\n    </script>\n</head>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<body onload=\"fecthMealContents();isMACNBMUpdate();getSysDate();getDieticianFlag();losCheck();PlaceOrderRightsEdit();calledDietType();drugAlert();\"><!--Added isMACNBMUpdate() Against ML-MMOH-CRF-1460-->\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<body onload=\"fecthMealContents();getSysDate();getDieticianFlag();losCheck();PlaceOrderRightsEdit();calledDietType();drugAlert();\"><!--Modified Against ML-MMOH-CRF-0672--> <!-- Added against ML-MMOH-CRF-0677 -->\t\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<form id=\"input\" name=\"PlaceDietOrderForm\" id=\"PlaceDietOrderForm\" action=\"../../servlet/eDS.PlaceDietOrderServlet\" target=\"messageFrame\" onsubmit=\"checkNull();\">\n\n\t\t<table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n\t\t<tr>\n\t\t\t<td>\n\t\t\t<table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\" bordercolor=\"#9999FF\">\n\t\t\t<tr>\n\t\t\t\t<td width=\"765\" valign=\"top\">\n\t\t\t\t<br/>\n\t\t\t\t<left>\n\t\t\t\t<table width=\"50%\" class=\"webglobeBoxBorder\" summary=\"asd\" cellpadding=\"0\" cellspacing=\"0\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"center\" valign=\"top\" class=\"smalltext\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t\t<td align=\"center\" valign=\"top\" class=\"smalltext\"><input type=\"Radio\" name=\"Suballocator\" id=\"Suballocator\"  value=\"Yes\" onclick=\"show();\" checked></td>\n\t\t\t\t\t<td align=\"center\" valign=\"top\" class=\"smalltext\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td><!--ML-MMOH-CRF-0406-->\n\t\t\t\t\t<td align=\"center\" valign=\"top\" class=\"smalltext\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\t\t\t\t\t\t\t\t\t     \n\t\t\t\t\t\t<input type=\"Radio\" name=\"Suballocator\"  id=\"attendantRadio\" value=\"No\" onclick=\"hide();\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t<input type=\"Radio\" name=\"Suballocator\"  id=\"attendantRadio\" value=\"No\" disabled=\"disabled\"></td>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t   <input type=\"Radio\" name=\"Suballocator\"  id=\"attendantRadio\" value=\"No\" onclick=\"hide();\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t<input type=\"Radio\" name=\"Suballocator\"  id=\"attendantRadio\" value=\"No\" onclick=\"hide();\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t<input type=\"Radio\" name=\"Suballocator\"  id=\"attendantRadio\" value=\"No\" disabled=\"disabled\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t<input type=\"Radio\" name=\"Suballocator\"  id=\"attendantRadio\" value=\"No\" disabled=\"disabled\"></td>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\t\t\t\t\t\t\t\n\t\t\t</tr>\n\t\t\t</table>\n\t\t<br/>\n\t\t<table width=\"100%\">\n\t\t<tr>\n\t\t\t<td align=\"center\" valign=\"top\" colspan=\"2\">\n\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"2\" id=\"pateint\" >\n\t\t\t\t<tr>\n\t\t\t\t<th  valign=\"top\" colspan=\"2\" width=\"50%\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t</th>\n\t\t\t\t</tr>\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t<!--ML-MMOH-CRF-0684 Starts-->\n\t\t<tr>\n\t\t<td class =\"label\" align =\"right\">\n\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t<td>\n\t\t\t<select name=\"menu_type\" id=\"menu_type\" id =\"menu_type\">\n\t\t\t\t<option value=\"\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" selected>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t</select><img id=\"MenuImage\" src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:visible\'></img>\n\t\t\t</td>\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t</select>\n\t\t   </td>\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t<!--ML-MMOH-CRF-0684 Ends-->\n\t<tr>\n\t\t<td class=\"label\"  nowrap>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t\t<td nowrap>\n\t\t<select name=\"dietCategory\" id=\"dietCategory\" id=\"dietCategory\" onchange=\"checkExclusions_select(this);return fecthDietType(this.value);fecthDietTypeToMealClass();drugAlert();\"> <!-- MMS-QH-CRF-0190 --><!--MMS-KH-CRF-0029.1-->\n\t\t<option value=\"\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t<option value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" selected>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t</option>\n\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t<option value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" >";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" </option>\n\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t</select><img id=\"dietCatImage\" src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:visible\'></img>\n\t\t<INPUT type=\"hidden\" name=\"dietCategory1\" id=\"dietCategory1\"  value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"> <!-- Added Against End KDAH-CRF-349-US5 -->\t\n\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\n\t\t\n\t\t</td>\n\t\t</tr>\n\n\t\t<!--ML-MMOH-CRF-0427 start-->\n\t\t<tr>\n\t\t\t<td class=\"label\"  nowrap>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td>\n\t\t\t\t<td nowrap>\n\t\t\t\t\t<input type=\"text\" class=\'chkFormChange\' name=\"dateFrom\" id=\"dateFrom\" id=\"dateFrom\" size=\"10\" maxlength=\"10\" value=\"\" onchange=\"checkExclusions(this)\">\n\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\"  name=\'datepickerimg\' id=\'fromdatepickerimg\' onclick=\"grayOutCalendar(\'dateFrom\',\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\',\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\');\">\n\t\t\t\t\t<img id=\"fromDateImage\" src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:visible\'></img>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\n\t\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'dateFrom\');\">\n\t\t\t\t\t<img id=\"fromDateImage\" src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:visible\'></img>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\n\t\t\t\t\t<input type=\"hidden\" name=\"testDate\" id=\"testDate\" size=\"8\" />\n\t\t\t\t</td>\n\t\t\t\t<td class=\"label\"  nowrap>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\t\t\t\t<td>\n\t\t\t\t\t<input type=\"text\" name=\"dateTo\" id=\"dateTo\" id=\"dateTo\" class=\'chkFormChange\' size=\"10\" maxlength=\"10\" value=\"\" onchange=\"checkExclusions(this)\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\n\t\t\t\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\"  name=\'datepickerimg\' id=\'todatepickerimg\' onclick=\"grayOutCalendar(\'dateTo\',";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =",\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\')\">\n\t\t\t\t\t<img id=\"dateToImage\" src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:visible\'/>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\n\t\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'dateTo\');\">\n\t\t\t\t\t<img id=\"dateToImage\" src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:visible\'/><!-- CRF-412-->\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\n\t\t\t<input type=\'hidden\' name=\'dateTo.pattern\' id=\'dateTo.pattern\' value=\'dd/MM/yyyy\'>\n\t\t\t</td>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t<td>\n\t\t\t</td>\n\t\t\t<td class=\"label\"  nowrap>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</td>\n\t\t\t<td>\n\t\t\t\t<input type=\"checkbox\" name=\"dieticianReferral\" id=\"dieticianReferral\" id=\"dieticianReferral\" value=\"\" onclick=\"enableMandatory();\">\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\"label\"  nowrap>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td>\n\t\t\t<td nowrap>\n\t\t\t<!--select name=\"mealClass\" id=\"mealClass\" onchange=\"checkExclusions_select(this);drugAlert();return fecthDietTypeToMealClass();\"--><!--MMS-KH-CRF-0029.1-->\n\t\t\t<select name=\"mealClass\" id=\"mealClass\" id=\"mealClass\" onchange=\"checkExclusions_select(this);fecthDietTypeToMealClass(); drugAlert();\"><!--MMS-KH-CRF-0029.1-->\n\t\t<option value=\"\">\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" selected>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</option>\n\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" >\n\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t</option>\n\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t</select><img id=\"MealClassImage\" src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:visible\'></img>\n\t\t</td>\n\t\t<td  class=\"label\" nowrap>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</td>\n\t\t<td nowrap>\n\t\t<select name=\"dietType\" id=\"dietType\" id=\"dietType\" onKeyUp=\"diettype_Autocomplete();\" onClick=\"Select()\" onchange=\"checkExclusions_select(this);fecthDietTypeToMealClass();drugAlert();\"><!--Modified against ML-MMOH-CRF-0674--><!--MMS-KH-CRF-0029.1-->\n\t\t<option value=\"\">";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t</option>\n\t\t</select><img id=\"dietTypeImage\" src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:visible\'></img>\n\t\t</td>\n\t\t<td></td>\n\t\t<td class=\"label\"  nowrap>\n\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t</td>\n\t\t<td>\n\t\t<input type=\"checkbox\" name=\"Full_Day_NBM_YN\" id=\"Full_Day_NBM_YN\" id=\"Full_Day_NBM_YN\" value=\"\" onclick=\"enableDisableField();enableMandatory();\">\n\t\t</td>\n\t\t</tr>\n\t<!-- Modified Against Start ML-MMOH-CRF-0671 [IN:062266] -->\n\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t<tr id=\"police_response1\" >\n\t\t<td  class=\"label\" nowrap>\n\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t</td>\n\t\t<td>\n\t\t<select name=\"feedType\" id=\"feedType\" id=\"feedType\">\n\t\t\t<option value=\"\">";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t</option>\n\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t</select>\n\t\t\t</td>\n\t\t\t<td  class=\"label\" nowrap>\n\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t</td>\n\t\t\t<td>\n\t\t\t\t<select name=\"dsDeliveryInstr\" id=\"dsDeliveryInstr\" id=\"dsDeliveryInstr\" indexed=\"10\">\n\t\t\t\t\t<option value=\"\">";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t\t</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t</select>\n\t\t</td>\n\t</tr>\n\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t<tr id=\"police_response1\" >\n\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t<!-- Modified Against End ML-MMOH-CRF-0671 [IN:062266] -->\n\t\t<!--ML-MMOH-CRF-0412 STARTS-->\n\t\t<tr>\n\t\t\t<td  class=\"label\" nowrap>";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</td>\n\t\t\t<td>\n\t\t\t\t<select name=\"texture_of_diet\" id=\"texture_of_diet\" id=\"texture_of_diet\" indexed=\"10\"><!-- CRF-412-->\n\t\t\t\t<option value=\"\">";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</option><!-- CRF-412-->\n\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t</option>\n\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t</select>\n\t\t</td>\n\t\t<td  class=\"label\" nowrap></td>\n\t\t<td></td>\n\t</tr>\n\t\t<!--ML-MMOH-CRF-0412 ENDS-->\n\t<tr>\n\t\t<!-- Modified Against Start ML-MMOH-CRF-0671 [IN:062266] -->\n\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t<td  class=\"label\" nowrap>";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</td>\n\t\t\t<td><textarea name=\"feedingInstructions\" id=\"feedingInstructions\" style=\"resize:none;\" onblur=\"return callsimbly();\" onkeypress=\"restrictSpecialChars(event)\"></textarea></td>\n\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t<!-- Modified Against End ML-MMOH-CRF-0671 [IN:062266] -->\n\t\t<td  class=\"label\" nowrap>\n\t\t<!-- Modified Against Start ML-MMOH-CRF-0668 [IN:062263] -->\n\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t<!--  Added Against Start KDAH-CRF-0353 US1 -->  \n\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\t\n\t\t<!--  Added Against End KDAH-CRF-0353 US1 -->  \n\t\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t<!-- Modified Against End ML-MMOH-CRF-0668 [IN:062263] -->\n\t\t</td>\n\t\t<td><textarea name=\"prepInstr\" id=\"prepInstr\" cols=\'35\' style=\"resize:none;\" onkeypress=\"restrictSpecialChars(event)\" onblur=\"textAreaLimit(this,4000);\"></textarea></td>\n\t</tr>\n\t</table>\n\t</td>\n\t</tr>\n\t<tr>\n\t<td>\n\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"2\" id=\"attendent\" style=\"display:none;\">\n\t\t<tr>\n\t\t\t<th   colspan=\"2\" width=\"45%\"><fmtmessage key=\"eOT.patientAttendantTitle.Label\" bundle=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" /></th>\n\t\t</tr>\n <!--ML-MMOH-CRF-0684 Starts-->\n ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t<tr>\n\t<td class =\"label\" align =\"right\">\n\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t<td >\n\t\t<select name=\"mac_menu_type\" id=\"mac_menu_type\" id =\"mac_menu_type\"> <!--Added Against TFS:32135-->\n\t\t\t<option value=\"\">";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" selected>\n\t\t\t\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t</select><img id=\"MenuImage\" src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:visible\'></img>\n\t</td>\t\t\t\t\t\t\t\t\t\t\t\n\t\t</select>\n   </td>\n</tr>\n ";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n<!--ML-MMOH-CRF-0684 Ends-->\n<tr>\n\t<td class=\"label\" >";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</td>\n\t<td>\n\t\t<input type=\"text\" class=\'chkFormChange\' name=\"attendentFromDate\" id=\"attendentFromDate\" id=\"attendentFromDate\" maxlength=\"10\" onBlur=\'isValidDate(this)\' size=\"10\" >\n\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return grayOutCalendar(\'attendentFromDate\',\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\');\">\n\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'attendentFromDate\');\">\n\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t<!--img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'attendentFromDate\');\"-->\n\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t</td>\n\t<td class=\"label\" >";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="</td>\n\t<td>\n\t\t<input type=\"text\" class=\'chkFormChange\' name=\"attendentToDate\" id=\"attendentToDate\" id=\"attendentToDate\" size=\"10\" maxlength=\"10\" onBlur=\'isValidDate(this)\' >\n\t";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t<img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return grayOutCalendar(\'attendentToDate\',\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\');\">\n\t<img src=\'../../eCommon/images/mandatory.gif\'></img> <!-- 58902 -->\t\n\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'attendentToDate\');\">\n\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img> <!-- CRF-412-->\n\t";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\t\t\n\t\t<input type=\'hidden\' name=\'attendentToDate.pattern\' id=\'attendentToDate.pattern\' value=\'dd/MM/yyyy\'>\n\t</td>\n</tr>\n\t<tr>\n\t\t<!-- start MMS-QH-CRF-0190 -->\n\t\t<td class=\"label\" nowrap>";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="</td>\n\t\t<td nowrap>\n\t\t\t<select name=\"attendentDietCategory\" id=\"attendentDietCategory\" onchange=\"return fecthDietTypes_Attendant(this.value);fecthDietTypeToMealClass();drugAlert();\"> <!-- MMS-QH-CRF-0190 --><!--MMS-KH-CRF-0029.1-->\n\t\t\t<option value=\"\">";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="<!-- CRF-412-->\n\t\t\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t\t\t\t\t</option>\n\t\t\t";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t</select>\n\t\t<img id=\"dietCatImage\" src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:visible\'></img> <!-- 52776 -->\n\t</td>\n\t<td  class=\"label\" nowrap>";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="</td>\n\t<td nowrap>\n\t\t<select name=\"attendentDiet\" id=\"attendentDiet\" onKeyUp=\"attendentdiettype_Autocomplete();\" onClick=\"attendentSelect()\"><!--ML-MMOH-CRF-0674-->\n\t\t\t<option>";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="</option>\n\t\t</select>\n\t\t<img id=\"dietTypeImage\" src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:visible\'></img>\n\t</td>\n</tr>\n<tr>\n\t<td class=\"label\" >\n\t\t";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t</td>\n\t<td nowrap>\n\t\t<select name=\"attendentMealClass\" id=\"attendentMealClass\">\n\t\t\t<option value=\"\">";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\" selected>\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t</option>\n";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\">\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\t\t\t\t\t\t\t\t\t\t\t\t</option>\n";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n\t</select>\n\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t<!-- Added Against ML-MMOH-CRF-1005-US2 Starts Here -->\n\t<input type=\"hidden\" name=\"mc_defaultcount\" id=\"mc_defaultcount\" id =\"mc_defaultcount\" value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\">\n\t<!-- Added Against ML-MMOH-CRF-1005-US2 Ends Here -->\n\t</td>\n\t\t<!-- end MMS-QH-CRF-0190 -->\n\t<td class=\"label\" >\n\t\t<!--";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="--> <!--COMMENTED FOR ML-MMOH-CRF-0406-->\n\t\t";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 =" <!--ML-MMOH-CRF-0406-->\n\t</td>\n\t<td><textarea name=\"atndInstr\" id=\"atndInstr\" style=\"resize:none;\" cols=\'35\'\n\tonkeypress=\"restrictSpecialChars(event)\"\n\tonblur=\"textAreaLimit(this,120);\"></textarea>\n\t<input type=\"hidden\" name=\"atndInstr1\" id=\"atndInstr1\" value=\"\"></td> <!-- ML-MMOH-SCF-735 -->\n\t</tr><!-- MMS-DM-SCF-0077 onkeypress function is added -->\n</table>\n</td>\n</tr>\n</table>\n</td>\n</tr>\n\t<tr id=\"contentsForAssignDietType\" >\n\t\t<TD>\n\t\t<div id=\"listContentLayer1\" style=\"display:block;visibility:visible;overflow-n: scroll;height:20;width:502;border: 1px outset #9999FF\" align=\"center\">\n\t\t\t<TABLE width=\"100%\" id=\"Able1\" CELLSPACING=\"0\" cellpadding=\"0\">\n\t\t\t\t<TR>\n\t\t\t\t\t<TH colspan=\"3\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t\t\t\t\t</TH>\n\t\t\t\t</TR>\n\t\t\t</TABLE>\n\t\t\t<div id=\"listContentLayer\" style=\"display:block;visibility:visible;overflow-y: scroll;height:98;width:500;border: 0px outset #9999FF\" align=\"center\">\n\t\t\t\t<TABLE width=\"100%\" id=\"Able\" CELLSPACING=\"0\" cellpadding=\"0\">\n\t\t\t\t\t<TR>\n\t\t\t\t\t</TR>\n\t\t\t\t</TABLE>\n\t\t\t</div>\n\t\t\t</div>\n\t\t</TD>\n\t\t<TD>\n\t\t\t<div id=\"NilByMounth\" style=\"display:block;visibility:visible;height:116;width:230;border: 1px outset #9999FF\" align=\"center\">\n\t\t\t<TABLE class=\"webglobeBoxBorder\" width=\"100%\" CELLSPACING=\"0\" cellpadding=\"0\">\n\t\t\t<TR>\n\t\t\t\t<TH colspan=\"2\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n\t\t\t\t</TH>\n\t\t\t</TR>\n\t\t\t<TR>\n\t\t\t<TD class=\"label\" NOWRAP>\n\t\t\t\t";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\t\t</TD>\n\t\t\t<TD>\n\t\t\t\t<input type=\"text\" class=\'chkFormChange\' name=\"from\" id=\"from\" id=\"from\" size=\"16\" value=\"\" onblur=\"if(this.value!=\'\') validateDate(this,this.value)\">\n\t\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n\t\t\t\t\t<img src=\"../../framework/images/img.gif\" id=\"nbmfromimg\" onclick=\"return grayOutCalendarDateTime(\'from\',";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\');\" style=\'visibility:visible\'/>\n\t\t\t\t";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\t\n\t\t\t\t\t<img src=\"../../framework/images/img.gif\" onclick=\"return showCalForNilByMouth(\'from\',\'%d/%m/%Y %H:%M\',\'24\',true,\'from\');\"/>\n\t\t\t\t";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t</TD>\n\t\t\t</TR>\n\t\t\t<TR>\n\t\t\t<TD class=\"label\">\n\t\t\t\t";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\n\t\t\t</TD>\n\t\t\t<TD>\n\t\t\t\t<input type=\"text\" class=\'chkFormChange\' name=\"to\" id=\"to\" id=\"to\" size=\"16\" value=\"\" onblur=\"if(this.value!=\'\') validateToDate(this,this.value)\" >\n\t\t\t\t";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t\t\t\t\t<img src=\"../../framework/images/img.gif\" onclick=\"return grayOutCalendarDateTime(\'to\',";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\');\"/>\n\t\t\t\t";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n\t\t\t\t\t<img src=\"../../framework/images/img.gif\" onclick=\"return showCalForNilByMouth(\'to\',\'%d/%m/%Y %H:%M\',\'24\',true,\'to\');\"/>\n\t\t\t\t";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n\t\t\t</TD>\n\t\t</TR>\n\t</TABLE>\n\t</div>\n\t</TD>\n\t</tr>\n\t</table>\n\t\t<br/>\n\t\t<table width=\"100%\" summary=\"asd\">\n\t\t\t<tr>\n\t\t\t\t<th colspan=\"8\"  id=\"dietOrders\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n\t\t\t\t</th>\n\t\t\t</tr>\n\t\t\t<tr  id=\"dietselect\">\n\t\t\t<td colspan=\"8\" class=\"label\">\n\t\t\t\t";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 =":\n\t\t\t\t<select name=\"status\" id=\"status\" id=\"status\" onchange=\"checkStatus(this.value, this)\">\n\t\t\t\t\t<option value=\"\"> ";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 =" </option>\n\t\t\t\t\t<option value=\"A\"> ";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 =" </option>\n\t\t\t\t\t<option value=\"C\"> ";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 =" </option>\n\t\t\t\t\t<option value=\"F\"> ";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 =" </option>\n\t\t\t\t\t<option value=\"X\"> Cancelled Orders </option>\n\t\t\t\t\t<option value=\"A~F\" selected> Active/Future Orders </option> \n\t\t\t\t</select>\n\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td id=\"myId\">\n\t\t\t\t<div id=\"dietlistContentLayer\" style=\"display:block;visibility:visible;overflow-y: scroll;height:100;width:100%;border: 1px outset #9999FF\" align=\"center\">\n\t\t\t\t\t<table width=\"100%\" summary=\"asd\" id=\"result_Id\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<th> </th>\n\t\t\t\t\t\t\t<th>";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="</th>\n\t\t\t\t\t\t\t<th colspan=\"1\">";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="</th>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\n\t\t\t\t\t\t\t<th>";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="</th> <!--Added against ML-MMOH-CRF-1780-->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="</th>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="</th>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</div>\n\t\t\t</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<div id=\"remarks\" style=\'visibility:visible\'>&nbsp;<a href=\"#\" onclick=\"return Remarks();\">";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="</a>\n\t\t\t<img id=\"remarksImg\" src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:hidden\'></img>\t<!--Added Against ICN-72015-->\n\t\t\t</div>\n\t\t\t<br/>\n\t\t\t<div id=\"attendentListLayer\" style=\"display:none;visibility:visible;overflow-y: scroll;height:100;width:100%;border: 1px outset #9999FF\" align=\"center\">\n\t\t\t\t<table width=\"100%\" summary=\"asd\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td>\n\t\t\t\t\t<table width=\"100%\" summary=\"asd\" id=\"attendentListTable\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<th>";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="</th>\n\t\t\t\t\t\t<th>";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="</th>\n\t\t\t\t\t\t<th colspan=\"2\"></th>\n\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t\t</Td>\n\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</div>\n\t\t\t<br/>\n\t\t\t<table  id=\"addAttendent\" align=\"right\" style=\"display:none;\">\n\t\t\t<tr>\n\t\t\t\t<td  class=\"data\">\n\t\t\t\t\t<a href=\"#\" onclick=\"return checkDates();\"><br>+ ";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 =" ";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="</a><!--ML-MMOH-CRF-0406-->\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t</td>\n\t\t\t<td valign=\"top\"  width=\"20%\" id=\'SideMenuId\'> <!-- MMS-QH-CRF-0190 -->\n\t\t\t<div style=\"visibility:visible;width:110%;overflow-n:border: 1px ;scroll;height:70;width:100%;\">\n\t\t\t\t<table id=\"tableData\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" >\n\t\t\t\t\t<tr >\n\t\t\t\t\t\t<td style=\"text-align: left\" class=\"label\" id=\"as\" colspan=\"2\" NOWRAP>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 =" :\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td style=\"text-align: left\" class=\"label\" id=\"as\" colspan=\"2\" NOWRAP>\n\t\t\t\t\t\t\t<input type=\"text\" class=\'chkFormChange\' name=\"dateForMeanu\" id=\"dateForMeanu\" size=\"10\" maxlength=\"10\" value=\"\" onblur=\"isValidDate(this),getDayRefNo(this.value);\" onmouseover=\"return getDayRefNo(this.value)\">\n\t\t\t\t\t\t<!--ML-MMOH-CRF-0427 US3 start-->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\t\t\t\t\t\t\t\t\n\t\t\t\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\"  name=\'datepickerimg_1\' id=\'datepickerimg_1\' onclick=\"grayOutCalendar(\'dateForMeanu\',";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\')\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\t\n\t\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'dateForMeanu\');\">\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\n\t\t\t\t\t<!--ML-MMOH-CRF-0427 US3 ends-->\t\n\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td style=\"text-align: left\" class=\"label\" colspan=\"2\" NOWRAP>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 =" :\n\t\t\t\t\t</td>\n\t\t\t\t\t<td style=\"text-align: left\" class=\"label\" id=\"as\" colspan=\"2\" NOWRAP >\n\t\t\t\t\t\t<select name=\"dayRef\" id=\"dayRef\" onchange=\"setdayRef(this)\" disabled=\"disabled\">\n\t\t\t\t\t\t\t<option value=\"\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\n\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t</select>\n\t\t\t\t\t\t<input type=\"button\" value=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\" class=\"button\" onClick=\"getMenuForDayRef();\" />\n\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr><td>&nbsp;&nbsp;&nbsp;<td></tr>\n\t\t\t\t\t<tbody id=\"dispGTC\" align=\"center\" BORDER = 1 style=\"overflow:auto;\" class=\"label\">\n\t\t\t\t\t</tbody>\n\t\t\t\t\t</table>\n\t\t\t\t</div>\n\t\t\t<table>\n\t\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t<div id=\"SideMenu\" style=\"visibility:visible;overflow-y: scroll\"></div>\n\t\t\t\t\t";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\n\t\t\t\t\t<div id=\"html-section\" title=\'";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\' >\n\t\t\t\t\t<table border=\"1\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td id=\"editMenu_flow_text\" onclick=\"modelWindow(this);\"  colspan=\"9\" class=\"label\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/flow_text.gif\' alt=\'Want To Edit\' />\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr><td>&nbsp;</td></tr>\n\t\t\t\t\t</table>\n\t\t\t\t\t<div style=\"overflow-y: scroll;height:250;width:100%;\">\n\t\t\t\t\t\t<table style=\"overflow-y: scroll;height:250;width:100%;\">\n\t\t\t\t\t\t\t<tbody id=\"treemenu3\"  BORDER = 1 style=\"overflow:auto;\" class=\"label\"></tbody>\n\t\t\t\t\t\t\t<tbody id=\"treemenu4\"  BORDER = 1 style=\"overflow:auto;\" class=\"label\"></tbody>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\n\t\t\t\t\t<div id=\"NutriEntSup\" title=\'";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\' style=\"width:100%;overflow-y: scroll;height:60;width:100%;\">\n\t\t\t\t\t<table border=\"1\">\n\t\t\t\t\t\t<tbody id=\"Nutrient\" align=\"center\" BORDER = 1 style=\"overflow:auto;\" class=\"label\" ></tbody>\n\t\t\t\t\t\t<tbody id=\"Nutrient1\" align=\"center\" BORDER = 1 style=\"overflow:auto;\" class=\"label\"></tbody>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td id=\"nutrient_flow_text\" onclick=\"document.getElementById(\'nutrientDeleteFlag\').value=\'Y\';return nuitrientModelWindow(this);\"  colspan=\"9\" class=\"label\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 =" \n\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/flow_text.gif\' alt=\'Want To Edit\' />\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t\t</div>\n\t\t\t\t\t<div id=\"spFoodItems\" style=\"width:100%;overflow-y: scroll;height:60;width:100%;\">\n\t\t\t\t\t\t<table border=\"1\">\n\t\t\t\t\t\t\t<tbody id=\"FoodItems\" align=\"center\" BORDER = 1 style=\"overflow:auto;\" class=\"data\" ></tbody>\n\t\t\t\t\t\t\t<tbody id=\"FoodItems1\" align=\"center\" BORDER = 1 style=\"overflow:auto;\" class=\"label\"></tbody>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td id=\"splFoodItem_flow_text\" onclick=\"return spFoodItemsModelWindow(this,\'";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\');\"  class=\"label\" colspan=\"9\">\n\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/flow_text.gif\' alt=\'Want To Edit\' />\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</div>\n\t\t\t\t\t<div id=\"foodDislikes\" style=\"width:100%;overflow-y: scroll;height:45;width:100%;\">\n\t\t\t\t\t\t<table border=\"0\">\n\t\t\t\t\t\t\t<tbody id=\"DislikesFoodItems\"></tbody>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td id=\"foodItem_dislike_flow_text\" onclick=\"return foodDislikesModelWindow(this);\"  class=\"label\" colspan=\"2\" >\n\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/flow_text.gif\' alt=\'Want To Edit\' />\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</div>\n\t\t\t\t\t<div id=\"Others\" style=\"width:110%;overflow-y:height:45;width:100%;\">\n\t\t\t\t\t<table border=\"0\">\n\t\t\t\t\t\t<tbody id=\"Others\"></tbody>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\"2\"  class=\"label\">\n\t\t\t\t\t\t\t<a\n\t\t\t\t\t\t\t\thref=\"javascript:callDiagnosis()\">";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\n\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td colspan=\"2\"  class=\"label\">\n\t\t\t\t\t\t\t\t<a\n\t\t\t\t\t\t\t\t\thref=\"javascript:callDiagnosis1()\">";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\n\t\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t\t</div>\n\t\t\t\t\t<div id=\"mealTypeExclusions\" style=\"width:100%;overflow-y: scroll;height:105;width:100%;background-color:white;\">\n\t\t\t\t\t\t<table border=\"0\">\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td id=\"exclusions_flow_text\" onclick=\"return openExclusionsWindow(this);\"  class=\"label\" colspan=\"2\" >\n\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/flow_text.gif\' alt=\'Want To Edit\' />\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tbody id=\"exclusions\"></tbody>\t\t\t\t\t\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</div>\n\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t\t<input type=\"hidden\" name=\"languageId\" id=\"languageId\" id=\"languageId\" value=\"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\" />\n\t\t<input type=\"hidden\" name=\"kitchenCode\" id=\"kitchenCode\" value=\"";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\">\n\t\t<input type=\"hidden\" name=\"encounterId\" id=\"encounterId\" id=\"encounterId\" value=\"";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\">\n\t\t<input type=\"hidden\" name=\"profileSL\" id=\"profileSL\" id=\"profileSL\" value=\"";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\" />\n\t\t<input type=\"hidden\" name=\"remarks_1\" id=\"remarks_1\" id=\"remarks_1\" value=\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\" />\t<!-- MMS-KH-CRF-029.1 -->\n\t\t<input type=\"hidden\" name=\"profileSL1\" id=\"profileSL1\" id=\"profileSL1\" value=\"";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\" />\n\t\t<input type=\"hidden\" name=\"addedFacilityId\" id=\"addedFacilityId\" id=\"addedFacilityId\" value=\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\" />\n\t\t<input type=\"hidden\" name=\"Patient_ID\" id=\"Patient_ID\" value=\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\" />\n\t\t<input type=\"hidden\" name=\"patientClass\" id=\"patientClass\" value=\"";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\" />\n\t\t<input type=\"hidden\" name=\"locationType\" id=\"locationType\" value=\"";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\" />\n\t\t<input type=\"hidden\" name=\"locationCode\" id=\"locationCode\" value=\"";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\" />\n\t\t<input type=\"hidden\" name=\"addedById\" id=\"addedById\" id=\"addedById\" value=\"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\" />\n\t\t<input type=\"hidden\" name=\"addedAtWsNo\" id=\"addedAtWsNo\" id=\"addedAtWsNo\" value=\"";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\" />\n\t\t<input type =\"hidden\" name=\"defalutDietType\" id=\"defalutDietType\" />\n\t\t<input type =\"hidden\" name=\"defalutMealType\" id=\"defalutMealType\" />\n\t\t<input type =\"hidden\" name=\"deitTypesStatus\" id=\"deitTypesStatus\" id=\"deitTypesStatus\" value=\"";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\"/>\n\t\t<input type =\"hidden\" name=\"gracePeriodApplicableYN\" id=\"gracePeriodApplicableYN\" value=\"";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\"/>\n\t\t<input type =\"hidden\" name=\"gracePeriod\" id=\"gracePeriod\" value=\"";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\"/>\n\t\t<input type=\"hidden\" name=\"mealTotalCalorie\" id=\"mealTotalCalorie\" />\n\t\t<input type=\"hidden\" name=\"datepattrn1\" id=\"datepattrn1\" value=\"dd/MM/yyyy\"/>\n\t\t<input type=\"hidden\" name=\"isNEW\" id=\"isNEW\" />\n\t\t<input type=\"hidden\" name=\"orderID\" id=\"orderID\" />\n\t\t<input type=\"hidden\" name=\"ageGroupCode1\" id=\"ageGroupCode1\"  />\n\t\t<input type=\"hidden\" name=\"ageGroupArr\" id=\"ageGroupArr\"  />\n\t\t<input type=\"hidden\" name=\"nFITotalCalorie\" id=\"nFITotalCalorie\" />\n\t\t<input type=\"hidden\" name=\"splFITotalCalorie\" id=\"splFITotalCalorie\" />\n\t\t<input type=\"hidden\" name=\"selectedProfile\" id=\"selectedProfile\" id=\"selectedProfile\" />\n\t\t<input type=\"hidden\" name=\"checkMealType\" id=\"checkMealType\" value=\"\" />\n\t\t<input type=\"hidden\" name=\"checkDietType\" id=\"checkDietType\" value=\"\" />\n\t\t<input type=\"hidden\" name=\"unCheckedMType\" id=\"unCheckedMType\" value=\"\" />\n\t\t<input type=\"hidden\" name=\"unCheckedDType\" id=\"unCheckedDType\" value=\"\" />\n\t\t<input type=\"hidden\" name=\"checkedMType\" id=\"checkedMType\" value=\"\" />\n\t\t<input type=\"hidden\" name=\"checkedDType\" id=\"checkedDType\" value=\"\" />\n\t\t<input type=\"hidden\" name=\"flag\" id=\"flag\" value=\"";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\" />\n\t\t<input type=\"hidden\" name=\"hdrFlag\" id=\"hdrFlag\" value=\"\" />\n\t\t<input type=\"hidden\" name=\"servingDate\" id=\"servingDate\" id=\"servingDate\" value=\"";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\" />\n\t\t<!--<input type=\"hidden\" name=\"remarks\" id=\"remarks\" value=\"\" /> --><!-- Commented Against AMRI-SCF-0497 -->\n\t\t<input type=\"hidden\" name=\"splFlagArr\" id=\"splFlagArr\" value=\"false\" />\n\t\t<input type=\"hidden\" name=\"nutriFlagArr\" id=\"nutriFlagArr\" value=\"false\" />\n\t\t<input type=\"hidden\" name=\"profileFlag\" id=\"profileFlag\" id=\"profileFlag\" value=\"";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\" /><!--ML-MMOH-CRF-0427-->\n\t\t<input type=\"hidden\" name=\"restrict_date_inpatients_yn\" id=\"restrict_date_inpatients_yn\" id=\"restrict_date_inpatients_yn\" value=\"";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\" /><!--ML-MMOH-CRF-0427-->\n\t\t<input type=\"hidden\" name=\"maximum_days_allowed\" id=\"maximum_days_allowed\" id=\"maximum_days_allowed\" value=\"";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\" /><!--ML-MMOH-CRF-0427-->\n\t\t<input type=\"hidden\" name=\"GEN_MEALPLAN_FOR_NBM_PAT_YN\" id=\"GEN_MEALPLAN_FOR_NBM_PAT_YN\" id=\"GEN_MEALPLAN_FOR_NBM_PAT_YN\" value=\"";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\" /><!-- MMS-QH-CRF-0078.1-US003-->\n\t\t<input type=\"hidden\" name=\"IRREGULAR_DIET_ORD_YN\" id=\"IRREGULAR_DIET_ORD_YN\" id=\"IRREGULAR_DIET_ORD_YN\" value=\"";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\" /><!-- ML-MMOH-CRF-409-->\n\t\t<input type=\"hidden\" name=\"IRREGULAR_MEAL_ORD_MESSAGE\" id=\"IRREGULAR_MEAL_ORD_MESSAGE\" id=\"IRREGULAR_MEAL_ORD_MESSAGE\" value=\"";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\" /><!-- ML-MMOH-CRF-409-->\n\t\t<input type=\"hidden\" name=\"irregular_meal_code\" id=\"irregular_meal_code\" id=\"irregular_meal_code\" value=\"\" /><!-- ML-MMOH-CRF-409-->\n\t\t<input type=\"hidden\" name=\"No_Of_Attendant\" id=\"No_Of_Attendant\" id=\"No_Of_Attendant\" value=\"";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\" /><!-- ML-MMOH-CRF-412-->\n\t\t<input type=\"hidden\" name=\"Attendent_Label_Name\" id=\"Attendent_Label_Name\" id=\"Attendent_Label_Name\" value=\"";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\" /><!-- ML-MMOH-CRF-406-->\n\t\t<input type=\"hidden\" name=\"enable_drugfood_YN\" id=\"enable_drugfood_YN\" id=\"enable_drugfood_YN\" value=\"";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\" /> \n\t\t<!-- MMS-KH-CRF-0029.1-US008 -->\n\t\t<!--ML-MMOH-CRF-0672 Starts Here-->\n\t\t<input type=\"hidden\" name=\"diffDays\" id=\"diffDays\" id=\"diffDays\" value=\"";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\">\n\t\t<input type=\"hidden\" name=\"isLos_gt7\" id=\"isLos_gt7\" id=\"isLos_gt7\" value=\"";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\">\n\t\t<!--ML-MMOH-CRF-0672 Ends Here-->\n\t\t<script type=\"text/javascript\" src=\"../../eDS/js/setupmenu.js\"></script>\n\t\t<script type=\"text/javascript\">\n\t\tvar menu = new NavBar(\"SideMenu\");\n\t\tnew NavSection(menu, \'";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\', \"html-section\",\"sec\"); // look in the HTML code for a DIV with ID=\"html-section\"\n\t\tnew NavSection(menu, \'";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\', \"NutriEntSup\",\"nutsuppl\");\n\t\tnew NavSection(menu, \'";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\', \"spFoodItems\",\"spfood\"); <!-- Modified Against PMG2017-COMN-CRF-0012 [IN066074] -->\n\t\tnew NavSection(menu, \'";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\', \"foodDislikes\",\"dslk\");\n\t\tnew NavSection(menu, \'";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\', \"Others\",\"oth\");\n\t\tnew NavSection(menu, \'";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\', \"mealTypeExclusions\",\"exc\");\n\t\tmenu.generate(true);\n\t\tmenu.sync(true);\n\t\t//$(\"#exc\")[0].onclick();\n\n\t\tif(document.getElementById(\"defalutMealType\").value){\n\t\t\tdocument.getElementById(\"mealClass\").value = document.getElementById(\"defalutMealType\").value;\n\t\t}\n\n\t\tif(document.getElementById(\"profileSL1\") != null && document.getElementById(\"profileSL1\") != \"\")\n\t\t{\n\t\t\tcheckStatus(\"A~F\",document.all(\"status\"));\n\t\t\tdocument.getElementById(\"status\").value=\"A~F\";\n\t\t}\n\n\tfunction setdayRef(obj){\n\t\tdocument.getElementById(\"dayRef\").value=obj.value;\n\t}\n\n\tvar pArgumentArray = new Array();\n\tpArgumentArray[0]=document.getElementById(\"Patient_ID\").value;\n\tpArgumentArray[1]=document.getElementById(\"locationCode\").value;\n\tpArgumentArray[2]=document.getElementById(\"patientClass\").value;\n\tpArgumentArray[3]=document.getElementById(\"locationType\").value;\n\tpArgumentArray[4]=document.getElementById(\"encounterId\").value;\n\n\tfunction callDiagnosis(){\n\t\tvar retVal = new String();\n\t\tvar dialogHeight = \"600px\";\n\t\tvar dialogWidth = \"900px\";\n\t\tvar status = \"no\";\n\t\tvar dialogUrl = \"../../eCA/jsp/PatProblemList.jsp?patient_id=\"+pArgumentArray[0]+\"&location_code=\"+pArgumentArray[1]+\"&patient_class=\"+pArgumentArray[2]+\"&locn_type=\"+pArgumentArray[3]+\"&episode_id=\"+pArgumentArray[4]+\"&modal_yn=Y\";\n\t\tvar dialogArguments = pArgumentArray;\n\t\tvar dialogFeatures = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \" ; scroll=no; status:\" + status;\n\t\twindow.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);\n\t}\n\n\tfunction callDiagnosis1(){\n\t\tvar retVal = new String();\n\t\tvar dialogHeight = \"600px\";\n\t\tvar dialogWidth = \"900px\";\n\t\tvar status = \"no\";\n\t\tvar dialogUrl =  \"../../eCA/jsp/AllergyList.jsp?patient_id=\"+pArgumentArray[0]+\"&called_from_ip=Y\";\n\t\tvar dialogArguments = pArgumentArray;\n\t\tvar dialogFeatures = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \" ; scroll=no; status:\" + status;\n\t\twindow.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);\n\t}\n\t  \n\tfunction restrictSpecialChars(event){\n\t\tvar strCheck = \'~!@#$%^&*()+=`{}|[];:_-,/\\\\?<>\"\\\'\';\n\t\tvar whichCode = (window.Event) ? event.which : event.keyCode;\n\t\tkey = String.fromCharCode(whichCode);  \n\t\tif (strCheck.indexOf(key) != -1) \n\t\t{\n\t\t\twindow.event.keyCode = 27;\n\t\t\treturn false;  \n\t\t}\n\t\treturn true ;\n\t}\n\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t<input type=\"hidden\" name=\"maxprofileSL\" id=\"maxprofileSL\" id=\"maxprofileSL\" value=\"\" />\n \t\t<input type=\"hidden\" name=\"maxActiveprofileSL\" id=\"maxActiveprofileSL\" id=\"maxActiveprofileSL\" value=\"\" /> <!-- AMRI-SCF-0385 [IN:056722] -->\n\t\t<input type=\"hidden\" name=\"dieticianReferral_hidden\" id=\"dieticianReferral_hidden\" id=\"dieticianReferral_hidden\" value=\"\"/><!--CRF-410-->\n\t\t<INPUT type=\"hidden\" name=\"nutrientDeleteFlag\" id=\"nutrientDeleteFlag\" value=\"N\">\n\t\t<INPUT type=\"hidden\" name=\"language_Id\" id=\"language_Id\" id=\"language_Id\" value=\"";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\">\n\t\t<INPUT type=\"hidden\" name=\"attendantAge\" id=\"attendantAge\" id=\"attendantAge\" value=\"";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\"> <!-- ML-MMOH-CRF-746-->\n\t\t<INPUT type=\"hidden\" name=\"yearIntValue\" id=\"yearIntValue\" id=\"yearIntValue\" value=\"";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\"> <!-- ML-MMOH-CRF-746-->\n\t\t<INPUT type=\"hidden\" name=\"monthIntValue\" id=\"monthIntValue\" id=\"monthIntValue\" value=\"";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\"> <!-- ML-MMOH-CRF-746-->\n\t\t<INPUT type=\"hidden\" name=\"dayIntValue\" id=\"dayIntValue\" id=\"dayIntValue\" value=\"";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\"> <!-- ML-MMOH-CRF-746-->\n\t\t<INPUT type=\"hidden\" name=\"attendant_Order_Applicable_Yn\" id=\"attendant_Order_Applicable_Yn\" id=\"attendant_Order_Applicable_Yn\" value=\"";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\"> <!-- ML-MMOH-CRF-746-->\t\t\n\t\t\n\t\t<INPUT type=\"hidden\" name=\"isAttendantAge\" id=\"isAttendantAge\" id=\"isAttendantAge\" value=\"";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\">\n\t\t<INPUT type=\"hidden\" name=\"editMenu_flow_text\" id=\"editMenu_flow_text\" id=\"editMenu_flow_text\" value=\"\"/><!--ML-MMOH-CRF-0669-->\n\t\t<!-- Added Against ML-MMOH-CRF-0671[IN:062266] -->\n\t\t";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\n\t\t\t<INPUT type=\"hidden\" name=\"feedingInstructions\" id=\"feedingInstructions\" id=\"feedingInstructions\" value=\"\">\n\t\t\t<INPUT type=\"hidden\" name=\"feedType\" id=\"feedType\" id=\"feedType\" value=\"\">\n\t\t\t<INPUT type=\"hidden\" name=\"dsDeliveryInstr\" id=\"dsDeliveryInstr\" id=\"dsDeliveryInstr\" value=\"\">\n\t\t";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\n\t\t    <INPUT type=\"hidden\" name=\"isMenuType\" id=\"isMenuType\" id=\"isMenuType\" value=\"";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\">\n\t\t<!-- Added against KDAH-CRF-0352 Starts Here-->\n\t\t    <INPUT type=\"hidden\" name=\"isEditMealType\" id=\"isEditMealType\" id=\"isEditMealType\" value=\"";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\">\t\n\t\t<!-- Added against KDAH-CRF-0352 Ends Here-->\n\t\t\t<INPUT type=\"hidden\" name=\"isDtCat_MlCls\" id=\"isDtCat_MlCls\" id=\"isDtCat_MlCls\" value=\"";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\"> <!-- Added Against KDAH-CRF-349-US5 -->\n\t\t\t<INPUT type=\"hidden\" name=\"isAlaCarte\" id=\"isAlaCarte\" id=\"isAlaCarte\" value=\"";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\"> <!-- Added Against ML-MMOH-CRF-1123-US3 -->\n\t\t<!-- Added against ML-MMOH-CRF-0674 Starts Here-->\n\t\t<INPUT type=\"hidden\" name=\"diettype_auto\" id=\"diettype_auto\" id=\"diettype_auto\" value=\"\">\n\t\t<INPUT type=\"hidden\" name=\"auto_flag\" id=\"auto_flag\" id=\"auto_flag\" value=\"false\">\t\t\t\n\t\t<INPUT type=\"hidden\" name=\"remarkDrugAlert\" id=\"remarkDrugAlert\" value=\"\">\t\t\n\t\t<!-- Added against ML-MMOH-CRF-0674 Ends Here-->\n\t\t<INPUT type=\"hidden\" name=\"isMACNBM\" id=\"isMACNBM\" id=\"isMACNBM\" value=\"";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\"><!--Added Against ML-MMOH-CRF-1460 Starts-->\n\t<script>\n\tfunction calledDietType(){\n\t\tvar isDtCat_MlCls = \"\";\n\t\tif(document.getElementById(\"isDtCat_MlCls\")!=null)\n\t\tisDtCat_MlCls=document.getElementById(\"isDtCat_MlCls\").value;\n\t\t//Added Against ML-MMOH-CRF-1123-US3 Starts Here\n\t\tvar isAlaCarte = \"\";\n\t\tif(document.getElementById(\"isAlaCarte\")!=null)\n\t\tisAlaCarte=document.getElementById(\"isAlaCarte\").value;\t\n\t\t//Added Against ML-MMOH-CRF-1123-US3 Ends Here\n\t\tvar diet_Category1 = \"\";\n\t\tdiet_Category1 = document.getElementById(\"dietCategory1\").value;\n\t\tdiet_Category = document.getElementById(\"dietCategory\").value;\n\t\tvar assign_val = \"\";\n\t\t\tif(isDtCat_MlCls == \"true\" || isDtCat_MlCls == true){\n\t\t\t\tassign_val=diet_Category1;\n\t\t\t\tfecthDietType(assign_val);\n\t\t\t\tfecthDietTypeToMealClass();\n\t\t\t\tfecthMealContents();\n\t\t\t}\n\t\t\t//Added Against ML-MMOH-CRF-1123-US3 Starts Here\n\t\t\tif(isAlaCarte ==true || isAlaCarte == \"true\" ){\n\t\t\t\tassign_val=diet_Category;\n\t\t\t\tfecthDietType(assign_val);\n\t\t\t\tfecthDietTypeToMealClass();\n\t\t\t\tfecthMealContents();\n\t\t\t}\n\t\t\t//Added Against ML-MMOH-CRF-1123-US3 Ends Here\n\t\t}\n\t</script>\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );
 
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
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends  
            _bw.write(_wl_block5Bytes, _wl_block5);
            eDS.DSCommonBean DSCommonBeanObj= null;{
                DSCommonBeanObj=(eDS.DSCommonBean)pageContext.getAttribute("DSCommonBeanObj");
                if(DSCommonBeanObj==null){
                    DSCommonBeanObj=new eDS.DSCommonBean();
                    pageContext.setAttribute("DSCommonBeanObj",DSCommonBeanObj);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
	if(sStyle==null)
		sStyle="IeStyle.css";

	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");

	String strloggeduser	=  (String) httpSession.getValue("login_user");
	String strclientip ="";
	strclientip=p.getProperty("client_ip_address");

	String facility_id	= (String)session.getAttribute("facility_id");
	String language_Id  = (String)session.getAttribute("LOCALE");
	String ward_Code = request.getParameter("locationCode");
	String location_type = request.getParameter("locationType");
	String encounterId=	request.getParameter("encounterId");
	String patientId=	request.getParameter("Patient_ID");
	String patientClass=	request.getParameter("patientClass");//ML-MMOH-CRF-0820	
	String remarks_1 = "";//MMS-KH-CRF-029.1	
	String flag=	request.getParameter("flag");
	String restrict_date_inpatients_yn="Y",maximum_days_allowed="";//ML-MMOH-CRF-0427
	
	//Added Against ML-MMOH-CRF-0672 Starts Here
	String diffDays	= checkForNull(request.getParameter("diffDays"));
	String isLos_gt7  = checkForNull(request.getParameter("isLos_gt7"));
	//Added Against ML-MMOH-CRF-0672 Ends Here
	
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt2 = null;
	PreparedStatement pstmt3 = null;
	PreparedStatement pstmt4 = null;
	PreparedStatement pstmt5 = null;//ML-MMOH-CRF-0427
	PreparedStatement pstmt6 = null;//ML-MMOH-CRF-0746
	PreparedStatement pstmt7 = null;//MMS-KH-CRF-029.1

	ResultSet rs = null;
	ResultSet rs1 = null;
	ResultSet rs2 = null;
	ResultSet rs3 = null;
	ResultSet rs4 = null;
	ResultSet rs5 = null;//ML-MMOH-CRF-0427
	ResultSet rs6 = null;//ML-MMOH-CRF-0746
	ResultSet rs7 = null;//MMS-KH-CRF-029.1
	
	Connection conn = null;
	conn = ConnectionManager.getConnection(request);
	//Added Against Start ML-MMOH-CRF-0684
	boolean isMenuType =false;
	isMenuType = CommonBean.isSiteSpecific(conn,"DS","DS_MENU_TYPE");
	//Added Against End ML-MMOH-CRF-0684
	//Added Against Start KDAH-CRF-0352
	boolean isEditMealType =false;
	isEditMealType = CommonBean.isSiteSpecific(conn,"DS","DS_MEAL_MENU_ITEMS");
	//Added Against End KDAH-CRF-0352

	//Added Against Start KDAH-CRF-0349-US005
	boolean isDtCat_MlCls =false;
	isDtCat_MlCls = CommonBean.isSiteSpecific(conn,"DS","DS_MEAL_MENU_ITEMS");
	String CheckFlag = "";
	if(isDtCat_MlCls == true)
		CheckFlag = "Y";
	else
		CheckFlag = "N";
	//Added Against End KDAH-CRF-0349-US005

	//Added Against ML-MMOH-CRF-1123-US3 Starts Here
	boolean isAlaCarte=false;
	isAlaCarte=CommonBean.isSiteSpecific(conn,"DS","PLACE_ORDER_FOR_ATTENDANT");
	String CheckFlag1 = "";
	if(isAlaCarte == true)
		CheckFlag1 = "Y";
	else
		CheckFlag1 = "N";

	String alaCarte = checkForNull(request.getParameter("alaCarte"));
	//Added Against ML-MMOH-CRF-1123-US3 Ends Here
	
	//Added Against ML-MMOH-SCF-1676 Starts
	boolean isEnteral = false;
	isEnteral = CommonBean.isSiteSpecific(conn,"DS","DS_DIET_ENTERAL");
	
	//Added by Santhosh for ML-MMOH-SCF-2331 
	boolean isSpecialDiet = false;
	isSpecialDiet = CommonBean.isSiteSpecific(conn,"DS","SPECIAL_DIET_CATEGORY");
	
	//Added Against ML-MMOH-SCF-1676 Ends
	
	//Added Against ML-MMOH-CRF-1460 Starts
	boolean isMACNBM = false;
	isMACNBM = CommonBean.isSiteSpecific(conn,"DS","DS_MAC_NBM");
	//Added Against ML-MMOH-SCF-1460 Ends
	
	//Added Against ML-MMOH-CRF-1780...starts
	boolean isDateLabel = false;
	isDateLabel = CommonBean.isSiteSpecific(conn,"DS","DS_DATE_LABEL");
	System.err.println("isDateLabel --->"+isDateLabel);
	//Added Against ML-MMOH-CRF-1780...ends
	
	System.out.println("isMACNBM in PlaceDietOrderCUD.jsp : "+isMACNBM);
	String kitchen_Code =  "";
	String prfSL = "";
	String acceptDietForIndMealYn = "";
	String graceAplYN = "";
	boolean profileFlag=true;//ML-MMOH-CRF-0427
	String GEN_MEALPLAN_FOR_NBM_PAT_YN="";//MMS-QH-CRF-0078.1-US003
	String IRREGULAR_DIET_ORD_YN="",IRREGULAR_MEAL_ORD_MESSAGE="";//ML-MMOH-CRF-409
	String Attendent_Label_Name="";//ML-MMOH-CRF-0406
	String No_Of_Attendant="";//ML-MMOH-CRF-0412
	int periodHr = 0;
	String servingDate="";		
	//ML-MMOH-CRF-0406 STARTS
	String AttendantInstr=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDS.PCTAttendantInstr.Label","ds_labels");		
	//ML-MMOH-CRF-0406 ENDS
	//ML-MMOH-CRF-0746
	String attendantAge="";
	String yearValue ="0",monthValue="0",dayValue="0";
	String attendInstru ="";//SCF-735
	int yearIntValue =0;
	int monthIntValue =0;
	int dayIntValue =0;	
	int mc_defaultcount=0;//Added Against ML-MMOH-CRF-1005-US2
	boolean isAttendantAge = false;
	isAttendantAge = CommonBean.isSiteSpecific(conn,"DS","PLACE_ORDER_FOR_ATTENDANT");//Using same function for Selayang
	//ML-MMOH-CRF-0746
	//Added Against Start CRF-673 
	String bed  = checkForNull(request.getParameter("bed"));
	String bedClassCode ="";
	String meal_class_code="";
	String meal_class_desc="";
	String enableDrugFoodYN="";//MMS-KH-CRF-0029.1-US008
	//ArrayList<String> list =new  ArrayList<String>(); 
	// Added Against End CRF-673	
	try{
		// Added Against Start 673-CRF 
		bedClassCode = DSCommonBeanObj.getIPBedClass(ward_Code,bed,facility_id); //Added Against CRF-673
		if(bedClassCode!=null && bedClassCode.length()>0){		
			String sql_meal="SELECT MEAL_CLASS,SHORT_DESC FROM DS_MEAL_CLASS WHERE BED_CLASS_CODE like '%"+bedClassCode+"%' ";
			pstmt1 = conn.prepareStatement(sql_meal);
			rs1	= pstmt1.executeQuery();
			if (rs1!= null && rs1.next()){
			  meal_class_code = rs1.getString("MEAL_CLASS");				
			  meal_class_desc = rs1.getString("SHORT_DESC");				
			}
		}

		// Added Against End 673-CRF 
	String sql_ward_Code = "select ward_Code, kitchen_Code from Ds_Wards_For_Kitchen where operating_Facility_Id ='"+facility_id+"' and ward_Code ='"+ward_Code+"'";
	String profileSL_query = "";
	//Added Against ML-MMOH-CRF-1460 Starts
	 if(isMACNBM)
	{
		 profileSL_query = "SELECT NVL(MAX (profile_sl),0) max_profile_sl FROM (SELECT NVL (MAX (a.profile_sl), 0) profile_sl FROM ds_epsd_diet_profile_hdr a WHERE a.encounter_id = '"+encounterId+"' AND a.operating_facility_id = '"+facility_id+"' UNION SELECT NVL (MAX (b.profile_sl), 0) profile_sl FROM ds_epsd_nbm_profile b WHERE b.encounter_id = '"+encounterId+"' AND b.operating_facility_id = '"+facility_id+"' UNION SELECT NVL (MAX (a.profile_sl), 0) profile_sl FROM ds_epsd_diet_profile_att a WHERE a.encounter_id = '"+encounterId+"' AND a.operating_facility_id = '"+facility_id+"')";
	}
	//Added Against ML-MMOH-CRF-1460 Ends
	else{ 
	 profileSL_query = "SELECT NVL(MAX (profile_sl),0) max_profile_sl FROM (SELECT NVL (MAX (a.profile_sl), 0) profile_sl FROM ds_epsd_diet_profile_hdr a WHERE a.encounter_id = '"+encounterId+"' AND a.operating_facility_id = '"+facility_id+"' UNION SELECT NVL (MAX (b.profile_sl), 0) profile_sl FROM ds_epsd_nbm_profile b WHERE b.encounter_id = '"+encounterId+"' AND b.operating_facility_id = '"+facility_id+"')";//CRF-410
	}
	String profileFlag_query="select * from ds_epsd_diet_profile_hdr where encounter_id='"+encounterId+"' AND nvl(status, 'ZZ') <> 'X' and trunc(sysdate) between period_from AND nvl(period_to,to_date('31/12/2999','DD/MM/YYYY')) order by MODIFIED_DATE";//ML-MMOH-CRF-0427

	String acceptMealDiet_query = "select ACCEPT_DIET_FOR_IND_MEAL_YN from DS_PARAM_FOR_FACILITY where OPERATING_FACILITY_ID = '"+facility_id+"'";

	String gPQuery = "select GRACE_PERIOD_APPLICABLE_YN,GRACE_PERIOD,restrict_date_inpatients_yn,nvl(maximum_days_allowed,'1') maximum_days_allowed,GEN_MEALPLAN_FOR_NBM_PAT_YN,LATE_IRREGULAR_DIET_ORD_FOR_IP,IRREGULAR_MEAL_ORD_MESSAGE,Attendent_Label_Name,NVL(No_Of_Attendant,'0') No_Of_Attendant, ENABLE_DRUG_FOOD_YN from DS_PARAM_FOR_FACILITY where OPERATING_FACILITY_ID = '"+facility_id+"'";//ML-MMOH-CRF-0427 and  MMS-QH-CRF-0078.1-US003 and ML-MMOH-CRF-409 and ML-MMOH-CRF-0406 and ML-MMOH-CRF-0412 & ICN 72081

	//ML-MMOH-CRF-0746
	   if(isAttendantAge){		
		String sql_age="select mp_get_age_ymdh(b.date_of_birth) age from mp_patient b where patient_id = '"+patientId+"'";
		
		pstmt6 = conn.prepareStatement(sql_age);
		rs6	= pstmt6.executeQuery();

		if (rs6!= null && rs6.next()){
			attendantAge = rs6.getString("age");				
		 }
		  
		 int yearindx =0; int monthindx =0; int days=0;
		 
		 if(attendantAge.contains("Y")){
			yearindx=attendantAge.indexOf("Y");
			if(yearindx>0)
			yearValue=attendantAge.substring(0,yearindx);
			yearValue = yearValue.trim();
		  }  
		  
		if(attendantAge.contains("M")){
			monthindx=attendantAge.indexOf("M");
		if(monthindx>0 && yearindx!=0)			monthValue=attendantAge.substring(++yearindx,monthindx);monthValue = monthValue.trim();
		//monthValue=attendantAge.substring(0,monthindx);
		if(yearindx==0)  monthValue=attendantAge.substring(0,monthindx); monthValue =		monthValue.trim();			  
		  }  
		if(attendantAge.contains("D")){
			days=attendantAge.indexOf("D");

		if(days>0 && monthindx>0 &&yearindx==0){
			dayValue=attendantAge.substring(++monthindx,days);dayValue = dayValue.trim();
			}
			if(days>0 && yearindx!=0 && monthindx<=0){dayValue=attendantAge.substring(++yearindx,days);dayValue = dayValue.trim();
			}
			 if(days>0 && yearindx<=0 && monthindx<=0){dayValue=attendantAge.substring(0,days);dayValue = dayValue.trim();
			 }		
		  } 		 
		}

		yearIntValue = Integer.parseInt(yearValue);
		monthIntValue = Integer.parseInt(monthValue);
		dayIntValue = Integer.parseInt(dayValue);

		//ML-MMOH-CRF-0746
		pstmt = conn.prepareStatement(sql_ward_Code);
		pstmt1 = conn.prepareStatement(profileSL_query);
		pstmt2 = conn.prepareStatement(acceptMealDiet_query);
		pstmt3 = conn.prepareStatement(gPQuery);
		pstmt4 = conn.prepareStatement("SELECT to_char(SYSDATE,'dd/mm/yyyy') CURRENT_DATE FROM DUAL");
		pstmt5 = conn.prepareStatement(profileFlag_query);//ML-MMOH-CRF-0427
					
		rs	= pstmt.executeQuery();
		rs1	= pstmt1.executeQuery();
		rs2	= pstmt2.executeQuery();
		rs3	= pstmt3.executeQuery();
		rs4	= pstmt4.executeQuery();
		rs5	= pstmt5.executeQuery();//ML-MMOH-CRF-0427
					
		while(rs != null && rs.next()){
			ward_Code=rs.getString(1);
			kitchen_Code=rs.getString(2);
		}
		while(rs1 != null && rs1.next()){
			prfSL = rs1.getString(1);
			
		}
		if(rs2 != null && rs2.next()){
			acceptDietForIndMealYn = rs2.getString(1);
		}
		if(rs3 != null && rs3.next()){
			graceAplYN = rs3.getString(1);
			periodHr = rs3.getInt(2);
			//ML-MMOH-CRF-0427

			maximum_days_allowed=checkForNull(rs3.getString("maximum_days_allowed"));
			maximum_days_allowed=""+(Integer.parseInt(maximum_days_allowed)-1);
			//ML-MMOH-CRF-0427
			GEN_MEALPLAN_FOR_NBM_PAT_YN=checkForNull(rs3.getString("GEN_MEALPLAN_FOR_NBM_PAT_YN"));
			//ML-MMOH-CRF-409 -STARTS
			IRREGULAR_DIET_ORD_YN=checkForNull(rs3.getString("LATE_IRREGULAR_DIET_ORD_FOR_IP"));
			IRREGULAR_MEAL_ORD_MESSAGE=checkForNull(rs3.getString("IRREGULAR_MEAL_ORD_MESSAGE"));
			//ML-MMOH-CRF-409 -ENDS				
			Attendent_Label_Name=rs3.getString("Attendent_Label_Name");//ML-MMOH-CRF-0406
			enableDrugFoodYN =rs3.getString("ENABLE_DRUG_FOOD_YN");//MMS-KH-CRF-0029.1-US008
			AttendantInstr=AttendantInstr.replace("#",Attendent_Label_Name);
			No_Of_Attendant=rs3.getString("No_Of_Attendant");//ML-MMOH-CRF-0412
		}
		while(rs4.next()){
			servingDate = rs4.getString("CURRENT_DATE");
		}
		//ML-MMOH-CRF-0427
		if(rs5.next()){
			profileFlag=false;
		}
		//SCF-735
		
		while(rs5 != null && rs5.next()){
			attendInstru =checkForNull(rs5.getString("ATNDNT_INSTR"));			
		}
		//SCF-735
		if(restrict_date_inpatients_yn.equals("Y")){
			profileFlag=true;
		}
		else
		{
			profileFlag=false;
		}
		//ML-MMOH-CRF-0427
		//Added against MMS-KH-CRF-0029.1 Starts Here
		String sql_rem="SELECT remarks FROM ds_epsd_diet_profile_hdr WHERE encounter_id = '"+encounterId+"' AND profile_sl = '"+prfSL+"' ";
		pstmt7 = conn.prepareStatement(sql_rem);
		rs7	= pstmt7.executeQuery();
		while(rs7 != null && rs7.next()){
		remarks_1=rs7.getString(1);
		//Added against MMS-KH-CRF-0029.1 Ends Here
	} 
	}
	catch(Exception e){
		System.err.println("PlaceDietOrderCUD.jsp====="+e.getMessage());
		e.printStackTrace();
	}
	finally	{
		if(pstmt != null){
			pstmt.close();
		}
		if(conn != null){
			conn.close();
		}
	}
 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(language_Id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(attendantAge));
            _bw.write(_wl_block10Bytes, _wl_block10);

		if(isMACNBM) //Added Against ICN:17117 ML-MMOH-CRF-1460
		{
	
            _bw.write(_wl_block11Bytes, _wl_block11);
}
	else{
	
            _bw.write(_wl_block12Bytes, _wl_block12);
	
	}
	
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Attendent_Label_Name));
            _bw.write(_wl_block15Bytes, _wl_block15);

						String accept_Diet_For_Ind_Meal_Yn = null;
						String attendant_Order_Applicable_Yn = null;
						try{
							conn = ConnectionManager.getConnection(request);
							String attendentStatus = "select paramFacility.attendant_Order_Applicable_Yn, paramFacility.accept_Diet_For_Ind_Meal_Yn from Ds_Param_For_Facility paramFacility where paramFacility.operating_Facility_Id ='"+facility_id+"'";
							pstmt = conn.prepareStatement(attendentStatus);
							rs	= pstmt.executeQuery();
							while(rs != null && rs.next()) {
								attendant_Order_Applicable_Yn = rs.getString(1);
								accept_Diet_For_Ind_Meal_Yn = rs.getString(2);
							}
						}catch(Exception e){
							e.printStackTrace();
						}
						finally{
							conn.close();
							pstmt.close();
						}
					
            _bw.write(_wl_block16Bytes, _wl_block16);

					   if(!isAttendantAge){
					
            _bw.write(_wl_block16Bytes, _wl_block16);

						if(attendant_Order_Applicable_Yn!=null  && !(attendant_Order_Applicable_Yn.equals("")) && attendant_Order_Applicable_Yn.equals("Y"))										{
					
            _bw.write(_wl_block17Bytes, _wl_block17);

						}
					   else {									      
					
            _bw.write(_wl_block18Bytes, _wl_block18);
}
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block16Bytes, _wl_block16);

						 if(isAttendantAge && (attendant_Order_Applicable_Yn!=null  && !(attendant_Order_Applicable_Yn.equals("")) &&      attendant_Order_Applicable_Yn.equals("Y"))) {
					
            _bw.write(_wl_block19Bytes, _wl_block19);
	if (yearIntValue<18) 
						{
												
					
            _bw.write(_wl_block20Bytes, _wl_block20);
} else if( yearIntValue == 18 && monthIntValue == 0 && dayIntValue == 0) {
						
            _bw.write(_wl_block21Bytes, _wl_block21);
}else if ((yearIntValue>18) || (yearIntValue == 18 && monthIntValue >0) ||(yearIntValue == 18 && dayIntValue > 0)){
            _bw.write(_wl_block22Bytes, _wl_block22);
}
						}if(isAttendantAge && (attendant_Order_Applicable_Yn!=null  && !(attendant_Order_Applicable_Yn.equals("")) &&      attendant_Order_Applicable_Yn.equals("N"))) {
						
            _bw.write(_wl_block23Bytes, _wl_block23);
}
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
if(isMenuType) { 
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

					try{
						conn = ConnectionManager.getConnection(request);
						String MenuTypecode = "";
						String MenuTypedescription =  "";
						String sql_Menu_Count="SELECT count(*) FROM ds_menu_type where eff_status ='E' and appl_for_ip_yn ='Y' AND DEFAULT_YN='Y'";

						pstmt = conn.prepareStatement(sql_Menu_Count);
						rs	= pstmt.executeQuery();
						int defaultcount=0;
						if(rs.next()){
							defaultcount=rs.getInt(1);
						}

						String sql_Menu_Type = "SELECT menu_type,short_desc,DEFAULT_YN FROM ds_menu_type where eff_status ='E' and appl_for_ip_yn ='Y' ORDER BY short_desc asc";

						pstmt = conn.prepareStatement(sql_Menu_Type);
						rs	= pstmt.executeQuery();
						while(rs != null && rs.next()){
							MenuTypecode=rs.getString(1);
							MenuTypedescription=rs.getString(2);
						String temp=rs.getString(3);
						if(defaultcount == 1 && temp.equals("Y"))
						{									
						 
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(MenuTypecode));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(MenuTypedescription));
            _bw.write(_wl_block31Bytes, _wl_block31);

						}
						else
						{								
						
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(MenuTypecode));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(MenuTypedescription));
            _bw.write(_wl_block34Bytes, _wl_block34);

						}
						}
						}
						catch(Exception e){
							e.printStackTrace();
						}
						finally	{
							if(pstmt != null){
								pstmt.close();
							}
							if(conn != null){
								conn.close();
							}
						}
					 
            _bw.write(_wl_block35Bytes, _wl_block35);
}
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);

	try{
		conn = ConnectionManager.getConnection(request);
		String dietCategoryCode = "";
		String description =  "";		
		String sql_diet_Category;
		//Modified Against ML-MMOH-CRF-1123-US3 Starts Here
		if(CheckFlag1.equalsIgnoreCase("Y")){
			if(alaCarte.equalsIgnoreCase("NAC"))
			{
				sql_diet_Category = "select diet_Category_Code, ds_get_desc.ds_diet_category(diet_Category_Code,?, 1) description from Ds_Diet_Category where diet_category_code != 'ALAC'";
				}
			else{
				sql_diet_Category = "select diet_Category_Code, ds_get_desc.ds_diet_category(diet_Category_Code,?, 1) description from Ds_Diet_Category";
				}
			}else{
				sql_diet_Category = "select diet_Category_Code, ds_get_desc.ds_diet_category(diet_Category_Code,?, 1) description from Ds_Diet_Category";
				}
		pstmt = conn.prepareStatement(sql_diet_Category);
		pstmt.setString(1,language_Id);
		rs	= pstmt.executeQuery();
		while(rs != null && rs.next()){
		dietCategoryCode=rs.getString(1);
		description=rs.getString(2);
		
	//Added by Santhosh for ML-MMOH-SCF-2331
	if(isSpecialDiet){
		if(!dietCategoryCode.equals("SD01")){	
	if(dietCategoryCode.equalsIgnoreCase("ALAC") && (CheckFlag1.equalsIgnoreCase("Y"))){
		if(alaCarte.equalsIgnoreCase("AC")){
	
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dietCategoryCode));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(description));
            _bw.write(_wl_block40Bytes, _wl_block40);
 }else{
	
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dietCategoryCode));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(description));
            _bw.write(_wl_block40Bytes, _wl_block40);
 }
	}
	else if(dietCategoryCode.equals("THEU") && (CheckFlag.equals("Y"))) {
	
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(dietCategoryCode));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(description));
            _bw.write(_wl_block40Bytes, _wl_block40);
	
	}else{				
	
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dietCategoryCode));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(description));
            _bw.write(_wl_block44Bytes, _wl_block44);

		} //end of else condition					
		} //End of dietCategoryCode
		} else if(isEnteral){//Added Against ML-MMOH-CRF-1123-US3 Starts Here
		if(!dietCategoryCode.equals("ENTE")){	//Added Against ML-MMOH-SCF-1676
	if(dietCategoryCode.equalsIgnoreCase("ALAC") && (CheckFlag1.equalsIgnoreCase("Y"))){
		if(alaCarte.equalsIgnoreCase("AC")){
	
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dietCategoryCode));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(description));
            _bw.write(_wl_block40Bytes, _wl_block40);
 }else{
	
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dietCategoryCode));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(description));
            _bw.write(_wl_block40Bytes, _wl_block40);
 }
	}
	//Added Against ML-MMOH-CRF-1123-US3 Ends Here
	//Added Against Start KDAH-CRF-349-US5
	else if(dietCategoryCode.equals("THEU") && (CheckFlag.equals("Y"))) {
	
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(dietCategoryCode));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(description));
            _bw.write(_wl_block40Bytes, _wl_block40);
	
	}else{				
	
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dietCategoryCode));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(description));
            _bw.write(_wl_block44Bytes, _wl_block44);

		} //end of else condition					
		} //End of dietCategoryCode
		} //End of Enteral	  
	 else{
		 if(dietCategoryCode.equalsIgnoreCase("ALAC") && (CheckFlag1.equalsIgnoreCase("Y"))){
		if(alaCarte.equalsIgnoreCase("AC")){
	
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dietCategoryCode));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(description));
            _bw.write(_wl_block40Bytes, _wl_block40);
 }else{
	
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dietCategoryCode));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(description));
            _bw.write(_wl_block40Bytes, _wl_block40);
 }
	}
	//Added Against ML-MMOH-CRF-1123-US3 Ends Here
	//Added Against Start KDAH-CRF-349-US5
	else if(dietCategoryCode.equals("THEU") && (CheckFlag.equals("Y"))) {
	
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(dietCategoryCode));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(description));
            _bw.write(_wl_block40Bytes, _wl_block40);
	
	}else{				
	
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dietCategoryCode));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(description));
            _bw.write(_wl_block44Bytes, _wl_block44);

		}
	 }
	} //end of while condition
	
	
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(dietCategoryCode));
            _bw.write(_wl_block46Bytes, _wl_block46);

			}catch(Exception e){
				e.printStackTrace();
			}finally{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}
	
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

						if(restrict_date_inpatients_yn.equals("Y") && profileFlag){
					
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(maximum_days_allowed));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(language_Id));
            _bw.write(_wl_block51Bytes, _wl_block51);
		
						}else{
					
            _bw.write(_wl_block52Bytes, _wl_block52);
	
						}
					
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

						if(restrict_date_inpatients_yn.equals("Y") && profileFlag){
					
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(maximum_days_allowed));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(language_Id));
            _bw.write(_wl_block57Bytes, _wl_block57);
	
						}else{
					
            _bw.write(_wl_block58Bytes, _wl_block58);
	
					}
					
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);

	try{
		conn = ConnectionManager.getConnection(request);
		String mealClass = "";
		String description =  "";

		String sql_meal_Class = "select meal_Class,ds_get_desc.ds_meal_class(meal_Class,'"+language_Id+"', 2)  short_Desc from Ds_Meal_Class where eff_Status ='E'";

		pstmt = conn.prepareStatement(sql_meal_Class);
		rs	= pstmt.executeQuery();
		while(rs != null && rs.next()){
		mealClass=rs.getString(1);
		description=rs.getString(2);
	if(mealClass.equals(meal_class_code)){
		
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(mealClass));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(description));
            _bw.write(_wl_block63Bytes, _wl_block63);
}else{
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(mealClass));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(description));
            _bw.write(_wl_block65Bytes, _wl_block65);
}
	}
	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally	{
		if(pstmt != null){																	pstmt.close();
			}
			if(conn != null){
				conn.close();
			}
		}
	 
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);
if(!isAttendantAge){
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);

				try{
					conn = ConnectionManager.getConnection(request);
					String feedType = "";
					String description =  "";
					String sql_feed_Type = "select feed_Type, ds_get_desc.ds_feed_type(feed_Type,'"+language_Id+"', 2)  short_Desc from Ds_Feed_Type where eff_Status='E'";
					pstmt = conn.prepareStatement(sql_feed_Type) ;
					rs	= pstmt.executeQuery();
					while(rs != null && rs.next()){
						feedType=rs.getString(1);
						description=rs.getString(2);
			 
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(feedType));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(description));
            _bw.write(_wl_block75Bytes, _wl_block75);

				}
				}
				catch(Exception e){
					e.printStackTrace();
				}
				finally	{
					if(pstmt != null){
						pstmt.close();
					}
					if(conn != null){
						conn.close();
					}
				}
			 
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

						try{
							conn = ConnectionManager.getConnection(request);
							String instrCode = "";
							String description =  "";
							String sql_Delivery_Instr = "select substr(ds_get_desc.ds_delivery_instr(instr_Code,'"+language_Id+"', 1) ,1,30), instr_Code from Ds_Delivery_Instr  where eff_Status ='E'";
							pstmt = conn.prepareStatement(sql_Delivery_Instr) ;
							rs	= pstmt.executeQuery();
							while(rs != null && rs.next()){
								description=rs.getString(1);
								instrCode=rs.getString(2);
					 
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(instrCode));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(description));
            _bw.write(_wl_block79Bytes, _wl_block79);

						}
						}
						catch(Exception e){
							e.printStackTrace();
						}
						finally	{
							if(pstmt != null){
								pstmt.close();
							}
							if(conn != null){
								conn.close();
							}
						}
					 
            _bw.write(_wl_block80Bytes, _wl_block80);
}else{
            _bw.write(_wl_block81Bytes, _wl_block81);
}
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);

				try{
					conn = ConnectionManager.getConnection(request);
					String texture_code = "";
					String texture_description =  "";
					String sql_texture_of_diet = "select texture_of_diet,short_desc from ds_texture_of_diet_lang_vw where language_Id like '"+language_Id+"' and eff_status='E' order by short_desc ASC";
					pstmt = conn.prepareStatement(sql_texture_of_diet) ;
					rs	= pstmt.executeQuery();
					while(rs != null && rs.next()){
						texture_code=rs.getString(1);
						texture_description=rs.getString(2);				
			 
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(texture_code));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(texture_description));
            _bw.write(_wl_block87Bytes, _wl_block87);

				}
				}
				catch(Exception e){
					e.printStackTrace();
				}
				finally	{
					if(pstmt != null){
						pstmt.close();
					}
					if(conn != null){
						conn.close();
					}
				}
			 
            _bw.write(_wl_block88Bytes, _wl_block88);
if(!isAttendantAge){
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);
}
            _bw.write(_wl_block91Bytes, _wl_block91);
if(isAttendantAge){
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);
}else{
            _bw.write(_wl_block93Bytes, _wl_block93);
if(isDtCat_MlCls){
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
}else{
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
}
            _bw.write(_wl_block94Bytes, _wl_block94);
}
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block96Bytes, _wl_block96);
if(isMenuType) {
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);

				try{
					conn = ConnectionManager.getConnection(request);
					String MenuTypecode = "";
					String MenuTypedescription =  "";
					String sql_Menu_Count="SELECT count(*) FROM ds_menu_type where eff_status ='E' and appl_for_ip_yn ='Y' AND DEFAULT_YN='Y'";
					pstmt = conn.prepareStatement(sql_Menu_Count);
					rs	= pstmt.executeQuery();
					int defaultcount=0;
					if(rs.next()){
						defaultcount=rs.getInt(1);
						}
					
					String sql_Menu_Type = "SELECT menu_type,short_desc,DEFAULT_YN FROM ds_menu_type where eff_status ='E' and appl_for_ip_yn ='Y' ORDER BY short_desc asc";
					pstmt = conn.prepareStatement(sql_Menu_Type);
					rs	= pstmt.executeQuery();
					while(rs != null && rs.next()){
						MenuTypecode=rs.getString(1);
						MenuTypedescription=rs.getString(2);
					String temp=rs.getString(3);
				if(defaultcount == 1 && temp.equals("Y"))
				{
			 
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(MenuTypecode));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(MenuTypedescription));
            _bw.write(_wl_block87Bytes, _wl_block87);

				}
				else
				{
			
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(MenuTypecode));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(MenuTypedescription));
            _bw.write(_wl_block87Bytes, _wl_block87);

				}
				}
				}
				catch(Exception e){
					e.printStackTrace();
				}
				finally	{
					if(pstmt != null){
						pstmt.close();
					}
					if(conn != null){
						conn.close();
					}
				}
			 
            _bw.write(_wl_block100Bytes, _wl_block100);
}
            _bw.write(_wl_block101Bytes, _wl_block101);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block102Bytes, _wl_block102);

		if(restrict_date_inpatients_yn.equals("Y") && profileFlag){
	
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(maximum_days_allowed));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(language_Id));
            _bw.write(_wl_block104Bytes, _wl_block104);

	}else{
	
            _bw.write(_wl_block105Bytes, _wl_block105);

	}
	
            _bw.write(_wl_block106Bytes, _wl_block106);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);

		if(restrict_date_inpatients_yn.equals("Y") && profileFlag){
	
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(maximum_days_allowed));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(language_Id));
            _bw.write(_wl_block109Bytes, _wl_block109);
			
		}else{
	
            _bw.write(_wl_block110Bytes, _wl_block110);
															
		}
	
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block112Bytes, _wl_block112);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);

				try{
						conn = ConnectionManager.getConnection(request);
						String dietCategoryCode = "";
						String description =  "";
						String sql_diet_Category = "select diet_Category_Code, ds_get_desc.ds_diet_category(diet_Category_Code,'"+language_Id+"', 1) description from Ds_Diet_Category where diet_Category_Code in (SELECT diet_Category_Code FROM ds_diet_type WHERE NVL (appl_att_yn, 'N') = 'Y')";//ML-MMOH-SCF-1046
						
						pstmt = conn.prepareStatement(sql_diet_Category);
						rs	= pstmt.executeQuery();
						while(rs != null && rs.next()){
						dietCategoryCode=rs.getString(1);
						description=rs.getString(2);
			
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(dietCategoryCode));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(description));
            _bw.write(_wl_block114Bytes, _wl_block114);

					}
					}
					catch(Exception e){
						e.printStackTrace();
					}
					finally	{
						if(pstmt != null){
							pstmt.close();
						}
						if(conn != null){
							conn.close();
						}
					}
			
            _bw.write(_wl_block115Bytes, _wl_block115);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block117Bytes, _wl_block117);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block118Bytes, _wl_block118);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);

	String attendentmealClass = "";
	String attendentdescription = "";
	try{
		conn = ConnectionManager.getConnection(request);
		//Modified Against ML-MMOH-CRF-1005-US2 Starts Here
		String sql_MealClass_Count="SELECT count(*) FROM ds_meal_class where eff_status ='E' and APPL_ATT_YN ='Y'";
		pstmt = conn.prepareStatement(sql_MealClass_Count);
		rs	= pstmt.executeQuery();
		if(rs.next()){
		mc_defaultcount=rs.getInt(1);
		}
		String sql_meal_Class = "select meal_Class,ds_get_desc.ds_meal_class(meal_Class,'"+language_Id+"', 2)  short_Desc from Ds_Meal_Class where eff_Status ='E' and APPL_ATT_YN='Y'";
		pstmt = conn.prepareStatement(sql_meal_Class);
		rs	= pstmt.executeQuery();
		while(rs != null && rs.next()){
		attendentmealClass=rs.getString(1);
		attendentdescription=rs.getString(2);
	if(mc_defaultcount == 1)
	{

            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(attendentmealClass));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(attendentdescription));
            _bw.write(_wl_block121Bytes, _wl_block121);

		}
		else
		{

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(attendentmealClass));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(attendentdescription));
            _bw.write(_wl_block123Bytes, _wl_block123);

	}
	//Modified Against ML-MMOH-CRF-1005-US2 Ends Here
	}
	}
	catch(Exception e){
	e.printStackTrace();
	}
	finally	{
	if(pstmt != null){																pstmt.close();
	}
	if(conn != null){
	conn.close();
	}
	}

            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(mc_defaultcount));
            _bw.write(_wl_block125Bytes, _wl_block125);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(AttendantInstr));
            _bw.write(_wl_block127Bytes, _wl_block127);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block129Bytes, _wl_block129);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block130Bytes, _wl_block130);

					if(restrict_date_inpatients_yn.equals("Y") && profileFlag){
				
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(maximum_days_allowed));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(language_Id));
            _bw.write(_wl_block132Bytes, _wl_block132);

				}else{
				
            _bw.write(_wl_block133Bytes, _wl_block133);

				}
				
            _bw.write(_wl_block134Bytes, _wl_block134);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block135Bytes, _wl_block135);

					if(restrict_date_inpatients_yn.equals("Y") && profileFlag){
				
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(maximum_days_allowed));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(language_Id));
            _bw.write(_wl_block137Bytes, _wl_block137);

				}else{
				
            _bw.write(_wl_block138Bytes, _wl_block138);

				}
				
            _bw.write(_wl_block139Bytes, _wl_block139);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block140Bytes, _wl_block140);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block141Bytes, _wl_block141);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block142Bytes, _wl_block142);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block143Bytes, _wl_block143);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block144Bytes, _wl_block144);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block145Bytes, _wl_block145);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block146Bytes, _wl_block146);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block147Bytes, _wl_block147);

							if(isDateLabel){  
							
            _bw.write(_wl_block148Bytes, _wl_block148);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block149Bytes, _wl_block149);

							  }else{
							
            _bw.write(_wl_block148Bytes, _wl_block148);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block150Bytes, _wl_block150);

							  }
							
            _bw.write(_wl_block148Bytes, _wl_block148);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block151Bytes, _wl_block151);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block152Bytes, _wl_block152);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block153Bytes, _wl_block153);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block153Bytes, _wl_block153);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block154Bytes, _wl_block154);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(Attendent_Label_Name));
            _bw.write(_wl_block156Bytes, _wl_block156);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block157Bytes, _wl_block157);

							if(restrict_date_inpatients_yn.equals("Y") && profileFlag){
						
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(maximum_days_allowed));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(language_Id));
            _bw.write(_wl_block159Bytes, _wl_block159);
	
					}else{
					
            _bw.write(_wl_block160Bytes, _wl_block160);
	
						}
					
            _bw.write(_wl_block161Bytes, _wl_block161);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block162Bytes, _wl_block162);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block163Bytes, _wl_block163);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block164Bytes, _wl_block164);
            _bw.write(_wl_block165Bytes, _wl_block165);

            if (_jsp__tag59(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block166Bytes, _wl_block166);
            _bw.write(_wl_block167Bytes, _wl_block167);

            if (_jsp__tag60(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block168Bytes, _wl_block168);
            _bw.write(_wl_block169Bytes, _wl_block169);
            _bw.write(_wl_block170Bytes, _wl_block170);

            if (_jsp__tag61(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block171Bytes, _wl_block171);
if (prfSL!=null && !prfSL.equals("") && !prfSL.equals("0")) { 
            _bw.write(_wl_block172Bytes, _wl_block172);

            if (_jsp__tag62(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block173Bytes, _wl_block173);
} 
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(patientClass));
            _bw.write(_wl_block175Bytes, _wl_block175);

            if (_jsp__tag63(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block176Bytes, _wl_block176);

            if (_jsp__tag64(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block177Bytes, _wl_block177);

            if (_jsp__tag65(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block178Bytes, _wl_block178);

            if (_jsp__tag66(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block179Bytes, _wl_block179);

            if (_jsp__tag67(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(language_Id));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(kitchen_Code));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(prfSL));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(remarks_1));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(prfSL));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(patientClass));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(ward_Code));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(strloggeduser));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(strclientip));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(acceptDietForIndMealYn));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(graceAplYN));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(periodHr));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(flag));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(servingDate));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(profileFlag));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(restrict_date_inpatients_yn));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(maximum_days_allowed));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(GEN_MEALPLAN_FOR_NBM_PAT_YN));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(IRREGULAR_DIET_ORD_YN));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(IRREGULAR_MEAL_ORD_MESSAGE));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(No_Of_Attendant));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(Attendent_Label_Name));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(enableDrugFoodYN));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(diffDays));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(isLos_gt7));
            _bw.write(_wl_block209Bytes, _wl_block209);

            if (_jsp__tag68(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block210Bytes, _wl_block210);

            if (_jsp__tag69(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block211Bytes, _wl_block211);

            if (_jsp__tag70(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block212Bytes, _wl_block212);

            if (_jsp__tag71(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block213Bytes, _wl_block213);

            if (_jsp__tag72(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block214Bytes, _wl_block214);

            if (_jsp__tag73(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(language_Id));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(attendantAge));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(yearIntValue));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(monthIntValue));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(dayIntValue));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(attendant_Order_Applicable_Yn));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(isAttendantAge));
            _bw.write(_wl_block222Bytes, _wl_block222);
if(isAttendantAge){
            _bw.write(_wl_block223Bytes, _wl_block223);
}
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(isMenuType));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(isEditMealType));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(isDtCat_MlCls));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(isAlaCarte));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(isMACNBM));
            _bw.write(_wl_block229Bytes, _wl_block229);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patient.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.patientOptionTitle.Label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.MenuType.Label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.DietCategory.Label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fromdate.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.todate.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ReferredToDietician.Label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.MealClass.Label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.DietType.Label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.FullNilByMouth.Label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.FeedType.Label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.deliveryInstruction.Label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.TextureOfDiet.Label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.feedingInstruction.Label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.Remarks.Label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.NutritionalDiagnosis.Label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.preparatoryInstruction.Label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.MenuType.Label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fromdate.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.todate.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.DietCategory.Label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.DietType.Label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.MealClass.Label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AttendantInstr.Label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.assign.Label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.nilBYMounth.Label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fromdate.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.todate.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.dietOrders.Label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.show.Label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.activeOrders.Label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.closedOrders.Label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.futureOrders.Label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.DietType.Label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Period.label", java.lang.String .class,"key"));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.OrderDateTime.Label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag48(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag48 = null ;
        int __result__tag48 = 0 ;

        if (__tag48 == null ){
            __tag48 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag48);
        }
        __tag48.setPageContext(pageContext);
        __tag48.setParent(null);
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderDate.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag48;
        __result__tag48 = __tag48.doStartTag();

        if (__result__tag48!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag48== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag48.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag48);
            return true;
        }
        _activeTag=__tag48.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag48);
        __tag48.release();
        return false;
    }

    private boolean _jsp__tag49(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag49 = null ;
        int __result__tag49 = 0 ;

        if (__tag49 == null ){
            __tag49 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag49);
        }
        __tag49.setPageContext(pageContext);
        __tag49.setParent(null);
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderedBy.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag49;
        __result__tag49 = __tag49.doStartTag();

        if (__result__tag49!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag49== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag49.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag49);
            return true;
        }
        _activeTag=__tag49.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag49);
        __tag49.release();
        return false;
    }

    private boolean _jsp__tag50(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag50 = null ;
        int __result__tag50 = 0 ;

        if (__tag50 == null ){
            __tag50 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag50);
        }
        __tag50.setPageContext(pageContext);
        __tag50.setParent(null);
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Remarks.Label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag50;
        __result__tag50 = __tag50.doStartTag();

        if (__result__tag50!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag50== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag50.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag50);
            return true;
        }
        _activeTag=__tag50.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag50);
        __tag50.release();
        return false;
    }

    private boolean _jsp__tag51(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag51 = null ;
        int __result__tag51 = 0 ;

        if (__tag51 == null ){
            __tag51 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag51);
        }
        __tag51.setPageContext(pageContext);
        __tag51.setParent(null);
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Period.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag51;
        __result__tag51 = __tag51.doStartTag();

        if (__result__tag51!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag51== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag51.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag51);
            return true;
        }
        _activeTag=__tag51.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag51);
        __tag51.release();
        return false;
    }

    private boolean _jsp__tag52(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag52 = null ;
        int __result__tag52 = 0 ;

        if (__tag52 == null ){
            __tag52 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag52);
        }
        __tag52.setPageContext(pageContext);
        __tag52.setParent(null);
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.MealClass.Label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag52;
        __result__tag52 = __tag52.doStartTag();

        if (__result__tag52!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag52== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag52.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag52);
            return true;
        }
        _activeTag=__tag52.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag52);
        __tag52.release();
        return false;
    }

    private boolean _jsp__tag53(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag53 = null ;
        int __result__tag53 = 0 ;

        if (__tag53 == null ){
            __tag53 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag53);
        }
        __tag53.setPageContext(pageContext);
        __tag53.setParent(null);
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.DietType.Label", java.lang.String .class,"key"));
        __tag53.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag53;
        __result__tag53 = __tag53.doStartTag();

        if (__result__tag53!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag53== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag53.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag53);
            return true;
        }
        _activeTag=__tag53.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag53);
        __tag53.release();
        return false;
    }

    private boolean _jsp__tag54(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag54 = null ;
        int __result__tag54 = 0 ;

        if (__tag54 == null ){
            __tag54 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag54);
        }
        __tag54.setPageContext(pageContext);
        __tag54.setParent(null);
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Add.label", java.lang.String .class,"key"));
        __tag54.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag54;
        __result__tag54 = __tag54.doStartTag();

        if (__result__tag54!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag54== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag54.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag54);
            return true;
        }
        _activeTag=__tag54.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag54);
        __tag54.release();
        return false;
    }

    private boolean _jsp__tag55(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag55 = null ;
        int __result__tag55 = 0 ;

        if (__tag55 == null ){
            __tag55 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag55);
        }
        __tag55.setPageContext(pageContext);
        __tag55.setParent(null);
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.date.Label", java.lang.String .class,"key"));
        __tag55.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag55;
        __result__tag55 = __tag55.doStartTag();

        if (__result__tag55!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag55== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag55.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag55);
            return true;
        }
        _activeTag=__tag55.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag55);
        __tag55.release();
        return false;
    }

    private boolean _jsp__tag56(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag56 = null ;
        int __result__tag56 = 0 ;

        if (__tag56 == null ){
            __tag56 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag56);
        }
        __tag56.setPageContext(pageContext);
        __tag56.setParent(null);
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.dietCycles.Label", java.lang.String .class,"key"));
        __tag56.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag56;
        __result__tag56 = __tag56.doStartTag();

        if (__result__tag56!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag56== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag56.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag56);
            return true;
        }
        _activeTag=__tag56.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag56);
        __tag56.release();
        return false;
    }

    private boolean _jsp__tag57(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag57 = null ;
        int __result__tag57 = 0 ;

        if (__tag57 == null ){
            __tag57 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag57);
        }
        __tag57.setPageContext(pageContext);
        __tag57.setParent(null);
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
        __tag57.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag57;
        __result__tag57 = __tag57.doStartTag();

        if (__result__tag57!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag57== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag57.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag57);
            return true;
        }
        _activeTag=__tag57.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag57);
        __tag57.release();
        return false;
    }

    private boolean _jsp__tag58(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag58 = null ;
        int __result__tag58 = 0 ;

        if (__tag58 == null ){
            __tag58 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag58);
        }
        __tag58.setPageContext(pageContext);
        __tag58.setParent(null);
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Go.label", java.lang.String .class,"key"));
        __tag58.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag58;
        __result__tag58 = __tag58.doStartTag();

        if (__result__tag58!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag58== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag58.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag58);
            return true;
        }
        _activeTag=__tag58.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag58);
        __tag58.release();
        return false;
    }

    private boolean _jsp__tag59(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag59 = null ;
        int __result__tag59 = 0 ;

        if (__tag59 == null ){
            __tag59 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag59);
        }
        __tag59.setPageContext(pageContext);
        __tag59.setParent(null);
        __tag59.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.meals.Label", java.lang.String .class,"key"));
        __tag59.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag59;
        __result__tag59 = __tag59.doStartTag();

        if (__result__tag59!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag59== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag59.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag59);
            return true;
        }
        _activeTag=__tag59.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag59);
        __tag59.release();
        return false;
    }

    private boolean _jsp__tag60(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag60 = null ;
        int __result__tag60 = 0 ;

        if (__tag60 == null ){
            __tag60 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag60);
        }
        __tag60.setPageContext(pageContext);
        __tag60.setParent(null);
        __tag60.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.edit.Label", java.lang.String .class,"key"));
        __tag60.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag60;
        __result__tag60 = __tag60.doStartTag();

        if (__result__tag60!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag60== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag60.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag60);
            return true;
        }
        _activeTag=__tag60.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag60);
        __tag60.release();
        return false;
    }

    private boolean _jsp__tag61(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag61 = null ;
        int __result__tag61 = 0 ;

        if (__tag61 == null ){
            __tag61 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag61);
        }
        __tag61.setPageContext(pageContext);
        __tag61.setParent(null);
        __tag61.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.nutriEntSupp.Label", java.lang.String .class,"key"));
        __tag61.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag61;
        __result__tag61 = __tag61.doStartTag();

        if (__result__tag61!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag61== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag61.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag61);
            return true;
        }
        _activeTag=__tag61.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag61);
        __tag61.release();
        return false;
    }

    private boolean _jsp__tag62(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag62 = null ;
        int __result__tag62 = 0 ;

        if (__tag62 == null ){
            __tag62 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag62);
        }
        __tag62.setPageContext(pageContext);
        __tag62.setParent(null);
        __tag62.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.edit.Label", java.lang.String .class,"key"));
        __tag62.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag62;
        __result__tag62 = __tag62.doStartTag();

        if (__result__tag62!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag62== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag62.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag62);
            return true;
        }
        _activeTag=__tag62.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag62);
        __tag62.release();
        return false;
    }

    private boolean _jsp__tag63(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag63 = null ;
        int __result__tag63 = 0 ;

        if (__tag63 == null ){
            __tag63 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag63);
        }
        __tag63.setPageContext(pageContext);
        __tag63.setParent(null);
        __tag63.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.edit.Label", java.lang.String .class,"key"));
        __tag63.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag63;
        __result__tag63 = __tag63.doStartTag();

        if (__result__tag63!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag63== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag63.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag63);
            return true;
        }
        _activeTag=__tag63.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag63);
        __tag63.release();
        return false;
    }

    private boolean _jsp__tag64(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag64 = null ;
        int __result__tag64 = 0 ;

        if (__tag64 == null ){
            __tag64 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag64);
        }
        __tag64.setPageContext(pageContext);
        __tag64.setParent(null);
        __tag64.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.edit.Label", java.lang.String .class,"key"));
        __tag64.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag64;
        __result__tag64 = __tag64.doStartTag();

        if (__result__tag64!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag64== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag64.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag64);
            return true;
        }
        _activeTag=__tag64.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag64);
        __tag64.release();
        return false;
    }

    private boolean _jsp__tag65(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag65 = null ;
        int __result__tag65 = 0 ;

        if (__tag65 == null ){
            __tag65 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag65);
        }
        __tag65.setPageContext(pageContext);
        __tag65.setParent(null);
        __tag65.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.activeProblems.Label", java.lang.String .class,"key"));
        __tag65.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag65;
        __result__tag65 = __tag65.doStartTag();

        if (__result__tag65!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag65== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag65.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag65);
            return true;
        }
        _activeTag=__tag65.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag65);
        __tag65.release();
        return false;
    }

    private boolean _jsp__tag66(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag66 = null ;
        int __result__tag66 = 0 ;

        if (__tag66 == null ){
            __tag66 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag66);
        }
        __tag66.setPageContext(pageContext);
        __tag66.setParent(null);
        __tag66.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.allergies.Label", java.lang.String .class,"key"));
        __tag66.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag66;
        __result__tag66 = __tag66.doStartTag();

        if (__result__tag66!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag66== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag66.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag66);
            return true;
        }
        _activeTag=__tag66.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag66);
        __tag66.release();
        return false;
    }

    private boolean _jsp__tag67(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag67 = null ;
        int __result__tag67 = 0 ;

        if (__tag67 == null ){
            __tag67 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag67);
        }
        __tag67.setPageContext(pageContext);
        __tag67.setParent(null);
        __tag67.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.edit.Label", java.lang.String .class,"key"));
        __tag67.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag67;
        __result__tag67 = __tag67.doStartTag();

        if (__result__tag67!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag67== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag67.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag67);
            return true;
        }
        _activeTag=__tag67.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag67);
        __tag67.release();
        return false;
    }

    private boolean _jsp__tag68(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag68 = null ;
        int __result__tag68 = 0 ;

        if (__tag68 == null ){
            __tag68 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag68);
        }
        __tag68.setPageContext(pageContext);
        __tag68.setParent(null);
        __tag68.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.meals.Label", java.lang.String .class,"key"));
        __tag68.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag68;
        __result__tag68 = __tag68.doStartTag();

        if (__result__tag68!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag68== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag68.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag68);
            return true;
        }
        _activeTag=__tag68.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag68);
        __tag68.release();
        return false;
    }

    private boolean _jsp__tag69(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag69 = null ;
        int __result__tag69 = 0 ;

        if (__tag69 == null ){
            __tag69 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag69);
        }
        __tag69.setPageContext(pageContext);
        __tag69.setParent(null);
        __tag69.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.nutriEntSupp.Label", java.lang.String .class,"key"));
        __tag69.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag69;
        __result__tag69 = __tag69.doStartTag();

        if (__result__tag69!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag69== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag69.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag69);
            return true;
        }
        _activeTag=__tag69.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag69);
        __tag69.release();
        return false;
    }

    private boolean _jsp__tag70(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag70 = null ;
        int __result__tag70 = 0 ;

        if (__tag70 == null ){
            __tag70 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag70);
        }
        __tag70.setPageContext(pageContext);
        __tag70.setParent(null);
        __tag70.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.SpclFoodItems.Label", java.lang.String .class,"key"));
        __tag70.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag70;
        __result__tag70 = __tag70.doStartTag();

        if (__result__tag70!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag70== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag70.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag70);
            return true;
        }
        _activeTag=__tag70.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag70);
        __tag70.release();
        return false;
    }

    private boolean _jsp__tag71(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag71 = null ;
        int __result__tag71 = 0 ;

        if (__tag71 == null ){
            __tag71 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag71);
        }
        __tag71.setPageContext(pageContext);
        __tag71.setParent(null);
        __tag71.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.foodDislikes.Label", java.lang.String .class,"key"));
        __tag71.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag71;
        __result__tag71 = __tag71.doStartTag();

        if (__result__tag71!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag71== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag71.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag71);
            return true;
        }
        _activeTag=__tag71.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag71);
        __tag71.release();
        return false;
    }

    private boolean _jsp__tag72(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag72 = null ;
        int __result__tag72 = 0 ;

        if (__tag72 == null ){
            __tag72 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag72);
        }
        __tag72.setPageContext(pageContext);
        __tag72.setParent(null);
        __tag72.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
        __tag72.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag72;
        __result__tag72 = __tag72.doStartTag();

        if (__result__tag72!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag72== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag72.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag72);
            return true;
        }
        _activeTag=__tag72.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag72);
        __tag72.release();
        return false;
    }

    private boolean _jsp__tag73(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag73 = null ;
        int __result__tag73 = 0 ;

        if (__tag73 == null ){
            __tag73 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag73);
        }
        __tag73.setPageContext(pageContext);
        __tag73.setParent(null);
        __tag73.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.mealExclusions.Label", java.lang.String .class,"key"));
        __tag73.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag73;
        __result__tag73 = __tag73.doStartTag();

        if (__result__tag73!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag73== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag73.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag73);
            return true;
        }
        _activeTag=__tag73.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag73);
        __tag73.release();
        return false;
    }
}
